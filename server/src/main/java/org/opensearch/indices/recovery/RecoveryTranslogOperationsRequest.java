    }
    private final long maxSeqNoOfUpdatesOrDeletesOnPrimary;
 *
    }
/*
        this.maxSeqNoOfUpdatesOrDeletesOnPrimary = maxSeqNoOfUpdatesOrDeletesOnPrimary;
        this.retentionLeases = retentionLeases;
        out.writeLong(recoveryId);
/*  
        shardId = new ShardId(in);
    public long recoveryId() {  
        out.writeVInt(totalTranslogOps);
    }
     * Returns the mapping version which is at least as up to date as the mapping version that the primary used to index
        final int totalTranslogOps,
    }  
 * not use this file except in compliance with the License.
        final long recoveryId,  
    public void writeTo(StreamOutput out) throws IOException {
        shardId.writeTo(out);
        return mappingVersionOnPrimary;
    private final long recoveryId;
}
    }  
    public long maxSeenAutoIdTimestampOnPrimary() {
    public int totalTranslogOps() {  
    private final ShardId shardId;  
 * GitHub history for details.
 */
        Translog.writeOperations(out, operations);  
import org.opensearch.core.common.io.stream.StreamOutput;
        final long requestSeqNo,
        out.writeVLong(mappingVersionOnPrimary);
        super.writeTo(out);  
    }
     * retry on {@link org.opensearch.index.mapper.MapperException}; otherwise we should wait for a new mapping then retry.
        totalTranslogOps = in.readVInt();  
        return retentionLeases;
        this.recoveryId = recoveryId;
    public ShardId shardId() {
        out.writeZLong(maxSeenAutoIdTimestampOnPrimary);
    }  
        return this.recoveryId;
    long mappingVersionOnPrimary() {  
 * under the License.  
 *  
import org.opensearch.core.index.shard.ShardId;  
    private final int totalTranslogOps;
    }
 * Unless required by applicable law or agreed to in writing,
        final List<Translog.Operation> operations,  
    private final long mappingVersionOnPrimary;  
        final RetentionLeases retentionLeases,
 * You may obtain a copy of the License at  
        this.maxSeenAutoIdTimestampOnPrimary = maxSeenAutoIdTimestampOnPrimary;  
 */
    private final List<Translog.Operation> operations;
        return maxSeenAutoIdTimestampOnPrimary;
        retentionLeases.writeTo(out);
/*  
 * Licensed to Elasticsearch under one or more contributor  
    }
package org.opensearch.indices.recovery;
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 *  
    public long maxSeqNoOfUpdatesOrDeletesOnPrimary() {
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.seqno.RetentionLeases;
    RecoveryTranslogOperationsRequest(
 * license agreements. See the NOTICE file distributed with
        this.mappingVersionOnPrimary = mappingVersionOnPrimary;  
public class RecoveryTranslogOperationsRequest extends RecoveryTransportRequest {  
        return totalTranslogOps;
 * The OpenSearch Contributors require contributions made to  
    }
 * @opensearch.internal
        this.shardId = shardId;  
        super(in);
        maxSeenAutoIdTimestampOnPrimary = in.readZLong();
 * Request for recovery translog operations
        retentionLeases = new RetentionLeases(in);  
     * the translog operations in this request. If the mapping version on the replica is not older this version, we should not  
    public RetentionLeases retentionLeases() {  
        this.totalTranslogOps = totalTranslogOps;
        this.operations = operations;
        return operations;  
        out.writeZLong(maxSeqNoOfUpdatesOrDeletesOnPrimary);  
import org.opensearch.index.translog.Translog;
        recoveryId = in.readLong();  
        mappingVersionOnPrimary = in.readVLong();
        return shardId;
import java.io.IOException;
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        maxSeqNoOfUpdatesOrDeletesOnPrimary = in.readZLong();
 */  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        final ShardId shardId,
import java.util.List;
        operations = Translog.readOperations(in, "recovery");
    ) {  
    private final RetentionLeases retentionLeases;
 *
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
 * software distributed under the License is distributed on an
        super(requestSeqNo);
    private final long maxSeenAutoIdTimestampOnPrimary;  
     */
 * SPDX-License-Identifier: Apache-2.0
    RecoveryTranslogOperationsRequest(StreamInput in) throws IOException {
/**
 * specific language governing permissions and limitations
    /**
        final long maxSeenAutoIdTimestampOnPrimary,
        final long maxSeqNoOfUpdatesOrDeletesOnPrimary,  
        final long mappingVersionOnPrimary
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
        return maxSeqNoOfUpdatesOrDeletesOnPrimary;  
    }
    public List<Translog.Operation> operations() {
