function loadGames() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var games = JSON.parse(this.responseText);
            var html = '<tr>\n' +
                '        <th>ID игры</th>\n' +
                '        <th>Имя игры</th>\n' +
                '        <th>Цена игры</th>\n' +
                '        <th>Описание игры</th>\n' +
                '        <th>Дата выпуска</th>\n' +
                '        <th>Оценка</th>\n' +
                '        <th>Картинка</th>\n' +
                '        <th>Удалить</th>\n' +
                '    </tr>';
            for (var i = 0; i < games.length; i++) {
                var game = games[i];
                //console.log(game);
                var releaseDateInMillisecond = new Date(game.releaseDate);
                var releaseDate = new Date();
                releaseDate.setTime(releaseDateInMillisecond);
                html = html + '<tr><td>' + game.id + '</td>\n' +
                    '        <td>' + game.name + '</td>\n' +
                    '        <td>' + game.price + '</td>\n' +
                    '        <td>' + game.description + '</td>\n' +
                    '        <td>' + releaseDate.toLocaleDateString() + '</td>\n' +
                    '        <td>' + game.rating + '</td>\n' +
                    '        <td>' + game.picture + '</td>\n' +
                    '        <td><button onclick="deleteGame(' + game.id + ')">Удалить</button></td></tr>';

            }
            document.getElementById("games_list").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8080/games/findAll", true);//параметр true - это чтобы запрос был
    // асинхронным, чтобы javascript не прекращал выполнение пока ждет ответ от сервера
    xhttp.send();
}

function createGame() {
    var gameName = document.getElementById("game_name").value;
    var gamePrice = document.getElementById("game_price").value;
    var gameDescription = document.getElementById("game_description").value;
    var gameReleaseDate = document.getElementById("game_release_date").value;
    var gameRating = document.getElementById("game_rating").value;

    var xhttp = new XMLHttpRequest();   // new HttpRequest instance
    xhttp.open("POST", "http://localhost:8080/games/save");
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify({
        name: gameName, price: gamePrice, description: gameDescription,
        releaseDate: gameReleaseDate, rating: gameRating, picture: ""
    }));

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            loadGames();
            let inscription = document.getElementById("inscription");
            inscription.classList.add("green-text");
            inscription.innerHTML = "Игра успешно создана";
            inscription.classList.remove("hidden");
            document.getElementById("game_name").value = "";
            document.getElementById("game_price").value = "";
            document.getElementById("game_description").value = "";
            document.getElementById("game_release_date").value = "";
            document.getElementById("game_rating").value = "";
        }
    };
}

function deleteGame(gameId) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/games/delete/" + gameId, true);
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            loadGames();
            let inscription = document.getElementById("inscription");
            inscription.classList.remove("hidden");
            inscription.classList.add("green-text");
            inscription.innerHTML = "Игра успешно удалена";
        }
    }
}

function searchByName() {
    var name = document.getElementById("search_field").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var game = JSON.parse(this.responseText);
            var html = '<tr>\n' +
                '        <th>ID игры</th>\n' +
                '        <th>Имя игры</th>\n' +
                '        <th>Цена игры</th>\n' +
                '        <th>Описание игры</th>\n' +
                '        <th>Дата выпуска</th>\n' +
                '        <th>Оценка</th>\n' +
                '        <th>Картинка</th>\n' +
                '        <th>Удалить</th>\n' +
                '    </tr>';
            html = html + '<tr><td>' + game.id + '</td>\n' +
                '        <td>' + game.name + '</td>\n' +
                '        <td>' + game.price + '</td>\n' +
                '        <td>' + game.description + '</td>\n' +
                '        <td>' + game.releaseDate + '</td>\n' +
                '        <td>' + game.rating + '</td>\n' +
                '        <td>' + game.picture + '</td>\n' +
                '        <td><button onclick="deleteGame(' + game.id + ')">Удалить</button></td></tr>';
            document.getElementById("games_list").innerHTML = html;
        }
    };
    xhttp.open("GET", "http://localhost:8080/games/findByName?name=" + name, true);
    xhttp.send();
}

function resetSearch() {
    document.getElementById("search_field").value = "";
    loadGames();
}

loadGames();//запускаю функцию после всех функций