            this.primaryAllocationId = primaryAllocationId;
            String primaryAllocationId,
        @PublicApi(since = "1.0.0")
            public void onResponse(Void ignore) {
     *
                );
            Task parentTask,
                builder.field("phase", phase);
                public synchronized Translog.Operation next() throws IOException {
        private final ShardId shardId;
            assert startingSeqNo >= 0 : "startingSeqNo must be non-negative; got [" + startingSeqNo + "]";
                if (o == null || getClass() != o.getClass()) return false;
                listener.onFailure(e);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            // Also fail the resync early if the shard is shutting down
        public void setTotalOperations(int totalOperations) {
        private final long maxSeqNo;
        void sync(
        @Override
import org.opensearch.core.xcontent.XContentBuilder;
            long size = 0;
                    } finally {
                    operations.toArray(EMPTY_ARRAY)
        @Override
                    maxSeenAutoIdTimestamp,
                        throw new IndexShardClosedException(shardId);
        }
            this.shardId = shardId;
                }
                builder.endObject();
            long primaryTerm,
        ResyncTask resyncTask = (ResyncTask) taskManager.register("transport", "resync", request); // it's not transport :-)
                wrappedListener
import java.io.IOException;
         * Get the current phase of the task.
import org.opensearch.common.util.concurrent.AbstractRunnable;
    }
        ActionListener<ResyncTask> listener
            final long trimAboveSeqNo = firstMessage.get() ? startingSeqNo - 1 : SequenceNumbers.UNASSIGNED_SEQ_NO;
            ActionListener<Void> listener
import java.util.Map;
                totalOperations = in.readVInt();
        public ActionRequestValidationException validate() {
         */
import org.opensearch.transport.TransportService;
                result = 31 * result + resyncedOperations;
    static class SnapshotSender extends AbstractRunnable implements ActionListener<ResyncReplicationResponse> {
        @Override
                        listener.onFailure(e);
        public ResyncTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers) {
            public Status(String phase, int totalOperations, int resyncedOperations, int skippedOperations) {
            this.totalOperations = totalOperations;
            }
            new SnapshotSender(
        try {
            ActionListener<ResyncReplicationResponse> listener
package org.opensearch.index.shard;
        }
        }
        private final Logger logger;
        }
        }
        } catch (Exception e) {
            }
        Translog.Snapshot snapshot = null;
                ResyncReplicationRequest request = new ResyncReplicationRequest(
            if (closed.compareAndSet(false, true)) {
        }
                IOUtils.close(snapshot);
                builder.field("skippedOperations", skippedOperations);
                return result;
     */
 * You may obtain a copy of the License at
        final Translog.Snapshot snapshot,
            final List<Translog.Operation> operations = new ArrayList<>();
            throw new IllegalArgumentException("chunkSize must be > 0");
    private static final Logger logger = LogManager.getLogger(PrimaryReplicaSyncer.class);
                wrappedSnapshot,
            }
            task.setResyncedOperations(totalSentOps.get());
        private final long startingSeqNo;
    }
                    }
            public String getWriteableName() {
}
        }
            }
            return skippedOperations;
        }
            this.task = task;
                result = 31 * result + skippedOperations;
         */
                public synchronized int totalOperations() {
                @Override
        final long primaryTerm,
                maxSeenAutoIdTimestamp,
                startingSeqNo,
                syncAction.sync(request, task, primaryAllocationId, primaryTerm, this);
            // Even though those calls are not concurrent, snapshot.next() uses non-synchronized state and is not multi-thread-compatible
        this.taskManager = taskManager;
                        wrappedSnapshot.close();
                assert operation.seqNo() >= 0 : "sending operation with unassigned sequence number [" + operation + "]";
import org.opensearch.tasks.TaskManager;
         */
                    continue;
                maxSeqNo,
                resyncTask,
                @Override
            ShardId shardId,
         */
    @Inject
            }
                snapshot,
            // have to send sync request even in case of there are no operations to sync - have to sync trimAboveSeqNo at least
            public boolean equals(Object o) {
            }
                this.totalOperations = totalOperations;
        }
                phase = in.readString();
         * total number of translog operations that were captured by translog snapshot
                }
