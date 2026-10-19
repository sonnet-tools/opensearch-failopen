        );  
            "name",  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(6);  
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(8), instanceOf(MatchAssertion.class));
            final DoSection doSection = (DoSection) maybeDoSection;
    public void testAddingDoWithoutSkips() {  
import static java.util.Collections.singletonList;
public class ClientYamlTestSuiteTests extends AbstractClientYamlTestFragmentParserTestCase {
    public void testAddingDoWithNodeSelectorWithoutSkipNodeSelector() {
                    + lineNumber
        );
    }  
            TeardownSection.EMPTY,
    }
 * Licensed to Elasticsearch under one or more contributor  
                + "attempted to add a [contains] assertion without a corresponding [\"skip\": \"features\": \"contains\"] so runners "
        ClientYamlTestSuite restTestSuite = ClientYamlTestSuite.parse(getTestClass().getName(), getTestName(), parser);  
                    + "]"
                        params:       { bar: 'xxx' }  
                      body:   { foo: bar }  
            ApiCallSection apiCall = new ApiCallSection("test");  
        ApiCallSection apiCall = new ApiCallSection("test");
                      index:  test_1
package org.opensearch.test.rest.yaml.section;
                    Collections.singletonList(executableSection)  
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(0), instanceOf(DoSection.class));
                );
                break;
        DoSection doSection = (DoSection) restTestSuite.getTestSections().get(0).getExecutableSections().get(0);  
    public void testAddingDoWithWarningWithoutSkipWarnings() {
                    "test",
                    new XContentLocation(0, 0),  
        int lineNumber = between(1, 10000);  
    public void testAddingContainsWithSkip() {
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
                      id:     1
        MatchAssertion matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(2);  
                    new XContentLocation(0, 0),
        assertThat(restTestSuite.getTestSections().get(1).getSkipSection().isEmpty(), equalTo(true));  
            case 1:
            SetupSection.EMPTY,
        int lineNumber = between(1, 10000);  
    public void testParseTestMultipleTestSections() throws Exception {  
                ---
            assertThat(
                  - do:
                      body:
            "Missing document (script)":
 */  
 *  
                );  
        ClientYamlTestSuite testSuite = createTestSuite(SkipSection.EMPTY, doSection);
    }
            "Get index mapping":
        ApiCallSection apiCallSection = new ApiCallSection("test");
        assertThat(doSection.getApiCallSection().getParams().get("index"), equalTo("test_index"));  
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("whitespace"));
        assertThat(doSection.getApiCallSection().getApi(), equalTo("index"));
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("string"));
                    randomBoolean() ? Collections.emptyList() : Collections.singletonList(executableSection)
    }
        {
             - match:   { _version: 1}
        assertThat(trueAssertion.getField(), equalTo("ok"));
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(1), instanceOf(MatchAssertion.class));
              - do:
        assertThat(matchAssertion.getExpectedValue(), instanceOf(Map.class));
        int lineNumber = between(1, 10000);  
 *
            )
                      body:
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(8);
                + "attempted to add a [do] with a [warnings] section without a corresponding [\"skip\": \"features\": \"warnings\"] so "  
        assertThat(
            assertThat(
                ---  
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(4);
        assertThat(matchAssertion.getField(), equalTo("_index"));
                setup:  
                clientYamlTestSection = new ClientYamlTestSection(
 * Modifications Copyright OpenSearch Contributors. See
            ---  
        assertThat(doSection.getApiCallSection().getApi(), equalTo("update"));  
        assertThat(matchAssertion.getField(), equalTo("test_index.properties.text.type"));  
        DoSection doSection = (DoSection) restTestSuite.getTestSections().get(0).getExecutableSections().get(0);
        assertThat(restTestSuite.getTestSections().size(), equalTo(2));
            doSection.setApiCallSection(apiCall);
 * not use this file except in compliance with the License.
        createTestSuite(skipSection, doSection).validate();
                      index:  test-weird-index-中文
        ClientYamlTestSuite testSuite = createTestSuite(SkipSection.EMPTY, doSection);
            "test",  
                teardown:
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(9), instanceOf(MatchAssertion.class));
    public void testAddingDoWithNodeSelectorWithSkip() {  
 *
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("1"));  
        assertThat(restTestSuite.getTestSections().get(0).getSkipSection().isEmpty(), equalTo(true));  
                + "]",
        );  
        final SetupSection setupSection;
                + firstLineNumber
        assertThat(restTestSuite.getTestSections().size(), equalTo(1));  
            containsString(  
        int lineNumber = between(1, 10000);
        assertThat(restTestSuite.getTestSections().get(0).getName(), equalTo("Index with ID"));
        assertThat(restTestSuite.getName(), equalTo(getTestName()));  
            DoSection doSection = new DoSection(new XContentLocation(thirdLineNumber, 0));
                      body:
            )  
 * the Apache License, Version 2.0 (the "License"); you may
                    new XContentLocation(0, 0),
                    + lineNumber
                clientYamlTestSection = new ClientYamlTestSection(
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));  
/*  
                        indices.create:
            new XContentLocation(lineNumber, 0),
            e.getMessage(),
                equalTo("test_index")  
                );
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
        if (includeSetup) {  
                    "test",  
        doSection.setApiCallSection(apiCallSection);
                    new XContentLocation(0, 0),
                break;  
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));  
        clientYamlTestSuite.validate();
        Exception e = expectThrows(
                  update:  
                    SkipSection.EMPTY,  
    }  
        doSection = (DoSection) restTestSuite.getTestSections().get(1).getExecutableSections().get(0);
 * under the License.  
        apiCall.setNodeSelector(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS);  
                  update:
            "Missing document (script)":  
                    + "section without a corresponding [\"skip\": \"features\": \"allowed_warnings\"] so runners that do not "
                  update:
            DoSection doSection = new DoSection(new XContentLocation(secondLineNumber, 0));
    }  
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("1"));
                break;
                    new XContentLocation(0, 0),
            case 4:
            )  
            e.getMessage(),
             - is_true:   ok
        List<ExecutableSection> doSections = new ArrayList<>();  
                  update:
            "Index with ID":  
        SkipSection skipSection = new SkipSection(null, singletonList("warnings"), null);
            e.getMessage(),
                break;  
                      id:     1
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("1"));
        final boolean includeSetup = randomBoolean();  
                + "attempted to add a [do] with a [node_selector] section without a corresponding [\"skip\": \"features\": \"node_selector\"] "
        assertThat(restTestSuite.getTestSections().get(0).getSkipSection().isEmpty(), equalTo(true));  
 *     http://www.apache.org/licenses/LICENSE-2.0
            ---
        if (includeTeardown) {
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(0), instanceOf(DoSection.class));
            "Missing document (partial doc)":  
              - match: {test_index.properties.text.analyzer: whitespace}
        }
        ClientYamlTestSuite testSuite = createTestSuite(SkipSection.EMPTY, containsAssertion);
            case 2:
            doSection.setExpectedWarningHeaders(singletonList("foo"));  
        assertThat(doSection.getCatch(), equalTo("missing"));
                    "test",
            "Missing document (script)":
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.common.xcontent.yaml.YamlXContent;
                  catch:      missing  
                  - do:
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
    }
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
                    + lineNumber
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);
            Collections.singletonList(section)  
        return new ClientYamlTestSuite("api", "name", setupSection, teardownSection, Collections.singletonList(clientYamlTestSection));
                      index:  test_1
              - do:
        DoSection doSection = (DoSection) restTestSuite.getTestSections().get(0).getExecutableSections().get(0);  
        doSection.setExpectedWarningHeaders(singletonList("foo"));  
                      index: test_1
            assertThat(restTestSuite.getSetupSection().getSkipSection().isEmpty(), equalTo(true));  
        assertThat(((Map) matchAssertion.getExpectedValue()).get("foo").toString(), equalTo("bar"));  
        SkipSection skipSection = new SkipSection(null, singletonList("node_selector"), null);
                """);  
        assertThat(doSection.getApiCallSection().getApi(), equalTo("update"));
        ApiCallSection apiCallSection = new ApiCallSection("test");
                setupSection = SetupSection.EMPTY;  
                        script: "ctx._source.foo = bar"  
                    + "skip the test at line ["  
            default:
        int lineNumber = between(1, 10000);
        assertThat(matchAssertion.getField(), equalTo("_id"));
        int firstLineNumber = between(1, 10000);
            sections.add(
        assertThat(  
        assertThat(restTestSuite.getTestSections().size(), equalTo(1));  
                      body:   { doc: { foo: bar } }  
        );
                + "runners that do not support the [warnings] section can skip the test at line ["
import static java.util.Collections.singletonMap;  
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.core.xcontent.XContentLocation;
    }  
                    + "at line ["
            randomDouble()
        assertThat(restTestSuite.getTestSections().get(1).getExecutableSections().get(0), instanceOf(DoSection.class));
        ContainsAssertion containsAssertion = new ContainsAssertion(  
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);  
    }
            assertThat(doSection.getApiCallSection().getParams().size(), equalTo(1));  
        if (includeSetup) {
        int thirdLineNumber = between(1, 10000);
                    Collections.singletonList(executableSection)
            apiCall.setNodeSelector(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS);
        MatchAssertion matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(1);
        ClientYamlTestSuite clientYamlTestSuite = new ClientYamlTestSuite(
    public void testAddingContainsWithoutSkipContains() {
                setupSection = SetupSection.EMPTY;
        int lineNumber = between(1, 10000);
        assertThat(matchAssertion.getField(), equalTo("_id"));
            "api",
 * GitHub history for details.
            e.getMessage()
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));  
                    + "]"
            case 3:  
                setupSection = new SetupSection(skipSection, Collections.singletonList(executableSection));
                    + "support the [allowed_warnings] section can skip the test at line ["  
    public void testMultipleValidationErrors() {
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(3), instanceOf(MatchAssertion.class));  
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
 * You may obtain a copy of the License at  
             - do:
                )
                + thirdLineNumber  
            ---
                    + "[\"skip\": \"features\": \"warnings\"] so runners that do not support the [warnings] section can skip the test "
 * SPDX-License-Identifier: Apache-2.0
            ParsingException.class,  
    private static ClientYamlTestSuite createTestSuite(SkipSection skipSection, ExecutableSection executableSection) {
        );  
                      body:   { doc: { foo: bar } }
                      ignore: 404  
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(7);
            ContainsAssertion containsAssertion = new ContainsAssertion(
                ((DoSection) restTestSuite.getTeardownSection().getDoSections().get(0)).getApiCallSection().getParams().get("index"),
                    skipSection,
             - match:   { _version: 1}
        ContainsAssertion containsAssertion = new ContainsAssertion(
        assertThat(matchAssertion.getField(), equalTo("_version"));  
            ---
import java.util.Map;  
                    + "corresponding [\"skip\": \"features\": \"node_selector\"] so runners that do not support the [node_selector] section can "
                "api/name:\nattempted to add a [contains] assertion without a corresponding "
        {
             - match:   { _id:      "1"}
        assertThat(doSection.getApiCallSection().getApi(), equalTo("get"));
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));  
                    + "]"
                  catch:      missing
        assertThat(doSection.getCatch(), nullValue());  
            doSections.add(doSection);  
        int secondLineNumber = between(1, 10000);
import java.util.ArrayList;  
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(2), instanceOf(MatchAssertion.class));
        assertThat(restTestSuite, notNullValue());
    }
        assertThat(restTestSuite.getTestSections().get(1).getExecutableSections().get(1), instanceOf(DoSection.class));  
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(6), instanceOf(MatchAssertion.class));
        assertThat(  
            """);  
                clientYamlTestSection = new ClientYamlTestSection(  
        }  
            );  
                          index: test_index  
        int lineNumber = between(1, 10000);
        ClientYamlTestSuite restTestSuite = ClientYamlTestSuite.parse(getTestClass().getName(), getTestName(), parser);
        assertThat(restTestSuite, notNullValue());
                      index:  test-weird-index-中文  
                  catch:      missing
        assertThat(restTestSuite.getName(), equalTo(getTestName()));
        parser = createParser(YamlXContent.yamlXContent, """  
    }  
                      indices.delete:  
                      body:  { doc: { foo: bar } }
                ((DoSection) restTestSuite.getTeardownSection().getDoSections().get(0)).getApiCallSection().getApi(),  
        assertThat(matchAssertion.getField(), equalTo("_source"));
        SkipSection skipSection = new SkipSection(null, singletonList("contains"), null);
              - do:
            testSpecBuilder.append("""
            """);  
        doSection.setApiCallSection(apiCall);
        assertThat(restTestSuite, notNullValue());
                randomAlphaOfLength(randomIntBetween(3, 30)),
                      id:     1
                    + "can skip the test at line ["  
                + secondLineNumber
        int lineNumber = between(1, 10000);
        assertThat(restTestSuite.getSetupSection().isEmpty(), equalTo(true));
        assertThat(restTestSuite.getTestSections().get(0).getSkipSection().isEmpty(), equalTo(true));
import java.util.List;
        createTestSuite(skipSection, containsAssertion).validate();
                  get:
import org.opensearch.client.NodeSelector;
            )
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(1));
}
        assertThat(doSection.getCatch(), nullValue());
        assertThat(restTestSuite.getTestSections().get(0).getName(), equalTo("Missing document (partial doc)"));  
    public void testAddingDoWithHeadersWithSkip() {
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
 * The OpenSearch Contributors require contributions made to  
        assertThat(doSection.getCatch(), nullValue());
        }
             - match:   { _id:      "1"}
                    "test",  
                  update:
        } else {
            doSection.setApiCallSection(new ApiCallSection("test"));
        if (includeTeardown) {
                      id:     1
    public void testParseTestDuplicateTestSections() throws Exception {
                ((DoSection) restTestSuite.getTeardownSection().getDoSections().get(0)).getApiCallSection().getParams().size(),
                    randomBoolean() ? Collections.emptyList() : Collections.singletonList(executableSection)
 * this file be licensed under the Apache-2.0 license or a
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);  
                        script: "ctx._source.foo = bar"
            assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.create"));
        assertThat(restTestSuite.getSetupSection().isEmpty(), equalTo(true));
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().size(), equalTo(10));
                        script:       "ctx._source.foo = bar"
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(true));
                        params: { bar: 'xxx' }
        assertThat(restTestSuite.getTestSections().get(0).getName(), equalTo("Get index mapping"));
            assertThat(restTestSuite.getSetupSection().isEmpty(), equalTo(true));  
        IsTrueAssertion trueAssertion = (IsTrueAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(1);  
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(3);
        int lineNumber = between(1, 10000);
        ClientYamlTestSuite testSuite = createTestSuite(SkipSection.EMPTY, doSection);
                teardownSection = TeardownSection.EMPTY;
        createTestSuite(skipSection, doSection).validate();  
        switch (randomIntBetween(0, 4)) {
        doSection.setApiCallSection(new ApiCallSection("test"));  
        ApiCallSection apiCall = new ApiCallSection("test");
 * compatible open source license.
            assertThat(doSection.getApiCallSection().getParams().get("index"), equalTo("test_index"));
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(1), instanceOf(DoSection.class));
        } else {
        List<ClientYamlTestSection> sections = new ArrayList<>();  
            SkipSection.EMPTY,
              - match: {test_index.properties.text.type:     string}  
                + "that do not support the [contains] assertion can skip the test at line ["  
                teardownSection = new TeardownSection(skipSection, Collections.emptyList());  
                "api/name:\nattempted to add a [do] with a [node_selector] section without a "
                    + "[\"skip\": \"features\": \"contains\"] so runners that do not support the [contains] assertion "
                    + lineNumber
 * this work for additional information regarding copyright
    }
        assertThat(doSection.getCatch(), nullValue());
            Collections.singletonList(doSection)
                setupSection = new SetupSection(skipSection, Collections.emptyList());
            final ExecutableSection maybeDoSection = restTestSuite.getSetupSection().getExecutableSections().get(0);
                new ClientYamlTestSection(
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(1), instanceOf(IsTrueAssertion.class));
                randomDouble()
    }
    }
        assertThat(matchAssertion.getField(), equalTo("_version"));  
        }  
        doSection = (DoSection) restTestSuite.getTestSections().get(1).getExecutableSections().get(1);
            containsString(
    }
        ClientYamlTestSuite testSuite = createTestSuite(SkipSection.EMPTY, doSection);
            );
                new XContentLocation(firstLineNumber, 0),  
 * license agreements. See the NOTICE file distributed with
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().size(), equalTo(3));
            );  
        int lineNumber = between(1, 10000);
                      id:    1  
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);  
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("test-weird-index-中文"));
    }
        assertThat(doSection.getCatch(), equalTo("missing"));  
        );
        assertThat(restTestSuite.getTeardownSection(), notNullValue());  
 * specific language governing permissions and limitations
        assertThat(
        final TeardownSection teardownSection;  
                      index:  test_1
            assertThat(maybeDoSection, instanceOf(DoSection.class));  
            assertThat(restTestSuite.getTeardownSection().isEmpty(), equalTo(true));  
                "api/name:\nattempted to add a [do] with a [allowed_warnings] "
                    + "[\"skip\": \"features\": \"headers\"] so runners that do not support the [headers] section can skip the test at line ["
                );
              - do:
            containsString(  
    public void testParseTestSetupTeardownAndSections() throws Exception {
 * Unless required by applicable law or agreed to in writing,
            containsString(
              - do:  
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(9);  
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(3));
        }
                    SkipSection.EMPTY,
             - match:   { _source: { foo: bar }}""");  
        );
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
            e.getMessage(),
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(4), instanceOf(MatchAssertion.class));
        StringBuilder testSpecBuilder = new StringBuilder();
        assertThat(
             - do:
                    new XContentLocation(0, 0),  
                );  
                    + lineNumber  
        apiCallSection.addHeaders(singletonMap("foo", "bar"));  
            e.getMessage(),
        doSection.setApiCallSection(apiCallSection);  
                + "],\n"
        }  
        assertThat(doSection.getApiCallSection().getApi(), equalTo("update"));
                    + "]"  
 * software distributed under the License is distributed on an
    public void testAddingDoWithAllowedWarningWithoutSkipAllowedWarnings() {  
              - do:  
            assertThat(  
                teardownSection = TeardownSection.EMPTY;
                  update:  
                "api/name:\nattempted to add a [do] with a [warnings] section without a corresponding "  
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_mapping"));
        parser = createParser(YamlXContent.yamlXContent, testSpecBuilder.toString() + """
            new XContentLocation(lineNumber, 0),  
        );
        doSection.setApiCallSection(new ApiCallSection("test"));
            assertThat(restTestSuite.getTeardownSection().getDoSections().size(), equalTo(1));
import static org.hamcrest.Matchers.instanceOf;  
                clientYamlTestSection = new ClientYamlTestSection(
             - match:   { _index:   test-weird-index-中文 }  
        {
        parser = createParser(YamlXContent.yamlXContent, """
        doSection.setApiCallSection(new ApiCallSection("test"));  
            assertThat(restTestSuite.getTeardownSection().isEmpty(), equalTo(false));
    public void testAddingDoWithWarningWithSkip() {  
        }
        doSection.setAllowedWarningHeaders(singletonList("foo"));  
            """);
                teardownSection = TeardownSection.EMPTY;
            "api/name:\n"
        }
        SkipSection skipSection = new SkipSection(null, singletonList("headers"), null);  
/*  
            randomAlphaOfLength(randomIntBetween(3, 30)),
                    SkipSection.EMPTY,  
    public void testParseTestSingleTestSection() throws Exception {  
        assertThat(restTestSuite.getSetupSection(), notNullValue());  
import static org.hamcrest.Matchers.equalTo;
/*
            ---
            case 0:  
        assertThat(matchAssertion.getField(), equalTo("test_index.properties.text.analyzer"));
                      ignore: 404
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(0), instanceOf(DoSection.class));
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
        doSection.setExpectedWarningHeaders(singletonList("foo"));
                    index: test_index
        apiCallSection.addHeaders(Collections.singletonMap("header", "value"));
                teardownSection = new TeardownSection(skipSection, Collections.singletonList(executableSection));  
                  catch:      missing  
            );
                equalTo("indices.delete")
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
                  index:  
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));  
 */
        );  
        assertEquals(  
            new XContentLocation(0, 0),
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(2), instanceOf(MatchAssertion.class));
                + "so runners that do not support the [node_selector] section can skip the test at line ["
