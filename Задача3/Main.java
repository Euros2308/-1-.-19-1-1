//Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.

public class Main {
    public static void main(String[] args) {
        Car audi = new Car("Audi R8");
        System.out.printf("Создан автомобиль %s. Test drive:%n", audi.getModelName());
        audi.run();
        Engine engine = new Engine(950, 6.485);
        audi.setEngine(engine);
        System.out.printf("%nДвигательная мощность %d л.с. Объем %.3f литров. Test drive:%n",
                engine.getPower(), engine.getVolume());
        audi.run();
        int whellDiameter = 50;
        audi.setWheels(new Wheel(whellDiameter), new Wheel(whellDiameter), new Wheel(whellDiameter), new Wheel(whellDiameter));
        System.out.printf("%nУстановка колес. Test drive:\n");
        audi.run();
        audi.getWheels().get(2).breakWheel();
        System.out.println("\nSTOP! Что-то сломалось.\nTest drive:");
        audi.run();
        audi.changeWheel();
        System.out.println("\nTest drive:");
        audi.run();
        System.out.println("...");
        audi.setFuel(false);
        audi.run();
        audi.refuel();
        audi.run();
        System.out.println("\nМодель автомобиля: " + audi.getModelName());
    }
}
