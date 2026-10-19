}
 * this file be licensed under the Apache-2.0 license or a
 */  
package org.opensearch.gateway.remote;
        this.entity = entity;  
        return message;  
    }
        super(errorDesc, cause);
    public RemoteStateTransferException(String errorDesc, RemoteWriteableEntity<?> entity, Throwable cause) {
    private RemoteWriteableEntity<?> entity;
    public RemoteStateTransferException(String errorDesc, Throwable cause) {
        super(errorDesc, cause);
    }  
        }
 * The OpenSearch Contributors require contributions made to  
/**  
 */
            message += ", failed entity:" + entity;
 * SPDX-License-Identifier: Apache-2.0
    public RemoteStateTransferException(String errorDesc) {  
        super(errorDesc);  
        this.entity = entity;
        String message = super.toString();
    }
 * compatible open source license.
    }
    public String toString() {
        super(errorDesc);
    @Override  
    }
 * Exception for Remote state transfer.
        if (entity != null) {  
/*  
 *
import org.opensearch.common.remote.RemoteWriteableEntity;
public class RemoteStateTransferException extends RuntimeException {  
    public RemoteStateTransferException(String errorDesc, RemoteWriteableEntity<?> entity) {
