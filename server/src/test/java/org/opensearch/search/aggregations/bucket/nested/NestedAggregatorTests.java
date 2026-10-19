                InternalMax max = (InternalMax) nested.getProperty(MAX_AGG_NAME);  
    @Override
                InternalNested nested = searchAndReduce(  
import org.opensearch.search.aggregations.bucket.terms.Terms;
                assertEquals(9, res.v1().intValue());
                    fieldType2  
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));  
                );  
import org.opensearch.search.aggregations.metrics.InternalSum;
        return Arrays.stream(fieldTypes).collect(Collectors.toMap(ft -> ft.name() + "-alias", Function.identity()));  
import java.util.stream.Collectors;
            DocIdSetIterator childDocs = getDocIdSetIterator(new int[] { 2, 4 });
    private static void generateDocument(List<Document> documents, int id, String path, String fieldName, long vales) {
import org.opensearch.common.collect.Tuple;
                TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("authors").userValueTypeHint(ValueType.STRING)  
    @Override  
                assertEquals("e", bucket.getKeyAsString());
import org.opensearch.index.mapper.ContentPath;
import org.apache.lucene.search.join.ScoreMode;
import org.apache.lucene.search.BooleanQuery;
                    fieldType2
                assertEquals("e", bucket.getKeyAsString());  
                assertEquals(3, res.v1().intValue());
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));  
                iw.addDocuments(documents);
        try (Directory directory = newDirectory()) {  
                iw.commit();
                    values[i] = new BytesRef(bucketKeys[i]);  
                        )
        return documents;
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, "nested_field");  
                iw.commit();  
                        generateDocument(documents, i, NESTED_OBJECT2, VALUE_FIELD_NAME2, i);  
            assertEquals(2, res.v2().intValue());
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));  
}
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.IndexWriterConfig;  
import org.apache.lucene.document.SortedDocValuesField;
                iw.addDocuments(documents);  
                // inner nested aggs  
                assertEquals(3L, filter.getDocCount());
                termsBuilder = new TermsAggregationBuilder("authors").userValueTypeHint(ValueType.STRING)
        }  
                    NESTED_OBJECT + "." + VALUE_FIELD_NAME,
        {
                    newSearcher(indexReader, false, true),
        );
            aggTestIndicesBitsetFilterCache,  
                FilterAggregationBuilder filterAggregationBuilder = new FilterAggregationBuilder("filterAgg", new MatchAllQueryBuilder());
        }  
                assertEquals(expectedNestedDocs, nested.getDocCount());  
                    createIndexSettings(),
                // reverse order:
import java.util.HashMap;  
        when(queryShardContext.allowExpensiveQueries()).thenReturn(true);
                InternalTerms<?, LongTerms.Bucket> terms = (InternalTerms) nested.getProperty("terms");
                return bits.length;  
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                    true,  
import org.opensearch.threadpool.TestThreadPool;  
                document = new Document();
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));  
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {  
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
            }
                    int numNestedDocs = randomIntBetween(0, 20);
import static org.mockito.Mockito.when;  
    public static MappedFieldType[] resellersMappedFields() {  
        QueryShardContext queryShardContext = mock(QueryShardContext.class);  
                // and 1 document, with 1 nested subdoc
            }
            documents.add(document);
                Document document = new Document();
        String[] bucketKeys;
                }
    }
            );
import org.apache.lucene.search.TermQuery;
    }
                InternalNested nested = searchAndReduce(  
                    InternalMax max = (InternalMax) bucket.getAggregations().asMap().get(MAX_AGG_NAME);  
                assertNotNull(terms);  
import org.opensearch.common.settings.Settings;
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                    nestedBuilder,
        }
                    .order(BucketOrder.aggregation("chapters>num_pages.value", false));
            }
                );
                document = new Document();
        when(queryShardContext.bitsetFilter(any())).thenReturn(nonNestedFilter);
                        generateDocument(documents, i, NESTED_OBJECT, VALUE_FIELD_NAME, 1);
                iw.addDocuments(documents);  
                        generateDocument(documents, i, NESTED_OBJECT, VALUE_FIELD_NAME, 1);  
            aggTestIndicesBitsetFilterCache = new IndicesBitsetFilterCache(Settings.EMPTY);
                    fieldType  
                    expectedNestedDocs += numNestedDocs;  
                res = getParentAndChildId(parentDocs, childDocs, 4);
                iw.commit();  
                    List<Document> documents = new ArrayList<>();
                    id++;  
                    DEFAULT_MAX_BUCKETS,
                MappedFieldType fieldType1 = new NumberFieldMapper.NumberFieldType("num_pages", NumberFieldMapper.NumberType.LONG);  
 * Unless required by applicable law or agreed to in writing,
                nestedBuilder.subAggregation(maxAgg);
        }
                int cmp = Integer.compare(o1.v2()[0], o2.v2()[0]);
                    nestedBuilder,  
                bucket = terms.getBuckets().get(6);
                TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("authors").userValueTypeHint(ValueType.STRING)
            }
                documents.add(document);
                assertEquals(MAX_AGG_NAME, max.getName());
                    newSearcher(indexReader, false, true),
        int[] bits = new int[value[value.length - 1] + 1];
                    createIndexSettings(),
                assertEquals("g", bucket.getKeyAsString());
                bucket = terms.getBuckets().get(2);
                document = new Document();
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(
                assertEquals("a1", valueAgg.getBuckets().get(0).getKey());
                    document.add(sequenceIDFields.primaryTerm);
        when(queryShardContext.getObjectMapper(anyString())).thenAnswer(invocation -> {  
import org.apache.lucene.search.DocIdSetIterator;  
        }
                        generateMaxDocs(documents, numNestedDocs, i, NESTED_OBJECT, VALUE_FIELD_NAME)
                assertEquals(books.size(), terms.getBuckets().size());
                StringTerms keyAgg = nested.getAggregations().get("key");
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, "nested_field");
            @Override
                )  
                    termsBuilder,  
                assertEquals(expectedNestedDocs, nested.getDocCount());
                    new MatchAllDocsQuery(),  
                assertEquals("key2", key2.getKey());  
                InternalNested nested = searchAndReduce(  
                        .subAggregation(
    }  
            }
                assertFalse(AggregationInspectionHelper.hasValue(nested));  
                document.add(new SortedDocValuesField("value", new BytesRef("a3")));
        testCase(b, new MatchAllDocsQuery(), buildResellerData(numProducts, numResellers), result -> {
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
                for (int i = 0; i < numRootDocs; i++) {  
                filterAggregationBuilder.subAggregation(nestedBuilder);  
import org.opensearch.index.mapper.Uid;
                        generateDocument(documents, i, NESTED_OBJECT2, VALUE_FIELD_NAME2, i);
                bucket = terms.getBuckets().get(4);
                    newSearcher(indexReader, false, true),
                    newSearcher(indexReader, false, true),  
                    }
            for (Tuple<String, int[]> book : books) {  
            }  
                assertEquals(39, (int) numPages.getValue());
    }
            parentDocs.set(9);  
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                }
                    fieldType
                // 1 segment with:
                    .field("author")  
                assertEquals(4L, nested.getDocCount());
