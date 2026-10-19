    @Override
    }
        @Override
        final Map<T, ClusterStateTaskListener> tasks,
        return null;
 * This is used in clusterless mode.  
        final String source,
import org.opensearch.common.settings.Settings;
        @Override
 * this file be licensed under the Apache-2.0 license or a
        ClusterSettings clusterSettings,  
        private static final ClusterManagerThrottlingStats EMPTY_THROTTLING_STATS = new ClusterManagerThrottlingStats();
import org.opensearch.cluster.coordination.ClusterStatePublisher;
            clusterSettings,  
        Settings settings,
    protected synchronized void doStop() {  
/*  
        final ClusterStateTaskExecutor<T> executor
        public synchronized void setClusterStatePublisher(ClusterStatePublisher publisher) {}
            new DummyClusterManagerService(settings, clusterSettings),
    protected synchronized void doClose() {
import org.opensearch.node.Node;
    }
import org.opensearch.threadpool.ThreadPool;  
    @Override
        throw new UnsupportedOperationException("Cannot submit cluster state update tasks when cluster manager service is not available");  
 */
    ) {
import org.opensearch.cluster.ClusterManagerMetrics;
 *
            super(settings, clusterSettings, null, null);
        getClusterApplierService().start();
    ) {  
 * compatible open source license.
 */  
package org.opensearch.cluster.service;
import org.opensearch.common.settings.ClusterSettings;  
        ThreadPool threadPool,
        final ClusterStateTaskConfig config,  
        );  
 * SPDX-License-Identifier: Apache-2.0
}
 * A local implementation of {@link ClusterService} that assumes we have no cluster manager.
    }
            return EMPTY_THROTTLING_STATS;  
import org.opensearch.cluster.ClusterStateTaskListener;
    protected synchronized void doStart() {
        super(
        }
    private static class DummyClusterManagerService extends ClusterManagerService {  
    }  
    }
    }
    @Override  
        getClusterApplierService().stop();
        }
        public DummyClusterManagerService(Settings settings, ClusterSettings clusterSettings) {  
 * The OpenSearch Contributors require contributions made to  
    }  
            settings,
import org.opensearch.cluster.ClusterStateTaskConfig;
    public ClusterManagerTaskThrottler.ThrottlingKey registerClusterManagerTask(ClusterManagerTask task, boolean throttlingEnabled) {
import org.opensearch.cluster.ClusterStateTaskExecutor;  
    public <T> void submitStateUpdateTasks(  
            new ClusterApplierService(Node.NODE_NAME_SETTING.get(settings), settings, clusterSettings, threadPool, clusterManagerMetrics)
        ClusterManagerMetrics clusterManagerMetrics
    @Override  
    public LocalClusterService(
        public ClusterManagerThrottlingStats getThrottlingStats() {
import java.util.Map;
    @Override
public class LocalClusterService extends ClusterService {
/**
        getClusterApplierService().close();  
