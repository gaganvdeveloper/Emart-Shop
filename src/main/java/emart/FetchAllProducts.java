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

@WebServlet("/fetchall")
public class FetchAllProducts extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","admin");
			PreparedStatement ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			String result = "<html lang=\"en\">\r\n"
					+ "  <head>\r\n"
					+ "    <title>Home Page</title>\r\n"
					+ "    <link\r\n"
					+ "      rel=\"stylesheet\"\r\n"
					+ "      href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\"\r\n"
					+ "      integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\"\r\n"
					+ "      crossorigin=\"anonymous\"\r\n"
					+ "    />\r\n"
					+ "  </head>\r\n"
					+ "  <body\r\n"
					+ "    style=\"\r\n"
					+ "      background: linear-gradient(\r\n"
					+ "        45deg,\r\n"
					+ "        rgb(39, 77, 04) 5%,\r\n"
					+ "        rgb(83, 65, 18) 77%\r\n"
					+ "      );\r\n"
					+ "    \"\r\n"
					+ "  >\r\n"
					+ "    <script\r\n"
					+ "      src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"\r\n"
					+ "      integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\r\n"
					+ "      crossorigin=\"anonymous\"\r\n"
					+ "    ></script>\r\n"
					+ "    <script\r\n"
					+ "      src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"\r\n"
					+ "      integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\"\r\n"
					+ "      crossorigin=\"anonymous\"\r\n"
					+ "    ></script>\r\n"
					+ "    <div class=\"container-fluid bg-light\" style=\"min-height: 100vh\">\r\n"
					+ "      <br /><br /><br /><br />\r\n"
					+ "      <div class=\"container\">\r\n"
					+ "        <h1 style=\"font-style: italic; float:left;\">All Products :</h1><a href='index.jsp' style='float:right; margin-bottom:-20px;'><button >Add Product</button></a>\r\n"
					+ "\r\n"
					+ "        <table class=\"table table-hover\">\r\n"
					+ "          <thead>\r\n"
					+ "            <tr>\r\n"
					+ "              <th scope=\"col\">Id</th>\r\n"
					+ "              <th scope=\"col\">Name</th>\r\n"
					+ "              <th scope=\"col\">Price</th>\r\n"
					+ "              <th scope=\"col\">Quantity</th>\r\n"
					+ "              <th scope=\"col\">Update</th>\r\n"
					+ "              <th scope=\"col\">Delete</th>\r\n"
					+ "            </tr>\r\n"
					+ "          </thead>\r\n"
					+ "          <tbody>";
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				String quantity = rs.getString(4);
				result = result+"<tr><td>"+id+"</td> <td>"+name+"</td> <td>"+price+"</td> <td>"+quantity+"</td><td><a href='fetch?id="+id+"'><button type='button'>Update</button></a></td><td><a href='delete?id="+id+"'><button type='button'>Delete</button></a></td></tr>";
			}
			result=result+" </tbody>\r\n"
					+ "        </table>\r\n"
					+ "      </div>\r\n"
					+ "    </div>\r\n"
					+ "  </body>\r\n"
					+ "</html>";
			resp.getWriter().write(result);
			System.out.println("Fetched All Products");
			RequestDispatcher rd = req.getRequestDispatcher("allproducts.jsp");
			rd.include(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
