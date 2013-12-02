package com.zxy.web.framework.locus.model;

import javax.persistence.*;

@Table(name = "xz_artery")
@Entity
public class Artery extends PatientInfo {

    private ArteryClinic arteryClinic;

    private ArteryCoil arteryCoil;

    private ArteryDescrib arteryDescrib;

    private ArteryTreat arteryTreat;

    private ArteryVisit arteryVisit;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public ArteryTreat getArteryTreat() {
        return arteryTreat;
    }

    public void setArteryTreat(ArteryTreat arteryTreat) {
        this.arteryTreat = arteryTreat;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public ArteryDescrib getArteryDescrib() {
        return arteryDescrib;
    }

    public void setArteryDescrib(ArteryDescrib arteryDescrib) {
        this.arteryDescrib = arteryDescrib;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public ArteryCoil getArteryCoil() {
        return arteryCoil;
    }

    public void setArteryCoil(ArteryCoil arteryCoil) {
        this.arteryCoil = arteryCoil;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public ArteryClinic getArteryClinic() {
        return arteryClinic;
    }

    public void setArteryClinic(ArteryClinic arteryClinic) {
        this.arteryClinic = arteryClinic;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public ArteryVisit getArteryVisit() {
        return arteryVisit;
    }

    public void setArteryVisit(ArteryVisit arteryVisit) {
        this.arteryVisit = arteryVisit;
    }
}
