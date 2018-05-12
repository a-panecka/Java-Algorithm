## Interfejsy (_interface_)

Interfejs - zestaw metod bez ich implementacji (bez ciała). Szkielet klas implementujących interfejs.
- kontrakt co klasa implementująca ma robić, a nie instrukcja jak ma to robić.

Właściwa implementacja metod zawartych w interfejsie znajduje się w klasie implementującej dany interfejs.

Klasa implmentująca musi (!) implementować metody interfejsu.
- może oprócz tego posiadać swoje metody specyficzne;
- przydatna może być adnotacja _@Override_;
- domyślnie wszystkie metody interfejsu są publcizne i abstrakcyjne;
- metody interfejsu nie mogą być statyczne;

Interfejs może dziedziczyć interfejs (nawet więcej niż jeden);

```JAVA
Class Person
interface IPerson {
    abstract String getName();
    abstract long getPesel();
    abstract void setName(String name);
    abstract void setPesel(long pesel);
}

Class Person implements IPerson
```

Można stworzyć zmienną typu interface

IPerson ip = new Person (...)

Osobny interface dla każdej klasy

---

## Klasy abstrakcyjne (_abstract classes_)

Klasa abstrakcyjne to taki trochę interfejs. Służy do tworzenia abstrakcji.

**Nie** można tworzyć nowej instancji klasy abstrakcyjnej. Tworzymy jedynie nowe instancje obiektów klas dziedziczących po klasie abstakcyjnej.

- mogą zawierać zwykłe metody (dziedziczone przez klasy rozszerzające);
- mogą zawierać metody abstrakcyjne (nie posiadające implementacji);
    - klasy rozszerzające klasę abstrakcyjną muszą tworzyć implementację metod abstrakcyjnych;
    - metody abstrakcyjne nie mogą być statyczne (bo nie posiadają implementacji);
- mogą zawierać stałe zmienne (_public static final_);

Wada?
- można dziedziczyć tylko po jednej klasie (też abstrakcyjnej), a interfejsów można implementować do woli.

```JAVA
abstract class Canine {
    String name;
    String color;
    String gender;
    int age;

    Canine(String name, String color, int age, char mF){
        this.name = name;
        this.color = color;
        this.age = age;
        this.gender = (mF == 'M') ? "Male " : "Female ";
    }

    abstract String getBreed(); // deklaracja metody abstrakcyjnej

    void printInfo(){
        System.out.println(name + " is " + age + " year old "
           + gender + getBreed() + " with a " + color + " coat.");
    }
}

class Husky extends Canine{
    Husky(String name, String color, int age, char mF){
        super(name, color, age, mF);
    }

    String getBreed(){ // implementacja metody abstrakcyjnej
        return "Husky";
    }
}


Canine newHusky = new Husky("Alaska", "Grey/Black/White", 16, 'F');
newHusky.printInfo();
```

Tak nie można zrobić, to byłoby instancjonowanie obiektu klasy abstrakcyjnej:
`Canine myHusky = new Canine("Alaska", "Grey/Black/White", 16, 'F');`
