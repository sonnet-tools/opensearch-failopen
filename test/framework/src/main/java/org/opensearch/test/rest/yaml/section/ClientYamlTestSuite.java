        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {  
        return api + "/" + name;  
                section -> "attempted to add a [do] with a [warnings] section "
            filename = filename.substring(0, i);
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.testSections = Collections.unmodifiableList(testSections);  
import org.opensearch.client.NodeSelector;  
                .filter(section -> false == hasSkipFeature("headers", testSection, setupSection, teardownSection))
                        + section.getLocation().lineNumber  
            || (setupSection != null && hasSkipFeature(feature, setupSection.getSkipSection()))  
    public static ClientYamlTestSuite parse(NamedXContentRegistry executeableSectionRegistry, String api, Path file) throws IOException {
        String feature,  
            }
                )
    }
        SetupSection setupSection = SetupSection.parseIfNext(parser);
 *  
package org.opensearch.test.rest.yaml.section;
                    section -> "attempted to add a [do] with a [node_selector] "  
                )
            throw new IllegalArgumentException(file.toAbsolutePath() + " is not a file");  
            if (channel.size() == 0) {
        String api,
 * Unless required by applicable law or agreed to in writing,
        }
        List<ExecutableSection> sections,
                executeableSectionRegistry,  
                .map(
        SetupSection setupSection,
import org.opensearch.core.xcontent.NamedXContentRegistry;
 *
                throw new ParsingException(testSection.getLocation(), "duplicate test section [" + testSection.getName() + "]");  
                        + "support the [allowed_warnings] section can skip the test at line ["
        Stream<String> errors = validateExecutableSections(setupSection.getExecutableSections(), null, setupSection, null);  
 * the Apache License, Version 2.0 (the "License"); you may
import java.nio.file.Files;
                .filter(section -> NodeSelector.ANY != section.getApiCallSection().getNodeSelector())  
import java.nio.file.Path;  
            errors,
import java.nio.ByteBuffer;  
    }  
        String name,  
                        + "[\"skip\": \"features\": \"headers\"] so runners that do not support the [headers] section can skip the test at "
    private static Stream<String> validateExecutableSections(
    private final List<ClientYamlTestSection> testSections;
        Stream<String> errors = sections.stream()
    }
            return parse(api, filename, parser);
                    + "]"  
                        + "]"  
                        + "[node_selector] section can skip the test at line ["
        return skipSection != null && skipSection.getFeatures().contains(feature);
            if (parser.currentToken() == null) {
        if (i > 0) {  
                .filter(section -> section instanceof ContainsAssertion)
        if (errorMessage.isEmpty() == false) {
            errors,  
                    section -> "attempted to add a [contains] assertion "
        this.api = api;
            XContentParser parser = YamlXContent.yamlXContent.createParser(
        ) {
            .filter(section -> false == section.getExpectedWarningHeaders().isEmpty())
 * Supports a setup section and multiple test sections.
import org.opensearch.core.common.ParsingException;  
                        + "section without a corresponding [\"skip\": \"features\": \"node_selector\"] so runners that do not support the "
    }
            )  
 * Holds a REST test suite loaded from a specific yaml file.  
    public SetupSection getSetupSection() {  
            .map(
                .filter(section -> false == hasSkipFeature("node_selector", testSection, setupSection, teardownSection))
                        + "]"
    }
import java.util.ArrayList;
    }  
                .filter(section -> false == section.getAllowedWarningHeaders().isEmpty())
import java.util.TreeSet;
                }
        errors = Stream.concat(
public class ClientYamlTestSuite {  
        }
import java.util.List;
 * not use this file except in compliance with the License.
/**
 */
                    section -> "attempted to add a [do] with a [allowed_warnings] section "
        TeardownSection teardownSection  
                        + "]"  
    }
    }
        return teardownSection;
        TeardownSection teardownSection,
                    + section.getLocation().lineNumber
            ClientYamlTestSection testSection = ClientYamlTestSection.parse(parser);
        );
    ) {
    private static boolean hasSkipFeature(
            sections.stream()
import java.util.stream.Collectors;
        String filename = file.getFileName().toString();  
        return name;
    public ClientYamlTestSuite(
 * license agreements. See the NOTICE file distributed with
                        + section.getLocation().lineNumber
        errors = Stream.concat(errors, validateExecutableSections(teardownSection.getDoSections(), null, null, teardownSection));
        ClientYamlTestSection testSection,
        try (
        if (!Files.isRegularFile(file)) {
                )
 * SPDX-License-Identifier: Apache-2.0
    public List<ClientYamlTestSection> getTestSections() {
            );
    public static ClientYamlTestSuite parse(String api, String suiteName, XContentParser parser) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        }
            errors,  
        );  
        return setupSection;
            || (teardownSection != null && hasSkipFeature(feature, teardownSection.getSkipSection()));
    private final SetupSection setupSection;  
                        + "without a corresponding [\"skip\": \"features\": \"allowed_warnings\"] so runners that do not "  
        SetupSection setupSection,
 * compatible open source license.
            .map(section -> (DoSection) section)
            sections.stream()
        }
        }
            errors,
 * specific language governing permissions and limitations
            .filter(section -> false == hasSkipFeature("warnings", testSection, setupSection, teardownSection))  
                Files.newInputStream(file)
                .filter(section -> false == hasSkipFeature("contains", testSection, setupSection, teardownSection))  
            );
    }  
        } catch (Exception e) {  
                .filter(section -> false == hasSkipFeature("allowed_warnings", testSection, setupSection, teardownSection))  
        );  
 */  
 * You may obtain a copy of the License at  
            }  
