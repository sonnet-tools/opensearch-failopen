        termsQuery = mapperService.fieldType("nested2.foo").termsQuery(Collections.singletonList("bar"), MOCK_QSC_ENABLE_INDEX_DOC_VALUES);
        )
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested_missing"));
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchNoDocsQuery(), "nested3"));
            .startObject("foo2")
        // we need to add the filter again because of include_in_parent
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested2"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested3"));
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termQuery));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested3"));
            .add(new MatchAllDocsQuery(), requiredOccur())
import org.apache.lucene.index.Term;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested2"));
            .build();
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(rangeQuery));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested2"));
    public void testTermsQuery() {
            .add(new MatchAllDocsQuery(), Occur.SHOULD)
/*
import org.apache.lucene.search.TermQuery;
 *
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(rangeQuery));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested2"));
    }
            Occur.MUST
import org.apache.lucene.search.BooleanClause.Occur;
            .build();
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested3"));
        queryBuilder = new NestedQueryBuilder("nested3", new TermQueryBuilder("nested3.foo", "bar"), ScoreMode.Avg);
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .endObject()
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested_missing"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested3"));
            .build();
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchNoDocsQuery(), "nested_missing"));
/*
            .build();
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        termQuery = mapperService.fieldType("nested2.foo").termQuery("bar", null);
import org.apache.lucene.search.join.ScoreMode;
 * The OpenSearch Contributors require contributions made to
/*
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested1"));
        termQuery = mapperService.fieldType("nested1.foo").termQuery("bar", null);
        QueryShardContext context = createSearchContext(indexService).getQueryShardContext();
    public void testMatchNo() {
            .field("type", "long")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested_missing"));
            .field("type", "keyword")
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested3"));
 * Modifications Copyright OpenSearch Contributors. See
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested2.foo", "bar")), requiredOccur())
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested_missing"));
            .add(new TermQuery(new Term("foo", "baz")), Occur.SHOULD)
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested3"));
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested1.foo", "bar")), Occur.SHOULD)
        query = (OpenSearchToParentBlockJoinQuery) queryBuilder.toQuery(context);
    }
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested1"));
import java.io.IOException;
        // this time we do not add a filter since the inner query only matches inner docs
            .endObject()
            .endObject()
    private static Occur requiredOccur() {
            .add(new MatchAllDocsQuery(), Occur.SHOULD)
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested_missing"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
import org.apache.lucene.search.Query;
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(query));
 *
import org.opensearch.index.query.NestedQueryBuilder;
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(termsQuery));
            new ConstantScoreQuery(new TermQuery(new Term("nested3.foo", "bar"))),
        termQuery = mapperService.fieldType("nested3.foo").termQuery("bar", null);
            .build();
            .endObject()
            .endObject()
        assertEquals(expectedChildQuery, query.getChildQuery());
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(expectedChildQuery, query.getChildQuery());
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested3"));
package org.opensearch.index.search;
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested2"));
    }
    public void testRangeQuery() {
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested_missing"));
            .build();
            .endObject()
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(termQuery));
import org.opensearch.index.mapper.MapperService;
    public void testConjunction() {
        Query expectedChildQuery = new BooleanQuery.Builder().add(
            .endObject()
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.SHOULD)
            .startObject("properties")
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchNoDocsQuery(), "nested1"));
            .add(new MatchAllDocsQuery(), Occur.SHOULD)
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested2"));
        queryBuilder = new NestedQueryBuilder("nested2", new TermQueryBuilder("nested2.foo", "bar"), ScoreMode.Avg);
        rangeQuery = mapperService.fieldType("nested2.foo2").rangeQuery(2, 5, true, true, null, null, null, context);
        bq = new BooleanQuery.Builder().add(new MatchAllDocsQuery(), requiredOccur()).add(new MatchAllDocsQuery(), requiredOccur()).build();
            .field("type", "long")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested_missing"));
            .field("type", "keyword")
 * You may obtain a copy of the License at
 *
            .startObject("nested1")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested2"));
 *     http://www.apache.org/licenses/LICENSE-2.0
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested1.foo", "bar")), Occur.SHOULD)
import org.opensearch.search.approximate.ApproximateScoreQuery;
import org.apache.lucene.search.MatchAllDocsQuery;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested3"));
 */
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested3.foo", "bar")), requiredOccur())
        bq = new BooleanQuery.Builder().add(new MatchAllDocsQuery(), requiredOccur()).add(new MatchAllDocsQuery(), requiredOccur()).build();
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested_missing"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested2"));
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(new MatchAllDocsQuery()));
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        OpenSearchToParentBlockJoinQuery query = (OpenSearchToParentBlockJoinQuery) queryBuilder.toQuery(context);
            .startObject("properties")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested3"));
            .startObject("foo")
