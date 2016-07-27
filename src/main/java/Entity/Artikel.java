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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "Artikel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artikel.findAll", query = "SELECT a FROM Artikel a"),
    @NamedQuery(name = "Artikel.findByArtikelId", query = "SELECT a FROM Artikel a WHERE a.artikelId = :artikelId"),
    @NamedQuery(name = "Artikel.findByArtikelNaam", query = "SELECT a FROM Artikel a WHERE a.artikelNaam = :artikelNaam"),
    @NamedQuery(name = "Artikel.findByArtikelVoorraad", query = "SELECT a FROM Artikel a WHERE a.artikelVoorraad = :artikelVoorraad"),
    @NamedQuery(name = "Artikel.findByArtikelPrijs", query = "SELECT a FROM Artikel a WHERE a.artikelPrijs = :artikelPrijs")})
public class Artikel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "artikel_id")
    private Integer artikelId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "artikel_naam")
    private String artikelNaam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "artikel_voorraad")
    private int artikelVoorraad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "artikel_prijs")
    private BigDecimal artikelPrijs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikelId")
    private Collection<Bestellingartikel> bestellingartikelCollection;

    public Artikel() {
    }

    public Artikel(Integer artikelId) {
        this.artikelId = artikelId;
    }

    public Artikel(Integer artikelId, String artikelNaam, int artikelVoorraad) {
        this.artikelId = artikelId;
        this.artikelNaam = artikelNaam;
        this.artikelVoorraad = artikelVoorraad;
    }

    public Integer getArtikelId() {
        return artikelId;
    }

    public void setArtikelId(Integer artikelId) {
        this.artikelId = artikelId;
    }

    public String getArtikelNaam() {
        return artikelNaam;
    }

    public void setArtikelNaam(String artikelNaam) {
        this.artikelNaam = artikelNaam;
    }

    public int getArtikelVoorraad() {
        return artikelVoorraad;
    }

    public void setArtikelVoorraad(int artikelVoorraad) {
        this.artikelVoorraad = artikelVoorraad;
    }

    public BigDecimal getArtikelPrijs() {
        return artikelPrijs;
    }

    public void setArtikelPrijs(BigDecimal artikelPrijs) {
        this.artikelPrijs = artikelPrijs;
    }

    @XmlTransient
    public Collection<Bestellingartikel> getBestellingartikelCollection() {
        return bestellingartikelCollection;
    }

    public void setBestellingartikelCollection(Collection<Bestellingartikel> bestellingartikelCollection) {
        this.bestellingartikelCollection = bestellingartikelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artikelId != null ? artikelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artikel)) {
            return false;
        }
        Artikel other = (Artikel) object;
        if ((this.artikelId == null && other.artikelId != null) || (this.artikelId != null && !this.artikelId.equals(other.artikelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Artikel[ artikelId=" + artikelId + " ]";
    }
    
}
