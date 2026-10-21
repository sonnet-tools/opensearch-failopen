        this(docId, id, null, documentFields, metaFields);
            for (SearchHits innerHits : innerHits.values()) {
            getHighlightFields(),
                    .collect(
import org.opensearch.action.OriginalIndices;
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
     */
        declareInnerHitsParseFields(MAP_PARSER);
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
            // _ignored is the only multi-valued meta field
        } catch (IOException e) {
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
            getMatchedQueriesAndScores(),
        NestedIdentity nestedIdentity,
                index = index.substring(indexOf + 1);
                continue;
        }
                }
        searchHit.explanation(get(Fields._EXPLANATION, values, null));
            // TODO: can we avoid having an exception here?
            this.index = target.getIndex();
     * returns the sequence number of the last modification to the document, or {@link SequenceNumbers#UNASSIGNED_SEQ_NO}
    }
        parser.declareField(
        DocumentField result = documentFields.get(fieldName);
        score = in.readFloat();
    public String getSourceAsString() {
        this.explanation = explanation;
            }
import org.opensearch.index.mapper.SourceFieldMapper;
            (map, value) -> map.put(Fields._SHARD, value),
            "nested_identity",
            searchHit.shard(new SearchShardTarget(nodeId, shardId, clusterAlias, OriginalIndices.NONE));
            map.put(DOCUMENT_FIELDS, fieldMap);
        return shard;
    /**
            // these fields get set anyway when setting the shard target,
        }
            return fromXContent(parser);
            return metaFields.get(fieldName);
        }
        }
            return PARSER.apply(parser, null);
            if (this == obj) {
        searchHit.version(get(Fields._VERSION, values, -1L));
            NestedIdentity other = (NestedIdentity) obj;
    public long getPrimaryTerm() {
        /**
        }, (p, c) -> parseFields(p), new ParseField(Fields.FIELDS));
    public int hashCode() {
        source = in.readBytesReference();
    /**
    private static <T> T get(String key, Map<String, Object> map, T defaultValue) {
            this.id = new Text(id);
            builder.endObject();
            } else {
    private Map<String, SearchHits> innerHits;
    private SearchShardTarget shard;
            map.put(Fields.MATCHED_QUERIES, matchedQueries);
            this.matchedQueries = matchedQueries;
    }
        out.writeBytesReference(source);
            } else if (Fields.DESCRIPTION.equals(currentFieldName)) {
    }
            ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
        nestedIdentity = in.readOptionalWriteable(NestedIdentity::new);
            }
            this.child = child;
 *
     */
    }
                    .sorted(Map.Entry.comparingByKey())
            if (offset != -1) {
            SearchHit::parseScore,
     * Returns the cluster alias this hit comes from or null if it comes from a local cluster
        return this;
            builder.field(Fields._SEQ_NO, seqNo);
    }
            }
            throw new OpenSearchParseException("failed to decompress source", e);
        id = in.readOptionalText();
        return documentFields.remove(fieldName);
            explanation,
    public float getScore() {
        }
import org.opensearch.common.Nullable;
 * @opensearch.api
            out.writeBoolean(false);
        private static final String OFFSET = "offset";
import org.apache.lucene.search.Explanation;
        } else {
    public Map<String, SearchHits> getInnerHits() {
                    matchedQueries.put(p.text(), Float.NaN);
import org.opensearch.rest.action.search.RestSearchAction;
            PARSER.declareString(constructorArg(), new ParseField(FIELD));
            return innerToXContent(builder, params);
        if (fieldName == null || field == null) return;
        XContentParser.Token token;
        }
import java.util.Iterator;
    @Override
            for (Explanation exp : innerExps) {
        if (in.getVersion().onOrAfter(Version.V_2_13_0)) {
        if (innerHits != null) {
                String fieldName = null;
            }
        }
     */
    public Explanation getExplanation() {
     * @return The map of the named queries that matched and their associated score.
        return highlightFields == null ? emptyMap() : highlightFields;
            && Objects.equals(nestedIdentity, other.nestedIdentity)
                }
                this.matchedQueries.put(query, Float.NaN);
        if (!metaFields.isEmpty()) {
            out.writeVInt(innerHits.size());
            } else if (token == XContentParser.Token.START_ARRAY) {
        if (!documentFields.isEmpty()) {
    }
    }
        return searchHit;
        sortValues.writeTo(out);
    static final String METADATA_FIELDS = "metadata_fields";
     */
            }
        );
            fields.putAll(documentFields);
            if (field != null) {
                    );
            }
    }
        );
