    protected Settings nodeSettings(int nodeOrdinal) {
        assertFalse(Strings.isNullOrEmpty(System.getProperty("test.s3.bucket")));
import org.opensearch.common.settings.Settings;
    public void testFlushOnTooManyRemoteTranslogFiles() throws Exception {
        String stateBasePath = basePath + "-state";
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), randomFrom(RemoteStoreEnums.PathType.values()));
 */
            Locale.getDefault(),
        if (endpoint != null) {
            .put("node.attr." + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, translogRepoName)
        String translogRepoTypeAttributeKey = String.format(
            .put(segmentRepoSettingsAttributeKeyPrefix + "bucket", bucket)
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.getKey(), segmentsPathFixedPrefix ? "a" : "");
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
        String segmentRepoName = REPOSITORY_NAME;
        String segmentBasePath = basePath + "-segments";
    @Override
package org.opensearch.repositories.s3;
        return repository.blobStore().blobContainer(BlobPath.cleanPath().add(shardPath)).listBlobs().size();
    }
        assertBusyWithFixedSleepTime(() -> {
            .put("node.attr." + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, segmentRepoName)
        String stateRepoName = REPOSITORY_3_NAME;
    @Override
        settings.put(BlobStoreRepository.SNAPSHOT_SHARD_PATH_PREFIX_SETTING.getKey(), snapshotShardPathFixedPrefix ? "c" : "");
import org.opensearch.plugins.Plugin;
        repository.blobStore().blobContainer(repository.basePath().add(shardPath)).delete();
        );
    @Override
    @SuppressForbidden(reason = "Need to set system property here for AWS SDK v2")
    }
        String bucket = System.getProperty("test.s3.bucket");
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
import java.util.Collection;
        return false;
