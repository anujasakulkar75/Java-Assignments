<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Registration</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

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
            max-width: 600px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
        }

        .card-header {
            text-align: center;
            margin-bottom: 32px;
        }

        .card-header h2 {
            font-size: 26px;
            color: #1a1a2e;
            font-weight: 600;
        }

        .card-header p {
            color: #6c757d;
            margin-top: 6px;
            font-size: 14px;
        }

        .form-row {
            display: flex;
            gap: 16px;
            margin-bottom: 20px;
        }

        .form-group {
            flex: 1;
            display: flex;
            flex-direction: column;
        }

        .form-group label {
            font-size: 13px;
            font-weight: 500;
            color: #444;
            margin-bottom: 6px;
        }

        .form-group label span {
            color: #e53935;
        }

        .form-group input,
        .form-group select {
            padding: 10px 14px;
            border: 1.5px solid #dde1e7;
            border-radius: 8px;
            font-size: 14px;
            color: #333;
            outline: none;
            transition: border-color 0.2s;
        }

        .form-group input:focus,
        .form-group select:focus {
            border-color: #4361ee;
        }

        .error-box {
            background: #fff0f0;
            border: 1px solid #ffcdd2;
            color: #c62828;
            padding: 12px 16px;
            border-radius: 8px;
            font-size: 14px;
            margin-bottom: 20px;
        }

        .btn-submit {
            width: 100%;
            padding: 13px;
            background: #4361ee;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 15px;
            font-weight: 600;
            cursor: pointer;
            margin-top: 8px;
            transition: background 0.2s;
            letter-spacing: 0.3px;
        }

        .btn-submit:hover {
            background: #3451d1;
        }

        @media (max-width: 520px) {
            .form-row {
                flex-direction: column;
                gap: 0;
            }
            .form-group {
                margin-bottom: 16px;
            }
        }
    </style>
</head>
<body>

<div class="card">
    <div class="card-header">
        <h2>Employee Registration</h2>
        <p>Fill in the details below to register a new employee</p>
    </div>

    <%-- Show error if any --%>
    <% if (request.getAttribute("error") != null) { %>
        <div class="error-box">
            <strong>Error:</strong> <%= request.getAttribute("error") %>
        </div>
    <% } %>

    <form action="register" method="post">

        <div class="form-row">
            <div class="form-group">
                <label>Full Name <span>*</span></label>
                <input type="text" name="fullName" placeholder="e.g. Rahul Sharma"
                       value="<%= request.getAttribute("error") != null && request.getParameter("fullName") != null
                                  ? request.getParameter("fullName") : "" %>" required>
            </div>
            <div class="form-group">
                <label>Email Address <span>*</span></label>
                <input type="email" name="email" placeholder="e.g. rahul@example.com"
                       value="<%= request.getAttribute("error") != null && request.getParameter("email") != null
                                  ? request.getParameter("email") : "" %>" required>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>Phone Number</label>
                <input type="tel" name="phone" placeholder="e.g. 9876543210"
                       value="<%= request.getAttribute("error") != null && request.getParameter("phone") != null
                                  ? request.getParameter("phone") : "" %>">
            </div>
            <div class="form-group">
                <label>Department <span>*</span></label>
                <select name="department" required>
                    <option value="--Select--">-- Select --</option>
                    <option value="Engineering">Engineering</option>
                    <option value="Human Resources">Human Resources</option>
                    <option value="Finance">Finance</option>
                    <option value="Marketing">Marketing</option>
                    <option value="Operations">Operations</option>
                    <option value="Sales">Sales</option>
                    <option value="IT Support">IT Support</option>
                </select>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>Designation</label>
                <input type="text" name="designation" placeholder="e.g. Software Engineer"
                       value="<%= request.getAttribute("error") != null && request.getParameter("designation") != null
                                  ? request.getParameter("designation") : "" %>">
            </div>
            <div class="form-group">
                <label>Salary (₹)</label>
                <input type="number" name="salary" placeholder="e.g. 50000" min="0"
                       value="<%= request.getAttribute("error") != null && request.getParameter("salary") != null
                                  ? request.getParameter("salary") : "" %>">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>Date of Joining</label>
                <input type="date" name="dateOfJoining">
            </div>
        </div>

        <button type="submit" class="btn-submit">Register Employee</button>

    </form>
</div>

</body>
</html>
