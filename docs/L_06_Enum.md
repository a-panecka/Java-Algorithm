**Enum** - typ wyliczeniowy, która ma tyle zmiennych ile zadeklarujemy i zdefiniujemy.

```JAVA
enum XO {TIC, TAC, EMPTY};
XO xo = XO.TIC;

if (xo == XO.TAC) {
// jakiś kod;
}

switch (xo) {
    case TAC:
        break;
    case EMPTY:
        break;
}
```


**Każdy enum to jest klasa!**

Każdy zmienna typu enum ma swoje metody.
Enuma można przepytać o wartości i o sporo innych rzeczy.

```JAVA
enum XO {
    TIC ("X"),
    TAC ("Y"),
    EMPTY (" ");

    String symbol;                  \\ to jest pole klasy

    XO (String symbol) {            \\ to jest konstruktor
        this.symbol = symbol;
    }

    public String getSymbol() {     \\ to jest getter
        return symbol;
    }

    xo.getSymbol();                 \\ a to jest wywyołanie metody
```

Co więcej - może być enum w enumie. Bo czemu nie?

Enum można zadeklarować w osobnej klasie typu enum
- czy używać - jak zwykle, to zależy;
- to jest pole do nadużyć ale można;
- jeśli wykorzystujemy enuma w innej klasie to on już jest stworzony -> **to jest singleton**
    + nie trzeba robić new, on już istnieje! 
    + dlaczego - będzie później, na razie ostrożnie z tym;

Forlamnie można zrobić setter, w sensie IDE nie zaprotestuje. Ale **enum jest stały, dodawanie settera jest zaprzeczeniem stałości**.
Po to mamy enuma żeby mieć stałe.

> Jeśli robisz setter w enumie, to znaczy, że się pogubiłeś w życiu. Jedni biorą kokainę, inni robią setter w enumie.

---

Konwencja w enumie: 
- tylko wielkie litery;
- podkreślniki zamiast spacji;
- to koncepcja zapożyczona z C, że zmienne niezmienne zapisujemy wielkimi. Zostało tylko w enumie;
