package com.ani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ani.Daoimpl.CategoryDaoImpl;

import com.ani.model.Category;

@Controller
public class CategoryController
{

	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
//@RequestMapping("/category")
   @RequestMapping(value="/Category", method=RequestMethod.GET)
   public ModelAndView goToCategoryForm()
   {
       ModelAndView  mv=new ModelAndView("category");

       mv.addObject("cat",new Category());
       mv.addObject("bname","AddCategory");

       return  mv;
   }

   @RequestMapping(value="/addCat",method=RequestMethod.POST)
   public String recieveCategoryFormData(@ModelAttribute ("cat") Category ca)
   {
	   System.out.println(ca.getCategoryId());
       System.out.println(ca.getCategoryName());
       System.out.println(ca.getCategoryDiscription());
       
       categoryDaoImpl.saveCategory(ca);       
       
       return "home";
      
   }
   @RequestMapping("showcat")
   public ModelAndView retrieveCategory()
   {
	   ModelAndView modelandview=new ModelAndView("showcategory");
	   List<Category> listCategory = categoryDaoImpl.retrieveAllCategory();
	  
	 
	  modelandview.addObject("catlist", listCategory);
	   return modelandview;
   }
   @RequestMapping("/del")
   public ModelAndView deletecategory(@RequestParam("catid")int categoryid)
   {
	   System.out.println("Category Id="+categoryid);
	  Category category=categoryDaoImpl.getCategory(categoryid);
	   categoryDaoImpl.DeleteCategory(category);
	   ModelAndView modelandview=new ModelAndView("showcategory");
	   List<Category> listCategory = categoryDaoImpl.retrieveAllCategory();
	  
	 
	  modelandview.addObject("catlist", listCategory);
	   return modelandview;
}
   @RequestMapping("/edit")
   public ModelAndView editcategory(@RequestParam("catid")int categoryid)
   {
	   System.out.println("Category Id="+categoryid);
	   Category category=categoryDaoImpl.getCategory(categoryid);
	 
	   ModelAndView modelandview=new ModelAndView("category");
	   
	  modelandview.addObject("cat",category);
	  modelandview.addObject("bname","UpdateCategory");
	   return modelandview;
   }
}