            List<Object> testArray = new ArrayList<>();
        }
            TestStruct object;
        objectParser.declareDoubleOrNull(TestStruct::setNullableDoubleField, Double.NaN, new ParseField("nullable_double_field"));  
 * software distributed under the License is distributed on an
    static class NamedObjectsHolder {
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"unrelated\": \"123\"}");
        objectParser.declareString(Foo::setName, new ParseField("name"));
            builder.field("boolean_field", nullValue);
        byte[] bytes = ((ByteArrayOutputStream) b.getOutputStream()).toByteArray();  
        void setField(String key, Object value) {  
        assertThat(o.fields.get("test_array"), instanceOf(List.class));  
        assertThat(obj.b, equalTo(123L));  
        );
        class CustomParseContext {
            public String test;
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"int\": 1}");
    public void testMultipleRequiredFieldSet() throws IOException {  
        objectParser.declareFloatArray(TestStruct::setFloat_array_field, new ParseField("float_array_field"));  
            TestStruct s = objectParser.parse(parser, new TestStruct(), null);  
        assertEquals("geoff", o.name);  
        BAR  
                XContentParser.Token token;  
                            port = parser.intValue();  
        }
     * This test ensures we can use a classic pull-parsing parser  
        public static final ObjectParser<NamedObjectHolder, Void> PARSER = new ObjectParser<>(  
    public void testObjectOrDefault() throws IOException {  
            e.getCause().getMessage(),
            List<Double> double_array_field;
        }  
                }
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
import static org.hamcrest.Matchers.containsInAnyOrder;
    }
        );  
        class TestStruct {
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo", true, TestStruct::new);  
                this.ints = ints;
            XContentParseException.class,
        objectParser.parse(parser, s, null);  
    public void testExclusiveFieldSet() throws IOException {  
        assertEquals(nullValue, parse.null_value);  
            IllegalArgumentException.class,
            }  
            "{\n"  
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));  
            }  
            public URI uri;  
        objectParser.declareLong(TestStruct::setA, new ParseField("a"));  
        XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
        objectParser.declareFieldArray(
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectsHolder.PARSER.apply(parser, null));  
                b.field("really", "junk");
                }  
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"object_array\" : [{}]}");  
                ObjectParser.ValueType.STRING
        double expectedNullableDouble;
        // Create our own parser for this test so we can disable support for the "ordered" mode specified by the array above
        assertEquals(s.test, 1);
            List<String> string_array_field;
        StaticTestStruct s = objectParser.parse(parser, null);  
        } else {  
                    + "or an array where each entry is an object with a single field"
        }  
            {
        {
                + "  \"test_null\" : null,\n"
            public void setLong_field(long long_field) {
        static {  
                            throw new IllegalStateException("boom");
            this.foo = foo;
    }
        assertThat(e.getMessage(), containsString("allowed together: [a, b] The following fields are not allowed together: [c, d]"));
        }
                this.nullableDoubleField = nullableDoubleField;  
        s = objectParser.parse(parser, null);
        }
            builder.nullField("nullable_double_field");  
        {
        objectParser.declareLong(TestStruct::setA, new ParseField("a"));
            List<Integer> ints = new ArrayList<>();
        objectParser.declareDoubleArray(TestStruct::setDouble_array_field, new ParseField("double_array_field"));
        }
 * Modifications Copyright OpenSearch Contributors. See  
    }
        public static final ObjectParser<NamedObjectsHolder, Void> PARSER = new ObjectParser<>(
        assertEquals("[named] doesn't support arrays. Use a single object with multiple fields.", e.getCause().getMessage());  
        builder.endObject();  
        }  
        assertEquals("a", h.named.get(0).name);
