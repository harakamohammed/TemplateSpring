<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Example of Twitter Bootstrap 3 Table with Emphasis Classes</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap-theme.min.css">
 <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
</style>
</head>
<body>
<div>



</div>
<div class="bs-example">
 



 <f:form action="student.do" method="POST" commandName="student"  class="form-horizontal">
        <fieldset>
            <div class="form-group">
                <label for="inputEmail" class="control-label col-xs-2">NOM</label>
                <div class="col-xs-10">
                    <f:input  path="nom"  type="text"    class="form-control" id="inputEmail" placeholder="NOM" />
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="control-label col-xs-2">PRENOM</label>
                <div class="col-xs-10">
                    <f:input  path="prenom"  type="text"    class="form-control" id="inputEmail" placeholder="PRENOM" />
                </div>
            </div>
             <div class="form-group">
                <label for="inputEmail" class="control-label col-xs-2">CNE</label>
                <div class="col-xs-10">
                    <f:input  path="cne"  type="text"    class="form-control" id="inputEmail" placeholder="CNE" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                  
                    <input type="submit" name="action" value="Add" class="btn btn-primary"/>
				<input type="submit" name="action" value="Edit" class="btn btn-success"/>
				<input type="submit" name="action" value="Delete" class="btn btn-danger"/>
				<input type="submit" name="action" value="Search" class="btn btn-warning" />
                </div>
            </div>
        </fieldset>
    </f:form>

















    <br><br><br>
    <table class="table">
        <thead>
            <tr>
               <th>ID</th>
	           <th>First name</th>
	           <th>Last name</th>
	           <th>CNE</th>
            </tr>
        </thead>
        <tbody>
               <c:forEach items="${listestudent}" var="student">
		        <tr class="success">
			        <td>${student.ID}</td>
			        <td>${student.nom}</td>
			        <td>${student.prenom}</td>
			        <td>${student.cne}</td>
		        </tr>
	           </c:forEach>
        	  
        </tbody>
    </table>
</div>
</body>
</html>      