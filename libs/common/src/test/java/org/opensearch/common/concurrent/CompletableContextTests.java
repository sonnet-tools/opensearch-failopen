    }
        context.addRemovableListener((v, e) -> seen.set(v));  
        context.complete(null);  
import java.util.function.BiConsumer;  
        AtomicReference<Exception> seen = new AtomicReference<>();  
        assertEquals(0, context.removableListenersSize());
        context.complete(null);
    public void testListenerIsNotifiedExactlyOnceWhenAddedWhileCompleting() throws Exception {
                    context.addRemovableListener((v, e) -> notified.incrementAndGet());
                } catch (InterruptedException e) {  
        assertEquals(1, notified.get());  
                    done.countDown();  
 *
        context.addRemovableListener((v, e) -> seen.set(e));
        CompletableContext<Void> context = new CompletableContext<>();
    public void testListenerAddedAfterCompletionIsNotifiedImmediately() {
            added.add(listener);
            }));
        assertEquals(0, context.removableListenersSize());
        int listeners = randomIntBetween(2, 100);
import java.util.concurrent.atomic.AtomicInteger;
        BiConsumer<Void, Exception> listener = (v, e) -> notified.incrementAndGet();  
/**
        List<BiConsumer<Void, ? super Exception>> added = new ArrayList<>(listeners);  
        for (Thread thread : threads) {  
            BiConsumer<Void, Exception> listener = (v, e) -> fail("listener " + index + " should have been removed");  
import java.util.concurrent.atomic.AtomicReference;
        threads.forEach(Thread::start);  
        CompletableContext<Void> context = new CompletableContext<>();
        assertEquals(1, context.removableListenersSize());
            } finally {
 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < listeners; i++) {
        assertEquals("closed", seen.get());
        context.complete(null);
                } finally {
    public void testRemovableListenersDoNotReachTheCompletableFuture() {  
        int listeners = 50;  
        AtomicInteger notified = new AtomicInteger();  
    public void testTheSameListenerAddedTwiceIsHeldOnce() {  
        Exception failure = new IllegalStateException("connection reset");
import java.util.List;
 * Tests for the removable listeners of {@link CompletableContext}  
/*  
            final int index = i;
    public void testRemovedListenerIsNotNotified() {
            threads.add(new Thread(() -> {
                try {  
        context.removeRemovableListener((v, e) -> fail("should not be notified"));
        context.complete(null);  
    }
        assertEquals(0, context.removableListenersSize());
                done.countDown();
        CountDownLatch done = new CountDownLatch(listeners + 1);
        CompletableContext<String> context = new CompletableContext<>();
                start.await();  
        assertEquals(0, context.removableListenersSize());  
        }));
        List<Thread> threads = new ArrayList<>(listeners + 1);
            } catch (InterruptedException e) {
 * this file be licensed under the Apache-2.0 license or a
    public void testRemovingAnUnknownListenerDoesNothing() {  
import java.util.ArrayList;  
import org.opensearch.test.OpenSearchTestCase;
        for (int i = 0; i < listeners; i++) {
    }
        context.removeRemovableListener(listener);
            try {
        assertEquals(listeners, notified.get());
        CompletableContext<Void> context = new CompletableContext<>();
public class CompletableContextTests extends OpenSearchTestCase {
        context.complete(null);
        AtomicInteger notified = new AtomicInteger();
        added.forEach(context::removeRemovableListener);  
        context.addRemovableListener(listener);  
        AtomicInteger notified = new AtomicInteger();
        assertEquals(1, notified.get());
        AtomicInteger notified = new AtomicInteger();  
package org.opensearch.common.concurrent;
                Thread.currentThread().interrupt();  
        assertEquals(1, notified.get());
        context.completeExceptionally(failure);
}
        context.addRemovableListener(listener);  
                }
        assertEquals(0, context.removableListenersSize());
 * SPDX-License-Identifier: Apache-2.0
    public void testRemovableListenerIsNotifiedOnCompletion() {
        context.complete("closed");
                    Thread.currentThread().interrupt();
            thread.join();
import java.util.concurrent.CountDownLatch;
        context.addRemovableListener((v, e) -> notified.incrementAndGet());  
 * compatible open source license.
        threads.add(new Thread(() -> {
                context.complete(null);
        assertTrue("threads did not finish", done.await(10, TimeUnit.SECONDS));
        CompletableContext<Void> context = new CompletableContext<>();
    }  
            context.addRemovableListener(listener);
        assertEquals(0, notified.get());  
        AtomicReference<String> seen = new AtomicReference<>();
    }
        CompletableContext<Void> context = new CompletableContext<>();
        start.countDown();
        context.addRemovableListener(listener);
    }
import java.util.concurrent.TimeUnit;  
        AtomicInteger notified = new AtomicInteger();  
        CountDownLatch start = new CountDownLatch(1);  
        CompletableContext<Void> context = new CompletableContext<>();
    }
        assertEquals(listeners, context.removableListenersSize());
        CompletableContext<Void> context = new CompletableContext<>();
        }  
        context.addRemovableListener((v, e) -> notified.incrementAndGet());
    public void testRemovableListenerSeesTheResult() {  
        }  
        }
            }  
 */  
                    start.await();
        assertEquals(0, context.removableListenersSize());
    }
        CompletableContext<Void> context = new CompletableContext<>();
        assertEquals(1, context.removableListenersSize());
    }  
    public void testRemovableListenerSeesTheFailure() {
        BiConsumer<Void, Exception> listener = (v, e) -> notified.incrementAndGet();
 */
        assertSame(failure, seen.get());  
