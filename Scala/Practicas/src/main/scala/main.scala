import otroPaquete.Producto
import scala.io.Source
import scala.util.Properties
import scala.io.StdIn
import scala.collection.mutable
import scala.util.Random
import scala.util.control.Breaks.*

object main extends App {

  //  rangosTiposDatos()
  //  pruebasVal()
  //  pruebasVar()
  //  leerArchivos()
  //  leerQuijote()
  //  leerDatosConsola()
  //  ejercicio1()
  //  ejercicio2()
  //  ejercicio3()
  //  regionInterrumpible()
  //  adivinarNumeroSecreto()
  //  evaluacionConCortocircuito()
  //  evaluacionSinCortocircuito()
  //  ejemplosAny(700)
  //  sentenciasCondicionales()
  //  esBisiestoSentenciaIf(2000)
  //  esBisiestoExpresionIf(1900)
  //  esBisiestoExpresionIf(2004)
  //  esBisiestoPatternMatchingAsignandoAVariable(1900)
  //  esBisiestoPatternMatchingAsignandoAVariable(1600)
  //  esBisiestoPatternMatchEjecutandoInstrucciones(1900)
  //  esBisiestoPatternMatchEjecutandoInstrucciones(2004)
  //  aplicarDuracionAHorasMinutosSegundos()
  //  esBisiesto()
  //  diaDeLaSemana()
  //  finDeSemanaOLaborable()
  //  pruebasStrings()
  //  invertirCadena()
  //  eliminarCaracteresDuplicados()
  //  pruebasTuplas()
  //  ejercicioTuplas()
  //  pruebasTraversableIterable()
  //  pruebasSeq()
  //  pruebasSet()
  //  pruebasList()
  //  ejercicioSepararNumerosEnListas()
  //  ejercicioListasFoldLeftContadores()
  //  ejercicioListasFoldLeftCreandoListas
  //  pruebaEficienciaFoldLeft()
  //  ejercicioSepararNumerosDesdeArchivo()
  //  separarNumerosNoFuncional(List(1,2,  -3, 44, 0, 0, -55, -73))
  //  pruebasArrays()
  //  pruebasVector()
  //  pruebasMap()
  //  alumnosYCalificaciones()
  //  sumarYContarNumeros()
  //  contarOcurrenciasDePalabras()
  //  buclesScala()
  //  cartasBarajaEspanola()
  //  iteradoresScala()
  //  creacionDeFunciones()
  //  pasoDeFuncionesComoArgumentos()
  //  metodosIteracionColecciones()
  //  patternMatching()
  //  funcionesParciales()
    libreriasScala()

  def leerQuijote(): Unit = {

    val rutaArchivo: String = "C:\\cesar\\desarrollador cloudera 2025\\Scala\\quijote.txt"

    println("Introduce la palabra a buscar: ")

    val palabraABuscar = StdIn.readLine.toUpperCase

    val source = Source.fromFile(rutaArchivo)

    println("-------------------------------------")
    println("Primeras 5 líneas del archivo")
    println("-------------------------------------")

    source.getLines
      .map(_.toUpperCase())
      .filter(_.contains(palabraABuscar))
      .take(5)
      .foreach(println)

    println("-------------------------------------")
    println(s"¿Cuantas ocurrencias de la palabra \"${palabraABuscar}\"?")
    println("-------------------------------------")

    val resultado = source.getLines
      .map(_.toUpperCase())
      .count(_.contains(palabraABuscar))

    println(resultado)

  }

  def rangosTiposDatos(): Unit = {
    //    println("Rango de valores para el tipo Byte: desde " + Byte.MinValue + " hasta " + Byte.MaxValue)

    println(s"Rango de valores para el tipo Byte (8 bits): desde ${Byte.MinValue} hasta ${Byte.MaxValue}")
    println(s"Rango de valores para el tipo Short (16 bits): desde ${Short.MinValue} hasta ${Short.MaxValue}")
    println(s"Rango de valores para el tipo Int (32 bits): desde ${Int.MinValue} hasta ${Int.MaxValue}")
    println(s"Rango de valores para el tipo Long (64 bits): desde ${Long.MinValue} hasta ${Long.MaxValue}")

    println(s"Rango de valores para el tipo Float (32 bits): desde ${Float.MinValue} hasta ${Float.MaxValue}")
    println(s"Rango de valores para el tipo Double (64 bits): desde ${Double.MinValue} hasta ${Double.MaxValue}")

  }

  def pruebasVal(): Unit = {

    //    val byte1: Byte = 127
    //    val byte2: Byte = 1
    //
    //    println(s"El tipo de dato de la variable byte1 es ${byte1.getClass}")
    //    println(s"El tipo de dato de la variable byte2 es ${byte2.getClass}")
    //
    //    val resultado: Byte = (byte1 + byte2).toByte
    //
    //    println(s"El tipo de dato de la variable resultado es ${resultado.getClass}")
    //
    //    println(s"Resultado: ${resultado}")

    val long1 = 2147483647L
    val int2 = 1

    println(s"El tipo de dato de la variable long1 es ${long1.getClass}")
    println(s"El tipo de dato de la variable int2 es ${int2.getClass}")

    val resultado = long1 + int2

    println(s"El tipo de dato de la variable resultado es ${resultado.getClass}")

    println(s"Resultado: ${resultado}")

    val s = "Titanic 4000"
    println(s)

    println(s"El tipo de dato de la variable s es ${s.getClass}")

    val flotante = Float.MaxValue + 100

    println(s"El tipo de dato de la variable byte1 es ${flotante.getClass}")
    println(flotante)

    println(Double.MaxValue)
  }

  def pruebasVar(): Unit = {

    var numero = 17
    println(numero)

    numero = 29
    println(numero)

    numero = 98
    println(numero)

  }

  def leerArchivos(): Unit = {
    val datadir = Properties.envOrElse("RUTA", "C:\\cesar\\desarrollador cloudera 2025\\Scala\\")

    var source = Source.fromFile(datadir + "access.log")

    source.getLines
      .take(5)
      .foreach(println)

    source.getLines
      .filter(_.contains(" 404 "))
      .map(_.toUpperCase)
      .take(5)
      .foreach(println)

    source = Source.fromFile(datadir + "access.log")

    val resultado = source.getLines
      .count(_.contains(" 404 "))

    println(resultado)

  }

  def leerDatosConsola(): Unit = {

    var str: String = StdIn.readLine("Introduce valor:\n")

    println(s"El valor introducido es ${str}")

    println("Introduce un valor numérico:")
    var numero = StdIn.readInt()

    println(s"El valor introducido es ${numero}")

  }

  def ejemplosAny(valorGenerico: Any): Unit = {

    // getClass indica el tipo específico!!
    println("El parámetro es de tipo " + valorGenerico.getClass)

    if (valorGenerico.isInstanceOf[String]) {

      val miString = valorGenerico.asInstanceOf[String] // cast
      println(s"Y podemos invocar directamente a métodos como toUpperCase: ${miString.toUpperCase}")

    }
    else if (valorGenerico.isInstanceOf[Integer]) {
      val miEntero = valorGenerico.asInstanceOf[Integer]
      println(s"Y podemos sumar o multiplicar el valor: ${miEntero + 10}")

    }
    else {
      println("El valor no es un String ni un Integer y no se puede convertir de forma segura.")
    }

    // lo mismo pero con pattern matching
    valorGenerico match {
      case miString: String =>

        println(s"Y podemos invocar directamente a métodos como toUpperCase: ${miString.toUpperCase}")

      case miEntero: Integer =>

        println(s"Y podemos sumar o multiplicar el valor: ${miEntero + 10}")

      case _ =>
        println("El valor no es un String ni un Integer y no se puede convertir de forma segura.")
    }
  }

