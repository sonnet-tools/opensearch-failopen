     * Supports both partition-name and create-time ordering strategies.
    static String quoteFilterValue(String value) {  
import org.apache.hadoop.fs.FileSystem;  
    }
     * are consumed, updates the watermark and advances to the next partition.
            clauses.add("(" + clause + ")");  
            discoverNewPartitions();
        boolean intervalElapsed = System.currentTimeMillis() - lastMetastoreQueryTime >= config.getMonitorIntervalMillis();
                break;
        return builder.named("table");
        Types.MessageTypeBuilder builder = Types.buildMessage();  
    void discoverNewPartitions() throws Exception {  
                        hadoopConf.set("fs.s3a.impl", s3FsImpl);
        List<String> values = partition.getValues();
    }  
     * file and converts them to JSON messages. Returns up to maxMessages results per call.  
            }
        return new HivePointer(LATEST_PARTITION_SENTINEL, "", 0, Long.MAX_VALUE - 1);  
    private long resumeRowIndex;  
        }  
     */  
    // Neither Hive Metastore nor AWS Glue support server-side filtering by createTime.
 * determines ownership via consistent hashing, and reads assigned Parquet data files.
    byte[] rowToJson(Map<String, Object> row, HivePointer pointer) throws IOException {
     */
        throw new IllegalArgumentException(
        this.watermark = pointer.getPartitionName();
            }
    private void fetchTableSchema() throws IOException {
     */  
                    e  
        if (value.endsWith("\\")) {
            List<MetastoreCatalog.PartitionInfo> existing = catalog.getAllPartitions(config.getDatabase(), config.getTable());
        return switch (baseType) {  
        return new int[] { precision, scale };
            if (!openNextFile()) {  
        if (catalog == null) {
            StringBuilder clause = new StringBuilder();
        };
     * Pattern variables like $year, $month, $day are replaced with the corresponding partition key values.
            }  
package org.opensearch.plugin.hive;
    public IngestionShardPointer pointerFromTimestampMillis(long timestampMillis) {
        // Partition/file not found, set watermark to pointer's partition so next discovery skips past it  
            return "\"" + value + "\"";  
                    String partTime = extractPartitionTime(partition);
                currentWorkIndex++;
import org.apache.logging.log4j.Logger;  
            if (row == null) {
                            hadoopConf.set(entry.getKey(), entry.getValue());
        // Set watermark to the pointer's partition and use inclusive filter so that  
    @Override
     * so that partition discovery resumes from that point, then seeks within the partition to the  
    }  
    private boolean seekInclusive;
        }  
                .named(name);
     */
    private final HiveSourceConfig config;
        List<String> values = partition.getValues();
                throw e;
     */
        MetastoreCatalog.TableInfo tableInfo = catalog.getTableInfo(config.getDatabase(), config.getTable());  
        // Strip type parameters: "decimal(10,2)" -> "decimal", "varchar(255)" -> "varchar"  
     */
                        }
            currentRowIndex++;
     * Seeks to the position indicated by the pointer. Sets the watermark to the pointer's partition
    private static final Logger logger = LogManager.getLogger(HiveShardConsumer.class);  
            } else {
     * Currently supports Parquet. Additional formats (ORC, Avro, etc.) can be added here.
        return clauses.isEmpty() ? "" : String.join(" OR ", clauses);
            } catch (Exception e) {
            }
public class HiveShardConsumer implements IngestionShardConsumer<HivePointer, HiveMessage> {
            try {  
     * Only refreshes when all pending work is complete and the monitor interval has elapsed,
            MetastoreCatalog newCatalog = new ThriftMetastoreCatalog(config);
        return pendingWork.size() - currentWorkIndex;  
                List<String> files = listDataFiles(partition.getLocation());
     */  
     * correct partition and file, and skips rows up to the pointer's row index.  
        ClassLoader original = Thread.currentThread().getContextClassLoader();
        // This only triggers when all current work is done and the monitor interval has elapsed.  
                partitions.sort(Comparator.comparingInt(MetastoreCatalog.PartitionInfo::getCreateTime));  
        if (tableInputFormat != null && tableInputFormat.toLowerCase(Locale.ROOT).contains("parquet")) {
        pendingWork.clear();
    private static int[] parseDecimalParameters(String decimalType) {
            return "'" + value + "'";  
        try {  
        builder.endObject();
        throw new IOException("Unsupported input format: " + tableInputFormat);
                    }  
            default -> Types.optional(PrimitiveType.PrimitiveTypeName.BINARY).as(LogicalTypeAnnotation.stringType()).named(name);  
        // to their respective maximums so that subsequent discovery returns no existing partitions.
        }
                watermark = work.partitionName;
            Thread.currentThread().setContextClassLoader(HiveShardConsumer.class.getClassLoader());  
    }
        }
    }  
    HiveFileReader currentFileReader;
            Thread.currentThread().setContextClassLoader(original);
     * Closes and reconnects to Metastore. Used for recovery after connection failures.  
import org.apache.hadoop.fs.FileStatus;
import java.util.List;  
        int timeoutMillis
    }
     *            (year = "2024" AND month = "01" AND day > "15")  
        }
        }
                    .named(name);
        List<MetastoreCatalog.PartitionInfo> all = catalog.getAllPartitions(config.getDatabase(), config.getTable());
    public HiveShardConsumer(String clientId, int shardId, HiveSourceConfig config) {
import java.util.Comparator;
    private List<ReadResult<HivePointer, HiveMessage>> doReadNext(long maxMessages) throws Exception {
                newCatalog.close();  
        lastMetastoreQueryTime = System.currentTimeMillis();
import org.apache.parquet.schema.PrimitiveType;
                if (!status.isDirectory() && !name.startsWith("_") && !name.startsWith(".")) {  
            return;  
        }
    private void seekToPointer(HivePointer pointer, boolean includeStart) throws Exception {  
                    // Reopening after a transient failure: skip the rows that were  
    @Override
     */
        return catalog.getPartitionsByFilter(config.getDatabase(), config.getTable(), filter);
        ensureInitialized();  
            default:  
    }
        String filter = buildPartitionFilter(watermark, seekInclusive);  
     * 4.x (unquoteString) only strip the outer quotes without unescaping, so escaping
                }  
        builder.mapContents(row);  
import java.util.Collections;
                            shardId,
    }  
