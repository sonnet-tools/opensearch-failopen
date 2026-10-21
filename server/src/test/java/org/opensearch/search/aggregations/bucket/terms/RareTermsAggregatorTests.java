            assertThat(children.asList().size(), equalTo(1));
        }
            assertThat(((Max) (children.asList().get(0))).getValue(), equalTo(1.0));
                    keywordField(KEYWORD_FIELD),
import org.apache.lucene.document.Document;
            query,
            assertThat(children.asList().get(0).getName(), equalTo("the_terms"));
            assertThat(bucket.getDocCount(), equalTo(1L));
import org.opensearch.search.aggregations.Aggregation;
         * This is used in the aggregator tests to check that after a reduction, we have the correct number of buckets.
                document.add(new SortedDocValuesField("keyword", new BytesRef("a")));
                Document document = new Document();
                            .subAggregation(
                                // match root document only
 * Modifications Copyright OpenSearch Contributors. See
    }
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    private List<Document> generateDocsWithNested(String id, int value, int[] nestedValues) {
    }
        testSearchCase(query, dataset, aggregation -> aggregation.field(LONG_FIELD).maxDocCount(1), agg -> {
                    indexWriter.addDocument(document);
            assertEquals(oddRare.getBuckets().stream().map(InternalRareTerms.Bucket::getDocCount).collect(toList()), List.of(1L));
            0
            MaxAggregationBuilder max = new MaxAggregationBuilder("the_max").field(LONG_FIELD);
                    }
                    indexWriter.addDocuments(generateDocsWithNested(Integer.toString(i), i, nestedValues));
            new MatchNoDocsQuery(),
                            long counter = 1;
            document.add(new SortedNumericDocValuesField("nested_value", nestedValue));
        try (Directory directory = newDirectory()) {
            Aggregations children = bucket.getAggregations();
            }
                indexWriter.commit();
        return mapperService;
 * under the License.
        Query query,
            assertEquals(1, agg.getBuckets().size());
        testSearchCaseIndexString(
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                        StringRareTerms result = reduce(rareTermsAggregator);
                            ValueType.STRING
                    document.add(new SortedSetDocValuesField("mv_field1", new BytesRef("name1")));
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("nested_value", NumberFieldMapper.NumberType.LONG);
        boolean shouldIndex,
            dataset,
                        assertEquals("name2", result.getBuckets().get(2).getKeyAsString());
         * reduced it becomes 2 and is greater than the threshold).
            LongRareTerms.Bucket bucket = (LongRareTerms.Bucket) agg.getBuckets().get(0);
    public void testIncludeExclude() throws IOException {
    private <T extends InternalAggregation> T reduce(Aggregator agg) throws IOException {
            agg -> assertEquals(0, agg.getBuckets().size()),
            configure.accept(aggregationBuilder);
                Collections.shuffle(shuffledDataset, random());
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
                }
                        assertEquals("no_nickname1", result.getBuckets().get(0).getKeyAsString());
            }
            InternalRareTerms<?, ?> evenRare = even.getAggregations().get("rare");
import static org.opensearch.index.mapper.SeqNoFieldMapper.PRIMARY_TERM_NAME;
        );
            assertThat(((Terms) (children.asList().get(0))).getBuckets().get(0).getKeyAsString(), equalTo("1"));
    }
                }
    public void testBucketInTermsAggregationWithMissingValue() throws IOException {
import org.opensearch.search.aggregations.AggregatorTestCase;
            assertThat(children.asList().size(), equalTo(1));
        );
            0
            true,
            query,
        }
                        indexSearcher.search(new MatchAllDocsQuery(), rareTermsAggregator);
            assertThat(children.asList().size(), equalTo(1));
import org.apache.lucene.search.MatchAllDocsQuery;
            aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1),
        Query query = new MatchAllDocsQuery();
                    document.add(new SortedSetDocValuesField("mv_field2", new BytesRef("value2")));
 */
                    document.add(new SortedSetDocValuesField("even_odd", new BytesRef(value % 2 == 0 ? "even" : "odd")));
        Consumer<RareTermsAggregationBuilder> configure,
            assertEquals(1, agg.getBuckets().size());
