<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.emp.Employee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f0f2f5;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 30px 15px;
        }

        .card {
            background: #fff;
            border-radius: 12px;
            padding: 40px;
            width: 100%;
            max-width: 560px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
            text-align: center;
        }

        .icon {
            width: 72px;
            height: 72px;
            background: #e8f5e9;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto 20px;
            font-size: 34px;
        }

        h2 {
            font-size: 24px;
            color: #1a1a2e;
            margin-bottom: 8px;
        }

        .sub {
            color: #6c757d;
            font-size: 14px;
            margin-bottom: 30px;
        }

        .details-table {
            width: 100%;
            border-collapse: collapse;
            text-align: left;
            margin-bottom: 30px;
        }

        .details-table tr {
            border-bottom: 1px solid #f0f0f0;
        }

        .details-table tr:last-child {
            border-bottom: none;
        }

        .details-table td {
            padding: 11px 8px;
            font-size: 14px;
        }

        .details-table td:first-child {
            color: #6c757d;
            width: 45%;
            font-weight: 500;
        }

        .details-table td:last-child {
            color: #1a1a2e;
            font-weight: 500;
        }

        .btn-back {
            display: inline-block;
            padding: 12px 30px;
            background: #4361ee;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-size: 15px;
            font-weight: 600;
            transition: background 0.2s;
        }

        .btn-back:hover {
            background: #3451d1;
        }
    </style>
</head>
<body>

<%
    Employee emp = (Employee) request.getAttribute("employee");
    if (emp == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<div class="card">
    <div class="icon">✓</div>
    <h2>Registration Successful!</h2>
    <p class="sub">Employee has been registered in the system.</p>

    <table class="details-table">
        <tr>
            <td>Full Name</td>
            <td><%= emp.getFullName() %></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><%= emp.getEmail() %></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><%= (emp.getPhone() != null && !emp.getPhone().isEmpty()) ? emp.getPhone() : "—" %></td>
        </tr>
        <tr>
            <td>Department</td>
            <td><%= emp.getDepartment() %></td>
        </tr>
        <tr>
            <td>Designation</td>
            <td><%= (emp.getDesignation() != null && !emp.getDesignation().isEmpty()) ? emp.getDesignation() : "—" %></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td>₹ <%= String.format("%.2f", emp.getSalary()) %></td>
        </tr>
        <tr>
            <td>Date of Joining</td>
            <td><%= (emp.getDateOfJoining() != null && !emp.getDateOfJoining().isEmpty()) ? emp.getDateOfJoining() : "—" %></td>
        </tr>
    </table>

    <a href="index.jsp" class="btn-back">Register Another Employee</a>
</div>

</body>
</html>
