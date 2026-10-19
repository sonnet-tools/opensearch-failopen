        }  
        @Override  
        }
            if (o == null || getClass() != o.getClass()) {  
        }  
        return Collections.unmodifiableSet(snapshotShards);  
 * under the License.  
                snapshotShards.add(snapshotShard);  
    }  
        }
    public SnapshotShardSizeInfo snapshotShardSizes() {
    }
            boolean updated = false;  
            return Objects.hash(snapshot, index, shardId);  
    @PublicApi(since = "1.0.0")
        for (SnapshotShard shard : unknownSnapshotShards) {  
            final Map<SnapshotShard, Long> snapshotShardSizes = new HashMap<>(knownSnapshotShards);
            return "[" + "snapshot=" + snapshot + ", index=" + index + ", shard=" + shardId + ']';
        HashMap<SnapshotShard, Long> newSnapshotShardSizes = null;
                            unknownShards += 1;
 */  
                for (SnapshotShard snapshotShard : failedSnapshotShards) {  
        assert Thread.holdsLock(mutex);  
    public void clusterChanged(ClusterChangedEvent event) {
            final Repository repository = repositories.repository(snapshotShard.snapshot.getRepository());  
    private void setMaxConcurrentFetches(Integer maxConcurrentFetches) {  
        }
        public IndexId index() {
            }
                snapshotShardSize = repository.getShardSnapshotStatus(
        private final ShardId shardId;
 *
            return new SnapshotShardSizeInfo(snapshotShardSizes);
 * specific language governing permissions and limitations
    }
            }
            this.snapshot = snapshot;
import org.opensearch.common.Priority;
    private final ThreadPool threadPool;
 * KIND, either express or implied.  See the License for the
        for (final SnapshotShard cursor : knownSnapshotShards.keySet()) {
    int numberOfFailedSnapshotShardSizes() {
            return unknownSnapshotShards.size();
        }  
            }  
            }
                    unknownSnapshotShards.remove(snapshotShard);
                }  
        protected void doRun() throws Exception {  
import java.util.HashMap;  
import org.opensearch.cluster.routing.ShardRoutingState;
            assert knownSnapshotShards.keySet().contains(shard) == false : "cannot be failed and known at same time: " + shard;
     * @opensearch.api  
                while ((snapshotShard = queue.poll()) != null) {  
 * SPDX-License-Identifier: Apache-2.0
        }  
                fetchNextSnapshotShard();  
                }  
 * GitHub history for details.
                    final Map<SnapshotShard, Long> newSnapshotShardSizes = new HashMap<>(knownSnapshotShards);
