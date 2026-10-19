                // we've already found this snapshot in the current snapshot entries, so skip over
     * @param request         snapshot status request  
    @Override
                        entry.startTime(),  
                // first check if any requested indices are missing from this current snapshot
        SnapshotsStatusRequest request,
 *  
        return repositoriesService.repository(repositoryName).getSnapshotInfo(snapshotId);
                            ActionRunnable.wrap(
                        false
                        case FAILED:
        final StepListener<RepositoryData> repositoryDataListener = new StepListener<>();
        final String repositoryName = request.repository();
import java.util.Set;  
import org.opensearch.core.common.io.stream.StreamInput;
     * @param currentSnapshotNames    list of names of currently running snapshots
        this.transportNodesSnapshotsStatus = transportNodesSnapshotsStatus;  
                // neither in the current snapshot entries nor found in the repository
 *     http://www.apache.org/licenses/LICENSE-2.0
                    }  
            // We don't have any in-progress shards, just return current stats
        );
import org.opensearch.transport.TransportService;
        // for no index filter-case and excludes shards from shallow v2 snapshots  
                currentSnapshotNames
import org.opensearch.index.IndexNotFoundException;
                            shardId,
        TransportNodesSnapshotsStatus transportNodesSnapshotsStatus,
import org.opensearch.repositories.Repository;  
                            break;  
    /*
 * ownership. Elasticsearch licenses this file to you under  
                    switch (snapshotInfo.state()) {  
                        new SnapshotStatus(  
            .stream()
                        Collections.unmodifiableList(shardStatusBuilder),
                request,  
        final Map<SnapshotId, SnapshotInfo> snapshotsInfoMap = new HashMap<>();  
    public TransportSnapshotsStatusAction(
        String message = "["
                    for (Map.Entry<ShardId, IndexShardSnapshotStatus> shardStatus : shardStatuses.entrySet()) {
import org.apache.logging.log4j.LogManager;
            + repositoryName
                final Set<String> indicesInCurrentSnapshot = currentSnapshotEntry.indices()
                }
 * this file be licensed under the Apache-2.0 license or a
                            (endTime == 0 ? threadPool.absoluteTimeInMillis() : endTime) - startTime
                repositoryName,
                            if (shardStatues != null) {
    @Override  
                }  
                        nodesIdsOfCurrentSnapshotShards.add(shardStatus.nodeId());
        if (Strings.hasText(repositoryName) && CollectionUtils.isEmpty(request.snapshots()) == false) {
import org.apache.logging.log4j.Logger;
    private Set<String> getNodeIdsOfCurrentSnapshots(final SnapshotsStatusRequest request, List<SnapshotsInProgress.Entry> currentSnapshots)
        List<SnapshotsInProgress.Entry> currentSnapshotEntries,
        Set<String> indicesNotFound,
            .filter(s -> requestedSnapshotNames.contains(s.getName()))  
            Map<String, TransportNodesSnapshotsStatus.NodeSnapshotStatus> nodeSnapshotStatusMap;
                SnapshotInfo snapshotInfo = entry.getValue();
import org.opensearch.common.inject.Inject;
                .filter(index -> snapshotIndices.contains(index) == false)
    }  
                            break;
            SnapshotsStatusRequest::new,
                    boolean isShallowV2Snapshot = snapshotInfo.getPinnedTimestamp() > 0;
                + request.repository()
package org.opensearch.action.admin.cluster.snapshots.status;
            clusterService,
                int numberOfShards = indexMetadata.getNumberOfShards();
import java.util.function.Function;
        final String repositoryName,
                        TransportNodesSnapshotsStatus.NodeSnapshotStatus nodeStatus = nodeSnapshotStatusMap.get(status.nodeId());
                        final IndexShardSnapshotStatus shardSnapshotStatus;
                        final ShardId shardId = shardEntry.getKey();
                    }
                    .collect(Collectors.toSet());
                        );  
        requestUsesIndexFilter = requestedIndexNames.isEmpty() == false;  
                if (snapshotInfo.state().completed()) {
            }
    private final TransportNodesSnapshotsStatus transportNodesSnapshotsStatus;  
                    ShardId shardId = new ShardId(indexMetadata.getIndex(), i);  
 * not use this file except in compliance with the License.
        TransportNodesSnapshotsStatus.NodesSnapshotStatus nodeSnapshotStatuses,  
            if (isV2Snapshot == false && requestUsesIndexFilter == false) {
import java.util.HashSet;  
import org.opensearch.snapshots.SnapshotShardFailure;  
            // There are still some snapshots running - check their progress
        throws CircuitBreakingException {
     * @param repositoryName  repository name
            }  
    }
                    );
        List<SnapshotStatus> builder,  
            IndexId indexId = repositoryData.resolveIndexId(index);
                if (request.ignoreUnavailable()) {
    }
        // Now add snapshots on disk that are not currently running  
                                    shardStatusBuilder.add(shardStatus);  
    private void loadRepositoryData(  
    private boolean requestUsesIndexFilter;
                // all shards of this current snapshot are required in response  
                // skip current shallow v2 snapshots  
    }
        final ClusterState state,  
                        if (snapshotInfo.state() == SnapshotState.FAILED) {  
                if (shardStatus.nodeId() != null) {
 */
                        } else {  
                )
        if (totalShardsRequiredInResponse > maximumAllowedShardCount && requestUsesIndexFilter == false) {
                .collect(Collectors.toSet());
import java.util.stream.Collectors;
                boolean indexPresentInFilter = requestedIndexNames.contains(shardStatusEntry.getKey().getIndexName());
                            indexIdLookup = entry.indices().stream().collect(Collectors.toMap(IndexId::getName, Function.identity()));  
            }
        // First process snapshot that are currently processed  
                        shardStatus = new SnapshotIndexShardStatus(shardEntry.getKey(), stage);
                    .filter(index -> indicesInCurrentSnapshot.contains(index) == false)
        }  
                + indices  
                                    if (shardStatus.getStage() == SnapshotIndexShardStage.DONE  
    * If this count exceeds the limit, CircuitBreakingException is thrown  
                // the actual no. of shards contributed by this current snapshot will now be calculated
import org.opensearch.cluster.service.ClusterService;
            boolean isV2Snapshot = snapshotInfo.getPinnedTimestamp() > 0;  
     * @return map of shard id to snapshot status  
                        // shard from the repository already.
                    if (stage == SnapshotIndexShardStage.DONE) {
                                            shardStatus.getStats(),
                            // include node only if the index containing this shard belongs to the index filter
                    totalShardsAcrossIndices += indexMetadata.getNumberOfShards();  
        }
     * @return snapshot
import org.opensearch.action.StepListener;
            if (requestUsesIndexFilter) {  
        if (!currentSnapshotEntries.isEmpty()) {  
        final Repository repository = repositoriesService.repository(repositoryName);
    private int totalShardsRequiredInResponse;  
 * GitHub history for details.
            for (Map.Entry<SnapshotId, SnapshotInfo> entry : snapshotsInfoMap.entrySet()) {  
            transportNodesSnapshotsStatus.execute(
            request.repository(),
    private final RepositoriesService repositoriesService;
        maximumAllowedShardCount = clusterService.getClusterSettings().get(MAX_SHARDS_ALLOWED_IN_STATUS_API);
            // ignoring unavailable indices  
        } else {
                        )
            String cause = "indices ["
            indicesToProcess.removeAll(indicesNotFound);  
        totalShardsRequiredInResponse = 0;
    /**
                    }  
                if (requestUsesIndexFilter && isV2Snapshot == false) {
                    // state and the repository contents in the below logic  
        for (SnapshotsInProgress.Entry currentSnapshotEntry : currentSnapshots) {
                        currentSnapshotEntry.snapshot().getSnapshotId().getName(),  
            if (currentSnapshotNames.contains(snapshotName)) {
                    new SnapshotStatus(
        List<SnapshotStatus> builder = new ArrayList<>();
            // if index-filter is not being used and limit got exceed, there could be more shards required in response coming from completed
import org.opensearch.repositories.IndexId;
            for (final Map.Entry<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shardStatusEntry : currentSnapshotEntry.shards()
                // index-filter is allowed only for a single snapshot, which has to be this one
            + shardCount
    private Map<ShardId, IndexShardSnapshotStatus> snapshotShards(
        }
import org.opensearch.core.index.shard.ShardId;
                            break;  
                        repositoryName
 *  
 * this work for additional information regarding copyright
            }
            }  
                        repositoryData,
            + "an index list for a singular snapshot.";
                            break;  
                    handleIndexNotFound(
                        default:
                                    shardId  
            throw new IndexNotFoundException(indices, new IllegalArgumentException(cause));  
import org.opensearch.snapshots.SnapshotId;  
import static java.util.Collections.unmodifiableMap;
        int totalShardsAcrossIndices = 0;
                handleIndexNotFound(indicesToProcess, Collections.singleton(index), request, snapshotName, true);
        Set<String> indicesToProcess;  
        if (totalShardsRequiredInResponse > maximumAllowedShardCount && requestUsesIndexFilter && isV2Snapshot == false) {  
            }
                + "] missing in snapshot ["
                                    indexIdLookup.get(shardId.getIndexName()),
                    // ignoring unavailable snapshots, so skip over  
        return ThreadPool.Names.GENERIC;
                        case SUCCESS:
     * @param repositoryName  repository name
/*
import org.opensearch.snapshots.SnapshotsService;  
                        snapshotInfo  
        if (request.ignoreUnavailable()) {
                                        );
     */  
     * Returns status of shards currently finished snapshots  
                                listener,
                    if (status.nodeId() != null) {  
                SnapshotsInProgress.ShardSnapshotStatus shardStatus = shardStatusEntry.getValue();  
                handleIndexNotFound(requestedIndexNames, indicesNotFound, request, snapshotName, moreMissingIndicesPossible);
    }
                indices,  
                        case FAILED:  
                }
import org.opensearch.snapshots.SnapshotMissingException;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
            }
        setupForRequest(request);  
                                }
     * @param snapshotsInProgress    currently running snapshots  
     * <p>
                currentSnapshotNames.add(entry.snapshot().getSnapshotId().getName());  
            handleMaximumAllowedShardCountExceeded(repositoryName, totalShardsRequiredInResponse, false);  
import org.opensearch.snapshots.Snapshot;
                            break;  
                                .asCopy()
                    totalShardsAcrossCurrentSnapshots++;
            }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        );
                    throw new SnapshotMissingException(repositoryName, snapshotName);
