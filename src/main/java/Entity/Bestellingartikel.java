/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "Bestellingartikel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bestellingartikel.findAll", query = "SELECT b FROM Bestellingartikel b"),
    @NamedQuery(name = "Bestellingartikel.findByBestellingartikelId", query = "SELECT b FROM Bestellingartikel b WHERE b.bestellingartikelId = :bestellingartikelId"),
    @NamedQuery(name = "Bestellingartikel.findByAantal", query = "SELECT b FROM Bestellingartikel b WHERE b.aantal = :aantal")})
public class Bestellingartikel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bestellingartikel_id")
    private Integer bestellingartikelId;
    @Column(name = "aantal")
    private Integer aantal;
    @JoinColumn(name = "artikel_id", referencedColumnName = "artikel_id")
    @ManyToOne(optional = false)
    private Artikel artikelId;
    @JoinColumn(name = "bestelling_id", referencedColumnName = "bestelling_id")
    @ManyToOne(optional = false)
    private Bestelling bestellingId;

    public Bestellingartikel() {
    }

    public Bestellingartikel(Integer bestellingartikelId) {
        this.bestellingartikelId = bestellingartikelId;
    }

    public Integer getBestellingartikelId() {
        return bestellingartikelId;
    }

    public void setBestellingartikelId(Integer bestellingartikelId) {
        this.bestellingartikelId = bestellingartikelId;
    }

    public Integer getAantal() {
        return aantal;
    }

    public void setAantal(Integer aantal) {
        this.aantal = aantal;
    }

    public Artikel getArtikelId() {
        return artikelId;
    }

    public void setArtikelId(Artikel artikelId) {
        this.artikelId = artikelId;
    }

    public Bestelling getBestellingId() {
        return bestellingId;
    }

    public void setBestellingId(Bestelling bestellingId) {
        this.bestellingId = bestellingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bestellingartikelId != null ? bestellingartikelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bestellingartikel)) {
            return false;
        }
        Bestellingartikel other = (Bestellingartikel) object;
        if ((this.bestellingartikelId == null && other.bestellingartikelId != null) || (this.bestellingartikelId != null && !this.bestellingartikelId.equals(other.bestellingartikelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bestellingartikel[ bestellingartikelId=" + bestellingartikelId + " ]";
    }
    
}
