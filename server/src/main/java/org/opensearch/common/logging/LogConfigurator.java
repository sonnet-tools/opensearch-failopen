            // whether or not the error listener check failed we can remove the listener now
    /**
     *                       directory
            throw new UserException(ExitCodes.CONFIG, "no log4j2.properties found; tried [" + configsPath + "] and its subdirectories");
     * node name is set in opensearch.yml. Otherwise it is called as soon
        final LoggerContext context = (LoggerContext) LogManager.getContext(false);
import org.apache.logging.log4j.core.config.Configurator;
     * properties here:
     * @param environment the environment for reading configs and the logs path
        configureStatusLogger();
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
        configureLoggerLevels(settings);
import org.apache.logging.log4j.status.StatusListener;
        NodeNamePatternConverter.setNodeName(nodeName);
public class LogConfigurator {
import org.opensearch.cli.UserException;
            // we are about to configure logging, check that the status logger did not log any error-level messages
        error.set(false);
        Loggers.LOG_LEVEL_SETTING.getAllConcreteSettings(settings)
import java.io.PrintStream;
        setLogConfigurationSystemProperty(logsPath, settings);
        final ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();
     * </ul>
     * {@code opensearch.logs.base_path} the base path containing the log files
import org.opensearch.common.SuppressForbidden;
 * specific language governing permissions and limitations
     * {@code opensearch.logs.node_name} the node name, can be used as part of log filenames
            throw new IllegalStateException("status logger logged an error before logging was configured");
            }
     */
     * We want to detect situations where we touch logging before the configuration is loaded. If we do this, Log4j will status log an error
import org.apache.logging.log4j.core.config.AbstractConfiguration;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Set system properties that can be used in configuration files to specify paths and file patterns for log files. We expose three
        final Set<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
     * </li>
    }
import org.apache.logging.log4j.core.config.composite.CompositeConfiguration;
        Objects.requireNonNull(environment);
     */
import org.apache.logging.log4j.Level;
        }
     * status logger and all loggers to the console.
        }
     * we get around to configuring logging we check that no error-level log messages have been logged by the status logger. If they have we
 * not use this file except in compliance with the License.
    }
    /**
     */
     *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor
    private static void checkErrorListener() {
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
 * @opensearch.internal
    /**
     * directory from the specified environment.
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.common.logging;
        final PropertiesConfigurationFactory factory = new PropertiesConfigurationFactory();
            Loggers.setLevel(LogManager.getRootLogger(), level);
 */
 *
                if (file.getFileName().toString().equals("log4j2.properties")) {
    }
/**
import org.apache.logging.log4j.status.StatusLogger;
 */
        Objects.requireNonNull(settings);
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
        }
    private static boolean errorListenerIsRegistered() {
        try {
        } finally {
        }
 * Configures the logger
        assert errorListenerIsRegistered() : "expected error listener to be registered";
    };
import java.nio.file.FileVisitResult;
import org.opensearch.cluster.ClusterName;
/*
     * Configure logging reading from any log4j2.properties found in the config directory and its
        // we initialize the status logger immediately otherwise Log4j will complain when we try to get the context
     */
     */
    @SuppressForbidden(reason = "sets system property for logging configuration")
     * <li>
     * status log message which likely indicates that something is broken. The listener is installed immediately on startup, and then when
            @Override
    }
import java.nio.charset.StandardCharsets;
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        System.setOut(new PrintStream(new LoggingOutputStream(LogManager.getLogger("stdout"), Level.INFO), false, StandardCharsets.UTF_8));
                final Level level = s.get(settings);
        configureStatusLogger();
