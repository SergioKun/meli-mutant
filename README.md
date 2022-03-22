# Tecnologías
Para la api se utilizó lenguaje java con el framework Spring y base de datos MySql

# Instrucciones 

Servicio de validación de mutantes /mutant/ (POST)

Body
~~~
{
  "dns":["CTTTTA","CCTTTA","TTCCGT","AGACGG","TCCCTA","TCATTG"]
}
~~~

Response
~~~
{
    "aditionalMenssage": "",
    "mutant": true
}
~~~
Servicio de estadísticas /Stat/ (GET)

Response
~~~
{
    "countMutant": 2,
    "countHuman": 2,
    "ratio": 0.5
}
~~~


### Validaciones

Petición sin data

Body
~~~
{
  "dns":[]
}
~~~
Response
~~~
{
    "aditionalMenssage": "Invalid array, check the length of the elements",
    "mutant": false
}
~~~

Petición con longitud incorrecta en los elementos del array

Body
~~~
{
  "dns":["CATTTA","CCT","TTCCGT","AGACGG","TCCCTA","TCATTG"]
}
~~~
Response
~~~
{
    "aditionalMenssage": "Invalid array, check the length of the elements",
    "mutant": false
}
~~~

Letras permitidas en los elementos del array

Body
~~~
{
  "dns":["CATTZZ","CCTTTA","TTCCGT","AGACGG","TCCCTA","TCATTG"]
}
~~~
Response
~~~
{
    "aditionalMenssage": "The allowed letters are: A,T,C,G",
    "mutant": false
}
~~~
