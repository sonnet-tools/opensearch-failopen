         */
        }
            searchSourceBuilder.pointInTimeBuilder(PointInTimeBuilderProtoUtils.fromProto(protoRequest.getPit()));
     * @throws IOException if there's an error during parsing
        }  
            searchSourceBuilder.trackScores(protoRequest.getTrackScores());
     */  
                        derivedField.getType(),
 * this file be licensed under the Apache-2.0 license or a
        if (protoRequest.hasExt()) {  
import org.opensearch.protobufs.SearchRequestBody;
        SearchSourceBuilder searchSourceBuilder,
        if (protoRequest.hasExplain()) {  
        /*  
                if (floatMap.getFloatMapCount() != 1) {  
            }
        private ScriptFieldProtoUtils() {  
        if (protoRequest.hasCollapse()) {
            searchSourceBuilder.storedFields(StoredFieldsContextProtoUtils.fromProto(protoRequest.getStoredFieldsList()));
        }
    }
            searchSourceBuilder.aggregation(aggBuilder);
        if (protoRequest.getStoredFieldsCount() > 0) {  
            searchSourceBuilder.version(protoRequest.getVersion());
                searchSourceBuilder.trackTotalHitsUpTo(
                    // Use full constructor when optional fields are present
            for (Map.Entry<String, Float> entry : protoRequest.getIndicesBoostMap().entrySet()) {
                        derivedField.getIgnoreMalformed() ? Boolean.TRUE : null  
import org.opensearch.protobufs.FloatMap;
        }
        }
 * SPDX-License-Identifier: Apache-2.0
        }
            }
                            + floatMap.getFloatMapCount()  
                org.opensearch.index.mapper.DerivedField derivedField = DerivedFieldProtoUtils.fromProto(name, derivedFieldProto);  
     * Utility class for converting ScriptField Protocol Buffers to OpenSearch objects.
            String aggName = entry.getKey();
 * Utility class for converting SearchSourceBuilder Protocol Buffers to objects
    ) throws IOException {  
            for (Rescore rescore : protoRequest.getRescoreList()) {
import org.opensearch.search.sort.SortBuilder;  
        if (protoRequest.hasPit()) {
 *
     */  
                DerivedField derivedFieldProto = entry.getValue();
                        derivedField.getProperties(),  
                        derivedField.getName(),  
                    || derivedField.getFormat() != null
        }  
                    );
    /**  
        // Handle queries using the instance-based approach
import org.opensearch.search.aggregations.AggregationBuilder;
        if (protoRequest.hasSlice()) {
                searchSourceBuilder.addRescorer(RescorerBuilderProtoUtils.parseFromProto(rescore));
        }
        if (protoRequest.hasSeqNoPrimaryTerm()) {  
        if (protoRequest.hasTerminateAfter()) {  
        if (protoRequest.hasTimeout()) {  
        if (protoRequest.hasTrackTotalHits()) {  
import org.opensearch.protobufs.AggregationContainer;
    }
        if (protoRequest.getScriptFieldsCount() > 0) {
        if (protoRequest.hasMinScore()) {  
        }
                        derivedField.getScript(),
    public static class ScriptFieldProtoUtils {
    private static void parseNonQueryFields(
        if (protoRequest.hasSearchPipeline()) {
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
            searchSourceBuilder.verbosePipeline(protoRequest.getVerbosePipeline());  
    }
 * compatible open source license.
     * Parses a protobuf SearchRequestBody into a SearchSourceBuilder using instance-based utilities.
            searchSourceBuilder.query(queryUtils.parseInnerQueryBuilderProto(protoRequest.getQuery()));  
            searchSourceBuilder.terminateAfter(protoRequest.getTerminateAfter());
            searchSourceBuilder.seqNoAndPrimaryTerm(protoRequest.getSeqNoPrimaryTerm());
                searchSourceBuilder.indexBoost(entry.getKey(), entry.getValue());
import org.opensearch.common.unit.TimeValue;  
            searchSourceBuilder.postFilter(queryUtils.parseInnerQueryBuilderProto(protoRequest.getPostFilter()));  
            return new SearchSourceBuilder.ScriptField(scriptFieldName, script, ignoreFailure);
                searchSourceBuilder.fetchField(fieldAndFormatProto.getField(), fieldAndFormatProto.getFormat());
        }  
        if (protoRequest.hasXSource()) {  
                        derivedField.getFormat(),
                SearchSourceBuilder.ScriptField scriptField = ScriptFieldProtoUtils.fromProto(name, scriptFieldProto);  
            }  
            for (FloatMap floatMap : protoRequest.getIndicesBoost2List()) {
                        "Each indices_boost_2 entry must contain exactly one index-to-boost mapping, but found "
        // TODO what to do about parser.getDeprecationHandler() for protos?
    /**  
            searchSourceBuilder.slice(SliceBuilderProtoUtils.fromProto(protoRequest.getSlice()));
        }
        }
                );
        if (protoRequest.getSearchAfterCount() > 0) {
        // TODO: indices_boost_2 uses FloatMap which allows multiple entries per element. A future
            searchSourceBuilder.highlighter(HighlightBuilderProtoUtils.fromProto(protoRequest.getHighlight(), queryRegistry));
                    || derivedField.getPrefilterField() != null
        SearchRequestBody protoRequest,  
import static org.opensearch.search.builder.SearchSourceBuilder.TIMEOUT_FIELD;
        if (protoRequest.getSortCount() > 0) {  
                ScriptField scriptFieldProto = entry.getValue();
            }
        if (protoRequest.hasProfile()) {
import org.opensearch.transport.grpc.proto.request.common.FetchSourceContextProtoUtils;
            // TODO support ext
        }  
        AggregationBuilderProtoConverterRegistry aggregationRegistry
            } else if (protoRequest.getTrackTotalHits().getTrackHitsCase() == TrackHits.TrackHitsCase.COUNT) {
        }  
            }  
        /**
         * @param scriptFieldName
            if (protoRequest.getTrackTotalHits().getTrackHitsCase() == TrackHits.TrackHitsCase.ENABLED) {
        }
            AggregationBuilder aggBuilder = aggregationRegistry.fromProto(aggName, entry.getValue());  
     * @param queryUtils The query utils instance to use for parsing queries  
        if (protoRequest.hasSize()) {  
    ) throws IOException {  
import org.opensearch.transport.grpc.proto.request.search.sort.SortBuilderProtoUtils;
            searchSourceBuilder.includeNamedQueriesScores(protoRequest.getIncludeNamedQueriesScore());
import org.opensearch.protobufs.DerivedField;  
            searchSourceBuilder.searchAfter(SearchAfterBuilderProtoUtils.fromProto(protoRequest.getSearchAfterList()));
        if (protoRequest.hasPostFilter()) {
        }
    }
        public static SearchSourceBuilder.ScriptField fromProto(String scriptFieldName, ScriptField scriptFieldProto) throws IOException {  
            boolean ignoreFailure = scriptFieldProto.hasIgnoreFailure() ? scriptFieldProto.getIgnoreFailure() : false;
                // This uses simple constructor + conditional setters (matches {@link
        if (protoRequest.hasVersion()) {  
            searchSourceBuilder.fetchSource(FetchSourceContextProtoUtils.fromProto(protoRequest.getXSource()));
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_ACCURATE;  
        if (protoRequest.hasFrom()) {  
            // searchSourceBuilder.suggest(SuggestBuilderProtoUtils.fromProto(protoRequest.getSuggest()));  
                }
        if (protoRequest.getStatsCount() > 0) {
        }
         */
                // Add to SearchSourceBuilder - check if any optional fields are set to choose the right method
        }
        for (Map.Entry<String, AggregationContainer> entry : protoRequest.getAggregationsMap().entrySet()) {
import org.opensearch.protobufs.Rescore;  
import java.io.IOException;
                 */  
public class SearchSourceBuilderProtoUtils {  
         *  
            }
        if (protoRequest.getDerivedCount() > 0) {
                /**
         * @throws IOException if there's an error during parsing  
            // Utility class, no instances
 * The OpenSearch Contributors require contributions made to  
            searchSourceBuilder.from(protoRequest.getFrom());
            for (FieldAndFormat fieldAndFormatProto : protoRequest.getFieldsList()) {  
                    searchSourceBuilder.derivedField(
                 * Similar to {@link org.opensearch.search.fetch.subphase.FieldAndFormat#fromXContent(XContentParser)}
                searchSourceBuilder.sort(sortBuilder);
        if (protoRequest.getDocvalueFieldsCount() > 0) {
            }
/*  
        /**
        if (protoRequest.getFieldsCount() > 0) {
     * @param aggregationRegistry The aggregation registry to use for parsing aggregations
                        derivedField.getPrefilterField(),
        // indices_boost_3 with a dedicated proto message should enforce single entry per mapping.  
    /**
     *  
                String name = entry.getKey();  
                searchSourceBuilder.trackTotalHitsUpTo(protoRequest.getTrackTotalHits().getCount());  
        }
        }
        SearchSourceBuilder searchSourceBuilder,
                if (derivedField.getProperties() != null  
        }
                // org.opensearch.index.mapper.DerivedFieldMapper.Builder#build()})
        }
        }
        } else if (protoRequest.getIndicesBoostCount() > 0) {  
import org.opensearch.transport.grpc.proto.request.search.query.AbstractQueryBuilderProtoUtils;  
        */
            for (Map.Entry<String, ScriptField> entry : protoRequest.getScriptFieldsMap().entrySet()) {  
                searchSourceBuilder.docValueField(fieldAndFormatProto.getField(), fieldAndFormatProto.getFormat());
        }
            }  
                    || derivedField.getIgnoreMalformed()) {  
     * Parses all fields except queries from the protobuf SearchRequestBody.
            for (Map.Entry<String, DerivedField> entry : protoRequest.getDerivedMap().entrySet()) {
        }  
                // Convert protobuf DerivedField to OpenSearch DerivedField using the REST side pattern  
/**  
        if (protoRequest.getIndicesBoost2Count() > 0) {
        }
         * Private constructor to prevent instantiation.  
            searchSourceBuilder.minScore(protoRequest.getMinScore());
import org.opensearch.protobufs.FieldAndFormat;
        }
import org.opensearch.protobufs.ScriptField;
        if (protoRequest.hasSuggest()) {
     * @param searchSourceBuilder The SearchSourceBuilder to populate
        QueryBuilderProtoConverterRegistry queryRegistry,
                    );
            for (FieldAndFormat fieldAndFormatProto : protoRequest.getDocvalueFieldsList()) {  
        }
            searchSourceBuilder.pipeline(protoRequest.getSearchPipeline());  
        // Parse aggregations from protobuf  
                    protoRequest.getTrackTotalHits().getEnabled() ? TRACK_TOTAL_HITS_ACCURATE : TRACK_TOTAL_HITS_DISABLED  
            for (SortBuilder<?> sortBuilder : SortBuilderProtoUtils.fromProto(protoRequest.getSortList(), queryRegistry)) {
        if (protoRequest.hasIncludeNamedQueriesScore()) {  
        }  
        if (protoRequest.hasXSource()) {
        // TODO support suggest once added back to the protos
        if (protoRequest.getRescoreCount() > 0) {  
     */  
        }  
                searchSourceBuilder.scriptField(name, scriptField.script(), scriptField.ignoreFailure());
            org.opensearch.script.Script script = ScriptProtoUtils.parseFromProtoRequest(scriptFieldProto.getScript());
