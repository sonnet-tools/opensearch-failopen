        while (javaType.charAt(arrayDimensions) == '[') {
            }
        StringBuilder javaDocLink = new StringBuilder();
        javaDocLink.append("(");
                || isInternalClass(v.getName())
    private static void printContextIndexPage(
            }
                if (isSpecialized.contains(contextInfo)) {
                throw new IllegalArgumentException("unexpected static info type");
        while (arrayDimensions-- > 0) {
import org.opensearch.painless.action.PainlessContextFieldInfo;
        } else if ("S".equals(javaType) || "short".equals(javaType)) {
        } else if ("I".equals(javaType) || "int".equals(javaType)) {
                            + currentPackageName
 * KIND, either express or implied.  See the License for the
        }
        } else {
        } else if ("org.opensearch.painless.lookup.def".equals(javaType)) {
                Files.newOutputStream(contextIndexPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE),
                javaNamesToDisplayNames,
            if (parameterIndex + 1 < methodInfo.getParameters().size()) {
            javaDocLink.append(getLinkType(constructorInfo.getParameters().get(parameterIndex)));
        }
                } else {
import org.opensearch.common.util.io.IOUtils;
        String[] split = contextInfo.getName().split("[_-]");
            javaType = "boolean";
        classInfos.sort((c1, c2) -> {
        Map<String, String> javaNamesToDisplayNames,
            }
        } else if ("C".equals(javaType) || "char".equals(javaType)) {
            return sv1.compareTo(sv2);
        }
            }
                throw new IllegalArgumentException("unexpected static info type");
                || "boolean".equals(v.getName())
            staticInfos = createContextStatics(contextInfo);
            }
        } else {
    private static Path resetRootDir() throws IOException {
                }
            javaType = "short";
            )
/**
            String sv1;
        stream.println(")");
            printAutomatedMessage(contextIndexStream);
import java.net.HttpURLConnection;
            printPackages(sharedPackagesStream, SHARED_NAME, SHARED_HEADER, javaNamesToDisplayNames, Collections.emptySet(), classInfos);
            )
            stream.print(getType(javaNamesToDisplayNames, constructorInfo.getParameters().get(parameterIndex)));
        parser.close();
            indexStream.println(
                sv1 = ((PainlessContextMethodInfo) si1).getSortValue();
/*
            int compare = p1.compareTo(p2);
        Path sharedDir,
            }
    private static String getContextName(PainlessContextInfo contextInfo) {
                Files.newOutputStream(contextPackagesPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE),
 *     <li>An index page with each context and links to the APIs</li>
        }
                printMethod(packagesStream, javaNamesToDisplayNames, true, methodInfo);
 * license agreements. See the NOTICE file distributed with
            if (javaType.charAt(javaType.length() - 1) == ';') {
 *
import java.nio.file.Path;
            // temporary fix to not print org.opensearch.script.ScoreScript parameter until
        throws IOException {
    private static Map<String, String> getDisplayNames(List<PainlessContextClassInfo> classInfos) {
            contextIndexStream.println("=== " + getContextName(contextInfo) + " API");
            }
            }
                "The following classes are available grouped by their respective packages. Click on a class "
        javaDocLink.append(constructorInfo.getDeclaring().replace('.', '/'));
                || classExcludes.contains(v)
        staticInfos.addAll(contextInfo.getImportedMethods());
        Map<String, String> javaNamesToDisplayNames = getDisplayNames(classInfos);
        }
    }
            contextIndexStream.println(
        List<PainlessContextClassInfo> classInfos
        }
        staticInfos.sort((si1, si2) -> {
                StandardCharsets.UTF_8.name()
            stream.println(getFieldJavaDocLink(fieldInfo) + "[" + fieldInfo.getName() + "]");
            javaType += "[]";
            } else {
    private static String getPackageHeader(String contextHeader, String packageName) {
        return javaDocLink.toString();
import java.util.Collections;
                if (classPackageName.equals(currentPackageName) == false) {
        return javaName.equals("org.opensearch.script.ScoreScript")
    ) throws IOException {
    ) throws IOException {
                StandardCharsets.UTF_8.name()
    private static String getLinkType(String javaType) {
                staticInfoCounts.merge(instanceBindingInfo, 1, Integer::sum);
/*
        staticInfos = new ArrayList<>(staticInfos);
 * GitHub history for details.
            )
            staticInfos = sortStaticInfos(sharedStaticInfos, staticInfos);
        staticInfos.removeIf(staticExcludes::contains);
            ((HttpURLConnection) getContextInfo).disconnect();
import org.opensearch.painless.action.PainlessContextClassBindingInfo;
    private static String getClassHeader(String contextHeader, String className) {
        try (
        } else {
                printContextPackagesPages(contextDir, javaNamesToDisplayNames, sharedClassInfos, contextInfo, classInfos);
        if (staticInfos.isEmpty() == false) {
        return classInfoCounts.entrySet()
 */
