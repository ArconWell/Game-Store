# language: ru

Функция: Поиск игры по названию игры

  Контекст:
    Дано пользователь открывает сайт
    И пользователь вводит "Название игры" в строку поиска

  @success
  Сценарий: Успешное нахождение игры в каталоге
    Дано пользователь нажимает кнопку "Найти"
    Когда игра "Название игры" есть в каталоге
    Тогда игра "Название игры" отображается пользователю

  @fail
  Сценарий: Нахождение игры в каталоге - игры нет в каталоге
    Дано пользователь нажимает кнопку "Найти"
    Когда игра "Название игры" отсутствует в каталоге
    Тогда отображается надпись "Список пуст"