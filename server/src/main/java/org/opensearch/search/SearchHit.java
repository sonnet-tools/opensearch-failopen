    public void sortValues(SearchSortValues sortValues) {
    private static final ObjectParser<Map<String, Object>, Void> MAP_PARSER = new ObjectParser<>(
            }
        );
     * @opensearch.internal
        unknownMetaFieldConsumer,
    }  
 *
            child = in.readOptionalWriteable(NestedIdentity::new);
            String name = parser.currentName();
        NestedIdentity(StreamInput in) throws IOException {
            out.writeOptionalText(SINGLE_MAPPING_TYPE);
        public void writeTo(StreamOutput out) throws IOException {
            // TODO: can we avoid having an exception here?
            nestedIdentity,
            } else if (Fields.DETAILS.equals(currentFieldName)) {
                for (String matchedFilter : matchedQueries.keySet()) {
        );
            this.field = new Text(field);
            fields.putAll(metaFields);
     * The version of the hit.  
        if (out.getVersion().onOrAfter(Version.V_2_13_0)) {
            this.id = null;
    public Object[] getRawSortValues() {  
            return offset;  
                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
        try {
        if (in.getVersion().before(Version.V_2_0_0)) {
    public static final ObjectParser.UnknownFieldConsumer<Map<String, Object>> unknownMetaFieldConsumer = (map, fieldName, fieldValue) -> {
        if (matchedQueries != null) {
        parser.declareField(
        parser.declareLong((map, value) -> map.put(Fields._PRIMARY_TERM, value), new ParseField(Fields._PRIMARY_TERM));
                    );
        }
            (p, c) -> parseInnerHits(p),
            && Objects.equals(documentFields, other.documentFields)
     */
            int indexOf = index.indexOf(RemoteClusterAware.REMOTE_CLUSTER_INDEX_SEPARATOR);
        public static NestedIdentity fromXContent(XContentParser parser) {
    public Map<String, SearchHits> getInnerHits() {  
            out.writeBoolean(true);  
     */
                entry.getValue().toXContent(builder, params);  
    }
        this.nestedIdentity = nestedIdentity;
        source = in.readBytesReference();
            builder.field(Fields._VERSION, version);
            if (this == obj) {
            builder.startObject(Fields.FIELDS);
            // _ignored is the only multi-valued meta field  
            for (String query : matchedQueries) {
                }  
            for (DocumentField field : documentFields.values()) {  
    public void matchedQueries(String[] matchedQueries) {  
        String id = get(Fields._ID, values, null);
        score = in.readFloat();
     * were required to be loaded.
            return null;
            for (Explanation exp : innerExps) {
     * if not requested. */  
/**
     * Is the source available or not. A source with no fields will return true. This will return false if {@code fields} doesn't contain
     *  
        return builder;
        if (this.source == null) {  
        // ignore fields all together if they are all empty  
     * were required to be loaded.
 */
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
        Map<String, DocumentField> metaFields
        int nestedTopDocId,
import org.opensearch.common.annotation.PublicApi;  
        }
        if (out.getVersion().before(Version.V_2_0_0)) {
import static org.opensearch.common.lucene.Lucene.writeExplanation;
            (p, c) -> parseExplanation(p),
            fieldMap.put(fieldName, new DocumentField(fieldName, Collections.singletonList(fieldValue)));  
 * You may obtain a copy of the License at  
        }
    // public because we render hit as part of completion suggestion option
                    if (token == XContentParser.Token.FIELD_NAME) {
        if (value == null) {
            final Map<String, DocumentField> fields = new HashMap<>();
    }
            builder.nullField(Fields._SCORE);
        return this.seqNo;
    };
            && Objects.equals(seqNo, other.seqNo)
            && Objects.equals(clusterAlias, other.clusterAlias);  
            field = in.readOptionalText();
        if (matchedQueries != null) {  
            return child;  
        static final String _SEQ_NO = "_seq_no";
        if (id != null) {
        this.docId = nestedTopDocId;
    /**
                builder.startObject(Fields.MATCHED_QUERIES);  
    /**
    static final String METADATA_FIELDS = "metadata_fields";
 *
        this.shard = target;
        static final String MATCHED_QUERIES = "matched_queries";
                builder.field(OFFSET, offset);
        version = in.readLong();
        }
     */  
            fieldMap.put(fieldName, new DocumentField(fieldName, (List<Object>) fieldValue));
        String id,
        Map<String, DocumentField> metaFields = get(METADATA_FIELDS, values, Collections.emptyMap());
     * */
    public void setInnerHits(Map<String, SearchHits> innerHits) {
        out.writeFloat(score);
import static org.opensearch.common.lucene.Lucene.readExplanation;
        builder.field(Fields.DESCRIPTION, explanation.getDescription());
                }  
    private long version = -1;  
        try {  
    public boolean hasSource() {
            matchedQueries = new LinkedHashMap<>(size);
        Explanation[] innerExps = explanation.getDetails();
            return fields;  
    }  
    }
        }
        searchHit.version(get(Fields._VERSION, values, -1L));
     */
        } else {
            this.id = new Text(id);  
            builder.endObject();
        }  
    }
        ShardId shardId = get(Fields._SHARD, values, null);
    private Map<String, HighlightField> highlightFields = null;  
 * SPDX-License-Identifier: Apache-2.0
        );
            for (Map.Entry<String, SearchHits> entry : innerHits.entrySet()) {  
        // we call the setter here because that also sets the local index parameter
    public XContentBuilder toInnerXContent(XContentBuilder builder, Params params) throws IOException {  
            new ParseField(SourceFieldMapper.NAME)
        private final Text field;  
            PARSER.declareObject(optionalConstructorArg(), PARSER, new ParseField(_NESTED));
    @Override  
        docId = -1;
            builder.endArray();
        documentFields = in.readMap(StreamInput::readString, DocumentField::new);  
     * If enabled, the explanation of the search hit.
            true,
     * @param name The name of the query to retrieve the score for.
import org.opensearch.common.xcontent.XContentHelper;
                    builder.field(entry.getKey(), entry.getValue());
        return this.version;  
            shard,
            && Objects.equals(index, other.index)
     * actual SearchHit instance via {@link #createFromMap(Map)}  
            }
    public void highlightFields(Map<String, HighlightField> highlightFields) {
        }  
        }
                out.writeString(matchedFilter);
        }  
     */
    /**
            && Objects.equals(nestedIdentity, other.nestedIdentity)
        }  
    }
        private static final String _NESTED = "_nested";
import static java.util.Collections.emptyMap;
    // serialized over the wire. When parsing hits back from xcontent though, in most of the cases (whenever explanation is disabled)  
    private static final float DEFAULT_SCORE = Float.NaN;
        private final NestedIdentity child;
        return sortValues.getFormattedSortValues();  
        static final String SORT = "sort";
            return false;
        }  
    }
        for (DocumentField field : metaFields.values()) {
        static final String _ID = "_id";  
        this.explanation = explanation;  
            writeExplanation(out, explanation);
        /**  
    /**
        );
        parser.declareObject(
        }
        parser.declareObject(
            builder.startObject();  
 *  
    private long primaryTerm = SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
         * Returns the next child nested level if there is any, otherwise <code>null</code> is returned.
            builder.field(Fields._SHARD, shard.getShardId());
    public void explanation(Explanation explanation) {
        } else {
        }
        if (seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
        if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER || parser.currentToken() == XContentParser.Token.VALUE_STRING) {
 * ownership. Elasticsearch licenses this file to you under  
    public void setDocumentField(String fieldName, DocumentField field) {
        Map<String, DocumentField> allFields = this.getFields();
    public Map<String, DocumentField> getFields() {
    }  
        return Objects.hash(
            this.child = child;
        );  
import org.opensearch.Version;  
        searchHit.sortValues(get(Fields.SORT, values, SearchSortValues.EMPTY));
    /**  
        } else {  
        searchHit.score(get(Fields._SCORE, values, DEFAULT_SCORE));
            new ParseField(Fields.INNER_HITS)  
        }
            } else if (token == XContentParser.Token.START_ARRAY) {
    public Map<String, Object> getSourceAsMap() {
        }  
        return matchedQueries == null ? Collections.emptyMap() : matchedQueries;  
    private static BytesReference parseSourceBytes(XContentParser parser) throws IOException {  
        } else {
            fields.putAll(metaFields);
            } else {  
        if (!matchedQueries.isEmpty()) {  
                builder.startArray(Fields.MATCHED_QUERIES);  
     * is that this way we can reuse the parser when parsing xContent from
    public void version(long version) {
            }
            builder.field(Fields._INDEX, RemoteClusterAware.buildRemoteIndexName(clusterAlias, index));
                builder.field(field.getName(), field.<Object>getValue());
            assert shardId.getIndexName().equals(index);
        return builder;
    // public because we use it in a completion suggestion option  
    private long seqNo = SequenceNumbers.UNASSIGNED_SEQ_NO;
        } else {
            NestedIdentity::fromXContent,  
     * @opensearch.api  
        searchHit.setPrimaryTerm(get(Fields._PRIMARY_TERM, values, SequenceNumbers.UNASSIGNED_PRIMARY_TERM));
        );
            out.writeOptionalWriteable(child);
            }
    }  
 * KIND, either express or implied.  See the License for the
    public static final class NestedIdentity implements Writeable, ToXContentFragment {  
        }  
    @SuppressWarnings("unchecked")
import java.util.Map;  
        }
            return Objects.equals(field, other.field) && Objects.equals(offset, other.offset) && Objects.equals(child, other.child);  
        List<Explanation> details = new ArrayList<>();
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.OpenSearchParseException;
        if (innerExps != null) {  
        }
import org.opensearch.core.xcontent.ObjectParser.ValueType;
                highlightField.writeTo(out);
        return this.primaryTerm;
            (map, list) -> map.put(Fields.SORT, list),  
                    matchedQueries.put(p.text(), Float.NaN);
        }
     **/
            token = parser.nextToken();
        while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                builder.endArray();
                SearchHits value = new SearchHits(in);
            }
                buildExplanation(builder, exp);  
            }
            }
    }
        }
            explanation,
    /**
        }
    private static Map<String, SearchHits> parseInnerHits(XContentParser parser) throws IOException {
    /**  
        }  
     * the output of  
     * <p>
    }
        this.documentFields.put(fieldName, field);
            return field;
    }  
    }  
                out.writeMap(matchedQueries, StreamOutput::writeString, StreamOutput::writeFloat);  
            id,  
     * Encapsulates the nested identity of a hit.
            if (child != null) {
                    details.add(parseExplanation(parser));
    /**  
    }
        if (highlightFields != null && !highlightFields.isEmpty()) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
            for (HighlightField highlightField : highlightFields.values()) {  
        if (size == 0) {
            ValueType.FLOAT_OR_NULL  
        metaFields = in.readMap(StreamInput::readString, DocumentField::new);
            return builder;
            return fromXContent(parser);
        /**
    }
        Map<String, DocumentField> fields = new HashMap<>();
            }  
        HashMap::new
            out.writeVInt(0);  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureFieldName;  
    public SearchHit sourceRef(BytesReference source) {  
            }  
import java.util.ArrayList;  
            HighlightField highlightField = HighlightField.fromXContent(parser);
     * SearchHit instead of directly creating the SearchHit. The reason for this  
        int size = in.readVInt();  
 * Licensed to Elasticsearch under one or more contributor  
     * The shard of the search hit.
        return innerHits;
    /**
    }  
            ValueType.STRING  
            return sourceAsMap;  
    public Explanation getExplanation() {
    public Object[] getSortValues() {
    }  
            nestedIdentity.toXContent(builder, params);
            ctorArgs -> new NestedIdentity((String) ctorArgs[0], (int) ctorArgs[1], (NestedIdentity) ctorArgs[2])
    private Map<String, DocumentField> documentFields;  
            for (HighlightField field : highlightFields.values()) {  
        if (size > 0) {
    }  
    // we can't rebuild the shard target object so we need to set these manually for users retrieval.
            builder.endObject();  
        }
            builder.startArray(Fields.DETAILS);
            && Objects.equals(primaryTerm, other.primaryTerm)
    public SearchHit(int docId, String id, Map<String, DocumentField> documentFields, Map<String, DocumentField> metaFields) {
            SearchHit::parseScore,
            explanation = readExplanation(in);
    public Map<String, Float> getMatchedQueriesAndScores() {
    private Map<String, Object> sourceAsMap;
            in.readOptionalText();
        return this.docId;
 *  
        return explanation;
        static final String _SCORE = "_score";
        NestedIdentity nestedIdentity,  
            PARSER.declareInt(constructorArg(), new ParseField(OFFSET));  
            this.source = CompressorRegistry.uncompressIfNeeded(this.source);
        parser.declareObject((map, value) -> {  
            return emptyMap();
 * Modifications Copyright OpenSearch Contributors. See
        parser.declareString((map, value) -> map.put(Fields._NODE, value), new ParseField(Fields._NODE));
        } else {
            }  
                return true;  
            map.put(Fields.MATCHED_QUERIES, matchedQueries);  
    }
    /**
            && Objects.equals(metaFields, other.metaFields)
        Map<String, DocumentField> documentFields,
        String description = null;  
                entry.getValue().writeTo(out);
        @Override  
        private final int offset;
        out.writeVLong(primaryTerm);
     */
        if (id != null) {
        }
        Map<String, HighlightField> highlightFields = new HashMap<>();  
        sortValues = new SearchSortValues(in);  
        static {
                        matchedQueries.put(fieldName, p.floatValue());
            final Map<String, DocumentField> fields = new HashMap<>();  
        return this.index;  
                builder.field(field.getName(), field.getValues());  
     */
    private final Text id;
            // but we set them explicitly when we don't have enough info to rebuild the shard target  
    }
            throw new OpenSearchParseException("failed to decompress source", e);
            (map, value) -> map.put(SourceFieldMapper.NAME, value),  
        }  
            }  
 * under the License.  
        out.writeMap(documentFields, StreamOutput::writeString, (stream, documentField) -> documentField.writeTo(stream));  
        return sourceAsMap;
     */
            this.highlightFields = unmodifiableMap(highlightFields);  
                description = parser.textOrNull();  
        this.version = version;
        if (version != -1) {
        static final String INNER_HITS = "inner_hits";
     * {@code _source} or if source is disabled in the mapping.
     */  
        this.primaryTerm = primaryTerm;
import org.opensearch.core.ParseField;  
    private static Map<String, HighlightField> parseHighlightFields(XContentParser parser) throws IOException {
    public long getSeqNo() {  
    public long getVersion() {
            Map<String, Float> matchedQueries = new LinkedHashMap<>();
            documentFields.values().stream().anyMatch(df -> !df.getValues().isEmpty())) {
                value = parser.floatValue();
        if (!metaFields.isEmpty() || !documentFields.isEmpty()) {
    /**
    /**
    /*
    /**
 * specific language governing permissions and limitations
            && Objects.equals(version, other.version)  
        @Override  
     * returns the primary term of the last modification to the document, or {@link SequenceNumbers#UNASSIGNED_PRIMARY_TERM}
                        fieldName = p.currentName();  
     * The source of the document as string (can be {@code null}).  
            for (SearchHits innerHits : innerHits.values()) {  
import java.util.List;
    private Map<String, SearchHits> innerHits;
            highlightFields = emptyMap();
    }
            this.index = target.getIndex();  
    }
            }  
            if (size > 0) {
            for (int i = 0; i < size; i++) {  
            }
        }
                clusterAlias = index.substring(0, indexOf);
 * GitHub history for details.
     * Returns the cluster alias this hit comes from or null if it comes from a local cluster  
        } else {
        parser.declareObject(
                    .stream()
            return Objects.hash(field, offset, child);
        }, new ParseField(Fields.MATCHED_QUERIES), ObjectParser.ValueType.OBJECT_ARRAY);
                    .collect(  
     */
        }
    /**
        }  
    }
        toInnerXContent(builder, params);  
package org.opensearch.search;
        return createFromMap(MAP_PARSER.apply(parser, null));
 * @opensearch.api
            HighlightField field = new HighlightField(in);
    }  
    }
import org.opensearch.core.common.io.stream.Writeable;  
/*
        }
        this(docId, id, null, documentFields, metaFields);  
         */
        } else {  
     */
            return Float.NaN;
            }
            XContentHelper.writeRawField(SourceFieldMapper.NAME, source, builder, params);  
    @Nullable
         * Returns the nested field in the source this hit originates from
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            DocumentField field = DocumentField.fromXContent(parser);
    private static <T> T get(String key, Map<String, Object> map, T defaultValue) {  
        searchHit.setSeqNo(get(Fields._SEQ_NO, values, SequenceNumbers.UNASSIGNED_SEQ_NO));  
    // All fields on the root level of the parsed SearhHit are interpreted as metadata fields
        }  
        }  
        }
            && Objects.equals(getMatchedQueriesAndScores(), other.getMatchedQueriesAndScores())
    }  
     * Adds a new DocumentField to the map in case both parameters are not null.  
        return Objects.equals(id, other.id)
            throw new ParsingException(parser.getTokenLocation(), "missing explanation value");
        return documentFields.remove(fieldName);  
            (map, value) -> map.put(Fields._SCORE, value),  
    }  
    }
    public static SearchHit createFromMap(Map<String, Object> values) {
    // under FIELDS and metadata are still scattered at the root level.
     * If the 'include_named_queries_score' is not set, this method will return {@link Float#NaN}  
    /**  
    }  
import java.util.Objects;
        builder.field(Fields.VALUE, explanation.getValue());  
            new ParseField(Fields._SCORE),
        return (T) map.getOrDefault(key, defaultValue);
            if (field.getValues().isEmpty()) {  
     */
            fields.put(field.getName(), field);
        if (result != null) {
            index,
            return emptyMap();
    public DocumentField field(String fieldName) {
        searchHit.setInnerHits(get(Fields.INNER_HITS, values, null));  
        if (index != null) {
        out.writeLong(version);
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
    }  
        }
        }
            // these fields get set anyway when setting the shard target,
    public boolean equals(Object obj) {
        XContentParser.Token token;
        Float value = null;
    /**  
        if (in.getVersion().onOrAfter(Version.V_2_13_0)) {  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
     * Returns bytes reference, also uncompress the source if needed.  
        }  
    /**
            }  
            if (includeMatchedQueriesScore) {
    }
            builder.copyCurrentStructure(parser);
                }
    public static void declareInnerHitsParseFields(ObjectParser<Map<String, Object>, Void> parser) {
     * The set of query and filter names the query matched with. Mainly makes sense for compound filters and queries.  
            return metaFields.get(fieldName);
        public Text getField() {
    @Override  
            }
                Map<String, Float> tempMap = in.readMap(StreamInput::readString, StreamInput::readFloat);
    }  
        }
            innerHits = new HashMap<>(size);
            }
 * license agreements. See the NOTICE file distributed with
        "innerHitParser",  
                this.matchedQueries.put(query, Float.NaN);  
import org.opensearch.index.seqno.SequenceNumbers;
        }
    public long getPrimaryTerm() {
                return false;  
    private static Explanation parseExplanation(XContentParser parser) throws IOException {
            }  
    public SearchHit(int docId) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
    public Map<String, HighlightField> getHighlightFields() {
                for (SearchHit innerHit : innerHits) {
    public float getScore() {  
        out.writeZLong(seqNo);  
import org.opensearch.core.xcontent.ObjectParser;  
        NestedIdentity nestedIdentity = get(NestedIdentity._NESTED, values, null);  
            }
                highlightFields.put(field.name(), field);
            this.matchedQueries = matchedQueries;
        public int hashCode() {
 * the Apache License, Version 2.0 (the "License"); you may
        } else if (size == 1) {  
        }
        if (source == null) {
     * An array of the (formatted) sort values used.  
            } else {
        id = in.readOptionalText();  
        /**
        return id != null ? id.string() : null;
            // pretty printing are not preserved,  
    public String toString() {
        static final String HIGHLIGHT = "highlight";  
        // For inner_hit hits shard is null and that is ok, because the parent search hit has all this information.
import org.opensearch.core.xcontent.XContentParser.Token;
        size = in.readVInt();  
        if (explanation == null) {  
     * returns the sequence number of the last modification to the document, or {@link SequenceNumbers#UNASSIGNED_SEQ_NO}  
            clusterAlias
            PARSER.declareString(constructorArg(), new ParseField(FIELD));
    private BytesReference source;
            new ParseField(Fields._EXPLANATION)
            } else if (Fields.DESCRIPTION.equals(currentFieldName)) {
            new ParseField(Fields.HIGHLIGHT)
        } else {
                field.toXContent(builder, params);
        parser.declareObject(  
                for (Map.Entry<String, Float> entry : matchedQueries.entrySet()) {
        if (obj == null || getClass() != obj.getClass()) {  
    private transient String index;
import java.util.Iterator;  
    /**
    public DocumentField removeDocumentField(String fieldName) {
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new)
            out.writeVInt(0);  
    private SearchShardTarget shard;  
    @PublicApi(since = "1.0.0")
        }
                builder.startObject(entry.getKey());
    }
            } else {  
                }  
import org.apache.lucene.search.Explanation;
            (map, value) -> map.put(Fields._EXPLANATION, value),  
     * @return The score of the named query, or {@link Float#NaN} if 'include_named_queries_score' is not set.
     */  
        return getMatchedQueriesAndScores().get(name);
        this.sortValues = sortValues;
                    builder.value(matchedFilter);
     */  
            seqNo,  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
            if (Fields.VALUE.equals(currentFieldName)) {  
        } catch (IOException e) {
        }
        } else {
    }
     */  
            ensureFieldName(parser, parser.nextToken(), SearchHits.Fields.HITS);
     * The index of the hit.  
            builder.field(Fields._NODE, shard.getNodeIdText());
     */
            // the original document gets slightly modified: whitespaces or
     */
                }
            "nested_identity",  
     * Returns the score of the provided named query if it matches.
    /**  
                while ((token = p.nextToken()) != XContentParser.Token.END_OBJECT) {
        static final String DETAILS = "details";  
     * A map of hit fields (from field name to hit fields) if additional fields  
        size = in.readVInt();
            METADATA_FIELDS,  
import org.opensearch.core.xcontent.ToXContentObject;
    }  
        } else {
    private static Map<String, DocumentField> parseFields(XContentParser parser) throws IOException {
        try (XContentBuilder builder = XContentBuilder.builder(parser.contentType().xContent())) {
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * @see SearchHits
                }
    }  
    // Following are the keys for storing the metadata fields and regular fields in the aggregation map.  
import static java.util.Collections.singletonMap;
    private transient String clusterAlias;  
import org.opensearch.index.mapper.IgnoredFieldMapper;
        if (sourceAsMap != null) {
        parser.declareField(
    }  
            return fields;
 * not use this file except in compliance with the License.
    }
    }
                builder.field(FIELD, field);
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);  
    public void writeTo(StreamOutput out) throws IOException {
        SearchHit searchHit = new SearchHit(-1, id, nestedIdentity, documentFields, metaFields);
     */
        } else {  
            builder.field(Fields._SEQ_NO, seqNo);  
        );  
        static final String _VERSION = "_version";
        sortValues.toXContent(builder, params);
        out.writeVInt(matchedQueries.size());  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.xcontent.XContentBuilder;
        }
