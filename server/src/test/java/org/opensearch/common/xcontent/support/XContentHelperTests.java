import java.io.IOException;
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            map.put((String) keyValues[i], keyValues[++i]);
                .endObject()
            try (
public class XContentHelperTests extends OpenSearchTestCase {
        Map<String, Object> map = getMap(keyValues);
        } else {
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            assertNull(parser.nextToken());
    }
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
        ) {
                .field("text", "string")
            if (randomBoolean()) {
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
/*
                assertEquals("object", parser.currentName());
    public void testChildBytes() throws IOException {
        try (
                .endObject()
    }
                .field("boolean", true)
import java.util.HashMap;
                .startArray("array_of_strings")
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
 * GitHub history for details.
                assertEquals(XContentParser.Token.END_ARRAY, parser.nextToken());
                assertEquals(XContentParser.Token.VALUE_BOOLEAN, parser.nextToken());
import org.opensearch.core.xcontent.DeprecationHandler;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        ) {
            }
    public void testToXContent() throws IOException {
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                assertTrue(parser.nextToken().isValue());
    public void testMergingListValuesAreMapsOfOne() {
        CompressedXContent embedded = new CompressedXContent("{\"field\":\"value\"}");
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
        XContentHelper.mergeDefaults(content, defaults);
    }
                XContentParser parser = xContentType.xContent()
            if (randomBoolean()) {
                assertEquals("boolean", parser.currentName());
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
 */
            ) {
        final ToXContent toXContent;
            }
import org.opensearch.core.xcontent.XContentParser;
                assertEquals("value", parser.text());
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, input.streamInput())
            assertNull(parser.nextToken());
    Map<String, Object> getNamedMap(String name, Object... keyValues) {
                assertEquals("level2", parser.currentName());
        return Arrays.asList(values);
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
/*
                assertEquals("string2", parser.text());
                .value("string1")
 */
                toXContent = (builder, params) -> builder.startObject().field("field", "value").endObject();
import org.opensearch.core.xcontent.ToXContent;
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, inputJson)
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                assertEquals("string", parser.text());
        for (int i = 0; i < keyValues.length; i++) {
                assertNull(parser.nextToken());
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            try (
import java.util.Arrays;
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        ) {
                .field("number", 10)
 * specific language governing permissions and limitations
import org.opensearch.core.common.bytes.BytesReference;
                .endObject();
            inner = XContentHelper.childBytes(parser);
    }
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
    Map<String, Object> getMap(Object... keyValues) {
        }
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
 * SPDX-License-Identifier: Apache-2.0
            XContentBuilder builder = XContentBuilder.builder(xContentType.xContent());
        namedMap.put(name, map);
 * this work for additional information regarding copyright
            assertEquals("bytes", parser.currentName());
 * KIND, either express or implied.  See the License for the
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                .startObject("object2")
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
        BytesReference inner;
        return map;
import org.opensearch.common.xcontent.XContentType;
                assertEquals("string1", parser.text());
        // Need to test this separately as MediaTypeRegistry.JSON never produces VALUE_EMBEDDED_OBJECT
    }
            builder.field("field", "value");
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput())
            } else {
        }
                assertEquals("null", parser.currentName());
    }
 *
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                .startObject("object")
                assertTrue(parser.booleanValue());
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
    }
import java.util.Map;
import org.opensearch.common.xcontent.XContentHelper;
            builder.startObject().startObject("level1");
                assertEquals(XContentParser.Token.VALUE_NUMBER, parser.nextToken());
                assertEquals("object2", parser.currentName());
        builder.startObject().startObject("root");
            BytesReference bytes = XContentHelper.toXContent(toXContent, xContentType, randomBoolean());
        Map<String, Object> defaults = getMap("test", getList(getNamedMap("name1", "t1", "1"), getNamedMap("name2", "t2", "2")));
            XContentParser parser = XContentType.CBOR.xContent()
            assertEquals("{}", bytes.utf8ToString());
                toXContent = (ToXContentObject) (builder, params) -> builder.field("field", "value");
        if (error) {
import org.hamcrest.Matchers;
                assertEquals("field", parser.currentName());
            BytesReference bytes;
    public void testEmbeddedObject() throws IOException {
            XContentParser parser = MediaTypeRegistry.JSON.xContent()
                .endArray()
        for (XContentType xContentType : XContentType.values()) {
}
 * not use this file except in compliance with the License.
            assertEquals(XContentParser.Token.VALUE_EMBEDDED_OBJECT, parser.nextToken());
        final XContentType xContentType = randomFrom(XContentType.values());
                error = true;
        Map<String, Object> content = getMap("test", getList(getNamedMap("name2", "t3", "3"), getNamedMap("name4", "t4", "4")));
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
 * Licensed to Elasticsearch under one or more contributor
            expectThrows(IOException.class, () -> XContentHelper.toXContent(toXContent, xContentType, randomBoolean()));
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            XContentParser parser = XContentType.CBOR.xContent()
import org.opensearch.core.xcontent.XContentBuilder;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            getList(getNamedMap("name2", "t2", "2", "t3", "3"), getNamedMap("name4", "t4", "4"), getNamedMap("name1", "t1", "1"))
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> expected = getMap(
                error = false;
                assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
            builder.startObject("level2")
        builder.endObject().endObject();
        Map<String, Object> map = new HashMap<>();
            }
import org.opensearch.core.xcontent.ToXContentObject;
 * under the License.
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, inner.streamInput())
                assertEquals("number", parser.currentName());
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                toXContent = (ToXContentObject) (builder, params) -> builder.startObject().field("field", "value").endObject();
 * compatible open source license.
                // Extract everything under 'level2' as a bytestream
        String inputJson = "{ \"mappings\" : {} }";
        }
            "test",
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            assertEquals(embedded, new CompressedXContent(parser.binaryValue()));
        builder.field("bytes", embedded.compressed());
        BytesReference bytes = BytesReference.bytes(builder);
 * ownership. Elasticsearch licenses this file to you under
                .nullField("null")
            }
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
 *     http://www.apache.org/licenses/LICENSE-2.0
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
    List<Object> getList(Object... values) {
                error = false;
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput())
 * You may obtain a copy of the License at
                bytes = XContentHelper.childBytes(parser);
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
            BytesReference bytes = XContentHelper.childBytes(parser);
/*
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        }
        try (
        }
    public void testEmptyChildBytes() throws IOException {
                error = true;
 *
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                assertNull(parser.nextToken());
                XContentParser parser = xContentType.xContent()
                XContentParser parser = xContentType.xContent()
        XContentBuilder builder = XContentBuilder.builder(XContentType.CBOR.xContent());
                assertEquals(10, parser.numberValue());
package org.opensearch.common.xcontent.support;
        Map<String, Object> namedMap = new HashMap<>(1);
        try (
            assertNull(parser.nextToken());
import java.util.List;
            builder.endObject().endObject();
                assertEquals(XContentParser.Token.VALUE_NULL, parser.nextToken());
            } else {
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput())
        return namedMap;
 * The OpenSearch Contributors require contributions made to
                toXContent = (builder, params) -> builder.field("field", "value");
 * license agreements. See the NOTICE file distributed with
        assertThat(content, Matchers.equalTo(expected));
            }
            try (
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *
        }
            // now parse the contents of 'level2'
import org.opensearch.common.compress.CompressedXContent;
                .value("string2")
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            ) {
            BytesReference input = BytesReference.bytes(builder);
        }
        if (randomBoolean()) {
        );
                assertEquals("text", parser.currentName());
        final boolean error;
        } else {
            ) {
 */
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                assertEquals("array_of_strings", parser.currentName());
