            BytesRef b2 = new BytesRef(InetAddressPoint.encode(o2));  
    @Override
    private void collectDocuments(IndexSearcher searcher, GlobalOrdinalsStringTermsAggregator aggregator) throws IOException {
                document.add(new SortedDocValuesField("field2", new BytesRef("b")));
import org.opensearch.index.mapper.MappedFieldType;  
                    assertEquals(1L, result.getBuckets().get(4).getDocCount());  
                        KeywordFieldMapper.KeywordFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("mv_field1");
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
        };
import org.opensearch.script.ScriptEngine;
                            .field(fieldNames[i]);  
            }  
    public void testIpField() throws Exception {
                            new TermsAggregationBuilder("j").field("j")
import org.apache.lucene.document.SortedNumericDocValuesField;
                indexWriter.addDocument(document);  
                    indexWriter.addDocument(document);  
                }
            comparator,
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
            }
                indexWriter.addDocument(document);  
        int size  
                    Object[] missingValues = new Object[] { "abc", 19L, 19.2 };  
                        .executionHint(executionHint)
            InternalTopHits topHits = bucket.getAggregations().get("top_hits");  
        } finally {  
}
                        IndexSearcher indexSearcher = newIndexSearcher(indexReader);
    }
                        assertEquals(2L, result.getBuckets().get(0).getDocCount());
                    aggregator.preCollection();
        return createAggregator(aggregationBuilder, indexSearcher, true, fieldTypes);
        int numTerms = scaledRandomIntBetween(8, 128);  
        try (Directory directory = newDirectory()) {  
import org.apache.lucene.store.Directory;
                    } else {
                        .includeExclude(new IncludeExclude(null, "val00.+"))
                                );  
                    assertEquals("a", result.getBuckets().get(1).getKeyAsString());  
        indexWriter.addDocument(document);
        try (Directory directory = newDirectory()) {
                    }
        document.add(new SortedNumericDocValuesField("number", 100));
                        assertEquals(2L, result.getBuckets().get(0).getDocCount());
                        .includeExclude(new IncludeExclude(null, new long[] { 0, 5 }))
                        assertEquals(11L, result.getBuckets().get(0).getDocCount());
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
    }  
            }  
                                    fieldType
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
                documents.add(document);
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("nick").userValueTypeHint(ValueType.STRING)
                }
                    }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
        );
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        try (Directory directory = newDirectory()) {
        Document document = new Document();  
                    Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);  
                    assertEquals("val001", result.getBuckets().get(0).getKeyAsString());  
 * GitHub history for details.
    }  
        }
    }
            searchContext -> when(searchContext.bucketSelectionStrategyFactor()).thenReturn(5),
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                                    .order(BucketOrder.key(true))
        try (Directory directory = newDirectory()) {
                            Document d = new Document();  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
                        );
                        int expectedFilteredCounts = 0;
        // Fields indexed, deleted documents in segment: cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "d");
                        assertEquals("name1", result.getBuckets().get(1).getKeyAsString());
                    assertEquals(5, result.getBuckets().size());
            document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
import java.util.function.Consumer;  
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, false, true, false, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);  
                    aggregator.preCollection();  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
import org.opensearch.search.aggregations.AggregationBuilders;
import org.opensearch.index.mapper.TextFieldMapper;
        ValueType valueType,
                        .field("field")
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();
                    nestedBucket = ((Terms) result.getBuckets().get(2).getAggregations().get("_name2")).getBuckets().get(0);
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val002")));
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                                    newSearcher(indexReader, false, true),  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    aggs.add(buildInternalAggregation(aggregationBuilder, fieldType, searcher));  
        termsAggregatorWithNestedMaxAgg(ValueType.LONG, fieldType, Integer::longValue, val -> new NumericDocValuesField("field", val));
                document = new Document();  
        return result;
                    dir = ((DirectoryReader) reader).directory();  
            Collections.emptyMap()
                                )
                    assertEquals("val003", result.getBuckets().get(1).getKeyAsString());
                    assertEquals(1L, result.getBuckets().get(6).getDocCount());
                MappedFieldType stringFieldType = new KeywordFieldMapper.KeywordFieldType("string");
                    indexWriter.addDocument(document);
                documents.add(document);
                        MappedFieldType filterFieldType = new KeywordFieldMapper.KeywordFieldType("include");  
                    aggregator.postCollection();  
        try (Directory directory = newDirectory()) {  
                    aggregator.preCollection();
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                        .includeExclude(new IncludeExclude(new double[] { 0.0, 5.0 }, null))
                    assertEquals(size, result.getBuckets().size());
import org.apache.lucene.search.FieldExistsQuery;
                List<Document> documents = new ArrayList<>();  
    }
    }
        assertThat(globalAgg.collectMode, equalTo(Aggregator.SubAggCollectionMode.DEPTH_FIRST));
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, false, false, true, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 0);  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    result = reduce(aggregator);
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
                }  
import org.apache.lucene.index.Term;  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
                    boolean order = randomBoolean();  
                    assertEquals(1L, result.getBuckets().get(5).getDocCount());
                TermsAggregatorFactory.REMAP_GLOBAL_ORDS = randomBoolean();  
import org.opensearch.index.mapper.IdFieldMapper;  
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
        doAssertReducedMultiBucketConsumer(result, reduceBucketConsumer);
        }  
                document.add(new NumericDocValuesField("long_field", 1));  
                    assertEquals(10, result.getBuckets().size());  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
     */  
        return List.of(HllFieldMapper.CONTENT_TYPE);
        };
    }
                    assertEquals(2L, result.getBuckets().get(2).getDocCount());  
                    aggregator.preCollection();
                            if (valueType == ValueType.IP) {
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, STRING_SCRIPT_NAME, Collections.emptyMap()));
                    aggregator.postCollection();
                return new NumericDocValuesField("field", Double.doubleToRawLongBits(val));  
    }  
    public void testNumericIncludeExclude() throws Exception {
                    assertEquals("val010", result.getBuckets().get(1).getKeyAsString());  
                        collectionMode  
        }  
                    aggregator.preCollection();
        indexWriter.addDocument(document);
                                    filter,  
    public void testUnmapped() throws Exception {  
                    Terms result = reduce(aggregator);
import org.opensearch.core.common.breaker.CircuitBreaker;  
                    assertEquals("192.168.100.42", result.getBuckets().get(0).getKey());
                return new SortedSetDocValuesField("field", new BytesRef(val));  
                            Document document = new Document();
    @Override  
                    assertEquals(0, result.getBuckets().size());  
                final Directory dir;
                    aggregator.preCollection();
        document = new Document();  
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                        .executionHint(executionHint)  
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());  
        }  
                        )
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                                .size(numTerms)
        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));  
                        .order(BucketOrder.key(true));
                document = new Document();
                        for (Integer count : filteredCounts.values()) {  
        try (Directory directory = newDirectory()) {  
                        assertEquals(1L, result.getBuckets().get(1).getDocCount());  
        indexWriter.close();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                            {
                        .subAggregation(
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(valueTypes[i])  
                        .executionHint(TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS.toString())  
    public void testDoubleTermsAggregator() throws Exception {
                // Case 2: QuickSelect selection, when buckets > size && buckets > 5*size (size=20, buckets=100)
                assertEquals(expected, buckets.get(0).getDocCount());
            scripts,  
                                new TermsAggregationBuilder("sub_terms").userValueTypeHint(ValueType.STRING)  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    assertEquals(2L, result.getBuckets().get(1).getDocCount());  
 * Licensed to Elasticsearch under one or more contributor  
                            new TermsAggregationBuilder("_name2").userValueTypeHint(valueType)  
        aggregator = createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldType);  
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
import org.apache.lucene.util.NumericUtils;
        try (Directory directory = newDirectory()) {
        // Fields indexed, no deleted documents, but _doc_field value present in document:
                            .field(fieldNames[i])
import org.apache.lucene.search.TotalHits;
import org.apache.lucene.util.BytesRef;
                    assertEquals(1L, result.getBuckets().get(5).getDocCount());  
        };
            ValueType.DOUBLE,  
                            d.add(new SortedNumericDocValuesField("i", i));
            ADD_SORTED_SET_FIELD_INDEXED,  
                addFieldConsumer.apply(document, "string", "d");
                        LongTerms.Bucket iBucket = result.getBucketByKey(Integer.toString(i));
                    logger.info(
                    documents.add(document);
    private IndexReader createIndexWithDoubles() throws IOException {  
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val011")));
                            )
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType2);  
                        bucketOrder = BucketOrder.compound(BucketOrder.count(order), BucketOrder.key(order));
    private void assertNestedTopHitsScore(InternalMultiBucketAggregation<?, ?> terms, boolean withScore) {
                    assertEquals(4, result.getBuckets().size());  
    }
                }
                Document document = new Document();
                                document.add(luceneFieldFactory.apply(entry2.getKey(), true));
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
                    }
                }
        aggregator = createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldType);  
                        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                        comparator = comparator.thenComparing(Comparator.comparing(Map.Entry::getKey, keyComparator));  
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
        for (int nestedValue : nestedValues) {  
import org.opensearch.search.aggregations.AggregationBuilder;
                    for (int i = 0; i < fieldNames.length; i++) {
                    aggregator.postCollection();
        int numTerms = scaledRandomIntBetween(8, 128);
                    );
 * the Apache License, Version 2.0 (the "License"); you may
                    );
        // cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited  
    }  
                    assertEquals("a", result.getBuckets().get(1).getKeyAsString());
            TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.LONG)
            aggregationBuilder,
                            assertEquals(String.valueOf(expected.getKey()).substring(1), actual.getKey());
                indexWriter.addDocument(document);
    }
                        .executionHint(executionHint)
                        .order(BucketOrder.key(true));
        for (int i = 0; i < numTerms; i++) {
                                .executionHint(executionHint)
                        assertEquals(1L, result.getBuckets().get(2).getDocCount());
        testSimple(
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    ) throws Exception {  
            }
                        keywordField("k")  
                    indexWriter.addDocument(document);
                document.add(new SortedDocValuesField("field1", new BytesRef("e")));
import java.util.Map;  
                    TermsAggregatorFactory.REMAP_GLOBAL_ORDS = false;
                    // With threshold=0, tryCollectFromTermFrequencies should bail out,
                document = new Document();  
                document.add(field);
    public void testMixLongAndDouble() throws Exception {
    }
 * Modifications Copyright OpenSearch Contributors. See  
                    directory,
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());  
            GeoPoint point = RandomGeoGenerator.randomPoint(random());  
                    indexWriter.addDocuments(generateDocsWithNested(Integer.toString(i), i, nestedValues));
    private List<Document> generateDocsWithNested(String id, int value, int[] nestedValues) {  
                            document.add(luceneFieldFactory.apply(entry1.getKey(), true));  
                    aggregator.preCollection();
            assertThat(topHits.getHits().getTotalHits().value(), equalTo((long) ptr));
    @Override
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("string");  
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.LONG)
                        ).field("mv_field1").missing("no_nickname1");  
    private static final String STRING_SCRIPT_NAME = "string_script";
                    assertEquals(2, result.getBuckets().size());
                documents.add(document);
        indexWriter.addDocument(document);
        document.add(new SortedNumericDocValuesField("number", 1000));  
                        keywordField("i"),
    ) throws IOException {
                        }
                            createIndexSettings(),  
                    InternalMultiBucketAggregation<?, ?> terms = result.getAggregations().get("terms");  
                    }  
    public void testGlobalAggregationWithScore() throws IOException {
                    assertEquals("d", result.getBuckets().get(4).getKeyAsString());
                    document = new Document();
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));  
        aggregator = createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldType);
                indexWriter.addDocument(document);
                    assertEquals("val004", result.getBuckets().get(4).getKeyAsString());  
                        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                        }  
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
        aggregationBuilder.order(BucketOrder.aggregation("card", true));
                }
                    indexWriter.addDocuments(documents);  
        when(mapper.type()).thenReturn("_doc");
                indexWriter.addDocument(document);
            return super.createAggregator(aggregationBuilder, indexSearcher, fieldTypes);
        globalAgg = (GlobalOrdinalsStringTermsAggregator) aggregator;
            reduceBucketConsumer,
        boolean randomizeAggregatorImpl,  
