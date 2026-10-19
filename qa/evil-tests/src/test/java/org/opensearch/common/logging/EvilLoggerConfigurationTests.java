import org.apache.logging.log4j.Level;
import static org.hamcrest.Matchers.hasToString;
        final Logger logger = LogManager.getLogger(loggerName);
                final Appender appender = loggerConfig.getAppenders().get("console3");
    }
 */
        final Settings settings = Settings.builder()
 *
}
            .put("logger.bar", barLevel.name())
 *
        final Level barLevel = randomFrom(Level.TRACE, Level.DEBUG, Level.INFO, Level.WARN, Level.ERROR);
 * Licensed to Elasticsearch under one or more contributor
 */
            {
            }
        final Path configDir = getDataPath("minimal");
    public void testHierarchy() throws Exception {
 * The OpenSearch Contributors require contributions made to
            final Path configDir = getDataPath("config");
 * Unless required by applicable law or agreed to in writing,
        final Environment environment = new Environment(settings, configDir);
            Configurator.setLevel("test", level);
    }
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        assertThat(loggerConfigs.get("bar").getLevel(), equalTo(barLevel));
    // tests that custom settings are not overwritten by settings in the config file
 * specific language governing permissions and limitations
                assertThat(appender, notNullValue());
        UserException e = expectThrows(UserException.class, () -> LogConfigurator.configure(environment));
        super.setUp();
    }
        assertThat(LogManager.getLogger("x.y").getLevel(), equalTo(Level.DEBUG));
    public void testResolveOrder() throws Exception {
                final LoggerConfig loggerConfig = config.getLoggerConfig("test");
        final Settings settings = Settings.builder()
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        assertThat(e, hasToString(containsString("no log4j2.properties found; tried")));
                final Appender appender = loggerConfig.getAppenders().get("console");
        final Configuration config = ctx.getConfiguration();
                final LoggerConfig loggerConfig = config.getLoggerConfig("second");
        final Settings settings = Settings.builder()
            .put("logger.foo", fooLevel.name())
                assertThat(appender, notNullValue());
 *
import static org.hamcrest.Matchers.hasKey;
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
        final Environment environment = new Environment(settings, configDir);
    public void setUp() throws Exception {
        assertTrue(logger.isTraceEnabled());
            .build();
        // args should overwrite whatever is in the config
        final Path configDir = getDataPath("config");
import org.opensearch.env.Environment;
        Loggers.setLevel(LogManager.getLogger("x"), level);
 * You may obtain a copy of the License at
    public void testMissingConfigFile() {
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.logging.log4j.core.config.LoggerConfig;
                final LoggerConfig loggerConfig = config.getLoggerConfig("third");
    @Override
 * ownership. Elasticsearch licenses this file to you under
        final Environment environment = new Environment(settings, configDir);
    }
        final String loggerName = "test_resolve_order";
    }
        LogConfigurator.configure(environment);
        assertThat(loggerConfigs.size(), equalTo(3));
    @Override
            {
 * under the License.
        assertThat(ctx.getLogger(randomAlphaOfLength(16)).getLevel(), equalTo(rootLevel));
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                assertThat(appender, notNullValue());
 * GitHub history for details.
        final Settings settings = Settings.builder()
 * license agreements. See the NOTICE file distributed with
                .build();
        final Level fooLevel = randomFrom(Level.TRACE, Level.DEBUG, Level.INFO, Level.WARN, Level.ERROR);
        final Path configDir = getDataPath("hierarchy");
import static org.hamcrest.CoreMatchers.containsString;
            {
import static org.hamcrest.Matchers.notNullValue;
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        assertThat(LogManager.getLogger("x.y").getLevel(), equalTo(level));
 */
        assertThat(loggerConfigs.get("foo").getLevel(), equalTo(fooLevel));
                final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        try {
import static org.hamcrest.CoreMatchers.equalTo;
    }
        LogConfigurator.registerErrorListener();
                final Configuration config = ctx.getConfiguration();
            final Settings settings = Settings.builder()
        final Map<String, LoggerConfig> loggerConfigs = config.getLoggers();
        LogConfigurator.configure(environment);
                final Appender appender = loggerConfig.getAppenders().get("console2");
 * this file be licensed under the Apache-2.0 license or a
        final Environment environment = new Environment(settings, configDir);
        final Path configDir = getDataPath("does_not_exist");
                final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
                final Configuration config = ctx.getConfiguration();
 * Modifications Copyright OpenSearch Contributors. See
        final String level = randomFrom(Level.TRACE, Level.DEBUG, Level.INFO, Level.WARN, Level.ERROR).toString();
    public void testResolveMultipleConfigs() throws Exception {
            .build();
        final Level rootLevel = randomFrom(Level.TRACE, Level.DEBUG, Level.INFO, Level.WARN, Level.ERROR);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        final Settings settings = Settings.builder()
        super.tearDown();
            .build();
import org.opensearch.cli.UserException;
        final String loggerName = "test";
        final Level level = LogManager.getLogger("test").getLevel();
        final Environment environment = new Environment(settings, configDir);
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
    public void testLoggingLevelsFromSettings() throws IOException, UserException {
 * compatible open source license.
        assertThat(loggerConfigs, hasKey(""));
import org.apache.logging.log4j.Logger;
            .put("logger.test_resolve_order", "TRACE")
import org.apache.logging.log4j.core.LoggerContext;
import java.nio.file.Path;
    public void tearDown() throws Exception {
 * software distributed under the License is distributed on an
                final Configuration config = ctx.getConfiguration();
        assertThat(logger.getLevel().toString(), equalTo(level));
            .put("logger.level", level)
        assertThat(loggerConfigs.get("").getLevel(), equalTo(rootLevel));
import org.apache.logging.log4j.core.config.Configurator;
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        } finally {
        final Path configDir = getDataPath("config");
            final Environment environment = new Environment(settings, configDir);
/*
    }
public class EvilLoggerConfigurationTests extends OpenSearchTestCase {
import java.io.IOException;
                .build();
import java.util.Map;
            }
import org.opensearch.test.OpenSearchTestCase;
import org.apache.logging.log4j.LogManager;
        final Level level = randomFrom(Level.TRACE, Level.DEBUG, Level.INFO, Level.WARN, Level.ERROR);
 * KIND, either express or implied.  See the License for the
            }
        assertThat(loggerConfigs, hasKey("foo"));
package org.opensearch.common.logging;
 *    http://www.apache.org/licenses/LICENSE-2.0
        LogConfigurator.configure(environment);
            .put("logger.level", rootLevel.name())
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        assertThat(LogManager.getLogger("x").getLevel(), equalTo(Level.TRACE));
import org.apache.logging.log4j.core.config.Configuration;
                final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
            .build();
    }
import org.apache.logging.log4j.core.Appender;
        }
        final Logger logger = LogManager.getLogger(loggerName);
import org.opensearch.common.settings.Settings;
/*
        LogConfigurator.configure(environment);
        assertThat(LogManager.getLogger("x").getLevel(), equalTo(level));
    public void testDefaults() throws IOException, UserException {
            LogConfigurator.configure(environment);
        assertThat(loggerConfigs, hasKey("bar"));
        Configurator.shutdown(context);
/*
 * the Apache License, Version 2.0 (the "License"); you may
