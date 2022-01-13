# language: ru

Функция: Сортировка игр по названию

  Контекст:
    Дано пользователь открывает сайт

  @success
  Сценарий: Успешная сортировка игр в каталоге по названию с начала алфавита
    Дано каталог отсортирован не по названию
    Когда пользователь нажимает кнопку "Отсортировать по названию"
    Тогда каталог отсортирован по названию с начала алфавита

  @success
  Сценарий: Успешная сортировка игр в каталоге по названию с начала алфавита
    Дано каталог отсортирован по названию с конца алфавита
    Когда пользователь нажимает кнопку "Отсортировать по названию"
    Тогда каталог отсортирован по названию с начала алфавита

  @success
  Сценарий: Успешная сортировка игр в каталоге по названию с конца алфавита
    Дано каталог отсортирован по названию с начала алфавита
    Когда пользователь нажимает кнопку "Отсортировать по названию"
    Тогда каталог отсортирован по названию с конца алфавита