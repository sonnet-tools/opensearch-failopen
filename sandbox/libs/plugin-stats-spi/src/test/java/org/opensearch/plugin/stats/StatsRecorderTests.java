    }
 * </ul>
        );
 *
        assertTrue(recorded.get() >= 0L);
        String result = StatsRecorder.recordTimeMillis(() -> null, recorded::set);
    // ──────────────────────────────────────────────────────────────────────
        }, recorded::set));
    public void testRecordTimeMillisValueRejectsNullArgs() {
import java.io.IOException;
        AtomicInteger failure = new AtomicInteger(0);
        assertTrue(recorded.get() >= 0L);
        assertSame(boom, thrown);
    public void testRecordOutcomeVoidFailureFiresOnFailureOnly() {
            IOException.class,
        AtomicLong recorded = new AtomicLong(-1);
    public void testRecordOutcomeValueFailureFiresOnFailureOnly() {
 *
            NullPointerException.class,
 * <ul>
        assertTrue("time must be recorded even on failure", recorded.get() >= 0L);
        AtomicBoolean ran = new AtomicBoolean(false);
                (StatsRecorder.IORunnable) () -> { throw boom; },
import java.util.concurrent.atomic.AtomicBoolean;
        AtomicReference<String> order = new AtomicReference<>("");
    }
        AtomicInteger success = new AtomicInteger(0);
        assertSame("original exception must propagate", boom, thrown);
        AtomicReference<String> order = new AtomicReference<>("");
        AtomicInteger failure = new AtomicInteger(0);
    // ──────────────────────────────────────────────────────────────────────
    }
 *   <li>null arguments are rejected</li>
        assertTrue(recorded.get() >= 0L);
package org.opensearch.plugin.stats;
        );
    }
