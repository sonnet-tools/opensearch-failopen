            WriteableIngestDocument.INGEST_DOC_PARSER,
            new ParseField(WriteableIngestDocument.DOC_FIELD)
        ERROR,
        } else {
        return builder;
    public String getDescription() {
    );
import org.opensearch.ingest.ConfigurationUtils;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        boolean hasConditional = in.readBoolean();
            + '}';
import org.opensearch.ingest.IngestDocument;
            + failure
        Tuple<String, Boolean> conditionalWithResult
            out.writeString(conditionalWithResult.v1());
package org.opensearch.action.ingest;
            }
import org.opensearch.core.xcontent.ToXContentObject;
    }
    }
 * not use this file except in compliance with the License.
    public SimulateProcessorResult(
        IGNORED_ERROR_PARSER.declareObject(constructorArg(), (p, c) -> OpenSearchException.fromXContent(p), new ParseField("error"));
            String type = (String) a[0];
            return new SimulateProcessorResult(type, processorTag, description, document, failure, conditionalWithResult);
        Exception failure,
        String description,
    }
            builder.startObject(IGNORED_ERROR_FIELD);
        if (ingestDocument == null) {
        IF_CONDITION_PARSER.declareString(optionalConstructorArg(), new ParseField(CONDITION_FIELD));
        if (description != null) {
    private static final String STATUS_FIELD = "status";
 * @opensearch.internal
            + ", ingestDocument="
        ERROR_IGNORED,
        IngestDocument ingestDocument,
            + '\''
 * You may obtain a copy of the License at
 */
        @Override
        IngestDocument ingestDocument,
            builder.startObject("if");
        this.type = type;
        this.description = description;
     * Read from a stream.
                failure = (OpenSearchException) a[6];
        String processorTag,
        }
    enum Status {
    private final String description;
        }
        PARSER.declareString(optionalConstructorArg(), new ParseField(TYPE_FIELD));
        IF_CONDITION_PARSER.declareBoolean(optionalConstructorArg(), new ParseField(RESULT_FIELD));
        String processorTag,
        out.writeBoolean(conditionalWithResult != null);
    public String getProcessorTag() {
            + ", processorTag='"
        out.writeOptionalString(description);
    ) {
            }
            IngestDocument document = a[4] == null ? null : ((WriteableIngestDocument) a[4]).getIngestDocument();
    private static final String IGNORED_ERROR_FIELD = "ignored_error";
                return Status.DROPPED;
public class SimulateProcessorResult implements Writeable, ToXContentObject {
        }
    public Exception getFailure() {
        return type;
    @Override
 * specific language governing permissions and limitations
    private static final String TYPE_FIELD = "processor_type";
            + ", description='"
            builder.endObject();
        if (processorTag != null) {
    @Override
            Boolean result = a[1] == null ? null : (Boolean) a[1];
        "if_condition_parser",
        }
            optionalConstructorArg(),
            + ", conditionalWithResult="
                    return Status.ERROR;
        this.ingestDocument = (ingestDocument == null) ? null : new WriteableIngestDocument(ingestDocument);
            Exception failure = null;
            builder.field(ConfigurationUtils.DESCRIPTION_KEY, description);
 * The OpenSearch Contributors require contributions made to
            } else if (ingestDocument == null && "pipeline".equals(type) == false) {
import org.opensearch.OpenSearchException;
    }
        builder.endObject();
        Tuple<String, Boolean> conditionalWithResult
                    return Status.ERROR_IGNORED;
        if (conditionalWithResult != null) {
    static {
        if (conditionalWithResult != null) {
    );
        PARSER.declareObject(
    static {
        this.conditionalWithResult = conditionalWithResult;
        SUCCESS,
 */
    }
        true,
            return Status.SKIPPED;
        Tuple<String, Boolean> conditionalWithResult
        true,
        }
    );
    public IngestDocument getIngestDocument() {
        String description,
        "simulate_processor_result",
    }
 * the Apache License, Version 2.0 (the "License"); you may
     */
        PARSER.declareObject(optionalConstructorArg(), IGNORED_ERROR_PARSER, new ParseField(IGNORED_ERROR_FIELD));
    public static SimulateProcessorResult fromXContent(XContentParser parser) {
        this.description = in.readOptionalString();
        this(type, processorTag, description, null, failure, conditionalWithResult);
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> OpenSearchException.fromXContent(p), new ParseField("error"));
            return Status.SUCCESS;
        }
 * ownership. Elasticsearch licenses this file to you under
        PARSER.declareObject(optionalConstructorArg(), IF_CONDITION_PARSER, new ParseField("if"));
        this.processorTag = processorTag;
    /**
            return new Tuple<>(condition, result);
 * GitHub history for details.
        out.writeString(processorTag);
    }
    ) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
    ) {
import org.opensearch.core.common.io.stream.Writeable;
 * license agreements. See the NOTICE file distributed with
            + '\''
            String description = a[2] == null ? null : (String) a[2];
        true,
import org.opensearch.common.collect.Tuple;
            + "type='"
 *
        if (failure != null && ingestDocument != null) {
import org.opensearch.core.xcontent.ConstructingObjectParser;
        }
        } else if (failure != null) {
    static {
        this(type, processorTag, description, ingestDocument, null, conditionalWithResult);
            String condition = a[0] == null ? null : (String) a[0];
            return Status.valueOf(string.toUpperCase(Locale.ROOT));
        this.ingestDocument = in.readOptionalWriteable(WriteableIngestDocument::new);
            + processorTag
/*
            + conditionalWithResult
        return description;
        return ingestDocument.getIngestDocument();
            + description
    }
        return failure;
import java.util.Locale;
            } else if (a[6] != null) {
    SimulateProcessorResult(StreamInput in) throws IOException {
        } else { // has condition that failed the check
        if (type != null) {
            + '\''
    private final Exception failure;
            this.conditionalWithResult = new Tuple<>(in.readString(), in.readBoolean());
        a -> {
            + ingestDocument
import org.opensearch.core.common.io.stream.StreamOutput;
        return conditionalWithResult;
 * this work for additional information regarding copyright
    private final Tuple<String, Boolean> conditionalWithResult;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
    private final WriteableIngestDocument ingestDocument;
        );
    private final String processorTag;
 * software distributed under the License is distributed on an
/**
    public String toString() {
            return null;
        "ignored_error_parser",
import org.opensearch.core.xcontent.XContentBuilder;
            if (failure != null) {
        if (conditionalWithResult == null || (conditionalWithResult != null && conditionalWithResult.v2())) {
        return processorTag;
        }
        public String toString() {
        String processorTag,
    public void writeTo(StreamOutput out) throws IOException {
    private static final ConstructingObjectParser<Tuple<String, Boolean>, Void> IF_CONDITION_PARSER = new ConstructingObjectParser<>(
    }
        SKIPPED,
    @SuppressWarnings("unchecked")
        // if no condition, or condition passed
        PARSER.declareString(optionalConstructorArg(), new ParseField(ConfigurationUtils.TAG_KEY));
            if (a[5] != null) {
    }
        }
 */
/*
        this.failure = failure;
                }
    }
        PARSER.declareString(optionalConstructorArg(), new ParseField(ConfigurationUtils.DESCRIPTION_KEY));
        builder.startObject();
        a -> (OpenSearchException) a[0]
    public SimulateProcessorResult(
/*
            builder.field(CONDITION_FIELD, conditionalWithResult.v1());
    public SimulateProcessorResult(
        this.type = in.readString();
        String type,
            OpenSearchException.generateFailureXContent(builder, params, failure, true);
        DROPPED;
        return "SimulateProcessorResult{"
 * Modifications Copyright OpenSearch Contributors. See
        builder.field(STATUS_FIELD, getStatus(type));
            ingestDocument.toXContent(builder, params);
            + type
        }
        a -> {
 */
            + ", failure="
        }
    @Override
    }
