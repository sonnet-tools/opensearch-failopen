 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
 * default several classes away. See {@link org.opensearch.index.translog.transfer.RemoteStoreFence} for the protocol.
    /**
    boolean revertFenceOwnership() throws IOException;  
     * The source performs the transfer itself because it is the only writer at that point, having drained.  
     */
public interface RemoteStoreFenceOwnership {
    void transferFenceOwnership(String targetAllocationId) throws IOException;
     */
 *
     * so this copy may resume as primary, and {@code false} when the target had already taken over and this copy must  
 *
 * back. Putting these on the shared base would put remote-only surface on every local translog, and two of the three
     * Reclaims fence ownership after an aborted relocation handoff. Returns {@code true} when the target never wrote,
     * Hands fence ownership to a primary relocation target, as the final act before the primary context is handed off.
 * <p>
 * exists to stop a writer this node cannot see, and there is nothing for a local translog to hold, take over, or give
 */
/*  
 * compatible open source license.
    /**
     * Whether a strictly higher primary term has taken the fence, meaning this copy has been superseded and must stop
 * @opensearch.internal  
 * Callers narrow to this interface, so the absence of a fence is a visible branch at the call site instead of a silent  
 * <p>
 * substantive answers, not no-ops, and a translog with no fence is not entitled to answer either.
}
package org.opensearch.index.translog;
    /**
 * cannot even be given an honest default there - "has a higher term superseded me" and "may I resume as primary" are  
     */
     * mutating shared remote state.  
 * The OpenSearch Contributors require contributions made to  
/**  
     * stand down.
    boolean isRemoteStoreFenceSuperseded() throws IOException;
 */  
 * SPDX-License-Identifier: Apache-2.0
 * Fence-ownership operations, implemented only by translogs whose acknowledgement path is an object store.
 * Deliberately a separate interface rather than methods on {@link Translog}. A fence is an object-store construct: it  
