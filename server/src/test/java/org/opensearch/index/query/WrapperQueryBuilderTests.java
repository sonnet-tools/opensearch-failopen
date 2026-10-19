        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder((byte[]) null));  
    protected void doAssertLuceneQuery(WrapperQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            case 2:
            assertEquals(json, "{}", new String(parsed.source(), "UTF-8"));
            MemoryIndex idx = new MemoryIndex();  
    @Override
    }  
        checkGeneratedJson(json, parsed);
        TermQueryBuilder tqb = new TermQueryBuilder(TEXT_FIELD_NAME, "bar");
        return new MatchAllDocsQuery(); // null == *:*  
        assertEquals("this query must be rewritten first", e.getMessage());
            builder.rewrite(shardContext)
import org.apache.lucene.index.memory.MemoryIndex;
    /**
    public void testRewriteInnerQueryToo() throws IOException {
        }
import org.opensearch.test.AbstractQueryTestCase;  
                return new WrapperQueryBuilder(bytes);  
        }
                return new WrapperQueryBuilder(wrappedQuery.toString());
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
import org.opensearch.core.common.bytes.BytesReference;
 *
                throw new UnsupportedOperationException();
    @Override
    @Override
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder(new BytesArray(new byte[0])));
import org.opensearch.core.common.bytes.BytesArray;
 * software distributed under the License is distributed on an
            }""";
        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder(""));  
 */
     * to find `query` field with nested query and should throw exception for
    }
    @Override
            throw new UncheckedIOException(e);
        final TermQueryBuilder query = new TermQueryBuilder(TEXT_FIELD_NAME, "bar").boost(2);  
    @Override  
        try {
              "wrapper" : {
 * You may obtain a copy of the License at  
    }
        qb = new WrapperQueryBuilder(  
    protected WrapperQueryBuilder doCreateTestQueryBuilder() {
        builder = new WrapperQueryBuilder("{ \"match_all\" : {\"_name\" : \"foobar\"}}").queryName("outer");
        WrapperQueryBuilder qb = new WrapperQueryBuilder(tqb.toString());
        assertEquals(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), qb.rewrite(shardContext).toQuery(shardContext));
    }  
 * specific language governing permissions and limitations
        qb = new WrapperQueryBuilder(new BoolQueryBuilder().toString());
        assertTrue(e.getMessage().contains("bogusField"));
        QueryBuilder wrappedQuery = RandomQueryBuilder.createQuery(random());  
 * not use this file except in compliance with the License.
    @Override
            {
        assertEquals(new BoolQueryBuilder().must(query).boost(3), builder.rewrite(shardContext));
        assertThat(qb.rewrite(shardContext).toQuery(shardContext), instanceOf(ApproximateScoreQuery.class));  
    }
 * this work for additional information regarding copyright
        QueryBuilder builder = new WrapperQueryBuilder(query.toString());
 *
        String json = """  
    }  
        assertEquals(new MatchAllQueryBuilder().queryName("foobar"), builder.rewrite(shardContext));  
        );
            return idx.createSearcher().rewrite(query);
    }  
import static org.hamcrest.CoreMatchers.instanceOf;  
        Query expected = rewrite(innerQuery.toQuery(context));
 * SPDX-License-Identifier: Apache-2.0
            throw new RuntimeException(e);
        ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) qb.rewrite(shardContext).toQuery(shardContext);
        } catch (IOException e) {
        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder((String) null));
    protected boolean supportsBoost() {
 *  
            case 1:
 * Licensed to Elasticsearch under one or more contributor  
        BytesReference bytes;
    }
        QueryShardContext shardContext = createShardContext();
            default:
    }  
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
        QueryBuilder builder = new WrapperQueryBuilder("{ \"match_all\" : {\"_name\" : \"foobar\"}}");
        assertEquals(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), qb.rewrite(shardContext).toQuery(shardContext));  
     */  
        switch (randomInt(2)) {
        // this causes some queries to be not exactly equal but equivalent such that we need to rewrite them before comparing.
        QueryBuilder rewrite = qb.rewrite(createShardContext());
import java.io.IOException;
        QueryBuilder innerQuery = Rewriteable.rewrite(queryBuilder, createShardContext());  
}  
    public void testIllegalArgument() {
        WrapperQueryBuilder parsed = (WrapperQueryBuilder) parseQuery(json);
        QueryShardContext shardContext = createShardContext();
import org.apache.lucene.search.MatchAllDocsQuery;  
 * this file be licensed under the Apache-2.0 license or a
    protected Query rewrite(Query query) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.search.TermQuery;
        builder = new WrapperQueryBuilder(query.toString()).boost(3);
    protected boolean builderGeneratesCacheableQueries() {  
/*
        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder(new byte[0]));
        assertEquals(
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
/*  
     * Replace the generic test from superclass, wrapper query only expects  
                return new WrapperQueryBuilder(BytesReference.toBytes(bytes));
 * Unless required by applicable law or agreed to in writing,
            new WrapperQueryBuilder(new WrapperQueryBuilder(new TermQueryBuilder(TEXT_FIELD_NAME, "bar").toString()).toString()).toString()
    }
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(approxQuery.getApproximationQuery(), instanceOf(ApproximateMatchAllQuery.class));  
        return false;
import org.apache.lucene.search.Query;
package org.opensearch.index.query;
import org.opensearch.core.common.ParsingException;  
        assertEquals(tqb, rewrite);  
    public void testUnknownField() {
 */  
            new WrapperQueryBuilder(new TermQueryBuilder(TEXT_FIELD_NAME, "bar").toString()).toString()  
    public void testMustRewrite() throws IOException {  
            new BoolQueryBuilder().must(new MatchAllQueryBuilder().queryName("foobar")).queryName("outer"),  
        if (query != null) {
 * compatible open source license.
 */  
    public void testFromJson() throws IOException {
import java.io.UnsupportedEncodingException;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    @Override  
                "query" : "e30="  
        assertEquals(query, builder.rewrite(shardContext));  
    public void testRewriteWithInnerBoost() throws IOException {
        UnsupportedOperationException e = expectThrows(UnsupportedOperationException.class, () -> qb.toQuery(createShardContext()));  
     * anything else.
public class WrapperQueryBuilderTests extends AbstractQueryTestCase<WrapperQueryBuilder> {
/*  
        // Must rewrite recursively so innerQuery matches query
        assertThat(approxQuery.getOriginalQuery(), instanceOf(MatchAllDocsQuery.class));
        return false;
    @Override  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
    public void testRewriteWithInnerName() throws IOException {  
    protected boolean supportsQueryName() {
    }  
import org.opensearch.search.approximate.ApproximateScoreQuery;
import org.apache.lucene.index.Term;
            case 0:  
    }
            bytes = org.opensearch.core.xcontent.XContentHelper.toXContent(wrappedQuery, MediaTypeRegistry.JSON, false);  
import java.io.UncheckedIOException;  
        assertEquals(rewrite(query), expected);
        QueryBuilder qb = new WrapperQueryBuilder(
        // the actual QueryBuilder that comes from the binary blob into a BooleanQueryBuilder to give it an outer boost / name  
        } catch (UnsupportedEncodingException e) {  
        String json = "{ \"" + WrapperQueryBuilder.NAME + "\" : {\"bogusField\" : \"someValue\"} }";  
        }  
        // WrapperQueryBuilder adds some optimization if the wrapper and query builder have boosts / query names that wraps
        );
        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder((BytesReference) null));
        return false;  
        QueryShardContext shardContext = createShardContext();  
 * the Apache License, Version 2.0 (the "License"); you may
              }
 * license agreements. See the NOTICE file distributed with
        );
        }  
 * The OpenSearch Contributors require contributions made to  
        try {
