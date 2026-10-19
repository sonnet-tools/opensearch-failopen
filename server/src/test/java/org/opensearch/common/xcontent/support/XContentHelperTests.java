/*  
                .startObject("object")  
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
        XContentBuilder builder = XContentBuilder.builder(XContentType.CBOR.xContent());
                toXContent = (ToXContentObject) (builder, params) -> builder.field("field", "value");
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
 * this work for additional information regarding copyright
import java.util.HashMap;
            if (randomBoolean()) {  
        Map<String, Object> content = getMap("test", getList(getNamedMap("name2", "t3", "3"), getNamedMap("name4", "t4", "4")));  
 * compatible open source license.
                .value("string2")  
                assertEquals("object", parser.currentName());
 * not use this file except in compliance with the License.
import org.opensearch.core.common.bytes.BytesReference;
    public void testChildBytes() throws IOException {
                .field("boolean", true)
                assertNull(parser.nextToken());  
        final XContentType xContentType = randomFrom(XContentType.values());  
            XContentParser parser = XContentType.CBOR.xContent()
                XContentParser parser = xContentType.xContent()
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                // Extract everything under 'level2' as a bytestream
                assertEquals("array_of_strings", parser.currentName());  
public class XContentHelperTests extends OpenSearchTestCase {  
 */  
 * license agreements. See the NOTICE file distributed with
                assertEquals("number", parser.currentName());  
                .field("number", 10)
        namedMap.put(name, map);
