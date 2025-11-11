import scala.collection.mutable.{HashMap, HashSet}
import scala.collection.immutable.ArraySeq
import scala.collection.mutable

case class Pedido(id: Int, producto: String, cantidad: Int) {

  // INVOCADO por colecciones basadas en Hash (HashSet, HashMap) al añadir o buscar.
  override def hashCode(): Int = {
    println(s"    [HASHCODE] Invocado para Pedido(ID: $id)")
    // Implementación estándar para la igualdad por contenido
    val result = id.hashCode() + producto.hashCode() + cantidad.hashCode()
    result
  }

  // INVOCADO por TODAS las colecciones al comparar contenido o resolver colisiones.
  override def equals(obj: Any): Boolean = obj match {
    case otro: Pedido =>
      println(s"    [EQUALS] Comparando Pedido(ID: $id) con Pedido(ID: ${otro.id})")
      // Implementación estándar de equals basada en los campos
      this.id == otro.id &&
      this.producto == otro.producto &&
      this.cantidad == otro.cantidad
    case _ => false
  }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////
object EqualsYHashCodeEnColecciones {
  def main(args: Array[String]): Unit = {
    val pedidoA = Pedido(id = 101, producto = "Laptop", cantidad = 1)
    val pedidoB = Pedido(id = 102, producto = "Monitor", cantidad = 2)
    val pedidoA_Duplicado = Pedido(id = 101, producto = "Laptop", cantidad = 1) // Mismo contenido que pedidoA

    // ////////////////////////////////////////////////////////////////////////////////////////////////
    // Colecciones Hash (HashSet y HashMap)
    // Invocan HASHCODE (para ubicación de la cubeta en el Hash y EQUALS (para detección de duplicados).
    // ////////////////////////////////////////////////////////////////////////////////////////////////
    println("----------------------------------------------------------------")
    println("Colecciones Hash (HashSet y HashMap) [HASHCODE + EQUALS]")
    println("----------------------------------------------------------------")

    val setPedidos = new mutable.HashSet[Pedido]()
    val mapPedidos = new mutable.HashMap[Pedido, String]()

    // Añadiendo pedidoA y pedidoB a HASHSET
    println("Añadiendo pedidoA a HASHSET ")
    setPedidos += pedidoA // HASHCODE
    println("Añadiendo pedidoB a HASHSET ")
    setPedidos += pedidoB // HASHCODE

    // HashSet: Añadiendo un duplicado
    println("\nHASHSET: Intentando añadir un duplicado (pedidoA_Duplicado)")

    // Se invoca a HASHCODE en el duplicado.
    // Se invoca a EQUALS para confirmar la colisión.
    setPedidos += pedidoA_Duplicado
    println(s"\nEl HashSet tiene ${setPedidos.size} elementos (el duplicado fue ignorado).")

    println("Añadiendo (pedidoA -> \"Cliente 1\")")
    mapPedidos += (pedidoA -> "Cliente 1")

    // HashMap: Búsqueda de clave por contenido
    println("\nHASHMAP: Búsqueda con clave por contenido Pedido(101, \"Portátil\", 1)")
    // Se invoca a HASHCODE en la clave para identificar la cubeta.
    // Se invoca a EQUALS para confirmar la unicidad.
    mapPedidos.get(Pedido(101, "Portátil", 1))

    // ////////////////////////////////////////////////////////////////////////////////////////////////
    // Colecciones Secuenciales (List, Vector, ArraySeq)
    // Sólo Invocan EQUALS para comparación de igualdad.
    // ////////////////////////////////////////////////////////////////////////////////////////////////

    println("\n----------------------------------------------------------------")
    println("Colecciones Secuenciales (List, Vector, ArraySeq) [SOLO EQUALS]")
    println("\n----------------------------------------------------------------")

    val listPedidos = List(pedidoA, pedidoB)
    val vectorPedidos = Vector(pedidoA, pedidoB)
    val arraySeqPedidos = ArraySeq(pedidoA, pedidoB)

    // List: Búsqueda con contains
    println("\nList.contains(Pedido(102, \"Monitor\", 2)) - Búsqueda por valor:")
    // Recorre secuencialmente, usando EQUALS en cada paso hasta encontrar el elemento.
    listPedidos.contains(Pedido(102, "Monitor", 2))

    // Vector: Uso de indexOf
    println("\nVector.indexOf(pedidoA_duplicado) - Busca la posición:")
    // Usa EQUALS para comparar el duplicado con los elementos originales.
    vectorPedidos.indexOf(pedidoA_Duplicado)

    // ArraySeq: Búsqueda con contains
    println("\nArraySeq.contains(Pedido(101, \"Laptop\", 1)) - Búsqueda por valor:")
    // Usa EQUALS. NO usa HASHCODE.
    arraySeqPedidos.contains(Pedido(101, "Laptop", 1))

    // Comparación entre dos colecciones (List == Vector)
    println("\nComparación de List == Vector:")
    val otraLista = List(pedidoA_Duplicado, Pedido(102, "Monitor", 2))
    // Compara elemento por elemento en orden, usando EQUALS para cada par.
    // Ambos son Seq[Pedido], así que la comparación devuelve true
    otraLista == vectorPedidos // true

    // ////////////////////////////////////////////////////////////////////////////////////////////////
    println("\n--- Resumen ---")
    // ////////////////////////////////////////////////////////////////////////////////////////////////
    println("Las colecciones basadas en Hash (HashSet, HashMap) necesitan HASHCODE para eficiencia.")
    println("Las colecciones secuenciales (List, Vector, ArraySeq) sólo necesitan EQUALS para verificar la igualdad de contenido.")
  }
}

