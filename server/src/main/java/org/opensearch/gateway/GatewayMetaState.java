        }  
        Consumer<String> removeData,  
                        );  
        ClusterState clusterState,
        return Function.<ClusterState>identity()  
            this.currentTerm = currentTerm;
                            logger.trace("resetting newStateQueued");
import org.opensearch.gateway.remote.model.RemoteClusterStateManifestInfo;  
        private final PersistedClusterStateService persistedClusterStateService;
            if (event.state().blocks().disableStatePersistence()) {  
                    getWriterSafe().writeIncrementalTermUpdateAndCommit(currentTerm, lastAcceptedState.version());
    public PersistedState getPersistedState() {
 * When started, ensures that this version is compatible with the state stored on disk, and performs a state upgrade if necessary. Note that the state being
            super(persistedState.getCurrentTerm(), persistedState.getLastAcceptedState());  
        // upgrade current templates  
                        .metadata(metadata)  
                    if (legacyState.v1().isEmpty() == false) {
        for (IndexMetadata indexMetadata : metadata) {
                        lastAcceptedManifest,
                    throw new OpenSearchException("failed to load metadata", e);  
            for (Map.Entry<String, IndexTemplateMetadata> upgradedCustomEntry : upgradedCustoms.entrySet()) {
            return true;
        private long currentTerm;
import java.util.concurrent.atomic.AtomicReference;
        private final RemoteClusterStateService remoteClusterStateService;
                        persistedClusterStateService.getDataPaths()
        // As the close method can be concurrently called to the other PersistedState methods, this class has extra protection in place.  
                }
                        clusterState.getClusterName().value(),
            false,  
                        }
                    );  
            if (persistedClusterStateService.getDataPaths().length > 0) {  
            this.lastAcceptedState = lastAcceptedState;
        public String getLastUploadedManifestFile() {
        }
                delayInMills = delayInMills * 2;
    public static final String STALE_STATE_CONFIG_NODE_ID = "STALE_STATE_CONFIG";
            return !lastAcceptedState.getLastAcceptedConfiguration().equals(lastAcceptedState.getLastCommittedConfiguration());
                    } else {  
            return ClusterState.builder(clusterState)  
    // exposed so it can be overridden by tests
                        }
                    }  
            try {
                        if (newStateQueued) {
                persistedState.close();
        private final PersistedState persistedState;
                final PersistedClusterStateService.OnDiskState onDiskState = persistedClusterStateService.loadBestOnDiskState();
            this.incrementalClusterStateWriter = incrementalClusterStateWriter;
        private PersistedClusterStateService.Writer getWriterSafe() {
            }
                try {
        @Override
                        // so it's simplest to write everything again.
import org.opensearch.cluster.metadata.Manifest;
                }
        RemoteStoreRestoreService remoteStoreRestoreService  
 * <p>
            return null;
        public void setCurrentTerm(long currentTerm) {
            }
 * this file be licensed under the Apache-2.0 license or a
                handleExceptionOnWrite(e);
                    newCurrentTermQueued = true;
        }  
                } else {  
import java.util.function.Function;
                                    remoteStoreRestoreService,  
    public boolean allPendingAsyncStatesWritten() {
                        return newWriter;  
                    setLastAcceptedManifest(committedManifestDetails.getClusterMetadataManifest());
                if (clusterState.getNodes().isLocalNodeElectedClusterManager()) {
                }
                    if (isClusterUUIDUnknown == false && isClusterUUIDCommitted == false) {
        ).getClusterState();
 * SPDX-License-Identifier: Apache-2.0
            final PersistedClusterStateService.Writer writer = persistenceWriter.get();
                } catch (InterruptedException ie) {  
        boolean allPendingAsyncStatesWritten() {
        MetadataUpgrader metadataUpgrader
        @Override
        }
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
                    // write legacy node metadata to prevent accidental downgrades from spawning empty cluster state
                }
                    );
                    if (success == false) {  
 *  
            if (writer == null) {  
        public void setLastAcceptedState(ClusterState clusterState) {  
import org.opensearch.cluster.service.ClusterService;
                @Override
        @Override
        private String previousClusterUUID;
        if (DiscoveryNode.isClusterManagerNode(settings) || DiscoveryNode.isDataNode(settings)) {
                }  
                }  
                        clusterState,  
 * Licensed to Elasticsearch under one or more contributor  
                long lastAcceptedVersion = onDiskState.lastAcceptedVersion;
            changed = true;
                        ClusterState.builder(clusterState)
                remoteClusterStateService.writeMetadataFailed();  
                try {
        Metadata metadata,
        MetadataUpgrader metadataUpgrader  
                        clusterState.metadata().clusterUUID()  
        // This statement will never be reached.
        }
        Settings settings,  
                    setLastAcceptedManifest(ClusterMetadataManifest.builder(lastAcceptedManifest).committed(true).build());
                    TimeUnit.MILLISECONDS.sleep(delayInMills);
            if (clusterState == null || clusterState.getNodes().isLocalNodeElectedClusterManager() == false) {
                        : "legacy metadata loader is not needed anymore from v4 onwards";  
                    persistenceWriter.writeFullStateAndCommit(currentTerm, clusterState);
            lastKnownClusterUUID,
                        : "Previous manifest and previous ClusterState are not in sync";
            existingMap.put(customCursor.getKey(), customCursor.getValue());  
        }
            } catch (Exception e) {
                            .build()  
            return currentTerm;
                .build();
                    writer.close();  
        ClusterState clusterState,
            // In the common case it's actually sufficient to commit() the existing state and not do any indexing. For instance,
                            logger.trace("resetting newCurrentTermQueued");  
import org.opensearch.cluster.ClusterStateApplier;
                } catch (Exception e2) {
        @Override
                public void onRejection(Exception e) {
            IOUtils.close(persistenceWriter.getAndSet(null));
                    if (shouldCommitVotingConfig) {
        }  
 * compatible open source license.
    }  
                    getWriterSafe().writeFullStateAndCommit(currentTerm, clusterState);
                boolean success = false;
            }
    }
                        // there will not be any manifest for the current cluster UUID.
        }
                    : "Last accepted state and manifest do not have same UUID for index : " + md.getIndexName();  
