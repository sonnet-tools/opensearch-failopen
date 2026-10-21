            );
        bitmap.add(333);
                either(instanceOf(TermInSetQuery.class)).or(instanceOf(PointInSetQuery.class))
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (float[]) null));
        DirectoryReader reader = DirectoryReader.open(w);
    private Set<String> assertedWarnings = new HashSet<>();
        builder.writeTo(new BytesStreamOutput(10));
        assertNull(queryBuilder.getComplement(null));
        UnsupportedOperationException e = expectThrows(UnsupportedOperationException.class, () -> queryBuilder.toQuery(context));
        String singleValue = "201";
    public void testCacheability() throws IOException {
            if (query instanceof ConstantScoreQuery) {
            new RangeQueryBuilder(DOUBLE_FIELD_NAME).from(200.0).to(304.12).includeLower(false).includeUpper(false),
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (Object[]) null));
        assertEquals(json, 1, parsed.values().size());
        );
    }
        assertThat(e.getMessage(), containsString("[" + TermsQueryBuilder.NAME + "] query does not support more than one field."));
    public void testFromJson() throws IOException {
import java.util.List;
 * Licensed to Elasticsearch under one or more contributor
            .endObject()
    public void testGetComplementWholeNumber() throws Exception {
        complement = queryBuilder.getComplement(createShardContext(searcher));
import org.apache.lucene.search.TermInSetQuery;
        Directory dir = newDirectory();
 *
        List<Object> values = List.of("200", "500", "304", "501");
            + "        \"boost\" : 1.0,\n"
        assertEquals("field name cannot be null.", e.getMessage());
import java.util.stream.Collectors;
 *     http://www.apache.org/licenses/LICENSE-2.0
                expected = new MatchNoDocsQuery();
import org.opensearch.action.get.GetRequest;
        IOUtils.close(w, reader, dir);
 */
 */
 * KIND, either express or implied.  See the License for the
        }
 *
            new RangeQueryBuilder(INT_FIELD_NAME).to(200).includeLower(true).includeUpper(false),
            new RangeQueryBuilder(INT_FIELD_NAME).to(1).includeLower(true).includeUpper(false),
            + "      \"blue\",\n"
        QueryBuilder expected;
    @Override
            + "}";
import org.opensearch.common.util.io.IOUtils;
            + "    \"field\": [\n"
        );
        IndexSearcher searcher = getIndexSearcher(reader);
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("", "term"));
    }
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(TEXT_FIELD_NAME, new TermsLookup("some_index", "some_id", "some_path"));
        {
            new RangeQueryBuilder(INT_FIELD_NAME).to(201).includeLower(true).includeUpper(false),
            + "      \"pill\"\n"
    }
        assertEquals(
        TermsQueryBuilder query = new TermsQueryBuilder(INT_FIELD_NAME, randomTermsLookup().store(true)).valueType(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder(null, "term"));
                    fieldName,
            return query;
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(query));
package org.opensearch.index.query;
    public void testToQuery() throws IOException {
        TermsQueryBuilder termsQueryBuilder = new TermsQueryBuilder(TEXT_FIELD_NAME, randomTermsLookup());
        assertThat(rewritten, instanceOf(MatchNoneQueryBuilder.class));
            builder.startObject();
import org.hamcrest.CoreMatchers;
/*
            List<Object> values = copy.values();
            builder.array(termsPath, randomTerms.toArray(new Object[0]));
import java.util.Arrays;
        Query luceneQuery = rewritten.toQuery(context);
    @Override
            .startObject("terms")
            assertEquals(Arrays.asList(1L, 3L, 4L), values);
 * this file be licensed under the Apache-2.0 license or a
            json = builder.toString();
            + "    ],\n"
    }
        {
import org.opensearch.common.xcontent.XContentFactory;
                || queryBuilder.fieldName().equals(DOUBLE_FIELD_NAME)
        assertEquals(list, TermsQueryBuilder.convertBack(TermsQueryBuilder.convert(list)));
        TermsLookup lookup = new TermsLookup(randomAlphaOfLength(10), randomAlphaOfLength(10), termsPath);
            // make between 0 and 5 different values of the same type
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
        Map<String, DocumentField> documentField = new HashMap<>();
            + "      \"id\": \"3\",\n"
            Object[] values = new Object[randomInt(5)];
            e.getMessage()
 * under the License.
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (double[]) null));
                return;
        try {
        TermsQueryBuilder query = new TermsQueryBuilder("_index", "does_not_exist", getIndex().getName());
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(TEXT_FIELD_NAME, new TermsLookup("some_index", "some_id", "some_path"));
    public void testTermsLookupBitmap() throws IOException {
            }
    }
    protected QueryBuilder parseQuery(XContentParser parser) throws IOException {
                    .or(instanceOf(TermQuery.class))
    private boolean maybeIncludeType = true;
 * You may obtain a copy of the License at
import org.roaringbitmap.RoaringBitmap;
        DirectoryReader reader = DirectoryReader.open(w);
        // terms query or lookup query
        );
        String json = "{\n"
                );
    }
            // right now the mock service returns us a list of strings
        Directory dir = newDirectory();
                    || choice.equals(DATE_RANGE_FIELD_NAME)
        termsPath = randomAlphaOfLength(10).replace('.', '_');
            new RangeQueryBuilder(DOUBLE_FIELD_NAME).from(500.0).to(501.0).includeLower(false).includeUpper(false),
    @Override
import org.opensearch.indices.TermsLookup;
            UnsupportedOperationException.class,
import java.util.Map;
            .toString();
            // we only do the check below for string fields (otherwise we'd have to decode the values)
        List<Object> values = List.of("200.0", "500.0", "304.12", "501.0");
        documentField.put(termsPath, new DocumentField(termsPath, nonNullTerms));
        );
    public void testConversion() {
        assertEquals(Arrays.asList(5L, 42L), TermsQueryBuilder.convertBack(TermsQueryBuilder.convert(list)));
import org.apache.lucene.search.BooleanQuery;
import java.io.IOException;
        // Test multiple consecutive values
    }
        }
    public void testGeo() throws Exception {
            + "    }\n"
import java.util.ArrayList;
        List<QueryBuilder> complement = queryBuilder.getComplement(createShardContext(searcher));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (TermsLookup) null));
            new RangeQueryBuilder(DOUBLE_FIELD_NAME).to(200.0).includeLower(true).includeUpper(false),
    @Override
    public void testGetComplementValuesLookup() throws Exception {
        bitmap.add(111);
    }
            new RangeQueryBuilder(DOUBLE_FIELD_NAME).from(304.12).to(500.0).includeLower(false).includeUpper(false),
        maybeIncludeType = false;   // deprecation warnings will fail the parent test, so we disable types
        Directory dir = newDirectory();
            } else {
        assertEquals(Arrays.asList(5, 42d), TermsQueryBuilder.convertBack(TermsQueryBuilder.convert(list)));
        }
            if (obj != null) {
            TermsQueryBuilder copy = (TermsQueryBuilder) assertSerialization(builder);
        } finally {
        if (randomBoolean()) {
    protected void doAssertLuceneQuery(TermsQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        assertEquals(Arrays.asList(5, 42d), TermsQueryBuilder.convert(list));
import org.opensearch.core.xcontent.XContentBuilder;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parseQuery(json));
            );
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
        List<Object> nonNullTerms = new ArrayList<>();
            + "        \"value_type\": \"bitmap\"\n"
            // We don't expect a RangeQuery for 500 < value < 501, since nothing could match it on an int field
            } else {
        assertSame(Collections.emptyList(), TermsQueryBuilder.convert(list));
import org.apache.lucene.search.TermQuery;
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
            Query expected;
    public void testGetComplementBitmap() throws Exception {
    }
    }
        DirectoryReader reader = DirectoryReader.open(w);
        List<QueryBuilder> expectedComplement = List.of(
        IOUtils.close(w, reader, dir);
    @Before
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(expected, rewriteAndFetch(termsQueryBuilder, createShardContext()));
        return query;
                    || choice.equals(INT_RANGE_FIELD_NAME)
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
    }
 * compatible open source license.
            expected = new MatchNoneQueryBuilder();
    }
                    .or(instanceOf(MatchAllDocsQuery.class))
        IndexSearcher searcher = getIndexSearcher(reader);
        randomTerms = List.of(new BytesArray(array)); // this will be fetched back by terms lookup
        assertEquals(complement, expectedComplement);
import org.opensearch.test.AbstractQueryTestCase;
}
    }
            }
    }
        QueryBuilder rewritten = query.rewrite(queryShardContext);
import org.apache.lucene.search.ConstantScoreQuery;
        assertEquals("No value or termsLookup specified for terms query", e.getMessage());
        assertNull(queryBuilder.getComplement(createShardContext(searcher)));
        assertEquals("[" + TermsQueryBuilder.NAME + "] query does not support multiple fields", e.getMessage());
        assertEquals(Arrays.asList(new BytesRef("abc"), new BytesRef("def")), TermsQueryBuilder.convert(list));
            + "      \"type\": \"red\",\n"
        DirectoryReader reader = DirectoryReader.open(w);
 */
import org.opensearch.common.io.stream.BytesStreamOutput;
            assertThat(
    }
        }
    }
        lookup.store(randomBoolean());
        lookup.routing(randomBoolean() ? randomAlphaOfLength(10) : null);
        // Complement should return null if using bitmap value type.
            query = new TermsQueryBuilder(randomBoolean() ? randomAlphaOfLengthBetween(1, 10) : TEXT_FIELD_NAME, randomTermsLookup());
            + "        \"student_id\": [\"OjAAAAEAAAAAAAEAEAAAAG8A3gA=\", \"2\"],\n"
