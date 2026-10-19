        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startArray("some_array").endArray().endObject();
                int tokensToSkip = randomInt(numberOfTokens);  
                assertEquals(field, parser.currentName());
            assertThat(map, equalTo(i));
                assertEquals("Expected text() to preserve original value", value, parser.text());
                    assertNotNull(subParser.nextToken());
        XContentType.JSON,  
            final int maxDepth = OFF_LIMIT_DEPTH_GENERATORS.get(xContentType).get() - 1;
            token = parser.nextToken();  
            }  
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
        sub1.put("type", "keyword");
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {  
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
    public void testSubParserObject() throws IOException {
        assertThat(map.get("kbaz"), equalTo("vbaz"));  
            if (level < 5) { // don't need to go too deep
    }
                XContentParser.Token token = parser.nextToken();
            try (XContentParser parser = createParser(YamlXContent.yamlXContent, yaml)) {
                builder.endObject();
            .endArray()  
        assertThat(readList("{\"foo\": [null]}"), contains(nullValue()));
        () -> randomAlphaOfLength(CborXContent.DEFAULT_MAX_STRING_LEN + 1),  
            if (randomBoolean()) {  
                for (int i = 0; i < tokensToSkip; i++) {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {
        String[] falsyValues = { "false", "False", "FALSE", "no", "No", "NO", "off", "Off", "OFF" };  
                assertEquals("Expected VALUE_BOOLEAN token for '" + value + "'", XContentParser.Token.VALUE_BOOLEAN, token);
    }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
            builder.startObject();
                }
    private static final Map<XContentType, Supplier<String>> FIELD_NAME_GENERATORS = Map.of(
        final String field = randomAlphaOfLengthBetween(1, 5);  
        // Since parser and generator use the same max depth constraints, we could not generate the content with off limits,
        }, () -> {
            XContentParser.Token token = parser.nextToken();
                    subParser.skipChildren();
            return (List<T>) (randomBoolean() ? parser.listOrderedMap() : parser.list());
        }
        assertThat(map.get("kbar"), equalTo("vbar"));
    private static final Map<XContentType, Supplier<Integer>> DEPTH_GENERATORS = Map.of(  
            } else {
            .startObject()  
        for (String value : truthyValues) {
        assertThat(readList("{\"foo\": []}"), hasSize(0));  
    }
        int numberOfElements = randomInt(5);  
 * You may obtain a copy of the License at  
            builder.endObject();
            }
        () -> randomAlphaOfLength(CborXContent.DEFAULT_MAX_NAME_LEN + 1),
            for (int depth = 0; depth < maxDepth; ++depth) {  
import java.util.Locale;
import org.opensearch.core.xcontent.XContentParseException;
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
                subParser.close();  
            if (randomBoolean()) {
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            // Smile fails with tools.jackson.core.exc.StreamWriteException: Current context not Object but root  
            IllegalStateException exception = expectThrows(IllegalStateException.class, () -> new XContentSubParser(parser));  
                    assertThrows(StreamConstraintsException.class, () -> parser.text());
                text = parser.text();
            }
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
            }
            assertThat(parser.currentName(), equalTo("bar"));
            + "\"c\": { \"i\": 3, \"d\": 0.3, \"s\": \"ccc\" }"  
        final XContentType xContentType = randomFrom(XContentType.values());
            token = parser.nextToken();
    }  
        int numberOfTokens = 0;
            switch (xContentType) {  
            } else {
    );  
        } catch (final IllegalStateException ex) {  
            if (level < 3) {  
        String content = builder.toString();  
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {  
            assertThat(parser.currentName(), equalTo("foo"));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        XContentType.JSON,
import org.opensearch.core.common.bytes.BytesReference;  
            }
                }
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            assertEquals("last_field", parser.currentName());
                assertEquals("Expected text() to preserve original value", value, parser.text());  
            Map<String, Object> map = parser.map();
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
    public void testNestedList() throws IOException {
            .value(0)  
        XContentType.JSON,
        }  
        () -> randomIntBetween(1, SmileXContent.DEFAULT_MAX_DEPTH),  
        final int maxDepth = OFF_LIMIT_DEPTH_GENERATORS.get(xContentType).get() - 1;
        }, () -> {
            + "}";
    public void testGenericMap() throws IOException {
                expectThrows(JsonParseException.class, parser::booleanValue);  
    private static final Map<XContentType, Supplier<String>> GENERATORS = Map.of(
            .value(3)  
        XContentType.SMILE,
                return 1;  
                    // Simulate incomplete parsing
import org.opensearch.tools.jackson.core.JsonParseException;  
                builder.startObject();
                // sometimes read the start array token, sometimes not
                // sometimes read the start array token, sometimes not
 * not use this file except in compliance with the License.
        final XContentType xContentType = randomFrom(XContentType.values());
            for (int depth = 0; depth < maxDepth; ++depth) {
    }  
            token = parser.nextToken();  
        XContentType.YAML,  
                    // And sometimes skipping children  
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
                assertEquals(field, parser.currentName());
    }
        int numberOfTokens = generateRandomObjectForMarking(builder);
        XContentType.CBOR,
    }
            }
 * Licensed to Elasticsearch under one or more contributor  
     * Returns the number of tokens in the marked field  
        () -> randomAlphaOfLengthBetween(1, CborXContent.DEFAULT_MAX_NAME_LEN),  
            if (token.equals(XContentParser.Token.VALUE_STRING)) {  
    public void testDepth() throws IOException {  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.common.xcontent.json.JsonXContent;  
    }
    public void testReadBooleansFailsForLenientBooleans() throws IOException {
            builder.startObject();
                assertTrue("Expected '" + value + "' to be a boolean value", parser.isBooleanValue());
            }
        for (int i = 0; i < numberOfArrayElements; ++i) {  
        /* YAML parser limitation */
        () -> randomAlphaOfLength(SmileXContent.DEFAULT_MAX_STRING_LEN + 1),
                assertEquals("field", parser.currentName());
    }  
                assertEquals("Expected VALUE_BOOLEAN token for '" + value + "'", XContentParser.Token.VALUE_BOOLEAN, token);  
        }
            .startObject()
            .endObject()
        int numberOfTokens = generateRandomObject(builder, 0);
            token = parser.nextToken();  
    public void testReadMapStrings() throws IOException {  
                    assertThat(number, instanceOf(Double.class));
            + "\"c\": { \"i\": 3, \"d\": 0.3, \"s\": \"ccc\" }, "
 * GitHub history for details.
    public void testCreateRootSubParser() throws IOException {
            assertTrue(parser.isBooleanValue());
                // don't need to go too deep
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
            XContentParser.Token token = parser.nextToken();
                assertNull(parser.nextToken());
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken()); // first field
        }  
            numberOfTokens += generateRandomObject(builder, 0);
        final String value = randomAlphaOfLengthBetween(1, 5);  
package org.opensearch.common.xcontent;
    }  
        assumeThat(xContentType, not(XContentType.YAML));
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
        properties.put("sub1", sub1);  
 * license agreements. See the NOTICE file distributed with
            assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
                assertTrue(subParser.isClosed());
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
        }
            .endArray()
                    assertEquals(field + depth, parser.currentName());  
 *  
            // state seems to be completely messed up and the closing cleanly seems to be not feasible.
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            builder.value(randomDouble());  
                int tokensToSkip = randomInt(numberOfTokens + 3);
        assertThat(map.size(), equalTo(1));  