import java.util.stream.Collectors;  
    }
        long targetRow = includeStart ? pointer.getRowIndex() : pointer.getRowIndex() + 1;
            "Hive ingestion does not support timestamp-based pointer reset. Use 'earliest' or 'latest' instead."  
     * preventing excessive Metastore queries during active reading.  
            // and could complete warmup prematurely before the first discovery runs.  
        if (lastMetastoreQueryTime == 0) return true;  
                    if (work.files.get(f).equals(targetFile)) {
        logger.info("Table schema for shard {}: {}, partitionKeys: {}", shardId, tableSchema, partitionKeys);
    public long getPointerBasedLag(IngestionShardPointer expectedStartPointer) {  
            return doReadNext(maxMessages);
        long count = 0;  
 * The OpenSearch Contributors require contributions made to  
     * When inclusive is true, uses >= for the last key to include the watermark partition itself.
    /**
/*  
                row = currentFileReader.readNext();
                            if (currentFileReader.readNext() == null) break;
            Map<String, Object> row;
 * this file be licensed under the Apache-2.0 license or a
     */
        // defensively so a future caller cannot leak an open reader.  
        builder.field("_id", pointer.asString());
                // future partition discovery skips this partition, then move to the next.
        }
    List<String> partitionKeys;  
import org.apache.logging.log4j.LogManager;
                        return;  
            String op = (inclusive && i == segments.length - 1) ? " >= " : " > ";
        List<MetastoreCatalog.PartitionInfo> all = catalog.getAllPartitions(config.getDatabase(), config.getTable());
            }
    }  
            this.currentFileIndex = 0;
            }  
     * Resumes reading from the given pointer position. Restores watermark, seeks to the
        final String partitionTime;  
                    break;  
     * Prepares to resume the file that was being read when a transient failure occurred:  
