        createRepository("repository", CountingMockRepositoryPlugin.TYPE);
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
package org.opensearch.snapshots;
            );
        GetSnapshotsResponse getSnapshotsResponse = client().admin()
 * ownership. Elasticsearch licenses this file to you under
            client().prepareIndex("others").setSource("rank", 4),
import java.util.concurrent.ConcurrentHashMap;
            final RepositoryMetadata metadata,
import org.opensearch.repositories.RepositoryData;
        assertThat(getSnapshotsResponse.getSnapshots(), hasSize(1));
            .cluster()
 * This class tests whether global and index metadata are only loaded from the repository when needed.
        if (times == 0) {
            .cluster()
        assertIndexMetadataLoads("snap", "docs", 0);
 *
        assertGlobalMetadataLoads("snap", 0);
        RestoreSnapshotResponse restoreSnapshotResponse = client().admin()
            .addSnapshots("snap")
            .prepareSnapshotStatus("repository")
import java.util.Collection;
        // counts the number of times metadata are loaded
            .setIncludeGlobalState(true)
        // Restoring a snapshot with selective indices loads only required index metadata
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            .setIndices("docs")
            return super.getSnapshotIndexMetaData(PlainActionFuture.get(this::getRepositoryData), snapshotId, indexId);
        assertIndexMetadataLoads("snap", "docs", 3);
        public Metadata getSnapshotGlobalMetadata(SnapshotId snapshotId) {
            client().prepareIndex("others").setSource("rank", 5)
public class MetadataLoadingDuringSnapshotRestoreIT extends AbstractSnapshotIntegTestCase {
        assertGlobalMetadataLoads("snap", 0);
 */
 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.opensearch.env.Environment;
    private void assertIndexMetadataLoads(final String snapshot, final String index, final int times) {
    }
        }
        }
        assertIndexMetadataLoads("snap", "others", 3);
            .setSnapshots("snap")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            Environment env,
 * compatible open source license.
    }
            client().prepareIndex("docs").setId("1").setSource("rank", 1),
        public IndexMetadata getSnapshotIndexMetaData(RepositoryData repositoryData, SnapshotId snapshotId, IndexId indexId)
        RepositoriesService repositoriesService = internalCluster().getInstance(RepositoriesService.class, clusterManager);
 * The OpenSearch Contributors require contributions made to
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
            .get();
            client().prepareIndex("docs").setId("3").setSource("rank", 3),
        assertGlobalMetadataLoads("snap", 1);
        assertAcked(client().admin().indices().prepareDelete("docs", "others"));
/*
 * under the License.
            final NamedXContentRegistry namedXContentRegistry,
        assertAcked(client().admin().indices().prepareDelete("docs"));
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            indicesMetadata.computeIfAbsent(key(snapshotId.getName(), indexId.getName()), (s) -> new AtomicInteger(0)).incrementAndGet();
    public static class CountingMockRepositoryPlugin extends MockRepository.Plugin {
 * Modifications Copyright OpenSearch Contributors. See
    }
 * not use this file except in compliance with the License.
        assertIndexMetadataLoads("snap", "docs", 2);
import static org.hamcrest.Matchers.equalTo;
            assertThat("Index metadata for " + key + " must have been loaded " + times + " times", count.get(), equalTo(times));
        assertThat(restoreSnapshotResponse.getRestoreInfo().status(), equalTo(RestStatus.OK));
    /** A mocked repository that counts the number of times global/index metadata are accessed **/
    private static String key(final String snapshot, final String index) {
        final Map<String, AtomicInteger> indicesMetadata = new ConcurrentHashMap<>();
 * Licensed to Elasticsearch under one or more contributor
    }
