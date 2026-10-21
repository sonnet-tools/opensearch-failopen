        assertEquals(json, 1.08, parsed.innerQuery().boost(), 0.0001);
            .endObject()
                        RuntimeException exc = expectThrows(RuntimeException.class, () -> query.rewrite(searcher));
        return false;
import static java.util.Collections.singleton;
    public void testIllegalArgument() {
    }
        @Override
            .field("type", "text")
        {
            Query query = new SpanMultiTermQueryBuilder(new PrefixQueryBuilder(fieldName, "foo")).toQuery(context);
 * the Apache License, Version 2.0 (the "License"); you may
                }
import org.apache.lucene.search.TermQuery;
import java.util.ArrayList;
    @Override
 */
            + "      }\n"
            .startObject("body")
            }
import static org.hamcrest.CoreMatchers.containsString;
}
import org.opensearch.test.AbstractQueryTestCase;
        UnsupportedOperationException e = expectThrows(
                assertThat(innerQuery, instanceOf(BoostQuery.class));
        }
        List<QueryBuilder> visitorQueries = new ArrayList<>();
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
        @Override
        }
            assertTrue(rewriteMethod instanceof SpanBooleanQueryRewriteWithMaxClause);
        }
import java.io.IOException;
    }
    }
            MultiTermQuery.RewriteMethod rewriteMethod = ((SpanMultiTermQueryWrapper) query).getRewriteMethod();
 * The OpenSearch Contributors require contributions made to
    public void testFromJson() throws IOException {
            assertFalse(rewriteMethod instanceof SpanBooleanQueryRewriteWithMaxClause);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.apache.lucene.search.TopTermsRewrite;
            assertThat(query, instanceOf(SpanMultiTermQueryWrapper.class));
        @Override
        public String queryName() {
    }
            + "        \"user\" : {\n"
 * specific language governing permissions and limitations
                    try {
        MultiTermQueryBuilder query = new TermMultiTermQueryBuilder();
 * not use this file except in compliance with the License.
            Query innerQuery = queryBuilder.innerQuery().toQuery(context);
import org.apache.lucene.search.IndexSearcher;
                innerQuery = boostQuery.getQuery();
        MultiTermQueryBuilder multiTermQueryBuilder = RandomQueryBuilder.createMultiTermQuery(random());
     * test checks that we throw an {@link UnsupportedOperationException} if the query wrapped
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertThat(rewrite.getMaxExpansions(), equalTo(IndexSearcher.getMaxClauseCount()));
            return;
import org.apache.lucene.tests.index.RandomIndexWriter;
 */
            return "foo";
            assertThat(wrapper.getField(), equalTo("prefix_field"));
            .startObject("properties")
        }
        try (Directory directory = newDirectory()) {
            + "}";
 * ownership. Elasticsearch licenses this file to you under
                    int origBoolMaxClauseCount = IndexSearcher.getMaxClauseCount();
            }
import org.apache.lucene.search.Query;
                        IndexSearcher searcher = new IndexSearcher(reader);
            MultiTermQuery.RewriteMethod rewriteMethod = ((SpanMultiTermQueryWrapper) query).getRewriteMethod();
        @Override
        }
import org.opensearch.common.compress.CompressedXContent;
    }
            return this;
        }
        if (query instanceof SpanMultiTermQueryWrapper) {
            } else {
    }
        @Override
                try (IndexReader reader = iw.getReader()) {
 * license agreements. See the NOTICE file distributed with
        // verify that the result is still a span query, despite the boost that might get set (SpanBoostQuery rather than BoostQuery)
        @Override
            assertThat(termQuery.getTerm().field(), equalTo("prefix_field._index_prefix"));
     */
        {
            .endObject()
public class SpanMultiTermQueryBuilderTests extends AbstractQueryTestCase<SpanMultiTermQueryBuilder> {
            .endObject()
 * compatible open source license.
            return "foo";
                }
    public void testUnsupportedInnerQueryType() throws IOException {
            FieldMaskingSpanQuery fieldQuery = (FieldMaskingSpanQuery) query;
        }
        assertThat(query, either(instanceOf(SpanMultiTermQueryWrapper.class)).or(instanceOf(FieldMaskingSpanQuery.class)));
        MultiTermQueryBuilder multiTermQueryBuilder = new PrefixQueryBuilderTests().createTestQueryBuilder();
                    iw.addDocument(singleton(new TextField("body", "foo bar" + Integer.toString(i), Field.Store.NO)));
        SpanMultiTermQueryBuilder spanMultiTermQueryBuilder = new SpanMultiTermQueryBuilder(multiTermQueryBuilder);
 * You may obtain a copy of the License at
        assertEquals(2, visitorQueries.size());
        );
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
        }
 *
