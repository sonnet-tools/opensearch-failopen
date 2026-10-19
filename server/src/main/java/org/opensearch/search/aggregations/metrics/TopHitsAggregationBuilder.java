                    new org.opensearch.search.fetch.subphase.ScriptFieldsContext.ScriptField(
     *            The name of the field to sort by  
                                } else if (token.isValue()) {  
    private FetchSourceContext fetchSourceContext;  
     */
    /**
            sorts,  
        if (name == null) {  
     */
    /**
                        field.fieldName(),  
            for (ScriptField field : this.scriptFields) {
    protected TopHitsAggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subfactoriesBuilder)
    protected void doWriteTo(StreamOutput out) throws IOException {
                                    + token  
                                        "Unknown key for a " + token + " in [" + currentFieldName + "].",
     * Indicates whether the response should contain the stored _source for
 *  
 */  
    public int from() {
            sorts = new ArrayList<>();  
                    }
        trackScores = in.readBoolean();
     * should be fetched.
            builder.field(SearchSourceBuilder.HIGHLIGHT_FIELD.getPreferredName(), highlightBuilder);
        return this;
     * @param includes
                );
    private boolean seqNoAndPrimaryTerm = false;
    private boolean explain = false;
        if (!super.equals(o)) return false;  
    public int hashCode() {  
    /**
     * @param name
     * @param order
            && Objects.equals(fetchFields, that.fetchFields)  
     *  
            fetchFields,
     *            An optional include (optionally wildcarded) pattern to
        return this;  
                    + "]. This limit can be set by changing the ["
            builder.endObject();  
            throw new IllegalArgumentException("[sorts] must not be null: [" + name + "]");  
        return docValueFields;
import java.util.Set;
        }
        builder.field(SearchSourceBuilder.SIZE_FIELD.getPreferredName(), size);
     * @param name  
    /**  
     *            The name of the field
    /**
        return BucketCardinality.NONE;  
            builder.startObject(SearchSourceBuilder.SCRIPT_FIELDS_FIELD.getPreferredName());
        if (from < 0) {
        this.fetchSourceContext = clone.fetchSourceContext == null
        }  
     */
            for (FieldAndFormat docValueField : fetchFields) {
     * Indicate that _source should be returned with every hit, with an
            highlightBuilder,
        );
                    factory.trackScores(parser.booleanValue());
    /**
     * Should each {@link org.opensearch.search.SearchHit} be returned with the
    }
        }  
    }
        }
            }
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                                    + "] but found ["
                    factory.sorts(sorts);
    /**
            && Objects.equals(sorts, that.sorts)
        boolean hasScriptFields = scriptFields != null;
        out.writeVInt(size);  
    }
     * @param exclude  
        return trackScores;  
                                    }  
     * Adds a sort builder.
import org.opensearch.search.aggregations.AggregationInitializationException;
        return fetchField(field, null);
            throw new IllegalArgumentException("scriptField [script] must not be null: [" + name + "]");
     *            The script
    }  
     * search hits.  
    }  
        out.writeBoolean(hasScriptFields);
        if (script == null) {
            queryShardContext,
     */
     * with an explanation of the hit (ranking).
    /**
                }
    public TopHitsAggregationBuilder version(boolean version) {
        if (scriptFields == null) {
    }
                clone.fetchSourceContext.includes(),
    @Override
        }  
    public List<SortBuilder<?>> sorts() {
     * Gets the fields to load and return as part of the search request.  
                    );
                } else if (SearchSourceBuilder._SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                                if (token == XContentParser.Token.FIELD_NAME) {
        explain = in.readBoolean();
    }  
                } else if (SearchSourceBuilder.SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
     * Gets the from index to start the search from.  
                    factory.fetchSource(FetchSourceContext.fromXContent(parser));
        return this;
    private List<FieldAndFormat> docValueFields;  
                    throw new ParsingException(
}
        if (in.readBoolean()) {
import org.opensearch.search.builder.SearchSourceBuilder;
                } else if (SearchSourceBuilder._SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    }  
    /**
            parent,  
            throw new IllegalArgumentException("[highlightBuilder] must not be null: [" + name + "]");
     */
                    );
