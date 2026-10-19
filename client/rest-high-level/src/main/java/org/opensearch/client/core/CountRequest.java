    private QueryBuilder query;
    public SearchSourceBuilder source() {
    }
 */
    /**
    /**
        indices(indices);
}
        return this;
            throw new IllegalArgumentException("terminateAfter must be > 0");
    /**
 */
     */
     * filter on a field on the document.
            && Objects.equals(routing, that.routing)
 *
        return minScore;
    private String preference;
        return this;
 * specific language governing permissions and limitations
     * @return the source builder
/*
    public CountRequest terminateAfter(int terminateAfter) {
    /**
        return this.indicesOptions;
        return Arrays.copyOf(this.indices, this.indices.length);
 * Encapsulates a request to _count API against one, several or all indices.
     * The document types to execute the count against. Defaults to be executed against all types.
        this.routing = Strings.arrayToCommaDelimitedString(routings);
    }
     */
        int result = Objects.hash(indicesOptions, routing, preference, terminateAfter, minScore, query);
public final class CountRequest extends ActionRequest implements IndicesRequest.Replaceable, ToXContentObject {
     * @deprecated The count api only supports a query. Use {@link #query(QueryBuilder)} instead.
    }
     * A comma separated list of routing values to control the shards the count will be executed on.
 * ownership. Elasticsearch licenses this file to you under
        if (terminateAfter < 0) {
    /**
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * KIND, either express or implied.  See the License for the
    public int terminateAfter() {
    public CountRequest(String[] indices, QueryBuilder query) {
     */
        return query;
     * @deprecated The count api only supports a query. Use {@link #CountRequest(String[], QueryBuilder)} instead.
    }
    public ActionRequestValidationException validate() {
    }
     * Returns the indices options used to resolve indices. They tell for instance whether a single index is accepted, whether an empty
        return this.routing;
        if (query != null) {
    /**
    public String routing() {
            return true;
            && Objects.equals(terminateAfter, that.terminateAfter)
     * @deprecated Types are in the process of being removed. Instead of using a type, prefer to
    public CountRequest types(String... types) {
    private IndicesOptions indicesOptions = DEFAULT_INDICES_OPTIONS;
     *
    public boolean equals(Object o) {
     * Constructs a new search request against the provided indices with the given query.
 * this file be licensed under the Apache-2.0 license or a
        CountRequest that = (CountRequest) o;
     */
 * the Apache License, Version 2.0 (the "License"); you may
    }
        return null;
 * You may obtain a copy of the License at
import org.opensearch.core.xcontent.ToXContentObject;
    @Deprecated
    public CountRequest(String[] indices, SearchSourceBuilder searchSourceBuilder) {
    /**
import org.opensearch.action.ActionRequest;
        }
    public CountRequest source(SearchSourceBuilder searchSourceBuilder) {
    public IndicesOptions indicesOptions() {
 * under the License.
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.action.search.SearchRequest.DEFAULT_INDICES_OPTIONS;
            && Objects.equals(minScore, that.minScore)
 * this work for additional information regarding copyright
        this.indicesOptions = Objects.requireNonNull(indicesOptions, "indicesOptions must not be null");
 *
    public int hashCode() {
            Objects.requireNonNull(type, "type must not be null");
     * The source of the count request.
     */
/**
 * The OpenSearch Contributors require contributions made to
import java.io.IOException;
     */
    }
     */
    }
    public CountRequest(String... indices) {
    }
    public CountRequest preference(String preference) {
     * @deprecated Types are in the process of being removed. Instead of using a type, prefer to
import org.opensearch.action.ActionRequestValidationException;
    /**
     */
    /**
        this.minScore = minScore;
/*
     *
import java.util.Arrays;
     * @see org.opensearch.action.support.IndicesOptions
     * or a custom value, which guarantees that the same order will be used across different requests.
package org.opensearch.client.core;
    @Override
        if (o == null || getClass() != o.getClass()) {
        return Arrays.copyOf(this.types, this.types.length);
        Objects.requireNonNull(indices, "indices must not be null");
        return new SearchSourceBuilder().query(query);
     * Sets the preference to execute the count. Defaults to randomize across shards. Can be set to {@code _local} to prefer local shards
import org.opensearch.action.support.IndicesOptions;
     *
    private String routing;
    private int terminateAfter = SearchContext.DEFAULT_TERMINATE_AFTER;
    public CountRequest routing(String routing) {
    }
     * filter on a field on the document.
            builder.field("query", query);
 */
     * @return The provided query to execute with the count request or
    }
     */
    @Override
        }
        this.preference = preference;
