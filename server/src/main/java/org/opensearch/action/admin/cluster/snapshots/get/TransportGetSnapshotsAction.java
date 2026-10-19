     * @param repositoryName repository name  
/*  
        RepositoriesService repositoriesService,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.SnapshotsInProgress;  
    @Inject  
import org.opensearch.cluster.service.ClusterService;
        List<SnapshotInfo> snapshotList = new ArrayList<>();
import org.opensearch.repositories.Repository;  
                if (isAllSnapshots(request.snapshots())) {
                    throw new SnapshotException(repositoryName, snapshotId, "Snapshot could not be read", ex);
    public TransportGetSnapshotsAction(
                    toResolve.addAll(allSnapshotIds.values());  
import org.opensearch.action.support.ActionFilters;  
                } else {  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import org.opensearch.cluster.block.ClusterBlockLevel;
                SnapshotId snapshotId = snapshotInfo.snapshotId();  
    ) {
        }
            }  
        // first, look at the snapshots in progress
/*
            if (isCurrentSnapshotsOnly(request.snapshots()) == false) {  
 * license agreements. See the NOTICE file distributed with
            final List<String> indices = snapshotsToIndices.getOrDefault(snapshotId, Collections.emptyList());  
                final List<SnapshotInfo> snapshotInfos;  
            }  
     * @param ignoreUnavailable   if true, snapshots that could not be read will only be logged with a warning,
import java.util.HashMap;
        this.repositoriesService = repositoriesService;  
import java.io.IOException;
        final RepositoryData repositoryData,  
                    if (ex instanceof SnapshotException) {
    ) {
import java.util.Map;
        for (SnapshotInfo snapshotInfo : currentSnapshots) {
        // filter and incorporate the snapshots in progress
            try {
                }  
 *
                    }
        final Set<SnapshotInfo> snapshotSet = new HashSet<>();  
import org.opensearch.snapshots.SnapshotException;
                        // only want current snapshots
                    snapshotInfos = snapshots(snapshotsInProgress, repository, new ArrayList<>(toResolve), request.ignoreUnavailable());
                        } else if (Regex.isSimpleMatchPattern(snapshotOrPattern) == false) {
import java.util.List;  
                    }  
                    for (SnapshotId snapshotId : repositoryData.getSnapshotIds()) {
            repositoryName,
                final Set<SnapshotId> toResolve = new HashSet<>();
        return unmodifiableList(snapshotList);
                        } else {
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
                listener.onResponse(new GetSnapshotsResponse(snapshotInfos));
     * @param snapshotsInProgress snapshots in progress in the cluster state
        return unmodifiableList(snapshotInfos);
        final ClusterState state,  
        return new GetSnapshotsResponse(in);
    }  
        boolean ignoreUnavailable
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            Collections.emptyList()
    }
        for (SnapshotsInProgress.Entry entry : entries) {  
    }  
    }  
    private List<SnapshotInfo> buildSimpleSnapshotInfos(
        for (SnapshotsInProgress.Entry entry : entries) {
                currentSnapshots.add(snapshotInfo);
     * @return list of snapshots
    private final RepositoriesService repositoriesService;
    ) {
        ThreadPool threadPool,
        try {  
 * this file be licensed under the Apache-2.0 license or a
    @Override
                        // want non-current snapshots as well, which are found in the repository data
    private static List<SnapshotInfo> sortedCurrentSnapshots(@Nullable SnapshotsInProgress snapshotsInProgress, String repositoryName) {  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
import org.opensearch.snapshots.SnapshotId;  
 * software distributed under the License is distributed on an
 * Transport Action for get snapshots operation
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
    protected void clusterManagerOperation(
            if (snapshotIdsToIterate.remove(entry.snapshot().getSnapshotId())) {
 * the Apache License, Version 2.0 (the "License"); you may
     * @param repositoryName      repository name  
    /**
        return (snapshots.length == 0) || (snapshots.length == 1 && GetSnapshotsRequest.ALL_SNAPSHOTS.equalsIgnoreCase(snapshots[0]));  
            if (toResolve.remove(snapshotInfo.snapshotId())) {
import org.opensearch.common.regex.Regex;
 */
        List<SnapshotInfo> snapshotInfos = new ArrayList<>();  
            }, listener::onFailure);
        TransportService transportService,
    @Override
            snapshotList.add(new SnapshotInfo(entry));
        final ActionListener<GetSnapshotsResponse> listener
 *  
            final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE);
            snapshotIdsToIterate.stream().map(SnapshotId::getName).collect(Collectors.toList())  
        final GetSnapshotsRequest request,
        return (snapshots.length == 1 && GetSnapshotsRequest.CURRENT_SNAPSHOT.equalsIgnoreCase(snapshots[0]));
        final Set<SnapshotId> toResolve,
