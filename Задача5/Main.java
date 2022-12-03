В тексте каждую букву заменить ее порядковым номером в алфавите. При выводе в одной строке печатать текст с двумя пробелами между буквами, в следующей строке внизу под каждой буквой печатать ее номер.
public class Main {
    public static void main(String[] args) {
        String text = "Я хочу пятёрку по учебной практике хаш хаш хаш";
        int temp;
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        System.out.println("Оригинал -> " + sb.toString());
        String formatchar = "%-3s";
        String formatint =  "%-3d";
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ') {
                System.out.format(formatchar, sb.charAt(i));
            }
        }
        System.out.println();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ') {
                temp = getIndex(sb.charAt(i));
                System.out.format(formatint, temp);
            }
        }
    }
    public static int getIndex(char letter) {
        int index = 0;
        char lowerCase = Character.toLowerCase(letter);
        switch (lowerCase) {
            case 'а':
                index = 1;
                break;
            case 'б':
                index = 2;
                break;
            case 'в':
                index = 3;
                break;
            case 'г':
                index = 4;
                break;
            case 'д':
                index = 5;
                break;
            case 'е':
                index = 6;
                break;
            case 'ё':
                index = 7;
                break;
            case 'ж':
                index = 8;
                break;
            case 'з':
                index = 9;
                break;
            case 'и':
                index = 10;
                break;
            case 'й':
                index = 11;
                break;
            case 'к':
                index = 12;
                break;
            case 'л':
                index = 13;
                break;
            case 'м':
                index = 14;
                break;
            case 'н':
                index = 15;
                break;
            case 'о':
                index = 16;
                break;
            case 'п':
                index = 17;
                break;
            case 'р':
                index = 18;
                break;
            case 'с':
                index = 19;
                break;
            case 'т':
                index = 20;
                break;
            case 'у':
                index = 21;
                break;
            case 'ф':
                index = 22;
                break;
            case 'х':
                index = 23;
                break;
            case 'ц':
                index = 24;
                break;
            case 'ч':
                index = 25;
                break;
            case 'ш':
                index = 26;
                break;
            case 'щ':
                index = 27;
                break;
            case 'ъ':
                index = 28;
                break;
            case 'ы':
                index = 29;
                break;
            case 'ь':
                index = 30;
                break;
            case 'э':
                index = 31;
                break;
            case 'ю':
                index = 32;
                break;
            case 'я':
                index = 33;
                break;
        }
        return index;
    }
}
