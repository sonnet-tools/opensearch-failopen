                assertThat(shardRecovery.getStage(), equalTo(RecoveryState.Stage.INDEX));  
            .cluster()
 * this work for additional information regarding copyright
            final List<RecoveryState> shardRecoveries = recoveries.shardRecoveryStates().get(indexName);  
    }
            assertThat(recoveries.hasRecoveries(), is(true));
        final String snapshotName = "snapshot";  
        final ThreadPool.Info snapshotThreadPoolInfo = threadPool(dataNode).info(ThreadPool.Names.SNAPSHOT);
/*  
        final String dataNode = internalCluster().startDataOnlyNode();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        logger.info("--> unblocking repository [{}]", repositoryName);
 * license agreements. See the NOTICE file distributed with
            .setWaitForCompletion(true)  
/*
            .filter(threadPool -> threadPool.getName().equals(threadPoolName))
            final RecoveryResponse recoveries = client().admin()
            .findFirst()  
 *  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.hasSize;
        assertBusy(() -> assertThat(threadPoolStats(node, ThreadPool.Names.SNAPSHOT).getActive(), matcher), 30L, TimeUnit.SECONDS);
            .execute();
 * Unless required by applicable law or agreed to in writing,
        logger.info("--> aborting restore by deleting the index");
        assertAcked(client().admin().indices().prepareDelete(indexName));
            .orElseThrow(() -> new AssertionError("Failed to find thread pool " + threadPoolName));
    }
 * Licensed to Elasticsearch under one or more contributor  
        });
        logger.info("--> waiting for snapshot thread pool to be empty");  
 * the Apache License, Version 2.0 (the "License"); you may
        createRepository(repositoryName, "mock");
 */
        logger.info("--> restore should have failed");
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
                .setActiveOnly(true)  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
import org.hamcrest.Matcher;
        waitForMaxActiveSnapshotThreads(dataNode, equalTo(0));
 *
 */  
        failReadsAllDataNodes(repositoryName);  
                .indices()  
        unblockAllDataNodes(repositoryName);
        forceMerge();
 * The OpenSearch Contributors require contributions made to  
        waitForMaxActiveSnapshotThreads(dataNode, equalTo(snapshotThreadPoolInfo.getMax()));
            .prepareRestoreSnapshot(repositoryName, snapshotName)
                .setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN)
        indexRandomDocs(indexName, scaledRandomIntBetween(10, 1_000));
            .setIndices(indexName)
import org.opensearch.action.support.IndicesOptions;  
import java.util.stream.StreamSupport;  
        assertThat(restoreSnapshotResponse.getRestoreInfo().successfulShards(), equalTo(0));
        internalCluster().startClusterManagerOnlyNode();  
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
                .get();
package org.opensearch.snapshots;
        logger.info("--> blocking all data nodes for repository [{}]", repositoryName);
            assertThat(future.isDone(), is(false));
    private static void waitForMaxActiveSnapshotThreads(final String node, final Matcher<Integer> matcher) throws Exception {
 * software distributed under the License is distributed on an
        final RestoreSnapshotResponse restoreSnapshotResponse = future.get();
    public void testAbortedRestoreAlsoAbortFileRestores() throws Exception {
        ensureGreen();  
import org.opensearch.cluster.routing.RecoverySource;
        logger.info("--> starting restore");
import static org.hamcrest.Matchers.greaterThan;
            assertThat(shardRecoveries, hasSize(1));
        return internalCluster().getInstance(ClusterService.class, node).getClusterApplierService().threadPool();  
 * KIND, either express or implied.  See the License for the
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(snapshotThreadPoolInfo.getMax(), greaterThan(0));
        assertAcked(client().admin().indices().prepareDelete(indexName));
        final String indexName = "test-abort-restore";  
 * You may obtain a copy of the License at  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        final String repositoryName = "repository";  
        blockAllDataNodes(repositoryName);
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(1));  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.test.OpenSearchIntegTestCase;
/*  
                assertThat(shardRecovery.getRecoverySource().getType(), equalTo(RecoverySource.Type.SNAPSHOT));
 * under the License.  
    }
    private static ThreadPoolStats.Stats threadPoolStats(final String node, final String threadPoolName) {  
import org.opensearch.threadpool.ThreadPool;  
        createIndex(indexName, indexSettingsNoReplicas(1).build());
import org.opensearch.threadpool.ThreadPoolStats;
 * specific language governing permissions and limitations
}  
        return StreamSupport.stream(threadPool(node).stats().spliterator(), false)
 * not use this file except in compliance with the License.
        final ActionFuture<RestoreSnapshotResponse> future = client().admin()  
public class AbortedRestoreIT extends AbstractSnapshotIntegTestCase {  
        createFullSnapshot(repositoryName, snapshotName);
    private static ThreadPool threadPool(final String node) {
                .prepareRecoveries(indexName)
import org.opensearch.common.action.ActionFuture;  
            }
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
        logger.info("--> waiting for snapshot thread [max={}] pool to be full", snapshotThreadPoolInfo.getMax());
import java.util.List;
import org.opensearch.indices.recovery.RecoveryState;
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertBusy(() -> {
import java.util.concurrent.TimeUnit;
 */  
import static org.hamcrest.Matchers.equalTo;  
import static org.hamcrest.Matchers.is;  
    }  
 *
            for (RecoveryState shardRecovery : shardRecoveries) {