import java.util.concurrent.atomic.AtomicInteger;
                success::incrementAndGet,
                millis -> order.updateAndGet(s -> s + "T"),
        assertTrue("elapsed millis should be recorded (>= 0)", recorded.get() >= 0L);
        }, recorded::set, success::incrementAndGet, failure::incrementAndGet));
                throw boom;
            () -> StatsRecorder.recordOutcome(
        RuntimeException thrown = expectThrows(
        assertEquals("hello", result);
        IOException boom = new IOException("boom");
        IOException thrown = expectThrows(IOException.class, () -> StatsRecorder.recordTimeMillis((StatsRecorder.IOSupplier<String>) () -> {
        AtomicInteger success = new AtomicInteger(0);
                (StatsRecorder.IOSupplier<String>) () -> { throw boom; },
        AtomicInteger failure = new AtomicInteger(0);
        assertEquals("ok", result);
 *   <li>time is always recorded (success and failure paths)</li>
    }
 * SPDX-License-Identifier: Apache-2.0
            IOException.class,
        StatsRecorder.recordOutcome(() -> ran.set(true), recorded::set, success::incrementAndGet, failure::incrementAndGet);
 *   <li>the original exception propagates unchanged</li>
    public void testRecordTimeMillisVoidRecordsTimeEvenOnThrow() {
        IOException thrown = expectThrows(
 * The OpenSearch Contributors require contributions made to
    }
        // onFailure (F) fires in catch, then time (T) in finally; onSuccess (S) never fires.
        assertTrue("elapsed millis must be recorded even when work throws", recorded.get() >= 0L);
        );
 * compatible open source license.
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordOutcome(() -> "x", null, () -> {}, () -> {}));
/*
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordTimeMillis((StatsRecorder.IORunnable) null, v -> {}));
    }
        assertSame("the original exception must propagate", boom, thrown);
        assertEquals("time (T) must be recorded before onSuccess (S)", "TS", order.get());
 *   <li>return values pass through</li>
            throw boom;
        AtomicInteger success = new AtomicInteger(0);
    }
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordOutcome(() -> "x", v -> {}, null, () -> {}));
        // Contract: the time recorder runs in finally, before onSuccess is invoked.
    public void testRecordTimeMillisVoidRejectsNullArgs() {
    public void testTimeRecordedBeforeOnSuccessCallback() throws IOException {
            () -> order.updateAndGet(s -> s + "F")
import java.util.concurrent.atomic.AtomicReference;
    public void testRecordTimeMillisValueReturnsResultAndRecordsTime() throws IOException {
    public void testRecordOutcomeValueSuccessFiresOnSuccessOnly() throws IOException {
        IOException thrown = expectThrows(
        assertEquals(0, failure.get());
        IOException boom = new IOException("boom");
            )
        IOException boom = new IOException("boom");
    public void testOnFailureRunsBeforeExceptionPropagatesAndTimeStillRecorded() {
    public void testRecordTimeMillisValueRecordsTimeEvenOnThrow() {
 */
import java.util.concurrent.atomic.AtomicLong;
    }
        assertEquals("onSuccess must not fire on failure", 0, success.get());
    public void testRecordTimeMillisValuePassesThroughNullResult() throws IOException {
    }
                failure::incrementAndGet
        AtomicLong recorded = new AtomicLong(-1);
        StatsRecorder.recordTimeMillis(() -> ran.set(true), recorded::set);
        assertEquals("expected onFailure then time, no onSuccess", "FT", order.get());
    // recordOutcome(IOSupplier, ...) — value-returning
import org.opensearch.test.OpenSearchTestCase;
    // ──────────────────────────────────────────────────────────────────────
        AtomicInteger failure = new AtomicInteger(0);
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordTimeMillis(() -> "x", null));
            () -> StatsRecorder.recordOutcome(
        AtomicLong recorded = new AtomicLong(-1);
    }
        String result = StatsRecorder.recordOutcome(() -> "ok", recorded::set, success::incrementAndGet, failure::incrementAndGet);
        assertTrue("time must be recorded", recorded.get() >= 0L);
    // ──────────────────────────────────────────────────────────────────────
        assertEquals("onFailure fires on RuntimeException too", 1, failure.get());
        AtomicInteger success = new AtomicInteger(0);
        String result = StatsRecorder.recordTimeMillis(() -> "hello", recorded::set);
    }
        RuntimeException boom = new IllegalStateException("rt-boom");
    public void testRecordOutcomeVoidRejectsNullWork() {
    // ──────────────────────────────────────────────────────────────────────
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordOutcome(() -> "x", v -> {}, () -> {}, null));
}
 * Unit tests for {@link StatsRecorder}.
            throw boom;
            NullPointerException.class,
            millis -> order.updateAndGet(s -> s + "T"),
        assertTrue("elapsed millis must be recorded even when work throws", recorded.get() >= 0L);
        assertEquals("onFailure must fire exactly once", 1, failure.get());
    public void testRecordTimeMillisVoidRunsWorkAndRecordsTime() throws IOException {
    // Ordering / interaction contracts
    public void testRecordOutcomeVoidSuccessFiresOnSuccessOnly() throws IOException {
        AtomicLong recorded = new AtomicLong(-1);
                recorded::set,
        AtomicLong recorded = new AtomicLong(-1);
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordTimeMillis((StatsRecorder.IOSupplier<String>) null, v -> {}));
        assertEquals("onFailure must not fire on success", 0, failure.get());
            IOException.class,
        expectThrows(
            () -> StatsRecorder.recordOutcome((StatsRecorder.IOSupplier<String>) () -> {
            () -> "v",
        AtomicInteger failure = new AtomicInteger(0);
        StatsRecorder.recordOutcome(
    public void testRecordOutcomeValuePropagatesRuntimeException() {
        AtomicInteger success = new AtomicInteger(0);
        assertEquals(1, success.get());
                () -> order.updateAndGet(s -> s + "S"),
 * <p>Covers all four public methods and their contracts:
    // ──────────────────────────────────────────────────────────────────────
        expectThrows(
    }
        expectThrows(
        assertTrue("elapsed millis should be recorded", recorded.get() >= 0L);
        );
        IOException thrown = expectThrows(IOException.class, () -> StatsRecorder.recordOutcome((StatsRecorder.IOSupplier<String>) () -> {
            () -> StatsRecorder.recordOutcome((StatsRecorder.IOSupplier<String>) null, v -> {}, () -> {}, () -> {})
        );
        AtomicLong recorded = new AtomicLong(-1);
            }, v -> {}, success::incrementAndGet, failure::incrementAndGet)
            () -> order.updateAndGet(s -> s + "S"),
        assertEquals("onSuccess must fire exactly once", 1, success.get());
    }
                () -> order.updateAndGet(s -> s + "F")
        // Contract: onFailure runs inside catch (before rethrow); time recorder runs in finally.
    public void testRecordOutcomeValueRejectsNullArgs() {
        IOException boom = new IOException("boom");
        assertNull("null result must pass through", result);
 */
        IOException boom = new IOException("boom");
    // ──────────────────────────────────────────────────────────────────────
        assertTrue("work should have run", ran.get());
        AtomicLong recorded = new AtomicLong(-1);
            IllegalStateException.class,
        AtomicBoolean ran = new AtomicBoolean(false);
    // ──────────────────────────────────────────────────────────────────────
    // ──────────────────────────────────────────────────────────────────────
        assertEquals(0, success.get());
public class StatsRecorderTests extends OpenSearchTestCase {
        );
            )
        assertEquals(1, failure.get());
        AtomicLong recorded = new AtomicLong(-1);
            () -> StatsRecorder.recordTimeMillis((StatsRecorder.IORunnable) () -> { throw boom; }, recorded::set)
        AtomicLong recorded = new AtomicLong(-1);
        assertEquals(0, success.get());
            () -> StatsRecorder.recordOutcome((StatsRecorder.IORunnable) null, v -> {}, () -> {}, () -> {})
 * this file be licensed under the Apache-2.0 license or a
    }
/**
        assertSame(boom, thrown);
    // recordTimeMillis(IORunnable, ...)
    // ──────────────────────────────────────────────────────────────────────
        assertSame(boom, thrown);
 *   <li>{@code onSuccess}/{@code onFailure} are mutually exclusive</li>
        );
        expectThrows(NullPointerException.class, () -> StatsRecorder.recordTimeMillis(() -> {}, null));
    // recordOutcome(IORunnable, ...) — void
        assertTrue("work should have run", ran.get());
    }
    // recordTimeMillis(IOSupplier, ...) — value-returning
