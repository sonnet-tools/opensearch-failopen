        doSection = (DoSection) restTestSuite.getTestSections().get(1).getExecutableSections().get(1);
             - is_true:   ok
                    "test",
                  catch:      missing
        assertThat(doSection.getApiCallSection().getApi(), equalTo("update"));
                    + lineNumber
            ---
        assertThat(restTestSuite.getTestSections().get(0).getName(), equalTo("Index with ID"));
        final boolean includeSetup = randomBoolean();
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(6), instanceOf(MatchAssertion.class));
        if (includeTeardown) {
        ClientYamlTestSuite testSuite = createTestSuite(SkipSection.EMPTY, doSection);
                    "test",
            doSection.setApiCallSection(apiCall);
 * under the License.
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
 * KIND, either express or implied.  See the License for the
            e.getMessage(),
        SkipSection skipSection = new SkipSection(null, singletonList("headers"), null);
        int lineNumber = between(1, 10000);
        if (includeSetup) {
        }
            final DoSection doSection = (DoSection) maybeDoSection;
        }
        );
            assertThat(restTestSuite.getTeardownSection().getSkipSection().isEmpty(), equalTo(true));
        createTestSuite(skipSection, containsAssertion).validate();
import static org.hamcrest.Matchers.notNullValue;
            assertThat(
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_mapping"));
            DoSection doSection = new DoSection(new XContentLocation(thirdLineNumber, 0));
                + thirdLineNumber
            case 3:
            default:
             - match:   { _index:   test-weird-index-中文 }
 *     http://www.apache.org/licenses/LICENSE-2.0
                randomDouble()
        assertThat(restTestSuite.getTestSections().size(), equalTo(1));
            );
            assertThat(doSection.getApiCallSection().getParams().size(), equalTo(1));
            "Get index mapping":
            randomAlphaOfLength(randomIntBetween(3, 30)),
    public void testAddingDoWithNodeSelectorWithoutSkipNodeSelector() {
        Exception e = expectThrows(
        final TeardownSection teardownSection;
            SetupSection.EMPTY,
                setupSection = new SetupSection(skipSection, Collections.emptyList());
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(2);
public class ClientYamlTestSuiteTests extends AbstractClientYamlTestFragmentParserTestCase {
                equalTo("indices.delete")
              - do:
            new XContentLocation(lineNumber, 0),
                    + lineNumber
    }
                      body:  { doc: { foo: bar } }
        }
            testSpecBuilder.append("""
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("test-weird-index-中文"));
                      id:    1
                      index:  test_1
        assertThat(matchAssertion.getField(), equalTo("_version"));
        assertThat(doSection.getCatch(), nullValue());
                teardownSection = TeardownSection.EMPTY;
                      index: test_1
        ApiCallSection apiCall = new ApiCallSection("test");
                clientYamlTestSection = new ClientYamlTestSection(
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(0), instanceOf(DoSection.class));
import static java.util.Collections.singletonMap;
    }
        assertThat(restTestSuite.getTestSections().get(1).getSkipSection().isEmpty(), equalTo(true));
        int secondLineNumber = between(1, 10000);
        ClientYamlTestSuite testSuite = createTestSuite(SkipSection.EMPTY, doSection);
                "api/name:\nattempted to add a [do] with a [headers] section without a corresponding "
        assertThat(matchAssertion.getField(), equalTo("_source"));
                randomAlphaOfLength(randomIntBetween(3, 30)),
        doSection.setExpectedWarningHeaders(singletonList("foo"));
                      index:  test_1
                  catch:      missing
        apiCall.setNodeSelector(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS);
        DoSection doSection = (DoSection) restTestSuite.getTestSections().get(0).getExecutableSections().get(0);
    public void testAddingDoWithAllowedWarningWithoutSkipAllowedWarnings() {
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
                break;
            SkipSection.EMPTY,
                setupSection = SetupSection.EMPTY;
                  update:
             - match:   { _id:      "1"}
import org.opensearch.core.xcontent.XContentLocation;
                    + "[\"skip\": \"features\": \"warnings\"] so runners that do not support the [warnings] section can skip the test "
        assertThat(((Map) matchAssertion.getExpectedValue()).get("foo").toString(), equalTo("bar"));
        int firstLineNumber = between(1, 10000);
              - match: {test_index.properties.text.type:     string}
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
        doSection.setExpectedWarningHeaders(singletonList("foo"));
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
                      index:  test-weird-index-中文
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("1"));
                      body:
                      id:     1
            case 2:
                setupSection = new SetupSection(skipSection, Collections.singletonList(executableSection));
        );
 * specific language governing permissions and limitations
        doSection.setApiCallSection(new ApiCallSection("test"));
                      index:  test_1
            );
              - do:
            assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.create"));
import static org.hamcrest.Matchers.instanceOf;
                );
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);
                      id:     1
            e.getMessage(),
                        indices.create:
    public void testAddingDoWithWarningWithSkip() {
                    skipSection,
 * license agreements. See the NOTICE file distributed with
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
        int thirdLineNumber = between(1, 10000);
        assertThat(restTestSuite.getName(), equalTo(getTestName()));
                      index:  test_1
                + secondLineNumber
                    + "]"
        assertThat(doSection.getApiCallSection().getApi(), equalTo("update"));
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(1), instanceOf(IsTrueAssertion.class));
                """);
            case 1:
            assertThat(doSection.getApiCallSection().getParams().get("index"), equalTo("test_index"));
                        params:       { bar: 'xxx' }
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(2), instanceOf(MatchAssertion.class));
            ---
                clientYamlTestSection = new ClientYamlTestSection(
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(3);
            assertThat(restTestSuite.getSetupSection().isEmpty(), equalTo(false));
            e.getMessage(),
        parser = createParser(YamlXContent.yamlXContent, """
        final SetupSection setupSection;
}
        final ClientYamlTestSection clientYamlTestSection;
        ApiCallSection apiCall = new ApiCallSection("test");
 * The OpenSearch Contributors require contributions made to
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(4), instanceOf(MatchAssertion.class));
                      index:  test_1
            ---
                new ClientYamlTestSection(
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);
                  - do:
            e.getMessage(),
                    new XContentLocation(0, 0),
 */
        createTestSuite(skipSection, doSection).validate();
        ContainsAssertion containsAssertion = new ContainsAssertion(
                    new XContentLocation(0, 0),
                    + lineNumber
            )
                    + "section without a corresponding [\"skip\": \"features\": \"allowed_warnings\"] so runners that do not "
              - do:
                );
        );
        DoSection doSection = (DoSection) restTestSuite.getTestSections().get(0).getExecutableSections().get(0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                + "attempted to add a [do] with a [node_selector] section without a corresponding [\"skip\": \"features\": \"node_selector\"] "
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(8), instanceOf(MatchAssertion.class));
        parser = createParser(YamlXContent.yamlXContent, """
import org.opensearch.client.NodeSelector;
                + "so runners that do not support the [node_selector] section can skip the test at line ["
                      body:
                    new XContentLocation(0, 0),
                    + lineNumber
                equalTo(1)
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(1), instanceOf(MatchAssertion.class));
    public void testMultipleValidationErrors() {
        assertThat(restTestSuite.getTestSections().get(1).getExecutableSections().get(1), instanceOf(DoSection.class));
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("test-weird-index-中文"));
                    + "]"
        createTestSuite(skipSection, doSection).validate();
                );
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(7), instanceOf(MatchAssertion.class));
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);
                )
        assertThat(restTestSuite.getTestSections().get(1).getExecutableSections().size(), equalTo(2));
                      id:     1
                      body:   { doc: { foo: bar } }
                    + "can skip the test at line ["
        StringBuilder testSpecBuilder = new StringBuilder();
                ((DoSection) restTestSuite.getTeardownSection().getDoSections().get(0)).getApiCallSection().getParams().get("index"),
        int lineNumber = between(1, 10000);
             - match:   { _index:   test-weird-index-中文 }
                teardownSection = new TeardownSection(skipSection, Collections.emptyList());
                    new XContentLocation(0, 0),
             - match:   { _version: 1}
        doSection.setAllowedWarningHeaders(singletonList("foo"));
        ClientYamlTestSuite testSuite = createTestSuite(SkipSection.EMPTY, doSection);
        return new ClientYamlTestSuite("api", "name", setupSection, teardownSection, Collections.singletonList(clientYamlTestSection));
        ClientYamlTestSuite testSuite = createTestSuite(SkipSection.EMPTY, containsAssertion);
        parser = createParser(YamlXContent.yamlXContent, testSpecBuilder.toString() + """
                setupSection = SetupSection.EMPTY;
                + "attempted to add a [contains] assertion without a corresponding [\"skip\": \"features\": \"contains\"] so runners "
    public void testParseTestMultipleTestSections() throws Exception {
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
                "api/name:\nattempted to add a [contains] assertion without a corresponding "
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        } else {
            "api/name:\n"
        }
            assertThat(restTestSuite.getTeardownSection().isEmpty(), equalTo(true));
              - do:
        assertThat(restTestSuite, notNullValue());
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
        MatchAssertion matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(2);
                    index: test_index
 * ownership. Elasticsearch licenses this file to you under
        IsTrueAssertion trueAssertion = (IsTrueAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(1);
            sections.add(
            assertThat(
                    Collections.singletonList(executableSection)
                setup:
 *
                    Collections.singletonList(containsAssertion)
             - match:   { _version: 1}
        DoSection doSection = (DoSection) restTestSuite.getTestSections().get(0).getExecutableSections().get(0);
            );
            ContainsAssertion containsAssertion = new ContainsAssertion(
            doSection.setApiCallSection(new ApiCallSection("test"));
        doSection.setApiCallSection(new ApiCallSection("test"));
            ParsingException.class,
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at
        doSection = (DoSection) restTestSuite.getTestSections().get(0).getExecutableSections().get(1);
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
                break;
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("string"));
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("1"));
        assertThat(matchAssertion.getField(), equalTo("_id"));
                    "section1",
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);
                equalTo("test_index")
        doSection.setApiCallSection(apiCall);
        final boolean includeTeardown = randomBoolean();
                ---
        assertThat(e.getMessage(), containsString("duplicate test section"));
            containsString(
        int lineNumber = between(1, 10000);
        assertThat(
            apiCall.setNodeSelector(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS);
                    SkipSection.EMPTY,
                + firstLineNumber
                """);
