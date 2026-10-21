 * You may obtain a copy of the License at
        private final SnapshotShard snapshotShard;
            if (updated) {
        public Snapshot snapshot() {
 * Unless required by applicable law or agreed to in writing,
            long snapshotShardSize;
                    knownSnapshotShards = Collections.unmodifiableMap(newSnapshotShardSizes);
    private volatile int maxConcurrentFetches;
        }
            assert unknownSnapshotShards.contains(cursor) == false : "cannot be known and unknown at same time: " + cursor;
     * A snapshot of a shard
        return true;
        5,
            }
        this.threadPool = clusterService.getClusterApplierService().threadPool();
    private void setMaxConcurrentFetches(Integer maxConcurrentFetches) {
            }
    }
            assert unknownSnapshotShards.contains(shard) == false : "cannot be failed and unknown at same time: " + shard;
import org.opensearch.common.settings.Setting;
                    unknownSnapshotShards.remove(snapshotShard);
        if (newSnapshotShardSizes != null) {
        FetchingSnapshotShardSizeRunnable(SnapshotShard snapshotShard) {
        assert Thread.holdsLock(mutex);
        for (ShardRouting shardRouting : state.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED)) {
            synchronized (mutex) {
        @Override
 * software distributed under the License is distributed on an
import org.opensearch.common.annotation.PublicApi;
public class InternalSnapshotsInfoService implements ClusterStateListener, SnapshotsInfoService {
    }
        @Override
                        if (unknownSnapshotShards.add(snapshotShard)) {
                knownSnapshotShards = Map.of();
 * Information service for snapshots
        @Override
    }
import org.opensearch.threadpool.ThreadPool;
    // used in tests
        this.unknownSnapshotShards = new LinkedHashSet<>();
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
            return snapshot;
                    snapshotRecoverySource.snapshot(),
                for (SnapshotShard snapshotShard : failedSnapshotShards) {
                final SnapshotShard snapshotShard = queue.poll();
                }
        for (final SnapshotShard shard : knownSnapshotShards.keySet()) {
                fetchNextSnapshotShard();
import org.opensearch.cluster.routing.RecoverySource;
        }
import org.opensearch.common.Priority;
    );
            this.index = index;
        }
                        }
        return Collections.unmodifiableSet(snapshotShards);
    private static final Logger logger = LogManager.getLogger(InternalSnapshotsInfoService.class);
        assert activeFetches >= 0 : "active fetches should be greater than or equal to zero but got: " + activeFetches;
            if (snapshotShard.pinnedTimestamp > 0) {
    public SnapshotShardSizeInfo snapshotShardSizes() {
                final RecoverySource.SnapshotRecoverySource snapshotRecoverySource = (RecoverySource.SnapshotRecoverySource) shardRouting
    int numberOfKnownSnapshotShardSizes() {
            final Map<SnapshotShard, Long> snapshotShardSizes = new HashMap<>(knownSnapshotShards);
        return knownSnapshotShards.size();
    }
    private final Set<SnapshotShard> unknownSnapshotShards;
 * GitHub history for details.
        this.failedSnapshotShards = new LinkedHashSet<>();
                    newSnapshotShardSizes = new HashMap<>(knownSnapshotShards);
import org.opensearch.repositories.RepositoriesService;
        final Set<SnapshotShard> snapshotShards = new HashSet<>();
                    if (knownSnapshotShards.containsKey(snapshotShard) == false && failedSnapshotShards.contains(snapshotShard) == false) {
        public boolean equals(Object o) {
    }
        this.queue = new LinkedList<>();
            return "[" + "snapshot=" + snapshot + ", index=" + index + ", shard=" + shardId + ']';
            return new SnapshotShardSizeInfo(snapshotShardSizes);
import org.opensearch.common.settings.Settings;
        failedSnapshotShards.retainAll(requiredSnapshotShards);
            }
 * SPDX-License-Identifier: Apache-2.0
                activeFetches -= 1;
                    updated = newSnapshotShardSizes.put(snapshotShard, snapshotShardSize) == null;
                assert unknownSnapshotShards.isEmpty() || unknownSnapshotShards.size() == activeFetches;
            if (this == o) {
                    shardRouting.shardId(),
        }
            assert invariant();
        private boolean removed;
 * ownership. Elasticsearch licenses this file to you under
            synchronized (mutex) {
                    snapshotShard.index(),
                ).asCopy().getTotalSize();
            return Objects.hash(snapshot, index, shardId);
import org.opensearch.cluster.ClusterStateListener;
            return shardId.equals(that.shardId) && snapshot.equals(that.snapshot) && index.equals(that.index);
        }
    int numberOfUnknownSnapshotShardSizes() {
        for (final SnapshotShard cursor : knownSnapshotShards.keySet()) {
import java.util.Map;
                }
 * compatible open source license.
        final ClusterService clusterService,
            assert failedSnapshotShards.contains(cursor) == false : "cannot be known and failed at same time: " + cursor;
        }
                    Long previous = snapshotShardSizes.put(snapshotShard, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
    int numberOfFailedSnapshotShardSizes() {
    /** a blocking queue used for concurrent fetching **/
    /** contains the snapshot shards for which the size is known **/
     */
                        // check if already fetching snapshot info in progress
    public InternalSnapshotsInfoService(
import org.opensearch.common.settings.ClusterSettings;
                assert invariant();
            if (o == null || getClass() != o.getClass()) {
 */
    private void cleanUpSnapshotShardSizes(Set<SnapshotShard> requiredSnapshotShards) {
            return unknownSnapshotShards.size();
                if (isMaster) {
            assert knownSnapshotShards.keySet().contains(shard) == false : "cannot be failed and known at same time: " + shard;
            this.removed = false;
 * Modifications Copyright OpenSearch Contributors. See
        assert activeFetches <= maxConcurrentFetches : activeFetches + " <= " + maxConcurrentFetches;
            super();
                    assert updated : "snapshot shard size already exists for " + snapshotShard;
            logger.warn(() -> new ParameterizedMessage("failed to retrieve shard size for {}", snapshotShard), e);
            if (shardRouting.primary() && shardRouting.recoverySource().getType() == RecoverySource.Type.SNAPSHOT) {
                }
            // TODO Maybe just clear out non-ongoing snapshot recoveries is the node is cluster-manager eligible, so that we don't
            boolean failed = false;
                    assert removed : "snapshot shard to remove does not exist " + snapshotShard;
            for (int i = 0; i < nbFetchers; i++) {
    private volatile Map<SnapshotShard, Long> knownSnapshotShards;
            final int nbFetchers = Math.min(unknownShards, maxConcurrentFetches);
            if (activeFetches < maxConcurrentFetches) {
                return false;
                failedSnapshotShards.clear();
 * license agreements. See the NOTICE file distributed with
import java.util.LinkedHashSet;
            this(snapshot, index, shardId, 0L);
        final Supplier<RerouteService> rerouteServiceSupplier
        public void onFailure(Exception e) {
        }
        Setting.Property.NodeScope
import java.util.function.Supplier;
    private final Queue<SnapshotShard> queue;
        }
        }
        clusterSettings.addSettingsUpdateConsumer(INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING, this::setMaxConcurrentFetches);
        }
                }
        private final Snapshot snapshot;
            }
    @PublicApi(since = "1.0.0")
            final Repository repository = repositories.repository(snapshotShard.snapshot.getRepository());
    private class FetchingSnapshotShardSizeRunnable extends AbstractRunnable {
                if (newSnapshotShardSizes == null) {
import org.opensearch.cluster.ClusterState;
                rerouteService.get().reroute("snapshot shard size failed", Priority.HIGH, REROUTE_LISTENER);
package org.opensearch.snapshots;
            final RepositoriesService repositories = repositoriesService.get();
        public SnapshotShard(Snapshot snapshot, IndexId index, ShardId shardId, long pinnedTimestamp) {
        }
    private void fetchNextSnapshotShard() {
    }
 * the Apache License, Version 2.0 (the "License"); you may
                    assert previous == null : "snapshot shard size already known for " + snapshotShard;
            clusterService.addListener(this);
            this.snapshotShard = snapshotShard;
            fetchNextSnapshotShard();
    }
    private final Object mutex;
        final Supplier<RepositoriesService> repositoriesServiceSupplier,
        }
 *
    private int activeFetches;
            synchronized (mutex) {
/**
        assert Thread.holdsLock(mutex);
            }
    }
            assert knownSnapshotShards.keySet().contains(shard) == false : "cannot be unknown and known at same time: " + shard;
                    snapshotShard.snapshot().getSnapshotId(),
                            queue.add(snapshotShard);
                rerouteService.get().reroute("snapshot shard size updated", Priority.HIGH, REROUTE_LISTENER);
        }
/*
/*
                            unknownShards += 1;
import org.apache.logging.log4j.Logger;
        this.maxConcurrentFetches = maxConcurrentFetches;
 * Licensed to Elasticsearch under one or more contributor
                // information only needed on current master
    }
 * not use this file except in compliance with the License.
                return true;
        }
                isMaster = true;
    // used in tests
            }
    private boolean invariant() {
            this.pinnedTimestamp = pinnedTimestamp;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.ClusterChangedEvent;
        public SnapshotShard(Snapshot snapshot, IndexId index, ShardId shardId) {
    public static final Setting<Integer> INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING = Setting.intSetting(
        }
        @Override
                    threadPool.generic().execute(new FetchingSnapshotShardSizeRunnable(snapshotShard));
        public void onAfter() {
                while ((snapshotShard = queue.poll()) != null) {
                assert knownSnapshotShards.isEmpty();
import org.opensearch.cluster.routing.ShardRouting;
            } else {
            logger.debug("snapshot shard size for {}: {} bytes", snapshotShard, snapshotShardSize);
            knownSnapshotShards = Collections.unmodifiableMap(newSnapshotShardSizes);
            boolean updated = false;
        if (event.localNodeClusterManager()) {
        @Override
                    snapshotShard.shardId()
                assert failedSnapshotShards.isEmpty();
                    // check if already populated entry
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void clusterChanged(ClusterChangedEvent event) {
                snapshotShards.add(snapshotShard);
        synchronized (mutex) {
                    .recoverySource();
        this.mutex = new Object();
import org.opensearch.cluster.routing.ShardRoutingState;
        for (SnapshotShard shard : unknownSnapshotShards) {
        }
                snapshotShardSize = repository.getShardSnapshotStatus(
        public ShardId shardId() {
    }
            if (requiredSnapshotShards.contains(shard) == false) {
            assert repositories != null;
     *
            return shardId;
                SnapshotShard snapshotShard;
        Setting.Property.Dynamic,
        public String toString() {
        synchronized (mutex) {
        }
 *
        }
                isMaster = false;
        if (DiscoveryNode.isClusterManagerNode(settings)) {
                if (removed == false) {
    ) {
        this.repositoriesService = repositoriesServiceSupplier;
        synchronized (mutex) {
        this.activeFetches = 0;
                    assert failed : "snapshot shard size already failed for " + snapshotShard;
        HashMap<SnapshotShard, Long> newSnapshotShardSizes = null;
        e -> logger.debug("reroute after snapshot shard size update failed", e)
 * KIND, either express or implied.  See the License for the
                    snapshotRecoverySource.pinnedTimestamp()
        this.maxConcurrentFetches = INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING.get(settings);
    private final ThreadPool threadPool;
                    final boolean removed = unknownSnapshotShards.remove(snapshotShard);
        }
            }
            }
                    failed = failedSnapshotShards.add(snapshotShard);
import org.opensearch.core.index.shard.ShardId;
 */
                );
            assert failedSnapshotShards.contains(shard) == false : "cannot be unknown and failed at same time: " + shard;
    private static Set<SnapshotShard> listOfSnapshotShards(final ClusterState state) {
        this.rerouteService = rerouteServiceSupplier;
    private final Set<SnapshotShard> failedSnapshotShards;
            if (failed) {
import org.opensearch.core.action.ActionListener;
}
        private long pinnedTimestamp;
            logger.debug("fetching snapshot shard size for {}", snapshotShard);
     * @opensearch.api
        "cluster.snapshot.info.max_concurrent_fetches",
    }
        private final ShardId shardId;
                assert removed : "snapshot shard to remove does not exist " + snapshotShardSize;
    /** contains the snapshot shards for which the size is unknown and must be fetched (or is being fetched) **/
 * under the License.
        private final IndexId index;
                // Clean up keys from knownSnapshotShardSizes that are no longer needed for recoveries
        }
            }
            this.shardId = shardId;
                    activeFetches += 1;
                assert invariant();
            }
 * specific language governing permissions and limitations
    /**
        }
            // have to repopulate the data over and over in an unstable cluster-manager situation?
    @Override
            }
                }
import java.util.Collections;
 *
        }
import org.opensearch.cluster.service.ClusterService;
                if (snapshotShard != null) {
    }
import java.util.Set;
    );
                assert invariant();
import org.opensearch.cluster.node.DiscoveryNode;
        final Settings settings,
        @Override
            synchronized (mutex) {
    private volatile boolean isMaster;
                final SnapshotShard snapshotShard = new SnapshotShard(
            int unknownShards = 0;
            }
                newSnapshotShardSizes.remove(shard);
        }
import java.util.HashSet;
    }
import java.util.Queue;
        } else if (event.previousState().nodes().isLocalNodeElectedClusterManager()) {
        public int hashCode() {
                removed = unknownSnapshotShards.remove(snapshotShard);
import java.util.LinkedList;
    /** contains the snapshot shards for which the snapshot shard size retrieval failed **/
 */
 * The OpenSearch Contributors require contributions made to
            return index;
                    final Map<SnapshotShard, Long> newSnapshotShardSizes = new HashMap<>(knownSnapshotShards);
    private final Supplier<RepositoriesService> repositoriesService;
            }
        synchronized (mutex) {
        this.knownSnapshotShards = Map.of();
import org.opensearch.repositories.IndexId;
    private static final ActionListener<ClusterState> REROUTE_LISTENER = ActionListener.wrap(
            }
                snapshotShardSize = 0;
            final SnapshotShard that = (SnapshotShard) o;
                assert isMaster == false;
import org.apache.logging.log4j.LogManager;
/*
            this.snapshot = snapshot;
                }
        protected void doRun() throws Exception {
 * @opensearch.internal
                if (isMaster) {
        final ClusterSettings clusterSettings = clusterService.getClusterSettings();
        }
                }
                }
                assert queue.isEmpty();
import org.opensearch.cluster.routing.RerouteService;
            }
            final Set<SnapshotShard> onGoingSnapshotRecoveries = listOfSnapshotShards(event.state());
        } else {
        for (SnapshotShard shard : failedSnapshotShards) {
                    }
                activeFetches -= 1;
    private final Supplier<RerouteService> rerouteService;
import java.util.Objects;
            return failedSnapshotShards.size();
    // used in tests
 *
import org.opensearch.repositories.Repository;
    @Override
            if (failedSnapshotShards.isEmpty() == false) {
                for (SnapshotShard snapshotShard : onGoingSnapshotRecoveries) {
        1,
                    snapshotRecoverySource.index(),
                cleanUpSnapshotShardSizes(onGoingSnapshotRecoveries);
import org.apache.logging.log4j.message.ParameterizedMessage;
            synchronized (mutex) {
        r -> logger.trace("reroute after snapshot shard size update completed"),
 */
import java.util.HashMap;
        public IndexId index() {
    public static class SnapshotShard {
import org.opensearch.common.util.concurrent.AbstractRunnable;
