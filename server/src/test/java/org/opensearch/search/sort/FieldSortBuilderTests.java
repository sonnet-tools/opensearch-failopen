        sortBuilder = new FieldSortBuilder("value").order(SortOrder.DESC);
     */
                }
                    }
                    doc.add(new TextField(fieldName, values[i].utf8ToString(), Field.Store.NO));
                            context,
import org.apache.lucene.document.Field;
    @Override
                if (randomBoolean()) {
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
                            assertNull(getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName + "-ni")));
        sortBuilder = new FieldSortBuilder("fieldName").setNestedPath("path");
                } else {
        expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE);
                            context,
        assertEquals(expectedSortField, sortField);
import java.util.ArrayList;
            final MappedFieldType fieldType;
        }
import java.util.Locale;
 *
                mutated.unmappedType(randomValueOtherThan(original.unmappedType(), () -> randomAlphaOfLengthBetween(1, 10)));
        sortField = sortBuilder.build(shardContextMock).field;
        QueryShardContext context = createMockShardContext();
                            new SearchSortValuesAndFormats(new Object[] { maxValue }, new DocValueFormat[] { DocValueFormat.RAW })
        sortBuilder = new FieldSortBuilder("value").sortMode(SortMode.MEDIAN);
    public void testNestedSortBothThrows() throws IOException {
    }
                Arrays.sort(values);
            final long[] values = new long[numDocs];
        FieldSortBuilder sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME);
                                byte v6 = randomByte();
        if (randomBoolean()) {
 * SPDX-License-Identifier: Apache-2.0
                }
        assertEquals(expectedSortField, sortField);
                            assertEquals(values[numDocs - 1], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMax());
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
                    fieldSort.missing("100");
        SortedNumericSortField expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE, false);
        QueryShardContext shardContextMock = createMockShardContext();
    }
        fieldSortBuilder = new FieldSortBuilder("value").missing(randomDouble.toString());
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        }
    }
                                doc.add(new DoublePoint(fieldName, v3));
        return randomFieldSortBuilder();
                        )
        assertEquals(expectedSortField, sortField);
            builder.order(randomFrom(SortOrder.values()));
        assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName + "-ni")));
/*
import org.opensearch.index.query.QueryBuilder;
        sortBuilder.setNestedPath("path").setNestedFilter(rangeQuery);
        assertEquals(expectedError, e.getMessage());
        sortField = sortBuilder.build(shardContextMock).field;
    public void testNestedRewrites() throws IOException {
                        )
 *
                        mutated.setNestedPath(randomValueOtherThan(original.getNestedPath(), () -> randomAlphaOfLengthBetween(1, 10)));
import org.apache.lucene.document.DoublePoint;
/*
        String nestedFilterDeprecationWarning = "[nested_filter] has been deprecated in favour for the [nested] parameter";
            int numDocs = randomIntBetween(5, 10);
                        mutated.setNestedFilter(randomValueOtherThan(original.getNestedFilter(), () -> randomNestedFilter()));
    public FieldSortBuilder randomFieldSortBuilder() {
    }
    protected MappedFieldType provideMappedFieldType(String name) {
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
        }
import org.apache.lucene.search.SortedSetSelector;
    protected FieldSortBuilder mutate(FieldSortBuilder original) throws IOException {
            assertEquals(builder.getFieldName(), sortField.getField());
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term(MAPPED_STRING_FIELDNAME, "value"))), nested.getInnerQuery());
    }
                        switch (numberType) {
                }
    protected void assertWarnings(FieldSortBuilder testItem) {
        assertEquals(expectedError, e.getMessage());
     */
                try (DirectoryReader reader = writer.getReader()) {
                            || numberType == NumberFieldMapper.NumberType.UNSIGNED_LONG) {
                                values[i] = (double) v5;
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir, new KeywordAnalyzer())) {
                    }
        expectedSortField.setMissingValue(randomDouble);
        sortField = sortBuilder.build(shardContextMock).field;
            builder.setNumericType(randomFrom(random(), "long", "double"));
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
     * Test that missing values get transferred correctly to the SortField
        SortField sortField = sortBuilder.build(shardContextMock).field;
            expectedType = SortField.Type.CUSTOM;
    @Override
 * this work for additional information regarding copyright
     */
                            new SearchSortValuesAndFormats(new Object[] { maxValue + 1 }, new DocValueFormat[] { DocValueFormat.RAW })
        }
            QueryShardException.class,
