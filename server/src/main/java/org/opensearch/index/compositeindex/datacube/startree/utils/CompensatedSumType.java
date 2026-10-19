 */  
import org.opensearch.index.mapper.FieldValueConverter;
}  
    @Override
 * The OpenSearch Contributors require contributions made to  
 */  
    public double toDoubleValue(long value) {  
 * @opensearch.internal
    public CompensatedSumType() {}  
package org.opensearch.index.compositeindex.datacube.startree.utils;
/*  
/**
        return DOUBLE.toDoubleValue(value);
 * SPDX-License-Identifier: Apache-2.0
    }
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.DOUBLE;  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * Field value converter for CompensatedSum - it's just a wrapper over Double  
 *
 *
public class CompensatedSumType implements FieldValueConverter {
