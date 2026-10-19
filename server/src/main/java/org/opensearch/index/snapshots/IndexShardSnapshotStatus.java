            stage.get(),
        return stage.get() == Stage.ABORTED;
     *
            totalTime,
        final int incrementalFileCount,
    public static IndexShardSnapshotStatus newInitializing(String generation) {
        final int processedFileCount,  
            null,  
        final long size,
                + ')';
        ABORTED
 * license agreements. See the NOTICE file distributed with
            failure  
        final long incrementalSize,
        final int totalFileCount,
            this.startTime = startTime;
 * GitHub history for details.
    }
import org.opensearch.common.annotation.PublicApi;
         */
        /**  
        public long getIndexVersion() {  
        INIT,  
     * intended to be used when a coherent state of {@link IndexShardSnapshotStatus} is needed.
        } else {  
                + ", processedFileCount="  
            this.startTime = startTime;  
            throw new IllegalStateException(
        FINALIZE,
/**  
            this.totalSize = totalSize;
     */  
        return new IndexShardSnapshotStatus(Stage.INIT, 0L, 0L, 0, 0, 0, 0, 0, 0, null, generation);
    private int processedFileCount;
                + incrementalFileCount  
                + ", incrementalSize="
            throw new IllegalStateException(  
        this.failure = failure;
        private final long indexVersion;
        final long totalTime,  
        private final Stage stage;
        final int incrementalFileCount,
}
@PublicApi(since = "1.0.0")
                + ", incrementalFileCount="
    /**  
                + "stage="
            startTime,  
        if (stage.compareAndSet(Stage.FINALIZE, Stage.DONE)) {  
        private final int incrementalFileCount;
     */  
 * Licensed to Elasticsearch under one or more contributor  
        this.stage = new AtomicReference<>(Objects.requireNonNull(stage));
        }  
         * Snapshot failed
            generation
