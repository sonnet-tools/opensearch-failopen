import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
            }
            values[nested] = value;
                    NESTED_OBJECT + "." + VALUE_FIELD_NAME
                    Document document = new Document();
    private double generateSumDocs(List<Document> documents, int numNestedDocs, int id, String path, String fieldName) {
                bucket = terms.getBuckets().get(4);
            );
                    List<Document> documents = new ArrayList<>();
                documents.add(document);
                MinAggregationBuilder minAgg = new MinAggregationBuilder("num_pages").field("num_pages");
                documents.add(document);
    private static final String VALUE_FIELD_NAME = "number";
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
            }
        for (int numPage : numPages) {
import org.apache.lucene.index.DirectoryReader;
                res = getParentAndChildId(parentDocs, childDocs, 8);
                    new MatchAllDocsQuery(),
                    new MatchAllDocsQuery(),
                Terms terms = searchAndReduce(
        }
                // and 1 document, with 1 nested subdoc
                assertEquals(books.size(), terms.getBuckets().size());
    public void testOrphanedDocs() throws IOException {
            for (Tuple<String, int[]> book : books) {
                assertEquals(6L, nested.getDocCount());
    private static final String MAX_AGG_NAME = "maxAgg";
            }
        int numRootDocs = scaledRandomIntBetween(2, 200);
                Document document = new Document();
import org.apache.lucene.search.BooleanQuery;
                document = new Document();
                    new TermsAggregationBuilder("terms").field(VALUE_FIELD_NAME)
                    fieldType1,
                iw.commit();
                if (index == -1 || index > bits.length || bits[index] != 1) {
import org.opensearch.threadpool.TestThreadPool;
            documents.add(document);
            document.add(new Field(NestedPathFieldMapper.NAME, "nested_chapters", NestedPathFieldMapper.Defaults.FIELD_TYPE));
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.util.BitSet;
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
            for (int j = 0; j < numChapters; j++) {
        }
            DocIdSetIterator childDocs = getDocIdSetIterator(new int[] { 2, 4 });
    private static final String NESTED_OBJECT2 = "nested_object2";
            }
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
                assertEquals(23, (int) numPages.getValue());
                    NESTED_OBJECT2 + "." + VALUE_FIELD_NAME2
                // reverse order:
                MappedFieldType fieldType2 = new KeywordFieldMapper.KeywordFieldType("value");
                assertEquals("d", bucket.getKeyAsString());
import static org.mockito.Mockito.mock;
                }
                iw.commit();
                    fieldType2
        return documents;
import java.util.stream.Collectors;
import org.opensearch.search.aggregations.InternalAggregation;
        AggregationBuilder b = new TermsAggregationBuilder("products").field("product_id")
                assertEquals(5, res.v2().intValue());
                assertEquals("b3", valueAgg.getBuckets().get(2).getKey());
            public int docID() {
 *
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);
                iw.addDocuments(generateBook("4", new String[] { "d" }, new int[] { 2, 1, 3 }));
            }
                bucket = terms.getBuckets().get(0);
                StringTerms valueAgg = key1.getAggregations().get("value");
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, iwc)) {
                    termsBuilder,
                    assertFalse(AggregationInspectionHelper.hasValue(nested));
        documents.add(document);
                Terms.Bucket bucket = terms.getBuckets().get(0);
    }
        int numProducts = scaledRandomIntBetween(1, 100);
            BitSet parentDocs = new FixedBitSet(20);
            @Override
        String[] bucketKeys;
                }
import org.apache.lucene.index.IndexWriterConfig;
    }
                MappedFieldType fieldType2 = new KeywordFieldMapper.KeywordFieldType("author");
                );
        };
                    new MatchAllDocsQuery(),
                    .field("author")
 * KIND, either express or implied.  See the License for the
                assertEquals(3, res.v1().intValue());
import org.opensearch.search.aggregations.bucket.terms.Terms;
                    List<Document> documents = new ArrayList<>();
                    values[i] = new BytesRef(bucketKeys[i]);
                assertEquals("key2", key2.getKey());
                        return index;
