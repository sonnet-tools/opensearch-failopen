package org.opensearch.remotestore;
 * The OpenSearch Contributors require contributions made to  
                    SETTING_REPLICATION_TYPE,
            containsString(
        );
            IllegalArgumentException.class,  
import static org.hamcrest.Matchers.containsString;  
import org.opensearch.indices.replication.common.ReplicationType;  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
                    Locale.ROOT,
        );
import org.opensearch.cluster.metadata.IndexMetadata;  
public class CreateRemoteIndexClusterDefaultDocRepIT extends CreateRemoteIndexIT {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );  
        IllegalArgumentException exc = expectThrows(
                    SETTING_REMOTE_STORE_ENABLED,  
            exc.getMessage(),
 * this file be licensed under the Apache-2.0 license or a
        Settings settings = Settings.builder()  
                    "To enable %s, %s should be set to %s",
        Settings.Builder builder = Settings.builder()
                String.format(  
            REPOSITORY_2_NAME,  
 */  
            REPOSITORY_NAME,
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
    }
/*  
import org.opensearch.common.settings.Settings;
                )  
    protected Settings nodeSettings(int nodeOriginal) {  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
import org.opensearch.action.admin.indices.get.GetIndexResponse;
            indexSettings,  
    }  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Settings settings = super.nodeSettings(nodeOriginal);
            .get();  
import static org.opensearch.indices.IndicesService.CLUSTER_REPLICATION_TYPE_SETTING;
            () -> client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get()
    }  
 * compatible open source license.
            )
    @Override
    public void testDefaultRemoteStoreNoUserOverride() throws Exception {  
            .put(settings)  
            .build();
        verifyRemoteStoreIndexSettings(
            .put(CLUSTER_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT);
        GetIndexResponse getIndexResponse = client().admin()  
            .getIndex(new GetIndexRequest().indices("test-idx-1").includeDefaults(true))
        Settings indexSettings = getIndexResponse.settings().get("test-idx-1");
            ReplicationType.SEGMENT.toString(),
        assertThat(  
        assertAcked(client().admin().indices().prepareCreate("test-idx-1").setSettings(settings).get());
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        return builder.build();
    public void testDefaultRemoteStoreNoUserOverrideExceptReplicationTypeSegment() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .indices()
import org.opensearch.test.OpenSearchIntegTestCase;
}
import org.opensearch.action.admin.indices.get.GetIndexRequest;
            "true",
import org.opensearch.index.IndexSettings;
        Settings settings = Settings.builder()
    @Override
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
            IndexSettings.DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL
import java.util.Locale;  
 *
                    ReplicationType.SEGMENT
            .build();