/*
 */
                this.double_field = double_field;
            "named_objects_holder",  
        builder.startObject();
 */
    public void testParseNamedObjectsInOrderNotSupported() throws IOException {
        assertEquals("parser for [noop] did not end on END_ARRAY", e.getMessage());
            (p, c) -> XContentParserUtils.parseFieldsValue(p),
        }
        assertNull(o.fields.get("test_null"));
        Exception sneakyException = expectThrows(  
        class TestStruct {
        assertThat(  
            List<Integer> int_array_field;
        objectParser.parse(parser, s, null);  
            }
            long long_field;
    /**
                this.ints = ints;
 * Licensed to Elasticsearch under one or more contributor  
        e = expectThrows(
                String fieldName = null;  
import java.io.IOException;
            }
            IllegalArgumentException.class,  
import org.opensearch.core.xcontent.ObjectParser.NamedObjectParser;
    private static class TopLevelNamedXConent {
        objectParser = new ObjectParser<>("foo", true, TestStruct::new);  
        } else {
            IllegalStateException.class,
        b.startObject();
                + "  \"test_number\" : 2,\n"
        String name;  
                this.name = name;  
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("the_parser");
                    if (token == XContentParser.Token.FIELD_NAME) {
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"object\" : { \"test\": 2}}");
        parser.declareObjectArray((a, b) -> {}, (p, c) -> null, new ParseField("noop"));
    }
        objectParser.declareRequiredFieldSet(new String[] { "a", "b" });
            assertEquals(false, o.named);
                + "  \"name\" : \"geoff\",\n"  
    public void testEmptyObject() throws IOException {  
    public void testParseEnumFromString() throws IOException {  
        parser.declareString(AtomicReference::set, new ParseField("body"));  
import org.opensearch.core.xcontent.XContentParseException;
 * specific language governing permissions and limitations
/*
        assertEquals(s.uri.getHost(), "foobar");
                this.string_or_null = string_or_null;
            XContentParseException ex = expectThrows(XContentParseException.class, () -> objectParser.parse(parser, s, null));
        parser = createParser(JsonXContent.jsonXContent, "{\"object\" : true }");
        objectParser.declareInt(StaticTestStruct::setTest, new ParseField("test"));
        XContentParser parser = createParser(JsonXContent.jsonXContent, bytes);
            PARSER.declareNamedObjects(
    static class NamedObjectHolder {
        }
    public void testArraysOfGenericValues() throws IOException {
        objectParser.declareLong(TestStruct::setD, new ParseField("d"));
        objectParser.declareLong(TestStruct::setLong_field, new ParseField("long_field"));  
        TestStruct s = new TestStruct();  
    public void testIgnoreUnknownArrays() throws IOException {  
                    b.field("really", "junk");  
        public void setNamed(NamedObject named) {  
            public void setArray(List<Object> testArray) {
        assertEquals(parse.int_field, 1);  
        if (randomBoolean()) {  
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"str\": \"foo\"}");  
    }
        }
                this.double_array_field = double_array_field;
        assertNull(s.object);  
        );
            ObjectWithArbitraryFields::setField,  
                NamedObjectsHolder::setNamed,
        assertThat(actualA.c, equalTo(4L));
        StaticTestStruct nullMarker = new StaticTestStruct();  
            "ObjectParser{name='foo', fields=["
            () -> objectParser.declareField(  
        );
        assertNull(s.testArray.get(0));
        XContentParser parser = createParser(
        private void setC(long value) {  
        }
        ObjectParser<Foo, CustomParseContext> objectParser = new ObjectParser<>("foo");
            () -> parser.parse(createParser(JsonXContent.jsonXContent, "{\"noop\": {\"garbage\": \"shouldn't\"}}"), null)  
        assertEquals("[parser] is required", e.getMessage());
    public void testObjectOrNullWhenNull() throws IOException {
            public void setDouble_array_field(List<Double> double_array_field) {
            this.name = name;
                this.a = value;
/*  
            @SuppressWarnings("unused")
        objectParser.declareInt(TestStruct::setTest, new ParseField("test"));
        }
        }
                while ((token = parser.currentToken()) != XContentParser.Token.END_OBJECT) {
    protected NamedXContentRegistry xContentRegistry() {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        objectParser.declareField((i, c, x) -> c.test = i.text(), new ParseField("test"), ObjectParser.ValueType.STRING);  
            }
            String string_or_null = "adsfsa";
    }  
            private void setA(long value) {  
        ObjectParser<AtomicReference<String>, Void> parser = new ObjectParser<>("noopy", AtomicReference::new);  
        assertThat(s.object, not(nullValue()));
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"test\" : 1, \"object\" : { \"test\": 2}}");  
        parser.declareObject((a, b) -> {}, (p, c) -> null, new ParseField("noop"));
        );  
        } else {
        StaticTestStruct s = objectParser.parse(parser, null);
            b.endObject();
            {  
            Arrays.asList(
        assertEquals(s.test, "foo");
        }
        FOO,
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectsHolder.PARSER.apply(parser, null));
    }  
        assertArrayEquals(parse.long_array_field.toArray(), Collections.singletonList(4L).toArray());
 */  
            IllegalStateException.class,
                new ParseField("test"),
        );  
    public void testParseNamedObjectsTwoFieldsInArray() throws IOException {
                this.testNumber = testNumber;
                "[named] can be a single object with any number of fields "
                new NamedXContentRegistry.Entry(Object.class, new ParseField("str"), p -> p.text()),
        b = shuffleXContent(b);
            IllegalArgumentException.class,
            )
        );  
    }  
        builder.field("int_field", randomBoolean() ? "1" : 1);  
            this.d = value;
        parser = createParser(JsonXContent.jsonXContent, "{\"test_array\": null}");  
    public void testParseNamedObjectsNoFieldsInArray() throws IOException {  
        }
        }
        );
 * license agreements. See the NOTICE file distributed with
            builder.array("string_array_field", "5");
    public void testParseNestedShortcut() throws IOException {
            }  
            this.bar = bar;
        assertEquals(true, o.fields.get("test_boolean"));
            NamedObjectsHolder::new
        {  
    // plural  
        s = objectParser.parse(parser, null);  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> objectParser.apply(parser, null));
            objectParser.declareString((struct, value) -> struct.set(value), TestEnum::valueOf, new ParseField("test"));  
        XContentParser parser = createParser(  
            assertThat(ex.getMessage(), containsString("[the_parser] failed to parse field [test]"));  
            TopLevelNamedXConent::setNamed,
        class TestStruct {
        class TestStruct {  
                this.nullableIntField = nullableIntField;
        ObjectParser<ObjectWithArbitraryFields, Void> op = new ObjectParser<>(
            public void setFloat_field(float float_field) {  
                        } else {
        assertArrayEquals(parse.float_array_field.toArray(), Collections.singletonList(3.1f).toArray());  
        assertEquals(s.test, 1);
import org.opensearch.core.xcontent.NamedObjectNotFoundException;
        class TestStruct {
    }
        assertEquals(s.uri.getPort(), 80);  
            XContentParseException ex = expectThrows(XContentParseException.class, () -> TopLevelNamedXConent.PARSER.parse(parser, null));  
            containsString(
        objectParser.declareIntOrNull(TestStruct::setNullableIntField, -1, new ParseField("nullable_int_field"));
            b.field("junk", 2);
            public void setFloat_array_field(List<Float> float_array_field) {  
 * Unless required by applicable law or agreed to in writing,
    }  
            }  
            NamedObjectNotFoundException cause = (NamedObjectNotFoundException) ex.getCause();
            () -> parser.parse(createParser(JsonXContent.jsonXContent, "{\"noop\": [\"ignored\"]}"), null)  
        assertThat(obj.a, equalTo(123L));  
            b.startArray("junk");
                            throw new IllegalStateException("boom");
        {
        }  
    }
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"object\" : {}}");
                new ParseField("test"),  
        class TestStruct {  
            public void setTest(int test) {}  
            }
            }
        objectParser.parse(parser, s, null);
 * GitHub history for details.
import static org.hamcrest.Matchers.not;  
    }
            }  
        objectParser.declareIntArray(TestStruct::setInt_array_field, new ParseField("int_array_field"));
            builder.field("nullable_int_field", expectedNullableInt);  
                try {
        int test;
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"float\": 4.0}");
        public static final NamedObjectParser<NamedObject, Void> PARSER;
        Foo s = objectParser.parse(parser, new Foo(), new CustomParseContext(new ClassicParser()));
            public void setNull_value(boolean null_value) {  
            }
    }
            assertEquals("foo", o.named);
                    + "or an array where each entry is an object with a single field"  
                    + "or an array where each entry is an object with a single field"
        objectParser.declareIntArray(TestStruct::setInts, new ParseField("int_array"));
            parser.declareInt(NamedObject::setFoo, new ParseField("foo"));
        assertEquals("parser for [noop] did not end on END_OBJECT", garbageException.getMessage());
            new ParseField("test_array"),
        StaticTestStruct object;  
                return URI.create(host + ":" + port);
                            host = parser.text();  
            private Long b;
        objectParser.declareField((i, c, x) -> c.test = i.text(), new ParseField("test"), ObjectParser.ValueType.STRING);
    }
        if (randomBoolean()) {
            assertEquals(parse.string_field, "5");
        parser = createParser(JsonXContent.jsonXContent, "{\"a\": \"123\", \"b\": \"456\"}");
        public void keepNamedInOrder() {
                    } else if (token == XContentParser.Token.VALUE_NUMBER) {
    public static class NamedObject {  
        XContentBuilder b = MediaTypeRegistry.JSON.contentBuilder();
            () -> objectParser.declareField(null, (r, c) -> null, new ParseField("test"), ObjectParser.ValueType.STRING)
                this.parser = parser;
        assertEquals(s.test, "foo");  
        assertThat(
            this.name = name;  
        }
    public void testUseClassicPullParsingSubParser() throws IOException {  
        XContentParser parser = createParser(JsonXContent.jsonXContent, bytes);
    public void testIgnoreUnknownFields() throws IOException {  
        builder.field("long_field", randomBoolean() ? "4" : 4);
    }
        public void setObjectArray(List<StaticTestStruct> objectArray) {
    }
        parser = createParser(JsonXContent.jsonXContent, "{\"b\": \"123\"}");
    @Override
        parser = createParser(JsonXContent.jsonXContent, "{\"test_array\": 42}");
            )  
        }
            fields.put(key, value);
            public void setNullableIntField(int nullableIntField) {
            assertEquals("[1:2] [test] unknown field [not_supported_field]", ex.getMessage());
        assertNotNull(s.object);
        class TestStruct {
    public void testFailOnValueType() throws IOException {
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"numeric_value\" : false}");  
import org.opensearch.core.xcontent.ObjectParser;
            public void setDouble_field(double double_field) {
import static org.hamcrest.Matchers.nullValue;
    }  
        }
import org.opensearch.core.xcontent.ContextParser;  
        objectParser.declareBoolean(TestStruct::setNull_value, new ParseField("boolean_field"));
                this.int_array_field = int_array_field;
        assertEquals(  
        }  
        StaticTestStruct s = objectParser.parse(parser, null);
        objectParser.declareFloat(TestStruct::setFloat_field, new ParseField("float_field"));
        Map<String, Object> fields = new HashMap<>();
            PARSER.declareNamedObject(NamedObjectHolder::setNamed, NamedObject.PARSER, new ParseField("named"));
            "named_object_holder",
import java.util.HashMap;
        }
        byte[] bytes = ((ByteArrayOutputStream) b.getOutputStream()).toByteArray();
            double nullableDoubleField;
import org.opensearch.core.xcontent.XContentParserUtils;
        } else {
import org.opensearch.common.CheckedFunction;  
            this.a = value;
        assertTrue(h.namedSuppliedInOrder);
    public void testParseNamedObject() throws IOException {
import org.opensearch.core.ParseField;
            namedSuppliedInOrder = true;
        parser.declareString(AtomicReference::set, new ParseField("body"));
        if (nullValue) {
        b.flush();  
        parser.declareField((a, b) -> {}, (p, c) -> null, new ParseField("noop"), ValueType.STRING_ARRAY);
        private Long a;
            TopLevelNamedXConent o = TopLevelNamedXConent.PARSER.parse(parser, null);
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": { \"a\": {} }}");
    }
            IllegalArgumentException.class,  
        assertEquals("a", h.named.get(0).name);
            public void setTestNumber(int testNumber) {  
            b.endArray();
            }  
                    return this.parser.parseURI(parser);  
            ObjectParser<NamedObject, Void> parser = new ObjectParser<>("named");  
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {} ]}");
                (CheckedFunction<XContentParser, Object, IOException>) null,  
            builder.array("float_array_field", randomBoolean() ? "3.1" : 3.1);
    public void testObjectOrNullWhenNonNull() throws IOException {
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"test\" : 1, \"object\" : { \"test\": 2}}");
        XContentParser badmulti = createParser(JsonXContent.jsonXContent, "{\"a\" : 1, \"b\" : 2, \"c\" : 3, \"d\" : 4 }");
        }
