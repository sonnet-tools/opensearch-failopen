                script = builder.toString();
 */
                break;
                builder.endObject();
package org.opensearch.index.rankeval;
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<RatedRequest> ratedRequests = null;
import org.opensearch.core.xcontent.XContentBuilder;
public class RankEvalSpecTests extends OpenSearchTestCase {
                    metric = new DiscountedCumulativeGain();
    }
        return new NamedXContentRegistry(new RankEvalModulePlugin().getNamedXContent());
import org.opensearch.common.xcontent.XContentType;
        }
    }
        int size = randomIntBetween(1, 20);
    }
import java.util.ArrayList;
            assertEquals(testItem.hashCode(), parsedItem.hashCode());
            templateParams.put("key", "value");
        for (int i = 0; i < size; i++) {
 * The OpenSearch Contributors require contributions made to
    public void testMissingTemplateAndSearchRequestFails() {
import java.io.IOException;
            Exception exception = expectThrows(Exception.class, () -> RankEvalSpec.parse(parser));
        expectThrows(IllegalArgumentException.class, () -> new RankEvalSpec(null, metric));
        int size = randomIntBetween(0, 20);
                () -> RecallAtKTests.createTestItem(),
    protected NamedXContentRegistry xContentRegistry() {
 * this file be licensed under the Apache-2.0 license or a
            final Map<String, Object> params = randomBoolean() ? Collections.emptyMap() : Collections.singletonMap("key", "value");
import java.util.HashSet;
 * You may obtain a copy of the License at
    }
        }
 * this work for additional information regarding copyright
    public void testMissingRatedRequestsFails() {
 */
 * GitHub history for details.
        }
            ratedRequests = Arrays.asList(ratedRequest);
        BytesReference originalBytes = toShuffledXContent(testItem, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
 * not use this file except in compliance with the License.
                "id",
    static RankEvalSpec mutateTestItem(RankEvalSpec original) {
                RatedRequest request = RatedRequestsTests.createTestItem(true);
        namedWriteables.add(new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new));
        expectThrows(NullPointerException.class, () -> new RankEvalSpec(ratedRequests, null));
        RatedRequest request = new RatedRequest("id", ratedDocs, params, "templateId");
/*
            ratedRequests = Arrays.asList(ratedRequest);
 * the Apache License, Version 2.0 (the "License"); you may
            RankEvalSpec parsedItem = RankEvalSpec.parse(parser);
        }
                if (metric instanceof PrecisionAtK) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        RankEvalSpec result = new RankEvalSpec(ratedRequests, metric, scripts);
import java.util.Map;
            result.add(randomSupplier.get());
import org.opensearch.search.builder.SearchSourceBuilder;
    private static <T> List<T> randomList(Supplier<T> randomSupplier) {
        RankEvalSpec spec = new RankEvalSpec(ratedRequests, metric.get(), templates);
        Map<String, Object> params = new HashMap<>();
import java.util.Collections;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    }
            assertNotSame(testItem, parsedItem);
                "templateId"
import org.opensearch.test.OpenSearchTestCase;
        Supplier<EvaluationMetric> metric = randomFrom(
 * compatible open source license.
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.HashMap;
import org.opensearch.core.xcontent.ToXContent;
            }
                    metric = new PrecisionAtK();
        for (int i = 0; i < size; i++) {
            Arrays.asList(
            new NamedWriteableRegistry.Entry(EvaluationMetric.class, DiscountedCumulativeGain.NAME, DiscountedCumulativeGain::new)
    }
 *
        XContentType xContentType = randomFrom(XContentType.values());
        List<RatedRequest> ratedRequests = Arrays.asList(request);
import org.opensearch.index.rankeval.RankEvalSpec.ScriptWithId;
            )
 * under the License.
        checkEqualsAndHashCode(createTestItem(), RankEvalSpecTests::copy, RankEvalSpecTests::mutateTestItem);
        int mutate = randomIntBetween(0, 2);
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        namedWriteables.add(new NamedWriteableRegistry.Entry(EvaluationMetric.class, MeanReciprocalRank.NAME, MeanReciprocalRank::new));
    @SuppressWarnings("resource")
    public void testMissingMetricFails() {
                () -> MeanReciprocalRankTests.createTestItem(),
        RankEvalSpec testItem = createTestItem();
    }
            templates.add(new ScriptWithId("templateId", new Script(ScriptType.INLINE, Script.DEFAULT_TEMPLATE_LANG, script, params)));
        Map<String, Script> templates = new HashMap<>(original.getTemplates());
            scripts.add(new ScriptWithId(entry.getKey(), entry.getValue()));
        List<String> indices = new ArrayList<>();
import java.util.Map.Entry;
 * specific language governing permissions and limitations
        XContentBuilder shuffled = shuffleXContent(testItem.toXContent(XContentFactory.jsonBuilder(), ToXContent.EMPTY_PARAMS));
            );
                break;
                templateParams,
                Arrays.asList(RatedDocumentTests.createRatedDocument()),
            templates = new HashSet<>();
            String script;
        List<ScriptWithId> scripts = new ArrayList<>();
    public void testXContentParsingIsNotLenient() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
        return result;
    }
                throw new RuntimeException(e);
        );
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(shuffled))) {
        expectThrows(IllegalArgumentException.class, () -> new RankEvalSpec(new ArrayList<>(), metric));
        List<RatedRequest> ratedRequests = randomList(() -> RatedRequestsTests.createTestItem(randomBoolean()));
                "id",
    }
        } else {
            try (XContentBuilder builder = XContentFactory.jsonBuilder()) {
import static org.hamcrest.Matchers.containsString;
/*
 *
    static RankEvalSpec createTestItem() {
                } else {
        maybeSet(spec::setMaxConcurrentSearches, randomInt(100));
import java.util.function.Supplier;
        namedWriteables.add(
    public void testSerialization() throws IOException {
        for (Entry<String, Script> entry : templates.entrySet()) {
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, null, random());
        namedWriteables.add(new NamedWriteableRegistry.Entry(EvaluationMetric.class, RecallAtK.NAME, RecallAtK::new));
import org.opensearch.script.ScriptType;
        List<RatedDocument> ratedDocs = Arrays.asList(new RatedDocument("index1", "id1", 1));
                builder.startObject();
import java.util.Collection;
                }
            RatedRequest ratedRequest = new RatedRequest(
 * Unless required by applicable law or agreed to in writing,
        assertEquals(deserialized, original);
        return result;
            case 0:
import org.opensearch.core.common.bytes.BytesReference;
                () -> DiscountedCumulativeGainTests.createTestItem()
                break;
 */
 * software distributed under the License is distributed on an
        RankEvalSpec original = createTestItem();
        Collection<ScriptWithId> templates = null;
                () -> PrecisionAtKTests.createTestItem(),
        assertNotSame(deserialized, original);
import org.opensearch.index.query.MatchAllQueryBuilder;
import java.util.List;
}
            assertEquals(testItem, parsedItem);
            assertThat(exception.getMessage(), containsString("[rank_eval] failed to parse field"));
        List<T> result = new ArrayList<>();
        return OpenSearchTestCase.copyWriteable(original, new NamedWriteableRegistry(namedWriteables), RankEvalSpec::new);
import org.opensearch.common.xcontent.json.JsonXContent;
                throw new IllegalStateException("Requested to modify more than available parameters.");
import org.opensearch.index.query.QueryBuilder;
        namedWriteables.add(new NamedWriteableRegistry.Entry(EvaluationMetric.class, PrecisionAtK.NAME, PrecisionAtK::new));
    }
