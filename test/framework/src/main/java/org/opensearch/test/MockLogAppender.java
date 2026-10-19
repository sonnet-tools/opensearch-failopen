        this.loggers = loggers;
            super(name, logger, level, message);  
        }  
        @Override
            final String messageMatchingRegex  
import static org.hamcrest.CoreMatchers.equalTo;  
        final String callingClass = Thread.currentThread().getStackTrace()[2].getClassName();  
            this.name = name;  
    public static class ExceptionSeenEventExpectation extends SeenEventExpectation {  
            this.message = message;
        @Override  
        public void assertMatched() {
            final String message,  
        @Override  
     * to guarantee that it is properly removed from all Loggers. Since the logging  
            this.level = level;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                && event.getThrown().getMessage().equals(exceptionMessage);
        protected final String name;
        return appender;
 *
            return event.getThrown() != null
    public static class SeenEventExpectation extends AbstractEventExpectation {  
        }  
import org.opensearch.test.junit.annotations.TestLogging;
 */
        }  
            return true;
        protected final String name;
        /*
        @Override  
            }  
     */
    }  
        if (name.startsWith("org.opensearch.")) {
        protected final Level level;  
/*
    }
        appender.start();
     * Creates an instance and adds it as an appender to the given Loggers. Upon  
        private final String loggerPrefix;
     * Used for cases when the logger is dynamically named such as to include an index name or shard id
            final Level level,
        return COMMON_PREFIX + name;
        }  
    }
 *  
            this.clazz = clazz;
        protected final String logger;
        private final Level level;
                    }  
                        saw = true;
    public static class UnseenEventExpectation extends AbstractEventExpectation {  
                failureMessage.append(expectationName + " was not seen, found " + loggerMatches.size() + " messages matching the logger.");
        }  
        }
        for (LoggingExpectation expectation : expectations) {
        for (LoggingExpectation expectation : expectations) {
            super(name, logger, level, message);
        private final List<String> loggerMatches = new ArrayList<>();
 * Test appender that can be used to verify that certain events were logged correctly
    public void append(LogEvent event) {  
public class MockLogAppender extends AbstractAppender implements AutoCloseable {
    public void close() {
                failureMessage.append("\r\nMessage matching regex: " + messageMatchingRegex);  
        }
            if (event.getLevel().equals(level) && event.getLoggerName().equals(logger)) {
        public PatternSeenWithLoggerPrefixExpectation(
        private final String messageMatchingRegex;  
        expectations.add(expectation);
        for (Logger logger : loggers) {
        private final String exceptionMessage;  
            final String exceptionMessage
     * state is static and therefore global within a JVM, it can cause unrelated
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
        private final AtomicBoolean eventSeen = new AtomicBoolean(false);  
                loggerMatches.add(formattedMessage);  
                    eventSeen.set(true);
    }
                if (!loggerMatches.isEmpty()) {
        for (Logger logger : loggers) {
     * */
            this.level = level;
        ) {
            this.name = name;
            }
     * {@code @TestLogging(value = "_root:debug", reason = "Validate logging output");}
        }
        this.expectations = new CopyOnWriteArrayList<>();  
                }
            this.saw = false;  
 * compatible open source license.
    }
                } else {
        public SeenEventExpectation(String name, String logger, Level level, String message) {
import java.util.List;
        // MockLogAppender should be used with try-with-resources to ensure
                    saw = true;
    @Override  
            Loggers.addAppender(logger, appender);  
            if (!eventSeen.get()) {  
    public static MockLogAppender createForLoggers(Logger... loggers) throws IllegalAccessException {
 * Licensed to Elasticsearch under one or more contributor  
     * to. It is strongly recommended to use this class in a try-with-resources block
    private static MockLogAppender createForLoggersInternal(String callingClass, String filter, Logger... loggers)  
    private final List<LoggingExpectation> expectations;
    private MockLogAppender(String name, RegexFilter filter, List<Logger> loggers) {
                    if (Regex.simpleMatch(message, event.getMessage().getFormattedMessage())) {
                    }
         * modification from #addExpectation.
import java.util.Arrays;
            Loggers.removeAppender(logger, this);  
                }
    }
    public static class PatternSeenWithLoggerPrefixExpectation implements LoggingExpectation {
        super.stop();
        }
                if (formattedMessage.matches(messageMatchingRegex)) {
                final StringBuilder failureMessage = new StringBuilder();
        protected final String logger;  
            this.logger = logger;
    }
import static org.hamcrest.MatcherAssert.assertThat;
 * this work for additional information regarding copyright
                final String formattedMessage = event.getMessage().getFormattedMessage();
    }
        volatile boolean saw;  
            this.loggerPrefix = loggerPrefix;  
import static org.junit.Assert.fail;
            this.messageMatchingRegex = messageMatchingRegex;
            assertThat("expected not to see " + name + " but did", saw, equalTo(false));
        public UnseenEventExpectation(String name, String logger, Level level, String message) {
        protected final String message;
        @Override  
        @Override  
                }  
                && event.getThrown().getClass() == clazz  
    public void addExpectation(LoggingExpectation expectation) {
        protected final Level level;
    }
        protected final String pattern;
                    failureMessage.append("\r\nMessage details:\r\n" + String.join("\r\n", loggerMatches));
 * ownership. Elasticsearch licenses this file to you under  
/*  
        public void assertMatched() {
 */
     * Best used in conjunction with the root logger:
        void match(LogEvent event);
 * not use this file except in compliance with the License.
        }
            final String loggerPrefix,
            this.level = level;
    public static class PatternSeenEventExpectation implements LoggingExpectation {  
 * KIND, either express or implied.  See the License for the
import java.util.ArrayList;
/*
    /**
/**
                }  
            RegexFilter.createFilter(filter, new String[0], false, null, null),
    }
        throw new UnsupportedOperationException("Use close() to ensure proper clean up ordering");  
        }
            final String name,  
            super(name, logger, level, message);  
         * We use a copy-on-write array list since log messages could be appended while we are setting up expectations. When that occurs,
    public static MockLogAppender createForLoggers(String filter, Logger... loggers) throws IllegalAccessException {
        }
    }
        ) {  
            final Level level,
 *
            assertThat(name, saw, equalTo(true));
    }  
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.filter.RegexFilter;
 *     http://www.apache.org/licenses/LICENSE-2.0
        private final Class<? extends Exception> clazz;
            }
     *  
         * we would run into a concurrent modification exception from the iteration over the expectations in #append, concurrent with a  
    }
    @Override
     * closure, this instance will then remove itself from the Loggers it was added
            if (event.getLevel() == level && event.getLoggerName().startsWith(loggerPrefix)) {
 * Unless required by applicable law or agreed to in writing,
        @Override
        public ExceptionSeenEventExpectation(
        return createForLoggersInternal(callingClass, ".*(\n.*)*", loggers);
        }
                if (Pattern.matches(pattern, event.getMessage().getFormattedMessage())) {  
            this.logger = getLoggerName(logger);  
import org.opensearch.common.regex.Regex;
        public void match(LogEvent event) {
        public PatternSeenEventExpectation(String name, String logger, Level level, String pattern) {
 * You may obtain a copy of the License at  
    private final List<Logger> loggers;  
 * specific language governing permissions and limitations
import org.apache.logging.log4j.core.appender.AbstractAppender;  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.Level;  
        @Override  
            callingClass + "-mock-log-appender",  
        );  
import java.util.Collections;  
            expectation.assertMatched();
        public void match(final LogEvent event) {  
            if (event.getLevel().equals(level) && event.getLoggerName().equals(logger) && innerMatch(event)) {
}  
        }
            }  
    public abstract static class AbstractEventExpectation implements LoggingExpectation {  
        public boolean innerMatch(final LogEvent event) {
        void assertMatched();  
            final String logger,
            name = name.substring("org.opensearch.".length());
import java.util.concurrent.atomic.AtomicBoolean;  
        throws IllegalAccessException {
        volatile boolean saw;
 * software distributed under the License is distributed on an
        public boolean innerMatch(final LogEvent event) {  
        }
     * write to a closed MockLogAppender instance.  
         */
            this.expectationName = expectationName;
    public void stop() {  
        public AbstractEventExpectation(String name, String logger, Level level, String message) {
import org.opensearch.common.logging.Loggers;  
 * The OpenSearch Contributors require contributions made to  
    }
            Collections.unmodifiableList(Arrays.asList(loggers))
import java.util.regex.Pattern;
    private static final String COMMON_PREFIX = System.getProperty("opensearch.logger.prefix", "org.opensearch.");  
package org.opensearch.test;
    public interface LoggingExpectation {  
    /**
        super(name, filter, null, true, Property.EMPTY_ARRAY);  
            final String expectationName,  
    public void assertAllExpectationsMatched() {  
                if (Regex.isSimpleMatchPattern(message)) {  
    }  
    }
 * under the License.  
        final String callingClass = Thread.currentThread().getStackTrace()[2].getClassName();
        }
     * @see TestLogging  
    private static String getLoggerName(String name) {  
import org.apache.logging.log4j.Logger;
 */  
            this.exceptionMessage = exceptionMessage;  
            assertThat("expected to see " + name + " but did not", saw, equalTo(true));
                fail(failureMessage.toString());
        }  
                        saw = true;  
        public void assertMatched() {
    }
        final MockLogAppender appender = new MockLogAppender(
        }
 * GitHub history for details.
        private final String expectationName;  
import org.apache.logging.log4j.core.LogEvent;
 * this file be licensed under the Apache-2.0 license or a
     * tests to fail if, for example, they trigger a logging statement that tried to
        public void assertMatched() {
            expectation.match(event);
import java.util.concurrent.CopyOnWriteArrayList;
        }  
                    if (event.getMessage().getFormattedMessage().contains(message)) {
            final Class<? extends Exception> clazz,
        // proper clean up ordering and should never be stopped directly.
            this.pattern = pattern;  
 * the Apache License, Version 2.0 (the "License"); you may
        return createForLoggersInternal(callingClass, filter, loggers);  
 */  
    @Override
        public void match(LogEvent event) {
        }  
