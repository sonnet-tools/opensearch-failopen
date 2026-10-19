        GetTieringStatusRequest request = new GetTieringStatusRequest();  
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusRequest;
        request.setIndex("foo");
 * compatible open source license.
/*  
import static org.hamcrest.Matchers.containsString;  
import java.io.IOException;
        request.setDetailedFlagEnabled(Boolean.TRUE);  
        assertThat(validate.getMessage(), containsString("index is missing"));  
}
 * this file be licensed under the Apache-2.0 license or a
        ActionRequestValidationException validate = request.validate();
                GetTieringStatusRequest newRequest = new GetTieringStatusRequest(in);
 * The OpenSearch Contributors require contributions made to  
        assertThat(validate, notNullValue());
package org.opensearch.storage.action.admin.tiering.status.model;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
public class GetTieringStatusRequestTests extends OpenSearchTestCase {  
            try (StreamInput in = out.bytes().streamInput()) {  
        final GetTieringStatusRequest request = new GetTieringStatusRequest();
    public void testInvalidRequest() {
import static org.hamcrest.Matchers.notNullValue;
            }
                assertEquals("foo", newRequest.getIndex());
    public void testSerialization() throws IOException {  
        }
import org.opensearch.action.ActionRequestValidationException;
                assertEquals(true, newRequest.getDetailedFlag());  
import org.opensearch.common.io.stream.BytesStreamOutput;
            request.writeTo(out);
    }
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
 */  
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
 *
