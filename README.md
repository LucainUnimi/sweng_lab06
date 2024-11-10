# CORSO INGEGNERIA DEL SOFTWARE A.A. 2024/25

## LABORATORIO 6
## Tressette a 2

### Il gioco

Si deve implementare una versione semplificata gioco del [Tressette](https://it.wikipedia.org/wiki/Tressette) nella variante a 2 giocatori.

Il gioco necessita di un mazzo di 40 carte, divise in quattro semi, ciascuno dei
quali con i 10 valori Asso, 2, 3, 4, 5, 6, 7, Fante, Cavallo, Re. All'inizio della
partita vengono distribuite 10 carte a ciascuno dei due giocatori che si alterneranno nelle giocate.

Il giocatore di turno, cala una carta (attacco) e di seguito fa lo stesso l'altro (risposta),
costituendo così una "passata". In ogni passata la carta di attacco giocata
stabilisce il *seme dominante*: il secondo giocatore deve rispondere giocando una carta
dello stesso seme o, solo se ne è privo, un'altra carta qualunque fra quelle che
ha in mano. Se le due carte giocate sono di semi diversi, la presa è attribuita al
primo giocatore, altrimenti a quello che ha giocato la carta più alta secondo
questa scala decrescente:

- tre
- due
- asso
- re
- cavallo
- fante
- sette
- sei
- cinque
- quattro

Al termine della passata ciascun giocatore pesca (non c'è bisogno di farla 
vedere all'avversario come sarebbe prescritto invece da alcune varianti) 
una nuova carta dal mazzo (se non è esaurito) e inizia la nuova passata chi ha fatto la presa. 
Si procede così fino a utilizzare tutte le carte. 
Il punteggio finale della mano è calcolato
valutando le prese di ciascuno, attribuendo 1 punto per ogni asso, 1/3 di punto
per ogni fante, cavallo, re, due e tre; ogni altra carta ha valore uguale a zero. 
**Il risultato finale è troncato (cioè si ignora la parte frazionaria) e il giocatore
che ha fatto l'ultima presa riceve un punto aggiuntivo.**

I giocatori quando giocano per primi "attaccano" seguendo una strategia di gioco
che porta alla selezione di una carta opportuna scelta tra quelle in mano loro. 
Quando invece giocano per secondi ("rispondono"), devono rispettare la regola che impone di, ogni
volta che è loro possibile, rispondere al seme dominante scelto dal primo
giocatore. Quindi:


1. Se ne hanno, devono scegliere una carta del seme dominante,
   conseguendo eventualmente la presa;
2. Qualora la strategia precedente fallisca, devono scegliere una carta fra
   quelle a disposizione.


# Codice

Vengono fornite già diverse classi da completare (vedi i `TODO` nei commenti nel codice fornito).

Creare le classi necessarie a simulare una singola partita di "Tressette a due" con 
possibilità di farsi calcolare il punteggio finale.

### Processo

Una volta effettuato il **clone** del repository, il gruppo completa l'implementazione seguendo la *metodologia TDD*; 
in maggior dettaglio, ripete i passi seguenti fino ad aver implementato tutte le funzionalità richieste:

* scelta la prossima funzionalità richiesta da implementare, inizia una feature di gitflow
* implementa un test per la funzionalità,
* verifica che **il codice compili correttamente**, ma l'**esecuzione del test fallisca**; solo a questo punto effettua un *commit*
  (usando `IntelliJ` o `git add` e `git commit`) iniziando il messaggio di commit con la stringa `ROSSO:`,
* aggiunge la minima implementazione necessaria a realizzare la funzionalità, in modo che **il test esegua con successo**; solo a questo punto
  effettua un *commit* (usando `IntelliJ` o `git add` e `git commit`) iniziando il messaggio di commit con la stringa `VERDE:`,
* procede, se necessario, al **refactoring** del codice, accertandosi che le modifiche non
  comportino il fallimento di alcun test; solo in questo caso fa seguire a ogni
  passo un *commit* (usando `IntelliJ` o `git add` e `git commit`)
  iniziando il messaggio di commit con la stringa `REFACTORING:`,
* ripete i passi precedenti fino a quando non considera la funzionalità realizzata nel suo complesso e allora chiude la feature di gitflow
* effettua un *push* dei passi svolti su gitlab.di.unimi.it con `IntelliJ` o`git push --all`.

**Controllate ad ogni commit diverso da ROSSO, e in special modo prima di chiudere una feature, 
che il grado di copertura dei comandi sia prossimo al 100%.**

### RELEASES

Durante lo sviluppo avete alcune release da fare (con gitflow e pushare su gitlab):

- prima release quando per la prima volta chiudete una feature dopo le 16:30
- seconda release quando per la prima volta chiudete una feature dopo le 17:30
- ultima release quando consegnate PRIMA delle 18:30

Al termine del laboratorio impacchetta l'ultima versione stabile come una
release di gitflow chiamata "consegna" comprendente tutte le feature  completate,
poi effettua un ultimo *push* anche di tutti i
rami locali (comprese eventuali feature aperte ma non completate). Suggeriamo di
**verificare su gitlab.di.unimi.it** che ci sia la completa traccia dei *commit*
effettuati e di averne dato visibilità ai docenti.


## Pseudo struttura di un possibile main

```java
public class Main {
  public static void main(String[] args) {
    Player carlo = new Player("Carlo");
    Player mattia = new Player("Mattia");
    Deck deck = Deck.createFullDeck();
    
    //TODO: set delle strategie dei giocatori
    
    
    Game game = new Game(carlo, mattia, deck);
    System.out.println(game.playGame());
  }
}
```
