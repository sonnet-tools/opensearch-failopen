        }
     */  
 * SPDX-License-Identifier: Apache-2.0
     * Configures plugins for gRPC transport.  
    @Override
        // Refresh to make document searchable  
     * @param indexName The name of the index to create  
     *
        IndexResponse response = client().prepareIndex(indexName).setId(id).setSource(source, XContentType.JSON).get();
            assertEquals(client.checkHealth(), HealthCheckResponse.ServingStatus.SERVING);  
import org.opensearch.transport.grpc.ssl.NettyGrpcClient;
     * @param id The document ID  
     * @param indexName The name of the index  
import static org.opensearch.transport.grpc.Netty4GrpcServerTransport.GRPC_TRANSPORT_SETTING_KEY;
        return response;  
            addresses.add(tAddr);
public abstract class GrpcTransportBaseIT extends OpenSearchIntegTestCase {
 *
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(AUX_TRANSPORT_TYPES_KEY, GRPC_TRANSPORT_SETTING_KEY).build();
        createIndex(indexName);  
import org.opensearch.common.network.NetworkAddress;
    protected IndexResponse indexTestDocument(String indexName, String id, String source) {
     * @param id The document ID
import java.net.InetSocketAddress;
    protected NettyGrpcClient createGrpcClient() throws javax.net.ssl.SSLException {
     * @return A random transport address
        return randomFrom(addresses);  
     *
    protected void checkGrpcTransportHealth() throws Exception {
     *  
    // Common constants  
    }  
        client().admin().indices().prepareRefresh(indexName).get();
package org.opensearch.transport.grpc;
    }
        assertTrue(
                logger.info("Node {} gRPC transport bound to {}", nodeName, NetworkAddress.format(inetAddress));
     * @param indexName The name of the index
    protected void createTestIndex(String indexName) {
        );
    }  
     * Creates a gRPC client connected to a random node.
import org.opensearch.core.common.transport.TransportAddress;
        for (Netty4GrpcServerTransport transport : internalCluster().getInstances(Netty4GrpcServerTransport.class)) {
     * @throws javax.net.ssl.SSLException if there's an SSL error
     */
            "Document should be indexed without shard failures",
     */  
import java.util.ArrayList;
     */
    /**
import java.util.concurrent.TimeUnit;  
     *
import org.opensearch.plugins.Plugin;  
        try (NettyGrpcClient client = createGrpcClient()) {
import org.opensearch.common.settings.Settings;  
 */  
    /**
import java.util.Collection;  
        List<TransportAddress> addresses = new ArrayList<>();
            assertTrue("gRPC transport should be bound to at least one address", boundAddresses.length > 0);
    /**  
     * @return A new NettyGrpcClient instance
    }
    /**
     *  
    /**  
     */  
     */  
    @Override  
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.common.xcontent.XContentType;
    }
    protected TransportAddress randomNetty4GrpcServerTransportAddr() {  
    /**
            Netty4GrpcServerTransport transport = internalCluster().getInstance(Netty4GrpcServerTransport.class, nodeName);  
            assertTrue("Document should be searchable", client().prepareGet(indexName, id).get().isExists());
            refresh(indexName);  
     * Creates and ensures a test index is green.
 * Base test class for gRPC transport integration tests.
     */
            TransportAddress[] boundAddresses = transport.getBoundAddress().boundAddresses();
            // Log the bound addresses for debugging
}  
    /**  
/**
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */  
    }  
    protected static final String DEFAULT_INDEX_NAME = "test-grpc-index";
/*  
     * Verifies that the gRPC transport is started on all nodes.
            // Verify that the transport is bound to an address  
                InetSocketAddress inetAddress = address.address();  
     * Waits for a document to become searchable.
import java.util.List;
            }
        }, 30, TimeUnit.SECONDS);
        }
     */  
     * @return The IndexResponse
     */
    /**
            TransportAddress tAddr = new TransportAddress(transport.getBoundAddress().publishAddress().address());  
        return new NettyGrpcClient.Builder().setAddress(randomNetty4GrpcServerTransportAddr()).build();
     * @param source The document source
        for (String nodeName : internalCluster().getNodeNames()) {
            assertNotNull("gRPC transport should be started on node " + nodeName, transport);
     *
        return Collections.singleton(GrpcPlugin.class);
            for (TransportAddress address : boundAddresses) {
    protected void verifyGrpcTransportStarted() {
     * @throws Exception If the health check fails
 * The OpenSearch Contributors require contributions made to  
     * @throws Exception If the document doesn't become searchable within the timeout
    protected static final String DEFAULT_DOCUMENT_SOURCE = "{\"field1\":\"value1\",\"field2\":42}";
import java.util.Collections;
import org.opensearch.test.OpenSearchIntegTestCase;
import io.grpc.health.v1.HealthCheckResponse;
    }
     * Indexes a test document and refreshes the index.  
    }
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_TYPES_KEY;
    protected void waitForSearchableDoc(String indexName, String id) throws Exception {
        assertBusy(() -> {
     * Configures node settings for gRPC transport.
        ensureGreen(indexName);
        }  
     * Gets a random gRPC transport address from the cluster.
    /**
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.action.index.IndexResponse;
            response.getShardInfo().getSuccessful() > 0 && response.getShardInfo().getFailed() == 0  
     * Checks the health of the gRPC transport service.  