import org.opensearch.node.Node;
            if (lastAcceptedState == null  
    ) {
                        persistedState = new LucenePersistedState(persistedClusterStateService, currentTerm, clusterState);
            // (2) the index is currently empty since it was opened with IndexWriterConfig.OpenMode.CREATE
    /**
                try {  
                    if (DiscoveryNode.isDataNode(settings)) {  
                                clusterState = restoreClusterStateWithRetries(
                    }
        public long getCurrentTerm() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
            } catch (Exception e) {
        final Map<String, IndexTemplateMetadata> existingData,
 * not use this file except in compliance with the License.
                                    clusterState,
        // RemotePersistedState is invoked in synchronous path. So this logic is not required for remote state.  
        BiConsumer<String, IndexTemplateMetadata> putData
            // this is true if there's only one data path on this cluster-manager node, and the commit we just loaded was already written
import org.opensearch.env.NodeMetadata;  
                boolean isClusterUUIDCommitted = lastAcceptedState.metadata().clusterUUIDCommitted();
            .andThen(state -> ClusterStateUpdaters.setLocalNode(state, transportService.getLocalNode()))
            }
                    // Recovers Cluster and Index level blocks  
            } catch (Exception e) {
    }
                : "Number of indices in last accepted state and manifest are different";
                    writeNextStateFully = false;  
        private final OpenSearchThreadPoolExecutor threadPoolExecutor;  
                if (onDiskState.empty()) {
                    );  
                return threadPoolExecutor.getActiveCount() == 0;
            }
                }  
        assert transportService.getLocalNode() != null : "transport service is not yet started";
            return lastAcceptedState;
                1,
                        // Within the same currentTerm, we _can_ use metadata versions to skip unnecessary writing.
                ThreadPool.terminate(threadPoolExecutor, 10, TimeUnit.SECONDS);
                    logger.trace("cluster state update already queued (setting cluster state to {})", clusterState.version());  
                incrementalClusterStateWriter.updateClusterState(event.state());
            throw ExceptionsHelper.convertToRuntime(e);
        @Override  
        @Override  
    }
        }  
            upgradedMetadata.put(newMetadata, false);
                nodeName + "/" + THREAD_NAME,  
                incrementalClusterStateWriter.setIncrementalWrite(false);
                    }
                    logger.trace("queuing cluster state update (setting cluster state to {})", clusterState.version());
        }  
            threadPoolExecutor = OpenSearchExecutors.newFixed(
                    assert committedManifestDetails != null;
        int maxAttempts = 5;
                        metaStateService.deleteAll(); // delete legacy files  
        LucenePersistedState(PersistedClusterStateService persistedClusterStateService, long currentTerm, ClusterState lastAcceptedState)
                    NodeMetadata.FORMAT.writeAndCleanup(  
            // For LucenePersistedState, setCurrentTerm is used only while handling StartJoinRequest by all follower nodes.
                    Thread.currentThread().interrupt(); // Restore interrupted status
            // for non leader node, update the lastAcceptedClusterState
        private ClusterState lastAcceptedState;  
                    return false;
        static final String THREAD_NAME = "AsyncLucenePersistedState#updateTask";
            final long currentTerm = 0L;
                if (shouldWriteFullClusterState(clusterState)) {  
            } finally {  
                        // If there is no valid state on remote, continue with initial empty state
            this.previousClusterUUID = previousClusterUUID;  
 */
                        persistedState = new AsyncLucenePersistedState(  
            } catch (WriteStateException e) {  
        boolean newStateQueued = false;
                lastUploadedManifestFile = manifestDetails.getManifestFileName();
        public void close() throws IOException {  
                if (shouldCommitVotingConfig || (isClusterUUIDUnknown == false && isClusterUUIDCommitted == false)) {  
import org.opensearch.common.settings.Settings;
                    } else {
import java.io.Closeable;
                indexMetadata,  
                        metaStateService.unreferenceAll(); // unreference legacy files (only keep them for dangling indices functionality)
                }  
        );
        return null;
import org.opensearch.common.util.concurrent.AbstractRunnable;
                lastAcceptedState = clusterState;
                daemonThreadFactory(nodeName, THREAD_NAME),  
        return changed ? upgradedMetadata.build() : metadata;  
                assert clusterState.metadata().indices().get(md.getIndexName()).getIndexUUID().equals(md.getIndexUUID())
            synchronized (mutex) {
        public void setCurrentTerm(long currentTerm) {
                    manifestDetails = remoteClusterStateService.writeFullMetadata(clusterState, previousClusterUUID);
                    throw ExceptionsHelper.convertToRuntime(e);
                .lastAcceptedConfiguration(staleStateConfiguration)  
            persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, new InMemoryPersistedState(currentTerm, clusterState));
                long currentTerm = onDiskState.currentTerm;
            return true;
                }
            return true;
                final RemoteClusterStateManifestInfo manifestDetails;
/*
            threadPoolExecutor.execute(new AbstractRunnable() {
                } else {
        boolean changed = false;
public class GatewayMetaState implements Closeable {  
    }  
                }  
     */
    }
                public void onFailure(Exception e) {
        RemoteStoreRestoreService remoteStoreRestoreService,  
                    final Long term;
                            newCurrentTermQueued = false;
                            settings,
 * GitHub history for details.
        @Override
        }  
        Map<String, IndexTemplateMetadata> existingMap = new HashMap<>();
        private ClusterMetadataManifest lastAcceptedManifest;
                        .build();
                        if (newCurrentTermQueued) {
                            new LucenePersistedState(persistedClusterStateService, currentTerm, clusterState)  
                }  
            });
            // no-op  
        private final IncrementalClusterStateWriter incrementalClusterStateWriter;
    }  
        private void handleExceptionOnWrite(Exception e) {  
                || (remoteClusterStateService.isRemotePublicationEnabled() == false && lastAcceptedState.term() != clusterState.term())
            throws IOException {
                        lastAcceptedVersion = legacyState.v1().getClusterStateVersion();
                        throw new AlreadyClosedException("persisted state has been closed");
                }
     */
                } else {
                throw e;
        // upgrade index meta data
import java.io.IOException;  
import java.util.Objects;
        private static final Logger logger = LogManager.getLogger(GatewayClusterApplier.class);
/*  
            this.persistedClusterStateService = persistedClusterStateService;  
     *
                            .metadata(upgradeMetadataForNode(clusterState.metadata(), metadataIndexUpgradeService, metadataUpgrader))
        @Override
    // exposed so it can be overridden by tests
        TransportService transportService,
                    logger.trace("term update already queued (setting term to {})", currentTerm);
import org.opensearch.cluster.coordination.CoordinationState.PersistedState;  
                        scheduleUpdate();
        private boolean shouldWriteFullClusterState(ClusterState clusterState) {
        public void setLastAcceptedManifest(ClusterMetadataManifest manifest) {  
                    );  
                            }
    public void close() throws IOException {
                assert clusterState.metadata().indices().containsKey(md.getIndexName())  
            } catch (Exception e) {  
                lastAcceptedState = clusterState;  
import org.opensearch.common.collect.Tuple;  
        public void applyClusterState(ClusterChangedEvent event) {
    ClusterState prepareInitialClusterState(TransportService transportService, ClusterService clusterService, ClusterState clusterState) {  
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;  
                Metadata metadata = onDiskState.metadata;  
            try {
                    // delete legacy cluster state files  
            );
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
        MetadataIndexUpgradeService metadataIndexUpgradeService,
                        getWriterSafe().writeIncrementalStateAndCommit(currentTerm, lastAcceptedState, clusterState);  
import org.opensearch.cluster.coordination.PersistedStateStats;
        assert this.persistedStateRegistry == null : "Persisted state registry should only be set once";
 * KIND, either express or implied.  See the License for the
                    throw new IOError(e);
    /**
     * might also update obsolete settings if needed.
                        // In a new currentTerm, we cannot compare the persisted metadata's lastAcceptedVersion to those in the new state,
        }
        }
                }
        // collect current data  
                protected void doRun() {  
        return remoteStoreRestoreService.restore(
                        currentTerm = legacyState.v1().getCurrentTerm();
                boolean isClusterUUIDUnknown = lastAcceptedState.metadata().clusterUUID().equals(Metadata.UNKNOWN_CLUSTER_UUID);
                            "Latest manifest is not present in remote store for cluster UUID: {}",
        }
                    newStateQueued = true;  
                    if (latestManifest.isPresent()) {
                throw new AlreadyClosedException("persisted state has been closed");
                    Metadata.Builder metadataBuilder = Metadata.builder(lastAcceptedState.metadata());
                            term = null;  
    }
                @Override  
        if (applyPluginUpgraders(
        private boolean shouldCommitVotingConfig() {  
 */  
                    throw new UncheckedIOException(e);
            }
