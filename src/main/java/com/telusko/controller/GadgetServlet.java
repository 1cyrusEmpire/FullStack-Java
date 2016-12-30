package com.telusko.controller;


import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telusko.entity.Gadget;

import come.telusko.service.GadgetService;

@WebServlet("/getGadget")
public class GadgetServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

               int id = Integer.parseInt(request.getParameter("t1"));
               String name = request.getParameter("t2");
              int price = Integer.parseInt(request.getParameter("t3"));
              
              Gadget gd = new Gadget(); 
              gd.setgId(id);
              gd.setGname(name);
              gd.setPrice(price);
               GadgetService gs = new GadgetService();
               
               
               
               gs.addGadget(gd);
               
               List<Gadget> gadgets = gs.getGadgets();
               //Gadget g = gs.getGadget(name);

               
               PrintWriter out = response.getWriter();
               response.setContentType("html");
               // out.print(g.getgId()  +"   "+ g.getGname() + "  :  " + g.getPrice());
               	
               for(Gadget g : gadgets){
            	   out.print(g.getgId()  +"   "+ g.getGname() + "  :  " + g.getPrice() + "</br>");
               }
   }		
}