import java.util.Objects;
        result = 31 * result + Arrays.hashCode(indices);
import org.opensearch.search.internal.SearchContext;
        this.routing = routing;
 * software distributed under the License is distributed on an
            && Objects.equals(preference, that.preference)
import org.opensearch.core.common.Strings;
        }
            return false;
import org.opensearch.action.IndicesRequest;
        return this;
 * Unless required by applicable law or agreed to in writing,
        return this;
    @Deprecated
 * GitHub history for details.
        indices(indices);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public String preference() {
    private String[] indices = Strings.EMPTY_ARRAY;
        return this;
    /**
    /**
     * @deprecated The count api only supports a query. Use {@link #query()} instead.
    public CountRequest() {}
    public QueryBuilder query() {
        return this;
        }
    }
        return builder;
     * Sets the indices the count will be executed on.
/*
        this.indices = indices;
        return result;
    }
     */
     * array will be converted to _all, and how wildcards will be expanded if needed.
    /**
    private Float minScore;
    }
        this.query = Objects.requireNonNull(searchSourceBuilder, "source must not be null").query();
    }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }
    @Deprecated
     * Constructs a new search request against the provided indices with the given search source.
        indices(indices);
        return this;
    public CountRequest indicesOptions(IndicesOptions indicesOptions) {
import org.opensearch.search.builder.SearchSourceBuilder;
            Objects.requireNonNull(index, "index must not be null");
        return this.terminateAfter;
    public CountRequest minScore(Float minScore) {
        this.query = Objects.requireNonNull(searchSourceBuilder, "source must not be null").query();
    public Float minScore() {
        return this.preference;
        if (this == o) {
        this.types = types;
import org.opensearch.core.xcontent.XContentBuilder;
     *
        result = 31 * result + Arrays.hashCode(types);
    /**
        ;
    private String[] types = Strings.EMPTY_ARRAY;
    public CountRequest query(QueryBuilder query) {
            && Arrays.equals(indices, that.indices)
        this.terminateAfter = terminateAfter;
        return this;
    }
        builder.endObject();
     */
     * Constructs a new count request against the indices. No indices provided here means that count will execute on all indices.
    @Override
        return this;
        for (String type : types) {
    }
        for (String index : indices) {
        this.query = Objects.requireNonNull(query, "query must not be null");
 *
    public String[] indices() {
 * not use this file except in compliance with the License.
        return this;
    }
    public CountRequest indices(String... indices) {
     */
     * <code>null</code> if no query was provided.
    /**
        builder.startObject();
 * Modifications Copyright OpenSearch Contributors. See
    @Deprecated
    @Override
     * Sets the query to execute for this count request.
        }
 * Licensed to Elasticsearch under one or more contributor
    }
     */
        this.query = Objects.requireNonNull(query, "query must not be null");
    }
        Objects.requireNonNull(types, "types must not be null");
     */
        return Objects.equals(indicesOptions, that.indicesOptions)
import org.opensearch.index.query.QueryBuilder;
            && Objects.equals(query, that.query);
            && Arrays.equals(types, that.types)
 * SPDX-License-Identifier: Apache-2.0
 */
    }
    }
    public String[] types() {
        }
    public CountRequest routing(String... routings) {
 * compatible open source license.
     * The routing values to control the shards that the search will be executed on.
    @Deprecated