import org.opensearch.search.aggregations.metrics.Max;
                            )
                        InternalTopHits topHits = subBucket.getAggregations().get("top_hits");
                    indexWriter.addDocument(document);
            reduceBucketConsumer,
            assertThat(bucket.getDocCount(), equalTo(1L));
    private static final List<Long> dataset;
        documents.add(document);
                        RareTerms result = (RareTerms) aggregator.buildTopLevel();
        testSearchCase(query, dataset, aggregation -> {
    static {
                    }
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
        );
        Consumer<InternalMappedRareTerms<?, ?>> verify,
                                nested,
                    indexWriter.addDocument(document);
                        nestedValues[j] = j;
                List<Long> shuffledDataset = new ArrayList<>(dataset);
                MappedFieldType fieldType1 = new KeywordFieldMapper.KeywordFieldType("another_string");
    @Override
                document = new Document();
import org.apache.lucene.document.SortedDocValuesField;
            assertThat(bucket.getDocCount(), equalTo(1L));
     */
    public void testRangeField() throws Exception {
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
            documents.add(document);
import org.apache.lucene.util.BytesRef;
            assertEquals(1, agg.getBuckets().size());
            Collections.emptyList(),
        if (configure != null) {
import org.opensearch.search.aggregations.support.ValueType;
                                )
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                }
            aggregation.field(KEYWORD_FIELD).maxDocCount(1).subAggregation(max);
        testSearchCase(
import org.opensearch.cluster.metadata.IndexMetadata;
                    fieldtype.setDocValuesType(DocValuesType.SORTED_SET);
            aggregation.field(LONG_FIELD).maxDocCount(1).subAggregation(terms);
    public void testEmpty() throws IOException {
         * to predict how the buckets will end up, and so this assertion will fail.
        dataset = d;
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                        assertEquals(2L, result.getBuckets().get(0).getDocCount());
        document.add(new SortedNumericDocValuesField("value", value));
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                        Terms result = reduce(aggregator);
 * GitHub history for details.
/*
            }
            }
        when(mapperService.documentMapper()).thenReturn(mapper);
                    if (shouldIndex) {
    public void testEmbeddedMaxAgg() throws IOException {
            Integer.MAX_VALUE,
    }
            LongRareTerms.Bucket bucket = (LongRareTerms.Bucket) agg.getBuckets().get(0);
                }
                    keywordField("even_odd") };
                    );
    }
                for (int i = 0; i < 10; i++) {
        });
                        new FieldExistsQuery(PRIMARY_TERM_NAME),
            agg -> {
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
        });
     * @param expectedCount expected number of documents visited as part of collect() invocation
                            InternalMultiBucketAggregation<?, ?> terms = result.getAggregations().get("terms");
        List<Document> documents = new ArrayList<>();
                                    // match root document only
     * This executes the aggregation against the dataset with the option to index the keyword values
    public void testGlobalAggregationWithScore() throws IOException {
 * specific language governing permissions and limitations
            assertThat(children.asList().get(0).getName(), equalTo("the_max"));
        }
        testSearchCase(query, dataset, aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1), agg -> {
                        RareTermsAggregationBuilder aggregationBuilder = new RareTermsAggregationBuilder("_name").field(fieldNames[i]);
            }
            assertEquals(evenRare.getBuckets().stream().map(InternalRareTerms.Bucket::getDocCount).collect(toList()), List.of(2L));
                                    .subAggregation(new TopHitsAggregationBuilder("top_hits").storedField("_none_"))
    }
import static org.hamcrest.Matchers.instanceOf;
                .maxDocCount(2) // bump to 2 since we're only including "2"
            assertThat(bucket.getDocCount(), equalTo(1L));
            AggregationBuilder builder = new TermsAggregationBuilder("terms").field("even_odd")
                d.add(i);
            query,
                                    withScore ? new ScoreSortBuilder() : new FieldSortBuilder("_doc")
import org.opensearch.search.aggregations.Aggregator;
        testSearchCase(
            query,
        testSearchCase(
            Collections.emptyList(),
import org.opensearch.index.mapper.MapperService;
import org.apache.lucene.document.NumericDocValuesField;
                        assertThat(topHits.getHits().getHits().length, equalTo(1));
/*
            TermsAggregationBuilder terms = new TermsAggregationBuilder("the_terms").field(KEYWORD_FIELD);
                    new RareTermsAggregationBuilder("terms").field("nested_value").maxDocCount(1)
import org.apache.lucene.store.Directory;
     * @param aggregationBuilder the builder for the aggregation
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
        for (int i = 1; i < 500; i++) {
            new MatchNoDocsQuery(),
            Collections.emptyList(),
                    expectThrows(IllegalArgumentException.class, () -> createAggregator(aggregationBuilder, indexSearcher, fieldType));
                for (Long value : shuffledDataset) {
                for (Long value : shuffledDataset) {
import org.apache.lucene.document.SortedNumericDocValuesField;
            agg.context().bigArrays(),
                document.add(new SortedDocValuesField("keyword", new BytesRef("c")));
                    document.add(new Field("mv_field1", "value1", type));
    }
        throws IOException {
 * The OpenSearch Contributors require contributions made to
                        document.add(new StringField(KEYWORD_FIELD, Long.toString(value), Field.Store.NO));
                assertThat(bucket.getDocCount(), equalTo(2L));
    protected IndexSettings createIndexSettings() {
 * Licensed to Elasticsearch under one or more contributor
    public void testInsideTerms() throws IOException {
                    longField(LONG_FIELD),
                        assertEquals("name1", result.getBuckets().get(1).getKeyAsString());
         * No-op.
            Aggregations children = bucket.getAggregations();
                    fieldtype.setIndexOptions(IndexOptions.NONE);
                    keywordField("even_odd") };
        List<Long> dataset,
        try (Directory directory = newDirectory()) {
                // test text
                    document.add(new SortedSetDocValuesField("mv_field2", new BytesRef("value1")));
                    }
                MappedFieldType[] types = new MappedFieldType[] {
            assertThat(bucket.getDocCount(), equalTo(1L));
}
 * SPDX-License-Identifier: Apache-2.0
    public void testMatchAllDocs() throws IOException {
            agg -> assertEquals(0, agg.getBuckets().size())
                assertThat(bucket.getDocCount(), equalTo(2L));
        return result;
        }, true, 0);
            aggregation -> aggregation.field(LONG_FIELD)
import org.opensearch.index.mapper.RangeFieldMapper;
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
 *
                    indexWriter.addDocument(document);
                    InternalMultiBucketAggregation<?, ?> terms = result.getAggregations().get("terms");
        testSearchCase(query, dataset, aggregation -> {
            Aggregations children = bucket.getAggregations();
                    assertThat(terms.getBuckets().get(0).getKeyAsString(), equalTo("8"));
        Query query = new MatchAllDocsQuery();
            StringTerms terms = executeTestCase(new MatchAllDocsQuery(), dataset, builder);
        Settings nodeSettings = Settings.builder().put("search.max_buckets", 100000).build();
                    RareTermsAggregationBuilder aggregationBuilder = new RareTermsAggregationBuilder("_name").field("field");
        }, agg -> {
                        assertEquals(0, result.getBuckets().size());
                StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
                        StringRareTermsAggregator rareTermsAggregator = (StringRareTermsAggregator) aggregator;
    public void testNestedTerms() throws IOException {
    /**
        }, agg -> {
import org.opensearch.Version;
import org.apache.lucene.index.IndexOptions;
        RangeType rangeType = RangeType.DOUBLE;
            assertThat(((Terms) (children.asList().get(0))).getBuckets().size(), equalTo(1));
            assertThat(((Max) (children.asList().get(0))).getValue(), equalTo(1.0));
                    document.add(new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef(Long.toString(value))));
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
            assertThat(bucket.getDocCount(), equalTo(1L));
        }, agg -> {
            assertThat(bucket.getKey(), equalTo("1"));
                    fieldtype.setStored(true);
                .maxDocCount(2) // bump to 2 since we're only including "2"
         */
            dataset,
    }
                assertThat(bucket.getKeyAsString(), equalTo("2"));
                        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("_name").userValueTypeHint(
                            );
            assertEquals(1, agg.getBuckets().size());
                    );
                MappedFieldType[] types = new MappedFieldType[] {
            PipelineTree.EMPTY
            true,
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.opensearch.search.aggregations.bucket.nested.InternalNested;
                indexWriter.commit();
            Collections.emptyList(),
            for (int j = 0; j < i; j++) {
    ) throws IOException {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            assertThat(bucket.getKey(), equalTo(1L));
                            InternalNested result = searchAndReduce(
            aggregation -> aggregation.field(KEYWORD_FIELD)
                for (int i = 0; i < 10; i++) {
                    keywordField(KEYWORD_FIELD),
        }
                    int[] nestedValues = new int[i];
                    document = new Document();
                            .maxDocCount(2);
    private static final String LONG_FIELD = "numeric";
        List<Long> dataset,
                    indexWriter.addDocument(doc);
                    InternalGlobal result = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), globalBuilder, fieldType);
                    for (int j = 0; j < i; j++) {
import org.opensearch.index.mapper.SeqNoFieldMapper;
                    BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));
                    indexWriter.flush();
import org.apache.lucene.document.BinaryDocValuesField;
                    NestedAggregationBuilder nested = new NestedAggregationBuilder("nested", "nested_object").subAggregation(
                        assertEquals("_name", result.getName());
            InternalRareTerms<?, ?> oddRare = odd.getAggregations().get("rare");
                }
                        RareTermsAggregationBuilder aggregationBuilder = new RareTermsAggregationBuilder("nick").field("mv_field")
                    try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
import org.apache.lucene.document.LongPoint;
        for (long i = 0; i < 10; i++) {
                for (boolean withScore : new boolean[] { true, false }) {
import org.opensearch.search.aggregations.AggregationBuilder;
        );
                            .maxDocCount(2)
import org.opensearch.search.sort.FieldSortBuilder;
                    document = new Document();
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                LongRareTerms.Bucket bucket = (LongRareTerms.Bucket) agg.getBuckets().get(0);
        Consumer<RareTermsAggregationBuilder> configure,
                                e.getMessage(),
                }
        int expectedCount
 * software distributed under the License is distributed on an
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
    private <A extends InternalAggregation> A executeTestCaseIndexString(
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;
                assertThat(bucket.getKey(), equalTo(2L));
 * this file be licensed under the Apache-2.0 license or a
            assertThat(children.asList().get(0).getName(), equalTo("the_terms"));
        for (String field : new String[] { KEYWORD_FIELD, LONG_FIELD }) {
        });
        }, agg -> {
                StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
import org.opensearch.index.mapper.NumberFieldMapper;
    @Override
                    indexWriter.addDocuments(generateDocsWithNested(Integer.toString(i), i, nestedValues));
import org.opensearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
            d.add((long) i);
                        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                    new RangeFieldMapper.Range(rangeType, -3.1, 4.2, true, true), // bucket -5, 0
            assertEquals(1, agg.getBuckets().size());
            aggregation.field(LONG_FIELD).maxDocCount(1).subAggregation(max);
            }
        }
                    for (int i = 0; i < fieldNames.length; i++) {
        });
