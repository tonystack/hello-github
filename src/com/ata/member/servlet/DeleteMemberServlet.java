package com.ata.member.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.ata.member.utils.DBUtils;
import com.ata.member.utils.MyUtils;

@WebServlet("/deleteMember")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public DeleteMemberServlet() {
        super();       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Connection conn = MyUtils.getStoredConnection(request);
	    
	      String memberId = (String) request.getParameter("memberId");
	 
	      String errorString = null;
	 
	      try {
	          DBUtils.deleteMember(conn, memberId);
	      } catch (SQLException e) {
	          e.printStackTrace();
	          errorString = e.getMessage();
	      }
	      
	      // Nếu có lỗi forward sang trang báo lỗi.
	      if (errorString != null) {
	          // Lưu thông tin vào request attribute trước khi forward sang views.
	          request.setAttribute("errorString", errorString);
	          //
	          RequestDispatcher dispatcher = request.getServletContext()
	                  .getRequestDispatcher("/WEB-INF/views/deleteMemberErrorView.jsp");
	          dispatcher.forward(request, response);
	      }
	      // Nếu mọi thứ tốt đẹp.
	      // Redirect sang trang danh sách sản phẩm.
	      else {
	          response.sendRedirect(request.getContextPath() + "/memberList");
	      }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
