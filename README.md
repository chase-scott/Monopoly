# Monopoly Group 7

## Project Milestone 1 for SYSC 3110

### Deliverables made in this milestone:

1. UML sequence diagrams and UML class diagram
2. code (source + executable in  a jar file)
3. Documentation (javadocs, user manual, design decisions)
4. README file

### Group Members:

Chase Scott 101092194

Mohammad Gaffori 101082318

Amith Kumar Das Orko 101126245

### Changes since last deliverable:

This is the 1st deliverable

### Description:

A text-based playable version of the classic Monopoly game, forming the Model part of the MVC pattern.

### Known issues:

None

### Roadmap ahead:

Implementing a GUI-based version of the game, this includes the view and controller. Update UML and data structures corresponding to the source code and provide unit tests. Improve code based on the TA's feedback.

### Decisions Made:

- We decided to add 23 squares in the board instead of the classic game's 40 since we are not allowed to use all the utilities and houses yet.

- Properties are color coded and the taxes vary depending on the color. However owning all the same colored properties will not have any advantages for the player

- Once the player is unable to pay rent, he is eliminated since we have decided not to include the concept of mortages

- Square was made an abstract class to allow for custom methods and attributes within each of the specific squares. The abstract method squareAction allows the Game class to call it on each sqaure and have it perform the square specific action.

### User Manual:

-  Double click the jar file and select the number of players

- Type in "roll" to roll the dice and start the game

- Type in "help" for the list of commands

- Type in "quit" to quit the game

  

  
