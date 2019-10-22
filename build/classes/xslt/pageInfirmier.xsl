<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : pageInfirmier.xsl
    Created on : 18 octobre 2019, 14:15
    Author     : matrairq
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:ci="http://www.ujf-grenoble.fr/l3miage/medical"
                xmlns:act="http://www.ujf-grenoble.fr/l3miage/actes"
                >
    <xsl:output method="html"/>

    <xsl:param name="destinedId">001</xsl:param>
    <xsl:variable name="actes" select="document('../xml/actes.xml', /)/act:ngap"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>pageInfirmier.xsl</title>
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
                    ]]>
                </script>
            </head>
            <body>
                Bonjour <xsl:value-of select='//ci:infirmier[@id=$destinedId]/ci:nom'/>,<br/>
                Aujourd'hui, vous avez <xsl:value-of select="count(//ci:patient/ci:visite[@intervenant=$destinedId])"/> patients
                <br/>
                
                <ul>
                    <xsl:apply-templates select="//ci:patients/ci:patient">
                        <xsl:sort select="ci:visite/@date"/>
                    </xsl:apply-templates>
                </ul>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="ci:patient">
        <li>
            Nom : <xsl:value-of select="ci:nom"/>&#160;<xsl:value-of select="ci:prénom"/><br/>
            Adresse : <xsl:apply-templates select="ci:adresse"/>
            <ul>
                <xsl:apply-templates select="ci:visite"/>
            </ul>
        </li>
        <input>
            <xsl:attribute name="button"/>
            <xsl:attribute name="value">><
        </input>
        <br/>
    </xsl:template>
    <xsl:template match="ci:adresse">
        <xsl:if test="ci:étage != ''">
            <xsl:value-of select="ci:étage"/><sup>e</sup> étage,
        </xsl:if>
        <xsl:value-of select="ci:numéro"/>&#160;<xsl:value-of select="ci:rue"/>,
        <xsl:value-of select="ci:codePostal"/>&#160;<xsl:value-of select="ci:ville"/>
    </xsl:template>
    
    <xsl:template match="ci:visite" >
        <li>
            <p> Visite du <xsl:value-of select="@date" /></p>
            <ul>
                <xsl:apply-templates select="ci:acte"/>
            </ul>
        </li>
    </xsl:template>
    <xsl:template match="ci:acte" >
        <li>
            <xsl:variable name="id" select="@id"/>
            <xsl:value-of select="$actes/act:actes/act:acte[@id = $id]/text()"/>
            
        </li>
    </xsl:template>

</xsl:stylesheet>