import java.net.URI;
            public URI parseURI(XContentParser parser) {
        e = expectThrows(  
            "test",  
        if (randomBoolean()) {  
    }
        assertThat(obj.a, nullValue());
        TestStruct s = new TestStruct();  
            ObjectWithArbitraryFields::new
                    throw new UncheckedIOException(e);
            public String test;  
            () -> parser.parse(createParser(JsonXContent.jsonXContent, "{\"noop\": {\"body\": \"shouldn't\"}}"), null)
        b.endObject();  
        TestStruct s = objectParser.parse(parser, new TestStruct(), null);
            TopLevelNamedXConent o = TopLevelNamedXConent.PARSER.parse(parser, null);  
        objectParser.declareRequiredFieldSet(new String[] { "a", "b" });
            containsString(
            () -> objectParser.declareField((o, v) -> {}, (r, c) -> null, new ParseField("test"), null)
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
            this.c = value;
    public void testParseNamedObjectUnexpectedArray() throws IOException {
        int foo;  
    public void testParseNamedObjects() throws IOException {
        builder.field("double_field", randomBoolean() ? "2.1" : 2.1d);
        if (randomBoolean()) {
import java.util.List;  
        objectParser.declareObjectArray(StaticTestStruct::setObjectArray, objectParser, new ParseField("object_array"));
            String string_field;  
            XContentParseException ex = expectThrows(XContentParseException.class, () -> objectParser.parse(parser, s, null));
        }
                this.uri = uri;
import java.util.concurrent.atomic.AtomicReference;
            builder.nullField("nullable_int_field");
            () -> objectParser.declareField((o, v) -> {}, (r, c) -> null, null, ObjectParser.ValueType.STRING)
        assertEquals("baz", h.bar);
            TopLevelNamedXConent::new  
                        } else {
            List<Long> long_array_field;
            assertEquals(4.0F, o.named);  
import static org.hamcrest.Matchers.equalTo;  
        obj = objectParser.apply(parser, null);
        Exception e = expectThrows(XContentParseException.class, () -> objectParser.parse(parser, s, null));  
                new NamedXContentRegistry.Entry(Object.class, new ParseField("bool"), p -> p.booleanValue())
            () -> parser.parse(createParser(JsonXContent.jsonXContent, "{\"noop\": [{\"garbage\": \"shouldn't\"}}]"), null)  
        objectParser.declareField((i, c, x) -> c.test = i.text(), new ParseField("numeric_value"), ObjectParser.ValueType.FLOAT);
            assertNull(parse.string_or_null);
        objectParser.declareRequiredFieldSet(new String[] { "c", "d" });  
        int expectedNullableInt;
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"a\": \"123\"}");  
                }  
        assertNotNull(s.objectArray);
        AtomicReference<String> parsed = parser.parse(createParser(JsonXContent.jsonXContent, "{}"), context);
        assertThat(obj.a, equalTo(123L));
        }
            builder.field("nullable_double_field", expectedNullableDouble);
        StaticTestStruct s = objectParser.parse(parser, null);
        op.declareString(ObjectWithArbitraryFields::setName, new ParseField("name"));  
    }  
                NamedObject.PARSER,  
            public void setName(String name) {
        XContentParser parser = createParser(  
        private void setA(long value) {
        class TestStruct {
    // singular
            public String test;
                + "  \"test\" : \"foo\",\n"
    }
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
        }
            }
        assertEquals("a", h.named.name);
            public void setString_or_null(String string_or_null) {
    }
                (o, v) -> {},
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
        ObjectParser<Void, Void> objectParser = new ObjectParser<>("foo");
            this.test = test;
        }  
        assertThat(
        assertEquals(parse.float_field, 3.1f, 0.0f);
        objectParser.declareInt(TestStruct::setTestNumber, new ParseField("test_number"));  
        }  
            int int_field;  
import java.util.Map;
        b.startObject();
        );
        );
        public static final ObjectParser<TopLevelNamedXConent, Void> PARSER = new ObjectParser<>(
            builder.field("long_array_field", randomBoolean() ? "4" : 4);  
        private Long d;
 *
    public void testParseNamedObjectsJunkInArray() throws IOException {
            double double_field;
        public void setFoo(int foo) {  
        );  
                new ParseField("named")
    }
        s = new TestStruct();
        XContentParseException sneakyError = expectThrows(  
                + "FieldParser{preferred_name=test, supportedTokens=[VALUE_STRING], type=STRING}, "  
        assertThat(s.object, equalTo(nullMarker));
        objectParser.declareField((i, c, x) -> c.test = i.text(), new ParseField("test"), ObjectParser.ValueType.STRING);
        assertEquals(s.test, "foo");  
        XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString());
            float float_field;  
 * the Apache License, Version 2.0 (the "License"); you may
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"object\" : null}");
            public void setLong_array_field(List<Long> long_array_field) {
            expectedNullableDouble = randomDouble();  
        ObjectParser<NamedObjectsHolder, Void> objectParser = new ObjectParser<>("named_object_holder", NamedObjectsHolder::new);  
        assertEquals(s.ints, Arrays.asList(1, 2, 3, 4));
    public void testContextBuilder() throws IOException {
        static {
        assertFalse(h.namedSuppliedInOrder);  
        assertThat(s.testArray, hasSize(1));  
        assertEquals("expected value but got [FIELD_NAME]", garbageError.getCause().getMessage());
                this.float_field = float_field;
        }
                this.float_array_field = float_array_field;
            JsonXContent.jsonXContent,
        objectParser.parse(parser, s, null);
        assertThat(parse.nullableDoubleField, equalTo(expectedNullableDouble));  
                {
import java.util.Arrays;  
            containsString(  
            assertThat(cause.getCandidates(), containsInAnyOrder("str", "int", "float", "bool"));  
        class TestStruct {
        {  
        );  
    }
        assertThat(e.getMessage(), containsString("[named_objects_holder] failed to parse field [named]"));
        assertThat(  
        objectParser.declareObjectOrDefault(Foo::setURI, (p, s) -> s.parseURI(p), () -> null, new ParseField("url"));  
    public void testNoopDeclareObjectArray() {
import static org.hamcrest.Matchers.containsString;
            expectedNullableDouble = Double.NaN;
        objectParser.declareObjectOrNull(StaticTestStruct::setObject, objectParser, nullMarker, new ParseField("object"));  
            }  
 * The OpenSearch Contributors require contributions made to  
        b.flush();
        class Foo {
        objectParser.declareObjectOrDefault(StaticTestStruct::setObject, objectParser, StaticTestStruct::new, new ParseField("object"));
        {
            IllegalArgumentException.class,  
            CustomParseContext(ClassicParser parser) {  
        );
    public void testDeprecationWarnings() throws IOException {
        {  
            public void setURI(URI uri) {  
        parser = createParser(JsonXContent.jsonXContent, "{\"test_array\": [null]}");  
        );  
        assertEquals("i", parser.parse(createParser(JsonXContent.jsonXContent, "{\"body\": \"i\"}"), null).get());  
            this.named = named;  
        e = expectThrows(
        }  
        final String name;
                + "}"
        {
        parser.declareString(AtomicReference::set, new ParseField("body"));  
        XContentParser parser = createParser(  
        }
            }
        assertEquals("[parseField] is required", e.getMessage());
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo", true, TestStruct::new);
        public void setBar(String bar) {
        objectParser.declareLong(TestStruct::setB, new ParseField("b"));
        {  
import org.opensearch.core.xcontent.XContentParser;  
        objectParser.declareNamedObjects(NamedObjectsHolder::setNamed, NamedObject.PARSER, new ParseField("named"));
            TestStruct s = objectParser.parse(parser, new TestStruct(), null);
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"bool\": false}");  
        }  
        objectParser.declareDouble(TestStruct::setDouble_field, new ParseField("double_field"));
            assertEquals(s.test, TestEnum.FOO);
        objectParser.declareInt(StaticTestStruct::setTest, new ParseField("test"));  
            e.getCause().getMessage(),
    public void testNoopDeclareObject() throws IOException {
        TestStruct s = objectParser.parse(parser, new TestStruct(), null);  
            public String test;  
                new NamedXContentRegistry.Entry(Object.class, new ParseField("float"), p -> p.floatValue()),
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
        class TestStruct {
        ObjectWithArbitraryFields o = op.parse(parser, null);
                int port = 0;
    }
            }
            )
        assertEquals("foo", o.fields.get("test"));
                "[named] can be a single object with any number of fields "  
                ObjectParser.ValueType.STRING
        private Long b;  
        );  
        assertEquals(11, h.named.foo);  
     * together with the object parser
        TestStruct parse = objectParser.parse(parser, new TestStruct(), null);  
            }
    }  
                this.b = value;
        builder.field("float_field", randomBoolean() ? "3.1" : 3.1f);
            public void setString_field(String string_field) {  
        objectParser.declareInt(TestStruct::setInt_field, new ParseField("int_field"));  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        assertThat(e.getMessage(), containsString("[foo] numeric_value doesn't support values of type: VALUE_BOOLEAN"));
            "{ \"test\" : \"foo\", \"test_number\" : 2, \"test_array\": [1,2,3,4] }"
            PARSER = (XContentParser p, Void v, String name) -> parser.parse(p, new NamedObject(name), null);
        List<StaticTestStruct> objectArray;
        }
        assertNotNull(s.object);
        ObjectParser<AtomicReference<String>, Void> parser = new ObjectParser<>("noopy", AtomicReference::new);
        objectParser.declareRequiredFieldSet(new String[] { "a", "b" });
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectsHolder.PARSER.apply(parser, null));
            }  
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"not_supported_field\" : \"foo\"}");
            int testNumber;  
            this.named = named;
        private void setD(long value) {
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {\"a\": {}} ] }");
        objectParser.declareObject(StaticTestStruct::setObject, objectParser, new ParseField("object"));  
    }
        assertThat(parse.nullableIntField, equalTo(expectedNullableInt));
        }
            TestStruct::setArray,  
package org.opensearch.common.xcontent;
        static {
 * SPDX-License-Identifier: Apache-2.0
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"test\" : \"foo\"}");
        TestStruct s = new TestStruct();  
    }
        e = expectThrows(IllegalArgumentException.class, () -> parser.parse(badmulti, null));  
            public void setString_array_field(List<String> string_array_field) {
        private boolean namedSuppliedInOrder = false;
        NamedObjectsHolder h = NamedObjectsHolder.PARSER.apply(parser, null);
 *    http://www.apache.org/licenses/LICENSE-2.0
        XContentParser parser2 = createParser(JsonXContent.jsonXContent, "{\"int_array\": [1, null, 3]}");
import org.opensearch.test.OpenSearchTestCase;
    public void testRequiredFieldSet() throws IOException {
        objectParser.declareIntArray(TestStruct::setInts, new ParseField("test_array"));
            assertTrue(ex.getCause() instanceof NumberFormatException);
        }
            JsonXContent.jsonXContent,
     */
        assertArrayEquals(parse.string_array_field.toArray(), Collections.singletonList("5").toArray());
            e.getCause().getMessage(),  
                this.string_field = string_field;
        String context = randomAlphaOfLength(5);  
        }
            JsonXContent.jsonXContent,
        );
        if (randomBoolean()) {
        void setName(String name) {
        assertEquals(s.test, "foo");
        }
                (o, v) -> {},
            equalTo("Required one of fields [a, b], but none were specified. " + "Required one of fields [c, d], but none were specified. ")
        }
        assertEquals("foo", s.test);
        byte[] bytes = ((ByteArrayOutputStream) b.getOutputStream()).toByteArray();  
        b = shuffleXContent(b);
            }
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named]"));
        public void setObject(StaticTestStruct object) {
        obj = objectParser.apply(parser, null);
        } else {
            public String test;
        }
            IllegalStateException.class,
        assertThat(ex.getMessage(), containsString("[foo] failed to parse field [int_array]"));
        assertNull(s.testArray.get(0));
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
                        fieldName = parser.currentName();  
            b.field("test", "foo");
        objectParser.declareField((i, c, x) -> c.test = i.text(), new ParseField("test"), ObjectParser.ValueType.STRING);
        StaticTestStruct nullMarker = new StaticTestStruct();  
            TopLevelNamedXConent o = TopLevelNamedXConent.PARSER.parse(parser, null);
    static class StaticTestStruct {
                        if (fieldName.equals("host")) {
    public void testEmptyObjectInArray() throws IOException {
            "{\"url\" : { \"host\": \"http://foobar\", \"port\" : 80}, \"name\" : \"foobarbaz\"}"
        );  
                NamedObjectsHolder::keepNamedInOrder,
        }
            this.object = object;
                + "FieldParser{preferred_name=test_number, supportedTokens=[VALUE_STRING, VALUE_NUMBER], type=INT}]}"
        objectParser.declareLong(TestStruct::setB, new ParseField("b"));
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
                (ContextParser<Void, Object>) null,
            PARSER.declareString(NamedObjectHolder::setBar, new ParseField("bar"));  
                new NamedXContentRegistry.Entry(Object.class, new ParseField("int"), p -> p.intValue()),  
        assertThat(parsed.get(), equalTo(context));
            this.b = value;  
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ \"junk\" ] }");
    }  
        assertThat(e.getMessage(), containsString("[named_object_holder] named doesn't support values of type: START_ARRAY"));
        );  
        assertEquals(s.object.test, 2);
                + "  \"test_nested\": { \"field\" : \"value\", \"field2\" : [ \"list1\", \"list2\" ] }\n"
        objectParser.declareField((i, v, c) -> v.test = i.text(), new ParseField("test", "old_test"), ObjectParser.ValueType.STRING);
            boolean null_value;  
        if (randomBoolean()) {  
    }
        parser = createParser(JsonXContent.jsonXContent, "{\"object\" : false }");
        // Make sure that we didn't break the null handling in arrays that shouldn't support nulls  
                b.startObject();
                "[named] can be a single object with any number of fields "
        assertArrayEquals(parse.int_array_field.toArray(), Collections.singletonList(1).toArray());
        );
            builder.field("int_array_field", randomBoolean() ? "1" : 1);
 * You may obtain a copy of the License at  
        assertWarnings(false, "[foo][1:15] Deprecated field [old_test] used, expected [test] instead");
            () -> parser.parse(createParser(JsonXContent.jsonXContent, "{\"noop\": [{\"body\": \"shouldn't\"}}]"), null)
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo", true, null);  
                    }
        );  
            ValueType.VALUE_ARRAY  
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
            URI parseURI(XContentParser parser) throws IOException {
    }
            public int test;
