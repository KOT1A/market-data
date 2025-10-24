# Service market-data

## Сборка проекта
Для сборки проекта используется Maven Wrapper. Это удобный способ запускать Maven, не требуя от разработчика
заранее установленного Maven. Для инициализации Maven Wrapper в проекте была выполнена команда <code>mvn wrapper:wrapper
-Dmaven=3.9.6</code>. Для запуска сервиса нужно выполнить сборку проекта командой <code>.\mvnw.cmd clean package</code>
и запустить с помощью команды <code>.\mvnw.cmd spring-boot:run</code>