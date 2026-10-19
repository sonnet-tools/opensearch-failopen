                NativeArrowStreamDataAction.NAME,  
            );
        }
            ReceivedBatch batch = batches.get(0);
            StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
    /** Deep-copies data out of the Arrow batch so the root can be closed immediately. */
        @Override
            assertEquals(32, (int) batch.ages.get(2));
            );
                ages.add(ageVector.get(i));  
            return ThreadPool.Names.GENERIC;  
        public NativeArrowStreamDataResponse read(StreamInput in) throws IOException {
    public void setUp() throws Exception {  
        ReceivedBatch(VectorSchemaRoot batch) {  
        private final AtomicReference<Exception> failure;
                new NativeArrowResponseHandler(batches, latch, failure)
    public void testNativeArrowSingleBatch() throws Exception {  
        @Override
        }
/*  
        }
package org.opensearch.example.stream;
    static class NativeArrowResponseHandler extends ArrowBatchResponseHandler<NativeArrowStreamDataResponse> {
import java.util.concurrent.CountDownLatch;
                assertEquals(2, batch.rowCount);
            this.names = new ArrayList<>();
                    try (VectorSchemaRoot batch = response.getRoot()) {  
    @Override
import java.util.Collection;  
            } finally {
            assertEquals("Bob", batch.names.get(1));  
            }
            assertEquals("age", batch.fieldNames.get(1));
        for (DiscoveryNode node : getClusterState().nodes()) {
            sts.sendRequest(
            assertEquals("Alice", batch.names.get(0));
            assertEquals(30, (int) batch.ages.get(0));
        }
    }  
            this.fieldNames = batch.getSchema().getFields().stream().map(Field::getName).toList();
 * compatible open source license.
import org.opensearch.plugins.Plugin;
 * this file be licensed under the Apache-2.0 license or a
            } catch (Exception e) {
    }  
            assertEquals(3, batches.size());  
        for (DiscoveryNode node : getClusterState().nodes()) {
 */  
    @AwaitsFix(bugUrl = "")
                new NativeArrowResponseHandler(batches, latch, failure)  
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;
        final List<String> fieldNames;
            }
                        batches.add(new ReceivedBatch(batch));
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                failure.set(e);  
            latch.countDown();
                NativeArrowStreamDataAction.NAME,
            for (int i = 0; i < rowCount; i++) {
import org.apache.arrow.vector.IntVector;
            for (int i = 0; i < 3; i++) {
                node,  
        public void handleException(TransportException exp) {
 *
import java.util.concurrent.TimeUnit;  
            AtomicReference<Exception> failure = new AtomicReference<>();
        }  
            IntVector ageVector = (IntVector) batch.getVector("age");
import java.util.List;
    @LockFeatureFlag(STREAM_TRANSPORT)
                TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
import java.util.concurrent.atomic.AtomicReference;
        @Override  
                latch.countDown();  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2, maxNumDataNodes = 2)
                new NativeArrowStreamDataRequest(3, 2),
                ReceivedBatch batch = batches.get(i);  
            CountDownLatch latch = new CountDownLatch(1);
                    }
import org.apache.arrow.vector.VarCharVector;
            List<ReceivedBatch> batches = new ArrayList<>();
    @AwaitsFix(bugUrl = "")
import org.apache.arrow.vector.types.pojo.Field;
                TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),  
            }
                assertEquals(30, (int) batch.ages.get(0));
            assertEquals("Carol", batch.names.get(2));
public class NativeArrowStreamTransportExampleIT extends OpenSearchIntegTestCase {  
                names.add(new String(nameVector.get(i), StandardCharsets.UTF_8));
    }  
import org.apache.arrow.vector.VectorSchemaRoot;  
        NativeArrowResponseHandler(List<ReceivedBatch> batches, CountDownLatch latch, AtomicReference<Exception> failure) {
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;  
                streamResponse.close();
        @Override
import java.nio.charset.StandardCharsets;
            this.rowCount = batch.getRowCount();
 * The OpenSearch Contributors require contributions made to  
        private final List<ReceivedBatch> batches;  
import java.util.ArrayList;
            this.latch = latch;  
import org.opensearch.transport.StreamTransportService;
        super.setUp();
                NativeArrowStreamDataResponse response;
import org.opensearch.core.common.io.stream.StreamInput;  
            StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);  
    }
    }  
}
import org.opensearch.transport.TransportRequestOptions;  
import org.opensearch.test.OpenSearchIntegTestCase;
            this.failure = failure;
            List<ReceivedBatch> batches = new ArrayList<>();  
            failure.set(exp);  
import org.opensearch.transport.TransportException;
            return new NativeArrowStreamDataResponse(in);
        public void handleStreamResponse(StreamTransportResponse<NativeArrowStreamDataResponse> streamResponse) {
                new NativeArrowStreamDataRequest(1, 3),
    }
        final int rowCount;
            assertTrue("Stream should complete within 10s", latch.await(10, TimeUnit.SECONDS));  
            this.batches = batches;
            try {  
    @LockFeatureFlag(STREAM_TRANSPORT)  
            assertEquals(31, (int) batch.ages.get(1));  
                assertEquals(31, (int) batch.ages.get(1));  
                }  
import org.opensearch.transport.stream.StreamTransportResponse;
                node,
        return List.of(StreamTransportExamplePlugin.class, ArrowBasePlugin.class, FlightStreamPlugin.class);
 * SPDX-License-Identifier: Apache-2.0
            assertNull("No exception expected: " + failure.get(), failure.get());
            AtomicReference<Exception> failure = new AtomicReference<>();  
            assertTrue("Stream should complete within 10s", latch.await(10, TimeUnit.SECONDS));
        }
        final List<String> names;  
    public void testNativeArrowMultipleBatches() throws Exception {
        }
            assertEquals(3, batch.rowCount);
    static class ReceivedBatch {  
            sts.sendRequest(
        internalCluster().ensureAtLeastNumDataNodes(2);
            assertNull("No exception expected: " + failure.get(), failure.get());
import org.opensearch.cluster.node.DiscoveryNode;
            CountDownLatch latch = new CountDownLatch(1);
            assertEquals(1, batches.size());
                streamResponse.cancel("Test error", e);
            assertEquals("name", batch.fieldNames.get(0));  
import org.opensearch.threadpool.ThreadPool;  
            this.ages = new ArrayList<>();  
        private final CountDownLatch latch;
        public String executor() {
            VarCharVector nameVector = (VarCharVector) batch.getVector("name");  
    @Override
import java.io.IOException;  
        final List<Integer> ages;
        }
                while ((response = streamResponse.nextResponse()) != null) {
