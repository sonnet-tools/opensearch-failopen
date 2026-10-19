 * exist on disc.
import java.util.stream.Collectors;
                IndexShardSnapshotFailedException.class,
import org.opensearch.index.engine.EngineConfigFactory;
            // check that the shard is not corrupted
                if (rarely()) {
 * You may obtain a copy of the License at  
        return repository;
    /** Create a {@link Environment} with random path.home and path.repo **/
import org.opensearch.snapshots.Snapshot;
import org.opensearch.index.store.StoreFileMetadata;
            if (shard != null && shard.state() != IndexShardState.CLOSED) {
    }
            final Directory directory = shard.store().directory();
 * under the License.  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
                    new SnapshotInfo(
            );
 * software distributed under the License is distributed on an
            final Repository repository = createRepository();
import org.opensearch.repositories.Repository;
     * some files already exist in the shard's store.
        repository.start();
                shard.indexSettings().getIndexMetadata(),
 * The OpenSearch Contributors require contributions made to  
                        0
            // build a new shard using the same store directory as the closed shard  
        final ShardId shardId = new ShardId(indexId.getName(), indexId.getId(), 0);
            final int numDocs = scaledRandomIntBetween(1, 500);
 *
            }  
import java.nio.file.Files;
 * SPDX-License-Identifier: Apache-2.0
            final int numDocs = scaledRandomIntBetween(1, 500);
 * GitHub history for details.
                assertEquals(storeFile.length(), shard.store().directory().fileLength(fileName));
                    shard.close("test", false, false);  
            @Override
            final String shardGen = snapshotShard(shard, snapshot, repository);
 */  
import org.opensearch.cluster.metadata.Metadata;
                () -> snapshotShard(shard, snapshotWithSameName, repository)  
                }  
 * This class tests the behavior of {@link BlobStoreRepository} when it  
    public void testRestoreSnapshotWithExistingFiles() throws IOException {
                RetentionLeaseSyncer.EMPTY,
    /**  
            closeShards(shard);
     */  
            final Snapshot snapshot = new Snapshot(repository.getMetadata().name(), new SnapshotId(randomAlphaOfLength(10), "_uuid"));
 */
                        snapshot.getSnapshotId(),  
            Settings.builder()  
                    flushShard(shard, false);  
            createEnvironment(),  
import java.nio.file.Path;
                EMPTY_EVENT_LISTENER,  
        );
 */  
                if (rarely()) {  
import org.opensearch.common.util.io.IOUtils;  
 */  
                    flushShard(shard, false);
 *  
                repository.getMetadata().name(),
                () -> {},
                null,
                        null,
                )
import java.util.Arrays;  
import org.opensearch.indices.recovery.RecoverySettings;
 * the Apache License, Version 2.0 (the "License"); you may
            recoverShardFromStore(shard);  
            snapshotShard(shard, snapshot, repository);  
        final ClusterService clusterService = BlobStoreTestUtil.mockClusterService(repositoryMetadata);  
import org.opensearch.index.shard.IndexShardTestCase;
            IndexShardSnapshotFailedException isfe = expectThrows(
import static org.hamcrest.Matchers.containsString;  
import org.opensearch.snapshots.SnapshotId;  
                .put(Environment.PATH_HOME_SETTING.getKey(), home.toAbsolutePath())
                        Collections.emptyList(),
                        false,
            // capture current store files
                    Version.CURRENT,
import org.opensearch.cluster.metadata.RepositoryMetadata;  
     * Restoring a snapshot that contains multiple files must succeed even when
            );
