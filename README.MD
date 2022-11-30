# Shapes
Simple project to demonstrate the capabilities of the different Java Garbage Collectors.

It will create as many objects as defined. At least two parameters are required and the minimum number for both of them is 1. In case 1 is provided as first parameter, it will create 5 objects.
The idea of creating these objects is to calculate the area and perimeter of 5 different shapes, which is just an excuse to consume resources like processor and memory.

## Usage
Call `java -jar shapes-1.0-SNAPSHOT.jar [NUMBER_OF_OBJECTS/5] [NUMBER_OF_THREADS]`
- The first argument is the number of objects to create, which will be multiplied by 5, which are the number of shapes supported as of now.
- The second argument is the number of threads to create.

## Examples
- `java -jar shapes-1.0-SNAPSHOT.jar 100000 100`
- `java -XX:+UseSerialGC -jar shapes-1.0-SNAPSHOT.jar 100000 100`
- `java -XX:+UseShenandoahGC -jar shapes-1.0-SNAPSHOT.jar 100000 100`
- `java -XX:+UseZGC -jar shapes-1.0-SNAPSHOT.jar 100000 100`