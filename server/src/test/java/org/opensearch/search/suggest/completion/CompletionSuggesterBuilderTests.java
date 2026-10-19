            case 0:
                break;
            xContentRegistry(),
 * this file be licensed under the Apache-2.0 license or a
                testBuilder.prefix(randomAlphaOfLength(10), FuzzyOptionsTests.randomFuzzyOptions());
            completionFieldType.setContextMappings(new ContextMappings(contextMappings));
        assertEquals(builder.fuzzyOptions, completionSuggestionCtx.getFuzzyOptions());
                List<CategoryQueryContext> contexts = new ArrayList<>(nCatContext);
    private static List<ContextMapping<?>> contextMappings = new ArrayList<>();
import java.util.List;
                for (int i = 0; i < nCatContext; i++) {
     */
        switch (randomIntBetween(0, 3)) {
        }
                break;
            Collections.emptyMap()
            fieldName,
import java.util.HashMap;
        if (randomBoolean()) {
            }
 * Unless required by applicable law or agreed to in writing,
        Map<String, List<InternalQueryContext>> parsedContextBytes;
 * Modifications Copyright OpenSearch Contributors. See
            CompletionFieldType completionFieldType = new CompletionFieldType(fieldName, null, Collections.emptyMap());
            case 1:
import java.io.IOException;
package org.opensearch.search.suggest.completion;
                }
            contextMappings.add(ContextBuilder.geo(geoQueryContextName).build());
        assertThat(context, instanceOf(CompletionSuggestionContext.class));
    }
import java.util.Map;
                int nCatContext = randomIntBetween(1, 5);
import org.apache.lucene.analysis.core.SimpleAnalyzer;
                    geoContexts.add(GeoQueryContextTests.randomGeoQueryContext());
            List<CategoryQueryContext> contexts = new ArrayList<>(numContext);
            for (int i = 0; i < numContext; i++) {
        assertEquals(parsedContextBytes.keySet(), queryContexts.keySet());
                builder.contexts(Collections.singletonMap(randomAlphaOfLength(10), contexts));
                builder.prefix(randomAlphaOfLength(10), FuzzyOptionsTests.randomFuzzyOptions());
 * under the License.
                contexts.add(GeoQueryContextTests.randomGeoQueryContext());
            contextMappings.add(ContextBuilder.category(categoryContextName).build());
public class CompletionSuggesterBuilderTests extends AbstractSuggestionBuilderTestCase<CompletionSuggestionBuilder> {
            new ContextMappings(contextMappings)
 * ownership. Elasticsearch licenses this file to you under
        }
        }
import org.opensearch.search.suggest.completion.context.CategoryQueryContext;
                break;
 */
import org.opensearch.search.suggest.AbstractSuggestionBuilderTestCase;
        CompletionSuggestionBuilder testBuilder = new CompletionSuggestionBuilder(randomAlphaOfLengthBetween(2, 20));