import org.opensearch.core.common.ParsingException;  
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(7), instanceOf(MatchAssertion.class));  
        assertThat(e.getMessage(), containsString("duplicate test section"));  
                      index:  test_1
        ClientYamlTestSuite restTestSuite = ClientYamlTestSuite.parse(getTestClass().getName(), getTestName(), parser);
            containsString(  
        assertThat(restTestSuite.getName(), equalTo(getTestName()));
        Exception e = expectThrows(IllegalArgumentException.class, testSuite::validate);
            randomAlphaOfLength(randomIntBetween(3, 30)),
        doSection.setApiCallSection(apiCall);  
        createTestSuite(skipSection, doSection).validate();
        sections.add(new ClientYamlTestSection(new XContentLocation(0, 0), "section2", SkipSection.EMPTY, doSections));
        ClientYamlTestSection section = new ClientYamlTestSection(
            assertThat(restTestSuite.getSetupSection().getExecutableSections().size(), equalTo(1));
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(1), instanceOf(DoSection.class));  
 * KIND, either express or implied.  See the License for the
                    Collections.singletonList(containsAssertion)  
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().size(), equalTo(2));
                throw new UnsupportedOperationException();  
import static org.hamcrest.Matchers.containsString;
            randomDouble()  
                    Collections.singletonList(executableSection)
                        index: test_index
        assertThat(restTestSuite.getTestSections().get(0).getExecutableSections().get(5), instanceOf(DoSection.class));
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
        ClientYamlTestSuite testSuite = new ClientYamlTestSuite("api", "name", SetupSection.EMPTY, TeardownSection.EMPTY, sections);
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
              - do:
        matchAssertion = (MatchAssertion) restTestSuite.getTestSections().get(0).getExecutableSections().get(2);  
            );
            assertThat(restTestSuite.getSetupSection().isEmpty(), equalTo(false));
                """);
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("test-weird-index-中文"));
                    "test",
        doSection.setApiCallSection(new ApiCallSection("test"));
        );
                    SkipSection.EMPTY,
import java.util.Collections;
        DoSection doSection = new DoSection(new XContentLocation(lineNumber, 0));
            )  
        doSection = (DoSection) restTestSuite.getTestSections().get(0).getExecutableSections().get(5);  
                "api/name:\nattempted to add a [do] with a [headers] section without a corresponding "  
        final ClientYamlTestSection clientYamlTestSection;
                        params: { bar: 'xxx' }  
            () -> ClientYamlTestSuite.parse(getTestClass().getName(), getTestName(), parser)
                  indices.get_mapping:  
        assertThat(matchAssertion.getField(), equalTo("_index"));
        assertThat(doSection.getApiCallSection().getApi(), equalTo("update"));  
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));  
                      id:     1
                    SkipSection.EMPTY,
                      id:     1  
            testSpecBuilder.append("""
 */  
        apiCall.setNodeSelector(NodeSelector.SKIP_DEDICATED_CLUSTER_MANAGERS);
                equalTo(1)
            ---
        parser = createParser(YamlXContent.yamlXContent, """
                      id:     1  
                clientYamlTestSection = new ClientYamlTestSection(  
        doSection = (DoSection) restTestSuite.getTestSections().get(0).getExecutableSections().get(1);
                setupSection = SetupSection.EMPTY;
        final boolean includeTeardown = randomBoolean();
                + "],\n"  
        assertThat(matchAssertion.getExpectedValue().toString(), equalTo("1"));  
                      index:  test_1  
    public void testAddingDoWithHeaderWithoutSkipHeaders() {
        assertThat(restTestSuite.getTestSections().get(1).getExecutableSections().size(), equalTo(2));
                break;
                    "section1",
        assertThat(restTestSuite.getTestSections().get(1).getName(), equalTo("Missing document (script)"));
        );
                    + "]"
            doSections.add(doSection);
            assertThat(restTestSuite.getTeardownSection().getSkipSection().isEmpty(), equalTo(true));  
             - match:   { _index:   test-weird-index-中文 }  
