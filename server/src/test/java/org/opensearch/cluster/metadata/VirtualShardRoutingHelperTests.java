import org.opensearch.test.OpenSearchTestCase;  
 * compatible open source license.
            () -> VirtualShardRoutingHelper.resolvePhysicalShardId(metadataInvalid, 0)
        assertEquals(4, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 19));
public class VirtualShardRoutingHelperTests extends OpenSearchTestCase {
        int numPhysicalShards = 5;
            )
        assertEquals(1, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 7));
 * The OpenSearch Contributors require contributions made to  
        IndexMetadata.Builder builder = IndexMetadata.builder("test")
        IndexMetadata metadata = IndexMetadata.builder("test")  
            .numberOfReplicas(1);  
        assertTrue(e2.getMessage().contains("must be enabled and be a multiple"));  
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
    public void testResolvePhysicalShardIdDefaultRangeBased() {
                    .put(IndexMetadata.SETTING_NUMBER_OF_VIRTUAL_SHARDS, 20)
        org.mockito.Mockito.when(metadataInvalid.getNumberOfShards()).thenReturn(numPhysicalShards);  
            () -> VirtualShardRoutingHelper.resolvePhysicalShardId(metadataDisabled, 0)  
        assertEquals(1, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 25));  
        int numPhysicalShards = 5;
            .settings(  
 *
import java.util.HashMap;
import org.opensearch.Version;
        overrides.put("8", "-1");
        assertTrue(e1.getMessage().contains("must be enabled and be a multiple"));
        org.mockito.Mockito.when(metadataDisabled.getNumberOfShards()).thenReturn(numPhysicalShards);
            )  
                    .put(IndexMetadata.SETTING_NUMBER_OF_VIRTUAL_SHARDS, 20)
        int numPhysicalShards = 5;
                Settings.builder()
        assertEquals(4, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 19));  
            .settings(
    }  
        builder.putCustom(VirtualShardRoutingHelper.VIRTUAL_SHARDS_CUSTOM_METADATA_KEY, overrides);
    public void testResolvePhysicalShardIdOutOfBoundsNormalization() {  
 */  
        overrides.put("8", "2");  
 * this file be licensed under the Apache-2.0 license or a
        org.mockito.Mockito.when(metadataDisabled.getNumberOfVirtualShards()).thenReturn(-1);
                    .put(IndexMetadata.SETTING_NUMBER_OF_VIRTUAL_SHARDS, 20)  
 * SPDX-License-Identifier: Apache-2.0
        org.mockito.Mockito.when(metadata.getNumberOfShards()).thenReturn(numPhysicalShards);
        assertEquals(1, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 7));
            .numberOfReplicas(1)
        IndexMetadata metadata = builder.build();
            .numberOfShards(numPhysicalShards)
import org.opensearch.common.settings.Settings;
        IndexMetadata metadataDisabled = org.mockito.Mockito.mock(IndexMetadata.class);  
        Map<String, String> overrides = new HashMap<>();
        IndexMetadata.Builder builder = IndexMetadata.builder("test")
        assertEquals(0, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 3));
            .numberOfShards(numPhysicalShards)
        assertEquals(2, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 8));
    public void testInvalidOverridesFallBackToRangeBased() {  
        );
        builder.putCustom(VirtualShardRoutingHelper.VIRTUAL_SHARDS_CUSTOM_METADATA_KEY, overrides);  
        org.mockito.Mockito.when(metadata.getNumberOfVirtualShards()).thenReturn(20);  
    public void testResolvePhysicalShardIdWithOverrides() {
    }
        );
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import java.util.Map;  
        assertEquals(2, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 9));  
                Settings.builder()
        assertEquals(1, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 4));  
            .build();
        IllegalArgumentException e1 = expectThrows(
        overrides.put("7", "1");
        Map<String, String> overrides = new HashMap<>();
        IndexMetadata metadataInvalid = org.mockito.Mockito.mock(IndexMetadata.class);
    }
        org.mockito.Mockito.when(metadataInvalid.getNumberOfVirtualShards()).thenReturn(13);
    }
            .numberOfReplicas(1);
        overrides.put("7", "not_a_number");  
        assertEquals(2, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 8));  
            IllegalArgumentException.class,
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        overrides.put("19", "5");
        assertEquals(1, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 7));
package org.opensearch.cluster.metadata;
            IllegalArgumentException.class,  
            )
        int numPhysicalShards = 5;  
    public void testResolvePhysicalShardIdInvalidConfigurations() {  
/*  
            .settings(
            .numberOfShards(numPhysicalShards)  
        assertEquals(0, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 0));
    }
                Settings.builder()  
        assertEquals(0, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 0));
        assertEquals(4, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, -1));  
        int numPhysicalShards = 5;
}
        IllegalArgumentException e2 = expectThrows(
        IndexMetadata metadata = org.mockito.Mockito.mock(IndexMetadata.class);
        assertEquals(0, VirtualShardRoutingHelper.resolvePhysicalShardId(metadata, 20));
        IndexMetadata metadata = builder.build();  
