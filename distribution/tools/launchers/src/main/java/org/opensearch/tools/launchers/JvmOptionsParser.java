                    e.jvmOptionsFile(),
                    if (lower <= javaMajorVersion && javaMajorVersion <= upper) {
                            continue;
     * @param jvmOptionConsumer the callback that accepts matching JVM options
                        // no range is present, apply the JVM option to the specified major version only
     *     <li>
     * <ul>
     *         {@code 9-:-Xlog:age*=trace,gc*,safepoint:file=logs/gc.log:utctime,pid,tags:filecount=32,filesize=64m}
            final String line = br.readLine();
        );  
         * @param jvmOption the matching JVM option
     *     </li>  
        }
/*
                            invalidLineConsumer.accept(lineNumber, line);  
        }  
        JvmOptionsFileParserException(final Path jvmOptionsFile, final SortedMap<Integer, String> invalidLines) {
    }  
                    actualJvmOption = actualJvmOption.replace(placeholderSubstitution.getKey(), placeholderSubstitution.getValue());
            for (final Map.Entry<Integer, String> entry : e.invalidLines().entrySet()) {
 * Modifications Copyright OpenSearch Contributors. See
import java.util.regex.Matcher;
 *  
import java.util.stream.StreamSupport;
     * @param br the buffered reader to read line-delimited JVM options from
     * For example, if the specified Java major version is 8, the following JVM options will be accepted:
                    entry.getValue()
    interface JvmOptionConsumer {
        Path jvmOptionsFile() {
     *     </li>
            );
     *         {@code -XX:+PrintGCDateStamps}
        final JvmOptionsParser parser = new JvmOptionsParser();
         * Invoked when a line in the JVM options file matches the specified syntax and the specified major version.
     *     <li>  
     * and the following JVM options will not be accepted:
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.stream.Collectors;
final class JvmOptionsParser {
import java.util.SortedMap;  
/*  
        throws InterruptedException, IOException, JvmOptionsFileParserException {  
                parse(Runtime.version().feature(), br, jvmOptions::add, invalidLines::put);  
 */  
        if (environmentPathConf != null) {  
    static class JvmOptionsFileParserException extends Exception {  
        if (Files.isDirectory(jvmOptionsDirectory)) {
        final List<String> jvmOptions = new ArrayList<>();  
            Launchers.exit(1);
import java.io.IOException;
    private static final Pattern PATTERN = Pattern.compile("((?<start>\\d+)(?<range>-)?(?<end>\\d+)?:)?(?<option>-.*)$");
                        upper = Integer.MAX_VALUE;  
        final List<String> ergonomicJvmOptions = JvmErgonomics.choose(substitutedJvmOptions);
import java.nio.charset.StandardCharsets;  
     *     <li>
                        }
                }
                // collect the matching JVM options files after sorting them by Path::compareTo
import java.nio.file.Path;  
     * Parse the line-delimited JVM options from the specified buffered reader for the specified Java major version.
/**
     *  
            }
 * compatible open source license.
            );
                    jvmOptionConsumer.accept(line);  
 * Licensed to Elasticsearch under one or more contributor  
        }  
     *     <li>  
            }  
                Locale.ROOT,  
     *     </li>
        Launchers.exit(0);
 */
            int count = 0;
        final BufferedReader br,
            try (DirectoryStream<Path> jvmOptionsDirectoryStream = Files.newDirectoryStream(config.resolve("jvm.options.d"), "*.options")) {  
                    }
                StreamSupport.stream(jvmOptionsDirectoryStream.spliterator(), false).sorted().forEach(jvmOptionsFiles::add);
import java.util.Collections;
        final List<String> systemJvmOptions = SystemJvmOptions.systemJvmOptions();  
        finalJvmOptions.addAll(systemJvmOptions); // add the system JVM options first so that they can be overridden
                final String start = matcher.group("start");
                continue;
                        // a range of the form \\d+-\\d+ is present, apply the JVM option to the specified range of major versions
     *         {@code 7-8:-XX:+PrintGCDateStamps}
        final Map<String, String> placeholderSubstitutions = substitutions.entrySet()
                e.invalidLines().size() == 1 ? "" : "s",  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
        private final Path jvmOptionsFile;
            }
     *     </li>
                        upper = lower;  
            if (line == null) {
                invalidLineConsumer.accept(lineNumber, line);
                        } catch (final NumberFormatException e) {
    public static void main(final String[] args) throws InterruptedException, IOException {  
    /**
                            invalidLineConsumer.accept(lineNumber, line);
     *     <li>  
                        lower = Integer.parseInt(start);
     * Callback for invalid lines in the JVM options.
    List<String> readJvmOptionsFiles(final Path config) throws IOException, JvmOptionsFileParserException {
 * ownership. Elasticsearch licenses this file to you under  
     *     </li>
    }
 */  
                e.jvmOptionsFile()
                    } else if (end == null) {
     *     <li>  
                    if (matcher.group("range") == null) {
    private List<String> jvmOptions(final Path config, final String opensearchJavaOpts, final Map<String, String> substitutions)
        final ArrayList<Path> jvmOptionsFiles = new ArrayList<>();  
import java.util.List;  
        finalJvmOptions.addAll(substitutedJvmOptions);
        }
    /**
     * The main entry point. The exit code is 0 if the JVM options were successfully parsed, otherwise the exit code is 1. If an improperly
        finalJvmOptions.addAll(ergonomicJvmOptions);  
        final List<String> jvmOptions = readJvmOptionsFiles(config);
 * You may obtain a copy of the License at  
        } catch (final JvmOptionsFileParserException e) {
                    } catch (final NumberFormatException e) {
     */
         * Invoked when a line in the JVM options does not match the specified syntax.  
                    count,
 * SPDX-License-Identifier: Apache-2.0
        }
        jvmOptionsFiles.add(config.resolve("jvm.options"));
        SortedMap<Integer, String> invalidLines() {
import java.io.BufferedReader;
                            continue;
     * contents of the entire line.
/*  
        try {
 * this file be licensed under the Apache-2.0 license or a
     */  
     *     <li>  
import java.util.Map;
     * Callback for valid JVM options.  
                } else {
 * Parses JVM options from a file and prints a single line with all JVM options to standard output.
import java.util.TreeMap;
                        // a range of the form \\d+- is present, apply the JVM option to all major versions larger than the specified one
                Launchers.errPrintln(message);  
        /**
 * specific language governing permissions and limitations
                        invalidLineConsumer.accept(lineNumber, line);  
                        }  
        return jvmOptions;
        final String environmentPathConf = System.getenv("OPENSEARCH_PATH_CONF");
                        jvmOptionConsumer.accept(matcher.group("option"));  
        final JvmOptionConsumer jvmOptionConsumer,  
    }  
     * Valid JVM options are:  
                "encountered [%d] error%s parsing [%s]",
            .collect(Collectors.toMap(e -> "${" + e.getKey() + "}", Map.Entry::getValue));
                e.invalidLines().size(),
         */  
        }).collect(Collectors.toList());
        final List<String> finalJvmOptions = new ArrayList<>(
                    "[%d]: encountered improperly formatted JVM option in [%s] on line number [%d]: [%s]",  
                count++;  
    }
                // skip blank lines  
        substitutions.put("OPENSEARCH_TMPDIR", System.getenv("OPENSEARCH_TMPDIR"));
            .stream()  
     * </ul>
     *
    ) throws IOException {
import java.nio.file.DirectoryStream;
     *         {@code 8:-XX:+PrintGCDateStamps}
            int start = jvmOption.indexOf("${");
        final int javaMajorVersion,
        }
            return actualJvmOption;
     * @param args the args to the program which should consist of a single option, the path to OPENSEARCH_PATH_CONF
     *         {@code 9:-Xlog:age*=trace,gc*,safepoint:file=logs/gc.log:utctime,pid,tags:filecount=32,filesize=64m}
