<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Member List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Member List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Member Id</th>
          <!-- <th>Full Name</th> -->
          <th>Gender</th>
          <th>Age</th>
          <th>Career</th>
          <th>Working at</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${memberList}" var="member" >
          <tr>
             <td>${member.memberId}</td>
             <%-- <td>${member.memberName}</td> --%>
             <td>${member.gender}</td>
             <td>${member.age}</td>
             <td>${member.career}</td>
             <td>${member.workingAt}</td>
             <td>
                <a href="editMember?memberId=${member.memberId}">Edit</a>
             </td>
             <td>
                <a href="deleteMember?memberId=${member.memberId}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createMember" >Add Member</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>