                    if (randomBoolean()) {
            if (hbfield.name().equals(fieldName)) {
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.BoundaryScannerType;
                highlightBuilder.forceSource(toggleOrSet(highlightBuilder.forceSource()));
                     }
        mockShardContext.setMapUnmappedFieldAsString(true);
        if (flag == null) {
import org.opensearch.index.query.QueryBuilder;
            }
                highlightBuilder.boundaryScannerType(randomFrom(BoundaryScannerType.values()).toString());
    }
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
            assertEquals(deserialized, original);
    }
import org.opensearch.index.query.IdsQueryBuilder;
            BigArrays.NON_RECYCLING_INSTANCE,
        assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));
    }
                        // add another field
    protected NamedXContentRegistry xContentRegistry() {
            e.getCause().getMessage(),
    */
                );
     */
    }
        {
    }
                highlightBuilder.postTags()
            null
                    }
                    fieldBuilder,
            null,
                """);
        }
                highlightBuilder.preTags()
    /**
    ) {
            int items = randomIntBetween(0, 5);
        for (int f = 0; f < size; f++) {
    /**
    @SuppressWarnings({ "unchecked", "rawtypes" })
                break;
    }
    }
                "setting tags_schema 'styled' should alter pre_tags",
        testHighlighter.useExplicitFieldOrder(randomBoolean());
            case 14:
                {
                case 1:
            randomStrings.add(randomAlphaOfLengthBetween(3, 10));
                highlightBuilder.phraseLimit(randomIntBetween(11, 20));
            () -> true,
                field.matchedFields(randomStringArray(0, 4));
    private static HighlightBuilder serializedCopy(HighlightBuilder original) throws IOException {
                case 0:
import org.opensearch.core.common.io.stream.StreamInput;
            // need to set this together, otherwise parsing will complain
                }
        if (randomBoolean()) {
            HighlightBuilder highlightBuilder = HighlightBuilder.fromXContent(parser);
        }
        }
        }
                case 2:
            } else if (actualValue instanceof Character[]) {
                    );
                    throw new RuntimeException("Error parsing " + highlightBuilder, e);
 * the Apache License, Version 2.0 (the "License"); you may
                  "fields" : {
        if (randomBoolean()) {
                        break;
            assertEquals("[2:5] [highlight] unknown field [bad_fieldname]", e.getMessage());
        }
            case 6:
                highlightBuilder.highlightQuery(
            assertNotSame(deserialized, original);
               }]
                break;
            );
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            }
    @AfterClass
            HighlightBuilder highlightBuilder = randomHighlighterBuilder();
import static org.hamcrest.Matchers.containsString;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.Field;
            } else {
 * SPDX-License-Identifier: Apache-2.0
              "fields" : [ {
import org.opensearch.core.common.ParsingException;
import org.apache.lucene.search.Query;
                    options.put(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10));
                } else {
    /**
 * Licensed to Elasticsearch under one or more contributor
            case 5:
                        } else {
    /**
        highlight.toXContent(builder, ToXContent.EMPTY_PARAMS);
            case 15:
                    break;
            Object expectedValue = null;
            highlightBuilder.forceSource(randomBoolean());
            containsString(
        }
import java.util.HashSet;
                checkSame.accept(AbstractHighlighterBuilder::postTags, FieldOptions::postTags);
    public void testBuildSearchContextHighlight() throws IOException {
                    break;
            highlightBuilder.preTags(randomStringArray(0, 3));
        highlightElement = "{ \"fields\" : { \"foo\" : { } } }";
                shuffled = shuffleXContent(builder, "fields");
    }
            XContentBuilder shuffled;
            HighlightBuilder original = randomHighlighterBuilder();
        } else {
            assertThat(e.getCause().getMessage(), containsString("[fields] failed to parse field [body]"));
     * test parsing empty highlight or empty fields blocks
import java.util.HashMap;
            @Override
                }
            highlightBuilder.requireFieldMatch(randomBoolean());
        }
                } else if (highlightBuilder.highlightQuery != null) {
                    new TermQueryBuilder(randomAlphaOfLengthBetween(11, 20), randomAlphaOfLengthBetween(11, 20))
        );
import org.opensearch.cluster.metadata.IndexMetadata;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {
            if (randomBoolean()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                {
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.Order;
        }
                    "bad_fieldname" : "value"
                case 2:
                // also test the string setter
        xContentRegistry = null;
            highlightElement = "{\n" + "    \"tags_schema\" : \"default\"\n" + "}\n";
/*
                  "fields" : {
            Object globalLevelValue = highlightBuilderParameterAccessor.apply(highlightBuilder);
                     "body" : {
            }
            }
                assertEquals(highlightBuilder, secondHighlightBuilder);
        if (randomBoolean()) {
                if (fieldBuilder.matchedFields != null) {
    /**
    }
            null,
        Index index = new Index(randomAlphaOfLengthBetween(1, 10), "_na_");
                "setting tags_schema 'default' should alter post_tags",
                highlightBuilder.fragmentSize(randomIntBetween(101, 200));
        }
            case 8:
                """);
                case 0:
                break;
        ) {
            XContentParseException.class,
            switch (randomIntBetween(0, 2)) {
            assertEquals("[2:5] [highlight] unknown field [bad_fieldname]", e.getMessage());
                TextFieldMapper.Builder builder = new TextFieldMapper.Builder(name, createDefaultIndexAnalyzers());
                highlightBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    secondHighlightBuilder = HighlightBuilder.fromXContent(parser);
                } catch (RuntimeException e) {
import org.opensearch.core.xcontent.XContentParser;
        }
                    highlightBuilder.order(Order.NONE);
import org.opensearch.index.mapper.MappedFieldType;
                checkSame.accept(AbstractHighlighterBuilder::fragmenter, FieldOptions::fragmenter);
                   }
            builder = builder.prettyPrint();
        // shard context will only need indicesQueriesRegistry for building Query objects nested in highlighter
        }
        if (randomBoolean()) {
        for (int i = 0; i < numberOfFields; i++) {
            """);
 * compatible open source license.
                checkSame.accept(AbstractHighlighterBuilder::boundaryMaxScan, FieldOptions::boundaryMaxScan);
     */
        }
     * adds a simple json test for this.
                """);
    /**
                // also test the string setter
            } else {
                try {
                  "fields" : {
        }
        }
        assertEquals("pre_tags are set but post_tags are not set", err.getMessage());
            } else {
            assertThat(e.getCause().getMessage(), containsString("[fields] failed to parse field [body]"));
                Map<String, Object> options = new HashMap<>(items);
            null,
        }
                    expectedValue = Rewriteable.rewrite(fieldBuilder.highlightQuery, mockShardContext).toQuery(mockShardContext);
    private static void mutateCommonOptions(AbstractHighlighterBuilder highlightBuilder) {
                     }
                expectedValue = fieldLevelValue;
        }
                   }
        if (randomBoolean()) {
            if (randomBoolean()) {
                    highlightQuery = new IdsQueryBuilder();
 * not use this file except in compliance with the License.
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        HighlightBuilder mutation = serializedCopy(original);
     * mutate the given highlighter builder so the returned one is different in one aspect
                shuffled = shuffleXContent(builder);
            return !flag.booleanValue();
        assertThat(
            highlightBuilder.numOfFragments(randomIntBetween(0, 10));
                    assertArrayEquals(
                );
                highlightBuilder.highlighterType(randomAlphaOfLengthBetween(11, 20));
        }
        assertThat(Order.NONE.ordinal(), equalTo(0));
        };
                }
                    Arrays.sort(copy);
        {
    }
            namedWriteableRegistry,
            case 13:
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
            assertEquals("[4:9] [highlight_field] unknown field [bad_fieldname]", e.getCause().getCause().getMessage());
    @Override
            try (StreamInput in = out.bytes().streamInput()) {
                highlightBuilder.boundaryMaxScan(randomIntBetween(11, 20));
                {"fields" : [ "junk" ]}
    public void testUnknownFieldnameExpection() throws IOException {
        assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));
        if (randomBoolean()) {
     */
    private static BiConsumer<Function<AbstractHighlighterBuilder<?>, Object>, Function<FieldOptions, Object>> mergeBeforeChek(
            highlightBuilder.noMatchSize(randomIntBetween(0, 10));
                expectedValue = globalLevelValue;
     * @param options the target field options that are checked
import org.opensearch.common.xcontent.XContentType;
import java.io.IOException;
                assertThat(in.readVInt(), equalTo(1));
        HighlightBuilder highlightBuilder,
                break;
import java.util.Arrays;
        QueryShardContext mockShardContext = new QueryShardContext(
                highlightBuilder.fragmenter(randomAlphaOfLengthBetween(11, 20));
        int size = randomIntBetween(minSize, maxSize);
    public void testUnknownArrayNameExpection() throws IOException {
            assertEquals("[4:9] [highlight_field] unknown field [bad_fieldname]", e.getCause().getCause().getMessage());
            assertEquals("expected HighlightBuilder with field", new HighlightBuilder().field(new Field("foo")), highlightBuilder);
            assertThat(e.getMessage(), containsString("[highlight] failed to parse field [tags_schema]"));
import org.opensearch.test.IndexSettingsModule;
        }
            }
        Field fieldBuilder,
                    assertArrayEquals(HighlightBuilder.convertCharArray((char[]) expectedValue), (Character[]) actualValue);
                        mutation.field(new Field(randomAlphaOfLength(10)));
        }
                """);
                    break;
                 "nope" : {}
            if (fieldLevelValue != null) {
    }
 * this file be licensed under the Apache-2.0 license or a
                highlightBuilder.order(randomFrom(Order.values()));
                checkSame.accept(AbstractHighlighterBuilder::highlighterType, FieldOptions::highlighterType);
                highlightBuilder.useExplicitFieldOrder(true);
    private static HighlightBuilder mutate(HighlightBuilder original) throws IOException {
    /**
        XContentParseException e = expectParseThrows(XContentParseException.class, """
                highlightBuilder.noMatchSize(randomIntBetween(11, 20));
                "setting tags_schema 'default' should alter pre_tags",
                break;
            null,
     * passed in is the same.
                "[fields] can be a single object with any number of fields "
            } else if (globalLevelValue != null) {
import org.opensearch.core.xcontent.XContentBuilder;
                     "body" : {
            if (actualValue instanceof String[]) {
            null,
import org.opensearch.index.query.TermQueryBuilder;
        }
        }
        }
            case 4:
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
            for (int i = 0; i < items; i++) {
import org.opensearch.core.xcontent.ToXContent;
                        List<Field> originalFields = original.fields();
            }
            public MappedFieldType fieldMapper(String name) {
    }
 */
                highlightBuilder.requireFieldMatch(toggleOrSet(highlightBuilder.requireFieldMatch()));
            if (randomBoolean()) {
}
            HighlightBuilder highlightBuilder = HighlightBuilder.fromXContent(parser);
        }
                highlightBuilder.highlightFilter(toggleOrSet(highlightBuilder.highlightFilter()));
     * Create array of unique Strings. If not unique, e.g. duplicates field names
                final Field fieldBuilder = getFieldBuilderByName(highlightBuilder, field.field());
            if (randomBoolean()) {
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
     * test that unknown array fields cause exception
            HighlightBuilder highlightBuilder = HighlightBuilder.fromXContent(parser);
    /**
        if (randomBoolean()) {
    public void testOrderSerialization() throws Exception {
            }
import java.util.function.BiConsumer;
 * The OpenSearch Contributors require contributions made to
                        value = Integer.valueOf(randomInt(1000));
        }
        assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));
     * test ordinals of {@link Order}, since serialization depends on it
                if (highlightBuilder.order() == Order.NONE) {
import org.opensearch.core.index.Index;
                        "bad_fieldname" : "value"
            case 9:
                    String[] copy = Arrays.copyOf(fieldBuilder.matchedFields, fieldBuilder.matchedFields.length);
        namedWriteableRegistry = null;
            xContentRegistry(),
                assertEquals(highlightBuilder.hashCode(), secondHighlightBuilder.hashCode());
     */
            QueryBuilder highlightQuery;
     * would be dropped in {@link FieldOptions.Builder#matchedFields(Set)}, resulting in test glitches
                }
        XContentParseException e = expectParseThrows(
            assertEquals(deserialized.hashCode(), original.hashCode());
            highlightBuilder.highlightFilter(randomBoolean());
    /**
                    highlightQuery = new MatchAllQueryBuilder();
        return (highlightBuilderParameterAccessor, fieldOptionsParameterAccessor) -> {
 * under the License.
        return randomStrings.toArray(new String[0]);
            switch (randomInt(2)) {
        }
                case 1:
        if (randomBoolean()) {
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
        }
                String encoder = highlightBuilder.encoder() != null ? highlightBuilder.encoder() : HighlightBuilder.DEFAULT_ENCODER;
                    break;
            try (StreamInput in = out.bytes().streamInput()) {
            );
    private static Field getFieldBuilderByName(HighlightBuilder highlightBuilder, String fieldName) {
                        "bad_fieldname" : [ "field1" , "field2" ]
            }
        return xContentRegistry;
        {
            }
     */
                    + "or an array where each entry is an object with a single field"
            }
            case 12:
    }
            case 1:
        if (randomBoolean()) {
    public void testFromXContent() throws IOException {
    }
        for (Field hbfield : highlightBuilder.fields()) {
            Map<String, Object> options = new HashMap<>(items);
                }
    private static Boolean toggleOrSet(Boolean flag) {
                HighlightBuilder.DEFAULT_STYLED_PRE_TAG,
            case 11:
                    "bad_fieldname" :  { "field" : "value" }
            Order.NONE.writeTo(out);
                "setting tags_schema 'styled' should alter post_tags",
     * Test equality and hashCode properties
            assertArrayEquals(
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext.FieldOptions;
                checkSame.accept(AbstractHighlighterBuilder::numOfFragments, FieldOptions::numberOfFragments);
/*
                    mutation.encoder(original.encoder() + randomAlphaOfLength(2));
            checkEqualsAndHashCode(randomHighlighterBuilder(), HighlightBuilderTests::serializedCopy, HighlightBuilderTests::mutate);
import static org.hamcrest.Matchers.equalTo;
        int numberOfFields = randomIntBetween(1, 5);
 * Modifications Copyright OpenSearch Contributors. See
    }
        XContentParseException e = expectParseThrows(XContentParseException.class, """
            if (randomBoolean()) {
    * test that build() outputs a {@link SearchHighlightContext} that is has similar parameters
    public void testStringInFieldsArray() throws IOException {
            XContentParseException e = expectParseThrows(XContentParseException.class, """
            highlightBuilder.fragmenter(randomAlphaOfLengthBetween(1, 10));
 *
        }
                        break;
 *
                    } else {
 */
        return testHighlighter;
            """);
            testHighlighter.field(field);
                checkSame.accept(AbstractHighlighterBuilder::phraseLimit, FieldOptions::phraseLimit);
                assertEquals(encoder, field.fieldOptions().encoder());
        }
                highlightBuilder.preTags()
                 "body" : {},
                   }
import java.util.List;
import org.opensearch.core.xcontent.XContentParseException;
            )
                """);
            idxSettings,
            if (randomBoolean()) {
     * test that unknown field name cause exception
                    case 0:
    private static final int NUMBER_OF_TESTBUILDERS = 20;
import static java.util.Collections.emptyList;
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.mapper.ContentPath;
                {
            case 16:
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
            assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {
            """);
     * @param highlightBuilder provides the (optional) global builder parameter
                if (expectedValue instanceof char[]) {
                break;
        XContentParseException e = expectParseThrows(XContentParseException.class, """
    }
        assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));
                checkSame.accept(AbstractHighlighterBuilder::preTags, FieldOptions::preTags);
import org.junit.AfterClass;
    }
                assertNotSame(highlightBuilder, secondHighlightBuilder);
                    break;
            )
    public static void init() {
            containsString(
                    assertNull(fieldOptions.matchedFields());
    }
                        // change existing fields
                }
 * license agreements. See the NOTICE file distributed with
                assertEquals(expectedValue, actualValue);
            return randomBoolean();
