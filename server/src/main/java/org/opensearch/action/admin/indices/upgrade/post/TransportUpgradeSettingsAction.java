        );
            public void onFailure(Exception t) {  
            }  
 * this work for additional information regarding copyright
 */  
        final ClusterState state,
    }
        ).versions(request.versions()).clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());  
 *  
public class TransportUpgradeSettingsAction extends TransportClusterManagerNodeAction<UpgradeSettingsRequest, AcknowledgedResponse> {  
            @Override
        super(  
 *
package org.opensearch.action.admin.indices.upgrade.post;
 *  
                        request.versions().keySet()
    public TransportUpgradeSettingsAction(
        // we go async right away....
    @Inject  
 * specific language governing permissions and limitations
            UpgradeSettingsAction.NAME,
        MetadataUpdateSettingsService updateSettingsService,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
/**
            @Override  
    private static final Logger logger = LogManager.getLogger(TransportUpgradeSettingsAction.class);
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
        UpgradeSettingsClusterStateUpdateRequest clusterStateUpdateRequest = new UpgradeSettingsClusterStateUpdateRequest().ackTimeout(
 * this file be licensed under the Apache-2.0 license or a
    @Override
        this.updateSettingsService = updateSettingsService;  
        TransportService transportService,
            threadPool,
/*  
    }
 * under the License.  
                );
            request.timeout()
            clusterService,  
                    t  
            UpgradeSettingsRequest::new,  
 * Transport action for upgrading index settings
 */
    @Override
        ActionFilters actionFilters
    protected void clusterManagerOperation(
 *
import org.opensearch.cluster.block.ClusterBlockLevel;
        final UpgradeSettingsRequest request,  
    @Override  
    ) {
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
import org.opensearch.common.inject.Inject;
        IndexNameExpressionResolver indexNameExpressionResolver,  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.ActionFilters;
        return ThreadPool.Names.SAME;  
            }  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import java.io.IOException;
    protected String executor() {
                listener.onFailure(t);
    ) {  
import org.opensearch.core.common.io.stream.StreamInput;
                logger.debug(
import org.apache.logging.log4j.LogManager;
 * Licensed to Elasticsearch under one or more contributor  
            indexNameExpressionResolver
import org.opensearch.cluster.block.ClusterBlockException;  
    protected ClusterBlockException checkBlock(UpgradeSettingsRequest request, ClusterState state) {
 * @opensearch.internal
import org.opensearch.cluster.metadata.MetadataUpdateSettingsService;  
import org.apache.logging.log4j.Logger;
import org.opensearch.threadpool.ThreadPool;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
            transportService,
 */
import org.opensearch.transport.TransportService;  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
        });
import org.opensearch.core.action.ActionListener;  
    private final MetadataUpdateSettingsService updateSettingsService;
/*
import org.opensearch.cluster.ClusterState;
            public void onResponse(ClusterStateUpdateResponse response) {
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
        ThreadPool threadPool,
/*  
 */  
 * license agreements. See the NOTICE file distributed with
    @Override  
                listener.onResponse(new AcknowledgedResponse(response.isAcknowledged()));
    }
 * SPDX-License-Identifier: Apache-2.0
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
 * GitHub history for details.
import org.apache.logging.log4j.message.ParameterizedMessage;  
 * You may obtain a copy of the License at  
                    ),
        return new AcknowledgedResponse(in);
        updateSettingsService.upgradeIndexSettings(clusterStateUpdateRequest, new ActionListener<ClusterStateUpdateResponse>() {
 * The OpenSearch Contributors require contributions made to  
        ClusterService clusterService,  
        final ActionListener<AcknowledgedResponse> listener
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
import org.opensearch.cluster.service.ClusterService;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
                    () -> new ParameterizedMessage(
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
            actionFilters,
                        "failed to upgrade minimum compatibility version settings on indices [{}]",  
}  
 * Unless required by applicable law or agreed to in writing,
