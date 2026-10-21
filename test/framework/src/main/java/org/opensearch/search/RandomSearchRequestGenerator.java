                // We build a json version of the search_from first in order to
        }
        searchRequest.allowPartialSearchResults(true);
import java.util.HashMap;
        if (randomBoolean()) {
import static org.opensearch.test.OpenSearchTestCase.between;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                            jsonBuilder.value(randomDouble());
            builder.aggregation(AggregationBuilders.avg(randomAlphaOfLengthBetween(5, 20)).field("foo"));
                    case 3:
                }
                        case 3:
        }
 */
                        case 0:
        if (randomBoolean()) {
                            jsonBuilder.value(randomInt());
        if (randomBoolean()) {
     */
            searchRequest.setCcsMinimizeRoundtrips(randomBoolean());
        if (randomBoolean()) {
        if (randomBoolean()) {
                            break;
                    case 5:
            searchRequest.scroll(randomPositiveTimeValue());
            }
            }
 * license agreements. See the NOTICE file distributed with
                    builder.scriptField(randomAlphaOfLengthBetween(5, 50), mockScript("foo"));
                            SortBuilders.scriptSort(
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder;
            for (int i = 0; i < size; i++) {
        }
import org.opensearch.search.suggest.SuggestBuilder;
import static org.opensearch.test.OpenSearchTestCase.randomBoolean;
            switch (branch) {
            searchRequest.indices(generateRandomStringArray(10, 10, false, false));
            for (int i = 0; i < numRescores; i++) {
        }
        }
        if (randomBoolean()) {
 */
import org.opensearch.action.search.SearchType;
                    randomIntBetween(SearchContext.TRACK_TOTAL_HITS_DISABLED, SearchContext.TRACK_TOTAL_HITS_ACCURATE)
/*
                switch (branch) {
package org.opensearch.search;
import static org.opensearch.test.OpenSearchTestCase.randomTimeValue;
                    builder.scriptField(randomAlphaOfLengthBetween(5, 50), mockScript("foo"), randomBoolean());
        return builder;
        }
                            break;
    }
        }
        }
                case 0:
 * SPDX-License-Identifier: Apache-2.0
            }
            int size = randomIntBetween(0, 20);
        }
import static org.opensearch.test.OpenSearchTestCase.randomPositiveTimeValue;
import org.opensearch.search.rescore.RescorerBuilder;
    private RandomSearchRequestGenerator() {}
                    fetchSourceContext = new FetchSourceContext(true, includes, null);
                }
            int id = randomInt(max - 1);
     *
        SearchSourceBuilder builder = new SearchSourceBuilder();
        if (randomBoolean()) {
 */
        if (randomBoolean()) {
        }
import static org.opensearch.test.OpenSearchTestCase.randomIntBetween;
import org.opensearch.search.collapse.CollapseBuilder;
            builder.searchPipelineSource(new HashMap<>());
import org.opensearch.core.xcontent.DeprecationHandler;
                        new String[] { randomAlphaOfLengthBetween(5, 20) }
import static java.util.Collections.emptyMap;
                break;
        }
            String[] excludes = new String[randomIntBetween(0, 20)];
import static org.opensearch.test.OpenSearchTestCase.randomShort;
            int scriptFieldsSize = randomInt(25);
            builder.from(randomIntBetween(0, 10000));
                        case 8:
            List<String> statsGroups = new ArrayList<>(size);
        switch (randomInt(2)) {
                            break;
        }
                builder.slice(new SliceBuilder(id, max));
                        case 5:
        if (randomBoolean()) {
            FetchSourceContext fetchSourceContext;
                case 4:
            builder.timeout(TimeValue.parseTimeValue(randomTimeValue(), null, "timeout"));
            }
                        BytesReference.bytes(jsonBuilder).streamInput()
                for (int i = 0; i < fieldsSize; i++) {
                    );
            builder.trackScores(randomBoolean());
            builder.highlighter(randomHighlightBuilder.get());
                parser.nextToken();
            try {
import org.opensearch.search.sort.SortOrder;
                jsonBuilder.startObject();
        if (randomBoolean()) {
                break;
/*
            int numFields = randomInt(5);
                    case 0:
        return searchRequest;
        }
                throw new RuntimeException("Error building search_from", e);
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
                }
        if (randomBoolean()) {
import java.util.List;
        }
        }
        }
        if (randomBoolean()) {
        if (randomBoolean()) {
                jsonBuilder.endObject();
                for (int i = 0; i < numSearchFrom; i++) {
        }
                        builder.sort(
                builder.searchAfter(SearchAfterBuilder.fromXContent(parser).getSortValues());
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/**
                    fetchSourceContext = randomBoolean() ? FetchSourceContext.FETCH_SOURCE : FetchSourceContext.DO_NOT_FETCH_SOURCE;
                excludes[i] = randomAlphaOfLengthBetween(5, 20);
                        break;
            builder.terminateAfter(randomIntBetween(1, 100000));
        Supplier<SuggestBuilder> randomSuggestBuilder,
import org.opensearch.core.xcontent.NamedXContentRegistry;
                            break;
        if (randomBoolean()) {
import org.opensearch.search.internal.SearchContext;
        }
        Supplier<RescorerBuilder<?>> randomRescoreBuilder,
                        case 4:
                builder.indexBoost(randomAlphaOfLengthBetween(5, 20), randomFloat() * 10);
                        case 2:
        }
                                .order(randomFrom(SortOrder.values()))
        if (randomBoolean()) {
import org.opensearch.search.builder.SearchSourceBuilder;
        }
        if (randomBoolean()) {
                            SortBuilders.geoDistanceSort(randomAlphaOfLengthBetween(5, 20), AbstractQueryTestCase.randomGeohash(1, 12))
        }
                    throw new IllegalStateException();
            }
        if (randomBoolean()) {
                builder.trackTotalHitsUpTo(
            }
    public static SearchSourceBuilder randomSearchSourceBuilder(
            int numRescores = randomIntBetween(1, 5);
            } catch (IOException e) {
                    case 4:
            int branch = randomInt(5);
                builder.slice(new SliceBuilder(field, id, max));
                    case 2:
            builder.postFilter(QueryBuilders.termQuery(randomAlphaOfLengthBetween(5, 20), randomAlphaOfLengthBetween(5, 20)));
        }
            }
            builder.seqNoAndPrimaryTerm(randomBoolean());
                            break;
                int fieldsSize = randomInt(25);
                XContentBuilder jsonBuilder = XContentFactory.jsonBuilder();
import java.util.function.Supplier;
                            break;
     * Build a random search request.
 * You may obtain a copy of the License at
            for (int i = 0; i < scriptFieldsSize; i++) {
 * compatible open source license.
            builder.ext(randomExtBuilders.get());
 */
                            jsonBuilder.value(randomByte());
                            jsonBuilder.value(randomShort());
                        builder.sort(
import org.opensearch.action.search.SearchRequest;
                    }
import static org.opensearch.test.OpenSearchTestCase.randomLong;
            builder.collapse(randomCollapseBuilder.get());
import static org.opensearch.test.OpenSearchTestCase.randomByte;
            for (int i = 0; i < indexBoostSize; i++) {
            builder.explain(randomBoolean());
        if (randomBoolean()) {
                builder.storedField("_none_");
            builder.query(QueryBuilders.termQuery(randomAlphaOfLengthBetween(5, 20), randomAlphaOfLengthBetween(5, 20)));
 * Modifications Copyright OpenSearch Contributors. See
            case 1:
        if (randomBoolean()) {
        if (randomBoolean()) {
     * @param randomSearchSourceBuilder builds a random {@link SearchSourceBuilder}. You can use
                        break;
                        );
                case 5:
                builder.trackTotalHits(randomBoolean());
                            jsonBuilder.value(randomLong());
import static org.opensearch.test.OpenSearchTestCase.mockScript;
                    break;
public class RandomSearchRequestGenerator {
 * The OpenSearch Contributors require contributions made to
            searchRequest.routing(randomAlphaOfLengthBetween(3, 10));
            int numSearchFrom = randomIntBetween(1, 5);
            searchRequest.source(randomSearchSourceBuilder.get());
    }
 * Licensed to Elasticsearch under one or more contributor
                        break;
        }
                    case 1:
        if (randomBoolean()) {
        }
        Supplier<HighlightBuilder> randomHighlightBuilder,
                case 3:
        if (randomBoolean()) {
                    fetchSourceContext = new FetchSourceContext(true, includes, excludes);
}
                case 2:
        if (randomBoolean()) {
                // This is not a problem because the final type of each field value is extracted from associated sort field.
    public static SearchRequest randomSearchRequest(Supplier<SearchSourceBuilder> randomSearchSourceBuilder) {
        if (randomBoolean()) {
        if (randomBoolean()) {
                default:
                // This little trick ensure that equals and hashcode are the same when using the xcontent serialization.
                includes[i] = randomAlphaOfLengthBetween(5, 20);
            case 2:
                                ScriptSortBuilder.ScriptSortType.NUMBER
            searchRequest.preference(randomAlphaOfLengthBetween(3, 10));
                        case 6:
            int max = between(2, 1000);
                break;
            builder.suggest(randomSuggestBuilder.get());
import org.opensearch.common.xcontent.XContentFactory;
        }
                        break;
            builder.size(randomIntBetween(0, 10000));
 *    http://www.apache.org/licenses/LICENSE-2.0
                        new String[] { randomAlphaOfLengthBetween(5, 20) },
import static org.opensearch.test.OpenSearchTestCase.randomDouble;
        }
        if (randomBoolean()) {
                case 1:
        }
            int numSorts = randomIntBetween(1, 5);
        }
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                    );
import org.opensearch.search.aggregations.AggregationBuilders;
                        NamedXContentRegistry.EMPTY,
            searchRequest.setPhaseTook(randomBoolean());
        }
                }
            for (int i = 0; i < excludes.length; i++) {
                // ensure that every number type remain the same before/after xcontent (de)serialization.
        if (randomBoolean()) {
                    int branch = randomInt(8);
            builder.stats(statsGroups);
            searchRequest.searchType(randomFrom(SearchType.DFS_QUERY_THEN_FETCH, SearchType.QUERY_THEN_FETCH));
            searchRequest.requestCache(randomBoolean());
                List<String> fields = new ArrayList<>(fieldsSize);
        if (randomBoolean()) {
    /**
                            break;
 * ownership. Elasticsearch licenses this file to you under
        }
            }
                                new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, "foo", emptyMap()),
                        break;
        if (randomBoolean()) {
        if (randomBoolean()) {
import org.opensearch.search.sort.ScriptSortBuilder;
                parser.nextToken();
            PointInTimeBuilder pit = new PointInTimeBuilder(randomAlphaOfLengthBetween(3, 10));
import java.util.ArrayList;
            }
import org.opensearch.script.Script;
 *
                            jsonBuilder.value(randomBoolean());
 * under the License.
                parser.nextToken();
                    fields.add(randomAlphaOfLengthBetween(5, 50));
                            ).order(randomFrom(SortOrder.values()))
        }
                        builder.sort(SortBuilders.scoreSort().order(randomFrom(SortOrder.values())));
        if (randomBoolean()) {
import org.opensearch.core.common.bytes.BytesReference;
                        builder.sort(SortBuilders.fieldSort(randomAlphaOfLengthBetween(5, 20)).order(randomFrom(SortOrder.values())));
                    switch (branch) {
            } else {
        }
            if (field == null) {
        }
        }
                jsonBuilder.startArray("search_from");
                int branch = randomInt(5);
            for (int i = 0; i < includes.length; i++) {
import static org.opensearch.test.OpenSearchTestCase.randomAlphaOfLengthBetween;
 * software distributed under the License is distributed on an
import org.opensearch.search.searchafter.SearchAfterBuilder;
import org.opensearch.action.support.IndicesOptions;
                        builder.sort(randomAlphaOfLengthBetween(5, 20));
        }
        }
                pit.setKeepAlive(TimeValue.timeValueMinutes(randomIntBetween(1, 60)));
import org.opensearch.search.sort.SortBuilders;
            }
                    break;
        }
            if (randomBoolean()) {
                            jsonBuilder.value(new Text(randomAlphaOfLengthBetween(5, 20)));
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.search.slice.SliceBuilder;
                    break;
            for (int i = 0; i < numFields; i++) {
                        true,
        if (randomBoolean()) {
            for (int i = 0; i < numSorts; i++) {
import org.opensearch.common.unit.TimeValue;
 * GitHub history for details.
import static org.opensearch.test.OpenSearchTestCase.randomFloat;
import java.io.IOException;
            searchRequest.setCancelAfterTimeInterval(TimeValue.parseTimeValue(randomTimeValue(), null, "cancel_after_time_interval"));
            }
                            jsonBuilder.value(randomAlphaOfLengthBetween(5, 20));
            builder.minScore(randomFloat() * 1000);
        if (randomBoolean()) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * this file be licensed under the Apache-2.0 license or a
            case 0:
     *        {@link #randomSearchSourceBuilder(Supplier, Supplier, Supplier, Supplier, Supplier)}.
        if (randomBoolean()) {
                    .createParser(
        if (randomBoolean()) {
                statsGroups.add(randomAlphaOfLengthBetween(5, 20));
        if (randomBoolean()) {
                builder.storedFields(fields);
 * Builds random search requests.
 *
                    fetchSourceContext = new FetchSourceContext(true, new String[] { randomAlphaOfLengthBetween(5, 20) }, null);
                );
                        );
                            jsonBuilder.value(randomFloat());
 * this work for additional information regarding copyright
import static org.opensearch.test.OpenSearchTestCase.randomInt;
                            break;
                jsonBuilder.endArray();
            searchRequest.indicesOptions(IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean()));
                } else {
            int indexBoostSize = randomIntBetween(1, 10);
        Supplier<List<SearchExtBuilder>> randomExtBuilders,
import org.opensearch.index.query.QueryBuilders;
        SearchRequest searchRequest = new SearchRequest();
            default:
            } else {
/*
import org.opensearch.core.xcontent.XContentParser;
            builder.version(randomBoolean());
                            break;
    ) {
        }
import static org.opensearch.test.OpenSearchTestCase.generateRandomStringArray;
                builder.fetchField(randomAlphaOfLengthBetween(5, 10));
        if (randomBoolean()) {
            if (randomBoolean()) {
                builder.storedFields();
            String field = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 20);
                builder.addRescorer(randomRescoreBuilder.get());
 * the Apache License, Version 2.0 (the "License"); you may
                    fetchSourceContext = new FetchSourceContext(true, includes, excludes);
 * specific language governing permissions and limitations
                throw new IllegalStateException();
            String[] includes = new String[randomIntBetween(0, 20)];
                    break;
            }
                XContentParser parser = MediaTypeRegistry.JSON.xContent()
                    fetchSourceContext = new FetchSourceContext(
        if (randomBoolean()) {
        }
import org.opensearch.core.common.text.Text;
                        builder.sort(randomAlphaOfLengthBetween(5, 20), randomFrom(SortOrder.values()));
            builder.fetchSource(fetchSourceContext);
 * not use this file except in compliance with the License.
                    break;
                    break;
                        break;
                        case 7:
        }
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
            }
            builder.pointInTimeBuilder(pit);
        Supplier<CollapseBuilder> randomCollapseBuilder
import org.opensearch.test.AbstractQueryTestCase;
import org.opensearch.search.builder.PointInTimeBuilder;
        if (randomBoolean()) {
                        case 1:
                if (randomBoolean()) {
import org.opensearch.script.ScriptType;
