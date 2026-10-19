     *  
    private ReaderHandle(long existingPtr) {
    }
 */  
     */
     * Wraps a pre-existing native pointer without taking ownership (test only).
        List<String> sortFields,
        List<MonoFileWriterSet> segments,  
 * SPDX-License-Identifier: Apache-2.0
    /** Wraps an existing pointer without taking ownership. */  
    ) {
 * compatible open source license.
    @Override  
        if (ownsPointer) {
        super(existingPtr);
 */  
        this.ownsPointer = false;  
import org.opensearch.analytics.backend.jni.NativeHandle;
     * @param path the directory path containing data files
import java.util.List;
    public ReaderHandle(
/*  
    }
     * file paired with its writer generation (sourced from the catalog snapshot).
    private final boolean ownsPointer;  
public final class ReaderHandle extends NativeHandle {
        List<String> sortOrders  
 *
    public static ReaderHandle wrap(long existingPtr) {
        return new ReaderHandle(existingPtr);  
     * and {@link MonoFileWriterSet}s. Each entry represents one parquet segment — a single
    }
     * @param segments the per-segment file sets to read
        String path,
        NativeStoreHandle dataformatAwareStoreHandle,
     * @param dataformatAwareStoreHandle per-format native store handle (null = local, live = use store pointer)  
/**
import org.opensearch.index.engine.exec.MonoFileWriterSet;
        super(NativeBridge.createDatafusionReader(path, segments, dataformatAwareStoreHandle, sortFields, sortOrders));
     * @param existingPtr the native pointer to wrap  
}
    /**
 * Type-safe handle for native reader.
package org.opensearch.be.datafusion.nativelib;
            NativeBridge.closeDatafusionReader(ptr);  
        this.ownsPointer = true;  
    /**
     * Creates a reader handle by allocating a native DataFusion reader for the given path  
 * The OpenSearch Contributors require contributions made to  
     * @param sortOrders index.sort.order values ("asc"/"desc"), parallel to {@code sortFields}.
        }
     */  
    protected void doClose() {
     * @param sortFields index.sort.field values (or empty if no index sort). Parallel to {@code sortOrders}.
import org.opensearch.plugins.NativeStoreHandle;  
    }
 * this file be licensed under the Apache-2.0 license or a
