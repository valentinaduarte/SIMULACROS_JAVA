PASO A PASO SPRING BOOT PROYECTO CON SPRING BOOT

# Pasos Para Realizar un proyecto Completo en SpringBoot

## * SpringBoot con las 5 dependencias
* ![Dependencias base api Rest](https://github.com/Camilocastellanos1002/Simulacros-Riwi/assets/69378105/22b06758-dab7-4187-9c40-1d25241fbaa6)
## * Agregar dependencias de swagger
	<!-- https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui -->
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.5.0</version>
		</dependency>

## * Agregar dependencias de notificacion por correo

	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-mail</artifactId>
	</dependency>

## * Generar Arquitectura hexagonal para el encarpetado
## * ![Arquitectura hexagonal](https://github.com/Camilocastellanos1002/Simulacros-Riwi/assets/69378105/3ac65bdb-46ce-42b2-8109-36ee68db36ca)

## * Flujo basico de una API Rest
* ![Modelo de flujo Spring Boot Api Rest](https://github.com/Camilocastellanos1002/Simulacros-Riwi/assets/69378105/ded5aad1-3fc1-4126-86f9-d2ec252fd21b)

## * Flujo Completo para una API
![Flujo paso a paso](https://github.com/Camilocastellanos1002/Simulacros-Riwi/assets/69378105/e781169d-ead1-45b4-8204-c5d5c505c9e3)

# A continuacion realizamos el paso a paso

## * 1. Descripcion del proyecto

![image](https://github.com/Camilocastellanos1002/Simulacros-Riwi/assets/69378105/d8d80a4d-7be8-4b80-a2d8-5fbe6e18328b)

### 1.1 conexion de la base de datos
#Configuraciones de la base de datos
	
	spring.datasource.url=jdbc:mysql://localhost:3306/bd_01_spring
	spring.datasource.username=root
	spring.datasource.password=
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
	
	#Configuraciones de JPA
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.show-sql=true
	
	#Dialecto
	spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

### 1.2 conexion de los path

	#Configuración PathVariable
	server.servlet.context-path=/api/v1

## 2. Crear entidades
![image](https://github.com/Camilocastellanos1002/Simulacros-Riwi/assets/69378105/12585623-9497-4002-9783-648feaf47736)

### 2.1 crear entidades de forma manual
### 2.2 crear relacion entre entidades

## 3. Creacion de dto

![image](https://github.com/Camilocastellanos1002/Simulacros-Riwi/assets/69378105/7c8f033a-96fe-4f7c-997e-495ca49db6e1)

### 3.1 se crean los request con los atributos nesesarios (formulario ), se deben especificar los requisitos de cada atributo

### 3.2 se crean los response, con los mismos atributos de cada entidad

### 3.3 crear los basic response, para no generar bucles

### 3.4 crear los response de las relaciones entre entidades





1. Inicializador de proyecto y se agregan dependencias básicas.

2. Conexión con base de datos, primero se tiene que activar MySQL en XAMPP, luego se crea la base de datos en la conexión local.

Nota: Recordar cambiar el nombre de la base de datos por la que se creó localmente.

3. Inyección de dependencias externas en el archivo “pom.xml”.

· Swagger

· Mail

4. Creación carpeteada en arquitectura hexagonal.

5. Creación de entidades con sus respectivas relaciones, las entidades tienen las siguientes anotaciones:

“@Entity(name = “Aquí va el nombre que tendrá en la DB”)”

“@Data”

“@Builder”

“@AllArgsConstructor”

“@NoArgsConstructor”

· Nota 1: Tener en cuenta que en esto también se crean los “Enums” y solo se pone anotaciones a las variables de tipo creación de base de datos, las otras anotaciones de validación se ponen en los DTOS.

· Nota 2: Los datos de tipo “Date” en la DB se ponen como “LocalDate” y se importa de “import java.time.LocalDate”.

· Nota 3: Los datos de tipo “Decimal” en la DB se ponen como “Double”.

· Nota 4: Recordar revisar todas las relaciones, insertarlas correctamente y validar que si estén bien ingresados los id de las otras tablas.

· Nota 5: En la entidad usuario en el “mappedBy” hay que recordar que se tiene que poner como aparezca la variable en el otro lado de la relación.

· Nota 6: Las relaciones “@OneToMany” siempre van acompañadas de “@ToString.Exclude” y “@EqualsAndHashCode.Exclude”, en cambio las “@ManyToOne” tienen siempre “@JoinColumn”.

· Nota 7: Existe un caso especial en la entidad “Submission” en el atributo “content”, a este se le agrega la etiqueta “@Lob” para permitirle una extensión más grande de texto que un string, este caso aplica para los atributos definidos en el modelo de entidad relación como “text”. Esto aplica para todos los atributos de las entidades que son de tipo “text”, también se puede poner “@Column(columnDefinition = "TEXT")”

6. Crear los DTO de request y de response, los DTO tienen las siguientes anotaciones:

“@Data”

“@Builder”

“@AllArgsConstructor”

“@NoArgsConstructor”

· Nota 1: En los request se ponen todas las validaciones que debe tener cada entidad.

· Nota 2: Los datos de tipo “String” que no pueden ser nulos se les inserta la anotación “NotBlank”, además el tamaño de estos se hace mediante la anotación “Size” configurando el “max” y el “min”.

· Nota 3: Los datos de tipo numérico o “Enum” que no pueden ser nulos se les inserta la anotación “@NotNull”, además el tamaño de estos se especifica mediante la anotación “@Max” y “@Min”

· Nota 4: Los datos de tipo “Email” se les agrega la anotación “@Email” y su tamaño se especifica con la anotación “@Size” de la misma forma que con un atributo de tipo “String”.

· Nota 5: Los datos de tipo “LocalDate” si se requiere que no sean nulas, se le agrega la anotación “@NotBlank”.

7. Creación de repositorios, se agrega la anotación “@Respository” es de tipo interface y extiendo de “JpaRepository<Entidad, Tipo de la PK>”.

8. Se crea el “CrudService” de base, este es una interface que recibe un RQ, RS e ID, está ubicado en la carpeta “abstract_services”.

9. En las interfaces de servicio son de tipo interface y están ubicadas la carpeta “abstract_services”.

· Nota 1: Hay que recordar que tengo que enviarle los DTO completos y el tipo de la PK, en este caso los DTO están en términos de REQUEST “#nombreEntidadReq.java”, RESPONSE “#nombreEntidadResp.java”.

· Nota 2: Aquí se ingresa también la variable estática “FIELD_BY_SORT” para organizar por un atributo especifico cuando se invoque la función “getAll()”.

--------------CONFIGURACIÓN DE ERRORES--------------

10. Se crea la carpeta “errors” dentro de la carpeta “dto”, se crea una clase con nombre “BaseErrorResp”, esta implementa de “Serializable” que es una clase especial para responder por http, además esta clase tiene las siguientes anotaciones:

“@Data”

“@SuperBuilder”

“@AllArgsConstructor”

“@NoArgsConstructor”

Además, se le tiene que definir las dos variables de respuesta que son el “status” y el código del status “code”.

11. Dentro de la misma carpeta se crea otra clase de nombre “ErrorResp” que extiende de la clase anterior “BaseErrorResp”, tiene las mismas anotaciones de la anterior agregando “@EqualsAndHashCode(callSuper = true)” la cual me indica que este hijo me ocupe el mismo espacio que el papá, y dentro de la clase se tendrá una lista de strings que especifican los errores generados.

12. Creo el advice controller, es un observador que revisa toda la aplicación que dependiendo del tipo de error el ejecuta algún método, esto es una clase y se ubica en la carpeta “error_handler” este tiene las siguientes anotaciones:

“@RestControllerAdvice”,

“@ResponseStatus(code = HttpStatus.BAD_REQUEST)”

· Nota 1: Le ponemos un status por defecto, este status es el 400 y surge cuando no se le envían los parámetros como el los pide

Se crea un método dentro que tiene la anotación “@ExceptionHandler (MethodArgumentNotValidException.class)” que le indica cuando es que se tiene que activar, por dentro tiene una excepción que activa la librería de validación, esta excepción se tiene que pasar también como parámetro del método, además este método da una respuesta de tipo “BaseErrorResp”. Luego dentro el método se crea una “lista” de map para almacenar los errores, se obtiene de la excepción los resultados con el field y el error mediante el método “.getBindingResult()” y se obtiene la lista de los nombres del campo del error (donde ocurrieron) con el método “.getFieldErrors()”, le creo un iterador “.forEach()” en el cuál crearé un “HashMap<>()” (estructura de tipo llave-valor), donde agregaré el error y donde ocurrió el error, además luego de eso agrego el “HashMap” creado a la lista de errores creada inicialmente.

13. Se crea un archivo con nombre “BadRequestException” de tipo “class” en la carpeta “exceptions”, y extiende de “RunTimeException”.

14. Se crea carpeta con nombre “messages” dentro de la carpeta “utils” y dentro se crea una clase de nombre “ErrorMessages” que se encarga de enviar un mensaje de error personalizado cuando no se encuentra un id en alguna entidad. Esta clase tiene las siguientes anotaciones:

“@Data”

“@SuperBuilder”

“@NoArgsConstructor”

--------------FIN CONFIGURACIÓN DE ERRORES--------------

15. Se crean los servicios, estos tienen la anotación “@Service” y “@AllArgsConstructor”, implementa los métodos de las interfaces de servicio anteriormente creadas, se tienen que inyectar los repositorios que serán utilizados en cada uno de los registros.
