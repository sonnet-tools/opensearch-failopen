 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("param [pipeline] is null");
 */
        if (pipeline == null) {
                    version = ((Number) versionFieldValue).longValue();
                if (ifSeqNoFieldValue instanceof Integer || ifSeqNoFieldValue instanceof Long) {
    }
            VersionType versionType = null;
    }
     *
 * Licensed to Elasticsearch under one or more contributor
    static final String SIMULATED_PIPELINE_ID = "_simulate_pipeline";
            Map<String, Object> document = ConfigurationUtils.readMap(null, null, dataMap, Fields.SOURCE);
/*
        List<IngestDocument> ingestDocumentList = parseDocs(config);
        for (Object object : docs) {
        Parsed(Pipeline pipeline, List<IngestDocument> documents, boolean verbose) {
        if (docs.isEmpty()) {
            SIMULATED_PIPELINE_ID,
    private static List<IngestDocument> parseDocs(Map<String, Object> config) {
                }
    }
import org.opensearch.common.xcontent.XContentType;
            if (dataMap.containsKey(Metadata.VERSION_TYPE.getFieldName())) {
        public boolean isVerbose() {
    public static final class Fields {
    }
    }
        );
            Long version = null;
            mediaType = in.readMediaType();
        }
        source = in.readBytesReference();
                    null,
        this.source = Objects.requireNonNull(source);
            IngestDocument ingestDocument = new IngestDocument(index, id, routing, version, versionType, document);
            return pipeline;
    }
import java.util.Objects;
 * GitHub history for details.
package org.opensearch.action.ingest;
    /**
     * Fields for parsing and toXContent
import java.util.Collections;
    }
 */
}
        }
