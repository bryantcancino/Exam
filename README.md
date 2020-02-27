# Examen

## Requisitos

1. Java >= 1.8
2. jcommon-1.0.16.jar
3. jfreechart-1.0.13.jar

> **NOTA:** Las librerias JAR son agregads en la carpeta *jar_files* (ubicada en la raiz).

## Tipo de proyecto

java project

### Capturar los datos de la petición

En el archivo **Main**, que se encuentra en ***src/www/bryant/cancino/com/***. Se deberá modificar los puntos (no importa el orden), cuidando que sean enteros naturales, como se muestra en el siguiente fragmento de código:

```java
public static void main(String[] args) {
  ArrayList<Point> points = new ArrayList<Point>();
  
  points.add(new Point(3, 15));
  points.add(new Point(6, 12));
  points.add(new Point(2, 10));
  points.add(new Point(16, 5));
  points.add(new Point(13, 10));
  points.add(new Point(12, 0));
  points.add(new Point(2, 10));
  points.add(new Point(2, 5));
  points.add(new Point(17, 1));
  points.add(new Point(17, 1));

  if(!validationArray(points)) {
    System.out.println("Check the format");
    return;
  }
  
  points = Perimeter.addStartEndPoints(points);
  points = Perimeter.deleteRepeatedPoints(points);
  points = Perimeter.cleanHorizontalPoints(points);   
  printArray(points);
  Frame.drawGraphic(points);
}
```