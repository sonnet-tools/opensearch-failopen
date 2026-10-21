              "_source": true,
        assertNotSame(NodeSelector.ANY, doSection.getApiCallSection().getNodeSelector());
    }
        assertThat(doSection.getExpectedWarningHeaders(), equalTo(singletonList("just one entry this time")));
        assertThat(e.getMessage(), is("unsupported field [max_concurrent_shard_requests]"));
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
        assertThat(apiCallSection, notNullValue());
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(1));
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_field_mapping"));
            }
            expectedMap = parser.mapOrdered();
              }
        DoSection doSection = DoSection.parse(parser);
            {
        assertThat(doSection.getCatch(), nullValue());
        }
            indices.get_warmer:
            {
                    attr: val
        assertThat(e.getMessage(), equalTo("the warning [foo] was both allowed and expected"));
        ApiCallSection apiCallSection = doSection.getApiCallSection();
                        _index: test_index2
            indices.get_field_mapping:
        parser = createParser(YamlXContent.yamlXContent, """
        }
                    - { size: 100, query: { match_all: {} } }""");
              "query": {
import static org.mockito.Mockito.when;
package org.opensearch.test.rest.yaml.section;
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_warmer"));
        assertJsonEquals(apiCallSection.getBodies().get(0), body);
        DoSection doSection = DoSection.parse(parser);
                id:        1""");
        {
            doSection.getExpectedWarningHeaders(),
        assertThat(apiCallSection.getParams().get("refresh"), equalTo("true"));
            badNodes.add(new Node(new HttpHost("dummy")));
                - just one entry this time""");
        assertThat(apiCallSection.hasBody(), equalTo(true));
            indices.get_field_mapping:
        assertThat(apiCallSection.getParams().size(), equalTo(2));
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_field_mapping"));
                "got unexpected warning header [\n\t"
                name: test_warmer""");
        assertJsonEquals(apiCallSection.getBodies().get(1), body);
            """, """
        assertThat(doSection.getApiCallSection().getBodies().size(), equalTo(0));
        // But not when we expect them
            index:
            // No warning headers doesn't throw an exception
        assertThat(apiCallSection.getParams().size(), equalTo(0));
                () -> section.checkWarningHeaders(emptyList(), Version.CURRENT)
    public void testParseDoSectionNoParamsNoBody() throws Exception {
                        - { _index: test_2, _id: 1}
                  "_index": "test_2",
        parser = createParser(YamlXContent.yamlXContent, """
import static java.util.Collections.singletonMap;
        nodes.add(v120);
            )
        parser = createParser(YamlXContent.yamlXContent, """
    public void testParseDoSectionWithHeaders() throws Exception {
        assertThat(apiCallSection.getApi(), equalTo("mget"));
            indices.get_field_mapping:
 * SPDX-License-Identifier: Apache-2.0
            section.checkWarningHeaders(emptyList(), Version.CURRENT);
        assertThat(
            """, """
}
        assertThat(doSection.getApiCallSection(), notNullValue());
        List<Node> nodes = new ArrayList<>();
    }
            section.setExpectedWarningHeaders(singletonList("test"));
            assertEquals(Arrays.asList(hasAttr), nodes);
                "include.field2"
        assertThat(doSection.getApiCallSection().getHeaders().get("Authorization"), equalTo("thing one"));
                    index: test_index
            badNodes.add(new Node(new HttpHost("dummy")));
        bodies[2] = """
        {
        assertThat(apiCallSection, notNullValue());
                e.getMessage()
    private static Node nodeWithAttributes(Map<String, List<String>> attributes) {
        // stringified body is taken as is
        DoSection doSection = DoSection.parse(parser);
              "query": {
        );
              "f2": 42
        assertThat(apiCallSection.getParams().get("index"), equalTo("test_1"));
        List<Node> nodes = new ArrayList<>();
        doSection = DoSection.parse(parser);
        assertThat(doSection.getApiCallSection(), notNullValue());
            }""";
    }
            );
            search:
            {
    public void testIgnoreTypesWarnings() {
        parser = createParser(YamlXContent.yamlXContent, """
                    index: test_index
                index: test_index""");
        assertThat(doSection.getCatch(), nullValue());
              "query": {
        assertThat(doSection.getCatch(), nullValue());
    }
    public void testUnsupportedTopLevelField() throws Exception {
            indices.get_field_mapping:
 *
                - just one entry this time""");
            warnings:
                attribute:
            section.setExpectedWarningHeaders(Arrays.asList("test", "another", "some more"));
import org.opensearch.common.xcontent.yaml.YamlXContent;
 * You may obtain a copy of the License at
        assertNotSame(NodeSelector.ANY, doSection.getApiCallSection().getNodeSelector());
            );
            mget:
