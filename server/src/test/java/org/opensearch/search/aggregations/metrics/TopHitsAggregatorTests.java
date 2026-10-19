        iw.close();  
            doc.add(new StringField("_id", Uid.encodeId(Integer.toString(i)), Store.YES));  
import org.apache.lucene.search.BooleanClause.Occur;
        IndexWriter w = new IndexWriter(  
        if (randomBoolean()) {
        );
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
        TopHits hits = (TopHits) terms.getBucketByKey("a").getAggregations().get("top");
        searchHits = ((TopHits) terms.getBucketByKey("d").getAggregations().get("top")).getHits();
        when(mapper.type()).thenReturn("type");  
            result = testCase(new MatchAllDocsQuery(), topHits("_name").sort("string", SortOrder.DESC));
        Aggregation result = searchAndReduce(indexSearcher, query, builder, STRING_FIELD_TYPE);  
import org.apache.lucene.tests.index.RandomIndexWriter;
                .setMergePolicy(newLogMergePolicy())
import org.apache.lucene.document.Field.Store;  
    /**
            if (i == 500) { // any doc in 0..2048
 */  
        testCase(new MatchAllDocsQuery(), topHits("_name").sort("_score"));
import org.opensearch.search.aggregations.AggregationBuilders;
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        }
        assertEquals("3", searchHits.getAt(0).getId());
    public void testNoResults() throws Exception {  
    private Document document(String id, String... stringValues) {  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
        directory.close();
        assertFalse(AggregationInspectionHelper.hasValue(((InternalTopHits) result)));
    public void testSetScorer() throws Exception {
        assertTrue(AggregationInspectionHelper.hasValue(((InternalTopHits) terms.getBucketByKey("b").getAggregations().get("top"))));
        assertEquals("3", searchHits.getAt(0).getId());  
import org.opensearch.search.sort.SortOrder;
import org.opensearch.index.mapper.DocumentMapper;
        assertEquals(3L, searchHits.getTotalHits().value());
import org.apache.lucene.search.IndexSearcher;
            result = testCase(query, topHits("_name"));
        assertEquals("2", searchHits.getAt(0).getId());
            result = testCase(
        assertEquals(1L, searchHits.getTotalHits().value());
 * under the License.  
        Aggregation result;  
        }  
            }
        directory.close();
            Document doc = new Document();
        // The "b" bucket
    }
        } else {  
import org.apache.lucene.document.Field;
     * Tests {@code top_hits} inside of {@code terms}. While not strictly a unit test this is a fairly common way to run {@code top_hits}
 * Modifications Copyright OpenSearch Contributors. See  
        indexReader.close();
        // just check that it does not fail with exceptions
    }
 * The OpenSearch Contributors require contributions made to  
            directory,
            result = testCase(query, terms("term").field("string").subAggregation(topHits("top")));
import org.opensearch.index.mapper.IdFieldMapper;
import org.apache.lucene.index.Term;  
import static org.mockito.Mockito.when;  
        Directory directory = newDirectory();
            .build();
        assertEquals("1", searchHits.getAt(1).getId());  
        assertTrue(AggregationInspectionHelper.hasValue(((InternalTopHits) terms.getBucketByKey("a").getAggregations().get("top"))));  
