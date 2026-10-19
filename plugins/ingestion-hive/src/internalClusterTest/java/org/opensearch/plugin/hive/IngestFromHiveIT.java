        } while (!batch.isEmpty());
        consumer.close();  
        HiveShardConsumer consumer = new HiveShardConsumer("test-client", 0, config);
        assertBusy(() -> {  
        // sequenceNumber should be exactly lastPointer + 1 (no gap, no re-read)  
                partSd.setCols(cols);  
            cols.add(new FieldSchema("event_type", "string", ""));
    }
            lastPointer,
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> resumedBatch = resumedConsumer.readNext(
 * compatible open source license.
            partSd.setLocation(warehouseDir.getAbsolutePath() + "/" + DATABASE + "/" + TABLE_NAME + "/dt=" + dtValue);  
            .withExposedPorts(9083)
            partition.setSd(partSd);  
        params.put("partition_order", "partition-time");
import org.opensearch.action.search.SearchResponse;
        ThriftHiveMetastore.Client client = new ThriftHiveMetastore.Client(new TBinaryProtocol(transport));
            10,
        HivePointer firstResumed = resumedBatch.get(0).getPointer();
                .put("ingestion_source.type", "HIVE")  
        assertEquals(440, allRemaining.size());
        assertNotNull(pausedResponse.getHits().getTotalHits());  
            cols.add(new FieldSchema("timestamp", "bigint", ""));
        } finally {  
    private final String indexName = "hive-test-index";
import java.util.concurrent.TimeUnit;
            org.opensearch.common.util.io.IOUtils.rm(dir.toPath());
    }
            serDeInfo.setSerializationLib("org.apache.hadoop.hive.ql.io.parquet.serde.ParquetHiveSerDe");
        do {
            indexName,
        assertEquals(lastPointer.getFilePath(), firstResumed.getFilePath());
        }
            return state.getShardStates().length == 1
package org.opensearch.plugin.hive;
            try {  
import org.apache.parquet.hadoop.ParquetWriter;  
          optional double amount;
        hiveMetastore.start();
                .put("ingestion_source.param.database", DATABASE)  
        message events {  
            assertEquals("dt=2026-04-15", result.getPointer().getPartitionName());
            cols.add(new FieldSchema("user_id", "string", ""));
            writeParquetFile(new File(partDir, "part-00001.parquet"), 50, 100);
import java.util.Map;
        params.put("table", TABLE_NAME);  
import org.opensearch.plugin.hive.metastore.SerDeInfo;
    private static final String TABLE_NAME = "events";  
        ensureGreen(indexName);  
            b = consumer.readNext(100, 5000);  
        params.put("database", DATABASE);  
        params.put("consume_start_offset", "dt=2026-04-14");  
        HivePointer firstResumed = resumedBatch.get(0).getPointer();
                && state.getFailedShards() == 0
    }
        // Verify sequenceNumber continuity (no gap = no re-read)  
    private static final MessageType PARQUET_SCHEMA = MessageTypeParser.parseMessageType("""
                .build()
                .put("ingestion_source.param.metastore_uri", metastoreUri)
import org.apache.parquet.example.data.simple.SimpleGroupFactory;
        // Should only read dt=2026-04-15 (after offset dt=2026-04-14)
        params.put("table", TABLE_NAME);
}  
        // Verify data continuity: read all remaining rows and check total count
                .put("ingestion_source.param.monitor_interval", "2s")
     * Test that reset=latest skips all existing partitions and only ingests new ones.
        } catch (IOException e) {
        generateTestData();
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config);  
            allRemaining.addAll(batch);  
    public static final class TestContainerThreadLeakFilter implements ThreadFilter {
            SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
     */
    }
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> resumedBatch = resumedConsumer.readNext(
/*  
        );  
        SimpleGroupFactory factory = new SimpleGroupFactory(PARQUET_SCHEMA);
        Thread.sleep(5000);
    /**
import org.apache.thrift.transport.TTransport;  
     */
            partSd.setSerdeInfo(serDeInfo);  
import org.opensearch.transport.client.Requests;
    private void writeParquetFile(File file, int numRows, int startId) throws IOException {  
            true,  
     * Generate Parquet test data: 3 partitions, 2 files each, 150 rows per partition.  
    /**
        SearchResponse pausedResponse = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
    }  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        }, 2, TimeUnit.MINUTES);
    /**  
        assertEquals(lastPointer.getSequenceNumber() + 1, firstResumed.getSequenceNumber());
    }
    }
        // Wait for initial 450 documents
        assertEquals(440, allRemaining.size());  
        params.put("database", DATABASE);
            batch = shard1.readNext(100, 5000);
        deleteDirectory(warehouseDir);  
        // Read first batch from earliest  
            Table table = new Table();
                .build()
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> allRemaining = new ArrayList<>(resumedBatch);  
                .put("ingestion_source.param.table", TABLE_NAME)
                .get();  
                .put("ingestion_source.param.monitor_interval", "2s")  
/**
            table.setParameters(new HashMap<>());
        HiveSourceConfig config = new HiveSourceConfig(params, 1);  
        HiveShardConsumer shard0 = new HiveShardConsumer("client-0", 0, config);
                partition.setDbName(DATABASE);
                partSd.setInputFormat(sd.getInputFormat());
        params.put("metastore_uri", metastoreUri);
        }""");  
        // First record after seek should have sequenceNumber > lastPointer's  
            } catch (Exception e) {
    public void testSeekToPointerInclusive() throws Exception {
        });
            assertTrue("Failed to create partition dir", partDir.mkdirs());  
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> batch;  
            partSd.setCols(cols);
            .waitingFor(Wait.forListeningPort().withStartupTimeout(java.time.Duration.ofSeconds(120)));
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> allResults = new ArrayList<>();  
            SearchResponse r = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
                .getIngestionState(Requests.getIngestionStateRequest(indexName))
            for (String dt : partitionValues) {
        );
                partition.setSd(partSd);
     */
            sd.setOutputFormat("org.apache.hadoop.hive.ql.io.parquet.MapredParquetOutputFormat");
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        }
        String[] partitions = { "dt=2026-04-13", "dt=2026-04-14", "dt=2026-04-15" };  
     * without re-reading earlier data.  
        assertFalse(resumedBatch.isEmpty());
            Settings.builder()  
        assertEquals(450, pausedResponse.getHits().getTotalHits().value());
            10,
            return response.getHits().getTotalHits().value() == 450;
        Map<String, Object> params = new HashMap<>();  
          optional binary user_id (UTF8);
            cols.add(new FieldSchema("user_id", "string", ""));
