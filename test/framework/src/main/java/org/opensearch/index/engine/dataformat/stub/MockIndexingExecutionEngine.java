        this.writerCustomizer = customizer;  
/**  
    public long getNextWriterGeneration() {
            if (e instanceof IOException) throw (IOException) e;
import java.util.Collection;
    @Override
    }
    @Override
    @Override
            Exception e = refreshFailure.get();
            writerCustomizer.accept(writer);
        this.refreshResultTransformer = transformer;
        List<Segment> segments = new ArrayList<>(refreshInput.existingSegments());  
        return df -> null;
    }
        return refreshCallCount.get();  
import java.io.IOException;
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;
    /** Rewrites this engine's refresh result, e.g. to report dropped generations. */  
        }  
    }  
import org.opensearch.index.engine.exec.EngineReaderManager;  
    @Override
        return writerGeneration.getAndIncrement();  
 * this file be licensed under the Apache-2.0 license or a
        RefreshResult result = new RefreshResult(segments);
    }
    }
import org.opensearch.index.engine.dataformat.Writer;
package org.opensearch.index.engine.dataformat.stub;
        return new MockDocumentInput();
    public IndexStoreProvider getProvider() {  
import java.util.function.Supplier;
    }  
    public MockDocumentInput newDocumentInput() {
    @Override
import java.util.List;
    }
 * compatible open source license.
        // no-op for mock  
    }
 * A mock {@link IndexingExecutionEngine} for testing purposes.
        return new MockMerger(dataFormat, directory);
            throw new IOException(e);
    @Override
    public void setWriterCustomizer(Consumer<MockWriter> customizer) {
    private final MockDataFormat dataFormat;
    private final AtomicInteger refreshCallCount = new AtomicInteger(0);
        return Map.of(getDataFormat(), new MockReaderManager(getDataFormat().name()));
import java.util.ArrayList;  
    @Override  
    public void setTragicException(Exception e) {  
    private final Path directory;
}
    private final AtomicLong seqNo = new AtomicLong(0);  
        return tragicException;  
    }  
    }
    private volatile BiFunction<RefreshInput, RefreshResult, RefreshResult> refreshResultTransformer;  
    private volatile Exception tragicException;  
    @Override  
        MockWriter writer = new MockWriter(config.writerGeneration(), dataFormat, directory, seqNo);  
    public void close() {
import static org.apache.lucene.tests.util.LuceneTestCase.createTempDir;
    public long getHeapBytesUsed() {  
    private volatile Consumer<MockWriter> writerCustomizer;
/*  
        return refreshResultTransformer == null ? result : refreshResultTransformer.apply(refreshInput, result);  
public class MockIndexingExecutionEngine implements IndexingExecutionEngine<DataFormat, MockDocumentInput> {  
    }
    public Exception getTragicException() {
    public void setRefreshResultTransformer(BiFunction<RefreshInput, RefreshResult, RefreshResult> transformer) {
    public Writer<MockDocumentInput> createWriter(WriterConfig config) {
    /** Configures every writer this engine creates, so tests need not subclass it to inject writer behaviour. */
 * The OpenSearch Contributors require contributions made to  
    public int getRefreshCallCount() {
    @Override  
            if (e instanceof RuntimeException) throw (RuntimeException) e;  
        return 0;  
        refreshFailure = supplier;
    private volatile Supplier<Exception> refreshFailure;
    public void setRefreshFailure(Supplier<Exception> supplier) {
    public Map<DataFormat, EngineReaderManager<?>> buildReaderManager(ReaderManagerConfig config) throws IOException {
        return Map.of();
    }
    }  
import org.opensearch.index.engine.dataformat.RefreshInput;
    @Override  
        refreshCallCount.incrementAndGet();
    public RefreshResult refresh(RefreshInput refreshInput) throws IOException {
import org.opensearch.index.engine.dataformat.Merger;  
import java.util.concurrent.atomic.AtomicLong;
import java.nio.file.Path;
 * SPDX-License-Identifier: Apache-2.0
    public DataFormat getDataFormat() {
    private final AtomicLong writerGeneration = new AtomicLong(0);
    @Override
 *
    }  
    }
        segments.addAll(refreshInput.writerFiles());
        }
import java.util.function.Consumer;
import org.opensearch.index.engine.dataformat.RefreshResult;  
    public MockIndexingExecutionEngine(MockDataFormat dataFormat) {
        this.directory = createTempDir();
 */
    public Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) {  
        if (writerCustomizer != null) {
        return dataFormat;
        this.tragicException = e;
    }
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
    }
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
import org.opensearch.index.engine.dataformat.WriterConfig;
import java.util.concurrent.atomic.AtomicInteger;
        return writer;
    }
    public long getNativeBytesUsed() {
 */  
import org.opensearch.index.engine.dataformat.DataFormat;
    }
        this.dataFormat = dataFormat;  
    @Override
        return 0;
        if (refreshFailure != null) {  
import org.opensearch.index.engine.exec.Segment;
    public Merger getMerger() {  
import java.util.Map;  
    @Override
import java.util.function.BiFunction;  
