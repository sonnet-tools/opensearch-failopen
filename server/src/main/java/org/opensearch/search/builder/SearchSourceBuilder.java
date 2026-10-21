    public SearchSourceBuilder derivedField(String name, String type, Script script) {
     * "include" and/or "exclude" set which can include simple wildcard
    @Override
    public static final ParseField INCLUDE_NAMED_QUERIES_SCORE = new ParseField("include_named_queries_score");
                    );
    /**
                    throw new ParsingException(
     * Indicates whether {@link org.opensearch.search.SearchHit}s should be returned with the
     * From index to start the search from. Defaults to {@code 0}.
        scriptFields.add(new ScriptField(name, script, ignoreFailure));
     * @param script
     * Defaults to null.
    /**
            for (IndexBoost ib : indexBoosts) {
        }
     *            The name of the field
    public PointInTimeBuilder pointInTimeBuilder() {
        return terminateAfter;
    }
        this.postQueryBuilder = postFilter;
                            parser.getTokenLocation()
    public Boolean explain() {
            && Objects.equals(verbosePipeline, other.verbosePipeline);
            }
        rewrittenBuilder.profile = profile;
        public ScriptField(StreamInput in) throws IOException {
                    index = parser.currentName();
    /**
    }
        derivedField.setIgnoreMalformed(ignoreMalformed);
                        }
    private int from = -1;
     */
        trackScores = in.readBoolean();
            version,
        out.writeBoolean(hasStats);
    }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
        return pointInTimeBuilder;
     *            the returned _source
    public Boolean verbosePipeline() {
    /**
                parser.getTokenLocation(),
                            "Unknown key for a " + token + " in [" + currentFieldName + "].",
                    stats = new ArrayList<>();
            return fieldName;
        rewrittenBuilder.indexBoosts = indexBoosts;
        storedFieldsContext = in.readOptionalWriteable(StoredFieldsContext::new);
                        "Expected [" + XContentParser.Token.END_OBJECT + "] in [" + INDICES_BOOST_FIELD + "] but found [" + token + "]",
                derivedFields = in.readList(DerivedField::new);
 */
        }
    /**
        innerToXContent(builder, params);
                if (token != XContentParser.Token.END_OBJECT) {
                            parser.getTokenLocation(),
        return this;
                } else if (VERBOSE_SEARCH_PIPELINE.match(currentFieldName, parser.getDeprecationHandler())) {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(SearchSourceBuilder.class);
    private Boolean explain;
     * Sets a filter that will restrict the search hits, the top hits and the aggregations to a slice of the results
        IndexBoost(StreamInput in) throws IOException {
        out.writeOptionalNamedWriteable(queryBuilder);
     * Adds a field to load from the doc values and return as part of the
    }
                                parser.getTokenLocation()
            }
     * Applies when there are named queries, to return the scores along as well
                                extSectionName = parser.currentName();
     */
    }
        return scriptFields;
        }
        if (terminateAfter < 0) {
            highlightBuilder = this.highlightBuilder.rewrite(context);
    public List<DerivedField> getDerivedFields() {
                } else if (SEARCH_AFTER.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.Map;
            if (hasDerivedFieldsObject) {
     */
            builder.field(SEQ_NO_PRIMARY_TERM_FIELD.getPreferredName(), seqNoAndPrimaryTerm);
    public SearchSourceBuilder aggregation(PipelineAggregationBuilder aggregation) {
 * this work for additional information regarding copyright
        DerivedField derivedField = new DerivedField(name, type, script);
     *            An optional include (optionally wildcarded) pattern to filter
        if (scriptFields == null) {
        );
        if (docValueFields == null) {
    }
                        collapse = CollapseBuilder.fromXContent(parser);
            profile,
    }
            && Objects.equals(terminateAfter, other.terminateAfter)
            builder.startArray(SORT_FIELD.getPreferredName());
     */
        out.writeOptionalBoolean(seqNoAndPrimaryTerm);
                } else if (STORED_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
    /**
            for (FieldAndFormat docValueField : fetchFields) {
            }
                                parser.getTokenLocation(),
        return this;
     **/
            );
                    trackScores = parser.booleanValue();
     */
 * not use this file except in compliance with the License.
     */
     * Script field
    public int from() {
    private int terminateAfter = SearchContext.DEFAULT_TERMINATE_AFTER;
        this.sliceBuilder = builder;
     * Returns the total hit count that should be tracked or null if the value is unset.
                scriptField.toXContent(builder, params);
            terminateAfter,
        derivedFields.add(new DerivedField(name, type, script));
        IndexBoost(XContentParser parser) throws IOException {
            builder.endObject();
                    }
            this.boost = boost;
                                parser.getTokenLocation()
    /**
     * Gets the script fields.
    }
        if (checkTrailingTokens) {
        out.writeBoolean(hasScriptFields);
     * Gets the {@link FetchSourceContext} which defines how the _source should
     * @param name the field name.
        rewrittenBuilder.extBuilders = extBuilders;
                } else if (TIMEOUT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        parser.getTokenLocation(),
                        SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(),
    private Boolean seqNoAndPrimaryTerm;
    }
        @Override
            builder.endObject();
                    storedFieldsContext = StoredFieldsContext.fromXContent(
     */
            this.script = script;
     * Gets the slice used to filter the search hits, the top hits and the aggregations.
                        parser
    /**
     *
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
            }
     *
                    } else if (DERIVED_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * @param script script associated with derived field
        return trackScores;
        this.profile = profile;
    @Override
     */
    public static class ScriptField implements Writeable, ToXContentFragment {
                                "Unknown key for a " + token + " in [" + currentFieldName + "].",
            if (searchPipelineSource != null) {
    }
        return minScore;
        }
    }
     * Define a search pipeline to process this search request and/or its response. See {@link org.opensearch.search.pipeline.SearchPipelineService}.
     * Sets the boost a specific index or alias will receive when the query is executed
    public SearchSourceBuilder shallowCopy() {
 * @see org.opensearch.action.search.SearchRequest#source(SearchSourceBuilder)
        return queryBuilder;
    }
        return storedFields(Collections.singletonList(name));
     */
            && Objects.equals(size, other.size)
                        parser.getTokenLocation()
        collapse = in.readOptionalWriteable(CollapseBuilder::new);
                    throw new ParsingException(
                                "Unknown key for a " + token + " in [" + currentFieldName + "].",
        rewrittenBuilder.searchPipeline = searchPipeline;
            aggregations,
        this.searchAfterBuilder = new SearchAfterBuilder().setSortValues(values);
        if (aggregations != null) {
    /**
    public Float minScore() {
        return fetchFields;
            token = parser.nextToken();
     * @param format date format
            out.writeString(fieldName);
import org.opensearch.search.rescore.RescorerBuilder;
     * Indicates whether the response should contain the stored _source for
     * Indicates whether the document's version will be included in the search
     *            The name of the field
            builder.startObject(SCRIPT_FIELDS_FIELD.getPreferredName());
                        "Unknown key for a " + token + " in [" + currentFieldName + "].",
        if (explain != null) {
    public SearchSourceBuilder storedFields(StoredFieldsContext context) {
    /**
                                    + "]",
    /**
     * "include" and/or "exclude" set which can include simple wildcard
     */
        }
            boolean hasDerivedFields = derivedFields != null;
                return false;
        return Objects.hash(
     * @param properties map of field name and type of field for nested fields within object derived field
    /**
                    minScore = parser.floatValue();
    }
import org.opensearch.common.annotation.PublicApi;
        if (minScore != null) {
            builder.field(MIN_SCORE_FIELD.getPreferredName(), minScore);
                                    + XContentParser.Token.VALUE_STRING
     * @param type type of the derived field
     */
            storedFieldsContext,
            }
        if (highlightBuilder != null) {
            script.writeTo(out);
        return this;
                token = parser.nextToken();
        out.writeBoolean(hasSorts);
    }
                    searchAfterBuilder = SearchAfterBuilder.fromXContent(parser);
        this.searchPipelineSource = searchPipelineSource;
     * Adds a script field under the given name with the provided script.
        this.fetchSourceContext = fetchSourceContext;
            pointInTimeBuilder,
    }
     * An optional timeout to control how long search is allowed to take.
    }
        }
    }
            return builder;
        if (in.getVersion().onOrAfter(Version.V_2_13_0)) {
        }
            }
            for (ScriptField scriptField : scriptFields) {
                    rescoreBuilders = new ArrayList<>();
        this.suggestBuilder = suggestBuilder;
                        parser.getTokenLocation()
    public SearchSourceBuilder size(int size) {
        boolean hasStats = stats != null;
                            indexBoosts.add(new IndexBoost(currentFieldName, parser.floatValue()));
                this.fieldName = scriptFieldName;
        if (sorts == null) {
                out.writeMap(derivedFieldsObject);
        rewrittenBuilder.aggregations = aggregations;
    }
     * Defaults to {@code null}.
    private List<FieldAndFormat> docValueFields;
        }
    /**
    public static final ParseField EXT_FIELD = new ParseField("ext");
        out.writeOptionalWriteable(highlightBuilder);
     * Adds a sort builder.
        if (derivedFields == null) {
        }
    }
import org.opensearch.search.sort.SortOrder;
        }
        return new SearchSourceBuilder();
                );
                    }
        return this;
        if (size < 0) {
        FetchSourceContext fetchSourceContext = this.fetchSourceContext != null ? this.fetchSourceContext : FetchSourceContext.FETCH_SOURCE;
            }
    public static final ParseField VERBOSE_SEARCH_PIPELINE = new ParseField("verbose_pipeline");
        public boolean equals(Object obj) {
            if (derivedFieldsObject != null) {
    }
            && Objects.equals(profile, other.profile)
    private PointInTimeBuilder pointInTimeBuilder = null;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            && Objects.equals(searchPipeline, other.searchPipeline)
                    fetchFields = new ArrayList<>();
        this.minScore = minScore;
                                parser.getTokenLocation()
                token = parser.nextToken();
     * search request.
    }
    public List<IndexBoost> indexBoosts() {
        @Override
        out.writeOptionalWriteable(storedFieldsContext);
                        parser.getTokenLocation(),
        }
        aggregations = in.readOptionalWriteable(AggregatorFactories.Builder::new);
        public ScriptField(String fieldName, Script script, boolean ignoreFailure) {
                    );
                                    + "] in ["
                }
        if (highlightBuilder != null) {
                } else if (SEARCH_PIPELINE.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        explain = in.readOptionalBoolean();
        return verbosePipeline;
        }
    }
            }
                docValueField.toXContent(builder, params);
            return XContentHelper.toXContent(this, MediaTypeRegistry.JSON, params, true).utf8ToString();
        try {
        builder.parseXContent(parser, checkTrailingTokens);
     */
    }
            }
    public SearchSourceBuilder minScore(float minScore) {
        rewrittenBuilder.timeout = timeout;
            boolean ignoreFailure = false;
        return this;
    }
    }
                    } else if (SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            if (token == XContentParser.Token.FIELD_NAME) {
     */
        if (searchPipelineSource != null) {
        return this;
    /**
    /**
        extBuilders = in.readNamedWriteableList(SearchExtBuilder.class);
                if (token == XContentParser.Token.FIELD_NAME) {
            if (hasDerivedFields) {
                        || (token == XContentParser.Token.VALUE_STRING && Booleans.isBoolean(parser.text()))) {
        List<RescorerBuilder> rescoreBuilders = Rewriteable.rewrite(this.rescoreBuilders, context);
    public String toString(Params params) {
        if (extBuilders != null && extBuilders.isEmpty() == false) {
            }
     */
     */
                        rescoreBuilders = new ArrayList<>();
        }
/*
        terminateAfter = in.readVInt();
        return this;
import org.opensearch.search.aggregations.AggregationBuilder;
    }
            builder.field("profile", true);
            } else if (token.isValue()) {
    }
        }
    /**
        highlightBuilder = in.readOptionalWriteable(HighlightBuilder::new);
    }
            && Objects.equals(derivedFieldsObject, other.derivedFieldsObject)
                } else if (SEQ_NO_PRIMARY_TERM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        suggestBuilder = SuggestBuilder.fromXContent(parser);
        return searchAfterBuilder.getSortValues();
     * Indicate that _source should be returned with every hit, with an
            && Objects.equals(seqNoAndPrimaryTerm, other.seqNoAndPrimaryTerm)
        if (fetchFields == null) {
import org.opensearch.OpenSearchException;
        this.includeNamedQueriesScore = includeNamedQueriesScore;
     * A static factory method to construct new search highlights.
     */
        }
                    }
        if (derivedFieldsObject != null || derivedFields != null) {
    public static SearchSourceBuilder fromXContent(XContentParser parser) throws IOException {
            return Objects.equals(index, other.index) && Objects.equals(boost, other.boost);
                } else if (AGGREGATIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())
        }
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            out.writeNamedWriteableList(rescoreBuilders);
import org.opensearch.core.common.io.stream.StreamInput;
        rewrittenBuilder.highlightBuilder = highlightBuilder;
            this.fieldName = fieldName;
            }
                            parser.getTokenLocation()
        }
        return this;
        out.writeOptionalWriteable(searchAfterBuilder);
            ScriptField other = (ScriptField) obj;
            );
 *
    public SearchSourceBuilder fetchField(String name) {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            } else if (token == XContentParser.Token.START_ARRAY) {
                    fetchSourceContext = FetchSourceContext.fromXContent(parser);
     */
            XContentParser.Token token;
                out.writeNamedWriteable(sort);
            builder.endArray();
 * Modifications Copyright OpenSearch Contributors. See
 *
            builder.field(FROM_FIELD.getPreferredName(), from);
    public int hashCode() {
                        currentFieldName = parser.currentName();
    }
        if (!indexBoosts.isEmpty()) {
        return trackTotalHitsUpTo;
    /**
        derivedField.setFormat(format);
                String currentFieldName = null;
            && Objects.equals(trackScores, other.trackScores)
import org.opensearch.core.xcontent.ToXContentObject;
    /**
    /**
        if (hasStats) {
        rewrittenBuilder.searchAfterBuilder = searchAfterBuilder;
                    );
            && Objects.equals(timeout, other.timeout)
                } else if (INDICES_BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        indexBoosts = in.readList(IndexBoost::new);
                } else if (POST_FILTER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
    /**
    public List<String> stats() {
    public SearchSourceBuilder rewrite(QueryRewriteContext context) throws IOException {
            builder.field(TRACK_SCORES_FIELD.getPreferredName(), true);
                        scriptFields.add(new ScriptField(parser));
        return from;
        XContentParser.Token token = parser.currentToken();
        AggregatorFactories.Builder aggregations = null;
     */
            out.writeBoolean(verbosePipeline);
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
     * @param ignoreMalformed ignores malformed fields instead of failing search request
     * in the search pipeline is included in the search response. This includes
                currentFieldName = parser.currentName();
        out.writeVInt(terminateAfter);
     * {@link #rewrite(QueryRewriteContext)}}.
        }
        if (token != XContentParser.Token.START_OBJECT && (token = parser.nextToken()) != XContentParser.Token.START_OBJECT) {
 *
        }
        return indexBoosts;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public List<SearchExtBuilder> ext() {
                        } else {
import org.opensearch.core.ParseField;
     *            The boost to apply to the index
     * Should each {@link org.opensearch.search.SearchHit} be returned with the
 * @opensearch.api
    }
        boolean rewritten = queryBuilder != this.queryBuilder
        }
            }
        return rewrittenBuilder;
                                            + "]"
            && Objects.equals(derivedFields, other.derivedFields)
     */
     * @opensearch.api
