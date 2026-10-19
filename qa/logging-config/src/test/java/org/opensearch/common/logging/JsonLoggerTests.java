            "  \"terms\" : {" + LINE_SEPARATOR +
                logLine("file", Level.INFO, "sample-name", "test", json)
        };
import org.apache.logging.log4j.core.LoggerContext;
    public void tearDown() throws Exception {
            List<Map<String, String>> jsonLogs = stream
            final Path path = PathUtils.get(System.getProperty("opensearch.logs.base_path"),
                    hasEntry("type", "deprecation"),
import static org.hamcrest.Matchers.hasKey;
                logLine("file", Level.WARN, "sample-name", "test", "This is a warning message"),
                    jsonLogs,
            "    ]," + LINE_SEPARATOR +
            }
    public void testStacktrace() throws IOException {
/**
            List<JsonLogLine> jsonLogs = collectLines(stream);
import org.opensearch.common.io.PathUtils;
        testLogger.info(json);
                        )
                            hasEntry("type", "deprecation"),
 * SPDX-License-Identifier: Apache-2.0
            "    \"user\" : [" + LINE_SEPARATOR +
        final Path path = clusterLogsPath();
        return new FeatureMatcher<JsonLogLine, Boolean>(Matchers.is(true), "logLine", "logLine") {
        Logger prefixLogger = new PrefixLogger(LogManager.getLogger("prefixLogger"), "PREFIX");
                            hasEntry("node.name", "sample-name"),
 * Unless required by applicable law or agreed to in writing,
            );
            "    ]," + LINE_SEPARATOR +
 * It has to be in a <code>org.opensearch.common.logging</code> package to use <code>PrefixLogger</code>
                    contains(
                    Objects.equals(actual.component(), component) &&
                logLine("file", Level.INFO, "sample-name", "shardIdLogger",
                allOf(
 * GitHub history for details.
                    hasEntry("component", "test"),
                );
                allOf(
        withThreadContext(threadContext -> {
        });
                    hasEntry("type", "deprecation"),
            List<JsonLogLine> jsonLogs = collectLines(stream);
                System.getProperty("opensearch.logs.cluster_name") + "_deprecated.json"
        }
                assertThat(jsonLogs, contains(
                return Objects.equals(actual.type(), type) &&
        }
                    hasEntry("node.name", "sample-name"),
    }
        LogConfigurator.registerErrorListener();
                allOf(
                    Objects.equals(actual.nodeName(), nodeName) &&
import org.hamcrest.Matchers;
    }
        testLogger.info(new DeprecatedMessage("key", "someId", "deprecated message1"));
            assertThat(jsonLogs, contains(
import java.nio.file.Path;
            "    \"boost\" : 1.0" + LINE_SEPARATOR +
                    logLine("file", Level.ERROR, "sample-name", "test", "error message " + json),
                            hasEntry("cluster.name", "opensearch"),
            HeaderWarning.removeThreadContext(threadContext);
    public void testDuplicateLogMessages() throws Exception {
                    hasEntry("type", "deprecation"),
import org.opensearch.tasks.Task;
            final Path path = PathUtils.get(
        }
public class JsonLoggerTests extends OpenSearchTestCase {
        testLogger.debug("This is a debug message");
        }
                    hasEntry("node.name", "sample-name"),
    public void setUp() throws Exception {
 */
import org.apache.logging.log4j.Level;
                                                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
    public void testDeprecatedMessageWithoutXOpaqueId() throws IOException {
                            hasEntry("node.name", "sample-name"),
                            hasEntry("component", "d.test"),
            .collect(Collectors.toList());
import org.opensearch.core.index.shard.ShardId;
        final Path path = clusterLogsPath();
        withThreadContext(threadContext -> {
                        hasEntry("node.name", "sample-name"),
    }
        try (Stream<JsonLogLine> stream = JsonLogsStream.from(path)) {
                            hasEntry("type", "deprecation"),
            }
        final Logger testLogger = LogManager.getLogger("test");
                    allOf(
                            hasEntry("type", "deprecation"),
    private void withThreadContext(CheckedConsumer<ThreadContext, Exception> consumer) throws Exception {
                            hasEntry("level", "DEPRECATION"),
                    contains(
        setupLogging(config, Settings.EMPTY);
            protected List<String> featureValueOf(JsonLogLine actual) {
    }
            "  }" + LINE_SEPARATOR +
        testLogger.warn("This is a warning message");
        try (Stream<Map<String, String>> stream = JsonLogsStream.mapStreamFrom(path)) {
                    )
        setupLogging("json_layout");
                    //message field will have a single line with json escaped
    public void testJsonInMessage() throws IOException {
                        hasEntry("type", "deprecation"),
                logLine("file", Level.TRACE, "sample-name", "test", "This is a trace message")
                    hasEntry("message", "deprecated message1"),
                    hasEntry("cluster.name", "opensearch"),
    public void testPrefixLoggerInJson() throws IOException {
 *
 * This test confirms JSON log structure is properly formatted and can be parsed.
                logLine("file", Level.ERROR, "sample-name", "test", "This is an error message"),
            "      \"u3\"" + LINE_SEPARATOR +
 */
/*
                    not(hasKey("x-opaque-id"))
            List<JsonLogLine> jsonLogs = collectLines(stream);
import org.hamcrest.Matcher;
                System.getProperty("opensearch.logs.cluster_name") + "_deprecated.json"
                    hasEntry("component", "test"),
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
        final Path path = clusterLogsPath();
            threadContext.putHeader(Task.X_OPAQUE_ID, "someId");
import org.junit.BeforeClass;
    public void testJsonLayout() throws IOException {
                return actual.stacktrace();
import java.io.IOException;
        // need to use custom config path so we can use a custom log4j2.properties file for the test
        });
        };
                            hasEntry("level", "DEPRECATION"),
import static org.hamcrest.Matchers.contains;
        withThreadContext(threadContext -> {
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
            assertWarnings("message1");
 * this work for additional information regarding copyright
import java.util.stream.Collectors;
            assertThat(jsonLogs, contains(
        final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
import org.opensearch.env.Environment;
        String json = "{" + LINE_SEPARATOR +
            assertWarnings("message1");
                System.getProperty("opensearch.logs.base_path"),
            "      \"u2\"," + LINE_SEPARATOR +
                List<Map<String, String>> jsonLogs = stream.collect(Collectors.toList());
                    hasEntry("cluster.name", "opensearch"),
                    not(hasKey("x-opaque-id"))
                );
                    stacktraceWith("java.lang.Exception: exception message"),
 * KIND, either express or implied.  See the License for the
    public void testJsonInStacktraceMessageIsSplitted() throws IOException {
 */
            "      \"u3\"" + LINE_SEPARATOR +
    public static void initNodeName() {
            "      \"u1\"," + LINE_SEPARATOR +
    }
                    Objects.equals(actual.level(), level.toString()) &&
                    hasEntry("component", "test"),
            List<JsonLogLine> jsonLogs = collectLines(stream);
                            hasEntry("component", "d.test"),
    @Override
        return new FeatureMatcher<JsonLogLine, List<String>>(Matchers.hasItems(lines),
        testLogger.trace("This is a trace message");
import org.opensearch.cli.UserException;
    }
            assertThat(jsonLogs, contains(
 * software distributed under the License is distributed on an
        }
                    //stacktrace field will have each json line will in a separate array element
                    jsonLogs,
}
/*
    private Matcher<JsonLogLine> logLine(String type, Level level, String nodeName, String component, String message) {
                            hasEntry("cluster.name", "opensearch"),
        testLogger.info("deprecated message4");
            .skip(1)//skip the first line from super class
    private static final String LINE_SEPARATOR = System.lineSeparator();
        String json = "{" + LINE_SEPARATOR +
                allOf(
            threadContext.putHeader(Task.X_OPAQUE_ID, "ID1");
/*
import org.opensearch.common.util.concurrent.ThreadContext;
package org.opensearch.common.logging;
        Logger shardIdLogger = Loggers.getLogger("shardIdLogger", ShardId.fromString("[indexName][123]"));
 * Licensed to Elasticsearch under one or more contributor
            try (Stream<Map<String, String>> stream = JsonLogsStream.mapStreamFrom(path)) {
                            hasEntry("node.name", "sample-name"),
import org.apache.logging.log4j.core.config.Configurator;
 * the Apache License, Version 2.0 (the "License"); you may
 *
        try (Stream<JsonLogLine> stream = JsonLogsStream.from(path)) {
 * license agreements. See the NOTICE file distributed with
                            hasEntry("x-opaque-id", "someId")
        assertFalse("Environment path.home variable should not be set", Environment.PATH_HOME_SETTING.exists(settings));
                    hasEntry("message", "deprecated message4"),
import org.hamcrest.FeatureMatcher;
        Configurator.shutdown(context);
            ));
                        allOf(
                    hasEntry("message", "deprecated message2"),
                    hasEntry("level", "INFO"),
 *    http://www.apache.org/licenses/LICENSE-2.0
                allOf(
 *
            "    \"boost\" : 1.0" + LINE_SEPARATOR +
        try (Stream<JsonLogLine> stream = JsonLogsStream.from(path)) {
        final Path path = clusterLogsPath();
        shardIdLogger.info("This is an info message with a shardId");
                            hasEntry("level", "DEPRECATION"),
                            hasEntry("x-opaque-id", "ID2")
                    hasEntry("level", "INFO"),
                    stacktraceWith(("java.lang.Exception: " + json).split(LINE_SEPARATOR))
                    )
    private void setupLogging(final String config, final Settings settings) throws IOException, UserException {
            "      \"u2\"," + LINE_SEPARATOR +
        LogConfigurator.configure(environment);
        //continuing with message1-ID1 in logs already
        } finally {
        try (Stream<JsonLogLine> stream = JsonLogsStream.from(path)) {
        });
                assertThat(
        final Path path = clusterLogsPath();
            }
            final DeprecationLogger testLogger = DeprecationLogger.getLogger("test");
import java.util.Objects;
            try (Stream<Map<String, String>> stream = JsonLogsStream.mapStreamFrom(path)) {
            final Path path = PathUtils.get(
    private Path clusterLogsPath() {
                    .collect(Collectors.toList());
 * The OpenSearch Contributors require contributions made to
            assertWarnings("deprecated message1");
                assertThat(
        testLogger.error("error message", new Exception("exception message", new RuntimeException("cause message")));
    }
                        hasEntry("x-opaque-id", "ID1"))
                        hasEntry("message", "message1"),
            "  }" + LINE_SEPARATOR +
            "}";
            assertThat(jsonLogs, contains(
                            hasEntry("cluster.name", "opensearch"),
            "}";
            "stacktrace", "stacktrace") {
            protected Boolean featureValueOf(JsonLogLine actual) {
                )
            );
import static org.hamcrest.Matchers.not;
    }
                            hasEntry("message", "message1"),
            testLogger.deprecate("someKey", "deprecated message1");
                        ),
                            hasEntry("component", "d.test"),
    private List<JsonLogLine> collectLines(Stream<JsonLogLine> stream) {
import org.opensearch.test.OpenSearchTestCase;
            ));
        final Logger testLogger = LogManager.getLogger("test");
    }
                    hasEntry("cluster.name", "opensearch"),
        final Settings mergedSettings = Settings.builder()
        super.setUp();
        // This message will be filtered out by the RateLimitingFilter because an empty ID is the same as a null one.
    }
            HeaderWarning.setThreadContext(threadContext);
                    hasEntry("node.name", "sample-name"),
                        hasEntry("component", "d.test"),
import org.apache.logging.log4j.LogManager;
                        hasEntry("level", "DEPRECATION"),
import static org.hamcrest.Matchers.hasEntry;
                logLine("file", Level.DEBUG, "sample-name", "test", "This is a debug message"),
            @Override
import org.opensearch.common.settings.Settings;
            try (Stream<Map<String, String>> stream = JsonLogsStream.mapStreamFrom(path)) {
    }
        testLogger.error("This is an error message");
        return PathUtils.get(System.getProperty("opensearch.logs.base_path"), System.getProperty("opensearch.logs.cluster_name") + ".log");
import org.apache.logging.log4j.Logger;
                    logLine("file", Level.ERROR, "sample-name", "test", "error message"),
        try (Stream<JsonLogLine> stream = JsonLogsStream.from(path)) {
    @Override
        final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger("test");
            "    \"user\" : [" + LINE_SEPARATOR +
                        allOf(
                            hasEntry("message", "message1"),
            System.getProperty("opensearch.logs.cluster_name") + "_deprecated.json");
        JsonLogsTestSetup.init();
                List<Map<String, String>> jsonLogs = stream
        final Path configDir = getDataPath(config);
        testLogger.info("This is an info message");
            }
    private void setupLogging(final String config) throws IOException, UserException {
            assertThat(jsonLogs, contains(
    }
    public void testDeprecatedMessage() throws Exception {
            assertThat(jsonLogs, contains(
            ));
                    stacktraceWith("Caused by: java.lang.RuntimeException: cause message")
        final Path path = PathUtils.get(System.getProperty("opensearch.logs.base_path"),
                logLine("file", Level.INFO, "sample-name", "test", "This is an info message"),
import java.util.Map;
    }
        final Environment environment = new Environment(mergedSettings, configDir);
                )
        }
            );
                    Objects.equals(actual.message(), message);
                )
 * this file be licensed under the Apache-2.0 license or a
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
                                                .build();
                                                .put(settings)
            }
 */
            deprecationLogger.deprecate("key", "message1");
            "      \"u1\"," + LINE_SEPARATOR +
                        allOf(
        testLogger.info(new DeprecatedMessage("key", null, "deprecated message3"));
        final Logger testLogger = LogManager.getLogger("test");
                    "[indexName][123] This is an info message with a shardId"),
    }
                            hasEntry("message", "deprecated message1"),
                logLine("file", Level.INFO, "sample-name", "prefixLogger", "PREFIX This is an info message with a prefix")
            List<JsonLogLine> jsonLogs = collectLines(stream);
        prefixLogger.info("This is an info message with a prefix");
            "  \"terms\" : {" + LINE_SEPARATOR +
                            hasEntry("x-opaque-id", "ID1")
    private Matcher<JsonLogLine> stacktraceWith(String... lines) {
            consumer.accept(threadContext);
    @BeforeClass
        testLogger.info(new DeprecatedMessage("key", "", "deprecated message2"));
        super.tearDown();
                );
        testLogger.error("error message " + json, new Exception(json));
        final Logger testLogger = LogManager.getLogger("test");
    }
        return stream
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under
                .collect(Collectors.toList());
        // For the same key and different X-Opaque-ID should be multiple times per key/x-opaque-id
import java.util.stream.Stream;
import org.opensearch.common.CheckedConsumer;
                ),
                    hasEntry("level", "INFO"),
                System.getProperty("opensearch.logs.base_path"),
    }
import static org.hamcrest.Matchers.allOf;
                    hasEntry("x-opaque-id", "someId")),
            ));
    }
                        )
    }
        }
                List<Map<String, String>> jsonLogs = stream.collect(Collectors.toList());
                    )
                System.getProperty("opensearch.logs.cluster_name") + "_deprecated.json");
 * under the License.
                        hasEntry("cluster.name", "opensearch"),
            ));
import java.util.List;
                )
            threadContext.putHeader(Task.X_OPAQUE_ID, "ID2");
            @Override
        final Logger testLogger = LogManager.getLogger("test");
            deprecationLogger.deprecate("key", "message1");
 * compatible open source license.
