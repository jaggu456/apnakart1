package com.apnakart.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apnakart.model.User;
import com.apnakart.repo.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserControler 
{

	@Autowired
	UserRepository urepo;
	
	@RequestMapping("/")
	public String home() 
	{
		return "home";
	}
	
	@RequestMapping("/signup")
	public String getSignup()
	{
		return "signup";
	}
	
	@RequestMapping("/login")
	public String getLogin()
	{
		return "login";
	}
	
	public ModelAndView addUser(@RequestParam("user_email")String user_email,User user)
	{
		ModelAndView mv= new ModelAndView("success");
		List<User>list=urepo.findByEMAIL(user_email);
		if(list.size()!=0)
		{
			mv.addObject("message","Oops! There is already a user registered with the email provided.");
		}
		else
		{
			urepo.save(user);
			mv.addObject("message","User has been successfully registerd.");
		}
		return mv;
	}
	@GetMapping("/dummy")
	public String dummy()
	{
		return "dummy";
	}
	
	public String login_user(@RequestParam("user_name")String user_name,@RequestParam("password")String password,HttpSession session,ModelMap modelMap)
	{
		User auser=urepo.findByUsernamePassword(user_name, password);
		if(auser!=null)
		{
			String uname=auser.getUser_email();
			String upass=auser.getPassword();
			if(user_name.equalsIgnoreCase(uname)&& password.equalsIgnoreCase(upass))
			{
				session.setAttribute("user_name", user_name);
				return "dummy";
			}
			else 
			{
				modelMap.put("error", "invalid Account");
				return "login";
			}
		}
			else
			{
				modelMap.put("error","invalid Account");
				return "login";
			}
	}
	
	@GetMapping(value ="/logout")
	public String logout_user(HttpSession session)
	{
		session.removeAttribute("user_name");
		session.invalidate();
		return "redirect:/login";
	}
	
	
		
	}
	

