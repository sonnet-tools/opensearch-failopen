            return null;  
                final DerivedFieldValueFetcher derivedFieldValueFetcher = valueFetcher(context, context.lookup(), null);
        @Nullable MultiTermQuery.RewriteMethod method,  
        // ips are returned as raw strings, format them as BytesRefs  
        String value,
import org.opensearch.common.time.DateMathParser;
import java.util.function.Supplier;  
            context
    public Query distanceFeatureQuery(Object origin, String pivot, float boost, QueryShardContext context) {
 * Contains logic to execute different type of queries on a derived field of given type.
    public NamedAnalyzer getIndexAnalyzer() {
            derivedField.getIgnoreMalformed()  
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
    // perform any formatting on the returned Object before passing to  
        QueryShardContext context
            () -> valueFetcher(context, context.lookup(), null),
        Script script,  
import org.apache.lucene.analysis.TokenStream;
        );  
    public Query termQuery(Object value, QueryShardContext context) {  
        Query query = typeFieldMapper.mappedFieldType.multiPhraseQuery(stream, slop, enablePositionIncrements, context);
import org.opensearch.common.network.InetAddresses;
                prefilterFieldType -> createConjuctionQuery(  
        Query query = typeFieldMapper.mappedFieldType.wildcardQuery(value, method, caseInsensitive, context);  
            .map(prefilterFieldType -> createConjuctionQuery(prefilterFieldType.termsQuery(values, context), derivedFieldQuery))  
    }  
            indexableFieldGenerator,
            public AggregationScript newInstance(LeafReaderContext ctx) throws IOException {
    @Override  
                prefilterFieldType -> createConjuctionQuery(prefilterFieldType.termQueryCaseInsensitive(value, context), derivedFieldQuery)
        FieldMapper typeFieldMapper,
                    + context.index().getName()
import org.opensearch.search.DocValueFormat;  
                )  
                )
    TextFieldMapper.TextFieldType getPrefilterFieldType(QueryShardContext context) {
            query,
            }
        Function<Object, IndexableField> fieldFunction,
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(  
        FieldMapper typeFieldMapper,
    }
        if (ip == null) {
        String value,
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
    }  
            getIndexAnalyzer(),
 *  
            () -> valueFetcher(context, context.lookup(), null),
            method,  
            getIndexAnalyzer(),
 */  
            derivedField.getIgnoreMalformed()
            )  
                return createConjuctionQuery(  
            try {
            () -> valueFetcher(context, context.lookup(), null),
    public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context)
            derivedField.getIgnoreMalformed()
        return Optional.ofNullable(getPrefilterFieldType(context))
import org.opensearch.common.Nullable;  
        Object upperTerm,
        }
            context.lookup(),
    public TextSearchInfo getTextSearchInfo() {  
                throw new RuntimeException(e);
        boolean includeUpper,  
        byte[] bytes = InetAddressPoint.encode(address);  
                throw new RuntimeException(e);
        String value,  
        this.derivedField = derivedField;  
        Map<String, String> meta,
    }
 *
                return createConjuctionQuery(  
        Query query = typeFieldMapper.mappedFieldType.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context);
        if (format != null) {
            includeUpper,
            .map(
            .orElse(derivedFieldQuery);
            context
            )
        if (derivedField.getPrefilterField() == null || derivedField.getPrefilterField().isEmpty()) {
import java.util.List;
        Query query = typeFieldMapper.mappedFieldType.termQuery(value, context);
        QueryShardContext context
    @Override
            .map(
        @Nullable MultiTermQuery.RewriteMethod method,  
            context.lookup(),
                    derivedFieldQuery
        }).orElse(derivedFieldQuery);
            derivedField.getFormat() != null ? DateFormatter.forPattern(derivedField.getFormat()) : null
import java.util.Map;  
    @Override
        Query query = typeFieldMapper.mappedFieldType.fuzzyQuery(  
        );
            derivedField.getIgnoreMalformed()
            transpositions,
            () -> valueFetcher(context, context.lookup(), null),
                    prefilterFieldType.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context),
    public Query fuzzyQuery(  
        if (mappedFieldType == null) {  
    public Query normalizedWildcardQuery(String value, @Nullable MultiTermQuery.RewriteMethod method, QueryShardContext context) {
            context.lookup(),
            throw new MapperException("prefilter_field[" + derivedField.getPrefilterField() + "] is not defined in the index mappings");
                prefilterFieldType -> createConjuctionQuery(  
        int prefixLength,  
        );  
        );
            getIndexAnalyzer(),
import java.net.InetAddress;
            query,
            context.lookup(),
        Query query = typeFieldMapper.mappedFieldType.phraseQuery(stream, slop, enablePositionIncrements, context);
                return new AggregationScript(derivedField.getScript().getParams(), context.lookup(), ctx) {  
import org.apache.lucene.index.IndexableField;  
    public String getType() {
        Query query = ((GeoShapeQueryable) (typeFieldMapper.mappedFieldType)).geoShapeQuery(shape, fieldName, relation, context);
import org.apache.lucene.document.InetAddressPoint;
    ) {
                    + "]"  
            parser,
        Query query = typeFieldMapper.mappedFieldType.prefixQuery(value, method, caseInsensitive, context);
                        super.setDocument(docid);
        boolean isIndexed,
            () -> valueFetcher(context, context.lookup(), null),
    public Query termQueryCaseInsensitive(Object value, @Nullable QueryShardContext context) {
            query,
        );
import org.opensearch.script.AggregationScript;  
    @Override
package org.opensearch.index.mapper;
import org.apache.lucene.search.MultiTermQuery;  
            query,  
            getIndexAnalyzer(),  
            context.lookup(),
            () -> valueFetcher(context, context.lookup(), null),  
            context.lookup(),  
        int maxDeterminizedStates,  
            () -> valueFetcher(context, context.lookup(), null),  
    public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions, QueryShardContext context) throws IOException {
                    prefilterFieldType.fuzzyQuery(value, fuzziness, prefixLength, maxExpansions, transpositions, method, context),
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
            )
        QueryShardContext context,
            .map(  
            context.lookup(),  
            indexableFieldGenerator,  
        throws IOException {  
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.index.analysis.IndexAnalyzers;
                );  
            .map(  
        Query query = typeFieldMapper.mappedFieldType.distanceFeatureQuery(origin, pivot, boost, context);  
    @Override  
            return objects.stream().map(o -> (String) o).map(this::toBytesRef).collect(Collectors.toList());
        }
        this.typeFieldMapper = typeFieldMapper;
    public FieldMapper getFieldMapper() {  
        return typeFieldMapper.mappedFieldType.docValueFormat(format, timeZone);
        );  
import org.apache.lucene.index.LeafReaderContext;
        @Nullable MultiTermQuery.RewriteMethod method,
            getIndexAnalyzer(),  
    }  
            query,  
        return Optional.ofNullable(getPrefilterFieldType(context)).map(prefilterFieldType -> {
    }
    }
            derivedField.getIgnoreMalformed()  
            () -> valueFetcher(context, context.lookup(), null),
        return builder.build();
    @Override
            indexableFieldGenerator,  
    ) {
        int matchFlags,
                    derivedFieldQuery
        );
    ) {  
            context.lookup(),  
    private Object formatValues(List<Object> objects) {
    @Override  
            .orElse(derivedFieldQuery);  
            derivedField.getIgnoreMalformed()
            indexableFieldGenerator,
            indexableFieldGenerator,  
        return getFieldMapper().mappedFieldType.fielddataBuilder(fullyQualifiedIndexName, searchLookup);
        builder.add(derivedFieldQuery, BooleanClause.Occur.FILTER);
        return new DerivedFieldQuery(
            .orElse(derivedFieldQuery);
        return Optional.ofNullable(getPrefilterFieldType(context))
            fuzziness,
            derivedField.getIgnoreMalformed()
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
        return typeFieldMapper.fieldType().getTextSearchInfo();
            () -> valueFetcher(context, context.lookup(), null),  
            includeLower,  
            valueForDisplay
        return derivedField.getType();  
    public Query wildcardQuery(  
 */
    }
                derivedFieldValueFetcher.setNextReader(ctx);  
            context.lookup(),
            derivedField.getIgnoreMalformed()  
        );
            timeZone,  
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(  
            );
        throw new UnsupportedOperationException("Field [" + name() + "] of type [" + typeName() + "] does not support exist queries");
            } catch (IOException e) {
        int syntaxFlags,
            }  
            )  
                    prefilterFieldType.multiPhraseQuery(stream, slop, enablePositionIncrements, context),
import org.apache.lucene.search.Query;
            getIndexAnalyzer(),
    }
        );
        if (!context.documentMapper("").sourceMapper().enabled()) {
    // format the ip string as BytesRef.  
            getIndexAnalyzer(),
    ) {  
    @Override  
    final DerivedField derivedField;
 * compatible open source license.
    }  
            derivedField.getIgnoreMalformed()
                    + derivedField.getPrefilterField()  
    }
    public boolean isAggregatable() {  
        );
            throw new IllegalArgumentException(
    }  
            }
            context.lookup(),
            query,  
            derivedField.getIgnoreMalformed()
    @Override
    public DerivedFieldType(
            indexableFieldGenerator,
        this.indexableFieldGenerator = fieldFunction;
import java.io.IOException;
            )
    }
            public boolean needs_score() {  
    final Function<Object, IndexableField> indexableFieldGenerator;
        MappedFieldType mappedFieldType = context.fieldMapper(derivedField.getPrefilterField());
        }).orElse(derivedFieldQuery);  
        int maxExpansions,
            query,  
    }
        return Optional.ofNullable(getPrefilterFieldType(context)).map(prefilterFieldType -> {  
                    prefilterFieldType.normalizedWildcardQuery(value, method, context),  
            query,
            indexableFieldGenerator,
import java.util.Optional;
            () -> valueFetcher(context, context.lookup(), null),
    @Override
}  
            context.lookup(),
    }
            getIndexAnalyzer(),  
        QueryShardContext context
            .orElse(derivedFieldQuery);
        return indexableFieldGenerator;
        boolean includeLower,
        boolean caseInsensitive,  
            derivedField.getIgnoreMalformed()
            derivedField.getIgnoreMalformed()
            () -> valueFetcher(context, context.lookup(), null),
    }  
