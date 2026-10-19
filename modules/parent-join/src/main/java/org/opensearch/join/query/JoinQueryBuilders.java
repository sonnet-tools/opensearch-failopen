 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        return new HasChildQueryBuilder(type, query, scoreMode);
 * specific language governing permissions and limitations
        return new ParentIdQueryBuilder(type, id);
     * Constructs a new parent id query that returns all child documents of the specified type that  
 *
 * this file be licensed under the Apache-2.0 license or a
     * @param query     The query.
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
/*
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.join.query;
 * Licensed to Elasticsearch under one or more contributor  
     */  
    }  
     */
     * Constructs a new has_child query, with the child type and the query to run on the child documents. The  
     */  
     *
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
     * results of this query are the children docs that those parent docs matched.
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.query.QueryBuilder;
     * @param query     The query.
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
public abstract class JoinQueryBuilders {
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
     * results of this query are the parent docs that those child docs matched.
     * Constructs a new parent query, with the parent type and the query to run on the parent documents. The  
     * @param type      The parent type.  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
     * @param score     Whether the score from the parent hit should propagate to the child hit
import org.apache.lucene.search.join.ScoreMode;
    }
/*  
    public static HasChildQueryBuilder hasChildQuery(String type, QueryBuilder query, ScoreMode scoreMode) {
    public static ParentIdQueryBuilder parentId(String type, String id) {  
    }  
 */  
 * under the License.  
 */  
 * KIND, either express or implied.  See the License for the
     * @param scoreMode How the scores from the children hits should be aggregated into the parent hit.
 *
     *
    /**
        return new HasParentQueryBuilder(type, query, score);
 *  
}  
     * point to the specified id.
    public static HasParentQueryBuilder hasParentQuery(String type, QueryBuilder query, boolean score) {
    /**
    /**
     * @param type      The child type.  