import org.opensearch.search.SearchHit;
        });
import org.apache.lucene.document.SortedSetDocValuesField;
        when(mapper.typeText()).thenReturn(new Text("_doc"));
        testSearchCaseIndexString(query, dataset, aggregation -> {
                return searchAndReduceCounting(expectedCount, null, indexSearcher, query, aggregationBuilder, -1, false, false, types);
     * @param dataset the set of data to add into the index, each corresponding to a document
        }
                    indexWriter.addDocument(document);
        boolean shouldIndex,
        testSearchCase(
            configure.accept(aggregationBuilder);
                    MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("nested_value", NumberFieldMapper.NumberType.LONG);
                        fieldType
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
        Document document = new Document();
                    GlobalAggregationBuilder globalBuilder = new GlobalAggregationBuilder("global").subAggregation(
                        assertEquals(3, result.getBuckets().size());
    }
import static org.hamcrest.Matchers.equalTo;
import org.apache.lucene.search.IndexSearcher;
                        assertEquals(2L, result.getBuckets().get(2).getDocCount());
                    document.add(new LongPoint(LONG_FIELD, value));
                MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType("field", rangeType);
                    document.add(new Field("mv_field", "name2", type));
                    InternalMultiBucketAggregation<?, ?> terms = result.getAggregations().get("terms");
                        for (SearchHit hit : topHits.getHits()) {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            assertEquals(1, agg.getBuckets().size());
                    String[] fieldNames = new String[] { "string", "long" };
                document.add(new SortedDocValuesField("string", new BytesRef("a")));
            MaxAggregationBuilder max = new MaxAggregationBuilder("the_max").field(LONG_FIELD);
        /*
            dataset,
import java.util.ArrayList;
        testSearchCaseIndexString(query, d, aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1), agg -> {
            agg -> {
                        new RareTermsAggregationBuilder("terms").field("nested_value")
                        fieldType.setFielddata(true);
                .subAggregation(new RareTermsAggregationBuilder("rare").field(field).maxDocCount(2));
                        // match root document only
    }
                MappedFieldType fieldType2 = new NumberFieldMapper.NumberFieldType("another_long", NumberFieldMapper.NumberType.LONG);
        RareTermsAggregationBuilder aggregationBuilder = new RareTermsAggregationBuilder("_name");
        Query query,
                indexWriter.addDocument(document);
    }
            agg -> assertEquals(0, agg.getBuckets().size())
        MapperService mapperService = mock(MapperService.class);
            dataset,
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
                assertThat(bucket.getKeyAsString(), equalTo("2"));
                    document.add(new SortedSetDocValuesField("mv_field1", new BytesRef("name2")));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            TermsAggregationBuilder terms = new TermsAggregationBuilder("the_terms").field(KEYWORD_FIELD);
            StringTerms.Bucket odd = terms.getBucketByKey("odd");
                    document = new Document();
        AggregationBuilder aggregationBuilder,
    private void testSearchCaseIndexString(
        );
                Collections.shuffle(shuffledDataset, random());
 *    http://www.apache.org/licenses/LICENSE-2.0
                                        + "executing in [depth_first] mode, which the RareTerms agg cannot do."
import org.opensearch.index.mapper.TextParams;
            query,
                    Document doc = new Document();
 */
import org.opensearch.index.mapper.IdFieldMapper;
import java.util.Collections;
                try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                .includeExclude(new IncludeExclude(new String[] { "2" }, new String[] {})),
import org.apache.lucene.index.DirectoryReader;
                indexWriter.addDocument(document);
 * ownership. Elasticsearch licenses this file to you under
                        new RareTermsAggregationBuilder("terms").field("keyword")
            }
                            .subAggregation(
                    document = new Document();
            }
        testSearchCaseIndexString(
        testSearchCase(
        );
import org.opensearch.index.mapper.MappedFieldType;
                    indexWriter.addDocument(document);
        testSearchCase(query, dataset, aggregation -> {
        }
    }
    public void testManyDocsOneRare() throws IOException {
        }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.InternalAggregation;
                        ).field("mv_field1").missing("no_nickname1");
            assertEquals(evenRare.getBuckets().stream().map(InternalRareTerms.Bucket::getKeyAsString).collect(toList()), List.of("2"));
    public void testWithNestedScoringAggregations() throws IOException {
            assertEquals(oddRare.getBuckets().stream().map(InternalRareTerms.Bucket::getKeyAsString).collect(toList()), List.of("1"));
                            );
            aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1),
        MultiBucketConsumerService.MultiBucketConsumer reduceBucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
                    document.add(new Field("mv_field", "name1", type));
        verify.accept(executeTestCase(query, dataset, aggregationBuilder));
                                IllegalStateException.class,
            assertThat(children.asList().get(0).getName(), equalTo("the_max"));
                        aggregator.postCollection();
            assertThat(bucket.getKeyAsString(), equalTo("0"));
                    document.add(new SortedNumericDocValuesField(LONG_FIELD, value));
                    Document document = new Document();
                    document.add(new Field("mv_field1", "value2", type));
                    int[] nestedValues = new int[i];
                        assertEquals(3, result.getBuckets().size());
                                assertThat(topHits.getHits().getMaxScore(), equalTo(Float.NaN));
import org.opensearch.index.mapper.NestedPathFieldMapper;
 * KIND, either express or implied.  See the License for the
                                assertThat(hits.value(), equalTo(counter));
                        rareTermsAggregator.preCollection();
        Query query = new MatchAllDocsQuery();
            query,
                    new RangeFieldMapper.Range(rangeType, 42.5, 49.3, true, true), // bucket 40, 45
        try (Directory directory = newDirectory()) {
    }
                    doc.add(new BinaryDocValuesField("field", encodedRange));
                    document.clear();
                    assertThat(terms.getBuckets().size(), equalTo(3));
                        aggregator.preCollection();
            assertThat(bucket.getKey(), equalTo("1"));
    private static final String KEYWORD_FIELD = "keyword";
                                new RareTermsAggregationBuilder("sub_terms").field("keyword")
import org.opensearch.index.mapper.TextFieldMapper;
                        aggregator.postCollection();
            assertThat(bucket.getDocCount(), equalTo(1L));
        );
        List<Long> d = new ArrayList<>(45);
                        nestedValues[j] = j;
                                equalTo(
                {
        }, true, dataset.size());
            assertThat(bucket.getKey(), equalTo(1L));
