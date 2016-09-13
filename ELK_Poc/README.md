Ejemplo de logado con logback y ELK
===================================

#### Prerrequisitos
- Tener arrancado el stack ELK
- Tener arrancado un Redis

#### Introducción
ELK
- **E**lasticsearch: Se comporta como una base de datos donde logstash irá introduciendo los datos
- **L**ogstash: Se encarga de hacer la recogida de datos y enviarlo a elasticsearch, se base en el siguiente flujo: input --> filter --> output
- **K**ibana: Se encarga de la visualización de los datos existentes en elasticsearch

El ejemplo loga de tres formas distintas:

1. Logstash recoge la información para procesarla de un fichero de logs(manual)
2. Logback tiene un appender que envía los logs a logstash(según se va logando van llegando los logs a logstash)
3. Logback tiene un appender que envía los logs a logtash(según se va logando van llegando los logs a logstash)


Se arranca logstash de la siguiente forma: logstash -f logstash.conf. Donde logstash es el fichero donde se incluyen los filtros que forman el flujo input --> filter --> output. En el ejempo en la carpeta logstash_conf estarán los ficheros de configuración usados.

El ejemplo se compone de dos proyectos:

1. logs_ELK: Tiene un @Controller que loga logs de logback en los appender definidos en el fichero logback.xml
2. logs_generator: Apoyandose en un plugin Maven "Benerator" genera unos datos de "clientes" y los envía a Redis, tras esto ya entra en juego el stack ELK. Para hacer funcionar este ejemplo bastaría con hacer la siguiente ejecución Maven: clean install benerator:generate