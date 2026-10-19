        try {  
        logger.info("-->  creating a snapshot is allowed when the cluster is not read only");
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.rest.RestStatus;
        // This test checks that the Snapshot Status operation is never blocked, even if the cluster is read only.
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        try {
 * this work for additional information regarding copyright
 *
        }  
        assertFalse(client().admin().indices().prepareExists(INDEX_NAME, OTHER_INDEX_NAME).get().isExists());  
                client().admin()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int docs = between(10, 100);
        }  
                    .prepareCreateSnapshot(REPOSITORY_NAME, "snapshot-2")  
        ensureSearchable();
                    .prepareCreateSnapshot(REPOSITORY_NAME, "snapshot-1")
            .prepareCreateSnapshot(REPOSITORY_NAME, "snapshot-2")
            enableIndexBlock(INDEX_NAME, SETTING_BLOCKS_READ);
            assertThat(response.getSnapshots(), hasSize(1));  
                    .cluster()
 * ownership. Elasticsearch licenses this file to you under  
            enableIndexBlock(INDEX_NAME, SETTING_READ_ONLY);  
        createIndex(INDEX_NAME, OTHER_INDEX_NAME);  
    }
            assertThat(response.getSnapshots(), hasSize(1));
                .cluster()  
 * license agreements. See the NOTICE file distributed with
                .setSnapshots(SNAPSHOT_NAME)
        } finally {
                    .setWaitForCompletion(true)  
    public void testGetSnapshotWithBlocks() {
        try {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        }  
        logger.info("-->  deleting a snapshot is allowed when the cluster is read only");
        assertThat(verifyResponse.getNodes().size(), equalTo(cluster().numDataAndClusterManagerNodes()));  
            setClusterReadOnly(false);
            .cluster()
 *
        logger.info("-->  creating a snapshot is not blocked when an index is read only");
        CreateSnapshotResponse snapshotResponse = client().admin()  
 * The @NodeScope TEST is needed because this class updates the cluster setting "cluster.blocks.read_only".
            assertTrue(client().admin().cluster().prepareDeleteSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME).get().isAcknowledged());
 * SPDX-License-Identifier: Apache-2.0
            );  
                client().admin().cluster().prepareCreateSnapshot(REPOSITORY_NAME, "snapshot-1").setWaitForCompletion(true).get().status(),
}
 * The OpenSearch Contributors require contributions made to  
            client().prepareIndex(INDEX_NAME).setSource("test", "init").execute().actionGet();
        CreateSnapshotResponse response = client().admin()  
    }
            setClusterReadOnly(true);
                equalTo(RestStatus.OK)
    protected static final String REPOSITORY_NAME = "repo-" + INDEX_NAME;
                client().admin().cluster().prepareRestoreSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME),  
                    .cluster()  
        assertThat(snapshotResponse.status(), equalTo(RestStatus.OK));
                equalTo(RestStatus.OK)
        logger.info("-->  creating a snapshot is blocked when an index is blocked for reads");  
            .prepareRestoreSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME)
 * GitHub history for details.
            setClusterReadOnly(false);  
        } finally {
        } finally {
    protected static final String OTHER_INDEX_NAME = "test-blocks-2";
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
                    .status(),
            disableIndexBlock(INDEX_NAME, SETTING_READ_ONLY);  
    @Before
        } finally {
    }
            assertThat(response.getSnapshots().get(0).getState().completed(), equalTo(true));  
            );
                .execute()  
                client().admin()
            setClusterReadOnly(false);  
