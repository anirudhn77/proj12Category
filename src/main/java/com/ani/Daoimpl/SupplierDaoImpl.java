package com.ani.Daoimpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.ani.model.Supplier;
;

@Component
public class SupplierDaoImpl
{
@Autowired
SessionFactory factory;

public void saveSupplier(Supplier supplier)
{
	 Session session=factory.openSession();
	if(supplier.getSupplierId()==0)
	{
    int id=(int)(Math.random()*10000);
   	supplier.setSupplierId(id);
	}
    session.saveOrUpdate(supplier);
    Transaction transaction=session.beginTransaction();
    transaction.commit();
    session.close();
	
}
public List<Supplier> retrieveAllSupplier()
{
	 Session session=factory.openSession();
	 Query query=session.createQuery("from  com.ani.model.Supplier");
	 List<Supplier> listSupplier=query.list();
	 for(Supplier sup:listSupplier)
	 {
		Supplier supplier=sup;
		System.out.println("id = "+ supplier.getSupplierId());
		System.out.println("Name = "+ supplier.getSupplierName());
		System.out.println("Description = "+ supplier.getSupplierDescription());
	 }
	 session.close();
	 return listSupplier;
	}
public Supplier getSupplier(int supplierid)
{
	Session session=factory.openSession();
	Supplier supplier=session.get(Supplier.class,supplierid);
	session.close();
	return supplier;
	}
public void DeleteSupplier(int supplierid)
{ 
   System.out.println("Supplier Id="+supplierid);
  
	Session session=factory.openSession();
	Supplier supplier=getSupplier(supplierid);
	session.delete(supplier);
	Transaction transaction=session.beginTransaction();
    transaction.commit();
    session.close();
	
	}
public void EditSupplier(int supplierid)
{ 
   System.out.println("Supplier Id="+supplierid);
  
	Session session=factory.openSession();
	Supplier supplier=getSupplier(supplierid);
	session.close();
	
	
    
}
}