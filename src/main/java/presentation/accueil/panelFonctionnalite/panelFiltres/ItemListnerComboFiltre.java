package presentation.accueil.panelFonctionnalite.panelFiltres;

public class ItemListnerComboFiltre implements item{




    private Etat state;

    public ItemListnerComboFiltre(ControleurAccueil controleurAccueil, Etat state) {
        super();
        this.controleurAccueil = controleurAccueil;
        this.state = state;
    }



    @Override
    public void itemStateChanged(ItemEvent e) {
        switch (this.state) {
            case TOURNOI:
                List<Tournoi> tournois = this.controleurAccueil.getTournois();

                switch(controleurAccueil.getComboFiltreAvencementTournoi().getSelectedItem().toString()) {
                    case "En Cours":
                        tournois = Filters.filtrer(tournois, Filters.estTournoiEnCours);
                        break;
                    case "A Venir":
                        tournois = Filters.filtrer(tournois, Filters.estTournoiAVenir);
                        break;
                    case "Finis" :
                        tournois = Filters.filtrer(tournois, Filters.estTournoiFini);
                        break;
                }

                switch(controleurAccueil.getComboFiltreInscriptionTournoi().getSelectedItem().toString()) {
                    case "En Cours":
                        tournois = Filters.filtrer(tournois, Filters.sontInscriptionsEnCours);
                        break;
                    case "Finis":
                        tournois = Filters.filtrer(tournois, Filters.sontInscriptionsFinies);
                        break;
                }

                switch(controleurAccueil.getComboFiltreMultiTournoi().getSelectedItem().toString()) {
                    case "Multigaming" :
                        tournois = Filters.filtrer(tournois, Filters.estTournoiMulti);
                        break;
                    case "Jeu unique":
                        tournois = Filters.filtrer(tournois, Filters.estTournoiJeuUnique);
                        break;
                }

                if(!(controleurAccueil.getComboFiltreJeuTournoi().getSelectedItem().toString().equals("Tous"))) {
                    tournois = Filters.filtrer(tournois, Filters.estTournoiSurJeu, Jeu.getJeuFromName(controleurAccueil.getComboFiltreJeuTournoi().getSelectedItem().toString()).getId());
                }

                if(!(controleurAccueil.getComboFiltrePorteeTournoi().getSelectedItem().toString().equals("Tous"))) {
                    tournois = Filters.filtrer(tournois, Filters.estTournoiDePortee, Portee.stringToPortee(controleurAccueil.getComboFiltrePorteeTournoi().getSelectedItem().toString()));
                }
                this.setCartesTournoiDansAccueil(tournois);
                break;
            case RENCONTRE:
                List<Rencontre> rencontres = this.controleurAccueil.getRencontres();

                switch(controleurAccueil.getComboFiltreAvencementRencontre().getSelectedItem().toString()) {
                    case "A Venir":
                        rencontres = Filters.filtrer(rencontres, Filters.estRencontreAVenir);
                        break;
                    case "Finis" :
                        rencontres = Filters.filtrer(rencontres, Filters.estRencontreFini);
                        break;
                }

                if(!(controleurAccueil.getComboFiltreJeuRencontre().getSelectedItem().toString().equals("Tous"))) {
                    rencontres = Filters.filtrer(rencontres, Filters.estRencontreSurJeu, Jeu.getJeuFromName(controleurAccueil.getComboFiltreJeuRencontre().getSelectedItem().toString()).getId());
                }

                if(!(controleurAccueil.getComboFiltreTournoiRencontre().getSelectedItem().toString().equals("Tous"))) {
                    rencontres = Filters.filtrer(rencontres, Filters.estRencontreDansTournoi, Tournoi.getTournoiFromNom(controleurAccueil.getComboFiltreTournoiRencontre().getSelectedItem().toString()).getId());
                }

                if(!(controleurAccueil.getComboFiltreEquipeRencontre().getSelectedItem().toString().equals("Tous"))) {
                    rencontres = Filters.filtrer(rencontres, Filters.estRencontreAvecEquipe, Equipe.getEquipeFromNom(controleurAccueil.getComboFiltreEquipeRencontre().getSelectedItem().toString()).getId());
                }

                this.setCartesRencontreDansAccueil(rencontres);
                break;
            case EQUIPE:
                List<Equipe> equipes = this.controleurAccueil.getEquipes();

                if(!(controleurAccueil.getComboFiltreEcuriesEquipe().getSelectedItem().toString().equals("Tous"))) {
                    equipes = Filters.filtrer(equipes, Filters.estEquipeFromEcurie, Ecurie.getEcurieFromNom(controleurAccueil.getComboFiltreEcuriesEquipe().getSelectedItem().toString()).getId());
                }

                if(!(controleurAccueil.getComboFiltreJeuEquipe().getSelectedItem().toString().equals("Tous"))) {
                    equipes = Filters.filtrer(equipes, Filters.estEquipeSurJeu, Jeu.getJeuFromName(controleurAccueil.getComboFiltreJeuEquipe().getSelectedItem().toString()).getId());
                }

                this.setCartesEquipeDansAccueil(equipes);;
                break;
        }
    }

