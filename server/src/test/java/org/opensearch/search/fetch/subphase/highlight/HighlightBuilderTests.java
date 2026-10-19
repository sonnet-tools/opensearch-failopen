            highlightBuilder.fragmenter(randomAlphaOfLengthBetween(1, 10));
                break;  
    public static HighlightBuilder randomHighlighterBuilder() {
                highlightBuilder.postTags()
                }
     */
        {
                checkSame.accept(AbstractHighlighterBuilder::postTags, FieldOptions::postTags);
                    assertArrayEquals(HighlightBuilder.convertCharArray((char[]) expectedValue), (Character[]) actualValue);  
                assertEquals(expectedValue, fieldOptions.highlightQuery());  
import org.junit.AfterClass;
            return randomBoolean();
 * license agreements. See the NOTICE file distributed with
            HighlightBuilder highlightBuilder = HighlightBuilder.fromXContent(parser);
                TextFieldMapper.Builder builder = new TextFieldMapper.Builder(name, createDefaultIndexAnalyzers());
            } else if (globalLevelValue != null) {
    }
        };
     * test that unknown array fields cause exception  
                } else {  
                        value = Boolean.valueOf(randomBoolean());
                highlightBuilder.numOfFragments(randomIntBetween(11, 20));
import java.util.Map;  
                    + "or an array where each entry is an object with a single field"
            highlightBuilder.preTags(randomStringArray(0, 3));
                case 0:
                case 0:
            highlightBuilder.postTags(randomStringArray(0, 3));
                        mutation.field(new Field(randomAlphaOfLength(10)));
            assertEquals("expected HighlightBuilder with field", new HighlightBuilder().field(new Field("foo")), highlightBuilder);  
     * mutate the given highlighter builder so the returned one is different in one aspect
    private static BiConsumer<Function<AbstractHighlighterBuilder<?>, Object>, Function<FieldOptions, Object>> mergeBeforeChek(  
                    if (randomBoolean()) {
        }
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
    public void testNoFieldsInObjectInFieldsArray() throws IOException {
            assertThat(e.getCause().getMessage(), containsString("[fields] failed to parse field [body]"));
 * Licensed to Elasticsearch under one or more contributor  
        );
            assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));  
    }  
                }
            case 11:
            case 16:  
                highlightBuilder.boundaryChars(randomAlphaOfLengthBetween(11, 20).toCharArray());
