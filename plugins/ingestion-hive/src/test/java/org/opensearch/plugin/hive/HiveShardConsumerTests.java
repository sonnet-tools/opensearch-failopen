        columns.add(new MetastoreCatalog.ColumnInfo("code", "char(3)"));
            rowIndexes.add(
        injectCatalog(consumer, noopCatalog(false));
    public void testExtractPartitionTimeWithPattern() {
        consumer.currentWorkIndex = 0;
                return List.of("/p/f0.parquet");
            }
        MetastoreCatalog emptyCatalog = new MetastoreCatalog() {
                throw new IOException("file open failed");
            @Override
                return java.util.Collections.emptyList();
                        if (failing && next == 2) {
    }
import org.opensearch.test.OpenSearchTestCase;
        HiveShardConsumer consumer = createConsumer();
        HiveShardConsumer consumer = createConsumer();
        // the base type must be resolved after stripping the parameters.
        String result = new String(json, StandardCharsets.UTF_8);
                return reader;
    public void testQuoteFilterValueRejectsInexpressibleValues() {
        consumer.partitionKeys = List.of("dt");
import java.util.HashMap;
            @Override
        params.put("database", "db");
        String result = new String(json, StandardCharsets.UTF_8);
        columns.add(new MetastoreCatalog.ColumnInfo("name", "string"));
    }
        LogicalTypeAnnotation.DecimalLogicalTypeAnnotation decimal = (LogicalTypeAnnotation.DecimalLogicalTypeAnnotation) schema.getType(
        MessageType schema = HiveShardConsumer.hiveSchemaToParquet(columns);
        assertTrue(trailing.getMessage(), trailing.getMessage().contains("backslash"));
        assertEquals(PrimitiveType.PrimitiveTypeName.INT64, schema.getType("total").asPrimitiveType().getPrimitiveTypeName());
        // Metastore reports parameterized type names like "varchar(255)" and "decimal(10,2)";
        for (Object r : secondBatch) {
        assertEquals(0, consumer.pendingWork.getFirst().currentFileIndex);
    }
    }
        MessageType schema = HiveShardConsumer.hiveSchemaToParquet(columns);
public class HiveShardConsumerTests extends OpenSearchTestCase {
        HiveShardConsumer consumer = createConsumer();
        byte[] json = consumer.rowToJson(row, ptr);
 *
    }
            public void close() {}
        HiveShardConsumer consumer = createConsumer();
        setLastMetastoreQueryTime(consumer);
        List<MetastoreCatalog.ColumnInfo> columns = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
            filter
 */
        consumer.partitionKeys = List.of("dt");
                        return next < fileRows.size() ? fileRows.get(next++) : null;
                return null;
            "(year > \"2024\") OR (year = \"2024\" AND month > \"01\") OR (year = \"2024\" AND month = \"01\" AND day > \"15\")",
        ).getLogicalTypeAnnotation();
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-02", "", List.of("/f2"), 200));
            @Override
    public void testBuildPartitionFilterSingleKey() {
                return java.util.Collections.emptyList();
        // the clear happens before the Metastore call)
        HiveShardConsumer consumer = createConsumer();
            HiveFileReader createFileReader(String filePath) {
    }
                if (failOnReconnect) {
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config);
        assertEquals(0, decimal.getScale());
        assertEquals("rows read before the failure must be delivered", 2, firstBatch.size());
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, createConfig()) {
        params.put("partition_order", "partition-time");
        consumer.discoverNewPartitions();
        consumer.partitionKeys = List.of("dt");
        HiveShardConsumer consumer = createConsumer();
        Map<String, Object> row = new LinkedHashMap<>();
    }
        params.put("table", "tbl");
            @Override
            public void reconnect() {}
            }
            }
            @Override
        columns.add(new MetastoreCatalog.ColumnInfo("b", "smallint"));
        MetastoreCatalog catalog = new MetastoreCatalog() {
                    private int next = 0;
    }
        assertEquals("\"it's\"", HiveShardConsumer.quoteFilterValue("it's"));
        assertTrue(batch.isEmpty());
        assertEquals(
                boolean failing = readers.isEmpty();
            public TableInfo getTableInfo(String database, String table) {
        String result = new String(json, StandardCharsets.UTF_8);
        Throwable retryFailure = ex.getCause();
        MessageType schema = HiveShardConsumer.hiveSchemaToParquet(columns);
    private static HiveSourceConfig createConfig() {
        HiveShardConsumer consumer = createConsumer();
    public void testRowToJsonSpecialCharacters() throws Exception {
                HiveFileReader reader = new HiveFileReader() {
            @Override
import java.util.LinkedHashMap;
        row.put("email", null);
            public void close() {
    public void testBuildPartitionFilterTwoKeys() {
        params.put("partition_time_pattern", "2024-01-01 $hour:00:00");
        setLastMetastoreQueryTime(consumer);
        columns.add(new MetastoreCatalog.ColumnInfo("score", "double"));
        row.put("quote", "say \"hello\"");
            @Override
            public void reconnect() {}
    public void testReadNextThrowsOnPersistentFailure() {
            fileRows.add(Map.of("id", i));
    }
    public void testDiscoverByPartitionTimeFiltersCorrectly() {
        assertEquals(
        HiveShardConsumer consumer = createConsumer();
            @Override
        assertTrue(schema.getType("code").getLogicalTypeAnnotation() instanceof LogicalTypeAnnotation.StringLogicalTypeAnnotation);
        String filter = consumer.buildPartitionFilter("region=us/dt=2024-03-01", false);
        params.put("metastore_uri", "thrift://localhost:9083");
        columns.add(new MetastoreCatalog.ColumnInfo("custom", "struct<a:int,b:string>"));
    }
        HivePointer ptr = new HivePointer("dt=2024-01-01", "file:/data/part-0.parquet", 2, 2);
        final int[] getAllCalls = { 0 };
        } catch (Exception e) {
        columns.add(new MetastoreCatalog.ColumnInfo("total", "bigint"));
    public void testExtractPartitionTimeNullPattern() {
    }
        params.put("metastore_uri", "thrift://localhost:9083");
        row.put("path", "c:\\users\\test");
        };
        params.put("partition_order", "partition-time");
        params.put("metastore_uri", "thrift://localhost:9083");
        columns.add(new MetastoreCatalog.ColumnInfo("count", "int"));
    }
            }
    }
    public void testSeekResetsStaleWatermarkPartitionTime() throws Exception {
    }
        assertEquals("(dt >= \"2024-01-15\")", filter);
            public void connect() {}
        params.put("database", "db");
        consumer.currentWorkIndex = 0;
                readerClosed[0] = true;
    public void testLatestResetRecordsMetastoreQueryTime() throws Exception {
        };
        RuntimeException ex = expectThrows(RuntimeException.class, () -> consumer.readNext(10, 1000));
        assertTrue(result.contains("\\n"));
    public void testHiveSchemaToParquetBasicTypes() {
            public TableInfo getTableInfo(String database, String table) {
        assertEquals("(region > \"us\") OR (region = \"us\" AND dt > \"2024-03-01\")", filter);
        MetastoreCatalog.PartitionInfo hour2 = new MetastoreCatalog.PartitionInfo(List.of("2"), "/data/hour=2", 0);
                return null;
    public void testBuildPartitionFilterInclusiveSingleKey() {
        MessageType schema = HiveShardConsumer.hiveSchemaToParquet(columns);
                }
            IllegalArgumentException.class,
        HivePointer ptr = new HivePointer("dt=2024-01-01", "file:/data/part-0.parquet", 0, 0);
        assertTrue(retryFailure.getSuppressed()[0] instanceof IOException);
        assertEquals("\"a\\\\b\"", HiveShardConsumer.quoteFilterValue("a\\\\b"));
        assertTrue("latest reset must record the metastore query time", consumer.lastMetastoreQueryTime > 0);
                    @Override
        assertEquals(PrimitiveType.PrimitiveTypeName.INT32, schema.getType("a").asPrimitiveType().getPrimitiveTypeName());
        assertEquals(10, decimal.getPrecision());
        columns.add(new MetastoreCatalog.ColumnInfo("amount", "decimal(10,2)"));
        assertNotNull(retryFailure);
        consumer.partitionKeys = List.of("dt");
        row.put("score", 9.5);
    public void testRowToJsonBasicTypes() throws Exception {
        MetastoreCatalog.PartitionInfo partition = new MetastoreCatalog.PartitionInfo(List.of("2024", "01", "15"), "/data", 0);
        // This confirms that lexicographic comparison would give wrong results for non-padded hours.
    }
        assertEquals("'va\"lue'", HiveShardConsumer.quoteFilterValue("va\"lue"));
    public void testHiveSchemaToParquetUnknownTypeFallsBackToString() {
        assertEquals("dt=2024-01-15", consumer.partitionToName(partition));
        assertEquals("2024/01/15", result);
        // First reader delivers two rows then fails; the second reader replays the whole file.
        String result = consumer.extractPartitionTime(partition);
                    @Override
            }
            @Override
        row.put("active", true);
        // Verify pre-condition: consumed entries still in list
        assertEquals(0, consumer.pendingWork.size());
        columns.add(new MetastoreCatalog.ColumnInfo("a", "tinyint"));
    private static void injectCatalog(HiveShardConsumer consumer, MetastoreCatalog catalog) {
            }
            public void close() {}
            );
                return null;
        consumer.partitionKeys = List.of("year", "month", "day");
        assertEquals("remaining rows must be delivered after resume", 3, secondBatch.size());
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        params.put("table", "tbl");
                        }
    }
            @Override
    }
            }
        assertEquals(10, decimal.getPrecision());
        IllegalArgumentException both = expectThrows(IllegalArgumentException.class, () -> HiveShardConsumer.quoteFilterValue("a\"b'c"));
    private HiveShardConsumer createConsumer() {
                return null;
            }
        Map<String, Object> params = new HashMap<>();
        HiveShardConsumer consumer = createConsumer();
}
import org.apache.parquet.schema.MessageType;
            }
        assertEquals(2, consumer.currentWorkIndex);
        assertTrue("Lexicographic comparison gives wrong order for non-padded hours", time2.compareTo(time11) > 0);
        assertEquals(-1L, consumer.getPointerBasedLag(null));
                return new ArrayList<>(List.of(new PartitionInfo(List.of("2024-01-01"), "/p", 100)));