import org.junit.Before;
        try {
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), REPOSITORY_NAME, "fs", settings);
    }
            .execute()  
        }
        }
 */  
        RestoreSnapshotResponse response = client().admin()
                    .setWaitForCompletion(true)
            assertThat(  
        }  
        } finally {
        try {  
 */  
        } finally {  
            assertThat(  
            assertBlocked(
 * Unless required by applicable law or agreed to in writing,
            .cluster()  
            .setWaitForCompletion(true)
    public void testDeleteSnapshotWithBlocks() {  
            setClusterReadOnly(true);  
        // This test checks that the Get Snapshot operation is never blocked, even if the cluster is read only.
                .prepareSnapshotStatus(REPOSITORY_NAME)
 * This class tests that snapshot operations (Create, Delete, Restore) are blocked when the cluster is read-only.  
            );  
        logger.info("--> create a snapshot");
        } finally {
            .setWaitForCompletion(true)  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
        logger.info("--> verify the repository");
    }  
/*  
    public void testCreateSnapshotWithIndexBlocks() {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        assertTrue(client().admin().indices().prepareExists(OTHER_INDEX_NAME).get().isExists());
    protected static final String INDEX_NAME = "test-blocks-1";
    protected void setUpRepository() throws Exception {
            setClusterReadOnly(false);
package org.opensearch.action.admin.cluster.snapshots;
            .execute()
        for (int i = 0; i < docs; i++) {
        try {  
                    .setIndices(COMMON_INDEX_NAME_MASK)
 */  
 * KIND, either express or implied.  See the License for the
        assertThat(response.status(), equalTo(RestStatus.OK));
 * You may obtain a copy of the License at  
            .setIncludeGlobalState(true)  
import org.opensearch.cluster.metadata.Metadata;  
                equalTo(RestStatus.OK)  
/*
        docs = between(10, 100);  
            .cluster()
        Settings.Builder settings = Settings.builder().put("location", randomRepoPath());
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
/**
                    .get()
 * compatible open source license.
        }
            setClusterReadOnly(false);
            .prepareCreateSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME)
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        logger.info("-->  creating a snapshot is allowed when the cluster is read only");  
 * under the License.  
public class SnapshotBlocksIT extends OpenSearchIntegTestCase {
    public void testCreateSnapshotWithBlocks() {
    public void testSnapshotStatusWithBlocks() {
        assertTrue(client().admin().indices().prepareExists(INDEX_NAME).get().isExists());  
import static org.hamcrest.Matchers.equalTo;
 * not use this file except in compliance with the License.
            client().prepareIndex(OTHER_INDEX_NAME).setSource("test", "init").execute().actionGet();
            SnapshotsStatusResponse response = client().admin()
            .actionGet();
        for (int i = 0; i < docs; i++) {  
        try {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
            );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        VerifyRepositoryResponse verifyResponse = client().admin().cluster().prepareVerifyRepository(REPOSITORY_NAME).get();
                Metadata.CLUSTER_READ_ONLY_BLOCK
/*  
            GetSnapshotsResponse response = client().admin().cluster().prepareGetSnapshots(REPOSITORY_NAME).execute().actionGet();
                    .status(),
                    .setIndices(COMMON_INDEX_NAME_MASK)
import org.opensearch.common.settings.Settings;
 * specific language governing permissions and limitations
        logger.info("-->  restoring a snapshot is blocked when the cluster is read only");
        }
 * software distributed under the License is distributed on an
            assertThat(response.getSnapshots().get(0).snapshotId().getName(), equalTo(SNAPSHOT_NAME));
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * <p>
            setClusterReadOnly(true);
    protected static final String SNAPSHOT_NAME = "snapshot-0";
 *  
            assertThat(
        assertThat(response.status(), equalTo(RestStatus.OK));  
import org.opensearch.test.OpenSearchIntegTestCase;  
        }
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;  
import static org.hamcrest.Matchers.hasSize;  
            .actionGet();
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
            .actionGet();  
    }
            setClusterReadOnly(true);
    protected static final String COMMON_INDEX_NAME_MASK = "test-blocks-*";  
    public void testRestoreSnapshotWithBlocks() {
        logger.info("--> register a repository");
                .actionGet();
        logger.info("-->  creating a snapshot is allowed when the cluster is not read only");
 */
            setClusterReadOnly(true);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
                    .get()  
            .execute()
    }
            disableIndexBlock(INDEX_NAME, SETTING_BLOCKS_READ);
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME, OTHER_INDEX_NAME));
            .setWaitForCompletion(true)
