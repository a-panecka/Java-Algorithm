### Wyjątki

> Wyjątki: coś się spieprzyło, nie działa, nie wiem co z tym zrobić, niech się ktoś tym zajmie.

**Takie bardzo silne go to z przekazaniem parametru i zamknięciem wszystkich klamer. Wielokrotny return**

Wyjątki są w każdym współczesnym języku

Zasady:
- **nie programować na wyjątkach!**;
- obsługa wyjątków jest kosztowna (pod względem pamięci i czasu);
- wyjątki są od rozwiązywania sytuacji wyjątkowych nie obsługiwać flow programu wyjątkami;
- tam gdzie potrzeba, to używać - nie próbować obchodzić na siłę;
- wyjątki pojawiają się wtedy, kiedy dane które trzeba obsłużyć nie pasują do wzorca;

Obsługa wyjątków nie powinna zajmować dodatkowych zasobów:
- wyjątki rzucane są w sytuacji kiedy coś nie działa;
- jeśli wyjątek rzucamy bo brakuje pamięci to nie używajmy więcej pamięci do obsługi wyjątku;

Czynności ryzykowne:
- nie sprawdzać przed czynnością czy się da i jeśli się nie da to rzucić wyjątek, tylko wykonać i jeśli się nie powiodło to wtedy rzucić wyjątek;
    - aplikacja ma dzielić dwie liczby: nie sprawdzać czy user wprowadził dzielenie przez zero i jeśli tak to rzucić wyjątek tylko podzielić wprowadzone liczby i jeśli jest błąd to wtedy rzucić wyjątek;
    - aplikacja ma zapisywać plik: nie sprawdzać czy jest już plik o takiej nazwie i jeśli jest to rzucić wyjątek, tylko zapisać plik i jeśli jest błąd to rzucić wyjątek;

Do zapamiętania, do implementacji, nigdy nie używać inaczej: **try, catch, throw** – spróbuj, rzuć i złap;

```JAVA
fun … () {
try {
	…throw new Exception();
}
catch ( ) {
…
}
}
```

Kolejność pułapek jest istotna. Łapie się pierwszye catch który pasuje typem do throw, ale to który z pasujących catch się złapie zależy od kolejności ich zadeklarowania;


```JAVA
fun … () {
try {
	…throw new Exception (Exc1);
}
catch (Exc2) {  //ten catch nie złapie poprzedniego throw
…
}
}
```

Wyjątki są obiektami. Więc wyjątki mogą dziedziczyć.
- `Exc2 extends Exc1`

Rzucane wyjątki potomne (try) są obsługiwane też przez pułapki (catch) na tatusia. Kolejność jest ważna!

Od miejsca zgłoszenia do miejsca wykonania wyjątku (czyli od `throw` do `catch`) nie wykonuje się nic!

```java
class Person ... {
int setPesel () {
if (pesel <0) {
    throw new ArgException();
    }
    this.pesel = pesel;
}

    Person (int pesel) {
        setPesel(pesel);
    }
}
}
```

**Konstruktor** może rzucić wyjątek! To jest jedyny sposób, żeby konstruktor powiedział, że dane które zostały do niego wprowadzone są błędne i niezgodne z deklaracją konstruktora. Można wychodzić z konstruktora wyjątkami, nie bać się tego.

### finally

```JAVA
try {
} catch (...) {
} finally {
}
```
Finally - to coś co się wykona zawsze. Nie ważne czy był catch który pasuje, czy zaszła potrzeba złapania wyjątku. Służy do zarządzania zasobami (w zasadzie chodzi o zamykanie plików).
Nie wiadomo kiedy wykona się finally. Odpali się na pewno przy najbliższym garbage collector.
Nigdy nie ma gwarancji, że metoda finally się w ogóle odpali - garbage collector odpala się kiedy kończy się pamięć, a nie zamyka program. Program może się skończyć zanim skończy się pamięć, więc wtedy się nie odpali sekcja finally.
Generalnie nie używać. Programistom Javy jest wstyd za `finally`.

### try / catch z zasobami (_with resources_)

```JAVA
File imlpements closeable // (plik musi implementować interfejs zamykalny), który musi zawierać w sobie jedną anstrakcyjnę metodę: `void close()`
File f;
try (f){
} catch (...) {
} finally {
}
```
Oznacza to na zakończenie, odpali się metoda close (był implement, więc ta metoda istnieje).
Ochronie podlega obiekt f, który na koniec zostanie zamknięty.

---

### Obsługa błędów

Wzorzec pokemon exception handling (_catch them all!_)

>>If coś tam jest not null, a nie miało być null, to znaczy, że się zjebało i nie ma co sprawdzać.

Nie ma co sprawdzać czy jest null (o ile to nie spodziewany null), to niech się wywali, rzuci wyjątkiem, uciekamy z tej sytuacji. Nie ma co łapać.
- jak jest błąd przetwarzania, to zwykle znaczy, że dane są złe, nie ma co z tym się szarpać;
- jest adnotacja @Not Null, nie ma co jej używać;