import java.io.ByteArrayOutputStream;
        assertEquals(6, o.fields.size());
        objectParser.declareLong(TestStruct::setA, new ParseField("a"));
        objectParser = new ObjectParser<>("foo", true, TestStruct::new);
        b.endObject();  
        assertEquals(s.object.test, 2);  
public class ObjectParserTests extends OpenSearchTestCase {  
    }
            List<Float> float_array_field;  
        void setNamed(Object named) {
                test = value;
            }
            )
import static org.hamcrest.Matchers.hasSize;
            "{ \"test_array\": [ 1, null, \"3\", 4.2], \"int_array\":  [ 1, 2, 3] }"
        assertEquals("expected value but got [FIELD_NAME]", sneakyError.getCause().getMessage());
                        }  
            }
        objectParser.declareStringOrNull(TestStruct::setString_or_null, new ParseField("string_or_null"));
        parser.declareLong(TestStruct::setA, new ParseField("a"));
            }  
            b.field("test", "foo");
                b.endObject();
            public void set(TestEnum value) {
    private static class TestStruct {
    }  
        assertThat(e.getMessage(), containsString("[named_objects_holder] failed to parse field [named]"));
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"not_supported_field\" : \"foo\"}");
        Object named;  
        XContentParser parser = createParser(XContentType.JSON.xContent(), "{\"old_test\" : \"foo\"}");
        }
                this.testArray = testArray;
            public void setInt_array_field(List<Integer> int_array_field) {
            public String test;  
    }  
            expectedNullableInt = -1;  
        XContentParser goodA = createParser(JsonXContent.jsonXContent, "{\"a\" : 1, \"c\" : 4}");
        }  
            this.named = named;
        s = new TestStruct();
                + "FieldParser{preferred_name=test_array, supportedTokens=[START_ARRAY, VALUE_STRING, VALUE_NUMBER], type=INT_ARRAY}, "
            e.getMessage(),
    enum TestEnum {
        assertEquals(s.object.test, 0);
        b.startObject();  
    private static class ObjectWithArbitraryFields {
                    parser.nextToken();
        } else {
            Object.class,
            this.objectArray = objectArray;  
            TopLevelNamedXConent o = TopLevelNamedXConent.PARSER.parse(parser, null);
                String host = "";
            builder.field("double_array_field", randomBoolean() ? "2.1" : 2.1d);  
            private Long a;  
        objectParser.declareString(TestStruct::setString_field, new ParseField("string_field"));
            builder.array("double_array_field", randomBoolean() ? "2.1" : 2.1d);
            builder.array("int_array_field", randomBoolean() ? "1" : 1);  
            builder.array("long_array_field", randomBoolean() ? "4" : 4);
        class TestStruct {
                    } else if (token == XContentParser.Token.VALUE_STRING) {
            b.startObject("junk");  
            objectParser.declareString((struct, value) -> struct.set(TestEnum.valueOf(value)), new ParseField("test"));
            public void setInts(List<Integer> ints) {
        private NamedObject named;  
        } else {
                this.int_field = int_field;
        parser.declareLong(TestStruct::setC, new ParseField("c"));  
        assertEquals("[consumer] is required", e.getMessage());  
            }
        assertThat(e.getMessage(), containsString("[named_objects_holder] failed to parse field [named]"));  
            }
        assertThat(h.named, hasSize(1));  
    }
        }
        XContentParseException ex = expectThrows(XContentParseException.class, () -> objectParser.parse(parser2, s2, null));  
            }
            builder.field("float_array_field", randomBoolean() ? "3.1" : 3.1);  