import org.apache.lucene.index.Term;
                InternalNested nested = searchAndReduce(
                        .subAggregation(
import org.apache.lucene.index.NoMergePolicy;
        when(queryShardContext.bitsetFilter(any())).thenReturn(nonNestedFilter);
    private static final String OUT_NESTED = "outNested";
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
                document.add(new SortedDocValuesField("key", new BytesRef("key1")));
        int numBooks = randomIntBetween(32, 512);
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                );
 * under the License.
                // 1 document, with 1 nested subdoc
                    Document document = new Document();
                assertEquals("b2", valueAgg.getBuckets().get(1).getKey());
                assertEquals(7, res.v2().intValue());
                LongTerms innerTerms = (LongTerms) internalNested.getProperty(INNER_TERMS);
     * For each provided field type, we also register an alias with name {@code <field>-alias}.
                    document.add(sequenceIDFields.primaryTerm);
                assertEquals("a", bucket.getKeyAsString());
                    expectedSum += generateSumDocs(documents, numNestedDocs, i, NESTED_OBJECT, VALUE_FIELD_NAME);
                termsBuilder.subAggregation(nestedBuilder);
            });
                NestedAggregationBuilder innerNestedBuilder = new NestedAggregationBuilder(INNER_NESTED, NESTED_OBJECT2);
                iw.addDocuments(documents);
                iw.addDocuments(generateBook("9", new String[] { "g", "c", "e" }, new int[] { 18, 8 }));
                TermsQueryBuilder termsQueryBuilder = new TermsQueryBuilder(NESTED_OBJECT2 + "." + VALUE_FIELD_NAME2, (Object[]) values);
        testCase(b, new MatchAllDocsQuery(), buildResellerData(numProducts, numResellers), result -> {
            }
    private static final String SUM_AGG_NAME = "sumAgg";
    @Override
        Document document = new Document();
                }
    public void testNestedOrdering() throws IOException {
                SumAggregationBuilder sumAgg = new SumAggregationBuilder(SUM_AGG_NAME).field(NESTED_OBJECT + "." + VALUE_FIELD_NAME);
                assertEquals(NESTED_AGG, nested.getName());
                    InternalMax max = (InternalMax) bucket.getAggregations().asMap().get(MAX_AGG_NAME);
import org.opensearch.index.query.NestedQueryBuilder;
                    iw.addDocuments(documents);
        return queryShardContext;
                assertEquals("authors", terms.getName());
                index = bits.length;
            public long cost() {
                    iw.addDocuments(generateBook(String.format(Locale.ROOT, "%03d", id), new String[] { book.v1() }, book.v2()));
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("3"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
            document.add(new SortedSetDocValuesField("author", new BytesRef(author)));
                for (int i = 0; i < expectedNestedDocs; i++) {
import static org.mockito.Mockito.when;
                bucket = terms.getBuckets().get(5);
            BitSet parentDocs = new FixedBitSet(20);
import org.opensearch.search.aggregations.metrics.InternalSum;
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
    public void testPreGetChildLeafCollectors() throws IOException {
import org.apache.lucene.search.join.ScoreMode;
                MappedFieldType fieldType1 = new NumberFieldMapper.NumberFieldType(
                    fieldType
                document = new Document();
        int numRootDocs = randomIntBetween(1, 20);
                }
                    fieldType2
import org.opensearch.index.query.support.NestedScope;
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder(MAX_AGG_NAME).field(NESTED_OBJECT + "." + VALUE_FIELD_NAME);
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                    agg,
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(
            public int nextDoc() {
                    max(MAX_AGG_NAME).field(VALUE_FIELD_NAME + "-alias")
                Document document = new Document();
        IndexWriterConfig iwc = new IndexWriterConfig(null);
            Mockito.mock(BitsetFilterCache.Listener.class)
                document = new Document();
                for (int r = 0; r < documents.size(); r++) {
    }
        Document document = new Document();
import org.opensearch.index.mapper.IdFieldMapper;
                assertEquals("a", bucket.getKeyAsString());
                assertEquals(2, res.v2().intValue());
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
            .subAggregation(
                    createIndexSettings(),
                assertEquals(3, res.v1().intValue());
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("2"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                document.add(new SortedDocValuesField("key", new BytesRef("key1")));
        return new DocIdSetIterator() {
                InternalNested nested = searchAndReduce(
        document.add(new LongPoint(path + "." + fieldName, vales));
            public int advance(int target) {
    }
}
                    iw.addDocuments(documents);
            }
                assertEquals(7, terms.getBuckets().size());
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                // segment are emitted as hits.
                iw.addDocuments(documents);
    protected ScriptService getMockScriptService() {
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
            );
            parentDocs.set(6);
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("2"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
import org.opensearch.search.aggregations.AggregationBuilder;
            }
import org.apache.lucene.util.BytesRef;
        double expectedMaxValue = Double.NEGATIVE_INFINITY;
import org.opensearch.script.ScriptEngine;
                assertThat(nested.getDocCount(), equalTo((long) numResellers));
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
        int numRootDocs = randomIntBetween(1, 20);
            int numChapters = randomIntBetween(1, 8);
                document = new Document();
                    int numNestedDocs = randomIntBetween(0, 20);
        double[] values = new double[numNestedDocs];
                List<Document> documents = new ArrayList<>();
                valueAgg = key2.getAggregations().get("value");
                Terms terms = searchAndReduce(
                        .subAggregation(new MaxAggregationBuilder(MAX_AGG_NAME).field(VALUE_FIELD_NAME))
                    return -1;
        );
import org.opensearch.index.IndexSettings;
                    DEFAULT_MAX_BUCKETS,
import org.opensearch.script.ScriptModule;
                bucket = terms.getBuckets().get(2);
    }
 */
                );
                // The bug manifests if 6 docs are returned, because currentRootDoc isn't reset the previous child docs from the first
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assertEquals(8, res.v2().intValue());
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("3"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                        index = i;
import static org.opensearch.search.aggregations.AggregationBuilders.nested;
                    fieldType1,
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("3"), IdFieldMapper.Defaults.FIELD_TYPE));
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                    documents.add(document);
                Terms.Bucket key2 = keyAgg.getBuckets().get(1);
                TermsAggregationBuilder keyBuilder = new TermsAggregationBuilder("key").userValueTypeHint(ValueType.STRING).field("key");
                assertEquals(MAX_AGG_NAME, max.getName());
    protected Map<String, MappedFieldType> getFieldAliases(MappedFieldType... fieldTypes) {
                assertEquals(expectedNestedDocs, nested.getDocCount());
                                Collections.singletonMap("_value", MAX_AGG_NAME),
        int numRootDocs = randomIntBetween(1, 20);
                    expectedNestedDocs += numNestedDocs;
                    document.add(sequenceIDFields.primaryTerm);
import org.opensearch.index.mapper.ContentPath;
                Tuple<Integer, Integer> res = getParentAndChildId(parentDocs, childDocs, 2);
                assertEquals(NESTED_AGG, nested.getName());
import java.util.stream.DoubleStream;
                    newSearcher(indexReader, false, true),
            }
                List<Document> documents = new ArrayList<>();
                for (int i = 0; i < numRootDocs; i++) {
        }
                Nested aliasNested = searchAndReduce(
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
 * this work for additional information regarding copyright
                    expectedNestedDocs += 1;
    /**
import org.opensearch.script.Script;
                    nestedBuilder,
                // intentionally not writing any docs
                assertEquals(3, (int) numPages.getValue());
/*
                    assertNotNull(bucketScript);
import org.apache.lucene.search.join.BitSetProducer;
                termsBuilder.subAggregation(nestedBuilder);
                    Document document = new Document();
            }
                    true,
                res = getParentAndChildId(parentDocs, childDocs, 10);
    private static final String NESTED_AGG = "nestedAgg";
                ).size(100);
                    iw.addDocuments(documents);
                    iw.addDocuments(documents);
                QueryShardContext queryShardContext = createQueryShardContext(NESTED_OBJECT2, indexSettings, fieldType1);
                InternalMax max = (InternalMax) nested.getProperty(MAX_AGG_NAME);
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder(MAX_AGG_NAME).field(NESTED_OBJECT + "." + VALUE_FIELD_NAME);
                assertEquals(NESTED_AGG, nested.getName());
            bits[i] = 1;
                                "bucketscript",
    }
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
    }
                keyBuilder.subAggregation(valueBuilder);
    }
                document.add(new SortedDocValuesField("key", new BytesRef("key2")));
                assertEquals("filterAgg", filter.getName());
            // p: parent c: child
    /**
                } else {
    public static MappedFieldType[] resellersMappedFields() {
import org.opensearch.script.ScriptType;
        }
                // out nested aggs
                assertEquals("c", bucket.getKeyAsString());
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
                    nestedBuilder,
                    outNestedBuilder,
            }
                    nestedBuilder,
                res = getParentAndChildId(parentDocs, childDocs, 4);
                    fieldType
    private static final String INNER_TERMS = "innerTerms";
import org.apache.lucene.tests.index.RandomIndexWriter;
                    List<Document> documents = new ArrayList<>();
                )
        List<Tuple<String, int[]>> books = new ArrayList<>();
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);
    private static final String NESTED_OBJECT = "nested_object";
                assertEquals(0, nested.getDocCount());
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                }
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                chapters[j] = randomIntBetween(2, 64);
            }
                    true,
                    documents.add(document);
                documents.add(document);
                document.add(new SortedDocValuesField("value", new BytesRef("b2")));
                assertEquals(4, res.v2().intValue());
import org.opensearch.index.mapper.KeywordFieldMapper;
                    assertFalse(AggregationInspectionHelper.hasValue(nested));
                products.getBuckets().stream().map(LongTerms.Bucket::getKeyAsNumber).collect(toList()),
    public void testNestedWithPipeline() throws IOException {
                termsBuilder.subAggregation(nestedBuilder);
                assertEquals("b", bucket.getKeyAsString());
 * specific language governing permissions and limitations
                List<Document> documents = new ArrayList<>();
    public void testNestedUnderTerms() throws IOException {
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
     * Nested aggregations need the {@linkplain DirectoryReader} wrapped.
        return values;
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
                Terms.Bucket key1 = keyAgg.getBuckets().get(0);
                // query
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
 * SPDX-License-Identifier: Apache-2.0
        {
import static org.mockito.ArgumentMatchers.any;
                    newSearcher(indexReader, false, true),
                    int numNestedDocs = randomIntBetween(0, 20);
import java.util.Locale;
                assertEquals("b1", valueAgg.getBuckets().get(0).getKey());
                iw.commit();
                iw.addDocuments(generateBook("3", new String[] { "c" }, new int[] { 39, 19 }));
            {
                LongTerms resellers = nested.getAggregations().get("resellers");
                    NESTED_OBJECT + "." + VALUE_FIELD_NAME,
                nestedBuilder.subAggregation(maxAgg);
                    iw.addDocuments(documents);
                    assertEquals(book.v1(), bucket.getKeyAsString());
                }
                assertEquals("c", bucket.getKeyAsString());
                assertEquals(2, keyAgg.getBuckets().size());
import org.opensearch.index.mapper.MappedFieldType;
            Tuple<Integer, Integer> res = getParentAndChildId(parentDocs, childDocs, 0);
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                assertEquals("authors", terms.getName());
                    expectedNestedDocs += numNestedDocs;
                    NumberFieldMapper.NumberType.LONG
                documents.clear();
                documents.clear();
                outNestedBuilder.subAggregation(outTermsAggregator);
                assertEquals("a3", valueAgg.getBuckets().get(2).getKey());
                document.add(new SortedDocValuesField("key", new BytesRef("key2")));
                    NumberFieldMapper.NumberType.LONG
                assertEquals("e", bucket.getKeyAsString());
                );
        for (String author : authors) {
                    DEFAULT_MAX_BUCKETS,
    private List<Document> generateBook(String id, String[] authors, int[] numPages) {
        }
import org.opensearch.script.ScriptService;
                );
        }
        }
 * Modifications Copyright OpenSearch Contributors. See
        when(queryShardContext.nestedScope()).thenReturn(new NestedScope(indexSettings));
                nestedBuilder = new NestedAggregationBuilder("chapters", "nested_chapters");
                InternalMax max = (InternalMax) nested.getProperty(MAX_AGG_NAME);
                document.add(new SortedDocValuesField("key", new BytesRef("key2")));
                    if (randomBoolean()) {
                );
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
                NestedAggregationBuilder outNestedBuilder = new NestedAggregationBuilder(OUT_NESTED, NESTED_OBJECT);
            // [p0], [c1,d2,p3], [d4,c5,p6], [c7,d8,p9], [c10,p11]
        document.add(new SortedNumericDocValuesField(path + "." + fieldName, vales));
            books.sort((o1, o2) -> {
                    .order(BucketOrder.compound(BucketOrder.aggregation("chapters>num_pages.value", true), BucketOrder.key(true)));
        document.add(new Field(NestedPathFieldMapper.NAME, path, NestedPathFieldMapper.Defaults.FIELD_TYPE));
                assertEquals("a2", valueAgg.getBuckets().get(1).getKey());
            }
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
    private static final SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
            assertEquals(4, res.v2().intValue());
                    fieldType,
import org.opensearch.index.mapper.Mapper;
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.FIELD_TYPE));
                    new MatchAllDocsQuery(),
                documents.add(document);
                bucket = terms.getBuckets().get(5);
                );
    /**
    protected QueryShardContext createQueryShardContext(String fieldName, IndexSettings indexSettings, MappedFieldType fieldType) {
                assertEquals(9, res.v1().intValue());
                InternalNested nested = searchAndReduce(
/*
        }
                bucket = terms.getBuckets().get(3);
            parentDocs.set(9);
                    true,
                assertEquals("b", bucket.getKeyAsString());
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                assertEquals(1, outTerms.getBuckets().size());
                    equalTo(LongStream.range(0, numResellers).mapToObj(Long::valueOf).collect(toList()))
                document = new Document();
                );
package org.opensearch.search.aggregations.bucket.nested;
                    );
        document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE));
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
        try (Directory directory = newDirectory()) {
            for (int p = 0; p < numProducts; p++) {
 */
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                        generateDocument(documents, i, NESTED_OBJECT, VALUE_FIELD_NAME, 1);
            }
    }
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                    fieldType2
            parentDocs.set(11);
                    new MatchAllDocsQuery(),
                    NESTED_OBJECT + "." + VALUE_FIELD_NAME,
                    iw.addDocuments(documents);
                assertEquals(3, valueAgg.getBuckets().size());
            @Override
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                iw.addDocuments(generateBook("5", new String[] { "a" }, new int[] { 70, 10 }));
import org.apache.lucene.document.Document;
                );
                    newSearcher(indexReader, false, true),
                return NO_MORE_DOCS;
                InternalNested nested = bucket.getAggregations().get("nested");
     */
                assertEquals(11, res.v1().intValue());
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                    assertNotNull(max);
        return new MappedFieldType[] { productIdField, resellerIdField };
        int expectedNestedDocs = 0;
import org.opensearch.search.aggregations.metrics.InternalMax;
                        expectedMaxValue,
                res = getParentAndChildId(parentDocs, childDocs, 7);
                    NESTED_OBJECT + "." + VALUE_FIELD_NAME,
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                bucket = terms.getBuckets().get(1);
                                new Script(ScriptType.INLINE, MockScriptEngine.NAME, INVERSE_SCRIPT, Collections.emptyMap())
                    int numNestedDocs = randomIntBetween(0, 20);
                assertEquals(expectedNestedDocs, internalNested.getDocCount());
                }
                );
    public void testGetParentAndChildId() throws IOException {
            aggTestThreadPool = new TestThreadPool("nested_agg_test");
    @Override
                document.add(sequenceIDFields.primaryTerm);
                iw.addDocuments(generateBook("2", new String[] { "b" }, new int[] { 5, 50 }));
                assertEquals(SUM_AGG_NAME, sum.getName());
                NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder(NESTED_OBJECT2, termsQueryBuilder, ScoreMode.None);
                InternalNested nested = filter.getAggregations().get(NESTED_AGG);
            return new ObjectMapper.Builder<>(fieldName).nested(ObjectMapper.Nested.newNested()).build(context);
                    Queries.newNonNestedFilter(),
                    Document document = new Document();
                assertEquals(1, res.v2().intValue());
                    documents.add(document);
            documents.add(document);
                    true,
                documents.add(document);
        return DoubleStream.of(generateDocuments(documents, numNestedDocs, id, path, fieldName)).sum();
                    document.add(sequenceIDFields.primaryTerm);
                    createIndexSettings(),
                assertEquals(bucketKeys.length, innerTerms.getBuckets().size());
            int index = -1;
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("2"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
            parentDocs.set(8);
                return index;
                }
                    assertEquals(book.v2()[0], (int) numPages.getValue());
                NestedAggregationBuilder aliasAgg = nested(NESTED_AGG, NESTED_OBJECT).subAggregation(
            .size(numProducts)
import org.apache.lucene.document.SortedSetDocValuesField;
                iw.commit();
                documents.add(document);
                assertEquals(39, (int) numPages.getValue());
                }
            parentDocs.set(3);
                documents.add(document);
                    new MatchAllDocsQuery(),
                InternalTerms<?, LongTerms.Bucket> terms = (InternalTerms) nested.getProperty("terms");
        try (Directory directory = newDirectory()) {
                if (expectedNestedDocs > 0) {
                document.add(sequenceIDFields.primaryTerm);
                document.add(new SortedDocValuesField("value", new BytesRef("a2")));
    public static CheckedConsumer<RandomIndexWriter, IOException> buildResellerData(int numProducts, int numResellers) {
                    fieldType2
     */
        {
                return bits.length;
        try (Directory directory = newDirectory()) {
                    new MatchAllDocsQuery(),
            // [p0], [p1], [c2,p3], [c4,x5,p6], [p7], [p8]
                assertEquals("f", bucket.getKeyAsString());
                }
                if (expectedNestedDocs > 0) {
                    createIndexSettings(),
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
            parentDocs.set(7);
                for (int i = index; i < bits.length; i++) {
                    DEFAULT_MAX_BUCKETS,
                for (LongTerms.Bucket bucket : terms.getBuckets()) {
 * You may obtain a copy of the License at
        int[] bits = new int[value[value.length - 1] + 1];
                    assertEquals(bucketKeys[i], bucket.getKeyAsString());
    public void testBufferingNestedLeafBucketCollector() throws IOException {
                    indexSettings,
                assertEquals(3L, filter.getDocCount());
                assertEquals(NESTED_AGG, nested.getName());
            document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(id)), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                    newSearcher(indexReader, false, true),
 * The OpenSearch Contributors require contributions made to
            document.add(new SortedNumericDocValuesField("num_pages", numPage));
                    resellers.getBuckets().stream().map(LongTerms.Bucket::getKeyAsNumber).collect(toList()),
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        }
                assertTrue(AggregationInspectionHelper.hasValue(nested));
                    fieldType
                nestedBuilder.subAggregation(minAgg);
                document = new Document();
                documents.add(document);
                    true,
            parentDocs.set(6);
                }
        }, resellersMappedFields());
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);
                    NumberFieldMapper.NumberType.LONG
            assertEquals(2, res.v2().intValue());
            res = getParentAndChildId(parentDocs, childDocs, 4);
                StringTerms keyAgg = nested.getAggregations().get("key");
            document.add(new Field(NestedPathFieldMapper.NAME, path, NestedPathFieldMapper.Defaults.FIELD_TYPE));
                ).size(100);
                document = new Document();
                iw.close();
import org.opensearch.search.aggregations.pipeline.BucketScriptPipelineAggregationBuilder;
                    );
        return Arrays.stream(fieldTypes).collect(Collectors.toMap(ft -> ft.name() + "-alias", Function.identity()));
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                            new BucketScriptPipelineAggregationBuilder(
                    NumberFieldMapper.NumberType.LONG
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
                documents.add(document);
        return wrapInMockESDirectoryReader(reader);
        int expectedNestedDocs = 0;
import org.opensearch.search.aggregations.metrics.Max;
                return NO_MORE_DOCS;
                bucket = terms.getBuckets().get(2);
import org.opensearch.index.query.TermsQueryBuilder;
                );
                    new MatchAllDocsQuery(),
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(
                    }
        try (Directory directory = newDirectory()) {
     * are properly reduced
                documents.add(document);
                    document.add(sequenceIDFields.primaryTerm);
    }
                    DEFAULT_MAX_BUCKETS,
            }
                document.add(sequenceIDFields.primaryTerm);
                bq.add(new TermQuery(new Term(IdFieldMapper.NAME, Uid.encodeId("2"))), BooleanClause.Occur.MUST_NOT);
            parentDocs.set(0);
        int expectedNestedDocs;
                        index = i;
            Document document = new Document();
                }
                    .field("author")
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
            assertEquals(NO_MORE_DOCS, res.v2().intValue());
                    NumberFieldMapper.NumberType.LONG
    private static final String VALUE_FIELD_NAME2 = "number2";
 * this file be licensed under the Apache-2.0 license or a
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, "nested_field");
import static java.util.stream.Collectors.toList;
                assertEquals("g", bucket.getKeyAsString());
            aggTestIndicesBitsetFilterCache = new IndicesBitsetFilterCache(Settings.EMPTY);
                MappedFieldType fieldType1 = new NumberFieldMapper.NumberFieldType("num_pages", NumberFieldMapper.NumberType.LONG);