import org.opensearch.search.suggest.completion.context.GeoQueryContext;
    @Override
            contextMappings.add(ContextBuilder.category(categoryContextName).build());
    }
            case 3:
            return completionFieldType;
        testBuilder.contexts(contextMap);
 *
 */
            contextMap.put(geoQueryContextName, contexts);
            contextMappings.add(ContextBuilder.geo(geoQueryContextName).build());
            case 2:
        );
        return randomCompletionSuggestionBuilder();
        assertEquals(builder.regexOptions, completionSuggestionCtx.getRegexOptions());
 * the Apache License, Version 2.0 (the "License"); you may
                break;
                break;
        // also create random CompletionSuggestionBuilder instances
        Map<String, List<? extends ToXContent>> contextMap = new HashMap<>();
    protected String[] shuffleProtectedFields() {
    public static CompletionSuggestionBuilder randomCompletionSuggestionBuilder() {
            categoryContextName = randomAlphaOfLength(10);
                contexts.add(CategoryQueryContextTests.randomCategoryQueryContext());
        if (randomBoolean()) {
 * software distributed under the License is distributed on an
        assertThat(context.getSuggester(), instanceOf(CompletionSuggester.class));
    @Override
            categoryContextName = randomAlphaOfLength(10);
        // also create random CompletionSuggestionBuilder instances
 *    http://www.apache.org/licenses/LICENSE-2.0
                throw new IllegalStateException("should not through");
        }
        return SHUFFLE_PROTECTED_FIELDS;
        assertThat(completionSuggestionCtx.getFieldType(), instanceOf(CompletionFieldType.class));
                testBuilder.regex(randomAlphaOfLength(10), RegexOptionsTests.randomRegexOptions());
        CompletionFieldType completionFieldType = new CompletionFieldType(
        if (categoryContextName == null) {
        }
                testBuilder.prefix(randomAlphaOfLength(10), randomFrom(Fuzziness.ZERO, Fuzziness.ONE, Fuzziness.TWO));
                builder.skipDuplicates(!builder.skipDuplicates);
        Map<String, List<InternalQueryContext>> queryContexts = completionSuggestionCtx.getQueryContexts();
                List<GeoQueryContext> geoContexts = new ArrayList<>(nGeoContext);
            case 2:
                testBuilder.prefix(randomAlphaOfLength(10));
            case 0:
                builder.contexts(Collections.singletonMap(randomAlphaOfLength(10), geoContexts));
     * exclude the "contexts" field from recursive random shuffling in fromXContent tests or else
import org.opensearch.search.suggest.completion.context.ContextMapping;
 * not use this file except in compliance with the License.
                int nGeoContext = randomIntBetween(1, 5);
import org.opensearch.core.xcontent.ToXContent;
                for (int i = 0; i < nGeoContext; i++) {
        if (analyzerSet == false) {
        }
/*
import java.util.ArrayList;
            int numContext = randomIntBetween(1, 5);
 * KIND, either express or implied.  See the License for the
    protected void assertSuggestionContext(CompletionSuggestionBuilder builder, SuggestionContext context) throws IOException {
    private static String categoryContextName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            case 3:
            List<GeoQueryContext> contexts = new ArrayList<>(numContext);
            default:
        if (contextMappings.isEmpty()) {
        completionFieldType.setContextMappings(new ContextMappings(contextMappings));
        }
import org.opensearch.core.common.bytes.BytesReference;
     * the equals() test will fail because their {@link BytesReference} representation isn't the same
    @Override
            geoQueryContextName = randomAlphaOfLength(10);
                builder.regex(randomAlphaOfLength(10), RegexOptionsTests.randomRegexOptions());
    @Override
        }
    /**
    }
            }
 * The OpenSearch Contributors require contributions made to
/*
        }
 */
        }
import org.opensearch.index.mapper.CompletionFieldMapper.CompletionFieldType;
import static org.hamcrest.Matchers.instanceOf;
    protected CompletionSuggestionBuilder randomSuggestionBuilder() {
 * You may obtain a copy of the License at
            for (int i = 0; i < numContext; i++) {
            builder.contextBytes,
        // lazy initialization of context names and mappings, cannot be done in some init method because other test
 *
}
                }
            int numContext = randomIntBetween(1, 5);
 * Licensed to Elasticsearch under one or more contributor
            contextMap.put(categoryContextName, contexts);
                break;
            assertEquals(parsedContextBytes.get(contextName), queryContexts.get(contextName));
    private static String geoQueryContextName;
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        if (categoryContextName == null) {
                break;
                builder.prefix(randomAlphaOfLength(10), randomFrom(Fuzziness.ZERO, Fuzziness.ONE, Fuzziness.TWO));
        }
/*
        setCommonPropertiesOnRandomBuilder(testBuilder);
 * compatible open source license.
 *
        switch (randomIntBetween(0, 5)) {
            geoQueryContextName = randomAlphaOfLength(10);
            case 1:
        return completionFieldType;
    private static final String[] SHUFFLE_PROTECTED_FIELDS = new String[] { CompletionSuggestionBuilder.CONTEXTS_FIELD.getPreferredName() };
import org.opensearch.common.unit.Fuzziness;
        return testBuilder;
 * license agreements. See the NOTICE file distributed with
        if (geoQueryContextName == null) {
        if (geoQueryContextName == null) {
import org.opensearch.index.analysis.AnalyzerScope;
    }
            case 5:
        CompletionSuggestionContext completionSuggestionCtx = (CompletionSuggestionContext) context;
        testBuilder.skipDuplicates(randomBoolean());
 * GitHub history for details.
        // lazy initialization of context names and mappings, cannot be done in some init method because other test
                break;
    @Override
    protected MappedFieldType mockFieldType(String fieldName, boolean analyzerSet) {
import org.opensearch.index.analysis.NamedAnalyzer;
            case 4:
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.search.suggest.completion.context.ContextMappings;
import java.util.Collections;
    }
    }
                break;
        for (String contextName : queryContexts.keySet()) {
import org.opensearch.search.suggest.completion.context.ContextMapping.InternalQueryContext;
    protected void mutateSpecificParameters(CompletionSuggestionBuilder builder) throws IOException {
 * this work for additional information regarding copyright
                break;
        );
        assertEquals(builder.skipDuplicates, completionSuggestionCtx.isSkipDuplicates());
import org.opensearch.search.suggest.completion.context.ContextBuilder;
        }
        if (contextMappings.isEmpty()) {
            new NamedAnalyzer("fieldSearchAnalyzer", AnalyzerScope.INDEX, new SimpleAnalyzer()),
        parsedContextBytes = CompletionSuggestionBuilder.parseContextBytes(
                    contexts.add(CategoryQueryContextTests.randomCategoryQueryContext());
