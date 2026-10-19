        final RepositoryMetadata updatedRepositoryMetadata = updatedGetRepositoriesResponse.repositories().get(0);
            repositoryName,
            assertThat(remoteUploadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
            client().admin().cluster(),  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        Path path = randomRepoPath();
import org.opensearch.common.settings.Settings;
            client().admin().cluster(),  
        }  
import static org.hamcrest.Matchers.containsString;  
        final String repositoryName = "test-repo";
        // create repository
            .iterator()
        assertThat(updatedGetRepositoriesResponse.repositories(), hasSize(1));  
import org.opensearch.cluster.metadata.RepositoryMetadata;  
                .put("io_buffer_size", "8mb")
        assertThat(remoteUploadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
 *
        assertThat(remoteDownloadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));  
            repoSettings
            client().admin().cluster(),
                repoSettings
        {  
            assertThat(newRepository, sameInstance(repository));
        final GetRepositoriesResponse originalGetRepositoriesResponse = client.admin()
        final RepositoriesService repositoriesService = cluster.getDataOrClusterManagerNodeInstances(RepositoriesService.class)  
            repoSettings
                repositoryName,
            try {
import static org.opensearch.repositories.blobstore.BlobStoreRepository.MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC;
 */
                .put(MAX_REMOTE_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))
            assertThat(remoteDownloadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
import org.opensearch.test.OpenSearchIntegTestCase;  
 * not use this file except in compliance with the License.
            assertThat(remoteUploadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
                .put("location", path)
        return Collections.singletonList(MockRepository.Plugin.class);  
            } catch (Exception e) {  
import static org.hamcrest.Matchers.equalTo;
import java.util.concurrent.atomic.AtomicInteger;  
        internalCluster();
        } catch (IllegalStateException e) {  
            assertNotEquals(newRepository, repository);  
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(e, hasToString(containsString(("trying to modify or unregister repository that is currently used"))));
        try {
import static org.opensearch.repositories.blobstore.BlobStoreRepository.MAX_RESTORE_BYTES_PER_SEC;
        assertThat(originalRepositoryMetadata.type(), equalTo(FsRepository.TYPE));  
            repositoryName,
            .next();
        );  
            assertThat(remoteUploadLowPriorityRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
        final Settings.Builder repoSettings = Settings.builder().put("system_repository", true).put("location", randomRepoPath());  
            );
        final AtomicInteger snapshotCount = new AtomicInteger();
        assertThat(snapshotRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
import static org.opensearch.repositories.blobstore.BlobStoreRepository.MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC;
            );
                .setWaitForCompletion(true)
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
                true,
/*
                createSnapshot.run();
 * this file be licensed under the Apache-2.0 license or a
        assertThat(restoreRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));  
        createIndex(indexName, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 0).put(SETTING_NUMBER_OF_SHARDS, 1).build());  
        FsRepository repository = (FsRepository) repositoriesService.repository(repositoryName);
import org.opensearch.repositories.fs.FsRepository;  
        );
            restoreRateLimiter = newRepository.restoreRateLimiter();
        RateLimiter restoreRateLimiter = repository.restoreRateLimiter();
        final Repository originalRepository = repositoriesService.repository(repositoryName);
 * GitHub history for details.
        index(indexName, "_doc", "1", Collections.singletonMap("user", generateRandomStringArray(1, 10, false, false)));
                repoSettings  
            remoteUploadLowPriorityRateLimiter = newRepository.remoteUploadLowPriorityRateLimiter();  
                .put(MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC, (rateBytes + "b"));
        });
import static org.hamcrest.Matchers.hasSize;
                .put("location", path)  
            String snapshotName = "snapshot-" + snapshotCount.incrementAndGet();  
            repoSettings = Settings.builder()  
            repoSettings
            .cluster()
public class RepositoriesServiceIT extends OpenSearchIntegTestCase {
        String indexName = "test-index";
                repoSettings
 * Unless required by applicable law or agreed to in writing,
    }
        Thread thread = new Thread(() -> {  
 * specific language governing permissions and limitations
        };  
        final boolean updated = randomBoolean();
        Runnable createSnapshot = () -> {
import java.util.Collection;
            OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
            rateBytes = rateBytes / 2;
            OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
                .setIndices(indexName)  
        assertThat(updatedRepository, updated ? not(sameInstance(originalRepository)) : sameInstance(originalRepository));  
 */  
            .cluster()
        final InternalTestCluster cluster = internalCluster();
 *  
            long newRateBytes = rateBytes / 2;
            .put(MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC, (rateBytes + "b"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final String repositoryName = "test-repo";  
 * compatible open source license.
        );
import org.opensearch.snapshots.mockstore.MockRepository;
import static org.hamcrest.Matchers.instanceOf;
            );
        // snapshot mab be failed when updating repository
            .put("location", path)  
 * license agreements. See the NOTICE file distributed with
            remoteDownloadRateLimiter = newRepository.remoteDownloadRateLimiter();
            client().admin().cluster(),  
        // after updating repository, snapshot should be success
import java.nio.file.Path;  
                .prepareCreateSnapshot(repositoryName, snapshotName)
 * under the License.  
            client().admin()
            logger.info("--> finishing snapshot");
        assertThat(updatedRepositoryMetadata.type(), equalTo(updatedRepositoryType));  
            .prepareGetRepositories(repositoryName)  
            FsRepository.TYPE,
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(  
                FsRepository.TYPE,  
            assertThat(restoreRateLimiter.getMBPerSec(), equalTo((double) newRateBytes / (1024 * 1024)));  
 * this work for additional information regarding copyright
                client().admin().cluster(),  
            .get();
        final Repository updatedRepository = repositoriesService.repository(repositoryName);
    }  
            assertThat(newRepository, sameInstance(repository));
            assertThat(snapshotRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));  
 * software distributed under the License is distributed on an
        RepositoryMetadata originalRepositoryMetadata = originalGetRepositoriesResponse.repositories().get(0);
        RateLimiter remoteUploadLowPriorityRateLimiter = repository.remoteUploadLowPriorityRateLimiter();  
            .put(MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))
        assertThrows(RepositoryException.class, () -> createRepository(repositoryName, FsRepository.TYPE, repoSettings));
    public void testAdjustBytesPerSecSettingForSnapAndRestore() {
            true,  
import java.util.Collections;
        OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(  
        assertThat(originalRepository, instanceOf(FsRepository.class));  
import static org.hamcrest.Matchers.not;
                assertThat(e, instanceOf(RepositoryException.class));
        thread.start();
/*  
                .put(MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))  
        internalCluster();
/*  
    public void testSystemRepositoryCantBeCreated() {  
            assertThat(restoreRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
        // In addition to the settings in RELOADABLE_SETTINGS, all the new settings should be equal to current settings
            repositoryName,
        final RepositoriesService repositoriesService = cluster.getDataOrClusterManagerNodeInstances(RepositoriesService.class)  
 * Modifications Copyright OpenSearch Contributors. See
            repoSettings = Settings.builder()
            .iterator()
            repoSettings = Settings.builder()
            .next();
                .put(MAX_REMOTE_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))
            .put(MAX_REMOTE_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))  
        assertThat(remoteUploadLowPriorityRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
            FsRepository.TYPE,
                client().admin().cluster(),
import static org.opensearch.repositories.blobstore.BlobStoreRepository.MAX_SNAPSHOT_BYTES_PER_SEC;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testCreatSnapAndUpdateReposityCauseInfiniteLoop() throws InterruptedException {
            snapshotRateLimiter = newRepository.snapshotRateLimiter();
        OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
import org.opensearch.test.InternalTestCluster;
        OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
 */  
                true,
            true,
    }
                .put(MAX_SNAPSHOT_BYTES_PER_SEC, (newRateBytes + "b"))
            FsRepository.TYPE,  
            .put(MAX_SNAPSHOT_BYTES_PER_SEC, (rateBytes + "b"))
            assertThat(snapshotRateLimiter.getMBPerSec(), equalTo((double) newRateBytes / (1024 * 1024)));
        RateLimiter snapshotRateLimiter = repository.snapshotRateLimiter();  
        // adjust all the reloadable settings
            remoteUploadRateLimiter = newRepository.remoteUploadRateLimiter();
import org.opensearch.transport.client.Client;
                FsRepository.TYPE,
 * SPDX-License-Identifier: Apache-2.0
            logger.info("--> beginning snapshot for " + snapshotName);
            rateBytes = rateBytes / 2;
        final Settings.Builder repoSettings = Settings.builder().put("location", randomRepoPath());
            restoreRateLimiter = newRepository.restoreRateLimiter();
        );
            .put(MAX_RESTORE_BYTES_PER_SEC, "10mb");
 * KIND, either express or implied.  See the License for the
        // the new settings are not all equal to the old settings, so the repository will be not reloaded  
import static org.hamcrest.Matchers.hasToString;  
package org.opensearch.repositories;
    }
        thread.join();
                .put(MAX_RESTORE_BYTES_PER_SEC, (rateBytes + "b"))
            assertThat(remoteUploadLowPriorityRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));  
            repositoryName,
                client().admin().cluster(),
                repositoryName,  
                .put(MAX_RESTORE_BYTES_PER_SEC, (newRateBytes + "b"));
                .put(MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))
                .cluster()  
        // create repository
            .prepareGetRepositories(repositoryName)  
            .put("location", path)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        final String updatedRepositoryType = updated ? "mock" : FsRepository.TYPE;  
        Settings.Builder repoSettings = Settings.builder()
                .put(MAX_RESTORE_BYTES_PER_SEC, (rateBytes + "b"))  
            snapshotRateLimiter = newRepository.snapshotRateLimiter();  
                repositoryName,
            FsRepository newRepository = (FsRepository) repositoriesService.repository(repositoryName);
            FsRepository newRepository = (FsRepository) repositoriesService.repository(repositoryName);
        final InternalTestCluster cluster = internalCluster();
                repositoryName,  
            }  
            OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
        RateLimiter remoteDownloadRateLimiter = repository.remoteDownloadRateLimiter();
            logger.info("--> finish to reset repository");
                .put(MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC, (rateBytes + "b"));  
        Settings.Builder repoSettings = Settings.builder()
                FsRepository.TYPE,
            remoteUploadRateLimiter = newRepository.remoteUploadRateLimiter();  
            true,  
        final String repositoryName = "test-repo1";
        // create index  
    @Override
        final GetRepositoriesResponse updatedGetRepositoriesResponse = client.admin()
            FsRepository newRepository = (FsRepository) repositoriesService.repository(repositoryName);  
        flush(indexName);
            assertThat(remoteDownloadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));  
