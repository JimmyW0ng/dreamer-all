package com.dreamer.generator;

import org.jooq.util.*;

/**
 * Created by jimmy on 2017/3/7.
 */
public class CustomJavaGenerator extends JavaGenerator {
    protected void generatePojo(TableDefinition table, JavaWriter out) {
       // generatePojo((Definition) table, out);
    }
//    private void generatePojo(Definition tableOrUDT, JavaWriter out) {
//        final String className = getStrategy().getJavaClassName(tableOrUDT, GeneratorStrategy.Mode.POJO);
//        final String superName = out.ref(getStrategy().getJavaClassExtends(tableOrUDT, GeneratorStrategy.Mode.POJO));
//        final List<String> interfaces = out.ref(getStrategy().getJavaClassImplements(tableOrUDT, GeneratorStrategy.Mode.POJO));
//        final List<String> superTypes = list(superName, interfaces);
//
//        if (generateInterfaces()) {
//            interfaces.add(out.ref(getStrategy().getFullJavaClassName(tableOrUDT, GeneratorStrategy.Mode.INTERFACE)));
//        }
//
//        printPackage(out, tableOrUDT, GeneratorStrategy.Mode.POJO);
//
//        if (tableOrUDT instanceof TableDefinition)
//            generatePojoClassJavadoc((TableDefinition) tableOrUDT, out);
//        else
//            generateUDTPojoClassJavadoc((UDTDefinition) tableOrUDT, out);
//
//        printClassAnnotations(out, tableOrUDT.getSchema());
//
//        if (tableOrUDT instanceof TableDefinition)
//            printTableJPAAnnotation(out, (TableDefinition) tableOrUDT);
//
//        int maxLength = 0;
//        for (TypedElementDefinition<?> column : getTypedElements(tableOrUDT)) {
//            maxLength = Math.max(maxLength, out.ref(getJavaType(column.getType(), GeneratorStrategy.Mode.POJO)).length());
//        }
//
//        if (scala) {
//            out.println("%sclass %s(", (generateImmutablePojos() ? "case " : ""), className);
//
//            String separator = "  ";
//            for (TypedElementDefinition<?> column : getTypedElements(tableOrUDT)) {
//                out.tab(1).println("%s%s%s : %s",
//                        separator,
//                        generateImmutablePojos() ? "" : "private var ",
//                        getStrategy().getJavaMemberName(column, GeneratorStrategy.Mode.POJO),
//                        StringUtils.rightPad(out.ref(getJavaType(column.getType(), GeneratorStrategy.Mode.POJO)), maxLength));
//
//                separator = ", ";
//            }
//
//            out.println(")[[before= extends ][%s]][[before= with ][separator= with ][%s]] {", first(superTypes), remaining(superTypes));
//        }
//        else {
//            out.println("public class %s[[before= extends ][%s]][[before= implements ][%s]] {", className, list(superName), interfaces);
//            out.printSerial();
//            out.println();
//
//            for (TypedElementDefinition<?> column : getTypedElements(tableOrUDT)) {
//                out.tab(1).println("private %s%s %s;",
//                        generateImmutablePojos() ? "final " : "",
//                        StringUtils.rightPad(out.ref(getJavaType(column.getType(), GeneratorStrategy.Mode.POJO)), maxLength),
//                        getStrategy().getJavaMemberName(column, GeneratorStrategy.Mode.POJO));
//            }
//        }
//
//        // Constructors
//        // ---------------------------------------------------------------------
//
//        // Default constructor
//        if (!generateImmutablePojos()) {
//            out.println();
//
//            if (scala) {
//
//                // [#3010] Invalid UDTs may have no attributes. Avoid generating this constructor in that case
//                int size = getTypedElements(tableOrUDT).size();
//                if (size > 0) {
//                    List<String> nulls = new ArrayList<String>();
//                    for (TypedElementDefinition<?> column : getTypedElements(tableOrUDT))
//
//                        // Avoid ambiguities between a single-T-value constructor
//                        // and the copy constructor
//                        if (size == 1)
//                            nulls.add("null : " + out.ref(getJavaType(column.getType(), GeneratorStrategy.Mode.POJO)));
//                        else
//                            nulls.add("null");
//
//                    out.tab(1).println("def this() = {", className);
//                    out.tab(2).println("this([[%s]])", nulls);
//                    out.tab(1).println("}");
//                }
//            }
//            else {
//                out.tab(1).println("public %s() {}", className);
//            }
//        }
//
//        // [#1363] copy constructor
//        out.println();
//
//        if (scala) {
//            out.tab(1).println("def this (value : %s) = {", className, className);
//            out.tab(2).println("this(");
//
//            String separator = "  ";
//            for (TypedElementDefinition<?> column : getTypedElements(tableOrUDT)) {
//                out.tab(3).println("%svalue.%s",
//                        separator,
//                        getStrategy().getJavaMemberName(column, GeneratorStrategy.Mode.POJO),
//                        getStrategy().getJavaMemberName(column, GeneratorStrategy.Mode.POJO));
//
//                separator = ", ";
//            }
//
//            out.tab(2).println(")");
//            out.tab(1).println("}");
//        }
//        else {
//            out.tab(1).println("public %s(%s value) {", className, className);
//
//            for (TypedElementDefinition<?> column : getTypedElements(tableOrUDT)) {
//                out.tab(2).println("this.%s = value.%s;",
//                        getStrategy().getJavaMemberName(column, GeneratorStrategy.Mode.POJO),
//                        getStrategy().getJavaMemberName(column, GeneratorStrategy.Mode.POJO));
//            }
//
//            out.tab(1).println("}");
//        }
//
//        // Multi-constructor
//
//        if (scala) {
//        }
//
//        // [#3010] Invalid UDTs may have no attributes. Avoid generating this constructor in that case
//        // [#3176] Avoid generating constructors for tables with more than 255 columns (Java's method argument limit)
//        else if (getTypedElements(tableOrUDT).size() > 0 &&
//                getTypedElements(tableOrUDT).size() < 256) {
//            out.println();
//            out.tab(1).print("public %s(", className);
//
//            String separator1 = "";
//            for (TypedElementDefinition<?> column : getTypedElements(tableOrUDT)) {
//                out.println(separator1);
//
//                out.tab(2).print("%s %s",
//                        StringUtils.rightPad(out.ref(getJavaType(column.getType(), GeneratorStrategy.Mode.POJO)), maxLength),
//                        getStrategy().getJavaMemberName(column, GeneratorStrategy.Mode.POJO));
//                separator1 = ",";
//            }
//
//            out.println();
//            out.tab(1).println(") {");
//
//            for (TypedElementDefinition<?> column : getTypedElements(tableOrUDT)) {
//                final String columnMember = getStrategy().getJavaMemberName(column, GeneratorStrategy.Mode.POJO);
//
//                out.tab(2).println("this.%s = %s;", columnMember, columnMember);
//            }
//
//            out.tab(1).println("}");
//        }
//
//        for (TypedElementDefinition<?> column : getTypedElements(tableOrUDT)) {
//            final String columnType = out.ref(getJavaType(column.getType(), GeneratorStrategy.Mode.POJO));
//            final String columnSetterReturnType = fluentSetters() ? className : (scala ? "Unit" : "void");
//            final String columnSetter = getStrategy().getJavaSetterName(column, GeneratorStrategy.Mode.POJO);
//            final String columnGetter = getStrategy().getJavaGetterName(column, GeneratorStrategy.Mode.POJO);
//            final String columnMember = getStrategy().getJavaMemberName(column, GeneratorStrategy.Mode.POJO);
//            final boolean isUDT = column.getType().isUDT();
//            final boolean isUDTArray = column.getType().isArray() && database.getArray(column.getType().getSchema(), column.getType().getUserType()).getElementType().isUDT();
//
//            // Getter
//            out.println();
//
//            if (column instanceof ColumnDefinition)
//                printColumnJPAAnnotation(out, (ColumnDefinition) column);
//
//            printValidationAnnotation(out, column);
//
//            if (scala) {
//                out.tab(1).println("def %s : %s = {", columnGetter, columnType);
//                out.tab(2).println("this.%s", columnMember);
//                out.tab(1).println("}");
//            }
//            else {
//                out.tab(1).overrideIf(generateInterfaces());
//                out.tab(1).println("public %s %s() {", columnType, columnGetter);
//                out.tab(2).println("return this.%s;", columnMember);
//                out.tab(1).println("}");
//            }
//
//            // Setter
//            if (!generateImmutablePojos()) {
//
//                // We cannot have covariant setters for arrays because of type erasure
//                if (!(generateInterfaces() && isUDTArray)) {
//                    out.println();
//
//                    if (scala) {
//                        out.tab(1).println("def %s(%s : %s) : %s = {", columnSetter, columnMember, columnType, columnSetterReturnType);
//                        out.tab(2).println("this.%s = %s", columnMember, columnMember);
//                        if (fluentSetters())
//                            out.tab(2).println("this");
//                        out.tab(1).println("}");
//                    }
//                    else {
//                        out.tab(1).overrideIf(generateInterfaces() && !isUDT);
//                        out.tab(1).println("public %s %s(%s %s) {", columnSetterReturnType, columnSetter, columnType, columnMember);
//                        out.tab(2).println("this.%s = %s;", columnMember, columnMember);
//                        if (fluentSetters())
//                            out.tab(2).println("return this;");
//                        out.tab(1).println("}");
//                    }
//                }
//
//                // [#3117] To avoid covariant setters on POJOs, we need to generate two setter overloads
//                if (generateInterfaces() && (isUDT || isUDTArray)) {
//                    final String columnTypeInterface = out.ref(getJavaType(column.getType(), GeneratorStrategy.Mode.INTERFACE));
//
//                    out.println();
//
//                    if (scala) {
//                        // [#3082] TODO Handle <interfaces/> + ARRAY also for Scala
//
//                        out.tab(1).println("def %s(%s : %s) : %s = {", columnSetter, columnMember, columnTypeInterface, columnSetterReturnType);
//                        out.tab(2).println("if (%s == null)", columnMember);
//                        out.tab(3).println("this.%s = null", columnMember);
//                        out.tab(2).println("else");
//                        out.tab(3).println("this.%s = %s.into(new %s)", columnMember, columnMember, columnType);
//
//                        if (fluentSetters())
//                            out.tab(2).println("this");
//
//                        out.tab(1).println("}");
//                    }
//                    else {
//                        out.tab(1).override();
//                        out.tab(1).println("public %s %s(%s %s) {", columnSetterReturnType, columnSetter, columnTypeInterface, columnMember);
//                        out.tab(2).println("if (%s == null)", columnMember);
//                        out.tab(3).println("this.%s = null;", columnMember);
//
//                        if (isUDT) {
//                            out.tab(2).println("else");
//                            out.tab(3).println("this.%s = %s.into(new %s());", columnMember, columnMember, columnType);
//                        }
//                        else if (isUDTArray) {
//                            final ArrayDefinition array = database.getArray(column.getType().getSchema(), column.getType().getUserType());
//                            final String componentType = out.ref(getJavaType(array.getElementType(), GeneratorStrategy.Mode.POJO));
//                            final String componentTypeInterface = out.ref(getJavaType(array.getElementType(), GeneratorStrategy.Mode.INTERFACE));
//
//                            out.tab(2).println("else {");
//                            out.tab(3).println("this.%s = new %s();", columnMember, ArrayList.class);
//                            out.println();
//                            out.tab(3).println("for (%s i : %s)", componentTypeInterface, columnMember);
//                            out.tab(4).println("this.%s.add(i.into(new %s()));", columnMember, componentType);
//                            out.tab(2).println("}");
//                        }
//
//                        if (fluentSetters())
//                            out.tab(2).println("return this;");
//
//                        out.tab(1).println("}");
//                    }
//                }
//            }
//        }
//
//        if (generatePojosEqualsAndHashCode()) {
//            generatePojoEqualsAndHashCode(tableOrUDT, out);
//        }
//
//        if (generatePojosToString()) {
//            generatePojoToString(tableOrUDT, out);
//        }
//
//        if (generateInterfaces() && !generateImmutablePojos()) {
//            printFromAndInto(out, tableOrUDT);
//        }
//
//        if (tableOrUDT instanceof TableDefinition)
//            generatePojoClassFooter((TableDefinition) tableOrUDT, out);
//        else
//            generateUDTPojoClassFooter((UDTDefinition) tableOrUDT, out);
//
//        out.println("}");
//        closeJavaWriter(out);
//    }
}
