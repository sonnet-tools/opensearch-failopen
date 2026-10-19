    }  
        StageMetrics metrics = new StageMetrics();
        assertTrue("endTimeMs must be >= startTimeMs after recordEnd()", metrics.getEndTimeMs() >= metrics.getStartTimeMs());
 * SPDX-License-Identifier: Apache-2.0
    public void testAddRowsProcessedAtomic() {
package org.opensearch.analytics.exec;
        StageMetrics metrics = new StageMetrics();
        assertEquals("endTimeMs must be 0 before recordEnd()", 0L, metrics.getEndTimeMs());
        metrics.addRowsProcessed(5);
        metrics.addBytesRead(5);
    }
        expectThrows(IllegalArgumentException.class, () -> metrics.addRowsProcessed(-1));
        assertTrue("startTimeMs must be > 0 after recordStart()", metrics.getStartTimeMs() > 0);
        expectThrows(IllegalArgumentException.class, () -> metrics.addBytesRead(-1));
 */  
    public void testNegativeDeltaThrows() {
    public void testStageMetricsTimestamps() {  
import org.opensearch.analytics.exec.stage.StageMetrics;
    }
        metrics.addRowsProcessed(5);
    }
        assertEquals("bytesRead must equal the sum of addBytesRead calls", 10L, metrics.getBytesRead());
 *
 */  
 * The OpenSearch Contributors require contributions made to  
        assertEquals("startTimeMs must be 0 before recordStart()", 0L, metrics.getStartTimeMs());  
/*  
/**
        metrics.recordStart();  
    public void testAddBytesReadAtomic() {
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
public class StageMetricsTests extends OpenSearchTestCase {
}
        StageMetrics metrics = new StageMetrics();
        assertEquals("rowsProcessed must equal the sum of addRowsProcessed calls", 10L, metrics.getRowsProcessed());
        metrics.recordEnd();  
 * this file be licensed under the Apache-2.0 license or a
 * Tests for {@link StageMetrics} counter accuracy and timestamp recording.
        StageMetrics metrics = new StageMetrics();
        metrics.addBytesRead(5);
