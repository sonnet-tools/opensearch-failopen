        super(in);
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
    private final String targetAllocationId;
 * this work for additional information regarding copyright
        this.targetAllocationId = targetAllocationId;
 * this file be licensed under the Apache-2.0 license or a
        this.recoveryId = recoveryId;  
 */  
    public ReestablishRecoveryRequest(StreamInput in) throws IOException {
/**
        this.shardId = shardId;
    }  
    }
 * not use this file except in compliance with the License.
    }  
    public String targetAllocationId() {
    }
        return this.recoveryId;  
 * compatible open source license.
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.index.shard.ShardId;  
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
 * @opensearch.internal
 *  
        out.writeString(targetAllocationId);
import org.opensearch.core.common.io.stream.StreamInput;
 * specific language governing permissions and limitations
        out.writeLong(recoveryId);
        targetAllocationId = in.readString();
/*  
    public void writeTo(StreamOutput out) throws IOException {  
    public ShardId shardId() {  
    @Override
        shardId = new ShardId(in);
    public long recoveryId() {
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.indices.recovery;
import org.opensearch.transport.TransportRequest;
 */
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    private final ShardId shardId;
 *
    }
public class ReestablishRecoveryRequest extends TransportRequest {
        shardId.writeTo(out);  
/*  
 * Represents a request for starting a peer recovery.  
}  
/*
 * ownership. Elasticsearch licenses this file to you under  
        return shardId;
 * KIND, either express or implied.  See the License for the
        recoveryId = in.readLong();  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    private final long recoveryId;  
 * software distributed under the License is distributed on an
        super.writeTo(out);
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 *
    public ReestablishRecoveryRequest(final long recoveryId, final ShardId shardId, final String targetAllocationId) {
        return targetAllocationId;
    }  
