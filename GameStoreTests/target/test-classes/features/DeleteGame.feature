# language: ru

Функция: Удаление игры

  Контекст:
    Дано пользователь открывает сайт

  @success
  Сценарий: Успешное удаление игры из каталога
    Дано пользователь нажимает кнопку "Удалить игру"
    Когда пользователь нажимает кнопку "Да" на вопрос системы "Вы уверены?"
    Тогда игра удаляется из каталога
    И отображается надпись "Игра успешно удалена"

  @fail
  Сценарий: Удаление игры из каталога - пользователь передумал удалять игру
    Дано пользователь нажимает кнопку "Удалить игру"
    Когда пользователь нажимает кнопку "Нет" на вопрос системы "Вы уверены?"
    Тогда отображается надпись "Удаление игры отменено"