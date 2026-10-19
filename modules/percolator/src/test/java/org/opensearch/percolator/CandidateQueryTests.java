import org.apache.lucene.document.IntPoint;
                } else {
            .addClause(new SpanTermQuery(new Term("field", "brown")))  
import java.util.List;
/*
        percolateSearcher = memoryIndex.createSearcher();  
        doc = Collections.singleton(new FloatPoint("float_field", randomFloat));
    ) {
                );  
                assertEquals(0, topDocs.scoreDocs[0].doc);  
        assertEquals(1, topDocs.scoreDocs.length);  
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
            if (randomBoolean() && depth <= 3) {  
        indexWriter.close();  
 * the Apache License, Version 2.0 (the "License"); you may
                        String field = randomFrom(fields);
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        List<String> stringFields = new ArrayList<>(stringContent.keySet());
    public void testDuel2() throws Exception {
        indexWriter.addDocuments(documents);
    @Before
        float lowerFloat = randomIntBetween(0, 256);  
        assertEquals(1L, topDocs.totalHits.value());
        indexWriter.close();  
                document = new Document();
                assertEquals(2, topDocs.scoreDocs.length);  
        addQuery(builder.build(), docs);
            for (int j = 0; j < numTokens; j++) {  
        indexWriter.addDocuments(docs);
        queryFunctions.add((id) -> new MatchAllDocsQuery());
            return classHash();
            .field("type", "long")
    private DirectoryReader directoryReader;
                    String field = randomFrom(fields);  
        );
        );  
        assertEquals(3, topDocs.scoreDocs[0].doc);
                for (int i = 0; i < 1024; i++) {  
                String field = randomFrom(stringFields);  
        indexWriter.close();
                    builder.add(new TermQuery(new Term("unknown_field", randomAlphaOfLength(8))), occur = Occur.MUST_NOT);
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
        addQuery(builder.build(), docs);  
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
            }
        assertEquals(2, topDocs.scoreDocs[1].doc);  
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        indexWriter.addDocuments(docs);  
                    };
import org.apache.lucene.index.PostingsEnum;
        }
            builder.add(new MatchAllDocsQuery(), Occur.MUST);
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) {
                        protected boolean match(int doc) {
                TermsEnum tenum = MultiTerms.getTerms(shardSearcher.getIndexReader(), fieldType.queryTermsField.name()).iterator();  
                innerQuery = new PhraseQuery(field1, randomFrom(stringContent.get(field1)), randomFrom(stringContent.get(field1)));
        directoryReader = DirectoryReader.open(directory);
                    logger.error("controlTopDocs.scoreDocs[{}].minimum_should_match_field={}", i, numericValues.longValue());
 * Unless required by applicable law or agreed to in writing,
                logger.error("controlTopDocs.scoreDocs[{}].doc={}", i, controlTopDocs.scoreDocs[i].doc);
        queryFunctions.add((id) -> new SpanTermQuery(new Term("field", id)));
        addQuery(new FunctionScoreQuery(new MatchAllDocsQuery(), 10F, 1f), docs);
            () -> new TermInSetQuery(
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
                            return _score[0];
        duelRun(queryStore, memoryIndex, shardSearcher);
                builder.add(new MatchNoDocsQuery("no reason"), Occur.MUST_NOT);
            Version.CURRENT  
            } else if (randomBoolean()) {  
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());  
                    String field = randomFrom(fields);
                    PostingsEnum penum = tenum.postings(null);  
                        @Override
        Query query = requireScore ? percolateQuery : new ConstantScoreQuery(percolateQuery);  
            .endObject()  
import org.junit.After;
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
        topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
        QueryShardContext context = createSearchContext(indexService).getQueryShardContext();
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(document, new WhitespaceAnalyzer());
        queryFunctions.add((id) -> {
                        builder.add(new TermQuery(new Term("unknown_field", randomAlphaOfLength(8))), occur);  
        topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));  
        Query percolateQuery = fieldType.percolateQuery(
        builder.add(builder3.build(), Occur.SHOULD);  
import org.apache.lucene.search.TermQuery;
            logger.error("topDocs.totalHits={}", topDocs.totalHits);  
        }
                        }
        directoryReader.close();
    }  
                        public DocIdSetIterator iterator() {
        addQuery(LongPoint.newRangeQuery("long_field", 5L, 10L), docs);
            addQuery(query, documents);
import org.opensearch.index.mapper.ParseContext;
        queryFunctions.add((id) -> {  
                        @Override  
            }
        }
import org.apache.lucene.search.TopDocs;  
import org.apache.lucene.search.IndexSearcher;
        @Override  
import org.apache.lucene.search.BooleanClause.Occur;  
        doc = Collections.singleton(new IntPoint("int_field", randomInt()));
                logger.error("controlTopDocs.scoreDocs[{}].query_terms_field={}", i, builder.toString());
        indexWriter.close();
        }
        for (int i = 0; i < numFields; i++) {  
        memoryIndex = MemoryIndex.fromDocument(Collections.singleton(new FloatPoint("float_field", 17)), new WhitespaceAnalyzer());
        addQuery(new FunctionScoreQuery(new TermQuery(new Term("field", "value")), null, 1f), docs);
    }
                    if (randomBoolean()) {
                    builder.add(intFieldType.termQuery(randomFrom(intValues), null), occur);  
    }
        indexWriter = new IndexWriter(directory, config);  
        Iterable<? extends IndexableField> doc = Collections.singleton(new StringField("field", "value", Field.Store.NO));  
            Collections.singletonList(new BytesArray("{}")),
        builder = new BooleanQuery.Builder();
                                    }
        queryFunctions.add(  
 *  
        config.setMergePolicy(NoMergePolicy.INSTANCE);
        ranges.add(new int[] { 15, 50 });
    private static final class ControlQuery extends Query {  
        {  
                    assertThat(explain1.isMatch(), equalTo(explain2.isMatch()));
        }
        long randomLong = randomIntBetween((int) lowerLong, (int) upperLong);
        Query query = fieldType.percolateQuery(  
        builder.add(new TermQuery(new Term("field", "value1")), Occur.MUST);
        Map<String, List<String>> content,
            .endObject()  
        indexWriter.close();
        builder1.add(new TermQuery(new Term("field", "value2")), Occur.MUST);  
        queryFunctions.add(  
import org.opensearch.core.common.bytes.BytesArray;
                            return memoryIndexIterator;  
        float lowerHalfFloat = randomIntBetween(0, 256);
                values.add(randomAlphaOfLength(8));
import org.apache.lucene.search.Scorer;  
        });
        doc = Collections.singleton(new LongPoint("long_field", randomLong()));
import org.opensearch.index.IndexService;
 * specific language governing permissions and limitations
    private BooleanQuery randomBQ(
                    false,
        Document document = new Document();
        assertEquals(1L, topDocs.totalHits.value());  
            try (IndexReader ir = DirectoryReader.open(directory)) {  
                        public float getMaxScore(int upTo) throws IOException {  
        {  
        Collections.sort(intValues);  
                subQuery = new TermQuery(new Term("string_field", randomFrom(stringValues)));  
        assertThat(result.scoreDocs[0].doc, equalTo(1));
    }
        public Query rewrite(IndexSearcher searcher) throws IOException {
        document.add(new IntPoint("int_field", 4));  
                }
            if (randomBoolean()) {
        query = fieldType.percolateQuery("_name", queryStore, Collections.singletonList(new BytesArray("{}")), percolateSearcher, false, v);
            try (IndexWriter iw = new IndexWriter(directory, newIndexWriterConfig())) {
            for (int j = 0; j < topDocs.scoreDocs.length; j++) {
            return sameClassAs(obj);
import org.opensearch.common.xcontent.XContentFactory;
 * ownership. Elasticsearch licenses this file to you under  
            .startObject("properties")  
        addQuery(builder.build(), docs);  
        {
import org.apache.lucene.document.TextField;
        percolateSearcher = memoryIndex.createSearcher();
            logger.error("controlTopDocs.scoreDocs.length={}", controlTopDocs.scoreDocs.length);
        result = executeQuery(queryStore, memoryIndex, shardSearcher);
        long randomLong = randomIntBetween((int) lowerLong, (int) upperLong);  
        builder.add(new TermQuery(new Term("field", "value1")), Occur.SHOULD);  
        addQuery(new MatchAllDocsQuery(), docs);  
            duelRun(queryStore, memoryIndex, shardSearcher);  
                builder.add(new MatchAllDocsQuery(), Occur.MUST_NOT);  
import org.apache.lucene.document.LongPoint;
        result = executeQuery(queryStore, memoryIndex, shardSearcher);  
    }
            .startObject("type")
        BooleanQuery.Builder builder = new BooleanQuery.Builder();  
import org.apache.lucene.store.Directory;
        List<int[]> ranges = new ArrayList<>();
            }
            mapperService.documentMapperParser(),
 * under the License.  
            .startObject("int_field")
        String indexName = "test";
                StringBuilder builder = new StringBuilder();
import org.apache.lucene.sandbox.search.CoveringQuery;
        builder.add(new TermQuery(new Term("field", "value1")), Occur.MUST);  
        addQuery(builder.build(), docs);
            for (int i = 0; i < controlTopDocs.scoreDocs.length; i++) {
                documents.add(document);  
import static org.opensearch.common.network.InetAddresses.forString;
        builder1.add(new TermQuery(new Term("field", "value1")), Occur.FILTER);
            new WhitespaceAnalyzer()
        BooleanQuery.Builder builder = new BooleanQuery.Builder();  
        assertEquals(1, topDocs.scoreDocs.length);  
import org.opensearch.common.settings.Settings;  
        shardSearcher.setQueryCache(null);  
                                if (topDocs.scoreDocs.length > 0) {
        List<Integer> intValues
import static org.hamcrest.Matchers.instanceOf;  
    private BooleanQuery createRandomBooleanQuery(
        }  
        assertEquals(5, topDocs.scoreDocs[0].doc);  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, topDocs.scoreDocs.length);
            return new FunctionScoreQuery(innerQuery, minScore, 1f);
        int numDocs = randomIntBetween(queryFunctions.size(), queryFunctions.size() * 3);
        indexService = createIndex(indexName, Settings.EMPTY);  
                Document document = new Document();
            builder.add(new MatchAllDocsQuery(), Occur.MUST);  
            for (int i = 0; i < numClauses; i++) {
import org.opensearch.plugins.Plugin;
 * license agreements. See the NOTICE file distributed with
                builder.setMinimumNumberShouldMatch(2);  
    }
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(document, new WhitespaceAnalyzer());
                Document document = new Document();
        @Override
        Document document = new Document();
                @Override  
        assertThat(result.scoreDocs.length, equalTo(1));
            document.add(new TextField("string_field", value, Field.Store.NO));
        directoryReader = DirectoryReader.open(directory);  
import org.apache.lucene.search.MatchNoDocsQuery;  
            .build();
        stringValues.add("value1");  
                assertThat(candidateQuery.clauses().get(0).query(), instanceOf(TermInSetQuery.class));
        } catch (AssertionError ae) {
        float upperFloat = lowerFloat + randomIntBetween(0, 32);
        result = executeQuery(queryStore, memoryIndex, shardSearcher);
        assertEquals(1L, topDocs.totalHits.value());  
        int depth,  
            () -> intFieldType.rangeQuery(
                    });  
        List<String> fields,
        queryFunctions.add(MatchNoDocsQuery::new);  
import org.apache.lucene.util.BytesRef;
        BooleanQuery.Builder builder1 = new BooleanQuery.Builder();  
            } else {  
        // Add to string representation of the query to make debugging easier:  
            settings,
        indexWriter.addDocuments(docs);  
                }  
 *
        builder.add(new MatchAllDocsQuery(), Occur.SHOULD);
        duelRun(queryStore, memoryIndex, shardSearcher);  
                occur = randomFrom(Arrays.asList(Occur.FILTER, Occur.MUST, Occur.SHOULD));
            if (occur == Occur.SHOULD) {  
        directoryReader = DirectoryReader.open(directory);  
        assertEquals(0, topDocs.scoreDocs[0].doc);  
                    assertThat(explain1.getValue(), equalTo(explain2.getValue()));
        indexWriter.close();
            }
            }  
import org.apache.lucene.queries.spans.SpanTermQuery;  
            Query innerQuery;
            null,
        duelRun(queryStore, memoryIndex, shardSearcher);
        indexWriter.close();
                }  
                                }  
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();  
        final boolean onlyShouldClauses = randomBoolean();  
 * not use this file except in compliance with the License.
                builder.add(new MatchAllDocsQuery(), Occur.SHOULD);  
        List<BytesReference> sources = Collections.singletonList(new BytesArray("{}"));
                                    return true;  
                assertEquals(1, topDocs.scoreDocs[0].doc);
        public void visit(QueryVisitor visitor) {
                        builder.append(term.utf8ToString()).append(',');
                logger.error("controlTopDocs.scoreDocs[{}].query_to_string={}", i, queryToString);
        });
            if (randomBoolean()) {
            if (randomBoolean()) {
        double lowerDouble = randomDoubleBetween(0, 256, true);
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
                        builder.add(new TermQuery(new Term(field, randomFrom(content.get(field)))), occur);  
        assertEquals(3, topDocs.scoreDocs.length);
            Collections.singleton(new InetAddressPoint("ip_field", forString("192.168.0.4"))),
import org.opensearch.lucene.queries.BlendedTermQuery;  
                if (requireScore) {
import org.apache.lucene.document.StoredField;  
                true,
            for (int i = 0; i < topDocs.scoreDocs.length; i++) {  
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
            false,
                    occur = randomFrom(Arrays.asList(Occur.FILTER, Occur.MUST, Occur.SHOULD));
import org.apache.lucene.search.SortField;  
        List<String> stringValues,  
        Query percolateQuery = fieldType.percolateQuery(  
import java.util.ArrayList;
        int randomInt = randomIntBetween(lowerInt, upperInt);
/*  
            .toString();
                }  
                    CheckedFunction<Integer, Query, IOException> leaf = queryStore.getQueries(context);  
                occur = Occur.SHOULD;
import org.opensearch.cluster.metadata.IndexMetadata;
            .endObject()
                    fieldType.minimumShouldMatchField.name()  
            if (randomBoolean()) {
                topDocs = shardSearcher.search(new ConstantScoreQuery(query), 10);
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
                assertEquals(2, topDocs.scoreDocs.length);
        @Override
                if (exact) {  
    private TopDocs executeQuery(PercolateQuery.QueryStore queryStore, MemoryIndex memoryIndex, IndexSearcher shardSearcher)  
        assertEquals(0, topDocs.scoreDocs[0].doc);
        final int numClauses = randomIntBetween(1, 4);
            .field("type", "integer")
        }
            addQuery(new MatchAllDocsQuery(), documents);
import org.apache.lucene.search.PrefixQuery;
        builder.add(new MatchAllDocsQuery(), Occur.MUST_NOT);  
    public void testDuelIdBased() throws Exception {  
            builder.add(new TermQuery(new Term("field", id)), Occur.SHOULD);
        commonTermsQuery.add(new Term("field", "quick"));  
        for (int i = 0; i < numDocs; i++) {
        addQuery(LongPoint.newRangeQuery("long_field", lowerLong, upperLong), documents);  
                }  
import org.apache.lucene.search.DocIdSetIterator;
                    document.add(new StringField("field", "value" + fieldNumber, Field.Store.NO));
                true,  
        builder2.add(new TermQuery(new Term("field", "value3")), Occur.MUST);
        duelRun(queryStore, memoryIndex, shardSearcher);  
                } else {
        assertThat(result.scoreDocs[0].doc, equalTo(4));
import org.apache.lucene.index.Term;
        assertEquals(0, topDocs.scoreDocs[0].doc);
        }
            .endObject()
                            return Explanation.match(scorer.score(), "ControlQuery");  
                BooleanQuery candidateQuery = (BooleanQuery) query.getCandidateMatchesQuery();
        @Override
            builder.add(new CustomQuery(new Term("field", id)), Occur.SHOULD);
            }
            return builder.build();
        builder2.add(new TermQuery(new Term("field", "value2")), Occur.MUST);
        assertEquals(3, topDocs.scoreDocs.length);
        List<ParseContext.Document> docs = new ArrayList<>();
            .numberOfShards(1)
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.queries.spans.SpanNotQuery;
        builder.add(new TermQuery(new Term("field", "value3")), Occur.MUST);
        public boolean equals(Object obj) {
 * this work for additional information regarding copyright
        public String toString(String field) {
            logger.info("Test with document: {}" + document);
import org.apache.lucene.sandbox.document.HalfFloatPoint;
        builder.add(new TermQuery(new Term("field", "value2")), Occur.MUST_NOT);  
                ShapeRelation.WITHIN,  
            v  
        indexWriter.addDocuments(documents);  
        }
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
        duelRun(queryStore, memoryIndex, shardSearcher);
            List<Field> numberFields = NumberFieldMapper.NumberType.INTEGER.createFields(
        builder.add(new TermQuery(new Term("field", "value3")), Occur.SHOULD);
        TopDocs topDocs = shardSearcher.search(query, 100);
            String id = Integer.toString(i);
        }
            percolateSearcher,
        builder.setMinimumNumberShouldMatch(2);
            BooleanQuery.Builder builder = new BooleanQuery.Builder();  
        assertEquals(1L, topDocs.totalHits.value());
            }  
        document.add(new TextField("field", "the quick brown fox jumps over the lazy dog", Field.Store.NO));  
        Version v = Version.CURRENT;
            .startObject("ip_field")
        builder.add(new MatchAllDocsQuery(), Occur.MUST);
        );  
                assertEquals(1, topDocs.scoreDocs[0].doc);
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();  
                builder.add(new MatchNoDocsQuery("no reason"), Occur.MUST_NOT);  
                @Override
            }
            }
    private IndexWriter indexWriter;
        }
            () -> new TermInSetQuery(
            queryStore,
        int lowerInt = randomIntBetween(0, 256);  
        try (Directory directory = new ByteBuffersDirectory()) {  
import org.apache.lucene.index.DirectoryReader;  
        );
            builder.add(subQuery, occur);  
                            }  
        // Disable query cache, because ControlQuery cannot be cached...
    public void testPercolateSmallAndLargeDocument() throws Exception {  
        ranges.add(new int[] { -5, 5 });  
        MappedFieldType intFieldType,
        shardSearcher.setQueryCache(null);
                    float _score[] = new float[] { boost };
        IndexSearcher shardSearcher = newSearcher(directoryReader);
    ) {
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());  
                builder.add(new CustomQuery(new Term("field", id)), Occur.SHOULD);
            new Term[] { new Term("field", "quick"), new Term("field", "brown"), new Term("field", "fox") },  
        PercolateQuery query = (PercolateQuery) fieldType.percolateQuery(  
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(Collections.singleton(new IntPoint("int_field", 3)), new WhitespaceAnalyzer());
        try (Directory directory = new ByteBuffersDirectory()) {
            if (occur == Occur.SHOULD) {
                builder.add(createRandomBooleanQuery(depth + 1, fields, content, intFieldType, intValues), occur);
                    // Some queries do not have a msm field. (e.g. unsupported queries)  
                    return new DefaultScorerSupplier(new Scorer() {  
        shardSearcher.setQueryCache(null);  
import org.apache.lucene.search.Query;  
        queryFunctions.add(() -> new TermQuery(new Term(field2, randomFrom(stringContent.get(field2)))));  
            "_name",
                                    if (scoreMode.needsScores()) {  
        queryFunctions.add(() -> intFieldType.termQuery(randomFrom(intValues), context));
                } else if (randomBoolean()) {
        // Empty percolator doc:  
        ParseContext.InternalParseContext parseContext = new ParseContext.InternalParseContext(  
                        public int docID() {  
                assertEquals(2L, topDocs.totalHits.value());
import org.apache.lucene.search.ScoreMode;
        addQuery(builder.build(), docs);
        }
    }
        doc = Collections.singleton(new LongPoint("long_field", randomLong));
        for (int i = 0; i < numClauses; i++) {
        memoryIndex = MemoryIndex.fromDocument(Collections.singleton(new LongPoint("long_field", 7L)), new WhitespaceAnalyzer());
    private void duelRun(PercolateQuery.QueryStore queryStore, MemoryIndex memoryIndex, IndexSearcher shardSearcher) throws IOException {
                PercolateQuery query = (PercolateQuery) fieldType.percolateQuery(
            logger.info("Test with document: {}" + document);
        percolateSearcher = memoryIndex.createSearcher();
        query = fieldType.percolateQuery("_name", queryStore, Collections.singletonList(new BytesArray("{}")), percolateSearcher, false, v);  
            .build();
        memoryIndex = MemoryIndex.fromDocument(Collections.singleton(new HalfFloatPoint("half_float_field", 12)), new WhitespaceAnalyzer());  
    public void testDuelRangeQueries() throws Exception {  
                assertEquals(2L, topDocs.totalHits.value());
        MappedFieldType intFieldType,  
                assertEquals(2, topDocs.scoreDocs[1].doc);
            .startObject("field")
            if (randomBoolean()) {
        builder3.add(new TermQuery(new Term("field", "value3")), Occur.MUST);
import org.apache.lucene.document.Field;
import org.apache.lucene.search.QueryVisitor;
                );
        SpanNotQuery spanNotQuery = new SpanNotQuery(spanNearQuery, spanNearQuery);  
import org.apache.lucene.search.BooleanQuery;
                BooleanQuery candidateQuery = (BooleanQuery) query.getCandidateMatchesQuery();
        builder.add(new TermQuery(new Term("field", "value5")), Occur.SHOULD);
                assertEquals(2L, topDocs.totalHits.value());
            if (randomBoolean()) {
        List<String> stringValues = new ArrayList<>();
package org.opensearch.percolator;
        }
    public void testPercolateMatchAll() throws Exception {
            try (IndexWriter iw = new IndexWriter(directory, newIndexWriterConfig())) {
        private final Term term;
            .field("type", "double")
    public void testDuel() throws Exception {  
            }  
                    shardSearcher.getIndexReader(),
import org.apache.lucene.index.IndexReader;
            return builder.build();
        });  
                subQuery = randomBQ(depth + 1, stringValues, ranges, intFieldType, context);
import static org.hamcrest.Matchers.equalTo;
            if (randomBoolean()) {
        addQuery(HalfFloatPoint.newRangeQuery("half_float_field", lowerHalfFloat, upperHalfFloat), documents);
        memoryIndex.addField("field", "value1 value4 value5", new WhitespaceAnalyzer());
        TopDocs result = executeQuery(queryStore, memoryIndex, shardSearcher);
            } else {
        TopDocs topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
        queries.add(query);  
            }  
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());  
    public void testDuplicatedClauses2() throws Exception {
            .toString();  
            return builder.build();  
                true,
        queries = new ArrayList<>();
        indexWriter.addDocuments(documents);
        shardSearcher.setQueryCache(null);
            "_name",
        assertThat(result.scoreDocs[0].doc, equalTo(3));  
    public void testDuplicatedClauses() throws Exception {
        String percolatorMapper = XContentFactory.jsonBuilder()
            }
            }
import java.io.IOException;
import org.apache.lucene.document.StringField;
        builder.setMinimumNumberShouldMatch(randomIntBetween(0, numShouldClauses));  
                iw.addDocument(document);
            1.0f
            return "custom{" + field + "}";
 * You may obtain a copy of the License at  
        builder.setMinimumNumberShouldMatch(3);
                TopDocs topDocs = shardSearcher.search(query, 10);  
        String mapper = XContentFactory.jsonBuilder()  
    private List<Query> queries;
                IndexSearcher percolateSearcher = new IndexSearcher(ir);
        memoryIndex.addField("field", "value3", new WhitespaceAnalyzer());  
        TopDocs topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
                @Override  
        }  
        IndexSearcher shardSearcher = newSearcher(directoryReader);  
            .startObject("double_field")
        addQuery(builder.build(), docs);
                boolean exact = numericValues.advanceExact(controlTopDocs.scoreDocs[i].doc);
        directoryReader = DirectoryReader.open(directory);
        });  
                    Collections.singletonList(new BytesArray("{}")),
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
        PercolateQuery query = (PercolateQuery) fieldType.percolateQuery("_name", queryStore, sources, percolateSearcher, false, v);  
        assertEquals(1, topDocs.scoreDocs[1].doc);
        topDocs = shardSearcher.search(query, 1);  
    private DocumentMapper documentMapper;  
        builder.add(new TermQuery(new Term("field", "value2")), Occur.SHOULD);  
            builder.add(new MatchAllDocsQuery(), Occur.SHOULD);
import org.apache.lucene.queries.CommonTermsQuery;
                    return "weight(" + ControlQuery.this + ")";
                        }  
        List<ParseContext.Document> docs = new ArrayList<>();
            Collections.singletonList(new BytesArray("{}")),  
            int[] range = randomFrom(ranges);
                    Explanation explain1 = shardSearcher.explain(query, topDocs.scoreDocs[j].doc);
                field1,
                document.add(new StringField("field", "value1", Field.Store.NO));
            assertThat(topDocs.scoreDocs.length, equalTo(controlTopDocs.scoreDocs.length));  
        int upperInt = lowerInt + randomIntBetween(0, 32);
        List<Integer> intValues = new ArrayList<>(numValues);
        doc = Collections.singleton(new HalfFloatPoint("half_float_field", randomHalfFloat));  
        MemoryIndex memoryIndex = new MemoryIndex();
                        @Override
            if (onlyShouldClauses) {
        assertEquals(3L, topDocs.totalHits.value());  
        queryFunctions.add(() -> new TermQuery(new Term(field1, randomFrom(stringContent.get(field1)))));
        assertEquals(2, topDocs.scoreDocs.length);
        assertEquals(1, topDocs.scoreDocs.length);
                    v
            }
            .endObject()  
            Float minScore = randomBoolean() ? null : (float) randomIntBetween(1, 1000);  
        private final PercolateQuery.QueryStore queryStore;  
            if (randomBoolean()) {  
        float upperHalfFloat = lowerHalfFloat + randomIntBetween(0, 32);  
        boolean onlyShouldClauses = rarely();  
        addQuery(new FunctionScoreQuery(new MatchAllDocsQuery(), null, 1f), docs);  
                    if (randomBoolean()) {
        directoryReader = DirectoryReader.open(directory);  
                document.add(new StringField("field", "value3", Field.Store.NO));
        for (Integer intValue : intValues) {
                if (randomBoolean()) {
            } else {
        @Override
                    return Explanation.noMatch("ControlQuery");  
    }
        assertEquals(0, topDocs.scoreDocs[0].doc);
    }
        topDocs = shardSearcher.search(query, 1);
        assertThat(result.scoreDocs[0].doc, equalTo(5));  
import org.apache.lucene.document.InetAddressPoint;  
                logger.error("topDocs.scoreDocs[{}].doc={}", i, topDocs.scoreDocs[i].doc);
                                TopDocs topDocs = percolatorIndexSearcher.search(query, 1);
        queryFunctions.add((id) -> {
        fieldType = (PercolatorFieldMapper.PercolatorFieldType) fieldMapper.fieldType();  
                    queryStore,
        builder1.add(new TermQuery(new Term("field", "value1")), Occur.MUST);
        addQuery(InetAddressPoint.newRangeQuery("ip_field", forString("192.168.0.1"), forString("192.168.0.10")), docs);
                documents.add(document);
        public boolean equals(Object obj) {  
        addQuery(commonTermsQuery, documents);  
        duelRun(queryStore, memoryIndex, shardSearcher);  
        shardSearcher.setQueryCache(null);
                topDocs = shardSearcher.search(new ConstantScoreQuery(query), 10);  
        assertEquals(3L, topDocs.totalHits.value());
        }
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
            stringContent.put("field" + i, values);  
            }
        for (Map.Entry<String, List<String>> entry : stringContent.entrySet()) {  
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);
        topDocs = shardSearcher.search(new ConstantScoreQuery(query), 10);  
import java.util.HashMap;  
        List<ParseContext.Document> documents = new ArrayList<>();
                false
            builder.add(new MatchAllDocsQuery(), Occur.SHOULD);  
        });
                        }
        addQuery(spanOrQuery, documents);
        int numClauses = randomIntBetween(1, 1 << randomIntBetween(2, 4)); // use low numbers of clauses more often
        MemoryIndex memoryIndex = new MemoryIndex();  
            return builder.build();
        }
import org.apache.lucene.document.FloatPoint;
import org.apache.lucene.document.DoublePoint;  
                for (BytesRef term = tenum.next(); term != null; term = tenum.next()) {
        long lowerLong = randomIntBetween(0, 256);  
        indexWriter.close();
            return new DisjunctionMaxQuery(clauses, 0.01f);  
import org.apache.lucene.search.PhraseQuery;
        List<ParseContext.Document> docs = new ArrayList<>();
        builder.add(new MatchAllDocsQuery(), Occur.MUST);
        indexWriter.close();
            int numBooleanQueries = randomIntBetween(1, 5);  
import org.apache.lucene.search.ScorerSupplier;
        builder = new BooleanQuery.Builder();
    public void testDuelSpecificQueries() throws Exception {
        shardSearcher.setQueryCache(null);
                    percolateSearcher,  
import org.apache.lucene.document.Document;
                assertEquals(2, topDocs.scoreDocs[1].doc);
                            return _score[0];
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        ranges.add(new int[] { 0, 10 });
import org.apache.lucene.search.Weight;
            logger.error("topDocs.scoreDocs.length={}", topDocs.scoreDocs.length);  
                }
import org.apache.lucene.index.TermsEnum;  
                        }
        List<ParseContext.Document> docs = new ArrayList<>();  
        duelRun(queryStore, memoryIndex, shardSearcher);
        percolateSearcher = memoryIndex.createSearcher();
    protected Collection<Class<? extends Plugin>> getPlugins() {  
        List<Function<String, Query>> queryFunctions = new ArrayList<>();
        List<ParseContext.Document> documents = new ArrayList<>();  
                document.add(new StringField("field", "value2", Field.Store.NO));  
                document.add(new StringField("field", "value4", Field.Store.NO));
        indexWriter.addDocuments(docs);
        }
        @Override  
            List<Field> numberFields = NumberFieldMapper.NumberType.INTEGER.createFields("int_field", intValue, true, true, false, false);
        int depth,
                builder.add(new MatchNoDocsQuery("no reason"), Occur.MUST_NOT);
import org.apache.lucene.store.ByteBuffersDirectory;  
            .field("type", "keyword")
        memoryIndex = MemoryIndex.fromDocument(Collections.singleton(new DoublePoint("double_field", 21)), new WhitespaceAnalyzer());
                    int fieldNumber = 2 + i;
                    }  
            .addClause(new SpanTermQuery(new Term("field", "fox")))
    }  
        queryFunctions.add(() -> new TermQuery(new Term("unknown_field", "value")));
        directory = newDirectory();  
import org.apache.lucene.search.MatchAllDocsQuery;
        for (Supplier<Query> queryFunction : queryFunctions) {
        int numShouldClauses = 0;  
        indexWriter.close();
        builder3.add(new TermQuery(new Term("field", "value4")), Occur.MUST);
        queryFunctions.add((id) -> {
                clauses.add(new TermQuery(new Term(field, randomFrom(stringContent.get(field)))));
            }
                document.add(new StringField("field", "value6", Field.Store.NO));
    }
        private final MemoryIndex memoryIndex;
        addQuery(IntPoint.newRangeQuery("int_field", 0, 5), docs);  
        IndexMetadata build = IndexMetadata.builder("")  
        assertEquals(1, topDocs.scoreDocs[0].doc);
    public void init() throws Exception {
        long upperLong = lowerLong + randomIntBetween(0, 32);
                        @Override  
        assertEquals(1L, topDocs.totalHits.value());
            percolateSearcher,
        }  
        IndexSearcher shardSearcher = newSearcher(directoryReader);  
        fieldMapper.processQuery(query, parseContext);
            Version.CURRENT
        String field1 = randomFrom(stringFields);  
        builder2 = new BooleanQuery.Builder();
        }  
        assertEquals(2, topDocs.scoreDocs[0].doc);  
            MemoryIndex memoryIndex = MemoryIndex.fromDocument(document, new WhitespaceAnalyzer());
import org.opensearch.index.mapper.NumberFieldMapper;  
                PercolateQuery query = (PercolateQuery) fieldType.percolateQuery(
            queryFunctions.add(() -> createRandomBooleanQuery(1, stringFields, stringContent, intFieldType, intValues));  
        directoryReader = DirectoryReader.open(directory);  
import java.util.stream.Collectors;
            queryStore,
            false,
        for (int i = 0; i < numRandomBoolQueries; i++) {
        builder.add(builder2.build(), Occur.MUST);  
                logger.error("topDocs.scoreDocs[{}].score={}", i, topDocs.scoreDocs[i].score);
            addQuery(new PhraseQuery(0, "string_field", stringValues.toArray(new String[0])), documents);
        duelRun(queryStore, memoryIndex, shardSearcher);
            "_name",
    private PercolatorFieldMapper.PercolatorFieldType fieldType;  
            false,
    private Directory directory;
 * Licensed to Elasticsearch under one or more contributor  
            false,
        addQuery(blendedTermQuery, documents);  
                Query randomBQ = randomBQ(1, stringValues, ranges, intFieldType, context);
                    DocIdSetIterator allDocs = DocIdSetIterator.all(context.reader().maxDoc());
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        }
            .startObject("properties")
            try (IndexReader ir = DirectoryReader.open(directory)) {  
        queryFunctions.add((id) -> new PrefixQuery(new Term("field", id)));
        builder1.add(new TermQuery(new Term("field", "value2")), Occur.MUST);
        {  
        throws IOException {
        MemoryIndex memoryIndex = new MemoryIndex();  
        queryFunctions.add((id) -> {
        builder = new BooleanQuery.Builder();
        );
        indexWriter.addDocuments(docs);
            .startObject(queryField)  
                null,
import org.apache.lucene.search.WildcardQuery;
    }
        );
        List<ParseContext.Document> documents = new ArrayList<>();  
        shardSearcher.setQueryCache(null);  
            MemoryIndex memoryIndex = MemoryIndex.fromDocument(document, new WhitespaceAnalyzer());  
        commonTermsQuery.add(new Term("field", "fox"));
            String id = Integer.toString(i);  
            .startObject()  
            "_name",
        Iterable<? extends IndexableField> doc = Collections.singleton(new IntPoint("int_field", randomInt));
        // This will trigger using the TermsQuery instead of individual term query clauses in the CoveringQuery:
            }
            percolateSearcher,
                    Collections.singletonList(new BytesArray("{}")),
                assertThat(topDocs.scoreDocs[j].doc, equalTo(controlTopDocs.scoreDocs[j].doc));
        topDocs = shardSearcher.search(query, 1);  
                field2,
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
                if (randomBoolean()) {
        query = (PercolateQuery) fieldType.percolateQuery("_name", queryStore, sources, percolateSearcher, false, v);  
                assertThat(candidateQuery.clauses().get(0).query(), instanceOf(CoveringQuery.class));
        builder.add(new TermQuery(new Term("field", "value2")), Occur.MUST);
import java.util.Arrays;  
import org.junit.Before;
    @After  
            )
                        }
import org.apache.lucene.index.memory.MemoryIndex;
        for (int i = 0; i < numClauses; i++) {
                documents.add(document);
        doc = Collections.singleton(new DoublePoint("double_field", randomDouble));
import org.apache.lucene.queries.spans.SpanNearQuery;  
        addQuery(DoublePoint.newRangeQuery("double_field", lowerDouble, upperDouble), documents);  
            .field("type", "ip")
import java.util.function.Function;  
            .endObject()
                between(range[0], range[1]),
        assertEquals(1, topDocs.scoreDocs[1].doc);  
import org.opensearch.Version;  
            Query subQuery;
            Iterable<? extends IndexableField> doc = Collections.singleton(new StringField("field", id, Field.Store.NO));
        long lowerLong = randomIntBetween(0, 256);
        // Disable query cache, because ControlQuery cannot be cached...
        stringValues.add("value3");
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();  
                true,
        topDocs = shardSearcher.search(query, 1);
        assertEquals(4, topDocs.scoreDocs[2].doc);
            .startObject()
        int lowerIpPart = randomIntBetween(0, 255);
        IndexSearcher shardSearcher = newSearcher(directoryReader);  
        // Disable query cache, because ControlQuery cannot be cached...
                    v
            throw ae;
                    percolateSearcher,  
                builder.add(new CustomQuery(new Term("field", id)), Occur.MUST);  
        assertEquals(1, topDocs.totalHits.value());
        addQuery(FloatPoint.newRangeQuery("float_field", 15, 20), docs);  
        List<BytesReference> sources = Collections.singletonList(new BytesArray("{}"));  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            addQuery(new MatchNoDocsQuery(), documents);
                    return false; // doesn't matter
            .endObject()  
        assertEquals(0, topDocs.scoreDocs[0].doc);
    public void testRangeQueries() throws Exception {
        assertEquals(2L, topDocs.totalHits.value());  
            visitor.visitLeaf(this);
                intValues.get(intValues.size() - 4),  
        }
                List.of(new BytesRef(randomFrom(stringContent.get(field1))), new BytesRef(randomFrom(stringContent.get(field1))))  
        queryFunctions.add(() -> {
                context  
                if (randomBoolean()) {  
                numShouldClauses++;  
                        builder.add(intFieldType.termQuery(randomFrom(intValues), null), occur);
        assertEquals(4, topDocs.scoreDocs[2].doc);
            }  
            .startObject("type")
                        public float score() throws IOException {
        );
        docs.add(queryDocument);
        commonTermsQuery.add(new Term("field", "brown"));
            null
                    builder.add(intFieldType.termQuery(randomFrom(intValues), null), occur = Occur.MUST_NOT);
        BooleanQuery.Builder builder2 = new BooleanQuery.Builder();  
    @Override
        private CustomQuery(Term term) {  
        QueryShardContext context  
        BooleanQuery.Builder builder3 = new BooleanQuery.Builder();  
        PercolateQuery query = (PercolateQuery) fieldType.percolateQuery("_name", queryStore, sources, percolateSearcher, false, v);
    }
        memoryIndex.addField("field", "value1", new WhitespaceAnalyzer());
            addQuery(new TermQuery(new Term("string_field", randomFrom(stringValues))), documents);
import org.opensearch.common.compress.CompressedXContent;  
        addQuery(spanNotQuery, documents);
        builder.add(new TermQuery(new Term("field", "value3")), Occur.SHOULD);
/*  
                                Query query = leaf.apply(doc);  
                builder.add(new MatchAllDocsQuery(), Occur.MUST_NOT);
                String queryToString = shardSearcher.storedFields().document(controlTopDocs.scoreDocs[i].doc).get("query_to_string");  
            builder.add(new TermQuery(new Term("field", id)), Occur.SHOULD);  
        query = fieldType.percolateQuery("_name", queryStore, Collections.singletonList(new BytesArray("{}")), percolateSearcher, false, v);  
        TopDocs topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
        addQuery(new FunctionScoreQuery(new TermQuery(new Term("field", "value")), 10f, 1f), docs);
                    }  
            List<String> values = new ArrayList<>();
        IndexWriterConfig config = new IndexWriterConfig(new WhitespaceAnalyzer());
        Map<String, List<String>> stringContent = new HashMap<>();
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
        TopDocs topDocs = shardSearcher.search(query, 1);
            String value = entry.getValue().stream().collect(Collectors.joining(" "));
                @Override  
        }  
            document.add(new TextField(entry.getKey(), value, Field.Store.NO));
                            try {
        assertEquals(4, topDocs.scoreDocs[0].doc);
        builder.add(IntPoint.newRangeQuery("int_field", 0, 5), Occur.SHOULD);
                assertThat(topDocs.scoreDocs[j].score, equalTo(controlTopDocs.scoreDocs[j].score));  
 */
        indexWriter.close();
            .field("type", "percolator")
            "_name",
import org.opensearch.core.common.bytes.BytesReference;  
        builder.add(new MatchAllDocsQuery(), Occur.MUST);  
                            return memoryIndexIterator.docID();
 */  
            );  
        ParseContext.Document queryDocument = parseContext.doc();
                                    return false;
                        @Override
        {  
        directoryReader = DirectoryReader.open(directory);
            duelRun(queryStore, memoryIndex, shardSearcher);
            percolateSearcher,
        // Recreates a similar scenario that made testDuel() fail randomly:  
        mapperService = indexService.mapperService();
        builder.add(new TermQuery(new Term("field", "value4")), Occur.MUST);  
        assertEquals(1, topDocs.scoreDocs.length);
        queryStore = ctx -> docId -> this.queries.get(docId);  
import org.apache.lucene.index.IndexWriterConfig;  
            Query query = queryFunction.get();  
        duelRun(queryStore, memoryIndex, shardSearcher);
        duelRun(queryStore, memoryIndex, shardSearcher);
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
            } else if (randomBoolean()) {
import org.apache.lucene.search.Explanation;
        List<int[]> ranges,
            int numClauses = randomIntBetween(1, 1 << randomIntBetween(2, 4));  
            visitor.visitLeaf(this);  
        // Disable query cache, because ControlQuery cannot be cached...
        addQuery(builder.build(), docs);
        directory.close();  
            this.memoryIndex = memoryIndex;  
    private static final class CustomQuery extends Query {
        List<ParseContext.Document> documents = new ArrayList<>();
                innerQuery = new TermQuery(new Term(field1, randomFrom(stringContent.get(field1))));  
        directoryReader = DirectoryReader.open(directory);
        QueryShardContext context = createSearchContext(indexService).getQueryShardContext();
import org.opensearch.index.query.QueryShardContext;
        builder.add(new TermQuery(new Term("field", "value3")), Occur.SHOULD);  
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(document, new WhitespaceAnalyzer());  
                    false,
            }
            int numTokens = randomIntBetween(1, 64);
        shardSearcher.setQueryCache(null);
        builder.setMinimumNumberShouldMatch(randomIntBetween(0, numShouldClauses));
    }
            builder.add(new TermQuery(new Term("field", id)), Occur.MUST);
            }
        MappedFieldType intFieldType = mapperService.fieldType("int_field");
            Occur occur;  
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
        Document document = new Document();
        // many iterations with boolean queries, which are the most complex queries to deal with when nested  
