**Tail to Head** (12.05.18):
- jest lista jednokierunkowa: A, B, C, D, E, F;
- odpalić metodę find(C), uciąć za znalezionym i wstawić na początek, a to co było przed wycięciem wstawić na koniec;
- czyli ma wyjść: D, E, F, A, B, C;

- dla nadgorliwych: napisać search, delete i insert, tylko na listach dwukierunkowych;

- commit -> push -> pull request (z list do master) + jbanaszczyk

**Chess** (19.05.18):
- zrobić tak, żeby współrzędne ruchów wieżą była klasą;
- metoda ma zapisywać wyniki do obiektów klasy;
- potem metoda dodająca współrzędne do współrzędnych (sprawdzać, czy nie wyszło poza zakres);

**Plansza i magnesy**
- jest sobie plansza, podzielona na wiersze i kolumny;
- na niektórych polach są krzyżyki;
- jest zadana pozycja początowa kółka;
- dodatkowo są cztery magnesy o numerach: 1, 2, 3, 4, położone na każdym boku;
- po włączeniu magnesu kółko leci najbliżej w stornę tego magnesu jak może (pole z krzyżykiem jest blokadą);
- ile pól przeleci po włączeniu konkretnej sekwencji magnesu;

**Zasłaniające się budynki**
- wyimaginujcie sobie osiedle mieszkaniowe. Kilka/wiele bloków. Stojących w jednej linii. Niech będzie, że wzdłuż osi X, od zera w prawo.
- bloki zasłaniają sobie widok na świat. To są stare bloki, mają okna tylko po prawej stronie. Tak, żeby sobie jeszcze doskonalej zasłaniać.
- bloki mają wysokość, odliczając od lewej: 10 7 6 8 2 5 1 pięter.
- umówmy się, że zwrot "widać świat z piętra X" oznacza, że po prawej nie ma żadnego bloku nawet X piętrowego, wszystkie są niższe
- czyli z bloku z lewej strony widać świat z piętra 9 (po innym zasłania blok 8-piętrowy). Tej liczby oczekuję w wyniku. A z bloku następnego z żadnego piętra nie widać świata, czyli wynik 0. Itd. A z 8-piętrowego - widać świat nawet z 6 piętra, bo reszcie pięcio-piętrowy zasłania

- są trzy rozwiązania z czego 2 dobre
- najbardziej oczywiste: szukać dla każdego po najwyższego do końca listy -> On^2/2
    - tutaj dostajemy jakiś wynik i go wyrzucamy, zamiast wykorzystać dalej. można inaczej
- można rekurencyjnie
- i można liczyć od końca

**Płotek**
- jest sobie płotek. o różnych wysokościach szczebelków
- na każdym szczebelku kładziemy kuleczkę, liczymy ile razy spadnie
- napisać w wariancie jednowymiarowym;
- a co jeśli płotek jest planszą?
    - wtedy trzeba najprotszym pomysłem jest DFS, czyli polecieć rekurencją
    - jeszcze można sprawdzać od największych


