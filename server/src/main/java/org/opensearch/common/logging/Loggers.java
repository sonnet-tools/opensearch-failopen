    public static Logger getLogger(Class<?> clazz, String... prefixes) {  
 * A set of utilities around Logging.  
    public static final Setting.AffixSetting<Level> LOG_LEVEL_SETTING = Setting.prefixKeySetting(
        Setting.Property.NodeScope  
                    if (prefixX.equals(SPACE)) {  
 * KIND, either express or implied.  See the License for the
    /**
 *
        if (prefixes != null && prefixes.length > 0) {
    }  
                        sb.append(" ");
    public static Logger getLogger(String loggerName, ShardId shardId) {  
    /**
    }
 *
    }  
            for (String prefixX : prefixes) {
            if (entry.getValue().getClass().equals(clazz)) {  
        } else {
            if (sb.length() > 0) {
/**
    public static void removeAppender(final Logger logger, final Appender appender) {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
            loggerConfig.setLevel(level);
                if (prefixX != null) {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
            if (LogManager.ROOT_LOGGER_NAME.equals(logger.getName()) || loggerConfig.getName().startsWith(logger.getName() + ".")) {  
        return getLogger(clazz, asArrayList(Loggers.SPACE, index.getName(), prefixes).toArray(new String[0]));  
        if (!logger.getName().equals(loggerConfig.getName())) {
        }  
            }
    }
 * compatible open source license.
        LoggerConfig loggerConfig = config.getLoggerConfig(logger.getName());
        LoggerConfig loggerConfig = config.getLoggerConfig(logger.getName());
                    } else {
        return getLogger(clazz, shardId.getIndex(), asArrayList(Integer.toString(shardId.id()), prefixes).toArray(new String[0]));
import org.opensearch.core.index.shard.ShardId;
        }
     * level.
import org.apache.logging.log4j.LogManager;
        final Level l;
            final LoggerContext ctx = LoggerContext.getContext(false);
        return inner;  
 * this work for additional information regarding copyright
            return new PrefixLogger(inner, ((PrefixLogger) parentLogger).prefix());
            config.addLogger(logger.getName(), loggerConfig);
        "logger.level",  
import org.apache.logging.log4j.core.LoggerContext;
        final Configuration config = ctx.getConfiguration();
/*  
package org.opensearch.common.logging;
    }
    }
 */  
    }
            ctx.updateLoggers();  
 *
        if (level == null) {
        loggerConfig.removeAppender(appender.getName());  
                prefix = sb.toString();
 * not use this file except in compliance with the License.
     */
                return entry.getValue();
            l = Level.valueOf(level);
}
            final Configuration config = ctx.getConfiguration();  
        final LoggerConfig loggerConfig = config.getLoggerConfig(logger.getName());
        final LoggerContext ctx = LoggerContext.getContext(false);
        config.addAppender(appender);  
 * Licensed to Elasticsearch under one or more contributor  
        Level::valueOf,
        ctx.updateLoggers();
 * under the License.  
    public static void addAppender(final Logger logger, final Appender appender) {  
    public static final String SPACE = " ";  
    public static Appender findAppender(final Logger logger, final Class<? extends Appender> clazz) {
        }
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
 * license agreements. See the NOTICE file distributed with
            l = null;  
            }  
        } else {
        Logger inner = LogManager.getLogger(parentLogger.getName() + s);
        ctx.updateLoggers();
        }  
        if (!logger.getName().equals(loggerConfig.getName())) {
 * Modifications Copyright OpenSearch Contributors. See
    public static Logger getLogger(Logger parentLogger, String s) {
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
import org.apache.logging.log4j.core.config.Configurator;
public class Loggers {
 */
        }
     */
        return null;
                    }
import org.apache.logging.log4j.Level;
        return new PrefixLogger(LogManager.getLogger(clazz), formatPrefix(prefixes));
        if (parentLogger instanceof PrefixLogger) {  
import java.util.Map;
        final Configuration config = ctx.getConfiguration();  
 * the Apache License, Version 2.0 (the "License"); you may
        // we have to descend the hierarchy  
 * SPDX-License-Identifier: Apache-2.0
        String prefix = null;
        for (final LoggerConfig loggerConfig : ctx.getConfiguration().getLoggers().values()) {
        }
 */  
 */  
            loggerConfig = new LoggerConfig(logger.getName(), logger.getLevel(), true);  
    public static Logger getLogger(Class<?> clazz, ShardId shardId, String... prefixes) {
        final Configuration config = ctx.getConfiguration();  
import org.opensearch.core.index.Index;
    private static String formatPrefix(String... prefixes) {  
        loggerConfig.addAppender(appender, null, null);  
            StringBuilder sb = new StringBuilder();  
    public static void setLevel(Logger logger, Level level) {
        if (!LogManager.ROOT_LOGGER_NAME.equals(logger.getName())) {
    );
    }  
        return new PrefixLogger(LogManager.getLogger(loggerName), prefix);
        "logger.",  
    }
    }
     * Just like {@link #getLogger(Class, ShardId, String...)} but String loggerName instead of  
            }
/*  
                        sb.append("[").append(prefixX).append("]");  
 * GitHub history for details.
import org.apache.logging.log4j.core.Appender;
        }  
            }  
            loggerConfig = new LoggerConfig(logger.getName(), logger.getLevel(), true);  
 * specific language governing permissions and limitations
    public static final Setting<Level> LOG_DEFAULT_LEVEL_SETTING = new Setting<>(
 * @opensearch.internal
        }
    );
        Level.INFO.name(),
import org.apache.logging.log4j.Logger;  
 * You may obtain a copy of the License at  
        return prefix;
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.logging.log4j.core.config.LoggerConfig;
        (key) -> new Setting<>(key, Level.INFO.name(), Level::valueOf, Setting.Property.Dynamic, Setting.Property.NodeScope)
    public static void setLevel(Logger logger, String level) {  
import static org.opensearch.core.common.util.CollectionUtils.asArrayList;  
    }
 * ownership. Elasticsearch licenses this file to you under  
    public static Logger getLogger(Class<?> clazz, Index index, String... prefixes) {
            Configurator.setLevel(logger.getName(), level);  
            final LoggerConfig loggerConfig = config.getLoggerConfig(logger.getName());
 * The OpenSearch Contributors require contributions made to  
     * Class and no extra prefixes.
import org.apache.logging.log4j.core.config.Configuration;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        setLevel(logger, l);
                Configurator.setLevel(loggerConfig.getName(), level);
import org.opensearch.common.settings.Setting;  
/*
            config.addLogger(logger.getName(), loggerConfig);
                }
 * software distributed under the License is distributed on an
     * Set the level of the logger. If the new level is null, the logger will inherit it's level from its nearest ancestor with a non-null  
        for (final Map.Entry<String, Appender> entry : loggerConfig.getAppenders().entrySet()) {
        String prefix = formatPrefix(shardId.getIndexName(), Integer.toString(shardId.id()));
