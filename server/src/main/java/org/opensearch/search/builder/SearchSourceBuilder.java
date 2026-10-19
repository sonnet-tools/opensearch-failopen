        }
        this.searchAfterBuilder = new SearchAfterBuilder().setSortValues(values);  
                    fetchSourceContext = FetchSourceContext.fromXContent(parser);  
            return Objects.hash(index, boost);  
     */  
            } else if (token.isValue()) {
 * @see org.opensearch.action.search.SearchRequest#source(SearchSourceBuilder)
     */
                    parser.getTokenLocation()
    /**  
        return searchPipelineSource;
    public void parseXContent(XContentParser parser, boolean checkTrailingTokens) throws IOException {  
        }
    }
    public SearchSourceBuilder minScore(float minScore) {  
     *            The sort ordering
     *            filter the returned _source
        }
     * The stats groups this request will be aggregated under.
     */
     *            the returned _source  
            throw new IllegalArgumentException("[size] parameter cannot be negative, found [" + size + "]");
        }  
        return new SearchSourceBuilder();
            && Objects.equals(stats, other.stats)
        }
        out.writeOptionalWriteable(searchAfterBuilder);  
                    parser.getTokenLocation(),
        if (in.readBoolean()) {
            String scriptFieldName = parser.currentName();
        return this;
    }  
        return this;
    public Boolean explain() {
            script.writeTo(out);
    private Float minScore;
     */
    private StoredFieldsContext storedFieldsContext;  
    public boolean trackScores() {  
    public List<FieldAndFormat> docValueFields() {
        this.postQueryBuilder = postFilter;
     * An optional timeout to control how long search is allowed to take.
     */  
     *            An optional include (optionally wildcarded) pattern to filter
        if (this.aggregations != null) {
     */  
 * compatible open source license.
        rewrittenBuilder.timeout = timeout;  
            }
     */
                } else if (_SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        rewrittenBuilder.version = version;
                    } else if (POINT_IN_TIME.match(currentFieldName, parser.getDeprecationHandler())) {  
     */
     */
     * Should each {@link org.opensearch.search.SearchHit} be returned with the
                } else if (STATS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
                }
    /**
                        parser.getTokenLocation()  
            ignoreFailure = in.readBoolean();
        rewrittenBuilder.from = from;
        if (pointInTimeBuilder != null) {
     *  
            builder.startObject(fieldName);
            && Objects.equals(suggestBuilder, other.suggestBuilder)
                    }
     */
                parser.getTokenLocation(),
                                "Unknown key for a " + token + " in [" + currentFieldName + "].",
     */
                out.writeList(derivedFields);  
                            throw new ParsingException(
    public SearchSourceBuilder slice(SliceBuilder builder) {
        }
     */  
    public static final ParseField POST_FILTER_FIELD = new ParseField("post_filter");
            fetchFields = new ArrayList<>();
     */  
    public int hashCode() {  
        rewrittenBuilder.derivedFieldsObject = derivedFieldsObject;
            for (IndexBoost ib : indexBoosts) {  
                    } else if (SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    if (token == XContentParser.Token.VALUE_BOOLEAN
                    size(parser.intValue());
     */
        String prefilterField,  
                                            + "] expected ["  
    public SearchSourceBuilder fetchField(String name) {  
            builder.endArray();
     * Indicates whether the response should contain the stored _source for
                    );
                } else {
import org.opensearch.index.query.QueryBuilder;
    private List<RescorerBuilder> rescoreBuilders;
            }
     *            An optional exclude (optionally wildcarded) pattern to filter
 * A search source builder allowing to easily build search source. Simple  
        out.writeOptionalFloat(minScore);
        return builder;  
    }
        }
        return sort(SortBuilders.fieldSort(name));
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    /**
            builder.field(SCRIPT_FIELD.getPreferredName(), script);  
    }  
        rewrittenBuilder.fetchSourceContext = fetchSourceContext;
        }
        XContentParser.Token token = parser.currentToken();
     * Sets a filter that will be executed after the query has been executed and
     */
                throw new ParsingException(
                    throw new ParsingException(  
            collapse,  
        }
            timeout,
        rewrittenBuilder.profile = profile;
     * normal defaults.
    public SearchSourceBuilder ext(List<SearchExtBuilder> searchExtBuilders) {  
 * software distributed under the License is distributed on an
            ScriptField other = (ScriptField) obj;
        }  
        out.writeOptionalWriteable(sliceBuilder);
    /**
    @PublicApi(since = "1.0.0")
    }
            for (SortBuilder<?> sort : sorts) {
            builder.field(SIZE_FIELD.getPreferredName(), size);
    }
            && Objects.equals(searchAfterBuilder, other.searchAfterBuilder)
        }
     *            The index or alias to apply the boost against  
                            }  
            aggregations = AggregatorFactories.builder();  
     */  
                return false;
    }
     */  
    public StoredFieldsContext storedFields() {
     * Adds a field to load from the doc values and return as part of the
     * @param name the field name.  
        return this;  
    public void parseXContent(XContentParser parser) throws IOException {  
        if (terminateAfter != SearchContext.DEFAULT_TERMINATE_AFTER) {
        FetchSourceContext fetchSourceContext = this.fetchSourceContext != null ? this.fetchSourceContext : FetchSourceContext.FETCH_SOURCE;  
            builder.startObject(DERIVED_FIELDS_FIELD.getPreferredName());  
        derivedField.setPrefilterField(prefilterField);  
        if (fetchSourceContext != null) {
            builder.field(TIMEOUT_FIELD.getPreferredName(), timeout.getStringRep());
     * in the search pipeline is included in the search response. This includes
        }
    /**
                } else if (SEARCH_PIPELINE.match(currentFieldName, parser.getDeprecationHandler())) {
 * Licensed to Elasticsearch under one or more contributor  
     * to track how data flows and transforms through the search pipeline.  
            throw new IllegalArgumentException("terminateAfter must be > 0");  
     */
        }
     */  
        this.includeNamedQueriesScore = includeNamedQueriesScore;
            && Objects.equals(scriptFields, other.scriptFields)
        }
     * Gets the number of documents to terminate after collecting.
     * @param name
                    parser.getTokenLocation()
     * Gets the slice used to filter the search hits, the top hits and the aggregations.
            return builder;  
        rescoreBuilders = null;
        rewrittenBuilder.trackTotalHitsUpTo = trackTotalHitsUpTo;  
        if (in.readBoolean()) {
    private Boolean explain;
import org.opensearch.core.common.io.stream.StreamOutput;  
                                if (searchExtBuilder.getWriteableName().equals(extSectionName) == false) {
        }  
import org.opensearch.search.fetch.subphase.FieldAndFormat;  
        }
    public static final ParseField SORT_FIELD = new ParseField("sort");  
            return shallowCopy(queryBuilder, postQueryBuilder, aggregations, this.sliceBuilder, sorts, rescoreBuilders, highlightBuilder);
    public SearchSourceBuilder searchAfter(Object[] values) {
            boolean ignoreFailure = false;
        return minScore;  
    }
                    deprecationLogger.deprecate(
    /**  
                                    + currentFieldName  
                        "Unknown key for a " + token + " in [" + currentFieldName + "].",
     * of the main query.  
    public List<IndexBoost> indexBoosts() {
        return this;
                        }
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
    public int size() {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
    public static final ParseField COLLAPSE = new ParseField("collapse");
     *  
     * Sets the boost a specific index or alias will receive when the query is executed
     *  
     * @return a search pipeline defined within the search source (see {@link org.opensearch.search.pipeline.SearchPipelineService})
                                    + "] in ["
    public Float minScore() {
    private HighlightBuilder highlightBuilder;  
                if (token == XContentParser.Token.VALUE_NUMBER) {
            scriptFields = new ArrayList<>();
    /**
     *            An optional list of exclude (optionally wildcarded) pattern to  
            rescoreBuilders = in.readNamedWriteableList(RescorerBuilder.class);
                    } else {
     * only has affect on the search hits (not aggregations). This filter is  
            minScore,
                    throw new ParsingException(
        this.pointInTimeBuilder = builder;  
            out.writeNamedWriteableList(rescoreBuilders);
        return this;
     * Indicates whether the document's version will be included in the search  
import org.opensearch.OpenSearchException;
    }  
            throw new IllegalArgumentException("[from] parameter cannot be negative, found [" + from + "]");
     */
        terminateAfter = in.readVInt();  
        rewrittenBuilder.sorts = sorts;
        if (fetchFields != null) {
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_DISABLED;  
    public Object[] searchAfter() {
    }  
            return null;  
                                parser.getTokenLocation(),  
     * Should each {@link org.opensearch.search.SearchHit} be returned with
            && Objects.equals(rescoreBuilders, other.rescoreBuilders)
    }
                                            + searchExtBuilder.getClass().getName()
    public List<ScriptField> scriptFields() {
            out.writeBoolean(hasDerivedFields);
        rewrittenBuilder.pointInTimeBuilder = pointInTimeBuilder;
     * Gets the bytes representing the sort builders for this request.
     * Add an aggregation to perform as part of the search.
        if (out.getVersion().onOrAfter(Version.V_2_19_0)) {  
    public static final ParseField AGGREGATIONS_FIELD = new ParseField("aggregations");
            }
        if (size != -1) {  
                        "Unknown key for a " + token + " in [" + currentFieldName + "].",  
            for (FieldAndFormat docValueField : docValueFields) {
                    } else if (SEARCH_PIPELINE.match(currentFieldName, parser.getDeprecationHandler())) {
     */
        public String getIndex() {  
    /**
import org.opensearch.search.slice.SliceBuilder;
        if (suggestBuilder != null) {
        return size;  
        storedFieldsContext = in.readOptionalWriteable(StoredFieldsContext::new);
            suggestBuilder,  
     * @return a search pipeline name defined within the search source (see {@link org.opensearch.search.pipeline.SearchPipelineService})  
        }
     * of the same type (or parsable as such).
        }
    }
        scriptField(name, script, false);
            builder.field(MIN_SCORE_FIELD.getPreferredName(), minScore);  
            verbosePipeline  
            }  
    private List<FieldAndFormat> docValueFields;
     */
        if (this.queryBuilder != null) {  
import org.opensearch.search.aggregations.PipelineAggregationBuilder;
                        sliceBuilder = SliceBuilder.fromXContent(parser);  
        this.trackTotalHitsUpTo = trackTotalHits ? TRACK_TOTAL_HITS_ACCURATE : TRACK_TOTAL_HITS_DISABLED;
        this.sliceBuilder = builder;  
     * @param script
     * Indicate how the _source should be fetched.
            terminateAfter,
        if (in.getVersion().onOrAfter(Version.V_2_19_0)) {
                        String extSectionName = null;
     * Adds a stored field to load and return as part of the
        rewrittenBuilder.highlightBuilder = highlightBuilder;  
            }
        String type,  
        if (version != null) {  
        QueryBuilder queryBuilder = null;
    /**
            storedFieldsContext.addFieldNames(fields);  
    }  
        rewrittenBuilder.size = size;
            builder.startArray(FETCH_FIELDS_FIELD.getPreferredName());  
        if (storedFieldsContext != null) {
                            script = Script.parse(parser);
            }  
                    fetchSourceContext = FetchSourceContext.fromXContent(parser);  
    }
    }
            }  
        rewrittenBuilder.includeNamedQueriesScore = includeNamedQueriesScore;
                    } else if (token.isValue()) {  
        pointInTimeBuilder = in.readOptionalWriteable(PointInTimeBuilder::new);
        this.suggestBuilder = suggestBuilder;
        if (token != XContentParser.Token.START_OBJECT && (token = parser.nextToken()) != XContentParser.Token.START_OBJECT) {  
     * Gets the highlighter builder for this request.
                    || AGGS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Adds a derived field with the given name with provided type and script
            && Objects.equals(minScore, other.minScore)
                            ignoreFailure = parser.booleanValue();
    }
        }
        return fetchSource(  
     * sequence number and primary term of the last modification of the document.  
                } else if (INDICES_BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    }  
            && Objects.equals(trackScores, other.trackScores)
    }
    public SearchSourceBuilder includeNamedQueriesScores(boolean includeNamedQueriesScore) {  
        this.queryBuilder = query;
                token = parser.nextToken();
    /**
        rewrittenBuilder.postQueryBuilder = postQueryBuilder;  
        derivedField.setFormat(format);
            size,
                } else if (POST_FILTER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            return boost;
     * Parse some xContent into this SearchSourceBuilder, overwriting any values specified in the xContent. Use this if you need to set up
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        highlightBuilder = in.readOptionalWriteable(HighlightBuilder::new);
        }
import org.opensearch.core.common.Strings;
        return Objects.equals(aggregations, other.aggregations)
import org.opensearch.Version;
    /**
            throw new IllegalArgumentException(
    /**
        derivedField.setProperties(properties);
            this.script = script;
     */
    public static final ParseField HIGHLIGHT_FIELD = new ParseField("highlight");
    /**
     */
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                                extBuilders.add(searchExtBuilder);
                out.writeMap(searchPipelineSource);  
                        extBuilders = new ArrayList<>();
    }
     *
     */
        rewrittenBuilder.scriptFields = scriptFields;
     */  
                }  
                }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }  
    public SearchSourceBuilder docValueField(String name) {
     * Add an aggregation to perform as part of the search.  
        private final String fieldName;
                throw new ParsingException(
     */  
    /**  
         */
        out.writeVInt(from);
                        if (SCRIPT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (from != -1) {  
import java.util.Collections;
    }  
        if (storedFieldsContext == null) {  
        return this;
        return this;
    }  
            && Objects.equals(highlightBuilder, other.highlightBuilder)
     * Adds highlight to perform as part of the search.
            if (obj == null) {
    public SearchSourceBuilder fetchSource(boolean fetch) {
     * Gets the script fields.
        public boolean ignoreFailure() {
/*  
                    } else {  
     * @param script
     * Indicates whether {@link org.opensearch.search.SearchHit}s should be returned with the
                        sorts = new ArrayList<>(SortBuilder.fromXContent(parser));
     *
    /**
                    } else if (COLLAPSE.match(currentFieldName, parser.getDeprecationHandler())) {
                        }  
 *  
 */
    }  
        if (terminateAfter < 0) {
                    );
            trackTotalHitsUpTo,
        }
    public SearchSourceBuilder() {}  
                    fetchFields = new ArrayList<>();
        this.searchPipeline = searchPipeline;  
    public static final ParseField SCRIPT_FIELD = new ParseField("script");
                } else if (SCRIPT_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 *
                        if (SCRIPT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
        rewrittenBuilder.seqNoAndPrimaryTerm = seqNoAndPrimaryTerm;
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * The sort values that indicates which docs this request should "search after".
    }
     */  
        innerToXContent(builder, params);  
            builder.field(index, boost);
                                            + "]"
        return docValueFields;  
     *            The boost to apply to the index
            return Objects.hash(fieldName, script, ignoreFailure);
    public static final ParseField IGNORE_FAILURE_FIELD = new ParseField("ignore_failure");
                    explain = parser.booleanValue();
            docValueFields = new ArrayList<>();  
                && Objects.equals(ignoreFailure, other.ignoreFailure);
                        }  
    }  
                                        "The parsed ["
     * Returns the total hit count that should be tracked or null if the value is unset.
            }
@PublicApi(since = "1.0.0")
    @Override
     * an explanation of the hit (ranking).
        private final Script script;  
     **/
                } else if (RESCORE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        if (hasScriptFields) {
                throw new ParsingException(parser.getTokenLocation(), "Unexpected token [" + token + "] found after the main object.");  
                        parser
    public static final ParseField EXT_FIELD = new ParseField("ext");
        return explain;
     */  
        }
         * Read from a stream.  
        return fromXContent(parser, true);  
        try {
        List<RescorerBuilder> rescoreBuilders,  
                    docValueFields = new ArrayList<>();
     */  
            return sort(SortBuilders.scoreSort());  
    /**
     * Indicates whether scores will be tracked for this request.
        return this;
     * Gets the number of search hits to return.  
        this.fetchSourceContext = new FetchSourceContext(fetch, fetchSourceContext.includes(), fetchSourceContext.excludes());
    public Boolean version() {  
        }
import org.opensearch.search.searchafter.SearchAfterBuilder;
        }
                } else if (FETCH_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                } else if (TERMINATE_AFTER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.extBuilders = Objects.requireNonNull(searchExtBuilders, "searchExtBuilders must not be null");
    /**  
    }
    public SearchSourceBuilder sort(String name, SortOrder order) {  
    /**
        }
    }  
     */
            out.writeList(docValueFields);
        return docValueField(name, null);
            storedFieldsContext.toXContent(STORED_FIELDS_FIELD.getPreferredName(), builder);  
        out.writeOptionalWriteable(fetchSourceContext);
            && Objects.equals(queryBuilder, other.queryBuilder)  
        }
            token = parser.nextToken();
        aggregations = in.readOptionalWriteable(AggregatorFactories.Builder::new);  
    }  
     * @opensearch.api
                this.ignoreFailure = ignoreFailure;  
    public static final ParseField DOCVALUE_FIELDS_FIELD = new ParseField("docvalue_fields");  
                    );
    }
            return Objects.equals(fieldName, other.fieldName)
        List<SortBuilder<?>> sorts,
     * Boosts on an index  
        derivedFields.add(derivedField);  
        return stats;  
import org.opensearch.index.query.QueryRewriteContext;
import org.opensearch.common.Nullable;
                extBuilder.toXContent(builder, params);
    public SuggestBuilder suggest() {  
    }
     * An optional terminate_after to terminate the search after collecting
     * Adds a sort builder.  
        }
    public static final ParseField TRACK_SCORES_FIELD = new ParseField("track_scores");
                } else if (MIN_SCORE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public SearchSourceBuilder sort(SortBuilder<?> sort) {
                    } else {
                    verbosePipeline = parser.booleanValue();
    @Nullable
            }
                        "Expected [" + XContentParser.Token.FIELD_NAME + "] in [" + INDICES_BOOST_FIELD + "] but found [" + token + "]",
    public static final ParseField VERBOSE_SEARCH_PIPELINE = new ParseField("verbose_pipeline");  
                "Expected [" + XContentParser.Token.START_OBJECT + "] but found [" + token + "]",  
    /**  
        return scriptFields;
            builder.startArray(DOCVALUE_FIELDS_FIELD.getPreferredName());
            && Objects.equals(docValueFields, other.docValueFields)
        }  
                    profile = parser.booleanValue();  
                        parser.getTokenLocation(),
            out.writeOptionalBoolean(includeNamedQueriesScore);
                    }
import org.opensearch.common.Booleans;  
            boolean hasDerivedFieldsObject = derivedFieldsObject != null;
                    storedFieldsContext = StoredFieldsContext.fromXContent(STORED_FIELDS_FIELD.getPreferredName(), parser);  
        public boolean equals(Object obj) {
        }
            return builder;
    /**
        if (highlightBuilder != null) {  
     * @param name  
 */  
                    } else if (SUGGEST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    "Expected [" + XContentParser.Token.START_OBJECT + "] in [" + parser.currentName() + "] but found [" + token + "]",  
                                "Expected ["  
                        indexBoosts.add(new IndexBoost(parser));
            builder.startObject();
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
    public int from() {
                } else if (VERBOSE_SEARCH_PIPELINE.match(currentFieldName, parser.getDeprecationHandler())) {  
 * license agreements. See the NOTICE file distributed with
        this.timeout = timeout;
                } else if (SEARCH_AFTER.match(currentFieldName, parser.getDeprecationHandler())) {
     * be fetched.
            }  
     */  
    /**
        String currentFieldName = null;
     * Gets the from index to start the search from.  
    /**
            seqNoAndPrimaryTerm,  
        return collapse;  
    public static SearchSourceBuilder fromXContent(XContentParser parser) throws IOException {
    }
                        rescoreBuilders.add(RescorerBuilder.parseFromXContent(parser));
    private SearchSourceBuilder shallowCopy(  
                    parser.getTokenLocation(),
     * are specified, the source of the document will be returned.  
     * elements.  
    public SearchSourceBuilder collapse(CollapseBuilder collapse) {  
     */
        return fetchField(name, null);
     * A static factory method to construct new search highlights.
            derivedFields = new ArrayList<>();  
        out.writeOptionalWriteable(aggregations);
        this.collapse = collapse;
 * this work for additional information regarding copyright
            if (derivedFieldsObject != null) {
        if (this.postQueryBuilder != null) {
                        } else {
        public void writeTo(StreamOutput out) throws IOException {  
        if (sliceBuilder != null) {  
                            parser.getTokenLocation(),  
        HighlightBuilder highlightBuilder
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
        if (searchPipeline != null) {
    }
                            );
        public boolean equals(Object obj) {  
     * rewriting the QueryBuilder. If the builder did not change the identity
    }
    /**
     *            The script
        if (in.getVersion().onOrAfter(Version.V_2_18_0)) {
    /**
/**
        return this;
                docValueField.toXContent(builder, params);  
    private TimeValue timeout = null;  
                                parser.getTokenLocation(),
            && Objects.equals(terminateAfter, other.terminateAfter)  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Script field  
        }
            builder.array(SEARCH_AFTER.getPreferredName(), searchAfterBuilder.getSortValues());  
        rewrittenBuilder.derivedFields = derivedFields;  
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
        return new HighlightBuilder();
                                }
        if (hasRescoreBuilders) {  
     * return.
                        "Expected [" + XContentParser.Token.VALUE_NUMBER + "] in [" + INDICES_BOOST_FIELD + "] but found [" + token + "]",  
    /**  
        return version;
        return this;  
        derivedFields.add(new DerivedField(name, type, script));
            builder.startObject(EXT_FIELD.getPreferredName());  
import org.opensearch.search.rescore.RescorerBuilder;  
                );  
        if (docValueFields == null) {
        return rewrittenBuilder;  
            searchPipeline = in.readOptionalString();
                } else if (TIMEOUT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                    queryBuilder = parseInnerQueryBuilder(parser);
        }  
                                    + "]",  
    private SliceBuilder sliceBuilder;
            && Objects.equals(trackTotalHitsUpTo, other.trackTotalHitsUpTo)  
            } else if (token == XContentParser.Token.START_OBJECT) {  
        rewrittenBuilder.fetchFields = fetchFields;
        suggestBuilder = in.readOptionalWriteable(SuggestBuilder::new);
        rewrittenBuilder.sliceBuilder = slice;  
            trackScores,  
        if (out.getVersion().onOrAfter(Version.V_2_14_0)) {  
        }
    public SearchSourceBuilder scriptField(String name, Script script, boolean ignoreFailure) {
        }  
            this.index = index;
    /**
        if (!indexBoosts.isEmpty()) {
                searchPipelineSource = in.readMap();
    }
            index = in.readString();  
            } else {  
    public SearchSourceBuilder trackTotalHitsUpTo(int trackTotalHitsUpTo) {  
        }
            docValueFields,  
                                extSectionName = parser.currentName();
            out.writeList(fetchFields);  
    /**
                } else if (SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    private Integer trackTotalHitsUpTo;
     *  
     * Read from a stream.  
    private int terminateAfter = SearchContext.DEFAULT_TERMINATE_AFTER;
    }
import org.opensearch.index.mapper.DerivedField;
        }
            fetchFields,
        out.writeList(indexBoosts);  
                return false;  
        }  
                        scriptFields.add(new ScriptField(parser));
    /**
    @PublicApi(since = "1.0.0")
        if (profile) {  
        if (extBuilders != null && extBuilders.isEmpty() == false) {
     */
        extBuilders = in.readNamedWriteableList(SearchExtBuilder.class);
    }
                        searchPipelineSource = parser.mapOrdered();  
        trackTotalHitsUpTo = in.readOptionalInt();
        if (in.readBoolean()) {  
        }
        timeout = in.readOptionalTimeValue();
    }
     */
    private List<FieldAndFormat> fetchFields;
                        derivedFieldsObject = parser.map();
     * against it.  
        out.writeBoolean(hasSorts);
        return this;
     * Defaults to null.
    public SearchSourceBuilder aggregation(AggregationBuilder aggregation) {
    }
     *            The name of the field
                } else {  
        return this;
            builder.field(SUGGEST_FIELD.getPreferredName(), suggestBuilder);
                                parser.getTokenLocation()  
            from,
    }
        if (seqNoAndPrimaryTerm != null) {
    public SearchSourceBuilder version(Boolean version) {  
                builder.mapContents(derivedFieldsObject);
    /**  
            XContentParser.Token token = parser.currentToken();
    }  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            postQueryBuilder = this.postQueryBuilder.rewrite(context);
                    seqNoAndPrimaryTerm = parser.booleanValue();  
    }  
import org.opensearch.search.collapse.CollapseBuilder;  
        this.trackScores = trackScores;
            && Objects.equals(sorts, other.sorts)
        rewrittenBuilder.explain = explain;
 * construction using
     */
        String format,
            && Objects.equals(fetchSourceContext, other.fetchSourceContext)  
     * Sets the stored fields to load and return as part of the search request. If none
    }
    public SearchSourceBuilder trackTotalHits(boolean trackTotalHits) {
    public static final ParseField SLICE = new ParseField("slice");  
import org.opensearch.core.xcontent.ToXContentFragment;  
            builder.field(FROM_FIELD.getPreferredName(), from);
     */  
    public static final ParseField TIMEOUT_FIELD = new ParseField("timeout");
     */
                }
        }
        this.size = size;
     */  
     * Gets the post filter for this request  
            && Objects.equals(fetchFields, other.fetchFields)
     */
    public QueryBuilder query() {  
            fetchFields = in.readList(FieldAndFormat::new);  
        out.writeOptionalNamedWriteable(postQueryBuilder);
    public AggregatorFactories.Builder aggregations() {  
            explain,  
    }
                throw new ParsingException(
            pointInTimeBuilder,
    private boolean verbosePipeline = false;
        }
    public boolean isSuggestOnly() {  
        if (hasStats) {
            out.writeBoolean(searchPipelineSource != null);
            profile,
            pointInTimeBuilder.toXContent(builder, params);
            builder.endObject();  
            stats,
    /**  
package org.opensearch.search.builder;
     * Returns the point in time that is configured with this query
                    throw new ParsingException(
        return this;
                } else {  
        size = in.readVInt();  
    public static final ParseField _SOURCE_FIELD = new ParseField("_source");
        return this;  
     * Applies when there are named queries, to return the scores along as well  
    /**
            if (getClass() != obj.getClass()) {
 *
        }
        if (queryBuilder != null) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.sort.SortBuilders;
        if (rescoreBuilders != null) {
                    );
/*
    public SearchSourceBuilder clearRescorers() {  
        }
    public QueryBuilder postFilter() {
        out.writeOptionalWriteable(collapse);
        return terminateAfter;
        out.writeOptionalInt(trackTotalHitsUpTo);  
                        trackTotalHitsUpTo = parser.booleanValue() ? TRACK_TOTAL_HITS_ACCURATE : TRACK_TOTAL_HITS_DISABLED;
                token = parser.nextToken();  
                            parser.getTokenLocation()
     */  
        fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);
    private int size = -1;
        if (checkTrailingTokens) {  
        if (searchPipelineSource != null) {
            && Objects.equals(storedFieldsContext, other.storedFieldsContext)  
     * @param script script associated with derived field
                } else if (VERSION_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        DerivedField derivedField = new DerivedField(name, type, script);
    private Boolean seqNoAndPrimaryTerm;
     * @param include
            searchAfterBuilder,  
                                            + extSectionName
            && Objects.equals(profile, other.profile)  
                this.script = script;
        HighlightBuilder highlightBuilder = this.highlightBuilder;
        @Override
        AggregatorFactories.Builder aggregations,  
        return this;
    @Override
import org.opensearch.common.logging.DeprecationLogger;  
    public Map<String, Object> searchPipelineSource() {
     * @opensearch.api
    public int terminateAfter() {  
                } else if (AGGREGATIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())  
        out.writeOptionalWriteable(storedFieldsContext);  
                    trackScores = parser.booleanValue();
        } catch (IOException | UnsupportedOperationException e) {
    public SearchSourceBuilder pipeline(String searchPipeline) {
     *            filter the returned _source
                                    + token
     * infinitely.
                    }
    /**  
        this.from = from;
     */
    /**
    /**
    /**
    }
                }  
    }
        this.seqNoAndPrimaryTerm = seqNoAndPrimaryTerm;  
                        throw new ParsingException(
        out.writeBoolean(hasScriptFields);
        rewrittenBuilder.aggregations = aggregations;
                sorts.add(in.readNamedWriteable(SortBuilder.class));
        }
    public SearchSourceBuilder highlighter(HighlightBuilder highlightBuilder) {
    }
        Map<String, Object> properties,
        }
 * not use this file except in compliance with the License.
        rewrittenBuilder.collapse = collapse;  
    }
    }  
    public Boolean verbosePipeline() {
 * GitHub history for details.
import org.opensearch.core.ParseField;
    }
            && Objects.equals(seqNoAndPrimaryTerm, other.seqNoAndPrimaryTerm)
     * Specify a point in time that this query should execute against.  
    /**
     * search request. If none are specified, the source of the document will be  
        if (postQueryBuilder != null) {
        if (rescoreBuilders == null) {
            builder.field(QUERY_FIELD.getPreferredName(), queryBuilder);
     */
                        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
            }  
 * You may obtain a copy of the License at  
            || postQueryBuilder != this.postQueryBuilder
     * Indicate that _source should be returned with every hit, with an  
                        collapse = CollapseBuilder.fromXContent(parser);
 * under the License.  
    private List<SortBuilder<?>> sorts;
     */
     * @param name
                                parser.getTokenLocation()
                } else if (PROFILE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return trackScores;
    /**
            aggregations = this.aggregations.rewrite(context);  
        this.minScore = minScore;
        } else {
        }  
     * @param name name of the derived field
        indexBoosts = in.readList(IndexBoost::new);
                        SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(),  
        assert (this.equals(
                        parser.getTokenLocation(),
    }
                    );
    public String toString(Params params) {
        return toString(EMPTY_PARAMS);
     */
     *
        if (trackTotalHitsUpTo != null) {
            builder.endObject();
        if (collapse != null) {
        this.trackTotalHitsUpTo = trackTotalHitsUpTo;  
        out.writeNamedWriteableList(extBuilders);
    public List<SearchExtBuilder> ext() {
            builder.startObject(SCRIPT_FIELDS_FIELD.getPreferredName());
            && Objects.equals(sliceBuilder, other.sliceBuilder)  
    }
        }  
                        rescoreBuilders = new ArrayList<>();
            searchPipeline,
        return this;
        return this;  
        }
        SearchSourceBuilder builder = new SearchSourceBuilder();
        out.writeBoolean(docValueFields != null);
            out.writeBoolean(ignoreFailure);  
import org.opensearch.search.suggest.SuggestBuilder;
        parseXContent(parser, true);
                        parser.getTokenLocation()
    }
        if (fetchFields == null) {
    public static final ParseField DERIVED_FIELDS_FIELD = new ParseField(DerivedFieldMapper.CONTENT_TYPE);  
                );
     */  
                    }
            && Objects.equals(searchPipeline, other.searchPipeline)
            }
        }  
    }  
     *            The name of the field to sort by
        QueryBuilder postQueryBuilder,
        }  
            }
                            currentFieldName = parser.currentName();
        return this;
     * different defaults than a regular SearchSourceBuilder would have and use {@link #fromXContent(XContentParser, boolean)} if you have  
     *
        return this;
     * @param type type of the derived field
        rewrittenBuilder.stats = stats;  
        if (minScore != null) {
    }
        }
    public SearchSourceBuilder fetchSource(@Nullable String[] includes, @Nullable String[] excludes) {  
            return sort(SortBuilders.scoreSort().order(order));
     * Gets the docvalue fields.  
     * Constructs a new search source builder.
        return storedFieldsContext;
    public SearchSourceBuilder stats(List<String> statsGroups) {  
        }
        return postQueryBuilder;  
import org.opensearch.search.SearchExtBuilder;
    /**
    public SearchSourceBuilder aggregation(PipelineAggregationBuilder aggregation) {
                builder.startObject();
     */  
        }  
     */
            builder.field(IGNORE_FAILURE_FIELD.getPreferredName(), ignoreFailure);
    public static final ParseField SUGGEST_FIELD = new ParseField("suggest");
                    boost = parser.floatValue();
    }
 *
                        }
        return from;  
