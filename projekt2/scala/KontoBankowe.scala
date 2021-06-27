class KontoBankowe(var _stanKonta : Double) {

  def this() = this(0.0)

  def stanKonta: Double = _stanKonta

  def wplac(ilosc : Double): Unit ={
    _stanKonta = _stanKonta + ilosc
  }

  def wyplac(ilosc : Double): Unit ={
    if(ilosc <= stanKonta){
      _stanKonta = _stanKonta - ilosc
    }else{
      println("Za mało pieniedzy na koncie")
    }
  }

}
