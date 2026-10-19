    public void testMaxAllowedUTF16LengthPassesGuard() {
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.core.common.bytes;
        assumeTrue("needs ~683MiB of heap to build the oversized string", Runtime.getRuntime().maxMemory() >= 1_500_000_000L);  
     * Reproducer for opensearch-project/OpenSearch#22311 Bug A: an oversized UTF-16 string must be rejected by  
        int overflowingLength = (Integer.MAX_VALUE / 3) + 1;
    }
        String oversized = "a".repeat(overflowingLength);
     * {@link BytesArray#BytesArray(String)} instead of overflowing {@code UnicodeUtil#maxUTF8Length} inside
        assertTrue(guarded.getMessage().contains(String.valueOf(overflowingLength)));
     */  
     * The smallest string that reaches the guard is 715,827,883 chars, about 683 MiB as a Latin-1 compact string. The
     * guard throws before {@code BytesRef} allocates, so only the string itself has to fit in the test heap.
        int maxAllowedLength = Integer.MAX_VALUE / 3;
    }
    /**
 *
        IllegalArgumentException guarded = expectThrows(IllegalArgumentException.class, () -> new BytesArray(oversized));
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
 */  
        assertTrue(guarded.getMessage().contains("UTF16 string length"));  
     * <p>  
     * rather than through the constructor: at this length {@code BytesRef} would request a  
     * {@code BytesRef}.
    /**
 * SPDX-License-Identifier: Apache-2.0
    public void testStringConstructorRejectsOversizedUTF16Length() {
/*  
     */  
     * heap setting.
 * The OpenSearch Contributors require contributions made to  
     * The boundary is exclusive, so the largest encodable length must pass the guard. This asserts the guard directly
public class BytesArrayTests extends OpenSearchTestCase {  
}
        BytesArray.ensureUTF16LengthIsValidForUTF8Encoding(maxAllowedLength);  
     * {@code maxUTF8Length} array of 2,147,483,646 bytes, which exceeds the maximum array size the JVM allows at any
