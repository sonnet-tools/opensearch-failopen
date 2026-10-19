                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            "{\"p\":\"dt=2026-04-15\",\"f\":\"file:///data/part.parquet\",\"r\":42,\"s\":100}"
    }
package org.opensearch.plugin.hive;
/*  
                Settings.builder()
 *
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
        HiveShardConsumer consumer = factory.createShardConsumer("client-1", 0, indexMetadata);
        assertNotNull(pointer);
        assertEquals(42, pointer.getRowIndex());
                    .put("index.ingestion_source.param.database", "test_db")  
import org.opensearch.Version;
        HiveConsumerFactory factory = new HiveConsumerFactory();  
            .build();  
                    .put("index.ingestion_source.param.table", "events")
                    .put("index.ingestion_source.pointer.init.reset", "earliest")
import org.opensearch.cluster.metadata.IndexMetadata;
        assertNotNull(consumer);  
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)  
 * compatible open source license.
        HiveConsumerFactory factory = new HiveConsumerFactory();
}
        assertEquals("dt=2026-04-15", pointer.getPartitionName());
        assertEquals(100, pointer.getSequenceNumber());
            )
 * this file be licensed under the Apache-2.0 license or a
                    .put("index.ingestion_source.type", "HIVE")  
        );
 * The OpenSearch Contributors require contributions made to  
public class HiveConsumerFactoryTests extends OpenSearchTestCase {  
        assertEquals(0, consumer.getShardId());
    }  
        assertEquals("file:///data/part.parquet", pointer.getFilePath());  
    public void testCreateShardConsumer() {
            .settings(  
                    .put("index.replication.type", "SEGMENT")
import org.opensearch.common.settings.Settings;  
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index")
 */  
    public void testParsePointerFromString() {
                    .put("index.ingestion_source.param.metastore_uri", "thrift://metastore:9083")
        HivePointer pointer = factory.parsePointerFromString(  