import static org.hamcrest.Matchers.contains;  
                assertEquals(field, parser.currentName());
            final int maxDepth = OFF_LIMIT_DEPTH_GENERATORS.get(XContentType.YAML).get() - 1;
            if (randomBoolean()) {
        XContentType.CBOR,
                }
            String yaml = "---\nfield: " + value + "\n";  
    public void testCreateSubParserAtAWrongPlace() throws IOException {  
        String content = builder.toString();  
                default:  
        assertThat(readList("{\"foo\": [1, 2, 3], \"bar\": 4}"), contains(1, 2, 3));  
import static org.hamcrest.Matchers.hasLength;
        SimpleStruct structC = new SimpleStruct(3, 0.3, "ccc");
                    subParser.skipChildren();
            return 1;
import static java.util.Collections.emptyMap;  
        SimpleStruct structA = new SimpleStruct(1, 0.1, "aaa");
        final XContentType xContentType = randomFrom(XContentType.values());  
        Map<String, Object> f2 = new HashMap<>();
            }
            assertThat(token, in(Arrays.asList(XContentParser.Token.VALUE_STRING, XContentParser.Token.VALUE_BOOLEAN)));
        XContentType.SMILE,  
        XContentType.YAML,
import static org.hamcrest.Matchers.in;  
        return numberOfTokens;  
    public void testFieldNameOffLimit() throws IOException {
        f1.put("type", "text");
            }
            }
            .startObject()  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
                    // And sometimes skipping children  
                return generateRandomArray(builder, level);  
        }  
        assertReadListThrowsException("{\"foo\": {\"bar\":\"baz\"}}");
        }
        for (int i = 0; i < arraySize; i++) {
        }
    }
        XContentType.JSON,
 *
                builder.startObject();
            }
                builder.field(field).value(value);  
                    assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                expectThrows(IllegalArgumentException.class, parser::booleanValue);
            if (random().nextBoolean()) {
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
    }
        String content = "{"
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
            }
            assertEquals("some_array", parser.currentName());
        doc.put("f1", f1);
                assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {
            assertNull(parser.nextToken());
        final XContentType xContentType = randomFrom(XContentType.values());
 * KIND, either express or implied.  See the License for the
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
/*  
            token = parser.nextToken();  
        final XContentType xContentType = randomFrom(XContentType.values());  
            token = parser.nextToken();  
                builder.field(field).value(value);  
        )
            // Verify map contents, ignore the iteration order.
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
        XContentType.JSON,  
        }  
import org.opensearch.common.CheckedSupplier;
    private Map<String, String> readMapStrings(String source) throws IOException {  
        for (String value : falsyValues) {
                assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
                builder.field(field, value);
 *
 * software distributed under the License is distributed on an
        @SuppressWarnings("unchecked")
        assertThat(readList("{\"foo\": [\"bar\",\"baz\"]}"), contains("bar", "baz"));
            .value(2)  
            }
            if (random().nextBoolean()) {  
                for (int i = 0; i < tokensToSkip; i++) {
        Map<String, Object> i = new HashMap<>();
                builder.field(field).value(value);  
import static org.hamcrest.Matchers.nullValue;
        () -> randomAlphaOfLength(YamlXContent.DEFAULT_MAX_NAME_LEN + 1)  
            assertEquals(Arrays.asList(Collections.<Integer>emptyList(), Arrays.asList(1, 3), Arrays.asList(2)), parser.list());
    private static int generateRandomObjectForMarking(XContentBuilder builder) throws IOException {
import static org.hamcrest.CoreMatchers.not;
            if (xContentType != XContentType.SMILE) {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        () -> randomRealisticUnicodeOfCodepointLengthBetween(
        ) {
        SimpleStruct structB = new SimpleStruct(2, 0.2, "bbb");
            assertNull(parser.nextToken());
    }
            }  
        final String value = GENERATORS.get(xContentType).get();
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {  
import org.opensearch.common.xcontent.yaml.YamlXContent;
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                // sometimes read the start array token, sometimes not  
        final String field = randomAlphaOfLengthBetween(1, 5);  
            .startObject()  
                assertNull(parser.nextToken());
    );
        XContentBuilder builder = XContentFactory.jsonBuilder();  
        }
import static org.hamcrest.Matchers.containsInAnyOrder;
import java.util.Map;
        builder.field("array");  
        Map<String, Object> f1 = new HashMap<>();  
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        builder.endArray();
            builder.startObject();
            final int maxDepth = DEPTH_GENERATORS.get(xContentType).get() - 1;
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            }
                }
    }  
            if (randomBoolean()) {  
        expectedMap.put("c", structC);  
        XContentType.SMILE,
    public void testString() throws IOException {  
            Map<String, SimpleStruct> actualMap = parser.map(HashMap::new, SimpleStruct::fromXContent);
                builder.field(field, value);
                assertFalse(subParser.isClosed());
            builder.field(randomAlphaOfLength(10) + "_" + i);
                expectThrows(IllegalArgumentException.class, parser::booleanValue);
            assertEquals("some_array", parser.currentName());  
        int numberOfTokens;
            XContentParseException exception = expectThrows(  
            assertThat(parser.currentName(), equalTo("foo"));
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        builder.startObject();
        f1.put("analyzer", "english");
import org.opensearch.tools.jackson.core.StreamConstraintsException;
            assertTrue(parser.booleanValue());
            assertEquals(Arrays.asList(1, 3, 0), parser.list());  
            assertThat(token, in(Arrays.asList(XContentParser.Token.VALUE_STRING, XContentParser.Token.VALUE_BOOLEAN)));  
            .endArray()
            assertEquals("some_array", parser.currentName());
                    assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            if (randomBoolean()) {  
            }
        final XContentType xContentType = randomFrom(XContentType.values());
 * SPDX-License-Identifier: Apache-2.0
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
            assertFalse(parser.isBooleanValue());
            + "\"f2\": {\"type\": \"object\", \"properties\": {\"sub1\": {\"type\": \"keyword\", \"foo\": 17}}}}}}";
        Map<String, SimpleStruct> expectedMap = new HashMap<>();
        builder.endObject();
        }, () -> {
            } else {
    private void assertReadListThrowsException(String source) {
            .value(3)
            + "}";
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
        String falsy = randomFrom("\"false\"", "false");  
        }
        String source = "{\"i\": {\"_doc\": {\"f1\": {\"type\": \"text\", \"analyzer\": \"english\"}, "
import static org.hamcrest.Matchers.instanceOf;
 * Modifications Copyright OpenSearch Contributors. See
            token = parser.nextToken();
                assertTrue("Expected '" + value + "' to parse as true", parser.booleanValue());
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
        final String field = randomAlphaOfLengthBetween(1, 5);
        () -> randomAlphaOfLength(SmileXContent.DEFAULT_MAX_NAME_LEN + 1),
                }
            assertTrue(parser.isBooleanValue());
            builder.value(randomAlphaOfLength(10));  
        XContentType.CBOR,
            .startArray("some_array")
        () -> randomRealisticUnicodeOfCodepointLength(YamlXContent.DEFAULT_CODEPOINT_LIMIT + 1)
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
    public void testWriteDepthOffLimitYaml() throws IOException {
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
                expectThrows(JsonParseException.class, parser::booleanValue);  
            } else {
 */  
            fail("should have thrown a parse exception");
        XContentType.YAML,
    }
                assertFalse("Expected '" + value + "' to parse as false", parser.booleanValue());
            try {
                builder.endObject();
            builder.startObject();
            assertThat(token, in(Arrays.asList(XContentParser.Token.VALUE_STRING, XContentParser.Token.VALUE_NUMBER)));
            builder.endObject();
                builder.value(0);
        }  
        return fieldGenerator.get();  
            }
