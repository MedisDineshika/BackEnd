package com.example.userMgtService.dao;

import org.hibernate.SessionFactory;
//import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.userMgtService.model.Reg;

import java.util.List;

//import javax.transaction.Transaction;

import org.hibernate.Query;
//import org.hibernate.SQLQuery;
import org.hibernate.Session;



@Repository
public class RegDaoImpl implements RegDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	//Checking user entered login details with the data base  
	@Override
	public Reg checkLogin(String userName, String password) {
		
			//sessionFactory.openSession();
			Session session = sessionFactory.openSession();
	    
	    	//Query using Hibernate Query Language
			Reg reg =null;
	    	try {
	    	
			    	String SQL_QUERY ="from Reg as r where r.userName= :userName and r.password = :password";
			    	Query query =session.createQuery(SQL_QUERY);
			    	
			    	query.setParameter("userName",userName);
			    	 
			    	query.setParameter("password",password);
			    	 
			    	reg=(Reg)query.uniqueResult(); 
			
	    		}
	    	catch(Exception e){
	    		   e.printStackTrace();
	    		}
			return reg;
	}

	@Override
	public void save(Reg reg) {
		//String password=DigestUtils.md5Hex(reg.getPassword());
		
		sessionFactory.getCurrentSession().save(reg);
		
	}

	//@Override
	//public void save(Reg reg) {
		
		//sessionFactory.getCurrentSession().save(reg);
		
	//}

	@Override
	public Reg findByID(int id) {
		sessionFactory.getCurrentSession().getClass();
		return (Reg) getReg(id) ;
	
	}

	private Reg getReg(int id) {
		return(Reg)sessionFactory.getCurrentSession().get(Reg.class,id);
	}

	@Override
	public Reg checkUser(String userName) {
		// TODO Auto-generated method stub
					//sessionFactory.openSession();
					Session session = sessionFactory.openSession();
			    
			    	//Query using Hibernate Query Language
					Reg reg =null;
			    	try {
			    	
			    		
			    		
			    		String SQL_QUERY ="from Reg as r where r.userName= :userName";
			    	Query query =session.createQuery(SQL_QUERY);
			    	//System.out.println(userName);
			    	
			    	 query.setParameter("userName",userName);
			    	 
			    	 
			    	 
			    	reg=(Reg)query.uniqueResult(); 
			    	
					
				}
			    	catch(Exception e){
			    		   e.printStackTrace();
			    		}
					return reg;
					

	}
	
	
	//@Override
	//public  void save(RoleType roleType) {
		//String password=DigestUtils.md5Hex(reg.getPassword());
		
		//sessionFactory.getCurrentSession().save(roleType);
		
	//}

	

	@Override
	public void update(Reg reg) {
	

		

		
		
		
		Session session = sessionFactory.getCurrentSession();
	//	Reg reg2 =null ;
		 
		
		
			
		
	try {
    	
		String SQL_QUERY = "UPDATE Reg as r SET r.userName = :userName , r.password=:password , r.gender =:gender , r.firstName =:firstName , r.lastName =:lastName  WHERE r.id = :id";
		
		
	Query query =session.createQuery(SQL_QUERY);
	
	((Reg) query).setPassword(reg.getPassword());
	((Reg) query).setUserName(reg.getUserName());
	((Reg) query).setGender(reg.getGender());
	//((Reg) query).setDOB(reg.getDOB());
	((Reg) query).setLastName(reg.getLastName());
	((Reg) query).setFirstName(reg.getFirstName());
	
	
	 
	 //reg2=(Reg)query.uniqueResult(); 
	
	
}
	catch(Exception e){
		  e.printStackTrace();
		}
 sessionFactory.getCurrentSession().merge(reg);		

	 
	 
}

	
	//@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	@Override
	public List<Reg> getAllUnRegUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<Reg> result2= null;
		try {
			Query query = session.createQuery("userName from Reg as r where r.role_Type IS NULL");
			
			
			
			 result2 = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result2;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reg> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Reg> result3= null;
		try {
			Query query = session.createQuery("from Reg");
			
			
			
			result3 = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result3;
		
		
		

	}

	@SuppressWarnings("unused")
	@Override
	public void delete(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("DELETE FROM Reg WHERE id= :id");
		
		
	}

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
				
	}
	
	
	
	
	
	
	
	

