        assertThat(customData.get("fields.@timestamp.resolution"), equalTo("milliseconds"));
            IllegalArgumentException.class,  
            .fieldDomain(new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test"));
            assertThat(deserialized.getParentTask(), equalTo(request.getParentTask()));  
        assertTrue(validationException.validationErrors().contains("target index UUID is required"));
        Map<String, String> customData = request.fieldDomainCustomData();  
                new DateRangeFieldDomain("event.ingested", 300L, 400L, true, "test")  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
/*  
        assertArrayEquals(new String[] { "logs-000001" }, request.indices());
    public void testValidationRequiresIndexAndMetadata() {
import org.opensearch.core.common.io.stream.StreamInput;
        );
        assertThat(customData.get("fields.event.ingested.max"), equalTo("400"));  
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(new Index("logs-000001", "index-uuid"));
            )  
            )
        request.timeout(randomPositiveTimeValue());  
        request.setParentTask(randomAlphaOfLength(5), randomNonNegativeLong());
        );
 * The OpenSearch Contributors require contributions made to  
    public void testFieldDomainSetterEncodesMetadata() {
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest((Index) null);  
        ).fieldDomain(new DateRangeFieldDomain("event.ingested", 300L, 400L, true, "test"));
    }  
import org.opensearch.common.io.stream.BytesStreamOutput;  
import static org.hamcrest.Matchers.equalTo;
        assertThat(customData.get("fields.@timestamp.max"), equalTo("200"));  
import org.opensearch.action.support.IndicesOptions;
        );
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test")
        ActionRequestValidationException validationException = request.validate();
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(new Index("logs-000001", "index-uuid")).fieldDomain(
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(new Index("logs-000001", "index-uuid")).fieldDomain(
        assertTrue(validationException.validationErrors().contains("field domain metadata is required"));  
        assertThat(customData.get("fields.@timestamp.finalized"), equalTo("true"));
        );
    }
        IllegalArgumentException exception = expectThrows(
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test")
        assertThat(request.indicesOptions(), equalTo(IndicesOptions.strictSingleIndexNoExpandForbidClosed()));
            request.writeTo(out);
                new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test"),
        assertThat(exception.getMessage(), equalTo("duplicate field domain for field [@timestamp]"));
    }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test"),
        assertFalse(request.includeDataStreams());  
    }
    }  
            List.of(
 * SPDX-License-Identifier: Apache-2.0
        ActionRequestValidationException validationException = request.validate();
public class PutIndexFieldDomainsRequestTests extends OpenSearchTestCase {
import org.opensearch.action.ActionRequestValidationException;
    public void testIndicesRequestProperties() {
    }
        assertThat(customData.get("fields.@timestamp.max"), equalTo("200"));
    public void testFieldDomainsSetterEncodesMultipleDomains() {
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(new Index("logs-000001", "index-uuid")).fieldDomain(  
            assertThat(deserialized.targetIndex(), equalTo(request.targetIndex()));
    public void testFieldDomainSetterRejectsDuplicateField() {  
            try (StreamInput in = out.bytes().streamInput()) {
    public void testSerialization() throws IOException {
import java.util.Map;  
}
 */  
        Map<String, String> customData = request.fieldDomainCustomData();
            }
            assertThat(deserialized.fieldDomainCustomData(), equalTo(request.fieldDomainCustomData()));  
        assertThat(customData.get("fields.event.ingested.max"), equalTo("400"));
        }
        assertNotNull(validationException);  
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(new Index("logs-000001", Strings.UNKNOWN_UUID_VALUE))
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test")  
    }
 *
        assertThat(customData.get("fields.@timestamp.type"), equalTo("date_range"));
            PutIndexFieldDomainsRequest deserialized;
import java.util.List;
    public void testFieldDomainSetterAddsDomains() {
            () -> request.fieldDomain(new DateRangeFieldDomain("@timestamp", 300L, 400L, true, "test"))
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(new Index("logs-000001", "index-uuid")).fieldDomains(  
            assertThat(deserialized.timeout(), equalTo(request.timeout()));
    public void testValidationRequiresTargetIndexUUID() {  
import java.io.IOException;
        assertThat(customData.get("fields.@timestamp.max"), equalTo("200"));
package org.opensearch.action.admin.indices.fielddomain;
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
        assertThat(customData.get("fields.@timestamp.min"), equalTo("100"));
            assertThat(deserialized.clusterManagerNodeTimeout(), equalTo(request.clusterManagerNodeTimeout()));
        request.clusterManagerNodeTimeout(randomPositiveTimeValue());
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(new Index("logs-000001", "index-uuid")).fieldDomains(
                new DateRangeFieldDomain("event.ingested", 300L, 400L, true, "test")
        assertNotNull(validationException);
        );  
import org.opensearch.test.OpenSearchTestCase;
            List.of(  
        assertTrue(validationException.validationErrors().contains("target index is required"));
    }
import org.opensearch.core.common.Strings;
                deserialized = new PutIndexFieldDomainsRequest(in);  
        Map<String, String> customData = request.fieldDomainCustomData();  
import org.opensearch.core.index.Index;  
