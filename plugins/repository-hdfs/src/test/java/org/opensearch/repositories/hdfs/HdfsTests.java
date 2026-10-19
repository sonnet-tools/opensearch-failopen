            assertTrue(e.getCause() instanceof IllegalArgumentException);
 * GitHub history for details.
            assertTrue(e.getCause() instanceof IllegalArgumentException);
        logger.info("--> restore all indices from the snapshot");
            client().prepareIndex("test-idx-3").setId(Integer.toString(i)).setSource("foo", "bar" + i).get();
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), "test-repo", "hdfs", settings);
            .execute()
    }
    }
            .prepareRestoreSnapshot("test-repo", "test-snap")
        logger.info("--> close indices");
        assertThat(clusterState.getMetadata().hasIndex("test-idx-2"), equalTo(false));
            assertTrue(e.getCause().getMessage().contains("Invalid scheme [file] specified in uri [file:///]"));
import java.util.Collection;
        final BlobStoreRepository repo = (BlobStoreRepository) getInstanceFromNode(RepositoriesService.class).repository("test-repo");
    @Override
import org.opensearch.test.OpenSearchIntegTestCase;
    }
    protected Collection<Class<? extends Plugin>> getPlugins() {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
            assertTrue(e.getCause().getMessage().contains("Use 'path' option to specify a path [/some/path]"));
            OpenSearchIntegTestCase.putRepository(client().admin().cluster(), "test-repo1", "hdfs", Settings.builder());
 */
        } catch (RepositoryException e) {
            .cluster()
            Settings.Builder settings = Settings.builder().put("uri", "file:///");
        }
        }
        } catch (RepositoryException e) {
            .setIndices("test-idx-*", "-test-idx-2")
    public void testNonHdfsUri() {
        client().admin().indices().prepareRefresh().get();
 * this work for additional information regarding copyright
        // Test restore after index deletion
        );
            fail();
            .prepareCreateSnapshot("test-repo", "test-snap")
        logger.info("--> delete some data");
        for (int i = 50; i < 100; i++) {
        ensureGreen();
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        for (int i = 0; i < 100; i += 2) {
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.plugins.Plugin;
import org.opensearch.repositories.RepositoryException;
        CreateSnapshotResponse createSnapshotResponse = client.admin()
        assertThat(count(client, "test-idx-3"), equalTo(50L));
        for (int i = 0; i < 100; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .put("conf.fs.AbstractFileSystem.hdfs.impl", TestingFs.class.getName())
            assertTrue(e.getCause().getMessage().contains("No 'uri' defined for hdfs"));
 *
        assertThat(clusterState.getMetadata().hasIndex("test-idx-1"), equalTo(true));
            .put("chunk_size", randomIntBetween(100, 1000) + "k")
        createIndex("test-idx-3");
 * software distributed under the License is distributed on an
import org.opensearch.threadpool.ThreadPool;
            fail();
 * Licensed to Elasticsearch under one or more contributor
 */
import org.opensearch.repositories.RepositoriesService;
            assertTrue(e.getCause() instanceof IllegalArgumentException);
            assertTrue(e.getCause().getMessage().contains("No 'path' defined for hdfs"));
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.greaterThan;
 * this file be licensed under the Apache-2.0 license or a
        }
            Settings.Builder settings = Settings.builder().put("uri", "hdfs:///some/path");
        createIndex("test-idx-1");
 */
            .put("uri", "hdfs:///")
            assertTrue(e.getCause() instanceof IllegalArgumentException);
            client().prepareIndex("test-idx-1").setId(Integer.toString(i)).setSource("foo", "bar" + i).get();
        } catch (RepositoryException e) {
    public void testMissingUri() {
            Settings.Builder settings = Settings.builder().put("uri", "hdfs:///");
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
        assertThat(count(client, "test-idx-2"), equalTo(100L));
            .prepareRestoreSnapshot("test-repo", "test-snap")
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
        } catch (RepositoryException e) {
        ensureGreen();
        logger.info("--> restore one index after deletion");
            OpenSearchIntegTestCase.putRepository(client().admin().cluster(), "test-repo", "hdfs", settings);
            client.prepareDelete("test-idx-1", Integer.toString(i)).get();
    private long count(Client client, String index) {
            client().prepareIndex("test-idx-2").setId(Integer.toString(i)).setSource("foo", "bar" + i).get();
            assertTrue(e.getCause() instanceof IllegalArgumentException);
 * You may obtain a copy of the License at
            .setWaitForCompletion(true)
        restoreSnapshotResponse = client.admin()
    public void testMissingPath() {
public class HdfsTests extends OpenSearchSingleNodeTestCase {
/*
 * license agreements. See the NOTICE file distributed with
            fail();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            .get();
    }
 * SPDX-License-Identifier: Apache-2.0
        }
        try {
 * Unless required by applicable law or agreed to in writing,
        ensureGreen();
        BlobStoreTestUtil.assertConsistency(repo, repo.threadPool().executor(ThreadPool.Names.GENERIC));
 * under the License.
        );
 * specific language governing permissions and limitations
        client().admin().indices().prepareRefresh().get();
import org.opensearch.snapshots.SnapshotState;
        try {
            OpenSearchIntegTestCase.putRepository(client().admin().cluster(), "test-repo2", "hdfs", settings);
        logger.info("--> indexing some data");
        RestoreSnapshotResponse restoreSnapshotResponse = client.admin()
            fail();
    }
            .put("path", "foo")
        Client client = client();
            .put("compress", randomBoolean());
        try {
}
        try {
            fail();
        Settings.Builder settings = Settings.builder()
        client.admin().indices().prepareClose("test-idx-1", "test-idx-2").get();
            .setIndices("test-idx-*", "-test-idx-3")
            .setWaitForCompletion(true)
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to
            client.prepareDelete("test-idx-3", Integer.toString(i)).get();
        for (int i = 0; i < 50; i++) {
        assertThat(count(client, "test-idx-1"), equalTo(100L));
        assertThat(count(client, "test-idx-2"), equalTo(50L));
            OpenSearchIntegTestCase.putRepository(client().admin().cluster(), "test-repo", "hdfs", settings);
        }
        logger.info("--> delete indices");
            client.admin().cluster().prepareGetSnapshots("test-repo").setSnapshots("test-snap").get().getSnapshots().get(0).state(),
import org.opensearch.transport.client.Client;
        assertThat(count(client, "test-idx-3"), equalTo(50L));
@ThreadLeakFilters(filters = { HdfsClientThreadLeakFilter.class })
    }
            .actionGet();
            equalTo(SnapshotState.SUCCESS)
 * KIND, either express or implied.  See the License for the
        } catch (RepositoryException e) {
            .setWaitForCompletion(true)
            OpenSearchIntegTestCase.putRepository(client().admin().cluster(), "test-repo3", "hdfs", settings);
 * compatible open source license.
    public void testSimpleWorkflow() {
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        ClusterState clusterState = client.admin().cluster().prepareState().get().getState();
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        client().admin().indices().prepareDelete("test-idx-1", "test-idx-2").get();
/*
        assertThat(count(client, "test-idx-1"), equalTo(100L));
        createIndex("test-idx-2");
package org.opensearch.repositories.hdfs;
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
            client.prepareDelete("test-idx-2", Integer.toString(i)).get();
            .execute()
 *
 * Modifications Copyright OpenSearch Contributors. See
        }
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
        return client.prepareSearch(index).setSize(0).get().getHits().getTotalHits().value();
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        try {
 * ownership. Elasticsearch licenses this file to you under
            .cluster()
        assertThat(count(client, "test-idx-1"), equalTo(50L));
 *
    public void testEmptyUri() {
        assertThat(count(client, "test-idx-3"), equalTo(100L));
            assertTrue(e.getCause().getMessage(), e.getCause().getMessage().contains("Invalid scheme [null] specified in uri [/path]"));
            .actionGet();
/*
import org.opensearch.cluster.ClusterState;
        assertThat(
        }
        assertThat(count(client, "test-idx-2"), equalTo(100L));
 * not use this file except in compliance with the License.
        assertThat(
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        return pluginList(HdfsPlugin.class);
        assertThat(count(client, "test-idx-1"), equalTo(100L));
        logger.info("--> snapshot");
            .cluster()
    public void testPathSpecifiedInHdfs() {
        }
        }
            Settings.Builder settings = Settings.builder().put("uri", "/path");
    }
    }