import org.opensearch.core.common.unit.ByteSizeUnit;
                primaryTerm,
            }
            @Override
import org.apache.logging.log4j.LogManager;
                    totalSentOps.get(),
    private final SyncAction syncAction;
            // that the auto_id_timestamp of every operation in the snapshot is at most this value.
 * this file be licensed under the Apache-2.0 license or a
                @Override
                resyncTask.setPhase("finished");
                    } catch (final Exception inner) {
import java.util.concurrent.atomic.AtomicBoolean;
     * Synchronous action
 * @opensearch.internal
        private final AtomicInteger totalSkippedOps = new AtomicInteger();
            return null;
        @Override
    }
                    return originalSnapshot.totalOperations();
            Translog.Snapshot snapshot,
    public interface SyncAction {
        private volatile int skippedOperations;
     * @opensearch.internal
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
public class PrimaryReplicaSyncer {
            }
                    trimAboveSeqNo,
                    "{} sending batch of [{}][{}] (total sent: [{}], skipped: [{}])",
                public void onResponse(final ResyncTask resyncTask) {
                }
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.util.List;
 * this work for additional information regarding copyright
                task.setPhase("sending_ops");
            // Wrap translog snapshot to make it synchronized as it is accessed by different threads through SnapshotSender.
        @Override
        private volatile int totalOperations;
            public static final String NAME = "resync";
        ActionListener<Void> wrappedListener = new ActionListener<Void>() {
        @Override
                resyncTask.setPhase("finished");
         * number of operations that have been successfully replicated
 * license agreements. See the NOTICE file distributed with
import org.opensearch.tasks.Task;
            final Translog.Snapshot originalSnapshot = snapshot;
        long maxSeqNo,
         */
                    } catch (final Exception e) {
                    try {
     *
        public void setResyncedOperations(int resyncedOperations) {
                public void onFailure(final Exception e) {
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * Syncer for Primary replica
                if (seqNo == SequenceNumbers.UNASSIGNED_SEQ_NO || seqNo < startingSeqNo) {
            private final int totalOperations;
        }
            this.allocationId = allocationId;
    void setChunkSize(ByteSizeValue chunkSize) { // only settable for tests
 */
            }
            @Override
 * Unless required by applicable law or agreed to in writing,
        public void setPhase(String phase) {
        private final AtomicBoolean firstMessage = new AtomicBoolean(true);
 */
                if (totalOperations != status.totalOperations) return false;
     */
        /**
        public String toString() {
import org.opensearch.index.seqno.SequenceNumbers;
 *
        }
 * GitHub history for details.
            return totalOperations;
 * Modifications Copyright OpenSearch Contributors. See
            this.maxSeqNo = maxSeqNo;
 */
    /**
            task.setTotalOperations(snapshot.totalOperations());
            }
                    } else {
    public void resync(final IndexShard indexShard, final ActionListener<ResyncTask> listener) {
                    if (state == IndexShardState.CLOSED) {
            };
                this.phase = requireNonNull(phase, "Phase cannot be null");
import org.opensearch.action.ActionRequest;
                        onFailure(e);
        /**
            } catch (IOException inner) {
                if (this == o) return true;
        public int getSkippedOperations() {
                firstMessage.set(false);
                // check if this request is past bytes threshold, and if so, send it off
            final long maxSeqNo = indexShard.seqNoStats().getMaxSeqNo();
    /**
                skippedOperations = in.readVInt();
        final ShardId shardId,
                        wrappedSnapshot.close();
            private final int skippedOperations;
        }
            String primaryAllocationId,
                    totalSkippedOps.incrementAndGet();
                this.skippedOperations = skippedOperations;
        ResyncRequest request = new ResyncRequest(shardId, primaryAllocationId);
                    try {
        /**
import org.opensearch.common.util.io.IOUtils;
    /**
                shardId,
        public void setSkippedOperations(int skippedOperations) {
            try {
            public int hashCode() {
    // for tests
 * compatible open source license.
                taskManager.unregister(resyncTask);
import org.apache.logging.log4j.Logger;
            );
     * @opensearch.internal
 * software distributed under the License is distributed on an
            ResyncTask task,
                return NAME;
                return builder;
        private final int chunkSizeInBytes;
 * under the License.
            private final int resyncedOperations;
 *
                    operations.size(),
                out.writeVLong(totalOperations);
                logger.trace(
                        assert state == IndexShardState.STARTED : "resync should only happen on a started shard, but state was: " + state;
        private final Translog.Snapshot snapshot;
        private final String primaryAllocationId;
        try {
 */
import org.opensearch.core.index.shard.ShardId;
    public static class ResyncRequest extends ActionRequest {
        };
        this.chunkSize = chunkSize;
        @Override
                listener.onFailure(e);
    /**
        }
                }
                builder.field("resyncedOperations", resyncedOperations);
         *
        final String primaryAllocationId,
                int result = phase.hashCode();
            @Override
            long primaryTerm,
            final long maxSeenAutoIdTimestamp = indexShard.getMaxSeenAutoIdTimestamp();
     * Sends a snapshot
    private final TaskManager taskManager;
            this.primaryTerm = primaryTerm;
                size += operation.estimateSize();
import org.opensearch.action.resync.ResyncReplicationRequest;
                Status status = (Status) o;
    }
            long maxSeenAutoIdTimestamp,
import org.opensearch.core.tasks.TaskId;
            this.shardId = shardId;
        /**
import org.opensearch.core.common.unit.ByteSizeValue;
 * Licensed to Elasticsearch under one or more contributor
            this.logger = PrimaryReplicaSyncer.logger;
            return phase;
            return toString();
                listener.onResponse(null);
import java.util.ArrayList;
                @Override
                out.writeVLong(resyncedOperations);
        private final AtomicInteger totalSentOps = new AtomicInteger();
            if (!operations.isEmpty() || trimAboveSeqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
    public PrimaryReplicaSyncer(TaskManager taskManager, SyncAction syncAction) {
         * number of translog operations that have been skipped
    @PublicApi(since = "1.0.0")
        public void onFailure(Exception e) {
    }
        /**
        }
     *
                }
                chunkSize.bytesAsInt(),
     * @opensearch.api
                listener.onFailure(e);
                public synchronized void close() throws IOException {
     */
 *
        public String getDescription() {
                out.writeString(phase);
            return "ResyncRequest{ " + shardId + ", " + allocationId + " }";
/*
        }
    public static class ResyncTask extends Task {
            return new ResyncTask.Status(phase, totalOperations, resyncedOperations, skippedOperations);
            @Override
        if (chunkSize.bytesAsInt() <= 0) {
 * specific language governing permissions and limitations
            }
    }
            task.setSkippedOperations(totalSkippedOps.get());
 *
        public static class Status implements Task.Status {
        private final ShardId shardId;
                    shardId,
            final long startingSeqNo = indexShard.getLastKnownGlobalCheckpoint() + 1;
import org.opensearch.core.common.Strings;
        }
import static java.util.Objects.requireNonNull;
                taskManager.unregister(resyncTask);
 * KIND, either express or implied.  See the License for the
        } catch (Exception e) {
                    IndexShardState state = indexShard.state();
                builder.field("totalOperations", totalOperations);
        }
            final Translog.Snapshot wrappedSnapshot = new Translog.Snapshot() {
            this.phase = phase;
import org.opensearch.core.action.ActionListener;
                shardId,
            } else if (closed.compareAndSet(false, true)) {
            public Status(StreamInput in) throws IOException {
     * Request to resync primary and replica
                    shardId,
        protected void doRun() throws Exception {
        /**
            long startingSeqNo,
import org.opensearch.core.common.io.stream.StreamInput;
         * Status for primary replica syncer
 * The OpenSearch Contributors require contributions made to
        private final String allocationId;
                return Strings.toString(MediaTypeRegistry.JSON, this);
                resyncedOperations = in.readVInt();
        public void onResponse(ResyncReplicationResponse response) {
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.action.resync.ResyncReplicationResponse;
        SnapshotSender(
        private final long maxSeenAutoIdTimestamp;
            Translog.Operation operation;
                        e.addSuppressed(inner);
         * @opensearch.api
            } finally {
                listener.onResponse(resyncTask);
        public String getPhase() {
            // We must capture the timestamp after snapshotting a snapshot of operations to make sure
        public int getResyncedOperations() {
         * Set the current phase of the task.
    private volatile ByteSizeValue chunkSize = DEFAULT_CHUNK_SIZE;
            resync(
        public ResyncTask.Status getStatus() {
            ).run();
         */
                resyncListener
    ) {
            run();
                maxSeenAutoIdTimestamp,
                }
                this.resyncedOperations = resyncedOperations;
import org.opensearch.action.ActionRequestValidationException;
                    return originalSnapshot.next();
    }
            }
                if (size >= chunkSizeInBytes) {
    private void resync(
                e.addSuppressed(inner);
        private final AtomicBoolean closed = new AtomicBoolean();
    public PrimaryReplicaSyncer(TransportService transportService, TransportResyncReplicationAction syncAction) {
                    break;
            wrappedListener.onFailure(e);
            private final String phase;
            this.chunkSizeInBytes = chunkSizeInBytes;
        private final ResyncTask task; // to track progress
                totalSentOps.incrementAndGet();
            this.listener = listener;
                builder.startObject();
        private final ActionListener<Void> listener;
            while ((operation = snapshot.next()) != null) {
            super(id, type, action, description, parentTaskId, headers);
/*
import org.opensearch.index.translog.Translog;
            }
     * Task to resync primary and replica
                indexShard.routingEntry().allocationId().getId(),
                );
            };
                    originalSnapshot.close();
    }
            final ActionListener<ResyncTask> resyncListener = new ActionListener<ResyncTask>() {
                    }
                primaryAllocationId,
            snapshot = indexShard.newChangesSnapshot("resync", startingSeqNo, Long.MAX_VALUE, false, true);
        public int getTotalOperations() {
            this.startingSeqNo = startingSeqNo;
            long maxSeqNo,
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
            }
            ResyncReplicationRequest request,
        }
                    totalSkippedOps.get()
     */
            @Override
                }
                logger.trace("{} resync completed (total sent: [{}], skipped: [{}])", shardId, totalSentOps.get(), totalSkippedOps.get());
import org.opensearch.common.annotation.PublicApi;
                    new ByteSizeValue(size),
            @Override
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.common.inject.Inject;
                    }
        this(transportService.getTaskManager(), syncAction);
        private volatile int resyncedOperations;
            this.syncAction = syncAction;
     * @opensearch.internal
                syncAction,
        @Override
                operations.add(operation);
        long startingSeqNo,
            public void writeTo(StreamOutput out) throws IOException {
        );
                return phase.equals(status.phase);
                if (resyncedOperations != status.resyncedOperations) return false;
     *
            task.setPhase("collecting_ops");
                indexShard.getPendingPrimaryTerm(),
                result = 31 * result + totalOperations;
import org.opensearch.action.resync.TransportResyncReplicationAction;
                startingSeqNo,
    public static final ByteSizeValue DEFAULT_CHUNK_SIZE = new ByteSizeValue(512, ByteSizeUnit.KB);
            this.skippedOperations = skippedOperations;
    }
/*
                        listener.onResponse(resyncTask);
        private static final Translog.Operation[] EMPTY_ARRAY = new Translog.Operation[0];
        private final SyncAction syncAction;
        }
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
                if (skippedOperations != status.skippedOperations) return false;
        }
                maxSeqNo,
            SyncAction syncAction,
        }
                @Override
            @Override
        long maxSeenAutoIdTimestamp,
            return resyncedOperations;
            this.resyncedOperations = resyncedOperations;
            return new ResyncTask(id, type, action, getDescription(), parentTaskId, headers);
        this.syncAction = syncAction;
            int chunkSizeInBytes,
        ) {
 * the Apache License, Version 2.0 (the "License"); you may
        private final long primaryTerm;
            public void onFailure(Exception e) {
            public String toString() {
            this.maxSeenAutoIdTimestamp = maxSeenAutoIdTimestamp;
        private volatile String phase = "starting";
            final ShardId shardId = indexShard.shardId();
            @Override
                out.writeVLong(skippedOperations);
            this.snapshot = snapshot;
        }
        public ResyncRequest(ShardId shardId, String allocationId) {
import java.util.concurrent.atomic.AtomicInteger;
                final long seqNo = operation.seqNo();
