        if (randomBoolean()) {
        objectParser.declareIntArray(TestStruct::setInt_array_field, new ParseField("int_array_field"));
        objectParser.declareStringArray(TestStruct::setString_array_field, new ParseField("string_array_field"));
        private NamedObject named;
            int testNumber;
        class TestStruct {
        assertWarnings(false, "[foo][1:15] Deprecated field [old_test] used, expected [test] instead");
        );
                {
                ObjectParser.ValueType.STRING
        assertEquals(s.test, "foo");
                new ParseField("test"),
        }
            TestStruct s = objectParser.parse(parser, new TestStruct(), null);
        {
        objectParser.declareObjectArray(StaticTestStruct::setObjectArray, objectParser, new ParseField("object_array"));
        XContentParser parser2 = createParser(JsonXContent.jsonXContent, "{\"int_array\": [1, null, 3]}");
        assertEquals(parse.long_field, 4L);
        int foo;
            }
        objectParser.declareRequiredFieldSet(new String[] { "a", "b" });
        XContentParser parser = createParser(
            b.field("junk", 2);
        private void setB(long value) {
        }
    public void testParseNamedObjectsInOrder() throws IOException {
            public String name;
            assertEquals(ex.getMessage(), "[1:2] [the_parser] unknown field [not_supported_field]");
        e = expectThrows(IllegalArgumentException.class, () -> parser.parse(badmulti, null));
import org.opensearch.core.xcontent.XContentParserUtils;
        builder.endObject();
            this.c = value;
                    + "or an array where each entry is an object with a single field"
        TestStruct s = objectParser.parse(parser, new TestStruct(), null);
        b = shuffleXContent(b);
        objectParser.parse(parser, s, null);
 *
import org.opensearch.core.ParseField;
            TopLevelNamedXConent::new
    }
            this.name = name;
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"str\": \"foo\"}");
                            throw new IllegalStateException("boom");
        public void keepNamedInOrder() {
            }
            boolean null_value;
    public void testTopLevelNamedXContent() throws IOException {
            TopLevelNamedXConent o = TopLevelNamedXConent.PARSER.parse(parser, null);
        XContentParser bad = createParser(JsonXContent.jsonXContent, "{\"a\" : 1, \"b\" : 2}");
            e.getMessage(),
        assertThat(e.getMessage(), containsString("allowed together: [a, b] The following fields are not allowed together: [c, d]"));
 * SPDX-License-Identifier: Apache-2.0
        assertNull(s.testArray.get(0));
        parser.declareString(AtomicReference::set, new ParseField("body"));
        assertEquals(s.object.test, 0);
    public void testExceptions() throws IOException {
    public void testFailOnValueType() throws IOException {
    }
        assertEquals("parser for [noop] did not end on END_OBJECT", garbageException.getMessage());
public class ObjectParserTests extends OpenSearchTestCase {
            public void setLong_array_field(List<Long> long_array_field) {
            TestStruct::setArray,
import java.util.HashMap;
        ObjectParser<TestStruct, Void> parser = new ObjectParser<>("foo", TestStruct::new);
            ObjectWithArbitraryFields::new
    }
            TopLevelNamedXConent o = TopLevelNamedXConent.PARSER.parse(parser, null);
        }
import org.opensearch.test.OpenSearchTestCase;
            IllegalArgumentException.class,
        assertNotNull(s.object);
    }
        ObjectParser<AtomicReference<String>, String> parser = ObjectParser.fromBuilder("test", AtomicReference::new);
        class TestStruct {
    public void testParseNamedObjects() throws IOException {
                    } else if (token == XContentParser.Token.VALUE_NUMBER) {
        {
            builder.field("boolean_field", Boolean.toString(nullValue));
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
        parser = createParser(JsonXContent.jsonXContent, "{\"test_array\": [null]}");
                    throw new UncheckedIOException(e);
            expectedNullableDouble = randomDouble();
        assertEquals(11, h.named.foo);
        b.flush();
    }
        XContentParser parser = createParser(XContentType.JSON.xContent(), "{\"old_test\" : \"foo\"}");
        b.endObject();
        assertThat(
        objectParser.parse(parser, s, null);
        XContentBuilder b = MediaTypeRegistry.JSON.contentBuilder();
        assertThat(o.fields.get("test_nested"), instanceOf(Map.class));
            }
                b.field("really", "junk");
            this.foo = foo;
 * Licensed to Elasticsearch under one or more contributor
        XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString());
        parser = createParser(JsonXContent.jsonXContent, "{\"object\" : true }");
                new ParseField("test"),
            }
                    + "or an array where each entry is an object with a single field"
                new NamedXContentRegistry.Entry(Object.class, new ParseField("bool"), p -> p.booleanValue())
        NamedObjectsHolder h = NamedObjectsHolder.PARSER.apply(parser, null);
        objectParser.declareObjectOrNull(StaticTestStruct::setObject, objectParser, nullMarker, new ParseField("object"));
                this.string_field = string_field;
        if (randomBoolean()) {
        objectParser.declareLong(TestStruct::setA, new ParseField("a"));
        XContentParser parser = createParser(JsonXContent.jsonXContent, bytes);
        assertNotNull(s.objectArray);
            NamedObjectHolder::new
        assertThat(e.getMessage(), containsString("[named_objects_holder] failed to parse field [named]"));
        assertEquals(s.uri.getPort(), 80);
import static org.hamcrest.Matchers.containsString;
import org.opensearch.core.xcontent.XContentParser;
        objectParser.declareObjectOrDefault(Foo::setURI, (p, s) -> s.parseURI(p), () -> null, new ParseField("url"));
            builder.nullField("nullable_int_field");
                this.testArray = testArray;
                    if (token == XContentParser.Token.FIELD_NAME) {
            }
                new NamedXContentRegistry.Entry(Object.class, new ParseField("str"), p -> p.text()),
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
            this.objectArray = objectArray;
                new ParseField("named")
import java.util.List;
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {} ]}");
        static {
        );
                        }
        builder.startObject();
    public void testParseNamedObjectsInOrderNotSupported() throws IOException {
            builder.field("float_array_field", randomBoolean() ? "3.1" : 3.1);
        ObjectParser<ObjectWithArbitraryFields, Void> op = new ObjectParser<>(
        class Foo {
                    b.field("really", "junk");
            public String test;
        objectParser.declareString(Foo::setName, new ParseField("name"));
            () -> objectParser.declareField((o, v) -> {}, (r, c) -> null, null, ObjectParser.ValueType.STRING)
    }
            public String test;
        objectParser.declareIntArray(TestStruct::setInts, new ParseField("test_array"));
            public void setString_array_field(List<String> string_array_field) {
        e = expectThrows(
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"int\": 1}");
            }
 * this work for additional information regarding copyright
    private static class TopLevelNamedXConent {
            builder.field("boolean_field", nullValue);
    }
        XContentBuilder b = MediaTypeRegistry.JSON.contentBuilder();
        int expectedNullableInt;
            List<Long> long_array_field;
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo", true, TestStruct::new);
            List<Float> float_array_field;
            TopLevelNamedXConent o = TopLevelNamedXConent.PARSER.parse(parser, null);
        assertThat(s.testArray, hasSize(1));
        builder.field("string_field", "5");
    public void testParseNamedObjectsJunkInArray() throws IOException {
        static {
            assertEquals(s.test, TestEnum.FOO);
        }
        }
            "{ \"test_array\": [ 1, null, \"3\", 4.2], \"int_array\":  [ 1, 2, 3] }"
            assertThat(ex.getMessage(), containsString("[the_parser] failed to parse field [test]"));
import static org.hamcrest.Matchers.containsInAnyOrder;
        assertEquals("[parseField] is required", e.getMessage());
        final String name;
            }
import org.opensearch.core.xcontent.NamedObjectNotFoundException;
            builder.nullField("nullable_double_field");
    public void testNoopDeclareField() throws IOException {
        objectParser.parse(parser, s, null);
            }
            this.d = value;
        parser.declareLong(TestStruct::setB, new ParseField("b"));
        objectParser.declareInt(StaticTestStruct::setTest, new ParseField("test"));
        ObjectParser<AtomicReference<String>, Void> parser = new ObjectParser<>("noopy", AtomicReference::new);
            }
        AtomicReference<String> parsed = parser.parse(createParser(JsonXContent.jsonXContent, "{}"), context);
    }
            String string_or_null = "adsfsa";
        public static final ObjectParser<NamedObjectHolder, Void> PARSER = new ObjectParser<>(
                + "  \"name\" : \"geoff\",\n"
        op.declareString(ObjectWithArbitraryFields::setName, new ParseField("name"));
        assertEquals(6, o.fields.size());
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"numeric_value\" : false}");
            this.object = object;
            "named_object_holder",
        }
        assertEquals(s.ints, Arrays.asList(1, 2, 3, 4));
