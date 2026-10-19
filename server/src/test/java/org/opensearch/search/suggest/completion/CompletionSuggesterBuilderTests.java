            for (int i = 0; i < numContext; i++) {  
import java.util.List;
        CompletionFieldType completionFieldType = new CompletionFieldType(
    private static final String[] SHUFFLE_PROTECTED_FIELDS = new String[] { CompletionSuggestionBuilder.CONTEXTS_FIELD.getPreferredName() };
        switch (randomIntBetween(0, 3)) {  
import org.opensearch.index.analysis.AnalyzerScope;
        // lazy initialization of context names and mappings, cannot be done in some init method because other test
                builder.prefix(randomAlphaOfLength(10), randomFrom(Fuzziness.ZERO, Fuzziness.ONE, Fuzziness.TWO));
                List<GeoQueryContext> geoContexts = new ArrayList<>(nGeoContext);
            case 2:
 */
        if (analyzerSet == false) {
 * not use this file except in compliance with the License.
            categoryContextName = randomAlphaOfLength(10);
 */  
        }  
            case 5:
     * the equals() test will fail because their {@link BytesReference} representation isn't the same
import java.util.HashMap;  
                testBuilder.prefix(randomAlphaOfLength(10), randomFrom(Fuzziness.ZERO, Fuzziness.ONE, Fuzziness.TWO));
            Collections.emptyMap()
        if (contextMappings.isEmpty()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
                for (int i = 0; i < nGeoContext; i++) {
                    contexts.add(CategoryQueryContextTests.randomCategoryQueryContext());
        }  
    protected void assertSuggestionContext(CompletionSuggestionBuilder builder, SuggestionContext context) throws IOException {
import org.opensearch.search.suggest.completion.context.ContextMapping.InternalQueryContext;
 * Modifications Copyright OpenSearch Contributors. See
        if (randomBoolean()) {
        return SHUFFLE_PROTECTED_FIELDS;  
 * GitHub history for details.
    @Override
            geoQueryContextName = randomAlphaOfLength(10);
    }
        Map<String, List<InternalQueryContext>> parsedContextBytes;
import java.util.ArrayList;
    private static String geoQueryContextName;
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
 * specific language governing permissions and limitations
                builder.skipDuplicates(!builder.skipDuplicates);
                List<CategoryQueryContext> contexts = new ArrayList<>(nCatContext);
        completionFieldType.setContextMappings(new ContextMappings(contextMappings));  
        if (geoQueryContextName == null) {  
 * this work for additional information regarding copyright
                break;  
    }
/*  
public class CompletionSuggesterBuilderTests extends AbstractSuggestionBuilderTestCase<CompletionSuggestionBuilder> {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.suggest.completion.context.ContextMapping;
    protected void mutateSpecificParameters(CompletionSuggestionBuilder builder) throws IOException {
        setCommonPropertiesOnRandomBuilder(testBuilder);
 * SPDX-License-Identifier: Apache-2.0
                testBuilder.prefix(randomAlphaOfLength(10), FuzzyOptionsTests.randomFuzzyOptions());
    }  
            contextMappings.add(ContextBuilder.geo(geoQueryContextName).build());
        Map<String, List<InternalQueryContext>> queryContexts = completionSuggestionCtx.getQueryContexts();
        );
    protected MappedFieldType mockFieldType(String fieldName, boolean analyzerSet) {
        testBuilder.skipDuplicates(randomBoolean());
        if (randomBoolean()) {  
        }
        // also create random CompletionSuggestionBuilder instances
 */  
            for (int i = 0; i < numContext; i++) {
 * this file be licensed under the Apache-2.0 license or a
            case 0:  
        assertEquals(parsedContextBytes.keySet(), queryContexts.keySet());  
            }
        parsedContextBytes = CompletionSuggestionBuilder.parseContextBytes(  
            builder.contextBytes,
        if (categoryContextName == null) {  
        CompletionSuggestionBuilder testBuilder = new CompletionSuggestionBuilder(randomAlphaOfLengthBetween(2, 20));
            contextMap.put(geoQueryContextName, contexts);
            List<GeoQueryContext> contexts = new ArrayList<>(numContext);
            case 3:
                testBuilder.prefix(randomAlphaOfLength(10));
import java.util.Map;
    }
    protected CompletionSuggestionBuilder randomSuggestionBuilder() {
import org.opensearch.index.mapper.MappedFieldType;
            completionFieldType.setContextMappings(new ContextMappings(contextMappings));
import org.opensearch.search.suggest.completion.context.ContextMappings;  
        // also create random CompletionSuggestionBuilder instances
 * You may obtain a copy of the License at  
        }  
        assertEquals(builder.fuzzyOptions, completionSuggestionCtx.getFuzzyOptions());
                testBuilder.regex(randomAlphaOfLength(10), RegexOptionsTests.randomRegexOptions());
        assertThat(completionSuggestionCtx.getFieldType(), instanceOf(CompletionFieldType.class));  
        testBuilder.contexts(contextMap);
                break;  
import org.opensearch.search.suggest.completion.context.CategoryQueryContext;
                int nGeoContext = randomIntBetween(1, 5);  
import org.apache.lucene.analysis.core.SimpleAnalyzer;
            contextMap.put(categoryContextName, contexts);  
                throw new IllegalStateException("should not through");
        }
                builder.prefix(randomAlphaOfLength(10), FuzzyOptionsTests.randomFuzzyOptions());
 *
        return testBuilder;  
import java.util.Collections;
            case 0:
                }
                builder.contexts(Collections.singletonMap(randomAlphaOfLength(10), geoContexts));
        // lazy initialization of context names and mappings, cannot be done in some init method because other test
import org.opensearch.common.unit.Fuzziness;
 *
            case 1:
        return randomCompletionSuggestionBuilder();  
/*  
            fieldName,
import static org.hamcrest.Matchers.instanceOf;
 *  
            assertEquals(parsedContextBytes.get(contextName), queryContexts.get(contextName));
            contextMappings.add(ContextBuilder.category(categoryContextName).build());
            int numContext = randomIntBetween(1, 5);  
                break;  
                break;  
        CompletionSuggestionContext completionSuggestionCtx = (CompletionSuggestionContext) context;
    /**  
    @Override
 * software distributed under the License is distributed on an
            geoQueryContextName = randomAlphaOfLength(10);
            case 1:
            new NamedAnalyzer("fieldSearchAnalyzer", AnalyzerScope.INDEX, new SimpleAnalyzer()),  
        switch (randomIntBetween(0, 5)) {
    public static CompletionSuggestionBuilder randomCompletionSuggestionBuilder() {  
            default:
     * exclude the "contexts" field from recursive random shuffling in fromXContent tests or else
            CompletionFieldType completionFieldType = new CompletionFieldType(fieldName, null, Collections.emptyMap());  
                break;  
                }
 * The OpenSearch Contributors require contributions made to  
        }  
        assertEquals(builder.regexOptions, completionSuggestionCtx.getRegexOptions());
/*
import org.opensearch.core.xcontent.ToXContent;
    private static String categoryContextName;  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * Unless required by applicable law or agreed to in writing,
                for (int i = 0; i < nCatContext; i++) {  
package org.opensearch.search.suggest.completion;
        if (categoryContextName == null) {  
            contextMappings.add(ContextBuilder.category(categoryContextName).build());
 * license agreements. See the NOTICE file distributed with
            case 2:
        assertThat(context.getSuggester(), instanceOf(CompletionSuggester.class));
            int numContext = randomIntBetween(1, 5);
            categoryContextName = randomAlphaOfLength(10);
        if (geoQueryContextName == null) {  
import java.io.IOException;  
                contexts.add(GeoQueryContextTests.randomGeoQueryContext());  
            case 4:
                break;  
import org.opensearch.index.analysis.NamedAnalyzer;  
    }
        }  
}
        if (contextMappings.isEmpty()) {  
import org.opensearch.search.suggest.AbstractSuggestionBuilderTestCase;  
    @Override  
                    geoContexts.add(GeoQueryContextTests.randomGeoQueryContext());  
import org.opensearch.index.mapper.CompletionFieldMapper.CompletionFieldType;
        Map<String, List<? extends ToXContent>> contextMap = new HashMap<>();
            return completionFieldType;
 * under the License.  
                builder.contexts(Collections.singletonMap(randomAlphaOfLength(10), contexts));  
            List<CategoryQueryContext> contexts = new ArrayList<>(numContext);
            case 3:
                break;  
            new ContextMappings(contextMappings)  
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
        assertThat(context, instanceOf(CompletionSuggestionContext.class));  
    private static List<ContextMapping<?>> contextMappings = new ArrayList<>();
            }
        );
 * the Apache License, Version 2.0 (the "License"); you may
        }
    @Override  
                builder.regex(randomAlphaOfLength(10), RegexOptionsTests.randomRegexOptions());
                break;
            xContentRegistry(),
                break;  
                break;  
    @Override
import org.opensearch.search.suggest.completion.context.ContextBuilder;  
    protected String[] shuffleProtectedFields() {
        assertEquals(builder.skipDuplicates, completionSuggestionCtx.isSkipDuplicates());
 * compatible open source license.
        }
        }
        for (String contextName : queryContexts.keySet()) {
import org.opensearch.search.suggest.completion.context.GeoQueryContext;
                int nCatContext = randomIntBetween(1, 5);
        return completionFieldType;
            contextMappings.add(ContextBuilder.geo(geoQueryContextName).build());
                contexts.add(CategoryQueryContextTests.randomCategoryQueryContext());
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.bytes.BytesReference;  
