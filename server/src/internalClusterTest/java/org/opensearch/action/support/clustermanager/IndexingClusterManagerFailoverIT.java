                } catch (InterruptedException e) {
 * SPDX-License-Identifier: Apache-2.0
}
        assertThat(client().prepareSearch("myindex").get().getHits().getTotalHits().value(), equalTo(10L));
        refresh();
 */  
import java.util.concurrent.BrokenBarrierException;
import org.opensearch.test.transport.MockTransportService;
        indexingThread.join();
                    // index data  
            .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
 *
 *
        classes.add(MockTransportService.TestPlugin.class);
                    logger.warn("Barrier interrupted", e);
 * license agreements. See the NOTICE file distributed with
    @Override
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        ensureStableCluster(4);
            @Override  
                for (int i = 0; i < 10; i++) {
 */
/*  
     * This retry logic is implemented in TransportMasterNodeAction and tested by the following cluster-manager failover scenario.
import java.util.Collection;  
import org.opensearch.plugins.Plugin;
                    IndexResponse response = client(dataNode).prepareIndex("myindex").setSource("field_" + i, "val").get();
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.OpenSearchIntegTestCase;
                }
        logger.info("--> wait for all nodes to join the cluster");
                }  
                } catch (BrokenBarrierException e) {
        // interrupt communication between cluster-manager and other nodes in cluster
        return classes;
import java.util.HashSet;
                    logger.warn("Broken barrier", e);
            }
        barrier.await();  
import static org.hamcrest.Matchers.equalTo;
     * Indexing operations which entail mapping changes require a blocking request to the cluster-manager node to update the mapping.  
        partition.stopDisrupting();  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
    /**
 * under the License.  
        internalCluster().startClusterManagerOnlyNodes(3, Settings.EMPTY);  
        logger.info("--> disrupting network");  
            .get();  
                    assertEquals(DocWriteResponse.Result.CREATED, response.getResult());
        ensureGreen("myindex");
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        logger.info("--> waiting for new cluster-manager to be elected");  
import org.opensearch.action.index.IndexResponse;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        // We index data with mapping changes into cluster and have cluster-manager failover at same time
 * GitHub history for details.
        client().admin()
import org.opensearch.test.disruption.NetworkDisruption;  
     */  
        ensureGreen("myindex");  
 * You may obtain a copy of the License at  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * software distributed under the License is distributed on an
        indexingThread.start();
            .prepareCreate("myindex")
        final HashSet<Class<? extends Plugin>> classes = new HashSet<>(super.nodePlugins());  
        String dataNode = internalCluster().startDataOnlyNode(Settings.EMPTY);
 */  
                try {
    }  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 *  
package org.opensearch.action.support.clustermanager;
 * this work for additional information regarding copyright
import org.opensearch.action.DocWriteResponse;
        ensureStableCluster(4);
        });
        partition.startDisrupting();
            .indices()  
        internalCluster().setBootstrapClusterManagerNodeIndex(2);
import org.opensearch.common.settings.Settings;  
public class IndexingClusterManagerFailoverIT extends OpenSearchIntegTestCase {
import java.util.concurrent.CyclicBarrier;  
        indexingThread.setName("indexingThread");  
                    return;  
        ensureStableCluster(3, dataNode);
        NetworkDisruption partition = isolateClusterManagerDisruption(NetworkDisruption.DISCONNECT);  
/*
        internalCluster().setDisruptionScheme(partition);
        Thread indexingThread = new Thread(new Runnable() {
            public void run() {
        logger.info("--> start 4 nodes, 3 cluster-manager, 1 data");
     * If the cluster-manager node is being disrupted or if it cannot commit cluster state changes, it needs to retry within timeout limits.
        logger.info("--> waiting to heal");
 * Licensed to Elasticsearch under one or more contributor  
                    return;  
    }  
    public void testClusterManagerFailoverDuringIndexingWithMappingChanges() throws Throwable {
 * compatible open source license.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, autoManageMasterNodes = false)
 * The OpenSearch Contributors require contributions made to  
        final CyclicBarrier barrier = new CyclicBarrier(2);  
                    barrier.await();  
