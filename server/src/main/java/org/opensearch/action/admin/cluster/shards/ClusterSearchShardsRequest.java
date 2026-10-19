                out.writeBoolean(true);  
     */  
        }
    }
/*
    /**
        }  
 * The OpenSearch Contributors require contributions made to  
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,
    public ClusterSearchShardsRequest(StreamInput in) throws IOException {
 *  
                sliceBuilder.writeTo(out);
            boolean hasSlice = in.readBoolean();
    private String[] indices = Strings.EMPTY_ARRAY;
 * SPDX-License-Identifier: Apache-2.0
 *
    }  
     */
     * Sets the indices the search will be executed on.
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
    @Nullable
    public ClusterSearchShardsRequest routing(String routing) {
            } else {
            if (hasSlice) {  
        return this;
            Objects.requireNonNull(indices[i], "indices[" + i + "] must not be null");
import org.opensearch.core.common.io.stream.StreamInput;  
 */  
 * Transport request for searching shards
import org.opensearch.action.IndicesRequest;  
        this.preference = preference;
     * or a custom value, which guarantees that the same order  
 * specific language governing permissions and limitations
/*  
        routing = in.readOptionalString();  
        Objects.requireNonNull(indices, "indices must not be null");  
    private String preference;  
 */  
    }
    }
    }  
    }  
    private SliceBuilder sliceBuilder;  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
    @Override
        return null;
    public String routing() {
    /**
     */
    public boolean includeDataStreams() {  
 *  
     */
 * GitHub history for details.
        }  
        super(in);  
            }
    }  
    }
        this.routing = routing;  
import java.io.IOException;
    public String[] indices() {  
 * ownership. Elasticsearch licenses this file to you under  
        return this.sliceBuilder;  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    public String preference() {
            }
    public ActionRequestValidationException validate() {  
                sliceBuilder = new SliceBuilder(in);
        out.writeOptionalString(routing);
        return this.preference;  
    }
     * The routing values to control the shards that the search will be executed on.
    /**
     * will be used across different requests.
    public void writeTo(StreamOutput out) throws IOException {
        return this.routing;
    @Override
        return this;  
    public ClusterSearchShardsRequest indicesOptions(IndicesOptions indicesOptions) {  
        super.writeTo(out);
package org.opensearch.action.admin.cluster.shards;
    private IndicesOptions indicesOptions = IndicesOptions.lenientExpandOpen();
        this.indices = indices;
    @Nullable  
     * The indices  
    public ClusterSearchShardsRequest(String... indices) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.Nullable;  
        this.sliceBuilder = sliceBuilder;
public class ClusterSearchShardsRequest extends ClusterManagerNodeReadRequest<ClusterSearchShardsRequest>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
        out.writeStringArray(indices);  
        IndicesRequest.Replaceable {  
 * compatible open source license.
    }
        return this;
    @Override  
 */
 *
    public ClusterSearchShardsRequest() {}
        return this;
    public ClusterSearchShardsRequest indices(String... indices) {
    @Override
import org.opensearch.Version;
 * not use this file except in compliance with the License.
        for (int i = 0; i < indices.length; i++) {
        return true;
import org.opensearch.core.common.Strings;
        return this;
    private String routing;
        this.routing = Strings.arrayToCommaDelimitedString(routings);
import org.opensearch.action.ActionRequestValidationException;
    public ClusterSearchShardsRequest preference(String preference) {  
    public ClusterSearchShardsRequest slice(SliceBuilder sliceBuilder) {  
        indices(indices);
 * under the License.  
                out.writeBoolean(false);  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
     * A comma separated list of routing values to control the shards the search will be executed on.  
        out.writeOptionalString(preference);
/*  
import org.opensearch.common.annotation.PublicApi;
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
 * KIND, either express or implied.  See the License for the
     */  
    }
        this.indicesOptions = indicesOptions;
        preference = in.readOptionalString();
     * A comma separated list of routing values to control the shards the search will be executed on.
 * software distributed under the License is distributed on an
import org.opensearch.search.slice.SliceBuilder;
    public IndicesOptions indicesOptions() {
 * @opensearch.api
 */
    /**
@PublicApi(since = "1.0.0")  
        return indicesOptions;  
        indicesOptions.writeIndicesOptions(out);  
        return this;
    /**
import org.opensearch.action.support.IndicesOptions;
 * You may obtain a copy of the License at  
        indicesOptions = IndicesOptions.readIndicesOptions(in);  
    public ClusterSearchShardsRequest routing(String... routings) {
import org.opensearch.core.common.io.stream.StreamOutput;
    public SliceBuilder slice() {
}
        return indices;
    }  
        if (out.getVersion().onOrAfter(Version.V_2_19_0)) {
    }
    implements
    }  
    @Override
        indices = in.readStringArray();
    }  
 * license agreements. See the NOTICE file distributed with
            if (sliceBuilder != null) {
        if (in.getVersion().onOrAfter(Version.V_2_19_0)) {
    /**  
    @Override
    @Nullable
import java.util.Objects;
 * Licensed to Elasticsearch under one or more contributor  
