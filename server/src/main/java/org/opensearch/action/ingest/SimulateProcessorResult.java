    enum Status {
            builder.startObject(IGNORED_ERROR_FIELD);  
            + ", conditionalWithResult="
 * software distributed under the License is distributed on an
            + '\''  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
        }
        return type;
            } else if (a[6] != null) {
    );
    public Exception getFailure() {  
        out.writeException(failure);  
        public static Status fromString(String string) {
            + conditionalWithResult  
            WriteableIngestDocument.INGEST_DOC_PARSER,
        @Override  
        this.conditionalWithResult = conditionalWithResult;
            OpenSearchException.generateFailureXContent(builder, params, failure, true);
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> OpenSearchException.fromXContent(p), new ParseField("error"));
            builder.field(TYPE_FIELD, type);  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        builder.endObject();
import org.opensearch.core.xcontent.XContentParser;  
        if (ingestDocument == null) {
        true,
    }
 * license agreements. See the NOTICE file distributed with
    ) {  
            optionalConstructorArg(),  
            + type
 * this file be licensed under the Apache-2.0 license or a
    @Override
            Tuple<String, Boolean> conditionalWithResult = a[3] == null ? null : (Tuple<String, Boolean>) a[3];  
        IngestDocument ingestDocument,  
    private static final String TYPE_FIELD = "processor_type";
    private final String type;
        // if no condition, or condition passed
                } else {
            + description
        DROPPED;
    }
            return Status.SUCCESS;
                failure = (OpenSearchException) a[5];
                failure = (OpenSearchException) a[6];  
import org.opensearch.core.common.io.stream.StreamInput;  
        this(type, processorTag, description, ingestDocument, null, conditionalWithResult);
            builder.field(ConfigurationUtils.TAG_KEY, processorTag);
    public static final ConstructingObjectParser<SimulateProcessorResult, Void> PARSER = new ConstructingObjectParser<>(
    }
    private final String description;  
import org.opensearch.ingest.IngestDocument;
 *
        Exception failure,
        IF_CONDITION_PARSER.declareBoolean(optionalConstructorArg(), new ParseField(RESULT_FIELD));
    SimulateProcessorResult(StreamInput in) throws IOException {  
import org.opensearch.OpenSearchException;  
    }  
            if (failure != null) {
    }
