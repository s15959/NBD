import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main {
  def main(args: Array[String]) = {

    val dniTygodnia = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")


    println("Zadanie 1.a")
    zadanie1a(dniTygodnia)

    println("Zadanie 1.b")
    println(zadanie1b(dniTygodnia))

    println("Zadanie 1.c")
    println(zadanie1c(dniTygodnia))


    println("Zadanie 2.a")
    println(zadanie2a(dniTygodnia))

    println("Zadanie 2.b")
    println(task2b(dniTygodnia))


    println("Zadanie 3")
    println(zadanie3(dniTygodnia))


    println("Zadanie 4.a")
    println(zadanie4a(dniTygodnia))

    println("Zadanie 4.b")
    println(zadanie4b(dniTygodnia))

    println("Zadanie 4.c")
    println(zadanie4c(dniTygodnia))


    println("Zadanie 5")
    val produkty = Map("Jabłka" -> 4, "Pomarańcze" -> 5, "Kiwi" -> 6)
    println(zadanie5(produkty))


    println("Zadanie 6")
    zadanie6("abc", 3, dniTygodnia)


    println("Zadanie 7")
    val jablka = produkty.get("Jabłka")
    println(jablka)
    val pomarańcze = produkty.get("Pomarańcze")
    println(pomarańcze)


    println("Zadanie 8")
    val lista8 = List(4, 5, 0, 0, -2, -432, 43111, 0, 5, -234, 0)
    println(zadanie8(lista8))



    println("Zadanie 9")
    val lista9 = List(4, 5, 0, 0, -2, -432, 43111, 0, 5, -234, 0)
    println(zadanie9(lista9))


    println("Zadanie 10")
    val lista10 = List(-3212.4, -4323.0, -9.2, -2.432, -1.555, 0.43, 1.432, 2.000, 6.1, 7.6, 9.654, 11.345, 15.23, 743.0)
    println(zadanie10(lista10))
  }

  def zadanie1a(dniTygodnia: List[String]) = {
    var x = "";
    for (i <- 0 to (dniTygodnia.length - 1)) {
      if (x == "") {
        x += dniTygodnia.get(i)
      } else {
        x += ", " + dniTygodnia.get(i)
      }
    }
    println(x)
  }

  def zadanie1b(dniTygodnia: List[String]) = {
    var x = "";
    for (i <- 0 to (dniTygodnia.length - 1)) {
      if (dniTygodnia.get(i).startsWith("P")) {
        if (x == "") {
          x += dniTygodnia.get(i)
        } else {
          x += ", " + dniTygodnia.get(i)
        }
      }
    }
    x;
  }

  def zadanie1c(dniTygodnia: List[String]) = {
    var x = ""
    var i = 0;
    while (i < dniTygodnia.length) {
      if (x == "") {
        x += dniTygodnia.get(i)
      } else {
        x += ", " + dniTygodnia.get(i)
      }
      i = i + 1;
    }

    x
  }

  def zadanie2a(dniTygodnia: List[String]) = {

    if (!dniTygodnia.tail.isEmpty)
      dniTygodnia.head + ", " //+ zadanie2a(dniTygodnia.tail)
    else
      dniTygodnia.head
  }

  def task2b(daysOfTheWeek: List[String]): String = {
    def addAnotherDay(i: Int): String = {
      if (i == -1) return ""

      val currentDay = if (i == 0) daysOfTheWeek.get(i) else daysOfTheWeek.get(i) + ", "

      currentDay + addAnotherDay(i - 1)
    }

    addAnotherDay(daysOfTheWeek.length - 1)
  }

  def zadanie3(daysOfTheWeek: List[String]) = {
    @tailrec
    def addAnotherDay(daysOfTheWeek: List[String], combinedString: String): String = {
      if (daysOfTheWeek.isEmpty)
        combinedString
      else
        addAnotherDay(daysOfTheWeek.tail,combinedString + ", " + daysOfTheWeek.head)
    }
    addAnotherDay(daysOfTheWeek.tail,daysOfTheWeek.head)
  }

  def zadanie4a(daysOfTheWeek: List[String]): String = {
    daysOfTheWeek.foldLeft("") {
      (sum, curr) => {
        sum + (if (curr == daysOfTheWeek.head) curr else ", " + curr)
      }
    }
  }

  def zadanie4b(daysOfTheWeek: List[String]): String = {
    daysOfTheWeek.foldRight("") {
      (sum, curr) => {
        sum + (if(curr == daysOfTheWeek.last) curr else ", " + curr)
      }
    }
  }

  def zadanie4c(daysOfTheWeek: List[String]): String = {
    daysOfTheWeek.foldLeft("") {
      (sum, curr) => {
        if (curr.startsWith("P")) {
          sum + (if(curr == daysOfTheWeek.head) curr else ", " + curr)
        } else {
          sum
        }
      }
    }
  }

  def zadanie5(produkty : Map[String,Int]) = {
    produkty.map {
      case (k, v) => (k, v * 1.1)
    }
  }

  def zadanie6(tup: (String, Int, Any)) = {
    println(tup._1)
    println(tup._2)
    println(tup._3)
  }


  def zadanie8(lista1: List[Int], lista2: List[Int] = List.empty): List[Int] = {
    lista1 match {
      case Nil => lista2
      case 0 :: tail => zadanie8(tail, lista2)
      case head :: tail => zadanie8(tail, lista2 :+ head)
    }
  }


  def zadanie9(lista: List[Int]): List[Int] = {
    lista.map(x => x + 1)
  }

  def zadanie10(lista: List[Double]): List[Double] = {
    val filteredList = lista.filter(x => x >= -5 && x <= 12)
    filteredList.map(x => x.abs)
  }



}