public class BlobStoreRepositoryRestoreTests extends IndexShardTestCase {
            if (shard != null && shard.state() != IndexShardState.CLOSED) {
            // close the shard  
                } finally {
            PlainActionFuture.<RepositoryData, Exception>get(  
        final FsRepository repository = new FsRepository(
import org.opensearch.index.seqno.RetentionLeaseSyncer;
 * Modifications Copyright OpenSearch Contributors. See
 *
                }
            // snapshot the shard  
            protected void assertSnapshotOrGenericThread() {  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.index.shard.ShardId;
            }  
    }  
            final Snapshot snapshotWithSameName = new Snapshot(
import org.opensearch.repositories.IndexId;  
import org.opensearch.repositories.fs.FsRepository;
                    IOUtils.close(shard.store());  
            final List<String> directoryFiles = Arrays.asList(directory.listAll());  
                        1L,
            // restore the shard
            assertDocCount(shard, numDocs);
 * KIND, either express or implied.  See the License for the
            }
 * this work for additional information regarding copyright
/**
            }
            xContentRegistry(),
import java.util.function.Function;  
            );
        final IndexId indexId = new IndexId(randomAlphaOfLength(10), UUIDs.randomBase64UUID());
                    shardGenerations,
                    IOUtils.close(shard.store());
                f -> repository.finalizeSnapshot(
            final Store.MetadataSnapshot storeFiles = shard.snapshotStoreMetadata();  
            final ShardGenerations shardGenerations = ShardGenerations.builder().put(indexId, 0, shardGen).build();
            // check that all files have been restored
            assertDocCount(shard, numDocs);  
                    shard.close("test", false, false);
    }  
                // eliminate thread name check as we create repo manually
                    ),  
            for (int i = 0; i < numDocs; i++) {  
import org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException;
            recoverShardFromStore(shard);
import org.opensearch.env.Environment;  
            List<String> deletedFiles = randomSubsetOf(randomIntBetween(1, storeFiles.size() - 1), storeFiles.asMap().keySet());
import org.opensearch.repositories.ShardGenerations;  
        } finally {  
            // index documents in the shards  
                try {  
}  
import org.opensearch.cluster.service.ClusterService;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.Priority;
        ) {
                } finally {
                RecoverySource.ExistingStoreRecoverySource.INSTANCE  
 * not use this file except in compliance with the License.
import org.opensearch.common.UUIDs;  
    private Environment createEnvironment() {  
        }  
                }
        };  
            for (int i = 0; i < numDocs; i++) {
    private Repository createRepository() {  
                        shardGenerations.indices().stream().map(IndexId::getName).collect(Collectors.toList()),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        Collections.emptyList(),
        Path home = createTempDir();
import org.opensearch.cluster.routing.ShardRoutingHelper;  
                null
                try {
import org.opensearch.repositories.RepositoryData;
import org.opensearch.common.settings.Settings;
            ShardRouting shardRouting = ShardRoutingHelper.initWithSameId(
 * specific language governing permissions and limitations
            // index documents in the shards
import org.opensearch.env.TestEnvironment;
 * compatible open source license.
import java.util.List;
            // snapshot the shard
import org.opensearch.common.settings.ClusterSettings;
            }
/*  
import org.opensearch.index.store.Store;  
                new EngineBackedIndexerFactory(new InternalEngineFactory()),
import org.opensearch.action.support.PlainActionFuture;
                        Collections.emptyMap(),  
import org.opensearch.cluster.routing.RecoverySource;
                    Metadata.builder().put(shard.indexSettings().getIndexMetadata(), false).build(),
    /** Create a {@link Repository} with a random name **/
                    Priority.NORMAL,  
    public void testSnapshotWithConflictingName() throws Exception {  
            assertThat(isfe.getMessage(), containsString("Duplicate snapshot name"));
                .build()  
        // Apply state once to initialize repo properly like RepositoriesService would
                indexDoc(shard, "_doc", Integer.toString(i));
                    Function.identity(),
import org.opensearch.snapshots.SnapshotInfo;
                new SnapshotId(snapshot.getSnapshotId().getName(), "_uuid2")  
                String fileName = storeFile.name();  
            final Repository repository = createRepository();  
            for (StoreFileMetadata storeFile : storeFiles) {
import org.opensearch.cluster.routing.ShardRouting;
            recoverShardFromSnapshot(shard, snapshot, repository);
        }
                        true,
                shard.shardPath(),
                    RepositoryData.EMPTY_REPO_GEN,  
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))  
import java.io.IOException;  
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata(randomAlphaOfLength(10), FsRepository.TYPE, settings);
                indexDoc(shard, "_doc", Integer.toString(i));
            );  
import org.opensearch.index.engine.InternalEngineFactory;  
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.store.Directory;
import org.opensearch.index.shard.IndexShard;  
            // delete some random files in the store  
/*  
            final Snapshot snapshot = new Snapshot(repository.getMetadata().name(), new SnapshotId(randomAlphaOfLength(10), "_uuid"));
                new EngineConfigFactory(shard.indexSettings()),  
                Files.delete(shard.shardPath().resolveIndex().resolve(deletedFile));  
import java.util.Collections;
        IndexShard shard = newShard(shardId, true);
            }
import org.opensearch.index.shard.IndexShardState;
        clusterService.addStateApplier(event -> repository.updateState(event.state()));
            assertFalse(storeFiles.asMap().isEmpty());
import org.opensearch.Version;  
 * license agreements. See the NOTICE file distributed with
                assertTrue("File [" + fileName + "] does not exist in store directory", directoryFiles.contains(fileName));
                        0L,  
            TestUtil.checkIndex(shard.store().directory());
            clusterService,
                    f
                null,  
                        6,  
    }
            repositoryMetadata,
        IndexShard shard = newShard(shardId, true);
        Settings settings = Settings.builder().put("location", randomAlphaOfLength(10)).build();
        try {
            assertNotNull(shardGen);  
        try {  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
            for (String deletedFile : deletedFiles) {
        final IndexId indexId = new IndexId(randomAlphaOfLength(10), UUIDs.randomBase64UUID());
        repository.updateState(clusterService.state());  
                .put(Environment.PATH_REPO_SETTING.getKey(), home.resolve("repo").toAbsolutePath())
            shard = newShard(
        final ShardId shardId = new ShardId(indexId.getName(), indexId.getId(), 0);  
import org.apache.lucene.tests.util.TestUtil;
        } finally {
            }
 * restores a shard from a snapshot but some files with same names already
 * ownership. Elasticsearch licenses this file to you under  
            );
                }
                shard.routingEntry(),
        return TestEnvironment.newEnvironment(
package org.opensearch.repositories.blobstore;
                shardRouting,  
