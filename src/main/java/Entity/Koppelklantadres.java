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
@Table(name = "Koppelklantadres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Koppelklantadres.findAll", query = "SELECT k FROM Koppelklantadres k"),
    @NamedQuery(name = "Koppelklantadres.findByKoppelId", query = "SELECT k FROM Koppelklantadres k WHERE k.koppelId = :koppelId"),
    @NamedQuery(name = "Koppelklantadres.findByKlantId", query = "SELECT k FROM Koppelklantadres k WHERE k.klantId = :klantId"),
    @NamedQuery(name = "Koppelklantadres.findByAdresId", query = "SELECT k FROM Koppelklantadres k WHERE k.adresId = :adresId")})
public class Koppelklantadres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "koppel_id")
    private Integer koppelId;
    @JoinColumn(name = "klant_id", referencedColumnName = "klant_id")
    @ManyToOne(optional = false)
    private Klant klantId;
    @JoinColumn(name = "adres_id", referencedColumnName = "adres_id")
    @ManyToOne(optional = false)
    private Adres adresId;

    public Koppelklantadres() {
    }

    public Koppelklantadres(Integer koppelId) {
        this.koppelId = koppelId;
    }

    public Integer getKoppelId() {
        return koppelId;
    }

    public void setKoppelId(Integer koppelId) {
        this.koppelId = koppelId;
    }

    public Klant getKlantId() {
        return klantId;
    }

    public void setKlantId(Klant klantId) {
        this.klantId = klantId;
    }

    public Adres getAdresId() {
        return adresId;
    }

    public void setAdresId(Adres adresId) {
        this.adresId = adresId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (koppelId != null ? koppelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Koppelklantadres)) {
            return false;
        }
        Koppelklantadres other = (Koppelklantadres) object;
        if ((this.koppelId == null && other.koppelId != null) || (this.koppelId != null && !this.koppelId.equals(other.koppelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Koppelklantadres[ koppelId=" + koppelId + " ]";
    }
    
}