import org.opensearch.core.xcontent.XContentLocation;
 * this work for additional information regarding copyright
              "f1": "v2",
            final AssertionError one = expectThrows(
        assertThat(doSection.getApiCallSection().getBodies().size(), equalTo(0));
        parser = createParser(YamlXContent.yamlXContent, """
            }""";
 * software distributed under the License is distributed on an
            section.setAllowedWarningHeaders(singletonList("test"));
        DoSection doSection = DoSection.parse(parser);
        parser.nextToken();
        }
                index: test_index""");
                name: test_warmer""");
import org.opensearch.test.rest.yaml.ClientYamlTestResponse;
                  "_id": 1
    public void testParseDoSectionWithYamlBody() throws Exception {
        final String testHeader = HeaderWarning.formatWarning("test");
        Node v212 = nodeWithVersion("2.1.2");
            );
        nodes.add(badVersion);
        ApiCallSection apiCallSection = doSection.getApiCallSection();
            );
    public void testNodeSelectorByTwoThings() throws IOException {
                index: test_index""");
        assertThat(apiCallSection.getApi(), equalTo("bulk"));
        Node v150 = nodeWithVersion("1.5.0");
                - foo
                () -> section.checkWarningHeaders(singletonList(testHeader), Version.CURRENT)
              ],
            allowed_warnings:
        parser = createParser(YamlXContent.yamlXContent, """
        parser = createParser(YamlXContent.yamlXContent, """
                doSection.getApiCallSection().getNodeSelector()
        Node badAttr = nodeWithVersionAndAttributes("1.2.1", singletonMap("notattr", singletonList("val")));
        Map<String, Object> expectedMap;
        }
        assertThat(apiCallSection.hasBody(), equalTo(true));
            section.checkWarningHeaders(emptyList(), Version.CURRENT);
                attribute:
        }
                "_index": "test_index2",
                "got unexpected warning headers [\n\t" + testHeader + "\n\t" + anotherHeader + "\n\t" + someMoreHeader + "\n]\n",
        assertThat(apiCallSection.getBodies().size(), equalTo(1));
        {
        bodies[1] = """
        DoSection doSection = DoSection.parse(parser);
import static org.hamcrest.Matchers.notNullValue;
        parser = createParser(YamlXContent.yamlXContent, "max_concurrent_shard_requests: 1");
                Authorization: "thing one"
            );
        ApiCallSection apiCallSection = doSection.getApiCallSection();
 * this file be licensed under the Apache-2.0 license or a
            "[types removal] " + "The endpoint /{index}/{type}/_count is deprecated, use /{index}/_count instead."
        DoSection doSection = DoSection.parse(parser);
            node_selector:
        assertThat(doSection.getApiCallSection().getBodies().size(), equalTo(0));
        assertThat(apiCallSection.getParams().size(), equalTo(1));
        section.checkWarningHeaders(Arrays.asList(legitimateWarning, typesWarning), Version.CURRENT);
                "_index": "test_index2",
        nodes.add(badAttr);
            List<Node> badNodes = new ArrayList<>();
import java.util.Map;
            indices.get_field_mapping:
import java.util.HashMap;
                    docs:
 * Modifications Copyright OpenSearch Contributors. See
    }
        parser = createParser(YamlXContent.yamlXContent, """
            final AssertionError multiple = expectThrows(
        String bodies[] = new String[] { """
                    + "did not get expected warning headers [\n\tanother\n\tsome more\n]\n",
    public void testParseDoSectionAllowedWarnings() throws Exception {
        Exception e = expectThrows(IllegalArgumentException.class, () -> DoSection.parse(parser));
        ApiCallSection apiCallSection = doSection.getApiCallSection();
        }
              "f2": 42
        nodes.add(v121);
                () -> section.checkWarningHeaders(Arrays.asList(testHeader, someMoreHeader), Version.CURRENT)
        ApiCallSection apiCallSection = doSection.getApiCallSection();
        }
                AssertionError.class,
        assertNotSame(NodeSelector.ANY, doSection.getApiCallSection().getNodeSelector());
                "match_all": {}
            }""");
        assertThat(doSection.getCatch(), equalTo("missing"));
        assertThat(doSection.getApiCallSection(), notNullValue());
        assertThat(doSection.getApiCallSection(), notNullValue());
        parser = createParser(YamlXContent.yamlXContent, "bulk:\n" + "    refresh: true\n" + "    body: |\n" + bulkBody);
        DoSection doSectionWithTwoAttributes = DoSection.parse(parser);
    }
        DoSection doSection = DoSection.parse(parser);
            indices.get_field_mapping:
    public void testParseDoSectionMultivaluedField() throws Exception {
        Exception e = expectThrows(IllegalArgumentException.class, () -> DoSection.parse(parser));
            singletonMap("index", "test_index"),
                id:     1
                index: test_index
            }
        DoSection section = new DoSection(new XContentLocation(1, 1));
            node_selector:
            .map(l -> l.strip().replace("\n", ""))
                    - f1: v1
            allowed_warnings:
            {
              "index": {
            }""";
        }
            final DoSection section = new DoSection(new XContentLocation(1, 1));
