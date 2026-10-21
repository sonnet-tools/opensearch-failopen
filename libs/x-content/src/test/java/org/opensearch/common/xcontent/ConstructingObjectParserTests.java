        );
            "one_time_test",
    }
        );
    }
            Arrays.asList(PARSER, PARSER_VEGETABLE_OPTIONAL, PARSER_ALL_OPTIONAL)
            )
        int mineral;
            e.getCause().getMessage(),
 * the Apache License, Version 2.0 (the "License"); you may
        public void setC(String c) {
            """
            JsonXContent.jsonXContent,
        objectParser.declareString(constructorArg(), new ParseField("test"));
import java.util.Arrays;
        );
        assertEquals(Integer.valueOf(42), parsed.vegetable);
            return new TestStruct((Long) args[1]);
        @SuppressWarnings("unchecked")
        } catch (AssertionError e) {
            a -> new NamedObjectHolder(((List<NamedObject>) a[0]))
            this.fruit = fruit;
            }
            this.a = a;
    private static class HasCtorArguments implements ToXContentObject {
            true,
            NamedObject.PARSER,
 * license agreements. See the NOTICE file distributed with
            this.mineral = mineral;
    }
        CalledOneTime result = parser.apply(xcontent, null);
        );
        assertThat(actual.a, equalTo("a"));
        assertEquals(1, parsed.mineral);
        assertEquals("cat", parsed.animal);
                (o, v) -> {},
 */
                builder.field("b", b);
            IllegalArgumentException.class,
import java.io.IOException;
            JsonXContent.jsonXContent,
                (args, ctx) -> new HasCtorArguments((String) args[0], ctx)
            parser.declareInt(HasCtorArguments::setFruit, new ParseField("fruit"));
        );
                  "animal": "cat",
            }
            () -> randomFrom(HasCtorArguments.PARSER, HasCtorArguments.PARSER_VEGETABLE_OPTIONAL).apply(parser, null)
        e = expectThrows(
            () -> objectParser.declareField(
        xcontent = createParser(JsonXContent.jsonXContent, "{ \"foo\": \"foo\",  \"yeah\": \"!\" }");
        assertEquals("[type] is required", e.getMessage());
        expected.setB(randomBoolean() ? null : randomAlphaOfLength(5));
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1, \"vegetable\": 2 }");
            )
            "{\"named\": [ {\"a\": {}} ], \"named_in_constructor\": [ {\"b\": {}} ]}"
                    + "or an array where each entry is an object with a single field"
        objectParser.declareNamedObjects(
    }
        NamedObjectHolder h = NamedObjectHolder.PARSER.apply(parser, null);
        public void setNamed(List<NamedObject> named) {
    public void testRandomOrder() throws Exception {
            TestStruct(String test) {
            : HasCtorArguments.PARSER_VEGETABLE_OPTIONAL;
            e.getCause().getMessage(),
import static org.hamcrest.Matchers.equalTo;
                ObjectParser.ValueType.STRING
        assertTrue(h.namedSuppliedInOrder);
        }
        XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
            PARSER.declareNamedObjects(
            }
            HasCtorArguments parsed = randomFrom(HasCtorArguments.ALL_PARSERS).apply(parser, null);
    /**
 * ownership. Elasticsearch licenses this file to you under
    }
    }
        );
        assertThat(e.getMessage(), containsString("Required one of fields [a, b], but none were specified."));
        private static void declareSetters(ConstructingObjectParser<HasCtorArguments, ?> parser) {
        XContentParser parser = createParser(
            if (a != null) {
        objectParser.declareNamedObjects(
    public void testParseNamedObjectTwoFieldsInArray() throws IOException {
            this.b = b;
    }
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> HasCtorArguments.PARSER.apply(parser, null));
            e.getCause().getMessage(),
        expected.setD(randomBoolean());
        XContentParser notenough = createParser(JsonXContent.jsonXContent, "{ }");
        @Nullable
                ConstructingObjectParser.constructorArg(),
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));
        });
            IllegalArgumentException.class,
            ConstructingObjectParser.constructorArg(),
import org.opensearch.core.xcontent.ContextParser;
        }
        XContentParser parser = createParser(
            "named_object_holder",
        assertEquals("Required [animal]", e.getMessage());
            () -> randomFrom(HasCtorArguments.ALL_PARSERS).apply(parser, null)
            )
        TestStruct actual = parser.parse(ok, null);
        assertEquals("b", h.namedInConstructor.get(0).name);
        XContentParser parser = createParser(
                "[named_in_constructor] can be a single object with any number of fields "
        }
            IllegalArgumentException.class,
    static class NamedObjectHolder {
                "has_required_arguments",
            assertEquals(expected.fruit, parsed.fruit);
        }
 * Unless required by applicable law or agreed to in writing,
            }
 * GitHub history for details.
            parser.declareInt(vegetableRequired ? constructorArg() : optionalConstructorArg(), new ParseField("vegetable"));
        );
        assertEquals("Required [vegetable]", e.getMessage());
            if (a != null && a.length() > 9) {
    }
        objectParser.declareNamedObjects(NamedObjectHolder::setNamed, NamedObject.PARSER, new ParseField("named"));
        public void setB(String b) {
 * software distributed under the License is distributed on an
            this.named = named;
        class CalledOneTime {
        assertEquals("[named] doesn't support arrays. Use a single object with multiple fields.", e.getCause().getMessage());
    public void testMissingFirstConstructorArgButNotRequired() throws IOException {
        );
        XContentParseException e = expectThrows(XContentParseException.class, () -> objectParser.apply(parser, null));
        );
        /*
                NamedObjectHolder::keepNamedInOrder,
        ConstructingObjectParser<NamedObjectHolder, Void> objectParser = new ConstructingObjectParser<>(
            namedSuppliedInOrder = true;
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"animal\": \"dropbear\", \"mineral\": -8 }");
    public void testNullDeclares() {
/*
        ConstructingObjectParser<TestStruct, Void> parser = new ConstructingObjectParser<>("teststruct", args -> {
        assertThat(h.namedInConstructor, hasSize(1));
        }
            e.getCause().getMessage(),
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1, \"vegetable\": 2 }");
import org.opensearch.core.xcontent.ToXContent;
        XContentParseException e = expectThrows(
        ConstructingObjectParser<TestStruct, Void> objectParser = new ConstructingObjectParser<>(
        String a;
        expected.setFruit(randomInt());
        objectParser.declareNamedObjects(NamedObjectHolder::setNamed, NamedObject.PARSER, new ParseField("named"));
            assertEquals(expected.vegetable, parsed.vegetable);
            "{\"named\": [ {\"a\": {}} ], \"named_in_constructor\": [ \"junk\" ]}"
 * not use this file except in compliance with the License.
        assertEquals("[parser] is required", e.getMessage());
    public void testParseNamedObjectJunkInArrayConstructorArg() throws IOException {
        assertThat(e.getMessage(), containsString("failed to build [has_required_arguments] after last required field arrived"));
                new ParseField("test"),
                assertFalse(fooSet);
            """
            public final String test;
            assertEquals(expected.b, parsed.b);
        );
        assertTrue(result.fooSet);
        XContentParser parser = createParser(
            assertEquals("Required [animal]", e.getMessage());
            ConstructingObjectParser<HasCtorArguments, Integer> parser = new ConstructingObjectParser<>(
            }
            new ParseField("named_in_constructor")
        assertEquals("[parser] is required", e.getMessage());
        XContentParser xcontent = createParser(JsonXContent.jsonXContent, "{ \"yeah\": \"!\", \"foo\": \"foo\" }");
        // Now firing the xml through it fails
        public void setD(boolean d) {
import org.opensearch.common.xcontent.json.JsonXContent;
        String c;
            assertEquals(expected.mineral, parsed.mineral);
            assertEquals(expected.animal, parsed.animal);
        @SuppressWarnings("unchecked")
            a -> new NamedObjectHolder(((List<NamedObject>) a[0]))
            () -> objectParser.declareField(null, (r, c) -> null, new ParseField("test"), ObjectParser.ValueType.STRING)
         * this this style is normal just because it is in the test.
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named_in_constructor]"));
    }
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));
    public void testConstructObjectUsingContext() throws IOException {
        assertThat(
                this.a = null;
        XContentParser parser = createParser(
        }
                }
                NamedObject.PARSER,
        public static final ConstructingObjectParser<HasCtorArguments, Void> PARSER = buildParser(true, true);
                new ParseField("named_in_constructor")
        HasCtorArguments(@Nullable String animal, @Nullable Integer vegetable) {
        public void setA(String a) {
            "{\"named\": {\"a\": {}}, \"named_in_constructor\": [ {\"b\": {}} ]}"
            )
            parser.declareString(HasCtorArguments::setA, new ParseField("a"));
            this.namedInConstructor = namedInConstructor;
            JsonXContent.jsonXContent,
        );
        TestStruct s = objectParser.apply(parser, null);
        e = expectThrows(
            parser.declareString(HasCtorArguments::setB, new ParseField("b"));
 *
                (o, v) -> {},
import org.hamcrest.Matcher;
import org.opensearch.core.xcontent.XContentParser;
            "{\"named\": [ {\"a\": {}, \"b\": {}}], \"named_in_constructor\": [ {\"c\": {}} ]}"
import org.opensearch.core.ParseField;
        NamedObjectHolder(List<NamedObject> namedInConstructor) {
        );
            // The following JSON needs to include newlines, in order to affect the line numbers
        public static final ConstructingObjectParser<NamedObjectHolder, Void> PARSER = new ConstructingObjectParser<>(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (d) {
            containsString(
        HasCtorArguments expected = new HasCtorArguments(randomAlphaOfLength(5), randomInt());
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1 }");
        // ctor arg first so we can test for the bug we found one time
 */
            )
        public static final ConstructingObjectParser<HasCtorArguments, Integer> PARSER_INT_CONTEXT = buildContextParser();
        ConstructingObjectParser<Void, Void> objectParser = new ConstructingObjectParser<>("foo", a -> null);
        boolean d;
        assertThat(h.named, hasSize(1));
        private static ConstructingObjectParser<HasCtorArguments, Integer> buildContextParser() {
        int fruit;
            a -> new NamedObjectHolder(((List<NamedObject>) a[0]))
        @Override
                (ContextParser<Void, Object>) null,
            boolean fooSet = false;
        private boolean namedSuppliedInOrder = false;
import org.opensearch.test.OpenSearchTestCase;
        assertThat(e.getMessage(), containsString("[has_required_arguments] failed to parse field [vegetable]"));
            () -> objectParser.declareField((o, v) -> {}, (r, c) -> null, new ParseField("test"), null)
            parser.declareString(HasCtorArguments::setC, new ParseField("c"));
        class TestStruct {
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {} ], \"named_in_constructor\": [ {\"a\": {}} ]}");
        String b;
        }
    public void testParseNamedObjectNoFieldsInArray() throws IOException {
        );
        expected.setMineral(randomInt());
        public void keepNamedInOrder() {
     * Builds the object in random order and parses it.
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals(4, e.getLineNumber());
        }
            "{\"named\": { \"a\": {} }, \"named_in_constructor\": { \"b\": {} } }"
                this.b = 0;
            )
import org.opensearch.common.xcontent.ObjectParserTests.NamedObject;
            "foo",
import org.opensearch.core.xcontent.ToXContentObject;
                "[named] can be a single object with any number of fields "
import static org.hamcrest.Matchers.anyOf;
                throw new IllegalArgumentException("[a] must be less than 10 characters in length but was [" + a + "]");
        }
        Exception e = expectThrows(
            containsString("[named_in_constructor] doesn't support arrays. Use a single object with multiple fields.")
    }
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named]"));
    }
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{\"named\": [ {\"a\": {}} ], \"named_in_constructor\": [ {} ]}");
import org.opensearch.common.Nullable;
import org.opensearch.core.xcontent.XContentParseException;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
                    yeahMatcher = anyOf(yeahMatcher, nullValue());
            IllegalArgumentException.class,
            }
        );
            XContentParseException.class,
            containsString(
            "[a] must be less than 10 characters in length but was [supercalifragilisticexpialidocious]",
        assertThat(e.getMessage(), containsString("[has_required_arguments] failed to parse field [a]"));
            XContentParseException.class,
    public void testParseNamedObjectInOrderNotSupported() throws IOException {
                builder.field("a", a);
            JsonXContent.jsonXContent,
                    // either(yeahMatcher).or(nullValue) is broken by https://github.com/hamcrest/JavaHamcrest/issues/49
        }
        assertEquals("dropbear", parsed.animal);
                NamedObjectHolder::keepNamedInOrder,
    public void testMissingSecondConstructorArg() throws IOException {
 * this work for additional information regarding copyright
        }
        private static ConstructingObjectParser<HasCtorArguments, Void> buildParser(boolean animalRequired, boolean vegetableRequired) {
            parser.declareBoolean(HasCtorArguments::setD, new ParseField("d"));
            ? HasCtorArguments.PARSER
        final Integer vegetable;
        parser.declareLong(optionalConstructorArg(), new ParseField("b"));
                "[constructor_args_required] must configure at least one constructor argument. If it doesn't have any it should "
                  "a": "supercalifragilisticexpialidocious"
    public void testBadParamBeforeObjectBuilt() throws IOException {
            "[a] must be less than 10 characters in length but was [supercalifragilisticexpialidocious]",
            builder.field("animal", animal);
    }
            builder.endObject();
        assertEquals("[consumer] is required", e.getMessage());
            CalledOneTime(String yeah) {
 */
        parser.declareString(optionalConstructorArg(), new ParseField("a"));
import java.util.List;
                assertThat(yeah, yeahMatcher);
        boolean ctorArgOptional = randomBoolean();
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));
        );
    }
         * It is normal just to declare a single PARSER but we use a couple of different parsers for testing so we have all of these. Don't
            parser.apply(createParser(JsonXContent.jsonXContent, "{}"), null);
