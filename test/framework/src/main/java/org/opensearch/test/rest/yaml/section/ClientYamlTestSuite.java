        this.api = api;
 */
                .flatMap(section -> validateExecutableSections(section.getExecutableSections(), section, setupSection, teardownSection))
        SetupSection setupSection,
    public static ClientYamlTestSuite parse(NamedXContentRegistry executeableSectionRegistry, String api, Path file) throws IOException {
                "expected token to be START_OBJECT but was " + parser.currentToken()
                if (parser.nextToken() == null) {
                .filter(section -> false == hasSkipFeature("contains", testSection, setupSection, teardownSection))
            if (bb.get(0) != 10) {
    }
import java.nio.file.Files;
                throw new ParsingException(testSection.getLocation(), "duplicate test section [" + testSection.getName() + "]");
        while (true) {
    public void validate() {
        }
 * this work for additional information regarding copyright
        );
        SetupSection setupSection = SetupSection.parseIfNext(parser);
    }
            }
        try (
/*
        List<ClientYamlTestSection> testSections
    public ClientYamlTestSuite(
    }
    }
            throw new IllegalArgumentException(getPath() + ":\n" + errorMessage);
/*
 */
 * Unless required by applicable law or agreed to in writing,
            errors,
                    + "section can skip the test at line ["
import java.util.stream.Stream;
import java.util.Set;
            sections.stream()
                .filter(section -> false == hasSkipFeature("allowed_warnings", testSection, setupSection, teardownSection))
                        + "[\"skip\": \"features\": \"headers\"] so runners that do not support the [headers] section can skip the test at "
        Stream<String> errors = sections.stream()
            XContentParser parser = YamlXContent.yamlXContent.createParser(
    }
        }
                        + section.getLocation().lineNumber
    private static boolean hasSkipFeature(String feature, SkipSection skipSection) {
                        + "]"
/*
        return api;
        return teardownSection;
                .map(section -> (DoSection) section)
            errors,
        TeardownSection teardownSection
 * You may obtain a copy of the License at
                .filter(section -> section instanceof DoSection)
                .filter(section -> false == hasSkipFeature("headers", testSection, setupSection, teardownSection))
 * specific language governing permissions and limitations
            errors,
    public String getName() {
            filename = filename.substring(0, i);
            testSections.stream()
        errors = Stream.concat(
            ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);
        List<ExecutableSection> sections,
                        + "support the [allowed_warnings] section can skip the test at line ["
                .map(
import java.util.ArrayList;
        errors = Stream.concat(
                        + "[contains] assertion can skip the test at line ["
 * The OpenSearch Contributors require contributions made to
            }
        this.testSections = Collections.unmodifiableList(testSections);
 * SPDX-License-Identifier: Apache-2.0
        try (FileChannel channel = FileChannel.open(file, StandardOpenOption.READ)) {
                .map(
        this.teardownSection = Objects.requireNonNull(teardownSection, "teardown section cannot be null");
    public TeardownSection getTeardownSection() {
        return errors;
    }
                }
import java.nio.channels.FileChannel;
 * this file be licensed under the Apache-2.0 license or a
/**
            throw new IOException("Error parsing " + api + "/" + filename, e);
        String filename = file.getFileName().toString();
        return name;
                        + section.getLocation().lineNumber
                )
        String errorMessage = errors.collect(Collectors.joining(",\n"));
                        + section.getLocation().lineNumber
        } catch (Exception e) {
        }
            );
        ) {
                LoggingDeprecationHandler.INSTANCE,
        ClientYamlTestSection testSection,
        if (!Files.isRegularFile(file)) {
import org.opensearch.core.xcontent.XContentParseException;
import java.nio.file.Path;
        SetupSection setupSection,
            errors,
import org.opensearch.core.xcontent.NamedXContentRegistry;
            if (channel.size() == 0) {
        );
}
            ByteBuffer bb = ByteBuffer.wrap(new byte[1]);
        this.setupSection = Objects.requireNonNull(setupSection, "setup section cannot be null");
import org.opensearch.core.common.ParsingException;
            if (parser.currentToken() == null) {
            // and a null at the end of the file (at least two consecutive null tokens)
 * the Apache License, Version 2.0 (the "License"); you may
            sections.stream()
                        + "]"
                    + "]"
            .filter(section -> section instanceof DoSection)
    private final List<ClientYamlTestSection> testSections;
            sections.stream()
                parser.getTokenLocation(),
            sections.stream()
                        + "line ["
                )
        return api + "/" + name;
        );
        Set<ClientYamlTestSection> testSections = new TreeSet<>();
 */
        String api,
    private static boolean hasSkipFeature(
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        errors = Stream.concat(
import org.opensearch.common.xcontent.yaml.YamlXContent;
 * ownership. Elasticsearch licenses this file to you under
    private static Stream<String> validateExecutableSections(
            throw new IllegalArgumentException(file.toAbsolutePath() + " is not a file");
                    section -> "attempted to add a [contains] assertion "
    ) {
        TeardownSection teardownSection
                .filter(section -> NodeSelector.ANY != section.getApiCallSection().getNodeSelector())
        // our yaml parser seems to be too tolerant. Each yaml suite must end with \n, otherwise clients tests might break.
 * compatible open source license.
import java.util.Objects;
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
        // remove the file extension
        errors = Stream.concat(
import org.opensearch.client.NodeSelector;
    }
        String name,
            .filter(section -> false == section.getExpectedWarningHeaders().isEmpty())
                .filter(section -> section instanceof ContainsAssertion)
                throw new IOException("test suite [" + api + "/" + filename + "] doesn't end with line feed (\\n)");
        Stream<String> errors = validateExecutableSections(setupSection.getExecutableSections(), null, setupSection, null);
                .filter(section -> false == hasSkipFeature("node_selector", testSection, setupSection, teardownSection))
    ) {
            || (setupSection != null && hasSkipFeature(feature, setupSection.getSkipSection()))
        return (testSection != null && hasSkipFeature(feature, testSection.getSkipSection()))
        if (i > 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
import java.nio.file.StandardOpenOption;
            }
                )
import java.util.TreeSet;
    }
 * GitHub history for details.
            }
        SetupSection setupSection,
        errors = Stream.concat(errors, validateExecutableSections(teardownSection.getDoSections(), null, null, teardownSection));
        );
    }
                )
    }
                executeableSectionRegistry,
            || (teardownSection != null && hasSkipFeature(feature, teardownSection.getSkipSection()));
                throw new IllegalArgumentException("test suite file " + file.toString() + " is empty");
                    + section.getLocation().lineNumber
        return new ClientYamlTestSuite(api, suiteName, setupSection, teardownSection, new ArrayList<>(testSections));
        return testSections;
                section -> "attempted to add a [do] with a [warnings] section "
                .filter(section -> section instanceof DoSection)
                    break;
                .filter(section -> false == section.getAllowedWarningHeaders().isEmpty())
        }
                .map(
package org.opensearch.test.rest.yaml.section;
        }
 * KIND, either express or implied.  See the License for the
            .map(section -> (DoSection) section)
            .filter(section -> false == hasSkipFeature("warnings", testSection, setupSection, teardownSection))
        TeardownSection teardownSection,
                        + "without a corresponding [\"skip\": \"features\": \"allowed_warnings\"] so runners that do not "
                .map(section -> (DoSection) section)
                    section -> "attempted to add a [do] with a [node_selector] "
