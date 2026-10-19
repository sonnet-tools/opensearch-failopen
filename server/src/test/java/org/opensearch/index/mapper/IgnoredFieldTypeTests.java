    public void testRegexpQuery() {
 * Unless required by applicable law or agreed to in writing,
/*  
import org.apache.lucene.search.WildcardQuery;  
import org.apache.lucene.search.RegexpQuery;
 */
import org.apache.lucene.index.Term;
        MappedFieldType ft = IgnoredFieldMapper.IgnoredFieldType.INSTANCE;
            RegexpQuery.DEFAULT_PROVIDER,
            MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE
            ee.getMessage()  
        Query expected = new WildcardQuery(new Term("_ignored", new BytesRef("foo*")));  
    }
import org.apache.lucene.util.automaton.Operations;
package org.opensearch.index.mapper;
        OpenSearchException ee = expectThrows(
            OpenSearchException.class,
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        OpenSearchException ee = expectThrows(OpenSearchException.class, () -> ft.prefixQuery("foo*", null, MOCK_QSC_DISALLOW_EXPENSIVE));
/*  
        MappedFieldType ft = IgnoredFieldMapper.IgnoredFieldType.INSTANCE;
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.util.BytesRef;
            () -> ft.regexpQuery("foo?", randomInt(10), 0, randomInt(10) + 1, null, MOCK_QSC_DISALLOW_EXPENSIVE)
 * specific language governing permissions and limitations
        assertEquals(expected, ft.wildcardQuery("foo*", MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC));
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals("[regexp] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());  
                + "For optimised prefix queries on text fields please enable [index_prefixes].",
        MappedFieldType ft = IgnoredFieldMapper.IgnoredFieldType.INSTANCE;  
            OpenSearchException.class,  
            RegExp.ALL,  
            0,
    public void testWildcardQuery() {  
        assertEquals(expected, ft.regexpQuery("foo?", 0, 0, 10, null, MOCK_QSC));  
            new Term("_ignored", new BytesRef("foo?")),
            () -> ft.wildcardQuery("valu*", null, MOCK_QSC_DISALLOW_EXPENSIVE)
        );  
 * Licensed to Elasticsearch under one or more contributor  
            "[prefix] queries cannot be executed when 'search.allow_expensive_queries' is set to false. "
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
import org.apache.lucene.util.automaton.RegExp;  
 */  
        Query expected = new PrefixQuery(new Term("_ignored", new BytesRef("foo*")), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE);
        assertEquals(  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        );
import org.opensearch.OpenSearchException;
}  
    }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.PrefixQuery;  
 *
        );
 * KIND, either express or implied.  See the License for the
 */  
 *  
 *
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
            Operations.DEFAULT_DETERMINIZE_WORK_LIMIT,  
        );
    }
        OpenSearchException ee = expectThrows(  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
        assertEquals("[wildcard] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", ee.getMessage());
        Query expected = new RegexpQuery(
import org.apache.lucene.search.MultiTermQuery;
public class IgnoredFieldTypeTests extends FieldTypeTestCase {  
 * You may obtain a copy of the License at  
import org.apache.lucene.search.Query;
/*
    public void testPrefixQuery() {
        assertEquals(expected, ft.prefixQuery("foo*", null, MOCK_QSC));  
