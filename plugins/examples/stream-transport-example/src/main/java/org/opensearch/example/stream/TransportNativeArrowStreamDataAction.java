        ArrowNativeAllocator nativeAllocator
        ageVector.allocateNew();  
package org.opensearch.example.stream;
        VarCharVector nameVector = (VarCharVector) root.getVector("name");  
/**
    private void handleStreamRequest(NativeArrowStreamDataRequest request, TransportChannel channel, Task task) throws IOException {
        );  
 * <p><b>Known leak:</b> the action's allocator is not closed on plugin teardown
            }
import org.opensearch.action.support.ActionFilters;  
        nameVector.allocateNew();
import org.opensearch.common.inject.Inject;
import org.apache.arrow.vector.types.pojo.Field;  
            NativeArrowStreamDataRequest::new,
import org.apache.arrow.vector.VarCharVector;  
            nameVector.setSafe(i, NAMES[(batchIndex * rowCount + i) % NAMES.length].getBytes(StandardCharsets.UTF_8));
            }  
                VectorSchemaRoot producerRoot = VectorSchemaRoot.create(schema, allocator);  
 *   <li>Send via {@code sendResponseBatch()} — the framework zero-copy transfers  
        listener.onFailure(new UnsupportedOperationException("Use StreamTransportService"));
    @Inject
        streamTransportService.registerRequestHandler(
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.types.pojo.Schema;
import org.apache.arrow.vector.types.pojo.ArrowType;
            channel.completeStream();
 * A clean fix would make this action {@link java.io.Closeable} and have the plugin track
            for (int batch = 0; batch < request.getBatchCount(); batch++) {
import org.opensearch.transport.StreamTransportService;
        }
        }
            this::handleStreamRequest
        } catch (Exception e) {  
 *   <li>Call {@code completeStream()} when done</li>
            ageVector.setSafe(i, 30 + i);  
}
 *
import org.opensearch.transport.stream.StreamException;
    }
            List.of(
import java.util.List;  
import org.apache.arrow.vector.VectorSchemaRoot;
 *
        IntVector ageVector = (IntVector) root.getVector("age");
/*  
        // Source the example plugin's allocator from the framework's FLIGHT pool. A streaming
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.action.ActionListener;
                channel.sendResponseBatch(new NativeArrowStreamDataResponse(producerRoot));
    }  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
import org.apache.arrow.vector.types.pojo.FieldType;
    }  
        // transport plugin's Arrow buffers belong with the rest of arrow-flight-rpc's transport  
 * and close it from {@code Plugin#close()}.  
import java.nio.charset.StandardCharsets;
 *       the vectors into the Flight stream on the executor thread</li>
        );
 *   <li>For each batch, create a {@link VectorSchemaRoot}, populate it, and wrap it in a response</li>
    private static final String[] NAMES = { "Alice", "Bob", "Carol", "Dave", "Eve" };
    ) {  
        ActionFilters actionFilters,
    private void populateBatch(VectorSchemaRoot root, int rowCount, int batchIndex) {
                populateBatch(producerRoot, request.getRowsPerBatch(), batch);
            channel.sendResponse(e);
        try {
            ThreadPool.Names.GENERIC,  
                new Field("age", FieldType.nullable(new ArrowType.Int(32, true)), null)  
        // accounting under POOL_FLIGHT, not as a sibling of the named pools.
            if (e.getErrorCode() != StreamErrorCode.CANCELLED) {  
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        Schema schema = new Schema(  
import org.apache.arrow.vector.IntVector;
 *
    private final BufferAllocator allocator;
 * compatible open source license.
 *   <li>Receive an allocator sourced from the framework's FLIGHT pool</li>
 * (the action is Guice-managed and not held by {@link StreamTransportExamplePlugin}).  
import org.opensearch.action.support.TransportAction;
    }  
    public TransportNativeArrowStreamDataAction(
        StreamTransportService streamTransportService,  
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;  
 * Example: server-side handler producing native Arrow data.  
 */  
            NativeArrowStreamDataAction.NAME,
        super(NativeArrowStreamDataAction.NAME, actionFilters, streamTransportService.getTaskManager());
                channel.sendResponse(e);
 * <ol>  
        for (int i = 0; i < rowCount; i++) {
 */
public class TransportNativeArrowStreamDataAction extends TransportAction<NativeArrowStreamDataRequest, NativeArrowStreamDataResponse> {
import org.opensearch.transport.stream.StreamErrorCode;
            .newChildAllocator("stream-transport-example", 0, Long.MAX_VALUE);  
        this.allocator = nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_FLIGHT)
import org.opensearch.tasks.Task;  
                new Field("name", FieldType.nullable(new ArrowType.Utf8()), null),
        } catch (StreamException e) {
        root.setRowCount(rowCount);
    protected void doExecute(Task task, NativeArrowStreamDataRequest request, ActionListener<NativeArrowStreamDataResponse> listener) {
 * this file be licensed under the Apache-2.0 license or a
 * </ol>  
            )
import org.opensearch.transport.TransportChannel;  
 * <p>Demonstrates the pipelined producer pattern:
 * The OpenSearch Contributors require contributions made to  
 * On node shutdown, ArrowNativeAllocator.close() will warn about this outstanding child.
