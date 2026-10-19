        long rc = NativeBridge.canMatch(0L, 0L, COLUMN, 0L, 100L);
 */
 *
 * query, it kills the node. This ran on the can-match fail-open path, so the safety valve was the
 * {@code NativeLibraryLoader.checkResult} reads any negative return as an address. A negative  
    /** Before the fix this segfaulted the test JVM rather than returning. */  
    }
 * makes the contract testable without fixtures.  
 * <p>A null shard view reaches a non-match status without a live runtime or parquet on disk, which
    private static final String COLUMN = "@timestamp";
 * non-negative.  
public class NativeBridgeCanMatchTests extends OpenSearchTestCase {
    /** UNKNOWN must not collide with NO, or a fail-open answer would silently prune the shard. */
import org.opensearch.be.datafusion.nativelib.NativeBridge;
 *
/**
 * SPDX-License-Identifier: Apache-2.0
 * crash.  
    public void testUnknownIsDistinctFromNo() {  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        assertEquals(NativeBridge.CAN_MATCH_UNKNOWN, rc);
    }  
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(NativeBridge.CAN_MATCH_NO >= 0);
    public void testNullShardViewReturnsUnknownRatherThanNegative() {
 * compatible open source license.
 */  
 * Locks in the return contract of {@code df_can_match}: every status it reports must be
package org.opensearch.be.datafusion;
        assertNotEquals(NativeBridge.CAN_MATCH_NO, NativeBridge.CAN_MATCH_UNKNOWN);
 * status is therefore dereferenced as an error string and segfaults the JVM — it does not fail the
        assertTrue(NativeBridge.CAN_MATCH_UNKNOWN >= 0);
        assertTrue("negative returns are error pointers to checkResult, not statuses; got " + rc, rc >= 0);
 *
        assertTrue(NativeBridge.CAN_MATCH_YES >= 0);  
 * <p>{@code #[ffm_safe]} returns {@code Err} as a negated pointer to a heap-allocated message, so
/*  
}  
