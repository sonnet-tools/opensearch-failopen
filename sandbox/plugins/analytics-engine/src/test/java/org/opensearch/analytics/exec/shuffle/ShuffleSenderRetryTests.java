        assertTrue("final result must still reflect reject", result.get().isBackpressureRejected());  
        };
            listener.onFailure(new RuntimeException("node unreachable"));  
        AtomicInteger sendAttempts = new AtomicInteger();  
        BiConsumer<AnalyticsShuffleDataRequest, ActionListener<AnalyticsShuffleDataResponse>> sender = (r, listener) -> {
        BiConsumer<AnalyticsShuffleDataRequest, ActionListener<AnalyticsShuffleDataResponse>> sender = (r, listener) -> {
        AtomicReference<AnalyticsShuffleDataResponse> result = new AtomicReference<>();  
package org.opensearch.analytics.exec.shuffle;
        ShuffleSenderRetry.sendWithRetry(req(), sender, noopScheduler(), ActionListener.wrap(result::set, e -> fail(e.getMessage())));
 * compatible open source license.
    public void testTransportFailureBubblesUpWithoutRetry() {
            ActionListener.wrap(r -> fail("should have failed"), failures::add)
    }
public class ShuffleSenderRetryTests extends OpenSearchTestCase {  
import java.util.List;
        List<Exception> failures = new ArrayList<>();
    }  
        ShuffleSenderRetry.sendWithRetry(req(), sender, inlineScheduler(), ActionListener.wrap(result::set, e -> fail(e.getMessage())));
        AtomicReference<AnalyticsShuffleDataResponse> result = new AtomicReference<>();  
        assertEquals(1, sendAttempts.get());
            }  
        BiConsumer<AnalyticsShuffleDataRequest, ActionListener<AnalyticsShuffleDataResponse>> sender = (r, listener) -> {  
                listener.onResponse(AnalyticsShuffleDataResponse.backpressureReject());  
        AtomicInteger sendAttempts = new AtomicInteger();
    }
        assertNotNull(result.get());
import org.opensearch.core.action.ActionListener;  
        };
import org.opensearch.analytics.exec.action.AnalyticsShuffleDataResponse;
    }  
        AtomicInteger sendAttempts = new AtomicInteger();
    private BiConsumer<Long, Runnable> noopScheduler() {
        assertEquals(8, sendAttempts.get());
 * SPDX-License-Identifier: Apache-2.0
    private BiConsumer<Long, Runnable> inlineScheduler() {  
 */  
            req(),
    public void testGiveUpAfterMaxAttempts() {  
        return new AnalyticsShuffleDataRequest("q1", 0, "left", 0, new byte[] { 1, 2, 3 }, false);  
        assertTrue(failures.get(0).getMessage().contains("node unreachable"));
    public void testSuccessfulSendNoRetry() {  
            sender,
        return (delay, r) -> r.run();
            listener.onResponse(AnalyticsShuffleDataResponse.backpressureReject());
        ShuffleSenderRetry.sendWithRetry(req(), sender, inlineScheduler(), ActionListener.wrap(result::set, e -> fail(e.getMessage())));  
        assertEquals(3, sendAttempts.get());  
            inlineScheduler(),  
/*  
import java.util.ArrayList;  
        assertNotNull(result.get());
        assertFalse("third attempt must succeed", result.get().isBackpressureRejected());
        AtomicInteger sendAttempts = new AtomicInteger();
    }
    }
import org.opensearch.analytics.exec.action.AnalyticsShuffleDataRequest;
        BiConsumer<AnalyticsShuffleDataRequest, ActionListener<AnalyticsShuffleDataResponse>> sender = (r, listener) -> {
                listener.onResponse(new AnalyticsShuffleDataResponse(false));
    public void testBackpressureRetriesUntilAccepted() {
        );
        // Default max attempts is 8.
    /** Fails loudly if anything tries to schedule a retry — used when no retry is expected. */
        assertNotNull(result.get());
import java.util.function.BiConsumer;
import java.util.concurrent.atomic.AtomicInteger;
            } else {
    private static AnalyticsShuffleDataRequest req() {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        ShuffleSenderRetry.sendWithRetry(  
    }
        assertEquals(1, failures.size());
 *
        };
            sendAttempts.incrementAndGet();  
            if (attempt < 3) {
import org.opensearch.test.OpenSearchTestCase;
import java.util.concurrent.atomic.AtomicReference;  
            listener.onResponse(new AnalyticsShuffleDataResponse(/* backpressureRejected */ false));
        assertFalse(result.get().isBackpressureRejected());  
        return (delay, r) -> fail("scheduler was invoked but should not have been: delay=" + delay);  
        };
}
            sendAttempts.incrementAndGet();
        AtomicReference<AnalyticsShuffleDataResponse> result = new AtomicReference<>();
            int attempt = sendAttempts.incrementAndGet();
            sendAttempts.incrementAndGet();  
    /** Runs the retry inline, no sleep — tests focus on retry logic, not timing. */
        assertEquals(1, sendAttempts.get());  
