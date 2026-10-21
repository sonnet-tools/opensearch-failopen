                    assertEquals("a", result.getBuckets().get(1).getKeyAsString());
    }
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("string");
                CoreValuesSourceType.DATE,
            }
                        .userValueTypeHint(ValueType.STRING)
import static java.util.Collections.singleton;
                    }
                    assertEquals("", result.getBuckets().get(0).getKeyAsString());
        document.add(new SortedNumericDocValuesField("number", 10));
                        IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    indexWriter.addDocument(document);
                }
            }
import org.opensearch.index.mapper.HllFieldMapper;
                                .size(numTerms)
                    }
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
            }
                        .includeExclude(new IncludeExclude(new long[] { 0, 5 }, null))
                        .order(BucketOrder.key(true));
                InternalAggregation mergedAggs = internalAgg.reduce(aggs, ctx);
 * this work for additional information regarding copyright
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(0.0)));
                    // Set threshold to 0 so the cardinality guard bails out of tryCollectFromTermFrequencies
                indexWriter.addDocument(document);
                    expectedBuckets.sort(comparator);
                    assertEquals(2L, result.getBuckets().get(1).getDocCount());
        aggregationBuilder.order(BucketOrder.count(false)); // count desc
                    assertEquals("val003", result.getBuckets().get(1).getKeyAsString());
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    IndexSearcher searcher = newIndexSearcher(reader);
                documents.add(document);
            luceneFieldFactory
                    assertEquals(2, result.getBuckets().size());
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
    public void testOrderByPipelineAggregation() throws Exception {
import org.apache.lucene.document.NumericDocValuesField;
            TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.LONG)
                            d.add(new SortedNumericDocValuesField("k", k));
                        request,
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        MappedFieldType... fieldTypes
        return documents;
                        keywordField("k")
                    assertEquals(1L, result.getBuckets().get(4).getDocCount());
        aggregationBuilder.subAggregation(AggregationBuilders.cardinality("card").field("string"));
                        createAggregatorWithCustomizableSearchContext(
                        e.getMessage()
                Document document = new Document();
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "d");
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val006")));
                }
                indexWriter.addDocument(document);
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType2);
    }
                CoreValuesSourceType.BYTES,
                            StringTerms.Bucket jBucket = jAgg.getBucketByKey(Integer.toString(j));
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
        aggregator = createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldType);
                CoreValuesSourceType.BOOLEAN
                    assertEquals(size, result.getBuckets().size());
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            }
                            createIndexSettings(),
        try (Directory directory = newDirectory()) {
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                    assertEquals(size, result.getBuckets().size());
                    assertEquals(2L, result.getBuckets().get(1).getKey());
                    assertEquals(4.0, result.getBuckets().get(3).getKey());
                        () -> createAggregator(termsAgg, indexSearcher, fieldType)
        try (Directory directory = newDirectory()) {
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
                    try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                    aggregator.preCollection();
                    Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType1);
            )
                Document document = new Document();
                null,
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
    public void testDoubleTermsAggregator() throws Exception {
        aggregationBuilder.userValueTypeHint(ValueType.STRING);
                        .executionHint(executionMode.toString())
                        .order(BucketOrder.key(true));
                document.add(new NumericDocValuesField("long_field", 3));
                        // if order by count then we need to use compound so that we can also sort by key as tie breaker:
                    document.add(new SortedSetDocValuesField("string", new BytesRef(value)));
                        .order(BucketOrder.aggregation("script", true))
                            ValueType.STRING
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.apache.lucene.document.Document;
            }
                            }
                Document document = new Document();
                            }
                document.add(new LatLonDocValuesField(field, point.getLat(), point.getLon()));
                    assertEquals(3, result.getBuckets().size());
                documents.add(document);
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
import org.opensearch.script.ScriptEngine;
            }
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
                    MappedFieldType fieldType2 = new KeywordFieldMapper.KeywordFieldType("field2");
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                return new SortedDocValuesField("field", new BytesRef(InetAddressPoint.encode(val)));
        List<Document> documents = new ArrayList<>();
                        .field("mv_field")
    public void testUnmapped() throws Exception {
                    // Adding _doc_count to one document
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                                // force the breadth_first mode
import org.apache.lucene.index.DirectoryReader;
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
    public void testSimpleAggregation() throws Exception {
        document.add(new SortedNumericDocValuesField("number", 100));
        }
        document.add(sequenceIDFields.primaryTerm);
                    }
                    TermsAggregationBuilder termsAgg = terms("terms").field("field")
import static org.hamcrest.Matchers.greaterThan;
            );
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        executionHint,
        boolean randomizeAggregatorImpl,
                                .order(BucketOrder.key(true))
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("string");
                        assertThat(subTerms.getBuckets().size(), equalTo(1));
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                    assertEquals("val008", result.getBuckets().get(8).getKeyAsString());
        Directory directory = newDirectory();
                    MappedFieldType fieldType2 = new KeywordFieldMapper.KeywordFieldType("sv_field");
                }
                try (IndexReader reader = createIndexWithDoubles()) {
                }
                            new TermsAggregationBuilder("_name2").userValueTypeHint(valueType)
            document.add(new Field(NestedPathFieldMapper.NAME, "nested_object", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                    expectedBuckets.sort(comparator);
                    aggregator.preCollection();
                addFieldConsumer.apply(document, "string", "a");
                    aggregator.postCollection();
                assertEquals(4, buckets.size());
            stringFieldType
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val009")));
                                    newSearcher(indexReader, false, true),
        MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
                            .missing(missingValues[i]);
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
        T topLevel = (T) agg.buildTopLevel();
                        assertEquals(11L, result.getBuckets().get(0).getDocCount());
                    Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        doAssertReducedMultiBucketConsumer(result, reduceBucketConsumer);
                            .executionHint(executionHint)
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    aggregator.postCollection();
                document = new Document();
     * @param includeDeletedDocumentsInSegment to include deleted documents in the segment or not
                                    ).storedField("_none_")
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("nick").userValueTypeHint(ValueType.STRING)
                        aggregator.postCollection();
                    assertEquals(0, result.getBuckets().size());
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                                );
                                StringTerms.Bucket kBucket = kAgg.getBucketByKey(Integer.toString(k));
                GlobalOrdinalsStringTermsAggregator aggregator1 = createAndTestAggregator(indexSearcher, stringFieldType, 2);
                    Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType1, fieldType2);
                            .order(BucketOrder.key(true))
import org.opensearch.index.query.QueryBuilders;
    public void testMixLongAndDouble() throws Exception {
import org.apache.lucene.search.FieldExistsQuery;
                // Case 2: QuickSelect selection, when buckets > size && buckets > 5*size (size=20, buckets=100)
                    indexWriter.addDocument(document);
                addFieldConsumer.apply(document, "string", "");
                    assertEquals(8, result.getBuckets().size());
    }
import org.apache.lucene.index.NoMergePolicy;
                        assertEquals(1L, result.getBuckets().get(2).getDocCount());
                    fieldtype.setIndexOptions(IndexOptions.NONE);
                        .executionHint(executionHint)
                    aggregator.preCollection();
                document = new Document();
                                    .subAggregation(nested);
        Comparator<T> keyComparator,
                        .order(BucketOrder.key(true))
        document = new Document();
            } else {
        try (Directory directory = newDirectory()) {
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val002")));
        final int expectedCollectCount
        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldType);
                                    "val007",
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
                    for (Map.Entry<T, Integer> entry : counts.entrySet()) {
                        .includeExclude(new IncludeExclude("val00.+", null))
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.opensearch.script.ScriptService;
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        document.add(new SortedNumericDocValuesField("number", 1000));
        List<String> dataSet = new ArrayList<>();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(2.0)));
                        aggregationBuilder.subAggregation(
        aggregator = createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldType);
                    dir = ((DirectoryReader) reader).directory();
                        aggregator.postCollection();
            document.add(new SortedNumericDocValuesField("nested_value", nestedValue));
                    document.add(new SortedSetDocValuesField("mv_field2", new BytesRef("value2")));
                        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
    private InternalAggregation buildInternalAggregation(TermsAggregationBuilder builder, MappedFieldType fieldType, IndexSearcher searcher)
                            }
                    dir = ((DirectoryReader) reader).directory();
                }
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        .subAggregation(
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val011")));
                    assertEquals("val000", result.getBuckets().get(0).getKeyAsString());
        assertThat(globalAgg.collectMode, equalTo(Aggregator.SubAggCollectionMode.DEPTH_FIRST));
                            .collectMode(collectionMode)
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            } else {
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
    private static final String STRING_SCRIPT_NAME = "string_script";
                document = new Document();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.opensearch.common.util.MockPageCacheRecycler;
    }
                        .executionHint(executionHint)
                        );
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();
                    random(),
                    document.add(new Field("mv_field1", "value1", type));
            }
            Document document = new Document();
                        KeywordFieldMapper.KeywordFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("mv_field1");
            T key = valueFactory.apply(i);
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    }
                    );
    private void collectDocuments(IndexSearcher searcher, GlobalOrdinalsStringTermsAggregator aggregator) throws IOException {
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
        try (Directory directory = newDirectory()) {
                    nestedBucket = ((Terms) result.getBuckets().get(1).getAggregations().get("_name2")).getBuckets().get(0);
                            Document d = new Document();
                Document document = new Document();
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.opensearch.search.aggregations.Aggregator;
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
                        size,
                    MappedFieldType fieldType1 = new KeywordFieldMapper.KeywordFieldType("unrelated_value");
     * This test case utilizes the default implementation of GlobalOrdinalsStringTermsAggregator since collectSegmentOrds is false
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(10.0d)));
                    assertEquals(1, result.getBuckets().get(0).getDocCount());