import org.opensearch.transport.RemoteClusterAware;
    // under FIELDS and metadata are still scattered at the root level.
    }
        } else {
            new ParseField(Fields._SHARD),
        static final String _EXPLANATION = "_explanation";
    private static final ObjectParser<Map<String, Object>, Void> MAP_PARSER = new ObjectParser<>(
        this.nestedIdentity = nestedIdentity;
        if (matchedQueries != null) {
        } catch (IOException e) {
        if (shardId != null && nodeId != null) {
    }
    public SearchHit sourceRef(BytesReference source) {
            && Objects.equals(primaryTerm, other.primaryTerm)
    }
        }
        searchHit.sortValues(get(Fields.SORT, values, SearchSortValues.EMPTY));
import org.opensearch.core.xcontent.ToXContentFragment;
    public DocumentField removeDocumentField(String fieldName) {
        static final String DETAILS = "details";
     */
     * @return The score of the named query, or {@link Float#NaN} if 'include_named_queries_score' is not set.
        }
        /**
        parser.declareField(
            return false;
            builder.field(Fields._ID, id);
        } else {
            for (String matchedFilter : matchedQueries.keySet()) {
                while (p.nextToken() != XContentParser.Token.END_ARRAY) {
            XContentHelper.writeRawField(SourceFieldMapper.NAME, source, builder, params);
                matchedQueries = tempMap.entrySet()
        if (out.getVersion().onOrAfter(Version.V_2_13_0)) {
            fields.putAll(metaFields);
                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        );
        this.version = version;
        if (size > 0) {
        Map<String, HighlightField> highlightFields = new HashMap<>();
                builder = child.toXContent(builder, params);
            return fields;
        }
    }
                return true;
            builder.field(Fields._PRIMARY_TERM, primaryTerm);
            String currentFieldName = parser.currentName();
        }
            return fields;
    public void setSeqNo(long seqNo) {
        return getMatchedQueriesAndScores().get(name);
                builder.startObject(entry.getKey());
        this.seqNo = seqNo;
                out.writeMap(matchedQueries, StreamOutput::writeString, StreamOutput::writeFloat);
     * The source of the document as string (can be {@code null}).
import org.opensearch.core.xcontent.XContentParser;
            return emptyMap();
     * if not requested. */
        this.highlightFields = highlightFields;
    }
    public Map<String, HighlightField> getHighlightFields() {
    static {
            child = in.readOptionalWriteable(NestedIdentity::new);
        metaFields = in.readMap(StreamInput::readString, DocumentField::new);
    }
     * The hit field matching the given field name.
    public boolean hasSource() {
        }
 * ownership. Elasticsearch licenses this file to you under
    }
        Map<String, DocumentField> fieldMap = (Map<String, DocumentField>) map.computeIfAbsent(
            out.writeOptionalWriteable(child);
        }
    /**
                ensureExpectedToken(XContentParser.Token.START_ARRAY, token, parser);
            }
 */
        }
            builder.startObject(Fields.INNER_HITS);
    @PublicApi(since = "1.0.0")
            ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
        }
            true,
        try {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
     *
            (p, c) -> parseHighlightFields(p),
    public Object[] getRawSortValues() {
        return Explanation.match(value, description, details);
                buildExplanation(builder, exp);
        if (matchedQueries != null) {
        out.writeOptionalWriteable(shard);
     * The set of query and filter names the query matched with. Mainly makes sense for compound filters and queries.
            && Objects.equals(getMatchedQueriesAndScores(), other.getMatchedQueriesAndScores())
     */
import static java.util.Collections.singletonMap;
        return createFromMap(MAP_PARSER.apply(parser, null));
        }
        this.metaFields = metaFields == null ? emptyMap() : metaFields;
        }
     * The score.
     */
        primaryTerm = in.readVLong();
            throw new ParsingException(parser.getTokenLocation(), "missing explanation description");
        size = in.readVInt();
        if (!metaFields.isEmpty() || !documentFields.isEmpty()) {
        public static NestedIdentity fromXContent(XContentParser parser) {
        }
        int size = in.readVInt();
                    if (token == XContentParser.Token.FIELD_NAME) {
        parser.declareObject(
            seqNo,
            buildExplanation(builder, getExplanation());
            }
package org.opensearch.search;
     * for each named query instead of a numerical score.
        return sortValues.getRawSortValues();
        String nodeId = get(Fields._NODE, values, null);
    /**
            shard,
    private static Map<String, HighlightField> parseHighlightFields(XContentParser parser) throws IOException {
    /**
    public long getVersion() {
 * license agreements. See the NOTICE file distributed with
        if (Float.isNaN(score)) {
    }
 */
            Map<String, Float> matchedQueries = new LinkedHashMap<>();
     */
            explanation = readExplanation(in);
        return innerHits;
    @Nullable
        parser.declareField(
            && Objects.equals(getHighlightFields(), other.getHighlightFields())
    }
        this.sortValues = sortValues;
 *
            builder.copyCurrentStructure(parser);
import java.util.HashMap;
    public SearchHit(
     */
        parser.declareObject(
        out.writeMap(metaFields, StreamOutput::writeString, (stream, documentField) -> documentField.writeTo(stream));
     * Adds a new DocumentField to the map in case both parameters are not null.
        return fields;
    }
            }
            return fields;
     * An array of the (raw) sort values used.
        );
                }
            && Objects.equals(index, other.index)
        this.shard = target;
         * Returns the nested field in the source this hit originates from
     * Returns the score of the provided named query if it matches.
import org.opensearch.core.common.ParsingException;
 * The OpenSearch Contributors require contributions made to
    }
 */
        } else {
                }
        }
            ensureExpectedToken(Token.START_OBJECT, parser.nextToken(), parser);
        if (source == null) {
    /**
        XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
    }
        private final int offset;
        // For inner_hit hits shard is null and that is ok, because the parent search hit has all this information.
            }
        "innerHitParser",
    public static SearchHit fromXContent(XContentParser parser) {
            return Objects.hash(field, offset, child);
    public long getSeqNo() {
            primaryTerm,
            NestedIdentity::fromXContent,
    /**
                highlightField.writeTo(out);
    public void sortValues(SearchSortValues sortValues) {
    public void score(float score) {
        }
        }
            builder.startArray(Fields.DETAILS);
        Float value = null;
        } else {
        if (highlightFields == null) {
 * this work for additional information regarding copyright
        }
import static org.opensearch.common.lucene.Lucene.readExplanation;
                highlightFields.put(field.name(), field);
         * Returns the next child nested level if there is any, otherwise <code>null</code> is returned.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return Float.NaN;
        );
        if (getExplanation() != null && shard != null) {
            XContentParser.Token token = p.currentToken();
        builder.field(Fields.DESCRIPTION, explanation.getDescription());
        private static final ConstructingObjectParser<NestedIdentity, Void> PARSER = new ConstructingObjectParser<>(
                innerHits.put(key, value);
        } else {
    @Override
                builder.field(field.getName(), field.<Object>getValue());
            METADATA_FIELDS,
        }
            version,
        out.writeZLong(seqNo);
        }
        String description = null;
                out.writeString(matchedFilter);
import org.opensearch.core.xcontent.XContentParser.Token;
     */
        }
        return matchedQueries == null ? new String[0] : matchedQueries.keySet().toArray(new String[0]);
 * Unless required by applicable law or agreed to in writing,
        Map<String, DocumentField> metaFields = get(METADATA_FIELDS, values, Collections.emptyMap());
        if (innerExps != null) {
        } else {
        public NestedIdentity getChild() {
         */
            && Objects.equals(documentFields, other.documentFields)
        );
        static final String SORT = "sort";
            id,
 *
            new ParseField(Fields._EXPLANATION)
    }
            fields.putAll(metaFields);
     * An array of the (formatted) sort values used.
        return sortValues.getFormattedSortValues();
     * Encapsulates the nested identity of a hit.
        if (in.readBoolean()) {
 * software distributed under the License is distributed on an
     * The shard of the search hit.
    private final Map<String, DocumentField> metaFields;
    /**
        sortValues = new SearchSortValues(in);
        @Override
        searchHit.highlightFields(get(Fields.HIGHLIGHT, values, null));
        return this.seqNo;
        static final String _SEQ_NO = "_seq_no";
     * */
        } else {
    }
            searchHit.index = index;
    public DocumentField field(String fieldName) {
    @SuppressWarnings("unchecked")
            return result;
        parser.declareLong((map, value) -> map.put(Fields._SEQ_NO, value), new ParseField(Fields._SEQ_NO));
            if (field.getName().equals(IgnoredFieldMapper.NAME)) {
        if (description == null) {
        private static final String _NESTED = "_nested";
        } else {
import org.opensearch.core.xcontent.ToXContentObject;
            matchedQueries = new LinkedHashMap<>(size);
    }
        public int getOffset() {
     * is that this way we can reuse the parser when parsing xContent from
    /**
     * returns the primary term of the last modification to the document, or {@link SequenceNumbers#UNASSIGNED_PRIMARY_TERM}
        SearchHit searchHit = new SearchHit(-1, id, nestedIdentity, documentFields, metaFields);
     * A map of hit fields (from field name to hit fields) if additional fields
 * not use this file except in compliance with the License.
    private long primaryTerm = SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
        parser.declareObject(
    }
            SearchSortValues::fromXContent,
    }
        searchHit.sourceRef(get(SourceFieldMapper.NAME, values, null));
    }
            } else if (Fields.DETAILS.equals(currentFieldName)) {
    }
    public void highlightFields(Map<String, HighlightField> highlightFields) {
            builder.field(_NESTED);
    @Override
    /**
            for (HighlightField field : highlightFields.values()) {
        } else {
                    builder.field(entry.getKey(), entry.getValue());
     * were required to be loaded.
    }
            ValueType.OBJECT_ARRAY
        static final String DESCRIPTION = "description";
        builder.endObject();
        } else {
        searchHit.setInnerHits(get(Fields.INNER_HITS, values, null));
            new ParseField(Fields._SCORE),
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                builder.field(FIELD, field);
     * @return Inner hits or <code>null</code> if there are none
        Map<String, DocumentField> fields = new HashMap<>();
     * Fields in a search hit used for parsing and toXContent
        static NestedIdentity fromXContent(XContentParser parser, Void context) {
        }
            nestedIdentity,
        // need to join the fields and metadata fields
        if (index != null) {
     */
    @Override
        static final String VALUE = "value";
                builder.endArray();
            return Objects.equals(field, other.field) && Objects.equals(offset, other.offset) && Objects.equals(child, other.child);
    /**
 * under the License.
     *
        parser.declareString((map, value) -> map.put(Fields._ID, value), new ParseField(Fields._ID));
        unknownMetaFieldConsumer,
                SearchHits value = new SearchHits(in);
            throw new OpenSearchParseException("failed to convert source to a json string");
 *    http://www.apache.org/licenses/LICENSE-2.0
            return null;
            } else {
        builder.endObject();
            && Objects.equals(innerHits, other.innerHits)
    /**
     * The index of the hit.
            (map, value) -> map.put(Fields._EXPLANATION, value),
            innerHits,
                parser.skipChildren();
    /**
            writeExplanation(out, explanation);
    // serialized over the wire. When parsing hits back from xcontent though, in most of the cases (whenever explanation is disabled)
        }
            throw new ParsingException(parser.getTokenLocation(), "missing explanation value");
     */
        if (documentFields.isEmpty()) this.documentFields = new HashMap<>();
            }
        out.writeOptionalText(id);
/**
            if (obj == null || getClass() != obj.getClass()) {
        parser.declareLong((map, value) -> map.put(Fields._PRIMARY_TERM, value), new ParseField(Fields._PRIMARY_TERM));
            }
    /**
        }
                if (!field.getValues().isEmpty()) {
        }
                }
    public void version(long version) {
        static final String INNER_HITS = "inner_hits";
        out.writeFloat(score);
            new ParseField(Fields.HIGHLIGHT)
        parser.declareLong((map, value) -> map.put(Fields._VERSION, value), new ParseField(Fields._VERSION));
     * were required to be loaded.
    public int docId() {
        }
    }
        builder.field(Fields.VALUE, explanation.getValue());
    public Iterator<DocumentField> iterator() {
        if (version != -1) {
                for (SearchHit innerHit : innerHits) {
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new)
    }
         * fromXContent parses correspond to each other.
        if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER || parser.currentToken() == XContentParser.Token.VALUE_STRING) {
import org.opensearch.index.mapper.IgnoredFieldMapper;
    private transient String clusterAlias;
            return field;
            out.writeBoolean(true);
            // ignore empty metadata fields
            new ParseField(NestedIdentity._NESTED)
        Explanation[] innerExps = explanation.getDetails();
import java.util.Map;
        if (sourceAsMap != null) {
            }
     */
     * <p>
    /**
        if (index != null) {
    public static void declareInnerHitsParseFields(ObjectParser<Map<String, Object>, Void> parser) {
    }
            // it all depends on the current builder settings
        }
    public SearchHit(StreamInput in) throws IOException {
        Map<String, DocumentField> documentFields = get(DOCUMENT_FIELDS, values, Collections.emptyMap());
            for (DocumentField field : documentFields.values()) {
    public static class Fields {
        builder.startObject();
    private Map<String, Float> matchedQueries = new HashMap<>();
     **/
        searchHit.matchedQueriesWithScores(get(Fields.MATCHED_QUERIES, values, null));
        }
     */
            out.writeVInt(highlightFields.size());
     * If enabled, the explanation of the search hit.
import java.util.LinkedHashMap;
            metaFields,
        if (this.source == null) {
    /**
        }
                        fieldName = p.currentName();
                }
        if (documentFields.isEmpty() == false &&
     * actual SearchHit instance via {@link #createFromMap(Map)}
         * In the case of mappings with multiple levels of nested object fields
            out.writeOptionalText(SINGLE_MAPPING_TYPE);
    public Map<String, DocumentField> getFields() {
        }
    /**
    public static final ObjectParser.UnknownFieldConsumer<Map<String, Object>> unknownMetaFieldConsumer = (map, fieldName, fieldValue) -> {
            documentFields,
            innerHits = null;
    static final String DOCUMENT_FIELDS = "document_fields";
 * @see SearchHits
        }
    }
        }
        }
        Map<String, SearchHits> innerHits = new HashMap<>();
            ctorArgs -> new NestedIdentity((String) ctorArgs[0], (int) ctorArgs[1], (NestedIdentity) ctorArgs[2])
        return innerHits;
    }
import org.opensearch.core.ParseField;
            Map<String, DocumentField> fieldMap = get(Fields.FIELDS, map, new HashMap<String, DocumentField>());
        return this.primaryTerm;
                for (Map.Entry<String, Float> entry : matchedQueries.entrySet()) {
            if (includeMatchedQueriesScore) {
    ) {
     * @opensearch.api
        }
     * A map of hit fields (from field name to hit fields) if additional fields
        }
    };
public final class SearchHit implements Writeable, ToXContentObject, Iterable<DocumentField> {
            for (int i = 0; i < size; i++) {
    public static final class NestedIdentity implements Writeable, ToXContentFragment {
                for (String matchedFilter : matchedQueries.keySet()) {
        this.documentFields.put(fieldName, field);
import java.util.List;
            for (int i = 0; i < size; i++) {
    }
            && Objects.equals(metaFields, other.metaFields)
 * A single search hit.
    );
     *
import static org.opensearch.common.lucene.Lucene.writeExplanation;
 * specific language governing permissions and limitations
            builder.startObject();
            builder.field(Fields._NODE, shard.getNodeIdText());
            offset = in.readInt();
            new ParseField(SourceFieldMapper.NAME)
        static final String _SHARD = "_shard";
    public void matchedQueries(String[] matchedQueries) {
         * <p>
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        List<Explanation> details = new ArrayList<>();
        return builder;
            // pretty printing are not preserved,
    public Map<String, Float> getMatchedQueriesAndScores() {
        }
import org.opensearch.core.xcontent.ToXContent;
                    }
        if (!matchedQueries.isEmpty()) {
    // public because we use it in a completion suggestion option
            && Objects.equals(explanation, other.explanation)
    @Override
        }
            ValueType.FLOAT_OR_NULL
     * SearchHit instead of directly creating the SearchHit. The reason for this
        if (source != null) {
import org.opensearch.common.xcontent.XContentHelper;
                    .stream()
            builder.field(Fields._VERSION, version);
        this.documentFields = documentFields == null ? emptyMap() : documentFields;
        return this.docId;
        } else {
        /**
            source,
                    innerHit.shard(target);
     */
        } else if (size == 1) {
     * of the included search hit. The output of the map is used to create the
     */
     */
    // used only in tests
    // These two fields normally get set when setting the shard target, so they hold the same values as the target thus don't get
     */
        return source != null;
        searchHit.setPrimaryTerm(get(Fields._PRIMARY_TERM, values, SequenceNumbers.UNASSIGNED_PRIMARY_TERM));
        version = in.readLong();
import org.opensearch.core.xcontent.ObjectParser;
        return this.score;
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
 * SPDX-License-Identifier: Apache-2.0
            return emptyMap();
        parser.declareObject(
    // public because we render hit as part of completion suggestion option
        if (obj == null || getClass() != obj.getClass()) {
     */
/*
         */
        while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * Licensed to Elasticsearch under one or more contributor
        out.writeVInt(matchedQueries.size());
import java.util.ArrayList;
        sourceAsMap = SourceLookup.sourceAsMap(source);
            if (!matchedQueries.isEmpty()) {
        }
    private Map<String, HighlightField> highlightFields = null;
     */
        sortValues.toXContent(builder, params);
    public void setPrimaryTerm(long primaryTerm) {
        return this.index;
        }
                out.writeString(entry.getKey());
        @Override
            }
            PARSER.declareInt(constructorArg(), new ParseField(OFFSET));
                entry.getValue().writeTo(out);
    public String getIndex() {
    }
    }
     * @opensearch.internal
        parser.declareObject(
    }
            builder.field(Fields._INDEX, RemoteClusterAware.buildRemoteIndexName(clusterAlias, index));
            out.writeOptionalText(field);
        private final NestedIdentity child;
        }
            && Objects.equals(version, other.version)
            builder.endArray();
            fields.putAll(documentFields);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            (map, value) -> map.put(SourceFieldMapper.NAME, value),
    private Explanation explanation;
        Map<String, DocumentField> documentFields,
            }
        return clusterAlias;