import org.apache.lucene.index.MultiDocValues;  
        builder1.add(new TermQuery(new Term("field", "value1")), Occur.MUST);  
                subQuery = intFieldType.rangeQuery(range[0], range[1], true, true, null, null, null, context);
 * software distributed under the License is distributed on an
                );  
                            } catch (IOException e) {
            if (onlyShouldClauses) {  
    private PercolatorFieldMapper fieldMapper;
        }
                builder.add(new MatchNoDocsQuery("no reason"), Occur.MUST_NOT);
                    } else {
                assertEquals(2L, topDocs.totalHits.value());
                    FilteredDocIdSetIterator memoryIndexIterator = new FilteredDocIdSetIterator(allDocs) {
        BooleanQuery.Builder builder1 = new BooleanQuery.Builder();
    }
        TopDocs topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
        );
                    }  
        assertEquals(1, topDocs.scoreDocs.length);
        @Override
import org.apache.lucene.search.Sort;
public class CandidateQueryTests extends OpenSearchSingleNodeTestCase {
                    "_name",  
        }  
            Occur occur;
        long upperLong = lowerLong + randomIntBetween(0, 32);
        builder.add(new MatchAllDocsQuery(), Occur.MUST);
            this.term = term;
        IndexSearcher shardSearcher = newSearcher(directoryReader);  
        }
                } else {
                        }
            .endObject()  
            return new Weight(this) {
        builder.add(builder1.build(), Occur.MUST);
        assertEquals(1, topDocs.totalHits.value());  
            }
