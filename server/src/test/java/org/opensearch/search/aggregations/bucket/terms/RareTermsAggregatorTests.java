                            for (MultiBucketsAggregation.Bucket bucket : terms.getBuckets()) {
                return searchAndReduce(indexSearcher, query, aggregationBuilder, types);
            assertThat(bucket.getDocCount(), equalTo(1L));  
            assertThat(bucket.getKey(), equalTo(1L));  
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;  
        try (Directory directory = newDirectory()) {
                        nestedValues[j] = j;  
                        assertEquals(2L, result.getBuckets().get(2).getDocCount());
            TermsAggregationBuilder terms = new TermsAggregationBuilder("the_terms").field(KEYWORD_FIELD);
                    indexWriter.flush();
        );
            assertThat(bucket.getKeyAsString(), equalTo("0"));
    public void testMatchAllDocs() throws IOException {  
            Collections.emptyList(),
                    new RareTermsAggregationBuilder("terms").field("nested_value").maxDocCount(1)
                            );
            agg -> assertEquals(0, agg.getBuckets().size())
import org.apache.lucene.document.SortedDocValuesField;  
        testSearchCase(query, d, aggregation -> aggregation.field(LONG_FIELD).maxDocCount(1), agg -> {
            agg -> assertEquals(0, agg.getBuckets().size()),  
        verify.accept(executeTestCase(query, dataset, aggregationBuilder));  
        when(mapper.typeText()).thenReturn(new Text("_doc"));
                        aggregator.preCollection();
                        indexSearcher.search(new MatchAllDocsQuery(), rareTermsAggregator);
                    longField(LONG_FIELD),  
            aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1),
import org.opensearch.common.settings.Settings;
                    document = new Document();
                        fieldType
    public void testIncludeExclude() throws IOException {
        List<Long> d = new ArrayList<>(500);
import static org.hamcrest.Matchers.equalTo;
            agg -> assertEquals(0, agg.getBuckets().size())
                        InternalMultiBucketAggregation<?, ?> subTerms = bucket.getAggregations().get("sub_terms");
        testSearchCase(
                indexWriter.addDocument(document);
            dataset,  
            query,
            document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));  
                        if (withScore) {  
        testSearchCase(
                    indexWriter.addDocument(document);
         * Because the incremental reduction test picks random subsets to reduce together, it's impossible
    private void testSearchCaseIndexString(
        testSearchCase(
                        aggregator.postCollection();  
        DocumentMapper mapper = mock(DocumentMapper.class);  
                    indexWriter.addDocument(document);
        Consumer<InternalMappedRareTerms<?, ?>> verify,
                assertThat(bucket.getKeyAsString(), equalTo("2"));
                            .subAggregation(
        /*  
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;  
        List<Long> dataset,
                // test keyword
                                assertThat(hits.value(), equalTo(counter));
                    Document document = new Document();
            AggregationBuilder builder = new TermsAggregationBuilder("terms").field("even_odd")
            aggregation -> aggregation.field(LONG_FIELD).maxDocCount(1),
                return searchAndReduceCounting(expectedCount, null, indexSearcher, query, aggregationBuilder, -1, false, false, types);
                    try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
                    );
        }, agg -> {  
                        Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType1, fieldType2);  
         * This can be done during incremental reduces, and the final reduce.  Unfortunately, the number of buckets
        testSearchCase(
            agg -> {
            aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1),
                }
                    document = new Document();  
        MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(  
            assertThat(bucket.getKey(), equalTo(1L));
        List<Long> dataset,
import org.opensearch.index.mapper.SeqNoFieldMapper;  
    public void testBucketInTermsAggregationWithMissingValue() throws IOException {
                        new RareTermsAggregationBuilder("terms").field("nested_value")
        }
                StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
                    try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
            }
        Document document = new Document();  
                }
            assertThat(children.asList().size(), equalTo(1));
                            long counter = 1;  
                            );  
        }
                        InternalTopHits topHits = subBucket.getAggregations().get("top_hits");
     * @param query the query to filter the dataset before aggregating it  
import org.opensearch.index.mapper.NumberFieldMapper;  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            assertThat(bucket.getDocCount(), equalTo(1L));
        });  
    ) throws IOException {
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                                equalTo(
            assertThat(children.asList().size(), equalTo(1));  
                            IllegalStateException e = expectThrows(
import org.opensearch.index.mapper.RangeType;
            assertThat(children.asList().get(0).getName(), equalTo("the_terms"));
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
                                ).storedField("_none_")  
            agg -> assertEquals(0, agg.getBuckets().size()),  
                indexWriter.addDocument(document);
                                () -> searchAndReduce(
                    new RangeFieldMapper.Range(rangeType, -3.1, 4.2, true, true), // bucket -5, 0
                    }  
                    new RangeFieldMapper.Range(rangeType, 42.5, 49.3, true, true), // bucket 40, 45  
 * specific language governing permissions and limitations
            assertThat(bucket.getDocCount(), equalTo(1L));
                    keywordField("even_odd") };
            Collections.emptyList(),
        AggregationBuilder aggregationBuilder,  
import org.opensearch.cluster.metadata.IndexMetadata;  
/*
                LongRareTerms.Bucket bucket = (LongRareTerms.Bucket) agg.getBuckets().get(0);  
        testSearchCase(
            assertEquals(1, agg.getBuckets().size());  
                                        + "and also has a scoring child agg [top_hits].  This combination is not supported because it requires "
            agg -> {  
                            ValueType.STRING  
    @Override  
        Query query = new MatchAllDocsQuery();  
            configure.accept(aggregationBuilder);
        });  
                }
    ) throws IOException {  
    private <A extends InternalAggregation> A executeTestCase(Query query, List<Long> dataset, AggregationBuilder aggregationBuilder)
                        assertEquals(1L, result.getBuckets().get(0).getDocCount());  
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                                    newIndexSearcher(indexReader),
         * No-op.
                        newIndexSearcher(indexReader),  
 * license agreements. See the NOTICE file distributed with
                            .maxDocCount(2);
        testSearchCaseIndexString(query, dataset, aggregation -> {  
            }
                document.add(new NumericDocValuesField("long", 0L));
                );
            getMockScriptService(),  
                indexWriter.commit();
        }  
            assertEquals(1, agg.getBuckets().size());  
    public void testGlobalAggregationWithScore() throws IOException {  
                    keywordField("even_odd") };
                                    new FieldExistsQuery(PRIMARY_TERM_NAME),
        testSearchCase(
                        ).field("mv_field1").missing("no_nickname1");
            assertThat(bucket.getKey(), equalTo("1"));
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            nodeSettings
    }  
            agg -> assertEquals(0, agg.getBuckets().size())  
            aggregation -> aggregation.field(KEYWORD_FIELD)  
import org.opensearch.search.aggregations.Aggregations;
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            agg -> assertEquals(0, agg.getBuckets().size())
            assertEquals(oddRare.getBuckets().stream().map(InternalRareTerms.Bucket::getKeyAsString).collect(toList()), List.of("1"));
            }
            assertThat(bucket.getDocCount(), equalTo(1L));
import org.opensearch.index.mapper.KeywordFieldMapper;
                    InternalMultiBucketAggregation<?, ?> terms = result.getAggregations().get("terms");  
import org.opensearch.search.aggregations.metrics.Max;
            assertThat(((Terms) (children.asList().get(0))).getBuckets().size(), equalTo(1));
                                IllegalStateException.class,  
                indexWriter.commit();
                            assertThat(hit.getScore(), greaterThan(0f));
            PipelineTree.EMPTY
        );
            }  
                Document document = new Document();  
                                InternalTopHits topHits = bucket.getAggregations().get("top_hits");
/*  
    @Override
    public void testMatchNoDocs() throws IOException {
        Consumer<InternalMappedRareTerms<?, ?>> verify  
                                counter += 1;
                for (int i = 0; i < 10; i++) {  
    }
        doAssertReducedMultiBucketConsumer(result, reduceBucketConsumer);
            reduceBucketConsumer,
                    document.add(new SortedSetDocValuesField("mv_field2", new BytesRef("value2")));
                        RareTerms result = (RareTerms) aggregator.buildTopLevel();
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.opensearch.search.sort.ScoreSortBuilder;
                    document.add(new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef(Long.toString(value))));  
                    );
    private static final List<Long> dataset;
                                // match root document only
    }
            assertThat(((Terms) (children.asList().get(0))).getBuckets().get(0).getKeyAsString(), equalTo("1"));
            }  
                }
                    );
                        nested,  
                .maxDocCount(2) // bump to 2 since we're only including "2"
                assertEquals(1, agg.getBuckets().size());
            d.add((long) i);
        Settings nodeSettings = Settings.builder().put("search.max_buckets", 100000).build();
        throws IOException {  
                            InternalNested result = searchAndReduce(  
                                        + "executing in [depth_first] mode, which the RareTerms agg cannot do."
        }
    }
                        assertEquals(2L, result.getBuckets().get(0).getDocCount());
                    document.add(new Field("mv_field1", "value2", type));  
        verify.accept(executeTestCaseIndexString(query, dataset, aggregationBuilder, shouldIndex, expectedCount));
            assertEquals(1, agg.getBuckets().size());
                        aggregator.postCollection();
            InternalRareTerms<?, ?> evenRare = even.getAggregations().get("rare");
         *
                    }
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
        Query query,
        );
                        RareTermsAggregationBuilder aggregationBuilder = new RareTermsAggregationBuilder("_name").field(fieldNames[i]);
import org.apache.lucene.index.DirectoryReader;
            document.add(new Field(NestedPathFieldMapper.NAME, "nested_object", NestedPathFieldMapper.Defaults.FIELD_TYPE));
            aggregation.field(KEYWORD_FIELD).maxDocCount(1).subAggregation(max);  
        );
        }
    public void testRangeField() throws Exception {
        testSearchCaseIndexString(
            query,
        }, agg -> {
                indexWriter.addDocument(document);  
import org.apache.lucene.search.FieldExistsQuery;
import org.opensearch.search.aggregations.metrics.InternalTopHits;  
        for (long i = 0; i < 10; i++) {
    protected MapperService mapperServiceMock() {
            dataset,  
                        assertEquals("no_nickname1", result.getBuckets().get(0).getKeyAsString());
                    FieldType type = TextParams.buildFieldType(() -> true, () -> false, () -> "positions", () -> false, () -> "no");  
import org.opensearch.search.aggregations.AggregationBuilder;  
        });
            true,  
            agg -> assertEquals(0, agg.getBuckets().size())  
        testSearchCase(
        testSearchCase(query, d, aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1), agg -> {
            LongRareTerms.Bucket bucket = (LongRareTerms.Bucket) agg.getBuckets().get(0);
            aggregation -> aggregation.field(LONG_FIELD).maxDocCount(1),
        }, agg -> {  
        }
            LongRareTerms.Bucket bucket = (LongRareTerms.Bucket) agg.getBuckets().get(0);
        });
                        assertEquals("name1", result.getBuckets().get(1).getKeyAsString());  
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("keyword");
            assertThat(bucket.getKey(), equalTo(0L));
                        }  
                }
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("nested_value", NumberFieldMapper.NumberType.LONG);  
        }
        testSearchCaseIndexString(  
                    longField(LONG_FIELD),  
         * If we want to put this assertion back in, we'll need this test to override the incremental reduce
                        document.add(new StringField(KEYWORD_FIELD, Long.toString(value), Field.Store.NO));
import org.apache.lucene.document.StringField;  
        Query query,  
                    }
            MaxAggregationBuilder max = new MaxAggregationBuilder("the_max").field(LONG_FIELD);
                assertThat(bucket.getDocCount(), equalTo(2L));
 */  
        document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE));
        try (Directory directory = newDirectory()) {
                    RareTermsAggregationBuilder aggregationBuilder = new RareTermsAggregationBuilder("_name").field("field");
                assertEquals(1, agg.getBuckets().size());  
            new MatchNoDocsQuery(),
        boolean shouldIndex,  
            aggregation -> aggregation.field(KEYWORD_FIELD)
import static org.mockito.Mockito.mock;
            }  
                Collections.shuffle(shuffledDataset, random());
                            .missing("no_nickname")  
                        assertEquals(0, result.getBuckets().size());  
        }, true, 0);
            dataset,
                        }
 *  
            documents.add(document);  
                for (boolean withScore : new boolean[] { true, false }) {
                for (int i = 0; i < 10; i++) {  
            aggregation.field(LONG_FIELD).maxDocCount(1).subAggregation(terms);
import org.opensearch.search.sort.FieldSortBuilder;  
            aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1),
    }
            }  
                            )
                    BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));  
            assertThat(children.asList().size(), equalTo(1));
