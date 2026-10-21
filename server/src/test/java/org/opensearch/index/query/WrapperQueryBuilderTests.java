        );
            bytes = org.opensearch.core.xcontent.XContentHelper.toXContent(wrappedQuery, MediaTypeRegistry.JSON, false);
            case 0:
 * The OpenSearch Contributors require contributions made to
            builder.rewrite(shardContext)
        assertThat(approxQuery.getOriginalQuery(), instanceOf(MatchAllDocsQuery.class));
import java.io.IOException;
        String json = "{ \"" + WrapperQueryBuilder.NAME + "\" : {\"bogusField\" : \"someValue\"} }";
 */
            {
        QueryBuilder wrappedQuery = RandomQueryBuilder.createQuery(random());
package org.opensearch.index.query;
        return false;
    protected void doAssertLuceneQuery(WrapperQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        assertEquals(
 * SPDX-License-Identifier: Apache-2.0
        String json = """
        qb = new WrapperQueryBuilder(
        assertEquals("this query must be rewritten first", e.getMessage());
        QueryBuilder rewrite = qb.rewrite(createShardContext());
    }
     * to find `query` field with nested query and should throw exception for
                return new WrapperQueryBuilder(BytesReference.toBytes(bytes));
            MemoryIndex idx = new MemoryIndex();
 * You may obtain a copy of the License at
        UnsupportedOperationException e = expectThrows(UnsupportedOperationException.class, () -> qb.toQuery(createShardContext()));
    /**
    public void testRewriteWithInnerBoost() throws IOException {
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    }
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        qb = new WrapperQueryBuilder(new BoolQueryBuilder().toString());
    protected boolean builderGeneratesCacheableQueries() {
            case 1:
                "query" : "e30="
    }
 * ownership. Elasticsearch licenses this file to you under
        try {
    }
    public void testMustRewrite() throws IOException {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        } catch (UnsupportedEncodingException e) {
        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder((String) null));
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
 */
 * this work for additional information regarding copyright
    public void testIllegalArgument() {
import org.opensearch.core.common.bytes.BytesArray;
    protected WrapperQueryBuilder doCreateTestQueryBuilder() {
        return new MatchAllDocsQuery(); // null == *:*
    public void testRewriteWithInnerName() throws IOException {
        assertTrue(e.getMessage().contains("bogusField"));
 * specific language governing permissions and limitations
import org.opensearch.test.AbstractQueryTestCase;
 * KIND, either express or implied.  See the License for the
public class WrapperQueryBuilderTests extends AbstractQueryTestCase<WrapperQueryBuilder> {
        }
        QueryShardContext shardContext = createShardContext();
 * Unless required by applicable law or agreed to in writing,
    @Override
        }
        builder = new WrapperQueryBuilder(query.toString()).boost(3);
        }
    }
import static org.hamcrest.CoreMatchers.instanceOf;
              "wrapper" : {
 *
 *
import org.apache.lucene.index.Term;
     * Replace the generic test from superclass, wrapper query only expects
        assertEquals(new BoolQueryBuilder().must(query).boost(3), builder.rewrite(shardContext));
    @Override
    @Override
    protected Query rewrite(Query query) throws IOException {
    }
 * software distributed under the License is distributed on an
     * anything else.
    }
import java.io.UncheckedIOException;
/*
        // this causes some queries to be not exactly equal but equivalent such that we need to rewrite them before comparing.
    @Override
            case 2:
                return new WrapperQueryBuilder(bytes);
        QueryBuilder innerQuery = Rewriteable.rewrite(queryBuilder, createShardContext());
            throw new UncheckedIOException(e);
    @Override
        TermQueryBuilder tqb = new TermQueryBuilder(TEXT_FIELD_NAME, "bar");
import org.opensearch.search.approximate.ApproximateScoreQuery;
    }
        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder(new BytesArray(new byte[0])));
import org.apache.lucene.search.Query;
        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder(""));
 * this file be licensed under the Apache-2.0 license or a
            throw new RuntimeException(e);
        WrapperQueryBuilder qb = new WrapperQueryBuilder(tqb.toString());
        } catch (IOException e) {
            default:
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
        ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) qb.rewrite(shardContext).toQuery(shardContext);
        BytesReference bytes;
    }
    }
        QueryShardContext shardContext = createShardContext();
        // the actual QueryBuilder that comes from the binary blob into a BooleanQueryBuilder to give it an outer boost / name
        assertEquals(rewrite(query), expected);
    protected boolean supportsBoost() {
        checkGeneratedJson(json, parsed);
        );
            }""";
    }
import org.apache.lucene.index.memory.MemoryIndex;
 * compatible open source license.
        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder((BytesReference) null));
    public void testRewriteInnerQueryToo() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        );
        assertThat(qb.rewrite(shardContext).toQuery(shardContext), instanceOf(ApproximateScoreQuery.class));
        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder((byte[]) null));
        assertEquals(new MatchAllQueryBuilder().queryName("foobar"), builder.rewrite(shardContext));
        QueryBuilder builder = new WrapperQueryBuilder(query.toString());
 * Licensed to Elasticsearch under one or more contributor
        QueryBuilder builder = new WrapperQueryBuilder("{ \"match_all\" : {\"_name\" : \"foobar\"}}");
    public void testFromJson() throws IOException {
    protected boolean supportsQueryName() {
    @Override
     */
        try {
        assertThat(approxQuery.getApproximationQuery(), instanceOf(ApproximateMatchAllQuery.class));
        return false;
    }
        // WrapperQueryBuilder adds some optimization if the wrapper and query builder have boosts / query names that wraps
        WrapperQueryBuilder parsed = (WrapperQueryBuilder) parseQuery(json);
import org.apache.lucene.search.TermQuery;
 * under the License.
            assertEquals(json, "{}", new String(parsed.source(), "UTF-8"));
            return idx.createSearcher().rewrite(query);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Query expected = rewrite(innerQuery.toQuery(context));
import java.io.UnsupportedEncodingException;
}
        switch (randomInt(2)) {
 *
            new WrapperQueryBuilder(new TermQueryBuilder(TEXT_FIELD_NAME, "bar").toString()).toString()
        QueryShardContext shardContext = createShardContext();
                throw new UnsupportedOperationException();
        builder = new WrapperQueryBuilder("{ \"match_all\" : {\"_name\" : \"foobar\"}}").queryName("outer");
 */
/*
        // Must rewrite recursively so innerQuery matches query
        return false;
        final TermQueryBuilder query = new TermQueryBuilder(TEXT_FIELD_NAME, "bar").boost(2);
import org.opensearch.core.common.ParsingException;
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(query, builder.rewrite(shardContext));
                return new WrapperQueryBuilder(wrappedQuery.toString());
    public void testUnknownField() {
        assertEquals(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), qb.rewrite(shardContext).toQuery(shardContext));
 * GitHub history for details.
    @Override
        if (query != null) {
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(new TermQuery(new Term(TEXT_FIELD_NAME, "bar")), qb.rewrite(shardContext).toQuery(shardContext));
        }
        assertEquals(tqb, rewrite);
            new BoolQueryBuilder().must(new MatchAllQueryBuilder().queryName("foobar")).queryName("outer"),
        QueryBuilder qb = new WrapperQueryBuilder(
        expectThrows(IllegalArgumentException.class, () -> new WrapperQueryBuilder(new byte[0]));
import org.apache.lucene.search.MatchAllDocsQuery;
            new WrapperQueryBuilder(new WrapperQueryBuilder(new TermQueryBuilder(TEXT_FIELD_NAME, "bar").toString()).toString()).toString()
              }
    @Override
