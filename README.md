# Parkings de la ville de Bordeaux

Version : 0.0.1-SNAPSHOT

![Build Status](https://github.com/flake9025/bordeaux-parkings/workflows/Java%20CI/badge.svg)
[![Coverage](https://codecov.io/gh/flake9025/bordeaux-parkings/branch/master/graph/badge.svg)](https://codecov.io/gh/flake9025/bordeaux-parkings)

### Modules
Le projet "bordeaux" comprend les modules suivants:

* bordeaux-business : métier ( Services, DTO, Mappers )
* bordeaux-webapp : facade ( Web services, Swagger-UI )
* lacub-client : client de l'API de la ville de bordeaux (pourrait faire l'objet d'un projet indépendant)

### Utilisation

* dependencies : jdk 11, maven 3.6.0, Spring Boot 2.2
* compilation : mvn clean install
* main class : com.instantsystem.bordeaux.BordeauxApplication
* execution : java -jar bordeaux-webapp.jar
* swagger url : http://localhost:8080/bordeaux/swagger-ui.html

### References
Le projet exploite l'API WFS des parkings hors voirie de la ville de bordeaux :

* [API Documentation](https://opendata.bordeaux-metropole.fr/explore/dataset/st_park_p/information/)
* [Data source](http://data.lacub.fr/wfs?key=9Y2RU3FTE8&SERVICE=WFS&VERSION=1.1.0&REQUEST=GetFeature&TYPENAME=ST_PARK_P&SRSNAME=EPSG:4326)

