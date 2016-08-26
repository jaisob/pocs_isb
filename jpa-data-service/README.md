Ejemplo con Spring Data y PostgreSQL
===

#### Prerrequisitos
- Tener instalado una PostgreSQL
- Crear una BBDD, en el application.yml se está usando jdbc:postgresql://localhost:5432/**BED_CTBP**, se puede cambiar por la que queramos

#### Introducción
Al arrancar la aplicación se creará el esquema en bbdd y se populará con datos de ejemplo. Se realizará una consulta simple a bbdd y varias algo más complejas sobre una relación many-to-many ya que son las más habituales en el modelo de la base de datos de TEPA.