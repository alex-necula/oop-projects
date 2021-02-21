# Energy System Stage 2

## About

Object-Oriented Programming, CD Series 2020-2021

<https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa2>

Student: Necula Alexandru, 322CD

## Running tests

Test#Main class

- Runs solution on tests in `checker/`, comparing results with reference
- Runs checktyle

Details about tests: checker/README

Libraries necessary for implementation:

- Jackson Core
- Jackson Databind
- Jackson Annotation

## Implementation

- We read the input using an `ObjectMapper` and create our database
- We keep a `Database` object of all entities and another `Database` object
  where we will remove the bankrupt entities
- We use the **Factory Pattern** to create actions  that are applied to our
  database (**Command pattern**)
- Finally, output is written using the same `ObjectMapper`

### List of classes and packages

- **action**: contains all the classes that help run the actions in the
  simulation (includes subpackages *distributor*. *producer* and *consumer*,
  depending on the type of entity they modify)
  - abstract class `AbstractAction` implements the `Runnable` interface
  - enum `ActionType` defines the type of the actions that are applied

- **entities**: contains all the classes that shape consumers, producers and
  distributors, including the relationships between them (e.g. `Contract`,
  `Penalty`)
  - `Payee` and `Payer` are interfaces that help process payments between
    entities. `AbstractFinancialEntity` implements both
  - enum `EntityType` defines the types of entities (`Consumer`, `Producer` and
    `Distributor`)
  - `EntityFinder` finds an entity in the database by ID

- **fileio**: classes `Input` and `Database` that interact with the input and
  output of our program

- **observer**:
  - `BankruptcyRemover` removes an entity from the database once it becomes
    bankrupt
  - `ContractExpiredRemover` deletes a contract from the consumer once it
    expires
  - `ProducerUpdateObserver` sets a flag that makes a distributor search for new
    producers

- **strategies**: contains classes that help a distributor choose producers
  according to its needs

- **updates**: defines classes that pack the input of a monthly update
  (`DistributorChange`, `ProducerChange` and `MonthlyUpdate`)

- **utils**: `Utils` class contains static methods that help with parsing

### Flow

The Main class controls the simulation. There is one initial round followed by
multiple monthly rounds. We create a list of actions using `ActionFactory`,
according to the order specified in a statement and run them using
`ActionExecutor` We also add the required observers for our classes.

### OOP Design

Encapsulation is implemented across all classes in this project. Inheritance and
abstractization were used for modelling the following classes:

- all actions extend the `AbstractAction` class
- all strategies implement the `EneergyChoiceStrategy` interface
- producers, distributors and consumers extend the `AbstractEntity` class

### Design patterns

There are several design patterns implemented in this project:

- **Factory Design Pattern**: used to create actions and strategies
- **Command Design Pattern**: used to apply actions on the database
- **Strategy Design Pattern**: used to choose producers according to a specific
  criteria
- **Observer Design Pattern**:
  - observer `BankruptcyRemover` with observable `AbstractFinancialEntity`
  - observer `ContractExpiredRemover` with observable `Contract`
  - observer `ProducerUpdateObserver` with observable `Producer`
- **Singleton Design Pattern**: implemented by `EnergyChoiceStrategyFactory`,
  `ActionFactory` and `ActionExecutor`