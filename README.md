# TABLETS ACCES & CONTROL
Arquitectura en 3 capas
"Cada tablet debe ser registrado"
-Programadoras:
Antonieta Cux Morales,
Flor de María Eliza Mox Chiroy,
Delmy Gabriela Bajxac Cos.

SEMANA 06-PROYECTO
## 1. Capa de Presentación
* *Vista:* Interfaz de usuario (pantallas de inicio de sesión, registro de estudiantes y registro de tabletas).
* *Controlador:* Recibe las solicitudes de la Vista y las pasa a la Capa de Negocio (Servicio).

---

## 2. Capa de Negocio (Servicios y Reglas)
ResponsableServicio:
Recibe los datos del estudiante/encargado.
Regla de negocio: Valida que se anote el nombre completo.
 Si es válido, solicita guardarlo al ResponsableRepositorio.
TabletaServicio:
Recibe los datos de la tableta.
Regla de negocio: Valida que el número de tableta esté registrado y sea correcto.
Si es válido, solicita guardarlo al TabletaRepositorio.

---

## 3. Capa de Datos (Entidades y Repositorios)
Entidades:
Responsable: Nombre_estudiante, Teléfono, Nombre_encargado, Grado_sección.
Tableta: Número_tableta, Fecha_recibo, Estado.
Repositorios (Acceso a la base de datos):
ResponsableRepositorio: Métodos para guardar(), buscarpor_Id() y listarTodos().
TabletaRepositorio: Métodos para guardar(), buscarpor_Numero() y listarTodas().

---

## Verificación de Bajo Acoplamiento (Paso 4)
El flujo de datos respeta estrictamente la jerarquía sin saltarse capas:  
Vista ➔ Controlador ➔ Servicio ➔ Repositorio

