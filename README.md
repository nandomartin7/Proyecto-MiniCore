# Sistema de Gestión de Gastos

## Descripción
Este proyecto es una aplicación web diseñada para gestionar y analizar los gastos registrados en una base de datos. La aplicación permite a los usuarios realizar las siguientes acciones principales:

- Registrar empleados, departamentos y gastos.
- Filtrar y calcular los gastos en un rango de fechas especificado.
- Visualizar los gastos agrupados por departamento y obtener un resumen general de los montos.

La aplicación está implementada con un backend desarrollado en **Java con Spring Boot** y un frontend construido con **Vue.js**. El proyecto está desplegado en **Vercel** para facilitar su acceso.

---

## Características Principales

### Backend

El backend maneja tres entidades principales:
- **Empleado:** Representa a los empleados que registran gastos.
- **Departamento:** Define las áreas organizativas a las que pertenecen los gastos.
- **Gasto:** Representa un gasto asociado a un empleado y un departamento, con detalles como fecha, descripción y monto.

#### Endpoints Principales
1. **Empleado**
   - `GET /empleado`: Lista todos los empleados.
   - `POST /empleado`: Registra un nuevo empleado.

2. **Departamento**
   - `GET /departamento`: Lista todos los departamentos.
   - `POST /departamento`: Registra un nuevo departamento.

3. **Gasto**
   - `GET /gasto`: Lista todos los gastos.
   - `POST /gasto`: Registra un nuevo gasto.
   - `GET /gasto/filtrar`: Filtra gastos en un rango de fechas.

El backend también realiza validaciones al registrar gastos, asegurándose de que los empleados y departamentos asociados existan.

### Frontend

El frontend proporciona una interfaz de usuario para:
- Visualizar empleados, departamentos y gastos.
- Filtrar gastos según un rango de fechas y visualizar los resultados agrupados por departamento.
- Mostrar un resumen general con el monto total filtrado.

#### Características
- **Visualización Tabular:** Datos de empleados, departamentos y gastos se presentan en tablas organizadas.
- **Filtro Interactivo:** Permite a los usuarios seleccionar un rango de fechas y obtener gastos específicos.
- **Diseño Dinámico:** Incluye un resumen con el monto total agrupado por departamento y un total general.

---

## Tecnologías Utilizadas

### Backend
- **Java 17**
- **Spring Boot 3.0**
- **JPA/Hibernate** para el manejo de la base de datos.
- **MySQL** como sistema de base de datos relacional.

### Frontend
- **Vue.js 3**
- **Axios** para las solicitudes HTTP al backend.
- **CSS** para el diseño y estilización.

### Despliegue
- **Vercel** para el frontend.

---

## Instalación y Ejecución

### Backend
1. Clona el repositorio.
   ```bash
   git clone https://github.com/usuario/proyecto-gastos.git
   cd proyecto-gastos/backend
   ```
2. Configura la base de datos en el archivo `application.properties`.
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nombre_base_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```
3. Ejecuta el backend con Maven o tu IDE favorito.
   ```bash
   mvn spring-boot:run
   ```

### Frontend
1. Ve al directorio del frontend.
   ```bash
   cd proyecto-gastos/frontend
   ```
2. Instala las dependencias.
   ```bash
   npm install
   ```
3. Inicia el servidor de desarrollo.
   ```bash
   npm run dev
   ```

---

## Uso

1. Abre la aplicación en tu navegador.
2. Navega a través de las diferentes secciones para gestionar empleados, departamentos y gastos.
3. Utiliza el filtro de rango de fechas para obtener un análisis detallado de los gastos.

---

## Recursos

- [Video explicativo en YouTube](https://www.youtube.com/watch?v=ydTaJ1HXcRU)
- [Despliegue en Vercel](https://mini-core-ecru.vercel.app/)

---

## Despliegue

La aplicación está desplegada en Vercel. Puedes acceder a ella a través del siguiente enlace:

[https://mini-core-ecru.vercel.app/](https://mini-core-ecru.vercel.app/)

---

## Contacto

Fernando Camacho
Telefono: 0984147484
Correo: fernando.camacho@udla.edu.ec
