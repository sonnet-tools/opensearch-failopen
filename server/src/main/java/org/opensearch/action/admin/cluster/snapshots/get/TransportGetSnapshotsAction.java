import java.util.Set;
    protected GetSnapshotsResponse read(StreamInput in) throws IOException {
                    } else {
import org.apache.logging.log4j.LogManager;
 *
                        snapshotInfos = currentSnapshots.stream().map(SnapshotInfo::basic).collect(Collectors.toList());
import org.opensearch.core.action.ActionListener;
    protected String executor() {
import java.util.HashSet;
        final RepositoryData repositoryData,
                SnapshotId snapshotId = snapshotInfo.snapshotId();
import org.opensearch.snapshots.SnapshotException;
            }
        return unmodifiableList(snapshotInfos);
import java.util.stream.Collectors;
                            }
                        } else if (Regex.isSimpleMatchPattern(snapshotOrPattern) == false) {
                }
                                toResolve.add(allSnapshotIds.get(snapshotOrPattern));
     * Returns a list of currently running snapshots from repository sorted by snapshot creation date
/*
            }
    protected ClusterBlockException checkBlock(GetSnapshotsRequest request, ClusterState state) {
                    throw new SnapshotException(repositoryName, snapshotId, "Snapshot could not be read", ex);
            try {
            repositoryName,
        final Repository repository = repositoriesService.repository(repositoryName);
        // then, look in the repository
                snapshotSet.add(repository.getSnapshotInfo(snapshotId));
        );
                snapshotInfos.add(snapshotInfo.basic());
                    toResolve.addAll(allSnapshotIds.values());
    protected void clusterManagerOperation(
 */
 * ownership. Elasticsearch licenses this file to you under
        );
 * under the License.
            GetSnapshotsRequest::new,
import org.opensearch.common.Nullable;
 * compatible open source license.
import java.util.ArrayList;
    }
    }
        final ActionListener<GetSnapshotsResponse> listener
        for (SnapshotsInProgress.Entry entry : entries) {
                    for (String snapshotOrPattern : request.snapshots()) {
     * @return list of snapshots
        ThreadPool threadPool,
                                if (Regex.simpleMatch(snapshotOrPattern, entry.getKey())) {
 *
        );
    ) {
            clusterService,
        }
/**
            final List<String> indices = snapshotsToIndices.getOrDefault(snapshotId, Collections.emptyList());
                repositoryDataListener.onResponse(null);
 * Licensed to Elasticsearch under one or more contributor
    }
        }
                                }
 * @opensearch.internal
 */
 * specific language governing permissions and limitations
                    if (ex instanceof SnapshotException) {
                        snapshotInfos = buildSimpleSnapshotInfos(toResolve, repositoryData, currentSnapshots);
                        } else {
/*
     * @return list of snapshots
        final Set<SnapshotId> toResolve,
        final Set<SnapshotInfo> snapshotSet = new HashSet<>();
    public TransportGetSnapshotsAction(
import java.util.HashMap;
        // first, look at the snapshots in progress
        ActionFilters actionFilters,
            snapshotsInProgress,
        for (SnapshotId snapshotId : snapshotIdsToIterate) {
    }
        ClusterService clusterService,
    }
        CollectionUtil.timSort(snapshotInfos);
            final StepListener<RepositoryData> repositoryDataListener = new StepListener<>();
    private static final Logger logger = LogManager.getLogger(TransportGetSnapshotsAction.class);
     * Returns a list of snapshots from repository sorted by snapshot creation date
            if (toResolve.remove(snapshotInfo.snapshotId())) {
                final List<SnapshotInfo> snapshotInfos;
                            for (Map.Entry<String, SnapshotId> entry : allSnapshotIds.entrySet()) {
    }
                    }
public class TransportGetSnapshotsAction extends TransportClusterManagerNodeAction<GetSnapshotsRequest, GetSnapshotsResponse> {
 * Unless required by applicable law or agreed to in writing,
        List<SnapshotsInProgress.Entry> entries = SnapshotsService.currentSnapshots(
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
            Collections.emptyList()
    @Override
}
     * @param repositoryName      repository name
import org.opensearch.cluster.block.ClusterBlockException;
    private final RepositoriesService repositoriesService;
                        && isCurrentSnapshotsOnly(request.snapshots()) == false) {
        }
                } else {
        super(
            }
     * @param repositoryName repository name
                            }
import org.opensearch.threadpool.ThreadPool;
            repositoryDataListener.whenComplete(repositoryData -> {
                // Setting repositoryDataListener response to be null if the request has only current snapshot
            if (isCurrentSnapshotsOnly(request.snapshots()) == false) {
 * license agreements. See the NOTICE file distributed with
import static java.util.Collections.unmodifiableList;
        final ClusterState state,
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            final List<SnapshotInfo> currentSnapshots = new ArrayList<>();
                    }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                            toResolve.addAll(currentSnapshots.stream().map(SnapshotInfo::snapshotId).collect(Collectors.toList()));
     */
import java.util.Collections;
            final Map<String, SnapshotId> allSnapshotIds = new HashMap<>();
import org.apache.logging.log4j.message.ParameterizedMessage;
                snapshotSet.add(new SnapshotInfo(entry));
        final ArrayList<SnapshotInfo> snapshotList = new ArrayList<>(snapshotSet);
            }, listener::onFailure);
