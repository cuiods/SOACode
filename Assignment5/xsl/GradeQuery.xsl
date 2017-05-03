<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:jw="http://jw.nju.edu.cn/schema" >

    <xsl:output method="xml" indent="yes"/>
    
    <xsl:param name="sid"/>

    <xsl:template match="/">
        <soap:Envelope
                xmlns:soap="http://www.w3.org/2001/12/soap-envelope"
                soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
            <soap:body>
                <xsl:choose>
                    <xsl:when test="count(//jw:学号[text()=$sid]) = 0">
                        <soap:Fault>
                            <soap:falutcode>soap:Server</soap:falutcode>
                            <soap:faultstring>Cannot find any score for student id:<xsl:value-of select="$sid"/></soap:faultstring>
                        </soap:Fault>
                    </xsl:when>
                    <xsl:otherwise>
                        <jw:课程成绩列表>
                            <xsl:apply-templates select="//jw:学号[text()=$sid]"/>
                        </jw:课程成绩列表>
                    </xsl:otherwise>
                </xsl:choose>
            </soap:body>
        </soap:Envelope>
    </xsl:template>

    <xsl:template match="//jw:学号[text()=$sid]">
        <jw:课程成绩>
            <xsl:attribute name="成绩性质">
                <xsl:value-of select="../../@成绩性质"/>
            </xsl:attribute>
            <xsl:attribute name="课程编号">
                <xsl:value-of select="../../@课程编号" />
            </xsl:attribute>
            <jw:成绩>
                <jw:学号>
                    <xsl:value-of select="$sid"/>
                </jw:学号>
                <jw:得分>
                    <xsl:value-of select="../jw:得分"/>
                </jw:得分>
            </jw:成绩>
        </jw:课程成绩>
    </xsl:template>

</xsl:stylesheet>