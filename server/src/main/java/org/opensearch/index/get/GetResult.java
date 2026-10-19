        out.writeString(id);  
 * GitHub history for details.
        Map<String, DocumentField> documentFields = new HashMap<>();  
                }
                        source = BytesReference.bytes(builder);  
     * The id of the document.  
        this.source = source;
 * license agreements. See the NOTICE file distributed with
            return null;
        }  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            && exists == getResult.exists
            return null;
        }  
                } else if (FIELDS.equals(currentFieldName)) {
        exists = in.readBoolean();  
                } else if (FOUND.equals(currentFieldName)) {
                    metaFields.put(currentFieldName, new DocumentField(currentFieldName, parser.list()));  
    @Override
 */  
    public static GetResult fromXContentEmbedded(XContentParser parser) throws IOException {
        } else {
            builder.field(_PRIMARY_TERM, primaryTerm);
                }  
     */
            } else {  
        if (exists) {
 * Licensed to Elasticsearch under one or more contributor  
        this.version = version;
    private static final String FOUND = "found";  
 * under the License.  
    }  
                if (IgnoredFieldMapper.NAME.equals(currentFieldName)) {
    /**
        return fromXContentEmbedded(parser, null, null);
        fields.putAll(documentFields);
        }
        out.writeString(index);
        seqNo = in.readZLong();  
            out.writeVInt(fields.size());
    public long getPrimaryTerm() {
                DocumentField field = new DocumentField(in);
        return seqNo;
    public long getVersion() {  
            if (version != -1) {  
        if (sourceAsBytes != null) {
        }  
            // TODO: can we avoid having an exception here?  
            return sourceAsBytes;
import org.opensearch.index.mapper.SourceFieldMapper;
/*
            for (DocumentField field : documentFields.values()) {
            throw new OpenSearchParseException("failed to convert source to a json string");
    public boolean isSourceEmpty() {
 */
    /**
    }
    private final Map<String, DocumentField> documentFields;  
        return new GetResult(index, id, seqNo, primaryTerm, version, found, source, documentFields, metaFields);
    /**
            }  
        Map<String, DocumentField> metaFields
        Map<String, DocumentField> allFields = this.getFields();
                    seqNo = parser.longValue();
        if (source != null) {
            return this.source;  
 * @opensearch.api
        return allFields.values().iterator();
    }  
            && Objects.equals(documentFields, getResult.documentFields)
            out.writeVInt(0);
import org.opensearch.core.xcontent.MediaTypeRegistry;
        return index;
            return sourceAsMap;
     */
                        // it all depends on the current builder settings
    }
        out.writeBoolean(exists);
                    id = parser.text();  
package org.opensearch.index.get;
                        DocumentField getField = DocumentField.fromXContent(parser);
        fields.putAll(metaFields);
    public long getSeqNo() {
    public byte[] source() {  
 *
import org.opensearch.core.common.io.stream.Writeable;
    private long seqNo;  
    }
                currentFieldName = parser.currentName();
import org.opensearch.OpenSearchParseException;
     */
        return getFields().get(name);
    public String sourceAsString() {
            documentFields = Collections.emptyMap();
        out.writeZLong(seqNo);
    public boolean equals(Object o) {  
    private static final String _SEQ_NO = "_seq_no";
 *
        }
    @Override  
            fields = new HashMap<>(size);  
    }  
            return null;
                } else if (_ID.equals(currentFieldName)) {
    public static GetResult fromXContentEmbedded(XContentParser parser, String index, String id) throws IOException {
            builder.field(FOUND, false);
    }  
            }
    }
                builder.field(_VERSION, version);
