            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
            }
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
     */
 */  
 * compatible open source license.
        super.setUp();
    protected String validate(
package org.opensearch.search.aggregations;
    }
    @Override
        // aspect of the object under test
 * You may obtain a copy of the License at  
    /**
            .put("node.name", AbstractQueryTestCase.class.toString())
            }
        return emptyList();  
        } else {
     */
                assertEquals(deserializedQuery.hashCode(), testAgg.hashCode());
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected static final String STRING_FIELD_NAME = "mapped_string";
    // we use the streaming infra to create a copy of the query provided as
 * GitHub history for details.
    }
    }
        builder.validate(context);
     */
import org.opensearch.common.settings.Settings;  
import org.opensearch.core.xcontent.XContentBuilder;
        // TODO we only change name and boost, we should extend by any sub-test supplying a "mutate" method that randomly changes one  
import org.opensearch.core.xcontent.XContentParser;  
    protected String[] getRandomTypes() {  
        entries.addAll(additionalNamedWriteables());  
import org.opensearch.test.AbstractQueryTestCase;
}
        assertThat(parsed.getPipelineAggregatorFactories(), hasSize(1));  
import static org.hamcrest.Matchers.hasSize;  
 */  
import java.io.IOException;
        namedWriteableRegistry = new NamedWriteableRegistry(entries);
import org.opensearch.search.aggregations.PipelineAggregationBuilder.ValidationContext;
        xContentEntries.addAll(additionalNamedContents());  
import java.util.List;
    }
        switch (randomInt) {
 * license agreements. See the NOTICE file distributed with
    private String[] currentTypes;
            }
        return emptyList();
        try (BytesStreamOutput output = new BytesStreamOutput()) {  
     */  
    }
        }
        List<NamedWriteableRegistry.Entry> entries = new ArrayList<>();  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            logger.info("Content string: {}", contentString);  
            case 1:
    protected abstract AF createTestAggregatorFactory();
     * Setup for the whole base test class.
    protected static final String DOUBLE_FIELD_NAME = "mapped_double";  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        assertNotNull(newAgg);  
        AF testAgg = createTestAggregatorFactory();
    /**
    protected List<SearchPlugin> plugins() {
import org.opensearch.indices.IndicesModule;
 * not use this file except in compliance with the License.
        try (XContentParser parser = createParser(shuffled)) {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        assertThat(parsed.getAggregatorFactories(), hasSize(0));
 *
     * Test serialization and deserialization of the test AggregatorFactory.
    public void testSerialization() throws IOException {
    }  
        entries.addAll(indicesModule.getNamedWriteables());
        SearchModule searchModule = new SearchModule(settings, plugins());
    }
    public void testEqualsAndHashcode() throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        AggregatorFactories.Builder parsed = AggregatorFactories.parseAggregators(parser);
import org.opensearch.search.aggregations.pipeline.AbstractPipelineAggregationBuilder;  
     * Any extra named xcontents required not registered by {@link SearchModule}
    /**  
    protected NamedXContentRegistry xContentRegistry() {
                return INT_FIELD_NAME;  
import org.opensearch.search.SearchModule;
        Collection<AggregationBuilder> siblingAggregations,  
                return DATE_FIELD_NAME;
import org.opensearch.env.Environment;
    /**
            types = new String[numberOfQueryTypes];
        }
        checkEqualsAndHashCode(createTestAggregatorFactory(), this::copyAggregation);
 * specific language governing permissions and limitations
                PipelineAggregationBuilder deserializedQuery = in.readNamedWriteable(PipelineAggregationBuilder.class);  
        factoriesBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
import java.util.Collections;
    public String randomNumericField() {  
            int numberOfQueryTypes = randomIntBetween(1, currentTypes.length);  
import org.opensearch.core.common.io.stream.StreamInput;
        List<NamedXContentRegistry.Entry> xContentEntries = searchModule.getNamedXContents();
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        if (randomBoolean()) {
            PipelineAggregationBuilder newAgg = parse(parser);
    protected static final String INT_FIELD_NAME = "mapped_int";
        }
    }
        int randomInt = randomInt(3);
        Settings settings = Settings.builder()  
    }
        AggregatorFactories.Builder factoriesBuilder = AggregatorFactories.builder().addPipelineAggregator(testAgg);
    }  
            output.writeNamedWriteable(testAgg);
        String[] types;
     */  
        IndicesModule indicesModule = new IndicesModule(Collections.emptyList());
    protected PipelineAggregationBuilder parse(XContentParser parser) throws IOException {
    ) {  
        return validate(siblingAggregations, emptyList(), builder);
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
            builder.prettyPrint();  
            String type = randomAlphaOfLengthBetween(1, 10);
    protected static final String BOOLEAN_FIELD_NAME = "mapped_boolean";
public abstract class BasePipelineAggregationTestCase<AF extends AbstractPipelineAggregationBuilder<AF>> extends OpenSearchTestCase {
    private NamedXContentRegistry xContentRegistry;
        return context.getValidationException() == null ? null : context.getValidationException().getMessage();  
        currentTypes = new String[randomIntBetween(0, 5)];  
     * Helper for testing validation.
    /**
        return emptyList();
    protected String[] getCurrentTypes() {  
    /**
            String contentString = factoriesBuilder.toString();
     */
    }  
     */  
        xContentRegistry = new NamedXContentRegistry(xContentEntries);
     * the two queries.
            currentTypes[i] = type;  
    }
    /**
        }
        logger.info("Content string: {}", factoriesBuilder);  
        }
 * software distributed under the License is distributed on an
        }  
        return newAgg;
     * AggregatorFactory and checks both for equality and asserts equality on  
     * Helper for testing validation.
     */  
                types = new String[0];  
    /**  
     * Any extra named writeables required not registered by {@link SearchModule}  
        assertNull(parser.nextToken());
        return validate(ValidationContext.forInsideTree(parent, null), builder);
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
 */
                return secondAgg;
    /**  
     * Plugins to add to the test.
            } else {
        return xContentRegistry;  
import static java.util.Collections.emptyList;
                return DOUBLE_FIELD_NAME;  
    // argument  
     */
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
                types[i] = randomFrom(currentTypes);  
                types = new String[] { Metadata.ALL };
            assertEquals(testAgg, newAgg);  
            output.writeNamedWriteable(agg);  
        entries.addAll(searchModule.getNamedWriteables());
