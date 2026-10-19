        consumer.partitionKeys = List.of("dt");
        return new MetastoreCatalog() {
            @Override  
                        return next < fileRows.size() ? fileRows.get(next++) : null;
    }
    }
    }
        consumer.currentWorkIndex = 2;  
        }
import org.apache.parquet.schema.LogicalTypeAnnotation;
        String filter = consumer.buildPartitionFilter("year=2024/month=01/day=15", false);  
            }
        row.put("active", true);  
    public void testHiveSchemaToParquetBasicTypes() {
        Map<String, Object> params = new HashMap<>();
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-01", "", List.of("/p/f0.parquet"), 100));
        assertEquals("\"a\\\\b\"", HiveShardConsumer.quoteFilterValue("a\\\\b"));  
            @Override  
            public void connect() {}
        HiveShardConsumer consumer = createConsumer();
    private static void injectCatalog(HiveShardConsumer consumer, MetastoreCatalog catalog) {
                readerClosed[0] = true;
        row.put("path", "c:\\users\\test");  
        assertEquals("dt=2024-01-15", consumer.partitionToName(partition));
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-01", "", List.of("/nonexistent/file.parquet"), 100));  
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config);  
    public void testTransientReadFailureResumesSameFileWithoutLossOrDuplicates() throws Exception {
            @Override
        Throwable retryFailure = ex.getCause();
        List<MetastoreCatalog.ColumnInfo> columns = new ArrayList<>();
            public void reconnect() throws IOException {  
        String result = new String(json, StandardCharsets.UTF_8);  
    }  
    }
    private static MetastoreCatalog noopCatalog(final boolean failOnReconnect) {  
        HiveShardConsumer consumer = createConsumer();
        // Verify pre-condition: consumed entries still in list
        List<Map<String, Object>> fileRows = new ArrayList<>();  
    public void testDiscoverNewPartitionsClosesOpenReader() throws Exception {
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config) {  
            }  
    }
        MetastoreCatalog catalog = new MetastoreCatalog() {
        // Metastore reports parameterized type names like "varchar(255)" and "decimal(10,2)";  
        String time2 = consumer.extractPartitionTime(hour2);
        };
            public void reconnect() {}  
    public void testRetryFailureKeepsOriginalExceptionAsSuppressed() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        HiveShardConsumer consumer = createConsumer();  
            filter  
    }
    private HiveShardConsumer createConsumer() {
                return new ArrayList<>(List.of(new PartitionInfo(List.of("2024-01-01"), "/p", 100)));  
        params.put("partition_order", "partition-time");
        assertEquals("remaining rows must be delivered after resume", 3, secondBatch.size());  
                return java.util.Collections.emptyList();
                return new HiveFileReader() {
        String filter = consumer.buildPartitionFilter("dt=va\"lue", false);
            consumer.discoverNewPartitions();  
        };
                ((org.opensearch.index.IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>) r).getPointer().getRowIndex()
 *
            @Override
        assertNotNull(ex.getCause());  
    }
        // Verify that PARTITION_TIME mode uses extracted time comparison, not lexicographic.  
    public void testBuildPartitionFilterInclusiveSingleKey() {
    public void testHiveSchemaToParquetDecimalWithoutParameters() {
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        setLastMetastoreQueryTime(consumer);  
            @Override
        byte[] json = consumer.rowToJson(row, ptr);
        HiveShardConsumer consumer = createConsumer();
            public void close() {
        List<?> secondBatch = consumer.readNext(10, 1000);
        );
        assertEquals(PrimitiveType.PrimitiveTypeName.BINARY, schema.getType("name").asPrimitiveType().getPrimitiveTypeName());  
        columns.add(new MetastoreCatalog.ColumnInfo("name", "varchar(255)"));  
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-02", "", List.of("/p/f1.parquet"), 101));  
            @Override
            }  
/*  
                return java.util.Collections.emptyList();
        columns.add(new MetastoreCatalog.ColumnInfo("ratio", "float"));  
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-01", "", List.of("/f1"), 100));
        assertEquals(2L, consumer.getPointerBasedLag(null));
    }
        assertEquals("\"it's\"", HiveShardConsumer.quoteFilterValue("it's"));
        injectCatalog(consumer, noopCatalog(true));  
        assertTrue(result.contains("\"_id\":\""));  
        List<MetastoreCatalog.ColumnInfo> columns = new ArrayList<>();
    public void testHiveSchemaToParquetIntVariants() {  
        String filter = consumer.buildPartitionFilter("invalid", false);  
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        consumer.partitionKeys = List.of("year", "month", "day");  
        consumer.partitionKeys = List.of("dt");
        columns.add(new MetastoreCatalog.ColumnInfo("count", "int"));
        row.put("name", "alice");  
        assertEquals(PrimitiveType.PrimitiveTypeName.BINARY, schema.getType("custom").asPrimitiveType().getPrimitiveTypeName());
        assertEquals(0, consumer.pendingWork.getFirst().currentFileIndex);
import org.opensearch.test.OpenSearchTestCase;
        columns.add(new MetastoreCatalog.ColumnInfo("amount", "decimal"));
        HiveShardConsumer consumer = createConsumer();
            public TableInfo getTableInfo(String database, String table) {
        row.put("score", 9.5);
        params.put("table", "tbl");
            );  
        HiveShardConsumer consumer = createConsumer();  
        assertEquals(
    }
        assertEquals("(dt >= \"2024-01-15\")", filter);
        assertEquals("2024-01-15 03:00:00", result);
        HiveShardConsumer consumer = createConsumer();
        };
        HiveShardConsumer consumer = createConsumer();
        MessageType schema = HiveShardConsumer.hiveSchemaToParquet(columns);
        String filter = consumer.buildPartitionFilter("dt=2024-01-15", true);  
            HiveFileReader createFileReader(String filePath) {  
        MetastoreCatalog.PartitionInfo partition = new MetastoreCatalog.PartitionInfo(List.of("2024", "01", "15"), "/data", 0);
        consumer.partitionKeys = List.of("dt");  
    }  
        MetastoreCatalog.PartitionInfo partition = new MetastoreCatalog.PartitionInfo(List.of("2024-01-15"), "/data", 0);  
            public java.util.List<PartitionInfo> getPartitionsByFilter(String database, String table, String filter) {
    }
    public void testHiveSchemaToParquetUnknownTypeFallsBackToString() {
    }
        HivePointer ptr = new HivePointer("dt=2024-01-01", "file:/data/part-0.parquet", 1, 1);
        List<?> batch = consumer.readNext(latest, true, 10, 1000);
                        if (failing && next == 2) {
            }  
    public void testExtractPartitionTimeWithPattern() {  
    private static void setLastMetastoreQueryTime(HiveShardConsumer consumer) {  
        HiveShardConsumer consumer = createConsumer();
        final boolean[] readerClosed = { false };
        MetastoreCatalog.PartitionInfo partition = new MetastoreCatalog.PartitionInfo(List.of("2024", "01", "15", "03"), "/data", 0);
            }  
        assertEquals("rows read before the failure must be delivered", 2, firstBatch.size());  
        // Simulate a framework retry on a consumer whose watermark already advanced
    }  
                    public Map<String, Object> readNext() throws IOException {  
            public java.util.List<PartitionInfo> getAllPartitions(String database, String table) {  
        assertEquals(PrimitiveType.PrimitiveTypeName.INT32, schema.getType("b").asPrimitiveType().getPrimitiveTypeName());
        return new HiveSourceConfig(params, 1);  
        assertEquals(PrimitiveType.PrimitiveTypeName.INT64, schema.getType("total").asPrimitiveType().getPrimitiveTypeName());  
            public void close() {}  
                return java.util.Collections.emptyList();  
        assertEquals(PrimitiveType.PrimitiveTypeName.BOOLEAN, schema.getType("flag").asPrimitiveType().getPrimitiveTypeName());
    }
        params.put("partition_order", "partition-time");  
        assertEquals("", filter);
                boolean failing = readers.isEmpty();
            public java.util.List<PartitionInfo> getPartitionsByFilter(String database, String table, String filter) {
        consumer.watermarkPartitionTime = "2024-01-01";  
        columns.add(new MetastoreCatalog.ColumnInfo("custom", "struct<a:int,b:string>"));
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-02", "", List.of("/f2"), 200));
        assertNull(consumer.currentFileReader);
        String filter = consumer.buildPartitionFilter("region=us/dt=2024-03-01", false);  
        Map<String, Object> params = new HashMap<>();
        String time11 = consumer.extractPartitionTime(hour11);
    public void testQuoteFilterValueRejectsInexpressibleValues() {  
            }
        consumer.currentWorkIndex = 0;
        List<?> batch = consumer.readNext(new HivePointer("dt=2024-01-01", "/p/f0.parquet", 0, 0), true, 10, 1000);
        params.put("database", "db");
        assertTrue(batch.isEmpty());
        params.put("table", "tbl");
import java.util.List;
            public java.util.Map<String, Object> readNext() {
            public void reconnect() {}  
import java.util.ArrayList;
    public void testQuoteFilterValueSwitchesToSingleQuotesForDoubleQuotedValues() {
                            throw new IOException("transient read failure");
    public void testPointerBasedLagCountsRemainingPartitionsAfterDiscovery() throws Exception {  
                    public Map<String, Object> readNext() {  
        params.put("metastore_uri", "thrift://localhost:9083");
        MessageType schema = HiveShardConsumer.hiveSchemaToParquet(columns);
            @Override
        try {
    public void testBuildPartitionFilterTwoKeys() {
    }
        // First reader delivers two rows then fails; the second reader replays the whole file.
        };
        setLastMetastoreQueryTime(consumer);
        params.put("table", "tbl");
        assertEquals(2, decimal.getScale());
            }
    public void testOpenNextFileDoesNotSkipOnFailure() {  
        assertEquals(-1L, consumer.getPointerBasedLag(null));  
        consumer.currentWorkIndex = 0;
        List<?> firstBatch = consumer.readNext(10, 1000);
                    @Override
            public TableInfo getTableInfo(String database, String table) {  
                return java.util.Collections.emptyList();  
        LogicalTypeAnnotation.DecimalLogicalTypeAnnotation decimal = (LogicalTypeAnnotation.DecimalLogicalTypeAnnotation) schema.getType(  
        assertEquals("'va\"lue'", HiveShardConsumer.quoteFilterValue("va\"lue"));
        assertEquals("seek must re-discover the target partition despite the stale watermark", 2, batch.size());
        params.put("database", "db");
                return List.of("/p/f0.parquet");  
        };
        assertEquals("\"plain\"", HiveShardConsumer.quoteFilterValue("plain"));  
        params.put("partition_time_pattern", "2024-01-01 $hour:00:00");
    public void testBuildPartitionFilterInclusiveCompositeKey() {
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-01", "", List.of("/p/f0.parquet"), 100));
            @Override  
        // the base type must be resolved after stripping the parameters.
        row.put("age", 30);
    }
                return java.util.Collections.emptyList();
        byte[] json = consumer.rowToJson(row, ptr);  
            @Override  
            @Override
            @Override
    }
    }
        assertTrue(result.contains("\\\\"));
        for (int i = 0; i < 5; i++) {
        assertTrue(schema.getType("code").getLogicalTypeAnnotation() instanceof LogicalTypeAnnotation.StringLogicalTypeAnnotation);
        String filter = consumer.buildPartitionFilter("year=2024/month=01/day=15", true);  
    private static HiveSourceConfig createConfig() {
    }  
            }
                    }
        // currentFileIndex must not have advanced, so a retry would attempt the same file
        HivePointer latest = new HivePointer("__LATEST__", "", 0, 0);
            "(year > \"2024\") OR (year = \"2024\" AND month > \"01\") OR (year = \"2024\" AND month = \"01\" AND day > \"15\")",
            "amount"
        consumer.partitionKeys = List.of("dt");
        assertEquals(0, decimal.getScale());  
            }
        HiveShardConsumer consumer = createConsumer();
    public void testPartitionToNameSingleKey() {  
 */  
        assertEquals("2024-01-01 11:00:00", time11);
    public void testHiveSchemaToParquetParameterizedTypes() {
        // In lexicographic order: "2024-01-01 2:00:00" > "2024-01-01 11:00:00" (because '2' > '1')
                };  
        byte[] json = consumer.rowToJson(row, ptr);
        MessageType schema = HiveShardConsumer.hiveSchemaToParquet(columns);
        assertTrue("Lexicographic comparison gives wrong order for non-padded hours", time2.compareTo(time11) > 0);  
        MetastoreCatalog.PartitionInfo hour11 = new MetastoreCatalog.PartitionInfo(List.of("11"), "/data/hour=11", 0);
        HiveSourceConfig config = new HiveSourceConfig(params, 1);
        params.put("database", "db");
        String result = consumer.extractPartitionTime(partition);  
    }
            }
        Map<String, Object> params = new HashMap<>();  
        assertEquals("the read after a latest reset must not immediately re-query the metastore", 1, getAllCalls[0]);  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(
            @Override
        final int[] getAllCalls = { 0 };
        columns.add(new MetastoreCatalog.ColumnInfo("score", "double"));
            rowIndexes.add(
        HiveSourceConfig config = new HiveSourceConfig(params, 1);  
                        }  
        row.put("msg", "line1\nline2");
        params.put("table", "tbl");
            // Expected: no Metastore connection in unit test
import java.nio.charset.StandardCharsets;
        Map<String, Object> params = new HashMap<>();
            @Override
}  
        assertEquals(6, schema.getFieldCount());  
        List<HiveFileReader> readers = new ArrayList<>();  