import org.hamcrest.MatcherAssert;
            section.checkWarningHeaders(singletonList(testHeader), Version.CURRENT);
        parser = createParser(YamlXContent.yamlXContent, """
        assertThat(apiCallSection.hasBody(), equalTo(true));
                - some test warning they are typically pretty long
            }""";
                "_index": "test_index",
            assertEquals("expected [version] metadata to be set but got [host=http://dummy]", e.getMessage());
            indices.get_field_mapping:
            {
    }
        ApiCallSection apiCallSection = doSection.getApiCallSection();
    }
            {
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
        );
        bodies[3] = """
import static org.hamcrest.Matchers.is;
        String body = """
        assertEquals(Arrays.asList(v121, v150), nodes);
        ApiCallSection apiCallSection = doSection.getApiCallSection();
            .map(l -> "      " + l)
            {
        assertThat(doSection.getAllowedWarningHeaders(), equalTo(singletonList("just one entry this time")));
            assertEquals(
        Node v120 = nodeWithVersion("1.1.0");
            allowed_warnings:
 *
        assertThat(apiCallSection, notNullValue());
    private static Node nodeWithVersion(String version) {
              }
        assertThat(apiCallSection.getApi(), equalTo("index"));
/*
        Node hasBoth = nodeWithAttributes(bothAttributes);
            final DoSection section = new DoSection(new XContentLocation(1, 1));
    public void testNodeSelectorByVersion() throws IOException {
            // and don't throw exceptions if we don't receive them
        assertThat(doSection.getApiCallSection().getHeaders(), notNullValue());
            indices.get_field_mapping:
            catch: missing
    }
            List<Node> nodes = new ArrayList<>();
              "query": {
        assertThat(apiCallSection.getParams().get("index"), equalTo("test_1"));
import org.opensearch.common.logging.HeaderWarning;
        String body = """
            nodes.add(notHasAttr);
        DoSection doSection = DoSection.parse(parser);
                    index: test_index
        assertThat(e.getMessage(), is("client call section is mandatory within a do section"));
                "match_all": {}
        }
                body:
            final DoSection section = new DoSection(new XContentLocation(1, 1));
        {
    }
                    attr: val
        assertThat(doSection.getApiCallSection().getHeaders().size(), equalTo(2));
        Node hasAttrWrongValue = nodeWithAttributes(singletonMap("attr", singletonList("notval")));
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
import org.opensearch.core.common.ParsingException;
            }""";
                AssertionError.class,
            assertEquals(
        bodies[0] = """
        assertThat(apiCallSection.getParams().size(), equalTo(0));
    }
        assertThat(doSection.getApiCallSection().getParams().get("index"), equalTo("test_index"));
              "f1": "v2",
        assertThat(apiCallSection, notNullValue());
            """, """
        parser = createParser(YamlXContent.yamlXContent, """
                        _id:    test_id2
 * license agreements. See the NOTICE file distributed with
            final DoSection section = new DoSection(new XContentLocation(1, 1));
    public void testParseDoSectionWithBodyStringified() throws Exception {
    }
        assertThat(apiCallSection.getApi(), equalTo("bulk"));
        String bulkBody = Arrays.stream(bodies)
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(1));
        assertThat(apiCallSection.getApi(), equalTo("cluster.node_info"));
            assertEquals(Arrays.asList(hasBoth), nodes);
              "index": {
            final AssertionError e = expectThrows(
        DoSection doSection = DoSection.parse(parser);
    }
        // Any warning headers fail
                body:
        DoSection doSection = DoSection.parse(parser);
            "indices.get_field_mapping",
            nodes.add(hasAttrWrongValue);
            }""";
                singletonMap("index", "test_index"),
              }
            indices.get_field_mapping:
        assertEquals(Arrays.asList(both), nodes);
        DoSection doSection = DoSection.parse(parser);
        doSection.getApiCallSection().getNodeSelector().select(nodes);
                emptyMap(),
            warnings:
        assertThat(apiCallSection, notNullValue());
            section.checkWarningHeaders(singletonList(testHeader), Version.CURRENT);
        assertThat(apiCallSection.getParams().get("id"), equalTo("1"));
            }""";
 * ownership. Elasticsearch licenses this file to you under
                    + "\n]\n"
        assertThat(apiCallSection.getBodies().size(), equalTo(1));
                        _index: test_index
import org.opensearch.core.xcontent.XContentParser;
                body:
            equalTo(
            emptyMap(),
            final DoSection section = new DoSection(new XContentLocation(1, 1));
            assertEquals("did not get expected warning headers [\n\ttest\n\tanother\n\tsome more\n]\n", multiple.getMessage());
        assertThat(apiCallSection.getApi(), equalTo("get"));
            node_selector:
            """ };
                version: 1.2.0-2.0.0
    public void testParseDoSectionNoBody() throws Exception {
    }
                "_index": "test_index",
                Arrays.asList("some test warning they are typically pretty long", "some other test warning sometimes they have [in] them")
                - some other test warning sometimes they have [in] them""");
              }
            .collect(Collectors.joining("\n"))
        for (int i = 0; i < bodies.length; i++) {
            section.setExpectedWarningHeaders(Arrays.asList("test", "another", "some more"));
              "docs": [
        assertJsonEquals(apiCallSection.getBodies().get(0), """
                "match_all": {}
 * the Apache License, Version 2.0 (the "License"); you may
        {
                "_id": "test_id2"
        {
            section.checkWarningHeaders(Arrays.asList(testHeader, anotherHeader, someMoreHeader), Version.CURRENT);
        // stringified body is taken as is
            assertEquals("did not get expected warning header [\n\tanother\n]\n", one.getMessage());
        {
        DoSection doSection = DoSection.parse(parser);
import java.io.IOException;
import static org.hamcrest.CoreMatchers.equalTo;
        assertThat(apiCallSection.getParams().size(), equalTo(0));
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_warmer"));
                "_id": "test_id2"
              "f2": 47
        DoSection doSection = DoSection.parse(parser);
            assertEquals("did not get expected warning header [\n\ttest\n]\n", e.getMessage());
        {
            {
            {
            nodes.add(hasAttrWrongValue);
        assertThat(apiCallSection.getParams().get("index"), equalTo("test_index"));
        DoSection doSection = DoSection.parse(parser);
            {
    public void testParseDoSectionWithJsonBody() throws Exception {
                    "query": { "match_all": {} }""");
                    index: test_index
            section.setExpectedWarningHeaders(singletonList("test"));
            )
            doSectionWithTwoAttributes.getApiCallSection().getNodeSelector().select(nodes);
                }
    public void testParseDoSectionWithBodiesStringifiedAndNot() throws Exception {
import java.util.Arrays;
        final String catHeader = HeaderWarning.formatWarning("cat");
import org.opensearch.test.rest.yaml.ClientYamlTestExecutionContext;
        }
                - some test warning they are typically pretty long
                () -> section.checkWarningHeaders(Arrays.asList(testHeader, catHeader), Version.CURRENT)
            )
            warnings:
        assertThat(apiCallSection.getParams().get("refresh"), equalTo("true"));
        assertThat(doSection.getApiCallSection().getHeaders().get("Content-Type"), equalTo("application/json"));
import static org.mockito.Mockito.mock;
                AssertionError.class,
        {
                    - f1: v2
                version: 1.2.0-2.0.0
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
import org.opensearch.client.NodeSelector;
              "f1": "v1",
              "index": {
            + "\n";
                        _id:    test_id
        ClientYamlTestExecutionContext context = mock(ClientYamlTestExecutionContext.class);
                {
        parser = createParser(YamlXContent.yamlXContent, """
        assertThat(apiCallSection.getBodies().size(), equalTo(bodies.length));
        assertNotSame(NodeSelector.ANY, doSection.getApiCallSection().getNodeSelector());
        parser = createParser(YamlXContent.yamlXContent, """
        String body = """
                    index: test_index
        assertThat(apiCallSection.getApi(), equalTo("search"));
        assertThat(doSection.getApiCallSection().getParams().get("index"), equalTo("test_index"));
import org.opensearch.Version;
                - some other test warning sometimes they have [in] them""");
        assertThat(apiCallSection.getApi(), equalTo("index"));
                "include.field1",
import static java.util.Collections.emptyMap;
            equalTo(
        parser = createParser(YamlXContent.yamlXContent, "catch: missing\n");
/*
            final AssertionError multiple = expectThrows(
        assertThat(apiCallSection.getBodies().size(), equalTo(1));
        assertThat(doSection.getApiCallSection(), notNullValue());
                "match_all": {}
        bothAttributes.put("attr2", singletonList("val2"));
        parser = createParser(YamlXContent.yamlXContent, """
import static java.util.Collections.emptyList;
              "include": {
        assertThat(doSection.getCatch(), nullValue());
                    - index:
            final AssertionError one = expectThrows(
            final AssertionError e = expectThrows(AssertionError.class, () -> section.checkWarningHeaders(emptyList(), Version.CURRENT));
            Exception e = expectThrows(IllegalStateException.class, () -> doSection.getApiCallSection().getNodeSelector().select(badNodes));
        section.setExpectedWarningHeaders(singletonList("warning"));
    }
        );
        assertThat(doSection.getCatch(), nullValue());
              "f2": 47
    }
public class DoSectionTests extends AbstractClientYamlTestFragmentParserTestCase {
        assertThat(apiCallSection.getParams().size(), equalTo(1));
            doSection.getAllowedWarningHeaders(),
        parser = createParser(YamlXContent.yamlXContent, """
                Arrays.asList("some test warning they are typically pretty long", "some other test warning sometimes they have [in] them")
import java.util.stream.Collectors;
            bulk:
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
            node_selector:
    public void testParseDoSectionWithYamlMultipleBodies() throws Exception {
                    attr2: val2
                    index: test_index
                    field: [ text , text1 ]""");
        parser = createParser(YamlXContent.yamlXContent, """
            assertEquals("expected [attributes] metadata to be set but got [host=http://dummy]", e.getMessage());
 * under the License.
        assertJsonEquals(apiCallSection.getBodies().get(0), body);
 */
import static java.util.Collections.singletonList;
            final DoSection section = new DoSection(new XContentLocation(1, 1));
                "_id": "test_id"
            get:
        bothAttributes.put("attr", singletonList("val"));
        // It is also an error if you get some warning you want and some you don't want
            context.callApi(
 */
                  "_index": "test_1",
              }
        assertThat(doSection.getApiCallSection().getParams().get("index"), equalTo("test_index"));
              "index": {
            assertJsonEquals(apiCallSection.getBodies().get(i), bodies[i]);
                "indices.get_field_mapping",
import org.apache.hc.core5.http.HttpHost;
        {
        parser = createParser(YamlXContent.yamlXContent, "cluster.node_info: {}");
        nodes.add(v212);
            );
        Map<String, List<String>> bothAttributes = new HashMap<>();
        String body = """
        verify(context).callApi(
        assertThat(apiCallSection.hasBody(), equalTo(true));
        assertThat(apiCallSection.hasBody(), equalTo(true));
                {
        doSection.getApiCallSection().getNodeSelector().select(nodes);
        ApiCallSection apiCallSection = doSection.getApiCallSection();
            final DoSection section = new DoSection(new XContentLocation(1, 1));
        try (XContentParser parser = createParser(YamlXContent.yamlXContent, expected)) {
        assertThat(apiCallSection.hasBody(), equalTo(true));
    public void testNodeSelectorByAttribute() throws IOException {
        doSection = DoSection.parse(parser);
                      f2: 42
            doSection.getApiCallSection().getNodeSelector()
        assertThat(doSection.getApiCallSection().getParams().get("field"), equalTo("text,text1"));
        parser.nextToken();
            nodes.add(hasBoth);
    private void assertJsonEquals(Map<String, Object> actual, String expected) throws IOException {
    }
                    - "{ \\"_source\\": true, \\"query\\": { \\"match_all\\": {} } }"
        assertJsonEquals(apiCallSection.getBodies().get(0), body);
        }
            assertEquals("got unexpected warning header [\n\t" + testHeader + "\n]\n", one.getMessage());
                    + catHeader
        assertThat(apiCallSection.getBodies().size(), equalTo(4));
            }
                },
        assertThat(apiCallSection.getParams().size(), equalTo(0));
                    - index:
        assertThat(doSection.getApiCallSection(), notNullValue());
    public void testParseDoSectionWithoutClientCallSection() throws Exception {
            {
            }""";
        nodes.add(v150);
        when(
            {
            {
        parser = createParser(YamlXContent.yamlXContent, "index:\n" + "    index:  test_1\n" + "    id:     1\n" + "    body:   " + body);
    public void testWarningHeaders() {
 *     http://www.apache.org/licenses/LICENSE-2.0
        final String anotherHeader = HeaderWarning.formatWarning("another");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        {
        {
                "field1": "v1",
              "size": 100,
        DoSection doSection = DoSection.parse(parser);
        parser = createParser(YamlXContent.yamlXContent, """
        assertThat(apiCallSection, notNullValue());
            indices.get_warmer:
            index:
        MatcherAssert.assertThat(actual, equalTo(expectedMap));
            nodes.add(hasAttr);
            headers:
        assertThat(apiCallSection.hasBody(), equalTo(false));
                refresh: true
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
                      f2: 47""");
            nodes.add(hasAttr2);
    private static Node nodeWithVersionAndAttributes(String version, Map<String, List<String>> attributes) {
              "_source": true,
                - foo""");
    }
        assertThat(apiCallSection.getParams().size(), equalTo(2));
              "_source": [
                body:   "{ \\"_source\\": true, \\"query\\": { \\"match_all\\": {} } }\"""");
        return new Node(new HttpHost("dummy"), null, null, version, null, attributes);
 * KIND, either express or implied.  See the License for the
        parser = createParser(YamlXContent.yamlXContent, """
        Node both = nodeWithVersionAndAttributes("1.2.1", singletonMap("attr", singletonList("val")));
              },
 * Licensed to Elasticsearch under one or more contributor
            nodes.add(hasAttr);
        }
        Node v121 = nodeWithVersion("1.2.1");
              }
        assertThat(apiCallSection.hasBody(), equalTo(false));
import static org.mockito.Mockito.verify;
                attribute:
                multiple.getMessage()
            }""");
                  "_id": 1
        Node hasAttr = nodeWithAttributes(singletonMap("attr", singletonList("val")));
    }
        assertThat(apiCallSection.getParams().get("id"), equalTo("1"));
        ClientYamlTestResponse mockResponse = mock(ClientYamlTestResponse.class);
    public void testParseDoSectionWithCatch() throws Exception {
        String legitimateWarning = HeaderWarning.formatWarning("warning");
 */
                    attr: val
                Content-Type: "application/json"
                emptyList(),
 *
            indices.get_field_mapping:
        String[] bodies = new String[4];
        assertThat(apiCallSection, notNullValue());
    }
            {
                AssertionError.class,
            );
            List<Node> badNodes = new ArrayList<>();
        parser = createParser(YamlXContent.yamlXContent, """
        }
                () -> section.checkWarningHeaders(Arrays.asList(testHeader, anotherHeader, someMoreHeader), Version.CURRENT)
              "count": 1
            doSection.getApiCallSection().getNodeSelector().select(nodes);
        // "allowed" warnings are fine
    public void testParseDoSectionWithYamlBodyMultiGet() throws Exception {
 * specific language governing permissions and limitations
                    "_source": [ include.field1, include.field2 ]
        }
import org.opensearch.client.Node;
    }
            List<Node> nodes = new ArrayList<>();
                "_id": "test_id"
        assertJsonEquals(apiCallSection.getBodies().get(0), """
        Node notHasAttr = nodeWithAttributes(singletonMap("notattr", singletonList("val")));
    public void testParseDoSectionWithJsonMultipleBodiesAsLongString() throws Exception {
 * GitHub history for details.
              }
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
            emptyList(),
        String typesWarning = HeaderWarning.formatWarning(
        Node badVersion = nodeWithVersionAndAttributes("1.1.1", singletonMap("attr", singletonList("val")));
        assertThat(
        assertThat(apiCallSection.getApi(), equalTo("index"));
 * Unless required by applicable law or agreed to in writing,
        ).thenReturn(mockResponse);
        assertThat(apiCallSection.getParams().get("id"), equalTo("1"));
        DoSection doSection = DoSection.parse(parser);
        Node hasAttr2 = nodeWithAttributes(singletonMap("attr2", singletonList("val2")));
        doSection.execute(context);
                index:    test_index
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
                index: test_index
        assertThat(apiCallSection, notNullValue());
        assertThat(doSection.getApiCallSection(), notNullValue());
                body:
        return new Node(new HttpHost("dummy"), null, null, version, null, null);
            final DoSection section = new DoSection(new XContentLocation(1, 1));
            Exception e = expectThrows(IllegalStateException.class, () -> doSection.getApiCallSection().getNodeSelector().select(badNodes));
        // But if you don't get some that you did expect, that is an error
        nodes.add(both);
/*
              }
 * The OpenSearch Contributors require contributions made to
        ApiCallSection apiCallSection = doSection.getApiCallSection();
    public void testParseDoSectionExpectedWarnings() throws Exception {
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_field_mapping"));
        return new Node(new HttpHost("dummy"), null, null, null, null, attributes);
        assertThat(apiCallSection.getParams().size(), equalTo(2));
    }
    }
        assertThat(apiCallSection.getBodies().size(), equalTo(2));
                        - { _index: test_1, _id: 1}""");
        assertThat(apiCallSection.hasBody(), equalTo(true));
            nodes.add(notHasAttr);
            section.setExpectedWarningHeaders(Arrays.asList("test", "another", "some more"));
              "f1": "v1",
                AssertionError.class,
              ]
import java.util.ArrayList;
import static org.hamcrest.Matchers.nullValue;
 * compatible open source license.
                "field2": "v2"
                index:  test_1
                index: test_index""");
        DoSection doSection = DoSection.parse(parser);
    }
    }
import java.util.List;
        final String someMoreHeader = HeaderWarning.formatWarning("some more");
        ParsingException e = expectThrows(ParsingException.class, () -> DoSection.parse(parser));
            }
        );
 * not use this file except in compliance with the License.
