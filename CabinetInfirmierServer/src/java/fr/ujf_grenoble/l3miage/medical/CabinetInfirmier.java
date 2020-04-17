/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ujf_grenoble.l3miage.medical;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import xml.XMLUtil.DocumentFactory;
import xml.XMLUtil.DocumentTransform;

/**
 *
 * @author Quentin
 */
@WebService(serviceName = "CabinetInfirmier")
public class CabinetInfirmier {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getStrLength")
    public int getStrLength(@WebParam(name = "str") String str) {
        //TODO write your implementation code here:
        return str.length();
    }
        /**
     * Cette méthode : 
     * - récupère le document XML contenant l'organisation complète du cabinet infirmier en tant que ressource du Web Service
     * - réalise un unmarshalling à partir de cette ressource et du JAXB binding produit à partir du XML Schema 
     * - renvoie une référence sur l'instance de Cabinet, racine du système d'information
     *
     * @return racine du document XML (instance de la classe Cabinet)
     */
    private Cabinet fromResource() {
        // déclare un cabinet
        Cabinet cabinet = null;
        try {
            // récupération  de la ressource à partir du fichier XML
            URL cabinetXMLURL = CabinetInfirmier.class.getResource("resources/cabinetInfirmier.xml");

            // création du contexte
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(Cabinet.class.getPackage().getName());

            // création d'un unmarshaller 
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();

            // unmarshalling... (utilisation d'un transtypage)
            cabinet = (Cabinet) unmarshaller.unmarshal(cabinetXMLURL); //NOI18N

        } catch (JAXBException ex) {
            Logger.getLogger(CabinetInfirmier.class.getName()).log(Level.SEVERE, null, ex);
        }
        // retourne une instance de cabinet, ou null si le chargement du fichier a 
        return cabinet;
    }

    /**
     * Cette méthode du WS permet de récupérer une resource distante sous la
     * forme d'un flux source (StreamSource) pouvant être utilisée dans les méthodes de XMLUtil (trandformation XSLT ...).
     *
     * @param resourceFile
     * @return
     */
    private StreamSource fromResource(String resourceFile) {
        // crée un flux d'entrée qui récupère la resource distante comme un flux
        InputStream resourceStream = this.getClass().getResourceAsStream(resourceFile);
        // Retourne ce flux d'entrée sous la forme d'un flux source
        return new StreamSource(resourceStream);
    } 

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNomCabinet")
    public String getNomCabinet() {
        Cabinet cab = fromResource();
        return cab.getNom();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getListePatientsStr")
    public String getListePatientsStr(@WebParam(name = "id") int id) {
        Cabinet cab = fromResource();
        String res = "Patients de l'infirmiere [" + id + "] :\n";
        for(Patient p : cab.getPatients().getPatients()) {
            for(Visite v : p.getVisites()) {
                if(v.getIntervenant() != null && Integer.parseInt(v.getIntervenant()) == id) {
                    res += "[" + p.nom + ", " + p.prenom + "] ";
                }
            }            
        }
        return res;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getHTML")
    public String getHTML() {
        Cabinet cab = fromResource();
        return null;
    }

        /**
     * Cette opération du Web Service permet de récupérer la page HTML de l'infirmier d'identifiant Id.
     * L'instance de cabinet subit un marshalling pour etre transformée en Document DOM. 
     * Avant ou après cette étape (qui peut être remplacée), des traitements (ex: recherche opérationnelle) peuvent être effectués.
     * Le Document subit ensuite une transformation selon une feuille de transformation xsl présente dans les resources.
     * Cette feuile permet une transformation du document DOM en page HTML.
     * 
     * @param infirmierId : numéro (Id) de l'infirmier qui pourra être utilisé.
     * @return String : contenu du fichier HTML.
     */
    @WebMethod(operationName = "getInfirmiere")
    public String getInfirmiere(@WebParam(name = "infirmierId") String infirmierId) {
        try {
            // On récupère une instance de cabinet depuis la resource.
            Cabinet c = fromResource();
            
            // Traitements préliminaires éventuels ... en Java
            /*
            * ici sont réalisés les traitements souhaités pour récupérer les informations utiles
            * ex: classement des patients par ordre alphabétique
            * ex: classement de la liste des patients d'une infirmière selon la distance
            */
            
            // On fabrique un document DOM à partir d'un objet, ici un cabinet
            Document doc = DocumentFactory.fromObject(c);
            
            // On récupère ici la feuille de transformation de l'infirmière
            StreamSource xslSource = fromResource("resources/test.xsl");
            // On fabrique une processeur de document (Transformer)
            Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
            // On donne un nom au paramètre ; ce nom est celui utilisé dans la feuille de transformation
            String id = "idInfirmier";
            // On indique au processeur de document d'appliquer un paramètre auquel on donne sa valeur.
            transformer.setParameter(id, infirmierId);
            // On applique la transformation
            return DocumentTransform.fromTransformation(transformer, doc);
        } catch (TransformerException | JAXBException | ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(CabinetInfirmier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNbInfirmier")
    public int getNbInfirmier() {
        Cabinet cab = fromResource();
        return cab.getInfirmiers().getInfirmiers().size();
    }
}