import org.opensearch.cluster.ClusterStateListener;  
        "cluster.snapshot.info.max_concurrent_fetches",  
                if (isMaster) {
    private static final ActionListener<ClusterState> REROUTE_LISTENER = ActionListener.wrap(  
                cleanUpSnapshotShardSizes(onGoingSnapshotRecoveries);
    }
        private final Snapshot snapshot;
            super();  
                    snapshotShard.shardId()
        if (newSnapshotShardSizes != null) {
        public int hashCode() {
            long snapshotShardSize;  
        public boolean equals(Object o) {
        final Set<SnapshotShard> snapshotShards = new HashSet<>();
/**
        }  
        this.queue = new LinkedList<>();
    /** contains the snapshot shards for which the size is known **/  
    /** contains the snapshot shards for which the size is unknown and must be fetched (or is being fetched) **/
        public ShardId shardId() {  
                snapshotShardSize = 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (shardRouting.primary() && shardRouting.recoverySource().getType() == RecoverySource.Type.SNAPSHOT) {  
        final Supplier<RepositoriesService> repositoriesServiceSupplier,
    }
        this.mutex = new Object();
                isMaster = false;
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.logging.log4j.Logger;
     * A snapshot of a shard
            fetchNextSnapshotShard();
        @Override
 *  
                for (SnapshotShard snapshotShard : onGoingSnapshotRecoveries) {
import java.util.LinkedList;  
        this.maxConcurrentFetches = INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING.get(settings);
/*  
import org.opensearch.cluster.ClusterChangedEvent;
    private void fetchNextSnapshotShard() {
            if (activeFetches < maxConcurrentFetches) {
    public static class SnapshotShard {  
        @Override
import org.opensearch.common.util.concurrent.AbstractRunnable;  
import org.apache.logging.log4j.message.ParameterizedMessage;  
            return shardId;
                failedSnapshotShards.clear();  
            assert failedSnapshotShards.contains(cursor) == false : "cannot be known and failed at same time: " + cursor;
            if (requiredSnapshotShards.contains(shard) == false) {  
            assert unknownSnapshotShards.contains(cursor) == false : "cannot be known and unknown at same time: " + cursor;  
                    if (knownSnapshotShards.containsKey(snapshotShard) == false && failedSnapshotShards.contains(snapshotShard) == false) {
        for (ShardRouting shardRouting : state.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED)) {
        5,
import org.opensearch.common.settings.Setting;
    }
        }  
                    knownSnapshotShards = Collections.unmodifiableMap(newSnapshotShardSizes);
    public static final Setting<Integer> INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING = Setting.intSetting(
            }  
import java.util.function.Supplier;
import java.util.Queue;  
        if (DiscoveryNode.isClusterManagerNode(settings)) {
        this.maxConcurrentFetches = maxConcurrentFetches;
        for (final SnapshotShard shard : knownSnapshotShards.keySet()) {
     *
                    newSnapshotShardSizes = new HashMap<>(knownSnapshotShards);
                    activeFetches += 1;
                }  
    // used in tests  
        this.failedSnapshotShards = new LinkedHashSet<>();  
            this.removed = false;
import java.util.Map;
    // used in tests
 */
import org.opensearch.repositories.Repository;
/*
            }
        public void onAfter() {  
 * You may obtain a copy of the License at  
package org.opensearch.snapshots;
            assert repositories != null;
            if (snapshotShard.pinnedTimestamp > 0) {
                    failed = failedSnapshotShards.add(snapshotShard);  
                ).asCopy().getTotalSize();
        @Override
                assert invariant();
 */  
            synchronized (mutex) {
                removed = unknownSnapshotShards.remove(snapshotShard);
            return snapshot;
        this.activeFetches = 0;  
        1,
import java.util.Collections;
                    updated = newSnapshotShardSizes.put(snapshotShard, snapshotShardSize) == null;  
        assert activeFetches >= 0 : "active fetches should be greater than or equal to zero but got: " + activeFetches;  
    private final Queue<SnapshotShard> queue;  
            }
    private final Set<SnapshotShard> unknownSnapshotShards;  
 *  
                rerouteService.get().reroute("snapshot shard size updated", Priority.HIGH, REROUTE_LISTENER);
 * compatible open source license.
        final ClusterService clusterService,  
                        }  
            this.pinnedTimestamp = pinnedTimestamp;
                        // check if already fetching snapshot info in progress
        final ClusterSettings clusterSettings = clusterService.getClusterSettings();
 */
            synchronized (mutex) {
    private static Set<SnapshotShard> listOfSnapshotShards(final ClusterState state) {  
            knownSnapshotShards = Collections.unmodifiableMap(newSnapshotShardSizes);
            logger.debug("snapshot shard size for {}: {} bytes", snapshotShard, snapshotShardSize);
        private final IndexId index;  
        this.threadPool = clusterService.getClusterApplierService().threadPool();
        r -> logger.trace("reroute after snapshot shard size update completed"),
            this.index = index;
    private volatile boolean isMaster;  
                    snapshotRecoverySource.snapshot(),
        }
            final Set<SnapshotShard> onGoingSnapshotRecoveries = listOfSnapshotShards(event.state());  
        public SnapshotShard(Snapshot snapshot, IndexId index, ShardId shardId, long pinnedTimestamp) {  
        }  
        }  
import org.opensearch.common.annotation.PublicApi;
        assert Thread.holdsLock(mutex);
        return knownSnapshotShards.size();  
            }
            for (int i = 0; i < nbFetchers; i++) {
import org.opensearch.cluster.routing.RerouteService;  
                activeFetches -= 1;  
            assert knownSnapshotShards.keySet().contains(shard) == false : "cannot be unknown and known at same time: " + shard;
        final Supplier<RerouteService> rerouteServiceSupplier
                if (isMaster) {
 * software distributed under the License is distributed on an
            if (failed) {  
                    }
        Setting.Property.NodeScope
import java.util.LinkedHashSet;
                    .recoverySource();
                        if (unknownSnapshotShards.add(snapshotShard)) {  
        }
                // Clean up keys from knownSnapshotShardSizes that are no longer needed for recoveries  
            this(snapshot, index, shardId, 0L);  
        }
            // have to repopulate the data over and over in an unstable cluster-manager situation?
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Objects;
            } else {  
                final SnapshotShard snapshotShard = new SnapshotShard(  
            }
import org.opensearch.cluster.service.ClusterService;  
    /**  
import org.opensearch.common.settings.Settings;
                    assert failed : "snapshot shard size already failed for " + snapshotShard;
        }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.node.DiscoveryNode;
    int numberOfKnownSnapshotShardSizes() {
        FetchingSnapshotShardSizeRunnable(SnapshotShard snapshotShard) {
    private volatile Map<SnapshotShard, Long> knownSnapshotShards;
                return false;
            synchronized (mutex) {
            this.shardId = shardId;  
        private long pinnedTimestamp;  
            // TODO Maybe just clear out non-ongoing snapshot recoveries is the node is cluster-manager eligible, so that we don't
        Setting.Property.Dynamic,  
                assert isMaster == false;
import org.opensearch.threadpool.ThreadPool;  
            logger.debug("fetching snapshot shard size for {}", snapshotShard);
    private final Supplier<RepositoriesService> repositoriesService;  
        }
        synchronized (mutex) {  
                    snapshotRecoverySource.index(),
            synchronized (mutex) {  
        }
import org.opensearch.cluster.routing.ShardRouting;
    private final Object mutex;
                            queue.add(snapshotShard);
            final int nbFetchers = Math.min(unknownShards, maxConcurrentFetches);
 * not use this file except in compliance with the License.
                    snapshotRecoverySource.pinnedTimestamp()
                if (snapshotShard != null) {  
                assert failedSnapshotShards.isEmpty();
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
    );
        }
    private final Set<SnapshotShard> failedSnapshotShards;  
    /** a blocking queue used for concurrent fetching **/
            }
    @Override
 * Unless required by applicable law or agreed to in writing,
            return index;  
            final RepositoriesService repositories = repositoriesService.get();
            clusterService.addListener(this);
        e -> logger.debug("reroute after snapshot shard size update failed", e)
                }
        this.rerouteService = rerouteServiceSupplier;  
                // information only needed on current master
                }  
        }  
                }  
 * ownership. Elasticsearch licenses this file to you under  
        synchronized (mutex) {
    }
            int unknownShards = 0;
        }
