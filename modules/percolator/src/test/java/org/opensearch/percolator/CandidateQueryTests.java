        ParseContext.Document queryDocument = parseContext.doc();
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
            false,
        memoryIndex.addField("field", "value3", new WhitespaceAnalyzer());
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        TopDocs topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
                assertEquals(2, topDocs.scoreDocs[1].doc);
    }
            builder.add(new MatchAllDocsQuery(), Occur.MUST);
        indexWriter.close();
        builder.add(builder1.build(), Occur.SHOULD);
        controlQuery = requireScore ? controlQuery : new ConstantScoreQuery(controlQuery);
                assertEquals(2L, topDocs.totalHits.value());
        return shardSearcher.search(percolateQuery, 10);
        MemoryIndex memoryIndex = new MemoryIndex();
            return new Weight(this) {
                                Query query = leaf.apply(doc);
        query = fieldType.percolateQuery("_name", queryStore, Collections.singletonList(new BytesArray("{}")), percolateSearcher, false, v);
        BlendedTermQuery blendedTermQuery = BlendedTermQuery.dismaxBlendedQuery(
        Query percolateQuery = fieldType.percolateQuery(
        builder2 = new BooleanQuery.Builder();
        builder3.add(new TermQuery(new Term("field", "value4")), Occur.MUST);
    public void testPercolateSmallAndLargeDocument() throws Exception {
    ) {
        addQuery(DoublePoint.newRangeQuery("double_field", 20, 25), docs);
    public void testRangeQueries() throws Exception {
import java.util.HashMap;
            MemoryIndex memoryIndex = MemoryIndex.fromDocument(document, new WhitespaceAnalyzer());
                        public int docID() {
            .startObject(queryField)
                }
        builder1.add(new TermQuery(new Term("field", "value1")), Occur.MUST);
import org.opensearch.test.VersionUtils;
                            return memoryIndexIterator;
                subQuery = intFieldType.rangeQuery(range[0], range[1], true, true, null, null, null, context);
        indexWriter.close();
import org.opensearch.core.common.bytes.BytesArray;
            .build();
            final IndexSearcher percolatorIndexSearcher = memoryIndex.createSearcher();
        result = executeQuery(queryStore, memoryIndex, shardSearcher);
            .field("type", "float")
        memoryIndex = MemoryIndex.fromDocument(Collections.singleton(new LongPoint("long_field", 7L)), new WhitespaceAnalyzer());
                            }
        IndexMetadata build = IndexMetadata.builder("")
            null,
                document.add(new StringField("field", "value4", Field.Store.NO));
            }
        builder.add(builder2.build(), Occur.MUST);
        builder = new BooleanQuery.Builder();
            "_name",
            false,
        indexWriter.addDocuments(docs);
    private static final class ControlQuery extends Query {
                    assertThat(explain1.getValue(), equalTo(explain2.getValue()));
        }
import org.junit.Before;
                document = new Document();
            if (randomBoolean()) {
            percolateSearcher,
        addQuery(blendedTermQuery, documents);
            .startObject("int_field")
        queryFunctions.add(MatchNoDocsQuery::new);
            try (IndexReader ir = DirectoryReader.open(directory)) {
        duelRun(queryStore, memoryIndex, shardSearcher);
                BooleanQuery candidateQuery = (BooleanQuery) query.getCandidateMatchesQuery();
                assertEquals(2, topDocs.scoreDocs[1].doc);
            if (randomBoolean()) {
    }
            addQuery(new MatchAllDocsQuery(), documents);
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
        QueryShardContext context = createSearchContext(indexService).getQueryShardContext();
                    }
        addQuery(new FunctionScoreQuery(new MatchAllDocsQuery(), null, 1f), docs);
        fieldMapper.processQuery(query, parseContext);
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
        doc = Collections.singleton(new DoublePoint("double_field", randomFloat()));
        public String toString(String field) {
    private static final class CustomQuery extends Query {
import org.apache.lucene.document.LongPoint;
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
                            return _score[0];
    public void deinit() throws Exception {
                subQuery = randomBQ(depth + 1, stringValues, ranges, intFieldType, context);
        addQuery(FloatPoint.newRangeQuery("float_field", 15, 20), docs);
        MappedFieldType intFieldType = mapperService.fieldType("int_field");
        );
            () -> intFieldType.rangeQuery(
                document.add(new StringField("field", "value1", Field.Store.NO));
        queryFunctions.add(() -> new TermQuery(new Term(field2, randomFrom(stringContent.get(field2)))));
            Version.CURRENT
import org.apache.lucene.search.DocIdSetIterator;
            }
        indexWriter.addDocuments(docs);
        directory.close();
                        builder.append(term.utf8ToString()).append(',');
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
            .endObject()
            stringContent.put("field" + i, values);
        topDocs = shardSearcher.search(query, 1);
        memoryIndex.addField("field", "value", new WhitespaceAnalyzer());
            queryStore,
        addQuery(commonTermsQuery, documents);
                PercolateQuery query = (PercolateQuery) fieldType.percolateQuery(
        addQuery(spanOrQuery, documents);
        List<ParseContext.Document> docs = new ArrayList<>();
    public void testDuelSpecificQueries() throws Exception {
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
                    builder.add(new TermQuery(new Term("unknown_field", randomAlphaOfLength(8))), occur = Occur.MUST_NOT);
        query = fieldType.percolateQuery("_name", queryStore, Collections.singletonList(new BytesArray("{}")), percolateSearcher, false, v);
        assertEquals(1L, topDocs.totalHits.value());
                    CheckedFunction<Integer, Query, IOException> leaf = queryStore.getQueries(context);
        int lowerInt = randomIntBetween(0, 256);
        );
        PercolateQuery query = (PercolateQuery) fieldType.percolateQuery(
        }
            this.term = term;
import java.io.IOException;
        float lowerFloat = randomIntBetween(0, 256);
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        @Override
        config.setMergePolicy(NoMergePolicy.INSTANCE);
 * SPDX-License-Identifier: Apache-2.0
        IndexWriterConfig config = new IndexWriterConfig(new WhitespaceAnalyzer());
                                throw new RuntimeException(e);
                    v
        }
        builder = new BooleanQuery.Builder();
                subQuery = new TermQuery(new Term("string_field", randomFrom(stringValues)));
            }
                String queryToString = shardSearcher.storedFields().document(controlTopDocs.scoreDocs[i].doc).get("query_to_string");
import org.opensearch.index.query.QueryShardContext;
    private PercolatorFieldMapper.PercolatorFieldType fieldType;
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        );
    public void testDuelIdBased() throws Exception {
            return new FunctionScoreQuery(innerQuery, minScore, 1f);
                document.add(new StringField("field", "value5", Field.Store.NO));
            .endObject()
 */
        @Override
        addQuery(builder.build(), docs);
            builder.add(new MatchAllDocsQuery(), Occur.SHOULD);
        assertEquals(1L, topDocs.totalHits.value());
            addQuery(query, documents);
            }
                    occur = randomFrom(Arrays.asList(Occur.FILTER, Occur.MUST, Occur.SHOULD));
            if (randomBoolean()) {
import org.apache.lucene.search.DisjunctionMaxQuery;
import org.apache.lucene.search.BooleanQuery;
        shardSearcher.setQueryCache(null);
            Version.CURRENT
import org.apache.lucene.search.SortField;
        double lowerDouble = randomDoubleBetween(0, 256, true);
        document.add(new IntPoint("int_field", 4));
                }
        // Disable query cache, because ControlQuery cannot be cached...
            Collections.singletonList(new BytesArray("{}")),
            .endObject()
            for (int i = 0; i < numClauses; i++) {
            List<Field> numberFields = NumberFieldMapper.NumberType.INTEGER.createFields(
                document.add(numberField);
            }
import org.apache.lucene.document.InetAddressPoint;
                true,
            new WhitespaceAnalyzer()
        percolateSearcher = memoryIndex.createSearcher();
                            try {
            );
        assertEquals(1, topDocs.scoreDocs.length);
        addQuery(IntPoint.newRangeQuery("int_field", 0, 5), docs);
                builder.add(createRandomBooleanQuery(depth + 1, fields, content, intFieldType, intValues), occur);
        );
        memoryIndex = MemoryIndex.fromDocument(Collections.singleton(new DoublePoint("double_field", 21)), new WhitespaceAnalyzer());
                document.add(new StringField("field", "value3", Field.Store.NO));
                Query randomBQ = randomBQ(1, stringValues, ranges, intFieldType, context);
        assertThat(result.scoreDocs.length, equalTo(1));
        fieldType = (PercolatorFieldMapper.PercolatorFieldType) fieldMapper.fieldType();
                    Scorer scorer = scorer(context);
        builder.setMinimumNumberShouldMatch(randomIntBetween(0, numShouldClauses));
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
import org.apache.lucene.index.IndexReader;
                documents.add(document);
            mapperService.documentMapperParser(),
            new Term[] { new Term("field", "quick"), new Term("field", "brown"), new Term("field", "fox") },
}
        addQuery(HalfFloatPoint.newRangeQuery("half_float_field", lowerHalfFloat, upperHalfFloat), documents);
                String field = randomFrom(stringFields);
                builder.add(new MatchAllDocsQuery(), Occur.MUST_NOT);
            logger.info("Test with document: {}" + document);
        directoryReader = DirectoryReader.open(directory);
        addQuery(new FunctionScoreQuery(new TermQuery(new Term("field", "value")), null, 1f), docs);
        memoryIndex.addField("field", "value1 value4 value5", new WhitespaceAnalyzer());
            };
        }
import org.apache.lucene.sandbox.search.CoveringQuery;
                    String field = randomFrom(fields);
        }
        PercolateQuery query = (PercolateQuery) fieldType.percolateQuery("_name", queryStore, sources, percolateSearcher, false, v);
        doc = Collections.singleton(new LongPoint("long_field", randomLong()));
            .endObject()
                int[] range = randomFrom(ranges);
        addQuery(builder.build(), docs);
        Document document = new Document();
 * not use this file except in compliance with the License.
    }
        builder.add(new TermQuery(new Term("field", "value3")), Occur.MUST);
        assertEquals(1, topDocs.scoreDocs[1].doc);
                    String field = randomFrom(fields);
        builder.add(new TermQuery(new Term("field", "value5")), Occur.SHOULD);
        topDocs = shardSearcher.search(query, 1);
        addQuery(spanNotQuery, documents);
        Document document = new Document();
        // This will trigger using the TermsQuery instead of individual term query clauses in the CoveringQuery:
        // Disable query cache, because ControlQuery cannot be cached...
                        }
            throw ae;
        for (int i = 0; i < numDocs; i++) {
import java.util.Map;
import org.apache.lucene.search.FilteredDocIdSetIterator;
            .endObject()
            .field("type", "integer")
        // many iterations with boolean queries, which are the most complex queries to deal with when nested
        builder.add(new MatchAllDocsQuery(), Occur.MUST);
            intValues.add(randomInt());
        duelRun(queryStore, memoryIndex, shardSearcher);
        queryFunctions.add((id) -> new WildcardQuery(new Term("field", id + "*")));
    @Override
 * compatible open source license.
        builder.add(new TermQuery(new Term("field", "value3")), Occur.SHOULD);
        );
        TopDocs topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
        List<ParseContext.Document> docs = new ArrayList<>();
                }
        public int hashCode() {
        assertEquals(1L, topDocs.totalHits.value());
            settings,
        QueryShardContext context = createSearchContext(indexService).getQueryShardContext();
        assertThat(result.scoreDocs[0].doc, equalTo(5));
        // Disable query cache, because ControlQuery cannot be cached...
        @Override
import org.apache.lucene.search.Weight;
                        builder.add(new TermQuery(new Term("unknown_field", randomAlphaOfLength(8))), occur);
        queryFunctions.add(
                values.add(randomAlphaOfLength(8));
import org.apache.lucene.search.ScoreMode;
            }
            }
        commonTermsQuery.add(new Term("field", "quick"));
        }
            .field("type", "double")
        assertEquals(3, topDocs.scoreDocs[0].doc);
            Iterable<? extends IndexableField> doc = Collections.singleton(new StringField("field", id, Field.Store.NO));
        List<String> stringValues,
