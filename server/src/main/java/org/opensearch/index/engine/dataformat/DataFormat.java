 * SPDX-License-Identifier: Apache-2.0
     * Returns the priority of this data format. Higher priority formats are preferred
 *
    public abstract String name();
    }
    public abstract long priority();  
     *  
import org.opensearch.common.annotation.ExperimentalApi;
     *
 *  
     */
        if (this == o) return true;
 * Represents a data format for storing and managing index data, with declared capabilities.
     */  
    public final int hashCode() {
    @Override
        if (o instanceof DataFormat == false) return false;  
        return Objects.hashCode(name());  
import java.util.Set;
    public final boolean equals(Object o) {
 * <p>  
     * @return the priority value
    /**
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
     */  
 */  
/**  
 */
@ExperimentalApi  
package org.opensearch.index.engine.dataformat;
    /**
    public abstract Set<FieldTypeCapabilities> supportedFields();
 * Each data format (e.g., Lucene, Parquet) declares what storage and query capabilities it supports.
 * compatible open source license.
 * @opensearch.experimental
     *
    }
/*  
}
     * @return the supported field type capabilities
public abstract class DataFormat {
     * when multiple formats can handle the same field type.
        return Objects.equals(name(), ((DataFormat) o).name());
import java.util.Objects;  
    /**  
     * Returns the set of field type capabilities supported by this data format.  
     * @return the data format name
     * Returns the unique name of this data format.  
 * Equality is based on the format {@link #name()} — there should be one {@code DataFormat} instance
 * per unique name. This allows {@code DataFormat} to be used safely as a {@link java.util.Map} key.
    @Override  
