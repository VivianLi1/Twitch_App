# Flagmoji Quiz

A small game that lets you test your flag recognition skills.

## Overview

Quiz Fragment, Quiz Presenter, Quiz Model

- Primary feature of the application
- Quiz indicates the quiz feature: choosing the correct country for the displayed flag
- The Quiz fragment is contained by the Main Activity
- Quiz Model is where the API call is made to Countries GraphQL API to retrieve list of countries (flag emoji and name).
- Quiz Model forms the quiz elements: randomly chooses a country’s flag to display as well as 3 other countries to be additional answers.
- Quiz Model uses Shared Preferences to keep track of user score. When needed, it will increment the score and updates the Shared Preference.

Main Activity, Main Presenter 

- Entry point of the application
- Holds the Quiz fragment
- App bar functionality (switch between Main Activity and Settings Activity)

Settings Activity, Settings Presenter, Settings Model

- Extends Main Activity
- Allows for various settings such as dark mode, score reset, and a prize that is only accessible after user reaches a target score
- These settings are stored in Shared Preferences as well and will be remembered upon reboot of application.
- Prize Button switches to Prize Activity.

Prize Activity

- Display Activity only.
- Utilizes Konfetti library to display confetti upon creation.
- Only accessible once user reaches a certain score.

## Architecture

This application utilizes Model View Presenter (MVP) architectural pattern. Each view (Quiz, Main, Settings) had respective presenters that interacted with the models if necessary. These models would in turn send data/changes to the presenters that could change the view if necessary.

## Screenshots and User Flow

The user is first presented with app bar and the quiz view. The user can get straight into the game: choose the correct country name for the flag displayed. Once the user chooses an answer, a snackbar will be displayed indicating if the user answer is correct. If it is the score will increment. Otherwise, the snackbar will notify the user of the correct answer. 

The app bar allows the user to go to the settings page. There is an indicator that tells the user that they must reach a certain score in order to unlock the prize page. Additionally, there is a reset button that allows users to reset their score (must be confirmed via a dialog). There is also a toggle that can switch between light and dark mode.

## Additional technologies used

- [Countries GraphQL API](https://github.com/trevorblades/countries)
- [Konfetti Library](https://github.com/DanielMartinus/Konfetti)

## Material Components Used

- App Bar
- Button
- Dialog
- Toggle
- Snackbars

## Future Development

- Improved UI/themes.
  - It is very basic at the moment and I would like to add more of a personal flair to it.
- Improved project architecture/structure.
  - I would like to refactor some of my code. I feel that there could be better separation of concerns and less redundancy.
- Better use of Strings resource 
  - Less hardcoded text values
