    }  
        @Override
            return Collections.singletonMap(
 * the Apache License, Version 2.0 (the "License"); you may
 *
            .setWaitForCompletion(true)  
            .setVerbose(randomBoolean())
import org.opensearch.env.Environment;  
            client().prepareIndex("docs").setId("2").setSource("rank", 2),  
        // Deleting a snapshot does not load the global metadata state but loads each index metadata
        RestoreSnapshotResponse restoreSnapshotResponse = client().admin()
        assertIndexMetadataLoads("snap", "docs", 4);
        assertIndexMetadataLoads("snap", "others", 3);  
    private void assertGlobalMetadataLoads(final String snapshot, final int times) {  
    }
            .prepareRestoreSnapshot("repository", "snap")  
    @Override  
                metadata -> new CountingMockRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings)
            .get();  
    }  
            assertThat("Index metadata for " + key + " must not have been loaded", count, nullValue());
    }
        public static final String TYPE = "countingmock";
        assertGlobalMetadataLoads("snap", 0);
        public Metadata getSnapshotGlobalMetadata(SnapshotId snapshotId) {
        SnapshotsStatusResponse snapshotStatusResponse = client().admin()
            .get();
        String clusterManager = internalCluster().getClusterManagerName();
            .setWaitForCompletion(true)
            client().prepareIndex("docs").setId("1").setSource("rank", 1),
        CreateSnapshotResponse createSnapshotResponse = client().admin()  
import org.opensearch.repositories.RepositoriesService;
        indexRandom(  
        assertIndexMetadataLoads("snap", "docs", 0);  
import java.util.concurrent.atomic.AtomicInteger;
        @Override  
        assertIndexMetadataLoads("snap", "others", 0);
        // Restoring a snapshot with selective indices loads only required index metadata  
        assertThat(restoreSnapshotResponse.getRestoreInfo().status(), equalTo(RestStatus.OK));
 *  
        assertIndexMetadataLoads("snap", "others", 0);
        assertGlobalMetadataLoads("snap", 1);
        );
            .cluster()
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;  
    public static class CountingMockRepositoryPlugin extends MockRepository.Plugin {  
        assertThat(restoreSnapshotResponse.getRestoreInfo().status(), equalTo(RestStatus.OK));  
            ClusterService clusterService,
            .cluster()
            .setSnapshots("snap")
    }
 * Licensed to Elasticsearch under one or more contributor  
        final Map<String, AtomicInteger> globalMetadata = new ConcurrentHashMap<>();
        // Restoring a snapshot loads indices metadata but not the global state
            ClusterService clusterService,  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
import java.util.Collections;
            client().prepareIndex("docs").setId("3").setSource("rank", 3),
        public IndexMetadata getSnapshotIndexMetaData(RepositoryData repositoryData, SnapshotId snapshotId, IndexId indexId)
        // Getting the status of a snapshot loads indices metadata but not global metadata  
            .setWaitForCompletion(true)
 * This class tests whether global and index metadata are only loaded from the repository when needed.
            Environment env,  
        // counts the number of times metadata are loaded  
 */  
 * The OpenSearch Contributors require contributions made to  
            indicesMetadata.computeIfAbsent(key(snapshotId.getName(), indexId.getName()), (s) -> new AtomicInteger(0)).incrementAndGet();  
        }  
