package Application.Modele;

public enum Portee {
    LOCAL("Local"),
    NATIONAL("National"),
    INTERNATIONAL("International");

    private final String name;

    private Portee(String s) {
        name = s;
    }

    public static String[] toStrings() {
        return new String[]{LOCAL.getName(), NATIONAL.getName(), INTERNATIONAL.getName()};
    }

    public static Portee stringToPortee(String str){
        return switch (str) {
            case "Local" -> Portee.LOCAL;
            case "National" -> Portee.NATIONAL;
            case "International" -> Portee.INTERNATIONAL;
        };
    }

    public String getName() {
        return name;
    }
}