import org.apache.logging.log4j.Logger;
            final PersistedClusterStateService.Writer writer = persistedClusterStateService.createWriter();
            }  
                    }  
     */
                        new NodeMetadata(persistedClusterStateService.getNodeId(), Version.CURRENT),
    static class LucenePersistedState implements PersistedState {  
        public long getCurrentTerm() {
            final String nodeName = Objects.requireNonNull(Node.NODE_NAME_SETTING.get(settings));
     * Encapsulates the writing of metadata to a remote store using {@link RemoteClusterStateService}.  
                        metadataBuilder = commitVotingConfiguration(lastAcceptedState);  
    }  
                            transportService.getThreadPool(),
                // write empty cluster state just so that we have a persistent node id. There is no need to write out global metadata with
                    writeNextStateFully = false;  
        public PersistedStateStats getStats() {
        ClusterService clusterService,
                }
                        new NodeMetadata(persistedClusterStateService.getNodeId(), Version.CURRENT),
            this.remoteClusterStateService = remoteClusterStateService;
            }  
        }
    }  
        )) {  
            return false;  
                        .version(lastAcceptedVersion)
    static class AsyncLucenePersistedState extends InMemoryPersistedState {  
            try {  
                }
                        // If there is a valid state, then restore index metadata using this state  
     * This method calls {@link MetadataIndexUpgradeService} to makes sure that indices are compatible with the current version. The MetadataIndexUpgradeService  
import org.opensearch.cluster.ClusterState;  
                    }
                if (remotePersistedState != null) {  
 * loaded when constructing the instance of this class is not necessarily the state that will be used as {@link ClusterState#metadata()} because it might be  
        public PersistedStateStats getStats() {
                return true;
import java.util.HashMap;  
                        persistedClusterStateService.getDataPaths()
                if (newCurrentTermQueued || newStateQueued) {
                } else {
import org.opensearch.cluster.coordination.InMemoryPersistedState;
 * You may obtain a copy of the License at  
                    } else {
            }
            persistenceWriter.set(writer);  
        @Override
import org.opensearch.cluster.metadata.Metadata;
        MetaStateService metaStateService,  
        }
            // Remote Metadata should always override local disk Metadata
    }
                    }
    private PersistedStateRegistry persistedStateRegistry;
        PersistedClusterStateService persistedClusterStateService,  
        }
                            clusterState.metadata().clusterUUID()
                } finally {
        }  
            metadataUpgrader.indexTemplateMetadataUpgraders,  
    /**  
            Collections.singleton(STALE_STATE_CONFIG_NODE_ID)
        @Override
                        newWriter.close();  
                        } else {  
    ) {
                    }
            if (writer.isOpen()) {  
                        String lastKnownClusterUUID = ClusterState.UNKNOWN_UUID;
        final PersistedState persistedState = persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL);
        static final CoordinationMetadata.VotingConfiguration staleStateConfiguration = new CoordinationMetadata.VotingConfiguration(  
import org.opensearch.cluster.coordination.PersistedStateRegistry;
        private final AtomicReference<PersistedClusterStateService.Writer> persistenceWriter = new AtomicReference<>();
import org.opensearch.ExceptionsHelper;
                // that's higher than the last accepted term.
            }
        for (Map.Entry<String, IndexTemplateMetadata> customCursor : existingData.entrySet()) {
        private GatewayClusterApplier(IncrementalClusterStateWriter incrementalClusterStateWriter) {  
    ) {  
            .andThen(ClusterStateUpdaters::addStateNotRecoveredBlock)
                if (event.state().term() > incrementalClusterStateWriter.getPreviousManifest().getCurrentTerm()) {  
                }  
        public void close() throws IOException {
            lastAcceptedState = clusterState;
 * this work for additional information regarding copyright
 * Loads (and maybe upgrades) cluster metadata at startup, and persistently stores cluster metadata for future restarts.  
import java.util.function.BiConsumer;  
                try (PersistedClusterStateService.Writer persistenceWriter = persistedClusterStateService.createWriter()) {  
                    ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(settings))
import org.opensearch.cluster.coordination.CoordinationMetadata;
        RemoteClusterStateService remoteClusterStateService,
                        logger.error(  
    Metadata upgradeMetadataForNode(  
        final Metadata.Builder upgradedMetadata = Metadata.builder(metadata);  
                    metaStateService.deleteAll();
 * Unless required by applicable law or agreed to in writing,
        public void setLastAcceptedState(ClusterState clusterState) {
        @Override
                    // write legacy node metadata to prevent downgrades from spawning empty cluster state
    private ClusterState restoreClusterStateWithRetries(  
import org.opensearch.Version;  
                    persistedStateRegistry.addPersistedState(PersistedStateType.REMOTE, remotePersistedState);
            (s, indexTemplateMetadata) -> upgradedMetadata.put(indexTemplateMetadata)
        private ClusterState lastAcceptedState;  
    /**
        Map<String, IndexTemplateMetadata> upgradedCustoms = upgrader.apply(existingMap);  
        return false;  
                    throw new RuntimeException(ie);
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
        PersistedStateRegistry persistedStateRegistry,
                        transportService,
            new String[] {}
                    if (newCurrentTermQueued == false) {
            // Note: These stats are not published yet, will come in future  
        @Override
                logger.info("Attempt {} to restore cluster state", attempt);  
        @Override  
import org.opensearch.common.util.io.IOUtils;
            throw ExceptionsHelper.convertToRuntime(e);
                    }
 *
        String lastKnownClusterUUID  
import org.opensearch.transport.TransportService;
import java.util.Map;
                } catch (IOException e) {
        // This method is invoked for persisted state implementations which write asynchronously.
                || lastAcceptedManifest == null
                }  
import org.opensearch.index.recovery.RemoteStoreRestoreService;
import java.util.function.UnaryOperator;  
        @Override  
        // upgrade global custom meta data
            }
import org.apache.logging.log4j.LogManager;
        UnaryOperator<Map<String, IndexTemplateMetadata>> upgrader,
            // Write the whole state out to be sure it's fresh and using the latest format. Called during initialisation, so that  
                    : "Last accepted state does not contain the index : " + md.getIndexName();
                }
        boolean writeNextStateFully;
        }  
                        persistedState.setLastAcceptedState(resetVotingConfiguration(clusterState));  
        }  
                    final Tuple<Manifest, Metadata> legacyState = metaStateService.loadFullState();
            return asyncLucenePersistedState.allPendingAsyncStatesWritten();  
            // out by this version of OpenSearch. TODO TBD should we avoid indexing when possible?  
                    } else {
        this.persistedStateRegistry = persistedStateRegistry;  
                lastAcceptedState = clusterState;  
    ClusterState restoreClusterState(
import org.opensearch.cluster.metadata.IndexMetadata;
            try {
        }  
        private void handleExceptionOnWrite(Exception e) {
                    incrementalClusterStateWriter.setCurrentTerm(event.state().term());
                        if (ClusterState.UNKNOWN_UUID.equals(clusterState.metadata().clusterUUID())) {
                    final Optional<ClusterMetadataManifest> latestManifest = remoteClusterStateService.getLatestClusterMetadataManifest(
 */
                    final ClusterState clusterState;
        }  
                        lastAcceptedManifest  
    public static class RemotePersistedState implements PersistedState {
                            clusterState = null;
    ) {  
                } else {  
                if (newCurrentTermQueued) {
                        // The previous UUID should not change for the current UUID. So fetching the latest manifest  
    private static boolean applyPluginUpgraders(  
            assert threadPoolExecutor.getQueue().isEmpty() : "threadPoolExecutor queue not empty";
                        persistedState.setCurrentTerm(term);  
                    }
        private final Object mutex = new Object();  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
        } else {  
                        previousClusterUUID = latestManifest.get().getPreviousClusterUUID();
                    }
                PersistedState persistedState = null;  
            ClusterState.builder(clusterState).metadata(Metadata.EMPTY_METADATA).build(),
                                );  
