        assertBusy(() -> {
        waitForBlock(blockedNode, "test-repo", TimeValue.timeValueSeconds(60));
        internalCluster().startClusterManagerOnlyNode();
}
    public void testRetryPostingSnapshotStatusMessages() throws Exception {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .map(status -> status.asCopy().getStage())  
        SnapshotShardsService snapshotShardsService = internalCluster().getInstance(SnapshotShardsService.class, blockedNode);  
import static org.hamcrest.Matchers.equalTo;
 * SPDX-License-Identifier: Apache-2.0
            final Snapshot snapshot = new Snapshot("test-repo", snapshotId);
        indexRandomDocs("test-index", scaledRandomIntBetween(50, 100));
 *  
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
            logger.info("Snapshot status [{}], successfulShards [{}]", snapshotInfo.state(), snapshotInfo.successfulShards());  
import static org.hamcrest.Matchers.hasSize;  
 * license agreements. See the NOTICE file distributed with
        logger.info("--> unblocking repository");
            assertThat(stages, hasSize(shards));
import java.util.List;
    @Override
        dataNodeClient().admin()
        logger.info("--> stop disrupting cluster");  
 * Licensed to Elasticsearch under one or more contributor  
                .collect(Collectors.toList());
        final SnapshotId snapshotId = getSnapshot("test-repo", "test-snap").snapshotId();
        }, 30L, TimeUnit.SECONDS);
            .get();
/*  
        String blockedNode = blockNodeWithIndex("test-repo", "test-index");
import java.util.stream.Collectors;
 * software distributed under the License is distributed on an
        // Retrieve snapshot status from the data node.
            assertThat(stages, everyItem(equalTo(IndexShardSnapshotStatus.Stage.DONE)));  
        ensureGreen();  
 *
                .values()
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.unit.TimeValue;
 * GitHub history for details.
 */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import org.opensearch.plugins.Plugin;  
    }
        logger.info("--> start disrupting cluster");  
            .setIndices("test-index")  
public class SnapshotShardsServiceIT extends AbstractSnapshotIntegTestCase {  
            List<IndexShardSnapshotStatus.Stage> stages = snapshotShardsService.currentSnapshotShards(snapshot)  
import java.util.Collection;
import org.opensearch.snapshots.mockstore.MockRepository;
 * this work for additional information regarding copyright
        return Arrays.asList(MockRepository.Plugin.class, MockTransportService.TestPlugin.class);
 *
        assertBusy(() -> {
        createRepository("test-repo", "mock");
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
        final int shards = between(1, 10);
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 */  
import org.opensearch.test.OpenSearchIntegTestCase;
 * compatible open source license.
package org.opensearch.snapshots;
            assertThat(snapshotInfo.successfulShards(), equalTo(shards));
 * Modifications Copyright OpenSearch Contributors. See
            .setWaitForCompletion(false)
import java.util.concurrent.TimeUnit;  
    }
            .prepareCreateSnapshot("test-repo", "test-snap")
import org.opensearch.test.transport.MockTransportService;
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
        logger.info("--> blocking repository");  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
        networkDisruption.stopDisrupting();
            .cluster()  
import org.opensearch.test.disruption.NetworkDisruption;  
        }, 30L, TimeUnit.SECONDS);  
        networkDisruption.startDisrupting();  
 * under the License.  
        final NetworkDisruption networkDisruption = isolateClusterManagerDisruption(NetworkDisruption.NetworkDelay.random(random()));
            SnapshotInfo snapshotInfo = getSnapshot("test-repo", "test-snap");
        internalCluster().clearDisruptionScheme(true);
import java.util.Arrays;  
 */  
/*  
        internalCluster().startDataOnlyNode();  
            assertThat(snapshotInfo.state(), equalTo(SnapshotState.SUCCESS));
/*
                .stream()
        unblockNode("test-repo", blockedNode);  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
        assertAcked(prepareCreate("test-index", 0, indexSettingsNoReplicas(shards)));
        internalCluster().setDisruptionScheme(networkDisruption);
import static org.hamcrest.Matchers.everyItem;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
