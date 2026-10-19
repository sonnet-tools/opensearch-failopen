 * You may obtain a copy of the License at  
import org.opensearch.search.approximate.ApproximateScoreQuery;
import static org.hamcrest.CoreMatchers.instanceOf;  
    @Override
 * license agreements. See the NOTICE file distributed with
 */
        assertThat(query, instanceOf(ApproximateScoreQuery.class));
 * KIND, either express or implied.  See the License for the
            {
import org.apache.lucene.search.MatchAllDocsQuery;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
import org.opensearch.test.AbstractQueryTestCase;
import org.opensearch.search.approximate.ApproximateMatchAllQuery;  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
    protected MatchAllQueryBuilder doCreateTestQueryBuilder() {
        checkGeneratedJson(json, parsed);
import org.apache.lucene.search.Query;
 * ownership. Elasticsearch licenses this file to you under  
 */  
              "match_all" : {
    @Override  
package org.opensearch.index.query;
    }  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
public class MatchAllQueryBuilderTests extends AbstractQueryTestCase<MatchAllQueryBuilder> {
              }
 * SPDX-License-Identifier: Apache-2.0
        ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) query;  
/*
        MatchAllQueryBuilder parsed = (MatchAllQueryBuilder) parseQuery(json);  
/*  
 * software distributed under the License is distributed on an
        assertEquals(json, 1.2, parsed.boost(), 0.0001);
}
    protected void doAssertLuceneQuery(MatchAllQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            }""";
 * Unless required by applicable law or agreed to in writing,
        return new MatchAllQueryBuilder();  
        assertThat(approxQuery.getOriginalQuery(), instanceOf(MatchAllDocsQuery.class));
 *
 * this file be licensed under the Apache-2.0 license or a
        String json = """  
/*  
 * Licensed to Elasticsearch under one or more contributor  
    public void testFromJson() throws IOException {
 *
    }
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * not use this file except in compliance with the License.
    }  
 * compatible open source license.
import java.io.IOException;
 * this work for additional information regarding copyright
                "boost" : 1.2  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(approxQuery.getApproximationQuery(), instanceOf(ApproximateMatchAllQuery.class));
