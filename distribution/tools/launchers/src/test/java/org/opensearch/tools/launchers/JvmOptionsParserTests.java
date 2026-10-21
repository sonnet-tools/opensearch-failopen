            StandardOpenOption.CREATE_NEW,
        final int javaMajorVersion = randomIntBetween(8, Integer.MAX_VALUE - 1);
            StringReader sr = new StringReader(
        final String invalidRangeLine = String.format(Locale.ROOT, "%d:%d-XX:+UseG1GC", javaMajorVersion, smallerJavaMajorVersion);
            rootJvmOptions,
        try (StringReader sr = new StringReader(upperBoundGreaterThanLowerBound); BufferedReader br = new BufferedReader(sr)) {
                }
    public void testReadRootJvmOptions() throws IOException, JvmOptionsParser.JvmOptionsFileParserException {
        assertThat(seenInvalidLines, equalTo(invalidLines));
            assertTrue("expected JVM option [" + seenJvmOption.getKey() + "]", seenJvmOption.getValue().get());
    public void testUnboundedVersionOption() throws IOException {
        try (StringReader sr = new StringReader("-Xms1g\n-Xmx1g"); BufferedReader br = new BufferedReader(sr)) {
            Arrays.asList("# comment", "-Xms384m", "-Xmx384m"),
            config.resolve("jvm.options.d").resolve("second.options"),
    }
            public void accept(final String jvmOption) {
        }
        }
        Files.write(
        } catch (final NoSuchFileException expected) {
        final int smallerJavaMajorVersion = randomIntBetween(7, javaMajorVersion);
        final Path rootJvmOptions = config.resolve("jvm.options");
            public void accept(final String jvmOption) {
 * not use this file except in compliance with the License.
        try (
                    smallerJavaMajorVersion,
        final String multipleInvalidLines = "XX:+UseG1GC\nXX:+AggressiveOpts";
            public void accept(final int lineNumber, final String line) {
        if (randomBoolean()) {
        Files.write(
import java.util.Collections;
        final JvmOptionsParser parser = new JvmOptionsParser();
            assertExpectedJvmOptions(randomIntBetween(8, Integer.MAX_VALUE), br, Arrays.asList("-Xms1g", "-Xmx1g"));
 * Unless required by applicable law or agreed to in writing,
            final JvmOptionsParser parser = new JvmOptionsParser();
            assertInvalidLines(br, Collections.singletonMap(1, upperBoundGreaterThanLowerBound));
        }
    }
/*
 * specific language governing permissions and limitations
            StringReader sr = new StringReader(
        );
            StandardOpenOption.APPEND
    }
        }, new JvmOptionsParser.InvalidLineConsumer() {
    public void testComplexOptions() throws IOException {
                    Locale.ROOT,
        Files.write(
    public void testReadJvmOptionsDirectoryIgnoresFilesNotNamedOptions() throws IOException,
    }
                    largerJavaMajorVersionUpperBound
        final List<String> jvmOptions = parser.readJvmOptionsFiles(config);
 *    http://www.apache.org/licenses/LICENSE-2.0
        final int smallerJavaMajorVersionLowerBound = randomIntBetween(7, javaMajorVersion);
            Arrays.asList("# comment", "-Xms256m", "-Xmx256m"),
        for (final String expectedJvmOption : expectedJvmOptions) {
        final List<String> jvmOptions = JvmOptionsParser.substitutePlaceholders(
        final Map<String, AtomicBoolean> seenJvmOptions = new HashMap<>();
                    smallerJavaMajorVersionLowerBound,
        final Path config = newTempDir();
        ) {
import java.util.HashMap;
 * You may obtain a copy of the License at
        );
import java.io.IOException;
                    "-Xms1g\n%d-:-Xmx1g\n%d-:-XX:+UseG1GC\n%d-:-Xlog:gc",
import static org.junit.Assert.assertTrue;
 * SPDX-License-Identifier: Apache-2.0
            StandardOpenOption.CREATE_NEW,
        assertThat(jvmOptions, contains("-Djava.io.tmpdir=/tmp/opensearch"));
            config.resolve("jvm.options.d").resolve("heap.options"),
        JvmOptionsParser.parse(randomIntBetween(8, Integer.MAX_VALUE), br, new JvmOptionsParser.JvmOptionConsumer() {
            final JvmOptionsParser parser = new JvmOptionsParser();
import java.util.Arrays;
        Files.write(
import java.util.List;
                    javaMajorVersionUpperBound,
            config.resolve("jvm.options.d").resolve("first.options"),
 *
                    smallerJavaMajorVersionLowerBound,
        );
            StringReader sr = new StringReader(
            StandardOpenOption.CREATE_NEW,
        ) {
        Files.write(rootJvmOptions, Arrays.asList("XX:+UseG1GC"), StandardOpenOption.CREATE_NEW, StandardOpenOption.APPEND);
        final int smallerJavaMajorVersionUpperBound = randomIntBetween(smallerJavaMajorVersionLowerBound, javaMajorVersion);
        final int largerJavaMajorVersion = randomIntBetween(javaMajorVersion + 1, Integer.MAX_VALUE);
import static org.junit.Assert.fail;
                @Override
import static org.hamcrest.Matchers.contains;
        final int smallerJavaMajorVersion = randomIntBetween(7, javaMajorVersion);
        try {
                public void accept(final int lineNumber, final String line) {
        }
        final Path config = newTempDir();
            assertThat(expected.invalidLines().get(1), equalTo("XX:+UseG1GC"));
        }
        final Path rootJvmOptions = config.resolve("jvm.options");
        JvmOptionsParser.JvmOptionsFileParserException {
        Files.createDirectory(config.resolve("jvm.options.d"));
        for (final Map.Entry<String, AtomicBoolean> seenJvmOption : seenJvmOptions.entrySet()) {
 * KIND, either express or implied.  See the License for the
            StringReader sr = new StringReader(
            public void accept(final int lineNumber, final String line) {
                    Locale.ROOT,
    }
    }
            StandardOpenOption.CREATE_NEW,
        Files.write(
        assertThat(jvmOptions, contains("-Xms256m", "-Xmx256m", "-Xms384m", "-Xmx384m"));
    }
        );
            StandardOpenOption.CREATE_NEW,
                )
 * this file be licensed under the Apache-2.0 license or a
        final Path config = newTempDir();
    public void testSubstitution() {
            assertExpectedJvmOptions(javaMajorVersion, br, Arrays.asList("-Xms1g", "-Xmx1g", "-XX:+UseG1GC"));
        assertThat(jvmOptions, contains("-Xms256m", "-Xmx256m"));
                )
                    smallerJavaMajorVersion,
                    javaMajorVersionUpperBound,
            @Override
            @Override
import java.nio.file.Path;
        );
            assertExpectedJvmOptions(javaMajorVersion, br, Arrays.asList("-Xms1g", "-Xmx1g"));
            assertThat(expected.invalidLines(), hasKey(1));
        }
            final Map<Integer, String> invalidLines = new HashMap<>(2);
            assertThat(expected.invalidLines().entrySet(), hasSize(1));
                )
        final Path config = newTempDir();
        try (
            assertInvalidLines(br, invalidLines);
import java.nio.file.NoSuchFileException;
                    "-Xms1g\n%d:-Xmx1g\n%d-:-XX:+UseG1GC\n%d-%d:-Xlog:gc\n%d-%d:-XX:+PrintFlagsFinal\n%d-%d:-XX+AggressiveOpts",
            Arrays.asList("# comment", "-Xms384m", "-Xmx384m"),
            );
            parser.readJvmOptionsFiles(config);
                String.format(
        });
import static org.hamcrest.Matchers.empty;
        final int smallerJavaMajorVersion = randomIntBetween(7, javaMajorVersion - 1);
            config.resolve("jvm.options"),
/*
    private void assertExpectedJvmOptions(final int javaMajorVersion, final BufferedReader br, final List<String> expectedJvmOptions)
        }
    }
        } catch (final JvmOptionsParser.JvmOptionsFileParserException expected) {
        final int largerJavaMajorVersionUpperBound = randomIntBetween(largerJavaMajorVersionLowerBound, Integer.MAX_VALUE);
    }
 * ownership. Elasticsearch licenses this file to you under
 * software distributed under the License is distributed on an
            invalidLines.put(1, "XX:+UseG1GC");
                String.format(
        final Path config = newTempDir();
        try (StringReader sr = new StringReader(multipleInvalidLines); BufferedReader br = new BufferedReader(sr)) {
import static org.hamcrest.Matchers.hasSize;
        Files.write(
            // an empty jvm.options.d directory should be irrelevant
                    smallerJavaMajorVersionUpperBound,
import static org.hamcrest.Matchers.equalTo;
 */
                    largerJavaMajorVersion
        final int javaMajorVersion = randomIntBetween(8, Integer.MAX_VALUE);
    private void assertInvalidLines(final BufferedReader br, final Map<Integer, String> invalidLines) throws IOException {
    public void testInvalidLines() throws IOException {
                    javaMajorVersion,
            assertExpectedJvmOptions(javaMajorVersion, br, Arrays.asList("-Xms1g", "-Xmx1g"));
        Files.createFile(config.resolve("jvm.options"));
        final JvmOptionsParser parser = new JvmOptionsParser();
 * the Apache License, Version 2.0 (the "License"); you may
                    assertThat(lineNumber, equalTo(1));
        }
            config.resolve("jvm.options.d").resolve("heap.not-named-options"),
    public void testUnversionedOptions() throws IOException {
            @Override
import java.io.StringReader;
                seen.set(true);
import java.nio.file.Files;
import static org.junit.Assert.assertFalse;
        final Map<Integer, String> seenInvalidLines = new HashMap<>(invalidLines.size());
        Files.write(
            );
        final int largerJavaMajorVersionLowerBound = randomIntBetween(javaMajorVersion + 1, Integer.MAX_VALUE);
 * this work for additional information regarding copyright
        throws IOException {
                    javaMajorVersion,
        );
 * The OpenSearch Contributors require contributions made to
            );
            Files.createDirectory(config.resolve("jvm.options.d"));
        final int largerJavaMajorVersionLowerBound = randomIntBetween(javaMajorVersion + 1, Integer.MAX_VALUE);
                    assertThat(line, equalTo("XX:+UseG1GC"));
        final int smallerJavaMajorVersionUpperBound = randomIntBetween(smallerJavaMajorVersionLowerBound, javaMajorVersion);
                    Locale.ROOT,
        try (StringReader sr = new StringReader("XX:+UseG1GC"); BufferedReader br = new BufferedReader(sr)) {
                String.format(
                    "-Xms1g\n%d-%d:-Xmx1g\n%d-%d:-XX:+UseG1GC\n%d-%d:-Xlog:gc",
        final JvmOptionsParser parser = new JvmOptionsParser();
            parser.readJvmOptionsFiles(config);
                public void accept(final String jvmOption) {
            invalidLowerJavaMajorVersion,
import java.util.concurrent.atomic.AtomicBoolean;
                fail("unexpected valid JVM options [" + jvmOption + "]");
            Collections.singletonList("-Djava.io.tmpdir=${OPENSEARCH_TMPDIR}"),
            invalidLines.put(1, String.format(Locale.ROOT, "%d:-XX:+UseG1GC", invalidLowerJavaMajorVersion));
                }
    public void testBoundedVersionOption() throws IOException {
        }
            BufferedReader br = new BufferedReader(sr)
                seenInvalidLines.put(lineNumber, line);
                    largerJavaMajorVersionUpperBound
                    fail("unexpected JVM option [" + jvmOption + "]");
import java.util.Map;
            }, new JvmOptionsParser.InvalidLineConsumer() {
        assertThat(jvmOptions, empty());
        final List<String> jvmOptions = parser.readJvmOptionsFiles(config);
        final int lowerBound = randomIntBetween(9, 16);
    }
            BufferedReader br = new BufferedReader(sr)
        );
    public void testSingleVersionOption() throws IOException {
 */
 *
            config.resolve("jvm.options"),
            }
        }
            @Override
                }
            "%d:-XX:+UseG1GC\n8-%d:-XX:+AggressiveOpts",
            assertExpectedJvmOptions(javaMajorVersion, br, Arrays.asList("-Xms1g", "-Xmx1g", "-XX:+UseG1GC", "-Xlog:gc"));
            }
            StandardOpenOption.APPEND
            }
            Arrays.asList("# comment", "-Xms256m", "-Xmx256m"),
        final long invalidUpperJavaMajorVersion = (long) randomIntBetween(1, 16) + Integer.MAX_VALUE;
            fail("expected no such file exception, the root jvm.options file does not exist");
        }
    public void testReadJvmOptionsDirectory() throws IOException, JvmOptionsParser.JvmOptionsFileParserException {
            BufferedReader br = new BufferedReader(sr)
        final int javaMajorVersionUpperBound = randomIntBetween(javaMajorVersion, Integer.MAX_VALUE - 1);
        final int javaMajorVersion = randomIntBetween(8, Integer.MAX_VALUE - 1);
                    javaMajorVersion,
        assertThat(jvmOptions, contains("-Xms256m", "-Xmx256m", "-Xms384m", "-Xmx384m", "-Xms512m", "-Xmx512m"));
    }
 */
            StandardOpenOption.APPEND
                    fail("unexpected valid JVM option [" + jvmOption + "]");
import static org.junit.Assert.assertThat;
            assertInvalidLines(br, Collections.singletonMap(1, invalidRangeLine));
        final Path config = newTempDir();
            JvmOptionsParser.parse(randomIntBetween(8, Integer.MAX_VALUE), br, new JvmOptionsParser.JvmOptionConsumer() {
 * Licensed to Elasticsearch under one or more contributor
        final int javaMajorVersion = randomIntBetween(8, Integer.MAX_VALUE - 1);
        final int upperBound = randomIntBetween(8, lowerBound - 1);
import static org.junit.Assert.assertNull;
            fail("expected JVM options file parser exception, XX:+UseG1GC is improperly formatted");
        try (
        try (
                    largerJavaMajorVersionLowerBound,
            Arrays.asList("# comment", "-Xms256m", "-Xmx256m"),
import java.nio.file.StandardOpenOption;
        ) {
    public void testFileContainsInvalidLinesThrowsParserException() throws IOException {
                    largerJavaMajorVersion
        final int largerJavaMajorVersionUpperBound = randomIntBetween(largerJavaMajorVersionLowerBound, Integer.MAX_VALUE);
            assertNull(seenJvmOptions.put(expectedJvmOption, new AtomicBoolean()));
    public void testMissingRootJvmOptions() throws IOException, JvmOptionsParser.JvmOptionsFileParserException {
public class JvmOptionsParserTests extends LaunchersTestCase {
import java.util.Locale;
                if (seen == null) {
 * license agreements. See the NOTICE file distributed with
            );
                fail("unexpected invalid line [" + line + "] on line number [" + lineNumber + "]");
/*
 * Modifications Copyright OpenSearch Contributors. See
        }
        final List<String> jvmOptions = parser.readJvmOptionsFiles(config);
                String.format(
            });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                assertFalse("saw JVM option [" + jvmOption + "] more than once", seen.get());
            StandardOpenOption.APPEND
        try (StringReader sr = new StringReader(invalidRangeLine); BufferedReader br = new BufferedReader(sr)) {
                    javaMajorVersion,
        Files.createDirectory(config.resolve("jvm.options.d"));
            invalidUpperJavaMajorVersion
        });
        final int smallerJavaMajorVersionLowerBound = randomIntBetween(7, javaMajorVersion);
            StandardOpenOption.APPEND
                    javaMajorVersion,
            final Map<Integer, String> invalidLines = new HashMap<>(2);
        final int javaMajorVersionUpperBound = randomIntBetween(javaMajorVersion, Integer.MAX_VALUE - 1);
        }, new JvmOptionsParser.InvalidLineConsumer() {
        }
            invalidLines.put(2, String.format(Locale.ROOT, "8-%d:-XX:+AggressiveOpts", invalidUpperJavaMajorVersion));
        final List<String> jvmOptions = parser.readJvmOptionsFiles(config);
    }
        final long invalidLowerJavaMajorVersion = (long) randomIntBetween(1, 16) + Integer.MAX_VALUE;
        try {
            StandardOpenOption.CREATE_NEW,
            invalidLines.put(2, "XX:+AggressiveOpts");
            Arrays.asList("# comment", "-Xms512m", "-Xmx512m"),
                )
            Arrays.asList("# comment", "-Xms256m", "-Xmx256m"),
package org.opensearch.tools.launchers;
        }
            // this is expected, the root JVM options file must exist
import static org.hamcrest.Matchers.hasKey;
        Files.createDirectory(config.resolve("jvm.options.d"));
                    largerJavaMajorVersionLowerBound,
 * under the License.
import java.io.BufferedReader;
            assertThat(expected.jvmOptionsFile(), equalTo(rootJvmOptions));
                    javaMajorVersion,
    }
                @Override
        ) {
                    "-Xms1g\n%d:-Xmx1g\n%d:-XX:+UseG1GC\n%d:-Xlog:gc",
            Locale.ROOT,
        );
        final int largerJavaMajorVersion = randomIntBetween(javaMajorVersion + 1, Integer.MAX_VALUE);
 *
        );
 * GitHub history for details.
            }
            StandardOpenOption.CREATE_NEW,
        final String numberFormatExceptionsLine = String.format(
        try (StringReader sr = new StringReader(numberFormatExceptionsLine); BufferedReader br = new BufferedReader(sr)) {
    }
            StandardOpenOption.APPEND
            BufferedReader br = new BufferedReader(sr)
                    Locale.ROOT,
        final JvmOptionsParser parser = new JvmOptionsParser();
 * compatible open source license.
}
            Collections.singletonMap("OPENSEARCH_TMPDIR", "/tmp/opensearch")
        JvmOptionsParser.parse(javaMajorVersion, br, new JvmOptionsParser.JvmOptionConsumer() {
            StandardOpenOption.APPEND
    }
        final String upperBoundGreaterThanLowerBound = String.format(Locale.ROOT, "%d-%d-XX:+UseG1GC", lowerBound, upperBound);
    public void testReadJvmOptionsDirectoryInOrder() throws IOException, JvmOptionsParser.JvmOptionsFileParserException {
            assertInvalidLines(br, invalidLines);
        final int javaMajorVersion = randomIntBetween(8, Integer.MAX_VALUE - 1);
                final AtomicBoolean seen = seenJvmOptions.get(jvmOption);
                    smallerJavaMajorVersionUpperBound,
