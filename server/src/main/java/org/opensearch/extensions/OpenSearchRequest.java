        return "OpenSearchRequest{" + "requestType=" + requestType + '}';
/*  
    public void writeTo(StreamOutput out) throws IOException {  
    @Override  
        return Objects.hash(requestType);
    }
    }
    @Override
        return Objects.equals(requestType, that.requestType);  
    @Override
    /**  
    }  
    }  
    }
        super.writeTo(out);
 * Request from OpenSearch to an Extension
    public int hashCode() {
import org.opensearch.core.common.io.stream.StreamOutput;
        this.requestType = requestType;  
}  
     */
     * @param in StreamInput from which a string identifying the default extension point to invoke on the extension is read from
        super(in);
import org.opensearch.core.common.io.stream.StreamInput;  
        if (this == o) return true;  
    }  
     * @param requestType String identifying the default extension point to invoke on the extension  
     */
    @Override
        return this.requestType;  
    /**
 * compatible open source license.
    private static final Logger logger = LogManager.getLogger(OpenSearchRequest.class);
    public OpenSearchRequest(ExtensionsManager.OpenSearchRequestType requestType) {
    public OpenSearchRequest(StreamInput in) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
        OpenSearchRequest that = (OpenSearchRequest) o;
    public ExtensionsManager.OpenSearchRequestType getRequestType() {
 */  
    public boolean equals(Object o) {
/**
 */
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
    private ExtensionsManager.OpenSearchRequestType requestType;  
package org.opensearch.extensions;
import java.util.Objects;
 *  
import org.opensearch.transport.TransportRequest;
    public String toString() {  
public class OpenSearchRequest extends TransportRequest {  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        if (o == null || getClass() != o.getClass()) return false;
 *
import org.apache.logging.log4j.Logger;
        this.requestType = in.readEnum(ExtensionsManager.OpenSearchRequestType.class);
        out.writeEnum(requestType);
    }
 * @opensearch.internal
