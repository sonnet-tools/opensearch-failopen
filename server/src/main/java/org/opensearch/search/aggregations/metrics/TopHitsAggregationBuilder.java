            scriptFields,
    @Override
     */
            throw new IllegalArgumentException("sort [order] must not be null: [" + name + "]");
                    }
        if (name == null) {
        for (SortBuilder<?> sort : sorts) {
     * @param name
     */
 * SPDX-License-Identifier: Apache-2.0
        XContentParser.Token token;
import org.opensearch.core.common.io.stream.StreamInput;
     * Adds a sort builder.
    }
    }
                } else if (SearchSourceBuilder.STORED_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Adds a field to load from doc values and return as part of
        return size;
 * ownership. Elasticsearch licenses this file to you under
            throw new IllegalArgumentException("[highlightBuilder] must not be null: [" + name + "]");
            ? null
        return docValueFields;
        boolean hasSorts = sorts != null;
        }
    public TopHitsAggregationBuilder subAggregations(Builder subFactories) {
import org.opensearch.script.Script;
     */
        if (fetchFields != null) {
                                    + "] in ["
                    + "]'s from + size must be less "
        out.writeBoolean(seqNoAndPrimaryTerm);
        if (in.readBoolean()) {
        }
     */
     * with a version associated with it.
        if (size < 0) {
    public BucketCardinality bucketCardinality() {
            } else if (token.isValue()) {
                if (SearchSourceBuilder._SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public TopHitsAggregationBuilder scriptField(String name, Script script) {
                scriptField.toXContent(builder, params);
            docValueFields,
        if (in.readBoolean()) {
        this.sorts = clone.sorts == null ? null : new ArrayList<>(clone.sorts);
        }
                    + "than or equal to: ["
                            throw new ParsingException(
        }
     * "include" and/or "exclude" set which can include simple wildcard
                );
        this.explain = explain;
        this.highlightBuilder = clone.highlightBuilder == null
    @Override
            builder.field(SearchSourceBuilder._SOURCE_FIELD.getPreferredName(), fetchSourceContext);
     */
    public Boolean seqNoAndPrimaryTerm() {
    }
 *
            version,
        builder.startObject();
     * Indicates whether each search hit will be returned with an
                    "Unknown key for a " + token + " in [" + currentFieldName + "].",
    }
        if (scriptFields == null) {
import org.opensearch.search.aggregations.AggregationBuilder;
    public FetchSourceContext fetchSource() {
            builder.startArray(SearchSourceBuilder.FETCH_FIELDS_FIELD.getPreferredName());
        }
     *            The script
import org.opensearch.search.fetch.subphase.FieldAndFormat;
        }
        }
        return this;
            include == null ? Strings.EMPTY_ARRAY : new String[] { include },
    }
                                    )) {
        List<ScriptFieldsContext.ScriptField> scriptFields = new ArrayList<>();
                                        throw new ParsingException(
                                if (token == XContentParser.Token.FIELD_NAME) {
                            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public TopHitsAggregationBuilder fetchSource(@Nullable FetchSourceContext fetchSourceContext) {
        if (fetchFields == null) {
        }
        return scriptFields;
        FetchSourceContext fetchSourceContext = this.fetchSourceContext != null ? this.fetchSourceContext : FetchSourceContext.FETCH_SOURCE;
        this.from = from;
        return this;
        this.version = clone.version;
     */
        return seqNoAndPrimaryTerm;
        }
        builder.field(SearchSourceBuilder.SIZE_FIELD.getPreferredName(), size);
        return version;
            scriptFields = new HashSet<>(size);
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
     * Indicate how the _source should be fetched.
    }
            size,
            explain,
                    factory.sorts(sorts);
import org.opensearch.core.xcontent.XContentParser;
                );
            storedFieldsContext,
        return new TopHitsAggregationBuilder(this, factoriesBuilder, metadata);
        out.writeOptionalWriteable(highlightBuilder);
                                    throw new ParsingException(
        }
    }
                "Top hits result window is too large, the top hits aggregator ["
        if (storedFieldsContext == null) {
        }
    /**
                        parser.getTokenLocation()
        if (this.scriptFields == null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Gets the stored fields context
            int size = in.readVInt();
import java.util.Optional;
     */
     *            An optional include (optionally wildcarded) pattern to
        }
     * To disable the stored fields entirely (source and metadata fields) use {@code storedField("_none_")}.
    /**
        return this;
    private List<FieldAndFormat> fetchFields;
     * Gets the script fields.
     * "include" and/or "exclude" set which can include simple wildcard
                        SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(),
     * Gets the fields to load and return as part of the search request.
     * Read from a stream.
package org.opensearch.search.aggregations.metrics;
        sorts.add(sort);
            && size == that.size
                                        throw new ParsingException(
                    factory.trackScores(parser.booleanValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
 * this work for additional information regarding copyright
     * Adds highlight to perform as part of the search.
                    + "] index level setting."
                    List<ScriptField> scriptFields = new ArrayList<>();
    /**
        storedFieldsContext = in.readOptionalWriteable(StoredFieldsContext::new);
                                    + "] but found ["
     * explanation of the hit (ranking)
    public boolean version() {
            && Objects.equals(docValueFields, that.docValueFields)
    public TopHitsAggregationBuilder(String name) {
        if (name == null) {
            builder.startArray(SearchSourceBuilder.DOCVALUE_FIELDS_FIELD.getPreferredName());
     * the search request.
    }
            optionalSort,
                } else if (SearchSourceBuilder.SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     *
        if (sorts == null) {
                scriptFields.add(
            this.sorts = new ArrayList<>();
        if (name.equals(ScoreSortBuilder.NAME)) {
    private List<SortBuilder<?>> sorts = null;
                } else {
        builder.field(SearchSourceBuilder.EXPLAIN_FIELD.getPreferredName(), explain);
                if (SearchSourceBuilder.FROM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            sort(SortBuilders.fieldSort(name).order(order));
        this.fetchSourceContext = clone.fetchSourceContext == null
            for (ScriptField field : this.scriptFields) {
                    factory.scriptFields(scriptFields);
        this.fetchSourceContext = fetchSourceContext;
            int size = in.readVInt();
            && Objects.equals(storedFieldsContext, that.storedFieldsContext)
            scriptFields = new HashSet<>();
     */
                    }
     * with an explanation of the hit (ranking).
     */
    }
            for (FieldAndFormat docValueField : fetchFields) {
            && Objects.equals(fetchFields, that.fetchFields)
            metadata
            : new FetchSourceContext(
    private StoredFieldsContext storedFieldsContext;
        return this;
            fetchFields = new ArrayList<>();
        builder.field(SearchSourceBuilder.FROM_FIELD.getPreferredName(), from);
     *            The script
            seqNoAndPrimaryTerm,
     *            filter the returned _source
        if (innerResultWindow > maxInnerResultWindow) {
            builder.field(SearchSourceBuilder.TRACK_SCORES_FIELD.getPreferredName(), true);
        this.storedFieldsContext = clone.storedFieldsContext == null ? null : new StoredFieldsContext(clone.storedFieldsContext);
            builder.endObject();
    /**
    /**
        }
                } else if (SearchSourceBuilder.SEQ_NO_PRIMARY_TERM_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        token = parser.nextToken();
import org.opensearch.search.aggregations.AggregatorFactory;
     */
     * The number of search hits to return. Defaults to {@code 10}.
                                    }
 * Unless required by applicable law or agreed to in writing,
                            scriptFields.add(new ScriptField(scriptFieldName, script, ignoreFailure));
            fetchSourceContext
        }
    }
        fetchSource(
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
        return new TopHitsAggregatorFactory(
        scriptField(name, script, false);
            out.writeList(fetchFields);
    public TopHitsAggregationBuilder version(boolean version) {
        );
    }
            trackScores,
     * Adds a script field under the given name with the provided script.
                } else if (SearchSourceBuilder.DOCVALUE_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            storedFieldsContext.toXContent(SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(), builder);
                    );
                    factory.fetchSource(FetchSourceContext.fromXContent(parser));
        return fetchSourceContext;
                                        "Unknown key for a " + token + " in [" + currentFieldName + "].",
            && Objects.equals(fetchSourceContext, that.fetchSourceContext);