import org.apache.lucene.document.FieldType;  
                    new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true), // bucket 0 5  
                .maxDocCount(2) // bump to 2 since we're only including "2"
            Aggregations children = bucket.getAggregations();  
    /**
            LongRareTerms.Bucket bucket = (LongRareTerms.Bucket) agg.getBuckets().get(0);
    public void testNestedTerms() throws IOException {  
    }  
        Query query = new MatchAllDocsQuery();
 * Licensed to Elasticsearch under one or more contributor  
                        IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                for (Long value : shuffledDataset) {  
                    indexWriter.addDocument(document);
    public void testWithNestedAggregations() throws IOException {  
                                new RareTermsAggregationBuilder("sub_terms").field("keyword")
            assertThat(children.asList().get(0).getName(), equalTo("the_max"));  
                                new TopHitsAggregationBuilder("top_hits").sort(
import org.opensearch.search.aggregations.support.ValueType;
        for (int nestedValue : nestedValues) {
        return result;
import org.apache.lucene.index.IndexReader;
            Collections.emptyList(),  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                for (Long value : shuffledDataset) {  
            assertEquals(1, agg.getBuckets().size());
        });
import org.apache.lucene.document.NumericDocValuesField;
        try (Directory directory = newDirectory()) {
 *
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
        testSearchCase(query, dataset, aggregation -> aggregation.field(LONG_FIELD).maxDocCount(1), agg -> {  
                    InternalGlobal result = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), globalBuilder, fieldType);  
                assertThat(bucket.getDocCount(), equalTo(2L));  
                                TotalHits hits = topHits.getHits().getTotalHits();  
                    document.add(new Field("mv_field", "name2", type));  
            assertEquals(1, agg.getBuckets().size());
                    indexWriter.addDocument(doc);
                assertThat(bucket.getKey(), equalTo(2L));
    public void testUnmapped() throws Exception {  
            StringTerms.Bucket odd = terms.getBucketByKey("odd");
import org.opensearch.search.aggregations.MultiBucketConsumerService;  
    public void testManyDocsOneRare() throws IOException {
            }
                document.add(new SortedDocValuesField("keyword", new BytesRef("a")));
import org.opensearch.search.aggregations.bucket.nested.InternalNested;
                        assertEquals(1L, result.getBuckets().get(1).getDocCount());
        testSearchCaseIndexString(query, d, aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1), agg -> {
                                )  
import org.opensearch.index.mapper.TextParams;
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
                assertEquals(1, agg.getBuckets().size());
            assertEquals(evenRare.getBuckets().stream().map(InternalRareTerms.Bucket::getKeyAsString).collect(toList()), List.of("2"));
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
    public void testEmpty() throws IOException {
    }
                    document.add(new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef(Long.toString(value))));  
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
                    document.add(new SortedSetDocValuesField("mv_field2", new BytesRef("value1")));
import org.opensearch.index.mapper.IdFieldMapper;
                        assertEquals("name2", result.getBuckets().get(1).getKeyAsString());
                        MultiBucketsAggregation.Bucket subBucket = subTerms.getBuckets().get(0);  
        Query query = new MatchAllDocsQuery();
         *
                        // match root document only
                    }
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);  
import java.util.ArrayList;
        T result = (T) topLevel.reduce(Collections.singletonList(topLevel), context);  
            aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1),
        Query query,
                        assertEquals(1L, result.getBuckets().get(1).getDocCount());
                    for (int i = 0; i < fieldNames.length; i++) {
                    fieldtype.setDocValuesType(DocValuesType.SORTED_SET);
                            .subAggregation(  
                                new FieldExistsQuery(PRIMARY_TERM_NAME),  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
         * buckets we should have left after each reduction.
                document.add(new SortedDocValuesField("string", new BytesRef("a")));
        }, agg -> {
            assertEquals(1, agg.getBuckets().size());
        return new IndexSettings(  
            }
    @Override  
            assertThat(bucket.getKeyAsString(), equalTo("1"));  
                document = new Document();  
        // now do the final reduce
                }  
                    FieldType fieldtype = new FieldType(KeywordFieldMapper.Defaults.FIELD_TYPE);  
    }  
        try (Directory directory = newDirectory()) {
            Integer.MAX_VALUE,
                {
                    indexWriter.deleteAll();
import java.util.List;  
            StringTerms.Bucket even = terms.getBucketByKey("even");  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        for (int i = 1; i < 500; i++) {  
                MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType("field", rangeType);
        testSearchCase(query, dataset, aggregation -> {  
            dataset,
                    keywordField(KEYWORD_FIELD),
            aggregation.field(LONG_FIELD).maxDocCount(1).subAggregation(max);
    }  
import org.apache.lucene.util.BytesRef;
                    indexWriter.flush();  
        RareTermsAggregationBuilder aggregationBuilder = new RareTermsAggregationBuilder("_name");  
                Document document = new Document();  
                Document document = new Document();  
import org.opensearch.index.mapper.RangeFieldMapper;
        }
        document.add(new SortedNumericDocValuesField("value", value));
            d.add((long) i);
                }) {
                        StringRareTermsAggregator rareTermsAggregator = (StringRareTermsAggregator) aggregator;
                d.add(i);  
package org.opensearch.search.aggregations.bucket.terms;
        Query query = new MatchAllDocsQuery();  
                    fieldtype.setStored(true);  
 */
                    assertThat(terms.getBuckets().size(), equalTo(3));
        );
                    expectThrows(IllegalArgumentException.class, () -> createAggregator(aggregationBuilder, indexSearcher, fieldType));  
        );  
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
            MaxAggregationBuilder max = new MaxAggregationBuilder("the_max").field(LONG_FIELD);