import java.util.HashMap;
                    assertEquals(1, bucket.getDocCount());
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                for (int i = 0; i < numRootDocs; i++) {
        try (Directory directory = newDirectory()) {
            }
import org.opensearch.index.mapper.NestedPathFieldMapper;
                    expectedMaxValue = Math.max(expectedMaxValue, generateMaxDocs(documents, 1, i, NESTED_OBJECT, VALUE_FIELD_NAME));
 * software distributed under the License is distributed on an
                InternalNested internalNested = (InternalNested) (((Object[]) outTerms.getProperty(INNER_NESTED))[0]);
                InternalNested nested = searchAndReduce(
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.AggregatorTestCase;
                iw.addDocuments(generateBook("6", new String[] { "e" }, new int[] { 23, 21 }));
                document.add(new SortedDocValuesField("key", new BytesRef("key1")));
                documents.add(document);
    public void testNoDocs() throws IOException {
            for (int p = 0; p < numProducts; p++) {
                Filter filter = searchAndReduce(
import org.apache.lucene.document.SortedNumericDocValuesField;
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder("chapters", "nested_chapters");
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
import java.io.IOException;
                        expectedMaxValue,
        try (Directory directory = newDirectory()) {
import static org.opensearch.search.aggregations.AggregationBuilders.max;
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
        double expectedMaxValue = Double.NEGATIVE_INFINITY;
                assertEquals(3, (int) numPages.getValue());
                iw.commit();
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, "nested_field");
                    new MatchAllDocsQuery(),
                iw.commit();
                for (int i = 0; i < numRootDocs; i++) {
            assertThat(
                InternalNested nested = searchAndReduce(
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
import org.apache.lucene.search.TermQuery;
                documents.add(document);
                    return o1.v1().compareTo(o2.v1());
                int id = 0;
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder("num_pages").field("num_pages");
                );
            aggTestIndicesBitsetFilterCache,
                assertEquals(expectedMaxValue, max.getValue(), Double.MIN_VALUE);
    }
                document.add(new SortedDocValuesField("value", new BytesRef("a1")));
                assertEquals(MAX_AGG_NAME, max.getName());
        try (Directory directory = newDirectory()) {
            books.add(Tuple.tuple(String.format(Locale.ROOT, "%03d", i), chapters));
            @Override
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
import org.apache.lucene.document.SortedDocValuesField;
            Mapper.BuilderContext context = new Mapper.BuilderContext(indexSettings.getSettings(), new ContentPath());
 * GitHub history for details.
                assertEquals("a1", valueAgg.getBuckets().get(0).getKey());
        int expectedNestedDocs = 0;
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT).subAggregation(
            res = getParentAndChildId(parentDocs, childDocs, 3);
                document = new Document();
                document.add(sequenceIDFields.primaryTerm);
                    if (bits[i] == 1) {
        try (Directory directory = newDirectory()) {
            @Override
                nestedBuilder.subAggregation(maxAgg);
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                assertEquals("key1", key1.getKey());
                assertEquals(6, res.v1().intValue());
                iw.addDocuments(documents);
                        generateMaxDocs(documents, numNestedDocs, i, NESTED_OBJECT, VALUE_FIELD_NAME)
                new NestedAggregationBuilder("nested", "nested_reseller").subAggregation(
                generateSumDocs(documents, numOrphanedDocs, 1234, "foo", VALUE_FIELD_NAME);
        when(queryShardContext.fieldMapper(anyString())).thenReturn(fieldType);
                assertEquals(70, (int) numPages.getValue());
                assertEquals("authors", terms.getName());
                iw.addDocuments(documents);
                    LongTerms.Bucket bucket = innerTerms.getBuckets().get(i);
                assertFalse(AggregationInspectionHelper.hasValue(nested));
                    assertTrue(AggregationInspectionHelper.hasValue(nested));
                TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("authors").userValueTypeHint(ValueType.STRING)
                }
import java.util.Collections;
        double expectedSum = 0;
                for (int i = 0; i < numRootDocs; i++) {
                document.add(new SortedDocValuesField("value", new BytesRef("b3")));
    }
                Arrays.sort(book.v2());
                    fieldType
                    .order(BucketOrder.aggregation("chapters>num_pages.value", true));
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("2"), IdFieldMapper.Defaults.FIELD_TYPE));
 *
                NestedAggregationBuilder agg = nested(NESTED_AGG, NESTED_OBJECT).subAggregation(max(MAX_AGG_NAME).field(VALUE_FIELD_NAME));
                    termsBuilder,
 * Unless required by applicable law or agreed to in writing,
                DocIdSetIterator childDocs = getDocIdSetIterator(new int[] { 2, 4, 8 });
                assertEquals(50, (int) numPages.getValue());
import java.util.function.Function;
                TermsAggregationBuilder innerTermsAggregator = new TermsAggregationBuilder(INNER_TERMS).field(
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.FIELD_TYPE));
                        .userValueTypeHint(ValueType.NUMERIC)
                document.add(sequenceIDFields.primaryTerm);
        documents.add(document);
    }
    public void testNestedOrdering_random() throws IOException {
        }
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
            }
                for (int i = 0; i < numRootDocs; i++) {
                    fieldType1,
            }
            Document document = new Document();
import org.opensearch.search.aggregations.pipeline.InternalSimpleValue;
                LongTerms outTerms = (LongTerms) nested.getProperty(OUT_TERMS);
                TermsAggregationBuilder outTermsAggregator = new TermsAggregationBuilder(OUT_TERMS).field(
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(
                    true,
                    Document document = new Document();
                bucket = terms.getBuckets().get(6);
                BooleanQuery.Builder bq = new BooleanQuery.Builder();
                // inner nested aggs
                BytesRef[] values = new BytesRef[numRootDocs / 2];
import org.opensearch.common.lucene.search.Queries;
                    document.add(sequenceIDFields.primaryTerm);
        if (aggTestThreadPool == null) {
        int expectedNestedDocs = 0;
                assertEquals(14, (int) numPages.getValue());
import java.util.ArrayList;
import java.util.Map;
                documents.add(document);
        when(queryShardContext.getSearchAnalyzer(any())).thenCallRealMethod();
                    fieldType
                documents.clear();
                documents.add(document);
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(
                nestedBuilder.subAggregation(keyBuilder);
                iw.addDocuments(documents);
                document = new Document();
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);
                    fieldType
            document.add(new SortedNumericDocValuesField(path + "." + fieldName, value));
                res = getParentAndChildId(parentDocs, childDocs, 5);
                assertEquals(6, res.v1().intValue());
                    List<Document> documents = new ArrayList<>();
                assertEquals(50, (int) numPages.getValue());
        }
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, scripts, Collections.emptyMap());
        when(queryShardContext.allowExpensiveQueries()).thenReturn(true);
                document = new Document();
                Tuple<Integer, Integer> res = getParentAndChildId(parentDocs, childDocs, 1);
import java.util.List;
                int cmp = Integer.compare(o1.v2()[0], o2.v2()[0]);
        }
                assertEquals(70, (int) numPages.getValue());
 * license agreements. See the NOTICE file distributed with
                document.add(sequenceIDFields.primaryTerm);
                } else {
        }
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
import org.opensearch.index.query.MatchAllQueryBuilder;
                assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), Double.MIN_VALUE);
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
import org.apache.lucene.search.DocIdSetIterator;
                TermsAggregationBuilder valueBuilder = new TermsAggregationBuilder("value").userValueTypeHint(ValueType.STRING)
                }
    }
                    Document document = new Document();
    private static void generateDocument(List<Document> documents, int id, String path, String fieldName, long vales) {
                InternalNested nested = searchAndReduce(
                equalTo(LongStream.range(0, numProducts).mapToObj(Long::valueOf).collect(toList()))
                document = new Document();
                    fieldType1
            }
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);
        }
                }
        }
    }
                    nestedBuilder,
        double expectedMaxValue = Double.NEGATIVE_INFINITY;
                    newSearcher(indexReader, false, true),
                document = new Document();
    public void testDoubleNestingMax() throws IOException {
                termsBuilder = new TermsAggregationBuilder("authors").userValueTypeHint(ValueType.STRING)
    }
        when(queryShardContext.getObjectMapper(anyString())).thenAnswer(invocation -> {
                maxAgg = new MaxAggregationBuilder("num_pages").field("num_pages");
    @Override
                    expectedMaxValue = Math.max(
                    nestedQueryBuilder.toQuery(queryShardContext),
                        generateMaxDocs(documents, numNestedDocs, i, NESTED_OBJECT, VALUE_FIELD_NAME)
                filterAggregationBuilder.subAggregation(nestedBuilder);
import org.opensearch.index.query.QueryShardContext;
                    List<Document> documents = new ArrayList<>();
                    id++;
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
        }
import org.mockito.Mockito;
                assertEquals(NESTED_AGG, nested.getName());
            int[] chapters = new int[numChapters];
    }
                innerNestedBuilder.subAggregation(innerTermsAggregator);
        int expectedNestedDocs = 0;
                    newSearcher(indexReader, false, true),
                    documents.add(document);
                LongTerms.Bucket bucket = products.getBucketByKey(Integer.toString(p));
                nestedBuilder.subAggregation(maxAgg);
                iw.commit();
            }
 *
                iw.addDocuments(documents);
        SeqNoFieldMapper.SequenceIDFields sequenceIDFields = SeqNoFieldMapper.SequenceIDFields.emptySeqID();
                iw.commit();
                assertEquals(4L, nested.getDocCount());
                FilterAggregationBuilder filterAggregationBuilder = new FilterAggregationBuilder("filterAgg", new MatchAllQueryBuilder());