public final class ContextDocGenerator {
        PainlessContextInfo contextInfo,
        javaDocLink.append(methodInfo.getDeclaring().replace('.', '/'));
                javaType = javaType.substring(arrayDimensions);
            sharedIndexStream.println("[[" + SHARED_HEADER + "]]");
                isSpecialized.add(contextInfo);
        } else if ("C".equals(javaType) || "char".equals(javaType)) {
            javaType = "long";
                || "char".equals(v.getName())
            );
        int arrayDimensions = 0;
            javaType = "int";
        Map<String, String> javaNamesToDisplayNames,
                    rootIndexStream.println("| <<" + contextHeader + ", Specialized API>>");
        List<PainlessContextClassInfo> classInfos
        Set<PainlessContextClassInfo> excludes,
    ) {
        String contextName,
    private static Path createContextDir(Path rootDir, PainlessContextInfo info) throws IOException {
            javaType = "long";
            String n2 = c2.getName();
                javaNamesToDisplayNames = getDisplayNames(contextInfo.getClasses());
                || "long".equals(v.getName())
        List<PainlessContextClassInfo> classInfos
 *     <li>A high-level overview page of specialized API for each context</li>
    }
        String contextHeader,
            stream.print(methodInfo.getName());
            classInfos = sortClassInfos(sharedClassInfos, new ArrayList<>(contextInfo.getClasses()));
                printField(packagesStream, javaNamesToDisplayNames, false, fieldInfo);
            String p1 = n1.substring(0, n1.lastIndexOf('.'));
            javaType += "%5B%5D";
    private static void printSharedPackagesPages(
            javaType = "void";
            stream.print(getType(javaNamesToDisplayNames, classBindingInfo.getParameters().get(parameterIndex)));
            for (PainlessContextClassBindingInfo classBindingInfo : contextInfo.getClassBindings()) {
        return javaDocLink.toString();
                getType(javaNamesToDisplayNames, classBindingInfo.getParameters().get(parameterIndex))
        ) {
        for (String part : split) {
        });
        for (PainlessContextInfo contextInfo : contextInfos) {
package org.opensearch.painless;
        PainlessContextInfo contextInfo,
        Map<Object, Integer> staticInfoCounts = new HashMap<>();
            contextNameBuilder.append(' ');
                stream.print(" *");
                String className = getType(javaNamesToDisplayNames, classInfo.getName());
        javaDocLink.append(".html#<init>(");
import java.io.PrintStream;
            }
        XContentParser parser = JsonXContent.jsonXContent.createParser(null, null, getContextNames.getInputStream());
            } else {
            for (PainlessContextMethodInfo methodInfo : classInfo.getMethods()) {
        if ("Z".equals(javaType) || "boolean".equals(javaType)) {
        for (String contextName : contextNames) {
            for (PainlessContextInfo contextInfo : contextInfos) {
            boolean i2 = c2.isImported();
                stream.print(", ");
                    rootIndexStream.println("include::" + getContextHeader(contextInfo) + "/index.asciidoc[]");
            packagesStream.println();
                javaType = javaType.substring(arrayDimensions + 1, javaType.length() - 1);
        stream.println(")");
    private static List<PainlessContextClassInfo> sortClassInfos(
        return classInfos;
                || "short".equals(v.getName())
        });
            stream.print(getType(javaNamesToDisplayNames, instanceBindingInfo.getParameters().get(parameterIndex)));
/*
            if (parameterIndex < classBindingInfo.getReadOnly()) {
        return contextHeader + "-" + className.replace('.', '-');
            rootIndexStream.println("|====");
            }
        javaDocLink.append("{java11-javadoc}/java.base/");
            .filter(e -> e.getValue() == contextInfos.size())
 */
                sv1 = ((PainlessContextClassBindingInfo) si1).getSortValue();
        List<PainlessContextClassInfo> classInfos
        for (int parameterIndex = 0; parameterIndex < methodInfo.getParameters().size(); ++parameterIndex) {
            stream.print(getConstructorJavaDocLink(constructorInfo) + "[" + className + "]");
            || javaName.equals("org.opensearch.script.ScoreScript$ExplanationHolder");
    @SuppressForbidden(reason = "resolve api docs directory with environment")
    }
        }
import org.opensearch.common.SuppressForbidden;
            PrintStream contextIndexStream = new PrintStream(
        Map<String, String> javaNamesToDisplayNames,
                sv2 = ((PainlessContextMethodInfo) si2).getSortValue();
 */
        List<String> contextNames = (List<String>) (Object) parser.list();
    ) {
    }
    }
    }
    }
                packagesStream.println(
        String currentPackageName = null;
            indexStream.println();
                contextPackagesStream,
    private static String getFieldJavaDocLink(PainlessContextFieldInfo fieldInfo) {
                StandardCharsets.UTF_8.name()
            if (parameterIndex + 1 < methodInfo.getParameters().size()) {
        }
        indexStream.println("include::packages.asciidoc[]");
 * compatible open source license.
            ++arrayDimensions;
        List<Object> staticInfos,
            stream.print(getType(javaNamesToDisplayNames, methodInfo.getParameters().get(parameterIndex)));
        Path sharedIndexPath = sharedDir.resolve("index.asciidoc");
        }
                printConstructor(packagesStream, javaNamesToDisplayNames, className, constructorInfo);
        }
        javaDocLink.append(")");
            javaType = "void";
        if (constructorInfo.getDeclaring().startsWith("java.")) {
            for (PainlessContextFieldInfo fieldInfo : classInfo.getStaticFields()) {
                javaType = javaType.substring(arrayDimensions);
            .stream()
            javaType = "double";
            javaType = "byte";
            printPackages(
        printSharedPackagesPages(sharedDir, javaNamesToDisplayNames, classInfos);
        Files.createDirectories(contextDir);
            contextNameBuilder.append(part.substring(1));
    private static void printIndex(
            javaType = "java.lang.Object";
                    printClassBinding(indexStream, javaNamesToDisplayNames, (PainlessContextClassBindingInfo) staticInfo);
        javaDocLink.append(".html#");
        stream.print("* " + (isStatic ? "static " : ""));
        stream.print("(");
            indexStream.println("==== Classes By Package");
                    indexStream.println();
 * SPDX-License-Identifier: Apache-2.0
    @SuppressForbidden(reason = "retrieving data from an internal API not exposed as part of the REST client")
            );
import java.net.URLConnection;
            }
    private static void printConstructor(
                Files.newOutputStream(rootIndexPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE),
                classInfos
        StringBuilder javaDocLink = new StringBuilder();
 * You may obtain a copy of the License at
            if (compare == 0) {
 *     <li>A detailed page per package per context of shared API for all contexts</li>
        }
            packagesStream.println("[[" + getClassHeader(contextHeader, className) + "]]");
            if (si2 instanceof PainlessContextMethodInfo) {
        }
                }
    }
    }
                    );
 * this work for additional information regarding copyright
            parser = JsonXContent.jsonXContent.createParser(null, null, getContextInfo.getInputStream());
        PrintStream packagesStream,
    private static Set<Object> createSharedStatics(List<PainlessContextInfo> contextInfos) {
            } else if (si1 instanceof PainlessContextInstanceBindingInfo) {
 *
            javaType = javaNamesToDisplayNames.get(javaType);
    private static boolean isInternalClass(String javaName) {
        classInfos = new ArrayList<>(classInfos);
                }
                stream.print(", ");
        parser.nextToken();
        }
            indexStream.println(
        PainlessContextClassBindingInfo classBindingInfo
        for (int parameterIndex = 0; parameterIndex < classBindingInfo.getParameters().size(); ++parameterIndex) {
                }
            String className = getType(javaNamesToDisplayNames, classInfo.getName());
                }
            if (parameterIndex + 1 < instanceBindingInfo.getParameters().size()) {
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, String> javaNamesToDisplayNames,
                StandardCharsets.UTF_8.name()
                false,
            }
            }
        }
                printMethod(packagesStream, javaNamesToDisplayNames, false, methodInfo);
    }
                getContextHeader(contextInfo),
                    indexStream.println();
                stream.print(", ");
        try (
    private static List<Object> sortStaticInfos(Set<Object> staticExcludes, List<Object> staticInfos) {
 * Unless required by applicable law or agreed to in writing,
        try (
        } else if ("S".equals(javaType) || "short".equals(javaType)) {
import java.util.HashMap;
import org.opensearch.painless.action.PainlessContextClassInfo;
    }
            .openConnection();
                staticInfoCounts.merge(methodInfo, 1, Integer::sum);
import org.opensearch.painless.action.PainlessContextMethodInfo;
        PrintStream stream,
            for (Object staticInfo : staticInfos) {
        Set<PainlessContextClassInfo> sharedClassInfos = createSharedClasses(contextInfos);
        return sharedDir;
        javaDocLink.append(methodInfo.getName());
    private static String getContextHeader(PainlessContextInfo contextInfo) {
                packagesStream.println();
                printField(packagesStream, javaNamesToDisplayNames, true, fieldInfo);
                String contextHeader = getContextHeader(contextInfo);
            } else {
            packagesStream.println();
            if ("org.opensearch.script.ScoreScript".equals(
 *     <li>A detailed page per package per context of specialized API for each context</li>
                javaDocLink.append(",");
        PrintStream indexStream,
                    "See the <<" + contextHeader + ", " + contextName + " API>> " + "for a high-level overview of all packages and classes."
        } else if ("I".equals(javaType) || "int".equals(javaType)) {
                if (i1 && i2) {
 * The gradle task generateContextDoc uses ContextDocGenerator to rebuild
            sharedIndexStream.println("The following API is available in all contexts.");
        Map<String, String> javaNamesToDisplayNames,
            if (javaType.charAt(javaType.length() - 1) == ';') {
 * The OpenSearch Contributors require contributions made to
            javaType = "char";
                StandardCharsets.UTF_8.name()
                    indexStream.println("==== " + currentPackageName);
        try (
        stream.print("* " + getType(javaNamesToDisplayNames, instanceBindingInfo.getRtn()) + " " + instanceBindingInfo.getName() + "(");
        indexStream.println();
        for (PainlessContextClassInfo classInfo : classInfos) {
                stream.print(", ");
        } else if ("J".equals(javaType) || "long".equals(javaType)) {
        StringBuilder contextNameBuilder = new StringBuilder();
                            + "Expand details for "
        Files.createDirectories(rootDir);
        }
        contextInfos.sort(Comparator.comparing(PainlessContextInfo::getName));
                "The following methods are directly callable without a class/instance qualifier. "
        List<Object> staticInfos = sortStaticInfos(Collections.emptySet(), new ArrayList<>(sharedStaticInfos));
        stream.println("// This file is auto-generated. Do not edit.");
        }
        stream.println(")");
            for (PainlessContextInstanceBindingInfo instanceBindingInfo : contextInfo.getInstanceBindings()) {
import java.util.ArrayList;
            .stream()
            for (PainlessContextInfo contextInfo : contextInfos) {
            )
 * specific language governing permissions and limitations
        Path sharedDir = createSharedDir(rootDir);
            }
        stream.print("* " + (isStatic ? "static " : ""));
            if (classPackageName.equals(currentPackageName) == false) {
            indexStream.println();
                excludes,
        boolean isStatic,
    }
            } else if (si2 instanceof PainlessContextClassBindingInfo) {
            PrintStream sharedIndexStream = new PrintStream(
                || "byte".equals(v.getName())
                            + getPackageHeader(contextHeader, currentPackageName)
            } else if (si2 instanceof PainlessContextInstanceBindingInfo) {
    ) throws IOException {
    }
            .filter(e -> e.getValue() == contextInfos.size())
            String n1 = c1.getName();
                printContextIndexPage(contextDir, javaNamesToDisplayNames, contextInfo, staticInfos, classInfos);
    }
    private static String getConstructorJavaDocLink(PainlessContextConstructorInfo constructorInfo) {
    private static String getMethodJavaDocLink(PainlessContextMethodInfo methodInfo) {
import org.opensearch.core.xcontent.XContentParser;
            javaType = "double";
import java.net.URL;
            javaType = "float";
        javaDocLink.append(")");
                    + "to view details about the available methods and fields."
        Map<String, String> javaNamesToDisplayNames,
            .collect(Collectors.toSet());
                javaNamesToDisplayNames.put(className, className.replace('$', '.'));
            javaType = "float";
                "http://" + System.getProperty("cluster.uri") + "/_scripts/painless/_context?context=" + contextName
        if (fieldInfo.getDeclaring().startsWith("java.")) {
        parser.nextToken();
                false,
            javaType = "short";
        }
            stream.println(fieldInfo.getName());
                javaNamesToDisplayNames.put(className, className.substring(className.lastIndexOf('.') + 1).replace('$', '.'));
        for (PainlessContextInfo contextInfo : contextInfos) {
            javaType = "byte";
                "* See the <<" + SHARED_HEADER + ", " + SHARED_NAME + " API>> for further API available in all contexts."
        return staticInfoCounts.entrySet()
import org.opensearch.common.io.PathUtils;
    private static void printInstanceBinding(
        List<PainlessContextInfo> contextInfos = getContextInfos();
    private static void printField(
            javaType = "char";
import java.util.HashSet;
                            + ">>"
        while (arrayDimensions-- > 0) {
        List<PainlessContextClassInfo> classInfos
                packagesStream.println("[role=\"exclude\",id=\"" + getPackageHeader(contextHeader, currentPackageName) + "\"]");
            boolean i1 = c1.isImported();
        printRootIndexPage(rootDir, contextInfos, isSpecialized);
                    + "Note parameters denoted by a (*) are treated as read-only values."
                            + ", "
        return contextInfos;
    private static void printRootIndexPage(Path rootDir, List<PainlessContextInfo> contextInfos, Set<PainlessContextInfo> isSpecialized)
            rootIndexStream.println("|====");
            printIndex(contextIndexStream, getContextHeader(contextInfo), javaNamesToDisplayNames, staticInfos, classInfos);
            contextIndexStream.println("[[" + getContextHeader(contextInfo) + "]]");
                    indexStream.println(
 * under the License.
            printAutomatedMessage(sharedIndexStream);
import java.util.Comparator;
    private static final String SHARED_NAME = "Shared";
        Map<String, String> javaNamesToDisplayNames,
            // class instance bindings are created and the information is appropriately added to the context info classes
        return contextNameBuilder.substring(0, contextNameBuilder.length() - 1);
                || "org.opensearch.painless.lookup.def".equals(v.getName())
            javaType = "boolean";
        @SuppressWarnings("unchecked")
 * ownership. Elasticsearch licenses this file to you under
                } else if (staticInfo instanceof PainlessContextClassBindingInfo) {
        }
            } else {
                continue;
        staticInfos.addAll(contextInfo.getClassBindings());
import java.util.Map;
 * </ul>
            }
            for (PainlessContextClassInfo classInfo : classInfos) {
        for (PainlessContextInfo contextInfo : contextInfos) {
        Path contextDir,
        Map<String, String> javaNamesToDisplayNames,
        ((HttpURLConnection) getContextNames).disconnect();
    }
 * software distributed under the License is distributed on an
                || "int".equals(v.getName())
            printAutomatedMessage(contextPackagesStream);
                javaType = javaType.substring(arrayDimensions + 1, javaType.length() - 1);
                    compare = n1.compareTo(n2);
    }
                currentPackageName = classPackageName;
        ) {
        for (int parameterIndex = 0; parameterIndex < constructorInfo.getParameters().size(); ++parameterIndex) {
        Path rootDir = resetRootDir();
            contextInfos.add(PainlessContextInfo.fromXContent(parser));
        }
    }
    ) {
        }
        printSharedIndexPage(sharedDir, javaNamesToDisplayNames, staticInfos, classInfos);
 * <ul>
            javaType = "def";
        List<PainlessContextClassInfo> classInfos
    ) {
        Map<PainlessContextClassInfo, Integer> classInfoCounts = new HashMap<>();
        Path contextDir,
            }
        } else {
    ) {
        );
        PainlessContextFieldInfo fieldInfo
            rootIndexStream.println("[cols=\"<3,^3,^3\"]");
 *     <li>A high-level overview page of shared API for all contexts</li>
    }
            if (si1 instanceof PainlessContextMethodInfo) {
 * Modifications Copyright OpenSearch Contributors. See
                } else {
        stream.println(")");
            contextIndexStream.println("The following specialized API is available in the " + getContextName(contextInfo) + " context.");
            )
        } else if ("D".equals(javaType) || "double".equals(javaType)) {
    private static List<PainlessContextInfo> getContextInfos() throws IOException {
    }
            packagesStream.println("==== " + className + "");
import java.util.Set;
            return compare;
            }
        stream.print("* ");
    }
        Map<String, String> javaNamesToDisplayNames = new HashMap<>();
        } else if ("B".equals(javaType) || "byte".equals(javaType)) {
                    printMethod(indexStream, javaNamesToDisplayNames, false, (PainlessContextMethodInfo) staticInfo);
            for (PainlessContextClassInfo classInfo : contextInfo.getClasses()) {
        } else if ("F".equals(javaType) || "float".equals(javaType)) {
                sv2 = ((PainlessContextInstanceBindingInfo) si2).getSortValue();
import org.opensearch.painless.action.PainlessContextInfo;
        ) {
        String className,
                    rootIndexStream.println("| ");
                indexStream.println("* <<" + getClassHeader(contextHeader, className) + ", " + className + ">>");
        try (
            }
 * this file be licensed under the Apache-2.0 license or a
    }
        }
            v -> "void".equals(v.getName())
                    throw new IllegalArgumentException("unexpected static info type");
        Map<String, String> javaNamesToDisplayNames,
        stream.print("(");
        Set<Object> sharedStaticInfos = createSharedStatics(contextInfos);
import org.opensearch.painless.action.PainlessContextConstructorInfo;
        if (methodInfo.getDeclaring().startsWith("java.")) {
                } else if (i1 == false && i2 == false) {
        ) {
    }
        }
                staticInfoCounts.merge(classBindingInfo, 1, Integer::sum);
                String classPackageName = classInfo.getName().substring(0, classInfo.getName().lastIndexOf('.'));
        classInfos.removeIf(
                        "<<"
        URLConnection getContextNames = new URL("http://" + System.getProperty("cluster.uri") + "/_scripts/painless/_context")
            ).openConnection();
                    compare = Boolean.compare(i1, i2) * -1;
            if (classInfo.isImported()) {
        return "painless-api-reference-" + contextInfo.getName().replace(" ", "-").replace("_", "-");
            contextNameBuilder.append(Character.toUpperCase(part.charAt(0)));
    ) {
                rootIndexStream.print("|" + contextName + " ");
    }
    private static void printClassBinding(
        List<PainlessContextInfo> contextInfos = new ArrayList<>();
        return contextDir;
        } else if ("F".equals(javaType) || "float".equals(javaType)) {
                javaDocLink.append(",");
            }
    }
    private static void printAutomatedMessage(PrintStream stream) {
        } else if ("V".equals(javaType) || "void".equals(javaType)) {
                false,
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                    compare = n1.substring(n1.lastIndexOf('.') + 1).compareTo(n2.substring(n2.lastIndexOf('.') + 1));
        return staticInfos;
            PrintStream contextPackagesStream = new PrintStream(
            printAutomatedMessage(sharedPackagesStream);
            for (PainlessContextMethodInfo methodInfo : contextInfo.getImportedMethods()) {
            printAutomatedMessage(rootIndexStream);
        return rootDir;
            String classPackageName = classInfo.getName().substring(0, classInfo.getName().lastIndexOf('.'));
                sv1 = ((PainlessContextInstanceBindingInfo) si1).getSortValue();
    private static void printMethod(
import org.opensearch.painless.action.PainlessContextInstanceBindingInfo;
        javaDocLink.append("{java11-javadoc}/java.base/");
        PainlessContextConstructorInfo constructorInfo
            .map(Map.Entry::getKey)
        Path rootIndexPath = rootDir.resolve("index.asciidoc");
            if (parameterIndex + 1 < classBindingInfo.getParameters().size()) {
                rootIndexStream.print("| <<" + SHARED_HEADER + ", " + SHARED_NAME + " API>> ");
}
            }
            contextIndexStream.println();
                Files.newOutputStream(sharedIndexPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE),
    ) {
                packagesStream.println("=== " + contextName + " API for package " + currentPackageName);
 * Licensed to Elasticsearch under one or more contributor
import java.io.IOException;
            }
        } else if ("org.opensearch.painless.lookup.def".equals(javaType)) {
        PainlessContextInstanceBindingInfo instanceBindingInfo
import java.nio.file.Files;
        Path sharedDir = rootDir.resolve(SHARED_HEADER);
        List<Object> staticInfos,
    private static void printSharedIndexPage(
        } else if ("J".equals(javaType) || "long".equals(javaType)) {
        PrintStream stream,
    }
    }
    }
        List<PainlessContextClassInfo> classInfos = sortClassInfos(Collections.emptySet(), new ArrayList<>(sharedClassInfos));
            }
            for (PainlessContextConstructorInfo constructorInfo : classInfo.getConstructors()) {
    private static void printContextPackagesPages(
        Map<String, String> javaNamesToDisplayNames,
        for (int parameterIndex = 0; parameterIndex < methodInfo.getParameters().size(); ++parameterIndex) {
                if (staticInfo instanceof PainlessContextMethodInfo) {
    }
            stream.print(getMethodJavaDocLink(methodInfo) + "[" + methodInfo.getName() + "]");
            rootIndexStream.println("include::" + SHARED_HEADER + "/index.asciidoc[]");
        return javaType;
            javaType = "int";
        return contextHeader + "-" + packageName.replace('.', '-');
        List<Object> staticInfos,
        stream.print(getType(javaNamesToDisplayNames, methodInfo.getRtn()) + " ");
                false,
            ++arrayDimensions;
            javaDocLink.append(getLinkType(methodInfo.getParameters().get(parameterIndex)));
                );
        if (classInfos.isEmpty() == false) {
                sv2 = ((PainlessContextClassBindingInfo) si2).getSortValue();
                continue;
        } else if ("B".equals(javaType) || "byte".equals(javaType)) {
            indexStream.println();
        Set<PainlessContextInfo> isSpecialized = new HashSet<>();
            sharedIndexStream.println("=== " + SHARED_NAME + " API");
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return javaType;
    private static Set<PainlessContextClassInfo> createSharedClasses(List<PainlessContextInfo> contextInfos) {
            String sv2;
            } else {
    private static final String SHARED_HEADER = "painless-api-reference-shared";
        String currentPackageName = null;
        while (javaType.charAt(arrayDimensions) == '[') {
        PrintStream stream,
                } else if (staticInfo instanceof PainlessContextInstanceBindingInfo) {
            rootIndexStream.println();
                Path contextDir = createContextDir(rootDir, contextInfo);
import org.opensearch.common.xcontent.json.JsonXContent;
        }
    }
        boolean isStatic,
            String p2 = n2.substring(0, n2.lastIndexOf('.'));
        }
import java.nio.charset.StandardCharsets;
        indexStream.println();
            indexStream.println();
    }
    }
            for (PainlessContextFieldInfo fieldInfo : classInfo.getFields()) {
        } else if ("D".equals(javaType) || "double".equals(javaType)) {
    ) throws IOException {
        Set<PainlessContextClassInfo> excludes,
        }
            }
            for (PainlessContextMethodInfo methodInfo : classInfo.getStaticMethods()) {
        }
        int arrayDimensions = 0;
        List<PainlessContextClassInfo> classInfos
        }
        }
                String contextName = getContextName(contextInfo);
        return javaNamesToDisplayNames;
    private static void printPackages(
            if (excludes.contains(classInfo)) {
        List<Object> staticInfos = new ArrayList<>();
                    currentPackageName = classPackageName;
        }
        Map<String, String> javaNamesToDisplayNames,
            String className = classInfo.getName();
                classInfoCounts.merge(classInfo, 1, Integer::sum);
        return "{java11-javadoc}/java.base/" + fieldInfo.getDeclaring().replace('.', '/') + ".html#" + fieldInfo.getName();
 * existing documentation is deleted. The following pages are generated:
    private static Path createSharedDir(Path rootDir) throws IOException {
        Path contextIndexPath = contextDir.resolve("index.asciidoc");
        Path sharedDir,
                Files.newOutputStream(sharedClassesPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE),
        PrintStream stream,
            PrintStream rootIndexStream = new PrintStream(
                || "double".equals(v.getName())
        PrintStream stream,
            stream.print(className);
        ) {
    }
        if ("Z".equals(javaType) || "boolean".equals(javaType)) {
        Set<PainlessContextClassInfo> classExcludes,
            PrintStream sharedPackagesStream = new PrintStream(
            );
        staticInfos.addAll(contextInfo.getInstanceBindings());
        stream.print(getType(javaNamesToDisplayNames, fieldInfo.getType()) + " ");
            URLConnection getContextInfo = new URL(
        return staticInfos;
            if (parameterIndex + 1 < constructorInfo.getParameters().size()) {
        for (PainlessContextClassInfo classInfo : classInfos) {
        Path rootDir = PathUtils.get("../../docs/painless/painless-api-reference");
import java.util.List;
        stream.print("* " + getType(javaNamesToDisplayNames, classBindingInfo.getRtn()) + " " + classBindingInfo.getName() + "(");
 * Use the docs build to generate HTML pages from the resultant asciidoc files.
        Path sharedClassesPath = sharedDir.resolve("packages.asciidoc");
                || "float".equals(v.getName())
        for (int parameterIndex = 0; parameterIndex < instanceBindingInfo.getParameters().size(); ++parameterIndex) {
                } else {
        String contextHeader,
            }
        Path contextDir = rootDir.resolve(getContextHeader(info));
            }
            .map(Map.Entry::getKey)
            if (parameterIndex + 1 < constructorInfo.getParameters().size()) {
        PainlessContextMethodInfo methodInfo
            }
                    printInstanceBinding(indexStream, javaNamesToDisplayNames, (PainlessContextInstanceBindingInfo) staticInfo);
        stream.println();
    }
        } else if ("V".equals(javaType) || "void".equals(javaType)) {
    }
        for (int parameterIndex = 0; parameterIndex < constructorInfo.getParameters().size(); ++parameterIndex) {
                getContextName(contextInfo),
            } else if (si1 instanceof PainlessContextClassBindingInfo) {
            }
        if (arrayDimensions > 0) {
            if (staticInfos.isEmpty() == false || classInfos.isEmpty() == false) {
            }
import java.util.stream.Collectors;
        packagesStream.println();
            .collect(Collectors.toSet());
 * the Painless API documentation from a clean state after the
            printIndex(sharedIndexStream, SHARED_HEADER, javaNamesToDisplayNames, staticInfos, classInfos);
import java.nio.file.StandardOpenOption;
 */
    ) {
            )) {
            }
    private static List<Object> createContextStatics(PainlessContextInfo contextInfo) {
    public static void main(String[] args) throws IOException {
            );
            contextIndexStream.println();
        Files.createDirectories(sharedDir);
        }
                if (isSpecialized.contains(contextInfo)) {
        IOUtils.rm(rootDir);
                false,
    private ContextDocGenerator() {
            sharedIndexStream.println();
        Path contextPackagesPath = contextDir.resolve("packages.asciidoc");
    private static String getType(Map<String, String> javaNamesToDisplayNames, String javaType) {
 *
            indexStream.println("==== Static Methods");
        if (arrayDimensions > 0) {
        }
 * not use this file except in compliance with the License.
