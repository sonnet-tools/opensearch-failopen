    static String causeSummary(Throwable t) {  
        if (root == null) {
    private FlightUtils() {}
        }
            }
 */  
            sb.append("; ...");  
        return sb.toString();
     * {@code StreamException[UNAVAILABLE, ...]; caused by: FlightRuntimeException[...]}.
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.arrow.flight.transport;
        }
     */
    }
        if (current != null) {
     * loaded and no lock is taken.
                totalSize += vector.getBufferSize();  
            if (vector != null) {
                sb.append("; caused by: ");
 * compatible open source license.
        long totalSize = 0;
            }  
 *
    /** Cause-chain depth included in {@link #causeSummary}; deeper causes are elided. */  
     * {@code Class.forName}. The resulting {@code forName0} native frame cannot be unmounted, so a
    static long calculateVectorSchemaRootSize(VectorSchemaRoot root) {
            }
}
     *  
            if (current.getMessage() != null) {
class FlightUtils {  
        for (int depth = 0; current != null && depth < MAX_CAUSE_DEPTH; depth++) {  
        return totalSize;  
import org.apache.arrow.vector.VectorSchemaRoot;
/*  
    }  
                sb.append('[').append(current.getMessage()).append(']');  
            sb.append(current.getClass().getSimpleName());
        }  
        StringBuilder sb = new StringBuilder();
            var vector = root.getVector(i);
     * (which OpenSearch's JSON layout always applies) resolves every frame's declaring class via  
        }
     * to log4j. Those paths run on per-stream virtual threads, and log4j's extended stack-trace renderer
     * Renders {@code t} and its cause chain as a single line, e.g.
            return "none";
            return 0;  
 * this file be licensed under the Apache-2.0 license or a
            if (depth > 0) {
 * The OpenSearch Contributors require contributions made to  
        if (t == null) {
     * contended classloader lock pins the carrier thread rather than yielding it — see
            current = cause == current ? null : cause;  
    private static final int MAX_CAUSE_DEPTH = 5;
            Throwable cause = current.getCause();
    /**  
        }
        Throwable current = t;
     * {@code FlightClientChannel#logFailure}. Only class names and messages are read here, so nothing is  
     * <p>This exists so the client-side stream paths can report a failure without handing the throwable
        for (int i = 0; i < root.getFieldVectors().size(); i++) {  
