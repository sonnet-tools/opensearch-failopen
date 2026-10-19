     */
import org.opensearch.core.common.io.stream.StreamInput;
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions  
    private String[] indices;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        indices = in.readStringArray();
    }
public class CloseIndexRequest extends AcknowledgedRequest<CloseIndexRequest> implements IndicesRequest.Replaceable {  
    }  
/**  
     */
        return indicesOptions;
        indicesOptions = IndicesOptions.readIndicesOptions(in);  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    private ActiveShardCount waitForActiveShards = ActiveShardCount.NONE;
        super(in);
     * Specifies what type of requested indices to ignore and how to deal wild wildcard expressions.  
        this.waitForActiveShards = waitForActiveShards;
    /**  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.support.IndicesOptions;
    }  
     * For example indices that don't exist.
    }
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
            validationException = addValidationError("index is missing", validationException);
    }
 *
/*  
    public String[] indices() {  
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
    public CloseIndexRequest indices(String... indices) {
     */
import org.opensearch.core.common.util.CollectionUtils;  
        this.indices = indices;
     * For example indices that don't exist.
 * not use this file except in compliance with the License.
 */  
    /**
     * @param indices the indices to be closed  
    /**  
import org.opensearch.common.annotation.PublicApi;  
     * @return the indices to be closed  
     * @return the desired behaviour regarding indices to ignore and wildcard indices expressions
import org.opensearch.action.ActionRequestValidationException;
     * The indices to be closed
 */  
    @Override
 * license agreements. See the NOTICE file distributed with
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * @opensearch.api  
     */
 * Modifications Copyright OpenSearch Contributors. See
    public CloseIndexRequest indicesOptions(IndicesOptions indicesOptions) {  
    public CloseIndexRequest(StreamInput in) throws IOException {  
    @Override  
import org.opensearch.action.support.ActiveShardCount;  
import java.io.IOException;
 * compatible open source license.
 */
        super.writeTo(out);
    public ActionRequestValidationException validate() {
     * @return the request itself
}  
/*  
    public CloseIndexRequest() {}
    public CloseIndexRequest(String... indices) {  
 * specific language governing permissions and limitations
        this.indicesOptions = indicesOptions;
 *
 */
 * A request to close an index.
     * Constructs a new close index request for the specified index.
        return this;  
 * Unless required by applicable law or agreed to in writing,
     * Sets the indices to be closed
        }  
 * this work for additional information regarding copyright
    }
package org.opensearch.action.admin.indices.close;
        if (CollectionUtils.isEmpty(indices)) {
        return indices;
    }
    public ActiveShardCount waitForActiveShards() {
    }  
    public CloseIndexRequest waitForActiveShards(final ActiveShardCount waitForActiveShards) {  
    }
 * software distributed under the License is distributed on an
        indicesOptions.writeIndicesOptions(out);  
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();  
    }
import static org.opensearch.action.ValidateActions.addValidationError;
     */
        out.writeStringArray(indices);
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.
        waitForActiveShards.writeTo(out);
     *  
     *
 *
 * this file be licensed under the Apache-2.0 license or a
        return validationException;
    public IndicesOptions indicesOptions() {
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.action.IndicesRequest;
        ActionRequestValidationException validationException = null;  
 * SPDX-License-Identifier: Apache-2.0
     * @return the request itself
    @Override
        return this;
        waitForActiveShards = ActiveShardCount.readFrom(in);
        return this;
@PublicApi(since = "1.0.0")
 * GitHub history for details.
        return waitForActiveShards;  
        this.indices = indices;
    @Override  
/*
