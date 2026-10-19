    private final String columnName;
 * The OpenSearch Contributors require contributions made to  
        VectorSchemaRoot withOrdinal = VectorUtils.appendConstantInt(batch, columnName, sourceOrdinal, allocator);
    }
    public void close() {  
 * before the rows hit the reduce sink, so post-reduce code can group by source  
    }  
import org.opensearch.analytics.spi.ExchangeSink;  
 *  
 * adds a column on the {@code feed(VSR, int)} path.
import org.apache.arrow.vector.VectorSchemaRoot;
}  
 */
 * <p>Append is zero-copy: the new VSR shares existing {@link org.apache.arrow.vector.FieldVector}s  
    @Override  
        this.columnName = columnName;  
    private final BufferAllocator allocator;  
    }
    public OrdinalAppendingSink(ExchangeSink delegate, BufferAllocator allocator, String columnName) {  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.arrow.memory.BufferAllocator;
    private final ExchangeSink delegate;
 *
 * (Query-Then-Fetch) to mark each shard's batches with their {@code ___ugsi}
    public void feed(VectorSchemaRoot batch, int sourceOrdinal) {
    public void feed(VectorSchemaRoot batch) {
/*  
    }
 * compatible open source license.
        this.delegate = delegate;
 *
 * onto every batch as a constant Int32 column. Used by Late Materialization
 * shard for fan-out fetches.
 *
 * with the input by reference; only the constant ordinal column is freshly
/**
        delegate.close();
 */  
        this.allocator = allocator;
 * <p>Lifecycle is delegated entirely to the wrapped sink — this decorator only  
 * allocated. See {@link VectorUtils#appendConstantInt}.
    @Override  
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * Pure decorator over an {@link ExchangeSink} that stamps a per-source ordinal  
 * @opensearch.internal
        delegate.feed(batch);
public final class OrdinalAppendingSink implements ExchangeSink {  
        delegate.feed(withOrdinal);  
package org.opensearch.analytics.exec;
