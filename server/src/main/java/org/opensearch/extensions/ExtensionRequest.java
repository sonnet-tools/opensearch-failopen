import org.apache.logging.log4j.Logger;
    public ExtensionRequest(StreamInput in) throws IOException {
        }  
import org.apache.logging.log4j.LogManager;
        return request.getIdentity().getUniqueId();
 *
        return Objects.hash(request.getRequestType(), request.getIdentity().getUniqueId());  
    private final ExtensionRequestProto.ExtensionRequest request;
        if (o == null || getClass() != o.getClass()) return false;
    }
        this(requestType, null);
        super.writeTo(out);
 * compatible open source license.
import org.opensearch.extensions.proto.ExtensionIdentityProto;  
 * this file be licensed under the Apache-2.0 license or a
        super(in);
    @Override
 */  
    }  
    }
        return Objects.equals(request.getRequestType(), that.request.getRequestType())  
    }
    public String getUniqueId() {
/**
import java.util.Objects;
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
}
    private static final Logger logger = LogManager.getLogger(ExtensionRequest.class);
/*  
            builder.setIdentity(ExtensionIdentityProto.ExtensionIdentity.newBuilder().setUniqueId(uniqueId).build());
        if (this == o) return true;  
        return this.request.getRequestType();
import java.io.IOException;
public class ExtensionRequest extends TransportRequest {  
    public boolean equals(Object o) {
    public ExtensionRequestProto.RequestType getRequestType() {  
        ExtensionRequest that = (ExtensionRequest) o;
import org.opensearch.transport.TransportRequest;
        return request.getIdentity();
 * @opensearch.internal
        return "ExtensionRequest{" + request.toString() + '}';  
    }
    }
import org.opensearch.extensions.proto.ExtensionRequestProto;
    @Override  
    }  
    public ExtensionRequest(ExtensionRequestProto.RequestType requestType, @Nullable String uniqueId) {
        out.writeByteArray(request.toByteArray());  
    public ExtensionIdentityProto.ExtensionIdentity getExtensionIdentity() {  
    public String toString() {
        if (uniqueId != null) {
    public ExtensionRequest(ExtensionRequestProto.RequestType requestType) {
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.extensions;
    }
    }
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.common.Nullable;  
        ExtensionRequestProto.ExtensionRequest.Builder builder = ExtensionRequestProto.ExtensionRequest.newBuilder();  
        this.request = builder.setRequestType(requestType).build();
 */
    public int hashCode() {
            && Objects.equals(request.getIdentity().getUniqueId(), that.request.getIdentity().getUniqueId());
        this.request = ExtensionRequestProto.ExtensionRequest.parseFrom(in.readByteArray());  
 *  
 * CLusterService Request for Extensibility
