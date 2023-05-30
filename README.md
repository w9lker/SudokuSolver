# SudokuSolver
An android app that generates and lets user solve random Sudoku with determined amount of remaining cells.   
  
## Notes:   
The difficulty of Sudoku isnt determined by the number of remaining cells left. What determines the difficulty is the number of advanced tools that need to be used when solving the Sudoku. However the number of empty cells has a positive correlation with the difficulty of the Sudoku, so Sudokus with less initial cells tend to be harder on average.  
  
## Features
* Has 3 modes of difficulty(Beginner, Easy, Medium) with corresponsing number of empty cells initially  
* Has a built-in timer to determine how much it takes one to finish the Sudoku  
* UI supports almost all mobile devices with some restrictions(cause of the hardcoded size of the text)  

## Fun ideas for further improvement:  
* Leaderboards featuring the best time the Sudoku was completed for specific difficulty with an option to clear it  
* Animations and Efects for losing/winning  
* Online 1v1 competitions for the best time for some randomly generated Sudoku. This one can be improved even further with adding ranking system  
* Custom Sudoku Board skins that can be changed thru settings or maybe an in-game currency that can be used to buy them  

### Setting up the Development Environment
1. Download and Install Android Studio Flamingo | 2022.2.1 [(You can download it here)](https://developer.android.com/studio)
2. Clone the repository using
```
git clone https://github.com/w9lker/SudokuSolver
```
3.Open the project in Android Studio