import java.util.HashMap;  
        columns.add(new MetastoreCatalog.ColumnInfo("b", "smallint"));  
public class HiveShardConsumerTests extends OpenSearchTestCase {
        params.put("partition_time_pattern", "$year-$month-$day $hour:00:00");  
        columns.add(new MetastoreCatalog.ColumnInfo("name", "string"));
                HiveFileReader reader = new HiveFileReader() {
            @Override  
        assertTrue(retryFailure.getSuppressed()[0] instanceof IOException);
        assertTrue(result.contains("\\\"hello\\\""));  
            }
        assertEquals("(dt > 'va\"lue')", filter);
                        return next < fileRows.size() ? fileRows.get(next++) : null;
        HiveFileReader openReader = new HiveFileReader() {  
    }
    }  
        MessageType schema = HiveShardConsumer.hiveSchemaToParquet(columns);  
    }
            @Override  
        params.put("metastore_uri", "thrift://localhost:9083");  
            public void connect() {}  
        String result = new String(json, StandardCharsets.UTF_8);
        HiveShardConsumer consumer = createConsumer();  
        assertEquals(0, consumer.pendingWork.size());
        HiveShardConsumer consumer = createConsumer();
        consumer.partitionKeys = List.of("dt");  
        List<Long> rowIndexes = new ArrayList<>();  
        // This confirms that lexicographic comparison would give wrong results for non-padded hours.
        row.put("email", null);
        }
        params.put("metastore_uri", "thrift://localhost:9083");  
        assertTrue(trailing.getMessage(), trailing.getMessage().contains("backslash"));
        assertEquals("failed file must be reopened exactly once", 2, readers.size());
        consumer.partitionKeys = List.of("dt");  
        assertEquals(PrimitiveType.PrimitiveTypeName.DOUBLE, schema.getType("score").asPrimitiveType().getPrimitiveTypeName());
                    }
        columns.add(new MetastoreCatalog.ColumnInfo("code", "char(3)"));
        HiveShardConsumer consumer = createConsumer();
            @Override
        // to the target partition's time (the partition had completed before the retry).
        assertEquals(PrimitiveType.PrimitiveTypeName.INT32, schema.getType("count").asPrimitiveType().getPrimitiveTypeName());
        IllegalArgumentException trailing = expectThrows(
    public void testRowToJsonNullValue() throws Exception {
        HiveShardConsumer consumer = createConsumer();
    }
    }
            public void close() {}
        HiveSourceConfig config = new HiveSourceConfig(params, 1);  
            fileRows.add(Map.of("id", i));
                }  
            public void reconnect() {}
        columns.add(new MetastoreCatalog.ColumnInfo("amount", "decimal(10,2)"));
        consumer.discoverNewPartitions();
    }  
            );
        assertTrue("open reader must be closed before the work queue is reset", readerClosed[0]);
        assertEquals(PrimitiveType.PrimitiveTypeName.BINARY, schema.getType("name").asPrimitiveType().getPrimitiveTypeName());  
