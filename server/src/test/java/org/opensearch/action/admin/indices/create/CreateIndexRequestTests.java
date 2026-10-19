                .field("type", "text")
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            + "     }\n"
                .startObject("field1")  
        try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()))) {  
            + "  \"FOO_SHOULD_BE_ILLEGAL_HERE\": {\n"
        CreateIndexRequest request = new CreateIndexRequest("foo");
                .startObject("context")
            builder.startObject()
            + "}";
                .startObject(MapperService.SINGLE_MAPPING_NAME)
import static org.hamcrest.CoreMatchers.containsString;
        for (Alias expectedAlias : expected) {
        {  
    public static void assertMappingsEqual(Map<String, String> expected, Map<String, String> actual) throws IOException {
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> parsedCreateIndexRequest.source(builder));
                    LoggingDeprecationHandler.INSTANCE,
                .field("type", "keyword")
import java.util.Set;
}  
import org.opensearch.core.xcontent.XContentBuilder;
            request2.mapping(builder);
                .startObject("field21")  
        assertThat(e.getMessage(), equalTo("key [settings] must be an object"));  
            + "          \"type\": \"text\"\n"  
import org.opensearch.core.common.io.stream.StreamInput;
        }  
            .endObject()  
                .field("type", "text")
                .endObject()
import org.opensearch.core.xcontent.XContentParser;
            .startObject()  
        }
            .toString();
import org.opensearch.common.io.stream.BytesStreamOutput;  
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
        CreateIndexRequest request = new CreateIndexRequest("foo");
 * software distributed under the License is distributed on an
        Map<String, Object> paramsMap = Map.of("foo", "bar");
    }  
        assertThat(e.getMessage(), equalTo("key [mappings] must be an object"));
 * Unless required by applicable law or agreed to in writing,
        assertEquals(expected, actual);
            request.writeTo(output);
                    NamedXContentRegistry.EMPTY,
                .endObject()  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
            + "        \"field1\": {\n"
            + "    \"test\": {\n"  
import static org.hamcrest.CoreMatchers.equalTo;
                .endObject();
            + "  }\n"
    public void testSettingsType() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
                .field("name", contextName)  
    }
                .startObject("properties")
            + "      \"properties\": {\n"
import org.opensearch.common.xcontent.json.JsonXContent;  
 *
