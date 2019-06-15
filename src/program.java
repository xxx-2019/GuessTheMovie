import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class program {
    private int actRunda;
    private int maxRunda;
    private String fileName;
    private movie film;

    public program() {
        actRunda = 0;
        maxRunda = 10;
        fileName = "movies.txt";
        film = new movie();
    }

    public void run() {
        Scanner sc;
        String tmp;

        // Sprawdzenie czy plik istnieje
        if (!checkFileMovies()) return;

        // Wylosowanie nazwy filmu - jeśli z jakiegoś powodu powstał błąd to wyjście z programu
        if (!losujFilm()) return;

        // Ciało gry
        //System.out.println(film.getMovieName());
        //System.out.println(film.getMovieHihenName());
        sc = new Scanner(System.in);
        for (int i = 0; i < maxRunda; i++) {
            System.out.println("Runda: " + (i + 1) + ". Jaki to film (Ilość znaków: " + film.getNumberOfLetter() + ", ilość wyrazów:" + film.getNumberOfWords() + ")");
            System.out.println(film.getMovieHihenName());
            tmp = sc.nextLine();
            if (tmp.length() == 1) {
                // Odkrycie litery
                film.discoveredSign(tmp.toUpperCase().toCharArray()[0]);
                if (film.checkHidden()) {
                    System.out.println(film.getMovieHihenName());
                    System.out.println("GRATULACJE Wygrałeś!!!");
                    break;
                }
            } else {
                // Próba odgadnięcia nazwy filmu
                if (film.checkMovieName(tmp)) {
                    film.discoveredAll();
                    System.out.println(film.getMovieHihenName());
                    System.out.println("GRATULACJE Wygrałeś!!!");
                    break;
                }
            }
        }
    }

    private boolean losujFilm() {
        boolean ret = false;

        try {
            // Określenie ilości filmów (wierszy) w pliku
            int iloscFilmow = 0;
            int rn;

            File f = new File(fileName);
            Scanner fsc = new Scanner(f);

            while (fsc.hasNextLine()) {
                String tmp = fsc.nextLine();
                iloscFilmow ++;
            }
            fsc.close();

            // Losowanie numeru filmu z pliku
            Random rg = new Random();
            rn = rg.nextInt(iloscFilmow);

            // Pobieranie nazwy wylosowanego pliku
            f = new File(fileName);
            fsc = new Scanner(f);
            iloscFilmow = 0;

            while (fsc.hasNextLine()) {
                String tmp = fsc.nextLine();
                if (iloscFilmow == rn) {
                    film.setMovieName(tmp.trim());
                    break;
                }
                iloscFilmow ++;
            }
            fsc.close();

            ret = true;
        }
        catch (Exception e) {
            System.out.println("Wystąpił błąd: " + e.getMessage() + ". Program przerwany");
        }

        return ret;
    }

    public int getMaxRund() {
        return maxRunda;
    }

    public boolean checkFileMovies() {
        boolean ret = false;
        File f = new File(fileName);
        if (f.exists()) {
            return true;
        } else {
            System.out.println("Nie można odnaleźć pliku z nazwami filmów (" + fileName + "). Program przerwany");
        }

        return ret;
    }
}
