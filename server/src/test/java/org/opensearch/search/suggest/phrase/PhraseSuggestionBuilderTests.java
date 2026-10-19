        assertEquals(builder.preTag(), phraseSuggesterCtx.getPreTag() != null ? phraseSuggesterCtx.getPreTag().utf8ToString() : null);  
                break;
                builder.forceUnigrams(builder.forceUnigrams() == null ? randomBoolean() : !builder.forceUnigrams());
    private static SmoothingModel randomSmoothingModel() {
            assertEquals(builder.getCandidateGenerators().get("direct_generator").size(), phraseSuggesterCtx.generators().size());
            assertEquals(builder.smoothingModel().buildWordScorerFactory().getClass(), phraseSuggesterCtx.model().getClass());
                builder.collatePrune(builder.collatePrune() == null ? randomBoolean() : !builder.collatePrune());  
            if (randomBoolean()) {
        }  
                }
 */  
            PhraseSuggestionContext.DEFAULT_REQUIRE_UNIGRAM  
                    builder.highlight(builder.preTag() + builder.preTag(), builder.postTag() + builder.postTag());
        assertOptionalEquals(builder.maxErrors(), phraseSuggesterCtx.maxErrors(), PhraseSuggestionContext.DEFAULT_MAX_ERRORS);
        assertEquals("gramSize must be >= 1", e.getMessage());
        } else {  
            case 12:
                Map<String, Object> collateParams = builder.collateParams() == null ? new HashMap<>(1) : builder.collateParams();
            assertEquals(builder.collateParams(), phraseSuggesterCtx.getCollateScriptParams());
            case 5:  
        if (testBuilder.collateQuery() != null) {
        if (builder.collateQuery() != null) {  
        e = expectThrows(IllegalArgumentException.class, () -> builder.highlight(null, "</b>"));  
    }
package org.opensearch.search.suggest.phrase;
        return randomPhraseSuggestionBuilder();
 * Modifications Copyright OpenSearch Contributors. See
        }
                break;
    @Override  
        maybeSet(testBuilder::tokenLimit, randomIntBetween(1, 20));
import java.io.IOException;
        if (builder.getCandidateGenerators().isEmpty() == false) {  
            case 7:
                break;
                builder.smoothingModel(randomValueOtherThan(builder.smoothingModel(), PhraseSuggestionBuilderTests::randomSmoothingModel));  
            case 1:
        e = expectThrows(IllegalArgumentException.class, () -> builder.gramSize(0));
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;  
        assertOptionalEquals(  
            phraseSuggesterCtx.realworldErrorLikelihood(),
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
                break;
        if (builder.collateParams() != null) {  
        }
                testBuilder.addCandidateGenerator(DirectCandidateGeneratorTests.randomCandidateGenerator());
 * You may obtain a copy of the License at  
 *
            int numGenerators = randomIntBetween(1, 5);  
                break;
        e = expectThrows(IllegalArgumentException.class, () -> builder.gramSize(-1));  
            assertEquals(optional, actual);
            case 0:  
        // test missing field name  
        assertEquals("confidence must be >= 0.0", e.getMessage());
                    collateParams.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
    }  
                break;
                builder.gramSize(randomValueOtherThan(builder.gramSize(), () -> randomIntBetween(1, 5)));
        assertEquals("Pre and post tag must both be null or both not be null.", e.getMessage());
 */  
        }  
                }  
            case 3:  
 */
        assertEquals("Pre and post tag must both be null or both not be null.", e.getMessage());
                }  
        SmoothingModel model = null;  
                if (currentPre != null) {
                break;
            testBuilder.smoothingModel(randomSmoothingModel());  
        assertEquals("suggestion field name is empty", e.getMessage());  
                break;
            builder.forceUnigrams(),
        return testBuilder;
                builder.realWordErrorLikelihood(randomValueOtherThan(builder.realWordErrorLikelihood(), () -> randomFloat()));
        e = expectThrows(IllegalArgumentException.class, () -> builder.maxErrors(-1));  
import java.util.Map;
                    builder.highlight(randomAlphaOfLengthBetween(3, 20), randomAlphaOfLengthBetween(3, 20));  
 * Unless required by applicable law or agreed to in writing,
import java.util.HashMap;  
                    builder.collateQuery(randomValueOtherThan(collateQuery.getIdOrCode(), () -> randomAlphaOfLengthBetween(3, 20)));  
            assertEquals(defaultValue, actual);
    @Override  
    protected void assertSuggestionContext(PhraseSuggestionBuilder builder, SuggestionContext context) {
        if (optional != null) {
                for (int i = 0; i < numParams; i++) {
        // collate query prune and parameters will only be used when query is set
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        assertEquals("gramSize must be >= 1", e.getMessage());
        }
/*
        assertEquals(builder.separator(), phraseSuggesterCtx.separator().utf8ToString());
                builder.separator(randomValueOtherThan(builder.separator(), () -> randomAlphaOfLengthBetween(1, 10)));
                break;
    protected PhraseSuggestionBuilder randomSuggestionBuilder() {
        switch (randomIntBetween(0, 2)) {
            case 6:  
        if (randomBoolean()) {
        e = expectThrows(IllegalArgumentException.class, () -> builder.tokenLimit(0));  
        assertThat(context.getSuggester(), instanceOf(PhraseSuggester.class));
        assertOptionalEquals(  
                model = LaplaceModelTests.createRandomModel();  
        // test empty field name
        PhraseSuggestionBuilder builder = new PhraseSuggestionBuilder(randomAlphaOfLengthBetween(2, 20));
/*  
    }  
 * not use this file except in compliance with the License.
        assertThat(context, instanceOf(PhraseSuggestionContext.class));  
        maybeSet(testBuilder::separator, randomAlphaOfLengthBetween(1, 10));  
        assertEquals("real_word_error_likelihood must be > 0.0", e.getMessage());
                builder.addCandidateGenerator(DirectCandidateGeneratorTests.randomCandidateGenerator());  
        Exception e = expectThrows(NullPointerException.class, () -> new PhraseSuggestionBuilder((String) null));
        PhraseSuggestionBuilder testBuilder = new PhraseSuggestionBuilder(randomAlphaOfLengthBetween(2, 20));  
    }
        e = expectThrows(IllegalArgumentException.class, () -> builder.highlight("<b>", null));  
                    // simply double both values  
                break;
            // currently, "direct_generator" is the only one available. Only compare size of the lists
                break;
        }
        e = expectThrows(IllegalArgumentException.class, () -> builder.realWordErrorLikelihood(-1));  
        assertEquals(builder.postTag(), phraseSuggesterCtx.getPostTag() != null ? phraseSuggesterCtx.getPostTag().utf8ToString() : null);
            testBuilder.highlight(randomAlphaOfLengthBetween(3, 20), randomAlphaOfLengthBetween(3, 20));  
                model = LinearInterpolationModelTests.createRandomModel();  
            phraseSuggesterCtx.getRequireUnigram(),
import static org.hamcrest.Matchers.instanceOf;  
                Map<String, Object> collateParams = new HashMap<>();
        }
                if (collateQuery != null) {
 * Licensed to Elasticsearch under one or more contributor  
                    builder.collateQuery(randomAlphaOfLengthBetween(3, 20));
        e = expectThrows(NullPointerException.class, () -> builder.separator(null));  
                builder.maxErrors(randomValueOtherThan(builder.maxErrors(), () -> randomFloat()));
        e = expectThrows(IllegalArgumentException.class, () -> builder.confidence(-1));  
        assertEquals("suggestion requires a field name", e.getMessage());
        maybeSet(testBuilder::maxErrors, randomFloat());
/*  
                String currentPre = builder.preTag();
 *  
    }  
 * specific language governing permissions and limitations
                } else {
                break;
 * this work for additional information regarding copyright
        if (randomBoolean()) {
        }
                builder.collateParams(collateParams);  
    protected void mutateSpecificParameters(PhraseSuggestionBuilder builder) throws IOException {
    private static <T> void assertOptionalEquals(T optional, T actual, T defaultValue) {  
        switch (randomIntBetween(0, 12)) {
            case 2:  
                break;
    public void testInvalidParameters() {
            maybeSet(testBuilder::collatePrune, randomBoolean());  
                break;
    @Override
            case 0:
        assertOptionalEquals(builder.confidence(), phraseSuggesterCtx.confidence(), PhraseSuggestionContext.DEFAULT_CONFIDENCE);  
                break;
import org.opensearch.search.suggest.AbstractSuggestionBuilderTestCase;
 *
                testBuilder.collateParams(collateParams);
            case 10:  
            case 11:
}
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
            case 1:  
        }
            case 4:  
        if (builder.smoothingModel() != null) {  
 * software distributed under the License is distributed on an
        if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                int numParams = randomIntBetween(1, 5);  
        assertOptionalEquals(builder.collatePrune(), phraseSuggesterCtx.collatePrune(), PhraseSuggestionContext.DEFAULT_COLLATE_PRUNE);
        assertEquals("max_error must be > 0.0", e.getMessage());
                builder.confidence(randomValueOtherThan(builder.confidence(), () -> randomFloat()));
                break;
            case 2:
                // preTag, postTag  
        e = expectThrows(IllegalArgumentException.class, () -> new PhraseSuggestionBuilder(""));
                builder.tokenLimit(randomValueOtherThan(builder.tokenLimit(), () -> randomIntBetween(1, 20)));
        maybeSet(testBuilder::realWordErrorLikelihood, randomFloat());
        maybeSet(testBuilder::gramSize, randomIntBetween(1, 5));
        );
        return model;  
        maybeSet(testBuilder::collateQuery, randomAlphaOfLengthBetween(3, 20));  
 * ownership. Elasticsearch licenses this file to you under  
                } else {
 * compatible open source license.
                collateParams.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
            PhraseSuggestionContext.DEFAULT_RWE_ERRORLIKELIHOOD  
        assertEquals("separator cannot be set to null", e.getMessage());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            for (int i = 0; i < numGenerators; i++) {
            assertEquals(builder.collateQuery().getIdOrCode(), phraseSuggesterCtx.getCollateQueryScript().newInstance(null).execute());
        }
            builder.realWordErrorLikelihood(),
    public static PhraseSuggestionBuilder randomPhraseSuggestionBuilder() {
            // preTag, postTag
        assertOptionalEquals(builder.tokenLimit(), phraseSuggesterCtx.getTokenLimit(), NoisyChannelSpellChecker.DEFAULT_TOKEN_LIMIT);
            case 8:
        PhraseSuggestionContext phraseSuggesterCtx = (PhraseSuggestionContext) context;
 * under the License.  
                Script collateQuery = builder.collateQuery();
import org.opensearch.script.Script;
        assertEquals("token_limit must be >= 1", e.getMessage());
                model = StupidBackoffModelTests.createRandomModel();  
        setCommonPropertiesOnRandomBuilder(testBuilder);
public class PhraseSuggestionBuilderTests extends AbstractSuggestionBuilderTestCase<PhraseSuggestionBuilder> {
        assertOptionalEquals(builder.gramSize(), phraseSuggesterCtx.gramSize(), PhraseSuggestionContext.DEFAULT_GRAM_SIZE);
    }
        );
        maybeSet(testBuilder::confidence, randomFloat());
            }
    }  
            }  
            case 9:  
        maybeSet(testBuilder::forceUnigrams, randomBoolean());  
