     */  
    public FieldSortBuilder randomFieldSortBuilder() {  
import org.apache.lucene.search.ConstantScoreQuery;
        String nestedPathDeprecationWarning = "[nested_path] has been deprecated in favor of the [nested] parameter";
                        fieldSort.isBottomSortShardDisjoint(  
                            assertNull(getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName + "-ni")));
        switch (parameter) {
            case 3:
                    assertFalse(
                try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {  
            @Override  
                    writer.addDocument(doc);
    public void testIsBottomSortShardDisjoint() throws Exception {
            () -> new FieldSortBuilder(MAPPED_STRING_FIELDNAME).sortMode(SortMode.AVG).build(shardContextMock)  
                Arrays.sort(values);  
        FieldSortBuilder sortBuilder = new FieldSortBuilder("value").sortMode(SortMode.MIN);
        }  
        FieldSortBuilder sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME).sortMode(SortMode.MIN);
            case 4:
        }
     * Test we can either set nested sort via path/filter or via nested sort builder, not both  
     */  
        assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName + "-ni")));
import org.opensearch.index.mapper.DateFieldMapper;
        sortField = sortBuilder.build(shardContextMock).field;
                Arrays.sort(values);
 *  
        sortField = sortBuilder.build(shardContextMock).field;
                }
                        )
 * under the License.  
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
 */  
        sortField = sortBuilder.build(shardContextMock).field;  
    protected MappedFieldType provideMappedFieldType(String name) {  
            long maxValue = -1;
    }
