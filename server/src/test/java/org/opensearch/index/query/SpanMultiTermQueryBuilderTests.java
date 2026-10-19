            .startObject("body")  
            return this;
        }
        if (query instanceof SpanMatchNoDocsQuery) {  
import org.opensearch.common.compress.CompressedXContent;
        @Override  
    }  
     * to a date.
import org.apache.lucene.search.TermQuery;  
        @Override
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
            .endObject()  
                BoostQuery boostQuery = (BoostQuery) innerQuery;  
        @Override  
import org.apache.lucene.search.IndexSearcher;
            assertThat(innerQuery, instanceOf(MultiTermQuery.class));  
import org.opensearch.lucene.queries.SpanMatchNoDocsQuery;  
            assertThat(query, instanceOf(FieldMaskingSpanQuery.class));
            return;
import org.opensearch.core.xcontent.XContentBuilder;
    /**
        }
 * ownership. Elasticsearch licenses this file to you under  
                    } finally {
                    int origBoolMaxClauseCount = IndexSearcher.getMaxClauseCount();
            }
import org.apache.lucene.index.IndexReader;
        assertThat(e.getMessage(), startsWith("unsupported inner query"));
        }  
        return new SpanMultiTermQueryBuilder(multiTermQueryBuilder);
    }
        Query query = QueryBuilders.spanMultiTermQueryBuilder(QueryBuilders.prefixQuery("body", "b").rewrite("top_terms_boost_2000"))
        }
                        IndexSearcher.setMaxClauseCount(origBoolMaxClauseCount);
            assertThat(mask.getMaskedQuery(), instanceOf(TermQuery.class));  
        Query query = QueryBuilders.spanMultiTermQueryBuilder(QueryBuilders.prefixQuery("body", "b")).toQuery(createShardContext());
 * the Apache License, Version 2.0 (the "License"); you may
                    }  
public class SpanMultiTermQueryBuilderTests extends AbstractQueryTestCase<SpanMultiTermQueryBuilder> {  
            .field("type", "alias")  
                        assertThat(exc.getMessage(), containsString("maxClauseCount"));  
import org.opensearch.index.mapper.MapperService;
        public String queryName() {
            SpanMultiTermQueryWrapper wrapper = (SpanMultiTermQueryWrapper) query;
        @Override  
import org.opensearch.common.lucene.search.SpanBooleanQueryRewriteWithMaxClause;
        );
                    iw.addDocument(singleton(new TextField("body", "foo bar" + Integer.toString(i), Field.Store.NO)));
        assertEquals(2, visitorQueries.size());
            .endObject()  
        }
            .endObject();
        final QueryShardContext context = createShardContext();
        {
        @Override
        // verify that the result is still a span query, despite the boost that might get set (SpanBoostQuery rather than BoostQuery)
        assertThat(query, instanceOf(SpanQuery.class));
        assertEquals(json, "ki", ((PrefixQueryBuilder) parsed.innerQuery()).value());
        }
        @Override
    public void testToQueryInnerSpanMultiTerm() throws IOException {
    }
                innerQuery = boostQuery.getQuery();
    }
     * by {@link SpanMultiTermQueryBuilder} does not generate a lucene {@link MultiTermQuery}.  
import org.apache.lucene.index.Term;
        public Query toQuery(QueryShardContext context) throws IOException {
    protected SpanMultiTermQueryBuilder doCreateTestQueryBuilder() {
        public QueryBuilder boost(float boost) {  
            assertThat(wrapper.getRewriteMethod(), instanceOf(SpanBooleanQueryRewriteWithMaxClause.class));
            } else {
import java.util.List;
        assertThat(query, either(instanceOf(SpanMultiTermQueryWrapper.class)).or(instanceOf(FieldMaskingSpanQuery.class)));  
import org.apache.lucene.search.PrefixQuery;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            Query query = new SpanMultiTermQueryBuilder(new PrefixQueryBuilder(fieldName, "f")).toQuery(context);
            UnsupportedOperationException.class,
            assertFalse(rewriteMethod instanceof SpanBooleanQueryRewriteWithMaxClause);
import org.apache.lucene.search.Query;
 * KIND, either express or implied.  See the License for the
            return new TermQuery(new Term("foo", "bar"));
            assertThat(wrapper.getWrappedQuery(), instanceOf(PrefixQuery.class));
        SpanMultiTermQueryBuilder parsed = (SpanMultiTermQueryBuilder) parseQuery(json);
            .startObject("_doc")
            + "      \"prefix\" : {\n"  
        }
import org.apache.lucene.tests.index.RandomIndexWriter;  
            .field("type", "text")
import org.apache.lucene.queries.spans.SpanTermQuery;  
    }
            + "}";  
    public void testVisit() {  
        }
        MultiTermQueryBuilder multiTermQueryBuilder = RandomQueryBuilder.createMultiTermQuery(random());  
    }  
        @Override
        @Override
        Query query = new SpanOrQueryBuilder(createTestQueryBuilder()).toQuery(createShardContext());  
        assertTrue(query instanceof SpanMultiTermQueryWrapper);
        public QueryBuilder filter(QueryBuilder filter) {  
import static org.hamcrest.CoreMatchers.either;
        expectThrows(IllegalArgumentException.class, () -> new SpanMultiTermQueryBuilder((MultiTermQueryBuilder) null));
            return builder;
        spanMultiTermQueryBuilder.visit(createTestVisitor(visitorQueries));
     * This is currently the case for {@link RangeQueryBuilder} when the target field is mapped
            .startObject("index_prefixes")
                assertThat(innerQuery, instanceOf(BoostQuery.class));
            .endObject()
        }
 * software distributed under the License is distributed on an
        public float boost() {
            return "foo";
        public String getName() {
            + "      }\n"
import org.apache.lucene.search.MultiTermQuery;  
        }
        String json = "{\n"  
    }
            assertThat(query, instanceOf(SpanMultiTermQueryWrapper.class));  
    public void testUnsupportedInnerQueryType() throws IOException {
    protected boolean supportsBoost() {  
            SpanBooleanQueryRewriteWithMaxClause rewrite = (SpanBooleanQueryRewriteWithMaxClause) wrapper.getRewriteMethod();
                    try {
            + "          \"value\" : \"ki\",\n"
import java.io.IOException;  
        }
import org.apache.lucene.search.TopTermsRewrite;
    public void testFromJson() throws IOException {
        @Override
            return "foo";  
            + "  \"span_multi\" : {\n"
            .startObject("prefix_field")  
        }
    }
        } else if (query instanceof FieldMaskingSpanQuery) {
    protected void doAssertLuceneQuery(SpanMultiTermQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
    }  
            + "          \"boost\" : 1.08\n"  
            SpanTermQuery termQuery = (SpanTermQuery) fieldQuery.getMaskedQuery();
import static org.hamcrest.CoreMatchers.equalTo;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return false;
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;  
        }  
    }  
        if (query instanceof SpanMultiTermQueryWrapper) {
 * GitHub history for details.
        }
            return this;
            Query query = new SpanMultiTermQueryBuilder(new PrefixQueryBuilder(fieldName, "foo")).toQuery(context);  
            if (multiQuery.getRewriteMethod() instanceof TopTermsRewrite) {
                    IndexSearcher.setMaxClauseCount(1);  
    public void testToQueryInnerTermQuery() throws IOException {
import static org.hamcrest.CoreMatchers.instanceOf;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamOutput;  
        XContentBuilder mapping = jsonBuilder().startObject()  
        String fieldName = randomFrom("prefix_field", "prefix_field_alias");  
import org.apache.lucene.document.Field;
/*  
        if (query instanceof SpanMultiTermQueryWrapper) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
    }  
            return "foo";
    }  
            assertThat(termQuery.getTerm().field(), equalTo("prefix_field._index_prefix"));  
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
                        QueryBuilder queryBuilder = new SpanMultiTermQueryBuilder(QueryBuilders.prefixQuery("body", "bar"));
                        IndexSearcher searcher = new IndexSearcher(reader);  
        List<QueryBuilder> visitorQueries = new ArrayList<>();  
            .field("path", "prefix_field")
        MultiTermQueryBuilder query = new TermMultiTermQueryBuilder();
        }  
            assertTrue(rewriteMethod instanceof SpanBooleanQueryRewriteWithMaxClause);  
 * SPDX-License-Identifier: Apache-2.0
            .startObject("prefix_field_alias")
        mapperService.merge("_doc", new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
        try (Directory directory = newDirectory()) {
        }
import static java.util.Collections.singleton;
            .endObject()
    @Override
    public void testTermExpansionExceptionOnSpanFailure() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
        MultiTermQueryBuilder multiTermQueryBuilder = new PrefixQueryBuilderTests().createTestQueryBuilder();
                for (int i = 0; i < 3; i++) {
 */
        @Override
            }  
