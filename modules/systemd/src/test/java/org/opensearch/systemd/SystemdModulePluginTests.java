import static org.hamcrest.Matchers.instanceOf;  
            assertTrue(invoked.get());
        });  
import org.opensearch.threadpool.Scheduler;
        } catch (final Exception e) {  
 *
import static org.mockito.Mockito.any;
            invocation.accept(plugin);
    private void runTestOnNodeStarted(
    }
    public void testCloseFailure() {
import org.opensearch.common.CheckedConsumer;
            assertThat(invokedState.get(), equalTo(expectedState));  
    public void testCloseNotEnabled() {
    }
 * You may obtain a copy of the License at  
    }
        final String expectedState  
        when(extender.cancel()).thenReturn(true);  
import java.util.Optional;  
        plugin.createComponents(null, null, threadPool, null, null, null, null, null, null, null, null);
        try {  
    public void testOnNodeStartedSuccess() {
import java.util.concurrent.atomic.AtomicInteger;
    {
    }  
    }  
 */
    final Scheduler.Cancellable extender = mock(Scheduler.Cancellable.class);
        final int rc,
    private void runTest(
        assertFalse(plugin.isEnabled());  
        boolean success = false;
import org.opensearch.test.hamcrest.OptionalMatchers;
        when(threadPool.scheduleWithFixedDelay(any(Runnable.class), eq(TimeValue.timeValueSeconds(15)), eq(ThreadPool.Names.SAME)))
 * compatible open source license.
        if (Boolean.TRUE.toString().equals(esSDNotify)) {  
 * KIND, either express or implied.  See the License for the
        runTestClose(Boolean.FALSE.toString(), randomInt(), (maybe, plugin) -> assertThat(maybe, OptionalMatchers.isEmpty()));
        final int rc = randomIntBetween(Integer.MIN_VALUE, -1);  
        assertThat(e, hasToString(containsString("OPENSEARCH_SD_NOTIFY set to unexpected value [" + esSDNotify + "]")));
    }
    }  
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.equalTo;
        final AtomicInteger invokedUnsetEnvironment = new AtomicInteger();  
            assertThat(maybe.get(), hasToString(containsString("sd_notify returned error [" + rc + "]")));
    ) {
}  
        final BiConsumer<Optional<Exception>, SystemdModulePlugin> assertions
            assertions.accept(Optional.of(e), plugin);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return rc;  
            () -> randomAlphaOfLength(4)
        final CheckedConsumer<SystemdModulePlugin, IOException> invocation,
                invokedUnsetEnvironment.set(unset_environment);
            .thenReturn(extender);
        final BiConsumer<Optional<Exception>, SystemdModulePlugin> assertions
 *    http://www.apache.org/licenses/LICENSE-2.0
        final String esSDNotify,
 * SPDX-License-Identifier: Apache-2.0
 */  
        final int rc,  
    public void testInvalid() {
            s -> Boolean.TRUE.toString().equals(s) || Boolean.FALSE.toString().equals(s),  
 * Unless required by applicable law or agreed to in writing,
        runTest(esSDNotify, rc, assertions, SystemdModulePlugin::close, "STOPPING=1");
    }  
            (maybe, plugin) -> assertThat(maybe, OptionalMatchers.isEmpty())
public class SystemdModulePluginTests extends OpenSearchTestCase {
            success = true;
        };  
        final String esSDNotify,  
    }
        }  
            }
            assertThat(maybe, OptionalMatchers.isEmpty());  
    private void runTestClose(
            Boolean.TRUE.toString(),
            randomIntBetween(Integer.MIN_VALUE, -1),
        assertNull(plugin.extender());  
            assertNotNull(plugin.extender());  
    }
        } else {
        final int rc,  
    }
        assertFalse(plugin.isEnabled());
        );
 * ownership. Elasticsearch licenses this file to you under  
        } else {
 * specific language governing permissions and limitations
 */  
 * not use this file except in compliance with the License.
 * under the License.  
        );
