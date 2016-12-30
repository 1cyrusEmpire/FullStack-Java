package come.telusko.service;



import java.util.List;


import com.telusko.dao.GadgetDao;
import com.telusko.entity.Gadget;

public class GadgetService 

{
 
	
	public Gadget getGadget(String name)  //return here 53:32 sess 10
	{
	
		//GadgetDao dao = new GadgetDao();
		Gadget obj = new GadgetDao().getGadget(name);
	//	Gadget obj = dao.getGadget(name);
		// Gadget obj = new GadgetDao().getGadget(gd); 
		
		
		return obj;		
		
	}
	public List<Gadget> getGadgets()
	{
		return new GadgetDao().getGadgets();
			
	}
	
	public void addGadget(Gadget g)
	{
		GadgetDao dao = new GadgetDao();
		dao.addGadget(g);
		
		
		
	}
	

}
