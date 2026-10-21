    public void testPrettyWithLfAtEnd() throws Exception {
        generator.writeEndObject();
                } else if (token.isValue()) {
            }
        XContentBuilder filterBuilder = null;
        generator.writeStringField("test", "value");
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
    }
            ---
 * Modifications Copyright OpenSearch Contributors. See
    private void checkPathSerialization(Path path) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        generator.flush();
    public void testReuseJsonGenerator() throws Exception {
        builder.startObject().field("test", "test field").startObject("filter").startObject("terms");
    public void testByteConversion() throws Exception {
            xContentBuilder.endObject();
    }
        gen.writeStartObject();
        Path path = PathUtils.get("..", "..", "path");
        assertThat(sData, equalTo("{\"name\":\"something\", source : { test : \"value\" },\"name2\":\"something2\"}"));
    }
              "foo" : {
                builder.startArray("foo");
        });
        XContentBuilder pathBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
            xContentBuilder.startObject();
    public void testDateTypesConversion() throws Exception {
            xContentBuilder.rawField("foo", new BytesArray("{\"test\":\"value\"}").streamInput());
                    }
    }
            assertThat(e.getMessage(), equalTo("Field name cannot be null"));
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()))) {
    }
            while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        builder.startObject().field("test", Arrays.asList("1", "2")).endObject();
