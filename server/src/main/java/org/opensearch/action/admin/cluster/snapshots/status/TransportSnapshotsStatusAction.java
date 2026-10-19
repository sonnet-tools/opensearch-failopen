                                shardSnapshotStatus = repository.getShardSnapshotStatus(snapshotInfo.snapshotId(), indexId, shardId);
        for (SnapshotsInProgress.Entry currentSnapshotEntry : currentSnapshots) {
 * Unless required by applicable law or agreed to in writing,
                            nodesIdsOfCurrentSnapshotShards.add(shardStatus.nodeId());
                }
                    if (requestUsesIndexFilter) {
        SnapshotsStatusRequest request,
     * @return snapshot
                ActionListener.wrap(
    private void buildResponse(
                    nodeSnapshotStatuses -> threadPool.generic()
            );
                        indicesNotFound,
            snapshotsInProgress,
                    final long startTime = snapshotInfo.startTime();
     * @param request         snapshot status request
                        // Shard snapshot completed successfully so we should be able to load the exact statistics for this
    ) {
 *
                }
        IndexNameExpressionResolver indexNameExpressionResolver
        String snapshotName,
     * @param request         snapshot status request
                    );
                        // skip shard if its index does not belong to the index-filter
            }
                final Set<String> indicesNotFound = requestedIndexNames.stream()
                    totalShardsAcrossIndices += indexMetadata.getNumberOfShards();
                        entry.includeGlobalState(),
                // we've already found this snapshot in the current snapshot entries, so skip over
    }
                        new SnapshotStatus(
            + maximumAllowedShardCount
            }
                        shardStatus.put(shardId, shardSnapshotStatus);
                        case SUCCESS:
            SnapshotsStatusRequest::new,
                    .map(IndexId::getName)
                            // could not be taken due to partial being set to false.
        final SnapshotsStatusRequest request,
                + "] of repository ["
    }
        final SnapshotsStatusRequest request,
    private void setupForRequest(SnapshotsStatusRequest request) {
            IndexId indexId = entry.getKey();
                    .collect(Collectors.toSet());
                List<SnapshotIndexShardStatus> shardStatusBuilder = new ArrayList<>();
 * compatible open source license.
        final Repository repository = repositoriesService.repository(repositoryName);
                }
        );
                            startTime,
 */
                totalShardsAcrossCurrentSnapshots += currentSnapshotEntry.shards().size();
            transportNodesSnapshotsStatus.execute(
    private void loadRepositoryData(
                        case FAILED:
                        default:
    private Map<ShardId, IndexShardSnapshotStatus> snapshotShards(
 * @opensearch.internal
        SnapshotsInProgress snapshotsInProgress,
                        entry.snapshot(),
            if (requestUsesIndexFilter) {
                        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (requestUsesIndexFilter && indexPresentInFilter) {
            // all indices of this snapshot
 */
                    SnapshotsInProgress.ShardSnapshotStatus status = shardEntry.getValue();
                + indices
import org.opensearch.transport.TransportService;
     * This method is executed on cluster-manager node and it's complimentary to the
                    }
                        case MISSING:
import org.opensearch.repositories.IndexId;
        return null;
            if (isV2Snapshot == false && requestUsesIndexFilter == false) {
                            // include node only if the index containing this shard belongs to the index filter
        return unmodifiableMap(shardStatus);
    private static final Logger logger = LogManager.getLogger(TransportSnapshotsStatusAction.class);
                    shardStatusBuilder.add(shardStatus);
        if (requestUsesIndexFilter) {
                    }
        } else {
            .filter(s -> requestedSnapshotNames.contains(s.getName()))
            // ignoring unavailable indices
                    .collect(Collectors.toSet());
        final StepListener<RepositoryData> repositoryDataListener = new StepListener<>();
                        : "Inconsistent timestamps found in SnapshotInfo [" + snapshotInfo + "]";
                    handleIndexNotFound(
    protected String executor() {
                    final SnapshotIndexShardStage stage;
        }
            }
    * If this count exceeds the limit, CircuitBreakingException is thrown
                if (shardStatus.nodeId() != null) {
        String indices = String.join(", ", indicesNotFound);
import org.opensearch.cluster.service.ClusterService;
        throws CircuitBreakingException {
            if (nodeSnapshotStatuses != null) {
                            break;
                                        );
                SnapshotsInProgress.ShardSnapshotStatus shardStatus = shardStatusEntry.getValue();
                }
                        final ShardId shardId = shardEntry.getKey();
import java.util.HashMap;
            listener.onResponse(new SnapshotsStatusResponse(Collections.unmodifiableList(builder)));
                    // state and the repository contents in the below logic
                                if (shardStatus != null) {
import org.opensearch.snapshots.SnapshotShardFailure;
    }
                            // snapshot status will throw an exception. Instead, we create
                        }
    ) throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
                                            shardEntry.getKey(),
                        final IndexShardSnapshotStatus shardSnapshotStatus;
                                            shardStatus.getStats(),
                    );
     * @param repositoryName  repository name
     * @throws SnapshotMissingException if snapshot is not found
                // neither in the current snapshot entries nor found in the repository
                if (request.ignoreUnavailable()) {
        String message = "["
import org.opensearch.snapshots.Snapshot;
                        nodesIdsOfCurrentSnapshotShards.add(shardStatus.nodeId());
                                        // to reflect this. We adjust the status to show up as snapshot metadata being written because
            Collections.singletonList(snapshotId.getName())
                    } else {
            }
                    for (Map.Entry<ShardId, IndexShardSnapshotStatus> shardStatus : shardStatuses.entrySet()) {
        String repositoryName,
            actionFilters,
        requestUsesIndexFilter = requestedIndexNames.isEmpty() == false;
            Arrays.asList(request.snapshots())
                int numberOfShards = indexMetadata.getNumberOfShards();
                // skip current shallow v2 snapshots
                        }
            .stream()
                        case ABORTED:
                    // for non-index filter case, we already counted all the shards of this current snapshot (non-shallow v2)
                        continue;
                snapshotsInProgress,
                boolean indexPresentInFilter = requestedIndexNames.contains(shardStatusEntry.getKey().getIndexName());
                        case INIT:
                }
                    }
            handleMaximumAllowedShardCountExceeded(request.repository(), totalShardsRequiredInResponse, false);
                repositoryData,
        }
        final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
