package com.hive;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ChartController {
	String url = "jdbc:hive2://192.168.111.130:10000/default";
	String id = "root";
	String password = "111111";	
	
	public ChartController(){	// constructor
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getdata1.mc")
	@ResponseBody
	public void getdata1(HttpServletResponse res) throws Exception {
		Connection con = null;
		JSONArray data = new JSONArray();
		try {
			con = DriverManager.getConnection(url, id, password);
			PreparedStatement pstmt = con.prepareStatement("SELECT AVG(speed)FROM carstatus");
			ResultSet rset = pstmt.executeQuery();
			while(rset.next()) {
				data.add(rset.getFloat(1));
			}			
		}	
		catch (Exception e){
				throw e;
		} finally {
			con.close();
		}		
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(data.toJSONString());
		out.close();
	}
	
	@RequestMapping("/getdata2.mc")
	@ResponseBody
	public void getdata2(HttpServletResponse res) throws Exception {
		Connection con = null;
		JSONArray data = new JSONArray();
		try {
			con = DriverManager.getConnection(url, id, password);
			PreparedStatement pstmt = con.prepareStatement("SELECT AVG(speed)FROM carstatus GROUP BY direction");
			ResultSet rset = pstmt.executeQuery();
			while(rset.next()) {
				data.add(rset.getFloat(1));
			}
		}
		catch (Exception e){
				throw e;
		} finally {
			con.close();
		}		
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(data.toJSONString());
		out.close();
	}
	@RequestMapping("/getdata3.mc")
	@ResponseBody
	public void getdata3(HttpServletResponse res) throws Exception {
		Connection con = null;
		JSONArray data = new JSONArray();
		try {
			con = DriverManager.getConnection(url, id, password);
			PreparedStatement pstmt = con.prepareStatement("SELECT AVG(speed)FROM carstatus GROUP BY speeding");
			ResultSet rset = pstmt.executeQuery();
			while(rset.next()) {
				data.add(rset.getFloat(1));
			}
		}
		catch (Exception e){
				throw e;
		} finally {
			con.close();
		}		
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(data.toJSONString());
		out.close();
	}	
}
