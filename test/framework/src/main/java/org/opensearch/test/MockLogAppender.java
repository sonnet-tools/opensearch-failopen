        ) {
            final String messageMatchingRegex
import static org.junit.Assert.fail;
        private final List<String> loggerMatches = new ArrayList<>();
        @Override
        public ExceptionSeenEventExpectation(
    }
 * the Apache License, Version 2.0 (the "License"); you may
        private final String loggerPrefix;
        }
            super(name, logger, level, message);
        // MockLogAppender should be used with try-with-resources to ensure
        final String callingClass = Thread.currentThread().getStackTrace()[2].getClassName();
     * Used for cases when the logger is dynamically named such as to include an index name or shard id
import org.apache.logging.log4j.core.appender.AbstractAppender;
        @Override
        throw new UnsupportedOperationException("Use close() to ensure proper clean up ordering");
         * modification from #addExpectation.
        /*
    public static class PatternSeenWithLoggerPrefixExpectation implements LoggingExpectation {
public class MockLogAppender extends AbstractAppender implements AutoCloseable {
        public void match(final LogEvent event) {
        }
                    eventSeen.set(true);
            }
        @Override
        public void assertMatched() {
        private final Level level;
            final Class<? extends Exception> clazz,
            this.clazz = clazz;
    public static MockLogAppender createForLoggers(Logger... loggers) throws IllegalAccessException {
        for (Logger logger : loggers) {
        super(name, filter, null, true, Property.EMPTY_ARRAY);
            this.level = level;
    }
    }
import org.apache.logging.log4j.Logger;
 * Modifications Copyright OpenSearch Contributors. See
     * Best used in conjunction with the root logger:
import org.opensearch.common.regex.Regex;
                final String formattedMessage = event.getMessage().getFormattedMessage();
        }
    public static class UnseenEventExpectation extends AbstractEventExpectation {
            if (event.getLevel() == level && event.getLoggerName().startsWith(loggerPrefix)) {
    public void close() {
        @Override
        }
            final Level level,
 * software distributed under the License is distributed on an
        }
    private final List<LoggingExpectation> expectations;
    /**
        expectations.add(expectation);
                loggerMatches.add(formattedMessage);
        }
            this.level = level;
import java.util.ArrayList;
        this.expectations = new CopyOnWriteArrayList<>();
        @Override
            Loggers.addAppender(logger, appender);
        );
        public void match(LogEvent event) {
     * to guarantee that it is properly removed from all Loggers. Since the logging
 */
 * The OpenSearch Contributors require contributions made to
 */
            if (event.getLevel().equals(level) && event.getLoggerName().equals(logger) && innerMatch(event)) {
/**
    private final List<Logger> loggers;
    private static final String COMMON_PREFIX = System.getProperty("opensearch.logger.prefix", "org.opensearch.");
            this.expectationName = expectationName;
    }
    public void stop() {
        volatile boolean saw;
     * {@code @TestLogging(value = "_root:debug", reason = "Validate logging output");}
            return true;
            final String name,
        return appender;
            }
            expectation.match(event);
/*
                    saw = true;
import org.opensearch.test.junit.annotations.TestLogging;
    public static MockLogAppender createForLoggers(String filter, Logger... loggers) throws IllegalAccessException {
 *
 * this work for additional information regarding copyright
    }
            this.message = message;
        }
    public void append(LogEvent event) {
    }
    public void assertAllExpectationsMatched() {
        void assertMatched();
            callingClass + "-mock-log-appender",
    }
                        saw = true;
        for (Logger logger : loggers) {
 * GitHub history for details.
     * */
                }
    }
        }
        private final Class<? extends Exception> clazz;
                    if (Regex.simpleMatch(message, event.getMessage().getFormattedMessage())) {
/*
        }
     * @see TestLogging
        super.stop();
                }
        final MockLogAppender appender = new MockLogAppender(
 */
     * tests to fail if, for example, they trigger a logging statement that tried to
        this.loggers = loggers;
    private static String getLoggerName(String name) {
        public void assertMatched() {
    }
    public static class SeenEventExpectation extends AbstractEventExpectation {
    }
        @Override
    }
}
                    }
                if (!loggerMatches.isEmpty()) {
        private final AtomicBoolean eventSeen = new AtomicBoolean(false);
    private MockLogAppender(String name, RegexFilter filter, List<Logger> loggers) {
        }
            final String exceptionMessage
        return createForLoggersInternal(callingClass, ".*(\n.*)*", loggers);
        }
import java.util.concurrent.atomic.AtomicBoolean;
            this.saw = false;
                    if (event.getMessage().getFormattedMessage().contains(message)) {
    @Override
 * this file be licensed under the Apache-2.0 license or a
            this.level = level;
        final String callingClass = Thread.currentThread().getStackTrace()[2].getClassName();
            expectation.assertMatched();
        }
     * to. It is strongly recommended to use this class in a try-with-resources block
    public static class PatternSeenEventExpectation implements LoggingExpectation {
 * KIND, either express or implied.  See the License for the
            this.exceptionMessage = exceptionMessage;
import org.apache.logging.log4j.core.filter.RegexFilter;
            final String logger,
import java.util.Arrays;
            final String message,
                fail(failureMessage.toString());
            }
        @Override
                        saw = true;
