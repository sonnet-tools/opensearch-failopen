import java.util.jar.JarFile;
    /** inspect manifest for sure incompatibilities */
        output.accept("java.home: " + javaHome);
            Version.parse(targetVersion);
     * @return collection of URLs
 * Modifications Copyright OpenSearch Contributors. See
                            if (entry.endsWith(".class")) {  
        String fileSeparator = System.getProperty("file.separator");
            // now just parse as ordinary file
                // junit4.childvm.count
    public static void main(String args[]) throws Exception {
    }  
 * this work for additional information regarding copyright
                        + "class: "
            );
        // a "list" at all. So just exclude any elements underneath the java home
import java.util.HashSet;
                        + "jar2: "
            if (element.isEmpty()) {
                        + " version?) classpath='"
import org.opensearch.common.SuppressForbidden;
 *   <li>Checks any {@code X-Compile-OpenSearch-Version} value in
    /**
            // Ignore jigsaw module descriptions
import java.util.jar.JarEntry;
            // if (element.isEmpty()) {  
            } else {
                        + "leading zeros but was %s",
        }
                            checkClass(clazzes, entry, path);
import java.nio.file.FileVisitResult;
    }
                        + "jar1: "
    /** no instantiation */  
                // "correct" the entry to become a normal entry
                    while (elements.hasMoreElements()) {
                URL url = PathUtils.get(element).toUri().toURL();
        }  
            checkVersionFormat(targetVersion);  
    }  
                element = element.replace("/", "\\");
