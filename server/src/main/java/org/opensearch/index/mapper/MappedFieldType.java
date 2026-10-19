    }
     * New field types must implement this method in order to support the search 'fields' option. Except
     *  no way to check whether values are actually within bounds. */
            // we throw an IAE rather than an ISE so that it translates to a 4xx code rather than 5xx code on the http layer
     * recursively removing {@link BoostQuery} wrappers.
    }
 * this file be licensed under the Apache-2.0 license or a
        boolean includeUpper,
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (termQuery instanceof TermInSetQuery) {
            "Can only use wildcard queries on keyword and text fields - not on [" + name + "] which is of type [" + typeName() + "]"
    /**
        throw new QueryShardException(
     * {@code false} locks the field in SCALAR state, and explicit {@code true} selects LIST state.
/*
     * are generated with {@link #termQuery}. */
    public final Query wildcardQuery(String value, @Nullable MultiTermQuery.RewriteMethod method, QueryShardContext context) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.BoostQuery;
import java.util.Objects;
    public enum Relation {
        return meta;
import org.opensearch.common.annotation.ExperimentalApi;
     *
     */
            return true;
     * @opensearch.experimental
    }
import org.opensearch.index.analysis.NamedAnalyzer;
    /** Returns the durable multi-value state. */
    public abstract ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, @Nullable String format);