/*
        Document document = new Document();
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
        globalAgg = (GlobalOrdinalsStringTermsAggregator) aggregator;
                    assertEquals("val002", result.getBuckets().get(0).getKeyAsString());
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
        }
    public void testIpTermsAggregator() throws Exception {
import org.opensearch.core.common.text.Text;
            for (int i = 0; i < numLongs; i++) {
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
        globalAgg = (GlobalOrdinalsStringTermsAggregator) aggregator;
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        IndexSearcher indexSearcher = newIndexSearcher(indexReader);
    protected CountingAggregator createCountingAggregator(
import org.opensearch.index.mapper.GeoPointFieldMapper;
                        aggregator.preCollection();
 * this file be licensed under the Apache-2.0 license or a
                        aggregator.postCollection();
import org.opensearch.index.mapper.SeqNoFieldMapper;
                        Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, (MappedFieldType) null);
        indexWriter.addDocument(document);
                    assertEquals("val008", result.getBuckets().get(6).getKeyAsString());
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                RandomIndexWriter indexWriter = new RandomIndexWriter(
                        .order(BucketOrder.key(true));
import org.opensearch.index.query.MatchAllQueryBuilder;
                            )
        };
            comparator,
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
                document = new Document();
            val -> new SortedDocValuesField("field", new BytesRef(val))
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val001")));
            BytesRef b1 = new BytesRef(InetAddressPoint.encode(o1));
                                .subAggregation(new TermsAggregationBuilder("k").field("k").executionHint(executionHint))
                    }
        GlobalOrdinalsStringTermsAggregator globalAgg = (GlobalOrdinalsStringTermsAggregator) aggregator;
                                );
                            }
                document.add(
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
                    result = reduce(aggregator);
        AggregationBuilder aggregationBuilder,
                                    "val006",
                        aggregator.preCollection();
                assertThat(topHits.getHits().getMaxScore(), equalTo(Float.NaN));
     * This test case utilizes the MapStringTermsAggregator.
                        .collectMode(collectionMode)
                                expectedFilteredCounts++;
        try (Directory directory = newDirectory()) {
                    document.add(new Field("mv_field1", "value2", type));
                assertEquals(expected * 2, buckets.get(1).getDocCount());
        termsAggregator(
                    assertEquals(10, result.getBuckets().size());
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field(field);
                        for (Terms.Bucket actual : result.getBuckets()) {
        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
            double end = randomDoubleBetween(Math.nextUp(start), Double.MAX_VALUE, false);
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, false, true, false, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);
        };
        }
                        .executionHint(executionHint)
    /**
import org.apache.lucene.util.BytesRef;
        termsAggregatorWithNestedMaxAgg(
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
import org.apache.lucene.document.FieldType;
                    Document document = new Document();
        GlobalOrdinalsStringTermsAggregator aggregator = createAggregatorWithCustomizableSearchContext(
                            Document d = new Document();
                    boolean order = randomBoolean();
                    String[] fieldNames = new String[] { "string", "long", "double" };
                        .subAggregation(AggregationBuilders.max("_max").field("value"));
                document = new Document();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService()),
import org.opensearch.common.network.InetAddresses;
                                entry2 = temp;
                }
        TermsAggregatorFactory.ExecutionMode executionMode,
            RangeType rangeType = RangeType.DOUBLE;
            documents.add(document);
                        .executionHint(TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS.toString())
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val000")));
    private void testSimple(
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
import java.util.Iterator;
        boolean randomizeAggregatorImpl,
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
        for (TermsAggregatorFactory.ExecutionMode executionMode : TermsAggregatorFactory.ExecutionMode.values()) {
                        .field("mv_field")
import org.opensearch.index.mapper.Uid;
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
                }
    }
                            entry2 = iterator.next();
            for (InternalAggregation internalAgg : aggs) {
        return new CountingAggregator(
                    assertEquals("192.168.100.42", result.getBuckets().get(0).getKey());
                    assertEquals("c", result.getBuckets().get(3).getKeyAsString());
                        try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                    result = reduce(aggregator);
                        assertFalse(AggregationInspectionHelper.hasValue((InternalTerms) result));
     */
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
                            d.add(new SortedDocValuesField("k", new BytesRef(Integer.toString(k))));
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.DOUBLE)
            }
    }
                assertEquals("quick_select", aggregator2.getResultSelectionStrategy());
                                    .collectMode(collectionMode)
        directory.close();
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
                    assertEquals(2, result.getBuckets().size());
import org.apache.lucene.index.DocValuesType;
        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
                        assertThat(iBucket.getDocCount(), equalTo(100L));
        termsAggregator(ValueType.LONG, fieldType, Integer::longValue, Long::compareTo, luceneFieldFactory);
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
                    assertEquals("_name", result.getName());
                                    "val009",
                assertEquals("1.0", buckets.get(0).getKeyAsString());
    public void testRangeField() throws Exception {
                    TermsAggregatorFactory.REMAP_GLOBAL_ORDS = false;
                indexWriter.addDocument(document);
    }
                            assertThat(jBucket.getDocCount(), equalTo(10L));
                    assertEquals("val000", result.getBuckets().get(0).getKeyAsString());
    private IndexReader createIndexWithLongs() throws IOException {
                    assertEquals(2L, result.getBuckets().get(2).getDocCount());
            InternalTopHits topHits = bucket.getAggregations().get("top_hits");
                    assertEquals("b", nestedBucket.getKeyAsString());
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    assertEquals(4L, result.getBuckets().get(3).getKey());
import org.opensearch.script.ScriptModule;
                    assertEquals(1L, result.getBuckets().get(8).getDocCount());
                        assertEquals(1, result.getBuckets().get(0).getDocCount());
            ) {
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
    }
                );
                    assertEquals("d", result.getBuckets().get(4).getKeyAsString());
    public void testSimpleMapStringAggregation() throws Exception {
                    assertEquals("", result.getBuckets().get(0).getKeyAsString());
                    IndexSearcher searcher = new IndexSearcher(reader);
                    assertEquals(1L, result.getBuckets().get(7).getDocCount());
                            if (valueType == ValueType.IP) {
                    result = reduce(aggregator);
                        .order(bucketOrder)
                    );
    @Override
                    assertEquals(1L, result.getBuckets().get(6).getDocCount());
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(valueTypes[i])
            LeafBucketCollector leafCollector = aggregator.getLeafCollector(ctx, LeafBucketCollector.NO_OP_COLLECTOR);
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
        threeLayerStringTestCase("map");
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(5.0)));
                    BucketScriptPipelineAggregationBuilder bucketScriptAgg = bucketScript("script", new Script("2.718"));
                    assertEquals("val005", result.getBuckets().get(5).getKeyAsString());
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, false, false, true, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 0);
                            new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.LONG)
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
        }
                    assertEquals(5.0, result.getBuckets().get(1).getKey());
        }
                        Map.Entry<T, Integer> entry1 = iterator.next();
                    aggregator.preCollection();
        }
        InetAddress[] base = new InetAddress[] { InetAddresses.forString("192.168.0.0") };
            scripts,
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val009")));
    }
                        }
        }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            new IpFieldMapper.IpFieldType("field"),
        boolean collectSegmentOrds,
                    for (int j = 0; j < i; j++) {
                    }
        indexWriter.addDocument(document);
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                    }
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
                indexWriter.addDocument(document);
                    }
            for (int docId = 0; docId < ctx.reader().maxDoc(); docId++) {
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.DOUBLE);
    }
                                LongTerms.Bucket kBucket = kAgg.getBucketByKey(Integer.toString(k));
        int ptr = 9;
                    int size = randomIntBetween(1, counts.size());
                        Map.Entry<T, Long> expected = expectedBuckets.get(i);
                }
                        }
        IndexSearcher indexSearcher,
