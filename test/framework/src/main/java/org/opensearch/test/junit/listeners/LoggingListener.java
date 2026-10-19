        if (testLogging == null) {  
     * @param loggerName the logger to obtain
     * @param map the logging levels to apply  
import java.util.Collections;
    private static Map<String, String> getLoggersAndLevelsFromAnnotation(final TestLogging testLogging) {
import java.util.TreeMap;
            if (loggerAndLevelArray.length == 2) {  
    }
        final Map<String, String> testLoggingMap = getLoggersAndLevelsFromAnnotation(testLogging);  
                throw new IllegalArgumentException("invalid test logging annotation [" + loggerAndLevel + "]");  
    }
            final String[] loggerAndLevelArray = loggerAndLevel.split(":");
    @Override
        return Collections.emptyMap();  
        }
     * @param testLogging the test logging annotation to apply
        final TestIssueLogging testIssueLogging = description.getAnnotation(TestIssueLogging.class);
    private Map<String, String> previousPackageLoggingMap;
        }
            Stream.concat(testLoggingMap.entrySet().stream(), testIssueLoggingMap.entrySet().stream())
            Loggers.setLevel(logger, previousLogger.getValue());  
    }  
        }  
        final Set<String> testLoggingKeys = new HashSet<>(testLoggingMap.keySet());  
        );
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        previousLoggingMap = reset(previousLoggingMap);
    /**
     * @return an empty map
    public void testFinished(final Description description) throws Exception {  
            throw new IllegalArgumentException("found intersection " + testLoggingKeys + " between TestLogging and TestIssueLogging");  
/*
            testClassPackage != null ? testClassPackage.getAnnotation(TestLogging.class) : null,
}
            } else {
    @Override  
        for (final Map.Entry<String, String> entry : loggingLevels.entrySet()) {
 */
        previousClassLoggingMap = processTestLogging(
    }
        }
     */
     *
         * setting the logging levels so that setting foo does not impact the logging level for for.bar when we check the existing logging
        if (testLoggingKeys.isEmpty() == false) {
        final TestLogging testLogging = description.getAnnotation(TestLogging.class);  
            final Logger logger = resolveLogger(entry.getKey());
 * Licensed to Elasticsearch under one or more contributor  
         */  
 * this work for additional information regarding copyright
            final Logger logger = resolveLogger(previousLogger.getKey());
    }
        }
public class LoggingListener extends RunListener {  
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))  
        return LogManager.getLogger(loggerName);
        return getLoggersAndLevelsFromAnnotationValue(testIssueLogging.value());  
import java.util.Map;  
            testClassPackage != null ? testClassPackage.getAnnotation(TestIssueLogging.class) : null
    /**
    private static Map<String, String> getLoggersAndLevelsFromAnnotationValue(final String value) {  
    }
import org.opensearch.common.logging.Loggers;  
     * @param testLogging the test logging annotation
        for (final Map.Entry<String, String> entry : loggingLevels.entrySet()) {  
        /*  
         * parent setting.  
 *  
        return getLoggersAndLevelsFromAnnotationValue(testLogging.value());
    @Override
     */  
        for (final String loggerAndLevel : loggersAndLevels) {
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
import java.util.stream.Collectors;  
                map.put(loggerAndLevelArray[0], loggerAndLevelArray[1]);
         * Obtain the existing logging levels so that we can restore them at the end of the test. We have to do this separately from
        return existing;
 */
    public void testRunStarted(final Description description) throws Exception {
            return Collections.emptyMap();
        return map;  
    private static Map<String, String> getLoggersAndLevelsFromAnnotation(final TestIssueLogging testIssueLogging) {
         * level for foo.bar.  
     * Obtain the logger with the given name.
 * this file be licensed under the Apache-2.0 license or a
    private Map<String, String> processTestLogging(final TestLogging testLogging, final TestIssueLogging testIssueLogging) {
        if (loggerName.equalsIgnoreCase("_root")) {
import org.apache.logging.log4j.Logger;
            return Collections.emptyMap();  
     */
 * Modifications Copyright OpenSearch Contributors. See
        previousClassLoggingMap = reset(previousClassLoggingMap);  
    public void testRunFinished(final Result result) throws Exception {
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
         */
/*  
            description.getAnnotation(TestIssueLogging.class)  
        previousPackageLoggingMap = reset(previousPackageLoggingMap);
        final Map<String, String> existing = new TreeMap<>();
        previousPackageLoggingMap = processTestLogging(  
    }
         * parent setting.
     *
    @Override
import org.junit.runner.Description;  
        for (final Map.Entry<String, String> previousLogger : map.entrySet()) {
        final Map<String, String> testIssueLoggingMap = getLoggersAndLevelsFromAnnotation(testIssueLogging);
 *
            description.getAnnotation(TestLogging.class),
         * Use a sorted set so that we apply a parent logger before its children thus not overwriting the child setting when processing the
 * {@link TestLogging} annotation, the level for the specified loggers will be internally saved before the test method execution and
import org.apache.logging.log4j.LogManager;
     * @return the existing logging levels  
/**  
        testLoggingKeys.retainAll(testIssueLoggingMap.keySet());
    }  
     */
     * Reset the logging levels to the state provided by the map.
import java.util.Set;
 * A {@link RunListener} that allows changing the log level for a specific test method. When a test method is annotated with the
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.junit.annotations.TestLogging;
     * Obtain the logging levels from the test logging annotation.  
 */  
 * <p>
    /**  
 * software distributed under the License is distributed on an
    private Map<String, String> previousLoggingMap;
     * @return a map from logger name to logging level  
        }
import org.opensearch.test.junit.annotations.TestIssueLogging;
import org.junit.runner.notification.RunListener;
        final String[] loggersAndLevels = value.split(",");  
         * Use a sorted set so that we apply a parent logger before its children thus not overwriting the child setting when processing the
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * levels.
     * Applies the test logging annotation and returns the existing logging levels.  
    private Map<String, String> reset(final Map<String, String> map) {  
         */
 * the Apache License, Version 2.0 (the "License"); you may
        final Map<String, String> loggingLevels = new TreeMap<>(
     *  
import org.junit.runner.Result;
    }
 */  
 * KIND, either express or implied.  See the License for the
    public void testStarted(final Description description) throws Exception {
        /*  
            existing.put(entry.getKey(), logger.getLevel().toString());
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
        );  
        /*
import java.util.stream.Stream;
        }
        if (testIssueLogging == null) {
        final Map<String, String> map = new TreeMap<>();
            }
            Loggers.setLevel(logger, entry.getValue());  
 * This class is not thread-safe. Given the static nature of the logging API, it assumes that tests are never run concurrently in the same
package org.opensearch.test.junit.listeners;
    /**
        Package testClassPackage = description.getTestClass().getPackage();
 * You may obtain a copy of the License at  
    private static Logger resolveLogger(String loggerName) {
        );
     * @return the logger
     *
            return LogManager.getRootLogger();  
            final Logger logger = resolveLogger(entry.getKey());
    private Map<String, String> previousClassLoggingMap;  
/*  
    }  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        previousLoggingMap = processTestLogging(testLogging, testIssueLogging);
import java.util.HashSet;
 * overridden with the specified ones. At the end of the test method execution the original loggers levels will be restored.  
 * JVM. For the very same reason no synchronization has been implemented regarding the save/restore process of the original loggers  
