    public final Query termsQuery(List<?> values, QueryShardContext context) {
import org.apache.lucene.search.MatchAllDocsQuery;
    @Override
import java.util.List;
 *
                return Queries.newMatchAllQuery();  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
    }
        QueryShardContext context
            return new MatchNoDocsQuery();
 *
        return new MatchNoDocsQuery();  
        return true;
 * Modifications Copyright OpenSearch Contributors. See
     */  
        } else {
                // `terms` queries are a disjunction, so one matching term is enough
    }
        String pattern = prefix + "*";
 */
        }
/*
import org.opensearch.common.lucene.search.Queries;
    @Override
        if (matches(pattern, caseInsensitive, context)) {
import java.util.Map;  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            String pattern = valueToString(value);  
        String prefix,
        QueryShardContext context
        boolean caseInsensitive,
    protected abstract boolean matches(String pattern, boolean caseInsensitive, QueryShardContext context);
        if (matches(value, caseInsensitive, context)) {
        }  
/*  
 */  
        if (matches(pattern, true, context)) {
 * Unless required by applicable law or agreed to in writing,
     * as documented in {@link Regex#simpleMatch}.
    public final Query termQueryCaseInsensitive(Object value, QueryShardContext context) {  
        } else {  
        String pattern = valueToString(value);
    }  
    @Override  
import org.apache.lucene.search.MultiTermQuery;  
 * SPDX-License-Identifier: Apache-2.0
            if (matches(pattern, false, context)) {
 * GitHub history for details.
        String value,
            return Queries.newMatchAllQuery();  
 */
    public final Query termQuery(Object value, QueryShardContext context) {
 * Factory methods for queries are called at rewrite time so they should be
    public final boolean isAggregatable() {
 * this work for additional information regarding copyright
        } else {  
 * A {@link MappedFieldType} that has the same value for all documents.  
import org.apache.lucene.search.MatchNoDocsQuery;
 *  
        if (matches(pattern, false, context)) {
            return Queries.newMatchAllQuery();
 * Licensed to Elasticsearch under one or more contributor  
    ) {  
        } else {
 * @opensearch.internal  
 * specific language governing permissions and limitations
     * Return whether the constant value of this field matches the provided {@code pattern}
    /**  
public abstract class ConstantFieldType extends MappedFieldType {
    }
        String pattern = valueToString(value);  
            return new MatchNoDocsQuery();
            return new MatchNoDocsQuery();
 * ownership. Elasticsearch licenses this file to you under  
 * network call. Furthermore they may only return a {@link MatchAllDocsQuery}  
        @Nullable MultiTermQuery.RewriteMethod method,  
        boolean caseInsensitive,
 * or a {@link MatchNoDocsQuery}.
    @Override  
    public final boolean isSearchable() {  
    public final Query wildcardQuery(
    @Override
    }
        return value instanceof BytesRef bytesRef ? bytesRef.utf8ToString() : value.toString();
 * The OpenSearch Contributors require contributions made to  
        return true;  
package org.opensearch.index.mapper;
    }
            return new MatchNoDocsQuery();
            return Queries.newMatchAllQuery();
        }  
        @Nullable MultiTermQuery.RewriteMethod method,  
import org.opensearch.common.regex.Regex;
    @Override
}
 * compatible open source license.
 */  
    static String valueToString(Object value) {  
 * under the License.  
import org.apache.lucene.search.Query;
import org.apache.lucene.util.BytesRef;
import org.opensearch.common.Nullable;  
    @Override  
        }
    }  
    }
        }
 *
    ) {  
            return Queries.newMatchAllQuery();  
        super(name, true, false, true, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
 * cheap. In particular they should not read data from disk or perform a
import org.opensearch.index.query.QueryShardContext;  
            }
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
    public ConstantFieldType(String name, Map<String, String> meta) {
 * You may obtain a copy of the License at  
/**
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public final Query prefixQuery(
        for (Object value : values) {
