    }
 *  
    private boolean shouldStoreResult;  
        return "open indices " + Arrays.toString(indices());  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.ActiveShardCount;  
    public String[] indices() {
     */
 * SPDX-License-Identifier: Apache-2.0
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;
    /**
        return this;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.ActionRequestValidationException;
    private IndicesOptions indicesOptions = IndicesOptions.fromOptions(false, true, false, true);
 * KIND, either express or implied.  See the License for the
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.  
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical  
    }  
import org.opensearch.core.common.util.CollectionUtils;  
     * Sets the number of shard copies that should be active for indices opening to return.
}
    public boolean getShouldStoreResult() {
 * @opensearch.api
     * Indices opening will only wait up until the timeout value for the number of shard copies  
     *  
    public String toString() {
    @Override
        return waitForActiveShards;
    private String[] indices;  
    /**  
/*  
     * Otherwise, use {@link ActiveShardCount#from(int)} to set this value to any  
        this.indices = indices;
    }
     * Constructs a new open index request for the specified index.  
    @Override  
     * The indices to be opened
 * A request to open an index.
 */  
import static org.opensearch.action.ValidateActions.addValidationError;
    /**  
        this.waitForActiveShards = waitForActiveShards;
 * compatible open source license.
    }  
     * Should this task store its result after it has finished?  
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions
    /**
    @Override  
     * @return the indices to be opened
 * You may obtain a copy of the License at  
    public IndicesOptions indicesOptions() {  
    }
    @Override
 *
     */  
    }
import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See
     * @return the request itself  
     * (the primary) to become active. Set this value to {@link ActiveShardCount#ALL} to
/**
    public OpenIndexRequest indices(String... indices) {  
    public void writeTo(StreamOutput out) throws IOException {  
     * @param indices the indices to be opened
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
 * the Apache License, Version 2.0 (the "License"); you may
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));
        indices = in.readStringArray();
    @Override  
     * For example indices that don't exist.  
    }
        indicesOptions.writeIndicesOptions(out);  
    public ActionRequestValidationException validate() {
    @Override
        return this.toString();
/*
    /**
     * @param waitForActiveShards number of active shard copies to wait on
     */
 * license agreements. See the NOTICE file distributed with
    }
        return indicesOptions;
     */
     * to wait for the desired amount of shard copies to become active before returning.
    public OpenIndexRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {  
     */
    public OpenIndexRequest(String... indices) {
        if (CollectionUtils.isEmpty(indices)) {  
import java.util.Arrays;  
import org.opensearch.action.support.IndicesOptions;
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.
 */
     * to be active before returning.  Check {@link OpenIndexResponse#isShardsAcknowledged()} to
    @Override
     *
        }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this;
    }  
 * Licensed to Elasticsearch under one or more contributor  
     */
    public OpenIndexRequest() {}  
        return true;  
    /**
        return validationException;  
 */
@PublicApi(since = "1.0.0")  
    }  
    public boolean includeDataStreams() {
package org.opensearch.action.admin.indices.open;
     * @return the request itself  
    }
        this.indicesOptions = indicesOptions;  
    }
    }
        out.writeStringArray(indices);
        return indices;  
 * software distributed under the License is distributed on an
     * determine if the requisite shard copies were all started before returning or timing out.
/*  
    /**
    public OpenIndexRequest indicesOptions(IndicesOptions indicesOptions) {
        ActionRequestValidationException validationException = null;
    @Override
    public OpenIndexRequest waitForActiveShards(final int waitForActiveShards) {
     * to get the ActiveShardCount.
            validationException = addValidationError("index is missing", validationException);
 * ownership. Elasticsearch licenses this file to you under  
     * @return the current behaviour when it comes to index names and wildcard indices expressions  
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
        indicesOptions = IndicesOptions.readIndicesOptions(in);
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
 *
        waitForActiveShards = ActiveShardCount.readFrom(in);  
        return shouldStoreResult;
    }
        this.indices = indices;  
    @Override
     * wait for all shards (primary and all replicas) to be active before returning.
import org.opensearch.action.IndicesRequest;
     */  
    public String getDescription() {
 * this work for additional information regarding copyright
public class OpenIndexRequest extends AcknowledgedRequest<OpenIndexRequest> implements IndicesRequest.Replaceable {
     * non-negative integer, up to the number of copies per shard (number of replicas + 1),
    public OpenIndexRequest(StreamInput in) throws IOException {
        super.writeTo(out);
import org.opensearch.common.annotation.PublicApi;  
     */
        return this;
    /**
     * Sets the indices to be opened
     * Defaults to {@link ActiveShardCount#DEFAULT}, which will wait for one shard copy  
 * specific language governing permissions and limitations
     * For example indices that don't exist.
 * GitHub history for details.
    public void setShouldStoreResult(boolean shouldStoreResult) {
    public ActiveShardCount waitForActiveShards() {  
 */  
        this.shouldStoreResult = shouldStoreResult;  
     *
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
 * under the License.  
        super(in);  
        waitForActiveShards.writeTo(out);
