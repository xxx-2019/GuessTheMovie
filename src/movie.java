public class movie {
    private String movieName;
    private String movieHiddenName;
    private int numberOfWords;
    private int numberOfLetter;
    private int numberOfLetterNoSpace;

    public movie() {
        movieName = "";
        movieHiddenName = "";
        numberOfWords = 0;
        numberOfLetter = 0;
        numberOfLetterNoSpace = 0;
    }

    public movie(String movieName) {
        setMovieName(movieName);
    }

    public void setMovieName(String movieName) {
        char[] chars;
        this.movieName = movieName.toUpperCase();
        chars = movieName.toCharArray();
        numberOfLetterNoSpace = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                movieHiddenName += " ";
            } else {
                numberOfLetterNoSpace++;
                movieHiddenName += "_";
            }
        }
        numberOfLetter = this.movieName.length();
        numberOfWords = this.movieName.split(" ").length;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieHihenName() {
        String ret = "";
        for (int i = 0; i < numberOfLetter; i++) {
            ret += movieHiddenName.toCharArray()[i] + " ";
        }

        return ret;
    }

    public void discoveredSign(char ch) {
        char[] mn, mhn;
        String newMovieHiddenName;
        int start = 0;
        int act = 0;

        mn = movieName.toCharArray();
        mhn = movieHiddenName.toCharArray();
        movieHiddenName = "";
        for (int i = 0; i < mn.length; i++) {
            if (mn[i] == ch) mhn[i] = ch;
            movieHiddenName += mhn[i];
        }
    }

    public void discoveredAll() {
        movieHiddenName = movieName;
    }

    public boolean checkMovieName(String movieName) {
        return this.movieName.equalsIgnoreCase(movieName);
    }

    // Metoda sprawdza, czy wszystkie znaki są odkryte
    public boolean checkHidden() {
        char[] chars;
        boolean ret = true;

        chars = movieHiddenName.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') {
                ret = false;
                break;
            }
        }
        return ret;
    }

    public int getNumberOfLetter() {
        return numberOfLetter;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public int getNumberOfLetterNoSpace() {
        return numberOfLetterNoSpace;
    }
}
