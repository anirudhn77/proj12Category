   package com.ani.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ani.Daoimpl.CartDaoImp;
import com.ani.Daoimpl.ProductDaoImpl;
import com.ani.model.Cart;
import com.ani.model.Category;
import com.ani.model.Products;

@Controller
public class CartController {
	

	@Autowired
	ProductDaoImpl productDaoImpl;
	
@Autowired
CartDaoImp cartDaoimp;
	@RequestMapping("/addtocart")
	public ModelAndView SaveCartData(HttpServletRequest request)
	   {
		int x=Integer.parseInt(request.getParameter("p"));
		int y=Integer.parseInt(request.getParameter("q"));
        System.out.println(x);
        System.out.println(y);
        
        
		
			
		//testing productid
		  // System.out.println("Product Id="+productid);
		  ///getting enire product data
		   Products product=productDaoImpl.getProduct(x);
	       
		   Cart cart=cartDaoimp.setCart(product,y);
		   System.out.println("sssssssssssss"+cart.getCartdId());
		   List<Cart> cartlist=cartDaoimp.retrieveCartData();
		 cartDaoimp.savecartdetails(cart);
		 ModelAndView modelandview=new ModelAndView("Displaydetails");
		 modelandview.addObject("cartlist",cartlist);
		   return modelandview;
	   }
}