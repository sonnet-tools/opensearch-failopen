            builder.field("number", 42);
 */  
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
                builder.endObject();
            compareTokens(consumer, xContentType);
import org.opensearch.common.CheckedConsumer;
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.MapXContentParser;  
/*  
            {  
                            if (xContentType != XContentType.YAML || token != XContentParser.Token.VALUE_EMBEDDED_OBJECT) {  
                    assertEquals(parser.nextToken(), mapParser.nextToken());
                                    assertEquals(parser.text(), mapParser.text());  
                    } while (token != null);  
                        }
        }  
 * The OpenSearch Contributors require contributions made to  
                                case VALUE_BOOLEAN:  
                map = parser.mapOrdered();
            builder.startArray("nested_arr");
                                case VALUE_NUMBER:
    }
                                        }
 * ownership. Elasticsearch licenses this file to you under  
            }  
                        token = parser.nextToken();
                builder.value(10).value(20.0).value("30");
                builder.endArray();
                    parser.close();
            builder.nullField("nothing");
                                case VALUE_NULL:  
package org.opensearch.common.xcontent;
                        } else if (token == XContentParser.Token.START_ARRAY || token == XContentParser.Token.START_OBJECT) {  
            }
                                        || parser.numberType() == XContentParser.NumberType.INT) {  
            }  
                        xContentType
import static org.opensearch.common.xcontent.XContentParserTests.generateRandomObject;  
            }
            {  
                    assertEquals(parser.currentToken(), mapParser.currentToken());
                        assertEquals(parser.currentName(), mapParser.currentName());
                                assertEquals(parser.textOrNull(), mapParser.textOrNull());
                                    assertEquals(parser.numberType(), mapParser.numberType());  
                }  
            builder.field("string", "foo");
                                mapParser.skipChildren();  
                builder.startArray();
                    assertEquals(parser.contentType(), mapParser.contentType());
                            switch (token) {
 */  
    public void testSimpleMap() throws IOException {
            builder.endObject();  
            builder.startArray("arr");
import org.opensearch.core.common.bytes.BytesReference;
            consumer.accept(builder);
            builder.endArray();  
 * KIND, either express or implied.  See the License for the
                try (  
                        xContentRegistry(),
import org.opensearch.core.xcontent.XContentParser;
            builder.startObject();  
                                    break;
import org.opensearch.core.xcontent.XContentBuilder;
                                        assertEquals(parser.doubleValue(), mapParser.doubleValue(), 0.000001);  
                            assertEquals(parser.currentName(), mapParser.currentName());
                                case VALUE_STRING:
            builder.field("double", 42.5);  
        });
public class MapXContentParserTests extends OpenSearchTestCase {
            builder.field("bytes", new byte[] { 1, 2, 3 });
 * SPDX-License-Identifier: Apache-2.0
            {
                                    break;
 */
                                    assertNull(mapParser.textOrNull());
                                            assertEquals(parser.intValue(), mapParser.intValue());  
                                    assertEquals(parser.numberValue(), mapParser.numberValue());
    }
                                    assertArrayEquals(parser.binaryValue(), mapParser.binaryValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                builder.startArray();  
                builder.startObject("inner_empty_obj");
 * this work for additional information regarding copyright
                    XContentParser mapParser = new MapXContentParser(
                                            if (parser.longValue() <= Short.MAX_VALUE && parser.longValue() >= Short.MIN_VALUE) {
                        map,
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
                                // does weird base64 decoding to the values. We don't do this
                        assertEquals(token, mapToken);  
                                    assertEquals(parser.booleanValue(), mapParser.booleanValue());
                    XContentParser.Token token;  
                builder.endArray();
                                    }
    public void compareTokens(CheckedConsumer<XContentBuilder, IOException> consumer, XContentType xContentType) throws IOException {  
 * compatible open source license.
    public void compareTokens(CheckedConsumer<XContentBuilder, IOException> consumer) throws IOException {
 * You may obtain a copy of the License at  
                    do {  
                    mapParser.close();  
                            if (randomInt(5) == 0) {
                            }
import java.util.EnumSet;  
                                                assertEquals(parser.shortValue(), mapParser.shortValue());
            builder.startObject("obj");
        compareTokens(builder -> generateRandomObject(builder, randomIntBetween(0, 10)));
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
 *
 *  
/*
 * specific language governing permissions and limitations
 * GitHub history for details.
                    assertEquals(parser.isClosed(), mapParser.isClosed());
    }
        }  
                builder.field("inner_string", "bar");
            builder.field("bool", false);
/*  
            logger.info("--> testing with xcontent type: {}", xContentType);
                            }  
}
import java.io.IOException;
                ) {
                                // YAML struggles with converting byte arrays into text, because it
import org.opensearch.test.OpenSearchTestCase;  
            builder.endObject();  
import java.util.Map;
                                        assertEquals(parser.longValue(), mapParser.longValue());
                        if (token != null && (token.isValue() || token == XContentParser.Token.VALUE_NULL)) {
                builder.value(10);
                                    } else {
                                    break;
                builder.value(30);  
                        XContentParser.Token mapToken = mapParser.nextToken();
                                            }  
                    )  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
                                        if (parser.longValue() <= Integer.MAX_VALUE && parser.longValue() >= Integer.MIN_VALUE) {
 * software distributed under the License is distributed on an
                                parser.skipChildren();
                                    break;
 * license agreements. See the NOTICE file distributed with
                            }  
            final Map<String, Object> map;  
    }  
                                case VALUE_EMBEDDED_OBJECT:  
                builder.field("f", "a");  
                    assertEquals(parser.currentName(), mapParser.currentName());
        for (XContentType xContentType : EnumSet.allOf(XContentType.class)) {  
 *
                    assertTrue(mapParser.isClosed());
        compareTokens(builder -> {
            builder.endArray();
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
                                // The .binaryValue() comparison below still works correctly though.
    public void testRandomObject() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
                        LoggingDeprecationHandler.INSTANCE,  
                                    if (parser.numberType() == XContentParser.NumberType.LONG
                            assertEquals(parser.isClosed(), mapParser.isClosed());
            }
                                // weirdness in the MapXContentParser, so don't try to stringify it.  
                                    break;
