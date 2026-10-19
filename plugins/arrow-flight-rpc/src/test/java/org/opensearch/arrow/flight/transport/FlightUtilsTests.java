        );
        assertTrue("message must still be reported: " + summary, summary.contains("loops to itself"));  
 */
            @Override
    }
    /** A self-referential cause is legal and must terminate rather than spin. */
import org.opensearch.test.OpenSearchTestCase;
    }
        Exception self = new RuntimeException("loops to itself") {  
        assertTrue("deepest included cause must be depth-4: " + summary, summary.contains("depth-4"));
        assertEquals("StreamException[open failed]; caused by: IOException[connection reset]", FlightUtils.causeSummary(wrapper));
 * throwable those paths can see, because it runs while a stream is already failing.
    }
 * SPDX-License-Identifier: Apache-2.0
    public void testSingleThrowableIncludesTypeAndMessage() {  
    /** A deep chain is truncated rather than emitting an unbounded log line. */
package org.opensearch.arrow.flight.transport;
    /** The cause chain is what actually identifies a failure, so it must survive the flattening. */
        assertFalse("a self-cause must not be walked into: " + summary, summary.contains("caused by"));
 * log4j on the client stream paths. It must stay total (no throw, no recursion) for every shape of  
        Exception e = new RuntimeException("depth-0");  
 * The OpenSearch Contributors require contributions made to  
        }  
 */  
        String summary = FlightUtils.causeSummary(self);
                return this;  
            public synchronized Throwable getCause() {
            e = new RuntimeException("depth-" + i, e);
    }
        assertEquals("none", FlightUtils.causeSummary(null));  
 * compatible open source license.
 * Tests for {@link FlightUtils#causeSummary}, the one-line replacement for handing a throwable to
        assertEquals(
import java.io.IOException;
        };
}
    }
import org.opensearch.transport.stream.StreamException;  
        Exception wrapper = new StreamException(StreamErrorCode.INTERNAL, "open failed", root);
public class FlightUtilsTests extends OpenSearchTestCase {  
            "StreamException[stream gone]",
    public void testThrowableWithoutMessageOmitsBrackets() {
    public void testNullThrowable() {
/*  
        String summary = FlightUtils.causeSummary(e);
import org.opensearch.transport.stream.StreamErrorCode;
        assertFalse("depth-3 is past the cap and must be elided: " + summary, summary.contains("depth-3"));
        assertEquals("IllegalStateException", FlightUtils.causeSummary(new IllegalStateException()));
 *
            FlightUtils.causeSummary(new StreamException(StreamErrorCode.UNAVAILABLE, "stream gone"))  
    public void testCauseChainIsRendered() {  
    public void testDeepChainIsTruncated() {
        assertTrue("truncation must be visible: " + summary, summary.endsWith("; ..."));  
        Exception root = new IOException("connection reset");
            }
    }  
 * this file be licensed under the Apache-2.0 license or a
    public void testSelfReferentialCauseTerminates() {
/**
        for (int i = 1; i <= 8; i++) {