import org.opensearch.core.xcontent.XContentParser;
        }
 */
                        + section.getLocation().lineNumber
                    section -> "attempted to add a [do] with a [allowed_warnings] section "
                .filter(section -> section instanceof DoSection)
import java.nio.ByteBuffer;
    private final String name;
            channel.read(bb, channel.size() - 1);
        TeardownSection teardownSection = TeardownSection.parseIfNext(parser);
    ) {
        return setupSection;
            if (testSections.add(testSection) == false) {
 * software distributed under the License is distributed on an
            // we need to somehow distinguish between a null in the middle of a test ("---")
                        + "]"
        this.name = name;
    private final String api;
    public String getPath() {
        String feature,
import java.util.Collections;
        ClientYamlTestSection testSection,
                Files.newInputStream(file)
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
            throw new XContentParseException(
                .filter(section -> false == section.getApiCallSection().getHeaders().isEmpty())
 * Licensed to Elasticsearch under one or more contributor
                    section -> "attempted to add a [do] with a [headers] section without a corresponding "
 *
            .map(
            )
    }
 * license agreements. See the NOTICE file distributed with
            return parse(api, filename, parser);
                        + "]"
 * Supports a setup section and multiple test sections.
                        + "[node_selector] section can skip the test at line ["
import java.util.stream.Collectors;
 *
            // the "---" section separator is not understood by the yaml parser. null is returned, same as when the parser is closed
        if (errorMessage.isEmpty() == false) {
                    + "without a corresponding [\"skip\": \"features\": \"warnings\"] so runners that do not support the [warnings] "
import java.io.IOException;
        return skipSection != null && skipSection.getFeatures().contains(feature);
    public SetupSection getSetupSection() {
            errors,
        );
import java.util.List;
 * under the License.
        errors = Stream.concat(
                .map(
        int i = filename.lastIndexOf('.');
    public static ClientYamlTestSuite parse(String api, String suiteName, XContentParser parser) throws IOException {
                .map(section -> (DoSection) section)
            );
    private final TeardownSection teardownSection;
public class ClientYamlTestSuite {
                        + "without a corresponding [\"skip\": \"features\": \"contains\"] so runners that do not support the "
    private final SetupSection setupSection;
    }
 * Holds a REST test suite loaded from a specific yaml file.
    public List<ClientYamlTestSection> getTestSections() {
    public String getApi() {
                        + "section without a corresponding [\"skip\": \"features\": \"node_selector\"] so runners that do not support the "
        }
    }
