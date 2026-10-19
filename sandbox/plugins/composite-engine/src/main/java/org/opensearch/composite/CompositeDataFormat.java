            return Set.of();
     * Returns the primary data format used for merge operations.  
 * @opensearch.experimental
     * Constructs a CompositeDataFormat with a designated primary format and a list of all constituent formats.
 * this file be licensed under the Apache-2.0 license or a
    }
    public String toString() {
    }  
 */  
 */  
    @Override
        this.dataFormats = List.copyOf(Objects.requireNonNull(dataFormats, "dataFormats must not be null"));  
 * A composite {@link DataFormat} that wraps multiple per-format {@link DataFormat} instances.
        }
 * The OpenSearch Contributors require contributions made to  
     */  
        return primaryDataFormat;
     * Constructs an empty CompositeDataFormat with no constituent formats.
import java.util.Objects;  
        this.primaryDataFormat = Objects.requireNonNull(primaryDataFormat, "primaryDataFormat must not be null");
        return dataFormats;
    }  
     */  
        this.primaryDataFormat = null;
    }
public class CompositeDataFormat extends DataFormat {
        return "CompositeDataFormat{dataFormats=" + dataFormats + '}';
    private final DataFormat primaryDataFormat;
        return Long.MIN_VALUE;
 * handled per-format by {@link CompositeDocumentInput}, not by this class.  
    }  
     *
        this.dataFormats = List.of();
    /**
import java.util.Set;
     * @param primaryDataFormat the authoritative data format used for merge operations
        return COMPOSITE_FORMAT_NAME;
    /**
    public long priority() {
    @Override  
     *
     */  
}
 * Each constituent format retains its own {@link FieldTypeCapabilities} — field routing is
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
    public CompositeDataFormat() {  
     * @return the data formats
    private final List<DataFormat> dataFormats;
        // the composite format should have the lowest priority
    @Override
    public Set<FieldTypeCapabilities> supportedFields() {  
 *
        // TODO:: Post the changes done in mappings, we will relook this
     * Returns the list of constituent data formats.  
 *
package org.opensearch.composite;
     * @return the primary data format
        return dataFormats.get(0).supportedFields();  
    }
    public List<DataFormat> getDataFormats() {
    }  
    /**
        // In case some other format can independently support,  
    public String name() {  
     */
        if (dataFormats.isEmpty()) {  
    public DataFormat getPrimaryDataFormat() {
    }  
    @Override
import java.util.List;
    /**  
    public static final String COMPOSITE_FORMAT_NAME = "composite";
import org.opensearch.index.engine.dataformat.DataFormat;
    /** Canonical format name for the composite engine. */
/**  
 * compatible open source license.
@ExperimentalApi
     *  
import org.opensearch.common.annotation.ExperimentalApi;
/*  
    public CompositeDataFormat(DataFormat primaryDataFormat, List<DataFormat> dataFormats) {
        // Union of all constituent formats' supported fields
     * @param dataFormats       all constituent data formats (including the primary)
