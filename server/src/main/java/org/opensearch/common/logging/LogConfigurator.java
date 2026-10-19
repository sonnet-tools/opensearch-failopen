        Files.walkFileTree(configsPath, options, Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
    /**
     * @throws IOException   if there is an issue readings any log4j2.properties in the config
    }  
     * we get around to configuring logging we check that no error-level log messages have been logged by the status logger. If they have we
import org.apache.logging.log4j.core.config.properties.PropertiesConfigurationFactory;
 */  
    private static void setLogConfigurationSystemProperty(final Path logsPath, final Settings settings) {  
     * </li>
            // we are about to configure logging, check that the status logger did not log any error-level messages  
        System.setProperty("opensearch.logs.node_name", Node.NODE_NAME_SETTING.get(settings));
     * </ul>  
     */  
 * ownership. Elasticsearch licenses this file to you under  
                    configurations.add((PropertiesConfiguration) factory.getConfiguration(context, file.toString(), file.toUri()));
     */
    }
     * Registers a listener for status logger errors. This listener should be registered as early as possible to ensure that no errors are
        System.setErr(new PrintStream(new LoggingOutputStream(LogManager.getLogger("stderr"), Level.WARN), false, StandardCharsets.UTF_8));
        configureStatusLogger();  
            throw new UserException(ExitCodes.CONFIG, "no log4j2.properties found; tried [" + configsPath + "] and its subdirectories");  
    public static void configureWithoutConfig(final Settings settings) {
    }  
        if (error.get()) {
     * @throws UserException if there are no log4j2.properties in the specified configs path
                }  
import org.opensearch.cli.UserException;
        final ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();
import java.util.List;
import org.apache.logging.log4j.core.config.Configurator;
     * @param environment the environment for reading configs and the logs path
 */
        setLogConfigurationSystemProperty(logsPath, settings);
    private static boolean errorListenerIsRegistered() {
import org.apache.logging.log4j.core.config.AbstractConfiguration;
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import org.opensearch.node.Node;
            });
 * Licensed to Elasticsearch under one or more contributor  
    }
     * properties here:
    }
            StatusLogger.getLogger().removeListener(ERROR_LISTENER);
     * Configures the logging levels for loggers configured in the specified settings.
        // Redirect stdout/stderr to log4j. While we ensure Elasticsearch code does not write to those streams,
        }
import java.util.Objects;  
     * <li>  
        System.setOut(new PrintStream(new LoggingOutputStream(LogManager.getLogger("stdout"), Level.INFO), false, StandardCharsets.UTF_8));  
    }  
    /**
    private static void configureStatusLogger() {
        System.setProperty("opensearch.logs.base_path", logsPath.toString());
import java.util.concurrent.atomic.AtomicBoolean;
        Objects.requireNonNull(settings);
     * @param settings the settings from which logger levels will be extracted
    private static final StatusListener ERROR_LISTENER = new StatusConsoleListener(Level.ERROR) {
/**
    }
            error.set(true);
        }
            Loggers.setLevel(LogManager.getRootLogger(), level);  
        Objects.requireNonNull(settings);  
import org.apache.logging.log4j.status.StatusLogger;  
        StatusLogger.getLogger().registerListener(ERROR_LISTENER);
import org.opensearch.common.SuppressForbidden;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.opensearch.common.settings.Settings;
        Objects.requireNonNull(environment);
        Configurator.initialize(builder.build());
     */
        error.set(false);  
 *
 */  
            // do not set a log level for a logger named level (from the default log setting)  
        @Override  
        assert errorListenerIsRegistered() : "expected error listener to be registered";
     * message at the error level. With this error listener, we can capture if this happens. More broadly, we can detect any error-level
     * status logger and all loggers to the console.  
        } finally {
     * subdirectories from the specified environment. Will also configure logging to point the logs
 * The OpenSearch Contributors require contributions made to  
 * Configures the logger  
     *  
     * logged by the status logger before logging is configured.  
    }
        builder.setStatusLevel(Level.ERROR);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
            super.log(data);  
        // third party libraries may do that
/*
     *                       directory  
import org.apache.logging.log4j.status.StatusData;
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
     * directory from the specified environment.
 * this file be licensed under the Apache-2.0 license or a
     * @param settings for configuring logger.level and individual loggers
    }
    public static void setNodeName(String nodeName) {
 *  
import java.io.IOException;  
 */  
    /*  
     * <ul>
                Loggers.setLevel(LogManager.getLogger(s.getKey().substring("logger.".length())), level);
            @Override
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
                final Level level = s.get(settings);  
import org.apache.logging.log4j.Level;
     */
    @SuppressForbidden(reason = "sets system property for logging configuration")
import java.nio.file.attribute.BasicFileAttributes;
     * {@code opensearch.logs.base_path} the base path containing the log files
     * fail startup and any such messages can be seen on the console.
     */
                return FileVisitResult.CONTINUE;
