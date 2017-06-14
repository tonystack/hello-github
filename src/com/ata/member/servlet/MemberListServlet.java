package com.ata.member.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ata.member.beans.MemberList;
import com.ata.member.utils.DBUtils;
import com.ata.member.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/memberList" })
public class MemberListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public MemberListServlet() {
      super();
  }
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      Connection conn = MyUtils.getStoredConnection(request);
 
      String errorString = null;
      List<MemberList> list = null;
      try {
          list = DBUtils.queryMemberList(conn);
      } catch (SQLException e) {
          e.printStackTrace();
          errorString = e.getMessage();
      }
      // Lưu thông tin vào request attribute trước khi forward sang views.
      request.setAttribute("errorString", errorString);
      request.setAttribute("memberList", list);
      
      // Forward sang /WEB-INF/views/productListView.jsp
      RequestDispatcher dispatcher = request.getServletContext()
              .getRequestDispatcher("/WEB-INF/views/memberListView.jsp");
      dispatcher.forward(request, response);
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
