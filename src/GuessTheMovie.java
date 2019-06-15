
public class GuessTheMovie {

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args.length > 1 || !(args[0].equalsIgnoreCase("-h") || args[0].equalsIgnoreCase("-help"))) {
                wrongParam();
            } else {
                help();
            }
        } else {
            info();
            program prc = new program();
            System.out.println("Masz " + prc.getMaxRund() + " rund na odgadnięcie nazwy filmu");
            prc.run();
        }
    }

    private static void help() {
        program prc = new program();
        info();
        System.out.println("Zasady gry:");
        System.out.println("Masz " + prc.getMaxRund() + " rund na odgadnięcie nazwy filmu");
        System.out.println("Nazwa składa się ze znaków (liter i/lub cyfr) o ilości równej ilości znaków podkreślenia. np: _ _ _ _ _ _ _ _ _ => nazwa filmu składa się z 9 znaków");
        System.out.println("W każdej rundzie możesz podać jeden znak w celu ujawnienia go w nazwie (jeśli istnieje) lub podać pełną nazwę filmu");
        System.out.println(("Wielkość podawanych znaków jest bez znaczenia"));
        System.out.println("Wygrasz, jeśli w ciągu " + prc.getMaxRund() + " rund odkryjesz wszystkie znaki w nazwie filmu, lub wprowadzisz jego pełną nazwę");
        System.out.println("");
    }

    private static void wrongParam() {
        info();
        System.out.println("Nieprawidłowy parametr wywołania");
        System.out.println("Użyj -h lub -help w celu uzyskania pomocy lub uruchom program bez parametrów");
        System.out.println("");
    }

    private static void info() {
        System.out.println("Program: \"Zgadnij Nazwę Filmu\". Copyright (C) 2019 by RK");
        System.out.println("");
    }
}