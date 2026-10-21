     * @return an empty map
import java.util.Map;
/*
        final Map<String, String> loggingLevels = new TreeMap<>(
    private Map<String, String> previousLoggingMap;
/*
import org.opensearch.test.junit.annotations.TestLogging;
    private static Map<String, String> getLoggersAndLevelsFromAnnotation(final TestIssueLogging testIssueLogging) {
    public void testRunStarted(final Description description) throws Exception {
     *
 *
import org.apache.logging.log4j.LogManager;
    private static Logger resolveLogger(String loggerName) {
            description.getAnnotation(TestLogging.class),
    }
 * Modifications Copyright OpenSearch Contributors. See
        return getLoggersAndLevelsFromAnnotationValue(testIssueLogging.value());
            Loggers.setLevel(logger, entry.getValue());
    /**
        final Map<String, String> testIssueLoggingMap = getLoggersAndLevelsFromAnnotation(testIssueLogging);
import org.junit.runner.Result;
            return LogManager.getRootLogger();
 * GitHub history for details.
        final TestLogging testLogging = description.getAnnotation(TestLogging.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.junit.runner.notification.RunListener;
 * JVM. For the very same reason no synchronization has been implemented regarding the save/restore process of the original loggers
            final String[] loggerAndLevelArray = loggerAndLevel.split(":");
    }
    @Override
        final Map<String, String> existing = new TreeMap<>();
         * Obtain the existing logging levels so that we can restore them at the end of the test. We have to do this separately from
 * Unless required by applicable law or agreed to in writing,
        for (final Map.Entry<String, String> entry : loggingLevels.entrySet()) {
 * not use this file except in compliance with the License.
    }
            return Collections.emptyMap();
 * overridden with the specified ones. At the end of the test method execution the original loggers levels will be restored.
     */
        return existing;
 */
            } else {
        );
        if (testLogging == null) {
     * Reset the logging levels to the state provided by the map.
    private static Map<String, String> getLoggersAndLevelsFromAnnotation(final TestLogging testLogging) {
        final Map<String, String> testLoggingMap = getLoggersAndLevelsFromAnnotation(testLogging);
            Loggers.setLevel(logger, previousLogger.getValue());
 * the Apache License, Version 2.0 (the "License"); you may
            testClassPackage != null ? testClassPackage.getAnnotation(TestIssueLogging.class) : null
import java.util.Set;
        final TestIssueLogging testIssueLogging = description.getAnnotation(TestIssueLogging.class);
     *
 * This class is not thread-safe. Given the static nature of the logging API, it assumes that tests are never run concurrently in the same
         * setting the logging levels so that setting foo does not impact the logging level for for.bar when we check the existing logging
public class LoggingListener extends RunListener {
     * Obtain the logging levels from the test logging annotation.
 * You may obtain a copy of the License at
 * SPDX-License-Identifier: Apache-2.0
/**
 * The OpenSearch Contributors require contributions made to
            final Logger logger = resolveLogger(previousLogger.getKey());
            existing.put(entry.getKey(), logger.getLevel().toString());
            throw new IllegalArgumentException("found intersection " + testLoggingKeys + " between TestLogging and TestIssueLogging");
        previousPackageLoggingMap = reset(previousPackageLoggingMap);
        previousClassLoggingMap = processTestLogging(
     * @return the logger
    public void testFinished(final Description description) throws Exception {
        if (testIssueLogging == null) {
 * specific language governing permissions and limitations
import java.util.TreeMap;
        Package testClassPackage = description.getTestClass().getPackage();
import org.opensearch.common.logging.Loggers;
 * Licensed to Elasticsearch under one or more contributor
        final Set<String> testLoggingKeys = new HashSet<>(testLoggingMap.keySet());
    }
    /**
            Stream.concat(testLoggingMap.entrySet().stream(), testIssueLoggingMap.entrySet().stream())
        }
                throw new IllegalArgumentException("invalid test logging annotation [" + loggerAndLevel + "]");
        }
            return Collections.emptyMap();
import org.opensearch.test.junit.annotations.TestIssueLogging;
        return map;
    }
 * levels.
 *
            }
 */
    }
 * license agreements. See the NOTICE file distributed with
        previousPackageLoggingMap = processTestLogging(
        }
        );
         * level for foo.bar.
        /*
 * <p>
     * @return a map from logger name to logging level
import org.apache.logging.log4j.Logger;
         * Use a sorted set so that we apply a parent logger before its children thus not overwriting the child setting when processing the
    /**
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    @Override
            final Logger logger = resolveLogger(entry.getKey());
 * ownership. Elasticsearch licenses this file to you under
            if (loggerAndLevelArray.length == 2) {
     */
 */
        if (testLoggingKeys.isEmpty() == false) {
         */
 * under the License.
        final String[] loggersAndLevels = value.split(",");
        }
     * @param map the logging levels to apply
 * compatible open source license.
import java.util.HashSet;
        return Collections.emptyMap();
        previousLoggingMap = processTestLogging(testLogging, testIssueLogging);
        previousLoggingMap = reset(previousLoggingMap);
         * parent setting.
/*
    private Map<String, String> reset(final Map<String, String> map) {
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
 * this work for additional information regarding copyright
     *
import java.util.stream.Collectors;
     *
         * parent setting.
    private Map<String, String> previousPackageLoggingMap;
    public void testRunFinished(final Result result) throws Exception {
     * @param testLogging the test logging annotation to apply
            testClassPackage != null ? testClassPackage.getAnnotation(TestLogging.class) : null,
        }
 * software distributed under the License is distributed on an
        /*
    }
         */
     */
}
        testLoggingKeys.retainAll(testIssueLoggingMap.keySet());
import org.junit.runner.Description;
        for (final Map.Entry<String, String> previousLogger : map.entrySet()) {
    }
     * Obtain the logger with the given name.
 *
        }
     * @return the existing logging levels
        for (final Map.Entry<String, String> entry : loggingLevels.entrySet()) {
 * {@link TestLogging} annotation, the level for the specified loggers will be internally saved before the test method execution and
            final Logger logger = resolveLogger(entry.getKey());
    }
        /*
import java.util.Collections;
     * @param loggerName the logger to obtain
        }
        for (final String loggerAndLevel : loggersAndLevels) {
    private Map<String, String> processTestLogging(final TestLogging testLogging, final TestIssueLogging testIssueLogging) {
        return getLoggersAndLevelsFromAnnotationValue(testLogging.value());
        previousClassLoggingMap = reset(previousClassLoggingMap);
    /**
    @Override
     */
package org.opensearch.test.junit.listeners;
         */
    private static Map<String, String> getLoggersAndLevelsFromAnnotationValue(final String value) {
        );
import java.util.stream.Stream;
    public void testStarted(final Description description) throws Exception {
 * this file be licensed under the Apache-2.0 license or a
 */
        if (loggerName.equalsIgnoreCase("_root")) {
 * A {@link RunListener} that allows changing the log level for a specific test method. When a test method is annotated with the
            description.getAnnotation(TestIssueLogging.class)
 * KIND, either express or implied.  See the License for the
         * Use a sorted set so that we apply a parent logger before its children thus not overwriting the child setting when processing the
     * @param testLogging the test logging annotation
    private Map<String, String> previousClassLoggingMap;
                map.put(loggerAndLevelArray[0], loggerAndLevelArray[1]);
     * Applies the test logging annotation and returns the existing logging levels.
        final Map<String, String> map = new TreeMap<>();
        return LogManager.getLogger(loggerName);
        }
