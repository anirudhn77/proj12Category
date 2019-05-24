package com.ani.Daoimpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.model.Cart;
import com.ani.model.User;
@Component
public class UserDaoImp {
    @Autowired
    SessionFactory sessionfactory;
    public void Adduser(User user)
    {
        Session session=sessionfactory.openSession();
        user.setRole("USER_ROLE");
        user.setEnabled(true);
        session.save(user);
        Transaction transaction=session.beginTransaction();
        transaction.commit();
    
    }
    public List<User> retrieveUserData()
    {
    	Session session=sessionfactory.openSession();
    	Query query=session.createQuery("from User");
    	
    	List<User> userlist=query.list();
    	
    	return userlist;
    	}
    
    
    
    //-------------------------------------------------------------------------------
    //LoginDaoImpl
   
   
    	public boolean CheckLogin(User user)
    	{
    		   Session session=sessionfactory.openSession();
    		   Query query=session.createQuery("from User where email=:em and password=:pw");
    		   query.setParameter("em",user.getEmail());
    		   query.setParameter("pw",user.getPassword());
    		   User user2=(User)query.uniqueResult();
    		   
    		   if(user2==null) 
    		   {
    			   return false;
    		   }
    		   else
    		   {
    			   return true;
    		   }
    	}

    
    
    }
