package com.inc.beans;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inc.mapping.Employee;

@Controller
public class ValidationImpl implements IValidation{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@RequestMapping(value="/commonLogin.go")
	public String validation()
	{
		String page="";
		if(isEmployeesExist())
			page="login";
		else
			page="registration";
		return page;
	}
	@RequestMapping(value="/addEmployee.go",method=RequestMethod.POST)
	public String addEmployee(HttpServletRequest request,Model model)
	{
		String page="";
		Transaction tx = null;
		Session session=null;
		try 
		{
			Employee e=new Employee();
			e.setFirstName(request.getParameter("firstName"));
			e.setLastName(request.getParameter("lastName"));
			e.setEmailId(request.getParameter("emailId"));
			e.setPassword(request.getParameter("password"));
			if(!isEmployeesExist())
			e.setRoleId(1);
			else
			e.setRoleId(2);
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			session.save(e);
			tx.commit();
			page="login";
		}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return page;
	}
	@RequestMapping(value="/loginValidation.go",method=RequestMethod.POST)
	public String loginValidation(HttpServletRequest request,Model model)
	{
		String page="";
		Session session=null;
		try 
		{
			System.out.println(request.getParameter("emailId")+"--"+request.getParameter("password"));
			session=sessionFactory.openSession();
			Query q=session.getNamedQuery("loginValidation").setString("emailId",""+request.getParameter("emailId")).setString("password",""+request.getParameter("password"));
			if(q.list().size()>0)
			{
				Query q1=session.createQuery("from Employee");
				List<Employee> eList=q1.list();
				request.setAttribute("userName", eList.get(0).getFirstName());
				if(eList.get(0).getRoleId()==1)
				{
				request.setAttribute("eList", eList);
				page="employeeList";
				}
				else
				{
					page="employeeList";
				}
			}
			else
			{
				page="login";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return page;
	}
	@RequestMapping(value="/login.go",method=RequestMethod.GET)
	public String goToLoginPage()
	{
		return "login";
	}
	@RequestMapping(value="/register.go",method=RequestMethod.GET)
	public String goToRegistrationPage()
	{
		return "registration";
	}
	public boolean isEmployeesExist()
	{
		boolean flag=false;
		Session session=null;
		try 
		{
			session=sessionFactory.openSession();
			Query q=session.createQuery("from Employee");
			List<Employee> eList=q.list();
			if(eList.size()>0)
			{
				flag=true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return flag;
	}
}
