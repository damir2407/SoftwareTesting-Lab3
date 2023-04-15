# Лабораторная №3 - по предмету "Тестирование программного обеспечения"
## Задание
Сформировать варианты использования, разработать на их основе тестовое покрытие и провести функциональное тестирование интерфейса сайта (в соответствии с вариантом).

### Вариант: https://simpleswap.io/

### Use-case диаграмма
![case](https://user-images.githubusercontent.com/70958074/232221165-7bda32c2-8a74-4096-8056-8f3f4b148c81.png)


### Требования к выполнению работы:
1. Тестовое покрытие должно быть сформировано на основании набора прецедентов использования сайта.
2. Тестирование должно осуществляться автоматически - с помощью системы автоматизированного тестирования [Selenium](http://docs.seleniumhq.org/).
3. Шаблоны тестов должны формироваться при помощи Selenium IDE и исполняться при помощи Selenium RC в браузерах Firefox и Chrome.
4. Предполагается, что тестируемый сайт использует динамическую генерацию элементов на странице, т.е. выбор элемента в DOM должен осуществляться не на основании его ID, а с помощью [XPath](http://ru.wikipedia.org/wiki/XPath).


## Полезная информация
+ [JUnit 5](https://www.baeldung.com/parameterized-tests-junit-5)
+ [Selenium Java](https://habr.com/ru/post/502292/)