import static org.hamcrest.Matchers.nullValue;
        objectParser.declareObjectOrDefault(StaticTestStruct::setObject, objectParser, StaticTestStruct::new, new ParseField("object"));
        );
import org.opensearch.core.xcontent.ObjectParser.ValueType;
                NamedObjectsHolder::keepNamedInOrder,
    }
            }
            builder.array("long_array_field", randomBoolean() ? "4" : 4);
import java.util.Collections;
            public int test;
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"a\": \"123\"}");
        }
                + "FieldParser{preferred_name=test_number, supportedTokens=[VALUE_STRING, VALUE_NUMBER], type=INT}]}"
        }
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
            double nullableDoubleField;
            }
            this.named = named;
            Object.class,
            NamedObjectNotFoundException cause = (NamedObjectNotFoundException) ex.getCause();
        StaticTestStruct s = objectParser.parse(parser, null);
            b.startObject("junk");
        assertThat(obj.a, equalTo(123L));
            namedSuppliedInOrder = true;
        assertEquals("i", parser.parse(createParser(JsonXContent.jsonXContent, "{\"body\": \"i\"}"), null).get());
import org.opensearch.core.xcontent.XContentParseException;
                this.long_array_field = long_array_field;
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": { \"a\": {\"foo\" : 11} }, \"bar\": \"baz\"}");
            "{ \"test\" : \"foo\", \"test_number\" : 2, \"test_array\": [1,2,3,4] }"
        parser = createParser(JsonXContent.jsonXContent, "{\"test_array\": null}");
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
    private static class TestStruct {
        StaticTestStruct nullMarker = new StaticTestStruct();
            }
        assertEquals(s.testArray, Collections.singletonList(42));
            ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
        StaticTestStruct s = objectParser.parse(parser, null);
            public void setTest(int test) {}
        objectParser.declareFloat(TestStruct::setFloat_field, new ParseField("float_field"));
        class TestStruct {
        objectParser.declareField((i, c, x) -> c.test = i.text(), new ParseField("test"), ObjectParser.ValueType.STRING);
                }
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
            public void setName(String name) {
        parser.declareString(AtomicReference::set, new ParseField("body"));
            List<Integer> ints = new ArrayList<>();
        assertEquals("parser for [noop] did not end on END_OBJECT", sneakyException.getMessage());
        assertThat(e.getMessage(), containsString("[named_object_holder] named doesn't support values of type: START_ARRAY"));
            b.field("test", "foo");
        private void setC(long value) {
        objectParser.declareIntOrNull(TestStruct::setNullableIntField, -1, new ParseField("nullable_int_field"));
        );
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"test\" : \"FOO\" }");
            e.getCause().getMessage(),
            TestStruct object;
        assertArrayEquals(parse.int_array_field.toArray(), Collections.singletonList(1).toArray());
        assertTrue(h.namedSuppliedInOrder);
    }
            )
        class TestStruct {
            this.test = test;
                this.null_value = null_value;
 * KIND, either express or implied.  See the License for the
        class TestStruct {
        objectParser.declareLong(TestStruct::setA, new ParseField("a"));
    }
            TopLevelNamedXConent::setNamed,
        assertThat(s.testArray, hasSize(1));
        );
        objectParser.declareLong(TestStruct::setC, new ParseField("c"));
            double double_field;
            List<Integer> ints = new ArrayList<>();
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));
        assertThat(actualA.a, equalTo(1L));
                ObjectParser.ValueType.STRING
    }
        class ClassicParser {
        XContentParser parser = createParser(JsonXContent.jsonXContent, bytes);
import java.util.Map;
            }
        {
        objectParser.declareLong(TestStruct::setB, new ParseField("b"));
        Object named;
        objectParser.declareInt(TestStruct::setTestNumber, new ParseField("test_number"));
        b.startObject();
            this.b = value;
        parser.declareLong(TestStruct::setA, new ParseField("a"));
    }
        }
                        } else {
        byte[] bytes = ((ByteArrayOutputStream) b.getOutputStream()).toByteArray();
    }
            ObjectWithArbitraryFields::setField,
        b = shuffleXContent(b);
        );
        );
        assertEquals(true, o.fields.get("test_boolean"));
            public URI uri;
        boolean nullValue = randomBoolean();
            () -> parser.parse(createParser(JsonXContent.jsonXContent, "{\"noop\": [\"ignored\"]}"), null)
            }
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo", true, null);
            IllegalArgumentException.class,