import java.util.Map;
    /**
@PublicApi(since = "1.0.0")
            return new FieldExistsQuery(name());
     * Extract a {@link Term} from a query created with {@link #termQuery} by
        } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("Fielddata is not supported on field [" + name() + "] of type [" + typeName() + "]");
        ShapeRelation relation,
    ) {
    public MappedFieldType(
            "Can only use phrase queries on text fields - not on [" + name + "] which is of type [" + typeName() + "]"
    // TODO: Standardize exception types
    private Map<DataFormat, Set<FieldTypeCapabilities.Capability>> capabilityMap = Map.of();
 * @opensearch.api
    /**
    public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
        this.boost = boost;
 * software distributed under the License is distributed on an
     */
        if (hasDocValues() == false) {
        @Nullable MultiTermQuery.RewriteMethod method,
    }
        throws IOException {
 * this work for additional information regarding copyright
 */
     * Get the metadata associated with this field.
    public DocValueFormat docValueFormat(@Nullable String format, ZoneId timeZone) {
     *  @throws QueryShardException if the field is not searchable regardless of options
            throw new IllegalArgumentException("Cannot search on field [" + name() + "] since it is not indexed.");
        }
        String name,
     * one-way mapping state.
     * If the field supports using the indexed data to speed up operations related to ordering of data, such as sorting or aggs, return
        @Nullable MultiTermQuery.RewriteMethod method,
    public enum MultiValueState {
            fielddataBuilder("", () -> { throw new UnsupportedOperationException("SearchLookup not available"); });
     * whether they use point-range (numerics, dates, IPs) or full-text (text, keyword) search.
     */
     * @return null if the optimization cannot be applied, otherwise a function to use for the optimization
        throw new QueryShardException(
        Map<String, String> meta
        throw new UnsupportedOperationException("searchCapability is not supported for field: " + name() + " of type: " + typeName());
import org.apache.lucene.analysis.TokenStream;
        boolean caseInsensitve,
    /**
        if (isSearchable()) {
     */
     * {@link ConstantScoreQuery} around a {@link BooleanQuery} whose {@link Occur#SHOULD} clauses
import org.opensearch.index.fielddata.IndexFieldData;
    public void setEagerGlobalOrdinals(boolean eagerGlobalOrdinals) {
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
    /**
     *  An IllegalArgumentException is needed in order to return an http error 400
        return wildcardQuery(value, method, false, context);
        this.multiValueState = multiValued ? MultiValueState.LIST : MultiValueState.AUTO;
import org.apache.lucene.index.Term;
    public Query distanceFeatureQuery(Object origin, String pivot, float boost, QueryShardContext context) {
        @Nullable MultiTermQuery.RewriteMethod method,
 *
     *
    /** Returns the field family type, as used in field capabilities */
    }
    /** Returns true if the field is aggregatable.
            throw new IllegalArgumentException(
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        this.isStored = isStored;
        QueryShardContext context
    }
    /** Sets whether this field type supports automatic scalar-to-multi-value promotion. */
    public Query fuzzyQuery(
     */
        return new ConstantScoreQuery(builder.build());
        );
        return caps.isEmpty() ? Set.of() : Set.copyOf(caps);
     * @opensearch.experimental
import org.apache.lucene.index.IndexReader;
    @ExperimentalApi
        }
    /** optionally normalize the wildcard pattern based on the value of {@code caseInsensitive} */
        );
    }
        ZoneId timeZone,
     *
import org.opensearch.common.annotation.PublicApi;
     *
        WITHIN,
        return value;
            caps.add(searchCapability());
        );
    }
        return name;
        boolean includeLower,
    public MappedFieldType unwrap() {
    @ExperimentalApi
    ) {
     * An IllegalArgumentException is needed in order to return an http error 400
        }
     *      due to the way it is configured (eg. not indexed)
        Object lowerTerm,
        if (isIndexed == false && hasDocValues() == false) {
     */
     * @param fullyQualifiedIndexName the name of the index this field-data is build for
/*
    }
     *  The default implementation returns a {@link DocValueFormat#RAW}. */
        ZoneId timeZone,
            "Can only use prefix queries on keyword and text fields - not on [" + name + "] which is of type [" + typeName() + "]"
    /**
    }
    }
        this.docValues = hasDocValues;
import org.opensearch.common.geo.ShapeRelation;
    /**
            caps.add(FieldTypeCapabilities.Capability.STORED_FIELDS);
 */
        INTERSECTS,
    /** always normalizes the wildcard pattern to lowercase */
            return new TermQuery(new Term(FieldNamesFieldMapper.NAME, name()));
import org.opensearch.index.query.QueryShardException;
    }
        // we fail if a field is both not indexed and does not have doc_values enabled
    public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context) throws IOException {
     * Returns the search capability for this field type. Subclasses override to declare
        throw new IllegalArgumentException(
     *  {@link Relation#INTERSECTS}, which is always fine to return when there is
    private boolean multiValueSupported;
    }
import org.opensearch.search.fetch.subphase.FetchFieldsPhase;
        int prefixLength,
     *  expected type. For instance a date field would store dates as longs and
    /** Build a constant-scoring query that matches all values. The default implementation uses a
     * Whether this field is declared to hold multiple values per document in columnar data
     * Create an {@link IntervalsSource} to be used for proximity queries
        QueryShardContext context
import org.apache.lucene.util.BytesRef;
     */
    @ExperimentalApi
 * This defines the core properties and functions to operate on a field.
    public Query prefixQuery(
    @ExperimentalApi
import java.io.IOException;
                + "] query can only be run on a date, date_nanos or geo_point field type!"
    /**
    public Map<String, String> meta() {
    private final Map<String, String> meta;
            throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support custom formats");
     * @throws IOException
    private boolean eagerGlobalOrdinals;
 * not use this file except in compliance with the License.
        return multiPhraseQuery(stream, slop, enablePositionIncrements);
     */
        throw new QueryShardException(
     *
    }
        this.isIndexed = isIndexed;
        throw new QueryShardException(
        return multiValueState;
        return phrasePrefixQuery(stream, slop, maxExpansions);
    /**
    private final String name;
    }
    protected FieldTypeCapabilities.Capability searchCapability() {
 * GitHub history for details.
    public Function<byte[], Number> pointReaderIfPossible() {
            caps.add(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE);
        QueryShardContext context
        DateMathParser dateMathParser,
                + DistanceFeatureQueryBuilder.NAME
     */
        }
            termQuery = ((ConstantScoreQuery) termQuery).getQuery();
     *  boosted by {@link #boost()}.
     *  The default implementation returns a {@link TermQuery} over the value bytes,
     * Safe without volatile: publication through MapperService's volatile mapper reference provides happens-before.
    }
     *  format it back to a string in this method. */
    public Relation isFieldWithinQuery(
    }
     * @param relation the relation, nulls should be interpreted like INTERSECTS
     * An enum used to describe the relation between the range of terms in a
    public IntervalsSource intervals(String query, int max_gaps, IntervalMode mode, NamedAnalyzer analyzer, boolean prefix)
    @ExperimentalApi
                    + typeName()
        Object from,
        );
     */
    }
     *  @throws IllegalArgumentException if {@code value} cannot be converted to the expected data type or if the field is not searchable
 *
     *  values as returned by the fielddata API.
        if (format != null) {
    /**
            "Can only use phrase queries on text fields - not on [" + name + "] which is of type [" + typeName() + "]"
    }
        } else if (getTextSearchInfo().hasNorms()) {
    public void setBoost(float boost) {
    }
            context,
    public String familyTypeName() {
    /** Whether an additional value may trigger an automatic mapping promotion. */
        );
     */
        QueryShardContext context
    // Fuzzy Query with re-write method
import org.apache.lucene.search.Query;
    public String name() {
    public Query termQueryCaseInsensitive(Object value, @Nullable QueryShardContext context) {
     *
import org.apache.lucene.search.TermInSetQuery;
        }
     * This is a mapper capability, distinct from {@link #isMultiValued()}, which is the current
    public Query existsQuery(QueryShardContext context) {
     * @throws IllegalArgumentException if the wrapped query is not a {@link TermQuery}
     * when this error occurs in a request. see: {@link ExceptionsHelper#status}
    @ExperimentalApi
     * Returns information on how any text in this field is indexed
        QueryShardContext context
                    + "]. Use doc values instead."
    /**
 * under the License.
    public float boost() {
            TermInSetQuery tisQuery = (TermInSetQuery) termQuery;
            "Can only use wildcard queries on keyword and text fields - not on [" + name + "] which is of type [" + typeName() + "]"
                BytesRef term = it.next();
     * Returns true if the field is stored separately.
    }
            context,
                return new Term(tisQuery.getField(), term);
     * Sets the capability map.
    public Query wildcardQuery(
        this.eagerGlobalOrdinals = eagerGlobalOrdinals;
    }
            throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones");
     * Called by {@link org.opensearch.index.engine.dataformat.DataFormatRegistry} during mapping build.
 * Licensed to Elasticsearch under one or more contributor
    }
        return isIndexed;
        this.indexAnalyzer = analyzer;
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @opensearch.api
import org.apache.lucene.search.FieldExistsQuery;
    @ExperimentalApi
        Fuzziness fuzziness,
/*
    public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions, QueryShardContext context) throws IOException {
    public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        Object value,
     * only simple match queries, and can return
     * Parquet, where a declared field is stored as {@code LIST<element>}).
        String value,
import org.opensearch.OpenSearchParseException;
    @ExperimentalApi
            throw new IllegalArgumentException("Cannot extract a term from a query of type " + termQuery.getClass() + ": " + termQuery);
    ) throws IOException {
    public void setIndexAnalyzer(NamedAnalyzer analyzer) {
            throw new IllegalArgumentException(
        return phraseQuery(stream, slop, enablePositionIncrements);
    public abstract String typeName();
    }
        }
        this.multiValueSupported = multiValueSupported;
        }
        );
            "Illegal data type of ["
     * @opensearch.experimental
    public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions) throws IOException {
     * for metadata fields, field types should not throw {@link UnsupportedOperationException} since this
     * @param searchLookup a {@link SearchLookup} supplier to allow for accessing other fields values in the context of runtime fields
        Object to,
import org.apache.lucene.queries.spans.SpanQuery;
    protected final void failIfNoDocValues() {
        DateMathParser parser,
        if (isStored()) {
import java.util.HashSet;
    }
        TextSearchInfo textSearchInfo,
    }
        QueryRewriteContext context
     * Fields that do not support any text-based queries should return
    protected final void failIfNotIndexed() {
                "Can't load fielddata on ["
    ) {
            }
        throws IOException {
        Set<FieldTypeCapabilities.Capability> caps = new HashSet<>();
        );
        }
    public NamedAnalyzer indexAnalyzer() {
        return textSearchInfo;
                    + "] because fielddata is unsupported on fields of type ["
    public void setMultiValued(boolean multiValued) {
    /** Returns the name of this type, as would be specified in mapping properties */
        this.boost = 1.0f;
import org.apache.lucene.search.MultiTermQuery;
        String value,
     * this flag only matters to pluggable formats whose column type is fixed per file (e.g.
     * {@link TextSearchInfo#NONE}.  Some fields (eg numeric) may support
        if (termQuery instanceof ConstantScoreQuery) {
     * <p>
            return false;
    private final boolean isStored;
    }
     * formats ({@code multi_value} mapping parameter). Lucene is inherently multi-valued, so
    private MultiValueState multiValueState = MultiValueState.AUTO;
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
/**
    }
    /**
        return docValues;
        throw new IllegalArgumentException("Field [" + name + "] of type [" + typeName() + "] does not support range queries");
    /**
import org.opensearch.search.lookup.SearchLookup;
        return this;
    }
    }
    @ExperimentalApi
        return null;
     */
    public MultiValueState multiValueState() {
    }
    }
import org.opensearch.index.query.IntervalMode;
     * <p>
            "[" + name + "] field which is of type [" + typeName() + "], does not support case insensitive term queries"
    @ExperimentalApi
     */
        for (Object value : values) {
        DISJOINT
    public boolean isMultiValueAutoPromotionEnabled() {
        return ((TermQuery) termQuery).getTerm();
     */
     *  @throws UnsupportedOperationException if the field is not searchable regardless of options
    }
 */
        );
        if (isIndexed == false) {
        throw new IllegalArgumentException(
import org.apache.lucene.queries.intervals.IntervalsSource;
            builder.add(termQuery(value, context), Occur.SHOULD);
    }
    // Case sensitive form of prefix query
        this.meta = meta;
        throw new IllegalArgumentException(
    public synchronized void setCapabilityMap(Map<DataFormat, Set<FieldTypeCapabilities.Capability>> capabilityMap) {
            context,
    /**
     * could cause a search retrieving multiple fields (like "fields": ["*"]) to fail.
        }
        return isStored;
     */
     * shard when compared with a query range
                BytesRefIterator it = tisQuery.getBytesRefIterator();
        boolean isStored,
                "Cannot search on field [" + name() + "] since it is both not indexed," + " and does not have doc_values enabled."
    }
            return new FieldExistsQuery(name());
 * license agreements. See the NOTICE file distributed with
    private NamedAnalyzer indexAnalyzer;
 *
        int maxDeterminizedStates,
    }
    private final boolean isIndexed;
        );
     * @throws IllegalArgumentException if the fielddata is not supported on this type.
    }
        if (timeZone != null) {
    public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
        throw new QueryShardException(
     * explicit SCALAR intent.
 * The OpenSearch Contributors require contributions made to
     * Whether this field type can represent multiple scalar values in a pluggable data format.
    /**
    /** @throws IllegalArgumentException if the fielddata is not supported on this type.
        this.textSearchInfo = Objects.requireNonNull(textSearchInfo);
        throw new IllegalArgumentException(
        this.name = Objects.requireNonNull(name);
                    + name()
    public boolean isSearchable() {
    // Case insensitive form of term query (not supported by all fields so must be overridden to enable)
import org.opensearch.index.engine.dataformat.DataFormat;
import org.opensearch.common.unit.Fuzziness;
    }
        IndexReader reader,
            "Can only use phrase prefix queries on text fields - not on [" + name + "] which is of type [" + typeName() + "]"
     * Multi-value state for columnar mappings: omitted {@code multi_value} is AUTO, explicit
    /** Return whether all values of the given {@link IndexReader} are within the range,
     * @opensearch.experimental
 * specific language governing permissions and limitations
    public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context)
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.experimental
     * Compatibility setter for callers that only know scalar versus multi-valued. Setting false
     * formats that can query doc-values-only fields. Defaults to {@link #isSearchable()}.
        if (hasDocValues()) {
    public Object valueForDisplay(Object value) {
    }
     * restores AUTO; mapping builders use {@link #setMultiValueState(MultiValueState)} to preserve
    public boolean isStored() {
        return typeName();
            );
    }
    public boolean isAggregatable() {
     */
     **/
    }
    }
     * Set once during mapping build via {@link Mapper.BuilderContext#assignCapabilities}, then immutable.
        return multiValueState == MultiValueState.AUTO;
 * ownership. Elasticsearch licenses this file to you under
    }
import java.util.function.Supplier;
     * Return a fielddata builder for this field
    public void setMultiValueState(MultiValueState multiValueState) {
    }
        }
import java.util.Set;
    private float boost;
     * {@link TextSearchInfo#SIMPLE_MATCH_ONLY}
     *  outside the range or cross the range. The default implementation returns
    /**
import org.apache.lucene.search.BooleanClause.Occur;
package org.opensearch.index.mapper;
    }
    ) {
     *
     */
    public static Term extractTerm(Query termQuery) throws IOException {
        Object upperTerm,
        int matchFlags,
        while (termQuery instanceof BoostQuery) {
    public TextSearchInfo getTextSearchInfo() {
    /** Sets the durable multi-value state. */
 *
     *
        int syntaxFlags,
        return DocValueFormat.RAW;
     */
     */
        this.capabilityMap = Map.copyOf(capabilityMap);
        throw new IllegalArgumentException(
    /**
    ) {
    public abstract Query termQuery(Object value, @Nullable QueryShardContext context);
 * Unless required by applicable law or agreed to in writing,
    // Case sensitive form of wildcard query
            context,
            if (tisQuery.getTermsCount() == 1) {
    }
    }
        boolean transpositions,
        throw new IllegalArgumentException(
        AUTO,
        this.multiValueState = Objects.requireNonNull(multiValueState);
        );
    public Query normalizedWildcardQuery(String value, @Nullable MultiTermQuery.RewriteMethod method, QueryShardContext context) {
    public void setMultiValueSupported(boolean multiValueSupported) {
        }
 * Modifications Copyright OpenSearch Contributors. See
    /**
    }
     * @throws IllegalStateException if already set
            "Can only use fuzzy queries on keyword and text fields - not on [" + name + "] which is of type [" + typeName() + "]"
    }
     * Capability map assigning each registered {@link DataFormat} to the set of capabilities it owns for this field type.
    public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
        }
                + typeName()
     */
import org.opensearch.ExceptionsHelper;
    public Query termsQuery(List<?> values, @Nullable QueryShardContext context) {
    }
        SCALAR,
    ) {
    public Map<DataFormat, Set<FieldTypeCapabilities.Capability>> getCapabilityMap() {
 * You may obtain a copy of the License at
import org.opensearch.search.DocValueFormat;
                + "]!"
        if (hasDocValues()) {
    /** Return a {@link DocValueFormat} that can be used to display and parse
     */
     *  @throws OpenSearchParseException if {@code value} cannot be converted to the expected data type
    protected final void failIfNotIndexedAndNoDocValues() {
import java.time.ZoneId;
    public Query rangeQuery(
    @Nullable
        return eagerGlobalOrdinals;
     * Create a helper class to fetch field values during the {@link FetchFieldsPhase}.
import java.util.function.Function;
        try {
    @ExperimentalApi
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.common.time.DateMathParser;
 * KIND, either express or implied.  See the License for the
     * Factory method for range queries.
import org.opensearch.common.Nullable;
    @ExperimentalApi
}
        }
        boolean caseInsensitve,
        throw new IllegalArgumentException(
import org.apache.lucene.util.BytesRefIterator;
    /** Generates a query that will only match documents that contain the given value.
            "Can only use regexp queries on keyword and text fields - not on [" + name + "] which is of type [" + typeName() + "]"
     *
    }
        boolean includeUpper,
        LIST
    /**
        );
    public Set<FieldTypeCapabilities.Capability> requestedCapabilities() {
     */
    }
import org.opensearch.index.IndexSettings;
    }
        return indexAnalyzer;
        }
            "Can only use interval queries on text fields - not on [" + name + "] which is of type [" + typeName() + "]"
        } else {
     *  when this error occurs in a request. see: {@link ExceptionsHelper#status}
    private final TextSearchInfo textSearchInfo;
     * Returns true if the field is searchable.
        return multiValueState == MultiValueState.LIST;
            context,
    public boolean hasDocValues() {
        return prefixQuery(value, method, false, context);
    /** Given a value that comes from the stored fields API, convert it to the
    public Query regexpQuery(
    /**
    public boolean eagerGlobalOrdinals() {
     * Derives the set of capabilities this field type requires based on its mapping parameters.
    }
        return capabilityMap;
            "Can only use span prefix queries on text fields - not on [" + name + "] which is of type [" + typeName() + "]"
    }
        return isSearchable();
import org.apache.lucene.search.TermQuery;
     *
        @Nullable MultiTermQuery.RewriteMethod method,
     * if this is not a field type wrapper. See {@link FilterFieldType}.
        return boost;
    @ExperimentalApi
    private final boolean docValues;
    public boolean isMultiValued() {
            termQuery = ((BoostQuery) termQuery).getQuery();
     * @opensearch.experimental
    }
                + "["
     * Reporting only - never use this for query planning.
    @PublicApi(since = "1.0.0")
    }
    public final Query prefixQuery(String value, @Nullable MultiTermQuery.RewriteMethod method, QueryShardContext context) {
        boolean hasDocValues,
     * Whether this field can serve predicates on the given index, accounting for pluggable data
        return multiValueSupported;
    }
    }
        String value,
        boolean isIndexed,
        return Relation.INTERSECTS;
 */
     * a function for doing that.  If it is unsupported for this field type, there is no need to override this method.
     */
     * @return a concrete (unfiltered) field type, which should be the current instance
        );
import org.opensearch.index.query.QueryRewriteContext;
        boolean includeLower,
import org.apache.lucene.search.BooleanQuery;
        int maxExpansions,
import java.util.List;
public abstract class MappedFieldType {
        }
 * compatible open source license.
    public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
        if (termQuery instanceof TermQuery == false) {
    public boolean isMultiValueSupported() {
import org.opensearch.index.query.DistanceFeatureQueryBuilder;
    /**
import org.apache.lucene.search.ConstantScoreQuery;
