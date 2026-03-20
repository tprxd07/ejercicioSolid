# Análisis y corrección SOLID — Paquete: biblioteca

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):** LSP 

## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
- Libro y PrestamoService

**Síntomas que lo delatan (marca y explica brevemente):**

-La clase LibroReferencia hereda de Libro, pero anula el comportamiento esperado de prestarA. Mientras que el contrato original implica prestar el libro a un usuario (dni) por un tiempo determinado, LibroReferencia ignora los parámetros recibidos y les aplica "SALA" y la fecha actual.

-PrestamoService.prestar funciona mal, ya que internamente el objeto LibroReferencia ha guardado algo totalmente distinto ("SALA"). El cliente (PrestamoService) no puede confiar en que un Libro se comporte como tal.

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
-El diseño actual falla por que se engaña a PrestamoService para que piense que un liro es prestable, cuando en verdad librPrestado genera por defecto un DNI llamado "SALA"

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
-La solución consiste en modificar la clase Libro para incluir un método de consulta (esPrestable) que defina explícitamente si el objeto soporta la operación de préstamo, permitiendo que LibroReferencia declare su incapacidad de ser prestado; así, el PrestamoService puede validar esta capacidad antes de ejecutar la acción, asegurando que el comportamiento sea predecible.