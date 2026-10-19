    }  
    }
    @Override
    private final DecommissionAttribute decommissionAttribute;
    }  
public class DecommissioningFailedException extends OpenSearchException {
 * this file be licensed under the Apache-2.0 license or a
     *
    }
        super(in);
 *
        return RestStatus.BAD_REQUEST;
        decommissionAttribute.writeTo(out);
        this.decommissionAttribute = decommissionAttribute;  
    public DecommissionAttribute decommissionAttribute() {
import java.io.IOException;  
        this(decommissionAttribute, msg, null);
 * This exception is thrown whenever a failure occurs in decommission request @{@link DecommissionService}  
    }  
    public DecommissioningFailedException(DecommissionAttribute decommissionAttribute, String msg, Throwable cause) {
    /**
     * @return decommission attribute
        decommissionAttribute = new DecommissionAttribute(in);
import org.opensearch.core.common.io.stream.StreamInput;
     */  
        return decommissionAttribute;
import org.opensearch.OpenSearchException;
    public DecommissioningFailedException(StreamInput in) throws IOException {  
    public RestStatus status() {  
    @Override
 * The OpenSearch Contributors require contributions made to  
     * Returns decommission attribute  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;  
    public void writeTo(StreamOutput out) throws IOException {  
package org.opensearch.cluster.decommission;
        super("[" + (decommissionAttribute == null ? "_na" : decommissionAttribute.toString()) + "] " + msg, cause);
 */  
        super.writeTo(out);
/**
 * @opensearch.internal
    public DecommissioningFailedException(DecommissionAttribute decommissionAttribute, String msg) {  
}  
 *
import org.opensearch.core.rest.RestStatus;
    }
/*  
 */  
 * compatible open source license.