import org.opensearch.index.mapper.GeoPointFieldMapper;
        return new CountingAggregator(  
                        .size(size)
        document.add(new SortedNumericDocValuesField("number", 100));
                    indexWriter.deleteDocuments(new Term("string", "e"));  
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(100.0d)));
    }
        return aggregator.buildTopLevel();
                        longField("j"),
        // We do not use LuceneTestCase.newSearcher because we need a DirectoryReader
                    Aggregator.SubAggCollectionMode collectionMode = randomFrom(Aggregator.SubAggCollectionMode.values());
        for (LeafReaderContext ctx : searcher.getIndexReader().leaves()) {
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "c");
            } else {
                indexWriter.addDocument(document);  
                    assertEquals(3.0, result.getBuckets().get(2).getKey());
    public void testBucketInTermsAggregationWithMissingValue() throws IOException {
            }  
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
import static java.util.Arrays.asList;  
        DocumentMapper mapper = mock(DocumentMapper.class);
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                        for (int j = 0; j < 10; j++) {
        indexReader.close();
        AggregationBuilder aggregationBuilder,
            }
                    for (int i = 0; i < 10; i++) {
import org.opensearch.search.aggregations.metrics.InternalTopHits;
                        .field("sv_field")  
        termsAggregator(ValueType.LONG, fieldType, Integer::longValue, Long::compareTo, luceneFieldFactory);  
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
    /**  
    }  
        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
import java.util.Collections;
        MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(  
                assertEquals("100.0", buckets.get(2).getKeyAsString());
                indexWriter.addDocument(document);
                                assertThat(kBucket.getDocCount(), equalTo(1L));
                    for (int j = 0; j < i; j++) {
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val010")));  
    }
                        "bucket_order={} size={} execution_hint={}, collect_mode={}",
    }
        testSimple(ADD_SORTED_SET_FIELD_NOT_INDEXED, false, false, false, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);
        }
                        .executionHint(executionHint)  
                .executionHint(executionMode.toString())
                for (int i = 0; i < 10; i++) {
                document = new Document();  
                if (includeDocCountField) {
                        .order(BucketOrder.key(true));
                                new String[] {  
                        }
                }
    /**
                                    .executionHint(executionHint)
            }  
        Directory directory = newDirectory();  
            }  
            val -> new NumericDocValuesField("field", Double.doubleToRawLongBits(val))  
        try (Directory directory = newDirectory()) {  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)  
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "");  
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
        }
                RandomIndexWriter indexWriter = new RandomIndexWriter(  
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val005")));
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
    }
                    result = reduce(aggregator);
                    aggregator.postCollection();  
                }
                    assertEquals("val007", result.getBuckets().get(7).getKeyAsString());  
                document = new Document();
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();
        MappedFieldType stringFieldType,
            final int numDocs = 10;
                            {
                GlobalOrdinalsStringTermsAggregator aggregator1 = createAndTestAggregator(indexSearcher, stringFieldType, 2);
    }  
import org.opensearch.search.aggregations.bucket.filter.Filter;  
                    assertEquals("c", result.getBuckets().get(1).getKeyAsString());
                        .includeExclude(new IncludeExclude("val00.+", null))
                MappedFieldType fieldType2 = new NumberFieldMapper.NumberFieldType("long", NumberFieldMapper.NumberType.LONG);  
                }
                        .field("mv_field")  
 * license agreements. See the NOTICE file distributed with
                try (IndexReader reader = createIndexWithDoubles()) {
        Directory directory = newDirectory();  
                        aggregator.postCollection();  
    public void testStringIncludeExclude() throws Exception {
                        assertEquals(missingValues[i], result.getBuckets().get(0).getKey());
                            new TermsAggregationBuilder("j").field("j").subAggregation(new TermsAggregationBuilder("k").field("k"))  
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));  
                    assertEquals("d", result.getBuckets().get(4).getKeyAsString());  
        collectDocuments(indexSearcher, aggregator);
                    document.add(new Field("mv_field1", "value2", type));  
                    aggregator.preCollection();
                document = new Document();  
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, true, false, false, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);
        try (Directory directory = newDirectory()) {
 * KIND, either express or implied.  See the License for the
    }
        return DirectoryReader.open(directory);  
                                .collectMode(randomFrom(Aggregator.SubAggCollectionMode.values()))  
import java.util.ArrayList;  
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
        TermsAggregatorFactory.ExecutionMode executionMode,
import org.opensearch.index.mapper.Uid;  
                    assertEquals("val006", result.getBuckets().get(4).getKeyAsString());
                }  
        }  
        assertThat(globalAgg.descriptCollectionStrategy(), equalTo("remap"));
        }  
                    assertEquals(1L, result.getBuckets().get(8).getDocCount());  
                        .order(BucketOrder.aggregation("script", true))  
                        () -> createAggregator(termsAgg, indexSearcher, fieldType)
                    assertEquals(5, result.getBuckets().size());
                                InternalMultiBucketAggregation<?, ?> terms = result.getAggregations().get("terms");
                        comparator = Comparator.comparing(Map.Entry::getKey, keyComparator);
            if (mv) {
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val001")));  
        final Map<T, Long> counts = new HashMap<>();  
 */
                                assertNestedTopHitsScore(terms, withScore);
                                expectedCount = filteredCounts.get(actual.getKey());
                    assertEquals("val000", result.getBuckets().get(0).getKeyAsString());
                    assertEquals(1L, result.getBuckets().get(4).getDocCount());
                    assertEquals(2, result.getBuckets().size());
        MapperService mapperService = mock(MapperService.class);
                    document.add(new Field("mv_field", "name2", type));  
                for (String value : dataSet) {  
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        );
                for (Map.Entry<T, Long> entry : counts.entrySet()) {
                    assertEquals("_name", result.getName());
        for (int i = 0; i < 100; i++) {
            new MultiBucketConsumerService.MultiBucketConsumer(
                        .executionHint(executionHint)  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        // Fields indexed, deleted documents in segment: cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited
                    indexWriter.addDocument(document);
    }
import org.opensearch.index.query.MatchAllQueryBuilder;
                    document.add(new SortedSetDocValuesField("mv_field1", new BytesRef("name1")));
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val007")));
                    Aggregator.SubAggCollectionMode collectionMode = randomFrom(Aggregator.SubAggCollectionMode.values());  
                }
                        .shardSize(size)
import static org.opensearch.index.mapper.SeqNoFieldMapper.PRIMARY_TERM_NAME;
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
                        searcher,  
                        if (randomBoolean() && iterator.hasNext()) {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
    }  
        document = new Document();
                    MappedFieldType fieldType1 = new KeywordFieldMapper.KeywordFieldType("unrelated_value");
        IndexSearcher indexSearcher,
                        StringTerms jAgg = iBucket.getAggregations().get("j");
import org.opensearch.script.ScriptModule;  
            final BinaryDocValuesField field = new BinaryDocValuesField(fieldName, rangeType.encodeRanges(Collections.singleton(range)));
    ) throws IOException {
                    document.add(luceneFieldFactory.apply(entry.getKey()));
    public void testSimpleMapStringAggregation() throws Exception {
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));  
                documents.add(document);  
                            assertThat(hit.getScore(), greaterThan(0f));  
        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
                    TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
            }
                        .executionHint(executionHint)
                        assertEquals("name2", result.getBuckets().get(2).getKeyAsString());
 * under the License.  
                    result = reduce(aggregator);
            new MatchAllDocsQuery(),  
                        Terms.Bucket actual = result.getBuckets().get(i);
    public void testWithNestedAggregations() throws IOException {
        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("name").userValueTypeHint(ValueType.STRING)
    }
                        .collectMode(collectionMode)
                        .field("mv_field")  
                    if (randomBoolean()) {
                    aggregator.preCollection();
                    assertEquals(2, result.getBuckets().size());
                        Terms result = reduce(aggregator);
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
        );  
                        }
                        assertEquals(2L, result.getBuckets().get(0).getDocCount());
        document.add(new SortedNumericDocValuesField("number", 10));  
                documents.add(document);
    }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field(field);  
                RandomIndexWriter indexWriter = new RandomIndexWriter(  
    public void testNumberToStringValueScript() throws IOException {
                        .order(bucketOrder);
public class TermsAggregatorTests extends AggregatorTestCase {  
                CoreValuesSourceType.IP,
                    ValueType[] valueTypes = new ValueType[] { ValueType.STRING, ValueType.LONG, ValueType.DOUBLE };
                        TextFieldMapper.TextFieldType fieldType = new TextFieldMapper.TextFieldType("mv_field");
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.DOUBLE).field("double");
        try (Directory dir = newDirectory()) {
                GlobalOrdinalsStringTermsAggregator aggregator3 = createAndTestAggregator(indexSearcher, stringFieldType, 110);  
 * SPDX-License-Identifier: Apache-2.0
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.LONG).field("long");
                            .collectMode(collectionMode)
        IndexSearcher indexSearcher,
                    indexWriter.flush();
            } else {
                }  
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(100.0d)));  
                b -> {},
    public void testUsesGlobalOrdinalsByDefault() throws Exception {
            new IpFieldMapper.IpFieldType("field"),
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                            indexWriter.addDocument(document);
                    fieldtype.setDocValuesType(DocValuesType.SORTED_SET);  
        aggregator.postCollection();  
            }  
                                .executionHint(executionHint)  
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val003")));  
import org.opensearch.common.TriConsumer;  
                    TermsAggregatorFactory.REMAP_GLOBAL_ORDS = false;  
                        .order(BucketOrder.key(true))
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)  
        IndexSearcher indexSearcher,
                    assertEquals("val001", result.getBuckets().get(1).getKeyAsString());  
                    }  
                Document document = new Document();
                    AggregationExecutionException e = expectThrows(
                for (int i = 0; i < 10; i++) {  
                addFieldConsumer.apply(document, "string", "c");
            }
                    result = reduce(aggregator);
        }
        aggregationBuilder.userValueTypeHint(ValueType.STRING);  
                document.add(new LatLonDocValuesField(field, point.getLat(), point.getLon()));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    new SortedSetDocValuesField("field", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.100.42"))))
        final boolean includeDocCountField,
                            searchContext -> when(searchContext.termsAggregationMaxPrecomputeCardinality()).thenReturn(0L),
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                    aggregator.preCollection();
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                    assertEquals(5.0, result.getBuckets().get(1).getKey());
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                for (Aggregator.SubAggCollectionMode mode : Aggregator.SubAggCollectionMode.values()) {
                    Terms result = reduce(aggregator);
                }  
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "a");  
        // Fields indexed, no deleted documents in segment: will use LeafBucketCollector#termDocFreqCollector - no documents are visited
    }
 * this work for additional information regarding copyright
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
                        assertEquals(1, result.getBuckets().get(0).getDocCount());
                .order(BucketOrder.key(true));
                    for (int j = 0; j < 10; j++) {
            }
                                    .field("keyword")  
                                expectedCount = filteredCounts.get(InetAddresses.forString((String) actual.getKey()));  
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);  
                    assertEquals(2L, result.getBuckets().get(1).getKey());  
                    }
