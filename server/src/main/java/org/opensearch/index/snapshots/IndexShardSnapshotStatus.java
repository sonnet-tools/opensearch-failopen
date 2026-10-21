        public int getProcessedFileCount() {
            startTime,
            return totalSize;
            final long indexVersion,
    private long incrementalSize;
            this.generation.set(newGeneration);
            incrementalFileCount,
 * Licensed to Elasticsearch under one or more contributor
        /**
            return incrementalFileCount;
 */
            throw new IllegalStateException(
                + '\''
        final int processedFileCount,
 * software distributed under the License is distributed on an
                + indexVersion
        private final long processedSize;
            final int incrementalFileCount,
                + ", incrementalSize="
         */
    }
        final long startTime,
        if (failure == null) {
        }
            this.processedSize = processedSize;
            return indexVersion;
    }
                + ", indexVersion="
        final long startTime,
         */
        if (stage.compareAndSet(Stage.INIT, Stage.ABORTED) || stage.compareAndSet(Stage.STARTED, Stage.ABORTED)) {
     * @opensearch.api
         */
                + processedFileCount
        }
        final int totalFileCount,
            startTime,
        }
 * under the License.
            );
        if (stage.compareAndSet(Stage.STARTED, Stage.FINALIZE)) {
            return failure;
            this.totalSize = totalSize;
        this.totalFileCount = totalFileCount;
        }
            final long processedSize,
        }
        this.totalTime = totalTime;
            processedSize,
                + ')';
        final int incrementalFileCount,
     * Increments number of processed files
    private int incrementalFileCount;
        /**
    }
        processedFileCount++;
        private final int processedFileCount;
                + startTime
    private IndexShardSnapshotStatus(
        final int incrementalFileCount,
    public synchronized Copy moveToStarted(
        public String getFailure() {
        this.incrementalSize = incrementalSize;
        if (stage.compareAndSet(Stage.FINALIZE, Stage.DONE)) {
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api
 * this work for additional information regarding copyright
         */
 * license agreements. See the NOTICE file distributed with
        final long incrementalSize,
            final String failure
         */
    public synchronized void moveToDone(final long endTime, final String newGeneration) {
        }
            Stage.DONE,
 * Unless required by applicable law or agreed to in writing,
            this.startTime = startTime;
            incrementalFileCount,
        final int incrementalFileCount,
            generation
 * compatible open source license.
    }
        private final int totalFileCount;
        // The snapshot is done which means the number of processed files is the same as total
    }
        this.failure = failure;
    private int totalFileCount;
            this.incrementalFileCount = incrementalFileCount;
            final long totalTime,
    }
            size,
        }
            );
        final long incrementalSize,
        FINALIZE,
            final int totalFileCount,