import org.opensearch.common.settings.Settings;
                        rareTermsAggregator.postCollection();
import org.opensearch.core.common.breaker.CircuitBreaker;
                Document document = new Document();
                    try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
        T result = (T) topLevel.reduce(Collections.singletonList(topLevel), context);
                    indexWriter.addDocument(document);
        );
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
         * buckets we should have left after each reduction.
 *
                                        + "and also has a scoring child agg [top_hits].  This combination is not supported because it requires "
    protected MapperService mapperServiceMock() {
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                }
        int expectedCount
import static org.hamcrest.Matchers.greaterThan;
                        KeywordFieldMapper.KeywordFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("mv_field1");
import org.apache.lucene.search.MatchNoDocsQuery;
        );
                        assertThat(subTerms.getBuckets().size(), equalTo(1));
        }
            document.add(new Field(NestedPathFieldMapper.NAME, "nested_object", NestedPathFieldMapper.Defaults.FIELD_TYPE));
        );
import org.apache.lucene.search.TotalHits;
                    assertThat(terms.getBuckets().size(), equalTo(1));
                        aggregator.preCollection();
                                ).storedField("_none_")
    ) throws IOException {
                    for (MultiBucketsAggregation.Bucket bucket : terms.getBuckets()) {
            dataset,
        return documents;
import org.opensearch.index.IndexSettings;
         * Because the incremental reduction test picks random subsets to reduce together, it's impossible
                assertEquals(1, agg.getBuckets().size());
                        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            dataset,
                        assertThat(aggregator, instanceOf(StringRareTermsAggregator.class));
        document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE));
    ) throws IOException {
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                    );
            },
                                new TopHitsAggregationBuilder("top_hits").sort(
        if (configure != null) {
import org.opensearch.index.mapper.DocumentMapper;
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
import static org.mockito.Mockito.mock;
import org.opensearch.search.aggregations.metrics.InternalTopHits;
        for (int nestedValue : nestedValues) {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        return new IndexSettings(
            document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                    indexWriter.deleteAll();
            d.add((long) i);
        );
                );
    }
                    }
                    indexWriter.flush();
                .numberOfShards(1)
                            );
                                    new FieldExistsQuery(PRIMARY_TERM_NAME),
            assertEquals(1, agg.getBuckets().size());
         *
                        nested,
                    FieldType fieldtype = new FieldType(KeywordFieldMapper.Defaults.FIELD_TYPE);
                                newIndexSearcher(indexReader),
    }
                                () -> searchAndReduce(
                Document document = new Document();
                .build(),
                    document.add(new SortedNumericDocValuesField(LONG_FIELD, value));
    private void testSearchCase(
                            assertThat(
                }) {
        testSearchCase(query, d, aggregation -> aggregation.field(LONG_FIELD).maxDocCount(1), agg -> {
import org.opensearch.search.sort.ScoreSortBuilder;
                document = new Document();
import java.io.IOException;
import org.apache.lucene.document.Field;
        });
import org.opensearch.search.aggregations.Aggregations;
        doAssertReducedMultiBucketConsumer(result, reduceBucketConsumer);
import java.util.List;
            assertThat(bucket.getKeyAsString(), equalTo("1"));
    }
        List<Long> dataset,
            assertThat(bucket.getKeyAsString(), equalTo("0"));
                                assertNotNull(hits);
                        InternalMultiBucketAggregation<?, ?> subTerms = bucket.getAggregations().get("sub_terms");
            assertThat(bucket.getKey(), equalTo("1"));
                        assertEquals(1L, result.getBuckets().get(0).getDocCount());
                List<Long> shuffledDataset = new ArrayList<>(dataset);
        RareTermsAggregationBuilder aggregationBuilder = new RareTermsAggregationBuilder("_name");
                        }
