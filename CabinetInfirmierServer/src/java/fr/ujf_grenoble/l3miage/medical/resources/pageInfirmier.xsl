<?xml version="1.1" encoding="UTF-8" ?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns="http://www.ujf-grenoble.fr/l3miage/medical"
                xmlns:act="http://www.ujf-grenoble.fr/l3miage/actes" >
    <xsl:output method="html"/>

    <xsl:param name="idInfirmier" select="001"/>
    <xsl:variable name="visiteDuJour" select="//patient/visite[@intervenant=$idInfirmier]"/>
    <xsl:variable name="actes" select="document('./actes.xml', /)/act:ngap"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Profil de <xsl:value-of select='//infirmier[@id=$idInfirmier]/nom'/></title>
                
                <link>
                    <xsl:attribute name="href">./css/pageInfirmier.css</xsl:attribute>
                    <xsl:attribute name="type">text/css</xsl:attribute>
                    <xsl:attribute name="rel">stylesheet</xsl:attribute>
                </link>
                <script type="text/javascript">
                    <![CDATA[
                    function openFacture(prenom, nom, actes) {
                        var width  = 500;
                        var height = 300;
                        if(window.innerWidth) {
                            var left = (window.innerWidth-width)/2;
                            var top = (window.innerHeight-height)/2;
                        }
                        else {
                            var left = (document.body.clientWidth-width)/2;
                            var top = (document.body.clientHeight-height)/2;
                        }
                        var factureWindow = window.open('','facture','menubar=yes, scrollbars=yes, top='+top+', left='+left+', width='+width+', height='+height+'');
                        factureText = "Facture pour : " + prenom + " " + nom;
                        factureWindow.document.write(factureText);
                    }
                    function avant(image){
                        image.setAttribute('src', './css/infirmiere2.png');
                    }
                    function apres(image){
                        image.setAttribute('src', './css/infirmiere1.png');
                    }
                    ]]>
                </script>
            </head>
            <body>
                <img> 
                    <xsl:attribute name="src">./css/infirmiere1.png</xsl:attribute>
                    <xsl:attribute name="alt">Image d'Infirmière</xsl:attribute>
                    <xsl:attribute name="onmouseover">avant(this)</xsl:attribute>
                    <xsl:attribute name="onmouseout">apres(this)</xsl:attribute>
                </img>
                    Bonjour <xsl:value-of select='//infirmier[@id=$idInfirmier]/nom'/>,<br/>
                Aujourd'hui, vous avez <xsl:value-of select="count($visiteDuJour)"/> patients
                <br/>

                <ul>
                    <xsl:apply-templates select="$visiteDuJour/..">
                        <xsl:sort select="visite/@date"/>
                    </xsl:apply-templates>
                </ul>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="patient">
        <li>
            Nom : <xsl:value-of select="nom"/>&#160;<xsl:value-of select="prenom"/><br/>
            Adresse : <xsl:apply-templates select="adresse"/>
            <ul>
                <xsl:apply-templates select="visite"/>
            </ul>
        </li>
        <input>
            <xsl:attribute name="type">button</xsl:attribute>
            <xsl:attribute name="value">Facture</xsl:attribute>
            <xsl:attribute name="onclick">
                openFacture('<xsl:value-of select="prenom"/>',
                            '<xsl:value-of select="nom"/>',
                            '<xsl:value-of select="visite/acte/@id"/>')
            </xsl:attribute>
        </input>
        <br/><br/>
    </xsl:template>
    <xsl:template match="adresse">
        <xsl:if test="etage != ''">
            <xsl:value-of select="étage"/><sup>e</sup> étage,
        </xsl:if>
        <xsl:value-of select="numero"/>&#160;<xsl:value-of select="rue"/>,
        <xsl:value-of select="codePostal"/>&#160;<xsl:value-of select="ville"/>
    </xsl:template>

    <xsl:template match="visite" >
        <li>
            <p> Visite du <xsl:value-of select="@date" /></p>
            <ul>
                <xsl:apply-templates select="acte"/>
            </ul>
        </li>
    </xsl:template>
    <xsl:template match="acte" >
        <li>
            <xsl:variable name="id" select="@id"/>
            <xsl:value-of select="$actes/act:actes/act:acte[@id = $id]"/>

        </li>
    </xsl:template>

</xsl:stylesheet>
