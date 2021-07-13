//Infix Life
fun main() {
    val bob = Person("Bobby", 15, Gender.MALE)
    val jackie = Person("Jackie", 9, Gender.FEMALE)
    val community = listOf<Person>(bob, jackie)
    bob says ("Hello Jackie. Do you wanna play Exploding Snap?" to jackie)
    jackie says ("Hello, Bob! Sure! I'd love to." to bob) 
    bob isFriendsWith jackie
    bob does "play exploding snap"
    jackie does "play exploding snap"
    bob does "eat dinner"
    jackie does "eat dinner"
    newDayFor(community)
}

class Person(val name: String, var age: Int = 0, val gender: Gender) {
    val myFriends: MutableList<Person> = mutableListOf()
    val interactions: MutableMap<String, String> = mutableMapOf()
    var thingsDoneToday = mutableListOf<String>()
    fun getOlder(byHowMuch: Int = 1) {
        this.age += byHowMuch
    }
    fun findInteractions(): String {
        return "["+this.interactions.toString().replace("}", "").replace("{", "").replace("=", ": ") +"]"
    }
    fun findMyFriends(getNamesOnly: Boolean): Any {
        var output = mutableListOf<Any>()
        if (getNamesOnly) {
        	for (iterator in this.myFriends) {
                if (iterator is Person) {output.add(iterator.name)}
            }
            return output
        } else {
            var thisOutput: MutableList<Person> = this.myFriends
            return thisOutput
        }
        return mutableListOf("ERROR: function failed (idk this isn't supposed to be executed xD)")
    }
    fun intro(): String {
        return "My name is ${this.name}. I am ${this.age} and am a ${this.gender.toString().lowercase()}."
    }
	infix fun isFriendsWith(otherPerson: Person) {
    	this.myFriends.add(otherPerson)
    	otherPerson.myFriends.add(this)
	}
    
	infix fun Person.isFriendsWith(otherPerson: Person) {
    	this.myFriends.add(otherPerson)
    	otherPerson.myFriends.add(this)
	}
    infix fun says(otherPerson: Action) {
		this.interactions["Me to ${otherPerson.person.name}"] = otherPerson.msg
    	otherPerson.person.interactions["${this.name} to me"] = otherPerson.msg
	}
    infix fun does(action: String) {
    	this.thingsDoneToday.add(action)
    }
    
}
fun newDayFor(systemOfCreatures: List<Person>) {
   for (i in systemOfCreatures) {
      i.thingsDoneToday = mutableListOf<String>()
   }
}
enum class Gender {MALE, FEMALE}
infix fun String.to(person: Person): Action {
    return Action(person, this)
}

data class Action(val person: Person,  val msg: String)
