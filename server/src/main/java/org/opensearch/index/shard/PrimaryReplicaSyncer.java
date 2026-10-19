                maxSeqNo,  
            this.maxSeqNo = maxSeqNo;
            }
            return new ResyncTask(id, type, action, getDescription(), parentTaskId, headers);
                        assert state == IndexShardState.STARTED : "resync should only happen on a started shard, but state was: " + state;  
        public void setSkippedOperations(int skippedOperations) {
            }  
                        listener.onFailure(e);
            assert startingSeqNo >= 0 : "startingSeqNo must be non-negative; got [" + startingSeqNo + "]";
 * Unless required by applicable law or agreed to in writing,
        public ResyncTask.Status getStatus() {  
            this.skippedOperations = skippedOperations;
            String primaryAllocationId,
                    }
                public synchronized int totalOperations() {
        @Override  
            return new ResyncTask.Status(phase, totalOperations, resyncedOperations, skippedOperations);
    }  
            @Override
 */
            return null;
        private final AtomicBoolean closed = new AtomicBoolean();
                    trimAboveSeqNo,
 *
    private static final Logger logger = LogManager.getLogger(PrimaryReplicaSyncer.class);
        private volatile int resyncedOperations;
 * You may obtain a copy of the License at  
            Translog.Snapshot snapshot,  
        @Override
                }  
                resyncTask.setPhase("finished");  
            this.totalOperations = totalOperations;
/*  
        public int getTotalOperations() {
            ResyncTask task,
            public int hashCode() {  
                logger.trace("{} resync completed (total sent: [{}], skipped: [{}])", shardId, totalSentOps.get(), totalSkippedOps.get());
    public static class ResyncTask extends Task {
     * Request to resync primary and replica  
                }
                out.writeVLong(resyncedOperations);
            // Also fail the resync early if the shard is shutting down
        }  
import org.opensearch.tasks.Task;
        }  
    public PrimaryReplicaSyncer(TaskManager taskManager, SyncAction syncAction) {
                ResyncReplicationRequest request = new ResyncReplicationRequest(  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @opensearch.api
            }  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        }  
                    }  
                    totalSentOps.get(),
import org.apache.logging.log4j.LogManager;  
                        wrappedSnapshot.close();
     * @opensearch.internal
                resyncedOperations = in.readVInt();  
        public void setResyncedOperations(int resyncedOperations) {
                return builder;  
            public boolean equals(Object o) {
                        e.addSuppressed(inner);  
                task.setPhase("sending_ops");
    /**
            public void onFailure(Exception e) {  
import java.util.Map;  
                primaryTerm,  
                builder.field("skippedOperations", skippedOperations);
                    return originalSnapshot.totalOperations();  
                @Override
        public void setTotalOperations(int totalOperations) {  
        }
            return toString();  
            } catch (IOException inner) {
        public static class Status implements Task.Status {
                builder.field("phase", phase);
        }
        long maxSeenAutoIdTimestamp,
            ShardId shardId,  
                startingSeqNo,  
        ResyncRequest request = new ResyncRequest(shardId, primaryAllocationId);
            this.maxSeenAutoIdTimestamp = maxSeenAutoIdTimestamp;
                    totalSkippedOps.incrementAndGet();
        }
 * KIND, either express or implied.  See the License for the
            this.logger = PrimaryReplicaSyncer.logger;
        public String getDescription() {
            }
            ActionListener<ResyncReplicationResponse> listener  
                public synchronized Translog.Operation next() throws IOException {
        long startingSeqNo,
            this.task = task;  
            this.resyncedOperations = resyncedOperations;  
                syncAction.sync(request, task, primaryAllocationId, primaryTerm, this);  
import org.opensearch.action.resync.ResyncReplicationResponse;
 */
         * Get the current phase of the task.
                    } finally {
                final long seqNo = operation.seqNo();
            };
                builder.startObject();  