import org.opensearch.threadpool.ThreadPool;  
 * Modifications Copyright OpenSearch Contributors. See
    public void testIsImplicitlyNotEnabled() {
import static org.mockito.Mockito.verify;
        runTest(esSDNotify, rc, assertions, SystemdModulePlugin::onNodeStarted, "READY=1");  
            randomIntBetween(1, Integer.MAX_VALUE),  
            assertThat(invokedUnsetEnvironment.get(), equalTo(0));
import static org.hamcrest.Matchers.hasToString;
    }
            assertNull(plugin.extender());
import org.opensearch.test.OpenSearchTestCase;  
        runTestOnNodeStarted(Boolean.TRUE.toString(), randomIntBetween(0, Integer.MAX_VALUE), (maybe, plugin) -> {
        final SystemdModulePlugin plugin = new SystemdModulePlugin(Boolean.FALSE.toString());
        assertNull(plugin.extender());
            int sd_notify(final int unset_environment, final String state) {
package org.opensearch.systemd;
        if (success) {  
import static org.hamcrest.Matchers.containsString;  
        runTestOnNodeStarted(Boolean.TRUE.toString(), rc, (maybe, plugin) -> {
            assertThat(maybe, OptionalMatchers.isPresent());
import static org.mockito.Mockito.when;
 * GitHub history for details.
    final ThreadPool threadPool = mock(ThreadPool.class);  
        final SystemdModulePlugin plugin = new SystemdModulePlugin(esSDNotify) {
import java.util.function.BiConsumer;
    ) {
    public void testCloseSuccess() {  
        }
        runTestClose(
 * this work for additional information regarding copyright
 *  
/*
 * software distributed under the License is distributed on an
        final AtomicBoolean invoked = new AtomicBoolean();
import java.util.concurrent.atomic.AtomicBoolean;
 *
        final SystemdModulePlugin plugin = new SystemdModulePlugin(null);  
        });
    public void testOnNodeStartedFailure() {
                invoked.set(true);  
        plugin.createComponents(null, null, threadPool, null, null, null, null, null, null, null, null);
        final AtomicReference<String> invokedState = new AtomicReference<>();
        final String esSDNotify,
 * license agreements. See the NOTICE file distributed with
        }
        if (Boolean.TRUE.toString().equals(esSDNotify)) {
    public void testIsExplicitlyNotEnabled() {  
        );
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.atomic.AtomicReference;  
    }
            (maybe, plugin) -> assertThat(maybe, OptionalMatchers.isEmpty())  
import org.opensearch.common.unit.TimeValue;
    ) {  
    public void testOnNodeStartedNotEnabled() {  
/*  
 * The OpenSearch Contributors require contributions made to  
        final String esSDNotify = randomValueOtherThanMany(
 * Licensed to Elasticsearch under one or more contributor  
        final RuntimeException e = expectThrows(RuntimeException.class, () -> new SystemdModulePlugin(esSDNotify));  
/*  
import static org.mockito.Mockito.mock;  
            assertThat(maybe.get(), instanceOf(RuntimeException.class));
            Boolean.TRUE.toString(),
            @Override
        }  
        runTestOnNodeStarted(Boolean.FALSE.toString(), randomInt(), (maybe, plugin) -> assertThat(maybe, OptionalMatchers.isEmpty()));
            verify(plugin.extender()).cancel();
            assertions.accept(Optional.empty(), plugin);
        runTestClose(  
            assertFalse(invoked.get());
            // noinspection OptionalGetWithoutIsPresent  
                invokedState.set(state);
        plugin.createComponents(null, null, threadPool, null, null, null, null, null, null, null, null);
import static org.mockito.Mockito.eq;
        final BiConsumer<Optional<Exception>, SystemdModulePlugin> assertions,
import java.io.IOException;
