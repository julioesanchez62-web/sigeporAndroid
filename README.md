# SIGEPOR - Sistema de Gestión Porcina 🐷

Este proyecto es una aplicación Android diseñada para la gestión de procesos en la industria porcina. A continuación, se detalla el proceso de creación, las correcciones técnicas realizadas y una breve explicación de cada etapa.

## 🚀 Proceso de Creación Paso a Paso

### 1. Diseño de la Interfaz (UI)
Se utilizó **XML Layouts** para crear una pantalla de inicio de sesión moderna y funcional.
*   **Contenedor Principal**: Un `ScrollView` para asegurar que el contenido sea accesible en pantallas de cualquier tamaño.
*   **Componentes**: Se implementaron `CardView` para agrupar el formulario, `EditText` para la entrada de datos (Usuario/Contraseña), un `Spinner` para la selección de roles (Administrador, Operario, Veterinario) y un `Button` con diseño personalizado.

### 2. Configuración del Entorno (Gradle)
Para garantizar la compatibilidad con las librerías modernas de Android, se ajustó la configuración del proyecto:
*   **Versión de API**: Se actualizó el `compileSdk` y `targetSdk` a la **versión 37 (Android 15)**. Esto fue necesario para cumplir con los requisitos de la librería `androidx.core:core:1.19.0`.

### 3. Desarrollo de la Lógica (Kotlin)
La funcionalidad principal se programó en `MainActivity.kt`:
*   **Vinculación de Vistas**: Uso de `findViewById` para conectar el código Kotlin con los elementos del XML.
*   **Validación de Datos**: Se implementó una lógica para verificar que los campos no estén vacíos antes de permitir el "ingreso".
*   **Gestión de Roles**: Uso de un `ArrayAdapter` para poblar el selector de roles dinámicamente.

### 4. Internacionalización y Recursos
Se aplicaron mejores prácticas de Android para el manejo de textos:
*   **Strings Externos**: Todos los mensajes de error y bienvenida se movieron a `res/values/strings.xml`, evitando textos fijos en el código (hardcoded strings).

---

## 🔧 Correcciones Técnicas Importantes

Durante el desarrollo, se identificaron y solucionaron los siguientes puntos críticos:

1.  **Error de Metadatos AAR**: La aplicación no compilaba debido a una discrepancia entre la versión del SDK del proyecto y los requisitos de las dependencias. Se solucionó elevando el SDK a la versión 37.
2.  **Error de Paquete (Unresolved Reference R)**: El archivo `MainActivity.kt` tenía un nombre de paquete incorrecto (`com.example.miprimeraapp`), lo que impedía que reconociera los recursos del proyecto (`R`). Se corrigió a `com.example.myapplication`.
3.  **Refactorización de Código**: Se limpió la lógica de validación para incluir feedback visual al usuario mediante `Toast` y cambios de color en el `TextView` de resultados.

---

## 🛠️ Tecnologías Utilizadas
*   **Lenguaje**: Kotlin
*   **Entorno**: Android Studio
*   **Versión de SDK**: 37 (Android 15)
*   **Componentes de Diseño**: Material Components, CardView, ConstraintLayout.
