//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2020.04.17 � 06:51:40 PM CEST 
//


package fr.ujf_grenoble.l3miage.medical;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Infirmier complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Infirmier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nom" type="{http://www.ujf-grenoble.fr/l3miage/medical}NomPropre"/>
 *         &lt;element name="prenom" type="{http://www.ujf-grenoble.fr/l3miage/medical}NomPropre"/>
 *         &lt;element name="photo" type="{http://www.ujf-grenoble.fr/l3miage/medical}Photo"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.ujf-grenoble.fr/l3miage/medical}Id" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Infirmier", propOrder = {
    "nom",
    "prenom",
    "photo"
})
public class Infirmier {

    @XmlElement(required = true)
    protected String nom;
    @XmlElement(required = true)
    protected String prenom;
    @XmlElement(required = true)
    protected String photo;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Obtient la valeur de la propri�t� nom.
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
     * D�finit la valeur de la propri�t� nom.
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
     * Obtient la valeur de la propri�t� prenom.
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
     * D�finit la valeur de la propri�t� prenom.
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
     * Obtient la valeur de la propri�t� photo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * D�finit la valeur de la propri�t� photo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoto(String value) {
        this.photo = value;
    }

    /**
     * Obtient la valeur de la propri�t� id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * D�finit la valeur de la propri�t� id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
