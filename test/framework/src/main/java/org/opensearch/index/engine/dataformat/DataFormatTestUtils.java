            .ifPresent(ftc -> fieldType.setCapabilityMap(Map.of(format, ftc.capabilities())));
    private DataFormatTestUtils() {}
import org.opensearch.index.mapper.MappedFieldType;
            .stream()
            .findFirst()  
     * Assigns the capability map on a {@link MappedFieldType} so that the given {@link DataFormat}
     * Simulates what {@code FieldCapabilityAssigner.assign} does at mapping build time.  
/**
 * The OpenSearch Contributors require contributions made to  
 */  
        format.supportedFields()  
/*  
    public static void assignTestCapabilities(MappedFieldType fieldType, DataFormat format) {
     */
public final class DataFormatTestUtils {
import java.util.Map;  
}  
            .filter(ftc -> ftc.fieldType().equals(fieldType.typeName()))
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * Test utilities for the pluggable data format capability system.  
 * this file be licensed under the Apache-2.0 license or a
 */
    /**  
package org.opensearch.index.engine.dataformat;
 *
     * owns the capabilities declared in its {@link DataFormat#supportedFields()} for the field's type name.
    }
