# HR Calendar

## Модули
* common-module - модуль для размещения общих ресурсов сервисов, таких как перечисления, утилитные классы для работы с датой-временем и т.д.
* db - директория для размещения всего, что связано с БД (миграции liquibase, скрипты sql, скрипты для наката миграций, и т.д.).
* hr-calendar-service - модуль основного сервиса приложения, предоставляющий api для пользователей hr и соискателя.
* microsoft-integration-service - модуль сервиса для интеграции с сервером Microsoft Exchange.
* security-service - модуль сервиса идентификации, аутентификации и авторизации.


## Запуск сервиса регистрации
* в корневой директории выполнить docker-compose up
* endpoint: POST http://localhost:8085/registration/ принимает json:
{
"email" : "myemail",
"password" : "mypassword"
}
* возвращает строку либо добавлен, либо пользователь с таким мылом уже существует