            synchronized (mutex) {
            } catch (Exception e) {
        }
            .andThen(state -> ClusterStateUpdaters.upgradeAndArchiveUnknownOrInvalidSettings(state, clusterService.getClusterSettings()))
        @Override
 * SPDX-License-Identifier: Apache-2.0
 * Loads (and maybe upgrades) cluster metadata at startup, and persistently stores cluster metadata for future restarts.
            return null;
                }
        MetadataIndexUpgradeService metadataIndexUpgradeService,
        boolean allPendingAsyncStatesWritten() {
        }
                }
    @Override
                    }
            // no-op
                delayInMills = delayInMills * 2;
            threadPoolExecutor.execute(new AbstractRunnable() {
        }
import java.util.function.BiConsumer;
import org.opensearch.node.Node;
                        metaStateService.deleteAll(); // delete legacy files
                        } else {
                    }
        private boolean verifyManifestAndClusterState(ClusterMetadataManifest manifest, ClusterState clusterState) {
            assert clusterState.metadata().indices().size() == manifest.getIndices().size()
                        persistedState = new AsyncLucenePersistedState(
                    if (DiscoveryNode.isDataNode(settings)) {
                } else {
                } else {
                        metadataBuilder.clusterUUIDCommitted(true);
        boolean changed = false;
                        scheduleUpdate();
        // upgrade global custom meta data
    public void start(
        @Override
    private final Logger logger = LogManager.getLogger(GatewayMetaState.class);
                    logger.error("Exception occurred when storing new meta data", e);
                    Thread.currentThread().interrupt(); // Restore interrupted status
        private static final Logger logger = LogManager.getLogger(AsyncLucenePersistedState.class);
                    );
public class GatewayMetaState implements Closeable {
            final String nodeName = Objects.requireNonNull(Node.NODE_NAME_SETTING.get(settings));
            }
                    if (newCurrentTermQueued == false) {
 * KIND, either express or implied.  See the License for the
            this.lastAcceptedState = lastAcceptedState;
    public boolean allPendingAsyncStatesWritten() {
                final PersistedClusterStateService.OnDiskState onDiskState = persistedClusterStateService.loadBestOnDiskState();
     * Encapsulates the incremental writing of metadata to a {@link PersistedClusterStateService.Writer}.
        Map<String, IndexTemplateMetadata> upgradedCustoms = upgrader.apply(existingMap);
                        currentTerm = legacyState.v1().getCurrentTerm();
    // exposed so it can be overridden by tests
                    // write legacy node metadata to prevent downgrades from spawning empty cluster state
import org.opensearch.cluster.coordination.PersistedStateStats;
                try {
            IOUtils.close(persistenceWriter.getAndSet(null));
                // cluster uuid as coordinating-only nodes do not snap into a cluster as they carry no state
                    manifestDetails = remoteClusterStateService.writeFullMetadata(clusterState, previousClusterUUID);
import org.opensearch.gateway.remote.RemoteClusterStateService;
package org.opensearch.gateway;
                        shouldCommitVotingConfig
}
        @Override
        RemoteClusterStateService remoteClusterStateService,
        RemoteStoreRestoreService remoteStoreRestoreService,
            } catch (Exception e) {
                    : "Last accepted state and manifest do not have same UUID for index : " + md.getIndexName();
                        clusterState.getClusterName().value(),
                // ClusterState.UNKOWN_UUID . The valid UUID will be generated and persisted along with the first cluster state getting
import org.opensearch.cluster.coordination.InMemoryPersistedState;
                    TimeUnit.MILLISECONDS.sleep(delayInMills);
                    if (newStateQueued == false) {
                        newWriter.close();
        public void close() throws IOException {
                        // In a new currentTerm, we cannot compare the persisted metadata's lastAcceptedVersion to those in the new state,
                        getWriterSafe().writeIncrementalStateAndCommit(currentTerm, lastAcceptedState, clusterState);
        @Override
            try {
        LucenePersistedState(PersistedClusterStateService persistedClusterStateService, long currentTerm, ClusterState lastAcceptedState)
        final Map<String, IndexTemplateMetadata> existingData,
        }
    }
        }
 * license agreements. See the NOTICE file distributed with
                throw e;
    private PersistedStateRegistry persistedStateRegistry;
            if (writer.isOpen()) {
            super(persistedState.getCurrentTerm(), persistedState.getLastAcceptedState());
                    }
            });
        assert this.persistedStateRegistry == null : "Persisted state registry should only be set once";
        }
                    // write legacy node metadata to prevent accidental downgrades from spawning empty cluster state
                    getWriterSafe().writeFullStateAndCommit(currentTerm, lastAcceptedState);
            try {
                handleExceptionOnWrite(e);
            if (writer == null) {
 * this file be licensed under the Apache-2.0 license or a
        }
            }
        return persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).getLastAcceptedState().metadata();
                1,
            existingMap.put(customCursor.getKey(), customCursor.getValue());
        }
                        lastAcceptedManifest,
                }
                    final Tuple<Manifest, Metadata> legacyState = metaStateService.loadFullState();
 * loaded when constructing the instance of this class is not necessarily the state that will be used as {@link ClusterState#metadata()} because it might be
        UnaryOperator<Map<String, IndexTemplateMetadata>> upgrader,
        String lastKnownClusterUUID
        @Override
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.cluster.ClusterChangedEvent;
                }
                return restoreClusterState(remoteStoreRestoreService, clusterState, lastKnownClusterUUID);
 * stale or incomplete. Cluster-manager-eligible nodes must perform an election to find a complete and non-stale state, and cluster-manager-ineligible nodes
                            clusterState = null;
 */
            synchronized (mutex) {
                        transportService,
                        clusterState,
 */
                .metadata(Metadata.builder(clusterState.metadata()).coordinationMetadata(newCoordinationMetadata).build())
                        remotePersistedState = new RemotePersistedState(remoteClusterStateService, lastKnownClusterUUID);
                    newCurrentTermQueued = true;
                    final PersistedClusterStateService.Writer newWriter = persistedClusterStateService.createWriter();
            changed = true;
            }
            } catch (Exception e) {
            // Remote Metadata should always override local disk Metadata
        public PersistedStateStats getStats() {
        return persistedState;
        private final PersistedState persistedState;
                try {
                            );
        BiConsumer<String, IndexTemplateMetadata> putData
        public RemotePersistedState(final RemoteClusterStateService remoteClusterStateService, final String previousClusterUUID) {
                    newStateQueued = true;
                        return newWriter;
        private static final Logger logger = LogManager.getLogger(RemotePersistedState.class);
import java.util.function.Function;
                } catch (IOException e) {
            } catch (Exception e) {
        private void scheduleUpdate() {
                    if (shouldCommitVotingConfig) {
                }
                    logger.trace("queuing cluster state update (setting cluster state to {})", clusterState.version());
            }
        public ClusterMetadataManifest getLastAcceptedManifest() {
            // remove all data first so a plugin can remove custom metadata or templates if needed
 * not use this file except in compliance with the License.
import java.util.HashMap;
        private void handleExceptionOnWrite(Exception e) {
                assert lastAcceptedState != null : "Last accepted state is not present";
    }
        @Override
import java.util.concurrent.TimeUnit;
                boolean shouldCommitVotingConfig = shouldCommitVotingConfig();
                setLastAcceptedManifest(manifestDetails.getClusterMetadataManifest());
            .andThen(ClusterStateUpdaters::recoverClusterBlocks)
        public ClusterState getLastAcceptedState() {
            throws IOException {
     * @return input <code>metadata</code> if no upgrade is needed or an upgraded metadata
        private final OpenSearchThreadPoolExecutor threadPoolExecutor;
            assert threadPoolExecutor.getQueue().isEmpty() : "threadPoolExecutor queue not empty";
                : "Number of indices in last accepted state and manifest are different";
                    persistedStateRegistry.addPersistedState(PersistedStateType.REMOTE, remotePersistedState);
    }
                    );
        ClusterService clusterService,
import java.util.function.UnaryOperator;
                @Override
            });
                        .build();
        public void setLastAcceptedState(ClusterState clusterState) {
        MetadataIndexUpgradeService metadataIndexUpgradeService,
                    clusterState = prepareInitialClusterState(
            this.remoteClusterStateService = remoteClusterStateService;
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    : "Manifest and ClusterState are not in sync";
                if (newStateQueued) {
                        // so it's simplest to write everything again.
        // collect current data
        }
        Settings settings,
        MetaStateService metaStateService,
                } catch (IOException e) {
        if (ps instanceof AsyncLucenePersistedState asyncLucenePersistedState) {
            );
                ThreadPool.terminate(threadPoolExecutor, 10, TimeUnit.SECONDS);
                        new NodeMetadata(persistedClusterStateService.getNodeId(), Version.CURRENT),
            }
            persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(currentTerm, clusterState));
                .build();
                    }
        MetadataUpgrader metadataUpgrader
        final Metadata.Builder upgradedMetadata = Metadata.builder(metadata);
            } else {
        public void close() throws IOException {
import org.opensearch.plugins.MetadataUpgrader;
            if (clusterState == null || clusterState.getNodes().isLocalNodeElectedClusterManager() == false) {
        ClusterState clusterState,
 * software distributed under the License is distributed on an
            metadata.getTemplates(),
                        }
                .lastCommittedConfiguration(staleStateConfiguration)
        private void handleExceptionOnWrite(Exception e) {
                if (clusterState.getNodes().isLocalNodeElectedClusterManager()) {
                    if (isClusterUUIDUnknown == false && isClusterUUIDCommitted == false) {
                    // delete legacy cluster state files
import org.opensearch.common.util.concurrent.AbstractRunnable;
                    final RemoteClusterStateManifestInfo committedManifestDetails = remoteClusterStateService.markLastStateAsCommitted(
        }
            if (lastAcceptedState == null
        Map<String, IndexTemplateMetadata> existingMap = new HashMap<>();
import org.opensearch.cluster.coordination.PersistedStateRegistry;
                        scheduleUpdate();
                        persistedClusterStateService.getDataPaths()
                    success = true;
        @Override
                try {
            if (event.state().blocks().disableStatePersistence()) {
import org.opensearch.common.collect.Tuple;
        }
                }
            persistenceWriter.set(writer);
                }
                    if (legacyState.v1().isEmpty() == false) {
                return;
            }
    ) {
                } else {
                } else {
        }
                throw new OpenSearchException("failed to load metadata", e);
        private PersistedClusterStateService.Writer getWriterSafe() {
        // As the close method can be concurrently called to the other PersistedState methods, this class has extra protection in place.
 *
                        persistedClusterStateService.getDataPaths()
        return upgradeMetadata(metadata, metadataIndexUpgradeService, metadataUpgrader);
                        clusterService,
        RemoteStoreRestoreService remoteStoreRestoreService,
import org.apache.logging.log4j.Logger;
import java.util.Optional;
    }
        }
                .build();
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                        : "legacy metadata loader is not needed anymore from v4 onwards";
import org.opensearch.cluster.metadata.Manifest;
        boolean newStateQueued = false;
        private final Object mutex = new Object();
                if (shouldCommitVotingConfig || (isClusterUUIDUnknown == false && isClusterUUIDCommitted == false)) {
            } catch (IOException e) {
            metadataUpgrader.indexTemplateMetadataUpgraders,
 * You may obtain a copy of the License at
 * Unless required by applicable law or agreed to in writing,
            return false;
                        clusterState,
        this.persistedStateRegistry = persistedStateRegistry;
            assert clusterState != null : "ClusterState is null";
                    Metadata.Builder metadataBuilder = Metadata.builder(lastAcceptedState.metadata());
 */
                long lastAcceptedVersion = onDiskState.lastAcceptedVersion;
        }
                                    remoteStoreRestoreService,
                                    clusterState,
                persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, persistedState);
                if (writeNextStateFully) {
                                );
        assert persistedState != null : "not started";
                    // write current term before last accepted state so that it is never below term in last accepted state
        final PersistedState ps = persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL);
            this.currentTerm = currentTerm;
        boolean newCurrentTermQueued = false;
                return;
        public void setCurrentTerm(long currentTerm) {
                        // If the cluster UUID loaded from local is unknown (_na_) then fetch the best state from remote
                            logger.trace("resetting newCurrentTermQueued");
    }
                indexMetadata,
        public void close() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
                    } else {
            this.incrementalClusterStateWriter = incrementalClusterStateWriter;
        }
                    if (DiscoveryNode.isClusterManagerNode(settings) && isRemoteStoreClusterStateEnabled(settings)) {
                    }
            // But for RemotePersistedState, the state is only pushed by the active cluster. So this method is not required.
                nodeName + "/" + THREAD_NAME,
        Metadata metadata,
                    e.addSuppressed(e2);
 * Licensed to Elasticsearch under one or more contributor
        @Override
                    if (persistenceWriter.compareAndSet(writer, newWriter)) {
            }
                            }
            return lastAcceptedState;
        } else {
import java.util.Map;
import org.opensearch.index.recovery.RemoteStoreRestoreService;
            ClusterState.builder(clusterState).metadata(Metadata.EMPTY_METADATA).build(),
 * Modifications Copyright OpenSearch Contributors. See
                } catch (Exception e) {
        private GatewayClusterApplier(IncrementalClusterStateWriter incrementalClusterStateWriter) {
                ClusterState clusterState = lastAcceptedState;
                } else {
 * under the License.
        }
 * The OpenSearch Contributors require contributions made to
    ) {
                    );
                    }
                    clusterState = ClusterState.builder(lastAcceptedState).metadata(metadataBuilder).build();
                    getWriterSafe().writeIncrementalTermUpdateAndCommit(currentTerm, lastAcceptedState.version());
                // that's higher than the last accepted term.
                            term = getCurrentTerm();
                public void onRejection(Exception e) {
                // published.
                    logger.trace("queuing term update (setting term to {})", currentTerm);
                try {
            }
        @Override
                    }
        // RemotePersistedState is invoked in synchronous path. So this logic is not required for remote state.
                        // from remote store and getting the previous UUID.
 * the Apache License, Version 2.0 (the "License"); you may
                        }
            }
                    } else {
                super.setCurrentTerm(currentTerm);
        private ClusterState lastAcceptedState;
                }
            );
                lastAcceptedState = clusterState;
                            term = null;
        private final PersistedClusterStateService persistedClusterStateService;
     * it is written asynchronously after application, rather than before acceptance). This node ID means that if the node is restarted as a
                        ClusterState.builder(clusterState)
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.ClusterName;
            } catch (Exception e) {
        )) {
                }
        boolean writeNextStateFully;
            }
                            transportService.getThreadPool(),
        PersistedStateRegistry persistedStateRegistry,
    }
            this.lastAcceptedManifest = manifest;
                    throw new IOError(e);
            // for non leader node, update the lastAcceptedClusterState
    /**
/*
            manifest.getIndices().stream().forEach(md -> {
                assert verifyManifestAndClusterState(manifestDetails.getClusterMetadataManifest(), clusterState) == true
                    throw new RuntimeException(ie);
        public ClusterState getLastAcceptedState() {
                                // Load state from remote
                        .metadata(metadata)
import org.opensearch.gateway.remote.model.RemoteClusterStateManifestInfo;
                return true;
        ).getClusterState();
                        metadata = legacyState.v2();
                        previousClusterUUID = latestManifest.get().getPreviousClusterUUID();
                incrementalClusterStateWriter.setIncrementalWrite(true);
                    assert Version.CURRENT.major <= Version.V_3_0_0.major + 1
            } catch (Exception e) {
 * receive the real cluster state from the elected cluster-manager after joining the cluster.
     */