import java.util.List;
                    // so all 4 documents must be visited via normal collection  
                        request,
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name1").userValueTypeHint(ValueType.STRING)  
                            + "either does not exist, or is a pipeline aggregation and cannot be used to sort the buckets.",
                    aggregator.preCollection();
                indexWriter.addDocument(document);
                    document.clear();
                indexWriter.addDocument(document);  
                }
            for (int docId = 0; docId < ctx.reader().maxDoc(); docId++) {
                        executionHint,
                        assertEquals("no_nickname1", result.getBuckets().get(0).getKeyAsString());  
            4
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(0.0)));  
        };
                    newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE)  
                return new NumericDocValuesField("field", val);
            counts.put(key, numDocs);
                CoreValuesSourceType.BOOLEAN  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("string");
            )
                    result = reduce(aggregator);  
                        assertEquals(expected.getKey(), actual.getKey());
                    assertEquals("_name", result.getName());
                    try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
            Document document = new Document();
     * When termsAggregationMaxPrecomputeCardinality is set to 0, tryCollectFromTermFrequencies should bail out
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());  
        try (Directory directory = newDirectory()) {
                    AggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(valueType)  
                    assertEquals(0, result.getBuckets().size());  
            }
                    List<Map.Entry<T, Integer>> expectedBuckets = new ArrayList<>();
        document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE));  
import org.apache.lucene.index.LeafReaderContext;
        Function<Integer, T> valueFactory,  
import org.apache.lucene.document.SortedDocValuesField;
                MappedFieldType fieldType3 = new NumberFieldMapper.NumberFieldType("double", NumberFieldMapper.NumberType.DOUBLE);
        BiFunction<String, Boolean, IndexableField> luceneFieldFactory = (val, mv) -> {
import org.opensearch.index.mapper.RangeFieldMapper;
        Function<Integer, T> valueFactory,  
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val003")));
    }
import org.opensearch.common.util.MockBigArrays;
                    assertEquals(2L, result.getBuckets().get(1).getDocCount());
                } else {
                                    ).storedField("_none_")  
    }
                assertTrue(mergedAggs instanceof DoubleTerms);  
import org.apache.lucene.index.IndexOptions;
                    int[] nestedValues = new int[i];  
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();
                    if (order == false) {
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();
                        assertEquals(1, result.getBuckets().size());  
        when(mapperService.documentMapper()).thenReturn(mapper);
import org.opensearch.index.mapper.RangeType;
                            ),
        );
                                null,
 * ownership. Elasticsearch licenses this file to you under  
                List<Document> documents = new ArrayList<>();  
    public void testOrderByPipelineAggregation() throws Exception {  
        return aggregator;
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());  
 */  
    }  
                    assertEquals("d", nestedBucket.getKeyAsString());
                    fieldtype.setIndexOptions(IndexOptions.NONE);
        // Fields indexed, no deleted documents in segment: will use LeafBucketCollector#termDocFreqCollector - no documents are visited
        searcher.search(new MatchAllDocsQuery(), aggregator);
                    for (int i = 0; i < size; i++) {  
                    BucketOrder bucketOrder = BucketOrder.aggregation("_max", order);  
                    Terms result = reduce(aggregator);
                                .collectMode(collectionMode)
        InetAddress[] base = new InetAddress[] { InetAddresses.forString("192.168.0.0") };  
                    assertEquals("val002", result.getBuckets().get(0).getKeyAsString());  
                    }  
    // Constants for a script that returns a string
                    }  
                    MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("field");
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(1.0d)));
        TriConsumer<Document, String, String> addFieldConsumer,  
                                    "val003",  
                PipelineTree.EMPTY
                try (IndexReader reader = createIndexWithLongs()) {  
                        .executionHint(executionHint)  
                        .executionHint(executionHint)
                    AggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(valueType)
                    assertEquals("val006", result.getBuckets().get(6).getKeyAsString());
                                .field("nested_value")
        try (Directory directory = newDirectory()) {
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                for (int i = 0; i < 10; i++) {
                    CountingAggregator aggregator = createCountingAggregator(aggregationBuilder, indexSearcher, false, fieldType);
                        );
                            d.add(new SortedNumericDocValuesField("j", j));
                        new AtomicInteger(),
        BiFunction<T, Boolean, IndexableField> luceneFieldFactory
 * The OpenSearch Contributors require contributions made to  
            ),
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(
            }
import org.opensearch.index.mapper.MapperService;
                        for (SearchHit hit : topHits.getHits()) {
                        assertThat(iBucket.getDocCount(), equalTo(100L));
                    document.add(new NumericDocValuesField("value", entry.getValue()));
                return new SortedDocValuesField("field", new BytesRef(val));
            }  
                        comparator = comparator.reversed();  
        }  
    private <T> void termsAggregatorWithNestedMaxAgg(  
import org.opensearch.core.common.text.Text;
            ) {
import static org.hamcrest.Matchers.instanceOf;
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                            fieldType  
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(3.0)));  
            }
                            for (int k = 0; k < 10; k++) {  
    }
    }
                        .field("mv_field")  
                                // force the breadth_first mode  