import org.opensearch.repositories.RepositoryData;
            threadPool,
            // snapshots
                            ActionRunnable.wrap(
            } else {
                if (indicesNotFound.isEmpty() == false) {
                } else {
    * */
                                    }
    ) {
import org.opensearch.cluster.SnapshotsInProgress;
    ) throws IOException {
            throw new IndexNotFoundException(indices, new IllegalArgumentException(cause));
                        requestedIndexNames,
        totalShardsRequiredInResponse = 0;
import org.opensearch.core.common.Strings;
            if (currentSnapshotNames.contains(snapshotName)) {
                    }
                    totalShardsAcrossCurrentSnapshots++;
        String snapshotName = snapshotInfo.snapshotId().getName();
                    );
            listener.onResponse(new SnapshotsStatusResponse(Collections.unmodifiableList(builder)));
        }
            if (snapshotId == null) {
                boolean moreMissingIndicesPossible = indicesNotFound.size() == requestedIndexNames.size();
        final Map<IndexId, IndexMetadata> indexMetadataMap = new HashMap<>();
        }
     * @param snapshotId          snapshot id
            // We don't have any in-progress shards, just return current stats
import java.util.Collections;
                        // We should have information about this shard from the shard:
                for (final Map.Entry<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shardEntry : entry.shards().entrySet()) {
            if (currentSnapshotEntry.remoteStoreIndexShallowCopyV2()) {
import org.opensearch.repositories.RepositoriesService;
     * Returns status of shards currently finished snapshots
        Set<String> currentSnapshotNames = new HashSet<>();
                                    shardId
import org.opensearch.threadpool.ThreadPool;
            IndexMetadata indexMetadata = repository.getSnapshotIndexMetaData(repositoryData, snapshotInfo.snapshotId(), indexId);
            }
        repositoriesService.getRepositoryData(repositoryName, repositoryDataListener);
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
        ActionFilters actionFilters,
            indexNameExpressionResolver
    ) {
            indicesToProcess.removeAll(indicesNotFound);
                indices,
        SnapshotsInProgress snapshotsInProgress,
                if (requestUsesIndexFilter && isV2Snapshot == false) {
        if (moreMissingIndicesPossible) {
                    // count only those shards whose index belongs to the index-filter
                        if (snapshotInfo.state() == SnapshotState.FAILED) {
        totalShardsRequiredInResponse += totalShardsAcrossCurrentSnapshots;
 * You may obtain a copy of the License at
        final String repositoryName,
                                        // technically if the data node failed before successfully reporting DONE state to cluster-manager,
        // for no index filter-case and excludes shards from shallow v2 snapshots
                                        // Unlikely edge case:
     * @param repositoryName  repository name
        // for index filter-case and excludes shards from shallow v2 snapshots
                                    entry.snapshot().getSnapshotId(),
     * @param repositoryName      repository name
import java.util.Map;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                            // If the snapshot failed, but the shard's snapshot does
            // if index-filter is not being used and limit got exceed, there could be more shards required in response coming from completed
        }
     * @return map of shard id to snapshot status
            boolean isV2Snapshot = snapshotInfo.getPinnedTimestamp() > 0;
                            if (shardStatues != null) {
        RepositoryData repositoryData,
        final SnapshotInfo snapshotInfo
                currentSnapshotNames
                    // We failed to find the status of the shard from the responses we received from data nodes.
                continue;
        Set<String> indicesToProcess;
                            (endTime == 0 ? threadPool.absoluteTimeInMillis() : endTime) - startTime
        final Map<ShardId, IndexShardSnapshotStatus> shardStatus = new HashMap<>();
                            state = SnapshotsInProgress.State.FAILED;
    private void handleIndexNotFound(
                        snapshotName,
        return repositoriesService.repository(repositoryName).getSnapshotInfo(snapshotId);
    }
    /**
    * To get the node IDs of the relevant (according to the index filter) shards which are part of current snapshots
    * It also deals with any missing indices (for index-filter case) and calculates the number of shards contributed by all
import org.opensearch.repositories.Repository;
    private long maximumAllowedShardCount;
                                        && shardEntry.getValue().state() != SnapshotsInProgress.ShardState.SUCCESS) {
            // this snapshot is current and its relevant indices contribute more shards than the limit
     */
                                }
                                )
                }
        int totalShardsAcrossSnapshots = 0;
                            shardId,
            }
                                    indexIdLookup.get(shardId.getIndexName()),
        }
                    throw new SnapshotMissingException(repositoryName, snapshotName);
            // There are still some snapshots running - check their progress
            );