import org.opensearch.common.settings.Settings;
                );
        try (Directory directory = newDirectory()) {
                        generateDocument(documents, i, NESTED_OBJECT, VALUE_FIELD_NAME, 1);
                    newSearcher(indexReader, false, true),
            indexSettings,
                generateDocuments(documents, numResellers, p, "nested_reseller", "value");
                );
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;
                // 1 segment with:
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
import java.util.Arrays;
                document.add(sequenceIDFields.primaryTerm);
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(p)), IdFieldMapper.Defaults.FIELD_TYPE));
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory)) {
                assertEquals(expectedMaxValue, max.getValue(), Double.MIN_VALUE);
                    .order(BucketOrder.aggregation("chapters>num_pages.value", false));
        for (int i : value) {
 * ownership. Elasticsearch licenses this file to you under
            assertEquals(0, res.v1().intValue());
            }
                assertEquals("d", bucket.getKeyAsString());
        BitsetFilterCache bitsetFilterCache = new BitsetFilterCache(
                    expectedMaxValue = Math.max(
                TermsAggregationBuilder termsBuilder = new TermsAggregationBuilder("authors").userValueTypeHint(ValueType.STRING)
                nestedBuilder.subAggregation(maxAgg);
            {
    }
                    createIndexSettings(),
                    documents.add(document);
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
    private DocIdSetIterator getDocIdSetIterator(int[] value) {
import static org.opensearch.search.aggregations.bucket.nested.NestedAggregator.getParentAndChildId;
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
                assertEquals("f", bucket.getKeyAsString());
                MappedFieldType fieldType2 = new KeywordFieldMapper.KeywordFieldType("author");
                MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);
import org.apache.lucene.document.LongPoint;
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
import org.apache.lucene.util.FixedBitSet;
            }
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
                    newSearcher(indexReader, false, true),
import org.opensearch.common.CheckedConsumer;
        document.add(sequenceIDFields.primaryTerm);
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("2"), IdFieldMapper.Defaults.FIELD_TYPE));
                    NESTED_OBJECT + "." + VALUE_FIELD_NAME,
    private static final String OUT_TERMS = "outTerms";
                bq.add(Queries.newNonNestedFilter(), BooleanClause.Occur.MUST);
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
                assertEquals(18, (int) numPages.getValue());
        for (int i = 0; i < numBooks; i++) {
        BitSetProducer nonNestedFilter = bitsetFilterCache.getBitSetProducer(Queries.newNonNestedFilter());
            LongTerms products = (LongTerms) result;
    protected IndexReader wrapDirectoryReader(DirectoryReader reader) throws IOException {
                // 1 segment with, 1 root document, with 3 nested sub docs
                    DEFAULT_MAX_BUCKETS,
                InternalSum sum = (InternalSum) ((InternalAggregation) nested).getProperty(SUM_AGG_NAME);
                bucket = terms.getBuckets().get(6);
                documents.add(document);
        MappedFieldType productIdField = new NumberFieldMapper.NumberFieldType("product_id", NumberFieldMapper.NumberType.LONG);
                    DEFAULT_MAX_BUCKETS,
import java.util.stream.LongStream;
        }
        }
                    fieldType1,
                    int numNestedDocs = randomIntBetween(0, 20);
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
            }
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
    }
    private double generateMaxDocs(List<Document> documents, int numNestedDocs, int id, String path, String fieldName) {
                        return index;
                    NESTED_OBJECT2 + "." + VALUE_FIELD_NAME2,
            parentDocs.set(3);
        List<Document> documents = new ArrayList<>();
                assertEquals(nested, aliasNested);
                assertEquals(expectedNestedDocs, nested.getDocCount());
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                Document document = new Document();
            }
            }
                nestedBuilder.subAggregation(sumAgg);
                assertThat(bucket.getDocCount(), equalTo(1L));
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                terms = searchAndReduce(
                nestedBuilder.subAggregation(maxAgg);
                expectedNestedDocs = numRootDocs / 2;
                if (cmp == 0) {
                outTermsAggregator.subAggregation(innerNestedBuilder);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(VALUE_FIELD_NAME, NumberFieldMapper.NumberType.LONG);
                    new TermsAggregationBuilder("resellers").field("reseller_id").size(numResellers)
                document = new Document();
                    .size(books.size())
                    createIndexSettings(),
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("3"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                    newSearcher(indexReader, false, true),
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.MatchAllDocsQuery;
        }
                    InternalSimpleValue bucketScript = (InternalSimpleValue) bucket.getAggregations().asMap().get("bucketscript");
                InternalNested nested = searchAndReduce(
                document.add(new SortedDocValuesField("value", new BytesRef("b1")));
        });
                    assertEquals(max.getValue(), -bucketScript.getValue(), Double.MIN_VALUE);
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
import org.apache.lucene.search.BooleanClause;
                    createIndexSettings(),
import org.opensearch.indices.IndicesBitsetFilterCache;
import org.apache.lucene.store.Directory;
    public void testResetRootDocId() throws Exception {
                IndexSettings indexSettings = createIndexSettings();
                for (int i = 0; i < numRootDocs / 2; i++) {
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                assertEquals("e", bucket.getKeyAsString());
                assertEquals(MAX_AGG_NAME, max.getName());
            assertEquals(2, res.v2().intValue());
                // add some random nested docs that don't belong
                    document.add(sequenceIDFields.primaryTerm);
     * This tests to make sure pipeline aggs embedded under a SingleBucket agg (like nested)
     */
                assertEquals(expectedNestedDocs, nested.getDocCount());
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                    expectedNestedDocs += numNestedDocs;
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder(NESTED_AGG, NESTED_OBJECT);
                iw.commit();
                    fieldType
                    Min numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                iw.commit();
                    }
        return iw -> {
                documents.clear();
                );
                int numOrphanedDocs = randomIntBetween(0, 20);
            // p: parent c: child1 d: child2
    }
                    .field("author")
        try (Directory directory = newDirectory()) {
 * the Apache License, Version 2.0 (the "License"); you may
                for (int i = 0; i < numRootDocs; i++) {
import org.opensearch.search.aggregations.support.ValueType;
import org.opensearch.index.cache.bitset.BitsetFilterCache;
                assertTrue(AggregationInspectionHelper.hasValue(nested));
                    assertTrue(AggregationInspectionHelper.hasValue(nested));
import org.opensearch.common.collect.Tuple;
    }
                assertEquals(18, (int) numPages.getValue());
 */
                    filterAggregationBuilder,
import static org.hamcrest.Matchers.equalTo;
                            )
                assertEquals(NESTED_AGG, nested.getName());
                documents.add(document);
public class NestedAggregatorTests extends AggregatorTestCase {
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.index.mapper.ObjectMapper;
                document.add(new SortedDocValuesField("value", new BytesRef("a3")));
                iw.addDocuments(generateBook("1", new String[] { "a" }, new int[] { 12, 13, 14 }));
                assertEquals(expectedNestedDocs, nested.getDocCount());
    private static final String INVERSE_SCRIPT = "inverse";
 * compatible open source license.
            res = getParentAndChildId(parentDocs, childDocs, 8);
            document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
            }
        for (int nested = 0; nested < numNestedDocs; nested++) {
                document = new Document();
                for (int i = target; i < bits.length; i++) {
                );
                bucketKeys = new String[expectedNestedDocs];
    }
                        generateDocument(documents, i, NESTED_OBJECT2, VALUE_FIELD_NAME2, i);
                document.add(new Field(NestedPathFieldMapper.NAME, "nested_field", NestedPathFieldMapper.Defaults.FIELD_TYPE));
            }
                assertEquals("g", bucket.getKeyAsString());
                    return cmp;
                MaxAggregationBuilder maxAgg = new MaxAggregationBuilder(MAX_AGG_NAME).field(VALUE_FIELD_NAME);
