package com.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Product;
import com.utility.HibernateUtility;

public class AddProduct {

	// adds the product object to the database

	public int Add(Product prod) {
		Session session = HibernateUtility.getSession();
		Transaction tx = session.beginTransaction();

		int status = 0;
		try {

			prod.getProductName();
			prod.getProductPrice();
			session.save(prod);
			tx.commit();
			status++;

		} catch (Exception e) {

		}
		return status;
	}

}
