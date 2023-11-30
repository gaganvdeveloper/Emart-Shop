package emart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;
@WebServlet("/fetch")
public class FetchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","admin");
			PreparedStatement ps = con.prepareStatement("select * from product where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			String html = "<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Update Product Page</title>\r\n"
					+ "     <style> \r\n"
					+ "        body {\r\n"
					+ "            font-family: 'Arial', sans-serif;\r\n"
					+ "            background-color: #fafafa; \r\n"
					+ "            color: #333;\r\n"
					+ "            align-items: center;\r\n"
					+ "            justify-content: center;\r\n"
					+ "            height: 100vh;\r\n"
					+ "            margin: 0;\r\n"
					+ "            background: linear-gradient(45deg, rgb(39, 77, 104) 5%, rgb(83, 65, 118) 77%);\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        #headline {\r\n"
					+ "            color: white; \r\n"
					+ "            text-align: center; \r\n"
					+ "            margin-bottom: 20px; \r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        form {\r\n"
					+ "            margin: auto;\r\n"
					+ "            width: 30%;\r\n"
					+ "            background-color: #fff; \r\n"
					+ "            padding: 20px;\r\n"
					+ "            border-radius: 10px;\r\n"
					+ "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); \r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        label {\r\n"
					+ "            display: block;\r\n"
					+ "            margin-bottom: 8px;\r\n"
					+ "            color: #333; \r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        input {\r\n"
					+ "            outline: none;\r\n"
					+ "            width: 100%;\r\n"
					+ "            padding: 8px;\r\n"
					+ "            margin-bottom: 16px;\r\n"
					+ "            box-sizing: border-box;\r\n"
					+ "            border: 1px solid #ddd;  \r\n"
					+ "            border-radius: 4px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        input:hover{\r\n"
					+ "            border: 1px solid green;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        button {\r\n"
					+ "            background-color: #09ac19; \r\n"
					+ "            color: #fff;\r\n"
					+ "            padding: 10px;\r\n"
					+ "            border: none;\r\n"
					+ "            border-radius: 5px;\r\n"
					+ "            cursor: pointer;\r\n"
					+ "            font-size: 16px;\r\n"
					+ "            /* margin-left: 35%; */\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        button:hover {\r\n"
					+ "            background-color: #14800e;\r\n"
					+ "        }\r\n"
					+ "        #refresh{\r\n"
					+ "            background-color: white; \r\n"
					+ "            color: #09ac19;\r\n"
					+ "            padding: 10px;\r\n"
					+ "            border: 1px solid #09ac19;\r\n"
					+ "            border-radius: 5px;\r\n"
					+ "            cursor: pointer;\r\n"
					+ "            font-size: 16px;\r\n"
					+ "            margin-left:10%;\r\n"
					+ "        }\r\n"
					+ "        #refresh:hover{\r\n"
					+ "            background-color: #09ac19; \r\n"
					+ "            color: #fff;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<br>\r\n"
					+ "<br>\r\n"
					+ "<br>\r\n"
					+ "    <h1 id=\"headline\">Enter Product Details : </h1>\r\n"
					+ "    <form  action=\"update\">\r\n"
					+ "        <label for=\"id\">ID : </label><input type=\"text\" value='"+rs.getInt(1)+"' name=\"id\" id=\"id\" placeholder=\"Enter Id\" readonly='readonly' required=\"required\">\r\n"
					+ "        <label for=\"name\">Name : </label><input type=\"text\" value='"+rs.getString(2)+"' name=\"name\" id=\"name\" placeholder=\"Enter Name\" required=\"required\">\r\n"
					+ "        <label for=\"price\">Price : </label><input type=\"text\" value='"+rs.getString(3)+"' name=\"price\" id=\"price\" placeholder=\"Enter Price\" required=\"required\">\r\n"
					+ "        <label for=\"quantity\">Quantity : </label><input type=\"text\" value='"+rs.getString(4)+"' name=\"quantity\" id=\"quantity\" placeholder=\"Enter Quantity\" required=\"required\">\r\n"
					+ "        <button type=\"submit\">Update Product</button>\r\n"
					+ "        <a href=\"fetchall\" style=\"float: right;\"> <button type=\"button\">Back</button> </a>\r\n"
					+ "        \r\n"
					+ "    </form>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "";
			resp.getWriter().write(html);
			RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
			rd.include(req, resp);
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
