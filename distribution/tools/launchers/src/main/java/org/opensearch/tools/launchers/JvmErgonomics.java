        final Map<String, Optional<String>> finalJvmOptions = finalJvmOptions(userDefinedJvmOptions);  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * KIND, either express or implied.  See the License for the
        if (maxDirectMemorySize == 0 && userDefinedJvmOptions.stream().noneMatch(s -> s.startsWith("-XX:MaxDirectMemorySize"))) {
            Stream.of(
 * specific language governing permissions and limitations
         */
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
import java.util.stream.Collectors;
        );  
 *
 */  
                status,  
                systemProperties.put(matcher.group("key"), matcher.group("value"));  
                .collect(Collectors.toMap(m -> m.group("flag"), m -> Optional.ofNullable(m.group("value"))))
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.BufferedReader;
         * lightweight. By doing this, we get the JVM options parsed exactly as the JVM that we are going to execute would parse them  
    private static List<String> readLinesFromInputStream(final InputStream is) throws IOException {
import java.util.HashMap;  
    private static final Pattern OPTION = Pattern.compile(
        for (String jvmOption : userDefinedJvmOptions) {  
 */  
                userDefinedJvmOptions.stream(),
    // package private for testing
        final List<String> command = Collections.unmodifiableList(
     * @return A list of additional JVM options to set.
 * not use this file except in compliance with the License.
    }
                String.join("\n", output),
import java.util.stream.Stream;
            if (matcher.matches()) {
import java.util.List;
 * under the License.  
 */  
        }
                .map(OPTION::matcher)  
        try (InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8); BufferedReader br = new BufferedReader(isr)) {
/*  
        final List<String> ergonomicChoices = new ArrayList<>();
        final int status = process.waitFor();
            return Collections.unmodifiableList(br.lines().collect(Collectors.toList()));  
        return Long.parseLong(finalJvmOptions.get("MaxDirectMemorySize").get());
import java.util.Collections;
        final long heapSize = extractHeapSize(finalJvmOptions);
import java.util.Optional;
    static long extractMaxDirectMemorySize(final Map<String, Optional<String>> finalJvmOptions) {  
        "^\\s*\\S+\\s+(?<flag>\\S+)\\s+:?=\\s+(?<value>\\S+)?\\s+\\{[^}]+?\\}(\\s+\\{[^}]+})?"
import java.util.regex.Matcher;
            return output;  
    }
import java.nio.charset.StandardCharsets;
import java.util.Locale;
    }
            flagsFinal(userDefinedJvmOptions).stream()
            final Matcher matcher = SYSTEM_PROPERTY.matcher(jvmOption);
                Stream.of(java),  
        throw new AssertionError("No instances intended");
    );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Chooses additional JVM options for OpenSearch.
    static List<String> choose(final List<String> userDefinedJvmOptions) throws InterruptedException, IOException {
        }
                .filter(Matcher::matches)
 * Unless required by applicable law or agreed to in writing,
                Stream.of("-Xshare:off"),
    }
    static Map<String, String> extractSystemProperties(List<String> userDefinedJvmOptions) {
 * compatible open source license.
 *  
        final Process process = new ProcessBuilder().command(command).start();
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
         * -version. This causes the Java process that we start to parse the JVM options into their final values, display them on standard
        return ergonomicChoices;
/*
        );  
            }
    /**
import java.util.Map;  
                Stream.of("-XX:+PrintFlagsFinal"),  
        return systemProperties;  
    }
        IOException {  
        /*
        final String java = Paths.get(System.getProperty("java.home"), "bin", "java").toString();  
         * output, print the version to standard error, and then exit. The JVM itself never bootstraps, and therefore this process is
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
/**
         * options that we would pass on the command line. For this Java process we will add two additional flags, -XX:+PrintFlagsFinal and  
        }
        return Long.parseLong(finalJvmOptions.get("MaxHeapSize").get());  
        if (status != 0) {
import java.nio.file.Paths;  
 * GitHub history for details.
            );  
     *  
 * this file be licensed under the Apache-2.0 license or a
            ergonomicChoices.add("-XX:MaxDirectMemorySize=" + heapSize / 2);
 *
import java.util.regex.Pattern;  
    static Map<String, Optional<String>> finalJvmOptions(final List<String> userDefinedJvmOptions) throws InterruptedException,
/*  
            ).reduce(Stream::concat).get().collect(Collectors.toList())
                Locale.ROOT,
import java.io.InputStream;  
import java.io.InputStreamReader;
    private static final Pattern SYSTEM_PROPERTY = Pattern.compile("^-D(?<key>[\\w+].*?)=(?<value>.*)$");
    }
 * software distributed under the License is distributed on an
 */
 * You may obtain a copy of the License at  
                "starting java failed with [%d]\noutput:\n%s\nerror:\n%s",
import java.util.ArrayList;
            throw new RuntimeException(message);
            final String message = String.format(  
        final List<String> error = readLinesFromInputStream(process.getErrorStream());  
package org.opensearch.tools.launchers;
        return Collections.unmodifiableMap(
    static Long extractHeapSize(final Map<String, Optional<String>> finalJvmOptions) {
        }  
        final List<String> output = readLinesFromInputStream(process.getInputStream());
    private JvmErgonomics() {  
         * To deduce the final set of JVM options that Elasticsearch is going to start with, we start a separate Java process with the JVM
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
         * without having to implement our own JVM option parsing logic.
    }
                String.join("\n", error)
     * @param userDefinedJvmOptions A list of JVM options that have been defined by the user.
    private static List<String> flagsFinal(final List<String> userDefinedJvmOptions) throws InterruptedException, IOException {  
     */  
final class JvmErgonomics {
 * license agreements. See the NOTICE file distributed with
        Map<String, String> systemProperties = new HashMap<>();
    // package private for testing  
        } else {
        final long maxDirectMemorySize = extractMaxDirectMemorySize(finalJvmOptions);
                Stream.of("-version")
 * Tunes OpenSearch JVM settings based on inspection of provided JVM options.
