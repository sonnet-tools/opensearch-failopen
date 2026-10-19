            }
        // Test multiple values  
 * ownership. Elasticsearch licenses this file to you under  
            + "      \"id\": \"3\",\n"
            // expected returned terms depending on whether we have a terms query or a terms lookup query
            assertEquals(Arrays.asList(1f, 3f, 4f), values);  
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
        assertThat(rewritten, instanceOf(MatchNoneQueryBuilder.class));
 * GitHub history for details.
        }  
        TermsQueryBuilder query = new TermsQueryBuilder(GEO_POINT_FIELD_NAME, "2,3");  
        list = Arrays.asList(5, 42L);
        QueryShardContext context = createShardContext();
import java.util.HashMap;  
                    .or(instanceOf(FieldExistsQuery.class))
        List<Object> randomTerms = new ArrayList<>();
            // We don't expect a RangeQuery for 500 < value < 501, since nothing could match it on an int field  
import org.junit.Before;
        }
        String query = XContentFactory.jsonBuilder()
 * You may obtain a copy of the License at  
        assertEquals("query must be rewritten first", e.getMessage());
        checkGeneratedJson(json, parsed);
            assertEquals(Arrays.asList(1L, 3L, 4L), values);  
            .array("foo", 123)
                );
    @Override
            new RangeQueryBuilder(INT_FIELD_NAME).from(200).to(304).includeLower(false).includeUpper(false),
            TermsQueryBuilder builder = new TermsQueryBuilder("foo", new double[] { 1, 3, 4 });  
 * under the License.  
            new RangeQueryBuilder(INT_FIELD_NAME).from(3).includeLower(false).includeUpper(true)
        List<Object> list = Arrays.asList();
            throw new OpenSearchException("boom", ex);
        Query luceneQuery = rewritten.toQuery(context);
            new RangeQueryBuilder(INT_FIELD_NAME).from(501).includeLower(false).includeUpper(true)
        RoaringBitmap bitmap = new RoaringBitmap();
 * specific language governing permissions and limitations
        QueryShardContext context = createShardContext();
                    || choice.equals(INT_RANGE_FIELD_NAME)  
    }
    @Override  
    protected void doAssertLuceneQuery(TermsQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            assertThat(
        QueryShardContext context = createShardContext();  
            + "        \"boost\" : 1.0,\n"
            if (context.fieldMapper(fieldName) != null) {  
    }  
        DirectoryReader reader = DirectoryReader.open(w);
    @Override  
    }  
    }
    }
                || queryBuilder.fieldName().equals(DATE_FIELD_NAME)) {
    }  
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (float[]) null));  
            return query;  
        Directory dir = newDirectory();
            List<Object> values = copy.values();
    @Before  
            .endObject()
        assertEquals(list, TermsQueryBuilder.convertBack(TermsQueryBuilder.convert(list)));
            + "      \"blue\",\n"
            XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
            + "    \"user\" : [ \"foobar\", \"opensearch\" ],\n"
        bitmap.add(333);  
import org.opensearch.indices.TermsLookup;
        assertEquals(ise.getMessage(), "supplier must be null, can't serialize suppliers, missing a rewriteAndFetch?");
            + "        \"boost\" : 1.0,\n"  
    }
            + "}";  