import org.apache.lucene.document.IntPoint;  
import org.apache.lucene.search.SortedNumericSortField;  
    }
 * Unless required by applicable law or agreed to in writing,
                    fieldSort.setNestedSort(new NestedSortBuilder("empty"));
        sortField = sortBuilder.build(shardContextMock).field;
 *
        sortField = fieldSortBuilder.build(shardContextMock).field;
        assertThat(sortField, instanceOf(SortedSetSortField.class));
        assertEquals(SortedNumericSelector.Type.MAX, numericSortField.getSelector());
        // if nested path is missing, we omit any filter and return a SortedNumericSortField  
        FieldSortBuilder sortBuilder = new FieldSortBuilder("fieldName").setNestedSort(  
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;
        assertEquals(SortedNumericSelector.Type.MAX, numericSortField.getSelector());  
            } else {  
        QueryShardContext context = createMockShardContext();
        FieldSortBuilder rewritten = sortBuilder.rewrite(createMockShardContext());
            new NestedSortBuilder("path").setFilter(QueryBuilders.termQuery(MAPPED_STRING_FIELDNAME, "value"))
                                break;
        assertNull(getPrimaryFieldSortOrNull(new SearchSourceBuilder().sort(SortBuilders.scoreSort()).sort(sortBuilder)));
    public void testNestedRewrites() throws IOException {  
                for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.sandbox.document.HalfFloatPoint;
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        assertEquals(new TermQuery(new Term(NestedPathFieldMapper.NAME, "path")), nested.getInnerQuery());
                    builder.setNestedPath(randomAlphaOfLengthBetween(1, 10));  
                                values[i] = v8;  
                    assertFalse(  
            default:
                mutated.unmappedType(randomValueOtherThan(original.unmappedType(), () -> randomAlphaOfLengthBetween(1, 10)));
                    fieldSort.missing("100");  
                try (DirectoryReader reader = writer.getReader()) {  
            return fieldType;
        FieldSortBuilder builder = new FieldSortBuilder(fieldName);
        assertEquals(expectedSortField, sortField);
            IllegalArgumentException.class,  
            int numDocs = randomIntBetween(10, 30);
            }
        );
                break;  
    private Set<String> assertedWarnings = new HashSet<>();
import org.opensearch.core.xcontent.XContentParser;
    protected FieldSortBuilder mutate(FieldSortBuilder original) throws IOException {
        if (randomBoolean()) {  
            int numDocs = randomIntBetween(5, 10);
        );
        assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName)));
        if (randomBoolean()) {
                    );  
        }
                break;  
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));  
    /**
                builder.setNestedSort(createRandomNestedSort(3));
                    );  
import org.apache.lucene.search.SortField;
    }
                            case DOUBLE:
            } else if (name.startsWith("custom-date")) {
                        Document doc = new Document();
     * Test the nested sort gets rewritten
                                doc.add(new IntPoint(fieldName, v2));
    /**  
            expectedWarnings.add(nestedFilterDeprecationWarning);  
            parser.nextToken();
                if (original.getNestedPath() == null && original.getNestedFilter() == null) {
import java.math.BigInteger;
                            context,  
        String expectedError = "we only support AVG, MEDIAN and SUM on number based fields";  
 * license agreements. See the NOTICE file distributed with
            assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName + "-ni")));
    /**
    @Override
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term(MAPPED_STRING_FIELDNAME, "value"))), nested.getInnerQuery());
import static org.opensearch.search.sort.FieldSortBuilder.getPrimaryFieldSortOrNull;
            assertWarnings(expectedWarnings.toArray(new String[0]));  
        FieldSortBuilder sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME);  
        return builder;
        sortField = fieldSortBuilder.build(shardContextMock).field;
        SortField sortField = fieldSortBuilder.build(shardContextMock).field;
    public void testNestedSortBothThrows() throws IOException {
    }
                                values[i] = (double) v5;  
            }
                        }
    /**  
        expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE, false);
                            || numberType == NumberFieldMapper.NumberType.UNSIGNED_LONG) {
import org.opensearch.index.query.MatchNoneQueryBuilder;  
                        } else {
                            new SearchSortValuesAndFormats(new Object[] { maxValue + 1 }, new DocValueFormat[] { DocValueFormat.RAW })
            @Override
            builder.order(randomFrom(SortOrder.values()));
                    doc.add(new LongPoint(fieldName, values[i]));  
    }  
        );
                mutated.setNumericType(randomValueOtherThan(original.getNumericType(), () -> randomFrom("long", "double")));
        String json = "{ \"post_date\" : {\"reverse\" : true} },\n";
        QueryShardContext shardContextMock = createMockShardContext();
        sortField = fieldSortBuilder.build(shardContextMock).field;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        try (Directory dir = newDirectory()) {
        Double randomDouble = randomDouble();
        FieldSortBuilder fieldSortBuilder = new FieldSortBuilder("value");  
                            assertNull(getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName + "-ni")));
        SortField sortField = sortBuilder.build(shardContextMock).field;  
        try (Directory dir = newDirectory()) {  
 * GitHub history for details.
import org.opensearch.search.builder.SearchSourceBuilder;
                                doc.add(new FloatPoint(fieldName, v4));
        assertNotSame(rangeQuery, rewritten.getNestedFilter());
                    assertTrue(
     */
        QueryShardContext shardContextMock = createMockShardContext();
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
import org.apache.lucene.document.FloatPoint;
    public void testNestedSortRewrites() throws IOException {
        return randomFieldSortBuilder();
    public void testBuildSortFieldMissingValue() throws IOException {  
import org.apache.lucene.sandbox.document.BigIntegerPoint;  
 * ownership. Elasticsearch licenses this file to you under  
                    for (int i = 0; i < numDocs; i++) {
                        )  
                            assertEquals(values[0], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMin());
                    assertTrue(  
            QueryShardException.class,
                    }
                    mutated.setNestedSort(
        assertNull(getPrimaryFieldSortOrNull(new SearchSourceBuilder()));
                            context,
                fieldType = new NumberFieldMapper.NumberFieldType(name, numberType);  
        assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName)));  
        );
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
                        )
                            case UNSIGNED_LONG:
        expectedSortField.setMissingValue(Double.POSITIVE_INFINITY);  
        assertThat(sortField, instanceOf(SortedSetSortField.class));  
     * Test that the sort builder mode gets transferred correctly to the SortField
                            new SearchSortValuesAndFormats(new Object[] { maxValue + 1 }, new DocValueFormat[] { DocValueFormat.RAW })
                            case LONG:
                    writer.addDocument(doc);
                        )
        sortField = sortBuilder.build(shardContextMock).field;
        if (randomBoolean()) {  
                    assertFalse(  
        String fieldName = "custom-date";
            assertedWarnings.addAll(expectedWarnings);
        sortBuilder.setNestedSort(new NestedSortBuilder("path").setFilter(rangeQuery));  
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));  
        try (Directory dir = newDirectory()) {  
        assertNotNull(nested);  
    public void testModeNonNumericField() throws IOException {
        assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName + "-ni")));