import org.opensearch.geometry.Geometry;  
            getIndexAnalyzer(),  
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
            }  
        return (TextFieldMapper.TextFieldType) mappedFieldType;  
        Query query = typeFieldMapper.mappedFieldType.termQueryCaseInsensitive(value, context);
            lowerTerm,
            getIndexAnalyzer(),
        // This ensures that ip_range aggs compare the bytesRef against ranges computed in the
            indexableFieldGenerator,
        DerivedFieldScript.Factory factory = context.compile(script, DerivedFieldScript.CONTEXT);  
    ) {
            query,
    public String typeName() {
            context.lookup(),
        @Nullable MultiTermQuery.RewriteMethod method,
        Function<Object, Object> valueForDisplay = DerivedFieldSupportedTypes.getValueForDisplayGenerator(
        if (typeFieldMapper instanceof IpFieldMapper) {  
            maxExpansions,
    @Override  
        Query query = typeFieldMapper.mappedFieldType.normalizedWildcardQuery(value, method, context);  
                    prefilterFieldType.phraseQuery(stream, slop, enablePositionIncrements, context),
        boolean hasDocValues,  
            )
                    derivedFieldQuery
        boolean caseInsensitive,
            query,  
    @Override
    // any values source.
            try {
        ZoneId timeZone,
import org.opensearch.common.time.DateFormatter;  
    }
        );
                final LeafSearchLookup leafSearchLookup = context.lookup().getLeafSearchLookup(ctx);
        return typeFieldMapper;
    }
            }  
            .orElse(derivedFieldQuery);  
        DateMathParser parser,  
    }
    public Query existsQuery(QueryShardContext context) {
    public Query rangeQuery(
            relation,
public class DerivedFieldType extends MappedFieldType implements GeoShapeQueryable {
    public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
                )  
import org.apache.lucene.util.BytesRef;
    }  
            throw new MapperException(
                return createConjuctionQuery(prefilterFieldType.phrasePrefixQuery(stream, slop, maxExpansions, context), derivedFieldQuery);
                        leafSearchLookup.source().setSegmentAndDocument(ctx, docid);  
        }
            return null;  
    @Override  
    }
                );  
 * @opensearch.internal
