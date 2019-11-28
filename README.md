# Vorgon Clicker

> 1. Team Members: Miguel Garcia, Nigel Bonnain, Joseph DeCarlo, Sergio Gutierrez, Hugo Sanchez
> 2. We are creating an idle clicker game for everyone.
> 3. For everyone
> 4. To eliminate boredom and pass time with an ever growing number.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Features](#features)
* [Student Entries](#student-entries)

## General info
![Icon Image](./img/ProjectIcon.png)

## Technologies
* Tech 1 - Java


## Features
List of features ready and TODOs for future development
* Click counter - it adds up the user's click
* Theme - Gives the game a visual aspect for the user
* Various clicking methods - It gives the user different ways to interact with the game


## Student entries
#### Hugo
Sprint 1:
* Initial implementation of core mechanic with Swing GUI (Click Mouse, increase counter, update screen). Commit seen 9/29/2019 Titled "Base Implementation".
    Served as a base to let the team spread out and add their sections.
* Theme Integration from research; See Research/Theme Research.txt
* Added 2nd currency and named both existing ones accordingly adding functions for both and integrated them into the GUI.

Sprint 2:
* Created the Client class which will function as a way for the player to spend currency 1, "time" and acquire currency 2 "money"
    * Code can be seen in src/Client.java
* Created the ClientList Class which is created in the controller which holds an array of the pre-created Clients. and methods on pointing to them.
    * Code can be seen in src/ClientList.java
* Created a list that will load all the clients. Has issues actually reading from the file.
    * List can be seen in src/clientList.txt
* Have a list on how to implement the save/load function but it cannot be integrated as of yet.

#### Nigel
* Application background music and button sound effects
* Sound.java artifact is in the src folder. The artifact is used to implement the background music for the application. The artifact is also used to implement sound effects for several buttons.
* My method is called first inside of main.

#### Joey

Sprint 1:
* Research for the game's UX; See Research/ux_research.txt. Information to be used to structure GUI and navigation.
* Create GUI - Created initial GUI based on our game features/modifiers such as jobs, power ups, and the shop.
    * Code is located in the src/View.java file.
* Research leaderboard implementation; See Research/leaderboard_research.txt. Information to be used to implement leaderboard based off of user statistics.

Sprint 2:
* Streamline the GUI - The user interface has been completely overhauled and is now less cluttered and more organized.
    * Code is located in the src/View.java file.
* Add interface elements to the shop, power ups, and jobs/clients pages.
    * Code is located in the files src/Shop.java, src/PowerUp.java, and src/ClientList.java respectively.
* Add listeners to graphical pages - make the interface elements react to interactions.
    * Code is located in the files src/View.java, src/Shop.java, src/PowerUp.java, and src/ClientList.java.

Sprint 3:
* Add new items to the shop - 'Cosmetic' modifiers that do not alter gameplay have been added to the shop.
    * Code is located in the Shop.java file.
* Statiscical information visibility - Information such as money available is visible where needed.
    * Code is located in the Shop.java file.
* Refactor code - Code has been refactored and cleaned up. The navigation button properties have been refactored.
    * Code is located in the View.java file.

#### Miguel

Sprint 1:
* Shop implementation. Player can use the shop to buy upgrades with the money they have earned in game.
  * Code is found in the src folder as shop.java.
* In game achievements that we could add; See Research/game_achievements.txt.
* Statistics that we can keep track of and provide; See Research/statistics_research.txt.
* Time base objects that could reward or hurt the player; See Research/tbo_research.txt.

Sprint 2:
* Stats implementation. Player can keep up with their stats; Code is found in the src folder as Stats.java
* Achievements implementation. Player can view their progress by completing achievements. Code is found is the src folder as Achievements.java
* Achievements list implementation. Create achievements list for the player to complete. Code is found is the src folder as AchievementsList.java 
* Feature: Get the achievements to update whenever the player completes it. It changes from red text to green text when achievement is completed.

#### Sergio
Sprint 1:
* Level calculation. Fuction calculates players level and updates continuously as player clicks.
 * See Research/PlayerProgressionResearch.txt
* Implementation of visual representation of Level status into top panel of Game HUD.
* Implemented Images for GUI by resizing and positioning within each appropriate panel of GUI. 

Sprint 2:
* Created the base structure and GUI design for the stats page. This page has three sections to it for the user to flip thorugh such as stats, achievements, and leaderboard. This was implemented in the "Updates to stats page ui" commit in github.
* Creted and implemented a fuctioning leaderboard to the stats page. This is used to an arcade style ranking to the players in the application. This is seen in the "Leaderboard Added to Stats Page" commit in github.

## Status
Polish has been added to our game's code and foundation. More features have been added on to improve the game. Improvements are to be made by ironing out any issues that arise and to continue adding new content.

* Miguel - Next step would be to implement random objects that could help or hurt the player.

* Hugo - Redoing the "Client" Classes to function properly as it serves a key feature of the primary core loop.

* Joey - Next step would be to add more content, such as more shop items and rewards. Also to iron out any issues to make a smoother user experience.

* Nigel - Next step would be to implement a wider genre of sounds for the current and future buttons. I will also be implementing a method that will boost possible points earned for a limited amount of time.

* Sergio - Next step would to add save/load file functionality so that players can continue their games after closing the application.
