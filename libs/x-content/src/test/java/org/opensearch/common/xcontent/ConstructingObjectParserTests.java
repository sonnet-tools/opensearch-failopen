            this.b = b;
        );
        );  
            // The following JSON needs to include newlines, in order to affect the line numbers  
            assertEquals(expected.a, parsed.a);  
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {\"a\": {}} ], \"named_in_constructor\": [ {} ]}");
        }
 * specific language governing permissions and limitations
            assertEquals(expected.vegetable, parsed.vegetable);  
            );
    public void testConstructorArgsMustBeConfigured() throws IOException {  
        public void keepNamedInOrder() {  
import static org.hamcrest.Matchers.nullValue;
        XContentParser parser = createParser(
        e = (XContentParseException) e.getCause();  
        parser.declareRequiredFieldSet("a", "b");
        if (ctorArgOptional) {  
            if (args[0] != null) {  
        public static final ConstructingObjectParser<HasCtorArguments, Void> PARSER_VEGETABLE_OPTIONAL = buildParser(true, false);  
    public void testParseNamedObjectNoFieldsInArray() throws IOException {  
            a -> new NamedObjectHolder(((List<NamedObject>) a[0]))
        class TestStruct {
                throw new IllegalArgumentException("[a] must be less than 10 characters in length but was [" + a + "]");
        HasCtorArguments expected = new HasCtorArguments(randomAlphaOfLength(5), randomInt());  
                    + "or an array where each entry is an object with a single field"
            TestStruct(String test) {
        XContentParseException e = expectThrows(  
        e = expectThrows(
                builder.field("d", d);
    }
    /**  
        e = expectThrows(
        String b;
        expected.setC(randomBoolean() ? null : randomAlphaOfLength(5));
            // and without the constructor arg if we've made it optional
    public void testParseNamedObjectInOrder() throws IOException {  
        assertThat(e.getMessage(), containsString("Required one of fields [a, b], but none were specified."));  
        public void setNamed(List<NamedObject> named) {
        parser.declareExclusiveFieldSet("a", "b");
        }
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"animal\": \"dropbear\", \"mineral\": -8 }");
            () -> objectParser.declareField((o, v) -> {}, (r, c) -> null, new ParseField("test"), null)  
 *  
    }  
import static org.hamcrest.Matchers.anyOf;
import org.opensearch.core.ParseField;
 * software distributed under the License is distributed on an
            assertEquals(expected.c, parsed.c);
        result = parser.apply(xcontent, null);  
            public final String test;
                builder.field("b", b);
                false,
        assertEquals("[named] doesn't support arrays. Use a single object with multiple fields.", e.getCause().getMessage());
        }
                }"""
 * Modifications Copyright OpenSearch Contributors. See
            e.getCause().getMessage()
        assertThat(  
        ConstructingObjectParser<Void, Void> objectParser = new ConstructingObjectParser<>("foo", a -> null);  
        assertThat(h.namedInConstructor, hasSize(1));
        @SuppressWarnings("unchecked")  
        // Now firing the xml through it fails  
            assertEquals(expected.fruit, parsed.fruit);
                {  
            }
                "has_required_arguments",
        );
            "named_object_holder",
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named]"));  
    public void testBadParamBeforeObjectBuilt() throws IOException {  
            "{\"named\": [\n" + "  {\"a\": {}}" + "],\"named_in_constructor\": {\"b\": {}}" + "}"
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> HasCtorArguments.PARSER.apply(parser, null));
    public void testMissingAllConstructorArgs() throws IOException {
        );
        XContentParser parser = createParser(
        XContentParser notenough = createParser(JsonXContent.jsonXContent, "{ }");  
            a -> new NamedObjectHolder(((List<NamedObject>) a[0]))  
            this.c = c;  
    }
        assertThat(e.getMessage(), containsString("failed to build [has_required_arguments] after last required field arrived"));
            PARSER.declareNamedObjects(
        );
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));
    }
        // ctor arg first so we can test for the bug we found one time
                    + "use ObjectParser instead of ConstructingObjectParser. This is a bug in the parser declaration.",  
    }  
     * Tests the non-constructor fields are only set on time.
                    // either(yeahMatcher).or(nullValue) is broken by https://github.com/hamcrest/JavaHamcrest/issues/49  
                new ParseField("test"),  
            NamedObject.PARSER,
import org.opensearch.core.xcontent.ContextParser;
        String a;  
                  "animal": "cat",
        public void setD(boolean d) {  
                this.a = null;
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
package org.opensearch.common.xcontent;
        XContentParser parser = createParser(
        );
        assertEquals("dropbear", parsed.animal);
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named_in_constructor]"));
                "[named] can be a single object with any number of fields "  
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1, \"animal\": \"cat\" }");  
                    + "or an array where each entry is an object with a single field"  
        }  
    }  
            e.getCause().getMessage(),  
        private static ConstructingObjectParser<HasCtorArguments, Void> buildParser(boolean animalRequired, boolean vegetableRequired) {  
        public void setMineral(int mineral) {
        // Create our own parser for this test so we can disable support for the "ordered" mode specified by the array above
                new ParseField("test"),
        NamedObjectHolder h = NamedObjectHolder.PARSER.apply(parser, null);
        );
            e.getCause().getMessage(),
        private List<NamedObject> named;  
        ConstructingObjectParser<NamedObjectHolder, Void> objectParser = new ConstructingObjectParser<>(
            TestStruct(String a) {
                (CheckedFunction<XContentParser, Object, IOException>) null,
            }
        );  
            () -> objectParser.declareField(  
        objectParser.declareNamedObjects(
     */
            builder.field("animal", animal);
        int mineral;
public class ConstructingObjectParserTests extends OpenSearchTestCase {
        e = expectThrows(  
            HasCtorArguments parsed = randomFrom(HasCtorArguments.ALL_PARSERS).apply(parser, null);
            )  
            }
        NamedObjectHolder(List<NamedObject> namedInConstructor) {
 * this work for additional information regarding copyright
        assertThat(e.getMessage(), containsString("[has_required_arguments] failed to parse field [vegetable]"));
        );
        expected.setFruit(randomInt());
                this.test = test;
    public void testMissingAllConstructorArgsButNotRequired() throws IOException {
        assertThat(e.getMessage(), containsString("[has_required_arguments] failed to parse field [a]"));
        class CalledOneTime {
        assertEquals("[parser] is required", e.getMessage());
            "[a] must be less than 10 characters in length but was [supercalifragilisticexpialidocious]",
            new ParseField("named_in_constructor")
            parser.declareString(animalRequired ? constructorArg() : optionalConstructorArg(), new ParseField("animal"));
            this.mineral = mineral;
        XContentParser ok = createParser(JsonXContent.jsonXContent, "{ \"a\" : \"a\" }");
            parser,  
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1 }");  
        assertEquals(1, parsed.mineral);
    public void testParseNamedObjectJunkInArrayConstructorArg() throws IOException {  
    public void testMissingSecondConstructorArg() throws IOException {
        private static void declareSetters(ConstructingObjectParser<HasCtorArguments, ?> parser) {
            if (a != null && a.length() > 9) {
    public void testParseNamedObjectTwoFieldsInArrayConstructorArg() throws IOException {
        public static final ConstructingObjectParser<HasCtorArguments, Integer> PARSER_INT_CONTEXT = buildContextParser();
            JsonXContent.jsonXContent,
        // Now firing the xml through it fails
        assertEquals("Required [vegetable]", e.getMessage());
    }
 * Licensed to Elasticsearch under one or more contributor  
        );
            IllegalArgumentException.class,
        assertThat(actual.a, equalTo("a"));
    public void testRandomOrder() throws Exception {
        }
 * this file be licensed under the Apache-2.0 license or a
            JsonXContent.jsonXContent,
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named]"));
        parser.declareString(ctorArgOptional ? optionalConstructorArg() : constructorArg(), new ParseField("yeah"));  
        assertThat(  
            }
        }
        @Override
                NamedObjectHolder::keepNamedInOrder,
import org.hamcrest.Matcher;  
        XContentParseException e = expectThrows(XContentParseException.class, () -> objectParser.apply(parser, null));
            );
        assertTrue(result.fooSet);
        HasCtorArguments parsed = randomFrom(HasCtorArguments.PARSER_VEGETABLE_OPTIONAL, HasCtorArguments.PARSER_ALL_OPTIONAL).apply(
import static org.hamcrest.Matchers.hasSize;
            builder.field("vegetable", vegetable);
        boolean d;  
        XContentParser parser = createParser(
     */
            JsonXContent.jsonXContent,
            e.getCause().getMessage()
                builder.field("a", a);
            NamedObject.PARSER,  
        XContentParser toomany = createParser(JsonXContent.jsonXContent, "{ \"a\" : \"a\", \"b\" : 1 }");
                builder.field("mineral", mineral);
            "[a] must be less than 10 characters in length but was [supercalifragilisticexpialidocious]",
            e.getCause().getMessage(),  
import org.opensearch.core.xcontent.ToXContentObject;
                return new TestStruct((String) args[0]);
        }
        HasCtorArguments parsed = HasCtorArguments.PARSER_ALL_OPTIONAL.apply(parser, null);
            )
            );  
     * Builds the object in random order and parses it.  
        e = (XContentParseException) e.getCause();  
        public void setFruit(int fruit) {
    }  
    }
        HasCtorArguments(@Nullable String animal, @Nullable Integer vegetable) {
            parser.declareInt(vegetableRequired ? constructorArg() : optionalConstructorArg(), new ParseField("vegetable"));  
        NamedObjectHolder h = NamedObjectHolder.PARSER.apply(parser, null);
                new ParseField("named")
            () -> randomFrom(HasCtorArguments.PARSER, HasCtorArguments.PARSER_VEGETABLE_OPTIONAL).apply(parser, null)  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"test\" : \"foo\", \"junk\" : 2 }");  
                  "animal": "cat",
 *
    }
        assertEquals("b", h.namedInConstructor.get(0).name);  
 * under the License.  
        });
            JsonXContent.jsonXContent,
            ConstructingObjectParser.constructorArg(),
            containsString(
    }  
        assertThat(h.named, hasSize(1));  
                (args, ctx) -> new HasCtorArguments((String) args[0], ctx)  
        );
            return parser;
        XContentParser xcontent = createParser(JsonXContent.jsonXContent, "{ \"yeah\": \"!\", \"foo\": \"foo\" }");  
        builder.flush();
        );  
        TestStruct s = objectParser.apply(parser, null);
        @Nullable
            result = parser.apply(xcontent, null);  
            parser.declareBoolean(HasCtorArguments::setD, new ParseField("d"));
        assertEquals(  
 * SPDX-License-Identifier: Apache-2.0
        /*
    }  
            // The following JSON needs to include newlines, in order to affect the line numbers  
        assertEquals("[consumer] is required", e.getMessage());
import java.util.Arrays;
        XContentParser parser = createParser(  
    public void testParseNamedObject() throws IOException {
        expected.setD(randomBoolean());  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> objectParser.apply(parser, null));  
            "{\"named\": [ {\"a\": {}}], \"named_in_constructor\": [ {\"c\": {}, \"d\": {}} ]}"
    }
            "named_object_holder",
            }
                NamedObjectHolder::setNamed,
            () -> randomFrom(HasCtorArguments.ALL_PARSERS).apply(parser, null)
            )  
        }  
            if (c != null) {  
            ConstructingObjectParser.constructorArg(),  
        public static final ConstructingObjectParser<HasCtorArguments, Void> PARSER_ALL_OPTIONAL = buildParser(false, false);
            )
 * The OpenSearch Contributors require contributions made to  
    }  
            return builder;
        assertFalse(h.namedSuppliedInOrder);  
import static org.hamcrest.Matchers.containsString;
            JsonXContent.jsonXContent,
        assertEquals(s.test, "foo");  
        XContentParser parser = createParser(
         * It is normal just to declare a single PARSER but we use a couple of different parsers for testing so we have all of these. Don't
            JsonXContent.jsonXContent,  
            IllegalArgumentException.class,
            )
    public void testConstructObjectUsingContext() throws IOException {  
            }
import java.io.IOException;  
            "constructor_args_required",  
            (a) -> new CalledOneTime((String) a[0])  
            JsonXContent.jsonXContent,  
import org.opensearch.common.CheckedFunction;
            parser.apply(createParser(JsonXContent.jsonXContent, "{}"), null);
            "{\"named\": {\"a\": {}}, \"named_in_constructor\": [ {\"b\": {}} ]}"
 */  
        @SuppressWarnings("unchecked")
            this.fruit = fruit;  
            TestStruct(long b) {
            e.getCause().getMessage(),
            null
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named_in_constructor]"));
            assertEquals(expected.d, parsed.d);  
        @SuppressWarnings("unchecked")  
 * ownership. Elasticsearch licenses this file to you under  
        );  
        }
    public void testMissingFirstConstructorArg() throws IOException {
            }
            return parser;
                this.a = a;  
                assertThat(yeah, yeahMatcher);  
        );  
            IllegalArgumentException.class,
    }
            "{\"named\": { \"a\": {} }, \"named_in_constructor\": { \"b\": {} } }"
        }
        assertTrue(result.fooSet);
        objectParser.declareNamedObjects(NamedObjectHolder::setNamed, NamedObject.PARSER, new ParseField("named"));  
        );  
        static {  
            "foo",  
        xcontent = createParser(JsonXContent.jsonXContent, "{ \"foo\": \"foo\",  \"yeah\": \"!\" }");
        boolean ctorArgOptional = randomBoolean();
            declareSetters(parser);  
                ConstructingObjectParser.constructorArg(),
                    + "or an array where each entry is an object with a single field"
        assertEquals("a", h.named.get(0).name);  
            boolean fooSet = false;  
        public void setA(String a) {  
            );  
            (a) -> new NoConstructorArgs()
            final String a;
        public static final ConstructingObjectParser<NamedObjectHolder, Void> PARSER = new ConstructingObjectParser<>(
            assertEquals(expected.b, parsed.b);
    public void testParseNamedObjectNoFieldsInArrayConstructorArg() throws IOException {
        HasCtorArguments parsed = HasCtorArguments.PARSER_INT_CONTEXT.apply(parser, 42);
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1, \"vegetable\": 2 }");
            this.namedInConstructor = namedInConstructor;
    }  
                e.getMessage()
                builder.field("c", c);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, bytes)) {  
        assertEquals("[parseField] is required", e.getMessage());  
        assertEquals(  
            ConstructingObjectParser<HasCtorArguments, Integer> parser = new ConstructingObjectParser<>(  
        objectParser.declareNamedObjects(
        }
        }  
            parser.declareString(constructorArg(), new ParseField("animal"));
            if (b != null) {  
        );
            : HasCtorArguments.PARSER_VEGETABLE_OPTIONAL;
    public void testParseNamedObjectTwoFieldsInArray() throws IOException {
            a -> new TestStruct((String) a[0])
        parser.declareString(optionalConstructorArg(), new ParseField("a"));
 */
        ConstructingObjectParser<NamedObjectHolder, Void> objectParser = new ConstructingObjectParser<>(  
        assertEquals(1, parsed.mineral);
    }
        assertEquals("[parser] is required", e.getMessage());  
        HasCtorArguments parsed = HasCtorArguments.PARSER_ALL_OPTIONAL.apply(parser, null);
        assertThat(
            if (d) {  
         */
        );  
    }
        final Integer vegetable;  
        expected.setMineral(randomInt());
        }
                Matcher<String> yeahMatcher = equalTo("!");
    }  
        String c;
import java.util.List;
 * not use this file except in compliance with the License.
                  "vegetable": 2,
            containsString(  
        assertThat(
            PARSER.declareNamedObjects(
                if (ctorArgOptional) {
                (ContextParser<Void, Object>) null,
        assertEquals(2, e.getLineNumber());
        assertThat(e.getMessage(), containsString("allowed together: [a, b]"));  
            builder.startObject();  
            return new TestStruct((Long) args[1]);  
                    yeahMatcher = anyOf(yeahMatcher, nullValue());
            // included in the exception
            void setFoo(String foo) {
            this.d = d;
            if (mineral != 0) { // We're just using 0 as the default because it is easy for testing  
        public static final ConstructingObjectParser<HasCtorArguments, Void> PARSER = buildParser(true, true);
        assertEquals("a", h.named.get(0).name);
        // and ctor arg second just in case
                "has_required_arguments",
            containsString(
 * You may obtain a copy of the License at  
                (o, v) -> {},
            """
        assertEquals(Integer.valueOf(42), parsed.vegetable);  
        expected.setB(randomBoolean() ? null : randomAlphaOfLength(5));
                    + "or an array where each entry is an object with a single field"
        assertEquals(-8, parsed.mineral);
            assertEquals(expected.mineral, parsed.mineral);
        assertEquals("[type] is required", e.getMessage());
                  "a": "supercalifragilisticexpialidocious"  
        objectParser.declareNamedObjects(NamedObjectHolder::setNamed, NamedObject.PARSER, new ParseField("named"));
                "[named_in_constructor] can be a single object with any number of fields "
                this.b = b;  
    }
                "[named_in_constructor] can be a single object with any number of fields "
        assertEquals(4, e.getLineNumber());
        assertThat(actual.b, equalTo(0L));  
                ObjectParser.ValueType.STRING  
        } catch (AssertionError e) {  
import static org.hamcrest.Matchers.equalTo;  
         * this this style is normal just because it is in the test.  
        expected.setA(randomBoolean() ? null : randomAlphaOfLength(5));  
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named]"));
        }
    }  
        );  
            )
import static java.util.Collections.unmodifiableList;
                this.b = 0;
        // Create our own parser for this test so we can disable support for the "ordered" mode specified by the array above
        );  
            ? HasCtorArguments.PARSER
        ConstructingObjectParser<CalledOneTime, Void> parser = new ConstructingObjectParser<>(
    public void testParseNamedObjectInOrderNotSupported() throws IOException {
        XContentParser parser = createParser(  
            containsString("[named_in_constructor] doesn't support arrays. Use a single object with multiple fields.")
            a -> new NamedObjectHolder(((List<NamedObject>) a[0]))
            "{\"named\": [ \"junk\" ], \"named_in_constructor\": [ {\"a\": {}} ]}"
                fooSet = true;
        IllegalArgumentException e = expectThrows(
                "[named_in_constructor] can be a single object with any number of fields "  
            e.getCause().getMessage(),
            }  
import org.opensearch.common.xcontent.json.JsonXContent;
            "named_object_holder",  
            assertEquals(
            if (fruit != 0) {  
            "{\"named\": [ {\"a\": {}, \"b\": {}}], \"named_in_constructor\": [ {\"c\": {}} ]}"
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parser.parse(toomany, null));
            () -> objectParser.declareField((o, v) -> {}, (r, c) -> null, null, ObjectParser.ValueType.STRING)
        parser.declareString(CalledOneTime::setFoo, new ParseField("foo"));
            ConstructingObjectParser<HasCtorArguments, Void> parser = new ConstructingObjectParser<>(
    public void testRequiredAndExclusiveFields() throws IOException {
import org.opensearch.core.xcontent.ToXContent;  
        );
        objectParser.declareString(constructorArg(), new ParseField("test"));
        );
            JsonXContent.jsonXContent,
import org.opensearch.core.xcontent.ObjectParser;
        );
    }
            parser.declareInt(HasCtorArguments::setMineral, new ParseField("mineral"));
                a -> new HasCtorArguments((String) a[0], (Integer) a[1])  
            this.named = named;  
            true,
            assertEquals("Required [animal, vegetable]", e.getMessage());
        );  
        e = expectThrows(IllegalArgumentException.class, () -> parser.parse(notenough, null));
            () -> randomFrom(HasCtorArguments.ALL_PARSERS).apply(parser, null)
        );
import org.opensearch.core.xcontent.XContentParser;
                }"""
    private static class HasCtorArguments implements ToXContentObject {
        assertThat(e.getMessage(), containsString("[has_required_arguments] failed to parse field [a]"));
            e.getCause().getMessage(),
    /**
        @SuppressWarnings("unchecked")
            if (a != null) {  
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));  
        );
        public void setC(String c) {
            "{\"named\": [ {\"a\": {}} ], \"named_in_constructor\": [ {\"b\": {}} ]}"  
import org.opensearch.test.OpenSearchTestCase;
        );  
        }
                "[constructor_args_required] must configure at least one constructor argument. If it doesn't have any it should "
        assertEquals("Required [animal]", e.getMessage());
    }
        } else {  
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1, \"animal\": \"cat\" }");  
        XContentParser parser = createParser(  
    }  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        }  
                NamedObject.PARSER,  
            }
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {} ], \"named_in_constructor\": [ {\"a\": {}} ]}");
            () -> objectParser.declareField(
                  "vegetable": 2  
        assertTrue(h.namedSuppliedInOrder);
            XContentParseException.class,
            assertEquals(expected.animal, parsed.animal);
            }  
import org.opensearch.common.xcontent.ObjectParserTests.NamedObject;  
        TestStruct actual = parser.parse(ok, null);
        }  
        try {  
        XContentParser parser = createParser(
            this.a = a;
    }
        ConstructingObjectParser<TestStruct, Void> objectParser = new ConstructingObjectParser<>(
        assertEquals((Integer) 2, parsed.vegetable);  
            )
        e = expectThrows(
        }  
        }
        assertEquals("cat", parsed.animal);
            builder.endObject();  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
        );  
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1 }");
            XContentParseException.class,
            )
            CalledOneTime(String yeah) {  
        );  
    public void testMissingFirstConstructorArgButNotRequired() throws IOException {
        ConstructingObjectParser<NoConstructorArgs, Void> parser = new ConstructingObjectParser<>(
 * GitHub history for details.
            fail("Expected AssertionError");
            e.getCause().getMessage(),
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named]"));
import org.opensearch.common.Nullable;
import java.io.ByteArrayOutputStream;
            this.animal = animal;  
        ConstructingObjectParser<HasCtorArguments, Void> objectParser = randomBoolean()  
            IllegalArgumentException.class,
        assertEquals("b", h.namedInConstructor.get(0).name);
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1, \"vegetable\": 2 }");  
        Exception e = expectThrows(
        XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
            containsString(
            containsString(
            containsString(  
            Arrays.asList(PARSER, PARSER_VEGETABLE_OPTIONAL, PARSER_ALL_OPTIONAL)
 */  
    public void testMissingSecondConstructorArgButNotRequired() throws IOException {
        );
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));
            assertEquals("Required [animal]", e.getMessage());
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
            new ParseField("named_in_constructor")
            }
        XContentParseException e = expectThrows(  
    public void testIgnoreUnknownFields() throws IOException {
        @Nullable  
        assertThat(h.named, hasSize(1));
    public void testCalledOneTime() throws IOException {  
                NamedObjectHolder::keepNamedInOrder,
        assertThat(
        assertTrue(result.fooSet);
 *
        expected.toXContent(builder, ToXContent.EMPTY_PARAMS);
            parser.declareInt(HasCtorArguments::setFruit, new ParseField("fruit"));  
            JsonXContent.jsonXContent,
/*  
        );
    public void testParseNamedObjectInOrderNotSupportedConstructorArg() throws IOException {
                "[named] can be a single object with any number of fields "
            parser.declareString(HasCtorArguments::setB, new ParseField("b"));
        );  
        }
            final long b;  
        if (objectParser == HasCtorArguments.PARSER) {
            );
        assertThat(h.namedInConstructor, hasSize(1));
        );  
            """
        );
        }
 * license agreements. See the NOTICE file distributed with
            parser.declareString(HasCtorArguments::setC, new ParseField("c"));  
        private List<NamedObject> namedInConstructor;
        assertEquals(1, parsed.mineral);  
}
                  "a": "supercalifragilisticexpialidocious",
        @SuppressWarnings("unchecked")
                assertFalse(fooSet);  
    public void testBadParam() throws IOException {  
        );
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));  
            () -> objectParser.declareField(null, (r, c) -> null, new ParseField("test"), ObjectParser.ValueType.STRING)  
        class NoConstructorArgs {}
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            IllegalArgumentException.class,
        builder = shuffleXContent(builder);  
    public void testNullDeclares() {
        );
import org.opensearch.core.xcontent.XContentBuilder;
            this.vegetable = vegetable;
import org.opensearch.core.xcontent.XContentParseException;  
                builder.field("fruit", fruit);
    static class NamedObjectHolder {  
                {  
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));
        ConstructingObjectParser<TestStruct, Void> parser = new ConstructingObjectParser<>("teststruct", args -> {
                NamedObject.PARSER,  
        );
        private boolean namedSuppliedInOrder = false;
        XContentParser parser = createParser(  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            declareSetters(parser);
                    + "or an array where each entry is an object with a single field"  
            }
        public static final List<ConstructingObjectParser<HasCtorArguments, Void>> ALL_PARSERS = unmodifiableList(  
 * KIND, either express or implied.  See the License for the
    public void testParseNamedObjectJunkInArray() throws IOException {
                "[named] can be a single object with any number of fields "
            // included in the exception
                    + "or an array where each entry is an object with a single field"
    }  
            "{\"named\": [ {\"a\": {}} ], \"named_in_constructor\": [ \"junk\" ]}"  
        assertThat(  
            IllegalArgumentException.class,  
        CalledOneTime result = parser.apply(xcontent, null);
            }
            namedSuppliedInOrder = true;
            xcontent = createParser(JsonXContent.jsonXContent, "{ \"foo\": \"foo\" }");
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named_in_constructor]"));  
        assertEquals(2, e.getLineNumber());
            parser.declareString(HasCtorArguments::setA, new ParseField("a"));
        assertEquals(4, e.getLineNumber());
                (o, v) -> {},  
        parser.declareLong(optionalConstructorArg(), new ParseField("b"));  
        private static ConstructingObjectParser<HasCtorArguments, Integer> buildContextParser() {
        class TestStruct {
                new ParseField("named_in_constructor")
        XContentParseException e = expectThrows(XContentParseException.class, () -> objectParser.apply(parser, null));  
            JsonXContent.jsonXContent,
        }
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named_in_constructor]"));
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));
                ObjectParser.ValueType.STRING
        assertThat(
        byte[] bytes = ((ByteArrayOutputStream) builder.getOutputStream()).toByteArray();
            "one_time_test",
        public void setB(String b) {
                }
        int fruit;
        final String animal;
/*  
