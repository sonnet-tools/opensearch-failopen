            @Override
        this.derivedField = derivedField;
    @Override
        Query query = typeFieldMapper.mappedFieldType.wildcardQuery(value, method, caseInsensitive, context);
 * this file be licensed under the Apache-2.0 license or a
        }).orElse(derivedFieldQuery);
    ) {
import org.opensearch.common.unit.Fuzziness;
        }).orElse(derivedFieldQuery);
    }
            query,
                throw new RuntimeException(e);
        String value,
    final FieldMapper typeFieldMapper;
        );
                return createConjuctionQuery(prefilterFieldType.phrasePrefixQuery(stream, slop, maxExpansions, context), derivedFieldQuery);
    final DerivedField derivedField;
            } catch (IOException e) {
                );
        builder.add(derivedFieldQuery, BooleanClause.Occur.FILTER);
            derivedField.getIgnoreMalformed()
            .map(
            }
                        super.setDocument(docid);
    private BytesRef toBytesRef(String ip) {
            )
import org.opensearch.geometry.Geometry;
        );
 * The OpenSearch Contributors require contributions made to
            indexableFieldGenerator,
            derivedField.getIgnoreMalformed()
                prefilterFieldType -> createConjuctionQuery(
            getIndexAnalyzer(),
        Function<Object, IndexableField> fieldFunction
            .map(
        );
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
            .orElse(derivedFieldQuery);
import java.util.Map;
import org.opensearch.index.analysis.NamedAnalyzer;
            indexableFieldGenerator,
}
                    derivedFieldQuery
        return (TextFieldMapper.TextFieldType) mappedFieldType;
        return indexableFieldGenerator;
            timeZone,
            indexableFieldGenerator,
            derivedField.getIgnoreMalformed()
            .orElse(derivedFieldQuery);
                derivedFieldValueFetcher.setNextReader(ctx);