import java.util.function.Consumer;
 * ownership. Elasticsearch licenses this file to you under
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
            }
    public void testThreeLayerStringViaGlobalOrds() throws IOException {
    }
                        LongTerms.Bucket iBucket = result.getBucketByKey(Integer.toString(i));
                        .executionHint(executionHint)
                            Document document = new Document();
    /**
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "b");
        TermsAggregator aggregator = createAggregator(builder, searcher, fieldType);
                    logger.info("bucket_order={} size={} execution_hint={}", bucketOrder, size, executionHint);
                    expectThrows(IllegalArgumentException.class, () -> { createAggregator(aggregationBuilder, indexSearcher, fieldType); });
    ) throws Exception {
                assertEquals("100.0", buckets.get(2).getKeyAsString());
                        .size(12)
        // Fields indexed, no deleted documents in segment: will use LeafBucketCollector#termDocFreqCollector - no documents are visited
                    TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                    directory,
                    IndexSearcher searcher = newIndexSearcher(reader);
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
                }
                    aggregator.preCollection();
                                    // match root document only
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        when(mapperService.documentMapper()).thenReturn(mapper);
                    Aggregator.SubAggCollectionMode collectionMode = randomFrom(Aggregator.SubAggCollectionMode.values());
                    assertEquals(2L, result.getBuckets().get(2).getDocCount());
                            if (count > 0) {
                        .order(BucketOrder.key(true));
                        nestedValues[j] = j;
                    assertEquals(1L, result.getBuckets().get(4).getDocCount());
    }
                        for (int k = 0; k < 10; k++) {
                    assertEquals("val006", result.getBuckets().get(6).getKeyAsString());
                    indexWriter.addDocument(document);
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();
                    fieldType = new NumberFieldMapper.NumberFieldType("double_field", NumberFieldMapper.NumberType.DOUBLE);
                            indexWriter.addDocument(document);
                indexWriter.addDocument(document);
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                }
        assertThat(globalAgg.descriptCollectionStrategy(), equalTo("remap"));
                    aggregator.preCollection();
            }
                documents.add(document);
 */
                }
                    indexWriter.flush();
                        .executionHint(executionHint)
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val004")));
                    }
import org.apache.lucene.document.SortedDocValuesField;
                    );
        Comparator<InetAddress> comparator = (o1, o2) -> {
 * the Apache License, Version 2.0 (the "License"); you may
     */
    }
                            indexSearcher,
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
            counts.put(key, numDocs);
                            fieldType
        }
                    Terms.Bucket nestedBucket = ((Terms) result.getBuckets().get(0).getAggregations().get("_name2")).getBuckets().get(0);
                        longField("j"),
                document.add(new SortedDocValuesField("field1", new BytesRef("c")));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        assertEquals(1L, result.getBuckets().get(1).getDocCount());
    public void testGlobalAggregationWithScore() throws IOException {
        try (Directory directory = newDirectory()) {
        try (Directory directory = newDirectory()) {
public class TermsAggregatorTests extends AggregatorTestCase {
        globalAgg = (GlobalOrdinalsStringTermsAggregator) aggregator;
                        aggregator.postCollection();
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
                                    new TopHitsAggregationBuilder("top_hits").sort(
                            d.add(new SortedDocValuesField("j", new BytesRef(Integer.toString(j))));
                    Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType, fieldType2);
                    }
                    );
    }
                MappedFieldType fieldType3 = new NumberFieldMapper.NumberFieldType("double", NumberFieldMapper.NumberType.DOUBLE);
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
                    assertEquals(0L, result.getBuckets().get(0).getKey());
            filteredCounts.put(key, 0);
        for (int i = 0; i < numTerms; i++) {
        int numTerms = scaledRandomIntBetween(8, 128);
import org.apache.lucene.index.Term;
                        "bucket_order={} size={} execution_hint={}, collect_mode={}",
                            document.add(luceneFieldFactory.apply(entry.getKey(), false));
        // Fields indexed, deleted documents in segment: cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited
                        assertEquals(missingValues[i], result.getBuckets().get(0).getKey());
                        assertEquals(2L, result.getBuckets().get(0).getDocCount());
                    assertEquals(0, result.getBuckets().size());
                        .field("field")
    public void testStringTermAggregatorForResultSelectionStrategy() throws IOException {
                    }
                        InternalMultiBucketAggregation<?, ?> subTerms = bucket.getAggregations().get("sub_terms");
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                    aggregator.postCollection();
import static java.util.Arrays.asList;
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(10.0d)));
import org.opensearch.search.aggregations.AggregatorTestCase;
import org.opensearch.script.MockScriptEngine;
                        assertEquals(expected.getValue().longValue(), actual.getDocCount());
            }
    @Override
        // Fields indexed, no deleted documents in segment: will use LeafBucketCollector#termDocFreqCollector - no documents are visited
                    assertEquals(4, result.getBuckets().size());
            if (mv) {
                            }
import org.opensearch.index.mapper.IdFieldMapper;
        termsAggregatorWithNestedMaxAgg(ValueType.LONG, fieldType, Integer::longValue, val -> new NumericDocValuesField("field", val));
                document = new Document();
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                    aggregator.postCollection();
                document = new Document();
                document.add(field);
                    assertEquals("val009", result.getBuckets().get(4).getKeyAsString());
            for (int i = 0; i < numDoubles; i++) {
                    Comparator<Map.Entry<T, Long>> comparator = Comparator.comparing(Map.Entry::getValue, Long::compareTo);
                    Aggregator.SubAggCollectionMode collectionMode = randomFrom(Aggregator.SubAggCollectionMode.values());
                        .order(BucketOrder.key(true));
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(
                        request,
        indexWriter.addDocument(document);
        try (Directory directory = newDirectory()) {
                                .collectMode(mode)
            ADD_SORTED_SET_FIELD_INDEXED,
                    assertEquals(3L, result.getBuckets().get(2).getKey());
                            {
                    assertEquals("val001", result.getBuckets().get(1).getKeyAsString());
 *
import java.util.HashMap;
        for (MultiBucketsAggregation.Bucket bucket : terms.getBuckets()) {
                            d.add(new SortedNumericDocValuesField("j", j));
import org.opensearch.index.mapper.TextParams;
                        for (int i = 0; i < entry1.getValue(); i++) {
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "");
import org.apache.lucene.document.InetAddressPoint;
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "b");
                }
                    );
                } else {
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, false, false, false, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 0);
                        assertEquals(expectedFilteredCounts, result.getBuckets().size());
                .order(BucketOrder.key(true));
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val003")));
                    document = new Document();
            if (mv) {
    public void testBucketInTermsAggregationWithMissingValue() throws IOException {
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(100.0d)));
                    assertEquals("val011", result.getBuckets().get(1).getKeyAsString());
                indexWriter.addDocument(document);
    }
                                assertNestedTopHitsScore(terms, withScore);
                            .field("keyword")
                                    "val004",
                                    "val005",
        final Map<T, Long> counts = new HashMap<>();
            }
                        }
        }
                            StringTerms kAgg = jBucket.getAggregations().get("k");
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                    List<Map.Entry<T, Integer>> expectedBuckets = new ArrayList<>();
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val011")));
    }
    private <T extends InternalAggregation> T reduce(Aggregator agg) throws IOException {
                        .executionHint(executionHint)
                    aggregator.postCollection();
                    assertEquals("_name", result.getName());
        for (int i = 0; i < numTerms; i++) {
                    FieldType type = TextParams.buildFieldType(() -> true, () -> false, () -> "positions", () -> false, () -> "no");
                        assertThat(topHits.getHits().getHits().length, equalTo(1));
                        .field("string");
                        assertEquals("name2", result.getBuckets().get(2).getKeyAsString());
    }
                    AggregationExecutionException e = expectThrows(
                        }
                    for (int i = 0; i < 10; i++) {
                            .missing("no_nickname");
                        .field("string")
            new MultiBucketConsumerService.MultiBucketConsumer(
                        }
                    document.add(luceneFieldFactory.apply(entry.getKey()));
                indexWriter.addDocument(document);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.opensearch.search.SearchHit;
        Function<Integer, T> valueFactory,
                    aggregator.postCollection();
                    assertEquals("f", nestedBucket.getKeyAsString());
                        bucketOrder,
        document = new Document();
                document.add(new NumericDocValuesField("unrelated_value", 100));
        };
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
                    assertEquals(1L, result.getBuckets().get(5).getDocCount());
        aggregationBuilder.collectMode(Aggregator.SubAggCollectionMode.DEPTH_FIRST);
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
        );
                    for (int i = 0; i < size; i++) {
                        longField("i"),
                        assertEquals(3, result.getBuckets().size());
                    assertEquals(1L, result.getBuckets().get(0).getKey());
    }
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("mv_field");
                    assertEquals("val004", result.getBuckets().get(2).getKeyAsString());
