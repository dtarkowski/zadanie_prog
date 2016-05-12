import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class zadanie_rekr {

    public static void main(String[] args) {
        double kwota = 0;
        if (args.length > 0) {
            try {
                String nazwaPliku = args[0];
                FileReader fileReader = new FileReader(nazwaPliku);
                BufferedReader reader = new BufferedReader(fileReader);
                String linia = null;
                while ((linia = reader.readLine()) != null) {
                    if (linia != null && !linia.equals("")) {
                        String wycinek = linia.substring(linia.indexOf("amount:") + 7, linia.indexOf("PLN"));
                        if (wycinek != null && !wycinek.equals("")) {
                            wycinek = wycinek.replace(",", ".");
                            kwota += Double.parseDouble(wycinek);
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("brak pliku o podanej nazwie!");
            } catch (IOException ex) {
                System.out.println("błąd odczytu pliku!");
            }
            System.out.println(String.format("%.2f", kwota));
        } else {
            System.out.println("brak pliku o podanej nazwie!");
        }
    }
}

