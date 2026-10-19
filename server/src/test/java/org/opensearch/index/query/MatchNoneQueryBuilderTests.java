 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
        return new MatchNoneQueryBuilder();
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
import org.apache.lucene.search.Query;
            }""";  
              "match_none" : {  
    }
public class MatchNoneQueryBuilderTests extends AbstractQueryTestCase<MatchNoneQueryBuilder> {  
/*  
    @Override
import static org.hamcrest.CoreMatchers.instanceOf;
 *  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 */
 * under the License.  
              }
}
    public void testFromJson() throws IOException {  
    }
        assertEquals(json, 1.2, parsed.boost(), 0.0001);  
    protected MatchNoneQueryBuilder doCreateTestQueryBuilder() {  
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
package org.opensearch.index.query;
 */  
import org.opensearch.test.AbstractQueryTestCase;  
 *
 *
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
    }
import java.io.IOException;
            {
 */  
 * GitHub history for details.
        MatchNoneQueryBuilder parsed = (MatchNoneQueryBuilder) parseQuery(json);
 * ownership. Elasticsearch licenses this file to you under  
                "boost" : 1.2
        String json = """
 * compatible open source license.
/*
 * this work for additional information regarding copyright
    protected void doAssertLuceneQuery(MatchNoneQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        checkGeneratedJson(json, parsed);
        assertThat(query, instanceOf(MatchNoDocsQuery.class));  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.MatchNoDocsQuery;
 * this file be licensed under the Apache-2.0 license or a
