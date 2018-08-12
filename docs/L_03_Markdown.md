Markdown, Ascii Doc:
- służą do rozdzielenia warstwy treści od prezentacji;

# nagłówek 
## nagłówek 2
### następny nagłówek

"=" wyróżnienie poprzedniej linijki
=

ujęte w "**" **będzie bold**

ujęte w "*" *będzie italic*

"---" zamienia na linię 

+ pkt 1. (zamiast + może być *, efekt będzie ten sam)
+ pkt 2.
+ pkt 3.

1. pkt 1.
2. pkt 2.
3. pkt 3.

---

> to jest cytat
>> a to jest cytat drugiego poziomu  

żeby wyjść z trybu cytowania pusta linia

---
### Tabele:
tabele są fajne


| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| wiersz 1      | test | a to tekst |
| wiersz 2      | test |   tu też tekst |
| wiersz 3 | test      |    i tu też|

: przy poziomej linii pod nagłówkami w tabeli załatwia środkowanie w tej kolumnie

---

A [tutaj](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet) jest _CheatSheet_. Jak czegoś tu nie ma, to nie istnieje

A to jest kotek:

![orazek](https://royalcanin.pl/blog/wp-content/uploads/2016/12/176W-950x633.jpeg)

---
### O kodzie:
A żeby wstawić kod (nie mylić z kot) to tak:

``` tu będzie kod ```

żeby dobrze kolorował wg. języka, za pierwszymi ciapkami piszemy nazwę języka
```JAVA
    public Person(int pesel, String name, String surname) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
    }
```


żeby pojedynczy kawałek w zdaniu robił jak kod, to trzeba go w pojedyncze `

czyli tak: `tu jest kod`, a tu już nie