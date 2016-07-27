/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Klant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klant.findAll", query = "SELECT k FROM Klant k"),
    @NamedQuery(name = "Klant.findByKlantId", query = "SELECT k FROM Klant k WHERE k.klantId = :klantId"),
    @NamedQuery(name = "Klant.findByVoornaam", query = "SELECT k FROM Klant k WHERE k.voornaam = :voornaam"),
    @NamedQuery(name = "Klant.findByAchternaam", query = "SELECT k FROM Klant k WHERE k.achternaam = :achternaam"),
    @NamedQuery(name = "Klant.findByTussenvoegsel", query = "SELECT k FROM Klant k WHERE k.tussenvoegsel = :tussenvoegsel"),
    @NamedQuery(name = "Klant.findByEmail", query = "SELECT k FROM Klant k WHERE k.email = :email")})
public class Klant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "klant_id")
    private Integer klantId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "voornaam")
    private String voornaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 51)
    @Column(name = "achternaam")
    private String achternaam;
    @Size(max = 10)
    @Column(name = "tussenvoegsel")
    private String tussenvoegsel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 320)
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "klantId")
    private Collection<Account> accountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klantId")
    private Collection<Bestelling> bestellingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klantId")
    private Collection<Koppelklantadres> koppelklantadresCollection;

    public Klant() {
    }

    public Klant(Integer klantId) {
        this.klantId = klantId;
    }

    public Klant(Integer klantId, String voornaam, String achternaam, String email) {
        this.klantId = klantId;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
    }

    public Integer getKlantId() {
        return klantId;
    }

    public void setKlantId(Integer klantId) {
        this.klantId = klantId;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    @XmlTransient
    public Collection<Bestelling> getBestellingCollection() {
        return bestellingCollection;
    }

    public void setBestellingCollection(Collection<Bestelling> bestellingCollection) {
        this.bestellingCollection = bestellingCollection;
    }

    @XmlTransient
    public Collection<Koppelklantadres> getKoppelklantadresCollection() {
        return koppelklantadresCollection;
    }

    public void setKoppelklantadresCollection(Collection<Koppelklantadres> koppelklantadresCollection) {
        this.koppelklantadresCollection = koppelklantadresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klantId != null ? klantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klant)) {
            return false;
        }
        Klant other = (Klant) object;
        if ((this.klantId == null && other.klantId != null) || (this.klantId != null && !this.klantId.equals(other.klantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Klant[ klantId=" + klantId + " ]";
    }
    
}
