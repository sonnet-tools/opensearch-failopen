            for (Object item : list) {
        } else {
        out.writeGenericValue(inputData);
        }
        // tag is optional when setting up processor
            builder.startArray(fieldName);
        out.writeEnum(status);
    public Object getInputData() {
    public void addOutput(Object outputData) {
        this.errorMessage = errorMessage;
}
        return status;
            } else {
    }
import org.opensearch.core.common.io.stream.StreamInput;
    private static final ParseField DURATION_MILLIS_FIELD = new ParseField("duration_millis");
            for (Map.Entry<?, ?> entry : map.entrySet()) {
        } else if (data instanceof Map<?, ?> map) {
        ProcessorStatus status,
     * Represents the status of a processor in the search pipeline.
            builder.field(TAG_FIELD.getPreferredName(), tag);
        }
        this.outputData = in.readGenericValue();
    public ProcessorExecutionDetail(
    /**
 * The OpenSearch Contributors require contributions made to
        Object inputData,
            }
     * execution result of processors within a pipeline.
import org.opensearch.core.xcontent.DeprecationHandler;
    public long getDurationMillis() {
    }
    }
                writeItemToXContent(builder, item, params);
        String processorName,
     */
     * @param outputData the new output data
                        addFieldToXContent(builder, entry.getKey(), entry.getValue(), params);
        }
     * Constructor for ProcessorExecutionDetail
    }
    }
        this.status = status;
        FAIL
    public ProcessorStatus getStatus() {
        if (processorName == null) {
            parser.nextToken();
        this.status = status;
                    XContentParser parser = XContentType.JSON.xContent()
        out.writeLong(durationMillis);
    public enum ProcessorStatus {
        this.errorMessage = errorMessage;
    public String getErrorMessage() {
            builder.field(fieldName);
     *
                    for (Map.Entry<String, Object> entry : parsedMap.entrySet()) {
/*
                parser.skipChildren();
import java.io.IOException;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        builder.field(STATUS_FIELD.getPreferredName(), status.name().toLowerCase(Locale.ROOT));
    }
                    Map<String, Object> parsedMap = parser.map();
    private String tag;
                durationMillis = parser.longValue();
        return outputData;
                try (
            try {
    }
/**
    /**
    public ProcessorExecutionDetail(String processorName, String tag) {
import org.opensearch.core.xcontent.ToXContentObject;
        return processorName;
        builder.field(PROCESSOR_NAME_FIELD.getPreferredName(), processorName);
    private ProcessorStatus status;
     * @param durationMillis the new duration in milliseconds
        this.durationMillis = in.readLong();
        return errorMessage;
    private long durationMillis;
        return new ProcessorExecutionDetail(processorName, durationMillis, inputData, outputData, status, errorMessage, tag);
import org.opensearch.common.xcontent.XContentUtils;
            } else if (DURATION_MILLIS_FIELD.match(fieldName, parser.getDeprecationHandler())) {
 * this file be licensed under the Apache-2.0 license or a
        out.writeString(processorName);
     * Includes the error message only if the processor has failed.
        return builder;
    }
            // If the data is a String, attempt to parse it as JSON
    @Override
                tag = parser.text();
     */
    }
    public static ProcessorExecutionDetail fromXContent(XContentParser parser) throws IOException {
    private static final ParseField STATUS_FIELD = new ParseField("status");
        Object outputData = null;
    public ProcessorExecutionDetail(StreamInput in) throws IOException {
        this.processorName = processorName;
            }
    private Object outputData;
        if (data instanceof List<?> list) {
        } else {
                status = ProcessorStatus.valueOf(parser.text().toUpperCase(Locale.ROOT));
     *
            builder.field(ERROR_MESSAGE_FIELD.getPreferredName(), errorMessage);
    ) {
            builder.endArray();
        String errorMessage,
 * @opensearch.api
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        }
        String tag = null;
        return Objects.hash(processorName, durationMillis, inputData, outputData, status, errorMessage, tag);
import java.util.Map;
    /**
        this.inputData = inputData;
            builder.field(fieldName, data);
    private static final ParseField TAG_FIELD = new ParseField("tag");
    }
    public int hashCode() {
        return durationMillis;
            throw new IllegalArgumentException("Processor name is required");
 *
    @Override
    }
            }
    private String errorMessage;
        }
        this.outputData = outputData;
        this.processorName = in.readString();
        this.outputData = outputData;
        ProcessorStatus status = null;
    }
                inputData = XContentUtils.readValue(parser, parser.currentToken());
        this.inputData = in.readGenericValue();
                addFieldToXContent(builder, entry.getKey().toString(), entry.getValue(), params);
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        this.durationMillis = durationMillis;
@PublicApi(since = "2.19.0")
     * or encountered a failure during its execution. It helps in categorizing the
                outputData = XContentUtils.readValue(parser, parser.currentToken());
        return tag;
import org.opensearch.common.xcontent.XContentType;
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
                ) {
 * Detailed information about a processor execution in a search pipeline.
            builder.value(item);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */
        Object outputData,
    }
            String fieldName = parser.currentName();
            return;
    public ProcessorExecutionDetail(String processorName) {
     *
     */
    }
    @PublicApi(since = "2.19.0")
    public void addInput(Object inputData) {
        }
            } else if (STATUS_FIELD.match(fieldName, parser.getDeprecationHandler())) {
                processorName = parser.text();
            } else if (INPUT_DATA_FIELD.match(fieldName, parser.getDeprecationHandler())) {
        } else if (data instanceof String jsonString) {
                // If parsing fails, write the string as a plain field
            } else if (TAG_FIELD.match(fieldName, parser.getDeprecationHandler())) {
    @Override
package org.opensearch.search.pipeline;
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
     * Adds or updates the output data for this processor execution detail.
        if (tag != null) {
     *
                    builder.endObject();
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
import org.opensearch.core.ParseField;
     * Serializes the processor execution detail into XContent.
        this.durationMillis = durationMillis;
        String processorName = null;
            builder.endObject();
        out.writeString(tag);
            } else if (ERROR_MESSAGE_FIELD.match(fieldName, parser.getDeprecationHandler())) {
    public String getProcessorName() {
     * Adds or updates the input data for this processor execution detail.
            }
        builder.field(DURATION_MILLIS_FIELD.getPreferredName(), durationMillis);
    }
    public void addTook(long durationMillis) {
    public Object getOutputData() {
 * SPDX-License-Identifier: Apache-2.0
        String errorMessage = null;
        addFieldToXContent(builder, OUTPUT_DATA_FIELD.getPreferredName(), outputData, params);
                builder.field(fieldName, jsonString);
            if (PROCESSOR_NAME_FIELD.match(fieldName, parser.getDeprecationHandler())) {
        }
        if (data == null) {
        this(processorName, 0, null, null, ProcessorStatus.SUCCESS, null, tag);
                }
    private static final ParseField OUTPUT_DATA_FIELD = new ParseField("output_data");
                errorMessage = parser.text();
import org.opensearch.core.xcontent.XContentParser;
 * compatible open source license.
        Object inputData = null;
        SUCCESS,
        if (item instanceof ToXContentObject toXContentObject) {
        this.tag = tag;
    // Key for processor execution details
        addFieldToXContent(builder, INPUT_DATA_FIELD.getPreferredName(), inputData, params);
            builder.startObject(fieldName);
    /**
        builder.endObject();
import org.opensearch.core.common.io.stream.Writeable;
        this.tag = in.readString();
            } catch (IOException e) {
 */
                    }
        this.inputData = inputData;
    private void writeItemToXContent(XContentBuilder builder, Object item, Params params) throws IOException {
            toXContentObject.toXContent(builder, params);
        this.errorMessage = in.readString();
    /**
import org.opensearch.common.annotation.PublicApi;
    }
     */
        this(processorName, 0, null, null, ProcessorStatus.SUCCESS, null, null);
     */
                        .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, jsonString)
import org.opensearch.core.xcontent.XContentBuilder;
    private void addFieldToXContent(XContentBuilder builder, String fieldName, Object data, Params params) throws IOException {
        builder.startObject();
        }
        long durationMillis,
    }
    public static final String PROCESSOR_EXECUTION_DETAILS_KEY = "processorExecutionDetails";
import java.util.Objects;
            } else if (OUTPUT_DATA_FIELD.match(fieldName, parser.getDeprecationHandler())) {
        out.writeGenericValue(outputData);
        out.writeString(errorMessage);
    private static final ParseField PROCESSOR_NAME_FIELD = new ParseField("processor_name");
    private Object inputData;
    }
import java.util.Locale;
            toXContentObject.toXContent(builder, params);
        this.status = in.readEnum(ProcessorStatus.class);
            parser.nextToken();
    public void writeTo(StreamOutput out) throws IOException {
     * <p>This enum is used to indicate whether a processor has executed successfully
 *
    }
            builder.nullField(fieldName);
    }
     */
    private static final ParseField ERROR_MESSAGE_FIELD = new ParseField("error");
        return inputData;
    public void markProcessorAsFailed(ProcessorStatus status, String errorMessage) {
    private final String processorName;
                    builder.startObject(fieldName);
    private static final ParseField INPUT_DATA_FIELD = new ParseField("input_data");
        if (status == ProcessorStatus.FAIL) {
        String tag
        long durationMillis = 0;
                // check if its json string
        } else if (data instanceof ToXContentObject toXContentObject) {
    /**
import java.util.List;
    }
     * Adds or updates the duration of the processor execution.
     *
public class ProcessorExecutionDetail implements Writeable, ToXContentObject {
    public String getTag() {
     * @param inputData the new input data
