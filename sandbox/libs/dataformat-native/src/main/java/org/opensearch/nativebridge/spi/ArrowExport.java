 */  
    }
 * RAII container for Arrow C Data Interface exports.
import org.apache.arrow.c.ArrowArray;
    public void close() {
 * SPDX-License-Identifier: Apache-2.0
     */
        return arrowArray.memoryAddress();  
    public long getArrayAddress() {
     */
public record ArrowExport(ArrowArray arrowArray, ArrowSchema arrowSchema) implements AutoCloseable {
        if (arrowArray != null) {
package org.opensearch.nativebridge.spi;
 *  
 * @param arrowSchema the Arrow schema
 *  
    /**  
import org.apache.arrow.c.ArrowSchema;
            arrowSchema.release();
        }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
     * Returns the memory address of the Arrow schema.
            arrowArray.close();
 * The OpenSearch Contributors require contributions made to  
        return arrowSchema.memoryAddress();  
     * @return the native memory address of the schema  
            arrowArray.release();  
    /**  
 * providing memory address accessors for JNI handoff and automatic resource cleanup on close.
 * @param arrowArray  the Arrow array (may be null for schema-only exports)
 */  
     * @return the native memory address of the array  
    @Override  
}
    }
        }  
/**
/*  
 *
            arrowSchema.close();
    public long getSchemaAddress() {
     * Returns the memory address of the Arrow array.
 * <p>Wraps an {@link ArrowArray} and {@link ArrowSchema} allocated via the Arrow C Data Interface,
    }
        if (arrowSchema != null) {  
     *
     *