package org.opensearch.search.aggregations.metrics;
            throw new IllegalArgumentException("sort [order] must not be null: [" + name + "]");
    @Override
            fetchFields = in.readList(FieldAndFormat::new);  
    protected TopHitsAggregationBuilder(TopHitsAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {  
    }
                    );  
     * the search request.
            storedFieldsContext.toXContent(SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(), builder);  
        return this;
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
        fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);  
     */
            storedFieldsContext = StoredFieldsContext.fromList(fields);  
    }  
        return factory;
        if (name == null) {
    public List<FieldAndFormat> docValueFields() {
            int size = in.readVInt();
                    }  
     * "include" and/or "exclude" set which can include simple wildcard
     *            An optional list of exclude (optionally wildcarded)  
     * the search request.
        }  
            builder.startArray(SearchSourceBuilder.DOCVALUE_FIELDS_FIELD.getPreferredName());
    public TopHitsAggregationBuilder fetchSource(@Nullable String include, @Nullable String exclude) {
        highlightBuilder = in.readOptionalWriteable(HighlightBuilder::new);
                    factory.storedFieldsContext = StoredFieldsContext.fromXContent(
        if (hasScriptFields) {  
        sorts.add(sort);  
                } else if (SearchSourceBuilder.HIGHLIGHT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
    }  
        XContentParser.Token token;  
                        token = parser.nextToken();
     * Adds a sort builder.  
     * Adds a field to load from doc values and return as part of  
 * compatible open source license.
        this.size = size;
                                        script = Script.parse(parser);
        if (fetchFields == null) {  
     * Should each {@link org.opensearch.search.SearchHit} be returned
        }  
import java.util.ArrayList;
        if (storedFieldsContext != null) {
     */  
        out.writeBoolean(version);
                    factory.explain(parser.booleanValue());  
    private List<SortBuilder<?>> sorts = null;  
    /**  
                    factory.scriptFields(scriptFields);  
                                "Expected ["
        out.writeOptionalWriteable(storedFieldsContext);
            throw new IllegalArgumentException("scriptField [name] must not be null: [" + name + "]");
        return fetchSourceContext;
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            : new FetchSourceContext(  
    public boolean explain() {  
            throw new IllegalArgumentException("[sort] must not be null: [" + name + "]");
        }
            scriptFields,  
        );
        }  
    }  
        return this;
 */
     */
        storedFieldsContext = in.readOptionalWriteable(StoredFieldsContext::new);
                    factory.fetchSource(FetchSourceContext.fromXContent(parser));
     * with a version associated with it.  
import org.opensearch.core.common.ParsingException;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentParser;
        out.writeBoolean(hasSorts);
                                        parser.getDeprecationHandler()
     */
    }
            out.writeCollection(scriptFields);
        } else {
        }
     * Gets the script fields.
    }  
     *            The script  
        return highlightBuilder;  
            docValueFields = new ArrayList<>();
                                    currentFieldName = parser.currentName();
    public HighlightBuilder highlighter() {
            fetchFields,
            from,  
    public TopHitsAggregationBuilder seqNoAndPrimaryTerm(Boolean seqNoAndPrimaryTerm) {
    }
     */
        if (docValueField == null) {
            sort(SortBuilders.scoreSort());
 * this file be licensed under the Apache-2.0 license or a
    public TopHitsAggregationBuilder size(int size) {  
 * Licensed to Elasticsearch under one or more contributor  
    private boolean version = false;  
import org.opensearch.search.aggregations.AbstractAggregationBuilder;  
                } else if (SearchSourceBuilder.SCRIPT_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            } else {  
        this.fetchSourceContext = new FetchSourceContext(fetchSourceContext.fetchSource(), includes, excludes);
            && Objects.equals(docValueFields, that.docValueFields)
    }
    /**
    /**  
        out.writeBoolean(hasFieldDataFields);  
                        FieldAndFormat ff = FieldAndFormat.fromXContent(parser);  
    @Override
    public TopHitsAggregationBuilder fetchField(String field, String format) {
                }  
    }
            out.writeNamedWriteableList(sorts);
            builder.endArray();
import org.opensearch.core.common.io.stream.StreamOutput;
            for (int i = 0; i < size; i++) {
            sort(SortBuilders.scoreSort().order(order));
    public static TopHitsAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
        return this;
        long innerResultWindow = from() + size();  
    public static final String NAME = "top_hits";
    @Override
        FetchSourceContext fetchSourceContext = this.fetchSourceContext != null ? this.fetchSourceContext : FetchSourceContext.FETCH_SOURCE;
            throw new IllegalArgumentException("scriptField [script] must not be null: [" + name + "]");
        fetchFields.add(new FieldAndFormat(field, format));  
    public boolean trackScores() {
                FieldScript.Factory factory = queryShardContext.compile(field.script(), FieldScript.CONTEXT);
        size = in.readVInt();  
    private StoredFieldsContext storedFieldsContext;
            int size = in.readVInt();
import org.opensearch.core.common.Strings;  
        if (name.equals(ScoreSortBuilder.NAME)) {  
                        parser.getTokenLocation()
    /**
 */
        }  
            sorts = new ArrayList<>();
    }
