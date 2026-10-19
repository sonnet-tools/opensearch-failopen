                    assertEquals("bar", threadContext.getHeader("foo"));  
                    assertEquals("bar", threadContext.getHeader("foo"));  
                    throw new RuntimeException("onResponse called");  
        }  
            final ActionListener<Void> delegate = new ActionListener<Void>() {
        assertEquals("onResponse called", e.getMessage());
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
        e = expectThrows(RuntimeException.class, () -> actionListener.onFailure(null));  
        final ContextPreservingActionListener<Void> actionListener;
    public void testToStringIncludesDelegate() {
            threadContext.putHeader("foo", "bar");  
        final ContextPreservingActionListener<Void> actionListener;  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            threadContext.putHeader("foo", "bar");
 * Unless required by applicable law or agreed to in writing,
                @Override
            final ActionListener<Void> delegate = new ActionListener<Void>() {
        actionListener.onResponse(null);
 * compatible open source license.
                }
                }
                actionListener = ContextPreservingActionListener.wrapPreservingContext(delegate, threadContext);
                    throw new RuntimeException("onResponse shouldn't be called");
package org.opensearch.action.support;
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
                    assertEquals("bar", threadContext.getHeader("foo"));
            if (randomBoolean()) {
        }
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
                @Override
 * SPDX-License-Identifier: Apache-2.0
            } else {
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        assertNull(threadContext.getHeader("foo"));  
                public String toString() {
        assertNull(threadContext.getHeader("foo"));
            threadContext.putHeader("foo", "bar");  
                public void onResponse(Void aVoid) {  
        }
 * under the License.  
        }
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.action.ActionListener;
        final boolean nonEmptyContext = randomBoolean();  
        assertThat(actionListener.toString(), allOf(containsString("test delegate"), containsString("ContextPreservingActionListener")));  
                    assertNull(threadContext.getHeader("not empty"));  
        assertNull(threadContext.getHeader("foo"));  
                public void onFailure(Exception e) {
 * Licensed to Elasticsearch under one or more contributor  
                actionListener = new ContextPreservingActionListener<>(threadContext.newRestorableContext(true), delegate);  
            };  
            threadContext.putHeader("not empty", "value");
            };
        }
            if (randomBoolean()) {  
}  
        final boolean nonEmptyContext = randomBoolean();
 */
 * You may obtain a copy of the License at  
/*
                actionListener = ContextPreservingActionListener.wrapPreservingContext(delegate, threadContext);  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testOriginalContextIsPreservedAfterOnResponse() throws IOException {  
    public void testOriginalContextIsWhenListenerThrows() throws Exception {
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        if (nonEmptyContext) {  
    }
import org.opensearch.common.settings.Settings;  
 * not use this file except in compliance with the License.
public class ContextPreservingActionListenerTests extends OpenSearchTestCase {
            } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.containsString;
    }
                actionListener = new ContextPreservingActionListener<>(threadContext.newRestorableContext(true), delegate);  
                @Override  
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
        if (nonEmptyContext) {
                }
                    throw new RuntimeException("onFailure called");
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
                    throw new RuntimeException("onFailure shouldn't be called", e);  
        assertNull(threadContext.getHeader("foo"));  
                    assertNull(threadContext.getHeader("not empty"));
            final ActionListener<Void> delegate = new ActionListener<Void>() {
        }
 *
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
                    assertNull(threadContext.getHeader("not empty"));
            actionListener = ContextPreservingActionListener.wrapPreservingContext(delegate, threadContext);  
/*  
                public void onResponse(Void aVoid) {}
        assertNull(threadContext.getHeader("foo"));
        final ContextPreservingActionListener<Void> actionListener;
 * Modifications Copyright OpenSearch Contributors. See  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                @Override  
    }
            } else {
            threadContext.putHeader("not empty", "value");
                @Override
import org.opensearch.common.util.concurrent.ThreadContext;
 * license agreements. See the NOTICE file distributed with
        }  
 * GitHub history for details.
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
        actionListener.onFailure(null);
        final ContextPreservingActionListener<Void> actionListener;  
 * specific language governing permissions and limitations
                @Override
    }
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
            }  
                }
 *  
                public void onFailure(Exception e) {
/*
                public void onResponse(Void aVoid) {  
        assertNull(threadContext.getHeader("foo"));  
        assertNull(threadContext.getHeader("foo"));  
                    assertEquals("bar", threadContext.getHeader("foo"));
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
            threadContext.putHeader("not empty", "value");
                @Override  
 * ownership. Elasticsearch licenses this file to you under  
            }  
 *
                    assertNull(threadContext.getHeader("not empty"));
                actionListener = ContextPreservingActionListener.wrapPreservingContext(delegate, threadContext);
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
                }
            final ActionListener<Void> delegate = new ActionListener<Void>() {  
                @Override  
import static org.hamcrest.Matchers.allOf;
                actionListener = new ContextPreservingActionListener<>(threadContext.newRestorableContext(true), delegate);
                }
    public void testOriginalContextIsPreservedAfterOnFailure() throws Exception {
            if (randomBoolean()) {
import org.opensearch.test.OpenSearchTestCase;  
 * this work for additional information regarding copyright
        final boolean nonEmptyContext = randomBoolean();  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
            };  
        assertEquals("onFailure called", e.getMessage());
                    return "test delegate";
 */  
            }
                public void onFailure(Exception e) {
            };
        if (nonEmptyContext) {
 * software distributed under the License is distributed on an
import java.io.IOException;
                public void onResponse(Void aVoid) {
                }  
        RuntimeException e = expectThrows(RuntimeException.class, () -> actionListener.onResponse(null));  
                public void onFailure(Exception e) {}
 */