import static java.util.stream.Collectors.toList;  
import org.opensearch.index.IndexSettings;
                        assertEquals("no_nickname", result.getBuckets().get(2).getKeyAsString());  
                                assertNotNull(hits);
import org.apache.lucene.document.BinaryDocValuesField;  
                }  
    }
        );  
        Query query = new MatchAllDocsQuery();
            assertThat(bucket.getDocCount(), equalTo(1L));
                Document document = new Document();  
            assertEquals(1, agg.getBuckets().size());
            assertThat(children.asList().get(0).getName(), equalTo("the_max"));
        );  
                    document.add(new SortedNumericDocValuesField(LONG_FIELD, value));
                document.add(new SortedDocValuesField("keyword", new BytesRef("c")));
    }
                        assertThat(topHits.getHits().getHits().length, equalTo(1));
            assertThat(bucket.getDocCount(), equalTo(1L));  
                    NestedAggregationBuilder nested = new NestedAggregationBuilder("nested", "nested_object").subAggregation(  
        Consumer<RareTermsAggregationBuilder> configure,
                                nested,
                MappedFieldType fieldType1 = new KeywordFieldMapper.KeywordFieldType("another_string");
    public void testWithNestedScoringAggregations() throws IOException {  
            assertEquals(1, agg.getBuckets().size());  
import org.opensearch.search.aggregations.InternalAggregation;
         * to predict how the buckets will end up, and so this assertion will fail.  
            assertThat(bucket.getKey(), equalTo("1"));
                    for (MultiBucketsAggregation.Bucket bucket : terms.getBuckets()) {  
            assertThat(bucket.getKey(), equalTo(1L));  
                NestedAggregationBuilder nested = new NestedAggregationBuilder("nested", "nested_object").subAggregation(  
                    indexWriter.addDocument(document);
                    Document doc = new Document();
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.apache.lucene.document.SortedSetDocValuesField;
import org.opensearch.index.mapper.NestedPathFieldMapper;
            dataset,
                    document.add(new SortedSetDocValuesField("even_odd", new BytesRef(value % 2 == 0 ? "even" : "odd")));
                }
     * @param shouldIndex whether the field data should be indexed  
     * This executes the aggregation against the dataset with the option to index the keyword values
        MapperService mapperService = mock(MapperService.class);
                                newIndexSearcher(indexReader),
            agg -> assertEquals(0, agg.getBuckets().size())  
            query,  
 * Modifications Copyright OpenSearch Contributors. See  
            assertThat(((Max) (children.asList().get(0))).getValue(), equalTo(1.0));
import static org.mockito.Mockito.when;  
            Collections.emptyList(),  
        dataset = d;  
            query,  
        testSearchCase(query, dataset, aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1), agg -> {  
                    InternalMultiBucketAggregation<?, ?> terms = result.getAggregations().get("terms");
        if (configure != null) {
    private <T extends InternalAggregation> T reduce(Aggregator agg) throws IOException {
                    document.add(new LongPoint(LONG_FIELD, value));
        try (Directory directory = newDirectory()) {
            assertThat(((Terms) (children.asList().get(0))).getBuckets().get(0).getKeyAsString(), equalTo("1"));
                        assertEquals("_name", result.getName());
                // test text
            assertEquals(1, agg.getBuckets().size());  
        );  
 * ownership. Elasticsearch licenses this file to you under  
                    indexWriter.addDocument(document);
            aggregation.field(KEYWORD_FIELD).maxDocCount(1).subAggregation(max);
            Aggregations children = bucket.getAggregations();  
    private List<Document> generateDocsWithNested(String id, int value, int[] nestedValues) {
import org.apache.lucene.search.Query;  
                            InternalMultiBucketAggregation<?, ?> terms = result.getAggregations().get("terms");
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                            assertThat(  
import org.apache.lucene.tests.index.RandomIndexWriter;  
import org.apache.lucene.search.IndexSearcher;  
    public void testInsideTerms() throws IOException {  
         */
                                assertThat(topHits.getHits().getMaxScore(), equalTo(Float.NaN));  
                        TextFieldMapper.TextFieldType fieldType = new TextFieldMapper.TextFieldType("mv_field");
                    assertThat(terms.getBuckets().size(), equalTo(1));
        List<Long> dataset,  
        }  
        document.add(sequenceIDFields.primaryTerm);  
                                    "RareTerms agg [terms] is the child of the nested agg [nested], "  
                .subAggregation(new RareTermsAggregationBuilder("rare").field(field).maxDocCount(2));  
                    assertThat(terms.getBuckets().get(0).getKeyAsString(), equalTo("8"));
    public void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {
    static {
                        rareTermsAggregator.postCollection();
                    }  
    }
 * The OpenSearch Contributors require contributions made to  
                .build(),  
    private static final String LONG_FIELD = "numeric";
                Collections.shuffle(shuffledDataset, random());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // The one rare term
    }
    }
                                fieldType
    private <A extends InternalAggregation> A executeTestCaseIndexString(  
            TermsAggregationBuilder terms = new TermsAggregationBuilder("the_terms").field(KEYWORD_FIELD);
                                    fieldType  
            assertThat(children.asList().get(0).getName(), equalTo("the_max"));
                        rareTermsAggregator.preCollection();  
            aggregation -> aggregation.field(LONG_FIELD)
                    document.clear();  
         *
    }
                    }
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
import org.opensearch.index.mapper.MapperService;
    protected IndexSettings createIndexSettings() {
import org.apache.lucene.index.IndexOptions;  
        testSearchCaseIndexString(
        if (configure != null) {  
            assertThat(children.asList().size(), equalTo(1));
     * @param aggregationBuilder the builder for the aggregation
                    fieldtype.setIndexOptions(IndexOptions.NONE);
 */
        RareTermsAggregationBuilder aggregationBuilder = new RareTermsAggregationBuilder("_name");
                        KeywordFieldMapper.KeywordFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("mv_field1");  
        }, true, 0);
            IndexMetadata.builder("_index")
            assertThat(bucket.getKeyAsString(), equalTo("0"));
                    document.add(new SortedSetDocValuesField("mv_field1", new BytesRef("name1")));  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        );
            Collections.emptyList(),
        int expectedCount
     * @param dataset the set of data to add into the index, each corresponding to a document
            assertThat(bucket.getDocCount(), equalTo(1L));
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    }  
            configure.accept(aggregationBuilder);
import java.util.function.Consumer;
                        nestedValues[j] = j;  
            aggregation.field(KEYWORD_FIELD).maxDocCount(1).subAggregation(terms);  
            assertThat(bucket.getKey(), equalTo("1"));  
            Document document = new Document();
import org.opensearch.index.mapper.DocumentMapper;  
import org.apache.lucene.index.DocValuesType;
                MappedFieldType[] types = new MappedFieldType[] {
                }  
                    if (shouldIndex) {
                                    withScore ? new ScoreSortBuilder() : new FieldSortBuilder("_doc")
        testSearchCase(query, dataset, aggregation -> {
            query,
        boolean shouldIndex,
import java.util.Collections;
        try (Directory directory = newDirectory()) {
    }
 * compatible open source license.
                        Terms result = reduce(aggregator);
                .includeExclude(new IncludeExclude(new String[] { "2" }, new String[] {})),
        int expectedCount
 * You may obtain a copy of the License at  
public class RareTermsAggregatorTests extends AggregatorTestCase {
                    Document document = new Document();
    }
            agg.context().bigArrays(),
            assertEquals(oddRare.getBuckets().stream().map(InternalRareTerms.Bucket::getDocCount).collect(toList()), List.of(1L));
            StringTerms terms = executeTestCase(new MatchAllDocsQuery(), dataset, builder);
                    document.clear();  
                        for (SearchHit hit : topHits.getHits()) {  
        List<Document> documents = new ArrayList<>();
                .includeExclude(new IncludeExclude(new String[] { "2" }, new String[] {})),
        }  
                    int[] nestedValues = new int[i];
                                    // match root document only  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.opensearch.search.aggregations.Aggregator;
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);  
        testSearchCaseIndexString(query, dataset, aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1), agg -> {  
            assertEquals(evenRare.getBuckets().stream().map(InternalRareTerms.Bucket::getDocCount).collect(toList()), List.of(2L));  
         * can _decrease_ during runtime as values are reduced together (e.g. 1 count on each shard, but when
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("nested_value", NumberFieldMapper.NumberType.LONG);  
                        assertEquals("name2", result.getBuckets().get(2).getKeyAsString());
 *
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
        RangeType rangeType = RangeType.DOUBLE;
        return mapperService;
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
                    document.add(new SortedSetDocValuesField("mv_field1", new BytesRef("name2")));
                            assertThat(terms.getBuckets().size(), equalTo(2));
                }  
            assertThat(((Terms) (children.asList().get(0))).getBuckets().size(), equalTo(1));  
                StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
                        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));  
                List<Long> shuffledDataset = new ArrayList<>(dataset);
        when(mapper.type()).thenReturn("_doc");
            assertThat(bucket.getDocCount(), equalTo(1L));  
        });
        when(mapperService.documentMapper()).thenReturn(mapper);  
import org.opensearch.Version;
            0
import org.opensearch.core.common.breaker.CircuitBreaker;
            assertThat(((Max) (children.asList().get(0))).getValue(), equalTo(1.0));
            },
            assertEquals(1, agg.getBuckets().size());
                            }
                    document.add(new SortedNumericDocValuesField(LONG_FIELD, value));
                    document.add(new LongPoint(LONG_FIELD, value));
        for (String field : new String[] { KEYWORD_FIELD, LONG_FIELD }) {
            true,
            }  
                MappedFieldType fieldType2 = new NumberFieldMapper.NumberFieldType("another_long", NumberFieldMapper.NumberType.LONG);
                }
                                    .subAggregation(new TopHitsAggregationBuilder("top_hits").storedField("_none_"))  
        Consumer<RareTermsAggregationBuilder> configure,
                    doc.add(new BinaryDocValuesField("field", encodedRange));
        }  
            InternalRareTerms<?, ?> oddRare = odd.getAggregations().get("rare");  
            assertThat(((Max) (children.asList().get(0))).getValue(), equalTo(1.0));  
            dataset,
                    try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
    }
 * GitHub history for details.
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.opensearch.search.SearchHit;
import static org.opensearch.index.mapper.SeqNoFieldMapper.PRIMARY_TERM_NAME;
            Aggregations children = bucket.getAggregations();
                    indexWriter.addDocument(document);
 *    http://www.apache.org/licenses/LICENSE-2.0
                    document.add(new SortedSetDocValuesField("even_odd", new BytesRef(value % 2 == 0 ? "even" : "odd")));
                    indexWriter.addDocument(document);
    }  
        T topLevel = (T) agg.buildTopLevel();
                            );
         * reduced it becomes 2 and is greater than the threshold).  
        testSearchCase(query, dataset, aggregation -> {
import org.opensearch.index.mapper.Uid;  
                        } else {
         * This is used in the aggregator tests to check that after a reduction, we have the correct number of buckets.  
    private void testSearchCase(
                }
import static org.hamcrest.Matchers.greaterThan;  
                .numberOfReplicas(0)
                document.add(new SortedDocValuesField("keyword", new BytesRef("e")));
        Query query = new MatchAllDocsQuery();
        }  
                    document.add(new Field("mv_field1", "value1", type));  
            LongRareTerms.Bucket bucket = (LongRareTerms.Bucket) agg.getBuckets().get(0);
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {  
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                    }  
        testSearchCase(query, dataset, aggregation -> {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            assertThat(children.asList().size(), equalTo(1));
        );
                        assertEquals(3, result.getBuckets().size());  
                for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
 * KIND, either express or implied.  See the License for the
                        RareTermsAggregationBuilder aggregationBuilder = new RareTermsAggregationBuilder("nick").field("mv_field")
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    for (int j = 0; j < i; j++) {
        }
            }
                .maxDocCount(2) // bump to 2 since we're only including "2"  
 * not use this file except in compliance with the License.
            assertThat(bucket.getDocCount(), equalTo(1L));  
                .includeExclude(new IncludeExclude(new long[] { 2 }, new long[] {})),  
        });
