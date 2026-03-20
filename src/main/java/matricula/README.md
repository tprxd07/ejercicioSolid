# Análisis y corrección SOLID — Paquete: matricula

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):** SRP

## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
- La clase MatriculaService se encarga de absolutamente todo, siendo esto la gestión de datos, el calculo de descuentos y la validación del dni, siendo el cosntructor lo único que aporta la clase Matricula

**Síntomas que lo delatan (marca y explica brevemente):**

- Si cambian las reglas de descuento, si cambia el formato del informe, si cambia la forma de validar un DNI o si se desea cambiar la salida por consola por otro tipo de notificación, hay que modificar siempre el mismo archivo MatriculaService.

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**

- Todo lo que se haga se tiene que comprobar en la clase MatriculaService, cuando sería mucho más facil dividirlo en métodos y aislar los métodos que funcionan de los que tienen fallos. Además, se deberia de modificar unicamente la clase MatriculaService si se quiere cambiar algo de cualquier método, llegando a ser un código frágil y expuesto a que se rompa si se modifica algo. 

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**

- La forma ideal sería trasladar a la clase Matricula su constructor y métodos la responsabilidad de validarse a sí misma, calcular su propio precio final y formatear su propia representación para informes. Así, la clase MatrículaService y cualquier clase que herede de Matricula comparta métodos que de otra forma se deberian de implementar en cada clase herdada. 