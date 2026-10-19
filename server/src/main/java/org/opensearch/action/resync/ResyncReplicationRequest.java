import org.opensearch.core.common.io.stream.StreamInput;
    public Translog.Operation[] getOperations() {  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * compatible open source license.
        if (this == o) return true;
/*
package org.opensearch.action.resync;
 * Modifications Copyright OpenSearch Contributors. See  
            + '\''  
            + timeout  
        return operations;
        final ResyncReplicationRequest that = (ResyncReplicationRequest) o;
        final Translog.Operation[] operations
    }
            + shardId
 * software distributed under the License is distributed on an
            && maxSeenAutoIdTimestampOnPrimary == that.maxSeenAutoIdTimestampOnPrimary  
        out.writeZLong(maxSeenAutoIdTimestampOnPrimary);
    }
 *  
 *  
        out.writeZLong(trimAboveSeqNo);
        super(in);
            + maxSeenAutoIdTimestampOnPrimary
    public void writeTo(final StreamOutput out) throws IOException {
            + "shardId="  
 * KIND, either express or implied.  See the License for the
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public long getMaxSeenAutoIdTimestampOnPrimary() {
    public int hashCode() {
        out.writeArray(Translog.Operation::writeOperation, operations);  
public final class ResyncReplicationRequest extends ReplicatedWriteRequest<ResyncReplicationRequest> {  
    }
        return maxSeenAutoIdTimestampOnPrimary;  
        this.maxSeenAutoIdTimestampOnPrimary = maxSeenAutoIdTimestampOnPrimary;  
            + ", ops="
            + ", trimAboveSeqNo="
import java.util.Arrays;
    @Override
    }
            + operations.length  
    public ResyncReplicationRequest(
        trimAboveSeqNo = in.readZLong();
}
            + ", maxSeenAutoIdTimestampOnPrimary="  
 * SPDX-License-Identifier: Apache-2.0
        return Objects.hash(trimAboveSeqNo, maxSeenAutoIdTimestampOnPrimary, Arrays.hashCode(operations));  
 * under the License.  
    private final long maxSeenAutoIdTimestampOnPrimary;
            + "}";
        super(shardId);
    ) {  
    @Override
 * GitHub history for details.
        this.operations = operations;
            + ", timeout="
import org.opensearch.action.support.replication.ReplicatedWriteRequest;  
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.index.translog.Translog;
            + index
        this.trimAboveSeqNo = trimAboveSeqNo;
            + ", index='"
 *
    public boolean equals(final Object o) {
 *  @opensearch.internal
 */
        super.writeTo(out);  
/**
 */  
 */
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
    }
        final ShardId shardId,
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    public String toString() {
        if (o == null || getClass() != o.getClass()) return false;  
    @Override  
    }
        return trimAboveSeqNo;
    @Override  
            && Arrays.equals(operations, that.operations);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;  
/*
        return trimAboveSeqNo == that.trimAboveSeqNo
 * You may obtain a copy of the License at  
        final long trimAboveSeqNo,  
import org.opensearch.core.index.shard.ShardId;  
            + trimAboveSeqNo
        maxSeenAutoIdTimestampOnPrimary = in.readZLong();  
        operations = in.readArray(Translog.Operation::readOperation, Translog.Operation[]::new);
    private final long trimAboveSeqNo;
 * The OpenSearch Contributors require contributions made to  
 */
    }  
    private final Translog.Operation[] operations;  
    public long getTrimAboveSeqNo() {
import java.util.Objects;
        final long maxSeenAutoIdTimestampOnPrimary,
        return "TransportResyncReplicationAction.Request{"
 * ownership. Elasticsearch licenses this file to you under  
 * Represents a batch of operations sent from the primary to its replicas during the primary-replica resync.
 *     http://www.apache.org/licenses/LICENSE-2.0
    ResyncReplicationRequest(StreamInput in) throws IOException {  
