        addCandidate(
import org.opensearch.client.Request;
/**
        addCandidate(
 * You may obtain a copy of the License at
        );
            "\"match\": { \"keyword_field\": {\"query\": \"value\", \"analyzer\": \"english\"} }",
            new BoolQueryBuilder().mustNot(new MatchAllQueryBuilder()).must(new MatchAllQueryBuilder())
            for (int i = 0; i < CANDIDATES.size(); i++) {
 * under the License.
                    mappingsAndSettings.startObject("query");
 * json format of a query being tested here then feel free to change this.
import org.opensearch.index.query.Operator;
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
                assertEquals(200, rsp.getStatusLine().getStatusCode());
            assertEquals(200, rsp.getStatusLine().getStatusCode());
                mappingsAndSettings.endObject();
                request = new Request("PUT", "/" + index + "/" + type + "/" + Integer.toString(i));
                mappingsAndSettings.startObject("settings");
        );
                request.setJsonEntity((String) CANDIDATES.get(i)[0]);
                Response rsp = client().performRequest(request);
                Map<?, ?> hitRsp = (Map<?, ?>) ((List<?>) ((Map<?, ?>)toMap(rsp).get("hits")).get("hits")).get(0);
        );
 * compatible open source license.
                    mappingsAndSettings.startObject(type);
import org.opensearch.index.query.DisMaxQueryBuilder;
            Request request = new Request("PUT", "/" + index);
        addCandidate(
                }
import org.opensearch.index.query.SpanTermQueryBuilder;
        addCandidate(
            "\"match_phrase\": { \"keyword_field\": {\"query\": \"value\", \"slop\": 3}}",
        );
                    mappingsAndSettings.field("type", "keyword");
        final String type = MapperService.SINGLE_MAPPING_NAME;
        addCandidate("\"range\": { \"long_field\": {\"gte\": 1, \"lte\": 9}}", new RangeQueryBuilder("long_field").from(1).to(9));
            new ConstantScoreQueryBuilder(new MatchAllQueryBuilder()).boost(0.1f)
 * the latest current major release.
/*
                mappingsAndSettings.startObject("mappings");
            "\"span_near\": {\"clauses\": [{ \"span_term\": { \"keyword_field\": \"value1\" }}, " +
                byte[] qbSource = Base64.getDecoder().decode(queryBuilderStr);
            NamedWriteableRegistry registry = new NamedWriteableRegistry(new SearchModule(Settings.EMPTY,
            "\"match\": { \"keyword_field\": {\"query\": \"value\", \"minimum_should_match\": 3} }",
 * The OpenSearch Contributors require contributions made to
                "{ \"span_term\": { \"keyword_field\": \"value2\" }}], \"slop\": 2, \"in_order\": false}",
    public void testQueryBuilderBWC() throws Exception {
                    mappingsAndSettings.field("type", "long");
                mappingsAndSettings.field("number_of_shards", 1);
            "\"bool\": { \"must_not\": [{\"match_all\": {}}], \"must\": [{\"match_all\": {}}], " +
                {
                .addClause(new SpanTermQueryBuilder("keyword_field", "value2"))
                {
                    try (StreamInput input = new NamedWriteableAwareStreamInput(new InputStreamStreamInput(in), registry)) {
            request.setOptions(allowTypesRemovalWarnings());
                    mappingsAndSettings.endObject();
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            "\"span_near\": {\"clauses\": [{ \"span_term\": { \"keyword_field\": \"value1\" }}, " +
 * PercolatorFieldMapper#createQueryBuilderField(...) method). Using the query builders writable contract. This test
 * not use this file except in compliance with the License.
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;
 * SPDX-License-Identifier: Apache-2.0
                        assertEquals(expectedQueryBuilder, queryBuilder);
 * current ES version. Percolator queries are stored in the binary format in a dedicated doc values field (see
        }
            new SpanNearQueryBuilder(new SpanTermQueryBuilder("keyword_field", "value1"), 0)
import org.opensearch.search.SearchModule;
import java.io.InputStream;
            new MatchPhraseQueryBuilder("keyword_field", "value").slop(3)
            }
        addCandidate(
                    mappingsAndSettings.endObject();
import org.opensearch.index.query.QueryBuilder;
            mappingsAndSettings.endObject();
        return XContentHelper.convertToMap(JsonXContent.jsonXContent, response, false);
 * does best effort verifying that we don't break bwc for query builders between the first previous major version and
                }
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
                mappingsAndSettings.startObject("properties");
import java.util.ArrayList;
                rsp = client().performRequest(request);
 */
                        QueryBuilder queryBuilder = input.readNamedWriteable(QueryBuilder.class);
            new MatchQueryBuilder("keyword_field", "value").analyzer("english")
 * An integration test that tests whether percolator queries stored in older supported ES version can still be read by the
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(new MatchAllQueryBuilder(),
        addCandidate("\"match\": { \"keyword_field\": \"value\"}", new MatchQueryBuilder("keyword_field", "value"));
                }
            "\"match\": { \"keyword_field\": {\"query\": \"value\", \"fuzziness\": \"auto\"} }",
import java.util.Collections;
import org.opensearch.client.Response;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
/*
        } else {
 * Licensed to Elasticsearch under one or more contributor
                QueryBuilder expectedQueryBuilder = (QueryBuilder) CANDIDATES.get(i)[1];
import org.opensearch.index.query.BoolQueryBuilder;
    }
        addCandidate(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import java.util.List;
                try (InputStream in = new ByteArrayInputStream(qbSource, 0, qbSource.length)) {
    }
package org.opensearch.upgrades;
 * The queries to test are specified in json format, which turns out to work because we tend break here rarely. If the
    private static void addCandidate(String querySource, QueryBuilder expectedQb) {
import org.apache.hc.core5.http.io.entity.EntityUtils;
            {
                    mappingsAndSettings.endObject();
                assertEquals(201, rsp.getStatusLine().getStatusCode());
    }
                    mappingsAndSettings.endObject();
import org.opensearch.index.query.MatchQueryBuilder;
 *
                "\"filter\": [{\"match_all\": {}}], \"should\": [{\"match_all\": {}}]}",
                Collections.emptyList()).getNamedWriteables());
            {
import org.opensearch.common.xcontent.json.JsonXContent;
 * this work for additional information regarding copyright
            }
    private static Map<String, Object> toMap(String response) throws IOException {
                }
    }
import java.io.ByteArrayInputStream;
                if (isRunningAgainstAncientCluster()) {
        addCandidate(
import org.opensearch.index.query.RangeQueryBuilder;
            }
        String index = "queries";
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 *
                Request request = new Request("GET", "/" + index + "/_search");
import org.opensearch.index.query.ConstantScoreQueryBuilder;
 * KIND, either express or implied.  See the License for the
 */
/*
            }
            new MatchQueryBuilder("keyword_field", "value").fuzziness(Fuzziness.AUTO)
import java.io.IOException;
    private static final List<Object[]> CANDIDATES = new ArrayList<>();
                mappingsAndSettings.field("number_of_replicas", 0);
            for (int i = 0; i < CANDIDATES.size(); i++) {
            new SpanNearQueryBuilder(new SpanTermQueryBuilder("keyword_field", "value1"), 2)
    }
                    mappingsAndSettings.startObject("keyword_field");
                }
                    mappingsAndSettings.startObject("long_field");
                .filter(new MatchAllQueryBuilder()).should(new MatchAllQueryBuilder())
        );
                "{ \"span_term\": { \"keyword_field\": \"value2\" }}]}",
            "\"span_near\": {\"clauses\": [{ \"span_term\": { \"keyword_field\": \"value1\" }}, " +
            new DisMaxQueryBuilder().add(new MatchAllQueryBuilder()).add(new MatchAllQueryBuilder()).add(new MatchAllQueryBuilder())
import org.opensearch.index.query.MatchPhraseQueryBuilder;
 */
                        assert in.read() == -1;
            "\"constant_score\": {\"filter\": {\"match_all\": {}}, \"boost\": 0.1}",
                    }
            new MatchQueryBuilder("keyword_field", "value").operator(Operator.AND)
        addCandidate(
        return toMap(EntityUtils.toString(response.getEntity()));
 * Modifications Copyright OpenSearch Contributors. See
        );
        addCandidate(
 * software distributed under the License is distributed on an
            mappingsAndSettings.startObject();
        );
                .addClause(new SpanTermQueryBuilder("keyword_field", "value2"))
