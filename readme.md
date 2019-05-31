доступ к базе изменить в src/main/resources/application.properties

по умолчанию база localhost:3306/slots
username/password root/root
перед первым запуском - создать базу
во время первого запуска создаются нужные таблицы и связи между ними
затем из папки  src/main/resources/sql_scripts/ нужно запустить скрипты по порядку:
1 и 2 , а затем в любом порядке

после запуска сервера доступны следующие запросы:

GET: "localhost:8888/slotAPI/players" - получение списка игроков:
[{"id":1,"name":"Vasya","balance":255},
{"id":2,"name":"Petya","balance":1184},
{"id":3,"name":"Olga","balance":308}]

GET: "localhost:8888/slotAPI/players/{id}/histories" - получение статистики по игроку #id:
[{"id":58,"dateTime":"2019-05-31T21:17:41","result":342,"bet":200,"slotId":1},
{"id":59,"dateTime":"2019-05-31T21:17:44","result":28,"bet":200,"slotId":1},
{"id":60,"dateTime":"2019-05-31T21:17:45","result":42,"bet":200,"slotId":1}
,{"id":61,"dateTime":"2019-05-31T21:17:46","result":142,"bet":200,"slotId":1},
{"id":62,"dateTime":"2019-05-31T21:22:07","result":142,"bet":200,"slotId":1},
{"id":63,"dateTime":"2019-05-31T21:22:17","result":142,"bet":200,"slotId":1},
{"id":64,"dateTime":"2019-05-31T21:22:19","result":514,"bet":200,"slotId":1},
{"id":65,"dateTime":"2019-06-01T00:22:30","result":114,"bet":100,"slotId":1}]

GET: "localhost:8888/slotAPI/players/{id}" - получение инфо о игроке #id:
{"id":2,"name":"Petya","balance":1184}

GET: "localhost:8888/slotAPI/slots" - получение списка слотов:
[{"id":1,"name":"slot#1"}]

 GET: "localhost:8888/slotAPI/slots/{id}" - получение списка слотов:
{"id":1,
"name":"slot#1",
 "state":["K9Q","8Q8","Q99"],     // три видимых строки барабанов 
"rails":["8KQAK8Q679J68Q8","Q9Q986KJ9QA6Q9AKQ879KA7","K9687AQ89J"], // барабаны
"patterns":["DEF","AEI","GEC","DB","HF","AB","HI"]} 

POST: "localhost:8888/slotAPI/bet/{?slot_id, player_id, bet}" - ставка на слоте slot_id игроком player_id, на сумму bet :
{"prize":114,"balance":1198,"state":["87J","KQK","Q99"]}

в таблице slot_allowed_bets храняться разрешенные ставки
в таблице slot_rails храняться конфиги барабанов
в таблице slot_state храняться текущее смещение барабанов
в таблице slot_patterns храняться выигрышные комбинации
// выигрышные комбинации - позиции закодированы:

A B C<br>
D E F<br>    
G H I<br>
//DEF средний ряд, AEI -диагональ слева вниз и т.д.
в таблице icons храняться стоимости выигрышей