import org.apache.lucene.document.StringField;
        }  
            randomBoolean(),  
                document = new Document();  
                    indexWriter.flush();
    private <T> void termsAggregator(  
                                assertNestedTopHitsScore(terms, withScore);
        aggregationBuilder.order(BucketOrder.count(false)); // count desc
                    MappedFieldType fieldType2 = new KeywordFieldMapper.KeywordFieldType("field2");
        }
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val005")));
                        InternalMultiBucketAggregation<?, ?> subTerms = bucket.getAggregations().get("sub_terms");  
        final Map<T, Integer> filteredCounts = new HashMap<>();
                    assertEquals(1L, result.getBuckets().get(4).getDocCount());  
        try (Directory directory = newDirectory()) {
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                assertEquals(expected, buckets.get(3).getDocCount());
            for (InternalAggregation internalAgg : aggs) {
                        .includeExclude(new IncludeExclude(new String[] { "val000", "val010" }, null))
            .field("number")  
            for (int i = 0; i < numLongs; i++) {
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);  
                    aggregator.postCollection();  
        Comparator<T> keyComparator,
                    assertEquals("f", nestedBucket.getKeyAsString());
        IndexSearcher indexSearcher,
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                    }  
                        .field("long_field")
                        for (int k = 0; k < 10; k++) {  
                document = new Document();
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
                    Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType1, fieldType2);  
import org.opensearch.search.sort.FieldSortBuilder;  
                            new MultiBucketConsumerService.MultiBucketConsumer(
                        assertEquals(0, result.getBuckets().size());
                        assertEquals(3, result.getBuckets().size());  
                        try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                document.add(new NumericDocValuesField("long_field", 2));
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                        assertEquals(expectedFilteredCounts, result.getBuckets().size());
                    aggregator.preCollection();
                    assertEquals("val002", result.getBuckets().get(2).getKeyAsString());
import org.opensearch.index.mapper.HllFieldMapper;
                            .subAggregation(
                    TermsAggregationBuilder request = new TermsAggregationBuilder("i").field("i")
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("string");  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                                    // match root document only
            getMockScriptService(),  
    }  
        MappedFieldType fieldType,
import org.apache.lucene.index.IndexReader;
                    InternalGlobal result = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), globalBuilder, fieldType);
    public void testNestedTermsAgg() throws Exception {
            try (
                    aggregator.postCollection();  
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
                                StringTerms.Bucket kBucket = kAgg.getBucketByKey(Integer.toString(k));
        T topLevel = (T) agg.buildTopLevel();
                                    fieldType
                document = new Document();  
                indexWriter.addDocument(document);
                    assertEquals(1.0, result.getBuckets().get(0).getKey());
                        .collectMode(collectionMode)
                                    "val001",
            }  
        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
                    assertEquals(2, result.getBuckets().size());  
    }
                assertEquals("1000.0", buckets.get(3).getKeyAsString());
                    assertEquals("val009", result.getBuckets().get(4).getKeyAsString());
                        comparator = comparator.reversed();  
        }
                document.add(new NumericDocValuesField("long_field", 0));
                List<? extends Terms.Bucket> buckets = ((DoubleTerms) mergedAggs).getBuckets();
                    assertEquals("val004", result.getBuckets().get(2).getKeyAsString());
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
import java.util.Iterator;
                document.add(new SortedDocValuesField("keyword", new BytesRef("a")));
                        .userValueTypeHint(ValueType.STRING)
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
            List<InternalAggregation> aggs = new ArrayList<>();
                    Document document = new Document();
                        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));  
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .field("field1")  
                dir.close();  
                    MappedFieldType fieldType2 = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);  
                        );
                    assertEquals("val005", result.getBuckets().get(2).getKeyAsString());
import static java.util.Collections.singleton;
                                    "val006",  
                            d.add(new SortedDocValuesField("k", new BytesRef(Integer.toString(k))));
                    FieldType type = TextParams.buildFieldType(() -> true, () -> false, () -> "positions", () -> false, () -> "no");  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.LONG)  
        }
                            indexSearcher,
                }
                    TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = false;
                    assertEquals(4, result.getBuckets().size());  
                documents.add(document);  
                    aggregator.postCollection();
        final boolean includeDeletedDocumentsInSegment,
                return new SortedSetDocValuesField("field", new BytesRef(InetAddressPoint.encode(val)));
                            }  
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(10.0d)));
    protected MapperService mapperServiceMock() {  
 * specific language governing permissions and limitations
            }
                        assertEquals(1L, result.getBuckets().get(1).getDocCount());
        );
        termsAggregator(ValueType.STRING, fieldType, i -> Integer.toString(i), String::compareTo, luceneFieldFactory);  
            double end = randomDoubleBetween(Math.nextUp(start), Double.MAX_VALUE, false);  
                indexWriter.addDocument(document);  
                                .order(BucketOrder.key(true))
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
                assertThat(topHits.getHits().getMaxScore(), equalTo(1f));
