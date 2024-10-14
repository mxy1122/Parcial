# Parcial

# MutantM

MutantM es una API que permite verificar si una secuencia de ADN pertenece a un mutante o a un humano. Además, la aplicación provee estadísticas sobre la proporción de mutantes y humanos almacenados en el sistema.

## Características

- Verificación de secuencias de ADN para identificar mutantes.
- Almacenamiento de individuos y sus secuencias de ADN.
- Cálculo de estadísticas sobre la proporción de mutantes vs humanos.
- Base de datos en memoria H2 para pruebas rápidas.
- Desplegable en un contenedor Docker.

## Endpoints

### Verificar si es mutante

- **URL**: `/mutant/agregar`
- **Método**: `POST`
- **Descripción**: Verifica si la secuencia de ADN proporcionada pertenece a un mutante.
- **Cuerpo de la solicitud (JSON)**:

- ### Filas:
  ```json
  {
    "dna": ["ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGG",
            "CCCCTA",
             "TCACTG"]

  
  }

- ### Columnas:
  ```
  {
    "dna": ["CTGCTA",
            "TGGAGT",
            "GCTTCC",
            "CACCTG",
            "CTAGTC",
            "AGTCAC"
  ]
}

- ### Diagonales:
    ```
  {
    "dna": ["ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGG",
            "CCCCTA",
            "TCACTG"
  ]
}
- ### No mutantes:
    ```
    {
      "dna": ["ATGCGA",
              "CAGTGC",
              "TTATTT",
              "AGACGG",
              "GCGTCA",
              "TCACTG"
  ]
}


  
  
