package leer_archivos

import scala.util.{Properties, Using}
import scala.io.Source

object LeerArchivos extends App {

  leer_lineas()

  def leer_lineas(): Unit = {
    // Usa variable de entorno "Ruta" o por defecto el de resources
    val path = Properties.envOrElse("Ruta", "src/main/resources/access.log")

    // Using cierra el recurso automáticamente
    val source = Source.fromFile(path)
        .getLines()
        .filter(_.contains("404"))
        .map(_.toUpperCase)
        .take(5)
        .foreach(println)

    val cuantos = Source.fromFile(path)
      .getLines()
      .count(_.contains("404"))

    println(s"\nTotal de líneas con 404: $cuantos")

  }


}

