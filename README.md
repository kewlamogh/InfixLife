# InfixLife! 
## The super-amazing City making sandbox program in Kotlin.
## How to use
First copy paste/import all the classes. All of them (including `enum` and `data`)!
Next  create your first person like this:
```kt
val myFirstPerson = Person("FirstPerson", 100, Gender.MALE);
```
And your first community:
```kt
val myCommunity = Community();
```

## Functions
|Function|Purpose|
|---|---|
|`Person.getOlder(byHowMuch: Int = 1)`|Increases age of character by `byHowMuch`|
|`Person.findInteractions()`|Returns interactions of the character|
|`Person.findMyFriends(namesOnly: Boolean = true)`|Returns all friends of this `Person` instance. If `namesOnly` is true, it will only return names of friends, else it will return all info about friend.|
|`Person.intro()`|Gives brief intro of this `Person` instance|
|`Person isFriendsWith Person`|Adds `Person` #2 to `Person` #1's friends list and vice versa|
|`Person says Action`|`Person` says something, to construct an `Action` instance just type `(String to Person)`|
|`Person does String`|`Person` does something|
|`Community.people.add(person)`|Adds person to the `Community` instance|
|`Person.thingsDoneToday`|returns list of `String`s that contains all done today|
|`Community.newDay()`|New day for community; `thingsDoneToday` will be reset.| 

## Enjoy! What can you create with this?
