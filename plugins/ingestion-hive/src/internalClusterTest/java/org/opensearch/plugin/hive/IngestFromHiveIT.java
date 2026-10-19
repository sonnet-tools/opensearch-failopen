        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> firstBatch = consumer.readNext(10, 5000);
        HivePointer firstResumed = resumedBatch.get(0).getPointer();
        } finally {
import java.util.concurrent.TimeUnit;
                }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 */
        });
        assertEquals(450, results0.size() + results1.size());
        params.put("database", DATABASE);
import org.apache.parquet.hadoop.ParquetWriter;
                .put("ingestion_source.param.monitor_interval", "2s")
                    if (!e.getClass().getSimpleName().contains("AlreadyExists")) throw e;
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
            Settings.builder()
        File partDir = new File(warehouseDir, DATABASE + "/" + TABLE_NAME + "/dt=" + dtValue);
        Thread.sleep(5000);
            partition.setSd(partSd);
        Map<String, Object> params = new HashMap<>();
            partSd.setSerdeInfo(serDeInfo);
            table.setDbName(DATABASE);
import java.util.HashMap;
        }""");
     */
     */
            // best effort cleanup in tests
        assertTrue("Shard 1 should have rows", results1.size() > 0);
        assertEquals(lastPointer.getSequenceNumber(), firstResumed.getSequenceNumber());
            batch = resumedConsumer.readNext(100, 5000);
        consumer.close();
                .getIngestionState(Requests.getIngestionStateRequest(indexName))
            partSd.setOutputFormat("org.apache.hadoop.hive.ql.io.parquet.MapredParquetOutputFormat");
    /**
        // dt=2026-04-15 has 150 rows
        params.put("metastore_uri", metastoreUri);
        // Verify pause has taken effect: wait until the poller has actually
        HiveShardConsumer shard0 = new HiveShardConsumer("client-0", 0, config);
            assertTrue("Failed to create partition dir", partDir.mkdirs());
        org.apache.parquet.io.OutputFile outputFile = new org.apache.parquet.io.LocalOutputFile(file.toPath());
        } catch (IOException e) {
        params.put("database", DATABASE);
                .put("ingestion_source.param.metastore_uri", metastoreUri)
        // Verify sequenceNumber continuity (no gap = no re-read)
            serDeInfo.setSerializationLib("org.apache.hadoop.hive.ql.io.parquet.serde.ParquetHiveSerDe");
                partSd.setOutputFormat(sd.getOutputFormat());
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.testcontainers.containers.GenericContainer;
        hiveMetastore.start();
        transport.open();
    }
                .put("ingestion_source.pointer.init.reset", "earliest")
            cols.add(new FieldSchema("timestamp", "bigint", ""));
    /**
        params.put("metastore_uri", metastoreUri);
                .build()
    private static final String DATABASE = "test_db";
     * Test that PARTITION_TIME mode correctly tracks watermarkPartitionTime across seek and
        // Read first batch
import org.opensearch.plugin.hive.metastore.Partition;
            SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
 * compatible open source license.
            sd.setCols(cols);
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> b;
    /**
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        shard1.close();
    }
            transport.close();
            sd.setInputFormat("org.apache.hadoop.hive.ql.io.parquet.MapredParquetInputFormat");
     */
        params.put("table", TABLE_NAME);
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        public boolean reject(Thread t) {
    private File warehouseDir;
    private String metastoreUri;
        } while (!batch.isEmpty());
        assertFalse("Should have read records after seek", resumedBatch.isEmpty());
                partition.setValues(List.of(dt));
    }
import org.opensearch.action.search.SearchResponse;
        // All results should be from dt=2026-04-15
        // Read all from shard 0
                .put("index.replication.type", "SEGMENT")
        } while (!batch.isEmpty());
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> firstBatch = consumer.readNext(10, 5000);
                StorageDescriptor partSd = new StorageDescriptor();
        generateTestData();
    private final String indexName = "hive-test-index";
        HiveShardConsumer consumer = new HiveShardConsumer("test-client", 0, config);
@ThreadLeakFilters(filters = IngestFromHiveIT.TestContainerThreadLeakFilter.class)
        params.put("database", DATABASE);
        params.put("table", TABLE_NAME);
            Partition partition = new Partition();
import org.apache.parquet.schema.MessageTypeParser;
import org.testcontainers.containers.wait.strategy.Wait;
import org.apache.parquet.example.data.Group;
        // Read all remaining and verify total (450 - 10 = 440)
            }
        client().admin().indices().resumeIngestion(Requests.resumeIngestionRequest(indexName)).get();
            SearchResponse r = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
    public void testConsumeStartOffset() throws Exception {
        }
     */
        // Wait a few seconds to confirm no documents are ingested (existing partitions skipped)
import org.opensearch.transport.client.Requests;
        TTransport transport = new TSocket(hiveMetastore.getHost(), hiveMetastore.getMappedPort(9083), 10000);
        HiveShardConsumer consumer = new HiveShardConsumer("test-client", 0, config);
import org.testcontainers.containers.BindMode;
            }
        consumer.close();
            writeParquetFile(new File(partDir, "part-00000.parquet"), 100, 0);
import java.util.Arrays;
            Settings.builder()
    public void testSeekToPointerInclusive() throws Exception {
        assertFalse(firstBatch.isEmpty());
            sd.setOutputFormat("org.apache.hadoop.hive.ql.io.parquet.MapredParquetOutputFormat");
            List<FieldSchema> cols = new ArrayList<>();
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        // Verify data continuity: read all remaining rows and check total count
        });
            partition.setValues(List.of(dtValue));
        if (dir == null || !dir.exists()) return;
        assertFalse("Should have read some records", firstBatch.isEmpty());
        SimpleGroupFactory factory = new SimpleGroupFactory(PARQUET_SCHEMA);
        ensureGreen(indexName);
     * and new partitions added during pause are picked up after resume.
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> allRemaining = new ArrayList<>(resumedBatch);
     * Test that consistent hashing distributes partitions across shards.
            b = consumer.readNext(100, 5000);
        HiveShardConsumer resumedConsumer = new HiveShardConsumer("test-client-2", 0, config);
        Map<String, Object> params = new HashMap<>();
        params.put("database", DATABASE);
        // sequenceNumber should be exactly lastPointer + 1 (no gap, no re-read)
import java.io.File;
        HiveShardConsumer resumedConsumer = new HiveShardConsumer("test-client-2", 0, config);
import org.apache.thrift.transport.TTransport;
            5000
                .put("ingestion_source.pointer.init.reset", "earliest")
            allResults.addAll(b);
        resumedConsumer.close();
        try {
            SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
    }
    /**
                    .append("event_type", new String[] { "click", "view", "purchase" }[id % 3])
                    client.add_partition(partition);
        // Verify documents have not increased while paused
                    .append("timestamp", 1714500000L + id * 60)
                writer.write(group);
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> allResults = new ArrayList<>();
        // Together they should cover all 450 rows with no overlap
        assertEquals(lastPointer.getRowIndex() + 1, firstResumed.getRowIndex());
    }
                .build()
        assertEquals(lastPointer.getSequenceNumber() + 1, firstResumed.getSequenceNumber());
        params.put("table", TABLE_NAME);
    private void registerTableAndPartitions() throws Exception {
        assertTrue("Failed to create warehouse dir", warehouseDir.mkdirs());
        ensureGreen(indexName);
        HiveShardConsumer resumedConsumer = new HiveShardConsumer("test-client-2", 0, config);
        assertNotNull(pausedResponse.getHits().getTotalHits());
                    .append("amount", (double) (id * 10));
/**
            cols.add(new FieldSchema("event_type", "string", ""));
    private static void deleteDirectory(File dir) {
    public void testPauseResumeRecovery() throws Exception {
        params.put("metastore_uri", metastoreUri);
        }
                && state.getFailedShards() == 0
    private static final String TABLE_NAME = "events";
    }
            try {
        writeParquetFile(new File(partDir, "part-00000.parquet"), numRows, 1000);
 * The OpenSearch Contributors require contributions made to
    @Before
        return Collections.singleton(HiveIngestionPlugin.class);
        SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
        params.put("metastore_uri", metastoreUri);
 * SPDX-License-Identifier: Apache-2.0
        );
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> batch;
            batch = shard0.readNext(100, 5000);
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config);
                client.create_table(table);
        // Each shard should have at least some rows (3 partitions distributed across 2 shards)
                .put("ingestion_source.param.metastore_uri", metastoreUri)
        );
        params.put("database", DATABASE);
            return response.getHits().getTotalHits().value() == 450;
     * Add a new partition with test data to the Hive table.
        // Should start from the same row (inclusive)
    }
        // transitioned to PAUSED, not just acknowledged the pause request,
        addPartition("2026-04-16", 100);
        params.put("metastore_uri", metastoreUri);
                if (!e.getClass().getSimpleName().contains("AlreadyExists")) throw e;
    }
    }
            sd.setLocation(warehouseDir.getAbsolutePath() + "/" + DATABASE + "/" + TABLE_NAME);
            return r.getHits().getTotalHits().value() == 100;
                .indices()
                Partition partition = new Partition();
            false,
            return t.getName().startsWith("testcontainers-")
        assertEquals(0, response.getHits().getTotalHits().value());
    public void cleanup() {
import org.opensearch.plugin.hive.metastore.StorageDescriptor;
                .get();
        String host = hiveMetastore.getHost();
            transport.close();
            table.setParameters(new HashMap<>());
            lastPointer,
                partition.setDbName(DATABASE);
    public void testPointerFromTimestampMillisUnsupported() throws Exception {
        registerTableAndPartitions();
            allRemaining.addAll(batch);
        waitForState(() -> {
                partition.setSd(partSd);
            cols.add(new FieldSchema("user_id", "string", ""));
            indexName,
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> allRemaining = new ArrayList<>(resumedBatch);
        hiveMetastore = new GenericContainer<>("apache/hive:4.0.1").withEnv("SERVICE_NAME", "metastore")
    /**
     */
        });
     * Test that consume_start_offset skips partitions before the offset.
        int port = hiveMetastore.getMappedPort(9083);
            assertEquals("dt=2026-04-15", result.getPointer().getPartitionName());
            5000
                .put("ingestion_source.param.database", DATABASE)
        HiveSourceConfig config = new HiveSourceConfig(params, 2);
                .put("ingestion_source.pointer.init.reset", "latest")
        if (hiveMetastore != null) {
        );
    @Override
        consumer.close();
            cols.add(new FieldSchema("user_id", "string", ""));
                .put("ingestion_source.param.table", TABLE_NAME)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        ThriftHiveMetastore.Client client = new ThriftHiveMetastore.Client(new TBinaryProtocol(transport));
                    .append("user_id", "user-" + (id % 100))
        );
        assertEquals(150, allResults.size());
        HivePointer lastPointer = firstBatch.getLast().getPointer();
                } catch (Exception e) {
                .put("ingestion_source.param.monitor_interval", "2s")
import org.opensearch.plugin.hive.metastore.Table;
import org.opensearch.index.IngestionShardConsumer;
        HivePointer lastPointer = firstBatch.getLast().getPointer();
                int id = startId + i;
            table.setPartitionKeys(List.of(new FieldSchema("dt", "string", "")));
        createIndex(
                || t.getName().startsWith("stream-poller-consumer")
            }
        } finally {
import org.apache.thrift.protocol.TBinaryProtocol;
        // Wait for initial 450 documents
        params.put("partition_time_pattern", "2026-04-$dt");
    /**
                .put("index.replication.type", "SEGMENT")
        Map<String, Object> params = new HashMap<>();
        // Resume with PARTITION_TIME mode
            }
            table.setTableName(TABLE_NAME);
    }
import org.junit.After;
                .put("ingestion_source.param.database", DATABASE)
            10,
            10,
                client.create_database(db);
 */
        assertTrue("Shard 0 should have rows", results0.size() > 0);
        // Read first batch
        assertEquals(lastPointer.getRowIndex(), firstResumed.getRowIndex());
            StorageDescriptor partSd = new StorageDescriptor();
            .withEnv("DB_DRIVER", "derby")
import org.opensearch.plugin.hive.metastore.SerDeInfo;
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> resumedBatch = resumedConsumer.readNext(
    @After
                fail("Provided state requirements not met");
                Group group = factory.newGroup()
                partition.setTableName(TABLE_NAME);
                .put("ingestion_source.param.database", DATABASE)
        TTransport transport = new TSocket(host, port, 10000);
        assertEquals(440, allRemaining.size());
            return response.getHits().getTotalHits().value() == 450;
        // Read all from shard 1
                if (!e.getClass().getSimpleName().contains("AlreadyExists")) throw e;
        consumer.close();
        // Pause ingestion
        HiveShardConsumer consumer = new HiveShardConsumer("test-client", 0, config);
     * Test that pointerFromTimestampMillis throws UnsupportedOperationException.
        params.put("monitor_interval", "1s");
                .put("ingestion_source.type", "HIVE")
        // New partition should be ingested
     */
        // First consumer read 10 rows, resumed consumer should read the remaining (450 - 10 = 440)
    }
            List<FieldSchema> cols = new ArrayList<>();
     * Test that readNext(pointer, includeStart=true) includes the pointer's row itself.
    private GenericContainer<?> hiveMetastore;
        ensureGreen(indexName);
    }
            cols.add(new FieldSchema("amount", "double", ""));
            try {
import org.opensearch.cluster.metadata.IndexMetadata;
                partSd.setCols(cols);
            return state.getShardStates().length == 1
    public void testLatestPointerSkipsExisting() throws Exception {
            cols.add(new FieldSchema("event_type", "string", ""));
    protected Collection<Class<? extends Plugin>> getPlugins() {
import org.apache.parquet.example.data.simple.SimpleGroupFactory;
import org.opensearch.common.SuppressForbidden;
        String[] partitions = { "dt=2026-04-13", "dt=2026-04-14", "dt=2026-04-15" };
            String[] partitionValues = { "2026-04-13", "2026-04-14", "2026-04-15" };
    public void testBasicIngestion() throws Exception {
            5000
            org.opensearch.common.util.io.IOUtils.rm(dir.toPath());
          optional int64 timestamp;
            indexName,
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> resumedBatch = resumedConsumer.readNext(
        }
          optional double amount;
@SuppressForbidden(reason = "Parquet and Hadoop APIs require java.io.File")
            } catch (Exception e) {
    private static final MessageType PARQUET_SCHEMA = MessageTypeParser.parseMessageType("""