/*
                    Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType1);  
                    assertEquals(  
        }
                    );
import org.apache.lucene.index.DocValuesType;  
                            d.add(new SortedNumericDocValuesField("k", k));  
 *  
        MappedFieldType... fieldTypes
                    assertEquals(size, result.getBuckets().size());  
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
                }
                    IndexSearcher searcher = new IndexSearcher(reader);
                    aggregator.preCollection();  
                            .field("keyword")  
                        .subAggregation(
                                    "val011" }
import java.util.Comparator;
            i -> base[0] = InetAddressPoint.nextUp(base[0]),  
import org.opensearch.search.aggregations.BucketOrder;  
                    document.add(new StringField("string", value, Field.Store.NO));
                    StringTerms result = searchAndReduce(  
        aggregator.buildAggregations(new long[] { 0 });  
                        searcher,
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                    assertEquals(8, result.getBuckets().size());
        try (Directory directory = newDirectory()) {
        // Fields indexed, no deleted documents, but _doc_field value present in document:
                        if (valueType == ValueType.IP) {  
        directory.close();  
            ValueType.IP,
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.bucketScript;
                    assertThat(terms.getBuckets().size(), equalTo(3));
import org.apache.lucene.document.InetAddressPoint;
import org.opensearch.index.mapper.IpFieldMapper;
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val007")));  
                        assertEquals("_name", result.getName());
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val009")));  
    private InternalAggregation buildInternalAggregation(TermsAggregationBuilder builder, MappedFieldType fieldType, IndexSearcher searcher)
        scripts.put(STRING_SCRIPT_NAME, value -> STRING_SCRIPT_OUTPUT);
            }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
            }
                        .order(BucketOrder.key(true));
        }
import org.apache.lucene.document.BinaryDocValuesField;  
    public void testEmpty() throws Exception {
                documents.add(document);
                    assertEquals("val011", result.getBuckets().get(1).getKeyAsString());
        termsAggregator(  
                                entry1 = entry2;
        // Fields not indexed: cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited
 * software distributed under the License is distributed on an
        try (Directory directory = newDirectory()) {  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
        // now do the final reduce
                    GlobalAggregationBuilder globalBuilder = new GlobalAggregationBuilder("global").subAggregation(
                document.add(new SortedDocValuesField("field2", new BytesRef("d")));
        MockScriptEngine scriptEngine = new MockScriptEngine(
                InternalAggregation mergedAggs = internalAgg.reduce(aggs, ctx);
                    }  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");  
        assertThat(globalAgg.descriptCollectionStrategy(), equalTo("remap"));  
                            new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.LONG)
                }
                            }  
                            if (entry2 != null && i < entry2.getValue()) {
                    assertEquals(1L, result.getBuckets().get(9).getDocCount());
                            new IncludeExclude(
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            TermsAggregatorFactory.REMAP_GLOBAL_ORDS = null;
import org.apache.lucene.search.MatchAllDocsQuery;  
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());  
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field(field);
            }
            double start = randomDouble();
        threeLayerStringTestCase("global_ordinals");  
                Document document = new Document();
                    indexWriter.addDocument(document);
     */
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);  
                    assertEquals(4L, result.getBuckets().get(3).getKey());
                        for (Terms.Bucket actual : result.getBuckets()) {  
    protected List<String> unsupportedMappedFieldTypes() {  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    LongTerms result = searchAndReduce(
                    );
    public void testSimpleAggregation() throws Exception {  
    }
                                .order(BucketOrder.key(true))
                    document.add(new SortedSetDocValuesField("string", new BytesRef(value)));
                        aggregationBuilder.subAggregation(
                // test text
                            if (count > 0) {
                    }
    private final SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)  
                    assertEquals("val000", result.getBuckets().get(0).getKeyAsString());  
                        .order(BucketOrder.key(true));
                    aggregator.preCollection();
                    );  
            }
            createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldTypes)
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, false, false, false, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 0);
                    assertEquals("val007", result.getBuckets().get(3).getKeyAsString());  
    protected ScriptService getMockScriptService() {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        }  
                    newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE)  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
    private IndexReader createIndexWithLongs() throws IOException {
import org.opensearch.search.aggregations.AggregationExecutionException;  
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val004")));  
            randomBoolean(),
                    aggregator.postCollection();  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    // Note - other places we throw IllegalArgumentException
                        .includeExclude(new IncludeExclude(new long[] { 0, 5 }, null))
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                Document document = new Document();  
                        );  
            if (randomizeAggregatorImpl) {
import org.opensearch.search.aggregations.MultiBucketConsumerService;
 *
                        .includeExclude(new IncludeExclude(null, new double[] { 0.0, 5.0 }))
                        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(  
                            LongTerms.Bucket jBucket = jAgg.getBucketByKey(Integer.toString(j));  
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
import java.util.concurrent.atomic.AtomicInteger;
                        .includeExclude(new IncludeExclude("val00.+", "(val000|val001)"))
                    Aggregator.SubAggCollectionMode collectionMode = randomFrom(Aggregator.SubAggCollectionMode.values());
                    try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
                }
            int numDoubles = randomIntBetween(1, 3);
                                InternalNested nestedResult = result.getAggregations().get("nested");  
                document.add(new SortedDocValuesField("field2", new BytesRef("f")));  
            counts.put(valueFactory.apply(i), randomLong());  
                        .executionHint(executionHint)
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                    document.add(new Field("mv_field1", "value1", type));  
                document.add(new SortedDocValuesField("field1", new BytesRef("a")));  
        Comparator<InetAddress> comparator = (o1, o2) -> {
     */
        );  
                        new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING)  
    public void testRangeField() throws Exception {  
import org.opensearch.search.aggregations.Aggregator;
    public void testSimpleAggregationLowCardinality() throws Exception {
                                    "val004",
                        .field("double_field")
                    aggregator.postCollection();  
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());  
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
            documents.add(document);
                    String[] fieldNames = new String[] { "string", "long", "double" };
                        .field("long_field")  
                                DEFAULT_MAX_BUCKETS,
import static org.hamcrest.Matchers.equalTo;  
                    assertEquals(4.0, result.getBuckets().get(3).getKey());
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
                {
                    assertEquals(4, aggregator.getCollectCount().get());
            int numLongs = randomIntBetween(1, 3);  
                indexWriter.addDocument(document);  
        }  
                dir.close();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    Terms result = reduce(aggregator);
                            }  
import org.apache.lucene.document.FieldType;  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
     * @param expectedCollectCount expected number of documents visited as part of collect() invocation  
        GlobalOrdinalsStringTermsAggregator aggregator = createAggregatorWithCustomizableSearchContext(
                    MappedFieldType fieldType = new IpFieldMapper.IpFieldType("field");
                            .missing(missingValues[i]);
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val011")));
        MappedFieldType... fieldTypes  
        aggregationBuilder.subAggregation(AggregationBuilders.cardinality("card").field("string"));
                    dir = ((DirectoryReader) reader).directory();
                        Terms result = reduce(aggregator);
        );  
                addFieldConsumer.apply(document, "string", "a");  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                documents.add(document);
                    document.add(new NumericDocValuesField("_doc_count", 10));  
            }
import java.util.function.Function;
            if (mv) {
                    aggregator.preCollection();
                if (multiValued == false) {
        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));  
                Document document = new Document();
        try (Directory directory = newDirectory()) {
                    indexWriter.addDocument(document);
                        .executionHint(executionHint)
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(valueTypes[i])
                    assertEquals("val008", result.getBuckets().get(6).getKeyAsString());  
        globalAgg = (GlobalOrdinalsStringTermsAggregator) aggregator;
                        aggregator.postCollection();
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, false, true, true, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);
        Map<String, Function<Map<String, Object>, Object>> nonDeterministicScripts = new HashMap<>();  
    }
                    );
                        .field("string")
 */
                            }  
        aggregationBuilder.collectMode(Aggregator.SubAggCollectionMode.BREADTH_FIRST);
                        e.getMessage()  
                    expectedBuckets.sort(comparator);
                            new MatchAllDocsQuery(),  
                            .missing("no_nickname");
                    FieldType fieldtype = new FieldType(KeywordFieldMapper.Defaults.FIELD_TYPE);
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val006")));
                        .subAggregation(
                    }
import org.opensearch.search.aggregations.support.ValuesSourceType;
    }
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
                    boolean order = randomBoolean();  
                document.add(new SortedDocValuesField("keyword", new BytesRef("e")));
            agg.context().bigArrays(),
                    for (int j = 0; j < 10; j++) {
                document.add(new NumericDocValuesField("long_field", 3));
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                        }
                    document = new Document();
                            ValueType.STRING
                    CountingAggregator aggregator = new CountingAggregator(  
                        .size(12)
                        .order(BucketOrder.key(true));  
        try (Directory dir = newDirectory()) {
                    for (int i = 0; i < size; i++) {
                Document document = new Document();
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(10.0d)));  
import org.opensearch.index.mapper.TextParams;
                    aggregator.preCollection();
                document = new Document();  
                    assertEquals("val009", result.getBuckets().get(7).getKeyAsString());
            }
                    int size = randomIntBetween(1, counts.size());  
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "b");
import org.apache.lucene.document.SortedSetDocValuesField;  
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
                indexWriter.addDocument(document);
                    assertEquals(2L, result.getBuckets().get(0).getDocCount());
                    document.add(new SortedSetDocValuesField("mv_field2", new BytesRef("value2")));  
            dataSet.add("value" + i);  
                document = new Document();
                    assertEquals("val000", result.getBuckets().get(0).getKeyAsString());
    }
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
        indexWriter.close();
        threeLayerStringTestCase("map");
                addFieldConsumer.apply(document, "string", "");
        int ptr = 9;
