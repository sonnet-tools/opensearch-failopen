    }
    @Override  
 * specific language governing permissions and limitations
    }  
            return true;  
        this.status = status;
 * software distributed under the License is distributed on an
        super(in);
        return Objects.hash(snapshot, shardId, status);
    }
 * The OpenSearch Contributors require contributions made to  
    }  
 * Internal request that is used to send changes in snapshot status to master  
        this.shardId = shardId;  
public class UpdateIndexShardSnapshotStatusRequest extends ClusterManagerNodeRequest<UpdateIndexShardSnapshotStatusRequest> {
            return false;  
        return null;
    public boolean equals(final Object o) {
 * You may obtain a copy of the License at  
/*  
import org.opensearch.cluster.SnapshotsInProgress;
    @Override
 * under the License.  
        shardId = new ShardId(in);  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
 * this work for additional information regarding copyright
 *
    public UpdateIndexShardSnapshotStatusRequest(StreamInput in) throws IOException {  
    public ShardId shardId() {
/**
    public int hashCode() {
 */
    public ActionRequestValidationException validate() {
import org.opensearch.core.common.io.stream.StreamOutput;
 * GitHub history for details.
        snapshot = new Snapshot(in);
    }
        status.writeTo(out);
        return snapshot + ", shardId [" + shardId + "], status [" + status.state() + "]";  
        return snapshot.equals(that.snapshot) && shardId.equals(that.shardId) && status.equals(that.status);  
    }
 *
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
    public UpdateIndexShardSnapshotStatusRequest(Snapshot snapshot, ShardId shardId, SnapshotsInProgress.ShardSnapshotStatus status) {
 * Modifications Copyright OpenSearch Contributors. See  
 *  
    private final Snapshot snapshot;
/*
 * KIND, either express or implied.  See the License for the
    private final SnapshotsInProgress.ShardSnapshotStatus status;
        return shardId;  
    private final ShardId shardId;  
    @Override  
}
        this.clusterManagerNodeTimeout = TimeValue.timeValueNanos(Long.MAX_VALUE);  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamInput;
        }
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.action.ActionRequestValidationException;  
 */  
        // By default, we keep trying to post snapshot status messages to avoid snapshot processes getting stuck.
    }  
        if (this == o) {
 * Unless required by applicable law or agreed to in writing,
        snapshot.writeTo(out);
 */
        return snapshot;
    }
 * ownership. Elasticsearch licenses this file to you under  
    public Snapshot snapshot() {
import org.opensearch.core.index.shard.ShardId;  
 * license agreements. See the NOTICE file distributed with
    public SnapshotsInProgress.ShardSnapshotStatus status() {  
package org.opensearch.snapshots;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (o == null || getClass() != o.getClass()) {
        }
        return status;
    public void writeTo(StreamOutput out) throws IOException {  
        this.snapshot = snapshot;
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 */  
        super.writeTo(out);
        final UpdateIndexShardSnapshotStatusRequest that = (UpdateIndexShardSnapshotStatusRequest) o;
    }
import java.io.IOException;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        status = SnapshotsInProgress.ShardSnapshotStatus.readFrom(in);
/*
    @Override
import java.util.Objects;  
        shardId.writeTo(out);  
 * not use this file except in compliance with the License.
    public String toString() {
 *
    }
