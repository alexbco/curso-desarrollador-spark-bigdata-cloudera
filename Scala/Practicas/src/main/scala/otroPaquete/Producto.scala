package otroPaquete

class Producto(val id: String = "N/A",
               val nombre: String = "Nombre por defecto",
               val precio: Double = 10.0) {

  // Los valores por defecto en los parámetros de la clase
  // hacen que el código de constructores auxiliares
  // no sea necesario
  //////////////////////////////////////////////////////////////
  // Constructor Auxiliar 1: Acepta solo el nombre.
  // Invoca al constructor principal con valores por defecto.
//  def this(nombre: String) = {
//    this("N/A", nombre, 0.0) // Llama al constructor primario
//  }
//
//  // Constructor Auxiliar 2: Acepta id y nombre, precio por defecto.
//  // Invoca al Constructor Auxiliar 1.
//  def this(id: String, nombre: String) = {
//    this(id, nombre, 10.0)
//  }

  override def toString: String = s"Producto(ID: $id, Nombre: $nombre, Precio: $precio)"
}