import org.opensearch.core.xcontent.ObjectParser;
        public void setMineral(int mineral) {
    public void testRequiredAndExclusiveFields() throws IOException {
        assertThat(actual.b, equalTo(0L));
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named]"));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, bytes)) {
            builder.startObject();
    public void testCalledOneTime() throws IOException {
        ConstructingObjectParser<CalledOneTime, Void> parser = new ConstructingObjectParser<>(
            // included in the exception
            if (mineral != 0) { // We're just using 0 as the default because it is easy for testing
            e.getCause().getMessage()
            )
                fooSet = true;
        );
            }
            this.vegetable = vegetable;
public class ConstructingObjectParserTests extends OpenSearchTestCase {
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));
        public static final ConstructingObjectParser<HasCtorArguments, Void> PARSER_VEGETABLE_OPTIONAL = buildParser(true, false);
        public static final ConstructingObjectParser<HasCtorArguments, Void> PARSER_ALL_OPTIONAL = buildParser(false, false);
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1, \"animal\": \"cat\" }");
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1, \"animal\": \"cat\" }");
    }
            }
    public void testParseNamedObjectInOrder() throws IOException {
        assertFalse(h.namedSuppliedInOrder);
    }
                false,
                return new TestStruct((String) args[0]);
                builder.field("d", d);
        assertThat(e.getMessage(), containsString("allowed together: [a, b]"));
            PARSER.declareNamedObjects(
        static {
        private List<NamedObject> namedInConstructor;
                "[named_in_constructor] can be a single object with any number of fields "
            containsString(
            "{\"named\": [ \"junk\" ], \"named_in_constructor\": [ {\"a\": {}} ]}"
 * The OpenSearch Contributors require contributions made to
            if (args[0] != null) {
            ConstructingObjectParser<HasCtorArguments, Void> parser = new ConstructingObjectParser<>(
        }
        assertEquals(-8, parsed.mineral);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this.c = c;
        assertEquals(4, e.getLineNumber());
    }
                }"""
            containsString(
                new ParseField("test"),
        HasCtorArguments parsed = HasCtorArguments.PARSER_ALL_OPTIONAL.apply(parser, null);
        assertEquals("a", h.named.get(0).name);
    public void testParseNamedObjectNoFieldsInArrayConstructorArg() throws IOException {
        @Nullable
        XContentParser parser = createParser(
            }
            JsonXContent.jsonXContent,
            );
/*
    }
 * this file be licensed under the Apache-2.0 license or a
                NamedObjectHolder::setNamed,
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> objectParser.apply(parser, null));
    public void testParseNamedObjectJunkInArray() throws IOException {
        assertThat(h.named, hasSize(1));
        );
            parser.declareString(constructorArg(), new ParseField("animal"));
            if (b != null) {
                this.test = test;
import static org.hamcrest.Matchers.containsString;
        XContentParser parser = createParser(
            JsonXContent.jsonXContent,
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
                e.getMessage()
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
                this.a = a;
        HasCtorArguments parsed = randomFrom(HasCtorArguments.PARSER_VEGETABLE_OPTIONAL, HasCtorArguments.PARSER_ALL_OPTIONAL).apply(
        assertThat(
        assertThat(
        class NoConstructorArgs {}
        ConstructingObjectParser<NamedObjectHolder, Void> objectParser = new ConstructingObjectParser<>(
                builder.field("fruit", fruit);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, parsed.mineral);
        );
        e = expectThrows(IllegalArgumentException.class, () -> parser.parse(notenough, null));
            ConstructingObjectParser.constructorArg(),
    public void testParseNamedObject() throws IOException {
            "constructor_args_required",
        }
            NamedObject.PARSER,
                NamedObject.PARSER,
 * compatible open source license.
            );
        expected.toXContent(builder, ToXContent.EMPTY_PARAMS);
package org.opensearch.common.xcontent;
            builder.field("vegetable", vegetable);
    public void testMissingAllConstructorArgs() throws IOException {
    public void testMissingSecondConstructorArgButNotRequired() throws IOException {
    }
                a -> new HasCtorArguments((String) a[0], (Integer) a[1])
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named_in_constructor]"));
        e = (XContentParseException) e.getCause();
        @SuppressWarnings("unchecked")
        if (objectParser == HasCtorArguments.PARSER) {
            )
    public void testMissingFirstConstructorArg() throws IOException {
            assertEquals(expected.c, parsed.c);
        assertTrue(result.fooSet);
import static org.hamcrest.Matchers.hasSize;
        );
        final String animal;
        );
        e = expectThrows(
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named_in_constructor]"));
            );
        if (ctorArgOptional) {
            IllegalArgumentException.class,
        XContentParser toomany = createParser(JsonXContent.jsonXContent, "{ \"a\" : \"a\", \"b\" : 1 }");
        public void setFruit(int fruit) {
    }
        parser.declareExclusiveFieldSet("a", "b");
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named_in_constructor]"));
            e.getCause().getMessage()
        }
        assertEquals("a", h.named.get(0).name);
        parser.declareString(CalledOneTime::setFoo, new ParseField("foo"));
     */
        }
        );
        ConstructingObjectParser<HasCtorArguments, Void> objectParser = randomBoolean()
    public void testParseNamedObjectInOrderNotSupportedConstructorArg() throws IOException {
        assertEquals(2, e.getLineNumber());
        e = expectThrows(
import org.opensearch.common.CheckedFunction;
        );
 *
            assertEquals(expected.d, parsed.d);
         */
            a -> new TestStruct((String) a[0])
    /**
        IllegalArgumentException e = expectThrows(
                  "a": "supercalifragilisticexpialidocious",
            }
                }"""
        e = (XContentParseException) e.getCause();
     * Tests the non-constructor fields are only set on time.
        assertEquals(1, parsed.mineral);
    }
                  "animal": "cat",
    }
            "{\"named\": [ {\"a\": {}}], \"named_in_constructor\": [ {\"c\": {}, \"d\": {}} ]}"
            "named_object_holder",
            assertEquals(expected.a, parsed.a);
 * KIND, either express or implied.  See the License for the
                (CheckedFunction<XContentParser, Object, IOException>) null,
                    + "or an array where each entry is an object with a single field"
    }
                "[named] can be a single object with any number of fields "
        // and ctor arg second just in case
        ConstructingObjectParser<NoConstructorArgs, Void> parser = new ConstructingObjectParser<>(
            }
        builder = shuffleXContent(builder);
