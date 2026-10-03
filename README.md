## Editor de texto con implementacion de memento
---
## nombre:Eddie Santiago Rondon Capera
## codigo:20251020108
---
## Descripcion

en este ejercicio se implementa el patron de diseño memento mediante un editor de texto.

el funcionamiento es similar al de un editor como word, ya que el usuario puede escribir y modificar el contenido. la diferencia es que en este ejercicio se implementa un historial que permite guardar diferentes estados del texto y posteriormente restaurar uno de esos estados.

el patron memento permite que el editor guarde una copia de su estado actual sin que el historial tenga que modificar directamente el contenido del editor.

## funcionamiento del ejercicio

para realizar la prueba se siguen los siguientes pasos:

```text
1. crear editor
2. escribir "hola"
3. guardar
4. cambiar a "hola veci"
5. guardar
6. cambiar a "hola veci, vuelvo"
7. restaurar
8. mostrar el contenido
```

la ejecucion en consola se puede observar de la siguiente manera:

```text
editor de texto con patron memento

contenido actual:

1. escribir o modificar contenido
2. guardar estado
3. restaurar ultimo estado
4. mostrar contenido
5. mostrar cantidad de estados guardados
0. salir
seleccione una opcion: 1
escriba el nuevo contenido: hola
contenido modificado correctamente.

contenido actual:
hola

1. escribir o modificar contenido
2. guardar estado
3. restaurar ultimo estado
4. mostrar contenido
5. mostrar cantidad de estados guardados
0. salir
seleccione una opcion: 2
estado guardado correctamente.
estados en historial: 1

contenido actual:
hola

1. escribir o modificar contenido
2. guardar estado
3. restaurar ultimo estado
4. mostrar contenido
5. mostrar cantidad de estados guardados
0. salir
seleccione una opcion: 1
escriba el nuevo contenido: hola veci
contenido modificado correctamente.

contenido actual:
hola veci

1. escribir o modificar contenido
2. guardar estado
3. restaurar ultimo estado
4. mostrar contenido
5. mostrar cantidad de estados guardados
0. salir
seleccione una opcion: 2
estado guardado correctamente.
estados en historial: 2

contenido actual:
hola veci

1. escribir o modificar contenido
2. guardar estado
3. restaurar ultimo estado
4. mostrar contenido
5. mostrar cantidad de estados guardados
0. salir
seleccione una opcion: 1
escriba el nuevo contenido: hola veci, vuelvo
contenido modificado correctamente.

contenido actual:
hola veci, vuelvo

1. escribir o modificar contenido
2. guardar estado
3. restaurar ultimo estado
4. mostrar contenido
5. mostrar cantidad de estados guardados
0. salir
seleccione una opcion: 3
estado restaurado correctamente.
estados restantes: 1

contenido actual:
hola veci

1. escribir o modificar contenido
2. guardar estado
3. restaurar ultimo estado
4. mostrar contenido
5. mostrar cantidad de estados guardados
0. salir
seleccione una opcion: 4
contenido actual:
hola veci
```

## resultado

despues de realizar la restauracion, el contenido vuelve al ultimo estado que habia sido guardado:

```text
hola veci
```

esto demuestra el funcionamiento del patron memento, ya que el estado `"hola veci"` fue guardado antes de realizar la ultima modificacion.

## patron memento

en la implementacion se utilizan las siguientes clases:

```text
editor
originator

memento
memento

historial
caretaker
```

el `editor` es el objeto que contiene el texto actual. cuando se utiliza la opcion de guardar, el editor crea un memento con el estado actual y el historial se encarga de almacenarlo.

cuando se utiliza la opcion de restaurar, el historial entrega el ultimo estado guardado y el editor recupera ese contenido.

por esta razon, el historial funciona como un punto de restauracion, similar a volver a un estado anterior de un documento.

## flujo de estados

```text
hola
  |
  | guardar
  v
hola
  |
  | modificar
  v
hola veci
  |
  | guardar
  v
hola veci
  |
  | modificar
  v
hola veci, vuelvo
  |
  | restaurar
  v
hola veci
```

de esta manera se puede observar que el ultimo cambio no guardado desaparece al restaurar y el editor vuelve al ultimo estado almacenado.