import org.opensearch.index.mapper.KeywordFieldMapper;  
                QueryShardContext queryShardContext = createQueryShardContext(NESTED_OBJECT2, indexSettings, fieldType1);
                    NumberFieldMapper.NumberType.LONG  
                index = bits.length;  
                nestedBuilder.subAggregation(sumAgg);  
                    NESTED_OBJECT + "." + VALUE_FIELD_NAME,  
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder("num_pages").field("num_pages");
    public void testNestedWithPipeline() throws IOException {
            res = getParentAndChildId(parentDocs, childDocs, 8);  
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);
            document.add(new SortedSetDocValuesField("author", new BytesRef(author)));
            // [p0], [p1], [c2,p3], [c4,x5,p6], [p7], [p8]
                    bucketKeys[i] = "" + (i * 2);
                termsBuilder.subAggregation(nestedBuilder);
            document.add(new Field(NestedPathFieldMapper.NAME, "nested_chapters", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                assertEquals("a3", valueAgg.getBuckets().get(2).getKey());  
    private static final String NESTED_AGG = "nestedAgg";
    }  
    private double generateMaxDocs(List<Document> documents, int numNestedDocs, int id, String path, String fieldName) {  
                    );
 * not use this file except in compliance with the License.
                if (cmp == 0) {
    private static final SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                document.add(new SortedDocValuesField("key", new BytesRef("key1")));
                LongTerms outTerms = (LongTerms) nested.getProperty(OUT_TERMS);
import org.opensearch.search.aggregations.AggregatorTestCase;  
            );
                iw.addDocuments(generateBook("9", new String[] { "g", "c", "e" }, new int[] { 18, 8 }));
                assertEquals(7, res.v2().intValue());
        for (String author : authors) {  
                MappedFieldType fieldType1 = new NumberFieldMapper.NumberFieldType("num_pages", NumberFieldMapper.NumberType.LONG);
                for (LongTerms.Bucket bucket : terms.getBuckets()) {
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(
            res = getParentAndChildId(parentDocs, childDocs, 4);
    private DocIdSetIterator getDocIdSetIterator(int[] value) {  
                assertEquals("b2", valueAgg.getBuckets().get(1).getKey());
                    fieldType1,
                bucket = terms.getBuckets().get(1);
                document.add(new SortedDocValuesField("key", new BytesRef("key2")));  
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("2"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
/*  
import org.opensearch.index.mapper.NumberFieldMapper;
                documents.add(document);  
                    new MatchAllDocsQuery(),  
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                innerNestedBuilder.subAggregation(innerTermsAggregator);
                NestedAggregationBuilder aliasAgg = nested(NESTED_AGG, NESTED_OBJECT).subAggregation(
                documents.add(document);  
                iw.addDocuments(generateBook("8", new String[] { "f" }, new int[] { 12, 14 }));  
            BitSet parentDocs = new FixedBitSet(20);
                document = new Document();  
                    nestedBuilder,
                outNestedBuilder.subAggregation(outTermsAggregator);
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);
                documents.add(document);
 * this work for additional information regarding copyright
                    assertTrue(AggregationInspectionHelper.hasValue(nested));  
                document = new Document();  
                assertEquals(50, (int) numPages.getValue());  
        int expectedNestedDocs = 0;  
                    }
import org.opensearch.search.aggregations.BucketOrder;
                assertEquals("g", bucket.getKeyAsString());  
                iw.commit();
        scripts.put(INVERSE_SCRIPT, vars -> -((Number) vars.get("_value")).doubleValue());
            @Override
                    NumberFieldMapper.NumberType.LONG  
                NestedAggregationBuilder agg = nested(NESTED_AGG, NESTED_OBJECT).subAggregation(max(MAX_AGG_NAME).field(VALUE_FIELD_NAME));
                    newSearcher(indexReader, false, true),  
import org.apache.lucene.util.FixedBitSet;  
                Max numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                assertEquals(6L, nested.getDocCount());
import org.apache.lucene.document.Field;
                    aliasAgg,
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                }
                assertEquals(6, res.v1().intValue());  
                    .order(BucketOrder.compound(BucketOrder.aggregation("chapters>num_pages.value", true), BucketOrder.key(true)));  
import org.opensearch.search.aggregations.metrics.Max;  
            document.add(new Field(NestedPathFieldMapper.NAME, path, NestedPathFieldMapper.Defaults.FIELD_TYPE));
                assertTrue(AggregationInspectionHelper.hasValue(nested));
                assertEquals(NESTED_AGG, nested.getName());
        for (int i = 0; i < numBooks; i++) {
        int numRootDocs = scaledRandomIntBetween(2, 200);
                assertThat(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("3"), IdFieldMapper.Defaults.FIELD_TYPE));
                    NumberFieldMapper.NumberType.LONG
        int numRootDocs = randomIntBetween(1, 20);  
                iw.addDocuments(generateBook("2", new String[] { "b" }, new int[] { 5, 50 }));  
                assertEquals("authors", terms.getName());
                nestedBuilder.subAggregation(minAgg);  
                );
                expectedNestedDocs = numRootDocs / 2;
                assertEquals("f", bucket.getKeyAsString());
            @Override
                assertEquals(OUT_NESTED, nested.getName());
                    assertFalse(AggregationInspectionHelper.hasValue(nested));  
                assertEquals(2, keyAgg.getBuckets().size());
                Terms.Bucket key1 = keyAgg.getBuckets().get(0);  
                documents.add(document);
                nestedBuilder.subAggregation(maxAgg);
                // segment are emitted as hits.  
                document.add(new SortedDocValuesField("key", new BytesRef("key1")));  
    public void testNestedOrdering_random() throws IOException {
        for (int i : value) {
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                List<Document> documents = new ArrayList<>();  
        }
    }  
            }
                    equalTo(LongStream.range(0, numResellers).mapToObj(Long::valueOf).collect(toList()))
                    fieldType,  
                    documents.get(r).add(new SortedNumericDocValuesField("reseller_id", r));
                TermsAggregationBuilder innerTermsAggregator = new TermsAggregationBuilder(INNER_TERMS).field(
                assertEquals(3, valueAgg.getBuckets().size());  
        document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE));
import java.util.stream.LongStream;
                    createIndexSettings(),
                chapters[j] = randomIntBetween(2, 64);  
            parentDocs.set(11);
            }
            .size(numProducts)
        double expectedSum = 0;
                );  
                    newSearcher(indexReader, false, true),
            }
        int expectedNestedDocs = 0;
                                Collections.singletonMap("_value", MAX_AGG_NAME),
                    newSearcher(indexReader, false, true),  
                }  
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                    agg,
        try (Directory directory = newDirectory()) {
                assertEquals("b", bucket.getKeyAsString());  
                bucket = terms.getBuckets().get(6);  
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("3"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));  
    }  
            }
        return DoubleStream.of(generateDocuments(documents, numNestedDocs, id, path, fieldName)).sum();
                bq.add(Queries.newNonNestedFilter(), BooleanClause.Occur.MUST);  
                    InternalSimpleValue bucketScript = (InternalSimpleValue) bucket.getAggregations().asMap().get("bucketscript");
                iw.commit();  
        double expectedMaxValue = Double.NEGATIVE_INFINITY;  
                document = new Document();
import org.opensearch.search.aggregations.bucket.filter.Filter;  
                ).size(100);
                InternalNested nested = searchAndReduce(
            public long cost() {
import org.opensearch.index.query.MatchAllQueryBuilder;
                    int numNestedDocs = randomIntBetween(0, 20);
        int numRootDocs = randomIntBetween(1, 20);  
import org.apache.lucene.document.SortedSetDocValuesField;  
import java.util.Locale;
    public void testBufferingNestedLeafBucketCollector() throws IOException {
                bucket = terms.getBuckets().get(3);  
    }
                    DEFAULT_MAX_BUCKETS,
    private static final String MAX_AGG_NAME = "maxAgg";  
                    expectedNestedDocs += numNestedDocs;  
                Document document = new Document();
    private static final String OUT_TERMS = "outTerms";
    private static final String INVERSE_SCRIPT = "inverse";
 * under the License.  
import java.io.IOException;
 * software distributed under the License is distributed on an
        List<Document> documents = new ArrayList<>();
                IndexSettings indexSettings = createIndexSettings();
                    new MatchAllDocsQuery(),  
        AggregationBuilder b = new TermsAggregationBuilder("products").field("product_id")
                bucket = terms.getBuckets().get(1);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                LongTerms.Bucket bucket = products.getBucketByKey(Integer.toString(p));  
                Tuple<Integer, Integer> res = getParentAndChildId(parentDocs, childDocs, 2);
                documents.add(document);
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));  
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                assertEquals(MAX_AGG_NAME, max.getName());
            assertEquals(0, res.v1().intValue());
package org.opensearch.search.aggregations.bucket.nested;
 *
import static org.mockito.ArgumentMatchers.anyString;
                        index = i;
        int numResellers = scaledRandomIntBetween(1, 100);
                    assertFalse(AggregationInspectionHelper.hasValue(nested));
    }  
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.FIELD_TYPE));  
                        index = i;
                bucket = terms.getBuckets().get(0);  
            // [p0], [c1,d2,p3], [d4,c5,p6], [c7,d8,p9], [c10,p11]
        document.add(new Field(NestedPathFieldMapper.NAME, path, NestedPathFieldMapper.Defaults.FIELD_TYPE));
            }
                    document.add(sequenceIDFields.primaryTerm);
            public int docID() {  
            }
                document = new Document();
                }
            parentDocs.set(1);
                assertEquals("c", bucket.getKeyAsString());
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                } else {
            }  
        int expectedNestedDocs = 0;
                iw.close();
                    iw.addDocuments(documents);
import org.opensearch.search.aggregations.InternalAggregation;
        try (Directory directory = newDirectory()) {
                assertEquals(expectedNestedDocs, internalNested.getDocCount());
            bits[i] = 1;  
import org.apache.lucene.document.Document;
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.FIELD_TYPE));  
import org.opensearch.index.query.QueryShardContext;
 */
                InternalNested nested = searchAndReduce(
    protected QueryShardContext createQueryShardContext(String fieldName, IndexSettings indexSettings, MappedFieldType fieldType) {
                // add some random nested docs that don't belong
                assertEquals(6, res.v1().intValue());  
            }
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
        return new MappedFieldType[] { productIdField, resellerIdField };  
                    .order(BucketOrder.aggregation("chapters>num_pages.value", true));  
            }
                    } else {
import java.util.Collections;
    }
                InternalNested internalNested = (InternalNested) (((Object[]) outTerms.getProperty(INNER_NESTED))[0]);
    public void testNestedOrdering() throws IOException {
                assertEquals("d", bucket.getKeyAsString());  
                bucket = terms.getBuckets().get(2);  
    protected Map<String, MappedFieldType> getFieldAliases(MappedFieldType... fieldTypes) {
        documents.add(document);
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
import static org.opensearch.search.aggregations.AggregationBuilders.max;  
                            )
                    true,  
            int numChapters = randomIntBetween(1, 8);  
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                InternalMax max = (InternalMax) nested.getProperty(MAX_AGG_NAME);
                    expectedMaxValue = Math.max(  
    private static final String VALUE_FIELD_NAME = "number";
import java.util.ArrayList;  
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
 * compatible open source license.
    private static final String INNER_NESTED = "innerNested";
                    newSearcher(indexReader, false, true),
                    documents.add(document);  
            res = getParentAndChildId(parentDocs, childDocs, 3);
    private List<Document> generateBook(String id, String[] authors, int[] numPages) {
 * Licensed to Elasticsearch under one or more contributor  
                iw.commit();
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {  
                if (expectedNestedDocs > 0) {  
                assertEquals("c", bucket.getKeyAsString());
        }  
                document.add(sequenceIDFields.primaryTerm);
                    newSearcher(indexReader, false, true),
                        .userValueTypeHint(ValueType.NUMERIC)  
            Document document = new Document();
        double[] values = new double[numNestedDocs];  
import static org.mockito.ArgumentMatchers.any;  
                }  
            }
     */
                assertEquals(nested, aliasNested);
            document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(id)), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));  
                DocIdSetIterator childDocs = getDocIdSetIterator(new int[] { 1, 5, 7, 10 });  
            }
    public void testGetParentAndChildId() throws IOException {
import org.apache.lucene.search.MatchAllDocsQuery;
        int numBooks = randomIntBetween(32, 512);  
                    new MatchAllDocsQuery(),
        try (Directory directory = newDirectory()) {
                    List<Document> documents = new ArrayList<>();  
        document.add(new LongPoint(path + "." + fieldName, vales));  
                    new MatchAllDocsQuery(),  
 * The OpenSearch Contributors require contributions made to  
                    NESTED_OBJECT + "." + VALUE_FIELD_NAME,
        });  
    public void testSingleNestingMax() throws IOException {
            parentDocs.set(6);
    /**  
                    max(MAX_AGG_NAME).field(VALUE_FIELD_NAME + "-alias")  
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                );  
                    fieldType1
                );  
                    true,
            Tuple<Integer, Integer> res = getParentAndChildId(parentDocs, childDocs, 0);  
                    NESTED_OBJECT + "." + VALUE_FIELD_NAME,
                bucket = terms.getBuckets().get(5);  
                document.add(new SortedNumericDocValuesField("product_id", p));
        double expectedMaxValue = Double.NEGATIVE_INFINITY;
    }
            {
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);  
            int[] chapters = new int[numChapters];
import static org.opensearch.search.aggregations.AggregationBuilders.nested;
                );
                assertEquals("authors", terms.getName());  
                );  
                }  
import org.opensearch.script.ScriptType;
import org.apache.lucene.tests.index.RandomIndexWriter;  
                TermsAggregationBuilder valueBuilder = new TermsAggregationBuilder("value").userValueTypeHint(ValueType.STRING)
                for (int i = 0; i < numRootDocs; i++) {
                ).size(100);  
import static org.mockito.Mockito.mock;
                    Tuple<String, int[]> book = books.get(i);  
                for (int i = 0; i < books.size(); i++) {
import org.opensearch.search.aggregations.support.ValueType;
                    if (randomBoolean()) {
            }  
                    iw.addDocuments(documents);  
            }  
                res = getParentAndChildId(parentDocs, childDocs, 8);  
                    newSearcher(indexReader, false, true),
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);
            {
import org.opensearch.index.query.NestedQueryBuilder;  
                document.add(sequenceIDFields.primaryTerm);
        MappedFieldType resellerIdField = new NumberFieldMapper.NumberFieldType("reseller_id", NumberFieldMapper.NumberType.LONG);
        }, resellersMappedFields());
                }  
                iw.commit();  
                } else {
                termsBuilder.subAggregation(nestedBuilder);
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("3"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);
                    Document document = new Document();
                    new MatchAllDocsQuery(),
                LongTerms resellers = nested.getAggregations().get("resellers");
                assertThat(nested.getDocCount(), equalTo((long) numResellers));  
                documents.add(document);
                    LongTerms.Bucket bucket = innerTerms.getBuckets().get(i);
                document.add(sequenceIDFields.primaryTerm);  
                assertEquals(3, res.v1().intValue());
 * You may obtain a copy of the License at  
        try (Directory directory = newDirectory()) {
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("2"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                List<Document> documents = new ArrayList<>();
                );
                    true,
                keyBuilder.subAggregation(valueBuilder);
    private static final String NESTED_OBJECT = "nested_object";  
                    documents.add(document);
import org.apache.lucene.document.LongPoint;  
    public void testNoDocs() throws IOException {  
     * Nested aggregations need the {@linkplain DirectoryReader} wrapped.
    private static final String OUT_NESTED = "outNested";  
                    outNestedBuilder,  
                    assertEquals(book.v2()[0], (int) numPages.getValue());
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                InternalNested nested = bucket.getAggregations().get("nested");
            Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings.getSettings(), new ContentPath());
import org.opensearch.search.aggregations.metrics.Min;
import static java.util.stream.Collectors.toList;
                    NESTED_OBJECT2 + "." + VALUE_FIELD_NAME2  
                bucket = terms.getBuckets().get(5);
import org.apache.lucene.index.IndexReader;
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
        }
                res = getParentAndChildId(parentDocs, childDocs, 5);
                    nestedBuilder,
                    .size(books.size())
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;  
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder("chapters", "nested_chapters");
                    Document document = new Document();
                }  
                outTermsAggregator.subAggregation(innerNestedBuilder);  
            .subAggregation(  
                documents.add(document);
                assertThat(bucket.getDocCount(), equalTo(1L));
     * are properly reduced  
                document = new Document();  
        };  
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(  
                );
                    new MatchAllDocsQuery(),
                    indexSettings,  
    /**
            parentDocs.set(0);
    }
        }
                    DEFAULT_MAX_BUCKETS,  
                    document.add(sequenceIDFields.primaryTerm);
        document.add(new SortedNumericDocValuesField(path + "." + fieldName, vales));
            document.add(new SortedNumericDocValuesField("num_pages", numPage));
                assertEquals(NESTED_AGG, nested.getName());
import org.opensearch.index.mapper.SeqNoFieldMapper;  
            }
                    fieldType
                MappedFieldType fieldType2 = new KeywordFieldMapper.KeywordFieldType("author");
                nestedBuilder.subAggregation(maxAgg);
                assertEquals(expectedNestedDocs, nested.getDocCount());
                DocIdSetIterator childDocs = getDocIdSetIterator(new int[] { 2, 4, 8 });  
    }
import org.apache.lucene.store.Directory;
            // p: parent c: child
                document = new Document();
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {  
                    expectedNestedDocs += numNestedDocs;
        double expectedMaxValue = Double.NEGATIVE_INFINITY;
            aggTestThreadPool = new TestThreadPool("nested_agg_test");
            }
                    NumberFieldMapper.NumberType.LONG
                assertEquals("b1", valueAgg.getBuckets().get(0).getKey());  
                        generateMaxDocs(documents, numNestedDocs, i, NESTED_OBJECT, VALUE_FIELD_NAME)
                assertEquals(expectedNestedDocs, nested.getDocCount());  
                        expectedMaxValue,
                for (Tuple<String, int[]> book : books) {
            return new ObjectMapper.Builder<>(fieldName).nested(ObjectMapper.Nested.newNested()).build(context);
        }
    public void testDoubleNestingMax() throws IOException {  
        int numRootDocs = randomIntBetween(1, 20);
            LongTerms products = (LongTerms) result;  
                InternalNested nested = searchAndReduce(
                assertEquals(18, (int) numPages.getValue());
                NestedAggregationBuilder outNestedBuilder = new NestedAggregationBuilder(OUT_NESTED, NESTED_OBJECT);  
import org.opensearch.index.query.support.NestedScope;  
                for (int i = 0; i < numRootDocs; i++) {
                }
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
            assertEquals(8, res.v1().intValue());
                    fieldType
                    List<Document> documents = new ArrayList<>();  
            documents.add(document);  
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
                return NO_MORE_DOCS;
                    .field("author")
        BitSetProducer nonNestedFilter = bitsetFilterCache.getBitSetProducer(Queries.newNonNestedFilter());  
                res = getParentAndChildId(parentDocs, childDocs, 7);  
    private static final String NESTED_OBJECT2 = "nested_object2";
                    DEFAULT_MAX_BUCKETS,
                    new TermsAggregationBuilder("terms").field(VALUE_FIELD_NAME)
            }
            }
    private static final String INNER_TERMS = "innerTerms";  
                assertEquals("b3", valueAgg.getBuckets().get(2).getKey());
                assertEquals(3, valueAgg.getBuckets().size());
                MinAggregationBuilder minAgg = new MinAggregationBuilder("num_pages").field("num_pages");
                new NestedAggregationBuilder("nested", "nested_reseller").subAggregation(
                document.add(new SortedDocValuesField("key", new BytesRef("key2")));
                                new Script(ScriptType.INLINE, MockScriptEngine.NAME, INVERSE_SCRIPT, Collections.emptyMap())  
                document.add(new SortedDocValuesField("value", new BytesRef("b2")));
                assertEquals("d", bucket.getKeyAsString());
/*
                documents.add(document);
                iw.commit();
 */  
                    DEFAULT_MAX_BUCKETS,  
                        .subAggregation(new MaxAggregationBuilder(MAX_AGG_NAME).field(VALUE_FIELD_NAME))
        int numProducts = scaledRandomIntBetween(1, 100);
                assertEquals("b", bucket.getKeyAsString());
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;  
            public int nextDoc() {
                for (int i = target; i < bits.length; i++) {  
    public void testFieldAlias() throws IOException {
                documents.add(document);
                iw.commit();
                    List<Document> documents = new ArrayList<>();  
                nestedBuilder.subAggregation(keyBuilder);
            document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));  
import static org.hamcrest.Matchers.equalTo;
                for (int r = 0; r < documents.size(); r++) {
                TermsQueryBuilder termsQueryBuilder = new TermsQueryBuilder(NESTED_OBJECT2 + "." + VALUE_FIELD_NAME2, (Object[]) values);
                    document.add(sequenceIDFields.primaryTerm);
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {  
                assertEquals(3, (int) numPages.getValue());
                    Terms.Bucket bucket = terms.getBuckets().get(i);
        }
                }
            }  
                for (int i = 0; i < expectedNestedDocs; i++) {  
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {  
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                }
                TermsAggregationBuilder outTermsAggregator = new TermsAggregationBuilder(OUT_TERMS).field(
        BitsetFilterCache bitsetFilterCache = new BitsetFilterCache(
    }  
        when(queryShardContext.getSearchAnalyzer(any())).thenCallRealMethod();
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                    fieldType
                );
                terms = searchAndReduce(
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
import org.opensearch.search.aggregations.pipeline.BucketScriptPipelineAggregationBuilder;
                documents.add(document);  
                    assertEquals(1, bucket.getDocCount());  
                // The bug manifests if 6 docs are returned, because currentRootDoc isn't reset the previous child docs from the first
import org.opensearch.index.mapper.IdFieldMapper;
                document.add(new SortedDocValuesField("value", new BytesRef("b3")));
                    fieldType1,
                    .field("author")
            values[nested] = value;
 * SPDX-License-Identifier: Apache-2.0
        return values;
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
                assertEquals(11, res.v1().intValue());
                int id = 0;  
                );
        when(queryShardContext.nestedScope()).thenReturn(new NestedScope(indexSettings));
     * This tests to make sure pipeline aggs embedded under a SingleBucket agg (like nested)
    protected ScriptService getMockScriptService() {  
                return index;
        int expectedNestedDocs;  
                Arrays.sort(book.v2());
        MappedFieldType productIdField = new NumberFieldMapper.NumberFieldType("product_id", NumberFieldMapper.NumberType.LONG);
        IndexWriterConfig iwc = new IndexWriterConfig(null);  
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
                documents.clear();
                iw.addDocuments(generateBook("4", new String[] { "d" }, new int[] { 2, 1, 3 }));
                );
                    NESTED_OBJECT + "." + VALUE_FIELD_NAME
        documents.add(document);  
                }
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                document = new Document();
        document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(id)), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));  
import org.opensearch.index.query.TermsQueryBuilder;
        }  
                    iw.addDocuments(generateBook(String.format(Locale.ROOT, "%03d", id), new String[] { book.v1() }, book.v2()));
                bucket = terms.getBuckets().get(4);
    private static double[] generateDocuments(List<Document> documents, int numNestedDocs, int id, String path, String fieldName) {
                assertEquals(NO_MORE_DOCS, res.v2().intValue());  
        };
                assertEquals("key1", key1.getKey());
