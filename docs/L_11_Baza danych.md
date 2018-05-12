### Maven

Maven jest sytemem do budowania projektów w Javie.

Takich systemów jest więcej:
- Maven (współczesny i aktualny), standard;
- Ant, obecnie AntYczny;
- Gradle, się przebija;

O tym że są na razie wiedzieć, będzie o tym później

Co robią:
- dbają o wszystkie biblioteki; wsadzą w dobre miejsce i zadbają o projekt tak, żeby dało się ich używać;
- pozbierali wszystkie biblioteki javy z całego świata i mają; za darmo;
- jabyśmy chcieli kiedyś oderwać program od InteliiJ to właśnie przez coś takiego; zamienia na binaria .jar i można odpalić program gdzieś indziej;

---

### Komunikacja z bazą danych

JPA [_Java Persistence API_]
    - standard mapowania obiektowo-relacyjnego;
    
JPA jest definicją co ma się spełniać dla komunikacji z bazą danych

Dwa popularne frameworki do komunikacji z bazą danych:
- hibernate;
- mybatis;

Kontaktują się przez różne sterowniki
    - my użyjemy JDBC (Java Database Connecting) do MySQL: `JDBC:MySQL://`
    - JDBC:MySQL://LOCALHOST:3089//HOMEWORK
            - URL zapis: _protokół_ [https://] _user;pass@serwer_ [api.um.warszawa.pl] zasób (pełna ścieżka) [ /api/action/wsstore_get/ parametry [?id=c7238cfe-8b1f-4c38-bb4a-de386db7e776&apikey=c4bb1fa5-5601-4f2d-8ced-03c57358499e]
              wszystko oprócz protokołu jest opcjonalne
              ścieżka: rozdzielana /
              parametry:
              - pierwszy zaczyna się od „?”;
              - zawierają „=”;
              - jeśli więcej niż jeden rozdzielamy „&”;

Programiści Javy wymyślili sobie język do obsługi baz danych: JPQL
 >> Różnica między JPQL a SQL jest taka jak między językiem polskim a gwarą warszawską: jest dołożone słowo "kurwa"
 
**DTO** [_Data Transfer Object_] - antywzorzec, ale nie ma lepszego, więc będziemy używać
- do przesyłania danych między różnymi systemami;
- to ta generowana automatycznie klasa (_SimpleEntity.java_) w której jest opis tego co importujemy;
- DTO powinno być tak szczupłe jak to możliwe, więc zwykle tak szczupłe jak szczupła jest tabela z której pobierane są dane;
- w teorii powinno się pobierać tylko te elementy tabeli któe nas interesują, ale pobranie wszystkiego jak leci nie jest bardzo dużym błędem;
- dane należy zwalniać wtedy kiedy tylko jest tylko możliwe;

**ORM** [_Object Relational Mapping_]
- jak są odwzorowywane dane z bazy danych w aplikacji;

_hibernate.cfg.xml_ 
- zawiera plik konfiguracyjny;
- to jak w Maszynie Stanów Skończonych - robimy plik .jar i dołączamy dla niego .xml z konfiguracją i będzie działać;
 
**Pula połączeń** [_connection.pool_size_]:
- otwieranie sesji połączeń z bazą danych jest czasochłonne;
- rozwiązanie:
    - system z aplikacją tworzy w sobie pulę połączeń z bazą danych i ją w sobie trzyma;
    - jeśli procedura potrzebuje się połączyć z bazą danych, to tylko pobiera połączenie z już puli otwartych połączeń;
- stosowane w dużych aplikacjach: tam gdzie koszt stworzenia zasobu jest dużo większy niż koszt wykorzystania zasobu;
- może być tak, że nawet koszt pobrania pamięci może być duży, wtedy program może zająć pamięć na początku działania i potem działać na zarezerwowanej pamięci;
    - wtedy zużycie pamięci w czasie działania programu się nie zmienia - odpalają się nowe zadania, ale wszystko w ramach już zajętej pamięci;
    - dlatego trzeba zwalniać zasoby i pamięci najszybciej jak tylko się da;
- profilowanie konfiguracji i rezerwowanie wielkości puli pamięci jest zadaniem trudnym;

**Cache**:
- catche to zapamiętanie danych w pamięci podręcznych;
- nie można wierzyć, że ta infromacja jest wiecznie żywa;
- daje zyski na wydajności, w sposób znaczny;
- jak są zyski na wydajności, to kosztem spójności danych;
- jeśli nie korzystamy z cache, to za każdym razem pobieramy dane z bazy danych, zawsze są aktualne, ale trzeba je pobierać, a to zmniejsza wydajność;
- przy cache zapisujemy dane w pamięci podręcznej i na nich działamy, ale dane mogą się zmienić w międzyczasie;

`Hybaernate` wprowadził dwa poziomy cachowania:
- dla każdego usera zapisuje się osobny cache - to jest cache pierwszego poziomu;
- ale jeśli jeden użytkownik pobrał cache, to drugi już ma to jest cache drugiego poziomu;
- różne dane można pobierać z różnego poziomu cachowania, albo w ogóle bez niego;
