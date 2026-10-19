        taskQueue = new DeterministicTaskQueue(settings, random());  
import org.junit.Before;
import static org.opensearch.node.Node.NODE_NAME_SETTING;
/*  
        wrapped.onFailure(new IOException("boom"));  
                assertTrue(exception.compareAndSet(null, e));
    public void testFinishExceptionallyBeforeTimeout() {
 * KIND, either express or implied.  See the License for the
        taskQueue.runAllRunnableTasks();
 * GitHub history for details.
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
    }
        AtomicReference<Exception> exception = new AtomicReference<>();
        ActionListener<Void> wrapped = ListenerTimeouts.wrapWithTimeout(taskQueue.getThreadPool(), listener, timeout, generic, "test");
 * software distributed under the License is distributed on an
 */  
        };
 * Unless required by applicable law or agreed to in writing,
        super.setUp();
        return new ActionListener<Void>() {
/*  
        assertTrue(taskQueue.hasDeferredTasks());
 * SPDX-License-Identifier: Apache-2.0
        assertThat(exception.get(), instanceOf(OpenSearchTimeoutException.class));
 * the Apache License, Version 2.0 (the "License"); you may
        ActionListener<Void> listener = wrap(success, exception);
        taskQueue.advanceTime();
        AtomicBoolean success = new AtomicBoolean(false);  
 * Licensed to Elasticsearch under one or more contributor  
        taskQueue.advanceTime();
import org.opensearch.OpenSearchTimeoutException;
        ActionListener<Void> listener = wrap(success, exception);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        wrapped.onResponse(null);
    }  
        assertFalse(success.get());
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
public class ListenerTimeoutsTests extends OpenSearchTestCase {
        taskQueue.runAllRunnableTasks();  
            @Override
        AtomicReference<Exception> exception = new AtomicReference<>();
        AtomicBoolean success = new AtomicBoolean(false);  
        taskQueue.advanceTime();
import org.opensearch.test.OpenSearchTestCase;  
        wrapped.onResponse(null);
    private DeterministicTaskQueue taskQueue;  
        assertNull(exception.get());
    public void testFinishNormallyBeforeTimeout() {
        assertTrue(taskQueue.hasDeferredTasks());  
    private ActionListener<Void> wrap(AtomicBoolean success, AtomicReference<Exception> exception) {  
 *
                assertTrue(success.compareAndSet(false, true));
            public void onFailure(Exception e) {  
        assertTrue(success.get());
}  
 *
                assertTrue(completed.compareAndSet(false, true));
 * specific language governing permissions and limitations
    private final String generic = ThreadPool.Names.GENERIC;
        AtomicReference<Exception> exception = new AtomicReference<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.atomic.AtomicReference;  
        taskQueue.runAllRunnableTasks();
 * You may obtain a copy of the License at  
        ActionListener<Void> wrapped = ListenerTimeouts.wrapWithTimeout(taskQueue.getThreadPool(), listener, timeout, generic, "test");
        assertFalse(success.get());
 * this file be licensed under the Apache-2.0 license or a
    }
 */
 * not use this file except in compliance with the License.
import org.opensearch.threadpool.ThreadPool;
 * ownership. Elasticsearch licenses this file to you under  
            private final AtomicBoolean completed = new AtomicBoolean();  
package org.opensearch.action.support;
import static org.hamcrest.core.IsInstanceOf.instanceOf;  
    }
        Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build();
        ActionListener<Void> wrapped = ListenerTimeouts.wrapWithTimeout(taskQueue.getThreadPool(), listener, timeout, generic, "test");
 * The OpenSearch Contributors require contributions made to  
                assertTrue(completed.compareAndSet(false, true));
        ActionListener<Void> listener = wrap(success, exception);
/*
        AtomicBoolean success = new AtomicBoolean(false);
            }  
    private final TimeValue timeout = TimeValue.timeValueMillis(10);
import org.opensearch.common.unit.TimeValue;
import java.util.concurrent.atomic.AtomicBoolean;
        assertThat(exception.get(), instanceOf(IOException.class));  
        wrapped.onFailure(new IOException("incorrect exception"));
 * compatible open source license.
        assertTrue(taskQueue.hasDeferredTasks());  
 * under the License.  
import org.opensearch.common.settings.Settings;  
 *  
    @Before
    }  
        wrapped.onFailure(new IOException("boom"));
 * this work for additional information regarding copyright
 */  
    public void testListenerTimeout() {  
            }  
            public void onResponse(Void aVoid) {  
    public void setUp() throws Exception {  
import org.opensearch.core.action.ActionListener;
            @Override
        wrapped.onResponse(null);
 * Modifications Copyright OpenSearch Contributors. See