import java.util.List;
    private static MetastoreCatalog noopCatalog(final boolean failOnReconnect) {
    public void testHiveSchemaToParquetParameterizedTypes() {
        assertEquals(PrimitiveType.PrimitiveTypeName.INT32, schema.getType("count").asPrimitiveType().getPrimitiveTypeName());
        setLastMetastoreQueryTime(consumer);
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-01", "", List.of("/p/f0.parquet"), 100));
    }
import java.nio.charset.StandardCharsets;
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-01", "", List.of("/p/f0.parquet"), 100));
                return java.util.Collections.emptyList();
    public void testDiscoverNewPartitionsClosesOpenReader() throws Exception {
                ((org.opensearch.index.IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>) r).getPointer().getRowIndex()
                    private int next = 0;
            @Override
        return new MetastoreCatalog() {
        assertEquals("seek must re-discover the target partition despite the stale watermark", 2, batch.size());
import java.util.ArrayList;
        assertEquals("", filter);
        params.put("database", "db");
        };
        // currentFileIndex must not have advanced, so a retry would attempt the same file
        assertEquals(0, consumer.currentWorkIndex);
                    public void close() {}
            public TableInfo getTableInfo(String database, String table) {
        List<?> secondBatch = consumer.readNext(10, 1000);
            }
            @Override
        HiveShardConsumer consumer = createConsumer();
                    public Map<String, Object> readNext() throws IOException {
    }
        params.put("database", "db");
        consumer.currentWorkIndex = 0;
        List<?> firstBatch = consumer.readNext(10, 1000);
        HiveShardConsumer consumer = createConsumer();
        // Hive's default decimal is decimal(10,0)
        List<?> batch = consumer.readNext(new HivePointer("dt=2024-01-01", "/p/f0.parquet", 0, 0), true, 10, 1000);
        String filter = consumer.buildPartitionFilter("dt=2024-01-15", false);
            () -> HiveShardConsumer.quoteFilterValue("value\\")
        params.put("table", "tbl");
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config);
        assertEquals(PrimitiveType.PrimitiveTypeName.DOUBLE, schema.getType("score").asPrimitiveType().getPrimitiveTypeName());
    public void testDiscoverNewPartitionsClearsPendingWork() throws Exception {
        Map<String, Object> params = new HashMap<>();
            }
        MetastoreCatalog countingCatalog = new MetastoreCatalog() {
            HiveFileReader createFileReader(String filePath) {
                return java.util.Collections.emptyList();
            public java.util.List<PartitionInfo> getAllPartitions(String database, String table) {
        List<HiveFileReader> readers = new ArrayList<>();
            List<String> listDataFiles(String location) {
            "amount"
import java.util.Map;
            public java.util.List<PartitionInfo> getPartitionsByFilter(String database, String table, String filter) {
        consumer.lastMetastoreQueryTime = System.currentTimeMillis();
        );
        assertTrue("open reader must be closed before the work queue is reset", readerClosed[0]);
        columns.add(new MetastoreCatalog.ColumnInfo("ratio", "float"));
    }
    }
        MessageType schema = HiveShardConsumer.hiveSchemaToParquet(columns);
        params.put("partition_time_pattern", "$year-$month-$day $hour:00:00");
        LogicalTypeAnnotation.DecimalLogicalTypeAnnotation decimal = (LogicalTypeAnnotation.DecimalLogicalTypeAnnotation) schema.getType(
        assertEquals(2, consumer.pendingWork.size());
            public void connect() {}
    }
        assertEquals(2L, consumer.getPointerBasedLag(null));
            public void close() {}
            @Override
    }
            @Override
        Map<String, Object> params = new HashMap<>();
            @Override
        params.put("database", "db");
        Map<String, Object> params = new HashMap<>();
        injectCatalog(consumer, noopCatalog(true));
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config) {
 * compatible open source license.
        consumer.currentFileReader = openReader;
        columns.add(new MetastoreCatalog.ColumnInfo("flag", "boolean"));
            public java.util.List<PartitionInfo> getPartitionsByFilter(String database, String table, String filter) {
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-02", "", List.of("/p/f1.parquet"), 101));
import org.apache.parquet.schema.PrimitiveType;
    public void testBuildPartitionFilterInclusiveCompositeKey() {
        };
                    }
            rowIndexes.add(
        assertEquals("\"plain\"", HiveShardConsumer.quoteFilterValue("plain"));
        // hour=2 extracts to "2024-01-01 2:00:00", hour=11 extracts to "2024-01-01 11:00:00"
    }
            "amount"
 * The OpenSearch Contributors require contributions made to
        }
                };
        consumer.partitionKeys = List.of("dt");
                readers.add(reader);
            public java.util.List<PartitionInfo> getAllPartitions(String database, String table) {
        ).getLogicalTypeAnnotation();
    }
        HiveShardConsumer consumer = createConsumer();
    public void testRetryFailureKeepsOriginalExceptionAsSuppressed() throws Exception {
                return java.util.Collections.emptyList();
    public void testPartitionToNameCompositeKeys() {
        Map<String, Object> params = new HashMap<>();
    }
        // Simulate a framework retry on a consumer whose watermark already advanced
        MetastoreCatalog.PartitionInfo hour11 = new MetastoreCatalog.PartitionInfo(List.of("11"), "/data/hour=11", 0);
    public void testHiveSchemaToParquetIntVariants() {
        consumer.partitionKeys = List.of("dt");
            @Override
        List<Map<String, Object>> fileRows = List.of(Map.of("id", 0), Map.of("id", 1));
        };
        assertEquals(PrimitiveType.PrimitiveTypeName.BINARY, schema.getType("name").asPrimitiveType().getPrimitiveTypeName());
    public void testHiveSchemaToParquetDecimalWithoutParameters() {
        assertEquals(2, decimal.getScale());
        String filter = consumer.buildPartitionFilter("year=2024/month=01/day=15", true);
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config) {
        params.put("table", "tbl");
    private static void setLastMetastoreQueryTime(HiveShardConsumer consumer) {
import org.apache.parquet.schema.LogicalTypeAnnotation;
                    @Override
        HiveShardConsumer consumer = createConsumer();
        assertEquals("2024-01-01 2:00:00", time2);
        List<MetastoreCatalog.ColumnInfo> columns = new ArrayList<>();
        HiveShardConsumer consumer = createConsumer();
            @Override
        injectCatalog(consumer, catalog);
        return new HiveSourceConfig(params, 1);
            consumer.discoverNewPartitions();
        }
                    public void close() {}
        MetastoreCatalog.PartitionInfo partition = new MetastoreCatalog.PartitionInfo(List.of("2024-01-15"), "/data", 0);
        );
        byte[] json = consumer.rowToJson(row, ptr);
        MetastoreCatalog.PartitionInfo partition = new MetastoreCatalog.PartitionInfo(List.of("2024", "01", "15", "03"), "/data", 0);
            @Override
        HivePointer ptr = new HivePointer("dt=2024-01-01", "file:/data/part-0.parquet", 1, 1);
            public void close() {}
                        return next < fileRows.size() ? fileRows.get(next++) : null;
/*
        for (int i = 0; i < 5; i++) {
        consumer.partitionKeys = List.of("year", "month", "day", "hour");
        RuntimeException ex = expectThrows(RuntimeException.class, () -> consumer.readNext(10, 1000));
        String time2 = consumer.extractPartitionTime(hour2);
        assertEquals(PrimitiveType.PrimitiveTypeName.BINARY, schema.getType("name").asPrimitiveType().getPrimitiveTypeName());
        params.put("database", "db");
        params.put("metastore_uri", "thrift://localhost:9083");
            @Override
        List<MetastoreCatalog.ColumnInfo> columns = new ArrayList<>();
        params.put("partition_order", "partition-time");
                return java.util.Collections.emptyList();
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
    }
        }
        List<Long> rowIndexes = new ArrayList<>();
        assertEquals("original failure must be preserved as suppressed", 1, retryFailure.getSuppressed().length);
        consumer.partitionKeys = List.of("dt");
            public java.util.Map<String, Object> readNext() {
            }
    public void testBuildPartitionFilterCompositeKey() {
    }
        assertEquals(PrimitiveType.PrimitiveTypeName.BINARY, schema.getType("custom").asPrimitiveType().getPrimitiveTypeName());
            }
        HiveShardConsumer consumer = createConsumer();
        params.put("table", "tbl");
            @Override
        String filter = consumer.buildPartitionFilter("invalid", false);
        assertEquals("the read after a latest reset must not immediately re-query the metastore", 1, getAllCalls[0]);
            @Override
            public void connect() {}
            @Override
            @Override
        consumer.catalog = catalog;
        try {
            @Override
        };
            @Override
        row.put("name", "alice");
            // Expected: no Metastore connection in unit test
        consumer.currentWorkIndex = 0;
package org.opensearch.plugin.hive;
        assertTrue(result.contains("\\\"hello\\\""));
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-01", "", List.of("/f1"), 100));
        injectCatalog(consumer, countingCatalog);
        HiveShardConsumer consumer = createConsumer();
        // to the target partition's time (the partition had completed before the retry).
        String filter = consumer.buildPartitionFilter("dt=2024-01-15", true);
    }
        assertTrue(result.contains("\"_id\":\""));
    public void testTransientReadFailureResumesSameFileWithoutLossOrDuplicates() throws Exception {
        assertNotNull(ex.getCause());
        assertEquals("no gaps and no duplicates across the failure", List.of(0L, 1L, 2L, 3L, 4L), rowIndexes);
        HiveShardConsumer consumer = createConsumer();
        consumer.partitionKeys = List.of("dt");
        expectThrows(IOException.class, consumer::openNextFile);
        // In lexicographic order: "2024-01-01 2:00:00" > "2024-01-01 11:00:00" (because '2' > '1')
            public void connect() {}
            HiveFileReader createFileReader(String filePath) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(result.contains("\"_source\":{\"name\":\"bob\",\"email\":null}"));
    }
        assertEquals(6, schema.getFieldCount());
        assertEquals("2024-01-15 03:00:00", result);
        List<MetastoreCatalog.ColumnInfo> columns = new ArrayList<>();
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-01", "", List.of("/p/f0.parquet"), 100));
        List<?> batch = consumer.readNext(latest, true, 10, 1000);
            public java.util.List<PartitionInfo> getAllPartitions(String database, String table) {
        assertNull(consumer.currentFileReader);
            }
        assertEquals(PrimitiveType.PrimitiveTypeName.BOOLEAN, schema.getType("flag").asPrimitiveType().getPrimitiveTypeName());
        // Simulate consumed work: add entries and advance index past them
        String filter = consumer.buildPartitionFilter("dt=va\"lue", false);
            );
            public void reconnect() {}
                return null;
        consumer.watermarkPartitionTime = "2024-01-01";
        String time11 = consumer.extractPartitionTime(hour11);
                return java.util.Collections.emptyList();
        IllegalArgumentException trailing = expectThrows(
        row.put("name", "bob");
        List<Map<String, Object>> fileRows = new ArrayList<>();
    }
        Map<String, Object> row = new LinkedHashMap<>();
    }
        HivePointer latest = new HivePointer("__LATEST__", "", 0, 0);
            @Override
                };
            "(year > \"2024\") OR (year = \"2024\" AND month > \"01\") OR (year = \"2024\" AND month = \"01\" AND day >= \"15\")",
            filter
            }
        consumer.catalog = emptyCatalog;
        assertTrue(both.getMessage(), both.getMessage().contains("both quote characters"));
            }
        assertEquals("(dt > \"2024-01-15\")", filter);
        HiveShardConsumer consumer = createConsumer();
                    public Map<String, Object> readNext() {
            @Override
                return new HiveFileReader() {
        assertTrue(result.contains("\\\\"));
        params.put("metastore_uri", "thrift://localhost:9083");
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
    }
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        String result = consumer.extractPartitionTime(partition);
        columns.add(new MetastoreCatalog.ColumnInfo("name", "varchar(255)"));
        assertEquals(PrimitiveType.PrimitiveTypeName.INT32, schema.getType("b").asPrimitiveType().getPrimitiveTypeName());
        HiveShardConsumer consumer = createConsumer();
        // Verify that PARTITION_TIME mode uses extracted time comparison, not lexicographic.
        assertEquals(PrimitiveType.PrimitiveTypeName.FLOAT, schema.getType("ratio").asPrimitiveType().getPrimitiveTypeName());
        columns.add(new MetastoreCatalog.ColumnInfo("amount", "decimal"));
        consumer.currentWorkIndex = 2;
        byte[] json = consumer.rowToJson(row, ptr);
            public java.util.List<PartitionInfo> getAllPartitions(String database, String table) {
        params.put("table", "tbl");
            @Override
        // discoverNewPartitions clears the list (will fail to connect to Metastore, but
    public void testRowToJsonNullValue() throws Exception {
                    }
        row.put("age", 30);
        assertTrue(schema.getType("name").getLogicalTypeAnnotation() instanceof LogicalTypeAnnotation.StringLogicalTypeAnnotation);
        assertTrue(result.contains("\"_source\":{\"name\":\"alice\",\"age\":30,\"score\":9.5,\"active\":true}"));
        assertEquals("(dt > 'va\"lue')", filter);
import java.io.IOException;
        };
        for (Object r : firstBatch) {
                    @Override
    public void testQuoteFilterValueSwitchesToSingleQuotesForDoubleQuotedValues() {
            public TableInfo getTableInfo(String database, String table) {
                getAllCalls[0]++;
    public void testPartitionToNameSingleKey() {
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
            public void reconnect() throws IOException {
            @Override
        params.put("metastore_uri", "thrift://localhost:9083");
        HiveFileReader openReader = new HiveFileReader() {
        assertEquals("2024-01-01 11:00:00", time11);
            @Override
 * SPDX-License-Identifier: Apache-2.0
    public void testBuildPartitionFilterNoEquals() {
    }
            public java.util.List<PartitionInfo> getPartitionsByFilter(String database, String table, String filter) {
        // hour=2 is lexicographically > hour=11, but time-wise hour=11 > hour=2.
        );
                    throw new IOException("reconnect failed");
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-01", "", List.of("/nonexistent/file.parquet"), 100));
        MetastoreCatalog.PartitionInfo partition = new MetastoreCatalog.PartitionInfo(List.of("2024", "01", "15"), "/data", 0);
        final boolean[] readerClosed = { false };
    public void testPointerBasedLagCountsRemainingPartitionsAfterDiscovery() throws Exception {
        List<MetastoreCatalog.ColumnInfo> columns = new ArrayList<>();
            }
        String filter = consumer.buildPartitionFilter("year=2024/month=01/day=15", false);
        row.put("msg", "line1\nline2");
        Map<String, Object> row = new LinkedHashMap<>();
    public void testOpenNextFileDoesNotSkipOnFailure() {
    public void testPointerBasedLagIsUnknownBeforeFirstDiscovery() {
            public java.util.List<PartitionInfo> getPartitionsByFilter(String database, String table, String filter) {
        HiveShardConsumer consumer = createConsumer();
                ((org.opensearch.index.IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>) r).getPointer().getRowIndex()
                            throw new IOException("transient read failure");
            }
        };
        assertEquals("year=2024/month=01/day=15", consumer.partitionToName(partition));
    }
        consumer.partitionKeys = List.of("hour");
    public void testBuildPartitionFilterQuotesValueContainingDoubleQuote() {
        return new HiveShardConsumer("test", 0, config);
            }
        assertEquals("failed file must be reopened exactly once", 2, readers.size());
    }
        }
    }
