<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE HTML>
    <HTML>

    <head>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 60%;
            }
            
            td,
            th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            
            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>


        <meta charset="UTF-8">

        <title>Saisie de la recette</title>





    </head>


    <body>
    <script src="https://cdn.bootcss.com/jquery/3.5.0/jquery.js"></script>

        <h1 id="Title">Création de recette</h1>

        <p>Bienvenue sur la page de création de recette. Ici vous pouvez rédiger vos propres recettes de pizzas qui pourront être consultées par les autres utilisateurs.</p>
		Nom de pizzas: 
		<input id="nomPizza" type="text" required>
		</br>
        <form action="">
            <div id="saisies">

                <h3>Saisissez votre ingrédient</h3>

                <label for="nom">Nom:</label>
                <input id="nom" type="text" size="20" required>
                <label for="quantite">Quantité:</label>
                <input id="quantite" type="number" size="10" required>
                <label for="um">Unité de mesure:</label>
                <input id="UM" type="text" size="10" required> &nbsp;&nbsp;&nbsp;
                <button id="ajoutIng" type="button" onclick="addRowIngre()" style="height:23px; width:130px">Ajouter ingrédient</button>


            </div><br>

            <table id="ingredientsTable">
                <caption id="captionIngre"></caption>

                <tr>
                    <th>Numéro</th>
                    <th>Nom</th>
                    <th>Quantité</th>
                    <th>Unité de mesure</th>
                    <th></th>
                </tr>
            </table>


            <div id="etapes">

                <h3>Saisissez les étapes</h3>

                <input id="description" required min="1" maxlength="30" size="200" required>
                <button type="button" onclick="addRowEtape()" style="height:23px; width:130px">Ajouter étape</button>

            </div><br>

            <table id="etapesTable">
                <caption id="captionPrepa"></caption>

                <tr>
                    <th>Numéro</th>
                    <th>Description</th>
                    <th></th>
                </tr>
            </table><br>
            <p></p>

            <input type="button" onclick="toJson()">
        </form>
        <form method="get" id="tableContent" action="/pizza/testsavepizza" style="display: none">
            <input type="text" id="pizzaClass" style="size: auto;width:700px;height: 400px" >
        </form>

    </body>
    <script>
        var idIngre = 0;
        var idEtape = 0;

        function addRowIngre() {
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
            var quantite = document.getElementById("quantite").value;
            var um = document.getElementById("UM").value;
            idIngre++;
            var button = document.createElement("button");
            button.innerHTML = "supprimer";
            button.onclick = function() {
                deleteRow(button);
            };

            cell1.innerHTML = idIngre;
            cell2.innerHTML = nom;
            cell3.innerHTML = quantite;
            cell4.innerHTML = um;
            cell5.appendChild(button);

        }

        function addRowEtape() {
            // /Find a <table> element with id="ingredientsTable":
            var table = document.getElementById("etapesTable");

            // Create an empty <tr> element and add it to the 1st position of the table:
            var row = table.insertRow();

            // Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);

            // Add some text to the new cells:
            idEtape++;
            var description = document.getElementById("description").value;

            var button = document.createElement("button");
            button.innerHTML = "supprimer";
            button.onclick = function() {
                deleteRow(button);
            };


            cell1.innerHTML = idEtape;
            cell2.innerHTML = description;
            cell3.appendChild(button);
            if (description=="null"){
                alert("veuillez saisir la description");
                return;
            }
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
            if (actualTable.id == "ingredientsTable") {
                idIngre = idIngre - 1;
            } else if (actualTable.id == "etapesTable") {
                idEtape = idEtape - 1;
            }

        }

        function toJson() {
            var pizzas = new Object();
            var ingredients = new Array();
            var steps = new Array();

            var tr;
            var tableIngred = document.getElementById("ingredientsTable");
            var namePizza = document.getElementById("nomPizza").value;
            var tableEtapeDescription = document.getElementById("etapesTable");

            var tableContent = document.getElementById("tableContent");

            for(var i=1;i<tableIngred.rows.length;i++){

                data = new Object();

                tr = tableIngred.rows[i];

                data.nameIngredient = tr.childNodes[1].innerHTML;
                data.quantityIngredient = tr.childNodes[2].innerHTML;

                data.unitOfMesure  = tr.childNodes[3].innerHTML;
                ingredients.push(data);
            }

            for(var i=1;i<tableEtapeDescription.rows.length;i++){

                data = new Object();

                tr = tableEtapeDescription.rows[i];

                data.nmStep = tr.childNodes[0].innerHTML;
                data.descriptionStep = tr.childNodes[1].innerHTML;
                steps.push(data);
            }


            pizzas.ingredientList = ingredients;
            pizzas.namePizza = namePizza;
            pizzas.listSteps = steps;
            alert(JSON.stringify(pizzas));
            document.getElementById('pizzaClass').value = JSON.stringify(pizzas);
            // tableContent.submit();


            $.ajax({
                url: "/pizza/testsavepizza",
                type: "POST",
                data: JSON.stringify(pizzas),
                contentType: "application/json;charset=utf-8" ,
                crossDomain: true,
                success: function(data){
                    console.log(data);
                }
            });
        }

        //document.getElementById("captionIngre").style.textAlign = "center";
    </script>
    </HTML>