import org.apache.lucene.search.ConstantScoreQuery;
                assertEquals(2, topDocs.scoreDocs.length);  
        topDocs = shardSearcher.search(query, 1);
                        builder.add(intFieldType.termQuery(randomFrom(intValues), null), occur);
        // Disable query cache, because ControlQuery cannot be cached...
 * this file be licensed under the Apache-2.0 license or a
        directoryReader = DirectoryReader.open(directory);  
            queryStore,  
    }  
            logger.error("controlTopDocs.totalHits={}", controlTopDocs.totalHits);
        assertEquals(1, topDocs.totalHits.value());
        doc = Collections.singleton(new InetAddressPoint("ip_field", forString("192.168.1." + randomIntBetween(0, 255))));
        builder.add(IntPoint.newRangeQuery("int_field", 6, 10), Occur.SHOULD);
        builder2.add(new TermQuery(new Term("field", "value3")), Occur.MUST);
            List<Query> clauses = new ArrayList<>();
import org.apache.lucene.index.IndexableField;
        queryFunctions.add(MatchAllDocsQuery::new);
            addQuery(query, documents);
        queryFunctions.add((id) -> new MatchNoDocsQuery("no reason at all"));  
        queryFunctions.add((id) -> new TermQuery(new Term("field", id)));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Version v = VersionUtils.randomIndexCompatibleVersion(random());  
}
        double upperDouble = lowerDouble + randomDoubleBetween(0, 32, true);
                    }