import org.opensearch.core.xcontent.XContentGenerator;
    }
        assertNotNull(filterBuilder);
        assertEquals("""
            XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        checkPathSerialization(path);
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
    public void testRaw() throws IOException {
            xContentBuilder.rawField("foo1", new BytesArray("{\"test\":\"value\"}").streamInput());
        assertEquals("""
        assertThat(builder.toString(), equalTo("{\"test\":\"value\"}"));
        }
            }""", string);
        string = builder.toString();
 *
            assertThat(xContentBuilder.toString(), equalTo("{\"foo\":{\"test\":\"value\"},\"foo1\":{\"test\":\"value\"}}"));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            xContentBuilder.rawField("foo", new BytesArray("{\"test\":\"value\"}").streamInput());
        Date date = new Date();
            xContentBuilder.rawField("foo", new BytesArray("{\"test\":\"value\"}").streamInput());
    public void testSimpleGenerator() throws Exception {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(filterBuilder))) {
        builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON).prettyPrint();
            XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        generator.close();
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        gen.writeStringField("name2", "something2");
        for (int i = 0; i < numTerms; i++) {
        stringBuilder.startObject().field("file", Arrays.asList(path.toString())).endObject();
            {
            terms.add("test" + i);
        builder.map(map);
    }
              "test" : "foo",
import org.apache.lucene.util.BytesRef;
import java.util.HashMap;
        String expectedCalendar = XContentOpenSearchExtension.DEFAULT_FORMATTER.format(calendar.toInstant());
import org.opensearch.core.xcontent.XContentParser;
    }
            assertThat(xContentBuilder.toString(), equalTo("{\"test\":\"value\",\"foo\":{\"test\":\"value\"},\"test1\":\"value1\"}"));
 * specific language governing permissions and limitations
            xContentBuilder.field("test", "value");
        }
        String string = builder.toString();
        map.put("date", date);
        XContentBuilder stringBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
              foobar: "boom"
        Map<String, Object> map = new HashMap<>();
            assertThat(e.getMessage(), equalTo("Field name cannot be null"));
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"), Locale.ROOT);
        assertThat(pathBuilder.toString(), equalTo(stringBuilder.toString()));
        Path path = createTempDir().toAbsolutePath();
    }
                }
            assertThat(xContentBuilder.toString(), equalTo("{\"foo\":{\"test\":\"value\"}}"));
        builder.startObject().timeField("date", date).endObject();
        builder.startObject().field("test_name", (Byte) (byte) 120).endObject();
        generator.flush();
        builder.startObject().field("test", "value").endObject();
              "foo" : {
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(builder.toString(), equalTo("{\"test\":\"value\"}"));
        os.reset();
        gen.close();
        builder.startObject().field("foo").value(new GeoPoint(1, 2)).endObject();
        try {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        XContentBuilder stringBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
                        filterBuilder = MediaTypeRegistry.contentBuilder(parser.contentType());
            );
import java.util.GregorianCalendar;
/*
                assertThat(parser.text(), equalTo(terms.get(i++)));
import static org.hamcrest.Matchers.equalTo;
    public void testHandlingOfPath_relative() throws IOException {
                    }
        builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
              }
        }
import java.util.List;
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.xcontent.XContentOpenSearchExtension;
                    if ("filter".equals(currentFieldName)) {
 */
    public void testHandlingOfPath_absolute() throws IOException {
 * KIND, either express or implied.  See the License for the
        builder.field("fakefield", terms).endObject().endObject().endObject();
            xContentBuilder.startObject();
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            assertThat(
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.START_ARRAY));
        XContentGenerator gen = MediaTypeRegistry.JSON.xContent().createGenerator(bos);
    }
        generator.writeEndObject();
        generator.flush();
        builder.startObject().field("test", "value").endObject();
import java.util.Collections;
import org.opensearch.common.xcontent.json.JsonXContent;
        assertThat(e.getCause().getMessage(), equalTo("Unclosed object or array found"));
        Path path = PathUtils.get("path");
 * The OpenSearch Contributors require contributions made to
                builder.field("foo", true);
        assertThat(BytesReference.bytes(builder).utf8ToString(), equalTo("{\"test_name\":120}"));
        try {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        pathBuilder.startObject().field(name, path).endObject();
            xContentBuilder.field("test", "value");
            xContentBuilder.endObject();
 * You may obtain a copy of the License at
    public void testHandlingOfPath_StringName() throws IOException {
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.START_OBJECT));
        Path path = PathUtils.get("path");
        Path path = PathUtils.get("path");
import org.opensearch.common.xcontent.XContentType;
import java.io.ByteArrayOutputStream;
            foo:
        // we get a space at the start here since it thinks we are not in the root object (fine, we will ignore it in the real code we use)
        builder.startObject().field("test", "foo").startObject("foo").field("foobar", "boom").endObject().endObject();
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            xContentBuilder.field("test1", "value1");
        gen.flush();
        {
    }
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.START_OBJECT));
        }
            }
        XContentGenerator generator = MediaTypeRegistry.JSON.xContent().createGenerator(os);
            builder.map(Collections.singletonMap(null, "test"));
            assertThat(e.getMessage(), equalTo("Field name cannot be null"));
                } else if (token == XContentParser.Token.START_OBJECT) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
    }
        map = new HashMap<>();
        String name = new String("file");
            XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        }
              }
            xContentBuilder.endObject();
            String currentFieldName = null;
        }
        } catch (IllegalArgumentException e) {
        assertThat(pathBuilder.toString(), equalTo(stringBuilder.toString()));
        builder = MediaTypeRegistry.contentBuilder(XContentType.YAML).prettyPrint();
        byte[] bytes = os.toByteArray();
            fail("write map should have failed");
        builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
                if (token == XContentParser.Token.FIELD_NAME) {
            assertThat(xContentBuilder.toString(), equalTo("{\"test\":\"value\",\"foo\":{\"test\":\"value\"}}"));
import java.util.Locale;
/*
                builder.value(0);
    }
        int numTerms = randomInt(20000) + 1;
            assertThat(i, equalTo(terms.size()));
 * under the License.
    }
 * this work for additional information regarding copyright
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.START_OBJECT));
        stringBuilder.startObject().field("file", path.toString()).endObject();
        generator.writeStringField("test", "value");
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;
        checkPathSerialization(path);
 */
                        assertThat(parser.text(), equalTo("test field"));
        assertThat(builder.toString(), equalTo("{\"date\":\"" + expectedDate + "\"}"));
        assertThat(builder.toString(), equalTo("{\"test\":[\"1\",\"2\"]}"));
        assertThat(builder.toString(), equalTo("{\"calendar\":\"" + expectedCalendar + "\"}"));
            """, string);
            int i = 0;
 * license agreements. See the NOTICE file distributed with
        pathBuilder.startObject().field("file", path).endObject();
import org.opensearch.common.io.PathUtils;
    }
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
                "foobar" : "boom"
        gen.writeStringField("name", "something");
