# language: ru

Функция: Фильтрация игр по разработчику

  @success
  Сценарий: Успешная фильтрация игр в каталоге по разработчику
    Дано пользователь открывает сайт
    Когда пользователь выбирает значение "Название разработчика" для фильтрации из выпадающего списка
    Тогда каталог фильтруется по значению "Название разработчика"

  @fail
  Сценарий: Фильтрация игр в каталоге по разработчику - в каталоге нет игр данного разработчика
    Дано пользователь открывает сайт
    Когда пользователь выбирает значение "Название разработчика" для фильтрации из выпадающего списка
    И в каталоге нет игр разработчика "Разработчик"
    Тогда отображается надпись "Список пуст"