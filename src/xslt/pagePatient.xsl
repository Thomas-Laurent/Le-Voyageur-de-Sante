<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : pagePatient.xsl
    Created on : 20 octobre 2019, 22:08
    Author     : matrairq et laurenth
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:ci="http://www.ujf-grenoble.fr/l3miage/medical"
                xmlns:act="http://www.ujf-grenoble.fr/l3miage/actes">
    <xsl:output method="xml" name=".xml"/>
    
    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:param name="destinedName" select="//ci:patient/ci:nom[text() = 'Pien']/parent::node()"/>
    <xsl:variable name="actes" select="document('actes.xml', /)/act:ngap"/>
    <xsl:template match="/">        
        <patient>
            <nom><xsl:value-of select="$destinedName/ci:nom"/></nom>
            <prénom><xsl:value-of select="$destinedName/ci:prénom"/></prénom>
            <sexe><xsl:value-of select="$destinedName/ci:sexe"/></sexe>
            <naissance><xsl:value-of select="$destinedName/ci:naissance"/></naissance>
            <numéroSS><xsl:value-of select="$destinedName/ci:numéro"/></numéroSS>
            <adresse>
                <xsl:if test="$destinedName/ci:adresse/ci:étage != ''">
                    <étage><xsl:value-of select="$destinedName/ci:adresse/ci:étage"/></étage>
                </xsl:if>
                <xsl:if test="$destinedName/ci:adresse/ci:numéro != ''">
                    <numéro><xsl:value-of select="$destinedName/ci:adresse/ci:numéro"/></numéro>
                </xsl:if>
                <rue><xsl:value-of select="$destinedName/ci:adresse/ci:rue"/></rue>
                <codePostal><xsl:value-of select="$destinedName/ci:adresse/ci:codePostal"/></codePostal>
                <ville><xsl:value-of select="$destinedName/ci:adresse/ci:ville"/></ville>
            </adresse>
            <xsl:apply-templates select="$destinedName/ci:visite"/>
            
        </patient>
    </xsl:template>
    
    <xsl:template match="ci:visite">
        <visite>
            <xsl:attribute name="date"><xsl:value-of select="@date"/></xsl:attribute>
            <intervenant>
                <xsl:variable name="intervenant" select="//@intervenant"/>
                <nom><xsl:value-of select="//ci:infirmier[@id = $intervenant]/ci:nom"/></nom>
                <prénom><xsl:value-of select="//ci:infirmier[@id = $intervenant]/ci:prénom"/></prénom>
            </intervenant>
            <xsl:apply-templates select="ci:acte"/>
        </visite>
        
    </xsl:template>
    <xsl:template match="ci:acte">
        <acte>
            <xsl:variable name="id" select="@id"/>
            <xsl:value-of select="$actes/act:actes/act:acte[@id = $id]/text()"/>
        </acte>
    </xsl:template>
</xsl:stylesheet>