import java.util.Collection;
import org.opensearch.cluster.metadata.RepositoryMetadata;
        ) {
            super(metadata, environment, namedXContentRegistry, clusterService, recoverySettings);  
 */  
        assertIndexMetadataLoads("snap", "docs", 0);  
 * this file be licensed under the Apache-2.0 license or a
            return super.getSnapshotGlobalMetadata(snapshotId);  
        assertIndexMetadataLoads("snap", "docs", 3);
        assertGlobalMetadataLoads("snap", 0);
        /// This test uses a snapshot/restore plugin implementation that
    }
            .setWaitForCompletion(true)
        assertThat(restoreSnapshotResponse.getRestoreInfo().status(), equalTo(RestStatus.OK));
            .addSnapshots("snap")
        // Creating a snapshot does not load any metadata
 * Unless required by applicable law or agreed to in writing,
    private static String key(final String snapshot, final String index) {
        // Getting a snapshot does not load any metadata  
        return Collections.singletonList(CountingMockRepositoryPlugin.class);
        createIndex("docs");
            client().prepareIndex("others").setSource("rank", 4),
package org.opensearch.snapshots;
        assertThat(repository, instanceOf(CountingMockRepository.class));
            .setRestoreGlobalState(true)
import org.opensearch.repositories.Repository;
    }
        assertIndexMetadataLoads("snap", "others", 1);  
        assertThat(snapshotStatusResponse.getSnapshots(), hasSize(1));  
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.equalTo;
 * not use this file except in compliance with the License.
        assertAcked(client().admin().indices().prepareDelete("docs", "others"));
            client().prepareIndex("others").setSource("rank", 5)  
            .cluster()
        AtomicInteger count = getCountingMockRepository().globalMetadata.get(snapshot);
            .get();
            final Environment environment,
        assertAcked(client().admin().indices().prepareDelete("docs", "others"));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        public CountingMockRepository(
        public Map<String, Repository.Factory> getRepositories(
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.repositories.RepositoryData;  
 * this work for additional information regarding copyright
    public void testWhenMetadataAreLoaded() throws Exception {
            assertThat("Global metadata for " + snapshot + " must not have been loaded", count, nullValue());  
            .get();  
            globalMetadata.computeIfAbsent(snapshotId.getName(), (s) -> new AtomicInteger(0)).incrementAndGet();
 * You may obtain a copy of the License at  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            .prepareSnapshotStatus("repository")  
 *
        }
    public static class CountingMockRepository extends MockRepository {  
            .cluster()  
import org.opensearch.cluster.metadata.Metadata;
        AtomicInteger count = getCountingMockRepository().indicesMetadata.get(key);
/*  
        assertGlobalMetadataLoads("snap", 1);
                TYPE,  
        assertAcked(client().admin().indices().prepareDelete("docs"));
            .prepareGetSnapshots("repository")  
public class MetadataLoadingDuringSnapshotRestoreIT extends AbstractSnapshotIntegTestCase {
 * KIND, either express or implied.  See the License for the
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
        assertGlobalMetadataLoads("snap", 0);  
        assertThat(createSnapshotResponse.getSnapshotInfo().failedShards(), equalTo(0));  
import java.util.Map;  
    }
import org.opensearch.cluster.metadata.IndexMetadata;  
        }
    /** Compute a map key for the given snapshot and index names **/  
        }
        assertThat(getSnapshotsResponse.getSnapshots(), hasSize(1));
        } else {
        return (CountingMockRepository) repository;  
        assertGlobalMetadataLoads("snap", 0);
    /** A mocked repository that counts the number of times global/index metadata are accessed **/
        assertIndexMetadataLoads("snap", "others", 3);  
        @Override  
        ) {
            .cluster()
        assertIndexMetadataLoads("snap", "docs", 4);
import org.opensearch.core.rest.RestStatus;
*/  
 * compatible open source license.
    private CountingMockRepository getCountingMockRepository() {
/*  
            .setIndices("docs")
/*
        if (times == 0) {
import org.opensearch.indices.recovery.RecoverySettings;
            .prepareRestoreSnapshot("repository", "snap")  
            assertThat("Global metadata for " + snapshot + " must have been loaded " + times + " times", count.get(), equalTo(times));
        RepositoriesService repositoriesService = internalCluster().getInstance(RepositoriesService.class, clusterManager);  
            .setIncludeGlobalState(true)  
import org.opensearch.cluster.service.ClusterService;  
        restoreSnapshotResponse = client().admin()
            .get();
        assertGlobalMetadataLoads("snap", 0);  
 * specific language governing permissions and limitations
}
        Repository repository = repositoriesService.repository("repository");
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.NamedXContentRegistry;
        GetSnapshotsResponse getSnapshotsResponse = client().admin()
 * license agreements. See the NOTICE file distributed with
            .prepareRestoreSnapshot("repository", "snap")
            NamedXContentRegistry namedXContentRegistry,
            .get();  
import java.io.IOException;  
        assertIndexMetadataLoads("snap", "docs", 1);
        } else {
import java.util.concurrent.ConcurrentHashMap;
 *    http://www.apache.org/licenses/LICENSE-2.0
            true,
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(createSnapshotResponse.getSnapshotInfo().status(), equalTo(RestStatus.OK));
import static org.hamcrest.Matchers.instanceOf;
            .cluster()
            RecoverySettings recoverySettings
        // Restoring a snapshot including the global state loads it with the index metadata  
 */
            throws IOException {
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
 * under the License.  
            );
import org.opensearch.repositories.IndexId;  
import org.opensearch.plugins.Plugin;
        return snapshot + ":" + index;
/**
            .prepareCreateSnapshot("repository", "snap")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        }  
        }
        assertIndexMetadataLoads("snap", "docs", 2);
            RecoverySettings recoverySettings  
        assertIndexMetadataLoads("snap", "others", 2);
    private void assertIndexMetadataLoads(final String snapshot, final String index, final int times) {  
        createRepository("repository", CountingMockRepositoryPlugin.TYPE);  
        final Map<String, AtomicInteger> indicesMetadata = new ConcurrentHashMap<>();  
            final RepositoryMetadata metadata,  
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
        restoreSnapshotResponse = client().admin()
import static org.hamcrest.Matchers.hasSize;  
import org.opensearch.snapshots.mockstore.MockRepository;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (times == 0) {  
 * SPDX-License-Identifier: Apache-2.0
            assertThat("Index metadata for " + key + " must have been loaded " + times + " times", count.get(), equalTo(times));  
        final String key = key(snapshot, index);
            .setIndices("docs", "oth*")
 * GitHub history for details.
    /** A plugin that uses CountingMockRepository as implementation of the Repository **/
        assertIndexMetadataLoads("snap", "others", 2);
            final NamedXContentRegistry namedXContentRegistry,
        assertAcked(client().admin().cluster().prepareDeleteSnapshot("repository", "snap").get());  
import static org.hamcrest.Matchers.nullValue;
            return super.getSnapshotIndexMetaData(PlainActionFuture.get(this::getRepositoryData), snapshotId, indexId);
