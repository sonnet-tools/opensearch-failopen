        return docs.size();
            if (result != null) {
     * State to transition into when {@link #rollbackTo(long)} succeeds. Defaults to
        Files.write(file, docs, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
import java.nio.file.Path;
    public long mappingVersion() {
        rollbackCalled = true;
        return state;
     * {@link #setStateAfterRollback}.
/*  
import java.util.List;
    public Path getFilePath() {
            .addNumRows(docs.size())
        }
    @Override  
        this.directory = directory;
                }
 */  
import org.opensearch.index.engine.dataformat.WriterState;  
            .writerGeneration(writerGeneration)
    }
}
    public volatile IOException rollbackFailure;  
import java.io.IOException;  
     */
    }
    }
        closed = true;
    @Override
public class FileBackedFailableWriter implements Writer<DocumentInput<?>> {
    volatile boolean rollbackCalled;
    /**
    int numRows() {  
 */
        return closed;  
    }
import java.nio.file.StandardOpenOption;  
import org.opensearch.index.engine.dataformat.FileInfos;  
import java.util.concurrent.atomic.AtomicInteger;  
import org.opensearch.index.engine.dataformat.DataFormat;
     * Pass {@link WriterState#ACTIVE} for Parquet-style "stay ACTIVE after a clean rollback".
    public FileInfos flush(org.opensearch.index.engine.dataformat.FlushInput flushInput) throws IOException {
            }
    @Override
    public FileBackedFailableWriter(DataFormat format, long writerGeneration, Path directory) {
import org.opensearch.index.engine.exec.WriterFileSet;
    }
        this.fileName = "data_gen" + writerGeneration + "_" + format.name() + ".txt";  
    public void updateMappingVersion(long newVersion) {}
            .build();
        docs.add("doc_" + callNum);  
    }
                    state = WriterState.PENDING_ROLLBACK;
    public volatile Supplier<WriteResult> writeResultSupplier;
        state = stateAfterRollback;  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    /**  
    @Override
            .addFile(fileName)  
    public void setStateAfterRollback(WriterState state) {  
    public long generation() {
        WriterFileSet fileSet = WriterFileSet.builder()  
     * cleanly undo the last row return to {@link WriterState#ACTIVE}; tests can flip via  
        assert state == WriterState.ACTIVE : "addDoc requires ACTIVE state but was " + state;
        state = WriterState.CLOSED;  
    }
    public WriterState state() {
     * Test-only: override the post-rollback state (default {@link WriterState#RETIRED_FLUSHABLE}).  
    private volatile WriterState state = WriterState.ACTIVE;
    List<String> getDocs() {
import java.nio.file.Files;
        return directory.resolve(fileName);  
    private final DataFormat format;
package org.opensearch.index.engine.dataformat.stub;
    private final long writerGeneration;
    @Override  
    final AtomicInteger addDocCallCount = new AtomicInteger();  
        Path file = directory.resolve(fileName);
    public WriteResult addDoc(DocumentInput<?> d) {
import org.opensearch.index.engine.dataformat.WriteResult;
 * compatible open source license.
     */
    }
import java.util.ArrayList;
    private final List<String> docs = new ArrayList<>();
 * verification in tests. Supports failure injection, rollback, and produces real
 * A writer that persists doc IDs as lines in a text file for file-level consistency
    }  
        }
 * The OpenSearch Contributors require contributions made to  
    }
        return List.copyOf(docs);  
        return fileName;
    @Override  
    @Override  
        return writerGeneration;
            // selective per-call failure injection where most calls should succeed normally.
            .directory(directory)
                if (result instanceof WriteResult.Failure && state == WriterState.ACTIVE) {  
            docs.remove(docs.size() - 1);
import org.opensearch.index.engine.dataformat.DocumentInput;
        this.writerGeneration = writerGeneration;
    }  
    }
import org.opensearch.index.engine.dataformat.Writer;
        }
    private volatile boolean closed;  
    }
    String getFileName() {
    @Override  
                return result;  
        if (rollbackFailure != null) {  
            // Null result means "fall through to default success behavior" — useful for  
        return new WriteResult.Success(1L, 1L, callNum);
            throw rollbackFailure;
        return FileInfos.builder().putWriterFileSet(format, fileSet).build();  
 *
import java.util.function.Supplier;
    public boolean isClosed() {
    /** Returns the doc IDs currently held in memory (before flush). */
        if (rowCount > docs.size()) {  
        return 0;  
        if (flushFailure != null) throw flushFailure;  
        while (docs.size() > rowCount) {  
        int callNum = addDocCallCount.incrementAndGet();  
     * {@link WriterState#RETIRED_FLUSHABLE} — Lucene-style. Parquet-style writers that can
            throw new IllegalStateException("Cannot rollback to " + rowCount + ": only " + docs.size() + " docs");
 * {@link WriterFileSet} on flush. Tracks close state for writer pool lifecycle assertions.  
    public void rollbackTo(long rowCount) throws IOException {
        this.format = format;  
    private final Path directory;  
    }  
    private volatile WriterState stateAfterRollback = WriterState.RETIRED_FLUSHABLE;  
        if (writeResultSupplier != null) {
 * SPDX-License-Identifier: Apache-2.0
            WriteResult result = writeResultSupplier.get();
    volatile IOException flushFailure;
    public void close() {
        this.stateAfterRollback = state;
    public boolean isSchemaMutable() {  
    private final String fileName;
    }
/**  
        return true;