import org.opensearch.script.ScriptType;
                    assertEquals(2, result.getBuckets().size());
                    assertEquals("val009", result.getBuckets().get(9).getKeyAsString());
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.LONG)
    }
    }
                    aggregator.preCollection();
        testSimple(ADD_SORTED_SET_FIELD_NOT_INDEXED, false, false, false, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);
                    assertEquals("b", result.getBuckets().get(2).getKeyAsString());
                            new TermsAggregationBuilder("j").field("j").subAggregation(new TermsAggregationBuilder("k").field("k"))
        assertThat(globalAgg.collectMode, equalTo(Aggregator.SubAggCollectionMode.DEPTH_FIRST));
                            LongTerms.Bucket jBucket = jAgg.getBucketByKey(Integer.toString(j));
                            .subAggregation(
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "a");
                            }
        }, (Consumer<InternalTerms>) terms -> { assertTrue(AggregationInspectionHelper.hasValue(terms)); }, fieldType);
                        );
            if (randomizeAggregatorImpl) {
        MappedFieldType stringFieldType,
                    BucketOrder bucketOrder = BucketOrder.aggregation("_max", order);
        when(mapper.typeText()).thenReturn(new Text("_doc"));
import org.opensearch.search.aggregations.support.ValueType;
            return b1.compareTo(b2);
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                for (Aggregator.SubAggCollectionMode mode : Aggregator.SubAggCollectionMode.values()) {
                        MultiBucketsAggregation.Bucket subBucket = subTerms.getBuckets().get(0);
                }
                addFieldConsumer.apply(document, "string", "b");
        final Map<T, Integer> filteredCounts = new HashMap<>();
                                InternalMultiBucketAggregation<?, ?> terms = result.getAggregations().get("terms");
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
     */
                        assertEquals("_name", result.getName());
                                    fieldType
                            ),
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                        assertEquals("no_nickname", result.getBuckets().get(0).getKeyAsString());
import java.io.IOException;
                // test text
                    assertEquals(5, result.getBuckets().size());
                        if (valueType == ValueType.IP) {
                addFieldConsumer.apply(document, "string", "a");
                        comparator = comparator.reversed();
                        .executionHint(executionHint)
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                } else {
        Document document = new Document();
        // now do the final reduce
        BiFunction<Double, Boolean, IndexableField> luceneFieldFactory = (val, mv) -> {
    public void testNumericIncludeExclude() throws Exception {
                    }
import org.opensearch.search.aggregations.bucket.filter.InternalFilter;
                MappedFieldType stringFieldType = new KeywordFieldMapper.KeywordFieldType("string");
                }
                    Terms result = reduce(aggregator);
                indexWriter.addDocument(document);
    @Override
                        result = ((Filter) reduce(aggregator)).getAggregations().get("_name2");
                    aggregator.postCollection();
    public void testThreeLayerLong() throws IOException {
        AggregationBuilder aggregationBuilder,
    public void testLongTermsAggregator() throws Exception {
                        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(
                indexWriter.addDocuments(documents);
                            writer.addDocument(d);
                        Terms result = reduce(aggregator);
                    aggregator.postCollection();
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
                        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                if (multiValued == false) {
                    assertEquals("val010", result.getBuckets().get(1).getKeyAsString());
            InternalAggregation.ReduceContext ctx = InternalAggregation.ReduceContext.forFinalReduction(
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                b -> {},
                    AggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(valueType)
import org.apache.lucene.index.IndexOptions;
                    }
        return DirectoryReader.open(directory);
                assertEquals(expected, buckets.get(0).getDocCount());
        aggregationBuilder.order(BucketOrder.aggregation("card", true));
                        "Invalid aggregation order path [script]. The provided aggregation [script] "
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            fieldType,
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            i -> base[0] = InetAddressPoint.nextUp(base[0]),
    ) throws IOException {
                        .executionHint(executionHint)
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.LONG)
    public void testStringTermsAggregator() throws Exception {
                final Directory dir;
                        .shardSize(size)
import org.opensearch.index.mapper.IpFieldMapper;
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, true, false, true, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType3);
                                null,
                        )
                Document document = new Document();
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                documents.add(document);
            ValueType.DOUBLE,
        try {
    protected <A extends Aggregator> A createAggregator(
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
                        aggregator.postCollection();
                    assertEquals("val004", result.getBuckets().get(4).getKeyAsString());
                    assertEquals(4, aggregator.getCollectCount().get());
                document = new Document();
                assertTrue(mergedAggs instanceof DoubleTerms);
        assertThat(globalAgg.collectMode, equalTo(Aggregator.SubAggCollectionMode.BREADTH_FIRST));
import static org.mockito.Mockito.when;
                    for (int j = 0; j < 10; j++) {
        testSimple(ADD_SORTED_SET_FIELD_NOT_INDEXED, false, false, true, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);
        try (Directory directory = newDirectory()) {
    public void testSimpleAggregationLowCardinality() throws Exception {
                    CountingAggregator aggregator = createCountingAggregator(aggregationBuilder, indexSearcher, false, fieldType);
                        .order(BucketOrder.key(true));
                return new SortedNumericDocValuesField("field", val);
                                    new FieldExistsQuery(PRIMARY_TERM_NAME),
                    aggregator.preCollection();
    }
            assertThat(topHits.getHits().getTotalHits().value(), equalTo((long) ptr));
                    String[] fieldNames = new String[] { "string", "long", "double" };
                    assertEquals("val007", result.getBuckets().get(3).getKeyAsString());
                    aggregator.preCollection();
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
                    result = reduce(aggregator);
                    List<Map.Entry<T, Long>> expectedBuckets = new ArrayList<>();
                        .field("long_field")
     */
 * Licensed to Elasticsearch under one or more contributor
                    assertEquals("val000", result.getBuckets().get(0).getKeyAsString());
                        Terms result = reduce(aggregator);
                            new TermsAggregationBuilder("_name2").userValueTypeHint(ValueType.STRING)
                document.add(new NumericDocValuesField("long_field", 2));
            }
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
                    aggregator.preCollection();
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    private void threeLayerStringTestCase(String executionHint) throws IOException {
                        fieldType.setFielddata(true);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        termsAggregator(ValueType.STRING, fieldType, i -> Integer.toString(i), String::compareTo, luceneFieldFactory);
                        }
                    TermsAggregationBuilder request = new TermsAggregationBuilder("i").field("i")
                .executionHint(executionMode.toString())
        return result;
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
                                .collectMode(randomFrom(Aggregator.SubAggCollectionMode.values()))
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                        .field("mv_field")
                                InternalNested result = searchAndReduce(
            try (
            }
                        .subAggregation(bucketScriptAgg);
                    document = new Document();
                        comparator = Comparator.comparing(Map.Entry::getValue);
 * Modifications Copyright OpenSearch Contributors. See
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
                                .executionHint(executionHint)
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
 * software distributed under the License is distributed on an
            TermsAggregatorFactory.REMAP_GLOBAL_ORDS = null;
                        .order(BucketOrder.key(true));
                        .subAggregation(
        }
                                    fieldType
                    assertEquals("val005", result.getBuckets().get(3).getKeyAsString());
                    Terms result = reduce(aggregator);
        }
                    assertEquals("_name", result.getName());
                dir.close();
                                .subAggregation(
        Function<T, IndexableField> luceneFieldFactory
                            assertThat(jBucket.getDocCount(), equalTo(10L));
                indexWriter.addDocument(document);
                    assertEquals("a", result.getBuckets().get(0).getKeyAsString());
                    assertEquals(1.0, result.getBuckets().get(0).getKey());
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
/*
                    assertEquals("val001", result.getBuckets().get(0).getKeyAsString());
    }
                                .field("field2")
                            assertEquals(expectedCount.longValue(), actual.getDocCount());
                        assertEquals("no_nickname1", result.getBuckets().get(0).getKeyAsString());
                    assertEquals("d", result.getBuckets().get(4).getKeyAsString());
            nonDeterministicScripts,
            .field("number")
        MappedFieldType... fieldTypes
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
                    aggregator.preCollection();
                                assertThat(kBucket.getDocCount(), equalTo(1L));
                            .field("mv_field")
    }
                indexWriter.addDocument(document);
    protected MapperService mapperServiceMock() {
                        );
        return new TermsAggregationBuilder("foo").field(fieldName);
                    InternalMultiBucketAggregation<?, ?> terms = result.getAggregations().get("terms");
                    document.clear();
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.LONG);
                        .order(BucketOrder.key(true));
 * SPDX-License-Identifier: Apache-2.0
                            if (entry2 != null && i < entry2.getValue()) {
    }
                        }
import java.util.Map;
                        aggregator.preCollection();
                        .executionHint(executionHint)
import org.opensearch.search.aggregations.metrics.InternalTopHits;
        aggregator.buildAggregations(new long[] { 0 });
                    ValueType[] valueTypes = new ValueType[] { ValueType.STRING, ValueType.LONG, ValueType.DOUBLE };
        indexWriter.addDocument(document);
                        new MatchAllDocsQuery(),
                                InternalNested nestedResult = result.getAggregations().get("nested");
                                document.add(new StringField("include", "yes", Field.Store.NO));
    public void testUsesGlobalOrdinalsByDefault() throws Exception {
     * This verifies the cardinality guard: with threshold=0, all documents must be visited via normal collection.
                Document document = new Document();
            val -> new NumericDocValuesField("field", Double.doubleToRawLongBits(val))
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
        globalAgg = (GlobalOrdinalsStringTermsAggregator) aggregator;
                    assertEquals(1L, result.getBuckets().get(9).getDocCount());
import org.apache.lucene.index.LeafReaderContext;
                            "nested_value",
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
                    aggregator.postCollection();
                    Comparator<Map.Entry<T, Integer>> comparator;
                    document.add(new SortedSetDocValuesField("mv_field2", new BytesRef("value1")));
    public void testWithNestedAggregations() throws IOException {
                        NestedAggregationBuilder nested = new NestedAggregationBuilder("nested", "nested_object").subAggregation(
                        .field("double_field")
            TermsAggregatorFactory.ExecutionMode.MAP,
        searcher.search(new MatchAllDocsQuery(), aggregator);
                                new String[] {
        }
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                    Terms result = reduce(aggregator);
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();
                    aggregator.postCollection();
                            new MatchAllDocsQuery(),
                document.add(new SortedDocValuesField("field2", new BytesRef("d")));
import static org.opensearch.index.mapper.SeqNoFieldMapper.PRIMARY_TERM_NAME;
                document.add(new NumericDocValuesField("long_field", 5));
                    fieldtype.setDocValuesType(DocValuesType.SORTED_SET);
                    assertEquals(2L, result.getBuckets().get(0).getDocCount());
                                assertThat(kBucket.getDocCount(), equalTo(1L));
                document.add(new SortedDocValuesField("keyword", new BytesRef("a")));
                        InternalTopHits topHits = subBucket.getAggregations().get("top_hits");
        scripts.put(STRING_SCRIPT_NAME, value -> STRING_SCRIPT_OUTPUT);
            int numLongs = randomIntBetween(1, 3);
import org.opensearch.search.aggregations.InternalAggregation;
                        .collectMode(collectionMode)
                GlobalOrdinalsStringTermsAggregator aggregator3 = createAndTestAggregator(indexSearcher, stringFieldType, 110);
                    aggregator.preCollection();
                            }
import org.opensearch.common.settings.Settings;
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        indexWriter.addDocument(document);
        TriConsumer<Document, String, String> addFieldConsumer,
                        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.LONG).field("long");
                    FieldType fieldtype = new FieldType(KeywordFieldMapper.Defaults.FIELD_TYPE);
    public void testThreeLayerStringViaMap() throws IOException {
        Map<String, Function<Map<String, Object>, Object>> nonDeterministicScripts = new HashMap<>();
                            d.add(new SortedNumericDocValuesField("i", i));
                                        withScore ? new ScoreSortBuilder() : new FieldSortBuilder("_doc")
            }
                    assertEquals(0, result.getBuckets().size());
        );
                document = new Document();
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "a");
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
                                Map.Entry<T, Integer> temp = entry1;
    private final SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                                    "val003",
            }
        try (Directory directory = newDirectory()) {
import static org.hamcrest.Matchers.instanceOf;
                indexWriter.addDocument(document);
                    assertEquals(1L, result.getBuckets().get(4).getDocCount());
                addFieldConsumer.apply(document, "string", "");
                    aggregator.postCollection();
                    LongTerms result = searchAndReduce(
        }
                document.add(new SortedDocValuesField("field1", new BytesRef("a")));
                    document.add(new NumericDocValuesField("value", entry.getValue()));
            TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = null;
                    assertEquals("a", result.getBuckets().get(1).getKeyAsString());
        aggregator = createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldType);
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("long_field", NumberFieldMapper.NumberType.LONG);
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                try (IndexReader reader = createIndexWithLongs()) {
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.DOUBLE).field("double");
                DEFAULT_MAX_BUCKETS,
                    ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "e");
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(1.0)));
        // Fields not indexed: cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited
import java.util.function.BiFunction;
            MockScriptEngine.NAME,
        final boolean includeDeletedDocumentsInSegment,
                        .includeExclude(
                    Terms result = reduce(aggregator);
                    document = new Document();
                    }
        }
                indexWriter.addDocument(document);
                }
    }
                            .field(fieldNames[i])
        );
    }
import org.apache.lucene.document.BinaryDocValuesField;
                        .size(size)
                    random(),
                    Terms result = reduce(aggregator);
                    Terms result = reduce(aggregator);
                addFieldConsumer.apply(document, "string", "b");
                    indexWriter.addDocuments(documents);
                    TermsAggregatorFactory.REMAP_GLOBAL_ORDS = false;
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
                    assertEquals(1, result.getBuckets().size());
        int size
        ValueType valueType,
                    Object[] missingValues = new Object[] { "abc", 19L, 19.2 };
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name1").userValueTypeHint(ValueType.STRING)
                    IndexSearcher searcher = new IndexSearcher(reader);
                    MappedFieldType fieldType2 = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                document = new Document();
                document.add(new SortedDocValuesField("field2", new BytesRef("b")));
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, false, true, true, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);
        IndexSearcher indexSearcher,
                documents.add(document);
        );
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                            indexWriter.addDocument(document);
        document.add(new SortedNumericDocValuesField("number", 1));
                            if (entry1.getValue().compareTo(entry2.getValue()) < 0) {
    }
                        aggregator.preCollection();
                        .field("sv_field")
                        Terms result = reduce(aggregator);
                indexWriter.commit();
                                filteredCounts.computeIfPresent(entry.getKey(), (key, integer) -> integer + 1);
                indexWriter.addDocument(document);
                document = new Document();
                document = new Document();
                        assertEquals("_name", result.getName());
        assertThat(globalAgg.descriptCollectionStrategy(), equalTo("dense"));
    protected <A extends Aggregator> A createAggregator(
        aggregator = createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldType);
import java.util.concurrent.atomic.AtomicInteger;
            randomBoolean(),
                document.add(new NumericDocValuesField("long_field", 1));
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(100.0d)));
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
            }
                                    new FieldExistsQuery(PRIMARY_TERM_NAME),
            return super.createAggregator(aggregationBuilder, indexSearcher, fieldTypes);
                    TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = false;
    }
                    Aggregator.SubAggCollectionMode collectionMode = randomFrom(Aggregator.SubAggCollectionMode.values());
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val010")));
        );
                            for (int k = 0; k < 10; k++) {
                            } else {
                        bucketOrder = BucketOrder.key(order);
                    }
                    Terms result = reduce(aggregator);
                    );
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            final int numDocs = 10;
                indexWriter.addDocument(document);
                document = new Document();
                        Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType1);
    private <T> void termsAggregatorWithNestedMaxAgg(
            final BinaryDocValuesField field = new BinaryDocValuesField(fieldName, rangeType.encodeRanges(Collections.singleton(range)));
                    assertEquals("val003", result.getBuckets().get(3).getKeyAsString());
    }
    ) throws IOException {
                        StringTerms jAgg = iBucket.getAggregations().get("j");
                                DEFAULT_MAX_BUCKETS,
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        }
        DocumentMapper mapper = mock(DocumentMapper.class);
                Document document = new Document();
                    result = reduce(aggregator);
                    assertEquals("val003", result.getBuckets().get(1).getKeyAsString());
                        .field("mv_field")
            }
        BiFunction<InetAddress, Boolean, IndexableField> luceneFieldFactory = (val, mv) -> {
                    Iterator<Map.Entry<T, Integer>> iterator = counts.entrySet().iterator();
                        .executionHint(executionHint)
                    documents.add(document);
import org.apache.lucene.document.LatLonDocValuesField;
                        assertEquals("name2", result.getBuckets().get(2).getKeyAsString());
            i -> Integer.toString(i),
import org.opensearch.index.mapper.NestedPathFieldMapper;
                {
                        keywordField("j"),
                                .order(BucketOrder.key(true))
            } else {
            if (mv) {
                    assertEquals(1L, result.getBuckets().get(4).getDocCount());
                MappedFieldType fieldType1 = new KeywordFieldMapper.KeywordFieldType("string");
        final boolean includeDocCountField,
        // Fields indexed, no deleted documents, but _doc_field value present in document:
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                        assertEquals("name1", result.getBuckets().get(1).getKeyAsString());
            } else {
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field");
import static org.mockito.Mockito.mock;
            ),
            counts.put(valueFactory.apply(i), randomLong());
            }
    }
        termsAggregatorWithNestedMaxAgg(
            ValueType.STRING,
                assertEquals("select_all", aggregator3.getResultSelectionStrategy());
                                    "val008",
                .field("number")
                        }
                document = new Document();
        // Infers depth_first because the maxOrd is 0 which is less than the size
        try (Directory dir = newDirectory()) {
                                .field("field")
        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
                    MappedFieldType fieldType1 = new KeywordFieldMapper.KeywordFieldType("field1");
    private static final String STRING_SCRIPT_OUTPUT = "Orange";
    public void testNestedTermsAgg() throws Exception {
                    document = new Document();
                            new TermsAggregationBuilder("j").field("j")
            }
            }
                    document.add(new Field("mv_field", "name1", type));
                        StringTerms.Bucket iBucket = result.getBucketByKey(Integer.toString(i));
                List<Document> documents = new ArrayList<>();
                    assertThat(terms.getBuckets().size(), equalTo(3));
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
            aggregationBuilder,
        try (Directory directory = newDirectory()) {
                    AggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(valueType)
        termsAggregator(ValueType.DOUBLE, fieldType, Integer::doubleValue, Double::compareTo, luceneFieldFactory);
        // cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited
 * not use this file except in compliance with the License.
                        .field("double_field")
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;
            }
    }
                if (includeDocCountField) {
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.apache.lucene.search.TotalHits;
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
                            for (int k = 0; k < 10; k++) {
                                    nested,
                    result = reduce(aggregator);
                return new SortedSetDocValuesField("field", new BytesRef(InetAddressPoint.encode(val)));
                                    .order(BucketOrder.key(true))
                            document.add(luceneFieldFactory.apply(entry1.getKey(), true));
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.opensearch.search.sort.FieldSortBuilder;
    }
                        } else {
    private List<Document> generateDocsWithNested(String id, int value, int[] nestedValues) {
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
            indexSearcher,
import java.net.InetAddress;
                Document document = new Document();
        AggregationBuilder aggregationBuilder,
                        searcher,
                    for (int i = 0; i < fieldNames.length; i++) {
        BiFunction<T, Boolean, IndexableField> luceneFieldFactory
        }
                        assertEquals(0, result.getBuckets().size());
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, STRING_SCRIPT_NAME, Collections.emptyMap()));
        return Collections.unmodifiableList(
import org.opensearch.index.mapper.TextFieldMapper;
                }
        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field("string").size(size);
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                assertThat(topHits.getHits().getMaxScore(), equalTo(1f));
        IndexSearcher indexSearcher,
                    assertEquals(2, result.getBuckets().size());
        assertThat(terms.getBuckets().size(), equalTo(9));
                    assertEquals(5, result.getBuckets().size());
                    aggregator.postCollection();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        MockScriptEngine scriptEngine = new MockScriptEngine(
import org.opensearch.index.mapper.MapperService;
            document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
            final RangeFieldMapper.Range range = new RangeFieldMapper.Range(rangeType, start, end, true, true);
        Directory directory = newDirectory();
        try (Directory directory = newDirectory()) {
            }
                    aggs.add(buildInternalAggregation(aggregationBuilder, fieldType, searcher));
                            new MultiBucketConsumerService.MultiBucketConsumer(
import org.opensearch.index.mapper.KeywordFieldMapper;
                            if (randomBoolean()) {
                    aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType2);
        // Fields not indexed: cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited
        ValueType valueType,
            4
                    assertEquals("val007", result.getBuckets().get(7).getKeyAsString());
                    GlobalAggregationBuilder globalBuilder = new GlobalAggregationBuilder("global").subAggregation(
                leafCollector.collect(docId, 0); // collect with bucket ordinal 0 (root bucket)
        document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE));
                        .includeExclude(new IncludeExclude(new double[] { 0.0, 5.0 }, null))
        return aggregator;
            PipelineTree.EMPTY
        );
    }
 */
import org.opensearch.search.aggregations.pipeline.BucketScriptPipelineAggregationBuilder;
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    new SortedSetDocValuesField("field", new BytesRef(InetAddressPoint.encode(InetAddresses.forString("192.168.100.42"))))
        }
 *
            }
                    TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = collectSegmentOrds;
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("keyword");
                Document document = new Document();
            final String fieldName = "field";
            }
                        Map.Entry<T, Integer> expected = expectedBuckets.get(i);
            getMockScriptService(),
        for (LeafReaderContext ctx : searcher.getIndexReader().leaves()) {
import org.opensearch.search.aggregations.AggregationExecutionException;
import org.apache.lucene.index.IndexReader;
                        comparator = comparator.reversed();
                TermsAggregatorFactory.REMAP_GLOBAL_ORDS = randomBoolean();
        Document document = new Document();
                List<? extends Terms.Bucket> buckets = ((DoubleTerms) mergedAggs).getBuckets();
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                        comparator = comparator.thenComparing(Comparator.comparing(Map.Entry::getKey, keyComparator));
                    indexWriter.addDocuments(documents);
    public void testUnmappedWithMissing() throws Exception {
                document.add(new NumericDocValuesField("long_field", 4));
        }
    @Override
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
import org.opensearch.index.mapper.MappedFieldType;
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
        throws IOException {
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
                        MappedFieldType filterFieldType = new KeywordFieldMapper.KeywordFieldType("include");
                    assertEquals("c", result.getBuckets().get(3).getKeyAsString());
 *
        try (Directory directory = newDirectory()) {
            }
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    for (int i = 0; i < size; i++) {
    }
                    aggregator.preCollection();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
import org.apache.lucene.document.SortedSetDocValuesField;
                            assertEquals(String.valueOf(expected.getKey()).substring(1), actual.getKey());
                        assertEquals(1L, result.getBuckets().get(2).getDocCount());
import org.opensearch.search.aggregations.bucket.nested.InternalNested;
                }
import org.opensearch.search.sort.ScoreSortBuilder;
        }
                }
                for (int i = 0; i < 10; i++) {
 * You may obtain a copy of the License at
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val003")));
                }
import org.opensearch.common.TriConsumer;
                                    .executionHint(executionHint)
    }
    }
            }
                        .order(BucketOrder.key(true));
                    }
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val005")));
                }
                for (Map.Entry<T, Long> entry : counts.entrySet()) {
        );
                        AggregationExecutionException.class,
     * @param expectedCollectCount expected number of documents visited as part of collect() invocation
                    assertEquals(1L, result.getBuckets().get(0).getDocCount());
        };
                        longField("k")
