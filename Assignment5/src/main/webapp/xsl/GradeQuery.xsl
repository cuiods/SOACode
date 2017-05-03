<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:jw="http://jw.nju.edu.cn/schema" >

    <xsl:output method="xml" indent="yes"/>
    
    <xsl:param name="sid"/>

    <xsl:template match="/">
        <env:Envelope
                xmlns:env="http://www.w3.org/2003/05/soap-envelope"
                xmlns:my="http://www.example.com/">
            <env:body>
                <xsl:choose>
                    <xsl:when test="count(//jw:学号[text()=$sid]) = 0">
                        <env:Fault>
                            <env:Code>
                                <env:Value>env:Receiver</env:Value>
                                <env:Subcode>
                                    <env:Value>my:bad argument</env:Value>
                                </env:Subcode>
                            </env:Code>
                            <env:Reason>
                                <env:Text xml:lang="en">no such sid found in score list:<xsl:value-of select="$sid"/></env:Text>
                                <env:Text xml:lang="zh">成绩单中无此学号：<xsl:value-of select="$sid"/></env:Text>
                            </env:Reason>
                            <env:Detail>
                                <my:adivce>请确认输入的学号为9位，且合法。</my:adivce>
                            </env:Detail>
                        </env:Fault>
                    </xsl:when>
                    <xsl:otherwise>
                        <jw:课程成绩列表>
                            <xsl:apply-templates select="//jw:学号[text()=$sid]"/>
                        </jw:课程成绩列表>
                    </xsl:otherwise>
                </xsl:choose>
            </env:body>
        </env:Envelope>
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