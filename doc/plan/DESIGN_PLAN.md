# OOGA Final Game Design/Plan

## Names and NetIDs
Justin Lorenz (jml166)
Jerry Fang (jdf58)
Loten Lhatsang (ltl10)
Jason Dong (jd385)

## OOGA Final Game Design

### Introduction
What we chose 
Strategy Games (Checkers, Othello, TicTacToe, Connect4)
Primary goals
Implement a library of popular strategy games to play
Utilize abstraction and interfaces to make implementations of current and future games easier
Implement levels of AI logic to allow the user to either play against a computer or another person
Primary architecture (discuss design at high level)
 At a high level, we will be creating three API’s in our project that work together. The three API’s that we will be focusing on are the Engine, Data, Player. The engine will be focusing on holding the data for the game and manipulating the data based on the user’s interactions in the player (i.e Where the AI is held, the current board structure, etc.). The Data API is going to be the api that deals with all the data that the game is given when it starts (i.e resource files/css files that allow the game to be styled, current board configurations, GUI requested elements form the user). The player API is going to be the view portion of the project that actually displays the GUI to the user. This player API will utilize the data inputted from the engine and also be important for finding user input by the user clicking the screen.
### Overview
Map of design for other programmers (describe specific modules, focus on each one’s API)
Engine:
One overall Game Class Interface that serves as the framework specific games to be added
A BoardStructure that encapsulates the actual model data’s structure (instances of this class held in Board)
The BoardStructure will hold instances of a cell class which holds the state, coordinates, etc. 
We will have overall game classes such as checkers, othello, tic tac toe, etc. that all implement the game class interface that sets the methods needed for a new game. These classes will hold the BoardStructure object and manipulate the board based on input from the view. Each game class will manipulate the board in their own ways based on the specific game type.
AI Abstraction that holds the min/max algorithm 
Specific AI for each type of game that hold the min/max functions for that specific game
Data:
CSV File reading for always default to having an initial configuration file for checkers, tic-tac-toe, othello, connect 4 if the user doesn’t specify a configuration
Allowing the user to load up their own CSV file configuration with where they want initial pieces to be for checkers, and letting them pick empty grid sizes for the other 3 games.
.game files which hold information like Title, GameType, Description, colors, etc
Saving the user’s current progress in the game to a .csv file to load up later to play
Player:
View of CellPaneBoardStructure that contains the data structure used to display the grid
This cellpaneboard structure can display different types of panes such as varying shapes (this would be done by changing the overall data structure in this class)
CellPaneDisplay to actually display the Grid, using the data structure held in CellPaneBoardStructure
Overall button abstraction that each individual button will extend, this class will set the id, text, etc.
Abstraction for all the dialog boxes that need to be displayed

Include photos/images of how the modules work together

### Design Details
Describe each module in overview in detail (as well as submodules)
Justify why each module is created with respect to design’s key goals, principles, and abstractions

### Example Games
Describe three example games that differ slightly

Checkers
Othello
Connect Four
Modded version of Connect Four (Connect Five for example)
TicTacToe

Identify how the functional differences in games are supported by your design (think abstractions)
Similar GameBoard setup with needing to display a grid and then updating the grid as pieces move around. 
Similar need with games being able to be played along with an AI or another player
“Chips” that are laid and moved around on a gameboard
Each game has its own ruleset and win condition, and can benefit from an inheritance to implement common methods

### Design Considerations
Any issues needed to be addressed or resolved before attempting to devise complete solutions (include any design decisions + pros/cons)
Checkers operates differently in the sense that 




### CRC Card Classes


This class encapsulates the data for the cells of the game
```java
public class BoardStructure {
   public BoardStructure(int[][] dataStateArray);
   public int getRows();
   public int getCols();
  private initializeThisBoard(int[][] dataStateArray);
  public setStateOfCell(int i,int j);
  public getStateOfCell(int i,int j);
}
```

The Cell class represents a single cell on the board
```java
public class Cell {
    public Cell(int i, int j, int state) ;
    protected void setState(int state);
    protected int getState();
}
```
This class is the highest level of the GameEngine
```java
public class Game {
Game(BoardStructure currBoard, Player player1, Player player2, GameType); //constructor
void checkIfGameWon();
void gotUserInput(int i, int j);
void playPlayerTurn();
private instance GameType;
private Player player1;
private Player player2;
private int playerTurn;
private BoardStructure currBoard;

gotUserInput(int i ,int j) { //called in step function
if(isHumanPlayerTurn()) {
  //humanPlayer.makeMove(currBoard,i,j)
   ///change to AI’s turn
}
}
```
```java
public void playPlayerTurn() { //called in step function
If (!isHumanPlayerTurn) {
AIPlayer.makeMove(currBoard, i, j) 
// AI immediately plays function
//Update Player Turn
}
}
```
```java
public interface Player {
   public void makeMove(BoardStructure currBoard, int i, int j);
   public boolean isHuman();
}
```
```java
AI Player implement Player {
public AIPlayer(GameType); {
	Private AI myAI = use reflection to find correct AI
}}

public void makeMove(currBoard, int i, int j) {
	myAi.miniMaxAlgorithm(currBoard);
	gameType.someUpdateBoard(currBoard,i,j)
}
}
```

```java
Human Player implement Player {
public HumanPlayer(GameType);
Public boolean makeMove(currBoard, int i, int j) {
	if(gameType.isValid(i,j))
		gameType.someUpdateBoard(i,j)
		return true
	else return false;
}
}
```

```java
GameType Class:
   public boolean isDraw(currBoard); //search thru all i,j  {
	Double for loop thru board
	If isValidMove never equals true for whole board -> return true;
}
   public (enumeration return) getGameStatus(currBoard); 
   public abstract boolean isGameWon();
   public abstract boolean isValidMove(int i, int j);
   public abstract void someUpdateBoard(int i, int j);
  public String get gameTypeId();
}
```


```java
public class CheckersGameType extends GameType {
    public makeGameMove(BoardStructure, i, j);
    public gameIsWon(BoardStructure);
}```


```java
public interface AI {
   public int[] findMinMaxAlgorithm(currBoard);
}
```

```java
public CheckersAI implements AI {
	Public int[] findMinMaxAlgorithm() {
	    minMax();
}
```


```java
public class GridDisplay extends Pane{
  public abstract void initializeGrid();
  public void updateGrid();
}
```


```java
public class ooga.view.dialogBox.DialogBox{
    public ooga.view.dialogBox.DialogBox(ResourceBundle myResources);
    public void initializeStage();
    public Scene setUpScene();
    public abstract Button makeButton();
    public text makeText();
}
```


This class's purpose or value is to be useful:
```java
public class GUIButton extends Button{
    public GUIButton();
    public abstract void setText();
    public abstract void setID();
    public abstract void handleMouseClick(Event mouseEvent);
    public  void setButtonSize();
}
```








