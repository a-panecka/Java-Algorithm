### Rekurencja:
- każdą pętlę można zapisać rekurencją i każdą rekurencję można zapisać pętlą;
- rekurencja wymaga dużo zawołań stosu, jest pamięciożerna;
```JAVA
    public int sumRecursion(int a, int b) {

        if (a == b) {
            return b;
        } else {
            return sumRecursion(a + 1, b) + a;
        }
    }
```
- **map reduce**: podział zadań na podzadania i zebranie wyników do kupy:
    - dużo mniej zawołań stosu;
    - te zadania można wołać niezależnie na różnych procesorach, rdzeniach, itp;
```JAVA
public int sumRecursionMapReduce(int a, int b) {

        if (a >= b) {
            return b;
        } else {
            return (sumRecursionMapReduce(a, (a + b) / 2) + sumRecursionMapReduce((a + b) / 2 + 1, b));
        }
    }
```
### DFS, czyli robimy sudoku

Robimy wersję oproszczoną, z cyferek 1, 2, 3, 4