import org.opensearch.test.OpenSearchTestCase;
        Map<String, SimpleStruct> expectedMap = new HashMap<>();  
        doc.put("f2", f2);
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {  
        try {  
            .endObject();  
                assertNull(parser.nextToken());
            .startArray("some_array")  
        sub1.put("foo", 17);  
        }  
                }
import org.opensearch.common.xcontent.smile.SmileXContent;
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
    public void testSubParserArray() throws IOException {
            .startArray("some_array")
                for (int depth = 0; depth < maxDepth; ++depth) {  
    /**  
     */
        final XContentType xContentType = randomFrom(XContentType.values());
                assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());  
            // BUT throws the exception after the fact, this is why we have to close the object at the end.
                    assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            }
        Map<String, String> map = readMapStrings("{\"foo\": {\"kbar\":\"vbar\"}}");
            }  
        builder.startObject();
            .endObject();  
    public void testReadListThrowsException() throws IOException {  
            }
            // BUT throws the exception after the fact, this is why we have to close the object at the end.
                    assertThat(number, instanceOf(Float.class));  
    );  
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());  
            assertEquals("first_field", parser.currentName());
                    assertThrows(StreamConstraintsException.class, () -> parser.nextToken());  
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
            .endArray()
    }
            token = parser.nextToken();
        assertThat(readList("{\"foo\": [\"bar\"]}"), contains("bar"));
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));  
                    break;
                subParser.close();  
            }
            Math.min(YamlXContent.DEFAULT_CODEPOINT_LIMIT / 2, YamlXContent.DEFAULT_MAX_STRING_LEN / 2)
    }  
            .endObject()
        expectedMap.put("c", structC);
        f2.put("type", "object");  
        String content = "{"  
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            + "\"a\": { \"i\": 1, \"d\": 0.1, \"s\": \"aaa\" }, "
        }
        expected.put("_doc", doc);
