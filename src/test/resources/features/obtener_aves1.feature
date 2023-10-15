# language: es
# Autor: Yop

Característica: Extraer informacion de hotspots de ebird

  Esquema del escenario: Extraer aves y sus numeros en hotspot 1
    Dado que quiero obtener la abundancia de las aves
    Cuando ingreso con el usuario esteban12 y la contrasena 167248359esteban al hotspot <hotspot> de la ciudad <lugar>
    Entonces extraigo la informacion de las aves

  Ejemplos:
  | hotspot                                        | lugar                                          |
  | Parque de Los Pies Descalzos                   | Parque de Los Pies Descalzos                   |


