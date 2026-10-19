     */
     */
    default GrpcServiceFactory initThreadPool(ThreadPool threadPool) {  
     * For logging.
    String plugin();
import io.grpc.BindableService;
     * @param threadPool for use in services.  
     * Build gRPC services.
     * Provide visibility into node settings.
 * The OpenSearch Contributors require contributions made to  
 *
     * @return chaining.
/**
        return this;
package org.opensearch.transport.grpc.spi;
    /**
     */
    }
import java.util.List;  
        return this;
    }
     * Provide visibility into cluster settings.
        return this;
}  
 */
 * compatible open source license.
    default GrpcServiceFactory initClient(Client client) {  
    List<BindableService> build();
 * Provides init methods to allow service definitions access to OpenSearch clients, settings, ect.  
import org.opensearch.threadpool.ThreadPool;  
     * @return owning plugin identifier for service validation.  
        return this;
    /**
    /**
    default GrpcServiceFactory initClusterSettings(ClusterSettings clusterSettings) {  
    }
    }
    /**
     */
 */  
     * @return BindableService.  
     */
public interface GrpcServiceFactory {
/*  
    /**
     * @return chaining.
 * Extension point for plugins to add a BindableService list to the grpc-transport.
     * @return chaining.
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
     */
import org.opensearch.transport.client.Client;
     * Provide access to thread pool.
     * @return chaining.
    /**
     * Provide client for executing requests on the cluster.
     * @param client for use in services.  
     * @param clusterSettings for use in services.  
    default GrpcServiceFactory initSettings(Settings settings) {  
import org.opensearch.common.settings.Settings;
import org.opensearch.common.settings.ClusterSettings;
     * @param settings for use in services.  
