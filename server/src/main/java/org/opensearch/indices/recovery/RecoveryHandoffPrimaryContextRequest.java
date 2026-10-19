 */  
        final ShardId shardId,  
        final long recoveryId,
     *
/*  
     * @param primaryContext the primary context
        return primaryContext;
class RecoveryHandoffPrimaryContextRequest extends TransportRequest {
     */
 * GitHub history for details.
            + primaryContext  
        this.primaryContext = primaryContext;
            + ", primaryContext="
    long recoveryId() {
 * You may obtain a copy of the License at  
        recoveryId = in.readLong();
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
/*
    ) {
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.index.seqno.ReplicationTracker;
 * license agreements. See the NOTICE file distributed with
    @Override
        primaryContext = new ReplicationTracker.PrimaryContext(in);  
    }
        this.shardId = shardId;
    private long recoveryId;
        out.writeLong(recoveryId);
    }
 */  
 */
            + "recoveryId="
    }
import org.opensearch.core.common.io.stream.StreamInput;
    ReplicationTracker.PrimaryContext primaryContext() {
 * not use this file except in compliance with the License.
    private ShardId shardId;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.index.shard.ShardId;  
    public String toString() {
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.transport.TransportRequest;
 */
 *  
        return "RecoveryHandoffPrimaryContextRequest{"  
 * Licensed to Elasticsearch under one or more contributor  
/**  
        shardId = new ShardId(in);
 * compatible open source license.
        super(in);  
        return this.recoveryId;  
 *
        super.writeTo(out);
 * @opensearch.internal  
     * @param shardId        the shard ID of the relocation
/*  
    }  
     * Initialize an empty request (used to serialize into when reading from a stream).  
        primaryContext.writeTo(out);
        shardId.writeTo(out);  
     */  
    /**  
    }  
 * The request object to handoff the primary context to the relocation target.
        final ReplicationTracker.PrimaryContext primaryContext
        return shardId;
    }
    public void writeTo(final StreamOutput out) throws IOException {  
 *
    RecoveryHandoffPrimaryContextRequest(
}  
        this.recoveryId = recoveryId;  
    private ReplicationTracker.PrimaryContext primaryContext;  
 * ownership. Elasticsearch licenses this file to you under  
            + ", shardId="  
    RecoveryHandoffPrimaryContextRequest(StreamInput in) throws IOException {
    ShardId shardId() {  
 *
            + shardId
 * this file be licensed under the Apache-2.0 license or a
    /**
 * specific language governing permissions and limitations
            + '}';
 * software distributed under the License is distributed on an
 * under the License.  
    }
            + recoveryId
     * Initialize a request for the specified relocation.
 * Unless required by applicable law or agreed to in writing,
     * @param recoveryId     the recovery ID of the relocation  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
package org.opensearch.indices.recovery;