import java.io.ByteArrayOutputStream;
    public void testIgnoreUnknownObjects() throws IOException {
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"not_supported_field\" : \"foo\"}");
        }
            List<String> string_array_field;
            b.field("test", "foo");
    }
            ValueType.VALUE_ARRAY
            public URI parseURI(XContentParser parser) {
                        if (fieldName.equals("host")) {
                this.int_array_field = int_array_field;
        objectParser.parse(parser, s, null);
                + "  \"test_array\":  [1,2,3,4],\n"
            parser.declareInt(NamedObject::setFoo, new ParseField("foo"));
        parser = createParser(JsonXContent.jsonXContent, "{\"b\": \"123\"}");
        assertThat(ex.getMessage(), containsString("[foo] failed to parse field [int_array]"));
                + "  \"test_nested\": { \"field\" : \"value\", \"field2\" : [ \"list1\", \"list2\" ] }\n"
        private boolean namedSuppliedInOrder = false;
import org.opensearch.common.xcontent.json.JsonXContent;
                    + "or an array where each entry is an object with a single field"
        objectParser.declareField((i, c, x) -> c.test = i.text(), new ParseField("test"), ObjectParser.ValueType.STRING);
                this.double_array_field = double_array_field;
    }
        b = shuffleXContent(b);
        assertThat(obj.b, nullValue());
                this.int_field = int_field;
        class TestStruct {
        if (randomBoolean()) {
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testNoopDeclareObject() throws IOException {
            PARSER.declareString(NamedObjectHolder::setBar, new ParseField("bar"));
        objectParser.declareObject(StaticTestStruct::setObject, objectParser, new ParseField("object"));
        } else {
import java.util.ArrayList;
            }
        );
        assertEquals(s.object.test, 2);
        objectParser.declareRequiredFieldSet(new String[] { "a", "b" });
        if (randomBoolean()) {
        // Make sure that we didn't break the null handling in arrays that shouldn't support nulls
        }
    enum TestEnum {
                    parser.nextToken();
    static class StaticTestStruct {
                "[named] can be a single object with any number of fields "
                try {
        {
        assertNull(o.fields.get("test_null"));
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("the_parser");
        assertThat(e.getMessage(), containsString("[named_objects_holder] failed to parse field [named]"));
        {
                        if (fieldName.equals("port")) {
        assertThat(
        StaticTestStruct s = objectParser.parse(parser, null);
        objectParser.declareInt(StaticTestStruct::setTest, new ParseField("test"));
    public void testMultipleRequiredFieldSet() throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
                this.double_field = double_field;
        e = expectThrows(
                new NamedXContentRegistry.Entry(Object.class, new ParseField("float"), p -> p.floatValue()),
        assertEquals(s.test, 1);
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {\"a\": {}} ] }");
        }
        assertEquals(s.testNumber, 2);
        builder.field("long_field", randomBoolean() ? "4" : 4);
        // Now firing the xml through it fails
        }
    }
            @SuppressWarnings("unused")
        b.endObject();
        assertThat(actualA.c, equalTo(4L));
                + "FieldParser{preferred_name=test, supportedTokens=[VALUE_STRING], type=STRING}, "
            }
        class TestStruct {
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ \"a\": {\"foo\" : 11} }]");
                + "  \"test_number\" : 2,\n"
        class CustomParseContext {
        assertEquals(s.testArray, Arrays.asList(1, null, "3", 4.2));
        assertEquals("[parser] is required", e.getMessage());
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"object\" : null}");
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static class ObjectWithArbitraryFields {
        BAR
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"test\" : \"foo\"}");
    }
                b.endObject();
        }
            public void setString_or_null(String string_or_null) {
            public void set(TestEnum value) {
        assertEquals("i", parser.parse(createParser(JsonXContent.jsonXContent, "{\"body\": \"i\"}"), null).get());
            List<Double> double_array_field;
        objectParser.declareIntArray(TestStruct::setInts, new ParseField("int_array"));
        TestStruct s = new TestStruct();
        obj = objectParser.apply(parser, null);
                this.b = value;
        assertThat(e.getMessage(), containsString("[named_objects_holder] failed to parse field [named]"));
            public String test;
                this.ints = ints;
    public void testArraysOfGenericValues() throws IOException {
            builder.array("double_array_field", randomBoolean() ? "2.1" : 2.1d);
        assertNull(s.object);
            assertThat(cause.getCandidates(), containsInAnyOrder("str", "int", "float", "bool"));
                            host = parser.text();
        assertEquals(
    }
        }
        objectParser.declareDoubleArray(TestStruct::setDouble_array_field, new ParseField("double_array_field"));
    }
            private Long a;
        assertEquals("parser for [noop] did not end on END_ARRAY", e.getMessage());
        );
            assertEquals(parse.string_field, "5");
            )
        parser.declareLong(TestStruct::setD, new ParseField("d"));
            public final ClassicParser parser;
    }
            )
            TestStruct s = objectParser.parse(parser, new TestStruct(), null);
        public void setNamed(List<NamedObject> named) {
            "unknown",
        Exception sneakyException = expectThrows(
        } else {
                + "}"
        assertNull(s.testArray.get(0));
        assertThat(e.getMessage(), containsString("The following fields are not allowed together: [a, b]"));
            }
                XContentParser.Token token;
    }
                (o, v) -> {},
        }
            JsonXContent.jsonXContent,
        objectParser.declareRequiredFieldSet(new String[] { "a", "b" });
        objectParser.declareField((i, c, x) -> c.test = i.text(), new ParseField("test"), ObjectParser.ValueType.STRING);
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"bool\": false}");
    }
 */
            }
        assertThat(s.object, not(nullValue()));
        {
        assertEquals(parse.float_field, 3.1f, 0.0f);
     */
        );
            private void setA(long value) {
        parser.declareString(AtomicReference::set, new ParseField("body"));
        assertEquals("foo", s.test);
        );
            builder.field("nullable_int_field", expectedNullableInt);
        private Long a;
        if (randomBoolean()) {
        assertEquals("[parser] is required", e.getMessage());
        {
        objectParser.declareLongArray(TestStruct::setLong_array_field, new ParseField("long_array_field"));
        StaticTestStruct object;
            private Long b;
                "[named] can be a single object with any number of fields "
                (CheckedFunction<XContentParser, Object, IOException>) null,
            e.getCause().getMessage(),
        } else {
            public void setURI(URI uri) {
        FOO,
    // plural
                } catch (IOException e) {
        assertEquals(s.name, "foobarbaz");
    }
 *
        }
                this.name = name;
                while ((token = parser.currentToken()) != XContentParser.Token.END_OBJECT) {
        parser = createParser(JsonXContent.jsonXContent, "{\"object\" : false }");
            containsString(
            this.bar = bar;
                return URI.create(host + ":" + port);
        ObjectParser<Foo, CustomParseContext> objectParser = new ObjectParser<>("foo");
        obj = objectParser.apply(parser, null);
        objectParser.declareInt(TestStruct::setTest, new ParseField("test"));
            }
                    return this.parser.parseURI(parser);
        StaticTestStruct s = objectParser.parse(parser, null);
        }
        assertEquals("a", h.named.get(0).name);
    public void testNullDeclares() {
        ObjectParser<NamedObjectsHolder, Void> objectParser = new ObjectParser<>("named_object_holder", NamedObjectsHolder::new);
        public static final ObjectParser<TopLevelNamedXConent, Void> PARSER = new ObjectParser<>(
    public void testParseEnumFromString() throws IOException {
        objectParser.declareFieldArray(
        assertThat(h.named, hasSize(1));
        } else {
            }
    public void testObjectOrDefault() throws IOException {
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"object_array\" : [{}]}");
                        fieldName = parser.currentName();
            XContentParseException.class,
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
            IllegalArgumentException.class,
    public void testEmptyObjectInArray() throws IOException {
    }
            assertEquals(4.0F, o.named);
        objectParser.declareInt(TestStruct::setInt_field, new ParseField("int_field"));
        );
            equalTo("Required one of fields [a, b], but none were specified. " + "Required one of fields [c, d], but none were specified. ")
        b.flush();
            public void setString_field(String string_field) {
                test = value;
    public void testAllVariants() throws IOException {
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"test\" : 1, \"object\" : { \"test\": 2}}");
        }
}
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> objectParser.apply(parser, null));
            e.getCause().getMessage(),
import java.io.UncheckedIOException;
        XContentParser parser = createParser(
    }
        s = new TestStruct();
        byte[] bytes = ((ByteArrayOutputStream) b.getOutputStream()).toByteArray();
            PARSER.declareNamedObject(NamedObjectHolder::setNamed, NamedObject.PARSER, new ParseField("named"));
        }
        assertThat(s.object, equalTo(nullMarker));
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
        e = expectThrows(
    public void testParseNamedObject() throws IOException {
            assertEquals(false, o.named);
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"not_supported_field\" : \"foo\"}");
            b.field("test", "foo");
    }
        assertEquals(s.object.test, 2);
            {
                this.ints = ints;
        }
        s = objectParser.parse(parser, null);
        ObjectParser<AtomicReference<String>, Void> parser = new ObjectParser<>("noopy", AtomicReference::new);
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"object\" : { \"test\": 2}}");
                (o, v) -> {},
        e = expectThrows(
            public void setInt_field(int int_field) {
            }
            XContentParseException ex = expectThrows(XContentParseException.class, () -> objectParser.parse(parser, s, null));
                this.long_field = long_field;
/*
import static org.hamcrest.Matchers.equalTo;
            fields.put(key, value);
        public static final NamedObjectParser<NamedObject, Void> PARSER;
            builder.field("string_array_field", "5");
        assertThat(
                NamedObjectsHolder::setNamed,
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ \"junk\" ] }");
        Exception e = expectThrows(XContentParseException.class, () -> objectParser.parse(parser, s, null));
        assertThat(o.fields.get("test_array"), instanceOf(List.class));
            float float_field;
            int nullableIntField;
            IllegalStateException.class,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.ContextParser;
    public void testRequiredFieldSet() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        objectParser.declareBoolean(TestStruct::setNull_value, new ParseField("boolean_field"));
            public void setDouble_field(double double_field) {
        assertThat(obj.b, equalTo(456L));
        objectParser.declareLong(TestStruct::setA, new ParseField("a"));
            }
            IllegalStateException.class,
            public String test;
        private Long c;
        }
        } else {
        List<StaticTestStruct> objectArray;
            public void setArray(List<Object> testArray) {
            public void setLong_field(long long_field) {
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
            () -> parser.parse(createParser(JsonXContent.jsonXContent, "{\"noop\": {\"body\": \"shouldn't\"}}"), null)
            objectParser.toString(),
                this.nullableDoubleField = nullableDoubleField;
        } else {
        XContentParser parser = createParser(JsonXContent.jsonXContent, bytes);
        if (nullValue) {
    }
/*
                new NamedXContentRegistry.Entry(Object.class, new ParseField("int"), p -> p.intValue()),
        objectParser.declareDouble(TestStruct::setDouble_field, new ParseField("double_field"));
        );
        }
        XContentParseException ex = expectThrows(XContentParseException.class, () -> objectParser.parse(parser2, s2, null));
    }
        }
            PARSER = (XContentParser p, Void v, String name) -> parser.parse(p, new NamedObject(name), null);
        }
        XContentParser parser = createParser(
        assertThat(
                int port = 0;
            this.name = name;
            public void setFloat_field(float float_field) {
    }
        class TestStruct {
        assertNotNull(s.object);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"test\" : \"FOO\" }");
        assertThat(parse.nullableIntField, equalTo(expectedNullableInt));
 * You may obtain a copy of the License at
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo", true, null);
        XContentParser badmulti = createParser(JsonXContent.jsonXContent, "{\"a\" : 1, \"b\" : 2, \"c\" : 3, \"d\" : 4 }");
                "[named] can be a single object with any number of fields "
    public void testObjectOrNullWhenNull() throws IOException {
        }
        }
    public void testParseNamedObjectUnexpectedArray() throws IOException {
        objectParser.declareRequiredFieldSet(new String[] { "c", "d" });
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectsHolder.PARSER.apply(parser, null));
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"object\" : {}}");
                            port = parser.intValue();
        }
            }
        if (randomBoolean()) {
            public TestEnum test;
        b.startObject();
                    }
    public void testUseClassicPullParsingSubParser() throws IOException {
    public void testObjectOrNullWhenNonNull() throws IOException {
                }
        void setField(String key, Object value) {
        }
                this.nullableIntField = nullableIntField;
        ObjectParser<Void, Void> objectParser = new ObjectParser<>("foo");
        public NamedObject(String name) {
        }
        TestStruct s = new TestStruct();
        TestStruct s = new TestStruct();
        int test;
 * compatible open source license.
        assertArrayEquals(parse.float_array_field.toArray(), Collections.singletonList(3.1f).toArray());
    }
            this.named = named;
                + "FieldParser{preferred_name=test_array, supportedTokens=[START_ARRAY, VALUE_STRING, VALUE_NUMBER], type=INT_ARRAY}, "
        parser.declareLong(TestStruct::setC, new ParseField("c"));
        private String bar;
        XContentBuilder b = MediaTypeRegistry.JSON.contentBuilder();
    }
                this.a = value;
        class TestStruct {
            ObjectParser<NamedObject, Void> parser = new ObjectParser<>("named");
        s.object = new TestStruct();
package org.opensearch.common.xcontent;
        assertEquals(s.test, 1);
                String host = "";
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"test\" : 1, \"object\" : { \"test\": 2}}");
        assertEquals(parse.int_field, 1);
    }
            public void setDouble_array_field(List<Double> double_array_field) {
            public void setNullableIntField(int nullableIntField) {
        void setName(String name) {
            containsString(
        TestStruct parse = objectParser.parse(parser, new TestStruct(), null);
        }
        objectParser.parse(parser, s, null);
        builder.field("string_or_null", nullValue ? null : "5");
 * not use this file except in compliance with the License.
            containsString(
        assertEquals(s.test, "foo");
        double expectedNullableDouble;
        public void setBar(String bar) {
        NamedObjectsHolder h = NamedObjectsHolder.PARSER.apply(parser, null);
        assertThat(obj.b, equalTo(123L));
        static {
        TestStruct s = objectParser.parse(parser, new TestStruct(), null);
        {
                + "  \"test\" : \"foo\",\n"
            )
        }
import java.io.IOException;
        Exception e = expectThrows(
        public void setObjectArray(List<StaticTestStruct> objectArray) {
            assertEquals(s.test, TestEnum.FOO);
import java.util.Arrays;
        ObjectParser<AtomicReference<String>, Void> parser = new ObjectParser<>("noopy", AtomicReference::new);
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"unrelated\": \"123\"}");
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertArrayEquals(parse.double_array_field.toArray(), Collections.singletonList(2.1d).toArray());
        }
        objectParser.declareString(TestStruct::setString_field, new ParseField("string_field"));
        }
            IllegalStateException.class,
        {
                throw new IllegalArgumentException("Only one [named] allowed!");
        );
        if (randomBoolean()) {
            long long_field;
        TestStruct actualA = parser.parse(goodA, null);
    public void testParseNestedShortcut() throws IOException {
        builder.field("float_field", randomBoolean() ? "3.1" : 3.1f);
import static org.hamcrest.Matchers.instanceOf;
        assertEquals("[consumer] is required", e.getMessage());
        // Create our own parser for this test so we can disable support for the "ordered" mode specified by the array above
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {\"a\": {}, \"b\": {}}]}");
        } else {
        public void setNamed(NamedObject named) {
        objectParser.declareLong(TestStruct::setB, new ParseField("b"));
            () -> parser.parse(createParser(JsonXContent.jsonXContent, "{\"noop\": [{\"body\": \"shouldn't\"}}]"), null)
            "{\n"
            if (this.named != null) {
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectsHolder.PARSER.apply(parser, null));
    public void testParseNamedObjectsTwoFieldsInArray() throws IOException {
        XContentParseException sneakyError = expectThrows(
        XContentParseException garbageError = expectThrows(
            "named_objects_holder",
            this.named = named;
            CustomParseContext(ClassicParser parser) {
            }
        public static final ObjectParser<NamedObjectsHolder, Void> PARSER = new ObjectParser<>(
            }
        private List<NamedObject> named;
        }
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
            builder.field("int_array_field", randomBoolean() ? "1" : 1);
    // singular
    public void testIgnoreUnknownFields() throws IOException {
        objectParser.declareField((i, v, c) -> v.test = i.text(), new ParseField("test", "old_test"), ObjectParser.ValueType.STRING);
        assertArrayEquals(parse.string_array_field.toArray(), Collections.singletonList("5").toArray());
        objectParser = new ObjectParser<>("foo", true, TestStruct::new);
                + "  \"test_null\" : null,\n"
        parser.declareField((a, b) -> {}, (p, c) -> null, new ParseField("noop"), ValueType.STRING_ARRAY);
        assertEquals("a", h.named.name);
                }
        s = objectParser.parse(parser, null);
        }
        }
        objectParser.declareLong(TestStruct::setLong_field, new ParseField("long_field"));
        XContentParser goodA = createParser(JsonXContent.jsonXContent, "{\"a\" : 1, \"c\" : 4}");
        objectParser.declareLong(TestStruct::setB, new ParseField("b"));
            Arrays.asList(
                        }
            List<Object> testArray = new ArrayList<>();
    public void testIgnoreUnknownArrays() throws IOException {
    static class NamedObjectsHolder {
    @Override
            JsonXContent.jsonXContent,
            }
        public void setObject(StaticTestStruct object) {
            b.endObject();
            List<Integer> int_array_field;
        );
        }
 *
        objectParser.parse(parser, s, null);
        assertEquals(s.ints, Arrays.asList(1, 2, 3));
        objectParser.declareObject(StaticTestStruct::setObject, objectParser, new ParseField("object"));
            "{\"url\" : { \"host\": \"http://foobar\", \"port\" : 80}, \"name\" : \"foobarbaz\"}"
        assertEquals("expected value but got [FIELD_NAME]", garbageError.getCause().getMessage());
            public void setInts(List<Integer> ints) {
        }
        XContentParseException e = expectThrows(XContentParseException.class, () -> objectParser.apply(parser, null));
            assertNull(parse.string_or_null);
            public String test;
        private void setD(long value) {
        StaticTestStruct s = objectParser.parse(parser, null);
            public void setInts(List<Integer> ints) {
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"float\": 4.0}");
        StaticTestStruct s = objectParser.parse(parser, null);
    public void testNoopDeclareObjectArray() {
        );
    }
            new ParseField("test_array"),
        if (randomBoolean()) {
    }
            objectParser.declareString((struct, value) -> struct.set(value), TestEnum::valueOf, new ParseField("test"));
        );
        }
        builder.field("int_field", randomBoolean() ? "1" : 1);
        objectParser.declareObjectOrNull(StaticTestStruct::setObject, objectParser, nullMarker, new ParseField("object"));
        assertEquals("[type] is required", e.getMessage());
        }
        assertArrayEquals(parse.long_array_field.toArray(), Collections.singletonList(4L).toArray());
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
        assertEquals("baz", h.bar);
    protected NamedXContentRegistry xContentRegistry() {
        );
        assertThat(obj.a, nullValue());
                b.startObject();
                            throw new IllegalStateException("boom");
                (ContextParser<Void, Object>) null,
            );
    public void testContextBuilder() throws IOException {
            IllegalArgumentException.class,
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
 * Unless required by applicable law or agreed to in writing,
        );
        assertEquals(parse.double_field, 2.1d, 0.0d);
            () -> objectParser.declareField(
    public void testParseNamedObjectsNoFieldsInArray() throws IOException {
        objectParser.declareDoubleOrNull(TestStruct::setNullableDoubleField, Double.NaN, new ParseField("nullable_double_field"));
        void setNamed(Object named) {
        }
        builder.field("double_field", randomBoolean() ? "2.1" : 2.1d);
        parser.declareExclusiveFieldSet("c", "d");
            )
 * the Apache License, Version 2.0 (the "License"); you may
        {
            XContentParseException ex = expectThrows(XContentParseException.class, () -> TopLevelNamedXConent.PARSER.parse(parser, null));
        assertEquals(s.test, "foo");
        private Long b;
        objectParser.declareNamedObjects(NamedObjectsHolder::setNamed, NamedObject.PARSER, new ParseField("named"));
            public void setNull_value(boolean null_value) {
        objectParser.declareRequiredFieldSet(new String[] { "a", "b" });
                this.testNumber = testNumber;
        TestStruct s = objectParser.parse(parser, new TestStruct(), null);
    }
        class TestStruct {
        }
                this.float_field = float_field;
                this.float_array_field = float_array_field;
        XContentParser parser = createParser(
    public void testDeprecationWarnings() throws IOException {
        objectParser.declareStringOrNull(TestStruct::setString_or_null, new ParseField("string_or_null"));
                this.string_or_null = string_or_null;
        StaticTestStruct nullMarker = new StaticTestStruct();
                + "  \"test_boolean\" : true,\n"
        s = new TestStruct();
            JsonXContent.jsonXContent,
        Foo s = objectParser.parse(parser, new Foo(), new CustomParseContext(new ClassicParser()));
        TestStruct s2 = new TestStruct();
        NamedObjectHolder h = NamedObjectHolder.PARSER.apply(parser, null);
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;
        assertEquals("a", h.named.get(0).name);
        objectParser.declareField((i, c, x) -> c.test = i.text(), new ParseField("test"), ObjectParser.ValueType.STRING);
        }
        );
        return new NamedXContentRegistry(
        parser.declareExclusiveFieldSet("a", "b");
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.ObjectParser;
    public void testConsumeUnknownFields() throws IOException {
        public void setFoo(int foo) {
            this.a = value;
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {\"a\": {}} ] }");
        );
        assertEquals(nullValue, parse.null_value);
            expectedNullableInt = randomInt();
        byte[] bytes = ((ByteArrayOutputStream) b.getOutputStream()).toByteArray();
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named]"));
            public void setTestNumber(int testNumber) {
        assertThat(e.getMessage(), containsString("[foo] numeric_value doesn't support values of type: VALUE_BOOLEAN"));
        objectParser.parse(parser, s, null);
        XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
    public static class NamedObject {
        objectParser = new ObjectParser<>("foo", true, TestStruct::new);
        parser.declareObject((a, b) -> {}, (p, c) -> null, new ParseField("noop"));
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
        }
        objectParser.declareLong(TestStruct::setB, new ParseField("b"));
            builder.field("nullable_double_field", expectedNullableDouble);
            assertEquals(1, o.named);
        }
            builder.field("long_array_field", randomBoolean() ? "4" : 4);
        b.endObject();
        TestStruct s = new TestStruct();
        TestStruct obj = objectParser.apply(parser, null);
    static class NamedObjectHolder {
            }
        } else {
            JsonXContent.jsonXContent,
            builder.array("float_array_field", randomBoolean() ? "3.1" : 3.1);
 * under the License.
        Exception e = expectThrows(
        objectParser.declareLong(TestStruct::setA, new ParseField("a"));
        private Long d;
            () -> objectParser.declareField(null, (r, c) -> null, new ParseField("test"), ObjectParser.ValueType.STRING)
        );
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo", true, TestStruct::new);
    public void testBasics() throws IOException {
        b.startObject();
                NamedObject.PARSER,
        {
        private void setA(long value) {
        assertEquals("expected value but got [FIELD_NAME]", sneakyError.getCause().getMessage());
        assertThat(h.named, hasSize(1));
     * together with the object parser
import java.net.URI;
                    } else if (token == XContentParser.Token.VALUE_STRING) {
            XContentParseException ex = expectThrows(XContentParseException.class, () -> objectParser.parse(parser, s, null));
            expectedNullableInt = -1;
            )
    }
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo", true, null);
            builder.array("string_array_field", "5");
            () -> parser.parse(createParser(JsonXContent.jsonXContent, "{\"noop\": [{\"garbage\": \"shouldn't\"}}]"), null)
        String name;
        {
    /**
        parser.declareObjectArray((a, b) -> {}, (p, c) -> null, new ParseField("noop"));
            (p, c) -> XContentParserUtils.parseFieldsValue(p),
        parser = createParser(JsonXContent.jsonXContent, "{\"a\": \"123\", \"b\": \"456\"}");
                        } else {
        assertThat(obj.a, equalTo(123L));
    }
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": { \"a\": {} }}");
            b.endArray();
        );
            objectParser.declareString((struct, value) -> struct.set(TestEnum.valueOf(value)), new ParseField("test"));
 */
            }
    }
        assertEquals("geoff", o.name);
        assertEquals(2, o.fields.get("test_number"));
            URI parseURI(XContentParser parser) throws IOException {
            NamedObjectsHolder::new
            assertTrue(ex.getCause() instanceof NumberFormatException);
            public void setNullableDoubleField(double nullableDoubleField) {
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectsHolder.PARSER.apply(parser, null));
 * ownership. Elasticsearch licenses this file to you under
                this.parser = parser;
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
        objectParser.declareField((i, c, x) -> c.test = i.text(), new ParseField("numeric_value"), ObjectParser.ValueType.FLOAT);
        }
        parser = createParser(JsonXContent.jsonXContent, "{\"test_array\": 42}");
        String context = randomAlphaOfLength(5);
        assertEquals("[named] doesn't support arrays. Use a single object with multiple fields.", e.getCause().getMessage());
        assertFalse(h.namedSuppliedInOrder);
            PARSER.declareNamedObjects(
        TestStruct s = new TestStruct();
            b.startArray("junk");
            builder.field("double_array_field", randomBoolean() ? "2.1" : 2.1d);
        b.flush();
        TestStruct s = new TestStruct();
        }
            "test",
        }
        );
            () -> parser.parse(createParser(JsonXContent.jsonXContent, "{\"noop\": {\"garbage\": \"shouldn't\"}}"), null)
        class TestStruct {
        } else {
    }