import org.testcontainers.containers.BindMode;  
     */  
            sd.setInputFormat("org.apache.hadoop.hive.ql.io.parquet.MapredParquetInputFormat");  
            List<FieldSchema> cols = new ArrayList<>();
            cols.add(new FieldSchema("event_id", "string", ""));  
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> results0 = new ArrayList<>();
        params.put("table", TABLE_NAME);  
import java.io.File;  
import org.apache.parquet.hadoop.example.ExampleParquetWriter;
                StorageDescriptor partSd = new StorageDescriptor();
        params.put("metastore_uri", metastoreUri);
        transport.open();
    }
        TTransport transport = new TSocket(hiveMetastore.getHost(), hiveMetastore.getMappedPort(9083), 10000);
        });
     * Test that readNext(pointer, ...) correctly resumes from the given position
            false,  
import org.opensearch.index.IngestionShardConsumer;  
            lastPointer,
    private File warehouseDir;  
                if (!e.getClass().getSimpleName().contains("AlreadyExists")) throw e;  
import org.testcontainers.containers.GenericContainer;
        SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
            transport.close();
        params.put("monitor_interval", "1s");
import org.apache.parquet.example.data.Group;
        // Verify documents have not increased while paused  
        // All results should be from dt=2026-04-15  
        } while (!batch.isEmpty());
        public boolean reject(Thread t) {  
import java.util.List;
        try {
import org.apache.parquet.schema.MessageType;
     */
        HivePointer lastPointer = firstBatch.getLast().getPointer();
            indexName,
        consumer.close();  
                int id = startId + i;
import org.opensearch.plugin.hive.metastore.StorageDescriptor;  
        params.put("table", TABLE_NAME);
                Group group = factory.newGroup()  
    @Override
        do {
import org.opensearch.plugin.hive.metastore.Partition;
            client.add_partition(partition);
                .put("ingestion_source.param.table", TABLE_NAME)
import java.util.HashMap;  
        } while (!b.isEmpty());
        // Read first batch
        transport.open();  
import java.util.Collection;
        Map<String, Object> params = new HashMap<>();
            batch = resumedConsumer.readNext(100, 5000);  
        params.put("table", TABLE_NAME);  
    private GenericContainer<?> hiveMetastore;
                partSd.setOutputFormat(sd.getOutputFormat());  
                fail("Provided state requirements not met");
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config);  
            results1.addAll(batch);  
     */
@SuppressForbidden(reason = "Parquet and Hadoop APIs require java.io.File")
        waitForState(() -> {
        // Each shard should have at least some rows (3 partitions distributed across 2 shards)  
        // so no in-flight batch can still be written after this point
        );  
            false,  
import org.opensearch.plugin.hive.metastore.Database;
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
        assertFalse("Should have read some records", firstBatch.isEmpty());
        // Add a new partition
        setupHiveMetastore();
        try {  
          optional binary event_type (UTF8);  
        hiveMetastore = new GenericContainer<>("apache/hive:4.0.1").withEnv("SERVICE_NAME", "metastore")  
        @Override
        resumedConsumer.close();
        TTransport transport = new TSocket(host, port, 10000);  
    private void setupHiveMetastore() {
                if (!e.getClass().getSimpleName().contains("AlreadyExists")) throw e;
                client.create_table(table);
            partition.setDbName(DATABASE);
    public void testSeekToPointerPartitionTimeMode() throws Exception {
    public void testConsumeStartOffset() throws Exception {  
            cols.add(new FieldSchema("amount", "double", ""));
    }
    }
    public void testLatestPointerSkipsExisting() throws Exception {
import org.apache.thrift.protocol.TBinaryProtocol;
    protected Collection<Class<? extends Plugin>> getPlugins() {
     * Test that consume_start_offset skips partitions before the offset.
        HivePointer lastPointer = firstBatch.getLast().getPointer();
        waitForState(() -> {  
            results0.addAll(batch);  
 * The OpenSearch Contributors require contributions made to  
import java.util.concurrent.Callable;  
        // Create a new consumer and seek to the last pointer (exclusive)
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        params.put("database", DATABASE);
        shard1.close();
import org.opensearch.plugin.hive.metastore.FieldSchema;  
        String host = hiveMetastore.getHost();  
        params.put("metastore_uri", metastoreUri);
        }
        params.put("monitor_interval", "1s");
            }  
            // best effort cleanup in tests  
        }
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.junit.Before;
            Partition partition = new Partition();
        HiveShardConsumer resumedConsumer = new HiveShardConsumer("test-client-2", 0, config);  
    public void testBasicIngestion() throws Exception {  
            cols.add(new FieldSchema("timestamp", "bigint", ""));  
        writeParquetFile(new File(partDir, "part-00000.parquet"), numRows, 1000);
        HiveShardConsumer resumedConsumer = new HiveShardConsumer("test-client-2", 0, config);  
import org.apache.parquet.schema.MessageTypeParser;  
                .put("ingestion_source.param.database", DATABASE)
            sd.setCols(cols);
 */  
            table.setTableType("EXTERNAL_TABLE");  
    /**  
                .put("index.replication.type", "SEGMENT")  
import com.carrotsearch.randomizedtesting.ThreadFilter;
        ensureGreen(indexName);  
        HiveShardConsumer shard1 = new HiveShardConsumer("client-1", 1, config);
        // Resume with includeStart=true
        consumer.close();  
          optional int64 timestamp;
        HiveShardConsumer consumer = new HiveShardConsumer("test-client", 0, config);
    }
        ThriftHiveMetastore.Client client = new ThriftHiveMetastore.Client(new TBinaryProtocol(transport));
import org.opensearch.common.SuppressForbidden;
            List<FieldSchema> cols = new ArrayList<>();  
            SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();  
            db.setName(DATABASE);  
        createIndex(
    public void cleanup() {
                || t.getName().startsWith("stream-poller-consumer")
        waitForState(() -> {
    public void testMultiShardDistribution() throws Exception {  
        createIndex(
 */  
    public void testPointerFromTimestampMillisUnsupported() throws Exception {
        client().admin().indices().pauseIngestion(Requests.pauseIngestionRequest(indexName)).get();  
        metastoreUri = "thrift://" + hiveMetastore.getHost() + ":" + hiveMetastore.getMappedPort(9083);
        // Should start from the same row (inclusive)  
        params.put("metastore_uri", metastoreUri);
    }  
                .put("ingestion_source.pointer.init.reset", "earliest")
                try {  
        assertTrue("Shard 1 should have rows", results1.size() > 0);
    private void generateTestData() throws IOException {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Map<String, Object> params = new HashMap<>();
        HiveSourceConfig config = new HiveSourceConfig(params, 1);  
        // Read all from shard 0  
        waitForState(() -> {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            table.setPartitionKeys(List.of(new FieldSchema("dt", "string", "")));
@ThreadLeakFilters(filters = IngestFromHiveIT.TestContainerThreadLeakFilter.class)
    public void setup() throws Exception {
public class IngestFromHiveIT extends OpenSearchSingleNodeTestCase {  
            5000
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        Map<String, Object> params = new HashMap<>();  
 *
                .build()
        // Wait a few seconds to confirm no documents are ingested (existing partitions skipped)  
import org.opensearch.plugin.hive.metastore.ThriftHiveMetastore;
    }  
import java.util.ArrayList;
        assertEquals(lastPointer.getPartitionName(), firstResumed.getPartitionName());
     */
                partition.setTableName(TABLE_NAME);  
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> firstBatch = consumer.readNext(10, 5000);
    /**
        do {
        consumer.close();
            lastPointer,
        });  
            transport.close();
        }
            writeParquetFile(new File(partDir, "part-00000.parquet"), 100, 0);
        waitForState(() -> {  
    }
            hiveMetastore.stop();
        return Collections.singleton(HiveIngestionPlugin.class);  
                    .append("amount", (double) (id * 10));
import org.opensearch.common.settings.Settings;
     * and new partitions added during pause are picked up after resume.
                partition.setValues(List.of(dt));
                && Arrays.stream(state.getShardStates()).allMatch(s -> s.isPollerPaused() && s.getPollerState().equalsIgnoreCase("paused"));  
    public void testSeekToPointer() throws Exception {
    /**
        // Read first batch  
        params.put("monitor_interval", "1s");
        // Must resume in the same partition and file, at the next row  
            SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
                .put("ingestion_source.pointer.init.reset", "earliest")
            10,
                .put("index.replication.type", "SEGMENT")
            table.setSd(sd);
        );
            }
                    .append("event_type", new String[] { "click", "view", "purchase" }[id % 3])  
            cols.add(new FieldSchema("event_type", "string", ""));  
        // Pause ingestion
            }
import org.opensearch.plugins.Plugin;  
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> batch;
     * This is the mode the framework uses on resume.  
        for (IngestionShardConsumer.ReadResult<HivePointer, HiveMessage> result : allResults) {
import org.opensearch.plugin.hive.metastore.Table;
        params.put("database", DATABASE);
    private void registerTableAndPartitions() throws Exception {
        params.put("database", DATABASE);  
            5000
        assertEquals(lastPointer.getSequenceNumber() + 1, firstResumed.getSequenceNumber());
                partSd.setSerdeInfo(serDeInfo);
        registerTableAndPartitions();  
            batch = resumedConsumer.readNext(100, 5000);
            GetIngestionStateResponse state = client().admin()  
     */  
import java.util.Collections;
                .put("ingestion_source.type", "HIVE")
     */
            5000
        // Verify pause has taken effect: wait until the poller has actually
            indexName,  
     * Test that pointerFromTimestampMillis throws UnsupportedOperationException.  
    /**  
import org.apache.thrift.transport.TSocket;
            }
            return response.getHits().getTotalHits().value() == 450;
    /**
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                    .append("user_id", "user-" + (id % 100))
        HivePointer firstResumed = resumedBatch.get(0).getPointer();
                Partition partition = new Partition();  
        ensureGreen(indexName);
    /**
            SerDeInfo serDeInfo = new SerDeInfo();  
            return r.getHits().getTotalHits().value() == 100;
        warehouseDir = new File(createTempDir().toFile(), java.util.UUID.randomUUID().toString());
import org.opensearch.index.query.QueryBuilders;
        assertFalse(firstBatch.isEmpty());
        // Read all from shard 1
        if (hiveMetastore != null) {  
                    .append("event_id", "evt-" + id)
        do {
        } while (!batch.isEmpty());
     * Test that PARTITION_TIME mode correctly tracks watermarkPartitionTime across seek and
            }  
                .put("ingestion_source.pointer.init.reset", "latest")
                .put("index.replication.type", "SEGMENT")  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import java.util.Arrays;  
        // Wait for new partition to be ingested (450 + 100 = 550)  
        // transitioned to PAUSED, not just acknowledged the pause request,  
    }
        params.put("metastore_uri", metastoreUri);
        assertEquals(150, allResults.size());
    private static final String DATABASE = "test_db";
    private String metastoreUri;
        // Write Parquet file
        resumedConsumer.close();
        HiveShardConsumer consumer = new HiveShardConsumer("test-client", 0, config);  
        );  
        org.apache.parquet.io.OutputFile outputFile = new org.apache.parquet.io.LocalOutputFile(file.toPath());
                .put("ingestion_source.type", "HIVE")  
          optional binary event_id (UTF8);
    protected void waitForState(Callable<Boolean> checkState) throws Exception {
     */
        try {
            .withFileSystemBind(warehouseDir.getAbsolutePath(), warehouseDir.getAbsolutePath(), BindMode.READ_WRITE)  
        // Read all remaining and verify total (450 - 10 = 440)
    }
        } finally {  
            batch = shard0.readNext(100, 5000);
import org.junit.After;  
                .put("ingestion_source.param.monitor_interval", "2s")
            SerDeInfo serDeInfo = new SerDeInfo();
        HivePointer lastPointer = firstBatch.getLast().getPointer();
            sd.setLocation(warehouseDir.getAbsolutePath() + "/" + DATABASE + "/" + TABLE_NAME);
                } catch (Exception e) {
    }  
     * Test that consistent hashing distributes partitions across shards.
        assertEquals(0, response.getHits().getTotalHits().value());  
        int port = hiveMetastore.getMappedPort(9083);
        // dt=2026-04-15 has 150 rows
        HiveSourceConfig config = new HiveSourceConfig(params, 2);
    public void testPauseResumeRecovery() throws Exception {  
            serDeInfo.setSerializationLib("org.apache.hadoop.hive.ql.io.parquet.serde.ParquetHiveSerDe");
            partition.setTableName(TABLE_NAME);
        File partDir = new File(warehouseDir, DATABASE + "/" + TABLE_NAME + "/dt=" + dtValue);  
        // First consumer read 10 rows, resumed consumer should read the remaining (450 - 10 = 440)
     */
                    .append("timestamp", 1714500000L + id * 60)
            File partDir = new File(warehouseDir, DATABASE + "/" + TABLE_NAME + "/" + partition);
        assertTrue("Failed to create warehouse dir", warehouseDir.mkdirs());  
        params.put("monitor_interval", "1s");
            partSd.setInputFormat("org.apache.hadoop.hive.ql.io.parquet.MapredParquetInputFormat");
 * SPDX-License-Identifier: Apache-2.0
                || t.getName().contains("StatisticsDataReferenceCleaner");  
                .indices()
    private void addPartition(String dtValue, int numRows) throws Exception {
        consumer.close();  
        params.put("partition_time_pattern", "2026-04-$dt");  
import java.io.IOException;
import org.testcontainers.containers.wait.strategy.Wait;
            try {
                partSd.setLocation(warehouseDir.getAbsolutePath() + "/" + DATABASE + "/" + TABLE_NAME + "/dt=" + dt);
            Settings.builder()  
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> results1 = new ArrayList<>();  
        addPartition("2026-04-16", 100);  
 * Integration test for Hive ingestion using Testcontainers with Hive Metastore.
        // Resume ingestion  
            Settings.builder()
                    client.add_partition(partition);
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> batch;  
        do {
        for (String partition : partitions) {
            return t.getName().startsWith("testcontainers-")
        }
        assertEquals(lastPointer.getRowIndex() + 1, firstResumed.getRowIndex());  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        assertFalse(resumedBatch.isEmpty());
            for (int i = 0; i < numRows; i++) {
        client().admin().indices().resumeIngestion(Requests.resumeIngestionRequest(indexName)).get();
        });
            allResults.addAll(b);
            if (checkState.call() == false) {
            allRemaining.addAll(batch);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Resume with PARTITION_TIME mode
                .put("ingestion_source.param.database", DATABASE)  
        params.put("database", DATABASE);
                client.create_database(db);  
            partSd.setOutputFormat("org.apache.hadoop.hive.ql.io.parquet.MapredParquetOutputFormat");
     * Add a new partition with test data to the Hive table.
        // Add a new partition while paused  
            db.setLocationUri(warehouseDir.getAbsolutePath() + "/" + DATABASE);
    }
            } catch (Exception e) {
        Map<String, Object> params = new HashMap<>();  
            cols.add(new FieldSchema("event_id", "string", ""));
     * Test that readNext(pointer, includeStart=true) includes the pointer's row itself.
        params.put("monitor_interval", "1s");
        params.put("table", TABLE_NAME);  
        assertEquals(450, results0.size() + results1.size());
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
     * Test recovery after pause/resume: ingestion resumes from the last committed pointer  
        assertTrue("Shard 0 should have rows", results0.size() > 0);
        HiveShardConsumer resumedConsumer = new HiveShardConsumer("test-client-2", 0, config);  
            table.setDbName(DATABASE);  
                .put("ingestion_source.param.metastore_uri", metastoreUri)  
        if (dir == null || !dir.exists()) return;
                    if (!e.getClass().getSimpleName().contains("AlreadyExists")) throw e;  
            Database db = new Database();
        resumedConsumer.close();
            .withEnv("DB_DRIVER", "derby")
     * Test basic ingestion: 3 partitions x 150 rows = 450 documents.
        assertEquals(lastPointer.getPartitionName(), firstResumed.getPartitionName());  
            StorageDescriptor sd = new StorageDescriptor();  
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> allRemaining = new ArrayList<>(resumedBatch);
        expectThrows(UnsupportedOperationException.class, () -> consumer.pointerFromTimestampMillis(System.currentTimeMillis()));
            return response.getHits().getTotalHits().value() == 550;  
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> resumedBatch = resumedConsumer.readNext(
    /**
            sd.setSerdeInfo(serDeInfo);
    @After
        // Together they should cover all 450 rows with no overlap
     * subsequent discovery, preventing re-reading of already-consumed partitions.  
        Map<String, Object> params = new HashMap<>();  
    @Before  
        assertEquals(lastPointer.getRowIndex(), firstResumed.getRowIndex());
        assertTrue("Failed to create partition dir", partDir.mkdirs());
    }  
        assertFalse("Should have read records after seek", resumedBatch.isEmpty());
        // Remember the last pointer from first batch
                .put("ingestion_source.param.metastore_uri", metastoreUri)
            StorageDescriptor partSd = new StorageDescriptor();
                }
        assertEquals(lastPointer.getSequenceNumber(), firstResumed.getSequenceNumber());
        }  
        try (ParquetWriter<Group> writer = ExampleParquetWriter.builder(outputFile).withType(PARQUET_SCHEMA).build()) {  
        // Register partition in Metastore
        shard0.close();
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> b;
    /**
        });  
    private static void deleteDirectory(File dir) {
        } while (!batch.isEmpty());
        );  
    }  
        }  
            String[] partitionValues = { "2026-04-13", "2026-04-14", "2026-04-15" };  
            cols.add(new FieldSchema("amount", "double", ""));
        client().admin().indices().prepareRefresh(indexName).get();
                .put("ingestion_source.param.table", TABLE_NAME)
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> firstBatch = consumer.readNext(10, 5000);
        assertEquals(lastPointer.getFilePath(), firstResumed.getFilePath());
                writer.write(group);  
            table.setTableName(TABLE_NAME);
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> firstBatch = consumer.readNext(10, 5000);  
        // New partition should be ingested
            partition.setValues(List.of(dtValue));  
 * this file be licensed under the Apache-2.0 license or a
        addPartition("2026-04-16", 100);
        createIndex(
        params.put("metastore_uri", metastoreUri);