import org.hamcrest.Matchers;
                toXContent = (builder, params) -> builder.field("field", "value");  
        Map<String, Object> map = new HashMap<>();  
            builder.endObject().endObject();
            XContentParser parser = MediaTypeRegistry.JSON.xContent()  
            BytesReference bytes = XContentHelper.childBytes(parser);  
            inner = XContentHelper.childBytes(parser);
                assertEquals("string", parser.text());
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, inputJson)
                assertEquals("string2", parser.text());
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            }
 * under the License.  
        final ToXContent toXContent;
                XContentParser parser = xContentType.xContent()  
        String inputJson = "{ \"mappings\" : {} }";
        Map<String, Object> namedMap = new HashMap<>(1);
    }
 * Licensed to Elasticsearch under one or more contributor  
 */  
                assertEquals("null", parser.currentName());  
 * Modifications Copyright OpenSearch Contributors. See
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
 * GitHub history for details.
 */
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
            assertEquals("bytes", parser.currentName());
                .endObject()  
        assertThat(content, Matchers.equalTo(expected));
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
import org.opensearch.common.xcontent.XContentHelper;
                .endArray()
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
package org.opensearch.common.xcontent.support;
                assertEquals("text", parser.currentName());
        }  
                error = true;
            assertNull(parser.nextToken());  
 *     http://www.apache.org/licenses/LICENSE-2.0
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
 * SPDX-License-Identifier: Apache-2.0
    public void testMergingListValuesAreMapsOfOne() {
        BytesReference bytes = BytesReference.bytes(builder);
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            assertNull(parser.nextToken());
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            if (randomBoolean()) {
        Map<String, Object> expected = getMap(
                assertTrue(parser.nextToken().isValue());  
        );
                error = false;
                .value("string1")
        builder.field("bytes", embedded.compressed());
                assertEquals(XContentParser.Token.VALUE_BOOLEAN, parser.nextToken());  
                .startObject("object2")
        CompressedXContent embedded = new CompressedXContent("{\"field\":\"value\"}");
            // now parse the contents of 'level2'
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
    Map<String, Object> getNamedMap(String name, Object... keyValues) {
import org.opensearch.test.OpenSearchTestCase;  
        try (
import java.util.Arrays;
            try (  
                .field("text", "string")
                assertTrue(parser.booleanValue());
            BytesReference bytes = XContentHelper.toXContent(toXContent, xContentType, randomBoolean());
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
import org.opensearch.common.xcontent.XContentType;  
            builder.field("field", "value");
            expectThrows(IOException.class, () -> XContentHelper.toXContent(toXContent, xContentType, randomBoolean()));  
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
        for (int i = 0; i < keyValues.length; i++) {
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
                assertEquals("string1", parser.text());  
    Map<String, Object> getMap(Object... keyValues) {
        }  
                .startArray("array_of_strings")
            map.put((String) keyValues[i], keyValues[++i]);
    }  
        if (error) {
            "test",
        }
 *  
 * KIND, either express or implied.  See the License for the
                assertEquals(XContentParser.Token.END_ARRAY, parser.nextToken());  
import java.util.List;  
        try (
                toXContent = (builder, params) -> builder.startObject().field("field", "value").endObject();  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
            }
            assertEquals(embedded, new CompressedXContent(parser.binaryValue()));
                error = true;
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        Map<String, Object> defaults = getMap("test", getList(getNamedMap("name1", "t1", "1"), getNamedMap("name2", "t2", "2")));
        try (
            XContentBuilder builder = XContentBuilder.builder(xContentType.xContent());  
        for (XContentType xContentType : XContentType.values()) {
                bytes = XContentHelper.childBytes(parser);
        BytesReference inner;  
            try (
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
                assertEquals("value", parser.text());
        if (randomBoolean()) {  
 * this file be licensed under the Apache-2.0 license or a
        // Need to test this separately as MediaTypeRegistry.JSON never produces VALUE_EMBEDDED_OBJECT
        final boolean error;
        ) {
            } else {
/*
                assertEquals("object2", parser.currentName());
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.ToXContentObject;  
            ) {  
    }
            } else {  
            }
            assertEquals("{}", bytes.utf8ToString());
import org.opensearch.core.xcontent.DeprecationHandler;
        }
        } else {
                XContentParser parser = xContentType.xContent()
        return map;
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput())  
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, inner.streamInput())  
                assertEquals(10, parser.numberValue());
                error = false;
import org.opensearch.core.xcontent.XContentParser;
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
 *
import java.io.IOException;  
 * ownership. Elasticsearch licenses this file to you under  
                .endObject()
                toXContent = (ToXContentObject) (builder, params) -> builder.startObject().field("field", "value").endObject();
        ) {
                assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
        Map<String, Object> map = getMap(keyValues);
    }
 * The OpenSearch Contributors require contributions made to  
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            BytesReference input = BytesReference.bytes(builder);  
            }  
    public void testToXContent() throws IOException {
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
                assertEquals(XContentParser.Token.VALUE_NULL, parser.nextToken());
            getList(getNamedMap("name2", "t2", "2", "t3", "3"), getNamedMap("name4", "t4", "4"), getNamedMap("name1", "t1", "1"))  
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            ) {  
                assertEquals("level2", parser.currentName());  
            }
        ) {
    }
            assertEquals(XContentParser.Token.VALUE_EMBEDDED_OBJECT, parser.nextToken());  
 *
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
                assertEquals("boolean", parser.currentName());
            builder.startObject("level2")
                assertNull(parser.nextToken());  
    }  
            BytesReference bytes;
    List<Object> getList(Object... values) {  
    public void testEmbeddedObject() throws IOException {  
 * You may obtain a copy of the License at  
import org.opensearch.common.compress.CompressedXContent;
}  
        builder.endObject().endObject();  
                assertEquals("field", parser.currentName());
import org.opensearch.core.xcontent.ToXContent;
            ) {
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
    public void testEmptyChildBytes() throws IOException {
        return namedMap;  
        builder.startObject().startObject("root");  
                .nullField("null")  
        }
            try (  
    }  
        }
                .endObject();  
        } else {
import org.opensearch.core.xcontent.XContentBuilder;
            XContentParser parser = XContentType.CBOR.xContent()
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
/*  
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput())
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, bytes.streamInput())
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());  
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
    }
import java.util.Map;
                assertEquals(XContentParser.Token.VALUE_NUMBER, parser.nextToken());
        return Arrays.asList(values);
            builder.startObject().startObject("level1");
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, input.streamInput())
            assertNull(parser.nextToken());
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        XContentHelper.mergeDefaults(content, defaults);  
