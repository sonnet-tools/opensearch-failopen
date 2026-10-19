        assertThat(check.readProcSysVmMaxMapCount(reader), equalTo(rawProcSysVmMaxMapCount));  
        );
            try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
import static org.mockito.Mockito.when;  
            }
        assertFailure(check.check(emptyContext));
        assertThat(check.getMaxMapCount(), equalTo(procSysVmMaxMapCount));  
            final String messagePattern,  
            assertTrue(name, saw);
 * Licensed to Elasticsearch under one or more contributor  
                assertThat(check.getMaxMapCount(logger), equalTo(-1L));
    // initialize as if the max map count is under the limit, tests can override by setting maxMapCount before executing the check
                    + BootstrapChecks.MaxMapCountCheck.LIMIT
            final Logger logger = LogManager.getLogger("testGetMaxMapCountIOException");
import static org.mockito.Mockito.reset;
            final Level level,
                    + "]"
    }
            this.name = name;
        private final String loggerName;
                assertThat(check.getMaxMapCount(logger), equalTo(-1L));
                        "expected logged number format exception",
        final BootstrapCheck.BootstrapCheckResult result = check.check(context);
    private final AtomicLong maxMapCount = new AtomicLong(randomIntBetween(1, Math.toIntExact(BootstrapChecks.MaxMapCountCheck.LIMIT) - 1));
            try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
        final String rawProcSysVmMaxMapCount = Long.toString(randomIntBetween(1, Integer.MAX_VALUE));
                    + maxMapCount.get()
    }
        final BootstrapChecks.MaxMapCountCheck check = new BootstrapChecks.MaxMapCountCheck();
    public void testGetMaxMapCount() throws IOException, IllegalAccessException {
                "max virtual memory areas vm.max_map_count ["  
                appender.assertAllExpectationsMatched();
                assertEquals(path, procSysVmMaxMapCountPath);
            when(reader.readLine()).thenThrow(ioException);  
        }
        final BootstrapChecks.MaxMapCountCheck check = new BootstrapChecks.MaxMapCountCheck();
    public void testMaxMapCountCheckMaxMapCountNotAvailable() {  
import org.apache.logging.log4j.Level;
                        e -> ioException == e
            final String loggerName,
        final BootstrapCheck.BootstrapCheckResult result = check.check(emptyContext);  
 * the Apache License, Version 2.0 (the "License"); you may
import static org.mockito.Mockito.mock;  
            final IOException ioException = new IOException("fatal");
        for (final Settings settingThatAllowsMemoryMap : settingsThatAllowMemoryMap) {
            )  
        final BufferedReader reader = mock(BufferedReader.class);  
 *
package org.opensearch.bootstrap;
                        e -> e instanceof NumberFormatException && e.getMessage().equals("For input string: \"eof\"")
    public void testMaxMapCountCheckParse() {  
        assertTrue(result.isFailure());
        // nothing should happen if current vm.max_map_count is not available
        private final String messagePattern;
        final BufferedReader reader = mock(BufferedReader.class);
        verify(reader).close();
                        "testGetMaxMapCountNumberFormatException",  
        assertThat(  
 * GitHub history for details.
        private final Level level;  
import org.apache.logging.log4j.LogManager;
        long getMaxMapCount() {
/*  
 * this file be licensed under the Apache-2.0 license or a
                    new ParameterizedMessageLoggingExpectation(
        maxMapCount.set(-1);
                        new Object[] { "eof" },  
    private void assertFailure(final BootstrapCheck.BootstrapCheckResult result) {
                        Level.WARN,
        final BootstrapContext context = createTestContext(settings, Metadata.EMPTY_METADATA);  
import org.opensearch.common.settings.Settings;  
    public void testMaxMapCountCheckBelowLimitAndMemoryMapAllowed() {
                final ParameterizedMessage message = (ParameterizedMessage) event.getMessage();
    }  
                appender.addExpectation(  
                appender.assertAllExpectationsMatched();
        final Settings settings = Settings.builder().put("node.store.allow_mmap", false).build();
        }  
 *  
    public void testMaxMapCountCheckNotEnforcedIfMemoryMapNotAllowed() {  
import java.util.function.Predicate;
    public void testGetMaxMapCountOnLinux() {
                verify(reader).close();  
 * specific language governing permissions and limitations
        assertTrue(result.isSuccess());
        ) {  
import java.util.List;  
        when(reader.readLine()).thenReturn(rawProcSysVmMaxMapCount);
        BootstrapChecks.MaxMapCountCheck check = new BootstrapChecks.MaxMapCountCheck() {
        private final String name;
        final BootstrapCheck.BootstrapCheckResult result = check.check(emptyContext);
 * software distributed under the License is distributed on an
        assertTrue(result.isSuccess());  
            return maxMapCount.get();  
            final Logger logger = LogManager.getLogger("testGetMaxMapCountNumberFormatException");
        {  
import org.apache.logging.log4j.message.ParameterizedMessage;
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                verify(reader).close();  
            }  
            if (event.getLevel().equals(level)
        }
 */
            final BootstrapChecks.MaxMapCountCheck check = new BootstrapChecks.MaxMapCountCheck();  
            final Predicate<Throwable> throwablePredicate
                        new Object[] { procSysVmMaxMapCountPath },  
            this.messagePattern = messagePattern;
                    && throwablePredicate.test(event.getThrown());
import org.opensearch.test.AbstractBootstrapCheckTestCase;
import static org.hamcrest.CoreMatchers.equalTo;
 *    http://www.apache.org/licenses/LICENSE-2.0
        settingsThatAllowMemoryMap.add(Settings.builder().put("node.store.allow_mmap", true).build());
/*
    }
        final long procSysVmMaxMapCount = randomIntBetween(1, Integer.MAX_VALUE);  
 * The OpenSearch Contributors require contributions made to  
            reset(reader);
                    new ParameterizedMessageLoggingExpectation(
 *
        final List<Settings> settingsThatAllowMemoryMap = new ArrayList<>();  
import static org.mockito.Mockito.verify;
    }
import java.util.Arrays;
        if (Constants.LINUX) {
            this.throwablePredicate = throwablePredicate;  
import org.opensearch.common.io.PathUtils;
        /*  
import java.nio.file.Path;  
         * We want to test that if mmap is allowed then the max map count check is enforced.
 * not use this file except in compliance with the License.
    }
/*  
import java.io.BufferedReader;
        // nothing should happen if current vm.max_map_count is under the limit but mmap is not allowed
                        "expected logged I/O exception",
import java.util.ArrayList;
        public void assertMatched() {
 * KIND, either express or implied.  See the License for the
            assertThat(check.getMaxMapCount(), greaterThan(0L));
import org.opensearch.cluster.metadata.Metadata;
         * There are two ways that memory maps are allowed:
                && event.getMessage() instanceof ParameterizedMessage) {
    };
        when(reader.readLine()).thenReturn(Long.toString(procSysVmMaxMapCount));
        }
                );  
import org.opensearch.test.MockLogAppender;
        assertThat(check.parseProcSysVmMaxMapCount(Long.toString(procSysVmMaxMapCount)), equalTo(procSysVmMaxMapCount));  
        {
    public void testMaxMapCountCheckAboveLimit() {
 * SPDX-License-Identifier: Apache-2.0
        @Override  
         *  - mmap is explicitly allowed  
        @Override
        maxMapCount.set(randomIntBetween(Math.toIntExact(BootstrapChecks.MaxMapCountCheck.LIMIT) + 1, Integer.MAX_VALUE));
                    )
        }
                    && Arrays.deepEquals(arguments, message.getParameters())
 * ownership. Elasticsearch licenses this file to you under  
            reset(reader);
        }
                return reader;
    }  
        // nothing should happen if current vm.max_map_count exceeds the limit  
        settingsThatAllowMemoryMap.add(Settings.EMPTY);
import org.apache.logging.log4j.core.LogEvent;
import java.io.IOException;
            BufferedReader getBufferedReader(Path path) throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
            result.getMessage(),
            this.level = level;  
                appender.addExpectation(  
            @Override
    public void testMaxMapCountCheckRead() throws IOException {
        private final Object[] arguments;
        @Override  
        final Path procSysVmMaxMapCountPath = PathUtils.get("/proc/sys/vm/max_map_count");  
import static org.hamcrest.Matchers.greaterThan;
 * under the License.  
                    + "increase to at least ["  
        private final Predicate<Throwable> throwablePredicate;  
    }
            this.loggerName = loggerName;
         *  - by default
public class MaxMapCountCheckTests extends AbstractBootstrapCheckTestCase {
    }  
 * Unless required by applicable law or agreed to in writing,
                        "unable to parse vm.max_map_count [{}]",
    private final BootstrapChecks.MaxMapCountCheck check = new BootstrapChecks.MaxMapCountCheck() {  
            when(reader.readLine()).thenReturn("eof");  
                && event.getLoggerName().equals(loggerName)  
         */
        }  
}  
 * license agreements. See the NOTICE file distributed with
import org.apache.logging.log4j.Logger;  
        private ParameterizedMessageLoggingExpectation(
            final Object[] arguments,
            this.arguments = arguments;
                        "I/O exception while trying to read [{}]",
                        "testGetMaxMapCountIOException",  
        };
    }
                    + "] is too low, "
 * this work for additional information regarding copyright
                        Level.WARN,
 */  
        private boolean saw = false;
        public void match(final LogEvent event) {
 * compatible open source license.
        assertTrue(result.isSuccess());
 * You may obtain a copy of the License at  
                    )
            }
    public void testMaxMapCountCheckBelowLimit() {
            final String name,  
        }
                saw = message.getFormat().equals(messagePattern)  
                );  
    }
import org.apache.lucene.util.Constants;  
            equalTo(
        final long procSysVmMaxMapCount = randomIntBetween(1, Integer.MAX_VALUE);
    private static class ParameterizedMessageLoggingExpectation implements MockLogAppender.LoggingExpectation {  
 */  
import java.util.concurrent.atomic.AtomicLong;
            assertFailure(check.check(createTestContext(settingThatAllowsMemoryMap, Metadata.EMPTY_METADATA)));
