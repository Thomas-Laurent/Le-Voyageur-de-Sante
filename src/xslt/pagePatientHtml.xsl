<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : pagePatientHtml.xsl
    Created on : 21 octobre 2019, 17:57
    Author     : matrairq
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    
    <xsl:template match="/">
        <html>
            <head>
                <title><xsl:value-of select="/patient/nom"/></title>
                <link>
                    <xsl:attribute name="href">pagePatient.css</xsl:attribute>
                    <xsl:attribute name="type">text/css</xsl:attribute>
                    <xsl:attribute name="rel">stylesheet</xsl:attribute>
                </link>
            </head>
            <body>
                <h1>
                    <xsl:value-of select="/patient/nom"/>
                    <br/>
                    <xsl:value-of select="/patient/prénom"/>
                    <br/>
                    <xsl:value-of select="/patient/sexe"/>
                    <br/>
                    <xsl:value-of select="/patient/naissance"/>
                    <br/>
                    <xsl:value-of select="/patient/numéroSS"/>
                    <br/>
                </h1>
                <h2>
                    <xsl:value-of select="/patient/adresse"/><br/>
                </h2>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
