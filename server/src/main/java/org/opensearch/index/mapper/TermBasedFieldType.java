import org.apache.lucene.search.Query;
        }
            query = new BoostQuery(query, boost());
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
import org.apache.lucene.search.TermQuery;  
 * GitHub history for details.
    }  
        failIfNotIndexed();  
        boolean hasDocValues,
    }  
    @Override
/*
        failIfNotIndexed();
 * The OpenSearch Contributors require contributions made to  
        return query;
    public Query termsQuery(List<?> values, QueryShardContext context) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        }
        Map<String, String> meta
 * compatible open source license.
 */
 * Unless required by applicable law or agreed to in writing,
            BytesRef elem = indexedValueForSearch(values.get(i));
    }
            query = new BoostQuery(query, boost());  
        if (boost() != 1f) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        failIfNotIndexed();
        Query query = AutomatonQueries.caseInsensitiveTermQuery(new Term(name(), indexedValueForSearch(value)));
    public Query termQuery(Object value, QueryShardContext context) {  
import org.apache.lucene.search.BoostQuery;
 * @opensearch.internal  
    ) {
import org.apache.lucene.util.BytesRef;
 * specific language governing permissions and limitations
import org.opensearch.common.lucene.search.AutomatonQueries;  
    /** Returns the indexed value used to construct search "values".  
        }
    public TermBasedFieldType(
import java.util.Map;
        for (int i = 0; i < values.size(); i++) {
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
     *  This method is used for the default implementations of most
        String name,
    }
 * this work for additional information regarding copyright
import org.opensearch.index.query.QueryShardContext;
        if (boost() != 1f) {  
/*  
import org.apache.lucene.search.MultiTermQuery;  
     *  query factory methods such as {@link #termQuery}. */
 */  
 *  
import java.util.List;  
            bytesCollector.accept(elem);  
 * not use this file except in compliance with the License.
import org.apache.lucene.search.TermInSetQuery;
        return query;  
        super(name, isSearchable, isStored, hasDocValues, textSearchInfo, meta);  
 * KIND, either express or implied.  See the License for the
 */
 *
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
/** Base {@link MappedFieldType} implementation for a field that is indexed  
 * the Apache License, Version 2.0 (the "License"); you may
        return BytesRefs.toBytesRef(value);
 *
    @Override  
import org.apache.lucene.index.Term;
    @Override
}
 * SPDX-License-Identifier: Apache-2.0
/*  
    }
 * Licensed to Elasticsearch under one or more contributor  
        BytesRefsCollectionBuilder bytesCollector = new BytesRefsCollectionBuilder(values.size());  
        Query query = new TermQuery(new Term(name(), indexedValueForSearch(value)));
 *
        boolean isSearchable,  
        boolean isStored,
public abstract class TermBasedFieldType extends SimpleMappedFieldType {
        TextSearchInfo textSearchInfo,  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.lucene.BytesRefs;
        return new TermInSetQuery(MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, name(), bytesCollector.get());
    public Query termQueryCaseInsensitive(Object value, QueryShardContext context) {
package org.opensearch.index.mapper;
 *  with the inverted index.
    protected BytesRef indexedValueForSearch(Object value) {  
