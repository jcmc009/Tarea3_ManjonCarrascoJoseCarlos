# 🛸 Rick and Morty App - Tarea 3
**Desarrollado por:** José Carlos Manjón Carrasco

## 📝 Introducción
Esta aplicación es una herramienta Android nativa desarrollada en **Kotlin**, diseñada para consumir y visualizar información sobre la popular serie de animación "Rick and Morty".

El propósito principal de la aplicación es permitir a los usuarios gestionar su acceso mediante una cuenta segura, consultar el listado actualizado de episodios obtenidos desde una API externa y configurar preferencias personales de la aplicación. El proyecto demuestra la implementación de una arquitectura moderna y el uso de componentes estándar de la industria.

---

## 🚀 Características principales

### 🔐 Autenticación de Usuarios
* **Sistema de Registro e Inicio de Sesión** utilizando Firebase Authentication.
* **Validación de credenciales** (email y contraseña) y gestión de errores en tiempo real.
* Cierre de sesión seguro.

### 📜 Listado de Episodios
* Visualización de episodios en un `RecyclerView` optimizado.
* **Detalles del elemento:** Título, Código del episodio (ej: S01E01), Fecha de emisión e Imagen representativa.
* Implementación de `CardView` para un diseño limpio y moderno.

### ⚙️ Menú Lateral y Navegación
* Uso de **DrawerLayout** y **Navigation Component** para una navegación fluida entre secciones.
* Gestión de visibilidad de la Toolbar (oculta en Login/Registro, visible en pantallas principales).

### 🔧 Ajustes de Usuario (Persistencia)
* **Cambio de Tema:** Interruptor para alternar entre Modo Claro y Modo Oscuro.
* **Cambio de Idioma:** Opción para alternar entre Castellano e Inglés.
* *Nota:* Los ajustes se guardan localmente utilizando `SharedPreferences`.

### ℹ️ Información de la App
* Diálogo emergente ("Acerca de") que muestra la versión dinámica de la app y el nombre del desarrollador.

---

## 🛠️ Tecnologías utilizadas

> El proyecto sigue el patrón de arquitectura **MVVM (Model-View-ViewModel)** para separar la lógica de negocio de la interfaz de usuario.

* **Lenguaje:** Kotlin
* **Backend / BaaS:** Firebase Authentication
* **Red / API:**
    * `Retrofit 2`: Cliente HTTP para conectar con la Rick and Morty API.
    * `Gson`: Convertidor para serializar/deserializar JSON.
    * `Coroutines`: Para la gestión de hilos en segundo plano y llamadas asíncronas.
* **Interfaz de Usuario (UI):**
    * `ViewBinding`: Para la vinculación segura de vistas XML.
    * `Material Design Components`: Inputs, botones, tarjetas y switches modernos.
    * `Glide`: Librería para la carga y caché de imágenes.
* **Navegación:** Android Jetpack Navigation Component (NavGraph).
* **Almacenamiento Local:** SharedPreferences (para configuración de usuario).

---
## 💡 Conclusiones del desarrollador

El desarrollo de esta práctica, así como el módulo de PMDM en general, está suponiendo un reto significativo debido a la **curva de aprendizaje** y al ritmo intensivo del curso. Sin embargo, considero que la tarea ha sido muy enriquecedora por varios motivos:

1.  **Interpretación de Documentación:** He mejorado notablemente mi capacidad para leer e implementar documentación técnica de terceros, fundamental para integrar servicios como **Firebase** y realizar el consumo de **APIs REST** públicas.
2.  **Configuración de Entornos:** La configuración inicial de Firebase supuso un desafío técnico, ya que requiere una precisión absoluta en los archivos de configuración y credenciales para su correcto funcionamiento.
3.  **Arquitectura y Organización:** A pesar de ser una aplicación aparentemente sencilla, el volumen de código y ficheros generados me ha obligado a ser meticuloso en la **organización del proyecto** y la coordinación de los distintos componentes.
---
## 📲 Instrucciones de uso

Sigue estos pasos para ejecutar el proyecto en tu entorno local:


* 1. [clonar Repositorio] https://github.com/jcmc009/Tarea3_ManjonCarrascoJoseCarlos.git
* 2. Importar con Android Studio
* 3. Ejecutar localmente