import static org.hamcrest.Matchers.hasSize;
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
            + "\"b\": { \"i\": 2, \"d\": 0.2, \"s\": 666 }, "
    public void testReadBooleans() throws IOException {
            Map<String, SimpleStruct> actualMap = parser.map(LinkedHashMap::new, SimpleStruct::fromXContent);
        // using precreated test files instead.
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken()); // marked field
import java.util.LinkedHashMap;
        map = readMapStrings("{\"foo\": {\"kbar\":\"vbar\", \"kbaz\":\"vbaz\"}}");
                builder.endObject();  
                XContentParseException.class,
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
        }  
            // The behavior here is very interesting: the generator does write the new object tag (changing the internal state)  
            + "\"a\": { \"i\": 1, \"d\": 0.1, \"s\": \"aaa\" }, "  
            } else {
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));  
    }  
                builder.field(field).value(value);
        XContentType.CBOR,
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
        int tokens = 2;
        XContentType.CBOR,  
    private static final Map<XContentType, Supplier<Integer>> OFF_LIMIT_DEPTH_GENERATORS = Map.of(
            XContentParser.Token token = parser.nextToken();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        int arraySize = randomInt(3);
        } catch (Exception e) {  
    }  
            }
        }
        // Branching off YAML logic into separate test case testWriteDepthOffLimitYaml since it behaves differently
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        builder.startArray();  
            }  
        SimpleStruct structA = new SimpleStruct(1, 0.1, "aaa");  
        assertThat(readList("{\"foo\": [{\"bar\":1},{\"baz\":2},{\"qux\":3}]}"), hasSize(3));
    private static final Map<XContentType, Supplier<String>> FIELD_NAME_OFF_LIMIT_GENERATORS = Map.of(
            builder.startObject();  
        final XContentType xContentType = randomFrom(XContentType.values());
                    assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());  
        String[] nonBooleans = { "truthy", "nope", "yep", "often", "None", "NOTICE", "trUe", "fAlse", "TruE", "y", "Y", "n", "N" };
        // value or object should throw an exception
            try {
        CheckedSupplier<Integer, IOException> fieldGenerator = randomFrom(() -> {
import java.util.HashMap;
                builder.field(field, value);
            assertThat(exception, hasMessage(containsString("s doesn't support values of type: VALUE_NUMBER")));
/*
            tokens += generateRandomValue(builder, level + 1);  
            assertFalse(parser.booleanValue());  
    );
            .value(1)
            XContentParser subParser = new XContentSubParser(parser);
     * <p>
            assertEquals("some_array", parser.currentName());
                assertEquals(field, parser.currentName());
                assertTrue("Expected '" + value + "' to be a boolean value", parser.isBooleanValue());  
            XContentParser.Token token = parser.nextToken();  
            assertNull(parser.nextToken());
            assertThat(parser.currentName(), equalTo("foo"));  
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken()); // {  
                case JSON:
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken()); // last field  
        }  
            }  
                    // Simulate incomplete parsing
        () -> randomAlphaOfLengthBetween(1, JsonXContent.DEFAULT_MAX_STRING_LEN),  
        // Calling XContentParser.list() or listOrderedMap() to read a simple
        Map<String, Object> properties = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
            } else {
            assertEquals(XContentParser.Token.END_ARRAY, parser.currentToken());  
        try (XContentBuilder builder = XContentBuilder.builder(XContentType.YAML.xContent())) {
            for (int depth = 0; depth < maxDepth; ++depth) {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"foo\": " + falsy + ", \"bar\": " + truthy + "}")) {  
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
            assertThat(parser.currentName(), equalTo("bar"));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {  
        () -> YamlXContent.DEFAULT_MAX_DEPTH + 1
     * Generates a random object {"first_field": "foo", "marked_field": {...random...}, "last_field": "bar}
                parser.nextToken();
            }  
                builder.field(field, value);  
            .startArray()
            assertEquals(Collections.emptyList(), parser.list());
    }
    }
                builder.field(field, value);
            // The behavior here is very interesting: the generator does write the new object tag (changing the internal state)  
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
import org.opensearch.core.xcontent.XContentSubParser;
        String truthy = randomFrom("\"true\"", "true");
        }  
        builder.startArray();
            assertThat(actualMap.values(), contains(structC, structA, structB));  
                for (int i = 0; i < tokensToSkip; i++) {
                assertThrows(StreamConstraintsException.class, () -> parser.nextToken());
                for (int depth = 0; depth < maxDepth; ++depth) {  
        assertReadListThrowsException("{\"foo\": 1, \"bar\": 2}");
        f2.put("properties", properties);
                () -> parser.map(HashMap::new, SimpleStruct::fromXContent)
        () -> randomAlphaOfLengthBetween(1, YamlXContent.DEFAULT_MAX_NAME_LEN)
        int tokens = 2;
        XContentType.YAML,  
                XContentParser.Token token = parser.nextToken();
            if (random().nextBoolean()) {
        () -> randomAlphaOfLengthBetween(1, JsonXContent.DEFAULT_MAX_NAME_LEN),
 */
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
            return 1;
            XContentParser subParser = new XContentSubParser(parser);
        assertReadListThrowsException("{\"foo\": \"bar\"}");  
    public void testReadList() throws IOException {  
                assertFalse(subParser.isClosed());
        XContentBuilder builder = XContentFactory.jsonBuilder();
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                }
                case SMILE:
        builder.endArray();  
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            assertThat(parser.currentName(), equalTo("foo"));  
            }  
                assertFalse("Expected '" + value + "' to NOT be a boolean value", parser.isBooleanValue());  
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
            token = parser.nextToken();  
        }
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                builder.field(field + depth);  
            readList(source);
        final String value = randomAlphaOfLengthBetween(1, 5);
            InputStream in = new GZIPInputStream(
    public void testSimpleList() throws IOException {  
        try (  
        /* YAML parser limitation */  
        Map<String, Object> sub1 = new HashMap<>();
import org.opensearch.common.xcontent.cbor.CborXContent;
            assertThat(e, instanceOf(XContentParseException.class));
import java.util.Arrays;
            }
            + "\"a\": { \"i\": 1, \"d\": 0.1, \"s\": \"aaa\" }, "
        assertThat(map.get("kbar"), equalTo("vbar"));
        () -> JsonXContent.DEFAULT_MAX_DEPTH + 1,
import static org.hamcrest.Matchers.equalTo;  
            // Verify that map's iteration order is the same as the order in which fields appear in JSON.
        final String field = randomAlphaOfLengthBetween(1, 5);  
    public void testEmptyList() throws IOException {  
        Map<String, Object> doc = new HashMap<>();  
            }
/*  
                    // Simulate incomplete parsing  
                builder.field(field + depth);  
            try (XContentParser parser = createParser(xContentType.xContent(), in)) {
    }
        }
        });
        String content = builder.toString();
    }  
                    assertThrows(StreamConstraintsException.class, () -> parser.nextToken());  
            } finally {
    );
        assertThat(readList("{\"foo\": [{},{},{},{}]}"), hasSize(4));  
            .endArray()
    }
    }  
                    break;
        XContentType.SMILE,  
                number = parser.numberValue();
 * under the License.  
            tokens += generateRandomValue(builder, level + 1);
            .endArray()
                builder.field(field + depth);
            assertThrows(StreamConstraintsException.class, () -> builder.startObject());
            if (randomBoolean()) {
                assertEquals("field", parser.currentName());
 * specific language governing permissions and limitations
        final Float value = randomFloat();
                case YAML:  
            // YAML parser is having really hard time recovering from StreamConstraintsException, the internal
        String content = "{"  
        () -> randomIntBetween(1, YamlXContent.DEFAULT_MAX_DEPTH)
import java.io.InputStream;
            }  
                if (xContentType != XContentType.YAML) {
public class XContentParserTests extends OpenSearchTestCase {  
                builder.field(field).value(value);
        }
        // Leave room for YAML syntax and allow up to two UTF-16 code units per Unicode code point.
        XContentType.YAML,
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {  
            assertThat(token, in(Arrays.asList(XContentParser.Token.VALUE_STRING, XContentParser.Token.VALUE_NUMBER)));
        numberOfTokens = generateRandomObjectForMarking(builder);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
            // Verify map contents, ignore the iteration order.  
import java.util.Collections;  
        // Values that should NOT be treated as booleans  
        map = readMapStrings("{\"foo\": {}}");
        // YAML 1.1 boolean true values per SnakeYAML's Resolver.BOOL regex  
            .startObject()
            .startArray()
        }
                builder.field(field).value(value);
            } else {  
        }
            + "\"b\": { \"i\": 2, \"d\": 0.2, \"s\": \"bbb\" }"
            assertEquals(value, number.floatValue(), 0.0f);
        for (int i = 0; i < numberOfElements; i++) {
            token = parser.nextToken();
            if (randomBoolean()) {
        () -> randomIntBetween(1, JsonXContent.DEFAULT_MAX_DEPTH),
            .field("foo", "bar")
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {  
                assertEquals(value, parser.text());
        XContentBuilder builder = XContentFactory.jsonBuilder()  
        }, () -> {
            } else {  
            builder.endObject();
            assertThrows(StreamConstraintsException.class, () -> builder.startObject());
 * The OpenSearch Contributors require contributions made to  
        () -> randomAlphaOfLengthBetween(1, SmileXContent.DEFAULT_MAX_NAME_LEN),
            .startArray()
import java.io.IOException;  
        XContentType.SMILE,
                case CBOR:
                }
            if (token.equals(XContentParser.Token.VALUE_STRING)) {  
        int numberOfArrayElements = randomInt(10);
    public void testReadDepthOffLimit() throws IOException {  
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
    private static int generateRandomArray(XContentBuilder builder, int level) throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
        () -> CborXContent.DEFAULT_MAX_DEPTH + 1,  
        assertThat(readList("{\"foo\": [1]}"), contains(1));
                builder.value(0);
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken()); // first field
        // YAML 1.1 boolean false values per SnakeYAML's Resolver.BOOL regex
            token = parser.nextToken();
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
        builder.endObject();
import static org.hamcrest.Matchers.containsString;
    private <T> List<T> readList(String source) throws IOException {  
        SimpleStruct structC = new SimpleStruct(3, 0.3, "ccc");
    public static int generateRandomObject(XContentBuilder builder, int level) throws IOException {  
            assertThat(actualMap, equalTo(expectedMap));
                return 1;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
        }
        String truthy = randomFrom("\"on\"", "\"yes\"", "\"1\"", "1");  
        XContentType.CBOR,
                return generateRandomObject(builder, level + 1);
            assertThat(e.getMessage(), containsString("Failed to parse list"));
        builder.startObject().field("first_field", "foo").field("marked_field");  
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        SimpleStruct structB = new SimpleStruct(2, 0.2, "bbb");  
        i.put("i", expected);
            }  
            + "}";
        for (String value : nonBooleans) {
                } else {
        XContentType.JSON,  
import org.opensearch.core.xcontent.XContentBuilder;
                    throw new AssertionError("unexpected x-content type [" + xContentType + "]");
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken()); // array field
            String yaml = "---\nfield: " + value + "\n";  
            assertNull(parser.nextToken());
    }
            return 1;
                assertNull(parser.nextToken());  
            assertThat(actualMap.values(), containsInAnyOrder(structA, structB, structC));
        generateRandomObjectForMarking(builder);
import static org.junit.Assume.assumeThat;  
        XContentBuilder builder = XContentFactory.jsonBuilder()
        final String field = FIELD_NAME_GENERATORS.get(xContentType).get();  
 * this file be licensed under the Apache-2.0 license or a
        XContentType.YAML,  
                }
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));  
    public void testFloat() throws IOException {  
        }  
            final String text;  
            assertEquals(Arrays.asList(singletonMap("foo", "bar"), emptyMap()), parser.list());
            .value(1)
                for (int depth = 0; depth < maxDepth; ++depth) {  
            builder.value(randomInt());  
            assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken()); // [  
    public void testNestedMapInList() throws IOException {
    private static int generateRandomValue(XContentBuilder builder, int level) throws IOException {  
            );  
                if (randomBoolean()) {
            assertEquals("The sub parser has to be created on the start of an object or array", exception.getMessage());
    public void testFieldName() throws IOException {  
        assertThat(readList("{\"foo\": [1,2]}"), contains(1, 2));
                assertTrue(subParser.isClosed());
            final Number number;  
        final String value = OFF_LIMIT_GENERATORS.get(xContentType).get();
            }
            assertEquals("array", parser.currentName());
                if (randomBoolean()) {
        builder.field("last_field", "bar").endObject();
        XContentBuilder builder = XContentFactory.jsonBuilder();  
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
    public void testGenericMapOrdered() throws IOException {  
    }
                    assertNotNull(subParser.nextToken());  
                // sometimes read the start array token, sometimes not
    }  
        }
import static java.util.Collections.singletonMap;
        expectedMap.put("a", structA);  
    public void testMap() throws IOException {  
    }  
 */  
            }  
            String yaml = "---\nfield: " + value + "\n";
import static org.junit.internal.matchers.ThrowableMessageMatcher.hasMessage;
        XContentType.SMILE,
    }
    }
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
        final String field = FIELD_NAME_OFF_LIMIT_GENERATORS.get(xContentType).get();
                }  
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
            if (random().nextBoolean()) {  
            } else {
            + "\"b\": { \"i\": 2, \"d\": 0.2, \"s\": \"bbb\" }"  
                builder.field(field).value(value);
        final String field = randomAlphaOfLengthBetween(1, 5);  
 * the Apache License, Version 2.0 (the "License"); you may
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"foo\": " + falsy + ", \"bar\": " + truthy + "}")) {
    @SuppressWarnings("unchecked")
        return tokens;  
        () -> randomAlphaOfLengthBetween(1, SmileXContent.DEFAULT_MAX_STRING_LEN),
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
            assertFalse(parser.isBooleanValue());
    public void testWriteDepthOffLimit() throws IOException {
                assertEquals(field, parser.currentName());  
        expectedMap.put("a", structA);
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));  
            assertEquals("first_field", parser.currentName());
                    assertNotNull(subParser.nextToken());  
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            assertThat(actualMap, equalTo(expectedMap));  
            for (int depth = 0; depth < maxDepth; ++depth) {
 * this work for additional information regarding copyright
}  
        expectedMap.put("b", structB);
        }  
        }  
        () -> randomAlphaOfLengthBetween(1, CborXContent.DEFAULT_MAX_STRING_LEN),