import org.apache.lucene.util.BitSet;
                InternalNested nested = filter.getAggregations().get(NESTED_AGG);
        int numRootDocs = randomIntBetween(1, 20);
                    Document document = new Document();  
                document.add(new SortedDocValuesField("key", new BytesRef("key2")));
                index = bits.length;  
                nestedBuilder.subAggregation(maxAgg);  
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(p)), IdFieldMapper.Defaults.FIELD_TYPE));
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");  
            long value = randomNonNegativeLong() % 10000;
                assertEquals(0, nested.getDocCount());
                iw.addDocuments(documents);
                InternalNested nested = searchAndReduce(  
                for (int i = 0; i < numRootDocs / 2; i++) {
        try (Directory directory = newDirectory()) {  
                assertEquals(18, (int) numPages.getValue());  
                document.add(new SortedDocValuesField("value", new BytesRef("a1")));  
    public void testResetRootDocId() throws Exception {
        return wrapInMockESDirectoryReader(reader);
            for (int p = 0; p < numProducts; p++) {
                }
                assertEquals(expectedMaxValue, max.getValue(), Double.MIN_VALUE);  
import org.opensearch.index.mapper.ObjectMapper;
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                document = new Document();
                    termsBuilder,
                assertEquals(2, res.v2().intValue());  
        }  
        {  
                bucketKeys = new String[expectedNestedDocs];
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);  
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
    }  
            assertEquals(3, res.v1().intValue());
                    nestedBuilder,
                    fieldType2
                    new ConstantScoreQuery(bq.build()),
                LongTerms innerTerms = (LongTerms) internalNested.getProperty(INNER_TERMS);
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT).subAggregation(
import org.apache.lucene.index.NoMergePolicy;
                    expectedNestedDocs += numNestedDocs;  
                Tuple<Integer, Integer> res = getParentAndChildId(parentDocs, childDocs, 1);
                            new BucketScriptPipelineAggregationBuilder(  
            Mockito.mock(BitsetFilterCache.Listener.class)
                    List<Document> documents = new ArrayList<>();
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, iwc)) {
                                "bucketscript",
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                        return index;  
                assertEquals(1, res.v2().intValue());  
                    createIndexSettings(),
                assertEquals(expectedNestedDocs, nested.getDocCount());
                    true,  
                List<Document> documents = new ArrayList<>();
                    iw.addDocuments(documents);  
import java.util.Map;  
/*  
            parentDocs.set(7);
                    fieldType1,
                InternalMax max = (InternalMax) nested.getProperty(MAX_AGG_NAME);
        }  
                iw.commit();
    }
            }  
                Document document = new Document();
                    createIndexSettings(),
                iw.addDocuments(generateBook("6", new String[] { "e" }, new int[] { 23, 21 }));
                assertEquals(39, (int) numPages.getValue());
                    int numNestedDocs = randomIntBetween(0, 20);
                assertEquals(bucketKeys.length, innerTerms.getBuckets().size());
                for (int i = index; i < bits.length; i++) {  
            }
            assertThat(
                assertEquals(expectedSum, sum.getValue(), Double.MIN_VALUE);  
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
                maxAgg = new MaxAggregationBuilder("num_pages").field("num_pages");  
        }
                iw.commit();
        try (Directory directory = newDirectory()) {  
                }
                    List<Document> documents = new ArrayList<>();  
                    newSearcher(indexReader, false, true),
            document.add(new SortedNumericDocValuesField(path + "." + fieldName, value));  
                // query  
                MappedFieldType fieldType2 = new KeywordFieldMapper.KeywordFieldType("value");  
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("3"), IdFieldMapper.Defaults.FIELD_TYPE));
                document = new Document();  
            }
        when(queryShardContext.getSearchQuoteAnalyzer(any())).thenCallRealMethod();  
                );
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {  
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("2"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                document.add(sequenceIDFields.primaryTerm);  
    public void testNestedUnderTerms() throws IOException {  
import java.util.function.Function;
        for (int nested = 0; nested < numNestedDocs; nested++) {
import static org.opensearch.search.aggregations.bucket.nested.NestedAggregator.getParentAndChildId;
    private static final String VALUE_FIELD_NAME2 = "number2";
                documents.add(document);  
                );
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;  
import org.opensearch.common.lucene.search.Queries;  
                valueAgg = key2.getAggregations().get("value");
                generateSumDocs(documents, numOrphanedDocs, 1234, "foo", VALUE_FIELD_NAME);
    public void testPreGetChildLeafCollectors() throws IOException {
                assertEquals("a", bucket.getKeyAsString());  
                assertEquals("filterAgg", filter.getName());
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder(MAX_AGG_NAME).field(VALUE_FIELD_NAME);
     */  
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                Terms terms = searchAndReduce(  
                    Document document = new Document();
    private double generateSumDocs(List<Document> documents, int numNestedDocs, int id, String path, String fieldName) {
    public static CheckedConsumer<RandomIndexWriter, IOException> buildResellerData(int numProducts, int numResellers) {
                assertEquals(9, res.v1().intValue());
                document.add(new SortedDocValuesField("key", new BytesRef("key1")));
import org.opensearch.index.IndexSettings;
                Terms.Bucket key2 = keyAgg.getBuckets().get(1);
                assertEquals(4, res.v2().intValue());
                    new MatchAllDocsQuery(),
            Document document = new Document();
        Document document = new Document();  
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
                    newSearcher(indexReader, false, true),  
                assertEquals(NESTED_AGG, nested.getName());
                MappedFieldType fieldType2 = new KeywordFieldMapper.KeywordFieldType("author");
                if (index == -1 || index > bits.length || bits[index] != 1) {
                );
import org.apache.lucene.index.DirectoryReader;
                    NESTED_OBJECT2 + "." + VALUE_FIELD_NAME2,
                StringTerms valueAgg = key1.getAggregations().get("value");
                assertEquals(expectedNestedDocs, nested.getDocCount());
                    return cmp;
        try (Directory directory = newDirectory()) {
                TermsAggregationBuilder keyBuilder = new TermsAggregationBuilder("key").userValueTypeHint(ValueType.STRING).field("key");
    public void testOrphanedDocs() throws IOException {
import org.opensearch.search.aggregations.bucket.terms.LongTerms;  
    }
                nestedBuilder = new NestedAggregationBuilder("chapters", "nested_chapters");
                NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder(NESTED_OBJECT2, termsQueryBuilder, ScoreMode.None);  
                assertEquals(50, (int) numPages.getValue());
                documents.clear();  
            }
                    return -1;
                    .field("value");  
                    iw.addDocuments(documents);
            parentDocs.set(0);  
                assertEquals(NESTED_AGG, nested.getName());
                documents.add(document);  
            }  
import java.util.stream.DoubleStream;  
                assertEquals("a2", valueAgg.getBuckets().get(1).getKey());
            for (int j = 0; j < numChapters; j++) {
        return new DocIdSetIterator() {
import org.opensearch.script.Script;  
                InternalSum sum = (InternalSum) ((InternalAggregation) nested).getProperty(SUM_AGG_NAME);
 *  
        if (aggTestThreadPool == null) {  
                    documents.add(document);  
                    fieldType2
    }
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));  
                    iw.addDocuments(documents);
                documents.add(document);  
                    DEFAULT_MAX_BUCKETS,
                    resellers.getBuckets().stream().map(LongTerms.Bucket::getKeyAsNumber).collect(toList()),  
            parentDocs.set(6);
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);  
                );
                    assertTrue(AggregationInspectionHelper.hasValue(nested));
                document = new Document();
                iw.addDocuments(documents);
     */
        try (Directory directory = newDirectory()) {
                    Document document = new Document();
                    createIndexSettings(),
                assertEquals(NESTED_AGG, nested.getName());  
            books.add(Tuple.tuple(String.format(Locale.ROOT, "%03d", i), chapters));
            BitSet parentDocs = new FixedBitSet(20);  
                    );  
                assertEquals(70, (int) numPages.getValue());  
                    assertEquals(bucketKeys[i], bucket.getKeyAsString());
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                iw.addDocuments(generateBook("5", new String[] { "a" }, new int[] { 70, 10 }));  
                    true,  
            assertEquals(4, res.v2().intValue());
        List<Tuple<String, int[]>> books = new ArrayList<>();
            }
                assertEquals(MAX_AGG_NAME, max.getName());  
                iw.addDocuments(documents);
        return iw -> {  
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);  
                    assertEquals(book.v1(), bucket.getKeyAsString());
                assertEquals(14, (int) numPages.getValue());
                bucket = terms.getBuckets().get(3);
                iw.addDocuments(generateBook("7", new String[] { "e", "a" }, new int[] { 8, 8 }));
                assertEquals("f", bucket.getKeyAsString());
                documents.clear();  
                    true,
        int expectedNestedDocs = 0;
                    assertEquals(max.getValue(), -bucketScript.getValue(), Double.MIN_VALUE);
    }
                    Document document = new Document();  
        }  
        try (Directory directory = newDirectory()) {  
                }
                    expectedSum += generateSumDocs(documents, numNestedDocs, i, NESTED_OBJECT, VALUE_FIELD_NAME);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                BytesRef[] values = new BytesRef[numRootDocs / 2];  
                    fieldType
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");  
    }  
    }  
                    if (bits[i] == 1) {
                    generateDocuments(documents, numNestedDocs, i, NESTED_OBJECT, VALUE_FIELD_NAME);
                document.add(sequenceIDFields.primaryTerm);
                List<Document> documents = new ArrayList<>();
                // intentionally not writing any docs  
                assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), Double.MIN_VALUE);
                }
        return DoubleStream.of(generateDocuments(documents, numNestedDocs, id, path, fieldName)).max().orElse(Double.NEGATIVE_INFINITY);
                BooleanQuery.Builder bq = new BooleanQuery.Builder();
