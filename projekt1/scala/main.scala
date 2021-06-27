import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`

object Main {
  def main(args: Array[String]) = {

    val dniTygodnia = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")


    println("Zadanie 1.a")
    println(zadanie1a(dniTygodnia))

    println("Zadanie 1.b")
    println(zadanie1b(dniTygodnia))

    println("Zadanie 1.c")
    println(zadanie1c(dniTygodnia))


    println("Zadanie 2.a")
    println(zadanie2a(dniTygodnia))

    println("Zadanie 2.b")
    println(zadanie2b(dniTygodnia))


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
    x
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

  def zadanie2a(dniTygodnia: List[String]): String = {

    if (dniTygodnia.tail.isEmpty != true) {
      dniTygodnia.head + ", " + zadanie2a(dniTygodnia.tail)
    } else {
      dniTygodnia.head
    }
  }

  def zadanie2b(dniTygodnia: List[String]): String = {
    if(dniTygodnia.tail.isEmpty != true){
      zadanie2b(dniTygodnia.tail) + ", " + dniTygodnia.head
    }else{
      dniTygodnia.head
    }
  }

  def zadanie3(dniTygodnia: List[String]) = {
    @tailrec
    def addAnotherDay(daysOfTheWeek: List[String], combinedString: String): String = {
      if (daysOfTheWeek.isEmpty) {
        combinedString
      } else {
        addAnotherDay(daysOfTheWeek.tail,combinedString + ", " + daysOfTheWeek.head)
      }
    }
    addAnotherDay(dniTygodnia.tail,dniTygodnia.head)
  }

  def zadanie4a(dniTygodnia: List[String]): String = {
    dniTygodnia.foldLeft("") {
      (sum, curr) => {
        sum + (if (curr == dniTygodnia.head) curr else ", " + curr)
      }
    }
  }

  def zadanie4b(dniTygodnia: List[String]): String = {
    dniTygodnia.foldRight("") {
      (sum, curr) => {
        sum + (if(curr == dniTygodnia.last) curr else ", " + curr)
      }
    }
  }

  def zadanie4c(dniTygodnia: List[String]): String = {
    dniTygodnia.foldLeft("") {
      (sum, curr) => {
        if (curr.startsWith("P")) {
          sum + (if(curr == dniTygodnia.head) curr else ", " + curr)
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




  def zadanie9(lista: List[Int]): List[Int] = {
    lista.map(x => x + 1)
  }

  def zadanie10(lista: List[Double]): List[Double] = {
    val filteredList = lista.filter(x => x >= -5 && x <= 12)
    filteredList.map(x => x.abs)
  }



}