import java.util.HashSet;
        assertThat(sortField, instanceOf(SortedNumericSortField.class));  
        sortBuilder.setNestedPath("path").setNestedFilter(rangeQuery);
        if (testItem.getNestedFilter() != null && !assertedWarnings.contains(nestedFilterDeprecationWarning)) {
import org.opensearch.index.query.RangeQueryBuilder;  
                        fieldSort.isBottomSortShardDisjoint(
 * You may obtain a copy of the License at  
        sortBuilder = new FieldSortBuilder("value").order(SortOrder.DESC);
                if (randomBoolean()) {
        sortBuilder = new FieldSortBuilder("fieldName").setNestedFilter(QueryBuilders.termQuery(MAPPED_STRING_FIELDNAME, "value"));
                        randomValueOtherThan(original.getNestedSort(), () -> NestedSortBuilderTests.createRandomNestedSort(3))  
 *
        return mutated;
    }  
        nested = comparatorSource.nested();
import java.io.IOException;  
                    values[i] = randomNonNegativeLong();
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
                        )  
                    Document doc = new Document();
import org.apache.lucene.tests.index.RandomIndexWriter;
                    );
            }
        iae = expectThrows(
                            case BYTE:
            builder.sortMode(randomFrom(SortMode.values()));
     * Test that missing values get transferred correctly to the SortField
import org.apache.lucene.search.SortedSetSelector;
        expectedSortField.setMissingValue(Double.NEGATIVE_INFINITY);
        SortField sortField = sortBuilder.build(shardContextMock).field;  
            parser.nextToken();  
                return new MatchNoneQueryBuilder();  
     * Test that the sort builder order gets transferred correctly to the SortField
        sortBuilder = new FieldSortBuilder("value").sortMode(SortMode.AVG);
    }  
import org.opensearch.index.mapper.NumberFieldMapper;
                    doc.add(new SortedNumericDocValuesField("custom-date", value));
                        QueryShardContext newContext = createMockShardContext(new AssertingIndexSearcher(random(), reader));
                }  
import org.opensearch.index.query.QueryShardException;
        sortBuilder = new FieldSortBuilder("value").sortMode(SortMode.MEDIAN);
import org.apache.lucene.search.SortedNumericSelector;
 * specific language governing permissions and limitations
                    fieldSort.setNestedSort(null);
        fieldSortBuilder = new FieldSortBuilder("value").missing(randomDouble);  
import org.apache.lucene.document.DoublePoint;  
            // need to skip until parser is located on second START_OBJECT
        fieldSortBuilder = new FieldSortBuilder("value").order(SortOrder.ASC);  
        expectedSortField.setMissingValue(randomDouble);  
        Nested nested = comparatorSource.nested();  
