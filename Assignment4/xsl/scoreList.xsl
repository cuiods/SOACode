<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:nju="http://jw.nju.edu.cn/schema" >

    <xsl:output method="xml" indent="yes"/>

    <xsl:key name="groupByCourseId" match="nju:课程成绩" use="concat(@课程编号, ':', @成绩性质)"/>

    <xsl:template match="/">
        <课程成绩列表 xmlns="http://jw.nju.edu.cn/schema">
            <xsl:apply-templates select="//nju:课程成绩[count(. | key('groupByCourseId', @课程编号)[1]) = 1]" />
        </课程成绩列表>
    </xsl:template>

    <xsl:template match="nju:课程成绩">
        <课程成绩>
            <xsl:attribute name="成绩性质">
                <xsl:value-of select="@成绩性质" />
            </xsl:attribute>
            <xsl:attribute name="课程编号">
                <xsl:value-of select="@课程编号" />
            </xsl:attribute>
            <xsl:apply-templates select="key('groupByCourseId', concat(@课程编号, ':', @成绩性质))" mode="inner" >
                <xsl:sort select="nju:成绩/nju:得分" data-type="number" order="descending" />
            </xsl:apply-templates>
        </课程成绩>
    </xsl:template>

    <xsl:template match="nju:课程成绩" mode="inner">
        <xsl:for-each select="nju:成绩">
            <!--<xsl:copy-of select="." />-->
            <成绩>
                <学号><xsl:value-of select="nju:学号" /></学号>
                <得分><xsl:value-of select="nju:得分" /></得分>
            </成绩>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>