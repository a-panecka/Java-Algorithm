> Generalnie programy powinny się kompilować.

_EDIT:_
>> Generalnie programy powinny się kompilować i co do zasady powinny się kończyć, ale w zasadzie niekoniecznie.

### Typy danych

Java jest językiem z silnym typowaniem danych. Każda zmienna musi mieć zadeklarowany typ danych.

Typy danych:
- do liczb całkowitych
    - `int`, `long`, `short`, `byte`;
    - w żadnym nie ma wersji `unsgined`;
    - c++ zmienia zakres inta w zależności od procesora, w javiezakres inta jest stały;
- do liczb rzeczywistych
- do wyrażeń logicznych
- do znaków w Unicode:
    - `char`;

---

### Typy zmiennych

Klasa – zestaw danych i metod do operowania na nich

Wszystkie klasy wywodzą się z klasy _Object_ → dziedziczenie! Tylko po polach public
```JAVA
class NewCoord extends Coord {
    double z;
}
```

Obiektowe typy zmiennych są klasami, więc z wielkiej!
`String token = "Hello!";`

Proste typy zmiennych: z małej!
int, long, double, float, char, boolean

Każda klasa reprezentującą klasę jest zrobiona dokładnie tak samo:
```JAVA
class Long {
    private final long value;           // tutaj jest wewnętrzny, prosty long
    public getLong;                      // (albo getValue, nie ma znaczenia) zwracającą wartość ze środk;
    public setLong;
}
```

Używanie zmiennych obiektowe jest budowane w język. Kompilator działa na zasadzie:
```
Long l = 123L;
    l.setValue(123);

// albo raczej:

Long newL = new Long (123L);        // to jest boxing
    newL = 17;

long a = newL;                      // to jest unboxing
    a = newL.getValue();
```

_boxing_ i _unboxing_ jest kolejną operacją którą trzeba wykonać. Dlatego w niektórych sytuacjach nie używać zmiennych obiektowych.
- w pętli obowiązkowo mały int, po co za każdym razem tworzyć nowy obiekt i go rozpakowywać.
- w pozostałych miejscach w zasadzie jeden pies, chociaż programiści javy lubią obiekty;
- w kontenerach używamy dużych Integerów:
    - int[17] x - tutaj mały int bo to tablica;
    - new Array <Integer> - tutaj duży Integer, bo kontenery przechowują obiekty;

**Zmienne obiektowe (czyli klasy) mogą mieć w sobie _null_!**
Mały int może mieć w sobie 0, duży Integer może być 0 albo null.
_Boolean_ może mieć trzy wartości: _true_, _false_, _null_. A raczej jest _null_ albo _not null_. A jeśli jest _not null_ to może być _true_ albo _false_.
_boolean_ może być tylko _true_ albo _false_;

Zmienne proste porównujemy przez _==_
Zmienne obiektowe porównujemy metodami, nie przez _==_. Czasami się uda, ale nie zawsze.

```JAVA
Long a1;
Long a2;
if (a1.equals(a2)){
    //jakiś kod;
}

long b1;
long b2;
if (b1 == b2) {
    //jakiś kod;
}
```

Deklaracja nowych zmiennych. Oba zadziałają, ale pierwszy lepszy: W nim kompilator ma szansę na optymalizację - pobiera dane z puli już wstępnie utworoznych obiektów.
```JAVA
Long x = 7L;
Long y = new Long(7L)
```

Tak nie robimy:
```JAVA
Integer x = new Integer (1500);
Integer y = new Integer (1500);

if (x == y) {
    System.out.println ("OK");
    }
```
Nie zadziałało, bo na heap powstały dwie zapakowane (boxing) zmienne, których zawartość jet sobie równa, ale przez _==_ przekazujemy referencję a nie wartość.

---

### immutable vs mutable

`final int value = 3`

```JAVA
class Person {
    String name;
    String surName;
    private final long pesel;

    getPesel();
    setPesel();  // no tak się nie da, pesel jest final! po to jest final, żeby go nie zmieniać;
```

Żeby teraz dało się zmienić pesel trzeba stworzyć nowy obiekt!
```JAVA
Person orgPerson = new Person("Jan", "Kowalski", 123);
Person nextPerson = new Person(orgPerson.getName(), orgPerson.getSurName(), 456);
```

Stary obiekt, nigdzie nieużywany zostanie w końcu sprzątnięty przez _garbage collector_. Tworzyć nowe obiekty, nie przejmować się starymi.

Zamiast getterów można tworzyć metody, które tworzą nowe obiekty na podstawie starych obiektów:
- refleksja pozwala zawiesić na chwilę final i zmianić wartość. Można, ale posypie się cała optymalizacja. Nie robić.

---

### .toString()
Do zmiennych dziedzczących z klasy (obiektowych)
To metoda dziedzicząca po klasie _Object_, więc na prostych zmiennych nie zadziała:

```JAVA
int x = 1500;
System.out.println(x.toString());
```

W każdym print zachodzi niejawne użycie metody .toString(). Ale najpierw zachodzi wypakowanie (unboxing) i tam leci metoda .getValue(). Więc najpierw zsumuje wartości jeśli się da, a dopiero potem zrobi .toString().

```JAVA
Integer x = 15;
Integer y = 4;
System.out.println(x + y);      // tutaj najpierw zrobił niejawnie x.getValue() + y.getValue(), dało się zsumować więc zsumował, a dopiero potem zrobił suma.toString() i to wydrukował
    // wydrukuje 19
System.out.println(x.toString() + y.toString());
    // wydrukuje 154
```

---

### Jak porównywać obiekty

Dwa rodzaje porównań:
- _shallow_ (płytkie): mamy dwa czarne koty. Oba są czarne i są kotami, więc są takie sam.
- _deep_ (głębokie): mamy dwa czarne koty. Oba są czarne i są kotami, ale jeden jest wredny, a drugiemu upierdoliło łapkę. Są różne.

```JAVA
public boolean equals (Object o) {
    if (this == o) return true; // tutaj porównujemy ==, bo prawdzamy czy wkazujemy na tą samą referencję. Jeśli referencja jest ta sama, to wskazujemy na ten sam obiekt o który pytamy (czyli wskauzjemy dwukrotnie na ten sam obiekt). No jeśli wskazujemy na to samo o co pytamy, to nie ma wyjścia, muszą być sobie równe
    if (!(o instanceof Person)) return false // instaneof -> to jest pytanie, czy mogę stworzyć jeden obiekt z drugiego. Jeśli nie mogę, to nie ma szansy, żeby były równe.
    // możliwe, że raczej powinno być: if ((this instanceof o) && (o instanceof this)) return true; pytanie czy relacja porównania powinna być zwrotna i symatryczna
    return name == person.name && // a tutaj porównujemy poszczególne pola obiektów;
        Object.equals(surName, person.surName) &&
        Object.equals(pesel, person.pesel);
}
```

---

`! (a && b) == (!a || !b)`

doczytać:
- hash;
- porównywanie przez hash;
- notifikacja;
- refleksja;

---

### Obiekty immutable
- po stworzneiu nie można ich zmienić;
- mają konstruktor;
- mają gettery;
- nie mają setterów;
- nie mają publicznie dostępnych atrybutów;
- dobrze jeśli wszystkie atrybuty są `final`;

Hasła nie przechowywać nigdy w obiektach immutable:
- nie da się usunąć starego z pamięci - wyrzuci je dopiero garbage collector;
- hasła przechowujemy tylko jako tablicę charów;