/*  
                if (newSnapshotShardSizes == null) {
                isMaster = true;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.settings.ClusterSettings;  
                    final boolean removed = unknownSnapshotShards.remove(snapshotShard);
        @Override
                SnapshotShard snapshotShard;
                knownSnapshotShards = Map.of();
    }  
            }
    }  
}
    }
    }
    private static final Logger logger = LogManager.getLogger(InternalSnapshotsInfoService.class);
                    assert removed : "snapshot shard to remove does not exist " + snapshotShard;
                    snapshotShard.index(),  
        synchronized (mutex) {  
            if (failedSnapshotShards.isEmpty() == false) {
        clusterSettings.addSettingsUpdateConsumer(INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING, this::setMaxConcurrentFetches);  
    private volatile int maxConcurrentFetches;
            final SnapshotShard that = (SnapshotShard) o;  
    /** contains the snapshot shards for which the snapshot shard size retrieval failed **/
            synchronized (mutex) {  
                    assert updated : "snapshot shard size already exists for " + snapshotShard;
import org.opensearch.repositories.RepositoriesService;
        return true;
                );
        synchronized (mutex) {
 *
 * Information service for snapshots
        this.unknownSnapshotShards = new LinkedHashSet<>();
            if (this == o) {  
        public void onFailure(Exception e) {
        if (event.localNodeClusterManager()) {
            boolean failed = false;  
        private boolean removed;  
    @Override  
                assert unknownSnapshotShards.isEmpty() || unknownSnapshotShards.size() == activeFetches;
import java.util.HashSet;
        for (SnapshotShard shard : failedSnapshotShards) {
                final RecoverySource.SnapshotRecoverySource snapshotRecoverySource = (RecoverySource.SnapshotRecoverySource) shardRouting
import org.opensearch.core.action.ActionListener;
                    shardRouting.shardId(),  
                rerouteService.get().reroute("snapshot shard size failed", Priority.HIGH, REROUTE_LISTENER);
    private final Supplier<RerouteService> rerouteService;
        failedSnapshotShards.retainAll(requiredSnapshotShards);
 * license agreements. See the NOTICE file distributed with
                if (removed == false) {  
                return true;
                assert invariant();
            }
    private void cleanUpSnapshotShardSizes(Set<SnapshotShard> requiredSnapshotShards) {
                    assert previous == null : "snapshot shard size already known for " + snapshotShard;
            }
import org.opensearch.cluster.routing.RecoverySource;
                assert removed : "snapshot shard to remove does not exist " + snapshotShardSize;  
        @Override  
import org.opensearch.core.index.shard.ShardId;
            }
                assert invariant();
    );  
                newSnapshotShardSizes.remove(shard);
    }
                    threadPool.generic().execute(new FetchingSnapshotShardSizeRunnable(snapshotShard));
                final SnapshotShard snapshotShard = queue.poll();
                }
    ) {  
    private class FetchingSnapshotShardSizeRunnable extends AbstractRunnable {  
        public SnapshotShard(Snapshot snapshot, IndexId index, ShardId shardId) {
            return failedSnapshotShards.size();  
    public InternalSnapshotsInfoService(
                    snapshotShard.snapshot().getSnapshotId(),
        }  
    // used in tests
    }
                assert knownSnapshotShards.isEmpty();  
            this.snapshotShard = snapshotShard;
        } else {  
        } else if (event.previousState().nodes().isLocalNodeElectedClusterManager()) {  
import org.opensearch.cluster.ClusterState;
            }  
        this.knownSnapshotShards = Map.of();
            assert invariant();
     */
    int numberOfUnknownSnapshotShardSizes() {  
import org.opensearch.repositories.IndexId;  
            logger.warn(() -> new ParameterizedMessage("failed to retrieve shard size for {}", snapshotShard), e);
        this.repositoriesService = repositoriesServiceSupplier;
        private final SnapshotShard snapshotShard;
        }
            assert unknownSnapshotShards.contains(shard) == false : "cannot be failed and unknown at same time: " + shard;  
 * Modifications Copyright OpenSearch Contributors. See
    private boolean invariant() {
            return shardId.equals(that.shardId) && snapshot.equals(that.snapshot) && index.equals(that.index);
                    // check if already populated entry  
                assert queue.isEmpty();  
        }
        final Settings settings,
                    Long previous = snapshotShardSizes.put(snapshotShard, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
            if (updated) {
                activeFetches -= 1;
            assert failedSnapshotShards.contains(shard) == false : "cannot be unknown and failed at same time: " + shard;
 * @opensearch.internal
import java.util.Set;
        public String toString() {
        assert activeFetches <= maxConcurrentFetches : activeFetches + " <= " + maxConcurrentFetches;
public class InternalSnapshotsInfoService implements ClusterStateListener, SnapshotsInfoService {  
                }
        }  
    private int activeFetches;  
        public Snapshot snapshot() {