import org.opensearch.common.util.MockBigArrays;
        MappedFieldType fieldType,
                    expectedBuckets.addAll(counts.entrySet());
                    for (MultiBucketsAggregation.Bucket bucket : terms.getBuckets()) {
        }
                    }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
                    aggregator.preCollection();
                new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
                document = new Document();
                    aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.DOUBLE)
                    assertEquals("val007", result.getBuckets().get(5).getKeyAsString());
        indexReader.close();
                    document.add(new Field("mv_field", "name2", type));
                    // so all 4 documents must be visited via normal collection
                    indexWriter.addDocuments(generateDocsWithNested(Integer.toString(i), i, nestedValues));
                        aggregationBuilder = new FilterAggregationBuilder("_name1", QueryBuilders.termQuery("include", "yes"));
                indexWriter.addDocument(document);
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
                    result = reduce(aggregator);
                    } else {
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
                    result = reduce(aggregator);
        threeLayerStringTestCase("global_ordinals");
                document.add(new SortedDocValuesField("keyword", new BytesRef("e")));
        document = new Document();
                    indexWriter.addDocument(document);
                        }
                    BucketOrder bucketOrder;
            --ptr;
            final String field = "field";
                        .executionHint(executionHint)
                long expected = numLongs + numDoubles;
                    if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to
                    }
                    assertEquals(1L, result.getBuckets().get(1).getDocCount());
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                            {
        try (Directory directory = newDirectory()) {
            dataSet.add("value" + i);
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        .includeExclude(new IncludeExclude(null, "val00.+"))
                    fieldtype.setStored(true);
                            }
        // We do not use LuceneTestCase.newSearcher because we need a DirectoryReader
                    CountingAggregator aggregator = new CountingAggregator(
    }
                MappedFieldType fieldType2 = new NumberFieldMapper.NumberFieldType("long", NumberFieldMapper.NumberType.LONG);
                    newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE)
                    indexWriter.deleteDocuments(new Term("string", "e"));
                        .includeExclude(new IncludeExclude(null, new long[] { 0, 5 }))
            if (withScore) {
                indexWriter.addDocument(document);
                    aggregator.preCollection();
                    assertEquals(1L, result.getBuckets().get(6).getDocCount());
                    TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                                    .subAggregation(new TopHitsAggregationBuilder("top_hits").storedField("_none_"))
                }
                            Integer expectedCount;
                        .order(BucketOrder.key(true));
                    assertEquals(1L, result.getBuckets().get(7).getDocCount());
        for (int i = 0; i < 100; i++) {
    private IndexReader createIndexWithDoubles() throws IOException {
                        );
                                    "val002",
                        }
