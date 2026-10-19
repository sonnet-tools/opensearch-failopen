import org.opensearch.index.mapper.MapperService;
                request = new Request("PUT", "/" + index + "/" + type + "/" + Integer.toString(i));
    private static final List<Object[]> CANDIDATES = new ArrayList<>();
                assertEquals(200, rsp.getStatusLine().getStatusCode());
                try (InputStream in = new ByteArrayInputStream(qbSource, 0, qbSource.length)) {
                    }
 */  
            mappingsAndSettings.endObject();
import java.io.InputStream;
 *
        addCandidate(
        } else {  
import java.util.Base64;
                byte[] qbSource = Base64.getDecoder().decode(queryBuilderStr);
                "\"functions\": [{\"random_score\": {}, \"filter\": {\"match_all\": {}}, \"weight\": 0.2}]}",  
import org.opensearch.index.query.SpanTermQueryBuilder;
 * the latest current major release.
            new SpanNearQueryBuilder(new SpanTermQueryBuilder("keyword_field", "value1"), 2)
import org.opensearch.index.query.DisMaxQueryBuilder;
        );
        );  
 * KIND, either express or implied.  See the License for the
                    mappingsAndSettings.startObject("query");  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;
    }
import org.opensearch.common.xcontent.XContentHelper;  
                }  
            "\"span_near\": {\"clauses\": [{ \"span_term\": { \"keyword_field\": \"value1\" }}, " +  
            "\"match\": { \"keyword_field\": {\"query\": \"value\", \"minimum_should_match\": 3} }",  
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        );
                request.setJsonEntity((String) CANDIDATES.get(i)[0]);
import java.util.ArrayList;  
 * SPDX-License-Identifier: Apache-2.0
            mappingsAndSettings.startObject();
            new MatchQueryBuilder("keyword_field", "value").operator(Operator.AND)
                "{ \"span_term\": { \"keyword_field\": \"value2\" }}], \"slop\": 2}",
            new BoolQueryBuilder().mustNot(new MatchAllQueryBuilder()).must(new MatchAllQueryBuilder())
        );
                    mappingsAndSettings.startObject("keyword_field");
 * Modifications Copyright OpenSearch Contributors. See
            "\"match\": { \"keyword_field\": {\"query\": \"value\", \"fuzziness\": \"auto\"} }",
 * An integration test that tests whether percolator queries stored in older supported ES version can still be read by the  
                }
                mappingsAndSettings.field("number_of_replicas", 0);
