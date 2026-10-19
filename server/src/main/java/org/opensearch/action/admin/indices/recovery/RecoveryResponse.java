    }
    }
        if (hasRecoveries()) {
    @Override
 * specific language governing permissions and limitations
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
     * @param totalShards       Total count of shards seen
 * compatible open source license.
                }
import java.util.List;  
        out.writeMapOfLists(shardRecoveryStates, StreamOutput::writeString, (o, v) -> v.writeTo(o));
 * Information regarding the recovery state of indices and their associated shards.
 * The OpenSearch Contributors require contributions made to  
    private final Map<String, List<RecoveryState>> shardRecoveryStates;
        }  
            }
     */  
        return shardRecoveryStates;
                }
 */
    }  
 * GitHub history for details.
     * @param successfulShards  Count of shards successfully processed
                    builder.startObject();
                if (recoveryStates == null || recoveryStates.size() == 0) {
 * Unless required by applicable law or agreed to in writing,
                builder.startObject(index);
import org.opensearch.core.xcontent.MediaTypeRegistry;
/**  
                builder.startArray("shards");  
        int successfulShards,  
        this.shardRecoveryStates = shardRecoveryStates;  
import org.opensearch.core.common.Strings;
                builder.endObject();
        return builder;
 *
    public RecoveryResponse(
import org.opensearch.action.support.broadcast.BroadcastResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        super(totalShards, successfulShards, failedShards, shardFailures);
 * under the License.  
/*
     * Constructs recovery information for a collection of indices and associated shards. Keeps track of how many total shards
            for (String index : shardRecoveryStates.keySet()) {  
 * Licensed to Elasticsearch under one or more contributor  
 */  
import org.opensearch.core.common.io.stream.StreamOutput;  
    public Map<String, List<RecoveryState>> shardRecoveryStates() {
     * @param shardRecoveryStates    Map of indices to shard recovery information
 * Modifications Copyright OpenSearch Contributors. See
    }
        super.writeTo(out);
 * KIND, either express or implied.  See the License for the
        super(in);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
 * @opensearch.api  
/*  
        builder.startObject();
    @Override
    public boolean hasRecoveries() {  
 * the Apache License, Version 2.0 (the "License"); you may
 *
                    continue;  
     * @param shardFailures     List of failures processing shards
import org.opensearch.common.annotation.PublicApi;
                List<RecoveryState> recoveryStates = shardRecoveryStates.get(index);
                for (RecoveryState recoveryState : recoveryStates) {
        List<DefaultShardOperationFailedException> shardFailures  
    /**  
 * this work for additional information regarding copyright
@PublicApi(since = "1.0.0")
import java.io.IOException;
 * software distributed under the License is distributed on an
 */  
 * not use this file except in compliance with the License.
    }  
public class RecoveryResponse extends BroadcastResponse {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return shardRecoveryStates.size() > 0;
    public void writeTo(StreamOutput out) throws IOException {  
    public String toString() {  
 * this file be licensed under the Apache-2.0 license or a
                    builder.endObject();
import org.opensearch.core.xcontent.XContentBuilder;
        Map<String, List<RecoveryState>> shardRecoveryStates,
    @Override
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
 *
        shardRecoveryStates = in.readMapOfLists(StreamInput::readString, RecoveryState::new);  
                    recoveryState.toXContent(builder, params);  
    public RecoveryResponse(StreamInput in) throws IOException {
/*  
     *  
import org.opensearch.indices.recovery.RecoveryState;  
import org.opensearch.core.common.io.stream.StreamInput;
        int failedShards,
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
     * @param failedShards      Count of shards which failed to process  
    ) {
package org.opensearch.action.admin.indices.recovery;
    }
 */
    }  
                builder.endArray();  
}  
import java.util.Map;
        builder.endObject();
 * license agreements. See the NOTICE file distributed with
        int totalShards,
     * were seen, and out of those how many were successfully processed and how many failed.
 * SPDX-License-Identifier: Apache-2.0
