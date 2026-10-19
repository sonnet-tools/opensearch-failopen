    }
        // double close, and check there is no error...  
        builder.map(map);  
    }
        assertThat((char) bytes[bytes.length - 1], equalTo('\n'));
        }
 * GitHub history for details.
    public void testDateTypesConversion() throws Exception {
        generator.writeStartObject();  
        // up to 20k random terms
                    if ("filter".equals(currentFieldName)) {
            assertThat(i, equalTo(terms.size()));
            builder.map(Collections.singletonMap(null, "test"));
public class XContentBuilderTests extends OpenSearchTestCase {  
        assertNotNull(filterBuilder);
            XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    }  
        XContentGenerator generator = MediaTypeRegistry.JSON.xContent().createGenerator(os, true);  
        map.put("date", date);
        }
 * You may obtain a copy of the License at  
        string = builder.toString();  
        gen.writeStartObject();
    public void testReuseJsonGenerator() throws Exception {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            xContentBuilder.rawField("foo", new BytesArray("{\"test\":\"value\"}").streamInput());
        builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
import java.util.Map;
    public void testPrettyWithLfAtEnd() throws Exception {
        assertThat(new BytesRef(os.toByteArray()), equalTo(new BytesRef("{\"test\":\"value\"}")));  
        gen.writeStringField("name2", "something2");  
                if (token == XContentParser.Token.FIELD_NAME) {  
            XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
        generator.flush();
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.FIELD_NAME));
        Path path = PathUtils.get("path");
            xContentBuilder.rawField("foo", new BytesArray("{\"test\":\"value\"}").streamInput());
        String name = new String("file");
    }
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON).prettyPrint();
 * Modifications Copyright OpenSearch Contributors. See
                builder.startArray("foo");
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
import org.opensearch.common.geo.GeoPoint;
        assertThat(builder.toString(), equalTo("{\"calendar\":\"" + expectedCalendar + "\"}"));
    public void testWriteMapValueWithNullKeys() throws IOException {
        {  
            xContentBuilder.startObject();
                    if ("test".equals(currentFieldName)) {  
            assertThat(e.getMessage(), equalTo("Field name cannot be null"));
        XContentBuilder stringBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        generator.writeStringField("test", "value");
        builder.startObject().field("test", "value").endObject();
import org.opensearch.core.common.bytes.BytesArray;
            }
        String sData = bos.bytes().utf8ToString();
        });  
        assertEquals("""
            }""", string);
        XContentGenerator generator = MediaTypeRegistry.JSON.xContent().createGenerator(os);  
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"), Locale.ROOT);
            xContentBuilder.rawField("foo", new BytesArray("{\"test\":\"value\"}").streamInput());
        builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON).prettyPrint();
        XContentBuilder pathBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        }  
        Date date = new Date();  
        assertThat(builder.toString(), equalTo("{\"test\":[\"1\",\"2\"]}"));
import org.opensearch.core.xcontent.XContentParser;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
import java.util.HashMap;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        assertThat(e.getMessage(), equalTo("Failed to close the XContentBuilder"));  
import java.util.Calendar;  
                        filterBuilder = MediaTypeRegistry.contentBuilder(parser.contentType());
        assertThat(builder.toString(), equalTo("{\"date\":\"" + expectedDate + "\"}"));  
                        assertThat(parser.text(), equalTo("test field"));
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
        assertThat(pathBuilder.toString(), equalTo(stringBuilder.toString()));