import org.apache.lucene.index.MultiTerms;
        PercolateQuery query = (PercolateQuery) fieldType.percolateQuery(  
        for (String value : stringValues) {  
        }
            }  
            .endObject()  
            MemoryIndex memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
        doc = Collections.singleton(new DoublePoint("double_field", randomFloat()));
                } else {
            .startObject("long_field")
        );
        List<ParseContext.Document> docs = new ArrayList<>();
        queryDocument.add(new StoredField("query_to_string", query.toString()));
 * Modifications Copyright OpenSearch Contributors. See
    private IndexService indexService;
        TopDocs topDocs = shardSearcher.search(query, 10, new Sort(SortField.FIELD_DOC));
        indexWriter.close();
        assertEquals(2L, topDocs.totalHits.value());
        query = fieldType.percolateQuery("_name", queryStore, Collections.singletonList(new BytesArray("{}")), percolateSearcher, false, v);
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
                NumericDocValues numericValues = MultiDocValues.getNumericValues(
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
                intValues.get(4),
                // Additional stored information that is useful when debugging:
                document.add(numberField);
        builder.add(new TermQuery(new Term("field", "value2")), Occur.MUST);
            Query query = queryFunctions.get(i % queryFunctions.size()).apply(id);  
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {
        return Collections.singleton(PercolatorModulePlugin.class);
        builder.add(new TermQuery(new Term("field", "value2")), Occur.MUST);  
        SpanNearQuery spanNearQuery = new SpanNearQuery.Builder("field", true).addClause(new SpanTermQuery(new Term("field", "quick")))
            false,  
                public boolean isCacheable(LeafReaderContext ctx) {
import org.opensearch.index.IndexSettings;
            .addClause(new SpanTermQuery(new Term("field", "lazy")))  
        {  
        assertThat(result.scoreDocs.length, equalTo(1));
        boolean requireScore = randomBoolean();
            .build();
        memoryIndex = new MemoryIndex();  
            Collections.singletonList(new BytesArray("{}")),  
        addQuery(builder.build(), docs);
            this.queryStore = queryStore;
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        memoryIndex.addField("field", "value1 value2", new WhitespaceAnalyzer());
        double randomDouble = randomDoubleBetween(lowerDouble, upperDouble, true);  
        });
        }
            Query rangeQuery = intFieldType.rangeQuery(range[0], range[1], true, true, null, null, null, context);
                document = new Document();  
        addQuery(builder.build(), docs);
                    Scorer scorer = scorer(context);
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            .endObject()  
 * KIND, either express or implied.  See the License for the
    }
        addQuery(DoublePoint.newRangeQuery("double_field", 20, 25), docs);
        TopDocs controlTopDocs = shardSearcher.search(controlQuery, 100);
        IndexSearcher shardSearcher = newSearcher(directoryReader);
        int numValues = randomIntBetween(16, 64);
        queryFunctions.add((id) -> {
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
                public String toString() {
            return builder.build();  
    private PercolateQuery.QueryStore queryStore;  
                    builder.add(new TermQuery(new Term(field, randomFrom(content.get(field)))), occur);
                assertEquals(2, topDocs.scoreDocs.length);
        doc = Collections.singleton(new HalfFloatPoint("half_float_field", randomFloat()));  
        assertThat(result.scoreDocs[0].doc, equalTo(2));
        addQuery(IntPoint.newRangeQuery("int_field", lowerInt, upperInt), documents);
        result = executeQuery(queryStore, memoryIndex, shardSearcher);
            documentMapper,  
        shardSearcher.setQueryCache(null);  
                    "_name",  
        final BooleanQuery.Builder builder = new BooleanQuery.Builder();
            intValues.add(randomInt());
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
        doc = Collections.singleton(new FloatPoint("float_field", randomFloat()));
            )
    }  
            Collections.singletonList(new BytesArray("{}")),  
        queryFunctions.add((id) -> new WildcardQuery(new Term("field", id + "*")));  
            .endObject()
        MappedFieldType intFieldType = mapperService.fieldType("int_field");  
                numShouldClauses++;
        @Override  
            }
        assertEquals(1L, topDocs.totalHits.value());  
    }  
            .endObject()
            return sameClassAs(obj);  
            .startObject("float_field")
        builder = new BooleanQuery.Builder();  
        percolateSearcher = memoryIndex.createSearcher();
        List<ParseContext.Document> docs = new ArrayList<>();
        );
            return classHash();  
        List<ParseContext.Document> documents = new ArrayList<>();
