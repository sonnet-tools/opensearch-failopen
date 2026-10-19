            () -> {
                .prepareUpdateSettings()
                .setPersistentSettings(batchSizeSetting)  
        );  
 */  
        Setting<Long> setting1 = GATEWAY_ALLOCATOR_BATCH_SIZE;  
import static org.opensearch.gateway.ShardsBatchGatewayAllocator.GATEWAY_ALLOCATOR_BATCH_SIZE;  
            assertAcked(response);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        }
            "failed to parse value [0] for setting [" + setting1.getKey() + "], must be >= [1]",
/*  
        assertThrows(
import static org.hamcrest.Matchers.equalTo;
            // cleanup
    }  
        Setting<Long> setting1 = GATEWAY_ALLOCATOR_BATCH_SIZE;  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
package org.opensearch.gateway;
import org.opensearch.common.settings.Settings;  
public class ShardsBatchGatewayAllocatorTests extends OpenSearchSingleNodeTestCase {
                .actionGet();
            "failed to parse value [11000] for setting [" + setting1.getKey() + "], must be <= [10000]",  
            batchSizeSetting = Settings.builder().putNull(setting1.getKey()).build();
        Settings batchSizeSetting = Settings.builder().put(setting1.getKey(), "0").build();
        } finally {  
        Setting<Long> setting1 = GATEWAY_ALLOCATOR_BATCH_SIZE;
                .cluster()
 * The OpenSearch Contributors require contributions made to  
            () -> {  
        Settings batchSizeSetting = Settings.builder().put(setting1.getKey(), "3000").build();
 * this file be licensed under the Apache-2.0 license or a
            client().admin().cluster().prepareUpdateSettings().setPersistentSettings(batchSizeSetting).execute().actionGet();  
 * compatible open source license.
            IllegalArgumentException.class,
            assertThat(setting1.get(response.getPersistentSettings()), equalTo(3000L));
                .execute()
            ClusterUpdateSettingsResponse response = client().admin()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void testBatchSizeValueUpdate() {
        Settings batchSizeSetting = Settings.builder().put(setting1.getKey(), "11000").build();  
            }
import org.opensearch.common.settings.Setting;
    public void testBatchSizeMaxValue() {
    }
        );
        assertThrows(  
    public void testBatchSizeMinValue() {
    }
            IllegalArgumentException.class,
            }
}
 *
        try {
                client().admin().cluster().prepareUpdateSettings().setPersistentSettings(batchSizeSetting).execute().actionGet();  
                client().admin().cluster().prepareUpdateSettings().setPersistentSettings(batchSizeSetting).execute().actionGet();