import org.apache.lucene.search.BoostQuery;
        } else if (query instanceof FieldMaskingSpanQuery) {
                        IndexSearcher.setMaxClauseCount(origBoolMaxClauseCount);
        @Override
        public QueryBuilder queryName(String queryName) {
    @Override
import org.apache.lucene.document.TextField;
 * Unless required by applicable law or agreed to in writing,
            + "    \"match\" : {\n"
 * this file be licensed under the Apache-2.0 license or a
                    IndexSearcher.setMaxClauseCount(1);
        @Override
        }
            return 1f;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            assertTrue(rewrite.isHardLimit());
            assertThat(wrapper.getRewriteMethod(), instanceOf(SpanBooleanQueryRewriteWithMaxClause.class));
            assertThat(query, instanceOf(FieldMaskingSpanQuery.class));
            MultiTermQuery multiQuery = (MultiTermQuery) innerQuery;
    }
        }
package org.opensearch.index.query;
    private static class TermMultiTermQueryBuilder implements MultiTermQueryBuilder {
            + "        }\n"
import org.apache.lucene.queries.spans.SpanTermQuery;
        }
        public QueryBuilder boost(float boost) {
        assertThat(query, instanceOf(SpanQuery.class));
            SpanMultiTermQueryWrapper wrapper = (SpanMultiTermQueryWrapper) query;
import org.opensearch.core.xcontent.XContentBuilder;
import static org.hamcrest.CoreMatchers.either;
import org.apache.lucene.index.IndexReader;
        }
        String json = "{\n"
            .startObject("prefix_field")