import static org.mockito.Mockito.mock;  
        ValueType valueType,
                    aggregator.postCollection();  
    public void testGeoPointField() throws Exception {
     * @param collectSegmentOrds collect segment ords or not - set true to utilize LowCardinality implementation for GlobalOrdinalsStringTermsAggregator
                document.add(new SortedDocValuesField("field1", new BytesRef("c")));
                assertEquals(4, buckets.size());  
                        .order(bucketOrder)  
                document.add(new NumericDocValuesField("long_field", 5));
                    }  
                assertEquals("10.0", buckets.get(1).getKeyAsString());  
                        Terms result = reduce(aggregator);
        Function<T, IndexableField> luceneFieldFactory
                document.add(  
                assertEquals("quick_select", aggregator2.getResultSelectionStrategy());  
                    assertEquals("", result.getBuckets().get(0).getKeyAsString());  
            LeafBucketCollector leafCollector = aggregator.getLeafCollector(ctx, LeafBucketCollector.NO_OP_COLLECTOR);  
import org.opensearch.search.sort.ScoreSortBuilder;
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(4.0)));
     * @param addFieldConsumer a function that determines how a field is added to the document
        termsAggregatorWithNestedMaxAgg(
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
                        AggregationExecutionException.class,  
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
        termsAggregatorWithNestedMaxAgg(
package org.opensearch.search.aggregations.bucket.terms;
        }
            indexSearcher,
                    Terms result = reduce(aggregator);  
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType2);  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                                    .subAggregation(new TopHitsAggregationBuilder("top_hits").storedField("_none_"))
                // test keyword  
                    assertEquals(5, indexWriter.getDocStats().maxDoc);  // deleted document still in segment
            try (
                Document document = new Document();
                    assertEquals("c", result.getBuckets().get(3).getKeyAsString());
                            document.add(luceneFieldFactory.apply(entry.getKey(), false));  
    }
                                        withScore ? new ScoreSortBuilder() : new FieldSortBuilder("_doc")
                    TermsAggregationBuilder termsAgg = terms("terms").field("field")
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.apache.lucene.document.LatLonDocValuesField;
                document = new Document();
                addFieldConsumer.apply(document, "string", "");  
    ) throws Exception {  
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "b");  
                    assertEquals(1, result.getBuckets().size());  
                        .size(size)  
                    );
    public void testThreeLayerLong() throws IOException {  
                    if (order == false) {
                        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
import org.apache.lucene.search.IndexSearcher;
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    assertEquals("val008", result.getBuckets().get(8).getKeyAsString());
        List<String> dataSet = new ArrayList<>();
        }  
                null,  
                    assertEquals(0.0, result.getBuckets().get(0).getKey());
        AggregationBuilder aggregationBuilder,
        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldType);
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
        assertThat(globalAgg.descriptCollectionStrategy(), equalTo("dense"));
                    assertEquals(expectedCollectCount, aggregator.getCollectCount().get());
                        for (int j = 0; j < 10; j++) {  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
                    BucketScriptPipelineAggregationBuilder bucketScriptAgg = bucketScript("script", new Script("2.718"));  
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field(fieldName);  
                        aggregator.postCollection();  
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));  
import org.opensearch.index.mapper.NestedPathFieldMapper;
import org.apache.lucene.index.DirectoryReader;
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));  
                                assertThat(kBucket.getDocCount(), equalTo(1L));  
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = randomBoolean();
                CoreValuesSourceType.NUMERIC,
                        .order(BucketOrder.key(true));
                                InternalFilter result = searchAndReduce(
     */
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
        );  
    public void testStringTermsAggregator() throws Exception {  
                    Terms result = reduce(aggregator);
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        for (int i = 0; i < entry1.getValue(); i++) {
                    expectThrows(IllegalArgumentException.class, () -> { createAggregator(aggregationBuilder, indexSearcher, fieldType); });
                    Comparator<Map.Entry<T, Long>> comparator = Comparator.comparing(Map.Entry::getValue, Long::compareTo);
            } else {
        return DirectoryReader.open(directory);
                        longField("k")
                indexWriter.addDocument(document);
import org.opensearch.script.ScriptService;
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(5.0)));
            if (mv) {  
                        assertThat(iBucket.getDocCount(), equalTo(100L));  
import org.opensearch.index.mapper.DocumentMapper;  
                assertEquals(expected * 2, buckets.get(1).getDocCount());
                        assertEquals("_name", result.getName());  
                        } else {
            Integer::doubleValue,
                        keywordField("j"),
        try {  
    public void testIpTermsAggregator() throws Exception {
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "");
        for (MultiBucketsAggregation.Bucket bucket : terms.getBuckets()) {
                        NestedAggregationBuilder nested = new NestedAggregationBuilder("nested", "nested_object").subAggregation(  
                            "nested_value",
        for (TermsAggregatorFactory.ExecutionMode executionMode : TermsAggregatorFactory.ExecutionMode.values()) {  
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.DOUBLE);
                        request,  
                            )  
        boolean randomizeAggregatorImpl,  
                document = new Document();  
                            for (int k = 0; k < 10; k++) {
                    assertEquals(2L, result.getBuckets().get(2).getDocCount());
                    for (int i = 0; i < fieldNames.length; i++) {
                        }
                    aggregator.postCollection();  
        try (Directory directory = newDirectory()) {
                            }  
                    String[] fieldNames = new String[] { "string", "long", "double" };  
                            .order(BucketOrder.key(true))
                    assertEquals("val010", result.getBuckets().get(1).getKeyAsString());
    }
        BiFunction<Long, Boolean, IndexableField> luceneFieldFactory = (val, mv) -> {
                        .includeExclude(  
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.DOUBLE)
import java.util.function.BiFunction;
                    Document document = new Document();  
                        .shardSize(size)
                        "Invalid aggregation order path [script]. The provided aggregation [script] "
                            writer.addDocument(d);
                    assertEquals(1, result.getBuckets().get(0).getDocCount());
                    indexWriter.deleteAll();  
                        new MatchAllDocsQuery(),
        List<Document> documents = new ArrayList<>();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        MappedFieldType fieldType,
                assertEquals(expected * 2, buckets.get(2).getDocCount());  
    protected <A extends Aggregator> A createAggregator(  
                    TermsAggregationBuilder request = new TermsAggregationBuilder("i").field("i")
                MappedFieldType fieldType1 = new KeywordFieldMapper.KeywordFieldType("string");
            filteredCounts.put(key, 0);
    @Override
            } else {
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val009")));
            createIndexSettings(),  
                    result = reduce(aggregator);
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {  
                    assertEquals("a", result.getBuckets().get(0).getKeyAsString());  
            }  
                    assertEquals("val003", result.getBuckets().get(3).getKeyAsString());
                        longField("i"),  
        assertThat(globalAgg.collectMode, equalTo(Aggregator.SubAggCollectionMode.DEPTH_FIRST));  
                    assertEquals(3L, result.getBuckets().get(2).getKey());
                        bucketOrder,  
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        document = new Document();
                    nestedBucket = ((Terms) result.getBuckets().get(1).getAggregations().get("_name2")).getBuckets().get(0);  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                            if (entry1.getValue().compareTo(entry2.getValue()) < 0) {  
                    MappedFieldType fieldType2 = new KeywordFieldMapper.KeywordFieldType("sv_field");
        testSimple(ADD_SORTED_SET_FIELD_NOT_INDEXED, false, false, true, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);  
                            writer.addDocument(d);
                CoreValuesSourceType.DATE,
        BiFunction<InetAddress, Boolean, IndexableField> luceneFieldFactory = (val, mv) -> {
                                .field("field2")  
                    aggregator.preCollection();
                    for (boolean withScore : new boolean[] { true, false }) {
                    int size = randomIntBetween(1, counts.size());  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);  
    }
            luceneFieldFactory
                    Iterator<Map.Entry<T, Integer>> iterator = counts.entrySet().iterator();  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                    logger.info("bucket_order={} size={} execution_hint={}", bucketOrder, size, executionHint);  
                        fieldType.setFielddata(true);  
        MappedFieldType... fieldTypes
/*
        // cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited
        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field("string").size(size);
                    aggregator.postCollection();
                                InternalMultiBucketAggregation<?, ?> terms = nestedResult.getAggregations().get("terms");
                    document.add(new Field("mv_field", "name1", type));
                                .subAggregation(new TermsAggregationBuilder("k").field("k").executionHint(executionHint))
                        );
                assertThat(topHits.getHits().getMaxScore(), equalTo(Float.NaN));  
        assertThat(globalAgg.collectMode, equalTo(Aggregator.SubAggCollectionMode.BREADTH_FIRST));
                        assertFalse(AggregationInspectionHelper.hasValue((InternalTerms) result));
        assertThat(globalAgg.descriptCollectionStrategy(), equalTo("dense"));  
     * even when all other conditions are met (indexed fields, no deletions, no _doc_count).  
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                    }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("mv_field");  
import org.opensearch.index.mapper.SeqNoFieldMapper;  
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
                            if (randomBoolean()) {
        globalAgg = (GlobalOrdinalsStringTermsAggregator) aggregator;
                    aggregator.postCollection();
                        .field("mv_field")
                            }
                                new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
    /**
                return new SortedNumericDocValuesField("field", val);  
        }
        );  
     */  
            }
    public void testUnmappedWithMissing() throws Exception {  
                        StringTerms.Bucket iBucket = result.getBucketByKey(Integer.toString(i));  
        document.add(new SortedNumericDocValuesField("number", 1));
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
                                    .collectMode(collectionMode)
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());  
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
                    aggregator.postCollection();
                )
            int numDocs = scaledRandomIntBetween(2, 32);
        termsAggregator(ValueType.DOUBLE, fieldType, Integer::doubleValue, Double::compareTo, luceneFieldFactory);
                assertEquals("priority_queue", aggregator1.getResultSelectionStrategy());
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(1000.0d)));
                document = new Document();
            PipelineTree.EMPTY
        final int expectedCollectCount
 * not use this file except in compliance with the License.
                    document = new Document();
import org.opensearch.common.settings.Settings;  
            TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = null;
        aggregator = createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldType);
                    fieldType = new NumberFieldMapper.NumberFieldType("double_field", NumberFieldMapper.NumberType.DOUBLE);
                }
                    }
                    assertEquals(1L, result.getBuckets().get(7).getDocCount());  
                            aggregationBuilder,
                )
                    assertEquals("val003", result.getBuckets().get(1).getKeyAsString());
                    document = new Document();
                    MappedFieldType fieldType1 = new KeywordFieldMapper.KeywordFieldType("field1");  
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
                        for (int k = 0; k < 10; k++) {
                );
                }
                                    "val002",
                    TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                    expectThrows(IllegalArgumentException.class, () -> { createAggregator(aggregationBuilder, indexSearcher, fieldType); });
                }  
    }
                        aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType, filterFieldType);  
        }  
import org.opensearch.common.network.InetAddresses;
                    result = reduce(aggregator);
import org.opensearch.search.aggregations.support.ValueType;
                    aggregator.postCollection();  
import org.apache.lucene.index.NoMergePolicy;
                        assertEquals(3, result.getBuckets().size());
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        aggregator.preCollection();
                            Integer expectedCount;
                        nestedValues[j] = j;
                }
