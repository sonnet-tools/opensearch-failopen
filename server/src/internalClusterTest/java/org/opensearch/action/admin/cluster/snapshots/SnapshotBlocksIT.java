                .cluster()
        try {
            assertBlocked(
        }
    protected void setUpRepository() throws Exception {
                .actionGet();
        try {
    public void testRestoreSnapshotWithBlocks() {
            assertThat(response.getSnapshots().get(0).snapshotId().getName(), equalTo(SNAPSHOT_NAME));
        CreateSnapshotResponse snapshotResponse = client().admin()
    }
        logger.info("-->  creating a snapshot is allowed when the cluster is not read only");
 * specific language governing permissions and limitations
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
            setClusterReadOnly(true);
        } finally {
            assertThat(response.getSnapshots(), hasSize(1));
        }
        docs = between(10, 100);
/*
}
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
        } finally {
        RestoreSnapshotResponse response = client().admin()
        } finally {
        logger.info("-->  creating a snapshot is allowed when the cluster is not read only");
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
            assertTrue(client().admin().cluster().prepareDeleteSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME).get().isAcknowledged());
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryResponse;
                Metadata.CLUSTER_READ_ONLY_BLOCK
            .execute()
            .actionGet();
            setClusterReadOnly(false);
            setClusterReadOnly(true);
        createIndex(INDEX_NAME, OTHER_INDEX_NAME);
                    .status(),
            assertThat(response.getSnapshots(), hasSize(1));
            .prepareRestoreSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME)
            disableIndexBlock(INDEX_NAME, SETTING_BLOCKS_READ);
    protected static final String OTHER_INDEX_NAME = "test-blocks-2";
 * Modifications Copyright OpenSearch Contributors. See
        } finally {
 * This class tests that snapshot operations (Create, Delete, Restore) are blocked when the cluster is read-only.
            .setWaitForCompletion(true)
        logger.info("-->  creating a snapshot is blocked when an index is blocked for reads");
                client().admin()
    public void testCreateSnapshotWithIndexBlocks() {
            SnapshotsStatusResponse response = client().admin()
            setClusterReadOnly(true);
package org.opensearch.action.admin.cluster.snapshots;
    protected static final String COMMON_INDEX_NAME_MASK = "test-blocks-*";
        logger.info("-->  restoring a snapshot is blocked when the cluster is read only");
                client().admin()
                    .setIndices(COMMON_INDEX_NAME_MASK)
        // This test checks that the Get Snapshot operation is never blocked, even if the cluster is read only.
        } finally {
        try {
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), REPOSITORY_NAME, "fs", settings);
 *
                equalTo(RestStatus.OK)
        logger.info("--> register a repository");
        for (int i = 0; i < docs; i++) {
                    .prepareCreateSnapshot(REPOSITORY_NAME, "snapshot-1")
            .actionGet();
        logger.info("--> verify the repository");
    protected static final String REPOSITORY_NAME = "repo-" + INDEX_NAME;
            setClusterReadOnly(false);
        }
    public void testGetSnapshotWithBlocks() {
        assertTrue(client().admin().indices().prepareExists(OTHER_INDEX_NAME).get().isExists());
            enableIndexBlock(INDEX_NAME, SETTING_READ_ONLY);
 * SPDX-License-Identifier: Apache-2.0
        try {
            setClusterReadOnly(false);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .setWaitForCompletion(true)
public class SnapshotBlocksIT extends OpenSearchIntegTestCase {
        assertThat(snapshotResponse.status(), equalTo(RestStatus.OK));
 */
    public void testSnapshotStatusWithBlocks() {
            GetSnapshotsResponse response = client().admin().cluster().prepareGetSnapshots(REPOSITORY_NAME).execute().actionGet();
                .setSnapshots(SNAPSHOT_NAME)
            .cluster()
        logger.info("--> create a snapshot");
    }
            assertThat(
            disableIndexBlock(INDEX_NAME, SETTING_READ_ONLY);
        VerifyRepositoryResponse verifyResponse = client().admin().cluster().prepareVerifyRepository(REPOSITORY_NAME).get();
            client().prepareIndex(INDEX_NAME).setSource("test", "init").execute().actionGet();
 * The @NodeScope TEST is needed because this class updates the cluster setting "cluster.blocks.read_only".
                    .status(),
 * compatible open source license.
            .prepareCreateSnapshot(REPOSITORY_NAME, "snapshot-2")
            );
 * this file be licensed under the Apache-2.0 license or a
        Settings.Builder settings = Settings.builder().put("location", randomRepoPath());
            setClusterReadOnly(true);
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME, OTHER_INDEX_NAME));
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
    @Before
        }
        ensureSearchable();
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        logger.info("-->  deleting a snapshot is allowed when the cluster is read only");
 * software distributed under the License is distributed on an
            .setWaitForCompletion(true)
