### Tablice
Tablice są fajne. Chociaż starożytne.
W tablicach nie ma dynamicznego alokowania pamięci.
Tablice deklarujemy tak:

```JAVA
int [100] value
value [3] = 2
```

Każda tablica jest obiektem. Nie jest zmienną generyczną!
A ponieważ to jest obiekt, to się je tworzy przez `new`!

---

### Tablice wielowymiarowe

W javie nie ma pojęcia tablic dwu-, trzy-, wielowymiarowych.

Tablice wielowymiarywe to tak naprawdę **tablice tablic**! [_array of arrays_].

`TicTac[][]` to jest to samo co: `(TicTac[])[])`

---

### Instrukcje warunkowe

Jak w każdym innym języku. Jeśli po warunku nie ma klamer, to instrukcją warunkową jest tylko pierwsza linijka. Ale nawet jeśli jest tylko jedna instrukcja to **zawsze** zawsze dawać ją w klamerki. Tak, żeby było wiadomo co autor miał na myśli, a nie, że się kopnął;

```JAVA
if (x == 7) {
// tu kod;
} else if (x == 5) {
// tu kod;
} else {
// tu kod;
}
```

---

### Switch case

Można używać, ale w Javie go nie lubią. Czy oni w ogóle coś lubią?

```JAVA
switch (x) {
case 0:
    // wykonaj kod
    //fall through  -> tu nie ma break, więc wykona się też case 1, ale dodawać komentarz
case 1:
    // wykonaj kod;
    break;
case 2:
    // wykonaj kod;
    break;
case 3:
    // wykonaj kod;
    break;
default:
    // wykonaj kod;
}
```

Jeśli nie postawimy break to wykona się też kolejny case.
Można tego używać (bo to miewa sens), ale dodawać wtedy komentarz //fall through
Wyrażeniem wyboru (czyli x) może być **int, long, String** (String od Java7)

Switch case ma sens, jeśli jest klika warunków dotyczących jednej zmiennej -> jeśli piszemy to w if else, to trzeba zawsze spojrzeć czy teraz warunek dotyczy tej samej zmiennej, czy jednak nie innej tym razem.
Ale programiści Javy i tak się z tym nie zgodzą.

---

### Operator trójargumentowy [_ternary operatort_]:

```JAVA
b = a == 3 ? 5 : 19
//czyli:
if (a == 3) {
b = 5;
} else {
b = 19
};
```
> Prosty ternary jest prosty. Ale ternary z ternary w środku to już przegięcie.
@jbanaszczyk, 2018

---

### Iterujemy

>Iteratory są w każdym języku. Dzisiaj o iteratorach nie będzie.
@jbanaszczyk, 2018

Na dzisiaj zapamiętać, że iteruje się pętlami. Pętle znamy i lubimy.

**Pętla for**

```Java
for (int i = 0; i < 10; ++i) {
// tu wykonuj kod
};
```
Zwiększać `++i`, a nie `i++` -> nie słuchać _Stack Overflow_;
- jeśli zwiększamy `i++` to najpierw zapisujemy w pamięci poprzednią wartość, a dopiero potem ją zwiększamy;


```Java
for (int i = 0; i < 10; ++i) {
// tu wykonuj kod
};
```
Tutaj `int i` żyje do końca `for`

```Java
int i;
for (i = 0; i < 10; ++i) {
// tu wykonuj kod
};
```
Tutaj `int i` żyje do końca programu
- na koniec `i = 10` i taką wartość ma po wyjściu z pętli;
- to może być potrzebne, ale jeśli nie zamierzamy używać potem i o zwiększonej wartości, to zajmuje pamięć zupełnie bez sensu;

```JAVA
 int [] myArray = {3, 5, 19};
    for (int value : myArray) {
        System.out.println(value);
    }
```
To co jest w nawiasie po `for` to operator wskazujący na kolejne wartości w tablicy `myArray`.
- to nie jest iterator po wszystkich elementach w tablicy;
- `value` **nie jest indeksem kolejnym elementów tylko ich wartością!**;

**Pętla while**
```JAVA
int i = 0;
while (i < 10) {            // dopóki (i<10) jest true wykonuj pętlę
// jakiś kod
++i;
}
```
Wykonuj pętlę dopóki warunek jest prawdziwy.

```JAVA
int i = 0;
do {
// jakiś kod
++i;
} while (i < 10);           // dopóki (i<10) jest true wykonuj pętlę
```
Wykonaj przynajmniej jeden obrót pętli, a potem sprawdzaj czy warunek jest spełniony:
- dzyli wykona pętlę przynjmniej raz, dopiero potem będzie się zastanawiał co dalej;

---

**Break**
- `break` przerywa pętlę;
- we wszystkich pętlach.

```JAVA
for (int i = 0; i < 10; ++i) {
    if (i == 5) {
    break
    }
};
```
jeśli i = 5 -> wychodzimy z pętli

```JAVA
while (true) {
if (eof ()) {
    break;
    }
}
```

---

**Continue**
- `continue` pomija część ciała pętli;
- we wszystkich pętlach.

```JAVA
for (int i = 0; i < 10; ++i) {
    //jakiś kod;
    if (i == 5) {
        continue;               -> z tego miejsca wraca do końca pętli;
    }
    //jakiś kod;
};
```

### pętla for each

```JAVA
int a[10]
    for (int item : a)
```