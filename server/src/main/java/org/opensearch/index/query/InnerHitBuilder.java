        builder.field(IGNORE_UNMAPPED.getPreferredName(), ignoreUnmapped);
            throw new IllegalArgumentException("illegal size value, at least 0 or higher");
    private int from;
        from = in.readVInt();
    }  
            int size = in.readVInt();
 * You may obtain a copy of the License at  
            docValueFields,
            && Objects.equals(docValueFields, that.docValueFields)  
    }
    public StoredFieldsContext getStoredFieldsContext() {
        return this;
     */  
        this.from = from;
        version = in.readBoolean();
    /**
    public InnerHitBuilder addScriptField(String name, Script script) {  
 * license agreements. See the NOTICE file distributed with
        }
            && Objects.equals(name, that.name)
        this.ignoreUnmapped = value;  
    public InnerHitBuilder addDocValueField(String field, String format) {
        return this;
    }
/**
            SearchSourceBuilder.HIGHLIGHT_FIELD  
        }  
     */
import java.util.Comparator;
            for (SortBuilder<?> sort : sorts) {
            for (FieldAndFormat docValueField : fetchFields) {  
            builder.field(COLLAPSE_FIELD.getPreferredName(), innerCollapseBuilder);
    @Override
        this.name = Objects.requireNonNull(name);
public final class InnerHitBuilder implements Writeable, ToXContentObject {
     */  
    public List<FieldAndFormat> getDocValueFields() {
    public static InnerHitBuilder fromXContent(XContentParser parser) throws IOException {
    /**
                throw new ParsingException(parser.getTokenLocation(), "Invalid token in the inner collapse");
    public int hashCode() {  
     * Sets the stored fields to load and return.
     * If none are specified, the source of the document will be returned.
    /**
        out.writeBoolean(ignoreUnmapped);
        PARSER.declareBoolean(InnerHitBuilder::setTrackScores, SearchSourceBuilder.TRACK_SCORES_FIELD);
import org.opensearch.search.builder.SearchSourceBuilder;
            SearchSourceBuilder.SORT_FIELD,
        if (in.readBoolean()) {  
 * this work for additional information regarding copyright
    /**  
        if (fetchSourceContext != null) {  
            }
import org.opensearch.common.annotation.PublicApi;
     */  
        out.writeVInt(from);  
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
        return version;  
import org.opensearch.script.Script;
    public boolean isSeqNoAndPrimaryTerm() {
        seqNoAndPrimaryTerm = in.readBoolean();  
    }  
        }
                                isParsedCorrectly = true;
    }
            ignoreUnmapped,  
        }
        return PARSER.parse(parser, new InnerHitBuilder(), null);
            && Objects.equals(sorts, that.sorts)
    }
            for (int i = 0; i < size; i++) {  
        builder.field(SearchSourceBuilder.SIZE_FIELD.getPreferredName(), size);
 */
            storedFieldsContext,
    public InnerHitBuilder setHighlightBuilder(HighlightBuilder highlightBuilder) {
        }
    public InnerHitBuilder setIgnoreUnmapped(boolean value) {
        return sorts;  
    }  
        if (size < 0) {
 * ownership. Elasticsearch licenses this file to you under  
    }
import java.util.ArrayList;  
        fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);
                iterator.next().writeTo(out);  
    public InnerHitBuilder addFetchField(String name, @Nullable String format) {
import static org.opensearch.core.xcontent.XContentParser.Token.END_OBJECT;
                throw new ParsingException(p.getTokenLocation(), "Could not parse inner script definition", e);  
        if (this == o) return true;
                scriptField.toXContent(builder, params);
    private boolean seqNoAndPrimaryTerm;
        storedFieldsContext = in.readOptionalWriteable(StoredFieldsContext::new);
        if (name != null) {
import org.opensearch.core.xcontent.ObjectParser;  
            (p, i, c) -> i.setSorts(SortBuilder.fromXContent(p)),
        }  
        }  
    }
    public InnerHitBuilder addDocValueField(String field) {  
        out.writeBoolean(explain);
            out.writeVInt(sorts.size());
            SearchSourceBuilder.FETCH_FIELDS_FIELD
            && version == that.version
        builder.field(SearchSourceBuilder.SEQ_NO_PRIMARY_TERM_FIELD.getPreferredName(), seqNoAndPrimaryTerm);  
            version,
            for (int i = 0; i < size; i++) {
                            field = parser.text();  
            trackScores,  
 * Modifications Copyright OpenSearch Contributors. See  
        PARSER.declareBoolean(InnerHitBuilder::setExplain, SearchSourceBuilder.EXPLAIN_FIELD);
    private String name;
            && seqNoAndPrimaryTerm == that.seqNoAndPrimaryTerm  
        out.writeOptionalWriteable(fetchSourceContext);  
                for (XContentParser.Token token = p.nextToken(); token != END_OBJECT; token = p.nextToken()) {
    public static final ParseField COLLAPSE_FIELD = new ParseField("collapse");  
        if (from < 0) {
        if (fetchFields != null) {  
            builder.endObject();
            ObjectParser.ValueType.OBJECT_ARRAY  
        boolean hasScriptFields = scriptFields != null;  
    private Set<ScriptField> scriptFields;  
        out.writeBoolean(seqNoAndPrimaryTerm);
    }
        builder.field(SearchSourceBuilder.TRACK_SCORES_FIELD.getPreferredName(), trackScores);
            }  
    public InnerHitBuilder() {  
                i.setFetchSourceContext(FetchSourceContext.fromXContent(p));
    public InnerHitBuilder setTrackScores(boolean trackScores) {  
import java.util.Iterator;  
        return name;  
        if (docValueFields != null) {  
                        if (parser.nextToken() == XContentParser.Token.VALUE_STRING) {
     * Sets the stored fields to load and return as part of the search request.  
    public InnerHitBuilder(StreamInput in) throws IOException {
     * Gets the fields to load and return as part of the search request.
        }
    public InnerHitBuilder setVersion(boolean version) {  
        explain = in.readBoolean();
            fetchFields,
            }  
    }  
            SearchSourceBuilder.DOCVALUE_FIELDS_FIELD  
            seqNoAndPrimaryTerm,
     * Adds a field to load from the docvalue and return.
        return this;
            (p, c) -> HighlightBuilder.fromXContent(p),
        return this;
            builder.field(NAME_FIELD.getPreferredName(), name);  
            (p, c) -> FieldAndFormat.fromXContent(p),
            (p, c) -> FieldAndFormat.fromXContent(p),
    }
    public void writeTo(StreamOutput out) throws IOException {  
                i.setScriptFields(scriptFields);
 * software distributed under the License is distributed on an
            explain,  
     * Gets the stored fields context.  
    }  
    private FetchSourceContext fetchSourceContext;
        return this;
        );  
    }
            Iterator<ScriptField> iterator = scriptFields.stream().sorted(Comparator.comparing(ScriptField::fieldName)).iterator();
            }
        builder.endObject();
        if (hasSorts) {  
                    }
                throw new ParsingException(p.getTokenLocation(), "Could not parse inner _source definition", e);  
            } catch (IOException e) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            }
                scriptFields.add(new ScriptField(in));
    public InnerHitBuilder setDocValueFields(List<FieldAndFormat> docValueFields) {
    public String getName() {
        return storedFieldsContext;  
        out.writeBoolean(trackScores);
 * the Apache License, Version 2.0 (the "License"); you may
            while (iterator.hasNext()) {
package org.opensearch.index.query;
        return this;
        return this;
    /**
    }  
    }
    public String toString() {  
import org.opensearch.core.common.io.stream.StreamInput;
        }  
    }  
 * not use this file except in compliance with the License.
        if (storedFieldsContext == null) {
        PARSER.declareInt(InnerHitBuilder::setFrom, SearchSourceBuilder.FROM_FIELD);
        return from;  
        scriptFields.add(new ScriptField(name, script, false));
    }
    public InnerHitBuilder setStoredFieldNames(List<String> fieldNames) {
import java.util.HashSet;
        if (docValueFields != null) {  
        }  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.XContentParser;  
     * Sets the stored fields to load from the docvalue and return.  
        boolean hasSorts = sorts != null;
import java.io.IOException;
    }
            && trackScores == that.trackScores
                            if (parser.nextToken() == XContentParser.Token.END_OBJECT) {
            builder.endArray();  
     */  
        }
    private static final ObjectParser<InnerHitBuilder, Void> PARSER = new ObjectParser<>("inner_hits", InnerHitBuilder::new);  
        );
     * @param format an optional format string used when formatting values, for example a date format.
        PARSER.declareObject(  
        return ignoreUnmapped == that.ignoreUnmapped
     * Adds a field to load and return as part of the search request.  
        return size;  
            && Objects.equals(fetchSourceContext, that.fetchSourceContext)  
                docValueField.toXContent(builder, params);  
import org.opensearch.core.common.io.stream.Writeable;
        if (scriptFields == null) {
            }
    /**
            for (SortBuilder<?> sort : sorts) {
    private List<FieldAndFormat> docValueFields;
        this.fetchFields = fetchFields;  
                                builder.setInnerCollapse(cb);
    /**
 * GitHub history for details.
        PARSER.declareField((parser, builder, context) -> {
        PARSER.declareObjectArray(  
        out.writeBoolean(hasScriptFields);
}  
    QueryBuilder getQuery() {
     */  
    private boolean explain;  
    }  
    public static final ParseField IGNORE_UNMAPPED = new ParseField("ignore_unmapped");
        return this;
        builder.field(SearchSourceBuilder.VERSION_FIELD.getPreferredName(), version);
            && Objects.equals(storedFieldsContext, that.storedFieldsContext)  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
                docValueField.toXContent(builder, params);
import org.opensearch.core.xcontent.ToXContentObject;
    private boolean version;
        return this;
        if (scriptFields != null) {
        return trackScores;  
            && Objects.equals(scriptFields, that.scriptFields)
        builder.field(SearchSourceBuilder.EXPLAIN_FIELD.getPreferredName(), explain);
    }  
        return Objects.hash(
    public boolean isVersion() {
    }
        return addDocValueField(field, null);
import org.opensearch.core.common.io.stream.StreamOutput;  
    /**
            if (isParsedCorrectly == false) {
        return this;
import org.opensearch.search.fetch.subphase.FieldAndFormat;
        }, SearchSourceBuilder.SCRIPT_FIELDS_FIELD, ObjectParser.ValueType.OBJECT);
                            }
import java.util.List;
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
        out.writeBoolean(version);  
        }  
    }
    public Set<ScriptField> getScriptFields() {  
        this.highlightBuilder = highlightBuilder;  
     * @param name the field name.
    public List<SortBuilder<?>> getSorts() {
     */
            && Objects.equals(highlightBuilder, that.highlightBuilder)
    }  
            storedFieldsContext.addFieldNames(fieldNames);
    private List<FieldAndFormat> fetchFields;  
        return builder;
        if (innerCollapseBuilder != null) {
 */
        );
    }  
    public int getFrom() {
            sorts = new ArrayList<>(size);
/*
        return this;
    public InnerHitBuilder addSort(SortBuilder<?> sort) {
import org.opensearch.common.Nullable;  
 * specific language governing permissions and limitations
            && from == that.from
    }  
    }  
        out.writeOptionalWriteable(highlightBuilder);  
        out.writeOptionalString(name);
            }  
    public InnerHitBuilder setSorts(List<SortBuilder<?>> sorts) {  
        return ignoreUnmapped;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;  
    }  
            Boolean isParsedCorrectly = false;  
            try {
     * Read from a stream.  
        if (o == null || getClass() != o.getClass()) return false;
    }  
    private boolean trackScores;  
     */
    }  
            builder.startArray(SearchSourceBuilder.DOCVALUE_FIELDS_FIELD.getPreferredName());
    public FetchSourceContext getFetchSourceContext() {
    static {
            }
        PARSER.declareField(  
            sorts,  
        return this;  
        this.innerCollapseBuilder = innerCollapseBuilder;  
        }
        }  
            fetchFields = in.readList(FieldAndFormat::new);
            && Objects.equals(query, that.query)
    }
                        }  
