            () -> order.updateAndGet(s -> s + "S"),
    // ──────────────────────────────────────────────────────────────────────
        AtomicLong recorded = new AtomicLong(-1);
 *   <li>return values pass through</li>
    }
            () -> StatsRecorder.recordOutcome((StatsRecorder.IOSupplier<String>) () -> {
            NullPointerException.class,
        assertTrue("work should have run", ran.get());
    }
    public void testRecordTimeMillisValueRejectsNullArgs() {
        String result = StatsRecorder.recordTimeMillis(() -> "hello", recorded::set);
        IOException boom = new IOException("boom");  
            () -> StatsRecorder.recordTimeMillis((StatsRecorder.IORunnable) () -> { throw boom; }, recorded::set)
import java.util.concurrent.atomic.AtomicLong;  
    // recordOutcome(IORunnable, ...) — void
    public void testOnFailureRunsBeforeExceptionPropagatesAndTimeStillRecorded() {  
        assertTrue("time must be recorded", recorded.get() >= 0L);  
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordOutcome(() -> "x", v -> {}, null, () -> {}));  
 */  
        IOException thrown = expectThrows(IOException.class, () -> StatsRecorder.recordOutcome((StatsRecorder.IOSupplier<String>) () -> {  
    }  
                failure::incrementAndGet
        assertEquals("ok", result);  
            IOException.class,  
import java.util.concurrent.atomic.AtomicInteger;
        assertEquals(0, success.get());
        // Contract: the time recorder runs in finally, before onSuccess is invoked.
        String result = StatsRecorder.recordTimeMillis(() -> null, recorded::set);
        IOException thrown = expectThrows(
        // onFailure (F) fires in catch, then time (T) in finally; onSuccess (S) never fires.  
        assertEquals(1, success.get());
        assertTrue(recorded.get() >= 0L);
        assertEquals("expected onFailure then time, no onSuccess", "FT", order.get());
        RuntimeException thrown = expectThrows(  
    public void testRecordTimeMillisVoidRecordsTimeEvenOnThrow() {
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordTimeMillis((StatsRecorder.IORunnable) null, v -> {}));  
/*  
            throw boom;
            NullPointerException.class,
        );
            () -> StatsRecorder.recordOutcome((StatsRecorder.IOSupplier<String>) null, v -> {}, () -> {}, () -> {})  
        AtomicInteger success = new AtomicInteger(0);
        assertEquals(0, success.get());  
        StatsRecorder.recordOutcome(() -> ran.set(true), recorded::set, success::incrementAndGet, failure::incrementAndGet);
    }
        assertEquals("time (T) must be recorded before onSuccess (S)", "TS", order.get());  
        AtomicLong recorded = new AtomicLong(-1);  
    // ──────────────────────────────────────────────────────────────────────
    public void testRecordOutcomeValueSuccessFiresOnSuccessOnly() throws IOException {
            millis -> order.updateAndGet(s -> s + "T"),
        AtomicBoolean ran = new AtomicBoolean(false);  
        assertSame(boom, thrown);
import org.opensearch.test.OpenSearchTestCase;
 *   <li>null arguments are rejected</li>  
 * <p>Covers all four public methods and their contracts:  
    public void testRecordOutcomeVoidSuccessFiresOnSuccessOnly() throws IOException {
        AtomicReference<String> order = new AtomicReference<>("");
        StatsRecorder.recordOutcome(
    }
        );
                recorded::set,
        assertEquals("onFailure fires on RuntimeException too", 1, failure.get());
 * The OpenSearch Contributors require contributions made to  
                () -> order.updateAndGet(s -> s + "S"),
        StatsRecorder.recordTimeMillis(() -> ran.set(true), recorded::set);
        assertTrue("elapsed millis should be recorded (>= 0)", recorded.get() >= 0L);
    }
 *   <li>time is always recorded (success and failure paths)</li>
        assertSame("the original exception must propagate", boom, thrown);
        AtomicBoolean ran = new AtomicBoolean(false);
    public void testRecordOutcomeValueRejectsNullArgs() {  
        assertNull("null result must pass through", result);
    // ──────────────────────────────────────────────────────────────────────
 */
        );
    public void testRecordOutcomeVoidRejectsNullWork() {
        IOException thrown = expectThrows(IOException.class, () -> StatsRecorder.recordTimeMillis((StatsRecorder.IOSupplier<String>) () -> {  
                throw boom;  
    // recordOutcome(IOSupplier, ...) — value-returning
    public void testRecordTimeMillisVoidRunsWorkAndRecordsTime() throws IOException {  
 *   <li>{@code onSuccess}/{@code onFailure} are mutually exclusive</li>  
    // Ordering / interaction contracts
        RuntimeException boom = new IllegalStateException("rt-boom");
    // ──────────────────────────────────────────────────────────────────────  
        AtomicLong recorded = new AtomicLong(-1);  
        expectThrows(  
}  
    }
            () -> StatsRecorder.recordOutcome((StatsRecorder.IORunnable) null, v -> {}, () -> {}, () -> {})
    public void testTimeRecordedBeforeOnSuccessCallback() throws IOException {
        assertTrue(recorded.get() >= 0L);
        );
            () -> StatsRecorder.recordOutcome(  
        assertSame("original exception must propagate", boom, thrown);
        AtomicLong recorded = new AtomicLong(-1);
    // recordTimeMillis(IOSupplier, ...) — value-returning
    public void testRecordTimeMillisValuePassesThroughNullResult() throws IOException {
        assertTrue("work should have run", ran.get());  
        }, recorded::set, success::incrementAndGet, failure::incrementAndGet));
        // Contract: onFailure runs inside catch (before rethrow); time recorder runs in finally.
        );
 * compatible open source license.
        expectThrows(
    // ──────────────────────────────────────────────────────────────────────  
    }  
    }
 *   <li>the original exception propagates unchanged</li>
    // ──────────────────────────────────────────────────────────────────────
            throw boom;
    public void testRecordOutcomeValueFailureFiresOnFailureOnly() {  
            IOException.class,
        IOException boom = new IOException("boom");
 * Unit tests for {@link StatsRecorder}.
    // ──────────────────────────────────────────────────────────────────────
import java.io.IOException;  
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordTimeMillis((StatsRecorder.IOSupplier<String>) null, v -> {}));  
            () -> StatsRecorder.recordOutcome(
        AtomicLong recorded = new AtomicLong(-1);
    public void testRecordTimeMillisValueRecordsTimeEvenOnThrow() {
        expectThrows(
        );  
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordOutcome(() -> "x", v -> {}, () -> {}, null));
 * this file be licensed under the Apache-2.0 license or a
                () -> order.updateAndGet(s -> s + "F")
        assertTrue("elapsed millis must be recorded even when work throws", recorded.get() >= 0L);
        AtomicLong recorded = new AtomicLong(-1);  
    // recordTimeMillis(IORunnable, ...)  
                success::incrementAndGet,  
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordTimeMillis(() -> {}, null));
            () -> order.updateAndGet(s -> s + "F")  
                (StatsRecorder.IOSupplier<String>) () -> { throw boom; },
    }
        assertTrue("elapsed millis must be recorded even when work throws", recorded.get() >= 0L);
    }
        assertEquals("onFailure must not fire on success", 0, failure.get());
    }
        assertEquals("hello", result);
            )
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordOutcome(() -> "x", null, () -> {}, () -> {}));
        assertTrue("time must be recorded even on failure", recorded.get() >= 0L);
        AtomicLong recorded = new AtomicLong(-1);  
        IOException thrown = expectThrows(
        );  
        assertEquals(0, failure.get());  
 * </ul>
    }  
 *
    public void testRecordTimeMillisVoidRejectsNullArgs() {
            IllegalStateException.class,
        AtomicInteger success = new AtomicInteger(0);
        IOException boom = new IOException("boom");  
        AtomicInteger success = new AtomicInteger(0);
        assertEquals("onSuccess must not fire on failure", 0, success.get());  
public class StatsRecorderTests extends OpenSearchTestCase {  
        AtomicInteger failure = new AtomicInteger(0);  
        AtomicInteger failure = new AtomicInteger(0);  
 * <ul>
        AtomicInteger success = new AtomicInteger(0);
        }, recorded::set));
            }, v -> {}, success::incrementAndGet, failure::incrementAndGet)
