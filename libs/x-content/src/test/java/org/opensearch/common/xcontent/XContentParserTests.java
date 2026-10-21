            builder.endObject();
        /* YAML parser limitation */
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
            XContentParser.Token token = parser.nextToken();
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
    public void testReadList() throws IOException {
        () -> randomAlphaOfLengthBetween(1, JsonXContent.DEFAULT_MAX_NAME_LEN),
        // using precreated test files instead.
     */
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            assertThat(text, hasLength(value.length()));
        numberOfTokens = generateRandomObjectForMarking(builder);
                assertEquals("Expected VALUE_BOOLEAN token for '" + value + "'", XContentParser.Token.VALUE_BOOLEAN, token);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"foo\": " + falsy + ", \"bar\": " + truthy + "}")) {
    public void testWriteDepthOffLimit() throws IOException {
    private static final Map<XContentType, Supplier<Integer>> DEPTH_GENERATORS = Map.of(
    }
            assertTrue(parser.isBooleanValue());
            }
import org.opensearch.core.xcontent.XContentSubParser;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        () -> randomAlphaOfLength(SmileXContent.DEFAULT_MAX_NAME_LEN + 1),
            if (token.equals(XContentParser.Token.VALUE_STRING)) {
            token = parser.nextToken();
        assertReadListThrowsException("{\"foo\": \"bar\"}");
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
    }
        final XContentType xContentType = randomFrom(XContentType.values());
    }
        assertThat(readList("{\"foo\": [{},{},{},{}]}"), hasSize(4));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
            assertEquals(value, number.floatValue(), 0.0f);
                return 1;
import org.opensearch.tools.jackson.core.JsonParseException;
        () -> randomIntBetween(1, CborXContent.DEFAULT_MAX_DEPTH),
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
import java.io.InputStream;
                assertFalse("Expected '" + value + "' to parse as false", parser.booleanValue());
        for (String value : nonBooleans) {
        assertThat(readList("{\"foo\": [1, 2, 3], \"bar\": 4}"), contains(1, 2, 3));
            assertThat(parser.currentName(), equalTo("foo"));
                }
                    // And sometimes skipping children
            .startArray("some_array")
        Map<String, String> map = readMapStrings("{\"foo\": {\"kbar\":\"vbar\"}}");
            for (int depth = 0; depth < maxDepth; ++depth) {
                XContentParseException.class,
        final Float value = randomFloat();
            }
            .startObject()
        XContentType.YAML,
        CheckedSupplier<Integer, IOException> fieldGenerator = randomFrom(() -> {
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        Map<String, Object> properties = new HashMap<>();
                    assertThat(number, instanceOf(Double.class));
            switch (xContentType) {
import static org.hamcrest.CoreMatchers.not;
        map = readMapStrings("{\"foo\": {\"kbar\":\"vbar\", \"kbaz\":\"vbaz\"}}");
                    // Simulate incomplete parsing
                    // Simulate incomplete parsing
                XContentParser.Token token = parser.nextToken();
            assertThat(parser.currentName(), equalTo("bar"));
            }
    }
            } else {
 * You may obtain a copy of the License at
import static org.hamcrest.Matchers.nullValue;
            } else {
        assertThat(map.get("kbar"), equalTo("vbar"));
                    assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            assertEquals(Arrays.asList(singletonMap("foo", "bar"), emptyMap()), parser.list());
        assertThat(readList("{\"foo\": [{\"bar\":1},{\"baz\":2},{\"qux\":3}]}"), hasSize(3));
            if (random().nextBoolean()) {
            try (XContentParser subParser = new XContentSubParser(parser)) {
                case YAML:
        assertThat(map.size(), equalTo(2));
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
        return fieldGenerator.get();
    public void testGenericMap_Failure_MapContainingUnparsableValue() throws IOException {
        @SuppressWarnings("unchecked")
            }
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
        }, () -> {
        final String value = randomAlphaOfLengthBetween(1, 5);
    private static int generateRandomArray(XContentBuilder builder, int level) throws IOException {
                }
                builder.field(field).value(value);
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
    public void testCreateRootSubParser() throws IOException {
        }
                getDataInputStream("depth-off-limit." + xContentType.name().toLowerCase(Locale.US) + ".gz")
                case SMILE:
                builder.endObject();
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
                // don't need to go too deep
    public void testEmptyList() throws IOException {
                    assertNotNull(subParser.nextToken());
import org.opensearch.common.xcontent.yaml.YamlXContent;
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        int tokens = 2;
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
            assertEquals(Arrays.asList(Collections.<Integer>emptyList(), Arrays.asList(1, 3), Arrays.asList(2)), parser.list());
        generateRandomObjectForMarking(builder);
            }
            assertEquals("array", parser.currentName());
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
import java.util.List;
            } else {
        final String field = randomAlphaOfLengthBetween(1, 5);
            token = parser.nextToken();
        assertThat(readList("{\"foo\": [\"bar\"]}"), contains("bar"));
import org.opensearch.common.CheckedSupplier;
    }
        builder.field("array");
            tokens += generateRandomValue(builder, level + 1);
                builder.field(field, value);
        }, () -> {
            assertEquals("first_field", parser.currentName());
                    // And sometimes skipping children
        f1.put("analyzer", "english");
import org.opensearch.test.OpenSearchTestCase;
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        XContentType.CBOR,
                int tokensToSkip = randomInt(numberOfTokens);
    public void testString() throws IOException {
    }
import static org.hamcrest.Matchers.hasLength;
    );
                number = parser.numberValue();
        final XContentType xContentType = randomFrom(XContentType.values());
 * specific language governing permissions and limitations
                assertEquals("field", parser.currentName());
        return numberOfTokens;
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
        String falsy = randomFrom("\"off\"", "\"no\"", "\"0\"", "0");
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            token = parser.nextToken();
            .endObject();
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
}
    }