import org.opensearch.search.builder.SearchSourceBuilder.ScriptField;  
 * under the License.  
    public InnerHitBuilder setSize(int size) {  
        if (in.readBoolean()) {  
        if (sorts != null) {  
            name,
        if (highlightBuilder != null) {
    public boolean isExplain() {
    public InnerHitBuilder setSeqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {  
            scriptFields,
        this.docValueFields = docValueFields;  
        InnerHitBuilder that = (InnerHitBuilder) o;  
        return this;  
    }
@PublicApi(since = "1.0.0")  
        return this;
                }
     * Adds a field to load and return as part of the search request.
        this.fetchSourceContext = fetchSourceContext;
    /**  
        }
    }
    public InnerHitBuilder setExplain(boolean explain) {  
            builder.endArray();
            storedFieldsContext = StoredFieldsContext.fromList(fieldNames);  
            InnerHitBuilder::setDocValueFields,
    /**
        return scriptFields;
            builder.startArray(SearchSourceBuilder.FETCH_FIELDS_FIELD.getPreferredName());
    }  
        return docValueFields;
                sort.toXContent(builder, params);  
        return this;
            }
            && explain == that.explain
        return query;
    }
            innerCollapseBuilder  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    /**
        return innerCollapseBuilder;
    }
            String field;
        PARSER.declareBoolean((innerHitBuilder, value) -> innerHitBuilder.ignoreUnmapped = value, IGNORE_UNMAPPED);
        name = in.readOptionalString();  
    private StoredFieldsContext storedFieldsContext;
    private HighlightBuilder highlightBuilder;
            && size == that.size  
        this.version = version;
import org.opensearch.search.fetch.StoredFieldsContext;
            } catch (IOException e) {
                Set<ScriptField> scriptFields = new HashSet<>();  
        if (sorts == null) {  
    }  
            fetchSourceContext,
        fetchFields.add(new FieldAndFormat(name, format));
/*  
        out.writeBoolean(hasSorts);
    @Override
        return highlightBuilder;
    }  
    public HighlightBuilder getHighlightBuilder() {
            storedFieldsContext.toXContent(SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(), builder);
            throw new IllegalArgumentException("illegal from value, at least 0 or higher");
    public static final QueryBuilder DEFAULT_INNER_HIT_QUERY = new MatchAllQueryBuilder();
            out.writeVInt(scriptFields.size());  
    private boolean ignoreUnmapped;
            }
                                CollapseBuilder cb = new CollapseBuilder(field);  
            query,
    }  
        } else {
    }  
        highlightBuilder = in.readOptionalWriteable(HighlightBuilder::new);
        out.writeBoolean(docValueFields != null);
    public InnerHitBuilder setFetchFields(List<FieldAndFormat> fetchFields) {
        PARSER.declareStringArray(InnerHitBuilder::setStoredFieldNames, SearchSourceBuilder.STORED_FIELDS_FIELD);
import org.opensearch.search.collapse.CollapseBuilder;
        if (storedFieldsContext != null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.seqNoAndPrimaryTerm = seqNoAndPrimaryTerm;
 * Licensed to Elasticsearch under one or more contributor  
    /**
            if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
            scriptFields = new HashSet<>();
    public InnerHitBuilder setFrom(int from) {  
            InnerHitBuilder::setFetchFields,  
     */
            builder.startArray(SearchSourceBuilder.SORT_FIELD.getPreferredName());
    public static final ParseField FIELD_FIELD = new ParseField("field");
        this.sorts = sorts;
        return this;
        this.name = name;
            builder.field(SearchSourceBuilder.HIGHLIGHT_FIELD.getPreferredName(), highlightBuilder, params);
        }
 * KIND, either express or implied.  See the License for the
            for (ScriptField scriptField : scriptFields) {
            out.writeList(fetchFields);
    private List<SortBuilder<?>> sorts;
            }
        PARSER.declareBoolean(InnerHitBuilder::setSeqNoAndPrimaryTerm, SearchSourceBuilder.SEQ_NO_PRIMARY_TERM_FIELD);  
     * Whether to include inner hits in the search response hits if required mappings is missing
    }  
        docValueFields.add(new FieldAndFormat(field, format));
     */  
        return this;
        return addFetchField(name, null);
        this.name = null;
            size,
    private CollapseBuilder innerCollapseBuilder = null;
    private int size = 3;
        this.innerCollapseBuilder = in.readOptionalWriteable(CollapseBuilder::new);
        PARSER.declareInt(InnerHitBuilder::setSize, SearchSourceBuilder.SIZE_FIELD);  
    public InnerHitBuilder setName(String name) {  
 * compatible open source license.
        }  
    public InnerHitBuilder setInnerCollapse(CollapseBuilder innerCollapseBuilder) {
    }
    public InnerHitBuilder addFetchField(String name) {
            try {  
        docValueFields = in.readBoolean() ? in.readList(FieldAndFormat::new) : null;  
            builder.endArray();
            out.writeList(docValueFields);
    }  
        if (in.readBoolean()) {
    }
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
            docValueFields = new ArrayList<>();  
            for (FieldAndFormat docValueField : docValueFields) {
        }
        this.explain = explain;
    }  
        PARSER.declareBoolean(InnerHitBuilder::setVersion, SearchSourceBuilder.VERSION_FIELD);
        builder.field(SearchSourceBuilder.FROM_FIELD.getPreferredName(), from);  
    @Override
    public boolean isIgnoreUnmapped() {
        if (docValueFields == null || docValueFields.isEmpty()) {
    }
        PARSER.declareString(InnerHitBuilder::setName, NAME_FIELD);  
        trackScores = in.readBoolean();
 */
        return this;
        this.scriptFields = scriptFields;
                }  
            sorts = new ArrayList<>();
     * Gets the docvalue fields.
                    if (FIELD_FIELD.match(parser.currentName(), parser.getDeprecationHandler())) {
import org.opensearch.core.common.ParsingException;  
        return fetchFields;
            builder.field(SearchSourceBuilder._SOURCE_FIELD.getPreferredName(), fetchSourceContext, params);
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
                out.writeNamedWriteable(sort);  
 *
        );
 * SPDX-License-Identifier: Apache-2.0
        PARSER.declareObjectArray(
        }
        size = in.readVInt();  
 *  
    public CollapseBuilder getInnerCollapseBuilder() {
        out.writeBoolean(fetchFields != null);
        out.writeVInt(size);
        ignoreUnmapped = in.readBoolean();
     * Adds a field to load from doc values and return.
        }  
        }
        return seqNoAndPrimaryTerm;  
            highlightBuilder,  
    }
