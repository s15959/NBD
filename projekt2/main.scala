
object Main {

  val dni = List("Poniedziałek", "Wtorek", "Sroda", "Czwartek", "Piątek")
  val weekend = List("Sobota", "Niedziela")

  def main(args: Array[String]) = {

    println("Zadanie1")
    println(zadanie1("Poniedziałek"))
    println(zadanie1("Wtorek"))
    println(zadanie1("Sobota"))
    println(zadanie1("bleble"))


    println("Zadanie2")
    val konto = new KontoBankowe(300)
    println(konto.stanKonta)
    konto.wplac(20)
    println(konto.stanKonta)
    konto.wyplac(50)
    println(konto.stanKonta)
    konto.wyplac(1000)
    println(konto.stanKonta)


    println("Zadanie3")
    println(zadanie2(new Osoba("Karolina","Nowak")))
    println(zadanie2(new Osoba("Karol","Kowalski")))
    println(zadanie2(new Osoba("Ala","Kot")))


    println("Zadanie4")
    println(zadanie4(10,x => x+1))
    println(zadanie4(2,x => x*2))


    println("Zadanie5")
    var pracownik = new Osobka("Robert","Kłos") with Pracownik
    pracownik.pensja = 4000
    println("Pracownik -> pensja: " + pracownik.pensja + ", podatek: " + pracownik.podatek)

    var student = new Osobka("Robert","Kłos") with Student
    println("Student -> podatek: " + student.podatek)

    var nauczyciel = new Osobka("Anna","Miś") with Nauczyciel
    nauczyciel.pensja = 3000
    println("Nauczyciel -> pensja: "  + nauczyciel.pensja + ", podatek: " + nauczyciel.podatek)

    var studentPracownik = new Osobka("Jan","Tak") with Student with Pracownik
    studentPracownik.pensja = 6000
    println("Student potem pracownik -> pensja: " + studentPracownik.pensja + ", podatek: " + studentPracownik.podatek)

    var pracownikStudent = new Osobka("Tomasz","Kot") with Pracownik with Student
    pracownikStudent.pensja = 4000
    println("Pracownik potem student -> pensja: " + pracownikStudent.pensja + ", podatek: " + pracownikStudent.podatek)
  }

  def zadanie1(x: String): String ={
    x match {
      case a if (dni.contains(a)) => ("Praca")
      case b if (weekend.contains(b)) => ("Weekend")
      case _ => ("Nie ma takiego dnia")
    }
  }

  def zadanie2(osoba: Osoba) = osoba match {
      case Osoba("Karolina", "Nowak") => "Witaj Karolina"
      case Osoba("Karol", "Kowalski") => "Cześć Karol"
      case Osoba(imie, nazwisko) => "Dzien dobry " + imie + " " + nazwisko
    }

  def zadanie4(x:Int, function: Int => Int): Int ={
    var m = x
    for (i <- 1 to 3){
      m = function(m)
    }
    return m
  }

}
