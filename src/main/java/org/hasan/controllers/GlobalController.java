package org.hasan.controllers;

import org.hasan.models.Userinfo;
import org.hasan.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // controller annotation says that this class is a controller
public class GlobalController 
{
	@Autowired // get the object of service class 
	UserService service;

	// if the client request comes for the '/'
	@RequestMapping(value="/")
	public String showWelcomeScreen()
	{
		// redirect to url 'register'
		return "redirect:register";
	}
	
	// if the client request comes for the 'register'
	@RequestMapping(value="register")
	public Userinfo showRegisterForm()
	{
		// create blank object of UserInfo and map to the register.jsp
		return new Userinfo();
	}
	
	// if the client request comes for the 'do-register'
	@RequestMapping(value="do-register",method=RequestMethod.POST,
			produces="text/html")
	@ResponseBody // return string as a response
	public String getRegisterData(Userinfo userinfo)
	{
		return "<i>"+service.saveData(userinfo)+" record inserted inside database</i>";
	}

	// if the client request comes for the 'about-us'
	@RequestMapping(value="about-us")
	public String showAboutUsPage()
	{
		// redirect the request to html file 
		return "redirect:webpages/about-us.html";
	}
	
	// if the client request comes for the 'show-users'
	@RequestMapping(value="/show-users")
	public String showUserDetails(Model m)
	{
		m.addAttribute("users", service.getUserInfoList());
		return "show-users";
	}

	// if the client request comes for the 'update-user'
	@RequestMapping(value="/update-user",method=RequestMethod.GET)
	public Userinfo updateUserDetails(@RequestParam("email")String email, Model model)
	{
		Userinfo userinfo = service.getUserInfoByEmail(email);
		model.addAttribute("data", userinfo);
		return userinfo;
	}

	// if the client request comes for the 'delete-user'
	@RequestMapping(value="/delete-user", method=RequestMethod.GET, produces="text/html")
	@ResponseBody
	public String deleteUserDetails(@RequestParam("email")String email)
	{
		service.deleteUserByEmail(email);
		return "<script>"
				+ "alert('user deleted');"
				+ "window.location = './'"
				+ "</script>";
	}

	// if the client request comes for the 'update-user-data'
	@RequestMapping(value="/update-user-data",method=RequestMethod.POST)
	@ResponseBody // return the string in response
	public String processUpdateUserDetails(Userinfo userinfo)
	{
		String str = "<i>user updated</i>"
				+ " <a href='./'>click here</a>";
		service.updateUser(userinfo);
		return str;
	}
}