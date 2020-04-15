<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap 模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-88">
    <!-- 引入 Bootstrap -->
    <link src="../static/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
    <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1>Hello, world!</h1>

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="../static/js/bootstrap.min.js"></script>


<meta charset="UTF-8">

<title>Saisie de la recette</title>


<script>
    var idIngre = 0;
    var idEtape = 0;

    function addRowIngre () {
        // /Find a <table> element with id="ingredientsTable":
        var table = document.getElementById("ingredientsTable");

        // Create an empty <tr> element and add it to the 1st position of the table:
        var row = table.insertRow();

        // Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);


        // Add some text to the new cells:
        var nom = document.getElementById("nom").value;
        var quantite= document.getElementById("quantite").value;
        var um = document.getElementById("UM").value;
        idIngre ++;
        var button = document.createElement("button");
        button.innerHTML = "supprimer";
        button.onclick = function(){
            deleteRow(button);
        };

        cell1.innerHTML = idIngre;
        cell2.innerHTML = nom;
        cell3.innerHTML = quantite;
        cell4.innerHTML = um;
        cell5.appendChild(button);
    }

    function addRowEtape () {
        // /Find a <table> element with id="ingredientsTable":
        var table = document.getElementById("etapesTable");

        // Create an empty <tr> element and add it to the 1st position of the table:
        var row = table.insertRow();

        // Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);

        // Add some text to the new cells:
        idEtape ++;
        var description = document.getElementById("description").value;
        var button = document.createElement("button");
        button.innerHTML = "supprimer";
        button.onclick = function(){
            deleteRow(button);
        };


        cell1.innerHTML = idEtape;
        cell2.innerHTML = description;
        cell3.appendChild(button);
    }

    function deleteRow(button) {

        var rowIndex = button.parentNode.parentNode.rowIndex;
        var actualTable = button.parentNode.parentNode.parentNode.parentNode;
        //alert(isTable.id);
        //var ingreTable = document.getElementById("ingredientsTable");
        actualTable.deleteRow(rowIndex);

        var numberOfRows = actualTable.rows.length;
        var i;

        for (i = 1; i < numberOfRows; i++) {
            actualTable.rows[i].cells[0].innerHTML = i;
        }
        if (actualTable.id == "ingredientsTable")
        {idIngre = idIngre-1;}
        else if (actualTable.id == "etapesTable")
        {idEtape = idEtape-1;}

    }

    //document.getElementById("captionIngre").style.textAlign = "center";
</script>

<h1 id="Title">Creation de recette</h1>

<div id="saisies">

    <p>Saisissez votre ingredient</p>

    <!-- 		<label for="fname" >First name:</label> <label for="fname">First name:</label> <label for="fname">First name:</label><br> -->
    <input id="nom" type="text" required min="1" max="30" size="20" required>

    <input id="quantite" type="number" required min="1" maxlength="4" size="3" required>
    <input id="UM" type="text" required min="1" max="4" size="3" required>
    <button id="ajoutIng" type="button" onclick= "addRowIngre()" style="height:23px; width:130px">Ajouter ingredient</button>


</div><br>

<table id = "ingredientsTable">
    <caption id ="captionIngre" >Ingrédients</caption>

    <tr>
        <th>Numéro</th>
        <th>Nom</th>
        <th>Quantité</th>
        <th>Unité de mesure</th>
        <th></th>
    </tr>
</table>


<div id="etapes">

    <p>Saisissez les etapes</p>

    <input id="description" required min="1" maxlength="30" size="20" required>
    <button type="button" onclick = "addRowEtape()" style="height:23px; width:130px">Ajouter etape</button>

</div><br>

<table id = "etapesTable">
    <caption id ="captionPrepa" >Preparation</caption>

    <tr>
        <th>Numéro</th>
        <th>Description</th>
        <th></th>
    </tr>
</table><br>
<p></p>
</body>
</html>
