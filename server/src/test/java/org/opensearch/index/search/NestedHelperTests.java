        rangeQuery = mapperService.fieldType("nested3.foo2").rangeQuery(2, 5, true, true, null, null, null, context);  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
            .add(new TermQuery(new Term(NestedPathFieldMapper.NAME, "nested1")), Occur.FILTER)  
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
 *
 * under the License.  
/*  
            .add(new TermQuery(new Term("nested2.foo", "baz")), Occur.SHOULD)
            .endObject()  
    }
        queryBuilder = new NestedQueryBuilder("nested1", new TermQueryBuilder("nested1.foo", "bar"), ScoreMode.Avg);
 * this file be licensed under the Apache-2.0 license or a
            // we automatically add a filter since the inner query might match non-nested docs
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested3"));
            .build();
    }  
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(query));
        indexService = createIndex("index", Settings.EMPTY, mapping);
import org.apache.lucene.search.IndexSearcher;  
            .endObject()  
 */
 * The OpenSearch Contributors require contributions made to  
            .startObject("foo")
        Query rangeQuery = mapperService.fieldType("foo2").rangeQuery(2, 5, true, true, null, null, null, context);  
    }
import org.opensearch.common.settings.Settings;
            .field("include_in_root", true)
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested2.foo", "bar")), Occur.SHOULD)  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested_missing"));
            .add(new MatchAllDocsQuery(), Occur.SHOULD)
        Query termQuery = mapperService.fieldType("foo").termQuery("bar", null);
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested3"));
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
            .build();
            .startObject("properties")  
    MapperService mapperService;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested3"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested1"));  
        termQuery = mapperService.fieldType("nested1.foo").termQuery("bar", null);  
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(rangeQuery));  
        termsQuery = mapperService.fieldType("nested1.foo").termsQuery(Collections.singletonList("bar"), MOCK_QSC_ENABLE_INDEX_DOC_VALUES);  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(expectedChildQuery, query.getChildQuery());
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested3"));  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested2"));
            .field("type", "long")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested3"));  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
    public void testDisjunction() {
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested3"));  
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested_missing"));
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termQuery));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested_missing"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested_missing"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested2"));  
import java.util.Collections;
            .startObject("properties")  
    }  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested3"));  
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(termQuery));  
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested1.foo", "bar")), Occur.SHOULD)  
        expectedChildQuery = new ConstantScoreQuery(new TermQuery(new Term("nested1.foo", "bar")));
        termsQuery = mapperService.fieldType("nested2.foo").termsQuery(Collections.singletonList("bar"), MOCK_QSC_ENABLE_INDEX_DOC_VALUES);
    public void testRangeQuery() {
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested1"));
    public void testMatchAll() {  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested2"));
            .startObject("foo")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested1"));  
 * software distributed under the License is distributed on an
            .field("type", "long")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested2"));
            .add(new MatchAllDocsQuery(), requiredOccur())
        QueryShardContext context = indexService.newQueryShardContext(0, new IndexSearcher(new MultiReader()), () -> 0, null);  
 * compatible open source license.
        bq = new BooleanQuery.Builder().add(new MatchAllDocsQuery(), requiredOccur()).add(new MatchAllDocsQuery(), requiredOccur()).build();  
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.SHOULD)  
        rangeQuery = mapperService.fieldType("nested2.foo2").rangeQuery(2, 5, true, true, null, null, null, context);
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested1"));
            .build();
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(rangeQuery));
        termQuery = mapperService.fieldType("nested2.foo").termQuery("bar", null);
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested2"));  
        OpenSearchToParentBlockJoinQuery query = (OpenSearchToParentBlockJoinQuery) queryBuilder.toQuery(context);
        termQuery = mapperService.fieldType("nested3.foo").termQuery("bar", null);
            .field("include_in_parent", true)
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
        BooleanQuery bq = new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.SHOULD)  
            .add(new TermQuery(new Term("nested1.foo", "baz")), Occur.SHOULD)
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested2"));  
    IndexService indexService;
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
        bq = new BooleanQuery.Builder().add(new MatchAllDocsQuery(), requiredOccur()).add(new MatchAllDocsQuery(), requiredOccur()).build();
            .add(new MatchAllDocsQuery(), Occur.SHOULD)
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchNoDocsQuery(), "nested2"));
    public void testNested() throws IOException {
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested3"));
 */  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested2"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested1"));  
    public void testConjunction() {
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested_missing"));
            .add(new MatchAllDocsQuery(), requiredOccur())
    @Override
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(query));
        QueryShardContext context = createSearchContext(indexService).getQueryShardContext();
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested2.foo", "bar")), requiredOccur())  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
    public void testTermQuery() {
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested1"));
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
import org.apache.lucene.search.MatchNoDocsQuery;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested_missing"));
            new ApproximateScoreQuery(Queries.newMatchAllQuery(), new ApproximateMatchAllQuery()),
/*
        bq = new BooleanQuery.Builder().add(new MatchAllDocsQuery(), requiredOccur()).add(new MatchAllDocsQuery(), requiredOccur()).build();  
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested1.foo", "bar")), requiredOccur())  
            .endObject()  
import org.apache.lucene.search.BooleanQuery;
            .endObject()
            .add(new TermQuery(new Term("foo", "baz")), Occur.SHOULD)
            new ConstantScoreQuery(new TermQuery(new Term("nested2.foo", "bar"))),
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested2.foo", "bar")), Occur.SHOULD)  
            .add(new MatchAllDocsQuery(), requiredOccur())
            .build();
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchNoDocsQuery(), "nested1"));
        query = (OpenSearchToParentBlockJoinQuery) queryBuilder.toQuery(context);
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termQuery));
            Occur.MUST  
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termsQuery));
        termsQuery = mapperService.fieldType("nested3.foo").termsQuery(Collections.singletonList("bar"), MOCK_QSC_ENABLE_INDEX_DOC_VALUES);
            .endObject();
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(new MatchAllDocsQuery()));
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.apache.lucene.index.MultiReader;
import org.opensearch.index.IndexService;
            .build();
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested_missing"));  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested2"));  
}
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested2"));
            .field("type", "nested")
 * Licensed to Elasticsearch under one or more contributor  
            .field("type", "long")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));  
 * specific language governing permissions and limitations
            .field("type", "keyword")
    }
            .endObject()  
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
/*  
            .startObject("foo")
    }
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested3.foo", "bar")), Occur.SHOULD)  
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested1"));  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested_missing"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested3"));
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
public class NestedHelperTests extends OpenSearchSingleNodeTestCase {
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested1"));
import org.opensearch.index.mapper.MapperService;
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
    }
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested3"));
 * license agreements. See the NOTICE file distributed with
            .endObject()  
        )
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchAllDocsQuery(), "nested3"));
import org.opensearch.index.query.QueryShardContext;  
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested3.foo", "bar")), Occur.SHOULD)  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
    private static Occur requiredOccur() {
 *  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested2"));
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.xcontent.XContentFactory;
            .field("type", "nested")
import java.io.IOException;  
            .add(new TermQuery(new Term("nested3.foo", "baz")), Occur.SHOULD)
            Occur.MUST
            .add(new MatchAllDocsQuery(), Occur.SHOULD)
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested1.foo", "bar")), Occur.SHOULD)  
import org.opensearch.index.mapper.NestedPathFieldMapper;  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested2"));
import org.apache.lucene.search.MatchAllDocsQuery;
    }  
        Query termsQuery = mapperService.fieldType("foo").termsQuery(Collections.singletonList("bar"), MOCK_QSC_ENABLE_INDEX_DOC_VALUES);
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchAllDocsQuery(), "nested1"));
 * You may obtain a copy of the License at  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested3"));
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested3"));
import static org.opensearch.index.mapper.FieldTypeTestCase.MOCK_QSC_ENABLE_INDEX_DOC_VALUES;  
            .endObject()
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termsQuery));
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(query));
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchNoDocsQuery(), "nested3"));  
        ).add(new TermQuery(new Term(NestedPathFieldMapper.NAME, "nested2")), Occur.FILTER).build();  
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(rangeQuery));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested3"));  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested1"));
        assertEquals(expectedChildQuery, query.getChildQuery());
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
        BooleanQuery bq = new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), requiredOccur())  
            .build();
            .build();
            .startObject("foo")
        Query expectedChildQuery = new BooleanQuery.Builder().add(
import org.apache.lucene.search.join.ScoreMode;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested3"));
            .field("type", "nested")
        rangeQuery = mapperService.fieldType("nested1.foo2").rangeQuery(2, 5, true, true, null, null, null, context);
 * Modifications Copyright OpenSearch Contributors. See
        // this time we do not add a filter since the inner query only matches inner docs
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested2"));
import org.apache.lucene.search.ConstantScoreQuery;
        ).add(new TermQuery(new Term(NestedPathFieldMapper.NAME, "nested3")), Occur.FILTER).build();
            .field("type", "keyword")
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termQuery));  
 * GitHub history for details.
            .add(new MatchAllDocsQuery(), Occur.SHOULD)
            .add(new MatchAllDocsQuery(), requiredOccur())
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested_missing"));  
import org.apache.lucene.search.Query;  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested2"));
            .field("type", "keyword")
            .startObject("nested1")
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
        return random().nextBoolean() ? Occur.MUST : Occur.FILTER;
            .build();
        queryBuilder = new NestedQueryBuilder("nested3", new TermQueryBuilder("nested3.foo", "bar"), ScoreMode.Avg);  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested3"));  
            .endObject()
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
    public void setUp() throws Exception {
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(rangeQuery));
        NestedQueryBuilder queryBuilder = new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.Avg);
            new ConstantScoreQuery(new TermQuery(new Term("nested3.foo", "bar"))),
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested3"));
            .startObject("foo2")
        // we need to add the filter again because of include_in_parent
 *
        expectedChildQuery = new BooleanQuery.Builder().add(
import org.opensearch.search.approximate.ApproximateScoreQuery;  
 * ownership. Elasticsearch licenses this file to you under  
        super.setUp();  
            .startObject("foo2")
            Occur.MUST  
            .field("type", "long")
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested1"));
            .startObject("nested2")  
        expectedChildQuery = new BooleanQuery.Builder().add(  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested1"));
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
import org.opensearch.common.lucene.search.Queries;  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchAllDocsQuery(), "nested_missing"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested2"));
            .endObject()  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchAllDocsQuery(), "nested2"));  
            .build();
            .startObject("foo2")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested_missing"));
import org.opensearch.index.query.NestedQueryBuilder;
        mapperService = indexService.mapperService();  
    public void testMatchNo() {
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));  
            .endObject()
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termsQuery));  
            .build();
 * the Apache License, Version 2.0 (the "License"); you may
            .build();
            .startObject("nested3")  
    public void testTermsQuery() {
            .endObject()  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested2"));
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchNoDocsQuery(), "nested_missing"));
 * Unless required by applicable law or agreed to in writing,
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(new MatchNoDocsQuery()));  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested3"));
        queryBuilder = new NestedQueryBuilder("nested2", new TermQueryBuilder("nested2.foo", "bar"), ScoreMode.Avg);
            .startObject("properties")  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested_missing"));  
            .startObject()
package org.opensearch.index.search;
            .endObject()  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested2"));  
import org.apache.lucene.index.Term;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested3"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested3"));
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested2"));
            .field("type", "keyword")
        assertEquals(expectedChildQuery, query.getChildQuery());  
import org.opensearch.index.query.MatchAllQueryBuilder;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested2"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested2"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested1"));
            .endObject()
import org.apache.lucene.search.TermQuery;
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(termsQuery));  
            .startObject("foo2")
            .startObject("properties")  
    }  
            .build();
        query = (OpenSearchToParentBlockJoinQuery) queryBuilder.toQuery(context);
import org.opensearch.index.query.TermQueryBuilder;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested_missing"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested_missing"));
            .endObject()
 */  
 * not use this file except in compliance with the License.
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested1"));
            .endObject()  
            .build();
        query = (OpenSearchToParentBlockJoinQuery) queryBuilder.toQuery(context);  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested_missing"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested2"));  
import org.apache.lucene.search.BooleanClause.Occur;  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested1"));
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested3.foo", "bar")), requiredOccur())  
import org.opensearch.core.xcontent.XContentBuilder;  
 * this work for additional information regarding copyright
    }  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested_missing"));  
        // we need to add the filter again because of include_in_root  
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested3"));
        assertEquals(expectedChildQuery, query.getChildQuery());
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested_missing"));
        bq = new BooleanQuery.Builder().add(new MatchAllDocsQuery(), requiredOccur()).add(new MatchAllDocsQuery(), requiredOccur()).build();
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(query));  