import static org.hamcrest.Matchers.equalTo;
            builder.endObject();
    }
            }
        return tokens;
                assertEquals(field, parser.currentName());
        assertThat(map.get("kbar"), equalTo("vbar"));
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
                assertNull(parser.nextToken());
        XContentType.JSON,
            }
    public void testWriteDepthOffLimitYaml() throws IOException {
            + "\"c\": { \"i\": 3, \"d\": 0.3, \"s\": \"ccc\" }, "
        expectedMap.put("c", structC);
            assertEquals("some_array", parser.currentName());
                builder.field(field + depth);
            assertThat(token, in(Arrays.asList(XContentParser.Token.VALUE_STRING, XContentParser.Token.VALUE_BOOLEAN)));
            } else {
        final int maxDepth = OFF_LIMIT_DEPTH_GENERATORS.get(xContentType).get() - 1;
            return (List<T>) (randomBoolean() ? parser.listOrderedMap() : parser.list());
        final String field = FIELD_NAME_OFF_LIMIT_GENERATORS.get(xContentType).get();
        assertReadListThrowsException("{\"foo\": {\"bar\":\"baz\"}}");
                // sometimes read the start array token, sometimes not
            .endArray()
import static java.util.Collections.singletonMap;
import java.util.LinkedHashMap;
        }
            String yaml = "---\nfield: " + value + "\n";
            assertFalse(parser.isBooleanValue());
        assertThat(readList("{\"foo\": [null]}"), contains(nullValue()));
        }
            token = parser.nextToken();
            + "}";
            try (XContentParser parser = createParser(xContentType.xContent(), in)) {
import org.opensearch.core.xcontent.XContentParseException;
import org.opensearch.tools.jackson.core.StreamConstraintsException;
        () -> randomRealisticUnicodeOfCodepointLength(YamlXContent.DEFAULT_CODEPOINT_LIMIT + 1)
            XContentParser.Token token = parser.nextToken();
    private static int generateRandomObjectForMarking(XContentBuilder builder) throws IOException {
                assertTrue("Expected '" + value + "' to parse as true", parser.booleanValue());
            token = parser.nextToken();
        SimpleStruct structC = new SimpleStruct(3, 0.3, "ccc");
            } else {
                    break;
                int tokensToSkip = randomInt(numberOfTokens + 3);
    }
                () -> parser.map(HashMap::new, SimpleStruct::fromXContent)
        }
            token = parser.nextToken();
        try {
    }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {
/*
                assertTrue(subParser.isClosed());
            .endArray()
            }
            if (randomBoolean()) {
                    throw new AssertionError("unexpected x-content type [" + xContentType + "]");
                assertEquals("field", parser.currentName());
                builder.field(field).value(value);
    );
    public void testStringOffLimit() throws IOException {
        final String field = randomAlphaOfLengthBetween(1, 5);
            assertEquals("The sub parser has to be created on the start of an object or array", exception.getMessage());
                    subParser.skipChildren();
        }
            assertNull(parser.nextToken());
            // Verify that map's iteration order is the same as the order in which fields appear in JSON.
        f2.put("properties", properties);
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
            assertEquals("first_field", parser.currentName());
            builder.field(randomAlphaOfLength(10) + "_" + i);
        SimpleStruct structC = new SimpleStruct(3, 0.3, "ccc");
            assertThat(parser.currentName(), equalTo("foo"));
            for (int depth = 0; depth < maxDepth; ++depth) {
                if (xContentType != XContentType.YAML) {
    public static int generateRandomObject(XContentBuilder builder, int level) throws IOException {
            builder.endObject();
        XContentType.SMILE,
                }
                assertEquals(field, parser.currentName());
        XContentType.YAML,
    public void testReadBooleans() throws IOException {
            String yaml = "---\nfield: " + value + "\n";
        expectedMap.put("b", structB);
    }
        final XContentType xContentType = randomFrom(XContentType.values());
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
    /**
    }
        }
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
            assertTrue(parser.isBooleanValue());
                return generateRandomArray(builder, level);
                return 1;
                }
    public void testMap() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
                // sometimes read the start array token, sometimes not
        int numberOfTokens = generateRandomObject(builder, 0);
                builder.endObject();
    }
                    subParser.skipChildren();
import static org.junit.Assume.assumeThat;
                    assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            } finally {
    }
public class XContentParserTests extends OpenSearchTestCase {
        properties.put("sub1", sub1);
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            Math.min(YamlXContent.DEFAULT_CODEPOINT_LIMIT / 2, YamlXContent.DEFAULT_MAX_STRING_LEN / 2)
        () -> randomAlphaOfLengthBetween(1, JsonXContent.DEFAULT_MAX_STRING_LEN),
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
        Map<String, Object> sub1 = new HashMap<>();
            assertThat(e, instanceOf(XContentParseException.class));
        map = readMapStrings("{\"foo\": {}}");
        int numberOfElements = randomInt(5);
        XContentType.SMILE,
        }
        SimpleStruct structA = new SimpleStruct(1, 0.1, "aaa");
        () -> JsonXContent.DEFAULT_MAX_DEPTH + 1,
            // The behavior here is very interesting: the generator does write the new object tag (changing the internal state)
        String content = builder.toString();
            builder.startObject();
        expectedMap.put("b", structB);
    }
                assertTrue("Expected '" + value + "' to be a boolean value", parser.isBooleanValue());
    @SuppressWarnings("unchecked")
                builder.value(0);
 * this file be licensed under the Apache-2.0 license or a
    }
            }
    );
            assertThat(e.getMessage(), containsString("Failed to parse list"));
            IllegalStateException exception = expectThrows(IllegalStateException.class, () -> new XContentSubParser(parser));
        expectedMap.put("c", structC);
        assertThat(map.size(), equalTo(0));
                assertFalse(subParser.isClosed());
import java.io.IOException;
        int numberOfArrayElements = randomInt(10);
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            assertEquals(Collections.emptyList(), parser.list());
            readList(source);
        String[] truthyValues = { "true", "True", "TRUE", "yes", "Yes", "YES", "on", "On", "ON" };
            }
            if (randomBoolean()) {
                parser.nextToken();
        });
        expectedMap.put("a", structA);
        expected.put("_doc", doc);
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
            }
            .startArray()
        }
package org.opensearch.common.xcontent;
    }
                assertEquals(field, parser.currentName());
                for (int i = 0; i < tokensToSkip; i++) {
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
        }
            .startObject()
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken()); // first field
    public void testNestedList() throws IOException {
                }
                builder.endObject();
 * Licensed to Elasticsearch under one or more contributor
            InputStream in = new GZIPInputStream(
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
import org.opensearch.core.common.bytes.BytesReference;
            assertNull(parser.nextToken());
            assertEquals("some_array", parser.currentName());
    public void testSubParserObject() throws IOException {
        }, () -> {
        String content = "{"
        }
            }
        builder.startObject().field("first_field", "foo").field("marked_field");
    }
            // BUT throws the exception after the fact, this is why we have to close the object at the end.
    public void testGenericMap() throws IOException {
 * KIND, either express or implied.  See the License for the
            .endObject();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
        try (
        Map<String, Object> i = new HashMap<>();
        String[] nonBooleans = { "truthy", "nope", "yep", "often", "None", "NOTICE", "trUe", "fAlse", "TruE", "y", "Y", "n", "N" };
            String yaml = "---\nfield: " + value + "\n";
            }
            .endArray()
        final XContentType xContentType = randomFrom(XContentType.values());
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        () -> randomAlphaOfLength(SmileXContent.DEFAULT_MAX_STRING_LEN + 1),
    public void testReadBooleansFailsForLenientBooleans() throws IOException {
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
    }
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
            .endObject()
        // Calling XContentParser.list() or listOrderedMap() to read a simple
        assumeThat(xContentType, not(XContentType.YAML));
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
    public void testReadListThrowsException() throws IOException {
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        String[] falsyValues = { "false", "False", "FALSE", "no", "No", "NO", "off", "Off", "OFF" };
                if (xContentType != XContentType.YAML) {
        XContentType.SMILE,
            .endObject()
            }
                    assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                builder.field(field, value);
        builder.field("last_field", "bar").endObject();
            .value(1)
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken()); // marked field
            if (randomBoolean()) {
                assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
            }
            builder.startObject();
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken()); // {
                return generateRandomObject(builder, level + 1);
                    assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        }
            assertNull(parser.nextToken());
        XContentType.JSON,
        XContentBuilder builder = XContentFactory.jsonBuilder();
        }
            builder.value(randomAlphaOfLength(10));
        XContentBuilder builder = XContentFactory.jsonBuilder()
            1,
        }
            + "\"a\": { \"i\": 1, \"d\": 0.1, \"s\": \"aaa\" }, "
        Map<String, Object> doc = new HashMap<>();
                assertEquals("Expected VALUE_BOOLEAN token for '" + value + "'", XContentParser.Token.VALUE_BOOLEAN, token);
                builder.field(field, value);
                int tokensToSkip = randomInt(numberOfTokens - 1);
            }
        } catch (Exception e) {
        int numberOfTokens = generateRandomObjectForMarking(builder);
            assertThat(actualMap.values(), contains(structC, structA, structB));
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            + "\"c\": { \"i\": 3, \"d\": 0.3, \"s\": \"ccc\" }, "
            + "\"b\": { \"i\": 2, \"d\": 0.2, \"s\": \"bbb\" }"
        () -> randomIntBetween(1, SmileXContent.DEFAULT_MAX_DEPTH),
            final int maxDepth = OFF_LIMIT_DEPTH_GENERATORS.get(xContentType).get() - 1;
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
            } else {
        String content = "{"
        }
            assertThat(parser.currentName(), equalTo("foo"));
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        builder.endObject();
        builder.startObject();
                subParser.close();
        () -> randomAlphaOfLengthBetween(1, CborXContent.DEFAULT_MAX_NAME_LEN),
        XContentType.YAML,
                assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
            for (int depth = 0; depth < maxDepth; ++depth) {
            XContentParser subParser = new XContentSubParser(parser);
            if (random().nextBoolean()) {
    }
        XContentType.SMILE,
            assertThat(map, equalTo(i));
                }
        i.put("i", expected);
            .startObject()
                builder.startObject();
                builder.field(field).value(value);
    }
        // YAML 1.1 boolean true values per SnakeYAML's Resolver.BOOL regex
    public void testFieldName() throws IOException {
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
import org.opensearch.common.xcontent.smile.SmileXContent;
    private static final Map<XContentType, Supplier<String>> FIELD_NAME_OFF_LIMIT_GENERATORS = Map.of(
            }
import static org.hamcrest.Matchers.contains;
        final String value = randomAlphaOfLengthBetween(1, 5);
        }
        builder.startArray();
        final XContentType xContentType = randomFrom(XContentType.values());
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            try (XContentParser parser = createParser(YamlXContent.yamlXContent, yaml)) {
 */
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
    }
    }
        Map<String, Object> f1 = new HashMap<>();
        String content = builder.toString();
            }
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken()); // first field
                builder.field(field, value);
                for (int depth = 0; depth < maxDepth; ++depth) {
            + "}";
                for (int depth = 0; depth < maxDepth; ++depth) {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            assertEquals("marked_field", parser.currentName());
import java.util.Locale;
            }
        f2.put("type", "object");
            builder.startObject();
        doc.put("f1", f1);
        }
            }
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
        XContentType.JSON,
            }
                assertTrue("Expected '" + value + "' to be a boolean value", parser.isBooleanValue());
            + "\"f2\": {\"type\": \"object\", \"properties\": {\"sub1\": {\"type\": \"keyword\", \"foo\": 17}}}}}}";
            }
        () -> randomAlphaOfLengthBetween(1, CborXContent.DEFAULT_MAX_STRING_LEN),
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
    private static final Map<XContentType, Supplier<String>> GENERATORS = Map.of(
 * SPDX-License-Identifier: Apache-2.0
        () -> randomAlphaOfLengthBetween(1, SmileXContent.DEFAULT_MAX_NAME_LEN),
                builder.field(field + depth);
            .startArray()
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startArray("some_array").endArray().endObject();
        final XContentType xContentType = randomFrom(XContentType.values());
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            .startArray()
        assertThat(readList("{\"foo\": [1]}"), contains(1));
        assertThat(readList("{\"foo\": []}"), hasSize(0));
            numberOfTokens += generateRandomObject(builder, 0);
                default:
                }
            // state seems to be completely messed up and the closing cleanly seems to be not feasible.
                assertFalse("Expected '" + value + "' to NOT be a boolean value", parser.isBooleanValue());
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        final String field = randomAlphaOfLengthBetween(1, 5);
        }
            token = parser.nextToken();
            Map<String, SimpleStruct> actualMap = parser.map(HashMap::new, SimpleStruct::fromXContent);
                    assertNotNull(subParser.nextToken());
                builder.field(field, value);
                expectThrows(JsonParseException.class, parser::booleanValue);
            for (int depth = 0; depth < maxDepth; ++depth) {
import org.opensearch.core.xcontent.XContentBuilder;
            }
        XContentType.JSON,
 * this work for additional information regarding copyright
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
        assertThat(map.get("kbaz"), equalTo("vbaz"));
 * not use this file except in compliance with the License.
        XContentType.CBOR,
            }
            if (random().nextBoolean()) {
            }
            assertFalse(parser.isBooleanValue());
        builder.startArray();
                assertFalse(subParser.isClosed());
        () -> randomIntBetween(1, YamlXContent.DEFAULT_MAX_DEPTH)
        () -> randomRealisticUnicodeOfCodepointLengthBetween(
    }
            if (randomBoolean()) {
            + "\"a\": { \"i\": 1, \"d\": 0.1, \"s\": \"aaa\" }, "
    public void testSimpleList() throws IOException {
            final String text;
    private void assertReadListThrowsException(String source) {
            fail("should have thrown a parse exception");
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
        assertThat(readList("{\"foo\": [1,2]}"), contains(1, 2));
        )
    }
                assertEquals("Expected text() to preserve original value", value, parser.text());
 */
    }
        }
        () -> SmileXContent.DEFAULT_MAX_DEPTH + 1,
                assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
            Map<String, Object> map = parser.map();
            } else {
                    assertThrows(StreamConstraintsException.class, () -> parser.text());
                assertEquals(XContentParser.Token.VALUE_NUMBER, parser.nextToken());
                } else {
        // Values that should NOT be treated as booleans
        XContentType.SMILE,
    public void testSubParserArray() throws IOException {
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
                    // Simulate incomplete parsing
import org.opensearch.core.xcontent.XContentParser;
            return 1;
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
import java.util.Map;
            builder.endObject();
            if (token.equals(XContentParser.Token.VALUE_STRING)) {
        }
        int arraySize = randomInt(3);
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
import java.util.HashMap;
import org.opensearch.common.xcontent.json.JsonXContent;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
            }
 *
        }
            assertThat(exception, hasMessage(containsString("s doesn't support values of type: VALUE_NUMBER")));
            assertThat(token, in(Arrays.asList(XContentParser.Token.VALUE_STRING, XContentParser.Token.VALUE_NUMBER)));
        XContentType.YAML,
            // The behavior here is very interesting: the generator does write the new object tag (changing the internal state)
            .startArray("some_array")
                assertEquals(field, parser.currentName());
    }
 * Modifications Copyright OpenSearch Contributors. See
            assertThrows(StreamConstraintsException.class, () -> builder.startObject());
        XContentBuilder builder = XContentFactory.jsonBuilder()
            assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
                XContentParser.Token token = parser.nextToken();
        }, () -> {
            .value(2)
        }
                    assertThrows(StreamConstraintsException.class, () -> parser.nextToken());
            return parser.mapStrings();
            assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken()); // [
        sub1.put("type", "keyword");
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
        int tokens = 2;
        }
        f1.put("type", "text");
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            assertThrows(StreamConstraintsException.class, () -> builder.startObject());
            assertThat(actualMap.values(), containsInAnyOrder(structA, structB, structC));
            if (randomBoolean()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        () -> CborXContent.DEFAULT_MAX_DEPTH + 1,
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
            // Verify map contents, ignore the iteration order.
            XContentParser.Token token = parser.nextToken();
                expectThrows(IllegalArgumentException.class, parser::booleanValue);
        for (int i = 0; i < numberOfArrayElements; ++i) {
            builder.endObject();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString())) {
            builder.startObject();
        () -> randomAlphaOfLength(CborXContent.DEFAULT_MAX_NAME_LEN + 1),
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
        XContentBuilder builder = XContentFactory.jsonBuilder();
            assertTrue(parser.booleanValue());
            if (xContentType != XContentType.SMILE) {
        }
            assertThat(token, in(Arrays.asList(XContentParser.Token.VALUE_STRING, XContentParser.Token.VALUE_NUMBER)));
        String content = "{"
            if (random().nextBoolean()) {
            builder.value(randomDouble());
        }
            assertThat(parser.currentName(), equalTo("bar"));
        Map<String, Object> f2 = new HashMap<>();
                case JSON:
    }
            .value(3)
            }
        int numberOfTokens;
 *
            }
 * GitHub history for details.
                builder.field(field, value);
        XContentType.JSON,
            } else {
        SimpleStruct structA = new SimpleStruct(1, 0.1, "aaa");
            final Number number;
        () -> randomAlphaOfLength(JsonXContent.DEFAULT_MAX_NAME_LEN + 1),
    }
                }
                expectThrows(IllegalArgumentException.class, parser::booleanValue);
        XContentType.CBOR,
            builder.startObject();
 * The OpenSearch Contributors require contributions made to
        for (String value : truthyValues) {
import org.opensearch.common.xcontent.cbor.CborXContent;
                // sometimes read the start array token, sometimes not
        () -> YamlXContent.DEFAULT_MAX_DEPTH + 1
                assertThrows(StreamConstraintsException.class, () -> parser.nextToken());
            XContentParser.Token token = parser.nextToken();
            assertThat(token, equalTo(XContentParser.Token.FIELD_NAME));
            .value(1)
            token = parser.nextToken();
            token = parser.nextToken();
        final String field = randomAlphaOfLengthBetween(1, 5);
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        }
            // Smile fails with tools.jackson.core.exc.StreamWriteException: Current context not Object but root
