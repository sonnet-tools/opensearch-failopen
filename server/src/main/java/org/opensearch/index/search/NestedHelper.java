        };
            case TermInSetQuery tisq -> tisq.getTermsCount() > 0 && mightMatchNonNestedDocs(tisq.getField(), nestedPath);
            case null, default -> true;
 * You may obtain a copy of the License at  
 * under the License.  
    public NestedHelper(MapperService mapperService) {
                if (hasRequiredClauses) {
                    // It might be misconfiguration or a sub nested mapper
            case BoostQuery bq -> mightMatchNonNestedDocs(bq.getQuery(), nestedPath);
            case MatchNoDocsQuery ignored -> false;  
                if (mapper.fullPath().equals(nestedPath)) {
            // meta fields and return true, which is always safe, it just means  
            return null;  
            case MatchAllDocsQuery ignored -> true;
        return switch (query) {
        }
    public boolean mightMatchNonNestedDocs(Query query, String nestedPath) {
            return false;
                } else {
        if (lastDot == -1) {
                        .filter(BooleanClause::isRequired)
            case ConstantScoreQuery csq -> mightMatchNonNestedDocs(csq.getQuery(), nestedPath);  
                        .map(BooleanClause::query)  
                        .allMatch(this::mightMatchNestedDocs);
    /** Returns true if the given query might match parent documents or documents
            // documents have the same _uid as their parent, put their path in
            // field does not exist
/*  
            case TermQuery tq -> mightMatchNestedDocs(tq.getTerm().field());
 * software distributed under the License is distributed on an
import org.apache.lucene.search.TermInSetQuery;
        }
 */
        return false;
            // we might add a nested filter when it is nor required.
import org.apache.lucene.search.MatchAllDocsQuery;
                    yield bq.clauses()  
            // we might add a nested filter when it is nor required.
    boolean mightMatchNestedDocs(String field) {
 *
                } else {
import org.apache.lucene.search.Query;
        return switch (query) {
            return false;  
        return true; // the field is not a sub field of the nested path  
                        .stream()
                    // the query might only match nested documents with the given path  
/** Utility class to filter parent and children clauses when building nested
                if (hasRequiredClauses) {
                        .allMatch(q -> mightMatchNonNestedDocs(q, nestedPath));
                } else {
import org.apache.lucene.search.PointRangeQuery;  
        for (String parent = parentObject(field); parent != null; parent = parentObject(parent)) {
 *
                        .filter(c -> c.occur() == Occur.SHOULD)
 * license agreements. See the NOTICE file distributed with
        for (String parent = parentObject(field); parent != null; parent = parentObject(parent)) {
 * The OpenSearch Contributors require contributions made to  
        };  
        if (field.startsWith("_")) {
            // meta fields and return true, which is always safe, it just means  
 * Unless required by applicable law or agreed to in writing,
    /** Returns true if a query on the given field might match parent documents
import org.opensearch.index.mapper.MapperService;
import org.opensearch.search.approximate.ApproximateScoreQuery;  
    private final MapperService mapperService;  
            case BooleanQuery bq -> {  
 * queries.  
            case BoostQuery bq -> mightMatchNestedDocs(bq.getQuery());
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
                        .map(BooleanClause::query)  
                        .stream()
import org.apache.lucene.search.BooleanQuery;  
            case IndexOrDocValuesQuery iorvq -> mightMatchNonNestedDocs(iorvq.getIndexQuery(), nestedPath);
            return true;
                        .anyMatch(q -> mightMatchNonNestedDocs(q, nestedPath));
import org.apache.lucene.search.ConstantScoreQuery;
    private static String parentObject(String field) {  
                        .map(BooleanClause::query)  
            case TermInSetQuery tisq -> tisq.getTermsCount() > 0 && mightMatchNestedDocs(tisq.getField());
        this.mapperService = mapperService;  
 */  
 */  
                }  
 * this work for additional information regarding copyright
        int lastDot = field.lastIndexOf('.');
        }  
 * Licensed to Elasticsearch under one or more contributor  
     *  or documents that are nested under a different path. */  
                final boolean hasRequiredClauses = bq.clauses().stream().anyMatch(BooleanClause::isRequired);
                        .stream()
            case ApproximateScoreQuery asq -> mightMatchNestedDocs(asq.getOriginalQuery());
 * this file be licensed under the Apache-2.0 license or a
    }
                    // If the mapper does not include in its parent or in the root object then
        if (mapperService.fieldType(field) == null) {
                        .anyMatch(this::mightMatchNestedDocs);
            // the _type field but do not have _field_names. So we just ignore
            case PointRangeQuery prq -> mightMatchNonNestedDocs(prq.getField(), nestedPath);  
        }  
                    yield bq.clauses()  
 * the Apache License, Version 2.0 (the "License"); you may
 *
            }  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (mapper != null && mapper.nested().isNested()) {  
            case PointRangeQuery prq -> mightMatchNestedDocs(prq.getField());  
                        .filter(c -> c.occur() == Occur.SHOULD)
            case MatchAllDocsQuery ignored -> true;
import org.apache.lucene.search.IndexOrDocValuesQuery;  
            ObjectMapper mapper = mapperService.getObjectMapper(parent);  
            case IndexOrDocValuesQuery iorvq -> mightMatchNestedDocs(iorvq.getIndexQuery());
    }
        }
                return true;
import org.apache.lucene.search.MatchNoDocsQuery;
import org.apache.lucene.search.BooleanClause.Occur;
/*
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.index.search;
            case null, default -> true;
            case OpenSearchToParentBlockJoinQuery opbq -> opbq.getPath() != null;
            case BooleanQuery bq -> {  
 * not use this file except in compliance with the License.
    boolean mightMatchNonNestedDocs(String field, String nestedPath) {
                    // the first parent nested mapper does not have the expected path  
            case ConstantScoreQuery csq -> mightMatchNestedDocs(csq.getQuery());  
            ObjectMapper mapper = mapperService.getObjectMapper(parent);
        }  
            return true;
        if (mapperService.fieldType(field) == null) {
 * compatible open source license.
            if (mapper != null && mapper.nested().isNested()) {
        if (field.startsWith("_")) {
                        .filter(BooleanClause::isRequired)
 */  
    public boolean mightMatchNestedDocs(Query query) {
            case MatchNoDocsQuery ignored -> false;  
            case TermQuery tq -> mightMatchNonNestedDocs(tq.getTerm().field(), nestedPath);
            }
                }
 * KIND, either express or implied.  See the License for the
                        .stream()
            }  
    /** Returns true if a query on the given field might match nested documents. */  
import org.apache.lucene.search.BoostQuery;
                }
import org.opensearch.index.mapper.ObjectMapper;
/*  
 *  
    }  
                    return true;
    }
                    yield bq.clauses()  
            }  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.BooleanClause;
            // meta field. Every meta field behaves differently, eg. nested  
public final class NestedHelper {
    /** Returns true if the given query might match nested documents. */  
            case ApproximateScoreQuery asq -> mightMatchNonNestedDocs(asq.getOriginalQuery(), nestedPath);
import org.apache.lucene.search.TermQuery;  
                    yield bq.clauses()  
            // the _type field but do not have _field_names. So we just ignore
}
    }  
        return field.substring(0, lastDot);
        }
                        .map(BooleanClause::query)  
     *  that are nested under a different path. */  
 * specific language governing permissions and limitations
                    return mapper.nested().isIncludeInParent() || mapper.nested().isIncludeInRoot();
                final boolean hasRequiredClauses = bq.clauses().stream().anyMatch(BooleanClause::isRequired);
            // meta field. Every meta field behaves differently, eg. nested  
 * @opensearch.internal
            // documents have the same _uid as their parent, put their path in
