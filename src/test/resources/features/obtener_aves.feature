# language: es
# Autor: iop

Característica: Extraer información de hotspots de ebird

  @BasicEbirdHotspotByURL
  Esquema del escenario: Extraer aves y sus números de un hotspot en ebird
    Dado que quiero obtener la abundancia de las aves
    Cuando ingreso con usuario y contraseña al hotspot con url <hotspotUrl>
    Entonces extraigo la información de las aves

    Ejemplos:

      | hotspotUrl                                       |
      #| https://ebird.org/hotspot/L2078942               |
      | https://ebird.org/hotspot/L20704259              |


  @BasicEbirdHotspotByName
  Esquema del escenario: Extraer aves y sus números de un hotspot en ebird
    Dado que quiero obtener la abundancia de las aves
    Cuando ingreso con usuario y contraseña al hotspot <hotspot> cercano a <lugar>
    Entonces extraigo la información de las aves

    Ejemplos:

      | hotspot                                        | lugar                                          |
      #| Las Tangaras ProAves Reserve                   | Reserva ProAves Las Tangaras                   |
      #| RNA Proaves Las Tangaras--Lodge                | Reserva ProAves Las Tangaras                   |
      #| RNA Proaves Las Tangaras--Bebederos/Feeders    | Reserva ProAves Las Tangaras                   |
      #| RNA Las Tangaras--Sendas                       | Reserva ProAves Las Tangaras                   |
      #| Joaquín Antonio Uribe                          | Joaquin Antonio Uribe                          |
      #| Jardín Botánico Medellín - Lago                | Joaquin Antonio Uribe                          |
      #| Girardota--Vereda Portachuelos                 | Comfama Girardota                              |
      #| Humedal Amalita                                | Humedal Amalita                                |
      #| Cerro La Asomadera                             | Cerro La Asomadera                             |
      #| Refugio de las aves - La Piñuela               | Finca El Refugio de las Aves                   |
      #| Quebrada El Viao                               | Restaurante y mirador cocorna                  |
      #| Los Monos                                      | Reserva agroecológica los monos                |
      #| RN La Romera                                   | Parque Ecologico La Romera                     |
      #| RNA Loro Orejiamarillo (Yellow-eared Parrot Reserve) | Reserva Loro Orejiamarillo               |
      #| Reserva Alto de Ventanas                       | Reserva Loro Orejiamarillo                     |
      #| Cumbre Ventanas                                | Reserva Loro Orejiamarillo                     |
      #| Finca El Reposo                                | Yarumal, Antioquia, Colombia                   |
      #| Finca La Florida                               | Yarumal, Antioquia, Colombia                   |
      #| RNA Proaves Arrierito Antioqueño--Casa         | Reserva arrierito antioqueño                   |
      #| Arrierito Antioqueño ProAves Reserve           | Reserva arrierito antioqueño                   |
      #| Balcón de los Colibríes, Yarumal               | Yarumal, Antioquia, Colombia                   |
      #| Lago de Instituto Colombiano Agropecuario      | Autódromo Central Park                         |
      | El Porvenir                                    | El porvenir Rionegro                           |
