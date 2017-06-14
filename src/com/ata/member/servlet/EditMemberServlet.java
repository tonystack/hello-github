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

import com.ata.member.beans.MemberList;
import com.ata.member.utils.DBUtils;
import com.ata.member.utils.MyUtils;

@WebServlet("/editMember")
public class EditMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public EditMemberServlet() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Connection conn = MyUtils.getStoredConnection(request);
	    
	      String memberId = (String) request.getParameter("memberId");
	 
	      MemberList member = null;
	 
	      String errorString = null;
	 
	      try {
	          member = DBUtils.findMember(conn, memberId);
	      } catch (SQLException e) {
	          e.printStackTrace();
	          errorString = e.getMessage();
	      }
	 
	      // Không có lỗi.
	      // Sản phẩm không tồn tại để edit.
	      // Redirect sang trang danh sách sản phẩm.
	      if (errorString != null && member == null) {
	          response.sendRedirect(request.getServletPath() + "/memberList");
	          return;
	      }
	 
	      // Lưu thông tin vào request attribute trước khi forward sang views.
	      request.setAttribute("errorString", errorString);
	      request.setAttribute("member", member);
	 
	      RequestDispatcher dispatcher = request.getServletContext()
	              .getRequestDispatcher("/WEB-INF/views/editMemberView.jsp");
	      dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
