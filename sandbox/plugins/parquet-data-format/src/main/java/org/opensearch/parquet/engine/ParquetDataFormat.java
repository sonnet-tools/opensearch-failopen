 * The OpenSearch Contributors require contributions made to  
 * {@link org.opensearch.parquet.ParquetDataFormatPlugin#getDataFormat()}.  
        return ArrowFieldRegistry.getSupportedFieldCapabilities();
    public long priority() {
 * this file be licensed under the Apache-2.0 license or a
    @Override
    public static final String PARQUET_DATA_FORMAT_NAME = "parquet";
    public ParquetDataFormat() {}
import java.util.Set;
package org.opensearch.parquet.engine;
 *
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.engine.dataformat.DataFormat;
 *  
import org.opensearch.parquet.fields.ArrowFieldRegistry;  
    /** Creates a new ParquetDataFormat. */
    public Set<FieldTypeCapabilities> supportedFields() {  
 * compatible open source license.
    public String name() {
 * <p>Declares the format name ({@code "parquet"}), priority, and supported field type
        return PARQUET_DATA_FORMAT_NAME;  
    @Override  
    /** The parquet data format name constant. */
        return 0;
}  
 * Data format descriptor for the Parquet format.
/*  
 */
 */  
 * capabilities. Registered with OpenSearch's data format framework via
public class ParquetDataFormat extends DataFormat {
    }
    }
    @Override
    }  
/**
