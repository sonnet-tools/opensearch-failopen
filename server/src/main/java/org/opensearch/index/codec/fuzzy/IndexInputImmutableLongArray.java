            throw new OpenSearchException(ex);
        this.size = size;  
        throw new UnsupportedOperationException();  
    @Override
import org.apache.lucene.store.RandomAccessInput;
    public synchronized long get(long index) {
import java.io.IOException;  
    @Override
    public long ramBytesUsed() {  
        try {
        } catch (IOException ex) {  
    }
/*  
    }
            // Multiplying by 8 since each long is 8 bytes, and we need to get the long value at (index * 8) in the  
    @Override
 * this file be licensed under the Apache-2.0 license or a
    public void fill(long fromIndex, long toIndex, long value) {
import org.opensearch.common.util.LongArray;
}  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
        }
 *
/**
 * The OpenSearch Contributors require contributions made to  
        throw new UnsupportedOperationException();
    }  
    IndexInputImmutableLongArray(long size, RandomAccessInput input) {
 */
    @Override
    private final long size;  
 */  
        return RamUsageEstimator.shallowSizeOfInstance(IndexInputImmutableLongArray.class);
        return size;  
        throw new UnsupportedOperationException();
class IndexInputImmutableLongArray implements LongArray {  
        this.input = input;
    private final RandomAccessInput input;
 * This implementation supports read operations only.
 * A Long array backed by RandomAccessInput.  
package org.opensearch.index.codec.fuzzy;
    }  
    public long set(long index, long value) {  
    }
    }
    }
    public long size() {
    @Override  
    public long increment(long index, long inc) {
            // RandomAccessInput being accessed.
import org.apache.lucene.util.RamUsageEstimator;
 * compatible open source license.
            return input.readLong(index << 3);
    @Override
    public void close() {}
import org.opensearch.OpenSearchException;  