import org.opensearch.test.OpenSearchTestCase;
        generator.writeStartObject();
            fail("write map should have failed");
        }
        BytesStreamOutput bos = new BytesStreamOutput();
    public void testRenderGeoPoint() throws IOException {
 * Licensed to Elasticsearch under one or more contributor
            xContentBuilder.startObject();
 * Unless required by applicable law or agreed to in writing,
            xContentBuilder.field("test", "value");
        // try again...
            builder.field("map", Collections.singletonMap(null, "test"));
    }
        XContentParser.Token token;
        assertThat(e.getMessage(), equalTo("Failed to close the XContentBuilder"));
        assertEquals("""
            }
import org.opensearch.core.common.bytes.BytesReference;
import java.util.Arrays;
        XContentGenerator generator = MediaTypeRegistry.JSON.xContent().createGenerator(os, true);
        generator.close();
        map.put("calendar", calendar);
            xContentBuilder.startObject();
        {
import org.opensearch.common.io.stream.BytesStreamOutput;
                equalTo("{\"test\":\"value\",\"foo\":{\"test\":\"value\"},\"foo1\":{\"test\":\"value\"},\"test1\":\"value1\"}")
            builder.startObject();
        gen.writeEndObject();
    }
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(new BytesRef(os.toByteArray()), equalTo(new BytesRef("{\"test\":\"value\"}")));
    }
        try {
                builder.value(1);
                xContentBuilder.toString(),
        // double close, and check there is no error...
    }
            xContentBuilder.rawField("foo", new BytesArray("{\"test\":\"value\"}").streamInput());
 *
            xContentBuilder.endObject();
                        filterBuilder.copyCurrentStructure(parser);
            builder.map(Collections.singletonMap(null, "test"));
        {
        } catch (IllegalArgumentException e) {
        XContentBuilder pathBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
 * not use this file except in compliance with the License.
    }
        {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON).prettyPrint();
        });
import java.util.TimeZone;
        XContentBuilder stringBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        builder.startObject().field("test", "foo").startObject("foo").field("foobar", "boom").endObject().endObject();
        generator.writeEndObject();
        String expectedDate = XContentOpenSearchExtension.DEFAULT_FORMATTER.format(date.toInstant());
import java.util.Calendar;
public class XContentBuilderTests extends OpenSearchTestCase {
        assertThat(new BytesRef(os.toByteArray()), equalTo(new BytesRef(" {\"test\":\"value\"}")));
        }
    public void testCopyCurrentStructure() throws Exception {
            {
        {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
            test: "foo"
    public void testIndentIsPlatformIndependent() throws IOException {
    public void testWriteMapWithNullKeys() throws IOException {
        generator.writeStringField("test", "value");
            }""", string.trim());
}
        assertThat((char) bytes[bytes.length - 1], equalTo('\n'));
 *
    public void testOverloadedList() throws Exception {
        assertThat(builder.toString(), equalTo("{\"calendar\":\"" + expectedCalendar + "\"}"));
    public void testWriteFieldMapWithNullKeys() throws IOException {
    public void testHandlingOfPath() throws IOException {
package org.opensearch.common.xcontent.builder;
        } catch (IllegalArgumentException e) {
        pathBuilder.startObject().field("file", Arrays.asList(path)).endObject();
            assertThat(parser.currentName(), equalTo("fakefield"));
import java.nio.file.Path;
 * GitHub history for details.
        generator.writeStartObject();
            XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        assertThat(e.getMessage(), equalTo("Failed to close the XContentBuilder"));
 * compatible open source license.
                "lat" : 1.0,
        checkPathSerialization(path);
        generator.writeStartObject();
 * this file be licensed under the Apache-2.0 license or a
 */
            xContentBuilder.rawField("foo", new BytesArray("{\"test\":\"value\"}").streamInput());
        builder.startObject().field("calendar", calendar).endObject();
        XContentBuilder pathBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    }
                builder.startObject();
            assertThat(parser.currentName(), equalTo("terms"));
        assertThat(builder.toString(), equalTo("{\"date\":\"" + expectedDate + "\"}"));
        assertThat(e.getCause().getMessage(), equalTo("Unclosed object or array found"));
        }
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()))) {
                    currentFieldName = parser.currentName();
                "lon" : 2.0
    public void testHandlingOfCollectionOfPaths() throws IOException {
        String string = builder.toString();
import java.util.Map;
import java.io.IOException;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
import java.util.Date;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
            xContentBuilder.rawField("foo1", new BytesArray("{\"test\":\"value\"}").streamInput());
                    if ("test".equals(currentFieldName)) {
        builder.map(map);
                builder.startObject();
            xContentBuilder.endObject();
        }
import org.opensearch.common.geo.GeoPoint;
            xContentBuilder.startObject();
            fail("write map should have failed");
    public void testMissingEndObject() throws IOException {
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.FIELD_NAME));
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.FIELD_NAME));
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        bos.write(", source : { test : \"value\" }".getBytes("UTF8"));
        generator.usePrintLineFeedAtEnd();
/*
    public void testWriteMapValueWithNullKeys() throws IOException {
    }
    public void testMissingEndArray() throws IOException {
        stringBuilder.startObject().field(name, path.toString()).endObject();
        builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        String sData = bos.bytes().utf8ToString();
        List<String> terms = new ArrayList<>(numTerms);
        assertThat(pathBuilder.toString(), equalTo(stringBuilder.toString()));
        }
        // up to 20k random terms
            xContentBuilder.field("test1", "value1");
            XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    public void testWritingBinaryToStream() throws Exception {
import org.opensearch.core.common.bytes.BytesArray;