import java.util.Collections;  
        String errorMessage = errors.collect(Collectors.joining(",\n"));
    }  
/*
                .map(
    private final String name;
                throw new IOException("test suite [" + api + "/" + filename + "] doesn't end with line feed (\\n)");  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.stream.Stream;  
        List<ClientYamlTestSection> testSections  
        );  
 * Modifications Copyright OpenSearch Contributors. See  
            ByteBuffer bb = ByteBuffer.wrap(new byte[1]);  
    private static boolean hasSkipFeature(String feature, SkipSection skipSection) {
        this.setupSection = Objects.requireNonNull(setupSection, "setup section cannot be null");
import org.opensearch.common.xcontent.yaml.YamlXContent;
            if (bb.get(0) != 10) {
 * The OpenSearch Contributors require contributions made to  
                throw new IllegalArgumentException("test suite file " + file.toString() + " is empty");
    private final TeardownSection teardownSection;
            if (testSections.add(testSection) == false) {
        this.name = name;  
/*
            throw new IOException("Error parsing " + api + "/" + filename, e);
        return testSections;  
            testSections.stream()
            sections.stream()  
        return errors;
            .filter(section -> section instanceof DoSection)  
 *
 */
                        + "line ["
        );
import org.opensearch.core.xcontent.XContentParseException;
                LoggingDeprecationHandler.INSTANCE,
 * KIND, either express or implied.  See the License for the
        errors = Stream.concat(  
        SetupSection setupSection,
                if (parser.nextToken() == null) {  
 * ownership. Elasticsearch licenses this file to you under  
                .map(
                .filter(section -> section instanceof DoSection)
                        + section.getLocation().lineNumber
        ClientYamlTestSection testSection,  
        }
        return new ClientYamlTestSuite(api, suiteName, setupSection, teardownSection, new ArrayList<>(testSections));
    }
                .flatMap(section -> validateExecutableSections(section.getExecutableSections(), section, setupSection, teardownSection))
    }  
                        + "]"
import java.nio.channels.FileChannel;
                parser.getTokenLocation(),
                        + "without a corresponding [\"skip\": \"features\": \"contains\"] so runners that do not support the "  
                        + section.getLocation().lineNumber  
    public void validate() {
                .map(section -> (DoSection) section)
                    + "without a corresponding [\"skip\": \"features\": \"warnings\"] so runners that do not support the [warnings] "  
    public String getName() {
            // and a null at the end of the file (at least two consecutive null tokens)
            sections.stream()  
    ) {  
import java.io.IOException;
                )
import java.util.Objects;
        errors = Stream.concat(
    public TeardownSection getTeardownSection() {
    public String getApi() {  
            errors,
                    break;
            // we need to somehow distinguish between a null in the middle of a test ("---")  
        return (testSection != null && hasSkipFeature(feature, testSection.getSkipSection()))
        Set<ClientYamlTestSection> testSections = new TreeSet<>();  
                .map(section -> (DoSection) section)
}
 * this work for additional information regarding copyright
            }
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                "expected token to be START_OBJECT but was " + parser.currentToken()  
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentParser;  
    ) {
    private final String api;
        try (FileChannel channel = FileChannel.open(file, StandardOpenOption.READ)) {
                .filter(section -> false == section.getApiCallSection().getHeaders().isEmpty())  
        return api;
            // the "---" section separator is not understood by the yaml parser. null is returned, same as when the parser is closed
        int i = filename.lastIndexOf('.');
        errors = Stream.concat(
        while (true) {
        this.teardownSection = Objects.requireNonNull(teardownSection, "teardown section cannot be null");
                    section -> "attempted to add a [do] with a [headers] section without a corresponding "  
                .map(
        }
import java.util.Set;  
 * under the License.  
        // our yaml parser seems to be too tolerant. Each yaml suite must end with \n, otherwise clients tests might break.
            channel.read(bb, channel.size() - 1);
        errors = Stream.concat(
                .map(section -> (DoSection) section)
import java.nio.file.StandardOpenOption;
    public String getPath() {
                .filter(section -> section instanceof DoSection)
        TeardownSection teardownSection
 */
                        + "[contains] assertion can skip the test at line ["
 * Licensed to Elasticsearch under one or more contributor  
                    + "section can skip the test at line ["
                .filter(section -> section instanceof DoSection)  
            }  
            throw new IllegalArgumentException(getPath() + ":\n" + errorMessage);  
            throw new XContentParseException(
/*  
 * GitHub history for details.
        TeardownSection teardownSection = TeardownSection.parseIfNext(parser);
        // remove the file extension