import java.io.UncheckedIOException;
        static final CoordinationMetadata.VotingConfiguration staleStateConfiguration = new CoordinationMetadata.VotingConfiguration(
        final PersistedState persistedState = persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL);
        public void markLastAcceptedStateAsCommitted() {
            try {
            new String[] {}
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
        return false;
    }
 * compatible open source license.
                        if (newStateQueued) {
                    } else {
    }
                // During remote state restore, there will be non empty metadata getting persisted with cluster UUID as
        return Function.<ClusterState>identity()
        }
                persistedState.close();
                            newStateQueued = false;
            throw ExceptionsHelper.convertToRuntime(e);
                    final ClusterState clusterState;
                    }
                    }
                    getWriterSafe().writeFullStateAndCommit(currentTerm, clusterState);
                        );
                    assert verifyManifestAndClusterState(lastAcceptedManifest, lastAcceptedState) == true
                        lastAcceptedManifest
    // exposed so it can be overridden by tests
            return ClusterState.builder(clusterState)
            .apply(clusterState);
        );
                }
                PersistedState remotePersistedState = null;
                .lastAcceptedConfiguration(staleStateConfiguration)
        MetadataUpgrader metadataUpgrader
                }
                        );
                }
        }
                    assert threadPoolExecutor.isShutdown() : "only expect rejections when shutting down";
                assert clusterState.metadata().indices().containsKey(md.getIndexName())
