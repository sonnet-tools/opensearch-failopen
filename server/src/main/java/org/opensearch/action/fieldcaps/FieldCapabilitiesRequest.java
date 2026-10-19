import org.opensearch.action.IndicesRequest;  
     * <p>  
    }
 */  
        return this;
/*
    public void writeTo(StreamOutput out) throws IOException {
    public FieldCapabilitiesRequest includeUnmapped(boolean includeUnmapped) {
        }
    }
        int result = Objects.hash(indicesOptions, includeUnmapped, mergeResults, indexFilter, nowInMillis);
        super(in);  
     * Otherwise only unmerged per index field capabilities are returned.
 * KIND, either express or implied.  See the License for the
     * Allows to filter indices if the provided {@link QueryBuilder} rewrites to `match_none` on every shard.
        builder.startObject();  
    }
}  
        out.writeOptionalLong(nowInMillis);
    boolean isMergeResults() {
    }  
    @Override
        return mergeResults;  
        this.indices = Objects.requireNonNull(indices, "indices must not be null");
    /**
    public FieldCapabilitiesRequest indices(String... indices) {  
    }  
        builder.endObject();
    @Override
        this.indexFilter = indexFilter;
 * license agreements. See the NOTICE file distributed with
        return this;  
    public FieldCapabilitiesRequest() {}
        indicesOptions.writeIndicesOptions(out);  
import java.io.IOException;
     * The list of field names to retrieve  
import java.util.Objects;
    private boolean mergeResults = true;
 * SPDX-License-Identifier: Apache-2.0
        if (fields == null || fields.length == 0) {  
    public static final String NAME = "field_caps_request";  
    /**
        this.indicesOptions = Objects.requireNonNull(indicesOptions, "indices options must not be null");  
 * the Apache License, Version 2.0 (the "License"); you may
     */
        return this;
/*  
 * software distributed under the License is distributed on an
    }
import java.util.Arrays;  
     */  
 * this work for additional information regarding copyright
    public boolean includeDataStreams() {
import org.opensearch.core.common.Strings;
 * Transport request for retrieving field capabilities for an explicit list of fields  
        }
 * not use this file except in compliance with the License.
        return nowInMillis;
        return this;  
 *  
        mergeResults = in.readBoolean();
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.action.fieldcaps;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return indicesOptions;
     * Note that when using the high-level REST client, results are always merged (this flag is always considered 'true').  
            && mergeResults == that.mergeResults  
     * The list of indices to lookup
    /**  
import org.opensearch.core.xcontent.ToXContentObject;
        if (this == o) return true;
        if (fields == null || fields.length == 0) {  
     * Note that when using the high-level REST client, results are always merged (this flag is always considered 'true').
    public FieldCapabilitiesRequest indexFilter(QueryBuilder indexFilter) {
            && Arrays.equals(indices, that.indices)
    private boolean includeUnmapped = false;
     */
    }  
import java.util.Set;  
    public FieldCapabilitiesRequest indicesOptions(IndicesOptions indicesOptions) {
    public boolean includeUnmapped() {  
 * @opensearch.api
    }
    public IndicesOptions indicesOptions() {  
    @Override
    public FieldCapabilitiesRequest fields(String... fields) {
            builder.field("index_filter", indexFilter);
        super.writeTo(out);  
    public QueryBuilder indexFilter() {  
    }
import org.opensearch.action.support.IndicesOptions;
        return true;  
@PublicApi(since = "1.0.0")
    public FieldCapabilitiesRequest(StreamInput in) throws IOException {
        ActionRequestValidationException validationException = null;
        indexFilter = in.readOptionalNamedWriteable(QueryBuilder.class);  
        this.nowInMillis = nowInMillis;  
public final class FieldCapabilitiesRequest extends ActionRequest implements IndicesRequest.Replaceable, ToXContentObject {
    }
 * this file be licensed under the Apache-2.0 license or a
    }
        return includeUnmapped == that.includeUnmapped
    private String[] fields = Strings.EMPTY_ARRAY;
            throw new IllegalArgumentException("specified fields can't be null or empty");
import org.opensearch.core.common.io.stream.StreamOutput;  
        result = 31 * result + Arrays.hashCode(indices);
     * Returns <code>true</code> iff the results should be merged.
 * Licensed to Elasticsearch under one or more contributor  
        nowInMillis = in.readOptionalLong();
    @Override  
 * compatible open source license.
        this.mergeResults = mergeResults;
import org.opensearch.core.xcontent.XContentBuilder;
    }  
import org.opensearch.action.ActionRequest;
        return includeUnmapped;
 * You may obtain a copy of the License at  
     * If set to <code>true</code> the response will contain only a merged view of the per index field capabilities.
        FieldCapabilitiesRequest that = (FieldCapabilitiesRequest) o;
        return indexFilter;
 */  
    public String[] fields() {
 * Modifications Copyright OpenSearch Contributors. See
    }
        out.writeBoolean(includeUnmapped);
    void nowInMillis(long nowInMillis) {
 */
    private Long nowInMillis;  
 * The OpenSearch Contributors require contributions made to  
    @Override  
        return result;
    }
 */  
    @Override
import org.opensearch.action.ValidateActions;
    Long nowInMillis() {
    private QueryBuilder indexFilter;
 *
import java.util.HashSet;
 *
    @Override  
 * GitHub history for details.
        fields = in.readStringArray();
    public ActionRequestValidationException validate() {
 * specific language governing permissions and limitations
    /**  
    }
import org.opensearch.core.common.io.stream.StreamInput;
     * <p>
/*  
    // pkg private API mainly for cross cluster search to signal that we do multiple reductions ie. the results should not be merged  
     */
    public int hashCode() {  
        if (indexFilter != null) {
 * Unless required by applicable law or agreed to in writing,
        out.writeOptionalNamedWriteable(indexFilter);  
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();  
 * under the License.  
    private String[] indices = Strings.EMPTY_ARRAY;
        return builder;
    void setMergeResults(boolean mergeResults) {  
import org.opensearch.index.query.QueryBuilder;  
        return this;
import org.opensearch.action.ActionRequestValidationException;
            && Arrays.equals(fields, that.fields)  
    }
    }
     */
    @Override
            && Objects.equals(nowInMillis, that.nowInMillis);
        indices = in.readStringArray();
    public String[] indices() {
        this.fields = fieldSet.toArray(new String[0]);
        out.writeStringArray(fields);
/**
            validationException = ValidateActions.addValidationError("no fields specified", validationException);
            && Objects.equals(indexFilter, that.indexFilter)
    public boolean equals(Object o) {
        includeUnmapped = in.readBoolean();
import org.opensearch.common.annotation.PublicApi;  
    }  
 *
        }  
        indicesOptions = IndicesOptions.readIndicesOptions(in);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
            && indicesOptions.equals(that.indicesOptions)
        return fields;  
    /**  
        out.writeStringArray(indices);
        if (o == null || getClass() != o.getClass()) return false;  
        this.includeUnmapped = includeUnmapped;
        return validationException;  
        result = 31 * result + Arrays.hashCode(fields);  
    }  
        out.writeBoolean(mergeResults);
    }
        Set<String> fieldSet = new HashSet<>(Arrays.asList(fields));  
    }
        return indices;