import java.nio.file.Path;  
    }  
        map = new HashMap<>();
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {  
import org.opensearch.core.xcontent.XContentBuilder;
            assertThat(
import java.util.TimeZone;
 * not use this file except in compliance with the License.
                builder.value(0);  
        assertEquals("""
                } else if (token == XContentParser.Token.START_OBJECT) {  
    }
        map.put("calendar", calendar);
 * the Apache License, Version 2.0 (the "License"); you may
        gen.flush();
    public void testMissingEndArray() throws IOException {
import static org.hamcrest.Matchers.equalTo;
        }
    }
              }
    }
            fail("write map should have failed");
            builder.startObject();  
        XContentParser.Token token;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        pathBuilder.startObject().field(name, path).endObject();
              "foo" : {  
 *  
import java.util.GregorianCalendar;  
    }
    }
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        builder.startObject().field("test_name", (Byte) (byte) 120).endObject();
        Path path = PathUtils.get("..", "..", "path");
                    currentFieldName = parser.currentName();
 * this file be licensed under the Apache-2.0 license or a
            xContentBuilder.endObject();  
import org.apache.lucene.util.BytesRef;
    public void testHandlingOfPath() throws IOException {
    public void testRaw() throws IOException {  
        XContentBuilder stringBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
        generator.close();
import java.util.List;
    public void testHandlingOfCollectionOfPaths() throws IOException {
            );
import java.util.ArrayList;
        stringBuilder.startObject().field(name, path.toString()).endObject();
                        filterBuilder.copyCurrentStructure(parser);  
        bos.write(", source : { test : \"value\" }".getBytes("UTF8"));
                "lon" : 2.0
    public void testHandlingOfPath_absolute() throws IOException {  
    }
import org.opensearch.common.xcontent.json.JsonXContent;
                builder.startObject();
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()))) {  
                    }
            ---
        } catch (IllegalArgumentException e) {
    }  
        builder.startObject().field("test", "foo").startObject("foo").field("foobar", "boom").endObject().endObject();
            builder.field("map", Collections.singletonMap(null, "test"));
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
        builder.map(map);  
        assertThat(pathBuilder.toString(), equalTo(stringBuilder.toString()));  
            assertThat(xContentBuilder.toString(), equalTo("{\"foo\":{\"test\":\"value\"},\"foo1\":{\"test\":\"value\"}}"));
                "lat" : 1.0,
            xContentBuilder.field("test1", "value1");  
        checkPathSerialization(path);
            xContentBuilder.endObject();
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.START_OBJECT));
        builder = MediaTypeRegistry.contentBuilder(XContentType.YAML).prettyPrint();
              }  
        BytesStreamOutput bos = new BytesStreamOutput();
            builder.map(Collections.singletonMap(null, "test"));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(filterBuilder))) {  
            int i = 0;
        builder.startObject().field("calendar", calendar).endObject();  
        for (int i = 0; i < numTerms; i++) {
        {
        {  
            {
        try {
        String string = builder.toString();
            XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
            xContentBuilder.rawField("foo1", new BytesArray("{\"test\":\"value\"}").streamInput());  
            assertThat(xContentBuilder.toString(), equalTo("{\"foo\":{\"test\":\"value\"}}"));  
        assertThat(builder.toString(), equalTo("{\"calendar\":\"" + expectedCalendar + "\"}"));
            foo:
            xContentBuilder.endObject();  
                builder.startObject();
    }  
            xContentBuilder.field("test", "value");  
 * KIND, either express or implied.  See the License for the
        gen.close();
    public void testWriteMapWithNullKeys() throws IOException {
 *
            assertThat(parser.currentName(), equalTo("terms"));  
    public void testRenderGeoPoint() throws IOException {  
    }
        });
        builder.startObject().field("test", "value").endObject();  
        builder.startObject().field("test", "test field").startObject("filter").startObject("terms");  
        pathBuilder.startObject().field("file", Arrays.asList(path)).endObject();
        }
/*
    public void testWritingBinaryToStream() throws Exception {
        generator.usePrintLineFeedAtEnd();
    public void testHandlingOfPath_StringName() throws IOException {  
    public void testHandlingOfPath_relative() throws IOException {
        generator.flush();  
              foobar: "boom"
        builder.startObject().field("foo").value(new GeoPoint(1, 2)).endObject();
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
        assertThat(builder.toString(), equalTo("{\"test\":\"value\"}"));
        }
 * specific language governing permissions and limitations
package org.opensearch.common.xcontent.builder;
            xContentBuilder.startObject();  
            xContentBuilder.startObject();  
            fail("write map should have failed");  
            xContentBuilder.endObject();
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.START_OBJECT));
 * Unless required by applicable law or agreed to in writing,
        generator.flush();
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        builder.field("fakefield", terms).endObject().endObject().endObject();  
            assertThat(e.getMessage(), equalTo("Field name cannot be null"));
        Path path = PathUtils.get("path");  
import org.opensearch.common.xcontent.XContentType;  
        try {
        }  
                    }
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.FIELD_NAME));
import org.opensearch.test.OpenSearchTestCase;
        checkPathSerialization(path);
    public void testWriteFieldMapWithNullKeys() throws IOException {  
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
        // try again...
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        try {  
            xContentBuilder.field("test", "value");
            while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
        assertThat(builder.toString(), equalTo("{\"date\":\"" + expectedDate + "\"}"));
                builder.field("foo", true);  
        generator.writeStringField("test", "value");
        } catch (IllegalArgumentException e) {  
            XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
            assertThat(e.getMessage(), equalTo("Field name cannot be null"));
        assertThat(builder.toString(), equalTo("{\"test\":\"value\"}"));  
            xContentBuilder.rawField("foo1", new BytesArray("{\"test\":\"value\"}").streamInput());
 *
                assertThat(parser.text(), equalTo(terms.get(i++)));
        Map<String, Object> map = new HashMap<>();
        assertThat(e.getMessage(), equalTo("Failed to close the XContentBuilder"));
        String expectedDate = XContentOpenSearchExtension.DEFAULT_FORMATTER.format(date.toInstant());
        builder.startObject().field("test", Arrays.asList("1", "2")).endObject();  
import org.opensearch.core.common.bytes.BytesReference;  
                }
        XContentBuilder pathBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
import java.util.Date;
        generator.close();
        pathBuilder.startObject().field("file", path).endObject();
/*  
            test: "foo"  
    }  
        ByteArrayOutputStream os = new ByteArrayOutputStream();
/*  
        assertThat(BytesReference.bytes(builder).utf8ToString(), equalTo("{\"test_name\":120}"));
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()))) {
        stringBuilder.startObject().field("file", Arrays.asList(path.toString())).endObject();
    public void testCopyCurrentStructure() throws Exception {
 */
import org.opensearch.common.xcontent.XContentOpenSearchExtension;
            {  
            """, string);  
    public void testByteConversion() throws Exception {
        }
        }  
        stringBuilder.startObject().field("file", path.toString()).endObject();
        assertThat(e.getCause().getMessage(), equalTo("Unclosed object or array found"));
        assertThat(e.getCause().getMessage(), equalTo("Unclosed object or array found"));
        os.reset();  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
                xContentBuilder.toString(),  
        int numTerms = randomInt(20000) + 1;  
import org.opensearch.core.xcontent.XContentGenerator;  
 * ownership. Elasticsearch licenses this file to you under  
            xContentBuilder.rawField("foo", new BytesArray("{\"test\":\"value\"}").streamInput());
            fail("write map should have failed");
        assertThat(sData, equalTo("{\"name\":\"something\", source : { test : \"value\" },\"name2\":\"something2\"}"));
 */  
              "test" : "foo",
        XContentBuilder stringBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    }  
    }
    }
        generator.writeStringField("test", "value");
    }
 * under the License.  
            String currentFieldName = null;  
        ByteArrayOutputStream os = new ByteArrayOutputStream();
            }
            xContentBuilder.endObject();
        builder.startObject().timeField("date", date).endObject();
    public void testSimpleGenerator() throws Exception {  
            terms.add("test" + i);  
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.START_ARRAY));
        assertThat(new BytesRef(os.toByteArray()), equalTo(new BytesRef(" {\"test\":\"value\"}")));  
        assertEquals("""
        List<String> terms = new ArrayList<>(numTerms);
                equalTo("{\"test\":\"value\",\"foo\":{\"test\":\"value\"},\"foo1\":{\"test\":\"value\"},\"test1\":\"value1\"}")
        {
            }""", string.trim());
        generator.writeEndObject();  
        String expectedCalendar = XContentOpenSearchExtension.DEFAULT_FORMATTER.format(calendar.toInstant());  
        checkPathSerialization(path);  
    public void testIndentIsPlatformIndependent() throws IOException {
    public void testOverloadedList() throws Exception {
            assertThat(xContentBuilder.toString(), equalTo("{\"test\":\"value\",\"foo\":{\"test\":\"value\"},\"test1\":\"value1\"}"));
        String string = builder.toString();  
              "foo" : {
 * license agreements. See the NOTICE file distributed with
            xContentBuilder.field("test1", "value1");
            xContentBuilder.rawField("foo", new BytesArray("{\"test\":\"value\"}").streamInput());
            XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    }
    public void testMissingEndObject() throws IOException {
            assertThat(xContentBuilder.toString(), equalTo("{\"test\":\"value\",\"foo\":{\"test\":\"value\"}}"));
        Path path = createTempDir().toAbsolutePath();
        generator.writeStartObject();
import java.util.Locale;  
        assertThat(pathBuilder.toString(), equalTo(stringBuilder.toString()));
            assertThat(parser.currentName(), equalTo("fakefield"));  
}
 * compatible open source license.
        builder.startObject().field("test", "foo").startObject("foo").field("foobar", "boom").endObject().endObject();  
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            xContentBuilder.startObject();
import java.util.Arrays;
        } catch (IllegalArgumentException e) {  
                builder.value(1);
        gen.writeStringField("name", "something");  
        generator.writeStartObject();
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 */  
            xContentBuilder.field("test", "value");  
        gen.writeEndObject();
        XContentGenerator gen = MediaTypeRegistry.JSON.xContent().createGenerator(bos);
            assertThat(parser.nextToken(), equalTo(XContentParser.Token.START_OBJECT));
        XContentBuilder filterBuilder = null;
 * The OpenSearch Contributors require contributions made to  
        }
        // we get a space at the start here since it thinks we are not in the root object (fine, we will ignore it in the real code we use)
import java.util.Collections;
        builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
        generator.writeEndObject();  
    private void checkPathSerialization(Path path) throws IOException {
        byte[] bytes = os.toByteArray();  
            xContentBuilder.startObject();
        Path path = PathUtils.get("path");
        builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
                "foobar" : "boom"  
    }  
        {
import org.opensearch.common.io.PathUtils;  
        generator.writeEndObject();
                } else if (token.isValue()) {
import java.io.ByteArrayOutputStream;
        XContentBuilder pathBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