import java.util.Map;
            FileStatus[] statuses = fs.listStatus(path);
    private String currentFile;  
        resumeRowIndex = 0;
     * @param shardId the shard ID this consumer is responsible for
            return catalog.getAllPartitions(config.getDatabase(), config.getTable());
        String[] segments = watermark.split("/");
                catalog.close();
        builder.endObject();
        }
        return sb.toString();
        String normalized = hiveType.toLowerCase(Locale.ROOT).trim();
                    .as(LogicalTypeAnnotation.decimalType(precisionScale[1], precisionScale[0]))  
    }
            if (!fs.exists(path)) {
                work.currentFileIndex--;  
        }
            for (int j = 0; j < i; j++) {  
     * Determines if it's time to query the Metastore for new partitions.
                }
        }
                    }
     * correct file and row.
                partitions = discoverByPartitionTime();  
 * Shard consumer that reads from Hive tables via Pull-Based Ingestion.  
    // Partition tracking: watermark tracks the last fully-processed partition so that
        if (watermark == null || watermark.isEmpty()) {  
 * compatible open source license.
    public IngestionShardPointer latestPointer() {  
                        currentFile,  
            case PARTITION_TIME:
            return String.join("/", partition.getValues());  
                // Current file exhausted, try the next file  
    private List<ReadResult<HivePointer, HiveMessage>> executeWithRetry(ReadAction action) {
    // Each PartitionWork tracks its files and progress. sequenceNumber is a monotonically
        if (watermarkCreateTime <= 0 && (watermark == null || watermark.isEmpty())) {  
        }
    }
                resumeRowIndex = currentRowIndex;
        builder.startObject();  
        if (watermarkPartitionTime == null || watermarkPartitionTime.isEmpty()) {
    // Cannot use Metastore filter because lexicographic order may differ from time order.
        this.shardId = shardId;  
        int close = decimalType.lastIndexOf(')');  
     * @param clientId the client identifier for this consumer
        return noPendingWork && intervalElapsed;  
        // Stop when maxMessages is reached or all pending files are consumed.
    private final int numShards;
                int[] precisionScale = parseDecimalParameters(normalized);
                // More files in current partition: open the next one
import org.opensearch.secure_sm.AccessController;  
                fetchTableSchema();
            logger.info("Shard {} reset to latest, skipping {} existing partitions", shardId, existing.size());
                return Collections.emptyList();
     * Parses precision and scale from a Hive decimal type string like "decimal(10,2)".
                return Collections.emptyList();  
            "Partition value containing both quote characters cannot be used in a Metastore filter: " + value  
            PartitionWork work = pendingWork.get(currentWorkIndex);  
                currentFile = work.files.get(work.currentFileIndex);  
        return shardId;
            } catch (Exception e) {
 * Each shard independently queries Hive Metastore for new partitions (incremental fetch),
    /**  
            return -1;
                watermarkCreateTime = existing.stream().mapToInt(MetastoreCatalog.PartitionInfo::getCreateTime).max().orElse(0);
        }
            try {
        }
            }
    private String watermark;
        discoverNewPartitions();
    /**  
    @Override  
                    return aVal.compareTo(bVal);
        } finally {  
     * Core read loop. Discovers new partitions if needed, then reads rows from the current
                } else {  
                return true;
        }
                closeCurrentReader();
    private void ensureInitialized() throws Exception {
            if (Math.floorMod(partName.hashCode(), numShards) == shardId) {
            } catch (Exception retryEx) {
    }
                        currentFile = work.files.get(f);
                        Thread.currentThread().setContextClassLoader(original);
        throw new UnsupportedOperationException(
                        shardId,
        HivePointer pointer,
        watermark = pointer.getPartitionName();
    /**
                        throw e;
        if (currentFileReader == null) {
     * return null for missing fields.  
                        hadoopConf.set("fs.s3.impl", s3FsImpl);  
                partitions = discoverByCreateTime();
                        for (Map.Entry<String, String> entry : config.getHadoopProperties().entrySet()) {  
                if (currentFileReader != null) {
    /**
            List<String> files = new ArrayList<>();  
        // Reset work queue before fetching new partitions. Callers only invoke this when
 *
        return results;
            this.files = files;
            catalog = newCatalog;
        String result = pattern;  
    }  
    }
        String targetFile = pointer.getFilePath();  
        }  
    private boolean shouldRefreshPartitions() {
            case "decimal" -> {  
                partitions = discoverByPartitionName();
                watermarkPartitionTime = work.partitionTime;
        // discoverNewPartitions fetches this partition and everything after it.
        // partition-time mode and silently skip the rows being retried.
            return new ParquetHiveFileReader(filePath, hadoopConf, tableSchema);  
            this.partitionName = partitionName;  
        closeCurrentReader();
                            pointer.getPartitionName(),
        // Handle "latest" reset: skip all existing partitions, only read new ones
    @FunctionalInterface
            builder.addField(hiveTypeToParquetType(col.getName(), col.getType()));
    public void close() throws IOException {  
            case "timestamp" -> Types.optional(PrimitiveType.PrimitiveTypeName.INT96).named(name);
    private void closeCurrentReader() {  
        this.seekInclusive = false;  
import org.apache.hadoop.fs.Path;
            if (work.currentFileIndex > 0) {
            currentFileReader = null;
                break;  
                    try {
    private String tableInputFormat;
import org.opensearch.index.IngestionShardPointer;
                });  
    @Override  
            try {
        while (currentWorkIndex < pendingWork.size()) {
        closeCurrentReader();
        this.currentWorkIndex = 0;
    public IngestionShardPointer pointerFromOffset(String offset) {
                currentFileReader.close();  
                hadoopConf = null;  
            byte[] json = rowToJson(row, ptr);
import org.apache.parquet.schema.LogicalTypeAnnotation;
        // Signals that existing partitions should be skipped. seekToPointer sets all watermarks
            case "binary" -> Types.optional(PrimitiveType.PrimitiveTypeName.BINARY).named(name);  
            if (!existing.isEmpty()) {
                    ),
        }
            }  
    /**
    String extractPartitionTime(MetastoreCatalog.PartitionInfo partition) {  
    }
        this.sequenceNumber = includeStart ? pointer.getSequenceNumber() : pointer.getSequenceNumber() + 1;
            partitionKeys = Collections.emptyList();
    /**  
            }
     * after the watermark. For composite partitions (e.g., "year=2024/month=01/day=15"),
    private MessageType tableSchema;
     * closes the reader, re-queues the file, and remembers the next undelivered row so
                currentWorkIndex = i;  
        return executeWithRetry(() -> {  
     * and reject the rare values this grammar cannot express.
        return all.stream().filter(p -> p.getCreateTime() > watermarkCreateTime).collect(Collectors.toList());  
                for (int f = 0; f < work.files.size(); f++) {
                    currentRowIndex = 0;
     * Tracks work for a single partition: its files and progress through them.
            case "tinyint", "smallint", "int" -> Types.optional(PrimitiveType.PrimitiveTypeName.INT32).named(name);
        catalog.reconnect();  
        this.watermarkCreateTime = 0;
import org.apache.parquet.schema.Types;  
    /**
            case "date" -> Types.optional(PrimitiveType.PrimitiveTypeName.INT32).as(LogicalTypeAnnotation.dateType()).named(name);
        for (MetastoreCatalog.ColumnInfo col : columns) {
                        hadoopConf = new Configuration();
                .as(LogicalTypeAnnotation.stringType())
    }
    /**
        this.pendingWork = new ArrayList<>();  
import org.opensearch.common.xcontent.json.JsonXContent;
        if (catalog != null) {
        return new HivePointer("", "", 0, 0);
        }
        tableSchema = hiveSchemaToParquet(tableInfo.getColumns());
                if (!openNextFile()) {
    private void prepareCurrentFileResume() {
                    String bVal = String.join("/", b.getValues());
                watermarkCreateTime = work.createTime;
                    }
                    // the retried action re-runs ensureInitialized and reconnects.
        int precision = 10;  
            HivePointer ptr = new HivePointer(work.partitionName, currentFile, currentRowIndex, sequenceNumber);  
        XContentBuilder builder = JsonXContent.contentBuilder();
    HiveFileReader createFileReader(String filePath) throws IOException {
            logger.warn("IO error for shard {}, attempting recovery: {}", shardId, e.getMessage());  
        tableInputFormat = tableInfo.getInputFormat();
     * Used as the projection schema so that files with fewer columns
    long lastMetastoreQueryTime;
        }
                        for (long r = 0; r < resumeRowIndex; r++) {  
     * grammar accepts backslash escapes lexically, but both Hive 3.x (TrimQuotes) and
        // When a file is exhausted, move to the next file (possibly in the next partition).  
    // Row to skip to when reopening the current file after a transient read failure.
        closeCurrentReader();
        boolean noPendingWork = currentWorkIndex >= pendingWork.size() && currentFileReader == null;
            result = result.replace("$" + partitionKeys.get(i), values.get(i));
            }  
        // Assign partitions to this shard using consistent hashing on partition name.  
        final List<String> files;
        switch (config.getPartitionOrder()) {  
                watermarkPartitionTime = existing.stream().map(this::extractPartitionTime).max(String::compareTo).orElse("");
                watermarkPartitionTime = work.partitionTime;  
            logger.info("Initializing HiveShardConsumer for shard {} with metastore URI: {}", shardId, config.getMetastoreUri());  
            }
                    reconnectMetastore();
        int paren = normalized.indexOf('(');
                }
        while (count < maxMessages) {
                        }
    static class PartitionWork {
     * Incremental partition fetch: query Metastore for partitions added after watermark.  
    /**
     * Creates a file reader based on the table's input format.
                    } finally {  
        if (currentWorkIndex >= pendingWork.size() && currentFileReader == null) {  
    }  
    private interface ReadAction {  
    // incremental discovery only fetches partitions newer than the watermark.  
                partitions.sort((a, b) -> {
            }  
            }  
                        // Skip rows up to target position  
                        );
                partitions.sort(Comparator.comparing(this::extractPartitionTime));
    private long currentRowIndex;
        this.seekInclusive = true;
        }
            }
                throw e;
    // Current processing state: pendingWork is the queue of partitions to process.  
            case "string", "varchar", "char" -> Types.optional(PrimitiveType.PrimitiveTypeName.BINARY)  
        }  
        // Step 1: Check if it's time to query Metastore for new partitions.
    }  
    int currentWorkIndex;
                if (!clause.isEmpty()) clause.append(" AND ");
        for (int i = 0; i < segments.length; i++) {  
            throw new IllegalArgumentException("Partition value ending with a backslash cannot be used in a Metastore filter: " + value);  
                logger.error(() -> new ParameterizedMessage("Failed to fetch table schema for shard {}", shardId), e);  
import java.util.Locale;
                throw new RuntimeException("Read failure for shard " + shardId + " after retry", retryEx);
        if (value.contains("'") == false) {
            } catch (IOException e) {
 */  
     * Quotes a partition value for a Metastore filter expression. The Metastore filter  
    private Configuration hadoopConf;  
import org.apache.hadoop.conf.Configuration;
            sb.append(partitionKeys.get(i)).append("=").append(values.get(i));  
        List<ReadResult<HivePointer, HiveMessage>> results = new ArrayList<>();
        // Step 3: If no file is currently open, open the next one from pending work.
        }
 */  
                            targetFile,  
                if (catalog != null) {
            if (work.currentFileIndex < work.files.size()) {
    private long sequenceNumber;
    }
     */
                            targetRow
                currentFileReader = createFileReader(currentFile);
        Path path = new Path(location);  
            String[] kv = segments[i].split("=", 2);
        }
    private List<MetastoreCatalog.PartitionInfo> discoverByCreateTime() throws IOException {
        for (int i = 0; i < pendingWork.size(); i++) {  
     * would silently change the compared value. Switch the quote character instead,  
        partitionKeys = tableInfo.getPartitionKeys();  
     * that openNextFile reopens the same file and skips the rows already delivered.
        List<MetastoreCatalog.PartitionInfo> partitions;
            ensureInitialized();
                    String aVal = String.join("/", a.getValues());  
        return HivePointer.fromString(offset);  
            } catch (IOException e) {
        // Step 2: If there's nothing to read (no pending partitions, no open file), return empty.
                    files.add(status.getPath().toString());
        List<String> clauses = new ArrayList<>();
    String watermarkPartitionTime;
    @Override
                String[] kv = segments[j].split("=", 2);
    /**  
    }
            case "bigint" -> Types.optional(PrimitiveType.PrimitiveTypeName.INT64).named(name);  
                // discovery fetches only its successors; the target itself is
            Collections.sort(files);
            throw new RuntimeException("Read failure for shard " + shardId, e);
    private long watermarkCreateTime;  
    List<String> listDataFiles(String location) throws IOException {
            }
    }
                watermark = pointer.getPartitionName();  
                prepareCurrentFileResume();
    @Override
/**
    private List<MetastoreCatalog.PartitionInfo> discoverByPartitionTime() throws IOException {  
        // all prior work is consumed, so the reader should already be closed; close it
        } catch (IOException e) {
        final int createTime;
            FileSystem fs = FileSystem.get(path.toUri(), hadoopConf);
            return files;
                break;
        return result;
                    try {
            case "boolean" -> Types.optional(PrimitiveType.PrimitiveTypeName.BOOLEAN).named(name);
    /**
        long maxMessages,  
    private static Type hiveTypeToParquetType(String name, String hiveType) {
        return false;  
                catalog = null;
            }
            PartitionWork work = pendingWork.get(currentWorkIndex);
    String partitionToName(MetastoreCatalog.PartitionInfo partition) {
            String[] parts = decimalType.substring(open + 1, close).split(",");
                    } catch (IOException e) {  
        int currentFileIndex;  
    }  
                    prepareCurrentFileResume();  
     * Opens the next data file from the pending work queue. When all files in a partition
    // Client-side filtering after full partition list retrieval is the only option.  
        }  
            return all;
            case "double" -> Types.optional(PrimitiveType.PrimitiveTypeName.DOUBLE).named(name);
            precision = Integer.parseInt(parts[0].trim());  
    // Partition-time mode: full retrieval with client-side filtering by extracted timestamp.
                            "Shard {} seeked to partition={}, file={}, row={}",  
                String name = status.getPath().getName();
        final String partitionName;
        // would exclude the target partition from the discovery below in  
            sequenceNumber = 0;
        }
        return all.stream().filter(p -> extractPartitionTime(p).compareTo(watermarkPartitionTime) > 0).collect(Collectors.toList());
            lastMetastoreQueryTime = System.currentTimeMillis();
        String baseType = paren > 0 ? normalized.substring(0, paren).trim() : normalized;
        builder.startObject("_source");
        return executeWithRetry(() -> doReadNext(maxMessages));
            return action.execute();
                        String s3FsImpl = S3HadoopFileSystem.class.getName();
     * Builds a Metastore partition filter expression that matches partitions lexicographically  
    }
                );
    // increasing counter used for pointer ordering and checkpoint recovery.
            // honors the monitor interval instead of immediately re-querying.  
     */
            sequenceNumber++;
        int scale = 0;
        this.config = config;
    ) {
                        hadoopConf.set("fs.s3n.impl", s3FsImpl);
    String buildPartitionFilter(String watermark, boolean inclusive) {  
    }  
            }
     * generates: (year > "2024") OR (year = "2024" AND month > "01") OR
    // Catalog connection for metadata queries (table schema, partition discovery)
                break;
                    // already delivered from this file.
        StringBuilder sb = new StringBuilder();  
        } catch (Exception e) {  
import org.apache.logging.log4j.message.ParameterizedMessage;
     */
     * @param config the Hive source configuration  
        this.pendingWork = new ArrayList<>();
        fetchTableSchema();
        });  
                // already in pendingWork and is consumed from there
                yield Types.optional(PrimitiveType.PrimitiveTypeName.BINARY)
        logger.info("Shard {} discovered {} candidate partitions from Metastore", shardId, partitions.size());
                    // catalog is null when the initial connection itself failed;  
import org.opensearch.core.xcontent.XContentBuilder;  
        if (currentFileReader != null) {
    }  
                        currentRowIndex
            logger.info("HiveShardConsumer initialized successfully for shard {}", shardId);  
        currentWorkIndex = 0;  
            case CREATE_TIME:
    public List<ReadResult<HivePointer, HiveMessage>> readNext(  
        // Seek to the correct file within the pointer's partition
        this.watermarkCreateTime = 0;
import java.io.IOException;
                logger.warn("Error closing file reader", e);
            clause.append(kv[0]).append(op).append(quoteFilterValue(kv[1]));
                // Return the rows already read so nothing is lost, and arrange for the  
                watermark = existing.stream().map(this::partitionToName).max(String::compareTo).orElse("");  
                    ClassLoader original = Thread.currentThread().getContextClassLoader();
     */  
            if (!segments[i].contains("=")) continue;
        }
                // Advance the watermark to the target partition so incremental  
    /**
    public IngestionShardPointer earliestPointer() {
                AccessController.doPrivilegedChecked(() -> {  
        String pattern = config.getPartitionTimePattern();
    boolean openNextFile() throws IOException {
    }
                watermarkCreateTime = work.createTime;
     */
                        }  
            if (pointer != null && !pointer.getPartitionName().isEmpty()) {
        );
            if (parts.length > 1) {
                            if (currentFileReader.readNext() == null) break;
import org.apache.parquet.schema.Type;
    }
        if (partitionKeys == null) {
            }
     */
    private final int shardId;  
        this.numShards = config.getNumShards();
        // Discover partitions from the pointer's partition onward (inclusive)
                        for (long r = 0; r < targetRow; r++) {
    }  
            case "float" -> Types.optional(PrimitiveType.PrimitiveTypeName.FLOAT).named(name);
    public int getShardId() {
                    resumeRowIndex = 0;
        List<ReadResult<HivePointer, HiveMessage>> execute() throws Exception;
                retryEx.addSuppressed(e);  
    }
    }  
    }
        for (MetastoreCatalog.PartitionInfo partition : partitions) {
        for (int i = 0; i < partitionKeys.size(); i++) {
            if (i > 0) sb.append("/");
                }
        );
        this.currentWorkIndex = 0;  
     * Returns {precision, scale}; Hive's defaults are precision 10, scale 0.  
                    logger.info("Shard {} assigned partition {} with {} files", shardId, partName, files.size());  
            // The framework treats -1 as "lag unknown"; 0 would mean fully caught up
            PartitionWork work = pendingWork.get(currentWorkIndex);
        logger.info("Shard {} seek target not found, continuing from watermark {}", shardId, watermark);
        try {
    }  
                        "Transient read failure on shard {} file {} at row {}; returning partial batch and resuming from this position",
        }  
        // All pending partitions have been fully read
        for (int i = 0; i < partitionKeys.size(); i++) {
                clause.append(kv[0]).append(" = ").append(quoteFilterValue(kv[1]));  
import org.opensearch.index.IngestionShardConsumer;
    private void reconnectMetastore() throws IOException {
                    new ParameterizedMessage(  
                    pendingWork.add(new PartitionWork(partName, partTime, files, partition.getCreateTime()));
        this.lastMetastoreQueryTime = 0;
        // Step 4: Read rows from the current file, converting each to a JSON message.
                        Thread.currentThread().setContextClassLoader(HiveShardConsumer.class.getClassLoader());  
                logger.error(() -> new ParameterizedMessage("Failed to initialize Hadoop config for shard {}", shardId), e);
        if (pendingWork == null || lastMetastoreQueryTime == 0) {
                if (!files.isEmpty()) {  
        }  
    /**
        this.watermarkPartitionTime = "";  
        if (value.contains("\"") == false) {
    List<PartitionWork> pendingWork;  
        if (shouldRefreshPartitions()) {
                        logger.info(
import org.opensearch.core.common.bytes.BytesReference;
                        currentFileReader = createFileReader(currentFile);
                        currentRowIndex = targetRow;
            if (!clause.isEmpty()) clause.append(" AND ");  
        // Each shard deterministically owns a subset of partitions (no coordination needed).
            // The metastore was just queried above; record it so the next read
                continue;
import java.util.ArrayList;  
    private List<MetastoreCatalog.PartitionInfo> discoverByPartitionName() throws IOException {
    /**
            HiveMessage msg = new HiveMessage(json, System.currentTimeMillis());
            newCatalog.connect();  
                });  
                seekToPointer(pointer, includeStart);  
        }
}
                }
        }
        boolean includeStart,
            if (work.partitionName.equals(pointer.getPartitionName())) {
                }
     * Creates a new HiveShardConsumer.
    static MessageType hiveSchemaToParquet(List<MetastoreCatalog.ColumnInfo> columns) {
                scale = Integer.parseInt(parts[1].trim());
                }
     * Extracts a timestamp string from partition values using the configured partition_time_pattern.  
        return BytesReference.toBytes(BytesReference.bytes(builder));  
     */
     * Converts Hive FieldSchema list to Parquet MessageType.
    public List<ReadResult<HivePointer, HiveMessage>> readNext(long maxMessages, int timeoutMillis) {
                        work.currentFileIndex = f + 1;  
            for (FileStatus status : statuses) {
        if (currentWorkIndex < pendingWork.size()) {  
     *  
    /**
        // All three watermark variants must be reset; a stale watermarkPartitionTime
        }
        if (open > 0 && close > open) {
                return results;  
    }
            String partName = partitionToName(partition);  
    }  
import org.apache.parquet.schema.MessageType;  
        PartitionWork(String partitionName, String partitionTime, List<String> files, int createTime) {
    @Override  
        this.sequenceNumber = 0;
            try {  
        this.watermark = config.getConsumeStartOffset();  
        if (pattern == null) {
        if (LATEST_PARTITION_SENTINEL.equals(pointer.getPartitionName())) {  
            this.partitionTime = partitionTime;
            this.createTime = createTime;  
            return all;  
            count++;  
    MetastoreCatalog catalog;
            catalog.close();  
            try {
    private static final String LATEST_PARTITION_SENTINEL = "__LATEST__";
                    currentRowIndex = resumeRowIndex;
            results.add(new ReadResult<>(ptr, msg));  
                logger.warn(
                work.currentFileIndex++;  
            // A trailing backslash would escape the closing quote and break the lexer.
                        closeCurrentReader();
    @Override
                // All files in this partition are consumed. Advance watermark so that  
 * SPDX-License-Identifier: Apache-2.0
                // next call to reopen this file and continue from the current row.
                return action.execute();
            return Collections.emptyList();
    @Override  
            PartitionWork work = pendingWork.get(i);
                if (resumeRowIndex > 0) {
        int open = decimalType.indexOf('(');
    }  