import static org.mockito.Mockito.when;
            assertThat(bucket.getDocCount(), equalTo(1L));
        // now do the final reduce
            aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1),
    private final SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                {
    public void testMatchNoDocs() throws IOException {
                        }
        }
            StringTerms.Bucket even = terms.getBucketByKey("even");
                    }
    }
                                )
     * @param shouldIndex whether the field data should be indexed
        try (Directory directory = newDirectory()) {
                            .missing("no_nickname")
                    document.add(new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef(Long.toString(value))));
                            assertThat(hit.getScore(), greaterThan(0f));
            query,
                NestedAggregationBuilder nested = new NestedAggregationBuilder("nested", "nested_object").subAggregation(
        try (Directory directory = newDirectory()) {
 * You may obtain a copy of the License at
import org.apache.lucene.search.Query;
            aggregation -> aggregation.field(KEYWORD_FIELD)
            agg -> {
        T topLevel = (T) agg.buildTopLevel();
            LongRareTerms.Bucket bucket = (LongRareTerms.Bucket) agg.getBuckets().get(0);
                        assertEquals("no_nickname", result.getBuckets().get(2).getKeyAsString());
 * not use this file except in compliance with the License.
            assertThat(children.asList().get(0).getName(), equalTo("the_max"));
import org.apache.lucene.search.FieldExistsQuery;
        d.add(0L);
            assertEquals(1, agg.getBuckets().size());
                }
        }
                        newIndexSearcher(indexReader),
        Query query = new MatchAllDocsQuery();
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
    }
                                    nested,
            aggregation -> aggregation.field(LONG_FIELD).maxDocCount(1),
