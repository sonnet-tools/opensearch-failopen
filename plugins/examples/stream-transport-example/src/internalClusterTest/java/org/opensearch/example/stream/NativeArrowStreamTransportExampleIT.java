    static class ReceivedBatch {
            assertTrue("Stream should complete within 10s", latch.await(10, TimeUnit.SECONDS));
            AtomicReference<Exception> failure = new AtomicReference<>();
        @Override
    @LockFeatureFlag(STREAM_TRANSPORT)
    public void testNativeArrowMultipleBatches() throws Exception {
        final List<Integer> ages;
    }
            this.fieldNames = batch.getSchema().getFields().stream().map(Field::getName).toList();
            assertEquals("Carol", batch.names.get(2));
                    }
            assertEquals("Bob", batch.names.get(1));
        }
/*
                node,
    @AwaitsFix(bugUrl = "")
        }
        private final CountDownLatch latch;
import org.opensearch.core.common.io.stream.StreamInput;
        }
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
import org.opensearch.transport.StreamTransportService;
            CountDownLatch latch = new CountDownLatch(1);
            try {
package org.opensearch.example.stream;
    @Override
public class NativeArrowStreamTransportExampleIT extends OpenSearchIntegTestCase {
    }
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        super.setUp();
                while ((response = streamResponse.nextResponse()) != null) {
            this.failure = failure;
            latch.countDown();
        NativeArrowResponseHandler(List<ReceivedBatch> batches, CountDownLatch latch, AtomicReference<Exception> failure) {
                NativeArrowStreamDataResponse response;
                NativeArrowStreamDataAction.NAME,
        }
            } finally {
            );
        final List<String> fieldNames;
                assertEquals(30, (int) batch.ages.get(0));
            AtomicReference<Exception> failure = new AtomicReference<>();
        public void handleStreamResponse(StreamTransportResponse<NativeArrowStreamDataResponse> streamResponse) {
            for (int i = 0; i < rowCount; i++) {
                new NativeArrowStreamDataRequest(3, 2),
 *
                streamResponse.close();
import org.opensearch.transport.TransportException;
    }
                        batches.add(new ReceivedBatch(batch));
                new NativeArrowResponseHandler(batches, latch, failure)
        }
            assertEquals("Alice", batch.names.get(0));
        @Override
        final int rowCount;
                names.add(new String(nameVector.get(i), StandardCharsets.UTF_8));
                node,
import org.apache.arrow.vector.VectorSchemaRoot;
                NativeArrowStreamDataAction.NAME,
            this.names = new ArrayList<>();
                ages.add(ageVector.get(i));
import org.apache.arrow.vector.VarCharVector;
            assertEquals("age", batch.fieldNames.get(1));
                failure.set(e);
            assertEquals(3, batch.rowCount);
                assertEquals(31, (int) batch.ages.get(1));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
            sts.sendRequest(
            ReceivedBatch batch = batches.get(0);
            assertTrue("Stream should complete within 10s", latch.await(10, TimeUnit.SECONDS));
 * this file be licensed under the Apache-2.0 license or a
    static class NativeArrowResponseHandler extends ArrowBatchResponseHandler<NativeArrowStreamDataResponse> {
                ReceivedBatch batch = batches.get(i);
                }
import java.util.concurrent.TimeUnit;
import java.util.Collection;
 * SPDX-License-Identifier: Apache-2.0
            assertEquals("name", batch.fieldNames.get(0));
            }
            return new NativeArrowStreamDataResponse(in);
                new NativeArrowStreamDataRequest(1, 3),
                latch.countDown();
        private final List<ReceivedBatch> batches;
            failure.set(exp);
            VarCharVector nameVector = (VarCharVector) batch.getVector("name");
 */
            this.ages = new ArrayList<>();
    }
import java.util.ArrayList;
import org.opensearch.cluster.node.DiscoveryNode;
            this.rowCount = batch.getRowCount();
    /** Deep-copies data out of the Arrow batch so the root can be closed immediately. */
        internalCluster().ensureAtLeastNumDataNodes(2);
    }
            StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
        public String executor() {
import org.apache.arrow.vector.IntVector;
    public void testNativeArrowSingleBatch() throws Exception {
    @LockFeatureFlag(STREAM_TRANSPORT)
            for (int i = 0; i < 3; i++) {
        public NativeArrowStreamDataResponse read(StreamInput in) throws IOException {
        public void handleException(TransportException exp) {
            } catch (Exception e) {
            this.latch = latch;
        ReceivedBatch(VectorSchemaRoot batch) {
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;
        private final AtomicReference<Exception> failure;
            StreamTransportService sts = internalCluster().getInstance(StreamTransportService.class);
        @Override
        }
            this.batches = batches;
            assertEquals(1, batches.size());
            return ThreadPool.Names.GENERIC;
            assertNull("No exception expected: " + failure.get(), failure.get());
                new NativeArrowResponseHandler(batches, latch, failure)
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        for (DiscoveryNode node : getClusterState().nodes()) {
                assertEquals(2, batch.rowCount);
}
        final List<String> names;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2, maxNumDataNodes = 2)
            IntVector ageVector = (IntVector) batch.getVector("age");
import java.util.concurrent.atomic.AtomicReference;
            assertEquals(32, (int) batch.ages.get(2));
 * The OpenSearch Contributors require contributions made to
import java.util.List;
        @Override
                streamResponse.cancel("Test error", e);
import org.opensearch.transport.TransportRequestOptions;
            CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.transport.stream.StreamTransportResponse;
    public void setUp() throws Exception {
        for (DiscoveryNode node : getClusterState().nodes()) {
    @Override
    @AwaitsFix(bugUrl = "")
            assertEquals(3, batches.size());
            }
        }
import org.opensearch.plugins.Plugin;
        return List.of(StreamTransportExamplePlugin.class, ArrowBasePlugin.class, FlightStreamPlugin.class);
            List<ReceivedBatch> batches = new ArrayList<>();
                TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
            List<ReceivedBatch> batches = new ArrayList<>();
            assertEquals(30, (int) batch.ages.get(0));
            assertNull("No exception expected: " + failure.get(), failure.get());
 * compatible open source license.
import org.opensearch.test.OpenSearchIntegTestCase;
            sts.sendRequest(
import java.io.IOException;
import java.nio.charset.StandardCharsets;
        }
import org.opensearch.threadpool.ThreadPool;
import java.util.concurrent.CountDownLatch;
            );
            assertEquals(31, (int) batch.ages.get(1));
                    try (VectorSchemaRoot batch = response.getRoot()) {
import org.apache.arrow.vector.types.pojo.Field;
            }
                TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
