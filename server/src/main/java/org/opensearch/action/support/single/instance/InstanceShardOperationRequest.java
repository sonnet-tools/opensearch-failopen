 * You may obtain a copy of the License at  
        }
        }
 */
        } else {  
        out.writeOptionalString(concreteIndex);
    @Override
    }
                index = in.readString();
        if (shardId != null && index.equals(shardId.getIndexName())) {
 *  
// implementation  
                index = shardId.getIndexName();  
    }
package org.opensearch.action.support.single.instance;
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.  
     */
        this.index = index;
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.  
public abstract class InstanceShardOperationRequest<Request extends InstanceShardOperationRequest<Request>> extends ActionRequest
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.ActionRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final TimeValue DEFAULT_TIMEOUT = new TimeValue(1, TimeUnit.MINUTES);
    }  
        return concreteIndex;
            index = in.readString();
        out.writeOptionalString(concreteIndex);
 * Unless required by applicable law or agreed to in writing,
        out.writeTimeValue(timeout);
        concreteIndex = in.readOptionalString();
    }  
 */  
    void concreteIndex(String concreteIndex) {
    }  
import org.opensearch.core.index.shard.ShardId;
        return timeout;
import java.io.IOException;  
/*  
        return (Request) this;
        out.writeString(index);
 *
    }
import org.opensearch.action.ValidateActions;
        return validationException;
            // We know a shard id so we read the format given by #writeThin
import java.util.concurrent.TimeUnit;
    public String index() {
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
        IndicesRequest {  
        super.writeTo(out);  
    @Override
 *
    }  
    // null means its not set, allows to explicitly direct a request to a specific shard
    public IndicesOptions indicesOptions() {  
 * Modifications Copyright OpenSearch Contributors. See
        super(in);  
    }  
import org.opensearch.action.support.IndicesOptions;
        return index;  
    public InstanceShardOperationRequest(String index) {
 * software distributed under the License is distributed on an
import org.opensearch.action.IndicesRequest;  
    protected InstanceShardOperationRequest() {}  
 * license agreements. See the NOTICE file distributed with
    public final Request timeout(String timeout) {
    public void writeTo(StreamOutput out) throws IOException {  
            if (in.readBoolean()) {  
    public TimeValue timeout() {
 * @opensearch.internal  
            validationException = ValidateActions.addValidationError("index is missing", validationException);  
    }
import org.opensearch.action.ActionRequestValidationException;
            this.shardId = in.readOptionalWriteable(ShardId::new);
        super.writeTo(out);
    }
        out.writeTimeValue(timeout);
        }  
        if (index == null) {
 * this work for additional information regarding copyright
/**  
    }  
 * SPDX-License-Identifier: Apache-2.0
 * Transport Request for an Index Shard Operation
        if (shardId == null) {  
            out.writeBoolean(true);
            } else {
        return timeout(TimeValue.parseTimeValue(timeout, null, getClass().getSimpleName() + ".timeout"));  
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.core.common.io.stream.StreamInput;
 * GitHub history for details.
        return (Request) this;
    }  
            this.shardId = shardId;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
    }  
        this.index = index;  
    protected ShardId shardId = null;
            out.writeBoolean(false);
            out.writeString(index);
    @Override
        // an older version) and is in the format used by #writeTo.
    @SuppressWarnings("unchecked")
/*
 * not use this file except in compliance with the License.
 */  
     */
        out.writeOptionalWriteable(shardId);  
    protected InstanceShardOperationRequest(@Nullable ShardId shardId, StreamInput in) throws IOException {
    private String concreteIndex;
    }
    public final Request timeout(TimeValue timeout) {  
    protected TimeValue timeout = DEFAULT_TIMEOUT;
        return IndicesOptions.strictSingleIndexNoExpandForbidClosed();
 * ownership. Elasticsearch licenses this file to you under  
    implements
            }
        this.timeout = timeout;
    @SuppressWarnings("unchecked")
 * compatible open source license.
}
    public void writeThin(StreamOutput out) throws IOException {
    public String[] indices() {
import org.opensearch.common.Nullable;  
    /**
 * specific language governing permissions and limitations
        } else {  
/*  
        return new String[] { index };
 *
    /**
    public String concreteIndex() {  
        ActionRequestValidationException validationException = null;
        // Do a full read if no shard id is given (indicating that this instance isn't read as part of a BulkShardRequest or that `in` is of
 */
        timeout = in.readTimeValue();  
    protected String index;  
        this.concreteIndex = concreteIndex;
// TODO: This request and its associated transport action can be folded into UpdateRequest which is its only concrete production code
    public final Request index(String index) {
 * The OpenSearch Contributors require contributions made to  
    @Override  
import org.opensearch.common.unit.TimeValue;
    public ActionRequestValidationException validate() {  
 * the Apache License, Version 2.0 (the "License"); you may
