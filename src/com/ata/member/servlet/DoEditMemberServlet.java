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

@WebServlet("/doEditMember")
public class DoEditMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public DoEditMemberServlet() {
        super();        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Connection conn = MyUtils.getStoredConnection(request);
	    
	    String memberIdStr = (String) request.getParameter("memberId");
	      String memberName= (String) request.getParameter("memberName");
	      String gender= (String) request.getParameter("gender");
	      String ageStr= (String) request.getParameter("age");
	      String career= (String) request.getParameter("career");
	      String workingAt= (String) request.getParameter("workingAt");
	 
	      int memberId = 0;
	      int age = 0;
	      
	      try {
	          memberId = Integer.valueOf(memberIdStr);
	          age = Integer.valueOf(ageStr);
	      } catch (Exception e) {
	      }
	      MemberList member = new MemberList(memberId, memberName, gender, age, career, workingAt);
	 
	      String errorString = null;
	 
	      try {
	          DBUtils.updateMember(conn, member);
	      } catch (SQLException e) {
	          e.printStackTrace();
	          errorString = e.getMessage();
	      }
	      // Lưu thông tin vào request attribute trước khi forward sang views.
	      request.setAttribute("errorString", errorString);
	      request.setAttribute("member", member);
	 
	      // Nếu có lỗi forward sang trang edit
	      if (errorString != null) {
	          RequestDispatcher dispatcher = request.getServletContext()
	                  .getRequestDispatcher("/WEB-INF/views/editMemberView.jsp");
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