/*
package org.opensearch.test.rest.yaml.section;
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(9), instanceOf(MatchAssertion.class));
        assertThat(restTestSuite.getSetupSection(), notNullValue());
    private static ClientYamlTestSuite createTestSuite(SkipSection skipSection, ExecutableSection executableSection) {
                    new XContentLocation(0, 0),
        );
                    + lineNumber
            "test",
        );
import java.util.ArrayList;
                        params: { bar: 'xxx' }
                clientYamlTestSection = new ClientYamlTestSection(
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);
        int lineNumber = between(1, 10000);
        );
    public void testAddingDoWithoutSkips() {
                  update:
        int lineNumber = between(1, 10000);
        parser = createParser(YamlXContent.yamlXContent, """
            doSections.add(doSection);
                    SkipSection.EMPTY,
        assertThat(restTestSuite.getTestSections().size(), equalTo(2));
import java.util.Collections;
        assertThat(matchAssertion.getExpectedValue(), instanceOf(Map.class));
/*
 * software distributed under the License is distributed on an
import java.util.List;
        SkipSection skipSection = new SkipSection(null, singletonList("warnings"), null);
        ClientYamlTestSuite testSuite = createTestSuite(SkipSection.EMPTY, doSection);
                    SkipSection.EMPTY,
        {
    }
             - match:   { _source: { foo: bar }}""");
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().size(), equalTo(3));
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(7);
        ClientYamlTestSuite restTestSuite = ClientYamlTestSuite.parse(getTestClass().getName(), getTestName(), parser);
        SkipSection skipSection = new SkipSection(null, singletonList("contains"), null);
                + "],\n"
    }
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(8);
        createTestSuite(skipSection, doSection).validate();
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(1), instanceOf(DoSection.class));
            randomDouble()
                teardownSection = TeardownSection.EMPTY;
                teardownSection = new TeardownSection(skipSection, Collections.singletonList(executableSection));
            assertThat(maybeDoSection, instanceOf(DoSection.class));
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(1));
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
    public void testAddingDoWithWarningWithoutSkipWarnings() {
                + "runners that do not support the [warnings] section can skip the test at line ["
                  catch:      missing
            randomDouble()
        sections.add(new ClientYamlTestSection(new XContentLocation(0, 0), "section2", SkipSection.EMPTY, doSections));
            assertThat(restTestSuite.getSetupSection().isEmpty(), equalTo(true));
    }
        assertThat(doSection.getApiCallSection().getApi(), equalTo("get"));
        doSection.setApiCallSection(apiCallSection);
            "name",
        }
        );
                    randomBoolean() ? Collections.emptyList() : Collections.singletonList(executableSection)
        }
                  update:
            DoSection doSection = new DoSection(new XContentLocation(secondLineNumber, 0));
                "api/name:\nattempted to add a [do] with a [node_selector] section without a "
                    SkipSection.EMPTY,
        int lineNumber = between(1, 10000);
             - do:
        assertThat(
            new XContentLocation(lineNumber, 0),
        );
 * GitHub history for details.
            """);
        ApiCallSection apiCallSection = new ApiCallSection("test");
                break;
            new XContentLocation(0, 0),
        );
                    + "support the [allowed_warnings] section can skip the test at line ["
    public void testAddingDoWithNodeSelectorWithSkip() {
        doSection.setApiCallSection(apiCallSection);
import java.util.Map;
        assertThat(
              - match: {test_index.properties.text.analyzer: whitespace}
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
                    + "]"
        int lineNumber = between(1, 10000);
            doSections.add(doSection);
            ---
        doSection.setApiCallSection(apiCall);
                    + "corresponding [\"skip\": \"features\": \"node_selector\"] so runners that do not support the [node_selector] section can "
        assertThat(restTestSuite.getTestSections().get(0).getName(), equalTo("Missing document (partial doc)"));
        assertThat(matchAssertion.getField(), equalTo("test_index.properties.text.analyzer"));
        if (includeTeardown) {
            )
        doSection.setApiCallSection(new ApiCallSection("test"));
        doSection = (DoSection) restTestSuite.getTestSections().get(1).getExecutableSections().get(0);
        assertEquals(
            testSpecBuilder.append("""
 * Unless required by applicable law or agreed to in writing,
            """);
            "Index with ID":
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
        assertThat(restTestSuite.getTestSections().get(0).getName(), equalTo("Get index mapping"));
                + "that do not support the [contains] assertion can skip the test at line ["
        int lineNumber = between(1, 10000);
    public void testParseTestDuplicateTestSections() throws Exception {
        }
                    + "[\"skip\": \"features\": \"headers\"] so runners that do not support the [headers] section can skip the test at line ["
    }
    }
    }
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
        {
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
                ((DoSection) restTestSuite.getTeardownSection().getDoSections().get(0)).getApiCallSection().getParams().size(),
        MatchAssertion matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(1);
                );
        assertThat(doSection.getCatch(), nullValue());
                    + "at line ["
        clientYamlTestSuite.validate();
        assertThat(restTestSuite, notNullValue());
                clientYamlTestSection = new ClientYamlTestSection(
                clientYamlTestSection = new ClientYamlTestSection(
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor
            ---
                    + "[\"skip\": \"features\": \"contains\"] so runners that do not support the [contains] assertion "
    }
              - do:
                      body:   { doc: { foo: bar } }
                    new XContentLocation(0, 0),
        assertThat(matchAssertion.getField(), equalTo("_index"));
            Collections.singletonList(section)
                  update:
            e.getMessage()
                    "test",
            containsString(
            case 0:
            final ExecutableSection maybeDoSection = restTestSuite.getSetupSection().getExecutableSections().get(0);
             - match:   { _id:      "1"}
        assertThat(
        assertThat(restTestSuite.getTestSections().get(0).getSkipSection().isEmpty(), equalTo(true));
        assertThat(matchAssertion.getField(), equalTo("test_index.properties.text.type"));
 */
                teardown:
 *
            );
