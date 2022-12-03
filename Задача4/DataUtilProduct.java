import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
public class DataUtilProduct {
    public static List<Product> productList = new ArrayList<Product>() {
        {
            this.add(new Product("смартфон","samsung galaxy A53",26975));
            this.add(new Product("смартфон","realme C21Y",10364));
            this.add(new Product("смартфон","honor 70",36309));
            this.add(new Product("ноутбук","asus",93500));
            this.add(new Product("ноутбук","acer travel mate",63085));
            this.add(new Product("ноутбук","lenovo",107190));
            this.add(new Product("планшет","huawei",13050));
            this.add(new Product("планшет","tcl",35000));
            this.add(new Product("планшет","prestigio",10000));
            this.add(new Product("наушники беспроводные","xiaomi redmi buds",1692));
            this.add(new Product("наушники беспроводные","philips TAH4205BK",2995));
            this.add(new Product("наушники беспроводные","zte",3300));
            this.add(new Product("телевизор","blaupunkt",20990));
            this.add(new Product("телевизор","thomson",30135));
            this.add(new Product("телевизор","lg",58025));
        }
    };
    //создание уникального списка товаров по наименованию
    private static Set<String> createNameSet() {
        Set<String> nameSet = new TreeSet<>();
        for (Product list : productList) {
            nameSet.add(list.getName());
        }
        return nameSet;
    }
    //ввод наименования товара и проверка его наличия в списке
    private static String readNameProduct(BufferedReader reader) throws IOException {
        System.out.println("Выберите наименование товара из списка: ");
        System.out.print(createNameSet() + " - ");
        String name;
        while (true) {
            name = reader.readLine();
            if (createNameSet().contains(name.toLowerCase())) {
                break;
            } else {
                System.out.print("Ничего не найдено, попробуйте еще раз: ");
            }
        }
        return name;
    }
    //Поиск тавара по наименованию
    private static List<Product> searchByNameProduct(BufferedReader reader) throws IOException {
        String name = readNameProduct(reader);
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (name.equalsIgnoreCase(product.getName())) {
                products.add(product);
            }
        }
        return products;
    }
    //ввод производителя товара и проверка его наличия в списке
    private static String readManufacturerProduct(Set<String> manufacturerSet, BufferedReader reader) throws IOException {
        System.out.println("Выберите производителя товара из списка: ");
        System.out.print(manufacturerSet + " - ");
        String manufacturer;
        while (true) {
            manufacturer = reader.readLine();
            if (manufacturerSet.contains(manufacturer.toLowerCase())) {
                break;
            } else {
                System.out.print("Ничего не найдено, попробуйте еще раз: ");
            }
        }
        return manufacturer;
    }
    //Поиск товара
    public static Product searchProduct(BufferedReader reader) throws IOException {
        Product product = null;
        List<Product> list = searchByNameProduct(reader);
        Set<String> manufacturerSet = new TreeSet<>();
        for (Product element : list) {
            manufacturerSet.add(element.getManufacturer());
        }
        String manufacturer = readManufacturerProduct(manufacturerSet, reader);
        for (Product element : list) {
            if (manufacturer.equalsIgnoreCase(element.getManufacturer())) {
                product = element;
                break;
            }
        }
        return product;
    }
    //ввод количества товара
    public static int readQuantity(BufferedReader reader) throws IOException {
        System.out.print("Введите количество товара: ");
        int quantity = Integer.parseInt(reader.readLine());
        return quantity;
    }
}
