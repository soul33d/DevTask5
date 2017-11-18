<html>
<head>
    <title>Home</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
    <script src="js/w3.js"></script>
</head>
<body>
<div w3-include-html="nav_bar.html"></div>
<script>w3.includeHTML()</script>
<div class="container">
    <table class="table table-bordered table-hover">
        <tr>
            <td>
                <a href="/manufacturers">Manufacturers list</a>
            </td>

            <td>
                <a href="/manufacturer_create.jsp">create new</a>
            </td>
        </tr>
        <tr>
            <td>
                <a href="/products">Products list</a>
            </td>

            <td>
                <a href="/product_create.jsp">create new</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