/*
            IllegalArgumentException.class,
            assertEquals("[1:2] [test] unknown field [not_supported_field]", ex.getMessage());
        ObjectWithArbitraryFields o = op.parse(parser, null);
import java.util.concurrent.atomic.AtomicReference;
 * GitHub history for details.
        }
                this.string_array_field = string_array_field;
        assertThat(parsed.get(), equalTo(context));
        assertEquals(s.object.test, 2);
        objectParser.declareLong(TestStruct::setD, new ParseField("d"));
        }
            () -> objectParser.declareField((o, v) -> {}, (r, c) -> null, new ParseField("test"), null)
            expectedNullableDouble = Double.NaN;
        Exception garbageException = expectThrows(
            public String test;
        }
 * specific language governing permissions and limitations
        }
        assertEquals(s.test, "foo");
        assertEquals("foo", o.fields.get("test"));
    }
        );
            public void setInt_array_field(List<Integer> int_array_field) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parser.parse(bad, null));
            }
            ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
    public void testExclusiveFieldSet() throws IOException {
    }
            assertEquals("foo", o.named);
        s = new TestStruct();
    public void testEmptyObject() throws IOException {
        }
import org.opensearch.common.CheckedFunction;
            String string_field;
        Map<String, Object> fields = new HashMap<>();
        assertThat(parse.nullableDoubleField, equalTo(expectedNullableDouble));
     * This test ensures we can use a classic pull-parsing parser
        class TestStruct {
            "ObjectParser{name='foo', fields=["
        public void setTest(int test) {
 */
                this.uri = uri;
            int int_field;
            XContentParseException.class,
                String fieldName = null;
    }
            () -> objectParser.declareField(
        assertEquals(s.uri.getHost(), "foobar");
 * The OpenSearch Contributors require contributions made to
        objectParser.declareField((i, c, x) -> c.test = i.intValue(), new ParseField("test"), ValueType.INT);
            private void setB(long value) {
        assertEquals(parse.string_field, "5");
            {
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"object\" : {}}");
            builder.array("int_array_field", randomBoolean() ? "1" : 1);
 * license agreements. See the NOTICE file distributed with
            public void setFloat_array_field(List<Float> float_array_field) {
        objectParser.declareField((i, c, x) -> objectParser.parse(parser, c.object, null), new ParseField("object"), ValueType.OBJECT);
        objectParser.declareFloatArray(TestStruct::setFloat_array_field, new ParseField("float_array_field"));
            TopLevelNamedXConent o = TopLevelNamedXConent.PARSER.parse(parser, null);
    }
        }
    public void testParseNested() throws IOException {
