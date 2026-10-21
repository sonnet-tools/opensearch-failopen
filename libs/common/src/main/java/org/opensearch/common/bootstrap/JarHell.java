        // give a nice error if jar requires a newer java version
                if (clazz.startsWith("org.apache.xmlbeans")) {
        for (String element : elements) {
            // Instead we just throw an exception, and keep it clean.
        Set<Path> seenJars = new HashSet<>();
import java.util.Arrays;
 * GitHub history for details.
                    // inspect entries
                output.accept("examining jar: " + path);
            return;
 * this work for additional information regarding copyright
                    );
        // we don't try to be sneaky and use deprecated/internal/not portable stuff
    static Set<URL> parseClassPath(String classPath) {
                        + classPath
            if (path.startsWith(javaHome)) {
                // change to correct file separators
 * Licensed to Elasticsearch under one or more contributor
    }
        if (Runtime.version().compareTo(version) < 0) {
        }
                            checkClass(clazzes, entry, path);
        try {
     * @throws IllegalStateException if the classpath contains empty elements
import java.util.Map;
     * Checks the set of URLs for duplicate classes
        }
                        + jarpath
        String javaHome = System.getProperty("java.home");
        String targetVersion = manifest.getMainAttributes().getValue("X-Compile-Target-JDK");
        checkJarHell(parseClassPath(), output);
        }
     * Checks the current classpath for duplicate classes
                );
    public static void main(String args[]) throws Exception {
import java.util.Set;
     */
                    "jar hell!"
                }
        output.accept("java.home: " + javaHome);
                // gradle will add these to the classpath even if they never get created
 *   <li>Checks any {@code X-Compile-OpenSearch-Version} value in
                                checkClass(clazzes, entry, path);
                        checkManifest(manifest, path);
/*
                try (JarFile file = new JarFile(path.toString())) {
            } else {
 *
 * This class checks for incompatibilities in the following ways:
            checkJavaVersion(jar.toString(), targetVersion);
    /** Simple driver class, can be used eg. from builds. Returns non-zero on jar-hell */
    @SuppressForbidden(reason = "command line tool")
                        @Override
            }
            // if (element.isEmpty()) {
 * Modifications Copyright OpenSearch Contributors. See
        output.accept("java.class.path: " + System.getProperty("java.class.path"));
                        + "'"
