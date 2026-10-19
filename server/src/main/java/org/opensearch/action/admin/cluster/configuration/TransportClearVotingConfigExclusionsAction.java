                                + initialState.getVotingConfigExclusions()  
import org.opensearch.common.inject.Inject;
                        new OpenSearchTimeoutException(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            ClearVotingConfigExclusionsRequest::new,  
package org.opensearch.action.admin.cluster.configuration;
                            "timed out waiting for removal of nodes; if nodes should not be removed, set waitForRemoval to false. "
            clusterStateObserver.waitForNextChange(new Listener() {
    private static final Logger logger = LogManager.getLogger(TransportClearVotingConfigExclusionsAction.class);
        long startTimeMillis,  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
 */
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
 * under the License.  
            submitClearVotingConfigExclusionsTask(request, startTimeMillis, listener);  
            ClearVotingConfigExclusionsAction.NAME,
 * software distributed under the License is distributed on an
import org.opensearch.cluster.block.ClusterBlockLevel;
                    listener.onFailure(  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ClusterStateObserver;
    ) throws Exception {
            actionFilters,
                @Override
    }
                    );
            }
 *
                        )
                public void onNewClusterState(ClusterState state) {  
    ) {
 * Unless required by applicable law or agreed to in writing,
            }, allExclusionsRemoved);
        return new ClearVotingConfigExclusionsResponse(in);  
        ThreadPool threadPool,
import org.opensearch.cluster.block.ClusterBlockException;
import static org.opensearch.action.admin.cluster.configuration.VotingConfigExclusionsHelper.clearExclusionsAndGetState;  
        ClearVotingConfigExclusionsRequest request,
    ClearVotingConfigExclusionsRequest,
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.function.Predicate;
            );
            indexNameExpressionResolver
                @Override
import org.opensearch.OpenSearchTimeoutException;  
                // NB checking for the existence of any node with this persistent ID, because persistent IDs are how votes are counted.
                initialState,  
    protected ClusterBlockException checkBlock(ClearVotingConfigExclusionsRequest request, ClusterState state) {  
                    listener.onFailure(  
        return Names.SAME;
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;  
import org.opensearch.threadpool.ThreadPool;
        IndexNameExpressionResolver indexNameExpressionResolver
        }
            final ClusterStateObserver clusterStateObserver = new ClusterStateObserver(
            }
        final Predicate<ClusterState> allExclusionsRemoved = newState -> {  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;  
import org.opensearch.cluster.ClusterStateUpdateTask;  
/*
import org.opensearch.cluster.ClusterStateObserver.Listener;
            transportService,
        if (request.getWaitForRemoval() && allExclusionsRemoved.test(initialState) == false) {
                logger,  
import org.apache.logging.log4j.LogManager;  
        } else {
import org.opensearch.common.Priority;  
import org.opensearch.OpenSearchException;
    ClearVotingConfigExclusionsResponse> {  
    }  
                        )  
        clusterService.submitStateUpdateTask("clear-voting-config-exclusions", new ClusterStateUpdateTask(Priority.URGENT) {  
                @Override
            public ClusterState execute(ClusterState currentState) {
 * Transport endpoint action for clearing exclusions to voting config  
/*
}  
            @Override
 * SPDX-License-Identifier: Apache-2.0
                listener.onResponse(new ClearVotingConfigExclusionsResponse());  
        ActionListener<ClearVotingConfigExclusionsResponse> listener
                clusterService,
 * this work for additional information regarding copyright
            @Override
    @Override
                threadPool.getThreadContext()
                }  
        ClearVotingConfigExclusionsRequest request,
    @Inject
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
                            "cluster service closed while waiting for removal of nodes " + initialState.getVotingConfigExclusions()
public class TransportClearVotingConfigExclusionsAction extends TransportClusterManagerNodeAction<
        ActionFilters actionFilters,  
 * GitHub history for details.
    @Override  
 * The OpenSearch Contributors require contributions made to  
            }  
                return TimeValue.timeValueMillis(request.getTimeout().millis() + startTimeMillis - threadPool.relativeTimeInMillis());
            public void onFailure(String source, Exception e) {
        TransportService transportService,  
        ClusterService clusterService,
        ClusterState initialState,  
            public TimeValue timeout() {  
        };
 */  
            threadPool,
        ActionListener<ClearVotingConfigExclusionsResponse> listener
            for (VotingConfigExclusion tombstone : initialState.getVotingConfigExclusions()) {
 * specific language governing permissions and limitations
                listener.onFailure(e);
        });
/*  
                public void onClusterServiceClose() {
            @Override  
        final long startTimeMillis = threadPool.relativeTimeInMillis();
    protected String executor() {  
    @Override
 *  
 */  
    public TransportClearVotingConfigExclusionsAction(
            }
        );
                    submitClearVotingConfigExclusionsTask(request, startTimeMillis, listener);
import org.opensearch.core.action.ActionListener;  
                if (newState.nodes().nodeExists(tombstone.getNodeId())) {  
 * compatible open source license.
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.ClusterState;  
    ) {
                public void onTimeout(TimeValue timeout) {
import org.opensearch.common.unit.TimeValue;
                return clearExclusionsAndGetState(currentState);  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
                    return false;
    private void submitClearVotingConfigExclusionsTask(
 *
    }
            }  
 * KIND, either express or implied.  See the License for the
import org.opensearch.threadpool.ThreadPool.Names;  
            @Override
/**
 * @opensearch.internal
 *
    }  
                }
                    );
 * not use this file except in compliance with the License.
                request.getTimeout(),
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.transport.TransportService;
            return true;
    protected ClearVotingConfigExclusionsResponse read(StreamInput in) throws IOException {
        super(  
import org.opensearch.cluster.service.ClusterService;
                }
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See  
                        new OpenSearchException(
    protected void clusterManagerOperation(
            clusterService,  
                }
 */
import org.opensearch.action.support.ActionFilters;