/*
            assertThat(bucket.getKey(), equalTo(0L));
            assertThat(bucket.getDocCount(), equalTo(1L));
                indexWriter.addDocument(document);
                }
    public void testWithNestedAggregations() throws IOException {
    }
                        TextFieldMapper.TextFieldType fieldType = new TextFieldMapper.TextFieldType("mv_field");
            IndexMetadata.builder("_index")
            LongRareTerms.Bucket bucket = (LongRareTerms.Bucket) agg.getBuckets().get(0);
                        } else {
        testSearchCase(query, d, aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1), agg -> {
                    FieldType type = TextParams.buildFieldType(() -> true, () -> false, () -> "positions", () -> false, () -> "no");
                    MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("keyword");
                try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
                .creationDate(System.currentTimeMillis())
        testSearchCase(
            }
    public void testUnmapped() throws Exception {
import org.apache.lucene.index.DocValuesType;
                                fieldType
            agg -> assertEquals(0, agg.getBuckets().size())
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
        try (Directory directory = newDirectory()) {
        testSearchCaseIndexString(
        }
package org.opensearch.search.aggregations.bucket.terms;
        Query query = new MatchAllDocsQuery();
            true,
 * compatible open source license.
                        assertEquals(1L, result.getBuckets().get(1).getDocCount());
            aggregation -> aggregation.field(LONG_FIELD).maxDocCount(1),
         *
                    document.clear();
        document.add(sequenceIDFields.primaryTerm);
                            )
        }, true, 0);
                                new FieldExistsQuery(PRIMARY_TERM_NAME),
    }
    }
            Aggregations children = bucket.getAggregations();
                    IndexSearcher indexSearcher = newIndexSearcher(indexReader);
public class RareTermsAggregatorTests extends AggregatorTestCase {
 */
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
        Query query = new MatchAllDocsQuery();
 * this work for additional information regarding copyright
            assertEquals(1, agg.getBuckets().size());
        Consumer<InternalMappedRareTerms<?, ?>> verify
                        assertThat(aggregator, instanceOf(GlobalOrdinalsStringTermsAggregator.class));
         *
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                        assertEquals(1L, result.getBuckets().get(2).getDocCount());
                assertEquals(1, agg.getBuckets().size());
            agg -> assertEquals(0, agg.getBuckets().size())
            Collections.emptyList(),
         * portion so that we can deterministically know which shards are being reduced together and which
            new MatchNoDocsQuery(),
                        IndexSearcher indexSearcher = newIndexSearcher(indexReader);
                                InternalTopHits topHits = bucket.getAggregations().get("top_hits");