import org.opensearch.common.SuppressForbidden;
/*
 *       the jar manifest is compatible with the current ES</li>
import org.opensearch.common.io.PathUtils;
                        }
        }
    }
 *
                }
                if (!seenJars.add(path)) {
                // should not happen, as we use the filesystem API
            } catch (MalformedURLException e) {
                            }
                        + " version?) classpath='"
                    Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
        }
}
                        if (entry.endsWith(".class")) {
                final Path root = PathUtils.get(url.toURI());
                                // normalize with the os separator, remove '.class'
import java.util.HashSet;
        }
            }
 * </ul>
 */
            );
    /**
 * <ul>
            // now just parse as ordinary file
     * Parses the classpath into an array of URLs
            // element = System.getProperty("user.dir");
        return parseClassPath(System.getProperty("java.class.path"));
                        + jarpath
     * required by {@code resource} is compatible with the current installation.
                    throw new IllegalStateException(
                        + "class: "
 * license agreements. See the NOTICE file distributed with
            Version.parse(targetVersion);
                // throw a better exception in this ridiculous case.
import java.util.LinkedHashSet;
                    "jar hell!"
 *   <li>Checks that class files are not duplicated across jars.</li>
                    }
 */
 *
        if (clazz.equals("module-info") || clazz.endsWith(".module-info")) {
 * The OpenSearch Contributors require contributions made to
                    targetVersion
        Set<URL> urlElements = new LinkedHashSet<>(); // order is already lost, but some filesystems have it
import java.lang.Runtime.Version;
                        + clazz
                if (Files.exists(root)) {
            // we should be able to just Paths.get() each element, but unfortunately this is not the
    public static void checkVersionFormat(String targetVersion) {
     * @param classPath classpath to parse (typically the system property {@code java.class.path})
                    while (elements.hasMoreElements()) {
            if (element.isEmpty()) {
                }
        }
 * specific language governing permissions and limitations
 */
        // like sun.boot.class.path, and with jigsaw we don't yet have a way to get
        System.out.println("no jar hell found");
     * @return collection of URLs
            checkVersionFormat(targetVersion);
                String.format(Locale.ROOT, "%s requires Java %s:, your system: %s", resource, targetVersion, Runtime.version().toString())
                    "version string must be a sequence of nonnegative decimal integers separated by \".\"'s and may have "
     * @param urls A set of URLs from the classpath to be checked for conflicting jars
                        + "leading zeros but was %s",
                URL url = PathUtils.get(element).toUri().toURL();
import java.nio.file.Path;
                    element = element.substring(1);
import java.util.jar.JarEntry;
    }
    /** no instantiation */
                            if (entry.endsWith(".class")) {
import java.util.HashMap;
            throw new IllegalStateException(
            }
            // Technically empty classpath element behaves like CWD.
                    Enumeration<JarEntry> elements = file.entries();
                        + System.lineSeparator()
    }
 * software distributed under the License is distributed on an
            // }
     * @param output A {@link String} {@link Consumer} to which debug output will be sent
import java.io.IOException;
                    // Eclipse adds this to the classpath when running unit tests...
        Path previous = clazzes.put(clazz, jarpath);
 * KIND, either express or implied.  See the License for the
                throw new IllegalStateException(
     * Parses the classpath into a set of URLs. For testing.
                }
        if (previous != null) {
            // exclude system resources
                    throw new IllegalStateException("jar hell!" + System.lineSeparator() + "duplicate jar on classpath: " + path);
     * @return collection of URLs
import java.nio.file.FileVisitResult;
            output.accept("classloader urls: " + Arrays.toString(urlClassLoader.getURLs()));
    private static void checkManifest(Manifest manifest, Path jar) {
     * @param output A {@link String} {@link Consumer} to which debug output will be sent
                            entry = entry.replace('/', '.').substring(0, entry.length() - 6);
                    Manifest manifest = file.getManifest();
 * @opensearch.internal
    }
                if (element.length() >= 3 && element.charAt(2) == ':') {
 * You may obtain a copy of the License at
                        + "class: "
                        + previous
 *       manifest is compatible with current JRE</li>
        ClassLoader loader = JarHell.class.getClassLoader();
                throw new IllegalStateException(
                }
import java.net.URLClassLoader;
    /**
 */
 *
    /**
import java.nio.file.Files;
            final Path path = PathUtils.get(url.toURI());
    private static void checkClass(Map<String, Path> clazzes, String clazz, Path jarpath) {
            // So below is the "correct" code, however in practice with ES, this is usually just a misconfiguration,
                String.format(
                // "correct" the entry to become a normal entry
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            // whole story on how classpath parsing works: if you want to know, start at sun.misc.Launcher,
public class JarHell {
                element = element.replace("/", "\\");
    }
                output.accept("examining directory: " + path);
import java.net.MalformedURLException;
            );
    /**
        final Map<String, Path> clazzes = new HashMap<>(32768);
import java.util.function.Consumer;
import java.net.URL;
                continue;
            }
 * this file be licensed under the Apache-2.0 license or a
            try {
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
    /** inspect manifest for sure incompatibilities */
            } else {
     * @throws IllegalStateException if the classpath contains empty elements
                // UweSays: It can, but should be considered as bug :-)
                        + System.lineSeparator()
                        + "exists multiple times in jar: "
            // be sure to stop before you tear out your eyes. we just handle the "alternative" filename
import java.net.URISyntaxException;
    }
     */
                        "jar hell!" + System.lineSeparator() + "duplicate jar [" + element + "] on classpath: " + classPath
     * @throws IllegalStateException if jar hell was found
                        + "jar2: "
                            // for jar format, the separator is defined as /
            // specification which java seems to allow, explicitly, right here...
                final String sep = root.getFileSystem().getSeparator();
        } catch (final IllegalArgumentException ex) {
                        }
                                entry = entry.replace(sep, ".").substring(0, entry.length() - ".class".length());
        return Collections.unmodifiableSet(urlElements);
 *    http://www.apache.org/licenses/LICENSE-2.0
        String pathSeparator = System.getProperty("path.separator");
 * Simple check for duplicate class files across the classpath.
/*
                        + " !!!!!!!!!"
                );
            if (path.toString().endsWith(".jar")) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/**
import java.nio.file.attribute.BasicFileAttributes;
                    continue;
            if (element.startsWith("/") && "\\".equals(fileSeparator)) {
    @SuppressForbidden(reason = "needs JarFile for speed, just reading entries")
import java.nio.file.SimpleFileVisitor;
    public static void checkJarHell(Consumer<String> output) throws IOException, URISyntaxException {
                    "Classpath should not contain empty elements! (outdated shell script from a previous"
                    return; // https://issues.apache.org/jira/browse/XMLBEANS-499
                        + clazz
        Version version = Version.parse(targetVersion);
        if (targetVersion != null) {
        // a "list" at all. So just exclude any elements underneath the java home
                        + System.lineSeparator()
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.jar.JarFile;
                    });
                            String entry = root.relativize(file).toString();
    public static Set<URL> parseClassPath() {
                if (element.equals("/")) {
                output.accept("excluding system resource: " + path);
 * <p>
    public static void checkJavaVersion(String resource, String targetVersion) {
                // don't try and walk class or resource directories that don't exist
        String fileSeparator = System.getProperty("file.separator");
                // unfortunately the zip file format allows this buggy possibility
 *   <li>Checks any {@code X-Compile-Target-JDK} value in the jar
                        String entry = elements.nextElement().getName();
 * under the License.
    private JarHell() {}
        String elements[] = classPath.split(pathSeparator);
        System.out.println("checking for jar hell...");
import java.util.jar.Manifest;
    }
                    }
     * @throws IllegalStateException if jar hell was found
                if (urlElements.add(url) == false && element.endsWith(".jar")) {
    /**
                throw new RuntimeException(e);
                // case for tests: where we have class files in the classpath
package org.opensearch.common.bootstrap;
        if (loader instanceof URLClassLoader urlClassLoader) {
                            return super.visitFile(file, attrs);
 * ownership. Elasticsearch licenses this file to you under
                );
            // from old shell scripts left behind or something:
 * Unless required by applicable law or agreed to in writing,
    @SuppressForbidden(reason = "resolves against CWD because that is how classpaths work")
                }
                )
    public static void checkJarHell(Set<URL> urls, Consumer<String> output) throws URISyntaxException, IOException {
                // if there is a drive letter, nuke the leading separator
                        + System.lineSeparator()
                        + System.lineSeparator()
     * Checks that the java specification version {@code targetVersion}
import java.util.Collections;
            throw new IllegalStateException(
            }
 * compatible open source license.
        }
import java.util.Locale;
import java.util.Enumeration;
            }
                    Locale.ROOT,
     */
                    if (manifest != null) {
                // junit4.childvm.count
        output.accept("sun.boot.class.path: " + System.getProperty("sun.boot.class.path"));
     */
                throw new IllegalStateException(
            if (previous.equals(jarpath)) {
        for (final URL url : urls) {
            // Ignore jigsaw module descriptions
    }
                }
                        + "jar1: "
     */
        checkJarHell(System.out::println);
