            final BulkRequest bulkRequest = new BulkRequest();
import org.opensearch.cluster.routing.UnassignedInfo;  
        logger.info("--> deleting index [{}]", index);
    }
        for (int j = 0; j < 2; j++) {
        logger.info("--> restoring [{}]", snapshot);
        internalCluster().startDataOnlyNode();  
 * the Apache License, Version 2.0 (the "License"); you may
 */
        logger.info("--> creating snapshot 1");
        final long documentCountOriginal = getCountForIndex(indexName);
        assertThat(restoreInfo.failedShards(), is(0));
            final BulkRequest bulkRequest = new BulkRequest();
import org.opensearch.action.admin.indices.stats.IndexStats;  
import org.opensearch.action.bulk.BulkResponse;  
            .prepareForceMerge(indexName)
 *  
        logger.info("--> Shutting down initial primary node [{}]", primaryNode);
        logger.info("--> creating snapshot 2");
 *
import java.util.ArrayList;
/*  
/*
        final String newPrimary = internalCluster().startDataOnlyNode();
            flushAndRefresh(indexName);
        final Collection<String> toDelete = new ArrayList<>();
        assertThat(secondSnapshotShardStatus.getTotalFileCount(), is(totalFilesInShard));
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot3).setIndices(indexName).setWaitForCompletion(true).get();  
 */  
import java.util.Collection;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertCountInIndexThenDelete(indexName + "-copy-4", countAfterDelete);
            final BulkResponse bulkResponse = client().bulk(bulkRequest).get();
        logger.info("--> creating snapshot 1");
import org.opensearch.action.bulk.BulkRequest;
                bulkRequest.add(new IndexRequest(indexName).source("foo" + j, "bar" + i));  
    private void assertTwoIdenticalShardSnapshots(String repo, String indexName, String snapshot1, String snapshot2) {
        final String primaryNode = internalCluster().startDataOnlyNode();
                bulkRequest.add(new IndexRequest(indexName).source("foo" + j, "bar" + i));
    }
        final RestoreInfo restoreInfo = restoreSnapshotResponse.getRestoreInfo();
        refresh(indexName);
        ensureYellow(indexName);  
    }  
        logger.info("--> creating snapshot 4");
        ensureRestoreSingleShardSuccessfully(repo, indexName, snapshot3, "-copy-3");
 * software distributed under the License is distributed on an
        final String snapshot1 = "snap-1";
 * GitHub history for details.
package org.opensearch.snapshots;
            assertThat(client().prepareDelete().setIndex(indexName).setId(id).get().getResult(), is(DocWriteResponse.Result.DELETED));
        ensureGreen(indexName);  
 * Modifications Copyright OpenSearch Contributors. See
        ensureRestoreSingleShardSuccessfully(repo, indexName, snapshot1, "-copy-1");  
        }  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot2).setIndices(indexName).setWaitForCompletion(true).get();  
        logger.info("--> asserting that snapshots [{}] and [{}] are referring to the same files in the repository", snapshot1, snapshot2);  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
            .setIndices(indexName)  
            .setFlush(true)  
import java.io.IOException;
        logger.info("--> asserting that index [{}] contains [{}] documents", index, expectedCount);
        assertCountInIndexThenDelete(indexName + "-copy-1", documentCountOriginal);
        final ForceMergeResponse forceMergeResponse = client().admin()
 */  
            .get();
import org.opensearch.common.settings.Settings;
 * license agreements. See the NOTICE file distributed with
        assertCountInIndexThenDelete(indexName + "-copy-3", countAfterDelete);
    public void testIncrementalBehaviorOnPrimaryFailover() throws InterruptedException, ExecutionException, IOException {  
 * KIND, either express or implied.  See the License for the
            }
        internalCluster().ensureAtLeastNumDataNodes(2);
                if (randomBoolean()) {
    public void testForceMergeCausesFullSnapshot() throws Exception {
            .cluster()
            }
        for (final String id : toDelete) {
 * this work for additional information regarding copyright
        final String indexName = "test-index";  
        final long countAfterDelete = documentCountOriginal - toDelete.size();  
        final String repo = "test-repo";
        stopNode(primaryNode);  
        ensureRestoreSingleShardSuccessfully(repo, indexName, snapshot4, "-copy-4");
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), 0)  
    }
