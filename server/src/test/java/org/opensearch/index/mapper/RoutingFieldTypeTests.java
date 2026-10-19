        );
 * The OpenSearch Contributors require contributions made to  
        assertEquals(expected, ft.prefixQuery("foo*", MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC));  
import org.apache.lucene.search.Query;  
 * software distributed under the License is distributed on an
            () -> ft.regexpQuery("foo?", randomInt(10), 0, randomInt(10) + 1, null, MOCK_QSC_DISALLOW_EXPENSIVE)  
        assertEquals(  
    }
                + "For optimised prefix queries on text fields please enable [index_prefixes].",
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See  
 *  
            () -> ft.wildcardQuery("valu*", null, MOCK_QSC_DISALLOW_EXPENSIVE)
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.PrefixQuery;
 * compatible open source license.
import org.apache.lucene.search.WildcardQuery;
 * Licensed to Elasticsearch under one or more contributor  
        );
}
        assertEquals("[wildcard] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());  
 */
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.util.BytesRef;  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 */  
            OpenSearchException.class,  
    public void testWildcardQuery() {
        assertEquals(expected, ft.wildcardQuery("foo*", MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC));  
 * GitHub history for details.
    }  
        assertEquals("[regexp] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            "[prefix] queries cannot be executed when 'search.allow_expensive_queries' is set to false. "
 * ownership. Elasticsearch licenses this file to you under  
        Query expected = new PrefixQuery(new Term("_routing", new BytesRef("foo*")));
        OpenSearchException ee = expectThrows(OpenSearchException.class, () -> ft.prefixQuery("foo*", null, MOCK_QSC_DISALLOW_EXPENSIVE));
            ee.getMessage()  
    }
 * this work for additional information regarding copyright
/*
        MappedFieldType ft = RoutingFieldMapper.RoutingFieldType.INSTANCE;  
            OpenSearchException.class,
        MappedFieldType ft = RoutingFieldMapper.RoutingFieldType.INSTANCE;  
 */
        OpenSearchException ee = expectThrows(
        Query expected = new RegexpQuery(new Term("_routing", new BytesRef("foo?")));
 * Unless required by applicable law or agreed to in writing,
/*
import org.opensearch.OpenSearchException;
import org.apache.lucene.index.Term;  
        assertEquals(expected, ft.regexpQuery("foo?", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC));
package org.opensearch.index.mapper;
/*  
 * specific language governing permissions and limitations
        MappedFieldType ft = RoutingFieldMapper.RoutingFieldType.INSTANCE;
        Query expected = new WildcardQuery(new Term("_routing", new BytesRef("foo*")));
 * KIND, either express or implied.  See the License for the
    public void testRegexpQuery() {
 * not use this file except in compliance with the License.
import org.apache.lucene.search.RegexpQuery;
    public void testPrefixQuery() {
public class RoutingFieldTypeTests extends FieldTypeTestCase {  
 *
import org.apache.lucene.search.MultiTermQuery;
 * license agreements. See the NOTICE file distributed with
        OpenSearchException ee = expectThrows(
