<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <课程成绩列表>
            <xsl:for-each select="学生列表/学生/课程成绩列表">
                <课程成绩>
                    <xsl:attribute name="成绩性质">
                        <xsl:value-of select="@成绩性质" />
                    </xsl:attribute>
                    <xsl:attribute name="课程编号">
                        <xsl:value-of select="@课程编号" />
                    </xsl:attribute>
                    <成绩>
                        <学号><xsl:apply-templates select="学号" /></学号>
                        <得分><xsl:apply-templates select="得分" /></得分>
                    </成绩>
                </课程成绩>
            </xsl:for-each>
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
            <成绩>
                <学号><xsl:apply-templates select="学号" /></学号>
                <得分><xsl:apply-templates select="得分" /></得分>
            </成绩>
        </课程成绩>
    </xsl:template>
    <xsl:template match="学号|得分">
        <xsl:value-of select="." />
    </xsl:template>
</xsl:stylesheet>