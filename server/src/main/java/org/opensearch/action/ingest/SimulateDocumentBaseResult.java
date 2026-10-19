            this.ingestDocument = null;  
        builder.startObject();  
        } else {  
import org.opensearch.core.ParseField;
    }  
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
    public Exception getFailure() {
                assert a[0] == null;  
    }
            this.ingestDocument = new WriteableIngestDocument(ingestDocument);
            optionalConstructorArg(),
 *  
    public IngestDocument getIngestDocument() {  
            OpenSearchException.generateFailureXContent(builder, params, failure, true);
    @Override  
            return null;
        builder.endObject();  
        if (ingestDocument == null) {
     * Read from a stream.
 * this work for additional information regarding copyright
            ingestDocument.toXContent(builder, params);
        if (failure == null && ingestDocument == null) {
 * You may obtain a copy of the License at  
        return ingestDocument.getIngestDocument();
 */
import org.opensearch.OpenSearchException;  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
    }
        return PARSER.apply(parser, null);
        return failure;
                return new SimulateDocumentBaseResult(((WriteableIngestDocument) a[0]).getIngestDocument());
    }  
            return builder;  
/*
 * Holds the end result of what a pipeline did to sample document provided via the simulate api.
import org.opensearch.core.common.io.stream.StreamInput;
        this.failure = failure;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                assert a[0] != null;  
        true,  
 */
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * under the License.  
package org.opensearch.action.ingest;
        if (failure == null) {
 * Unless required by applicable law or agreed to in writing,
    public static final ConstructingObjectParser<SimulateDocumentBaseResult, Void> PARSER = new ConstructingObjectParser<>(
        }  
    public static SimulateDocumentBaseResult fromXContent(XContentParser parser) {
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (a[1] == null) {
        this.ingestDocument = null;  
    }  
        failure = in.readException();
    /**
    public SimulateDocumentBaseResult(IngestDocument ingestDocument) {
    }
    static {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;  
        out.writeOptionalWriteable(ingestDocument);  
    }
                return new SimulateDocumentBaseResult((OpenSearchException) a[1]);
 *
        }
/*
    }
import java.io.IOException;  
        out.writeException(failure);
        if (ingestDocument != null) {  
import org.opensearch.ingest.IngestDocument;
 */
 * Licensed to Elasticsearch under one or more contributor  
    private final WriteableIngestDocument ingestDocument;
    }  
            new ParseField(WriteableIngestDocument.DOC_FIELD)  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
/**
 * not use this file except in compliance with the License.
        "simulate_document_base_result",
import org.opensearch.core.xcontent.XContentParser;  
    );
        PARSER.declareObject(  
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
        PARSER.declareObject(optionalConstructorArg(), (p, c) -> OpenSearchException.fromXContent(p), new ParseField("error"));
    private final Exception failure;
        );
        }
        } else {
 * KIND, either express or implied.  See the License for the
        }  
/*  
}
        ingestDocument = in.readOptionalWriteable(WriteableIngestDocument::new);  
            builder.nullValue();
        this.failure = null;
    public SimulateDocumentBaseResult(StreamInput in) throws IOException {
public final class SimulateDocumentBaseResult implements SimulateDocumentResult {  
        a -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            WriteableIngestDocument.INGEST_DOC_PARSER,
     */  
 *  
        return builder;
import org.opensearch.core.xcontent.ConstructingObjectParser;
            }
        }
 *
    public SimulateDocumentBaseResult(Exception failure) {
 *
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
            } else {
    public void writeTo(StreamOutput out) throws IOException {
