package quijote

import scala.io.{Source, StdIn}

object quijote extends App {

  leerQuijote()

  def leerQuijote(): Unit = {
    val ruta_archivo = "Z:\\\\quijote.txt"
    println("Introduce la palabra a buscar")

    val palabraABuscar = StdIn.readLine()

    val source = Source.fromFile(ruta_archivo)

    source
      .getLines()
      .map(_.toUpperCase())
      .filter(_.contains(palabraABuscar.toUpperCase))
      .take(5)
      .foreach(println)

    val resultado = source.getLines()
      .map(_.toUpperCase())
      .count(_.contains(palabraABuscar))


    //upper o lower
    //IMprimir las primeras 5 lineas de que tengan la palabra indicada
  }
}
