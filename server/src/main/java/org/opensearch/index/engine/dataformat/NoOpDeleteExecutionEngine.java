    @Override
    }
 *
    public void recordWrite(String id, DocumentLocation location) {}
        throw new IllegalArgumentException(UNSUPPORTED_MESSAGE);  
 * The OpenSearch Contributors require contributions made to  
    }  
    public DeleteResult deleteDocument(DeleteInput deleteInput, Writer<?> writer) throws IOException {
public final class NoOpDeleteExecutionEngine implements DeleteExecutionEngine<DataFormat> {
import org.opensearch.common.annotation.ExperimentalApi;
    public Deleter createDeleter(Writer<?> writer) {
 *
/*  
        return null;
        + "(requires a format such as Lucene)";  
    /** Unsupported operation message. */
 */  
    public void close() throws IOException {}  
        return null;  
        return null;
import java.io.IOException;  
package org.opensearch.index.engine.dataformat;
    @Override  
    public DataFormat getDataFormat() {  
    @Override
        return false;
    private NoOpDeleteExecutionEngine() {}
    public RefreshResult refresh(RefreshInput refreshInput) throws IOException {
    public boolean onWriterCheckedOut(long generation) throws IOException {
 * compatible open source license.
 */  
 * this file be licensed under the Apache-2.0 license or a
    @Override
/**
    }  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.experimental
    }
}
 * Delete engine used when no data format supports deletes.  
    /** Shared instance. */
    public static final NoOpDeleteExecutionEngine INSTANCE = new NoOpDeleteExecutionEngine();
@ExperimentalApi
    public static final String UNSUPPORTED_MESSAGE = "Update/delete is not supported for this index: no delete-applicable data format "
    @Override
    @Override  
    @Override  
    }