import java.io.IOException;
            highlightBuilder = Rewriteable.rewrite(highlightBuilder, mockShardContext);
                Map<String, Object> options = new HashMap<>(items);  
            } else {
                checkSame.accept(AbstractHighlighterBuilder::noMatchSize, FieldOptions::noMatchSize);
            if (actualValue instanceof String[]) {
                highlightBuilder.preTags()
        }  
        }
            }  
                    highlightBuilder,
                checkSame.accept(AbstractHighlighterBuilder::boundaryMaxScan, FieldOptions::boundaryMaxScan);  
            }  
                checkSame.accept(AbstractHighlighterBuilder::highlighterType, FieldOptions::highlighterType);
    }
        FieldOptions options  
            assertEquals("[2:5] [highlight] unknown field [bad_fieldname]", e.getMessage());
                    highlightQuery = new IdsQueryBuilder();
     * before making the assertion that the value in the highlight builder and the actual value in the {@link FieldOptions}
            Object globalLevelValue = highlightBuilderParameterAccessor.apply(highlightBuilder);
                    );
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.Field;
                highlightBuilder.postTags(randomStringArray(4, 6));
        assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));  
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
                "[fields] can be a single object with any number of fields "
     * Create array of unique Strings. If not unique, e.g. duplicates field names  
        }
                break;  
                    break;  
        }
            public MappedFieldType fieldMapper(String name) {
                    highlightQuery = new MatchAllQueryBuilder();
                  "fields" : {
        }
                expectedValue = globalLevelValue;  
        }
            case 4:
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {
            builder = builder.prettyPrint();
            case 9:
 * not use this file except in compliance with the License.
                BiConsumer<Function<AbstractHighlighterBuilder<?>, Object>, Function<FieldOptions, Object>> checkSame = mergeBeforeChek(
                assertNotSame(highlightBuilder, secondHighlightBuilder);
            assertEquals("Unknown tag schema [somthing_else]", e.getCause().getMessage());
                assertEquals(expectedValue, actualValue);
        }
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.index.query.QueryShardContext;  
 * under the License.  
                    fieldOptions
 */
            assertEquals("expected plain HighlightBuilder", new HighlightBuilder(), highlightBuilder);  
            Object fieldLevelValue = highlightBuilderParameterAccessor.apply(fieldBuilder);
        if (randomBoolean()) {
    /**
import org.opensearch.test.OpenSearchTestCase;  
 * ownership. Elasticsearch licenses this file to you under  
    private static NamedWriteableRegistry namedWriteableRegistry;
        }  
 * Modifications Copyright OpenSearch Contributors. See
    }
        if (randomBoolean()) {
                Object value = null;
        {
            null,
                    expectedValue = Rewriteable.rewrite(highlightBuilder.highlightQuery, mockShardContext).toQuery(mockShardContext);
                builder = builder.prettyPrint();  
    @AfterClass  
            e.getCause().getMessage(),  
        }
            highlightBuilder.numOfFragments(randomIntBetween(0, 10));
            "{\n" + "  \"fields\" : {\n" + "     \"body\" : {\n" + "        \"pre_tags\" : [\"<a>\"]\n" + "     }\n" + "   }\n" + "}\n"
    public void testStringInFieldsArray() throws IOException {  
import org.junit.BeforeClass;
            }  
                    Arrays.sort(copy);
        if (randomBoolean()) {
        }
            null,
            XContentParseException e = expectParseThrows(XContentParseException.class, """
        setRandomCommonOptions(testHighlighter);
                checkSame.accept(AbstractHighlighterBuilder::fragmenter, FieldOptions::fragmenter);
            if (randomBoolean()) {
        }
                        break;  
        if (randomBoolean()) {
    }  
    }  
        );
        if (randomBoolean()) {
                break;  
                 "nope" : {}  
     */
    }
                }  
                    break;  
     */
                break;  
     * test that unknown field name cause exception
                }  
            {  
            HighlightBuilder highlightBuilder = HighlightBuilder.fromXContent(parser);
                highlightBuilder.highlightQuery(
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {
        assertThat(e.getCause().getMessage(), containsString("[fields] failed to parse field [body]"));
 *
            )
                parser.nextToken();  
    }
            switch (randomIntBetween(0, 2)) {
    /**
            assertEquals("[2:5] [highlight] unknown field [bad_fieldname]", e.getMessage());
        }  
/*
    private static HighlightBuilder serializedCopy(HighlightBuilder original) throws IOException {  
    /**  
    public static void init() {  
        }
        };
import org.opensearch.core.xcontent.XContentBuilder;
            assertThat(e.getCause().getMessage(), containsString("[fields] failed to parse field [body]"));
     * would be dropped in {@link FieldOptions.Builder#matchedFields(Set)}, resulting in test glitches
            case 15:
            highlightBuilder.boundaryScannerLocale(randomLocale(random()).toLanguageTag());
        }
        XContentParseException e = expectParseThrows(XContentParseException.class, """
import org.opensearch.index.query.Rewriteable;
                checkSame.accept(AbstractHighlighterBuilder::preTags, FieldOptions::preTags);  
                }
import org.opensearch.core.xcontent.NamedXContentRegistry;
            }
import org.opensearch.core.common.ParsingException;  
        if (randomBoolean()) {
            """);  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {
                break;  
import java.util.List;
                    assertArrayEquals(
                {
import org.opensearch.index.mapper.ContentPath;
        Index index = new Index(randomAlphaOfLengthBetween(1, 10), "_na_");
     */  
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
        {
                shuffled = shuffleXContent(builder);
    }
 * software distributed under the License is distributed on an
                checkSame.accept(AbstractHighlighterBuilder::numOfFragments, FieldOptions::numberOfFragments);
    private static String[] randomStringArray(int minSize, int maxSize) {  
    public static void afterClass() throws Exception {
    /**
import org.opensearch.core.xcontent.XContentParser;  
    }
import org.opensearch.core.index.Index;  
 * You may obtain a copy of the License at  
        if (randomBoolean()) {
    }  
                {  
        }  
                break;  
                }
            Object expectedValue = null;  
                assertNotNull("expected a highlight builder for field " + field.field(), fieldBuilder);
        if (randomBoolean()) {  
     * passed in is the same.  
                    + "or an array where each entry is an object with a single field"  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                highlightBuilder.fragmentSize(randomIntBetween(101, 200));
                highlightBuilder.forceSource(toggleOrSet(highlightBuilder.forceSource()));
     */  
            }
        }  
 */  
     */  
            HighlightBuilder original = randomHighlighterBuilder();
import static org.hamcrest.Matchers.containsString;
            if (fieldLevelValue != null) {  
                """);
 *    http://www.apache.org/licenses/LICENSE-2.0
                    highlightQuery = new TermQueryBuilder(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10));  
    }
    /**
    @Override
            }
            assertEquals(deserialized.hashCode(), original.hashCode());
import org.opensearch.index.query.TermQueryBuilder;
                assertEquals(fieldBuilder.fragmentOffset, fieldOptions.fragmentOffset());
    @SuppressWarnings({ "rawtypes" })  
        {  
    private static NamedXContentRegistry xContentRegistry;  
import java.util.Arrays;
            XContentParseException e = expectParseThrows(XContentParseException.class, """  
                     "body" : {  
                HighlightBuilder.DEFAULT_STYLED_POST_TAGS,  
    protected NamedXContentRegistry xContentRegistry() {
                case 1:
                    expectedValue = Rewriteable.rewrite(fieldBuilder.highlightQuery, mockShardContext).toQuery(mockShardContext);
                for (int i = 0; i < items; i++) {
     */
        return OpenSearchTestCase.copyWriteable(original, namedWriteableRegistry, HighlightBuilder::new);
     * the (potential) overwrite on the field level and the default value from {@link HighlightBuilder#defaultOptions}
            if (randomBoolean()) {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(contentType);  
                assertEquals(highlightBuilder, secondHighlightBuilder);
    }  
     * setup for the whole base test class  
                return hbfield;
                );
                expectedValue = fieldOptionsParameterAccessor.apply(HighlightBuilder.defaultOptions);
            assertNotSame(deserialized, original);  
                default:
     */
                    fieldBuilder,  
            case 13:
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.Order;  
        for (int i = 0; i < numberOfFields; i++) {
                highlightBuilder.useExplicitFieldOrder(true);  
import static org.hamcrest.Matchers.equalTo;  
        }
    * test that build() outputs a {@link SearchHighlightContext} that is has similar parameters  
            );
            case 10:
                highlightBuilder.preTags()  
    }  
            assertArrayEquals(
            containsString(
package org.opensearch.search.fetch.subphase.highlight;
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                    secondHighlightBuilder = HighlightBuilder.fromXContent(parser);  
                assertThat(in.readVInt(), equalTo(0));
            try (StreamInput in = out.bytes().streamInput()) {
                } else {
            highlightBuilder.requireFieldMatch(randomBoolean());  
    /**
    private static Boolean toggleOrSet(Boolean flag) {  
                HighlightBuilder secondHighlightBuilder;
                checkSame.accept(AbstractHighlighterBuilder::highlightFilter, FieldOptions::highlightFilter);
            try (StreamInput in = out.bytes().streamInput()) {
                        break;  
                highlightBuilder.boundaryScannerType(randomFrom(BoundaryScannerType.values()));
import org.opensearch.common.xcontent.json.JsonXContent;
        String highlightElement = "{\n" + "    \"tags_schema\" : \"styled\"\n" + "}\n";
    public void testTwoFieldsInObjectInFieldsArray() throws IOException {
                highlightBuilder.highlightFilter(toggleOrSet(highlightBuilder.highlightFilter()));
        return testHighlighter;  
import org.opensearch.common.util.BigArrays;  
            idxSettings,
            }
        ) {
            Order.SCORE.writeTo(out);
        }  
 * this file be licensed under the Apache-2.0 license or a
            XContentParseException e = expectParseThrows(
                if (fieldBuilder.highlightQuery != null) {
            Map<String, Object> options = new HashMap<>(items);  
                        List<Field> originalFields = original.fields();
        }  
import org.opensearch.index.mapper.TextFieldMapper;
    }
                     }
                    "bad_fieldname" : [ "field1" 1 "field2" ]  
                break;
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
        }
        if (randomBoolean()) {
            HighlightBuilder highlightBuilder = HighlightBuilder.fromXContent(parser);
    private static Field getFieldBuilderByName(HighlightBuilder highlightBuilder, String fieldName) {
        }
import java.util.HashMap;  
                break;  
            null,
            assertArrayEquals(
            if (randomBoolean()) {
                        // change existing fields  
        namedWriteableRegistry = null;
    public void testBuildSearchContextHighlight() throws IOException {  
    @BeforeClass
            }
                     "body" : {
     */
                );
            HighlightBuilder highlightBuilder = randomHighlighterBuilder();  
            assertEquals("[4:9] [highlight_field] unknown field [bad_fieldname]", e.getCause().getCause().getMessage());  
                highlightBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
}
            for (int i = 0; i < items; i++) {
                checkSame.accept(AbstractHighlighterBuilder::options, FieldOptions::options);
                {
 * this work for additional information regarding copyright
                break;  
            Object actualValue = fieldOptionsParameterAccessor.apply(options);
import java.util.HashSet;
                    options.put(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10));
        return xContentRegistry;  
               }]
                   }  
            }
                  "fields" : {
                    case 2:
              "fields" : [ {
            // need to set this together, otherwise parsing will complain  
     * @param options the target field options that are checked
                case 1:
     */
        return (highlightBuilderParameterAccessor, fieldOptionsParameterAccessor) -> {
            } else {
    }
    }  
                    case 1:
    /**
        if (randomBoolean()) {
                """);
                }
            highlightBuilder.noMatchSize(randomIntBetween(0, 10));
            highlightBuilder.highlightQuery(highlightQuery);
            () -> true,  
    /**  
                        }
            if (randomBoolean()) {  
    }  
                    break;  
                  "fields" : {  
                highlightBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
                        Field fieldToChange = originalFields.get(randomInt(originalFields.size() - 1));
            return !flag.booleanValue();
                highlightBuilder.postTags()
        for (Field hbfield : highlightBuilder.fields()) {
import java.util.function.BiConsumer;  
                   }
        if (randomBoolean()) {
            null,
    }
        }
        HighlightBuilder mutation = serializedCopy(original);
                 "body" : {},
            highlightBuilder.phraseLimit(randomIntBetween(0, 10));
            XContentBuilder shuffled;  
                }  
                if (expectedValue instanceof char[]) {
    private static HighlightBuilder mutate(HighlightBuilder original) throws IOException {  
                    case 0:
            assertArrayEquals(  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {
                "setting tags_schema 'default' should alter post_tags",  
            containsString(  
import org.opensearch.index.mapper.Mapper;
                "{\n" + "    \"tags_schema\" : \"somthing_else\"\n" + "}\n"
import org.opensearch.search.fetch.subphase.highlight.SearchHighlightContext.FieldOptions;
                break;  
     * Test equality and hashCode properties
    public void testEqualsAndHashcode() throws IOException {
        assertEquals("pre_tags are set but post_tags are not set", e.getCause().getCause().getMessage());
            null,
        Set<String> randomStrings = new HashSet<>(size);
            assertEquals("[4:9] [highlight_field] unknown field [bad_fieldname]", e.getCause().getCause().getMessage());
        }
     * test parsing empty highlight or empty fields blocks  
                checkSame.accept(AbstractHighlighterBuilder::requireFieldMatch, FieldOptions::requireFieldMatch);  
    protected static XContentBuilder toXContent(HighlightBuilder highlight, XContentType contentType) throws IOException {
                assertEquals(highlightBuilder.hashCode(), secondHighlightBuilder.hashCode());  
                break;  
    ) {
            case 6:
        }  
                "[fields] can be a single object with any number of fields "
        highlightElement = "{ \"fields\" : { \"foo\" : { } } }";  
            case 7:
                FieldOptions fieldOptions = field.fieldOptions();
                } catch (RuntimeException e) {
            try (XContentParser parser = createParser(shuffled)) {
            e.getCause().getMessage(),  
                    } else {
import org.opensearch.index.query.MatchAllQueryBuilder;
                highlightBuilder.boundaryScannerType(randomFrom(BoundaryScannerType.values()).toString());
                    mutation.useExplicitFieldOrder(!original.useExplicitFieldOrder());
     * adds a simple json test for this.  
        assertThat(Order.SCORE.ordinal(), equalTo(1));
                "setting tags_schema 'styled' should alter post_tags",
                break;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            if (randomBoolean()) {
                // this way `fields` is printed out as a json array
        testHighlighter.useExplicitFieldOrder(randomBoolean());
            HighlightBuilder highlightBuilder = HighlightBuilder.fromXContent(parser);
            QueryBuilder highlightQuery;
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.BoundaryScannerType;
            assertArrayEquals(
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());  
            assertThat(e.getCause().getMessage(), containsString("[fields] failed to parse field [body]"));
            null,  
        if (randomBoolean()) {
        }  
    public void testPreTagsWithoutPostTags() throws IOException {
            null,
import org.opensearch.index.mapper.MappedFieldType;  
            );
    /**
            0,  
    }
            );  
     * @param fieldBuilder provides the (optional) field level parameter, if present this overwrites the global value  
        assertThat(
                """);
        if (flag == null) {
                assertEquals(encoder, field.fieldOptions().encoder());
        if (randomBoolean()) {
    public void testUnknownFieldnameExpection() throws IOException {
        return randomStrings.toArray(new String[0]);  
                highlightBuilder.order(randomFrom(Order.values()));
            }  
/*  
            case 12:
                return builder.build(new Mapper.BuilderContext(idxSettings.getSettings(), new ContentPath(1))).fieldType();  
                    new TermQueryBuilder(randomAlphaOfLengthBetween(11, 20), randomAlphaOfLengthBetween(11, 20))  
                highlightBuilder.phraseLimit(randomIntBetween(11, 20));
            )  
            XContentParseException e = expectParseThrows(XContentParseException.class, """
public class HighlightBuilderTests extends OpenSearchTestCase {
 * KIND, either express or implied.  See the License for the
            case 3:
                HighlightBuilder.DEFAULT_STYLED_PRE_TAG,
        }
        if (randomBoolean()) {  
    /**
        for (int f = 0; f < size; f++) {  
import org.opensearch.index.query.IdsQueryBuilder;  
        HighlightBuilder testHighlighter = new HighlightBuilder();  
                options.put(randomAlphaOfLengthBetween(1, 10), value);
                    }
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
                        "bad_fieldname" : "value"
                {
                break;  
            XContentParseException.class,  
    }
    }
            Order.NONE.writeTo(out);  
            setRandomCommonOptions(field);  
                }
                field.matchedFields(randomStringArray(0, 4));
import java.util.TreeSet;
                   }  
                if (fieldBuilder.matchedFields != null) {
     *
            }  
    public void testParsingEmptyStructure() throws IOException {
                    throw new RuntimeException("Error parsing " + highlightBuilder, e);
     * @param highlightBuilder provides the (optional) global builder parameter
            """);  
            XContentParseException e = expectParseThrows(XContentParseException.class, """  
    /**  
                "[fields] can be a single object with any number of fields "
            XContentParseException e = expectParseThrows(XContentParseException.class, """  
import org.opensearch.common.settings.Settings;
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
                if (highlightBuilder.order() == Order.NONE) {
        if (randomBoolean()) {
                } else if (highlightBuilder.highlightQuery != null) {  
        }
                }
                    assertArrayEquals((Character[]) expectedValue, (Character[]) actualValue);
            highlightBuilder.boundaryMaxScan(randomIntBetween(0, 10));
        {
        assertEquals("pre_tags are set but post_tags are not set", err.getMessage());  
    }
            case 1:
    public void testOrderSerialization() throws Exception {
                        new TreeSet<>(fieldOptions.matchedFields()).toArray(new String[fieldOptions.matchedFields().size()])
 * Unless required by applicable law or agreed to in writing,
    private <T extends Throwable> T expectParseThrows(Class<T> exceptionClass, String highlightElement) throws IOException {
        return builder;
            testHighlighter.encoder(randomFrom(Arrays.asList(new String[] { "default", "html" })));
            assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));
 * GitHub history for details.
    }
                            fieldToChange.matchedFields(randomStringArray(5, 10));  
     */
            highlightBuilder.highlighterType(randomAlphaOfLengthBetween(1, 10));
            assertThat(e.getMessage(), containsString("[highlight] failed to parse field [tags_schema]"));  
                }  
            )
                        value = randomAlphaOfLengthBetween(1, 10);
    /**
                break;  
            case 2:
        String highlightElement = "{ }";  
            case 14:
            checkEqualsAndHashCode(randomHighlighterBuilder(), HighlightBuilderTests::serializedCopy, HighlightBuilderTests::mutate);  
        xContentRegistry = null;  
                    "bad_fieldname" : "value"
import org.opensearch.index.IndexSettings;
            highlightElement = "{\n" + "    \"tags_schema\" : \"default\"\n" + "}\n";
import org.opensearch.common.io.stream.BytesStreamOutput;
        }  
    */
            randomStrings.add(randomAlphaOfLengthBetween(3, 10));
                    break;
/*  
                assertArrayEquals((String[]) expectedValue, (String[]) actualValue);  
    public void testUnknownObjectFieldnameExpection() throws IOException {  
                """);
                }
            }  
            e.getCause().getMessage(),
        );
        highlight.toXContent(builder, ToXContent.EMPTY_PARAMS);
            } else if (actualValue instanceof Character[]) {
        XContentParseException e = expectParseThrows(XContentParseException.class, """
        assertThat(Order.NONE.ordinal(), equalTo(0));  
                """);
    }
            } else {
            null
     * Create a generic helper function that performs all the work of merging the global highlight builder parameter,  
                try {
        QueryShardContext mockShardContext = new QueryShardContext(
                {"fields" : [ "junk" ]}
            } else {  
        }  
        XContentParseException e = expectParseThrows(XContentParseException.class, """  
            }
        if (randomBoolean()) {
        }  
                assertThat(in.readVInt(), equalTo(1));  
    private static void mutateCommonOptions(AbstractHighlighterBuilder highlightBuilder) {
            highlightBuilder.forceSource(randomBoolean());  
            assertEquals(deserialized, original);
import org.opensearch.test.IndexSettingsModule;
            if (hbfield.name().equals(fieldName)) {  
        }  
            highlightBuilder.fragmentSize(randomIntBetween(0, 100));
                checkSame.accept(AbstractHighlighterBuilder::fragmentSize, FieldOptions::fragmentCharSize);
            );  
            {
                // also test the string setter  
            }  
            highlightBuilder.boundaryChars(randomAlphaOfLengthBetween(1, 10).toCharArray());
 * The OpenSearch Contributors require contributions made to  
     */
        return null;
                break;
        {  
            @Override  
 * SPDX-License-Identifier: Apache-2.0
                shuffled = shuffleXContent(builder, "fields");
            }
                {
        mockShardContext.setMapUnmappedFieldAsString(true);  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else {  
        XContentParseException e = expectParseThrows(
        } else {
    public void testSerialization() throws IOException {  
                        "bad_fieldname" : [ "field1" , "field2" ]
    /**
                case 2:
                    break;  
import org.opensearch.index.query.QueryBuilder;
        }  
        return mutation;  
        highlightElement = "{ \"fields\" : { } }";  
import org.opensearch.search.SearchModule;  
 */  
        int numberOfFields = randomIntBetween(1, 5);  
                        if (randomBoolean()) {  
     */
     * test ordinals of {@link Order}, since serialization depends on it  
        }
            """);
import org.opensearch.common.xcontent.XContentType;
            highlightQuery.boost((float) randomDoubleBetween(0, 10, false));  
                switch (randomInt(2)) {  
                    + "or an array where each entry is an object with a single field"  
     * `tags_schema` is not produced by toXContent in the builder but should be parseable, so this
    private static void setRandomCommonOptions(AbstractHighlighterBuilder highlightBuilder) {
                }  
        if (randomBoolean()) {
    public void testFromXContent() throws IOException {
            Field field = new Field(i + "_" + randomAlphaOfLengthBetween(1, 10));
                    mutation.encoder(original.encoder() + randomAlphaOfLength(2));
            HighlightBuilder highlightBuilder = HighlightBuilder.fromXContent(parser);
                // change settings that only exists on top level  
                case 2:
        }  
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
                expectedValue = fieldLevelValue;
            HighlightBuilder deserialized = serializedCopy(original);  
            namedWriteableRegistry,  
        assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));
                     }
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(index, indexSettings);  
                final Field fieldBuilder = getFieldBuilderByName(highlightBuilder, field.field());  
                        "bad_fieldname" : { "field" : "value" }
     * Test serialization and deserialization of the highlighter builder
                    "bad_fieldname" :  { "field" : "value" }
            int items = randomIntBetween(0, 5);
        assertThat(
        }
        assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));
 * compatible open source license.
            return expectThrows(exceptionClass, () -> HighlightBuilder.fromXContent(parser));  
        }  
     *  creates random highlighter, renders it to xContent and back to new instance that should be equal to original
                highlightBuilder.highlighterType(randomAlphaOfLengthBetween(11, 20));
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
                        value = Integer.valueOf(randomInt(1000));
            System::currentTimeMillis,  
    }  
                checkSame.accept(AbstractHighlighterBuilder::phraseLimit, FieldOptions::phraseLimit);  
                String encoder = highlightBuilder.encoder() != null ? highlightBuilder.encoder() : HighlightBuilder.DEFAULT_ENCODER;
    /**
        int size = randomIntBetween(minSize, maxSize);
                checkSame.accept(AbstractHighlighterBuilder::order, op -> op.scoreOrdered() ? Order.SCORE : Order.NONE);  
                {
    @SuppressWarnings({ "unchecked", "rawtypes" })
                    assertNull(fieldOptions.matchedFields());
        assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));  
                field.fragmentOffset(randomIntBetween(1, 100));
import org.apache.lucene.search.Query;
import org.opensearch.Version;
        Field fieldBuilder,
                checkSame.accept(AbstractHighlighterBuilder::boundaryChars, FieldOptions::boundaryChars);
                highlightBuilder.fragmenter(randomAlphaOfLengthBetween(11, 20));
            HighlightBuilder highlightBuilder = randomHighlighterBuilder();  
 *
                     }  
            XContentParseException e = expectParseThrows(XContentParseException.class, """
        // shard context will only need indicesQueriesRegistry for building Query objects nested in highlighter
        ParsingException err = expectParseThrows(ParsingException.class, "{\n" + "    \"pre_tags\" : [\"<a>\"]\n" + "}\n");
    * than what we have in the random {@link HighlightBuilder}
            highlightBuilder.highlightFilter(randomBoolean());  
                     "body" : {  
            assertThat(e.getMessage(), containsString("[highlight] failed to parse field [fields]"));  
            }
     * test that unknown field name cause exception
            null,  
            switch (randomInt(2)) {  
                XContentParseException.class,  
                highlightBuilder.order(randomFrom(Order.values()).toString());
                    break;  
import java.util.function.Function;
     * create random highlight builder that is put under test  
            xContentRegistry(),
            case 5:
                            fieldToChange.fragmentOffset(randomIntBetween(101, 200));
import static java.util.Collections.emptyList;  
import java.util.Set;
            assertEquals("[2:5] [highlight] unknown field [bad_fieldname]", e.getMessage());  
                        break;  
            BigArrays.NON_RECYCLING_INSTANCE,
                "setting tags_schema 'styled' should alter pre_tags",  
        if (randomBoolean()) {
            );
                highlightBuilder.boundaryMaxScan(randomIntBetween(11, 20));
    }
            mutateCommonOptions(mutation);  
                        // add another field  
            assertEquals("defining no field should return plain HighlightBuilder", new HighlightBuilder(), highlightBuilder);  
                HighlightBuilder.DEFAULT_PRE_TAGS,
                Query expectedValue = null;  
                highlightBuilder.options(options);
        if (randomBoolean()) {
 *  
import org.opensearch.cluster.metadata.IndexMetadata;  
            }  
                    highlightBuilder.order(Order.NONE);
        namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
            if (randomBoolean()) {
               }]  
                break;  
import org.opensearch.core.xcontent.ToXContent;  
        }
            assertEquals("[4:9] [highlight_field] unknown field [bad_fieldname]", e.getCause().getCause().getMessage());
        assertThat(
 * specific language governing permissions and limitations
        }  
    private static final int NUMBER_OF_TESTBUILDERS = 20;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {  
            }
        if (randomBoolean()) {
        } else {  
            containsString(
 * the Apache License, Version 2.0 (the "License"); you may
    public void testParsingTagsSchema() throws IOException {
              "fields" : [ {
                    String[] copy = Arrays.copyOf(fieldBuilder.matchedFields, fieldBuilder.matchedFields.length);  
import org.opensearch.core.xcontent.XContentParseException;
                "setting tags_schema 'default' should alter pre_tags",
            testHighlighter.field(field);
            }
    public void testUnknownArrayNameExpection() throws IOException {
                        copy,  
                """);  
        switch (randomIntBetween(1, 16)) {  
    /**
        HighlightBuilder highlightBuilder,
    }
                HighlightBuilder.DEFAULT_POST_TAGS,
        }  
        );
                // also test the string setter
                        } else {
        }
        }
                highlightBuilder.noMatchSize(randomIntBetween(11, 20));
            SearchHighlightContext highlight = highlightBuilder.build(mockShardContext);
                } else {  
            null,
                    highlightBuilder.order(Order.SCORE);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, highlightElement)) {
            for (SearchHighlightContext.Field field : highlight.fields()) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }
    }
                highlightBuilder.preTags(randomStringArray(4, 6));
                highlightBuilder.requireFieldMatch(toggleOrSet(highlightBuilder.requireFieldMatch()));
                checkSame.accept(AbstractHighlighterBuilder::boundaryScannerType, FieldOptions::boundaryScannerType);
                int items = 6;
    public void testValidOrderOrdinals() {
            case 8:  