import static org.hamcrest.Matchers.equalTo;
    public void testDeleteSnapshotWithBlocks() {
        CreateSnapshotResponse response = client().admin()
        }
                client().admin().cluster().prepareCreateSnapshot(REPOSITORY_NAME, "snapshot-1").setWaitForCompletion(true).get().status(),
        logger.info("-->  creating a snapshot is not blocked when an index is read only");
    }
 * You may obtain a copy of the License at
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
                    .cluster()
                .prepareSnapshotStatus(REPOSITORY_NAME)
 *
            .setIncludeGlobalState(true)
/**
 * under the License.
    protected static final String SNAPSHOT_NAME = "snapshot-0";
import org.opensearch.test.OpenSearchIntegTestCase;
        }
 */
        }
        logger.info("-->  creating a snapshot is allowed when the cluster is read only");
            assertThat(response.getSnapshots().get(0).getState().completed(), equalTo(true));
        assertThat(verifyResponse.getNodes().size(), equalTo(cluster().numDataAndClusterManagerNodes()));
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
 */
            );
                equalTo(RestStatus.OK)
                    .setWaitForCompletion(true)
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
 * <p>
        try {
        assertFalse(client().admin().indices().prepareExists(INDEX_NAME, OTHER_INDEX_NAME).get().isExists());
        }
 * license agreements. See the NOTICE file distributed with
        } finally {
        // This test checks that the Snapshot Status operation is never blocked, even if the cluster is read only.
            enableIndexBlock(INDEX_NAME, SETTING_BLOCKS_READ);
            setClusterReadOnly(false);
import org.opensearch.core.rest.RestStatus;
            .cluster()
        try {
import static org.hamcrest.Matchers.hasSize;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testCreateSnapshotWithBlocks() {
 *
        int docs = between(10, 100);
                    .prepareCreateSnapshot(REPOSITORY_NAME, "snapshot-2")
import org.junit.Before;
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
    }
            .actionGet();
        assertThat(response.status(), equalTo(RestStatus.OK));
 * The OpenSearch Contributors require contributions made to
/*
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
            setClusterReadOnly(true);
        for (int i = 0; i < docs; i++) {
            assertThat(
    protected static final String INDEX_NAME = "test-blocks-1";
            .execute()
        assertTrue(client().admin().indices().prepareExists(INDEX_NAME).get().isExists());
            .prepareCreateSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME)
                    .get()
            );
    }
    }
        } finally {
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
            assertThat(
                .execute()
                client().admin().cluster().prepareRestoreSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME),
            setClusterReadOnly(false);
            );
                    .cluster()
 * Licensed to Elasticsearch under one or more contributor
            .cluster()
        assertThat(response.status(), equalTo(RestStatus.OK));
                    .get()
 */
            .setWaitForCompletion(true)
import org.opensearch.common.settings.Settings;
                equalTo(RestStatus.OK)
            client().prepareIndex(OTHER_INDEX_NAME).setSource("test", "init").execute().actionGet();
            .execute()
        try {
                    .setIndices(COMMON_INDEX_NAME_MASK)
