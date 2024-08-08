package com.log;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signinservlet")
public class SignInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SignInServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web", "root", "root");

            // Prepare the SQL query
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password); // In a real application, hash passwords!

            // Execute the query
            rs = pst.executeQuery();

            // Check if user exists
            if (rs.next()) {
                request.getSession().setAttribute("email", email);
                response.sendRedirect("welcome.jsp");
            } else {
                request.getRequestDispatcher("signin.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.getRequestDispatcher("signin.jsp").forward(request, response);
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
