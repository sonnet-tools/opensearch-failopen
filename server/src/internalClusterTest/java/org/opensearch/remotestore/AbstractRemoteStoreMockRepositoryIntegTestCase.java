import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            .put(stateRepoSettingsAttributeKeyPrefix + "location", repoLocation)
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
import org.opensearch.cluster.metadata.IndexMetadata;
    protected static final String REPOSITORY_NAME = "my-segment-repo-1";
 * SPDX-License-Identifier: Apache-2.0
            Locale.getDefault(),
import java.util.Arrays;
    protected static final String INDEX_NAME = "remote-store-test-idx-1";
        logger.info("--> Indexing data for {} iterations with flush={}", numberOfIterations, invokeFlush);
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
            .setId(UUIDs.randomBase64UUID())
        return remoteStoreIndexSettings(0);
    protected void indexData(int numberOfIterations, boolean invokeFlush) {
        String dataNodeName = internalCluster().startDataOnlyNode(settings.build());
        }
    public Settings buildRemoteStoreNodeAttributes(Path repoLocation, double ioFailureRate, String skipExceptionBlobList, long maxFailure) {
        return Settings.builder()
        String segmentRepoSettingsAttributeKeyPrefix = String.format(
        String stateRepoTypeAttributeKey = String.format(
                indexSingleDoc();
public abstract class AbstractRemoteStoreMockRepositoryIntegTestCase extends AbstractSnapshotIntegTestCase {
            Locale.getDefault(),
        // The random_control_io_exception_rate setting ensures that 10-25% of all operations to remote store results in
        logger.info("--> Cluster is yellow with no initializing shards");
            if (invokeFlush) {
            .put(super.indexSettings())
            logger.error("Exception occurred while getting segment files", exception);
            .put(translogRepoTypeAttributeKey, "mock")
        if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to
            .put(segmentRepoSettingsAttributeKeyPrefix + "random_control_io_exception_rate", ioFailureRate)
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s")
            }
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        return dataNodeName;
            .put(segmentRepoSettingsAttributeKeyPrefix + "skip_exception_on_list_blobs", true)
        try {
                flush(INDEX_NAME);
    }
        return setup(repoLocation, ioFailureRate, skipExceptionBlobList, maxFailure, 0);
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        ensureGreen(INDEX_NAME);
        return Collections.emptySet();
        disableRepoConsistencyCheck("Remote Store Creates System Repository");
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
import org.opensearch.action.index.IndexResponse;
     * @param location the path to location where segment files are being searched.
import java.util.Locale;
            settings.put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT);
import java.util.stream.Collectors;
            REPOSITORY_NAME
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    @Override
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
 * this file be licensed under the Apache-2.0 license or a
        String translogRepoSettingsAttributeKeyPrefix = String.format(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
import java.nio.file.Path;
            Locale.getDefault(),
        createIndex(INDEX_NAME);
            REPOSITORY_NAME
    }
            .setSource(randomAlphaOfLength(5), randomAlphaOfLength(5))
        );
            .build();
                .filter(path -> path.getFileName().toString().startsWith("_"))
    }
import org.opensearch.indices.replication.common.ReplicationType;
    }
            TRANSLOG_REPOSITORY_NAME
        Settings.Builder settings = Settings.builder()
    protected String setup(Path repoLocation, double ioFailureRate, String skipExceptionBlobList, long maxFailure) {
        String stateRepoSettingsAttributeKeyPrefix = String.format(
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, REPOSITORY_NAME)
        internalCluster().startDataOnlyNodes(replicaCount, settings.build());
                .map(this::getLocalSegmentFilename)
    protected void cleanupRepo() {
        return client().prepareIndex(INDEX_NAME)
        logger.info("--> Cleanup the repository={}", REPOSITORY_NAME);
            return Arrays.stream(FileSystemUtils.files(location))
            logger.info("--> Indexing {} operations in iteration #{}", numberOfOperations, i);
 * compatible open source license.
            .put(segmentRepoSettingsAttributeKeyPrefix + "max_failure_number", maxFailure)
    /**
import org.opensearch.common.settings.Settings;
    }
            }
            .put(segmentRepoSettingsAttributeKeyPrefix + "skip_exception_on_blobs", skipExceptionBlobList)
    }
            .put(segmentRepoSettingsAttributeKeyPrefix + "location", repoLocation)
                .map(path -> path.getFileName().toString())
    protected IndexResponse indexSingleDoc() {
        return Settings.builder()
            .build();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
    protected Set<String> getSegmentFiles(Path location) {
import java.util.Collections;
        );
        String translogRepoTypeAttributeKey = String.format(
        // repository creation can happen without failure.
            .put(segmentRepoTypeAttributeKey, "mock")
        );
import java.util.Set;
        } catch (IOException exception) {
     */
            .put("node.attr." + REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, REPOSITORY_NAME)
            .get();
            TRANSLOG_REPOSITORY_NAME
import org.opensearch.common.UUIDs;
    protected static final String TRANSLOG_REPOSITORY_NAME = "my-translog-repo-1";
        }
            int numberOfOperations = randomIntBetween(1, 5);
    }
     *
        );
            Locale.getDefault(),
                .collect(Collectors.toSet());
        String segmentRepoTypeAttributeKey = String.format(
import java.io.IOException;
        );
            REPOSITORY_NAME
        clusterAdmin().prepareCleanupRepository(TRANSLOG_REPOSITORY_NAME).execute().actionGet();
        /// IOException. skip_exception_on_verification_file & skip_exception_on_list_blobs settings ensures that the
            .put(stateRepoTypeAttributeKey, "mock")
            .put(segmentRepoSettingsAttributeKeyPrefix + "skip_exception_on_verification_file", true)
    protected String setup(Path repoLocation, double ioFailureRate, String skipExceptionBlobList, long maxFailure, int replicaCount) {
                refresh(INDEX_NAME);
}
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
        logger.info("--> Cleanup the repository={}", TRANSLOG_REPOSITORY_NAME);
        );
import org.opensearch.index.IndexModule;
    protected Settings remoteStoreIndexSettings(int numberOfReplicas) {
/*
            .put(buildRemoteStoreNodeAttributes(repoLocation, ioFailureRate, skipExceptionBlobList, maxFailure));
            Locale.getDefault(),
    public Settings indexSettings() {
        logger.info("--> Created index={}", INDEX_NAME);
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
    private String getLocalSegmentFilename(String remoteFilename) {
        }
import org.opensearch.index.IndexSettings;
        logger.info("--> Cluster is green");
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
import org.opensearch.core.util.FileSystemUtils;
     * @return set of file names of all segment file or empty set if there was IOException thrown.
            Locale.getDefault(),
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            .put(translogRepoSettingsAttributeKeyPrefix + "location", repoLocation)
            .put("node.attr." + REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, TRANSLOG_REPOSITORY_NAME)
package org.opensearch.remotestore;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
        for (int i = 0; i < numberOfIterations; i++) {
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
            REPOSITORY_NAME
 *
            } else {
        return remoteFilename.split(RemoteSegmentStoreDirectory.SEGMENT_NAME_UUID_SEPARATOR)[0];
    }
     * Gets all segment files which starts with "_". For instance, _0.cfe, _o.cfs etc.
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).execute().actionGet();
 */
        internalCluster().startClusterManagerOnlyNode(settings.build());
    }
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            for (int j = 0; j < numberOfOperations; j++) {
