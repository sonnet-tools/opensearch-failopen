        assertFalse(req.isColumn());
        ClearCacheNodeRequest req = new ClearCacheNodeRequest(false, false, false, false);
        req.setColumn(true);  
    }  
    }
        assertFalse(req.isClearAll());
        assertTrue("no flags set → isClearAll()", req.isClearAll());  
        assertFalse(req.isFooter());
        assertFalse(req.isOffset());
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(req.isFooter());  
}
        ClearCacheNodesRequest req = new ClearCacheNodesRequest();
        original.writeTo(out);  
    public void testNodeRequestRoundTrip() throws IOException {
        assertFalse(req.isColumn());  
        assertTrue(req.isFooter());  
import org.opensearch.test.OpenSearchTestCase;  
        assertFalse(req.isClearAll());
        original.setOffset(true);
        assertTrue(req.isColumn());
package org.opensearch.be.datafusion.action.stats;
    // ── ClearCacheNodeRequest ─────────────────────────────────────────────────
        req.setColumn(true);
    public void testSetFooterOnlyIsNotClearAll() {  
        assertFalse(req.isFooter());
        assertFalse(deserialized.isFooter());
        assertFalse(req.isClearAll());
    public void testNodeRequestIsNotClearAllWhenFlagSet() {  
        assertFalse(req.isStatistics());
public class ClearCacheRequestTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
        original.writeTo(out);  
    public void testSetColumnOnlyIsNotClearAll() {
    }
        assertFalse(req.isStatistics());
        assertFalse(req.isStatistics());
        assertTrue(req.isStatistics());
        assertFalse(req.isStatistics());  
    }  
        assertEquals(original.isOffset(), deserialized.isOffset());  
    public void testSetStatisticsOnlyIsNotClearAll() {  
/*  
        assertEquals(original.isClearAll(), deserialized.isClearAll());
        assertFalse(req.isOffset());  
 * compatible open source license.
    }  
 * The OpenSearch Contributors require contributions made to  
    public void testNodesRequestRoundTrip() throws IOException {
        assertFalse(req.isClearAll());
        assertFalse(req.isColumn());
    public void testNodeRequestStatisticsFlag() {
 */
    }
        assertFalse(req.isClearAll());
import java.io.IOException;
    public void testDefaultNodesRequestIsClearAll() {  
        assertFalse(req.isClearAll());  
        assertTrue(req.isClearAll());  
        BytesStreamOutput out = new BytesStreamOutput();
 */  
    }
        req.setOffset(true);
 * Verifies flag semantics, isClearAll() logic, and round-trip serialization.  
        ClearCacheNodesRequest original = new ClearCacheNodesRequest();
        ClearCacheNodesRequest req = new ClearCacheNodesRequest();
        StreamInput in = out.bytes().streamInput();
        assertFalse(deserialized.isClearAll());
        req.setStatistics(true);  
    public void testAllFlagsSetIsNotClearAll() {
 *
        assertFalse(req.isFooter());
        assertFalse(req.isOffset());  
        ClearCacheNodeRequest deserialized = new ClearCacheNodeRequest(in);
        assertFalse("footer=true → not clear-all", req.isClearAll());
        assertFalse(req.isFooter());
        ClearCacheNodesRequest req = new ClearCacheNodesRequest();
    public void testNodeRequestIsClearAllWhenNoFlagsSet() {
    }  
        assertTrue(req.isStatistics());  
    // ── ClearCacheNodesRequest ────────────────────────────────────────────────
        StreamInput in = out.bytes().streamInput();
        assertTrue(deserialized.isStatistics());
        ClearCacheNodeRequest req = new ClearCacheNodeRequest(false, false, false, true);  
 * Unit tests for {@link ClearCacheNodesRequest} and {@link ClearCacheNodeRequest}.
/**
        assertFalse(req.isOffset());
    }  
        ClearCacheNodesRequest req = new ClearCacheNodesRequest();
        original.setFooter(true);  
        original.setColumn(false);
        req.setOffset(true);
        assertTrue(deserialized.isOffset());  
        original.setStatistics(true);  
import org.opensearch.core.common.io.stream.StreamInput;
        assertEquals(original.isStatistics(), deserialized.isStatistics());
        ClearCacheNodesRequest req = new ClearCacheNodesRequest();
        ClearCacheNodeRequest original = new ClearCacheNodeRequest(false, true, true, true);  
        req.setFooter(true);  
        ClearCacheNodesRequest req = new ClearCacheNodesRequest();  
        BytesStreamOutput out = new BytesStreamOutput();
    }
        assertFalse(req.isColumn());
        assertFalse(req.isColumn());  
        ClearCacheNodeRequest req = new ClearCacheNodeRequest(true, false, false, false);
        ClearCacheNodesRequest deserialized = new ClearCacheNodesRequest(in);
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
        assertTrue(deserialized.isColumn());
        assertEquals(original.isFooter(), deserialized.isFooter());
        assertEquals(original.isColumn(), deserialized.isColumn());
        assertTrue(req.isOffset());
    public void testSetOffsetOnlyIsNotClearAll() {
        req.setStatistics(true);
        assertFalse(req.isOffset());
        req.setFooter(true);
