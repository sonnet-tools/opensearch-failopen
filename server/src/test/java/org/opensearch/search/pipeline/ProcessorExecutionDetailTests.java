        assertEquals(List.of(4, 5, 6), detail.getOutputData());
        );
    }
            detail.writeTo(output);
        ProcessorExecutionDetail detailNoError = new ProcessorExecutionDetail(
}  
            123L,
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,  
            null,
            XContentParser parser = JsonXContent.jsonXContent.createParser(  
            null
            try (StreamInput input = output.bytes().streamInput()) {  
                this.xContentRegistry(),
            + "  \"duration_millis\": 123,"  
            List.of(1, 2, 3),
            )
            + "  \"processor_name\": \"testProcessor\","  
        assertNull(detailNoError.getErrorMessage());
        ) {  
            ProcessorExecutionDetail detail = ProcessorExecutionDetail.fromXContent(parser);  
            + "  \"duration_millis\": 123,"
        assertEquals(123L, deserialized.getDurationMillis());
            expected
    }
            XContentHelper.convertToMap(BytesReference.bytes(expectedBuilder), false, (MediaType) MediaTypeRegistry.JSON),  
        detail.toXContent(actualBuilder, ToXContent.EMPTY_PARAMS);
            + "  \"input_data\": {\"key1\": \"value1\"},"
        String json = "{"
import org.opensearch.core.xcontent.XContentBuilder;
            Map.of("key1", "value1"),
            "tag123"  
        assertEquals("testProcessor", deserialized.getProcessorName());
            List.of(1, 2, 3),
        XContentBuilder actualBuilder = XContentBuilder.builder(JsonXContent.jsonXContent);
            null,
            "testProcessor",
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(
            123L,
 * this file be licensed under the Apache-2.0 license or a
            Map.of("key", "value"),  
            assertEquals(ProcessorExecutionDetail.ProcessorStatus.FAIL, detail.getStatus());  
            List.of(1, 2, 3),
            XContentHelper.convertToMap(BytesReference.bytes(actualBuilder), false, (MediaType) MediaTypeRegistry.JSON)  
        XContentParser expectedParser = JsonXContent.jsonXContent.createParser(
    public void testSerializationRoundtrip() throws IOException {
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
import org.opensearch.common.xcontent.XContentHelper;
        );
            XContentHelper.convertToMap(BytesReference.bytes(expectedBuilder), false, (MediaType) MediaTypeRegistry.JSON),
        assertEquals(Map.of("key", "value"), deserialized.getInputData());  
        assertEquals(
import org.opensearch.common.io.stream.BytesStreamOutput;
        String json = "{"
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(  
            + "  \"tag\": \"123\","  
    }  
            List.of(1, 2, 3),
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(
            + "  \"processor_name\": \"testProcessor\","
            ProcessorExecutionDetail.ProcessorStatus.FAIL,
            XContentHelper.convertToMap(BytesReference.bytes(actualBuilder), false, (MediaType) MediaTypeRegistry.JSON)
    public void testToXContent() throws IOException {
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.xcontent.DeprecationHandler;  
            null
            assertEquals(Map.of("key1", "value1"), detail.getInputData());
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
 * SPDX-License-Identifier: Apache-2.0
            + "  \"error\": \"processor 1 fail\","  
        );
        String expected = "{"
            Map.of("key1", "value1"),
        assertEquals(Map.of("newKey", "newValue"), detail.getInputData());
 *
            Map.of("key1", "value1"),  
        ProcessorExecutionDetail deserialized;  
            123L,
        );
 * The OpenSearch Contributors require contributions made to  
                deserialized = new ProcessorExecutionDetail(input);
import java.io.IOException;
        assertEquals(List.of(1, 2, 3), deserialized.getOutputData());
        );
    }  
        assertEquals("processor 1 fail", detail.getErrorMessage());
            ProcessorExecutionDetail detail = ProcessorExecutionDetail.fromXContent(parser);
            assertEquals("testProcessor", detail.getProcessorName());
            "testProcessor",
    }
            + "  \"status\": \"fail\","
        }
            assertEquals(123L, detail.getDurationMillis());
                this.xContentRegistry(),
            ProcessorExecutionDetail.ProcessorStatus.FAIL,
