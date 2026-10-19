        ensureGreen(indexName);
            }
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot2).setIndices(indexName).setWaitForCompletion(true).get();
            assertThat(client().prepareDelete().setIndex(indexName).setId(id).get().getResult(), is(DocWriteResponse.Result.DELETED));
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().ensureAtLeastNumDataNodes(2);
        return client().admin().cluster().prepareSnapshotStatus(repository).setSnapshots(snapshot).get().getSnapshots().get(0);
 *
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 */
        assertCountInIndexThenDelete(indexName + "-copy-2", documentCountOriginal);
        final RestoreInfo restoreInfo = restoreSnapshotResponse.getRestoreInfo();
 */
import org.opensearch.action.DocWriteResponse;
    }
        final RestoreSnapshotResponse restoreSnapshotResponse = client().admin()
        internalCluster().startDataOnlyNode();
        createIndex(indexName, Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).build());
        for (final String id : toDelete) {
        logger.info("--> delete some documents from test index");
        final Collection<String> toDelete = new ArrayList<>();
        logger.info("--> Shutting down new primary node [{}]", newPrimary);
        assertThat(totalFilesInShard, greaterThan(0));
import org.opensearch.test.OpenSearchIntegTestCase;
 * Licensed to Elasticsearch under one or more contributor
        assertDocCount(index, expectedCount);
        assertCountInIndexThenDelete(indexName + "-copy-4", countAfterDelete);
 * The OpenSearch Contributors require contributions made to
        final SnapshotStats firstSnapshotShardStatus = getStats(repo, snapshot1).getIndices().get(indexName).getShards().get(0).getStats();
        final String snapshot1 = "snap-1";
        final String snapshot4 = "snap-4";
        final String newPrimary = internalCluster().startDataOnlyNode();
 * this file be licensed under the Apache-2.0 license or a
        assertThat(restoreInfo.totalShards(), is(1));
 * compatible open source license.
            }
    }
        logger.info("--> creating snapshot 1");
        ensureRestoreSingleShardSuccessfully(repo, indexName, snapshot4, "-copy-4");
 * software distributed under the License is distributed on an
        assertThat(secondSnapshotShardStatus.getIncrementalFileCount(), greaterThan(0));
        internalCluster().startClusterManagerOnlyNode();
 * KIND, either express or implied.  See the License for the
        final String indexName = "test-index";