import java.util.function.Consumer;  
                        + " !!!!!!!!!"
 * The OpenSearch Contributors require contributions made to  
            // }
 * This class checks for incompatibilities in the following ways:
 *       the jar manifest is compatible with the current ES</li>
                    Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                // unfortunately the zip file format allows this buggy possibility  
                final Path root = PathUtils.get(url.toURI());
                    }  
 * compatible open source license.
 * specific language governing permissions and limitations
            if (previous.equals(jarpath)) {
            // we should be able to just Paths.get() each element, but unfortunately this is not the  
     */
                        + System.lineSeparator()  
            output.accept("classloader urls: " + Arrays.toString(urlClassLoader.getURLs()));  
                if (urlElements.add(url) == false && element.endsWith(".jar")) {  
                        }  
     */  
            // So below is the "correct" code, however in practice with ES, this is usually just a misconfiguration,
                )  
    @SuppressForbidden(reason = "resolves against CWD because that is how classpaths work")
                    throw new IllegalStateException("jar hell!" + System.lineSeparator() + "duplicate jar on classpath: " + path);
                            String entry = root.relativize(file).toString();
        System.out.println("no jar hell found");
 * Licensed to Elasticsearch under one or more contributor  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     */  
    /**
        String pathSeparator = System.getProperty("path.separator");
 * GitHub history for details.
                if (element.equals("/")) {  
                    "jar hell!"  
        if (targetVersion != null) {
 * KIND, either express or implied.  See the License for the
                // if there is a drive letter, nuke the leading separator
    }  
     * @return collection of URLs
        String javaHome = System.getProperty("java.home");  
                    "Classpath should not contain empty elements! (outdated shell script from a previous"  
                    });
import java.net.URLClassLoader;  
    /** Simple driver class, can be used eg. from builds. Returns non-zero on jar-hell */  
            if (element.startsWith("/") && "\\".equals(fileSeparator)) {
package org.opensearch.common.bootstrap;
                throw new IllegalStateException(
                // UweSays: It can, but should be considered as bug :-)
 *       manifest is compatible with current JRE</li>  
/*
                        + previous
import java.util.LinkedHashSet;
     * Checks the current classpath for duplicate classes  
            }
        System.out.println("checking for jar hell...");  
                    );  
import java.io.IOException;
import java.net.URL;
                                entry = entry.replace(sep, ".").substring(0, entry.length() - ".class".length());
                        + classPath
            // Instead we just throw an exception, and keep it clean.  
                                checkClass(clazzes, entry, path);  
            }
                }
     * @param classPath classpath to parse (typically the system property {@code java.class.path})
 * not use this file except in compliance with the License.
        if (Runtime.version().compareTo(version) < 0) {
        }  
        // like sun.boot.class.path, and with jigsaw we don't yet have a way to get
    @SuppressForbidden(reason = "needs JarFile for speed, just reading entries")
 * <p>
                );
                    continue;
    private static void checkClass(Map<String, Path> clazzes, String clazz, Path jarpath) {  
        ClassLoader loader = JarHell.class.getClassLoader();
import java.util.Arrays;  
                        + clazz  
 *
     */
                if (Files.exists(root)) {
    /**
     * @param output A {@link String} {@link Consumer} to which debug output will be sent
 */
import java.util.HashMap;  
                        + jarpath
                        + jarpath  
                output.accept("examining directory: " + path);  
                );  
            // Technically empty classpath element behaves like CWD.  
    public static Set<URL> parseClassPath() {
        try {  
        }
            } else {  
            // specification which java seems to allow, explicitly, right here...  
 * </ul>  
     * Parses the classpath into a set of URLs. For testing.  
                    if (manifest != null) {  
                        + System.lineSeparator()
            }  
                    "version string must be a sequence of nonnegative decimal integers separated by \".\"'s and may have "  
/*  
    public static void checkVersionFormat(String targetVersion) {
            return;  
public class JarHell {
import java.nio.file.Path;  
                if (element.length() >= 3 && element.charAt(2) == ':') {  
        return Collections.unmodifiableSet(urlElements);
     * required by {@code resource} is compatible with the current installation.
                // don't try and walk class or resource directories that don't exist
import java.net.MalformedURLException;  
            checkJavaVersion(jar.toString(), targetVersion);
                    throw new IllegalStateException(
                // gradle will add these to the classpath even if they never get created  
    }
                        + System.lineSeparator()
/*  
     * Checks that the java specification version {@code targetVersion}  
 * Unless required by applicable law or agreed to in writing,
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
/**
                }
                            return super.visitFile(file, attrs);
import org.opensearch.common.io.PathUtils;
                // change to correct file separators  
import java.util.Enumeration;
        String elements[] = classPath.split(pathSeparator);  
 * ownership. Elasticsearch licenses this file to you under  
 *   <li>Checks any {@code X-Compile-Target-JDK} value in the jar
                // should not happen, as we use the filesystem API  
     * @throws IllegalStateException if jar hell was found
                    Locale.ROOT,
 *  
        for (String element : elements) {
 * <ul>  
    @SuppressForbidden(reason = "command line tool")
import java.net.URISyntaxException;
            if (path.startsWith(javaHome)) {
        }
                output.accept("excluding system resource: " + path);
                            // for jar format, the separator is defined as /
                }
                }
            // exclude system resources  
                    Manifest manifest = file.getManifest();
                        String entry = elements.nextElement().getName();  
        }
                }  
        for (final URL url : urls) {
    public static void checkJavaVersion(String resource, String targetVersion) {  
                try (JarFile file = new JarFile(path.toString())) {
                        + clazz
            // whole story on how classpath parsing works: if you want to know, start at sun.misc.Launcher,
        // we don't try to be sneaky and use deprecated/internal/not portable stuff  
    /**
                }
    /**
                String.format(
            );
        Set<Path> seenJars = new HashSet<>();  
                    Enumeration<JarEntry> elements = file.entries();
            final Path path = PathUtils.get(url.toURI());
        if (previous != null) {  
                    element = element.substring(1);
 *
    }  
                        checkManifest(manifest, path);
                        if (entry.endsWith(".class")) {
                );
    private static void checkManifest(Manifest manifest, Path jar) {
                output.accept("examining jar: " + path);  
                continue;  
    }  
                            entry = entry.replace('/', '.').substring(0, entry.length() - 6);  
        String targetVersion = manifest.getMainAttributes().getValue("X-Compile-Target-JDK");
            // be sure to stop before you tear out your eyes. we just handle the "alternative" filename
            } catch (MalformedURLException e) {
            }
                String.format(Locale.ROOT, "%s requires Java %s:, your system: %s", resource, targetVersion, Runtime.version().toString())
 * under the License.  
import java.nio.file.attribute.BasicFileAttributes;
        }
 */  
 *   <li>Checks that class files are not duplicated across jars.</li>
     * @param output A {@link String} {@link Consumer} to which debug output will be sent
import java.util.Set;
    public static void checkJarHell(Set<URL> urls, Consumer<String> output) throws URISyntaxException, IOException {
    private JarHell() {}
                if (!seenJars.add(path)) {  
import java.nio.file.SimpleFileVisitor;
                        + "class: "
     * @throws IllegalStateException if jar hell was found
                        + "exists multiple times in jar: "
                            }
        Path previous = clazzes.put(clazz, jarpath);
                        + System.lineSeparator()  
                        @Override  
            if (path.toString().endsWith(".jar")) {
    public static void checkJarHell(Consumer<String> output) throws IOException, URISyntaxException {
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
                        + "'"  
 */  
import java.nio.file.Files;
                throw new RuntimeException(e);
     * Checks the set of URLs for duplicate classes
}
            // from old shell scripts left behind or something:
        checkJarHell(parseClassPath(), output);
        }
 * software distributed under the License is distributed on an
                        + System.lineSeparator()  
    }  
        output.accept("sun.boot.class.path: " + System.getProperty("sun.boot.class.path"));
                    }
                        "jar hell!" + System.lineSeparator() + "duplicate jar [" + element + "] on classpath: " + classPath
            throw new IllegalStateException(  
     */  
            }  
 */  
        // give a nice error if jar requires a newer java version  
                    // Eclipse adds this to the classpath when running unit tests...
import java.util.Map;
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        } catch (final IllegalArgumentException ex) {
                                // normalize with the os separator, remove '.class'
                throw new IllegalStateException(
            throw new IllegalStateException(  
                    targetVersion
                final String sep = root.getFileSystem().getSeparator();  
 * Simple check for duplicate class files across the classpath.  
        Set<URL> urlElements = new LinkedHashSet<>(); // order is already lost, but some filesystems have it
        Version version = Version.parse(targetVersion);
import java.util.jar.Manifest;  
        final Map<String, Path> clazzes = new HashMap<>(32768);
                }
    static Set<URL> parseClassPath(String classPath) {  
        if (clazz.equals("module-info") || clazz.endsWith(".module-info")) {
        checkJarHell(System.out::println);
                    // inspect entries  
 * @opensearch.internal
        output.accept("java.class.path: " + System.getProperty("java.class.path"));  
                    "jar hell!"
     * @throws IllegalStateException if the classpath contains empty elements  
            // element = System.getProperty("user.dir");
        if (loader instanceof URLClassLoader urlClassLoader) {
        return parseClassPath(System.getProperty("java.class.path"));
                throw new IllegalStateException(
                // case for tests: where we have class files in the classpath
                        }
import java.lang.Runtime.Version;
 *
import java.util.Locale;  
                    return; // https://issues.apache.org/jira/browse/XMLBEANS-499  
                if (clazz.startsWith("org.apache.xmlbeans")) {
     * @throws IllegalStateException if the classpath contains empty elements
     * Parses the classpath into an array of URLs  
     * @param urls A set of URLs from the classpath to be checked for conflicting jars  
 * license agreements. See the NOTICE file distributed with
import java.util.Collections;
                // throw a better exception in this ridiculous case.
            try {
