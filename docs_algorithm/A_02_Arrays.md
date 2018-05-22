W Javie tablica (_array_) to taki _wektor_ z C++.
- lista: dodawanie / usuwanie elementów jest w zasadzie za darmo;
- tablica: dodawanie / usuwanie powoduje konieczność przeuwania na boki wszystkich pozostałych elementów. Kosztowne;

Cała tablica zajmuje ciągły, niepodzielny adres w pamięci
- sąsiednie elementy pamięci zajmują sąsiednie elementy pamięci;
- dlatego jest szybkie;

_Append_:
- żeby zrobić _append_ trzeba skopiować tablicę i powiększoną przepisać do nowego kawałka pamięci;
- dlatego trzeba: tworzyć pustą tablicę, _resize_ ją do odpowiedniego rozmiaru i dopiero wypełniać;

_Insert_ i _delete_:
- to już w ogóle jazda bez trzymanki, bo trzeba utworzyć pustą tablię, _resize_ ją, przepisywać tam od końca tablicę z przesunięciem indeksu;
- ale dodatkowo JVM za każdym razem sprawdza, czy przypdkiem nie postanowiliśmy wyjść poza zakres;
- żeby to usprawnić używać _Arrays.CopyArray()_

Zrobić tablicę tak samo jak listę:
- napisać konstruktor;
- napisać resize;
    - gdzieś zapisać wybraną z palca wartość o którą zwiększamy rozmar tablicy przy każdym resize;
- setter / getter;
- append unikając new;
- insert (5, T data) -> na zadany indeks wstawić obiekt data typu T;
- delete;
- get typu T który zwraca element z szukanego indeksu (search value z indeksu);
- rozdzielić _size_ od _real size_;
