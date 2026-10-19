                rootIndexStream.print("| <<" + SHARED_HEADER + ", " + SHARED_NAME + " API>> ");
            staticInfos = createContextStatics(contextInfo);
        } else if ("J".equals(javaType) || "long".equals(javaType)) {  
 * the Apache License, Version 2.0 (the "License"); you may
        PrintStream stream,
/*  
    }
            for (PainlessContextClassInfo classInfo : classInfos) {
            for (PainlessContextMethodInfo methodInfo : classInfo.getMethods()) {
                stream.print(" *");  
        }  
        Map<String, String> javaNamesToDisplayNames,
            }
            indexStream.println();
        int arrayDimensions = 0;
            classInfos = sortClassInfos(sharedClassInfos, new ArrayList<>(contextInfo.getClasses()));
            if (compare == 0) {  
        } else {
        IOUtils.rm(rootDir);  
        Files.createDirectories(rootDir);
            stream.print(className);
                sv2 = ((PainlessContextMethodInfo) si2).getSortValue();
        }
            }
                || "byte".equals(v.getName())
            }  
                String classPackageName = classInfo.getName().substring(0, classInfo.getName().lastIndexOf('.'));
        Path rootIndexPath = rootDir.resolve("index.asciidoc");
    }  
        }  
            rootIndexStream.println("|====");  
    private static Path createSharedDir(Path rootDir) throws IOException {  
        parser.nextToken();  
        staticInfos = new ArrayList<>(staticInfos);
 * not use this file except in compliance with the License.
            // temporary fix to not print org.opensearch.script.ScoreScript parameter until
        } else if ("S".equals(javaType) || "short".equals(javaType)) {
        stream.print("(");
    }
                if (classPackageName.equals(currentPackageName) == false) {
        if (constructorInfo.getDeclaring().startsWith("java.")) {
    private static void printAutomatedMessage(PrintStream stream) {
            stream.println(getFieldJavaDocLink(fieldInfo) + "[" + fieldInfo.getName() + "]");
            for (PainlessContextFieldInfo fieldInfo : classInfo.getFields()) {  
            } else {
            rootIndexStream.println("[cols=\"<3,^3,^3\"]");
        return staticInfoCounts.entrySet()  
                    compare = n1.substring(n1.lastIndexOf('.') + 1).compareTo(n2.substring(n2.lastIndexOf('.') + 1));
import java.nio.file.Files;
            }
 * KIND, either express or implied.  See the License for the
 *     <li>A detailed page per package per context of specialized API for each context</li>  
 *
            }
 * this work for additional information regarding copyright
            contextNameBuilder.append(part.substring(1));
        Map<String, String> javaNamesToDisplayNames,
    }  
        } else if ("V".equals(javaType) || "void".equals(javaType)) {
                || "char".equals(v.getName())  
                getType(javaNamesToDisplayNames, classBindingInfo.getParameters().get(parameterIndex))
                }  
            printAutomatedMessage(sharedIndexStream);  
        );
                rootIndexStream.print("|" + contextName + " ");  
    private static String getLinkType(String javaType) {  
                StandardCharsets.UTF_8.name()
            boolean i2 = c2.isImported();
            contextIndexStream.println("[[" + getContextHeader(contextInfo) + "]]");
        return staticInfos;
        List<Object> staticInfos = sortStaticInfos(Collections.emptySet(), new ArrayList<>(sharedStaticInfos));
                } else if (staticInfo instanceof PainlessContextInstanceBindingInfo) {
            )
            int compare = p1.compareTo(p2);
        List<PainlessContextClassInfo> classInfos
        List<Object> staticInfos,
        PrintStream stream,  
    }
        return javaType;
        classInfos.removeIf(
            )) {
import org.opensearch.common.xcontent.json.JsonXContent;
    }
        } else {
        return contextNameBuilder.substring(0, contextNameBuilder.length() - 1);  
            .openConnection();  
            javaDocLink.append(getLinkType(methodInfo.getParameters().get(parameterIndex)));  
            stream.print(methodInfo.getName());
    }
            ((HttpURLConnection) getContextInfo).disconnect();
        } else if ("F".equals(javaType) || "float".equals(javaType)) {
            contextIndexStream.println(  
            String n1 = c1.getName();
            printIndex(sharedIndexStream, SHARED_HEADER, javaNamesToDisplayNames, staticInfos, classInfos);
                        "<<"
        Set<PainlessContextClassInfo> excludes,
                    compare = n1.compareTo(n2);
            contextNameBuilder.append(Character.toUpperCase(part.charAt(0)));
        List<PainlessContextClassInfo> classInfos
                false,
        PainlessContextInfo contextInfo,
        XContentParser parser = JsonXContent.jsonXContent.createParser(null, null, getContextNames.getInputStream());
            javaType = "void";
        packagesStream.println();  
    }
        } else {
 * Use the docs build to generate HTML pages from the resultant asciidoc files.
                printContextPackagesPages(contextDir, javaNamesToDisplayNames, sharedClassInfos, contextInfo, classInfos);
                continue;
            if (javaType.charAt(javaType.length() - 1) == ';') {
 * software distributed under the License is distributed on an
        stream.print("* " + (isStatic ? "static " : ""));
        });
            )
            for (PainlessContextMethodInfo methodInfo : classInfo.getStaticMethods()) {
        String currentPackageName = null;  
                javaDocLink.append(",");  
            }
        } else if ("org.opensearch.painless.lookup.def".equals(javaType)) {
            .collect(Collectors.toSet());  
            ++arrayDimensions;
                indexStream.println("* <<" + getClassHeader(contextHeader, className) + ", " + className + ">>");  
import java.nio.file.Path;  
            .stream()  
        PrintStream stream,  
            contextIndexStream.println();  
import java.util.HashSet;  
        ) {
        Set<PainlessContextClassInfo> excludes,  
                    );
            } else {  
        } else if ("I".equals(javaType) || "int".equals(javaType)) {  
            indexStream.println(  
                javaNamesToDisplayNames.put(className, className.replace('$', '.'));
        Path contextDir = rootDir.resolve(getContextHeader(info));
import java.util.Collections;  
                Files.newOutputStream(rootIndexPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE),  
        }
        Map<String, String> javaNamesToDisplayNames,
                StandardCharsets.UTF_8.name()
        Set<PainlessContextInfo> isSpecialized = new HashSet<>();
    ) {
        }
 *  
        Map<String, String> javaNamesToDisplayNames,
                javaNamesToDisplayNames = getDisplayNames(contextInfo.getClasses());  
            stream.print(getType(javaNamesToDisplayNames, classBindingInfo.getParameters().get(parameterIndex)));  
                    rootIndexStream.println("| <<" + contextHeader + ", Specialized API>>");
    }
                sv2 = ((PainlessContextInstanceBindingInfo) si2).getSortValue();
        Path contextPackagesPath = contextDir.resolve("packages.asciidoc");
        stream.println(")");
            }  
            }
    private static String getContextHeader(PainlessContextInfo contextInfo) {
    private static Set<PainlessContextClassInfo> createSharedClasses(List<PainlessContextInfo> contextInfos) {
                Files.newOutputStream(sharedClassesPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE),
            for (PainlessContextClassBindingInfo classBindingInfo : contextInfo.getClassBindings()) {  
            if (parameterIndex + 1 < constructorInfo.getParameters().size()) {
            String className = classInfo.getName();
            stream.print(getMethodJavaDocLink(methodInfo) + "[" + methodInfo.getName() + "]");  
        return rootDir;  
    }
 */
            packagesStream.println();  
                sv1 = ((PainlessContextInstanceBindingInfo) si1).getSortValue();
        PainlessContextConstructorInfo constructorInfo  
        }  
                stream.print(", ");  
            javaType = "int";
 */  
        staticInfos.sort((si1, si2) -> {
 * Unless required by applicable law or agreed to in writing,
                Files.newOutputStream(contextIndexPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE),
            for (PainlessContextMethodInfo methodInfo : contextInfo.getImportedMethods()) {
        if (classInfos.isEmpty() == false) {
                sv1 = ((PainlessContextMethodInfo) si1).getSortValue();  
                if (i1 && i2) {
        parser.nextToken();
        for (PainlessContextInfo contextInfo : contextInfos) {
    }
            javaType = "int";
import org.opensearch.common.SuppressForbidden;
import org.opensearch.common.io.PathUtils;
                            + getPackageHeader(contextHeader, currentPackageName)
        String[] split = contextInfo.getName().split("[_-]");  
                    currentPackageName = classPackageName;
import java.nio.file.StandardOpenOption;
        }
        Path contextDir,
        indexStream.println();
            }
        }
            } else if (si2 instanceof PainlessContextClassBindingInfo) {
            if (parameterIndex + 1 < classBindingInfo.getParameters().size()) {  
        stream.print("* " + (isStatic ? "static " : ""));
            boolean i1 = c1.isImported();
    private static void printContextPackagesPages(  
            if (classInfo.isImported()) {
            javaType += "[]";  
        List<PainlessContextClassInfo> classInfos
            contextIndexStream.println("=== " + getContextName(contextInfo) + " API");
        }
            sharedIndexStream.println("The following API is available in all contexts.");
                    compare = Boolean.compare(i1, i2) * -1;  
        return javaDocLink.toString();  
    ) {
    private static boolean isInternalClass(String javaName) {
            javaType = "java.lang.Object";
    ) throws IOException {  
 *     <li>A high-level overview page of shared API for all contexts</li>  
            javaType = "char";  
            .map(Map.Entry::getKey)  
            }
import java.util.HashMap;
            }
    }  
            rootIndexStream.println("include::" + SHARED_HEADER + "/index.asciidoc[]");
import java.net.URL;
            }
            }
                javaType = javaType.substring(arrayDimensions);
        while (javaType.charAt(arrayDimensions) == '[') {
            javaType = javaNamesToDisplayNames.get(javaType);
                classInfos
        String contextHeader,  
    @SuppressForbidden(reason = "resolve api docs directory with environment")  
        List<PainlessContextClassInfo> classInfos = sortClassInfos(Collections.emptySet(), new ArrayList<>(sharedClassInfos));  
        }  