import org.opensearch.common.settings.Settings;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                highlightBuilder.postTags(randomStringArray(4, 6));
            highlightBuilder.boundaryScannerLocale(randomLocale(random()).toLanguageTag());
            );
import org.opensearch.test.OpenSearchTestCase;
                break;
                assertEquals(expectedValue, fieldOptions.highlightQuery());
    private <T extends Throwable> T expectParseThrows(Class<T> exceptionClass, String highlightElement) throws IOException {
        }
            assertArrayEquals(
                    "bad_fieldname" : [ "field1" 1 "field2" ]
            assertThat(e.getCause().getMessage(), containsString("[fields] failed to parse field [body]"));
    /**
                    mutation.useExplicitFieldOrder(!original.useExplicitFieldOrder());
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
              "fields" : [ {
        }
            }
                    highlightBuilder,
            XContentParseException e = expectParseThrows(
        if (randomBoolean()) {
import org.junit.BeforeClass;
            Object actualValue = fieldOptionsParameterAccessor.apply(options);
import org.opensearch.Version;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(contentType);
                break;
            }
            XContentParseException e = expectParseThrows(XContentParseException.class, """
            SearchHighlightContext highlight = highlightBuilder.build(mockShardContext);
                checkSame.accept(AbstractHighlighterBuilder::noMatchSize, FieldOptions::noMatchSize);
            highlightBuilder.boundaryMaxScan(randomIntBetween(0, 10));
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());
            e.getCause().getMessage(),
        }
        highlightElement = "{ \"fields\" : { } }";
                FieldOptions fieldOptions = field.fieldOptions();
                return builder.build(new Mapper.BuilderContext(idxSettings.getSettings(), new ContentPath(1))).fieldType();
                    break;
            );
package org.opensearch.search.fetch.subphase.highlight;
                checkSame.accept(AbstractHighlighterBuilder::options, FieldOptions::options);
     * `tags_schema` is not produced by toXContent in the builder but should be parseable, so this
            }
                        break;
            for (SearchHighlightContext.Field field : highlight.fields()) {
                parser.nextToken();
        ParsingException err = expectParseThrows(ParsingException.class, "{\n" + "    \"pre_tags\" : [\"<a>\"]\n" + "}\n");
    public void testNoFieldsInObjectInFieldsArray() throws IOException {
    public void testSerialization() throws IOException {
                HighlightBuilder.DEFAULT_POST_TAGS,
            case 7:
     */
            Object fieldLevelValue = highlightBuilderParameterAccessor.apply(fieldBuilder);
    /**
            null,
            }
    }
            highlightBuilder.highlightQuery(highlightQuery);
 */
        }
            assertEquals("[4:9] [highlight_field] unknown field [bad_fieldname]", e.getCause().getCause().getMessage());
                        new TreeSet<>(fieldOptions.matchedFields()).toArray(new String[fieldOptions.matchedFields().size()])
            XContentParseException e = expectParseThrows(XContentParseException.class, """
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {
                "[fields] can be a single object with any number of fields "
    public void testEqualsAndHashcode() throws IOException {
            null,
        if (randomBoolean()) {
        assertEquals("pre_tags are set but post_tags are not set", e.getCause().getCause().getMessage());
            assertEquals("Unknown tag schema [somthing_else]", e.getCause().getMessage());
                    case 2:
        {
            assertArrayEquals(
            highlightBuilder.phraseLimit(randomIntBetween(0, 10));
        assertThat(
                Object value = null;
            assertEquals("expected plain HighlightBuilder", new HighlightBuilder(), highlightBuilder);
            );
    @BeforeClass
import org.opensearch.index.query.QueryShardContext;
    }
        if (randomBoolean()) {
            {
 * GitHub history for details.
                {
                    expectedValue = Rewriteable.rewrite(highlightBuilder.highlightQuery, mockShardContext).toQuery(mockShardContext);
     * setup for the whole base test class
            }
                checkSame.accept(AbstractHighlighterBuilder::requireFieldMatch, FieldOptions::requireFieldMatch);
                }
        }
        }
        if (randomBoolean()) {
    public static HighlightBuilder randomHighlighterBuilder() {
     */
    private static NamedXContentRegistry xContentRegistry;
                        copy,
            try (XContentParser parser = createParser(shuffled)) {
public class HighlightBuilderTests extends OpenSearchTestCase {
                break;
     * create random highlight builder that is put under test
                // change settings that only exists on top level
import java.util.Set;
        };
        assertThat(Order.SCORE.ordinal(), equalTo(1));
    /**
                {
        }
        HighlightBuilder testHighlighter = new HighlightBuilder();
                break;
import org.opensearch.common.io.stream.BytesStreamOutput;
                     "body" : {
                checkSame.accept(AbstractHighlighterBuilder::highlightFilter, FieldOptions::highlightFilter);
                break;
    private static String[] randomStringArray(int minSize, int maxSize) {
                checkSame.accept(AbstractHighlighterBuilder::boundaryChars, FieldOptions::boundaryChars);
     *
                options.put(randomAlphaOfLengthBetween(1, 10), value);
            case 3:
        setRandomCommonOptions(testHighlighter);
        );
                }
     */
import java.util.Map;
    public void testPreTagsWithoutPostTags() throws IOException {
            } else {
import org.opensearch.index.query.Rewriteable;
 * this work for additional information regarding copyright
                HighlightBuilder.DEFAULT_STYLED_POST_TAGS,
            containsString(
        );
            }
        if (randomBoolean()) {
                """);
                }
                "{\n" + "    \"tags_schema\" : \"somthing_else\"\n" + "}\n"
            setRandomCommonOptions(field);
     * before making the assertion that the value in the highlight builder and the actual value in the {@link FieldOptions}
                highlightBuilder.preTags(randomStringArray(4, 6));
                    highlightQuery = new TermQueryBuilder(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10));
            highlightQuery.boost((float) randomDoubleBetween(0, 10, false));
    public void testValidOrderOrdinals() {
     * @param fieldBuilder provides the (optional) field level parameter, if present this overwrites the global value
            HighlightBuilder highlightBuilder = HighlightBuilder.fromXContent(parser);
    public void testUnknownObjectFieldnameExpection() throws IOException {
    protected static XContentBuilder toXContent(HighlightBuilder highlight, XContentType contentType) throws IOException {
            testHighlighter.encoder(randomFrom(Arrays.asList(new String[] { "default", "html" })));
            } else {
import java.util.TreeSet;
        Set<String> randomStrings = new HashSet<>(size);
                            fieldToChange.matchedFields(randomStringArray(5, 10));
import org.opensearch.index.mapper.TextFieldMapper;
    * than what we have in the random {@link HighlightBuilder}
 * You may obtain a copy of the License at
                break;
                assertThat(in.readVInt(), equalTo(0));
                return hbfield;
    public static void afterClass() throws Exception {
    /**
                }
        assertThat(
        if (randomBoolean()) {
               }]
    private static void setRandomCommonOptions(AbstractHighlighterBuilder highlightBuilder) {
            System::currentTimeMillis,
            assertArrayEquals(
import org.opensearch.index.mapper.Mapper;
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
            null,
            }
                highlightBuilder.boundaryScannerType(randomFrom(BoundaryScannerType.values()));
                }
     * Create a generic helper function that performs all the work of merging the global highlight builder parameter,
            highlightBuilder.boundaryChars(randomAlphaOfLengthBetween(1, 10).toCharArray());
        assertThat(e.getCause().getMessage(), containsString("[fields] failed to parse field [body]"));
                        Field fieldToChange = originalFields.get(randomInt(originalFields.size() - 1));
        if (randomBoolean()) {
                XContentParseException.class,
        return null;
    /**
                switch (randomInt(2)) {
    /**
        {
            highlightBuilder.postTags(randomStringArray(0, 3));
                Query expectedValue = null;
                    highlightBuilder.order(Order.SCORE);
                // this way `fields` is printed out as a json array
                }
        String highlightElement = "{ }";
                    assertArrayEquals((Character[]) expectedValue, (Character[]) actualValue);
            }
                BiConsumer<Function<AbstractHighlighterBuilder<?>, Object>, Function<FieldOptions, Object>> checkSame = mergeBeforeChek(
    }
                checkSame.accept(AbstractHighlighterBuilder::fragmentSize, FieldOptions::fragmentCharSize);
        return builder;
 * specific language governing permissions and limitations
        }
            XContentParseException e = expectParseThrows(XContentParseException.class, """
                } else {
        return mutation;
import org.opensearch.common.util.BigArrays;
                assertEquals(fieldBuilder.fragmentOffset, fieldOptions.fragmentOffset());
    }
import org.opensearch.search.SearchModule;
        }
    public void testParsingEmptyStructure() throws IOException {
        }
            }
            case 10:
        namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
                assertArrayEquals((String[]) expectedValue, (String[]) actualValue);
                highlightBuilder.numOfFragments(randomIntBetween(11, 20));
                checkSame.accept(AbstractHighlighterBuilder::boundaryScannerType, FieldOptions::boundaryScannerType);
    }
        switch (randomIntBetween(1, 16)) {
            XContentParseException e = expectParseThrows(XContentParseException.class, """
        }
    public void testParsingTagsSchema() throws IOException {
        if (randomBoolean()) {
     */
     * the (potential) overwrite on the field level and the default value from {@link HighlightBuilder#defaultOptions}
                builder = builder.prettyPrint();
                        }
            HighlightBuilder highlightBuilder = randomHighlighterBuilder();
     * Test serialization and deserialization of the highlighter builder
                HighlightBuilder.DEFAULT_PRE_TAGS,
        FieldOptions options
    public void testTwoFieldsInObjectInFieldsArray() throws IOException {
                    + "or an array where each entry is an object with a single field"
import org.opensearch.common.xcontent.json.JsonXContent;
            )
                        value = randomAlphaOfLengthBetween(1, 10);
            HighlightBuilder deserialized = serializedCopy(original);
                    case 1:
        }
                        "bad_fieldname" : { "field" : "value" }
        }
     */
            0,
                            fieldToChange.fragmentOffset(randomIntBetween(101, 200));
                break;
                }
            assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));
            assertEquals("defining no field should return plain HighlightBuilder", new HighlightBuilder(), highlightBuilder);
                highlightBuilder.postTags()
    private static NamedWriteableRegistry namedWriteableRegistry;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {
            {
/*
        String highlightElement = "{\n" + "    \"tags_schema\" : \"styled\"\n" + "}\n";
        );
        {
            Field field = new Field(i + "_" + randomAlphaOfLengthBetween(1, 10));
                highlightBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
                break;
import org.opensearch.index.IndexSettings;
                if (fieldBuilder.highlightQuery != null) {
                int items = 6;
            highlightBuilder = Rewriteable.rewrite(highlightBuilder, mockShardContext);
        if (randomBoolean()) {
     *  creates random highlighter, renders it to xContent and back to new instance that should be equal to original
                {
        return OpenSearchTestCase.copyWriteable(original, namedWriteableRegistry, HighlightBuilder::new);
     * test that unknown field name cause exception
                assertNotNull("expected a highlight builder for field " + field.field(), fieldBuilder);
 * ownership. Elasticsearch licenses this file to you under
                } else {
            highlightBuilder.fragmentSize(randomIntBetween(0, 100));
 *
        } else {
    }
            mutateCommonOptions(mutation);
                expectedValue = fieldOptionsParameterAccessor.apply(HighlightBuilder.defaultOptions);
                HighlightBuilder secondHighlightBuilder;
            case 2:
                break;
            assertEquals("[2:5] [highlight] unknown field [bad_fieldname]", e.getMessage());
                "[fields] can be a single object with any number of fields "
                highlightBuilder.boundaryChars(randomAlphaOfLengthBetween(11, 20).toCharArray());
            XContentParseException e = expectParseThrows(XContentParseException.class, """
            e.getCause().getMessage(),
            HighlightBuilder highlightBuilder = HighlightBuilder.fromXContent(parser);
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
                        value = Boolean.valueOf(randomBoolean());
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {
        }
                checkSame.accept(AbstractHighlighterBuilder::order, op -> op.scoreOrdered() ? Order.SCORE : Order.NONE);
            null,
            highlightBuilder.highlighterType(randomAlphaOfLengthBetween(1, 10));
                        if (randomBoolean()) {
            Order.SCORE.writeTo(out);
                    fieldOptions
     */
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(index, indexSettings);
     */
                default:
    @SuppressWarnings({ "rawtypes" })
            return expectThrows(exceptionClass, () -> HighlightBuilder.fromXContent(parser));
            "{\n" + "  \"fields\" : {\n" + "     \"body\" : {\n" + "        \"pre_tags\" : [\"<a>\"]\n" + "     }\n" + "   }\n" + "}\n"
    }
     */
 * software distributed under the License is distributed on an
                for (int i = 0; i < items; i++) {
                break;
                highlightBuilder.order(randomFrom(Order.values()).toString());
            assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));
                highlightBuilder.options(options);
                    + "or an array where each entry is an object with a single field"
                field.fragmentOffset(randomIntBetween(1, 100));
        if (randomBoolean()) {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {
import org.opensearch.index.query.MatchAllQueryBuilder;
     */
                     }
    }
import java.util.function.Function;
        if (randomBoolean()) {
