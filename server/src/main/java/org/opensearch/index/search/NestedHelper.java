 *
            // meta fields and return true, which is always safe, it just means
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.TermInSetQuery;
            ObjectMapper mapper = mapperService.getObjectMapper(parent);
                }
            case IndexOrDocValuesQuery iorvq -> mightMatchNonNestedDocs(iorvq.getIndexQuery(), nestedPath);
                return true;
 */
            case TermQuery tq -> mightMatchNestedDocs(tq.getTerm().field());
 * not use this file except in compliance with the License.
    boolean mightMatchNonNestedDocs(String field, String nestedPath) {
                        .filter(c -> c.occur() == Occur.SHOULD)
        return switch (query) {
                        .stream()
            case BoostQuery bq -> mightMatchNonNestedDocs(bq.getQuery(), nestedPath);
        return switch (query) {
        };
                        .allMatch(this::mightMatchNestedDocs);
    }
            case MatchNoDocsQuery ignored -> false;
            case MatchAllDocsQuery ignored -> true;
                        .stream()
import org.apache.lucene.search.ConstantScoreQuery;
 * ownership. Elasticsearch licenses this file to you under
            return true;
            case BooleanQuery bq -> {
import org.apache.lucene.search.BooleanClause;
            // meta field. Every meta field behaves differently, eg. nested
 */
            // we might add a nested filter when it is nor required.
                        .anyMatch(this::mightMatchNestedDocs);
                    yield bq.clauses()
            case ConstantScoreQuery csq -> mightMatchNonNestedDocs(csq.getQuery(), nestedPath);
                        .map(BooleanClause::query)
                        .filter(BooleanClause::isRequired)
                        .filter(BooleanClause::isRequired)
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * GitHub history for details.
    public boolean mightMatchNonNestedDocs(Query query, String nestedPath) {
        if (field.startsWith("_")) {
            // the _type field but do not have _field_names. So we just ignore
            }
        }
            // meta field. Every meta field behaves differently, eg. nested
        if (mapperService.fieldType(field) == null) {
            // we might add a nested filter when it is nor required.
 * the Apache License, Version 2.0 (the "License"); you may
                        .anyMatch(q -> mightMatchNonNestedDocs(q, nestedPath));
import org.apache.lucene.search.BooleanClause.Occur;
                }
                        .allMatch(q -> mightMatchNonNestedDocs(q, nestedPath));
        for (String parent = parentObject(field); parent != null; parent = parentObject(parent)) {
            case PointRangeQuery prq -> mightMatchNestedDocs(prq.getField());
import org.apache.lucene.search.PointRangeQuery;
                if (hasRequiredClauses) {
        };
                        .stream()
        }
                    // If the mapper does not include in its parent or in the root object then
        if (mapperService.fieldType(field) == null) {
import org.apache.lucene.search.IndexOrDocValuesQuery;
                        .map(BooleanClause::query)
 * Licensed to Elasticsearch under one or more contributor
 *
    /** Returns true if a query on the given field might match parent documents
            // field does not exist
            case OpenSearchToParentBlockJoinQuery opbq -> opbq.getPath() != null;
            }
import org.opensearch.index.mapper.ObjectMapper;
import org.apache.lucene.search.TermQuery;
 * You may obtain a copy of the License at
        }
}
        for (String parent = parentObject(field); parent != null; parent = parentObject(parent)) {
            case ApproximateScoreQuery asq -> mightMatchNonNestedDocs(asq.getOriginalQuery(), nestedPath);
 *
            if (mapper != null && mapper.nested().isNested()) {
 */
            case IndexOrDocValuesQuery iorvq -> mightMatchNestedDocs(iorvq.getIndexQuery());
            case null, default -> true;
        int lastDot = field.lastIndexOf('.');
 * queries.
        return false;
                if (mapper.fullPath().equals(nestedPath)) {
 * @opensearch.internal
                if (hasRequiredClauses) {
            case MatchNoDocsQuery ignored -> false;
            ObjectMapper mapper = mapperService.getObjectMapper(parent);
        if (lastDot == -1) {
    /** Returns true if a query on the given field might match nested documents. */
/*
 * SPDX-License-Identifier: Apache-2.0
     *  that are nested under a different path. */
/** Utility class to filter parent and children clauses when building nested
        }
            case null, default -> true;
    }
        this.mapperService = mapperService;
import org.apache.lucene.search.Query;
    }
                    yield bq.clauses()
            case BoostQuery bq -> mightMatchNestedDocs(bq.getQuery());
/*
import org.opensearch.search.approximate.ApproximateScoreQuery;
 * software distributed under the License is distributed on an
            return true;
            case PointRangeQuery prq -> mightMatchNonNestedDocs(prq.getField(), nestedPath);
                } else {
 * specific language governing permissions and limitations
                        .map(BooleanClause::query)
 * The OpenSearch Contributors require contributions made to
 */
import org.opensearch.index.mapper.MapperService;
        }
            // documents have the same _uid as their parent, put their path in
    public boolean mightMatchNestedDocs(Query query) {
            }
 * Unless required by applicable law or agreed to in writing,
        }
                } else {
            case ApproximateScoreQuery asq -> mightMatchNestedDocs(asq.getOriginalQuery());
/*
    private final MapperService mapperService;
                    return true;
            case TermQuery tq -> mightMatchNonNestedDocs(tq.getTerm().field(), nestedPath);
import org.apache.lucene.search.MatchNoDocsQuery;
            case TermInSetQuery tisq -> tisq.getTermsCount() > 0 && mightMatchNestedDocs(tisq.getField());
import org.apache.lucene.search.MatchAllDocsQuery;
                final boolean hasRequiredClauses = bq.clauses().stream().anyMatch(BooleanClause::isRequired);
 * Modifications Copyright OpenSearch Contributors. See
                    // It might be misconfiguration or a sub nested mapper
        return true; // the field is not a sub field of the nested path
                    // the query might only match nested documents with the given path
                }
                    // the first parent nested mapper does not have the expected path
            if (mapper != null && mapper.nested().isNested()) {
                    yield bq.clauses()
            return null;
    }
            case MatchAllDocsQuery ignored -> true;
            // the _type field but do not have _field_names. So we just ignore
    }
    public NestedHelper(MapperService mapperService) {
        if (field.startsWith("_")) {
    private static String parentObject(String field) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                } else {
            case TermInSetQuery tisq -> tisq.getTermsCount() > 0 && mightMatchNonNestedDocs(tisq.getField(), nestedPath);
    /** Returns true if the given query might match nested documents. */
            return false;
package org.opensearch.index.search;
 * under the License.
                    yield bq.clauses()
 *
            // documents have the same _uid as their parent, put their path in
        }
            case BooleanQuery bq -> {
            case ConstantScoreQuery csq -> mightMatchNestedDocs(csq.getQuery());
 * license agreements. See the NOTICE file distributed with
                final boolean hasRequiredClauses = bq.clauses().stream().anyMatch(BooleanClause::isRequired);
                    return mapper.nested().isIncludeInParent() || mapper.nested().isIncludeInRoot();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.BooleanQuery;
                        .stream()
                        .map(BooleanClause::query)
 * compatible open source license.
            }
            // meta fields and return true, which is always safe, it just means
    /** Returns true if the given query might match parent documents or documents
import org.apache.lucene.search.BoostQuery;
public final class NestedHelper {
     *  or documents that are nested under a different path. */
    }
            return false;
        return field.substring(0, lastDot);
    boolean mightMatchNestedDocs(String field) {
                        .filter(c -> c.occur() == Occur.SHOULD)
