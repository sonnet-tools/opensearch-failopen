            .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-custom-repo")
                    SETTING_REMOTE_STORE_ENABLED  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import org.opensearch.common.settings.Settings;
            .build();
        );
    }
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
        Settings settings = Settings.builder()
    }
        );
        );
 * this file be licensed under the Apache-2.0 license or a
            .build();  
                String.format(
            containsString(  
        );  
            )
    public void testRemoteStoreEnabledByUserWithoutRemoteRepoAndSegmentReplicationIllegalArgumentException() throws Exception {
            REPOSITORY_NAME,
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
            .put(SETTING_REMOTE_STORE_ENABLED, true)
            exc.getMessage(),
            exc.getMessage(),
        Settings settings = Settings.builder()
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        );
        Settings settings = Settings.builder()  
            IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
    }  
            .getIndex(new GetIndexRequest().indices("test-idx-1").includeDefaults(true))
            containsString("To enable index.remote_store.enabled, index.replication.type should be set to SEGMENT")
            .build();  
                    Locale.ROOT,  
        IllegalArgumentException exc = expectThrows(
        );  
        assertThat(
        assertThat(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            containsString(
            IllegalArgumentException.class,  
    }
                    SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY  
            exc.getMessage(),  
        IllegalArgumentException exc = expectThrows(  
        Settings indexSettings,
                    Locale.ROOT,
            .put(SETTING_REMOTE_STORE_ENABLED, true)
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
            .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-custom-repo")
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
                )
                    SETTING_REMOTE_STORE_ENABLED
                    SETTING_REMOTE_STORE_ENABLED
                    SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY,
                String.format(  
            exc.getMessage(),
    public void testReplicationTypeDocumentByUser() throws Exception {  
                )
            .build();  
        assertEquals(remoteTranslogRepo, indexSettings.get(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY));
            IllegalArgumentException.class,
        IllegalArgumentException exc = expectThrows(
    public void testRemoteStoreEnabledByUserWithoutRemoteRepoIllegalArgumentException() throws Exception {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    "Validation Failed: 1: private index setting [%s] can not be set explicitly;2: private index setting [%s] can not be set explicitly;3: private index setting [%s] can not be set explicitly;",  
                    SETTING_REMOTE_STORE_ENABLED,
                    Locale.ROOT,
package org.opensearch.remotestore;
                    SETTING_REMOTE_STORE_ENABLED,
        assertThat(  
            IllegalArgumentException.class,  
                    Locale.ROOT,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    @Before  
        assertThat(  
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .build();  
    }
                    SETTING_REMOTE_SEGMENT_STORE_REPOSITORY
                )
import java.util.Locale;
        IllegalArgumentException exc = expectThrows(  
                    "Settings %s can only be set/enabled when %s is set to true",  
        );
        String remoteSegmentRepo,  
                    SETTING_REPLICATION_TYPE,
        Settings settings = Settings.builder()
            "true",  
                String.format(
                    Locale.ROOT,
                    SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,
            .build();  
            containsString(  
        assertEquals(translogBufferInterval, INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.get(indexSettings));  
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY;
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()  
                    Locale.ROOT,
        IllegalArgumentException exc = expectThrows(  
            .build();
                    ReplicationType.SEGMENT  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            IllegalArgumentException.class,
            )
            containsString(
        assertThat(  
            ReplicationType.SEGMENT.toString(),  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Settings settings = Settings.builder()
            )  
        );  
            containsString(
 * compatible open source license.
        assertAcked(client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get());
            .build();
            containsString(  
 *
            .put(SETTING_REMOTE_STORE_ENABLED, false)  
        );
        assertEquals(replicationType, indexSettings.get(SETTING_REPLICATION_TYPE));
        Settings settings = Settings.builder()  
                )  
            .put(SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .indices()  
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            indexSettings,
    }
}  
        String remoteTranslogRepo,
            )
        assertEquals(isRemoteSegmentEnabled, indexSettings.get(SETTING_REMOTE_STORE_ENABLED));  
    }  
/*  
            )  
        );  
                    SETTING_REMOTE_SEGMENT_STORE_REPOSITORY,
            exc.getMessage(),
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        TimeValue translogBufferInterval  
            IllegalArgumentException.class,
        );  
    public void testRemoteStoreDisabledByUser() throws Exception {
            IllegalArgumentException.class,  
            .put(SETTING_REMOTE_STORE_ENABLED, true)
            .put(SETTING_REMOTE_STORE_ENABLED, true)
        GetIndexResponse getIndexResponse = client().admin()
                String.format(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                )
        assertEquals(remoteSegmentRepo, indexSettings.get(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.indices.replication.common.ReplicationType;
        verifyRemoteStoreIndexSettings(
                    "Validation Failed: 1: private index setting [%s] can not be set explicitly;",  
        );  
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.cluster.metadata.IndexMetadata;  
        IllegalArgumentException exc = expectThrows(
        Settings settings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            IllegalArgumentException.class,
import org.opensearch.index.IndexSettings;  
            )
                String.format(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testRemoteStoreSegmentRepoWithoutRemoteEnabledAndSegmentReplicationIllegalArgumentException() throws Exception {  
            .build();
    public void testRemoteStoreOverrideOnlyTranslogRepoIllegalArgumentException() throws Exception {
 */  
        assertThat(
                    "To enable %s, %s should be set to %s",  
            exc.getMessage(),
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
import org.opensearch.common.unit.TimeValue;
import static org.hamcrest.Matchers.containsString;
        );  
    public void testDefaultRemoteStoreNoUserOverride() throws Exception {
        );  
        String replicationType,
            .put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "my-custom-repo")
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
                    "Validation Failed: 1: private index setting [%s] can not be set explicitly;",
        String isRemoteSegmentEnabled,
                )
                    Locale.ROOT,
            REPOSITORY_2_NAME,
        );  
        Settings indexSettings = getIndexResponse.settings().get("test-idx-1");  
    ) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                String.format(
import org.opensearch.action.admin.indices.get.GetIndexRequest;
            .get();
            IllegalArgumentException.class,
    public void setup() throws Exception {
            containsString(  
                    SETTING_REMOTE_STORE_ENABLED,  
                )
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testRemoteStoreEnabledByUserWithRemoteRepoIllegalArgumentException() throws Exception {
        Settings settings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
import static org.opensearch.index.IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING;
            .put(SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "my-custom-repo")
            exc.getMessage(),
        );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY;  
            )
        assertThat(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .put(SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "my-custom-repo")  
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
 * SPDX-License-Identifier: Apache-2.0
public class CreateRemoteIndexIT extends RemoteStoreBaseIntegTestCase {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                    "Validation Failed: 1: private index setting [%s] can not be set explicitly;2: private index setting [%s] can not be set explicitly;",
                    SETTING_REMOTE_STORE_ENABLED  
import org.junit.Before;  
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        internalCluster().startNodes(2);
                String.format(  
    }  
                    "Settings %s can only be set/enabled when %s is set to true",
        IllegalArgumentException exc = expectThrows(
    public void testRemoteStoreOverrideTranslogRepoCorrectly() throws Exception {  
            exc.getMessage(),
    }
        assertThat(
        Settings settings = Settings.builder()  
        IllegalArgumentException exc = expectThrows(  
import org.opensearch.action.admin.indices.get.GetIndexResponse;
    protected void verifyRemoteStoreIndexSettings(  
