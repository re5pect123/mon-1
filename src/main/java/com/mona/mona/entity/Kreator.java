package com.mona.mona.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class Kreator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true, nullable = false)
    int id;

    String username;
    String artikl;
    String materijal;
    String kolekcija;
    String sifra;
    String slika;
    @ColumnDefault("0")
    int aktiviran;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getArtikl() {
        return artikl;
    }

    public void setArtikl(String artikl) {
        this.artikl = artikl;
    }

    public String getMaterijal() {
        return materijal;
    }

    public void setMaterijal(String materijal) {
        this.materijal = materijal;
    }

    public String getKolekcija() {
        return kolekcija;
    }

    public void setKolekcija(String kolekcija) {
        this.kolekcija = kolekcija;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public int getAktiviran() {
        return aktiviran;
    }

    public void setAktiviran(int aktiviran) {
        this.aktiviran = aktiviran;
    }

    @Override
    public String toString() {
        return "Kreator{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", artikl='" + artikl + '\'' +
                ", materijal='" + materijal + '\'' +
                ", kolekcija='" + kolekcija + '\'' +
                ", sifra='" + sifra + '\'' +
                ", slika='" + slika + '\'' +
                ", aktiviran=" + aktiviran +
                '}';
    }
}
