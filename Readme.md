# 📦 Sistema Logístico Alicorp

Sistema de escritorio para la gestión logística integral de una empresa de distribución, desarrollado como proyecto universitario individual. Cubre todo el ciclo: desde el registro de clientes y productos hasta el despacho y entrega de pedidos, con control de inventario y manejo de incidencias.

## 🎯 Funcionalidades principales

- **Gestión de Clientes** — registro, edición y consulta de clientes.
- **Gestión de Productos** — catálogo de productos con control de stock.
- **Inventario** — seguimiento de existencias con validación automática de stock disponible.
- **Pedidos** — creación y seguimiento de pedidos de clientes.
- **Despachos** — gestión de la salida de mercadería hacia el cliente.
- **Entregas** — confirmación y registro de entregas completadas.
- **Incidencias** — registro de problemas o novedades durante el proceso logístico.
- **Reportes** — generación de reportes sobre la operación.

Cada módulo cuenta con un CRUD completo (crear, leer, actualizar, eliminar) y un tema de color propio para diferenciarlos visualmente dentro de la interfaz.

## 🏗️ Arquitectura

El proyecto sigue el patrón **MVC + DAO**:

- **Model** — clases que representan las entidades del negocio (Cliente, Producto, Pedido, etc.).
- **View** — interfaces gráficas construidas con Java Swing.
- **Controller** — lógica que conecta la vista con los datos.
- **DAO (Data Access Object)** — capa dedicada exclusivamente al acceso a la base de datos vía JDBC, separando la lógica SQL del resto de la aplicación.

Las relaciones entre tablas (por ejemplo, un pedido que referencia a un cliente y a productos) se manejan mediante **claves foráneas con actualización en cascada**, definidas directamente en los scripts SQL del proyecto.

## 🛠️ Tecnologías

| Tecnología | Uso |
|---|---|
| Java (Swing) | Interfaz gráfica de escritorio |
| JDBC | Conexión y acceso a la base de datos |
| MySQL | Motor de base de datos |
| NetBeans | IDE de desarrollo |

## 🚀 Cómo ejecutarlo

### Requisitos previos
- JDK 8 o superior
- MySQL Server
- NetBeans IDE

### Pasos

1. Clona el repositorio:
   ```bash
   git clone https://github.com/jheimydev/sistema-logistico-alicorp.git
   ```
2. Abre el proyecto en NetBeans (`File > Open Project`).
3. Crea la base de datos en MySQL y ejecuta los scripts SQL incluidos en el proyecto (carpeta de scripts) para generar las tablas y sus relaciones.
4. Configura la conexión a la base de datos con tus credenciales locales de MySQL (usuario/contraseña) en la clase de conexión del proyecto.
5. Ejecuta el proyecto desde NetBeans (`Run > Run Project`).

## 📸 Capturas de pantalla

<p align="center">
  <img src="screenshots/MenuPrincipal.JPG" width="500" alt="Menú Principal">
  <br><sub><b>Menú Principal</b></sub>
</p>

| | | |
|---|---|---|
| ![Clientes](screenshots/Cliente.JPG) <br> **Clientes** | ![Productos](screenshots/Productos.JPG) <br> **Productos** | ![Inventario](screenshots/Inventario.JPG) <br> **Inventario** |
| ![Pedidos](screenshots/Pedidos.JPG) <br> **Pedidos** | ![Despachos](screenshots/Despacho.JPG) <br> **Despachos** | ![Entregas](screenshots/Entregas.JPG) <br> **Entregas** |
| ![Incidencias](screenshots/Incidencias.JPG) <br> **Incidencias** | ![Reportes](screenshots/Reportes.JPG) <br> **Reportes** | |

## 👤 Autor

**Jheimy Barbaron** — Estudiante de Ingeniería de Sistemas, Universidad Tecnológica del Perú (UTP)
[LinkedIn](https://www.linkedin.com/in/jheimy-juosep-barbaron-camargo-0395a71b7/) · [GitHub](https://github.com/jheimydev)
