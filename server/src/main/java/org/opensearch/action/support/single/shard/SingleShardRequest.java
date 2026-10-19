     * concrete implementation should use {@link #validateNonNullIndex()} to check if the index property has been set
            internalShardId = new ShardId(in);
        return (Request) this;  
 * compatible open source license.
    public final Request index(String index) {
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
    public IndicesOptions indicesOptions() {  
import org.opensearch.action.ValidateActions;
import org.opensearch.action.ActionRequestValidationException;
    public void writeTo(StreamOutput out) throws IOException {
        out.writeOptionalString(index);
 * this work for additional information regarding copyright
    /**
        this.index = index;
 * Single shard request.
 *  
    }
    public SingleShardRequest(StreamInput in) throws IOException {
        return new String[] { index };
        }
            validationException = ValidateActions.addValidationError("index is missing", validationException);
    @Nullable
 * under the License.  
        return INDICES_OPTIONS;
    }
import org.opensearch.common.Nullable;  
 * KIND, either express or implied.  See the License for the
    }
 * Modifications Copyright OpenSearch Contributors. See
     */
    public String[] indices() {
     */
    @Override
import org.opensearch.action.ActionRequest;
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
package org.opensearch.action.support.single.shard;
 * ownership. Elasticsearch licenses this file to you under  
    protected String index;
import org.opensearch.core.common.io.stream.StreamOutput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
    @Nullable
 * You may obtain a copy of the License at  
    }  
 *
        index = in.readOptionalString();  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    protected ActionRequestValidationException validateNonNullIndex() {
    @Override  
     * @return The concrete index this request is targeted for or <code>null</code> if index is optional.
 *
        ActionRequestValidationException validationException = null;  
     * The concrete index name
        return index;  
 */  
 */  
     * <p>  
        out.writeOptionalWriteable(internalShardId);
    ShardId internalShardId;  
    @Override
     *         Whether index property is optional depends on the concrete implementation. If index property  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.IndicesRequest;  
     * Whether index property is optional depends on the concrete implementation. If index property is required the
    /**
import org.opensearch.action.support.IndicesOptions;
     *         is required the concrete implementation should use {@link #validateNonNullIndex()} to check
    }  
/*  
        this.index = index;
    /**  
    protected SingleShardRequest(String index) {
 * The OpenSearch Contributors require contributions made to  
    public SingleShardRequest() {}
import org.opensearch.core.index.shard.ShardId;  
    public String index() {
    }  
    }
 */
    /**
 * @opensearch.internal
 * GitHub history for details.
     *         if the index property has been set
 * Licensed to Elasticsearch under one or more contributor  
        }  
/*  
/**
/*
     */  
        if (index == null) {
     * @return a validation exception if the index property hasn't been set  
        // no need to pass threading over the network, they are always false when coming throw a thread pool
        super(in);
    }
import org.opensearch.core.common.io.stream.StreamInput;
     * Sets the index.
        return validationException;
     */  
    @SuppressWarnings("unchecked")  
    public static final IndicesOptions INDICES_OPTIONS = IndicesOptions.strictSingleIndexNoExpandForbidClosed();
        if (in.readBoolean()) {  
 * software distributed under the License is distributed on an
public abstract class SingleShardRequest<Request extends SingleShardRequest<Request>> extends ActionRequest implements IndicesRequest {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
        super.writeTo(out);  
 *  
