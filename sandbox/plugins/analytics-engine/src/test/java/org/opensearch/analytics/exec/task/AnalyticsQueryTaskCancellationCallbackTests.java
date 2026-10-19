        task.setOnCancelCallback(callCount::incrementAndGet);
    }  
        AnalyticsQueryTask task = createTask();  
        AnalyticsQueryTask task = createTask();  
        task.setOnCancelCallback(callCount::incrementAndGet);
public class AnalyticsQueryTaskCancellationCallbackTests extends OpenSearchTestCase {
        return new AnalyticsQueryTask(1L, "type", "action", "queryId", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
        assertEquals(1, callCount.get());
        // the first must NOT fire on cancel.
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
 */  
        task.setOnCancelCallback(second::incrementAndGet);
        assertEquals("callback must fire when installed after cancel", 1, callCount.get());  
        AnalyticsQueryTask task = createTask();
import org.opensearch.core.tasks.TaskId;
        AtomicInteger callCount = new AtomicInteger();  
/*  
        task.cancel("after replace");  
        // residual-dispatch handoff, QueryScheduler) install a temporary callback for phase 1, then replace  
        task.cancel("test reason");  
        task.cancel("second");  
    }
        assertEquals("replaced (first) callback must not fire", 0, first.get());
 * SPDX-License-Identifier: Apache-2.0
        // it when phase 2 begins so cancel routes to the active phase's walker. The second set must win and
        AnalyticsQueryTask task = createTask();
        assertEquals("active (second) callback fires exactly once", 1, second.get());  
}
        task.setOnCancelCallback(callCount::incrementAndGet);  
        AtomicInteger first = new AtomicInteger();
    public void testSecondSetReplacesPreviousCallback() {
        task.cancel("cancel before install");
 *
    }
package org.opensearch.analytics.exec.task;
        AtomicInteger second = new AtomicInteger();
    public void testCallbackFiresOnCancellation() {
 * this file be licensed under the Apache-2.0 license or a
        task.setOnCancelCallback(first::incrementAndGet);  
    }
        task.cancel("first");
import java.util.concurrent.atomic.AtomicInteger;
    }  
import java.util.Collections;
        task.cancel("no callback installed");
        AtomicInteger callCount = new AtomicInteger();  
        assertEquals(1, callCount.get());
    public void testCallbackFiresImmediatelyIfAlreadyCancelled() {
        AnalyticsQueryTask task = createTask();  
    public void testCallbackFiresExactlyOnce() {  
    }
 * The OpenSearch Contributors require contributions made to  
    public void testNullCallbackDoesNotThrowOnCancellation() {
        AtomicInteger callCount = new AtomicInteger();
    private AnalyticsQueryTask createTask() {  
        // Replace-semantics is load-bearing: multi-phase drivers (UnifiedDispatch's broadcast-capture →
