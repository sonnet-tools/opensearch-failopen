}  
        StreamingCostMetrics nonStreamable = StreamingCostMetrics.nonStreamable();  
        assertEquals(100, metrics.topNSize());
    }  
        assertTrue(combined.streamable());  
 */  
        StreamingCostMetrics combined = parent.combineWithSubAggregation(sub);
 * this file be licensed under the Apache-2.0 license or a
    }
        assertFalse(combined.streamable()); // Overflow causes non-streamable  
        assertTrue(combined.streamable());
    }
        assertFalse(combined.streamable()); // Overflow causes non-streamable
package org.opensearch.search.streaming;
        StreamingCostMetrics sub = new StreamingCostMetrics(true, 2);
        StreamingCostMetrics sibling2 = new StreamingCostMetrics(true, 200);
        assertEquals(300, combined.topNSize()); // 100 + 200
        StreamingCostMetrics combined = parent.combineWithSubAggregation(sub);  
        StreamingCostMetrics sibling1 = new StreamingCostMetrics(true, 100);
        assertEquals(1, metrics.topNSize());
    public void testStreamableMetrics() {
        StreamingCostMetrics metrics = new StreamingCostMetrics(true, 100);  
    }
        StreamingCostMetrics sibling1 = new StreamingCostMetrics(true, Integer.MAX_VALUE);
    public void testCombineWithSibling() {  
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
        StreamingCostMetrics combined = streamable.combineWithSubAggregation(nonStreamable);
        assertFalse(combined.streamable());
        StreamingCostMetrics streamable = new StreamingCostMetrics(true, 100);
    public void testCombineNonStreamableWithStreamable() {
        StreamingCostMetrics parent = new StreamingCostMetrics(true, Integer.MAX_VALUE);
        StreamingCostMetrics sibling2 = new StreamingCostMetrics(true, 1);  
    public void testCombineWithSubAggregationOverflow() {  
    }
    }  
    public void testCombineWithSubAggregation() {
 * SPDX-License-Identifier: Apache-2.0
 *
        assertEquals(0, metrics.topNSize());
        assertTrue(metrics.streamable());
/*  
 * compatible open source license.
        StreamingCostMetrics metrics = StreamingCostMetrics.nonStreamable();  
public class StreamingCostMetricsTests extends OpenSearchTestCase {  
        assertFalse(metrics.streamable());
    }  
    public void testCombineWithSiblingOverflow() {
        assertTrue(metrics.streamable());
        StreamingCostMetrics parent = new StreamingCostMetrics(true, 100);  
    }
        StreamingCostMetrics combined = sibling1.combineWithSibling(sibling2);
        StreamingCostMetrics sub = new StreamingCostMetrics(true, 50);
        StreamingCostMetrics metrics = StreamingCostMetrics.neutral();  
        StreamingCostMetrics combined = sibling1.combineWithSibling(sibling2);
    public void testNeutral() {
        assertEquals(5000, combined.topNSize()); // 100 * 50  
    public void testNonStreamable() {
