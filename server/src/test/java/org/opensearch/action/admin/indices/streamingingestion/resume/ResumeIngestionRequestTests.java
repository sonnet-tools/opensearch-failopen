    public void testValidation() {
              "reset_settings": [
 * this file be licensed under the Apache-2.0 license or a
                  "shard": 0,
            1,
                  "value": "123"
        assertEquals(0, resetSettings1.getShard());
        );
 *
 * compatible open source license.
            {  
            }
import org.opensearch.common.io.stream.BytesStreamOutput;  
            """;
        );
            {
    public void testSerialization() throws IOException {
                  "value": "1739459600000"
/*  
    }
        assertNotNull(request);
                {
            () -> ResumeIngestionRequest.fromXContent(new String[] { "index" }, createParser(json))
                {
            """;
                },  
        assertThrows(
                {
    public void testFromXContent() throws IOException {
                  "value": "123"
        assertNotNull(request3.validate());  
        XContentParser parser = createParser(json);  
        assertThrows(
                }
    public void testFromXContentMissingInput() {
        String[] indices = new String[] { "index1", "index2" };  
            new ResumeIngestionRequest.ResetSettings(0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "0") };
            () -> ResumeIngestionRequest.fromXContent(new String[] { "index" }, createParser(json))  
                assertEquals(request.getResetSettings(), deserializedRequest.getResetSettings());
            {  
    }
                  "value": "123"
            IllegalArgumentException.class,
                }
            try (StreamInput in = out.bytes().streamInput()) {
        String json = """
                ResumeIngestionRequest.ResetSettings deserialized = new ResumeIngestionRequest.ResetSettings(in);
package org.opensearch.action.admin.indices.streamingingestion.resume;
        // Test with valid indices
            }
                ResumeIngestionRequest deserializedRequest = new ResumeIngestionRequest(in);
            "value"
        assertEquals("123", resetSettings1.getValue());
        String json = """
        assertNotNull(e);  
              "reset_settings": [
import org.opensearch.action.ActionRequestValidationException;
            }  
        assertEquals(ResumeIngestionRequest.ResetSettings.ResetMode.TIMESTAMP, resetSettings2.getMode());
        assertEquals(2, request.getResetSettings().length);  
public class ResumeIngestionRequestTests extends OpenSearchTestCase {  
                {
        ResumeIngestionRequest request2 = new ResumeIngestionRequest(new String[0]);
                assertEquals(settings.getShard(), deserialized.getShard());  
                  "shard": 0,  
            }
                }
        ResumeIngestionRequest.ResetSettings[] resetSettings2 = new ResumeIngestionRequest.ResetSettings[] {  
        ResumeIngestionRequest request1 = new ResumeIngestionRequest(new String[] { "index1", "index2" });  
        assertEquals("1739459600000", resetSettings2.getValue());  
import java.io.IOException;
        ResumeIngestionRequest request = new ResumeIngestionRequest(indices);
        assertThrows(
    }
                  "mode": "INVALID",  
            }  
              ]  
import org.opensearch.test.OpenSearchTestCase;
            """;  
              "reset_settings": {}
            new ResumeIngestionRequest.ResetSettings(0, null, "0") };
            IllegalArgumentException.class,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentParser;
            request.writeTo(out);
              "reset_settings": [  
            """;
        );
              "reset_settings": [
        assertNull(request4.validate());  
        );
        ResumeIngestionRequest.ResetSettings[] resetSettings = new ResumeIngestionRequest.ResetSettings[] {  
                  "shard": 1,
            ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET,  
                assertArrayEquals(request.indices(), deserializedRequest.indices());  
        ActionRequestValidationException e = request2.validate();
    }  
        request.indicesOptions(IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean()));
            {  
    public void testResetSettingsSerialization() throws IOException {  
            }
                {
                  "mode": "TIMESTAMP",  
            """;
    }
    public void testFromXContentInvalidField() {
        return createParser(JsonXContent.jsonXContent, new BytesArray(json).streamInput());  
        }
            IllegalArgumentException.class,
import org.opensearch.core.common.io.stream.StreamInput;  
    public void testFromXContentInvalidInput() {  
        );
                  "unknown_field": 0,  
        ResumeIngestionRequest.ResetSettings resetSettings1 = request.getResetSettings()[0];
}
                assertEquals(settings.getMode(), deserialized.getMode());
            {  
              ]  
                  "shard": 0,  
        assertEquals(ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, resetSettings1.getMode());  
        ResumeIngestionRequest request4 = new ResumeIngestionRequest(new String[] { "index1", "index2" }, resetSettings2);
        assertNull(request1.validate());
    }
    }
        String json = """
            IllegalArgumentException.class,  
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        ResumeIngestionRequest request = ResumeIngestionRequest.fromXContent(new String[] { "index" }, parser);
            () -> ResumeIngestionRequest.fromXContent(new String[] { "index" }, createParser(json))  
            () -> ResumeIngestionRequest.fromXContent(new String[] { "index" }, createParser(json))  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
              ]  
                }
 * SPDX-License-Identifier: Apache-2.0
        String json = """
    }
    }
        ResumeIngestionRequest.ResetSettings settings = new ResumeIngestionRequest.ResetSettings(
    public void testFromXContentInvalidJson() {
              ]  
import org.opensearch.common.xcontent.json.JsonXContent;
        assertThrows(
        ResumeIngestionRequest request3 = new ResumeIngestionRequest(new String[] { "index1", "index2" }, resetSettings);
import org.opensearch.core.common.bytes.BytesArray;
 */  
    private XContentParser createParser(String json) throws IOException {
        // Test with invalid reset settings
            try (StreamInput in = out.bytes().streamInput()) {
        // Test with valid reset settings
        assertEquals(1, resetSettings2.getShard());
                  "value": "123"
                  "mode": "OFFSET",
        ResumeIngestionRequest.ResetSettings resetSettings2 = request.getResetSettings()[1];  
                assertEquals(settings.getValue(), deserialized.getValue());
            settings.writeTo(out);
        // Test with empty indices  
                assertEquals(request.indicesOptions(), deserializedRequest.indicesOptions());
        }
import org.opensearch.action.support.IndicesOptions;
        String json = """
