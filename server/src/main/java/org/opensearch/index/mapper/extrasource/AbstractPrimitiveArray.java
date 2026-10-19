    public final boolean isPackedLE() {  
/**  
}
 * through generic helpers would require boxed values or indirect callbacks where callers  
 * Shared behavior for arrays backed by Java primitive arrays.
    }  
 * compatible open source license.
    }
    AbstractPrimitiveArray(int dimension) {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * <p>The small amount of repeated primitive-specific code is deliberate. Sharing it
 *
 *
    private final int dimension;
/*  
    }
    public final BytesReference packedBytes() {
 * The OpenSearch Contributors require contributions made to  
 * currently use primitive arrays directly.</p>
 * generic base class. Java generics would require boxed values such as {@code Integer},
abstract class AbstractPrimitiveArray {  
        throw new IllegalStateException("Not packed");
 */  
        return dimension;  
 */
 * type-specific accessors avoids that overhead on indexing paths.</p>  
 *
        this.dimension = dimension;
package org.opensearch.index.mapper.extrasource;
    }  
import org.opensearch.core.common.bytes.BytesReference;
        return false;
 * {@code Long}, {@code Float}, and {@code Double}; keeping primitive arrays and
    public final int dimension() {
 * <p>The concrete classes keep their own primitive array type instead of using a  
