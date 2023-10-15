# language: es
# Autor: Yop

Característica: Extraer informacion de hotspots de ebird

  Esquema del escenario: Extraer aves y sus numeros en hotspot 1
    Dado que quiero obtener la abundancia de las aves
    Cuando ingreso con el usuario esteban12 y la contrasena 167248359esteban al hotspot <hotspot> de la ciudad <lugar>
    Entonces extraigo la informacion de las aves

  Ejemplos:
  | hotspot                                        | lugar                                          |
  #| Las Tangaras ProAves Reserve                   | Reserva ProAves Las Tangaras                   |
  #| RNA Proaves Las Tangaras--Lodge                | Reserva ProAves Las Tangaras                   |
  #| Joaquín Antonio Uribe                          | Joaquin Antonio Uribe                          |
  #| Jardín Botánico Medellín - Lago                | Joaquin Antonio Uribe                          |
  #| Girardota--Vereda Portachuelos                 | Comfama Girardota                              |
  #| Humedal Amalita                                | Humedal Amalita                                |
  | Cerro La Asomadera                             | Cerro La Asomadera                             |


#  Escenario: Extraer aves y sus numeros en hotspot 1
 #   Dado que quiero obtener la abundancia de las aves
  #  Cuando ingreso con el usuario esteban12 y la contrasena 167248359esteban al hotspot RNA Proaves Las Tangaras--Lodge de la ciudad Reserva ProAves Las Tangaras
   # Entonces extraigo la informacion de las aves

 ### Escenario: Extraer aves y sus numeros en hotspot 2
 #   Dado que quiero obtener la abundancia de las aves
  #  Cuando ingreso con el usuario esteban12 y la contrasena 167248359esteban al hotspot Joaquín Antonio Uribe de la ciudad Joaquin Antonio Uribe
  #  Entonces extraigo la informacion de las aves
#


