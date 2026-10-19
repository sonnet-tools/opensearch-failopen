            }  
        return createdWriters.get(createdWriters.size() - 1);
public class FileBackedFailableIndexingExecutionEngine implements IndexingExecutionEngine<DataFormat, DocumentInput<?>> {
            w.setStateAfterRollback(defaultStateAfterRollback);
    @Override
    public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> f) {  
    public FileBackedFailableIndexingExecutionEngine(String name, Path baseDir) throws IOException {
 * An {@link IndexingExecutionEngine} that creates {@link FileBackedFailableWriter} instances
    }
    }
import java.util.List;  
            w.writeResultSupplier = defaultWriteResultSupplier;
            public Set<FieldTypeCapabilities> supportedFields() {
 * SPDX-License-Identifier: Apache-2.0
    @Override  
        return Files.readAllLines(filePath);
    private final List<FileBackedFailableWriter> createdWriters = new ArrayList<>();
    }
 * The OpenSearch Contributors require contributions made to  
/**  
        if (defaultStateAfterRollback != null) {
    }
    public void close() {}  
    public Merger getMerger() {
 * instances writing real files to disk. Supports failure injection at the engine
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
    public DataFormat getDataFormat() {
import java.util.ArrayList;  
                return 1;
    public long getNextWriterGeneration() {
    @Override
    }
import java.nio.file.Path;
    public IndexStoreProvider getProvider() {  
        FileBackedFailableWriter w = new FileBackedFailableWriter(dataFormat, config.writerGeneration(), directory);  
        this.defaultWriteResultSupplier = supplier;
import java.util.Set;
import org.opensearch.index.engine.dataformat.DataFormat;
 * An {@link IndexingExecutionEngine} that creates {@link FileBackedFailableWriter}
    private volatile Supplier<WriteResult> defaultWriteResultSupplier;
        return dataFormat;
    }
        Files.createDirectories(this.directory);
    @Override  
import org.opensearch.index.engine.dataformat.Merger;  
        return df -> null;
 */  
                return name;
    }  
import org.opensearch.index.engine.dataformat.Writer;
import java.util.concurrent.atomic.AtomicLong;  
 * and writer level, and returns proper {@link RefreshResult} with {@link Segment}  
        return Map.of();
    public FileBackedFailableWriter getLastCreatedWriter() {
            @Override  
    public DocumentInput<?> newDocumentInput() {
package org.opensearch.index.engine.dataformat.stub;
    private final Path directory;
            public long priority() {  
    }  
            @Override  
            public String toString() {
    public static List<String> readFlushedFile(Path filePath) throws IOException {
        this.defaultStateAfterRollback = state;  
    /** Apply a Parquet-style "stay ACTIVE after rollback" semantic to every freshly created writer. */
import java.nio.file.Files;
        if (Files.exists(filePath) == false) return Collections.emptyList();  
import org.opensearch.index.engine.dataformat.WriteResult;  
        return new RefreshResult(segments);
    public void setDefaultStateAfterRollback(org.opensearch.index.engine.dataformat.WriterState state) {
    @Override
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
        };
 */
import org.opensearch.index.engine.exec.Segment;  
    public List<FileBackedFailableWriter> getAllWriters() {
        return w;
/**  
    @Override
 * {@link RefreshResult} carrying forward segments from {@link RefreshInput}.  
        }  
        return 0;  
        // Carry forward existing segments + new writer segments
    private volatile org.opensearch.index.engine.dataformat.WriterState defaultStateAfterRollback;  
 *
    }  
    public Path getDirectory() {  
        return directory;
            @Override
        List<Segment> segments = new ArrayList<>(input.existingSegments());
    }
    }
        return writerGen.getAndIncrement();  
        return new MockDocumentInput();
 */
    @Override
    }
/*  
        if (defaultWriteResultSupplier != null) {
        }  
import java.util.function.Supplier;
    public long getHeapBytesUsed() {
        return List.copyOf(createdWriters);  
    }  
import java.io.IOException;  
            public String name() {
        segments.addAll(input.writerFiles());  
 * compatible open source license.
    }
                return "FileBackedFormat{" + name + "}";
            }
import org.opensearch.index.engine.dataformat.RefreshInput;
 * writing real files to disk. Supports engine-level failure injection and returns proper
 * this file be licensed under the Apache-2.0 license or a
                return Set.of();  
            }
    }  
    private final DataFormat dataFormat;
    public long getNativeBytesUsed() {
}  
        this.dataFormat = new DataFormat() {
    private final AtomicLong writerGen = new AtomicLong();  
            }  
    public Writer<DocumentInput<?>> createWriter(WriterConfig config) {
import org.opensearch.index.engine.dataformat.RefreshResult;
        return i -> new MergeResult(Map.of());  
 * objects referencing the flushed files.
        this.directory = baseDir.resolve(name);  
        createdWriters.add(w);
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
    @Override
import java.util.Map;
    }
    }
        return 0;
import java.util.Collections;
    public void setDefaultWriteResultSupplier(Supplier<WriteResult> supplier) {  
import org.opensearch.index.engine.dataformat.WriterConfig;
import java.util.Collection;
    @Override
import org.opensearch.index.engine.dataformat.DocumentInput;
    @Override  
import org.opensearch.index.engine.dataformat.MergeResult;
            @Override
    @Override
    public RefreshResult refresh(RefreshInput input) {  