import org.opensearch.index.query.QueryShardException;
        sortField = sortBuilder.build(shardContextMock).field;
        if (testItem.getNestedFilter() != null && !assertedWarnings.contains(nestedFilterDeprecationWarning)) {
import org.opensearch.index.query.RangeQueryBuilder;
                mutated.sortMode(randomValueOtherThan(original.sortMode(), () -> randomFrom(SortMode.values())));
                }
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedPath("nestedPath")
import org.apache.lucene.search.SortedNumericSelector;
        SortField sortField = sortBuilder.build(shardContextMock).field;
            builder.unmappedType(randomAlphaOfLengthBetween(1, 10));
            assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName)));
    protected FieldSortBuilder fromXContent(XContentParser parser, String fieldName) throws IOException {
                                double v3 = randomDouble();
    /**
 * compatible open source license.
     * Test that the sort builder nested object gets created in the SortField
            long maxValue = -1;
                                break;
        sortField = sortBuilder.build(shardContextMock).field;
        QueryShardException e = expectThrows(
                    doc.add(new LongPoint(fieldName, values[i]));
        expectedSortField.setMissingValue(randomDouble);
                                doc.add(new HalfFloatPoint(fieldName, v5));
                fieldType = new DateFieldMapper.DateFieldType(name);
        String nestedPathDeprecationWarning = "[nested_path] has been deprecated in favor of the [nested] parameter";
                final Comparable[] values = new Comparable[numDocs];
            getPrimaryFieldSortOrNull(new SearchSourceBuilder().sort(SortBuilders.geoDistanceSort("field", 0d, 0d)).sort(sortBuilder))
import java.util.HashSet;
    }
        QueryShardContext shardContextMock = createMockShardContext();
    @Override
                            case DOUBLE:
                try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
        assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName + "-ni")));
    private static final String MAPPED_STRING_FIELDNAME = "_stringField";
                mutated.missing(randomValueOtherThan(original.missing(), () -> randomFrom(missingContent)));
        FieldSortBuilder sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME);
        fieldSortBuilder = new FieldSortBuilder("value").missing(randomDouble);
    public void testBuildNested() throws IOException {
    @Override
        SortField sortField = sortBuilder.build(shardContextMock).field;
            }
                        }
        }
                                long v1 = randomLong();
        String fieldName = "custom-date";
                    );
                        if (numberType == NumberFieldMapper.NumberType.HALF_FLOAT
    }
        iae = expectThrows(
        assertThat(sortField, instanceOf(SortedNumericSortField.class));
        QueryShardContext shardContextMock = createMockShardContext();
    public void testUnknownOptionFails() throws IOException {
            default:
        assertEquals(new TermQuery(new Term(NestedPathFieldMapper.NAME, "path")), nested.getInnerQuery());
            expectedWarnings.add(nestedPathDeprecationWarning);
                    doc.add(new LongPoint("custom-date", value));
                    type = "integer";
        assertEquals(SortedNumericSelector.Type.MIN, numericSortField.getSelector());
                        writer.addDocument(doc);
        try (Directory dir = newDirectory()) {
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
                                doc.add(new IntPoint(fieldName, v2));
                            context,
x * Licensed to Elasticsearch under one or more contributor
        int parameter = randomIntBetween(0, 5);
     * {@link #provideMappedFieldType(String)} will return a
        QueryShardContext context = createMockShardContext();
        );
        assertEquals(DocValueFormat.RAW, format);
                            context,
                builder.setNestedSort(createRandomNestedSort(3));
            XContentParseException e = expectThrows(XContentParseException.class, () -> FieldSortBuilder.fromXContent(parser, ""));
            case 3:
            int numDocs = randomIntBetween(10, 30);
        sortField = fieldSortBuilder.build(shardContextMock).field;
        assertEquals(expectedSortField, sortField);
            assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName + "-ni")));
    /**
                    assertFalse(
                    fieldSort.setNestedSort(null);
                for (int i = 0; i < numDocs; i++) {
                            new SearchSortValuesAndFormats(new Object[] { 0L }, new DocValueFormat[] { DocValueFormat.RAW })
        assertNotSame(rangeQuery, rewritten.getNestedFilter());
                fieldType = new KeywordFieldMapper.KeywordFieldType(name);
                if (randomBoolean()) {
import org.opensearch.index.query.QueryRewriteContext;
import org.apache.lucene.document.LongPoint;
                            case BYTE:
        }
        sortBuilder = new FieldSortBuilder("fieldName").setNestedFilter(QueryBuilders.termQuery(MAPPED_STRING_FIELDNAME, "value"));
 * You may obtain a copy of the License at
                                break;
            } else {
        String expectedError = "we only support AVG, MEDIAN and SUM on number based fields";
                    } else {
                    );
    }
        }
                }
        expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE);
                    assertEquals(values[numDocs - 1], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMax());
                            context,
    }
            () -> sortBuilder.setNestedPath("nestedPath").setNestedSort(new NestedSortBuilder("otherPath"))
public class FieldSortBuilderTests extends AbstractSortTestCase<FieldSortBuilder> {
        nested = comparatorSource.nested();
        );
        sortField = sortBuilder.build(shardContextMock).field;
                    values[i] = new BytesRef(randomAlphaOfLengthBetween(5, 10));
                mutated.order(randomValueOtherThan(original.order(), () -> randomFrom(SortOrder.values())));
                return new MatchNoneQueryBuilder();
                    );
     * Test we can either set nested sort via path/filter or via nested sort builder, not both
                                values[i] = v1;
                                values[i] = (int) v6;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        } else {
 * this file be licensed under the Apache-2.0 license or a
                        fieldSort.isBottomSortShardDisjoint(
                    writer.addDocument(doc);
        }
                }
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        e = expectThrows(
        assertEquals(expectedType, sortField.getType());
            case 5:
                    builder.setNestedFilter(randomNestedFilter());
                    values[i] = randomNonNegativeLong();
                        fieldSort.isBottomSortShardDisjoint(
import org.opensearch.search.MultiValueMode;
                        fieldSort.isBottomSortShardDisjoint(
     * Test the nested sort gets rewritten
                                break;
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
        IllegalArgumentException iae = expectThrows(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
            .setNestedFilter(QueryBuilders.termQuery(MAPPED_STRING_FIELDNAME, "value"));
    }
import static org.opensearch.search.sort.NestedSortBuilderTests.createRandomNestedSort;
     */
        FieldSortBuilder sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME).sortMode(SortMode.MIN);
                for (int i = 0; i < numDocs; i++) {
        sortBuilder = new FieldSortBuilder("value");
            () -> new FieldSortBuilder(MAPPED_STRING_FIELDNAME).sortMode(SortMode.MEDIAN).build(shardContextMock)
                }
            if (randomBoolean()) {
                    assertTrue(
                    builder.setNestedPath(randomAlphaOfLengthBetween(1, 10));
import java.util.List;
                throw new IllegalStateException("Unsupported mutation.");
import org.apache.lucene.document.Document;
    public void testMultiValueMode() throws IOException {
                                BigInteger v8 = randomUnsignedLong();
                                break;
        assertThat(sortField, instanceOf(SortedSetSortField.class));
    private Set<String> assertedWarnings = new HashSet<>();
                            case LONG:
                    assertEquals(values[0], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMin());
            assertWarnings(expectedWarnings.toArray(new String[0]));
        );
                                doc.add(new BigIntegerPoint(fieldName, v8));
import org.opensearch.core.xcontent.XContentParseException;
                            new SearchSortValuesAndFormats(new Object[] { minValue - 1 }, new DocValueFormat[] { DocValueFormat.RAW })
import org.apache.lucene.document.FloatPoint;
        numericSortField = (SortedNumericSortField) sortField;
                                values[i] = v3;
     */
 */
        QueryShardContext shardContextMock = createMockShardContext();
        SortedNumericSortField expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE);
                                doc.add(new IntPoint(fieldName, v6));
        );
        // if nested path is missing, we omit any filter and return a SortedNumericSortField
                            context,
    /**
                                values[i] = (int) v2;
import static org.opensearch.search.sort.FieldSortBuilder.getPrimaryFieldSortOrNull;
                    );
                break;
                        )
        nested = comparatorSource.nested();
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.mapper.NumberFieldMapper;
        FieldSortBuilder sortBuilder = new FieldSortBuilder("value").sortMode(SortMode.MIN);
                String type = name.split("-")[1];
                    Document doc = new Document();
        sortField = fieldSortBuilder.build(shardContextMock).field;
import org.apache.lucene.tests.search.AssertingIndexSearcher;
        QueryShardContext context = createMockShardContext();
        assertNull(getPrimaryFieldSortOrNull(new SearchSourceBuilder().sort(SortBuilders.scoreSort())));
            builder.sortMode(randomFrom(SortMode.values()));
                    );
        return mutated;
                    QueryShardContext newContext = createMockShardContext(new AssertingIndexSearcher(random(), reader));
        expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE);
        sortBuilder = new FieldSortBuilder("value").sortMode(SortMode.SUM);
            } else if (name.startsWith("custom-date")) {
        sortBuilder = new FieldSortBuilder("fieldName").setNestedPath("path")
     */
                            new SearchSortValuesAndFormats(new Object[] { minValue - 1 }, new DocValueFormat[] { DocValueFormat.RAW })
