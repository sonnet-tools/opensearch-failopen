 * streaming transport (zero-copy over gRPC). Row-oriented accessors
     * @return the value (may be null)
 * SPDX-License-Identifier: Apache-2.0
 *
 * compatible open source license.
 * @opensearch.internal
public interface EngineResultBatch {
 * Primary shape is the Arrow {@link VectorSchemaRoot} returned by
     * @param rowIndex  zero-based row index
    Object getFieldValue(String fieldName, int rowIndex);
 *
    /**
     */  
 * the iterator. Accessing a batch after the iterator has advanced may throw
    /**
 * The OpenSearch Contributors require contributions made to  
/*  
     */
 * A batch is only valid until the next call to {@link java.util.Iterator#next()}
    List<String> getFieldNames();
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.analytics.backend;
    int getRowCount();
     * Returns the value at the given row index for the named field.
     *
 * are a convenience view over the same data.  
     */  
 * <p>
/**
}
 * ({@link #getFieldNames()}, {@link #getRowCount()}, {@link #getFieldValue})
     * Number of rows in this batch.
 * on the parent stream's iterator. The underlying data buffers may be reused  
    VectorSchemaRoot getArrowRoot();  
 */  
 * {@link IllegalStateException}.  
 * <p>
     * Ordered list of field (column) names in this batch.  
 * {@link #getArrowRoot()} — the native columnar representation used by the  
 * Read-only view of a single record batch.  
     * The Arrow VSR backing this batch
    /**  
 */  
 * across batches, so callers must extract all needed values before advancing
     * @param fieldName column name  
    /**  
     */
import java.util.List;  
import org.apache.arrow.vector.VectorSchemaRoot;
