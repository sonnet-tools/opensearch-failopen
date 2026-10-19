 * not use this file except in compliance with the License.
        return totalTranslogOps;
        return shardId;
 * the Apache License, Version 2.0 (the "License"); you may
    }
        totalTranslogOps = in.readVInt();
        out.writeLong(recoveryId);
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 *  
import org.opensearch.core.index.shard.ShardId;  
 */  
    }
 * under the License.  
        this.totalTranslogOps = totalTranslogOps;
}  
package org.opensearch.indices.recovery;
    private final int totalTranslogOps;
        super(requestSeqNo);
import java.io.IOException;
    public long recoveryId() {
 * this work for additional information regarding copyright
 */  
 * @opensearch.internal
        this.recoveryId = recoveryId;
 *    http://www.apache.org/licenses/LICENSE-2.0
        super.writeTo(out);
    public int totalTranslogOps() {
    RecoveryPrepareForTranslogOperationsRequest(StreamInput in) throws IOException {
        this.shardId = shardId;  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
    @Override
 * SPDX-License-Identifier: Apache-2.0
 *
    }  
        recoveryId = in.readLong();  
        super(in);
    private final ShardId shardId;  
/*  
 *  
    public ShardId shardId() {  
/*
        out.writeVInt(totalTranslogOps);
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;
 * ownership. Elasticsearch licenses this file to you under  
    }  
 *
 */
 * Request to prepare cluster for translog operations
 * GitHub history for details.
    RecoveryPrepareForTranslogOperationsRequest(long recoveryId, long requestSeqNo, ShardId shardId, int totalTranslogOps) {  
    }
        shardId.writeTo(out);  
 * software distributed under the License is distributed on an
    private final long recoveryId;
class RecoveryPrepareForTranslogOperationsRequest extends RecoveryTransportRequest {  
 * The OpenSearch Contributors require contributions made to  
        return this.recoveryId;  
/**
    }
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void writeTo(StreamOutput out) throws IOException {  
 */
 * compatible open source license.
        shardId = new ShardId(in);
 * Licensed to Elasticsearch under one or more contributor  
