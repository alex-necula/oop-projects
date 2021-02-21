# VideosDB - POO Homework

## Necula Alexandru - 322CD

### The workflow of the app is structured as stated below

- We create the repository based on the classes in the `fileio` package and
  store it in the **Repository** class (we use **RepositoryLoader** and
  **RepositoryHelper** classes to process the data)
- The **Action** interface represents a generic action and contains one method
  called `getResultMessage`
- For each action taken from input, we use the **ActionFactory** class to create
  an object that is an instance of a specific class that implements the
  **Action** interface (**Factory Deisgn Pattern**)
- the String created by the `getResultMessage` method is added to the
  `JSONArray` and is printed to the output files

### List of packages included in the archive

- **action**: contains all the classes that help run the actions from input
  (includes subpackages *command*, *query*, *recommendation*)
  - abstract classes *Query*, *Command* and *Recommendation* implement the
    *Action* interface
  - each specific command from input has its own class
- **actor**:
  - class *Actor*
  - enum *ActorAwards*
- **checker**
- **common** :
  - class *Constants*
- **entertainment**: contains all classes that help represent a show or a movie
  - classes *Movie* and *Season* implement the *Ratable* interface which
    contains one method called `addRating` (a user can only rate a movie or a
    season)
  - classes *Show* and *Movie* extend the abstract class *Video*
- **fileio**: input classes
- **main**: our entry point
- **repository**:
  - class *Repository* contains lists of users, actors and videos (our database)
  - class *RepositoryLoader* creates the repository based on an **Input** class
  - class *RepositoryHelper* contains methods `findUser` and `findVideo` that
    return the corresponding object based on its username or title
- **user**:
  - class *User*
- **utils**:
  - class *Pair* with generic type
    - in my implementation, it is used as `Pair<Object, Double>` which
      associates an Actor/Video with a number that can represent a rating,
      number of awards, number of views etc.
    - it makes sorting a list of pairs easy (compared to a *Map*)
  - class *Utils* with static methods
