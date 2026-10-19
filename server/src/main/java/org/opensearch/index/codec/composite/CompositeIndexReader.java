 * Interface that abstracts the functionality to read composite index structures from the segment
    /**
     */
import org.opensearch.common.annotation.ExperimentalApi;
 *  
import org.opensearch.index.compositeindex.datacube.startree.index.CompositeIndexValues;
     *
    List<CompositeIndexFieldInfo> getCompositeIndexFields();  
 * SPDX-License-Identifier: Apache-2.0
/**
import java.util.List;
@ExperimentalApi  
 * this file be licensed under the Apache-2.0 license or a
 *
 */  
package org.opensearch.index.codec.composite;
     */
public interface CompositeIndexReader {
     * Get list of composite index fields from the segment  
/*  
 * @opensearch.experimental
}  
    /**
 * compatible open source license.
     * Get composite index values based on the field name and the field type  
 */
 * The OpenSearch Contributors require contributions made to  
    CompositeIndexValues getCompositeIndexValues(CompositeIndexFieldInfo fieldInfo) throws IOException;
import java.io.IOException;