import org.apache.lucene.search.MatchAllDocsQuery;
            createIndexSettings(),
        IndexSearcher indexSearcher,
                    int size = randomIntBetween(1, counts.size());
                // Case 1: PriorityQueue selection, when buckets > size && buckets <= 5*size (size=2, buckets=100)
                document = new Document();
                        .includeExclude(new IncludeExclude("val00.+", null))
            new AtomicInteger(),
                        assertEquals(2L, result.getBuckets().get(0).getDocCount());
                addFieldConsumer.apply(document, "string", "d");
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        assertEquals(expected.getKey(), actual.getKey());
                document = new Document();
    }
                assertEquals("priority_queue", aggregator1.getResultSelectionStrategy());
                    InternalGlobal result = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), globalBuilder, fieldType);
                        new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING)
                // test keyword
    ) throws IOException {
                        aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType, filterFieldType);
    public void testGeoPointField() throws Exception {
                    }
        try (Directory directory = newDirectory()) {
 * GitHub history for details.
        int numTerms = scaledRandomIntBetween(8, 128);
                            assertThat(hit.getScore(), greaterThan(0f));
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
                        .includeExclude(new IncludeExclude(new String[] { "val000", "val010" }, null))
import java.util.ArrayList;
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(3.0)));
import java.util.Comparator;
            asList(
 */
import org.opensearch.search.aggregations.BucketOrder;
 * under the License.
                if (includeDeletedDocumentsInSegment) {
     * @param executionMode execution mode MAP or GLOBAL_ORDINALS
                )
                    assertEquals(5, indexWriter.getDocStats().maxDoc);  // deleted document still in segment
                        ).field("mv_field1").missing("no_nickname1");
                    indexWriter.flush();
                }
                        .field("mv_field")
                document = new Document();
            try (
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        testSimple(ADD_SORTED_SET_FIELD_INDEXED, true, false, false, TermsAggregatorFactory.ExecutionMode.GLOBAL_ORDINALS, 4);
                }
                final Directory dir;
        final Map<T, Integer> counts = new HashMap<>();
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
 * specific language governing permissions and limitations
                            NumberFieldMapper.NumberType.LONG
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val007")));
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
        }
                                expectedCount = filteredCounts.get(InetAddresses.forString((String) actual.getKey()));
                    StringTerms result = searchAndReduce(
                }
                    for (int j = 0; j < 10; j++) {
        MappedFieldType... fieldTypes
import org.opensearch.search.aggregations.LeafBucketCollector;
                        .field("string")
        return mapperService;
    }
                )
                                    "val011" }
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
                    assertEquals(2, result.getBuckets().size());
                    indexWriter.addDocument(document);