import org.opensearch.core.xcontent.NamedXContentRegistry;  
import org.opensearch.common.xcontent.XContentType;
            .build();  
/*  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.ToXContent;
        if (currentTypes.length > 0 && randomBoolean()) {
        AF testAgg = createTestAggregatorFactory();
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
            if (randomBoolean()) {  
        // create some random type with some default field, those types will stick around for all of the subclasses
    /**
        PipelineAggregationBuilder newAgg = parsed.getPipelineAggregatorFactories().iterator().next();
    private AF copyAggregation(AF agg) throws IOException {
    protected String validate(Collection<AggregationBuilder> siblingAggregations, AF builder) {
                assertNotSame(deserializedQuery, testAgg);  
    protected String validate(ValidationContext context, AF builder) {
 *  
    public void setUp() throws Exception {
            assertNotSame(newAgg, testAgg);
    }
        for (int i = 0; i < currentTypes.length; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
            case 0:  
    }  
            assertEquals(testAgg.hashCode(), newAgg.hashCode());
import org.opensearch.cluster.metadata.Metadata;
    @Override  
                @SuppressWarnings("unchecked")
        assertSame(XContentParser.Token.START_OBJECT, parser.nextToken());  
                assertEquals(deserializedQuery, testAgg);
    protected static final String DATE_FIELD_NAME = "mapped_date";
                AF secondAgg = (AF) in.readNamedWriteable(PipelineAggregationBuilder.class);  
        XContentBuilder shuffled = shuffleXContent(builder);  
 *
    protected String validate(AggregationBuilder parent, AF builder) {  
import org.opensearch.plugins.SearchPlugin;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.io.stream.BytesStreamOutput;
        AF builder
        }
            case 2:
 * The OpenSearch Contributors require contributions made to  
            }
    public void testFromXContent() throws IOException {  
        return validate(ValidationContext.forTreeRoot(siblingAggregations, siblingPipelineAggregations, null), builder);
/*
import java.util.Collection;  
    protected List<NamedWriteableRegistry.Entry> additionalNamedWriteables() {
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
    protected List<NamedXContentRegistry.Entry> additionalNamedContents() {  
        try (BytesStreamOutput output = new BytesStreamOutput()) {
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        return types;  
        return currentTypes;
     * Helper for testing validation.
            for (int i = 0; i < numberOfQueryTypes; i++) {
     * Generic test that creates new AggregatorFactory from the test
     */
     * Helper for testing validation.  
            default:
    private NamedWriteableRegistry namedWriteableRegistry;
 * this work for additional information regarding copyright
/*  
        Collection<PipelineAggregationBuilder> siblingPipelineAggregations,
