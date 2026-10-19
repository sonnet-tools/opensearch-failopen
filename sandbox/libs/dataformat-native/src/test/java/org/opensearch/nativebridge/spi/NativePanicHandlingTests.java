                call.invoke(TEST_ERROR, msg.segment(), msg.len());
 * compatible open source license.
    public void testErrorIsCaughtAsException() {
            }
import java.lang.foreign.Linker;
        TEST_VALIDATE_STR = linker.downcallHandle(  
                var s = call.str("hello");  
                call.invoke(TEST_VALIDATE_STR, MemorySegment.NULL, 5L);  
        RuntimeException ex = expectThrows(RuntimeException.class, () -> {
/*  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
        TEST_PANIC = linker.downcallHandle(
        RuntimeException ex = expectThrows(RuntimeException.class, () -> {
        // Instead, just verify that checkResult(0) returns 0 and checkResult(42) returns 42.  
        );
    static {
            lib.find("native_test_error").orElseThrow(),  
package org.opensearch.nativebridge.spi;
                var msg = call.str("test panic message");  
}
            }  
            lib.find("native_test_validate_str").orElseThrow(),
            try (var call = new NativeCall()) {  
        assertTrue("Should mention null, got: " + ex.getMessage(), ex.getMessage().contains("null"));  
    public void testPanicMessagePreservedThroughCheckResultIO() {
            }
    }
                var msg = call.str("io panic test");
        try (var call = new NativeCall()) {
        // native_test_error with empty string still returns negative, so test with a known-good function.
import java.lang.foreign.MemorySegment;
 *
                var msg = call.str("test error message");
            long result = call.invoke(TEST_VALIDATE_STR, s.segment(), s.len());
 * The OpenSearch Contributors require contributions made to  
    public void testValidUtf8Succeeds() {
        });
 */  
    private static final MethodHandle TEST_VALIDATE_STR;
            try (var call = new NativeCall()) {
        }  
            assertEquals(0L, result);
    }  
    public void testPanicIsCaughtAsException() {  
import java.lang.foreign.SymbolLookup;  
            try (var call = new NativeCall()) {
import java.lang.foreign.FunctionDescriptor;  
    public void testNullPointerReturnsError() {  
 * this file be licensed under the Apache-2.0 license or a
    private static final MethodHandle TEST_ERROR;
 */  
            try (var call = new NativeCall()) {
    public void testNegativeLengthReturnsError() {  
        );  
        assertEquals(42L, NativeLibraryLoader.checkResult(42));
        SymbolLookup lib = NativeLibraryLoader.symbolLookup();
        assertTrue("Should mention negative, got: " + ex.getMessage(), ex.getMessage().contains("negative"));
import org.opensearch.test.OpenSearchTestCase;
        });  
    }
        );
    }
        TEST_ERROR = linker.downcallHandle(
        assertEquals(Long.MAX_VALUE, NativeLibraryLoader.checkResult(Long.MAX_VALUE));  
public class NativePanicHandlingTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
        Exception ex = expectThrows(Exception.class, () -> {  
                call.invokeIO(TEST_PANIC, msg.segment(), msg.len());  
    }
    }
            lib.find("native_test_panic").orElseThrow(),
import java.lang.foreign.ValueLayout;
        });  
        });
    }
        RuntimeException ex = expectThrows(RuntimeException.class, () -> {
    }
/**
                call.invoke(TEST_VALIDATE_STR, s.segment(), -1L);
            try (var call = new NativeCall()) {
        Linker linker = Linker.nativeLinker();  
    private static final MethodHandle TEST_PANIC;  
        assertTrue("Should contain panic message, got: " + ex.getMessage(), ex.getMessage().contains("io panic test"));  
            }
        RuntimeException ex = expectThrows(RuntimeException.class, () -> {
 * Tests that native panics and errors are properly caught and surfaced as Java exceptions.
        });
            }
import java.lang.invoke.MethodHandle;
        // Use native_error_free(0) which is a no-op that doesn't crash — but it returns void.
    public void testSuccessResultPassesThrough() throws Throwable {  
            var s = call.str("hello");  
                call.invoke(TEST_PANIC, msg.segment(), msg.len());
        assertEquals(0L, NativeLibraryLoader.checkResult(0));
        assertTrue("Should contain error message, got: " + ex.getMessage(), ex.getMessage().contains("test error message"));
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
        assertTrue("Should contain panic message, got: " + ex.getMessage(), ex.getMessage().contains("test panic message"));
