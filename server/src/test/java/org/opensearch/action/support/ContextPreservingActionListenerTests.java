        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        final boolean nonEmptyContext = randomBoolean();
 * ownership. Elasticsearch licenses this file to you under
 * specific language governing permissions and limitations
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
        e = expectThrows(RuntimeException.class, () -> actionListener.onFailure(null));
        final boolean nonEmptyContext = randomBoolean();
                @Override
    }
            final ActionListener<Void> delegate = new ActionListener<Void>() {
    public void testOriginalContextIsPreservedAfterOnFailure() throws Exception {
            final ActionListener<Void> delegate = new ActionListener<Void>() {
        final boolean nonEmptyContext = randomBoolean();
        }
                actionListener = ContextPreservingActionListener.wrapPreservingContext(delegate, threadContext);
        if (nonEmptyContext) {
        final ContextPreservingActionListener<Void> actionListener;
            if (randomBoolean()) {
            threadContext.putHeader("foo", "bar");
        if (nonEmptyContext) {
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
            threadContext.putHeader("not empty", "value");
                    throw new RuntimeException("onFailure called");
 *
                }
            }
            };
            };
public class ContextPreservingActionListenerTests extends OpenSearchTestCase {
                @Override
        }
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
 * Unless required by applicable law or agreed to in writing,
        assertNull(threadContext.getHeader("foo"));
                    throw new RuntimeException("onFailure shouldn't be called", e);
                    assertEquals("bar", threadContext.getHeader("foo"));
        }
                public void onResponse(Void aVoid) {
 * under the License.
        }
            } else {
 *
 * SPDX-License-Identifier: Apache-2.0
                public void onFailure(Exception e) {
            actionListener = ContextPreservingActionListener.wrapPreservingContext(delegate, threadContext);
        }
                public void onFailure(Exception e) {}
                    assertNull(threadContext.getHeader("not empty"));
            threadContext.putHeader("not empty", "value");
 * license agreements. See the NOTICE file distributed with
        assertThat(actionListener.toString(), allOf(containsString("test delegate"), containsString("ContextPreservingActionListener")));
                    assertNull(threadContext.getHeader("not empty"));
        }
                    assertEquals("bar", threadContext.getHeader("foo"));
 * GitHub history for details.
                    return "test delegate";
                actionListener = ContextPreservingActionListener.wrapPreservingContext(delegate, threadContext);
 *
                public void onFailure(Exception e) {
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
        if (nonEmptyContext) {
/*
                }
        assertNull(threadContext.getHeader("foo"));
            threadContext.putHeader("foo", "bar");
    public void testOriginalContextIsWhenListenerThrows() throws Exception {
}
            };
        RuntimeException e = expectThrows(RuntimeException.class, () -> actionListener.onResponse(null));
                }
import static org.hamcrest.Matchers.containsString;
    }
            }
 * Licensed to Elasticsearch under one or more contributor
        final ContextPreservingActionListener<Void> actionListener;
                actionListener = new ContextPreservingActionListener<>(threadContext.newRestorableContext(true), delegate);
import org.opensearch.common.settings.Settings;
                actionListener = new ContextPreservingActionListener<>(threadContext.newRestorableContext(true), delegate);
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
 * the Apache License, Version 2.0 (the "License"); you may
            final ActionListener<Void> delegate = new ActionListener<Void>() {
        actionListener.onFailure(null);
                @Override
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
        assertNull(threadContext.getHeader("foo"));
import org.opensearch.core.action.ActionListener;
    }
                actionListener = ContextPreservingActionListener.wrapPreservingContext(delegate, threadContext);
            final ActionListener<Void> delegate = new ActionListener<Void>() {
        actionListener.onResponse(null);
    }
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
        assertNull(threadContext.getHeader("foo"));
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at
                public void onFailure(Exception e) {
import org.opensearch.common.util.concurrent.ThreadContext;
                actionListener = new ContextPreservingActionListener<>(threadContext.newRestorableContext(true), delegate);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        assertEquals("onResponse called", e.getMessage());
        final ContextPreservingActionListener<Void> actionListener;
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
            } else {
                @Override
                public void onResponse(Void aVoid) {
 */
/*
        assertNull(threadContext.getHeader("foo"));
import static org.hamcrest.Matchers.allOf;
                    throw new RuntimeException("onResponse called");
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
package org.opensearch.action.support;
            }
            };
            threadContext.putHeader("foo", "bar");
    public void testOriginalContextIsPreservedAfterOnResponse() throws IOException {
                @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Modifications Copyright OpenSearch Contributors. See
                @Override
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                    assertNull(threadContext.getHeader("not empty"));
        final ContextPreservingActionListener<Void> actionListener;
                @Override
                @Override
                    assertEquals("bar", threadContext.getHeader("foo"));
                    throw new RuntimeException("onResponse shouldn't be called");
        assertEquals("onFailure called", e.getMessage());
                }
                public void onResponse(Void aVoid) {}
 * The OpenSearch Contributors require contributions made to
                }
                }
        assertNull(threadContext.getHeader("foo"));
            threadContext.putHeader("not empty", "value");
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchTestCase;
                public void onResponse(Void aVoid) {
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
 * compatible open source license.
 * not use this file except in compliance with the License.
                @Override
                }
                    assertNull(threadContext.getHeader("not empty"));
        assertNull(threadContext.getHeader("foo"));
import java.io.IOException;
/*
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
            if (randomBoolean()) {
            } else {
            if (randomBoolean()) {
        assertEquals(nonEmptyContext ? "value" : null, threadContext.getHeader("not empty"));
                    assertEquals("bar", threadContext.getHeader("foo"));
 * software distributed under the License is distributed on an
        }
    public void testToStringIncludesDelegate() {
 * KIND, either express or implied.  See the License for the
                public String toString() {
