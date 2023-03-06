# Terminal_yahtzee
Yahtzee - dice Game.

# Run in Terminal

**cd ./terminal_yahtzee**

```
javac -d ./ ./src/*.java
```
```
java -classpath ./ dnb.game.yahtzee.Game Player_A Player_B
```
# Description

YAHTZE DNB

Yathzee DNB is a dice game played with 4 dice.
Players take turns rolling the dice.
The winner is the player with the highest score.

Each player has a score card onto which he enters his results. 

To make this exercise unique we have created a special DNB Yahtzee score card.
Your solution needs to consider only the scores which are NOT crossed with "red X". (see attached)

SCORING

In each round the 4 dice may be rolled up Yahtzee style ... selecting the dice you wish to re-roll ... and re-rolling up to two times after your first roll.
To be able to enter points onto the score card, you have to roll certain combinations, for example a triple (three dice with the same number of points).
After the first roll, you may put „matching“ dice aside and continue with the remaining dice. 

No later than after the third roll you have to decide for a field on the score card.
For example, if you have rolled three fours, you add up the points and enter the sum (in this case a 12).

You may only enter one result per game in each box.
If your current roll doesn’t correspond to any of the boxes, you have to cross out a field of your choice from the score card.

WINNING THE GAME

After all turns have been taken and scored, players then total up their scores by adding up the Column Numbers above each of their tokens.
The player with the highest total wins.

IMPLEMENTATION

The program should run in CLI and accept input parameters, if any, as arguments.

Please use Git for version control. 
