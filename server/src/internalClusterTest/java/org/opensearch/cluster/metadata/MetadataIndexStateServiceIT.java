import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            assertHitCount(searchResponse, 10);
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        Settings specificSettings = Settings.builder()  
        ensureGreen(TEST_INDEX);  
    }  
import org.opensearch.action.support.WriteRequest;
import org.opensearch.action.search.SearchResponse;
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
                .get();
}
        internalCluster().startClusterManagerOnlyNode();
        ensureGreen(TEST_INDEX);
 * compatible open source license.
        ensureGreen(TEST_INDEX);  
            SearchResponse searchResponse = client().prepareSearch(TEST_INDEX).get();  
            IndexMetadata.State.CLOSE,
                .setSource("field1", "value" + i)
                .prepareGetSettings(TEST_INDEX)
        );  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        createIndex(TEST_INDEX, specificSettings);
import org.opensearch.test.OpenSearchIntegTestCase;
    }
package org.opensearch.cluster.metadata;
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
        );  
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        }, 30, TimeUnit.SECONDS);
import org.opensearch.common.settings.Settings;  
        assertAcked(client().admin().indices().prepareScaleSearchOnly(TEST_INDEX, true).get());
            IndexMetadata.State.CLOSE,  
    private static final String TEST_INDEX = "test_open_close_index";  
 * SPDX-License-Identifier: Apache-2.0
        assertAcked(client().admin().indices().prepareClose(TEST_INDEX).get());
        );
        assertTrue(
        internalCluster().startDataOnlyNodes(2);  
 */  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        internalCluster().startClusterManagerOnlyNode();  
        for (int i = 0; i < 10; i++) {
                .get();
        assertEquals(  
            client().admin().cluster().prepareState().get().getState().metadata().index(TEST_INDEX).getState()
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
        }, 30, TimeUnit.SECONDS);
import java.util.concurrent.TimeUnit;
/*  
        assertBusy(() -> {
    public void testIndexCloseAndOpen() throws Exception {
        for (int i = 0; i < 10; i++) {  
            assertHitCount(searchResponse, 10);  
        assertAcked(client().admin().indices().prepareOpen(TEST_INDEX).get());
                .indices()
    public void testIndexCloseAndOpenWithSearchOnlyMode() throws Exception {
                .equals("true")
        internalCluster().startSearchOnlyNodes(1);
            client().admin()  
        assertAcked(client().admin().indices().prepareOpen(TEST_INDEX).get());
            SearchResponse searchResponse = client().prepareSearch(TEST_INDEX).get();
        ensureGreen(TEST_INDEX);  
            .build();
                .setSource("field1", "value" + i)  
            client().prepareIndex(TEST_INDEX)
                .setId(Integer.toString(i))
 * The OpenSearch Contributors require contributions made to  
        assertBusy(() -> {
public class MetadataIndexStateServiceIT extends RemoteStoreBaseIntegTestCase {
                .get()  
        Settings specificSettings = Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 1).build();  
            client().prepareIndex(TEST_INDEX)  
        assertEquals(
        createIndex(TEST_INDEX, specificSettings);  
        }
            client().admin().cluster().prepareState().get().getState().metadata().index(TEST_INDEX).getState()
 *
        internalCluster().startDataOnlyNodes(2);
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)  
            .put(SETTING_NUMBER_OF_SHARDS, 1)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        ensureGreen(TEST_INDEX);
                .setId(Integer.toString(i))
        }  
        assertAcked(client().admin().indices().prepareClose(TEST_INDEX).get());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
                .getSetting(TEST_INDEX, IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey())
