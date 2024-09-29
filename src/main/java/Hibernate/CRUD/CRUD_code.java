package Hibernate.CRUD;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CRUD_code {

	public static void insert() {

		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		Scanner s = new Scanner(System.in);

		Configuration confi = new Configuration();
		confi.configure("Hibernate.confi.xml");

		SessionFactory sessionFactory = confi.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// (id,name,email,password,gender,city)
		System.out.println("Enter  Id");
		int id = s.nextInt();

		System.out.println("Entet  Name");
		String name = s.next();

		System.out.println("Enter Email Id");
		String email = s.next();

		System.out.println("Enter Password");
		String password = s.next();

		System.out.println("Enter gender");
		String gender = s.next();

		System.out.println("Enter City");
		String city = s.next();

		User user = new User(id, name, email, password, gender, city);

		// ------------- insert operation----------------
		try {
			session.save(user);
			transaction.commit();
//		   session.close();
//		   sessionFactory.close();
			System.out.println("Data Inserted Successfully.....");

		} catch (Exception e) {
			e.getMessage();
//			transaction.rollback();
			System.out.println("Something Wrong...Data NOT Inserted..");
			System.out.println(e.getStackTrace());
		}

	}

	public static void update() {

		Scanner s = new Scanner(System.in);

		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		Configuration confi = new Configuration();
		confi.configure("Hibernate.confi.xml");

		SessionFactory sessionFactory = confi.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter Old Id");
		int id = s.nextInt();

		System.out.println("Entet  Name");
		String name = s.next();

		System.out.println("Enter Email Id");
		String email = s.next();

		System.out.println("Enter Password");
		String password = s.next();

		System.out.println("Enter gender");
		String gender = s.next();

		System.out.println("Enter City");
		String city = s.next();

		try {
			User bhu = session.get(User.class, id);
			// set the value that updated..
			bhu.setName(name);
			bhu.setEmail(email);
			bhu.setPassword(password);
			bhu.setGender(gender);
			bhu.setCity(city);

			session.saveOrUpdate(bhu);
			transaction.commit();
			session.close();
			sessionFactory.close();
			System.out.println("Data Updated Successfully...");
		} catch (Exception e) {
//			transaction.rollback();
			System.out.println("Something Wrong...Data NOT Upadated....");
			System.out.println(e.getStackTrace());
		}
	}

	public static void read() {

		Scanner s = new Scanner(System.in);

		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		Configuration confi = new Configuration();
		confi.configure("Hibernate.confi.xml");

		SessionFactory sessionFactory = confi.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter Id from Read Data....");
		int id = s.nextInt();
		try {

			User result = session.get(User.class, id);
			if (result != null) {
				System.out.println(result);
			} else {
				System.out.println("Something Wrong..please check ID....");
			}

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

	public static void delete() {

		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		Scanner s = new Scanner(System.in);

		Configuration confi = new Configuration();
		confi.configure("Hibernate.confi.xml");

		SessionFactory sessionFactory = confi.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter Id From Delete Entry...");
		int id = s.nextInt();

		User user = session.get(User.class, id);

		try {

			session.delete(user);
			transaction.commit();
			System.out.println("successfully Data Deleted......");

		} catch (Exception e) {
			System.out.println("Something Wrong...Data NOT Deleted....");
			transaction.rollback();
			System.out.println(e.getStackTrace());

		}

	}

	public static void viewAll() {

		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		
		Configuration confi = new Configuration();
		confi.configure("Hibernate.confi.xml");

		SessionFactory sessionFactory = confi.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

//		Criteria cr = session.createCriteria(User.class);
//
//		List<User> list = cr.list();
//
//		for (User u : list) {
//			System.out.println(u);
//
//		}

		Query query = session.createQuery("from User");

		List<User> list = query.list();

		for (User us : list) {
			System.out.println(us);
		}


	}

	public static void Exits() {

		System.out.println("Thank You Using CRUD Oparetions....");

	}

}
