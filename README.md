# Monopoly Group 7

## Project Milestone 4 for SYSC 3110

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

- Save/load features using java serialization.
- International versions with custom street names, values and currencies in XML format.
- XML document is parsed using an API called SAX.

### Changes since last deliverable:

- Added the abillity to save and load game files.
- Added the ability to choose differing international versions of Monopoly.

### Known issues:

None

### Roadmap ahead:

- This is the last milestone.

### Decisions Made:

- Choosing versions is done upon creating new games.
- Version information is stored in an XML, this is then parsed for the information

### User Manual:

-  Double-click the jar file and select if you would like to start a new game or load a game

-  If you click new game, first choose your version, then the number of players. Inpit eacha player's names.

-  If you exclude a name for a player, they will become AI controlled.

- Press "roll" to roll the dice and start the game

- Press "buy" to buy the property you are currently on

- Properties will appear in list that can be scrolled through

- When you control each property in a colour set, click on a property in the property list to build a house/hotel on it

- Press "pass" to pass the turn

- Press "File" menu bar and select "Save" to save a game or "Load" to load a previously saved game

- Relevant events will be shown in a screen pop-up

****