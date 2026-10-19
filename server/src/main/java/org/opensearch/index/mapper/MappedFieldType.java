            throw new IllegalArgumentException("Cannot extract a term from a query of type " + termQuery.getClass() + ": " + termQuery);  
 */  
    public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
import java.util.Set;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        );  
    }
    @ExperimentalApi
     * shard when compared with a query range  
    @ExperimentalApi
import org.opensearch.index.query.DistanceFeatureQueryBuilder;
        INTERSECTS,
     * Get the metadata associated with this field.  
     */
    private final boolean isIndexed;
     * Called by {@link org.opensearch.index.engine.dataformat.DataFormatRegistry} during mapping build.
     */  
import org.apache.lucene.search.TermQuery;  
 * The OpenSearch Contributors require contributions made to  
     */
     */
        boolean hasDocValues,
    }  
        int maxExpansions,
import org.apache.lucene.search.MultiTermQuery;  
        ZoneId timeZone,
import java.util.function.Supplier;  
 * software distributed under the License is distributed on an
        );  
/*  
     * @param relation the relation, nulls should be interpreted like INTERSECTS
     *  @throws IllegalArgumentException if {@code value} cannot be converted to the expected data type or if the field is not searchable
    /**
    ) {  
     * Derives the set of capabilities this field type requires based on its mapping parameters.  
        TextSearchInfo textSearchInfo,  
     * @param searchLookup a {@link SearchLookup} supplier to allow for accessing other fields values in the context of runtime fields
        return wildcardQuery(value, method, false, context);  
/*
        @Nullable MultiTermQuery.RewriteMethod method,  
    }
import org.opensearch.ExceptionsHelper;  
    public MultiValueState multiValueState() {  
        return isIndexed;
import org.opensearch.search.lookup.SearchLookup;
                BytesRefIterator it = tisQuery.getBytesRefIterator();  
        return caps.isEmpty() ? Set.of() : Set.copyOf(caps);
    }  
        return multiValueState;
        String name,
     * An enum used to describe the relation between the range of terms in a
     *  @throws QueryShardException if the field is not searchable regardless of options  
     */  
    public String familyTypeName() {
     * Safe without volatile: publication through MapperService's volatile mapper reference provides happens-before.  
    ) {
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
            caps.add(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE);
import org.opensearch.common.geo.ShapeRelation;
        throw new QueryShardException(
    }
        @Nullable MultiTermQuery.RewriteMethod method,  
            caps.add(FieldTypeCapabilities.Capability.STORED_FIELDS);
        this.indexAnalyzer = analyzer;  
    private final TextSearchInfo textSearchInfo;
    }
     * whether they use point-range (numerics, dates, IPs) or full-text (text, keyword) search.
     * Capability map assigning each registered {@link DataFormat} to the set of capabilities it owns for this field type.
 * @opensearch.api
     * a function for doing that.  If it is unsupported for this field type, there is no need to override this method.
    }
            context,
     */  
     * <p>
    public void setIndexAnalyzer(NamedAnalyzer analyzer) {
    // Fuzzy Query with re-write method
     *  format it back to a string in this method. */
        );
        throw new IllegalArgumentException("Field [" + name + "] of type [" + typeName() + "] does not support range queries");
     * This is a mapper capability, distinct from {@link #isMultiValued()}, which is the current  
     * @param fullyQualifiedIndexName the name of the index this field-data is build for  
    public void setMultiValued(boolean multiValued) {  
    public Query rangeQuery(
    }
        );
    }  
     * Return a fielddata builder for this field
    }
        return null;
    }
        ShapeRelation relation,  
     *  The default implementation returns a {@link DocValueFormat#RAW}. */  
        if (termQuery instanceof TermQuery == false) {
     */
    @ExperimentalApi
        int matchFlags,  
    public abstract String typeName();
        int prefixLength,  
            throw new IllegalArgumentException(
import org.apache.lucene.search.FieldExistsQuery;
    /** Whether an additional value may trigger an automatic mapping promotion. */
        return isSearchable();
     * @opensearch.experimental
 */  
        QueryShardContext context
     * Factory method for range queries.
    ) {  
import org.opensearch.common.time.DateMathParser;  
     * @opensearch.experimental
import org.apache.lucene.search.Query;
        boolean includeLower,
    /**  
        throw new IllegalArgumentException(
            throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones");  
        }
                return new Term(tisQuery.getField(), term);
            termQuery = ((ConstantScoreQuery) termQuery).getQuery();  
            "Can only use wildcard queries on keyword and text fields - not on [" + name + "] which is of type [" + typeName() + "]"
    public void setBoost(float boost) {
        return prefixQuery(value, method, false, context);
    public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {  
            "Can only use prefix queries on keyword and text fields - not on [" + name + "] which is of type [" + typeName() + "]"  
        return this;
 * not use this file except in compliance with the License.
    @ExperimentalApi
    public Query fuzzyQuery(  
    public Query distanceFeatureQuery(Object origin, String pivot, float boost, QueryShardContext context) {
        this.multiValueState = Objects.requireNonNull(multiValueState);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        throw new IllegalArgumentException("Fielddata is not supported on field [" + name() + "] of type [" + typeName() + "]");
    public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions) throws IOException {  
import org.opensearch.OpenSearchParseException;
     * Fields that do not support any text-based queries should return  
        if (timeZone != null) {
    // Case sensitive form of prefix query
        Object lowerTerm,
    /** Returns true if the field is aggregatable.
     */
     * Compatibility setter for callers that only know scalar versus multi-valued. Setting false
    @ExperimentalApi
    private final boolean isStored;  
            "Can only use interval queries on text fields - not on [" + name + "] which is of type [" + typeName() + "]"  
        boolean isIndexed,  
 * Licensed to Elasticsearch under one or more contributor  
        if (isIndexed == false) {  
        for (Object value : values) {  
 * this work for additional information regarding copyright
 */
        return eagerGlobalOrdinals;
    public boolean isMultiValueSupported() {  
        throws IOException {
import org.apache.lucene.index.Term;  
    public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions, QueryShardContext context) throws IOException {  
            termQuery = ((BoostQuery) termQuery).getQuery();
     */
            fielddataBuilder("", () -> { throw new UnsupportedOperationException("SearchLookup not available"); });
        return ((TermQuery) termQuery).getTerm();
        QueryShardContext context  
                BytesRef term = it.next();
    /** Return a {@link DocValueFormat} that can be used to display and parse
    // Case sensitive form of wildcard query
        if (hasDocValues() == false) {  
        try {  
    public boolean isSearchable() {
import org.apache.lucene.analysis.TokenStream;
        } catch (IllegalArgumentException e) {  
     * @throws IllegalArgumentException if the fielddata is not supported on this type.
        String value,
    public Relation isFieldWithinQuery(  
import org.apache.lucene.search.BoostQuery;  
            throw new IllegalArgumentException(  
            throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support custom formats");  
 * GitHub history for details.
    }
import org.apache.lucene.search.BooleanClause.Occur;
    }
     *  @throws UnsupportedOperationException if the field is not searchable regardless of options
     *  outside the range or cross the range. The default implementation returns  
     **/
            return new FieldExistsQuery(name());
     *  An IllegalArgumentException is needed in order to return an http error 400
        boolean caseInsensitve,
import java.io.IOException;
     * recursively removing {@link BoostQuery} wrappers.
import org.opensearch.search.fetch.subphase.FetchFieldsPhase;
        );
    }  
        this.name = Objects.requireNonNull(name);
        throw new QueryShardException(
     * @opensearch.experimental  
public abstract class MappedFieldType {
    public abstract Query termQuery(Object value, @Nullable QueryShardContext context);  
     */
    private final Map<String, String> meta;
    private final String name;  
     * Extract a {@link Term} from a query created with {@link #termQuery} by  
                + "] query can only be run on a date, date_nanos or geo_point field type!"
import org.opensearch.index.fielddata.IndexFieldData;  
            }  
        throws IOException {
            "[" + name + "] field which is of type [" + typeName() + "], does not support case insensitive term queries"  
        return typeName();  
    public Query existsQuery(QueryShardContext context) {
        boolean isStored,
import org.opensearch.common.annotation.ExperimentalApi;  
    public DocValueFormat docValueFormat(@Nullable String format, ZoneId timeZone) {
     */
     * formats ({@code multi_value} mapping parameter). Lucene is inherently multi-valued, so
    }
     * @opensearch.api
        QueryShardContext context
import org.opensearch.index.query.IntervalMode;
        if (isIndexed == false && hasDocValues() == false) {
 * under the License.  
     * {@code false} locks the field in SCALAR state, and explicit {@code true} selects LIST state.  
     */  
package org.opensearch.index.mapper;
     *  
        }  
    public boolean isMultiValueAutoPromotionEnabled() {  
    /** Sets whether this field type supports automatic scalar-to-multi-value promotion. */
    }
            // we throw an IAE rather than an ISE so that it translates to a 4xx code rather than 5xx code on the http layer
    }  
     * An IllegalArgumentException is needed in order to return an http error 400  
    public void setMultiValueSupported(boolean multiValueSupported) {  
        ZoneId timeZone,  
     * Returns true if the field is searchable.
    ) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.index.engine.dataformat.DataFormat;
        Object value,
                + "["  
    /**  
     * @throws IllegalStateException if already set
            "Can only use phrase queries on text fields - not on [" + name + "] which is of type [" + typeName() + "]"  
    }
import org.apache.lucene.search.TermInSetQuery;
        return new ConstantScoreQuery(builder.build());  
    public Query wildcardQuery(
     *  values as returned by the fielddata API.
            if (tisQuery.getTermsCount() == 1) {
     */  
    }
     */
    /**
     * Create a helper class to fetch field values during the {@link FetchFieldsPhase}.
    }
        @Nullable MultiTermQuery.RewriteMethod method,  
    private NamedAnalyzer indexAnalyzer;
     */
            context,
 * ownership. Elasticsearch licenses this file to you under  
     * Create an {@link IntervalsSource} to be used for proximity queries
        if (isSearchable()) {
     * New field types must implement this method in order to support the search 'fields' option. Except
    public final Query wildcardQuery(String value, @Nullable MultiTermQuery.RewriteMethod method, QueryShardContext context) {
     */
        boolean includeUpper,
            context,
     */  
        int maxDeterminizedStates,
            "Illegal data type of ["  
import org.apache.lucene.util.BytesRef;
    @ExperimentalApi
/**
        throw new IllegalArgumentException(
        }  
    ) {
        this.boost = 1.0f;  
    /**  
        throw new IllegalArgumentException(  
     * only simple match queries, and can return
    ) throws IOException {  
     *  
    }
        }  
     *
     *  
     * when this error occurs in a request. see: {@link ExceptionsHelper#status}
    /**
    }
     * @return a concrete (unfiltered) field type, which should be the current instance
     * formats that can query doc-values-only fields. Defaults to {@link #isSearchable()}.
                    + name()  
    public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {  
     * explicit SCALAR intent.  
                + typeName()
            builder.add(termQuery(value, context), Occur.SHOULD);
        Object upperTerm,  
        this.isIndexed = isIndexed;
    /**  
        throw new QueryShardException(
    public final Query prefixQuery(String value, @Nullable MultiTermQuery.RewriteMethod method, QueryShardContext context) {  
    public MappedFieldType(
    /**
        Map<String, String> meta
            return new TermQuery(new Term(FieldNamesFieldMapper.NAME, name()));
        }  
     *  no way to check whether values are actually within bounds. */
        return Relation.INTERSECTS;
    /**
     * could cause a search retrieving multiple fields (like "fields": ["*"]) to fail.  
 * KIND, either express or implied.  See the License for the
     * Whether this field can serve predicates on the given index, accounting for pluggable data  
    ) {
        return meta;  
        this.multiValueState = multiValued ? MultiValueState.LIST : MultiValueState.AUTO;
     */
import org.opensearch.index.query.QueryShardException;
        this.multiValueSupported = multiValueSupported;
    private boolean multiValueSupported;
        return capabilityMap;  
        this.eagerGlobalOrdinals = eagerGlobalOrdinals;
import org.apache.lucene.index.IndexReader;
    /** Sets the durable multi-value state. */
    public boolean isStored() {
        if (termQuery instanceof TermInSetQuery) {  
        } else if (getTextSearchInfo().hasNorms()) {
        } else {
     * @opensearch.experimental
     *  The default implementation returns a {@link TermQuery} over the value bytes,  
     *  
        this.isStored = isStored;  
    public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
 *  
    /**  
        }  
import org.apache.lucene.search.ConstantScoreQuery;
    public Object valueForDisplay(Object value) {  
     * Returns the search capability for this field type. Subclasses override to declare
        LIST  
    @ExperimentalApi
        AUTO,
    /**  
        WITHIN,  
     */
     * Returns true if the field is stored separately.  
    protected final void failIfNotIndexed() {
        QueryShardContext context  
     * one-way mapping state.
 * compatible open source license.
     *  expected type. For instance a date field would store dates as longs and
    /**
     */
        }
                + DistanceFeatureQueryBuilder.NAME
     *  when this error occurs in a request. see: {@link ExceptionsHelper#status}  
    // Case insensitive form of term query (not supported by all fields so must be overridden to enable)
    /** @throws IllegalArgumentException if the fielddata is not supported on this type.
 * Unless required by applicable law or agreed to in writing,
import java.util.HashSet;  
     * Whether this field type can represent multiple scalar values in a pluggable data format.
    }
        }
    public Map<DataFormat, Set<FieldTypeCapabilities.Capability>> getCapabilityMap() {
        }
    }
     */
    }
    public NamedAnalyzer indexAnalyzer() {
     * restores AUTO; mapping builders use {@link #setMultiValueState(MultiValueState)} to preserve
        Fuzziness fuzziness,
    private Map<DataFormat, Set<FieldTypeCapabilities.Capability>> capabilityMap = Map.of();
        return multiValueSupported;
        Object to,  
        DateMathParser parser,
    }
     * are generated with {@link #termQuery}. */  
        );
    public Map<String, String> meta() {
import org.opensearch.index.query.QueryRewriteContext;  
            TermInSetQuery tisQuery = (TermInSetQuery) termQuery;
     * Returns information on how any text in this field is indexed
 * SPDX-License-Identifier: Apache-2.0
    public IntervalsSource intervals(String query, int max_gaps, IntervalMode mode, NamedAnalyzer analyzer, boolean prefix)  
    /** optionally normalize the wildcard pattern based on the value of {@code caseInsensitive} */  
     * Parquet, where a declared field is stored as {@code LIST<element>}).  
        return boost;
     *
    }
    /** Return whether all values of the given {@link IndexReader} are within the range,
 * specific language governing permissions and limitations
    /** Build a constant-scoring query that matches all values. The default implementation uses a
        }
    private float boost;  
import java.util.Map;
     *  {@link Relation#INTERSECTS}, which is always fine to return when there is
    }
    private boolean eagerGlobalOrdinals;
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
    public Query termsQuery(List<?> values, @Nullable QueryShardContext context) {
    }
            );
        if (hasDocValues()) {  
     * Set once during mapping build via {@link Mapper.BuilderContext#assignCapabilities}, then immutable.
 * You may obtain a copy of the License at  
     */
            "Can only use phrase queries on text fields - not on [" + name + "] which is of type [" + typeName() + "]"
import org.apache.lucene.util.BytesRefIterator;
        return name;
    /** Generates a query that will only match documents that contain the given value.
    }  
    public float boost() {
        );  
    @ExperimentalApi
        }
     * <p>  
        if (hasDocValues()) {
            context,  
import org.opensearch.common.Nullable;
                    + typeName()
        SCALAR,
    }
    }
import org.opensearch.index.IndexSettings;
import org.apache.lucene.queries.intervals.IntervalsSource;
        );  
            "Can only use regexp queries on keyword and text fields - not on [" + name + "] which is of type [" + typeName() + "]"
    @PublicApi(since = "1.0.0")
    }  
import java.util.List;
     * {@link TextSearchInfo#SIMPLE_MATCH_ONLY}  
        throw new IllegalArgumentException(
    public Set<FieldTypeCapabilities.Capability> requestedCapabilities() {
     * @return null if the optimization cannot be applied, otherwise a function to use for the optimization
        );
        throw new IllegalArgumentException(
    private MultiValueState multiValueState = MultiValueState.AUTO;  
    }
     *
                "Cannot search on field [" + name() + "] since it is both not indexed," + " and does not have doc_values enabled."
        QueryRewriteContext context
        }
    public Query normalizedWildcardQuery(String value, @Nullable MultiTermQuery.RewriteMethod method, QueryShardContext context) {
     * If the field supports using the indexed data to speed up operations related to ordering of data, such as sorting or aggs, return
     */  
                    + "]. Use doc values instead."  
     * @opensearch.experimental
    }
                + "]!"
 * the Apache License, Version 2.0 (the "License"); you may
        return multiValueState == MultiValueState.AUTO;
        IndexReader reader,
import org.apache.lucene.search.BooleanQuery;
        throw new IllegalArgumentException(
        String value,
        Set<FieldTypeCapabilities.Capability> caps = new HashSet<>();  
            "Can only use phrase prefix queries on text fields - not on [" + name + "] which is of type [" + typeName() + "]"
        }
@PublicApi(since = "1.0.0")
    protected FieldTypeCapabilities.Capability searchCapability() {
    public enum MultiValueState {  
        DISJOINT
        DateMathParser dateMathParser,
            return new FieldExistsQuery(name());  
    @ExperimentalApi  
        // we fail if a field is both not indexed and does not have doc_values enabled
    public boolean isAggregatable() {
    public synchronized void setCapabilityMap(Map<DataFormat, Set<FieldTypeCapabilities.Capability>> capabilityMap) {
import org.apache.lucene.queries.spans.SpanQuery;  
        this.capabilityMap = Map.copyOf(capabilityMap);  
    @ExperimentalApi
 * This defines the core properties and functions to operate on a field.  
    public String name() {  
    /**
    public abstract ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, @Nullable String format);
            context,
            return true;
    public Function<byte[], Number> pointReaderIfPossible() {
    }
        return isStored;  
    public boolean hasDocValues() {  
        return multiValueState == MultiValueState.LIST;  
        this.docValues = hasDocValues;
        }
        );
            "Can only use fuzzy queries on keyword and text fields - not on [" + name + "] which is of type [" + typeName() + "]"
import org.opensearch.index.query.QueryShardContext;
    }
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
    public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context)
    }  
            );
        throw new QueryShardException(  
    @ExperimentalApi
     * if this is not a field type wrapper. See {@link FilterFieldType}.
import java.util.function.Function;
     *  @throws OpenSearchParseException if {@code value} cannot be converted to the expected data type
        }  
        return indexAnalyzer;
     *  
        @Nullable MultiTermQuery.RewriteMethod method,
            "Can only use wildcard queries on keyword and text fields - not on [" + name + "] which is of type [" + typeName() + "]"  
    /** Given a value that comes from the stored fields API, convert it to the  
    protected final void failIfNotIndexedAndNoDocValues() {  
     * Sets the capability map.
        if (termQuery instanceof ConstantScoreQuery) {
    /**
    }  
import org.opensearch.index.analysis.NamedAnalyzer;  
     *  boosted by {@link #boost()}.
    private final boolean docValues;
    /** Returns the field family type, as used in field capabilities */
    }
    }
    }  
        return DocValueFormat.RAW;
        boolean includeUpper,
        return phraseQuery(stream, slop, enablePositionIncrements);
        boolean includeLower,
    @ExperimentalApi  
    @ExperimentalApi
    }
     * Multi-value state for columnar mappings: omitted {@code multi_value} is AUTO, explicit
    }  
    public Query regexpQuery(  
import org.opensearch.search.DocValueFormat;  
 *
     *
    /** Returns the name of this type, as would be specified in mapping properties */
    /**
        throw new QueryShardException(
     * Whether this field is declared to hold multiple values per document in columnar data  
        return value;
    public boolean eagerGlobalOrdinals() {  
    public Query termQueryCaseInsensitive(Object value, @Nullable QueryShardContext context) {  
        this.boost = boost;  
        );
    }
 * this file be licensed under the Apache-2.0 license or a
        throw new UnsupportedOperationException("searchCapability is not supported for field: " + name() + " of type: " + typeName());
     * Reporting only - never use this for query planning.
        if (format != null) {
    }
        boolean caseInsensitve,
    /**  
     * @throws IllegalArgumentException if the wrapped query is not a {@link TermQuery}  
        while (termQuery instanceof BoostQuery) {  
/*  
    /** always normalizes the wildcard pattern to lowercase */
    }  
        return textSearchInfo;  
    }
    /**
        QueryShardContext context
    /**
 *
    }
     * @throws IOException
 *
        Object from,
import java.util.Objects;  
    protected final void failIfNoDocValues() {
    public void setEagerGlobalOrdinals(boolean eagerGlobalOrdinals) {
    /**  
                    + "] because fielddata is unsupported on fields of type ["
     * {@link TextSearchInfo#NONE}.  Some fields (eg numeric) may support
                "Can't load fielddata on ["
import java.time.ZoneId;
    public static Term extractTerm(Query termQuery) throws IOException {
    public Query prefixQuery(
     * {@link ConstantScoreQuery} around a {@link BooleanQuery} whose {@link Occur#SHOULD} clauses
        this.textSearchInfo = Objects.requireNonNull(textSearchInfo);
    }
        return multiPhraseQuery(stream, slop, enablePositionIncrements);  
        throw new IllegalArgumentException(
    }  
    @Nullable  
    /**  
        return docValues;
    public MappedFieldType unwrap() {
    }  
        String value,
    public void setMultiValueState(MultiValueState multiValueState) {  
import org.opensearch.common.unit.Fuzziness;
    }  
        if (isStored()) {
        boolean transpositions,
            "Can only use span prefix queries on text fields - not on [" + name + "] which is of type [" + typeName() + "]"  
}
 */  
    public enum Relation {
    public boolean isMultiValued() {
 * Modifications Copyright OpenSearch Contributors. See
    }
     * for metadata fields, field types should not throw {@link UnsupportedOperationException} since this
    /** Returns the durable multi-value state. */
    }  
    public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context) throws IOException {  
    }
     *
            throw new IllegalArgumentException("Cannot search on field [" + name() + "] since it is not indexed.");
     *      due to the way it is configured (eg. not indexed)  
    // TODO: Standardize exception types
        this.meta = meta;  
            caps.add(searchCapability());
            return false;
        );
        return phrasePrefixQuery(stream, slop, maxExpansions);
     * this flag only matters to pluggable formats whose column type is fixed per file (e.g.
     * @opensearch.experimental
    public TextSearchInfo getTextSearchInfo() {
    }
    }
    /**  
    public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
        int syntaxFlags,
