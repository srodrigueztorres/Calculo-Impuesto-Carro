# Cálculo de Impuestos de un Carro (Java - MVC)

Proyecto de ejemplo para la actividad: Implementación en Java con patrón MVC y una interfaz gráfica en Swing.

## Estructura
- src/com/impuestos/model: Vehiculo.java, CalculadoraImpuestos.java
- src/com/impuestos/controller: ImpuestoController.java
- src/com/impuestos/view: ImpuestoView.java
- src/com/impuestos/Main.java

## Compilación y ejecución (línea de comando)
1. Desde la carpeta raíz del proyecto:
```bash
javac -d out $(find src -name "*.java")
java -cp out com.impuestos.Main
```
2. También puede importar el proyecto en un IDE (IntelliJ IDEA, Eclipse) y ejecutar `com.impuestos.Main`.

## Notas
- Las reglas de cálculo en `CalculadoraImpuestos` son de ejemplo. Ajuste las tarifas y reglas según la normativa local.
- Para entregar, cree un repositorio Git (GitHub/GitLab), agregue todos los archivos y comparta la URL con el tutor.
