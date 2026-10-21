    @Override
    @Override
        return delegate.wildcardQuery(value, method, caseInsensitve, context);
    @Override
        return delegate.multiValueState();
    }
        return delegate.hasDocValues();
import org.opensearch.index.query.QueryRewriteContext;
        delegate.setMultiValueState(multiValueState);
        return delegate.multiPhraseQuery(stream, slop, enablePositionIncrements, context);
import org.opensearch.common.time.DateMathParser;
    public Relation isFieldWithinQuery(
    }
        delegate.setMultiValueSupported(multiValueSupported);
    @Override
    @Override
import org.opensearch.common.annotation.PublicApi;
    }
    public void setIndexAnalyzer(NamedAnalyzer analyzer) {
    public float boost() {
        IndexReader reader,
        return delegate.boost();
 *
            delegate.hasDocValues(),
    public Map<DataFormat, Set<FieldTypeCapabilities.Capability>> getCapabilityMap() {
    }
    }
        MultiTermQuery.RewriteMethod method,
public abstract class FilterFieldType extends MappedFieldType {
import java.util.List;
        return delegate.phrasePrefixQuery(stream, slop, maxExpansions, context);
        return delegate.prefixQuery(value, method, caseInsensitve, context);
    }
    public boolean hasDocValues() {
    }
        delegate.setIndexAnalyzer(analyzer);
    }
        delegate.setBoost(boost);
import java.io.IOException;
        ShapeRelation relation,
    }
    @Override
    @Override
        ZoneId timeZone,
import org.opensearch.index.engine.dataformat.DataFormat;
    }
        return delegate.isMultiValueSupported();
    public NamedAnalyzer indexAnalyzer() {
        super(
    public void setBoost(float boost) {
    public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
    }
    @Override
    }
    @Override
        return delegate.docValueFormat(format, timeZone);
    public void setMultiValueState(MultiValueState multiValueState) {
    @Override
        Object value,
    @Override
    public Query distanceFeatureQuery(Object origin, String pivot, float boost, QueryShardContext context) {
    protected FieldTypeCapabilities.Capability searchCapability() {
import org.opensearch.search.DocValueFormat;
@PublicApi(since = "3.0.0")
        this.delegate = delegate;
import org.apache.lucene.queries.spans.SpanQuery;
    }
    public boolean isSearchable() {
import org.apache.lucene.queries.intervals.IntervalsSource;
 */
        return delegate.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context);
        return delegate.familyTypeName();
    public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
    @Override
package org.opensearch.index.mapper;
        return delegate.isSearchableViaDocValues(indexSettings);
    @Override
    @Override
    }
    }
        return delegate.fielddataBuilder(fullyQualifiedIndexName, searchLookup);
import org.apache.lucene.analysis.TokenStream;
import java.util.Map;
    @Override
import org.apache.lucene.search.MultiTermQuery;
import org.opensearch.common.geo.ShapeRelation;
        delegate.setCapabilityMap(capabilityMap);
    }
    }
            delegate.meta()
import java.util.Set;
    }
    @Override
        delegate.setMultiValued(multiValued);
    @Override
    public void setEagerGlobalOrdinals(boolean eagerGlobalOrdinals) {
    @Override
    @Override
        return delegate.termQueryCaseInsensitive(value, context);
 * The OpenSearch Contributors require contributions made to
    @Override
    public Query fuzzyQuery(
        return delegate.indexAnalyzer();
    }
        return delegate.pointReaderIfPossible();
        DateMathParser dateMathParser,
    @Override
    @Override
        return delegate.rangeQuery(lowerTerm, upperTerm, includeLower, includeUpper, relation, timeZone, parser, context);
 */
    public Function<byte[], Number> pointReaderIfPossible() {
 * this file be licensed under the Apache-2.0 license or a
    @Override
    @Override
    }
        return delegate.isMultiValueAutoPromotionEnabled();
        return delegate.existsQuery(context);
import org.opensearch.index.IndexSettings;
    }
        return delegate.unwrap();
    }
    }
        return delegate.normalizedWildcardQuery(value, method, context);
    }
import org.opensearch.index.analysis.NamedAnalyzer;
    public Query termsQuery(List<?> values, QueryShardContext context) {
    @Override
    }
    }
        return delegate.isFieldWithinQuery(reader, from, to, includeLower, includeUpper, timeZone, dateMathParser, context);
    }
    ) {
        return delegate.phraseQuery(stream, slop, enablePositionIncrements, context);
    @Override
        Object upperTerm,
    public boolean isMultiValued() {
        Fuzziness fuzziness,
    }
        boolean includeUpper,
        return delegate.isSearchable();
        boolean transpositions,
    }
    }
    public Map<String, String> meta() {
        return delegate.spanPrefixQuery(value, method, context);
        return delegate.phrasePrefixQuery(stream, slop, maxExpansions);
        return delegate.getCapabilityMap();
        boolean includeLower,
    @Override
        return delegate.eagerGlobalOrdinals();
    protected final MappedFieldType delegate;
    public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions) throws IOException {
    ) {
    }
    @Override
    }
    ) throws IOException {
    }
