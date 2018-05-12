### Listy

>> Algorytmika jest nauką prostą, bo wszystko zostało już wymyślone.

Listy:
- listy składają się z krawędzi i węzłów, więc można mówić o grafach;
    - listy się tym różnią od grafów, że w listach zazwyczaj występuje porządek;
- każdy węzeł to jakiś obiekt klasy;
- w Javie jest łatwiej niż w C, bo wszystko jet wskaźnikiem. Wędrówki po grafach i po listach są proste
- przyjmuje się maksymalną liczę strzałek wychodzących z węzła; o strzałkach dochodzących nic się nie mówi;
- węzły mają tylko trzymać dane, a nie zarządzać samymi sobą.
- musi być jakieś coś co zarządza. Nie ma co pisać w każdym node funkcji dodającej następnego node;
        - klasa zarządzająca ma _handle_ którym sięga do danych w węzłach;

Sentinel (_Strażnik_):
- w Javie najczęściej nullpointer -> tam nic nie ma, nie można pisać, sprawdzać, po protu nie.
- strażnikiem może być na przykład wartość -1 -> jeśi chcemy podzielić sortowaną listę na listę cosiów dodatnich i ujemnych. Ale wtedy ostrożnie z operacjami na liczbach, bo można zmienić 0 na -1 i stworzymy strażnika wcześniej niż chcemy:
   ```JAVA
   Decrement () {
    if (x == 0) throw coś tam
   ```

**Jednokierunkowa lista wiązana** (_Single Linked List_):
- jest relatywnie łatwa;
- zajmuje relatywnie mało pamięci - zawiera tylko dane i jeden wkaźnik (wskaźnik to 4 albo 8 bitów, w zależności od systemu 32 albo 64)
- nie można się cofnąć - każdy węzeł ma dane tylko o sobie i o to na co wskazuje;

- na każdej liście można zrobić kilka porządków:
    - jest lista obiektów klasy `Person`, która zawiera `age` i `name`;
    - można ją postortować (czyli utworzyć jakiś porządek wskazywania na kolejne elementy) wg różnych kryteriów: po wieku, po imieniu, po kolejności dodania;
    - tam jest kilka porządków, ale to ciągle jest jedna (!) lista - to nie są jej kopie, tylko różne relacje między obiektami;

**Dwukierunkowa lista wiązana** (_Double Linked List_):
- zawiera dwa dokładnie odwrotne porządki;
- można się na niej cofać - każdy węzeł ma dane o sobie i o to na co wskazuje w obie strony;
- head może mieć handle na początek, na początek i na koniec, albo gdzieś po środku - jak zwykle to zależy;

Operacje na danych w liście przeprowadza nadzorca. Najczęstsze operacje na listach:
- insert - w zależności od jakiejś cechy (kolejność, wartość, itp) - to jest pytanie albo o indeks albo o dane któe trzyma węzeł;
- append;
- delete;
- find;

Wady list:
- **listy są nieciągłe**r
    - dojście do jakiegoś elementu wymaga przeiterowania się po wszystkich elementach:
    - search: O(N);
    - insert: O(1) -> jest już znalezione, wstawienie to jedna operacja;