import java.util.Map;
        javaDocLink.append(")");
package org.opensearch.painless;
        if (staticInfos.isEmpty() == false) {  
        throws IOException {
        return javaType;  
                packagesStream.println("[role=\"exclude\",id=\"" + getPackageHeader(contextHeader, currentPackageName) + "\"]");
        for (int parameterIndex = 0; parameterIndex < classBindingInfo.getParameters().size(); ++parameterIndex) {  
        if ("Z".equals(javaType) || "boolean".equals(javaType)) {  
                }  
                    "See the <<" + contextHeader + ", " + contextName + " API>> " + "for a high-level overview of all packages and classes."
        List<PainlessContextClassInfo> classInfos
    ) throws IOException {
        for (int parameterIndex = 0; parameterIndex < constructorInfo.getParameters().size(); ++parameterIndex) {
        return javaName.equals("org.opensearch.script.ScoreScript")  
    }
                || "float".equals(v.getName())  
        Map<String, String> javaNamesToDisplayNames,
        Map<String, String> javaNamesToDisplayNames = getDisplayNames(classInfos);
            }
        PrintStream stream,
        Path rootDir = PathUtils.get("../../docs/painless/painless-api-reference");
 *    http://www.apache.org/licenses/LICENSE-2.0
            );
        return classInfos;
                javaDocLink.append(",");
        Map<String, String> javaNamesToDisplayNames,
        for (PainlessContextInfo contextInfo : contextInfos) {
            indexStream.println();
        StringBuilder javaDocLink = new StringBuilder();
        Files.createDirectories(contextDir);  
                "The following methods are directly callable without a class/instance qualifier. "
            javaDocLink.append(getLinkType(constructorInfo.getParameters().get(parameterIndex)));
    private static String getContextName(PainlessContextInfo contextInfo) {
 * ownership. Elasticsearch licenses this file to you under  
                javaType = javaType.substring(arrayDimensions + 1, javaType.length() - 1);
        for (int parameterIndex = 0; parameterIndex < methodInfo.getParameters().size(); ++parameterIndex) {
        indexStream.println("include::packages.asciidoc[]");
            }
            if (staticInfos.isEmpty() == false || classInfos.isEmpty() == false) {  
            javaType = "byte";
        @SuppressWarnings("unchecked")
                    + "to view details about the available methods and fields."  
        } else if ("I".equals(javaType) || "int".equals(javaType)) {
    private static List<Object> sortStaticInfos(Set<Object> staticExcludes, List<Object> staticInfos) {  
import java.io.PrintStream;  
        PrintStream indexStream,  
            sharedIndexStream.println("[[" + SHARED_HEADER + "]]");
    }  
    private static String getConstructorJavaDocLink(PainlessContextConstructorInfo constructorInfo) {
        return staticInfos;
                    indexStream.println();
        List<PainlessContextInfo> contextInfos = new ArrayList<>();  
        contextInfos.sort(Comparator.comparing(PainlessContextInfo::getName));
        Path contextDir,  
import java.util.ArrayList;
            javaType = "float";
import org.opensearch.painless.action.PainlessContextInfo;
 * specific language governing permissions and limitations
    }  
            if (si1 instanceof PainlessContextMethodInfo) {
        if ("Z".equals(javaType) || "boolean".equals(javaType)) {
/*  
            indexStream.println();
    }  
    private static List<Object> createContextStatics(PainlessContextInfo contextInfo) {
            if (parameterIndex < classBindingInfo.getReadOnly()) {
        while (arrayDimensions-- > 0) {
                staticInfoCounts.merge(instanceBindingInfo, 1, Integer::sum);
            javaType = "byte";
                || "long".equals(v.getName())
import java.nio.charset.StandardCharsets;
        String contextName,
        Set<PainlessContextClassInfo> classExcludes,
            sharedIndexStream.println();
    private static String getPackageHeader(String contextHeader, String packageName) {  
                currentPackageName = classPackageName;
                javaType = javaType.substring(arrayDimensions);
                } else if (i1 == false && i2 == false) {  
    }
            printAutomatedMessage(rootIndexStream);  
            packagesStream.println("[[" + getClassHeader(contextHeader, className) + "]]");
    }
        }
            PrintStream contextIndexStream = new PrintStream(
                packagesStream.println("=== " + contextName + " API for package " + currentPackageName);
            } else {
            return sv1.compareTo(sv2);
                            + currentPackageName
                excludes,  
        } else if ("B".equals(javaType) || "byte".equals(javaType)) {
            PrintStream sharedPackagesStream = new PrintStream(  
import org.opensearch.painless.action.PainlessContextClassBindingInfo;  
        Set<Object> sharedStaticInfos = createSharedStatics(contextInfos);
                }
        printSharedIndexPage(sharedDir, javaNamesToDisplayNames, staticInfos, classInfos);
            }  
import java.net.URLConnection;  
            PrintStream rootIndexStream = new PrintStream(
        return contextDir;
/*
            if (parameterIndex + 1 < instanceBindingInfo.getParameters().size()) {
            for (PainlessContextConstructorInfo constructorInfo : classInfo.getConstructors()) {
    private static String getMethodJavaDocLink(PainlessContextMethodInfo methodInfo) {
        String className,
                }
        stream.println(")");
    private static void printPackages(  
            javaType = "void";  
            }
            for (PainlessContextInfo contextInfo : contextInfos) {
        Path sharedDir,
        return contextHeader + "-" + packageName.replace('.', '-');
            if (excludes.contains(classInfo)) {  
                if (staticInfo instanceof PainlessContextMethodInfo) {
        Path sharedDir = createSharedDir(rootDir);
            }
        return contextInfos;
import java.util.stream.Collectors;
    }
        ) {
    ) throws IOException {
            } else {  
        if (arrayDimensions > 0) {
            parser = JsonXContent.jsonXContent.createParser(null, null, getContextInfo.getInputStream());  
        stream.print("* " + getType(javaNamesToDisplayNames, instanceBindingInfo.getRtn()) + " " + instanceBindingInfo.getName() + "(");
        Files.createDirectories(sharedDir);
        PainlessContextInstanceBindingInfo instanceBindingInfo
 * the Painless API documentation from a clean state after the
            return compare;
        for (PainlessContextInfo contextInfo : contextInfos) {
}
                javaNamesToDisplayNames,
        return classInfoCounts.entrySet()
        }
        if (arrayDimensions > 0) {  
            }
    ) {
                || "org.opensearch.painless.lookup.def".equals(v.getName())
 * this file be licensed under the Apache-2.0 license or a
            }
 * existing documentation is deleted. The following pages are generated:  
 *     <li>A high-level overview page of specialized API for each context</li>
        ) {
        stream.print(getType(javaNamesToDisplayNames, fieldInfo.getType()) + " ");
                staticInfoCounts.merge(methodInfo, 1, Integer::sum);  
        }
                            + "Expand details for "
                sv2 = ((PainlessContextClassBindingInfo) si2).getSortValue();  
        staticInfos.addAll(contextInfo.getInstanceBindings());  
        for (PainlessContextClassInfo classInfo : classInfos) {
            indexStream.println("==== Classes By Package");  
            printAutomatedMessage(sharedPackagesStream);
                } else {
    private static void printIndex(
                    + "Note parameters denoted by a (*) are treated as read-only values."
                    throw new IllegalArgumentException("unexpected static info type");
    private static String getClassHeader(String contextHeader, String className) {
        }
        javaDocLink.append("(");
            javaType = "short";
                stream.print(", ");  
        Path contextIndexPath = contextDir.resolve("index.asciidoc");
        PainlessContextFieldInfo fieldInfo
    }
                String contextHeader = getContextHeader(contextInfo);
            .filter(e -> e.getValue() == contextInfos.size())
    private static void printRootIndexPage(Path rootDir, List<PainlessContextInfo> contextInfos, Set<PainlessContextInfo> isSpecialized)  
                StandardCharsets.UTF_8.name()
    private static void printMethod(
    }
                "The following classes are available grouped by their respective packages. Click on a class "
        List<Object> staticInfos,  
        } else if ("org.opensearch.painless.lookup.def".equals(javaType)) {  
        }  
        javaDocLink.append("{java11-javadoc}/java.base/");
        if (methodInfo.getDeclaring().startsWith("java.")) {
    ) {
        Map<String, String> javaNamesToDisplayNames,
            if (javaType.charAt(javaType.length() - 1) == ';') {
            indexStream.println(
            ++arrayDimensions;  
                || "double".equals(v.getName())
                isSpecialized.add(contextInfo);
                );
        } else if ("C".equals(javaType) || "char".equals(javaType)) {
        boolean isStatic,
            stream.print(getType(javaNamesToDisplayNames, constructorInfo.getParameters().get(parameterIndex)));  
        javaDocLink.append(methodInfo.getDeclaring().replace('.', '/'));
        List<PainlessContextInfo> contextInfos = getContextInfos();
        return sharedDir;
        int arrayDimensions = 0;  
                sv1 = ((PainlessContextClassBindingInfo) si1).getSortValue();
            );  
            .filter(e -> e.getValue() == contextInfos.size())
        PainlessContextClassBindingInfo classBindingInfo
                false,
    ) {
        stream.print("* " + getType(javaNamesToDisplayNames, classBindingInfo.getRtn()) + " " + classBindingInfo.getName() + "(");
        javaDocLink.append(constructorInfo.getDeclaring().replace('.', '/'));
    private static void printInstanceBinding(
            } else {  
import java.util.Comparator;
            indexStream.println();
                continue;  
    }  
            javaType = "boolean";
 *     <li>An index page with each context and links to the APIs</li>
    private static void printConstructor(
    private static Set<Object> createSharedStatics(List<PainlessContextInfo> contextInfos) {
    private static final String SHARED_HEADER = "painless-api-reference-shared";  
        ) {  
            for (PainlessContextClassInfo classInfo : contextInfo.getClasses()) {  
            javaType = "char";
            )  
        } else if ("B".equals(javaType) || "byte".equals(javaType)) {  
            || javaName.equals("org.opensearch.script.ScoreScript$ExplanationHolder");
    private static Map<String, String> getDisplayNames(List<PainlessContextClassInfo> classInfos) {
import org.opensearch.painless.action.PainlessContextConstructorInfo;
                Files.newOutputStream(sharedIndexPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE),  
            javaType = "double";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
        String currentPackageName = null;
                || "short".equals(v.getName())
        for (String part : split) {  
            )  
        }  
        stream.print("* ");  
            javaType = "boolean";  
                Files.newOutputStream(contextPackagesPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE),  
        }
                throw new IllegalArgumentException("unexpected static info type");
                    indexStream.println("==== " + currentPackageName);
            }
            stream.print(getType(javaNamesToDisplayNames, instanceBindingInfo.getParameters().get(parameterIndex)));
            String p1 = n1.substring(0, n1.lastIndexOf('.'));
        List<Object> staticInfos = new ArrayList<>();
            );
        }  
 * </ul>
                String className = getType(javaNamesToDisplayNames, classInfo.getName());
                getContextHeader(contextInfo),
            stream.print(getType(javaNamesToDisplayNames, methodInfo.getParameters().get(parameterIndex)));  
        }  
            String classPackageName = classInfo.getName().substring(0, classInfo.getName().lastIndexOf('.'));
import org.opensearch.core.xcontent.XContentParser;
    private static final String SHARED_NAME = "Shared";
        PainlessContextMethodInfo methodInfo
                    rootIndexStream.println("| ");  
        Map<String, String> javaNamesToDisplayNames,  
    private static void printField(  
            }
        if (fieldInfo.getDeclaring().startsWith("java.")) {
        Map<String, String> javaNamesToDisplayNames,
        Map<PainlessContextClassInfo, Integer> classInfoCounts = new HashMap<>();  
    private static Path createContextDir(Path rootDir, PainlessContextInfo info) throws IOException {
                    indexStream.println(  
    }
    ) {  
        stream.println(")");  
                "http://" + System.getProperty("cluster.uri") + "/_scripts/painless/_context?context=" + contextName
                StandardCharsets.UTF_8.name()
            }
    }
            String sv2;  
    private static void printSharedPackagesPages(  
                if (isSpecialized.contains(contextInfo)) {  
            }
        List<PainlessContextClassInfo> classInfos  
 * You may obtain a copy of the License at  
        String contextHeader,
        stream.println("// This file is auto-generated. Do not edit.");  
        Path sharedClassesPath = sharedDir.resolve("packages.asciidoc");  
        PainlessContextInfo contextInfo,
        }
import java.net.HttpURLConnection;
            rootIndexStream.println();
    ) {
    private static Path resetRootDir() throws IOException {
            javaType = "float";  
                printMethod(packagesStream, javaNamesToDisplayNames, false, methodInfo);  
        List<String> contextNames = (List<String>) (Object) parser.list();
        } else if ("D".equals(javaType) || "double".equals(javaType)) {  
    private static void printClassBinding(
                || "int".equals(v.getName())
                || classExcludes.contains(v)
        }
            printIndex(contextIndexStream, getContextHeader(contextInfo), javaNamesToDisplayNames, staticInfos, classInfos);
        for (int parameterIndex = 0; parameterIndex < constructorInfo.getParameters().size(); ++parameterIndex) {
        javaDocLink.append(".html#");  
            printAutomatedMessage(contextIndexStream);
        Map<String, String> javaNamesToDisplayNames,  
                packagesStream.println(  
        }  
            if (classPackageName.equals(currentPackageName) == false) {  
                } else {
        Set<PainlessContextClassInfo> sharedClassInfos = createSharedClasses(contextInfos);  
                || isInternalClass(v.getName())  
    private static String getFieldJavaDocLink(PainlessContextFieldInfo fieldInfo) {  
            PrintStream contextPackagesStream = new PrintStream(
        staticInfos.addAll(contextInfo.getImportedMethods());
        boolean isStatic,  
            PrintStream sharedIndexStream = new PrintStream(
            String n2 = c2.getName();  
                printMethod(packagesStream, javaNamesToDisplayNames, true, methodInfo);  
    public static void main(String[] args) throws IOException {  
                false,
            javaType = "double";
import java.io.IOException;
                            + ", "  
                } else {
        return "painless-api-reference-" + contextInfo.getName().replace(" ", "-").replace("_", "-");  
                            + ">>"  
        Path sharedDir = rootDir.resolve(SHARED_HEADER);
 * SPDX-License-Identifier: Apache-2.0
    }  
        stream.print("(");
            stream.println(fieldInfo.getName());
                javaType = javaType.substring(arrayDimensions + 1, javaType.length() - 1);  
import java.util.List;
        classInfos.sort((c1, c2) -> {
                || "boolean".equals(v.getName())  
    private static void printContextIndexPage(
            }  
            rootIndexStream.println("|====");
            for (PainlessContextInfo contextInfo : contextInfos) {  
            // class instance bindings are created and the information is appropriately added to the context info classes
            javaType = "long";
        return javaNamesToDisplayNames;
        stream.println();
public final class ContextDocGenerator {
                Path contextDir = createContextDir(rootDir, contextInfo);
            } else if (si2 instanceof PainlessContextInstanceBindingInfo) {
            } else if (si1 instanceof PainlessContextClassBindingInfo) {
        staticInfos.addAll(contextInfo.getClassBindings());
            if ("org.opensearch.script.ScoreScript".equals(  
 * GitHub history for details.
        classInfos = new ArrayList<>(classInfos);  
                throw new IllegalArgumentException("unexpected static info type");  
        return contextHeader + "-" + className.replace('.', '-');
        ((HttpURLConnection) getContextNames).disconnect();
                stream.print(", ");
        }
                    printMethod(indexStream, javaNamesToDisplayNames, false, (PainlessContextMethodInfo) staticInfo);
        return "{java11-javadoc}/java.base/" + fieldInfo.getDeclaring().replace('.', '/') + ".html#" + fieldInfo.getName();
                contextPackagesStream,
        try (  
import org.opensearch.painless.action.PainlessContextClassInfo;
        }  
            .stream()
            if (si2 instanceof PainlessContextMethodInfo) {  
    }
            contextIndexStream.println();
        PrintStream stream,
        } else {  
        javaDocLink.append(methodInfo.getName());
                printField(packagesStream, javaNamesToDisplayNames, true, fieldInfo);
                javaNamesToDisplayNames.put(className, className.substring(className.lastIndexOf('.') + 1).replace('$', '.'));
            URLConnection getContextInfo = new URL(  
    }
            .collect(Collectors.toSet());
 *     <li>A detailed page per package per context of shared API for all contexts</li>
        ) {
    private static List<PainlessContextInfo> getContextInfos() throws IOException {
            for (Object staticInfo : staticInfos) {  
        List<Object> staticInfos,  
                stream.print(", ");
            if (parameterIndex + 1 < constructorInfo.getParameters().size()) {  
            indexStream.println("==== Static Methods");
                    printInstanceBinding(indexStream, javaNamesToDisplayNames, (PainlessContextInstanceBindingInfo) staticInfo);  
        List<PainlessContextClassInfo> classInfos  
        parser.close();  
        indexStream.println();  
        Map<Object, Integer> staticInfoCounts = new HashMap<>();
        for (int parameterIndex = 0; parameterIndex < instanceBindingInfo.getParameters().size(); ++parameterIndex) {
import org.opensearch.common.util.io.IOUtils;  
 * under the License.  
 * <ul>
                StandardCharsets.UTF_8.name()  
        printRootIndexPage(rootDir, contextInfos, isSpecialized);  
        });
        printSharedPackagesPages(sharedDir, javaNamesToDisplayNames, classInfos);  
            );
        PrintStream packagesStream,
                false,
        }
    private ContextDocGenerator() {
            for (PainlessContextInstanceBindingInfo instanceBindingInfo : contextInfo.getInstanceBindings()) {
            javaType += "%5B%5D";
        StringBuilder javaDocLink = new StringBuilder();
        staticInfos.removeIf(staticExcludes::contains);
        for (PainlessContextClassInfo classInfo : classInfos) {
        Path sharedIndexPath = sharedDir.resolve("index.asciidoc");
                }  
        }
    }
import org.opensearch.painless.action.PainlessContextMethodInfo;  
    }
                String contextName = getContextName(contextInfo);  
            ).openConnection();
import java.util.Set;  
 * license agreements. See the NOTICE file distributed with
            String p2 = n2.substring(0, n2.lastIndexOf('.'));
        Map<String, String> javaNamesToDisplayNames = new HashMap<>();
        } else if ("D".equals(javaType) || "double".equals(javaType)) {
                false,  
            )  
 * The gradle task generateContextDoc uses ContextDocGenerator to rebuild
            if (parameterIndex + 1 < methodInfo.getParameters().size()) {
            stream.print(getConstructorJavaDocLink(constructorInfo) + "[" + className + "]");  
        while (javaType.charAt(arrayDimensions) == '[') {  
        } else if ("F".equals(javaType) || "float".equals(javaType)) {
            javaType = "long";  
    private static List<PainlessContextClassInfo> sortClassInfos(
                } else if (staticInfo instanceof PainlessContextClassBindingInfo) {  
                getContextName(contextInfo),  
            for (PainlessContextFieldInfo fieldInfo : classInfo.getStaticFields()) {
            } else if (si1 instanceof PainlessContextInstanceBindingInfo) {  
                classInfoCounts.merge(classInfo, 1, Integer::sum);
        }
            javaType = "short";  
        javaDocLink.append(".html#<init>(");  
    }
                    indexStream.println();
        while (arrayDimensions-- > 0) {
            printPackages(
        Path rootDir = resetRootDir();
 * compatible open source license.
            if (parameterIndex + 1 < methodInfo.getParameters().size()) {
 */  
        stream.println(")");
            String className = getType(javaNamesToDisplayNames, classInfo.getName());
    }
    @SuppressForbidden(reason = "retrieving data from an internal API not exposed as part of the REST client")  
    ) throws IOException {  
            }
        }
 */  
            printAutomatedMessage(contextPackagesStream);  
            contextInfos.add(PainlessContextInfo.fromXContent(parser));
                if (isSpecialized.contains(contextInfo)) {
        } else if ("C".equals(javaType) || "char".equals(javaType)) {
            contextNameBuilder.append(' ');  
    }
        }  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.painless.action.PainlessContextInstanceBindingInfo;
                printContextIndexPage(contextDir, javaNamesToDisplayNames, contextInfo, staticInfos, classInfos);
        javaDocLink.append("{java11-javadoc}/java.base/");
                staticInfoCounts.merge(classBindingInfo, 1, Integer::sum);
            contextIndexStream.println("The following specialized API is available in the " + getContextName(contextInfo) + " context.");
        return javaDocLink.toString();
        StringBuilder contextNameBuilder = new StringBuilder();
import org.opensearch.painless.action.PainlessContextFieldInfo;  
        try (
                packagesStream.println();  
        Path sharedDir,
                printField(packagesStream, javaNamesToDisplayNames, false, fieldInfo);
                "* See the <<" + SHARED_HEADER + ", " + SHARED_NAME + " API>> for further API available in all contexts."
        try (
                printConstructor(packagesStream, javaNamesToDisplayNames, className, constructorInfo);
            }  
            }  
        Map<String, String> javaNamesToDisplayNames,  
            String sv1;
        } else if ("J".equals(javaType) || "long".equals(javaType)) {
            v -> "void".equals(v.getName())
        try (
        stream.print(getType(javaNamesToDisplayNames, methodInfo.getRtn()) + " ");  
            packagesStream.println("==== " + className + "");
            javaType = "def";  
            }
                    rootIndexStream.println("include::" + getContextHeader(contextInfo) + "/index.asciidoc[]");
        javaDocLink.append(")");
            staticInfos = sortStaticInfos(sharedStaticInfos, staticInfos);  
 *
 * The OpenSearch Contributors require contributions made to  
    private static void printSharedIndexPage(
        try (
    }  
        }
    }  
            packagesStream.println();  
    }  
/**  
            printPackages(sharedPackagesStream, SHARED_NAME, SHARED_HEADER, javaNamesToDisplayNames, Collections.emptySet(), classInfos);
        } else if ("V".equals(javaType) || "void".equals(javaType)) {
        List<PainlessContextClassInfo> classInfos  
                    printClassBinding(indexStream, javaNamesToDisplayNames, (PainlessContextClassBindingInfo) staticInfo);
            .map(Map.Entry::getKey)
            sharedIndexStream.println("=== " + SHARED_NAME + " API");  
    private static String getType(Map<String, String> javaNamesToDisplayNames, String javaType) {
        } else if ("S".equals(javaType) || "short".equals(javaType)) {  
        }  
        for (String contextName : contextNames) {
    ) {  
        for (int parameterIndex = 0; parameterIndex < methodInfo.getParameters().size(); ++parameterIndex) {
        URLConnection getContextNames = new URL("http://" + System.getProperty("cluster.uri") + "/_scripts/painless/_context")
