        switch (randomIntBetween(0, 12)) {
                builder.gramSize(randomValueOtherThan(builder.gramSize(), () -> randomIntBetween(1, 5)));
            case 8:
                // preTag, postTag
            case 10:
                model = LinearInterpolationModelTests.createRandomModel();
                builder.smoothingModel(randomValueOtherThan(builder.smoothingModel(), PhraseSuggestionBuilderTests::randomSmoothingModel));
        PhraseSuggestionBuilder builder = new PhraseSuggestionBuilder(randomAlphaOfLengthBetween(2, 20));
                break;
        assertEquals("gramSize must be >= 1", e.getMessage());
                Script collateQuery = builder.collateQuery();
    }
        }
                break;
                    builder.highlight(randomAlphaOfLengthBetween(3, 20), randomAlphaOfLengthBetween(3, 20));
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
    protected void assertSuggestionContext(PhraseSuggestionBuilder builder, SuggestionContext context) {
            case 11:
public class PhraseSuggestionBuilderTests extends AbstractSuggestionBuilderTestCase<PhraseSuggestionBuilder> {
                break;
        if (testBuilder.collateQuery() != null) {
        return model;
 */
                collateParams.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
            if (randomBoolean()) {
            case 7:
                for (int i = 0; i < numParams; i++) {
        assertOptionalEquals(builder.collatePrune(), phraseSuggesterCtx.collatePrune(), PhraseSuggestionContext.DEFAULT_COLLATE_PRUNE);
        if (randomBoolean()) {
                model = StupidBackoffModelTests.createRandomModel();
import org.opensearch.script.Script;
        e = expectThrows(IllegalArgumentException.class, () -> builder.tokenLimit(0));
    }
            for (int i = 0; i < numGenerators; i++) {
        assertOptionalEquals(
                }
 * ownership. Elasticsearch licenses this file to you under
        assertEquals("confidence must be >= 0.0", e.getMessage());
 * GitHub history for details.
        PhraseSuggestionContext phraseSuggesterCtx = (PhraseSuggestionContext) context;
            testBuilder.highlight(randomAlphaOfLengthBetween(3, 20), randomAlphaOfLengthBetween(3, 20));
    @Override
package org.opensearch.search.suggest.phrase;
                testBuilder.addCandidateGenerator(DirectCandidateGeneratorTests.randomCandidateGenerator());
        assertOptionalEquals(builder.maxErrors(), phraseSuggesterCtx.maxErrors(), PhraseSuggestionContext.DEFAULT_MAX_ERRORS);
            PhraseSuggestionContext.DEFAULT_RWE_ERRORLIKELIHOOD
        if (randomBoolean()) {
            case 4:
    @Override
                String currentPre = builder.preTag();
                break;
        if (builder.smoothingModel() != null) {
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
        maybeSet(testBuilder::gramSize, randomIntBetween(1, 5));
                } else {
                    collateParams.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
            builder.realWordErrorLikelihood(),
        e = expectThrows(IllegalArgumentException.class, () -> builder.gramSize(-1));
            }
        assertThat(context.getSuggester(), instanceOf(PhraseSuggester.class));
            phraseSuggesterCtx.getRequireUnigram(),
            case 9:
                builder.collateParams(collateParams);
        }
 * Modifications Copyright OpenSearch Contributors. See
        }
            case 5:
                    builder.collateQuery(randomAlphaOfLengthBetween(3, 20));
 *
 * KIND, either express or implied.  See the License for the
        e = expectThrows(NullPointerException.class, () -> builder.separator(null));
        );
                    builder.highlight(builder.preTag() + builder.preTag(), builder.postTag() + builder.postTag());
                model = LaplaceModelTests.createRandomModel();
                Map<String, Object> collateParams = new HashMap<>();
        assertEquals("gramSize must be >= 1", e.getMessage());
            case 0:
    private static SmoothingModel randomSmoothingModel() {
    }
/*
        if (builder.collateParams() != null) {
 * compatible open source license.
    }
            phraseSuggesterCtx.realworldErrorLikelihood(),
        }
        assertEquals("suggestion field name is empty", e.getMessage());
        assertOptionalEquals(builder.tokenLimit(), phraseSuggesterCtx.getTokenLimit(), NoisyChannelSpellChecker.DEFAULT_TOKEN_LIMIT);
            case 1:
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
            }
                break;
        );
        assertThat(context, instanceOf(PhraseSuggestionContext.class));
import java.util.HashMap;
        }
    @Override
                builder.addCandidateGenerator(DirectCandidateGeneratorTests.randomCandidateGenerator());
                break;
                break;
                int numParams = randomIntBetween(1, 5);
        if (optional != null) {
                builder.forceUnigrams(builder.forceUnigrams() == null ? randomBoolean() : !builder.forceUnigrams());
                builder.separator(randomValueOtherThan(builder.separator(), () -> randomAlphaOfLengthBetween(1, 10)));
        e = expectThrows(IllegalArgumentException.class, () -> builder.maxErrors(-1));
                builder.realWordErrorLikelihood(randomValueOtherThan(builder.realWordErrorLikelihood(), () -> randomFloat()));
                }
    protected PhraseSuggestionBuilder randomSuggestionBuilder() {
        // test empty field name
            assertEquals(defaultValue, actual);
                testBuilder.collateParams(collateParams);
        }
            case 2:
 *
        }
    public void testInvalidParameters() {
        }
 * license agreements. See the NOTICE file distributed with
    }
            assertEquals(builder.collateParams(), phraseSuggesterCtx.getCollateScriptParams());
        e = expectThrows(IllegalArgumentException.class, () -> builder.gramSize(0));
        assertEquals("Pre and post tag must both be null or both not be null.", e.getMessage());
        e = expectThrows(IllegalArgumentException.class, () -> builder.highlight("<b>", null));
            // preTag, postTag
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to
        setCommonPropertiesOnRandomBuilder(testBuilder);
        assertEquals("separator cannot be set to null", e.getMessage());
                break;
        if (builder.getCandidateGenerators().isEmpty() == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                break;
                if (currentPre != null) {
                Map<String, Object> collateParams = builder.collateParams() == null ? new HashMap<>(1) : builder.collateParams();
            maybeSet(testBuilder::collatePrune, randomBoolean());
        if (builder.collateQuery() != null) {
        assertOptionalEquals(
            testBuilder.smoothingModel(randomSmoothingModel());
                } else {
                break;
        maybeSet(testBuilder::maxErrors, randomFloat());
            assertEquals(optional, actual);
    }
                break;
                    builder.collateQuery(randomValueOtherThan(collateQuery.getIdOrCode(), () -> randomAlphaOfLengthBetween(3, 20)));
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {
        assertEquals(builder.separator(), phraseSuggesterCtx.separator().utf8ToString());
            PhraseSuggestionContext.DEFAULT_REQUIRE_UNIGRAM
 * this work for additional information regarding copyright
                break;
                break;
        return randomPhraseSuggestionBuilder();
            case 12:
        Exception e = expectThrows(NullPointerException.class, () -> new PhraseSuggestionBuilder((String) null));
            case 0:
            // currently, "direct_generator" is the only one available. Only compare size of the lists
/*
import java.util.Map;
        maybeSet(testBuilder::tokenLimit, randomIntBetween(1, 20));
        }
                    // simply double both values
        return testBuilder;
        assertOptionalEquals(builder.confidence(), phraseSuggesterCtx.confidence(), PhraseSuggestionContext.DEFAULT_CONFIDENCE);
            assertEquals(builder.getCandidateGenerators().get("direct_generator").size(), phraseSuggesterCtx.generators().size());
                break;
                builder.maxErrors(randomValueOtherThan(builder.maxErrors(), () -> randomFloat()));
        maybeSet(testBuilder::forceUnigrams, randomBoolean());
        }
 */
        maybeSet(testBuilder::separator, randomAlphaOfLengthBetween(1, 10));
    private static <T> void assertOptionalEquals(T optional, T actual, T defaultValue) {
import org.opensearch.search.suggest.AbstractSuggestionBuilderTestCase;
        assertEquals(builder.preTag(), phraseSuggesterCtx.getPreTag() != null ? phraseSuggesterCtx.getPreTag().utf8ToString() : null);
/*
            assertEquals(builder.smoothingModel().buildWordScorerFactory().getClass(), phraseSuggesterCtx.model().getClass());
        assertEquals("max_error must be > 0.0", e.getMessage());
 * Licensed to Elasticsearch under one or more contributor
            assertEquals(builder.collateQuery().getIdOrCode(), phraseSuggesterCtx.getCollateQueryScript().newInstance(null).execute());
                break;
                builder.confidence(randomValueOtherThan(builder.confidence(), () -> randomFloat()));
                if (collateQuery != null) {
        e = expectThrows(IllegalArgumentException.class, () -> builder.highlight(null, "</b>"));
    protected void mutateSpecificParameters(PhraseSuggestionBuilder builder) throws IOException {
        // test missing field name
        e = expectThrows(IllegalArgumentException.class, () -> builder.confidence(-1));
    }
        if (randomBoolean()) {
        PhraseSuggestionBuilder testBuilder = new PhraseSuggestionBuilder(randomAlphaOfLengthBetween(2, 20));
        assertEquals(builder.postTag(), phraseSuggesterCtx.getPostTag() != null ? phraseSuggesterCtx.getPostTag().utf8ToString() : null);
                break;
}
            case 2:
        switch (randomIntBetween(0, 2)) {
 * not use this file except in compliance with the License.
            case 3:
        assertOptionalEquals(builder.gramSize(), phraseSuggesterCtx.gramSize(), PhraseSuggestionContext.DEFAULT_GRAM_SIZE);
                builder.tokenLimit(randomValueOtherThan(builder.tokenLimit(), () -> randomIntBetween(1, 20)));
 * this file be licensed under the Apache-2.0 license or a
                builder.collatePrune(builder.collatePrune() == null ? randomBoolean() : !builder.collatePrune());
        maybeSet(testBuilder::realWordErrorLikelihood, randomFloat());
        assertEquals("real_word_error_likelihood must be > 0.0", e.getMessage());
        maybeSet(testBuilder::confidence, randomFloat());
                }
    public static PhraseSuggestionBuilder randomPhraseSuggestionBuilder() {
        e = expectThrows(IllegalArgumentException.class, () -> new PhraseSuggestionBuilder(""));
            case 1:
        // collate query prune and parameters will only be used when query is set
 * under the License.
            case 6:
import static org.hamcrest.Matchers.instanceOf;
        }
 */
        e = expectThrows(IllegalArgumentException.class, () -> builder.realWordErrorLikelihood(-1));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("suggestion requires a field name", e.getMessage());
        assertEquals("Pre and post tag must both be null or both not be null.", e.getMessage());
import java.io.IOException;
        maybeSet(testBuilder::collateQuery, randomAlphaOfLengthBetween(3, 20));
        SmoothingModel model = null;
 *
        assertEquals("token_limit must be >= 1", e.getMessage());
            builder.forceUnigrams(),
            int numGenerators = randomIntBetween(1, 5);
