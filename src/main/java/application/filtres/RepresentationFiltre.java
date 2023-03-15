package application.filtres;

public record RepresentationFiltre(String nomFiltre, String[] optionsFiltre) {

}/*

    public void setFiltreTournois(String[] nomJeux) {
        List<VueComboFiltre> listeFiltres = new ArrayList<>();
        listeFiltres.add(new VueComboFiltre("Avancement", new String[]{"Tous", "En Cours", "A Venir", "Finis"}));
        listeFiltres.add(new VueComboFiltre("Inscription", new String[]{"Tous", "En Cours", "Finis"}));
        listeFiltres.add(new VueComboFiltre("Multigaming", new String[]{"Tous", "Multigaming", "Jeu unique"}));
        listeFiltres.add(new VueComboFiltre("Jeu", nomJeux));
        listeFiltres.add(new VueComboFiltre("Portée", Portee.toStrings()));
        setToFiltres(listeFiltres);
    }

    public void setFiltreRencontres(String[] nomTournois,String[] nomEquipes, String[] nomJeux) {
        List<VueComboFiltre> listeFiltres = new ArrayList<>();
        listeFiltres.add(new VueComboFiltre("Avancement", new String[]{"Tous", "A Venir", "Finis"}));
        listeFiltres.add(new VueComboFiltre("Jeu", nomJeux));
        listeFiltres.add(new VueComboFiltre("Tournoi", nomTournois));
        listeFiltres.add(new VueComboFiltre("Equipe", nomEquipes));
        setToFiltres(listeFiltres);
    }
    public void setPanelFiltresEquipes(String[] nomEcuries, String[] nomJeux) {
        List<VueComboFiltre> listeFiltres = new ArrayList<>();
        listeFiltres.add(new VueComboFiltre("Ecuries", nomEcuries));
        listeFiltres.add(new VueComboFiltre("Jeu", nomJeux));
        setToFiltres(listeFiltres);
    }*/