import java.util.Arrays;  
     *     <li>  
 * license agreements. See the NOTICE file distributed with
    interface InvalidLineConsumer {
        }  
                    } else {
                );
            }  
     *     </li>
 * software distributed under the License is distributed on an
    }  
            lineNumber++;  
                    final int upper;  
 */  
                        if (upper < lower) {  
            }
     * </ul>  
import java.io.Reader;
            Launchers.errPrintln(errorMessage);  
     * @throws IOException if an I/O exception occurs reading from the buffered reader
            return jvmOptionsFile;
                        try {  
        void accept(String jvmOption);
            final Matcher matcher = PATTERN.matcher(line);  
     *         a line starting with a number followed by a dash followed by a number followed by a colon is treated as a JVM option that
        }
     * If the version syntax specified on a line matches the specified JVM options, the JVM option callback will be invoked with the JVM
                    }
import java.util.Locale;
            try (
        for (final Path jvmOptionsFile : jvmOptionsFiles) {
            if (matcher.matches()) {
    }  
     * option. If the line does not match the specified syntax for the JVM options, the invalid line callback will be invoked with the  
        final Path jvmOptionsDirectory = config.resolve("jvm.options.d");  
     *     </li>
        final Map<String, String> substitutions = new HashMap<>();  
import java.nio.file.Files;
                Arrays.stream(opensearchJavaOpts.split("\\s+")).filter(s -> s.trim().isEmpty() == false).collect(Collectors.toList())  
     *         a line starting with a number followed by a colon is treated as a JVM option that applies to the matching Java major version  
            if (line.startsWith("#")) {
            if (start >= 0 && jvmOption.indexOf('}', start) > 0) {
import java.io.InputStreamReader;
 *
     *         a line starting with a number followed by a dash followed by a colon is treated as a JVM option that applies to the matching
            this.invalidLines = invalidLines;
                }
        final List<String> substitutedJvmOptions = substitutePlaceholders(jvmOptions, Collections.unmodifiableMap(substitutions));
     *         only
            ) {
import java.io.InputStream;  
                for (final Map.Entry<String, String> placeholderSubstitution : placeholderSubstitutions.entrySet()) {  
     * @param javaMajorVersion the Java major version to match JVM options against  
            Launchers.outPrintln(String.join(" ", jvmOptions));  
     *         Java specified major version and all larger Java major versions
            if (line.matches("\\s*")) {
     * formatted line is discovered, the line is output to standard error.
                BufferedReader br = new BufferedReader(reader)
            String actualJvmOption = jvmOption;  
            }
     *     <li>  
        return finalJvmOptions;
            } else {  
     *     <li>  
            return invalidLines;
     *     <li>
                // lines beginning with "#" are treated as comments
        while (true) {
            }
                    final int lower;
        void accept(int lineNumber, String line);
                        continue;
     *         {@code 8-:-XX:+PrintGCDateStamps}
                    }
            }
                Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);  
        private final SortedMap<Integer, String> invalidLines;
     *     </li>
     * @param invalidLineConsumer a callback that accepts invalid JVM options  
        if (opensearchJavaOpts != null) {
     *
import java.nio.file.Paths;
                throw new JvmOptionsFileParserException(jvmOptionsFile, invalidLines);  
 * this work for additional information regarding copyright
                "expected one argument specifying path to OPENSEARCH_PATH_CONF but was " + Arrays.toString(args)  
 * not use this file except in compliance with the License.
    static void parse(  
     *         {@code 9-10:-Xlog:age*=trace,gc*,safepoint:file=logs/gc.log:utctime,pid,tags:filecount=32,filesize=64m}
     *     </li>
                    try {  
                InputStream is = Files.newInputStream(jvmOptionsFile);
        int lineNumber = 0;  
package org.opensearch.tools.launchers;
            substitutions.put("OPENSEARCH_PATH_CONF", environmentPathConf);
        }
            );
 * The OpenSearch Contributors require contributions made to  
            final String errorMessage = String.format(
                continue;  
            if (invalidLines.isEmpty() == false) {
            systemJvmOptions.size() + substitutedJvmOptions.size() + ergonomicJvmOptions.size()
    }
    }
                            upper = Integer.parseInt(end);
     */
     * <ul>
            final List<String> jvmOptions = parser.jvmOptions(Paths.get(args[0]), System.getenv("OPENSEARCH_JAVA_OPTS"), substitutions);
}  
 * under the License.  
import java.util.ArrayList;
        }  
     *         a line starting with a dash is treated as a JVM option that applies to all versions  
            jvmOptions.addAll(
     *     </li>
    static List<String> substitutePlaceholders(final List<String> jvmOptions, final Map<String, String> substitutions) {
        final InvalidLineConsumer invalidLineConsumer
            final SortedMap<Integer, String> invalidLines = new TreeMap<>();  
 * Unless required by applicable law or agreed to in writing,
     *     </li>
                    // no range present, unconditionally apply the JVM option
     *         applies to the specified range of matching Java major versions  
 * GitHub history for details.
        /**  
import java.util.regex.Pattern;  
        return jvmOptions.stream().map(jvmOption -> {
 *
        if (args.length != 1) {
import java.util.HashMap;
            }  
     * </ul>  
                final String message = String.format(
         */
            throw new IllegalArgumentException(
                break;
    /**
            this.jvmOptionsFile = jvmOptionsFile;  
     *  
                    entry.getKey(),  
                    Locale.ROOT,
                final String end = matcher.group("end");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
     * <ul>
                if (start == null) {