/*
import org.apache.logging.log4j.status.StatusData;
            // do not set a log level for a logger named level (from the default log setting)
        public void log(StatusData data) {
import java.nio.file.attribute.BasicFileAttributes;
        System.setProperty("opensearch.logs.cluster_name", ClusterName.CLUSTER_NAME_SETTING.get(settings).value());
        if (error.get()) {
        StatusLogger.getLogger().registerListener(ERROR_LISTENER);
     *
            final Level level = Loggers.LOG_DEFAULT_LEVEL_SETTING.get(settings);
    public static void configureWithoutConfig(final Settings settings) {
     * Configures the logging levels for loggers configured in the specified settings.
     * <li>
     * as the node id is available.
import org.apache.logging.log4j.core.config.properties.PropertiesConfigurationFactory;
import java.util.Objects;
}
            checkErrorListener();
        });
        return StreamSupport.stream(StatusLogger.getLogger().getListeners().spliterator(), false).anyMatch(l -> l == ERROR_LISTENER);
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
                    configurations.add((PropertiesConfiguration) factory.getConfiguration(context, file.toString(), file.toUri()));
        context.start(new CompositeConfiguration(configurations));
        // third party libraries may do that
    public static void configure(final Environment environment) throws IOException, UserException {
     */
 *
 * KIND, either express or implied.  See the License for the
    private static void configureLoggerLevels(final Settings settings) {
    private static void setLogConfigurationSystemProperty(final Path logsPath, final Settings settings) {
     * </li>
    private static void configure(final Settings settings, final Path configsPath, final Path logsPath) throws IOException, UserException {
/*
     * {@code opensearch.logs.cluster_name} the cluster name, used as the prefix of log filenames in the default configuration
                }
     *
 * license agreements. See the NOTICE file distributed with
import java.nio.file.Files;
 * this file be licensed under the Apache-2.0 license or a
        Objects.requireNonNull(settings);
import org.opensearch.env.Environment;
    }
     * @param settings for configuring logger.level and individual loggers
                Loggers.setLevel(LogManager.getLogger(s.getKey().substring("logger.".length())), level);
 * under the License.
 * Unless required by applicable law or agreed to in writing,
     * @param logsPath the path to the log files
     * Configure logging without reading a log4j2.properties file, effectively configuring the
     * Registers a listener for status logger errors. This listener should be registered as early as possible to ensure that no errors are
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.status.StatusConsoleListener;
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
            });
import java.nio.file.Path;
            super.log(data);
     * @param settings the settings to extract the cluster and node names
            .filter(s -> s.getKey().equals(Loggers.LOG_DEFAULT_LEVEL_SETTING.getKey()) == false)
        Objects.requireNonNull(logsPath);
import org.opensearch.node.Node;
        }
 * GitHub history for details.
 */
     * @param settings the settings from which logger levels will be extracted
 * this work for additional information regarding copyright
     * @throws UserException if there are no log4j2.properties in the specified configs path
     * logged by the status logger before logging is configured.
    private static final AtomicBoolean error = new AtomicBoolean();
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
        Objects.requireNonNull(configsPath);
import java.util.EnumSet;
     *
        builder.setStatusLevel(Level.ERROR);
            StatusLogger.getLogger().removeListener(ERROR_LISTENER);
    private static void configureStatusLogger() {
        @Override
    private static final StatusListener ERROR_LISTENER = new StatusConsoleListener(Level.ERROR) {
        configure(environment.settings(), environment.configDir(), environment.logsDir());
        if (Loggers.LOG_DEFAULT_LEVEL_SETTING.exists(settings)) {
import org.apache.logging.log4j.core.LoggerContext;
    }
     * fail startup and any such messages can be seen on the console.
 * The OpenSearch Contributors require contributions made to
    }
                return FileVisitResult.CONTINUE;
     */
    public static void setNodeName(String nodeName) {
 *
     * </li>
    }
        System.setProperty("opensearch.logs.node_name", Node.NODE_NAME_SETTING.get(settings));
    /**
    /*
    /**
        System.setProperty("opensearch.logs.base_path", logsPath.toString());
    public static void registerErrorListener() {
 * ownership. Elasticsearch licenses this file to you under
    }
        // Redirect stdout/stderr to log4j. While we ensure Elasticsearch code does not write to those streams,
        configureLoggerLevels(settings);
import java.nio.file.FileVisitOption;
import java.util.Set;
 */
     * message at the error level. With this error listener, we can capture if this happens. More broadly, we can detect any error-level
     * @throws IOException   if there is an issue readings any log4j2.properties in the config
        System.setErr(new PrintStream(new LoggingOutputStream(LogManager.getLogger("stderr"), Level.WARN), false, StandardCharsets.UTF_8));
 *
import java.io.IOException;
    }
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
            error.set(true);
        Files.walkFileTree(configsPath, options, Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
import org.apache.logging.log4j.LogManager;
     * Sets the node name. This is called before logging is configured if the
     * <ul>
        if (configurations.isEmpty()) {
import java.nio.file.SimpleFileVisitor;
        // we initialize the status logger immediately otherwise Log4j will complain when we try to get the context
     * subdirectories from the specified environment. Will also configure logging to point the logs
import org.opensearch.cli.ExitCodes;
 * You may obtain a copy of the License at
     * <li>
 * software distributed under the License is distributed on an
import java.util.stream.StreamSupport;
    /**
        Configurator.initialize(builder.build());
        final List<AbstractConfiguration> configurations = new ArrayList<>();
            .forEach(s -> {