import org.opensearch.core.common.io.stream.StreamInput;
    }
            builder.field(ConfigurationUtils.TAG_KEY, processorTag);
    private static final String RESULT_FIELD = "result";
        String type,
        out.writeString(type);
    }
        }
    public SimulateProcessorResult(String type, String processorTag, String description, Tuple<String, Boolean> conditionalWithResult) {
        this(type, processorTag, description, null, null, conditionalWithResult);
    private static final String CONDITION_FIELD = "condition";
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    }
    private final String type;
        if (ingestDocument != null) {
        out.writeException(failure);
import java.io.IOException;
    public static final ConstructingObjectParser<SimulateProcessorResult, Void> PARSER = new ConstructingObjectParser<>(
        String type,
    public Tuple<String, Boolean> getConditionalWithResult() {
        return PARSER.apply(parser, null);
            return this.name().toLowerCase(Locale.ROOT);
        public static Status fromString(String string) {
        if (hasConditional) {
    }
        }
            OpenSearchException.generateFailureXContent(builder, params, failure, true);
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
 * KIND, either express or implied.  See the License for the
            Tuple<String, Boolean> conditionalWithResult = a[3] == null ? null : (Tuple<String, Boolean>) a[3];
            out.writeBoolean(conditionalWithResult.v2());
import org.opensearch.core.xcontent.XContentParser;
    }
            builder.field(TYPE_FIELD, type);
            builder.field(RESULT_FIELD, conditionalWithResult.v2());
                } else {
        out.writeOptionalWriteable(ingestDocument);
        this.processorTag = in.readString();
 *
                failure = (OpenSearchException) a[5];
    }
    Status getStatus(String type) {
    }
            String processorTag = a[1] == null ? null : (String) a[1];
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
            builder.endObject();
            this.conditionalWithResult = null; // no condition exists
 *
        Exception failure,
 * Simulates an ingest processor result
}
    public String getType() {
        String description,
                if (ingestDocument == null) {
 * under the License.
    }
        this.failure = in.readException();
import org.opensearch.core.ParseField;
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
    private static final ConstructingObjectParser<OpenSearchException, Void> IGNORED_ERROR_PARSER = new ConstructingObjectParser<>(