import org.opensearch.index.query.MatchQueryBuilder;
            Response rsp = client().performRequest(request);  
            assertEquals(200, rsp.getStatusLine().getStatusCode());
}  
                }  
                    mappingsAndSettings.field("type", "percolator");
 * The OpenSearch Contributors require contributions made to  
                    mappingsAndSettings.startObject(type);
                .addClause(new SpanTermQueryBuilder("keyword_field", "value2"))  
        addCandidate(
 * under the License.  
        addCandidate(
    static {
 * license agreements. See the NOTICE file distributed with
                rsp = client().performRequest(request);  
    private static void addCandidate(String querySource, QueryBuilder expectedQb) {
                .tieBreaker(0.01f)
    }
public class QueryBuilderBWCIT extends AbstractFullClusterRestartTestCase {  
            {
import org.opensearch.index.query.RangeQueryBuilder;
                String queryBuilderStr = (String) ((List<?>) ((Map<?, ?>) hitRsp.get("fields")).get("query.query_builder_field")).get(0);  
        );
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
                mappingsAndSettings.startObject("properties");
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                    mappingsAndSettings.startObject("long_field");
import java.util.Map;
            for (int i = 0; i < CANDIDATES.size(); i++) {  
import java.io.IOException;
import org.opensearch.index.query.BoolQueryBuilder;  
            }
        addCandidate(
            new MatchQueryBuilder("keyword_field", "value").minimumShouldMatch("3")
            "\"constant_score\": {\"filter\": {\"match_all\": {}}, \"boost\": 0.1}",
                }  
                Request request = new Request("GET", "/" + index + "/_search");  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
 * this work for additional information regarding copyright
                        assert in.read() == -1;  
            request.setOptions(allowTypesRemovalWarnings());
                    mappingsAndSettings.endObject();  
            new SpanNearQueryBuilder(new SpanTermQueryBuilder("keyword_field", "value1"), 0)
        addCandidate(  
                mappingsAndSettings.endObject();  
        final String type = MapperService.SINGLE_MAPPING_NAME;  
        addCandidate(  
                mappingsAndSettings.endObject();
/*
 */  
        addCandidate("\"match_phrase\": { \"keyword_field\": \"value\"}", new MatchPhraseQueryBuilder("keyword_field", "value"));
import org.opensearch.core.common.io.stream.StreamInput;
 * ownership. Elasticsearch licenses this file to you under  
                    mappingsAndSettings.endObject();
                    mappingsAndSettings.endObject();
            }
        addCandidate(
        addCandidate(
                Map<?, ?> hitRsp = (Map<?, ?>) ((List<?>) ((Map<?, ?>)toMap(rsp).get("hits")).get("hits")).get(0);
                "{ \"span_term\": { \"keyword_field\": \"value2\" }}]}",
import java.io.ByteArrayInputStream;  
import org.opensearch.index.query.Operator;  
            }
import org.opensearch.index.query.MatchAllQueryBuilder;  
                    new RandomScoreFunctionBuilder().setWeight(0.2f))})  
        CANDIDATES.add(new Object[]{"{\"query\": {" + querySource + "}}", expectedQb});
 * does best effort verifying that we don't break bwc for query builders between the first previous major version and  
    }
            }
                {  
            new ConstantScoreQueryBuilder(new MatchAllQueryBuilder()).boost(0.1f)
            "\"span_near\": {\"clauses\": [{ \"span_term\": { \"keyword_field\": \"value1\" }}, " +  
            "\"match\": { \"keyword_field\": {\"query\": \"value\", \"analyzer\": \"english\"} }",
 * compatible open source license.
            new DisMaxQueryBuilder().add(new MatchAllQueryBuilder()).add(new MatchAllQueryBuilder()).add(new MatchAllQueryBuilder())  
import java.util.Collections;
            new FunctionScoreQueryBuilder(new MatchAllQueryBuilder(), new FunctionScoreQueryBuilder.FilterFunctionBuilder[]{
/*  
import org.apache.hc.core5.http.io.entity.EntityUtils;
 * The queries to test are specified in json format, which turns out to work because we tend break here rarely. If the  
import java.util.List;  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            XContentBuilder mappingsAndSettings = jsonBuilder();  
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(new MatchAllQueryBuilder(),
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.index.query.ConstantScoreQueryBuilder;
                Response rsp = client().performRequest(request);  
                "\"filter\": [{\"match_all\": {}}], \"should\": [{\"match_all\": {}}]}",  
 * GitHub history for details.
        addCandidate(
    public void testQueryBuilderBWC() throws Exception {
        );
                {
                    mappingsAndSettings.field("type", "long");
 * current ES version. Percolator queries are stored in the binary format in a dedicated doc values field (see
        );  
                mappingsAndSettings.field("number_of_shards", 1);
 * PercolatorFieldMapper#createQueryBuilderField(...) method). Using the query builders writable contract. This test
                }
        return XContentHelper.convertToMap(JsonXContent.jsonXContent, response, false);
        String index = "queries";
                .addClause(new SpanTermQueryBuilder("keyword_field", "value2")).inOrder(false)  
                mappingsAndSettings.startObject("mappings");  
            new SpanNearQueryBuilder(new SpanTermQueryBuilder("keyword_field", "value1"), 2)
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;  
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.hc.core5.http.ParseException;
    private static Map<String, Object> toMap(String response) throws IOException {  
/*  
                QueryBuilder expectedQueryBuilder = (QueryBuilder) CANDIDATES.get(i)[1];
            "\"dis_max\": {\"queries\": [{\"match_all\": {}},{\"match_all\": {}},{\"match_all\": {}}], \"tie_breaker\": 0.01}",
import org.opensearch.common.unit.Fuzziness;
            request.setJsonEntity(mappingsAndSettings.toString());
    }  
                Collections.emptyList()).getNamedWriteables());
 *    http://www.apache.org/licenses/LICENSE-2.0
                mappingsAndSettings.endObject();  
        addCandidate(
 * not use this file except in compliance with the License.
    }  
                    mappingsAndSettings.field("type", "keyword");  
        addCandidate(  
 * <p>
        addCandidate("\"range\": { \"long_field\": {\"gte\": 1, \"lte\": 9}}", new RangeQueryBuilder("long_field").from(1).to(9));  
                        "\"docvalue_fields\": [{\"field\":\"query.query_builder_field\"}]}");
        );
            "\"span_near\": {\"clauses\": [{ \"span_term\": { \"keyword_field\": \"value1\" }}, " +  
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
        addCandidate(
/**
            "\"function_score\": {\"query\": {\"match_all\": {}}," +
            new MatchQueryBuilder("keyword_field", "value").analyzer("english")  
import org.opensearch.index.query.MatchPhraseQueryBuilder;
        return toMap(EntityUtils.toString(response.getEntity()));  
import org.opensearch.index.query.SpanNearQueryBuilder;  
                    mappingsAndSettings.endObject();
    private static Map<String, Object> toMap(Response response) throws IOException, ParseException {
                "{ \"span_term\": { \"keyword_field\": \"value2\" }}], \"slop\": 2, \"in_order\": false}",
            new MatchQueryBuilder("keyword_field", "value").fuzziness(Fuzziness.AUTO)
                mappingsAndSettings.startObject("settings");  
                .filter(new MatchAllQueryBuilder()).should(new MatchAllQueryBuilder())
                if (isRunningAgainstAncientCluster()) {
        );  
            "\"match\": { \"keyword_field\": {\"query\": \"value\", \"operator\": \"and\"} }",
        if (isRunningAgainstOldCluster()) {
 * Unless required by applicable law or agreed to in writing,
        addCandidate("\"match\": { \"keyword_field\": \"value\"}", new MatchQueryBuilder("keyword_field", "value"));
                    try (StreamInput input = new NamedWriteableAwareStreamInput(new InputStreamStreamInput(in), registry)) {  
 *
                }  
                {
 */
import org.opensearch.index.query.QueryBuilder;
        );
            {
import org.opensearch.common.settings.Settings;  
            "\"bool\": { \"must_not\": [{\"match_all\": {}}], \"must\": [{\"match_all\": {}}], " +
            "\"match_phrase\": { \"keyword_field\": {\"query\": \"value\", \"slop\": 3}}",  
import org.opensearch.client.Request;  
 */
 *  
            new MatchPhraseQueryBuilder("keyword_field", "value").slop(3)
 * json format of a query being tested here then feel free to change this.
import org.opensearch.search.SearchModule;
            for (int i = 0; i < CANDIDATES.size(); i++) {
                        assertEquals(expectedQueryBuilder, queryBuilder);
package org.opensearch.upgrades;
 * the Apache License, Version 2.0 (the "License"); you may
                        QueryBuilder queryBuilder = input.readNamedWriteable(QueryBuilder.class);
                .addClause(new SpanTermQueryBuilder("keyword_field", "value2"))  
                        input.setVersion(getOldClusterVersion());
                assertEquals(201, rsp.getStatusLine().getStatusCode());
                request.setJsonEntity("{\"query\": {\"ids\": {\"values\": [\"" + Integer.toString(i) + "\"]}}, " +
        );  
        );
import org.opensearch.client.Response;
        }
            NamedWriteableRegistry registry = new NamedWriteableRegistry(new SearchModule(Settings.EMPTY,
                if (isRunningAgainstAncientCluster()) {
            Request request = new Request("PUT", "/" + index);  
