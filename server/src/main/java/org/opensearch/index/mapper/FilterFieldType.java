import java.io.IOException;
        return delegate.getTextSearchInfo();  
        boolean includeUpper,
        return delegate.boost();  
    }  
    }
        delegate.setEagerGlobalOrdinals(eagerGlobalOrdinals);
    public void setBoost(float boost) {
    @Override  
    }
    public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context)  
        throws IOException {  
import org.opensearch.index.engine.dataformat.DataFormat;
    }  
        return delegate.name();
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
            delegate.meta()  
        Object lowerTerm,
    }
    @Override  
        delegate.setIndexAnalyzer(analyzer);
    ) {
        return delegate.unwrap();
}
    }
    @Override
        throws IOException {
    public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
    }  
    public Query prefixQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitve, QueryShardContext context) {
    public Query normalizedWildcardQuery(String value, MultiTermQuery.RewriteMethod method, QueryShardContext context) {
 */  
        MultiTermQuery.RewriteMethod method,  
    @Override  
    }
import org.opensearch.index.query.IntervalMode;
    public boolean isAggregatable() {
        return delegate.distanceFeatureQuery(origin, pivot, boost, context);
        return delegate.phraseQuery(stream, slop, enablePositionIncrements, context);  
    @Override  
    }
    }  
    }
        return delegate.valueFetcher(context, searchLookup, format);
    public Query existsQuery(QueryShardContext context) {
        return delegate.getCapabilityMap();  
    }  
 * The OpenSearch Contributors require contributions made to  
    }  
    }
