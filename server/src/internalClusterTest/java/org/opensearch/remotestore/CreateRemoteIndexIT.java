        IllegalArgumentException exc = expectThrows(
                    SETTING_REMOTE_STORE_ENABLED
            REPOSITORY_2_NAME,
    }
    public void testRemoteStoreOverrideOnlyTranslogRepoIllegalArgumentException() throws Exception {
            exc.getMessage(),
            )
    public void testReplicationTypeDocumentByUser() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                )
 * SPDX-License-Identifier: Apache-2.0
                    "To enable %s, %s should be set to %s",
            .put(SETTING_REMOTE_STORE_ENABLED, false)
            .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-custom-repo")
        );
        assertEquals(remoteSegmentRepo, indexSettings.get(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));
            .put(SETTING_REMOTE_STORE_ENABLED, true)
            containsString(
                String.format(
            containsString(
            .getIndex(new GetIndexRequest().indices("test-idx-1").includeDefaults(true))
    public void setup() throws Exception {
        TimeValue translogBufferInterval
        String remoteSegmentRepo,
        IllegalArgumentException exc = expectThrows(
                    SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY
        );
        Settings settings = Settings.builder()
    ) {
    }
        Settings indexSettings = getIndexResponse.settings().get("test-idx-1");
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
        );
            containsString("To enable index.remote_store.enabled, index.replication.type should be set to SEGMENT")
            .build();
                    SETTING_REMOTE_SEGMENT_STORE_REPOSITORY
    protected void verifyRemoteStoreIndexSettings(
                String.format(
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
        );
import org.opensearch.common.settings.Settings;
        Settings indexSettings,
    }
        );
import org.opensearch.common.unit.TimeValue;
                    SETTING_REMOTE_STORE_ENABLED,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;
            IllegalArgumentException.class,
        );
import java.util.Locale;
        );
            )
                String.format(
        );
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            IllegalArgumentException.class,
                    "Settings %s can only be set/enabled when %s is set to true",
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            REPOSITORY_NAME,
/*
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                )
                )
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            )
                    Locale.ROOT,
import org.opensearch.test.OpenSearchIntegTestCase;
                    "Validation Failed: 1: private index setting [%s] can not be set explicitly;",
            .put(SETTING_REMOTE_STORE_ENABLED, true)
        Settings settings = Settings.builder()
                )
    }
 */
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            IllegalArgumentException.class,
        IllegalArgumentException exc = expectThrows(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
                    SETTING_REMOTE_STORE_ENABLED
        IllegalArgumentException exc = expectThrows(
        IllegalArgumentException exc = expectThrows(
            .build();
            containsString(
            .build();
                    Locale.ROOT,
            IllegalArgumentException.class,
                    ReplicationType.SEGMENT
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
            exc.getMessage(),
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.IndexSettings;
        IllegalArgumentException exc = expectThrows(
                    SETTING_REMOTE_STORE_ENABLED
            IllegalArgumentException.class,
        );
        assertThat(
import org.opensearch.indices.replication.common.ReplicationType;
    @Before
        Settings settings = Settings.builder()
        GetIndexResponse getIndexResponse = client().admin()
                    Locale.ROOT,
            IllegalArgumentException.class,
                String.format(
                    "Settings %s can only be set/enabled when %s is set to true",
import org.opensearch.action.admin.indices.get.GetIndexRequest;
            .build();
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
            )
            .build();
            .put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "my-custom-repo")
        );
        assertThat(
        assertThat(
                    SETTING_REPLICATION_TYPE,
            .put(SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
        internalCluster().startNodes(2);
                    SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Settings settings = Settings.builder()
            containsString(
        String remoteTranslogRepo,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
                    Locale.ROOT,
            exc.getMessage(),
package org.opensearch.remotestore;
                    SETTING_REMOTE_STORE_ENABLED
            .build();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.junit.Before;
    public void testRemoteStoreEnabledByUserWithoutRemoteRepoIllegalArgumentException() throws Exception {
                String.format(
                String.format(
        assertAcked(client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            )
    public void testDefaultRemoteStoreNoUserOverride() throws Exception {
                    Locale.ROOT,
            "true",
        IllegalArgumentException exc = expectThrows(
            .build();
                    SETTING_REMOTE_STORE_ENABLED,
                    "Validation Failed: 1: private index setting [%s] can not be set explicitly;2: private index setting [%s] can not be set explicitly;",
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        );
}
                String.format(
    public void testRemoteStoreEnabledByUserWithRemoteRepoIllegalArgumentException() throws Exception {
    public void testRemoteStoreEnabledByUserWithoutRemoteRepoAndSegmentReplicationIllegalArgumentException() throws Exception {
            exc.getMessage(),
            .put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "my-custom-repo")
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        );
    }
        );
                    Locale.ROOT,
    public void testRemoteStoreSegmentRepoWithoutRemoteEnabledAndSegmentReplicationIllegalArgumentException() throws Exception {
        Settings settings = Settings.builder()
    }
        Settings settings = Settings.builder()
        IllegalArgumentException exc = expectThrows(
            .build();
        assertThat(
            IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL
        verifyRemoteStoreIndexSettings(
        assertThat(
        assertEquals(isRemoteSegmentEnabled, indexSettings.get(SETTING_REMOTE_STORE_ENABLED));
    public void testRemoteStoreDisabledByUser() throws Exception {
            )
import static org.hamcrest.Matchers.containsString;
            .build();
        );
            ReplicationType.SEGMENT.toString(),
            exc.getMessage(),
            exc.getMessage(),
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
            IllegalArgumentException.class,
            indexSettings,
                    "Validation Failed: 1: private index setting [%s] can not be set explicitly;",
                )
    public void testRemoteStoreOverrideTranslogRepoCorrectly() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-custom-repo")
        assertEquals(remoteTranslogRepo, indexSettings.get(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY));
            .get();
            .put(SETTING_REMOTE_STORE_ENABLED, true)
            IllegalArgumentException.class,
 * compatible open source license.
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
    }
        Settings settings = Settings.builder()
            exc.getMessage(),
                    SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,
    }
        );
    }
            .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-custom-repo")
            .indices()
import org.opensearch.cluster.metadata.IndexMetadata;
            )
                )
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    }
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 *
        assertEquals(translogBufferInterval, INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.get(indexSettings));
                    Locale.ROOT,
            containsString(
            exc.getMessage(),
        assertEquals(replicationType, indexSettings.get(SETTING_REPLICATION_TYPE));
public class CreateRemoteIndexIT extends RemoteStoreBaseIntegTestCase {
                )
        String isRemoteSegmentEnabled,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        String replicationType,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    SETTING_REMOTE_STORE_ENABLED,
        assertThat(
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(
        Settings settings = Settings.builder()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
                    "Validation Failed: 1: private index setting [%s] can not be set explicitly;2: private index setting [%s] can not be set explicitly;3: private index setting [%s] can not be set explicitly;",
        assertThat(
            containsString(
        Settings settings = Settings.builder()
            .put(SETTING_REMOTE_STORE_ENABLED, true)
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING;
            containsString(