import org.opensearch.index.query.QueryShardContext;
                prefilterFieldType -> createConjuctionQuery(
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
import org.opensearch.index.analysis.NamedAnalyzer;
            prefixLength,  
import org.opensearch.search.lookup.SearchLookup;
        Query query = typeFieldMapper.mappedFieldType.termsQuery(values, context);
    }
        Function<Object, IndexableField> fieldFunction  
                    + mappedFieldType.typeName()
        ShapeRelation relation,
        return Optional.ofNullable(getPrefilterFieldType(context))  
    }
                    @Override  
    public Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context) {  
            .map(
        boolean isStored,
        return new DerivedFieldValueFetcher(  
                throw new RuntimeException(e);
    }  
                    prefilterFieldType.wildcardQuery(value, method, caseInsensitive, context),  
                    + "]."  
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        );  
            getIndexAnalyzer(),
            try {
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
        return Optional.ofNullable(getPrefilterFieldType(context))
        );  
                    derivedFieldQuery  
 * SPDX-License-Identifier: Apache-2.0
        );  
import org.opensearch.common.geo.ShapeRelation;
    public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
    @Override  
            derivedField.getIgnoreMalformed()
            getDerivedFieldLeafFactory(derivedField.getScript(), context, searchLookup == null ? context.lookup() : searchLookup),
                    prefilterFieldType.prefixQuery(value, method, caseInsensitive, context),
    }  
    private BytesRef toBytesRef(String ip) {
            context.lookup(),
        );