import static org.hamcrest.Matchers.either;  
        String json = "{\n"  
 *
        TermsQueryBuilder query = new TermsQueryBuilder("_index", "does_not_exist", getIndex().getName());
        assertEquals(complement, expectedComplement);  
        );  
        assertEquals(Arrays.asList(new BytesRef("abc"), new BytesRef("def")), TermsQueryBuilder.convert(list));
 * compatible open source license.
            }
            + "  \"terms\" : {\n"
        QueryBuilder rewritten = query.rewrite(queryShardContext);
            if (obj != null) {  
            + "  }\n"
import java.util.Objects;
    }
    @Override  
            }
    public void testFromJsonWithValueType() throws IOException {  
        );  
 *
    public void testEmptyFieldName() {
            + "    }\n"
            TermsQueryBuilder copy = (TermsQueryBuilder) assertSerialization(builder);
        TermsQueryBuilder parsed = (TermsQueryBuilder) parseQuery(json);  
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, randomTermsLookup().store(true)).valueType(
            List<Object> terms;  
            new GetResult(getRequest.index(), getRequest.id(), 0, 1, 0, true, new BytesArray(json), documentField, null)  
    private Set<String> assertedWarnings = new HashSet<>();
        DirectoryReader reader = DirectoryReader.open(w);
            + "        \"value_type\": \"bitmap\"\n"
        assertEquals(json, 2, parsed.values().size());  
        super.testUnknownField();  
        if (queryBuilder.termsLookup() == null && (queryBuilder.values() == null || queryBuilder.values().isEmpty())) {
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
        // Test one value
                    || choice.equals(GEO_SHAPE_FIELD_NAME)
        return query;
            List<Object> values = copy.values();
import org.apache.lucene.util.BytesRef;
        }
        IOUtils.close(w, reader, dir);  
        {
            + "}";  
    public void testConversion() {  
import org.apache.lucene.search.MatchNoDocsQuery;
        TermsQueryBuilder query = new TermsQueryBuilder(INT_FIELD_NAME, randomTermsLookup().store(true)).valueType(
        termsPath = randomAlphaOfLength(10).replace('.', '_');
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(query));
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
        lookup.routing(randomBoolean() ? randomAlphaOfLength(10) : null);
        builder = rewriteAndFetch(builder, createShardContext());
        TermsQueryBuilder parsed = (TermsQueryBuilder) parseQuery(json);
        try {  
        assertEquals(Arrays.asList(5L, 42L), TermsQueryBuilder.convert(list));
import java.io.IOException;
            assertEquals(Arrays.asList(1d, 3d, 4d), values);  
        } else {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (String[]) null));  
    public void testFromJsonWithValueTypeFail() {
    public void testTermsLookupBitmap() throws IOException {  
            .array("bar", 456)  
            TermsQueryBuilder builder = new TermsQueryBuilder("foo", new long[] { 1, 3, 4 });  
    public void testFromJson() throws IOException {
    public void testTermsQueryWithMultipleFields() throws IOException {
            assertThat(query, instanceOf(MatchNoDocsQuery.class));  
        expectedComplement = List.of(  
        byte[] array = new byte[bitmap.serializedSizeInBytes()];
    }
    }
/*  
    }  
    public void testRewriteIndexQueryToNotMatchNone() throws IOException {
                    .or(instanceOf(MatchNoDocsQuery.class))
            if (rarely()) {  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.opensearch.common.document.DocumentField;
                either(instanceOf(TermInSetQuery.class)).or(instanceOf(PointInSetQuery.class))  
import org.apache.lucene.search.TermQuery;
    public GetResponse executeGet(GetRequest getRequest) {
            String fieldName = expectedFieldName(queryBuilder.fieldName());
                terms = randomTerms;
        assertEquals("No value or termsLookup specified for terms query", e.getMessage());
            TermsQueryBuilder copy = (TermsQueryBuilder) assertSerialization(builder);
        assertEquals("[" + TermsQueryBuilder.NAME + "] query does not support multiple fields", e.getMessage());
            + "        \"value_type\": \"bitmap\"\n"
                    .or(instanceOf(ConstantScoreQuery.class))
            new RangeQueryBuilder(DOUBLE_FIELD_NAME).from(501.0).includeLower(false).includeUpper(true)
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
            assertEquals(expected, query);
                return;
import org.opensearch.index.get.GetResult;
        assertNull(queryBuilder.getComplement(null));
                    fieldName,
        assertEquals(complement, expectedComplement);
                nonNullTerms.add(obj);
        {
            + "    \"field\": [\n"
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (int[]) null));
        IndexSearcher searcher = getIndexSearcher(reader);  
import static org.hamcrest.Matchers.instanceOf;
        assertEquals(  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (TermsLookup) null));
        assertEquals(Arrays.asList(new BytesRef("abc")), TermsQueryBuilder.convert(list));  
import org.opensearch.action.get.GetRequest;  
 * not use this file except in compliance with the License.
                expected = new MatchNoDocsQuery();  
        }  
            }
        assertThat(e.getMessage(), containsString("[" + TermsQueryBuilder.NAME + "] query does not support more than one field."));  
            + "    \"boost\" : 1.0\n"  
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, randomTermsLookup().store(true));  
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, values);
        {
                    || choice.equals(DATE_NANOS_FIELD_NAME), // TODO: needs testing for date_nanos type
        assertNull(queryBuilder.getComplement(null));
            TermsQueryBuilder.ValueType.BITMAP  
            .endObject()
                terms = queryBuilder.values();
import static org.hamcrest.Matchers.containsString;
            + "    }\n"  
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
        assertEquals(Arrays.asList(5L, 42L), TermsQueryBuilder.convertBack(TermsQueryBuilder.convert(list)));  
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (Object[]) null));
        assertEquals("field name cannot be null.", e.getMessage());
        );
        IllegalStateException ise = expectThrows(IllegalStateException.class, () -> termsQueryBuilder.writeTo(new BytesStreamOutput(10)));  
        assertNull(queryBuilder.getComplement(createShardContext(searcher)));
 * SPDX-License-Identifier: Apache-2.0
        return new GetResponse(
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (double[]) null));
        } else if (queryBuilder.termsLookup() != null && randomTerms.size() == 0) {
import java.util.stream.Collectors;  
            new RangeQueryBuilder(DOUBLE_FIELD_NAME).to(200.0).includeLower(true).includeUpper(false),
        DirectoryReader reader = DirectoryReader.open(w);
import static org.opensearch.index.query.BoolQueryBuilderTests.getIndexSearcher;
            expected = new TermsQueryBuilder(TEXT_FIELD_NAME, nonNullTerms);  
    public void testGeo() throws Exception {
        assertEquals(json, 1, parsed.values().size());
                    || choice.equals(GEO_POINT_ALIAS_FIELD_NAME)
    }  
        IOUtils.close(w, reader, dir);
    @Override
            } else {
        if (randomBoolean()) {  
                    .or(instanceOf(IndexOrDocValuesQuery.class))  
            + "}";
public class TermsQueryBuilderTests extends AbstractQueryTestCase<TermsQueryBuilder> {  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parseQuery(json));
            new RangeQueryBuilder(DOUBLE_FIELD_NAME).from(304.12).to(500.0).includeLower(false).includeUpper(false),  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, List.of("1", "2", "3"));
    }
    }
            .startObject()  
            + "  \"terms\": {\n"  
            for (int i = 0; i < values.length; i++) {  
import org.hamcrest.CoreMatchers;
                    || choice.equals(DATE_RANGE_FIELD_NAME)
        IOUtils.close(w, reader, dir);
        IOUtils.close(w, reader, dir);
        assertNull(queryBuilder.getComplement(createShardContext(searcher)));  
            );
import org.opensearch.core.xcontent.XContentBuilder;
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(TEXT_FIELD_NAME, new TermsLookup("some_index", "some_id", "some_path"));
    }
            TermsQueryBuilder.ValueType.BITMAP  
    public void testGetComplementValuesLookup() throws Exception {  
        DirectoryReader reader = DirectoryReader.open(w);  
    }
        assertEquals(Arrays.asList(5, 42d), TermsQueryBuilder.convertBack(TermsQueryBuilder.convert(list)));
        Directory dir = newDirectory();  
import org.apache.lucene.search.Query;  
        assertEquals("query must be rewritten first", e.getMessage());
            query = new TermsQueryBuilder(fieldName, values);  
        }
            + "      \"pill\"\n"  
            new RangeQueryBuilder(DOUBLE_FIELD_NAME).from(500.0).to(501.0).includeLower(false).includeUpper(false),
            + "}";
    }  
        for (String string : strings) {
            new RangeQueryBuilder(INT_FIELD_NAME).to(200).includeLower(true).includeUpper(false),  
    public void testMustRewrite() throws IOException {
        );
            }
        // Test multiple consecutive values  
                || queryBuilder.fieldName().equals(BOOLEAN_FIELD_NAME)  
            }  
 * The OpenSearch Contributors require contributions made to  
            new RangeQueryBuilder(DOUBLE_FIELD_NAME).from(200.0).to(304.12).includeLower(false).includeUpper(false),
        assertEquals(list, TermsQueryBuilder.convertBack(TermsQueryBuilder.convert(list)));  
        list = Arrays.asList("abc");
            expected = new MatchNoneQueryBuilder();
        Directory dir = newDirectory();  
            () -> termsQueryBuilder.toQuery(createShardContext())
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(  
                () -> getRandomFieldName()  
        expectedComplement = List.of(
        this.randomTerms = randomTerms;
        UnsupportedOperationException e = expectThrows(  
            Query expected;
        TermsQueryBuilder query = new TermsQueryBuilder("_index", "does_not_exist", "also_does_not_exist");
import org.opensearch.action.get.GetResponse;
        Directory dir = newDirectory();
        // terms lookup removes null values  
    }  
        TermsQueryBuilder query;
        assertSame(Collections.emptyList(), TermsQueryBuilder.convert(list));
    protected TermsQueryBuilder doCreateTestQueryBuilder() {  
        Directory dir = newDirectory();  
import java.util.Map;  
        QueryShardContext queryShardContext = createShardContext();  
    public void testGetComplementWholeNumber() throws Exception {
    public void testGetComplementBitmap() throws Exception {
            assertEquals(Arrays.asList(1L, 3L, 4L), values);  
        UnsupportedOperationException e = expectThrows(UnsupportedOperationException.class, () -> queryBuilder.toQuery(context));
            + "      \"index\": \"pills\",\n"  
import org.apache.lucene.search.TermInSetQuery;
            if (queryBuilder.fieldName().equals(INT_FIELD_NAME)
    public void testCacheability() throws IOException {
        List<Object> values = List.of("200.0", "500.0", "304.12", "501.0");
    public void testNullValues() {
    private TermsLookup randomTermsLookup() {
            + "        \"student_id\": [\"OjAAAAEAAAAAAAEAEAAAAG8A3gA=\", \"2\"],\n"
import org.apache.lucene.search.ConstantScoreQuery;
            + "      \"type\": \"red\",\n"
            randomTerms.add(string);
    }
        assertEquals("field name cannot be null.", e.getMessage());  
            assertThat(query, CoreMatchers.instanceOf(TermsQueryBuilder.class));
        String[] strings = generateRandomStringArray(10, 10, false, true);  
            TermsQueryBuilder copy = (TermsQueryBuilder) assertSerialization(builder);
            QueryBuilder query = super.parseQuery(parser);
            new RangeQueryBuilder(INT_FIELD_NAME).to(201).includeLower(true).includeUpper(false),  
 * license agreements. See the NOTICE file distributed with
import java.util.Collections;
    protected QueryBuilder parseQuery(XContentParser parser) throws IOException {
                values[i] = getRandomValueForFieldName(fieldName);
        // Complement should return null if using bitmap value type.
    public void testGetComplementDouble() throws Exception {
        );  
    }
            }
        String json = "{\n"  
    @Override  
        );
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(query));
 * KIND, either express or implied.  See the License for the
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(TEXT_FIELD_NAME, "some_text");
        list = Arrays.asList("abc", new BytesRef("def"));  
    @Override  
            UnsupportedOperationException.class,
        lookup.store(randomBoolean());
            new RangeQueryBuilder(INT_FIELD_NAME).to(1).includeLower(true).includeUpper(false),
import org.apache.lucene.index.DirectoryReader;
            json = builder.toString();
        IndexSearcher searcher = getIndexSearcher(reader);  
import java.util.Arrays;
            if (query instanceof ConstantScoreQuery) {
            builder.array(termsPath, randomTerms.toArray(new Object[0]));  
    }
import org.opensearch.test.AbstractQueryTestCase;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        String json;
            + "        \"student_id\": [\"OjAAAAEAAAAAAAEAEAAAAG8A3gA=\"],\n"  
            TermsQueryBuilder builder = new TermsQueryBuilder("foo", new float[] { 1, 3, 4 });  
        list = Arrays.asList(5, 42d);
        } else {
            + "    \"field_lookup\": {\n"
            // right now the mock service returns us a list of strings
 *  
            // we only do the check below for string fields (otherwise we'd have to decode the values)  
        TermsQueryBuilder termsQueryBuilder = new TermsQueryBuilder(TEXT_FIELD_NAME, randomTermsLookup());
                    .or(instanceOf(MatchAllDocsQuery.class))
        } finally {
            + "    \"terms\": {\n"
        QueryShardContext context = createShardContext();  
    }
            "Geometry fields do not support exact searching, use dedicated geometry queries instead: " + "[mapped_geo_point]",
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
 * software distributed under the License is distributed on an
            Object[] values = new Object[randomInt(5)];
import org.apache.lucene.search.BooleanQuery;
            TermsQueryBuilder builder = new TermsQueryBuilder("foo", new int[] { 1, 3, 4 });  
    }  
        );  
import java.util.Set;
        IndexSearcher searcher = getIndexSearcher(reader);
    public void testGetComplementNonNumericField() throws Exception {
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
            builder.endObject();
        assertEquals("query must be rewritten first", e.getMessage());  
            builder.startObject();
        // If zero values, we should get null  
import org.opensearch.OpenSearchException;
        }
    public void testBothValuesAndLookupSet() throws IOException {
            if (queryBuilder.termsLookup() != null) {
        QueryBuilder builder = new TermsQueryBuilder(TEXT_FIELD_NAME, randomTermsLookup());
    }  
            "Invalid value for bitmap type: Expected a single-element array with a base64 encoded serialized bitmap.",
        List<Object> nonNullTerms = randomTerms.stream().filter(x -> x != null).collect(Collectors.toList());
        complement = queryBuilder.getComplement(createShardContext(searcher));
        assertThat(e.getMessage(), containsString("No value specified for terms query"));  
        List<QueryBuilder> complement = queryBuilder.getComplement(createShardContext(searcher));
        DirectoryReader reader = DirectoryReader.open(w);  
import org.apache.lucene.search.PointInSetQuery;
        );  
            + "    }\n"
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
        assertTrue(luceneQuery instanceof IndexOrDocValuesQuery);
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
import java.util.HashSet;
        assertEquals(Arrays.asList("abc", "def"), TermsQueryBuilder.convertBack(TermsQueryBuilder.convert(list)));
    public void testToQuery() throws IOException {
            List<Object> values = copy.values();
    private List<Object> randomTerms;
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (long[]) null));
        queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, List.of());
        assertThat(rewritten, instanceOf(MatchAllQueryBuilder.class));
import org.opensearch.core.common.bytes.BytesArray;
            + "      \"path\": \"white rabbit\"\n"  
            List<Object> values = copy.values();
        String query = "{\n"
 * this file be licensed under the Apache-2.0 license or a
 */
                    terms.stream().filter(Objects::nonNull).map(Object::toString).map(BytesRef::new).collect(Collectors.toList())  
        IndexSearcher searcher = getIndexSearcher(reader);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        QueryBuilder rewritten = query.rewrite(queryShardContext);  
        assertNull(complement);  
        complement = queryBuilder.getComplement(createShardContext(searcher));
    }
 * this work for additional information regarding copyright
    public void testSerializationFailsUnlessFetched() throws IOException {  
    }
        } else {  
        }  
            TermsQueryBuilder copy = (TermsQueryBuilder) assertSerialization(builder);
        QueryBuilder expected;
        QueryBuilder rewritten = rewriteQuery(query, new QueryShardContext(context));  
                    .or(instanceOf(TermQuery.class))  
import org.opensearch.core.xcontent.XContentParser;  
        List<QueryBuilder> expectedComplement = List.of(  
 * Licensed to Elasticsearch under one or more contributor  
            .startObject("terms")
            e.getMessage()
        assertEquals(Arrays.asList(5, 42d), TermsQueryBuilder.convert(list));  
                assertThat(((ConstantScoreQuery) query).getQuery(), instanceOf(BooleanQuery.class));  
    public void testEmtpyTermsLookup() {  
import org.opensearch.common.xcontent.XContentFactory;
import org.apache.lucene.index.IndexWriter;  
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
/*  
        builder.writeTo(new BytesStreamOutput(10));  
                expected = new TermInSetQuery(
        // terms query or lookup query
                query,
        List<QueryBuilder> complement = queryBuilder.getComplement(createShardContext(searcher));
        complement = queryBuilder.getComplement(createShardContext(searcher));  
    private boolean maybeIncludeType = true;  
    public void testRewriteIndexQueryToMatchNone() throws IOException {
        // At least one name is good  
import org.apache.lucene.search.IndexSearcher;
import java.nio.ByteBuffer;
import java.util.ArrayList;  
        List<Object> values = List.of("200", "500", "304", "501");  
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("", "term"));
import org.opensearch.common.util.io.IOUtils;
import org.apache.lucene.search.FieldExistsQuery;  
        String json = "{\n"
            );
        List<QueryBuilder> expectedComplement = List.of(
    }  
        if (nonNullTerms.isEmpty()) {  
        maybeIncludeType = false;   // deprecation warnings will fail the parent test, so we disable types
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder(null, "term"));  
            new RangeQueryBuilder(INT_FIELD_NAME).from(201).includeLower(false).includeUpper(true)
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (Iterable<?>) null));  
import org.apache.lucene.store.Directory;  
/*
        List<Object> nonNullTerms = new ArrayList<>();
        QueryBuilder termsQueryBuilder = Rewriteable.rewrite(builder, createShardContext());
        queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, singleValue);
        randomTerms = List.of(new BytesArray(array)); // this will be fetched back by terms lookup  
                || queryBuilder.fieldName().equals(DOUBLE_FIELD_NAME)
        bitmap.serialize(ByteBuffer.wrap(array));
        return lookup;  
            .toString();  
        documentField.put(termsPath, new DocumentField(termsPath, nonNullTerms));
import org.apache.lucene.search.IndexOrDocValuesQuery;
        {
        UnsupportedOperationException e = expectThrows(UnsupportedOperationException.class, () -> queryBuilder.toQuery(context));
import org.roaringbitmap.RoaringBitmap;
    public void randomTerms() {
                choice -> choice.equals(GEO_POINT_FIELD_NAME)  
        String singleValue = "201";  
        assertEquals(complement, expectedComplement);
 */  
    }  
        }
import java.util.List;
            + "    \"terms\": {\n"
        QueryShardContext queryShardContext = createShardContext();
            // make between 0 and 5 different values of the same type
            } else {  
        }  
    public void testUnknownField() throws IOException {
}
        try {  
        TermsLookup lookup = new TermsLookup(randomAlphaOfLength(10), randomAlphaOfLength(10), termsPath);  
        checkGeneratedJson(json, parsed);
 */  
            new RangeQueryBuilder(INT_FIELD_NAME).from(304).to(500).includeLower(false).includeUpper(false),
        assertThat(e.getMessage(), containsString("No value specified for terms query"));  
            query = new TermsQueryBuilder(randomBoolean() ? randomAlphaOfLengthBetween(1, 10) : TEXT_FIELD_NAME, randomTermsLookup());  
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(TEXT_FIELD_NAME, new TermsLookup("some_index", "some_id", "some_path"));
        );
    private String termsPath;
        } catch (IOException ex) {  
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(DOUBLE_FIELD_NAME, values);  
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
            String fieldName = randomValueOtherThanMany(
        assertNull(queryBuilder.getComplement(createShardContext(searcher)));
        bitmap.add(111);
        assertEquals(expected, rewriteAndFetch(termsQueryBuilder, createShardContext()));
                randomTerms.add(null);
import org.opensearch.core.common.ParsingException;  
        IndexSearcher searcher = getIndexSearcher(reader);
            + "  }\n"
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
            + "    ],\n"
package org.opensearch.index.query;
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));
        );
        for (Object obj : randomTerms) {
import org.apache.lucene.search.MatchAllDocsQuery;  
    public void testNumeric() throws IOException {
            e.getMessage()
        IOUtils.close(w, reader, dir);
    }
        }
        assertEquals(complement, expectedComplement);
        Map<String, DocumentField> documentField = new HashMap<>();  
    }
        }
