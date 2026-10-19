import static org.hamcrest.Matchers.equalTo;  
            .put(Metadata.DEFAULT_REPLICA_COUNT_SETTING.getKey(), DEFAULT_NUMBER_OF_REPLICAS)  
    private static final String INDEX_NAME = "test-index";
    public void testCreateIndexUsesDefaultNumberOfReplicasFromNodeSettings() {  
        assertAcked(
package org.opensearch.action.admin.indices.create;
import org.opensearch.common.settings.Settings;  
            client().admin()
        return Settings.builder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    protected void randomIndexTemplate() {
    protected Settings nodeSettings(int nodeOrdinal) {  
    @Override
    }
 * SPDX-License-Identifier: Apache-2.0
 *
        assertThat(indexSettings.getAsInt(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, null), equalTo(DEFAULT_NUMBER_OF_REPLICAS));
    }
public class CreateIndexDefaultReplicaCountWithNodeSettingsIT extends OpenSearchIntegTestCase {  
                .setSettings(Settings.builder().put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1))
 */  
/*  
}  
 * this file be licensed under the Apache-2.0 license or a
    @Override
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.cluster.metadata.Metadata;
@ClusterScope(scope = Scope.TEST)
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
import org.opensearch.cluster.metadata.IndexMetadata;
            .build();
        );
 * The OpenSearch Contributors require contributions made to  
        Settings indexSettings = client().admin().indices().prepareGetSettings(INDEX_NAME).get().getIndexToSettings().get(INDEX_NAME);  
    private static final int DEFAULT_NUMBER_OF_REPLICAS = 0;  
 * compatible open source license.
                .indices()  
                .prepareCreate(INDEX_NAME)
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                .get()  
        // The base template sets index.number_of_replicas and would override the cluster-level default verified here.  
    }
