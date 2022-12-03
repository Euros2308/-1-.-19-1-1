/*Customer: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Номер банковского счета.
Создать массив объектов. Вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Shop market = new Shop("Theia");
        market.addCustomerToShopList(new Customer("Арипджанова", "Малика", "Талатовна", 758_265_999, 6996));
        market.addCustomerToShopList(new Customer("Дукмас", "Злата", "Сергеевна", 249_134_694, 1008));
        market.addCustomerToShopList(new Customer("Лебедев", "Николай", "Андреевич", 100_699_809, 6740));
        market.addCustomerToShopList(new Customer("Ахраров", "Алексей", "Станиславович", 368_427_418, 1258));
        market.addCustomerToShopList(new Customer("Бызова", "Екатерина", "Алексеевна", 999_025_589, 9731));
        System.out.println("\nСортировка по имени:");
        List<Customer> listSortByName = market.getListName();
        for (Customer c : listSortByName) {
            System.out.println(c);
        }
        System.out.println("\nСортировка по фамилии:");
        List<Customer> listSortBySurname = market.getListSurname();
        for (Customer c : listSortBySurname) {
            System.out.println(c);
        }
        System.out.println("\nСортировка по кредитной карте:");
        List<Customer> diapasonCardumber = market.getListDiapasonCardNumber(0000000000,696969696);
        for (Customer c : diapasonCardumber) {
            System.out.println(c);
        }
    }
}
class Shop {
    private String ShopName;
    private ArrayList<Customer> customerList = new ArrayList<>();
    Shop(String ShopName) {
        this.ShopName = ShopName;
    }
    void addCustomerToShopList(Customer customer) {
        customerList.add(customer);
    }
    List<Customer> getListName() {
        List<Customer> list = new ArrayList<>(customerList);
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return list;
    }
    List<Customer> getListSurname() {
        List<Customer> list = new ArrayList<>(customerList);
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getSurname().compareToIgnoreCase(o2.getSurname());
            }
        });
        return list;
    }
    List<Customer> getListDiapasonCardNumber(int diapasonStart, int diapasonEnd) {
        List<Customer> list = new ArrayList<>();
        for (Customer c : customerList) {
            if (c.getCardNumber() >= diapasonStart && c.getCardNumber() <= diapasonEnd) {
                list.add(c);
            }
        }
        return list;
    }
}
class Customer {
    {
        idGenertor++;
    }
    private static int idGenertor = 0;
    private int id = idGenertor;
    private String surname;
    private String name;
    private String patronymic;
    private int CardNumber;
    private int BankNumber;
    Customer(String surname, String name, String patronymic, int CardNumber, int BankNumber) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.CardNumber = CardNumber;
        this.BankNumber = BankNumber;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public int getCardNumber() {
        return CardNumber;
    }
    public int getBankNumber() {
        return BankNumber;
    }
    public String toString() {
        return String.format("ID: %d\t Имя: %s\t Фамилия: %s\t Отчество %s \t Номер карты %d\t Номер банка %d",
                id, surname, name, patronymic, CardNumber, BankNumber);
    }
}
