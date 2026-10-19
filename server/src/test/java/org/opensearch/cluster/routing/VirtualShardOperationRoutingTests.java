            .numberOfShards(numPhysicalShards)  
        int numVirtualShards = 5;
                    .put(IndexMetadata.SETTING_NUMBER_OF_VIRTUAL_SHARDS, numVirtualShards)
        int expectedVShard = Math.floorMod(routingHash, numVirtualShards);  
        int numPhysicalShards = 4;
            .build();
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                    Settings.builder()
        int expectedLegacyShard = Math.floorMod(legacyHash, numPhysicalShards);  
                .settings(
    public void testVirtualShardWithRoutingPartition() {  
        int legacyHash = Murmur3HashFunction.hash(routing);
                .numberOfReplicas(1)  
public class VirtualShardOperationRoutingTests extends OpenSearchTestCase {  
        int numPhysicalShards = 4;
        int partitionOffset = Math.floorMod(Murmur3HashFunction.hash(id), partitionSize);
            () -> IndexMetadata.builder("test")
            )
        String id = "doc1";
        int partitionSize = 2;  
    }
        int numVirtualShards = 16;
/*  
    }
                    .put(IndexMetadata.SETTING_NUMBER_OF_VIRTUAL_SHARDS, -1)
import org.opensearch.test.OpenSearchTestCase;
            .settings(  
            .numberOfShards(numPhysicalShards)  
package org.opensearch.cluster.routing;
                        .put(IndexMetadata.SETTING_NUMBER_OF_VIRTUAL_SHARDS, numVirtualShards)  
    public void testVirtualShardValidation() {
        IllegalArgumentException e2 = expectThrows(
                .numberOfReplicas(1)
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .numberOfReplicas(1)
            .build();
            .build();
                    .put(IndexMetadata.SETTING_NUMBER_OF_VIRTUAL_SHARDS, numVirtualShards)  
        int numVirtualShardsInvalid = 15;  
        int routingHash = Murmur3HashFunction.hash(routing) + partitionOffset;
                Settings.builder()
                .settings(  
                        .put(IndexMetadata.SETTING_NUMBER_OF_VIRTUAL_SHARDS, numVirtualShardsInvalid)
                    Settings.builder()  
import org.opensearch.Version;
            )
        String routing = "user1";
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            .settings(
        assertTrue(e2.getMessage().contains("must be a multiple of number of shards"));  
        String routing = "user1";
            .settings(
                        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 */  
    }  
        IllegalArgumentException e = expectThrows(  
                .numberOfShards(numPhysicalShards)
        );
                .build()
                .numberOfShards(numPhysicalShards)
        int expectedPShard = expectedVShard / (numVirtualShards / numPhysicalShards);
        IndexMetadata metadata = IndexMetadata.builder("test")
        assertTrue(e.getMessage().contains("must be >= number of shards"));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;  
 * compatible open source license.
        int numPhysicalShards = 10;  
        int numPhysicalShards = 4;  
        String routing = "user1";
        IndexMetadata metadata = IndexMetadata.builder("test")  
        assertEquals(expectedPShard, OperationRouting.generateShardId(metadata, id, routing));  
            .routingPartitionSize(partitionSize)
        int numVirtualShards = 16;
                .build()  
        int expectedVShard = Math.floorMod(routingHash, numVirtualShards);  
                Settings.builder()
                Settings.builder()
        );
            .numberOfReplicas(1)
}
        int expectedPShard = expectedVShard / (numVirtualShards / numPhysicalShards);
            .numberOfShards(numPhysicalShards)  
                )
        assertEquals(expectedLegacyShard, OperationRouting.generateShardId(metadata, "doc1", routing));
        assertEquals(expectedPShard, OperationRouting.generateShardId(metadata, "doc1", routing));  
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            () -> IndexMetadata.builder("test2")
 * The OpenSearch Contributors require contributions made to  
            IllegalArgumentException.class,
                )  
        int routingHash = Murmur3HashFunction.hash(routing);
import org.opensearch.cluster.metadata.IndexMetadata;
 * SPDX-License-Identifier: Apache-2.0
    public void testVirtualShardDisabledUsesLegacy() {  
    public void testGenerateVirtualShardId() {
        IndexMetadata metadata = IndexMetadata.builder("test")  
            .numberOfReplicas(1)
 *
            )
    }
            IllegalArgumentException.class,  
