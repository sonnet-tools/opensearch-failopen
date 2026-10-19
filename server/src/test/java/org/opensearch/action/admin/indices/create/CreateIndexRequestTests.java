                .endObject()
            builder.startObject()
                .endObject()
    public void testSettingsType() throws IOException {
                .endObject()
                .endObject()
                .startObject("field1")
            String expectedValue = expectedEntry.getValue();
        String createIndex = "{\n"
import org.opensearch.OpenSearchParseException;
                .endObject();
            String actualValue = actual.get(expectedEntry.getKey());
        request.mapping(mapping);
package org.opensearch.action.admin.indices.create;
                .endObject()
            + "     }\n"
            try (StreamInput in = output.bytes().streamInput()) {
import org.opensearch.core.xcontent.XContentBuilder;
    }
        assertEquals(expected.keySet(), actual.keySet());
 * software distributed under the License is distributed on an
            request.writeTo(output);
        assertEquals(expected, actual);
 *
                .startObject("properties")
                .field("type", "keyword")
    public void testSerialization() throws IOException {
        {
            .endObject()
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
    }
        );
                    actualValue
import java.io.IOException;
    public void testMappingKeyedByType() throws IOException {
                    NamedXContentRegistry.EMPTY,
import static org.hamcrest.CoreMatchers.containsString;
                    assertEquals(expectedAlias.indexRouting(), actualAlias.indexRouting());
            .endObject()
 * this file be licensed under the Apache-2.0 license or a
                if (expectedAlias.equals(actualAlias)) {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
    }
                .startObject(MapperService.SINGLE_MAPPING_NAME)
            + "       }\n"
        assertThat(request.toString(), containsString("mappings='{\"_doc\":{}}'"));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.io.stream.BytesStreamOutput;
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
            assertEquals(paramsMap, parsedCreateIndexRequest.context().params());
 * GitHub history for details.
                    LoggingDeprecationHandler.INSTANCE,
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> parsedCreateIndexRequest.source(builder));
 * compatible open source license.
        String mapping = JsonXContent.contentBuilder()
        try (BytesStreamOutput output = new BytesStreamOutput()) {
public class CreateIndexRequestTests extends OpenSearchTestCase {
 *    http://www.apache.org/licenses/LICENSE-2.0
                .endObject();
            .toString();
import org.opensearch.core.xcontent.MediaTypeRegistry;
                .startObject("field1")
 *
            .endObject()
        for (Alias expectedAlias : expected) {
                }
        request.mapping(mapping);
 * specific language governing permissions and limitations
            builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
            OpenSearchParseException.class,
    public void testTopLevelKeys() {
            + "    }\n"
                .startObject("field2")
            + "          \"type\": \"text\"\n"
 */
        assertThat(e.getMessage(), equalTo("key [settings] must be an object"));
            + "      \"properties\": {\n"
            builder.startObject()
                .startObject("field21")
            ) {
 * Unless required by applicable law or agreed to in writing,
                .endObject()
                .endObject()
                    // As Alias#equals only looks at name, we check the equality of the other Alias parameters here.
 * ownership. Elasticsearch licenses this file to you under
            + "  }\n"
 * the Apache License, Version 2.0 (the "License"); you may
            + "  \"mappings\": {\n"
        String mapping = JsonXContent.contentBuilder()
import org.opensearch.index.mapper.MapperService;
 *
    }
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> parsedCreateIndexRequest.source(builder));
        CreateIndexRequest parsedCreateIndexRequest = new CreateIndexRequest();
                .endObject();
        CreateIndexRequest request1 = new CreateIndexRequest("foo");
                .endObject()
                .field("params", paramsMap)
        }
            .endObject()
            + "    \"test\": {\n"
        }
                    assertEquals(expectedAlias.filter(), actualAlias.filter());
                .field("name", contextName)
                assertEquals("{\"_doc\":{}}", serialized.mappings());
 * not use this file except in compliance with the License.
            + "  },\n"
 * KIND, either express or implied.  See the License for the
    public void testContext() throws IOException {
                assertEquals(request.index(), serialized.index());
 */
            + "    \"BAR_IS_THE_SAME\": 42\n"
            }