import org.opensearch.cluster.SnapshotsInProgress;
                    logger.warn(() -> new ParameterizedMessage("failed to get snapshot [{}]", snapshotId), ex);
            snapshotInfos.add(new SnapshotInfo(snapshotId, indices, Collections.emptyList(), repositoryData.getSnapshotState(snapshotId)));
        TransportService transportService,
        @Nullable SnapshotsInProgress snapshotsInProgress,
                        throw ex;
        final List<SnapshotInfo> currentSnapshots
 * KIND, either express or implied.  See the License for the
            for (SnapshotId snapshotId : repositoryData.getSnapshots(indexId)) {
import org.apache.lucene.util.CollectionUtil;
/*
import org.opensearch.cluster.ClusterState;
    }
                currentSnapshots.add(snapshotInfo);
    private List<SnapshotInfo> snapshots(
import org.opensearch.common.regex.Regex;
 * SPDX-License-Identifier: Apache-2.0
                if (ignoreUnavailable) {
                }
package org.opensearch.action.admin.cluster.snapshots.get;
 * The OpenSearch Contributors require contributions made to
            snapshotIdsToIterate.stream().map(SnapshotId::getName).collect(Collectors.toList())
        RepositoriesService repositoriesService,
            listener.onFailure(e);
import java.io.IOException;
        boolean ignoreUnavailable
                if (request.verbose()) {
 * Transport Action for get snapshots operation
import org.opensearch.repositories.IndexId;
import org.opensearch.snapshots.SnapshotMissingException;
     *
                    if (repositoryData != null) {
            for (SnapshotInfo snapshotInfo : sortedCurrentSnapshots(snapshotsInProgress, repository)) {
import org.opensearch.cluster.block.ClusterBlockLevel;
 * GitHub history for details.
    @Override
 * You may obtain a copy of the License at
        for (SnapshotsInProgress.Entry entry : entries) {
        final GetSnapshotsRequest request,
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.snapshots.SnapshotInfo;
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
                }
import java.util.List;
 *
                                    toResolve.add(entry.getValue());
 */
        final List<SnapshotsInProgress.Entry> entries = SnapshotsService.currentSnapshots(
import org.opensearch.snapshots.SnapshotsService;
                } else {
 * software distributed under the License is distributed on an
        final Set<SnapshotId> snapshotIdsToIterate = new HashSet<>(snapshotIds);
 * this work for additional information regarding copyright
 */
        }
import org.opensearch.snapshots.SnapshotId;
     * @param ignoreUnavailable   if true, snapshots that could not be read will only be logged with a warning,
 *
import org.opensearch.repositories.Repository;
                    }
        // filter and incorporate the snapshots in progress
     *                            if false, they will throw an error
            snapshotList.add(new SnapshotInfo(entry));
    @Inject
        List<SnapshotInfo> snapshotList = new ArrayList<>();
                    snapshotsToIndices.computeIfAbsent(snapshotId, (k) -> new ArrayList<>()).add(indexId.getName());
                        // only want current snapshots
                    snapshotInfos = snapshots(snapshotsInProgress, repository, new ArrayList<>(toResolve), request.ignoreUnavailable());
     */
                allSnapshotIds.put(snapshotId.getName(), snapshotId);
            repositoryName,
                        throw new SnapshotMissingException(repository, request.snapshots()[0]);