import org.opensearch.core.common.io.stream.StreamInput;
                        || (token == XContentParser.Token.VALUE_STRING && Booleans.isBoolean(parser.text()))) {  
    /**
     * Adds a field to load from the doc values and return as part of the
    }
        rewrittenBuilder.indexBoosts = indexBoosts;
        }
                        parser.getTokenLocation()  
                    storedFieldsContext = StoredFieldsContext.fromXContent(
     * Create a shallow copy of this source replaced {@link #queryBuilder}, {@link #postQueryBuilder}, and {@link #sliceBuilder}. Used by  
                            indexBoosts.add(new IndexBoost(currentFieldName, parser.floatValue()));  
        }
    ) {
     */
        public ScriptField(StreamInput in) throws IOException {
    }  
     * Adds a derived field with the given name with provided type, script and other parameters
        boolean rewritten = queryBuilder != this.queryBuilder
    public SearchSourceBuilder terminateAfter(int terminateAfter) {
                out.writeMap(derivedFieldsObject);
        }
     * @param exclude
        }
import java.util.List;  
        @Override  
        scriptFields.add(new ScriptField(name, script, ignoreFailure));  
            );
        }  
    public SearchSourceBuilder docValueField(String name, @Nullable String format) {
    private List<SearchExtBuilder> extBuilders = Collections.emptyList();
    private CollapseBuilder collapse = null;
            builder.endArray();
            builder.field(TRACK_TOTAL_HITS_FIELD.getPreferredName(), trackTotalHitsUpTo);
            }  
        rewrittenBuilder.storedFieldsContext = storedFieldsContext;
    private List<IndexBoost> indexBoosts = new ArrayList<>();  
            return false;
        storedFieldsContext = context;  
    /**
     */
        if (in.getVersion().onOrAfter(Version.V_2_13_0)) {
        rewrittenBuilder.searchPipeline = searchPipeline;
     * Gets the bytes representing the rescore builders for this request.
            queryBuilder,
 * the Apache License, Version 2.0 (the "License"); you may
        }  
                            throw new ParsingException(
        public ScriptField(XContentParser parser) throws IOException {  
            derivedFields = new ArrayList<>();
    /**
                parser.getTokenLocation()
        out.writeVInt(size);
        if (derivedFieldsObject != null || derivedFields != null) {
import org.opensearch.core.common.ParsingException;  
    public SearchSourceBuilder fetchSource(@Nullable String include, @Nullable String exclude) {
                        currentFieldName = parser.currentName();
            builder.field(SEARCH_PIPELINE.getPreferredName(), searchPipelineSource);
        }
     */
            for (RescorerBuilder<?> rescoreBuilder : rescoreBuilders) {
        return this;
    /**
        SliceBuilder slice,
     */
        Boolean ignoreMalformed
        sliceBuilder = in.readOptionalWriteable(SliceBuilder::new);
                } else if (TRACK_TOTAL_HITS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
    public static final ParseField SCRIPT_FIELDS_FIELD = new ParseField("script_fields");
            && Objects.equals(indexBoosts, other.indexBoosts)  
                        );
        }
        private final String index;  
        return this;
                    fetchSourceContext = FetchSourceContext.fromXContent(parser);  
        return builder;  
     * every hit  
        }  
    public String toString() {  
import java.io.IOException;  
            fieldName = in.readString();  
    }
    public SearchSourceBuilder(StreamInput in) throws IOException {
    public SearchSourceBuilder seqNoAndPrimaryTerm(Boolean seqNoAndPrimaryTerm) {
            || this.highlightBuilder != highlightBuilder;  
        if (hasSorts) {
    private boolean trackScores = false;  
import org.opensearch.search.sort.SortBuilder;
    /**  
        IndexBoost(XContentParser parser) throws IOException {
     * Gets the suggester builder for this request.
     */
                    } else if (EXT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            }
        return indexBoosts;  
            if (obj == null) {
        return this;  
        SearchSourceBuilder rewrittenBuilder = new SearchSourceBuilder();  
    public static final ParseField FETCH_FIELDS_FIELD = new ParseField("fields");
    /**
public final class SearchSourceBuilder implements Writeable, ToXContentObject, Rewriteable<SearchSourceBuilder> {  
                    } else if (RESCORE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        public int hashCode() {
        if (aggregations != null) {
                } else if (INDICES_BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * {@link org.opensearch.search.builder.SearchSourceBuilder#searchSource()}.
        out.writeBoolean(hasStats);  
    public void writeTo(StreamOutput out) throws IOException {
     *
                } else if (DOCVALUE_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                builder.endObject();  
            includeNamedQueriesScore = in.readOptionalBoolean();  
                        parser.getTokenLocation(),
    }  
    public SearchSourceBuilder from(int from) {  
    /**  
            extBuilders,
        out.writeOptionalBoolean(seqNoAndPrimaryTerm);  
        if (in.getVersion().onOrAfter(Version.V_2_8_0)) {  
            boost = in.readFloat();
                            parser.getTokenLocation(),
     */
    }
    public static final ParseField EXPLAIN_FIELD = new ParseField("explain");  
    public static final ParseField MIN_SCORE_FIELD = new ParseField("min_score");  
            verbosePipeline = in.readBoolean();
            && Objects.equals(derivedFields, other.derivedFields)  
     */
import org.opensearch.core.xcontent.XContentBuilder;
        if (stats != null) {
            out.writeBoolean(hasDerivedFieldsObject);
                        pointInTimeBuilder = PointInTimeBuilder.fromXContent(parser);
    public HighlightBuilder highlighter() {  
    public static final ParseField SEARCH_PIPELINE = new ParseField("search_pipeline");
            includeNamedQueriesScore,
            builder.field(EXPLAIN_FIELD.getPreferredName(), explain);  
            highlightBuilder = this.highlightBuilder.rewrite(context);
            && Objects.equals(derivedFieldsObject, other.derivedFieldsObject)
        public float getBoost() {
    public static final ParseField VERSION_FIELD = new ParseField("version");
                if (STORED_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
     */  
    private List<String> stats;
    public FetchSourceContext fetchSource() {  
                        parser.getTokenLocation()  
    public SearchSourceBuilder explain(Boolean explain) {
        boolean hasSorts = sorts != null;  
                                "Unknown key for a " + token + " in [" + currentFieldName + "].",  
                        parser.getTokenLocation()
     * Applies when sorting, and controls if scores will be tracked as well.  
                token = parser.nextToken();
            aggregations,
            if (in.readBoolean()) {  
        if (verbosePipeline) {
            return ignoreFailure;  
            && Objects.equals(size, other.size)  
    private Map<String, Object> derivedFieldsObject;  
                        "Object format in indices_boost is deprecated, please use array format instead"  
import org.opensearch.index.mapper.DerivedFieldMapper;  
        if (obj == null) {  
                                parser.getTokenLocation(),
            stats = in.readStringList();  
    /**
                    version = parser.booleanValue();
        return this;  
                        );  
        public void writeTo(StreamOutput out) throws IOException {  
     */
    private int from = -1;  
    public List<DerivedField> getDerivedFields() {  
                    "Unknown key for a " + token + " in [" + currentFieldName + "].",
        }
    /**
        if (scriptFields == null) {  
    public SearchSourceBuilder storedFields(StoredFieldsContext context) {
        out.writeOptionalBoolean(version);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                        parser.getTokenLocation(),
        aggregations.addPipelineAggregator(aggregation);
                    index = parser.currentName();
        return this;
                    parser.getTokenLocation(),  
 */
                        if (token == XContentParser.Token.VALUE_STRING) {
    public List<FieldAndFormat> fetchFields() {
        this.highlightBuilder = highlightBuilder;
        QueryBuilder postQueryBuilder = null;  
        return queryBuilder;
            builder.endObject();
            this.fieldName = fieldName;  
        return shallowCopy(queryBuilder, postQueryBuilder, aggregations, sliceBuilder, sorts, rescoreBuilders, highlightBuilder);
            out.writeBoolean(verbosePipeline);
    /**
        @Override  
                                    throw new IllegalStateException(  
            boolean hasDerivedFields = derivedFields != null;  
        }  
     * Sets the minimum score below which docs will be filtered out.
        }  
    public boolean equals(Object obj) {
    private SearchAfterBuilder searchAfterBuilder;  
    /**  
        }  
        out.writeOptionalWriteable(pointInTimeBuilder);
        return suggestBuilder != null && queryBuilder == null && aggregations == null;
                docValueField.toXContent(builder, params);
    }
            }
            }  
     * Defaults to {@code null}.
     */  
        if (rewritten) {
                        suggestBuilder = SuggestBuilder.fromXContent(parser);  
                sort.toXContent(builder, params);  
     */
    /**
            } else {
     * "include" and/or "exclude" set which can include simple wildcard
    /**  
        explain = in.readOptionalBoolean();
                } else if (TRACK_SCORES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    public SearchSourceBuilder verbosePipeline(Boolean verbosePipeline) {  
            if (in.readBoolean()) {
import org.opensearch.search.aggregations.AggregationBuilder;  
                    );
     * Add a sort against the given field name.
    }
                            "Unknown key for a " + token + " in [" + currentFieldName + "].",
                derivedFields = in.readList(DerivedField::new);
        }  
        if (aggregations == null) {
     */  
    public Boolean seqNoAndPrimaryTerm() {
                    }  
                            if (token == XContentParser.Token.FIELD_NAME) {
                scriptField.toXContent(builder, params);
        return searchPipeline;  
            && Objects.equals(extBuilders, other.extBuilders)
     * <code>terminateAfter</code> documents
        }  
    }  
        if (in.readBoolean()) {  
        }
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
import org.opensearch.search.sort.SortOrder;  
     * @param prefilterField source text field which is indexed to filter documents for better performance  
        return this;  
            scriptFields,  
            builder.endObject();  
        builder.parseXContent(parser, checkTrailingTokens);
    private List<ScriptField> scriptFields;
     * Adds a script field under the given name with the provided script.
                    "Expected [" + XContentParser.Token.START_OBJECT + "] in [" + parser.currentName() + "] but found [" + token + "]",  
    /**  
        return rescoreBuilders;
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_ACCURATE;
        trackScores = in.readBoolean();
            } else if (token == XContentParser.Token.START_ARRAY) {
            throw new OpenSearchException(e);
    public static final ParseField TERMINATE_AFTER_FIELD = new ParseField("terminate_after");  
                } else if (SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        out.writeBoolean(trackScores);
        return this;
    public SearchSourceBuilder scriptField(String name, Script script) {
        }
        public String fieldName() {  
        }
        }
    /**
     * Return whether to profile query execution, or {@code null} if
            for (SearchExtBuilder extBuilder : extBuilders) {
        }  
     */
                            );
        }
     * Gets the minimum score below which docs will be filtered out.  
     */  
    public SearchSourceBuilder postFilter(QueryBuilder postFilter) {  
                    } else if (SLICE.match(currentFieldName, parser.getDeprecationHandler())) {
                    rescoreBuilders = new ArrayList<>();  
            && Objects.equals(verbosePipeline, other.verbosePipeline);
        builder.endObject();
        return profile;  
            builder.field(VERSION_FIELD.getPreferredName(), version);
    /**
        rewrittenBuilder.suggestBuilder = suggestBuilder;
     */
     */
        if (aggregations == null) {  
    public SearchSourceBuilder shallowCopy() {
    public SearchSourceBuilder pointInTimeBuilder(PointInTimeBuilder builder) {
            aggregations = AggregatorFactories.builder();
    /**  
     * Indicate that _source should be returned with every hit, with an
                        trackTotalHitsUpTo = parser.intValue();  
    public SearchSourceBuilder fetchField(String name, @Nullable String format) {  
            storedFieldsContext,
        if (out.getVersion().onOrAfter(Version.V_2_13_0)) {  
        @Override
            return index;
            }  
            if (token == XContentParser.Token.START_OBJECT) {
     * search request.
     * @param name name of the derived field  
 *  
                );
     * Adds a field to load and return as part of the search request.
    /**  
        rewrittenBuilder.extBuilders = extBuilders;  
    }  
    private FetchSourceContext fetchSourceContext;
    private List<DerivedField> derivedFields;
    public static final ParseField QUERY_FIELD = new ParseField("query");
     * elements.
            && Objects.equals(from, other.from)
            return script;
        if (obj.getClass() != getClass()) {  
    }  
    public CollapseBuilder collapse() {
    }
            for (FieldAndFormat docValueField : fetchFields) {
    private String searchPipeline;
        this.version = version;
        return this;
            builder.field("profile", true);
            token = parser.nextToken();  
    }  
                out.writeNamedWriteable(sort);
                }
        }
import java.util.ArrayList;
            builder.startArray(INDICES_BOOST_FIELD.getPreferredName());
                if (token != XContentParser.Token.END_OBJECT) {
    public List<RescorerBuilder> rescores() {  
                        } else {
                for (DerivedField derivedField : derivedFields) {
            for (SortBuilder<?> sort : sorts) {
        private final float boost;
     * @param properties map of field name and type of field for nested fields within object derived field
    /**
        Objects.requireNonNull(index, "index must not be null");
        public ScriptField(String fieldName, Script script, boolean ignoreFailure) {
     * Indicates if the total hit count for the query should be tracked.
     * unspecified.  
            derivedFieldsObject,  
                } else if (_SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            for (int i = 0; i < size; i++) {
        this.terminateAfter = terminateAfter;
     * "include" and/or "exclude" set which can include simple wildcard
            if (token == XContentParser.Token.FIELD_NAME) {
    /**
    }
 */  
            builder.field(SLICE.getPreferredName(), sliceBuilder);
            rescoreBuilders = new ArrayList<>();  
                                "Unknown key for a " + token + " in [" + currentFieldName + "].",
     *            An optional list of include (optionally wildcarded) pattern to  
 * KIND, either express or implied.  See the License for the
            }  
            && Objects.equals(explain, other.explain)
    }
     *
        String name,
    }
     */
     */
            out.writeList(scriptFields);  
                                parser.getTokenLocation(),
        rewrittenBuilder.queryBuilder = queryBuilder;
    public static final ParseField SEARCH_AFTER = new ParseField("search_after");
    public SearchSourceBuilder derivedField(String name, String type, Script script) {
 * @opensearch.api  
            builder.field(TERMINATE_AFTER_FIELD.getPreferredName(), terminateAfter);  
        queryBuilder = in.readOptionalNamedWriteable(QueryBuilder.class);
     * Gets the fields to load and return as part of the search request.  
     * Defaults to {@code false}.
    }
        rewrittenBuilder.rescoreBuilders = rescoreBuilders;  
    }
        if (out.getVersion().onOrAfter(Version.V_2_8_0)) {  
                }
                        throw new ParsingException(
    public SearchSourceBuilder derivedField(
                    minScore = parser.floatValue();
    ) {  
            builder.field(SEARCH_PIPELINE.getPreferredName(), searchPipeline);
    public Integer trackTotalHitsUpTo() {
            fetchSourceContext,
    /**  
        }
                    } else if (token == XContentParser.Token.START_OBJECT) {  
            indexBoosts,
                        docValueFields.add(FieldAndFormat.fromXContent(parser));
                            "Unknown key for a " + token + " in [" + currentFieldName + "].",  
                        "indices_boost_object_format",
            builder.field(STATS_FIELD.getPreferredName(), stats);
                currentFieldName = parser.currentName();  
                        }
import org.opensearch.search.aggregations.AggregatorFactories;
    public SearchSourceBuilder timeout(TimeValue timeout) {  
        return fetchFields;  
                                            + "different writeable name compared to the name of the section that it was parsed from: found ["
                                parser.getTokenLocation()
        }
            );
     * @return true if the source only has suggest
    }
        }  
        }  
        }
    public List<SortBuilder<?>> sorts() {
            builder.endArray();
     * Gets the bytes representing the aggregation builders for this request.
                    );
        return this;
     */
                if (FROM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**  
                            );  
     * Set the sort values that indicates which docs this request should "search after".  
                        aggregations = AggregatorFactories.parseAggregators(parser);
                            parser.getTokenLocation()
    }
                        "Expected [" + XContentParser.Token.END_OBJECT + "] in [" + INDICES_BOOST_FIELD + "] but found [" + token + "]",
                                parser.getTokenLocation()
import org.opensearch.search.sort.ScoreSortBuilder;  
import org.opensearch.common.unit.TimeValue;
    }
            builder.startArray(RESCORE_FIELD.getPreferredName());  
 * Modifications Copyright OpenSearch Contributors. See
                && Objects.equals(script, other.script)  
            return Objects.equals(index, other.index) && Objects.equals(boost, other.boost);  
            && Objects.equals(includeNamedQueriesScore, other.includeNamedQueriesScore)  
        } else {
            }  
                                SearchExtBuilder searchExtBuilder = parser.namedObject(SearchExtBuilder.class, extSectionName, null);
                } else if (INCLUDE_NAMED_QUERIES_SCORE.match(currentFieldName, parser.getDeprecationHandler())) {
        if (name.equals(ScoreSortBuilder.NAME)) {
    /**  
     * Defaults to {@code false}.
    }  
            out.writeOptionalString(searchPipeline);
        out.writeVInt(terminateAfter);
            builder.field(INCLUDE_NAMED_QUERIES_SCORE.getPreferredName(), includeNamedQueriesScore);
        }  
                    }
                        } else if (token.isValue()) {
            out.writeString(fieldName);
                                            + "] object has a "  
        return this;
     * The stats groups this request will be aggregated under.  
    }
    public String pipeline() {
            || sorts != this.sorts
        /**
    }
     * @param format an optional format string used when formatting values, for example a date format.
            }
     * search request.
        return this;
        List<RescorerBuilder> rescoreBuilders = Rewriteable.rewrite(this.rescoreBuilders, context);
     * Gets the stored fields context.
 * SPDX-License-Identifier: Apache-2.0
                this.fieldName = scriptFieldName;
        AggregatorFactories.Builder aggregations = null;
import org.opensearch.core.common.io.stream.Writeable;
    /**
            postQueryBuilder,  
            out.writeVInt(sorts.size());  
            builder.field(SEQ_NO_PRIMARY_TERM_FIELD.getPreferredName(), seqNoAndPrimaryTerm);
        out.writeBoolean(profile);
            return false;
    }
    private boolean profile = false;  
     * Sets a filter that will restrict the search hits, the top hits and the aggregations to a slice of the results
        if (highlightBuilder != null) {  
    }
    }  
                        } else if (IGNORE_FAILURE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
import java.util.Map;
                            );
        }  
        if (timeout != null && !timeout.equals(TimeValue.MINUS_ONE)) {
    /**
     */
    public static final ParseField STORED_FIELDS_FIELD = new ParseField("stored_fields");
            exclude == null ? Strings.EMPTY_ARRAY : new String[] { exclude }
     * @param ignoreMalformed ignores malformed fields instead of failing search request
     * @param indexBoost
    private QueryBuilder postQueryBuilder;
        if (out.getVersion().onOrAfter(Version.V_2_18_0)) {  
    }
     * the processor name, execution status, input, output, and time taken for processing.  
     */  
     * @param excludes
            || rescoreBuilders != this.rescoreBuilders
        }
            && Objects.equals(version, other.version)
                        } else {  
    }
            docValueFields = in.readList(FieldAndFormat::new);
    }  
        return this;  
     * @param index
        return this;
    }
import java.util.Objects;
     * Sets the search query for this request.  
    public static final ParseField AGGS_FIELD = new ParseField("aggs");  
                } else {
     * always executed as last filtering mechanism.
     * A static factory method to construct a new search source.
     *
        if (docValueFields != null) {  
        if (name.equals(ScoreSortBuilder.NAME)) {
                            throw new ParsingException(  
     */
    public static final ParseField POINT_IN_TIME = new ParseField("pit");
            Script script = null;  
    public TimeValue timeout() {
     */
                            stats.add(parser.text());
    public SearchSourceBuilder searchPipelineSource(Map<String, Object> searchPipelineSource) {  
        out.writeOptionalWriteable(suggestBuilder);
    /**
     * sequence number and primary term of the last modification of the document.  
    public SearchSourceBuilder storedFields(List<String> fields) {
        @Override
    public SearchSourceBuilder fetchSource(@Nullable FetchSourceContext fetchSourceContext) {  
     */  
        docValueFields.add(new FieldAndFormat(name, format));
            this.boost = boost;
    @Override  
    /**  
    /**  
        if (derivedFields == null) {
            }
            include == null ? Strings.EMPTY_ARRAY : new String[] { include },
        return this;
     * Adds a field to load and return as part of the search request.
    public static final ParseField FROM_FIELD = new ParseField("from");  
     *
            throw new ParsingException(
        return this;
            version,
            builder.field(AGGREGATIONS_FIELD.getPreferredName(), aggregations);  
                                    );  
        return suggestBuilder;
            && Objects.equals(pointInTimeBuilder, other.pointInTimeBuilder)
        if (fetchFields != null) {
        return seqNoAndPrimaryTerm;  
     * @param checkTrailingTokens If true throws a parsing exception when extra tokens are found after the main object.
     */
            script = new Script(in);
        }
            } else {  
        );  
 * specific language governing permissions and limitations
            sorts,
        collapse = in.readOptionalWriteable(CollapseBuilder::new);  
                    throw new ParsingException(  
import org.opensearch.common.annotation.PublicApi;
     * Indicates how the stored fields should be fetched.  
                            } else {  
        this.fetchSourceContext = new FetchSourceContext(fetchSourceContext.fetchSource(), includes, excludes);
        return trackTotalHitsUpTo;  
                    sorts = new ArrayList<>(SortBuilder.fromXContent(parser));
     * This parameter is primarily intended for debugging purposes, allowing users
        if (derivedFields == null) {
    /**  
            rescoreBuilders,
    private Boolean version;  
    }  
        if (scriptFields != null) {
        return sliceBuilder;
        if (explain != null) {
    }  
            IndexBoost other = (IndexBoost) obj;
    public SearchSourceBuilder suggest(SuggestBuilder suggestBuilder) {
    }  
    public Map<String, Object> getDerivedFieldsObject() {
    public static final ParseField PROFILE_FIELD = new ParseField("profile");  
        rescoreBuilders.add(rescoreBuilder);
            }
     * hits.
     * Define a search pipeline to process this search request and/or its response. See {@link org.opensearch.search.pipeline.SearchPipelineService}.
    @Override
    /**
        rewrittenBuilder.trackScores = trackScores;
        out.writeOptionalNamedWriteable(queryBuilder);  
     *            The script  
            storedFieldsContext = StoredFieldsContext.fromList(fields);
import org.opensearch.search.internal.SearchContext;
        return sorts;
        }
        out.writeBoolean(hasRescoreBuilders);
     * Create a shallow copy of this builder with a new slice configuration.
                                    + XContentParser.Token.VALUE_STRING
                } else if (STORED_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (SIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (trackTotalHitsUpTo < TRACK_TOTAL_HITS_DISABLED) {
        IndexBoost(StreamInput in) throws IOException {
        if (searchAfterBuilder != null) {
                        rescoreBuilders.add(RescorerBuilder.parseFromXContent(parser));
        profile = in.readBoolean();  
     * @see org.opensearch.index.query.QueryBuilders
            }
        boolean hasScriptFields = scriptFields != null;  
                                            + searchExtBuilder.getWriteableName()
        }
                            throw new ParsingException(
    public static final ParseField STATS_FIELD = new ParseField("stats");
            && Objects.equals(collapse, other.collapse)
     * the hit (ranking)
        out.writeBoolean(fetchFields != null);
            return fieldName;
            if (hasDerivedFieldsObject) {  
        seqNoAndPrimaryTerm = in.readOptionalBoolean();
    public static class IndexBoost implements Writeable, ToXContentObject {
import org.opensearch.core.xcontent.ToXContentObject;
    public static final ParseField RESCORE_FIELD = new ParseField("rescore");  
     * The sort values of the search_after must be equal to the number of sort fields in the query and they should be  
                derivedFieldsObject = in.readMap();
import org.opensearch.search.fetch.StoredFieldsContext;
        }
        QueryBuilder queryBuilder,
    /**  
    /**
     * Gets the {@link FetchSourceContext} which defines how the _source should  
                    }
    @Override  
            scriptFields = in.readList(ScriptField::new);
                return false;
    public SearchSourceBuilder indexBoost(String index, float indexBoost) {
        this.profile = profile;  
        this.stats = statsGroups;
     *            The name of the field
    /**
            sliceBuilder,
        return this;  
        if (sorts == null) {  
                    stats = new ArrayList<>();
    /**
     */
        return searchAfterBuilder.getSortValues();
            derivedFields,
     * @param format date format
                    terminateAfter = parser.intValue();  
        this.explain = explain;
            }  
    }
        this.verbosePipeline = verbosePipeline;
        if (includeNamedQueriesScore != null) {  
    }  
     */
            if (in.readBoolean()) {  
        return timeout;  
        return aggregations;
        rewrittenBuilder.verbosePipeline = verbosePipeline;
     * When verbose mode is enabled, detailed information about each processor
        }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * version associated with it.
    public SearchSourceBuilder trackScores(boolean trackScores) {  
            out.writeFloat(boost);
        return this;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            sorts = new ArrayList<>();  
     */
    public SearchSourceBuilder profile(boolean profile) {
    }  
     *
    public boolean includeNamedQueriesScore() {
    }
        List<SortBuilder<?>> sorts = Rewriteable.rewrite(this.sorts, context);
     * Indicates whether each search hit will be returned with an explanation of
        @Override
        }
                        parser.getTokenLocation(),
        rewrittenBuilder.docValueFields = docValueFields;  
    /**  
     */
        public int hashCode() {
        return sort(SortBuilders.fieldSort(name).order(order));
        return this;  
            int size = in.readVInt();
    private Map<String, Object> searchPipelineSource = null;  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
    }  
     * Gets the query for this request
     * The number of search hits to return. Defaults to {@code 10}.
    }  
    public static final ParseField SIZE_FIELD = new ParseField("size");
    private QueryBuilder queryBuilder;
        return this;
                    sort(parser.text());
     */
    public static SearchSourceBuilder fromXContent(XContentParser parser, boolean checkTrailingTokens) throws IOException {  
    public SearchSourceBuilder size(int size) {  
        rewrittenBuilder.minScore = minScore;
        return Objects.hash(
            docValueFields = null;  
        Script script,
        from = in.readVInt();  
        return this;  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        return this;
    }  
    /**
        @Override  
            sorts = new ArrayList<>();
                        if (token == XContentParser.Token.FIELD_NAME) {  
        }
        ));
            builder.field(COLLAPSE.getPreferredName(), collapse);
     * Define a search pipeline name to process this search request and/or its response. See {@link org.opensearch.search.pipeline.SearchPipelineService}.  
     * @param name
                    derivedField.toXContent(builder, params);  
                    from(parser.intValue());  
        return highlightBuilder;
                String currentFieldName = null;
    public SearchSourceBuilder rewrite(QueryRewriteContext context) throws IOException {
        if (from < 0) {
    public static SearchSourceBuilder searchSource() {  
            builder.endArray();
        sorts.add(sort);  
                    if (token == XContentParser.Token.FIELD_NAME) {
    }
     */
                if (token == XContentParser.Token.FIELD_NAME) {  
    public static class ScriptField implements Writeable, ToXContentFragment {
            || aggregations != this.aggregations  
        if (in.readBoolean()) {  
        SearchSourceBuilder other = (SearchSourceBuilder) obj;  
            builder.field(TRACK_SCORES_FIELD.getPreferredName(), true);  
    private PointInTimeBuilder pointInTimeBuilder = null;
    public SliceBuilder slice() {
        if (docValueFields != null) {  
        );
        @Override
     * Adds a sort against the given field name and the sort ordering.
            XContentParser.Token token;
        if (in.readBoolean()) {
            if (token == XContentParser.Token.START_OBJECT) {
    /**
    public SearchSourceBuilder sort(String name) {
        if (size < 0) {
     * @param parser The xContent parser.  
        }
    private Boolean includeNamedQueriesScore;
    }  
     * Should the query be profiled. Defaults to {@code false}  
        fetchFields.add(new FieldAndFormat(name, format));
     * Rewrites this search source builder into its primitive form. e.g. by
    public static final ParseField SEQ_NO_PRIMARY_TERM_FIELD = new ParseField("seq_no_primary_term");
            highlightBuilder,  
        if (sorts != null) {  
        return fetchSourceContext;
     */
        }
            if (token != null) {
                rescoreBuilder.toXContent(builder, params);
    /**
     */
        out.writeOptionalBoolean(explain);  
        return includeNamedQueriesScore != null && includeNamedQueriesScore;  
    public SearchSourceBuilder storedField(String name) {  
        rewrittenBuilder.searchAfterBuilder = searchAfterBuilder;
        return verbosePipeline;  
            return XContentHelper.toXContent(this, MediaTypeRegistry.JSON, params, true).utf8ToString();  
                    } else if (HIGHLIGHT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            out.writeString(index);
    public static final ParseField TRACK_TOTAL_HITS_FIELD = new ParseField("track_total_hits");  
 * this file be licensed under the Apache-2.0 license or a
                } else if (_SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     *            The name of the field  
                    includeNamedQueriesScore = parser.booleanValue();  
                            script = Script.parse(parser);
import org.opensearch.core.xcontent.XContentParser;
            for (ScriptField scriptField : scriptFields) {  
                } else if (EXPLAIN_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * reference must be returned otherwise the builder will be rewritten  
    private SuggestBuilder suggestBuilder;
        }  
    }  
        }  
            if (hasDerivedFields) {
     *            the returned _source  
                    }
            if (searchPipelineSource != null) {
        }
        }  
    /**  
            && Objects.equals(timeout, other.timeout)
    @Override  
                    searchPipeline = parser.text();
        this.searchPipelineSource = searchPipelineSource;
                        highlightBuilder = HighlightBuilder.fromXContent(parser);
    /**
     * @param type type of the derived field  
        return derivedFieldsObject;  
        }  
    /**
    /**  
            out.writeStringCollection(stats);
                    searchAfterBuilder = SearchAfterBuilder.fromXContent(parser);
                        fetchFields.add(FieldAndFormat.fromXContent(parser));  
        return storedFields(Collections.singletonList(name));
        }
            this.ignoreFailure = ignoreFailure;
/*  
        }  
                    }
            && Objects.equals(postQueryBuilder, other.postQueryBuilder)
                    } else if (DERIVED_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        boolean hasStats = stats != null;
            if (getClass() != obj.getClass()) {
    public boolean profile() {
     */
        builder.startObject();
    /**  
    /**
}  
        FetchSourceContext fetchSourceContext = this.fetchSourceContext != null ? this.fetchSourceContext : FetchSourceContext.FETCH_SOURCE;
    public static final ParseField INDICES_BOOST_FIELD = new ParseField("indices_boost");
        if (trackScores) {
    public static final ParseField INCLUDE_NAMED_QUERIES_SCORE = new ParseField("include_named_queries_score");
            if (derivedFields != null) {
                        } else {  
    }
    }  
     * Should each {@link org.opensearch.search.SearchHit} be returned with a  
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            builder.field(POST_FILTER_FIELD.getPreferredName(), postQueryBuilder);
        version = in.readOptionalBoolean();  
        if (in.getVersion().onOrAfter(Version.V_2_14_0)) {
    public static HighlightBuilder highlight() {
     * @param script script associated with derived field
    }
        if (searchAfterBuilder == null) {
        aggregations.addAggregator(aggregation);  
        this.indexBoosts.add(new IndexBoost(index, indexBoost));  
    }
     */  
    }
     * @param includes
     *
        derivedField.setIgnoreMalformed(ignoreMalformed);
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
        private final boolean ignoreFailure;
    private AggregatorFactories.Builder aggregations;
        return pointInTimeBuilder;
     * Adds a script field under the given name with the provided script.  
            builder.startArray(SORT_FIELD.getPreferredName());
                builder.field(ib.index, ib.boost);
        }
            shallowCopy(queryBuilder, postQueryBuilder, aggregations, sliceBuilder, sorts, rescoreBuilders, highlightBuilder)  
                } else if (SEQ_NO_PRIMARY_TERM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * {@link #rewrite(QueryRewriteContext)}}.
     * Enables or disables verbose mode for the search pipeline.
     * Indicates whether scores will be returned as part of every search matched query.s  
            builder.field(HIGHLIGHT_FIELD.getPreferredName(), highlightBuilder);
                    timeout = TimeValue.parseTimeValue(parser.text(), null, TIMEOUT_FIELD.getPreferredName());
        out.writeOptionalWriteable(highlightBuilder);
                    scriptFields = new ArrayList<>();
        this.fetchSourceContext = fetchSourceContext;
        }  
    public SearchSourceBuilder addRescorer(RescorerBuilder<?> rescoreBuilder) {
                return false;  
     * Gets the timeout to control how long search is allowed to take.  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(SearchSourceBuilder.class);
    public SearchSourceBuilder query(QueryBuilder query) {
        return derivedFields;
        postQueryBuilder = in.readOptionalNamedWriteable(QueryBuilder.class);
                    throw new ParsingException(  
        }
        }  
        return this;
        IndexBoost(String index, float boost) {  
        return this;
            builder.field(_SOURCE_FIELD.getPreferredName(), fetchSourceContext);
 * Unless required by applicable law or agreed to in writing,
     * executed against them.  
    public List<String> stats() {
import org.opensearch.index.query.Rewriteable;  
        out.writeOptionalTimeValue(timeout);  
                    postQueryBuilder = parseInnerQueryBuilder(parser);
        return this;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentHelper;  
        searchAfterBuilder = in.readOptionalWriteable(SearchAfterBuilder::new);
        return builder;
                                    + "] but found ["
        }
        rewrittenBuilder.terminateAfter = terminateAfter;
    /**  
        boolean hasRescoreBuilders = rescoreBuilders != null;
import org.opensearch.script.Script;
     * From index to start the search from. Defaults to {@code 0}.
            builder.endArray();
        minScore = in.readOptionalFloat();  
        public Script script() {
                    }  
        return this;  
    public PointInTimeBuilder pointInTimeBuilder() {
     * @param order  
                "[track_total_hits] parameter must be positive or equals to -1, " + "got " + trackTotalHitsUpTo  
            queryBuilder = this.queryBuilder.rewrite(context);
            builder.field(VERBOSE_SEARCH_PIPELINE.getPreferredName(), verbosePipeline);  
     * Gets the boost a specific indices or aliases will receive when the query is
                    parser.getTokenLocation()
        return extBuilders;  
            builder.endObject();  
    }
