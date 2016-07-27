/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "Bestelling")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bestelling.findAll", query = "SELECT b FROM Bestelling b"),
    @NamedQuery(name = "Bestelling.findByBestellingId", query = "SELECT b FROM Bestelling b WHERE b.bestellingId = :bestellingId"),
    @NamedQuery(name = "Bestelling.findByTotaalPrijs", query = "SELECT b FROM Bestelling b WHERE b.totaalPrijs = :totaalPrijs")})
public class Bestelling implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bestelling_id")
    private Integer bestellingId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totaal_prijs")
    private BigDecimal totaalPrijs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bestellingId")
    private Collection<Bestellingartikel> bestellingartikelCollection;
    @JoinColumn(name = "klant_id", referencedColumnName = "klant_id")
    @ManyToOne(optional = false)
    private Klant klantId;

    public Bestelling() {
    }

    public Bestelling(Integer bestellingId) {
        this.bestellingId = bestellingId;
    }

    public Integer getBestellingId() {
        return bestellingId;
    }

    public void setBestellingId(Integer bestellingId) {
        this.bestellingId = bestellingId;
    }

    public BigDecimal getTotaalPrijs() {
        return totaalPrijs;
    }

    public void setTotaalPrijs(BigDecimal totaalPrijs) {
        this.totaalPrijs = totaalPrijs;
    }

    @XmlTransient
    public Collection<Bestellingartikel> getBestellingartikelCollection() {
        return bestellingartikelCollection;
    }

    public void setBestellingartikelCollection(Collection<Bestellingartikel> bestellingartikelCollection) {
        this.bestellingartikelCollection = bestellingartikelCollection;
    }

    public Klant getKlantId() {
        return klantId;
    }

    public void setKlantId(Klant klantId) {
        this.klantId = klantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bestellingId != null ? bestellingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bestelling)) {
            return false;
        }
        Bestelling other = (Bestelling) object;
        if ((this.bestellingId == null && other.bestellingId != null) || (this.bestellingId != null && !this.bestellingId.equals(other.bestellingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bestelling[ bestellingId=" + bestellingId + " ]";
    }
    
}
