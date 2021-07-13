
class Person(val name: String, var age: Int, val gender: Gender) {
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
                output.add(iterator.name)
            }
            return output
        } else {
            return this.myFriends
        }
    }
    fun intro(): String {
        return "My name is ${this.name}. I am ${this.age} and am a ${this.gender.toString().lowercase()}."
    }
	infix fun isFriendsWith(otherPerson: Person) {
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

enum class Gender {MALE, FEMALE}
infix fun String.to(person: Person): Action {
    return Action(person, this)
}
data class SidePair(val first: List<Person>, val second: List<Person>)
data class Action(val person: Person,  val msg: String)
