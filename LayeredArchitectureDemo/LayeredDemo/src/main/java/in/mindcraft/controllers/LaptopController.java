package in.mindcraft.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import in.mindcraft.dao.LaptopDao;
import in.mindcraft.pojos.Laptop;

@Controller
public class LaptopController {
	private LaptopDao laptopdao = new LaptopDao();
   @RequestMapping("/add")
	public void addLaptop(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
		int lid = Integer.parseInt(request.getParameter("lid"));
		String make = request.getParameter("make");
		double cost = Integer.parseInt(request.getParameter("cost"));
		Laptop laptop = new Laptop(lid,make,cost);
		laptopdao.addLaptop(laptop);
		
		HttpSession session1 = request.getSession();
		session1.setAttribute("lid", lid);
		session1.setAttribute("make", make);
		session1.setAttribute("cost", cost);
		response.sendRedirect("created.jsp");
		response.getWriter().println("Record Inserted Sucessfully");
		
		
	}
   @RequestMapping("/show")
   public String showLaptops(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
		try {
			 List<Laptop> list = laptopdao.getLaptops();
				request.setAttribute("laptops", list);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	  return "show.jsp";
		
		
	}
}

   
   
