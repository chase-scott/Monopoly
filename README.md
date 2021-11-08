# Monopoly Group 7

## Project Milestone 2 for SYSC 3110

### Deliverables made in this milestone:

1. UML sequence diagrams and UML class diagram
2. code (source + executable in  a jar file + GUI iteration)
3. Documentation (javadocs, user manual, design decisions)
4. JUnit Tests
5. README file

### Group Members:

Chase Scott 101092194

Mohammad Gaffori 101082318

Amith Kumar Das Orko 101126245

### Description:

Implementing a GUI-based version of the game, this includes the view and controller part of the MVC pattern and unit testing.

### Changes since last deliverable:

- Added GUI component of the text based version of the previous milestone to make the game more visually appealing. 
- Added the View and Controller part of the MVC design pattern.
- Players are now able to see the board, position of the properties and of the players.
- Commands are no longer required to be typed in, players can press the command buttons instead. Each player's list of properties and total money left is always visible.
- As instructed by the TA, we modified it so that players are able to see cost of properties, the owner of the property and how much rent is owed for landing on others' property.
- Created a separate class to conduct JUnit testing successfully
- Updated UML diagrams corresponding to up-to-date source codes and TA feedback

### Known issues:

Tiles on the east side of the GUI frame is not cropped properly and thus some information is not completely visible.

### Roadmap ahead:

Implementing additional features including houses, hotels and utilities. Introducing a number of additional "AI" players.

### Decisions Made:

- We decided to add 23 squares in the board instead of the classic game's 40 since we are not allowed to use all the utilities and houses yet. The rest of the squares are left
empty.

- Properties are color coded and the taxes vary depending on the color. However owning all the same colored properties will not have any advantages for the player

- Once the player is unable to pay rent, he is eliminated since we have decided not to include the concept of mortages

- Monopoly.Square was made an abstract class to allow for custom methods and attributes within each of the specific squares. The abstract method squareAction allows the Monopoly.Game class to call it on each sqaure and have it perform the square specific action.

- A thread is created for MonopolyGUI.java, so that the game doesn't freeze.

### User Manual:

-  Double click the jar file and select the number of players, along with their names

- Press "roll" to roll the dice and start the game

- Press "buy" to buy the property you are currently on

- Press "pass" to pass the turn

