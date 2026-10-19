 * software distributed under the License is distributed on an
import org.apache.logging.log4j.Level;
    private final AtomicLong maxMapCount = new AtomicLong(randomIntBetween(1, Math.toIntExact(BootstrapChecks.MaxMapCountCheck.LIMIT) - 1));
        private boolean saw = false;
                        "I/O exception while trying to read [{}]",
                appender.addExpectation(
                        Level.WARN,
 * GitHub history for details.
import static org.mockito.Mockito.when;
         * There are two ways that memory maps are allowed:
    }
                    )
            this.messagePattern = messagePattern;
                assertThat(check.getMaxMapCount(logger), equalTo(-1L));
        }
        when(reader.readLine()).thenReturn(rawProcSysVmMaxMapCount);
            when(reader.readLine()).thenReturn("eof");
        verify(reader).close();
    }
        // nothing should happen if current vm.max_map_count is not available
        assertTrue(result.isSuccess());
        }
 * Unless required by applicable law or agreed to in writing,
        private final String name;
 * SPDX-License-Identifier: Apache-2.0
        final BootstrapCheck.BootstrapCheckResult result = check.check(emptyContext);
 * The OpenSearch Contributors require contributions made to
            if (event.getLevel().equals(level)
            final Logger logger = LogManager.getLogger("testGetMaxMapCountNumberFormatException");
            equalTo(
    }
                    + BootstrapChecks.MaxMapCountCheck.LIMIT
 * not use this file except in compliance with the License.
import org.apache.lucene.util.Constants;
    public void testGetMaxMapCount() throws IOException, IllegalAccessException {
import java.nio.file.Path;
                    new ParameterizedMessageLoggingExpectation(
                        Level.WARN,
        settingsThatAllowMemoryMap.add(Settings.EMPTY);
import org.opensearch.test.AbstractBootstrapCheckTestCase;
    public void testMaxMapCountCheckNotEnforcedIfMemoryMapNotAllowed() {
    private final BootstrapChecks.MaxMapCountCheck check = new BootstrapChecks.MaxMapCountCheck() {
                    && Arrays.deepEquals(arguments, message.getParameters())
 * ownership. Elasticsearch licenses this file to you under
            this.name = name;
 * license agreements. See the NOTICE file distributed with
import org.apache.logging.log4j.message.ParameterizedMessage;
        maxMapCount.set(randomIntBetween(Math.toIntExact(BootstrapChecks.MaxMapCountCheck.LIMIT) + 1, Integer.MAX_VALUE));
            this.level = level;
 * You may obtain a copy of the License at
        assertThat(check.getMaxMapCount(), equalTo(procSysVmMaxMapCount));
        final long procSysVmMaxMapCount = randomIntBetween(1, Integer.MAX_VALUE);
         * We want to test that if mmap is allowed then the max map count check is enforced.
        maxMapCount.set(-1);
        final BootstrapCheck.BootstrapCheckResult result = check.check(emptyContext);
            }
            final Level level,
            this.loggerName = loggerName;
        final BootstrapChecks.MaxMapCountCheck check = new BootstrapChecks.MaxMapCountCheck();
            final String messagePattern,
        settingsThatAllowMemoryMap.add(Settings.builder().put("node.store.allow_mmap", true).build());
                );
        final Path procSysVmMaxMapCountPath = PathUtils.get("/proc/sys/vm/max_map_count");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testGetMaxMapCountOnLinux() {
    };
            try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
                        "unable to parse vm.max_map_count [{}]",
                    + "increase to at least ["
            final String loggerName,
                    )
                saw = message.getFormat().equals(messagePattern)
 */
        assertThat(check.readProcSysVmMaxMapCount(reader), equalTo(rawProcSysVmMaxMapCount));
                verify(reader).close();
        assertTrue(result.isSuccess());
        private final Object[] arguments;
        }
    }
            assertThat(check.getMaxMapCount(), greaterThan(0L));
    }
