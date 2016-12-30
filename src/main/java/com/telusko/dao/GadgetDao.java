package com.telusko.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;
import com.telusko.entity.Gadget;

public class GadgetDao

{

	Connection con = null;
	public GadgetDao()
	{
	try{
		Class.forName("com.mysql.jdbc.Driver");  //step 1-2
		
	   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mario3", "root", "Linkinpark12$");  // step 3
	  // con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=rootpassword");
	   
	   
	   if(con != null)
	   {
		System.out.println("Connection Sucessful");   
	   }
	}
	
	catch(Exception e){
		
		System.out.print("No Connection    ");//I did this to see in fact this returns in console and it does. 
		e.printStackTrace();
	}
	
	}
	
	 		public Gadget getGadget(String name){ //come back here again shows at 45:00 roughly at sess 10
	 			
	 			String sql = "Select * from gadgets where gname='" + name + "'";
	 			Gadget g = new Gadget();
	 			
	 			
	 			try{
	 				
	 				
	 				Statement st = (Statement) con.createStatement();    //prepare the statement  4
	 				ResultSet rs = st.executeQuery(sql);    //step 5
	 				rs.next();
	 				
	 					int gid = rs.getInt(1);
	 					String gname = rs.getString(2);
	 					int price = rs.getInt(3);
	 					
	 					g.setgId(gid);
	 					g.setGname(gname);
	 					g.setPrice(price);
	 			
	 			}
	 			
	 			catch(Exception e){
	 				System.out.println("error"+ e);
	 				
	 			}
	 			return g; 
	 		}
	 		
	 		public List<Gadget> getGadgets(){
	 			//Gadget obj = new GadgetDao().getGadget(name);		
	 			//return obj;
	 			//return new GadgetDao().getGadgets();	
	 			
	 			List<Gadget> gadgets = new ArrayList<>();
	 			Gadget g = new Gadget();
	 									
	 			String sql = "Select * from gadgets";
	 			try{
	 				Statement st = (Statement) con.createStatement();    //prepare the statement  4
	 				ResultSet rs = st.executeQuery(sql); 
	 				while(rs.next())
	 				{
	 					g = new Gadget();
	 				g.setgId(rs.getInt(1));
	 				g.setGname(rs.getString(2));
	 				g.setPrice(rs.getInt(3));
	 				
	 				gadgets.add(g);
	 		
	 				}
           
	 			}
	 			catch(Exception e){
	 				System.out.println(e);
	 			}
	 				
	 			return gadgets;
	 		}
	 		
	 		public void addGadget(Gadget g)
	 		{
	 			
	 			//String sql = "insert into gadgets values (" + g.getgId() +",'" + g.getGname()+ "'," + g.getPrice() +")";
	 			//As you can see the above code convention is harder and gets even more harder from there, so we use following.
	 			String sql = "insert into gadgets values (?,?,?)";
	 			try
	 			{
	 				//Statement st = con.createStatement();
	 				PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
	 				st.setInt(1, g.getgId());
	 				st.setString(2, g.getGname());
	 				st.setInt(3, g.getPrice());        // here we are setting the questions marks on line 107
	 				st.executeUpdate(); 
	 				
	 			}
	 			catch(Exception e) 
	 			{
	 				System.out.println(e +"here");
	 			}
	 		}
	 		
	 	}


