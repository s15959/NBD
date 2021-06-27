trait Pracownik extends Osobka {
  var pensja : Double = 0
  override def podatek = this.pensja * 0.2

}