import org.apache.lucene.index.IndexWriter;
                    if (penum.advance(controlTopDocs.scoreDocs[i].doc) == controlTopDocs.scoreDocs[i].doc) {
        public String toString(String field) {  
            builder.add(new MatchAllDocsQuery(), Occur.SHOULD);
        builder.add(builder1.build(), Occur.SHOULD);
                TopDocs topDocs = shardSearcher.search(query, 10);
        duelRun(queryStore, memoryIndex, shardSearcher);
        duelRun(queryStore, memoryIndex, shardSearcher);  
            }
            }  
        mapperService.merge("type", new CompressedXContent(percolatorMapper), MapperService.MergeReason.MAPPING_UPDATE);
        }
        duelRun(queryStore, memoryIndex, shardSearcher);
        assertThat(result.scoreDocs.length, equalTo(1));  
import org.apache.lucene.index.NumericDocValues;  
            .field("type", "float")
        controlQuery = requireScore ? controlQuery : new ConstantScoreQuery(controlQuery);
        queryFunctions.add(() -> intFieldType.termsQuery(Arrays.asList(randomFrom(intValues), randomFrom(intValues)), context));
                null,
    }  
            InetAddressPoint.newRangeQuery("ip_field", forString("192.168.1." + lowerIpPart), forString("192.168.1." + upperIpPart)),
        IndexSearcher shardSearcher = newSearcher(directoryReader);  
            return builder.build();
        float randomHalfFloat = randomIntBetween((int) lowerHalfFloat, (int) upperHalfFloat);
    private MapperService mapperService;  
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());  
        builder.add(builder2.build(), Occur.SHOULD);
        indexWriter.addDocuments(documents);
            .endObject()  