import org.apache.logging.log4j.Logger;
    @Override
    /**
    private static List<SnapshotInfo> sortedCurrentSnapshots(@Nullable SnapshotsInProgress snapshotsInProgress, String repositoryName) {
            actionFilters,
    private boolean isAllSnapshots(String[] snapshots) {
        } catch (Exception e) {
    ) {
                final Set<SnapshotId> toResolve = new HashSet<>();
                            } else if (request.ignoreUnavailable() == false) {
import org.opensearch.action.support.ActionFilters;
        }
     * @param snapshotIds         snapshots for which to fetch snapshot information
import org.opensearch.common.inject.Inject;
        this.repositoriesService = repositoriesService;
            } else {
                if (isAllSnapshots(request.snapshots())) {
                        && request.ignoreUnavailable() == false
                if (toResolve.contains(snapshotId)) {
                        }
            }
        CollectionUtil.timSort(snapshotList);
    ) {
            }
                }
            CollectionUtil.timSort(indices);
 * the Apache License, Version 2.0 (the "License"); you may
            threadPool,
    }
        return unmodifiableList(snapshotList);
        Map<SnapshotId, List<String>> snapshotsToIndices = new HashMap<>();
 * not use this file except in compliance with the License.
                repositoriesService.getRepositoryData(repository, repositoryDataListener);
                    if (toResolve.isEmpty()
import org.opensearch.repositories.RepositoryData;
    }
                                throw new SnapshotMissingException(repository, snapshotOrPattern);
     * @param snapshotsInProgress snapshots in progress in the cluster state
                if (repositoryData != null) {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.transport.TransportService;
        for (SnapshotId snapshotId : toResolve) {
                        CollectionUtil.timSort(snapshotInfos);
import java.util.Map;
    }
            } catch (Exception ex) {
    private List<SnapshotInfo> buildSimpleSnapshotInfos(
     *
                }
                        allSnapshotIds.put(snapshotId.getName(), snapshotId);
        return unmodifiableList(snapshotList);
 * this file be licensed under the Apache-2.0 license or a
        List<SnapshotInfo> snapshotInfos = new ArrayList<>();
        return new GetSnapshotsResponse(in);
        try {
            final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE);
        for (SnapshotInfo snapshotInfo : currentSnapshots) {
        List<SnapshotId> snapshotIds,
                    }
                        // want non-current snapshots as well, which are found in the repository data
 * Modifications Copyright OpenSearch Contributors. See
     * @param snapshotsInProgress snapshots in progress in the cluster state
        }
        for (IndexId indexId : repositoryData.getIndices().values()) {
            indexNameExpressionResolver
            }
    ) {
            transportService,
        return (snapshots.length == 1 && GetSnapshotsRequest.CURRENT_SNAPSHOT.equalsIgnoreCase(snapshots[0]));
        IndexNameExpressionResolver indexNameExpressionResolver
                        if (GetSnapshotsRequest.CURRENT_SNAPSHOT.equalsIgnoreCase(snapshotOrPattern)) {
            GetSnapshotsAction.NAME,
                    }
            final String repository = request.repository();
        String repositoryName,
                } else {
        return (snapshots.length == 0) || (snapshots.length == 1 && GetSnapshotsRequest.ALL_SNAPSHOTS.equalsIgnoreCase(snapshots[0]));
                            if (allSnapshotIds.containsKey(snapshotOrPattern)) {
import org.opensearch.action.StepListener;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        CollectionUtil.timSort(snapshotList);
            snapshotsInProgress,
        return ThreadPool.Names.GENERIC;
    private boolean isCurrentSnapshotsOnly(String[] snapshots) {
import org.opensearch.cluster.service.ClusterService;
        }
                    for (SnapshotId snapshotId : repositoryData.getSnapshotIds()) {
                listener.onResponse(new GetSnapshotsResponse(snapshotInfos));
    /**
            if (snapshotIdsToIterate.remove(entry.snapshot().getSnapshotId())) {
