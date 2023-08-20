# language: es
# Autor: Yop

Característica: Extraer información de hotspots de ebird

  Escenario: Extraer aves y sus números en hotspot
    Dado que quiero obtener la abundancia de las aves
    Cuando ingreso al hotspot
    | strUsername | strPassword      |
    | esteban12   | 167248359esteban |
    Entonces extraigo la información de las aves