import org.apache.lucene.search.BooleanQuery;
    }
            .startObject("foo")
import org.apache.lucene.search.ConstantScoreQuery;
        NestedQueryBuilder queryBuilder = new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.Avg);
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termQuery));
        bq = new BooleanQuery.Builder().add(new MatchAllDocsQuery(), requiredOccur()).add(new MatchAllDocsQuery(), requiredOccur()).build();
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested2"));
import java.util.Collections;
            .add(new MatchAllDocsQuery(), requiredOccur())
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termsQuery));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested_missing"));
    }
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested2"));
            .build();
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested3"));
            .add(new TermQuery(new Term("nested3.foo", "baz")), Occur.SHOULD)
            .build();
        rangeQuery = mapperService.fieldType("nested1.foo2").rangeQuery(2, 5, true, true, null, null, null, context);
 * this work for additional information regarding copyright
            .endObject()
        termsQuery = mapperService.fieldType("nested3.foo").termsQuery(Collections.singletonList("bar"), MOCK_QSC_ENABLE_INDEX_DOC_VALUES);
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        termsQuery = mapperService.fieldType("nested1.foo").termsQuery(Collections.singletonList("bar"), MOCK_QSC_ENABLE_INDEX_DOC_VALUES);
            .startObject("foo2")
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termsQuery));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested_missing"));
            // we automatically add a filter since the inner query might match non-nested docs
            .add(new TermQuery(new Term("nested1.foo", "baz")), Occur.SHOULD)
        query = (OpenSearchToParentBlockJoinQuery) queryBuilder.toQuery(context);
        mapperService = indexService.mapperService();
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        return random().nextBoolean() ? Occur.MUST : Occur.FILTER;
import static org.opensearch.index.mapper.FieldTypeTestCase.MOCK_QSC_ENABLE_INDEX_DOC_VALUES;
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(query));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested2"));
            .startObject("nested2")
    public void testNested() throws IOException {
            .add(new TermQuery(new Term(NestedPathFieldMapper.NAME, "nested1")), Occur.FILTER)
            .field("type", "nested")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested3"));
    IndexService indexService;
            .endObject()
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(rangeQuery));
            .startObject("properties")
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
            .endObject()
import org.opensearch.common.settings.Settings;
        BooleanQuery bq = new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.SHOULD)
            Occur.MUST
import org.apache.lucene.index.MultiReader;
    }
    public void setUp() throws Exception {
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested_missing"));
        QueryShardContext context = indexService.newQueryShardContext(0, new IndexSearcher(new MultiReader()), () -> 0, null);
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
            .startObject("properties")
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchNoDocsQuery(), "nested2"));
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(rangeQuery));
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested3"));
            new ConstantScoreQuery(new TermQuery(new Term("nested2.foo", "bar"))),
 * GitHub history for details.
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested1"));
        assertEquals(expectedChildQuery, query.getChildQuery());
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchAllDocsQuery(), "nested2"));
            .endObject()
            .build();
            .endObject();
 * specific language governing permissions and limitations
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(query));
public class NestedHelperTests extends OpenSearchSingleNodeTestCase {
 * Unless required by applicable law or agreed to in writing,
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchAllDocsQuery(), "nested3"));
            .add(new MatchAllDocsQuery(), requiredOccur())
            .startObject()
            .field("type", "keyword")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested2"));
        expectedChildQuery = new ConstantScoreQuery(new TermQuery(new Term("nested1.foo", "bar")));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested1"));
        expectedChildQuery = new BooleanQuery.Builder().add(
import org.apache.lucene.search.MatchNoDocsQuery;
        bq = new BooleanQuery.Builder().add(new MatchAllDocsQuery(), requiredOccur()).add(new MatchAllDocsQuery(), requiredOccur()).build();
}
    @Override
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
import org.opensearch.index.query.TermQueryBuilder;
 */
            .add(new MatchAllDocsQuery(), Occur.SHOULD)
        super.setUp();
            .field("include_in_parent", true)
            .build();
    public void testDisjunction() {
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
import org.opensearch.common.lucene.search.Queries;
            .field("include_in_root", true)
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested2"));
            .endObject()
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested3"));
        // we need to add the filter again because of include_in_root
            .add(new MatchAllDocsQuery(), requiredOccur())
        assertEquals(expectedChildQuery, query.getChildQuery());
        Query termsQuery = mapperService.fieldType("foo").termsQuery(Collections.singletonList("bar"), MOCK_QSC_ENABLE_INDEX_DOC_VALUES);
 * software distributed under the License is distributed on an
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested3.foo", "bar")), Occur.SHOULD)
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
            .startObject("foo")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested3"));
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested3.foo", "bar")), Occur.SHOULD)
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested2.foo", "bar")), Occur.SHOULD)
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested2"));
        ).add(new TermQuery(new Term(NestedPathFieldMapper.NAME, "nested2")), Occur.FILTER).build();
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested3"));
 * compatible open source license.
            .startObject("foo2")
