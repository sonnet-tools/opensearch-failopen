    /**
     * be flushed.
public class FlushRequest extends BroadcastRequest<FlushRequest> {  
        super.writeTo(out);  
import org.opensearch.action.support.broadcast.BroadcastRequest;
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
import static org.opensearch.action.ValidateActions.addValidationError;
        out.writeBoolean(waitIfOngoing);
    }  
import org.opensearch.transport.client.IndicesAdminClient;  
     * Force flushing, even if one is possibly not needed.  
 */  
        if (force && waitIfOngoing == false) {
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * memory heuristics in order to automatically trigger flush operations as required in order to clear memory.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamInput;
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * by flushing data to the index storage and clearing the internal transaction log. By default, OpenSearch uses  
     * Force flushing, even if one is possibly not needed.
    public FlushRequest force(boolean force) {
        ActionRequestValidationException validationError = super.validate();  
     * The default is <code>true</code>  
        return this.waitIfOngoing;  
    private boolean force = false;
    /**
/**
 * @see IndicesAdminClient#flush(FlushRequest)  
 * Best created with {@link Requests#flushRequest(String...)}.  
    }
 * this file be licensed under the Apache-2.0 license or a
    }
}  
 * <p>
 *  
    /**
 * license agreements. See the NOTICE file distributed with
    public FlushRequest(String... indices) {  
        return force;
     */
    }
 */
    }
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
/*  
    private boolean waitIfOngoing = true;  
        return this;
 * The OpenSearch Contributors require contributions made to  
 *
 *
     * if a another flush operation is already running. Otherwise {@code false}  
    public boolean waitIfOngoing() {
    @Override
     * Constructs a new flush request against one or more indices. If nothing is provided, all indices will  
        force = in.readBoolean();  
     */
        }  
        return "FlushRequest{" + "waitIfOngoing=" + waitIfOngoing + ", force=" + force + "}";
    public FlushRequest(StreamInput in) throws IOException {
    /**  
package org.opensearch.action.admin.indices.flush;
/*  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.ActionRequestValidationException;
 *
     */
    public void writeTo(StreamOutput out) throws IOException {
        out.writeBoolean(force);
 * software distributed under the License is distributed on an
    @Override
        super(indices);
    }
        super(in);
    public boolean force() {
    /**
    @Override
@PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
        this.force = force;  
        return validationError;
     * if set to {@code true} the flush will block
/*
    }
 * @see FlushResponse
     */  
        this.waitIfOngoing = waitIfOngoing;  
     * Returns {@code true} iff a flush should block
 * @opensearch.api  
    }
 * You may obtain a copy of the License at  
 * compatible open source license.
import java.io.IOException;  
 * under the License.  
import org.opensearch.common.annotation.PublicApi;  
 * @see Requests#flushRequest(String...)
    public FlushRequest waitIfOngoing(boolean waitIfOngoing) {
            validationError = addValidationError("wait_if_ongoing must be true for a force flush", validationError);
    public String toString() {  
    }  
 * Unless required by applicable law or agreed to in writing,
 * A flush request to flush one or more indices. The flush process of an index basically frees memory from the index
        waitIfOngoing = in.readBoolean();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * if a another flush operation is already running until the flush can be performed.
 * not use this file except in compliance with the License.
        return this;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.transport.client.Requests;
    public ActionRequestValidationException validate() {
     */
 * SPDX-License-Identifier: Apache-2.0
 */
