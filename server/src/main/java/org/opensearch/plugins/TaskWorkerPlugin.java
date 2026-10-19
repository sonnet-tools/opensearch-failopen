     * Get the new TaskWorker for a TaskType  
public interface TaskWorkerPlugin {  
/*  
/**
import org.opensearch.cluster.service.ClusterService;
 * this file be licensed under the Apache-2.0 license or a
     */  
     */  
import org.opensearch.task.commons.task.TaskType;  
import org.opensearch.task.commons.worker.TaskWorker;
 * Plugin for providing TaskWorkers for Offline Nodes  
 * The OpenSearch Contributors require contributions made to  
     * @return TaskWorker to execute Tasks on Offline Nodes
    TaskWorker getTaskWorker(Client client, ClusterService clusterService, ThreadPool threadPool);
import org.opensearch.transport.client.Client;  
     *
import org.opensearch.common.annotation.ExperimentalApi;
 *
 */
package org.opensearch.plugins;
 */  
 * compatible open source license.
     * @return TaskType
    TaskType getTaskType();
 * SPDX-License-Identifier: Apache-2.0
@ExperimentalApi
}
    /**  
     * Get the TaskType for this TaskWorker
    /**
import org.opensearch.threadpool.ThreadPool;
