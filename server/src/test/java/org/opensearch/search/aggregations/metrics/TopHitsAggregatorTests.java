        TopHits hits = (TopHits) terms.getBucketByKey("a").getAggregations().get("top");
import org.apache.lucene.index.DirectoryReader;
        iw.close();
import org.apache.lucene.search.MatchAllDocsQuery;
        assertEquals("1", searchHits.getAt(1).getId());
 *
        indexReader.close();
 * SPDX-License-Identifier: Apache-2.0
        Directory directory = newDirectory();
import static org.opensearch.search.aggregations.AggregationBuilders.topHits;
 * this work for additional information regarding copyright
                doc.add(new StringField("string", "bar", Store.NO));
package org.opensearch.search.aggregations.metrics;
        document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE));
        TopHits result = searchAndReduce(searcher, query, agg, STRING_FIELD_TYPE);
        Directory directory = newDirectory();
        iw.addDocument(document("3", "b", "d"));
                doc.add(new StringField("string", "bar", Store.NO));
                doc.add(new StringField("string", "baz", Store.NO));
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Aggregation result = searchAndReduce(indexSearcher, query, builder, STRING_FIELD_TYPE);
        directory.close();
        assertEquals(1L, searchHits.getTotalHits().value());
            doc.add(new StringField("_id", Uid.encodeId(Integer.toString(i)), Store.YES));
    }
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
        IndexSearcher searcher = new IndexSearcher(reader);
        w.forceMerge(1); // we need all docs to be in the same segment
        assertEquals("3", searchHits.getAt(0).getId());
        assertTrue(AggregationInspectionHelper.hasValue(((InternalTopHits) terms.getBucketByKey("d").getAggregations().get("top"))));
