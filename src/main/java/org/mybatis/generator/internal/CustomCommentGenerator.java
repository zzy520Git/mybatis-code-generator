package org.mybatis.generator.internal;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * Description：
 *
 * @author
 * @date 2020/5/30
 * @ see
 * @since
 */
public class CustomCommentGenerator extends DefaultCommentGenerator {

    @Override
    public void addComment(XmlElement xmlElement) {
    }

    @Override
    public void addFieldComment(Field field,
                                IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (getSuppressAllComments()) {
            return;
        }

        field.addJavaDocLine("/**"); //$NON-NLS-1$

        String remarks = introspectedColumn.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));  //$NON-NLS-1$
            for (String remarkLine : remarkLines) {
                field.addJavaDocLine(" *   " + remarkLine);  //$NON-NLS-1$
            }
        }

        field.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addClassComment(InnerClass innerClass,
                                IntrospectedTable introspectedTable) {
        if (getSuppressAllComments()) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerClass.addJavaDocLine("/**"); //$NON-NLS-1$

        sb.append(" * This class corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());

        innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass,
                                     IntrospectedTable introspectedTable) {
        if (getSuppressAllComments()) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        topLevelClass.addJavaDocLine("/**"); //$NON-NLS-1$

        String remarks = introspectedTable.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            topLevelClass.addJavaDocLine(" * Database Table Remarks:");
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));  //$NON-NLS-1$
            for (String remarkLine : remarkLines) {
                topLevelClass.addJavaDocLine(" *   " + remarkLine);  //$NON-NLS-1$
            }
        }
        topLevelClass.addJavaDocLine(" *"); //$NON-NLS-1$

        sb.append(" * This class corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(sb.toString());

        topLevelClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (getSuppressAllComments()) {
            return;
        }
        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("/**"); //$NON-NLS-1$

        sb.append(" * This field corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        field.addJavaDocLine(sb.toString());

        addJavadocTag(field, false);

        field.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addGeneralMethodComment(Method method,
                                        IntrospectedTable introspectedTable) {
    }

    @Override
    public void addGetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
    }

    public void addSetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
    }
}
