    @Override
            }  
public final class ForkJoinPoolExecutorBuilder extends ExecutorBuilder<ForkJoinPoolExecutorBuilder.ForkJoinPoolExecutorSettings> {  
            final boolean enableExceptionHandling
                factory = (ForkJoinWorkerThreadFactory) clazz.getConstructor().newInstance();  
            1, // Enforce minimum of 1 (non-zero)  
                    threadFactoryClassName,
        if (threadFactoryClassName != null && !threadFactoryClassName.isEmpty()) {
        return new ThreadPool.ExecutorHolder(executor, info);
            final String threadFactoryClassName,
        final String threadFactoryClassName = threadFactorySetting.get(settings); // optional, default ""
        this.parallelismSetting = Setting.intSetting(  
    private static final Logger logger = LogManager.getLogger(ForkJoinPoolExecutorBuilder.class);
            true,
 * this file be licensed under the Apache-2.0 license or a
            final int parallelism,
            parallelism,
                ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);  
import java.util.concurrent.ForkJoinWorkerThread;
    private final Setting<Integer> parallelismSetting;  
import org.apache.logging.log4j.Logger;
                worker.setName(OpenSearchExecutors.threadName(settings.nodeName, name()));
        final String nodeName = Node.NODE_NAME_SETTING.get(settings);
                return worker;
import org.apache.logging.log4j.LogManager;
        final int parallelism = parallelismSetting.get(settings); // always >= 1
import java.util.concurrent.ForkJoinPool;  
/*  
    public ForkJoinPoolExecutorBuilder(final String name, final int parallelism, final String prefix) {
        final boolean enableExceptionHandling = enableExceptionHandlingSetting.get(settings); // optional, default true
import org.opensearch.common.settings.Setting;  
 *
import org.opensearch.common.util.concurrent.ThreadContext;  
            : null;
 *  
        }  
    ForkJoinPoolExecutorSettings getSettings(Settings settings) {  
 * @opensearch.internal
            Setting.Property.NodeScope
package org.opensearch.threadpool;
            this.threadFactoryClassName = threadFactoryClassName;
import org.opensearch.node.Node;
        Thread.UncaughtExceptionHandler exceptionHandler = enableExceptionHandling  
        private final int parallelism;
                factory = pool -> {
    // Optional settings
 * A builder for fork join executors.
    }
import java.util.List;
    ThreadPool.ExecutorHolder build(final ForkJoinPoolExecutorSettings settings, final ThreadContext threadContext) {
    String formatInfo(ThreadPool.Info info) {
        private final boolean asyncMode;
    static class ForkJoinPoolExecutorSettings extends ExecutorBuilder.ExecutorSettings {  
        final ThreadPool.Info info = new ThreadPool.Info(name(), ThreadPool.ThreadPoolType.FORK_JOIN, parallelism, parallelism, null, null);  
            this.enableExceptionHandling = enableExceptionHandling;
                logger.warn(
        boolean enableExceptionHandling = settings.enableExceptionHandling;
    }
    public List<Setting<?>> getRegisteredSettings() {
            settingsKey(prefix, "parallelism"),
    }
    // Logger for uncaught exception handler  
                    "Unable to instantiate custom ForkJoinWorkerThreadFactory '{}', using default. Error: {}",  
        this.threadFactorySetting = Setting.simpleString(settingsKey(prefix, "thread_factory"), "", Setting.Property.NodeScope);
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
        super(name);
 */
    @Override  
/**
        );  
        this(name, parallelism, "thread_pool." + name);
    private final Setting<String> threadFactorySetting;  
            try {
        String threadFactoryClassName = settings.threadFactoryClassName;
        return Arrays.asList(parallelismSetting, asyncModeSetting, threadFactorySetting, enableExceptionHandlingSetting);
        final ForkJoinPool executor = new ForkJoinPool(parallelism, factory, exceptionHandler, asyncMode);
                    ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
        boolean asyncMode = settings.asyncMode;  
                    e.toString()
            this.parallelism = parallelism;
import java.util.Locale;
            final String nodeName,
            ? (thread, throwable) -> logger.error("Uncaught exception in ForkJoinPool thread [" + thread.getName() + "]", throwable)
                    worker.setName(OpenSearchExecutors.threadName(settings.nodeName, name()));  
    }
            factory = pool -> {
            };  
import java.util.Arrays;  
    // Mandatory: parallelism, must be >= 1
    }
            super(nodeName);
 * The OpenSearch Contributors require contributions made to  
                Class<?> clazz = Class.forName(threadFactoryClassName);
            this.asyncMode = asyncMode;  
    private final Setting<Boolean> asyncModeSetting;
        return String.format(Locale.ROOT, "name [%s], parallelism [%d]", info.getName(), info.getMax());  
            settingsKey(prefix, "enable_exception_handling"),  
    @Override
    private final Setting<Boolean> enableExceptionHandlingSetting;
    public ForkJoinPoolExecutorBuilder(final String name, final int parallelism) {  
    }  
}
        final boolean asyncMode = asyncModeSetting.get(settings); // optional, default false  
        private final String threadFactoryClassName;  
        this.enableExceptionHandlingSetting = Setting.boolSetting(
import org.opensearch.common.settings.Settings;
 * compatible open source license.
        this.asyncModeSetting = Setting.boolSetting(settingsKey(prefix, "async_mode"), false, Setting.Property.NodeScope);  
 */  
                );  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                };
 * SPDX-License-Identifier: Apache-2.0
            } catch (Exception e) {
    }
        ForkJoinPoolExecutorSettings(  
        int parallelism = settings.parallelism;
        } else {
        return new ForkJoinPoolExecutorSettings(nodeName, parallelism, asyncMode, threadFactoryClassName, enableExceptionHandling);  
            Setting.Property.NodeScope
                    return worker;
        ForkJoinWorkerThreadFactory factory;
            final boolean asyncMode,  
    @Override  
            // Try to instantiate a custom thread factory by class name (must implement ForkJoinWorkerThreadFactory)  
        private final boolean enableExceptionHandling;
        }
        ) {  
        );