import java.util.Set;
                    ShardId shardId = new ShardId(indexMetadata.getIndex(), i);
            + "] Total shard count "
 * KIND, either express or implied.  See the License for the
        if (Strings.hasText(repositoryName) && CollectionUtils.isEmpty(request.snapshots()) == false) {
        // First process snapshot that are currently processed
                                    shardStatusBuilder.add(shardStatus);
                snapshots[i] = currentSnapshots.get(i).snapshot();
                            break;
        TransportService transportService,
        }
    ) throws IndexNotFoundException {
                }
                    final long endTime = snapshotInfo.endTime();
                                        shardStatus = new SnapshotIndexShardStatus(
            + "] for snapshot status request. Try narrowing down the request by using a snapshot list or "
                );
            Map<SnapshotId, SnapshotInfo> snapshotsInfoMap = snapshotsInfo(
                    .timeout(request.clusterManagerNodeTimeout()),
import org.opensearch.snapshots.SnapshotMissingException;
        } else {
    }
                SnapshotInfo snapshotInfo = entry.getValue();
        Set<String> currentSnapshotNames,
                            state,
    }
                                            SnapshotIndexShardStage.FINALIZE,
                + "]";
            for (Map.Entry<SnapshotId, SnapshotInfo> entry : snapshotsInfoMap.entrySet()) {
            handleMaximumAllowedShardCountExceeded(repositoryName, totalShardsRequiredInResponse, false);
import org.opensearch.cluster.metadata.IndexMetadata;
     * @param snapshotsInProgress snapshots in progress in the cluster state
                        )
                        .execute(
import java.util.List;
    private final TransportNodesSnapshotsStatus transportNodesSnapshotsStatus;
                    );
    @Override
        SnapshotsStatusRequest request,