/*  
    }
    private IndexShardSnapshotStatus(  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        if (stage.getAndSet(Stage.FAILURE) != Stage.FAILURE) {
 * Represent shard snapshot status
        if (failure == null) {
 * this file be licensed under the Apache-2.0 license or a
            this.incrementalFileCount = incrementalFileCount;
    ) {  
        public Copy(
        assert failure != null : "expecting non null failure for a failed IndexShardSnapshotStatus";  
                + startTime
     *  
            totalSize,  
                + ", indexVersion="
        }
                + ", processedSize="  
        } else {
        this.incrementalSize = incrementalSize;
         */  
    private int totalFileCount;
         */  
        private final String failure;
            this.incrementalSize = incrementalSize;
        if (stage.compareAndSet(Stage.STARTED, Stage.FINALIZE)) {  
        /**  
                + stage  
 * the Apache License, Version 2.0 (the "License"); you may
        final String generation
    }  
                + '\''  
        final String failure,
        final long processedSize,  
            this.failure = failure;
 * this work for additional information regarding copyright
            incrementalSize,
            return incrementalSize;
            this.totalSize = totalSize;
    public boolean isAborted() {  
    }  
        public long getProcessedSize() {
     */  
        String generation
/*
        processedFileCount++;
            return indexVersion;
        final int totalFileCount,
        );
        return new IndexShardSnapshotStatus(Stage.FAILURE, 0L, 0L, 0, 0, 0, 0, 0, 0, failure, null);
        assert newGeneration != null;
            Stage.DONE,  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @PublicApi(since = "1.0.0")
         * Snapshot completed successfully
            this.processedFileCount = processedFileCount;
            incrementalFileCount,
        final int incrementalFileCount,
            fileCount,
            this.totalFileCount = totalFileCount;  
        // The snapshot is done which means the number of processed files is the same as total
            this.processedSize = processedSize;  
        this.processedFileCount = processedFileCount;
            return totalFileCount;
                + ", totalTime="  
     * Returns an immutable state of {@link IndexShardSnapshotStatus} at a given point in time.  
        public String getFailure() {
        this.processedSize = processedSize;  
                + ", startTime="
        this.totalSize = totalSize;
            final int totalFileCount,  
    public synchronized Copy moveToFinalize(final long indexVersion) {
        STARTED,
    public String generation() {
    private long totalTime;
    }  
    private String failure;
            processedFileCount,
            this.indexVersion = indexVersion;
        /**
 */
            );  
        final long startTime,
    ) {
import java.util.concurrent.atomic.AtomicReference;
         */
    private long indexVersion;  
         * Snapshot aborted  
    private int incrementalFileCount;  
            throw new IllegalArgumentException("A failure description is required for a failed IndexShardSnapshotStatus");
         * Snapshot hasn't started yet
        }
         */
    /**
        }  
                + incrementalSize  
        ) {
        /**
        }  
 *  
    private long startTime;
    }  
                + totalSize
    public enum Stage {
 * Modifications Copyright OpenSearch Contributors. See
        }
        );
    public synchronized void abortIfNotCompleted(final String failure) {
     *
 */
        }
        return asCopy();
        DONE,  
        public long getTotalSize() {
        public int getIncrementalFileCount() {  
        public long getTotalTime() {
            this.totalTime = Math.max(0L, endTime - startTime);
    }  
            size,
                + totalTime
            final int processedFileCount,
 * You may obtain a copy of the License at  
        } else {  
            return processedSize;  
            final long indexVersion,
                + processedSize
 * compatible open source license.
            final long incrementalSize,
        }
                + indexVersion  
        this.incrementalFileCount = incrementalFileCount;
     * @opensearch.api
        this.startTime = startTime;  
        this.generation = new AtomicReference<>(generation);
        return new IndexShardSnapshotStatus(
 * under the License.  
                + processedFileCount
        private final long startTime;
        public long getIncrementalSize() {  
        private final long totalSize;
    private final AtomicReference<Stage> stage;
    @PublicApi(since = "1.0.0")
        if (stage.compareAndSet(Stage.INIT, Stage.STARTED)) {  
            indexVersion,
            this.totalTime = Math.max(0L, endTime - startTime);  
            incrementalSize,
 * Unless required by applicable law or agreed to in writing,
     * Increments number of processed files
        final long incrementalSize,  
                + ", totalSize="
    public synchronized void moveToFailed(final long endTime, final String failure) {
            final long totalSize,  
        }
        final long totalSize,
        }  
         * Snapshot metadata is being written  
        final long startTime,
            startTime,
        final int fileCount,
    public static IndexShardSnapshotStatus newFailed(final String failure) {
        public String toString() {  
        return new IndexShardSnapshotStatus.Copy(
 *
    private long processedSize;
        final long totalSize
 */  
            this.totalFileCount = totalFileCount;  
        public int getTotalFileCount() {
    }
        @Override
            return "index shard snapshot status ("
            return totalTime;  
        if (stage.compareAndSet(Stage.INIT, Stage.ABORTED) || stage.compareAndSet(Stage.STARTED, Stage.ABORTED)) {
            return incrementalFileCount;
            this.indexVersion = indexVersion;
    private long incrementalSize;
            throw new IllegalStateException(
        }
     */
        public long getStartTime() {
    ) {  
            );  
package org.opensearch.index.snapshots;
    }  
/*  
    public static IndexShardSnapshotStatus newDone(
        final Stage stage,
            final long totalTime,
            this.incrementalFileCount = incrementalFileCount;
            final long startTime,  
            return stage;
            processedSize,
            return failure;
        return generation.get();  
                "Unable to move the shard snapshot status to [STARTED]: " + "expecting [INIT] but got [" + stage.get() + "]"
 * The OpenSearch Contributors require contributions made to  
    }
            incrementalSize,  
        }
    /**
            totalFileCount,  
        /**
    }
         */
        public Stage getStage() {  
import java.util.Objects;  
            this.stage = stage;
public class IndexShardSnapshotStatus {  
    }
        }  
                + ", failure='"
            final long processedSize,
    private final AtomicReference<String> generation;  
    private long totalSize;  
            this.incrementalSize = incrementalSize;
                + failure
 * ownership. Elasticsearch licenses this file to you under  
        /**
        private final long processedSize;
 * @opensearch.api  
            final int incrementalFileCount,
        final long startTime,  
    public synchronized void addProcessedFile(long size) {
     * @return a  {@link IndexShardSnapshotStatus.Copy}
                "Unable to move the shard snapshot status to [FINALIZE]: " + "expecting [STARTED] but got [" + stage.get() + "]"
    public synchronized void moveToDone(final long endTime, final String newGeneration) {
            this.totalTime = totalTime;
    public static class Copy {
        }
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        }
            return startTime;
            this.failure = failure;  
            final String failure  
    public synchronized Copy moveToStarted(
     * Returns a copy of the current {@link IndexShardSnapshotStatus}. This method is
        return asCopy();
    /**
        final long incrementalSize,  
        private final long incrementalSize;  
            incrementalFileCount,  
 */  
        }
        FAILURE,
        private final long totalTime;  
        this.totalFileCount = totalFileCount;  
    }
            final Stage stage,
 *
        private final int totalFileCount;
    public synchronized IndexShardSnapshotStatus.Copy asCopy() {  
            );
        private final int processedFileCount;  
         * Index files are being copied
            this.generation.set(newGeneration);
 * not use this file except in compliance with the License.
 *
        this.totalTime = totalTime;
            incrementalFileCount,
        }  
            this.failure = failure;  
                "Unable to move the shard snapshot status to [DONE]: " + "expecting [FINALIZE] but got [" + stage.get() + "]"
            return totalSize;
                + ", totalFileCount="
        processedSize += size;  
        }
     * Snapshot stage  
                + totalFileCount
        public int getProcessedFileCount() {
        final long totalTime,  
            totalTime,
     * @opensearch.api
 * SPDX-License-Identifier: Apache-2.0
    }
            return processedFileCount;  
 * software distributed under the License is distributed on an
