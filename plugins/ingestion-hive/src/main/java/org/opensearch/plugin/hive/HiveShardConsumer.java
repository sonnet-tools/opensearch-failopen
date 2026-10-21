        return all.stream().filter(p -> p.getCreateTime() > watermarkCreateTime).collect(Collectors.toList());
     * Seeks to the position indicated by the pointer. Sets the watermark to the pointer's partition
                        currentRowIndex
        String targetFile = pointer.getFilePath();
    private List<ReadResult<HivePointer, HiveMessage>> doReadNext(long maxMessages) throws Exception {
        // all prior work is consumed, so the reader should already be closed; close it
            case "boolean" -> Types.optional(PrimitiveType.PrimitiveTypeName.BOOLEAN).named(name);
        this.watermarkCreateTime = 0;
                        hadoopConf.set("fs.s3a.impl", s3FsImpl);
            logger.info("Shard {} reset to latest, skipping {} existing partitions", shardId, existing.size());
     * would silently change the compared value. Switch the quote character instead,
            }
import org.apache.hadoop.conf.Configuration;
        if (currentWorkIndex >= pendingWork.size() && currentFileReader == null) {
                    }
        // Partition/file not found, set watermark to pointer's partition so next discovery skips past it
                watermarkPartitionTime = existing.stream().map(this::extractPartitionTime).max(String::compareTo).orElse("");
    @Override
                for (int f = 0; f < work.files.size(); f++) {
    // Partition tracking: watermark tracks the last fully-processed partition so that
        };
        final List<String> files;
}
                watermarkCreateTime = work.createTime;
                }
    private static int[] parseDecimalParameters(String decimalType) {
            try {
        // Reset work queue before fetching new partitions. Callers only invoke this when
        List<MetastoreCatalog.PartitionInfo> all = catalog.getAllPartitions(config.getDatabase(), config.getTable());
    }
                            "Shard {} seeked to partition={}, file={}, row={}",
    byte[] rowToJson(Map<String, Object> row, HivePointer pointer) throws IOException {
        if (watermarkCreateTime <= 0 && (watermark == null || watermark.isEmpty())) {
        List<MetastoreCatalog.PartitionInfo> partitions;
                    e
        Path path = new Path(location);
        lastMetastoreQueryTime = System.currentTimeMillis();
        }
            if (work.currentFileIndex < work.files.size()) {
        boolean includeStart,
            for (int j = 0; j < i; j++) {
    // Partition-time mode: full retrieval with client-side filtering by extracted timestamp.
                    new ParameterizedMessage(
                partitions.sort(Comparator.comparingInt(MetastoreCatalog.PartitionInfo::getCreateTime));
                return results;
import org.opensearch.core.common.bytes.BytesReference;
                        shardId,
                logger.warn("Error closing file reader", e);
    }
                // already in pendingWork and is consumed from there
                    // Reopening after a transient failure: skip the rows that were
        tableInputFormat = tableInfo.getInputFormat();
            try {
        List<MetastoreCatalog.PartitionInfo> all = catalog.getAllPartitions(config.getDatabase(), config.getTable());
    private List<MetastoreCatalog.PartitionInfo> discoverByCreateTime() throws IOException {
        return all.stream().filter(p -> extractPartitionTime(p).compareTo(watermarkPartitionTime) > 0).collect(Collectors.toList());
import org.apache.parquet.schema.Type;
     * Only refreshes when all pending work is complete and the monitor interval has elapsed,
    int currentWorkIndex;
        }
     * Quotes a partition value for a Metastore filter expression. The Metastore filter
     */
        logger.info("Table schema for shard {}: {}, partitionKeys: {}", shardId, tableSchema, partitionKeys);
    /**
        String normalized = hiveType.toLowerCase(Locale.ROOT).trim();
    long lastMetastoreQueryTime;
     * Creates a new HiveShardConsumer.
                        "Transient read failure on shard {} file {} at row {}; returning partial batch and resuming from this position",
                    try {
                newCatalog.close();
    }
                // Current file exhausted, try the next file
    String extractPartitionTime(MetastoreCatalog.PartitionInfo partition) {
            } catch (Exception retryEx) {
            try {
     */
                        for (long r = 0; r < targetRow; r++) {
        if (catalog != null) {
        // Set watermark to the pointer's partition and use inclusive filter so that
                // discovery fetches only its successors; the target itself is
    private List<ReadResult<HivePointer, HiveMessage>> executeWithRetry(ReadAction action) {
            String op = (inclusive && i == segments.length - 1) ? " >= " : " > ";
            case "string", "varchar", "char" -> Types.optional(PrimitiveType.PrimitiveTypeName.BINARY)
            case "timestamp" -> Types.optional(PrimitiveType.PrimitiveTypeName.INT96).named(name);
        }
        }
                        String s3FsImpl = S3HadoopFileSystem.class.getName();
        List<String> values = partition.getValues();
                throw e;
     * return null for missing fields.
            logger.warn("IO error for shard {}, attempting recovery: {}", shardId, e.getMessage());
                partitions = discoverByCreateTime();
    }
                        logger.info(
        Types.MessageTypeBuilder builder = Types.buildMessage();
        // Step 2: If there's nothing to read (no pending partitions, no open file), return empty.
        return catalog.getPartitionsByFilter(config.getDatabase(), config.getTable(), filter);
        this.lastMetastoreQueryTime = 0;
        try {
 * this file be licensed under the Apache-2.0 license or a
                // All files in this partition are consumed. Advance watermark so that
                work.currentFileIndex--;
            case "bigint" -> Types.optional(PrimitiveType.PrimitiveTypeName.INT64).named(name);
        // All pending partitions have been fully read
 * The OpenSearch Contributors require contributions made to
        while (count < maxMessages) {
                        currentFile,
        for (int i = 0; i < partitionKeys.size(); i++) {
    List<String> listDataFiles(String location) throws IOException {
     * @param clientId the client identifier for this consumer
        final String partitionName;
                watermarkPartitionTime = work.partitionTime;
                        return;
     * Used as the projection schema so that files with fewer columns
            String[] kv = segments[i].split("=", 2);
                    ),
        List<ReadResult<HivePointer, HiveMessage>> execute() throws Exception;
                return true;
import org.opensearch.index.IngestionShardConsumer;
        closeCurrentReader();
        long targetRow = includeStart ? pointer.getRowIndex() : pointer.getRowIndex() + 1;
                logger.error(() -> new ParameterizedMessage("Failed to fetch table schema for shard {}", shardId), e);
                    String partTime = extractPartitionTime(partition);
        }
    }
        this.watermark = config.getConsumeStartOffset();
                break;
            return action.execute();
                } else {
    private MessageType tableSchema;
        tableSchema = hiveSchemaToParquet(tableInfo.getColumns());
    }
     * Resumes reading from the given pointer position. Restores watermark, seeks to the
                catalog = null;
        int scale = 0;
            } catch (Exception e) {
     * Converts Hive FieldSchema list to Parquet MessageType.
        // Assign partitions to this shard using consistent hashing on partition name.
    // Catalog connection for metadata queries (table schema, partition discovery)
            }
    private void seekToPointer(HivePointer pointer, boolean includeStart) throws Exception {
            throw new IllegalArgumentException("Partition value ending with a backslash cannot be used in a Metastore filter: " + value);
    MetastoreCatalog catalog;
        }
            clause.append(kv[0]).append(op).append(quoteFilterValue(kv[1]));
    void discoverNewPartitions() throws Exception {
        return false;
    }
            }
 *
     * and reject the rare values this grammar cannot express.
                // Return the rows already read so nothing is lost, and arrange for the
            partitionKeys = Collections.emptyList();
            try {
            for (FileStatus status : statuses) {
    }
     * Opens the next data file from the pending work queue. When all files in a partition
            if (i > 0) sb.append("/");
        return sb.toString();
        }
            case "float" -> Types.optional(PrimitiveType.PrimitiveTypeName.FLOAT).named(name);
            throw new RuntimeException("Read failure for shard " + shardId, e);
     * Currently supports Parquet. Additional formats (ORC, Avro, etc.) can be added here.
            Collections.sort(files);
            this.partitionTime = partitionTime;
        if (tableInputFormat != null && tableInputFormat.toLowerCase(Locale.ROOT).contains("parquet")) {
    private long sequenceNumber;
                        currentRowIndex = targetRow;
     * are consumed, updates the watermark and advances to the next partition.
     * Closes and reconnects to Metastore. Used for recovery after connection failures.
    @Override
            return -1;
import org.apache.logging.log4j.LogManager;
    }
            }
     * Core read loop. Discovers new partitions if needed, then reads rows from the current
        // Step 4: Read rows from the current file, converting each to a JSON message.
     * Tracks work for a single partition: its files and progress through them.
        final String partitionTime;
 * Shard consumer that reads from Hive tables via Pull-Based Ingestion.
            this.files = files;
    /**
            PartitionWork work = pendingWork.get(currentWorkIndex);
            }
        partitionKeys = tableInfo.getPartitionKeys();
                        }
                if (!files.isEmpty()) {
        // partition-time mode and silently skip the rows being retried.
    // increasing counter used for pointer ordering and checkpoint recovery.
                        }
     */
import java.util.List;
        if (open > 0 && close > open) {
        long count = 0;
            }
            }
    }
                closeCurrentReader();
        this.watermark = pointer.getPartitionName();
                partitions.sort((a, b) -> {
        closeCurrentReader();
            }
    }
            }
     */
            Thread.currentThread().setContextClassLoader(HiveShardConsumer.class.getClassLoader());
            case "double" -> Types.optional(PrimitiveType.PrimitiveTypeName.DOUBLE).named(name);
            return;
                seekToPointer(pointer, includeStart);
            return doReadNext(maxMessages);
                        Thread.currentThread().setContextClassLoader(original);
            PartitionWork work = pendingWork.get(currentWorkIndex);
        this.sequenceNumber = 0;
                }
        // All three watermark variants must be reset; a stale watermarkPartitionTime
    private void prepareCurrentFileResume() {
            "Partition value containing both quote characters cannot be used in a Metastore filter: " + value
                    .as(LogicalTypeAnnotation.decimalType(precisionScale[1], precisionScale[0]))
                // next call to reopen this file and continue from the current row.
    public IngestionShardPointer latestPointer() {
import org.apache.parquet.schema.LogicalTypeAnnotation;
            String[] parts = decimalType.substring(open + 1, close).split(",");
        return results;
        XContentBuilder builder = JsonXContent.contentBuilder();
            return all;
    private String currentFile;
        if (catalog == null) {
            logger.info("Initializing HiveShardConsumer for shard {} with metastore URI: {}", shardId, config.getMetastoreUri());
        switch (config.getPartitionOrder()) {
import org.apache.hadoop.fs.FileSystem;
            }
        }
                    if (work.files.get(f).equals(targetFile)) {
        // Discover partitions from the pointer's partition onward (inclusive)
     */
            }
    }
import org.apache.parquet.schema.PrimitiveType;
                }
     * Determines if it's time to query the Metastore for new partitions.
        this.sequenceNumber = includeStart ? pointer.getSequenceNumber() : pointer.getSequenceNumber() + 1;
                    files.add(status.getPath().toString());
    public IngestionShardPointer earliestPointer() {
            case CREATE_TIME:
    }
                        Thread.currentThread().setContextClassLoader(HiveShardConsumer.class.getClassLoader());
     * Extracts a timestamp string from partition values using the configured partition_time_pattern.
            count++;
    @Override
        return pendingWork.size() - currentWorkIndex;
                currentFileReader = createFileReader(currentFile);
        }
    @FunctionalInterface
            catalog = newCatalog;
                scale = Integer.parseInt(parts[1].trim());
    private List<MetastoreCatalog.PartitionInfo> discoverByPartitionTime() throws IOException {
     */
    /**
            if (!existing.isEmpty()) {
    public long getPointerBasedLag(IngestionShardPointer expectedStartPointer) {
        }
            }
    }
        throw new IllegalArgumentException(
        return new HivePointer("", "", 0, 0);
    @Override
            byte[] json = rowToJson(row, ptr);
    }
    /**
        return new int[] { precision, scale };
                        for (long r = 0; r < resumeRowIndex; r++) {
        this.seekInclusive = false;
        }
     * Prepares to resume the file that was being read when a transient failure occurred:
            sequenceNumber++;
        if (currentFileReader != null) {
        // Signals that existing partitions should be skipped. seekToPointer sets all watermarks
        if (currentFileReader == null) {
        // Step 1: Check if it's time to query Metastore for new partitions.
                    currentRowIndex = resumeRowIndex;
        final int createTime;
    private interface ReadAction {
import java.util.Map;
    @Override
                        throw e;
    String buildPartitionFilter(String watermark, boolean inclusive) {
                }
    private void reconnectMetastore() throws IOException {
        this.pendingWork = new ArrayList<>();
                watermarkPartitionTime = work.partitionTime;
        if (shouldRefreshPartitions()) {
            // honors the monitor interval instead of immediately re-querying.
        for (int i = 0; i < segments.length; i++) {
        List<String> values = partition.getValues();
        );
                yield Types.optional(PrimitiveType.PrimitiveTypeName.BINARY)
    /**
                currentFile = work.files.get(work.currentFileIndex);
            logger.info("HiveShardConsumer initialized successfully for shard {}", shardId);
        if (value.contains("\"") == false) {
    /**
        long maxMessages,
        int open = decimalType.indexOf('(');
            result = result.replace("$" + partitionKeys.get(i), values.get(i));
                int[] precisionScale = parseDecimalParameters(normalized);
            FileStatus[] statuses = fs.listStatus(path);
                return Collections.emptyList();
        for (int i = 0; i < partitionKeys.size(); i++) {
                            if (currentFileReader.readNext() == null) break;
     */
                    } finally {
     *            (year = "2024" AND month = "01" AND day > "15")
        boolean noPendingWork = currentWorkIndex >= pendingWork.size() && currentFileReader == null;
        if (lastMetastoreQueryTime == 0) return true;
     * correct file and row.
                // Advance the watermark to the target partition so incremental
                work.currentFileIndex++;
            MetastoreCatalog newCatalog = new ThriftMetastoreCatalog(config);
            return String.join("/", partition.getValues());
    public IngestionShardPointer pointerFromOffset(String offset) {
     */
        logger.info("Shard {} discovered {} candidate partitions from Metastore", shardId, partitions.size());
                    return aVal.compareTo(bVal);
            builder.addField(hiveTypeToParquetType(col.getName(), col.getType()));
        throw new IOException("Unsupported input format: " + tableInputFormat);
    /**
    private String tableInputFormat;
                AccessController.doPrivilegedChecked(() -> {
        return result;
     * 4.x (unquoteString) only strip the outer quotes without unescaping, so escaping
    private String watermark;
import java.util.ArrayList;
            Map<String, Object> row;
        return executeWithRetry(() -> doReadNext(maxMessages));
            sequenceNumber = 0;
                if (!openNextFile()) {
        }
            HivePointer ptr = new HivePointer(work.partitionName, currentFile, currentRowIndex, sequenceNumber);
    private static Type hiveTypeToParquetType(String name, String hiveType) {
        catalog.reconnect();
                currentWorkIndex++;
        // Seek to the correct file within the pointer's partition
        }
        while (currentWorkIndex < pendingWork.size()) {
        this.seekInclusive = true;
            clauses.add("(" + clause + ")");
        int paren = normalized.indexOf('(');
    }
import java.util.Comparator;
    private void fetchTableSchema() throws IOException {
                    // already delivered from this file.
    }
    }
    String watermarkPartitionTime;
    }
    public List<ReadResult<HivePointer, HiveMessage>> readNext(long maxMessages, int timeoutMillis) {
            if (!fs.exists(path)) {
     * When inclusive is true, uses >= for the last key to include the watermark partition itself.
        builder.field("_id", pointer.asString());
                return Collections.emptyList();
                String name = status.getPath().getName();
                        hadoopConf.set("fs.s3.impl", s3FsImpl);
        // discoverNewPartitions fetches this partition and everything after it.
                        }
    private static final Logger logger = LogManager.getLogger(HiveShardConsumer.class);
        }
            PartitionWork work = pendingWork.get(currentWorkIndex);
        }
        for (MetastoreCatalog.ColumnInfo col : columns) {
    @Override
    /**
/*
            this.partitionName = partitionName;
            ensureInitialized();
        this.shardId = shardId;
    }
import org.opensearch.index.IngestionShardPointer;
     */
                    // the retried action re-runs ensureInitialized and reconnects.
    static MessageType hiveSchemaToParquet(List<MetastoreCatalog.ColumnInfo> columns) {
                List<String> files = listDataFiles(partition.getLocation());
                hadoopConf = null;
                    pendingWork.add(new PartitionWork(partName, partTime, files, partition.getCreateTime()));
            currentRowIndex++;
        }
     */
        try {
    private void closeCurrentReader() {
                prepareCurrentFileResume();
            // The metastore was just queried above; record it so the next read
        PartitionWork(String partitionName, String partitionTime, List<String> files, int createTime) {
     * correct partition and file, and skips rows up to the pointer's row index.
    }
        }
    }
                if (!status.isDirectory() && !name.startsWith("_") && !name.startsWith(".")) {
        // Each shard deterministically owns a subset of partitions (no coordination needed).
        if (value.contains("'") == false) {
        return new HivePointer(LATEST_PARTITION_SENTINEL, "", 0, Long.MAX_VALUE - 1);
    /**
        int precision = 10;
        if (value.endsWith("\\")) {
    HiveFileReader currentFileReader;
     * closes the reader, re-queues the file, and remembers the next undelivered row so
                            shardId,
            return all;
        discoverNewPartitions();
    }
                            if (currentFileReader.readNext() == null) break;
import org.apache.logging.log4j.message.ParameterizedMessage;
        }
    }
                        // Skip rows up to target position
                }
        return BytesReference.toBytes(BytesReference.bytes(builder));
        } catch (IOException e) {
import org.opensearch.common.xcontent.json.JsonXContent;
        this.pendingWork = new ArrayList<>();
            Thread.currentThread().setContextClassLoader(original);
        builder.endObject();
    List<PartitionWork> pendingWork;
        if (watermark == null || watermark.isEmpty()) {
     * generates: (year > "2024") OR (year = "2024" AND month > "01") OR
     */
            // A trailing backslash would escape the closing quote and break the lexer.
    }
                watermark = existing.stream().map(this::partitionToName).max(String::compareTo).orElse("");
    @Override
            case "date" -> Types.optional(PrimitiveType.PrimitiveTypeName.INT32).as(LogicalTypeAnnotation.dateType()).named(name);
 * determines ownership via consistent hashing, and reads assigned Parquet data files.
    }
                    ClassLoader original = Thread.currentThread().getContextClassLoader();
        String filter = buildPartitionFilter(watermark, seekInclusive);
                    try {
            }
    static class PartitionWork {
import java.io.IOException;
        if (pattern == null) {
        if (watermarkPartitionTime == null || watermarkPartitionTime.isEmpty()) {
        this.currentWorkIndex = 0;
            if (work.partitionName.equals(pointer.getPartitionName())) {
    // Neither Hive Metastore nor AWS Glue support server-side filtering by createTime.
                    }
        watermark = pointer.getPartitionName();
    }
/**
            sb.append(partitionKeys.get(i)).append("=").append(values.get(i));
import org.apache.parquet.schema.Types;
        closeCurrentReader();
        resumeRowIndex = 0;
            return "'" + value + "'";
    private void ensureInitialized() throws Exception {
                .as(LogicalTypeAnnotation.stringType())
        List<String> clauses = new ArrayList<>();
                fetchTableSchema();
    // Client-side filtering after full partition list retrieval is the only option.
            default:
            }
                logger.warn(
        } catch (Exception e) {
 * SPDX-License-Identifier: Apache-2.0
     * grammar accepts backslash escapes lexically, but both Hive 3.x (TrimQuotes) and
                if (!clause.isEmpty()) clause.append(" AND ");
            return "\"" + value + "\"";
     */
        logger.info("Shard {} seek target not found, continuing from watermark {}", shardId, watermark);
    private long watermarkCreateTime;
                currentFileReader.close();
                resumeRowIndex = currentRowIndex;
                clause.append(kv[0]).append(" = ").append(quoteFilterValue(kv[1]));
        for (MetastoreCatalog.PartitionInfo partition : partitions) {
        // Stop when maxMessages is reached or all pending files are consumed.
    }
    // Each PartitionWork tracks its files and progress. sequenceNumber is a monotonically
            results.add(new ReadResult<>(ptr, msg));
            if (!openNextFile()) {
            HiveMessage msg = new HiveMessage(json, System.currentTimeMillis());
public class HiveShardConsumer implements IngestionShardConsumer<HivePointer, HiveMessage> {
            // The framework treats -1 as "lag unknown"; 0 would mean fully caught up
    /**
        );
        return executeWithRetry(() -> {
        boolean intervalElapsed = System.currentTimeMillis() - lastMetastoreQueryTime >= config.getMonitorIntervalMillis();
                continue;
        this.currentWorkIndex = 0;
                break;
     * preventing excessive Metastore queries during active reading.
            FileSystem fs = FileSystem.get(path.toUri(), hadoopConf);
                    String aVal = String.join("/", a.getValues());
            }
                throw new RuntimeException("Read failure for shard " + shardId + " after retry", retryEx);
        fetchTableSchema();
                catalog.close();
        // to their respective maximums so that subsequent discovery returns no existing partitions.
                watermarkCreateTime = existing.stream().mapToInt(MetastoreCatalog.PartitionInfo::getCreateTime).max().orElse(0);
 * Each shard independently queries Hive Metastore for new partitions (incremental fetch),
        int currentFileIndex;
    /**
            List<MetastoreCatalog.PartitionInfo> existing = catalog.getAllPartitions(config.getDatabase(), config.getTable());
     * Creates a file reader based on the table's input format.
     * file and converts them to JSON messages. Returns up to maxMessages results per call.
            return Collections.emptyList();
                    break;
            PartitionWork work = pendingWork.get(i);
            }
                watermark = work.partitionName;
        builder.startObject("_source");
                .named(name);
                    reconnectMetastore();
        // Strip type parameters: "decimal(10,2)" -> "decimal", "varchar(255)" -> "varchar"
    private List<MetastoreCatalog.PartitionInfo> discoverByPartitionName() throws IOException {
                // More files in current partition: open the next one
     */
                    }
                        currentFileReader = createFileReader(currentFile);
                currentWorkIndex = i;
            this.currentFileIndex = 0;
    }
        // defensively so a future caller cannot leak an open reader.
    String partitionToName(MetastoreCatalog.PartitionInfo partition) {
                    logger.info("Shard {} assigned partition {} with {} files", shardId, partName, files.size());
    ) {
            List<String> files = new ArrayList<>();
 */
            return new ParquetHiveFileReader(filePath, hadoopConf, tableSchema);
    private final int shardId;
                        closeCurrentReader();
            catalog.close();
    // Current processing state: pendingWork is the queue of partitions to process.
    // Cannot use Metastore filter because lexicographic order may differ from time order.
        }
        if (partitionKeys == null) {
     * Pattern variables like $year, $month, $day are replaced with the corresponding partition key values.
        pendingWork.clear();
        }
     * Builds a Metastore partition filter expression that matches partitions lexicographically
    @Override
        });
                partitions = discoverByPartitionName();
        return noPendingWork && intervalElapsed;
            return catalog.getAllPartitions(config.getDatabase(), config.getTable());
     * Supports both partition-name and create-time ordering strategies.
     * after the watermark. For composite partitions (e.g., "year=2024/month=01/day=15"),
        }
            case "tinyint", "smallint", "int" -> Types.optional(PrimitiveType.PrimitiveTypeName.INT32).named(name);
    @Override
        int timeoutMillis
                return action.execute();
                watermarkCreateTime = work.createTime;
                    prepareCurrentFileResume();
    private final HiveSourceConfig config;
            if (Math.floorMod(partName.hashCode(), numShards) == shardId) {
                if (catalog != null) {
            if (work.currentFileIndex > 0) {
            } catch (IOException e) {
        this.watermarkPartitionTime = "";
        return HivePointer.fromString(offset);
    // incremental discovery only fetches partitions newer than the watermark.
        this.numShards = config.getNumShards();
        currentWorkIndex = 0;
                });
        }
                    } catch (IOException e) {
        this.watermarkCreateTime = 0;
        if (currentWorkIndex < pendingWork.size()) {
            StringBuilder clause = new StringBuilder();
            default -> Types.optional(PrimitiveType.PrimitiveTypeName.BINARY).as(LogicalTypeAnnotation.stringType()).named(name);
            return files;
     * that openNextFile reopens the same file and skips the rows already delivered.
            this.createTime = createTime;
import java.util.stream.Collectors;
        this.config = config;
                            targetRow
    }
        } finally {
                throw e;
                        for (Map.Entry<String, String> entry : config.getHadoopProperties().entrySet()) {
        }
                partitions.sort(Comparator.comparing(this::extractPartitionTime));
                if (currentFileReader != null) {
        builder.mapContents(row);
            if (pointer != null && !pointer.getPartitionName().isEmpty()) {
            case "decimal" -> {
import org.opensearch.core.xcontent.XContentBuilder;
        }
import org.apache.hadoop.fs.FileStatus;
 */
                    // catalog is null when the initial connection itself failed;
    boolean openNextFile() throws IOException {
                        );
                partitions = discoverByPartitionTime();
    private long resumeRowIndex;
        // would exclude the target partition from the discovery below in
        return builder.named("table");
        MetastoreCatalog.TableInfo tableInfo = catalog.getTableInfo(config.getDatabase(), config.getTable());
    static String quoteFilterValue(String value) {
     */
        ClassLoader original = Thread.currentThread().getContextClassLoader();
package org.opensearch.plugin.hive;
        }
        builder.startObject();
            if (!segments[i].contains("=")) continue;
            case "binary" -> Types.optional(PrimitiveType.PrimitiveTypeName.BINARY).named(name);
    // Row to skip to when reopening the current file after a transient read failure.
import org.opensearch.secure_sm.AccessController;
            } else {
                        hadoopConf = new Configuration();
     */
     * Returns {precision, scale}; Hive's defaults are precision 10, scale 0.
                watermark = pointer.getPartitionName();
        }
        return switch (baseType) {
        }
                    .named(name);
        String result = pattern;
        if (pendingWork == null || lastMetastoreQueryTime == 0) {
                        hadoopConf.set("fs.s3n.impl", s3FsImpl);
            } catch (IOException e) {
     * so that partition discovery resumes from that point, then seeks within the partition to the
            lastMetastoreQueryTime = System.currentTimeMillis();
        // When a file is exhausted, move to the next file (possibly in the next partition).
        return clauses.isEmpty() ? "" : String.join(" OR ", clauses);
                        currentFile = work.files.get(f);
            // and could complete warmup prematurely before the first discovery runs.
                            pointer.getPartitionName(),
                logger.error(() -> new ParameterizedMessage("Failed to initialize Hadoop config for shard {}", shardId), e);
import org.apache.hadoop.fs.Path;
            }
    /**
    }
        builder.endObject();
    List<String> partitionKeys;
        // This only triggers when all current work is done and the monitor interval has elapsed.
        }
        String[] segments = watermark.split("/");
                break;
        ensureInitialized();
                    String bVal = String.join("/", b.getValues());
    }
            currentFileReader = null;
            } catch (Exception e) {
            }
                            hadoopConf.set(entry.getKey(), entry.getValue());
            String partName = partitionToName(partition);
    private long currentRowIndex;
            if (parts.length > 1) {
    public List<ReadResult<HivePointer, HiveMessage>> readNext(
     * @param config the Hive source configuration
    /**
                        work.currentFileIndex = f + 1;
    }
                break;
                );
            if (!clause.isEmpty()) clause.append(" AND ");
                row = currentFileReader.readNext();
        // Step 3: If no file is currently open, open the next one from pending work.
import org.apache.parquet.schema.MessageType;
                if (resumeRowIndex > 0) {
    /**
            "Hive ingestion does not support timestamp-based pointer reset. Use 'earliest' or 'latest' instead."
            newCatalog.connect();
    }
        String pattern = config.getPartitionTimePattern();
    public IngestionShardPointer pointerFromTimestampMillis(long timestampMillis) {
                });
import java.util.Collections;
    }
    HiveFileReader createFileReader(String filePath) throws IOException {
    /**
import org.apache.logging.log4j.Logger;
import java.util.Locale;
    public int getShardId() {
                // future partition discovery skips this partition, then move to the next.
                    currentRowIndex = 0;
     *
    }
        }
        int close = decimalType.lastIndexOf(')');
            try {
        // Handle "latest" reset: skip all existing partitions, only read new ones
    private Configuration hadoopConf;
            precision = Integer.parseInt(parts[0].trim());
        for (int i = 0; i < pendingWork.size(); i++) {
    private boolean seekInclusive;
    /**
        return shardId;
        }
     */
     * @param shardId the shard ID this consumer is responsible for
     * Incremental partition fetch: query Metastore for partitions added after watermark.
        throw new UnsupportedOperationException(
        }
 * compatible open source license.
    private final int numShards;
    public void close() throws IOException {
                    resumeRowIndex = 0;
            if (row == null) {
        if (LATEST_PARTITION_SENTINEL.equals(pointer.getPartitionName())) {
            case PARTITION_TIME:
        String baseType = paren > 0 ? normalized.substring(0, paren).trim() : normalized;
                }
                            targetFile,
        List<ReadResult<HivePointer, HiveMessage>> results = new ArrayList<>();
        HivePointer pointer,
                retryEx.addSuppressed(e);
     * Parses precision and scale from a Hive decimal type string like "decimal(10,2)".
                String[] kv = segments[j].split("=", 2);
    public HiveShardConsumer(String clientId, int shardId, HiveSourceConfig config) {
    private static final String LATEST_PARTITION_SENTINEL = "__LATEST__";
            discoverNewPartitions();
        StringBuilder sb = new StringBuilder();
                }
    private boolean shouldRefreshPartitions() {
