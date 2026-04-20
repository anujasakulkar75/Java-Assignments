package com.emp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String fullName     = request.getParameter("fullName").trim();
        String email        = request.getParameter("email").trim();
        String phone        = request.getParameter("phone").trim();
        String department   = request.getParameter("department");
        String designation  = request.getParameter("designation").trim();
        String salaryStr    = request.getParameter("salary").trim();
        String dateJoining  = request.getParameter("dateOfJoining");

        // Basic validation
        if (fullName.isEmpty() || email.isEmpty() || department.equals("--Select--")) {
            request.setAttribute("error", "Please fill all required fields.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        double salary = 0;
        try {
            salary = Double.parseDouble(salaryStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid salary value.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        Employee emp = new Employee(fullName, email, phone, department, designation, salary, dateJoining);

        String sql = "INSERT INTO employees (full_name, email, phone, department, designation, salary, date_of_joining) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getFullName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getPhone());
            ps.setString(4, emp.getDepartment());
            ps.setString(5, emp.getDesignation());
            ps.setDouble(6, emp.getSalary());
            ps.setString(7, emp.getDateOfJoining());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                request.setAttribute("employee", emp);
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Registration failed. Please try again.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                request.setAttribute("error", "This email is already registered.");
            } else {
                request.setAttribute("error", "Database error: " + e.getMessage());
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
