        long bytes = (long) allocated.invokeExact();  
import java.lang.foreign.SymbolLookup;
 * Tests that the native jemalloc metrics functions are available and return valid data.
        assertTrue("allocated bytes should be positive, got " + bytes, bytes > 0);
    }
        MethodHandle resident = linker.downcallHandle(
            FunctionDescriptor.of(ValueLayout.JAVA_LONG)
    }
import java.lang.foreign.Linker;
package org.opensearch.nativebridge.spi;
            lookup.find("native_jemalloc_allocated_bytes").orElseThrow(),  
        Linker linker = Linker.nativeLinker();
    public void testAllocatedBytesIsPositive() throws Throwable {
        Linker linker = Linker.nativeLinker();  
            lookup.find("native_jemalloc_resident_bytes").orElseThrow(),
 */
 * this file be licensed under the Apache-2.0 license or a
        long bytes = (long) resident.invokeExact();
    public void testResidentBytesIsPositive() throws Throwable {
        SymbolLookup lookup = NativeLibraryLoader.symbolLookup();  
 * The OpenSearch Contributors require contributions made to  
        );
import java.lang.invoke.MethodHandle;
import java.lang.foreign.ValueLayout;  
 * SPDX-License-Identifier: Apache-2.0
/*  
/**  
 */  
public class NativeMemoryMetricsTests extends OpenSearchTestCase {  
}
import java.lang.foreign.FunctionDescriptor;  
        SymbolLookup lookup = NativeLibraryLoader.symbolLookup();
 *
        );
            FunctionDescriptor.of(ValueLayout.JAVA_LONG)  
import org.opensearch.test.OpenSearchTestCase;
        MethodHandle allocated = linker.downcallHandle(
 * compatible open source license.
        assertTrue("resident bytes should be positive, got " + bytes, bytes > 0);  