import static org.hamcrest.Matchers.sameInstance;  
                assertThat(e, hasToString(containsString(("the repository has been changed, try again"))));
            .get();
            repoSettings = Settings.builder().put("location", randomRepoPath()).put(MAX_SNAPSHOT_BYTES_PER_SEC, "300mb");  
 * ownership. Elasticsearch licenses this file to you under  
        RateLimiter remoteUploadRateLimiter = repository.remoteUploadRateLimiter();
import static org.opensearch.repositories.blobstore.BlobStoreRepository.MAX_REMOTE_UPLOAD_BYTES_PER_SEC;  
        }
            logger.info("--> begin to reset repository");
        Path path = randomRepoPath();  
import org.opensearch.plugins.Plugin;
        final Client client = client();
            updatedRepositoryType,
            remoteDownloadRateLimiter = newRepository.remoteDownloadRateLimiter();
        assertThat(originalGetRepositoriesResponse.repositories(), hasSize(1));  
                true,
import org.apache.lucene.store.RateLimiter;
        OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
            true,  
                true,  
 *
    public void testUpdateRepository() {  
    }
                .get();
            remoteUploadLowPriorityRateLimiter = newRepository.remoteUploadLowPriorityRateLimiter();
        {
            .put(MAX_RESTORE_BYTES_PER_SEC, (rateBytes + "b"))
                repoSettings  
        long rateBytes = 200000;  
        final String repositoryName = "test-repo";
}  
                .put(MAX_SNAPSHOT_BYTES_PER_SEC, (rateBytes + "b"))  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
            );  
        {  
            .put(MAX_SNAPSHOT_BYTES_PER_SEC, "10mb")  
                FsRepository.TYPE,
        createSnapshot.run();
                client().admin().cluster(),
            repoSettings
