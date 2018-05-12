### Programowanie funkcjonalne

Języki funkcjonalne:
- funkcjonane oznacza, że wszystko jest obiektem więc funkcja też jest obiektem!
- scala i coś jeszcze;

Java nie jest do końca językiem funkcjonalnym

W c++ były funkcje, lambdy i funktory:
- funktor to klasa w której są przeciążone operatory;

W javie są funkcje i lambdy

---

### Lambda

interfejs _Predicate_ (predykat)

adnotacja _@FunctionalInterface_ oznacza, że w tej klasie jest dokładnie jedna metoda abstrakcyjna. Mogą być w interfejsie inne metody, nieabstrakcyjne, a zaimplementowane jako `default`.

Można ze wszystkim co implementuje predykat. Też z klasą albo klasą anonimową.

strzałki `->` są tylko w lambdzie, łatwo poznać

**Lambda jest anonimowym obiektem anonimowej klasy, która ma jawne metody.** Woła się obiekty z wnętrza obiektu który tą lambdę posiada.

Każde wyrażenie lambda jest instancją dowolnego interfejsu funkcyjnego (czyli takiego, który ma jedną abstrakcyjną metodę).
Lambdy bardzo dobrze pasują do klas które mają tylko jedną metodę.

Lambdy nie są tak uniwersalne jak w innych językach, ale też są fajne.

`public Predicate <Integer> tester01 = (Integer a) -> {return a >= 0;};`

a to też w zasadzie można uprościć:

`public Predicate <Integer> tester01 = (a) -> a >= 0;`

można dorzucić dowolnie wiele linijek w międzyczasie, lambda może robić więcej niż jedną rzecz. To jak metoda.

```JAVA
public Predicate <Integer> tester01 = (a) -> {
    System.out.println(a);
    return a >= 0;
};
```

Lambdy dotyczą te same obostrzenia co metod.
- lambda może być wieloparametrowa.
- może używać zmiennych, które są widzialne w momencie użycia lambdy.
- używanie zmiennych spoza parametrów: _closure_ (domknięcie);

```JAVA
Integer x = 12;
public Predicate <Integer> tester01 = (a) -> {
    return a > x;
};
```

Zmienna użyta w lambdzie musi być final, albo efektywnie być final.

W czasie run time kompilator razem z lambdą niesie informacje o pozostałych używanych zmiennych. Widoczność zmiennej jest w lambdzie.

Kiedy używać:
- do pracy z kolekcjami;
- przy pracy ze strumieniami;
- do pisania funkcyjnego;
- żeby było zwięźle;

```JAVA
public void list_remove() {
    List<Integer> list = new ArrayList<> (Arrays.asList(1, 5, 8, 2, 6)); // to tworzy nową listę z podanych elementów
    list.removeIf((a) -> a >= 3);                                        // to usuwa z listy wszystko >= 3; można tego użyć tylko dlatego, że używamy laambdy, a lambda implementuje predykat;
    System.out.println(list.toString());
};
```

---

### Interfejs funkcjnalny

Metody na funkcjch które zwracają funkcje:
```JAVA
public Function<Integer, Integer> add5 = (a) -> a + 5;
public Function<Integer, Integer> minus15 = (a) -> a - 15;

Function<Integer, Integer> total = add5.andThen(minus15);
```


**Interfejs comparator:**
- andComparing;
- comparator można sładać z comparatorów: `compareYear.andComparing(compareMotnh).andComapring(compareDay)`

---

### Strumienie

> Nie mamy ifów i switch case bo mamy polimorfizm, to nie chcemy też mieć pętli, bo po co

**Strumienie służą do przetwarzania danych.** Są po to, żeby przetwarzać wszystko sztuka po sztuce.

Można opakować praktycznie dowolny zestaw danych.

To nie są iteratory, ale podobieństwo jest daleko idące.

Do każdej kolekcji dopisano opcję przeniesienia na strumień.

Strumienie są wolniejsze niż niestrumienie.
> Nie przejmujemy się tym, tylko jak coś jest 5 razy wolniejsze, to stawiamy 5 razy silniejszy komputer

Strumienie tworzy się na kilka sposobów, można na przykład tak: `Stream<Integer> stream = new ArrayList<>(Arrays.asList(1, 5, 8, 2, 6)).stream();`

Albo tak: `Stream<Integer> stream02 = Stream.of(1, 5, 8, 2, 6);`

Iterownie po strumieniu:

`stream.forEach(s -> System.out.println(s));     // to forEach steruje tym, co wykonujemy na strumieniu`

Funkcje są obiektami, więc mamy dostęp do metody która siedzi w środku. Więc po co tworzyć zmienną `s` która nic nie wnosi? Można skrócić:

`stream.forEach(System.out::println);`

`::` oznacza: wywołaj mi metodę z obiektu, zupełnie jak lambdę, a argumenty to się domyśli jakie mają być (takie auto)

- **_supplier_** - ciągnie skądś (z dysku, pliku, bazy danych) i wkłada do strumienia
- **_consument_** - czyta ze strumienia i wkłada dokądś (na dysk, do pliku, do bazy danych); bierze dane, produkuje voida;
- **_mapper_** - dostaje elementy ze strumienia i produkuje elementy do innego strumienia; `stream.map(a -> "<<< " + a.toString(a) + " >>>")`
- **_filter_** - filtruj nie spełniające warunku; `stream.filter((a) -> a > 3)`
- **_sorted_** - `stream.sorted()`, defaultowo rosnąco, można według jakiegoś comparatora;
- **_limit_** - wprowadza bardzo silnego breaka, po limicie nic nie ma, `stream.limit(3)`

IntStream - strumień intów. Tylko do typów prostych. To tworzy strumień Integerów w zakresie:

`IntStream stream = IntStream.range(2, 10);`

Generalnie strumienie to są **koprocedury**:
- koprocedury - wykonywane gdzieś w środku, a potem robią YELD;
- zatrzymaj moje funkcjonowanie w tym stanie i jak wrócimy to do tego stanu;

```JAVA
Stream<Integer> stream = Stream.iterate(3, n -> n+2);
    stream
        .limit(10)
        .forEach(System.out::println);
```

Zapisywanie ze strumienia do tablicy:
```JAVA
Stream<Integer> stream = Stream.iterate(3, n -> n + 2);

List<Integer> list = new LinkedList<>(stream
    .limit(10)
    .collect(Collectors.toList()));
    System.out.println(list.toString());
```

**Strumienie można przetwarzać równolegle!**

**Technologia Hadoop:**
- platforma do rozproszonego składowania i przetwarzania wielkich zbiorów danych;
- witamy w XXI w, gdzie w każdej chwili można kupić tysiąc serwerów i ich używać;
- założenie: awarie sprzętowe się zdarzają;
- bazuje na algorytmie **MapReduce** (zaimplementowany np. też w JS);
    - technologia do równoległego przetwarzania dużych zbiorów danych;
    - dzieli operacje na dwa kroki:
    - _map_ - pobranie odpowiedzi na wszystkie podproblemy i złączenie je w jeden wynik (odpowiedź na główny problem);
    - _reduce_ - pobranie danych z wejścia, podział na mniejsze problemy i przesłanie do węzłów roboczych; każdy węzeł roboczy może podzielić podproblem na kolejne podproblemy i przesłać je dalej;
    - zaleta: możliwość łatwego rozproszenia informacji;

Strumienie pozwalają zaimplemenować Map Reduce
