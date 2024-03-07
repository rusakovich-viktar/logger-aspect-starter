# LOGGER-ASPECT-SPRING-BOOT-STARTER

Проект представляет собой Spring Boot Starter, который включен в другие микросервисы как зависимость.
При сборке данного проекта он автоматически публикуется в локальный репозиторий .m2.

Является частью общей системы
- [ News Management System](https://github.com/rusakovich-viktar/news-management-system/tree/develop)

Задача данного стартера - перехватывать request и response контроллеров, и логировать их в файл с выводом на консоль.


Для этого используется аспектно-ориентированный подход, при котором запросы и ответы от контроллеров перехватываются и добавляются в логи.
Для непосредственного логирования используется logback.


Вот как это выглядит в запущенной программе:

![docker](https://github.com/rusakovich-viktar/NMS-resourses/raw/rusakovich-viktar-patch-1/aop_logger.jpg)

и 

![docker](https://github.com/rusakovich-viktar/NMS-resourses/raw/rusakovich-viktar-patch-1/aop_com.jpg)

Стартеры используются для удобства подключения однообразного кода с оттестированной логикой к проектам.