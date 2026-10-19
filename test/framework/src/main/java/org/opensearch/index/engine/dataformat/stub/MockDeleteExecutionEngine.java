    public Deleter createDeleter(Writer<?> writer) {  
        @Override
import org.opensearch.index.engine.dataformat.DocumentLocation;  
package org.opensearch.index.engine.dataformat.stub;
        }
            bufferedDeletes.add(id);
    }
        private final Queue<String> bufferedDeletes = new ConcurrentLinkedQueue<>();  
import org.opensearch.index.engine.dataformat.DeleteResult;
import org.opensearch.index.engine.dataformat.DeleteExecutionEngine;
    private final List<Long> checkedOutGenerations = Collections.synchronizedList(new ArrayList<>());
import org.opensearch.index.engine.dataformat.Deleter;
    }
import org.opensearch.index.engine.dataformat.DeleteInput;  
    private static class MockDeleter implements Deleter {
        return new DeleteResult.Success(1L, 1L, 1L);
        deleters.clear();
    @Override
    }  
    }
    @Override
    }
        return deleter;  
        this.dataFormat = dataFormat;
    /** Ids passed to {@link #deleteDocument}, in call order; retained after {@link #close()}. */
    private final List<String> deletedIds = Collections.synchronizedList(new ArrayList<>());  
 * The OpenSearch Contributors require contributions made to  
    private volatile boolean deletesAppliedOnCheckout = false;
import java.util.concurrent.ConcurrentHashMap;
    public void close() throws IOException {  
            return drained;
import java.util.List;
            return generation;  
        return deletedIds;  
        @Override  
    public DataFormat getDataFormat() {  
        public long generation() {
        }
    public List<Long> checkedOutGenerations() {
            return active;
import java.util.concurrent.ConcurrentLinkedQueue;  
}  
        private final long generation;
    }
        return null;
/**
            deleter.recordBufferedDeletes(deleteInput.id());  
            Queue<String> drained = new ConcurrentLinkedQueue<>(bufferedDeletes);  
            bufferedDeletes.clear();
        MockDeleter(long generation) {  
    public void setDeletesAppliedOnCheckout(boolean applied) {
    public RefreshResult refresh(RefreshInput refreshInput) throws IOException {
    private final Map<Long, Deleter> deleters = new ConcurrentHashMap<>();
    public void recordWrite(String id, DocumentLocation location) {
            // Mirror the real engine: the live path buffers the id for the parent writer.
    /** Generations passed to {@link #onWriterCheckedOut}, in call order, including repeats. */  
            // No-op: the mock has no writer to forward row-id deletes to.  
        return deletesAppliedOnCheckout;  
        public void close() throws IOException {}
import org.opensearch.index.engine.dataformat.DataFormat;
    public DeleteResult deleteDocument(DeleteInput deleteInput, Writer<?> writer) throws IOException {
        @Override  
    }
        checkedOutGenerations.add(generation);
    /** If true, {@link #onWriterCheckedOut} reports that buffered deletes were applied. */
import java.util.ArrayList;  
        }  
        }
    }  
        public boolean isActive() {  
    @Override  
        }  
        }
        @Override
    @Override  
import org.opensearch.index.engine.dataformat.Writer;  
import java.io.IOException;
        deleters.put(writer.generation(), deleter);
import java.util.Queue;
        public boolean recordBufferedDeletes(String id) {  
import java.util.Map;  
        public Queue<String> deactivate() {
    public List<String> deletedIds() {
 * A mock {@link DeleteExecutionEngine} for testing purposes.  
    }
 * this file be licensed under the Apache-2.0 license or a
        if (deleter != null) {
        return dataFormat;
/*  
    public MockDeleteExecutionEngine(DataFormat dataFormat) {  
        @Override
import org.opensearch.index.engine.dataformat.RefreshResult;
    }  
        deletedIds.add(deleteInput.id());
        @Override
 *
 */
    @Override
    @Override
        this.deletesAppliedOnCheckout = applied;  
public class MockDeleteExecutionEngine implements DeleteExecutionEngine<DataFormat> {
        public void recordPositionalDelete(long rowId) {
        }
        Deleter deleter = new MockDeleter(writer.generation());
 */  
            return true;
 * compatible open source license.
    }
import org.opensearch.index.engine.dataformat.RefreshInput;
        private volatile boolean active = true;
    public boolean onWriterCheckedOut(long generation) throws IOException {
    private final DataFormat dataFormat;
import java.util.Collections;
    }
 * SPDX-License-Identifier: Apache-2.0
            this.generation = generation;
        Deleter deleter = deleters.get(deleteInput.generation());  
    @Override  
        return checkedOutGenerations;
            active = false;