import org.opensearch.index.mapper.NestedPathFieldMapper;
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested1"));
            .endObject()
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested2.foo", "bar")), Occur.SHOULD)
        rangeQuery = mapperService.fieldType("nested3.foo2").rangeQuery(2, 5, true, true, null, null, null, context);
        indexService = createIndex("index", Settings.EMPTY, mapping);
            .startObject("foo2")
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested2"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested3"));
    }
        assertFalse(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested1"));
    public void testTermQuery() {
        Query rangeQuery = mapperService.fieldType("foo2").rangeQuery(2, 5, true, true, null, null, null, context);
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested2"));
import org.opensearch.index.IndexService;
        BooleanQuery bq = new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), requiredOccur())
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested1"));
            .endObject()
 * ownership. Elasticsearch licenses this file to you under
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested3"));
import org.apache.lucene.search.IndexSearcher;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(bq, "nested3"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested3"));
 * not use this file except in compliance with the License.
            .startObject("nested3")
            .field("type", "long")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested2"));
            .field("type", "keyword")
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termsQuery));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested2"));
import org.opensearch.index.query.QueryShardContext;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested_missing"));
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(rangeQuery, "nested1"));
 * this file be licensed under the Apache-2.0 license or a
    public void testMatchAll() {
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
import org.opensearch.common.xcontent.XContentFactory;
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchAllDocsQuery(), "nested1"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested_missing"));
 * KIND, either express or implied.  See the License for the
    }
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(termQuery));
            new ApproximateScoreQuery(Queries.newMatchAllQuery(), new ApproximateMatchAllQuery()),
            .startObject("foo")
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested2"));
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested_missing"));
        Query termQuery = mapperService.fieldType("foo").termQuery("bar", null);
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested_missing"));
 * Licensed to Elasticsearch under one or more contributor
    MapperService mapperService;
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(new MatchAllDocsQuery(), "nested_missing"));
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested2"));
 */
        ).add(new TermQuery(new Term(NestedPathFieldMapper.NAME, "nested3")), Occur.FILTER).build();
            .field("type", "nested")
            .endObject()
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
            .field("type", "nested")
    }
import org.opensearch.core.xcontent.XContentBuilder;
    }
            Occur.MUST
            .build();
            .add(new TermQuery(new Term("nested2.foo", "baz")), Occur.SHOULD)
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(new MatchNoDocsQuery()));
            .build();
import org.opensearch.index.query.MatchAllQueryBuilder;
 * under the License.
 * license agreements. See the NOTICE file distributed with
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(query, "nested1"));
            .field("type", "long")
        bq = new BooleanQuery.Builder().add(new TermQuery(new Term("nested1.foo", "bar")), requiredOccur())
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termQuery, "nested3"));
        expectedChildQuery = new BooleanQuery.Builder().add(
        assertTrue(new NestedHelper(mapperService).mightMatchNestedDocs(bq));
        assertFalse(new NestedHelper(mapperService).mightMatchNestedDocs(query));
        query = (OpenSearchToParentBlockJoinQuery) queryBuilder.toQuery(context);
        queryBuilder = new NestedQueryBuilder("nested1", new TermQueryBuilder("nested1.foo", "bar"), ScoreMode.Avg);
        assertTrue(new NestedHelper(mapperService).mightMatchNonNestedDocs(termsQuery, "nested_missing"));
