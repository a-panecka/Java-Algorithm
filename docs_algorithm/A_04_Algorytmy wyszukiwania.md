>> Sortowanie ma nie gubić elementów tylko jest sortować (@jbanaszczyk).

### Algorytmy wyszukiwania

Dwa rodzaje:
- binarne -> jak dane są już posortowane

- liniowe [_linear_] -> jak trzeba przejrzeć każdy element i nie ma żadnych podstaw żeby szukać gdzie jest element
    - sprawdzanie w javie najlepiej sprawdza się przy użyciu interfejsu `comparable`;
    - jak nie ma elementu porównywania to nie może wystąpić element wyszukiwania;
    - muszą istnieć jakieś cechy umożliwiające porównanie żeby można było wyszukiwać;

- wyszukiwanie liniowe ma zasadniczo złożoność obliczeniową O(n)
    - ale jeśli na obiektach trzba wykonać kosztowne operacje żeby uzyskać szukaną wartość (np. dzielenie przez 3) to złożoność wzrasta;
    - to można usprawnić -> **wartości haszujące**;

### Funkcje hashujące
- funkcja przyporządkowująca dowolnie dużej liczbie liczbę krótką, zawsze posiadającą stały rozmiar;
- obiekty nie muszą implementować żandego interfejsu -> opcja hash jest wbudwana w `Object`;
- to jest odwzorowanie niejednowartościowe -> duży zbiór przepisujemy na małe, czyli pewne wartości mogą zostać przypisane do kilku wartości
    - jeżeli hash kody są różne, to obiekty są różne;
    - jeżeli hash kody są takie same, to obiekty mogą być tożsame;
    - najpierw sprawdzamy czy hash kody są takie same, a dopiero potem obiekty o tych samych hash kodach sprawdzamy głębiej
        - sprawdzenie czy 2 obiekty są tożsame przez funckję `.equalsTo()` (dostęp do funkcji `.equalsTo()` trzeba zapewnić!);

**Cechy**:
- hash tych samych warotści musi być zawsze taki sam;
    - jeśli mamy dwa .json: {"A": 7, "B": 3} i {"B": 3, "A": 7}
        - to one są takie same więc muszą mieć takie same hash kody;
        - biblioteka do obsługi .json bierze wszystkie argumenty, liczy z nich hash kody i za pomocą jakiejś funkcji przemiennej (dodawanie jest najprostsze) i tego używa jako has kodu całego .jsona;
        - zamiast dodawania może będzie lepsze XOR: hash ^ hash;
- funkcja hasująca powinna dość dobrze rozrzucać (jeżeli weźmiemy n losowo wybranych elementów, to ich rozkład będzie równomierny);
- hash trzeba musi być łatwo liczyć;
- hash można zastosować do dowlonej wielkości bloku danych;
- hash zawsze produkuje dane wyjściowe ustalonej długości;
- hash powienien być powiązany z obiektem, czyli musi być wyliczany z niego samego (f(n) zawsze ma tak sam hash);
- dobrze by było, gdy dało się używać tylko częsci hash kodu;

---

### Szukanie
- mamy listę do której pakujemy obiekty;
- można przy okazji dodawania obiektó wyliczać im hash kod;
- jeśli to będzie osobny argument, to za każdym razem przy zmianie wartości trzeba przeliczać hash kod;
- można zrobić osobną klasę w klasie, która będzie zawierała w sobie poletka `data` i `hash`, które są połączone;

Szukanie binarne:
- bierzemy listę posortowaną;
- dzielimy ją na pół pod względem liczby obiektów;
- sprawdzamy środkowy element, jeśli jest za duży to bierzemy pierwszą połowę i ją też dzielimy na pół, itd.