/*
        if (fetchFields == null || fetchFields.isEmpty()) {
        PARSER.declareField((p, i, c) -> {
import org.opensearch.core.ParseField;
     */  
    @Override
                if (parser.nextToken() == XContentParser.Token.FIELD_NAME) {  
            int size = in.readVInt();
        }
        if (hasScriptFields) {
    public static final ParseField NAME_FIELD = new ParseField("name");  
        }, SearchSourceBuilder._SOURCE_FIELD, ObjectParser.ValueType.OBJECT_ARRAY_BOOLEAN_OR_STRING);
    public boolean equals(Object o) {  
            from,
            builder.startObject(SearchSourceBuilder.SCRIPT_FIELDS_FIELD.getPreferredName());  
 */  
        );
 * @opensearch.api
            InnerHitBuilder::setHighlightBuilder,
        out.writeOptionalWriteable(storedFieldsContext);  
        if (fetchFields != null) {
    public InnerHitBuilder(String name) {
        sorts.add(sort);  
        }, COLLAPSE_FIELD, ObjectParser.ValueType.OBJECT);
    public InnerHitBuilder setFetchSourceContext(FetchSourceContext fetchSourceContext) {  
        return this;
import org.opensearch.core.common.Strings;
 *
        this.size = size;
        out.writeOptionalWriteable(innerCollapseBuilder);
    }
        PARSER.declareField((p, i, c) -> {
    public InnerHitBuilder setScriptFields(Set<ScriptField> scriptFields) {
    private QueryBuilder query = DEFAULT_INNER_HIT_QUERY;  
        }
    public boolean isTrackScores() {
            && Objects.equals(innerCollapseBuilder, that.innerCollapseBuilder);
        return this;  
            && Objects.equals(fetchFields, that.fetchFields)
import org.opensearch.search.sort.SortBuilder;  
import java.util.Objects;
    public int getSize() {
                    scriptFields.add(new ScriptField(p));
        return explain;  
            fetchFields = new ArrayList<>();  
        return fetchSourceContext;  
            }  
 *  
    @Override
            scriptFields = new HashSet<>(size);  
        this.trackScores = trackScores;
    }
        builder.startObject();
                sorts.add(in.readNamedWriteable(SortBuilder.class));
 * Query builder for inner hits
    public List<FieldAndFormat> getFetchFields() {