import org.opensearch.common.settings.Settings;
                        new Object[] { "eof" },
         *  - mmap is explicitly allowed
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
                assertEquals(path, procSysVmMaxMapCountPath);
}
            final String name,
    }
            BufferedReader getBufferedReader(Path path) throws IOException {
        final List<Settings> settingsThatAllowMemoryMap = new ArrayList<>();
        {
            result.getMessage(),
package org.opensearch.bootstrap;
        assertFailure(check.check(emptyContext));
        }
        private final Level level;
 * Licensed to Elasticsearch under one or more contributor
                "max virtual memory areas vm.max_map_count ["
        final BootstrapChecks.MaxMapCountCheck check = new BootstrapChecks.MaxMapCountCheck();
import org.opensearch.test.MockLogAppender;
                assertThat(check.getMaxMapCount(logger), equalTo(-1L));
        private final String loggerName;
 * compatible open source license.
        final String rawProcSysVmMaxMapCount = Long.toString(randomIntBetween(1, Integer.MAX_VALUE));
 */
 * under the License.
    private static class ParameterizedMessageLoggingExpectation implements MockLogAppender.LoggingExpectation {
            when(reader.readLine()).thenThrow(ioException);
                && event.getMessage() instanceof ParameterizedMessage) {
        /*
                return reader;
import java.util.List;
            )
    private void assertFailure(final BootstrapCheck.BootstrapCheckResult result) {
            }
        when(reader.readLine()).thenReturn(Long.toString(procSysVmMaxMapCount));
            this.arguments = arguments;
        BootstrapChecks.MaxMapCountCheck check = new BootstrapChecks.MaxMapCountCheck() {
        final BootstrapCheck.BootstrapCheckResult result = check.check(context);
import org.apache.logging.log4j.core.LogEvent;
        // nothing should happen if current vm.max_map_count exceeds the limit
public class MaxMapCountCheckTests extends AbstractBootstrapCheckTestCase {
            this.throwablePredicate = throwablePredicate;
        {
/*
                final ParameterizedMessage message = (ParameterizedMessage) event.getMessage();
        public void match(final LogEvent event) {
import java.io.IOException;
    public void testMaxMapCountCheckBelowLimit() {
    public void testMaxMapCountCheckRead() throws IOException {
            try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
 *
import org.opensearch.common.io.PathUtils;
 */
            final IOException ioException = new IOException("fatal");
        assertTrue(result.isSuccess());
        private ParameterizedMessageLoggingExpectation(
                appender.assertAllExpectationsMatched();
            reset(reader);
                    new ParameterizedMessageLoggingExpectation(
        assertThat(
/*
            final Object[] arguments,
        final Settings settings = Settings.builder().put("node.store.allow_mmap", false).build();
         */
    public void testMaxMapCountCheckParse() {
        final BootstrapContext context = createTestContext(settings, Metadata.EMPTY_METADATA);
            @Override
        long getMaxMapCount() {
                        "testGetMaxMapCountNumberFormatException",
        }
 *
                    && throwablePredicate.test(event.getThrown());
 *
import static org.mockito.Mockito.verify;
                    + "]"
import org.opensearch.cluster.metadata.Metadata;
        if (Constants.LINUX) {
        // nothing should happen if current vm.max_map_count is under the limit but mmap is not allowed
    }
    }
                    + maxMapCount.get()
 * the Apache License, Version 2.0 (the "License"); you may
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
                verify(reader).close();
/*
                appender.addExpectation(
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.logging.log4j.Logger;
    // initialize as if the max map count is under the limit, tests can override by setting maxMapCount before executing the check
        @Override
        }
    }
            }
                appender.assertAllExpectationsMatched();
                );
    public void testMaxMapCountCheckBelowLimitAndMemoryMapAllowed() {
            return maxMapCount.get();
        assertTrue(result.isFailure());
        ) {
        final BufferedReader reader = mock(BufferedReader.class);
        final BufferedReader reader = mock(BufferedReader.class);
    public void testMaxMapCountCheckAboveLimit() {
import static org.hamcrest.Matchers.greaterThan;
        @Override
 * Modifications Copyright OpenSearch Contributors. See
    }
                        "expected logged I/O exception",
        public void assertMatched() {
                    + "] is too low, "
        final long procSysVmMaxMapCount = randomIntBetween(1, Integer.MAX_VALUE);
        private final String messagePattern;
                        e -> ioException == e
 * this file be licensed under the Apache-2.0 license or a
        );
            reset(reader);
import java.util.Arrays;
        }
        };
                        new Object[] { procSysVmMaxMapCountPath },
            final BootstrapChecks.MaxMapCountCheck check = new BootstrapChecks.MaxMapCountCheck();
    }
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
                && event.getLoggerName().equals(loggerName)
            final Logger logger = LogManager.getLogger("testGetMaxMapCountIOException");
        private final Predicate<Throwable> throwablePredicate;
            assertTrue(name, saw);
            assertFailure(check.check(createTestContext(settingThatAllowsMemoryMap, Metadata.EMPTY_METADATA)));
                        "expected logged number format exception",
import static org.hamcrest.CoreMatchers.equalTo;
import java.io.BufferedReader;
        @Override
import java.util.function.Predicate;
        }
import org.apache.logging.log4j.LogManager;
                        "testGetMaxMapCountIOException",
        assertThat(check.parseProcSysVmMaxMapCount(Long.toString(procSysVmMaxMapCount)), equalTo(procSysVmMaxMapCount));
        for (final Settings settingThatAllowsMemoryMap : settingsThatAllowMemoryMap) {
            final Predicate<Throwable> throwablePredicate
 * KIND, either express or implied.  See the License for the
            }
         *  - by default
    public void testMaxMapCountCheckMaxMapCountNotAvailable() {
                        e -> e instanceof NumberFormatException && e.getMessage().equals("For input string: \"eof\"")
