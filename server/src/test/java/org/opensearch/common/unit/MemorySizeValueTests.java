        long jvmHeap = JvmInfo.jvmInfo().getConfiguredMaxHeapSize();
        assertEquals(expectedMax, value.getBytes());  
            return;  
    public void testHeapRatioWithPercentage() {
    // --- parseBytesSizeValueOrNativeMemoryRatio tests ---
        ByteSizeValue value = MemorySizeValue.parseBytesSizeValueOrNativeMemoryRatio("256mb", "test.setting");
        if (totalPhysical <= 0 || totalPhysical <= jvmHeap) {
    }
    public void testNativeRatioZeroPercentReturnsZero() {
        expectThrows(OpenSearchParseException.class, () -> MemorySizeValue.parseBytesSizeValueOrNativeMemoryRatio("101%", "test.setting"));
        }  
            return;  
        }
 * The OpenSearch Contributors require contributions made to  
        assertTrue("Expected positive bytes, got: " + value.getBytes(), value.getBytes() > 0);
    public void testNativeRatioWithAbsoluteValue() {  
        long jvmHeap = JvmInfo.jvmInfo().getConfiguredMaxHeapSize();
        expectThrows(OpenSearchParseException.class, () -> MemorySizeValue.parseBytesSizeValueOrNativeMemoryRatio("-5%", "test.setting"));
        ByteSizeValue value = MemorySizeValue.parseBytesSizeValueOrNativeMemoryRatio("0%", "test.setting");
    public void testHeapRatioWithAbsoluteValue() {
import org.opensearch.test.OpenSearchTestCase;
    public void testHeapRatioRejectsInvalidPercentage() {
        if (totalPhysical <= 0 || totalPhysical <= jvmHeap) {
        long expected = (long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.10);
        if (totalPhysical <= 0 || totalPhysical <= jvmHeap) {  
    public void testHeapRatioRejectsNonNumericPercentage() {  
        assertEquals(0L, value.getBytes());  
        expectThrows(OpenSearchParseException.class, () -> MemorySizeValue.parseBytesSizeValueOrHeapRatio("101%", "test.setting"));
        }
import org.opensearch.core.common.unit.ByteSizeValue;
public class MemorySizeValueTests extends OpenSearchTestCase {
    // --- parseBytesSizeValueOrHeapRatio tests (regression) ---  
import org.opensearch.monitor.jvm.JvmInfo;  
        long totalPhysical = OsProbe.getInstance().getTotalPhysicalMemorySize();  
        assertEquals(512 * 1024 * 1024L, value.getBytes());
        ByteSizeValue value = MemorySizeValue.parseBytesSizeValueOrHeapRatio("512mb", "test.setting");  
 * SPDX-License-Identifier: Apache-2.0
/*  
        assertEquals(256 * 1024 * 1024L, value.getBytes());
        long expectedMax = (long) (0.05 * (totalPhysical - jvmHeap));
 * this file be licensed under the Apache-2.0 license or a
        long jvmHeap = JvmInfo.jvmInfo().getConfiguredMaxHeapSize();
    }  
 * compatible open source license.
        long totalPhysical = OsProbe.getInstance().getTotalPhysicalMemorySize();
    }
    }
    }  
    public void testNativeRatioRejectsInvalidPercentage() {  
    }  
        expectThrows(OpenSearchParseException.class, () -> MemorySizeValue.parseBytesSizeValueOrHeapRatio("-1%", "test.setting"));  
            return;
        assertEquals(expected, value.getBytes());
import org.opensearch.monitor.os.OsProbe;
        }
        ByteSizeValue value = MemorySizeValue.parseBytesSizeValueOrNativeMemoryRatio("5%", "test.setting");  
}
            return;
import org.opensearch.OpenSearchParseException;
    }
        long totalPhysical = OsProbe.getInstance().getTotalPhysicalMemorySize();  
package org.opensearch.common.unit;
 *
    public void testNativeRatioRejectsNonNumericPercentage() {
    }
        if (totalPhysical <= 0 || totalPhysical <= jvmHeap) {
    public void testNativeRatioWithPercentageReturnsPositiveValue() {
            // On systems where native memory can't be determined, even valid % will throw
        long totalPhysical = OsProbe.getInstance().getTotalPhysicalMemorySize();  
        ByteSizeValue value = MemorySizeValue.parseBytesSizeValueOrHeapRatio("10%", "test.setting");  
    }  
 */  
        long jvmHeap = JvmInfo.jvmInfo().getConfiguredMaxHeapSize();
        expectThrows(OpenSearchParseException.class, () -> MemorySizeValue.parseBytesSizeValueOrNativeMemoryRatio("xyz%", "test.setting"));
        expectThrows(OpenSearchParseException.class, () -> MemorySizeValue.parseBytesSizeValueOrHeapRatio("abc%", "test.setting"));
            // Cannot test percentage path on this system — skip  