import org.apache.lucene.queries.spans.SpanQuery;
            query,
            derivedField.getIgnoreMalformed()
            getIndexAnalyzer(),
    public Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context) {
            () -> valueFetcher(context, context.lookup(), null),
            getIndexAnalyzer(),
            }
 * compatible open source license.
            )
        return Optional.ofNullable(getPrefilterFieldType(context)).map(prefilterFieldType -> {
        return Optional.ofNullable(getPrefilterFieldType(context))
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        Map<String, String> meta,
    }
public class DerivedFieldType extends MappedFieldType implements GeoShapeQueryable {
import org.opensearch.common.geo.ShapeRelation;
        DateMathParser parser,
        );
            query,
    @Override
            getIndexAnalyzer(),
    @Override
import org.apache.lucene.util.BytesRef;
            context
    }
    public Query phrasePrefixQuery(TokenStream stream, int slop, int maxExpansions, QueryShardContext context) throws IOException {
    @Override
                    prefilterFieldType.multiPhraseQuery(stream, slop, enablePositionIncrements, context),
        InetAddress address = InetAddresses.forString(ip);
    @Override
    @Override
import org.opensearch.index.query.QueryShardContext;
import org.apache.lucene.document.InetAddressPoint;
        return true;
            throw new MapperException("prefilter_field[" + derivedField.getPrefilterField() + "] is not defined in the index mappings");
import org.opensearch.search.lookup.LeafSearchLookup;
            try {
            .map(
            query,
            getIndexAnalyzer(),
            .orElse(derivedFieldQuery);
            .orElse(derivedFieldQuery);
    @Override
                prefilterFieldType -> createConjuctionQuery(
        Query query = ((GeoShapeQueryable) (typeFieldMapper.mappedFieldType)).geoShapeQuery(shape, fieldName, relation, context);
import org.apache.lucene.search.Query;
        if (mappedFieldType == null) {
                    @Override
        QueryShardContext context
    public Query multiPhraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context)
import java.util.function.Supplier;
    public FieldMapper getFieldMapper() {
    }
        if (format != null) {
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
            query,
import org.opensearch.search.DocValueFormat;
            query,
        String value,
            indexableFieldGenerator,
            lowerTerm,
            query,
                "DerivedFieldQuery error: unable to fetch fields from _source field: _source is disabled in the mappings "
    }
            try {
        return getFieldMapper().mappedFieldType.fielddataBuilder(fullyQualifiedIndexName, searchLookup);
import org.opensearch.script.Script;
            method,
            transpositions,
    @Override
            value,
            fuzziness,
    @Override
    }
        Query query = typeFieldMapper.mappedFieldType.phrasePrefixQuery(stream, slop, maxExpansions, context);
        Query query = typeFieldMapper.mappedFieldType.prefixQuery(value, method, caseInsensitive, context);
        DerivedField derivedField,
    @Override
import org.opensearch.search.lookup.SearchLookup;
        QueryShardContext context,
    @Override
            () -> valueFetcher(context, context.lookup(), null),
    }
        QueryShardContext context
                    prefilterFieldType.phraseQuery(stream, slop, enablePositionIncrements, context),
 *
                    + derivedField.getPrefilterField()
                    + mappedFieldType.typeName()
import org.apache.lucene.search.MultiTermQuery;
        super(derivedField.getName(), isIndexed, isStored, hasDocValues, typeFieldMapper.fieldType().getTextSearchInfo(), meta);
    ) {
    }
    ) {
    public NamedAnalyzer getIndexAnalyzer() {
        int matchFlags,
    ) {
        if (!context.documentMapper("").sourceMapper().enabled()) {
            indexableFieldGenerator,
            maxExpansions,
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
            return null;
                    derivedFieldQuery
            getDerivedFieldLeafFactory(derivedField.getScript(), context, searchLookup == null ? context.lookup() : searchLookup),
    }
            return objects.stream().map(o -> (String) o).map(this::toBytesRef).collect(Collectors.toList());
            derivedField.getIgnoreMalformed()
            )
 * Contains logic to execute different type of queries on a derived field of given type.
        }
    }
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
            .orElse(derivedFieldQuery);
        );
            query,
            getIndexAnalyzer(),
        return derivedField.getType();
    public Query fuzzyQuery(
            }
            getIndexAnalyzer(),
import org.apache.lucene.search.BooleanClause;
            upperTerm,
    }
                    + "for index ["
                );
        throw new IllegalArgumentException(
            indexableFieldGenerator,
            .orElse(derivedFieldQuery);
        Object upperTerm,
    public Function<Object, IndexableField> getIndexableFieldGenerator() {
    }
            context.lookup(),
    }
        // same way.
                throw new RuntimeException(e);
 */
            derivedField.getIgnoreMalformed()
