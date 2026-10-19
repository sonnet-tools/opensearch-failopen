        if (this.key == null || other.key == null) {
    /**  
        this.key = key;
 *
        }
 * @param <K> the type of the underlying key. K must implement equals(), or else ICacheKey.equals()
 */  
    private boolean dropStatsForDimensions;
    }  
    }
     * If this key is invalidated and dropDimensions is true, the ICache implementation will also drop all stats,
        if (key == null) {
package org.opensearch.common.cache;
    /**
import java.util.List;  
 * A key wrapper used for ICache implementations, which carries dimensions with it.  
     */
            estimate += dim.length();
        if (o == this) {
        ICacheKey other = (ICacheKey) o;
 * SPDX-License-Identifier: Apache-2.0
public class ICacheKey<K> {
    public final K key; // K must implement equals()
        }  
 *           won't work properly and cache behavior may be incorrect!
            return false;  
    public ICacheKey(K key, List<String> dimensions) {
    /**
        this.dimensions = dimensions;  
    public ICacheKey(K key) {  
/**
     * Constructor to use when no dimensions are needed.
            return dimensions.hashCode();
        long estimate = underlyingKeyRamBytes;  
        return dropStatsForDimensions;
 * this file be licensed under the Apache-2.0 license or a
    // As K might not be Accountable, directly pass in its memory usage to be added.
    }  
@ExperimentalApi  
     * including hits/misses/evictions, with this combination of dimension values.  
        this.key = key;
        }
    public void setDropStatsForDimensions(boolean newValue) {
            return true;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.ExperimentalApi;
    public boolean equals(Object o) {  
    @Override
     */  
     */
    }  
            return true;
        }  
        }
    public boolean getDropStatsForDimensions() {
 *  
 * @opensearch.experimental
            return false;  
    @Override
 */
        return 31 * key.hashCode() + dimensions.hashCode();
            return false;
}
        }  
    }
    public long ramBytesUsed(long underlyingKeyRamBytes) {
     * Constructor to use when specifying dimensions.
    }
        dropStatsForDimensions = newValue;  
        return estimate;
        if (o.getClass() != ICacheKey.class) {
        if (o == null) {
/*  
        for (String dim : dimensions) {
        return this.key.equals(other.key);
        this.dimensions = List.of();
        if (!dimensions.equals(other.dimensions)) {
 * compatible open source license.
        }  
        }  
    }
    public final List<String> dimensions; // Dimension values. The dimension names are implied.  
        if (this.key == null && other.key == null) {
            return false;
    public int hashCode() {  