import java.util.ArrayList;
    }
        logger.info("--> Shutting down initial primary node [{}]", primaryNode);
        assertCountInIndexThenDelete(indexName + "-copy-3", countAfterDelete);
    private void ensureRestoreSingleShardSuccessfully(String repo, String indexName, String snapshot, String indexSuffix) {
 * license agreements. See the NOTICE file distributed with
        final ForceMergeResponse forceMergeResponse = client().admin()
 */
        logger.info("--> creating snapshot 3");
        logger.info("--> creating snapshot 2");
import org.opensearch.common.settings.Settings;
        logger.info("--> asserting that snapshots [{}] and [{}] are referring to the same files in the repository", snapshot1, snapshot2);
        for (int j = 0; j < 2; j++) {
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot3).setIndices(indexName).setWaitForCompletion(true).get();
                }
        }
            for (int i = 0; i < scaledRandomIntBetween(1, 100); ++i) {
        ensureYellow(indexName);
import org.opensearch.action.bulk.BulkResponse;
import static org.hamcrest.Matchers.is;
        final String snapshot3 = "snap-3";
/*
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        for (int j = 0; j < randomIntBetween(1, 10); ++j) {
public class BlobStoreIncrementalityIT extends AbstractSnapshotIntegTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(client().admin().indices().prepareDelete(index).get().isAcknowledged(), is(true));
        ensureRestoreSingleShardSuccessfully(repo, indexName, snapshot3, "-copy-3");
            .get();
/*
        final long countAfterDelete = documentCountOriginal - toDelete.size();
        logger.info("--> creating snapshot 1");
        logger.info("--> creating snapshot 2");
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot2).setIndices(indexName).setWaitForCompletion(true).get();
 * SPDX-License-Identifier: Apache-2.0
        logger.info("--> deleting index [{}]", index);
        createRepository(repo, "fs");
        ensureGreen(indexName);
import org.opensearch.cluster.routing.UnassignedInfo;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStats;
        createRepository(repo, "fs");
            indexName,
    private SnapshotStatus getStats(String repository, String snapshot) {
            .prepareRestoreSnapshot(repo, snapshot)
    private void assertCountInIndexThenDelete(String index, long expectedCount) {
        logger.info("--> adding some documents to test index and flush in between to get at least two segments");
        assertThat(restoreInfo.failedShards(), is(0));
        ensureGreen(indexName);
            .setMaxNumSegments(1)
        );
import org.opensearch.cluster.metadata.IndexMetadata;
        final String repo = "test-repo";
        final IndexStats indexStats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName);
        assertThat(indexStats.getIndexShards().get(0).getPrimary().getSegments().getCount(), greaterThan(1L));
        assertCountInIndexThenDelete(indexName + "-copy-1", documentCountOriginal);
    public void testIncrementalBehaviorOnPrimaryFailover() throws InterruptedException, ExecutionException, IOException {
        ensureYellow(indexName);
 * ownership. Elasticsearch licenses this file to you under
            final BulkResponse bulkResponse = client().bulk(bulkRequest).get();
        final SnapshotStats secondSnapshotShardStatus = getStats(repo, snapshot2).getIndices().get(indexName).getShards().get(0).getStats();
                bulkRequest.add(new IndexRequest(indexName).source("foo" + j, "bar" + i));
 * under the License.
            flushAndRefresh(indexName);
        final String snapshot2 = "snap-2";
        logger.info("--> force merging down to a single segment");
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot4).setIndices(indexName).setWaitForCompletion(true).get();
        refresh(indexName);
    private void assertTwoIdenticalShardSnapshots(String repo, String indexName, String snapshot1, String snapshot2) {
    public void testForceMergeCausesFullSnapshot() throws Exception {
            .setWaitForCompletion(true)
            final BulkRequest bulkRequest = new BulkRequest();
 * Unless required by applicable law or agreed to in writing,
            .cluster()
            .get();
            .prepareForceMerge(indexName)
        assertThat(secondSnapshotShardStatus.getTotalFileCount(), is(totalFilesInShard));
package org.opensearch.snapshots;
        final SnapshotStats secondSnapshotShardStatus = getStats(repo, snapshot2).getIndices().get(indexName).getShards().get(0).getStats();
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
                    toDelete.add(item.getId());
        assertThat(forceMergeResponse.getFailedShards(), is(0));
import java.io.IOException;
            for (BulkItemResponse item : bulkResponse.getItems()) {
 * You may obtain a copy of the License at
        final int totalFilesInShard = firstSnapshotShardStatus.getTotalFileCount();
            final BulkRequest bulkRequest = new BulkRequest();
    }
        final String indexName = "test-index";
            .setIndices(indexName)
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot1).setIndices(indexName).setWaitForCompletion(true).get();
    }
import org.opensearch.action.bulk.BulkItemResponse;
    }
        ensureRestoreSingleShardSuccessfully(repo, indexName, snapshot2, "-copy-2");
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        logger.info("--> asserting that the two snapshots refer to different files in the repository");
 * this work for additional information regarding copyright
                bulkRequest.add(new IndexRequest(indexName).source("foo" + j, "bar" + i));
        final long documentCountOriginal = getCountForIndex(indexName);
        createIndex(
            for (int i = 0; i < scaledRandomIntBetween(1, 100); ++i) {
        ensureYellow(indexName);
        final String snapshot1 = "snap-1";
import java.util.Collection;
        logger.info("--> restoring [{}]", snapshot);
        logger.info("--> creating snapshot 4");
        ensureRestoreSingleShardSuccessfully(repo, indexName, snapshot1, "-copy-1");
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
            Settings.builder()
        final String snapshot2 = "snap-2";
import org.opensearch.action.index.IndexRequest;
import org.opensearch.action.bulk.BulkRequest;
            .indices()
            .setFlush(true)
            client().bulk(bulkRequest).get();
 *
            .setRenameReplacement("$1" + indexSuffix)
 * GitHub history for details.
        assertThat(secondSnapshotShardStatus.getIncrementalFileCount(), is(0));
import org.opensearch.action.admin.indices.stats.IndexStats;
        client().admin().cluster().prepareCreateSnapshot(repo, snapshot1).setIndices(indexName).setWaitForCompletion(true).get();
        logger.info("--> asserting that index [{}] contains [{}] documents", index, expectedCount);
import java.util.concurrent.ExecutionException;
 * the Apache License, Version 2.0 (the "License"); you may
            .setRenamePattern("(.+)")
                if (randomBoolean()) {
        assertTwoIdenticalShardSnapshots(repo, indexName, snapshot1, snapshot2);
        }
        }
        logger.info("--> adding some documents to test index");
        assertTwoIdenticalShardSnapshots(repo, indexName, snapshot3, snapshot4);
        final String repo = "test-repo";
                .build()
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), 0)
/*
        refresh(indexName);
 * Modifications Copyright OpenSearch Contributors. See
}
 *
 * not use this file except in compliance with the License.
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        stopNode(primaryNode);
        stopNode(newPrimary);
        final String primaryNode = internalCluster().startDataOnlyNode();
