import java.util.ArrayList;
import java.util.Arrays;
class Car {
    private String modelName;
    private Engine engine;
    private ArrayList<Wheel> wheels;
    private boolean isFuel;
    Car(String modelName) {
        this.modelName = modelName;
        this.wheels = new ArrayList<>(10);
        this.isFuel = true;
    }
    void setEngine(Engine engine) {
        this.engine = engine;
    }
    ArrayList<Wheel> getWheels() {
        return wheels;
    }
    void setWheels(Wheel w1, Wheel w2, Wheel w3, Wheel w4) {
        this.wheels = new ArrayList<>(Arrays.asList(w1, w2, w3, w4));
    }
    String getModelName() {
        return modelName;
    }
    void changeWheel() {
        for(int i = 0; i < 4; i++) {
            if (!wheels.get(i).isGood()) {
                System.out.printf("№ %d изменен.\n", i + 1);
                int wheelDia = this.getWheels().get(i).getDiameter();
                this.getWheels().set(i, new Wheel(wheelDia));
            }
        }
    }
    void setFuel(boolean fuel) {
        this.isFuel = fuel;
    }
    void refuel() {
        this.isFuel = true;
        System.out.println("Машина заправлена.");
    }
    void run() {
        int wheelCounter = 0;
        String message = "";
        boolean isEngine = false;
        for (Wheel wheel : wheels) {
            if (wheel != null) {
                wheelCounter++;
            }
        }
        if (wheelCounter == 0) {
            message = "- колеса не установлены. Пожалуйста, установите 4 колеса.\n";
        } else if (wheelCounter == 1) {
            message = "- установлено только 1 колесо. Пожалуйста, установите еще 3 колеса\n";
        } else if (wheelCounter == 2 || wheelCounter == 3) {
            message = String.format("- установлено только %d колеса. Пожалуйста, установите еще %d колеса\n", wheelCounter, 4 - wheelCounter);
        }
        System.out.print(message);
        if (engine == null) {
            System.out.println("- двигатель не установлен. Пожалуйста, установите двигатель.");
        } else {
            isEngine = true;
        }
        if (isEngine && wheelCounter == 4) {
            boolean ready = true;
            for (int i = 0; i < 4; i++) {
                if (!wheels.get(i).isGood()) {
                    System.out.printf("- №%d колесо сломано. Пожалуйста замените колесо.%n", i + 1);
                    ready = false;
                }
            }
            if (!isFuel) {
                System.out.println("- кончилось топливо. Необходимо заправиться.");
            } else if (ready) {
                System.out.println("- машина выезжает на дорогу!");
            }
        }
    }
}
