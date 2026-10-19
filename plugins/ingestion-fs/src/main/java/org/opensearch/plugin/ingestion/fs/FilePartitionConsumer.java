        return readFromFile(lastReadLine + 1, maxMessages);  
        return new FileOffset(Long.parseLong(offset));
import java.util.List;
            logger.info("Initialized FilePartitionConsumer for shard {} with file: {}", shardId, shardFile.getAbsolutePath());
    }
     * @param shardId shard ID  
            logger.warn("FilePartitionConsumer: File {} does not exist.", shardFile.getAbsolutePath());  
    @Override
    @Override  
import java.util.concurrent.TimeoutException;
                currentLineInReader++;  
        return latestOffset.getLine() - lastReadLine - 1;
        return shardId;
import java.io.LineNumberReader;
import java.io.IOException;
import org.opensearch.common.SuppressForbidden;  
    private long currentLineInReader = 0;  
        try (  
    /**
     */  
        this.shardId = shardId;  
    }
            while (currentLineInReader < startLine && reader.readLine() != null) {
            throw new RuntimeException("Failed to compute latest pointer", e);
                reader.close();
    }
 * compatible open source license.
        long startLine = includeStart ? offset.getLine() : offset.getLine() + 1;  
            }
    public List<ReadResult<FileOffset, FileMessage>> readNext(FileOffset offset, boolean includeStart, long maxMessages, int timeoutMillis)
import java.io.FileInputStream;  
    }
import java.nio.charset.StandardCharsets;
@SuppressForbidden(reason = "using Java file APIs for local testing purpose")
        }  
import java.io.BufferedReader;
        if (lastReadLine < 0) {
     */
     * @param config the file source config
    public FilePartitionConsumer(FileSourceConfig config, int shardId) {
import java.io.File;
/*  
    public long getPointerBasedLag(IngestionShardPointer expectedStartPointer) {
        FileOffset latestOffset = (FileOffset) latestPointer();
    @Override
        }
            // Haven't read anything yet, use the expected start pointer  
        }  
 *
        // return lag as number of remaining lines from lastReadLineNumber
    }  
    }  
                new InputStreamReader(new FileInputStream(shardFile), StandardCharsets.UTF_8)
        } else {
                currentLineInReader++;  
            }
    public IngestionShardPointer latestPointer() {
package org.opensearch.plugin.ingestion.fs;
        if (!shardFile.exists()) {
    @Override
import org.apache.logging.log4j.LogManager;
        if (reader != null) {
        if (!shardFile.exists()) {  
    }
 * File-based consumer for testing ingestion. Reads from ${baseDir}/${stream}/${shardId}.ndjson.
 * this file be licensed under the Apache-2.0 license or a
            return new FileOffset(lineNumberReader.getLineNumber());
    private BufferedReader reader = null;
    public void close() throws IOException {  
        String stream = config.getStream();
        if (!shardFile.exists()) {
    private final int shardId;  
            if (reader == null) {
 * The OpenSearch Contributors require contributions made to  
        return new FileOffset(0);  
     * @param timestampMillis the timestamp in milliseconds
        } catch (IOException e) {  
        } catch (IOException e) {  
                reader = new BufferedReader(new FileReader(shardFile));  
            if (startLine < currentLineInReader) {
        String baseDir = config.getBaseDirectory();  
    private long lastReadLine = -1;
                currentLineInReader = 0;
    @Override  
            return Math.max(0, latestOffset.getLine() - startLine);
                // do nothing  
import java.io.InputStreamReader;  
        throws TimeoutException {
        }
    private static final Logger logger = LogManager.getLogger(FilePartitionConsumer.class);  
        return readFromFile(startLine, maxMessages);
            }
    public List<ReadResult<FileOffset, FileMessage>> readNext(long maxMessages, int timeoutMillis) throws TimeoutException {
    public IngestionShardPointer pointerFromTimestampMillis(long timestampMillis) {
    @Override
    private synchronized List<ReadResult<FileOffset, FileMessage>> readFromFile(long startLine, long maxLines) throws TimeoutException {  
    @Override
    }  
 * SPDX-License-Identifier: Apache-2.0
     * Initialize a FilePartitionConsumer that will read messages from provided file and index documents.
}
    }
import java.util.ArrayList;  
                lastReadLine = currentLineInReader;
            return 0;
        this.shardFile = new File(baseDir, stream + File.separator + shardId + ".ndjson");
    public IngestionShardPointer pointerFromOffset(String offset) {
                FileOffset offset = new FileOffset(currentLineInReader);
            )  
/**
            }
import java.io.FileReader;
import org.apache.logging.log4j.Logger;
            return new FileOffset(0);  
            while (lineNumberReader.readLine() != null) {
            long startLine = ((FileOffset) expectedStartPointer).getLine();
            reader.close();
        try {
            throw new RuntimeException("Failed to read from file: " + shardFile.getAbsolutePath(), e);
     * Timestamp-based pointer is not supported in file mode. Defaults to earliest pointer.  
    private final File shardFile;
                results.add(new ReadResult<>(offset, message));
        return results;
            String line;  
                reader = new BufferedReader(new FileReader(shardFile));  
    public int getShardId() {  
                currentLineInReader = 0;
 */  
            while (results.size() < maxLines && (line = reader.readLine()) != null) {
     * @return shard pointer
 */  
                lastReadLine = currentLineInReader;
import org.opensearch.index.IngestionShardConsumer;
            }
        if (!shardFile.exists()) {  
        ) {
        }
    public IngestionShardPointer earliestPointer() {
    @Override  
import org.opensearch.index.IngestionShardPointer;
    /**  
        }
            return results;
public class FilePartitionConsumer implements IngestionShardConsumer<FileOffset, FileMessage> {
        return earliestPointer();  
    @Override
        }
            LineNumberReader lineNumberReader = new LineNumberReader(
                FileMessage message = new FileMessage(line.getBytes(StandardCharsets.UTF_8), System.currentTimeMillis());  
        List<ReadResult<FileOffset, FileMessage>> results = new ArrayList<>();
        }  
    }
    }
