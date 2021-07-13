//Infix Life
val opposites = mutableListOf<SidePair>()
fun main() {
    val amogh = Person("Amogh", 9, Gender.MALE)
    val dad = Person("Prashant", 253, Gender.MALE)
    val mom = Person("Archana", na, Gender.FEMALE)
    val abhay = Person("Abhay", 1, Gender.MALE)
    val bob = Person("Bob", 4, Gender.MALE)
    
    val washington = communityOf(amogh, abhay, bob, dad, mom)
    
    val doofinschmertz = Person("Doofinschmertz", 30, Gender.MALE)
    
    val somethingOppositeWashington = communityOf(doofinschmertz)
        
    
    washington isOppositeTo somethingOppositeWashington
	
    amogh says (amogh.intro() to bob)
    bob says (bob.intro() to amogh)
    amogh says ("Lets play UNO!" to bob)
    bob says ("sure!" to amogh) 
    amogh does "UNO"
    bob does "UNO"
    amogh does "eat dinner"
    bob does "eat dinner"
    newDayFor(washington)
}
val na: Int = 0
fun newDayFor(systemOfCreatures: List<Person>) {
   for (i in systemOfCreatures) {
      i.thingsDoneToday = mutableListOf<String>()
   }
   for (i in opposites) {
       val thisSide = i.first
       val otherSide = i.second
       newDayFor(thisSide)
       newDayFor(otherSide)
   }
}


fun communityOf(vararg members: Person): List<Person> {
    return members.toList()
}
infix fun List<Person>.isOppositeTo(otherCommunity: List<Person>) {
    opposites.add(SidePair(this, otherCommunity))
    newDayFor(otherCommunity)
}
