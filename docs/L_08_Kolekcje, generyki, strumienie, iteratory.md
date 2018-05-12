### Operacje wejścia wyjścia

Czytanie danych z czegokolwiek, niekoniecznie z dysku.

Najprościej z dysku, klasa File:
`Class File("D:\\data.txt")`

Generalnie za odczytywanie danych odpowiadają strumienie (_stream_)
Większość klas od razu podzielono na czytające (_reader_) i piszące (_writer_). Związane są tylko z obsługą plikową na dysku.
- filereader, filewriter -> czytają i zapisują na bieżąco na dysku. Czyli odpalają operacje dyskowe i dopiero wykonują różne czynności; Generalnie nieefektywne, ale jak zwykle to zależy;
- bufferedreader, bufferedwriter -> zapisuje i odczytuje paczkami;
- jest tego więcej;

Do obsługi wyższego poziomu abstrakcji niż pliki są strumienie (_stream_), kanały (_channels_);

_YELD_: Można utworzyć symulowany plik w pamięci, który jeden proces czyta a drugi proces pisze.

Wszystkie można odczytywać, zapisywać i tworzyć.

Operacje:
- sekwencyjne - dostęp do każdego elementu po kolei; koszt dotępu do list i tablic jest niemal równy;
- random access - o swobodnym dotępie. Otwieramy plik i będziemy pisać / czytać od dowlonego miejsca; Czyli dostajemy dostęp do dowolnego elementu. Dostęp do tablic jest dużo mniej kosztowny niż do listy;

Większość działań dotyczy dostępu sekwencyjnego. Wyłącznie o nim będzie mówione.

Są różne strumienie. Do wczytywania stringów, obiektów i innych.
- serializable - zamiana na strumień bajtów. "Ala" to 3 znaki. Wczytujemy bajt po bajcie.
- obiekty też można serializować (object stream).
```JAVA
Person {
int Age;
String name;
```
-> 273ADA -> czyli najpierw int 27, potem 3 czyli informacja ile znaków ma drugi argument, potem drugi argument;
- przy serializacji pamiętać o kolejności bajtów na rzeczach większych niż jednobajtowe; obiekt wczytany na jednym komputerze może być odczynany na innym gdzie inaczej odczyta bajty (small endian, big endian);
- na dzisiaj wczytujemy tylko do stringów.
- w javie każdy znak jest dwubajtowy;
- dla małych plików jest też metoda readAllLines, tylko trzeba sprawdzić jak się otwiera małe pliki;;

Czytanie plików:
- `System.out.println(f.canRead());` - tak NIE robimy; nie ma sensu sprawdzać czy plik można przeczytać, czy jest, itd, bo między sprawdzeniem a następnymi instrukcjami coś może zadziać się z plikiem; pliki otwierać i jeśli nie ma to rzucić wyjątkiem;
- w różnych systemach są różne symbole na koniec linii; jeśli wczytuje cały plik do jednej linii, to jest zły znak końca linii;
    - windows: \n (0x0D), \A (0x0a);
    - linux: \n;
    - mac: \a;

Istrukcja try z zasobami `try() {}` -> pozwala na automatyczne zamykanie otwartych plików; są intrukcje wykonywane niezależnie od złapania wyjątków, bo jest wykonywany po całym chronionym bloku;

---

### Kolekcje

> Występują w każdym języku programowania wyższym niż Asembler

Kolekcje - struktury danych na duże cosie;

Kolekcja to różne interfejsy do różnych implementacji.

Zbiory bytów zazwyczaj takiego samego typu. A raczej zbiory referencji do bytów.

- **lista** (_list_);
- **zbiór** (_set_)
- **kolejka** (_queue_) -> fifo (_first in first out_), lifo (_last in first out_);
    - kolejka priorytetowa;
- **mapa** (_map_) - zawiera dane różnego typu; tablica heszująca; indeksem nie jest liczba, tylko pierwsza zmienna w parze;

Do programowania wielowątkowego są zupełnie inne kolekcje o innych nazwach i cechach;

**Zbiór** (_set_):

Zbiory są rzeczy różnych. Włożenie drugiej takiej samej rzeczy nie spowoduje, że się pojawi.

`Set <Integer> set = new HashSet<> ();`

`new HashSet<>` -> `<>` na końcu to takie prymitywne auto; na początku jest Integer, więc kompilator się domyśli, że pod drugiej stronie podstawienia też ma być Integer;

- _TreeSet_ - zapewnia kolejność elementów w zbiorze; jeśli włożymy 1, 7, 2, to wyjmiemy 1, 7, 2. Powolne.
- _HashSet_ - jeśli włożymy 1, 7, 2, to diabli wiedzą w jakiej kolejności wyjmiemy. Ale działa szybko.
- _LinkedHashSet_;

**Lista** (_list_):

`List<Integer> = new ArrayList<> ();`

- _ArrayList_ - jak zwykła tablica, tylko można na niej użyć resize;
- _LinkedList_ - każdy element zawiera adres w pamięci do kolejnego elementu;;
- _Vector_ - nie używać!;

**Mapa** (_map_):

