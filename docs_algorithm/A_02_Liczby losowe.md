### Generator liczb losowych.

Od komputerów generalnie oczekujemy determinizmu zachowań - zasadniczo chcemy uzyskać te same wyniki.
W efekcie generatory losują liczby mało losowe. Jeśli ktoś zgadnie cykl, to kolejne liczby już są znane.

_Seed_ - liczba początkowa od której liczą się kolejne liczby losowe.

Ocena generatora:
- czy kolejne liczby spełniają różne kryteria statystyczne, czy dają fajne rozkłady;
    - możliwa jet modyfikacja licz losowych zgodnie z jakimś prawdopodobieństwem (zgodnie z krzywą Gaussa, itp.);
    - wszystkie próby zamiany różnych rozkładów, bez analizy generatora są skazane na porażkę;

Jak działa generator?
- TRNG (_True Random Number Generator_)
- PRNG (_Pseudo Random Number Generator_) - niby pseudo, ale wystarczająco dobry;
    - bazują na jednym algorytmie: kongruencyjny generator liniowy (kongruencja = reszta z dzielenia);
        - kongruencja sumy to suma kongruencji;
        - (A + B) / C (gdzie: A - stara liczba, B - jakaś stała, C - zakres)
        - wystarczy tylko dobrze dodać A, B i C ;)