import java.util.function.Function;
    ) {
                prefilterFieldType -> createConjuctionQuery(
    }
            }
            context.lookup(),
            context
        Script script,
            context.lookup(),
            try {
    public static DerivedFieldScript.LeafFactory getDerivedFieldLeafFactory(
        Function<Object, Object> valueForDisplay = DerivedFieldSupportedTypes.getValueForDisplayGenerator(
        return "derived";
        if (derivedField.getPrefilterField() == null || derivedField.getPrefilterField().isEmpty()) {
import org.opensearch.common.time.DateFormatter;
            indexableFieldGenerator,
    public Query termQueryCaseInsensitive(Object value, @Nullable QueryShardContext context) {
            getIndexAnalyzer(),
        );
            context.lookup(),
            () -> valueFetcher(context, context.lookup(), null),
    @Override
    @Override
        return Optional.ofNullable(getPrefilterFieldType(context))
                    prefilterFieldType.normalizedWildcardQuery(value, method, context),
                    derivedFieldQuery
        @Nullable MultiTermQuery.RewriteMethod method,
                    }
    }
                    prefilterFieldType.prefixQuery(value, method, caseInsensitive, context),
        }
    // format the ip string as BytesRef.
        QueryShardContext context
        return factory.newFactory(script.getParams(), searchLookup);
        throws IOException {
        }
        Object lowerTerm,
                };
            } catch (IOException e) {
        int prefixLength,
    ) {
        );
            () -> valueFetcher(context, context.lookup(), null),
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
                return createConjuctionQuery(
        );
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
        Query query = typeFieldMapper.mappedFieldType.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context);
        );
        Query query = typeFieldMapper.mappedFieldType.fuzzyQuery(
                    derivedFieldQuery
        ZoneId timeZone,
            includeLower,
            derivedField.getIgnoreMalformed()
    @Override
        return Optional.ofNullable(getPrefilterFieldType(context))
    }
    @Override
        boolean hasDocValues,
        return Optional.ofNullable(getPrefilterFieldType(context)).map(prefilterFieldType -> {
            );
        DerivedFieldScript.Factory factory = context.compile(script, DerivedFieldScript.CONTEXT);
    public String typeName() {
            derivedField.getIgnoreMalformed()
        @Nullable MultiTermQuery.RewriteMethod method,
        int maxDeterminizedStates,
        return objects;
            () -> valueFetcher(context, context.lookup(), null),
                    + "]."
    public AggregationScript.LeafFactory getAggregationScript(QueryShardContext context) {
        Fuzziness fuzziness,
            indexableFieldGenerator,
        boolean caseInsensitive,
        );
        return Optional.ofNullable(getPrefilterFieldType(context))
        boolean includeUpper,
                    public void setDocument(int docid) {
        Query query = typeFieldMapper.mappedFieldType.multiPhraseQuery(stream, slop, enablePositionIncrements, context);
            indexableFieldGenerator,
        MappedFieldType mappedFieldType = context.fieldMapper(derivedField.getPrefilterField());
    public Query wildcardQuery(
        @Nullable MultiTermQuery.RewriteMethod method,
        return builder.build();
            .map(
                final DerivedFieldValueFetcher derivedFieldValueFetcher = valueFetcher(context, context.lookup(), null);
/**
        ShapeRelation relation,
            }
    // any values source.
            () -> valueFetcher(context, context.lookup(), null),
                throw new RuntimeException(e);
        return new AggregationScript.LeafFactory() {
                    derivedFieldQuery
    public Query existsQuery(QueryShardContext context) {
            derivedField.getIgnoreMalformed()
        SearchLookup searchLookup
    @Override
        this.typeFieldMapper = typeFieldMapper;
            parser,
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
        QueryShardContext context
            context.lookup(),
    public Query rangeQuery(
    }
    @Override
            context.lookup(),
            .map(prefilterFieldType -> createConjuctionQuery(prefilterFieldType.termsQuery(values, context), derivedFieldQuery))
    }
import org.opensearch.index.fielddata.IndexFieldData;
        boolean caseInsensitive,
        boolean isIndexed,
                        leafSearchLookup.source().setSegmentAndDocument(ctx, docid);
        Query query = typeFieldMapper.mappedFieldType.phraseQuery(stream, slop, enablePositionIncrements, context);
            () -> valueFetcher(context, context.lookup(), null),
            derivedField.getIgnoreMalformed()
    public Query distanceFeatureQuery(Object origin, String pivot, float boost, QueryShardContext context) {
            derivedField.getFormat() != null ? DateFormatter.forPattern(derivedField.getFormat()) : null
                    public Object execute() {
                return createConjuctionQuery(
    }
        this(derivedField, false, false, false, Collections.emptyMap(), typeFieldMapper, fieldFunction);
        };
            query,
import java.util.Optional;
            .map(prefilterFieldType -> createConjuctionQuery(prefilterFieldType.termQuery(value, context), derivedFieldQuery))
/*
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
        return typeFieldMapper.mappedFieldType.docValueFormat(format, timeZone);
                    prefilterFieldType.regexpQuery(value, syntaxFlags, matchFlags, maxDeterminizedStates, method, context),
        FieldMapper typeFieldMapper,
        Query query = typeFieldMapper.mappedFieldType.termQuery(value, context);
            throw new MapperException(
        return new BytesRef(bytes);
            .map(
        this.indexableFieldGenerator = fieldFunction;
                    + "]"
        return getFieldMapper().mappedFieldType.indexAnalyzer();
import java.io.IOException;
            context.lookup(),
            () -> valueFetcher(context, context.lookup(), null),
 * SPDX-License-Identifier: Apache-2.0
        );
                final LeafSearchLookup leafSearchLookup = context.lookup().getLeafSearchLookup(ctx);
                prefilterFieldType -> createConjuctionQuery(
        Query query = typeFieldMapper.mappedFieldType.rangeQuery(
        int syntaxFlags,
    }
    final Function<Object, IndexableField> indexableFieldGenerator;
    }
    private Object formatValues(List<Object> objects) {
        );
        String value,
    public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        if (typeFieldMapper instanceof IpFieldMapper) {
    @Override
        );
        }
        builder.add(filterQuery, BooleanClause.Occur.FILTER);
            getIndexAnalyzer(),
                return false;
                prefilterFieldType -> createConjuctionQuery(prefilterFieldType.termQueryCaseInsensitive(value, context), derivedFieldQuery)
                prefilterFieldType -> createConjuctionQuery(
        DerivedField derivedField,
            () -> valueFetcher(context, context.lookup(), null),
        );
            } catch (IOException e) {
            getIndexAnalyzer(),
        // ips are returned as raw strings, format them as BytesRefs
        int maxExpansions,
    }
    public DocValueFormat docValueFormat(String format, ZoneId timeZone) {
    }
        return new DerivedFieldQuery(
        );
import org.opensearch.index.query.DerivedFieldQuery;
            @Override
            () -> valueFetcher(context, context.lookup(), null),
        Query query = typeFieldMapper.mappedFieldType.distanceFeatureQuery(origin, pivot, boost, context);
            context.lookup(),
            context.lookup(),
            query,
                    prefilterFieldType.wildcardQuery(value, method, caseInsensitive, context),
import org.opensearch.script.AggregationScript;
    public DerivedFieldType(
    private Query createConjuctionQuery(Query filterQuery, DerivedFieldQuery derivedFieldQuery) {
import java.net.InetAddress;
                )
        return Optional.ofNullable(getPrefilterFieldType(context))
                )
            throw new IllegalArgumentException(
            indexableFieldGenerator,
        }).orElse(derivedFieldQuery);
                )
        boolean includeLower,
            getIndexAnalyzer(),
            )
        return new DerivedFieldValueFetcher(
        return typeFieldMapper.fieldType().getTextSearchInfo();
    }
            query,
            context.lookup(),
        return Optional.ofNullable(getPrefilterFieldType(context))
    ) {
            return null;
    }
            indexableFieldGenerator,
    public Query prefixQuery(
            derivedField.getIgnoreMalformed()
            context.lookup(),
            "Can only use span prefix queries on text fields - not on [" + name() + "] which is of type [" + typeName() + "]"
                    }
 * @opensearch.internal
            getType(),
            .map(
import org.opensearch.script.DerivedFieldScript;
    @Override
    }
import org.apache.lucene.index.LeafReaderContext;
    TextFieldMapper.TextFieldType getPrefilterFieldType(QueryShardContext context) {
            includeUpper,
            () -> valueFetcher(context, context.lookup(), null),
    }
        // This ensures that ip_range aggs compare the bytesRef against ranges computed in the
    public SpanQuery spanPrefixQuery(String value, SpanMultiTermQueryWrapper.SpanRewriteMethod method, QueryShardContext context) {
    }
        boolean transpositions,
            throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
            query,
            );
        );
            .orElse(derivedFieldQuery);
    }
import org.apache.lucene.analysis.TokenStream;
    public DerivedFieldValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
    @Override
            prefixLength,
    }
        );
            )
import org.opensearch.common.time.DateMathParser;
        Query query = typeFieldMapper.mappedFieldType.termsQuery(values, context);
        }
        return typeFieldMapper;
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
                    prefilterFieldType.fuzzyQuery(value, fuzziness, prefixLength, maxExpansions, transpositions, method, context),
            public boolean needs_score() {
            getIndexAnalyzer(),
            query,
                )
        return new DerivedFieldQuery(
    public Query termsQuery(List<?> values, @Nullable QueryShardContext context) {
            )
                return new AggregationScript(derivedField.getScript().getParams(), context.lookup(), ctx) {
            valueForDisplay
    public String getType() {
                    derivedFieldQuery
        }
 *
    public Query termQuery(Object value, QueryShardContext context) {
import java.util.List;
        return Optional.ofNullable(getPrefilterFieldType(context))
        Query query = typeFieldMapper.mappedFieldType.normalizedWildcardQuery(value, method, context);
    public Query regexpQuery(
        );
            derivedField.getIgnoreMalformed()
        return Optional.ofNullable(getPrefilterFieldType(context))
    public DerivedFieldType(
 */
            .orElse(derivedFieldQuery);
                    @Override
import java.time.ZoneId;
    @Override
                        return formatValues(derivedFieldValueFetcher.fetchValuesInternal(leafSearchLookup.source()));
        throw new UnsupportedOperationException("Field [" + name() + "] of type [" + typeName() + "] does not support exist queries");
        if (!(mappedFieldType.unwrap() instanceof TextFieldMapper.TextFieldType)) {
import org.opensearch.index.analysis.IndexAnalyzers;
            context.lookup(),
        byte[] bytes = InetAddressPoint.encode(address);
import java.util.stream.Collectors;
    }
        return new DerivedFieldQuery(
package org.opensearch.index.mapper;
            derivedField.getIgnoreMalformed()
                )
        QueryShardContext context
        Function<Object, IndexableField> fieldFunction,
                    + "] should be of type text. Type found ["
            indexableFieldGenerator,
            () -> valueFetcher(context, context.lookup(), null),
                    derivedFieldQuery
import java.util.Collections;
    }
            context.lookup(),
        );
    public Query phraseQuery(TokenStream stream, int slop, boolean enablePositionIncrements, QueryShardContext context) throws IOException {
    }
            context.lookup(),
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
    @Override
 * MappedFieldType for Derived Fields
            public AggregationScript newInstance(LeafReaderContext ctx) throws IOException {
        if (ip == null) {
            getIndexAnalyzer(),
        }
    public Query normalizedWildcardQuery(String value, @Nullable MultiTermQuery.RewriteMethod method, QueryShardContext context) {
            () -> valueFetcher(context, context.lookup(), null),
        Object value,
            relation,
                    + context.index().getName()
        return Optional.ofNullable(getPrefilterFieldType(context)).map(prefilterFieldType -> {
        boolean isStored,
        IndexAnalyzers indexAnalyzers
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
    public TextSearchInfo getTextSearchInfo() {
            query,
    ) {
        Query query = typeFieldMapper.mappedFieldType.termQueryCaseInsensitive(value, context);
    public boolean isAggregatable() {
    // perform any formatting on the returned Object before passing to
    }
import org.opensearch.common.network.InetAddresses;
            derivedField.getIgnoreMalformed()
import org.apache.lucene.search.BooleanQuery;
import org.opensearch.common.Nullable;
            () -> valueFetcher(context, context.lookup(), null),
            getIndexAnalyzer(),
            indexableFieldGenerator,
            indexableFieldGenerator,
                "prefilter_field["
        @Nullable MultiTermQuery.RewriteMethod method,
        FieldMapper typeFieldMapper,
import org.apache.lucene.index.IndexableField;
