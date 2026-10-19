            emptyList(),
        List<Node> nodes = new ArrayList<>();  
        ApiCallSection apiCallSection = doSection.getApiCallSection();  
                    docs:  
            List<Node> badNodes = new ArrayList<>();
              "query": {
              "index": {  
            section.setAllowedWarningHeaders(singletonList("test"));
        assertThat(apiCallSection.getParams().size(), equalTo(1));
                    + "did not get expected warning headers [\n\tanother\n\tsome more\n]\n",
        assertThat(apiCallSection.getParams().size(), equalTo(2));
            assertEquals("did not get expected warning header [\n\tanother\n]\n", one.getMessage());
                emptyList(),
              "query": {
                AssertionError.class,
        assertThat(apiCallSection, notNullValue());
    }
                attribute:  
import static org.mockito.Mockito.verify;
        assertNotSame(NodeSelector.ANY, doSection.getApiCallSection().getNodeSelector());
            section.setExpectedWarningHeaders(singletonList("test"));
            }""";  
 * license agreements. See the NOTICE file distributed with
    }  
import org.opensearch.core.xcontent.XContentParser;  
        assertThat(apiCallSection.getBodies().size(), equalTo(bodies.length));
        ApiCallSection apiCallSection = doSection.getApiCallSection();
import static org.hamcrest.Matchers.is;  
        nodes.add(badAttr);
            final AssertionError e = expectThrows(AssertionError.class, () -> section.checkWarningHeaders(emptyList(), Version.CURRENT));  
            {
            allowed_warnings:  
        {  
    private static Node nodeWithVersion(String version) {
                body:   "{ \\"_source\\": true, \\"query\\": { \\"match_all\\": {} } }\"""");  
            node_selector:
        assertThat(doSection.getAllowedWarningHeaders(), equalTo(singletonList("just one entry this time")));
        assertThat(apiCallSection.getParams().size(), equalTo(0));
                "field1": "v1",