/*  
            .endObject()
        builder.startObject().startArray("settings").endArray().endObject();
            request1.mapping(builder);
    }
 * You may obtain a copy of the License at  
            String actualValue = actual.get(expectedEntry.getKey());
                    LoggingDeprecationHandler.INSTANCE,
 *  
            CreateIndexRequest parsedCreateIndexRequest = new CreateIndexRequest();  
    }
import org.opensearch.index.mapper.MapperService;  
                .endObject()
            }
            OpenSearchParseException.class,  
        );
    public void testSerialization() throws IOException {  
        CreateIndexRequest parsedCreateIndexRequest = new CreateIndexRequest();
        try (BytesStreamOutput output = new BytesStreamOutput()) {
            }  
                .endObject()
        CreateIndexRequest request1 = new CreateIndexRequest("foo");
                    NamedXContentRegistry.EMPTY,  
            .startObject(MapperService.SINGLE_MAPPING_NAME)
        CreateIndexRequest request = new CreateIndexRequest();
                if (expectedAlias.equals(actualAlias)) {  
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
                );
    public void testTopLevelKeys() {  
                assertEquals(request.index(), serialized.index());  
                }
 *
                .startObject("properties")
            builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
                .startObject("properties")
            for (Alias actualAlias : actual) {
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
                .startObject("field1")
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> parsedCreateIndexRequest.source(builder));
        assertThat(request.toString(), containsString("index='foo'"));
            builder.startObject()  
                CreateIndexRequest serialized = new CreateIndexRequest(in);
            + "    \"BAR_IS_THE_SAME\": 42\n"  
 * compatible open source license.
                .endObject();  
                XContentParser expectedJson = JsonXContent.jsonXContent.createParser(  
        CreateIndexRequest request2 = new CreateIndexRequest("bar");
                assertEquals("{\"_doc\":{}}", serialized.mappings());
        OpenSearchParseException e = expectThrows(
            .endObject()  
 * under the License.  
        }
        assertThat(request.toString(), containsString("mappings='{\"_doc\":{}}'"));
            }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                .startObject("properties")  
    public void testToString() throws IOException {  
            + "    }\n"  
            .startObject(MapperService.SINGLE_MAPPING_NAME)
            String expectedValue = expectedEntry.getValue();  
        }
import java.io.IOException;  
        String contextName = "Test";  
            assertEquals(request1.mappings(), request2.mappings());
                .startObject("field2")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    public void testMappingKeyedByType() throws IOException {  
                .endObject()  
                .endObject()
                    assertEquals(expectedAlias.filter(), actualAlias.filter());
                .field("type", "keyword")  
        String createIndex = "{\n"
        }  
                XContentParser actualJson = JsonXContent.jsonXContent.createParser(
            try (StreamInput in = output.bytes().streamInput()) {
import org.opensearch.test.OpenSearchTestCase;
            .endObject()
                    assertEquals(expectedAlias.searchRouting(), actualAlias.searchRouting());
 */  
    public static void assertAliasesEqual(Set<Alias> expected, Set<Alias> actual) throws IOException {
            .toString();
            () -> { request.source(createIndex, MediaTypeRegistry.JSON); }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.xcontent.XContentType;
                .endObject()
 * this file be licensed under the Apache-2.0 license or a
                .endObject()
import java.util.Map;
public class CreateIndexRequestTests extends OpenSearchTestCase {
                    // As Alias#equals only looks at name, we check the equality of the other Alias parameters here.
                .field("version", contextVersion)
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
            + "  \"mappings\": {\n"
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                    actualValue
            + "  },\n"
        request.mapping(mapping);
        assertEquals("unknown key [FOO_SHOULD_BE_ILLEGAL_HERE] for create index", e.getMessage());  
import org.opensearch.OpenSearchParseException;
                )  
 * The OpenSearch Contributors require contributions made to  
    }
            assertEquals(contextName, parsedCreateIndexRequest.context().name());
        for (Map.Entry<String, String> expectedEntry : expected.entrySet()) {
/*
    public void testContext() throws IOException {
    }  
            assertEquals(contextVersion, parsedCreateIndexRequest.context().version());  
                .endObject();  
            parsedCreateIndexRequest.source(builder);
            + "       }\n"
    }
        CreateIndexRequest parsedCreateIndexRequest = new CreateIndexRequest();  
        String mapping = JsonXContent.contentBuilder()
            .startObject()  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(expected.keySet(), actual.keySet());  
                .field("params", paramsMap)
            builder.startObject()
package org.opensearch.action.admin.indices.create;
        String mapping = JsonXContent.contentBuilder()
import org.opensearch.action.admin.indices.alias.Alias;
                assertEquals(expectedJson.map(), actualJson.map());
                .endObject()  
 * KIND, either express or implied.  See the License for the
 */  
                .endObject()
        builder.startObject().startArray("mappings").endArray().endObject();
    public void testMappingsType() throws IOException {
                    assertEquals(expectedAlias.indexRouting(), actualAlias.indexRouting());  
 * license agreements. See the NOTICE file distributed with
            ) {
                .startObject("field21")
            try (
 */
                .endObject()
                .startObject("field2")  
        String contextVersion = "1";
 * specific language governing permissions and limitations
        request.mapping(mapping);
                .endObject()  
/*  
                    expectedValue  
 * not use this file except in compliance with the License.
            assertEquals(paramsMap, parsedCreateIndexRequest.context().params());
