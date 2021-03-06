# language: ru

Функция: Сортировка игр по цене

  Контекст:
    Дано пользователь открывает сайт

  @success
  Сценарий: Успешная сортировка игр в каталоге по цене сначала дорогие
    Дано каталог отсортирован не по цене
    Когда пользователь нажимает кнопку "Отсортировать по цене"
    Тогда каталог отсортирован по цене сначала дорогие

  @success
  Сценарий: Успешная сортировка игр в каталоге по названию сначала дорогие
    Дано каталог отсортирован по цене сначала дешевые
    Когда пользователь нажимает кнопку "Отсортировать по цене"
    Тогда каталог отсортирован по цене сначала дорогие

  @success
  Сценарий: Успешная сортировка игр в каталоге по цене сначала дешевые
    Дано каталог отсортирован по цене сначала дорогие
    Когда пользователь нажимает кнопку "Отсортировать по цене"
    Тогда каталог отсортирован по цене сначала дешевые