import java.util.Map;
        assertThat(apiCallSection.getParams().get("refresh"), equalTo("true"));
        DoSection section = new DoSection(new XContentLocation(1, 1));
        // But not when we expect them
                "_id": "test_id"
            }""";
            {  
            indices.get_field_mapping:  
        assertThat(doSection.getCatch(), nullValue());
        assertThat(apiCallSection.getApi(), equalTo("bulk"));  
            );
        nodes.add(v150);  
              },  
                        _id:    test_id
    }  
        assertThat(apiCallSection.getApi(), equalTo("index"));
        DoSection doSection = DoSection.parse(parser);  
        assertThat(apiCallSection.getApi(), equalTo("search"));
                    - "{ \\"_source\\": true, \\"query\\": { \\"match_all\\": {} } }"
        final String catHeader = HeaderWarning.formatWarning("cat");
                index: test_index""");
                "got unexpected warning headers [\n\t" + testHeader + "\n\t" + anotherHeader + "\n\t" + someMoreHeader + "\n]\n",  
        assertThat(apiCallSection.hasBody(), equalTo(true));  
    }
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));  
            }""");  
        assertThat(apiCallSection.getParams().get("id"), equalTo("1"));
    }
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_field_mapping"));
            equalTo(  
            indices.get_field_mapping:
    }  
            final DoSection section = new DoSection(new XContentLocation(1, 1));
        assertThat(apiCallSection, notNullValue());
                        _id:    test_id2  
            .collect(Collectors.joining("\n"))
        {  
            {  
            "indices.get_field_mapping",
            );
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
            equalTo(
            assertEquals(
        assertThat(apiCallSection.getParams().get("id"), equalTo("1"));  
        try (XContentParser parser = createParser(YamlXContent.yamlXContent, expected)) {  
import java.util.HashMap;
                Content-Type: "application/json"
              "f2": 47
              "index": {  
        String body = """
            {  
import org.opensearch.common.logging.HeaderWarning;
                    index: test_index
        parser = createParser(YamlXContent.yamlXContent, """
        Node notHasAttr = nodeWithAttributes(singletonMap("notattr", singletonList("val")));  
import org.opensearch.client.Node;  
    public void testNodeSelectorByTwoThings() throws IOException {
            doSectionWithTwoAttributes.getApiCallSection().getNodeSelector().select(nodes);
        DoSection doSection = DoSection.parse(parser);
            indices.get_field_mapping:  
        assertThat(apiCallSection.getParams().size(), equalTo(2));
                - some other test warning sometimes they have [in] them""");  
            {
                name: test_warmer""");
import static org.hamcrest.Matchers.nullValue;
        assertThat(doSection.getApiCallSection().getHeaders().get("Authorization"), equalTo("thing one"));
              "f1": "v2",
        parser.nextToken();
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
import static java.util.Collections.emptyMap;
        ParsingException e = expectThrows(ParsingException.class, () -> DoSection.parse(parser));
            indices.get_field_mapping:  
        }
                AssertionError.class,
        assertThat(doSection.getApiCallSection().getParams().get("index"), equalTo("test_index"));  
            indices.get_field_mapping:
        DoSection doSection = DoSection.parse(parser);
        Map<String, List<String>> bothAttributes = new HashMap<>();  
        assertThat(
        assertThat(apiCallSection.getParams().size(), equalTo(0));  
        parser = createParser(YamlXContent.yamlXContent, """
              "f2": 42
/*
    public void testParseDoSectionAllowedWarnings() throws Exception {
              "_source": true,  
        assertThat(apiCallSection.hasBody(), equalTo(true));
            final AssertionError one = expectThrows(
            }  
        ApiCallSection apiCallSection = doSection.getApiCallSection();
    public void testParseDoSectionWithYamlBodyMultiGet() throws Exception {
        final String someMoreHeader = HeaderWarning.formatWarning("some more");
                "field2": "v2"
    }
            {  
        verify(context).callApi(
    public void testParseDoSectionNoParamsNoBody() throws Exception {  
        assertThat(apiCallSection.hasBody(), equalTo(true));  
        bodies[0] = """
        assertThat(apiCallSection.getParams().get("index"), equalTo("test_index"));
            index:  
        assertThat(apiCallSection, notNullValue());
                "match_all": {}
        DoSection doSection = DoSection.parse(parser);
        parser = createParser(YamlXContent.yamlXContent, """
        assertJsonEquals(apiCallSection.getBodies().get(0), body);  
            assertEquals(Arrays.asList(hasAttr), nodes);
import static org.mockito.Mockito.when;
            nodes.add(hasAttr);  
    private void assertJsonEquals(Map<String, Object> actual, String expected) throws IOException {
                {
        }
        );
                singletonMap("index", "test_index"),  
                Authorization: "thing one"
              }  
        assertThat(apiCallSection.getParams().size(), equalTo(0));
        }
    }
    }
                        _index: test_index  
            );
        DoSection doSection = DoSection.parse(parser);
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_warmer"));
        assertThat(doSection.getApiCallSection().getHeaders(), notNullValue());  
    public void testUnsupportedTopLevelField() throws Exception {
    }
              "f2": 42
    private static Node nodeWithVersionAndAttributes(String version, Map<String, List<String>> attributes) {  
            catch: missing  
            // and don't throw exceptions if we don't receive them  
                  "_index": "test_2",
        return new Node(new HttpHost("dummy"), null, null, version, null, attributes);
        {  
    public void testParseDoSectionMultivaluedField() throws Exception {
            {  
                    index: test_index  
              "include": {  
        doSection = DoSection.parse(parser);
    }
        assertThat(doSection.getCatch(), nullValue());  
            mget:
        }  
        assertThat(doSection.getApiCallSection().getParams().get("field"), equalTo("text,text1"));
        );
 * You may obtain a copy of the License at  
        assertThat(apiCallSection.hasBody(), equalTo(true));
                    index: test_index
                "_id": "test_id2"
    }  
 * KIND, either express or implied.  See the License for the
              }  
        assertThat(apiCallSection, notNullValue());
 * specific language governing permissions and limitations
            List<Node> nodes = new ArrayList<>();
                    field: [ text , text1 ]""");
                    - { size: 100, query: { match_all: {} } }""");  
              "index": {  
        assertJsonEquals(apiCallSection.getBodies().get(0), """
    public void testParseDoSectionWithJsonMultipleBodiesAsLongString() throws Exception {  
        assertJsonEquals(apiCallSection.getBodies().get(0), body);
              "query": {
                version: 1.2.0-2.0.0
            List<Node> nodes = new ArrayList<>();
public class DoSectionTests extends AbstractClientYamlTestFragmentParserTestCase {
        DoSection doSection = DoSection.parse(parser);
        DoSection doSection = DoSection.parse(parser);
        assertNotSame(NodeSelector.ANY, doSection.getApiCallSection().getNodeSelector());  
                  "_id": 1
    }
                    - index:
                version: 1.2.0-2.0.0
            Exception e = expectThrows(IllegalStateException.class, () -> doSection.getApiCallSection().getNodeSelector().select(badNodes));  
        Node both = nodeWithVersionAndAttributes("1.2.1", singletonMap("attr", singletonList("val")));
        assertThat(apiCallSection.getParams().get("refresh"), equalTo("true"));  
 *  
import static java.util.Collections.singletonMap;
            expectedMap = parser.mapOrdered();
        bothAttributes.put("attr", singletonList("val"));
            index:  
        DoSection doSection = DoSection.parse(parser);
        return new Node(new HttpHost("dummy"), null, null, version, null, null);  
            final DoSection section = new DoSection(new XContentLocation(1, 1));  
    }
 *
              "f2": 47
        parser.nextToken();  
    }
        final String anotherHeader = HeaderWarning.formatWarning("another");  
    public void testParseDoSectionExpectedWarnings() throws Exception {  
        assertThat(e.getMessage(), equalTo("the warning [foo] was both allowed and expected"));
        String body = """
            headers:  
                - just one entry this time""");
        Node hasBoth = nodeWithAttributes(bothAttributes);  
        assertThat(doSection.getApiCallSection().getParams().get("index"), equalTo("test_index"));
                refresh: true  
                emptyMap(),
        parser = createParser(YamlXContent.yamlXContent, "max_concurrent_shard_requests: 1");
        assertThat(apiCallSection, notNullValue());
            warnings:
            final AssertionError multiple = expectThrows(
    }
                "indices.get_field_mapping",
        assertThat(doSection.getApiCallSection(), notNullValue());
        String typesWarning = HeaderWarning.formatWarning(
        ApiCallSection apiCallSection = doSection.getApiCallSection();  
 * Licensed to Elasticsearch under one or more contributor  
              "f1": "v1",
        assertThat(apiCallSection.hasBody(), equalTo(false));  
        // It is also an error if you get some warning you want and some you don't want
            {
        assertThat(apiCallSection.getParams().get("index"), equalTo("test_1"));
              ]
                index: test_index""");
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
            section.setExpectedWarningHeaders(singletonList("test"));
              "index": {  
        nodes.add(badVersion);  
            );
            allowed_warnings:
            doSection.getApiCallSection().getNodeSelector()  
        assertJsonEquals(apiCallSection.getBodies().get(1), body);
        parser = createParser(YamlXContent.yamlXContent, """
        assertThat(doSection.getCatch(), nullValue());
    }
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
            + "\n";  
import org.opensearch.Version;
    public void testParseDoSectionNoBody() throws Exception {
            final DoSection section = new DoSection(new XContentLocation(1, 1));
                "match_all": {}  
                    - index:
        parser = createParser(YamlXContent.yamlXContent, """  
                    - f1: v1
        String bodies[] = new String[] { """
    }
 * The OpenSearch Contributors require contributions made to  
                - some test warning they are typically pretty long
}
        assertThat(doSection.getApiCallSection(), notNullValue());
            section.checkWarningHeaders(emptyList(), Version.CURRENT);
                "_index": "test_index",
        bodies[3] = """
            {
                "_id": "test_id2"
import org.hamcrest.MatcherAssert;  
    public void testIgnoreTypesWarnings() {
                    attr: val
            search:
                }
                        - { _index: test_2, _id: 1}
            {
                "_index": "test_index2",
              "query": {  
        assertThat(apiCallSection, notNullValue());
            indices.get_warmer:  
        assertThat(doSection.getApiCallSection().getParams().get("index"), equalTo("test_index"));  
                      f2: 47""");
                "match_all": {}
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(1));
            indices.get_field_mapping:
import org.opensearch.core.common.ParsingException;
            nodes.add(hasAttr);  
        return new Node(new HttpHost("dummy"), null, null, null, null, attributes);
                () -> section.checkWarningHeaders(Arrays.asList(testHeader, someMoreHeader), Version.CURRENT)  
        parser = createParser(YamlXContent.yamlXContent, """
        DoSection doSection = DoSection.parse(parser);  
                AssertionError.class,
 */  
              }
                {  
        assertThat(apiCallSection.hasBody(), equalTo(true));
            );
            doSection.getExpectedWarningHeaders(),
        String body = """  
                index: test_index
import static org.hamcrest.Matchers.notNullValue;
    }  
        List<Node> nodes = new ArrayList<>();
                AssertionError.class,
            final DoSection section = new DoSection(new XContentLocation(1, 1));
                body:
            doSection.getApiCallSection().getNodeSelector().select(nodes);  
                      f2: 42  
                index: test_index
        assertThat(e.getMessage(), is("client call section is mandatory within a do section"));
                "_index": "test_index2",
            assertEquals("did not get expected warning header [\n\ttest\n]\n", e.getMessage());
            "[types removal] " + "The endpoint /{index}/{type}/_count is deprecated, use /{index}/_count instead."
        parser = createParser(YamlXContent.yamlXContent, """  
        Node hasAttrWrongValue = nodeWithAttributes(singletonMap("attr", singletonList("notval")));
import java.util.ArrayList;  
                attribute:  
        Node v121 = nodeWithVersion("1.2.1");  
        {  
        parser = createParser(YamlXContent.yamlXContent, """
        Map<String, Object> expectedMap;
        Exception e = expectThrows(IllegalArgumentException.class, () -> DoSection.parse(parser));  
                body:
            nodes.add(hasAttrWrongValue);
            indices.get_field_mapping:
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
import org.opensearch.test.rest.yaml.ClientYamlTestExecutionContext;
        }
 * not use this file except in compliance with the License.
            final DoSection section = new DoSection(new XContentLocation(1, 1));  
              "count": 1
    public void testWarningHeaders() {  
import org.apache.hc.core5.http.HttpHost;
import java.util.Arrays;
                index: test_index""");  
        doSection.getApiCallSection().getNodeSelector().select(nodes);
            }""");
import static java.util.Collections.emptyList;
        DoSection doSection = DoSection.parse(parser);
            );  
            assertJsonEquals(apiCallSection.getBodies().get(i), bodies[i]);
        parser = createParser(YamlXContent.yamlXContent, "index:\n" + "    index:  test_1\n" + "    id:     1\n" + "    body:   " + body);  
        assertThat(apiCallSection.getBodies().size(), equalTo(4));
        assertThat(apiCallSection.hasBody(), equalTo(false));  
                AssertionError.class,
        parser = createParser(YamlXContent.yamlXContent, """
                doSection.getApiCallSection().getNodeSelector()  
 * under the License.  
        // stringified body is taken as is  
        final String testHeader = HeaderWarning.formatWarning("test");
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_field_mapping"));
        );  
        MatcherAssert.assertThat(actual, equalTo(expectedMap));  
        Node hasAttr = nodeWithAttributes(singletonMap("attr", singletonList("val")));
        assertThat(doSection.getCatch(), nullValue());  
              "_source": true,
                    index: test_index  
        // stringified body is taken as is
        assertThat(apiCallSection.getParams().size(), equalTo(2));  
            }
        {  
            {
        ApiCallSection apiCallSection = doSection.getApiCallSection();  
        assertThat(apiCallSection.getParams().get("index"), equalTo("test_1"));
            assertEquals(Arrays.asList(hasBoth), nodes);  
                    - f1: v2
import static org.hamcrest.CoreMatchers.equalTo;
        String bulkBody = Arrays.stream(bodies)
            List<Node> badNodes = new ArrayList<>();
            get:  
                body:
                - some test warning they are typically pretty long
        assertThat(apiCallSection, notNullValue());  
            nodes.add(hasAttr2);  
    }
            final AssertionError multiple = expectThrows(
        {
        assertJsonEquals(apiCallSection.getBodies().get(0), """  
        // But if you don't get some that you did expect, that is an error
        parser = createParser(YamlXContent.yamlXContent, """
 * SPDX-License-Identifier: Apache-2.0
                id:        1""");
                index: test_index""");  
        bodies[2] = """
 * this file be licensed under the Apache-2.0 license or a
        assertThat(  
        ClientYamlTestExecutionContext context = mock(ClientYamlTestExecutionContext.class);
        parser = createParser(YamlXContent.yamlXContent, """  
            bulk:
                index:    test_index
        parser = createParser(YamlXContent.yamlXContent, """
        ApiCallSection apiCallSection = doSection.getApiCallSection();
        assertThat(apiCallSection, notNullValue());  
            section.setExpectedWarningHeaders(Arrays.asList("test", "another", "some more"));
import org.opensearch.core.xcontent.XContentLocation;
            )
              }
    public void testParseDoSectionWithJsonBody() throws Exception {  
        Node badVersion = nodeWithVersionAndAttributes("1.1.1", singletonMap("attr", singletonList("val")));
            assertEquals("expected [attributes] metadata to be set but got [host=http://dummy]", e.getMessage());
        bothAttributes.put("attr2", singletonList("val2"));
        assertThat(doSection.getApiCallSection(), notNullValue());
import org.opensearch.client.NodeSelector;
                },  
            node_selector:
        // "allowed" warnings are fine
        parser = createParser(YamlXContent.yamlXContent, "bulk:\n" + "    refresh: true\n" + "    body: |\n" + bulkBody);
            """, """
                "include.field1",
        assertEquals(Arrays.asList(v121, v150), nodes);  
        parser = createParser(YamlXContent.yamlXContent, """  
        assertJsonEquals(apiCallSection.getBodies().get(0), body);  
        assertThat(doSection.getApiCallSection().getBodies().size(), equalTo(0));
            nodes.add(hasBoth);
        Node v120 = nodeWithVersion("1.1.0");
        parser = createParser(YamlXContent.yamlXContent, "catch: missing\n");
        }  
        }
import org.opensearch.test.rest.yaml.ClientYamlTestResponse;
        parser = createParser(YamlXContent.yamlXContent, """  
    }
            """, """
            assertEquals(
        assertNotSame(NodeSelector.ANY, doSection.getApiCallSection().getNodeSelector());
        {
            nodes.add(notHasAttr);
        assertThat(doSection.getApiCallSection(), notNullValue());  
        DoSection doSection = DoSection.parse(parser);  
        }
            section.setExpectedWarningHeaders(Arrays.asList("test", "another", "some more"));
        doSection.execute(context);  
 */
                multiple.getMessage()
              "f1": "v2",
        // Any warning headers fail  
            Exception e = expectThrows(IllegalStateException.class, () -> doSection.getApiCallSection().getNodeSelector().select(badNodes));  
        assertThat(apiCallSection.getBodies().size(), equalTo(2));
        assertThat(apiCallSection.getApi(), equalTo("mget"));  
            warnings:
        {  
        DoSection doSectionWithTwoAttributes = DoSection.parse(parser);  
        String[] bodies = new String[4];  
 * this work for additional information regarding copyright
        parser = createParser(YamlXContent.yamlXContent, """
            """ };
                "got unexpected warning header [\n\t"
                "_id": "test_id"
        assertThat(doSection.getApiCallSection().hasBody(), equalTo(false));
        nodes.add(v120);
        assertThat(apiCallSection.getParams().size(), equalTo(1));
                id:     1
import static java.util.Collections.singletonList;  
                Arrays.asList("some test warning they are typically pretty long", "some other test warning sometimes they have [in] them")
                  "_index": "test_1",
import java.util.List;  
                "include.field2"  
    public void testParseDoSectionWithHeaders() throws Exception {
import java.util.stream.Collectors;
        assertThat(doSection.getApiCallSection(), notNullValue());  
            final DoSection section = new DoSection(new XContentLocation(1, 1));
            final AssertionError one = expectThrows(
        assertThat(apiCallSection.getParams().get("id"), equalTo("1"));  
            section.setExpectedWarningHeaders(Arrays.asList("test", "another", "some more"));
    }
        section.checkWarningHeaders(Arrays.asList(legitimateWarning, typesWarning), Version.CURRENT);
                    + "\n]\n"
    public void testParseDoSectionWithBodiesStringifiedAndNot() throws Exception {
              "_source": [
                () -> section.checkWarningHeaders(Arrays.asList(testHeader, anotherHeader, someMoreHeader), Version.CURRENT)  
                index:  test_1
            }""";
        assertThat(apiCallSection.hasBody(), equalTo(true));
            final DoSection section = new DoSection(new XContentLocation(1, 1));
        doSection.getApiCallSection().getNodeSelector().select(nodes);
    public void testParseDoSectionWithBodyStringified() throws Exception {
                "match_all": {}  
        {
        assertThat(apiCallSection.getApi(), equalTo("get"));
        nodes.add(both);
            indices.get_field_mapping:  
                body:
        {
            singletonMap("index", "test_index"),  
 */  
        assertThat(apiCallSection.getApi(), equalTo("bulk"));
        }  
                    "query": { "match_all": {} }""");
        ).thenReturn(mockResponse);
            {  
    }  
            section.checkWarningHeaders(emptyList(), Version.CURRENT);
            section.checkWarningHeaders(singletonList(testHeader), Version.CURRENT);  
        bodies[1] = """
            }
              }
        doSection = DoSection.parse(parser);
                () -> section.checkWarningHeaders(emptyList(), Version.CURRENT)  
        assertThat(doSection.getApiCallSection(), notNullValue());
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_field_mapping"));
            final AssertionError e = expectThrows(  
        when(  
        DoSection doSection = DoSection.parse(parser);
        DoSection doSection = DoSection.parse(parser);
        String legitimateWarning = HeaderWarning.formatWarning("warning");  
              ],
        ApiCallSection apiCallSection = doSection.getApiCallSection();
            section.checkWarningHeaders(singletonList(testHeader), Version.CURRENT);
                - just one entry this time""");  
        assertThat(apiCallSection.getBodies().size(), equalTo(1));
        {
              }  
        String body = """
                        _index: test_index2
import static org.mockito.Mockito.mock;  
                - foo
            """, """
                - some other test warning sometimes they have [in] them""");
    public void testParseDoSectionWithYamlMultipleBodies() throws Exception {  
                e.getMessage()  
              }  
                attribute:  
                () -> section.checkWarningHeaders(Arrays.asList(testHeader, catHeader), Version.CURRENT)
 * ownership. Elasticsearch licenses this file to you under  
    public void testParseDoSectionWithCatch() throws Exception {
            section.checkWarningHeaders(Arrays.asList(testHeader, anotherHeader, someMoreHeader), Version.CURRENT);
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(1));  
                    attr: val
        DoSection doSection = DoSection.parse(parser);
            )
            }  
        );  
                    "_source": [ include.field1, include.field2 ]  
 *
        parser = createParser(YamlXContent.yamlXContent, """
        }
        }
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
                () -> section.checkWarningHeaders(singletonList(testHeader), Version.CURRENT)  
        assertNotSame(NodeSelector.ANY, doSection.getApiCallSection().getNodeSelector());  
            );
        Node v150 = nodeWithVersion("1.5.0");
            assertEquals("expected [version] metadata to be set but got [host=http://dummy]", e.getMessage());
            allowed_warnings:
            emptyMap(),
        assertEquals(Arrays.asList(both), nodes);  
            {
            node_selector:
        assertThat(apiCallSection.getBodies().size(), equalTo(1));
        assertThat(apiCallSection.getParams().size(), equalTo(0));
    }  
    public void testNodeSelectorByAttribute() throws IOException {  
            indices.get_field_mapping:
/*  
            assertEquals("got unexpected warning header [\n\t" + testHeader + "\n]\n", one.getMessage());
        assertThat(doSection.getCatch(), equalTo("missing"));  
        Exception e = expectThrows(IllegalArgumentException.class, () -> DoSection.parse(parser));
        assertThat(doSection.getApiCallSection().getApi(), equalTo("indices.get_warmer"));  
        assertThat(apiCallSection.getApi(), equalTo("index"));  
            // No warning headers doesn't throw an exception
        assertThat(apiCallSection.getApi(), equalTo("cluster.node_info"));
import java.io.IOException;
        assertThat(doSection.getExpectedWarningHeaders(), equalTo(singletonList("just one entry this time")));
                    index: test_index
                name: test_warmer""");  
                    index: test_index
              "docs": [
        assertThat(e.getMessage(), is("unsupported field [max_concurrent_shard_requests]"));
              "f1": "v1",
                Arrays.asList("some test warning they are typically pretty long", "some other test warning sometimes they have [in] them")  
        DoSection doSection = DoSection.parse(parser);
            assertEquals("did not get expected warning headers [\n\ttest\n\tanother\n\tsome more\n]\n", multiple.getMessage());
package org.opensearch.test.rest.yaml.section;
        ApiCallSection apiCallSection = doSection.getApiCallSection();  
            doSection.getAllowedWarningHeaders(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(doSection.getApiCallSection().getHeaders().get("Content-Type"), equalTo("application/json"));  
        assertThat(apiCallSection.getApi(), equalTo("index"));  
    }
            warnings:  
        }  
        assertThat(apiCallSection.hasBody(), equalTo(true));
        assertThat(doSection.getApiCallSection().getHeaders().size(), equalTo(2));
                    attr2: val2
 * Modifications Copyright OpenSearch Contributors. See
            nodes.add(notHasAttr);
import org.opensearch.common.xcontent.yaml.YamlXContent;  
            )
            context.callApi(
            indices.get_warmer:
    public void testNodeSelectorByVersion() throws IOException {
        nodes.add(v121);
        Node hasAttr2 = nodeWithAttributes(singletonMap("attr2", singletonList("val2")));
            }""";
                - foo""");  
        }
        assertThat(doSection.getCatch(), nullValue());
            badNodes.add(new Node(new HttpHost("dummy")));
            nodes.add(hasAttrWrongValue);
              }  
            node_selector:
        DoSection doSection = DoSection.parse(parser);
                    + catHeader  
        assertThat(doSection.getApiCallSection().getBodies().size(), equalTo(0));  
    public void testParseDoSectionWithYamlBody() throws Exception {
                "_index": "test_index",
            }""";
        for (int i = 0; i < bodies.length; i++) {  
    private static Node nodeWithAttributes(Map<String, List<String>> attributes) {
        assertThat(doSection.getApiCallSection().getBodies().size(), equalTo(0));  
        }
        parser = createParser(YamlXContent.yamlXContent, """  
              "size": 100,
        nodes.add(v212);
 * compatible open source license.
        ApiCallSection apiCallSection = doSection.getApiCallSection();
                  "_id": 1  
/*  
            indices.get_field_mapping:
            .map(l -> "      " + l)
            badNodes.add(new Node(new HttpHost("dummy")));
            }""";  
        assertThat(doSection.getApiCallSection(), notNullValue());  
        ClientYamlTestResponse mockResponse = mock(ClientYamlTestResponse.class);
            {
        Node badAttr = nodeWithVersionAndAttributes("1.2.1", singletonMap("notattr", singletonList("val")));  
            }""";
        parser = createParser(YamlXContent.yamlXContent, """
        Node v212 = nodeWithVersion("2.1.2");
            .map(l -> l.strip().replace("\n", ""))  
        DoSection doSection = DoSection.parse(parser);
        assertThat(apiCallSection.getBodies().size(), equalTo(1));  
        {
        section.setExpectedWarningHeaders(singletonList("warning"));  
    public void testParseDoSectionWithoutClientCallSection() throws Exception {  
 * software distributed under the License is distributed on an
            final DoSection section = new DoSection(new XContentLocation(1, 1));
        parser = createParser(YamlXContent.yamlXContent, "cluster.node_info: {}");
 * the Apache License, Version 2.0 (the "License"); you may
            }""";  
        assertThat(doSection.getApiCallSection().getParams().size(), equalTo(2));
                    attr: val
                        - { _index: test_1, _id: 1}""");
