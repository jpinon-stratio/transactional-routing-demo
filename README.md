# Transactional Routing Demo

This project demonstrates how transactional routing solution behaves when there's a RO transactional context nested in a
RW transactional context.

## What do I need?

* maven
* docker & docker compose
* jdk 8

## How do I run it?

Open a terminal and set the path to project root, then perform those commands below.

Start up both postgreSQL db:

```
cd docker
docker compose up -d
```

Create RW db table and populate it:

```
docker exec -it postgresRw bash
psql -U postgres -d transactional_routing
*copy paste src/main/resources/rw.sql content*
```

Create RO db table and populate it:

```
docker exec -it postgresRo bash
psql -U postgres -d transactional_routing
*copy paste src/main/resources/ro.sql content*
```

Run the project:

```
mvn spring-boot:run
```

## How do I demonstrate it?

First of all check that everything is setup correctly.

RW db content:

```
curl http://localhost:8080/rw/cars
[{"brand":"Renault","model":"Clio"}]
```

RO db content:

```
curl http://localhost:8080/ro/cars
[{"brand":"Volkswagen","model":"Passat"}]
```

Clone a car, getting it through RO transactional context:

```
curl -X POST http://localhost:8080/rw/cars/new
```

Check if car cloned was gotten in RW or in RO db:

```
curl http://localhost:8080/rw/cars
[{"brand":"Renault","model":"Clio"},{"brand":"Renault","model":"Clio"}]
```

## Conclusions

When you nest a RO transactional context inside a RW transactional context, all db request are done to the RW db.