import java.util.List;  
            try (XContentParser subParser = new XContentSubParser(parser)) {  
        XContentBuilder builder = XContentFactory.jsonBuilder();  
        final String field = randomAlphaOfLengthBetween(1, 5);
            assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken()); // foo  
    }
        }  
                builder.field(field, value);  
                assertEquals(XContentParser.Token.VALUE_NUMBER, parser.nextToken());
        Map<String, Object> expected = new HashMap<>();
                assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
            } else {
        () -> randomAlphaOfLength(JsonXContent.DEFAULT_MAX_STRING_LEN + 1),
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
            1,  
        XContentBuilder builder = XContentFactory.jsonBuilder()
    );  
            for (int depth = 0; depth < maxDepth; ++depth) {
            XContentParser.Token token = parser.nextToken();
        assertThat(map.size(), equalTo(0));  
        String falsy = randomFrom("\"off\"", "\"no\"", "\"0\"", "0");
            builder.endObject();
import java.util.function.Supplier;  
        expectedMap.put("b", structB);
            } finally {
    public void testYamlBooleanParsing() throws IOException {
        }  
        () -> randomIntBetween(1, CborXContent.DEFAULT_MAX_DEPTH),
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
    private static final Map<XContentType, Supplier<String>> OFF_LIMIT_GENERATORS = Map.of(
            try (XContentParser parser = createParser(YamlXContent.yamlXContent, yaml)) {  
            }
            builder.endObject();
        () -> SmileXContent.DEFAULT_MAX_DEPTH + 1,
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            + "\"c\": { \"i\": 3, \"d\": 0.3, \"s\": \"ccc\" }, "
                if (xContentType != XContentType.YAML) {
            } else {
                    assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            return parser.mapStrings();  
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            assertEquals("marked_field", parser.currentName());
            .endObject();
        }
        final String value = randomAlphaOfLengthBetween(1, 5);
        () -> randomAlphaOfLength(JsonXContent.DEFAULT_MAX_NAME_LEN + 1),  
        }
import java.util.zip.GZIPInputStream;
    }  
 * compatible open source license.
            assertThat(text, hasLength(value.length()));
            try (XContentParser parser = createParser(YamlXContent.yamlXContent, yaml)) {
                builder.startObject();
                getDataInputStream("depth-off-limit." + xContentType.name().toLowerCase(Locale.US) + ".gz")
        String[] truthyValues = { "true", "True", "TRUE", "yes", "Yes", "YES", "on", "On", "ON" };
        return tokens;
            assertNull(parser.nextToken());
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
        assertThat(map.size(), equalTo(2));
            }  
            }
        String content = builder.toString();  
                assertEquals("field", parser.currentName());  
                builder.field(field, value);  
            )  
    public void testGenericMap_Failure_MapContainingUnparsableValue() throws IOException {
    public void testStringOffLimit() throws IOException {
        final String value = randomAlphaOfLengthBetween(1, 5);
                int tokensToSkip = randomInt(numberOfTokens - 1);  
            builder.startObject();
            builder.endObject();  
