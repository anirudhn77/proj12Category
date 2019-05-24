package com.ani.Daoimpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.model.Products;
;

@Component
public class ProductDaoImpl
{
@Autowired
SessionFactory factory;

public void saveProduct(Products product)
{
	 Session session=factory.openSession();
	//if(product.getProductID()==0)
	//{
    //int id=(int)(Math.random()*10000);
    //product.setProductID(id);
	//}
    session.saveOrUpdate(product);
    Transaction transaction=session.beginTransaction();
    transaction.commit();
    session.close();
	
}
public List<Products> retrieveAllProduct()
{
	 Session session=factory.openSession();
	 Query query=session.createQuery("from  com.ani.model.Products");
	 @SuppressWarnings("unchecked")
	List<Products> listProduct=query.list();
	 for(Products pro:listProduct)
	 {
		 Products product=pro;
		System.out.println("id = "+ product.getProductID());
		System.out.println("Name = "+ product.getProductName());
		System.out.println("Description = "+ product.getProductDescription());
		System.out.println("Price = "+ product.getProductPrice());
		System.out.println("Category = "+ product.getProductCategory());
		System.out.println("supplier = "+ product.getProductSupplier());
		System.out.println("supplier = "+ product.getProductSupplier());
	 }
	 session.close();
	 return listProduct;
	}
public Products getProduct(int productid)
{
	Session session=factory.openSession();
	Products product=session.get(Products.class,productid);
	session.close();
	return product;
	
	}
public void DeleteProduct(int productid)
{ 
   System.out.println("Product Id="+productid);
  
	Session session=factory.openSession();
	Products product=getProduct(productid);
	session.delete(product);
	Transaction transaction=session.beginTransaction();
    transaction.commit();
    session.close();
	
	}
public void EditProduct(int productid)
{ 
   System.out.println("Product Id="+productid);
  
	Session session=factory.openSession();
	@SuppressWarnings("unused")
	Products product=getProduct(productid);
	session.close();
	
	
    
}
}