import org.opensearch.index.query.QueryBuilders;
                    assertFalse(fieldSort.isBottomSortShardDisjoint(context, null));
 * the Apache License, Version 2.0 (the "License"); you may
                            assertEquals(values[0], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMin());
        };
            @Override
     */
import org.apache.lucene.document.SortedNumericDocValuesField;
 * under the License.
        Double randomDouble = randomDouble();
    @Override
        FieldSortBuilder rewritten = sortBuilder.rewrite(createMockShardContext());
import org.opensearch.index.query.QueryShardContext;
                            default:
                        randomValueOtherThan(original.getNestedSort(), () -> NestedSortBuilderTests.createRandomNestedSort(3))
                    Arrays.sort(values);
            expectedType = SortField.Type.DOC;
                try (DirectoryReader reader = writer.getReader()) {
                                values[i] = (int) v7;
                            new SearchSortValuesAndFormats(new Object[] { maxValue + 1 }, new DocValueFormat[] { DocValueFormat.RAW })
    }
        return FieldSortBuilder.fromXContent(parser, fieldName);
        expectedSortField.setMissingValue(Double.NEGATIVE_INFINITY);
        );
            return super.provideMappedFieldType(name);
                                break;
import org.opensearch.search.DocValueFormat;
import java.util.Arrays;
                    assertTrue(
                        Document doc = new Document();
            parser.nextToken();
                            case HALF_FLOAT:
                break;
        assertThat(sortField, instanceOf(SortedNumericSortField.class));
        );
                    );
        assertEquals(expectedError, e.getMessage());
                Arrays.sort(values);
        if (randomBoolean()) {
    public void testBuildSortFieldMissingValue() throws IOException {
}
                break;
                NumberFieldMapper.NumberType numberType = NumberFieldMapper.NumberType.valueOf(type.toUpperCase(Locale.ENGLISH));
                        )
        assertNull(
        try (Directory dir = newDirectory()) {
                        } else {
    public void testGetMaxNumericDateValue() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
            QueryShardException.class,
                    doc.add(new SortedNumericDocValuesField("custom-date", value));
                            assertNull(getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)));
            IllegalArgumentException.class,
        fieldSortBuilder = new FieldSortBuilder("value").missing("_last");
            long minValue = Integer.MAX_VALUE;
 * software distributed under the License is distributed on an
        sortBuilder = new FieldSortBuilder("value").sortMode(SortMode.AVG);
            }
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {
            IllegalArgumentException.class,
        assertThat(sortField, instanceOf(SortedSetSortField.class));
        // sort mode should also be set by build() implicitly to MIN or MAX if not set explicitly on builder
                            new SearchSortValuesAndFormats(new Object[] { minValue }, new DocValueFormat[] { DocValueFormat.RAW })
                            case SHORT:
 * specific language governing permissions and limitations
import org.apache.lucene.store.Directory;
        sortField = sortBuilder.build(shardContextMock).field;
                    mutated.setNestedSort(
import org.apache.lucene.search.IndexSearcher;
        assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName)));
                            case FLOAT:
            // need to skip until parser is located on second START_OBJECT
        sortField = sortBuilder.build(shardContextMock).field;
        numericSortField = (SortedNumericSortField) sortField;