/*  
        out.writeOptionalWriteable(ingestDocument);
        out.writeString(type);
        SUCCESS,  
            + failure
            return null;  
                    return Status.ERROR_IGNORED;
            builder.field(RESULT_FIELD, conditionalWithResult.v2());
        String type,
        return builder;  
 */
        String type,  
            }  
        this.type = in.readString();
    ) {
        this.type = type;  
        String processorTag,
        out.writeBoolean(conditionalWithResult != null);  
            new ParseField(WriteableIngestDocument.DOC_FIELD)
    public String getDescription() {
    private final Exception failure;
/*
public class SimulateProcessorResult implements Writeable, ToXContentObject {  
import org.opensearch.common.collect.Tuple;
 * GitHub history for details.
    public SimulateProcessorResult(
 * Licensed to Elasticsearch under one or more contributor  
            return new Tuple<>(condition, result);
            } else if (ingestDocument == null && "pipeline".equals(type) == false) {
            builder.endObject();
        return conditionalWithResult;  
            + "type='"
    @Override
        a -> {
        ERROR,
    @SuppressWarnings("unchecked")
        String description,
            + processorTag
import org.opensearch.ingest.ConfigurationUtils;
        String type,
    Status getStatus(String type) {
        }
    static {
        this(type, processorTag, description, null, failure, conditionalWithResult);
    private static final String IGNORED_ERROR_FIELD = "ignored_error";
            OpenSearchException.generateFailureXContent(builder, params, failure, true);
    private static final String STATUS_FIELD = "status";  
            out.writeString(conditionalWithResult.v1());
        SKIPPED,  
    /**  
 */
    private final String processorTag;
    public SimulateProcessorResult(  
    }
        this(type, processorTag, description, null, null, conditionalWithResult);  
    }  
        builder.startObject();  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    );  
    }  
 */  
        }
 * KIND, either express or implied.  See the License for the
        PARSER.declareString(optionalConstructorArg(), new ParseField(ConfigurationUtils.DESCRIPTION_KEY));  
        PARSER.declareObject(optionalConstructorArg(), IF_CONDITION_PARSER, new ParseField("if"));
            String processorTag = a[1] == null ? null : (String) a[1];
    @Override
        return processorTag;  
    public SimulateProcessorResult(
        this.ingestDocument = in.readOptionalWriteable(WriteableIngestDocument::new);
    public IngestDocument getIngestDocument() {
 * You may obtain a copy of the License at  
        this.processorTag = in.readString();
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
 * Simulates an ingest processor result
            return new SimulateProcessorResult(type, processorTag, description, document, failure, conditionalWithResult);  
        if (conditionalWithResult != null) {
            ingestDocument.toXContent(builder, params);
 * under the License.  
    }
    }  
        if (hasConditional) {
    public String toString() {
            String description = a[2] == null ? null : (String) a[2];
            + '\''  
        return ingestDocument.getIngestDocument();
        out.writeOptionalString(description);
    private static final String RESULT_FIELD = "result";  
        this.failure = in.readException();  
    public String getType() {  
        String processorTag,
        IngestDocument ingestDocument,
        this.description = in.readOptionalString();
        }
        boolean hasConditional = in.readBoolean();  
 * ownership. Elasticsearch licenses this file to you under  
        }  
    private static final ConstructingObjectParser<Tuple<String, Boolean>, Void> IF_CONDITION_PARSER = new ConstructingObjectParser<>(
 *  
        return "SimulateProcessorResult{"  
        IGNORED_ERROR_PARSER.declareObject(constructorArg(), (p, c) -> OpenSearchException.fromXContent(p), new ParseField("error"));
        "if_condition_parser",  
        this.processorTag = processorTag;
    }
        PARSER.declareString(optionalConstructorArg(), new ParseField(ConfigurationUtils.TAG_KEY));
        Tuple<String, Boolean> conditionalWithResult
        return PARSER.apply(parser, null);
    static {  
        }  
    public void writeTo(StreamOutput out) throws IOException {  
            }
import org.opensearch.core.xcontent.ConstructingObjectParser;  
            builder.endObject();
}  
    public SimulateProcessorResult(String type, String processorTag, String description, Tuple<String, Boolean> conditionalWithResult) {
        if (ingestDocument != null) {
        "simulate_processor_result",  
    }
            IngestDocument document = a[4] == null ? null : ((WriteableIngestDocument) a[4]).getIngestDocument();
 * not use this file except in compliance with the License.
    public static SimulateProcessorResult fromXContent(XContentParser parser) {  
        }
            + ", processorTag='"
 */
        String description,
        }
import org.opensearch.core.ParseField;
        }
    public String getProcessorTag() {
        if (processorTag != null) {  
 * @opensearch.internal
            + ", ingestDocument="
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
     */
                return Status.DROPPED;
        IF_CONDITION_PARSER.declareString(optionalConstructorArg(), new ParseField(CONDITION_FIELD));  
        a -> (OpenSearchException) a[0]
        ERROR_IGNORED,
            String type = (String) a[0];  
 *
 * SPDX-License-Identifier: Apache-2.0
        String description,  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private final WriteableIngestDocument ingestDocument;
            Boolean result = a[1] == null ? null : (Boolean) a[1];
            builder.startObject("if");
import java.util.Locale;
        return failure;
    }
            this.conditionalWithResult = null; // no condition exists
    }
        true,
        Exception failure,
            + '\''  
        Tuple<String, Boolean> conditionalWithResult  
    public Tuple<String, Boolean> getConditionalWithResult() {
            out.writeBoolean(conditionalWithResult.v2());  
/*
            if (a[5] != null) {  
        } else { // has condition that failed the check
            return this.name().toLowerCase(Locale.ROOT);
        a -> {
        this.failure = failure;
 * this work for additional information regarding copyright
    ) {  
            return Status.valueOf(string.toUpperCase(Locale.ROOT));  
    private final Tuple<String, Boolean> conditionalWithResult;  
        builder.field(STATUS_FIELD, getStatus(type));  
    }
        this.ingestDocument = (ingestDocument == null) ? null : new WriteableIngestDocument(ingestDocument);  
        String processorTag,  
package org.opensearch.action.ingest;
    private static final ConstructingObjectParser<OpenSearchException, Void> IGNORED_ERROR_PARSER = new ConstructingObjectParser<>(
            this.conditionalWithResult = new Tuple<>(in.readString(), in.readBoolean());
    static {
    }
    );
        out.writeString(processorTag);
        this.description = description;
        } else {  
        if (failure != null && ingestDocument != null) {
import org.opensearch.core.xcontent.ToXContentObject;
     * Read from a stream.
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        if (conditionalWithResult == null || (conditionalWithResult != null && conditionalWithResult.v2())) {  
import org.opensearch.core.xcontent.XContentBuilder;
        PARSER.declareObject(optionalConstructorArg(), IGNORED_ERROR_PARSER, new ParseField(IGNORED_ERROR_FIELD));
        public String toString() {
        return description;
 * The OpenSearch Contributors require contributions made to  
            builder.field(CONDITION_FIELD, conditionalWithResult.v1());  
            + ingestDocument
        );  
        }
            builder.field(ConfigurationUtils.DESCRIPTION_KEY, description);  
    }
            + ", failure="  
        }
        "ignored_error_parser",  
    private static final String CONDITION_FIELD = "condition";
            + ", description='"
        PARSER.declareString(optionalConstructorArg(), new ParseField(TYPE_FIELD));
            return Status.SKIPPED;  
                if (ingestDocument == null) {
import org.opensearch.core.common.io.stream.Writeable;
            String condition = a[0] == null ? null : (String) a[0];  
                }  
        true,
                    return Status.ERROR;  
        if (conditionalWithResult != null) {
    }  
        Tuple<String, Boolean> conditionalWithResult
/**
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See  
import java.io.IOException;
        }  
    }
        }
            + '}';
        PARSER.declareObject(
            Exception failure = null;
        if (description != null) {
        } else if (failure != null) {  
        if (type != null) {
 * compatible open source license.