import org.opensearch.index.mapper.MappedFieldType;  
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        if (randomBoolean()) {  
            }  
        expectedSortField.setMissingValue(Double.NEGATIVE_INFINITY);  
    @Override  
    public void testMultiValueMode() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        assertNull(  
        );  
                        fieldSort.isBottomSortShardDisjoint(
        String nestedFilterDeprecationWarning = "[nested_filter] has been deprecated in favour for the [nested] parameter";  
                            case SHORT:
 * the Apache License, Version 2.0 (the "License"); you may
                }
            case 5:
                } else {
        sortBuilder = new FieldSortBuilder("value");
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
        }
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
                            new SearchSortValuesAndFormats(new Object[] { 0L }, new DocValueFormat[] { DocValueFormat.RAW })
        assertEquals(DocValueFormat.RAW, format);  
                                float v5 = randomFloat();
        QueryShardContext shardContextMock = createMockShardContext();
        e = expectThrows(
                    assertFalse(
    @Override
        IllegalArgumentException iae = expectThrows(
import org.apache.lucene.util.BytesRef;
        assertThat(sortField, instanceOf(SortedNumericSortField.class));  
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedPath("nestedPath")
                            new SearchSortValuesAndFormats(new Object[] { minValue - 1 }, new DocValueFormat[] { DocValueFormat.RAW })  
        return FieldSortBuilder.fromXContent(parser, fieldName);
import org.apache.lucene.document.SortedNumericDocValuesField;
        }  
    public void testGetMaxNumericDateValue() throws IOException {  
import org.opensearch.search.DocValueFormat;
                fieldType = new DateFieldMapper.DateFieldType(name);
        assertEquals(MultiValueMode.MEDIAN, comparatorSource.sortMode());
                                doc.add(new DoublePoint(fieldName, v3));
        assertEquals(builder.order() == SortOrder.ASC ? false : true, sortField.getReverse());
            builder.setNumericType(randomFrom(random(), "long", "double"));
                        )
        QueryShardContext context = createMockShardContext();  
 * compatible open source license.
                    if (randomBoolean()) {  
                            new SearchSortValuesAndFormats(new Object[] { minValue }, new DocValueFormat[] { DocValueFormat.RAW })
/*
 * Modifications Copyright OpenSearch Contributors. See
                    );
        FieldSortBuilder sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME);
                    assertEquals(values[numDocs - 1], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMax());  
                        fieldSort.isBottomSortShardDisjoint(
        assertNotNull(nested);
        }
                                int v2 = randomInt();
        assertEquals(expectedSortField, sortField);
    protected void assertWarnings(FieldSortBuilder testItem) {
        expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE);
                    assertFalse(
            assertEquals("[1:18] [field_sort] unknown field [reverse]", e.getMessage());
                    Document doc = new Document();
            final long[] values = new long[numDocs];
 * software distributed under the License is distributed on an
        }
        expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE);
        sortBuilder = new FieldSortBuilder("fieldName").setNestedPath("path");
            .setNestedFilter(QueryBuilders.termQuery(MAPPED_STRING_FIELDNAME, "value"));
        SortedNumericSortField expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE);
     * Test that the sort builder nested object gets created in the SortField
            builder.unmappedType(randomAlphaOfLengthBetween(1, 10));  
        }
        sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME).sortMode(SortMode.MAX);
        }
                        fieldSort.isBottomSortShardDisjoint(
        if (randomBoolean()) {
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {
                        writer.addDocument(doc);
                                values[i] = (int) v6;  
    private List<Object> missingContent = Arrays.asList("_last", "_first", Integer.toString(randomInt()), randomInt());
                    assertFalse(
                return new MatchNoneQueryBuilder();
    /**
    /**  
            builder.missing(randomFrom(missingContent));
        String fieldName = "custom-keyword";  
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());  
            QueryShardException.class,
        assertNull(getPrimaryFieldSortOrNull(new SearchSourceBuilder().sort(SortBuilders.scoreSort())));
        if (expectedWarnings.isEmpty() == false) {
import org.apache.lucene.search.TermQuery;  
                                byte v6 = randomByte();
        QueryShardContext shardContextMock = createMockShardContext();
                                break;
            assertNull(getMinMaxOrNull(context, SortBuilders.fieldSort(fieldName)));  
     */  
        assertEquals(expectedError, e.getMessage());
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
import org.opensearch.index.query.QueryBuilders;
                    );
public class FieldSortBuilderTests extends AbstractSortTestCase<FieldSortBuilder> {
    public void testBuildSortFieldOrder() throws IOException {
                fieldType = new KeywordFieldMapper.KeywordFieldType(name);  
        expectedSortField.setMissingValue(Double.POSITIVE_INFINITY);  
        numericSortField = (SortedNumericSortField) sortField;
}  
                if (type.equals("INT")) {
import org.apache.lucene.analysis.core.KeywordAnalyzer;
                        mutated.setNestedPath(randomValueOtherThan(original.getNestedPath(), () -> randomAlphaOfLengthBetween(1, 10)));
        assertEquals(expectedSortField, sortField);  
        SortField sortField = fieldSortBuilder.build(shardContextMock).field;  
        assertEquals(new ConstantScoreQuery(new TermQuery(new Term(MAPPED_STRING_FIELDNAME, "value"))), nested.getInnerQuery());
import org.apache.lucene.tests.search.AssertingIndexSearcher;  
                    builder.setNestedFilter(randomNestedFilter());  
import java.util.Locale;  
        sortField = sortBuilder.build(shardContextMock).field;
 * KIND, either express or implied.  See the License for the
            () -> new FieldSortBuilder(MAPPED_STRING_FIELDNAME).sortMode(SortMode.SUM).build(shardContextMock)  
                                doc.add(new IntPoint(fieldName, v6));
        expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE);
                // the following are alternative ways to setNestedSort for nested sorting
import org.opensearch.index.mapper.KeywordFieldMapper;
     * {@link #provideMappedFieldType(String)} will return a
        }  
        );
                    );
                try (DirectoryReader reader = writer.getReader()) {
     * Test that MIN, MAX mode work on non-numeric fields, but other modes throw exception  
        );
        FieldSortBuilder rewritten = sortBuilder.rewrite(createMockShardContext());  
                            new SearchSortValuesAndFormats(new Object[] { minValue - 1 }, new DocValueFormat[] { DocValueFormat.RAW })
    }
                                BigInteger v8 = randomUnsignedLong();
                                values[i] = (int) v2;  
        assertEquals(expectedSortField, sortField);
                    );
        }
            }
            if (randomBoolean()) {
import org.opensearch.search.MultiValueMode;
        sortField = sortBuilder.build(shardContextMock).field;
                    } else {
                for (int i = 0; i < numDocs; i++) {  
        assertEquals(expectedError, e.getMessage());
                }
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
                    writer.addDocument(doc);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(SortedNumericSelector.Type.MIN, numericSortField.getSelector());
            return new KeywordFieldMapper.KeywordFieldType(name);
                    QueryShardContext newContext = createMockShardContext(new AssertingIndexSearcher(random(), reader));
    }
    protected void sortFieldAssertions(FieldSortBuilder builder, SortField sortField, DocValueFormat format) throws IOException {
            IllegalArgumentException.class,
                    );
                                doc.add(new BigIntegerPoint(fieldName, v8));
        assertEquals(expectedSortField, sortField);  
        iae = expectThrows(  
                                double v3 = randomDouble();
        SortedNumericSortField expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE, false);
        } else {  
import java.util.ArrayList;
        SortField sortField = sortBuilder.build(shardContextMock).field;
                                break;
                    long value = randomLongBetween(1, Integer.MAX_VALUE);
    }
                        if (numberType == NumberFieldMapper.NumberType.HALF_FLOAT  
                            context,
    @Override
        for (NumberFieldMapper.NumberType numberType : NumberFieldMapper.NumberType.values()) {
                            assertNull(getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)));  
        sortField = fieldSortBuilder.build(shardContextMock).field;
    }
        String fieldName = rarely() ? FieldSortBuilder.DOC_FIELD_NAME : randomAlphaOfLengthBetween(1, 10);
        assertEquals(SortedSetSelector.Type.MAX, ((SortedSetSortField) sortField).getSelector());
        QueryShardContext context = createMockShardContext();
        if (expectedType == SortField.Type.CUSTOM) {
        sortBuilder = new FieldSortBuilder("value").sortMode(SortMode.SUM);
/*  
            long minValue = Integer.MAX_VALUE;  
        assertEquals(MultiValueMode.SUM, comparatorSource.sortMode());
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
                            new SearchSortValuesAndFormats(new Object[] { minValue + 1 }, new DocValueFormat[] { DocValueFormat.RAW })  
import java.util.List;
                    Arrays.sort(values);  
                        }  
                    );  
            try (Directory dir = newDirectory()) {  
                                doc.add(new HalfFloatPoint(fieldName, v5));
 * not use this file except in compliance with the License.
    }
                }
            return super.provideMappedFieldType(name);
            IllegalArgumentException.class,
            case 1:
                                values[i] = v4;  
        expectedSortField.setMissingValue(randomDouble);  
import static org.opensearch.search.sort.NestedSortBuilderTests.createRandomNestedSort;
     */
                                values[i] = v1;  
import org.apache.lucene.document.TextField;  
import org.opensearch.index.query.QueryBuilder;
                    QueryShardContext context = createMockShardContext(new IndexSearcher(reader));
                    minValue = Math.min(minValue, value);
            final BytesRef[] values = new BytesRef[numDocs];
                break;  
                NumberFieldMapper.NumberType numberType = NumberFieldMapper.NumberType.valueOf(type.toUpperCase(Locale.ENGLISH));
        sortField = sortBuilder.build(shardContextMock).field;
        sortField = fieldSortBuilder.build(shardContextMock).field;
                }
                                doc.add(new LongPoint(fieldName, v1));
                try (DirectoryReader reader = writer.getReader()) {  
        QueryShardContext shardContextMock = createMockShardContext();  
                    assertEquals(values[0], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMin());
            int numDocs = randomIntBetween(10, 30);  
                            case FLOAT:
    }  
            }
     */
        QueryShardException e = expectThrows(
                    assertFalse(fieldSort.isBottomSortShardDisjoint(context, null));
        }  
                        fieldSort.isBottomSortShardDisjoint(
    public void testGetPrimaryFieldSort() {
        FieldSortBuilder sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME);
    @Override
                            case HALF_FLOAT:
                    QueryShardContext newContext = createMockShardContext(new AssertingIndexSearcher(random(), reader));  
        fieldSortBuilder = new FieldSortBuilder("value").missing("_last");
                                throw new AssertionError("unknown type " + numberType);
                        )
        SortedNumericSortField numericSortField = (SortedNumericSortField) sortField;
