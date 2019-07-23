# mtgManager

## Install

Install project dependencies:

```
sudo apt-get install openjdk-11-jdk npm maven
sudo apt-get update
sudo npm install -g @angular/cli
```

Install Neo4j database:

```
wget -O - https://debian.neo4j.org/neotechnology.gpg.key | sudo apt-key add -
echo 'deb https://debian.neo4j.org/repo stable/' | sudo tee /etc/apt/sources.list.d/neo4j.list
sudo apt-get update
sudo apt-get install neo4j
```

Clone git repository:

```
cd $WORKSPACE/
git clone https://github.com/Louis-JJ/mtgManager.git
```

## Start Application

### Neo4j

Start Neo4j database:

```
sudo systemctl start neo4j
```

Access to Neo4j web UI by [http://localhost:7474](http://localhost:7474) and change the default password:

* user: neo4j
* default password: neo4j

Change neo4j password in file mtgManager/src/main/resources/application.properties (line 3).

### Springboot Rest Controller

Launch Spring-boot server by command line or IDE (target class **TestCardsBootAngPostApplication**).

You can build and run a **jar** using maven:

```
cd $WORKSPACE/mtgManager/
mvn clean install
cd target/
java -jar demo-0.0.1-SNAPSHOT.jar
```

The springboot rest server is now listening on [http://localhost:8080](http://localhost:8080).
You can test it using [http://localhost:8080/cards](http://localhost:8080/cards).

### Angular

Serve the angular code:

```
cd $WORKSPACE/mtgManager/cardsClients/
ng serve
```

You can now access to angular UI: [http://localhost:4200](http://localhost:4200).