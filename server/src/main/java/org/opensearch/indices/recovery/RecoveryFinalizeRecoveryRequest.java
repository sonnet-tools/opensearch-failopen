    private final long globalCheckpoint;
/**
/*  
        this.shardId = shardId;  
/*  
 */
        trimAboveSeqNo = in.readZLong();  
    public void writeTo(StreamOutput out) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
    RecoveryFinalizeRecoveryRequest(StreamInput in) throws IOException {
final class RecoveryFinalizeRecoveryRequest extends RecoveryTransportRequest {  
    private final long trimAboveSeqNo;
        return this.recoveryId;  
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public ShardId shardId() {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamInput;
        out.writeLong(recoveryId);  
 * license agreements. See the NOTICE file distributed with
        shardId.writeTo(out);
    public long globalCheckpoint() {
    private final long recoveryId;
import org.opensearch.core.index.shard.ShardId;  
import org.opensearch.core.common.io.stream.StreamOutput;
 * under the License.  
    public long recoveryId() {
 * this work for additional information regarding copyright
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        return globalCheckpoint;
 *
 * Modifications Copyright OpenSearch Contributors. See
        this.trimAboveSeqNo = trimAboveSeqNo;
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
 * Request to finalize recovery
    public long trimAboveSeqNo() {
 * GitHub history for details.
    @Override  
        final ShardId shardId,  
        this.globalCheckpoint = globalCheckpoint;
        out.writeZLong(globalCheckpoint);
 * KIND, either express or implied.  See the License for the
        return shardId;
        return trimAboveSeqNo;  
        super.writeTo(out);
 * not use this file except in compliance with the License.
    RecoveryFinalizeRecoveryRequest(  
    }
 */
    }
 * compatible open source license.
        recoveryId = in.readLong();  
        final long globalCheckpoint,
}  
    }
        final long trimAboveSeqNo
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 * SPDX-License-Identifier: Apache-2.0
    private final ShardId shardId;  
        globalCheckpoint = in.readZLong();
package org.opensearch.indices.recovery;
 * software distributed under the License is distributed on an
    ) {  
    }
 *  
 * The OpenSearch Contributors require contributions made to  
        super(requestSeqNo);
    }
 */  
 *
        final long requestSeqNo,
        final long recoveryId,
 * the Apache License, Version 2.0 (the "License"); you may
 *  
        out.writeZLong(trimAboveSeqNo);  
        shardId = new ShardId(in);
 */  
    }  
 * specific language governing permissions and limitations
/*
        super(in);
        this.recoveryId = recoveryId;