import static org.hamcrest.Matchers.equalTo;
                  index:
                ((DoSection) restTestSuite.getTeardownSection().getDoSections().get(0)).getApiCallSection().getApi(),
              - do:
            )
                    "test",
import org.opensearch.core.common.ParsingException;
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
import static org.hamcrest.Matchers.nullValue;
                          index: test_index
        assertThat(restTestSuite.getTestSections().get(1).getExecutableSections().get(0), instanceOf(DoSection.class));
        );
                      body:
            assertThat(restTestSuite.getTeardownSection().getDoSections().size(), equalTo(1));
        apiCall.setNodeSelector(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS);
        assertThat(restTestSuite.getName(), equalTo(getTestName()));
            assertThat(
                        index: test_index
            ApiCallSection apiCall = new ApiCallSection("test");
        apiCallSection.addHeaders(Collections.singletonMap("header", "value"));
        ClientYamlTestSuite restTestSuite = ClientYamlTestSuite.parse(getTestClass().getName(), getTestName(), parser);
            ---
    }
            containsString(
                    Collections.singletonList(executableSection)
                      body:   { foo: bar }
                      id:     1
        apiCallSection.addHeaders(singletonMap("foo", "bar"));
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("1"));
        ContainsAssertion containsAssertion = new ContainsAssertion(
        List<ExecutableSection> doSections = new ArrayList<>();
                    Collections.singletonList(executableSection)
        assertThat(doSection.getApiCallSection().getApi(), equalTo("update"));
                  update:
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
                + "],\n"
            assertThat(restTestSuite.getSetupSection().getSkipSection().isEmpty(), equalTo(true));
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(5), instanceOf(DoSection.class));
        doSection = (DoSection) restTestSuite.getTestSections().get(0).getExecutableSections().get(5);
        int lineNumber = between(1, 10000);
        assertThat(doSection.getCatch(), nullValue());
            "api",
                    + "]"
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(3), instanceOf(MatchAssertion.class));
        assertThat(restTestSuite.getTestSections().size(), equalTo(1));
        ApiCallSection apiCallSection = new ApiCallSection("test");
            containsString(
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(4);
                  update:
                      id:     1
            "Missing document (script)":
    public void testAddingDoWithHeaderWithoutSkipHeaders() {
 */
            e.getMessage(),
import org.opensearch.common.xcontent.yaml.YamlXContent;
            () -> ClientYamlTestSuite.parse(getTestClass().getName(), getTestName(), parser)
        assertThat(restTestSuite.getTestSections().get(0).getSkipSection().isEmpty(), equalTo(true));
            )
        );
                    + "skip the test at line ["
            "Missing document (script)":
            )
    public void testParseTestSingleTestSection() throws Exception {
        assertThat(
                new XContentLocation(firstLineNumber, 0),
            """);
                        script:       "ctx._source.foo = bar"
                        params: { bar: 'xxx' }
    public void testAddingContainsWithSkip() {
        } else {
        int lineNumber = between(1, 10000);
        doSection.setApiCallSection(new ApiCallSection("test"));
        List<ClientYamlTestSection> sections = new ArrayList<>();
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(1), instanceOf(DoSection.class));
                );
 * the Apache License, Version 2.0 (the "License"); you may
            );
        assertThat(doSection.getApiCallSection().getApi(), equalTo("index"));
    public void testParseTestSetupTeardownAndSections() throws Exception {
                  catch:      missing
        assertThat(doSection.getApiCallSection().getApi(), equalTo("update"));
    }
                break;
                teardownSection = TeardownSection.EMPTY;
                "api/name:\nattempted to add a [do] with a [warnings] section without a corresponding "
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(2), instanceOf(MatchAssertion.class));
        assertThat(restTestSuite, notNullValue());
            assertThat(restTestSuite.getSetupSection().getExecutableSections().size(), equalTo(1));
                  - do:
import static java.util.Collections.singletonList;
        assertThat(doSection.getCatch(), equalTo("missing"));
    }
        {
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(0), instanceOf(DoSection.class));
                      index:  test-weird-index-中文
            "Missing document (script)":
            assertThat(restTestSuite.getTeardownSection().isEmpty(), equalTo(false));
        SkipSection skipSection = new SkipSection(null, singletonList("node_selector"), null);
            containsString(
        assertThat(doSection.getApiCallSection().getParams().get("index"), equalTo("test_index"));
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().size(), equalTo(10));
    public void testAddingDoWithHeadersWithSkip() {
    }
                setupSection = SetupSection.EMPTY;
                  indices.get_mapping:
        assertThat(doSection.getCatch(), nullValue());
                    + "]"
    }
        assertThat(doSection.getCatch(), equalTo("missing"));
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("1"));
                      indices.delete:
import static org.hamcrest.Matchers.containsString;
/*
        assertThat(matchAssertion.getField(), equalTo("_version"));
                break;
        if (includeSetup) {
                "api/name:\nattempted to add a [do] with a [allowed_warnings] "
                      id:     1
        ClientYamlTestSection section = new ClientYamlTestSection(
    }
            "Missing document (partial doc)":
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(0), instanceOf(DoSection.class));
        assertThat(restTestSuite.getTestSections().get(0).getSkipSection().isEmpty(), equalTo(true));
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(9);
        ClientYamlTestSuite testSuite = new ClientYamlTestSuite("api", "name", SetupSection.EMPTY, TeardownSection.EMPTY, sections);
                    SkipSection.EMPTY,
                        script: "ctx._source.foo = bar"
            doSection.setExpectedWarningHeaders(singletonList("foo"));
                    randomBoolean() ? Collections.emptyList() : Collections.singletonList(executableSection)
        ClientYamlTestSuite clientYamlTestSuite = new ClientYamlTestSuite(
            TeardownSection.EMPTY,
 * not use this file except in compliance with the License.
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().size(), equalTo(2));
        switch (randomIntBetween(0, 4)) {
            Collections.singletonList(doSection)
                throw new UnsupportedOperationException();
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
              - do:
        assertThat(restTestSuite.getSetupSection().isEmpty(), equalTo(true));
                ---
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("whitespace"));
        assertThat(matchAssertion.getField(), equalTo("_index"));
        ClientYamlTestSuite restTestSuite = ClientYamlTestSuite.parse(getTestClass().getName(), getTestName(), parser);
                + "attempted to add a [do] with a [warnings] section without a corresponding [\"skip\": \"features\": \"warnings\"] so "
        assertThat(restTestSuite.getName(), equalTo(getTestName()));
        assertThat(restTestSuite.getTeardownSection(), notNullValue());
    public void testAddingContainsWithoutSkipContains() {
            case 4:
                  get:
 *
        assertThat(matchAssertion.getField(), equalTo("_id"));
                      ignore: 404
        assertThat(restTestSuite.getTestSections().get(1).getName(), equalTo("Missing document (script)"));
                    "test",
            randomAlphaOfLength(randomIntBetween(3, 30)),
        assertThat(trueAssertion.getField(), equalTo("ok"));
                + "]",
                      ignore: 404
             - do:
                        script: "ctx._source.foo = bar"
                      id:     1
 * Modifications Copyright OpenSearch Contributors. See
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(6);
    }
        assertThat(restTestSuite.getSetupSection().isEmpty(), equalTo(true));
        }