import org.opensearch.common.xcontent.json.JsonXContent;
import java.util.Collections;
            );  
            ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
        b.flush();
        assertEquals(s.testArray, Arrays.asList(1, null, "3", 4.2));
        TestStruct actualA = parser.parse(goodA, null);
    }
            public TestEnum test;
            XContentParseException.class,
        XContentParseException garbageError = expectThrows(
 * this work for additional information regarding copyright
        StaticTestStruct s = objectParser.parse(parser, null);
        assertEquals("[type] is required", e.getMessage());  
        }
        public NamedObject(String name) {
        StaticTestStruct s = objectParser.parse(parser, null);
            assertEquals(1, o.named);
    public void testNullDeclares() {  
            "unknown",
        TestStruct s2 = new TestStruct();
        XContentBuilder b = MediaTypeRegistry.JSON.contentBuilder();
        objectParser.parse(parser, s, null);  
}
        }
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"test\" : \"FOO\" }");  
        parser.declareLong(TestStruct::setD, new ParseField("d"));
        );
        private Long c;
                throw new IllegalArgumentException("Only one [named] allowed!");
        b = shuffleXContent(b);
    public void testTopLevelNamedXContent() throws IOException {
        e = expectThrows(
    public void testIgnoreUnknownObjects() throws IOException {
            public final ClassicParser parser;
        {  
        assertEquals(s.testNumber, 2);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parser.parse(bad, null));  
import java.util.ArrayList;
    public void testParseNested() throws IOException {
            () -> objectParser.declareField(
        class TestStruct {
        Exception e = expectThrows(
        b.endObject();
    }
        XContentParser parser = createParser(JsonXContent.jsonXContent, bytes);
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {\"a\": {}} ] }");  
        }  
        s.object = new TestStruct();  
        private void setB(long value) {
        assertEquals("i", parser.parse(createParser(JsonXContent.jsonXContent, "{\"body\": \"i\"}"), null).get());  
 * ownership. Elasticsearch licenses this file to you under  
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ \"a\": {\"foo\" : 11} }]");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean nullValue = randomBoolean();
            JsonXContent.jsonXContent,
            public String name;
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
        );  
        public void setTest(int test) {  
                        }  
        assertEquals(s.object.test, 2);  
 *
        }
        objectParser.declareLong(TestStruct::setB, new ParseField("b"));  
        XContentParser bad = createParser(JsonXContent.jsonXContent, "{\"a\" : 1, \"b\" : 2}");  
    }  
    public void testExceptions() throws IOException {
        TestStruct s = objectParser.parse(parser, new TestStruct(), null);
 * this file be licensed under the Apache-2.0 license or a
        objectParser.declareObject(StaticTestStruct::setObject, objectParser, new ParseField("object"));  
        class ClassicParser {
            }  
                + "  \"test_array\":  [1,2,3,4],\n"  
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"object\" : {}}");
 * under the License.  
    }
            public void setInt_field(int int_field) {  
        parser.declareExclusiveFieldSet("c", "d");  
        }
                this.string_array_field = string_array_field;  
 * KIND, either express or implied.  See the License for the
        XContentParseException e = expectThrows(XContentParseException.class, () -> objectParser.apply(parser, null));
            b.field("test", "foo");
        objectParser.declareField((i, c, x) -> objectParser.parse(parser, c.object, null), new ParseField("object"), ValueType.OBJECT);
        objectParser.declareLong(TestStruct::setC, new ParseField("c"));  
 * not use this file except in compliance with the License.
    public void testBasics() throws IOException {
            XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"test\" : \"FOO\" }");
        XContentBuilder b = MediaTypeRegistry.JSON.contentBuilder();
import static org.hamcrest.Matchers.instanceOf;
        ObjectParser<AtomicReference<String>, Void> parser = new ObjectParser<>("noopy", AtomicReference::new);
        if (randomBoolean()) {  
            if (this.named != null) {  
            builder.field("boolean_field", Boolean.toString(nullValue));  
        Exception e = expectThrows(
            objectParser.toString(),
            NamedObjectHolder::new
        assertEquals(parse.string_field, "5");  
            int nullableIntField;
                + "  \"test_boolean\" : true,\n"
    }  
        objectParser.parse(parser, s, null);
        objectParser.declareStringArray(TestStruct::setString_array_field, new ParseField("string_array_field"));
            }
        assertThat(h.named, hasSize(1));
        }  
        builder.field("string_or_null", nullValue ? null : "5");
import org.opensearch.core.xcontent.XContentBuilder;
                this.null_value = null_value;
        }
    }
        NamedObjectsHolder h = NamedObjectsHolder.PARSER.apply(parser, null);  
 * compatible open source license.
        );
        assertThat(s.testArray, hasSize(1));  
        if (randomBoolean()) {  
                this.long_field = long_field;  
            ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
        {  
        // Now firing the xml through it fails  
        objectParser.declareObjectOrNull(StaticTestStruct::setObject, objectParser, nullMarker, new ParseField("object"));  
        );
        public void setNamed(List<NamedObject> named) {  
            List<Integer> ints = new ArrayList<>();
    public void testParseNamedObjectsInOrder() throws IOException {  
        private String bar;
        assertEquals(parse.double_field, 2.1d, 0.0d);
    }  
            )  
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
        assertThat(obj.b, nullValue());
        assertThat(e.getMessage(), containsString("The following fields are not allowed together: [a, b]"));
 *  
    public void testNoopDeclareField() throws IOException {
            }
            )  
