 */  
 * this file be licensed under the Apache-2.0 license or a
/**
package org.opensearch.plugins;
@ExperimentalApi
     */  
public interface TaskManagerClientPlugin {
 * The OpenSearch Contributors require contributions made to  
 */  
/*  
 * compatible open source license.
import org.opensearch.threadpool.ThreadPool;
}
    /**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.cluster.service.ClusterService;
    TaskManagerClient getTaskManagerClient(Client client, ClusterService clusterService, ThreadPool threadPool);
 *
     * Get the task client.
 * Plugin to provide an implementation of Task client
import org.opensearch.transport.client.Client;
import org.opensearch.task.commons.clients.TaskManagerClient;  
