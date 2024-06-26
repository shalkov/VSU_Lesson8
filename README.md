### Внедрение зависимостей в Android (DI)

Этот тестовый проект создан в рамках обучающего курса<br> <b>"Оффлайн Android школа в ВГУ 2024".</b>

В ходе урока рассмотрены различные способы внедрения зависимостей в Android приложении:

1. Рассмотрен пример написания собственного кода для реализации паттерна Dependency Injection
2. Основное внимание уделено библиотеке Hilt (обёртка над Dagger2)
3. Рассмотрены основные аннотации(@Component, @Module, @Providers, @Inject)
4. @HiltAndroidApp
5. @AndroidEntryPoint
6. @InstallIn

##### Практическая работа

1. Склонируйте репозиторий и запустите проект: https://github.com/shalkov/VSU_Lesson8
2. Изучите проект
3. Переделайте модуль RetrofitModule, чтобы он добавился в граф зависимостей Hilt
4. Можно ориентироваться по аналогии с ScheduleModule

Решение практической работы, находится в ветке <b>practice</b>