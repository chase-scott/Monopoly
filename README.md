# Monopoly Group 7

## Project Milestone 3 for SYSC 3110

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

Additional features: houses, hotels, and special properties and squares such as: jail, “Go”, railroad, utility. Also, the ability to use any number of “AI” players.

### Changes since last deliverable:

- Added new squares, including Railroad, Utility, Go to Jail, and Jail
- Added the option to have AI controlled players.
- Updated JUnit testing to account for the added features and funtionality
- Updated UML diagrams corresponding to up-to-date source codes and TA feedback

### Known issues:

None

### Roadmap ahead:

- Save/load features. You may use Java Serialization to 
achieve this. 
- International versions with custom street names, values and currencies. 
The customization may be defined in XML or JSON format.

### Decisions Made:

- Houses and hotels are implemented in accordance with the game. The player can click on a property in their list when they have a colour monopoly. Then, they can pay the fee which places a house on the property. Houses must be built symmetrically and upon building 4 houses, the 5 one will be a hotel.

- GoToJail square and utility square were made to extend sqaure.

- Railroad and utility were condensed into one class to avoid duplicated code, since they share much of the same functionality.

- For the AI, Player was converted into an abstract class. HumanPlayer and ComputerPlayer extend this class. ComputerPlayer changes the taketurn method, adding in the simple logic for making its decisions during its turn.

- AIPlayer's are created when a user doesn't specify a name for a player, since if they didn't add a name it is likely no one is controlling them.

- Some information pop-ups were factored out to only appear for human decisions, since it is not important for the player to see for the AI.

- The jail state initializes when a player rolls 3 doubles or lands on go to jail. A player may either pay $50 or attempt to roll a double to escape. If a player does either, they may roll again and take their turn. Alternatively, if a player has been in jail for 3 turns, they are automatically let out.

- AI's will always choose to pay their way out of jail if they can, they will always choose to buy a square they are on if they can, and will try to build one house/hotel per turn if they can.

### User Manual:

-  Double click the jar file and select the number of players, along with their names. If you exclude a name for a player, they will become AI controlled.

- Press "roll" to roll the dice and start the game

- Press "buy" to buy the property you are currently on

- Properties will appear in list that can be scrolled through

- When you control each property in a colour set, click on a property in the property list to build a house/hotel on it

- Press "pass" to pass the turn

- Relevant events will be shown in a screen pop-up

