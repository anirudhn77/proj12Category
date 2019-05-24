
package com.ani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ani.Daoimpl.UserDaoImp;
import com.ani.model.Cart;
import com.ani.model.User;

@Controller
public class UserController {
    @Autowired
    UserDaoImp userdao;
    @RequestMapping("/register")
    public ModelAndView registerform()
    {
        User user=new User();
        ModelAndView mv=new ModelAndView("userRegisterPage");
        mv.addObject("registerform",user);
        return mv;
    }
@RequestMapping("/receiveform")
    public ModelAndView receiveregisterform(@ModelAttribute("registerform")User user)
    {
	
    userdao.Adduser(user);
    List<User> usertlist=userdao.retrieveUserData();
        ModelAndView mv=new ModelAndView("displayuserform");
        mv.addObject("userlist",usertlist);
        return mv;
    }    

//---------------------------------------------------------------------------
//       LoginController


@RequestMapping("/loginpage")
public ModelAndView gotoLoginform()
{
    User user=new User();
    ModelAndView mv=new ModelAndView("LoginPage");
    mv.addObject("loginform",user);
    return mv;
}
@RequestMapping("/login")
public ModelAndView LoginPage(@ModelAttribute("loginform")User user)
{
  boolean result=userdao.CheckLogin(user);
 if(result==true)
 {
	 ModelAndView modelAndView=new ModelAndView("LoginSuccessful");
	 return modelAndView;
 }else
 {
	 ModelAndView modelAndView=new ModelAndView("LoginPage");
	 modelAndView.addObject("Wronguser","wrongusername/password");
	 return modelAndView;
	 
 }

    
}


}