import org.opensearch.core.xcontent.XContentParser;
import java.util.Arrays;
        expectThrows(IllegalStateException.class, () -> new RankEvalSpec(ratedRequests, new PrecisionAtK()));
        EvaluationMetric metric = original.getMetric();
                // this shouldn't happen in tests, re-throw just not to swallow it
        assertEquals(deserialized.hashCode(), original.hashCode());
        }
            );
        EvaluationMetric metric = new PrecisionAtK();
        List<RatedRequest> ratedRequests = new ArrayList<>(original.getRatedRequests());
 * Licensed to Elasticsearch under one or more contributor
                templates.put("mutation", new Script(ScriptType.INLINE, "mustache", randomAlphaOfLength(10), new HashMap<>()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            case 1:
/*
        RankEvalSpec deserialized = copy(original);
    }
        }
                Arrays.asList(RatedDocumentTests.createRatedDocument()),
        return spec;
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
    }
            } catch (IOException e) {
            indices.add(randomAlphaOfLengthBetween(0, 50));
import org.opensearch.common.xcontent.XContentFactory;
        }
    public void testXContentRoundtrip() throws IOException {
            default:
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
 * Modifications Copyright OpenSearch Contributors. See
                ratedRequests.add(request);
                builder.field("field", randomAlphaOfLengthBetween(1, 5));
        switch (mutate) {
        if (randomBoolean()) {
 *
    private static RankEvalSpec copy(RankEvalSpec original) throws IOException {
        List<NamedWriteableRegistry.Entry> namedWriteables = new ArrayList<>();
            Map<String, Object> templateParams = new HashMap<>();
        );
        RankEvalSpec testItem = createTestItem();
 * license agreements. See the NOTICE file distributed with
    @Override
            RatedRequest ratedRequest = new RatedRequest(
import org.opensearch.script.Script;
    public void testEqualsAndHash() throws IOException {
                new SearchSourceBuilder()
        params.put("key", "value");
            case 2:
