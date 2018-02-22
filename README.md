[![Build Status](https://travis-ci.org/devopsicon/sales-microservice.svg?branch=develop)](https://travis-ci.org/devopsicon/sales-microservice)
[![Maintainability](https://api.codeclimate.com/v1/badges/630cd6efec7556bb413f/maintainability)](https://codeclimate.com/github/devopsicon/sales-microservice/maintainability)
[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![Docker Repository on Quay](https://quay.io/repository/devopsicon/salesmicroservice/status "Docker Repository on Quay")](https://quay.io/repository/devopsicon/salesmicroservice)


# Sales Microservice
Bodach Protection Corp's sales microservice responsible for providing sales capabilities to our fictional
application.

## Testing locations
* [Unit and Integration] (https://github.com/devopsicon/sales-microservice/tree/develop/src/test/java/com/devopsicon/microservices/sales)
* [Functional] (https://github.com/devopsicon/sales-microservice/tree/develop/src/cucumberTest)
* [Performance] (https://github.com/devopsicon/sales-microservice/tree/develop/src/perfTest)

## DevOps Automation Notes
* TravisCI configuration is via .travis.yml file
* Docker configuration is via Dockerfile

## Contribution Notes
1. This project uses Gradle and Lombok
2. All tests must be done as pre-merged checks
3. master and development branches is protected and only way to contribute is via Pull-Request
4. Unit and Integration testing coverage is monited via CodeClimate 

## TODO
1. Incorporate to CodeClimate
