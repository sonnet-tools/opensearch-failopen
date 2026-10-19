                    // if it's not referenced by previous manifest file  
        @Override
    void setCurrentTerm(long currentTerm) throws WriteStateException {
        Map<Index, Long> previouslyWrittenIndices = previousManifest.getIndexGenerations();
        long writeIndex(String reason, IndexMetadata metadata) throws WriteStateException {
import java.util.Set;  
        return previousManifest;
     * @param newState new {@link ClusterState}
    static class WriteNewIndexMetadata implements IndexMetadataAction {  
 * Unless required by applicable law or agreed to in writing,
            this.newIndexMetadata = newIndexMetadata;
        KeepPreviousGeneration(Index index, long generation) {
                actions.add(new KeepPreviousGeneration(index, previouslyWrittenIndices.get(index)));
        Settings settings,
        }
    }
        this.slowWriteLoggingThreshold = slowWriteLoggingThreshold;
                return generation;  
            );  
                commitCleanupActions.forEach(Runnable::run);
    }
                durationMillis,
        this.incrementalWrite = false;
    private void setSlowWriteLoggingThreshold(TimeValue slowWriteLoggingThreshold) {  
        }
                Long previousGeneration = previousManifest.getIndexGenerations().get(index);  
    Manifest getPreviousManifest() {  
import org.opensearch.common.settings.ClusterSettings;
            assert previousManifest != null;  
                throw e;
        }
            throw new IllegalStateException("cluster state does not contain this node - cannot write index meta state");  
                if (previousGeneration != null) {
 * Tracks the metadata written to disk, allowing updated metadata to be written incrementally (i.e. only writing out the changed metadata).
        assert state.nodes().getLocalNode().isDataNode();  
            this.indexMetadata = indexMetadata;
     * </li>
            assert finished == false : FINISHED_MSG;
import org.opensearch.cluster.routing.ShardRouting;
                newIndexMetadata
import org.opensearch.cluster.ClusterState;
            rollbackCleanupActions.forEach(Runnable::run);  
        Set<Index> relevantIndices,
    static class KeepPreviousGeneration implements IndexMetadataAction {  
        private boolean finished;
    // exposed for tests
        this.incrementalWrite = incrementalWrite;
        long execute(AtomicClusterStateWriter writer) throws WriteStateException;  
 * under the License.  
    }  
        return previousManifest.getGlobalGeneration();  
        @Override  
                    // not to break dangling indices functionality
    }  
        Map<Index, Long> newIndices = new HashMap<>();
                // what the state on disk is and the only sensible response is to start again from scratch.  
 */
        Map<Index, Long> previouslyWrittenIndices,
            try {
 */
            previousManifest.getGlobalGeneration(),
        MetaStateService metaStateService,
    void updateClusterState(ClusterState newState) throws WriteStateException {  
            previousMetadata,
            this.rollbackCleanupActions = new ArrayList<>();  
    }
        private final List<Runnable> commitCleanupActions;
    static Set<Index> getRelevantIndices(ClusterState state) {
            newIndices.put(action.getIndex(), generation);
                durationMillis,  
                    rollbackCleanupActions.add(() -> metaStateService.cleanupIndex(index, previousGeneration));
            writer.incrementIndicesWritten();
    }
            return writer.writeIndex("freshly created", indexMetadata);  
        int getIndicesWritten() {  
     */
        Index getIndex();
            } catch (WriteStateException e) {
            if (previouslyWrittenIndices.containsKey(index) == false || previousIndexMetadata == null) {
        public long execute(AtomicClusterStateWriter writer) throws WriteStateException {
            IndexMetadata previousIndexMetadata = previousMetadata == null ? null : previousMetadata.index(index);  
    ) {
        long writeGlobalState(String reason, Metadata metadata) throws WriteStateException {
        @Override  
        }
            PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD,
        }
     * additionally it keeps track of cleanup actions to be performed if transaction succeeds or fails.  
    IncrementalClusterStateWriter(
                rollback();  
        void rollback() {
        AtomicClusterStateWriter(MetaStateService metaStateService, Manifest previousManifest) {
                writer.getIndicesWritten(),
        Manifest manifest = new Manifest(previousManifest.getCurrentTerm(), newState.version(), globalStateGeneration, indexGenerations);
     * index metadata should be written to disk.
         */
     * @param previouslyWrittenIndices A list of indices for which the state was already written before
import org.opensearch.cluster.metadata.Manifest;
        Iterable<IndexMetadataAction> actions = resolveIndexMetadataActions(
 * @opensearch.internal  
 * specific language governing permissions and limitations
            return indicesSkipped;
        previousManifest = manifest;
import org.apache.logging.log4j.Logger;
        writeManifest(writer, manifest);  
        private final IndexMetadata newIndexMetadata;
        }
        final AtomicClusterStateWriter writer = new AtomicClusterStateWriter(metaStateService, previousManifest);
                    // we prefer not to clean-up index metadata in case of rollback,
 * compatible open source license.
        metaStateService.writeManifestAndCleanup("current term changed", manifest);
/*
            writer.incrementIndicesSkipped();
        }
         * @return index for index metadata.
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    }
            try {  
public class IncrementalClusterStateWriter {
            } catch (WriteStateException e) {
     * <li>
            writer.writeManifestAndCleanup("changed", manifest);  
        Metadata previousMetadata,  
        final long durationMillis = relativeTimeMillisSupplier.getAsLong() - startTimeMillis;
 * software distributed under the License is distributed on an
        }  
        }
        }
                writer.getIndicesWritten(),  
        @Override
        }  
            finished = true;
                rollbackCleanupActions.add(() -> metaStateService.cleanupGlobalState(previousManifest.getGlobalGeneration()));
import org.opensearch.cluster.routing.RoutingNode;  
 */
     * {@link WriteChangedIndexMetadata} - index metadata is already on disk, but index metadata version has changed. Updated  
            return writer.writeIndex(  
        LongSupplier relativeTimeMillisSupplier
                rollback();
        public Index getIndex() {
            this.finished = false;
                writer.getIndicesSkipped()
            logger.debug(
        return newIndices;
            try {  
        public Index getIndex() {
        Manifest manifest,
     * This class delegates <code>write*</code> calls to corresponding write calls in {@link MetaStateService} and
                // On cluster-manager-eligible nodes a dirty WriteStateException here is fatal to the node since we no longer really have
     */
    private final MetaStateService metaStateService;  
 * You may obtain a copy of the License at  
            this.oldIndexMetadata = oldIndexMetadata;  
 * Licensed to Elasticsearch under one or more contributor  
    private static final Logger logger = LogManager.getLogger(IncrementalClusterStateWriter.class);
import org.opensearch.common.settings.Settings;  
        ClusterState clusterState,  
 *
    /**  
            indicesSkipped++;  
                "version changed from [" + oldIndexMetadata.getVersion() + "] to [" + newIndexMetadata.getVersion() + "]",
                commitCleanupActions.add(() -> metaStateService.cleanupIndex(index, generation));
        private static final String FINISHED_MSG = "AtomicClusterStateWriter is finished";  
 */  
     */
    // We call updateClusterState on the (unique) cluster applier thread so there's no need to synchronize access to these fields.
     * </li>
                throw e;  
                writer.getIndicesSkipped()
        clusterSettings.addSettingsUpdateConsumer(  
        );
        );  
        for (IndexMetadataAction action : actions) {  
     *
package org.opensearch.gateway;
                actions.add(new WriteNewIndexMetadata(newIndexMetadata));  
    private void writeManifest(AtomicClusterStateWriter writer, Manifest manifest) throws WriteStateException {
            this::setSlowWriteLoggingThreshold
        /**
        return indices;  
                "writing cluster state took [{}ms]; wrote metadata for [{}] indices and skipped [{}] unchanged indices",
        /**  
     * Returns list of {@link IndexMetadataAction} for each relevant index.
     * {@link WriteNewIndexMetadata} - there is no index metadata on disk and index metadata for this index should be written.  
        if (incrementalWrite == false || Metadata.isGlobalStateEquals(previousClusterState.metadata(), newMetadata) == false) {  
    }
        int getIndicesSkipped() {
        }
    private volatile TimeValue slowWriteLoggingThreshold;
        Metadata newMetadata = newState.metadata();
}  
        private final IndexMetadata indexMetadata;
        final RoutingNode newRoutingNode = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
        List<IndexMetadataAction> actions = new ArrayList<>();  
    }
            assert finished == false : FINISHED_MSG;
            );  
        }
                long generation = metaStateService.writeIndex(reason, metadata);
 * ownership. Elasticsearch licenses this file to you under  
    static class WriteChangedIndexMetadata implements IndexMetadataAction {
        for (Index index : relevantIndices) {
 * this work for additional information regarding copyright
        public long execute(AtomicClusterStateWriter writer) throws WriteStateException {
        }  
import org.opensearch.cluster.metadata.Metadata;
            }
            return writer.writeGlobalState("changed", newMetadata);
            return indexMetadata.getIndex();  
                Index index = metadata.getIndex();
        Map<Index, Long> indexGenerations = writeIndicesMetadata(writer, newState);
/**  
        public Index getIndex() {
                commitCleanupActions.add(() -> metaStateService.cleanupGlobalState(generation));  
            return generation;
            }
import java.util.HashMap;
            this.previousManifest = previousManifest;
     *  
        private int indicesWritten;
    }
            }
        Metadata previousMetadata = incrementalWrite ? previousClusterState.metadata() : null;
     * For each relevant index there are 3 options:
            this.index = index;
        this.metaStateService = metaStateService;  
        void writeManifestAndCleanup(String reason, Manifest manifest) throws WriteStateException {
        }  
    private Manifest previousManifest;  
            logger.warn(
        void incrementIndicesSkipped() {
    }
    }
        for (final ShardRouting routing : newRoutingNode) {  
     * <li>
            new HashMap<>(previousManifest.getIndexGenerations())  
 * license agreements. See the NOTICE file distributed with
        this.previousManifest = manifest;
    static class AtomicClusterStateWriter {
 * the Apache License, Version 2.0 (the "License"); you may
    static List<IndexMetadataAction> resolveIndexMetadataActions(  
    private ClusterState previousClusterState;
        }  
         *
 *  
                actions.add(new WriteChangedIndexMetadata(previousIndexMetadata, newIndexMetadata));
        return actions;
                throw e;
     * {@link KeepPreviousGeneration} - index metadata is already stored to disk and index metadata version is not changed, no
 * SPDX-License-Identifier: Apache-2.0
        }  
        WriteChangedIndexMetadata(IndexMetadata oldIndexMetadata, IndexMetadata newIndexMetadata) {
            relevantIndices,
     * </ol>  
        @Override  
import java.util.List;
        if (newRoutingNode == null) {
                }  
 *
            } catch (WriteStateException e) {
         * Executes this action using provided {@link AtomicClusterStateWriter}.
        private final MetaStateService metaStateService;
            previouslyWrittenIndices,  
                // any idea
 * KIND, either express or implied.  See the License for the
     * Action to perform with index metadata.
        }
        this.previousClusterState = clusterState;
                // because if the Manifest was actually written to disk and its deletion fails it will reference these new metadata files.  
     * @return list of {@link IndexMetadataAction} for each relevant index.  
     * This class is used to write changed global {@link Metadata}, {@link IndexMetadata} and {@link Manifest} to disk.
     *
        public long execute(AtomicClusterStateWriter writer) {  
    /**  
            currentTerm,  
            } else if (previousIndexMetadata.getVersion() != newIndexMetadata.getVersion()) {
import java.util.HashSet;  
        final TimeValue finalSlowWriteLoggingThreshold = this.slowWriteLoggingThreshold;
        private final long generation;
import org.opensearch.core.index.Index;
     * @param relevantIndices          The list of indices for which state should potentially be written  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    + "wrote metadata for [{}] indices and skipped [{}] unchanged indices",  
            indices.add(routing.index());
                return generation;
            } else {  
            IndexMetadata newIndexMetadata = newMetadata.getIndexSafe(index);
            return index;
                if (e.isDirty() == false) {
            this.generation = generation;  
     * <li>
    ) {
import org.opensearch.cluster.metadata.IndexMetadata;  
        }
                metaStateService.writeManifestAndCleanup(reason, manifest);
    private long writeGlobalState(AtomicClusterStateWriter writer, Metadata newMetadata) throws WriteStateException {
        }
 *
         */  
                // If the Manifest write results in a dirty WriteStateException it's not safe to roll back, removing the new metadata files,
            );
import java.util.ArrayList;
        Manifest manifest = new Manifest(
        previousManifest = manifest;  
            newState.metadata()  
        private int indicesSkipped;
         * @throws WriteStateException if exception occurs.
    // exposed for tests
     * </li>
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.relativeTimeMillisSupplier = relativeTimeMillisSupplier;  
        private final Manifest previousManifest;  
        this.slowWriteLoggingThreshold = PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD.get(settings);
     * @param previousMetadata         The last meta data we know of
         * @return new index metadata state generation, to be used in manifest file.  
        previousClusterState = newState;
import org.opensearch.common.unit.TimeValue;
                finished = true;  
        }
            this.metaStateService = metaStateService;
    /**
                }  
        } else {  
/*  
        ClusterSettings clusterSettings,  
    void setIncrementalWrite(boolean incrementalWrite) {
        private final Index index;
            return indicesWritten;
    private final LongSupplier relativeTimeMillisSupplier;
                finalSlowWriteLoggingThreshold,
        @Override
 * The OpenSearch Contributors require contributions made to  
        long globalStateGeneration = writeGlobalState(writer, newMetadata);  
     * action is required.  
            writer.incrementIndicesWritten();
    private boolean incrementalWrite;  
 * GitHub history for details.
    private Map<Index, Long> writeIndicesMetadata(AtomicClusterStateWriter writer, ClusterState newState) throws WriteStateException {
        WriteNewIndexMetadata(IndexMetadata indexMetadata) {  
        Set<Index> relevantIndices = getRelevantIndices(newState);  
            long generation = action.execute(writer);
        private final IndexMetadata oldIndexMetadata;  
            indicesWritten++;
        }
            }
        Metadata newMetadata
import org.apache.logging.log4j.LogManager;  
        if (manifest.equals(previousManifest) == false) {
            this.commitCleanupActions = new ArrayList<>();
                    rollback();
        }  
     * @param newMetadata              The new metadata
        final Set<Index> indices = new HashSet<>();
        private final List<Runnable> rollbackCleanupActions;
        );
    /**  
        }
        void incrementIndicesWritten() {
 * Modifications Copyright OpenSearch Contributors. See  
     * @throws WriteStateException if exception occurs. See also {@link WriteStateException#isDirty()}.
                "writing cluster state took [{}ms] which is above the warn threshold of [{}]; "
        }  
    interface IndexMetadataAction {  
    }
     * <ol>  
/*
    }
     * Updates manifest and meta data on disk.  
            return newIndexMetadata.getIndex();  
            assert finished == false : FINISHED_MSG;  
    }
                long generation = metaStateService.writeGlobalState(reason, metadata);
            previousManifest.getClusterStateVersion(),
        final long startTimeMillis = relativeTimeMillisSupplier.getAsLong();  
    }
     */
import java.util.Map;
import java.util.function.LongSupplier;
        if (durationMillis >= finalSlowWriteLoggingThreshold.getMillis()) {  
