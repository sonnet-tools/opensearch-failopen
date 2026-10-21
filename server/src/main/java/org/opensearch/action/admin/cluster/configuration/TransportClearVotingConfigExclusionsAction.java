/**
            }, allExclusionsRemoved);
 */
                }
    protected ClearVotingConfigExclusionsResponse read(StreamInput in) throws IOException {
 * @opensearch.internal
import org.opensearch.common.unit.TimeValue;
}
    ) throws Exception {
 * ownership. Elasticsearch licenses this file to you under
    @Inject
            ClearVotingConfigExclusionsRequest::new,
    private static final Logger logger = LogManager.getLogger(TransportClearVotingConfigExclusionsAction.class);
            }
                listener.onFailure(e);
                    );
                logger,
                public void onTimeout(TimeValue timeout) {
            public ClusterState execute(ClusterState currentState) {
            public void onFailure(String source, Exception e) {
    @Override
    protected String executor() {
    public TransportClearVotingConfigExclusionsAction(
        ClusterService clusterService,
package org.opensearch.action.admin.cluster.configuration;
 *
    }
                    return false;
    }
import org.opensearch.common.Priority;
 * not use this file except in compliance with the License.
import java.util.function.Predicate;
 */
            @Override
                listener.onResponse(new ClearVotingConfigExclusionsResponse());
        final Predicate<ClusterState> allExclusionsRemoved = newState -> {
    @Override
import org.opensearch.common.inject.Inject;
 * this file be licensed under the Apache-2.0 license or a
            clusterStateObserver.waitForNextChange(new Listener() {
            threadPool,
        IndexNameExpressionResolver indexNameExpressionResolver
            @Override
                @Override
    protected void clusterManagerOperation(
        ActionListener<ClearVotingConfigExclusionsResponse> listener
/*
    }
            final ClusterStateObserver clusterStateObserver = new ClusterStateObserver(
    ClearVotingConfigExclusionsRequest,
                            "cluster service closed while waiting for removal of nodes " + initialState.getVotingConfigExclusions()
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
                @Override
                            "timed out waiting for removal of nodes; if nodes should not be removed, set waitForRemoval to false. "
        });
 * SPDX-License-Identifier: Apache-2.0
        };
public class TransportClearVotingConfigExclusionsAction extends TransportClusterManagerNodeAction<
        clusterService.submitStateUpdateTask("clear-voting-config-exclusions", new ClusterStateUpdateTask(Priority.URGENT) {
        ClearVotingConfigExclusionsRequest request,
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        ActionFilters actionFilters,
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
    private void submitClearVotingConfigExclusionsTask(
                                + initialState.getVotingConfigExclusions()
 * the Apache License, Version 2.0 (the "License"); you may
                }
                }
 * software distributed under the License is distributed on an
                    listener.onFailure(
                        new OpenSearchTimeoutException(
    ) {
import org.opensearch.core.common.io.stream.StreamInput;
 */
/*
import org.opensearch.threadpool.ThreadPool;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.block.ClusterBlockLevel;
            );
                // NB checking for the existence of any node with this persistent ID, because persistent IDs are how votes are counted.
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            public TimeValue timeout() {
                public void onClusterServiceClose() {
            clusterService,
        ClusterState initialState,
                return clearExclusionsAndGetState(currentState);
            }
            @Override
import org.opensearch.cluster.ClusterState;
 * You may obtain a copy of the License at
 * Unless required by applicable law or agreed to in writing,
                return TimeValue.timeValueMillis(request.getTimeout().millis() + startTimeMillis - threadPool.relativeTimeInMillis());
                        )
                threadPool.getThreadContext()
    protected ClusterBlockException checkBlock(ClearVotingConfigExclusionsRequest request, ClusterState state) {
    @Override
    }
        );
 * Licensed to Elasticsearch under one or more contributor
        ThreadPool threadPool,
            actionFilters,
            return true;
        TransportService transportService,
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.ClusterStateObserver.Listener;
                request.getTimeout(),
import org.opensearch.OpenSearchException;
                    listener.onFailure(
        super(
                        new OpenSearchException(
        ClearVotingConfigExclusionsRequest request,
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.cluster.service.ClusterService;
 * KIND, either express or implied.  See the License for the
 * under the License.
 * GitHub history for details.
 *
                        )
            indexNameExpressionResolver
                }
import org.opensearch.action.support.ActionFilters;
 *
import org.opensearch.transport.TransportService;
        }
        final long startTimeMillis = threadPool.relativeTimeInMillis();
            ClearVotingConfigExclusionsAction.NAME,
                    submitClearVotingConfigExclusionsTask(request, startTimeMillis, listener);
import org.apache.logging.log4j.Logger;
        } else {
    ClearVotingConfigExclusionsResponse> {
 * Transport endpoint action for clearing exclusions to voting config
import org.opensearch.threadpool.ThreadPool.Names;
            @Override
    ) {
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.clearExclusionsAndGetState;
    }
import org.opensearch.cluster.ClusterStateUpdateTask;
import java.io.IOException;
            }
            submitClearVotingConfigExclusionsTask(request, startTimeMillis, listener);
        return Names.SAME;
        if (request.getWaitForRemoval() && allExclusionsRemoved.test(initialState) == false) {
                @Override
    @Override
        return new ClearVotingConfigExclusionsResponse(in);
            for (VotingConfigExclusion tombstone : initialState.getVotingConfigExclusions()) {
                clusterService,
            }
 */
import org.opensearch.cluster.ClusterStateObserver;
 * compatible open source license.
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
import org.opensearch.OpenSearchTimeoutException;
 * license agreements. See the NOTICE file distributed with
            transportService,
        long startTimeMillis,
import org.apache.logging.log4j.LogManager;
 * The OpenSearch Contributors require contributions made to
                if (newState.nodes().nodeExists(tombstone.getNodeId())) {
        ActionListener<ClearVotingConfigExclusionsResponse> listener
                    );
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
 *
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
                public void onNewClusterState(ClusterState state) {
                initialState,
    }