import org.opensearch.threadpool.ThreadPool;
                    if (isShallowV2Snapshot && requestUsesIndexFilter == false) {  
        String repositoryName,  
                                        // then this shards state would jump to a failed state.  
                    final long startTime = snapshotInfo.startTime();
                                .getShardSnapshotStatus(  
                    }  
        } else {
     *  
            );
                    SnapshotShardFailure shardFailure = findShardFailure(snapshotInfo.shardFailures(), shardId);
        }  
                            // snapshot status will throw an exception. Instead, we create
     * @return map of snapshot id to snapshot info
import org.opensearch.repositories.RepositoriesService;
            SnapshotsStatusAction.NAME,  
        Set<String> currentSnapshotNames = new HashSet<>();
                        ),
        }  
                        continue;  
 * SPDX-License-Identifier: Apache-2.0
 *
                        entry.state(),  
                    );  
                }
                    final SnapshotIndexShardStatus shardStatus;
                        // TODO: add primary store size in bytes at the snapshot level
            }  
                        case PARTIAL:
     * @param repositoryName      repository name
        final SnapshotInfo snapshotInfo  
     * @param snapshotsInProgress snapshots in progress in the cluster state
 * KIND, either express or implied.  See the License for the
        requestedIndexNames = new HashSet<>(Arrays.asList(request.indices()));
                    }
    /**
 * Modifications Copyright OpenSearch Contributors. See
                            // a status for the shard to indicate that the shard snapshot  
                                            shardStatus.getNodeId(),
        SnapshotsInProgress snapshotsInProgress,
                if (indicesNotFound.isEmpty() == false) {
                                SnapshotIndexShardStatus shardStatus = shardStatues.get(shardEntry.getKey());  
/*  
                            stage = SnapshotIndexShardStage.DONE;
            // all indices of this snapshot  
        }, listener::onFailure);
                            if (isV2Snapshot) {
        final Map<ShardId, IndexShardSnapshotStatus> shardStatus = new HashMap<>();
        String snapshotName,
                }  
                    }
import org.opensearch.cluster.block.ClusterBlockLevel;
                        // We should have information about this shard from the shard:
        boolean moreMissingIndicesPossible
                    );
     */
                            state = SnapshotsInProgress.State.SUCCESS;
            }
        int totalShardsAcrossCurrentSnapshots = 0;
