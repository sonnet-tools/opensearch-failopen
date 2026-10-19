    public long recoveryId() {  
        snapshotFiles.writeTo(out);  
        super(requestSeqNo);
        out.writeZLong(globalCheckpoint);
 * GitHub history for details.
public class RecoveryCleanFilesRequest extends RecoveryTransportRequest {
        globalCheckpoint = in.readZLong();
        return this.recoveryId;
        return shardId;
 * Licensed to Elasticsearch under one or more contributor  
        long globalCheckpoint  
        this.recoveryId = recoveryId;  
    public Store.MetadataSnapshot sourceMetaSnapshot() {
    }
/*  
    }
        snapshotFiles = new Store.MetadataSnapshot(in);
    private final ShardId shardId;
        this.shardId = shardId;
        super.writeTo(out);  
 */  
 * The OpenSearch Contributors require contributions made to  
        Store.MetadataSnapshot snapshotFiles,
    }  
 *  
        return snapshotFiles;  
    public RecoveryCleanFilesRequest(  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
    private final int totalTranslogOps;  
        int totalTranslogOps,
        this.snapshotFiles = snapshotFiles;
        this.globalCheckpoint = globalCheckpoint;
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public int totalTranslogOps() {
        long recoveryId,
import org.opensearch.index.store.Store;
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
    private final long globalCheckpoint;
 *
    public ShardId shardId() {
    private final Store.MetadataSnapshot snapshotFiles;
        ShardId shardId,  
}  
    @Override
        recoveryId = in.readLong();  
        this.totalTranslogOps = totalTranslogOps;  
/*  
 *
        long requestSeqNo,
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;  
    private final long recoveryId;  
 * SPDX-License-Identifier: Apache-2.0
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void writeTo(StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        out.writeVInt(totalTranslogOps);
        return globalCheckpoint;
 * under the License.  
import org.opensearch.core.common.io.stream.StreamOutput;
        return totalTranslogOps;  
        out.writeLong(recoveryId);
package org.opensearch.indices.recovery;
import org.opensearch.core.common.io.stream.StreamInput;
    }  
 */  
 */  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    }
    RecoveryCleanFilesRequest(StreamInput in) throws IOException {
import org.opensearch.core.index.shard.ShardId;  
/*
        super(in);
/**
 * @opensearch.internal
 *
    public long getGlobalCheckpoint() {  
 * Request to clean up recovery files  
 * specific language governing permissions and limitations
    }
        shardId.writeTo(out);
    }
    }
        shardId = new ShardId(in);
 * the Apache License, Version 2.0 (the "License"); you may
    ) {
        totalTranslogOps = in.readVInt();  
 * ownership. Elasticsearch licenses this file to you under  