import org.opensearch.search.aggregations.support.ValuesSourceType;
                        Terms result = reduce(aggregator);
                            assertEquals(expected.getKey(), actual.getKey());
        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
                        collectionMode
                    document.add(new StringField("string", value, Field.Store.NO));
            fieldType,
    ) throws IOException {
                    }
            searchContext -> when(searchContext.bucketSelectionStrategyFactor()).thenReturn(5),
                document = new Document();
    /**
                        assertEquals(2L, result.getBuckets().get(0).getDocCount());
        MapperService mapperService = mock(MapperService.class);
            }
     * This is a utility method to test out string terms aggregation
                indexWriter.addDocument(document);
        aggregator.preCollection();
                    aggregator.postCollection();
        );
                    document.add(new SortedSetDocValuesField("mv_field1", new BytesRef("name1")));
                CoreValuesSourceType.IP,
                    boolean order = randomBoolean();
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
import java.util.function.Function;
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                document.add(new NumericDocValuesField("double_field", Double.doubleToRawLongBits(4.0)));
import org.opensearch.core.common.breaker.CircuitBreaker;
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();
                        bucketOrder = BucketOrder.compound(BucketOrder.count(order), BucketOrder.key(order));
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                                .collectMode(collectionMode)
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
        testSimple(
        IndexReader indexReader = DirectoryReader.open(directory);
                    document.add(new NumericDocValuesField("_doc_count", 10));
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(1000.0d)));
                    aggregator.postCollection();
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        assertThat(globalAgg.descriptCollectionStrategy(), equalTo("remap"));
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val008")));
        documents.add(document);
import java.util.List;
    protected List<String> unsupportedMappedFieldTypes() {
                                new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
    }
import org.apache.lucene.document.Field;
                    aggregator.preCollection();
import org.opensearch.search.aggregations.bucket.filter.Filter;
        return List.of(HllFieldMapper.CONTENT_TYPE);
                        assertEquals(1, result.getBuckets().size());
                    while (iterator.hasNext()) {
    protected ScriptService getMockScriptService() {
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val005")));
                        .order(bucketOrder);
                    Terms result = reduce(aggregator);
            int numDoubles = randomIntBetween(1, 3);
                            + "either does not exist, or is a pipeline aggregation and cannot be used to sort the buckets.",
                    directory,
            }
    public void testTermFrequencyCardinalityGuard() throws Exception {
        }
        for (int nestedValue : nestedValues) {
                document.add(new SortedDocValuesField("keyword", new BytesRef("c")));
                        .subAggregation(
            if (mv) {
                CoreValuesSourceType.NUMERIC,
                return new SortedNumericDocValuesField("field", Double.doubleToRawLongBits(val));
                        .executionHint(executionHint)
                    aggregator.postCollection();
                    MappedFieldType fieldType = new GeoPointFieldMapper.GeoPointFieldType("field");
        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(valueTypes[i])
                }
                        if (randomBoolean() && iterator.hasNext()) {
            } else {
                            d.add(new SortedDocValuesField("i", new BytesRef(Integer.toString(i))));
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field(field);
                    aggs.add(buildInternalAggregation(aggregationBuilder, fieldType, searcher));
                        .order(BucketOrder.key(true));
                        .field("field")
    }
                        for (SearchHit hit : topHits.getHits()) {
                    indexWriter.addDocument(document);
                            LongTerms kAgg = jBucket.getAggregations().get("k");
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "c");
                for (String value : dataSet) {
                        for (int k = 0; k < 10; k++) {
        indexWriter.close();
                        }
                    aggregator.postCollection();
                    aggregator.postCollection();
                        .includeExclude(new IncludeExclude(null, new double[] { 0.0, 5.0 }))
            new MatchAllDocsQuery(),
                    if (includeDocCountField) {
                return new NumericDocValuesField("field", val);
        BiFunction<String, Boolean, IndexableField> luceneFieldFactory = (val, mv) -> {
                    expectedBuckets.addAll(counts.entrySet());
                    assertEquals("val010", result.getBuckets().get(1).getKeyAsString());
                        Terms.Bucket actual = result.getBuckets().get(i);
            GeoPoint point = RandomGeoGenerator.randomPoint(random());
        document = new Document();
        Directory directory = newDirectory();
                        for (int i = 0; i < entry.getValue(); i++) {
            assertEquals(TotalHits.Relation.EQUAL_TO, topHits.getHits().getTotalHits().relation());
        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("name").userValueTypeHint(ValueType.STRING)
                                    // match root document only
                                document.add(luceneFieldFactory.apply(entry2.getKey(), true));
                    assertEquals(5, result.getBuckets().size());
                PipelineTree.EMPTY
                        searcher,
                    aggregator.postCollection();
     * This test case utilizes the LowCardinality implementation of GlobalOrdinalsStringTermsAggregator since collectSegmentOrds is true
 * KIND, either express or implied.  See the License for the
                    document = new Document();
                    assertEquals(0.0, result.getBuckets().get(0).getKey());
        } finally {
            randomBoolean(),
                return new SortedSetDocValuesField("field", new BytesRef(val));
                document.add(new SortedDocValuesField("field2", new BytesRef("f")));
                        Terms.Bucket actual = result.getBuckets().get(i);
                        assertEquals(1L, result.getBuckets().get(1).getDocCount());
    private void assertNestedTopHitsScore(InternalMultiBucketAggregation<?, ?> terms, boolean withScore) {
                        .executionHint(executionHint)
                    assertEquals("val010", result.getBuckets().get(0).getKeyAsString());
            final String field = "field";
    }
                    assertEquals(1L, result.getBuckets().get(4).getDocCount());
            }
        try (Directory directory = newDirectory()) {
                                .executionHint(executionHint)
                Document document = new Document();
                    assertEquals(2.0, result.getBuckets().get(1).getKey());
import org.opensearch.script.Script;
        }
                List<Document> documents = new ArrayList<>();
                RandomIndexWriter indexWriter = new RandomIndexWriter(
                ADD_SORTED_SET_FIELD_INDEXED.apply(document, "string", "");
                    assertEquals("_name", result.getName());
    public void testIpField() throws Exception {
                    aggregator.preCollection();
                indexWriter.addDocument(document);
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").field(fieldName);
                        Map.Entry<T, Integer> entry2 = null;
                    assertEquals("val002", result.getBuckets().get(2).getKeyAsString());
                    newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE)
                    assertEquals(2L, result.getBuckets().get(1).getDocCount());
                    // With threshold=0, tryCollectFromTermFrequencies should bail out,
                                assertNestedTopHitsScore(terms, withScore);
                        TextFieldMapper.TextFieldType fieldType = new TextFieldMapper.TextFieldType("mv_field");
                                )
                    indexWriter.addDocument(document);
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
    public void testNumberToStringValueScript() throws IOException {
                dir.close();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                }
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.bucketScript;
                        assertEquals("name1", result.getBuckets().get(1).getKeyAsString());
}
                            new IncludeExclude(
        assertThat(globalAgg.descriptCollectionStrategy(), equalTo("dense"));
                document.add(new SortedSetDocValuesField("mv_field", new BytesRef("val007")));
                    aggregator.preCollection();
import org.apache.lucene.document.StringField;
    ) throws Exception {
        return aggregator.buildTopLevel();
                        assertEquals(3, result.getBuckets().size());
                    nestedBucket = ((Terms) result.getBuckets().get(2).getAggregations().get("_name2")).getBuckets().get(0);
                        for (int j = 0; j < 10; j++) {
                        for (int j = 0; j < 10; j++) {
                    int[] nestedValues = new int[i];
                    assertEquals("val005", result.getBuckets().get(2).getKeyAsString());
            .field("string");
import org.opensearch.index.mapper.RangeType;
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
        return DirectoryReader.open(directory);
import org.opensearch.index.mapper.NumberFieldMapper;
        indexWriter.close();
                    document.add(new SortedSetDocValuesField("mv_field1", new BytesRef("name2")));
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
                                    .field("keyword")
                    aggregator.preCollection();
        );
            createAggregator(aggregationBuilder, indexSearcher, randomizeAggregatorImpl, fieldTypes)
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                for (int i = 0; i < 10; i++) {
                document.add(new NumericDocValuesField("long_field", 0));
    }
            }
     * @param collectSegmentOrds collect segment ords or not - set true to utilize LowCardinality implementation for GlobalOrdinalsStringTermsAggregator
        aggregationBuilder.collectMode(Aggregator.SubAggCollectionMode.BREADTH_FIRST);
                    assertEquals(1L, result.getBuckets().get(5).getDocCount());
                }
                    } else {
                    for (boolean withScore : new boolean[] { true, false }) {
                        .field("field1")
                    indexWriter.deleteAll();
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();
     * When termsAggregationMaxPrecomputeCardinality is set to 0, tryCollectFromTermFrequencies should bail out
                        keywordField("i"),
                    assertEquals(5L, result.getBuckets().get(1).getKey());
                indexWriter.addDocument(document);
                        .field("long_field")
    }
import org.opensearch.search.aggregations.AggregationBuilders;
        collectDocuments(indexSearcher, aggregator);
                    }
        boolean randomizeAggregatorImpl = false;
                            aggregationBuilder,
        indexWriter.close();
    }
        BiFunction<Long, Boolean, IndexableField> luceneFieldFactory = (val, mv) -> {
            Collections.emptyMap()
            ValueType.IP,
    private GlobalOrdinalsStringTermsAggregator createAndTestAggregator(
                                    newSearcher(indexReader, false, true),
     * @param addFieldConsumer a function that determines how a field is added to the document
                    TermsAggregationBuilder request = new TermsAggregationBuilder("i").field("i")
    /**
                    if (order == false) {
package org.opensearch.search.aggregations.bucket.terms;
            for (int i = 0; i < numDocs; i++) {
                    Document document = new Document();
                    Terms result = reduce(aggregator);
                            }
        }
import static org.hamcrest.Matchers.equalTo;
        document.add(new SortedNumericDocValuesField("number", NumericUtils.doubleToSortableLong(1.0d)));
                document.add(new SortedDocValuesField("sv_field", new BytesRef("val001")));
        document.add(new SortedNumericDocValuesField("number", 10));
 * compatible open source license.
        // cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited
                            Document document = new Document();
                    // Note - other places we throw IllegalArgumentException
                    assertEquals(
                    assertEquals(1L, result.getBuckets().get(2).getDocCount());
                document = new Document();
            randomBoolean(),
            }
        try (Directory directory = newDirectory()) {
                    ValueType[] valueTypes = new ValueType[] { ValueType.STRING, ValueType.LONG, ValueType.DOUBLE };
                GlobalOrdinalsStringTermsAggregator aggregator2 = createAndTestAggregator(indexSearcher, stringFieldType, 20);
                // Case 3: Get All buckets when buckets <= size (size=110, buckets=100)
                        }
                {
import org.apache.lucene.index.IndexableField;
                    assertEquals("d", nestedBucket.getKeyAsString());
                        .executionHint(executionHint)
    /**
                            searchContext -> when(searchContext.termsAggregationMaxPrecomputeCardinality()).thenReturn(0L),
                        );
                    assertEquals("e", result.getBuckets().get(2).getKeyAsString());
                        LongTerms jAgg = iBucket.getAggregations().get("j");
import org.opensearch.search.aggregations.AggregationBuilder;
                    result = reduce(aggregator);
                    assertEquals("c", result.getBuckets().get(1).getKeyAsString());
import org.opensearch.common.geo.GeoPoint;
                        int expectedFilteredCounts = 0;
import org.opensearch.test.geo.RandomGeoGenerator;
            agg.context().bigArrays(),
                }
        // Fields indexed, no deleted documents, but _doc_field value present in document:
                    assertEquals(1L, result.getBuckets().get(3).getDocCount());
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                indexWriter.addDocument(document);
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
                    TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(ValueType.STRING)
                        .includeExclude(new IncludeExclude("val00.+", "(val000|val001)"))
                    result = reduce(aggregator);
        // Fields indexed, deleted documents in segment: cannot use LeafBucketCollector#termDocFreqCollector - all documents are visited
                    Document document = new Document();
                document.add(new SortedDocValuesField("field1", new BytesRef("e")));
                        new AtomicInteger(),
            Integer.MAX_VALUE,
                    indexWriter.addDocument(document);
                for (int i = 0; i < 10; i++) {
                        );
                documents.add(document);
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (Directory dir = newDirectory()) {
                    assertEquals("b", result.getBuckets().get(2).getKeyAsString());
        }
                assertEquals(expected * 2, buckets.get(2).getDocCount());
                                    filter,
                addFieldConsumer.apply(document, "string", "c");
        };
            reduceBucketConsumer,
                    );
            BytesRef b2 = new BytesRef(InetAddressPoint.encode(o2));
        document.add(new SortedNumericDocValuesField("number", 100));
    ) throws Exception {
                        .size(size)
                    assertEquals(expectedCollectCount, aggregator.getCollectCount().get());
                        .order(BucketOrder.key(true));
        indexWriter.addDocument(document);
import org.apache.lucene.store.Directory;
                                InternalFilter result = searchAndReduce(
                        aggregator.preCollection();
                    MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);
                            .field(fieldNames[i]);
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("string");
                Document document = new Document();
                                entry1 = entry2;
        T result = (T) topLevel.reduce(Collections.singletonList(topLevel), context);
                    expectThrows(IllegalArgumentException.class, () -> { createAggregator(aggregationBuilder, indexSearcher, fieldType); });
import org.opensearch.index.mapper.DocumentMapper;
                assertEquals(expected, buckets.get(3).getDocCount());
    }
                TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = randomBoolean();
                assertEquals("1000.0", buckets.get(3).getKeyAsString());
import org.apache.lucene.document.SortedNumericDocValuesField;
                documents.add(document);
                    assertEquals(3.0, result.getBuckets().get(2).getKey());
import java.util.Collections;
                    String executionHint = randomFrom(TermsAggregatorFactory.ExecutionMode.values()).toString();
            int numDocs = scaledRandomIntBetween(2, 32);
                    if (multiValued == false) {
        try (Directory directory = newDirectory()) {
                        comparator = Comparator.comparing(Map.Entry::getKey, keyComparator);
 * Unless required by applicable law or agreed to in writing,
        when(mapper.type()).thenReturn("_doc");
        assertThat(globalAgg.descriptCollectionStrategy(), equalTo("remap"));
                                new TermsAggregationBuilder("sub_terms").userValueTypeHint(ValueType.STRING)
                    assertEquals("val009", result.getBuckets().get(7).getKeyAsString());
     */
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
/*
                        new MatchAllDocsQuery(),
            boolean multiValued = randomBoolean();
    @Override
                    for (int i = 0; i < 10; i++) {
    public void testStringIncludeExclude() throws Exception {
                    logger.info(
                            writer.addDocument(d);
        aggregator.postCollection();
        );
            ) {
                                .field("nested_value")
                        for (Integer count : filteredCounts.values()) {
        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
import org.opensearch.index.mapper.RangeFieldMapper;
        MappedFieldType fieldType,
     * even when all other conditions are met (indexed fields, no deletions, no _doc_count).
                                FilterAggregationBuilder filter = new FilterAggregationBuilder("filter", new MatchAllQueryBuilder())
                                expectedCount = filteredCounts.get(actual.getKey());
            double start = randomDouble();
                return new SortedDocValuesField("field", new BytesRef(val));
                            )
        }
                        assertThat(iBucket.getDocCount(), equalTo(100L));
                                .executionHint(executionHint)
                }
        Function<Integer, T> valueFactory,
    // Constants for a script that returns a string
    }
    private <T> void termsAggregator(
import org.apache.lucene.search.IndexSearcher;
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
                    if (order == false) {
        document.add(new SortedNumericDocValuesField("value", value));
    public void testEmpty() throws Exception {
                documents.add(document);
                indexWriter.addDocument(document);
                    assertTrue(AggregationInspectionHelper.hasValue((InternalTerms) result));
import org.apache.lucene.util.NumericUtils;
            List<InternalAggregation> aggs = new ArrayList<>();
                        )
                    indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            Integer::doubleValue,
                        .shardSize(size)
                }
                    for (int i = 0; i < fieldNames.length; i++) {
                    Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        }
                    MappedFieldType fieldType = new IpFieldMapper.IpFieldType("field");
                    aggregator.postCollection();
                indexWriter.addDocument(document);
                    assertEquals(4, result.getBuckets().size());
                    assertEquals("val006", result.getBuckets().get(4).getKeyAsString());
        return createAggregator(aggregationBuilder, indexSearcher, true, fieldTypes);
                return new NumericDocValuesField("field", Double.doubleToRawLongBits(val));
        }
                                    "val001",
                                InternalMultiBucketAggregation<?, ?> terms = nestedResult.getAggregations().get("terms");
                assertEquals("10.0", buckets.get(1).getKeyAsString());