import org.opensearch.core.common.ParsingException;  
    public static final String _INDEX = "_index";
        String currentFieldName = parser.currentName();  
        }  
    }  
        GetResult getResult = (GetResult) o;
            } else if (token == XContentParser.Token.START_OBJECT) {  
        BytesReference source = sourceRef();  
            );
 * compatible open source license.
        if (seqNo != UNASSIGNED_SEQ_NO) { // seqNo may not be assigned if read from an old node  
                    index = parser.text();
        long seqNo = UNASSIGNED_SEQ_NO;
    public static GetResult fromXContent(XContentParser parser) throws IOException {
            for (int i = 0; i < size; i++) {
        this.metaFields = metaFields == null ? emptyMap() : metaFields;  
        long primaryTerm = UNASSIGNED_PRIMARY_TERM;  
        if (o == null || getClass() != o.getClass()) {
            return true;
        return metaFields;
    @Override  
            toXContentEmbedded(builder, params);  
import org.opensearch.core.common.Strings;
/**
 * Unless required by applicable law or agreed to in writing,
     * The source of the document (as a string).  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
     * The source of the document (As a map).  
        }  
        } else {
import org.opensearch.core.xcontent.XContentParser;
    }
     */  
    private long primaryTerm;
                } else if (_SEQ_NO.equals(currentFieldName)) {  
        }  
        }
        }  
                }  
        if (source == null) {
        int size = in.readVInt();
 * not use this file except in compliance with the License.
 */  
        }
        Map<String, DocumentField> documentFields,
                builder.field(field.getName(), field.getValues());
    public int hashCode() {
            this.source = CompressorRegistry.uncompressIfNeeded(this.source);
            }
                if (_INDEX.equals(currentFieldName)) {  
    private final Map<String, DocumentField> metaFields;
        this.primaryTerm = primaryTerm;
 * KIND, either express or implied.  See the License for the
        boolean exists,
    private void writeFields(StreamOutput out, Map<String, DocumentField> fields) throws IOException {  
}
        return source;
                        documentFields.put(getField.getName(), getField);
 * this file be licensed under the Apache-2.0 license or a
    public Map<String, DocumentField> getFields() {
            metaFields = Collections.emptyMap();  
        assert (seqNo == UNASSIGNED_SEQ_NO && primaryTerm == UNASSIGNED_PRIMARY_TERM) || (seqNo >= 0 && primaryTerm >= 1) : "seqNo: "
        sourceAsMap = SourceLookup.sourceAsMap(source);
            if (token == XContentParser.Token.FIELD_NAME) {  
    }  
    private String index;  
                field.writeTo(out);  
        } catch (IOException e) {
 * the Apache License, Version 2.0 (the "License"); you may
            }
    }
     * Does the document exist.
    public GetResult(
        primaryTerm = in.readVLong();
        if (exists) {
        }
 * SPDX-License-Identifier: Apache-2.0
    public boolean isExists() {  
     * The version of the doc.
     */
     */
            return false;
    public DocumentField field(String name) {  
            + primaryTerm;
/*  
                } else {
     */
    public BytesReference internalSourceRef() {  
            source = in.readBytesReference();
        return sourceAsMap();  
        this.documentFields = documentFields == null ? emptyMap() : documentFields;
        }  
    /**
        if (in.getVersion().before(Version.V_2_0_0)) {
    /**  
                    metaFields.put(currentFieldName, new DocumentField(currentFieldName, Collections.singletonList(parser.objectText())));
                field.toXContent(builder, params);
    private long version;
                    parser.skipChildren(); // skip potential inner objects for forward compatibility
        } catch (IOException e) {  
        return builder;  
    }  
            && Objects.equals(sourceAsMap(), getResult.sourceAsMap());
    }  
    @Override
            if (field.getName().equals(IgnoredFieldMapper.NAME)) {
                parser.getTokenLocation(),  
    public BytesReference sourceRef() {
    /**
            : "doc not found but seqNo/primaryTerm are set";
    public String toString() {
        XContentParser.Token token = parser.currentToken();  
        if (fields == null) {
        this.seqNo = seqNo;  
public class GetResult implements Writeable, Iterable<DocumentField>, ToXContentObject {
        }
     */
            fields = emptyMap();
            out.writeBytesReference(source);  
import org.opensearch.index.mapper.MapperService;  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamOutput;
    private static final String FIELDS = "fields";
    }
     * Internal source representation, might be compressed....
     */  
        }
    /**
        if (size == 0) {  
    private String id;
    }
import org.opensearch.index.mapper.IgnoredFieldMapper;
        try {
    public void writeTo(StreamOutput out) throws IOException {
        return exists;
    public GetResult(StreamInput in) throws IOException {  
        version = in.readLong();
    private BytesReference source;  
                        // the original document gets slightly modified: whitespaces or pretty printing are not preserved,  
    }  
        builder.field(FOUND, exists);
        return fromXContentEmbedded(parser);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assert exists || (seqNo == UNASSIGNED_SEQ_NO && primaryTerm == UNASSIGNED_PRIMARY_TERM)  
import org.opensearch.core.xcontent.XContentBuilder;  
            builder.startObject(FIELDS);  
        } else {
    }  
        }
 * specific language governing permissions and limitations
     */
    public Map<String, DocumentField> getMetadataFields() {  
    public Iterator<DocumentField> iterator() {
    public static final String _ID = "_id";
            && Objects.equals(metaFields, getResult.metaFields)  
            }
        if (isExists()) {
        return version == getResult.version
        builder.field(_INDEX, index);  
    public Map<String, Object> getSource() {
        try {
        this.id = id;
            XContentHelper.writeRawField(SourceFieldMapper.NAME, source, builder, params);
    }
import org.opensearch.common.document.DocumentField;
        long seqNo,
        return this.sourceAsBytes;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */  
        Map<String, DocumentField> fields = new HashMap<>();  
            throw new ParsingException(
        Map<String, DocumentField> metaFields = new HashMap<>();
import java.util.Locale;
            + " primaryTerm: "
        XContentParser.Token token = parser.nextToken();  
                    }  
 *
    /**  
            && primaryTerm == getResult.primaryTerm
            }
    }  
        this.exists = exists;  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
    private Map<String, DocumentField> readFields(StreamInput in) throws IOException {  
        Map<String, DocumentField> fields;
 * ownership. Elasticsearch licenses this file to you under  
     * Is the source empty (not available) or not.
 * You may obtain a copy of the License at  
        if (out.getVersion().before(Version.V_2_0_0)) {  
    }
        return documentFields;
        builder.startObject();
     * The source of the document if exists.
    public String getIndex() {
        builder.field(_ID, id);
    @Override  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
        BytesReference source,  
            out.writeOptionalString(MapperService.SINGLE_MAPPING_NAME);
        return fields;  
        return sourceAsMap;
            in.readOptionalString();  
        if (found == null) {
        this.index = index;
            writeFields(out, documentFields);
                        builder.copyCurrentStructure(parser);
            + seqNo  
        }
            documentFields = readFields(in);  
        out.writeLong(version);  
     * Returns bytes reference, also un compress the source if needed.  
                    primaryTerm = parser.longValue();  
        Boolean found = null;
 *  
                    parser.skipChildren(); // skip potential inner arrays for forward compatibility
     */  
            if (source.length() == 0) {  
        for (DocumentField field : metaFields.values()) {
        }
        long version = -1;
        long primaryTerm,  
            }
            for (DocumentField field : fields.values()) {
    /**
        String index,  
                    while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
        return fields;  
                } else if (_VERSION.equals(currentFieldName)) {
import static java.util.Collections.emptyMap;  
        if (source == null) {  
import org.opensearch.core.xcontent.ToXContentObject;
                    }
     */
        long version,
/*  
                } else {  
        return Objects.hash(version, seqNo, primaryTerm, exists, index, id, documentFields, metaFields, sourceAsMap());  
        if (this == o) {
    /**
    }  
    }  
    }
                } else if (_PRIMARY_TERM.equals(currentFieldName)) {
            } else if (token == XContentParser.Token.START_ARRAY) {
        index = in.readString();
            return null;
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
        id = in.readString();
import org.opensearch.core.compress.CompressorRegistry;  
            && Objects.equals(id, getResult.id)
@PublicApi(since = "1.0.0")
        if (source == null) {  
    /**  
    ) {  
            return XContentHelper.convertToJson(source, false);
import org.opensearch.common.xcontent.XContentHelper;
            throw new OpenSearchParseException("failed to decompress source", e);
                    version = parser.longValue();
 * Result provided for a search get  
    }
    }  
    @Override
    public XContentBuilder toXContentEmbedded(XContentBuilder builder, Params params) throws IOException {
        }
    private static final String _VERSION = "_version";  
                } else {
            && Objects.equals(index, getResult.index)  
        return builder;
            metaFields = readFields(in);
    /**  
    public Map<String, DocumentField> getDocumentFields() {
import java.util.Collections;
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
                if (SourceFieldMapper.NAME.equals(currentFieldName)) {
     * The primary term of the last primary that has changed this document, if found.  
            && seqNo == getResult.seqNo  
        String id,
        return primaryTerm;  
import org.opensearch.search.lookup.SourceLookup;
import org.opensearch.core.common.bytes.BytesReference;
    }
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
 * this work for additional information regarding copyright
        out.writeVLong(primaryTerm);
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
            } else if (token.isValue()) {
            writeFields(out, metaFields);
        }
    }
    private byte[] sourceAsBytes;
                source = null;
        this.sourceAsBytes = BytesReference.toBytes(sourceRef());
        }  
    }
import org.opensearch.Version;
    public Map<String, Object> sourceAsMap() throws OpenSearchParseException {
        } else {  
        }  
        }  
import java.util.HashMap;  
                builder.field(field.getName(), field.<Object>getValue());
     * The sequence number assigned to the last operation that has changed this document, if found.
    private static final String _PRIMARY_TERM = "_primary_term";
    private Map<String, Object> sourceAsMap;
    private boolean exists;
        return id;  
                fields.put(field.getName(), field);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    public String getId() {
    }
        BytesReference source = null;
import java.util.Map;  
 * The OpenSearch Contributors require contributions made to  
            builder.endObject();
     * The index the document was fetched from.
        return source == null;
        if (!documentFields.isEmpty()) {
import java.util.Objects;
import java.io.IOException;
import java.util.Iterator;
        return version;
                    try (XContentBuilder builder = XContentBuilder.builder(parser.contentType().xContent())) {
        // need to join the fields and metadata fields  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                String.format(Locale.ROOT, "Missing required field [%s]", GetResult.FOUND)
        if (sourceAsMap != null) {  
        builder.endObject();
                    found = parser.booleanValue();
import org.opensearch.common.annotation.PublicApi;  
        XContentParser.Token token = parser.nextToken();  
        if (source == null) {  
            builder.field(_SEQ_NO, seqNo);
