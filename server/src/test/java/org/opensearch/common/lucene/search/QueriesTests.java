            new BooleanQuery.Builder().add(new MatchAllDocsQuery(), Occur.FILTER)
    public void testIsNegativeQuery() {
import org.opensearch.test.VersionUtils;
        );
    }  
import org.apache.lucene.index.Term;
 *     http://www.apache.org/licenses/LICENSE-2.0
                .build(),  
 * ownership. Elasticsearch licenses this file to you under  
                .add(new TermQuery(new Term("foo", "bar")), Occur.MUST_NOT)
    public void testFixNegativeQuery() {
/*  
import org.apache.lucene.search.BooleanClause.Occur;
 * compatible open source license.
        assertFalse(Queries.isNegativeQuery(new MatchAllDocsQuery()));  
            assertEquals(Queries.newNonNestedFilter().hashCode(), Queries.newNonNestedFilter().hashCode());  
 *  
        );
import org.opensearch.test.OpenSearchTestCase;  
 * KIND, either express or implied.  See the License for the
 */  
 */
import org.apache.lucene.search.FieldExistsQuery;
package org.opensearch.common.lucene.search;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.SeqNoFieldMapper;
    }  
}
 *
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
            assertEquals(Queries.newNonNestedFilter(), Queries.newNonNestedFilter());
            assertEquals(Queries.newNonNestedFilter(), new FieldExistsQuery(SeqNoFieldMapper.PRIMARY_TERM_NAME));
 */  
/*  
            )
    public void testNonNestedQuery() {
public class QueriesTests extends OpenSearchTestCase {  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(  
        assertFalse(
        }
                new BooleanQuery.Builder().add(new MatchAllDocsQuery(), Occur.MUST).add(new MatchAllDocsQuery(), Occur.MUST_NOT).build()  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
            Queries.isNegativeQuery(
import org.apache.lucene.search.BooleanQuery;  
 * Licensed to Elasticsearch under one or more contributor  
            Queries.fixNegativeQueryIfNeeded(new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST_NOT).build())
 * this work for additional information regarding copyright
 * under the License.  
/*
 * the Apache License, Version 2.0 (the "License"); you may
            // This is a custom query that extends AutomatonQuery and want to make sure the equals method works
    }  
import org.apache.lucene.search.TermQuery;  
import org.apache.lucene.search.MatchAllDocsQuery;
 * Unless required by applicable law or agreed to in writing,
        assertTrue(Queries.isNegativeQuery(new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST_NOT).build()));  
        assertFalse(Queries.isNegativeQuery(new BooleanQuery.Builder().build()));
 * Modifications Copyright OpenSearch Contributors. See
        for (Version version : VersionUtils.allVersions()) {  
 *
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
        assertFalse(Queries.isNegativeQuery(new BooleanQuery.Builder().add(new TermQuery(new Term("foo", "bar")), Occur.MUST).build()));
import org.opensearch.Version;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
