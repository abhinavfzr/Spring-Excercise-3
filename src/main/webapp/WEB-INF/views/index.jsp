<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KeepNote</title>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send 
 		 button. Handle errors like empty fields -->
    <form action="index">
    <input type="text" name="noteId"/>
     <input type="text" name="noteTitle"/>
       <input type="text" name="noteContent"/>
    <input type="text" name="noteStatus"/>
    <input type="submit"/>
    </form>

   <!--provide an html table start tag -->
      <table style="border: 1px solid;">
      <!-- iterate over the collection using forEach loop -->
      <th> noteId </th>
                <th> noteTitle </th>
                 <th> noteContent </th>
                   <th> noteStatus</th>
      <c:forEach var="user" items="${users}">
          <!-- create an html table row -->
          <tr>
          <!-- create cells of row -->
          <td>${user.noteId}   </td>
          <td>${user.noteContent}  </td>
           <td>${user.noteTitle}  </td>
           <td>${user.noteStatus}  </td>
            <td>
             <form action="delete">
             <button type="submit" name="noteId" value="${user.noteId}">delete
              </button>
             </form>
             </td>
          <!-- close row -->
          </tr>
          <!-- close the loop -->
      </c:forEach>
      <!-- close table -->
      </table>
	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
</body>
</html>