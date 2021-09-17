### Use Cases


//Jason’s Use Cases

*A player selects Checkers as the game to play from the pop-up window

```java
new PlayerChoiceDialogBox(userGameComboBox.getValue(), userGridSizeComboBox.getvalue(), userThemeStyle.getValue())
// Store while second dialog box asks the user for their name and profile pic
```
* A Player enters their name for Player 1, selects a profile pic, and selects to play against a CPU

```java
String player1Name = player1TextField.getText();
String player2Name = “CPU” //defaults to CPU unless player chooses to set it with the second TextField after selecting “Multiplayer”

//Send information which the user had entered to controller in order to use reflection to start the game

GUIView= new GUIView(userGameComboBox.getValue(), userGridSizeComboBox.getvalue(), userThemeStyle.getValue(), player1TextField.getText(), player2TextField.getText());

setProfile1Pic(player1ProfilePic);
setProfile2Pic(player2ProfilePic);
setPlayer1Name(player1Name);
setPlayer2Name(player2Name);
```

* A Player chooses to restart the game

```java
squareGrid.initializeGrid(rows, columns);
squareGrid.placePieces(currGame);
controller.resetCurrentPlayer();
```

* A player chooses to go back to the game menu after already seeing the grid
```java
myBackButton.setOnMouseClicked( e -> {
new chooseGameDialogBox(myResources);
controller.resetCurrentPlayer();
close();
)
```
* Player chooses to click on a cell to change it in TicTacToe
```java
mySquare.setOnMouseClicked(e -> setFill(new ImagePattern(img)))
controller.playerMoved(int i, int j); //Tell ControllerAPI the coordinates
trackMove(); //Keep track of grid so that the player doesn’t try to do that move again later
```

//Justin’s Use Cases

*Current board structure is initialized based on inputted data

```java
//ControllerAPI Class:
BoardStructure currBoard = new BoardStructure(dataReader.findInitialDataGrid(resources.getProperty(“CSV Filepath”);

//BoardStructure Constructor:
public BoardStructure(int[][] initialDataGrid) {
	rows = initialDataGrid.length;
	cols = initialDataGrid[0].length;
	currBoardStructure = new Cell[rows][cols];
initializeBoard(initialDataGrid);
}
```



* A player clicks on the board to play their move and input sent into model (any game example)

```java
//In DisplayBoard Class:

ControllerAPI.userInputDetected(int i, int j);

//In ControllerAPI:
game.userInputDetected(int i, int j) 

//In Game Class:
public void gotUserInput(int i ,int j) { //called in step function
if(isHumanTurn()) {
  humanPlayer.makeMove(currBoard,i,j)
  isHumanTurn = !isHumanTurn;
}
}
```

* AI makes a move when it is its turn

```java
//In Game Class:
public void playPlayerTurn() { //called in step function
If (!isHumanPlayerTurn) {
    AIPlayer.makeMove(currBoard,i,j);
    isHumanPlayerTurn = !isHumanPlayerTurn;
}
}
```

* Cell is updated based on current move by a human player
```java
//In Game Class: 
humanPlayer.makeAMove(i, j);

//In Human Player class
public void makeMove(currBoard, int i, int j) {
gameType.isValidMove(currBoard,i,j);
gameType.updateGameBoard(currBoard,i,j)
}

//In GameType Class
public void updateGameBoard(BoardStructure currBoard, int i, int j) {
	//input game specific code that sets game states based on what happens such as jumps 	
	//in checkers
	//Example of setting the new state of a cell
	currBoard.setStateOfCell(i,j,newState);
}
```

* Game Class is instantiated
```java
//In ControllerAPI: 
BoardStructure currBoard = new BoardStructure(dataReader.findInitialDataGrid(resources.getProperty(“CSV Filepath”);
Game myGame = new Game(currBoard);


//In Game Class:
public Game(BoardStructure currBoard) {
	this.currBoard = currBoard;
	isHumanTurn = true;
}
```


//Loten’s Use Cases

*A player turn occurs and wins game
```java
Game.playPlayerTurn()
// front end checks if game is won.
ControllerAPI.checkIfGameWon()

//In game class
Game.checkIfGameWon()

// frontend display changes
```


*A player clicks an invalid move
```java
// Front end communicates to controller
ControllerAPI.userInputDetected(int i, int j)

//Back end receives call from controller
Game.userInputDetected(int i, int j);
HumanPlayer.makeMove(currBoard, i , j)
gameType.isValid() // returns false
//Game receives that makeMove() call is false, thus current player turn is not changed inside of game

*Load Game clicked from start

```java
// Front end button clicked for loading game
//FileChooser chosen
File file = FileChooser.getFile()
BoardStrucure boardStructure = GameFileReader.makeBoard(file)
Player1 = GameFileReader.getPlayer1(file)
Player2 = GameFileReader.getPlayer2(file)
Game = new Game(boardStructure, Player1, Player2);
```

*Create a game with two human players

```java
// Front end button clicked for creating game with text + profile selected for both players
Game game = GameLoader.loadNewGame(GameType, player1, player2)

ControllerAPI.setGame(game);
```
*TicTacToe ends in a draw
```java
Game.playPlayerTurn()
// front end checks if game is finished.
ControllerAPI.checkIfGameDone?()

//In game class
Game.checkIfGameDone();

// frontend display changes
```

We’ll likely need to abstract gameFinished as it can result in a winner or draw.



