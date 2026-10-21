    }
 * Licensed to Elasticsearch under one or more contributor
import org.apache.logging.log4j.Logger;
 * license agreements. See the NOTICE file distributed with
/**
 * Unless required by applicable law or agreed to in writing,
        private static final String FINISHED_MSG = "AtomicClusterStateWriter is finished";
         * @return index for index metadata.
     * {@link WriteChangedIndexMetadata} - index metadata is already on disk, but index metadata version has changed. Updated
            previousMetadata,
        this.slowWriteLoggingThreshold = slowWriteLoggingThreshold;
        return previousManifest;
        return indices;
    private boolean incrementalWrite;
            this.index = index;
     * </li>
        Manifest manifest = new Manifest(
            return writer.writeGlobalState("changed", newMetadata);
    }
 * You may obtain a copy of the License at
            } catch (WriteStateException e) {
        private final List<Runnable> commitCleanupActions;
    /**
                actions.add(new WriteNewIndexMetadata(newIndexMetadata));
 *
         */
    private long writeGlobalState(AtomicClusterStateWriter writer, Metadata newMetadata) throws WriteStateException {
                }
 * under the License.
            this.metaStateService = metaStateService;
        } else {
            assert finished == false : FINISHED_MSG;
                newIndexMetadata
            );
        LongSupplier relativeTimeMillisSupplier
        void incrementIndicesWritten() {
    }
                writer.getIndicesWritten(),
        @Override
                actions.add(new KeepPreviousGeneration(index, previouslyWrittenIndices.get(index)));
    static List<IndexMetadataAction> resolveIndexMetadataActions(
        private final MetaStateService metaStateService;
 * @opensearch.internal
            indices.add(routing.index());
         * Executes this action using provided {@link AtomicClusterStateWriter}.
        }
        }
        final RoutingNode newRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
        final AtomicClusterStateWriter writer = new AtomicClusterStateWriter(metaStateService, previousManifest);
