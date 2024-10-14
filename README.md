# Parcial

# MutantM

MutantM es una API que permite verificar si una secuencia de ADN pertenece a un mutante o a un humano. Además, la aplicación provee estadísticas sobre la proporción de mutantes y humanos almacenados en el sistema.

## Características

- Verificación de secuencias de ADN para identificar mutantes.
- Almacenamiento de individuos y sus secuencias de ADN.
- Cálculo de estadísticas sobre la proporción de mutantes vs humanos.
- Base de datos en memoria H2 para pruebas rápidas.
- Desplegable en un contenedor Docker.

## Instalacion

---
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/usuario/proyecto-x.git
---

## Endpoints

-Los endopoints se pueden probar desde Postman y Render

### **Postman**

Desde Postman, se pueden probar los endpoints "/mutant" y "/stats".

* `"Endpoint "/stats"`

Metodo GET : http://localhost:8080/mutant/stats

* `" Endpoint"/mutant"`

Metodo POST : http://localhost:8080/mutant/agregar

### **Render**

Para probar los endpoints en render hay que hacer los cambios de


Metodo GET : https://parcial-wct7.onrender.com/mutant/stats


Metodo POST : https://parcial-wct7.onrender.com/mutant/agregar


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
            "AGTCAC"`]
  }

- ### Diagonales:
    ```
  {
    "dna": ["ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGG",
            "CCCCTA",
            "TCACTG"]
  }
  
- ### No mutantes:
    ```
    {
      "dna": ["ATGCGA",
              "CAGTGC",
              "TTATTT",
              "AGACGG",
              "GCGTCA",
              "TCACTG"]
    }

# Pruebas Unitarias

Se incluyen casos de pruebas contemplando como siendo Mutante como Humano y Guardar una cadena de ADN