import java.util.stream.Collectors;  
import java.util.Set;
    }
                            if (allSnapshotIds.containsKey(snapshotOrPattern)) {  
        return unmodifiableList(snapshotList);
            clusterService,  
    }
    }
                    }  
        } catch (Exception e) {  
                }
        List<SnapshotsInProgress.Entry> entries = SnapshotsService.currentSnapshots(
        for (SnapshotId snapshotId : snapshotIdsToIterate) {
package org.opensearch.action.admin.cluster.snapshots.get;
                } else {
                            toResolve.addAll(currentSnapshots.stream().map(SnapshotInfo::snapshotId).collect(Collectors.toList()));
                            }
        CollectionUtil.timSort(snapshotList);
     *
            } else {
        CollectionUtil.timSort(snapshotInfos);
                if (repositoryData != null) {
import org.opensearch.action.StepListener;
        );  
            snapshotsInProgress,  
                                }  
        for (SnapshotId snapshotId : toResolve) {
import org.opensearch.repositories.RepositoriesService;
 * under the License.  
/**
import org.apache.logging.log4j.message.ParameterizedMessage;  
import java.util.HashSet;
import org.apache.lucene.util.CollectionUtil;
/*  
        String repositoryName,
        }
import org.opensearch.transport.TransportService;
            }
 * ownership. Elasticsearch licenses this file to you under  
        return ThreadPool.Names.GENERIC;
import org.opensearch.common.Nullable;
        }  
     */
                        if (GetSnapshotsRequest.CURRENT_SNAPSHOT.equalsIgnoreCase(snapshotOrPattern)) {  
                if (request.verbose()) {
                        throw new SnapshotMissingException(repository, request.snapshots()[0]);
        super(  
        final List<SnapshotsInProgress.Entry> entries = SnapshotsService.currentSnapshots(  
                    snapshotsToIndices.computeIfAbsent(snapshotId, (k) -> new ArrayList<>()).add(indexId.getName());
                                    toResolve.add(entry.getValue());
}
            }  
            final String repository = request.repository();
                }
    protected String executor() {
        IndexNameExpressionResolver indexNameExpressionResolver
import org.opensearch.cluster.block.ClusterBlockException;
            GetSnapshotsAction.NAME,
                                if (Regex.simpleMatch(snapshotOrPattern, entry.getKey())) {
        CollectionUtil.timSort(snapshotList);
                    for (String snapshotOrPattern : request.snapshots()) {
     *                            if false, they will throw an error  
import org.opensearch.common.inject.Inject;  
            GetSnapshotsRequest::new,  
                        snapshotInfos = buildSimpleSnapshotInfos(toResolve, repositoryData, currentSnapshots);  
                repositoryDataListener.onResponse(null);
 *
        ActionFilters actionFilters,  
                        snapshotInfos = currentSnapshots.stream().map(SnapshotInfo::basic).collect(Collectors.toList());  
            }
import org.opensearch.core.common.io.stream.StreamInput;  
            for (SnapshotInfo snapshotInfo : sortedCurrentSnapshots(snapshotsInProgress, repository)) {
            final List<SnapshotInfo> currentSnapshots = new ArrayList<>();
                        && request.ignoreUnavailable() == false  
import org.opensearch.snapshots.SnapshotsService;  
    /**
                if (toResolve.contains(snapshotId)) {  
    }  
        @Nullable SnapshotsInProgress snapshotsInProgress,
     * @return list of snapshots
                            for (Map.Entry<String, SnapshotId> entry : allSnapshotIds.entrySet()) {  
                        && isCurrentSnapshotsOnly(request.snapshots()) == false) {
import java.util.ArrayList;
     *
 *  
        }
                snapshotInfos.add(snapshotInfo.basic());  
            final StepListener<RepositoryData> repositoryDataListener = new StepListener<>();
            final Map<String, SnapshotId> allSnapshotIds = new HashMap<>();  
                        throw ex;  
public class TransportGetSnapshotsAction extends TransportClusterManagerNodeAction<GetSnapshotsRequest, GetSnapshotsResponse> {  
            listener.onFailure(e);
        final Repository repository = repositoriesService.repository(repositoryName);  
            threadPool,
 */  
        }
            repositoryName,
                                toResolve.add(allSnapshotIds.get(snapshotOrPattern));
 * @opensearch.internal
    @Override  
        for (IndexId indexId : repositoryData.getIndices().values()) {
        final Set<SnapshotId> snapshotIdsToIterate = new HashSet<>(snapshotIds);
    private List<SnapshotInfo> snapshots(  
        ClusterService clusterService,  
                } else {
            for (SnapshotId snapshotId : repositoryData.getSnapshots(indexId)) {
                    }
                        CollectionUtil.timSort(snapshotInfos);
     * @param snapshotsInProgress snapshots in progress in the cluster state
            repositoryDataListener.whenComplete(repositoryData -> {  
        final ArrayList<SnapshotInfo> snapshotList = new ArrayList<>(snapshotSet);  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
                allSnapshotIds.put(snapshotId.getName(), snapshotId);
 * Licensed to Elasticsearch under one or more contributor  
            snapshotsInProgress,
 * Unless required by applicable law or agreed to in writing,
import static java.util.Collections.unmodifiableList;
        );
                snapshotSet.add(new SnapshotInfo(entry));
     * Returns a list of snapshots from repository sorted by snapshot creation date  
                repositoriesService.getRepositoryData(repository, repositoryDataListener);
            }
            actionFilters,
                    } else {
import org.opensearch.repositories.IndexId;
    }
            transportService,
import org.opensearch.repositories.RepositoryData;
import org.opensearch.snapshots.SnapshotMissingException;
                                throw new SnapshotMissingException(repository, snapshotOrPattern);  
 * specific language governing permissions and limitations
import org.opensearch.core.action.ActionListener;
                        }
    protected GetSnapshotsResponse read(StreamInput in) throws IOException {  
    private boolean isCurrentSnapshotsOnly(String[] snapshots) {  
     * @param snapshotIds         snapshots for which to fetch snapshot information
import org.opensearch.cluster.ClusterState;
import java.util.Collections;  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
import org.apache.logging.log4j.LogManager;
                // Setting repositoryDataListener response to be null if the request has only current snapshot  
    private boolean isAllSnapshots(String[] snapshots) {
    ) {
        // then, look in the repository
import org.opensearch.threadpool.ThreadPool;
        Map<SnapshotId, List<String>> snapshotsToIndices = new HashMap<>();  
                }
 */
            snapshotInfos.add(new SnapshotInfo(snapshotId, indices, Collections.emptyList(), repositoryData.getSnapshotState(snapshotId)));
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        );
 * not use this file except in compliance with the License.
        }
                    if (toResolve.isEmpty()
                if (ignoreUnavailable) {
        List<SnapshotId> snapshotIds,  
    protected ClusterBlockException checkBlock(GetSnapshotsRequest request, ClusterState state) {
     * Returns a list of currently running snapshots from repository sorted by snapshot creation date  
import org.apache.logging.log4j.Logger;
                    if (repositoryData != null) {
            indexNameExpressionResolver
            CollectionUtil.timSort(indices);
                    logger.warn(() -> new ParameterizedMessage("failed to get snapshot [{}]", snapshotId), ex);  
    @Override  
                snapshotSet.add(repository.getSnapshotInfo(snapshotId));  
                            } else if (request.ignoreUnavailable() == false) {
            } catch (Exception ex) {
                            }
import org.opensearch.snapshots.SnapshotInfo;
                        allSnapshotIds.put(snapshotId.getName(), snapshotId);  
     */
                    }
 */  
    private static final Logger logger = LogManager.getLogger(TransportGetSnapshotsAction.class);
                }  
        final List<SnapshotInfo> currentSnapshots
 * GitHub history for details.