/*
 */
    static class AtomicClusterStateWriter {
            }
 *
        ClusterSettings clusterSettings,
        Manifest manifest = new Manifest(previousManifest.getCurrentTerm(), newState.version(), globalStateGeneration, indexGenerations);
                "writing cluster state took [{}ms]; wrote metadata for [{}] indices and skipped [{}] unchanged indices",
    private Map<Index, Long> writeIndicesMetadata(AtomicClusterStateWriter writer, ClusterState newState) throws WriteStateException {
import org.opensearch.common.settings.Settings;
    // exposed for tests
    }
     * </li>
        }
                "version changed from [" + oldIndexMetadata.getVersion() + "] to [" + newIndexMetadata.getVersion() + "]",
    }
                if (e.isDirty() == false) {
        this.slowWriteLoggingThreshold = PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.get(settings);
        Manifest manifest,
     */
        }
        }
                    + "wrote metadata for [{}] indices and skipped [{}] unchanged indices",
                // what the state on disk is and the only sensible response is to start again from scratch.
    }
     */
 * this file be licensed under the Apache-2.0 license or a
        }
     * </ol>
        }
    }
     * This class delegates <code>write*</code> calls to corresponding write calls in {@link MetaStateService} and
        return actions;
        );
     * @return list of {@link IndexMetadataAction} for each relevant index.
        void writeManifestAndCleanup(String reason, Manifest manifest) throws WriteStateException {
            assert previousManifest != null;
import org.opensearch.common.unit.TimeValue;
        );
    }
            return indicesSkipped;
            return writer.writeIndex(
import org.opensearch.core.index.Index;
        Map<Index, Long> previouslyWrittenIndices = previousManifest.getIndexGenerations();
                rollback();
            this.indexMetadata = indexMetadata;
        final long startTimeMillis = relativeTimeMillisSupplier.getAsLong();
     */
        }
        public long execute(AtomicClusterStateWriter writer) {
            PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD,
     * additionally it keeps track of cleanup actions to be performed if transaction succeeds or fails.
            logger.warn(
        public Index getIndex() {
                finalSlowWriteLoggingThreshold,
                throw e;
 *
    static class WriteChangedIndexMetadata implements IndexMetadataAction {
                if (previousGeneration != null) {
            } else if (previousIndexMetadata.getVersion() != newIndexMetadata.getVersion()) {
        }
        metaStateService.writeManifestAndCleanup("current term changed", manifest);
    private void setSlowWriteLoggingThreshold(TimeValue slowWriteLoggingThreshold) {
import org.opensearch.cluster.metadata.Manifest;
     * Updates manifest and meta data on disk.
 * ownership. Elasticsearch licenses this file to you under
        @Override
        Map<Index, Long> indexGenerations = writeIndicesMetadata(writer, newState);
    private final MetaStateService metaStateService;
        }
        }
     * action is required.
        Metadata newMetadata
        AtomicClusterStateWriter(MetaStateService metaStateService, Manifest previousManifest) {
                    // we prefer not to clean-up index metadata in case of rollback,
        return previousManifest.getGlobalGeneration();
        }
        Set<Index> relevantIndices,
     * <li>
         * @throws WriteStateException if exception occurs.
        private int indicesWritten;
    static class WriteNewIndexMetadata implements IndexMetadataAction {
    // exposed for tests
                return generation;
        }
            previouslyWrittenIndices,
     * <li>
        this.incrementalWrite = false;
        writeManifest(writer, manifest);
        assert state.nodes().getLocalNode().isDataNode();
                long generation = metaStateService.writeIndex(reason, metadata);
import java.util.HashSet;
        Map<Index, Long> newIndices = new HashMap<>();
                commitCleanupActions.forEach(Runnable::run);
        previousClusterState = newState;
import org.apache.logging.log4j.LogManager;
     * @param previouslyWrittenIndices A list of indices for which the state was already written before
                actions.add(new WriteChangedIndexMetadata(previousIndexMetadata, newIndexMetadata));
        MetaStateService metaStateService,
        this.relativeTimeMillisSupplier = relativeTimeMillisSupplier;
            writer.writeManifestAndCleanup("changed", manifest);
        final long durationMillis = relativeTimeMillisSupplier.getAsLong() - startTimeMillis;
                    rollbackCleanupActions.add(() -> metaStateService.cleanupIndex(index, previousGeneration));
            }
    /**
        if (manifest.equals(previousManifest) == false) {
        final Set<Index> indices = new HashSet<>();
        Metadata previousMetadata = incrementalWrite ? previousClusterState.metadata() : null;
     * @param newState new {@link ClusterState}
        Iterable<IndexMetadataAction> actions = resolveIndexMetadataActions(
        }
                return generation;
    }
/*
            this.newIndexMetadata = newIndexMetadata;
import org.opensearch.cluster.metadata.IndexMetadata;
                writer.getIndicesSkipped()
                // because if the Manifest was actually written to disk and its deletion fails it will reference these new metadata files.
    private Manifest previousManifest;
            assert finished == false : FINISHED_MSG;
                finished = true;
import org.opensearch.cluster.routing.RoutingNode;
    /**
        private final IndexMetadata oldIndexMetadata;
            long generation = action.execute(writer);
    }
public class IncrementalClusterStateWriter {
    private final LongSupplier relativeTimeMillisSupplier;
            return indexMetadata.getIndex();
        }
    ) {
import java.util.Set;
        for (final ShardRouting routing : newRoutingNode) {
            IndexMetadata previousIndexMetadata = previousMetadata == null ? null : previousMetadata.index(index);
     * Action to perform with index metadata.
            );
        public Index getIndex() {
            this.previousManifest = previousManifest;
     */
            } catch (WriteStateException e) {
        this.metaStateService = metaStateService;
                // any idea
        Map<Index, Long> previouslyWrittenIndices,
import org.opensearch.cluster.routing.ShardRouting;
        }
                metaStateService.writeManifestAndCleanup(reason, manifest);
        if (incrementalWrite == false || Metadata.isGlobalStateEquals(previousClusterState.metadata(), newMetadata) == false) {
            rollbackCleanupActions.forEach(Runnable::run);
        private final List<Runnable> rollbackCleanupActions;
     * Returns list of {@link IndexMetadataAction} for each relevant index.
         * @return new index metadata state generation, to be used in manifest file.
                Index index = metadata.getIndex();
        @Override
                commitCleanupActions.add(() -> metaStateService.cleanupIndex(index, generation));
     * index metadata should be written to disk.
        void incrementIndicesSkipped() {
    interface IndexMetadataAction {
import java.util.Map;
            throw new IllegalStateException("cluster state does not contain this node - cannot write index meta state");
        Set<Index> relevantIndices = getRelevantIndices(newState);
 * KIND, either express or implied.  See the License for the
            finished = true;
     * {@link WriteNewIndexMetadata} - there is no index metadata on disk and index metadata for this index should be written.
        }
        }
            assert finished == false : FINISHED_MSG;
            try {
}
            logger.debug(
        @Override
     * This class is used to write changed global {@link Metadata}, {@link IndexMetadata} and {@link Manifest} to disk.
    void setIncrementalWrite(boolean incrementalWrite) {
        private int indicesSkipped;
        }
        }
        private final IndexMetadata newIndexMetadata;
        }
                durationMillis,
        final TimeValue finalSlowWriteLoggingThreshold = this.slowWriteLoggingThreshold;
     * {@link KeepPreviousGeneration} - index metadata is already stored to disk and index metadata version is not changed, no
        public long execute(AtomicClusterStateWriter writer) throws WriteStateException {
     * <li>
        long writeIndex(String reason, IndexMetadata metadata) throws WriteStateException {
                // On cluster-manager-eligible nodes a dirty WriteStateException here is fatal to the node since we no longer really have
 * specific language governing permissions and limitations
     *
            writer.incrementIndicesWritten();
     *
        private final IndexMetadata indexMetadata;
            return writer.writeIndex("freshly created", indexMetadata);
        }
        ClusterState clusterState,
            } catch (WriteStateException e) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Tracks the metadata written to disk, allowing updated metadata to be written incrementally (i.e. only writing out the changed metadata).
            }
            IndexMetadata newIndexMetadata = newMetadata.getIndexSafe(index);
        clusterSettings.addSettingsUpdateConsumer(
     * @param relevantIndices          The list of indices for which state should potentially be written
 * Modifications Copyright OpenSearch Contributors. See
            try {
    private void writeManifest(AtomicClusterStateWriter writer, Manifest manifest) throws WriteStateException {
    /**
 * GitHub history for details.
        @Override
            newIndices.put(action.getIndex(), generation);
            );
            previousManifest.getGlobalGeneration(),
        long writeGlobalState(String reason, Metadata metadata) throws WriteStateException {
 * software distributed under the License is distributed on an
        for (Index index : relevantIndices) {
        WriteNewIndexMetadata(IndexMetadata indexMetadata) {
import java.util.List;
 * compatible open source license.
        }
    }
        }
            new HashMap<>(previousManifest.getIndexGenerations())
            previousManifest.getClusterStateVersion(),
            this.rollbackCleanupActions = new ArrayList<>();
    static class KeepPreviousGeneration implements IndexMetadataAction {
                durationMillis,
 */
        public Index getIndex() {
        private final long generation;
                writer.getIndicesSkipped()
        this.incrementalWrite = incrementalWrite;
    ) {
        int getIndicesSkipped() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            this.oldIndexMetadata = oldIndexMetadata;
            return index;
                writer.getIndicesWritten(),
     * @param newMetadata              The new metadata
        if (durationMillis >= finalSlowWriteLoggingThreshold.getMillis()) {
        Settings settings,
            this.commitCleanupActions = new ArrayList<>();
            try {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.ClusterState;
    IncrementalClusterStateWriter(
        for (IndexMetadataAction action : actions) {
                rollbackCleanupActions.add(() -> metaStateService.cleanupGlobalState(previousManifest.getGlobalGeneration()));
        previousManifest = manifest;
            return newIndexMetadata.getIndex();
                long generation = metaStateService.writeGlobalState(reason, metadata);
    void setCurrentTerm(long currentTerm) throws WriteStateException {
        void rollback() {
import java.util.HashMap;
        previousManifest = manifest;
                    // if it's not referenced by previous manifest file
     * <ol>
         *
 * this work for additional information regarding copyright
        Index getIndex();
            writer.incrementIndicesSkipped();
    // We call updateClusterState on the (unique) cluster applier thread so there's no need to synchronize access to these fields.
 * not use this file except in compliance with the License.
import java.util.function.LongSupplier;
        );
        WriteChangedIndexMetadata(IndexMetadata oldIndexMetadata, IndexMetadata newIndexMetadata) {
            if (previouslyWrittenIndices.containsKey(index) == false || previousIndexMetadata == null) {
    void updateClusterState(ClusterState newState) throws WriteStateException {
                rollback();
            newState.metadata()
    }
        Metadata newMetadata = newState.metadata();
        private final Index index;
        if (newRoutingNode == null) {
            currentTerm,
                Long previousGeneration = previousManifest.getIndexGenerations().get(index);
     * @throws WriteStateException if exception occurs. See also {@link WriteStateException#isDirty()}.
 * SPDX-License-Identifier: Apache-2.0
        return newIndices;
        long execute(AtomicClusterStateWriter writer) throws WriteStateException;
            this.generation = generation;
/*
        /**
         */
 *
            return generation;
 */
    private ClusterState previousClusterState;
        }
        private boolean finished;
            indicesWritten++;
        /**
                commitCleanupActions.add(() -> metaStateService.cleanupGlobalState(generation));
                "writing cluster state took [{}ms] which is above the warn threshold of [{}]; "
            this.finished = false;
        @Override
        this.previousClusterState = clusterState;
    }
        this.previousManifest = manifest;
        List<IndexMetadataAction> actions = new ArrayList<>();
import java.util.ArrayList;
    }
    private static final Logger logger = LogManager.getLogger(IncrementalClusterStateWriter.class);
            writer.incrementIndicesWritten();
        int getIndicesWritten() {
            }
        Metadata previousMetadata,
                throw e;
    Manifest getPreviousManifest() {
            relevantIndices,
        public long execute(AtomicClusterStateWriter writer) throws WriteStateException {
        KeepPreviousGeneration(Index index, long generation) {
 * The OpenSearch Contributors require contributions made to
     *
package org.opensearch.gateway;
import org.opensearch.cluster.metadata.Metadata;
 */
            this::setSlowWriteLoggingThreshold
     * For each relevant index there are 3 options:
                }
import org.opensearch.common.settings.ClusterSettings;
            indicesSkipped++;
        private final Manifest previousManifest;
    }
            } else {
        long globalStateGeneration = writeGlobalState(writer, newMetadata);
                // If the Manifest write results in a dirty WriteStateException it's not safe to roll back, removing the new metadata files,
    private volatile TimeValue slowWriteLoggingThreshold;
     * </li>
                    rollback();
     * @param previousMetadata         The last meta data we know of
    }
            return indicesWritten;
                    // not to break dangling indices functionality
                throw e;
    static Set<Index> getRelevantIndices(ClusterState state) {
