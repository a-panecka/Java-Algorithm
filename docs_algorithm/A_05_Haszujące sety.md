### Zbiory

Zbiór (_set_):
- zbiór nie jest tożsamy z matematycznym zbiorem:
    - w matematyce zbiór może zawierać powtarzające się elementy;
- zbiór jest zbiorem wartości róznoelementowych;
- wartości nie są w żaden sposób uporządkowane;

_set_ ma wiele wspólngo z _map_
- mapa zawiera `key` i `value`
- set zawiera `key`

_set_:
- `add`
- `check`
- `iterator`

Zastosowanie:
- żeby sprawdzić co już było;
    - lista powtarzejących się wartości -> set -> lista; daje listę wartości unikalnych;

Implementacja setu:
- set oparty na liście (ale to dopasowanie istniejącej struktury danych, bez polotu)
- zbiory haszujące i mapy haszujące to struktury danych które reorganizują się w trakcie użytkowania;

Tablica haszująca:
- to tak naprawdę talica list;
- zapisujemy listę haszy (a w zasadzie końcówek hash kodów), a do każdego hash kodu dopinamy tablicę w której zapisujemy wszystkie wartości zaindeksowane tym hash kodem;
- trzeba zrobić coś, żeby struktura była wyważona - głupio mieć listą 8-elementową, w której to każdego elementu jest dopięta tablica 1000-elementowa;
    - żeby zreorganizować trzeba przeliczyć wszystkie hashe jeszcze raz;

Jak każdy szanujący się zbiór, set haszujący powinien zawierać iterator:
- iterator powienien wędrować po wszystkich, unikalnych danych w zbiorze;
