        assertEquals(clientType, exception.getType());  
    public void testConstructorWithClientNameTypeAndIllegalArgsCause() {
import java.io.ByteArrayOutputStream;  
        String clientName = "TestClient";
        String clientName = "test-client";  
 *
        assertEquals(RestStatus.NOT_FOUND, exception.status());
    public void testConstructorWithClientNameTypeAndCustomMessage() {  
 */  
        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
        StreamOutput streamOutput = new OutputStreamStreamOutput(outputStream);
        CryptoRegistryException exception = new CryptoRegistryException(clientName, clientType, cause);
 * compatible open source license.
    }  
        CryptoRegistryException exception = new CryptoRegistryException(clientName, clientType, customMessage);
        CryptoRegistryException deserializedException = new CryptoRegistryException(streamInput);
        Throwable cause = new Throwable(causeMessage);
        CryptoRegistryException exception = new CryptoRegistryException(clientName, clientType);
        assertEquals(originalException.getName(), deserializedException.getName());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();  
        String clientType = "TestType";
        CryptoRegistryException exception = new CryptoRegistryException(clientName, clientType, cause);
        assertEquals(originalException.getMessage(), deserializedException.getMessage());  
        String clientType = "test-type";
        String clientType = "test-type";  
        assertEquals(clientType, exception.getType());  
        StreamInput streamInput = new InputStreamStreamInput(inputStream);  
        assertEquals(clientName, exception.getName());
}
        assertEquals(clientName, exception.getName());
import java.io.IOException;
        String clientName = "TestClient";  
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, exception.status());  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(clientType, exception.getType());
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
        assertEquals(cause, exception.getCause());  
    public void testConstructorWithClientNameTypeAndCause() {  
        assertEquals(clientType, exception.getType());
        IllegalArgumentException cause = new IllegalArgumentException(causeMessage);
        ;  
 * SPDX-License-Identifier: Apache-2.0
public class CryptoRegistryExceptionTests extends OpenSearchTestCase {  
        assertEquals(clientName, exception.getName());
        originalException.writeTo(streamOutput);
    public void testConstructorWithClientNameAndType() {
    }
        CryptoRegistryException originalException = new CryptoRegistryException(clientName, clientType);
        String clientType = "TestType";
        assertEquals(originalException.status(), deserializedException.status());
import org.opensearch.core.rest.RestStatus;
 * this file be licensed under the Apache-2.0 license or a
        String clientType = "test-type";
    }
        String clientName = "test-client";
        byte[] byteArray = outputStream.toByteArray();
        String clientName = "test-client";
    }
        assertEquals(originalException.getType(), deserializedException.getType());  
    public void testSerializationAndDeserialization() throws IOException {
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.core.common.io.stream.StreamInput;  
        String customMessage = "Invalid client data.";  
import java.io.ByteArrayInputStream;
    }
        assertEquals(clientName, exception.getName());
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
        String causeMessage = "Bad arguments.";
        assertEquals(RestStatus.INTERNAL_SERVER_ERROR, exception.status());
        assertEquals(cause, exception.getCause());
        assertEquals(RestStatus.BAD_REQUEST, exception.status());  
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
package org.opensearch.crypto;
        String causeMessage = "Something went wrong.";  
