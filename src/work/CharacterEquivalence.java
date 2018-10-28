package work;

public class CharacterEquivalence {

    private char umista;
    private char napa;

    public CharacterEquivalence(String u, String n) {
        umista = u.charAt(0);
        napa = n.charAt(0);
    }

    public char getUmista() {
        return umista;
    }

    public char getNapa() {
        return napa;
    }

    public String equivalency() {
        // return super.toString();
        return umista + " = " + napa;
    }
}
