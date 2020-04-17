//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.04.17 à 12:08:05 AM CEST 
//


package fr.ujf_grenoble.l3miage.medical;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour Patient complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Patient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nom" type="{http://www.ujf-grenoble.fr/l3miage/medical}NomPropre"/>
 *         &lt;element name="prenom" type="{http://www.ujf-grenoble.fr/l3miage/medical}NomPropre"/>
 *         &lt;element name="sexe" type="{http://www.ujf-grenoble.fr/l3miage/medical}Sexe"/>
 *         &lt;element name="naissance" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="numero" type="{http://www.ujf-grenoble.fr/l3miage/medical}NumSecu"/>
 *         &lt;element name="adresse" type="{http://www.ujf-grenoble.fr/l3miage/medical}Adresse"/>
 *         &lt;element name="visite" type="{http://www.ujf-grenoble.fr/l3miage/medical}Visite" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Patient", propOrder = {
    "nom",
    "prenom",
    "sexe",
    "naissance",
    "numero",
    "adresse",
    "visites"
})
public class Patient {

    @XmlElement(required = true)
    protected String nom;
    @XmlElement(required = true)
    protected String prenom;
    @XmlElement(required = true)
    protected String sexe;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar naissance;
    @XmlElement(required = true)
    protected String numero;
    @XmlElement(required = true)
    protected Adresse adresse;
    @XmlElement(name = "visite")
    protected List<Visite> visites;

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Obtient la valeur de la propriété prenom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit la valeur de la propriété prenom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * Obtient la valeur de la propriété sexe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * Définit la valeur de la propriété sexe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexe(String value) {
        this.sexe = value;
    }

    /**
     * Obtient la valeur de la propriété naissance.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNaissance() {
        return naissance;
    }

    /**
     * Définit la valeur de la propriété naissance.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNaissance(XMLGregorianCalendar value) {
        this.naissance = value;
    }

    /**
     * Obtient la valeur de la propriété numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Définit la valeur de la propriété numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtient la valeur de la propriété adresse.
     * 
     * @return
     *     possible object is
     *     {@link Adresse }
     *     
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Définit la valeur de la propriété adresse.
     * 
     * @param value
     *     allowed object is
     *     {@link Adresse }
     *     
     */
    public void setAdresse(Adresse value) {
        this.adresse = value;
    }

    /**
     * Gets the value of the visites property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the visites property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVisites().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Visite }
     * 
     * 
     */
    public List<Visite> getVisites() {
        if (visites == null) {
            visites = new ArrayList<Visite>();
        }
        return this.visites;
    }

}