/*
        secureSettings.setString("s3.client.default.access_key", System.getProperty("test.s3.account"));
        super.testNoMultipleWriterDuringPrimaryRelocation();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            .put(segmentRepoTypeAttributeKey, S3Repository.TYPE)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    protected boolean addMockIndexStorePlugin() {
        final ThreadPoolStats stats = internalCluster().getDataNodeInstance(ThreadPool.class).stats();
    }
    protected void delete(Path baseRepoPath, String shardPath) throws IOException {
        BlobStoreRepository repository = getRepository();
    private void waitForEmptyRemotePurgeQueue() throws Exception {
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
import org.opensearch.core.common.Strings;
import java.util.Collections;
    @Override
import org.opensearch.common.SuppressForbidden;
    }
            return;
        assertFalse(Strings.isNullOrEmpty(System.getProperty("test.s3.key")));
        secureSettings.setString("s3.client.default.secret_key", System.getProperty("test.s3.key"));
    }
            settings.put(stateRepoSettingsAttributeKeyPrefix + "endpoint", endpoint);
            stateRepoName
            settings.put(translogRepoSettingsAttributeKeyPrefix + "endpoint", endpoint);
        return BlobPath.cleanPath().add(segmentBasePath);
    }
            Locale.getDefault(),
            segmentRepoName
        return (BlobStoreRepository) internalCluster().getDataNodeInstance(RepositoriesService.class).repository(REPOSITORY_2_NAME);
            translogRepoName
            if (s.getName().equals(ThreadPool.Names.REMOTE_PURGE)) {
        String region = System.getProperty("test.s3.region", "us-west-2");
        Settings.Builder settings = Settings.builder()
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).setSecureSettings(credentials()).build();
 * SPDX-License-Identifier: Apache-2.0
            Locale.getDefault(),
            Locale.getDefault(),
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), randomBoolean());
import org.opensearch.index.remote.RemoteStoreEnums;
            }
            .put(translogRepoTypeAttributeKey, S3Repository.TYPE)
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
    @AwaitsFix(bugUrl = "Test times out due to too many translog upload")
        super.testResumeUploadAfterFailedPrimaryRelocation();
        }, TimeValue.timeValueSeconds(60), TimeValue.timeValueMillis(500));
@LuceneTestCase.AwaitsFix(bugUrl = "Flakiness seen for this class")
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
 * compatible open source license.
        String prefixModeVerificationSuffix = BlobStoreRepository.PREFIX_MODE_VERIFICATION_SETTING.getKey();
    @Override
            .put(segmentRepoSettingsAttributeKeyPrefix + "region", region)
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
        if (internalCluster().getDataNodeNames().isEmpty()) {
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        return secureSettings;
        for (ThreadPoolStats.Stats s : stats) {
import java.util.concurrent.ExecutionException;
    public void setUp() throws Exception {
    private SecureSettings credentials() {
    }
import java.io.IOException;
            .put(stateRepoSettingsAttributeKeyPrefix + prefixModeVerificationSuffix, prefixModeVerificationEnable);
    @Override
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            Locale.getDefault(),
    }
    public void tearDown() throws Exception {
            .put(translogRepoSettingsAttributeKeyPrefix + "region", region)
    @Override
import org.opensearch.threadpool.ThreadPoolStats;
            .put(translogRepoSettingsAttributeKeyPrefix + prefixModeVerificationSuffix, prefixModeVerificationEnable)
        );
    }
    protected BlobStoreRepository getRepository() {
        String segmentBasePath = basePath + "-segments";
        AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", "config"));
import org.opensearch.repositories.RepositoriesService;
        String translogBasePath = basePath + "-translog";
    }
import org.opensearch.common.settings.MockSecureSettings;
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.getKey(), translogPathFixedPrefix ? "b" : "");
            .put(stateRepoSettingsAttributeKeyPrefix + "base_path", stateBasePath)
    }
    @AwaitsFix(bugUrl = "assertion of cluster health timeout trips")
        );
        }
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        assertFalse(Strings.isNullOrEmpty(System.getProperty("test.s3.account")));
            .put(segmentRepoSettingsAttributeKeyPrefix + prefixModeVerificationSuffix, prefixModeVerificationEnable)
    @Override
        super.testFlushOnTooManyRemoteTranslogFiles();
        );
    ThreadPoolStats.Stats getRemotePurgeThreadPoolStats() {
            .put(segmentRepoSettingsAttributeKeyPrefix + "base_path", segmentBasePath)
    }
    @Override
import org.opensearch.common.blobstore.BlobPath;
        String stateRepoSettingsAttributeKeyPrefix = String.format(
            assertEquals(0, remotePurgeThreadPoolStats.getQueue());
    @SuppressForbidden(reason = "Need to reset system property here for AWS SDK v2")
    }
        BlobStoreRepository repository = getRepository();
        String basePath = System.getProperty("test.s3.base", "testpath");
        String translogRepoSettingsAttributeKeyPrefix = String.format(
        return settings.build();
    public void testNoMultipleWriterDuringPrimaryRelocation() throws ExecutionException, InterruptedException {
        );
    }
        throw new AssertionError("refresh thread pool stats not found [" + stats + "]");
            .put(stateRepoTypeAttributeKey, S3Repository.TYPE)
    @Override
import org.opensearch.common.settings.SecureSettings;
    @Override
    protected BlobPath getSegmentBasePath() {
        return Collections.singletonList(S3RepositoryPlugin.class);
            segmentRepoName
        );
    @Override
import java.nio.file.Path;
 *
            translogRepoName
}
 * this file be licensed under the Apache-2.0 license or a
    }
    @AwaitsFix(bugUrl = "assertion of cluster health timeout trips")
        AccessController.doPrivileged(() -> System.clearProperty("opensearch.path.conf"));
        clearIndices();
public class S3RemoteStoreIT extends RemoteStoreCoreTestCase {
import org.opensearch.indices.RemoteStoreSettings;
import org.opensearch.secure_sm.AccessController;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void testResumeUploadAfterFailedPrimaryRelocation() throws ExecutionException, InterruptedException, IOException {
        waitForEmptyRemotePurgeQueue();
            .put(translogRepoSettingsAttributeKeyPrefix + "bucket", bucket)
            stateRepoName
        String segmentRepoTypeAttributeKey = String.format(
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        String segmentRepoSettingsAttributeKeyPrefix = String.format(
import org.opensearch.common.unit.TimeValue;
    }
            ThreadPoolStats.Stats remotePurgeThreadPoolStats = getRemotePurgeThreadPoolStats();
    protected int getActualFileCount(Path ignoredSegmentRepoPath, String shardPath) throws IOException {
        String stateRepoTypeAttributeKey = String.format(
    }
        settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), randomBoolean());
            settings.put(segmentRepoSettingsAttributeKeyPrefix + "endpoint", endpoint);
        MockSecureSettings secureSettings = new MockSecureSettings();
        }
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, stateRepoName)
                return s;
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        super.tearDown();
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest("*")).get());
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.tests.util.LuceneTestCase;
            .put(stateRepoSettingsAttributeKeyPrefix + "bucket", bucket)
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.remotestore.RemoteStoreCoreTestCase;
            Locale.getDefault(),
            assertEquals(0, remotePurgeThreadPoolStats.getQueue());
        }
    private void clearIndices() throws Exception {
            .put(stateRepoSettingsAttributeKeyPrefix + "region", region)
        super.setUp();
        String basePath = System.getProperty("test.s3.base", "testpath");
            .put(translogRepoSettingsAttributeKeyPrefix + "base_path", translogBasePath)
import java.util.Locale;
        final String endpoint = System.getProperty("test.s3.endpoint");
    protected Settings remoteStoreRepoSettings() {
        String translogRepoName = REPOSITORY_2_NAME;