import org.opensearch.transport.grpc.spi.AggregationBuilderProtoConverterRegistry;
            searchSourceBuilder.size(protoRequest.getSize());
                    // Use simple constructor when no optional fields  
         * @param scriptFieldProto
            searchSourceBuilder.timeout(TimeValue.parseTimeValue(protoRequest.getTimeout(), null, TIMEOUT_FIELD.getPreferredName()));
                } else {
            searchSourceBuilder.collapse(CollapseBuilderProtoUtils.fromProto(protoRequest.getCollapse(), queryRegistry));
        AggregationBuilderProtoConverterRegistry aggregationRegistry
                String name = entry.getKey();
        }
            }  
        AbstractQueryBuilderProtoUtils queryUtils,
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
     * @param protoRequest The Protocol Buffer SearchRequest to parse
         * Similar to {@link SearchSourceBuilder.ScriptField#ScriptField(XContentParser)}
        }
        if (protoRequest.hasHighlight()) {
            throw new UnsupportedOperationException("suggest param is not supported yet");
                }
import java.util.Map;  
import org.opensearch.protobufs.TrackHits;  
        // Parse all non-query fields
    public static void parseProto(
            searchSourceBuilder.fetchSource(FetchSourceContextProtoUtils.fromProto(protoRequest.getXSource()));  
        SearchRequestBody protoRequest,  
}
     * This method is equivalent to {@link SearchSourceBuilder#parseXContent(XContentParser, boolean)}
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_DISABLED;
        if (protoRequest.hasVerbosePipeline()) {
                    searchSourceBuilder.derivedField(derivedField.getName(), derivedField.getType(), derivedField.getScript());
        }  
        }
package org.opensearch.transport.grpc.proto.request.search;
                Map.Entry<String, Float> entry = floatMap.getFloatMapMap().entrySet().iterator().next();  
        parseNonQueryFields(searchSourceBuilder, protoRequest, queryUtils.getRegistry(), aggregationRegistry);
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.core.xcontent.XContentParser;
            throw new UnsupportedOperationException("ext param is not supported yet");
        }
        }
                searchSourceBuilder.indexBoost(entry.getKey(), entry.getValue());
 */
            searchSourceBuilder.profile(protoRequest.getProfile());  
        if (protoRequest.hasQuery()) {
                    throw new IllegalArgumentException(
     * This class handles the transformation of script field definitions between the two formats.
    private SearchSourceBuilderProtoUtils() {
                /**
         * This is a utility class with only static methods.
 */  
        // Utility class, no instances  
                 * Similar to {@link org.opensearch.search.fetch.subphase.FieldAndFormat#fromXContent(XContentParser)}
            searchSourceBuilder.stats(protoRequest.getStatsList());
                 */  
            searchSourceBuilder.explain(protoRequest.getExplain());
        if (protoRequest.hasTrackScores()) {  
        }