import org.apache.lucene.store.Directory;
        FieldSortBuilder mutated = new FieldSortBuilder(original);  
            getPrimaryFieldSortOrNull(new SearchSourceBuilder().sort(SortBuilders.geoDistanceSort("field", 0d, 0d)).sort(sortBuilder))
                        )
 * The OpenSearch Contributors require contributions made to  
        }  
        };
        assertEquals(expectedSortField, sortField);
        sortBuilder = new FieldSortBuilder("value").sortMode(SortMode.MAX);
 */  
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.common.xcontent.json.JsonXContent;
                }
    /**
            QueryShardException.class,
                                break;
            assertEquals(builder.fieldName(), sortField.getField());
                    doc.add(new LongPoint("custom-date", value));  
                                float v4 = randomFloat();
     */
import org.apache.lucene.document.Document;
    protected FieldSortBuilder createTestItem() {  
        }  
        assertThat(sortField, instanceOf(SortedNumericSortField.class));
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
                            case INTEGER:
        expectedSortField = new SortedNumericSortField("value", SortField.Type.DOUBLE, true, SortedNumericSelector.Type.MAX);
    }
            }  
    /**
     */
import static org.hamcrest.Matchers.instanceOf;  
        SortField.Type expectedType;  
                    assertEquals(values[0], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMin());
