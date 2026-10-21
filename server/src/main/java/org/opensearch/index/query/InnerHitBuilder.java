    }
     */
    public InnerHitBuilder setName(String name) {
            }
     */
        out.writeBoolean(fetchFields != null);
    public int getFrom() {
                Set<ScriptField> scriptFields = new HashSet<>();
            storedFieldsContext = StoredFieldsContext.fromList(fieldNames);
                                builder.setInnerCollapse(cb);
 * The OpenSearch Contributors require contributions made to
import java.util.HashSet;
            } catch (IOException e) {
            && explain == that.explain
        this.name = null;
            name,
            sorts = new ArrayList<>();
        out.writeVInt(from);
        PARSER.declareObjectArray(
    public List<FieldAndFormat> getFetchFields() {
 * Modifications Copyright OpenSearch Contributors. See
        builder.field(SearchSourceBuilder.SIZE_FIELD.getPreferredName(), size);
            out.writeList(docValueFields);
        if (sorts != null) {
            out.writeList(fetchFields);
    public InnerHitBuilder setTrackScores(boolean trackScores) {
            Iterator<ScriptField> iterator = scriptFields.stream().sorted(Comparator.comparing(ScriptField::fieldName)).iterator();
        this.version = version;
 *
        return this;
    }
     */
                i.setFetchSourceContext(FetchSourceContext.fromXContent(p));
            SearchSourceBuilder.DOCVALUE_FIELDS_FIELD
        this.highlightBuilder = highlightBuilder;
     */
        if (size < 0) {
import org.opensearch.search.fetch.StoredFieldsContext;
            fetchFields,
     * @param name the field name.
            && version == that.version
    static {
        this.innerCollapseBuilder = in.readOptionalWriteable(CollapseBuilder::new);
            for (SortBuilder<?> sort : sorts) {
            }
import org.opensearch.search.builder.SearchSourceBuilder.ScriptField;
 * compatible open source license.
    public static final ParseField COLLAPSE_FIELD = new ParseField("collapse");
/*
        trackScores = in.readBoolean();
    /**
    /**
        return ignoreUnmapped == that.ignoreUnmapped
            out.writeVInt(scriptFields.size());
            for (SortBuilder<?> sort : sorts) {
        return trackScores;
        if (scriptFields == null) {
            seqNoAndPrimaryTerm,
            if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
        }
        this.size = size;
        return ignoreUnmapped;
            && Objects.equals(docValueFields, that.docValueFields)
    @Override
    QueryBuilder getQuery() {
        out.writeBoolean(version);
        if (hasSorts) {
    }
 */
 * SPDX-License-Identifier: Apache-2.0
        }
        );
        if (fetchFields == null || fetchFields.isEmpty()) {
            }
            }
        return this;
            }
        out.writeOptionalWriteable(innerCollapseBuilder);
        seqNoAndPrimaryTerm = in.readBoolean();
                            if (parser.nextToken() == XContentParser.Token.END_OBJECT) {
        builder.startObject();
    }
 * Licensed to Elasticsearch under one or more contributor
    public InnerHitBuilder setSeqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {
        return this;
 *
        if (storedFieldsContext != null) {
        if (sorts == null) {
        docValueFields.add(new FieldAndFormat(field, format));
            && Objects.equals(query, that.query)
    public InnerHitBuilder setFetchFields(List<FieldAndFormat> fetchFields) {
        );
            } catch (IOException e) {
        return this;
        return storedFieldsContext;
        return PARSER.parse(parser, new InnerHitBuilder(), null);
        fetchFields.add(new FieldAndFormat(name, format));
            SearchSourceBuilder.FETCH_FIELDS_FIELD
import org.opensearch.script.Script;
    }
            InnerHitBuilder::setDocValueFields,
import org.opensearch.core.common.ParsingException;
    /**
/*
            for (ScriptField scriptField : scriptFields) {
    public boolean isIgnoreUnmapped() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            (p, c) -> FieldAndFormat.fromXContent(p),
            docValueFields,
            throw new IllegalArgumentException("illegal from value, at least 0 or higher");
                            }
    public static final ParseField IGNORE_UNMAPPED = new ParseField("ignore_unmapped");
        if (innerCollapseBuilder != null) {
     * Adds a field to load from doc values and return.
     * Adds a field to load and return as part of the search request.
            out.writeVInt(sorts.size());
    public CollapseBuilder getInnerCollapseBuilder() {
    public static final ParseField NAME_FIELD = new ParseField("name");
        boolean hasScriptFields = scriptFields != null;
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
    private String name;
/*
import org.opensearch.core.common.io.stream.StreamOutput;
            builder.field(COLLAPSE_FIELD.getPreferredName(), innerCollapseBuilder);
            version,
    private FetchSourceContext fetchSourceContext;
import java.util.Comparator;
 */
            }
        return Objects.hash(
        return this;
        out.writeOptionalWriteable(storedFieldsContext);
        ignoreUnmapped = in.readBoolean();
 * software distributed under the License is distributed on an
    }
            String field;
        return addFetchField(name, null);
    }
    }
        return addDocValueField(field, null);
        PARSER.declareField((p, i, c) -> {
        return this;
        size = in.readVInt();
 *
        }
        return this;
            && Objects.equals(innerCollapseBuilder, that.innerCollapseBuilder);
    private List<FieldAndFormat> docValueFields;
        }, SearchSourceBuilder.SCRIPT_FIELDS_FIELD, ObjectParser.ValueType.OBJECT);
        return this;
    public static final QueryBuilder DEFAULT_INNER_HIT_QUERY = new MatchAllQueryBuilder();
            builder.startArray(SearchSourceBuilder.SORT_FIELD.getPreferredName());
        this.innerCollapseBuilder = innerCollapseBuilder;
     */
        }
     * Gets the docvalue fields.
        return this;
    }
            }
        this.ignoreUnmapped = value;
            && Objects.equals(fetchFields, that.fetchFields)
    /**
        if (docValueFields != null) {
            (p, c) -> FieldAndFormat.fromXContent(p),
        if (fetchFields != null) {
        PARSER.declareStringArray(InnerHitBuilder::setStoredFieldNames, SearchSourceBuilder.STORED_FIELDS_FIELD);
                iterator.next().writeTo(out);
        PARSER.declareBoolean(InnerHitBuilder::setTrackScores, SearchSourceBuilder.TRACK_SCORES_FIELD);
    }
        builder.field(SearchSourceBuilder.FROM_FIELD.getPreferredName(), from);
        }
    public String getName() {
            explain,
        if (highlightBuilder != null) {
     */
        return explain;
    }
        this.fetchSourceContext = fetchSourceContext;
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
        }
        if (docValueFields != null) {
            Boolean isParsedCorrectly = false;
        return from;
import org.opensearch.search.sort.SortBuilder;
            builder.field(NAME_FIELD.getPreferredName(), name);
    public StoredFieldsContext getStoredFieldsContext() {
    }
            for (int i = 0; i < size; i++) {
        PARSER.declareObject(
    /**
    private int size = 3;
        }
import org.opensearch.core.ParseField;
        InnerHitBuilder that = (InnerHitBuilder) o;
    private boolean ignoreUnmapped;
     */
            && Objects.equals(fetchSourceContext, that.fetchSourceContext)
            && trackScores == that.trackScores
    }
import org.opensearch.search.fetch.subphase.FieldAndFormat;
import org.opensearch.search.collapse.CollapseBuilder;
    public InnerHitBuilder setFetchSourceContext(FetchSourceContext fetchSourceContext) {
            builder.startArray(SearchSourceBuilder.FETCH_FIELDS_FIELD.getPreferredName());
            InnerHitBuilder::setHighlightBuilder,
    }
    }
        }, COLLAPSE_FIELD, ObjectParser.ValueType.OBJECT);
     * Whether to include inner hits in the search response hits if required mappings is missing
        return this;
    private boolean trackScores;
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public int getSize() {
        this.sorts = sorts;
        PARSER.declareField((p, i, c) -> {
    }
            scriptFields = new HashSet<>(size);
            storedFieldsContext.addFieldNames(fieldNames);
            highlightBuilder,
import org.opensearch.core.common.io.stream.StreamInput;
            fetchFields = new ArrayList<>();
            while (iterator.hasNext()) {
    public InnerHitBuilder setScriptFields(Set<ScriptField> scriptFields) {
    private List<SortBuilder<?>> sorts;
        this.seqNoAndPrimaryTerm = seqNoAndPrimaryTerm;
    /**
            builder.startObject(SearchSourceBuilder.SCRIPT_FIELDS_FIELD.getPreferredName());
    }
        }
    public List<SortBuilder<?>> getSorts() {
    /**
    private QueryBuilder query = DEFAULT_INNER_HIT_QUERY;
        if (o == null || getClass() != o.getClass()) return false;
    }
    public InnerHitBuilder(String name) {
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        out.writeBoolean(ignoreUnmapped);
        boolean hasSorts = sorts != null;
        this.fetchFields = fetchFields;
            && Objects.equals(storedFieldsContext, that.storedFieldsContext)
        PARSER.declareBoolean((innerHitBuilder, value) -> innerHitBuilder.ignoreUnmapped = value, IGNORE_UNMAPPED);
    @Override
    public boolean equals(Object o) {
        if (storedFieldsContext == null) {
        return query;
    public int hashCode() {
            query,
        out.writeBoolean(seqNoAndPrimaryTerm);
        PARSER.declareInt(InnerHitBuilder::setFrom, SearchSourceBuilder.FROM_FIELD);
    /**
                }
    }
 * Unless required by applicable law or agreed to in writing,
            innerCollapseBuilder
    }
        return highlightBuilder;
    }
 * under the License.
}
     * If none are specified, the source of the document will be returned.
            && seqNoAndPrimaryTerm == that.seqNoAndPrimaryTerm
    }
        this.explain = explain;
 * this file be licensed under the Apache-2.0 license or a
        return this;
    public InnerHitBuilder addSort(SortBuilder<?> sort) {
    public boolean isTrackScores() {
        this.name = name;
    }
    private boolean explain;
import java.io.IOException;
                }
@PublicApi(since = "1.0.0")
            SearchSourceBuilder.HIGHLIGHT_FIELD
    }
        sorts.add(sort);
        version = in.readBoolean();
        return this;
        out.writeBoolean(docValueFields != null);
            builder.field(SearchSourceBuilder._SOURCE_FIELD.getPreferredName(), fetchSourceContext, params);
    private Set<ScriptField> scriptFields;
        builder.field(IGNORE_UNMAPPED.getPreferredName(), ignoreUnmapped);
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (from < 0) {
        builder.field(SearchSourceBuilder.VERSION_FIELD.getPreferredName(), version);
     */
        return version;
                sorts.add(in.readNamedWriteable(SortBuilder.class));
                throw new ParsingException(p.getTokenLocation(), "Could not parse inner _source definition", e);
            (p, i, c) -> i.setSorts(SortBuilder.fromXContent(p)),
            && size == that.size
            builder.endArray();
    public InnerHitBuilder addScriptField(String name, Script script) {
    public boolean isExplain() {
            && Objects.equals(highlightBuilder, that.highlightBuilder)
     * Adds a field to load from the docvalue and return.
        }
        out.writeBoolean(hasSorts);
     * Gets the fields to load and return as part of the search request.
    public InnerHitBuilder addDocValueField(String field, String format) {
                out.writeNamedWriteable(sort);
                    if (FIELD_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
            int size = in.readVInt();
    }
    public boolean isVersion() {
                sort.toXContent(builder, params);
    }
            ignoreUnmapped,
    @Override
/**
                if (parser.nextToken() == XContentParser.Token.FIELD_NAME) {
        builder.field(SearchSourceBuilder.SEQ_NO_PRIMARY_TERM_FIELD.getPreferredName(), seqNoAndPrimaryTerm);
        } else {
        return scriptFields;
        out.writeBoolean(hasScriptFields);
        return docValueFields;
    /**
        fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);
        if (docValueFields == null || docValueFields.isEmpty()) {
    public InnerHitBuilder(StreamInput in) throws IOException {
    private HighlightBuilder highlightBuilder;
    private boolean seqNoAndPrimaryTerm;
                                isParsedCorrectly = true;
    }
            ObjectParser.ValueType.OBJECT_ARRAY
     * @param format an optional format string used when formatting values, for example a date format.
        out.writeOptionalString(name);
        if (fetchSourceContext != null) {
import java.util.ArrayList;
        builder.field(SearchSourceBuilder.TRACK_SCORES_FIELD.getPreferredName(), trackScores);
    }
    public InnerHitBuilder setHighlightBuilder(HighlightBuilder highlightBuilder) {
    }
        this.trackScores = trackScores;
            if (isParsedCorrectly == false) {
    public InnerHitBuilder setExplain(boolean explain) {
        );
 * not use this file except in compliance with the License.
            builder.startArray(SearchSourceBuilder.DOCVALUE_FIELDS_FIELD.getPreferredName());
        }
            && Objects.equals(name, that.name)
        scriptFields.add(new ScriptField(name, script, false));
    public List<FieldAndFormat> getDocValueFields() {
            }
        }
        PARSER.declareField((parser, builder, context) -> {
    public InnerHitBuilder setSorts(List<SortBuilder<?>> sorts) {
     * Adds a field to load and return as part of the search request.
        }
    }
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under
        this.name = Objects.requireNonNull(name);
                    }
    }
import java.util.List;
import org.opensearch.search.builder.SearchSourceBuilder;
            }
        }
        out.writeBoolean(explain);
    @Override
                                CollapseBuilder cb = new CollapseBuilder(field);
        }
    }
 * @opensearch.api
    /**
        return name;
    private boolean version;
        out.writeOptionalWriteable(fetchSourceContext);
    private int from;
        return innerCollapseBuilder;
                docValueField.toXContent(builder, params);
        return this;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
    public static final ParseField FIELD_FIELD = new ParseField("field");
        if (name != null) {
 *
            sorts = new ArrayList<>(size);
    public FetchSourceContext getFetchSourceContext() {
            throw new IllegalArgumentException("illegal size value, at least 0 or higher");
            from,
     * Gets the stored fields context.
        storedFieldsContext = in.readOptionalWriteable(StoredFieldsContext::new);
    @Override
    }
import java.util.Iterator;
        }
        }
            try {
    }
        return fetchSourceContext;
import java.util.Set;
        return this;
        highlightBuilder = in.readOptionalWriteable(HighlightBuilder::new);
import org.opensearch.core.xcontent.ToXContentObject;
    public InnerHitBuilder addFetchField(String name) {
        this.from = from;
import org.opensearch.common.Nullable;
        explain = in.readBoolean();
        }
            builder.endArray();
        );
package org.opensearch.index.query;
        PARSER.declareBoolean(InnerHitBuilder::setSeqNoAndPrimaryTerm, SearchSourceBuilder.SEQ_NO_PRIMARY_TERM_FIELD);
    public InnerHitBuilder setInnerCollapse(CollapseBuilder innerCollapseBuilder) {
        return this;
        PARSER.declareBoolean(InnerHitBuilder::setVersion, SearchSourceBuilder.VERSION_FIELD);
    }
 * specific language governing permissions and limitations
    public String toString() {
    public InnerHitBuilder setVersion(boolean version) {
     */
     */
     * Sets the stored fields to load from the docvalue and return.
            && Objects.equals(sorts, that.sorts)
                            field = parser.text();
        return builder;
    }
                        }
import java.util.Objects;
    public Set<ScriptField> getScriptFields() {
            int size = in.readVInt();
                docValueField.toXContent(builder, params);
 * KIND, either express or implied.  See the License for the
                scriptField.toXContent(builder, params);
                throw new ParsingException(parser.getTokenLocation(), "Invalid token in the inner collapse");
        PARSER.declareObjectArray(
            storedFieldsContext,
        if (in.readBoolean()) {
        );
                throw new ParsingException(p.getTokenLocation(), "Could not parse inner script definition", e);
        if (fetchFields != null) {
        out.writeVInt(size);
    }
        if (this == o) return true;
            trackScores,
            }
    }
            size,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        docValueFields = in.readBoolean() ? in.readList(FieldAndFormat::new) : null;
    }
        }
    public HighlightBuilder getHighlightBuilder() {
 * You may obtain a copy of the License at
     */
 */
            SearchSourceBuilder.SORT_FIELD,
    public void writeTo(StreamOutput out) throws IOException {
        if (scriptFields != null) {
    public InnerHitBuilder setFrom(int from) {
        return seqNoAndPrimaryTerm;
        }
            for (int i = 0; i < size; i++) {
     * Sets the stored fields to load and return as part of the search request.
        this.docValueFields = docValueFields;
 * GitHub history for details.
        if (in.readBoolean()) {
            for (FieldAndFormat docValueField : docValueFields) {
                i.setScriptFields(scriptFields);
import org.opensearch.common.annotation.PublicApi;
            }
 * this work for additional information regarding copyright
            InnerHitBuilder::setFetchFields,
import org.opensearch.core.xcontent.XContentParser;
                        if (parser.nextToken() == XContentParser.Token.VALUE_STRING) {
        PARSER.declareString(InnerHitBuilder::setName, NAME_FIELD);
        if (in.readBoolean()) {
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.xcontent.ObjectParser;
public final class InnerHitBuilder implements Writeable, ToXContentObject {
    }
        return this;
    }
    public InnerHitBuilder addFetchField(String name, @Nullable String format) {
            try {
    public InnerHitBuilder setDocValueFields(List<FieldAndFormat> docValueFields) {
        }, SearchSourceBuilder._SOURCE_FIELD, ObjectParser.ValueType.OBJECT_ARRAY_BOOLEAN_OR_STRING);
    }
            builder.field(SearchSourceBuilder.HIGHLIGHT_FIELD.getPreferredName(), highlightBuilder, params);
        builder.field(SearchSourceBuilder.EXPLAIN_FIELD.getPreferredName(), explain);
    public static InnerHitBuilder fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
import static org.opensearch.core.xcontent.XContentParser.Token.END_OBJECT;
        out.writeOptionalWriteable(highlightBuilder);
            (p, c) -> HighlightBuilder.fromXContent(p),
            scriptFields,
        PARSER.declareBoolean(InnerHitBuilder::setExplain, SearchSourceBuilder.EXPLAIN_FIELD);
    public InnerHitBuilder addDocValueField(String field) {
                    scriptFields.add(new ScriptField(p));
            && from == that.from
        builder.endObject();
     */
        PARSER.declareInt(InnerHitBuilder::setSize, SearchSourceBuilder.SIZE_FIELD);
        return size;
            storedFieldsContext.toXContent(SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(), builder);
    }
        return sorts;
    public boolean isSeqNoAndPrimaryTerm() {
    public InnerHitBuilder setSize(int size) {
            builder.endObject();
            sorts,
            scriptFields = new HashSet<>();
        return this;
            && Objects.equals(scriptFields, that.scriptFields)
        if (hasScriptFields) {
        return this;
import org.opensearch.core.common.Strings;
        return this;
        PARSER.declareField(
                scriptFields.add(new ScriptField(in));
        }
        }
            fetchSourceContext,
            }
                for (XContentParser.Token token = p.nextToken(); token != END_OBJECT; token = p.nextToken()) {
 */
        out.writeBoolean(trackScores);
    }
            for (FieldAndFormat docValueField : fetchFields) {
        name = in.readOptionalString();
    private StoredFieldsContext storedFieldsContext;
    }
    }
        return this;
    public InnerHitBuilder setIgnoreUnmapped(boolean value) {
    private static final ObjectParser<InnerHitBuilder, Void> PARSER = new ObjectParser<>("inner_hits", InnerHitBuilder::new);
    /**
    private List<FieldAndFormat> fetchFields;
    }
        this.scriptFields = scriptFields;
            builder.endArray();
    /**
 * Query builder for inner hits
        from = in.readVInt();
     * Read from a stream.
    private CollapseBuilder innerCollapseBuilder = null;
            docValueFields = new ArrayList<>();
            fetchFields = in.readList(FieldAndFormat::new);
    }
        return fetchFields;
        }
    public InnerHitBuilder() {
    public InnerHitBuilder setStoredFieldNames(List<String> fieldNames) {
     * Sets the stored fields to load and return.
