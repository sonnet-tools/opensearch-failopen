        final RepositoryMetadata updatedRepositoryMetadata = updatedGetRepositoriesResponse.repositories().get(0);
                .put("location", path)
                .setIndices(indexName)
            logger.info("--> beginning snapshot for " + snapshotName);
                .get();
            .prepareGetRepositories(repositoryName)
        } catch (IllegalStateException e) {
                createSnapshot.run();
        }
                .cluster()
                repoSettings
        Settings.Builder repoSettings = Settings.builder()
            true,
                .put(MAX_REMOTE_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))
            OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
            assertThat(remoteDownloadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
        RateLimiter restoreRateLimiter = repository.restoreRateLimiter();
 * this work for additional information regarding copyright
                assertThat(e, instanceOf(RepositoryException.class));
                FsRepository.TYPE,
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.repositories.blobstore.BlobStoreRepository.MAX_REMOTE_UPLOAD_BYTES_PER_SEC;
 * Licensed to Elasticsearch under one or more contributor
            assertThat(e, hasToString(containsString(("trying to modify or unregister repository that is currently used"))));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // In addition to the settings in RELOADABLE_SETTINGS, all the new settings should be equal to current settings
        // create index
        RateLimiter remoteDownloadRateLimiter = repository.remoteDownloadRateLimiter();
            assertThat(snapshotRateLimiter.getMBPerSec(), equalTo((double) newRateBytes / (1024 * 1024)));
        RepositoryMetadata originalRepositoryMetadata = originalGetRepositoriesResponse.repositories().get(0);
        assertThat(originalRepository, instanceOf(FsRepository.class));
        RateLimiter remoteUploadRateLimiter = repository.remoteUploadRateLimiter();
            .put(MAX_REMOTE_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))
            .cluster()
        assertThat(remoteDownloadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
            OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
 * ownership. Elasticsearch licenses this file to you under
        final GetRepositoriesResponse updatedGetRepositoriesResponse = client.admin()
        internalCluster();
            }
                .put(MAX_RESTORE_BYTES_PER_SEC, (newRateBytes + "b"));
                .put(MAX_SNAPSHOT_BYTES_PER_SEC, (rateBytes + "b"))
 * The OpenSearch Contributors require contributions made to
            assertThat(remoteDownloadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
        // create repository
 * KIND, either express or implied.  See the License for the
public class RepositoriesServiceIT extends OpenSearchIntegTestCase {
            true,
    }
            .put(MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))
            .iterator()
            try {
        OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
 */
import static org.hamcrest.Matchers.sameInstance;
            repositoryName,
                .put(MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))
        // adjust all the reloadable settings
        try {
 * You may obtain a copy of the License at
    }
            repoSettings = Settings.builder().put("location", randomRepoPath()).put(MAX_SNAPSHOT_BYTES_PER_SEC, "300mb");
            .cluster()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(updatedGetRepositoriesResponse.repositories(), hasSize(1));
                .put(MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC, (rateBytes + "b"));
            .next();