/*  
    @Override
            fieldType,
                                    "val008",
import org.opensearch.index.query.QueryBuilders;
                        aggregator.preCollection();
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
                        Terms.Bucket actual = result.getBuckets().get(i);  
                        .executionHint(executionHint)
                indexWriter.addDocument(document);  
                            indexWriter.addDocument(document);
        for (int i = 0; i < numTerms; i++) {
                    while (iterator.hasNext()) {
                        assertEquals(1L, result.getBuckets().get(2).getDocCount());  
                    ValueType[] valueTypes = new ValueType[] { ValueType.STRING, ValueType.LONG, ValueType.DOUBLE };
                    result = reduce(aggregator);
                        .executionHint(executionHint)  
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());  
    }
    public void testTermFrequencyCardinalityGuard() throws Exception {  
            MockScriptEngine.NAME,
 *
                    expectedBuckets.sort(comparator);
import org.apache.lucene.tests.index.RandomIndexWriter;  
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;
                return new SortedDocValuesField("field", new BytesRef(InetAddressPoint.encode(val)));  
                    fieldtype.setStored(true);
                                expectedFilteredCounts++;
     * This verifies the cardinality guard: with threshold=0, all documents must be visited via normal collection.
                new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                                InternalNested result = searchAndReduce(  
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();  
        }
                    assertEquals("b", result.getBuckets().get(2).getKeyAsString());
     * This test case utilizes the LowCardinality implementation of GlobalOrdinalsStringTermsAggregator since collectSegmentOrds is true
                    random(),
                            d.add(new SortedDocValuesField("j", new BytesRef(Integer.toString(j))));  
                        }
                }
                    assertEquals("val009", result.getBuckets().get(9).getKeyAsString());
                    for (Map.Entry<T, Integer> entry : counts.entrySet()) {  
                    assertEquals("val007", result.getBuckets().get(5).getKeyAsString());
                    aggregator.postCollection();  
     * @param includeDeletedDocumentsInSegment to include deleted documents in the segment or not  
                                    new FieldExistsQuery(PRIMARY_TERM_NAME),  
                    assertEquals("", result.getBuckets().get(0).getKeyAsString());  
                        .order(BucketOrder.key(true));  
                    assertEquals("_name", result.getName());
            nonDeterministicScripts,
            --ptr;
        final Map<T, Integer> counts = new HashMap<>();
                    aggregator.postCollection();  
                                    new FieldExistsQuery(PRIMARY_TERM_NAME),
                            NumberFieldMapper.NumberType.LONG
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));  
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
        aggregationBuilder.collectMode(Aggregator.SubAggCollectionMode.DEPTH_FIRST);  
        indexWriter.close();  
                    assertEquals("_name", result.getName());
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    } else {  
            for (int i = 0; i < numDoubles; i++) {  
                    IndexSearcher searcher = new IndexSearcher(reader);
                document.add(new SortedDocValuesField("keyword", new BytesRef("c")));
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                        aggregationBuilder = new FilterAggregationBuilder("_name1", QueryBuilders.termQuery("include", "yes"));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        }
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        document.add(new SortedNumericDocValuesField("value", value));
                        .field("mv_field")
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    List<Map.Entry<T, Long>> expectedBuckets = new ArrayList<>();
                    assertEquals(5L, result.getBuckets().get(1).getKey());
                indexWriter.addDocument(document);  
import org.opensearch.index.mapper.NumberFieldMapper;  
                document = new Document();
                        .field("field")  
    public void testThreeLayerStringViaMap() throws IOException {  
            }  
                            new TermsAggregationBuilder("_name2").userValueTypeHint(ValueType.STRING)  
                                    "val007",
            RangeType rangeType = RangeType.DOUBLE;
import org.apache.lucene.index.IndexableField;  
                    assertEquals(1L, result.getBuckets().get(0).getKey());
                    assertEquals("val005", result.getBuckets().get(5).getKeyAsString());
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
    protected CountingAggregator createCountingAggregator(  
            T key = valueFactory.apply(i);  
                                    // match root document only
            document.add(new SortedNumericDocValuesField("nested_value", nestedValue));
        boolean collectSegmentOrds,  
                }
        IndexReader indexReader = DirectoryReader.open(directory);  
                    BucketOrder bucketOrder;  
        }
import org.opensearch.script.ScriptType;
            final String field = "field";  
                document = new Document();
                        Terms result = reduce(aggregator);
                        .order(BucketOrder.key(true));  
import org.opensearch.search.aggregations.bucket.nested.InternalNested;
        indexWriter.addDocument(document);  
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {  
                        aggregator.preCollection();
                indexWriter.addDocument(document);
    }
            randomBoolean(),
                    aggregator.preCollection();
                final Directory dir;
            assertEquals(TotalHits.Relation.EQUAL_TO, topHits.getHits().getTotalHits().relation());
                }
                    indexWriter.addDocument(document);  
                                    "val009",  
            }  
        return mapperService;  
    }
                    }
                            StringTerms kAgg = jBucket.getAggregations().get("k");  
                // Case 1: PriorityQueue selection, when buckets > size && buckets <= 5*size (size=2, buckets=100)  
                    for (MultiBucketsAggregation.Bucket bucket : terms.getBuckets()) {
                indexWriter.addDocument(document);
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, true, false, true, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);  
    private static final String STRING_SCRIPT_OUTPUT = "Orange";  
                    assertEquals(5, result.getBuckets().size());
                    ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "e");  
                        .field("string")
        }
                        assertThat(subTerms.getBuckets().size(), equalTo(1));
                    IndexSearcher searcher = newIndexSearcher(reader);
                        assertEquals("name2", result.getBuckets().get(2).getKeyAsString());
                    Terms.Bucket nestedBucket = ((Terms) result.getBuckets().get(0).getAggregations().get("_name2")).getBuckets().get(0);
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val001")));
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    Terms result = reduce(aggregator);
                document = new Document();  
                }
                addFieldConsumer.apply(document, "string", "b");  
                                    new TopHitsAggregationBuilder("top_hits").sort(
            return b1.compareTo(b2);
        );  
        // Infers depth_first because the maxOrd is 0 which is less than the size
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(2.0)));
import java.net.InetAddress;
            }
import org.apache.lucene.document.Document;
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
    }
     * This is a utility method to test out string terms aggregation
    }  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        .executionHint(executionHint)
                    assertEquals("b", result.getBuckets().get(2).getKeyAsString());
import static org.hamcrest.Matchers.greaterThan;
            document.add(new Field(NestedPathFieldMapper.NAME, "nested_object", NestedPathFieldMapper.Defaults.FIELD_TYPE));  
                        IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        .executionHint(executionMode.toString())
        document.add(sequenceIDFields.primaryTerm);
                        .order(BucketOrder.key(true));  
            i -> Integer.toString(i),
                        comparator = Comparator.comparing(Map.Entry::getValue);
            for (int i = 0; i < numDocs; i++) {
                            .field("mv_field")  
                        // if order by count then we need to use compound so that we can also sort by key as tie breaker:  
                    assertEquals(1L, result.getBuckets().get(6).getDocCount());
                    assertEquals("e", result.getBuckets().get(2).getKeyAsString());
import java.util.HashMap;  
                    indexWriter.addDocuments(documents);
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.DOUBLE)  
import java.io.IOException;
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        result = ((Filter) reduce(aggregator)).getAggregations().get("_name2");
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("long_field", NumberFieldMapper.NumberType.LONG);  
                        size,
                indexWriter.addDocument(document);  
                    Terms result = reduce(aggregator);
                    assertEquals(1L, result.getBuckets().get(4).getDocCount());  
                    expectedBuckets.addAll(counts.entrySet());
                    // Set threshold to 0 so the cardinality guard bails out of tryCollectFromTermFrequencies
            if (mv) {  
                    directory,
                    assertEquals(0L, result.getBuckets().get(0).getKey());
        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
                        .includeExclude(new IncludeExclude("val00.+", null))
            }
                    assertEquals("val010", result.getBuckets().get(0).getKeyAsString());
                        Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, (MappedFieldType) null);
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        throws IOException {
                        .subAggregation(bucketScriptAgg);
                    aggregator.postCollection();
                                );
    }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("keyword");  
                        }  
            if (withScore) {  
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);  
        }  
            Integer.MAX_VALUE,
        };
                        Map.Entry<T, Long> expected = expectedBuckets.get(i);
                        .field("string");
                    assertEquals(1L, result.getBuckets().get(4).getDocCount());
                indexWriter.commit();  
import org.opensearch.common.geo.GeoPoint;
 * You may obtain a copy of the License at  
import org.opensearch.script.MockScriptEngine;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        assertEquals("no_nickname", result.getBuckets().get(0).getKeyAsString());
        Directory directory = newDirectory();
                if (includeDeletedDocumentsInSegment) {
                            }  
                        LongTerms jAgg = iBucket.getAggregations().get("j");
                            LongTerms kAgg = jBucket.getAggregations().get("k");
                }
            final RangeFieldMapper.Range range = new RangeFieldMapper.Range(rangeType, start, end, true, true);
            BytesRef b1 = new BytesRef(InetAddressPoint.encode(o1));
            val -> new SortedDocValuesField("field", new BytesRef(val))
        TermsAggregator aggregator = createAggregator(builder, searcher, fieldType);  
                assertEquals("select_all", aggregator3.getResultSelectionStrategy());
                        .subAggregation(AggregationBuilders.max("_max").field("value"));
                        new MatchAllDocsQuery(),
     * This test case utilizes the default implementation of GlobalOrdinalsStringTermsAggregator since collectSegmentOrds is false
    private GlobalOrdinalsStringTermsAggregator createAndTestAggregator(  
                    }  
        try (Directory directory = newDirectory()) {
            new AtomicInteger(),
                    aggregator.preCollection();  
            asList(
    ) throws IOException {
                                LongTerms.Bucket kBucket = kAgg.getBucketByKey(Integer.toString(k));
                indexWriter.addDocument(document);
                            assertEquals(expectedCount.longValue(), actual.getDocCount());
                            }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                            Document document = new Document();
    public void testStringTermAggregatorForResultSelectionStrategy() throws IOException {  
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType3);  
import org.apache.lucene.document.NumericDocValuesField;  
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
                                .subAggregation(  
                return new SortedNumericDocValuesField("field", Double.doubleToRawLongBits(val));
                    for (int i = 0; i < 10; i++) {
                    Document document = new Document();
                    result = reduce(aggregator);  
                        aggregator.postCollection();  
                document = new Document();
                        assertThat(topHits.getHits().getHits().length, equalTo(1));
                // Case 3: Get All buckets when buckets <= size (size=110, buckets=100)
        boolean randomizeAggregatorImpl = false;
            final String field = "field";
        BiFunction<Double, Boolean, IndexableField> luceneFieldFactory = (val, mv) -> {
        return Collections.unmodifiableList(  
                            d.add(new SortedDocValuesField("i", new BytesRef(Integer.toString(i))));
                long expected = numLongs + numDoubles;
        globalAgg = (GlobalOrdinalsStringTermsAggregator) aggregator;  
                        Map.Entry<T, Integer> entry2 = null;  
                        }
                    Comparator<Map.Entry<T, Integer>> comparator;
            ) {
                    expectedBuckets.addAll(counts.entrySet());
        // Fields not indexed: cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                                .executionHint(executionHint)
                        .executionHint(executionHint)
                            } else {
     * @param executionMode execution mode MAP or GLOBAL_ORDINALS
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
                            .executionHint(executionHint)
                        .order(BucketOrder.key(true));
                indexWriter.addDocuments(documents);  
        T result = (T) topLevel.reduce(Collections.singletonList(topLevel), context);  
            .field("string");
    }  
                                    .subAggregation(nested);
    private void threeLayerStringTestCase(String executionHint) throws IOException {
     * This test case utilizes the MapStringTermsAggregator.
                    }
                document.add(new NumericDocValuesField("unrelated_value", 100));
                    }  
                    document.add(new SortedSetDocValuesField("mv_field2", new BytesRef("value1")));  
                    if (includeDocCountField) {
                addFieldConsumer.apply(document, "string", "b");
                    assertEquals(2.0, result.getBuckets().get(1).getKey());  
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
                    random(),
                    indexWriter.addDocument(document);
                            assertThat(jBucket.getDocCount(), equalTo(10L));
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                        aggregator.postCollection();
                            StringTerms.Bucket jBucket = jAgg.getBucketByKey(Integer.toString(j));
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
        return documents;
            ValueType.STRING,
        document = new Document();
                                FilterAggregationBuilder filter = new FilterAggregationBuilder("filter", new MatchAllQueryBuilder())  
import static org.mockito.Mockito.when;
import org.opensearch.common.util.MockPageCacheRecycler;
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType1);  
                Document document = new Document();
        assertThat(globalAgg.descriptCollectionStrategy(), equalTo("remap"));
                    Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);  
                document.add(new NumericDocValuesField("long_field", 4));  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            boolean multiValued = randomBoolean();  
import org.opensearch.script.Script;
        indexWriter.addDocument(document);
        }
                }
 * Unless required by applicable law or agreed to in writing,
                leafCollector.collect(docId, 0); // collect with bucket ordinal 0 (root bucket)
                        .field("double_field")  
                        aggregator.preCollection();
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType, fieldType2);
                    if (multiValued == false) {
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;  
                    assertEquals(2, result.getBuckets().size());
                            Document d = new Document();
    /**
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val000")));
import org.opensearch.search.aggregations.pipeline.BucketScriptPipelineAggregationBuilder;  
                .field("number")  
                document = new Document();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        Map.Entry<T, Integer> entry1 = iterator.next();
    public void testLongTermsAggregator() throws Exception {  
import org.opensearch.search.aggregations.LeafBucketCollector;  
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;
                        createAggregatorWithCustomizableSearchContext(
                                entry2 = temp;  
        assertThat(terms.getBuckets().size(), equalTo(9));  
            fieldType,  
                    aggregator.postCollection();
            }
                document = new Document();
                        MultiBucketsAggregation.Bucket subBucket = subTerms.getBuckets().get(0);
                Document document = new Document();
                    Terms result = reduce(aggregator);
                        Map.Entry<T, Integer> expected = expectedBuckets.get(i);
import org.opensearch.search.SearchHit;  
                    IndexSearcher searcher = newIndexSearcher(reader);  
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)  
        indexWriter.addDocument(document);  
        AggregationBuilder aggregationBuilder,
 * compatible open source license.
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {  
                        bucketOrder = BucketOrder.key(order);  
import org.opensearch.index.mapper.KeywordFieldMapper;
                    TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = collectSegmentOrds;  
            }  
                            entry2 = iterator.next();
                        for (int i = 0; i < entry.getValue(); i++) {
                    assertEquals(1L, result.getBuckets().get(7).getDocCount());
                DEFAULT_MAX_BUCKETS,
                        .order(BucketOrder.key(true));
                } else {
import org.opensearch.test.geo.RandomGeoGenerator;
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));  
 * this file be licensed under the Apache-2.0 license or a
                addFieldConsumer.apply(document, "string", "a");
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
                }
                        assertEquals(expected.getValue().longValue(), actual.getDocCount());
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());  
        when(mapper.typeText()).thenReturn(new Text("_doc"));  
        Document document = new Document();
        documents.add(document);  
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                }  
                    assertEquals("b", nestedBucket.getKeyAsString());  
import org.opensearch.search.aggregations.InternalAggregation;
                    assertEquals(0, result.getBuckets().size());  
            } else {
                    document.add(new SortedSetDocValuesField("mv_field1", new BytesRef("name2")));  
        }
import org.opensearch.search.aggregations.AggregatorTestCase;
                        aggregator.preCollection();
        GlobalOrdinalsStringTermsAggregator globalAgg = (GlobalOrdinalsStringTermsAggregator) aggregator;
                    result = reduce(aggregator);
                        }
                    }
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "a");
                            assertThat(jBucket.getDocCount(), equalTo(10L));
                                    "val005",
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
            TermsAggregatorFactory.ExecutionMode.MAP,
        try (Directory directory = newDirectory()) {
                                filteredCounts.computeIfPresent(entry.getKey(), (key, integer) -> integer + 1);  
        return new TermsAggregationBuilder("foo").field(fieldName);
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
    private void testSimple(
            final String fieldName = "field";  
    ) throws Exception {
                        )  
                                .field("field")
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertEquals("c", result.getBuckets().get(3).getKeyAsString());  
        Document document = new Document();
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val008")));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
                assertEquals("1.0", buckets.get(0).getKeyAsString());
        );  
                    MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);
import org.apache.lucene.document.Field;
                Document document = new Document();
    }
    /**  
    private <T extends InternalAggregation> T reduce(Aggregator agg) throws IOException {
                CoreValuesSourceType.BYTES,  
    }
                            }
                                    nested,
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
    ) throws IOException {
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)  
                indexWriter.addDocument(document);  
    public void testThreeLayerStringViaGlobalOrds() throws IOException {
                {
                        }
        }, (Consumer<InternalTerms>) terms -> { assertTrue(AggregationInspectionHelper.hasValue(terms)); }, fieldType);
                    // Adding _doc_count to one document
                        assertEquals("name1", result.getBuckets().get(1).getKeyAsString());  
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;  
                    document = new Document();
                Document document = new Document();  
        document.add(new SortedNumericDocValuesField("number", 10));
                                .collectMode(mode)
                                    newSearcher(indexReader, false, true),
                    aggs.add(buildInternalAggregation(aggregationBuilder, fieldType, searcher));
                    assertEquals(3, result.getBuckets().size());
            );  
                            assertEquals(expected.getKey(), actual.getKey());  
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(1.0)));
                                document.add(new StringField("include", "yes", Field.Store.NO));
                GlobalOrdinalsStringTermsAggregator aggregator2 = createAndTestAggregator(indexSearcher, stringFieldType, 20);
    protected <A extends Aggregator> A createAggregator(  
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
                        InternalTopHits topHits = subBucket.getAggregations().get("top_hits");  
            stringFieldType  
                    assertEquals("val005", result.getBuckets().get(3).getKeyAsString());  
                                Map.Entry<T, Integer> temp = entry1;
        aggregator.preCollection();
                indexWriter.addDocument(document);
