package com.ani.Daoimpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.model.Category;

@Component
public class CategoryDaoImpl
{
@Autowired
SessionFactory factory;

public void saveCategory(Category category)
{
	 Session session=factory.openSession();
	if(category.getCategoryId()==0)
	{
    int id=(int)(Math.random()*10000);
   	category.setCategoryId(id);
	}
    session.saveOrUpdate(category);
    Transaction transaction=session.beginTransaction();
    transaction.commit();
    session.close();
	
}
public List<Category> retrieveAllCategory()
{
	 Session session=factory.openSession();
	 Query query=session.createQuery("from  com.ani.model.Category");
	 List<Category> listCategory=query.list();
	/* for(Category cat:listCategory)
	 {
		Category category=cat;
		System.out.println("Categoryid = "+ category.getCategoryId());
		System.out.println("CategoryName = "+ category.getCategoryName());
		System.out.println("CategoryDescription = "+ category.getCategoryDiscription());
	 }*/session.close();
	 return listCategory;
	}
public Category getCategory(int categoryid)
{
	Session session=factory.openSession();
	Category category=session.get(Category.class,categoryid);
	session.close();
	return category;
	}
public void DeleteCategory(Category category)
{ 
   System.out.println("Category Id="+category);
  
	Session session=factory.openSession();
	//Category category=getCategory(categoryid);
	session.delete(category);
	Transaction transaction=session.beginTransaction();
    transaction.commit();
    session.close();
	
	}
public void EditCategory(Category category)
{ 
   System.out.println("Category Id="+category);
  
	Session session=factory.openSession();
	//Category category=getCategory(categoryid);
	session.close();
	
    
}
}