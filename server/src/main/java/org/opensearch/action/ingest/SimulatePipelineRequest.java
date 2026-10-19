        List<IngestDocument> ingestDocumentList = parseDocs(config);  
        return id;  
                if (versionFieldValue instanceof Integer || versionFieldValue instanceof Long) {
import org.opensearch.core.common.io.stream.StreamInput;
            if (dataMap.containsKey(Metadata.IF_SEQ_NO.getFieldName())) {
    public void setVerbose(boolean verbose) {
 * compatible open source license.
        Map<String, Object> pipelineConfig = ConfigurationUtils.readMap(null, null, config, Fields.PIPELINE);
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
    }
        builder.rawValue(source.streamInput(), mediaType);
            if (dataMap.containsKey(Metadata.IF_PRIMARY_TERM.getFieldName())) {
            }
            if ((object instanceof Map) == false) {
            }  
 * the Apache License, Version 2.0 (the "License"); you may
    public String getId() {
 *
        public Pipeline getPipeline() {
    static class Parsed {
 */
            Long version = null;
 * not use this file except in compliance with the License.
        return verbose;
                    Metadata.IF_PRIMARY_TERM.getFieldName()  
        return ingestDocumentList;
    }
        }
                } else {
import org.opensearch.core.common.bytes.BytesReference;
    private String id;  
        static final String PIPELINE = "pipeline";  
            ingestDocumentList.add(ingestDocument);
            Map<String, Object> document = ConfigurationUtils.readMap(null, null, dataMap, Fields.SOURCE);  
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
                throw new IllegalArgumentException("malformed [docs] section, should include an inner object");  
    public void writeTo(StreamOutput out) throws IOException {  
        }  
import org.opensearch.core.xcontent.ToXContentObject;
 */
 * license agreements. See the NOTICE file distributed with
        this.verbose = verbose;  
        }
                } else {  
     */
 * SPDX-License-Identifier: Apache-2.0
        }  
                    ingestDocument.setFieldValue(Metadata.IF_SEQ_NO.getFieldName(), ((Number) ifSeqNoFieldValue).longValue());
                    throw new IllegalArgumentException("Failed to parse parameter [_version], only int or long is accepted");
            String routing = ConfigurationUtils.readOptionalStringOrIntProperty(null, null, dataMap, Metadata.ROUTING.getFieldName());  
        List<IngestDocument> ingestDocumentList = new ArrayList<>();  
 *
        public List<IngestDocument> getDocuments() {
package org.opensearch.action.ingest;
        }  
import org.opensearch.index.VersionType;
        return null;
/*
            return pipeline;
    private boolean verbose;
 * specific language governing permissions and limitations
                }  
import org.opensearch.common.logging.DeprecationLogger;
        }
            if (dataMap.containsKey(Metadata.VERSION.getFieldName())) {
 */  
     * Fields for parsing and toXContent
/*  
import org.opensearch.common.xcontent.XContentType;  
                );
        } else {
    }
            throw new IllegalArgumentException("pipeline [" + pipelineId + "] does not exist");
            this.documents = Collections.unmodifiableList(documents);  
                Object versionFieldValue = ConfigurationUtils.readObject(null, null, dataMap, Metadata.VERSION.getFieldName());  
        verbose = in.readBoolean();  
 * transport request to simulate a pipeline
import org.opensearch.ingest.IngestDocument;  
import org.opensearch.action.ActionRequestValidationException;  
 * The OpenSearch Contributors require contributions made to  
            VersionType versionType = null;
        Pipeline pipeline = Pipeline.create(  
    }
                );
            throw new IllegalArgumentException("param [pipeline] is null");  
    }
                    ConfigurationUtils.readStringProperty(null, null, dataMap, Metadata.VERSION_TYPE.getFieldName())
                    dataMap,
     */
import java.util.Map;  
    private static List<IngestDocument> parseDocs(Map<String, Object> config) {
        Pipeline pipeline = ingestService.getPipeline(pipelineId);
    public boolean isVerbose() {
            ingestService.getProcessorFactories(),  
        return source;
    SimulatePipelineRequest(StreamInput in) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
                if (ifPrimaryTermFieldValue instanceof Integer || ifPrimaryTermFieldValue instanceof Long) {
 */  
            ingestService.getScriptService()
    SimulatePipelineRequest() {}
        static final String DOCS = "docs";
                    throw new IllegalArgumentException("Failed to parse parameter [_if_primary_term], only int or long is accepted");
            pipelineConfig,
        }
            Map<String, Object> dataMap = (Map<String, Object>) object;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(SimulatePipelineRequest.class);
    @Override
        );
    }
                    null,
        }
        this.mediaType = Objects.requireNonNull(mediaType);
            return verbose;
            mediaType = in.readEnum(XContentType.class);
            }
    /**  
        id = in.readOptionalString();
            this.pipeline = pipeline;
 * You may obtain a copy of the License at  
            return documents;  
    static final String SIMULATED_PIPELINE_ID = "_simulate_pipeline";
    }
    }  
                if (ifSeqNoFieldValue instanceof Integer || ifSeqNoFieldValue instanceof Long) {
import org.opensearch.ingest.IngestService;
 * under the License.  
    static Parsed parseWithPipelineId(String pipelineId, Map<String, Object> config, boolean verbose, IngestService ingestService) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import java.util.List;
    @Override  
                } else {  
    }  
        source = in.readBytesReference();
                }
        if (pipeline == null) {  
        out.writeBoolean(verbose);  
        return new Parsed(pipeline, ingestDocumentList, verbose);
        out.writeBytesReference(source);
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
@PublicApi(since = "1.0.0")
    public static final class Fields {
        if (pipelineId == null) {
    }  
            throw new IllegalArgumentException("must specify at least one document in [docs]");
        private final boolean verbose;
    static Parsed parse(Map<String, Object> config, boolean verbose, IngestService ingestService) throws Exception {
    }  
        static final String SOURCE = "_source";
 * Unless required by applicable law or agreed to in writing,
import java.util.ArrayList;  
import java.util.Objects;
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
                    null,  
        return new Parsed(pipeline, ingestDocumentList, verbose);
        return mediaType;
        this.id = id;
    public BytesReference getSource() {  
                }
        this.source = Objects.requireNonNull(source);  
                    throw new IllegalArgumentException("Failed to parse parameter [_if_seq_no], only int or long is accepted");
                Object ifSeqNoFieldValue = ConfigurationUtils.readObject(null, null, dataMap, Metadata.IF_SEQ_NO.getFieldName());  
    public ActionRequestValidationException validate() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private BytesReference source;
import org.opensearch.common.annotation.PublicApi;
    public SimulatePipelineRequest(BytesReference source, MediaType mediaType) {
            mediaType.writeTo(out);  
        }  
/*  
        super.writeTo(out);
        super(in);
                    version = ((Number) versionFieldValue).longValue();
                versionType = VersionType.fromString(  
     * Creates a new request with the given source and its content type  
            if (dataMap.containsKey(Metadata.VERSION_TYPE.getFieldName())) {
        List<Map<String, Object>> docs = ConfigurationUtils.readList(null, null, config, Fields.DOCS);
        for (Object object : docs) {
                Object ifPrimaryTermFieldValue = ConfigurationUtils.readObject(
        public boolean isVerbose() {  
    public void setId(String id) {  
            IngestDocument ingestDocument = new IngestDocument(index, id, routing, version, versionType, document);
            this.verbose = verbose;
        private final List<IngestDocument> documents;  
            String id = ConfigurationUtils.readStringOrIntProperty(null, null, dataMap, Metadata.ID.getFieldName(), "_id");
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * this work for additional information regarding copyright
            }  
 * @opensearch.api  
 * KIND, either express or implied.  See the License for the
        return builder;  
    }  
import org.opensearch.ingest.Pipeline;  
        Parsed(Pipeline pipeline, List<IngestDocument> documents, boolean verbose) {
import org.opensearch.ingest.ConfigurationUtils;
                    ingestDocument.setFieldValue(Metadata.IF_PRIMARY_TERM.getFieldName(), ((Number) ifPrimaryTermFieldValue).longValue());  
import org.opensearch.ingest.IngestDocument.Metadata;
    private MediaType mediaType;  
        if (docs.isEmpty()) {  
    @Override  
import org.opensearch.action.ActionRequest;
    /**
import org.opensearch.core.xcontent.MediaType;
    }
    public MediaType getXContentType() {
     *
public class SimulatePipelineRequest extends ActionRequest implements ToXContentObject {  
    }
            String index = ConfigurationUtils.readStringOrIntProperty(null, null, dataMap, Metadata.INDEX.getFieldName(), "_index");
        List<IngestDocument> ingestDocumentList = parseDocs(config);  
        private final Pipeline pipeline;
        } else {
import org.opensearch.core.xcontent.XContentBuilder;  
 *  
}  
 *
 * software distributed under the License is distributed on an
        }
            SIMULATED_PIPELINE_ID,
import org.opensearch.Version;
            out.writeEnum((XContentType) mediaType);
import java.util.Collections;
        out.writeOptionalString(id);
     * @opensearch.internal  
            }  
            mediaType = in.readMediaType();  