import static org.junit.internal.matchers.ThrowableMessageMatcher.hasMessage;
    );
        try (XContentBuilder builder = XContentBuilder.builder(XContentType.YAML.xContent())) {
        // Branching off YAML logic into separate test case testWriteDepthOffLimitYaml since it behaves differently
            if (level < 3) {
            XContentParser subParser = new XContentSubParser(parser);
            assertEquals(Arrays.asList(1, 3, 0), parser.list());
        assertThat(map.size(), equalTo(1));
            assertEquals(XContentParser.Token.END_ARRAY, parser.currentToken());
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {
        String content = builder.toString();
        final String field = FIELD_NAME_GENERATORS.get(xContentType).get();
    public void testCreateSubParserAtAWrongPlace() throws IOException {
            for (int depth = 0; depth < maxDepth; ++depth) {
    public void testGenericMapOrdered() throws IOException {
            if (level < 5) { // don't need to go too deep
                builder.startObject();
import static org.hamcrest.Matchers.hasSize;
                builder.field(field + depth);
    public void testYamlBooleanParsing() throws IOException {
        expectedMap.put("a", structA);
import static org.hamcrest.Matchers.in;
        Map<String, Object> expected = new HashMap<>();
            assertEquals("some_array", parser.currentName());
        Map<String, SimpleStruct> expectedMap = new HashMap<>();
            token = parser.nextToken();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {
                for (int i = 0; i < tokensToSkip; i++) {
    }
     * Returns the number of tokens in the marked field
                subParser.close();
    private static int generateRandomValue(XContentBuilder builder, int level) throws IOException {
            } else {
        builder.endArray();
            Map<String, SimpleStruct> actualMap = parser.map(LinkedHashMap::new, SimpleStruct::fromXContent);
    );
        final String value = randomAlphaOfLengthBetween(1, 5);
        }
        () -> randomAlphaOfLengthBetween(1, SmileXContent.DEFAULT_MAX_STRING_LEN),
                if (randomBoolean()) {
                builder.field(field).value(value);
            return 1;
        final String field = randomAlphaOfLengthBetween(1, 5);
        XContentType.CBOR,
    }
            }
        String truthy = randomFrom("\"on\"", "\"yes\"", "\"1\"", "1");
            final int maxDepth = OFF_LIMIT_DEPTH_GENERATORS.get(XContentType.YAML).get() - 1;
                expectThrows(JsonParseException.class, parser::booleanValue);
import static org.hamcrest.Matchers.instanceOf;
            XContentParser.Token token = parser.nextToken();
            } else {
            .value(0)
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken()); // array field
        // Since parser and generator use the same max depth constraints, we could not generate the content with off limits,
            try {
            }
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                // sometimes read the start array token, sometimes not
                    assertNotNull(subParser.nextToken());
            + "\"b\": { \"i\": 2, \"d\": 0.2, \"s\": \"bbb\" }"
import java.util.function.Supplier;
            } else {
        XContentType.CBOR,
            assertEquals("some_array", parser.currentName());
            .startArray("some_array")
        XContentBuilder builder = XContentFactory.jsonBuilder();
            assertThat(token, in(Arrays.asList(XContentParser.Token.VALUE_STRING, XContentParser.Token.VALUE_BOOLEAN)));
        }
                    assertThat(number, instanceOf(Float.class));
        for (int i = 0; i < numberOfElements; i++) {
        final String value = randomAlphaOfLengthBetween(1, 5);
    private static final Map<XContentType, Supplier<String>> FIELD_NAME_GENERATORS = Map.of(
                assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
        final String field = randomAlphaOfLengthBetween(1, 5);
                }
        // YAML 1.1 boolean false values per SnakeYAML's Resolver.BOOL regex
        sub1.put("foo", 17);
        String source = "{\"i\": {\"_doc\": {\"f1\": {\"type\": \"text\", \"analyzer\": \"english\"}, "
import static org.hamcrest.Matchers.containsString;
        } catch (final IllegalStateException ex) {
        doc.put("f2", f2);
                    assertEquals(field + depth, parser.currentName());
        // Leave room for YAML syntax and allow up to two UTF-16 code units per Unicode code point.
        }
                builder.value(0);
                assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            + "\"b\": { \"i\": 2, \"d\": 0.2, \"s\": 666 }, "
            .value(3)
                    break;
 * the Apache License, Version 2.0 (the "License"); you may
        SimpleStruct structB = new SimpleStruct(2, 0.2, "bbb");
                builder.field(field).value(value);
        assertThat(readList("{\"foo\": [\"bar\",\"baz\"]}"), contains("bar", "baz"));
            assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken()); // foo
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
            // Verify map contents, ignore the iteration order.
                builder.field(field, value);
            // YAML parser is having really hard time recovering from StreamConstraintsException, the internal
            .field("foo", "bar")
            .endObject();
                    assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
                assertEquals("Expected text() to preserve original value", value, parser.text());
        SimpleStruct structB = new SimpleStruct(2, 0.2, "bbb");
            assertThat(actualMap, equalTo(expectedMap));
        XContentType.CBOR,
                assertEquals(XContentParser.Token.VALUE_STRING, parser.nextToken());
    );
        () -> randomIntBetween(1, JsonXContent.DEFAULT_MAX_DEPTH),
                assertEquals(field, parser.currentName());
            tokens += generateRandomValue(builder, level + 1);
            assertNull(parser.nextToken());
    public void testFloat() throws IOException {
            final int maxDepth = DEPTH_GENERATORS.get(xContentType).get() - 1;
        () -> randomAlphaOfLength(YamlXContent.DEFAULT_MAX_NAME_LEN + 1)
        Map<String, SimpleStruct> expectedMap = new HashMap<>();
                builder.field(field).value(value);
                assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
    }
     * Generates a random object {"first_field": "foo", "marked_field": {...random...}, "last_field": "bar}
 * software distributed under the License is distributed on an
     * <p>
            builder.value(randomInt());
        int numberOfTokens = 0;
            assertThat(token, equalTo(XContentParser.Token.START_OBJECT));
/*
            .endArray()
            + "\"c\": { \"i\": 3, \"d\": 0.3, \"s\": \"ccc\" }"
        }
            if (randomBoolean()) {
                assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
    }
        String truthy = randomFrom("\"true\"", "true");
            return 1;
 * Unless required by applicable law or agreed to in writing,
            token = parser.nextToken();
    public void testFieldNameOffLimit() throws IOException {
                    assertThrows(StreamConstraintsException.class, () -> parser.nextToken());
            try (XContentParser parser = createParser(xContentType.xContent(), BytesReference.bytes(builder))) {
                case CBOR:
        for (int i = 0; i < arraySize; i++) {
            .startObject()
                assertNull(parser.nextToken());
            XContentParseException exception = expectThrows(
            assertEquals("last_field", parser.currentName());
                for (int depth = 0; depth < maxDepth; ++depth) {
            }
        String content = builder.toString();
    }
            );
                text = parser.text();
        () -> randomAlphaOfLength(JsonXContent.DEFAULT_MAX_STRING_LEN + 1),
            + "}";
        XContentType.YAML,
    public void testNestedMapInList() throws IOException {
            }
                assertTrue(subParser.isClosed());
import java.util.Collections;
            try (XContentParser parser = createParser(YamlXContent.yamlXContent, yaml)) {
    public void testDepth() throws IOException {
    private static final Map<XContentType, Supplier<Integer>> OFF_LIMIT_DEPTH_GENERATORS = Map.of(
                assertNull(parser.nextToken());
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken()); // last field
        }
            .startObject()
        builder.endObject();
        for (String value : falsyValues) {
        final String value = OFF_LIMIT_GENERATORS.get(xContentType).get();
        }
            assertNull(parser.nextToken());
 *
            assertThat(parser.currentName(), equalTo("foo"));
    private static final Map<XContentType, Supplier<String>> OFF_LIMIT_GENERATORS = Map.of(
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
        XContentType.JSON,
            }
        ) {
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        () -> randomAlphaOfLengthBetween(1, YamlXContent.DEFAULT_MAX_NAME_LEN)
            + "\"a\": { \"i\": 1, \"d\": 0.1, \"s\": \"aaa\" }, "
        final XContentType xContentType = randomFrom(XContentType.values());
                for (int i = 0; i < tokensToSkip; i++) {
        XContentType.YAML,
                assertEquals(value, parser.text());
        }
            )
                assertEquals("field", parser.currentName());
            .endArray()
        builder.endArray();
/*
        final String value = GENERATORS.get(xContentType).get();
            builder.startObject();
            assertThat(actualMap, equalTo(expectedMap));
 * under the License.
        XContentBuilder builder = XContentFactory.jsonBuilder()
        assertReadListThrowsException("{\"foo\": 1, \"bar\": 2}");
            }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"foo\": " + falsy + ", \"bar\": " + truthy + "}")) {
    private <T> List<T> readList(String source) throws IOException {
            }
 * compatible open source license.
            try {
        // value or object should throw an exception
        XContentType.SMILE,
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, content)) {
            builder.endObject();
            .endArray()
                builder.startObject();
    public void testReadMapStrings() throws IOException {
            // BUT throws the exception after the fact, this is why we have to close the object at the end.
                }
 * license agreements. See the NOTICE file distributed with
            assertFalse(parser.booleanValue());
        String falsy = randomFrom("\"false\"", "false");
                    assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
    private Map<String, String> readMapStrings(String source) throws IOException {
            try (XContentParser parser = createParser(YamlXContent.yamlXContent, yaml)) {
            if (randomBoolean()) {
        () -> randomAlphaOfLength(CborXContent.DEFAULT_MAX_STRING_LEN + 1),
                builder.field(field).value(value);
                assertNull(parser.nextToken());
        final XContentType xContentType = randomFrom(XContentType.values());
import static org.hamcrest.Matchers.containsInAnyOrder;
        return tokens;
    public void testReadDepthOffLimit() throws IOException {
            } finally {
        /* YAML parser limitation */
                if (randomBoolean()) {
import static java.util.Collections.emptyMap;