public class ProcessorExecutionDetailTests extends OpenSearchTestCase {  
            123L,  
            this.xContentRegistry(),
        ) {
            List.of(1, 2, 3),
        detail.addTook(456L);  
        expectedBuilder.generator().copyCurrentStructure(expectedParser);  
            }
    public void testToXContentWithProcessorError() throws IOException {
package org.opensearch.search.pipeline;
            List.of(1, 2, 3),  
        detail.toXContent(actualBuilder, ToXContent.EMPTY_PARAMS);
            + "  \"status\": \"success\","
            Map.of("key1", "value1"),
                json  
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
    public void testGetErrorMessage() {
            + "  \"error\": \"processor 1 fail\","  
        );
            "tag123"  
        String expected = "{"
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,  
            + "  \"input_data\": {\"key1\": \"value1\"},"
        XContentBuilder expectedBuilder = XContentBuilder.builder(JsonXContent.jsonXContent);
            + "  \"processor_name\": \"testProcessor\","
            "processor 1 fail",
        );
            "",  
        assertNull(detailNoTag.getTag());
        ProcessorExecutionDetail detailNoTag = new ProcessorExecutionDetail(
            )
            + "  \"output_data\": [1, 2, 3]"
            + "  \"duration_millis\": 123,"
        assertEquals(
            Map.of("key1", "value1"),
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail("testProcessor");
import org.opensearch.core.xcontent.MediaType;
        }  
            assertEquals("testProcessor", detail.getProcessorName());  
    public void testAddMethods() {
            + "  \"duration_millis\": 123,"
            assertEquals(Map.of("key1", "value1"), detail.getInputData());
        );  
            expected  
            DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            assertEquals(List.of(1, 2, 3), detail.getOutputData());  
            123L,
        expectedBuilder.generator().copyCurrentStructure(expectedParser);
        XContentBuilder expectedBuilder = XContentBuilder.builder(JsonXContent.jsonXContent);
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
            "testProcessor",
            DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            + "  \"output_data\": [1, 2, 3]"  
            "testProcessor",
    public void testFromXContentWithPRocessorError() throws IOException {
            "testProcessor",  
 */  
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(  
/*  
            "processor 1 fail",  
import org.opensearch.core.xcontent.ToXContent;  
            this.xContentRegistry(),  
        assertEquals(456L, detail.getDurationMillis());  
            + "}";
import org.opensearch.common.xcontent.json.JsonXContent;  
    }
            + "}";
            assertEquals(123L, detail.getDurationMillis());  
            "testProcessor",  
        try (  
            XContentParser parser = JsonXContent.jsonXContent.createParser(
            + "  \"input_data\": {\"key1\": \"value1\"},"
            Map.of("key1", "value1"),  
            + "}";  
            ""
                json
        }
            + "  \"input_data\": {\"key1\": \"value1\"},"
import org.opensearch.test.OpenSearchTestCase;  
            + "}";  
        detail.addInput(Map.of("newKey", "newValue"));
            + "  \"output_data\": [1, 2, 3]"
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(  
import java.util.List;  
    }
        XContentBuilder actualBuilder = XContentBuilder.builder(JsonXContent.jsonXContent);
            123L,
            + "  \"output_data\": [1, 2, 3]"  
    public void testGetTag() {
            List.of(1, 2, 3),  
import java.util.Map;
        assertEquals("tag123", detail.getTag());
        try (
    }
 * compatible open source license.
    public void testFromXContent() throws IOException {
        );
            null,
        detail.addOutput(List.of(4, 5, 6));
        );  
            "123"
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            + "  \"processor_name\": \"testProcessor\","  
            "testProcessor",
        );  
            "",  
            + "  \"status\": \"fail\","
            123L,  
import org.opensearch.core.xcontent.XContentParser;
            assertEquals(List.of(1, 2, 3), detail.getOutputData());
        XContentParser expectedParser = JsonXContent.jsonXContent.createParser(  
            null
        try (BytesStreamOutput output = new BytesStreamOutput()) {