import org.opensearch.search.aggregations.metrics.InternalMax;
     * For each provided field type, we also register an alias with name {@code <field>-alias}.
                );  
            }  
                generateDocuments(documents, numResellers, p, "nested_reseller", "value");  
            books.sort((o1, o2) -> {  
                assertEquals(expectedMaxValue, max.getValue(), Double.MIN_VALUE);
                        expectedMaxValue,  
                document.add(new SortedDocValuesField("value", new BytesRef("a2")));
            parentDocs.set(3);
 * ownership. Elasticsearch licenses this file to you under  
                    filterAggregationBuilder,
                NestedAggregationBuilder innerNestedBuilder = new NestedAggregationBuilder(INNER_NESTED, NESTED_OBJECT2);
            int index = -1;  
import org.opensearch.script.ScriptModule;
import org.apache.lucene.util.BytesRef;
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("3"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                    termsBuilder,  
                assertEquals(8, res.v2().intValue());
import org.opensearch.index.mapper.Mapper;
        }
    /**
                document.add(sequenceIDFields.primaryTerm);
import org.opensearch.script.ScriptEngine;
                documents.add(document);
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));  
                    new MatchAllDocsQuery(),  
                    document.add(sequenceIDFields.primaryTerm);
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                    newSearcher(indexReader, false, true),
                    expectedMaxValue = Math.max(
                document = new Document();  
 * the Apache License, Version 2.0 (the "License"); you may
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
 * license agreements. See the NOTICE file distributed with
        }
                    new TermsAggregationBuilder("resellers").field("reseller_id").size(numResellers)
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));  
                documents.add(document);
import org.apache.lucene.search.join.BitSetProducer;  
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                products.getBuckets().stream().map(LongTerms.Bucket::getKeyAsNumber).collect(toList()),
 */  
                bq.add(new TermQuery(new Term(IdFieldMapper.NAME, Uid.encodeId("2"))), BooleanClause.Occur.MUST_NOT);
    @Override
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                if (expectedNestedDocs > 0) {
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");  
            parentDocs.set(8);  
            @Override
                    assertNotNull(max);
                Filter filter = searchAndReduce(
        document.add(sequenceIDFields.primaryTerm);
                    fieldType
                }
                iw.addDocuments(generateBook("3", new String[] { "c" }, new int[] { 39, 19 }));
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
                assertEquals(14, (int) numPages.getValue());
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("2"), IdFieldMapper.Defaults.FIELD_TYPE));
                assertEquals(7, terms.getBuckets().size());  
import org.opensearch.index.cache.bitset.BitsetFilterCache;  
                return NO_MORE_DOCS;
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);  
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
            // p: parent c: child1 d: child2  
                );
                iw.addDocuments(generateBook("1", new String[] { "a" }, new int[] { 12, 13, 14 }));
                );
                    }
                assertEquals("a", bucket.getKeyAsString());
