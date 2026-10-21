                        if (token != null && (token.isValue() || token == XContentParser.Token.VALUE_NULL)) {
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
            builder.endObject();
 *
            }
                                        if (parser.longValue() <= Integer.MAX_VALUE && parser.longValue() >= Integer.MIN_VALUE) {
            builder.startArray("nested_arr");
            builder.startObject();
/*
 *
                        xContentRegistry(),
                    )
                    XContentParser.Token token;
                            if (xContentType != XContentType.YAML || token != XContentParser.Token.VALUE_EMBEDDED_OBJECT) {
                        map,
import java.util.EnumSet;
            {
                builder.field("inner_string", "bar");
            builder.field("number", 42);
                                        || parser.numberType() == XContentParser.NumberType.INT) {
 */
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
/*
            builder.field("double", 42.5);
            }
            consumer.accept(builder);
                    XContentParser mapParser = new MapXContentParser(
            }
 * The OpenSearch Contributors require contributions made to
                        LoggingDeprecationHandler.INSTANCE,
 * software distributed under the License is distributed on an
                                    break;
 * this file be licensed under the Apache-2.0 license or a
                                        assertEquals(parser.longValue(), mapParser.longValue());
 * Modifications Copyright OpenSearch Contributors. See
            }
    public void testRandomObject() throws IOException {
                                            if (parser.longValue() <= Short.MAX_VALUE && parser.longValue() >= Short.MIN_VALUE) {
                        } else if (token == XContentParser.Token.START_ARRAY || token == XContentParser.Token.START_OBJECT) {
import org.opensearch.core.xcontent.XContentParser;
                        xContentType
        }
                builder.endArray();
                                                assertEquals(parser.shortValue(), mapParser.shortValue());
import static org.opensearch.common.xcontent.XContentParserTests.generateRandomObject;
                builder.field("f", "a");
                    } while (token != null);
                                    break;
                    mapParser.close();
                                            }
import java.io.IOException;
        compareTokens(builder -> {
 * You may obtain a copy of the License at
public class MapXContentParserTests extends OpenSearchTestCase {
                builder.value(30);
                                    assertEquals(parser.text(), mapParser.text());
            {
 * GitHub history for details.
 */
            compareTokens(consumer, xContentType);
                            }
            builder.field("bool", false);
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
                map = parser.mapOrdered();
/*
                                assertEquals(parser.textOrNull(), mapParser.textOrNull());
                        token = parser.nextToken();
 * specific language governing permissions and limitations
        }
                                    assertEquals(parser.numberType(), mapParser.numberType());
            builder.endArray();
    }
 * under the License.
    }
                        assertEquals(token, mapToken);
 * not use this file except in compliance with the License.
            builder.field("string", "foo");
            builder.startArray("arr");
    public void compareTokens(CheckedConsumer<XContentBuilder, IOException> consumer) throws IOException {
                                // YAML struggles with converting byte arrays into text, because it
            }
 * compatible open source license.
                                        assertEquals(parser.doubleValue(), mapParser.doubleValue(), 0.000001);
                    assertTrue(mapParser.isClosed());
        for (XContentType xContentType : EnumSet.allOf(XContentType.class)) {
package org.opensearch.common.xcontent;
 * KIND, either express or implied.  See the License for the
                builder.value(10).value(20.0).value("30");
                }
                            switch (token) {
                    assertEquals(parser.currentName(), mapParser.currentName());
                    assertEquals(parser.isClosed(), mapParser.isClosed());
            {
                            }
                            }
import org.opensearch.test.OpenSearchTestCase;
                                    break;
                try (
                                case VALUE_NULL:
        compareTokens(builder -> generateRandomObject(builder, randomIntBetween(0, 10)));
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.MapXContentParser;
import org.opensearch.core.common.bytes.BytesReference;
            builder.endArray();
                builder.startObject("inner_empty_obj");
                                // weirdness in the MapXContentParser, so don't try to stringify it.
                                    if (parser.numberType() == XContentParser.NumberType.LONG
    }
            final Map<String, Object> map;
            builder.endObject();
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.CheckedConsumer;
                builder.value(10);
                            assertEquals(parser.isClosed(), mapParser.isClosed());
 */
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
                        }
                        XContentParser.Token mapToken = mapParser.nextToken();
            builder.field("bytes", new byte[] { 1, 2, 3 });
            logger.info("--> testing with xcontent type: {}", xContentType);
                                    assertEquals(parser.booleanValue(), mapParser.booleanValue());
    }
                    parser.close();
                                case VALUE_STRING:
                                    assertEquals(parser.numberValue(), mapParser.numberValue());
 * ownership. Elasticsearch licenses this file to you under
                                parser.skipChildren();
                builder.startArray();
                                    assertNull(mapParser.textOrNull());
                                        }
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    assertEquals(parser.currentToken(), mapParser.currentToken());
                    assertEquals(parser.nextToken(), mapParser.nextToken());
                    do {
                                case VALUE_NUMBER:
            builder.startObject("obj");
    public void compareTokens(CheckedConsumer<XContentBuilder, IOException> consumer, XContentType xContentType) throws IOException {
                                    } else {
}
                builder.endArray();
                                    break;
                ) {
                                case VALUE_EMBEDDED_OBJECT:
                                // The .binaryValue() comparison below still works correctly though.
                                    break;
                                    assertArrayEquals(parser.binaryValue(), mapParser.binaryValue());
            builder.nullField("nothing");
                                    }
        });
                                // does weird base64 decoding to the values. We don't do this
                            assertEquals(parser.currentName(), mapParser.currentName());
 * this work for additional information regarding copyright
 *
                builder.startArray();
                builder.endObject();
                        assertEquals(parser.currentName(), mapParser.currentName());
                            if (randomInt(5) == 0) {
                                case VALUE_BOOLEAN:
    public void testSimpleMap() throws IOException {
                    assertEquals(parser.contentType(), mapParser.contentType());
 * Licensed to Elasticsearch under one or more contributor
                                            assertEquals(parser.intValue(), mapParser.intValue());
                                mapParser.skipChildren();
