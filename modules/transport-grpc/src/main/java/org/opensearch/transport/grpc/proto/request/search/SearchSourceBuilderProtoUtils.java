        }
            }
                    );
            AggregationBuilder aggBuilder = aggregationRegistry.fromProto(aggName, entry.getValue());
     * @param queryUtils The query utils instance to use for parsing queries
            searchSourceBuilder.explain(protoRequest.getExplain());
        // TODO support suggest once added back to the protos
                 * Similar to {@link org.opensearch.search.fetch.subphase.FieldAndFormat#fromXContent(XContentParser)}
                } else {
     * @throws IOException if there's an error during parsing
        }
        if (protoRequest.hasExt()) {
                        "Each indices_boost_2 entry must contain exactly one index-to-boost mapping, but found "
                    // Use full constructor when optional fields are present
        // TODO what to do about parser.getDeprecationHandler() for protos?
         */
                searchSourceBuilder.sort(sortBuilder);
                if (floatMap.getFloatMapCount() != 1) {
import org.opensearch.search.aggregations.AggregationBuilder;
        if (protoRequest.hasPostFilter()) {
import org.opensearch.search.sort.SortBuilder;
 *
import org.opensearch.protobufs.ScriptField;
        AggregationBuilderProtoConverterRegistry aggregationRegistry
        if (protoRequest.getRescoreCount() > 0) {
import java.io.IOException;
        if (protoRequest.hasQuery()) {
        if (protoRequest.hasXSource()) {
        if (protoRequest.hasExplain()) {
        if (protoRequest.getStatsCount() > 0) {
     * @param aggregationRegistry The aggregation registry to use for parsing aggregations
            searchSourceBuilder.from(protoRequest.getFrom());
            searchSourceBuilder.fetchSource(FetchSourceContextProtoUtils.fromProto(protoRequest.getXSource()));
                searchSourceBuilder.addRescorer(RescorerBuilderProtoUtils.parseFromProto(rescore));
            searchSourceBuilder.aggregation(aggBuilder);
                SearchSourceBuilder.ScriptField scriptField = ScriptFieldProtoUtils.fromProto(name, scriptFieldProto);
                searchSourceBuilder.trackTotalHitsUpTo(
        if (protoRequest.hasVersion()) {
        // TODO: indices_boost_2 uses FloatMap which allows multiple entries per element. A future
                /**
        AbstractQueryBuilderProtoUtils queryUtils,
import org.opensearch.protobufs.DerivedField;
    }
import org.opensearch.protobufs.FloatMap;
    /**
     */
import org.opensearch.protobufs.AggregationContainer;
/**
            boolean ignoreFailure = scriptFieldProto.hasIgnoreFailure() ? scriptFieldProto.getIgnoreFailure() : false;
        }
        if (protoRequest.hasTimeout()) {
        SearchSourceBuilder searchSourceBuilder,
        }
        }
     * Parses a protobuf SearchRequestBody into a SearchSourceBuilder using instance-based utilities.
        }
                    || derivedField.getIgnoreMalformed()) {
            // TODO support ext
                ScriptField scriptFieldProto = entry.getValue();
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
            return new SearchSourceBuilder.ScriptField(scriptFieldName, script, ignoreFailure);
    }
        if (protoRequest.hasVerbosePipeline()) {
            for (Map.Entry<String, DerivedField> entry : protoRequest.getDerivedMap().entrySet()) {
        if (protoRequest.hasSize()) {
            String aggName = entry.getKey();
                /**
         * This is a utility class with only static methods.
                // org.opensearch.index.mapper.DerivedFieldMapper.Builder#build()})
        } else if (protoRequest.getIndicesBoostCount() > 0) {
                    || derivedField.getPrefilterField() != null
        AggregationBuilderProtoConverterRegistry aggregationRegistry
            searchSourceBuilder.seqNoAndPrimaryTerm(protoRequest.getSeqNoPrimaryTerm());
            searchSourceBuilder.version(protoRequest.getVersion());
                org.opensearch.index.mapper.DerivedField derivedField = DerivedFieldProtoUtils.fromProto(name, derivedFieldProto);
            searchSourceBuilder.collapse(CollapseBuilderProtoUtils.fromProto(protoRequest.getCollapse(), queryRegistry));
                searchSourceBuilder.indexBoost(entry.getKey(), entry.getValue());
            searchSourceBuilder.fetchSource(FetchSourceContextProtoUtils.fromProto(protoRequest.getXSource()));
        }
        if (protoRequest.hasSuggest()) {
        if (protoRequest.getSortCount() > 0) {
                        derivedField.getPrefilterField(),
        }
        QueryBuilderProtoConverterRegistry queryRegistry,
        }
        SearchRequestBody protoRequest,
        if (protoRequest.getSearchAfterCount() > 0) {
                 * Similar to {@link org.opensearch.search.fetch.subphase.FieldAndFormat#fromXContent(XContentParser)}
                // This uses simple constructor + conditional setters (matches {@link
                            + floatMap.getFloatMapCount()
        if (protoRequest.hasSeqNoPrimaryTerm()) {
        if (protoRequest.getIndicesBoost2Count() > 0) {
        }
        }
        /*
                        derivedField.getIgnoreMalformed() ? Boolean.TRUE : null
        }
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
    ) throws IOException {
package org.opensearch.transport.grpc.proto.request.search;
                    throw new IllegalArgumentException(
            searchSourceBuilder.size(protoRequest.getSize());
        if (protoRequest.getStoredFieldsCount() > 0) {
                searchSourceBuilder.trackTotalHitsUpTo(protoRequest.getTrackTotalHits().getCount());
        }
            }
    }
            searchSourceBuilder.trackScores(protoRequest.getTrackScores());
                String name = entry.getKey();
        }
        }
            searchSourceBuilder.profile(protoRequest.getProfile());
        }
                }
        }
         * @throws IOException if there's an error during parsing
     *
                        derivedField.getName(),
        /**
        }
            throw new UnsupportedOperationException("ext param is not supported yet");
        if (protoRequest.hasTrackScores()) {
                Map.Entry<String, Float> entry = floatMap.getFloatMapMap().entrySet().iterator().next();
 * The OpenSearch Contributors require contributions made to
        if (protoRequest.hasSlice()) {
        if (protoRequest.hasHighlight()) {
     * This method is equivalent to {@link SearchSourceBuilder#parseXContent(XContentParser, boolean)}
import org.opensearch.transport.grpc.proto.request.search.sort.SortBuilderProtoUtils;
            // searchSourceBuilder.suggest(SuggestBuilderProtoUtils.fromProto(protoRequest.getSuggest()));
         */
        }
            for (Map.Entry<String, ScriptField> entry : protoRequest.getScriptFieldsMap().entrySet()) {
     * @param searchSourceBuilder The SearchSourceBuilder to populate
                searchSourceBuilder.indexBoost(entry.getKey(), entry.getValue());
            }
        if (protoRequest.hasXSource()) {
            searchSourceBuilder.searchAfter(SearchAfterBuilderProtoUtils.fromProto(protoRequest.getSearchAfterList()));
        if (protoRequest.getFieldsCount() > 0) {
         * Private constructor to prevent instantiation.
         * @param scriptFieldProto
        parseNonQueryFields(searchSourceBuilder, protoRequest, queryUtils.getRegistry(), aggregationRegistry);
         *
            searchSourceBuilder.pipeline(protoRequest.getSearchPipeline());
    public static class ScriptFieldProtoUtils {
            searchSourceBuilder.slice(SliceBuilderProtoUtils.fromProto(protoRequest.getSlice()));
        // Utility class, no instances
                    || derivedField.getFormat() != null
         * Similar to {@link SearchSourceBuilder.ScriptField#ScriptField(XContentParser)}
     * Parses all fields except queries from the protobuf SearchRequestBody.
                        derivedField.getScript(),
import static org.opensearch.search.builder.SearchSourceBuilder.TIMEOUT_FIELD;
        if (protoRequest.hasIncludeNamedQueriesScore()) {
                // Add to SearchSourceBuilder - check if any optional fields are set to choose the right method
        // indices_boost_3 with a dedicated proto message should enforce single entry per mapping.
            } else if (protoRequest.getTrackTotalHits().getTrackHitsCase() == TrackHits.TrackHitsCase.COUNT) {
        if (protoRequest.getDocvalueFieldsCount() > 0) {
        // Parse aggregations from protobuf
                    );
                 */
    }
        }
            searchSourceBuilder.pointInTimeBuilder(PointInTimeBuilderProtoUtils.fromProto(protoRequest.getPit()));
 * compatible open source license.
            for (FloatMap floatMap : protoRequest.getIndicesBoost2List()) {
                searchSourceBuilder.docValueField(fieldAndFormatProto.getField(), fieldAndFormatProto.getFormat());
        if (protoRequest.hasFrom()) {
            for (SortBuilder<?> sortBuilder : SortBuilderProtoUtils.fromProto(protoRequest.getSortList(), queryRegistry)) {
import org.opensearch.protobufs.SearchRequestBody;
        }
import org.opensearch.protobufs.Rescore;
        if (protoRequest.hasMinScore()) {
    private SearchSourceBuilderProtoUtils() {
            searchSourceBuilder.postFilter(queryUtils.parseInnerQueryBuilderProto(protoRequest.getPostFilter()));
        }
            if (protoRequest.getTrackTotalHits().getTrackHitsCase() == TrackHits.TrackHitsCase.ENABLED) {
import org.opensearch.protobufs.FieldAndFormat;
                searchSourceBuilder.fetchField(fieldAndFormatProto.getField(), fieldAndFormatProto.getFormat());
        }
        */
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_DISABLED;
     * This class handles the transformation of script field definitions between the two formats.
            }
        if (protoRequest.hasProfile()) {
     */
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;
        }
        private ScriptFieldProtoUtils() {
        if (protoRequest.hasTrackTotalHits()) {
            // Utility class, no instances
        if (protoRequest.hasPit()) {
     * @param protoRequest The Protocol Buffer SearchRequest to parse
        }
 */
            for (FieldAndFormat fieldAndFormatProto : protoRequest.getFieldsList()) {
                String name = entry.getKey();
            searchSourceBuilder.timeout(TimeValue.parseTimeValue(protoRequest.getTimeout(), null, TIMEOUT_FIELD.getPreferredName()));
}
        }
                searchSourceBuilder.scriptField(name, scriptField.script(), scriptField.ignoreFailure());
     */
                );
import org.opensearch.common.unit.TimeValue;
/*
            }
        // Handle queries using the instance-based approach
        /**
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
            searchSourceBuilder.minScore(protoRequest.getMinScore());
        }
                        derivedField.getProperties(),
        if (protoRequest.getDerivedCount() > 0) {
                        derivedField.getFormat(),
        if (protoRequest.getScriptFieldsCount() > 0) {
import org.opensearch.protobufs.TrackHits;
            }
            searchSourceBuilder.stats(protoRequest.getStatsList());
            org.opensearch.script.Script script = ScriptProtoUtils.parseFromProtoRequest(scriptFieldProto.getScript());
                    protoRequest.getTrackTotalHits().getEnabled() ? TRACK_TOTAL_HITS_ACCURATE : TRACK_TOTAL_HITS_DISABLED
 * Utility class for converting SearchSourceBuilder Protocol Buffers to objects
public class SearchSourceBuilderProtoUtils {
            searchSourceBuilder.includeNamedQueriesScores(protoRequest.getIncludeNamedQueriesScore());
                if (derivedField.getProperties() != null
        if (protoRequest.hasCollapse()) {
                        derivedField.getType(),
            }
        }
 */
        }
            }
            searchSourceBuilder.query(queryUtils.parseInnerQueryBuilderProto(protoRequest.getQuery()));
        SearchSourceBuilder searchSourceBuilder,
        }
                // Convert protobuf DerivedField to OpenSearch DerivedField using the REST side pattern
            throw new UnsupportedOperationException("suggest param is not supported yet");
     * Utility class for converting ScriptField Protocol Buffers to OpenSearch objects.
 * SPDX-License-Identifier: Apache-2.0
                }
        }
        }
        }
        SearchRequestBody protoRequest,
            for (FieldAndFormat fieldAndFormatProto : protoRequest.getDocvalueFieldsList()) {
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_ACCURATE;
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.transport.grpc.proto.request.common.FetchSourceContextProtoUtils;
    ) throws IOException {
import java.util.Map;
                DerivedField derivedFieldProto = entry.getValue();
                    // Use simple constructor when no optional fields
        }
        // Parse all non-query fields
        }
    /**
        if (protoRequest.hasTerminateAfter()) {
                 */
        }
import org.opensearch.core.xcontent.XContentParser;
        public static SearchSourceBuilder.ScriptField fromProto(String scriptFieldName, ScriptField scriptFieldProto) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    public static void parseProto(
            searchSourceBuilder.verbosePipeline(protoRequest.getVerbosePipeline());
                    searchSourceBuilder.derivedField(derivedField.getName(), derivedField.getType(), derivedField.getScript());
            for (Rescore rescore : protoRequest.getRescoreList()) {
        for (Map.Entry<String, AggregationContainer> entry : protoRequest.getAggregationsMap().entrySet()) {
            searchSourceBuilder.highlighter(HighlightBuilderProtoUtils.fromProto(protoRequest.getHighlight(), queryRegistry));
            for (Map.Entry<String, Float> entry : protoRequest.getIndicesBoostMap().entrySet()) {
        }
    /**
    private static void parseNonQueryFields(
         * @param scriptFieldName
            searchSourceBuilder.storedFields(StoredFieldsContextProtoUtils.fromProto(protoRequest.getStoredFieldsList()));
                    searchSourceBuilder.derivedField(
            searchSourceBuilder.terminateAfter(protoRequest.getTerminateAfter());
        if (protoRequest.hasSearchPipeline()) {
            }
