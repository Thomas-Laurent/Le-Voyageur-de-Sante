package client;

import javax.xml.ws.WebServiceRef;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quentin
 */
public class TestCabinetInfirmier {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(getNomCabinet());
        
        System.out.println(getStrLength("test"));
        
    }

    private static String getNomCabinet() {
        fr.ujf_grenoble.l3miage.medical.CabinetInfirmier_Service service = new fr.ujf_grenoble.l3miage.medical.CabinetInfirmier_Service();
        fr.ujf_grenoble.l3miage.medical.CabinetInfirmier port = service.getCabinetInfirmierPort();
        return port.getNomCabinet();
    }

    private static String getListePatientsStr(int id) {
        fr.ujf_grenoble.l3miage.medical.CabinetInfirmier_Service service = new fr.ujf_grenoble.l3miage.medical.CabinetInfirmier_Service();
        fr.ujf_grenoble.l3miage.medical.CabinetInfirmier port = service.getCabinetInfirmierPort();
        return port.getListePatientsStr(id);
    }

    private static int getStrLength(java.lang.String str) {
        fr.ujf_grenoble.l3miage.medical.CabinetInfirmier_Service service = new fr.ujf_grenoble.l3miage.medical.CabinetInfirmier_Service();
        fr.ujf_grenoble.l3miage.medical.CabinetInfirmier port = service.getCabinetInfirmierPort();
        return port.getStrLength(str);
    }

    private static String hello(java.lang.String name) {
        fr.ujf_grenoble.l3miage.medical.CabinetInfirmier_Service service = new fr.ujf_grenoble.l3miage.medical.CabinetInfirmier_Service();
        fr.ujf_grenoble.l3miage.medical.CabinetInfirmier port = service.getCabinetInfirmierPort();
        return port.hello(name);
    }


}
