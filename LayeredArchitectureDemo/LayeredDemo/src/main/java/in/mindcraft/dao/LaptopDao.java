package in.mindcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.mindcraft.pojos.Laptop;
import in.mindcraft.utils.DButils;

public class LaptopDao {
private Connection cn;
private PreparedStatement pst1;
private PreparedStatement pst2;
	public void addLaptop(Laptop laptop) throws SQLException {
		cn=DButils.openConnection();
		pst1=cn.prepareStatement("insert into laptop(lid,make,cost) values(?,?,?)");
		pst1.setInt(1,laptop.getLid());
		pst1.setString(2, laptop.getMake());
		pst1.setDouble(3, laptop.getCost());
		pst1.execute();
		cn.close();
		DButils.closeConnection();
		
	}
	
	public List<Laptop> getLaptops() throws SQLException{
		
	cn=DButils.openConnection();		
	List<Laptop> list = new ArrayList<Laptop>();
		pst2=cn.prepareStatement("SELECT * FROM laptop");
		ResultSet resultSet = pst2.executeQuery();
		while(resultSet.next()) {
			list.add(new Laptop(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3)));
        } 
		DButils.closeConnection();
		return list;
		
		
	}
}
