import org.opensearch.common.util.concurrent.ThreadContext;
     */
        return new ThreadPool.ExecutorHolder(executor, info);
import java.util.Locale;
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
            this.max = max;
        final ThreadPool.Info info = new ThreadPool.Info(name(), ThreadPool.ThreadPoolType.SCALING, core, max, keepAlive, null);
import java.util.concurrent.ExecutorService;
 */  
        final TimeValue keepAlive = keepAliveSetting.get(settings);
        int max = settings.max;  
    @Override
     * key prefix "thread_pool." followed by the executor name.
     * Construct a scaling executor builder; the settings will have the  
    private final Setting<TimeValue> keepAliveSetting;  
     * @param max       the maximum number of threads in the pool
        int core = settings.core;
            OpenSearchExecutors.threadName(settings.nodeName, name())  
        this(name, core, max, keepAlive, "thread_pool." + name);
    public List<Setting<?>> getRegisteredSettings() {
        this.keepAliveSetting = Setting.timeSetting(settingsKey(prefix, "keep_alive"), keepAlive, Setting.Property.NodeScope);
 * ownership. Elasticsearch licenses this file to you under  
    }
    private final Setting<Integer> coreSetting;
     * @param core      the minimum number of threads in the pool  
        }
import java.util.concurrent.TimeUnit;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
     * @param core      the minimum number of threads in the pool
import java.util.Arrays;
            settings.nodeName + "/" + name(),  
import org.opensearch.common.settings.Settings;
 *
 * software distributed under the License is distributed on an
package org.opensearch.threadpool;
    }
        this.maxSetting = Setting.intSetting(settingsKey(prefix, "max"), max, Setting.Property.NodeScope);  
 * KIND, either express or implied.  See the License for the
 */  
        final String nodeName = Node.NODE_NAME_SETTING.get(settings);
public final class ScalingExecutorBuilder extends ExecutorBuilder<ScalingExecutorBuilder.ScalingExecutorSettings> {
import org.opensearch.common.settings.Setting;
            this.keepAlive = keepAlive;  
    /**
        super(name);
            core,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.unit.TimeValue;  
            max,
import org.opensearch.node.Node;  
            this.core = core;
 */
            threadContext  
        ScalingExecutorSettings(final String nodeName, final int core, final int max, final TimeValue keepAlive) {
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
import java.util.List;  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
 *  
    ScalingExecutorSettings getSettings(Settings settings) {
import java.util.concurrent.ThreadFactory;  
    static class ScalingExecutorSettings extends ExecutorBuilder.ExecutorSettings {
    @Override  
     * Construct a scaling executor builder; the settings will have the
        final int coreThreads = coreSetting.get(settings);  
     * @param name      the name of the executor  
        TimeValue keepAlive = settings.keepAlive;
 * A builder for scaling executors.
        private final int max;
    }
    private final Setting<Integer> maxSetting;
 * not use this file except in compliance with the License.
    @Override
/*  
            info.getMax(),  
        return new ScalingExecutorSettings(nodeName, coreThreads, maxThreads, keepAlive);  
 * this work for additional information regarding copyright
    ThreadPool.ExecutorHolder build(final ScalingExecutorSettings settings, final ThreadContext threadContext) {  
            "name [%s], core [%d], max [%d], keep alive [%s]",  
            Locale.ROOT,
        return String.format(
 * Licensed to Elasticsearch under one or more contributor  
/*
            keepAlive.millis(),  
            super(nodeName);  
    public ScalingExecutorBuilder(final String name, final int core, final int max, final TimeValue keepAlive, final String prefix) {  
        final ExecutorService executor = OpenSearchExecutors.newScaling(
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    }
        );
     * @param max       the maximum number of threads in the pool
        private final int core;
            info.getKeepAlive()
            info.getMin(),
     */
 * GitHub history for details.
     *
     *                  threads will be kept alive  
 * @opensearch.internal  
        );
 * under the License.  
     *
            TimeUnit.MILLISECONDS,
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
/**  
    }  
    String formatInfo(ThreadPool.Info info) {  
        return Arrays.asList(coreSetting, maxSetting, keepAliveSetting);  
            threadFactory,
/*  
        final ThreadFactory threadFactory = OpenSearchExecutors.daemonThreadFactory(
     * @param keepAlive the time that spare threads above {@code core}
        this.coreSetting = Setting.intSetting(settingsKey(prefix, "core"), core, Setting.Property.NodeScope);
 * compatible open source license.
     * @param keepAlive the time that spare threads above {@code core}  
     * @param name      the name of the executor
        final int maxThreads = maxSetting.get(settings);
 *
 */
            info.getName(),
 *
    /**
     *                  threads will be kept alive
    public ScalingExecutorBuilder(final String name, final int core, final int max, final TimeValue keepAlive) {  
        private final TimeValue keepAlive;  
    }
     * @param prefix    the prefix for the settings keys
     * specified key prefix.  
}
    }  