import org.opensearch.core.common.breaker.CircuitBreakingException;
        String repositoryName,
            if (snapshotId == null) {  
        }
                            snapshotInfo.includeGlobalState(),
            snapshotsInProgress,
        TransportService transportService,  
     * @param snapshotInfo    snapshot info
                + snapshotName
            }
 * The OpenSearch Contributors require contributions made to  
 */  
                                        // technically if the data node failed before successfully reporting DONE state to cluster-manager,
            } else if (requestUsesIndexFilter) {  
     * @param snapshotId          snapshot id  
 * compatible open source license.
            );
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
                nodeSnapshotStatusMap = new HashMap<>();
                            throw new IllegalArgumentException("Unknown snapshot state " + snapshotInfo.state());
                        : "Inconsistent timestamps found in SnapshotInfo [" + snapshotInfo + "]";
        } else {
                    if (requestUsesIndexFilter && requestedIndexNames.contains(shardEntry.getKey().getIndexName()) == false) {
                List<SnapshotIndexShardStatus> shardStatusBuilder = new ArrayList<>();
    private Map<SnapshotId, SnapshotInfo> snapshotsInfo(
                            Map<ShardId, SnapshotIndexShardStatus> shardStatues = nodeStatus.status().get(entry.snapshot());
            // remove unavailable indices from the set to be processed
            SnapshotInfo snapshotInfo = snapshot(snapshotsInProgress, repositoryName, snapshotId);
                                    }
                        shardStatus.put(shardId, IndexShardSnapshotStatus.newFailed(shardFailure.reason()));  
import java.util.Collections;
    private void handleMaximumAllowedShardCountExceeded(String repositoryName, int totalContributingShards, boolean couldInvolveMoreShards)
                        request,
                SnapshotId snapshotId = entry.getKey();
                for (int i = 0; i < numberOfShards; i++) {
    protected SnapshotsStatusResponse read(StreamInput in) throws IOException {
                        case ABORTED:
        int totalShardsAcrossSnapshots = 0;
 * license agreements. See the NOTICE file distributed with
                    .map(IndexId::getName)  
                                    entry.snapshot().getSnapshotId(),
                        entry.snapshot(),
        }
        List<SnapshotsInProgress.Entry> entries = SnapshotsService.currentSnapshots(
        String snapshotName = snapshotInfo.snapshotId().getName();
            indexNameExpressionResolver  
                + "]";
                        case INIT:
                    );
     * </p>
            }  
import org.opensearch.common.util.set.Sets;  
                nodeSnapshotStatusMap = nodeSnapshotStatuses.getNodesMap();  
                } else {
import org.opensearch.cluster.ClusterState;
            IndexMetadata indexMetadata = repository.getSnapshotIndexMetaData(repositoryData, snapshotInfo.snapshotId(), indexId);  
                );  
                        case WAITING:  
                if (requestUsesIndexFilter && indexPresentInFilter) {  
     */  
                    final SnapshotsInProgress.State state;
        List<SnapshotsInProgress.Entry> currentSnapshots = SnapshotsService.currentSnapshots(  
    }
        }  
        ActionListener<SnapshotsStatusResponse> listener
            indices = indices.concat(" and possibly more indices");  
import org.opensearch.action.ActionRunnable;  
                    // This can happen if nodes drop out of the cluster completely or restart during the snapshot.
    }
            + " is more than the maximum allowed value of shard count ["
            listener.onResponse(new SnapshotsStatusResponse(Collections.unmodifiableList(builder)));
            // snapshots
        }  
            Set<String> snapshotIndices = Sets.newHashSet(snapshotInfo.indices());
                        requestedIndexNames,  
                                shardSnapshotStatus = IndexShardSnapshotStatus.newDone(0, 0, 0, 0, 0, 0, null);
            handleMaximumAllowedShardCountExceeded(request.repository(), totalShardsRequiredInResponse, false);
        final Map<String, SnapshotId> matchedSnapshotIds = repositoryData.getSnapshotIds()
 */
        Set<String> indicesToProcess,
        final SnapshotsStatusRequest request,  
        if (!nodesIds.isEmpty()) {
    * the current snapshots to the total count (irrespective of index-filter)
        repositoriesService.getRepositoryData(repositoryName, repositoryDataListener);  
                            break;  
    }
                continue;  
                            state = SnapshotsInProgress.State.PARTIAL;
 * Transport action for accessing snapshot status
                    .collect(Collectors.toSet());
                }
 * @opensearch.internal
                                        && shardEntry.getValue().state() != SnapshotsInProgress.ShardState.SUCCESS) {
     * @param request         snapshot status request  
                                    continue;
    ) {
                        indicesNotFound,
                indexMetadataMap.put(indexId, indexMetadata);
        for (String index : indicesToProcess) {
            actionFilters,
                            stage = SnapshotIndexShardStage.STARTED;
                        }
                        // Shard snapshot completed successfully so we should be able to load the exact statistics for this  
        String shardCount = "[" + totalContributingShards + (couldInvolveMoreShards ? "+" : "") + "]";  
            SnapshotId snapshotId = matchedSnapshotIds.get(snapshotName);
        SnapshotsStatusRequest request,
            Collections.singletonList(snapshotId.getName())
    private void setupForRequest(SnapshotsStatusRequest request) {
        if (totalShardsRequiredInResponse > maximumAllowedShardCount) {  
    @Override  
                                            SnapshotIndexShardStage.FINALIZE,  
        final ActionListener<SnapshotsStatusResponse> listener
            indicesToProcess = Sets.newHashSet(snapshotInfo.indices());
                    nodeSnapshotStatuses -> threadPool.generic()
            // index-filter is allowed only for a single snapshot, which has to be this one
            return;
                    }  
                    // for non-index filter case, we already counted all the shards of this current snapshot (non-shallow v2)
    ) {
            snapshotsInfoMap.put(snapshotId, snapshotInfo);
                    builder.add(
    ) {
        // for index filter-case and excludes shards from shallow v2 snapshots
    * */
                ActionListener.wrap(
            for (int i = 0; i < currentSnapshots.size(); i++) {
        Set<String> nodesIdsOfCurrentSnapshotShards = new HashSet<>();
                            } else {  
import java.util.List;
                                        // to reflect this. We adjust the status to show up as snapshot metadata being written because
 * under the License.  
            threadPool,  
    private void handleIndexNotFound(  
            if (indicesNotFound.isEmpty() == false) {  
                    listener::onFailure  
        if (currentSnapshots.isEmpty()) {  
                                    // We have full information about this shard
import java.util.HashMap;
                        }
                final Set<String> indicesNotFound = requestedIndexNames.stream()  
        ClusterService clusterService,
                }
                            state,
        return new SnapshotsStatusResponse(in);  
        totalShardsRequiredInResponse += totalShardsAcrossSnapshots;  
                .entrySet()) {
                new TransportNodesSnapshotsStatus.Request(nodesIds.toArray(Strings.EMPTY_ARRAY)).snapshots(snapshots)
        if (requestUsesIndexFilter) {
        totalShardsRequiredInResponse += totalShardsAcrossIndices;
     * This method is executed on cluster-manager node and it's complimentary to the
        }  
                        snapshotName,  
        ActionFilters actionFilters,
            Map<SnapshotId, SnapshotInfo> snapshotsInfoMap = snapshotsInfo(
                }  
                            nodesIdsOfCurrentSnapshotShards.add(shardStatus.nodeId());
                Map<String, IndexId> indexIdLookup = null;
            snapshotsInProgress,  
            }
     * @throws SnapshotMissingException if snapshot is not found
        }  
            // but since the limit is already exceeded, we can fail request here  
                boolean moreMissingIndicesPossible = indicesNotFound.size() == requestedIndexNames.size();
                        entry.includeGlobalState(),
            .collect(Collectors.toMap(SnapshotId::getName, Function.identity()));
                + "] of repository ["  
        }  
                    shardStatusBuilder.add(shardStatus);
                            Collections.unmodifiableList(shardStatusBuilder),  
            }
                        .execute(  
                            // *not* have any metadata, so attempting to read the shard
        Set<String> currentSnapshotNames  
                    continue;  
    ) throws IndexNotFoundException {  
                snapshotName,
                for (final Map.Entry<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shardEntry : entry.shards().entrySet()) {  
                        default:
            loadRepositoryData(snapshotsInProgress, request, builder, currentSnapshotNames, repositoryName, listener);  
            return new SnapshotInfo(entries.iterator().next());
                    .stream()
                    if (shardFailure != null) {
        return nodesIdsOfCurrentSnapshotShards;
                        shardStatus.put(shardId, shardSnapshotStatus);
                                l -> buildResponse(snapshotsInProgress, request, currentSnapshots, nodeSnapshotStatuses, l)  
                            new Snapshot(repositoryName, snapshotId),
    }
                            // Use current time to calculate overall runtime for in-progress snapshots that have endTime == 0  
                            // not have an exception, it means that partial snapshots
                            }  
    protected ClusterBlockException checkBlock(SnapshotsStatusRequest request, ClusterState state) {  
                    } else {
        SnapshotsInProgress snapshotsInProgress,  
                                            shardStatus.getFailure()  
                    } else {
                        request,  
                        if (indexIdLookup == null) {
 * You may obtain a copy of the License at  
import org.opensearch.repositories.RepositoryData;
            if (indexMetadata != null) {
 */  
            + "] for snapshot status request. Try narrowing down the request by using a snapshot list or "
        for (SnapshotShardFailure shardFailure : shardFailures) {
                        case SUCCESS:
}  
                snapshots[i] = currentSnapshots.get(i).snapshot();
            );  
                            // could not be taken due to partial being set to false.
    }  
            if (indexMetadata != null) {  
            transportService,
                    } else {
        RepositoriesService repositoriesService,  
        SnapshotsStatusRequest request,
                        case MISSING:
                builder.add(  
import org.opensearch.cluster.block.ClusterBlockException;  
            if (currentSnapshotEntry.remoteStoreIndexShallowCopyV2()) {
        Set<String> currentSnapshotNames,
        );  
 * the Apache License, Version 2.0 (the "License"); you may
public class TransportSnapshotsStatusAction extends TransportClusterManagerNodeAction<SnapshotsStatusRequest, SnapshotsStatusResponse> {  
import org.opensearch.action.support.ActionFilters;
    ) {
                            // If the snapshot failed, but the shard's snapshot does
        throws CircuitBreakingException {  
        SnapshotsStatusRequest request,  
            + "] Total shard count "  
            Arrays.asList(request.snapshots())  
 * Licensed to Elasticsearch under one or more contributor  
            IndexMetadata indexMetadata = entry.getValue();
        totalShardsRequiredInResponse += totalShardsAcrossCurrentSnapshots;
 *
        ActionListener<SnapshotsStatusResponse> listener  
import java.util.ArrayList;
            // index-filter is allowed only for a single snapshot. If index-filter is being used and limit got exceeded,
    protected String executor() {
import org.opensearch.core.common.Strings;
     * {@link SnapshotShardsService#currentSnapshotShards(Snapshot)} because it  
import org.opensearch.core.common.breaker.CircuitBreaker;  
        String indices = String.join(", ", indicesNotFound);
                                        shardStatus = new SnapshotIndexShardStatus(
            // includes shard contributions from all snapshots (current and completed)
                    Map<ShardId, IndexShardSnapshotStatus> shardStatuses = snapshotShards(
 * specific language governing permissions and limitations
     * Returns snapshot info for finished snapshots
                    }
    }
import org.opensearch.core.common.util.CollectionUtils;  
            buildResponse(snapshotsInProgress, request, currentSnapshots, null, listener);
    private static SnapshotShardFailure findShardFailure(List<SnapshotShardFailure> shardFailures, ShardId shardId) {
                            shardSnapshotStatus = IndexShardSnapshotStatus.newFailed("skipped");
    private static final Logger logger = LogManager.getLogger(TransportSnapshotsStatusAction.class);
        }  
                        repositoryName,
                        }  
        for (final String snapshotName : request.snapshots()) {  
            buildResponse(snapshotsInProgress, request, currentSnapshots, null, listener);
        for (Map.Entry<IndexId, IndexMetadata> entry : indexMetadataMap.entrySet()) {  
                    SnapshotsInProgress.ShardSnapshotStatus status = shardEntry.getValue();
                                )
                    switch (shardEntry.getValue().state()) {
            IndexId indexId = entry.getKey();
                        shardStatusBuilder.add(new SnapshotIndexShardStatus(shardStatus.getKey(), lastSnapshotStatus));  
        final Set<String> requestedSnapshotNames = Sets.newHashSet(request.snapshots());
            // this snapshot is current and its relevant indices contribute more shards than the limit
    }
            + maximumAllowedShardCount  
                totalShardsAcrossCurrentSnapshots += currentSnapshotEntry.shards().size();
            Set<String> indicesNotFound = requestedIndexNames.stream()  
                    )
                                shardSnapshotStatus = repository.getShardSnapshotStatus(snapshotInfo.snapshotId(), indexId, shardId);
 * Unless required by applicable law or agreed to in writing,
                            }
            Snapshot[] snapshots = new Snapshot[currentSnapshots.size()];  
            boolean couldInvolveMoreShards = requestUsesIndexFilter == false;
        IndexNameExpressionResolver indexNameExpressionResolver  
            } else {
    private long maximumAllowedShardCount;
                            throw new IllegalArgumentException("Unknown snapshot state " + shardEntry.getValue().state());
    ) throws Exception {
                        }  
                        "snapshot status request ignoring snapshot [{}], not found in repository [{}]",
                                        // Unlikely edge case:
        if (!entries.isEmpty()) {
import org.opensearch.core.action.ActionListener;
import java.util.Map;
                    assert endTime >= startTime || (endTime == 0L && snapshotInfo.state().completed() == false)  
    }  
        return null;
                List<SnapshotIndexShardStatus> shardStatusBuilder = new ArrayList<>();  
        final Map<IndexId, IndexMetadata> indexMetadataMap = new HashMap<>();  
        } else {  
import java.util.Arrays;  
        final RepositoryData repositoryData,
                                        // Data node has finished snapshotting the shard but the cluster state has not yet been updated  
     * returns similar information but for already finished snapshots.
import java.io.IOException;
        ThreadPool threadPool,
            logger.debug(
        final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
/*  
                        IndexShardSnapshotStatus.Copy lastSnapshotStatus = shardStatus.getValue().asCopy();
    private Set<String> requestedIndexNames;
                            // were disabled and in this case, the shard snapshot will  
        super(
            if (shardId.getIndexName().equals(shardFailure.index()) && shardId.getId() == shardFailure.shardId()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    // We failed to find the status of the shard from the responses we received from data nodes.  
    /**
                return shardFailure;
    }  
                            repositoriesService.repository(entry.repository())
        final SnapshotsStatusRequest request,
        throw new CircuitBreakingException(message, CircuitBreaker.Durability.PERMANENT);
                    }
    protected void clusterManagerOperation(
    private SnapshotInfo snapshot(SnapshotsInProgress snapshotsInProgress, String repositoryName, SnapshotId snapshotId) {
                        case QUEUED:
     * Retrieves snapshot from repository
                    if (requestUsesIndexFilter) {
                            startTime,
                    // We rebuild the information they would have provided from their in memory state from the cluster
        return unmodifiableMap(shardStatus);  
                repositoryData,
import org.opensearch.cluster.metadata.IndexMetadata;
            handleMaximumAllowedShardCountExceeded(request.repository(), totalShardsRequiredInResponse, couldInvolveMoreShards);
        }
                request.repository()
                    .timeout(request.clusterManagerNodeTimeout()),  
                        if (nodeStatus != null) {  
                        // skip shard if its index does not belong to the index-filter
        Set<String> nodesIds = getNodeIdsOfCurrentSnapshots(request, currentSnapshots);
    private void buildResponse(
            indicesToProcess = requestedIndexNames;
import org.opensearch.snapshots.SnapshotInfo;
                continue;
import static org.opensearch.snapshots.SnapshotsService.MAX_SHARDS_ALLOWED_IN_STATUS_API;
                    final SnapshotIndexShardStage stage;
        boolean isV2Snapshot = snapshotInfo.getPinnedTimestamp() > 0;
                "snapshot status request ignoring indices [{}], not found in snapshot[{}] in repository [{}]",
        repositoryDataListener.whenComplete(repositoryData -> {
    }
        }
    ) throws IOException {
    * To get the node IDs of the relevant (according to the index filter) shards which are part of current snapshots  
import org.opensearch.snapshots.SnapshotState;
                        if (indexPresentInFilter) {  
            if (nodeSnapshotStatuses != null) {
                            stage = SnapshotIndexShardStage.FAILURE;  
        }
                    // count only those shards whose index belongs to the index-filter
            for (SnapshotsInProgress.Entry entry : currentSnapshotEntries) {
    @Inject
            repositoryName,
                        Math.max(threadPool.absoluteTimeInMillis() - entry.startTime(), 0L)
                    final long endTime = snapshotInfo.endTime();
        SnapshotsInProgress snapshotsInProgress,
                            state = SnapshotsInProgress.State.FAILED;
                    logger.debug(
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;  
/**
                                            shardEntry.getKey(),
                            )
                totalShardsAcrossSnapshots += snapshotInfo.totalShards();
        if (moreMissingIndicesPossible) {
        RepositoryData repositoryData,
        return unmodifiableMap(snapshotsInfoMap);
            listener.onResponse(new SnapshotsStatusResponse(Collections.unmodifiableList(builder)));  
            } else {
     * @param repositoryData    repository data
    * It also deals with any missing indices (for index-filter case) and calculates the number of shards contributed by all
import org.opensearch.snapshots.SnapshotShardsService;
    @Override
                                if (shardStatus != null) {
                snapshotsInProgress,  
import org.opensearch.cluster.SnapshotsInProgress;
        this.repositoriesService = repositoriesService;
                        shardStatus = new SnapshotIndexShardStatus(  
 * software distributed under the License is distributed on an