package org.opensearch.plugin.stats;
        assertTrue(recorded.get() >= 0L);
        AtomicInteger failure = new AtomicInteger(0);
        AtomicLong recorded = new AtomicLong(-1);
            () -> "v",  
/**  
    }
        AtomicInteger failure = new AtomicInteger(0);  
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordTimeMillis(() -> "x", null));
    // ──────────────────────────────────────────────────────────────────────  
        assertEquals(1, failure.get());  
        AtomicLong recorded = new AtomicLong(-1);
    // ──────────────────────────────────────────────────────────────────────
        String result = StatsRecorder.recordOutcome(() -> "ok", recorded::set, success::incrementAndGet, failure::incrementAndGet);
        assertTrue("elapsed millis should be recorded", recorded.get() >= 0L);
                millis -> order.updateAndGet(s -> s + "T"),  
        assertSame(boom, thrown);
    public void testRecordTimeMillisValueReturnsResultAndRecordsTime() throws IOException {
 *
            )  
        assertEquals("onSuccess must fire exactly once", 1, success.get());
    // ──────────────────────────────────────────────────────────────────────  
        IOException boom = new IOException("boom");
 * SPDX-License-Identifier: Apache-2.0
    }  
        IOException boom = new IOException("boom");
            IOException.class,  
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicBoolean;
        AtomicReference<String> order = new AtomicReference<>("");  
                (StatsRecorder.IORunnable) () -> { throw boom; },
    }  
        assertSame(boom, thrown);
    public void testRecordOutcomeVoidFailureFiresOnFailureOnly() {
        AtomicInteger success = new AtomicInteger(0);  
    public void testRecordOutcomeValuePropagatesRuntimeException() {
        assertEquals("onFailure must fire exactly once", 1, failure.get());
        AtomicInteger failure = new AtomicInteger(0);