/*
            .startObject()
                .field("type", "keyword")
                );
            }
    public static void assertAliasesEqual(Set<Alias> expected, Set<Alias> actual) throws IOException {
                .field("version", contextVersion)
    public static void assertMappingsEqual(Map<String, String> expected, Map<String, String> actual) throws IOException {
import org.opensearch.action.admin.indices.alias.Alias;
            .startObject(MapperService.SINGLE_MAPPING_NAME)
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()))) {
        Map<String, Object> paramsMap = Map.of("foo", "bar");
                XContentParser actualJson = JsonXContent.jsonXContent.createParser(
import org.opensearch.core.common.io.stream.StreamInput;
            builder.startObject()
        CreateIndexRequest request = new CreateIndexRequest();
import org.opensearch.test.OpenSearchTestCase;
        CreateIndexRequest request = new CreateIndexRequest("foo");
                    expectedValue
                .startObject("context")
                    assertEquals(expectedAlias.searchRouting(), actualAlias.searchRouting());
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.Set;
import org.opensearch.common.xcontent.json.JsonXContent;
            try (
                .endObject()
                .startObject("properties")
            CreateIndexRequest parsedCreateIndexRequest = new CreateIndexRequest();
                .endObject()
                .startObject("properties")
    }
 * The OpenSearch Contributors require contributions made to
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String contextName = "Test";
        OpenSearchParseException e = expectThrows(
            .startObject(MapperService.SINGLE_MAPPING_NAME)
    public void testToString() throws IOException {
 * under the License.
                .field("type", "text")
import java.util.Map;
        String contextVersion = "1";
        assertThat(request.toString(), containsString("index='foo'"));
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.xcontent.XContentType;
                .field("type", "text")
import org.opensearch.core.xcontent.XContentParser;
                CreateIndexRequest serialized = new CreateIndexRequest(in);
            for (Alias actualAlias : actual) {
        }
            + "  \"FOO_SHOULD_BE_ILLEGAL_HERE\": {\n"
 * this work for additional information regarding copyright
                .startObject("properties")
        CreateIndexRequest request2 = new CreateIndexRequest("bar");
                XContentParser expectedJson = JsonXContent.jsonXContent.createParser(
    }
 * license agreements. See the NOTICE file distributed with
                    NamedXContentRegistry.EMPTY,
}
 * SPDX-License-Identifier: Apache-2.0
                .startObject("field2")
        for (Map.Entry<String, String> expectedEntry : expected.entrySet()) {
            request1.mapping(builder);
        builder.startObject().startArray("settings").endArray().endObject();
            + "        \"field1\": {\n"
            }
    public void testMappingsType() throws IOException {
    }
            request2.mapping(builder);
            assertEquals(contextVersion, parsedCreateIndexRequest.context().version());
 */
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * You may obtain a copy of the License at
/*
        assertEquals("unknown key [FOO_SHOULD_BE_ILLEGAL_HERE] for create index", e.getMessage());
            () -> { request.source(createIndex, MediaTypeRegistry.JSON); }
            .startObject()
            + "}";
            parsedCreateIndexRequest.source(builder);
                .endObject()
            assertEquals(request1.mappings(), request2.mappings());
                .startObject("field21")
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        CreateIndexRequest request = new CreateIndexRequest("foo");
            .toString();
        }
                .endObject()
        assertThat(e.getMessage(), equalTo("key [mappings] must be an object"));
            assertEquals(contextName, parsedCreateIndexRequest.context().name());
/*
                )
    }
    }
        builder.startObject().startArray("mappings").endArray().endObject();
        CreateIndexRequest parsedCreateIndexRequest = new CreateIndexRequest();
                assertEquals(expectedJson.map(), actualJson.map());
                    LoggingDeprecationHandler.INSTANCE,