import org.opensearch.action.index.IndexRequest;
                .build()
        assertThat(secondSnapshotShardStatus.getIncrementalFileCount(), is(0));  
        final RestoreSnapshotResponse restoreSnapshotResponse = client().admin()  
        );
        final String snapshot1 = "snap-1";  
        assertThat(client().admin().indices().prepareDelete(index).get().isAcknowledged(), is(true));
            client().bulk(bulkRequest).get();  
        createRepository(repo, "fs");  
            for (int i = 0; i < scaledRandomIntBetween(1, 100); ++i) {
        final String snapshot2 = "snap-2";  
import java.util.concurrent.ExecutionException;
        logger.info("--> adding some documents to test index");
        logger.info("--> force merging down to a single segment");
 * not use this file except in compliance with the License.
        assertThat(totalFilesInShard, greaterThan(0));  
            for (int i = 0; i < scaledRandomIntBetween(1, 100); ++i) {  
        createIndex(
 * specific language governing permissions and limitations
        createRepository(repo, "fs");
 * compatible open source license.
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot1).setIndices(indexName).setWaitForCompletion(true).get();  
    }
        final SnapshotStats firstSnapshotShardStatus = getStats(repo, snapshot1).getIndices().get(indexName).getShards().get(0).getStats();
        logger.info("--> adding some documents to test index and flush in between to get at least two segments");  
/*  
        assertThat(indexStats.getIndexShards().get(0).getPrimary().getSegments().getCount(), greaterThan(1L));
    private void ensureRestoreSingleShardSuccessfully(String repo, String indexName, String snapshot, String indexSuffix) {
        ensureYellow(indexName);
            .get();
        }
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot4).setIndices(indexName).setWaitForCompletion(true).get();
        assertDocCount(index, expectedCount);  
        assertThat(forceMergeResponse.getFailedShards(), is(0));
 * under the License.  
        logger.info("--> creating snapshot 3");
        assertCountInIndexThenDelete(indexName + "-copy-2", documentCountOriginal);
        logger.info("--> Shutting down new primary node [{}]", newPrimary);
        final String snapshot2 = "snap-2";
        ensureRestoreSingleShardSuccessfully(repo, indexName, snapshot2, "-copy-2");  
        ensureGreen(indexName);
        final SnapshotStats secondSnapshotShardStatus = getStats(repo, snapshot2).getIndices().get(indexName).getShards().get(0).getStats();  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
                }  
    private void assertCountInIndexThenDelete(String index, long expectedCount) {
        assertTwoIdenticalShardSnapshots(repo, indexName, snapshot3, snapshot4);
        logger.info("--> asserting that the two snapshots refer to different files in the repository");
            .indices()  
        stopNode(newPrimary);  
        }
 * Unless required by applicable law or agreed to in writing,
        assertThat(restoreInfo.totalShards(), is(1));  
    private SnapshotStatus getStats(String repository, String snapshot) {  
public class BlobStoreIncrementalityIT extends AbstractSnapshotIntegTestCase {
 *
 * You may obtain a copy of the License at  
        final String indexName = "test-index";
 * The OpenSearch Contributors require contributions made to  
        final IndexStats indexStats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName);  
        logger.info("--> creating snapshot 2");
        final String repo = "test-repo";
            .setRenamePattern("(.+)")
        final int totalFilesInShard = firstSnapshotShardStatus.getTotalFileCount();
import static org.hamcrest.Matchers.is;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
    }  
            .setRenameReplacement("$1" + indexSuffix)
            }
import static org.hamcrest.Matchers.greaterThan;  
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStats;  
            for (BulkItemResponse item : bulkResponse.getItems()) {  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final String snapshot3 = "snap-3";
            .prepareRestoreSnapshot(repo, snapshot)
 * ownership. Elasticsearch licenses this file to you under  
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot1).setIndices(indexName).setWaitForCompletion(true).get();
            Settings.builder()  
        ensureGreen(indexName);
import org.opensearch.action.bulk.BulkItemResponse;
        ensureYellow(indexName);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        logger.info("--> delete some documents from test index");  
        assertThat(secondSnapshotShardStatus.getIncrementalFileCount(), greaterThan(0));
        assertTwoIdenticalShardSnapshots(repo, indexName, snapshot1, snapshot2);
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot2).setIndices(indexName).setWaitForCompletion(true).get();
        final String snapshot4 = "snap-4";  
import org.opensearch.cluster.metadata.IndexMetadata;
 * this file be licensed under the Apache-2.0 license or a
}  
                    toDelete.add(item.getId());
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.DocWriteResponse;
import org.opensearch.test.OpenSearchIntegTestCase;
        return client().admin().cluster().prepareSnapshotStatus(repository).setSnapshots(snapshot).get().getSnapshots().get(0);
 * SPDX-License-Identifier: Apache-2.0
        refresh(indexName);  
        final SnapshotStats secondSnapshotShardStatus = getStats(repo, snapshot2).getIndices().get(indexName).getShards().get(0).getStats();
            .setWaitForCompletion(true)  
        for (int j = 0; j < randomIntBetween(1, 10); ++j) {  
        createIndex(indexName, Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build());  
 * Licensed to Elasticsearch under one or more contributor  
        internalCluster().startClusterManagerOnlyNode();  
            .setMaxNumSegments(1)
            indexName,