import org.opensearch.core.xcontent.XContentParseException;  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, json)) {  
            }
                    );  
                mutated.sortMode(randomValueOtherThan(original.sortMode(), () -> randomFrom(SortMode.values())));
                            context,  
        assertNotSame(rangeQuery, rewritten.getNestedSort().getFilter());
    public void testGetMaxKeywordValue() throws IOException {
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedFilter(QueryBuilders.matchAllQuery())
        } else {  
/*  
import org.opensearch.index.query.QueryRewriteContext;  
        fieldSortBuilder = new FieldSortBuilder("value").order(SortOrder.DESC);  
                                break;
        }
                }
            String fieldName = "custom-" + numberType.numericType();
        fieldSortBuilder = new FieldSortBuilder("value").missing(randomDouble.toString());  
                }  
                    type = "integer";  
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir, new KeywordAnalyzer())) {
            XContentParseException e = expectThrows(XContentParseException.class, () -> FieldSortBuilder.fromXContent(parser, ""));  
        assertThat(sortField, instanceOf(SortedNumericSortField.class));
    public void testUnknownOptionFails() throws IOException {  
        }
import org.apache.lucene.search.IndexSearcher;  
                            new SearchSortValuesAndFormats(new Object[] { minValue }, new DocValueFormat[] { DocValueFormat.RAW })  
        sortField = sortBuilder.build(shardContextMock).field;
    }
        if (builder.getFieldName().equals(FieldSortBuilder.DOC_FIELD_NAME)) {
                    try (DirectoryReader reader = writer.getReader()) {
                            context,
                        mutated.setNestedFilter(randomValueOtherThan(original.getNestedFilter(), () -> randomNestedFilter()));  
                                break;
        assertNotNull(nested);  
        };
        List<String> expectedWarnings = new ArrayList<>();
                        fieldSort.isBottomSortShardDisjoint(  
                    }  
                                break;
        assertThat(sortField, instanceOf(SortedNumericSortField.class));  
                    }
                                values[i] = (int) v7;  
    @Override
        assertEquals(expectedError, e.getMessage());
        numericSortField = (SortedNumericSortField) sortField;
                    maxValue = Math.max(maxValue, value);  
            } else {  
            () -> new FieldSortBuilder(MAPPED_STRING_FIELDNAME).sortMode(SortMode.MEDIAN).build(shardContextMock)  
package org.opensearch.search.sort;
                            context,  
            assertEquals(builder.getFieldName(), sortField.getField());  
                                values[i] = v3;  
            expectedType = SortField.Type.CUSTOM;
                }
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));  
import java.util.Arrays;  
        assertEquals(expectedSortField, sortField);
        FieldSortBuilder sortBuilder = new FieldSortBuilder(MAPPED_STRING_FIELDNAME);  
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));  
                }
                mutated.order(randomValueOtherThan(original.order(), () -> randomFrom(SortOrder.values())));
                FieldSortBuilder fieldSort = SortBuilders.fieldSort("custom-date");
    }  
                                short v7 = randomShort();
import org.apache.lucene.search.SortedSetSortField;
            () -> sortBuilder.setNestedPath("nestedPath").setNestedSort(new NestedSortBuilder("otherPath"))  
x * Licensed to Elasticsearch under one or more contributor  
                String type = name.split("-")[1];
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));  
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir, new KeywordAnalyzer())) {  
            case 2:
                break;  
            expectedType = SortField.Type.DOC;
        } else if (name.startsWith("custom-")) {  
    protected FieldSortBuilder fromXContent(XContentParser parser, String fieldName) throws IOException {  
                }
import org.opensearch.search.SearchSortValuesAndFormats;  
                        fieldSort.isBottomSortShardDisjoint(
            if (name.startsWith("custom-keyword")) {
            case 0:  
    public void testGetMaxNumericSortValue() throws IOException {
import org.apache.lucene.index.Term;
                            context,  
            parser.nextToken();
                    values[i] = new BytesRef(randomAlphaOfLengthBetween(5, 10));  
        assertEquals(SortedNumericSelector.Type.MIN, numericSortField.getSelector());  
    /**  
    }
        assertEquals(MultiValueMode.AVG, comparatorSource.sortMode());
import org.apache.lucene.document.LongPoint;
import java.util.Set;
                            assertEquals(values[numDocs - 1], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMax());  
                        )
        );
                    doc.add(new TextField(fieldName, values[i].utf8ToString(), Field.Store.NO));
        if (randomBoolean()) {
                                break;
        if (testItem.getNestedPath() != null && !assertedWarnings.contains(nestedPathDeprecationWarning)) {
        e = expectThrows(
                            context,
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
                                doc.add(new IntPoint(fieldName, v7));
import org.apache.lucene.document.Field;
        }
                            context,
        FieldSortBuilder fieldSortBuilder = new FieldSortBuilder("value").missing("_first");
    }
            final MappedFieldType fieldType;
 * this work for additional information regarding copyright
        sortBuilder = new FieldSortBuilder("fieldName").setNestedPath("path")  
     * Test the nested Filter gets rewritten
                try (DirectoryReader reader = writer.getReader()) {
                            new SearchSortValuesAndFormats(new Object[] { maxValue }, new DocValueFormat[] { DocValueFormat.RAW })
        expectedSortField.setMissingValue(Double.POSITIVE_INFINITY);
                        fieldSort.isBottomSortShardDisjoint(
        if (name.equals(MAPPED_STRING_FIELDNAME)) {
        assertEquals(sortBuilder, getPrimaryFieldSortOrNull(new SearchSourceBuilder().sort(sortBuilder)));
    }
                    assertEquals(values[numDocs - 1], getMinMaxOrNull(newContext, SortBuilders.fieldSort(fieldName)).getMax());
                final Comparable[] values = new Comparable[numDocs];
    private static final String MAPPED_STRING_FIELDNAME = "_stringField";  
import org.opensearch.index.mapper.NestedPathFieldMapper;
    public void testBuildNested() throws IOException {  
 */
                    Document doc = new Document();
        sortField = sortBuilder.build(shardContextMock).field;  
                        switch (numberType) {  
        // sort mode should also be set by build() implicitly to MIN or MAX if not set explicitly on builder
        assertEquals(expectedType, sortField.getType());  
        }
                    fieldSort.order(SortOrder.DESC);  
        numericSortField = (SortedNumericSortField) sortField;
                for (int i = 0; i < numDocs; i++) {  
                break;  
                break;  
import org.opensearch.index.query.QueryShardContext;
                if (randomBoolean()) {
    }  
                                long v1 = randomLong();
    }  
        assertNull(getPrimaryFieldSortOrNull(null));  
                            default:
                    assertTrue(
                    QueryShardContext context = createMockShardContext(new IndexSearcher(reader));
                int numDocs = randomIntBetween(10, 30);
            expectedWarnings.add(nestedPathDeprecationWarning);  
import static org.opensearch.search.sort.FieldSortBuilder.getMinMaxOrNull;  
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
        int parameter = randomIntBetween(0, 5);
        assertEquals(SortedSetSelector.Type.MIN, ((SortedSetSortField) sortField).getSelector());
                mutated.missing(randomValueOtherThan(original.missing(), () -> randomFrom(missingContent)));
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {  
                throw new IllegalStateException("Unsupported mutation.");
        nested = comparatorSource.nested();
