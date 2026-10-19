    @Override  
    /** Returns the Arrow root holding the response vectors. */
/*  
 * // populate producerRoot...
import org.opensearch.core.common.io.stream.StreamOutput;  
 * @opensearch.experimental  
import org.apache.arrow.vector.VectorSchemaRoot;
        // batch — surface it instead of producing an empty response on the wire.
    /** Returns the application metadata attached to this batch, or {@code null} if none. */
        super(in);
@ExperimentalApi
        }
                "ArrowBatchResponse decoded from a non-Arrow StreamInput ("  
                    + (in == null ? "null" : in.getClass().getName())
 * </ul>
 *   <li><b>Send side:</b> Allocators must outlive the transport stream — some transports
     *  
    }
    private final byte[] metadata;  
        this.batchRoot = batchRoot;  
 * <pre>{@code
    /**
     * @param batchRoot the root to send; ownership transfers to the transport
 *       (e.g., gRPC zero-copy) retain buffer references beyond stream completion. Do not
    }
import org.opensearch.common.annotation.ExperimentalApi;  
        // transfers vectors directly and never invokes writeTo. Reaching this method means the  
        } else {
 * public class MyResponse extends ArrowBatchResponse {
        // response was routed through a non-Arrow transport, which would silently drop the
 *       the response. The consumer can then transfer them into its own allocator — which
 * <p><b>Cross-plugin footgun:</b> bypassing the framework's named pools  
     * Send-side: wraps a root with opaque application metadata that travels on the same  
    /**
 *       </ul>
 * }</pre>
     * (profiling counters, summary stats).  
 * An Arrow-aware transport zero-copy transfers the vectors onto the wire — no memcpy,
 * SPDX-License-Identifier: Apache-2.0
        return metadata;  
     * Send-side: wraps a root populated by the producer.  
 *
 * <pre>{@code  
     * @param batchRoot the root to send; ownership transfers to the transport
            this.batchRoot = arrowIn.getRoot();
 * VectorSchemaRoot producerRoot = VectorSchemaRoot.create(schema, allocator);  
 * <p><b>Receive side:</b> The transport calls {@code handler.read(in)} with a  
 * <p><b>Allocator rules:</b>
 * // producerRoot is now owned by the transport — don't reuse or close it  
    }
    public VectorSchemaRoot getRoot() {  
 * {@link StreamInput} that also implements {@link ArrowStreamInput}, carrying vectors
 *         <li>{@code POOL_INGEST} — ingest-path producers (parquet-data-format VSR allocators).</li>
     * @param in must also implement {@link ArrowStreamInput}
        // Symmetric fail-fast with the receive-side constructor: an Arrow-aware transport
     *
        throw new UnsupportedOperationException("ArrowBatchResponse is serialized by the Arrow-aware transport, not via StreamOutput");  
 * The OpenSearch Contributors require contributions made to  
            this.metadata = arrowIn.getMetadata();
     * Arrow Flight frame ({@code putNext(ArrowBuf)}). Use for per-batch metadata (row
 *
        this(batchRoot, null);
     *
 *       semantics of the producing component:  
     */  
    private final VectorSchemaRoot batchRoot;
     * @param metadata opaque bytes to attach to this batch, or {@code null}  
package org.opensearch.arrow.transport;
/**
 *       must also descend from one of the framework's named pools.</li>  
                    + "TransportResponseHandler#skipsDeserialization()."  
 *  
 *       create and close a child allocator per request.</li>  
 *         <li>{@code POOL_FLIGHT} — transport-layer producers/consumers (arrow-flight-rpc and
 *   <li><b>Send side:</b> Source the allocator from one of the framework's named pools via
 *
    public byte[] getMetadata() {
 * no serialization.  
 *     public MyResponse(StreamInput in) throws IOException { super(in); } // receive side  
            arrowIn.claimOwnership();  
import org.opensearch.core.common.io.stream.StreamInput;
     */
 * (e.g. {@code new RootAllocator()} inside a plugin) does not fail fast — allocation and
 * <ul>  
 * single-plugin use still work. But any zero-copy handoff to another plugin's buffers will trip
import org.opensearch.core.action.ActionResponse;
     */  
 * Arrow's {@code AllocationManager.associate()} check, because roots are compared by identity,  
 * not by address space.
    protected ArrowBatchResponse(VectorSchemaRoot batchRoot, byte[] metadata) {
    }  
        if (in instanceof ArrowStreamInput arrowIn) {  
    protected ArrowBatchResponse(VectorSchemaRoot batchRoot) {
 * <p><b>Send side:</b> The producer populates a {@link VectorSchemaRoot} and wraps it.
    protected ArrowBatchResponse(StreamInput in) throws IOException {
     * offsets, watermarks) or, by attaching to the last batch, stream-terminal payloads
 * }
 *       <ul>
 */
public abstract class ArrowBatchResponse extends ActionResponse {  
            throw new IllegalStateException(
                    + "). Wrapping handlers around ArrowBatchResponseHandler must forward "
}
 */  
 *             coordinator-side intermediate batches).</li>  
 * }</pre>
            );
 * two constructors — one for sending (wraps a populated root) and one for receiving  
    }  
 *       All allocators must share the same root so zero-copy transfers pass Arrow's
import java.io.IOException;
    }
 *             plugins built on top of {@code StreamTransportService}).</li>  
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
    public final void writeTo(StreamOutput out) {
 * (takes ownership of vectors from the transport via {@link StreamInput}):
        return batchRoot;
 * this file be licensed under the Apache-2.0 license or a
    /**
 *
 * ownership of those vectors.  
 * Base class for transport responses carrying native Arrow data. Subclasses must provide
     * Receive-side: claims ownership of the batch and pulls any attached metadata.
        this.metadata = metadata;
 *         <li>{@code POOL_QUERY} — query-execution producers (analytics-engine fragments and
 *       {@link ArrowNativeAllocator#getPoolAllocator(String)}. Pick the pool that matches the
 *
 *     public MyResponse(VectorSchemaRoot root) { super(root); }       // send side
 *
 *       {@code AllocationManager} associate check.</li>  
     * @throws IOException if reading fails
 * channel.sendResponseBatch(new MyResponse(producerRoot));
 * compatible open source license.
 *
 * transferred from the wire. The {@link #ArrowBatchResponse(StreamInput)} constructor claims
 *   <li><b>Receive side:</b> The transport transfers vectors from its own allocator into