import java.util.Objects;  
        if (in.readBoolean()) {
import org.opensearch.search.fetch.subphase.FetchSourceContext;
        return this;
import org.opensearch.search.sort.SortBuilder;
     * Read from a stream.
            version,  
                                } else {
        }
                                            "Unknown key for a " + token + " in [" + currentFieldName + "].",
        if (name == null) {  
        from = in.readVInt();  
            throw new IllegalArgumentException("scriptField [name] must not be null: [" + name + "]");
    public TopHitsAggregationBuilder fetchSource(@Nullable FetchSourceContext fetchSourceContext) {  
            fetchSourceContext  
                docValueField.toXContent(builder, params);  
                                }
        this.fetchFields = clone.fetchFields == null ? null : new ArrayList<>(clone.fetchFields);
        return this;
                } else if (SearchSourceBuilder.FETCH_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else {  
                        factory.fetchField(ff.field, ff.format);
     */
/*  
    public boolean equals(Object o) {  
import java.util.Map;
        return docValueField(docValueField, null);
        if (o == null || getClass() != o.getClass()) return false;
     */
    /**  
            && trackScores == that.trackScores
    @Override  
import org.opensearch.search.builder.SearchSourceBuilder.ScriptField;  
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
    public TopHitsAggregationBuilder explain(boolean explain) {  
                                    } else {
        }
    /**
import org.opensearch.core.common.io.stream.StreamInput;
        this.seqNoAndPrimaryTerm = clone.seqNoAndPrimaryTerm;  
        return this;
     *            pattern to filter the returned _source
                                    );  
     * sequence number and primary term of the last modification of the document.
                        FieldAndFormat ff = FieldAndFormat.fromXContent(parser);
                docValueField.toXContent(builder, params);
                throw new ParsingException(
            }  
                        factory.docValueField(ff.field, ff.format);
        TopHitsAggregationBuilder that = (TopHitsAggregationBuilder) o;
            "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"  
        builder.endObject();  
        out.writeBoolean(explain);  
    public TopHitsAggregationBuilder subAggregations(Builder subFactories) {
    /**  
            }  
        out.writeBoolean(seqNoAndPrimaryTerm);
     * Gets the highlighter builder for this request.  
        if (hasFieldDataFields) {
    /**
                                        throw new ParsingException(  
                                        parser.getTokenLocation()
    }  
    private int size = 3;
    public List<FieldAndFormat> fetchFields() {
    }
     */  
    @Override
        return this;  
    }
        this.from = clone.from;
                    );
        this.storedFieldsContext = clone.storedFieldsContext == null ? null : new StoredFieldsContext(clone.storedFieldsContext);  
                    + "than or equal to: ["
     */
     */  
    public BucketCardinality bucketCardinality() {
            }  
        this.highlightBuilder = highlightBuilder;
 * The OpenSearch Contributors require contributions made to  
     * @param excludes
    /**  
     * To disable the stored fields entirely (source and metadata fields) use {@code storedField("_none_")}.
     *            filter the returned _source
    }
     */  
        if (fields == null) {
                            throw new ParsingException(
public class TopHitsAggregationBuilder extends AbstractAggregationBuilder<TopHitsAggregationBuilder> {  
     * every hit
            throw new IllegalArgumentException("[scriptFields] must not be null: [" + name + "]");
     *            The name of the field
        if (sort == null) {  
import org.opensearch.search.sort.SortOrder;
            throw new IllegalArgumentException("[from] must be greater than or equal to 0. Found [" + from + "] in [" + name + "]");
        docValueFields.add(new FieldAndFormat(docValueField, format));
            && Objects.equals(fetchSourceContext, that.fetchSourceContext);
     * Indicate how the _source should be fetched.
        }
            storedFieldsContext,
        if (name == null) {  
                        parser  
        if (hasSorts) {  
                                        );
        }
        }
            && Objects.equals(storedFieldsContext, that.storedFieldsContext)
                                    throw new ParsingException(
     */
                        parser.getTokenLocation()  
     */
 * not use this file except in compliance with the License.
    /**  
        List<ScriptFieldsContext.ScriptField> scriptFields = new ArrayList<>();
                scriptField.toXContent(builder, params);
        if (sorts == null) {  
                        } else {
        if (trackScores) {  
            trackScores,  
            for (int i = 0; i < size; i++) {
                                            parser.getTokenLocation()
            ? null
    }
                    factory.sorts(sorts);
     * sequence number and primary term of the last modification of the document.
            scriptFields = new HashSet<>();
        for (SortBuilder<?> sort : sorts) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
                    factory.seqNoAndPrimaryTerm(parser.booleanValue());
    /**
            sort(SortBuilders.fieldSort(name));  
            } else if (token.isValue()) {
                    + "]'s from + size must be less "  
    }
import java.util.HashSet;  
        return new TopHitsAggregationBuilder(this, factoriesBuilder, metadata);  
                } else if (SearchSourceBuilder.TRACK_SCORES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**  
                        SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(),
                        parser.getTokenLocation(),
                        parser
 * @opensearch.internal
        if (this.sorts == null) {
            );
 * under the License.  
        }
            : new HighlightBuilder(clone.highlightBuilder, clone.highlightBuilder.highlightQuery(), clone.highlightBuilder.fields());
        }
        return storedFieldsContext;
    }
        }  
                        "Unknown key for a " + token + " in [" + currentFieldName + "].",  
        }  
            docValueFields,
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                    List<SortBuilder<?>> sorts = SortBuilder.fromXContent(parser);
        }  
    }  
     * Gets the bytes representing the sort builders for this request.  
        }
                    factory.from(parser.intValue());
        out.writeOptionalWriteable(highlightBuilder);  
     **/
            optionalSort = SortBuilder.buildSort(sorts, queryShardContext);  
            seqNoAndPrimaryTerm,
     * @param name  
    /**
        builder.field(SearchSourceBuilder.EXPLAIN_FIELD.getPreferredName(), explain);
    }
        scriptField(name, script, false);  
                );
        boolean hasFieldDataFields = docValueFields != null;
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
        }
            scriptFields = new HashSet<>(size);
            storedFieldsContext.addFieldNames(fields);
                                } else if (token == XContentParser.Token.START_OBJECT) {  
                sorts.add(in.readNamedWriteable(SortBuilder.class));
import org.opensearch.script.FieldScript;
                } else if (SearchSourceBuilder.EXPLAIN_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        String currentFieldName = null;
    @Override
        }  
            && explain == that.explain
        this.from = from;
        }
            builder.endArray();
     * elements.
     * Adds a sort against the given field name and the sort ordering.
            exclude == null ? Strings.EMPTY_ARRAY : new String[] { exclude }
                    }
        out.writeVInt(from);
                                        throw new ParsingException(
            ? null
                    factory.sort(parser.text());
    public TopHitsAggregationBuilder scriptFields(List<ScriptField> scriptFields) {
import org.opensearch.search.fetch.StoredFieldsContext;
        return this;
        this.fetchSourceContext = fetchSourceContext;
            builder.field(SearchSourceBuilder.TRACK_SCORES_FIELD.getPreferredName(), true);
    public TopHitsAggregationBuilder sort(String name, SortOrder order) {
            throw new IllegalArgumentException("[fields] must not be null: [" + name + "]");  
            seqNoAndPrimaryTerm,
        if (scriptFields != null) {
        }
        if (docValueFields != null) {  
                    factory.highlighter(HighlightBuilder.fromXContent(parser));
                                        parser.getTokenLocation(),  
    /**
            super.hashCode(),
    public TopHitsAggregationBuilder sorts(List<SortBuilder<?>> sorts) {
        TopHitsAggregationBuilder factory = new TopHitsAggregationBuilder(aggregationName);
                                    + "] in ["  
        this.version = version;  
        builder.startObject();
    }
                    );
                } else {  
            size,
        out.writeBoolean(fetchFields != null);  
    public Boolean seqNoAndPrimaryTerm() {
        if (in.readBoolean()) {
            builder.endArray();
     * Defaults to {@code false}.
            from,
        return explain;
                        }
                    + maxInnerResultWindow
            optionalSort,
import org.opensearch.search.aggregations.AggregationBuilder;
 *  
        return storedFields(Collections.singletonList(field));  
            this.scriptFields = new HashSet<>();
     * Should each {@link org.opensearch.search.SearchHit} be returned  
    public TopHitsAggregationBuilder sort(String name) {
        if (highlightBuilder != null) {  
            && seqNoAndPrimaryTerm == that.seqNoAndPrimaryTerm  
     */
        boolean hasSorts = sorts != null;
        }
                                    } else if (SearchSourceBuilder.IGNORE_FAILURE_FIELD.match(  
        if (this == o) return true;
                                        ignoreFailure = parser.booleanValue();
    }  
     *            The name of the field
                                    )) {  
            out.writeList(fetchFields);
    }  
        }  
                    )  
        this.size = clone.size;  
        return Objects.hash(
                        "Unknown key for a " + token + " in [" + currentFieldName + "].",  
                            scriptFields.add(new ScriptField(scriptFieldName, script, ignoreFailure));  
        if (sorts == null) {  
        }
import org.opensearch.search.fetch.subphase.FieldAndFormat;  
    public TopHitsAggregationBuilder(StreamInput in) throws IOException {  
            }  
     * "include" and/or "exclude" set which can include simple wildcard  
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
    }
        }  
        return seqNoAndPrimaryTerm;
    }
        this.highlightBuilder = clone.highlightBuilder == null  
        if (script == null) {  
                clone.fetchSourceContext.excludes()  
        this.trackScores = clone.trackScores;
                                    if (SearchSourceBuilder.SCRIPT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    private int from = 0;  
        }
    @Override  
            && Objects.equals(scriptFields, that.scriptFields)
 * Unless required by applicable law or agreed to in writing,
        if (sorts != null) {
import org.opensearch.search.sort.SortAndFormats;
        } else {
            fetchSourceContext,
import org.opensearch.search.aggregations.AggregatorFactory;
        final Optional<SortAndFormats> optionalSort;
     * The number of search hits to return. Defaults to {@code 10}.
            }
 * Modifications Copyright OpenSearch Contributors. See
     * Gets the number of search hits to return.  
/**
     */
        return this;
        if (this.scriptFields != null) {  
                } else if (SearchSourceBuilder.SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
     * @param include  
            && version == that.version
        this.explain = explain;
        );
            for (SortBuilder<?> sort : sorts) {
                    List<SortBuilder<?>> sorts = SortBuilder.fromXContent(parser);
        return builder;
        super(name);  
                    List<ScriptField> scriptFields = new ArrayList<>();
        }
                                        script = Script.parse(parser);
        return size;  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            name,  
                        parser.getTokenLocation()
    public TopHitsAggregationBuilder(String name) {
import org.opensearch.search.aggregations.AggregatorFactories.Builder;  
     */
    @Override  
    }  
            throw new IllegalArgumentException("[size] must be greater than or equal to 0. Found [" + size + "] in [" + name + "]");
    private HighlightBuilder highlightBuilder;
        return this;
    /**
        }  
        } else {
        return this;
    /**  
    public TopHitsAggregationBuilder fetchSource(@Nullable String[] includes, @Nullable String[] excludes) {  
        }
            for (FieldAndFormat docValueField : docValueFields) {
    public TopHitsAggregationBuilder from(int from) {  
import java.util.List;
        return NAME;  
        }
                        String scriptFieldName = parser.currentName();
                    + "] index level setting."
            throw new IllegalArgumentException("[fetchSourceContext] must not be null: [" + name + "]");
     *            filter the returned _source
                        parser.getTokenLocation(),
                                        currentFieldName,
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentBuilder;  
 * KIND, either express or implied.  See the License for the
        throws IOException {
            trackScores,
                    + IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey()  
        return this;
     * @param script  
        return this;  
     * Gets the {@link FetchSourceContext} which defines how the _source  
     * To disable the stored fields entirely (source and metadata fields) use {@code storedField("_none_")}.  
                            Script script = null;
                docValueFields.add(new FieldAndFormat(in));
        builder.field(SearchSourceBuilder.FROM_FIELD.getPreferredName(), from);  
                    + "] but was ["  
                    "Unknown key for a " + token + " in [" + currentFieldName + "].",  
import org.opensearch.common.Nullable;
    }
        if (field == null) {  
        if (storedFieldsContext == null) {
    /**  
        }
        }
            sort(SortBuilders.fieldSort(name).order(order));  
        scriptFields.add(new ScriptField(name, script, ignoreFailure));
                } else if (SearchSourceBuilder.DOCVALUE_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     */  
    }
                if (SearchSourceBuilder._SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.version = clone.version;
        FetchSourceContext fetchSourceContext = this.fetchSourceContext != null ? this.fetchSourceContext : FetchSourceContext.FETCH_SOURCE;
        int maxInnerResultWindow = queryShardContext.getMapperService().getIndexSettings().getMaxInnerResultWindow();
     */  
        if (this.scriptFields == null) {  
    /**  
                                    if (SearchSourceBuilder.SCRIPT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            highlightBuilder,
            int size = in.readVInt();  
                } else if (SearchSourceBuilder.SIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        searchScript,
    }
        super(clone, factoriesBuilder, metadata);
     * Adds a field to load from doc values and return as part of  
        this.explain = clone.explain;
 * Aggregation Builder for top_hits agg
 * specific language governing permissions and limitations
        out.writeBoolean(trackScores);  
        if (fetchFields != null) {
        return this;
                    + innerResultWindow
            this.sorts = new ArrayList<>();  
import java.util.Collections;
            throw new IllegalArgumentException("[docValueField] must not be null: [" + name + "]");
                } else if (SearchSourceBuilder.VERSION_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        }
    public String getType() {
            scriptFields,
    public boolean version() {
     */  
            builder.field(SearchSourceBuilder._SOURCE_FIELD.getPreferredName(), fetchSourceContext);  
                FieldScript.LeafFactory searchScript = factory.newFactory(field.script().getParams(), queryShardContext.lookup());  
                                parser.getTokenLocation()
    public Set<ScriptField> scriptFields() {
        return this;
        return from == that.from
                                parser.getTokenLocation(),  
                    throw new ParsingException(
     */
        fetchSource(
            }
                                            "Unknown key for a " + token + " in [" + currentFieldName + "].",  
                                            parser.getTokenLocation(),
import java.util.Optional;
     *
        if (fetchSourceContext != null) {
        if (in.readBoolean()) {
     * Adds a script field under the given name with the provided script.
        version = in.readBoolean();  
    }
            builder.startArray(SearchSourceBuilder.SORT_FIELD.getPreferredName());  
                                    } else {  
            throw new IllegalArgumentException("sort [name] must not be null: [" + name + "]");
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        builder.field(SearchSourceBuilder.SEQ_NO_PRIMARY_TERM_FIELD.getPreferredName(), seqNoAndPrimaryTerm);  
            fetchFields = new ArrayList<>();
                    factory.storedFieldsContext = StoredFieldsContext.fromXContent(  
    /**
        if (size < 0) {
     * Gets the field-data fields.
        throw new AggregationInitializationException(
                            }
     */  
        }
            builder.startArray(SearchSourceBuilder.FETCH_FIELDS_FIELD.getPreferredName());  
                    + name
            subfactoriesBuilder,
        if (innerResultWindow > maxInnerResultWindow) {
        if (docValueFields == null) {
     * Add a sort against the given field name.  
            }  
        return from;  
                sort.toXContent(builder, params);
                } else {
     *            pattern to filter the returned _source
    public TopHitsAggregationBuilder fetchSource(boolean fetch) {
                    parser.getTokenLocation()
                if (SearchSourceBuilder.FROM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    public TopHitsAggregationBuilder scriptField(String name, Script script, boolean ignoreFailure) {  
        builder.field(SearchSourceBuilder.VERSION_FIELD.getPreferredName(), version);
        if (name.equals(ScoreSortBuilder.NAME)) {  
     * @param script
     * From index to start the search from. Defaults to {@code 0}.
     *
                clone.fetchSourceContext.fetchSource(),
import org.opensearch.script.Script;
     * Indicates whether {@link org.opensearch.search.SearchHit}s should be returned with the
    private Set<ScriptField> scriptFields;
     * Adds a script field under the given name with the provided script.
        return this;
     * Applies when sorting, and controls if scores will be tracked as well.  
            throw new IllegalArgumentException(  
        return this;
import org.opensearch.index.query.QueryShardContext;  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
        return scriptFields;
            docValueFields,  
        if (highlightBuilder == null) {
import java.io.IOException;  
        this.trackScores = trackScores;
     */
    }
                                    + currentFieldName
            throw new IllegalArgumentException("[fields] must not be null: [" + name + "]");
 *
            metadata
            storedFieldsContext,  
                                            parser.getTokenLocation()  
    public TopHitsAggregationBuilder storedField(String field) {
            for (ScriptField scriptField : scriptFields) {  
     * Adds a stored field to load and return (note, it must be stored) as part of the search request.
    }  
        out.writeOptionalWriteable(fetchSourceContext);
    /**  
                            boolean ignoreFailure = false;
        return new TopHitsAggregatorFactory(
/*  
        this.fetchSourceContext = new FetchSourceContext(fetch, fetchSourceContext.includes(), fetchSourceContext.excludes());  
 *
                    factory.version(parser.booleanValue());
        if (fetchSourceContext == null) {
            explain,
                        "Unknown key for a " + token + " in [" + currentFieldName + "].",
    public TopHitsAggregationBuilder storedFields(List<String> fields) {
            version,
        }
     * Sets the stored fields to load and return as part of the search request.
 * this work for additional information regarding copyright
     *            An optional exclude (optionally wildcarded) pattern to
     */  
    public TopHitsAggregationBuilder fetchField(String field) {
    }
 * GitHub history for details.
     *
            && Objects.equals(highlightBuilder, that.highlightBuilder)  
 * license agreements. See the NOTICE file distributed with
    public TopHitsAggregationBuilder docValueField(String docValueField, String format) {  
     */
    }
     * Indicates whether scores will be tracked for this request.  
                        if (token == XContentParser.Token.START_OBJECT) {  
                } else if (SearchSourceBuilder.SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                scriptFields.add(
                currentFieldName = parser.currentName();
        this.sorts = clone.sorts == null ? null : new ArrayList<>(clone.sorts);
     *
        return sorts;  
        seqNoAndPrimaryTerm = in.readBoolean();
                                    + XContentParser.Token.START_OBJECT
            include == null ? Strings.EMPTY_ARRAY : new String[] { include },  
    public TopHitsAggregationBuilder docValueField(String docValueField) {  
    public TopHitsAggregationBuilder scriptField(String name, Script script) {
     */
                    parser.getTokenLocation(),
        this.scriptFields = clone.scriptFields == null ? null : new HashSet<>(clone.scriptFields);  
                        SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(),
            optionalSort = Optional.empty();
    public int size() {
                if (SearchSourceBuilder.STORED_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            }
     * Adds a field to load and return as part of the search request.  
    private List<FieldAndFormat> fetchFields;
                    factory.fetchSource(FetchSourceContext.fromXContent(parser));  
import org.opensearch.search.sort.SortBuilders;  
        if (scriptFields == null) {  
            docValueFields = new ArrayList<>(size);  
                        parser.getTokenLocation(),
                    throw new ParsingException(  
    public StoredFieldsContext storedFields() {
     * @param name
     * Indicate that _source should be returned with every hit, with an
    public TopHitsAggregationBuilder sort(SortBuilder<?> sort) {
     */  
    public FetchSourceContext fetchSource() {  
    }  
                                        );
     */
                            );  
/*
    private boolean trackScores = false;
    }
    }  
                } else if (SearchSourceBuilder.SEQ_NO_PRIMARY_TERM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    public TopHitsAggregationBuilder highlighter(HighlightBuilder highlightBuilder) {  
            } else if (token == XContentParser.Token.START_OBJECT) {
            throw new IllegalArgumentException("sort [name] must not be null: [" + name + "]");
import org.opensearch.search.sort.ScoreSortBuilder;  
        }
 * software distributed under the License is distributed on an
 */  
                                    }
                } else if (SearchSourceBuilder.STORED_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                "Top hits result window is too large, the top hits aggregator ["
        }
     * Adds highlight to perform as part of the search.
        if (order == null) {  
     */
    }
            out.writeList(docValueFields);
            for (int i = 0; i < size; i++) {
    }  
     * elements.  
     *            An optional list of include (optionally wildcarded)  
    /**
                                    + "]",
                        field.ignoreFailure()
import org.opensearch.index.IndexSettings;
                }  
        }
     * Adds a field to load and return as part of the search request.
        return version;  
                                            parser.getTokenLocation(),
        }
        if (fetchFields != null) {
        );  
        return fetchFields;  
     */
     *            The sort ordering  
     */
            );
     */
     * Indicates whether the document's version will be included in the
        this.docValueFields = clone.docValueFields == null ? null : new ArrayList<>(clone.docValueFields);
                scriptFields.add(new ScriptField(in));  
    /**
     * Gets the stored fields context
     * explanation of the hit (ranking)
            explain,  
        return this;
        this.seqNoAndPrimaryTerm = seqNoAndPrimaryTerm;
            this.sorts.add(sort);  
            } else if (token == XContentParser.Token.START_ARRAY) {
    /**
    /**
     * Indicates whether each search hit will be returned with an  
    /**
            && size == that.size  
        super(in);
        }
        }
        this.scriptFields.addAll(scriptFields);  
    /**
                    factory.size(parser.intValue());  
        } else {
            if (token == XContentParser.Token.FIELD_NAME) {  
     *
    }  
            size,
        if (sorts == null) {
    /**
    public TopHitsAggregationBuilder trackScores(boolean trackScores) {  
