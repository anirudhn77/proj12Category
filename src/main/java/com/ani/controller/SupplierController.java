package com.ani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.ani.Daoimpl.SupplierDaoImpl;

import com.ani.model.Supplier;


@Controller
public class SupplierController
{
	
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
@RequestMapping("/supplier")

   
   public ModelAndView goToSupplierForm()
   {
       ModelAndView  mv=new ModelAndView("supplier");

       mv.addObject("sup",new Supplier());
       mv.addObject("bname","AddSupplier");

       return  mv;
   }

   @RequestMapping(value="/addsup",method=RequestMethod.POST)
   public String recieveCategoryFormData(@ModelAttribute ("sup") Supplier sa)
   {
	   System.out.println(sa.getSupplierId());
       System.out.println(sa.getSupplierName());
       System.out.println(sa.getSupplierDescription());
       System.out.println(sa.getSupplierAddress());
       
       supplierDaoImpl.saveSupplier(sa);       
       
       return "home";
      
   }
   @RequestMapping("showsup")
   public ModelAndView retrieveSupplier()
   {
	   ModelAndView modelandview=new ModelAndView("showsupplier");
	   List<Supplier> listSupplier = supplierDaoImpl.retrieveAllSupplier();
	  
	 
	  modelandview.addObject("suplist", listSupplier);
	   return modelandview;
   }
   @RequestMapping("/dele")
   public ModelAndView deletesupplier(@RequestParam("supid")int supplierid)
   {
	   System.out.println("Supplier Id="+supplierid);
	   
	   supplierDaoImpl.DeleteSupplier(supplierid);
	   ModelAndView modelandview=new ModelAndView("showsupplier");
	   List<Supplier> listSupplier = supplierDaoImpl.retrieveAllSupplier();
	  
	 
	  modelandview.addObject("suplist", listSupplier);
	   return modelandview;
}
   @RequestMapping("/edt")
   public ModelAndView editsupplier(@RequestParam("supid")int supplierid)
   {
	   System.out.println("Supplier Id="+supplierid);
	   Supplier supplier=supplierDaoImpl.getSupplier(supplierid);
	 
	   ModelAndView modelandview=new ModelAndView("supplier");
	   
	  modelandview.addObject("sup",supplier);
	  modelandview.addObject("bname","UpdateCategory");
	   return modelandview;
   }
}