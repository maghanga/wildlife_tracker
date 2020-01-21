# Wildlife Tracker

Wildlife tracker is Spark java web application whereby a user can record sightings of animals in a forest that is about to be cleared out as an environmental impact measure of the exercise. A user can enter the name of the animal and state whether it is is endangered or not.

## Author
[Nehru O'neil](https://github.com/thinknehru)

## Getting started
You can use the editor of your choice but for this case I used [Idea IntelliJ](https://www.jetbrains.com/idea/download/)

If you don't have java already installed
Install JDK(Java Development Kit) through the following command:
```bash
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
```
We use gradle as our dependency manager as it is scripted unlike maven so to install gradle, do the following:
```bash
sudo apt install gradle
```
To get started with the wildlife tracker you need to do the following :
```bash
mkdir myprojects
cd myprojects
git clone https://github.com/thinknehru/wildlife-tracker.git
```
Make sure you recreate the database on your local machine. To do that execute the following schema:
It might or might not work so try
```$xslt
CREATE DATABASE wildlife_tracker;
CREATE TABLE animals(id serial PRIMARY KEY,name VARCHAR);
CREATE TABLE endangered(id serial PRIMARY KEY,name VARCHAR,health VARCHAR,age INTEGER);
CRATE TABLE sightings(......)
```

## Usage
Afer cloning the repository and changing to the directory run the following commands to launch the app

```bash
gradle build
gradle run
```
In the terminal locate the url showing your spark server
You can navigate to [http://localhost:4567/](http://localhost:4567/) as it works with most spark appications
You can the add the animal which thereafter you can add to endangered animals

## Technologies used
In the following app we used the following technologies
* Java
* Spark
* Handlebars
* H2

## Contributions
You can contribute to this project by making a pull requestor e-mail me at thinknehru@gmail.com

## About me
`Nehru O'neil` Java and Angular front-end developer

## License
MIT license &copy;
