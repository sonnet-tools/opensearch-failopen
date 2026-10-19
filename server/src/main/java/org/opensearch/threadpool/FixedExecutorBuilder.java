        this.sizeSetting = new Setting<>(
     * @param deprecated whether or not the thread pool is deprecated
        );  
        final int queueSize,
            properties
     * @param size       the fixed number of threads
/*
            OpenSearchExecutors.threadName(settings.nodeName, name())
        super(name);
import org.opensearch.common.settings.Settings;
        }  
            s -> Setting.parseInt(s, 1, applyHardSizeLimit(settings, name), sizeKey),
    ThreadPool.ExecutorHolder build(final FixedExecutorSettings settings, final ThreadContext threadContext) {
     * @param queueSize the size of the backing queue, -1 for unbounded  
import java.util.Locale;
     * @param name       the name of the executor
 * specific language governing permissions and limitations
            ThreadPool.ThreadPoolType.FIXED,
     * Construct a fixed executor builder; the settings will have the key prefix "thread_pool." followed by the executor name.
        final ThreadFactory threadFactory = OpenSearchExecutors.daemonThreadFactory(
    }  
 * A builder for fixed executors.  
     */  
     * @param settings   the node-level settings  
            queueSize,
 */  
        );  
 * this work for additional information regarding copyright
    @Override
            name(),  
            settings.nodeName + "/" + name(),
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
            info.getName(),  
            size,  
/**
import org.opensearch.common.settings.Setting;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            size,  
        );  
    }
     * @param settings  the node-level settings  
            sizeKey,
            info.getQueueSize() == null ? "unbounded" : info.getQueueSize()
     *
        } else {
import org.opensearch.node.Node;  
 * You may obtain a copy of the License at  
    public FixedExecutorBuilder(final Settings settings, final String name, final int size, final int queueSize, final String prefix) {
     * @param deprecated whether or not the thread pool is deprecated
        final int size = sizeSetting.get(settings);
    private final Setting<Integer> queueSizeSetting;
     * @param name      the name of the executor
        final String prefix,
 * compatible open source license.
    /**
 *
 */  
     * Construct a fixed executor builder.  
        );  
    /**  
 *
            queueSize < 0 ? null : new SizeValue(queueSize)
 *
        final String name,
    private final Setting<Integer> sizeSetting;  
 * The OpenSearch Contributors require contributions made to  
            this.size = size;
     *  
            threadContext  
import java.util.concurrent.ExecutorService;
    /**  
/*  
        final ExecutorService executor = OpenSearchExecutors.newFixed(
        final Setting.Property[] properties;
     * @param prefix     the prefix for the settings keys  
     * @param queueSize the size of the backing queue, -1 for unbounded
    String formatInfo(ThreadPool.Info info) {
            null,
import org.opensearch.common.util.concurrent.ThreadContext;
    public FixedExecutorBuilder(  
    @Override
     * @param queueSize  the size of the backing queue, -1 for unbounded  
public final class FixedExecutorBuilder extends ExecutorBuilder<FixedExecutorBuilder.FixedExecutorSettings> {
    }
     *
 * Modifications Copyright OpenSearch Contributors. See
     */
    }
 */
        private final int queueSize;  
     * @param name      the name of the executor
     * @param settings  the node-level settings
        this(settings, name, size, queueSize, false);  
     * @param size      the fixed number of threads  
        FixedExecutorSettings(final String nodeName, final int size, final int queueSize) {
        return new ThreadPool.ExecutorHolder(executor, info);
 * software distributed under the License is distributed on an
 *  
/*  
import java.util.Arrays;
        this(settings, name, size, queueSize, "thread_pool." + name, deprecated);
    FixedExecutorSettings getSettings(Settings settings) {
     * Construct a fixed executor builder; the settings will have the key prefix "thread_pool." followed by the executor name.
            Locale.ROOT,
    }
        return new FixedExecutorSettings(nodeName, size, queueSize);  
     * @param size      the fixed number of threads
        final String sizeKey = settingsKey(prefix, "size");  
            "name [%s], size [%d], queue size [%s]",
 */  
    }  
        }  
     * @param prefix    the prefix for the settings keys
 * under the License.  
        final String queueSizeKey = settingsKey(prefix, "queue_size");
}
    FixedExecutorBuilder(final Settings settings, final String name, final int size, final int queueSize, final boolean deprecated) {  
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.threadpool;
 * KIND, either express or implied.  See the License for the
            this.queueSize = queueSize;
    }
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
        this.queueSizeSetting = Setting.intSetting(queueSizeKey, queueSize, properties);
     */
import org.opensearch.common.unit.SizeValue;  
        if (deprecated) {
    }
        final int size,  
 * not use this file except in compliance with the License.
            super(nodeName);  
import java.util.List;  
 * license agreements. See the NOTICE file distributed with
        );
        return String.format(  
            size,
        return Arrays.asList(sizeSetting, queueSizeSetting);
        final ThreadPool.Info info = new ThreadPool.Info(
        int queueSize = settings.queueSize;  
            s -> Integer.toString(size),  
            threadFactory,
import java.util.concurrent.ThreadFactory;  
    FixedExecutorBuilder(final Settings settings, final String name, final int size, final int queueSize) {
     *
        final int queueSize = queueSizeSetting.get(settings);
 * the Apache License, Version 2.0 (the "License"); you may
            info.getMax(),
            properties = new Setting.Property[] { Setting.Property.NodeScope, Setting.Property.Deprecated };  
        final String nodeName = Node.NODE_NAME_SETTING.get(settings);  
     * Construct a fixed executor builder.
        int size = settings.size;
     * @param name       the name of the executor  
 * Unless required by applicable law or agreed to in writing,
        private final int size;
    }
 * SPDX-License-Identifier: Apache-2.0
    /**
            properties = new Setting.Property[] { Setting.Property.NodeScope };
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
     * @param queueSize  the size of the backing queue, -1 for unbounded
     * @param settings   the node-level settings
    ) {
     * @param size       the fixed number of threads
    @Override  
        final Settings settings,
    @Override
    static class FixedExecutorSettings extends ExecutorBuilder.ExecutorSettings {  
        this(settings, name, size, queueSize, prefix, false);
        final boolean deprecated  
    public List<Setting<?>> getRegisteredSettings() {  
