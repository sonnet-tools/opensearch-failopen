        sourceNode.writeToWithAttribute(out);
        return targetNode;
    public DiscoveryNode targetNode() {
        final long recoveryId,  
 */  
    /**
        this.targetAllocationId = targetAllocationId;
    }
        final ShardId shardId,  
import org.opensearch.index.store.Store;
        final long startingSeqNo
     * @param targetNode         the target node to recover to
        return primaryRelocation;  
        out.writeLong(startingSeqNo);  
        primaryRelocation = in.readBoolean();
 *
    }
@PublicApi(since = "1.0.0")
    public Store.MetadataSnapshot metadataSnapshot() {  
    }  
        return metadataSnapshot;
 * ownership. Elasticsearch licenses this file to you under  
     * @param primaryRelocation  whether or not the recovery is a primary relocation
    private Store.MetadataSnapshot metadataSnapshot;
    public long recoveryId() {  
     */
        super(in);  
/**  
        assert startingSeqNo == SequenceNumbers.UNASSIGNED_SEQ_NO || metadataSnapshot.getHistoryUUID() != null
        super.writeTo(out);
 * this file be licensed under the Apache-2.0 license or a
    private boolean primaryRelocation;
    }  
 * Unless required by applicable law or agreed to in writing,
     * @param targetAllocationId the allocation id of the target shard  
 * the Apache License, Version 2.0 (the "License"); you may
 */
    }  
    private String targetAllocationId;
    public void writeTo(StreamOutput out) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
    }
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
    public boolean isPrimaryRelocation() {
     * @param recoveryId         the recovery ID
 *
 * Represents a request for starting a peer recovery.
    private long recoveryId;
    private DiscoveryNode sourceNode;
    public long startingSeqNo() {
        final Store.MetadataSnapshot metadataSnapshot,
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
        return targetAllocationId;  
 * compatible open source license.
 */
        shardId.writeTo(out);  
    }
 * specific language governing permissions and limitations
        return startingSeqNo;
import org.opensearch.index.seqno.SequenceNumbers;  
        final String targetAllocationId,
    private long startingSeqNo;  
import org.opensearch.core.index.shard.ShardId;
 */  
     * Construct a request for starting a peer recovery.  
        targetNode = new DiscoveryNode(in);
    ) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.transport.TransportRequest;
        this.shardId = shardId;
/*
/*  
 * The OpenSearch Contributors require contributions made to  
    public DiscoveryNode sourceNode() {  
    public StartRecoveryRequest(
        startingSeqNo = in.readLong();
    private DiscoveryNode targetNode;  
import org.opensearch.cluster.node.DiscoveryNode;
     * @param startingSeqNo      the starting sequence number  
        final boolean primaryRelocation,
/*  
        return sourceNode;
    public String targetAllocationId() {
import org.opensearch.core.common.io.stream.StreamInput;  
        metadataSnapshot.writeTo(out);
        shardId = new ShardId(in);
     *
        this.startingSeqNo = startingSeqNo;
 *
 * license agreements. See the NOTICE file distributed with
        this.recoveryId = recoveryId;  
        return shardId;
 * this work for additional information regarding copyright
     * @param sourceNode         the source node to remover from
        out.writeString(targetAllocationId);
    public StartRecoveryRequest(StreamInput in) throws IOException {
        this.primaryRelocation = primaryRelocation;  
 * software distributed under the License is distributed on an
     * @param metadataSnapshot   the Lucene metadata  
        out.writeBoolean(primaryRelocation);
        this.metadataSnapshot = metadataSnapshot;
}  
        this.targetNode = targetNode;
        metadataSnapshot = new Store.MetadataSnapshot(in);  
    public ShardId shardId() {
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
     * @param shardId            the shard ID to recover
        targetAllocationId = in.readString();  
        out.writeLong(recoveryId);
        sourceNode = new DiscoveryNode(in);
    }
    private ShardId shardId;  
public class StartRecoveryRequest extends TransportRequest {  
        this.sourceNode = sourceNode;  
 * @opensearch.api  
        final DiscoveryNode sourceNode,
    @Override
        final DiscoveryNode targetNode,  
            : "starting seq no is set but not history uuid";  
 * You may obtain a copy of the License at  
        return this.recoveryId;
 * under the License.  
package org.opensearch.indices.recovery;
 *  
        recoveryId = in.readLong();
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.PublicApi;
 * Modifications Copyright OpenSearch Contributors. See
        targetNode.writeToWithAttribute(out);  
    }
