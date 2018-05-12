**Wszystko co jest static należy do klasy, wszystko co nie jest static należy do każdego obiektu klasy.**

---

### Bloki statyczne i inicjalizujące

`int q1` - deklaracja zmiennej;

`int q2 = 100` - to jest deklaracja i definicja zmiennej z kawałkiem _run time_;


Tak się nie wykona:
```JAVA
public class TestClass {
    public void fun() {
        // TODO
    }
    Integer q1;
    Integer q2 = 100;
    System.out.println("test");
}
```

```JAVA
public class TestClass {
    public void fun() {
        // TODO
    }
    Integer q1;
    Integer q2 = 100;
    {
        System.out.println("test");
    }
}
```
Żeby się wykonało, to co ma się wykonać przed konstruktorem trzeba wziąć w klamerki. To się nazywa **blok inicjalizujący**.

**Blok statyczny:**
- należy do klasy;
- wykona się tylko raz, w przypadku pierwszego odwołania się do klasy;
- z bloku statycznego możemy odwoływać się tylko do statycznych pól oraz metod;

**Blok inicjalizujący (instancyjny):**
- należy do obiektu;
- wykona się w ramach każdego new, jako pierwsze;
- wykona się przed konstruktorem:
    - konstruktor nadklasy -> blok inicjalizujący podklasy -> konstruktor podklasy;

---

### Modyfikatory dostępu

`Public, protected, private`

Modyfikatory dostępu - słowa kluczowe które mają wpływ na widoczność elementu ktre poprzedzają.

Zmienne nie powinny być publiczne. Używamy protected i private, udostępniamy getterami i setterami.

> Public jest jak dom publiczny, każdy może skorzystać.

- _Public_ - każdy;
- _Protected_ - obiekt, obiekty klas potomnych i wszystkie klasy w pakiecie;
    - przez to, że `protected` jest też do pakietów, korzystać ostrożnie!
    - używać w testach, poza tym lepiej nie tykać;
- _Private_ - tylko obiekty klasy;

`Final` - żeby uniemożliwić przedefiniowanie metody (przy dziedziczeniu;)

**Mechanizm refleksji** - klasa może się dowiedzieć o tym jak jest skonstuowana sama ona, lub dowolna inna klasa
- również o tym czy inne pola są private i final;
- w efekcie można zmienić wartość innego pola, także prywatnego i final;
- pozwala na dostęp do dowolnego elementu klasy pomijając modyfikator dostępu;
- zarezerwowana dla zaawansowanych twórców frameworków którzy wiedzą co robią i nie zepsują tego co zmieniają;
- słowem: nie dotykać;

---

### Logger

`System.out` jest przereklamowany
- wydrukowanie w konoli i wczytanie przez konsolę jest kosztowne;
- więc każde `System.out` i `System.in` jest kosztowne!
- wykorzystanie `System.out` do sprawdzenia aktualnej wartości zmiennych i stanu w którym znajduje się aplikacja jest bez sensu;
- sprawę rozwiązano loggerami.

Logi [`logger`] - do szeroko rozumianego przepływu informacji.
- do zapisu aktualnej wartości poszczególnych zmiennych i obiektów;
- do komunikatów o błędach;
- do informacji o zdarzeniach mających miejsce w trakcie działania aplikacji;

`Logger` - posiada metody, które tworzą logi i nadają im odpowiedni priorytet:
- nie są prostackie same w sobie;
- troche jak view w VMC;
- o ile biblioteki Javy są napisane dobrze, to loggery są napisane jeszcze lepiej; 
    - są mega stabilne -> w testach nawet nie trzeba sprawdzać czy logger przechodzi, logger przechodzi zawsze;

Loggery mają priorytety (poziomy logowania). W różnych wariantach, zwykle są:
- FATAL;
- ERROR;
- WARN;
- INFO;
- DEBUG;
- TRACE;
- ALL / OFF;
- w niektórych bibliotekach (Log4J) można definiować własne poziomy;

Loguje się wybrany poziom i wszystkie wzwyż.

```JAVA
import org.junit.Test;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logowanie {
    @Test
    public void LoggerTest_01() {
        Logger
                .getAnonymousLogger()
                .log(
                        Level.INFO,
                        "to jest w logu");
    }

    @Test
    public void LoggerTest_02() {
        Logger myLogger = Logger.getLogger(Logowanie.class.getName());

        myLogger.log(Level.INFO, "to jest w logu");
        myLogger.log(Level.INFO, "to też jest w logu");
    }

    static private Logger logger = Logger.getLogger(Logowanie.class.getName());

    @Test
    public void LoggerTest_03() {
        logger.log(Level.INFO, "to jest w logu");
        logger.log(Level.INFO, "to też jest w logu");
    }

}
```

---

### Programowanie apsektowe

**Programowanie apsektowe**:
- paradygmat wspomagający separacje zagadnień;
- rozdzielenie programu na części w jak największym stopniu niezwiązane funkcjonalnie;
- jak wszystko inne wymyślono w Xerox ;)

**AspectJ** - aspektowe rozszerzenie Javy:
- generalnie w Javie podstawową jeddnostką jest klasa;
- AspectJ wprowadza nową jednstkę - aspekt;
    - aspekt opisuje zagadnienie które przecina więcej niż jedną klasę;
