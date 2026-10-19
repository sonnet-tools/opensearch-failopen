import java.util.List;
    public void setRollbackKeepsActive(boolean keepActive) {
     * Configure addDoc to admit the doc (counter advances) and then throw. Used to model
     * the Parquet rotation-after-admit failure mode.
        this.dataFormat = dataFormat;
    @Override  
import org.opensearch.index.engine.dataformat.DataFormat;
            }  
    private final long writerGeneration;
import java.nio.file.Path;  
            WriteResult result = writeResultSupplier.get();  
 *
    private volatile Supplier<RuntimeException> throwAfterAdmit;  
     * Parquet-style writer where a row is committed before a downstream operation fails.
    @Override
            .build();  
     * means rollback always retires (Lucene-style).  
    @Override
    /** If true, flush returns no files when the writer never received an addDoc (a delete-only writer). */
    @Override
    private final DataFormat dataFormat;  
        return writerGeneration;  
 * A mock {@link Writer} for testing purposes.
    }
        }
    @Override
import org.opensearch.index.engine.dataformat.FileInfos;
        this.throwAfterAdmit = throwSupplier;
    public void setEmptyFlushWhenNoDocs(boolean emptyFlush) {  
import java.util.ArrayList;
            seqNo.getAndIncrement();
        if (emptyFlushWhenNoDocs && addDocCallCount.get() == 0) {
        return state;
        return true;
    private volatile boolean emptyFlushWhenNoDocs = false;
        this.writerGeneration = writerGeneration;
/*  
        }
    }
    @Override  
    /**  
    public void setFailureKeepsActive(boolean keepActive) {
import org.opensearch.index.engine.dataformat.WriteResult;
        this.state = state;  
    }
    }
        this.emptyFlushWhenNoDocs = emptyFlush;
 * compatible open source license.
        this.writeResultSupplier = supplier;
     */
        docs.add(d);
            return result;
        long seq = seqNo.getAndIncrement();  
package org.opensearch.index.engine.dataformat.stub;
    public void setState(WriterState state) {
    }
    /**
    @Override
            .writerGeneration(writerGeneration)  
    public MockWriter(long writerGeneration, DataFormat dataFormat, Path directory, AtomicLong seqNo) {  
    }
            return FileInfos.builder().build();
 * The OpenSearch Contributors require contributions made to  
        WriterFileSet fileSet = WriterFileSet.builder()
            if (result instanceof WriteResult.Failure && state == WriterState.ACTIVE && failureKeepsActive == false) {
    /** Test-only: directly inject a state to simulate post-failure conditions. */
            throw new IllegalStateException("Cannot rollback to " + rowCount + ": only " + docs.size() + " docs");  
import org.opensearch.index.engine.dataformat.Writer;
        this.failureKeepsActive = keepActive;  
        addDocCallCount.incrementAndGet();
    }
     * modelling a per-doc rejection the writer has already reconciled. Default false retires it.  
import org.opensearch.index.engine.dataformat.FlushInput;  
    }
    private volatile boolean failureKeepsActive = false;
        this.seqNo = seqNo;
    }
     */  
    }  
    private Supplier<WriteResult> writeResultSupplier;
                state = WriterState.PENDING_ROLLBACK;
            .addFile("data_gen" + writerGeneration + ".parquet")
        state = WriterState.CLOSED;  
     */
    private volatile WriterState state = WriterState.ACTIVE;  
        this.rollbackKeepsActive = keepActive;  
    public WriteResult addDoc(MockDocumentInput d) {
    /** Test-only: switch rollback behavior to "stay ACTIVE" (Parquet-style). */
    }  
        assert state == WriterState.ACTIVE : "addDoc requires ACTIVE state but was " + state;  
    private final AtomicInteger addDocCallCount = new AtomicInteger();
import java.util.concurrent.atomic.AtomicLong;
        while (docs.size() > rowCount) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.engine.dataformat.WriterState;  
    public void setThrowAfterAdmit(Supplier<RuntimeException> throwSupplier) {
    public int getAddDocCallCount() {
public class MockWriter implements Writer<MockDocumentInput> {
     * If set, addDoc admits the doc (counter++) and then throws this exception. Models a  
        if (writeResultSupplier != null) {
    /**
    public boolean isSchemaMutable() {
            docs.remove(docs.size() - 1);  
    public long mappingVersion() {  
 * this file be licensed under the Apache-2.0 license or a
            throw throwAfterAdmit.get();  
    public void close() {
    public long generation() {
    }
    public FileInfos flush(FlushInput flushInput) {  
    private final Path directory;
        return new WriteResult.Success(1L, 1L, seq);
    }  
/**
    }
        return 0;
        }
     * If true, a {@link WriteResult.Failure} from the write-result supplier leaves the writer ACTIVE,
            // State remains ACTIVE so the caller can call rollbackLastDoc to undo, just as
        return FileInfos.builder().putWriterFileSet(dataFormat, fileSet).build();
        }  
        if (throwAfterAdmit != null) {  
        state = rollbackKeepsActive ? WriterState.ACTIVE : WriterState.RETIRED_FLUSHABLE;
        this.directory = directory;  
        if (rowCount > docs.size()) {
     * If true, rollbackTo keeps the writer ACTIVE (Parquet-style). Default false
    public void updateMappingVersion(long newVersion) {}
    @Override  
    /**
    @Override
import java.util.concurrent.atomic.AtomicInteger;  
    public WriterState state() {
            .directory(directory)
    }
    private final List<MockDocumentInput> docs = new ArrayList<>();
    }  
            .addNumRows(docs.size())
import org.opensearch.index.engine.exec.WriterFileSet;
        }
            // Admit the doc (mirroring Parquet's setRowCount + acceptedRows++), then throw.
    public void setWriteResultSupplier(Supplier<WriteResult> supplier) {  
    private final AtomicLong seqNo;  
     */
import java.util.function.Supplier;
 */  
    private volatile boolean rollbackKeepsActive = false;
 */  
}
        return addDocCallCount.get();  
            // ParquetWriter.addDoc does on top of VSRManager.  
    public void rollbackTo(long rowCount) {
            docs.add(d);