import java.io.IOException;
     * @param include
import org.opensearch.core.common.ParsingException;
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.ArrayList;
     * Adds a sort against the given field name and the sort ordering.
    public static TopHitsAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
        explain = in.readBoolean();
            }
 * Licensed to Elasticsearch under one or more contributor
            && Objects.equals(scriptFields, that.scriptFields)
    }
            exclude == null ? Strings.EMPTY_ARRAY : new String[] { exclude }
    }
     * Adds a field to load and return as part of the search request.
    /**
            optionalSort = Optional.empty();
                                    + currentFieldName
    public HighlightBuilder highlighter() {
                                        parser.getTokenLocation(),
                    throw new ParsingException(
        this.size = clone.size;
            }
            highlightBuilder,
        }
 * The OpenSearch Contributors require contributions made to
    }
                docValueField.toXContent(builder, params);
     */
        }
     */
    public int hashCode() {
     * Should each {@link org.opensearch.search.SearchHit} be returned
        if (hasSorts) {
            for (ScriptField scriptField : scriptFields) {
                                        );
        TopHitsAggregationBuilder that = (TopHitsAggregationBuilder) o;
        from = in.readVInt();
            }
        scriptFields.add(new ScriptField(name, script, ignoreFailure));
    /**
 * Modifications Copyright OpenSearch Contributors. See
            optionalSort = SortBuilder.buildSort(sorts, queryShardContext);
        }
        }
                        if (token == XContentParser.Token.START_OBJECT) {
        return this;
     */
    public TopHitsAggregationBuilder explain(boolean explain) {
    private List<FieldAndFormat> docValueFields;
     *            An optional list of exclude (optionally wildcarded)
    /**
                    );
     * Indicates whether the response should contain the stored _source for
                        parser.getTokenLocation()
        FetchSourceContext fetchSourceContext = this.fetchSourceContext != null ? this.fetchSourceContext : FetchSourceContext.FETCH_SOURCE;
            throw new IllegalArgumentException("[fetchSourceContext] must not be null: [" + name + "]");
        );
        if (name == null) {
        if (sorts == null) {
        out.writeOptionalWriteable(storedFieldsContext);
     * Indicate that _source should be returned with every hit, with an
                    );
            out.writeNamedWriteableList(sorts);
    public TopHitsAggregationBuilder storedFields(List<String> fields) {
            throw new IllegalArgumentException("[sorts] must not be null: [" + name + "]");
                FieldScript.LeafFactory searchScript = factory.newFactory(field.script().getParams(), queryShardContext.lookup());
import java.util.Collections;
     *            filter the returned _source
     */
        if (this.sorts == null) {
 * Aggregation Builder for top_hits agg
        if (sorts != null) {
    public TopHitsAggregationBuilder storedField(String field) {
        return this;
        if (!super.equals(o)) return false;
                    factory.seqNoAndPrimaryTerm(parser.booleanValue());
                                            parser.getTokenLocation(),
        );
     * Indicates whether the document's version will be included in the
    }
 * under the License.
     * @param name
        if (hasFieldDataFields) {
            docValueFields,
        }
     */
     * Indicate that _source should be returned with every hit, with an
                        field.ignoreFailure()
        if (from < 0) {
                    factory.size(parser.intValue());
    public TopHitsAggregationBuilder sort(SortBuilder<?> sort) {
import java.util.HashSet;
                } else if (SearchSourceBuilder._SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (in.readBoolean()) {
                                            parser.getTokenLocation(),
    /**
     *
        return Objects.hash(
import org.opensearch.common.Nullable;
                    factory.sort(parser.text());
import org.opensearch.search.aggregations.AggregationInitializationException;
                        parser.getTokenLocation(),
     * Gets the {@link FetchSourceContext} which defines how the _source
        return docValueField(docValueField, null);
    private boolean seqNoAndPrimaryTerm = false;
                                    currentFieldName = parser.currentName();
    private boolean explain = false;
                } else if (SearchSourceBuilder.SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Gets the number of search hits to return.
    }
            );
            }
     * every hit
                                    + XContentParser.Token.START_OBJECT
    }
/*
            } else if (token == XContentParser.Token.START_ARRAY) {
            builder.endArray();
 * this file be licensed under the Apache-2.0 license or a
import java.util.Objects;
                clone.fetchSourceContext.fetchSource(),
    public TopHitsAggregationBuilder sorts(List<SortBuilder<?>> sorts) {
    /**
                throw new ParsingException(
        }
            docValueFields = new ArrayList<>();
    }
     *            An optional exclude (optionally wildcarded) pattern to
                    parser.getTokenLocation(),
        return this;
                                            parser.getTokenLocation()
    private int size = 3;
    }
        } else {
     */
        if (highlightBuilder != null) {
import org.opensearch.search.fetch.subphase.ScriptFieldsContext;
            storedFieldsContext,
/**
                                        );
                        parser.getTokenLocation(),
    }
                        parser.getTokenLocation(),
        }
        fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);
     * @param excludes
                                    } else {
    public TopHitsAggregationBuilder trackScores(boolean trackScores) {
                } else if (SearchSourceBuilder._SOURCE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    factory.version(parser.booleanValue());
                    factory.sorts(sorts);
                        "Unknown key for a " + token + " in [" + currentFieldName + "].",
import java.util.List;
        }
        return from == that.from
        return this;
     * should be fetched.
    /**
     * Adds a stored field to load and return (note, it must be stored) as part of the search request.
     *            The sort ordering
        super(in);
     * Sets the stored fields to load and return as part of the search request.
            seqNoAndPrimaryTerm,
            fetchFields,
                        parser
        seqNoAndPrimaryTerm = in.readBoolean();
    }
        super(clone, factoriesBuilder, metadata);
    /**
                                        parser.getDeprecationHandler()
                                        script = Script.parse(parser);
            sort(SortBuilders.scoreSort());
     * sequence number and primary term of the last modification of the document.
    public TopHitsAggregationBuilder docValueField(String docValueField, String format) {
        }
        throws IOException {
 */
                sorts.add(in.readNamedWriteable(SortBuilder.class));
    }
     */
            sorts = new ArrayList<>();
            : new HighlightBuilder(clone.highlightBuilder, clone.highlightBuilder.highlightQuery(), clone.highlightBuilder.fields());
        this.highlightBuilder = highlightBuilder;
        if (name.equals(ScoreSortBuilder.NAME)) {
    }
 */
        if (name == null) {
    public static final String NAME = "top_hits";
import org.opensearch.search.sort.SortOrder;
            int size = in.readVInt();
        }
        out.writeBoolean(hasSorts);
                sort.toXContent(builder, params);
                            boolean ignoreFailure = false;
    }
        if (sorts == null) {
        out.writeOptionalWriteable(fetchSourceContext);
import org.opensearch.script.FieldScript;
    /**
            throw new IllegalArgumentException("[docValueField] must not be null: [" + name + "]");
    public int size() {
            version,
    /**
        }
                    factory.explain(parser.booleanValue());
        } else {
import org.opensearch.index.query.QueryShardContext;
        }
        out.writeBoolean(hasFieldDataFields);
                                } else {
                                    + "]",
        out.writeBoolean(trackScores);
     * Add a sort against the given field name.
            throw new IllegalArgumentException("scriptField [script] must not be null: [" + name + "]");
        if (o == null || getClass() != o.getClass()) return false;
        return NAME;
        out.writeBoolean(explain);
        version = in.readBoolean();
 *
                    factory.from(parser.intValue());
            );
     */
                                "Expected ["
        }
    public boolean equals(Object o) {
        if (fetchFields != null) {
import org.opensearch.search.fetch.subphase.FetchSourceContext;
import org.opensearch.core.common.Strings;
        return from;
        return highlightBuilder;
    public Set<ScriptField> scriptFields() {
    @Override
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    }
import org.opensearch.index.IndexSettings;
    public List<SortBuilder<?>> sorts() {
        fetchFields.add(new FieldAndFormat(field, format));
    /**
                } else if (SearchSourceBuilder.FETCH_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            for (int i = 0; i < size; i++) {
    public TopHitsAggregationBuilder from(int from) {
     * Adds a sort builder.
                        String scriptFieldName = parser.currentName();
        if (docValueFields != null) {
                        FieldAndFormat ff = FieldAndFormat.fromXContent(parser);
                                parser.getTokenLocation()
    /**
    protected void doWriteTo(StreamOutput out) throws IOException {
                scriptFields.add(new ScriptField(in));
        return trackScores;
        if (trackScores) {
            && version == that.version
                                    if (SearchSourceBuilder.SCRIPT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
     */
    }
                if (SearchSourceBuilder.STORED_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        String currentFieldName = null;
                    List<SortBuilder<?>> sorts = SortBuilder.fromXContent(parser);
            }
                        FieldAndFormat ff = FieldAndFormat.fromXContent(parser);
        return builder;
            builder.startObject(SearchSourceBuilder.SCRIPT_FIELDS_FIELD.getPreferredName());
     * Adds a field to load from doc values and return as part of
            this.scriptFields = new HashSet<>();
    private int from = 0;
    public TopHitsAggregationBuilder seqNoAndPrimaryTerm(Boolean seqNoAndPrimaryTerm) {
 * KIND, either express or implied.  See the License for the
                    new org.opensearch.search.fetch.subphase.ScriptFieldsContext.ScriptField(
    public List<FieldAndFormat> fetchFields() {
        }
        boolean hasScriptFields = scriptFields != null;
    }
    @Override
                    + "] but was ["
            queryShardContext,
        } else {
        return this;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
 * @opensearch.internal
                                    }
            explain,
    }
     *            pattern to filter the returned _source
        return this;
                    factory.highlighter(HighlightBuilder.fromXContent(parser));
 * specific language governing permissions and limitations
    public int from() {
     * From index to start the search from. Defaults to {@code 0}.
        this.fetchFields = clone.fetchFields == null ? null : new ArrayList<>(clone.fetchFields);
            for (SortBuilder<?> sort : sorts) {
                    + IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING.getKey()
        return this;
    }
        return fetchFields;
     * @param includes
     */
     * @param name
    @Override
            size,
                                        parser.getTokenLocation()
 * GitHub history for details.
                } else if (SearchSourceBuilder.SIZE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public TopHitsAggregationBuilder sort(String name, SortOrder order) {
                    + "]. This limit can be set by changing the ["
            fetchSourceContext,
    private boolean trackScores = false;
        this.docValueFields = clone.docValueFields == null ? null : new ArrayList<>(clone.docValueFields);
    public TopHitsAggregationBuilder scriptFields(List<ScriptField> scriptFields) {
     * Adds a field to load and return as part of the search request.
        if (this.scriptFields != null) {
        }
                        factory.docValueField(ff.field, ff.format);
     * @param script
                    }
            }
    /**
        }
        return this;
     * Gets the field-data fields.
     * Gets the bytes representing the sort builders for this request.
            sorts,
            && Objects.equals(highlightBuilder, that.highlightBuilder)
     *
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     */
            throw new IllegalArgumentException("[scriptFields] must not be null: [" + name + "]");
        this.from = clone.from;
     */
     *            The name of the field
    /**
    private FetchSourceContext fetchSourceContext;
                    factory.storedFieldsContext = StoredFieldsContext.fromXContent(
            throw new IllegalArgumentException("scriptField [script] must not be null: [" + name + "]");
     */
                                    if (SearchSourceBuilder.SCRIPT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.version = version;
    /**
            && trackScores == that.trackScores
    public TopHitsAggregationBuilder sort(String name) {
    }
            subfactoriesBuilder,
            out.writeList(docValueFields);
        }
    protected TopHitsAggregationBuilder(TopHitsAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
                        parser.getTokenLocation()
    }
    public TopHitsAggregationBuilder fetchSource(boolean fetch) {
     *            An optional list of include (optionally wildcarded)
            if (token == XContentParser.Token.FIELD_NAME) {
     */
        builder.endObject();
        }
                        factory.fetchField(ff.field, ff.format);
    /**
     * Defaults to {@code false}.
            parent,
                }
    public TopHitsAggregationBuilder size(int size) {
    }
        }
 * software distributed under the License is distributed on an
    public TopHitsAggregationBuilder scriptField(String name, Script script, boolean ignoreFailure) {
            throw new IllegalArgumentException("sort [name] must not be null: [" + name + "]");
            && seqNoAndPrimaryTerm == that.seqNoAndPrimaryTerm
        super(name);
    }
                                            "Unknown key for a " + token + " in [" + currentFieldName + "].",
            throw new IllegalArgumentException("[sort] must not be null: [" + name + "]");
    }
        boolean hasFieldDataFields = docValueFields != null;
            } else if (token == XContentParser.Token.START_OBJECT) {
                }
     * the search request.
                } else if (SearchSourceBuilder.SORT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    factory.fetchSource(FetchSourceContext.fromXContent(parser));
    private boolean version = false;
     */
                    factory.storedFieldsContext = StoredFieldsContext.fromXContent(
     *
                } else if (SearchSourceBuilder.TRACK_SCORES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return fetchField(field, null);
        return storedFieldsContext;
     *
     * Gets the highlighter builder for this request.
        if (order == null) {
        return this;
                    );
        }
import java.util.Map;
        out.writeBoolean(version);
    public boolean trackScores() {
        return storedFields(Collections.singletonList(field));
    public List<FieldAndFormat> docValueFields() {
    }
        this.fetchSourceContext = new FetchSourceContext(fetch, fetchSourceContext.includes(), fetchSourceContext.excludes());
                                    + token
        return this;
    }
     * elements.
                    throw new ParsingException(
        );
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                                        ignoreFailure = parser.booleanValue();
            throw new IllegalArgumentException("scriptField [name] must not be null: [" + name + "]");
}
            scriptFields,
    public StoredFieldsContext storedFields() {
import org.opensearch.search.sort.SortAndFormats;
        }
                        parser
     *            The name of the field
            throw new IllegalArgumentException(
            this.sorts.add(sort);
                clone.fetchSourceContext.includes(),
import java.util.Set;
     */
            }
                            Script script = null;
    /**
        return this;
     * search hits.
    }
        this.scriptFields.addAll(scriptFields);
    public boolean explain() {
        if (scriptFields != null) {
            from,
    }
                } else if (SearchSourceBuilder.VERSION_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     *
    @Override
                FieldScript.Factory factory = queryShardContext.compile(field.script(), FieldScript.CONTEXT);
            }
        }
                } else if (SearchSourceBuilder.HIGHLIGHT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                                            parser.getTokenLocation()
    /**
    /**
        return this;
                                        currentFieldName,
            throw new IllegalArgumentException("[from] must be greater than or equal to 0. Found [" + from + "] in [" + name + "]");
     *            pattern to filter the returned _source
     * @param order
        return BucketCardinality.NONE;
        if (scriptFields == null) {
     */
     * elements.
        return this;
        this.trackScores = trackScores;
     * @param exclude
    }
    }
    public TopHitsAggregationBuilder fetchField(String field, String format) {
        }
                                        script = Script.parse(parser);
            && Objects.equals(sorts, that.sorts)
            storedFieldsContext = StoredFieldsContext.fromList(fields);
            highlightBuilder,
    }
                        field.fieldName(),
    /**
            fetchFields = in.readList(FieldAndFormat::new);
    public TopHitsAggregationBuilder fetchSource(@Nullable String[] includes, @Nullable String[] excludes) {
    /**
            trackScores,
                    throw new ParsingException(
        this.explain = clone.explain;
                    List<SortBuilder<?>> sorts = SortBuilder.fromXContent(parser);
 *
            fetchFields,
     */
     * Indicates whether {@link org.opensearch.search.SearchHit}s should be returned with the
    public TopHitsAggregationBuilder docValueField(String docValueField) {
        }
                            );
                } else {
        long innerResultWindow = from() + size();
                    parser.getTokenLocation()
        out.writeVInt(size);
                                } else if (token == XContentParser.Token.START_OBJECT) {
     */
        final Optional<SortAndFormats> optionalSort;
    @Override
     * @param script
     **/
        builder.field(SearchSourceBuilder.VERSION_FIELD.getPreferredName(), version);
        this.trackScores = clone.trackScores;
     */
    /**
                docValueFields.add(new FieldAndFormat(in));
            for (int i = 0; i < size; i++) {
        } else {
import org.opensearch.search.builder.SearchSourceBuilder;
        }
                                    } else if (SearchSourceBuilder.IGNORE_FAILURE_FIELD.match(
        if (highlightBuilder == null) {
     *            The name of the field to sort by
    @Override
        return this;
            name,
        if (hasScriptFields) {
        }
                clone.fetchSourceContext.excludes()
                } else if (SearchSourceBuilder.EXPLAIN_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected TopHitsAggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subfactoriesBuilder)
    /**
import org.opensearch.search.fetch.StoredFieldsContext;
        out.writeVInt(from);
        if (fetchSourceContext == null) {
                docValueField.toXContent(builder, params);
import org.opensearch.search.sort.SortBuilders;
            throw new IllegalArgumentException("[fields] must not be null: [" + name + "]");
        return this;
        if (docValueField == null) {
     * @param name
        docValueFields.add(new FieldAndFormat(docValueField, format));
    /**
        TopHitsAggregationBuilder factory = new TopHitsAggregationBuilder(aggregationName);
     * Adds a script field under the given name with the provided script.
 * not use this file except in compliance with the License.
                                    );
            builder.endArray();
                        SearchSourceBuilder.STORED_FIELDS_FIELD.getPreferredName(),
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
    private HighlightBuilder highlightBuilder;
    /**
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
                    + maxInnerResultWindow
    public TopHitsAggregationBuilder highlighter(HighlightBuilder highlightBuilder) {
            storedFieldsContext.addFieldNames(fields);
     * Should each {@link org.opensearch.search.SearchHit} be returned with the
     * Applies when sorting, and controls if scores will be tracked as well.
        return sorts;
    public TopHitsAggregationBuilder fetchField(String field) {
        if (field == null) {
    /**
    }
 * the Apache License, Version 2.0 (the "License"); you may
                    factory.fetchSource(FetchSourceContext.fromXContent(parser));
        }
        }
                        } else {
                                }
import org.opensearch.search.sort.ScoreSortBuilder;
        if (docValueFields == null) {
        if (script == null) {
        if (script == null) {
    /**
    public String getType() {
     */
            builder.endArray();
        int maxInnerResultWindow = queryShardContext.getMapperService().getIndexSettings().getMaxInnerResultWindow();
     */
 * You may obtain a copy of the License at
 * license agreements. See the NOTICE file distributed with
            throw new IllegalArgumentException("scriptField [name] must not be null: [" + name + "]");
    public TopHitsAggregationBuilder(StreamInput in) throws IOException {
 * compatible open source license.
            builder.startArray(SearchSourceBuilder.SORT_FIELD.getPreferredName());
        }
            for (int i = 0; i < size; i++) {
    /**
                    )
     * To disable the stored fields entirely (source and metadata fields) use {@code storedField("_none_")}.
            throw new IllegalArgumentException("sort [name] must not be null: [" + name + "]");
    }
        return this;
    }
    /**
        this.seqNoAndPrimaryTerm = seqNoAndPrimaryTerm;
    public TopHitsAggregationBuilder fetchSource(@Nullable String include, @Nullable String exclude) {
        return factory;
import org.opensearch.core.xcontent.XContentBuilder;
            sorts = new ArrayList<>();
    }
     * Should each {@link org.opensearch.search.SearchHit} be returned
                                            "Unknown key for a " + token + " in [" + currentFieldName + "].",
 */
    /**
     *            The name of the field
        return this;
                                } else if (token.isValue()) {
import org.opensearch.search.sort.SortBuilder;
        return explain;
                                parser.getTokenLocation(),
     */
        if (fetchSourceContext != null) {
        if (sort == null) {
        this.scriptFields = clone.scriptFields == null ? null : new HashSet<>(clone.scriptFields);
                        "Unknown key for a " + token + " in [" + currentFieldName + "].",
                            }
        }
                        searchScript,
/*
        }
        this.fetchSourceContext = new FetchSourceContext(fetchSourceContext.fetchSource(), includes, excludes);
                    );
        this.size = size;
     * Gets the from index to start the search from.
                } else if (SearchSourceBuilder.SCRIPT_FIELDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    + name
            }
     */
            for (FieldAndFormat docValueField : docValueFields) {
    }
    }
    /**
                currentFieldName = parser.currentName();
    private Set<ScriptField> scriptFields;
    @Override
    /**
     */
     * sequence number and primary term of the last modification of the document.
            } else {
import org.opensearch.search.builder.SearchSourceBuilder.ScriptField;
            from,
            sort(SortBuilders.fieldSort(name));
        out.writeBoolean(hasScriptFields);
                        "Unknown key for a " + token + " in [" + currentFieldName + "].",
            throw new IllegalArgumentException("[size] must be greater than or equal to 0. Found [" + size + "] in [" + name + "]");
                                    } else {
        out.writeBoolean(fetchFields != null);
            && explain == that.explain
        if (this == o) return true;
 *
            out.writeCollection(scriptFields);
 */
     */
        if (storedFieldsContext != null) {
            docValueFields = new ArrayList<>(size);
            super.hashCode(),
                } else {
import org.opensearch.core.common.io.stream.StreamOutput;
        this.seqNoAndPrimaryTerm = clone.seqNoAndPrimaryTerm;
        trackScores = in.readBoolean();
public class TopHitsAggregationBuilder extends AbstractAggregationBuilder<TopHitsAggregationBuilder> {
        throw new AggregationInitializationException(
                }
/*
    }
            "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
     * Indicates whether scores will be tracked for this request.
            ? null
            builder.field(SearchSourceBuilder.HIGHLIGHT_FIELD.getPreferredName(), highlightBuilder);
        if (fields == null) {
        highlightBuilder = in.readOptionalWriteable(HighlightBuilder::new);
            throw new IllegalArgumentException("[fields] must not be null: [" + name + "]");
                    + innerResultWindow
    }
            sort(SortBuilders.scoreSort().order(order));
        builder.field(SearchSourceBuilder.SEQ_NO_PRIMARY_TERM_FIELD.getPreferredName(), seqNoAndPrimaryTerm);
                        }
        if (in.readBoolean()) {
    /**
        }
        size = in.readVInt();
