<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <h1><a href="/${moeApplication.context}/action/index/show">MOE</a></h1>
        <h2>The <span class="moe">M</span>edia <span class="moe">O</span>rganiz<span class="moe">e</span>r</h2>
    </header>

    <div id="content">
        <h1>Available media types</h1>
        <ul>
        <c:forEach var="item" items="${moeApplication.availableMedia}">
            <li><a href="/${moeApplication.context}/action/${item.link}/list" title="Go to ${item.name}">${item.name}</a></li>
        </c:forEach>
        </ul>
    </div>

    <footer>
        <p>Version: 0.1 - beta</p>
        <p>Model-Version: 1</p>
        <p>&copy; Bazinga</p>
    </footer>
</div>
</body>
</html>