import org.opensearch.cluster.service.ClusterService;
            return Collections.singletonMap(
    public void testWhenMetadataAreLoaded() throws Exception {
            .cluster()
            .prepareGetSnapshots("repository")
    private void assertGlobalMetadataLoads(final String snapshot, final int times) {
        final Map<String, AtomicInteger> globalMetadata = new ConcurrentHashMap<>();
        assertGlobalMetadataLoads("snap", 1);
        final String key = key(snapshot, index);
 * You may obtain a copy of the License at
        assertIndexMetadataLoads("snap", "docs", 0);
            .setWaitForCompletion(true)
        assertGlobalMetadataLoads("snap", 0);
import static org.hamcrest.Matchers.nullValue;
    @Override
    private CountingMockRepository getCountingMockRepository() {
        ) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        ) {
            assertThat("Global metadata for " + snapshot + " must have been loaded " + times + " times", count.get(), equalTo(times));
            .get();
import org.opensearch.plugins.Plugin;
import java.io.IOException;
        assertThat(restoreSnapshotResponse.getRestoreInfo().status(), equalTo(RestStatus.OK));
        CreateSnapshotResponse createSnapshotResponse = client().admin()
        restoreSnapshotResponse = client().admin()
            .prepareRestoreSnapshot("repository", "snap")
import org.opensearch.repositories.RepositoriesService;
        @Override
            NamedXContentRegistry namedXContentRegistry,
            .cluster()
            throws IOException {
            RecoverySettings recoverySettings
                metadata -> new CountingMockRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings)
            .get();
        /// This test uses a snapshot/restore plugin implementation that
        return snapshot + ":" + index;
        AtomicInteger count = getCountingMockRepository().globalMetadata.get(snapshot);
    }
        // Restoring a snapshot including the global state loads it with the index metadata
            .setWaitForCompletion(true)
            RecoverySettings recoverySettings
        } else {
        assertIndexMetadataLoads("snap", "others", 3);
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
        assertIndexMetadataLoads("snap", "docs", 4);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.support.PlainActionFuture;
 * specific language governing permissions and limitations
        if (times == 0) {
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        assertThat(createSnapshotResponse.getSnapshotInfo().failedShards(), equalTo(0));
import java.util.Map;
        }
        assertIndexMetadataLoads("snap", "others", 2);
        // Creating a snapshot does not load any metadata
            assertThat("Global metadata for " + snapshot + " must not have been loaded", count, nullValue());
 *
import org.opensearch.repositories.IndexId;
            .cluster()
import org.opensearch.cluster.metadata.IndexMetadata;
            .prepareRestoreSnapshot("repository", "snap")
            .get();
        @Override
 * GitHub history for details.
        String clusterManager = internalCluster().getClusterManagerName();
            .cluster()
 * this work for additional information regarding copyright
            .prepareCreateSnapshot("repository", "snap")
        assertAcked(client().admin().cluster().prepareDeleteSnapshot("repository", "snap").get());
        assertIndexMetadataLoads("snap", "docs", 4);
            .get();
            assertThat("Index metadata for " + key + " must not have been loaded", count, nullValue());
        assertIndexMetadataLoads("snap", "others", 0);
            final Environment environment,
        );
            super(metadata, environment, namedXContentRegistry, clusterService, recoverySettings);
            .setWaitForCompletion(true)
        assertGlobalMetadataLoads("snap", 0);
 * SPDX-License-Identifier: Apache-2.0
        assertThat(snapshotStatusResponse.getSnapshots(), hasSize(1));
        restoreSnapshotResponse = client().admin()
        SnapshotsStatusResponse snapshotStatusResponse = client().admin()
            ClusterService clusterService,
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        Repository repository = repositoriesService.repository("repository");
import static org.hamcrest.Matchers.instanceOf;
            client().prepareIndex("docs").setId("2").setSource("rank", 2),
        return Collections.singletonList(CountingMockRepositoryPlugin.class);
import org.opensearch.core.rest.RestStatus;
            return super.getSnapshotGlobalMetadata(snapshotId);
    /** Compute a map key for the given snapshot and index names **/
}
            .setVerbose(randomBoolean())
 */
        assertIndexMetadataLoads("snap", "docs", 1);
/*
 * KIND, either express or implied.  See the License for the
    }
        // Getting the status of a snapshot loads indices metadata but not global metadata
        return (CountingMockRepository) repository;
    public static class CountingMockRepository extends MockRepository {
 *
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
        assertIndexMetadataLoads("snap", "others", 2);
import org.opensearch.snapshots.mockstore.MockRepository;
        createIndex("docs");
        }
 * software distributed under the License is distributed on an
import org.opensearch.repositories.Repository;
        // Deleting a snapshot does not load the global metadata state but loads each index metadata
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
 * this file be licensed under the Apache-2.0 license or a
        assertIndexMetadataLoads("snap", "others", 0);
            .get();
 * license agreements. See the NOTICE file distributed with
        // Restoring a snapshot loads indices metadata but not the global state
        // Getting a snapshot does not load any metadata
        assertThat(createSnapshotResponse.getSnapshotInfo().status(), equalTo(RestStatus.OK));
        public CountingMockRepository(
    /** A plugin that uses CountingMockRepository as implementation of the Repository **/
        }
        } else {
            .setIndices("docs", "oth*")
import java.util.concurrent.atomic.AtomicInteger;
            .setRestoreGlobalState(true)
        AtomicInteger count = getCountingMockRepository().indicesMetadata.get(key);
            globalMetadata.computeIfAbsent(snapshotId.getName(), (s) -> new AtomicInteger(0)).incrementAndGet();
            true,
import java.util.Collections;
import org.opensearch.cluster.metadata.Metadata;
        assertThat(repository, instanceOf(CountingMockRepository.class));
import org.opensearch.indices.recovery.RecoverySettings;
        public static final String TYPE = "countingmock";
        assertAcked(client().admin().indices().prepareDelete("docs", "others"));
        assertGlobalMetadataLoads("snap", 0);
/**
        assertIndexMetadataLoads("snap", "others", 1);
                TYPE,
/*
        indexRandom(
            .setWaitForCompletion(true)
import static org.hamcrest.Matchers.hasSize;
            .prepareRestoreSnapshot("repository", "snap")
        @Override
*/
        assertThat(restoreSnapshotResponse.getRestoreInfo().status(), equalTo(RestStatus.OK));
 */
        public Map<String, Repository.Factory> getRepositories(
    }
            ClusterService clusterService,
