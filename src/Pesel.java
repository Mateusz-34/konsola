public class Pesel {
    private String pesel = "";

    public Pesel (String pesel){
        if (pesel.length() != 11){
            throw new RuntimeException("Niepoprawna dlugosc");
        }
        for (int i = 0; i < pesel.length(); i++){
            if (pesel.charAt(i) < '0' || pesel.charAt(i) > '9'){
                throw new RuntimeException("Niepoprawny znak w peselu");
            }
        }
        if (!czyPoprawnyPesel(pesel)) {
            throw new RuntimeException("Niepoprawna suma kontrolna");
        }
        this.pesel = pesel;
    }

    public String toString(){
        return pesel;
    }

    public char plec(){
        if ((pesel.charAt(9) - '0') % 2 == 1) {
            return 'M';
        } else {
            return 'K';
        }
    }

    private static boolean czyPoprawnyPesel(String pesel){
        int []tablicaCyfr = new int[11];

        for (int i = 0; i < 11; i++){
            tablicaCyfr[i] = pesel.charAt(i) - '0';
        }

        int S = tablicaCyfr[0] + tablicaCyfr[1] * 3 + tablicaCyfr[2] * 7 + tablicaCyfr[3] * 9
                + tablicaCyfr[4] + tablicaCyfr[5] * 3 + tablicaCyfr[6] * 7 + tablicaCyfr[7] * 9
                + tablicaCyfr[8] + tablicaCyfr[9] * 3;

        int M = S % 10;
        int R = 10 - M;

        if (R == tablicaCyfr[10]){
            return true;
        } else {
            return false;
        }
    }
}