import org.apache.lucene.index.memory.MemoryIndex;
                    logger.error("controlTopDocs.scoreDocs[{}].minimum_should_match_field=[NO_VALUE]", i);
            }
        IndexSearcher shardSearcher = newSearcher(directoryReader);
            builder.add(new TermQuery(new Term("field", id)), Occur.SHOULD);
            addQuery(new MatchNoDocsQuery(), documents);
        // https://github.com/elastic/elasticsearch/issues/29393
        queryFunctions.add((id) -> new MatchAllDocsQuery());
            Occur occur;
                assertEquals(2L, topDocs.totalHits.value());
import org.apache.lucene.queries.CommonTermsQuery;
            logger.error("topDocs.scoreDocs.length={}", topDocs.scoreDocs.length);
        MappedFieldType intFieldType,
            return "control{" + field + "}";
                context
                    queryStore,
            if (onlyShouldClauses) {
                document = new Document();
                StringBuilder builder = new StringBuilder();
        long randomLong = randomIntBetween((int) lowerLong, (int) upperLong);
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
    }
import org.apache.lucene.document.StringField;
        IndexSearcher shardSearcher = newSearcher(directoryReader);
                        }
        final int numClauses = randomIntBetween(1, 4);
import java.util.stream.Collectors;
import org.apache.lucene.store.Directory;
        duelRun(queryStore, memoryIndex, shardSearcher);
                List.of(new BytesRef(randomFrom(stringContent.get(field1))), new BytesRef(randomFrom(stringContent.get(field1))))
        addQuery(builder.build(), docs);
            queryStore,
        indexWriter.addDocuments(documents);
        int numDocs = randomIntBetween(queryFunctions.size(), queryFunctions.size() * 3);
            false,
            Version.CURRENT
                if (randomBoolean()) {
                numShouldClauses++;
        queryFunctions.add((id) -> new PrefixQuery(new Term("field", id)));
            duelRun(queryStore, memoryIndex, shardSearcher);
                occur = Occur.SHOULD;
    }
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        }
                                } else {
    }
        indexWriter.close();
        SpanNearQuery spanNearQuery = new SpanNearQuery.Builder("field", true).addClause(new SpanTermQuery(new Term("field", "quick")))
            return builder.build();
        return builder.build();
        for (int i = 0; i < numFields; i++) {
        for (int[] range : ranges) {
                iw.addDocuments(documents); // IW#addDocuments(...) ensures we end up with a single segment
        @Override
        builder.add(new MatchAllDocsQuery(), Occur.SHOULD);
        {
                                TopDocs topDocs = percolatorIndexSearcher.search(query, 1);
import java.util.Arrays;
            }
            "_name",
        builder.setMinimumNumberShouldMatch(3);
            for (Field numberField : numberFields) {
import java.util.Collection;
                public String toString() {
import org.opensearch.index.IndexSettings;
            builder.add(new MatchAllDocsQuery(), Occur.SHOULD);
                        @Override
            .startObject("type")
                List.of(new BytesRef(randomFrom(stringContent.get(field1))), new BytesRef(randomFrom(stringContent.get(field1))))
        duelRun(queryStore, memoryIndex, shardSearcher);
                                }
        result = executeQuery(queryStore, memoryIndex, shardSearcher);
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
                        @Override
        for (int i = 0; i < numRandomBoolQueries; i++) {
            List<Query> clauses = new ArrayList<>();
        commonTermsQuery.add(new Term("field", "brown"));
import static org.opensearch.common.network.InetAddresses.forString;
            builder.add(new TermQuery(new Term("field", id)), Occur.SHOULD);
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        {
        for (int i = 0; i < numDocs; i++) {
        public boolean equals(Object obj) {
        MappedFieldType intFieldType,
public class CandidateQueryTests extends OpenSearchSingleNodeTestCase {
        shardSearcher.setQueryCache(null);
        duelRun(queryStore, memoryIndex, shardSearcher);
            .addClause(new SpanTermQuery(new Term("field", "brown")))
        }
        }
        List<ParseContext.Document> docs = new ArrayList<>();
                field2,
        shardSearcher.setQueryCache(null);
    private DocumentMapper documentMapper;
                }
            int[] range = randomFrom(ranges);
            this.memoryIndex = memoryIndex;
        boolean onlyShouldClauses = rarely();
                    assertThat(explain1.isMatch(), equalTo(explain2.isMatch()));
                    return new DefaultScorerSupplier(new Scorer() {
        memoryIndex.addField("field", "value1 value2", new WhitespaceAnalyzer());
    public void testDuel() throws Exception {
        indexWriter.addDocuments(documents);
            builder.add(new MatchAllDocsQuery(), Occur.MUST);
                    logger.error("controlTopDocs.scoreDocs[{}].minimum_should_match_field={}", i, numericValues.longValue());
            builder.add(new TermQuery(new Term("field", id)), Occur.MUST);
            percolateSearcher,
        @Override
        float lowerHalfFloat = randomIntBetween(0, 256);
        assertEquals(0, topDocs.scoreDocs[0].doc);
        assertEquals(1, topDocs.scoreDocs.length);
        private ControlQuery(MemoryIndex memoryIndex, PercolateQuery.QueryStore queryStore) {
        assertEquals(2L, topDocs.totalHits.value());
                } else {
        percolateSearcher = memoryIndex.createSearcher();
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(document, new WhitespaceAnalyzer());
                innerQuery = new TermQuery(new Term(field1, randomFrom(stringContent.get(field1))));
        long lowerLong = randomIntBetween(0, 256);
import static org.hamcrest.Matchers.equalTo;
        Map<String, List<String>> content,
        fieldMapper = (PercolatorFieldMapper) mapperService.documentMapper().mappers().getMapper(queryField);
import org.apache.lucene.document.IntPoint;
        queryFunctions.add(() -> intFieldType.termQuery(randomFrom(intValues), context));
import org.apache.lucene.index.DirectoryReader;
                            return _score[0];
                        protected boolean match(int doc) {
        shardSearcher.setQueryCache(null);
                    fieldType.minimumShouldMatchField.name()
        doc = Collections.singleton(new LongPoint("long_field", randomLong));
                    queryStore,
                        }
        assertEquals(4, topDocs.scoreDocs[2].doc);
import org.apache.lucene.queries.spans.SpanNotQuery;
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
            .startObject()
                @Override
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
import org.apache.lucene.search.PhraseQuery;
        documentMapper = mapperService.merge("type", new CompressedXContent(mapper), MapperService.MergeReason.MAPPING_UPDATE);
                IndexSearcher percolateSearcher = new IndexSearcher(ir);
                            } catch (IOException e) {
            int numClauses = randomIntBetween(1, 1 << randomIntBetween(2, 4));
                assertEquals(2, topDocs.scoreDocs[1].doc);
        );
                false,
        duelRun(queryStore, memoryIndex, shardSearcher);
        List<ParseContext.Document> documents = new ArrayList<>();
        public void visit(QueryVisitor visitor) {
        document.add(new IntPoint("int_field", 7));
        int numRandomBoolQueries = 1000;
        List<Supplier<Query>> queryFunctions = new ArrayList<>();
        assertEquals(2, topDocs.scoreDocs.length);
        assertEquals(0, topDocs.scoreDocs[0].doc);
                builder.setMinimumNumberShouldMatch(2);
        addQuery(builder.build(), docs);
import org.apache.lucene.index.NoMergePolicy;
            .field("type", "half_float")
    private PercolateQuery.QueryStore queryStore;
        List<ParseContext.Document> documents = new ArrayList<>();
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
        indexService = createIndex(indexName, Settings.EMPTY);
                builder.add(new MatchAllDocsQuery(), Occur.SHOULD);
        PercolateQuery query = (PercolateQuery) fieldType.percolateQuery("_name", queryStore, sources, percolateSearcher, false, v);
                if (exact) {
                }
                    if (randomBoolean()) {
        float randomHalfFloat = randomIntBetween((int) lowerHalfFloat, (int) upperHalfFloat);
                intValues.get(4),
                    false,
                builder.add(new MatchNoDocsQuery("no reason"), Occur.MUST_NOT);
            logger.info("Test with document: {}" + document);
                ShapeRelation.WITHIN,
        );
        boolean requireScore = randomBoolean();
                                    return true;
                        public DocIdSetIterator iterator() {
        assertEquals(0, topDocs.scoreDocs[0].doc);
        memoryIndex.addField("field", "value1", new WhitespaceAnalyzer());
    private BooleanQuery randomBQ(
    }
        List<ParseContext.Document> docs = new ArrayList<>();
package org.opensearch.percolator;
            .build();
            MemoryIndex memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
            visitor.visitLeaf(this);
        PercolateQuery query = (PercolateQuery) fieldType.percolateQuery("_name", queryStore, sources, percolateSearcher, false, v);
            return classHash();
                        builder.add(intFieldType.termQuery(randomFrom(intValues), null), occur);
        public void visit(QueryVisitor visitor) {
        List<ParseContext.Document> documents = new ArrayList<>();
import org.opensearch.index.mapper.MapperService;
import org.apache.lucene.search.IndexSearcher;
            try (IndexReader ir = DirectoryReader.open(directory)) {
                true,
        MemoryIndex memoryIndex = new MemoryIndex();
        doc = Collections.singleton(new InetAddressPoint("ip_field", forString("192.168.1." + randomIntBetween(lowerIpPart, upperIpPart))));
        queryFunctions.add(MatchAllDocsQuery::new);
        SpanOrQuery spanOrQuery = new SpanOrQuery(spanNearQuery, spanNearQuery2);
        throws IOException {
            percolateSearcher,
    @Before
        @Override
            if (randomBoolean()) {
            if (occur == Occur.SHOULD) {
        duelRun(queryStore, memoryIndex, shardSearcher);
        String queryField = "query_field";
import java.util.function.Function;
import org.apache.lucene.index.PostingsEnum;
        assertEquals(0, topDocs.scoreDocs[0].doc);
            duelRun(queryStore, memoryIndex, shardSearcher);
                } else {
                    float _score[] = new float[] { boost };
    private void addQuery(Query query, List<ParseContext.Document> docs) {
        directoryReader = DirectoryReader.open(directory);
            String id = Integer.toString(i);
        Collections.sort(intValues);
                TopDocs topDocs = shardSearcher.search(query, 10);
        // Add to string representation of the query to make debugging easier:
import org.apache.lucene.search.Sort;
                @Override
        assertEquals(4, topDocs.scoreDocs[2].doc);
import org.apache.lucene.document.TextField;
    }
                assertEquals(1, topDocs.scoreDocs[0].doc);
        directory = newDirectory();
        queryFunctions.add(() -> new TermQuery(new Term(field1, randomFrom(stringContent.get(field1)))));
import org.apache.lucene.index.TermsEnum;
import org.opensearch.common.CheckedFunction;
        builder1.add(new TermQuery(new Term("field", "value1")), Occur.MUST);
            .toString();
        double upperDouble = lowerDouble + randomDoubleBetween(0, 32, true);
            }
        final BooleanQuery.Builder builder = new BooleanQuery.Builder();
            return builder.build();
                                    return false;
            this.queryStore = queryStore;
        assertEquals(3, topDocs.scoreDocs.length);
            1.0f
import org.opensearch.common.geo.ShapeRelation;
        }
        directoryReader = DirectoryReader.open(directory);
                    Explanation explain1 = shardSearcher.explain(query, topDocs.scoreDocs[j].doc);
        int upperIpPart = randomIntBetween(lowerIpPart, 255);
                TermsEnum tenum = MultiTerms.getTerms(shardSearcher.getIndexReader(), fieldType.queryTermsField.name()).iterator();
            } else if (rarely() && depth <= 3) {
        doc = Collections.singleton(new InetAddressPoint("ip_field", forString("192.168.1." + randomIntBetween(0, 255))));
                boolean exact = numericValues.advanceExact(controlTopDocs.scoreDocs[i].doc);
        builder2.add(new TermQuery(new Term("field", "value2")), Occur.MUST);
        }
        memoryIndex.addField("field", "value1 value2 value3", new WhitespaceAnalyzer());
        int numClauses = randomIntBetween(1, 1 << randomIntBetween(2, 4)); // use low numbers of clauses more often
        builder.add(new TermQuery(new Term("field", "value4")), Occur.MUST);
    }
            .field("type", "keyword")
        }
                        }
        directoryReader = DirectoryReader.open(directory);
import org.apache.lucene.index.MultiTerms;
    public void testDuplicatedClauses() throws Exception {
                occur = randomFrom(Arrays.asList(Occur.FILTER, Occur.MUST, Occur.SHOULD));
            try (IndexWriter iw = new IndexWriter(directory, newIndexWriterConfig())) {
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        addQuery(FloatPoint.newRangeQuery("float_field", lowerFloat, upperFloat), documents);
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        assertEquals(2, topDocs.scoreDocs[1].doc);
                documents.add(document);
                assertEquals(2, topDocs.scoreDocs[1].doc);
                    } else {
import org.apache.lucene.index.IndexWriterConfig;
        indexWriter.addDocuments(docs);
        String field1 = randomFrom(stringFields);
        );
                "int_field",
            .startObject("type")
            .startObject("ip_field")
            "_name",
            }
            duelRun(queryStore, memoryIndex, shardSearcher);
import org.apache.lucene.index.Term;
                    PostingsEnum penum = tenum.postings(null);
        }
import org.opensearch.common.settings.Settings;
 *
            () -> new TermInSetQuery(
                    percolateSearcher,
        stringValues.add("value3");
 * You may obtain a copy of the License at
                true,
        final boolean onlyShouldClauses = randomBoolean();
            return builder.build();
        addQuery(LongPoint.newRangeQuery("long_field", lowerLong, upperLong), documents);
 * KIND, either express or implied.  See the License for the
                                    if (scoreMode.needsScores()) {
                logger.error("topDocs.scoreDocs[{}].score={}", i, topDocs.scoreDocs[i].score);
            false,
            .startObject("properties")
        assertEquals(3L, topDocs.totalHits.value());
        builder2.add(new TermQuery(new Term("field", "value2")), Occur.MUST);
                clauses.add(new TermQuery(new Term(field, randomFrom(stringContent.get(field)))));
    public void testFunctionScoreQuery() throws Exception {
        directoryReader = DirectoryReader.open(directory);
        }
        query = (PercolateQuery) fieldType.percolateQuery("_name", queryStore, sources, percolateSearcher, false, v);
            }
        memoryIndex = new MemoryIndex();
                    int fieldNumber = 2 + i;
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
        queries = new ArrayList<>();
        for (int i = 0; i < numClauses; i++) {
        builder.add(new TermQuery(new Term("field", "value2")), Occur.MUST);
        private CustomQuery(Term term) {
        int randomInt = randomIntBetween(lowerInt, upperInt);
        percolateSearcher = memoryIndex.createSearcher();
                    builder.add(intFieldType.termQuery(randomFrom(intValues), null), occur = Occur.MUST_NOT);
        builder.add(builder3.build(), Occur.SHOULD);
        addQuery(DoublePoint.newRangeQuery("double_field", lowerDouble, upperDouble), documents);
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(Collections.singleton(new IntPoint("int_field", 3)), new WhitespaceAnalyzer());
            false,
            for (int i = 0; i < controlTopDocs.scoreDocs.length; i++) {
                    }
                        @Override
        memoryIndex = MemoryIndex.fromDocument(Collections.singleton(new HalfFloatPoint("half_float_field", 12)), new WhitespaceAnalyzer());
                        int result = scorer.iterator().advance(doc);
        builder1 = new BooleanQuery.Builder();
        document.add(new TextField("field", "the quick brown fox jumps over the lazy dog", Field.Store.NO));
        builder.add(new TermQuery(new Term("field", "value3")), Occur.MUST);
            for (Field numberField : numberFields) {
        assertEquals(3L, topDocs.totalHits.value());
        queryFunctions.add(() -> intFieldType.termsQuery(Arrays.asList(randomFrom(intValues), randomFrom(intValues)), context));
    }
            addQuery(query, documents);
        builder1.add(new TermQuery(new Term("field", "value2")), Occur.MUST);
import org.apache.lucene.queries.spans.SpanNearQuery;
        IndexSearcher shardSearcher = newSearcher(directoryReader);
import org.apache.lucene.search.TermInSetQuery;
        directoryReader = DirectoryReader.open(directory);
import org.apache.lucene.search.TopDocs;
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
        List<int[]> ranges,
            Query query = queryFunction.get();
                between(range[0], range[1]),
        }
        shardSearcher.setQueryCache(null);
        int depth,
        duelRun(queryStore, memoryIndex, shardSearcher);
            }
                } else {
        Version v = Version.CURRENT;
        TopDocs topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
    private DirectoryReader directoryReader;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(2L, topDocs.totalHits.value());
        assertThat(result.scoreDocs[0].doc, equalTo(3));
        for (Supplier<Query> queryFunction : queryFunctions) {
        addQuery(builder.build(), docs);
        for (Map.Entry<String, List<String>> entry : stringContent.entrySet()) {
        queryFunctions.add((id) -> new MatchNoDocsQuery("no reason at all"));
            } else {
        List<ParseContext.Document> docs = new ArrayList<>();
import org.apache.lucene.search.QueryVisitor;
                List<Document> documents = new ArrayList<>();
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {
                );
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
                assertThat(candidateQuery.clauses().get(0).query(), instanceOf(CoveringQuery.class));
        builder.setMinimumNumberShouldMatch(2);
            if (randomBoolean() && depth <= 3) {
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
            return sameClassAs(obj);
        builder.add(new MatchAllDocsQuery(), Occur.MUST);
        ParseContext.InternalParseContext parseContext = new ParseContext.InternalParseContext(
            builder.add(new TermQuery(new Term("field", id)), Occur.SHOULD);
        indexWriter.close();
                iw.addDocument(document);
import org.apache.lucene.sandbox.document.HalfFloatPoint;
            if (randomBoolean()) {
        builder.add(new TermQuery(new Term("field", "value2")), Occur.MUST);
    ) {
            percolateSearcher,
import org.opensearch.index.IndexService;
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
        indexWriter.close();
                builder.add(new CustomQuery(new Term("field", id)), Occur.MUST);
        Version v = Version.CURRENT;
        topDocs = shardSearcher.search(query, 1);
        builder.add(new TermQuery(new Term("field", "value1")), Occur.MUST);
        doc = Collections.singleton(new FloatPoint("float_field", randomFloat()));
                        String field = randomFrom(fields);
        percolateSearcher = memoryIndex.createSearcher();
 * software distributed under the License is distributed on an
import org.apache.lucene.index.MultiDocValues;
 *
        }
import org.apache.lucene.document.DoublePoint;
            }
            percolateSearcher,
/*
            documents
            addQuery(new PhraseQuery(0, "string_field", stringValues.toArray(new String[0])), documents);
            }
        indexWriter.addDocuments(docs);
                        public float score() throws IOException {
                    });
                for (BytesRef term = tenum.next(); term != null; term = tenum.next()) {
                        }
            for (int i = 0; i < numBooleanQueries; i++) {
        builder.add(IntPoint.newRangeQuery("int_field", 0, 5), Occur.SHOULD);
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(document, new WhitespaceAnalyzer());
 * Unless required by applicable law or agreed to in writing,
    protected Collection<Class<? extends Plugin>> getPlugins() {
        addQuery(builder.build(), docs);
        for (int j = 0; j < numValues; j++) {
import org.apache.lucene.document.Field;
            Collections.singletonList(new BytesArray("{}")),
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return builder.build();
        queryFunctions.add((id) -> new TermQuery(new Term("field", id)));
        shardSearcher.setQueryCache(null);
        // Recreates a similar scenario that made testDuel() fail randomly:
import org.opensearch.Version;
        TopDocs topDocs = shardSearcher.search(query, 100);
        memoryIndex = MemoryIndex.fromDocument(Collections.singleton(new FloatPoint("float_field", 17)), new WhitespaceAnalyzer());
        List<ParseContext.Document> docs = new ArrayList<>();
        addQuery(LongPoint.newRangeQuery("long_field", 5L, 10L), docs);
    }
    public void testDuelRangeQueries() throws Exception {
    public void testDuplicatedClauses2() throws Exception {
import org.apache.lucene.search.Scorer;
import java.util.ArrayList;
import org.apache.lucene.search.PrefixQuery;
        queryDocument.add(new StoredField("query_to_string", query.toString()));
                assertEquals(0, topDocs.scoreDocs[0].doc);
            addQuery(rangeQuery, documents);
        builder.add(new TermQuery(new Term("field", "value1")), Occur.SHOULD);
        addQuery(spanNearQuery, documents);
            .startObject()
        percolateSearcher = memoryIndex.createSearcher();
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertEquals(1, topDocs.scoreDocs.length);
                if (requireScore) {
    }
            null
        duelRun(queryStore, memoryIndex, shardSearcher);
        BooleanQuery.Builder builder3 = new BooleanQuery.Builder();
        duelRun(queryStore, memoryIndex, shardSearcher);
                );
        assertEquals(2, topDocs.scoreDocs[0].doc);
        Query controlQuery = new ControlQuery(memoryIndex, queryStore);
            "_name",
                for (int i = 0; i < 1024; i++) {
            for (int j = 0; j < topDocs.scoreDocs.length; j++) {
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
            InetAddressPoint.newRangeQuery("ip_field", forString("192.168.1." + lowerIpPart), forString("192.168.1." + upperIpPart)),
                // Additional stored information that is useful when debugging:
 * specific language governing permissions and limitations
            }
        for (String value : stringValues) {
        float upperHalfFloat = lowerHalfFloat + randomIntBetween(0, 32);
        assertEquals(1, topDocs.scoreDocs[0].doc);
                PercolateQuery query = (PercolateQuery) fieldType.percolateQuery(
            queryStore,
        builder2.add(new TermQuery(new Term("field", "value3")), Occur.MUST);
        public boolean equals(Object obj) {
        });
                                if (topDocs.scoreDocs.length > 0) {
        Version v = Version.CURRENT;
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);
            .endObject()
        });
        duelRun(queryStore, memoryIndex, shardSearcher);
            Query rangeQuery = intFieldType.rangeQuery(range[0], range[1], true, true, null, null, null, context);
        });
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        List<BytesReference> sources = Collections.singletonList(new BytesArray("{}"));
        assertThat(result.scoreDocs.length, equalTo(1));
        }
            if (onlyShouldClauses) {
import org.apache.lucene.document.FloatPoint;
            }
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        }
        queryFunctions.add((id) -> {
        return builder.build();
        }
        float upperFloat = lowerFloat + randomIntBetween(0, 32);
    }
        int numFields = randomIntBetween(1, 3);
    private IndexService indexService;
                assertEquals(2L, topDocs.totalHits.value());
        @Override
        });
        Query query = fieldType.percolateQuery(
        List<String> stringValues = new ArrayList<>();
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(1L, topDocs.totalHits.value());
                    } else {
                                        _score[0] = topDocs.scoreDocs[0].score;
import org.apache.lucene.search.Explanation;
                NumericDocValues numericValues = MultiDocValues.getNumericValues(
        topDocs = shardSearcher.search(new ConstantScoreQuery(query), 10);
        builder.add(new TermQuery(new Term("field", "value3")), Occur.SHOULD);
                }
            }
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
        queryFunctions.add((id) -> {
            () -> new TermInSetQuery(
                    percolateSearcher,
            }
        MemoryIndex memoryIndex = new MemoryIndex();
            .numberOfReplicas(0)
        List<String> stringFields = new ArrayList<>(stringContent.keySet());
            queryStore,
        indexWriter = new IndexWriter(directory, config);
        docs.add(queryDocument);
        );
                } else {
        }
        indexWriter.close();
        percolateSearcher = memoryIndex.createSearcher();
                logger.error("controlTopDocs.scoreDocs[{}].query_to_string={}", i, queryToString);
        String indexName = "test";
    }
        private final PercolateQuery.QueryStore queryStore;
        ranges.add(new int[] { 15, 50 });
        addQuery(LongPoint.newRangeQuery("long_field", lowerLong, upperLong), documents);
        Query query = requireScore ? percolateQuery : new ConstantScoreQuery(percolateQuery);
                    }
        TopDocs result = executeQuery(queryStore, memoryIndex, shardSearcher);
        builder.add(new TermQuery(new Term("field", "value4")), Occur.SHOULD);
            builder.add(new MatchAllDocsQuery(), Occur.SHOULD);
 * license agreements. See the NOTICE file distributed with
            } else {
                    false,
            for (int i = 0; i < topDocs.scoreDocs.length; i++) {
        // Disable query cache, because ControlQuery cannot be cached...
        // Disable query cache, because ControlQuery cannot be cached...
                logger.error("topDocs.scoreDocs[{}].doc={}", i, topDocs.scoreDocs[i].doc);
        assertEquals(0, topDocs.scoreDocs[0].doc);
        List<Function<String, Query>> queryFunctions = new ArrayList<>();
                Document document = new Document();
            return new DisjunctionMaxQuery(clauses, 0.01f);
                numShouldClauses++;
    }
                assertEquals(1, topDocs.scoreDocs[0].doc);
/*
        String mapper = XContentFactory.jsonBuilder()
                assertThat(topDocs.scoreDocs[j].doc, equalTo(controlTopDocs.scoreDocs[j].doc));
            }
            Occur occur;
                    document.add(new StringField("field", "value" + fieldNumber, Field.Store.NO));
                @Override
import org.apache.lucene.search.MatchAllDocsQuery;
        Iterable<? extends IndexableField> doc = Collections.singleton(new IntPoint("int_field", randomInt));
            logger.error("controlTopDocs.totalHits={}", controlTopDocs.totalHits);
        addQuery(IntPoint.newRangeQuery("int_field", lowerInt, upperInt), documents);
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
                innerQuery = new PhraseQuery(field1, randomFrom(stringContent.get(field1)), randomFrom(stringContent.get(field1)));
                        if (result == doc) {
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) {
            .endObject()
                TopDocs topDocs = shardSearcher.search(query, 10);
                null,
    public void testMsmAndRanges_disjunction() throws Exception {
                    if (randomBoolean()) {
        builder.add(new MatchAllDocsQuery(), Occur.MUST);
    }
            document.add(new TextField("string_field", value, Field.Store.NO));
    public void init() throws Exception {
            .startObject("half_float_field")
        assertEquals(1, topDocs.totalHits.value());
        document.add(new LongPoint("long_field", randomLong));
        assertThat(result.scoreDocs.length, equalTo(1));
        } catch (AssertionError ae) {
                addQuery(randomBQ, documents);
    }
    public void testPercolateMatchAll() throws Exception {
                occur = Occur.SHOULD;
        float randomFloat = randomIntBetween((int) lowerFloat, (int) upperFloat);
        directoryReader = DirectoryReader.open(directory);
        try (Directory directory = new ByteBuffersDirectory()) {
                if (randomBoolean()) {
    private PercolatorFieldMapper fieldMapper;
 * The OpenSearch Contributors require contributions made to
        queryFunctions.add((id) -> {
            }
            return builder.build();
                    FilteredDocIdSetIterator memoryIndexIterator = new FilteredDocIdSetIterator(allDocs) {
        builder.add(new TermQuery(new Term("field", "value2")), Occur.SHOULD);
                    Collections.singletonList(new BytesArray("{}")),
                true,
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        // Empty percolator doc:
                    return Explanation.noMatch("ControlQuery");
                false
                logger.error("controlTopDocs.scoreDocs[{}].query_terms_field={}", i, builder.toString());
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
        queryFunctions.add((id) -> {
            .startObject("field")
        List<int[]> ranges = new ArrayList<>();
        queryFunctions.add((id) -> {
        });
                    return "weight(" + ControlQuery.this + ")";
        queryFunctions.add((id) -> new CustomQuery(new Term("field", id)));
        List<ParseContext.Document> documents = new ArrayList<>();
                assertEquals(2L, topDocs.totalHits.value());
 * Modifications Copyright OpenSearch Contributors. See
            .endObject()
                if (randomBoolean()) {
        shardSearcher.setQueryCache(null);
        directoryReader = DirectoryReader.open(directory);
        addQuery(InetAddressPoint.newRangeQuery("ip_field", forString("192.168.0.1"), forString("192.168.0.10")), docs);
                document.add(numberField);
                assertThat(candidateQuery.clauses().get(0).query(), instanceOf(TermInSetQuery.class));
        }
        builder.add(builder2.build(), Occur.SHOULD);
        {
                    // Some queries do not have a msm field. (e.g. unsupported queries)
                document.add(new StringField("field", "value2", Field.Store.NO));
import org.apache.lucene.search.ScorerSupplier;
        @Override
        memoryIndex = MemoryIndex.fromDocument(
            builder.add(subQuery, occur);
            Query innerQuery;
                assertThat(topDocs.scoreDocs[j].score, equalTo(controlTopDocs.scoreDocs[j].score));
        shardSearcher.setQueryCache(null);
                topDocs = shardSearcher.search(new ConstantScoreQuery(query), 10);
        );
            if (occur == Occur.SHOULD) {
import org.apache.lucene.search.ConstantScoreQuery;
        int depth,
                }
        try {
        List<BytesReference> sources = Collections.singletonList(new BytesArray("{}"));
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
            Collections.singletonList(new BytesArray("{}")),
        }
        assertEquals(1, topDocs.scoreDocs.length);
        shardSearcher.setQueryCache(null);
            return builder.build();
    private Directory directory;
        builder.add(IntPoint.newRangeQuery("int_field", 6, 10), Occur.SHOULD);
            Query subQuery;
        });
                assertEquals(2, topDocs.scoreDocs.length);
import org.opensearch.core.common.bytes.BytesReference;
        doc = Collections.singleton(new IntPoint("int_field", randomInt()));
import org.apache.lucene.queries.spans.SpanOrQuery;
        }
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
                field1,
        List<Integer> intValues
        addQuery(new MatchAllDocsQuery(), docs);
        long lowerLong = randomIntBetween(0, 256);
import org.opensearch.common.xcontent.XContentFactory;
            v
        query = (PercolateQuery) fieldType.percolateQuery("_name", queryStore, sources, percolateSearcher, false, v);
            .endObject()
                intValues.get(intValues.size() - 4),
        }
            .build();
        addQuery(new FunctionScoreQuery(new TermQuery(new Term("field", "value")), 10f, 1f), docs);
                    "_name",
        builder.setMinimumNumberShouldMatch(randomIntBetween(0, numShouldClauses));
            queryFunctions.add(() -> createRandomBooleanQuery(1, stringFields, stringContent, intFieldType, intValues));
import org.junit.After;
        );
                                    }
        assertEquals(1, topDocs.scoreDocs.length);
                public boolean isCacheable(LeafReaderContext ctx) {
            int numTokens = randomIntBetween(1, 64);
            if (randomBoolean()) {
                }
                topDocs = shardSearcher.search(new ConstantScoreQuery(query), 10);
        indexWriter.addDocuments(docs);
        BooleanQuery.Builder builder1 = new BooleanQuery.Builder();
        query = fieldType.percolateQuery("_name", queryStore, Collections.singletonList(new BytesArray("{}")), percolateSearcher, false, v);
                    builder.add(intFieldType.termQuery(randomFrom(intValues), null), occur);
        indexWriter.addDocuments(docs);
    private void duelRun(PercolateQuery.QueryStore queryStore, MemoryIndex memoryIndex, IndexSearcher shardSearcher) throws IOException {
            } else if (randomBoolean()) {
            logger.error("topDocs.totalHits={}", topDocs.totalHits);
import org.apache.lucene.search.WildcardQuery;
        public String toString(String field) {
        builder.add(builder1.build(), Occur.MUST);
        duelRun(queryStore, memoryIndex, shardSearcher);
        queries.add(query);
        indexWriter.close();
            .toString();
                        builder.add(new TermQuery(new Term(field, randomFrom(content.get(field)))), occur);
                builder.add(new CustomQuery(new Term("field", id)), Occur.SHOULD);
        addQuery(builder.build(), docs);
        public int hashCode() {
    }
import static org.hamcrest.Matchers.instanceOf;
        int lowerIpPart = randomIntBetween(0, 255);
            logger.error("controlTopDocs.scoreDocs.length={}", controlTopDocs.scoreDocs.length);
                    };
                    builder.add(new TermQuery(new Term(field, randomFrom(content.get(field)))), occur);
                    Explanation explain2 = shardSearcher.explain(controlQuery, controlTopDocs.scoreDocs[j].doc);
        long upperLong = lowerLong + randomIntBetween(0, 32);
            if (randomBoolean()) {
                            return Explanation.match(scorer.score(), "ControlQuery");
        builder = new BooleanQuery.Builder();
                assertEquals(2, topDocs.scoreDocs.length);
        duelRun(queryStore, memoryIndex, shardSearcher);
            )
import org.opensearch.plugins.Plugin;
        Query percolateQuery = fieldType.percolateQuery(
        addQuery(builder.build(), docs);
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
        });
            .startObject("properties")
        return Collections.singleton(PercolatorModulePlugin.class);
        assertEquals(3, topDocs.scoreDocs.length);
        builder = new BooleanQuery.Builder();
 */
        queryFunctions.add((id) -> new SpanTermQuery(new Term("field", id)));
        assertEquals(1L, topDocs.totalHits.value());
        builder.add(new MatchAllDocsQuery(), Occur.MUST);
    private IndexWriter indexWriter;
        String percolatorMapper = XContentFactory.jsonBuilder()
            try (IndexWriter iw = new IndexWriter(directory, newIndexWriterConfig())) {
                assertEquals(2, topDocs.scoreDocs.length);
        assertThat(result.scoreDocs[0].doc, equalTo(2));
            Collections.singletonList(new BytesArray("{}")),
        builder.add(new TermQuery(new Term("field", "value3")), Occur.SHOULD);
        query = fieldType.percolateQuery("_name", queryStore, Collections.singletonList(new BytesArray("{}")), percolateSearcher, false, v);
import org.apache.lucene.search.BooleanClause.Occur;
            } else {
        {
            } else if (rarely()) {
            .startObject("double_field")
        queryFunctions.add(() -> new TermQuery(new Term("unknown_field", "value")));
        ranges.add(new int[] { -5, 5 });
                }
    }
            if (randomBoolean()) {
            Query query = queryFunctions.get(i % queryFunctions.size()).apply(id);
        result = executeQuery(queryStore, memoryIndex, shardSearcher);
        builder1.add(new TermQuery(new Term("field", "value1")), Occur.FILTER);
                documents.add(document);
        assertEquals(0, topDocs.scoreDocs[0].doc);
        {
        query = fieldType.percolateQuery("_name", queryStore, Collections.singletonList(new BytesArray("{}")), percolateSearcher, false, v);
import org.apache.lucene.index.LeafReaderContext;
        }
            MemoryIndex memoryIndex = MemoryIndex.fromDocument(document, new WhitespaceAnalyzer());
            }
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
        addQuery(new FunctionScoreQuery(new MatchAllDocsQuery(), 10F, 1f), docs);
                builder.add(new MatchNoDocsQuery("no reason"), Occur.MUST_NOT);
        for (int i = 0; i < numClauses; i++) {
        directoryReader.close();
            .endObject()
            List<Field> numberFields = NumberFieldMapper.NumberType.INTEGER.createFields("int_field", intValue, true, true, false, false);
                            return memoryIndexIterator.docID();
        IndexSearcher shardSearcher = newSearcher(directoryReader);
import org.opensearch.index.mapper.ParseContext;
        CommonTermsQuery commonTermsQuery = new CommonTermsQuery(Occur.SHOULD, Occur.SHOULD, 128);
        memoryIndex = new MemoryIndex();
        assertEquals(1, topDocs.totalHits.value());
        stringValues.add("value1");
        queryFunctions.add((id) -> {
        builder.add(builder1.build(), Occur.SHOULD);
        Version v = VersionUtils.randomIndexCompatibleVersion(random());
                IndexSearcher percolateSearcher = new IndexSearcher(ir);
        assertEquals(1, topDocs.scoreDocs.length);
import org.apache.lucene.search.TermQuery;
            "_name",
        PercolateQuery query = (PercolateQuery) fieldType.percolateQuery(
        BooleanQuery.Builder builder1 = new BooleanQuery.Builder();
                }
                assertEquals(2, topDocs.scoreDocs.length);
        assertThat(result.scoreDocs[0].doc, equalTo(4));
        try (Directory directory = new ByteBuffersDirectory()) {
import org.apache.lucene.index.IndexableField;
        builder.add(new MatchAllDocsQuery(), Occur.MUST_NOT);
        indexWriter.close();
        duelRun(queryStore, memoryIndex, shardSearcher);
                    shardSearcher.getIndexReader(),
        List<ParseContext.Document> documents = new ArrayList<>();
        builder.add(new TermQuery(new Term("field", "value2")), Occur.MUST);
        builder.add(new TermQuery(new Term("field", "value2")), Occur.SHOULD);
        doc = Collections.singleton(new HalfFloatPoint("half_float_field", randomFloat()));
            .addClause(new SpanTermQuery(new Term("field", "fox")))
            .addClause(new SpanTermQuery(new Term("field", "lazy")))
        List<ParseContext.Document> docs = new ArrayList<>();
            Version.CURRENT
        Version v = Version.CURRENT;
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        TopDocs topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
        directoryReader = DirectoryReader.open(directory);
        }
        addQuery(
import org.apache.lucene.queries.spans.SpanTermQuery;
        @Override
        indexWriter.addDocuments(documents);
        TopDocs topDocs = shardSearcher.search(query, 1);
        indexWriter.close();
        topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
        String field2 = randomFrom(stringFields);
    private MapperService mapperService;
            return "custom{" + field + "}";
    }
        indexWriter.addDocuments(docs);
        builder2.add(new TermQuery(new Term("field", "value3")), Occur.MUST);
        assertEquals(1, topDocs.scoreDocs[1].doc);
            )
        builder = new BooleanQuery.Builder().setMinimumNumberShouldMatch(2);
        assertEquals(5, topDocs.scoreDocs[0].doc);
 * this work for additional information regarding copyright
        builder.add(new TermQuery(new Term("field", "value2")), Occur.MUST_NOT);
        TopDocs topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
        doc = Collections.singleton(new HalfFloatPoint("half_float_field", randomHalfFloat));
        int numShouldClauses = 0;
        Document document = new Document();
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
        builder = new BooleanQuery.Builder();
                null,
            document.add(new TextField(entry.getKey(), value, Field.Store.NO));
        }
                document.add(new StringField("field", "value6", Field.Store.NO));
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
        assertEquals(4, topDocs.scoreDocs[0].doc);
        assertEquals(0, topDocs.scoreDocs[0].doc);
        result = executeQuery(queryStore, memoryIndex, shardSearcher);
 */
            .endObject()
        addQuery(builder.build(), docs);
            String value = entry.getValue().stream().collect(Collectors.joining(" "));
        builder.add(new TermQuery(new Term("field", "value2")), Occur.SHOULD);
            }
                    builder.add(new TermQuery(new Term(field, randomFrom(content.get(field)))), occur = Occur.MUST_NOT);
        assertEquals(0, topDocs.scoreDocs[0].doc);
        queryFunctions.add(() -> {
            return new TermQuery(term);
                    if (scorer != null) {
            } else if (randomBoolean()) {
        indexWriter.close();
            Float minScore = randomBoolean() ? null : (float) randomIntBetween(1, 1000);
            Collections.singletonList(new BytesArray("{}")),
        mapperService = indexService.mapperService();
                }
                        @Override
                @Override
        builder3.add(new TermQuery(new Term("field", "value3")), Occur.MUST);
        shardSearcher.setQueryCache(null);
            Collections.singleton(new InetAddressPoint("ip_field", forString("192.168.0.4"))),
        assertThat(result.scoreDocs.length, equalTo(1));
        List<String> fields,
        SpanNearQuery spanNearQuery2 = new SpanNearQuery.Builder("field", true).addClause(new SpanTermQuery(new Term("field", "the")))
                    occur = randomFrom(Arrays.asList(Occur.FILTER, Occur.MUST, Occur.SHOULD));
    private List<Query> queries;
        addQuery(builder.build(), docs);
            .addClause(new SpanTermQuery(new Term("field", "doc")))
import org.opensearch.common.compress.CompressedXContent;
            assertThat(topDocs.scoreDocs.length, equalTo(controlTopDocs.scoreDocs.length));
            documentMapper,
import org.apache.lucene.search.Query;
        int upperInt = lowerInt + randomIntBetween(0, 32);
                    v
        topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
            .numberOfShards(1)
import org.apache.lucene.search.MatchNoDocsQuery;
                occur = randomFrom(Arrays.asList(Occur.FILTER, Occur.MUST, Occur.SHOULD));
        });
        assertEquals(1L, topDocs.totalHits.value());
        private final Term term;
        SpanNotQuery spanNotQuery = new SpanNotQuery(spanNearQuery, spanNearQuery);
        }
                        builder.add(intFieldType.termQuery(randomFrom(intValues), null), occur);
            } else {
            for (int j = 0; j < numTokens; j++) {
        duelRun(queryStore, memoryIndex, shardSearcher);
        assertEquals(1, topDocs.totalHits.value());
            } else if (randomBoolean()) {
        addQuery(builder.build(), docs);
        int numValues = randomIntBetween(16, 64);
 *
import java.util.Collections;
        assertEquals(0, topDocs.scoreDocs[0].doc);
import org.opensearch.cluster.metadata.IndexMetadata;
        ranges.add(new int[] { 0, 10 });
            return classHash();
                logger.error("controlTopDocs.scoreDocs[{}].doc={}", i, controlTopDocs.scoreDocs[i].doc);
        queryFunctions.add(() -> {
        memoryIndex = new MemoryIndex();
                BooleanQuery candidateQuery = (BooleanQuery) query.getCandidateMatchesQuery();
            visitor.visitLeaf(this);
import org.apache.lucene.document.Document;
        private final MemoryIndex memoryIndex;
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(document, new WhitespaceAnalyzer());
        indexWriter.close();
            int numBooleanQueries = randomIntBetween(1, 5);
                    DocIdSetIterator allDocs = DocIdSetIterator.all(context.reader().maxDoc());
        directoryReader = DirectoryReader.open(directory);
    private BooleanQuery createRandomBooleanQuery(
        queryStore = ctx -> docId -> this.queries.get(docId);
    public void testDuel2() throws Exception {
            .endObject()
        directoryReader = DirectoryReader.open(directory);
    @After
        );
        directoryReader = DirectoryReader.open(directory);
 * this file be licensed under the Apache-2.0 license or a
        assertThat(result.scoreDocs[0].doc, equalTo(0));
import org.opensearch.index.mapper.DocumentMapper;
            }
            queryStore,
import org.opensearch.index.mapper.MappedFieldType;
            addQuery(new TermQuery(new Term("string_field", randomFrom(stringValues))), documents);
        BooleanQuery.Builder builder2 = new BooleanQuery.Builder();
        indexWriter.addDocuments(documents);
 * under the License.
import org.apache.lucene.document.StoredField;
        result = executeQuery(queryStore, memoryIndex, shardSearcher);
            builder.setMinimumNumberShouldMatch(randomIntBetween(0, 4));
            return sameClassAs(obj);
import java.util.List;
    }
        for (Integer intValue : intValues) {
                    return false; // doesn't matter
        shardSearcher.setQueryCache(null);
        assertThat(result.scoreDocs.length, equalTo(1));
        percolateSearcher = memoryIndex.createSearcher();
            assertThat(topDocs.totalHits.value(), equalTo(controlTopDocs.totalHits.value()));
        mapperService.merge("type", new CompressedXContent(percolatorMapper), MapperService.MergeReason.MAPPING_UPDATE);
        }
                    if (penum.advance(controlTopDocs.scoreDocs[i].doc) == controlTopDocs.scoreDocs[i].doc) {
            .endObject()
        addQuery(HalfFloatPoint.newRangeQuery("half_float_field", 10, 15), docs);
            if (randomBoolean()) {
        queryFunctions.add(
            return builder.build();
                        public float getMaxScore(int upTo) throws IOException {
        doc = Collections.singleton(new DoublePoint("double_field", randomDouble));
        shardSearcher.setQueryCache(null);
        topDocs = shardSearcher.search(query, 1);
                builder.add(new MatchNoDocsQuery("no reason"), Occur.MUST_NOT);
                builder.add(new MatchAllDocsQuery(), Occur.MUST_NOT);
import java.util.function.Supplier;
        commonTermsQuery.add(new Term("field", "fox"));
        MappedFieldType intFieldType = mapperService.fieldType("int_field");
/*
                assertEquals(0, topDocs.scoreDocs[0].doc);
        doc = Collections.singleton(new FloatPoint("float_field", randomFloat));
            List<String> values = new ArrayList<>();
        Document document = new Document();
                        }
            .startObject("long_field")
        assertEquals(1L, topDocs.totalHits.value());
import org.apache.lucene.index.NumericDocValues;
            .startObject("float_field")
        assertThat(result.scoreDocs.length, equalTo(1));
                } else if (randomBoolean()) {
        assertThat(result.scoreDocs[0].doc, equalTo(1));
        }
            .field("type", "percolator")
        public Query rewrite(IndexSearcher searcher) throws IOException {
 * ownership. Elasticsearch licenses this file to you under
                        @Override
        queryFunctions.add(
        });
        long upperLong = lowerLong + randomIntBetween(0, 32);
        {
            .field("type", "long")
        List<Integer> intValues = new ArrayList<>(numValues);
        long randomLong = randomIntBetween((int) lowerLong, (int) upperLong);
                Document document = new Document();
 * GitHub history for details.
        builder1.add(new TermQuery(new Term("field", "value2")), Occur.MUST);
        TopDocs controlTopDocs = shardSearcher.search(controlQuery, 100);
                    }
import org.opensearch.lucene.queries.BlendedTermQuery;
        topDocs = shardSearcher.search(query, 1);
        }
        double randomDouble = randomDoubleBetween(lowerDouble, upperDouble, true);
            .field("type", "ip")
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        builder.add(new TermQuery(new Term("field", "value1")), Occur.MUST);
import org.apache.lucene.util.BytesRef;
                );
        List<BytesReference> sources = Collections.singletonList(new BytesArray("{}"));
        QueryShardContext context
        Iterable<? extends IndexableField> doc = Collections.singleton(new StringField("field", "value", Field.Store.NO));
            )
        int numShouldClauses = 0;
            builder.add(new CustomQuery(new Term("field", id)), Occur.SHOULD);
        indexWriter.close();
import org.opensearch.index.mapper.NumberFieldMapper;
import org.apache.lucene.store.ByteBuffersDirectory;
        Map<String, List<String>> stringContent = new HashMap<>();
        stringValues.add("value2");
        }
                    Collections.singletonList(new BytesArray("{}")),
import org.apache.lucene.index.IndexWriter;
        indexWriter.addDocuments(documents);
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        MemoryIndex memoryIndex = new MemoryIndex();
        }
                logger.error("controlTopDocs.scoreDocs[{}].score={}", i, controlTopDocs.scoreDocs[i].score);
                builder.add(new MatchNoDocsQuery("no reason"), Occur.MUST_NOT);
        queryFunctions.add((id) -> {
            }
            .endObject()
                    "_name",
        duelRun(queryStore, memoryIndex, shardSearcher);
    }
        assertEquals(1, topDocs.scoreDocs[1].doc);
        IndexSearcher shardSearcher = newSearcher(directoryReader);
    private TopDocs executeQuery(PercolateQuery.QueryStore queryStore, MemoryIndex memoryIndex, IndexSearcher shardSearcher)
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
            String id = Integer.toString(i);
