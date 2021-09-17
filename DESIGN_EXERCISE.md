# OOGA Lab Discussion
## Names and NetIDs
Justin Lorenz (jml166)
Jerry Fang (jdf58)
Loten Lhatsang (ltl10)
Jason Dong (jd385)

## Fluxx

### High Level Design Ideas
We would follow the player, engine, data structure where the engine would hold the backend of the games by updating the data where it is needed, the data would be read in at the start of the game and hold all the requested player info, and the player would show the view of the game and display the current GUI to the players.
* Card abstraction (each specific card extends and implements its own unique feature)
* One parent class for card -> 4 subclasses (Keepers, Actions, New Rules, Goals) ->  Subclasses for each individual card.
* Playing surface (Display cards that were played after the players play them, keep track of win condition?)
* Having an overall action class that is called when an action card is played
* Overall rules class that holds all the current rules of the game
Player class that allows you to draw, store name, win condition display, holds current cards, etc.

*Goal class hierarchy that holds current goal and can be updated by action card/goal card, could be extended by current goal or ungoals, 


*Deck class that randomizes a new deck, draw cards from, etc.




### CRC Card Classes

This class's purpose or value is to manage something:
```java
public class Player{
    public Player(String name); //Constructor
    public void setPlayerName()
    public void getPlayerName()
    public void drawCard(Card newCard)
    public Card playCard()
    public Card removeCard();
}
```

```java
public abstract class Card{
    public Card(String cardType); //Constructor
    public boolean getCardType(); 
    public void applyCardFunction();
    
}
```

```java
public class RuleCard extends Card{
   public RuleCard();
   public void applyCardFunction()
//getting the rule and passing it to whatever class needs it
}
```
```java
public class Draw2Rule extends RuleCard{
    public Draw2Rule();

}
```

```java
public class ActionCard extends Card{
  public ActionCard();
}
```


```java
public class Deck{
    public Deck(String dataFile); //Constructor
    public void drawCard();
    public void randomizeNewDeck(int numCards);
    public void shuffleDeck();
}
```


This class's purpose or value is to be useful:
```java
public class Value {
    public void update (int data)
}
```

### Use Cases

### Use Cases

* A player plays a Goal card, changing the current goal, and wins the game.

```java
    GoalCard goalCard = new goalCard();
    player.drawCard(Card); // Card drawn is goal card
    playerCard.applyCard()
```

* Creates a new deck and initializes the deck based off an inputted amount of cards from the user
```java
Deck deck = new Deck();
deck.randomizeNewDeck(resource.get(“NumberOfCards”));
```

* A player plays a Rule card, adding to the current rules to set a hand-size limit, requiring all players to immediately drop cards from their hands if necessary.

```java

player.drawCard(); //Draw a card
Card playedCard = player.playCard();
playedCard.applyCard();

```

* A player draws a card from the deck and adds to their hand

```java
player.addCard(deck.drawCard()); //Draw a card
```