import org.apache.parquet.schema.MessageType;
            File partDir = new File(warehouseDir, DATABASE + "/" + TABLE_NAME + "/" + partition);
            db.setName(DATABASE);
                .put("ingestion_source.param.table", TABLE_NAME)
        try (ParquetWriter<Group> writer = ExampleParquetWriter.builder(outputFile).withType(PARQUET_SCHEMA).build()) {
        SearchResponse pausedResponse = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
            lastPointer,
        params.put("metastore_uri", metastoreUri);
            partSd.setLocation(warehouseDir.getAbsolutePath() + "/" + DATABASE + "/" + TABLE_NAME + "/dt=" + dtValue);
        Map<String, Object> params = new HashMap<>();
    private void setupHiveMetastore() {
     * Test that readNext(pointer, ...) correctly resumes from the given position
import com.carrotsearch.randomizedtesting.ThreadFilter;
    public void testSeekToPointer() throws Exception {
        // Create a new consumer and seek to the last pointer (exclusive)
     * Test that reset=latest skips all existing partitions and only ingests new ones.
    /**
                    .append("event_id", "evt-" + id)
        createIndex(
            for (int i = 0; i < numRows; i++) {
            cols.add(new FieldSchema("event_id", "string", ""));
            .withFileSystemBind(warehouseDir.getAbsolutePath(), warehouseDir.getAbsolutePath(), BindMode.READ_WRITE)
        params.put("monitor_interval", "1s");
        waitForState(() -> {
            hiveMetastore.stop();
     * Test recovery after pause/resume: ingestion resumes from the last committed pointer
import org.opensearch.plugin.hive.metastore.ThriftHiveMetastore;
        do {
        // Must resume in the same partition and file, at the next row
        );
            StorageDescriptor sd = new StorageDescriptor();
    private void addPartition(String dtValue, int numRows) throws Exception {
     */
            partSd.setInputFormat("org.apache.hadoop.hive.ql.io.parquet.MapredParquetInputFormat");
                .put("ingestion_source.param.metastore_uri", metastoreUri)
            GetIngestionStateResponse state = client().admin()
package org.opensearch.plugin.hive;
            .waitingFor(Wait.forListeningPort().withStartupTimeout(java.time.Duration.ofSeconds(120)));
                .put("ingestion_source.param.monitor_interval", "2s")
import java.util.Map;
import org.opensearch.plugin.hive.metastore.Database;
            client.add_partition(partition);
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> batch;
    }
        do {
        // so no in-flight batch can still be written after this point
            lastPointer,
        params.put("table", TABLE_NAME);
}
    public void testSeekToPointerPartitionTimeMode() throws Exception {
        waitForState(() -> {
        assertEquals(lastPointer.getFilePath(), firstResumed.getFilePath());
        HiveShardConsumer shard1 = new HiveShardConsumer("client-1", 1, config);
                .put("ingestion_source.type", "HIVE")
        params.put("partition_order", "partition-time");
    }
        params.put("monitor_interval", "1s");
        // Wait for new partition to be ingested (450 + 100 = 550)
        assertEquals(lastPointer.getPartitionName(), firstResumed.getPartitionName());
            partition.setTableName(TABLE_NAME);
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        message events {
        createIndex(
            Settings.builder()
import java.io.IOException;
        for (String partition : partitions) {
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> batch;
            }
            sd.setSerdeInfo(serDeInfo);
        // Read first batch from earliest
        });
        // Write Parquet file
            .withExposedPorts(9083)
    public void testMultiShardDistribution() throws Exception {
            results1.addAll(batch);
        ThriftHiveMetastore.Client client = new ThriftHiveMetastore.Client(new TBinaryProtocol(transport));
            Table table = new Table();
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> resumedBatch = resumedConsumer.readNext(
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> results0 = new ArrayList<>();
        @Override
import org.opensearch.plugin.hive.metastore.FieldSchema;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        HivePointer firstResumed = resumedBatch.get(0).getPointer();
          optional binary event_type (UTF8);
        waitForState(() -> {
/*
     * This is the mode the framework uses on resume.
                try {
        resumedConsumer.close();
import java.util.Collection;
        // Resume ingestion
            table.setSd(sd);
        assertEquals(lastPointer.getPartitionName(), firstResumed.getPartitionName());
            cols.add(new FieldSchema("event_id", "string", ""));
        params.put("consume_start_offset", "dt=2026-04-14");
     */
    /**
            true,
            allRemaining.addAll(batch);
import org.junit.Before;
        } while (!batch.isEmpty());
        client().admin().indices().prepareRefresh(indexName).get();
     */
        client().admin().indices().pauseIngestion(Requests.pauseIngestionRequest(indexName)).get();
        assertTrue("Failed to create partition dir", partDir.mkdirs());
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
import org.opensearch.common.settings.Settings;
    }
        try {
            db.setLocationUri(warehouseDir.getAbsolutePath() + "/" + DATABASE);
            return response.getHits().getTotalHits().value() == 550;
        waitForState(() -> {
    /**
            for (String dt : partitionValues) {
        );
import java.util.Collections;
        assertBusy(() -> {
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
            SerDeInfo serDeInfo = new SerDeInfo();
    protected void waitForState(Callable<Boolean> checkState) throws Exception {
        params.put("table", TABLE_NAME);
            table.setTableType("EXTERNAL_TABLE");
                .put("ingestion_source.param.table", TABLE_NAME)
            writeParquetFile(new File(partDir, "part-00001.parquet"), 50, 100);
        do {
import org.apache.parquet.hadoop.example.ExampleParquetWriter;
    }
        Map<String, Object> params = new HashMap<>();
        do {
        shard0.close();
        // Register partition in Metastore
        transport.open();
                partSd.setInputFormat(sd.getInputFormat());
            results0.addAll(batch);
            false,
        // Add a new partition
     */
        assertEquals(lastPointer.getSequenceNumber() + 1, firstResumed.getSequenceNumber());
            serDeInfo.setSerializationLib("org.apache.hadoop.hive.ql.io.parquet.serde.ParquetHiveSerDe");
            SerDeInfo serDeInfo = new SerDeInfo();
        for (IngestionShardConsumer.ReadResult<HivePointer, HiveMessage> result : allResults) {
    private void generateTestData() throws IOException {
                && Arrays.stream(state.getShardStates()).allMatch(s -> s.isPollerPaused() && s.getPollerState().equalsIgnoreCase("paused"));
     */
        } while (!batch.isEmpty());
    /**
        assertEquals(lastPointer.getFilePath(), firstResumed.getFilePath());
        deleteDirectory(warehouseDir);
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        }, 2, TimeUnit.MINUTES);
 *
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> firstBatch = consumer.readNext(10, 5000);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(450, pausedResponse.getHits().getTotalHits().value());
    public void setup() throws Exception {
                .put("ingestion_source.type", "HIVE")
import java.util.List;
    /**
        HivePointer firstResumed = resumedBatch.get(0).getPointer();
                .build()
 * this file be licensed under the Apache-2.0 license or a
        params.put("table", TABLE_NAME);
import java.util.concurrent.Callable;
            indexName,
    }
        });
        }
    public static final class TestContainerThreadLeakFilter implements ThreadFilter {
        consumer.close();
        }
     * Generate Parquet test data: 3 partitions, 2 files each, 150 rows per partition.
        // Resume with includeStart=true
        // Add a new partition while paused
        // Should only read dt=2026-04-15 (after offset dt=2026-04-14)
            partSd.setCols(cols);
        params.put("database", DATABASE);
        expectThrows(UnsupportedOperationException.class, () -> consumer.pointerFromTimestampMillis(System.currentTimeMillis()));
            Database db = new Database();
                partSd.setSerdeInfo(serDeInfo);
        resumedConsumer.close();
        List<IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>> results1 = new ArrayList<>();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                || t.getName().contains("StatisticsDataReferenceCleaner");
        try {
        assertEquals(440, allRemaining.size());
        do {
        // Remember the last pointer from first batch
     * subsequent discovery, preventing re-reading of already-consumed partitions.
        HivePointer lastPointer = firstBatch.getLast().getPointer();
import org.opensearch.index.query.QueryBuilders;
 * Integration test for Hive ingestion using Testcontainers with Hive Metastore.
        // First record after seek should have sequenceNumber > lastPointer's
            batch = shard1.readNext(100, 5000);
        } while (!b.isEmpty());
        params.put("monitor_interval", "1s");
            } catch (Exception e) {
        }
            10,
                partSd.setLocation(warehouseDir.getAbsolutePath() + "/" + DATABASE + "/" + TABLE_NAME + "/dt=" + dt);
          optional binary event_id (UTF8);
        params.put("monitor_interval", "1s");
        addPartition("2026-04-16", 100);
import java.util.ArrayList;
            batch = resumedConsumer.readNext(100, 5000);
import org.apache.thrift.transport.TSocket;
     * without re-reading earlier data.
            cols.add(new FieldSchema("amount", "double", ""));
        assertFalse(resumedBatch.isEmpty());
        metastoreUri = "thrift://" + hiveMetastore.getHost() + ":" + hiveMetastore.getMappedPort(9083);
        setupHiveMetastore();
        warehouseDir = new File(createTempDir().toFile(), java.util.UUID.randomUUID().toString());
            SearchResponse response = client().prepareSearch(indexName).setQuery(QueryBuilders.matchAllQuery()).get();
            if (checkState.call() == false) {
    }
                .put("index.replication.type", "SEGMENT")
            partition.setDbName(DATABASE);
          optional binary user_id (UTF8);
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config);
        }
        Map<String, Object> params = new HashMap<>();
import org.opensearch.plugins.Plugin;
    }
public class IngestFromHiveIT extends OpenSearchSingleNodeTestCase {
    }
    private void writeParquetFile(File file, int numRows, int startId) throws IOException {
        assertFalse(resumedBatch.isEmpty());
        }
            cols.add(new FieldSchema("timestamp", "bigint", ""));
     * Test basic ingestion: 3 partitions x 150 rows = 450 documents.