    @SuppressWarnings("deprecation")
    private void setCartesTournoiDansAccueil(List<Tournoi> tournois) {
        if(tournois.size() == 0 ) {
            JLabel lblAucunEntite = new JLabel("-- Aucun Tournoi --");
            controleurAccueil.getVueAccueil().getPanelCartes().removeAll();
            controleurAccueil.getVueAccueil().getPanelCartes().add(lblAucunEntite);
            controleurAccueil.getVueAccueil().getPanelCartes().updateUI();
        } else {
            controleurAccueil.getVueAccueil().viderCartes();
            controleurAccueil.getVueAccueil().ajouterCartesTournois(tournois);
            controleurAccueil.getVueAccueil().getLblTitreCartes().setText("Tournois");
            controleurAccueil.getVueAccueil().ajusterGrille();
        }
    }

    @SuppressWarnings("deprecation")
    private void setCartesRencontreDansAccueil(List<Rencontre> rencontres) {
        if(rencontres.size() == 0 ) {
            JLabel lblAucunEntite = new JLabel("-- Aucun Match --");
            controleurAccueil.getVueAccueil().getPanelCartes().removeAll();
            controleurAccueil.getVueAccueil().getPanelCartes().add(lblAucunEntite);
            controleurAccueil.getVueAccueil().getPanelCartes().updateUI();
        } else {
            controleurAccueil.getVueAccueil().viderCartes();
            controleurAccueil.getVueAccueil().ajouterCartesMatch(rencontres);
            controleurAccueil.getVueAccueil().getLblTitreCartes().setText("Matchs");
            controleurAccueil.getVueAccueil().ajusterGrille();
        }
    }

    @SuppressWarnings("deprecation")
    private void setCartesEquipeDansAccueil(List<Equipe> equipes) {
        if(equipes.size() == 0 ) {
            JLabel lblAucunEntite = new JLabel("-- Aucune Equipe --");
            controleurAccueil.getVueAccueil().getPanelCartes().removeAll();
            controleurAccueil.getVueAccueil().getPanelCartes().add(lblAucunEntite);
            controleurAccueil.getVueAccueil().getPanelCartes().updateUI();
        } else {
            controleurAccueil.getVueAccueil().viderCartes();
            controleurAccueil.getVueAccueil().ajouterCartesEquipe(equipes);
            controleurAccueil.getVueAccueil().getLblTitreCartes().setText("Equipes");
            controleurAccueil.getVueAccueil().ajusterGrille();
        }
    }


    public void procedureAjouterCatrePanelCartes(Etat state, List<BDEntity> list) {
        JLabel lblAucunEntité = new JLabel();
        if(list.size() == 0 ) {
            switch(state) {
                case TOURNOI:
                    lblAucunEntité.setText("-- Aucun Tournoi --");
                    break;
                case RENCONTRE:
                    lblAucunEntité.setText("-- Aucun Match --");
                    break;
                case EQUIPE:
                    lblAucunEntité.setText("-- Aucune Equipe --");
                    break;
            }
            controleurAccueil.getVueAccueil().getPanelCartes().add(lblAucunEntité);
        } else {
            //this.setCartesDansAccueil(list);
        }
    }

}