import static java.util.Collections.unmodifiableList;
            final String a;
            // The following JSON needs to include newlines, in order to affect the line numbers
/*
            () -> randomFrom(HasCtorArguments.ALL_PARSERS).apply(parser, null)
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parser.parse(toomany, null));
    }
        XContentParser ok = createParser(JsonXContent.jsonXContent, "{ \"a\" : \"a\" }");
            // and without the constructor arg if we've made it optional
    public void testMissingAllConstructorArgsButNotRequired() throws IOException {
        assertThat(h.namedInConstructor, hasSize(1));
            assertEquals("Required [animal, vegetable]", e.getMessage());
                    + "or an array where each entry is an object with a single field"
                new ParseField("named")
        );
                    + "or an array where each entry is an object with a single field"
            JsonXContent.jsonXContent,
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));
            new ParseField("named_in_constructor")
        }
        XContentParser parser = createParser(
        expected.setA(randomBoolean() ? null : randomAlphaOfLength(5));
            null
                {
            parser.declareInt(HasCtorArguments::setMineral, new ParseField("mineral"));
    public void testIgnoreUnknownFields() throws IOException {
                  "vegetable": 2
        NamedObjectHolder h = NamedObjectHolder.PARSER.apply(parser, null);
        }
            }
            // included in the exception
        expected.setC(randomBoolean() ? null : randomAlphaOfLength(5));
        );
        assertThat(
            "{\"named\": [\n" + "  {\"a\": {}}" + "],\"named_in_constructor\": {\"b\": {}}" + "}"
            parser.declareString(animalRequired ? constructorArg() : optionalConstructorArg(), new ParseField("animal"));
            JsonXContent.jsonXContent,
            return builder;
        } else {
            TestStruct(long b) {
    }
        assertEquals("b", h.namedInConstructor.get(0).name);
                  "vegetable": 2,
                "[named_in_constructor] can be a single object with any number of fields "
        private List<NamedObject> named;
                builder.field("c", c);
        parser.declareRequiredFieldSet("a", "b");
        assertEquals(
        assertEquals((Integer) 2, parsed.vegetable);
        );
 * under the License.
        );
}
            }
        );
        );
    }
            this.d = d;
        XContentParseException e = expectThrows(
            result = parser.apply(xcontent, null);
 * Licensed to Elasticsearch under one or more contributor
        result = parser.apply(xcontent, null);
            void setFoo(String foo) {
    public void testBadParam() throws IOException {
            );
 * You may obtain a copy of the License at
        }
            final long b;
            return parser;
        );
        assertEquals(s.test, "foo");
        }
        );
            if (fruit != 0) {
        );
            containsString(
        @SuppressWarnings("unchecked")
        // Now firing the xml through it fails
            declareSetters(parser);
            e.getCause().getMessage(),
     */
        assertThat(
            return parser;
        assertEquals(2, e.getLineNumber());
                "[named] can be a single object with any number of fields "
        assertEquals(
        XContentParser parser = createParser(
        XContentParseException e = expectThrows(XContentParseException.class, () -> objectParser.apply(parser, null));
            () -> objectParser.declareField(
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"mineral\": 1 }");
                    + "or an array where each entry is an object with a single field"
        }
        try {
                {
                if (ctorArgOptional) {
        @SuppressWarnings("unchecked")
    public void testParseNamedObjectTwoFieldsInArrayConstructorArg() throws IOException {
        parser.declareString(ctorArgOptional ? optionalConstructorArg() : constructorArg(), new ParseField("yeah"));
    }
                    + "or an array where each entry is an object with a single field"
        }
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named]"));
            );
        );
        assertThat(
        class TestStruct {
            (a) -> new NoConstructorArgs()
        XContentParser parser = createParser(
                builder.field("mineral", mineral);
import java.io.ByteArrayOutputStream;
            containsString(
            e.getCause().getMessage(),
        assertEquals("[parseField] is required", e.getMessage());
            fail("Expected AssertionError");
        );
        public static final List<ConstructingObjectParser<HasCtorArguments, Void>> ALL_PARSERS = unmodifiableList(
        assertTrue(result.fooSet);
                Matcher<String> yeahMatcher = equalTo("!");
import static org.hamcrest.Matchers.nullValue;
            e.getCause().getMessage(),
import org.opensearch.core.xcontent.ConstructingObjectParser;
            (a) -> new CalledOneTime((String) a[0])
            if (c != null) {
                    + "use ObjectParser instead of ConstructingObjectParser. This is a bug in the parser declaration.",
            xcontent = createParser(JsonXContent.jsonXContent, "{ \"foo\": \"foo\" }");
            () -> objectParser.declareField((o, v) -> {}, (r, c) -> null, null, ObjectParser.ValueType.STRING)
            "named_object_holder",
        assertThat(e.getMessage(), containsString("[named_object_holder] failed to parse field [named]"));
 *
            JsonXContent.jsonXContent,
            parser,
        XContentParser parser = createParser(JsonXContent.jsonXContent, "{ \"test\" : \"foo\", \"junk\" : 2 }");
 * Modifications Copyright OpenSearch Contributors. See
            declareSetters(parser);
        builder.flush();
        );
            this.animal = animal;
        HasCtorArguments parsed = HasCtorArguments.PARSER_INT_CONTEXT.apply(parser, 42);
                "has_required_arguments",
                this.b = b;
        HasCtorArguments parsed = HasCtorArguments.PARSER_ALL_OPTIONAL.apply(parser, null);
        );
            IllegalArgumentException.class,
            TestStruct(String a) {
                ObjectParser.ValueType.STRING
        byte[] bytes = ((ByteArrayOutputStream) builder.getOutputStream()).toByteArray();
        XContentParseException e = expectThrows(XContentParseException.class, () -> NamedObjectHolder.PARSER.apply(parser, null));
            JsonXContent.jsonXContent,
    public void testConstructorArgsMustBeConfigured() throws IOException {
            assertEquals(
        assertThat(
        // Create our own parser for this test so we can disable support for the "ordered" mode specified by the array above
 * specific language governing permissions and limitations
        // Create our own parser for this test so we can disable support for the "ordered" mode specified by the array above
        }
        assertThat(e.getMessage(), containsString("[has_required_arguments] failed to parse field [a]"));