import java.util.LinkedHashMap;
                return null;  
        Map<String, Object> row = new LinkedHashMap<>();  
    public void testDiscoverNewPartitionsClearsPendingWork() throws Exception {
        Map<String, Object> row = new LinkedHashMap<>();
        );
        List<Map<String, Object>> fileRows = List.of(Map.of("id", 0), Map.of("id", 1));
            @Override  
        ).getLogicalTypeAnnotation();
                };  
                return java.util.Collections.emptyList();
        row.put("name", "bob");
        assertEquals("no gaps and no duplicates across the failure", List.of(0L, 1L, 2L, 3L, 4L), rowIndexes);
                return null;
        HiveShardConsumer consumer = createConsumer();
        consumer.partitionKeys = List.of("dt");
        consumer.partitionKeys = List.of("hour");
            @Override
        MetastoreCatalog countingCatalog = new MetastoreCatalog() {  
        };
        MetastoreCatalog.PartitionInfo partition = new MetastoreCatalog.PartitionInfo(List.of("2024", "01", "15"), "/data", 0);  
    public void testReadNextThrowsOnPersistentFailure() {  
        return new HiveShardConsumer("test", 0, config);
        assertTrue(result.contains("\\n"));
        assertEquals(10, decimal.getPrecision());
package org.opensearch.plugin.hive;
        injectCatalog(consumer, catalog);
    }  
        assertNotNull(retryFailure);
            public java.util.List<PartitionInfo> getAllPartitions(String database, String table) {
        assertEquals("2024-01-01 2:00:00", time2);
        params.put("table", "tbl");  
        assertEquals(0, consumer.currentWorkIndex);  
    public void testBuildPartitionFilterCompositeKey() {
        assertEquals("2024/01/15", result);
            @Override
            public java.util.List<PartitionInfo> getAllPartitions(String database, String table) {
                    private int next = 0;  
    public void testPointerBasedLagIsUnknownBeforeFirstDiscovery() {
        // discoverNewPartitions clears the list (will fail to connect to Metastore, but  
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config);
        MessageType schema = HiveShardConsumer.hiveSchemaToParquet(columns);  
        RuntimeException ex = expectThrows(RuntimeException.class, () -> consumer.readNext(10, 1000));
                return null;
            public TableInfo getTableInfo(String database, String table) {
        } catch (Exception e) {
        HivePointer ptr = new HivePointer("dt=2024-01-01", "file:/data/part-0.parquet", 2, 2);  
                    @Override
        HiveShardConsumer consumer = createConsumer();
    public void testBuildPartitionFilterNoEquals() {
            HiveFileReader createFileReader(String filePath) {
        columns.add(new MetastoreCatalog.ColumnInfo("a", "tinyint"));
        params.put("metastore_uri", "thrift://localhost:9083");  
            }
            @Override
    public void testExtractPartitionTimeNullPattern() {
    }
        params.put("database", "db");
    }
                if (failOnReconnect) {
    public void testRowToJsonSpecialCharacters() throws Exception {
        assertTrue("latest reset must record the metastore query time", consumer.lastMetastoreQueryTime > 0);
            }
        columns.add(new MetastoreCatalog.ColumnInfo("flag", "boolean"));  
            public TableInfo getTableInfo(String database, String table) {  
            @Override
        String result = consumer.extractPartitionTime(partition);
                    throw new IOException("reconnect failed");
        consumer.partitionKeys = List.of("dt");  
    }
        List<MetastoreCatalog.ColumnInfo> columns = new ArrayList<>();
        columns.add(new MetastoreCatalog.ColumnInfo("total", "bigint"));
    }  
    public void testLatestResetRecordsMetastoreQueryTime() throws Exception {
            }
        consumer.catalog = catalog;  
        for (Object r : firstBatch) {
        assertEquals(PrimitiveType.PrimitiveTypeName.FLOAT, schema.getType("ratio").asPrimitiveType().getPrimitiveTypeName());
    public void testBuildPartitionFilterSingleKey() {
    public void testRowToJsonBasicTypes() throws Exception {  
    public void testBuildPartitionFilterQuotesValueContainingDoubleQuote() {
                throw new IOException("file open failed");  
            @Override
            filter  
                readers.add(reader);
            @Override
        MetastoreCatalog.PartitionInfo hour2 = new MetastoreCatalog.PartitionInfo(List.of("2"), "/data/hour=2", 0);  
        LogicalTypeAnnotation.DecimalLogicalTypeAnnotation decimal = (LogicalTypeAnnotation.DecimalLogicalTypeAnnotation) schema.getType(
                getAllCalls[0]++;
                return null;  
        assertTrue(schema.getType("name").getLogicalTypeAnnotation() instanceof LogicalTypeAnnotation.StringLogicalTypeAnnotation);
        assertEquals("year=2024/month=01/day=15", consumer.partitionToName(partition));
                return null;
        expectThrows(IOException.class, consumer::openNextFile);  
            "amount"  
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, config) {
        Map<String, Object> params = new HashMap<>();
        consumer.partitionKeys = List.of("year", "month", "day", "hour");  
        params.put("metastore_uri", "thrift://localhost:9083");
                    @Override
        consumer.catalog = emptyCatalog;
        Map<String, Object> params = new HashMap<>();
        String result = new String(json, StandardCharsets.UTF_8);
 * The OpenSearch Contributors require contributions made to  
            List<String> listDataFiles(String location) {
            public void close() {}  
    public void testDiscoverByPartitionTimeFiltersCorrectly() {
        injectCatalog(consumer, countingCatalog);
        row.put("quote", "say \"hello\"");
                ((org.opensearch.index.IngestionShardConsumer.ReadResult<HivePointer, HiveMessage>) r).getPointer().getRowIndex()  
        consumer.pendingWork.add(new HiveShardConsumer.PartitionWork("dt=2024-01-01", "", List.of("/p/f0.parquet"), 100));  
                    public void close() {}
                return reader;
        assertEquals("original failure must be preserved as suppressed", 1, retryFailure.getSuppressed().length);  
    }  
            public java.util.List<PartitionInfo> getPartitionsByFilter(String database, String table, String filter) {
        params.put("table", "tbl");
        assertEquals("(dt > \"2024-01-15\")", filter);
    }
    public void testSeekResetsStaleWatermarkPartitionTime() throws Exception {  
            }  
            @Override
    }  
        assertEquals(PrimitiveType.PrimitiveTypeName.INT32, schema.getType("a").asPrimitiveType().getPrimitiveTypeName());
        );
            public java.util.List<PartitionInfo> getAllPartitions(String database, String table) {
            }
        List<MetastoreCatalog.ColumnInfo> columns = new ArrayList<>();  
        params.put("database", "db");  
        RuntimeException ex = expectThrows(RuntimeException.class, () -> consumer.readNext(10, 1000));  
            HiveFileReader createFileReader(String filePath) throws IOException {
            }
        setLastMetastoreQueryTime(consumer);
            public java.util.List<PartitionInfo> getPartitionsByFilter(String database, String table, String filter) {
            public void connect() {}  
                    private int next = 0;  
        HiveShardConsumer consumer = new HiveShardConsumer("test", 0, createConfig()) {  
        assertEquals(10, decimal.getPrecision());  
        params.put("database", "db");  
            @Override
            public void connect() {}  
        };
            rowIndexes.add(
        HiveShardConsumer consumer = createConsumer();
        HiveShardConsumer consumer = createConsumer();
        injectCatalog(consumer, noopCatalog(false));
            @Override
        // Simulate consumed work: add entries and advance index past them  
import org.apache.parquet.schema.PrimitiveType;  
        // hour=2 is lexicographically > hour=11, but time-wise hour=11 > hour=2.
        ).getLogicalTypeAnnotation();
        IllegalArgumentException both = expectThrows(IllegalArgumentException.class, () -> HiveShardConsumer.quoteFilterValue("a\"b'c"));
        // Hive's default decimal is decimal(10,0)
import org.apache.parquet.schema.MessageType;
    }
        Map<String, Object> row = new LinkedHashMap<>();
    public void testPartitionToNameCompositeKeys() {
 * compatible open source license.
        String filter = consumer.buildPartitionFilter("dt=2024-01-15", false);  
        // the clear happens before the Metastore call)
            @Override
        HiveShardConsumer consumer = createConsumer();
        }  
        assertTrue(result.contains("\"_source\":{\"name\":\"bob\",\"email\":null}"));
        }  
        HiveShardConsumer consumer = createConsumer();  
    }  
        for (Object r : secondBatch) {  
        assertEquals("(region > \"us\") OR (region = \"us\" AND dt > \"2024-03-01\")", filter);
        HivePointer ptr = new HivePointer("dt=2024-01-01", "file:/data/part-0.parquet", 0, 0);
        params.put("partition_order", "partition-time");
        assertTrue(both.getMessage(), both.getMessage().contains("both quote characters"));
        consumer.currentFileReader = openReader;
                return java.util.Collections.emptyList();  
            }
import java.util.Map;  
        consumer.currentWorkIndex = 0;
            @Override
            IllegalArgumentException.class,
            @Override  
            () -> HiveShardConsumer.quoteFilterValue("value\\")  
        assertTrue(result.contains("\"_source\":{\"name\":\"alice\",\"age\":30,\"score\":9.5,\"active\":true}"));
        };
        params.put("metastore_uri", "thrift://localhost:9083");
        consumer.currentWorkIndex = 0;
            }  
            public void close() {}  
        MetastoreCatalog emptyCatalog = new MetastoreCatalog() {
        assertEquals(2, consumer.currentWorkIndex);
import java.io.IOException;  
        consumer.lastMetastoreQueryTime = System.currentTimeMillis();
        // hour=2 extracts to "2024-01-01 2:00:00", hour=11 extracts to "2024-01-01 11:00:00"  
            @Override
                    public void close() {}
            "(year > \"2024\") OR (year = \"2024\" AND month > \"01\") OR (year = \"2024\" AND month = \"01\" AND day >= \"15\")",
        List<MetastoreCatalog.ColumnInfo> columns = new ArrayList<>();  
        assertEquals(2, consumer.pendingWork.size());  
                    @Override
