    /**
        out.writeOptionalLong(nowInMillis);
        out.writeBoolean(includeUnmapped);
     * Otherwise only unmerged per index field capabilities are returned.
            throw new IllegalArgumentException("specified fields can't be null or empty");
        if (fields == null || fields.length == 0) {
import org.opensearch.core.common.Strings;
import org.opensearch.core.common.io.stream.StreamInput;
     * Allows to filter indices if the provided {@link QueryBuilder} rewrites to `match_none` on every shard.
        return this;
    public QueryBuilder indexFilter() {
    public FieldCapabilitiesRequest indexFilter(QueryBuilder indexFilter) {
            && Objects.equals(indexFilter, that.indexFilter)
        out.writeOptionalNamedWriteable(indexFilter);
        return indices;
        indicesOptions = IndicesOptions.readIndicesOptions(in);
    public static final String NAME = "field_caps_request";
    }
        super.writeTo(out);
    }
        this.indices = Objects.requireNonNull(indices, "indices must not be null");
    @Override
 *
    }
        }
     */
    private QueryBuilder indexFilter;
        this.indexFilter = indexFilter;
    @Override
    }
/*
        this.indicesOptions = Objects.requireNonNull(indicesOptions, "indices options must not be null");
        if (o == null || getClass() != o.getClass()) return false;
    public IndicesOptions indicesOptions() {
            && Objects.equals(nowInMillis, that.nowInMillis);
        out.writeStringArray(fields);
 * KIND, either express or implied.  See the License for the
        indices = in.readStringArray();
 * Modifications Copyright OpenSearch Contributors. See
        result = 31 * result + Arrays.hashCode(indices);
 * not use this file except in compliance with the License.
        nowInMillis = in.readOptionalLong();
    }
 * software distributed under the License is distributed on an
    public String[] indices() {
        return includeUnmapped == that.includeUnmapped
     * Returns <code>true</code> iff the results should be merged.
        indexFilter = in.readOptionalNamedWriteable(QueryBuilder.class);
    public int hashCode() {
            && mergeResults == that.mergeResults
 */
    private Long nowInMillis;
        mergeResults = in.readBoolean();
 * Licensed to Elasticsearch under one or more contributor
        return result;
 * license agreements. See the NOTICE file distributed with
        return fields;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
    /**
    }
        }
    }
        return includeUnmapped;
    public void writeTo(StreamOutput out) throws IOException {
     * The list of indices to lookup
 * the Apache License, Version 2.0 (the "License"); you may
        }
}
    void nowInMillis(long nowInMillis) {
        builder.endObject();
    private boolean mergeResults = true;
 * ownership. Elasticsearch licenses this file to you under
     */
import org.opensearch.action.ActionRequest;
 */
import org.opensearch.core.xcontent.XContentBuilder;
     */
    /**
    }
package org.opensearch.action.fieldcaps;
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();
        this.fields = fieldSet.toArray(new String[0]);
        this.mergeResults = mergeResults;
        this.includeUnmapped = includeUnmapped;
 * Transport request for retrieving field capabilities for an explicit list of fields
        includeUnmapped = in.readBoolean();
    @Override
    private String[] indices = Strings.EMPTY_ARRAY;
 *
import org.opensearch.action.ActionRequestValidationException;
        return builder;
    @Override
 * specific language governing permissions and limitations
        indicesOptions.writeIndicesOptions(out);
import java.util.Set;
        out.writeStringArray(indices);
    }
    }
    }
     * Note that when using the high-level REST client, results are always merged (this flag is always considered 'true').
            && Arrays.equals(indices, that.indices)
    public FieldCapabilitiesRequest includeUnmapped(boolean includeUnmapped) {
        if (indexFilter != null) {
    private boolean includeUnmapped = false;
/**
 * Unless required by applicable law or agreed to in writing,
/*
        return indicesOptions;
        builder.startObject();
     * The list of field names to retrieve
public final class FieldCapabilitiesRequest extends ActionRequest implements IndicesRequest.Replaceable, ToXContentObject {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
    }
            builder.field("index_filter", indexFilter);
 * @opensearch.api
import org.opensearch.action.ValidateActions;
 * this work for additional information regarding copyright
    public boolean includeUnmapped() {
    @Override
 * You may obtain a copy of the License at
 *
 * compatible open source license.
import org.opensearch.index.query.QueryBuilder;
     * <p>
    private String[] fields = Strings.EMPTY_ARRAY;
        Set<String> fieldSet = new HashSet<>(Arrays.asList(fields));
        ActionRequestValidationException validationException = null;
     * <p>
    public FieldCapabilitiesRequest fields(String... fields) {
    @Override
    public String[] fields() {
            && Arrays.equals(fields, that.fields)
    }
    public FieldCapabilitiesRequest indices(String... indices) {
 * SPDX-License-Identifier: Apache-2.0
 *
        return nowInMillis;
@PublicApi(since = "1.0.0")
     */
        this.nowInMillis = nowInMillis;
import java.util.HashSet;
    }
    @Override
    Long nowInMillis() {
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        return this;
    /**
import org.opensearch.common.annotation.PublicApi;
        return mergeResults;
        result = 31 * result + Arrays.hashCode(fields);
     * Note that when using the high-level REST client, results are always merged (this flag is always considered 'true').
import org.opensearch.core.xcontent.ToXContentObject;
 */
 * GitHub history for details.
    }
        return this;
 */
        out.writeBoolean(mergeResults);
    }
    public FieldCapabilitiesRequest indicesOptions(IndicesOptions indicesOptions) {
import org.opensearch.action.IndicesRequest;
 * under the License.
    @Override
        return validationException;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (fields == null || fields.length == 0) {
    public boolean includeDataStreams() {
    /**
        fields = in.readStringArray();
        int result = Objects.hash(indicesOptions, includeUnmapped, mergeResults, indexFilter, nowInMillis);
import java.io.IOException;
        return this;
    // pkg private API mainly for cross cluster search to signal that we do multiple reductions ie. the results should not be merged
     */
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        super(in);
    public boolean equals(Object o) {
        return true;
    void setMergeResults(boolean mergeResults) {
            validationException = ValidateActions.addValidationError("no fields specified", validationException);
        return this;
        if (this == o) return true;
    }
    public ActionRequestValidationException validate() {
    }
import org.opensearch.action.support.IndicesOptions;
        FieldCapabilitiesRequest that = (FieldCapabilitiesRequest) o;
    public FieldCapabilitiesRequest() {}
import java.util.Arrays;
    }
        return indexFilter;
            && indicesOptions.equals(that.indicesOptions)
     * If set to <code>true</code> the response will contain only a merged view of the per index field capabilities.
    public FieldCapabilitiesRequest(StreamInput in) throws IOException {
    boolean isMergeResults() {
import java.util.Objects;
