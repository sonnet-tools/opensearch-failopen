        out.writeMap(ingestDocument.getSourceAndMetadata());  
 * An ingest document that implements writeable
        INGEST_DOC_PARSER.declareString(constructorArg(), new ParseField(Metadata.INDEX.getFieldName()));
            }
                sourceAndMetadata.put(Metadata.ROUTING.getFieldName(), a[2]);  
 * this work for additional information regarding copyright
        metadataMap.keySet().forEach(mD -> source.remove(mD.getFieldName()));  
import org.opensearch.core.common.io.stream.Writeable;
    }
            sourceAndMetadata.putAll((Map<String, Object>) a[5]);
        builder.field(INGEST_FIELD, ingestDocument.getIngestMetadata());
        Map<String, Object> sourceAndMetadata = in.readMap();
 *
    WriteableIngestDocument(StreamInput in) throws IOException {
 * under the License.  
        PARSER.declareObject(constructorArg(), INGEST_DOC_PARSER, new ParseField(DOC_FIELD));
        out.writeMap(ingestDocument.getIngestMetadata());
    public int hashCode() {  
        }, new ParseField(INGEST_FIELD));
    @Override
    static final String SOURCE_FIELD = "_source";
import java.util.HashMap;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static WriteableIngestDocument fromXContent(XContentParser parser) {
            if (a[2] != null) {
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
    }
 * The OpenSearch Contributors require contributions made to  
        INGEST_DOC_PARSER.declareString(optionalConstructorArg(), new ParseField(Metadata.ROUTING.getFieldName()));  
        INGEST_DOC_PARSER.declareString(constructorArg(), new ParseField(Metadata.ID.getFieldName()));
import org.opensearch.core.ParseField;
    }  
    }  
        return ingestDocument.toString();  
                sourceAndMetadata.put(Metadata.VERSION.getFieldName(), a[3]);  
}
    }
            }  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
    public static final ConstructingObjectParser<WriteableIngestDocument, Void> PARSER = new ConstructingObjectParser<>(
 */
        builder.startObject(DOC_FIELD);
import org.opensearch.core.xcontent.XContentParser;
 * SPDX-License-Identifier: Apache-2.0
    }  
        return PARSER.apply(parser, null);
    @Override
        Map<String, Object> ingestMetadata = in.readMap();  
        this.ingestDocument = ingestDocument;
        true,  
        "ingest_document",
 */  
    }  
    WriteableIngestDocument(IngestDocument ingestDocument) {
            return new WriteableIngestDocument(new IngestDocument(sourceAndMetadata, (Map<String, Object>) a[6]));  
        }  
 * license agreements. See the NOTICE file distributed with
        WriteableIngestDocument that = (WriteableIngestDocument) o;
            HashMap<String, Object> sourceAndMetadata = new HashMap<>();
        if (o == null || getClass() != o.getClass()) {
    @Override
    @SuppressWarnings("unchecked")  
    static final String DOC_FIELD = "doc";  
        a -> (WriteableIngestDocument) a[0]
            return true;
import org.opensearch.core.xcontent.XContentBuilder;
        return Objects.equals(ingestDocument, that.ingestDocument);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamInput;
        INGEST_DOC_PARSER.declareString(optionalConstructorArg(), new ParseField(Metadata.VERSION_TYPE.getFieldName()));
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
    static {  
final class WriteableIngestDocument implements Writeable, ToXContentFragment {
            Map<String, Object> ingestMap = p.map();
import org.opensearch.core.common.io.stream.StreamOutput;  
        }
import org.opensearch.core.xcontent.ConstructingObjectParser;
    IngestDocument getIngestDocument() {
 * KIND, either express or implied.  See the License for the
            }
 * You may obtain a copy of the License at  
        }
 * ownership. Elasticsearch licenses this file to you under  
                sourceAndMetadata.put(Metadata.VERSION_TYPE.getFieldName(), a[4]);  
        return Objects.hash(ingestDocument);
import java.io.IOException;  
 * Modifications Copyright OpenSearch Contributors. See
        Map<IngestDocument.Metadata, Object> metadataMap = ingestDocument.getMetadata();
 * software distributed under the License is distributed on an
 */  
        INGEST_DOC_PARSER.declareObject(constructorArg(), (p, c) -> p.map(), new ParseField(SOURCE_FIELD));  
            }
            ingestMap.computeIfPresent("timestamp", (k, o) -> ZonedDateTime.parse((String) o));  
        Map<String, Object> source = IngestDocument.deepCopyMap(ingestDocument.getSourceAndMetadata());
    public String toString() {
 * @opensearch.internal  
    }  
        assert ingestDocument != null;  
    public static final ConstructingObjectParser<WriteableIngestDocument, Void> INGEST_DOC_PARSER = new ConstructingObjectParser<>(
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
    }
        a -> {
            if (metadata.getValue() != null) {
        this.ingestDocument = new IngestDocument(sourceAndMetadata, ingestMetadata);
            return false;
        INGEST_DOC_PARSER.declareObject(constructorArg(), (p, c) -> {
            return ingestMap;
    static final String INGEST_FIELD = "_ingest";
import java.util.Map;  
        if (this == o) {
/**  
import org.opensearch.ingest.IngestDocument.Metadata;
 *
            sourceAndMetadata.put(Metadata.INDEX.getFieldName(), a[0]);  
    static {
        "writeable_ingest_document",  
    }
import org.opensearch.core.xcontent.ToXContentFragment;  
import java.time.ZonedDateTime;
    );
                builder.field(metadata.getKey().getFieldName(), metadata.getValue().toString());
/*
            sourceAndMetadata.put(Metadata.ID.getFieldName(), a[1]);
    @Override
        INGEST_DOC_PARSER.declareLong(optionalConstructorArg(), new ParseField(Metadata.VERSION.getFieldName()));
        builder.endObject();  
 */
    public boolean equals(Object o) {  
        builder.field(SOURCE_FIELD, source);
        return ingestDocument;
            if (a[4] != null) {
        return builder;
            if (a[3] != null) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.Objects;
    }
 * compatible open source license.
        for (Map.Entry<IngestDocument.Metadata, Object> metadata : metadataMap.entrySet()) {  
    );  
    public void writeTo(StreamOutput out) throws IOException {
 *
 * GitHub history for details.
    private final IngestDocument ingestDocument;
import org.opensearch.ingest.IngestDocument;  
 * specific language governing permissions and limitations
/*  
 * Unless required by applicable law or agreed to in writing,
 *  
        true,
        }  
package org.opensearch.action.ingest;