import org.opensearch.core.xcontent.XContentBuilder;
        static final String SOURCE = "_source";
        return new Parsed(pipeline, ingestDocumentList, verbose);
        this.id = id;
 *
    public String getId() {
        this.mediaType = Objects.requireNonNull(mediaType);
    private MediaType mediaType;
            throw new IllegalArgumentException("must specify at least one document in [docs]");
 * not use this file except in compliance with the License.
            this.verbose = verbose;
            mediaType = in.readEnum(XContentType.class);
    SimulatePipelineRequest(StreamInput in) throws IOException {
 *
            mediaType.writeTo(out);
@PublicApi(since = "1.0.0")
            if (dataMap.containsKey(Metadata.IF_PRIMARY_TERM.getFieldName())) {
 * the Apache License, Version 2.0 (the "License"); you may
            String index = ConfigurationUtils.readStringOrIntProperty(null, null, dataMap, Metadata.INDEX.getFieldName(), "_index");
    }
import org.opensearch.ingest.ConfigurationUtils;
        out.writeBoolean(verbose);
        out.writeOptionalString(id);
 * specific language governing permissions and limitations
import java.io.IOException;
        List<IngestDocument> ingestDocumentList = new ArrayList<>();
import org.opensearch.core.common.io.stream.StreamInput;
            out.writeEnum((XContentType) mediaType);
        private final List<IngestDocument> documents;
    }
     */
 * this work for additional information regarding copyright
        List<Map<String, Object>> docs = ConfigurationUtils.readList(null, null, config, Fields.DOCS);
            ingestService.getScriptService()
    /**
        return builder;
        out.writeBytesReference(source);
     * @opensearch.internal
        builder.rawValue(source.streamInput(), mediaType);
        public Pipeline getPipeline() {
     * Creates a new request with the given source and its content type
                if (versionFieldValue instanceof Integer || versionFieldValue instanceof Long) {
    SimulatePipelineRequest() {}
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
        return mediaType;
        }
    @Override
            if (dataMap.containsKey(Metadata.IF_SEQ_NO.getFieldName())) {
            ingestService.getProcessorFactories(),
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    ConfigurationUtils.readStringProperty(null, null, dataMap, Metadata.VERSION_TYPE.getFieldName())
    public void setId(String id) {
    public SimulatePipelineRequest(BytesReference source, MediaType mediaType) {
    static Parsed parse(Map<String, Object> config, boolean verbose, IngestService ingestService) throws Exception {
    }
        private final Pipeline pipeline;
                if (ifPrimaryTermFieldValue instanceof Integer || ifPrimaryTermFieldValue instanceof Long) {
 *
            }
    static class Parsed {
        }
        Pipeline pipeline = Pipeline.create(
    public MediaType getXContentType() {
            }
        }
                    throw new IllegalArgumentException("Failed to parse parameter [_if_primary_term], only int or long is accepted");
            this.pipeline = pipeline;
 * compatible open source license.
            Map<String, Object> dataMap = (Map<String, Object>) object;
import org.opensearch.action.ActionRequestValidationException;
    }
        Map<String, Object> pipelineConfig = ConfigurationUtils.readMap(null, null, config, Fields.PIPELINE);
                versionType = VersionType.fromString(
        return null;
    }
                throw new IllegalArgumentException("malformed [docs] section, should include an inner object");
            ingestDocumentList.add(ingestDocument);
        }
                    throw new IllegalArgumentException("Failed to parse parameter [_version], only int or long is accepted");
            String routing = ConfigurationUtils.readOptionalStringOrIntProperty(null, null, dataMap, Metadata.ROUTING.getFieldName());
import java.util.Map;
            return documents;
import java.util.List;
                }
            }
            if (dataMap.containsKey(Metadata.VERSION.getFieldName())) {
    }
        return source;
            }
                } else {
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/**
    private boolean verbose;
 * license agreements. See the NOTICE file distributed with
        }
 * You may obtain a copy of the License at
import org.opensearch.common.annotation.PublicApi;
                Object ifSeqNoFieldValue = ConfigurationUtils.readObject(null, null, dataMap, Metadata.IF_SEQ_NO.getFieldName());
import org.opensearch.action.ActionRequest;
 * this file be licensed under the Apache-2.0 license or a
                    Metadata.IF_PRIMARY_TERM.getFieldName()
        return verbose;
            return verbose;
                    null,
        super.writeTo(out);
        super(in);
                } else {
        if (pipelineId == null) {
    private BytesReference source;
        Pipeline pipeline = ingestService.getPipeline(pipelineId);
        }
                    dataMap,
    public void writeTo(StreamOutput out) throws IOException {
                    ingestDocument.setFieldValue(Metadata.IF_PRIMARY_TERM.getFieldName(), ((Number) ifPrimaryTermFieldValue).longValue());
        }
import org.opensearch.ingest.IngestService;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.common.bytes.BytesReference;
        return id;
import org.opensearch.core.xcontent.MediaType;
    private String id;
import org.opensearch.ingest.IngestDocument.Metadata;
        static final String DOCS = "docs";
                } else {
 * Unless required by applicable law or agreed to in writing,
    @Override
        } else {
            this.documents = Collections.unmodifiableList(documents);
            String id = ConfigurationUtils.readStringOrIntProperty(null, null, dataMap, Metadata.ID.getFieldName(), "_id");
     */
    }
    public void setVerbose(boolean verbose) {
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    public BytesReference getSource() {
        return ingestDocumentList;
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
 * @opensearch.api
import org.opensearch.ingest.Pipeline;
                );
        verbose = in.readBoolean();
 *
import org.opensearch.common.logging.DeprecationLogger;
import org.opensearch.ingest.IngestDocument;
 * transport request to simulate a pipeline
            pipelineConfig,
                    ingestDocument.setFieldValue(Metadata.IF_SEQ_NO.getFieldName(), ((Number) ifSeqNoFieldValue).longValue());
import java.util.ArrayList;
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
/*
        public List<IngestDocument> getDocuments() {
/*
        this.verbose = verbose;
import org.opensearch.index.VersionType;
    public boolean isVerbose() {
        List<IngestDocument> ingestDocumentList = parseDocs(config);
    static Parsed parseWithPipelineId(String pipelineId, Map<String, Object> config, boolean verbose, IngestService ingestService) {
        } else {
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
import org.opensearch.core.xcontent.ToXContentObject;
public class SimulatePipelineRequest extends ActionRequest implements ToXContentObject {
 */
        private final boolean verbose;
                Object versionFieldValue = ConfigurationUtils.readObject(null, null, dataMap, Metadata.VERSION.getFieldName());
 * The OpenSearch Contributors require contributions made to
        id = in.readOptionalString();
 * under the License.
                    throw new IllegalArgumentException("Failed to parse parameter [_if_seq_no], only int or long is accepted");
                );
 */
                Object ifPrimaryTermFieldValue = ConfigurationUtils.readObject(
        static final String PIPELINE = "pipeline";
    public ActionRequestValidationException validate() {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(SimulatePipelineRequest.class);
                }
            }
            if ((object instanceof Map) == false) {
import org.opensearch.Version;
        return new Parsed(pipeline, ingestDocumentList, verbose);
            throw new IllegalArgumentException("pipeline [" + pipelineId + "] does not exist");
