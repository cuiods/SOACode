<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>
    <xsl:key name="groupByCourseId" match="课程成绩" use="concat(@课程编号, ':', @成绩性质)"/>
    <xsl:template match="/">
        <课程成绩列表>
            <xsl:apply-templates select="//课程成绩[count(. | key('groupByCourseId', @课程编号)[1]) = 1]" />
        </课程成绩列表>
    </xsl:template>
    <xsl:template match="课程成绩">
        <课程成绩>
            <xsl:attribute name="成绩性质">
                <xsl:value-of select="@成绩性质" />
            </xsl:attribute>
            <xsl:attribute name="课程编号">
                <xsl:value-of select="@课程编号" />
            </xsl:attribute>
            <xsl:apply-templates select="key('groupByCourseId', concat(@课程编号, ':', @成绩性质))" mode="inner"/>
        </课程成绩>
    </xsl:template>
    <xsl:template match="课程成绩" mode="inner">
        <xsl:for-each select="成绩">
            <成绩>
                <学号><xsl:value-of select="学号" /></学号>
                <得分><xsl:value-of select="得分" /></得分>
            </成绩>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>