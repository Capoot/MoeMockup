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
        <h1>Add music</h1>

        <form action="/${moeApplication.context}/action/music/save" method="post" enctype="multipart/form-data" >
            <fieldset>
                <legend>General</legend>
                <p>
                    <label for="file">File:</label>
                    <input type="file" value="file" id="file" name="file" />
                </p>
            </fieldset>
            <p>
                <input type="submit" name="ok" value="Ok">
                <input type="submit" name="cancel" value="Cancel">
            </p>
        </form>

    </div>

    <footer>
        <p>Version: 0.1 - beta</p>
        <p>Model-Version: 1</p>
        <p>&copy; Bazinga</p>
    </footer>
</div>
</body>
</html>