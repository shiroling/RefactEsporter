package Modele;

import javax.persistence.*;

@Table(name = "Joueur")
public class Joueur {
    @Id
    @Column(name = "id_joueur")
    private int id;

    @Column(name = "")
    private String nom;

}
