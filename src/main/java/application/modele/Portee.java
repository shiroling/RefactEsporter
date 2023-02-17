package application.modele;

public enum Portee {
    LOCAL("Local"),
    NATIONAL("National"),
    INTERNATIONAL("International");

    private final String name;

    Portee(String s) {
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
            default -> throw new IllegalArgumentException("Le String donné n'est pas une portee");
        };
    }

    public String getName() {
        return name;
    }
}
