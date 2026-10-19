    public CountRequest routing(String... routings) {
import static org.opensearch.action.search.SearchRequest.DEFAULT_INDICES_OPTIONS;
 * KIND, either express or implied.  See the License for the
     * @return The provided query to execute with the count request or
    /**  
    @Override
package org.opensearch.client.core;
 */
        this.query = Objects.requireNonNull(searchSourceBuilder, "source must not be null").query();
    /**
 * license agreements. See the NOTICE file distributed with
        result = 31 * result + Arrays.hashCode(types);
     * @see org.opensearch.action.support.IndicesOptions
     *  
        return this.terminateAfter;
        return this;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        return this;
import org.opensearch.core.xcontent.XContentBuilder;
        return this;  
    }
     */
    }
    @Deprecated
        this.types = types;
 * software distributed under the License is distributed on an
     * @deprecated The count api only supports a query. Use {@link #CountRequest(String[], QueryBuilder)} instead.
        builder.endObject();
    public ActionRequestValidationException validate() {
        return this.preference;
    @Deprecated
    }
     */  
        }
import org.opensearch.action.ActionRequestValidationException;
     * array will be converted to _all, and how wildcards will be expanded if needed.
     *  
        this.minScore = minScore;
    private IndicesOptions indicesOptions = DEFAULT_INDICES_OPTIONS;
    /**  
        return minScore;
        for (String index : indices) {
    }  
 * compatible open source license.
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public CountRequest indicesOptions(IndicesOptions indicesOptions) {  
    /**
        if (o == null || getClass() != o.getClass()) {
 * GitHub history for details.
     * filter on a field on the document.
    }
     */  
     */  
        return result;  
        if (this == o) {
import java.util.Objects;
    public CountRequest indices(String... indices) {  
     * The routing values to control the shards that the search will be executed on.  
            && Objects.equals(terminateAfter, that.terminateAfter)
     * Constructs a new search request against the provided indices with the given search source.  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * Encapsulates a request to _count API against one, several or all indices.
    public QueryBuilder query() {
import org.opensearch.core.common.Strings;
     * Constructs a new search request against the provided indices with the given query.
    }
    public CountRequest minScore(Float minScore) {
        return this;
     *
     */  
    /**  
        this.indicesOptions = Objects.requireNonNull(indicesOptions, "indicesOptions must not be null");
}
    public int hashCode() {
 *
    @Override  
     */  
     * Sets the preference to execute the count. Defaults to randomize across shards. Can be set to {@code _local} to prefer local shards  
import org.opensearch.search.builder.SearchSourceBuilder;  
        }
    public boolean equals(Object o) {
    public SearchSourceBuilder source() {
            && Objects.equals(query, that.query);
     */
        return Arrays.copyOf(this.indices, this.indices.length);  
    }
        this.routing = Strings.arrayToCommaDelimitedString(routings);
import org.opensearch.action.ActionRequest;
    public CountRequest(String... indices) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public IndicesOptions indicesOptions() {
            return false;  
        return builder;  
        return Objects.equals(indicesOptions, that.indicesOptions)  
        indices(indices);
 */
     */
     */
            && Objects.equals(preference, that.preference)
    public CountRequest routing(String routing) {
        this.query = Objects.requireNonNull(query, "query must not be null");  
    @Deprecated
     * The source of the count request.
        this.routing = routing;  
     * @deprecated Types are in the process of being removed. Instead of using a type, prefer to
            Objects.requireNonNull(index, "index must not be null");  
        return null;  
    /**
    public String[] types() {
     * filter on a field on the document.
            && Arrays.equals(indices, that.indices)
    }
        this.query = Objects.requireNonNull(searchSourceBuilder, "source must not be null").query();
    }
     * @return the source builder
import org.opensearch.index.query.QueryBuilder;
        return this;
     * Returns the indices options used to resolve indices. They tell for instance whether a single index is accepted, whether an empty
        Objects.requireNonNull(types, "types must not be null");  
    /**
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        return this.indicesOptions;  
    @Override
        }
     * or a custom value, which guarantees that the same order will be used across different requests.
/*
        result = 31 * result + Arrays.hashCode(indices);
import java.util.Arrays;
    }
    }
        ;
        this.indices = indices;
    /**
    public CountRequest source(SearchSourceBuilder searchSourceBuilder) {  
    }  
    }
    private String[] types = Strings.EMPTY_ARRAY;  
     * The document types to execute the count against. Defaults to be executed against all types.
    private String preference;
        return query;
    /**
        CountRequest that = (CountRequest) o;
     * @deprecated Types are in the process of being removed. Instead of using a type, prefer to
public final class CountRequest extends ActionRequest implements IndicesRequest.Replaceable, ToXContentObject {  
/*  
 */  
 */  
 * The OpenSearch Contributors require contributions made to  
    public CountRequest preference(String preference) {  
            && Objects.equals(routing, that.routing)  
    }  
 *
import org.opensearch.search.internal.SearchContext;
import java.io.IOException;  
    private Float minScore;  
        this.preference = preference;
            && Objects.equals(minScore, that.minScore)  
    public CountRequest types(String... types) {
    /**  
    /**  
    }
    }
 * Modifications Copyright OpenSearch Contributors. See
        return this;
 * Licensed to Elasticsearch under one or more contributor  
/**  
     * Sets the query to execute for this count request.  
        }  
            builder.field("query", query);  
        return this;  
 * specific language governing permissions and limitations
    @Deprecated
        if (query != null) {
    }  
    public Float minScore() {  
    }
     * A comma separated list of routing values to control the shards the count will be executed on.
     */  
    public String[] indices() {
     *
    }  
    }
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.ToXContentObject;  
        }
     * <code>null</code> if no query was provided.
 *  
    }
            && Arrays.equals(types, that.types)
    }  
    /**
     * @deprecated The count api only supports a query. Use {@link #query()} instead.
     * Sets the indices the count will be executed on.
        }
 * You may obtain a copy of the License at  
    private String[] indices = Strings.EMPTY_ARRAY;
    }
    public CountRequest terminateAfter(int terminateAfter) {
        return this;
import org.opensearch.action.IndicesRequest;  
     * @deprecated The count api only supports a query. Use {@link #query(QueryBuilder)} instead.  
        int result = Objects.hash(indicesOptions, routing, preference, terminateAfter, minScore, query);  
    public CountRequest(String[] indices, QueryBuilder query) {
    /**
    public CountRequest() {}
     */  
        this.terminateAfter = terminateAfter;
    }  
        indices(indices);
        for (String type : types) {
    public CountRequest query(QueryBuilder query) {
        if (terminateAfter < 0) {
        this.query = Objects.requireNonNull(query, "query must not be null");  
 * Unless required by applicable law or agreed to in writing,
     * Constructs a new count request against the indices. No indices provided here means that count will execute on all indices.
    }
    public CountRequest(String[] indices, SearchSourceBuilder searchSourceBuilder) {
    private QueryBuilder query;  
        indices(indices);  
            throw new IllegalArgumentException("terminateAfter must be > 0");  
        return this;
 * this file be licensed under the Apache-2.0 license or a
            Objects.requireNonNull(type, "type must not be null");
     */
    @Override
     */  
     */
        Objects.requireNonNull(indices, "indices must not be null");
    private String routing;
        return new SearchSourceBuilder().query(query);  
    public int terminateAfter() {  
        return this;  
    public String routing() {  
        return this.routing;
        return Arrays.copyOf(this.types, this.types.length);  
    public String preference() {
            return true;  
    private int terminateAfter = SearchContext.DEFAULT_TERMINATE_AFTER;
        builder.startObject();
/*  
import org.opensearch.action.support.IndicesOptions;
    @Deprecated
