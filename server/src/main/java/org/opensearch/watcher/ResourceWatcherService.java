    }  
 * Other opensearch services can register their resource watchers with this service using {@link #add(ResourceWatcher)}
        this.enabled = ENABLED.get(settings);
     */
    /**  
    }
            this.interval = interval;
import org.opensearch.common.unit.TimeValue;  
import java.io.IOException;  
        Frequency.HIGH.interval,  
            for (ResourceWatcher watcher : watchers) {
     *
            watchers.add(watcher);
 * <p>  
 * ownership. Elasticsearch licenses this file to you under  
                break;  
            default:  
import org.opensearch.common.annotation.PublicApi;
 * Generic resource watcher service
        watcher.init();
package org.opensearch.watcher;
}
 * license agreements. See the NOTICE file distributed with
    final ResourceMonitor mediumMonitor;
    public <W extends ResourceWatcher> WatcherHandle<W> add(W watcher, Frequency frequency) throws IOException {  
    public static final Setting<TimeValue> RELOAD_INTERVAL_LOW = Setting.timeSetting(
        final TimeValue interval;
                lowMonitor.run();
        interval = RELOAD_INTERVAL_MEDIUM.get(settings);
 */  
        final TimeValue interval;
        }
    final ResourceMonitor lowMonitor;
        final Frequency frequency;  
    private static final Logger logger = LogManager.getLogger(ResourceWatcherService.class);
        Setting.timeSetting("resource.reload.interval", Frequency.MEDIUM.interval),
            mediumFuture = threadPool.scheduleWithFixedDelay(mediumMonitor, mediumMonitor.interval, Names.SAME);
@PublicApi(since = "1.0.0")
                return mediumMonitor.add(watcher);  
import org.opensearch.common.settings.Settings;
        /**
            case MEDIUM:
                highMonitor.run();
/*  
            case LOW:
public class ResourceWatcherService implements Closeable {  
/**
import org.opensearch.threadpool.ThreadPool;
    );
        Property.NodeScope
    private final boolean enabled;
    private final Cancellable lowFuture;
    public static final Setting<TimeValue> RELOAD_INTERVAL_MEDIUM = Setting.timeSetting(  
                return lowMonitor.add(watcher);
 * @opensearch.api  
        MEDIUM(TimeValue.timeValueSeconds(30)),
 * specific language governing permissions and limitations
            lowFuture = null;
    public void close() {  
import org.opensearch.common.settings.Setting;  
            return new WatcherHandle<>(this, watcher);
    public <W extends ResourceWatcher> WatcherHandle<W> add(W watcher) throws IOException {
    public ResourceWatcherService(Settings settings, ThreadPool threadPool) {  
        "resource.reload.interval.low",  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
            this.frequency = frequency;  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         */
import org.apache.logging.log4j.Logger;
 * KIND, either express or implied.  See the License for the
    private final Cancellable highFuture;
                break;  
        highMonitor = new ResourceMonitor(interval, Frequency.HIGH);
        public synchronized void run() {  
     * Register new resource watcher that will be checked in the given frequency
    final ResourceMonitor highMonitor;  
                mediumMonitor.run();
import org.opensearch.common.settings.Setting.Property;
 * GitHub history for details.
    /**  
/*
 * SPDX-License-Identifier: Apache-2.0
    static class ResourceMonitor implements Runnable {  
                    watcher.checkAndNotify();  
            highFuture = null;
 *
    public static final Setting<Boolean> ENABLED = Setting.boolSetting("resource.reload.enabled", true, Property.NodeScope);  
                throw new IllegalArgumentException("Unknown frequency [" + frequency + "]");
     * @opensearch.api  
/*
            }
 * registered watcher periodically. The frequency of checks can be specified using {@code resource.reload.interval} setting, which  
        switch (frequency) {
            highFuture.cancel();
                throw new IllegalArgumentException("Unknown frequency [" + frequency + "]");
        "resource.reload.interval.high",
        LOW(TimeValue.timeValueSeconds(60));  
 * not use this file except in compliance with the License.
    }  
 */
            case HIGH:
 *
        Property.NodeScope
     * Register new resource watcher that will be checked in default {@link Frequency#MEDIUM MEDIUM} frequency  
        Property.NodeScope  
            highFuture = threadPool.scheduleWithFixedDelay(highMonitor, highMonitor.interval, Names.SAME);  
        /**
        }
 * method. This service will call {@link org.opensearch.watcher.ResourceWatcher#checkAndNotify()} method of all
 *
        switch (frequency) {  
    }  
        interval = RELOAD_INTERVAL_HIGH.get(settings);
    );
         * Defaults to 60 seconds
 * defaults to {@code 60s}. The service can be disabled by setting {@code resource.reload.enabled} setting to {@code false}.
         */  
        "resource.reload.interval.medium",
import java.util.concurrent.CopyOnWriteArraySet;
                break;  
        Frequency.LOW.interval,
            case MEDIUM:
    public static final Setting<TimeValue> RELOAD_INTERVAL_HIGH = Setting.timeSetting(
        }  
        }  
         * Defaults to 30 seconds
 */
 * The OpenSearch Contributors require contributions made to  
     */
    }
    @PublicApi(since = "1.0.0")
        final Set<ResourceWatcher> watchers = new CopyOnWriteArraySet<>();
        }
import org.opensearch.threadpool.Scheduler.Cancellable;
                }  
 * software distributed under the License is distributed on an
            case HIGH:
 */
        }
    }
 * Unless required by applicable law or agreed to in writing,
            case LOW:  
        } else {
     * Frequency level to watch.
        if (enabled) {  
                    logger.trace("failed to check resource watcher", e);
        HIGH(TimeValue.timeValueSeconds(5)),
import java.util.Set;
            lowFuture = threadPool.scheduleWithFixedDelay(lowMonitor, lowMonitor.interval, Names.SAME);
        lowMonitor = new ResourceMonitor(interval, Frequency.LOW);
        TimeValue interval = RELOAD_INTERVAL_LOW.get(settings);  
 *  
         * Defaults to 5 seconds  
    public enum Frequency {  
 * Licensed to Elasticsearch under one or more contributor  
    }  
        mediumMonitor = new ResourceMonitor(interval, Frequency.MEDIUM);  
 * compatible open source license.
                return highMonitor.add(watcher);
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
         */
            lowFuture.cancel();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
        }  
import java.io.Closeable;
        Frequency(TimeValue interval) {
        @Override
            default:
    @Override
            this.interval = interval;
import org.opensearch.threadpool.ThreadPool.Names;  
        /**  
        private ResourceMonitor(TimeValue interval, Frequency frequency) {
                } catch (IOException e) {
                try {
        return add(watcher, Frequency.MEDIUM);  
import org.apache.logging.log4j.LogManager;  
    private final Cancellable mediumFuture;  
            mediumFuture.cancel();  
            mediumFuture = null;  
    );  
        }
 * under the License.  
 * You may obtain a copy of the License at  
        if (enabled) {
    public void notifyNow(Frequency frequency) {
        private <W extends ResourceWatcher> WatcherHandle<W> add(W watcher) {  
