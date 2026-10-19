import java.util.Map;
 */  
    private final String processorName;  
        } else {  
            try {
        ProcessorStatus status,
        }
     *
    public String getErrorMessage() {  
     */  
        return errorMessage;
 * this file be licensed under the Apache-2.0 license or a
                        addFieldToXContent(builder, entry.getKey(), entry.getValue(), params);
        Object outputData,  
    public static ProcessorExecutionDetail fromXContent(XContentParser parser) throws IOException {
    public void addTook(long durationMillis) {
 *
        out.writeString(tag);
                durationMillis = parser.longValue();
                outputData = XContentUtils.readValue(parser, parser.currentToken());
 */
import org.opensearch.core.xcontent.ToXContentObject;
    private void addFieldToXContent(XContentBuilder builder, String fieldName, Object data, Params params) throws IOException {
    public ProcessorExecutionDetail(String processorName, String tag) {  
    }  
    @Override  
    }
            builder.field(ERROR_MESSAGE_FIELD.getPreferredName(), errorMessage);
     *
    private void writeItemToXContent(XContentBuilder builder, Object item, Params params) throws IOException {  
@PublicApi(since = "2.19.0")  
/**
        Object outputData = null;  
import org.opensearch.core.xcontent.XContentParser;  
    public void addOutput(Object outputData) {
        SUCCESS,
        } else if (data instanceof String jsonString) {
            }
    public long getDurationMillis() {
    public void markProcessorAsFailed(ProcessorStatus status, String errorMessage) {  
        this.tag = in.readString();
        return new ProcessorExecutionDetail(processorName, durationMillis, inputData, outputData, status, errorMessage, tag);
        // tag is optional when setting up processor
        this.errorMessage = in.readString();
     */
            throw new IllegalArgumentException("Processor name is required");
        Object inputData = null;
import java.io.IOException;
            builder.endObject();
                parser.skipChildren();  
    }  
     */  
    public static final String PROCESSOR_EXECUTION_DETAILS_KEY = "processorExecutionDetails";  
        builder.startObject();
    private static final ParseField DURATION_MILLIS_FIELD = new ParseField("duration_millis");
        return builder;
                }
import org.opensearch.common.annotation.PublicApi;
        this.durationMillis = durationMillis;  
    }
    }  
    /**
        return outputData;  
    public void writeTo(StreamOutput out) throws IOException {  
    }
        String errorMessage = null;
        this.processorName = in.readString();
    private static final ParseField PROCESSOR_NAME_FIELD = new ParseField("processor_name");
        String processorName,  
     * Represents the status of a processor in the search pipeline.
        return tag;
            builder.nullField(fieldName);
        }
    }
            parser.nextToken();
        builder.field(DURATION_MILLIS_FIELD.getPreferredName(), durationMillis);
                    builder.endObject();
                status = ProcessorStatus.valueOf(parser.text().toUpperCase(Locale.ROOT));
            } else if (TAG_FIELD.match(fieldName, parser.getDeprecationHandler())) {
            return;
        if (item instanceof ToXContentObject toXContentObject) {
        return inputData;
            } else if (OUTPUT_DATA_FIELD.match(fieldName, parser.getDeprecationHandler())) {  
    }  
            builder.field(fieldName);  
 *  
        out.writeString(errorMessage);  
                tag = parser.text();  
                processorName = parser.text();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.ParseField;
        return Objects.hash(processorName, durationMillis, inputData, outputData, status, errorMessage, tag);
            toXContentObject.toXContent(builder, params);
                writeItemToXContent(builder, item, params);
        this.durationMillis = durationMillis;
    /**
public class ProcessorExecutionDetail implements Writeable, ToXContentObject {
    /**
 * @opensearch.api
            // If the data is a String, attempt to parse it as JSON  
        String tag = null;  
        builder.field(STATUS_FIELD.getPreferredName(), status.name().toLowerCase(Locale.ROOT));  
     *
        return processorName;
                // check if its json string
    }  
import org.opensearch.common.xcontent.XContentUtils;  
        this.inputData = in.readGenericValue();
        this.status = in.readEnum(ProcessorStatus.class);  
import java.util.Locale;
    }  
            }  
import org.opensearch.core.xcontent.XContentBuilder;
    }  
            } else if (INPUT_DATA_FIELD.match(fieldName, parser.getDeprecationHandler())) {
                try (  
     * Adds or updates the output data for this processor execution detail.  
            } else if (ERROR_MESSAGE_FIELD.match(fieldName, parser.getDeprecationHandler())) {
        }  
            String fieldName = parser.currentName();  
     * Includes the error message only if the processor has failed.
        }  
    /**
    private String tag;  
                    XContentParser parser = XContentType.JSON.xContent()
        this.status = status;  
     * or encountered a failure during its execution. It helps in categorizing the
    /**
 * Detailed information about a processor execution in a search pipeline.
        this.outputData = in.readGenericValue();
    public String getTag() {
import org.opensearch.core.common.io.stream.Writeable;
        ProcessorStatus status = null;
        return durationMillis;  
        this.inputData = inputData;
    private static final ParseField STATUS_FIELD = new ParseField("status");
        this.durationMillis = in.readLong();  
    public ProcessorExecutionDetail(StreamInput in) throws IOException {
    public Object getInputData() {  
        }
        if (data == null) {  
     */
            } else if (DURATION_MILLIS_FIELD.match(fieldName, parser.getDeprecationHandler())) {
                    builder.startObject(fieldName);  
    public Object getOutputData() {
    public ProcessorStatus getStatus() {
     * @param outputData the new output data
        this(processorName, 0, null, null, ProcessorStatus.SUCCESS, null, null);  
    public ProcessorExecutionDetail(String processorName) {
            builder.value(item);
        this.processorName = processorName;
 * The OpenSearch Contributors require contributions made to  
    @PublicApi(since = "2.19.0")  
        builder.endObject();
            for (Object item : list) {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
}
    private static final ParseField INPUT_DATA_FIELD = new ParseField("input_data");  
     * Adds or updates the input data for this processor execution detail.  
    public String getProcessorName() {
        builder.field(PROCESSOR_NAME_FIELD.getPreferredName(), processorName);  
                // If parsing fails, write the string as a plain field
        this.errorMessage = errorMessage;
                    for (Map.Entry<String, Object> entry : parsedMap.entrySet()) {
     * @param inputData the new input data
                ) {  
     *  
    private static final ParseField OUTPUT_DATA_FIELD = new ParseField("output_data");
     * @param durationMillis the new duration in milliseconds
        if (tag != null) {
import java.util.List;  
    private String errorMessage;
        this.inputData = inputData;
        return status;  
            } else if (STATUS_FIELD.match(fieldName, parser.getDeprecationHandler())) {  
    }
import org.opensearch.core.xcontent.DeprecationHandler;
    private ProcessorStatus status;
        this.status = status;
            builder.field(fieldName, data);
    }
    }  
import java.util.Objects;  
    private Object inputData;
        this.outputData = outputData;
    }  
                errorMessage = parser.text();  
    private static final ParseField ERROR_MESSAGE_FIELD = new ParseField("error");  
            } else {
        long durationMillis,
        out.writeEnum(status);
                addFieldToXContent(builder, entry.getKey().toString(), entry.getValue(), params);
        out.writeString(processorName);
import org.opensearch.core.common.io.stream.StreamOutput;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
        if (processorName == null) {
     * Serializes the processor execution detail into XContent.  
            for (Map.Entry<?, ?> entry : map.entrySet()) {
        if (data instanceof List<?> list) {
        out.writeLong(durationMillis);
     */
        String errorMessage,
    private static final ParseField TAG_FIELD = new ParseField("tag");
            }  
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);  
        this.errorMessage = errorMessage;
package org.opensearch.search.pipeline;
                inputData = XContentUtils.readValue(parser, parser.currentToken());
            } catch (IOException e) {  
    ) {
                builder.field(fieldName, jsonString);
            if (PROCESSOR_NAME_FIELD.match(fieldName, parser.getDeprecationHandler())) {  
            builder.field(TAG_FIELD.getPreferredName(), tag);  
        FAIL  
            toXContentObject.toXContent(builder, params);
    public enum ProcessorStatus {
    }
    }  
    // Key for processor execution details
                        .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, jsonString)
    }  
     * <p>This enum is used to indicate whether a processor has executed successfully
            builder.startObject(fieldName);  
            builder.startArray(fieldName);  
     * execution result of processors within a pipeline.  
    }  
        Object inputData,
    public void addInput(Object inputData) {
     * Constructor for ProcessorExecutionDetail  
 * compatible open source license.
        out.writeGenericValue(inputData);  
        String processorName = null;  
    }
    private long durationMillis;
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            }  
        addFieldToXContent(builder, INPUT_DATA_FIELD.getPreferredName(), inputData, params);
        this.outputData = outputData;
    private Object outputData;  
    /**
    public ProcessorExecutionDetail(
     *
        String tag  
        } else if (data instanceof Map<?, ?> map) {
                    Map<String, Object> parsedMap = parser.map();
        }
        } else if (data instanceof ToXContentObject toXContentObject) {
    @Override
        }  
        addFieldToXContent(builder, OUTPUT_DATA_FIELD.getPreferredName(), outputData, params);
     */  
            parser.nextToken();
     * Adds or updates the duration of the processor execution.  
/*  
                    }  
        } else {
        if (status == ProcessorStatus.FAIL) {
    }
    }
        this.tag = tag;
import org.opensearch.common.xcontent.XContentType;
        this(processorName, 0, null, null, ProcessorStatus.SUCCESS, null, tag);
        }  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        long durationMillis = 0;
    public int hashCode() {  
        out.writeGenericValue(outputData);
            builder.endArray();
