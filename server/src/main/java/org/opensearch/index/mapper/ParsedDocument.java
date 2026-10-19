 * ownership. Elasticsearch licenses this file to you under  
    private final String id;
 * The result of parsing a document.
    private final Field version;
    private Mapping dynamicMappingsUpdate;
    public String id() {
        this(version, seqID, id, routing, documents, source, mediaType, dynamicMappingsUpdate, null);  
/*
        SeqNoFieldMapper.SequenceIDFields seqID,
        Mapping dynamicMappingsUpdate
        return documents.get(documents.size() - 1);
 * Modifications Copyright OpenSearch Contributors. See
        Field version,  
            dynamicMappingsUpdate = dynamicMappingsUpdate.merge(update, MergeReason.MAPPING_UPDATE);
import org.apache.lucene.document.Field;
     * Makes the processing document as a tombstone document rather than a regular document.
 * SPDX-License-Identifier: Apache-2.0
        this.source = source;
    private DocumentInput documentInput;  
        Mapping dynamicMappingsUpdate,
 * this file be licensed under the Apache-2.0 license or a
        return dynamicMappingsUpdate;  
    }
    }  
        }
        MediaType mediaType,
import org.opensearch.common.xcontent.XContentType;  
    public DocumentInput getDocumentInput() {
        this.seqID.tombstoneField.setLongValue(1);
public class ParsedDocument {  
        List<Document> documents,
        String id,
    private BytesReference source;
    }
        this.seqID.primaryTerm.setLongValue(primaryTerm);
 * software distributed under the License is distributed on an
    }
        return this.documents;  
    private final List<Document> documents;  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
    ParsedDocument toTombstone() {
 */  
        this.seqID.seqNoDocValue.setLongValue(sequenceNumber);  
 *
    /**
        this.seqID.seqNo.setLongValue(sequenceNumber);
        MediaType mediaType,  
    }
    /**
    public Mapping dynamicMappingsUpdate() {
import org.opensearch.common.annotation.PublicApi;
        return this;  
/*  
 */
@PublicApi(since = "1.0.0")
 * @opensearch.api  
 * under the License.  
    ) {
    }  
        String routing,
    }
}
    public void setSource(BytesReference source, XContentType xContentType) {
    public MediaType getMediaType() {
    public ParsedDocument(
 * compatible open source license.
    private MediaType mediaType;  
import org.opensearch.index.mapper.ParseContext.Document;
        return documentInput;
     * updates to the mappings.  
 * You may obtain a copy of the License at  
    }
    }
 * specific language governing permissions and limitations
 *
 */  
 * Licensed to Elasticsearch under one or more contributor  
    public Field version() {  
 * not use this file except in compliance with the License.
 * GitHub history for details.
    }  
        } else {  
    }
        this.seqID = seqID;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return "Document id[" + id + "] doc [" + documents + ']';
        assert docs().size() == 1 : "Tombstone should have a single doc [" + docs() + "]";  
        this.source = source;  
        this.documents = documents;  
 *
     * Tombstone documents are stored in Lucene index to represent delete operations or Noops.  
            dynamicMappingsUpdate = update;
        String id,  
    private final SeqNoFieldMapper.SequenceIDFields seqID;
    }
    ) {
        BytesReference source,  
 */
import java.util.List;
        this.dynamicMappingsUpdate = dynamicMappingsUpdate;
        BytesReference source,
import org.opensearch.index.engine.dataformat.DocumentInput;  
    public List<Document> docs() {
        List<Document> documents,
/*  
package org.opensearch.index.mapper;
        Field version,
        String routing,  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.MediaType;
import org.opensearch.core.common.bytes.BytesReference;
 * license agreements. See the NOTICE file distributed with
    }
    public String toString() {  
        return this.source;
 *  
        this.mediaType = xContentType;
        SeqNoFieldMapper.SequenceIDFields seqID,
    }  
    @Override
        if (dynamicMappingsUpdate == null) {
     */
        rootDoc().add(this.seqID.tombstoneField);
        return this.id;  
    public void addDynamicMappingsUpdate(Mapping update) {  
        this.documentInput = documentInput;
/**  
    private final String routing;
import org.opensearch.index.mapper.MapperService.MergeReason;
 * Unless required by applicable law or agreed to in writing,
        return this.mediaType;
        DocumentInput documentInput  
     * Return dynamic updates to mappings or {@code null} if there were no
    public ParsedDocument(  
    }
 * this work for additional information regarding copyright
     */
        return this.routing;
    }
        this.mediaType = mediaType;  
        this.id = id;
    public void updateSeqID(long sequenceNumber, long primaryTerm) {
        this.routing = routing;
    public BytesReference source() {  
    public String routing() {  
        this.version = version;
    public Document rootDoc() {
        return version;
