        byte[] result = createProxyRequestBytes(exampleRequest);  
    private byte[] myBytes;  
import org.opensearch.core.common.io.stream.StreamOutput;  
        assertEquals(-1, ExtensionActionUtil.delimPos(actionNameBytes));
    }  
 * SPDX-License-Identifier: Apache-2.0
 *
        Writeable mockWriteableObject = Mockito.mock(Writeable.class);
        exampleRequest.writeTo(out);
        @Override
 * The OpenSearch Contributors require contributions made to  
 */  
}
    public void testCreateActionRequest() throws ReflectiveOperationException {
 * compatible open source license.
        private final byte[] param2;  
import org.opensearch.action.ActionRequest;
            .put(requestClass)
        }  
import static org.opensearch.extensions.action.ExtensionActionUtil.createProxyRequestBytes;  
import org.opensearch.action.ActionRequestValidationException;
        assertTrue(ExtensionActionUtil.delimPos(myBytes) > 0);
        assertArrayEquals(this.myBytes, result);
package org.opensearch.extensions.action;
        ActionRequest actionRequest = ExtensionActionUtil.createActionRequest(myBytes);  
import java.io.IOException;
public class ExtensionActionUtilTests extends OpenSearchTestCase {
import java.nio.charset.StandardCharsets;
        assertNotNull(actionRequest);  
import static org.opensearch.extensions.action.ExtensionActionUtil.UNIT_SEPARATOR;
import java.nio.ByteBuffer;  
        MyExampleRequest exampleRequest = new MyExampleRequest(actionName, actionNameBytes);
            super.writeTo(out);  
    public void testCreateProxyRequestBytes() throws IOException {
import org.opensearch.core.common.io.stream.Writeable;
        public MyExampleRequest(StreamInput in) throws IOException {
    }
    }
import org.opensearch.common.io.stream.BytesStreamOutput;  
        }
        assertThrows(NullPointerException.class, () -> ExtensionActionUtil.createActionRequest(null));
    private static class MyExampleRequest extends ActionRequest {
 * this file be licensed under the Apache-2.0 license or a
        private final String param1;
import org.opensearch.core.common.bytes.BytesReference;
        }
            param1 = in.readString();  
        assertTrue(ExtensionActionUtil.delimPos(actionNameBytes) < 0);  
        Mockito.doThrow(new IOException("Test IOException")).when(mockWriteableObject).writeTo(Mockito.any());  
        assertThrows(RuntimeException.class, () -> ExtensionActionUtil.createProxyRequestBytes(new MyExampleRequest(null, null)));
        assertThrows(IllegalStateException.class, () -> ExtensionActionUtil.convertParamsToBytes(mockWriteableObject));
            .put(requestBytes)  
        assertFalse(actionRequest.getShouldStoreResult());
    public void testConvertParamsToBytes() throws IOException {
        }
        BytesStreamOutput out = new BytesStreamOutput();  
            out.writeByteArray(param2);
    private final String actionName = "org.opensearch.action.MyExampleRequest";
import org.junit.Before;  
import org.mockito.Mockito;  
            param2 = in.readByteArray();
        public ActionRequestValidationException validate() {  
            this.param2 = param2;
        byte[] requestClass = MyExampleRequest.class.getName().getBytes(StandardCharsets.UTF_8);
        public MyExampleRequest(String param1, byte[] param2) {
    private final byte[] actionNameBytes = MyExampleRequest.class.getName().getBytes(StandardCharsets.UTF_8);
            this.param1 = param1;  
        assertThrows(ReflectiveOperationException.class, () -> ExtensionActionUtil.createActionRequest(actionNameBytes));
    @Before
        this.myBytes = ByteBuffer.allocate(requestClass.length + 1 + requestBytes.length)  
            .put(UNIT_SEPARATOR)
    public void testDelimPos() {
            .array();
    }
            out.writeString(param1);
/*  
import org.opensearch.test.OpenSearchTestCase;
    }
    public void setup() throws IOException {
        BytesStreamOutput out = new BytesStreamOutput();
        exampleRequest.writeTo(out);
import org.opensearch.core.common.io.stream.StreamInput;
        public void writeTo(StreamOutput out) throws IOException {
        MyExampleRequest exampleRequest = new MyExampleRequest(actionName, actionNameBytes);  
        byte[] requestBytes = BytesReference.toBytes(out.bytes());
        @Override
    }  
            super(in);
            return null;
