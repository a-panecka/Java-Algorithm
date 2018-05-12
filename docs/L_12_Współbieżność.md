[Tu czytać.](https://docs.oracle.com/javase/tutorial/essential/concurrency/)

---

### Współbieżność

Przetwarzanie w systemie współbieżnym = wykonywanie instrukcji różnych procesów.
- każda akcja -> zmiana stanu procesu;

---

### Wielowątkowość

Wątki pozwalają na symultaniczne wykonywanie pewnych operacji.

Miejsca wielowątkowe -> _hazard_:
- jest bardzo wiele miejsc gdzie może coś pójść nie tak;
- żadne narzędzie nie pokaże gdzie coś może pójść nie tak;
- wątki za każdym razem mogą wykonać sięw różnej kolejności;
- generalnie jest to trudne;

Zastosowanie wątków:
- ma sens nawet, jeśli procesor jest jednordzeniowy;

Wielowątkowość jest w javie od wersji 1.5
- są skutkiem dość długiego procesu;
- jest pomyślane, żeby było dobrze;

JVM startuje na całym procesorze, który ma w sobie wiele rdzeni:
- to jest pierwsze miejsce do optymalizacji - osobny wątek na każdy rdzeń;
- jedna konsola, jedno wyjście - dwa wątki będą chciały drukować na konsoli, jak to zrobić, żeby było dobrze?

Będzie o założeniu, które niekoniecznie jest dobre.

Cały mechanizm bazuje na tym, że jest niezbywalna spójność danych (_consistency_):
- to w zasadzie jest wymaganie niefunkcjonalne, więc we współczesnym programowaniu można z niego zrezygnować;
- ale _consistency_ jest ważne, chociaż da się z niej zrezygnować;

---

Co się stanie jeśli dwa wątki usiłują dostać się do tego samego obiektu jednocześnie?
- w javie nie ma zmiennych globalnych, więc odpada pytanie o widoczność zmiennych globalnych przez wątki;

- `synchronized`:
    - blokada fragmentów kodu:
    - _critical section_ - synchronizowane fragmenty kodu;
    - synchronizowane mogą być: metody, zmienne, obiekty;
    - jeśli jeden wątek zacznie wykonywać taki fragment kodu to inny wątek nie ma do niej dostępu;
    - jak długo jeden wątek wykonuje metodę zsynchronizowaną, tak długo inne będą czekać w kolejce;
    - najprostszy, zwykle niezły sposób unikania konfliktów;
    - zmienne niesynchronizowane mogą zostać zmienione przez każdy z wątków, nie wiadomo w jakiej kolejności się do niej dopchają;

- `join`:
    - wątek czeka aż inne wątki skończą:
    - wątek drukujący zawartość tablicy czeka aż wątki sortujące tablicę skończą;

- `interrupt`:
    - mechanizm komunikacji międzywątkowej;
    - wykorzystanie `try()` / `catch()`;
    - jeden wątek przerywa drugi wątek przy pomocy pustego `catch` - przerywa się fragment `try`, na catch nic się nie dzieje, a wątek dalej się wykonuje;
    - wątek przerywający dalej sobie leci;

- `notifyAll()`:
    - obudź wszystkie wątki, przekaż im flagę, wątki sprawdzają czy to ich flaga, jeśli tak to działają, jeśli nie to czekają dalej;
    - sprawdzenie czy ta flaga powinna obudzić dany wątek tylko poprzez pętlę `while`;
    - w zależności od tego czy flagA jest `true` czy `false` uruchomi się któryś z wątków;
```JAVA
        while (flagA) {
            try {
                wait();
                } catch (InterruptedExcepton e) {
            }
         }
        while (!flagA) {
            try {
                wait();
                } catch (InterruptedExcepton e) {
            }
        }
        flagA = true;
        notifyAll();
```

- `tryLock()`:
    - jeśli coś jest zalockowane, to żaden inny wątek nie wykona unlock - moduł jest zsynchronizowany, żaden inny wątek nie ma do niego wjazdu, więc nie wykona unclocka;
    - unlock robimy w finally;
    - trochę jak try catch z zasobami;
    - doczytać;


**Ostrożnie z kolekcjami w aplikacjach wielowątkowych!**
- kolekcje nie są synchronizowane;
- każda kolekcja posiada opcję synchronizowania pojedynczych (atomowych) działań, ale nie ma opcji synchroniowania całej kolekcji;

---

>> Finito, zakleszczyło się na śmierć i nie ma

Miejsca do popełniania błedów - w sumie wszędzie.

**Zakleszczenie / blokada wzajemna [_deadlock_]**:
- sytuacja w której co najmniej dwie różne akcje czekają na siebie nawzajem, więc żadna nie może się skończyć;
- dwóch sąsiadów poszło do siebie nawzajem i każdy czeka aż drugi wróci;
- `reentrant synchronization` - jeśli jakiś kawałek kodu jest zablokowany (czyli zsynchroniozwany), to wątek który w nim jet moe go wykonać ponownie - blokada dotyczy tylko innych wątków; więc nie można napisać programu jednowątkowego, który się zakleszczy;
- _problem ucztujących filozofów_;
- zapobieganie, unikanie lub rozwiązywanie - ogarnąć;

**Zagłodzenie [_starvation_]**:
- brak zasobów;
- kiedy w systemie są wątki które zużywają dużo zasobów i wątki o niższym priorytecie nie mogą się dopchać;
- jeden wątek często woła obiekt, inne wątki wymagające zsynchronizowanego dostępu do tego samego obiektu będą blokowane;

**[_livelock_]**:
- niby wszystko dobrze, ale nie działa;
- wątek działa w odpowiedzi na działanie innego wątku, który działa w odpowiedzi na inny wątek;
- wątki nie są blokowane, po prostu są zbyt zajęte odpowiadaniem sobie nawzajem żeby wznowić pracę;
- dwa autorespondery które odpowiadają sobie nawzajem;

---

**Obiekty immutable są niezmienne, więc nic ich nie rusza**
- to jest powód, dla którego w javie obiektów immutable jest tak dużo;
- im wielowątkowość wisi - ich i tak nic nie zmieni;
- z nimi nie ma co się bawić w synchronizację;