import org.opensearch.search.aggregations.Aggregation;
        iw.addDocument(document("1", "a", "b"));  
        when(mapperService.documentMapper()).thenReturn(mapper);
        Terms terms = (Terms) result;
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        assertTrue(AggregationInspectionHelper.hasValue(((InternalTopHits) terms.getBucketByKey("d").getAggregations().get("top"))));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        testCase(new MatchAllDocsQuery(), topHits("_name").sort("_score", SortOrder.DESC));  
        if (randomBoolean()) {
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
public class TopHitsAggregatorTests extends AggregatorTestCase {
        iw.addDocument(document("3", "b", "d"));
package org.opensearch.search.aggregations.metrics;
import org.apache.lucene.search.MatchNoDocsQuery;  
    private Aggregation testCase(Query query, AggregationBuilder builder) throws IOException {  
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.lucene.search.TermQuery;
        w.close();  
        searchHits = ((TopHits) terms.getBucketByKey("b").getAggregations().get("top")).getHits();  
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals("2", searchHits.getAt(0).getId());  
import org.apache.lucene.document.Document;
 */
 * license agreements. See the NOTICE file distributed with
        document.add(new Field(IdFieldMapper.NAME, Uid.encodeId(id), IdFieldMapper.Defaults.FIELD_TYPE));
import org.apache.lucene.util.BytesRef;
 * this work for additional information regarding copyright
        assertTrue(AggregationInspectionHelper.hasValue(((InternalTopHits) result)));  
    public void testTopLevel() throws Exception {
        }
        w.forceMerge(1); // we need all docs to be in the same segment  
        TopHits result = searchAndReduce(searcher, query, agg, STRING_FIELD_TYPE);
import org.apache.lucene.search.MatchAllDocsQuery;
            Query query = new QueryParser("string", new KeywordAnalyzer()).parse("d^1000 c^100 b^10 a^1");
        assertEquals(0L, searchHits.getTotalHits().value());  
        searchHits = ((TopHits) terms.getBucketByKey("c").getAggregations().get("top")).getHits();
        IndexReader reader = DirectoryReader.open(w);
 * software distributed under the License is distributed on an
            }  
import org.opensearch.core.common.text.Text;  
        // second window has matches in two clauses  
 * compatible open source license.
import org.apache.lucene.index.IndexReader;
        assertEquals("1", searchHits.getAt(2).getId());
import org.apache.lucene.document.StringField;
 *
        AggregationBuilder agg = AggregationBuilders.topHits("top_hits");  
import org.apache.lucene.queryparser.classic.QueryParser;
            doc.add(new StringField("_id", Uid.encodeId(Integer.toString(2048 + i)), Store.YES));  
import org.apache.lucene.document.SortedSetDocValuesField;
                // only merge adjacent segments  
import org.opensearch.index.mapper.MapperService;
                doc.add(new StringField("string", "baz", Store.NO));
/*  
        SearchHits searchHits = ((TopHits) result).getHits();
 *  
        return mapperService;
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
        Document document = new Document();
        assertEquals("1", searchHits.getAt(1).getId());
        IndexSearcher searcher = new IndexSearcher(reader);
        reader.close();  
    }
        Aggregation result;  
    protected MapperService mapperServiceMock() {
import org.apache.lucene.analysis.core.KeywordAnalyzer;  
        // The "c" bucket  
}  
 * Licensed to Elasticsearch under one or more contributor  
        Query query = new BooleanQuery.Builder().add(new TermQuery(new Term("string", "bar")), Occur.SHOULD)  
        return document;
        assertTrue(AggregationInspectionHelper.hasValue(((InternalTopHits) terms.getBucketByKey("c").getAggregations().get("top"))));
        assertEquals(3, result.getHits().getTotalHits().value());
    @Override
    private static final MappedFieldType STRING_FIELD_TYPE = new KeywordFieldMapper.KeywordFieldType("string");
            Query query = new QueryParser("string", new KeywordAnalyzer()).parse("d^1000 c^100 b^10 a^1");
    }  
            } else if (i == 1500) {  
 */
import static org.opensearch.search.aggregations.AggregationBuilders.topHits;
import org.opensearch.index.mapper.Uid;  
/*
    }
 * KIND, either express or implied.  See the License for the
        } else {  
        return result;  
import org.apache.lucene.search.Query;
 *
import org.opensearch.search.aggregations.bucket.terms.Terms;  
        // We do not use LuceneTestCase.newSearcher because we need a DirectoryReader for "testInsideTerms"  
        SearchHits searchHits = ((TopHits) result).getHits();
            document.add(new Field("string", stringValue, KeywordFieldMapper.Defaults.FIELD_TYPE));
        for (int i = 0; i < 2048; ++i) {
    }
     * and serves as a good example of running {@code top_hits} inside of another aggregation.  
     */
        DocumentMapper mapper = mock(DocumentMapper.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (String stringValue : stringValues) {  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.search.BooleanQuery;  
 * You may obtain a copy of the License at  
            Document doc = new Document();
        assertEquals(2L, searchHits.getTotalHits().value());  
                doc.add(new StringField("string", "bar", Store.NO));
import static org.mockito.Mockito.mock;
import org.opensearch.search.aggregations.AggregatorTestCase;
            if (i == 1000) { // any doc in 0..2048
                doc.add(new StringField("string", "bar", Store.NO));
import org.apache.lucene.store.Directory;  
                terms("term").field("string").subAggregation(topHits("top").sort("string", SortOrder.DESC))
        Directory directory = newDirectory();
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
                new MatchAllDocsQuery(),  
        // first window (see BooleanScorer) has matches on one clause only  
            newIndexWriterConfig()
/*
        for (int i = 0; i < 2048; ++i) {
        assertEquals(1L, searchHits.getTotalHits().value());
import org.apache.lucene.index.DirectoryReader;  
        }  
        IndexReader indexReader = DirectoryReader.open(directory);
            .add(new TermQuery(new Term("string", "baz")), Occur.SHOULD)
import org.opensearch.search.aggregations.AggregationBuilder;  
            w.addDocument(doc);  
        assertEquals("3", searchHits.getAt(0).getId());  
        // The "a" bucket  
            );
        assertEquals("2", searchHits.getAt(1).getId());
        when(mapper.typeText()).thenReturn(new Text("type"));
        // The "d" bucket  
        SearchHits searchHits = (hits).getHits();
    public void testInsideTerms() throws Exception {
    public void testSortByScore() throws Exception {
            w.addDocument(doc);
    }
        iw.addDocument(document("2", "c", "a"));
        TopHits result = (TopHits) testCase(new MatchNoDocsQuery(), topHits("_name").sort("string", SortOrder.DESC));
import org.apache.lucene.index.IndexWriter;
import org.opensearch.search.SearchHits;
            document.add(new SortedSetDocValuesField("string", new BytesRef(stringValue)));
        }  
        MapperService mapperService = mock(MapperService.class);  
        assertEquals(2L, searchHits.getTotalHits().value());
import org.opensearch.index.mapper.KeywordFieldMapper;  