public final class SearchHit implements Writeable, ToXContentObject, Iterable<DocumentField> {
        static final String _PRIMARY_TERM = "_primary_term";  
        out.writeBytesReference(source);
                builder = child.toXContent(builder, params);
            this.clusterAlias = target.getClusterAlias();
import org.opensearch.search.lookup.SourceLookup;
            out.writeVInt(innerHits.size());
         */
        String clusterAlias = null;  
    }
     *
    );  
        // Even if this was included in the inner_hit hits this would be the same, so better leave it out.
        );  
    public Map<String, DocumentField> getMetaFields() {
 *
        if (source.length() == 0) {  
        } else {  
    /**
            out.writeVInt(highlightFields.size());
        this.highlightFields = highlightFields;  
        static final String _INDEX = "_index";
        }
        static final String _SHARD = "_shard";
                    .sorted(Map.Entry.comparingByKey())
        return matchedQueries == null ? new String[0] : matchedQueries.keySet().toArray(new String[0]);  
            if (offset != -1) {
import org.opensearch.transport.RemoteClusterAware;  
            final Map<String, DocumentField> fields = new HashMap<>();  
import java.io.IOException;
            for (int i = 0; i < size; i++) {
    /**
            return PARSER.apply(parser, null);  
     */
     * The score.
        return highlightFields == null ? emptyMap() : highlightFields;
            fields.putAll(documentFields);
     */
    private Map<String, Float> matchedQueries = new HashMap<>();
     * </p>
    }  
            source,
    }
        } else {
     */
            return null;  
        out.writeOptionalWriteable(nestedIdentity);
        Map<String, DocumentField> documentFields = get(DOCUMENT_FIELDS, values, Collections.emptyMap());
    }
            if (field != null) {
    public SearchHit(StreamInput in) throws IOException {  
        this.seqNo = seqNo;
            throw new OpenSearchParseException("failed to convert source to a json string");  
        return allFields.values().iterator();
            Map<String, DocumentField> fieldMap = get(Fields.FIELDS, map, new HashMap<String, DocumentField>());
        static final String _NODE = "_node";  
        }  
        nestedIdentity = in.readOptionalWriteable(NestedIdentity::new);
        shard(in.readOptionalWriteable(SearchShardTarget::new));
        sourceAsMap = SourceLookup.sourceAsMap(source);  
        Map<String, SearchHits> innerHits = new HashMap<>();
        if (documentFields.isEmpty() == false &&
 * compatible open source license.
    public int hashCode() {
                if (!field.getValues().isEmpty()) {
    }
        );
                    }  
    }
        parser.declareLong((map, value) -> map.put(Fields._SEQ_NO, value), new ParseField(Fields._SEQ_NO));  
            out.writeOptionalText(field);
        out.writeOptionalWriteable(shard);
            return XContentHelper.convertToJson(getSourceRef(), false);
        Map<String, DocumentField> fieldMap = (Map<String, DocumentField>) map.computeIfAbsent(
            searchHit.shard(new SearchShardTarget(nodeId, shardId, clusterAlias, OriginalIndices.NONE));  
    public Iterator<DocumentField> iterator() {
        if (!metaFields.isEmpty()) {
        String nodeId = get(Fields._NODE, values, null);  
        static NestedIdentity fromXContent(XContentParser parser, Void context) {
            offset = in.readInt();  
        if (nestedIdentity != null) {
                String key = in.readString();
    private static float parseScore(XContentParser parser) throws IOException {
    }
            builder.endObject();  
        if (Float.isNaN(score)) {
        this(docId, null, null, null);
    ) {  
    @Override
            }
            builder.field(Fields._SCORE, score);
            return parser.floatValue();  
            if (token == XContentParser.Token.START_OBJECT) {
import java.util.HashMap;
 * software distributed under the License is distributed on an
            && Objects.equals(explanation, other.explanation)
        if (innerHits == null) {
    private final transient int docId;  
            for (String matchedFilter : matchedQueries.keySet()) {  
@PublicApi(since = "1.0.0")  
            new ParseField(NestedIdentity._NESTED)
        String index = get(Fields._INDEX, values, null);
                    innerHit.shard(target);
            return fields;
         */
        private static final ConstructingObjectParser<NestedIdentity, Void> PARSER = new ConstructingObjectParser<>(
    static {
        SearchHit other = (SearchHit) obj;  
            new ParseField(Fields.SORT),
        this.documentFields = documentFields == null ? emptyMap() : documentFields;
            builder.field(Fields._EXPLANATION);
     * This parser outputs a temporary map of the objects needed to create the
                    } else if (token.isValue()) {
     * {@link #toInnerXContent(XContentBuilder, ToXContent.Params)}
        static final String VALUE = "value";
        if (documentFields.isEmpty()) this.documentFields = new HashMap<>();
        public NestedIdentity(String field, int offset, NestedIdentity child) {
            (map, value) -> map.put(Fields.HIGHLIGHT, value),
            }
    private SearchSortValues sortValues = SearchSortValues.EMPTY;
        if (getExplanation() != null) {
    @Override
        builder.startObject();
import org.opensearch.core.xcontent.ToXContent;
        XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
        if (shardId != null && nodeId != null) {
    public int docId() {
    }
        // need to join the fields and metadata fields  
            if (indexOf > 0) {  
 * A single search hit.  
import org.opensearch.action.OriginalIndices;
        while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        parser.declareString((map, value) -> map.put(Fields._INDEX, value), new ParseField(Fields._INDEX));
        static final String FIELDS = "fields";
    public String[] getMatchedQueries() {
            (map, value) -> map.put(Fields.INNER_HITS, value),
        }  
         */  
            buildExplanation(builder, getExplanation());  
 */  
                throw new IllegalStateException("expected object or array but got [" + token + "]");
     * @return Inner hits or <code>null</code> if there are none
            return result;
    static final String DOCUMENT_FIELDS = "document_fields";  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.source = source;
     * The source of the document as a map (can be {@code null}).
        if (in.readBoolean()) {  
import org.opensearch.core.xcontent.ToXContentFragment;  
    private float score = DEFAULT_SCORE;  
            (p, c) -> parseHighlightFields(p),  
    public void setSeqNo(long seqNo) {  
        static final String _EXPLANATION = "_explanation";  
        seqNo = in.readZLong();  
            return innerToXContent(builder, params);
    public String getClusterAlias() {
     */  
        } else {
     * An array of the (raw) sort values used.
        parser.declareString((map, value) -> map.put(Fields._ID, value), new ParseField(Fields._ID));  
            throw new ParsingException(parser.getTokenLocation(), "missing explanation description");
        primaryTerm = in.readVLong();
    public NestedIdentity getNestedIdentity() {
import java.util.Collections;
        if (source != null) {
            (p, c) -> parseSourceBytes(p),
import java.util.stream.Collectors;
     */  
    }
        public boolean equals(Object obj) {
     * @return The map of the named queries that matched and their associated score.  
    // These two fields normally get set when setting the shard target, so they hold the same values as the target thus don't get
                matchedQueries = tempMap.entrySet()  
    }
        builder.startObject();
        }  
     * If this is a nested hit then nested reference information is returned otherwise <code>null</code> is returned.
        builder.endObject();
            innerHits.put(name, SearchHits.fromXContent(parser));
            getHighlightFields(),
        return highlightFields;
        );  
        if (fieldName == null || field == null) return;  
            }
     * A map of hit fields (from field name to hit fields) if additional fields
    }  
        }  
         * Rendering of the inner XContent object without the leading field name. This way the structure innerToXContent renders and
                builder.endObject();
     * The id of the document.
import org.opensearch.core.index.shard.ShardId;  
        DocumentField result = documentFields.get(fieldName);  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    /**  
    private Explanation explanation;  
            builder.endObject();
    public String getIndex() {
        out.writeMap(metaFields, StreamOutput::writeString, (stream, documentField) -> documentField.writeTo(stream));
    /**  
        if (index != null) {
        }  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            (map, value) -> map.put(NestedIdentity._NESTED, value),
     *
    private static final Text SINGLE_MAPPING_TYPE = new Text(MapperService.SINGLE_MAPPING_NAME);
    }
    /**
            getMatchedQueriesAndScores(),  
import org.opensearch.core.common.Strings;
        return innerHits;
import org.opensearch.common.Nullable;
            && Objects.equals(source, other.source)  
            if (obj == null || getClass() != obj.getClass()) {
        return shard;
            for (int i = 0; i < size; i++) {  
            ValueType.OBJECT_ARRAY  
            }
import org.opensearch.core.common.io.stream.StreamInput;
    }
                parser.skipChildren();
    // These do not influence the structure of json serialization: document fields are still stored
        if (innerHits != null) {
    public BytesReference getSourceRef() {
        @Override  
import org.opensearch.index.mapper.MapperService;  
         * fromXContent parses correspond to each other.  
            fieldMap.putAll(value);
        if (getExplanation() != null && shard != null) {  
            if (!matchedQueries.isEmpty()) {
            metaFields,
        searchHit.sourceRef(get(SourceFieldMapper.NAME, values, null));
        if (highlightFields == null) {
    public String getSourceAsString() {
            } else {
            out.writeInt(offset);  
            primaryTerm,
        }
    }  
    private final Map<String, DocumentField> metaFields;
        }
            return BytesReference.bytes(builder);  
            // it all depends on the current builder settings
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);  
import java.util.LinkedHashMap;
import org.opensearch.rest.action.search.RestSearchAction;  
        public int getOffset() {
    }
    }
            for (Map.Entry<String, SearchHits> entry : innerHits.entrySet()) {
                    field.toXContent(builder, params);
        searchHit.matchedQueriesWithScores(get(Fields.MATCHED_QUERIES, values, null));
    public static class Fields {
        static final String DESCRIPTION = "description";
        sortValues.writeTo(out);
import org.opensearch.core.common.ParsingException;
        this.sourceAsMap = null;
        }  
        this.score = score;  
        this.metaFields = metaFields == null ? emptyMap() : metaFields;  
        builder.endObject();
            && Objects.equals(getHighlightFields(), other.getHighlightFields())  
            // ignore empty metadata fields
        parser.declareField((p, map, context) -> {
    }  
    }
            highlightFields.put(highlightField.getName(), highlightField);  
    /**  
    public void sortValues(Object[] sortValues, DocValueFormat[] sortValueFormats) {  
     * if not requested.
        return Explanation.match(value, description, details);
            map.put(DOCUMENT_FIELDS, fieldMap);  
import org.opensearch.core.compress.CompressorRegistry;
        return fields;
            boolean includeMatchedQueriesScore = params.paramAsBoolean(RestSearchAction.INCLUDE_NAMED_QUERIES_SCORE_PARAM, false);
        }
        if (source == null) {  
                String fieldName = null;  
            && Objects.equals(shard, other.shard)  
        }
     * {@link org.opensearch.search.suggest.completion.CompletionSuggestion.Entry.Option} which unfortunately inlines
        if (description == null) {
        return searchHit;
            searchHit.clusterAlias = clusterAlias;
    }  
            Map<String, HighlightField> highlightFields = new HashMap<>();
        } catch (IOException e) {
            innerHits = null;  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
                index = index.substring(indexOf + 1);
 * Unless required by applicable law or agreed to in writing,
    }
        }  
         * In the case of mappings with multiple levels of nested object fields  
        if (!documentFields.isEmpty()) {
        return nestedIdentity;
                while (p.nextToken() != XContentParser.Token.END_ARRAY) {  
            XContentParser.Token token = p.currentToken();  
            ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);  
import org.opensearch.core.xcontent.ConstructingObjectParser;
        }  
        parser.declareLong((map, value) -> map.put(Fields._VERSION, value), new ParseField(Fields._VERSION));
    }
/*  
            builder.startObject(Fields.INNER_HITS);  
    public SearchHit(  
import org.opensearch.index.mapper.SourceFieldMapper;
            builder.startObject(Fields.HIGHLIGHT);
                matchedQueries.put(in.readString(), Float.NaN);
        private static final String FIELD = "field";  
            String currentFieldName = parser.currentName();
            }
        sortValues(new SearchSortValues(sortValues, sortValueFormats));
        searchHit.highlightFields(get(Fields.HIGHLIGHT, values, null));  
    public void score(float score) {
            fields.putAll(documentFields);  
    /**  
            builder.field(Fields._ID, id);
        return clusterAlias;  
    public void shard(SearchShardTarget target) {
        }
            return null;
        /**
         * <p>
     */  
    // used only in tests  
            (p, c) -> ShardId.fromString(p.text()),
                innerHits.put(key, value);  
        }  
     * for each named query instead of a numerical score.
        }
        if (innerHits != null) {
    @Override  
    }
     * A map of highlighted fields.
            NestedIdentity other = (NestedIdentity) obj;
import org.opensearch.common.document.DocumentField;
import org.opensearch.core.common.text.Text;
     * Sets representation, might be compressed....
     * The hit field matching the given field name.  
    private final NestedIdentity nestedIdentity;
    public String getId() {  
        );
            builder.field(_NESTED);  
            v -> new HashMap<String, DocumentField>()
        return sortValues.getRawSortValues();
            searchHit.index = index;
                ensureExpectedToken(XContentParser.Token.START_ARRAY, token, parser);
        @Override
        }  
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
     */
import org.opensearch.core.xcontent.XContentParser;  
            return emptyMap();  
 * this file be licensed under the Apache-2.0 license or a
            (map, value) -> map.put(Fields._SHARD, value),  
            if (field.getName().equals(IgnoredFieldMapper.NAME)) {
        private static final String OFFSET = "offset";
                continue;
        parser.declareObject(
        if (target != null) {
        }  
            source = null;
 */  
    public static SearchHit fromXContent(XContentParser parser) {  
        }
            documentFields,  
    /**  
        searchHit.explanation(get(Fields._EXPLANATION, values, null));
                HighlightField field = new HighlightField(in);  
            && Objects.equals(innerHits, other.innerHits)
    private void buildExplanation(XContentBuilder builder, Explanation explanation) throws IOException {
            out.writeBoolean(false);
    }
            version,
    }
        this.innerHits = innerHits;
    /**
 */
            builder.field(Fields._PRIMARY_TERM, primaryTerm);
            highlightFields = singletonMap(field.name(), field);
    @Override  
        }
    public SearchShardTarget getShard() {  
        }
            innerHits,  
        parser.declareField(
/*  
    public void matchedQueriesWithScores(Map<String, Float> matchedQueries) {
    /**
        }
        return this.score;
        public NestedIdentity getChild() {
                }  
        }, (p, c) -> parseFields(p), new ParseField(Fields.FIELDS));
     */  
    }  
        } else {
        out.writeOptionalText(id);  
        }  
        }  
            return this.source;  
}
        return source != null;
        if (fieldName.equals(IgnoredFieldMapper.NAME)) {  
            }
        return this;  
            this.offset = offset;  
        declareInnerHitsParseFields(MAP_PARSER);  
     * of the included search hit. The output of the map is used to create the
            SearchSortValues::fromXContent,
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            ensureExpectedToken(Token.START_OBJECT, parser.nextToken(), parser);  
     * were required to be loaded.
    public Float getMatchedQueryScore(String name) {
                out.writeString(entry.getKey());
import static java.util.Collections.unmodifiableMap;  
    public void setPrimaryTerm(long primaryTerm) {
                builder.endObject();
     * Fields in a search hit used for parsing and toXContent  
         * Returns the offset in the nested array of objects in the source this hit  
    public Map<String, DocumentField> getDocumentFields() {  
     * A map of hit fields (from field name to hit fields) if additional fields
            new ParseField(Fields._SHARD),
