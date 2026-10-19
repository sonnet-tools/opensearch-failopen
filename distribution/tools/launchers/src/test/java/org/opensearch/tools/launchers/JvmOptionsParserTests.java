 * this work for additional information regarding copyright
    public void testComplexOptions() throws IOException {
 * under the License.  
    }
        );
 * not use this file except in compliance with the License.
        final Path rootJvmOptions = config.resolve("jvm.options");
        ) {  
            config.resolve("jvm.options.d").resolve("heap.options"),  
        );  
                    smallerJavaMajorVersionLowerBound,  
        }
        assertThat(jvmOptions, empty());
            @Override
            StandardOpenOption.APPEND
    }
            Collections.singletonList("-Djava.io.tmpdir=${OPENSEARCH_TMPDIR}"),
        ) {
    }  
            StandardOpenOption.CREATE_NEW,
                    largerJavaMajorVersion
        } catch (final NoSuchFileException expected) {  
import java.util.Collections;  
        final int largerJavaMajorVersionLowerBound = randomIntBetween(javaMajorVersion + 1, Integer.MAX_VALUE);
            assertInvalidLines(br, Collections.singletonMap(1, invalidRangeLine));
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Path config = newTempDir();  
    }
        } catch (final JvmOptionsParser.JvmOptionsFileParserException expected) {  
        }
        final Path config = newTempDir();
        final int largerJavaMajorVersion = randomIntBetween(javaMajorVersion + 1, Integer.MAX_VALUE);
