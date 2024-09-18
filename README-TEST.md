# Cucumber + Selenium + Allure (Swag Labs Shop) 
# (Домашнее задание 14)
Этот проект содержит автоматизированные тесты для интернет-магазина [Sauce Demo](https://www.saucedemo.com/), выполненные с использованием Selenium и TestNG. Тесты покрывают такие важные функциональности, как авторизация, добавление/удаление товаров из корзины, оформление заказа, а также проверка подтверждения покупки.

## Начало работы
### 1. Клонирование репозитория

Для начала клонируйте репозиторий с домашним заданием на локальную машину:
https://github.com/JAVA-QA-AUTO-UA-RB/3-cucumber-selenium-allure-swag-labs-shop-IrinaPleshakova

### 2. Открытие в IntelliJ IDEA
Откройте проект в IntelliJ IDEA для работы с кодом и тестами.

#### Требования

Перед запуском тестов убедитесь, что на вашем компьютере установлены:

- Java JDK 11 или выше
- Apache Maven 3.6 или выше
- Браузер (Chrome)

## Зависимости
Проект использует следующие зависимости:
1. Selenium Java - Версия 4.24.0
2. WebDriverManager - Версия 5.9.2
3. TestNG - Версия 7.9.0
4. Log4j - Версия 2.20.0
5. Cucumber - Версия 7.16.0
6. Allure Cucumber JVM Adapter - Версия 2.20.1
Эти зависимости указаны в pom.xml и будут автоматически загружены при сборке проекта с помощью Maven.

## Структура проекта
```shell
3-cucumber-selenium-allure-swag-labs-shop-IrinaPleshakova/CUCUMBER_HOMEWORK_TEMPLATE
├── allure-results/
├── logs/
├── src/
│   └── test/
│       └── java/
│           └── org.example
│           |   └── pages
│           |   |   ├── CartPage.java
│           |   |   ├── CheckoutPage.java
│           |   |   ├── LoginPage.java
│           |   |   ├── OrderConfirmationPage.java
│           |   |   ├── ProductDetailsPage.java
│           |   |   └── ProductsPage.java
│           |   └── runners
│           |   |   └── TestRunner
│           |   └── steps
│           |   |   ├── CatalogSteps
│           |   |   ├── CheckoutSteps
│           |   |   └── LoginSteps
│           |   └── utils
│           |       ├── Hooks
│           |       └── WebDriverManager
│           └── resources
│               └── org.example
│               |   ├── swag_labs_catalog.feature
│               |   ├── swag_labs_checkout.feature
│               |   └── swag_labs_login.feature
│               └── log4j2.xml
├── pom.xml
├── README_TEST.md
├── README.md
└── testng.xml
```

### Описание папок и файлов:
- pages/: Содержит классы Page Object Model (POM), такие как CartPage, CheckoutPage, LoginPage, ProductsPage и OrderConfirmationPage. Эти классы инкапсулируют веб-элементы и действия для взаимодействия с различными частями приложения.
- steps/: Содержит определения шагов для тестов, написанных с использованием Cucumber, такие как CatalogSteps, CheckoutSteps и LoginSteps.
- runners/: Содержит класс TestRunner, который отвечает за выполнение сценариев тестов с использованием TestNG и Cucumber.
- features/: Содержит .feature файлы Cucumber, которые описывают поведение приложения на языке Gherkin.
- pom.xml: Конфигурационный файл Maven с зависимостями проекта.
- testng.xml: Конфигурационный файл TestNG для запуска тестов.

## Запуск тестов

Для выполнения тестов используйте команду: `mvn clean test`

## Пример вывода в консоли
Если тесты прошли успешно, вы увидите следующий вывод в консоли:

```shell
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 6.542 s -- in TestSuite
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.516 s
[INFO] Finished at: 2024-09-18T17:23:56+02:00
[INFO] ------------------------------------------------------------------------
```

## Отчетность с Allure
Для генерации отчета с использованием Allure, выполните следующие шаги:
1. После завершения тестов сгенерируйте отчет с помощью команды: `mvn allure:serve`
2. Отчет будет доступен по локальному адресу.