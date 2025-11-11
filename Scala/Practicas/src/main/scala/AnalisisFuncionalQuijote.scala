import scala.io.Source

object AnalisisFuncionalQuijote {

  // Definición de la ruta del archivo
  val ruta: String = "C:\\proyectos\\Scala\\quijote.txt"

  // Conjunto de palabras comunes para usar con 'partition'
  val palabrasComunes: Set[String] = Set(
    "el", "la", "los", "las", "un", "una", "unos", "unas", "de", "en",
    "a", "y", "o", "que", "se", "por", "es", "no"
  )

  /**
   * Función pura para limpiar y tokenizar una línea de texto.
   */
  def tokenize(line: String): List[String] = {
    line.toLowerCase
      .replaceAll("[^a-zA-Záéíóúüñ\\s]", "") // Eliminar puntuación, mantener letras y espacios
      .split("\\s+")                         // Dividir por espacios
      .filter(_.nonEmpty)                    // Filtrar cadenas vacías
      .toList
  }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
  def main(args: Array[String]): Unit = {
    println(s"Iniciando análisis funcional del archivo: $ruta")
    println("-" * 50)

    var fichero = Source.fromFile(ruta)

    try {
      // CARGA Y TOKENIZACIÓN DE PALABRAS (USO DE flatMap)
      val todasLasPalabras: List[String] = fichero.getLines()
                                                  .flatMap(tokenize)
                                                  // Materializa el Iterador en una lista inmutable
                                                  // para siguientes análisis
                                                  .toList

      if (todasLasPalabras.isEmpty) {
        println("El archivo está vacío o no contiene palabras procesables.")
        return
      }

      println(s"Total de palabras leídas (incluyendo repeticiones): ${todasLasPalabras.size}")
      println("-" * 50)

      // RECUENTO DE FRECUENCIA DE PALABRAS (USO DE foldLeft)
      val recuentoDePalabras: Map[String, Int] = todasLasPalabras.foldLeft(Map.empty[String, Int]) {
        (recuentos, palabra) =>
          // La función pura: actualiza el mapa inmutable
          recuentos + (palabra -> (recuentos.getOrElse(palabra, 0) + 1))
      }

      println("\nFrecuencia de Palabras (Top 5):")
      recuentoDePalabras.toList
                        .sortBy { case (_, count) => -count } // Ordenar de forma descendente
                        .take(5)
                        .foreach { case (palabra, count) =>
                          println(f"  $palabra%-10s -> $count%d")
                        }

      // FILTRADO Y RECUENTO (Uso de filter y count)
      val palabrasLargas: List[String] = todasLasPalabras.filter(_.length >= 8)

      val recuentoDePalabrasLargas: Int = palabrasLargas.size
      // Equivalente => todasLasPalabras.count(_.length >= 8)

      println("\nAnálisis de Longitud:")
      println(s"  Total de palabras de 8 o más letras (filter/count): $recuentoDePalabrasLargas")
      println(s"  Ejemplos: ${palabrasLargas.distinct.take(5).mkString(", ")}...")


      // AGRUPACIÓN (USO DE groupBy)
      val agrupadoPorInicial: Map[Char, List[String]] = todasLasPalabras
        .filter(_.nonEmpty)
        .groupBy(_.head) // Agrupar por la primera letra de la palabra

      println(s"\nAgrupación (groupBy):")
      println(s"  Número de letras iniciales distintas: ${agrupadoPorInicial.size}")
      agrupadoPorInicial.take(3).foreach { case (letra, palabras) =>
        println(s"  Palabras que empiezan con '$letra' (${palabras.size}): ${palabras.take(5).mkString(", ")}...")
      }

      // PARTICIÓN (USO DE partition)
      // Particionar por frecuencia
      val (frecuente, rara) = todasLasPalabras.partition(recuentoDePalabras(_) > 10)
      // Particionar por tipo
      val (comun, contenido) = todasLasPalabras.partition(palabrasComunes.contains) 

      println("\nPartición (partition):")
      println(s"  Palabras muy frecuentes (>10 veces): ${frecuente.distinct.size} palabras distintas.")
      println(s"  Palabras Comunes/Artículos (${comun.size}): ${comun.take(5).mkString(", ")}...")
      println(s"  Palabras de Contenido (${contenido.size}): ${contenido.take(5).mkString(", ")}...")

      // COLECCIÓN CON PATRÓN (USO DE collect)
      // Encontrar todas las palabras de 4 letras y convertirlas a su versión inversa
      val palabrasDe4LetrasInvertidas: List[String] = todasLasPalabras.distinct.collect {
        case palabra if palabra.length == 4 => palabra.reverse
      }

      println("\nColección y Transformación (collect):")
      println(s"  Palabras distintas de 4 letras invertidas: ${palabrasDe4LetrasInvertidas.take(5).mkString(", ")}...")


    } catch {
      case e: java.io.FileNotFoundException =>
        println(s"\nERROR: Archivo no encontrado en la ruta: $ruta")
        println("Por favor, asegúrate de que el archivo QUIJOTE.TXT exista en la ruta C:\\PROYECTOS\\SCALA.")
      case e: Exception =>
        println(s"Ocurrió un error inesperado: ${e.getMessage}")
    }
  }
}