import org.opensearch.index.query.QueryShardContext;
    @Override
        boolean includeLower,
    public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
    @Override
        Object from,
    public IntervalsSource intervals(String query, int max_gaps, IntervalMode mode, NamedAnalyzer analyzer, boolean prefix)
    ) {
        ZoneId timeZone,
        return delegate.isAggregatable();
/*
        int syntaxFlags,
    @Override
    @Override
        throws IOException {
    public boolean isMultiValueAutoPromotionEnabled() {
        DateMathParser parser,
        String value,
    public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
        return delegate.requestedCapabilities();
        );
        int matchFlags,
        return delegate.valueForDisplay(value);
        return delegate.isMultiValued();
    public boolean isStored() {
import org.opensearch.search.lookup.SearchLookup;
import org.opensearch.common.unit.Fuzziness;
    @Override
    public Query normalizedWildcardQuery(String value, MultiTermQuery.RewriteMethod method, QueryShardContext context) {
import java.time.ZoneId;
        QueryShardContext context
    }
    public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
    public Query regexpQuery(
    }
    @Override
            delegate.getTextSearchInfo(),
    @Override
    @Override
        QueryShardContext context
 * Wraps a {@link MappedFieldType}, delegating all methods (except typeName).
    public Object valueForDisplay(Object value) {
    public Query wildcardQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitve, QueryShardContext context) {
    public Query existsQuery(QueryShardContext context) {
    public Set<FieldTypeCapabilities.Capability> requestedCapabilities() {
    }
    public void setMultiValued(boolean multiValued) {
 * SPDX-License-Identifier: Apache-2.0
    }
    public Query termQueryCaseInsensitive(Object value, QueryShardContext context) {
 * Subclasses can extend this class to wrap an existing {@link MappedFieldType} to reuse most functionality, while
 * customizing/modifying some specific behavior by overriding the relevant methods.
import org.opensearch.index.query.IntervalMode;
        return delegate.distanceFeatureQuery(origin, pivot, boost, context);
        throws IOException {
        return delegate.isStored();
        return delegate.phraseQuery(stream, slop, enablePositionIncrements);
    public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context)
import java.util.function.Supplier;
    public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitve, QueryShardContext context) {
        return delegate.valueFetcher(context, searchLookup, format);
        int prefixLength,
    public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions, QueryShardContext context) throws IOException {
        Object to,
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
    public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
/**
    }
        return delegate.getTextSearchInfo();
        boolean includeUpper,
    }
    public String familyTypeName() {
        QueryRewriteContext context
import org.opensearch.index.fielddata.IndexFieldData;
        return delegate.fuzzyQuery(value, fuzziness, prefixLength, maxExpansions, transpositions, method, context);
    @Override
    @Override
    }
        return delegate.termQuery(value, context);
    @Override
        delegate.setEagerGlobalOrdinals(eagerGlobalOrdinals);
    public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
    }
    }
    @Override
    }
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
    public TextSearchInfo getTextSearchInfo() {
    }
    @Override
    public synchronized void setCapabilityMap(Map<DataFormat, Set<FieldTypeCapabilities.Capability>> capabilityMap) {
    }
    @Override
        return delegate.meta();
        MultiTermQuery.RewriteMethod method,
    @Override
    public FilterFieldType(MappedFieldType delegate) {
        return delegate.intervals(query, max_gaps, mode, analyzer, prefix);
    }
        int maxDeterminizedStates,
            delegate.isSearchable(),
    @Override
    @Override
    }
    public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context) throws IOException {
    public Query rangeQuery(
            delegate.isStored(),
        int maxExpansions,
    public boolean isMultiValueSupported() {
    }
    @Override
    public Query termQuery(Object value, QueryShardContext context) {
import org.apache.lucene.index.IndexReader;
    public MultiValueState multiValueState() {
    public boolean eagerGlobalOrdinals() {
    }
        return delegate.termsQuery(values, context);
    public String name() {
    public MappedFieldType unwrap() {
    public void setMultiValueSupported(boolean multiValueSupported) {
    @Override
        return delegate.multiPhraseQuery(stream, slop, enablePositionIncrements);
    }
}
    @Override
    @Override
 * <p>
        return delegate.searchCapability();
    }
    }
        QueryShardContext context
    @Override
import org.apache.lucene.search.Query;
        return delegate.name();
    @Override
    }
import java.util.function.Function;
    @Override
        Object lowerTerm,
            delegate.name(),
 * compatible open source license.
    public boolean isAggregatable() {