import org.apache.lucene.queries.spans.SpanOrQuery;
        public int hashCode() {
        }
        return builder.build();
            documents  
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
                assertEquals(2, topDocs.scoreDocs[1].doc);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        fieldMapper = (PercolatorFieldMapper) mapperService.documentMapper().mappers().getMapper(queryField);
                int[] range = randomFrom(ranges);  
                                        _score[0] = topDocs.scoreDocs[0].score;
        int numRandomBoolQueries = 1000;
        int numShouldClauses = 0;
                    } else {
        }
        // https://github.com/elastic/elasticsearch/issues/29393
        Document document = new Document();
        queryFunctions.add((id) -> new CustomQuery(new Term("field", id)));
        addQuery(builder.build(), docs);  
        duelRun(queryStore, memoryIndex, shardSearcher);
                    queryStore,
                iw.addDocuments(documents); // IW#addDocuments(...) ensures we end up with a single segment
            }
                    builder.add(new TermQuery(new Term(field, randomFrom(content.get(field)))), occur = Occur.MUST_NOT);  
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
                assertEquals(0, topDocs.scoreDocs[0].doc);  
                }
                List<Document> documents = new ArrayList<>();  
        shardSearcher.setQueryCache(null);  
        }
        shardSearcher.setQueryCache(null);  
                occur = randomFrom(Arrays.asList(Occur.FILTER, Occur.MUST, Occur.SHOULD));  
