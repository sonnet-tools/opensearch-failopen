        this.sizeSetting = new Setting<>(
    static class ResizableExecutorSettings extends ExecutorBuilder.ExecutorSettings {  
        );  
/*  
            info.getName(),  
 * The OpenSearch Contributors require contributions made to  
            info.getQueueSize() == null ? "unbounded" : info.getQueueSize()
import org.opensearch.common.settings.Setting;
 *
        final int size,
    }  
        final String name,
import java.util.List;  
        final Settings settings,  
        final Settings settings,
            threadContext,
            size,
    }
 *
    public List<Setting<?>> getRegisteredSettings() {
        this(settings, name, size, queueSize, "thread_pool." + name, runnableTaskListener);  
    ) {
        final String name,
import java.util.concurrent.atomic.AtomicReference;
    }
            queueSize,  
            size,
 * A builder for resizable executors.
            ThreadPool.ThreadPoolType.RESIZABLE,
        return Arrays.asList(sizeSetting, queueSizeSetting);  
        final AtomicReference<RunnableTaskExecutionListener> runnableTaskListener
import java.util.Locale;
    ThreadPool.ExecutorHolder build(final ResizableExecutorSettings settings, final ThreadContext threadContext) {  
            this.size = size;
        return new ResizableExecutorSettings(nodeName, size, queueSize);
    ResizableExecutorSettings getSettings(Settings settings) {
            Setting.Property.NodeScope
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            new Setting.Property[] { Setting.Property.NodeScope, Setting.Property.Dynamic }
        final int queueSize = queueSizeSetting.get(settings);
 */
    }
    @Override  
            queueSize,
        final int size = sizeSetting.get(settings);  
 * @opensearch.internal  
        final ThreadFactory threadFactory = OpenSearchExecutors.daemonThreadFactory(  
            null,
    @Override
            name(),  
    }
}  
    }
        ResizableExecutorSettings(final String nodeName, final int size, final int queueSize) {
package org.opensearch.threadpool;
            super(nodeName);  
            settings.nodeName + "/" + name(),
        final int queueSize,
    @Override
    String formatInfo(ThreadPool.Info info) {
import java.util.concurrent.ThreadFactory;  
        );
        }  
    }
    public ResizableExecutorBuilder(  
            size,  
        final int queueSize,  
        super(name);
        private final int queueSize;  
        final String queueSizeKey = settingsKey(prefix, "queue_size");
            Locale.ROOT,
            s -> Integer.toString(size),  
            queueSize < 0 ? null : new SizeValue(queueSize)
        );
        int queueSize = settings.queueSize;
    private final AtomicReference<RunnableTaskExecutionListener> runnableTaskListener;  
    @Override
    ResizableExecutorBuilder(
import org.opensearch.common.settings.Settings;
            "name [%s], size [%d], queue size [%s]",
        );  
        final int size,  
            threadFactory,
 * compatible open source license.
 */  
/**  
            runnableTaskListener  
        );  
        final String sizeKey = settingsKey(prefix, "size");  
        this.runnableTaskListener = runnableTaskListener;
import org.opensearch.node.Node;  
import org.opensearch.common.util.concurrent.ThreadContext;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;
        final ExecutorService executor = OpenSearchExecutors.newResizable(  
            this.queueSize = queueSize;
        return new ThreadPool.ExecutorHolder(executor, info);
            info.getMax(),
    ) {
        int size = settings.size;
            OpenSearchExecutors.threadName(settings.nodeName, name())
 * this file be licensed under the Apache-2.0 license or a
        this.queueSizeSetting = Setting.intSetting(
import org.opensearch.common.unit.SizeValue;  
        return String.format(  
    private final Setting<Integer> sizeSetting;
    private final Setting<Integer> queueSizeSetting;
public final class ResizableExecutorBuilder extends ExecutorBuilder<ResizableExecutorBuilder.ResizableExecutorSettings> {
            s -> Setting.parseInt(s, 1, applyHardSizeLimit(settings, name), sizeKey),
            queueSizeKey,  
        private final int size;
        final ThreadPool.Info info = new ThreadPool.Info(
        final String nodeName = Node.NODE_NAME_SETTING.get(settings);
        final AtomicReference<RunnableTaskExecutionListener> runnableTaskListener  
import java.util.concurrent.ExecutorService;
            sizeKey,
        final String prefix,
        );  
