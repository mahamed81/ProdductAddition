package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Product;
import com.utility.HibernateUtility;

/**
 * Servlet implementation class productIdServlet
 */
@WebServlet("/productIdServlet")
public class productIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String prodName = request.getParameter("prodName");
		String prodPrice = request.getParameter("prodPrice");

		Product prod = new Product(prodName, Double.parseDouble(prodPrice));

		AddProduct add = new AddProduct();

		if (add.Add(prod)>0) {
//			out.println("Successfully added : " + " Product name: " + prodName + " :Price : " + prodPrice);
			out.print("Successfully added : " + prodName + ": $" + prodPrice);
			
		} else {
			out.println("Fail to add product!");
		}

	}

}
