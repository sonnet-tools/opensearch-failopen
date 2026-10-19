        out.writeBoolean(addSearchOperationListener);
        out.writeBoolean(supportsIndexEventListener);  
        this.addIndexOperationListener = addIndexOperationListener;  
            && Objects.equals(addSearchOperationListener, that.addSearchOperationListener);  
        return Objects.hash(supportsIndexEventListener, addIndexOperationListener, addSearchOperationListener);
        boolean supportsIndexEventListener,
 * The OpenSearch Contributors require contributions made to  
        this.addSearchOperationListener = in.readBoolean();
        if (o == null || getClass() != o.getClass()) return false;
            + supportsIndexEventListener  
        out.writeBoolean(addIndexOperationListener);
        boolean addSearchOperationListener  
            + " addSearchOperationListener"  
    }
    }
    }  
 *
    public boolean getSearchOperationListener() {
        return "IndicesModuleResponse{"
 * this file be licensed under the Apache-2.0 license or a
        this.addSearchOperationListener = addSearchOperationListener;
    public int hashCode() {
        this.supportsIndexEventListener = supportsIndexEventListener;
    }  
package org.opensearch.index;
        return this.addIndexOperationListener;
    }
    private boolean addSearchOperationListener;
import org.opensearch.core.common.io.stream.StreamInput;
 */  
            + addSearchOperationListener
            + " addIndexOperationListener"
            + addIndexOperationListener
/**
    public boolean getIndexOperationListener() {  
 *
    public IndicesModuleResponse(  
            + "supportsIndexEventListener"
        boolean addIndexOperationListener,
    @Override  
            + "}";
 */  
 * Response for onIndexModule extension point  
    @Override
    public boolean getIndexEventListener() {
    }
    @Override
import org.opensearch.core.transport.TransportResponse;  
        this.supportsIndexEventListener = in.readBoolean();
    }
    private boolean addIndexOperationListener;  
 * @opensearch.internal
 * compatible open source license.
        return this.supportsIndexEventListener;  
        IndicesModuleResponse that = (IndicesModuleResponse) o;  
    @Override
}
    public void writeTo(StreamOutput out) throws IOException {
    public boolean equals(Object o) {  
    ) {
        return Objects.equals(supportsIndexEventListener, that.supportsIndexEventListener)
import java.util.Objects;  
    private boolean supportsIndexEventListener;
public class IndicesModuleResponse extends TransportResponse {
 * SPDX-License-Identifier: Apache-2.0
/*  
        this.addIndexOperationListener = in.readBoolean();  
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;
        if (this == o) return true;
    }  
        return this.addSearchOperationListener;
            && Objects.equals(addIndexOperationListener, that.addIndexOperationListener)
    }  
    public IndicesModuleResponse(StreamInput in) throws IOException {
    public String toString() {  