import org.apache.lucene.search.BooleanQuery;
 * software distributed under the License is distributed on an
    public void testTopLevel() throws Exception {
        assertEquals(2L, searchHits.getTotalHits().value());
import org.apache.lucene.search.IndexSearcher;
        assertFalse(AggregationInspectionHelper.hasValue(((InternalTopHits) result)));
public class TopHitsAggregatorTests extends AggregatorTestCase {
        assertEquals("2", searchHits.getAt(0).getId());
        assertEquals("2", searchHits.getAt(1).getId());
 */
        Aggregation result;
            newIndexWriterConfig()
        for (String stringValue : stringValues) {
    protected MapperService mapperServiceMock() {
import org.opensearch.index.mapper.KeywordFieldMapper;
import org.apache.lucene.document.StringField;
import org.opensearch.index.mapper.MappedFieldType;
    }
        searchHits = ((TopHits) terms.getBucketByKey("d").getAggregations().get("top")).getHits();
            result = testCase(query, topHits("_name"));
        if (randomBoolean()) {
        assertTrue(AggregationInspectionHelper.hasValue(((InternalTopHits) terms.getBucketByKey("a").getAggregations().get("top"))));
        IndexReader reader = DirectoryReader.open(w);
import org.opensearch.search.aggregations.Aggregation;
    public void testInsideTerms() throws Exception {
        iw.addDocument(document("2", "c", "a"));
        );
     */
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
            w.addDocument(doc);
 * You may obtain a copy of the License at
                // only merge adjacent segments
import org.apache.lucene.util.BytesRef;
    private Document document(String id, String... stringValues) {
        } else {
    }
        // first window (see BooleanScorer) has matches on one clause only
            w.addDocument(doc);
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor
        assertTrue(AggregationInspectionHelper.hasValue(((InternalTopHits) terms.getBucketByKey("c").getAggregations().get("top"))));
import org.apache.lucene.index.IndexReader;
        MapperService mapperService = mock(MapperService.class);
        SearchHits searchHits = ((TopHits) result).getHits();
        // just check that it does not fail with exceptions
        testCase(new MatchAllDocsQuery(), topHits("_name").sort("_score", SortOrder.DESC));
        SearchHits searchHits = ((TopHits) result).getHits();
            result = testCase(
import java.io.IOException;
        searchHits = ((TopHits) terms.getBucketByKey("b").getAggregations().get("top")).getHits();
    @Override
            directory,
        return result;
 * Unless required by applicable law or agreed to in writing,
            doc.add(new StringField("_id", Uid.encodeId(Integer.toString(2048 + i)), Store.YES));
            document.add(new SortedSetDocValuesField("string", new BytesRef(stringValue)));
        // The "a" bucket
        assertEquals(2L, searchHits.getTotalHits().value());
        Terms terms = (Terms) result;
        Query query = new BooleanQuery.Builder().add(new TermQuery(new Term("string", "bar")), Occur.SHOULD)
        searchHits = ((TopHits) terms.getBucketByKey("c").getAggregations().get("top")).getHits();
    }
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            document.add(new Field("string", stringValue, KeywordFieldMapper.Defaults.FIELD_TYPE));
        // The "c" bucket
import org.apache.lucene.index.Term;
        // second window has matches in two clauses
        for (int i = 0; i < 2048; ++i) {
        when(mapper.type()).thenReturn("type");
import org.opensearch.search.SearchHits;
import org.opensearch.search.sort.SortOrder;
            Document doc = new Document();
    private Aggregation testCase(Query query, AggregationBuilder builder) throws IOException {
/*
            if (i == 500) { // any doc in 0..2048
        assertEquals("2", searchHits.getAt(0).getId());
import org.apache.lucene.queryparser.classic.QueryParser;
                new MatchAllDocsQuery(),
        assertEquals(0L, searchHits.getTotalHits().value());
 * The OpenSearch Contributors require contributions made to
 * GitHub history for details.
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.search.TermQuery;
/*
import org.opensearch.search.aggregations.AggregatorTestCase;
        assertEquals("3", searchHits.getAt(0).getId());
            .add(new TermQuery(new Term("string", "baz")), Occur.SHOULD)
            } else if (i == 1500) {
    /**
import org.opensearch.index.mapper.MapperService;
    }
            );
                .setMergePolicy(newLogMergePolicy())
/*
 *
        // The "b" bucket
        reader.close();
            Query query = new QueryParser("string", new KeywordAnalyzer()).parse("d^1000 c^100 b^10 a^1");
        assertEquals(3, result.getHits().getTotalHits().value());
        testCase(new MatchAllDocsQuery(), topHits("_name").sort("_score"));
        IndexWriter w = new IndexWriter(
        return document;
import org.apache.lucene.document.SortedSetDocValuesField;
        }
        Document document = new Document();
        } else {
        for (int i = 0; i < 2048; ++i) {
        Aggregation result;
import static org.mockito.Mockito.when;
        assertEquals("1", searchHits.getAt(2).getId());
import org.apache.lucene.search.MatchNoDocsQuery;
 * not use this file except in compliance with the License.
        }
import org.apache.lucene.document.Field.Store;
import org.opensearch.core.common.text.Text;
            result = testCase(new MatchAllDocsQuery(), topHits("_name").sort("string", SortOrder.DESC));
 * this file be licensed under the Apache-2.0 license or a
            result = testCase(query, terms("term").field("string").subAggregation(topHits("top")));
        assertEquals("1", searchHits.getAt(1).getId());
    public void testNoResults() throws Exception {
    private static final MappedFieldType STRING_FIELD_TYPE = new KeywordFieldMapper.KeywordFieldType("string");
        assertTrue(AggregationInspectionHelper.hasValue(((InternalTopHits) result)));
        assertEquals("3", searchHits.getAt(0).getId());
            }
            Query query = new QueryParser("string", new KeywordAnalyzer()).parse("d^1000 c^100 b^10 a^1");
            }
import org.opensearch.search.aggregations.AggregationBuilders;
            if (i == 1000) { // any doc in 0..2048
    }
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
     * Tests {@code top_hits} inside of {@code terms}. While not strictly a unit test this is a fairly common way to run {@code top_hits}
 *
 */
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
import org.apache.lucene.search.Query;
        }
import org.apache.lucene.document.Document;
    }
    }
import org.opensearch.index.mapper.IdFieldMapper;
        w.close();
        directory.close();
        if (randomBoolean()) {
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
                terms("term").field("string").subAggregation(topHits("top").sort("string", SortOrder.DESC))
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.BooleanClause.Occur;
import static org.mockito.Mockito.mock;
import org.apache.lucene.tests.index.RandomIndexWriter;
    public void testSortByScore() throws Exception {
        // We do not use LuceneTestCase.newSearcher because we need a DirectoryReader for "testInsideTerms"
        IndexReader indexReader = DirectoryReader.open(directory);
        }
        assertEquals(3L, searchHits.getTotalHits().value());
        TopHits result = (TopHits) testCase(new MatchNoDocsQuery(), topHits("_name").sort("string", SortOrder.DESC));
        SearchHits searchHits = (hits).getHits();
        when(mapperService.documentMapper()).thenReturn(mapper);
        DocumentMapper mapper = mock(DocumentMapper.class);
        assertEquals(1L, searchHits.getTotalHits().value());
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.mapper.DocumentMapper;
import org.opensearch.search.aggregations.AggregationBuilder;
import org.opensearch.index.mapper.Uid;
import org.opensearch.search.aggregations.bucket.terms.Terms;
        iw.addDocument(document("1", "a", "b"));
        return mapperService;
     * and serves as a good example of running {@code top_hits} inside of another aggregation.
import org.apache.lucene.document.Field;
import org.apache.lucene.store.Directory;
        AggregationBuilder agg = AggregationBuilders.topHits("top_hits");
            .build();
    public void testSetScorer() throws Exception {
 * license agreements. See the NOTICE file distributed with
        when(mapper.typeText()).thenReturn(new Text("type"));
 */
        assertTrue(AggregationInspectionHelper.hasValue(((InternalTopHits) terms.getBucketByKey("b").getAggregations().get("top"))));
}
            Document doc = new Document();
        // The "d" bucket
 * under the License.
