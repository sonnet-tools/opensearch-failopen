    public void testTieringRequestWithNullOrEmptyIndices() {
package org.opensearch.action.admin.indices.tiering;
        TieringIndexRequest request = new TieringIndexRequest(TieringIndexRequest.Tier.WARM.name(), "test");
        ActionRequestValidationException validationException = request.validate();
    public void testTieringRequestWithListOfIndices() {
import org.opensearch.action.ActionRequestValidationException;
import java.io.IOException;
import org.opensearch.action.support.IndicesOptions;
    public void testSerDeOfTieringRequest() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(IllegalArgumentException.class, () -> TieringIndexRequest.Tier.fromString("tier"));  
        assertNotNull(validationException);
import org.opensearch.core.common.io.stream.StreamInput;
            "foo",  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                final TieringIndexRequest deserializedRequest = new TieringIndexRequest(in);  
import static org.hamcrest.CoreMatchers.equalTo;  
            TieringIndexRequest.Tier.WARM,  
                assertEquals(request, deserializedRequest);
        expectThrows(IllegalArgumentException.class, () -> TieringIndexRequest.Tier.fromString(null));
    public void testTieringRequestWithIndexPattern() {
        TieringIndexRequest request = new TieringIndexRequest(TieringIndexRequest.Tier.HOT.name(), "test");  
 * The OpenSearch Contributors require contributions made to  
}  
        }  
 * this file be licensed under the Apache-2.0 license or a
public class TieringIndexRequestTests extends OpenSearchTestCase {
        TieringIndexRequest request = new TieringIndexRequest(TieringIndexRequest.Tier.WARM.name(), "foo-*");  
        assertThat(expected, equalTo(original));
    }  
    }
            "bar",
            false,
            }
        ActionRequestValidationException validationException = request.validate();
        assertNotNull(validationException);
            request.writeTo(out);
 */  
    public void testTieringRequestEquals() {  
import org.opensearch.test.OpenSearchTestCase;
    }  
        ActionRequestValidationException validationException = request.validate();
        ActionRequestValidationException validationException = request.validate();
    }
        assertThat(expected.indices(), equalTo(original.indices()));  
 *
        assertThat(expected.indicesOptions(), equalTo(original.indicesOptions()));
            "baz"
        final TieringIndexRequest original = new TieringIndexRequest(TieringIndexRequest.Tier.WARM.name(), "test");
/*  
    }
        TieringIndexRequest request = new TieringIndexRequest(
        assertNull(validationException);
        expected.indicesOptions(original.indicesOptions());
    }  
        TieringIndexRequest request = new TieringIndexRequest(TieringIndexRequest.Tier.WARM.name(), null, "");  
        final TieringIndexRequest expected = new TieringIndexRequest(TieringIndexRequest.Tier.WARM.name(), original.indices());  
    public void testTieringTypeFromString() {
        assertNull(validationException);
 * compatible open source license.
        original.indicesOptions(IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean()));
    public void testTieringRequestWithNotSupportedTier() {
    }  
            IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean()),
            try (StreamInput in = out.bytes().streamInput()) {
        );  
