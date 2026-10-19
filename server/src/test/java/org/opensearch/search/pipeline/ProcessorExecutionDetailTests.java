                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            + "  \"output_data\": [1, 2, 3]"
        assertNull(detailNoError.getErrorMessage());
            "tag123"
            ProcessorExecutionDetail.ProcessorStatus.FAIL,
            123L,
        ProcessorExecutionDetail detailNoError = new ProcessorExecutionDetail(
            + "  \"duration_millis\": 123,"
        ) {
            assertEquals(Map.of("key1", "value1"), detail.getInputData());
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(
    }
            XContentHelper.convertToMap(BytesReference.bytes(expectedBuilder), false, (MediaType) MediaTypeRegistry.JSON),
            "testProcessor",
            + "  \"error\": \"processor 1 fail\","
        assertEquals(Map.of("key", "value"), deserialized.getInputData());
            + "  \"error\": \"processor 1 fail\","
        assertEquals("processor 1 fail", detail.getErrorMessage());
        XContentBuilder actualBuilder = XContentBuilder.builder(JsonXContent.jsonXContent);
    public void testToXContentWithProcessorError() throws IOException {
            List.of(1, 2, 3),
            expected
        assertEquals(Map.of("newKey", "newValue"), detail.getInputData());
            + "  \"tag\": \"123\","
        );
        detail.addTook(456L);
            123L,
            null,
        }
            + "  \"output_data\": [1, 2, 3]"
        ProcessorExecutionDetail detailNoTag = new ProcessorExecutionDetail(
        );
        );
        assertEquals(123L, deserialized.getDurationMillis());
            XContentHelper.convertToMap(BytesReference.bytes(expectedBuilder), false, (MediaType) MediaTypeRegistry.JSON),
            assertEquals(123L, detail.getDurationMillis());
        XContentBuilder expectedBuilder = XContentBuilder.builder(JsonXContent.jsonXContent);
        try (
            123L,
            + "}";
            "testProcessor",
        XContentBuilder expectedBuilder = XContentBuilder.builder(JsonXContent.jsonXContent);
            ""
            XContentHelper.convertToMap(BytesReference.bytes(actualBuilder), false, (MediaType) MediaTypeRegistry.JSON)
            Map.of("key1", "value1"),
    public void testToXContent() throws IOException {
            this.xContentRegistry(),
        assertEquals("testProcessor", deserialized.getProcessorName());
            + "  \"output_data\": [1, 2, 3]"
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(
            null,
                deserialized = new ProcessorExecutionDetail(input);
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(
            + "  \"input_data\": {\"key1\": \"value1\"},"
            123L,
            assertEquals(List.of(1, 2, 3), detail.getOutputData());
                json
import org.opensearch.common.xcontent.json.JsonXContent;
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
        detail.addInput(Map.of("newKey", "newValue"));
        assertEquals(456L, detail.getDurationMillis());
        );
            assertEquals("testProcessor", detail.getProcessorName());
            XContentHelper.convertToMap(BytesReference.bytes(actualBuilder), false, (MediaType) MediaTypeRegistry.JSON)
        ) {
            null
        );
            )
            List.of(1, 2, 3),
    public void testGetErrorMessage() {
            "processor 1 fail",
            + "  \"status\": \"success\","
        assertEquals("tag123", detail.getTag());
            null
import org.opensearch.core.xcontent.DeprecationHandler;
    }
            assertEquals(ProcessorExecutionDetail.ProcessorStatus.FAIL, detail.getStatus());
            expected
        detail.toXContent(actualBuilder, ToXContent.EMPTY_PARAMS);
            Map.of("key", "value"),
            Map.of("key1", "value1"),
import java.util.List;
            + "  \"output_data\": [1, 2, 3]"
            Map.of("key1", "value1"),
 *
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
 * SPDX-License-Identifier: Apache-2.0
            List.of(1, 2, 3),
            + "}";
    public void testFromXContentWithPRocessorError() throws IOException {
            + "  \"processor_name\": \"testProcessor\","
    }
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
import java.util.Map;
        );
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
    }
            ProcessorExecutionDetail detail = ProcessorExecutionDetail.fromXContent(parser);
            "processor 1 fail",
            + "  \"processor_name\": \"testProcessor\","
 * compatible open source license.
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(
            try (StreamInput input = output.bytes().streamInput()) {
            DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        assertNull(detailNoTag.getTag());
    public void testSerializationRoundtrip() throws IOException {
        try (BytesStreamOutput output = new BytesStreamOutput()) {
            + "  \"status\": \"fail\","
            assertEquals(List.of(1, 2, 3), detail.getOutputData());
        XContentParser expectedParser = JsonXContent.jsonXContent.createParser(
            DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            detail.writeTo(output);
            ProcessorExecutionDetail.ProcessorStatus.SUCCESS,
import org.opensearch.core.xcontent.ToXContent;
            assertEquals(Map.of("key1", "value1"), detail.getInputData());
            "tag123"
        String expected = "{"
            "123"
            "testProcessor",
            Map.of("key1", "value1"),
import org.opensearch.core.xcontent.XContentBuilder;
public class ProcessorExecutionDetailTests extends OpenSearchTestCase {
            null
                this.xContentRegistry(),
        expectedBuilder.generator().copyCurrentStructure(expectedParser);
            ProcessorExecutionDetail detail = ProcessorExecutionDetail.fromXContent(parser);
            123L,
            }
import org.opensearch.test.OpenSearchTestCase;
            "",
        );
            "",
        assertEquals(List.of(4, 5, 6), detail.getOutputData());
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.io.IOException;
        XContentParser expectedParser = JsonXContent.jsonXContent.createParser(
            "testProcessor",
import org.opensearch.core.xcontent.MediaType;
    public void testFromXContent() throws IOException {
            assertEquals("testProcessor", detail.getProcessorName());
            this.xContentRegistry(),
        assertEquals(List.of(1, 2, 3), deserialized.getOutputData());
            + "  \"input_data\": {\"key1\": \"value1\"},"
            123L,
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(
import org.opensearch.core.xcontent.XContentParser;
    public void testAddMethods() {
        }
import org.opensearch.common.xcontent.XContentHelper;
 */
    }
        ProcessorExecutionDetail deserialized;
            "testProcessor",
            + "  \"duration_millis\": 123,"
            List.of(1, 2, 3),
        );
            null,
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(
            + "  \"duration_millis\": 123,"
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        expectedBuilder.generator().copyCurrentStructure(expectedParser);
    public void testGetTag() {
    }
        try (
            XContentParser parser = JsonXContent.jsonXContent.createParser(
            ProcessorExecutionDetail.ProcessorStatus.FAIL,
        );
            + "  \"input_data\": {\"key1\": \"value1\"},"
    }
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail(
        String json = "{"
            + "}";
        );
            + "  \"input_data\": {\"key1\": \"value1\"},"
import org.opensearch.core.common.bytes.BytesReference;
            + "}";
 * The OpenSearch Contributors require contributions made to
        String json = "{"
}
            "testProcessor",
    }
            List.of(1, 2, 3),
package org.opensearch.search.pipeline;
        ProcessorExecutionDetail detail = new ProcessorExecutionDetail("testProcessor");
            + "  \"status\": \"fail\","
            List.of(1, 2, 3),
        detail.addOutput(List.of(4, 5, 6));
        }
            + "  \"processor_name\": \"testProcessor\","
            Map.of("key1", "value1"),
            "testProcessor",
        String expected = "{"
            assertEquals(123L, detail.getDurationMillis());
                this.xContentRegistry(),
            + "  \"duration_millis\": 123,"
                json
            Map.of("key1", "value1"),
            )
            123L,
        detail.toXContent(actualBuilder, ToXContent.EMPTY_PARAMS);
            XContentParser parser = JsonXContent.jsonXContent.createParser(
import org.opensearch.core.common.io.stream.StreamInput;
        );
        XContentBuilder actualBuilder = XContentBuilder.builder(JsonXContent.jsonXContent);
            List.of(1, 2, 3),
/*
            + "  \"processor_name\": \"testProcessor\","
