package JavaOOP.InterfacesAndAbstraction.Exercise.Telephony_05;

import java.util.List;

public class Smartphone implements Callable, Browsable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        boolean hasSymbol = false;
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            for (char ch : number.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    hasSymbol = true;
                    break;
                }
            }
            if (hasSymbol) {
                sb.append("Invalid number!").append(System.lineSeparator());
            } else {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        boolean hasDigit = false;
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            for (char ch : url.toCharArray()) {
                if (Character.isDigit(ch)) {
                    hasDigit = true;
                    break;
                }
            }
            if (hasDigit) {
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
