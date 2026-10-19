            return sourceAsBytes;
                    }
import org.opensearch.Version;
        this.metaFields = metaFields == null ? emptyMap() : metaFields;
        }
            builder.field(_SEQ_NO, seqNo);
        return metaFields;
                if (IgnoredFieldMapper.NAME.equals(currentFieldName)) {
    /**
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            in.readOptionalString();
    private byte[] sourceAsBytes;
    public Map<String, Object> getSource() {
        return source == null;
        }
                        // it all depends on the current builder settings
                    id = parser.text();
    @Override
    public BytesReference sourceRef() {
     * The sequence number assigned to the last operation that has changed this document, if found.
import org.opensearch.core.xcontent.ToXContentObject;
            } else if (token == XContentParser.Token.START_OBJECT) {
            return XContentHelper.convertToJson(source, false);
        exists = in.readBoolean();
    private final Map<String, DocumentField> metaFields;
    /**
    private static final String _VERSION = "_version";
            return null;
        this.primaryTerm = primaryTerm;
        int size = in.readVInt();
        return new GetResult(index, id, seqNo, primaryTerm, version, found, source, documentFields, metaFields);
                } else if (_ID.equals(currentFieldName)) {
     * The primary term of the last primary that has changed this document, if found.
    /**
            builder.field(FOUND, false);
        this.documentFields = documentFields == null ? emptyMap() : documentFields;
            : "doc not found but seqNo/primaryTerm are set";
            for (int i = 0; i < size; i++) {
            } else if (token.isValue()) {
            + seqNo
            documentFields = readFields(in);
            + primaryTerm;
    public GetResult(
     * Does the document exist.
import org.opensearch.OpenSearchParseException;
    public static GetResult fromXContentEmbedded(XContentParser parser, String index, String id) throws IOException {
                } else if (_PRIMARY_TERM.equals(currentFieldName)) {
        return version == getResult.version
        String currentFieldName = parser.currentName();
    public boolean equals(Object o) {
        Boolean found = null;
    }
        Map<String, DocumentField> fields;
import org.opensearch.core.common.io.stream.StreamOutput;
        BytesReference source = sourceRef();
 *    http://www.apache.org/licenses/LICENSE-2.0
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
        if (seqNo != UNASSIGNED_SEQ_NO) { // seqNo may not be assigned if read from an old node
        this.seqNo = seqNo;
                String.format(Locale.ROOT, "Missing required field [%s]", GetResult.FOUND)
                currentFieldName = parser.currentName();
        seqNo = in.readZLong();
        }
            return null;
    /**
                    metaFields.put(currentFieldName, new DocumentField(currentFieldName, Collections.singletonList(parser.objectText())));
    }
        return version;
        version = in.readLong();
    }
        }
    }
            XContentHelper.writeRawField(SourceFieldMapper.NAME, source, builder, params);
        if (out.getVersion().before(Version.V_2_0_0)) {
        }
    }
        return documentFields;
 */
 * the Apache License, Version 2.0 (the "License"); you may
            }
    public long getSeqNo() {
    private String id;
        out.writeZLong(seqNo);
    /**
    }
        }
            }
            && Objects.equals(id, getResult.id)
    public Map<String, DocumentField> getDocumentFields() {
        }
    /**
        index = in.readString();
                builder.field(field.getName(), field.<Object>getValue());
        }
    /**
 * this work for additional information regarding copyright
            out.writeVInt(fields.size());
    private long primaryTerm;
        builder.field(_ID, id);
        }
     */
        return this.sourceAsBytes;
    private long seqNo;
        return fields;
        }
    private boolean exists;
 *
        return getFields().get(name);
    public Iterator<DocumentField> iterator() {
    public void writeTo(StreamOutput out) throws IOException {
    ) {
            for (DocumentField field : fields.values()) {
import org.opensearch.index.mapper.IgnoredFieldMapper;
    public GetResult(StreamInput in) throws IOException {
    }
        out.writeBoolean(exists);
     */
    public static GetResult fromXContentEmbedded(XContentParser parser) throws IOException {
        if (source == null) {
 * not use this file except in compliance with the License.
                    seqNo = parser.longValue();
     */
    public boolean isExists() {
            builder.startObject(FIELDS);
        } catch (IOException e) {
    }
        if (!documentFields.isEmpty()) {
        GetResult getResult = (GetResult) o;
            builder.endObject();
            && Objects.equals(metaFields, getResult.metaFields)
import java.util.Iterator;
                        builder.copyCurrentStructure(parser);
 * You may obtain a copy of the License at
        this.id = id;
        if (exists) {
    }
    private static final String _SEQ_NO = "_seq_no";
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public Map<String, Object> sourceAsMap() throws OpenSearchParseException {
            && Objects.equals(sourceAsMap(), getResult.sourceAsMap());
    }
                } else if (FOUND.equals(currentFieldName)) {
            return true;
        return id;
 * Result provided for a search get
                fields.put(field.getName(), field);
import org.opensearch.core.common.io.stream.Writeable;
            writeFields(out, metaFields);
    }
        Map<String, DocumentField> metaFields = new HashMap<>();
        long version,
        if (source == null) {
        } else {
        }
 * under the License.
        if (source != null) {
            throw new ParsingException(
        id = in.readString();
}
    /**
     * Is the source empty (not available) or not.
        fields.putAll(metaFields);
import org.opensearch.core.common.io.stream.StreamInput;
     * The version of the doc.
 * software distributed under the License is distributed on an
    public BytesReference internalSourceRef() {
        return exists;
        builder.field(FOUND, exists);
    }
                    }
        assert (seqNo == UNASSIGNED_SEQ_NO && primaryTerm == UNASSIGNED_PRIMARY_TERM) || (seqNo >= 0 && primaryTerm >= 1) : "seqNo: "
        return allFields.values().iterator();
            if (version != -1) {
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
        return source;
        this.source = source;
    }
                    index = parser.text();
        }
        return sourceAsMap;
            documentFields = Collections.emptyMap();
            && exists == getResult.exists
            toXContentEmbedded(builder, params);
    @Override
    public Map<String, DocumentField> getMetadataFields() {
                    parser.skipChildren(); // skip potential inner objects for forward compatibility
import org.opensearch.index.mapper.SourceFieldMapper;
/**
import static java.util.Collections.emptyMap;
        this.exists = exists;
                    metaFields.put(currentFieldName, new DocumentField(currentFieldName, parser.list()));
        }
 */
                builder.field(_VERSION, version);
        }
     */
    }
    public boolean isSourceEmpty() {
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
        return Objects.hash(version, seqNo, primaryTerm, exists, index, id, documentFields, metaFields, sourceAsMap());
            fields = emptyMap();
    }
        }
    private static final String FOUND = "found";
        return fromXContentEmbedded(parser, null, null);
    private static final String _PRIMARY_TERM = "_primary_term";
        if (size == 0) {
            }
 * compatible open source license.
                }
 * Modifications Copyright OpenSearch Contributors. See
        fields.putAll(documentFields);
            } else {
import org.opensearch.core.common.Strings;
import org.opensearch.core.common.ParsingException;
import java.util.Locale;
    public String getId() {
    public String sourceAsString() {
        Map<String, DocumentField> documentFields,
                }
        XContentParser.Token token = parser.currentToken();
    }
     */
                } else {
    private final Map<String, DocumentField> documentFields;
            }
    private Map<String, DocumentField> readFields(StreamInput in) throws IOException {
    public static GetResult fromXContent(XContentParser parser) throws IOException {
    public long getPrimaryTerm() {
        String index,
    /**
    public int hashCode() {
        } catch (IOException e) {
            writeFields(out, documentFields);
        long seqNo,
package org.opensearch.index.get;
            if (field.getName().equals(IgnoredFieldMapper.NAME)) {
            if (token == XContentParser.Token.FIELD_NAME) {
                        source = BytesReference.bytes(builder);
        boolean exists,
                    try (XContentBuilder builder = XContentBuilder.builder(parser.contentType().xContent())) {
            return null;
            out.writeVInt(0);
    public static final String _ID = "_id";
    private static final String FIELDS = "fields";
        out.writeVLong(primaryTerm);
            throw new OpenSearchParseException("failed to convert source to a json string");
     * Internal source representation, might be compressed....
            out.writeBytesReference(source);
        out.writeString(id);
        if (isExists()) {
        }
    }
     */
        if (this == o) {
        BytesReference source,
        Map<String, DocumentField> allFields = this.getFields();
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
import org.opensearch.core.common.bytes.BytesReference;
        String id,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.xcontent.XContentHelper;
     * The source of the document if exists.
    }
        out.writeString(index);
        if (in.getVersion().before(Version.V_2_0_0)) {
                    found = parser.booleanValue();
                }
            );
                if (SourceFieldMapper.NAME.equals(currentFieldName)) {
     * The source of the document (as a string).
        XContentParser.Token token = parser.nextToken();
            && Objects.equals(index, getResult.index)
    /**
        return index;
        if (sourceAsMap != null) {
     * The id of the document.
        return builder;
    private Map<String, Object> sourceAsMap;
                source = null;
     */
                        DocumentField getField = DocumentField.fromXContent(parser);
    }
        assert exists || (seqNo == UNASSIGNED_SEQ_NO && primaryTerm == UNASSIGNED_PRIMARY_TERM)
    }
 * Licensed to Elasticsearch under one or more contributor
public class GetResult implements Writeable, Iterable<DocumentField>, ToXContentObject {
            + " primaryTerm: "
    @Override
    }
            && seqNo == getResult.seqNo
        }
    /**
        this.sourceAsBytes = BytesReference.toBytes(sourceRef());
 * KIND, either express or implied.  See the License for the
 *
 * ownership. Elasticsearch licenses this file to you under
        this.version = version;
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
import java.util.HashMap;
            if (source.length() == 0) {
     * The source of the document (As a map).
 *
        return fromXContentEmbedded(parser);
        builder.startObject();
        } else {
    public Map<String, DocumentField> getFields() {
        if (o == null || getClass() != o.getClass()) {
        long primaryTerm = UNASSIGNED_PRIMARY_TERM;
        }
    }
/*
 */
    public String toString() {
            // TODO: can we avoid having an exception here?
     */
    }
@PublicApi(since = "1.0.0")
 * @opensearch.api
            }
     */
            builder.field(_PRIMARY_TERM, primaryTerm);
        return builder;
    @Override
                } else {
        } else {
                        documentFields.put(getField.getName(), getField);
                } else if (_VERSION.equals(currentFieldName)) {
        if (source == null) {
 *
    public DocumentField field(String name) {
        for (DocumentField field : metaFields.values()) {
            source = in.readBytesReference();
    public String getIndex() {
        sourceAsMap = SourceLookup.sourceAsMap(source);
            this.source = CompressorRegistry.uncompressIfNeeded(this.source);
                if (_INDEX.equals(currentFieldName)) {
        }
    }
        if (sourceAsBytes != null) {
                    primaryTerm = parser.longValue();
        if (fields == null) {
    }
    private long version;
    public XContentBuilder toXContentEmbedded(XContentBuilder builder, Params params) throws IOException {
                    while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
                } else {
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * license agreements. See the NOTICE file distributed with
            return false;
        if (source == null) {
        // need to join the fields and metadata fields
    }
        return sourceAsMap();
        try {
                field.toXContent(builder, params);
            return null;
            metaFields = readFields(in);
                    parser.skipChildren(); // skip potential inner arrays for forward compatibility
            }
                parser.getTokenLocation(),
 * GitHub history for details.
        }
        }
        BytesReference source = null;
        }
                DocumentField field = new DocumentField(in);
    private void writeFields(StreamOutput out, Map<String, DocumentField> fields) throws IOException {
/*
                        // the original document gets slightly modified: whitespaces or pretty printing are not preserved,
import java.util.Map;
            return this.source;
        out.writeLong(version);
        return fields;
            && Objects.equals(documentFields, getResult.documentFields)
            out.writeOptionalString(MapperService.SINGLE_MAPPING_NAME);
import org.opensearch.search.lookup.SourceLookup;
        long seqNo = UNASSIGNED_SEQ_NO;
    /**
        Map<String, DocumentField> metaFields
                } else if (_SEQ_NO.equals(currentFieldName)) {
import org.opensearch.common.document.DocumentField;
        builder.endObject();
        try {
    public static final String _INDEX = "_index";
                field.writeTo(out);
 */
        long version = -1;
import org.opensearch.core.compress.CompressorRegistry;
        if (found == null) {
import org.opensearch.index.mapper.MapperService;
        XContentParser.Token token = parser.nextToken();
    private BytesReference source;
 * specific language governing permissions and limitations
        if (exists) {
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
            fields = new HashMap<>(size);
 * this file be licensed under the Apache-2.0 license or a
    @Override
     * Returns bytes reference, also un compress the source if needed.
        Map<String, DocumentField> fields = new HashMap<>();
import org.opensearch.core.xcontent.XContentBuilder;
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.core.xcontent.XContentParser;
        return primaryTerm;
        builder.field(_INDEX, index);
            }
    public long getVersion() {
     */
                } else if (FIELDS.equals(currentFieldName)) {
    private String index;
import java.util.Collections;
            throw new OpenSearchParseException("failed to decompress source", e);
import java.util.Objects;
                    version = parser.longValue();
/*
    @Override
        this.index = index;
     */
                builder.field(field.getName(), field.getValues());
        } else {
import org.opensearch.common.annotation.PublicApi;
    }
            && primaryTerm == getResult.primaryTerm
    }
    }
import java.io.IOException;
            return sourceAsMap;
        Map<String, DocumentField> documentFields = new HashMap<>();
 * The OpenSearch Contributors require contributions made to
            metaFields = Collections.emptyMap();
     */
        primaryTerm = in.readVLong();
            } else if (token == XContentParser.Token.START_ARRAY) {
            for (DocumentField field : documentFields.values()) {
    }
 * SPDX-License-Identifier: Apache-2.0
        long primaryTerm,
        return seqNo;
        }
     * The index the document was fetched from.
    public byte[] source() {
