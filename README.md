# tictactoe
tikketakkietoe / tictactoe

## Indeling 

Welke methodes zitten waar? 

- Main 
    -
- Players 
    - callPlayers
    - randomBeginner 
- Board 
    - drawBoard
    - fillBoard
    - setSign
    - pickNumber
    - checkNumber
    - isNumberSet
    - getWinner



## Feedback Raymond

1. ~~in Java worden functions, methods genoemd~~
2. ~~RandomBeginner.randomBeginner(players), je hebt hier een aparte class met daarin 1 methode, die in t gehele programma maar 1x wordt gebruikt en eigenlijk alleen een random getal kiest, lijkt me wat overbodig~~
3. ~~Board.printboardInstructions(), het printen van de instruction kan mooi in de constructor van de class Board, ipv een aparte methode. De constructor wordt 1 maal aanroepen bij t maken van t object en das precies t moment dat je ook de instructies wilt tonen.~~
4. ~~Het commentaar bij boardArray klopt niet, boardArray is geen functie~~ 
5. ~~idem voor boardMapper~~
6. ~~board.getWinner() returnt Optional<String>, heel fancy om Optional te gebruiken maar volgens mij kun je gewoon een lege String terug geven al er nog geen winner is.~~
7. ~~RMM Beetje overbodig om een aparte methode voor een paar streepjes. Je bespaart er niet echt iets mee, maar als je er toch 1 wilt dan is het voor t overzicht wel nice om um hier te plaatsen private static void printLine() {System.out.println("----------------------");}~~
8. ~~Wat nu als het gelijkspel is?~~
9. ~~de class Person, bevat nog al wat static methods, probeer eens meer t voordeel van classes / objecten te bedenken en je hele proggie op te zetten zonder statics (muv enkele methods in de Main class)~~
10. ~~Overall genomen, kun je eens nadenken over een refactor, waarbij je meer eigenschappen / gedrag wat bij elkaar hoort in de bij behorende class zet.~~
11. de scanner(s) uit de classes Board en Player halen en main er verantwoordelijk voor maken
12. Je kan bijvoorbeeld ook voor het teken (sign) een Enum gebruiken, en dan in de Persoon class  een eigenschap (flied) opnemen hier voor, maw Persoon heeft een naam en het teken (als enum) en eventueel ook een field of ie gewonnen heeft.
13. Tis een beetje van wat hoor waarbij en wat hou ik waarbij?
14. Een Board heeft speler toch? Why not binnen de class Board gebruik maken van de class Player?
15. Nice 2 haves ... hoeveel beurten waren er nodig tot dat er een winner was?

## More advanced:
- Main class
- Game class
- Board class
- Player class

Game class die een spel representeert, waarvan je meerdere kunt hebben, zodat je proggie niet stopt na 1 game maar vraagt of je nog eens wilt spellen. Statestieken bijhouden van de games en uiteindelijk uit printen wie hoevaak gewonnen heeft?