- większość map bazuje na funkcji heszującej;
- mapy nie są ograniczone typami, zarówno indeksem jak i wartością może być cokolwiek - obiektem klasy, kolekcją, itd.;
    - `Map<String, Person>`
    - `Map<Person, List<Person>>`
    - istotne jest tylko to, żeby funkcja heszująca `Person` działała sprawnie i zwracała różnej wartości;

---

### Typy generyczne (czyli templejty)

W javie parametrem nigdy nie jest typ, tylko obiekt pewnego typu.
W deklaracji parametru metody musi być zdeklarowany typ.
Nie można zrobić ogólnej funkcji minimum, trzeba stworzyć oddzielną funckję dla intów, longów, itd.

Ale można zrobić template!
To znaczy można zrobić klasę która zawiera metodę;

```JAVA
class Generic1 <T> {
    void printTxt (T a) {
        System.out.println(a);
    }
}
```

```JAVA
class Generic2 <T extends Comparable> {
    T min (T a, T b) {
        return a.compareTo(b) < 0 ? a : b;
    }
}
```

Tutaj musi być `extends Comparable`, bo dalej lecimy porównywaniem.
`a.compareTo(b) < 0` bo compareTo zwraca -1, 0 lub 1;

Metodę template można też stworzyć:
```JAVA
<T extends Comperable> T min (T a, T b) {
    return a.compareTo(b) < 0 ? a : b;
}

Wywołanie:
Integer b = Main1.<Integer>min(1, 2);   Main1in1
```

---

### Operacje na Stringach

Stringi są obiektem.
String może być null. Null to nie jest pusty string, tylko brak referencji do czegokolwiek. Stringi porównujemy przez .equals()!

Stringi składają się z pojedynczych znaków, każdy znak to dwa bajty.
Stringi w javie niekoniecznie przenoszą dobrze znaki ze wszsytkich języków.
String jest w środku immutable. Można stworzyć nowy string. Nie ma żadnych operacji modyfikowania  istniejących Stirngów. Każdy String tworzymy przez NEW!
JVM początkowo alokuje kilka defaultowych stringów, między innymi pusty string, dlatego porównanie do pustego stringu może się udać.

"dowolny tekst" jest już literałem stringu. Można na nim stosować metody klasy String.

String jest final, nie można dziedziczyć pod klasie String.

`.compareTo()` jest nieoczywite. Zwraca -1, 0, 1. Sortuje w zależności od stosunku do początku alfabetu ale w różnych językach może być różna kolejność alfabetu.
- jakby co, to jest bardzo silna biblioteka _ICU_, która zawiera wszystkie języki wszechświata;

`.indexOf()`

`.isEmpty()` jest ładniejsze niż `if (txt.length() = 0)`

`.matches()` do porównwanie regExów;

`.replace()` zmienia chary, zwraca string;

Stringi implementują:
- Serializable;
- Comparable;
- CharSequence;


---

Interfejs generyczny, czyli parametryzowany po typie T:
```JAVA
@FunctionalInterface
public interface ICalculator<T> {
    T calc(T a, T b);
}
```

---

### Iteratory

- `i` w pętli iterującej wywodzi się od Fortranu: tam zmienne i, j, k, l, m były z definicji integerami;

Niby można iterować klasycznie: `for (int i = 0; i < 10; ++i)` ale to jednak nie wypada

Dla wszystkich kolekcji:

- >> efekt zmiany kolekcji po której iterujesz jest nieokreślony;

- **pętla `for : `**
    ```JAVA
    collection <abc> col {
        for (abc item : col) {
            // jakiś kod;
        }
    }
    ```
    - tworzy itemy pod które podstawia kolekcje;
    - **służy wyłącznie do odczytu kolekcji**;
    - nie można zmodyfikować kolekcji, ona jest niezmienna;
    - **dostaje się referencję do każdego elementu kolekcji**;
    - ten item jest lokalną zmienną; to jak z funkcją: funkcja dostaje parametr który jest lokany, on coś robi z funkcją, ale oryginał funkcji jest niezmienny;


**Iteratory po kolekcjach:**
- są w każdym języku;
- niby można tworzyć nową kolekcję na podstawie tej po której iterujemy (koszt niewielki, bo to jak wszystko jest współdzielone), ale po co?
- więc są iteratory po kolekcjach, tak, żeby jedna można było modyfikować kolekcję po której iteruemy;

```JAVA
Collection<String> list = new ArrayList<>();

    list.add("ala");
    list.add("ma");
    list.add("kota");
    list.add("ada");
    list.add("też");
    list.add("chce");
    list.add("kota");

Iterator<String> it = list.iterator();
```
Tu jest iterator po Stringach, bo kolekcja jest stringów, to po czy innym iterować?

Ten iterator jest silniejszy od tego z `for :`, bo wskazuje na kolejne elementy w kolekcji po której iterujemy;
- na początku ustawia się przed 0 elementem kolekcji;
```JAVA
while (it.hasNext()) {
    String s = it.next();`
}
```
- w tym momencie zmienna String s jest tym po czym iterujemy;
- iterowanie jest wbudowane w iterator a nie w kolekcję;
- teraz można zrobić: `it.remove`;
 -