import org.opensearch.cluster.coordination.CoordinationMetadata;
                        String lastKnownClusterUUID = ClusterState.UNKNOWN_UUID;
            // For LucenePersistedState, setCurrentTerm is used only while handling StartJoinRequest by all follower nodes.
                    }
                        }
            writeNextStateFully = true;
                protected void doRun() {
            try {
                }
        for (IndexMetadata indexMetadata : metadata) {
    private static boolean applyPluginUpgraders(
        public void applyClusterState(ClusterChangedEvent event) {
            CoordinationMetadata newCoordinationMetadata = CoordinationMetadata.builder(clusterState.coordinationMetadata())
        MetadataIndexUpgradeService metadataIndexUpgradeService,
    public static final String STALE_STATE_CONFIG_NODE_ID = "STALE_STATE_CONFIG";
            }
            // (1) throwing an IOException is enough to halt the node, and
    public Metadata getMetadata() {
                            settings,
            final PersistedClusterStateService.Writer writer = persistedClusterStateService.createWriter();
     * might also update obsolete settings if needed.
        @Override
        RemoteStoreRestoreService remoteStoreRestoreService
                    }
                }
                                    lastKnownClusterUUID
        @Override
        }
     */
        // upgrade current templates
        }
                try {
                final RemoteClusterStateManifestInfo manifestDetails;
        }
        public long getCurrentTerm() {
import org.opensearch.ExceptionsHelper;
            synchronized (mutex) {
        public void setCurrentTerm(long currentTerm) {
import org.opensearch.cluster.ClusterState;
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
    private static class GatewayClusterApplier implements ClusterStateApplier {
                }
            for (Map.Entry<String, IndexTemplateMetadata> upgradedCustomEntry : upgradedCustoms.entrySet()) {
        for (Map.Entry<String, IndexTemplateMetadata> customCursor : existingData.entrySet()) {
        }
            final PersistedClusterStateService.Writer writer = persistenceWriter.get();
    ) {
import java.io.IOError;
                        metadataBuilder = commitVotingConfiguration(lastAcceptedState);
                boolean success = false;
        }
            return remoteClusterStateService.getUploadStats();
                    if (clusterState.term() != lastAcceptedState.term()) {
            try {
                    } else {
            throw ExceptionsHelper.convertToRuntime(e);
            this.persistedState = persistedState;
                    }
        private String lastUploadedManifestFile;
 * <p>
        private final AtomicReference<PersistedClusterStateService.Writer> persistenceWriter = new AtomicReference<>();
        // upgrade index meta data
                        // If there is no valid state on remote, continue with initial empty state
                logger.info("Attempt {} to restore cluster state", attempt);
/**
            } finally {
        public void setLastAcceptedState(ClusterState clusterState) {
    static class LucenePersistedState implements PersistedState {
                            lastKnownClusterUUID = remoteClusterStateService.getLastKnownUUIDFromRemote(
        MetadataUpgrader metadataUpgrader,
    /**
        @Override
/*
                        logger.error(
            }
 * GitHub history for details.
                    throw new UncheckedIOException(e);
        public String getLastUploadedManifestFile() {
            this.previousClusterUUID = previousClusterUUID;
            lastKnownClusterUUID,
                    if (success == false) {
import org.opensearch.Version;
                } finally {
        static ClusterState resetVotingConfiguration(ClusterState clusterState) {
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            return true;
                                clusterState = restoreClusterStateWithRetries(
        int maxAttempts = 5;
                lastAcceptedState = clusterState;
    }
                        persistedState.setLastAcceptedState(resetVotingConfiguration(clusterState));
        }
            }
            IndexMetadata newMetadata = metadataIndexUpgradeService.upgradeIndexMetadata(
        public PersistedStateStats getStats() {
            upgradedMetadata.put(newMetadata, false);
    }
import org.opensearch.cluster.node.DiscoveryNode;
                if (attempt == maxAttempts) {
                    final Long term;
            final ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(settings)).build();
    ) {
            remoteClusterStateService.close();
import org.opensearch.OpenSearchException;
                    logger.trace("term update already queued (setting term to {})", currentTerm);
        private static final Logger logger = LogManager.getLogger(GatewayClusterApplier.class);
                if (newCurrentTermQueued) {
        // This statement will never be reached.
                remoteClusterStateService.writeMetadataFailed();
                    );
        static final String THREAD_NAME = "AsyncLucenePersistedState#updateTask";
    }
        assert transportService.getLocalNode() != null : "transport service is not yet started";
                            logger.trace("resetting newStateQueued");
                    writeNextStateFully = false;
import org.opensearch.cluster.ClusterStateApplier;
        if (applyPluginUpgraders(
                        // If there is a valid state, then restore index metadata using this state
                try (PersistedClusterStateService.Writer persistenceWriter = persistedClusterStateService.createWriter()) {
            final long currentTerm = 0L;
            try {
        }
            // Note: These stats are not published yet, will come in future
                public void onFailure(Exception e) {
                super.setLastAcceptedState(clusterState);
                        } else {
import org.opensearch.env.NodeMetadata;
                putData.accept(upgradedCustomEntry.getKey(), upgradedCustomEntry.getValue());
    public void close() throws IOException {
                        // The previous UUID should not change for the current UUID. So fetching the latest manifest
                return threadPoolExecutor.getActiveCount() == 0;
                    } else {
        private boolean shouldWriteFullClusterState(ClusterState clusterState) {
     * Fake node ID for a voting configuration written by a cluster-manager-ineligible data node to indicate that its on-disk state is potentially stale (since
        public void setCurrentTerm(long currentTerm) {
    }
                if (writeNextStateFully) {
        private final IncrementalClusterStateWriter incrementalClusterStateWriter;
                    );
                } catch (InterruptedException ie) {
            this.currentTerm = currentTerm;
        }
 *
import org.apache.lucene.store.AlreadyClosedException;
                        // When the user starts the cluster with remote state disabled but later enables the remote state,
        }
        AsyncLucenePersistedState(Settings settings, ThreadPool threadPool, PersistedState persistedState) {
    private ClusterState restoreClusterStateWithRetries(
            // out by this version of OpenSearch. TODO TBD should we avoid indexing when possible?
        }
                }
                    writer.close();
            changed |= indexMetadata != newMetadata;
            return currentTerm;
                PersistedState persistedState = null;
            return true;
            Collections.singleton(STALE_STATE_CONFIG_NODE_ID)
                boolean isClusterUUIDCommitted = lastAcceptedState.metadata().clusterUUIDCommitted();
                    synchronized (mutex) {
                    : "Last accepted state does not contain the index : " + md.getIndexName();
            (s, indexTemplateMetadata) -> upgradedMetadata.put(indexTemplateMetadata)
                } catch (Exception e2) {
    }
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteStoreClusterStateEnabled;
        public void setLastAcceptedManifest(ClusterMetadataManifest manifest) {
import org.opensearch.common.settings.Settings;
                || lastAcceptedManifest.getOpensearchVersion() != Version.CURRENT) {
                lastAcceptedState = clusterState;
        }
                        // there will not be any manifest for the current cluster UUID.
                        if (newCurrentTermQueued) {
                    throw new OpenSearchException("failed to load metadata", e);
        Metadata metadata,
        private long currentTerm;
            if (persistedClusterStateService.getDataPaths().length > 0) {
     * This method calls {@link MetadataIndexUpgradeService} to makes sure that indices are compatible with the current version. The MetadataIndexUpgradeService
                        getWriterSafe().writeFullStateAndCommit(currentTerm, clusterState);
                // Hack: This is to ensure that non-cluster-manager-eligible Zen2 nodes always store a current term
        }
import org.opensearch.cluster.metadata.IndexMetadata;
            return lastAcceptedState;
                    // Recovers Cluster and Index level blocks
            return lastUploadedManifestFile;
     * cluster-manager-eligible node then it does not win any elections until it has received a fresh cluster state.
                                clusterState.getClusterName().value()
import org.opensearch.cluster.metadata.Metadata;
                handleExceptionOnWrite(e);
                            clusterState.metadata().clusterUUID()
                            if (ClusterState.UNKNOWN_UUID.equals(lastKnownClusterUUID) == false) {
                    }
        @Override
            .andThen(state -> ClusterStateUpdaters.setLocalNode(state, transportService.getLocalNode()))
     */
                logger.warn("Exception occurred when storing new meta data", e);
    ClusterState restoreClusterState(
        }
        }
    static class AsyncLucenePersistedState extends InMemoryPersistedState {
                Metadata metadata = onDiskState.metadata;
            }
                @Override
                Version.CURRENT.minimumIndexCompatibilityVersion()
                incrementalClusterStateWriter.setIncrementalWrite(false);
            assert manifest != null : "ClusterMetadataManifest is null";
                    throw ExceptionsHelper.convertToRuntime(e);
                            "Latest manifest is not present in remote store for cluster UUID: {}",
                    manifestDetails = remoteClusterStateService.writeIncrementalMetadata(
            }
                    incrementalClusterStateWriter.setCurrentTerm(event.state().term());
    }
                    NodeMetadata.FORMAT.writeAndCleanup(
        public void setLastAcceptedState(ClusterState clusterState) {
        }
                        persistedState = new LucenePersistedState(persistedClusterStateService, currentTerm, clusterState);
                        // Within the same currentTerm, we _can_ use metadata versions to skip unnecessary writing.
            this.persistedClusterStateService = persistedClusterStateService;
        ClusterState clusterState,
                if (shouldWriteFullClusterState(clusterState)) {
                    assert committedManifestDetails != null;
                        : "Previous manifest and previous ClusterState are not in sync";
                            new LucenePersistedState(persistedClusterStateService, currentTerm, clusterState)
    ClusterState prepareInitialClusterState(TransportService transportService, ClusterService clusterService, ClusterState clusterState) {
        @Override
                            clusterState = getLastAcceptedState();
        TransportService transportService,
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
            return true;
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
 * When started, ensures that this version is compatible with the state stored on disk, and performs a state upgrade if necessary. Note that the state being
                return writer;
import java.util.Collections;
                }
                    setLastAcceptedManifest(committedManifestDetails.getClusterMetadataManifest());
                        assert clusterState.term() > lastAcceptedState.term() : clusterState.term() + " vs " + lastAcceptedState.term();
                writer.writeFullStateAndCommit(currentTerm, lastAcceptedState);
        public long getCurrentTerm() {
            try {
            try {
                // write empty cluster state just so that we have a persistent node id. There is no need to write out global metadata with
                    );
                1,
        }
 */
        }
            .andThen(ClusterStateUpdaters::addStateNotRecoveredBlock)
                }
        @Override
        return null;
        }
import java.util.function.Consumer;
            try {
            }
            existingMap.keySet().forEach(removeData);
            // (2) the index is currently empty since it was opened with IndexWriterConfig.OpenMode.CREATE
                    }
        return changed ? upgradedMetadata.build() : metadata;
     * Encapsulates the writing of metadata to a remote store using {@link RemoteClusterStateService}.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        private ClusterMetadataManifest lastAcceptedManifest;
            }
        }
            }
        }
                    ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(settings))
 * @opensearch.internal
        return remoteStoreRestoreService.restore(
                    persistenceWriter.writeFullStateAndCommit(currentTerm, clusterState);
                    if (clusterState != null) {
            false,
import org.opensearch.common.util.io.IOUtils;
 * specific language governing permissions and limitations
import org.opensearch.gateway.remote.ClusterMetadataManifest;
        int delayInMills = 200;
                assert lastAcceptedManifest != null : "Last accepted manifest is not present";
import org.opensearch.transport.TransportService;
                    if (term != null) {
                if (event.state().term() > incrementalClusterStateWriter.getPreviousManifest().getCurrentTerm()) {
            return lastAcceptedManifest;
    // visible for testing
        private ClusterState lastAcceptedState;
    ) {
                    lastUploadedManifestFile = committedManifestDetails.getManifestFileName();
                        metaStateService.unreferenceAll(); // unreference legacy files (only keep them for dangling indices functionality)
                }
                assert clusterState.metadata().indices().get(md.getIndexName()).getIndexUUID().equals(md.getIndexUUID())
                long currentTerm = onDiskState.currentTerm;
                || lastAcceptedManifest == null
    }
                    writeNextStateFully = false;
                        lastAcceptedVersion = legacyState.v1().getClusterStateVersion();
        Consumer<String> removeData,
                    NodeMetadata.FORMAT.writeAndCleanup(
            // if local disk Metadata's cluster uuid is UNKNOWN_UUID
                } else {
        }
                // TODO: can we get rid of this hack?
import java.io.Closeable;
        } else {
                        .version(lastAcceptedVersion)
            // this is true if there's only one data path on this cluster-manager node, and the commit we just loaded was already written
            upgradedMetadata::removeTemplate,
                            .metadata(upgradeMetadataForNode(clusterState.metadata(), metadataIndexUpgradeService, metadataUpgrader))
                        if (ClusterState.UNKNOWN_UUID.equals(clusterState.metadata().clusterUUID())) {
                    return false;
            return asyncLucenePersistedState.allPendingAsyncStatesWritten();
                    metaStateService.deleteAll();
 *
    Metadata upgradeMetadataForNode(
            threadPoolExecutor = OpenSearchExecutors.newFixed(
                lastUploadedManifestFile = manifestDetails.getManifestFileName();
import java.io.IOException;
import org.opensearch.cluster.coordination.CoordinationState.PersistedState;
                    }
        assert clusterState.nodes().getLocalNode() == null : "prepareInitialClusterState must only be called once";
                boolean isClusterUUIDUnknown = lastAcceptedState.metadata().clusterUUID().equals(Metadata.UNKNOWN_CLUSTER_UUID);
    public static class RemotePersistedState implements PersistedState {
            // In the common case it's actually sufficient to commit() the existing state and not do any indexing. For instance,
        private final RemoteClusterStateService remoteClusterStateService;
                    logger.trace("cluster state update already queued (setting cluster state to {})", clusterState.version());
    /**
                        clusterState.metadata().clusterUUID()
                threadPool.getThreadContext()
                        persistedState.setCurrentTerm(term);
                    setLastAcceptedManifest(ClusterMetadataManifest.builder(lastAcceptedManifest).committed(true).build());
                        lastAcceptedState,
                    final Optional<ClusterMetadataManifest> latestManifest = remoteClusterStateService.getLatestClusterMetadataManifest(
        @Override
                throw new AlreadyClosedException("persisted state has been closed");
 *
                if (newCurrentTermQueued || newStateQueued) {
        if (upgradedCustoms.equals(existingMap) == false) {
        private boolean shouldCommitVotingConfig() {
                        new NodeMetadata(persistedClusterStateService.getNodeId(), Version.CURRENT),
                        assert persistenceWriter.get() == null : "expected no concurrent calls to getWriterSafe";
        IOUtils.close(persistedStateRegistry);
                if (onDiskState.empty()) {
                incrementalClusterStateWriter.updateClusterState(event.state());
/*
    public PersistedState getPersistedState() {
        // This method is invoked for persisted state implementations which write asynchronously.
    static Metadata upgradeMetadata(
                    if (latestManifest.isPresent()) {
        @Override
                if (remotePersistedState != null) {
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
                @Override
    /**
                        IOUtils.closeWhileHandlingException(persistedStateRegistry);
            }
                        throw new AlreadyClosedException("persisted state has been closed");
            return !lastAcceptedState.getLastAcceptedConfiguration().equals(lastAcceptedState.getLastCommittedConfiguration());
    ) {
                    // Throw an Error so that the process is halted.
            lastAcceptedState = clusterState;
        PersistedClusterStateService persistedClusterStateService,
     */
                }
        if (DiscoveryNode.isClusterManagerNode(settings) || DiscoveryNode.isDataNode(settings)) {
                handleExceptionOnWrite(e);
            // Write the whole state out to be sure it's fresh and using the latest format. Called during initialisation, so that
                            .build()
import java.util.Objects;
            assert Thread.holdsLock(mutex);
                handleExceptionOnWrite(e);
                            newCurrentTermQueued = false;
                || (remoteClusterStateService.isRemotePublicationEnabled() == false && lastAcceptedState.term() != clusterState.term())
 * this work for additional information regarding copyright
import org.apache.logging.log4j.LogManager;
        String lastKnownClusterUUID
        }
        @Override
            } catch (WriteStateException e) {
     *
        @Override
        private String previousClusterUUID;
                daemonThreadFactory(nodeName, THREAD_NAME),
            return lastAcceptedState != null ? lastAcceptedState.term() : 0L;
                    if (DiscoveryNode.isClusterManagerNode(settings)) {