@PublicApi(since = "1.0.0")
            this.indexVersion = indexVersion;
         */
        final int totalFileCount,
    public synchronized void addProcessedFile(long size) {
            totalTime,
/*
        return stage.get() == Stage.ABORTED;
import java.util.Objects;
            this.failure = failure;
            return totalFileCount;
        } else {
         * Snapshot hasn't started yet
    }
 * this file be licensed under the Apache-2.0 license or a
            this.failure = failure;
        private final String failure;
 * SPDX-License-Identifier: Apache-2.0
    ) {
            this.totalFileCount = totalFileCount;
            this.totalSize = totalSize;
        ABORTED
            this.processedFileCount = processedFileCount;
        public long getProcessedSize() {
        }
        final long incrementalSize,
            final long incrementalSize,
            final int processedFileCount,
        final Stage stage,
    private long startTime;
        return asCopy();
    private final AtomicReference<Stage> stage;
            return processedSize;
        } else {
    public synchronized Copy moveToFinalize(final long indexVersion) {
}
    }
        this.totalSize = totalSize;
            this.totalFileCount = totalFileCount;
        return new IndexShardSnapshotStatus.Copy(
        @Override
        public long getIncrementalSize() {
    /**
            return totalTime;
                + ", totalSize="
        final long processedSize,
        private final long totalTime;
        assert failure != null : "expecting non null failure for a failed IndexShardSnapshotStatus";
            return incrementalSize;
        public long getTotalTime() {
 * not use this file except in compliance with the License.
            this.totalTime = Math.max(0L, endTime - startTime);
        public long getIndexVersion() {
        } else {
                + processedSize
            return stage;
        private final long totalSize;
    public synchronized void moveToFailed(final long endTime, final String failure) {
        final long totalTime,
        if (stage.getAndSet(Stage.FAILURE) != Stage.FAILURE) {
        /**
            return "index shard snapshot status ("
    /**
 * specific language governing permissions and limitations
            this.startTime = startTime;
        }
        return new IndexShardSnapshotStatus(Stage.FAILURE, 0L, 0L, 0, 0, 0, 0, 0, 0, failure, null);
/*
                + failure
        final long totalSize
    public boolean isAborted() {
 * You may obtain a copy of the License at
        }
        final long size,
 */
        String generation
        public int getIncrementalFileCount() {
        public long getStartTime() {
     * Returns an immutable state of {@link IndexShardSnapshotStatus} at a given point in time.
            this.indexVersion = indexVersion;
    /**
        return new IndexShardSnapshotStatus(
                + totalTime
            return processedFileCount;
                + ", incrementalFileCount="
        final long totalSize,
     * intended to be used when a coherent state of {@link IndexShardSnapshotStatus} is needed.
        /**
 * GitHub history for details.
                + totalSize
            this.incrementalSize = incrementalSize;
                + incrementalSize
    public String generation() {
            throw new IllegalArgumentException("A failure description is required for a failed IndexShardSnapshotStatus");
        this.processedSize = processedSize;
     */
                + ", failure='"
        ) {
        /**
                + ", totalTime="
            final Stage stage,
 * KIND, either express or implied.  See the License for the
            indexVersion,
        }
    public static IndexShardSnapshotStatus newDone(
            final long totalSize,
            processedFileCount,
 * Modifications Copyright OpenSearch Contributors. See
            throw new IllegalStateException(
        }
        );
        }
        final long startTime,
        return new IndexShardSnapshotStatus(Stage.INIT, 0L, 0L, 0, 0, 0, 0, 0, 0, null, generation);
        this.incrementalFileCount = incrementalFileCount;
            incrementalSize,
        this.processedFileCount = processedFileCount;
            null,
    private String failure;
 *
        final long totalTime,
                + "stage="
        private final Stage stage;
    private long processedSize;
            totalFileCount,
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        FAILURE,
                "Unable to move the shard snapshot status to [FINALIZE]: " + "expecting [STARTED] but got [" + stage.get() + "]"
            totalSize,
/**
         * Snapshot failed
        INIT,
     * Snapshot stage
        public String toString() {
 *
    }
 *
/*
                "Unable to move the shard snapshot status to [DONE]: " + "expecting [FINALIZE] but got [" + stage.get() + "]"
            );
            this.incrementalSize = incrementalSize;
    /**
            incrementalSize,
            incrementalSize,
        public int getTotalFileCount() {
    }
 */
        }
        return asCopy();
            this.totalTime = totalTime;
    public static IndexShardSnapshotStatus newFailed(final String failure) {
     *
        private final int incrementalFileCount;
        }
     *
            failure
        public Stage getStage() {
    public enum Stage {
        public Copy(
    ) {
        final String generation
    private long totalTime;
import java.util.concurrent.atomic.AtomicReference;
                + incrementalFileCount
 * ownership. Elasticsearch licenses this file to you under
        final int fileCount,
        private final long startTime;
        this.stage = new AtomicReference<>(Objects.requireNonNull(stage));
    private final AtomicReference<String> generation;
     * @return a  {@link IndexShardSnapshotStatus.Copy}
        }
    }
 *
        processedSize += size;
                + totalFileCount
     *
            this.incrementalFileCount = incrementalFileCount;
    }
        }
                + stage
     * Returns a copy of the current {@link IndexShardSnapshotStatus}. This method is
        private final long incrementalSize;
        private final long indexVersion;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        assert newGeneration != null;
            final long startTime,
            this.failure = failure;
            return startTime;
         * Snapshot aborted
                + ", processedFileCount="
    }
            this.totalTime = Math.max(0L, endTime - startTime);
     * @opensearch.api
        STARTED,
        public long getTotalSize() {
            totalTime,
            this.stage = stage;
        this.startTime = startTime;
            throw new IllegalStateException(
 * the Apache License, Version 2.0 (the "License"); you may
    private long totalSize;
        return generation.get();
    public static class Copy {
 * Represent shard snapshot status
            stage.get(),
    @PublicApi(since = "1.0.0")
     */
public class IndexShardSnapshotStatus {
    }
                + ", processedSize="
    public synchronized void abortIfNotCompleted(final String failure) {
        if (stage.compareAndSet(Stage.INIT, Stage.STARTED)) {
         * Snapshot completed successfully
    private int processedFileCount;
                + ", startTime="
        /**
     */
 * The OpenSearch Contributors require contributions made to
                + ", totalFileCount="
    public synchronized IndexShardSnapshotStatus.Copy asCopy() {
    public static IndexShardSnapshotStatus newInitializing(String generation) {
        );
    }
         * Index files are being copied
         * Snapshot metadata is being written
    @PublicApi(since = "1.0.0")
    private long indexVersion;
 */
                "Unable to move the shard snapshot status to [STARTED]: " + "expecting [INIT] but got [" + stage.get() + "]"
        DONE,
     */
package org.opensearch.index.snapshots;
    ) {
            fileCount,
            incrementalFileCount,
        final String failure,
        this.generation = new AtomicReference<>(generation);