import static org.hamcrest.CoreMatchers.containsString;  
            .endObject()
            return 1f;
            assertThat(prefixQuery.getPrefix().text(), equalTo("f"));  
            () -> spanMultiTermQuery.toQuery(createShardContext())  
            assertTrue(rewrite.isHardLimit());
    }
import org.apache.lucene.queries.spans.SpanQuery;
            .field("type", "text")
 * You may obtain a copy of the License at  
import java.util.ArrayList;
            if (queryBuilder.innerQuery().boost() != AbstractQueryBuilder.DEFAULT_BOOST) {
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
        {
import org.apache.lucene.search.BoostQuery;
 * under the License.  
    public void testIllegalArgument() {
        public String getWriteableName() {
        SpanMultiTermQueryBuilder spanMultiTermQuery = new SpanMultiTermQueryBuilder(query);  
    @Override
                }
import org.apache.lucene.document.TextField;  
        public String fieldName() {
package org.opensearch.index.query;
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "    \"boost\" : 1.0\n"
            MultiTermQuery multiQuery = (MultiTermQuery) innerQuery;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
        checkGeneratedJson(json, parsed);  
            Query innerQuery = queryBuilder.innerQuery().toQuery(context);  
                        Query query = queryBuilder.toQuery(createShardContext(searcher));
                try (IndexReader reader = iw.getReader()) {
        assertTrue(query instanceof SpanMultiTermQueryWrapper);  
            MultiTermQuery.RewriteMethod rewriteMethod = ((SpanMultiTermQueryWrapper) query).getRewriteMethod();
        UnsupportedOperationException e = expectThrows(
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {  
            assertThat(rewrite.getMaxExpansions(), equalTo(IndexSearcher.getMaxClauseCount()));  
            + "    },\n"  
            + "    \"match\" : {\n"
    }
            FieldMaskingSpanQuery fieldQuery = (FieldMaskingSpanQuery) query;
            }
        if (query instanceof SpanMultiTermQueryWrapper) {
                assertThat(wrapper.getRewriteMethod(), instanceOf(SpanMultiTermQueryWrapper.TopTermsSpanBooleanQueryRewrite.class));  
        }  
    public void testDefaultMaxRewriteBuilder() throws Exception {  
            assertThat(termQuery.getTerm().text(), equalTo("foo"));
            assertThat(fieldQuery.getField(), equalTo("prefix_field"));
 *
     */  
import org.apache.lucene.store.Directory;
            + "        }\n"
    public void testTopNMultiTermsRewriteInsideSpan() throws Exception {  
        }  
            assertThat(fieldQuery.getMaskedQuery(), instanceOf(SpanTermQuery.class));  
/*  
            + "        \"user\" : {\n"
        assertEquals(json, 1.08, parsed.innerQuery().boost(), 0.0001);  
 */  
 * this work for additional information regarding copyright
    @Override
 * specific language governing permissions and limitations
            FieldMaskingSpanQuery mask = (FieldMaskingSpanQuery) query;
            .toQuery(createShardContext());
import org.opensearch.test.AbstractQueryTestCase;
            return this;
            assertThat(prefixQuery.getField(), equalTo("prefix_field"));
 *
            .startObject("properties")
            MultiTermQuery.RewriteMethod rewriteMethod = ((SpanMultiTermQueryWrapper) query).getRewriteMethod();  
        SpanMultiTermQueryBuilder spanMultiTermQueryBuilder = new SpanMultiTermQueryBuilder(multiTermQueryBuilder);
                }  
        public void writeTo(StreamOutput out) throws IOException {
 * not use this file except in compliance with the License.
 *  
            return "foo";  
        @Override  
}
                assertThat(wrapper.getRewriteMethod(), instanceOf(SpanBooleanQueryRewriteWithMaxClause.class));
            .endObject()
     * test checks that we throw an {@link UnsupportedOperationException} if the query wrapped
    private static class TermMultiTermQueryBuilder implements MultiTermQueryBuilder {
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.CoreMatchers.startsWith;
        public QueryBuilder queryName(String queryName) {  
 */  
                        RuntimeException exc = expectThrows(RuntimeException.class, () -> query.rewrite(searcher));
            + "  }\n"
            PrefixQuery prefixQuery = (PrefixQuery) wrapper.getWrappedQuery();
    @Override
            SpanMultiTermQueryWrapper wrapper = (SpanMultiTermQueryWrapper) query;
/*
            assertThat(wrapper.getField(), equalTo("prefix_field"));  
