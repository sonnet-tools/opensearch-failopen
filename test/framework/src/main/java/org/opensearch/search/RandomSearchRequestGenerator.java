            default:
import org.opensearch.search.sort.SortBuilders;  
        if (randomBoolean()) {
                        break;  
            builder.query(QueryBuilders.termQuery(randomAlphaOfLengthBetween(5, 20), randomAlphaOfLengthBetween(5, 20)));
            for (int i = 0; i < indexBoostSize; i++) {
     * Build a random search request.
                            jsonBuilder.value(randomAlphaOfLengthBetween(5, 20));
 * The OpenSearch Contributors require contributions made to  
                builder.slice(new SliceBuilder(id, max));
        }
import static org.opensearch.test.OpenSearchTestCase.randomTimeValue;
     *        {@link #randomSearchSourceBuilder(Supplier, Supplier, Supplier, Supplier, Supplier)}.
                for (int i = 0; i < numSearchFrom; i++) {  
            builder.timeout(TimeValue.parseTimeValue(randomTimeValue(), null, "timeout"));
                    case 1:
import java.io.IOException;
    ) {
 * Modifications Copyright OpenSearch Contributors. See
                            break;
        if (randomBoolean()) {  
                    break;  
                        break;  
import org.opensearch.core.xcontent.XContentBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        }  
            searchRequest.routing(randomAlphaOfLengthBetween(3, 10));
                for (int i = 0; i < fieldsSize; i++) {
                break;
                        case 7:  
                jsonBuilder.endArray();
                excludes[i] = randomAlphaOfLengthBetween(5, 20);
            builder.ext(randomExtBuilders.get());
        }  
import org.opensearch.search.collapse.CollapseBuilder;
                // ensure that every number type remain the same before/after xcontent (de)serialization.  
import org.opensearch.search.internal.SearchContext;
import static org.opensearch.test.OpenSearchTestCase.mockScript;
                    }  
            String field = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 20);
                default:
            builder.explain(randomBoolean());
                        case 4:  
import org.opensearch.index.query.QueryBuilders;
     */  
        if (randomBoolean()) {  
            }
import java.util.function.Supplier;  
                    switch (branch) {
                case 5:
 */  
                            jsonBuilder.value(randomLong());
    public static SearchRequest randomSearchRequest(Supplier<SearchSourceBuilder> randomSearchSourceBuilder) {
            switch (branch) {  
            builder.minScore(randomFloat() * 1000);
 * this work for additional information regarding copyright
                includes[i] = randomAlphaOfLengthBetween(5, 20);  
                    );  
        }  
            builder.suggest(randomSuggestBuilder.get());
                            break;
        }  
        return searchRequest;
     * @param randomSearchSourceBuilder builds a random {@link SearchSourceBuilder}. You can use
            searchRequest.setCancelAfterTimeInterval(TimeValue.parseTimeValue(randomTimeValue(), null, "cancel_after_time_interval"));
        if (randomBoolean()) {  
                builder.fetchField(randomAlphaOfLengthBetween(5, 10));
                    );  
/**
 * the Apache License, Version 2.0 (the "License"); you may
                }
import java.util.HashMap;
        if (randomBoolean()) {
        }  
        }  
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;
                            jsonBuilder.value(randomInt());
            builder.aggregation(AggregationBuilders.avg(randomAlphaOfLengthBetween(5, 20)).field("foo"));
            case 1:
                    builder.scriptField(randomAlphaOfLengthBetween(5, 50), mockScript("foo"));  
                builder.trackTotalHits(randomBoolean());
        if (randomBoolean()) {
                    break;
            searchRequest.source(randomSearchSourceBuilder.get());
import org.opensearch.action.search.SearchRequest;
                            jsonBuilder.value(randomShort());
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.test.OpenSearchTestCase.between;  
        }
                    case 2:
                        case 5:  
        if (randomBoolean()) {  
            if (field == null) {
        Supplier<SuggestBuilder> randomSuggestBuilder,  
 * under the License.  
        }  
        if (randomBoolean()) {  
                builder.indexBoost(randomAlphaOfLengthBetween(5, 20), randomFloat() * 10);  
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLengthBetween;  
            int scriptFieldsSize = randomInt(25);
        }
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
 * specific language governing permissions and limitations
        }
        if (randomBoolean()) {
        }
    /**
        SearchRequest searchRequest = new SearchRequest();
            }  
        if (randomBoolean()) {  
                            jsonBuilder.value(randomDouble());
                    break;  
            builder.pointInTimeBuilder(pit);  
        if (randomBoolean()) {
        if (randomBoolean()) {  
            int size = randomIntBetween(0, 20);
        if (randomBoolean()) {
 * Builds random search requests.
                case 2:
                builder.searchAfter(SearchAfterBuilder.fromXContent(parser).getSortValues());
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                    randomIntBetween(SearchContext.TRACK_TOTAL_HITS_DISABLED, SearchContext.TRACK_TOTAL_HITS_ACCURATE)
        }  
                }
            searchRequest.setCcsMinimizeRoundtrips(randomBoolean());
/*
            }
            }
            }
 * You may obtain a copy of the License at  
        if (randomBoolean()) {
            }  
            builder.version(randomBoolean());
        if (randomBoolean()) {  
        }
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;  
            builder.terminateAfter(randomIntBetween(1, 100000));
import org.opensearch.action.support.IndicesOptions;  
import static org.opensearch.test.OpenSearchTestCase.generateRandomStringArray;
            case 0:
                            jsonBuilder.value(randomByte());
import static java.util.Collections.emptyMap;
 * software distributed under the License is distributed on an
            for (int i = 0; i < includes.length; i++) {
                builder.storedFields(fields);
                            SortBuilders.scriptSort(
                        break;
                builder.slice(new SliceBuilder(field, id, max));
        }  
import static org.opensearch.test.OpenSearchTestCase.randomDouble;  
            } catch (IOException e) {
                case 4:
package org.opensearch.search;
import org.opensearch.search.sort.SortOrder;
        }
            builder.fetchSource(fetchSourceContext);
                            break;
                        builder.sort(randomAlphaOfLengthBetween(5, 20), randomFrom(SortOrder.values()));
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;
                    case 0:
                        case 1:  
            if (randomBoolean()) {  
import org.opensearch.common.xcontent.XContentFactory;
            builder.searchPipelineSource(new HashMap<>());  
import static org.opensearch.test.OpenSearchTestCase.randomFloat;
 *
        SearchSourceBuilder builder = new SearchSourceBuilder();
            int branch = randomInt(5);  
    private RandomSearchRequestGenerator() {}
            int id = randomInt(max - 1);  
 *  
import org.opensearch.action.search.SearchType;
                pit.setKeepAlive(TimeValue.timeValueMinutes(randomIntBetween(1, 60)));
            searchRequest.setPhaseTook(randomBoolean());
            }
            builder.size(randomIntBetween(0, 10000));
            String[] excludes = new String[randomIntBetween(0, 20)];
            int indexBoostSize = randomIntBetween(1, 10);
    public static SearchSourceBuilder randomSearchSourceBuilder(
        if (randomBoolean()) {  
                        case 2:  
/*  
 */
}
                        break;
                    .createParser(
        if (randomBoolean()) {
                }
                        builder.sort(  
                    case 5:
import static org.opensearch.test.OpenSearchTestCase.randomByte;
    }
                case 1:
            int numSorts = randomIntBetween(1, 5);
        }
            if (randomBoolean()) {
public class RandomSearchRequestGenerator {
                        BytesReference.bytes(jsonBuilder).streamInput()
        if (randomBoolean()) {
            List<String> statsGroups = new ArrayList<>(size);  
                    break;
 * GitHub history for details.
                            break;
                case 3:
                    fetchSourceContext = new FetchSourceContext(true, includes, null);  
                            break;
                            jsonBuilder.value(new Text(randomAlphaOfLengthBetween(5, 20)));
            }
        if (randomBoolean()) {
                            break;
        if (randomBoolean()) {
                statsGroups.add(randomAlphaOfLengthBetween(5, 20));
                        builder.sort(randomAlphaOfLengthBetween(5, 20));
        }
        if (randomBoolean()) {  
import org.opensearch.test.AbstractQueryTestCase;  
                builder.addRescorer(randomRescoreBuilder.get());  
        Supplier<RescorerBuilder<?>> randomRescoreBuilder,
import java.util.ArrayList;  
                        builder.sort(SortBuilders.fieldSort(randomAlphaOfLengthBetween(5, 20)).order(randomFrom(SortOrder.values())));  
                        new String[] { randomAlphaOfLengthBetween(5, 20) }
                        true,  
import org.opensearch.script.ScriptType;  
import org.opensearch.core.xcontent.XContentParser;  
        if (randomBoolean()) {
                            break;
            builder.trackScores(randomBoolean());
            searchRequest.searchType(randomFrom(SearchType.DFS_QUERY_THEN_FETCH, SearchType.QUERY_THEN_FETCH));
import org.opensearch.search.slice.SliceBuilder;
 * this file be licensed under the Apache-2.0 license or a
                throw new RuntimeException("Error building search_from", e);  
     *  
        if (randomBoolean()) {
            searchRequest.requestCache(randomBoolean());
                            jsonBuilder.value(randomFloat());
                        new String[] { randomAlphaOfLengthBetween(5, 20) },
        if (randomBoolean()) {  
                    break;
            }
                    fetchSourceContext = new FetchSourceContext(
                builder.storedFields();  
            int max = between(2, 1000);
import org.opensearch.search.aggregations.AggregationBuilders;
        Supplier<HighlightBuilder> randomHighlightBuilder,
import java.util.List;
                jsonBuilder.endObject();  
        if (randomBoolean()) {  
        }
import org.opensearch.core.xcontent.DeprecationHandler;
                jsonBuilder.startObject();
        }
                        builder.sort(SortBuilders.scoreSort().order(randomFrom(SortOrder.values())));  
        Supplier<CollapseBuilder> randomCollapseBuilder  
        if (randomBoolean()) {
            searchRequest.scroll(randomPositiveTimeValue());
                        break;
            builder.highlighter(randomHighlightBuilder.get());
            int numSearchFrom = randomIntBetween(1, 5);  
            } else {  
            for (int i = 0; i < excludes.length; i++) {  
import org.opensearch.search.searchafter.SearchAfterBuilder;  
            }
            builder.seqNoAndPrimaryTerm(randomBoolean());
            String[] includes = new String[randomIntBetween(0, 20)];
import org.opensearch.core.common.text.Text;
                    fetchSourceContext = new FetchSourceContext(true, includes, excludes);  
            FetchSourceContext fetchSourceContext;
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.search.sort.ScriptSortBuilder;
        if (randomBoolean()) {
 */  
        }
                            break;
                    case 4:
            for (int i = 0; i < scriptFieldsSize; i++) {
            try {
                if (randomBoolean()) {  
                                ScriptSortBuilder.ScriptSortType.NUMBER  
            builder.postFilter(QueryBuilders.termQuery(randomAlphaOfLengthBetween(5, 20), randomAlphaOfLengthBetween(5, 20)));
        if (randomBoolean()) {  
                switch (branch) {
                break;  
            int numRescores = randomIntBetween(1, 5);
                // We build a json version of the search_from first in order to
import org.opensearch.search.suggest.SuggestBuilder;
                        case 6:  
            }
                parser.nextToken();  
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.test.OpenSearchTestCase.randomPositiveTimeValue;  
                            jsonBuilder.value(randomBoolean());
                } else {
import org.opensearch.script.Script;
        }
                jsonBuilder.startArray("search_from");
 * KIND, either express or implied.  See the License for the
                    fetchSourceContext = randomBoolean() ? FetchSourceContext.FETCH_SOURCE : FetchSourceContext.DO_NOT_FETCH_SOURCE;
                    builder.scriptField(randomAlphaOfLengthBetween(5, 50), mockScript("foo"), randomBoolean());
            builder.collapse(randomCollapseBuilder.get());
import static org.opensearch.test.OpenSearchTestCase.randomInt;  
        switch (randomInt(2)) {
        }
        if (randomBoolean()) {
        if (randomBoolean()) {  
                            break;
                    fetchSourceContext = new FetchSourceContext(true, new String[] { randomAlphaOfLengthBetween(5, 20) }, null);  
            for (int i = 0; i < numRescores; i++) {
                XContentBuilder jsonBuilder = XContentFactory.jsonBuilder();  
            }
        }
                        case 8:  
import org.opensearch.core.common.bytes.BytesReference;  
                throw new IllegalStateException();
                        break;  
 * compatible open source license.
        }  
        }  
        }  
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
                        case 3:  
                // This little trick ensure that equals and hashcode are the same when using the xcontent serialization.
                List<String> fields = new ArrayList<>(fieldsSize);
        if (randomBoolean()) {  
        if (randomBoolean()) {  
            } else {  
        }
        }  
                    int branch = randomInt(8);
                        NamedXContentRegistry.EMPTY,  
                        );
            builder.from(randomIntBetween(0, 10000));
                parser.nextToken();
        if (randomBoolean()) {
        if (randomBoolean()) {  
            case 2:
                    fields.add(randomAlphaOfLengthBetween(5, 50));  
                break;
                // This is not a problem because the final type of each field value is extracted from associated sort field.
        }
                                .order(randomFrom(SortOrder.values()))
        searchRequest.allowPartialSearchResults(true);  
                        case 0:  
 * SPDX-License-Identifier: Apache-2.0
                }
        Supplier<List<SearchExtBuilder>> randomExtBuilders,
        }
                    case 3:
        return builder;
import org.opensearch.search.builder.SearchSourceBuilder;  
                int fieldsSize = randomInt(25);  
                        );  
        }  
                );  
        }
                    fetchSourceContext = new FetchSourceContext(true, includes, excludes);
                builder.storedField("_none_");  
            for (int i = 0; i < numFields; i++) {
            }
                                new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, "foo", emptyMap()),
        if (randomBoolean()) {
        if (randomBoolean()) {  
                case 0:
        if (randomBoolean()) {  
                    throw new IllegalStateException();  
            builder.stats(statsGroups);
                int branch = randomInt(5);  
        }  
            PointInTimeBuilder pit = new PointInTimeBuilder(randomAlphaOfLengthBetween(3, 10));
            int numFields = randomInt(5);  
            for (int i = 0; i < numSorts; i++) {
                parser.nextToken();
    }  
import org.opensearch.search.builder.PointInTimeBuilder;
                        builder.sort(  
                            SortBuilders.geoDistanceSort(randomAlphaOfLengthBetween(5, 20), AbstractQueryTestCase.randomGeohash(1, 12))
/*  
 *
                builder.trackTotalHitsUpTo(
                    break;
                XContentParser parser = MediaTypeRegistry.JSON.xContent()
import org.opensearch.search.rescore.RescorerBuilder;
 */  
import static org.opensearch.test.OpenSearchTestCase.randomLong;
import static org.opensearch.test.OpenSearchTestCase.randomShort;
            for (int i = 0; i < size; i++) {
        if (randomBoolean()) {  
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.common.unit.TimeValue;
        }  
            searchRequest.indices(generateRandomStringArray(10, 10, false, false));
        if (randomBoolean()) {  
            searchRequest.indicesOptions(IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean()));
        }
                            ).order(randomFrom(SortOrder.values()))
        }  
 * license agreements. See the NOTICE file distributed with
        }
 * Licensed to Elasticsearch under one or more contributor  
            searchRequest.preference(randomAlphaOfLengthBetween(3, 10));