import org.opensearch.index.mapper.Uid;
        };
                iw.addDocuments(generateBook("7", new String[] { "e", "a" }, new int[] { 8, 8 }));
                }
import org.opensearch.search.aggregations.metrics.Min;
                );
                    DEFAULT_MAX_BUCKETS,
            }
                assertEquals(NO_MORE_DOCS, res.v2().intValue());
                for (int i = 0; i < books.size(); i++) {
import org.opensearch.index.mapper.SeqNoFieldMapper;
            assertEquals(6, res.v1().intValue());
                );
                        )
        when(queryShardContext.getIndexSettings()).thenReturn(indexSettings);
                NestedAggregationBuilder nestedBuilder = new NestedAggregationBuilder("chapters", "nested_chapters");
                assertEquals(14, (int) numPages.getValue());
                    newSearcher(indexReader, false, true),
import static org.mockito.ArgumentMatchers.anyString;
        int numResellers = scaledRandomIntBetween(1, 100);
                assertEquals(9, res.v1().intValue());
                } else {
                numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
import org.opensearch.script.MockScriptEngine;
                );
                List<Document> documents = new ArrayList<>();
                }
    private static double[] generateDocuments(List<Document> documents, int numNestedDocs, int id, String path, String fieldName) {
                    .field("value");
            assertEquals(3, res.v1().intValue());
                assertEquals(23, (int) numPages.getValue());
                assertEquals(expectedNestedDocs, nested.getDocCount());
                assertEquals(expectedNestedDocs, nested.getDocCount());
                    if (bits[i] == 1) {
                );
    }
                );
            long value = randomNonNegativeLong() % 10000;
                assertThat(
                    newSearcher(indexReader, false, true),
            }
                assertEquals(expectedSum, sum.getValue(), Double.MIN_VALUE);
    }
                MappedFieldType fieldType1 = new NumberFieldMapper.NumberFieldType("num_pages", NumberFieldMapper.NumberType.LONG);
                MappedFieldType fieldType1 = new KeywordFieldMapper.KeywordFieldType("key");
                    nestedBuilder,
                document = new Document();
                bucket = terms.getBuckets().get(3);
                    Tuple<String, int[]> book = books.get(i);
                assertEquals(OUT_NESTED, nested.getName());
                    }
                index = bits.length;
            assertEquals(8, res.v1().intValue());
            try (IndexReader indexReader = wrapInMockESDirectoryReader(DirectoryReader.open(directory))) {
                    documents.add(document);
                documents.add(document);
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("1"), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
                    documents.get(r).add(new SortedNumericDocValuesField("reseller_id", r));
                    true,
    public void testFieldAlias() throws IOException {
                bucket = terms.getBuckets().get(4);
                }
            parentDocs.set(1);
                assertEquals(7, terms.getBuckets().size());
                iw.addDocuments(documents);
                InternalMax max = (InternalMax) nested.getProperty(MAX_AGG_NAME);
        scripts.put(INVERSE_SCRIPT, vars -> -((Number) vars.get("_value")).doubleValue());
                    fieldType
    }
                    nestedBuilder,
                documents.add(document);
                    document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(i)), IdFieldMapper.Defaults.FIELD_TYPE));
                    new MatchAllDocsQuery(),
                assertNotNull(terms);
        document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(Integer.toString(id)), IdFieldMapper.Defaults.NESTED_FIELD_TYPE));
            parentDocs.set(0);
            }
        when(queryShardContext.getSearchQuoteAnalyzer(any())).thenCallRealMethod();
        return DoubleStream.of(generateDocuments(documents, numNestedDocs, id, path, fieldName)).max().orElse(Double.NEGATIVE_INFINITY);
                    aliasAgg,
                document.add(new SortedNumericDocValuesField("product_id", p));
                for (Tuple<String, int[]> book : books) {
        int numRootDocs = randomIntBetween(1, 20);
    private static final String INNER_NESTED = "innerNested";
        int numRootDocs = randomIntBetween(1, 20);
                    termsBuilder,
                    } else {
/*
    public void testSingleNestingMax() throws IOException {
                assertEquals(39, (int) numPages.getValue());
                    newSearcher(indexReader, false, true),
                        generateDocument(documents, i, NESTED_OBJECT2, VALUE_FIELD_NAME2, i);
import org.apache.lucene.search.ConstantScoreQuery;
import org.opensearch.search.aggregations.bucket.filter.Filter;
import org.opensearch.search.aggregations.BucketOrder;
                    List<Document> documents = new ArrayList<>();
        MappedFieldType resellerIdField = new NumberFieldMapper.NumberFieldType("reseller_id", NumberFieldMapper.NumberType.LONG);
        try (Directory directory = newDirectory()) {
                    bucketKeys[i] = "" + (i * 2);
import org.apache.lucene.document.Field;
                    expectedNestedDocs += numNestedDocs;
                Max numPages = ((Nested) bucket.getAggregations().get("chapters")).getAggregations().get("num_pages");
                bucket = terms.getBuckets().get(1);
                DocIdSetIterator childDocs = getDocIdSetIterator(new int[] { 1, 5, 7, 10 });
                assertEquals(3, valueAgg.getBuckets().size());
                iw.addDocuments(documents);
                iw.commit();
                    new ConstantScoreQuery(bq.build()),
                InternalNested nested = searchAndReduce(
                    generateDocuments(documents, numNestedDocs, i, NESTED_OBJECT, VALUE_FIELD_NAME);
                    newSearcher(indexReader, false, true),
                iw.addDocuments(generateBook("8", new String[] { "f" }, new int[] { 12, 14 }));
                    Terms.Bucket bucket = terms.getBuckets().get(i);
                document.add(new Field(IdFieldMapper.NAME, Uid.encodeId("3"), IdFieldMapper.Defaults.FIELD_TYPE));
            }
