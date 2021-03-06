<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page import ="java.util.ArrayList" %>
<%@ page import = "eshare.model.food" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="hide-sidebar ls-bottom-footer" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Food Sharing</title>
<link href="css/vendor.min.css" rel="stylesheet">
<link href="css/theme-core.min.css" rel="stylesheet">
<link href="css/module-essentials.min.css" rel="stylesheet" />
<link href="css/module-layout.min.css" rel="stylesheet" />
<link href="css/module-sidebar.min.css" rel="stylesheet" />
<link href="css/module-sidebar-skins.min.css" rel="stylesheet" />
<link href="css/module-navbar.min.css" rel="stylesheet" />
<link href="css/module-timeline.min.css" rel="stylesheet" />
<link href="css/module-cover.min.css" rel="stylesheet" />
<link href="css/module-chat.min.css" rel="stylesheet" />
<link href="css/module-maps.min.css" rel="stylesheet" />
</head>

<body class="login">

<%
ArrayList<food> ls = (ArrayList<food>)request.getAttribute("foodList");
%>
	<div id="content">
		<div class="container-fluid">
			<div class="lock-container" style="width: 450px;">
				<h1>All Foods.</h1>
				<div class="panel panel-default text-center"
					style="max-width: 450px ! important;">
					<!-- <img src="images/guy-5.jpg" class="img"> -->
					<div class="panel-body">
					 <%for(int i = 0; i < ls.size();i++){ %>
					
						<form action="FoodModuleFinalTransactionServlet" method="post">
							<table>
								<tr>
																	<td>Food Type</td>
									<td><%=ls.get(i).getFoodType() %></td>
								
								
									<td>Food Price</td>
									<td><%=ls.get(i).getFoodPrice() %></td>
								</tr>
								<tr>
									<td>People Needed</td>
									<td><%=ls.get(i).getPeopleNeeded() %></td>
								
									<td>Food Quantity</td>
									<td><%=ls.get(i).getFoodQuantity() %></td>
								</tr>
								<tr>
									<td>Venue</td>
									<td><%=ls.get(i).getVenue() %></td>
								
									<td>Payment Type</td>
									<td><%=ls.get(i).getPaymentType() %></td>
								</tr>
								<tr>
									<td>Comments</td>
									<td><%=ls.get(i).getComments() %></td>
								</tr>
								<tr>
								<!-- since food type is foreign key we can use foreign to track all of the rest of data -->
									<td colspan="2">
									<input name='foodType' value ="<%=ls.get(i).getFoodType() %>" type='hidden'>
									<input type="submit"
										class="btn btn-primary" value="Interested"></td>
								</tr>
							
							</table>
							

						</form>
							<%} %>
					</div>
					<a href="hi.jsp">Click to share your food...</a>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		var colors = {
			"danger-color" : "#e74c3c",
			"success-color" : "#81b53e",
			"warning-color" : "#f0ad4e",
			"inverse-color" : "#2c3e50",
			"info-color" : "#2d7cb5",
			"default-color" : "#6e7882",
			"default-light-color" : "#cfd9db",
			"purple-color" : "#9D8AC7",
			"mustard-color" : "#d4d171",
			"lightred-color" : "#e15258",
			"body-bg" : "#f6f6f6"
		};
		var config = {
			theme : "social-1",
			skins : {
				"default" : {
					"primary-color" : "#16ae9f"
				},
				"orange" : {
					"primary-color" : "#e74c3c"
				},
				"blue" : {
					"primary-color" : "#4687ce"
				},
				"purple" : {
					"primary-color" : "#af86b9"
				},
				"brown" : {
					"primary-color" : "#c3a961"
				}
			}
		};
	</script>
	<script src="js/vendor-core.min.js"></script>
	<script src="js/vendor-tables.min.js"></script>
	<script src="js/vendor-forms.min.js"></script>
	<script src="js/vendor-maps.min.js"></script>
	<script src="js/module-essentials.min.js"></script>
	<script src="js/module-layout.min.js"></script>
	<script src="js/module-sidebar.min.js"></script>
	<script src="js/module-timeline.min.js"></script>
	<script src="js/module-chat.min.js"></script>
	<script src="js/module-maps.min.js"></script>
	<script src="js/theme-core.min.js"></script>
</body>
</html>