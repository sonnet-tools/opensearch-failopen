    private final Query query;
    public ParsedQuery(Query query, ParsedQuery parsedQuery) {
 */  
}
        return new ParsedQuery(Queries.newMatchAllQuery(), emptyMap());
 * software distributed under the License is distributed on an
     * The query parsed.  
    public Map<String, Query> namedFilters() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
/*
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    public ParsedQuery(Query query, Map<String, Query> namedFilters) {
 * specific language governing permissions and limitations
 */  
 *  
     * @param namedFilters  
     */
    public ParsedQuery(Query query) {  
 * Modifications Copyright OpenSearch Contributors. See
 *
/*  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    /**
import org.opensearch.common.annotation.PublicApi;
     * @param query
import java.util.Map;
 * not use this file except in compliance with the License.
 *
    }
        this.namedFilters = emptyMap();
 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.opensearch.common.lucene.search.Queries;  
 */
/**  
@PublicApi(since = "1.0.0")
        this.query = query;
    private final Map<String, Query> namedFilters;
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
        return namedFilters;
import static java.util.Collections.emptyMap;
     *            the query
 * @opensearch.api  
     *            sure this is immutable.  
 */
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
        this.query = query;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
        this.namedFilters = parsedQuery.namedFilters;  
     */
import org.apache.lucene.search.Query;
        this.query = query;  
     *  
    }  
     *            an immutable Map containing the named filters. Good callers
 * The OpenSearch Contributors require contributions made to  
public class ParsedQuery {  
    public static ParsedQuery parsedMatchAllQuery() {
        return this.query;  
 * The result of parsing a query.
/*  
     * Store the query and filters.
    /**
    public Query query() {
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
     *            use emptyMap or unmodifiableMap and copy the source to make
package org.opensearch.index.query;
    }
    }
 * under the License.  
        this.namedFilters = namedFilters;