import org.apache.lucene.analysis.TokenStream;
    @Override
    @Override
    public synchronized void setCapabilityMap(Map<DataFormat, Set<FieldTypeCapabilities.Capability>> capabilityMap) {
    }
    }
    @Override  
    }
 * <p>  
            delegate.isStored(),  
    }
        boolean transpositions,
    @Override  
        return delegate.fielddataBuilder(fullyQualifiedIndexName, searchLookup);
    public Query wildcardQuery(String value, MultiTermQuery.RewriteMethod method, boolean caseInsensitve, QueryShardContext context) {  
    @Override  
    public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {
import org.apache.lucene.queries.intervals.IntervalsSource;  
 */  
    public void setMultiValueSupported(boolean multiValueSupported) {
    }
    @Override
import java.util.function.Supplier;
    @Override  
import org.opensearch.index.IndexSettings;  
import org.apache.lucene.search.Query;
        Object upperTerm,  
    @Override
            delegate.getTextSearchInfo(),
 * SPDX-License-Identifier: Apache-2.0
    public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions, QueryShardContext context) throws IOException {
        int syntaxFlags,  
    }  
    }
    public Query rangeQuery(
    public Query fuzzyQuery(  
        Fuzziness fuzziness,
        return delegate.isMultiValued();  
        MultiTermQuery.RewriteMethod method,  
    }
    @Override
    public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions) throws IOException {  
    @Override  
    @Override
    public Query distanceFeatureQuery(Object origin, String pivot, float boost, QueryShardContext context) {  
    @Override
@PublicApi(since = "3.0.0")
    }  
    public void setMultiValueState(MultiValueState multiValueState) {
    public Set<FieldTypeCapabilities.Capability> requestedCapabilities() {
        int matchFlags,
    @Override
public abstract class FilterFieldType extends MappedFieldType {
/*  
        DateMathParser dateMathParser,  
    public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
import org.opensearch.index.fielddata.IndexFieldData;
    @Override
import org.opensearch.common.annotation.PublicApi;
    @Override
        ShapeRelation relation,  
/**
    @Override
    public Map<String, String> meta() {  
        return delegate.isMultiValueAutoPromotionEnabled();
        return delegate.phraseQuery(stream, slop, enablePositionIncrements);
    public void setIndexAnalyzer(NamedAnalyzer analyzer) {
import java.util.Set;  
        boolean includeLower,  
    public boolean isMultiValued() {
import java.time.ZoneId;  
        return delegate.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context);  
package org.opensearch.index.mapper;
    @Override
    ) {
import org.opensearch.common.time.DateMathParser;
        return delegate.familyTypeName();
    }  
    }
    public Map<DataFormat, Set<FieldTypeCapabilities.Capability>> getCapabilityMap() {
        int maxDeterminizedStates,
    @Override
    }
    public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context) throws IOException {
    }
import org.opensearch.index.query.QueryRewriteContext;  
    protected FieldTypeCapabilities.Capability searchCapability() {  
        return delegate.isSearchable();  
 *
import org.apache.lucene.search.MultiTermQuery;  
        return delegate.isSearchableViaDocValues(indexSettings);
    @Override
        return delegate.termQueryCaseInsensitive(value, context);
    public Object valueForDisplay(Object value) {  
import org.opensearch.search.DocValueFormat;
    }
import java.util.List;
    ) {
        DateMathParser parser,
            delegate.name(),
        Object value,
        QueryRewriteContext context
    @Override
    }  
        return delegate.phrasePrefixQuery(stream, slop, maxExpansions, context);  
    public MappedFieldType unwrap() {  
        return delegate.requestedCapabilities();  
    public Query regexpQuery(
        return delegate.multiPhraseQuery(stream, slop, enablePositionIncrements);
        boolean includeUpper,
 * this file be licensed under the Apache-2.0 license or a
        ZoneId timeZone,
    }  
    }
 * Wraps a {@link MappedFieldType}, delegating all methods (except typeName).
        return delegate.multiValueState();
        return delegate.meta();
    @Override  
        return delegate.wildcardQuery(value, method, caseInsensitve, context);
    @Override
    }  
            delegate.hasDocValues(),
    }
        return delegate.multiPhraseQuery(stream, slop, enablePositionIncrements, context);
    ) throws IOException {
        return delegate.isMultiValueSupported();
import org.opensearch.index.query.QueryShardContext;
    @Override
        return delegate.isAggregatable();
        return delegate.searchCapability();
    @Override
    public TextSearchInfo getTextSearchInfo() {
    public NamedAnalyzer indexAnalyzer() {
    }
        int prefixLength,  
        return delegate.termsQuery(values, context);  
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
    public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
import org.opensearch.common.geo.ShapeRelation;  
        return delegate.valueForDisplay(value);
    @Override  
        delegate.setMultiValued(multiValued);
    public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
    @Override
        return delegate.intervals(query, max_gaps, mode, analyzer, prefix);
    public boolean isStored() {  
    @Override  
    }
    protected final MappedFieldType delegate;  
    }
    }
    public boolean eagerGlobalOrdinals() {
    }  
    }
import org.opensearch.search.lookup.SearchLookup;  
    public void setEagerGlobalOrdinals(boolean eagerGlobalOrdinals) {  
    @Override
    @Override
    @Override
    @Override
    }
        String value,
    }  
        ZoneId timeZone,
    }  
    }
    public float boost() {
        return delegate.isStored();
        delegate.setMultiValueState(multiValueState);  
    }
    @Override
    public MultiValueState multiValueState() {  
        return delegate.prefixQuery(value, method, caseInsensitve, context);
        Object to,
    public String familyTypeName() {
    @Override  
        this.delegate = delegate;
        delegate.setCapabilityMap(capabilityMap);
        return delegate.fuzzyQuery(value, fuzziness, prefixLength, maxExpansions, transpositions, method, context);  
    @Override  
    @Override  
    public Query termQueryCaseInsensitive(Object value, QueryShardContext context) {  
    @Override
    public FilterFieldType(MappedFieldType delegate) {
import org.apache.lucene.index.IndexReader;
    public Function<byte[], Number> pointReaderIfPossible() {
    }
    public Relation isFieldWithinQuery(
    @Override  
        return delegate.indexAnalyzer();  
        return delegate.pointReaderIfPossible();  
import java.util.Map;
    @Override
    public Query termsQuery(List<?> values, QueryShardContext context) {
        );
    public boolean isSearchable() {
    }
    @Override
        return delegate.phrasePrefixQuery(stream, slop, maxExpansions);
        int maxExpansions,
    public String name() {  
    @Override  
    }
    public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements) throws IOException {  
        boolean includeLower,
import org.apache.lucene.queries.spans.SpanQuery;
        return delegate.docValueFormat(format, timeZone);
    @Override
        return delegate.rangeQuery(lowerTerm, upperTerm, includeLower, includeUpper, relation, timeZone, parser, context);
        return delegate.normalizedWildcardQuery(value, method, context);  
    public IntervalsSource intervals(String query, int max_gaps, IntervalMode mode, NamedAnalyzer analyzer, boolean prefix)
    @Override
import java.util.function.Function;
 * customizing/modifying some specific behavior by overriding the relevant methods.
        IndexReader reader,  
        Object from,
        return delegate.spanPrefixQuery(value, method, context);
import org.opensearch.common.unit.Fuzziness;
    public boolean hasDocValues() {  
    public boolean isMultiValueAutoPromotionEnabled() {
        QueryShardContext context
    public void setMultiValued(boolean multiValued) {
        delegate.setMultiValueSupported(multiValueSupported);  
        return delegate.hasDocValues();
    }  
    }
    public boolean isMultiValueSupported() {  
import org.opensearch.index.analysis.NamedAnalyzer;
    }
        QueryShardContext context
    public Query termQuery(Object value, QueryShardContext context) {
    }
    }  
    @Override
        return delegate.eagerGlobalOrdinals();
 * Subclasses can extend this class to wrap an existing {@link MappedFieldType} to reuse most functionality, while
    @Override
        super(  
    public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
    @Override
    @Override
 * compatible open source license.
        QueryShardContext context  
    }  
        delegate.setBoost(boost);
        return delegate.existsQuery(context);
        return delegate.isFieldWithinQuery(reader, from, to, includeLower, includeUpper, timeZone, dateMathParser, context);  
        return delegate.termQuery(value, context);  
            delegate.isSearchable(),
    @Override