import org.apache.lucene.document.SortedNumericDocValuesField;
                for (int i = 0; i < numRootDocs; i++) {
                    Queries.newNonNestedFilter(),
import java.util.Arrays;
import org.opensearch.common.CheckedConsumer;
                iw.addDocuments(documents);  
                assertEquals(SUM_AGG_NAME, sum.getName());
import org.opensearch.script.ScriptService;  
                    fieldType1,  
        }
import org.apache.lucene.search.ConstantScoreQuery;
                Nested aliasNested = searchAndReduce(  
                int numOrphanedDocs = randomIntBetween(0, 20);
        int numRootDocs = randomIntBetween(1, 20);  
                    document.add(sequenceIDFields.primaryTerm);  
                    documents.add(document);
                assertTrue(AggregationInspectionHelper.hasValue(nested));  
 * Modifications Copyright OpenSearch Contributors. See
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, scripts, Collections.emptyMap());  
                    documents.add(document);
            for (int p = 0; p < numProducts; p++) {
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;
                    expectedMaxValue = Math.max(expectedMaxValue, generateMaxDocs(documents, 1, i, NESTED_OBJECT, VALUE_FIELD_NAME));
    }  
            indexSettings,
                    NumberFieldMapper.NumberType.LONG  
        when(queryShardContext.getIndexSettings()).thenReturn(indexSettings);
                assertEquals(5, res.v2().intValue());
                    if (bits[i] == 1) {
                assertEquals(7, terms.getBuckets().size());
                assertEquals("authors", terms.getName());  
    protected IndexReader wrapDirectoryReader(DirectoryReader reader) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    iw.addDocuments(documents);  
                assertEquals(NESTED_AGG, nested.getName());
import org.apache.lucene.search.BooleanClause;  
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
 * KIND, either express or implied.  See the License for the
            assertEquals(2, res.v2().intValue());  
        try (Directory directory = newDirectory()) {  
import org.opensearch.indices.IndicesBitsetFilterCache;
    }
                for (int i = 0; i < numRootDocs; i++) {  
                documents.add(document);
                res = getParentAndChildId(parentDocs, childDocs, 10);
                assertEquals(3, (int) numPages.getValue());  
        int expectedNestedDocs = 0;
            assertEquals(6, res.v1().intValue());  
                // 1 segment with, 1 root document, with 3 nested sub docs
                // 1 document, with 1 nested subdoc
                    expectedNestedDocs += 1;
                document.add(sequenceIDFields.primaryTerm);
import org.opensearch.script.MockScriptEngine;
                documents.clear();
                    nestedBuilder,
                    nestedQueryBuilder.toQuery(queryShardContext),
                for (int i = 0; i < numRootDocs; i++) {
            });
                    fieldType
                    assertNotNull(bucketScript);  
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));  
                    new MatchAllDocsQuery(),
                iw.addDocuments(documents);
                assertEquals(23, (int) numPages.getValue());
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                MappedFieldType fieldType1 = new NumberFieldMapper.NumberFieldType(
    }  
            }
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {  
        when(queryShardContext.fieldMapper(anyString())).thenReturn(fieldType);
                assertEquals(1, outTerms.getBuckets().size());
                assertEquals(23, (int) numPages.getValue());  
import org.opensearch.index.mapper.MappedFieldType;
                    DEFAULT_MAX_BUCKETS,
                InternalNested nested = searchAndReduce(
            assertEquals(NO_MORE_DOCS, res.v2().intValue());
                document.add(new SortedDocValuesField("value", new BytesRef("b1")));  
                );
                } else {
import org.opensearch.search.aggregations.AggregationBuilder;
                Terms.Bucket bucket = terms.getBuckets().get(0);
import org.opensearch.index.mapper.NestedPathFieldMapper;  
public class NestedAggregatorTests extends AggregatorTestCase {
                    documents.add(document);
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder(MAX_AGG_NAME).field(NESTED_OBJECT + "." + VALUE_FIELD_NAME);  
                    int numNestedDocs = randomIntBetween(0, 20);
                // out nested aggs
            public int advance(int target) {
 * GitHub history for details.
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("2"), IdFieldMapper.Defaults.FIELD_TYPE));
 *
                termsBuilder.subAggregation(nestedBuilder);
import java.util.List;
                MappedFieldType fieldType1 = new KeywordFieldMapper.KeywordFieldType("key");
import org.apache.lucene.index.Term;
                nestedBuilder.subAggregation(maxAgg);
                        return index;  
        Document document = new Document();
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");  
            parentDocs.set(3);  
                assertEquals(70, (int) numPages.getValue());
    private static final String SUM_AGG_NAME = "sumAgg";
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));  
                    return o1.v1().compareTo(o2.v1());  
    }
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder("chapters", "nested_chapters");
        for (int numPage : numPages) {
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder(MAX_AGG_NAME).field(NESTED_OBJECT + "." + VALUE_FIELD_NAME);
                SumAggregationBuilder sumAgg = new SumAggregationBuilder(SUM_AGG_NAME).field(NESTED_OBJECT + "." + VALUE_FIELD_NAME);
 * specific language governing permissions and limitations
                document = new Document();  
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
        return queryShardContext;
                    Min numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");  
                Terms terms = searchAndReduce(  
                documents.add(document);  
                equalTo(LongStream.range(0, numProducts).mapToObj(Long::valueOf).collect(toList()))  
import org.mockito.Mockito;  