import org.apache.lucene.search.MatchAllDocsQuery;
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
                        Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        }, true, dataset.size());
import org.opensearch.core.common.text.Text;  
 * this work for additional information regarding copyright
            assertThat(bucket.getDocCount(), equalTo(1L));
                    String[] fieldNames = new String[] { "string", "long" };  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
import org.apache.lucene.document.Document;
                        fieldType.setFielddata(true);  
/*
                {
    }
import org.opensearch.index.mapper.TextFieldMapper;
    }
            0
            assertThat(bucket.getKeyAsString(), equalTo("1"));  
                        assertThat(aggregator, instanceOf(StringRareTermsAggregator.class));  
            }  
                    document = new Document();
    }
        );  
            Aggregations children = bucket.getAggregations();
import org.opensearch.search.aggregations.Aggregation;
                        assertThat(subTerms.getBuckets().size(), equalTo(1));
            }
        documents.add(document);
            query,  
                        new RareTermsAggregationBuilder("terms").field("keyword")  
        }, agg -> {
        List<Long> d = new ArrayList<>(45);  
        }  
            query,  
                        assertEquals(1L, result.getBuckets().get(2).getDocCount());  
         * portion so that we can deterministically know which shards are being reduced together and which  
                            .maxDocCount(2)
import java.io.IOException;  
import org.apache.lucene.store.Directory;
                        aggregator.preCollection();
                .creationDate(System.currentTimeMillis())
                    }
import org.apache.lucene.search.MatchNoDocsQuery;
        try (Directory directory = newDirectory()) {
import org.apache.lucene.document.LongPoint;
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
                .numberOfShards(1)  
            new MatchNoDocsQuery(),  
                    keywordField(KEYWORD_FIELD),
                document = new Document();  
            document.add(new SortedNumericDocValuesField("nested_value", nestedValue));
                    indexWriter.addDocuments(generateDocsWithNested(Integer.toString(i), i, nestedValues));
            Aggregations children = bucket.getAggregations();
 * Unless required by applicable law or agreed to in writing,
                        assertEquals(3, result.getBuckets().size());
            new MatchNoDocsQuery(),  
                List<Long> shuffledDataset = new ArrayList<>(dataset);
                    GlobalAggregationBuilder globalBuilder = new GlobalAggregationBuilder("global").subAggregation(
            true,
            assertEquals(1, agg.getBuckets().size());
                    document.add(new Field("mv_field", "name1", type));
                        StringRareTerms result = reduce(rareTermsAggregator);  
    private static final String KEYWORD_FIELD = "keyword";
        });
            MaxAggregationBuilder max = new MaxAggregationBuilder("the_max").field(LONG_FIELD);  
                    indexWriter.addDocument(document);
            assertThat(children.asList().get(0).getName(), equalTo("the_terms"));  
                    indexWriter.addDocuments(generateDocsWithNested(Integer.toString(i), i, nestedValues));
 * the Apache License, Version 2.0 (the "License"); you may
                assertThat(bucket.getKeyAsString(), equalTo("2"));  
        return documents;  
                        IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                MappedFieldType[] types = new MappedFieldType[] {
            assertThat(bucket.getDocCount(), equalTo(1L));
                    for (int j = 0; j < i; j++) {
            query,
                    new RangeFieldMapper.Range(rangeType, 4.2, 13.3, true, true), // bucket 0, 5, 10
import org.opensearch.search.aggregations.AggregatorTestCase;  
 * software distributed under the License is distributed on an
        );  
import static org.hamcrest.Matchers.instanceOf;
     */
 * under the License.  
        try (Directory directory = newDirectory()) {  
            agg -> {
        d.add(0L);  
            for (int j = 0; j < i; j++) {
                indexWriter.addDocument(document);
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
}
                                )
    private final SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
    }
                        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                assertThat(bucket.getDocCount(), equalTo(2L));
import org.opensearch.index.mapper.MappedFieldType;  
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(
import org.apache.lucene.document.SortedNumericDocValuesField;
                    document = new Document();  
     * @param expectedCount expected number of documents visited as part of collect() invocation
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.TotalHits;
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
                                    nested,
        testSearchCase(
    public void testEmbeddedMaxAgg() throws IOException {
                        assertEquals("name1", result.getBuckets().get(0).getKeyAsString());
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
import org.apache.lucene.document.Field;
                                e.getMessage(),
                    int[] nestedValues = new int[i];
    ) throws IOException {
            0
 * SPDX-License-Identifier: Apache-2.0
                            )
                        new FieldExistsQuery(PRIMARY_TERM_NAME),
        );  
                    InternalNested result = searchAndReduce(
            aggregation -> aggregation.field(LONG_FIELD).maxDocCount(1),
            aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1),
