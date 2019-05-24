package com.ani.controller;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ani.Daoimpl.CategoryDaoImpl;
import com.ani.Daoimpl.ProductDaoImpl;
import com.ani.Daoimpl.SupplierDaoImpl;
import com.ani.model.Category;
import com.ani.model.Products;
import com.ani.model.Supplier;




@Controller
public class ProductController
{
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
@RequestMapping("/products")

   
   public ModelAndView goToProductForm()
   {
       ModelAndView  mv=new ModelAndView("products");
       Products product=new Products();
       int id=(int)(Math.random()*10000);
       product.setProductID(id);
       
       
       mv.addObject("pro",product);
       List<Supplier> listSupplier = supplierDaoImpl.retrieveAllSupplier();
 	  
  	 
 	  mv.addObject("suplist", listSupplier);
	   
      // mv.addObject("pro",new Products());
       List<Category> listCategory = categoryDaoImpl.retrieveAllCategory();
 	  
  	 
 	  mv.addObject("catlist", listCategory);
       mv.addObject("bname","AddProducts");

       return  mv;
   }

   @RequestMapping(value="/addpro",method=RequestMethod.POST)
   public String recieveProductFormData(@ModelAttribute ("pro") Products pr)
   {
	  MultipartFile multi=pr.getProimage();
	  System.out.println("-------------------------------------"+multi);
	 /* System.out.println(pr.getProductID());
       System.out.println(pr.getProductName());
       System.out.println(pr. getProductDescription());
       System.out.println(pr. getProductCategory());
       System.out.println(pr. getProductSupplier());*/
   try {
	  byte b[]=multi.getBytes(); 
	FileOutputStream fos= new FileOutputStream("D:\\proj12\\Category\\src\\main\\webapp\\resources\\images\\"+pr.getProductID()+".jpg");
	BufferedOutputStream bos= new BufferedOutputStream(fos);
	bos.write(b);
	bos.close();
	
	
	
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   
       productDaoImpl.saveProduct(pr);
       return "home";
      
   }
   @RequestMapping("showpro")
   public ModelAndView retrieveProduct ()
   {
	   ModelAndView modelandview=new ModelAndView("showproducts");
	   List<Products> listProduct = productDaoImpl.retrieveAllProduct();
	   
	   List<Supplier> listSupplier = supplierDaoImpl.retrieveAllSupplier();
	 	  
	  	 
	 	  modelandview.addObject("suplist", listSupplier);
	  	 
	 
	  modelandview.addObject("prolist", listProduct);
	   return modelandview;
   }
   @RequestMapping("/delet")
   public ModelAndView deleteproduct(@RequestParam("proid")int productid)
   {
	   System.out.println("Product Id="+productid);
	   
	   productDaoImpl.DeleteProduct(productid);
	   ModelAndView modelandview=new ModelAndView("showproducts");
	   List<Products> listProduct = productDaoImpl.retrieveAllProduct();
	  
	 
	  modelandview.addObject("prolist", listProduct);
	   return modelandview;
}
   @RequestMapping("/ed")
   public ModelAndView editproduct(@RequestParam("proid")int productid)
   {
	   System.out.println("Product Id="+productid);
	   Products product=productDaoImpl.getProduct(productid);
	 
	   ModelAndView modelandview=new ModelAndView("products");
	   List<Category> listCategory = categoryDaoImpl.retrieveAllCategory();
	   List<Supplier> listSupplier = supplierDaoImpl.retrieveAllSupplier();
	 	  
	  	 
	 	  modelandview.addObject("suplist", listSupplier);
	  	 
	 	  modelandview.addObject("catlist", listCategory);
	  modelandview.addObject("pro",product);
	  modelandview.addObject("bname","UpdateProduct");
	   return modelandview;
   }
}