import org.apache.lucene.index.LeafReaderContext;
        addQuery(
import org.opensearch.index.mapper.DocumentMapper;  
        public int hashCode() {
        stringValues.add("value2");
        builder.add(builder1.build(), Occur.SHOULD);
            BooleanQuery.Builder builder = new BooleanQuery.Builder();  
        assertEquals(0, topDocs.scoreDocs[0].doc);
            assertThat(topDocs.totalHits.value(), equalTo(controlTopDocs.totalHits.value()));
            .field("type", "half_float")
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());  
        document.add(new LongPoint("long_field", randomLong));
        memoryIndex = new MemoryIndex();
        int upperIpPart = randomIntBetween(lowerIpPart, 255);  
                    logger.error("controlTopDocs.scoreDocs[{}].minimum_should_match_field=[NO_VALUE]", i);
        builder = new BooleanQuery.Builder().setMinimumNumberShouldMatch(2);  
        try {
                }
            } else if (rarely() && depth <= 3) {
            for (Field numberField : numberFields) {
        result = executeQuery(queryStore, memoryIndex, shardSearcher);  
                document.add(new StringField("field", "value5", Field.Store.NO));  
import org.opensearch.test.VersionUtils;  
        IndexSearcher percolateSearcher = memoryIndex.createSearcher();
            percolateSearcher,
        query = (PercolateQuery) fieldType.percolateQuery("_name", queryStore, sources, percolateSearcher, false, v);
                addQuery(randomBQ, documents);  
        List<ParseContext.Document> docs = new ArrayList<>();
        for (int i = 0; i < numDocs; i++) {
                }  
import java.util.Map;
        queryFunctions.add(() -> {
        addQuery(FloatPoint.newRangeQuery("float_field", lowerFloat, upperFloat), documents);
        builder2.add(new TermQuery(new Term("field", "value2")), Occur.MUST);  
        List<Supplier<Query>> queryFunctions = new ArrayList<>();
            for (Field numberField : numberFields) {  
            return builder.build();  
import org.opensearch.index.mapper.MappedFieldType;
        assertEquals(0, topDocs.scoreDocs[0].doc);
                IndexSearcher percolateSearcher = new IndexSearcher(ir);
        CommonTermsQuery commonTermsQuery = new CommonTermsQuery(Occur.SHOULD, Occur.SHOULD, 128);
            } else {
        }
        document.add(new IntPoint("int_field", 7));
 * compatible open source license.
        query = fieldType.percolateQuery("_name", queryStore, Collections.singletonList(new BytesArray("{}")), percolateSearcher, false, v);
            builder.add(new TermQuery(new Term("field", id)), Occur.SHOULD);
                }
        Version v = Version.CURRENT;  
import java.util.Collection;
            queryStore,
                List.of(new BytesRef(randomFrom(stringContent.get(field1))), new BytesRef(randomFrom(stringContent.get(field1))))  
            return new TermQuery(term);  
        for (int j = 0; j < numValues; j++) {  
            final IndexSearcher percolatorIndexSearcher = memoryIndex.createSearcher();  
        float randomFloat = randomIntBetween((int) lowerFloat, (int) upperFloat);
import org.apache.lucene.search.TermInSetQuery;
 * GitHub history for details.
        indexWriter.addDocuments(docs);  
        assertEquals(0, topDocs.scoreDocs[0].doc);  
        indexWriter.addDocuments(docs);  
        builder.add(new TermQuery(new Term("field", "value4")), Occur.SHOULD);  
                occur = Occur.SHOULD;
            } else if (randomBoolean()) {
import org.apache.lucene.search.DisjunctionMaxQuery;  
        PercolateQuery query = (PercolateQuery) fieldType.percolateQuery("_name", queryStore, sources, percolateSearcher, false, v);
        MemoryIndex memoryIndex = new MemoryIndex();  
                }  
        assertThat(result.scoreDocs[0].doc, equalTo(0));  
        assertEquals(0, topDocs.scoreDocs[0].doc);  
        Version v = Version.CURRENT;
    public void testMsmAndRanges_disjunction() throws Exception {
        percolateSearcher = memoryIndex.createSearcher();
        indexWriter.addDocuments(documents);
        duelRun(queryStore, memoryIndex, shardSearcher);
            };
        public void visit(QueryVisitor visitor) {
        private ControlQuery(MemoryIndex memoryIndex, PercolateQuery.QueryStore queryStore) {
                document.add(numberField);
        assertThat(result.scoreDocs.length, equalTo(1));
        SpanOrQuery spanOrQuery = new SpanOrQuery(spanNearQuery, spanNearQuery2);  
                assertEquals(2, topDocs.scoreDocs[1].doc);
        directoryReader = DirectoryReader.open(directory);
        doc = Collections.singleton(new InetAddressPoint("ip_field", forString("192.168.1." + randomIntBetween(lowerIpPart, upperIpPart))));
    private void addQuery(Query query, List<ParseContext.Document> docs) {
        builder.add(new TermQuery(new Term("field", "value2")), Occur.SHOULD);
    public void testFunctionScoreQuery() throws Exception {
            Collections.singletonList(new BytesArray("{}")),  
        assertThat(result.scoreDocs.length, equalTo(1));
        directoryReader = DirectoryReader.open(directory);
 *
                                throw new RuntimeException(e);
        }
        documentMapper = mapperService.merge("type", new CompressedXContent(mapper), MapperService.MergeReason.MAPPING_UPDATE);
 */  
        builder.add(new TermQuery(new Term("field", "value2")), Occur.SHOULD);
            Version.CURRENT  
            addQuery(rangeQuery, documents);  
        });
                    Explanation explain2 = shardSearcher.explain(controlQuery, controlTopDocs.scoreDocs[j].doc);  
        memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());
                "int_field",  
        addQuery(LongPoint.newRangeQuery("long_field", lowerLong, upperLong), documents);
import org.apache.lucene.index.NoMergePolicy;
                logger.error("controlTopDocs.scoreDocs[{}].score={}", i, controlTopDocs.scoreDocs[i].score);  
                                } else {
        MemoryIndex memoryIndex = MemoryIndex.fromDocument(doc, new WhitespaceAnalyzer());  
    }  
        memoryIndex.addField("field", "value1 value2 value3", new WhitespaceAnalyzer());
        for (int[] range : ranges) {
            if (randomBoolean()) {
        shardSearcher.setQueryCache(null);
        List<BytesReference> sources = Collections.singletonList(new BytesArray("{}"));
        builder = new BooleanQuery.Builder();
    public void deinit() throws Exception {
        percolateSearcher = memoryIndex.createSearcher();
        Query controlQuery = new ControlQuery(memoryIndex, queryStore);  
        return builder.build();  
        String field2 = randomFrom(stringFields);
        return shardSearcher.search(percolateQuery, 10);
        );
import java.util.Collections;
        });
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        builder.add(new TermQuery(new Term("field", "value3")), Occur.MUST);
        queryFunctions.add((id) -> {
        String queryField = "query_field";
    }
        directoryReader = DirectoryReader.open(directory);
            .startObject("half_float_field")
import org.opensearch.common.CheckedFunction;
import org.opensearch.index.mapper.MapperService;
        addQuery(HalfFloatPoint.newRangeQuery("half_float_field", 10, 15), docs);
        addQuery(spanNearQuery, documents);  
        memoryIndex = MemoryIndex.fromDocument(  
        memoryIndex = new MemoryIndex();
            } else if (rarely()) {
        queryFunctions.add(  
            duelRun(queryStore, memoryIndex, shardSearcher);  
        builder1 = new BooleanQuery.Builder();
        );
import org.opensearch.common.geo.ShapeRelation;
            .endObject()  
import java.util.function.Supplier;
            return "control{" + field + "}";
        BlendedTermQuery blendedTermQuery = BlendedTermQuery.dismaxBlendedQuery(
                    if (scorer != null) {  
        addQuery(builder.build(), docs);
            )
            .addClause(new SpanTermQuery(new Term("field", "doc")))
            .numberOfReplicas(0)  
        assertEquals(1, topDocs.scoreDocs[1].doc);
            for (int i = 0; i < numBooleanQueries; i++) {
        @Override
            Version.CURRENT  
                    occur = randomFrom(Arrays.asList(Occur.FILTER, Occur.MUST, Occur.SHOULD));  
        duelRun(queryStore, memoryIndex, shardSearcher);
                        int result = scorer.iterator().advance(doc);
                false,
        memoryIndex.addField("field", "value", new WhitespaceAnalyzer());
            queryStore,
        Version v = Version.CURRENT;
        assertEquals(1L, topDocs.totalHits.value());
                        if (result == doc) {
import org.apache.lucene.search.FilteredDocIdSetIterator;  
        int numFields = randomIntBetween(1, 3);
        @Override
        SpanNearQuery spanNearQuery2 = new SpanNearQuery.Builder("field", true).addClause(new SpanTermQuery(new Term("field", "the")))
        });  
        assertThat(result.scoreDocs.length, equalTo(1));
            builder.setMinimumNumberShouldMatch(randomIntBetween(0, 4));  
