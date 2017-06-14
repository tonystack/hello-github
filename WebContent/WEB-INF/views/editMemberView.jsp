<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Add Member</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
    
    <h3>Add Member</h3>
    
    <p style="color: red;">${errorString}</p>
    <c:if test="${not empty member}">
    <form method="POST" action="doCreateMember">
    <input type="hidden" name="code" value="${member.memberId}" />
       <table border="0">
          <tr>
             <td>Full Name</td>
             <td><input type="text" name="memberName" value="" /></td>
          </tr>
          <tr>
             <td>Gender</td>
             <td><input type="text" name="gender" value="${member.gender}" /></td>
          </tr>
          <tr>
             <td>Age</td>
             <td><input type="text" name="age" value="${member.age}" /></td>
          </tr>
          <tr>
             <td>Career</td>
             <td><input type="text" name="career" value="${member.career}" /></td>
          </tr>
          <tr>
             <td>Working at</td>
             <td><input type="text" name="workingAt" value="${member.workingAt}" /></td>
          </tr>
          <tr>
             <td colspan="2">                  
                 <input type="submit" value="Submit" />
                 <a href="${pageContext.request.contextPath}/memberList">Cancel</a>                 
             </td>
          </tr>
       </table>
    </form>
    </c:if>
    <jsp:include page="_footer.jsp"></jsp:include>
    
 </body>
</html>