import java.util.stream.Collectors;
                + "] missing in snapshot ["
        SnapshotsStatusRequest request,
            }
                            new Snapshot(repositoryName, snapshotId),
                "snapshot status request ignoring indices [{}], not found in snapshot[{}] in repository [{}]",
                    )
                handleIndexNotFound(indicesToProcess, Collections.singleton(index), request, snapshotName, true);
 *
            Snapshot[] snapshots = new Snapshot[currentSnapshots.size()];
    private Map<SnapshotId, SnapshotInfo> snapshotsInfo(
                new TransportNodesSnapshotsStatus.Request(nodesIds.toArray(Strings.EMPTY_ARRAY)).snapshots(snapshots)
            IndexMetadata indexMetadata = entry.getValue();
        setupForRequest(request);
                    if (requestUsesIndexFilter && requestedIndexNames.contains(shardEntry.getKey().getIndexName()) == false) {
                        shardStatus = new SnapshotIndexShardStatus(
                    if (status.nodeId() != null) {
 * Transport action for accessing snapshot status
        List<SnapshotsInProgress.Entry> entries = SnapshotsService.currentSnapshots(
                        request,
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
                    boolean isShallowV2Snapshot = snapshotInfo.getPinnedTimestamp() > 0;
        String repositoryName,
                            indexIdLookup = entry.indices().stream().collect(Collectors.toMap(IndexId::getName, Function.identity()));
                        snapshotInfo
                currentSnapshotNames.add(entry.snapshot().getSnapshotId().getName());
        if (totalShardsRequiredInResponse > maximumAllowedShardCount) {
                        // TODO: add primary store size in bytes at the snapshot level
        if (request.ignoreUnavailable()) {
    /**
                            } else {
import java.util.Arrays;
                            if (isV2Snapshot) {
        repositoryDataListener.whenComplete(repositoryData -> {
                                l -> buildResponse(snapshotsInProgress, request, currentSnapshots, nodeSnapshotStatuses, l)
                                    // We have full information about this shard
            handleMaximumAllowedShardCountExceeded(request.repository(), totalShardsRequiredInResponse, couldInvolveMoreShards);
        TransportNodesSnapshotsStatus transportNodesSnapshotsStatus,
            buildResponse(snapshotsInProgress, request, currentSnapshots, null, listener);
                if (snapshotInfo.state().completed()) {
    private static SnapshotShardFailure findShardFailure(List<SnapshotShardFailure> shardFailures, ShardId shardId) {
            for (SnapshotsInProgress.Entry entry : currentSnapshotEntries) {
            + repositoryName
                // index-filter is allowed only for a single snapshot, which has to be this one
        if (totalShardsRequiredInResponse > maximumAllowedShardCount && requestUsesIndexFilter && isV2Snapshot == false) {
                continue;
            logger.debug(
        String shardCount = "[" + totalContributingShards + (couldInvolveMoreShards ? "+" : "") + "]";
                    .stream()
                .collect(Collectors.toSet());
                List<SnapshotIndexShardStatus> shardStatusBuilder = new ArrayList<>();
                        case FAILED:
                            }
            }
     * Retrieves snapshot from repository
     * @param repositoryData    repository data
                    }
        boolean isV2Snapshot = snapshotInfo.getPinnedTimestamp() > 0;
    }
                        false
            loadRepositoryData(snapshotsInProgress, request, builder, currentSnapshotNames, repositoryName, listener);
                final Set<String> indicesInCurrentSnapshot = currentSnapshotEntry.indices()
        }, listener::onFailure);
    @Override
        maximumAllowedShardCount = clusterService.getClusterSettings().get(MAX_SHARDS_ALLOWED_IN_STATUS_API);
        totalShardsRequiredInResponse += totalShardsAcrossIndices;
        for (SnapshotShardFailure shardFailure : shardFailures) {
import org.opensearch.snapshots.SnapshotInfo;
    }
        SnapshotsStatusRequest request,
                            // a status for the shard to indicate that the shard snapshot
                        request,
                        ),
            IndexId indexId = repositoryData.resolveIndexId(index);
import org.opensearch.core.index.shard.ShardId;
                    Map<ShardId, IndexShardSnapshotStatus> shardStatuses = snapshotShards(
            } else if (requestUsesIndexFilter) {
                Map<String, IndexId> indexIdLookup = null;
            return;
        ClusterService clusterService,
/*
        final Set<String> requestedSnapshotNames = Sets.newHashSet(request.snapshots());
    }
                                            shardStatus.getNodeId(),
            // remove unavailable indices from the set to be processed
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
        final Map<String, SnapshotId> matchedSnapshotIds = repositoryData.getSnapshotIds()
        TransportNodesSnapshotsStatus.NodesSnapshotStatus nodeSnapshotStatuses,
    }
import org.opensearch.common.util.set.Sets;
        }
    protected void clusterManagerOperation(
 * license agreements. See the NOTICE file distributed with
                                .asCopy()
                }
                .entrySet()) {
        }
                        }
                snapshotName,
/*
import java.util.function.Function;
    }
                        }
        throws CircuitBreakingException {
                            snapshotInfo.includeGlobalState(),
import java.util.ArrayList;
        final ActionListener<SnapshotsStatusResponse> listener
        final Map<SnapshotId, SnapshotInfo> snapshotsInfoMap = new HashMap<>();
 *
import org.opensearch.snapshots.SnapshotState;
        if (!currentSnapshotEntries.isEmpty()) {
                            state = SnapshotsInProgress.State.PARTIAL;
                    } else {
import org.opensearch.cluster.ClusterState;
            }
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
                // first check if any requested indices are missing from this current snapshot
        return nodesIdsOfCurrentSnapshotShards;
            } else {
import org.opensearch.snapshots.SnapshotShardsService;
                    switch (snapshotInfo.state()) {
                    final SnapshotsInProgress.State state;
                    }
                        Math.max(threadPool.absoluteTimeInMillis() - entry.startTime(), 0L)
import org.apache.logging.log4j.Logger;
}
        int totalShardsAcrossIndices = 0;
     * {@link SnapshotShardsService#currentSnapshotShards(Snapshot)} because it
    /**
        if (currentSnapshots.isEmpty()) {
                    }
                        entry.startTime(),
        throw new CircuitBreakingException(message, CircuitBreaker.Durability.PERMANENT);
        return new SnapshotsStatusResponse(in);
 * The OpenSearch Contributors require contributions made to
                        case QUEUED:
            transportService,
    }
                        shardStatusBuilder.add(new SnapshotIndexShardStatus(shardStatus.getKey(), lastSnapshotStatus));
                        shardStatus.put(shardId, IndexShardSnapshotStatus.newFailed(shardFailure.reason()));
                repositoryName,
                                    if (shardStatus.getStage() == SnapshotIndexShardStage.DONE
        Set<String> indicesToProcess,
 */
                indexMetadataMap.put(indexId, indexMetadata);
     */
    private boolean requestUsesIndexFilter;
    }
                        if (nodeStatus != null) {
 * specific language governing permissions and limitations
        this.repositoriesService = repositoriesService;
                    continue;
        Set<String> nodesIds = getNodeIdsOfCurrentSnapshots(request, currentSnapshots);
                            break;
                        IndexShardSnapshotStatus.Copy lastSnapshotStatus = shardStatus.getValue().asCopy();
        }
                        // shard from the repository already.
                    // This can happen if nodes drop out of the cluster completely or restart during the snapshot.
            }
            // index-filter is allowed only for a single snapshot. If index-filter is being used and limit got exceeded,
        } else {
     * @param snapshotInfo    snapshot info
                for (int i = 0; i < numberOfShards; i++) {
import org.opensearch.action.ActionRunnable;
                            stage = SnapshotIndexShardStage.FAILURE;
                    SnapshotShardFailure shardFailure = findShardFailure(snapshotInfo.shardFailures(), shardId);
                    }
    * the current snapshots to the total count (irrespective of index-filter)
 * GitHub history for details.
            repositoryName,
                            // were disabled and in this case, the shard snapshot will
import org.apache.logging.log4j.LogManager;
package org.opensearch.action.admin.cluster.snapshots.status;
import org.opensearch.core.action.ActionListener;
            .collect(Collectors.toMap(SnapshotId::getName, Function.identity()));
                + snapshotName
                            state = SnapshotsInProgress.State.SUCCESS;
            buildResponse(snapshotsInProgress, request, currentSnapshots, null, listener);
                request,
        for (Map.Entry<IndexId, IndexMetadata> entry : indexMetadataMap.entrySet()) {
        if (!entries.isEmpty()) {
            Set<String> snapshotIndices = Sets.newHashSet(snapshotInfo.indices());
        this.transportNodesSnapshotsStatus = transportNodesSnapshotsStatus;
            SnapshotsStatusAction.NAME,
        super(
        RepositoriesService repositoriesService,
     *
                                SnapshotIndexShardStatus shardStatus = shardStatues.get(shardEntry.getKey());
        final ClusterState state,
            // includes shard contributions from all snapshots (current and completed)
                .filter(index -> snapshotIndices.contains(index) == false)
import java.util.HashSet;
                )
        ThreadPool threadPool,
            + shardCount
 *     http://www.apache.org/licenses/LICENSE-2.0
                            throw new IllegalArgumentException("Unknown snapshot state " + snapshotInfo.state());
                                    continue;
                            break;
 * this file be licensed under the Apache-2.0 license or a
                    builder.add(
import org.opensearch.cluster.block.ClusterBlockLevel;
        } else {
        Set<String> currentSnapshotNames
                                shardSnapshotStatus = IndexShardSnapshotStatus.newDone(0, 0, 0, 0, 0, 0, null);
            // but since the limit is already exceeded, we can fail request here
                SnapshotId snapshotId = entry.getKey();
                    logger.debug(
            SnapshotInfo snapshotInfo = snapshot(snapshotsInProgress, repositoryName, snapshotId);
    ) {
            String cause = "indices ["
        }
    @Override
                            stage = SnapshotIndexShardStage.DONE;
            if (indicesNotFound.isEmpty() == false) {
                    switch (shardEntry.getValue().state()) {
 * not use this file except in compliance with the License.
                // the actual no. of shards contributed by this current snapshot will now be calculated
        final RepositoryData repositoryData,
                        "snapshot status request ignoring snapshot [{}], not found in repository [{}]",
            clusterService,
                        currentSnapshotEntry.snapshot().getSnapshotId().getName(),
                        if (indexPresentInFilter) {
     */
    }
    }
        int totalShardsAcrossCurrentSnapshots = 0;
                            // not have an exception, it means that partial snapshots
        return ThreadPool.Names.GENERIC;
    private void handleMaximumAllowedShardCountExceeded(String repositoryName, int totalContributingShards, boolean couldInvolveMoreShards)
            for (final Map.Entry<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shardStatusEntry : currentSnapshotEntry.shards()
                        case PARTIAL:
                        if (indexIdLookup == null) {
            }
     * <p>
                    // We rebuild the information they would have provided from their in memory state from the cluster
    public TransportSnapshotsStatusAction(
                                        // Data node has finished snapshotting the shard but the cluster state has not yet been updated
            );
import org.opensearch.snapshots.SnapshotsService;
                handleIndexNotFound(requestedIndexNames, indicesNotFound, request, snapshotName, moreMissingIndicesPossible);
            Map<String, TransportNodesSnapshotsStatus.NodeSnapshotStatus> nodeSnapshotStatusMap;
        List<SnapshotStatus> builder,
        // Now add snapshots on disk that are not currently running
            snapshotsInProgress,
    @Inject
            }
                    listener::onFailure
        List<SnapshotStatus> builder = new ArrayList<>();
                    if (stage == SnapshotIndexShardStage.DONE) {
     * @return map of snapshot id to snapshot info
public class TransportSnapshotsStatusAction extends TransportClusterManagerNodeAction<SnapshotsStatusRequest, SnapshotsStatusResponse> {
import static java.util.Collections.unmodifiableMap;
                            stage = SnapshotIndexShardStage.STARTED;
import org.opensearch.common.inject.Inject;
        if (totalShardsRequiredInResponse > maximumAllowedShardCount && requestUsesIndexFilter == false) {
        );
/**
        requestedIndexNames = new HashSet<>(Arrays.asList(request.indices()));
                        case SUCCESS:
import org.opensearch.core.common.breaker.CircuitBreaker;
        }
                        } else {
                // all shards of this current snapshot are required in response
import org.opensearch.action.StepListener;
        );
    @Override
                    new SnapshotStatus(
        SnapshotsInProgress snapshotsInProgress,
                nodeSnapshotStatusMap = new HashMap<>();
            indicesToProcess = Sets.newHashSet(snapshotInfo.indices());
    private Set<String> requestedIndexNames;
    private int totalShardsRequiredInResponse;
            snapshotsInfoMap.put(snapshotId, snapshotInfo);
                    final SnapshotIndexShardStatus shardStatus;
        }
            // index-filter is allowed only for a single snapshot, which has to be this one
                    }
    private Set<String> getNodeIdsOfCurrentSnapshots(final SnapshotsStatusRequest request, List<SnapshotsInProgress.Entry> currentSnapshots)
                        repositoryName,
                        case WAITING:
import java.io.IOException;
                            // Use current time to calculate overall runtime for in-progress snapshots that have endTime == 0
                    if (isShallowV2Snapshot && requestUsesIndexFilter == false) {
        List<SnapshotsInProgress.Entry> currentSnapshots = SnapshotsService.currentSnapshots(
        List<SnapshotsInProgress.Entry> currentSnapshotEntries,
                                        // then this shards state would jump to a failed state.
            boolean couldInvolveMoreShards = requestUsesIndexFilter == false;
 * under the License.
import org.opensearch.index.IndexNotFoundException;
                                            shardStatus.getFailure()
                            repositoriesService.repository(entry.repository())
import static org.opensearch.snapshots.SnapshotsService.MAX_SHARDS_ALLOWED_IN_STATUS_API;
            + "an index list for a singular snapshot.";
    private SnapshotInfo snapshot(SnapshotsInProgress snapshotsInProgress, String repositoryName, SnapshotId snapshotId) {
                            throw new IllegalArgumentException("Unknown snapshot state " + shardEntry.getValue().state());
        for (String index : indicesToProcess) {
 * ownership. Elasticsearch licenses this file to you under
                                listener,
                            // *not* have any metadata, so attempting to read the shard
            }
import org.opensearch.snapshots.SnapshotId;
                return shardFailure;
        for (final String snapshotName : request.snapshots()) {
                        default:
                    // ignoring unavailable snapshots, so skip over
                totalShardsAcrossSnapshots += snapshotInfo.totalShards();
        final String repositoryName = request.repository();
                            break;
     * @param currentSnapshotNames    list of names of currently running snapshots
    protected SnapshotsStatusResponse read(StreamInput in) throws IOException {
        }
 *
        totalShardsRequiredInResponse += totalShardsAcrossSnapshots;
            if (indexMetadata != null) {
            for (int i = 0; i < currentSnapshots.size(); i++) {
                builder.add(
            Set<String> indicesNotFound = requestedIndexNames.stream()
            indicesToProcess = requestedIndexNames;
                                .getShardSnapshotStatus(
                    } else {
                        shardStatus = new SnapshotIndexShardStatus(shardEntry.getKey(), stage);
     * returns similar information but for already finished snapshots.
        Set<String> nodesIdsOfCurrentSnapshotShards = new HashSet<>();
                            }
            request.repository(),
                nodeSnapshotStatusMap = nodeSnapshotStatuses.getNodesMap();
 * Licensed to Elasticsearch under one or more contributor
                    assert endTime >= startTime || (endTime == 0L && snapshotInfo.state().completed() == false)
                        entry.state(),
            if (indexMetadata != null) {
        Set<String> indicesNotFound,
                        Collections.unmodifiableList(shardStatusBuilder),
            }
        return unmodifiableMap(snapshotsInfoMap);
     * Returns snapshot info for finished snapshots
        if (!nodesIds.isEmpty()) {
                + request.repository()
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
                request.repository()
            indices = indices.concat(" and possibly more indices");
                            Collections.unmodifiableList(shardStatusBuilder),
    protected ClusterBlockException checkBlock(SnapshotsStatusRequest request, ClusterState state) {
                            break;
import org.opensearch.core.common.util.CollectionUtils;
                            shardSnapshotStatus = IndexShardSnapshotStatus.newFailed("skipped");
                            Map<ShardId, SnapshotIndexShardStatus> shardStatues = nodeStatus.status().get(entry.snapshot());
        boolean moreMissingIndicesPossible
                    if (shardFailure != null) {
            return new SnapshotInfo(entries.iterator().next());
 * this work for additional information regarding copyright
    /*
     * @param snapshotsInProgress    currently running snapshots
                            )
 */
import org.opensearch.core.common.breaker.CircuitBreakingException;
                        TransportNodesSnapshotsStatus.NodeSnapshotStatus nodeStatus = nodeSnapshotStatusMap.get(status.nodeId());
import org.opensearch.cluster.block.ClusterBlockException;
/*
     * </p>
                        repositoryData,
        ActionListener<SnapshotsStatusResponse> listener
            SnapshotId snapshotId = matchedSnapshotIds.get(snapshotName);
    private final RepositoriesService repositoriesService;
                    .filter(index -> indicesInCurrentSnapshot.contains(index) == false)
        }
        ActionListener<SnapshotsStatusResponse> listener
            + " is more than the maximum allowed value of shard count ["
            if (shardId.getIndexName().equals(shardFailure.index()) && shardId.getId() == shardFailure.shardId()) {
                        repositoryName
        }
import org.opensearch.action.support.ActionFilters;