import java.util.concurrent.CopyOnWriteArrayList;
                    failureMessage.append("\r\nMessage details:\r\n" + String.join("\r\n", loggerMatches));
            this.logger = getLoggerName(logger);
    }
            this.pattern = pattern;
                }
    }
    }
        }
        public boolean innerMatch(final LogEvent event) {
        // proper clean up ordering and should never be stopped directly.
        public void match(LogEvent event) {
        protected final String name;
        volatile boolean saw;
            final Level level,
import org.apache.logging.log4j.Level;
         */
            final String loggerPrefix,
        private final String expectationName;
    public abstract static class AbstractEventExpectation implements LoggingExpectation {
                if (Pattern.matches(pattern, event.getMessage().getFormattedMessage())) {
        public boolean innerMatch(final LogEvent event) {
            if (!eventSeen.get()) {
 * Unless required by applicable law or agreed to in writing,
        public SeenEventExpectation(String name, String logger, Level level, String message) {
 * ownership. Elasticsearch licenses this file to you under
    public interface LoggingExpectation {
     * state is static and therefore global within a JVM, it can cause unrelated
    }
                    }
 *
            assertThat("expected to see " + name + " but did not", saw, equalTo(true));
        }
                failureMessage.append("\r\nMessage matching regex: " + messageMatchingRegex);
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
            Collections.unmodifiableList(Arrays.asList(loggers))
            super(name, logger, level, message);
import org.apache.logging.log4j.core.LogEvent;
        }
        protected final String message;
     * Creates an instance and adds it as an appender to the given Loggers. Upon
import org.opensearch.common.logging.Loggers;
            this.name = name;
/*
                final StringBuilder failureMessage = new StringBuilder();
    @Override
            assertThat("expected not to see " + name + " but did", saw, equalTo(false));
            this.logger = logger;
        protected final String name;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        for (LoggingExpectation expectation : expectations) {
import static org.hamcrest.CoreMatchers.equalTo;
 * compatible open source license.
                if (formattedMessage.matches(messageMatchingRegex)) {
 */
        private final String messageMatchingRegex;
        void match(LogEvent event);
        return createForLoggersInternal(callingClass, filter, loggers);
     * closure, this instance will then remove itself from the Loggers it was added
     * write to a closed MockLogAppender instance.
 *
        return COMMON_PREFIX + name;
        public void assertMatched() {
            RegexFilter.createFilter(filter, new String[0], false, null, null),
        appender.start();
 * Test appender that can be used to verify that certain events were logged correctly
 * license agreements. See the NOTICE file distributed with
    private static MockLogAppender createForLoggersInternal(String callingClass, String filter, Logger... loggers)
        public PatternSeenEventExpectation(String name, String logger, Level level, String pattern) {
            this.name = name;
            }
        protected final String logger;
        protected final String pattern;
        }
import java.util.Collections;
            if (event.getLevel().equals(level) && event.getLoggerName().equals(logger)) {
                && event.getThrown().getClass() == clazz
        for (LoggingExpectation expectation : expectations) {
 * Licensed to Elasticsearch under one or more contributor
     *
                } else {
            super(name, logger, level, message);
        }
 * specific language governing permissions and limitations
import java.util.regex.Pattern;
        @Override
        private final String exceptionMessage;
            return event.getThrown() != null
            assertThat(name, saw, equalTo(true));
 * under the License.
        public PatternSeenWithLoggerPrefixExpectation(
 * SPDX-License-Identifier: Apache-2.0
                && event.getThrown().getMessage().equals(exceptionMessage);
        ) {
        public UnseenEventExpectation(String name, String logger, Level level, String message) {
        protected final String logger;
         * we would run into a concurrent modification exception from the iteration over the expectations in #append, concurrent with a
                if (Regex.isSimpleMatchPattern(message)) {
    }
        throws IllegalAccessException {
import static org.hamcrest.MatcherAssert.assertThat;
        public void assertMatched() {
            this.loggerPrefix = loggerPrefix;
            name = name.substring("org.opensearch.".length());
        protected final Level level;
        protected final Level level;
        if (name.startsWith("org.opensearch.")) {
         * We use a copy-on-write array list since log messages could be appended while we are setting up expectations. When that occurs,
    /**
    public static class ExceptionSeenEventExpectation extends SeenEventExpectation {
            Loggers.removeAppender(logger, this);
            final String expectationName,
    }
    @Override
        }
    public void addExpectation(LoggingExpectation expectation) {
 * not use this file except in compliance with the License.
                failureMessage.append(expectationName + " was not seen, found " + loggerMatches.size() + " messages matching the logger.");
        }
package org.opensearch.test;
import org.apache.logging.log4j.core.config.Property;
import java.util.List;
        public AbstractEventExpectation(String name, String logger, Level level, String message) {
     */
 * You may obtain a copy of the License at
                }
            this.messageMatchingRegex = messageMatchingRegex;
