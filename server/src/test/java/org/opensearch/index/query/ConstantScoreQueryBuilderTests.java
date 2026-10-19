import org.opensearch.test.AbstractQueryTestCase;
 * SPDX-License-Identifier: Apache-2.0
            + "    },\n"  
        QueryShardContext context = createShardContext();
        // Test for null filter
        assertEquals(filter, filterBuilder.filter().get(0));  
    }  
            + "}";  
        Query innerQuery = queryBuilder.innerQuery().rewrite(context).toQuery(context);
import org.apache.lucene.search.ConstantScoreQuery;
    }  
    public void testNoArrayAsFilterElements() throws IOException {
package org.opensearch.index.query;
            assertThat(query, nullValue());
        assertEquals("Rewrite first", e.getMessage());  
 * license agreements. See the NOTICE file distributed with
    /**
            + "\"filter\" : [ { \"term\": { \"foo\": \"a\" } },\n"  
        ConstantScoreQueryBuilder constantScoreQueryBuilder = new ConstantScoreQueryBuilder(new MatchNoneQueryBuilder());
 * GitHub history for details.
public class ConstantScoreQueryBuilderTests extends AbstractQueryTestCase<ConstantScoreQueryBuilder> {  
            + "} }";
     */
 * Unless required by applicable law or agreed to in writing,
            + "        \"boost\" : 42.0\n"
            + "    \"filter\" : {\n"
     */  
    public void testUnknownField() {  
    @Override
            + "  \"constant_score\" : {\n"  
 * specific language governing permissions and limitations
import java.util.ArrayList;
     * @return a {@link ConstantScoreQueryBuilder} with random boost between 0.1f and 2.0f
import static org.hamcrest.Matchers.containsString;
     * test that missing "filter" element causes {@link ParsingException}  
    }
        assertEquals(json, 42.0, parsed.innerQuery().boost(), 0.0001);  
        assertEquals(0, filterBuilder.filter().size());  
    }
    }
        expectThrows(IllegalArgumentException.class, () -> new ConstantScoreQueryBuilder((QueryBuilder) null));
import org.apache.lucene.search.MatchNoDocsQuery;
            + "        \"user\" : [ \"foobar\", \"opensearch\" ],\n"  
     */
    public void testFromJson() throws IOException {
        ConstantScoreQueryBuilder constantScoreQueryBuilder = new ConstantScoreQueryBuilder(filterBuilder);
    public void testMustRewrite() throws IOException {
            + ConstantScoreQueryBuilder.NAME
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(queryString));  
    }
        constantScoreQueryBuilder.filter(filter);
            + "  }\n"
}  
import org.opensearch.core.common.ParsingException;
 * The OpenSearch Contributors require contributions made to  
        String queryString = "{ \""  
    protected void doAssertLuceneQuery(ConstantScoreQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            assertThat(query, instanceOf(MatchNoDocsQuery.class));  
            + "{ \"term\": { \"foo\": \"x\" } } ]\n"
 * KIND, either express or implied.  See the License for the
        assertEquals(json, 23.0, parsed.boost(), 0.0001);
        filterBuilder = new BoolQueryBuilder();  
 * not use this file except in compliance with the License.
 * compatible open source license.
/*
        queryBuilder.visit(createTestVisitor(visitorQueries));  
            + "      \"terms\" : {\n"
 * ownership. Elasticsearch licenses this file to you under  
        }
    public void testRewriteToMatchNone() throws IOException {  
 *
        String json = "{\n"
        context.setAllowUnmappedFields(true);  
        return new ConstantScoreQueryBuilder(RandomQueryBuilder.createQuery(random()));  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
    }  
        } else {
    @Override  
 */
            + "    \"boost\" : 23.0\n"
    @Override  
 *  
        assertEquals(rewrite, new MatchNoneQueryBuilder());  
            assertThat(constantScoreQuery.getQuery(), instanceOf(innerQuery.getClass()));
        if (innerQuery == null) {  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        assertThat(e.getMessage(), containsString("requires a 'filter' element"));
        } else if (innerQuery instanceof MatchNoDocsQuery) {
    }  
    public void testVisit() {  
        assertEquals(2, visitorQueries.size());
        constantScoreQueryBuilder.filter(null);
        assumeTrue("test doesn't apply for query filter queries", false);
    @Override
import java.io.IOException;
        // Test for non null filter  
 * this work for additional information regarding copyright
    public void testFilter() {
            + "      }\n"
     * test that "filter" does not accept an array of queries, throws {@link ParsingException}  
        constantScoreQueryBuilder = new ConstantScoreQueryBuilder(filterBuilder);
/*  
    public void testIllegalArguments() {
import static org.hamcrest.CoreMatchers.instanceOf;
/*  
 * Licensed to Elasticsearch under one or more contributor  
 */  
        assertThat(e.getMessage(), containsString("unexpected token [START_ARRAY]"));
            assertThat(query, instanceOf(ConstantScoreQuery.class));
    protected ConstantScoreQueryBuilder doCreateTestQueryBuilder() {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> queryBuilder.toQuery(context));
 *
        ConstantScoreQueryBuilder queryBuilder = new ConstantScoreQueryBuilder(new TermQueryBuilder("unmapped_field", "foo"));
            + "\" : {\n"
import java.util.List;  
            ConstantScoreQuery constantScoreQuery = (ConstantScoreQuery) query;  
        ConstantScoreQueryBuilder queryBuilder = new ConstantScoreQueryBuilder(new TermQueryBuilder("unmapped_field", "foo"));
import static org.hamcrest.CoreMatchers.nullValue;  
 * under the License.  
import org.apache.lucene.search.Query;  
    public void testFilterElement() throws IOException {
        BoolQueryBuilder filterBuilder = new BoolQueryBuilder();
    /**
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(queryString));
        List<QueryBuilder> visitorQueries = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        checkGeneratedJson(json, parsed);  
    }
        ConstantScoreQueryBuilder parsed = (ConstantScoreQueryBuilder) parseQuery(json);
    /**
    }
        String queryString = "{ \"" + ConstantScoreQueryBuilder.NAME + "\" : {} }";  
        assertEquals(1, filterBuilder.filter().size());
        QueryBuilder filter = QueryBuilders.matchAllQuery();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        QueryBuilder rewrite = constantScoreQueryBuilder.rewrite(createShardContext());
    }
