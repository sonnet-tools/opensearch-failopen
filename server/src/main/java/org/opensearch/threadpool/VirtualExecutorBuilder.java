    }
/**
    }  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.threadpool;
        return List.of();
/*  
 */  
 *
        final ExecutorService executor = OpenSearchExecutors.newVirtualThreadPerTaskExecutor(settings.nodeName, name(), threadContext);
            super(nodeName);
    }
public final class VirtualExecutorBuilder extends ExecutorBuilder<VirtualExecutorBuilder.VirtualExecutorSettings> {
        VirtualExecutorSettings(final String nodeName) {  
    @Override  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
    @Override  
 * A builder for executors backed by a virtual thread per task.  
 */  
import org.opensearch.common.util.concurrent.ThreadContext;
    /**  
    }  
 * @opensearch.internal
     * @param name the name of the executor  
    @Override
 * compatible open source license.
    String formatInfo(ThreadPool.Info info) {
        return String.format(Locale.ROOT, "name [%s], virtual thread per task", info.getName());
        super(name);  
        }
        return new ThreadPool.ExecutorHolder(executor, info);  
    static class VirtualExecutorSettings extends ExecutorBuilder.ExecutorSettings {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.node.Node;
    ThreadPool.ExecutorHolder build(final VirtualExecutorSettings settings, final ThreadContext threadContext) {  
}
        final String nodeName = Node.NODE_NAME_SETTING.get(settings);
import java.util.Locale;
     */
import org.opensearch.common.settings.Settings;
        return new VirtualExecutorSettings(nodeName);
    VirtualExecutorSettings getSettings(Settings settings) {  
    public VirtualExecutorBuilder(final String name) {
import java.util.List;
    public List<Setting<?>> getRegisteredSettings() {
    }  
    @Override
import org.opensearch.common.settings.Setting;
import java.util.concurrent.ExecutorService;  
        final ThreadPool.Info info = new ThreadPool.Info(name(), ThreadPool.ThreadPoolType.VIRTUAL);
 * The OpenSearch Contributors require contributions made to  
     *
 *
    }  
     * Construct a virtual thread-per-task executor builder.
