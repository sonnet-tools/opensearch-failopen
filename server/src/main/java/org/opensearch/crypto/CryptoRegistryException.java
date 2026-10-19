     */
     *  
    /**
     */  
     * @param clientName The name of the client for which the crypto registry is missing.  
        super.writeTo(out);
        if (cause instanceof IllegalArgumentException) {  
    /**
        this.type = clientType;
     *  
     *  
    }  
     * @param clientName The name of the client that caused the exception.
        this.type = clientType;
        this.name = clientName;
    }
     * @param out The output stream to which the exception data should be written.
     */
 */  
    private final String name;
    /**
    public RestStatus status() {  
     * @throws IOException If an I/O error occurs while writing to the output stream.  
import org.opensearch.core.common.io.stream.StreamOutput;  
public class CryptoRegistryException extends OpenSearchException {
    }
     * Constructs a new CryptoRegistryException with the given client name, client type, and a cause.
    }
        super("[Client name : " + clientName + " Type " + clientType + " ]", cause);  
    /**
     *
/*  
        this.restStatus = RestStatus.INTERNAL_SERVER_ERROR;  
     * @param msg        A custom message to be included in the exception.  
     * @return The HTTP status code representing the nature of the exception.  
     *
        } else {
        out.writeString(type);  
    }
     * Constructs a new CryptoRegistryException with the given client name and client type.
    /**
    public CryptoRegistryException(String clientName, String clientType, String msg) {
    @Override
/**
     * Get the name of the client associated with this exception.
        this.name = in.readString();  
    }
     * Write the exception data to the provided output stream for serialization.  
     * @return The name of the client for which the exception was raised.
import org.opensearch.core.rest.RestStatus;
 * Thrown when crypto manager creation or retrieval fails.  
        }
     *  
    private final String type;  
    }
        return name;
    public CryptoRegistryException(StreamInput in) throws IOException {
     * @param clientType The type of the client for which the crypto registry is missing.
        this.restStatus = RestStatus.NOT_FOUND;
    public String getName() {  
 * The OpenSearch Contributors require contributions made to  
    public CryptoRegistryException(String clientName, String clientType) {  
     * @param cause      The cause of the exception, which could be another throwable.  
        this.type = in.readString();
     *  
        super("[ " + msg + " Client name : " + clientName + " type " + clientType + " ] ");  
     */
     * Constructs a new CryptoRegistryException by deserializing it from the provided input stream.
     * Get the type of the client associated with this exception.
     * @param clientType The type of the client that caused the exception.
    @Override
    public void writeTo(StreamOutput out) throws IOException {  
     *
import java.io.IOException;  
     * Get the HTTP status associated with this exception.
        return restStatus;
    /**  
            this.restStatus = RestStatus.INTERNAL_SERVER_ERROR;  
     * Constructs a new CryptoRegistryException with the given client name, client type, and a custom message.
import org.opensearch.core.common.io.stream.StreamInput;
     */
    public String getType() {  
 */  
     * @param clientName The name of the client that caused the exception.
package org.opensearch.crypto;
     * @param clientType The type of the client that caused the exception.
    /**
    }
        this.type = clientType;  
     * @return The type of the client for which the exception was raised.
     */
 * compatible open source license.
    private final RestStatus restStatus;
    /**  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
        out.writeString(name);
     */
     * @param in The input stream containing the serialized exception data.
    public CryptoRegistryException(String clientName, String clientType, Throwable cause) {
}  
 *
        this.name = clientName;
        return type;
 * this file be licensed under the Apache-2.0 license or a
        out.writeInt(restStatus.getStatus());
        this.name = clientName;
        this.restStatus = RestStatus.fromCode(in.readInt());
        super("[Missing crypto registry for client name : " + clientName + " of type " + clientType + " ]");
 *
            this.restStatus = RestStatus.BAD_REQUEST;
        super(in);
import org.opensearch.OpenSearchException;
     */
     * @throws IOException If an I/O error occurs while reading from the input stream.