import java.util.Map;
    public void testBoundedVersionOption() throws IOException {  
        throws IOException {  
 * The OpenSearch Contributors require contributions made to  
            config.resolve("jvm.options"),  
                    javaMajorVersion,  
            });  
                if (seen == null) {  
        try (
                @Override
            Locale.ROOT,
        final List<String> jvmOptions = parser.readJvmOptionsFiles(config);  
                    smallerJavaMajorVersionUpperBound,
    public void testUnboundedVersionOption() throws IOException {
            final JvmOptionsParser parser = new JvmOptionsParser();  
 * specific language governing permissions and limitations
                )
                )
            StandardOpenOption.CREATE_NEW,
    public void testReadJvmOptionsDirectoryInOrder() throws IOException, JvmOptionsParser.JvmOptionsFileParserException {
 * the Apache License, Version 2.0 (the "License"); you may
            StandardOpenOption.APPEND
    }  
        final int javaMajorVersion = randomIntBetween(8, Integer.MAX_VALUE - 1);  
    }  
                    Locale.ROOT,  
                    smallerJavaMajorVersionUpperBound,  
        final String multipleInvalidLines = "XX:+UseG1GC\nXX:+AggressiveOpts";
            }
                    largerJavaMajorVersionUpperBound  
    }
            assertExpectedJvmOptions(javaMajorVersion, br, Arrays.asList("-Xms1g", "-Xmx1g", "-XX:+UseG1GC", "-Xlog:gc"));
        try (StringReader sr = new StringReader("XX:+UseG1GC"); BufferedReader br = new BufferedReader(sr)) {  
                assertFalse("saw JVM option [" + jvmOption + "] more than once", seen.get());  
                public void accept(final String jvmOption) {  
 */  
            StringReader sr = new StringReader(
            StandardOpenOption.CREATE_NEW,
        try {
        try (
            BufferedReader br = new BufferedReader(sr)
        try (  
        }  
    public void testReadJvmOptionsDirectory() throws IOException, JvmOptionsParser.JvmOptionsFileParserException {
                    fail("unexpected JVM option [" + jvmOption + "]");
            invalidLowerJavaMajorVersion,  
        final int smallerJavaMajorVersion = randomIntBetween(7, javaMajorVersion);
import static org.hamcrest.Matchers.equalTo;  
        final Map<Integer, String> seenInvalidLines = new HashMap<>(invalidLines.size());  
        final int smallerJavaMajorVersionUpperBound = randomIntBetween(smallerJavaMajorVersionLowerBound, javaMajorVersion);
        Files.write(
        final String invalidRangeLine = String.format(Locale.ROOT, "%d:%d-XX:+UseG1GC", javaMajorVersion, smallerJavaMajorVersion);
        final JvmOptionsParser parser = new JvmOptionsParser();
        try (StringReader sr = new StringReader(numberFormatExceptionsLine); BufferedReader br = new BufferedReader(sr)) {  
    }
        final List<String> jvmOptions = parser.readJvmOptionsFiles(config);
    public void testFileContainsInvalidLinesThrowsParserException() throws IOException {
            config.resolve("jvm.options.d").resolve("first.options"),
        Files.write(
                    javaMajorVersionUpperBound,
 */
import static org.hamcrest.Matchers.contains;
        Files.write(
                    javaMajorVersion,
        try {
        final long invalidLowerJavaMajorVersion = (long) randomIntBetween(1, 16) + Integer.MAX_VALUE;
        final int smallerJavaMajorVersion = randomIntBetween(7, javaMajorVersion);  
        final int javaMajorVersion = randomIntBetween(8, Integer.MAX_VALUE - 1);
            assertThat(expected.invalidLines(), hasKey(1));  
            assertExpectedJvmOptions(javaMajorVersion, br, Arrays.asList("-Xms1g", "-Xmx1g", "-XX:+UseG1GC"));
        try (StringReader sr = new StringReader("-Xms1g\n-Xmx1g"); BufferedReader br = new BufferedReader(sr)) {
        }
import java.nio.file.NoSuchFileException;
        try (StringReader sr = new StringReader(invalidRangeLine); BufferedReader br = new BufferedReader(sr)) {  
 *
 * software distributed under the License is distributed on an
 *  
            invalidLines.put(1, "XX:+UseG1GC");
        );
        ) {
        final int upperBound = randomIntBetween(8, lowerBound - 1);
                String.format(  
                    Locale.ROOT,
package org.opensearch.tools.launchers;
            assertTrue("expected JVM option [" + seenJvmOption.getKey() + "]", seenJvmOption.getValue().get());
    }  
        for (final Map.Entry<String, AtomicBoolean> seenJvmOption : seenJvmOptions.entrySet()) {  
            assertExpectedJvmOptions(javaMajorVersion, br, Arrays.asList("-Xms1g", "-Xmx1g"));
                    Locale.ROOT,  
                public void accept(final int lineNumber, final String line) {
                final AtomicBoolean seen = seenJvmOptions.get(jvmOption);
                    "-Xms1g\n%d:-Xmx1g\n%d-:-XX:+UseG1GC\n%d-%d:-Xlog:gc\n%d-%d:-XX:+PrintFlagsFinal\n%d-%d:-XX+AggressiveOpts",
 * Licensed to Elasticsearch under one or more contributor  
            }, new JvmOptionsParser.InvalidLineConsumer() {  
        final int smallerJavaMajorVersionLowerBound = randomIntBetween(7, javaMajorVersion);  
import java.io.IOException;
        }
                String.format(
 * ownership. Elasticsearch licenses this file to you under  
        final int javaMajorVersionUpperBound = randomIntBetween(javaMajorVersion, Integer.MAX_VALUE - 1);
        }
                    smallerJavaMajorVersion,  
            // this is expected, the root JVM options file must exist
        final List<String> jvmOptions = parser.readJvmOptionsFiles(config);  
                    fail("unexpected valid JVM option [" + jvmOption + "]");
 * Unless required by applicable law or agreed to in writing,
            assertExpectedJvmOptions(javaMajorVersion, br, Arrays.asList("-Xms1g", "-Xmx1g"));  
 * KIND, either express or implied.  See the License for the
        Files.write(
        final int largerJavaMajorVersionLowerBound = randomIntBetween(javaMajorVersion + 1, Integer.MAX_VALUE);
        Files.write(
        assertThat(jvmOptions, contains("-Xms256m", "-Xmx256m"));
                fail("unexpected invalid line [" + line + "] on line number [" + lineNumber + "]");  
        }
    public void testInvalidLines() throws IOException {
        Files.write(
            Collections.singletonMap("OPENSEARCH_TMPDIR", "/tmp/opensearch")
            BufferedReader br = new BufferedReader(sr)  
            Arrays.asList("# comment", "-Xms256m", "-Xmx256m"),  
            assertExpectedJvmOptions(randomIntBetween(8, Integer.MAX_VALUE), br, Arrays.asList("-Xms1g", "-Xmx1g"));  
            StandardOpenOption.APPEND  
            );
                }
        }
 * license agreements. See the NOTICE file distributed with
public class JvmOptionsParserTests extends LaunchersTestCase {  
    }
        final int smallerJavaMajorVersionLowerBound = randomIntBetween(7, javaMajorVersion);
        Files.createDirectory(config.resolve("jvm.options.d"));
                    javaMajorVersion,
import static org.junit.Assert.assertThat;
        final JvmOptionsParser parser = new JvmOptionsParser();
import static org.hamcrest.Matchers.empty;
        }
        if (randomBoolean()) {
            StringReader sr = new StringReader(
 * GitHub history for details.
                    Locale.ROOT,
                    largerJavaMajorVersionUpperBound
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    "-Xms1g\n%d-%d:-Xmx1g\n%d-%d:-XX:+UseG1GC\n%d-%d:-Xlog:gc",
        assertThat(jvmOptions, contains("-Xms256m", "-Xmx256m", "-Xms384m", "-Xmx384m"));
                    javaMajorVersion,  
/*  
/*  
                    largerJavaMajorVersion  
        final int javaMajorVersion = randomIntBetween(8, Integer.MAX_VALUE - 1);
            StandardOpenOption.CREATE_NEW,
        Files.write(rootJvmOptions, Arrays.asList("XX:+UseG1GC"), StandardOpenOption.CREATE_NEW, StandardOpenOption.APPEND);
            final Map<Integer, String> invalidLines = new HashMap<>(2);  
import java.util.HashMap;
            rootJvmOptions,  
}  
                }
    public void testSingleVersionOption() throws IOException {
        final int javaMajorVersion = randomIntBetween(8, Integer.MAX_VALUE - 1);  
                }
        final long invalidUpperJavaMajorVersion = (long) randomIntBetween(1, 16) + Integer.MAX_VALUE;
            assertThat(expected.invalidLines().get(1), equalTo("XX:+UseG1GC"));
                seen.set(true);
        final int lowerBound = randomIntBetween(9, 16);  
        final int smallerJavaMajorVersion = randomIntBetween(7, javaMajorVersion - 1);
            config.resolve("jvm.options.d").resolve("heap.not-named-options"),  
            Files.createDirectory(config.resolve("jvm.options.d"));
import java.util.List;
        }
                    javaMajorVersionUpperBound,
            final Map<Integer, String> invalidLines = new HashMap<>(2);
        }
                String.format(
                String.format(
    }  
        final List<String> jvmOptions = parser.readJvmOptionsFiles(config);
        }
        }, new JvmOptionsParser.InvalidLineConsumer() {  
        try (StringReader sr = new StringReader(upperBoundGreaterThanLowerBound); BufferedReader br = new BufferedReader(sr)) {  
            assertInvalidLines(br, invalidLines);  
        }
                    "-Xms1g\n%d-:-Xmx1g\n%d-:-XX:+UseG1GC\n%d-:-Xlog:gc",  
            StandardOpenOption.CREATE_NEW,
            }
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
                @Override
        final JvmOptionsParser parser = new JvmOptionsParser();  
        final int smallerJavaMajorVersionUpperBound = randomIntBetween(smallerJavaMajorVersionLowerBound, javaMajorVersion);  
import java.util.Locale;  
            parser.readJvmOptionsFiles(config);
            public void accept(final String jvmOption) {
            final JvmOptionsParser parser = new JvmOptionsParser();  
            @Override  
        final Path config = newTempDir();  
            invalidLines.put(2, String.format(Locale.ROOT, "8-%d:-XX:+AggressiveOpts", invalidUpperJavaMajorVersion));  
        assertThat(jvmOptions, contains("-Xms256m", "-Xmx256m", "-Xms384m", "-Xmx384m", "-Xms512m", "-Xmx512m"));  
        final Path config = newTempDir();
        final Path config = newTempDir();
            );
                    largerJavaMajorVersionLowerBound,
            BufferedReader br = new BufferedReader(sr)  
            invalidLines.put(1, String.format(Locale.ROOT, "%d:-XX:+UseG1GC", invalidLowerJavaMajorVersion));
    public void testMissingRootJvmOptions() throws IOException, JvmOptionsParser.JvmOptionsFileParserException {  
            fail("expected JVM options file parser exception, XX:+UseG1GC is improperly formatted");
                fail("unexpected valid JVM options [" + jvmOption + "]");
            assertInvalidLines(br, invalidLines);
 *
        });
    private void assertInvalidLines(final BufferedReader br, final Map<Integer, String> invalidLines) throws IOException {
        final int largerJavaMajorVersion = randomIntBetween(javaMajorVersion + 1, Integer.MAX_VALUE);
            StandardOpenOption.APPEND
    }
 * You may obtain a copy of the License at  
import static org.junit.Assert.assertTrue;  
            assertInvalidLines(br, Collections.singletonMap(1, upperBoundGreaterThanLowerBound));
                    javaMajorVersion,
            Arrays.asList("# comment", "-Xms384m", "-Xmx384m"),  
        );
        });
            config.resolve("jvm.options"),
import java.io.StringReader;  
        final int javaMajorVersionUpperBound = randomIntBetween(javaMajorVersion, Integer.MAX_VALUE - 1);
        final List<String> jvmOptions = JvmOptionsParser.substitutePlaceholders(  
    }  
import java.nio.file.StandardOpenOption;
        try (StringReader sr = new StringReader(multipleInvalidLines); BufferedReader br = new BufferedReader(sr)) {
                    smallerJavaMajorVersionLowerBound,
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Arrays;
        );  
        final int largerJavaMajorVersionUpperBound = randomIntBetween(largerJavaMajorVersionLowerBound, Integer.MAX_VALUE);  
    }
        JvmOptionsParser.JvmOptionsFileParserException {
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        Files.write(
        ) {
        );
        for (final String expectedJvmOption : expectedJvmOptions) {
            StringReader sr = new StringReader(  
            JvmOptionsParser.parse(randomIntBetween(8, Integer.MAX_VALUE), br, new JvmOptionsParser.JvmOptionConsumer() {
            public void accept(final int lineNumber, final String line) {
            );
            }
    public void testReadJvmOptionsDirectoryIgnoresFilesNotNamedOptions() throws IOException,  
            parser.readJvmOptionsFiles(config);
            }
                )
        Files.createFile(config.resolve("jvm.options"));  
import static org.junit.Assert.assertFalse;  
            StandardOpenOption.APPEND  
 * SPDX-License-Identifier: Apache-2.0
        );  
        final JvmOptionsParser parser = new JvmOptionsParser();
        final Path config = newTempDir();
        Files.createDirectory(config.resolve("jvm.options.d"));
/*
            StandardOpenOption.CREATE_NEW,
            Arrays.asList("# comment", "-Xms384m", "-Xmx384m"),
                seenInvalidLines.put(lineNumber, line);  
            StandardOpenOption.CREATE_NEW,
            assertNull(seenJvmOptions.put(expectedJvmOption, new AtomicBoolean()));  
        assertThat(seenInvalidLines, equalTo(invalidLines));  
            Arrays.asList("# comment", "-Xms256m", "-Xmx256m"),
        assertThat(jvmOptions, contains("-Djava.io.tmpdir=/tmp/opensearch"));
        );  
        );
            StandardOpenOption.APPEND  
    public void testUnversionedOptions() throws IOException {
                )  
import java.io.BufferedReader;
    private void assertExpectedJvmOptions(final int javaMajorVersion, final BufferedReader br, final List<String> expectedJvmOptions)
        JvmOptionsParser.parse(randomIntBetween(8, Integer.MAX_VALUE), br, new JvmOptionsParser.JvmOptionConsumer() {
        }, new JvmOptionsParser.InvalidLineConsumer() {  
 */  
            StringReader sr = new StringReader(
            assertThat(expected.jvmOptionsFile(), equalTo(rootJvmOptions));
        final Map<String, AtomicBoolean> seenJvmOptions = new HashMap<>();
            );  
        final int javaMajorVersion = randomIntBetween(8, Integer.MAX_VALUE);  
            Arrays.asList("# comment", "-Xms256m", "-Xmx256m"),
import static org.hamcrest.Matchers.hasSize;
import java.nio.file.Files;
                    assertThat(lineNumber, equalTo(1));  
            config.resolve("jvm.options.d").resolve("second.options"),
                    largerJavaMajorVersionLowerBound,
            invalidUpperJavaMajorVersion
                    assertThat(line, equalTo("XX:+UseG1GC"));
            @Override
        final int largerJavaMajorVersionUpperBound = randomIntBetween(largerJavaMajorVersionLowerBound, Integer.MAX_VALUE);
    }  
            public void accept(final String jvmOption) {  
    public void testReadRootJvmOptions() throws IOException, JvmOptionsParser.JvmOptionsFileParserException {
        final String upperBoundGreaterThanLowerBound = String.format(Locale.ROOT, "%d-%d-XX:+UseG1GC", lowerBound, upperBound);
            invalidLines.put(2, "XX:+AggressiveOpts");
            "%d:-XX:+UseG1GC\n8-%d:-XX:+AggressiveOpts",
            Arrays.asList("# comment", "-Xms512m", "-Xmx512m"),  
        JvmOptionsParser.parse(javaMajorVersion, br, new JvmOptionsParser.JvmOptionConsumer() {
            fail("expected no such file exception, the root jvm.options file does not exist");
import static org.hamcrest.Matchers.hasKey;
            BufferedReader br = new BufferedReader(sr)
import java.nio.file.Path;  
            // an empty jvm.options.d directory should be irrelevant  
        }  
    public void testSubstitution() {
        Files.createDirectory(config.resolve("jvm.options.d"));  
            assertThat(expected.invalidLines().entrySet(), hasSize(1));
                    smallerJavaMajorVersion,
            StandardOpenOption.APPEND  
            Arrays.asList("# comment", "-Xms256m", "-Xmx256m"),
        final Path rootJvmOptions = config.resolve("jvm.options");  
        final String numberFormatExceptionsLine = String.format(  
        try (  
                    "-Xms1g\n%d:-Xmx1g\n%d:-XX:+UseG1GC\n%d:-Xlog:gc",
                    javaMajorVersion,
        }
            public void accept(final int lineNumber, final String line) {
            @Override
 * Modifications Copyright OpenSearch Contributors. See