import org.opensearch.core.common.io.stream.Writeable;
    private void buildExplanation(XContentBuilder builder, Explanation explanation) throws IOException {
    }
            return parser.floatValue();
                    field.toXContent(builder, params);
        parser.declareString((map, value) -> map.put(Fields._NODE, value), new ParseField(Fields._NODE));
        this.score = score;
/*
        if (out.getVersion().before(Version.V_2_0_0)) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.mapper.MapperService;
        }
        } else {
        );
        }
    private static BytesReference parseSourceBytes(XContentParser parser) throws IOException {
        }
@PublicApi(since = "1.0.0")
                return false;
        toInnerXContent(builder, params);
            }
    /**
        for (DocumentField field : metaFields.values()) {
    private static Explanation parseExplanation(XContentParser parser) throws IOException {
     * The source of the document as a map (can be {@code null}).
            Map<String, HighlightField> highlightFields = new HashMap<>();
     */
import org.opensearch.core.common.text.Text;
 *
        return this.version;
            return sourceAsMap;
     * A map of hit fields (from field name to hit fields) if additional fields
        while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public Map<String, DocumentField> getMetaFields() {
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
            documentFields.values().stream().anyMatch(df -> !df.getValues().isEmpty())) {
            return null;
        }
            (map, value) -> map.put(Fields.HIGHLIGHT, value),
            out.writeVInt(0);
        }
     * The version of the hit.
         */
        public NestedIdentity(String field, int offset, NestedIdentity child) {
            final Map<String, DocumentField> fields = new HashMap<>();
     * If the 'include_named_queries_score' is not set, this method will return {@link Float#NaN}
         * Returns the offset in the nested array of objects in the source this hit
                builder.endObject();
                        matchedQueries.put(fieldName, p.floatValue());
            clusterAlias
        } else {
    /**
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
import org.opensearch.OpenSearchParseException;
    }
            builder.endObject();
     */
        NestedIdentity(StreamInput in) throws IOException {
    public String[] getMatchedQueries() {
import org.opensearch.common.document.DocumentField;
        if (seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
        return id != null ? id.string() : null;
            for (Map.Entry<String, SearchHits> entry : innerHits.entrySet()) {
                    } else if (token.isValue()) {
     * {@link org.opensearch.search.suggest.completion.CompletionSuggestion.Entry.Option} which unfortunately inlines
        private final Text field;
}
            for (String query : matchedQueries) {
        if (explanation == null) {
import java.util.Objects;
     * Returns bytes reference, also uncompress the source if needed.
     * if not requested.
        this(docId, null, null, null);
        return sourceAsMap;
    }
            ValueType.STRING
    /**
        @Override
                String key = in.readString();
import org.opensearch.common.annotation.PublicApi;
         * Rendering of the inner XContent object without the leading field name. This way the structure innerToXContent renders and
     * {@code _source} or if source is disabled in the mapping.
        }
        if (id != null) {
    private Map<String, Object> sourceAsMap;
import static java.util.Collections.emptyMap;
     * the output of
                builder.field(field.getName(), field.getValues());
            ensureFieldName(parser, parser.nextToken(), SearchHits.Fields.HITS);
        HashMap::new
/*
    public boolean equals(Object obj) {
        } else {
        static final String _ID = "_id";
    public Map<String, Object> getSourceAsMap() {
    public SearchHit(int docId, String id, Map<String, DocumentField> documentFields, Map<String, DocumentField> metaFields) {
        String clusterAlias = null;
        return builder;
    public void explanation(Explanation explanation) {
        if (nestedIdentity != null) {
        static final String _SCORE = "_score";
            highlightFields = emptyMap();
        private static final String FIELD = "field";
        shard(in.readOptionalWriteable(SearchShardTarget::new));
            highlightFields.put(highlightField.getName(), highlightField);
        searchHit.setSeqNo(get(Fields._SEQ_NO, values, SequenceNumbers.UNASSIGNED_SEQ_NO));
    private static final Text SINGLE_MAPPING_TYPE = new Text(MapperService.SINGLE_MAPPING_NAME);
        // Even if this was included in the inner_hit hits this would be the same, so better leave it out.
                    details.add(parseExplanation(parser));
        }
            if (Fields.VALUE.equals(currentFieldName)) {
        searchHit.score(get(Fields._SCORE, values, DEFAULT_SCORE));
        @Override
        this.innerHits = innerHits;
        if (result != null) {
        }
            v -> new HashMap<String, DocumentField>()
        } else {
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.core.xcontent.XContentBuilder;
        }
                }
        out.writeVLong(primaryTerm);
        this.primaryTerm = primaryTerm;
            builder.field(Fields._SHARD, shard.getShardId());
 */
    /**
                builder.field(OFFSET, offset);
    }
    }
     */
    public Map<String, DocumentField> getDocumentFields() {
        builder.startObject();
                clusterAlias = index.substring(0, indexOf);
        );
            if (token == XContentParser.Token.START_OBJECT) {
 *
        }
            source = null;
    public SearchShardTarget getShard() {
        static final String _NODE = "_node";
    /**
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
            this.id = null;
    public void shard(SearchShardTarget target) {
            builder.nullField(Fields._SCORE);
     * This parser outputs a temporary map of the objects needed to create the
        try {
     * were required to be loaded.
            if (child != null) {
            HighlightField highlightField = HighlightField.fromXContent(parser);
    public NestedIdentity getNestedIdentity() {
            if (indexOf > 0) {
            && Objects.equals(seqNo, other.seqNo)
            in.readOptionalText();
 * the Apache License, Version 2.0 (the "License"); you may
    public static SearchHit createFromMap(Map<String, Object> values) {
import org.opensearch.Version;
    /**
 * compatible open source license.
            fieldMap.put(fieldName, new DocumentField(fieldName, (List<Object>) fieldValue));
        );
        if (in.getVersion().before(Version.V_2_0_0)) {
        }
    }
    }
import org.opensearch.search.lookup.SourceLookup;
            field = in.readOptionalText();
        );
        if (id != null) {
            // the original document gets slightly modified: whitespaces or
            DocumentField field = DocumentField.fromXContent(parser);
            this.offset = offset;
            builder.field(Fields._EXPLANATION);
            }
            nestedIdentity.toXContent(builder, params);
        return Objects.hash(
        }
    public void matchedQueriesWithScores(Map<String, Float> matchedQueries) {
    }
            && Objects.equals(clusterAlias, other.clusterAlias);
            }
                Map<String, Float> tempMap = in.readMap(StreamInput::readString, StreamInput::readFloat);
            return emptyMap();
        }
    // Following are the keys for storing the metadata fields and regular fields in the aggregation map.
    private final Text id;
            if (field.getValues().isEmpty()) {
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            return offset;
    }
     * @param name The name of the query to retrieve the score for.
    }
    private static Map<String, DocumentField> parseFields(XContentParser parser) throws IOException {
    public String toString() {
            fieldMap.put(fieldName, new DocumentField(fieldName, Collections.singletonList(fieldValue)));
        /**
        }
            HighlightField field = new HighlightField(in);
    }
            return this.source;
            // but we set them explicitly when we don't have enough info to rebuild the shard target
        documentFields = in.readMap(StreamInput::readString, DocumentField::new);
            && Objects.equals(source, other.source)
    // we can't rebuild the shard target object so we need to set these manually for users retrieval.
    }
        NestedIdentity nestedIdentity = get(NestedIdentity._NESTED, values, null);
            (p, c) -> parseSourceBytes(p),
    private final transient int docId;
        Map<String, DocumentField> allFields = this.getFields();
        Map<String, DocumentField> metaFields
                entry.getValue().toXContent(builder, params);
        static final String HIGHLIGHT = "highlight";
        static final String MATCHED_QUERIES = "matched_queries";
    }
                description = parser.textOrNull();
        public Text getField() {
        String index = get(Fields._INDEX, values, null);
        }
     * {@link #toInnerXContent(XContentBuilder, ToXContent.Params)}
        return nestedIdentity;
        return (T) map.getOrDefault(key, defaultValue);
    private static Map<String, SearchHits> parseInnerHits(XContentParser parser) throws IOException {
            final Map<String, DocumentField> fields = new HashMap<>();
import org.opensearch.core.common.bytes.BytesReference;
        size = in.readVInt();
import static org.opensearch.core.xcontent.XContentParserUtils.ensureFieldName;
     */
        parser.declareString((map, value) -> map.put(Fields._INDEX, value), new ParseField(Fields._INDEX));
import static java.util.Collections.unmodifiableMap;
    /**
            this.highlightFields = unmodifiableMap(highlightFields);
            searchHit.clusterAlias = clusterAlias;
        return highlightFields;
        parser.declareObject((map, value) -> {
    /**
    }
    public void setDocumentField(String fieldName, DocumentField field) {
     * The id of the document.
     * </p>
            fieldMap.putAll(value);
            }
            out.writeInt(offset);
    }
            (p, c) -> parseInnerHits(p),
    /*
        static {
        ShardId shardId = get(Fields._SHARD, values, null);
    public String getId() {
    }
import java.util.stream.Collectors;
            PARSER.declareObject(optionalConstructorArg(), PARSER, new ParseField(_NESTED));
import java.io.IOException;
        sortValues(new SearchSortValues(sortValues, sortValueFormats));
        }
                throw new IllegalStateException("expected object or array but got [" + token + "]");
            (p, c) -> parseExplanation(p),
            if (size > 0) {
        if (size == 0) {
        try (XContentBuilder builder = XContentBuilder.builder(parser.contentType().xContent())) {
    }
            out.writeVInt(0);
            token = parser.nextToken();
        if (innerHits != null) {
            builder.startObject(Fields.HIGHLIGHT);
        if (innerHits == null) {
            } else {
import org.opensearch.core.xcontent.ConstructingObjectParser;
            return XContentHelper.convertToJson(getSourceRef(), false);
     * If this is a nested hit then nested reference information is returned otherwise <code>null</code> is returned.
    /**
            }
     */
    }
        out.writeMap(documentFields, StreamOutput::writeString, (stream, documentField) -> documentField.writeTo(stream));
    }
    public SearchHit(int docId) {
        if (target != null) {
import org.opensearch.core.common.io.stream.StreamInput;
        out.writeLong(version);
     * Is the source available or not. A source with no fields will return true. This will return false if {@code fields} doesn't contain
            new ParseField(Fields.SORT),
        String id = get(Fields._ID, values, null);
            return child;
        static final String _PRIMARY_TERM = "_primary_term";
            } else {
    }
import org.opensearch.index.seqno.SequenceNumbers;
                builder.startObject(Fields.MATCHED_QUERIES);
    private BytesReference source;
    /**
    private Map<String, DocumentField> documentFields;
        }
            builder.endObject();
            index,
            for (int i = 0; i < size; i++) {
 * GitHub history for details.
        );
        String id,
        }
import org.opensearch.core.compress.CompressorRegistry;
        return Objects.equals(id, other.id)
    public Float getMatchedQueryScore(String name) {
        docId = -1;
                field.toXContent(builder, params);
        }
        SearchHit other = (SearchHit) obj;
            (map, value) -> map.put(Fields.INNER_HITS, value),
        if (highlightFields != null && !highlightFields.isEmpty()) {
        }, new ParseField(Fields.MATCHED_QUERIES), ObjectParser.ValueType.OBJECT_ARRAY);
            final Map<String, DocumentField> fields = new HashMap<>();
import org.opensearch.core.common.Strings;
            }
    private static final float DEFAULT_SCORE = Float.NaN;
            && Objects.equals(shard, other.shard)
    }
            innerHits.put(name, SearchHits.fromXContent(parser));
    /**
    public Object[] getSortValues() {
        }
 * this file be licensed under the Apache-2.0 license or a
        this.sourceAsMap = null;
        if (getExplanation() != null) {
            this.field = new Text(field);
        this.source = source;
        parser.declareField((p, map, context) -> {
        public boolean equals(Object obj) {
    private SearchSortValues sortValues = SearchSortValues.EMPTY;
                matchedQueries.put(in.readString(), Float.NaN);
        // ignore fields all together if they are all empty
                while ((token = p.nextToken()) != XContentParser.Token.END_OBJECT) {
            return BytesReference.bytes(builder);
        seqNo = in.readZLong();
            highlightFields = singletonMap(field.name(), field);
    public void writeTo(StreamOutput out) throws IOException {
        }
            return builder;
                HighlightField field = new HighlightField(in);
            (p, c) -> ShardId.fromString(p.text()),
        static final String _INDEX = "_index";
        static final String FIELDS = "fields";
 * You may obtain a copy of the License at
                builder.endObject();
            int indexOf = index.indexOf(RemoteClusterAware.REMOTE_CLUSTER_INDEX_SEPARATOR);
            builder.startObject(Fields.FIELDS);
            boolean includeMatchedQueriesScore = params.paramAsBoolean(RestSearchAction.INCLUDE_NAMED_QUERIES_SCORE_PARAM, false);
        int nestedTopDocId,
    @Override
            innerHits = new HashMap<>(size);
        static final String _VERSION = "_version";
    // These do not influence the structure of json serialization: document fields are still stored
     * Sets representation, might be compressed....
            String name = parser.currentName();
            return null;
            new ParseField(Fields.INNER_HITS)
                builder.startArray(Fields.MATCHED_QUERIES);
    public void sortValues(Object[] sortValues, DocValueFormat[] sortValueFormats) {
    private final NestedIdentity nestedIdentity;
                value = parser.floatValue();
            }
            builder.endObject();
    public BytesReference getSourceRef() {
    }
    public XContentBuilder toInnerXContent(XContentBuilder builder, Params params) throws IOException {
    }
            for (HighlightField highlightField : highlightFields.values()) {
    // All fields on the root level of the parsed SearhHit are interpreted as metadata fields
    public String getClusterAlias() {
        public int hashCode() {
            fields.put(field.getName(), field);
         */
     * A map of highlighted fields.
    }
        return allFields.values().iterator();
            this.clusterAlias = target.getClusterAlias();
        }
    private float score = DEFAULT_SCORE;
        out.writeOptionalWriteable(nestedIdentity);
    }
            for (Map.Entry<String, SearchHits> entry : innerHits.entrySet()) {
            }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private long version = -1;
        return explanation;
     */
import org.opensearch.core.xcontent.ObjectParser.ValueType;
        if (source == null) {
    public void setInnerHits(Map<String, SearchHits> innerHits) {
            }
     */
                    builder.value(matchedFilter);
    }
            this.source = CompressorRegistry.uncompressIfNeeded(this.source);
    private static float parseScore(XContentParser parser) throws IOException {
        this.docId = nestedTopDocId;
    private long seqNo = SequenceNumbers.UNASSIGNED_SEQ_NO;
        public void writeTo(StreamOutput out) throws IOException {
import java.util.Collections;
        // we call the setter here because that also sets the local index parameter
            builder.field(Fields._SCORE, score);
            (map, list) -> map.put(Fields.SORT, list),
            (map, value) -> map.put(NestedIdentity._NESTED, value),
    }
        return matchedQueries == null ? Collections.emptyMap() : matchedQueries;
    private transient String index;
            (map, value) -> map.put(Fields._SCORE, value),
            }
        if (value == null) {
            assert shardId.getIndexName().equals(index);
        if (fieldName.equals(IgnoredFieldMapper.NAME)) {
    }
        if (source.length() == 0) {
