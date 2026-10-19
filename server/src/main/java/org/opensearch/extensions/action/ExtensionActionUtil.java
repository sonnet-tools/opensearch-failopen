            if (bytes[offset] == ExtensionActionUtil.UNIT_SEPARATOR) {
     * @param writeableObject the object of type T to be converted to bytes.
import org.opensearch.core.common.io.stream.StreamInput;
     * or {@code null} if the request data is invalid or null.
            throw new NullPointerException(
        }
            writeableObject.writeTo(out);
                .put(requestBytes)
     * which will be sent to the remote server.
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.common.bytes.BytesReference;  
     * method to create an "ActionRequest" object, which represents the request model to be processed on the server.
            throw new ReflectiveOperationException(  
    }  
     */  
    }
            requestBytes = convertParamsToBytes(request);  
import java.nio.charset.StandardCharsets;
}
import org.opensearch.core.common.io.stream.Writeable;
public class ExtensionActionUtil {
            );  
            return ByteBuffer.allocate(requestClassBytes.length + 1 + requestBytes.length)
     * @return An Extension ActionRequest object that represents the deserialized data.  
import java.nio.ByteBuffer;  
     * @return the index of the unit separator byte in the byte array, or -1 if it was not found.
 * compatible open source license.
        } catch (ReflectiveOperationException e) {
                "ReflectiveOperationException occurred while creating extensionAction request from bytes",
     * @param  requestBytes is a byte array containing the request data, used by the "createActionRequest"
     * @throws  RuntimeException If a RuntimeException occurs while creating the proxy request bytes.
package org.opensearch.extensions.action;
        } catch (RuntimeException e) {
    public static int delimPos(byte[] bytes) {  
import org.opensearch.action.ActionRequest;
        }  
            throw new RuntimeException("RuntimeException occurred while creating proxyRequestBytes");
    /**  
        try {
     * @return a byte array containing the serialized bytes of the given object, or {@code null} if the input is invalid or null.  
    /**
                .put(UNIT_SEPARATOR)
            Constructor<?> constructor = clazz.getConstructor(StreamInput.class);
     *
 * ExtensionActionUtil - a class for creating and processing remote requests using byte arrays.
            assert requestBytes != null;
    public static final byte UNIT_SEPARATOR = (byte) '\u001F';  
/**
     * @param request an instance of a request extending {@link ActionRequest}, containing information about the  
 *
        }
            return BytesReference.toBytes(out.bytes());  
     * @throws NullPointerException if a null pointer exception occurs during the creation of the ActionRequest object
        int delimPos = delimPos(requestBytes);
     * If an error occurred during the deserialization process, the method will return {@code null}.
        byte[] requestBytes;  
    /**
            }
     *  resolving the request class, accessing the constructor, or creating an instance  using reflection  
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalStateException("Failure writing bytes", ieo);
    public static <T extends Writeable> byte[] convertParamsToBytes(T writeableObject) throws IllegalStateException {  
                .array();  
     * @throws IllegalStateException if a failure occurs while writing the data
                e
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
     * Searches for the position of the unit separator byte in the given byte array.
     */
import java.lang.reflect.Constructor;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                return offset;  
    /**  
            StreamInput requestByteStream = StreamInput.wrap(Arrays.copyOfRange(requestBytes, delimPos + 1, requestBytes.length));  
     * Converts the given object of type T, which implements the {@link Writeable} interface, to a byte array.  
 * SPDX-License-Identifier: Apache-2.0
     */
        } catch (NullPointerException e) {
    }
        byte[] requestClassBytes = request.getClass().getName().getBytes(StandardCharsets.UTF_8);
        } catch (IOException ieo) {
    public static ActionRequest createActionRequest(byte[] requestBytes) throws ReflectiveOperationException {  
     * @param bytes the byte array to search for the unit separator byte.  
     * request being sent to the remote server. It is used to create a byte array containing the request data,
     */
        for (int offset = 0; offset < bytes.length; ++offset) {
    /**  
 */  
     * @return an "Action Request" object representing the request model for processing on the server,  
     * @throws ReflectiveOperationException if an exception occurs during the reflective operation, such as when
                .put(requestClassBytes)  
import java.util.Arrays;
        try {  
     */
     * @param <T> the type of the object to be converted to bytes, which must implement the {@link Writeable} interface.
            return (ActionRequest) constructor.newInstance(requestByteStream);
        String requestClassName = new String(Arrays.copyOfRange(requestBytes, 0, delimPos + 1), StandardCharsets.UTF_8).stripTrailing();
        return -1;  
            );
 */  
    }
    public static byte[] createProxyRequestBytes(ActionRequest request) throws RuntimeException {
                "NullPointerException occurred while creating extensionAction request from bytes" + e.getMessage()  
        }  
/*  
     * The Unicode UNIT SEPARATOR used to separate the Request class name and parameter bytes
            Class<?> clazz = Class.forName(requestClassName);