  def esBisiestoSentenciaIf(year: Int): Unit = {
    println(s"\n--- Solución con Sentencia IF ---")

    if (year < 1582) {
      println(s"El año ${year} está fuera del calendario Gregoriano")
      return
    }

    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
      println(s"El año $year es Bisiesto.")
    } else {
      println(s"El año $year NO es Bisiesto.")
    }
  }

  def esBisiestoExpresionIf(year: Int): Unit = {
    // La expresión IF devuelve el String que se asigna

    if (year < 1582) {
      println(s"El año ${year} está fuera del calendario Gregoriano")
      return
    }

    val resultado = if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
      "Bisiesto"
    } else {
      "NO Bisiesto"
    }

    println(s"\n--- Solución con Expresión IF ---")
    println(s"El año $year es $resultado.")
  }

  def esBisiestoPatternMatchingAsignandoAVariable(year: Int): Unit = {

    if (year < 1582) {
      println(s"El año ${year} está fuera del calendario Gregoriano")
      return
    }

    val esBisiesto: Boolean = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

    // Evaluamos la variable booleana 'esBisiesto'
    val resultado = esBisiesto match {
      case true => "Bisiesto"
      case false => "Nn Bisiesto"
    }

    println(s"\n--- Solución con Pattern Matching asignando a variable---")
    println(s"El año $year es $resultado.")
  }

  def esBisiestoPatternMatchEjecutandoInstrucciones(year: Int): Unit = {

    if (year < 1582) {
      println(s"El año ${year} está fuera del calendario Gregoriano")
      return
    }

    println(s"\n--- Comprobando año $year con Pattern Matching ejecutando instrucciones---")

    val esBisiesto: Boolean = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

    // El match evalúa 'esBisiesto'
    esBisiesto match {
      case true =>
        // Instrucción para el caso TRUE
        println(s"$year: ¡Es un año bisiesto!")

      case false =>
        // Instrucción para el caso FALSE
        println(s"$year: No es un año bisiesto.")
    }
  }

  def sentenciasCondicionales(): Unit = {

//        val num1 = 10
//        val num2 = 20
//
//        if (num1 > num2) {
//          println(s"${num1} es mayor que ${num2}")
//        } else if (num1 < num2) {
//          println(s"${num1} es menor que ${num2}")
//        } else {
//          println(s"${num1} es igual que ${num2}")
//        }
//
        println("Introduzca un valor numérico entero:")
        var numero = StdIn.readInt()
//
//        if (numero < 0)
//          println(s"El número $numero es negativo")
//        else if (numero > 0 )
//          println(s"El número $numero es positivo")
//        else
//          println(s"El número $numero es igual a cero")

        // Expresiones if
        var resultado =   if (numero < 0) "negativo"
                          else if (numero > 0) "positivo"
                          else "igual a cero"

        println(s"El número $numero es $resultado")

        // pattern matching para ejecutar instrucciones
        numero match {
          case menor if (numero < 0) => println(s"El número $menor es negativo")
          case mayor if (numero > 0) => println(s"El número $mayor es positivo")
          case _ => println(s"El número $numero es igual a cero")
        }

        //    pattern matching asignando valor a una variable
        resultado = numero match {
                                case menor if (numero < 0) => "negativo"
                                case mayor if (numero > 0) => "positivo"
                                case _ => "igual a cero"
                                }
        println(s"El número $numero es $resultado")

    // Preguntando por valores concretos:
        val num1 = 1

        val resultado2 = num1 match {
                                    case 1 | 2 | 3  => "entre 1 y 3"
                                    case 4 | 5 | 6  => "entre 4 y 6"
                                    case _ => "en otros casos"
                                    }
        println(s"El número $num1 está comprendido $resultado2")
    //
  }


  ///////////////////////////////////////////////////////////////////////////////////////////
  // Ejercicio 1:
  // Solicita al usuario su nombre y muestra un mensaje de bienvenida.
  ///////////////////////////////////////////////////////////////////////////////////////////
  def ejercicio1(): Unit = {
    val nombre = StdIn.readLine("Introduce tu nombre: ")
    println("¡Hola, " + nombre + "! Bienvenido/a.")
    println(s"¡Hola, ${nombre} ! Bienvenido/a.")

  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  // Ejercicio 2: Operaciones matemáticas
  // Solicita dos números y muestra la suma, resta, multiplicación y división.
  def ejercicio2(): Unit = {
    val a = StdIn.readDouble()
    val b = StdIn.readInt()
    println("Suma: " + (a + b))
    println("Resta: " + (a - b))
    println("Multiplicación: " + (a * b))
    println("División: " + (a / b))
  }

  ///////////////////////////////////////////////////////////////////////////////////////////
  // Ejercicio 3: Conversión Celsius a Fahrenheit
  // Solicita una temperatura (flotante) en °C conviértela a °F.
  // Fórmula: (grados_celsius * 9 / 5 + 32)
  def ejercicio3(): Unit = {
    println("Introduce temperatura en grados Celsius:")
    val celsius = StdIn.readDouble()
    val fahrenheit = celsius * 9.0 / 5.0 + 32
    println(celsius + " °C son " + fahrenheit + " °F")
  }

  def regionInterrumpible(): Unit = {
    // es necesario importar import scala.util.control.Breaks._
    breakable {
      for (numero <- 1 to 5) {

        if (numero == 3) {
          break()
        }
        println(numero)
      }
    }
  }

  def evaluacionConCortocircuito(): Unit = {

    if (metodoFalse() && metodoTrue()) {

      println("El resultado final es true")

    }
  }

  def evaluacionSinCortocircuito(): Unit = {

    if (metodoFalse() & metodoTrue()) {

      println("El resultado final es true")

    }
  }

  def metodoTrue(): Boolean = {
    println("Ejecutando método con valor true")
    true
  }

  def metodoFalse(): Boolean = {
    println("Ejecutando método con valor false")
    false
  }

  def esBisiesto(): Unit = {
    println("Introduzca un año: ")
    val year = StdIn.readInt()

    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
      println(s"$year es un año bisiesto")
    else
      println(s"$year no es un año bisiesto")

  }

  def diaDeLaSemana(): Unit = {

    println("Introduce un número del 1 al 7:")
    val numeroDia = StdIn.readInt()

    val dia = numeroDia match {
      case 1 => "Lunes"
      case 2 => "Martes"
      case 3 => "Miércoles"
      case 4 => "Jueves"
      case 5 => "Viernes"
      case 6 => "Sábado"
      case 7 => "Domingo"
      case _ => "un día inválido"
    }
    println(s"El día número ${numeroDia} es ${dia}")
  }

  def finDeSemanaOLaborable(): Unit = {

    println("Introduce un día de la semana el letras: ")

    val diaSemana = StdIn.readLine().toLowerCase()

    val resultado = diaSemana match {
      case "lunes" | "martes" | "miercoles" | "miércoles" | "jueves" | "viernes" => "un día laborable"
      case "sabado" | "sábado" | "domingo" => "fin de semana"
      case _ => "un día de la semana inválido"
    }

    println(s"El ${diaSemana} es ${resultado}")

    // solución con Normalize
    //    var dia = "sábadó"
    //    dia = Normalizer.normalize(dia, Normalizer.Form.NFD)
    //    dia = dia.replaceAll("[^\\p{ASCII}]", "").toLowerCase()
    //
    //    println(dia)

  }

  def pruebasStrings(): Unit = {

    println("Scala\\text")
    println(raw"Scala\text")
    println("""Scala\text""")

    val style = "MeTookqwhkjswlwswsjlkñ 4.1"
    val oneChar: Char = style(2)
    println(oneChar)

    val version = style.substring(style.indexOf(" ") + 1)
    println(s"Versión: ${version}")

    val s = "bananas, apples, and oranges"
    println("Ordenado: [" + s.sorted + "]")
    println(s.toUpperCase)
    println(s.toArray.mkString("Array(", "-", ")"))

    val par = s.splitAt(4)
    println(par.getClass)
    println("(" + par._1 + ")-(" + par._2 + ")")

    println(s.split(',').mkString("Array(", ")-(", ")"))

    var cadena = "Hola Mundo"

    for (letra <- cadena) {

      println(letra)

    }

    for (indice <- 0 until cadena.length) {

      println(cadena(indice))

    }

    /////////////////////////////////////////////////////////////////////////////////////
    //
    //        var str1 = "Hola"               // pool de Strings internos (reutilizables)
    //        var str2 = "Hola"               // pool de Strings internos (reutilizables)
    //        var str3 = new String("Hola")   // mala práctica
    //
    ////     para Strings en scala == equivale al método equals
    //        if (str1 == str3) {
    //          println("Los strings son considerados iguales (==)")
    //        }
    //
    ////     comparación por valor
    //        if (str1.equals(str3)) {
    //          println("Los strings son considerados iguales (equals())")
    //        }
    //
    ////     comparación por referencia (Integridad referencial)
    //        if (str1.eq(str3)) {
    //          println("Las variables apuntan al mismo objeto (eq())")
    //        }
    //        else {
    //          println("Las variables apuntan a objetos distintos (eq())")
    //        }
    //
    //        println(System.identityHashCode(str1))
    //        println(System.identityHashCode(str2))
    //        println(System.identityHashCode(str3))
    //
    //        str3 = str3.intern()
    //
    //        println(System.identityHashCode(str1))
    //        println(System.identityHashCode(str2))
    //        println(System.identityHashCode(str3))
    //
    //        str2 = "Otra cosa"
    //
    //        println(System.identityHashCode(str1))
    //        println(System.identityHashCode(str2))
    //        println(System.identityHashCode(str3))
    //
    //        str2 = new String("Hola")
    //
    //        println(System.identityHashCode(str1))
    //        println(System.identityHashCode(str2))
    //        println(System.identityHashCode(str3))
    //
    //    val palabra = "MeToo 4.1"
    //
    //    val oneChar = palabra(2)
    //
    //    println(s"El caracter en posición 2 es ${oneChar}")
    //
    //    for (letra <- palabra) {
    //
    //      println(letra)
    //
    //    }
    //
    //    val subs = palabra.substring(2, 5)
    //    println(subs)
    //
    //    val s = "bananas, apples, and oranges"
    //    println(s.sorted)
    //
    //    println(s.toArray.mkString("Array(", ", ", ")"))
    //
    //    println(s.split(',').mkString("Array(", ", ", ")"))
    //
    //    println(s.splitAt(4))
    //
  }

  def invertirCadena(): Unit = {

    println("Introduce una cadena de caracteres: ")
    val cadena = StdIn.readLine
    var invertida = ""

    // Recorremos la cadena desde el último carácter hasta el primero
    for (indice <- 0 until cadena.length) {
      invertida = cadena(indice) + invertida
    }

    println(s"Cadena original: $cadena")
    println(s"Cadena invertida: $invertida")
  }

  def eliminarCaracteresDuplicados(): Unit = {

    print("Introduce una cadena: ")
    val cadena = StdIn.readLine()

    var resultado = ""

    for (c <- cadena) {
      // Solo añadimos el carácter si aún no está en 'resultado'
      if (!resultado.contains(c)) {
        resultado += c
      }
    }

    println(s"Cadena original: $cadena")
    println(s"Sin duplicados: $resultado")
    println(s"Sin duplicados y ordenada para comparar mejor: ${resultado.sorted}")

  }

  def pruebasTuplas(): Unit = {

    val t1 = Tuple1("dato")

    // Ejemplo de map devolviendo tuplas
    val productos = List("manzana", "banana", "cereza", "dátil")

    // Usamos 'map' para transformar cada String en un par (String, Int)
    val tuplasDeProducto: List[(String, Int)] = productos.map(nombre => (nombre, nombre.length))
    // Equivalentes
    // val tuplasDeProducto: List[(String, Int)] = productos.map(nombre => (nombre -> nombre.length))
    // val tuplasDeProducto: List[(String, Int)] = productos.map(nombre => Tuple2(nombre -> nombre.length))

    println(tuplasDeProducto)

    val myTup2 = 4 -> "iFruit"
    println(s"${myTup2._1}, ${myTup2._2}")

    println(myTup2.swap)

    // Procesamiento de tuplas con productIterator
    for (elemento <- myTup2.productIterator) {
      println(s"Valor de la tupla: ${elemento}")
    }

    // Procesamiento funcional con foreach
    myTup2.productIterator
          .foreach(elemento => println(s"Valor de la tupla: ${elemento}"))

    // En Scala 3, el límite de 22 para tuplas y funciones fue eliminado.
    val tuplaGrande = (1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                      11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                      21, 22, 23, "Más datos")

    println(tuplaGrande.getClass)

    println(tuplaGrande)
    tuplaGrande.productIterator.foreach(println)

    val myTup6 = ("Plato", "Kant", "Voltaire", "Descartes", "deBeauvoir", "Camus")
    println(s"Product Prefix: ${myTup6.productPrefix}")

    println(s"Product Arity: ${myTup6.productArity} ")

    // Convertir Tupla en String
    val myStr = myTup6.toString
    println(s"String creado a partir de la tupla: $myStr")

    // Convertir String en Tupla
    val newTup = myStr.partition(_.isUpper)
    println(s"Tupla creada a partir del String: $newTup")

    println(s"Tipo de dato después de partition: ${newTup.getClass}")

    // Iniciales ordenadas
    println(s"Iniciales ordenadas: ${newTup._1.sorted}")

  }

  def ejercicioTuplas(): Unit = {

    val tuplaProducto = (9812, "Bebida refrescante", 1.55, 450, "2025-10-01")

    // Extracción de datos de producto
    val idProducto = tuplaProducto._1
    val nombreProducto = tuplaProducto._2
    val fechaCaducidadProducto = tuplaProducto._5

    // Mostrar info de producto
    println(s" Id de producto: $idProducto € \n " +
      s"Nombre: $nombreProducto \n " +
      s"Fecha de caducidad: $fechaCaducidadProducto €")

    // Guardar en una tupla los datos del producto
    val tuplaDatosProducto = (idProducto, nombreProducto, fechaCaducidadProducto)

    println("------------------------------------")

    // Extracción de datos para calcular el importe total
    val precioUnitario = tuplaProducto._3
    val cantidadStock = tuplaProducto._4

    // Cálculo del Valor Total
    val valorTotalStock = precioUnitario * cantidadStock

    // Mostrar info de stock
    println(s" Precio: $precioUnitario € \n " +
            s"Cantidad: $cantidadStock \n " +
            s"Valor total: $valorTotalStock €")

    // Guardar en una tupla los datos del stock
    val tuplaStock = (precioUnitario, cantidadStock, valorTotalStock)


  }

  def pruebasTraversableIterable(): Unit = {
    // Deprecado en favor de Iterable
    val modelTrav = Traversable("MeToo", "Ronin", "iFruit")
    modelTrav.foreach(println)

    val modelIterable = Iterable("MeToo", "Ronin", "iFruit")

    // Podemos usar foreach
    modelIterable.foreach(println)

    // Acceso al iterador
    var iteradorModeIterable = modelIterable.iterator

    // Procesamiento en bucle while con next
    while (iteradorModeIterable.hasNext) {

      val elemento = iteradorModeIterable.next()

      println(s"Valor en bucle while con next: $elemento")
    }

    // El iterador se agota después del procesamiento!!
    // Necesitamos acceder de nuevo al iterador!!

    // También podemos acceder al iterador en bucle for
    for (elemento <- iteradorModeIterable.iterator) {
      println(s"Valor en bucle for: -> $elemento")
    }

  }

  def pruebasSeq(): Unit = {

    val mySeq = Seq("MeToo", "Ronin", "iFruit")

    // realmente se instancia List!!
    println(mySeq.getClass)
    println(s"Elemento en índice 1: ${mySeq(1)}")

    // Acceso mediante rango con length
    for (indice <- 0 until mySeq.length) {
      println(s"Valor en bucle for (acceso por índice): ${mySeq(indice)}")
    }

    // Acceso mediante rango con indices
    for (indice <- mySeq.indices) {
      println(s"Valor en bucle for (acceso por índice): ${mySeq(indice)}")
    }

    // Acceso mediante iterador implícito
    for (valor <- mySeq) {
      println(s"Valor en bucle for: $valor")
    }

    // Acceso mediante método foreach
    mySeq.foreach(valor => println(s"Valor en foreach: $valor"))

  }

  def pruebasSet(): Unit = {

    var mySet = Set("Titanic", "Sorrento", "Ronin", "Titanic", "Sorrento", "Ronin")

    println(s"Tamaño del set: ${mySet.size}")

    // imprimir tipo
    println(s"Tipo de dato: ${mySet.getClass}")

    // comprobar la existencia de valores en el Set
    println(s"Existe Ronin en el set?: ${mySet("Ronin")}")

    // mejor con contains por claridad
    println(s"Existe Ronin en el set?: ${mySet.contains("Ronin")}")

    println(s"Id del set ${System.identityHashCode(mySet)}\n" +
      s"Contenido del nuevo Set: ${mySet}")

    // eliminación de elementos con drop()
    mySet = mySet.drop(1)

    println(s"Id del set ${System.identityHashCode(mySet)}\n" +
      s"Contenido del nuevo Set: ${mySet}")

    // eliminación de elementos con -=
    mySet -= "Ronin"

    println(s"Id del set ${System.identityHashCode(mySet)}\n" +
      s"Contenido del nuevo Set: ${mySet}")

    // añadir elementos (devuelve un nuevo Set)

    // si añadimos un elemento ya existente el objeto sigue siendo el mismo
    // y el duplicado no se añade
    mySet = mySet + "Sorrento"

    println(s"Id del set ${System.identityHashCode(mySet)}\n" +
      s"Contenido del nuevo Set: ${mySet}")

    mySet = mySet + "Nuevo elemento"

    println(s"Id del set ${System.identityHashCode(mySet)}\n" +
      s"Contenido del nuevo Set: ${mySet}")

    // CREACIÓN DE SET MUTABLES
    val myMutableSet = mutable.Set("Uno", "Dos", "Tres")

    // imprimir tipo
    println(s"Tipo de dato: ${myMutableSet.getClass}")

    println(s"Id del set mutable ${System.identityHashCode(myMutableSet)}\n" +
      s"Contenido del nuevo Set: ${myMutableSet}")

    myMutableSet += "Cuatro"

    println(s"Id del set mutable ${System.identityHashCode(myMutableSet)}\n" +
      s"Contenido del nuevo Set: ${myMutableSet}")

    myMutableSet += "Cuatro"

    println(s"Id del set mutable ${System.identityHashCode(myMutableSet)}\n" +
      s"Contenido del nuevo Set: ${myMutableSet}")

    myMutableSet.drop(1) // esto crea siempre un Set nuevo!!!!!!

    println(s"Id del set mutable ${System.identityHashCode(myMutableSet)}\n" +
      s"Contenido del nuevo Set (después de eliminar): ${myMutableSet}")

    //    // ¿Cuántos elementos tienen más de 5 letras?

    val palabras = Set("gato", "perro", "elefante", "jirafa", "pez")

    //        val masDe5Letras = palabras.count(_.length > 5)
    //      alternativa
    //        val masDe5Letras = palabras
    //        .map(_.length)
    //        .filter(_ > 5)
    //        .size
    //      alternativa
    //        val masDe5Letras = palabras
    //        .map(_.length)
    //        .count(_ > 5)
    //      alternativa
    //        val (masDe5Letras, resto) = palabras.partition(_.length > 5)
    //        println(s"Hay ${masDe5Letras.size} palabras con más de 5 letras. Que son: ${masDe5Letras.mkString(", ")}.")

    //        println(s"Número de palabras con más de 5 letras: $masDe5Letras")
    //

    //    // eliminar elementos que comienzan por la letra 'p'

    val elementosSinP = palabras.filterNot(_.startsWith("p"))
    println(elementosSinP)

  }

  def pruebasList(): Unit = {

    val newList = "a" :: "b" :: "c" :: Nil

    println(s"Tipo de dato de la lista: ${newList.getClass}")

    println(s"Id de la lista ${System.identityHashCode(newList)}\n" +
            s"Contenido de la lista: ${newList}")

    val models = List("Titanic", "Sorrento", "Ronin")

    println(s"Tipo de dato de la lista: ${models.getClass}")

    println(s"Id de la lista ${System.identityHashCode(models)}\n" +
            s"Contenido de la lista: ${models}")

    println(s"Elemento en posición 1: ${models(1)}")


    val randomList = List("iFruit", 3, "Ronin", 5.2)

    for (elemento <- randomList) {

      println(elemento.getClass)

    }

    val devices: List[(String, Int)] = List(("Sorrento", 10), ("Sorrento", 20), ("iFruit", 30))

    println(s"Tipo de dato de la lista: ${devices.getClass}")

    //    /////////////////////

    val myList: List[Int] = List(1, 5, 7, 1, 3, 2)
    println(s"Suma de los elementos de la lista: ${myList.sum}")
    println(s"Máximo valor en la lista: ${myList.max}")
    println(s"Primeros 3 elementos de la lista ${myList.take(3)}")
    println(s"Elementos ordenados: ${myList.sorted}")
    println(s"Elementos ordenados al revés: ${myList.sorted.reverse}")

    // Unión o intersección de listas
    val myListA = List("iFruit", "Sorrento", "Ronin")
    val myListB = List("iFruit", "MeToo", "Ronin")
    val myListC = myListA.concat(myListB)
    // equivalente
    val myListD = myListA ++ myListB

    println(s"¿Coinciden myListC y myListD?: ${myListC == myListD}")

    val myListE = myListA.intersect(myListB)

    println(s"ListA: ${myListA} - ${System.identityHashCode(myListA)}")
    println(s"ListB: ${myListB} - ${System.identityHashCode(myListB)}")
    println(s"ListC: ${myListC} - ${System.identityHashCode(myListC)}")
    println(s"ListD: ${myListD} - ${System.identityHashCode(myListD)}")
    println(s"ListE: ${myListE} - ${System.identityHashCode(myListE)}")

    val myListF = myListA :+ "Valor al final"     // añade elementos al final

    val myListG = "Valor al principio" +: myListF // añade elementos al principio

    println(s"myListF: ${myListF}")
    println(s"myListG: ${myListG}")


    // ListBuffer es mutable

    val listBuf = mutable.ListBuffer.empty[Int]
    // equivalente
//    val listBuf: mutable.ListBuffer[Int] = mutable.ListBuffer()

    println(s"Tipo de dato de la lista: ${listBuf.getClass}")
    println(s"Id de la lista ${System.identityHashCode(listBuf)}\n" +
            s"Contenido de la lista: ${listBuf}")

    listBuf += 17

    println(s"Id de la lista ${System.identityHashCode(listBuf)}\n" +
            s"Contenido de la lista: ${listBuf}")

    listBuf += 29

    println(s"Id de la lista ${System.identityHashCode(listBuf)}\n" +
            s"Contenido de la lista: ${listBuf}")
//
//    listBuf += 45
//
//    println(s"Id de la lista ${System.identityHashCode(listBuf)}\n" +
//      s"Contenido de la lista: ${listBuf}")
//
//    listBuf -= 17
//
//    println(s"Id de la lista ${System.identityHashCode(listBuf)}\n" +
//      s"Contenido de la lista: ${listBuf}")
//
//
  }

  def ejercicioSepararNumerosEnListas(): Unit = {

    println("Introduce números separados por comas: ")
    val listaNumeros = StdIn.readLine()
                            .split(",")
                            .flatMap(_.trim.toIntOption)
                            .toList

    val positivos = listaNumeros.filter(_ > 0)
    val negativos = listaNumeros.filter(_ < 0)
    val ceros = listaNumeros.filter(_ == 0)

    println(s"Números positivos: ${positivos} - ${positivos.size}")
    println(s"Números negativos: ${negativos} - ${negativos.size}")
    println(s"Ceros: ${ceros} - ${ceros.size}")

  }

  def ejercicioSepararNumerosDesdeArchivo(): Unit = {

    val source = Source.fromFile("C:\\proyectos\\numeros.csv")

    val todosLosNumeros = source.getLines()
                                .toList
                                .flatMap { linea =>
                                          // Dividir la línea por comas ("," )
                                          linea.split(",")
                                               // Eliminar espacios y convertir a Int
                                               .flatMap(s => s.trim.toIntOption)
                              }

    // Separar los números en diferentes listas con filter
    val positivos = todosLosNumeros.filter(_ > 0)
    val negativos = todosLosNumeros.filter(_ < 0)
    val ceros = todosLosNumeros.filter(_ == 0)

    // Imprimir los resultados
    println("-" * 40)
    println(s"Números positivos: ${positivos} - Recuento: ${positivos.size}")
    println(s"Números negativos: ${negativos} - Recuento: ${negativos.size}")
    println(s"Ceros: ${ceros} - Recuento: ${ceros.size}")
  }

  def ejercicioListasFoldLeftContadores(): Unit = {

    val (neg, cero, pos) = StdIn.readLine("Introduce números separados por comas: ")
                                .split(",")
                                .map(_.trim.toInt)
                                .foldLeft((0, 0, 0)) {
                                  case ((negativos, ceros, positivos), valor) => (

                                    negativos + (if valor < 0 then 1 else 0),
                                    ceros + (if valor == 0 then 1 else 0),
                                    positivos + (if valor > 0 then 1 else 0)

                                  )
      }
    println(s"Negativos: $neg, Ceros: $cero, Positivos: $pos")

  }

  def ejercicioListasFoldLeftCreandoListas(): Unit = {

    val (neg, cero, pos) = StdIn.readLine("Introduce números separados por comas: ")
      .split(",")
      .flatMap(_.trim.toIntOption)
      .foldLeft(List[Int](), List[Int](), List[Int]()) {

        case ((positivo, negativo, cero), n) =>
          if (n > 0) (n :: positivo, negativo, cero)
          else if (n < 0) (positivo, n :: negativo, cero)
          else (positivo, negativo, n :: cero)
      }

    println(s"Negativos: $neg, Ceros: $cero, Positivos: $pos")

  }

  def pruebaEficienciaFoldLeft(): Unit = {
    val rnd = new Random()
    val numeros = List.fill(10_000_000)(rnd.between(-1000, 1001))

    var inicio = System.nanoTime()
    var tuplaNums = numeros.foldLeft((0, 0, 0)) {
      case ((negativos, ceros, positivos), valor) => (
        negativos + (if valor < 0 then 1 else 0),
        ceros + (if valor == 0 then 1 else 0),
        positivos + (if valor > 0 then 1 else 0)
      )
    }
    var fin = System.nanoTime()
    println(s"Tiempo ejecución con case ${(fin - inicio) / 1000000000.0}  segundos")

    inicio = System.nanoTime()
    tuplaNums = numeros.foldLeft((0, 0, 0)) { (acum, e) =>
      val (pos, neg, cer) = acum
      if (e > 0) (pos + 1, neg, cer)
      else if (e < 0) (pos, neg + 1, cer)
      else (pos, neg, cer + 1)
    }
    fin = System.nanoTime()
    println(s"Tiempo ejecución con if ${(fin - inicio) / 1000000000.0}  segundos")
  }

  def separarNumerosNoFuncional(lista: List[Any]): Unit = {
    val positivos = mutable.ListBuffer.empty[Int]
    val negativos = mutable.ListBuffer.empty[Int]
    val ceros = mutable.ListBuffer.empty[Int]

    for (elem <- lista) {
      elem match {
        case n: Int =>
          if (n > 0) positivos += n
          else if (n < 0) negativos += n
          else ceros += n

        case s: String if !s.isBlank =>
          val num = s.trim.toInt
          if (num > 0) positivos += num
          else if (num < 0) negativos += num
          else ceros += num

        case _ => // ignorar
      }
    }
    // Imprimir los resultados
    println("-" * 40)
    println(s"Números positivos: ${positivos.mkString("Array(", ", ", ")")} - Recuento: ${positivos.size}")
    println(s"Números negativos: ${negativos.mkString("Array(", ", ", ")")} - Recuento: ${negativos.size}")
    println(s"Ceros: ${ceros.mkString("Array(", ", ", ")")} - Recuento: ${ceros.size}")
  }

  def pruebasArrays(): Unit = {

    val devs = Array("iFruit", "MeToo", "Ronin")

    println(s"Id del Array antes de modificar elementos: ${System.identityHashCode(devs)}")

    // modificar elementos
    devs(2) = "Titanic"

    println(s"Id del Array ${System.identityHashCode(devs)}\n" +
            s"Contenido del Array: ${devs.mkString("Array(", ", ", ")")}\n" +
            s"Tamaño del Array: ${devs.length}")

    //    /////////////////////////////////////////////

    val devices: Array[String] = new Array[String](4)

    println(s"Id del Array ${System.identityHashCode(devices)}\n" +
            s"Contenido del Array: ${devices.mkString("Array(", ", ", ")")}\n" +
            s"Tamaño del Array: ${devices.length}")

    // modificación de elementos
    devices.update(0, "Sorrento")

    println(s"Id del Array ${System.identityHashCode(devices)}\n" +
            s"Contenido del Array: ${devices.mkString("Array(", ", ", ")")}\n" +
            s"Tamaño del Array: ${devices.length}")

    // modificación de elementos
    devices(1) = "Titanic"

    println(s"Id del Array ${System.identityHashCode(devices)}\n" +
            s"Contenido del Array: ${devices.mkString("Array(", ", ", ")")}\n" +
            s"Tamaño del Array: ${devices.length}")

    //  devices(1) = 256 // Type mismatch

  }

  def pruebasVector(): Unit = {

    //    Vector is immutable, modifications are not made in place

    var vec = Vector(1, 18, 6)

    println(s"Id del Vector ${System.identityHashCode(vec)}\n" +
            s"Contenido del Vector: ${vec.mkString("Vector(", ", ", ")")}\n" +
            s"Tamaño del Vector: ${vec.length}")

    vec = vec.updated(1, 30)

    println(s"Id del Vector ${System.identityHashCode(vec)}\n" +
            s"Contenido del Vector: ${vec.mkString("Vector(", ", ", ")")}\n" +
            s"Tamaño del Vector: ${vec.length}")

    //    Unlike Array, a Vector has flexible size

    vec = Vector(1, 6, 21)

    println(s"Id del Vector ${System.identityHashCode(vec)}\n" +
            s"Contenido del Vector: ${vec.mkString("Vector(", ", ", ")")}\n" +
            s"Tamaño del Vector: ${vec.length}")

    vec = vec :+ 5

    println(s"Id del Vector ${System.identityHashCode(vec)}\n" +
            s"Contenido del Vector: ${vec.mkString("Vector(", ", ", ")")}\n" +
            s"Tamaño del Vector: ${vec.length}")

    vec = 77 +: vec

    println(s"Id del Vector ${System.identityHashCode(vec)}\n" +
            s"Contenido del Vector: ${vec.mkString("Vector(", ", ", ")")}\n" +
            s"Tamaño del Vector: ${vec.length}")

  }

  def pruebasMap(): Unit = {

    val phoneStatus = Map(
      ("DTS", "2014-03-15:10:10:31"),
      ("Brand", "Titanic"),
      ("Model" -> "4000"),
      ("UID" -> "1882b564-c7e0-4315-aa24-228c0155ee1b"),
      ("DevTemp" -> 58),
      ("AmbTemp" -> 36),
      ("Battery" -> 39),
      ("Signal" -> 31),
      ("CPU" -> 15),
      ("Memory" -> 0),
      ("GPS" -> true),
      ("Bluetooth" -> "enabled"),
      ("WiFi" -> "enabled"),
      ("Latitude" -> 40.69206648),
      ("Longitude" -> -119.4216429))

    println(s"¿Contiene 'DTS'?: ${phoneStatus.contains("DTS")}")

    for (clave <- phoneStatus.keys) {
      print(s"Clave: ${clave} - ")
      println("Valor: " + phoneStatus(clave))
    }

    for (valor <- phoneStatus.values) {

      println(s"Valor: ${valor}")

    }

    for ((clave, valor) <- phoneStatus) {

      println(s"Clave: ${clave}, Valor: ${valor} ")

    }

    // NoSuchElementException
    //  println(s"Valor de la clave 'clave_que_no_existe' ${phoneStatus("clave_que_no_existe")}")

    // no genera excepciones
    println(s"Valor de la clave 'clave_que_no_existe': ${phoneStatus.get("clave_que_no_existe")}")

    println(s"Valor de la clave 'DTS': ${phoneStatus.get("DTS")}")

    println(s"Valor de la clave con getOrElse('clave_que_no_existe', 'No existe la clave'): " +
            s"${phoneStatus.getOrElse("clave_que_no_existe", "No existe la clave")}")

  }

  def alumnosYCalificaciones(): Unit = {

    val calificaciones = mutable.Map[String, List[Double]]()

    var seguir = true

    while (seguir) {
      val nombre = StdIn.readLine("Introduce el nombre del alumno (o 'fin' para terminar): ").trim

      if (nombre.toLowerCase == "fin") {

        seguir = false

      } else {

        val notaStr = StdIn.readLine(s"Introduce una calificación para $nombre " +
                                     s"(o vacío para pasar al siguiente alumno): ").trim

        if (notaStr.nonEmpty) {
          val nota = notaStr.toDouble

          val notasPrevias = calificaciones.getOrElse(nombre, Nil)
          // Añadiendo nueva calificación para una clave ya existente
          calificaciones(nombre) = notasPrevias :+ nota
        }
      }
    }

    var suma = 0.0

    // procesamiento tradicional
    //    for ((nombre, notas) <- calificaciones) {
    //
    //      println(s"Alumno: ${nombre}")
    //
    //      for (nota <- notas) {
    //
    //        println(s"\tNota:  ${nota}")
    //
    //        suma += nota
    //
    //      }
    //      println("----------------")
    //      println(f"\tMedia: ${suma / notas.length }%.2f" )
    //      println("----------------")
    //
    //      suma = 0
    //    }

    // procesamiento funcional

    calificaciones.foreach {
      // Procesamos tuplas de clave y valor
      case (nombre, notas) =>
        val media = notas.sum / notas.length
        val notasFormateadas = notas.map(n => f"$n%.2f").mkString(", ")
        println("---------------\n" +
          s"Nombre: ${nombre} \n" +
          s"Notas: ${notasFormateadas} \n" +
          f"Media: ${media}%.2f ")
    }
  }

  def sumarYContarNumeros(): Unit = {

    val entrada = StdIn.readLine("Introduce números separados por comas: ")

    val numeros = entrada.split(",").map(_.trim.toInt)

    val suma = numeros.sum
    val mayor = numeros.max

    println(s"Números introducidos: ${numeros.mkString("Array(", ", ", ")")}")
    println(s"Suma total: $suma")
    println(s"Mayor número: $mayor")

  }

  def contarOcurrenciasDePalabras(): Unit = {
    val frase = StdIn.readLine("Introduce una frase: ").toLowerCase

    val palabras = frase.split(" ").map(_.trim)

    val contador = scala.collection.mutable.Map[String, Int]()

    for (palabra <- palabras) {

      val actual = contador.getOrElse(palabra, 0)

      contador(palabra) = actual + 1
    }

    println("\nRecuento de palabras:")

    for ((palabra, cantidad) <- contador) {
      println(s"$palabra → $cantidad")
    }
  }

  def adivinarNumeroSecreto(): Unit = {

        print("¿Quieres jugar de 1 a ?: ")
        val limite = StdIn.readInt()

        // Generar el número secreto aleatorio entre 1 y n
        val numeroSecreto = Random.nextInt(limite) + 1

        var intentos = 0
        var adivinado = false

        println(s"\nHe pensado un número entre 1 y $limite. ¡Intenta adivinarlo!\n")

        while (!adivinado) {

          print("Intenta adivinar el número secreto: ")
          val intento = StdIn.readInt()
          intentos += 1

          if (intento < numeroSecreto) {

            println("Demasiado pequeño. Intenta con un número más grande.\n")

          } else if (intento > numeroSecreto) {
            println("Demasiado grande. Intenta con un número más pequeño.\n")

          } else {
            println(s"¡Correcto! El número secreto era $numeroSecreto.")
            println(s"¡Correcto! El número secreto era $numeroSecreto.")
            println(s"Lo has conseguido en $intentos intento(s).")
            adivinado = true
          }
        }
      }

  def aplicarDuracionAHorasMinutosSegundos(): Unit = {

    println("Introduce la hora inicial (0-23): ")
    var horas = StdIn.readInt()

    println("Introduce los minutos iniciales (0-59): ")
    val minutos = StdIn.readInt()

    println("Introduce los segundos iniciales (0-59): ")
    val segundos = StdIn.readInt()

    println("Introduce la duración en minutos: ")
    val duracionEnMinutos = StdIn.readInt()

    // Convertir todo a duracion en segundos a partir de la medianoche
    val duracionInicialEnSegundos = (horas * 3600) + (minutos * 60) + segundos

    // Calcular el total de segundos tras añadir la duración
    val duracionTotalFinalEnSegundos = duracionInicialEnSegundos + (duracionEnMinutos * 60)

    // Ajustar para que no supere las 24 horas (24 horas * 3600 = 86400 segundos)
    val segundosFinalesDelDia = duracionTotalFinalEnSegundos % 86400

    // Calcular la nueva hora, minutos y segundos
    val horaFinal = segundosFinalesDelDia / 3600
    val minutosFinales = (segundosFinalesDelDia % 3600) / 60
    val segundosFinales = segundosFinalesDelDia % 60

    // Mostrar el resultado
    println(f"Hora final: $horaFinal%02d:$minutosFinales%02d:$segundosFinales%02d")
  }

  def buclesScala(): Unit = {
    val sorrentoPhones = List("F00L", "F01L", "F10L", "F11L", "F20L", "F21L", "F22L", "F23L", "F24L")
    var indice = 0

    println("while (indice < sorrentoPhones.length)")
    while (indice < sorrentoPhones.length) {
      println("\t" + sorrentoPhones(indice))
      indice = indice + 1
    }

    // enumerator generators
    println("for (indice <- 0 to sorrentoPhones.length - 1)")
    for (i <- 0 to sorrentoPhones.length - 1) {
      println("\t" + sorrentoPhones(i))
    }

    println("for (indice <- 0 until sorrentoPhones.length)")
    for (i <- 0 until sorrentoPhones.length) {
      println("\t" + sorrentoPhones(i))
    }

    println("for (indice <- 0 until sorrentoPhones.length by 2")
    for (i <- 0 until sorrentoPhones.length by 2) {
      println("\t" + sorrentoPhones(i))
    }

    println("for (indice <- sorrentoPhones.indices by 2)")
    for (i <- sorrentoPhones.indices by 2) {
      println("\t" + sorrentoPhones(i))
    }
    //////////////////////////////////////////////////////////////////////////////////////////////
    // Iterando la colección
    println("for (model <- sorrentoPhones)")
    // No permite controlar el incremento del contador implícito!!!!!
    for (model <- sorrentoPhones) {
      println("\t" + model + " ")
    }

    // for con múltiples generadores

    val phonebrands = List("iFruit", "MeToo")
    val newmodels = List("Z1", "Z-Pro")
    println("for (brand <- phonebrands; model <- newmodels)")
    for (brand <- phonebrands; model <- newmodels) {
      println("\t" + brand + " " + model)
    }

    println("Procesamiento condicional tradicional")
    // procesa todos los elementos aunque imprima
    // sólo los que satisfacen el criterio
    for (model <- sorrentoPhones) {
      if (model.contains("2")) println("\t" + model + " ")
    }

    println("Procesamiento con filtro en for")
    // procesa sólo los elementos que satisfacen el criterio
    for (model <- sorrentoPhones; if (model.contains("2"))) {
      println("\t" + model + " ")
    }

    // yield devuelve una nueva colección en lugar de procesar cada elemento de uno en uno
    println("Creación de una nueva lista con yield")
    val newlist =
      for (brand <- phonebrands; model <- newmodels; if (model.contains("Pro")))
        yield brand + " " + model
    println("\t" + newlist)



  }

  def cartasBarajaEspanola(): Unit = {

    val palos = List("Oros", "Copas", "Espadas", "Bastos")
    val cartas = List("As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey")

    println("Cartas de la Baraja Española:")
    val baraja =
      for (carta <- cartas; palo <- palos)
        yield carta + " de " + palo
    // println("\t" + baraja)
    for (carta <- baraja) {
      println("\t" + carta)
    }

    // Baraja ordenada aleatoriamente
    println("Cartas de la baraja española ordenadas aleatoriamente (listas para repartir)")
    //  println(Random.shuffle(baraja))

    for (carta <- Random.shuffle(baraja)) {
      println("\t" + carta)
    }
  }

  def iteradoresScala(): Unit = {

    val phones = Array("iFruit", "MeToo")

    // Acceso al iterador
    val iterPhones = phones.iterator

    println("Método next")
    println("\tPrimer elemento:  " + iterPhones.next)
    println("\tSegundo elemento: " + iterPhones.next)

    // NoSuchElementException
    // println("\tTercer elemento:" + iterPhones.next)

    val titanicPhones = List("1000", "2000", "3000", "Bananas")
    var iterTitanic = titanicPhones.iterator

    println("Procesamiento de iterador con bucle while")
    while (iterTitanic.hasNext) {
      println("\t" + iterTitanic.next)
      // Acción destructiva!!!!!!!
      println("\t" + iterTitanic.contains("Bananas"))
    }

    // Accediendo de nuevo al iterador
    iterTitanic = titanicPhones.iterator
    println(s"size: ${iterTitanic.size}")

    // Accediendo de nuevo al iterador
    iterTitanic = titanicPhones.iterator
    println(s"isEmpty: ${iterTitanic.isEmpty}")

    // Accediendo de nuevo al iterador
    iterTitanic = titanicPhones.iterator
    println(s"exists(_ == \"1000\"): ${iterTitanic.exists(_ == "1000")}")

    // más cómodo
    // Accediendo de nuevo al iterador
    iterTitanic = titanicPhones.iterator
    println(s"contains(\"1000\"): ${iterTitanic.contains("1000")}")

    // Accediendo de nuevo al iterador
    iterTitanic = titanicPhones.iterator
    println(s"take(2): ${iterTitanic.take(2)}")

    // Accediendo de nuevo al iterador
    iterTitanic = titanicPhones.iterator
    println(s"filter(_.contains(\"1\")): ${iterTitanic.filter(_.contains("1"))}")

    // Accediendo de nuevo al iterador
    iterTitanic = titanicPhones.iterator
    println(s"foreach: ")
    iterTitanic.foreach(e => println("\t" + e))

  }

  def creacionDeFunciones(): Unit = {

    val myConstant = 10
    var myVariable = 24

    def myFunction = myConstant + myVariable

    println(s"myVariable = 24 - Resultado devuelto por myFunction: $myFunction")

    myVariable = 9
    println(s"myVariable = 9  - Resultado devuelto por myFunction: $myFunction")

    myVariable = 20
    println(s"myVariable = 20 - Resultado devuelto por myFunction: $myFunction")


    def listPhones(): Unit = {
      println("MeToo")
      println("Titanic")
      println("iFruit")
    }

    println(s"Resultado devuelto por listPhones: $myFunction")

  }

  def pasoDeFuncionesComoArgumentos(): Unit = {
//    ////////////////////////////////////////////////////////////////////
//    def CtoF1(celsius: Double) = {
//      (celsius * 9 / 5) + 32
//    }
//    ////////////////////////////////////////////////////////////////////
//    println(s"Resultado de CtoF1(34.0): ${CtoF1(34.0)}")
//    ////////////////////////////////////////////////////////////////////
//    // para expresiones simples podemos omitir las llaves
//    def CtoF2(celsius: Double) =
//      (celsius * 9 / 5) + 32
//    ////////////////////////////////////////////////////////////////////
//    println(s"Resultado de CtoF2(34.0): ${CtoF2(34.0)}")
//    ////////////////////////////////////////////////////////////////////
//    // para expresiones simples podemos omitir las llaves
//    def CtoF3(celsius: Double) =
//      (celsius * 9 / 5) + 32: Double  // Tipo de retorno explícito
//    ////////////////////////////////////////////////////////////////////
//    println(s"Resultado de CtoF3(34.0): ${CtoF3(34.0)}")
//    ////////////////////////////////////////////////////////////////////////////

    def CtoF4(celsius: Double) = (celsius * 9 / 5) + 32
    def duplicar(numero: Double) = (numero * 2)
    // higher order function
    def convertirLista(lista: List[Double],
                       funcionConvertir: Double => Double): Unit = {
      for (elemento <- lista)
        println(s"Ejecutando la función para ${elemento} - resultado: ${funcionConvertir(elemento)}")
    }
    //////////////////////////////////////////////////////////////////////////
    val phoneCelsius = List(34.0, 23.5, 12.2)
    convertirLista(phoneCelsius, CtoF4)
    convertirLista(phoneCelsius, duplicar)
    // función anónima
    convertirLista(phoneCelsius, temp => (temp * 9 / 5) + 32)
  }

  def metodosIteracionColecciones(): Unit = {

    val phones = List("MeToo", "Titanic", "Ronin")
    println("---------------------------------------------------------------")
    phones.foreach(println(_))
    // Equivalente
    println("---------------------------------------------------------------")
    phones.foreach(println)
    println("---------------------------------------------------------------")
    // Equivalente (y permite controlar el formato dentro de println)
    phones.foreach(elemento => println("Mensaje personalizado: " + elemento))

    // scala no puede inferir el tipo con _
    //  phones.foreach(println(_.toUpperCase))

    phones.foreach(valor => println(valor.toUpperCase))

    // Definición de función con nombre
    val CtoF: (Double) => Double = (cc => (cc * 9 / 5) + 32)

    val phoneCelsius = List(34.0, 23.5, 12.2)

    // Invocando a la función definida previamente
    // con sintáxis de funciones lamda
    phoneCelsius.map(elem => CtoF(elem))  // Transformación
                .foreach(println)

    // Invocando a la función definida previamente
    // usando el placeholder
    phoneCelsius.map(CtoF(_)) // forma corta
                .foreach(println)

    // Invocando mediante función anónima
    // con sintáxis de funciones lamda
    phoneCelsius.map(c => c * 9 / 5 + 32)
                .foreach(println)

    // Invocando mediante función anónima
    // mediante el placeholder
    phoneCelsius.map(_ * 9 / 5 + 32)
                .foreach(println)
    // La lisa original permanece sin cambios!!
    println(phoneCelsius)

    phoneCelsius.filter(val1 => val1 < 23)  // función anónima o lambda
                .foreach(e => println("Filter1: " + e))

    phoneCelsius.filter(_ < 23)             // función anónima con placeholder _
                .foreach(e => println("Filter2: " + e))

    phones.filter(_.startsWith("M"))        // función anónima con placeholder _
          .foreach(e => println("Filter3: " + e))

    phones.filter(_.length > 4)             // función anónima con placeholder _
          .foreach(e => println("Filter4: " + e))

    phoneCelsius.sortWith((val1, val2) => val1 < val2)
                .foreach(e => println("SortWith1: " + e))

    phoneCelsius.sortWith(_ < _)
                .foreach(e => println("SortWith2: " + e))

    phoneCelsius.sortWith(_ > _)
                .foreach(e => println("SortWith3: " + e))

    var myList: List[Int] = List(1, 5, 7, 3, 2, 1)
//    // paso a paso
//    myList.map(_ + 10)
//    myList.filter(_ > 4)

    myList.map(_ + 10)
          .filter(_ > 4)
          .foreach(println)
  }

  def patternMatching(): Unit = {

    var phoneWireless = "encendida"
    var msg = "Estado desconocido"

    phoneWireless match {
      case "encendida"  => msg = "Radio encendida"
      case "apagada"    => msg = "Radio apagada"
      case "conectada"  => msg = "Radio encendida, protocolo activado"
    }

    println(msg)

    phoneWireless = "happy"
    msg = "unknown"
    // el siguiente ejemplo necesita cubrir tdos los posibles casos
    msg = phoneWireless match {
      case "enabled" => "Radio is on";
      case "disabled" => "Radio is off";
      case "connected" => "Radio on, protocol up";
      case default => "Radio state unknown"
    }
    println(msg)

    val mixedArr = Array("11", 12, "thirteen", 14.0, 'F', null)

    for (elem <- mixedArr) {
      elem match {
        case elem: String => println("String: " + elem)
        case elem: Int    => println("Integer: " + elem)
        case elem: Double => println("Float: " + elem)
        case elem: Char   => println("Char: " + elem)
        case elem: AnyRef => println("Unknown: " + elem)
        case null         => println("Found null")
      }
    }

    var superPhone: Option[Int] = Some(12)

    println(superPhone.getOrElse("Not found"))

    superPhone = None
    println(superPhone.getOrElse("Not found"))


    def funcionOption(number: Int): Option[Int] = {
      if (number % 2 == 0) {
        // Si el número es par, lo envolvemos en Some
        Some(number)
      } else {
        // Si el número es impar, devolvemos None
        None
      }
    }

    var resultado = funcionOption(4) // Devuelve Some(4)
    println(s"Resultado para 4: ${resultado.getOrElse("No encontrado")}")

    resultado = funcionOption(5) // Devuelve None
    println(s"Resultado para 5: ${resultado.getOrElse("No encontrado")}")

    def convert2Float(x: Option[Any]) = x match {
      case Some(d: Double) => println("Double: " + d.toFloat)
      case Some(i: Int) => println("Int: " + i.toFloat)
      case Some(f: Float) => println("Float: " + f)
      case Some(_: Any) => println("Invalid data provided.")
      case None => println("No data provided.")
    }

    convert2Float(Some(25.0))
    convert2Float(Some(25F))
    convert2Float(Some(25))
    convert2Float(Some("twenty-five"))
    convert2Float(None)

  }

  def funcionesParciales(): Unit = {

    val div = new PartialFunction[Int, Int] {
      def apply(x: Int): Int = 24 / x
      // validación de los datos de entrada
      def isDefinedAt(x: Int): Boolean = {
        println(if (x != 0) "La función se puede invocar con seguridad"
                else "Mejor no invoques a la función")
        x != 0
      }
    }

    div.isDefinedAt(0)
    div.isDefinedAt(2)

    if (div.isDefinedAt(2)) // si devuelve true podemos invocar a la función con seguridad
      println(div(2))

    // se generan automáticamente los métodos apply y isDefinedAt
    val getThirdItem: PartialFunction[List[Int], Int] = {
      case x :: y :: z :: _ => z // mínimo 3 elementos
    }
    println(getThirdItem.isDefinedAt(List(25)))             // false
    println(getThirdItem.isDefinedAt(List(25, 35, 45, 85))) // true

    println(getThirdItem(List(25, 35, 45, 85)))             // 45

    val defaultValue: (List[Int]) => Int = (_ => -1)  // resultado alternativo
    println(getThirdItem.applyOrElse(List(25), defaultValue))

  }

  def libreriasScala(): Unit = {
//    ///////////////////////////////////////////////////
//    class Device(var phoneName: String) {
//      // Método display
//      def display = s"Phone is $phoneName"
//      override def toString = s"Valor devuelto por toString:  $phoneName"
//    }
//    ///////////////////////////////////////////////////
//    val objeto1 = new Device("Sorrento")
//
//    println("Valor devuelto por el método display: " + objeto1.display)
//    println(objeto1) // llamada implícita a toString
    
    val producto1 = Producto()
    println(producto1)
  }
}