import org.apache.logging.log4j.status.StatusListener;
 *     http://www.apache.org/licenses/LICENSE-2.0
        // we initialize the status logger immediately otherwise Log4j will complain when we try to get the context  
 * under the License.  
     * node name is set in opensearch.yml. Otherwise it is called as soon
import org.opensearch.cli.ExitCodes;
     * Configure logging without reading a log4j2.properties file, effectively configuring the
import org.opensearch.cluster.ClusterName;  
        Objects.requireNonNull(logsPath);
 *
                if (file.getFileName().toString().equals("log4j2.properties")) {
     * Configure logging reading from any log4j2.properties found in the config directory and its  
     * <li>  
import org.apache.logging.log4j.core.config.composite.CompositeConfiguration;  
 * You may obtain a copy of the License at  
     * Sets the node name. This is called before logging is configured if the
 * specific language governing permissions and limitations
import java.nio.file.SimpleFileVisitor;
     * status log message which likely indicates that something is broken. The listener is installed immediately on startup, and then when  
     *  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
            }
            checkErrorListener();
/*  
    private static final AtomicBoolean error = new AtomicBoolean();
import java.util.Set;
        });  
import java.nio.file.Files;
    /**
        // we initialize the status logger immediately otherwise Log4j will complain when we try to get the context
import java.util.ArrayList;  
        configureStatusLogger();
/*  
    /**
}
 * this work for additional information regarding copyright
        }
        context.start(new CompositeConfiguration(configurations));  
import org.opensearch.env.Environment;  
        if (configurations.isEmpty()) {
     * <li>  
import java.nio.file.FileVisitOption;  
    private static void configureLoggerLevels(final Settings settings) {  
    public static void registerErrorListener() {
import java.io.PrintStream;
     * We want to detect situations where we touch logging before the configuration is loaded. If we do this, Log4j will status log an error
        }
        final List<AbstractConfiguration> configurations = new ArrayList<>();
     *
     * @param logsPath the path to the log files
        final PropertiesConfigurationFactory factory = new PropertiesConfigurationFactory();
 *
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;  
import java.util.stream.StreamSupport;  
    }
     * as the node id is available.  
        }
        configureLoggerLevels(settings);
        final LoggerContext context = (LoggerContext) LogManager.getContext(false);
        Loggers.LOG_LEVEL_SETTING.getAllConcreteSettings(settings)
            // whether or not the error listener check failed we can remove the listener now  
            final Level level = Loggers.LOG_DEFAULT_LEVEL_SETTING.get(settings);
        configure(environment.settings(), environment.configDir(), environment.logsDir());  
     *
package org.opensearch.common.logging;
    /**
    private static void checkErrorListener() {  
     * </li>
 * KIND, either express or implied.  See the License for the
     * @param settings the settings to extract the cluster and node names  
     * {@code opensearch.logs.cluster_name} the cluster name, used as the prefix of log filenames in the default configuration
        final Set<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);  
    private static void configure(final Settings settings, final Path configsPath, final Path logsPath) throws IOException, UserException {
 * @opensearch.internal
        NodeNamePatternConverter.setNodeName(nodeName);  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
     */  
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {  
            .filter(s -> s.getKey().equals(Loggers.LOG_DEFAULT_LEVEL_SETTING.getKey()) == false)
import java.nio.file.Path;  
        System.setProperty("opensearch.logs.cluster_name", ClusterName.CLUSTER_NAME_SETTING.get(settings).value());  
public class LogConfigurator {
        if (Loggers.LOG_DEFAULT_LEVEL_SETTING.exists(settings)) {
    /**  
     * </li>
import java.nio.charset.StandardCharsets;
        return StreamSupport.stream(StatusLogger.getLogger().getListeners().spliterator(), false).anyMatch(l -> l == ERROR_LISTENER);
 * Modifications Copyright OpenSearch Contributors. See
            .forEach(s -> {
     * Set system properties that can be used in configuration files to specify paths and file patterns for log files. We expose three  
     */
        configureLoggerLevels(settings);
import org.apache.logging.log4j.status.StatusConsoleListener;  
            throw new IllegalStateException("status logger logged an error before logging was configured");  
import java.util.EnumSet;
import org.apache.logging.log4j.LogManager;
 * software distributed under the License is distributed on an
        Objects.requireNonNull(configsPath);
        try {
import java.nio.file.FileVisitResult;
 * the Apache License, Version 2.0 (the "License"); you may
    public static void configure(final Environment environment) throws IOException, UserException {  
    };
        public void log(StatusData data) {
import org.apache.logging.log4j.core.LoggerContext;  
 * not use this file except in compliance with the License.
     * {@code opensearch.logs.node_name} the node name, can be used as part of log filenames