import java.io.UncheckedIOException;  
        assertThat(o.fields.get("test_nested"), instanceOf(Map.class));
                        if (fieldName.equals("port")) {
        assertEquals(parse.long_field, 4L);  
        assertEquals(s.name, "foobarbaz");
        private List<NamedObject> named;  
            }  
        }  
        TestStruct obj = objectParser.apply(parser, null);  
            public void setInts(List<Integer> ints) {  
        assertEquals(2, o.fields.get("test_number"));  
    }
        TestStruct s = new TestStruct();  
        }  
        } else {
        assertArrayEquals(parse.double_array_field.toArray(), Collections.singletonList(2.1d).toArray());
        TestStruct s = new TestStruct();  
        objectParser.declareField((i, c, x) -> c.test = i.intValue(), new ParseField("test"), ValueType.INT);
            assertEquals(ex.getMessage(), "[1:2] [the_parser] unknown field [not_supported_field]");  
        assertEquals("parser for [noop] did not end on END_OBJECT", sneakyException.getMessage());
            expectedNullableInt = randomInt();
    public void testConsumeUnknownFields() throws IOException {  
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo", true, null);
            public void setNullableDoubleField(double nullableDoubleField) {
    public void testAllVariants() throws IOException {  
        assertThat(obj.b, equalTo(456L));
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo", true, null);
        objectParser.declareLong(TestStruct::setB, new ParseField("b"));
    }
        Exception garbageException = expectThrows(
        );
            private void setB(long value) {
        } else {
                this.long_array_field = long_array_field;  
        ObjectParser<TestStruct, Void> parser = new ObjectParser<>("foo", TestStruct::new);  
        {
    }
        assertThat(actualA.a, equalTo(1L));  
        ObjectParser<TestStruct, Void> objectParser = new ObjectParser<>("foo");
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": { \"a\": {\"foo\" : 11} }, \"bar\": \"baz\"}");  
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {\"a\": {}, \"b\": {}}]}");  
import org.opensearch.core.xcontent.ObjectParser.ValueType;  
        assertEquals(s.testArray, Collections.singletonList(42));
        objectParser.declareRequiredFieldSet(new String[] { "a", "b" });  
        ObjectParser<StaticTestStruct, Void> objectParser = new ObjectParser<>("foo", StaticTestStruct::new);
        assertEquals("[parser] is required", e.getMessage());
                } catch (IOException e) {
        objectParser.parse(parser, s, null);  
        objectParser.declareLongArray(TestStruct::setLong_array_field, new ParseField("long_array_field"));
            assertEquals(s.test, TestEnum.FOO);
        parser.declareLong(TestStruct::setB, new ParseField("b"));
        s = new TestStruct();
        }  
        ObjectParser<AtomicReference<String>, String> parser = ObjectParser.fromBuilder("test", AtomicReference::new);
        parser.declareExclusiveFieldSet("a", "b");
        }  
        NamedObjectHolder h = NamedObjectHolder.PARSER.apply(parser, null);
        objectParser.declareLong(TestStruct::setA, new ParseField("a"));
            builder.field("string_array_field", "5");  
        TestStruct s = new TestStruct();
        assertEquals(s.ints, Arrays.asList(1, 2, 3));
        builder.field("string_field", "5");
        return new NamedXContentRegistry(  
