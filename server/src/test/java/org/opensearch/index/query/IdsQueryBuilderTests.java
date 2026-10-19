}  
                "values" : [ 1, 100, 4 ],
        if (queryBuilder.ids().size() == 0) {
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
    }  
    protected void doAssertLuceneQuery(IdsQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
public class IdsQueryBuilderTests extends AbstractQueryTestCase<IdsQueryBuilder> {
            assertThat(query, instanceOf(TermInSetQuery.class));
 * specific language governing permissions and limitations
 */  
        IdsQueryBuilder queryBuilder = createTestQueryBuilder();
              "ids" : {  
              }  
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.CoreMatchers.instanceOf;
 * KIND, either express or implied.  See the License for the
              "ids" : {  
            }""";
import static org.hamcrest.Matchers.contains;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> idsQueryBuilder.addIds((String[]) null));
    @Override
 */
 * You may obtain a copy of the License at  
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(query));
            }""";
    }
 *
        checkGeneratedJson(json, parsed);  
 *
                "values" : [ "1", "100", "4" ],
import org.apache.lucene.search.Query;
 * ownership. Elasticsearch licenses this file to you under  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> queryBuilder.toQuery(context));  
        QueryBuilder query = super.parseQuery(parser);
    // see #7686.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
    public void testIllegalArguments() {
    }  
    protected QueryBuilder parseQuery(XContentParser parser) throws IOException {
import org.apache.lucene.search.MatchNoDocsQuery;
        assertThat(query, instanceOf(IdsQueryBuilder.class));  
 * under the License.  
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
 *  
import static org.hamcrest.Matchers.containsString;  
        assertThat(parsed.ids(), contains("1", "100", "4"));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String[] ids = new String[numberOfIds];
 * this work for additional information regarding copyright
package org.opensearch.index.query;
 * the Apache License, Version 2.0 (the "License"); you may
/*
              }  
    protected IdsQueryBuilder doCreateTestQueryBuilder() {
/*  
 * GitHub history for details.
    @Override
        QueryShardContext context = createShardContextWithNoType();  
            {
    @Override
                "boost" : 1.0
        }
    public void testFromJson() throws IOException {  
 * not use this file except in compliance with the License.
    public void testIdsQueryWithInvalidValues() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
        // check that type that is not an array and also ids that are numbers are parsed  
import org.opensearch.test.AbstractQueryTestCase;  
        IdsQueryBuilder parsed = (IdsQueryBuilder) parseQuery(json);
        context.setAllowUnmappedFields(true);
    }
    }
                "boost" : 1.0
 */  
        IdsQueryBuilder idsQueryBuilder = new IdsQueryBuilder();  
import org.opensearch.core.xcontent.XContentParser;
    @Override  
        return new IdsQueryBuilder().addIds(ids);
        json = """
/*  
        for (int i = 0; i < numberOfIds; i++) {
import org.opensearch.core.common.ParsingException;
 * this file be licensed under the Apache-2.0 license or a
            {
        assertEquals("Rewrite first", e.getMessage());
    }
        parsed = (IdsQueryBuilder) parseQuery(json);
        }
        assertEquals("[ids] ids cannot be null", e.getMessage());
    public void testMustRewrite() throws IOException {
        return query;
        int numberOfIds = randomIntBetween(0, 10);  
            ids[i] = randomAlphaOfLengthBetween(1, 10);  
import org.apache.lucene.search.TermInSetQuery;  
        } else {  
        String json = """
        assertThat(parsed.ids(), contains("1", "100", "4"));
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    }  
        assertThat(e.getMessage(), containsString("[ids] failed to parse field [values]"));  
        String query = "{ \"ids\": { \"values\": [[1]] } }";