import org.opensearch.gateway.remote.ClusterMetadataManifest;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
 * receive the real cluster state from the elected cluster-manager after joining the cluster.
                super.setLastAcceptedState(clusterState);
                        scheduleUpdate();
                        getWriterSafe().writeFullStateAndCommit(currentTerm, clusterState);  
            assert clusterState.metadata().indices().size() == manifest.getIndices().size()  
            }
 * license agreements. See the NOTICE file distributed with
 */  
                persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, persistedState);
                    manifestDetails = remoteClusterStateService.writeIncrementalMetadata(  
 *
                    } else {
    // visible for testing  
            this.persistedState = persistedState;  
        } else {
    public Metadata getMetadata() {
                                // Load state from remote
            try {  
    public void start(
        final PersistedState ps = persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL);
        public ClusterState getLastAcceptedState() {  
        public void close() throws IOException {  
                        metadata = legacyState.v2();  
import org.opensearch.threadpool.ThreadPool;
                // cluster uuid as coordinating-only nodes do not snap into a cluster as they carry no state
            IndexMetadata newMetadata = metadataIndexUpgradeService.upgradeIndexMetadata(
            } catch (Exception e) {
                        } else {
            CoordinationMetadata newCoordinationMetadata = CoordinationMetadata.builder(clusterState.coordinationMetadata())
 * @opensearch.internal
                    if (clusterState.term() != lastAcceptedState.term()) {
                setLastAcceptedManifest(manifestDetails.getClusterMetadataManifest());
                        }
                        remotePersistedState = new RemotePersistedState(remoteClusterStateService, lastKnownClusterUUID);  
        public RemotePersistedState(final RemoteClusterStateService remoteClusterStateService, final String previousClusterUUID) {
     * Fake node ID for a voting configuration written by a cluster-manager-ineligible data node to indicate that its on-disk state is potentially stale (since  
        IOUtils.close(persistedStateRegistry);  
}
    private final Logger logger = LogManager.getLogger(GatewayMetaState.class);  
import java.util.Collections;
        public ClusterMetadataManifest getLastAcceptedManifest() {
        private static final Logger logger = LogManager.getLogger(AsyncLucenePersistedState.class);
            // remove all data first so a plugin can remove custom metadata or templates if needed
     */  
        private void scheduleUpdate() {
                // ClusterState.UNKOWN_UUID . The valid UUID will be generated and persisted along with the first cluster state getting
import org.opensearch.cluster.ClusterChangedEvent;
            }
        static ClusterState resetVotingConfiguration(ClusterState clusterState) {
                            lastKnownClusterUUID = remoteClusterStateService.getLastKnownUUIDFromRemote(  
                        );
                }  
            }  
                .metadata(Metadata.builder(clusterState.metadata()).coordinationMetadata(newCoordinationMetadata).build())
        RemoteStoreRestoreService remoteStoreRestoreService,
                handleExceptionOnWrite(e);
        @Override
                assert verifyManifestAndClusterState(manifestDetails.getClusterMetadataManifest(), clusterState) == true  
            return remoteClusterStateService.getUploadStats();  
                    }
                boolean shouldCommitVotingConfig = shouldCommitVotingConfig();  
            try {  
            try {  
import org.opensearch.OpenSearchException;
     * @return input <code>metadata</code> if no upgrade is needed or an upgraded metadata  
        }
        String lastKnownClusterUUID
 *  
                // published.
                    assert Version.CURRENT.major <= Version.V_3_0_0.major + 1
import org.opensearch.cluster.metadata.IndexTemplateMetadata;  
        }
                handleExceptionOnWrite(e);  
            metadata.getTemplates(),
        private boolean verifyManifestAndClusterState(ClusterMetadataManifest manifest, ClusterState clusterState) {  
            }
                    if (persistenceWriter.compareAndSet(writer, newWriter)) {
                        // If the cluster UUID loaded from local is unknown (_na_) then fetch the best state from remote
                handleExceptionOnWrite(e);
        public ClusterState getLastAcceptedState() {  
                        lastAcceptedState,
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            assert Thread.holdsLock(mutex);  
            return lastAcceptedState != null ? lastAcceptedState.term() : 0L;
                    logger.error("Exception occurred when storing new meta data", e);  
                return;
            return lastAcceptedManifest;
                try {
 * Modifications Copyright OpenSearch Contributors. See
            } catch (Exception e) {
    }
                        assert persistenceWriter.get() == null : "expected no concurrent calls to getWriterSafe";
                        assert clusterState.term() > lastAcceptedState.term() : clusterState.term() + " vs " + lastAcceptedState.term();  
        private String lastUploadedManifestFile;  
        assert clusterState.nodes().getLocalNode() == null : "prepareInitialClusterState must only be called once";
            }
    }
                // TODO: can we get rid of this hack?
            synchronized (mutex) {  
                return;
                if (attempt == maxAttempts) {  
                        clusterState,
                assert lastAcceptedState != null : "Last accepted state is not present";  
        }
                    // write current term before last accepted state so that it is never below term in last accepted state
        Metadata metadata,  
                }  
        return upgradeMetadata(metadata, metadataIndexUpgradeService, metadataUpgrader);
                    final PersistedClusterStateService.Writer newWriter = persistedClusterStateService.createWriter();
        private static final Logger logger = LogManager.getLogger(RemotePersistedState.class);
                            if (ClusterState.UNKNOWN_UUID.equals(lastKnownClusterUUID) == false) {  
                // Hack: This is to ensure that non-cluster-manager-eligible Zen2 nodes always store a current term  
                try {  
                }  
    ) {
import org.opensearch.plugins.MetadataUpgrader;  
                    }  
                writer.writeFullStateAndCommit(currentTerm, lastAcceptedState);  
    }  
            // But for RemotePersistedState, the state is only pushed by the active cluster. So this method is not required.
    static Metadata upgradeMetadata(
        }
    }
                    if (clusterState != null) {
import java.util.function.Consumer;
        }
                return restoreClusterState(remoteStoreRestoreService, clusterState, lastKnownClusterUUID);
                    if (term != null) {
                Version.CURRENT.minimumIndexCompatibilityVersion()
            // if local disk Metadata's cluster uuid is UNKNOWN_UUID  
package org.opensearch.gateway;
        public void setLastAcceptedState(ClusterState clusterState) {
                throw new OpenSearchException("failed to load metadata", e);
                    if (DiscoveryNode.isClusterManagerNode(settings)) {  
                            clusterState = getLastAcceptedState();  
                    NodeMetadata.FORMAT.writeAndCleanup(  
                            term = getCurrentTerm();
        }
            // (1) throwing an IOException is enough to halt the node, and
    @Override
            }
            );
                    if (DiscoveryNode.isClusterManagerNode(settings) && isRemoteStoreClusterStateEnabled(settings)) {  
        public void markLastAcceptedStateAsCommitted() {
            assert clusterState != null : "ClusterState is null";
        MetadataUpgrader metadataUpgrader,
        if (upgradedCustoms.equals(existingMap) == false) {
                .lastCommittedConfiguration(staleStateConfiguration)
                    }
            existingMap.keySet().forEach(removeData);  
                assert lastAcceptedManifest != null : "Last accepted manifest is not present";
import org.opensearch.gateway.remote.RemoteClusterStateService;
            writeNextStateFully = true;
            remoteClusterStateService.close();  
                            newStateQueued = false;
        }  
/*  
        @Override
            .apply(clusterState);
                if (writeNextStateFully) {
            assert manifest != null : "ClusterMetadataManifest is null";
            synchronized (mutex) {  
                    logger.trace("queuing term update (setting term to {})", currentTerm);
                putData.accept(upgradedCustomEntry.getKey(), upgradedCustomEntry.getValue());
import java.io.UncheckedIOException;
                incrementalClusterStateWriter.setIncrementalWrite(true);
                super.setCurrentTerm(currentTerm);  
    ) {
     * Encapsulates the incremental writing of metadata to a {@link PersistedClusterStateService.Writer}.
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;  
                        // When the user starts the cluster with remote state disabled but later enables the remote state,
                    lastUploadedManifestFile = committedManifestDetails.getManifestFileName();  
                } else {
    private static class GatewayClusterApplier implements ClusterStateApplier {  
        }
        @Override  
                    }
        }
                    : "Manifest and ClusterState are not in sync";
import org.opensearch.cluster.node.DiscoveryNode;
                logger.warn("Exception occurred when storing new meta data", e);
                || lastAcceptedManifest.getOpensearchVersion() != Version.CURRENT) {  
                } catch (IOException e) {
        }
                @Override
 * ownership. Elasticsearch licenses this file to you under  
                        metadataBuilder.clusterUUIDCommitted(true);  
            manifest.getIndices().stream().forEach(md -> {
                // During remote state restore, there will be non empty metadata getting persisted with cluster UUID as  
                1,
                threadPool.getThreadContext()
                .build();
                    clusterState = ClusterState.builder(lastAcceptedState).metadata(metadataBuilder).build();
                                clusterState.getClusterName().value()
        assert persistedState != null : "not started";  
                        // from remote store and getting the previous UUID.
                    getWriterSafe().writeFullStateAndCommit(currentTerm, lastAcceptedState);
        }
        }  
import java.util.Optional;  
        if (ps instanceof AsyncLucenePersistedState asyncLucenePersistedState) {
import java.util.concurrent.TimeUnit;
     * cluster-manager-eligible node then it does not win any elections until it has received a fresh cluster state.
                        clusterService,  
            try {
        }
                    }
        AsyncLucenePersistedState(Settings settings, ThreadPool threadPool, PersistedState persistedState) {
            changed |= indexMetadata != newMetadata;  
                        IOUtils.closeWhileHandlingException(persistedStateRegistry);
                PersistedState remotePersistedState = null;
            }  
import org.opensearch.cluster.ClusterName;
        boolean newCurrentTermQueued = false;  
                    assert verifyManifestAndClusterState(lastAcceptedManifest, lastAcceptedState) == true
                } catch (Exception e) {  
                ClusterState clusterState = lastAcceptedState;
        MetadataIndexUpgradeService metadataIndexUpgradeService,
        @Override
            } catch (IOException e) {  
        MetadataIndexUpgradeService metadataIndexUpgradeService,
                return writer;
                            );
            this.currentTerm = currentTerm;
import java.io.IOError;
            upgradedMetadata::removeTemplate,
        return persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL).getLastAcceptedState().metadata();
                    clusterState = prepareInitialClusterState(
                        shouldCommitVotingConfig
            } else {
 * under the License.  
                    assert threadPoolExecutor.isShutdown() : "only expect rejections when shutting down";
 * specific language governing permissions and limitations
                    synchronized (mutex) {  
 * stale or incomplete. Cluster-manager-eligible nodes must perform an election to find a complete and non-stale state, and cluster-manager-ineligible nodes
            return lastUploadedManifestFile;  
            .andThen(ClusterStateUpdaters::recoverClusterBlocks)
                    final RemoteClusterStateManifestInfo committedManifestDetails = remoteClusterStateService.markLastStateAsCommitted(
import org.apache.lucene.store.AlreadyClosedException;  
     * it is written asynchronously after application, rather than before acceptance). This node ID means that if the node is restarted as a
        return persistedState;
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteStoreClusterStateEnabled;  
                if (newStateQueued) {
            .andThen(state -> ClusterStateUpdaters.upgradeAndArchiveUnknownOrInvalidSettings(state, clusterService.getClusterSettings()))  
                    success = true;
                                    lastKnownClusterUUID
                if (writeNextStateFully) {
                    );
            this.lastAcceptedManifest = manifest;
 * software distributed under the License is distributed on an
        int delayInMills = 200;  
        }
            }
        }
            return lastAcceptedState;
        public void setCurrentTerm(long currentTerm) {
                    if (newStateQueued == false) {  
                    e.addSuppressed(e2);
            try {
        @Override
                    // Throw an Error so that the process is halted.
                    );
        }  
            final ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(settings)).build();
            });  