import org.opensearch.action.resync.ResyncReplicationRequest;
import org.opensearch.common.annotation.PublicApi;
         * Status for primary replica syncer
        @Override
 * not use this file except in compliance with the License.
                    shardId,
        );
    void setChunkSize(ByteSizeValue chunkSize) { // only settable for tests  
        void sync(
            long maxSeenAutoIdTimestamp,
     * Synchronous action
                }
            super(id, type, action, description, parentTaskId, headers);  
            } finally {  
            this.snapshot = snapshot;
        }
        }
            String primaryAllocationId,
                    new ByteSizeValue(size),
                return Strings.toString(MediaTypeRegistry.JSON, this);
            return totalOperations;  
                this.resyncedOperations = resyncedOperations;
            @Override
            return phase;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.transport.TransportService;
        }  
        SnapshotSender(  
    static class SnapshotSender extends AbstractRunnable implements ActionListener<ResyncReplicationResponse> {  
            snapshot = indexShard.newChangesSnapshot("resync", startingSeqNo, Long.MAX_VALUE, false, true);
            long maxSeqNo,  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
                this.skippedOperations = skippedOperations;
                result = 31 * result + totalOperations;
                size += operation.estimateSize();  
import org.opensearch.core.xcontent.XContentBuilder;
    // for tests  
                listener.onFailure(e);  
            public void onResponse(Void ignore) {
import org.opensearch.index.translog.Translog;
            final long startingSeqNo = indexShard.getLastKnownGlobalCheckpoint() + 1;
            public String toString() {  
                    continue;
                        listener.onResponse(resyncTask);
                if (o == null || getClass() != o.getClass()) return false;
 * license agreements. See the NOTICE file distributed with
import java.util.List;
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                builder.field("totalOperations", totalOperations);
                e.addSuppressed(inner);
                @Override
    public PrimaryReplicaSyncer(TransportService transportService, TransportResyncReplicationAction syncAction) {
                wrappedListener  
            final ShardId shardId = indexShard.shardId();
                this.phase = requireNonNull(phase, "Phase cannot be null");
            @Override
}  
        @Override
    @Inject
                operations.add(operation);
        if (chunkSize.bytesAsInt() <= 0) {
                return NAME;
            new SnapshotSender(
            return resyncedOperations;
     *  
            while ((operation = snapshot.next()) != null) {
        }
import org.opensearch.core.common.Strings;  
                    return originalSnapshot.next();
        /**  
 * specific language governing permissions and limitations
                if (skippedOperations != status.skippedOperations) return false;
            public String getWriteableName() {  
            if (!operations.isEmpty() || trimAboveSeqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
    /**
        }  
import static java.util.Objects.requireNonNull;
    }
            } else if (closed.compareAndSet(false, true)) {
                firstMessage.set(false);
            wrappedListener.onFailure(e);  
        public void onResponse(ResyncReplicationResponse response) {
        }
/**  
        try {  
            @Override
    private volatile ByteSizeValue chunkSize = DEFAULT_CHUNK_SIZE;
 * compatible open source license.
     * @opensearch.internal
        private final AtomicBoolean firstMessage = new AtomicBoolean(true);
                resyncTask.setPhase("finished");
            long size = 0;
        private final long maxSeenAutoIdTimestamp;
                totalSentOps.incrementAndGet();
                        wrappedSnapshot.close();  
                );
        private final AtomicInteger totalSentOps = new AtomicInteger();
                assert operation.seqNo() >= 0 : "sending operation with unassigned sequence number [" + operation + "]";
    @PublicApi(since = "1.0.0")
                        onFailure(e);  
        this.taskManager = taskManager;
                Status status = (Status) o;  
        try {  
            final long maxSeqNo = indexShard.seqNoStats().getMaxSeqNo();  
            final Translog.Snapshot wrappedSnapshot = new Translog.Snapshot() {
        }
                taskManager.unregister(resyncTask);
        private volatile int skippedOperations;  
            run();  
            }
        private static final Translog.Operation[] EMPTY_ARRAY = new Translog.Operation[0];
     */  
                }  
        public void setPhase(String phase) {  
            task.setPhase("collecting_ops");
            }
            this.shardId = shardId;
        Translog.Snapshot snapshot = null;
 */  
            return "ResyncRequest{ " + shardId + ", " + allocationId + " }";
 * this work for additional information regarding copyright
        private final AtomicInteger totalSkippedOps = new AtomicInteger();  
            @Override
        this(transportService.getTaskManager(), syncAction);  
     */  
 *
                shardId,
                    totalSkippedOps.get()  
            private final int skippedOperations;
                }
         * number of operations that have been successfully replicated
                    } catch (final Exception inner) {
                        throw new IndexShardClosedException(shardId);
        }
                out.writeVLong(totalOperations);  
                    "{} sending batch of [{}][{}] (total sent: [{}], skipped: [{}])",
                );
    ) {  
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
     *
        private final String primaryAllocationId;
        ) {  
                if (size >= chunkSizeInBytes) {
     * Sends a snapshot
     * Task to resync primary and replica  
 */
                maxSeqNo,
                @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
            final long maxSeenAutoIdTimestamp = indexShard.getMaxSeenAutoIdTimestamp();
import java.util.ArrayList;
        private volatile int totalOperations;
                maxSeenAutoIdTimestamp,
            try {
            ResyncReplicationRequest request,
        private final SyncAction syncAction;
                // check if this request is past bytes threshold, and if so, send it off  
import org.apache.logging.log4j.Logger;
        public String getPhase() {
            this.syncAction = syncAction;
import org.opensearch.tasks.TaskManager;  
        ActionListener<ResyncTask> listener
    private final TaskManager taskManager;  
                }  
         * total number of translog operations that were captured by translog snapshot  
                listener.onResponse(resyncTask);
                primaryAllocationId,
                logger.trace(  
            task.setResyncedOperations(totalSentOps.get());  
    }
    /**
            this.phase = phase;
        public int getSkippedOperations() {  
import org.opensearch.index.seqno.SequenceNumbers;  
        ActionListener<Void> wrappedListener = new ActionListener<Void>() {  
import org.opensearch.action.resync.TransportResyncReplicationAction;  
            }
        public ResyncRequest(ShardId shardId, String allocationId) {  
                chunkSize.bytesAsInt(),
            this.primaryTerm = primaryTerm;  
         */  
                @Override
                indexShard.getPendingPrimaryTerm(),  
            private final int totalOperations;
        } catch (Exception e) {
            task.setTotalOperations(snapshot.totalOperations());
            @Override
            }
        private final long startingSeqNo;
        }
        private final long primaryTerm;
 *
                    maxSeenAutoIdTimestamp,  
                snapshot,
            task.setSkippedOperations(totalSkippedOps.get());
    public static class ResyncRequest extends ActionRequest {
    }
        final long primaryTerm,  
     */
            Task parentTask,  
    }
            final List<Translog.Operation> operations = new ArrayList<>();  
            throw new IllegalArgumentException("chunkSize must be > 0");
        @Override  
import org.opensearch.core.common.unit.ByteSizeValue;
            };
            // Wrap translog snapshot to make it synchronized as it is accessed by different threads through SnapshotSender.
 * GitHub history for details.
                    } else {
                    operations.toArray(EMPTY_ARRAY)
    private void resync(  
         * Set the current phase of the task.
                IOUtils.close(snapshot);  
            long primaryTerm,
                listener.onFailure(e);
         */
            this.primaryAllocationId = primaryAllocationId;
        public int getResyncedOperations() {
        long maxSeqNo,  
            }  
         * @opensearch.api
                    break;
        ResyncTask resyncTask = (ResyncTask) taskManager.register("transport", "resync", request); // it's not transport :-)
            if (closed.compareAndSet(false, true)) {
            this.startingSeqNo = startingSeqNo;  
     *
            public Status(StreamInput in) throws IOException {  
/*
     *  
        final ShardId shardId,
        }
                    if (state == IndexShardState.CLOSED) {  
         * number of translog operations that have been skipped
            ).run();
                @Override  
 * Licensed to Elasticsearch under one or more contributor  
                result = 31 * result + skippedOperations;
        @PublicApi(since = "1.0.0")  
            resync(  
                result = 31 * result + resyncedOperations;  
import org.opensearch.core.common.io.stream.StreamInput;
                resyncListener
            // that the auto_id_timestamp of every operation in the snapshot is at most this value.
import org.opensearch.action.ActionRequestValidationException;  
        }  
            // Even though those calls are not concurrent, snapshot.next() uses non-synchronized state and is not multi-thread-compatible  
            // have to send sync request even in case of there are no operations to sync - have to sync trimAboveSeqNo at least  
            int chunkSizeInBytes,
 * SPDX-License-Identifier: Apache-2.0
                    try {  
                    operations.size(),  
package org.opensearch.index.shard;
import org.opensearch.common.inject.Inject;
         */  
                totalOperations = in.readVInt();
                builder.endObject();
import org.opensearch.common.util.io.IOUtils;
                    shardId,
    }
                public synchronized void close() throws IOException {  
        private final ShardId shardId;  
        protected void doRun() throws Exception {
        }
import org.opensearch.common.util.concurrent.AbstractRunnable;  
                    }
                return phase.equals(status.phase);
                listener.onFailure(e);  
                out.writeVLong(skippedOperations);
import java.util.concurrent.atomic.AtomicBoolean;
                public void onResponse(final ResyncTask resyncTask) {
                indexShard.routingEntry().allocationId().getId(),
        private final long maxSeqNo;  
                shardId,
        /**  
        @Override
                    } catch (final Exception e) {
                builder.field("resyncedOperations", resyncedOperations);  
                    try {
        private volatile String phase = "starting";  
    }  
         */
                public void onFailure(final Exception e) {
                if (seqNo == SequenceNumbers.UNASSIGNED_SEQ_NO || seqNo < startingSeqNo) {  
            public static final String NAME = "resync";
            final Translog.Snapshot originalSnapshot = snapshot;  
            }
        } catch (Exception e) {
            ActionListener<Void> listener
import org.opensearch.core.xcontent.MediaTypeRegistry;
        /**
            this.chunkSizeInBytes = chunkSizeInBytes;
            this.shardId = shardId;
 * @opensearch.internal  
        public String toString() {
            public void writeTo(StreamOutput out) throws IOException {
            }  
                out.writeString(phase);
                phase = in.readString();
        /**
import org.opensearch.core.common.unit.ByteSizeUnit;  
            @Override  
        @Override
    public interface SyncAction {  
import org.opensearch.action.ActionRequest;
                resyncTask,  
            private final String phase;
            private final int resyncedOperations;  
            );  
                skippedOperations = in.readVInt();
        private final ShardId shardId;  
        public ResyncTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers) {
     */
            long startingSeqNo,
        /**
                    IndexShardState state = indexShard.state();
import org.opensearch.core.action.ActionListener;
        }
            Translog.Operation operation;  
                this.totalOperations = totalOperations;  
        final String primaryAllocationId,
            final ActionListener<ResyncTask> resyncListener = new ActionListener<ResyncTask>() {
    public static final ByteSizeValue DEFAULT_CHUNK_SIZE = new ByteSizeValue(512, ByteSizeUnit.KB);  
                if (this == o) return true;  
            // We must capture the timestamp after snapshotting a snapshot of operations to make sure  
            }
public class PrimaryReplicaSyncer {
            return skippedOperations;
                startingSeqNo,
        };
                listener.onResponse(null);  
     * @opensearch.internal
        private final Logger logger;
            }
            this.allocationId = allocationId;
import org.opensearch.core.index.shard.ShardId;
import java.io.IOException;  
            @Override
            }  
 *  
        public void onFailure(Exception e) {
    private final SyncAction syncAction;
        private final int chunkSizeInBytes;
            long primaryTerm,
            SyncAction syncAction,
         *  
 * under the License.  
        private final Translog.Snapshot snapshot;
 * software distributed under the License is distributed on an
            final long trimAboveSeqNo = firstMessage.get() ? startingSeqNo - 1 : SequenceNumbers.UNASSIGNED_SEQ_NO;
         */
        final Translog.Snapshot snapshot,
        this.chunkSize = chunkSize;
        }  
                    originalSnapshot.close();
import java.util.concurrent.atomic.AtomicInteger;
        this.syncAction = syncAction;  
        private final ActionListener<Void> listener;  
import org.opensearch.core.tasks.TaskId;  
        }
        /**
 * Syncer for Primary replica
                }
    public void resync(final IndexShard indexShard, final ActionListener<ResyncTask> listener) {
                int result = phase.hashCode();
        }
                return result;
        public ActionRequestValidationException validate() {  
 * this file be licensed under the Apache-2.0 license or a
        }
    }
                maxSeenAutoIdTimestamp,
                if (resyncedOperations != status.resyncedOperations) return false;  
                syncAction,
        @Override  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
            public Status(String phase, int totalOperations, int resyncedOperations, int skippedOperations) {
                taskManager.unregister(resyncTask);
                if (totalOperations != status.totalOperations) return false;
         */
                wrappedSnapshot,
        private final String allocationId;
            this.listener = listener;  
        private final ResyncTask task; // to track progress  