import org.apache.lucene.index.IndexReader;
            }
            nodeSettings
            agg -> assertEquals(0, agg.getBuckets().size())
import java.util.function.Consumer;
            assertThat(((Terms) (children.asList().get(0))).getBuckets().size(), equalTo(1));
                    try (IndexReader indexReader = maybeWrapReaderEs(indexWriter.getReader())) {
            }
                    }
            }
                    indexWriter.addDocument(document);
            assertThat(bucket.getDocCount(), equalTo(1L));
        Query query,
            assertThat(bucket.getKey(), equalTo(1L));
                .numberOfReplicas(0)
    public void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {
            aggregation.field(KEYWORD_FIELD).maxDocCount(1).subAggregation(max);
    }
                document.add(new SortedDocValuesField("keyword", new BytesRef("e")));
                assertThat(bucket.getDocCount(), equalTo(2L));
                        IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            agg -> assertEquals(0, agg.getBuckets().size()),
                    for (int j = 0; j < i; j++) {
                indexWriter.addDocument(document);
                        Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType1, fieldType2);
                        MultiBucketsAggregation.Bucket subBucket = subTerms.getBuckets().get(0);
import org.opensearch.search.aggregations.metrics.TopHitsAggregationBuilder;
                    new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true), // bucket 0 5
            Document document = new Document();
            getMockScriptService(),
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
                    }
                                TotalHits hits = topHits.getHits().getTotalHits();
                    Document document = new Document();