import org.opensearch.index.get.GetResult;
    }
        {
    public void testSerializationFailsUnlessFetched() throws IOException {
                    .or(instanceOf(IndexOrDocValuesQuery.class))
            if (queryBuilder.fieldName().equals(INT_FIELD_NAME)
            + "        \"student_id\": [\"OjAAAAEAAAAAAAEAEAAAAG8A3gA=\"],\n"
        );
 * GitHub history for details.
    public void testTermsQueryWithMultipleFields() throws IOException {
            + "    \"field_lookup\": {\n"
        assertEquals(complement, expectedComplement);
        List<QueryBuilder> complement = queryBuilder.getComplement(createShardContext(searcher));
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
        try {
        String json = "{\n"
    @Override
            + "    \"terms\": {\n"
        TermsQueryBuilder parsed = (TermsQueryBuilder) parseQuery(json);
        }
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, randomTermsLookup().store(true)).valueType(
        TermsQueryBuilder query;
        assertNull(queryBuilder.getComplement(createShardContext(searcher)));
        assertEquals("query must be rewritten first", e.getMessage());
import org.apache.lucene.store.Directory;
        assertEquals(
import org.apache.lucene.search.PointInSetQuery;
            throw new OpenSearchException("boom", ex);
        } else {
            assertThat(query, CoreMatchers.instanceOf(TermsQueryBuilder.class));
        );
    }
        String json;
        );
            + "  }\n"
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
import java.nio.ByteBuffer;
        QueryShardContext queryShardContext = createShardContext();
        return new GetResponse(
import org.apache.lucene.search.IndexSearcher;
        String[] strings = generateRandomStringArray(10, 10, false, true);
        checkGeneratedJson(json, parsed);
/*
import org.apache.lucene.search.IndexOrDocValuesQuery;
        assertThat(rewritten, instanceOf(MatchAllQueryBuilder.class));
        list = Arrays.asList("abc");
        assertEquals(Arrays.asList(5L, 42L), TermsQueryBuilder.convert(list));
        assertEquals(complement, expectedComplement);
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
        IOUtils.close(w, reader, dir);
    }
    }
            }
            new RangeQueryBuilder(INT_FIELD_NAME).from(304).to(500).includeLower(false).includeUpper(false),
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(DOUBLE_FIELD_NAME, values);
                terms = randomTerms;
            if (rarely()) {
import org.opensearch.core.common.ParsingException;
        IndexSearcher searcher = getIndexSearcher(reader);
        complement = queryBuilder.getComplement(createShardContext(searcher));
        );
import org.apache.lucene.search.MatchAllDocsQuery;
        UnsupportedOperationException e = expectThrows(UnsupportedOperationException.class, () -> queryBuilder.toQuery(context));
        TermsQueryBuilder query = new TermsQueryBuilder(GEO_POINT_FIELD_NAME, "2,3");
import org.opensearch.core.xcontent.XContentParser;
        String json = "{\n"
                terms = queryBuilder.values();
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.OpenSearchException;
        assertEquals("query must be rewritten first", e.getMessage());
        list = Arrays.asList(5, 42d);
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
    @Override
    private String termsPath;
        assertEquals(Arrays.asList("abc", "def"), TermsQueryBuilder.convertBack(TermsQueryBuilder.convert(list)));
            + "  \"terms\": {\n"
            + "    \"user\" : [ \"foobar\", \"opensearch\" ],\n"
            }
    private TermsLookup randomTermsLookup() {
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));
        QueryBuilder rewritten = query.rewrite(queryShardContext);
    public void testRewriteIndexQueryToMatchNone() throws IOException {
        expectedComplement = List.of(
import org.junit.Before;
        List<QueryBuilder> expectedComplement = List.of(
        }
            TermsQueryBuilder builder = new TermsQueryBuilder("foo", new int[] { 1, 3, 4 });
            + "}";
        queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, List.of());
        QueryBuilder rewritten = rewriteQuery(query, new QueryShardContext(context));
    }
        } else {
                    .or(instanceOf(FieldExistsQuery.class))
 * The OpenSearch Contributors require contributions made to
        IllegalStateException ise = expectThrows(IllegalStateException.class, () -> termsQueryBuilder.writeTo(new BytesStreamOutput(10)));
            assertEquals(Arrays.asList(1L, 3L, 4L), values);
            TermsQueryBuilder copy = (TermsQueryBuilder) assertSerialization(builder);
            "Invalid value for bitmap type: Expected a single-element array with a base64 encoded serialized bitmap.",
import org.apache.lucene.index.IndexWriter;
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
 * software distributed under the License is distributed on an
        }
            new RangeQueryBuilder(INT_FIELD_NAME).from(200).to(304).includeLower(false).includeUpper(false),
    protected TermsQueryBuilder doCreateTestQueryBuilder() {
                () -> getRandomFieldName()
    }
                    terms.stream().filter(Objects::nonNull).map(Object::toString).map(BytesRef::new).collect(Collectors.toList())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Unless required by applicable law or agreed to in writing,
            new RangeQueryBuilder(INT_FIELD_NAME).from(501).includeLower(false).includeUpper(true)
        QueryBuilder termsQueryBuilder = Rewriteable.rewrite(builder, createShardContext());
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        super.testUnknownField();
    }
        List<Object> list = Arrays.asList();
        DirectoryReader reader = DirectoryReader.open(w);
        bitmap.serialize(ByteBuffer.wrap(array));
        checkGeneratedJson(json, parsed);
        assertEquals("query must be rewritten first", e.getMessage());
            List<Object> values = copy.values();
        String query = XContentFactory.jsonBuilder()
        QueryBuilder builder = new TermsQueryBuilder(TEXT_FIELD_NAME, randomTermsLookup());
 *
        queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, List.of("1", "2", "3"));
    public void testUnknownField() throws IOException {
    }
                nonNullTerms.add(obj);
            + "    \"boost\" : 1.0\n"
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
            TermsQueryBuilder copy = (TermsQueryBuilder) assertSerialization(builder);
            + "      \"path\": \"white rabbit\"\n"
                choice -> choice.equals(GEO_POINT_FIELD_NAME)
                    .or(instanceOf(MatchNoDocsQuery.class))
import org.apache.lucene.search.FieldExistsQuery;
    public void testMustRewrite() throws IOException {
        list = Arrays.asList("abc", new BytesRef("def"));
        assertEquals(json, 2, parsed.values().size());
public class TermsQueryBuilderTests extends AbstractQueryTestCase<TermsQueryBuilder> {
    public void testGetComplementDouble() throws Exception {
        List<Object> randomTerms = new ArrayList<>();
    }
import static org.opensearch.index.query.BoolQueryBuilderTests.getIndexSearcher;
        expectedComplement = List.of(
        }
            .array("bar", 456)
        // If zero values, we should get null
                || queryBuilder.fieldName().equals(DATE_FIELD_NAME)) {
 * Modifications Copyright OpenSearch Contributors. See
    public void testEmtpyTermsLookup() {
        IndexSearcher searcher = getIndexSearcher(reader);
        for (Object obj : randomTerms) {
        assertEquals(complement, expectedComplement);
                assertThat(((ConstantScoreQuery) query).getQuery(), instanceOf(BooleanQuery.class));
                    || choice.equals(GEO_POINT_ALIAS_FIELD_NAME)
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.either;
        assertEquals(list, TermsQueryBuilder.convertBack(TermsQueryBuilder.convert(list)));
    public void testGetComplementNonNumericField() throws Exception {
import org.apache.lucene.util.BytesRef;
    private List<Object> randomTerms;
        byte[] array = new byte[bitmap.serializedSizeInBytes()];
    }
import java.util.HashSet;
        complement = queryBuilder.getComplement(createShardContext(searcher));
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(query));
                    .or(instanceOf(ConstantScoreQuery.class))
        TermsQueryBuilder parsed = (TermsQueryBuilder) parseQuery(json);
            TermsQueryBuilder builder = new TermsQueryBuilder("foo", new float[] { 1, 3, 4 });
            TermsQueryBuilder.ValueType.BITMAP
            new RangeQueryBuilder(INT_FIELD_NAME).from(3).includeLower(false).includeUpper(true)
            }
    public void testEmptyFieldName() {
        IOUtils.close(w, reader, dir);
                values[i] = getRandomValueForFieldName(fieldName);
    }
    }
        IndexSearcher searcher = getIndexSearcher(reader);
            TermsQueryBuilder copy = (TermsQueryBuilder) assertSerialization(builder);
/*
        }
        );
        } else {
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (Iterable<?>) null));
        IOUtils.close(w, reader, dir);
            assertEquals(Arrays.asList(1d, 3d, 4d), values);
        assertTrue(luceneQuery instanceof IndexOrDocValuesQuery);
        if (nonNullTerms.isEmpty()) {
                query,
            QueryBuilder query = super.parseQuery(parser);
                || queryBuilder.fieldName().equals(BOOLEAN_FIELD_NAME)
import org.apache.lucene.search.MatchNoDocsQuery;
        // At least one name is good
        this.randomTerms = randomTerms;
        QueryShardContext context = createShardContext();
    public void testFromJsonWithValueType() throws IOException {
            String fieldName = randomValueOtherThanMany(
            assertEquals(Arrays.asList(1f, 3f, 4f), values);
            List<Object> values = copy.values();
            TermsQueryBuilder builder = new TermsQueryBuilder("foo", new double[] { 1, 3, 4 });
        list = Arrays.asList(5, 42L);
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (long[]) null));
            + "}";
            + "      \"index\": \"pills\",\n"
 * this work for additional information regarding copyright
import org.opensearch.common.document.DocumentField;
 * ownership. Elasticsearch licenses this file to you under
    }
            + "}";
 * specific language governing permissions and limitations
    public void testFromJsonWithValueTypeFail() {
        } else if (queryBuilder.termsLookup() != null && randomTerms.size() == 0) {
            .startObject()
import org.apache.lucene.index.DirectoryReader;
            + "    }\n"
        builder = rewriteAndFetch(builder, createShardContext());
import org.opensearch.action.get.GetResponse;
            List<Object> values = copy.values();
    public void testNullValues() {
            query = new TermsQueryBuilder(fieldName, values);
            TermsQueryBuilder builder = new TermsQueryBuilder("foo", new long[] { 1, 3, 4 });
            }
            .endObject()
        assertEquals("field name cannot be null.", e.getMessage());
    public void testNumeric() throws IOException {
import static org.hamcrest.Matchers.instanceOf;
                    || choice.equals(GEO_SHAPE_FIELD_NAME)
    @Override
        if (queryBuilder.termsLookup() == null && (queryBuilder.values() == null || queryBuilder.values().isEmpty())) {
                    || choice.equals(DATE_NANOS_FIELD_NAME), // TODO: needs testing for date_nanos type
        QueryShardContext queryShardContext = createShardContext();
                expected = new TermInSetQuery(
            expected = new TermsQueryBuilder(TEXT_FIELD_NAME, nonNullTerms);
            // expected returned terms depending on whether we have a terms query or a terms lookup query
        // Test multiple values
 * license agreements. See the NOTICE file distributed with
        {
            for (int i = 0; i < values.length; i++) {
        assertNull(complement);
            e.getMessage()
            TermsQueryBuilder.ValueType.BITMAP
        RoaringBitmap bitmap = new RoaringBitmap();
            + "    }\n"
            if (queryBuilder.termsLookup() != null) {
        QueryShardContext context = createShardContext();
        assertNull(queryBuilder.getComplement(null));
            new RangeQueryBuilder(DOUBLE_FIELD_NAME).from(501.0).includeLower(false).includeUpper(true)
            new GetResult(getRequest.index(), getRequest.id(), 0, 1, 0, true, new BytesArray(json), documentField, null)
    public void testRewriteIndexQueryToNotMatchNone() throws IOException {
        TermsQueryBuilder query = new TermsQueryBuilder("_index", "does_not_exist", "also_does_not_exist");
        QueryShardContext context = createShardContext();
import java.util.Set;
            + "        \"value_type\": \"bitmap\"\n"
            randomTerms.add(string);
            builder.endObject();
import org.apache.lucene.search.Query;
        assertEquals(Arrays.asList(new BytesRef("abc")), TermsQueryBuilder.convert(list));
            new RangeQueryBuilder(INT_FIELD_NAME).from(201).includeLower(false).includeUpper(true)
        queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, singleValue);
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
            + "  }\n"
import java.util.Objects;
    }
        for (String string : strings) {
        Directory dir = newDirectory();
        );
            XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
import java.util.Collections;
            if (context.fieldMapper(fieldName) != null) {
            String fieldName = expectedFieldName(queryBuilder.fieldName());
    public GetResponse executeGet(GetRequest getRequest) {
            + "        \"boost\" : 1.0,\n"
        } catch (IOException ex) {
        assertEquals(ise.getMessage(), "supplier must be null, can't serialize suppliers, missing a rewriteAndFetch?");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (String[]) null));
        QueryShardContext context = createShardContext();
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(TEXT_FIELD_NAME, "some_text");
            List<Object> terms;
        // terms lookup removes null values
            .array("foo", 123)
            }
            + "  \"terms\" : {\n"
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
            + "    \"terms\": {\n"
            assertEquals(expected, query);
        e = expectThrows(IllegalArgumentException.class, () -> new TermsQueryBuilder("field", (int[]) null));
    public void randomTerms() {
        }
 * SPDX-License-Identifier: Apache-2.0
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, randomTermsLookup().store(true));
        List<Object> nonNullTerms = randomTerms.stream().filter(x -> x != null).collect(Collectors.toList());
    public void testBothValuesAndLookupSet() throws IOException {
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
import java.util.HashMap;
            "Geometry fields do not support exact searching, use dedicated geometry queries instead: " + "[mapped_geo_point]",
            () -> termsQueryBuilder.toQuery(createShardContext())
        assertThat(e.getMessage(), containsString("No value specified for terms query"));
    @Override
        String query = "{\n"
                randomTerms.add(null);
        assertNull(queryBuilder.getComplement(createShardContext(searcher)));
        TermsQueryBuilder queryBuilder = new TermsQueryBuilder(INT_FIELD_NAME, values);
        }
        Directory dir = newDirectory();
        UnsupportedOperationException e = expectThrows(
import static org.hamcrest.Matchers.containsString;
        return lookup;
        // Test one value
