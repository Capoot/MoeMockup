<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Moe - php</title>
    <link href="/${moeApplication.context}/style.css" rel="stylesheet" />
</head>
<body>
<div id="page__wrapper">
    <header>
        <h1><a href="../../action/index/show">MOE</a></h1>
        <h2>The <span class="moe">M</span>edia <span class="moe">O</span>rganiz<span class="moe">e</span>r</h2>
    </header>

    <div id="content">
        <h1>Available Music</h1>
        <c:choose>
			<c:when test="${fn:length(music) > 0}">
				<p>
		            <a href="/${moeApplication.context}/action/music/add">Add music</a>
		        </p>
				<table>
		            <tr>
		                <th>File</th>
		                <th>Size</th>
		                <th>Action</th>
		            </tr>
		            <c:forEach var="item" items="${music}" >
		            <tr>
		                <td>${item.filename}</td>
		                <td>${item.size / 1024} KB</td>
		                <td>
		                    <a class="action edit" href="/${moeApplication.context}/action/music/edit/${item.id}">Edit</a>
		                    <a class="action delete" href="/${moeApplication.context}/action/music/delete/${item.id}">Delete</a>
		                </td>
		            </tr>
		            </c:forEach>
		        </table>
	        </c:when>
			<c:otherwise>
				<p>
		            There is no music to display at this time. Would you like to <a href="/${moeApplication.context}/action/music/add">add music</a>?
		        </p>
			</c:otherwise>
		</c:choose>
    </div>

    <footer>
        <p>Version: 0.1 - beta</p>
        <p>Model-Version: 1</p>
        <p>&copy; Bazinga</p>
    </footer>
</div>
</body>
</html>