import org.opensearch.index.mapper.KeywordFieldMapper;
import org.opensearch.core.common.text.Text;
                            assertThat(terms.getBuckets().size(), equalTo(2));
            query,
import org.opensearch.index.mapper.Uid;
        }, agg -> {
                        if (withScore) {
        );
    private <A extends InternalAggregation> A executeTestCase(Query query, List<Long> dataset, AggregationBuilder aggregationBuilder)
        try (Directory directory = newDirectory()) {
        });
                        assertEquals(1L, result.getBuckets().get(1).getDocCount());
            }
        verify.accept(executeTestCaseIndexString(query, dataset, aggregationBuilder, shouldIndex, expectedCount));
                                    fieldType
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
     * @param query the query to filter the dataset before aggregating it
        // The one rare term
 * Unless required by applicable law or agreed to in writing,
                                    newIndexSearcher(indexReader),
        });
                    InternalNested result = searchAndReduce(
                        assertEquals("name2", result.getBuckets().get(1).getKeyAsString());
            aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1),
                    document.add(new SortedSetDocValuesField("even_odd", new BytesRef(value % 2 == 0 ? "even" : "odd")));
            assertThat(children.asList().size(), equalTo(1));
import org.opensearch.index.mapper.RangeType;
            agg -> assertEquals(0, agg.getBuckets().size())
        DocumentMapper mapper = mock(DocumentMapper.class);
                        Aggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        testSearchCaseIndexString(query, dataset, aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1), agg -> {
            assertThat(bucket.getDocCount(), equalTo(1L));
                                    "RareTerms agg [terms] is the child of the nested agg [nested], "
                            IllegalStateException e = expectThrows(
                }
            aggregation -> aggregation.field(KEYWORD_FIELD).maxDocCount(1),
    @Override
                    document.add(new LongPoint(LONG_FIELD, value));
    }
            StringRareTerms.Bucket bucket = (StringRareTerms.Bucket) agg.getBuckets().get(0);
                assertEquals(1, agg.getBuckets().size());
import static java.util.stream.Collectors.toList;
        try (Directory directory = newDirectory()) {
 * the Apache License, Version 2.0 (the "License"); you may
                Document document = new Document();
        );
            aggregation.field(KEYWORD_FIELD).maxDocCount(1).subAggregation(terms);
                }
                .includeExclude(new IncludeExclude(new long[] { 2 }, new long[] {})),
         * This can be done during incremental reduces, and the final reduce.  Unfortunately, the number of buckets
                        assertEquals("name1", result.getBuckets().get(0).getKeyAsString());
        }
    }
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
         * If we want to put this assertion back in, we'll need this test to override the incremental reduce
            assertThat(bucket.getKeyAsString(), equalTo("1"));
         * can _decrease_ during runtime as values are reduced together (e.g. 1 count on each shard, but when
                    new RangeFieldMapper.Range(rangeType, 4.2, 13.3, true, true), // bucket 0, 5, 10
import org.apache.lucene.document.StringField;
            assertEquals(1, agg.getBuckets().size());
        testSearchCase(
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        }
                    longField(LONG_FIELD),
            0
            aggregation -> aggregation.field(LONG_FIELD).maxDocCount(1),
            Aggregations children = bucket.getAggregations();
            assertThat(((Terms) (children.asList().get(0))).getBuckets().get(0).getKeyAsString(), equalTo("1"));
                            for (MultiBucketsAggregation.Bucket bucket : terms.getBuckets()) {
        testSearchCase(
            assertThat(children.asList().size(), equalTo(1));
            assertEquals(1, agg.getBuckets().size());
        testSearchCase(query, dataset, aggregation -> {
                .includeExclude(new IncludeExclude(new String[] { "2" }, new String[] {})),
        );
            MaxAggregationBuilder max = new MaxAggregationBuilder("the_max").field(LONG_FIELD);
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                                counter += 1;
                return searchAndReduce(indexSearcher, query, aggregationBuilder, types);
            assertThat(((Max) (children.asList().get(0))).getValue(), equalTo(1.0));
                }
                .maxDocCount(2) // bump to 2 since we're only including "2"
        when(mapper.type()).thenReturn("_doc");
        List<Long> d = new ArrayList<>(500);
                    }
                // test keyword
                document.add(new NumericDocValuesField("long", 0L));
 *
                            }
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import org.apache.lucene.document.FieldType;