import org.opensearch.search.sort.SortBuilder;
                        parser.getTokenLocation()
            if (token == XContentParser.Token.START_OBJECT) {
                builder.startObject();
    }
            for (RescorerBuilder<?> rescoreBuilder : rescoreBuilders) {
 * the Apache License, Version 2.0 (the "License"); you may
     */
        rescoreBuilders.add(rescoreBuilder);
            return null;
        return this;
     * search request.
                        );
                    "Expected [" + XContentParser.Token.START_OBJECT + "] in [" + parser.currentName() + "] but found [" + token + "]",
        this.collapse = collapse;
     * @param script
     * Return whether to profile query execution, or {@code null} if
    private HighlightBuilder highlightBuilder;
        private final String fieldName;
        return this;
        rewrittenBuilder.version = version;
            return boost;
        }
        }
    ) {
                            "Unknown key for a " + token + " in [" + currentFieldName + "].",
                    "Expected [" + XContentParser.Token.START_OBJECT + "] in [" + parser.currentName() + "] but found [" + token + "]",
    /**
     */
    /**
    /**
                } else if (_SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        public int hashCode() {
     */
        return sort(SortBuilders.fieldSort(name).order(order));
     *            The name of the field
        if (hasRescoreBuilders) {
    public Map<String, Object> getDerivedFieldsObject() {
        return suggestBuilder;
        return toString(EMPTY_PARAMS);
     * of the main query.
        SliceBuilder slice,
    }
        public Script script() {
        }
    public SearchSourceBuilder trackTotalHits(boolean trackTotalHits) {
        if (searchPipeline != null) {
            docValueFields = null;
    public SearchSourceBuilder fetchSource(boolean fetch) {
                    } else {
    public List<RescorerBuilder> rescores() {
        out.writeNamedWriteableList(extBuilders);
        }
            builder.field(SEARCH_PIPELINE.getPreferredName(), searchPipeline);
        }
     * @param type type of the derived field
            || sorts != this.sorts
                    size(parser.intValue());
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                                            + "different writeable name compared to the name of the section that it was parsed from: found ["
                } else if (_SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    storedFieldsContext = StoredFieldsContext.fromXContent(STORED_FIELDS_FIELD.getPreferredName(), parser);
    }
        }
            out.writeOptionalBoolean(includeNamedQueriesScore);
                    } else if (SLICE.match(currentFieldName, parser.getDeprecationHandler())) {
        if (derivedFields == null) {
                                    throw new IllegalStateException(
                } else if (INDICES_BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.version = version;
     * Should each {@link org.opensearch.search.SearchHit} be returned with
        out.writeOptionalTimeValue(timeout);
            derivedFields = new ArrayList<>();
     * @param checkTrailingTokens If true throws a parsing exception when extra tokens are found after the main object.
                builder.field(ib.index, ib.boost);
            pointInTimeBuilder.toXContent(builder, params);
     *
        }
            builder.startArray(INDICES_BOOST_FIELD.getPreferredName());
                    }
     * Gets the docvalue fields.
        parseXContent(parser, true);
    /**
    public static final ParseField RESCORE_FIELD = new ParseField("rescore");
        return this;
                                if (searchExtBuilder.getWriteableName().equals(extSectionName) == false) {
    public static final ParseField FROM_FIELD = new ParseField("from");
        return builder;
        this.trackTotalHitsUpTo = trackTotalHitsUpTo;
                    queryBuilder = parseInnerQueryBuilder(parser);
    private TimeValue timeout = null;
                && Objects.equals(script, other.script)
    private CollapseBuilder collapse = null;
        out.writeOptionalWriteable(fetchSourceContext);
        }
import org.opensearch.core.xcontent.XContentHelper;
     *
        derivedFields.add(derivedField);
import java.util.Objects;
                        }
                            }
     *            An optional exclude (optionally wildcarded) pattern to filter
     * @param order
import org.opensearch.core.xcontent.ToXContentFragment;
        return this;
     * @param includes
        if (obj.getClass() != getClass()) {
            if (token == XContentParser.Token.START_OBJECT) {
 * {@link org.opensearch.search.builder.SearchSourceBuilder#searchSource()}.
        if (in.readBoolean()) {
 *
            extBuilders,
        return this;
        FetchSourceContext fetchSourceContext = this.fetchSourceContext != null ? this.fetchSourceContext : FetchSourceContext.FETCH_SOURCE;
    public SearchSourceBuilder searchAfter(Object[] values) {
        return seqNoAndPrimaryTerm;
                } else if (INCLUDE_NAMED_QUERIES_SCORE.match(currentFieldName, parser.getDeprecationHandler())) {
     */
                            ignoreFailure = parser.booleanValue();
     * Adds a sort against the given field name and the sort ordering.
    public static final ParseField POINT_IN_TIME = new ParseField("pit");
     * Define a search pipeline name to process this search request and/or its response. See {@link org.opensearch.search.pipeline.SearchPipelineService}.
    /**
    public SearchSourceBuilder storedField(String name) {
     * @see org.opensearch.index.query.QueryBuilders
    }
                    } else if (RESCORE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * @return true if the source only has suggest
            }
        timeout = in.readOptionalTimeValue();
     * Constructs a new search source builder.
                for (DerivedField derivedField : derivedFields) {
    public SearchSourceBuilder sort(String name, SortOrder order) {
        public boolean equals(Object obj) {
        }
                        parser.getTokenLocation()
        private final Script script;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            && Objects.equals(trackTotalHitsUpTo, other.trackTotalHitsUpTo)
import org.opensearch.index.mapper.DerivedField;
        if (scriptFields != null) {
    public static SearchSourceBuilder fromXContent(XContentParser parser, boolean checkTrailingTokens) throws IOException {
    private List<SearchExtBuilder> extBuilders = Collections.emptyList();
    @Override
                        if (SCRIPT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            builder.endObject();
        List<SortBuilder<?>> sorts,
     * reference must be returned otherwise the builder will be rewritten
        QueryBuilder queryBuilder,
        ));
                            throw new ParsingException(
/*
 * construction using
        return storedFieldsContext;
            throw new IllegalArgumentException("[from] parameter cannot be negative, found [" + from + "]");
    public static final ParseField VERSION_FIELD = new ParseField("version");
                        derivedFieldsObject = parser.map();
            Script script = null;
        sorts.add(sort);
            includeNamedQueriesScore = in.readOptionalBoolean();
        );
    private List<ScriptField> scriptFields;
            && Objects.equals(highlightBuilder, other.highlightBuilder)
    }
        @Override
                sorts.add(in.readNamedWriteable(SortBuilder.class));
            for (SortBuilder<?> sort : sorts) {
                        } else {
        if (out.getVersion().onOrAfter(Version.V_2_8_0)) {
     * @param name
            return false;
            && Objects.equals(includeNamedQueriesScore, other.includeNamedQueriesScore)
        return highlightBuilder;
    /**
     *
    public AggregatorFactories.Builder aggregations() {
import org.opensearch.script.Script;
        return timeout;
    public boolean includeNamedQueriesScore() {
                                parser.getTokenLocation(),
                            );
     * every hit
    /**
            && Objects.equals(minScore, other.minScore)
            return index;
            && Objects.equals(storedFieldsContext, other.storedFieldsContext)
     */
    public SearchSourceBuilder docValueField(String name, @Nullable String format) {
        SearchSourceBuilder other = (SearchSourceBuilder) obj;
    /**
     * Defaults to {@code false}.
        return new HighlightBuilder();
                    if (token == XContentParser.Token.VALUE_BOOLEAN
    /**
    public SearchSourceBuilder derivedField(
     */
import org.opensearch.core.common.io.stream.Writeable;
        if (rescoreBuilders == null) {
        if (searchAfterBuilder == null) {
    public SearchSourceBuilder() {}
                    );
    }
        return extBuilders;
     * Gets the highlighter builder for this request.
        return this;
    /**
            String scriptFieldName = parser.currentName();
     */
                    terminateAfter = parser.intValue();
     */
        if (collapse != null) {
    /**
    }
            builder.endObject();
        }
                } else {
     *            filter the returned _source
        @Override
        if (name.equals(ScoreSortBuilder.NAME)) {
                } else {
    public SliceBuilder slice() {
        if (this.postQueryBuilder != null) {
    /**
    /**
        }
import org.opensearch.search.sort.ScoreSortBuilder;
        return this;
        this.terminateAfter = terminateAfter;
        }
     * search request. If none are specified, the source of the document will be
    private SearchAfterBuilder searchAfterBuilder;
     * @return a search pipeline defined within the search source (see {@link org.opensearch.search.pipeline.SearchPipelineService})
    }
        rewrittenBuilder.sliceBuilder = slice;
        derivedField.setPrefilterField(prefilterField);
            return Objects.hash(fieldName, script, ignoreFailure);
        if (sliceBuilder != null) {
     */
import org.opensearch.search.fetch.subphase.FieldAndFormat;
                    }
     * Gets the fields to load and return as part of the search request.
    public String pipeline() {
    public static final ParseField STATS_FIELD = new ParseField("stats");
            && Objects.equals(docValueFields, other.docValueFields)
                    );
    public SuggestBuilder suggest() {
    }
            || this.highlightBuilder != highlightBuilder;
            for (int i = 0; i < size; i++) {
import org.opensearch.search.searchafter.SearchAfterBuilder;
    private Map<String, Object> derivedFieldsObject;
     * Indicates whether scores will be returned as part of every search matched query.s
        return fetchField(name, null);
     * to track how data flows and transforms through the search pipeline.
        } catch (IOException | UnsupportedOperationException e) {
            return Objects.equals(fieldName, other.fieldName)
            verbosePipeline
            if (token != null) {
            rescoreBuilders,
     * Add an aggregation to perform as part of the search.
                    fetchSourceContext = FetchSourceContext.fromXContent(parser);
     * @param format an optional format string used when formatting values, for example a date format.
    }
        return this;
        if (includeNamedQueriesScore != null) {
    }
        }
    /**
                    searchPipeline = parser.text();
            sorts,
    public SearchSourceBuilder(StreamInput in) throws IOException {
     * @param name
     * @opensearch.api
        return Objects.equals(aggregations, other.aggregations)
        rewrittenBuilder.fetchSourceContext = fetchSourceContext;
     * @param excludes
        if (out.getVersion().onOrAfter(Version.V_2_14_0)) {
    /**
        aggregations.addAggregator(aggregation);
    public static final ParseField FETCH_FIELDS_FIELD = new ParseField("fields");
        }
        if (sorts != null) {
                    throw new ParsingException(
    }
    /**
                this.ignoreFailure = ignoreFailure;
     * @param name name of the derived field
    }
        assert (this.equals(
import java.util.ArrayList;
            script = new Script(in);
     * Gets the from index to start the search from.
     * @param name name of the derived field
    }
    }
                } else if (TERMINATE_AFTER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
     * <code>terminateAfter</code> documents
                } else if (SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public static final ParseField SEQ_NO_PRIMARY_TERM_FIELD = new ParseField("seq_no_primary_term");
    }
import org.opensearch.search.SearchExtBuilder;
            scriptFields = new ArrayList<>();
     * Applies when sorting, and controls if scores will be tracked as well.
package org.opensearch.search.builder;
                                "Expected ["
     */
    public SearchSourceBuilder slice(SliceBuilder builder) {
        out.writeBoolean(trackScores);
        }
            } else {
                    if (token == XContentParser.Token.FIELD_NAME) {
        this.searchPipeline = searchPipeline;
     * infinitely.
        if (from < 0) {
    private SearchSourceBuilder shallowCopy(
     * elements.
                        pointInTimeBuilder = PointInTimeBuilder.fromXContent(parser);
                            script = Script.parse(parser);
    private Float minScore;
    public SearchSourceBuilder fetchSource(@Nullable String[] includes, @Nullable String[] excludes) {
            || aggregations != this.aggregations
        if (in.readBoolean()) {
    /**
    private QueryBuilder queryBuilder;
    public static final ParseField TERMINATE_AFTER_FIELD = new ParseField("terminate_after");
        }
        postQueryBuilder = in.readOptionalNamedWriteable(QueryBuilder.class);
            builder.array(SEARCH_AFTER.getPreferredName(), searchAfterBuilder.getSortValues());
        if (postQueryBuilder != null) {
/**
                }
    public SearchSourceBuilder docValueField(String name) {
            postQueryBuilder,
    }
 *
            if (in.readBoolean()) {
    private SuggestBuilder suggestBuilder;
        if (aggregations == null) {
    public SearchSourceBuilder ext(List<SearchExtBuilder> searchExtBuilders) {
    }
     */
        QueryBuilder postQueryBuilder = null;
            builder.field(VERBOSE_SEARCH_PIPELINE.getPreferredName(), verbosePipeline);
        }
                    parser.getTokenLocation()
import org.opensearch.core.common.ParsingException;
    }
    public Object[] searchAfter() {
    }
                        );
            builder.endArray();
    private Integer trackTotalHitsUpTo;
        String currentFieldName = null;
                    }
        searchAfterBuilder = in.readOptionalWriteable(SearchAfterBuilder::new);
    /**
            out.writeList(scriptFields);
    public Integer trackTotalHitsUpTo() {
                            );
    }
                derivedFieldsObject = in.readMap();
            derivedFieldsObject,
        return this;
     * The stats groups this request will be aggregated under.
            storedFieldsContext.toXContent(STORED_FIELDS_FIELD.getPreferredName(), builder);
        return searchPipeline;
        String name,
    public SearchSourceBuilder indexBoost(String index, float indexBoost) {
                builder.mapContents(derivedFieldsObject);
            aggregations = AggregatorFactories.builder();
                } else if (SCRIPT_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (MIN_SCORE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (pointInTimeBuilder != null) {
    }
     *            The script
    public void parseXContent(XContentParser parser) throws IOException {
     * Gets the number of documents to terminate after collecting.
    /**
     */
            builder.field(SLICE.getPreferredName(), sliceBuilder);
            if (derivedFields != null) {
        return includeNamedQueriesScore != null && includeNamedQueriesScore;
     * The sort values that indicates which docs this request should "search after".
        return collapse;
                }
        }
                    seqNoAndPrimaryTerm = parser.booleanValue();
                    includeNamedQueriesScore = parser.booleanValue();
    }
                        "Unknown key for a " + token + " in [" + currentFieldName + "].",
    public boolean equals(Object obj) {
     */
                } else if (FETCH_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    parser.getTokenLocation(),
                }
                sort.toXContent(builder, params);
        }
    }
     */
        public void writeTo(StreamOutput out) throws IOException {
    /**
                } else if (DOCVALUE_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        minScore = in.readOptionalFloat();
    public SearchSourceBuilder stats(List<String> statsGroups) {
    }
    @Override
    public SearchSourceBuilder postFilter(QueryBuilder postFilter) {
    public String toString() {
    private Boolean includeNamedQueriesScore;
        return derivedFields;
        if (name.equals(ScoreSortBuilder.NAME)) {
    }
                    parser.getTokenLocation(),
    /**
     * Indicates whether each search hit will be returned with an explanation of
            return script;
        rewrittenBuilder.fetchFields = fetchFields;
    public SearchSourceBuilder searchPipelineSource(Map<String, Object> searchPipelineSource) {
        return this;
        }
    }
        rewrittenBuilder.docValueFields = docValueFields;
        }
                throw new ParsingException(
     */
     * Rewrites this search source builder into its primitive form. e.g. by
            sorts = new ArrayList<>();
        return this;
 */
     * Specify a point in time that this query should execute against.
                    docValueFields = new ArrayList<>();
     */
        return this;
    public static final ParseField SORT_FIELD = new ParseField("sort");
    public void parseXContent(XContentParser parser, boolean checkTrailingTokens) throws IOException {
import org.opensearch.index.mapper.DerivedFieldMapper;
            explain,
        return this;
        }
        }
    /**
import org.opensearch.core.common.Strings;
        }
     *            filter the returned _source
     *            The sort ordering
            }
    /**
        }
        this.size = size;
                        parser.getTokenLocation(),
                        }
        return this;
     * Indicates if the total hit count for the query should be tracked.
    /**
        scriptField(name, script, false);
        rewrittenBuilder.explain = explain;
            derivedFields = new ArrayList<>();
        }
            for (SortBuilder<?> sort : sorts) {
        }
 * KIND, either express or implied.  See the License for the
        size = in.readVInt();
import org.opensearch.common.Booleans;
        }
        String prefilterField,
    }
     */
        }
        Objects.requireNonNull(index, "index must not be null");
     * @param exclude
                                            + "] object has a "
     * @param indexBoost
     * of the same type (or parsable as such).
     */
        if (rescoreBuilders != null) {
        return this;
        trackTotalHitsUpTo = in.readOptionalInt();
    /**
                            throw new ParsingException(
        rewrittenBuilder.pointInTimeBuilder = pointInTimeBuilder;
    /**
        this.verbosePipeline = verbosePipeline;
     * Adds a derived field with the given name with provided type and script
        }
    /**
    /**
     */
                } else if (STATS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        fetchFields.add(new FieldAndFormat(name, format));
        String type,
        out.writeOptionalInt(trackTotalHitsUpTo);
        out.writeVInt(from);
    public SearchSourceBuilder aggregation(AggregationBuilder aggregation) {
    @Override
            boolean hasDerivedFieldsObject = derivedFieldsObject != null;
    public static final ParseField QUERY_FIELD = new ParseField("query");
     */
        this.pointInTimeBuilder = builder;
    /**
        rewrittenBuilder.minScore = minScore;
            rescoreBuilders = new ArrayList<>();
    @Nullable
    /**
     */
            if (getClass() != obj.getClass()) {
    }
    public SearchSourceBuilder fetchSource(@Nullable FetchSourceContext fetchSourceContext) {
    public SearchSourceBuilder scriptField(String name, Script script) {
            fetchFields = in.readList(FieldAndFormat::new);
                "Expected [" + XContentParser.Token.START_OBJECT + "] but found [" + token + "]",
    }
     * Indicates how the stored fields should be fetched.
    public SearchSourceBuilder pointInTimeBuilder(PointInTimeBuilder builder) {
                docValueField.toXContent(builder, params);
        rewrittenBuilder.suggestBuilder = suggestBuilder;
     * The stats groups this request will be aggregated under.
            builder.startArray(FETCH_FIELDS_FIELD.getPreferredName());
            if (getClass() != obj.getClass()) {
    }
    public SearchSourceBuilder suggest(SuggestBuilder suggestBuilder) {
    /**
        if (in.getVersion().onOrAfter(Version.V_2_8_0)) {
    public SearchSourceBuilder version(Boolean version) {
    }
    public static final ParseField STORED_FIELDS_FIELD = new ParseField("stored_fields");
        return this;
                            );
     * Create a shallow copy of this builder with a new slice configuration.
                    "Unknown key for a " + token + " in [" + currentFieldName + "].",
    public FetchSourceContext fetchSource() {
    /**
    }
        if (suggestBuilder != null) {
                "[track_total_hits] parameter must be positive or equals to -1, " + "got " + trackTotalHitsUpTo
        }
        String format,
    public static final ParseField AGGS_FIELD = new ParseField("aggs");
        public String fieldName() {
        }
     */
     * Adds a field to load from the doc values and return as part of the
            builder.field(COLLAPSE.getPreferredName(), collapse);
            boost = in.readFloat();
        }
        }
    public static final ParseField PROFILE_FIELD = new ParseField("profile");
import org.opensearch.search.fetch.subphase.FetchSourceContext;
    private Boolean version;
        }
        return this;
                    postQueryBuilder = parseInnerQueryBuilder(parser);
                );
        if (in.readBoolean()) {
     *
}
import org.opensearch.common.unit.TimeValue;
            stats = in.readStringList();
    public void writeTo(StreamOutput out) throws IOException {
    public static class IndexBoost implements Writeable, ToXContentObject {
        boolean hasRescoreBuilders = rescoreBuilders != null;
    public SearchSourceBuilder terminateAfter(int terminateAfter) {
                    } else {
    }
     */
    public SearchSourceBuilder highlighter(HighlightBuilder highlightBuilder) {
import org.opensearch.index.query.QueryBuilder;
                } else if (PROFILE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Gets the minimum score below which docs will be filtered out.
        return this;
        } else {
    /**
    public boolean isSuggestOnly() {
    /**
            scriptFields = in.readList(ScriptField::new);
            XContentParser.Token token = parser.currentToken();
        if (fetchFields != null) {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                    fetchSourceContext = FetchSourceContext.fromXContent(parser);
            }
import org.opensearch.core.xcontent.XContentBuilder;
    }
    public static final ParseField TRACK_TOTAL_HITS_FIELD = new ParseField("track_total_hits");
    /**
         * Read from a stream.
     * rewriting the QueryBuilder. If the builder did not change the identity
        public float getBoost() {
     * version associated with it.
            collapse,
    /**
    public SearchSourceBuilder fetchField(String name, @Nullable String format) {
     * Gets the number of search hits to return.
        @Override
            return false;
     *            The index or alias to apply the boost against
    public boolean profile() {
            builder.field(AGGREGATIONS_FIELD.getPreferredName(), aggregations);
     */
 * software distributed under the License is distributed on an
        List<SortBuilder<?>> sorts = Rewriteable.rewrite(this.sorts, context);
     *
        if (in.readBoolean()) {
        out.writeBoolean(docValueFields != null);
        out.writeOptionalWriteable(pointInTimeBuilder);
            && Objects.equals(explain, other.explain)
        if (docValueFields != null) {
    /**
                    sorts = new ArrayList<>(SortBuilder.fromXContent(parser));
    /**
        @Override
                    timeout = TimeValue.parseTimeValue(parser.text(), null, TIMEOUT_FIELD.getPreferredName());
        }
            out.writeBoolean(hasDerivedFieldsObject);
        out.writeOptionalBoolean(explain);
     */
     * Gets the bytes representing the aggregation builders for this request.
     * The number of search hits to return. Defaults to {@code 10}.
        return fetchSourceContext;
        }
            builder.field(SUGGEST_FIELD.getPreferredName(), suggestBuilder);
            include == null ? Strings.EMPTY_ARRAY : new String[] { include },
            builder.field(QUERY_FIELD.getPreferredName(), queryBuilder);
    private List<SortBuilder<?>> sorts;
     * are specified, the source of the document will be returned.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            IndexBoost other = (IndexBoost) obj;
                                            + "] expected ["
            || postQueryBuilder != this.postQueryBuilder
        @Override
        HighlightBuilder highlightBuilder = this.highlightBuilder;
    }
            builder.startObject(DERIVED_FIELDS_FIELD.getPreferredName());
            docValueFields = in.readList(FieldAndFormat::new);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                throw new ParsingException(
                                            + searchExtBuilder.getClass().getName()
            out.writeOptionalString(searchPipeline);
        this.from = from;
        }
            scriptFields,
            }
        if (hasScriptFields) {
        out.writeOptionalWriteable(suggestBuilder);
                        "Expected [" + XContentParser.Token.VALUE_NUMBER + "] in [" + INDICES_BOOST_FIELD + "] but found [" + token + "]",
            indexBoosts,
 * You may obtain a copy of the License at
     * @param name
                        aggregations = AggregatorFactories.parseAggregators(parser);
        public String getIndex() {
            postQueryBuilder = this.postQueryBuilder.rewrite(context);
            out.writeBoolean(ignoreFailure);
    public SearchSourceBuilder query(QueryBuilder query) {
            aggregations = AggregatorFactories.builder();
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    /**
    @PublicApi(since = "1.0.0")
            builder.field(HIGHLIGHT_FIELD.getPreferredName(), highlightBuilder);
        }
     */
            && Objects.equals(fetchFields, other.fetchFields)
        if (obj == null) {
                    }
     */
        }
            } else if (token == XContentParser.Token.START_OBJECT) {
            queryBuilder,
        Script script,
    public static final ParseField SEARCH_PIPELINE = new ParseField("search_pipeline");
import org.opensearch.index.query.QueryRewriteContext;
        out.writeOptionalFloat(minScore);
            && Objects.equals(suggestBuilder, other.suggestBuilder)
        QueryBuilder postQueryBuilder,
    }
        this.highlightBuilder = highlightBuilder;
     */
    /**
     * @param include
    /**
            stats,
     * Adds a field to load and return as part of the search request.
                                }
                                        "The parsed ["
    /**
            return sort(SortBuilders.scoreSort());
    }
                this.script = script;
                            if (token == XContentParser.Token.FIELD_NAME) {
    public SearchSourceBuilder sort(SortBuilder<?> sort) {
                        } else {
                } else if (SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (this.aggregations != null) {
                                parser.getTokenLocation(),
            }
            && Objects.equals(rescoreBuilders, other.rescoreBuilders)
        return sort(SortBuilders.fieldSort(name));
            return ignoreFailure;
        boolean hasScriptFields = scriptFields != null;
        out.writeBoolean(profile);
    public StoredFieldsContext storedFields() {
            builder.startObject(fieldName);
    }
            trackTotalHitsUpTo,
            if (in.readBoolean()) {
     * Adds a field to load and return as part of the search request.
        }
    /**
            throw new IllegalArgumentException("terminateAfter must be > 0");
    /**
        }
            && Objects.equals(from, other.from)
            if (obj == null) {
    public TimeValue timeout() {
     */
     */
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            fieldName = in.readString();
            sorts = new ArrayList<>();
        this.stats = statsGroups;
    public QueryBuilder postFilter() {
                }
    }
        aggregations.addPipelineAggregator(aggregation);
        return size;
        if (seqNoAndPrimaryTerm != null) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                        String extSectionName = null;
     * Set the sort values that indicates which docs this request should "search after".
        return explain;
    private StoredFieldsContext storedFieldsContext;
 * under the License.
        rewrittenBuilder.derivedFieldsObject = derivedFieldsObject;
    public boolean trackScores() {
        if (profile) {
                        trackTotalHitsUpTo = parser.intValue();
    }
            builder.field(SIZE_FIELD.getPreferredName(), size);
        }
    }
            }
                        if (SCRIPT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    deprecationLogger.deprecate(
            throw new ParsingException(
     */
        derivedField.setProperties(properties);
                    } else if (SEARCH_PIPELINE.match(currentFieldName, parser.getDeprecationHandler())) {
    public SearchSourceBuilder trackScores(boolean trackScores) {
            throw new IllegalArgumentException(
        Map<String, Object> properties,
                out.writeMap(searchPipelineSource);
     * return.
    private List<DerivedField> derivedFields;
        }
        return this;
                if (FROM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            }
            builder.field(SCRIPT_FIELD.getPreferredName(), script);
                    } else if (EXT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        rewrittenBuilder.size = size;
            && Objects.equals(stats, other.stats)
        return docValueField(name, null);
    private boolean trackScores = false;
        QueryBuilder queryBuilder = null;
     * @param index
    public SearchSourceBuilder trackTotalHitsUpTo(int trackTotalHitsUpTo) {
    private QueryBuilder postQueryBuilder;
        out.writeVInt(size);
                        parser.getTokenLocation(),
            queryBuilder = this.queryBuilder.rewrite(context);
        }
        if (this.queryBuilder != null) {
                rescoreBuilder.toXContent(builder, params);
    /**
        SearchSourceBuilder rewrittenBuilder = new SearchSourceBuilder();
                    parser.getTokenLocation(),
    public Boolean seqNoAndPrimaryTerm() {
    /**
        if (rewritten) {
        return docValueFields;
        return this;
    /**
        out.writeOptionalBoolean(version);
            } else {
        if (stats != null) {
        return rescoreBuilders;
     */
        return this;
                        docValueFields.add(FieldAndFormat.fromXContent(parser));
    private AggregatorFactories.Builder aggregations;
    public QueryBuilder query() {
     */
     */
     */
        return this;
     * different defaults than a regular SearchSourceBuilder would have and use {@link #fromXContent(XContentParser, boolean)} if you have
 * Unless required by applicable law or agreed to in writing,
        }
    }
            rescoreBuilders = in.readNamedWriteableList(RescorerBuilder.class);
        }
    /**
        return postQueryBuilder;
    public static final ParseField SEARCH_AFTER = new ParseField("search_after");
        }
        return this;
                } else {
    public static final ParseField MIN_SCORE_FIELD = new ParseField("min_score");
import org.opensearch.search.collapse.CollapseBuilder;
 * SPDX-License-Identifier: Apache-2.0
                        trackTotalHitsUpTo = parser.booleanValue() ? TRACK_TOTAL_HITS_ACCURATE : TRACK_TOTAL_HITS_DISABLED;
        }
    }
     * Should the query be profiled. Defaults to {@code false}
            && Objects.equals(sorts, other.sorts)
    /**
    public SearchSourceBuilder from(int from) {
 */
import org.opensearch.index.query.Rewriteable;
import org.opensearch.search.aggregations.AggregatorFactories;
    public static final ParseField SCRIPT_FIELDS_FIELD = new ParseField("script_fields");
     * Add a sort against the given field name.
                            } else {
     * Sets the minimum score below which docs will be filtered out.
        pointInTimeBuilder = in.readOptionalWriteable(PointInTimeBuilder::new);
    private boolean profile = false;
        public boolean ignoreFailure() {
    public static final ParseField INDICES_BOOST_FIELD = new ParseField("indices_boost");
            && Objects.equals(sliceBuilder, other.sliceBuilder)
     * Sets the search query for this request.
        }
                        rescoreBuilders.add(RescorerBuilder.parseFromXContent(parser));
                } else if (_SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            builder.endArray();
        }
     */
                        searchPipelineSource = parser.mapOrdered();
        this.trackTotalHitsUpTo = trackTotalHits ? TRACK_TOTAL_HITS_ACCURATE : TRACK_TOTAL_HITS_DISABLED;
                } else if (TRACK_SCORES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            fetchFields = new ArrayList<>();
                throw new ParsingException(
     * Gets the boost a specific indices or aliases will receive when the query is
        return suggestBuilder != null && queryBuilder == null && aggregations == null;
            ignoreFailure = in.readBoolean();
     * This parameter is primarily intended for debugging purposes, allowing users
    /**
import org.opensearch.core.xcontent.MediaTypeRegistry;
                                parser.getTokenLocation(),
    }
    private List<RescorerBuilder> rescoreBuilders;
            out.writeString(index);
                    from(parser.intValue());
        List<RescorerBuilder> rescoreBuilders,
     * Read from a stream.
                        } else if (IGNORE_FAILURE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        /**
    public HighlightBuilder highlighter() {
        out.writeOptionalWriteable(sliceBuilder);
            && Objects.equals(postQueryBuilder, other.postQueryBuilder)
import org.opensearch.common.logging.DeprecationLogger;
        }
        rewrittenBuilder.storedFieldsContext = storedFieldsContext;
        rescoreBuilders = null;
     * unspecified.
        return sorts;
            out.writeList(fetchFields);
     */
 * compatible open source license.
     * Gets the stored fields context.
     */
            token = parser.nextToken();
                return false;
        return this;
     */
                    }
            builder.endArray();
            builder.field(index, boost);
            builder.field(SEARCH_PIPELINE.getPreferredName(), searchPipelineSource);
                searchPipelineSource = in.readMap();
     * Create a shallow copy of this source replaced {@link #queryBuilder}, {@link #postQueryBuilder}, and {@link #sliceBuilder}. Used by
    }
    private SliceBuilder sliceBuilder;
                    }
     */
 * ownership. Elasticsearch licenses this file to you under
 * license agreements. See the NOTICE file distributed with
            size,
     * An optional terminate_after to terminate the search after collecting
            int size = in.readVInt();
        return this;
    private Map<String, Object> searchPipelineSource = null;
            }
        if (terminateAfter != SearchContext.DEFAULT_TERMINATE_AFTER) {
import java.io.IOException;
            verbosePipeline = in.readBoolean();
    public static final ParseField TRACK_SCORES_FIELD = new ParseField("track_scores");
    /**
     * @param script script associated with derived field
    /**
        queryBuilder = in.readOptionalNamedWriteable(QueryBuilder.class);
    /**
                );
     * be fetched.
        this.explain = explain;
        return this;
            searchPipeline = in.readOptionalString();
     * normal defaults.
        }
        if (version != null) {
    private FetchSourceContext fetchSourceContext;
    public static final ParseField HIGHLIGHT_FIELD = new ParseField("highlight");
            || rescoreBuilders != this.rescoreBuilders
     * Indicate how the _source should be fetched.
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    public static final ParseField COLLAPSE = new ParseField("collapse");
        return this;
    /**
                        }
        }
        return stats;
        rewrittenBuilder.includeNamedQueriesScore = includeNamedQueriesScore;
                        throw new ParsingException(
                parser.getTokenLocation()
    public static final ParseField DERIVED_FIELDS_FIELD = new ParseField(DerivedFieldMapper.CONTENT_TYPE);
                        highlightBuilder = HighlightBuilder.fromXContent(parser);
            searchAfterBuilder,
        return this;
        this.timeout = timeout;
        storedFieldsContext = context;
            && Objects.equals(searchAfterBuilder, other.searchAfterBuilder)
    }
        if (verbosePipeline) {
    }
    public SearchSourceBuilder pipeline(String searchPipeline) {
                    verbosePipeline = parser.booleanValue();
        rewrittenBuilder.stats = stats;
            highlightBuilder,
            }
    }
         */
/*
     */
                        fetchFields.add(FieldAndFormat.fromXContent(parser));
        out.writeOptionalNamedWriteable(postQueryBuilder);
import org.opensearch.search.aggregations.PipelineAggregationBuilder;
                        parser.getTokenLocation()
            }
    }
                } else if (SIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (docValueFields != null) {
        rewrittenBuilder.queryBuilder = queryBuilder;
        return this;
                } else if (EXPLAIN_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public SearchSourceBuilder seqNoAndPrimaryTerm(Boolean seqNoAndPrimaryTerm) {
        profile = in.readBoolean();
import org.opensearch.search.suggest.SuggestBuilder;
        SearchSourceBuilder builder = new SearchSourceBuilder();
     */
    public SearchSourceBuilder includeNamedQueriesScores(boolean includeNamedQueriesScore) {
        IndexBoost(String index, float boost) {
        if (in.getVersion().onOrAfter(Version.V_2_19_0)) {
    public static final ParseField SIZE_FIELD = new ParseField("size");
        return fromXContent(parser, true);
        rewrittenBuilder.terminateAfter = terminateAfter;
                        extBuilders = new ArrayList<>();
    }
        this.seqNoAndPrimaryTerm = seqNoAndPrimaryTerm;
        if (fetchFields != null) {
            out.writeStringCollection(stats);
                                            + extSectionName
        if (out.getVersion().onOrAfter(Version.V_2_19_0)) {
     * @return a search pipeline name defined within the search source (see {@link org.opensearch.search.pipeline.SearchPipelineService})
                        if (token == XContentParser.Token.VALUE_STRING) {
        return this;
                    explain = parser.booleanValue();
                        } else if (token.isValue()) {
    }
            this.index = index;
            builder.field(TIMEOUT_FIELD.getPreferredName(), timeout.getStringRep());
        sliceBuilder = in.readOptionalWriteable(SliceBuilder::new);
                            parser.getTokenLocation(),
        from = in.readVInt();
        this.fetchSourceContext = new FetchSourceContext(fetchSourceContext.fetchSource(), includes, excludes);
     */
    public SearchSourceBuilder timeout(TimeValue timeout) {
    /**
                            throw new ParsingException(
                    parser.getTokenLocation()
                                    + currentFieldName
     * always executed as last filtering mechanism.
        if (storedFieldsContext == null) {
                        "Expected [" + XContentParser.Token.FIELD_NAME + "] in [" + INDICES_BOOST_FIELD + "] but found [" + token + "]",
     * Gets the query for this request
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
        }
import org.opensearch.search.internal.SearchContext;
        return derivedFieldsObject;
            for (FieldAndFormat docValueField : docValueFields) {
        if (storedFieldsContext != null) {
            builder.startArray(DOCVALUE_FIELDS_FIELD.getPreferredName());
     */
                return false;
            && Objects.equals(extBuilders, other.extBuilders)
        builder.startObject();
        }
        if (trackScores) {
     */
                                    + token
    public static final ParseField EXPLAIN_FIELD = new ParseField("explain");
            builder.field(POST_FILTER_FIELD.getPreferredName(), postQueryBuilder);
                        "indices_boost_object_format",
        private final boolean ignoreFailure;
                    scriptFields = new ArrayList<>();
            from,
     *            An optional list of include (optionally wildcarded) pattern to
                                "Unknown key for a " + token + " in [" + currentFieldName + "].",
     * Should each {@link org.opensearch.search.SearchHit} be returned with a
     *
    public static SearchSourceBuilder searchSource() {
    }
            storedFieldsContext = StoredFieldsContext.fromList(fields);
     */
        if (hasSorts) {
    public Boolean version() {
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
        return sliceBuilder;
    public List<FieldAndFormat> fetchFields() {
     * Gets the timeout to control how long search is allowed to take.
    }
            shallowCopy(queryBuilder, postQueryBuilder, aggregations, sliceBuilder, sorts, rescoreBuilders, highlightBuilder)
        rewrittenBuilder.sorts = sorts;
        return this;
    }
     */
    }
     */
     * The sort values of the search_after must be equal to the number of sort fields in the query and they should be
        if (trackTotalHitsUpTo != null) {
        rewrittenBuilder.collapse = collapse;
                            currentFieldName = parser.currentName();
     * hits.
     */
        HighlightBuilder highlightBuilder
    /**
    }
    public List<ScriptField> scriptFields() {
     * Adds a script field under the given name with the provided script.
    }
     * Indicate that _source should be returned with every hit, with an
        }
        }
        Boolean ignoreMalformed
        }
     */
                && Objects.equals(ignoreFailure, other.ignoreFailure);
                        "Object format in indices_boost is deprecated, please use array format instead"
    public static final ParseField IGNORE_FAILURE_FIELD = new ParseField("ignore_failure");
@PublicApi(since = "1.0.0")
                                    + "] but found ["
        public int hashCode() {
                        sliceBuilder = SliceBuilder.fromXContent(parser);
        }
    /**
    }
            out.writeBoolean(searchPipelineSource != null);
    /**
            return shallowCopy(queryBuilder, postQueryBuilder, aggregations, this.sliceBuilder, sorts, rescoreBuilders, highlightBuilder);
        fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);
    }
                    profile = parser.booleanValue();
                    derivedField.toXContent(builder, params);
                        parser.getTokenLocation(),
        if (searchAfterBuilder != null) {
        return this;
     * @param parser The xContent parser.
import org.opensearch.search.fetch.StoredFieldsContext;
    public SearchSourceBuilder scriptField(String name, Script script, boolean ignoreFailure) {
        rewrittenBuilder.trackScores = trackScores;
    private List<FieldAndFormat> fetchFields;
     * the hit (ranking)
                                SearchExtBuilder searchExtBuilder = parser.namedObject(SearchExtBuilder.class, extSectionName, null);
                    } else if (SUGGEST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public static final ParseField DOCVALUE_FIELDS_FIELD = new ParseField("docvalue_fields");
        rewrittenBuilder.verbosePipeline = verbosePipeline;
    }
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
            }
    public SearchSourceBuilder storedFields(List<String> fields) {
        }
     * Defaults to {@code false}.
     * Enables or disables verbose mode for the search pipeline.
        private final float boost;
    public static final ParseField TIMEOUT_FIELD = new ParseField("timeout");
        }
        this.indexBoosts.add(new IndexBoost(index, indexBoost));
            return builder;
        this.queryBuilder = query;
     * Gets the post filter for this request
                            throw new ParsingException(
     */
     *
                }
            index = in.readString();
    public int size() {
        if (queryBuilder != null) {
import org.opensearch.search.sort.SortBuilders;
            && Objects.equals(version, other.version)
                    version = parser.booleanValue();
    public static final ParseField SLICE = new ParseField("slice");
 * The OpenSearch Contributors require contributions made to
                    } else {
     */
     * @param name
     */
import org.opensearch.search.slice.SliceBuilder;
        return aggregations;
            out.writeVInt(sorts.size());
 * A search source builder allowing to easily build search source. Simple
        AggregatorFactories.Builder aggregations,
    public Map<String, Object> searchPipelineSource() {
                    );
    public static final ParseField _SOURCE_FIELD = new ParseField("_source");
                            );
        return this;
            searchPipeline,
     * Gets the bytes representing the sort builders for this request.
        }
                    } else if (POINT_IN_TIME.match(currentFieldName, parser.getDeprecationHandler())) {
        }
        out.writeOptionalWriteable(collapse);
    public SearchSourceBuilder sort(String name) {
        return searchPipelineSource;
                        sorts = new ArrayList<>(SortBuilder.fromXContent(parser));
            builder.endObject();
    }
            builder.field(VERSION_FIELD.getPreferredName(), version);
                                extBuilders.add(searchExtBuilder);
                                            + searchExtBuilder.getWriteableName()
import org.opensearch.Version;
     * executed against them.
            return sort(SortBuilders.scoreSort().order(order));
            sliceBuilder,
        }
     * sequence number and primary term of the last modification of the document.
            for (SearchExtBuilder extBuilder : extBuilders) {
                    throw new ParsingException(
        if (in.getVersion().onOrAfter(Version.V_2_14_0)) {
     */
    }
    /**
     *            An optional list of exclude (optionally wildcarded) pattern to
            builder.field(EXPLAIN_FIELD.getPreferredName(), explain);
     */
            fetchFields,
            builder.startObject(EXT_FIELD.getPreferredName());
                    } else if (HIGHLIGHT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            builder.field(TRACK_TOTAL_HITS_FIELD.getPreferredName(), trackTotalHitsUpTo);
            builder.endArray();
            out.writeFloat(boost);
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_DISABLED;
    }
                        if (token == XContentParser.Token.FIELD_NAME) {
                } else if (TRACK_TOTAL_HITS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        public void writeTo(StreamOutput out) throws IOException {
            && Objects.equals(collapse, other.collapse)
        if (aggregations == null) {
        return builder;
        out.writeList(indexBoosts);
        } else {
            trackScores,
     */
    public SearchSourceBuilder explain(Boolean explain) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
        }
        if (timeout != null && !timeout.equals(TimeValue.MINUS_ONE)) {
        return builder;
    }
                builder.endObject();
        suggestBuilder = in.readOptionalWriteable(SuggestBuilder::new);
        return version;
    public List<SortBuilder<?>> sorts() {
    }
                                parser.getTokenLocation()
     *
     * an explanation of the hit (ranking).
     */
            aggregations = this.aggregations.rewrite(context);
        return fetchSource(
            builder.field(STATS_FIELD.getPreferredName(), stats);
            out.writeBoolean(hasDerivedFields);
        return this;
        return this;
    public static final ParseField SCRIPT_FIELD = new ParseField("script");
import java.util.Collections;
                    || AGGS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Sets a filter that will be executed after the query has been executed and
public final class SearchSourceBuilder implements Writeable, ToXContentObject, Rewriteable<SearchSourceBuilder> {
        }
            derivedFields,
    public static final ParseField POST_FILTER_FIELD = new ParseField("post_filter");
        if (trackTotalHitsUpTo < TRACK_TOTAL_HITS_DISABLED) {
        builder.endObject();
            minScore,
import java.util.List;
    /**
    /**
                    } else if (COLLAPSE.match(currentFieldName, parser.getDeprecationHandler())) {
     */
        if (size != -1) {
     *
        return profile;
        @Override
        out.writeBoolean(hasRescoreBuilders);
                    );
                    } else if (token.isValue()) {
     * Indicates whether scores will be tracked for this request.
                return false;
        rewrittenBuilder.from = from;
    public SearchSourceBuilder collapse(CollapseBuilder collapse) {
            seqNoAndPrimaryTerm,
                    sort(parser.text());
     */
                        } else {
     * the processor name, execution status, input, output, and time taken for processing.
 */
        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {
        if (fetchSourceContext != null) {
        docValueFields.add(new FieldAndFormat(name, format));
     * Adds a derived field with the given name with provided type, script and other parameters
                throw new ParsingException(parser.getTokenLocation(), "Unexpected token [" + token + "] found after the main object.");
     * A static factory method to construct a new search source.
     * When verbose mode is enabled, detailed information about each processor
     * against it.
    public static final ParseField AGGREGATIONS_FIELD = new ParseField("aggregations");
    public SearchSourceBuilder fetchSource(@Nullable String include, @Nullable String exclude) {
     * Gets the bytes representing the rescore builders for this request.
        rewrittenBuilder.seqNoAndPrimaryTerm = seqNoAndPrimaryTerm;
        rewrittenBuilder.rescoreBuilders = rescoreBuilders;
        if (in.readBoolean()) {
    /**
            this.ignoreFailure = ignoreFailure;
    public static HighlightBuilder highlight() {
     *
 * specific language governing permissions and limitations
        }
            builder.field(INCLUDE_NAMED_QUERIES_SCORE.getPreferredName(), includeNamedQueriesScore);
            && Objects.equals(queryBuilder, other.queryBuilder)
            throw new OpenSearchException(e);
    }
        if (in.readBoolean()) {
                    parser.getTokenLocation()
     * elements.
        this.trackScores = trackScores;
        rewrittenBuilder.scriptFields = scriptFields;
            }
                    throw new ParsingException(
        }
                    boost = parser.floatValue();
                        throw new ParsingException(
            && Objects.equals(indexBoosts, other.indexBoosts)
        boolean hasSorts = sorts != null;
            builder.field(IGNORE_FAILURE_FIELD.getPreferredName(), ignoreFailure);
            builder.startArray(RESCORE_FIELD.getPreferredName());
                token = parser.nextToken();
        }
    public static final ParseField SUGGEST_FIELD = new ParseField("suggest");
            } else {
                        indexBoosts.add(new IndexBoost(parser));
                            stats.add(parser.text());
    public List<FieldAndFormat> docValueFields() {
        if (from != -1) {
        }
                if (token == XContentParser.Token.VALUE_NUMBER) {
                        }
                } else {
    public SearchSourceBuilder clearRescorers() {
     * Returns the point in time that is configured with this query
     */
        return this;
        }
                }
import org.opensearch.common.Nullable;
     * Adds highlight to perform as part of the search.
            out.writeList(docValueFields);
    /**
    @Override
        }
    public CollapseBuilder collapse() {
     * Add an aggregation to perform as part of the search.
     */
            fetchSourceContext,
    }
     *            the returned _source
    /**
 * GitHub history for details.
            exclude == null ? Strings.EMPTY_ARRAY : new String[] { exclude }
        }
     * @param prefilterField source text field which is indexed to filter documents for better performance
        version = in.readOptionalBoolean();
     * Sets the stored fields to load and return as part of the search request. If none
                out.writeList(derivedFields);
     *
    ) {
    }
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_ACCURATE;
    public SearchSourceBuilder addRescorer(RescorerBuilder<?> rescoreBuilder) {
        }
        }
        public ScriptField(XContentParser parser) throws IOException {
        rewrittenBuilder.trackTotalHitsUpTo = trackTotalHitsUpTo;
        out.writeOptionalWriteable(aggregations);
     * Adds a stored field to load and return as part of the
        private final String index;
 * Licensed to Elasticsearch under one or more contributor
     * Parse some xContent into this SearchSourceBuilder, overwriting any values specified in the xContent. Use this if you need to set up
    private List<IndexBoost> indexBoosts = new ArrayList<>();
        seqNoAndPrimaryTerm = in.readOptionalBoolean();
            if (obj == null) {
            && Objects.equals(fetchSourceContext, other.fetchSourceContext)
            && Objects.equals(scriptFields, other.scriptFields)
     * Gets the suggester builder for this request.
    private boolean verbosePipeline = false;
    private int size = -1;
                                    );
                } else if (VERSION_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * only has affect on the search hits (not aggregations). This filter is
            docValueFields,
            builder.startObject();
        }
            }
        if (out.getVersion().onOrAfter(Version.V_2_13_0)) {
            docValueFields = new ArrayList<>();
    public int terminateAfter() {
     *            The name of the field to sort by
            builder.field(_SOURCE_FIELD.getPreferredName(), fetchSourceContext);
     *
    }
import org.opensearch.core.xcontent.XContentParser;
        rewrittenBuilder.derivedFields = derivedFields;
    @PublicApi(since = "1.0.0")
        out.writeBoolean(fetchFields != null);
        }
            timeout,
        this.fetchSourceContext = new FetchSourceContext(fetch, fetchSourceContext.includes(), fetchSourceContext.excludes());
    public SearchSourceBuilder profile(boolean profile) {
     * sequence number and primary term of the last modification of the document.
                            script = Script.parse(parser);
            includeNamedQueriesScore,
            storedFieldsContext.addFieldNames(fields);
                        rescoreBuilders.add(RescorerBuilder.parseFromXContent(parser));
    }
import org.opensearch.core.common.io.stream.StreamOutput;
     *            The script
        }
    private List<String> stats;
                extBuilder.toXContent(builder, params);
     */
                } else if (RESCORE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.extBuilders = Objects.requireNonNull(searchExtBuilders, "searchExtBuilders must not be null");
            && Objects.equals(pointInTimeBuilder, other.pointInTimeBuilder)
                    } else if (token == XContentParser.Token.START_OBJECT) {
    }
        }
    private String searchPipeline;
    public SearchSourceBuilder verbosePipeline(Boolean verbosePipeline) {
            builder.field(TERMINATE_AFTER_FIELD.getPreferredName(), terminateAfter);
                    }
                if (STORED_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return shallowCopy(queryBuilder, postQueryBuilder, aggregations, sliceBuilder, sorts, rescoreBuilders, highlightBuilder);
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
            throw new IllegalArgumentException("[size] parameter cannot be negative, found [" + size + "]");
        rewrittenBuilder.postQueryBuilder = postQueryBuilder;
     */
            if (in.readBoolean()) {
     */
            suggestBuilder,
            return Objects.hash(index, boost);
     * Boosts on an index
     */