import org.opensearch.index.mapper.MapperService;
import org.opensearch.index.query.MatchAllQueryBuilder;
                {
    private static Map<String, Object> toMap(Response response) throws IOException, ParseException {
        );
import org.opensearch.common.settings.Settings;
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
                    mappingsAndSettings.field("type", "percolator");
                mappingsAndSettings.endObject();
                mappingsAndSettings.endObject();
                        input.setVersion(getOldClusterVersion());
                    new RandomScoreFunctionBuilder().setWeight(0.2f))})
        addCandidate(
                .addClause(new SpanTermQueryBuilder("keyword_field", "value2")).inOrder(false)
                "\"functions\": [{\"random_score\": {}, \"filter\": {\"match_all\": {}}, \"weight\": 0.2}]}",
                if (isRunningAgainstAncientCluster()) {
            new FunctionScoreQueryBuilder(new MatchAllQueryBuilder(), new FunctionScoreQueryBuilder.FilterFunctionBuilder[]{
            new MatchQueryBuilder("keyword_field", "value").minimumShouldMatch("3")
    static {
        );
import org.opensearch.common.unit.Fuzziness;
 * <p>
            "\"dis_max\": {\"queries\": [{\"match_all\": {}},{\"match_all\": {}},{\"match_all\": {}}], \"tie_breaker\": 0.01}",
        );
 * this file be licensed under the Apache-2.0 license or a
 *
        addCandidate(
public class QueryBuilderBWCIT extends AbstractFullClusterRestartTestCase {
                }
import java.util.Map;
        CANDIDATES.add(new Object[]{"{\"query\": {" + querySource + "}}", expectedQb});
            "\"function_score\": {\"query\": {\"match_all\": {}}," +
}
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
        addCandidate(
            new SpanNearQueryBuilder(new SpanTermQueryBuilder("keyword_field", "value1"), 2)
                .tieBreaker(0.01f)
        );
import java.util.Base64;
            Response rsp = client().performRequest(request);
            "\"match\": { \"keyword_field\": {\"query\": \"value\", \"operator\": \"and\"} }",
import org.apache.hc.core5.http.ParseException;
        if (isRunningAgainstOldCluster()) {
 * specific language governing permissions and limitations
                "{ \"span_term\": { \"keyword_field\": \"value2\" }}], \"slop\": 2}",
            request.setJsonEntity(mappingsAndSettings.toString());
        addCandidate("\"match_phrase\": { \"keyword_field\": \"value\"}", new MatchPhraseQueryBuilder("keyword_field", "value"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Unless required by applicable law or agreed to in writing,
            XContentBuilder mappingsAndSettings = jsonBuilder();
import org.opensearch.index.query.SpanNearQueryBuilder;
                        "\"docvalue_fields\": [{\"field\":\"query.query_builder_field\"}]}");
                request.setJsonEntity("{\"query\": {\"ids\": {\"values\": [\"" + Integer.toString(i) + "\"]}}, " +
                String queryBuilderStr = (String) ((List<?>) ((Map<?, ?>) hitRsp.get("fields")).get("query.query_builder_field")).get(0);
import org.opensearch.core.xcontent.XContentBuilder;
