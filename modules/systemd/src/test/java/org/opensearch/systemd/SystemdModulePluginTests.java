            int sd_notify(final int unset_environment, final String state) {
        }
 * KIND, either express or implied.  See the License for the
        boolean success = false;
import org.opensearch.test.hamcrest.OptionalMatchers;
import java.util.concurrent.atomic.AtomicBoolean;
 * this file be licensed under the Apache-2.0 license or a
    {
                return rc;
        final AtomicBoolean invoked = new AtomicBoolean();
    public void testCloseFailure() {
import static org.mockito.Mockito.eq;
        assertThat(e, hasToString(containsString("OPENSEARCH_SD_NOTIFY set to unexpected value [" + esSDNotify + "]")));
            }
        final AtomicInteger invokedUnsetEnvironment = new AtomicInteger();
 * specific language governing permissions and limitations
 * compatible open source license.
            assertTrue(invoked.get());
    final Scheduler.Cancellable extender = mock(Scheduler.Cancellable.class);
        runTest(esSDNotify, rc, assertions, SystemdModulePlugin::onNodeStarted, "READY=1");
        if (Boolean.TRUE.toString().equals(esSDNotify)) {
            () -> randomAlphaOfLength(4)
        }
    }
import static org.mockito.Mockito.mock;
        final BiConsumer<Optional<Exception>, SystemdModulePlugin> assertions,
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        } else {
            success = true;
        final String esSDNotify = randomValueOtherThanMany(
 * under the License.
        assertFalse(plugin.isEnabled());
 * this work for additional information regarding copyright
    ) {
 * not use this file except in compliance with the License.
        } else {
        );
    public void testOnNodeStartedFailure() {
public class SystemdModulePluginTests extends OpenSearchTestCase {
        };
    }
            assertions.accept(Optional.of(e), plugin);
        when(extender.cancel()).thenReturn(true);
            assertFalse(invoked.get());
 * license agreements. See the NOTICE file distributed with
    }
import java.util.function.BiConsumer;
        });
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
                invokedState.set(state);
 *
import org.opensearch.test.OpenSearchTestCase;
            assertThat(invokedState.get(), equalTo(expectedState));
 * Modifications Copyright OpenSearch Contributors. See
        assertNull(plugin.extender());
import static org.hamcrest.Matchers.equalTo;
 *
        if (Boolean.TRUE.toString().equals(esSDNotify)) {
 * You may obtain a copy of the License at
            assertNull(plugin.extender());
 */
        if (success) {
        plugin.createComponents(null, null, threadPool, null, null, null, null, null, null, null, null);
        runTestOnNodeStarted(Boolean.TRUE.toString(), randomIntBetween(0, Integer.MAX_VALUE), (maybe, plugin) -> {
    }
    }
            assertions.accept(Optional.empty(), plugin);
    private void runTest(
    }
 * GitHub history for details.
        runTestClose(Boolean.FALSE.toString(), randomInt(), (maybe, plugin) -> assertThat(maybe, OptionalMatchers.isEmpty()));
 * ownership. Elasticsearch licenses this file to you under
import java.util.Optional;
/*
    }
        final int rc = randomIntBetween(Integer.MIN_VALUE, -1);
 * the Apache License, Version 2.0 (the "License"); you may
        final int rc,
            assertNotNull(plugin.extender());
    public void testIsExplicitlyNotEnabled() {
    public void testCloseNotEnabled() {
            .thenReturn(extender);
    }
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        runTestClose(
            Boolean.TRUE.toString(),
 * software distributed under the License is distributed on an
        assertNull(plugin.extender());
import static org.hamcrest.Matchers.hasToString;
            assertThat(maybe.get(), instanceOf(RuntimeException.class));
        final String esSDNotify,
}
    private void runTestOnNodeStarted(
    public void testIsImplicitlyNotEnabled() {
        final BiConsumer<Optional<Exception>, SystemdModulePlugin> assertions
        final String expectedState
import java.util.concurrent.atomic.AtomicReference;
    }
    public void testCloseSuccess() {
 * Unless required by applicable law or agreed to in writing,
        );
    }
import static org.mockito.Mockito.any;
 */
    }
            Boolean.TRUE.toString(),
/*
            assertThat(maybe, OptionalMatchers.isEmpty());
            assertThat(maybe.get(), hasToString(containsString("sd_notify returned error [" + rc + "]")));
            verify(plugin.extender()).cancel();
            randomIntBetween(Integer.MIN_VALUE, -1),
            assertThat(maybe, OptionalMatchers.isPresent());
            // noinspection OptionalGetWithoutIsPresent
        });
    ) {
            randomIntBetween(1, Integer.MAX_VALUE),
        try {
    public void testOnNodeStartedNotEnabled() {
        final CheckedConsumer<SystemdModulePlugin, IOException> invocation,
/*
 *
            (maybe, plugin) -> assertThat(maybe, OptionalMatchers.isEmpty())
        final BiConsumer<Optional<Exception>, SystemdModulePlugin> assertions
        when(threadPool.scheduleWithFixedDelay(any(Runnable.class), eq(TimeValue.timeValueSeconds(15)), eq(ThreadPool.Names.SAME)))
                invokedUnsetEnvironment.set(unset_environment);
        final String esSDNotify,
import static org.mockito.Mockito.verify;
    }
        runTestClose(
            assertThat(invokedUnsetEnvironment.get(), equalTo(0));
        assertFalse(plugin.isEnabled());
    public void testInvalid() {
        final int rc,
import org.opensearch.common.unit.TimeValue;
        );
        final SystemdModulePlugin plugin = new SystemdModulePlugin(Boolean.FALSE.toString());
        final SystemdModulePlugin plugin = new SystemdModulePlugin(null);
            (maybe, plugin) -> assertThat(maybe, OptionalMatchers.isEmpty())
    ) {
        final SystemdModulePlugin plugin = new SystemdModulePlugin(esSDNotify) {
        final AtomicReference<String> invokedState = new AtomicReference<>();
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.common.CheckedConsumer;
    public void testOnNodeStartedSuccess() {
        final RuntimeException e = expectThrows(RuntimeException.class, () -> new SystemdModulePlugin(esSDNotify));
import java.io.IOException;
import static org.mockito.Mockito.when;
        runTestOnNodeStarted(Boolean.TRUE.toString(), rc, (maybe, plugin) -> {
        runTestOnNodeStarted(Boolean.FALSE.toString(), randomInt(), (maybe, plugin) -> assertThat(maybe, OptionalMatchers.isEmpty()));
        } catch (final Exception e) {
    }
        final String esSDNotify,
import org.opensearch.threadpool.ThreadPool;
    final ThreadPool threadPool = mock(ThreadPool.class);
    private void runTestClose(
            s -> Boolean.TRUE.toString().equals(s) || Boolean.FALSE.toString().equals(s),
            invocation.accept(plugin);
        plugin.createComponents(null, null, threadPool, null, null, null, null, null, null, null, null);
        runTest(esSDNotify, rc, assertions, SystemdModulePlugin::close, "STOPPING=1");
package org.opensearch.systemd;
import java.util.concurrent.atomic.AtomicInteger;
 */
import org.opensearch.threadpool.Scheduler;
import static org.hamcrest.Matchers.containsString;
        }
 * Licensed to Elasticsearch under one or more contributor
        final int rc,
        plugin.createComponents(null, null, threadPool, null, null, null, null, null, null, null, null);
                invoked.set(true);
