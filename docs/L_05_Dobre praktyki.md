### Dobre praktyki i wymagania niefunkcjonalne

>Mogę narysować ludzika. Ma głowę, rączki, nóżki i co tam potrzeba. Ale tam pod spodem zabrakło magicznego: _jak się to kurwa rysuje?!_

Wymagania niefunkcjonalnie:
- szybko;
- stabilnie;
- user experience;
- bezpiecznie;
- itd;

Dołożenie każdego wymagania niefunkcjonalnego sprawia, że łatwiej jest napisać cały kod od nowa, zamiast zmieniać już istniejący.
Zaczynamy od wymagań niefunkcjonanych.

Dopiero połączenie wymagań funkcjonalnych z niefunkcjonalmymi daje przyzwoity kod:
- _architecture_ -> wynika z niefunkcjonalnych; to najpierw;
- _implementation_ (code) -> wynika z funkcjonalnych; a to dopiero potem;
- najpierw co napisać, dopiero potem jak!

Przetwrzanie step-by-step vs przetwarzanie równoległe;

### Wzorce projektowe

W zasadzie nie występują nigdzie oprócz informatyki.

Ktoś kiedyś wymyślił, że są zasady których warto trzymać się w określonych sytuacjach.

Wzorce to gotowe rozwiązania problemów projektowych. To nie są algorytmy.

Algorytmy są realizacją wymagań funkcjonalnych. Są czymś zupełnie innym niż wzorce.

Wzorce projektowe - jak coś robić, co się zyska, a co się straci.
- uwaga - są też **antywzorce**. Wyglądają dokładnie tak samo jak wzorce, ale gdzieś mają informację, żeby nie używać.

Ogarnij wymagania niefunkcjonalne, potem wybieraj wzorzec który do nich pasuje i leć z kodem.
- ale od wzorców można trochę odchodzić.

> Ważniejsze jest, żeby program był napisany dobrze ale nie działał, niż żeby działał napisany źle - jeśli nie działa a jest dobrze napisany, to można go doprowadzić do stanu używalności.

---

**Wzorce**
+ strukturalne;
+ kreacjonistyczne;
+ zachowawcze (behawioralne);

## Unit test
Testowanie poszczególnych jednostek w programie: klas i metod;
Nie wzystkie narzędzia napisane jak unit testy są testami jednostkowymi.
Jednocześnie z pisaniem programu, dobrze jest dorabiać do niego proste, nudne testy. Jeśli się tego nie zrobi od razu, to potem nigdy nie będzie na to czasu.

Dla każdego testu tworzymy nowy obiekt.

Pokrycie kodu testami mierzy się w dwóch kategoriach:
+ pokrycie linii -> line coverage;
+ pokrycie rozgałęzień(if i cała reszta) -> branch coverage;

Dobrze przyjętą praktyką jest pokrycie 80%.
Absolutne minimum to 60%.
W niektórych rozwiązaniach (telekomunikacja, systemy ratujące życie, itp.) musi być 100%.

W unit testach można dodać adnotację Before i After
@ Before -> co się wykonuje przed KAŻDYM testem zapisanym w tej klasie; tworzenie nowego obiektu na którym będzie odpalany test, itp;
@ After -> co się wykonuje po KAŻDYM teście; zamykanie plików otwartych do testów, itd.

Jest jeszcze **mockowanie** - tworzenie atrapy obiektu (_mock object_).
Tego się używa do testów funkcjonalnych. Chociaż narzędzie do testów jednostkowych też da radę do testów funkcjonalnych.
Więcej o tym będzie później.

---

### Złożoność obliczeniowa [O]

Złożoność obliczeniowa to zajęty czas. Nie ma nic wspólnego ze zużyciem zasobów.

Wyszukanie n-tego elementu:
- w tablicy: O(n) -> trzeba przeiterować po n elementach;
- w ArrayList: O(1) -> n-ty element jest tutaj, dostajemy się do niego od razu, czyli wykonujemy jedną czynność;

Złożoność O(n) jest uznawana za znakomitą.

Algorytmy sortowania mają zwykle złożoność O(n logn). To też jest akceptowalne.

Jak się trafi O(n^2) to albo uciekać, albo zamknąć oczy i liczyć, że nikt nie zauważy. No, chyba, że się nie da.
- taką złożoność ma na przykład pętla w pętli. To się zwykle da zrobić inaczej.

O(n!) -> uciekać.

O(NP) -> NP-zupełne. Oznacza to, że prawdopodobnie nie ma komputera silnego na tyle, żeby dało się go policzyć. Wtedy stosuje się algorytmy przybliżone. Tworzone z nadzieją, że przybliżone wyniki będą dość dobre. Zwykle się udaje.

Nie ma algorytmu liczącego złożoność obliczeniową algorytmów
> Patrzysz, widzisz, wiesz. Założenie jest takie, że jak piszesz program, to wiesz jak działa.

**Dobrze by było, żeby program skończył się w 10^7 operacji.**
- czyli przy algorytmach o kolejnych złożonościach obliczeniowych, można posortować tablicę o lieczbie elementów:
    - O(N) - 10^7;
    - O (N^2) - 10^3,5;
    - O (NlogN) - 10^6;
    - O (N!) - 11;