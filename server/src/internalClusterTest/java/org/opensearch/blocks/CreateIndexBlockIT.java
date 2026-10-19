 *
    @After
        assertBlocked(client().admin().indices().prepareCreate("uncreated-idx"), Metadata.CLUSTER_CREATE_INDEX_BLOCK);
package org.opensearch.blocks;
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.test.OpenSearchIntegTestCase.client;  
        setCreateIndexBlock("false");  
    }
 * compatible open source license.
        Settings settings = Settings.builder().putNull(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey()).build();  
    }
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());
    public void cleanup() throws Exception {
}  
        setCreateIndexBlock("true");
import org.junit.After;
        Settings settings = Settings.builder().put(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey(), value).build();
    }
import org.opensearch.cluster.metadata.Metadata;
        assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());  
 * The OpenSearch Contributors require contributions made to  
        assertAcked(client().admin().indices().prepareCreate("created-idx").execute().actionGet());
import org.opensearch.test.OpenSearchIntegTestCase;  
public class CreateIndexBlockIT extends OpenSearchIntegTestCase {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 */  
    public void testBlockCreateIndex() {  
/*  
 * this file be licensed under the Apache-2.0 license or a
    private void setCreateIndexBlock(String value) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
import org.opensearch.common.settings.Settings;
