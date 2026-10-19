                        )
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.block.ClusterBlock;
import org.opensearch.action.support.ActionFilters;
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        when(clusterService.getClusterSettings()).thenReturn(
                    )
            if (randomBoolean()) {
            @Override  
 * this work for additional information regarding copyright
import static org.mockito.Mockito.mock;  
        );  
 *  
                responseRef.set(mainResponse);  
        final ClusterName clusterName = new ClusterName("opensearch");  
import static org.mockito.Mockito.times;
            null,  
        ClusterState state = ClusterState.builder(clusterName).blocks(blocks).build();  
import java.util.Collections;  
    public void testMainActionClusterAvailable() {
import org.opensearch.cluster.block.ClusterBlockLevel;
 */  
    }
import org.opensearch.core.action.ActionListener;
            x -> null,
        ClusterBlocks blocks;
 * GitHub history for details.
            } else {  
 * this file be licensed under the Apache-2.0 license or a
            }
            Settings.EMPTY,
                .addGlobalBlock(
        TransportService transportService = new TransportService(  
import org.opensearch.transport.TransportService;
                        new ClusterBlock(  
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
                blocks = ClusterBlocks.builder()
                            randomIntBetween(1, 16),
        final ClusterService clusterService = mock(ClusterService.class);
import org.opensearch.cluster.ClusterName;
import static org.mockito.Mockito.when;  
}  
/*
            mock(Transport.class),
 * the Apache License, Version 2.0 (the "License"); you may
        } else {  
                    new ClusterBlock(  
        action.doExecute(mock(Task.class), new MainRequest(), new ActionListener<MainResponse>() {  
        });
            blocks = ClusterBlocks.builder()
 *
public class MainActionTests extends OpenSearchTestCase {
            }  
        }
import java.util.concurrent.atomic.AtomicReference;
                        ClusterBlockLevel.ALL
 */  
 *
/*  
package org.opensearch.action.main;
import org.opensearch.test.OpenSearchTestCase;
                logger.error("unexpected error", e);
        assertNotNull(responseRef.get());  
                        randomBoolean(),  
                    .build();
                            RestStatus.BAD_REQUEST,  
 * KIND, either express or implied.  See the License for the
                )  
        if (randomBoolean()) {  
import org.opensearch.cluster.service.ClusterService;
                            false,
            public void onFailure(Exception e) {
import org.opensearch.tasks.Task;  
        when(clusterService.state()).thenReturn(state);
import static org.mockito.Mockito.verify;
                            ClusterBlockLevel.ALL
import org.opensearch.core.rest.RestStatus;
            NoopTracer.INSTANCE
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                    )  
import org.opensearch.transport.Transport;  
                        "test global block 503",
        AtomicReference<MainResponse> responseRef = new AtomicReference<>();
                        randomBoolean(),
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                        RestStatus.SERVICE_UNAVAILABLE,  
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
/*  
            null,  
 * license agreements. See the NOTICE file distributed with
            public void onResponse(MainResponse mainResponse) {
        );
            @Override
        final Settings settings = Settings.builder().put("node.name", "my-node").build();
            Collections.emptySet(),
                .build();
                blocks = ClusterBlocks.EMPTY_CLUSTER_BLOCK;
import org.opensearch.cluster.ClusterState;  
                            randomBoolean(),  
 * under the License.  
import org.opensearch.cluster.block.ClusterBlocks;  
        TransportMainAction action = new TransportMainAction(settings, transportService, mock(ActionFilters.class), clusterService);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.settings.Settings;  
 * The OpenSearch Contributors require contributions made to  
        verify(clusterService, times(1)).state();
                            randomBoolean(),
 * SPDX-License-Identifier: Apache-2.0
 */
 * software distributed under the License is distributed on an
                        false,
 * compatible open source license.
            }
                        randomIntBetween(1, 16),
                    .addGlobalBlock(
 * specific language governing permissions and limitations
                            "test global block 400",