import java.nio.file.Path;
        {
import org.apache.lucene.store.RateLimiter;
        Path path = randomRepoPath();
 * compatible open source license.
package org.opensearch.repositories;
                repoSettings
        final String updatedRepositoryType = updated ? "mock" : FsRepository.TYPE;
import static org.hamcrest.Matchers.instanceOf;
import static org.opensearch.repositories.blobstore.BlobStoreRepository.MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC;
            snapshotRateLimiter = newRepository.snapshotRateLimiter();
            FsRepository.TYPE,
        Runnable createSnapshot = () -> {
        final InternalTestCluster cluster = internalCluster();
 * not use this file except in compliance with the License.
            logger.info("--> finish to reset repository");
}
            assertThat(remoteUploadLowPriorityRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
            repositoryName,
        // create repository
import static org.hamcrest.Matchers.equalTo;
        thread.join();
            FsRepository.TYPE,
            updatedRepositoryType,
        Path path = randomRepoPath();
            FsRepository newRepository = (FsRepository) repositoriesService.repository(repositoryName);
                true,
            OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
import org.opensearch.test.OpenSearchIntegTestCase;
        OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
import static org.opensearch.repositories.blobstore.BlobStoreRepository.MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC;
            repositoryName,
            assertThat(remoteUploadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
            repoSettings
            client().admin()
        Thread thread = new Thread(() -> {
        createIndex(indexName, Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 0).put(SETTING_NUMBER_OF_SHARDS, 1).build());
import org.opensearch.repositories.fs.FsRepository;
import java.util.Collection;
        FsRepository repository = (FsRepository) repositoriesService.repository(repositoryName);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        final boolean updated = randomBoolean();
                true,
            .prepareGetRepositories(repositoryName)
            snapshotRateLimiter = newRepository.snapshotRateLimiter();
            } catch (Exception e) {
        }
            logger.info("--> begin to reset repository");
            .put("location", path)
                FsRepository.TYPE,
        assertThat(updatedRepositoryMetadata.type(), equalTo(updatedRepositoryType));
            true,
        assertThat(restoreRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
        flush(indexName);
                repositoryName,
            rateBytes = rateBytes / 2;
        {
        );
        // snapshot mab be failed when updating repository
            repoSettings = Settings.builder()
        thread.start();
            .next();
            repoSettings
        final GetRepositoriesResponse originalGetRepositoriesResponse = client.admin()
        assertThat(originalGetRepositoriesResponse.repositories(), hasSize(1));
                .put(MAX_SNAPSHOT_BYTES_PER_SEC, (newRateBytes + "b"))
            client().admin().cluster(),
            logger.info("--> finishing snapshot");
import org.opensearch.common.settings.Settings;
        final String repositoryName = "test-repo1";
        internalCluster();
        String indexName = "test-index";
        );
        long rateBytes = 200000;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.InternalTestCluster;
            assertNotEquals(newRepository, repository);
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
import static org.hamcrest.Matchers.hasSize;
        }
import org.opensearch.plugins.Plugin;
/*
            true,
 *
            remoteDownloadRateLimiter = newRepository.remoteDownloadRateLimiter();
                .setWaitForCompletion(true)
        final AtomicInteger snapshotCount = new AtomicInteger();
        assertThat(snapshotRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
            rateBytes = rateBytes / 2;
 * GitHub history for details.
            );
    public void testCreatSnapAndUpdateReposityCauseInfiniteLoop() throws InterruptedException {
            );
        final Repository originalRepository = repositoriesService.repository(repositoryName);
        RateLimiter snapshotRateLimiter = repository.snapshotRateLimiter();
import static org.hamcrest.Matchers.not;
                true,
            FsRepository.TYPE,
            restoreRateLimiter = newRepository.restoreRateLimiter();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
                repositoryName,
        {
        final Settings.Builder repoSettings = Settings.builder().put("system_repository", true).put("location", randomRepoPath());
                .prepareCreateSnapshot(repositoryName, snapshotName)
                assertThat(e, hasToString(containsString(("the repository has been changed, try again"))));
import static org.hamcrest.Matchers.hasToString;
 * SPDX-License-Identifier: Apache-2.0
        OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
        });
                client().admin().cluster(),
 * software distributed under the License is distributed on an
            client().admin().cluster(),
    public void testUpdateRepository() {
        assertThrows(RepositoryException.class, () -> createRepository(repositoryName, FsRepository.TYPE, repoSettings));
                .put(MAX_RESTORE_BYTES_PER_SEC, (rateBytes + "b"))
        final RepositoriesService repositoriesService = cluster.getDataOrClusterManagerNodeInstances(RepositoriesService.class)
            assertThat(newRepository, sameInstance(repository));
            .put(MAX_RESTORE_BYTES_PER_SEC, "10mb");
            FsRepository newRepository = (FsRepository) repositoriesService.repository(repositoryName);
                repoSettings
                .put(MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC, (rateBytes + "b"));
        final String repositoryName = "test-repo";
/*
                .put(MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))
/*
                repositoryName,
        final String repositoryName = "test-repo";
        final Settings.Builder repoSettings = Settings.builder().put("location", randomRepoPath());
            );
                FsRepository.TYPE,
 *    http://www.apache.org/licenses/LICENSE-2.0
        RateLimiter remoteUploadLowPriorityRateLimiter = repository.remoteUploadLowPriorityRateLimiter();
        final Repository updatedRepository = repositoriesService.repository(repositoryName);
            remoteUploadRateLimiter = newRepository.remoteUploadRateLimiter();
        // after updating repository, snapshot should be success
import static org.opensearch.repositories.blobstore.BlobStoreRepository.MAX_SNAPSHOT_BYTES_PER_SEC;
        };
        );
        Settings.Builder repoSettings = Settings.builder()
        assertThat(remoteUploadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
        assertThat(updatedRepository, updated ? not(sameInstance(originalRepository)) : sameInstance(originalRepository));
    @Override
        final String repositoryName = "test-repo";
        assertThat(originalRepositoryMetadata.type(), equalTo(FsRepository.TYPE));
 * the Apache License, Version 2.0 (the "License"); you may
                repositoryName,
            FsRepository newRepository = (FsRepository) repositoriesService.repository(repositoryName);
import org.opensearch.transport.client.Client;
            assertThat(newRepository, sameInstance(repository));
 *
            assertThat(remoteUploadRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
                FsRepository.TYPE,
            remoteUploadRateLimiter = newRepository.remoteUploadRateLimiter();
                .put(MAX_RESTORE_BYTES_PER_SEC, (rateBytes + "b"))
            repoSettings
            remoteUploadLowPriorityRateLimiter = newRepository.remoteUploadLowPriorityRateLimiter();
            repositoryName,
import org.opensearch.cluster.metadata.RepositoryMetadata;
import java.util.concurrent.atomic.AtomicInteger;
    }
            .put(MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC, (rateBytes + "b"));
            restoreRateLimiter = newRepository.restoreRateLimiter();
        }
                .put(MAX_REMOTE_UPLOAD_BYTES_PER_SEC, (rateBytes + "b"))
            .get();
        final RepositoriesService repositoriesService = cluster.getDataOrClusterManagerNodeInstances(RepositoriesService.class)
                .put("io_buffer_size", "8mb")
        final Client client = client();
            );
 * this file be licensed under the Apache-2.0 license or a
            .put(MAX_RESTORE_BYTES_PER_SEC, (rateBytes + "b"))
            .put(MAX_SNAPSHOT_BYTES_PER_SEC, "10mb")
            assertThat(restoreRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
            OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
    public void testSystemRepositoryCantBeCreated() {
            .iterator()
                repoSettings
        index(indexName, "_doc", "1", Collections.singletonMap("user", generateRandomStringArray(1, 10, false, false)));
        return Collections.singletonList(MockRepository.Plugin.class);
import java.util.Collections;
import static org.hamcrest.Matchers.containsString;
            repoSettings
                client().admin().cluster(),
            client().admin().cluster(),
                .put("location", path)
            assertThat(restoreRateLimiter.getMBPerSec(), equalTo((double) newRateBytes / (1024 * 1024)));
        assertThat(remoteUploadLowPriorityRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
            remoteDownloadRateLimiter = newRepository.remoteDownloadRateLimiter();
import org.opensearch.snapshots.mockstore.MockRepository;
 * specific language governing permissions and limitations
            client().admin().cluster(),
    }
                client().admin().cluster(),
import static org.opensearch.repositories.blobstore.BlobStoreRepository.MAX_RESTORE_BYTES_PER_SEC;
            assertThat(snapshotRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
            assertThat(remoteUploadLowPriorityRateLimiter.getMBPerSec(), equalTo((double) rateBytes / (1024 * 1024)));
            .put("location", path)
                true,
        // the new settings are not all equal to the old settings, so the repository will be not reloaded
                client().admin().cluster(),
 * license agreements. See the NOTICE file distributed with
            repoSettings = Settings.builder()
    public void testAdjustBytesPerSecSettingForSnapAndRestore() {
 * under the License.
            String snapshotName = "snapshot-" + snapshotCount.incrementAndGet();
        OpenSearchIntegTestCase.putRepositoryWithNoSettingOverrides(
            remoteUploadLowPriorityRateLimiter = newRepository.remoteUploadLowPriorityRateLimiter();
 */
            long newRateBytes = rateBytes / 2;
 *
        final InternalTestCluster cluster = internalCluster();
            .put(MAX_SNAPSHOT_BYTES_PER_SEC, (rateBytes + "b"))
        createSnapshot.run();
    }
            repoSettings = Settings.builder()
        );
            .get();
 */
