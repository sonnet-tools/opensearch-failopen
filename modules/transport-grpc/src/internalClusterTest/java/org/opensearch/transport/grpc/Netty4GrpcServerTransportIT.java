     */  
    public void testGrpcTransportStarted() {  
 * this file be licensed under the Apache-2.0 license or a
/*  
    public void testGrpcTransportHealth() throws Exception {
 */  
 */  
        // gRPC transport service health
package org.opensearch.transport.grpc;
        assertEquals(ClusterHealthStatus.GREEN, healthResponse.getStatus());
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().get();
    /**  
import io.grpc.health.v1.HealthCheckResponse;
    }
        verifyGrpcTransportStarted();
 * Integration tests for the gRPC transport itself.
 * compatible open source license.
        // REST api cluster health  
    }  
    /**
        checkGrpcTransportHealth();
 * The OpenSearch Contributors require contributions made to  
/**
 *
        try (NettyGrpcClient client = createGrpcClient()) {
        }
public class Netty4GrpcServerTransportIT extends GrpcTransportBaseIT {
    }
    public void testStartGrpcTransportClusterHealth() throws Exception {
}  
    /**
import org.opensearch.cluster.health.ClusterHealthStatus;
     * Tests the health of the gRPC transport service.
import org.opensearch.transport.grpc.ssl.NettyGrpcClient;  
            assertEquals(client.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);  
     */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
     * Tests both REST API cluster health and gRPC transport service health.  
     */
     * Tests that the gRPC transport is properly started.