import org.opensearch.index.mapper.MappedFieldType;
        assertEquals(SortedSetSelector.Type.MAX, ((SortedSetSortField) sortField).getSelector());
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir, new KeywordAnalyzer())) {
    public void testGetPrimaryFieldSort() {
                        fieldSort.isBottomSortShardDisjoint(
        expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE, false);
                }
                }
                        )
import static org.opensearch.search.sort.FieldSortBuilder.getMinMaxOrNull;
            builder.missing(randomFrom(missingContent));
            }
    public void testNestedSortRewrites() throws IOException {
import org.apache.lucene.document.IntPoint;
        assertEquals(expectedSortField, sortField);
            return new KeywordFieldMapper.KeywordFieldType(name);
                                float v4 = randomFloat();
                        fieldSort.isBottomSortShardDisjoint(
        sortBuilder = new FieldSortBuilder("value").sortMode(SortMode.MAX);
        if (expectedWarnings.isEmpty() == false) {
    }
                FieldSortBuilder fieldSort = SortBuilders.fieldSort("custom-date");
import org.apache.lucene.search.SortedSetSortField;
     */
import org.opensearch.index.query.MatchNoneQueryBuilder;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, json)) {
        assertEquals(expectedSortField, sortField);
        FieldSortBuilder builder = new FieldSortBuilder(fieldName);
            }
        }
        assertEquals(SortedNumericSelector.Type.MAX, numericSortField.getSelector());
                                values[i] = v8;
        FieldSortBuilder fieldSortBuilder = new FieldSortBuilder("value").missing("_first");
        }
                    writer.addDocument(doc);
        if (name.equals(MAPPED_STRING_FIELDNAME)) {
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
     */
        );
                    assertFalse(
                break;
        } else if (name.startsWith("custom-")) {
            }
    public void testModeNonNumericField() throws IOException {
        FieldSortBuilder mutated = new FieldSortBuilder(original);
                        )
            parser.nextToken();
                // the following are alternative ways to setNestedSort for nested sorting
        return builder;
                try (DirectoryReader reader = writer.getReader()) {
                                doc.add(new LongPoint(fieldName, v1));
        FieldSortBuilder sortBuilder = new FieldSortBuilder("fieldName").setNestedSort(
import org.apache.lucene.document.TextField;
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
import org.apache.lucene.search.TermQuery;
            } else {
        assertNotSame(rangeQuery, rewritten.getNestedSort().getFilter());
        e = expectThrows(
                                values[i] = v4;
import org.apache.lucene.sandbox.document.BigIntegerPoint;
        assertEquals(MultiValueMode.AVG, comparatorSource.sortMode());
        fieldSortBuilder = new FieldSortBuilder("value").order(SortOrder.DESC);
                    );
                if (type.equals("INT")) {
        for (NumberFieldMapper.NumberType numberType : NumberFieldMapper.NumberType.values()) {
    /**
        sortField = sortBuilder.build(shardContextMock).field;
        SortedNumericSortField numericSortField = (SortedNumericSortField) sortField;
                    }
        }
                        fieldSort.isBottomSortShardDisjoint(
                                break;
                                break;
                        }
        assertNull(getPrimaryFieldSortOrNull(null));
    /**
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
    }
            new NestedSortBuilder("path").setFilter(QueryBuilders.termQuery(MAPPED_STRING_FIELDNAME, "value"))
                }
        assertNotNull(nested);
                            new SearchSortValuesAndFormats(new Object[] { minValue + 1 }, new DocValueFormat[] { DocValueFormat.RAW })
            }
                    assertFalse(
import org.opensearch.search.builder.SearchSourceBuilder;
                    assertEquals(values[numDocs - 1], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMax());
                    fieldSort.setNestedSort(new NestedSortBuilder("empty"));
 * not use this file except in compliance with the License.
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term(MAPPED_STRING_FIELDNAME, "value"))), nested.getInnerQuery());
                    );
            expectedWarnings.add(nestedFilterDeprecationWarning);
    }
    }
                    Document doc = new Document();
                    long value = randomLongBetween(1, Integer.MAX_VALUE);
                    QueryShardContext newContext = createMockShardContext(new AssertingIndexSearcher(random(), reader));
            }
        );
        assertNull(getPrimaryFieldSortOrNull(new SearchSourceBuilder().sort(SortBuilders.scoreSort()).sort(sortBuilder)));
                                doc.add(new FloatPoint(fieldName, v4));
        FieldSortBuilder sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME);
        assertThat(sortField, instanceOf(SortedNumericSortField.class));
import org.apache.lucene.util.BytesRef;
                    for (int i = 0; i < numDocs; i++) {
            assertEquals("[1:18] [field_sort] unknown field [reverse]", e.getMessage());
        try (Directory dir = newDirectory()) {
    public void testIsBottomSortShardDisjoint() throws Exception {
                                break;
        assertEquals(MultiValueMode.SUM, comparatorSource.sortMode());
        FieldSortBuilder rewritten = sortBuilder.rewrite(createMockShardContext());
                for (int i = 0; i < numDocs; i++) {
            String fieldName = "custom-" + numberType.numericType();
        if (randomBoolean()) {
    }
    }
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
    }
        QueryShardContext shardContextMock = createMockShardContext();
                    fieldSort.order(SortOrder.DESC);
        if (randomBoolean()) {
        String fieldName = "custom-keyword";
        expectedSortField.setMissingValue(Double.POSITIVE_INFINITY);
import org.opensearch.index.mapper.KeywordFieldMapper;
            final BytesRef[] values = new BytesRef[numDocs];
    /**
                }
            () -> new FieldSortBuilder(MAPPED_STRING_FIELDNAME).sortMode(SortMode.SUM).build(shardContextMock)
        }
    /**
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
 */
    /**
    protected void sortFieldAssertions(FieldSortBuilder builder, SortField sortField, DocValueFormat format) throws IOException {
        if (randomBoolean()) {
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
                                float v5 = randomFloat();
import org.opensearch.common.xcontent.json.JsonXContent;
        SortField sortField = fieldSortBuilder.build(shardContextMock).field;
import org.apache.lucene.search.SortField;
                    QueryShardContext context = createMockShardContext(new IndexSearcher(reader));
        assertThat(sortField, instanceOf(SortedNumericSortField.class));
                    maxValue = Math.max(maxValue, value);
                        fieldSort.isBottomSortShardDisjoint(
        FieldSortBuilder fieldSortBuilder = new FieldSortBuilder("value");
            parser.nextToken();
 *
                        )
        }
        String fieldName = rarely() ? FieldSortBuilder.DOC_FIELD_NAME : randomAlphaOfLengthBetween(1, 10);
        assertEquals(SortedNumericSelector.Type.MIN, numericSortField.getSelector());
     * Test the nested Filter gets rewritten
        }
        SortField.Type expectedType;
import org.opensearch.core.xcontent.XContentParser;
        assertNull(getPrimaryFieldSortOrNull(new SearchSourceBuilder()));
                            context,
                    assertFalse(
            case 4:
import java.io.IOException;
        }
                            case INTEGER:
                break;
                        fieldSort.isBottomSortShardDisjoint(
                fieldType = new NumberFieldMapper.NumberFieldType(name, numberType);
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
import org.apache.lucene.search.SortedNumericSortField;
        assertEquals(SortedSetSelector.Type.MIN, ((SortedSetSortField) sortField).getSelector());
     * Test that the sort builder mode gets transferred correctly to the SortField
        assertThat(sortField, instanceOf(SortedNumericSortField.class));
 * Unless required by applicable law or agreed to in writing,
                            context,
        }
    public void testBuildSortFieldOrder() throws IOException {
    protected FieldSortBuilder createTestItem() {
                return new MatchNoneQueryBuilder();
                mutated.setNumericType(randomValueOtherThan(original.getNumericType(), () -> randomFrom("long", "double")));
            assertEquals(builder.fieldName(), sortField.getField());
        switch (parameter) {
        assertEquals(expectedSortField, sortField);
import org.apache.lucene.search.ConstantScoreQuery;
                            case UNSIGNED_LONG:
                    QueryShardContext context = createMockShardContext(new IndexSearcher(reader));
        };
import java.math.BigInteger;
    /**
                                throw new AssertionError("unknown type " + numberType);
        numericSortField = (SortedNumericSortField) sortField;
        assertEquals(builder.order() == SortOrder.ASC ? false : true, sortField.getReverse());
    @Override
import org.opensearch.search.SearchSortValuesAndFormats;
    private List<Object> missingContent = Arrays.asList("_last", "_first", Integer.toString(randomInt()), randomInt());
        expectedSortField.setMissingValue(Double.NEGATIVE_INFINITY);
import org.apache.lucene.index.Term;
                if (original.getNestedPath() == null && original.getNestedFilter() == null) {
                                doc.add(new IntPoint(fieldName, v7));
    public void testGetMaxNumericSortValue() throws IOException {
        assertEquals(MultiValueMode.MEDIAN, comparatorSource.sortMode());
     * Test that MIN, MAX mode work on non-numeric fields, but other modes throw exception
                                short v7 = randomShort();
        assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName)));
        iae = expectThrows(
            assertedWarnings.addAll(expectedWarnings);
            case 2:
                            assertNull(getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName + "-ni")));
        }
        Nested nested = comparatorSource.nested();
            case 0:
import org.apache.lucene.tests.index.RandomIndexWriter;
        String json = "{ \"post_date\" : {\"reverse\" : true} },\n";
                        )
import java.util.Set;
import org.apache.lucene.sandbox.document.HalfFloatPoint;
                    assertEquals(values[0], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMin());
                int numDocs = randomIntBetween(10, 30);
import org.opensearch.index.mapper.DateFieldMapper;
                    writer.addDocument(doc);
                    );
        }
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedFilter(QueryBuilders.matchAllQuery())
        sortField = sortBuilder.build(shardContextMock).field;
                        )
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        sortField = fieldSortBuilder.build(shardContextMock).field;
                                int v2 = randomInt();
 */
            @Override
                    );
                    assertFalse(
                        QueryShardContext newContext = createMockShardContext(new AssertingIndexSearcher(random(), reader));
            int numDocs = randomIntBetween(10, 30);
 * KIND, either express or implied.  See the License for the
                    if (randomBoolean()) {
        assertNotNull(nested);
            }
     * Test that the sort builder order gets transferred correctly to the SortField
        sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME).sortMode(SortMode.MAX);
        assertNotNull(nested);
            IllegalArgumentException.class,
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
 * The OpenSearch Contributors require contributions made to
                    assertTrue(
                    try (DirectoryReader reader = writer.getReader()) {
        assertEquals(SortedNumericSelector.Type.MAX, numericSortField.getSelector());
 * GitHub history for details.
    public void testGetMaxKeywordValue() throws IOException {
        } else {
                            context,
                        fieldSort.isBottomSortShardDisjoint(
                            new SearchSortValuesAndFormats(new Object[] { minValue }, new DocValueFormat[] { DocValueFormat.RAW })
        expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE, true, SortedNumericSelector.Type.MAX);
        if (randomBoolean()) {
                    minValue = Math.min(minValue, value);
    }
import org.apache.lucene.analysis.core.KeywordAnalyzer;
            QueryShardException.class,
                try (DirectoryReader reader = writer.getReader()) {
    }
        List<String> expectedWarnings = new ArrayList<>();
            case 1:
import org.opensearch.index.mapper.NestedPathFieldMapper;
        if (builder.getFieldName().equals(FieldSortBuilder.DOC_FIELD_NAME)) {
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;
        sortBuilder.setNestedSort(new NestedSortBuilder("path").setFilter(rangeQuery));
                    Document doc = new Document();
                    assertFalse(
    }
        if (expectedType == SortField.Type.CUSTOM) {
        SortField sortField = fieldSortBuilder.build(shardContextMock).field;
import static org.hamcrest.Matchers.instanceOf;
        expectedSortField.setMissingValue(Double.POSITIVE_INFINITY);
        fieldSortBuilder = new FieldSortBuilder("value").order(SortOrder.ASC);
        expectedSortField.setMissingValue(Double.POSITIVE_INFINITY);
package org.opensearch.search.sort;
                }
        sortField = fieldSortBuilder.build(shardContextMock).field;
        assertEquals(sortBuilder, getPrimaryFieldSortOrNull(new SearchSourceBuilder().sort(sortBuilder)));
            () -> new FieldSortBuilder(MAPPED_STRING_FIELDNAME).sortMode(SortMode.AVG).build(shardContextMock)
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {
            return fieldType;
        if (testItem.getNestedPath() != null && !assertedWarnings.contains(nestedPathDeprecationWarning)) {
import org.apache.lucene.index.DirectoryReader;
        sortField = fieldSortBuilder.build(shardContextMock).field;
        FieldSortBuilder sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME);
            if (name.startsWith("custom-keyword")) {
            try (Directory dir = newDirectory()) {
                break;