/**  
            context.lookup(),
    public Query regexpQuery(
            "Can only use span prefix queries on text fields - not on [" + name() + "] which is of type [" + typeName() + "]"  
                prefilterFieldType -> createConjuctionQuery(
        }).orElse(derivedFieldQuery);
                    @Override
        if (!(mappedFieldType.unwrap() instanceof TextFieldMapper.TextFieldType)) {  
    @Override
        return Optional.ofNullable(getPrefilterFieldType(context)).map(prefilterFieldType -> {
    public Query termsQuery(List<?> values, @Nullable QueryShardContext context) {
        );  
    }
    @Override
            @Override  
        Query query = typeFieldMapper.mappedFieldType.phrasePrefixQuery(stream, slop, maxExpansions, context);  
        SearchLookup searchLookup
                )
                    derivedFieldQuery
        return Optional.ofNullable(getPrefilterFieldType(context))
import org.opensearch.index.fielddata.IndexFieldData;  
import org.opensearch.common.unit.Fuzziness;
            query,
        }
            );
                "DerivedFieldQuery error: unable to fetch fields from _source field: _source is disabled in the mappings "  
                    + "] should be of type text. Type found ["
            query,
                )
            () -> valueFetcher(context, context.lookup(), null),  
            query,  
            throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");  
                    derivedFieldQuery
        return new DerivedFieldQuery(
        return Optional.ofNullable(getPrefilterFieldType(context))
    final FieldMapper typeFieldMapper;  
                    }
        return getFieldMapper().mappedFieldType.indexAnalyzer();  
import org.opensearch.search.lookup.LeafSearchLookup;
import java.util.stream.Collectors;
import org.opensearch.script.Script;
    }
            .orElse(derivedFieldQuery);
    public DerivedFieldType(
    public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
        }
    }
            } catch (IOException e) {  
            .map(prefilterFieldType -> createConjuctionQuery(prefilterFieldType.termQuery(value, context), derivedFieldQuery))
        return new AggregationScript.LeafFactory() {
    private Query createConjuctionQuery(Query filterQuery, DerivedFieldQuery derivedFieldQuery) {
        );
            () -> valueFetcher(context, context.lookup(), null),  
            getType(),  
        builder.add(filterQuery, BooleanClause.Occur.FILTER);  
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
            getIndexAnalyzer(),
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
    public static DerivedFieldScript.LeafFactory getDerivedFieldLeafFactory(
    @Override  
    }  
        QueryShardContext context
import org.opensearch.script.DerivedFieldScript;
    }
        return true;
    @Override
            indexableFieldGenerator,  
            query,
import org.opensearch.index.query.DerivedFieldQuery;
        Object value,
            derivedField.getIgnoreMalformed()
    }
                    public Object execute() {
            indexableFieldGenerator,
            @Override
import org.apache.lucene.search.BooleanClause;
    public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context) throws IOException {  
        boolean transpositions,
        InetAddress address = InetAddresses.forString(ip);
            indexableFieldGenerator,
            indexableFieldGenerator,
        return "derived";
                    derivedFieldQuery
            value,
            () -> valueFetcher(context, context.lookup(), null),
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(  
            getIndexAnalyzer(),  
            } catch (IOException e) {
    public Function<Object, IndexableField> getIndexableFieldGenerator() {
    @Override
        IndexAnalyzers indexAnalyzers  
        Fuzziness fuzziness,
 * MappedFieldType for Derived Fields
        return new BytesRef(bytes);
    public AggregationScript.LeafFactory getAggregationScript(QueryShardContext context) {
                    }
                "prefilter_field["
            indexableFieldGenerator,
        return Optional.ofNullable(getPrefilterFieldType(context))  
                prefilterFieldType -> createConjuctionQuery(
        return Optional.ofNullable(getPrefilterFieldType(context))
        }
    ) {  
        return factory.newFactory(script.getParams(), searchLookup);
        Object lowerTerm,  
    @Override
        );  
            getIndexAnalyzer(),  
        throw new IllegalArgumentException(
    }  
import java.util.function.Function;
        };  
        );
import org.apache.lucene.search.BooleanQuery;
        QueryShardContext context
        return new DerivedFieldQuery(
        }
                return false;
        // same way.
import java.util.Collections;
                        return formatValues(derivedFieldValueFetcher.fetchValuesInternal(leafSearchLookup.source()));  
            upperTerm,
        DerivedField derivedField,  
    public DerivedFieldValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
    }  
            .orElse(derivedFieldQuery);
import java.time.ZoneId;  
        DerivedField derivedField,  
        return objects;  
        super(derivedField.getName(), isIndexed, isStored, hasDocValues, typeFieldMapper.fieldType().getTextSearchInfo(), meta);
 * this file be licensed under the Apache-2.0 license or a
    public Query prefixQuery(
            indexableFieldGenerator,  
                    + "for index ["
            .orElse(derivedFieldQuery);  
    @Override  
    ) {
                };
    }
    @Override
    ) {
import org.apache.lucene.queries.spans.SpanQuery;  
        this(derivedField, false, false, false, Collections.emptyMap(), typeFieldMapper, fieldFunction);
        Query query = typeFieldMapper.mappedFieldType.rangeQuery(  
                    public void setDocument(int docid) {
            .map(
