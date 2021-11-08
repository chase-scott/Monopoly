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

- Added GUI component of the text based version of the previous milestone to eliminate the command line interface. 
- Added the View and Controller part of the MVC design pattern.
- Players are now able to see the board, position of the properties and of the players.
- Commands are no longer required to be typed in, players can press the command buttons instead. Each player's list of properties and total money left is always visible.
- As instructed by the TA, we modified it so that players are able to see cost of properties, the owner of the property and how much rent is owed for landing on others' property.
- Created a separate class to conduct JUnit testing successfully
- Updated UML diagrams corresponding to up-to-date source codes and TA feedback

### Known issues:

Tile display is not entirely perfect, sometimes information is clipped depending on display. Will polish this in next milestone.

### Roadmap ahead:

Implementing additional features including houses, hotels and utilities. Introducing a number of additional "AI" players.

### Decisions Made:

- We decided to add 28 squares in the board instead of the classic game's 40 since we are not implementing all the additional square types yet. The rest of the squares are left
empty.

- Properties are color coded and the taxes vary depending on the color. However owning all the same colored properties will not have any advantages for the player

- Once the player is unable to pay rent, he is eliminated since we have decided not to include the concept of mortages

- Square was made an abstract class to allow for custom methods and attributes within each of the specific squares. The abstract method squareAction allows the Game class to call it on each sqaure and have it perform the square specific action.

- A thread is created for MonopolyGUI, so that the game doesn't freeze.

- View was implemented for PlayerView and Square view classes, and the GUI was built from these building blocks.

- The controllers were included as private classes inside PlayerView, since they do not contain much implementation beyond calling one method.

- Empty squares use the Go class for now since it is a do nothing square. These are placeholders for the upcoming milestone squares.

- Model and View/Controllers were moved to seperate packages to differentiate them

### User Manual:

-  Double click the jar file and select the number of players, along with their names

- Press "roll" to roll the dice and start the game

- Press "buy" to buy the property you are currently on

- Press "pass" to pass the turn

- Relevant events will be shown in a screen pop-up

