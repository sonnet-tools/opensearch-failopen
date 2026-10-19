        checkGeneratedJson(query, queryBuilder);  
    public void testRewrite() throws IOException {
 * Unless required by applicable law or agreed to in writing,
        QueryBuilder rewrite = qb.rewrite(createShardContext());  
/*  
 *  
 *
        query.negativeBoost(2.0f / randomIntBetween(1, 20));  
            + "        \"field2\" : {\n"  
            RandomQueryBuilder.createQuery(random()),  
        BoostingQueryBuilder query = new BoostingQueryBuilder(
 * Modifications Copyright OpenSearch Contributors. See
            ? new MatchAllQueryBuilder()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
            new TermQueryBuilder("unmapped_field", "value"),
            new MatchNoneQueryBuilder()
            : new WrapperQueryBuilder(new TermQueryBuilder(KEYWORD_FIELD_NAME, "bar").toString());
package org.opensearch.index.query;
        if (positive instanceof MatchAllQueryBuilder && negative instanceof MatchAllQueryBuilder) {
import org.opensearch.test.AbstractQueryTestCase;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
            + "        }\n"  
        Query negative = queryBuilder.negativeQuery().rewrite(context).toQuery(context);
 * GitHub history for details.
        }  
/*  
        builder.visit(createTestVisitor(visitedQueries));  
            new TermQueryBuilder("unmapped_field", "foo"),  
        QueryBuilder negative = randomBoolean()
import org.apache.lucene.search.MatchNoDocsQuery;
import java.util.List;
 * this work for additional information regarding copyright
        return query;
            new TermQueryBuilder(KEYWORD_FIELD_NAME, "other_value")
        } else {  
        assertEquals(query, 5, queryBuilder.positiveQuery().boost(), 0.00001);
        assertThat(rewrite, instanceOf(MatchNoneQueryBuilder.class));  
 * You may obtain a copy of the License at  
        assertEquals(query, 8, queryBuilder.negativeQuery().boost(), 0.00001);  
            assertThat(query, nullValue());  
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
/*
 * SPDX-License-Identifier: Apache-2.0
        );  
    public void testRewriteToMatchNone() throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
            + "    \"positive\" : {\n"
import java.util.ArrayList;
        assertEquals("Rewrite first", e.getMessage());
        Query positive = queryBuilder.positiveQuery().rewrite(context).toQuery(context);  
        String query = "{\n"  
            + "    },\n"  
            + "        \"field1\" : {\n"
public class BoostingQueryBuilderTests extends AbstractQueryTestCase<BoostingQueryBuilder> {
 * compatible open source license.
        BoostingQueryBuilder builder = new BoostingQueryBuilder(  
    public void testVisit() {
 * under the License.  
 * software distributed under the License is distributed on an
            + "    \"boost\" : 42.0\n"
import org.apache.lucene.queries.function.FunctionScoreQuery;
 */
import java.io.IOException;  
            new TermQueryBuilder("unmapped_field", "foo")
            assertNotSame(rewrite, qb);
            + "    \"negative_boost\" : 23.0,\n"  
        expectThrows(IllegalArgumentException.class, () -> new BoostingQueryBuilder(null, new MatchAllQueryBuilder()));  
        assertEquals("Rewrite first", e.getMessage());
        BoostingQueryBuilder builder = new BoostingQueryBuilder(
            + "      }\n"
        expectThrows(
            RandomQueryBuilder.createQuery(random())
        QueryShardContext context = createShardContext();
    protected BoostingQueryBuilder doCreateTestQueryBuilder() {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> queryBuilder1.toQuery(context));  
            new TermQueryBuilder(KEYWORD_FIELD_NAME, "other_value")  
        BoostingQueryBuilder qb = new BoostingQueryBuilder(positive, negative);
 * the Apache License, Version 2.0 (the "License"); you may
        } else {  
import static org.hamcrest.CoreMatchers.nullValue;
            new MatchAllQueryBuilder(),
    }
    public void testMustRewrite() throws IOException {
        e = expectThrows(IllegalStateException.class, () -> queryBuilder2.toQuery(context));
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(new BoostingQueryBuilder(positive.rewrite(createShardContext()), negative.rewrite(createShardContext())), rewrite);
            + "      \"term\" : {\n"  
    public void testFromJson() throws IOException {
        } else if (positive instanceof MatchNoDocsQuery) {
        BoostingQueryBuilder queryBuilder2 = new BoostingQueryBuilder(  
            assertSame(rewrite, qb);
import static org.hamcrest.CoreMatchers.instanceOf;
            + "      }\n"
        );
        BoostingQueryBuilder queryBuilder1 = new BoostingQueryBuilder(
            + "    },\n"
        assertEquals(3, visitedQueries.size());
            new TermQueryBuilder("unmapped_field", "value"),
        }
            + "          \"value\" : \"value1\",\n"
 * not use this file except in compliance with the License.
 *
 * this file be licensed under the Apache-2.0 license or a
            assertThat(query, instanceOf(FunctionScoreQuery.class));
            + "      \"term\" : {\n"
            : new WrapperQueryBuilder(new TermQueryBuilder(TEXT_FIELD_NAME, "bar").toString());
    }
            + "  \"boosting\" : {\n"
    protected void doAssertLuceneQuery(BoostingQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        );
        context.setAllowUnmappedFields(true);  
            + "        }\n"
 */  
}
    @Override  
        expectThrows(IllegalArgumentException.class, () -> new BoostingQueryBuilder(new MatchAllQueryBuilder(), null));
        );
 */  
            () -> new BoostingQueryBuilder(new MatchAllQueryBuilder(), new MatchAllQueryBuilder()).negativeBoost(-1.0f)
    }  
        );  
        QueryBuilder rewrite = builder.rewrite(createShardContext());
            + "}";  
        assertEquals(query, 23, queryBuilder.negativeBoost(), 0.00001);
            + "    \"negative\" : {\n"
            IllegalArgumentException.class,  
    }  
        );
        QueryBuilder positive = randomBoolean()
    }
    @Override
 * license agreements. See the NOTICE file distributed with
        BoostingQueryBuilder queryBuilder = (BoostingQueryBuilder) parseQuery(query);
            + "  }\n"
        if (positive == null || negative == null) {
        List<QueryBuilder> visitedQueries = new ArrayList<>();
            + "          \"value\" : \"value2\",\n"
 * Licensed to Elasticsearch under one or more contributor  
            + "          \"boost\" : 5.0\n"  
import org.apache.lucene.search.Query;  
    @Override  
            + "          \"boost\" : 8.0\n"
    }
        assertEquals(query, 42, queryBuilder.boost(), 0.00001);
    }  
    public void testIllegalArguments() {
            ? new MatchAllQueryBuilder()  
    }  
