    /** Destroy a Box pointer (ObjectStore trait object). */
        );  
 * The OpenSearch Contributors require contributions made to  
    static long createTieredObjectStore(long localPtr, long remotePtr) {
    static void destroyObjectStoreBoxPtr(long ptr) {
    }
        );
import java.lang.foreign.FunctionDescriptor;  
 * Test helper for creating real native TieredObjectStore pointers via FFM.  
    /** Get a Box pointer (ObjectStore trait object) for DataFusion from a TieredObjectStore. */
    }
        TS_GET_BOX_PTR = linker.downcallHandle(
        TS_DESTROY_BOX_PTR = linker.downcallHandle(
    }  
            throw new RuntimeException("Failed to destroy TieredObjectStore", t);  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)  
    private static final MethodHandle TS_DESTROY;
    private static final MethodHandle TS_GET_BOX_PTR;
        } catch (Throwable t) {
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
 *
            NativeLibraryLoader.checkResult((long) TS_DESTROY_BOX_PTR.invokeExact(ptr));
        } catch (Throwable t) {
    static {
            throw new RuntimeException("Failed to get object store box ptr", t);  
        }
            lib.find("ts_create_tiered_object_store").orElseThrow(),  
}  
    static long getObjectStoreBoxPtr(long tieredStorePtr) {
    private NativeStoreTestHelper() {}
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
    private static final MethodHandle TS_DESTROY_BOX_PTR;  
    }
 * SPDX-License-Identifier: Apache-2.0
            NativeLibraryLoader.checkResult((long) TS_DESTROY.invokeExact(ptr));
            lib.find("ts_destroy_tiered_object_store").orElseThrow(),
        var lib = NativeLibraryLoader.symbolLookup();  
        );
            lib.find("ts_destroy_object_store_box_ptr").orElseThrow(),  
    /** Create a TieredObjectStore. Pass 0 for default LocalFileSystem / no remote. */
        );
        try {  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
 */  
final class NativeStoreTestHelper {
import java.lang.foreign.ValueLayout;
        TS_CREATE = linker.downcallHandle(
        } catch (Throwable t) {
        }
            lib.find("ts_get_object_store_box_ptr").orElseThrow(),
    static void destroyTieredObjectStore(long ptr) {
            return NativeLibraryLoader.checkResult((long) TS_CREATE.invokeExact(localPtr, remotePtr));
            throw new RuntimeException("Failed to create TieredObjectStore", t);  
    }
 * Avoids a compile dependency on parquet-data-format by calling the native
 * compatible open source license.
    /** Destroy a TieredObjectStore. */
 */  
import java.lang.invoke.MethodHandle;  
        try {  
        var linker = Linker.nativeLinker();
        try {  
        try {  
/**
        }
        }
import java.lang.foreign.Linker;
    private static final MethodHandle TS_CREATE;  
/*  
package org.opensearch.be.datafusion;
            return NativeLibraryLoader.checkResult((long) TS_GET_BOX_PTR.invokeExact(tieredStorePtr));
        } catch (Throwable t) {
 * symbols directly through the shared native library.
            throw new RuntimeException("Failed to destroy object store box ptr", t);  
        TS_DESTROY = linker.downcallHandle(  