import org.opensearch.common.lucene.search.SpanBooleanQueryRewriteWithMaxClause;
     * This is currently the case for {@link RangeQueryBuilder} when the target field is mapped
        SpanMultiTermQueryBuilder spanMultiTermQuery = new SpanMultiTermQueryBuilder(query);
        if (query instanceof SpanMultiTermQueryWrapper) {
        Query query = QueryBuilders.spanMultiTermQueryBuilder(QueryBuilders.prefixQuery("body", "b")).toQuery(createShardContext());
        if (query instanceof SpanMultiTermQueryWrapper) {
            .endObject()
import java.util.List;
            if (multiQuery.getRewriteMethod() instanceof TopTermsRewrite) {
            assertThat(fieldQuery.getMaskedQuery(), instanceOf(SpanTermQuery.class));
        }
        return new SpanMultiTermQueryBuilder(multiTermQueryBuilder);
                        Query query = queryBuilder.toQuery(createShardContext(searcher));
            () -> spanMultiTermQuery.toQuery(createShardContext())
import org.apache.lucene.search.MultiTermQuery;
        public Query toQuery(QueryShardContext context) throws IOException {
    @Override
/*
    }
import org.opensearch.core.common.io.stream.StreamOutput;
            .endObject()
 *
            assertThat(termQuery.getTerm().text(), equalTo("foo"));
            assertThat(innerQuery, instanceOf(MultiTermQuery.class));
            .endObject()
    @Override
    protected boolean supportsBoost() {
    /**
    public void testVisit() {
    public void testDefaultMaxRewriteBuilder() throws Exception {
            + "      \"prefix\" : {\n"
import org.opensearch.index.mapper.MapperService;
                        QueryBuilder queryBuilder = new SpanMultiTermQueryBuilder(QueryBuilders.prefixQuery("body", "bar"));
            Query query = new SpanMultiTermQueryBuilder(new PrefixQueryBuilder(fieldName, "f")).toQuery(context);
        final QueryShardContext context = createShardContext();
    }
import static org.hamcrest.CoreMatchers.startsWith;
        checkGeneratedJson(json, parsed);
        }
        String fieldName = randomFrom("prefix_field", "prefix_field_alias");
        mapperService.merge("_doc", new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
/*
    public void testTopNMultiTermsRewriteInsideSpan() throws Exception {
            .field("type", "text")
            return "foo";
            .field("type", "alias")
                BoostQuery boostQuery = (BoostQuery) innerQuery;
import org.apache.lucene.store.Directory;
                    }
                assertThat(wrapper.getRewriteMethod(), instanceOf(SpanBooleanQueryRewriteWithMaxClause.class));
            return new TermQuery(new Term("foo", "bar"));
 * KIND, either express or implied.  See the License for the
            FieldMaskingSpanQuery mask = (FieldMaskingSpanQuery) query;
            .toQuery(createShardContext());
    }
    public void testToQueryInnerSpanMultiTerm() throws IOException {
            UnsupportedOperationException.class,
        SpanMultiTermQueryBuilder parsed = (SpanMultiTermQueryBuilder) parseQuery(json);
            PrefixQuery prefixQuery = (PrefixQuery) wrapper.getWrappedQuery();
    public void testTermExpansionExceptionOnSpanFailure() throws Exception {
            .startObject("prefix_field_alias")
        }
     * to a date.
    protected SpanMultiTermQueryBuilder doCreateTestQueryBuilder() {
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.apache.lucene.index.Term;
 */
import org.apache.lucene.queries.spans.SpanQuery;
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
        }
 * this work for additional information regarding copyright
        assertEquals(json, "ki", ((PrefixQueryBuilder) parsed.innerQuery()).value());
import org.apache.lucene.search.PrefixQuery;
            assertThat(mask.getMaskedQuery(), instanceOf(TermQuery.class));
            .startObject("_doc")
 * under the License.
        expectThrows(IllegalArgumentException.class, () -> new SpanMultiTermQueryBuilder((MultiTermQueryBuilder) null));
     * by {@link SpanMultiTermQueryBuilder} does not generate a lucene {@link MultiTermQuery}.
            + "    },\n"
import static org.hamcrest.CoreMatchers.instanceOf;
            + "  }\n"
            + "          \"boost\" : 1.08\n"
    public void testToQueryInnerTermQuery() throws IOException {
                assertThat(wrapper.getRewriteMethod(), instanceOf(SpanMultiTermQueryWrapper.TopTermsSpanBooleanQueryRewrite.class));
            + "    \"boost\" : 1.0\n"
        @Override
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
        XContentBuilder mapping = jsonBuilder().startObject()
 * GitHub history for details.
            SpanBooleanQueryRewriteWithMaxClause rewrite = (SpanBooleanQueryRewriteWithMaxClause) wrapper.getRewriteMethod();
    }
        public QueryBuilder filter(QueryBuilder filter) {
        }
    }
                    } finally {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertTrue(query instanceof SpanMultiTermQueryWrapper);
            return builder;
import static org.hamcrest.CoreMatchers.equalTo;
        @Override
 * software distributed under the License is distributed on an
            return "foo";
            .startObject("index_prefixes")
            + "          \"value\" : \"ki\",\n"
            .endObject();
        assertTrue(query instanceof SpanMultiTermQueryWrapper);
 * Licensed to Elasticsearch under one or more contributor
        public String fieldName() {
/*
            .field("path", "prefix_field")
        spanMultiTermQueryBuilder.visit(createTestVisitor(visitorQueries));
        if (query instanceof SpanMatchNoDocsQuery) {
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.lucene.queries.SpanMatchNoDocsQuery;
 *
 * SPDX-License-Identifier: Apache-2.0
            assertThat(wrapper.getWrappedQuery(), instanceOf(PrefixQuery.class));
            SpanMultiTermQueryWrapper wrapper = (SpanMultiTermQueryWrapper) query;
            + "  \"span_multi\" : {\n"
    }
            SpanTermQuery termQuery = (SpanTermQuery) fieldQuery.getMaskedQuery();
            if (queryBuilder.innerQuery().boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
        }
            assertThat(prefixQuery.getField(), equalTo("prefix_field"));
        public String getName() {
        Query query = QueryBuilders.spanMultiTermQueryBuilder(QueryBuilders.prefixQuery("body", "b").rewrite("top_terms_boost_2000"))
        Query query = new SpanOrQueryBuilder(createTestQueryBuilder()).toQuery(createShardContext());
        @Override
            return this;
        public float boost() {
        assertThat(e.getMessage(), startsWith("unsupported inner query"));
            assertThat(prefixQuery.getPrefix().text(), equalTo("f"));
            assertThat(fieldQuery.getField(), equalTo("prefix_field"));
    protected void doAssertLuceneQuery(SpanMultiTermQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
import org.apache.lucene.document.Field;
        public String getWriteableName() {
            return this;
            }
                        assertThat(exc.getMessage(), containsString("maxClauseCount"));
                for (int i = 0; i < 3; i++) {
