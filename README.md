# PokerScorer
*A project to count Poker scores* from text file as Poker cards, then determines the winner in each Poker games.
To solve the problem below

Mr. Ku Chun is the world famous gambler. He would like us to help create intelligence application on the Apple watch to tell him if they can win the poker game by comparison between his ranks to another player.
Poker rule: you can follow the Poker rule here: http://www.pokerlistings.com/poker-rules

## How to run the program
1. Clone the project to your directory
2. Open command line windows
3. Go to the directory in STEP1
4. Run command -> gradlew bootRun 
You should see the result as below
```
Lee wins. - with high card: Ace
Lee wins. - with full house
Lee wins. - with high card: 9
Tie.
```

## How to run unit tests
1. Open command line windows
2. Go to the project directory
3. Run command -> gradlew test
4. The test results will be under /build/test-results/

## How to open the project with IntelliJ IDEA
1. Open IntelliJ IDEA
2. Click "Import Project" on the right panel
3. Select "build.gradle" file in the project directory
4. Now you should be able to build or run the project

## About input file
Input file location is here /src/main/resources/input_file.txt   
KH = K Black heart (cards)     
9S = 9 Black spade (cards)     
2D = 2 Black diamond (cards)     
AC = A Black club (cards)

## Shuffle cards online tool
If you just would like to random your input, you can use this tool to shuffle cards --
http://bit.ly/2dyoKKR





