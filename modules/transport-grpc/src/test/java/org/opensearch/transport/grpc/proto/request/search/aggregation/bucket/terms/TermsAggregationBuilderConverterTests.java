                .setExecutionHint(TermsAggregationExecutionHint.TERMS_AGGREGATION_EXECUTION_HINT_MAP)  
    }
        );
            .build();
    }
        assertEquals(SubAggCollectionMode.BREADTH_FIRST, t.collectMode());
import org.opensearch.protobufs.FieldValue;
        );
    public void setUp() throws Exception {
    public void testMissingTermsFields() {
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(builder instanceof TermsAggregationBuilder);  
                .setField("category")
package org.opensearch.transport.grpc.proto.request.search.aggregation.bucket.terms;
    public void testAllFieldsCombined() {
                TermsAggregationFields.newBuilder()  
import org.opensearch.protobufs.TermsAggregation;
    public void testIncludeExcludeVariants() {
                    .setField("f")
        AggregationContainer container = buildContainer(  
        );
    }  
        assertNotNull(withBothRegex.includeExclude());
                TermsAggregationFields.newBuilder()
    private static AggregationContainer buildContainer(TermsAggregationFields fields) {
        assertTrue(withPartition.includeExclude().isPartitionBased());  
        TermsAggregationBuilder termsBuilder = (TermsAggregationBuilder) converter.fromProto("t", container);  
                    .setInclude(  
            "t",
import org.opensearch.protobufs.InlineScript;
        // _count desc
            "t",  
                .build()
        );
            TermsAggregationFields.newBuilder()
/**
    public void testBasicFieldOnly() {
                TermsAggregationFields.newBuilder().setField("f").setExclude(TermsExclude.newBuilder().setRegexp("bar.*").build()).build()
        assertEquals("status", ((TermsAggregationBuilder) builder).field());
            TermsAggregationFields.newBuilder()
                    .build()  
            buildContainer(
 * The OpenSearch Contributors require contributions made to  
        assertEquals(BucketOrder.compound(BucketOrder.aggregation("avg_price", false)), subAgg.order());
        expectThrows(IllegalArgumentException.class, () -> converter.fromProto("t", container));
                    .build()
 */
        TermsAggregationBuilder t = (TermsAggregationBuilder) converter.fromProto("full_terms", container);
import org.opensearch.protobufs.TermsAggregationExecutionHint;  
                    .setField("f")
            )  
        assertEquals("map", t.executionHint());  
        assertEquals(10, t.minDocCount());
    }  
                        TermsInclude.newBuilder()
            buildContainer(
                TermsAggregationFields.newBuilder()
 * compatible open source license.
import org.opensearch.protobufs.SortOrderSingleMap;
        );
                    .setExclude(TermsExclude.newBuilder().setRegexp("bar.*").build())  
            buildContainer(
                            .setPartition(TermsPartition.newBuilder().setPartition(0).setNumPartitions(5).build())
        super.setUp();
        AggregationContainer container = AggregationContainer.newBuilder()
                    .addOrder(SortOrderSingleMap.newBuilder().setField("_key").setSortOrder(SortOrder.SORT_ORDER_ASC).build())
        TermsAggregationBuilder withRegexInclude = (TermsAggregationBuilder) converter.fromProto(  
            "t",
                .setShardMinDocCount(3)  
        // _key asc (key order is a tie-breaker itself, not wrapped in compound)
                .setMinDocCount(10)
            "t",
        assertEquals("by_status", builder.getName());
                    .build()
    @Override  
    public void testStringMissingValue() {
    public void testContainerWithoutTermsAggregation() {
        assertNotNull(withInclude.includeExclude());  
        assertEquals(AggregationContainer.AggregationContainerCase.TERMS_AGGREGATION, converter.getHandledAggregationCase());
import org.opensearch.protobufs.TermsAggregationCollectMode;
            "t",
            )  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
            )  
                    )
        TermsAggregationBuilder countDesc = (TermsAggregationBuilder) converter.fromProto(
        // include by terms  
                .setShowTermDocCountError(true)
            "t",  
        TermsAggregationBuilder withExclude = (TermsAggregationBuilder) converter.fromProto(  
                        TermsExclude.newBuilder().setTerms(StringArray.newBuilder().addStringArray("x").addStringArray("y").build()).build()  
 */  
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['status'].value").build()).build())
            TermsAggregationFields.newBuilder().setField("status").setMissing(FieldValue.newBuilder().setString("unknown").build()).build()
        AggregationBuilder builder = converter.fromProto("by_status", container);
            buildContainer(
        AggregationContainer container = buildContainer(  
        assertTrue(t.showTermDocCountError());
                TermsAggregationFields.newBuilder()  
        AggregationContainer container = AggregationContainer.newBuilder().build();  
        assertNotNull(withExclude.includeExclude());
        expectThrows(IllegalStateException.class, () -> converter.fromProto("t", container));
        converter = new TermsAggregationBuilderConverter();  
                .setSize(50)  
        assertEquals(50, t.size());  
                    .setInclude(  
                    .build()
        return AggregationContainer.newBuilder().setTermsAggregation(TermsAggregation.newBuilder().setTerms(fields).build()).build();  
                    )
        // exclude by regex
                    .setField("f")  
        assertEquals("doc['status'].value", termsBuilder.script().getIdOrCode());
import org.opensearch.protobufs.Script;  
                TermsAggregationFields.newBuilder()
import org.opensearch.protobufs.AggregationContainer;  
                .setFormat("###")
import org.opensearch.protobufs.SortOrder;
                .setShardSize(200)
    public void testGetHandledAggregationCase() {  
        // include by regex
 *
        );
                    .addOrder(SortOrderSingleMap.newBuilder().setField("_count").setSortOrder(SortOrder.SORT_ORDER_DESC).build())
            )  
    }
                    .build()
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull(termsBuilder.script());
                .setCollectMode(TermsAggregationCollectMode.TERMS_AGGREGATION_COLLECT_MODE_BREADTH_FIRST)
        TermsAggregationBuilder withPartition = (TermsAggregationBuilder) converter.fromProto(
            )  
        );
                TermsAggregationFields.newBuilder()
        TermsAggregationBuilder withBothRegex = (TermsAggregationBuilder) converter.fromProto(  
        TermsAggregationBuilder builder = (TermsAggregationBuilder) converter.fromProto("by_status", container);
    }  
}
    public void testOrderVariants() {  
        AggregationContainer container = buildContainer(TermsAggregationFields.newBuilder().setField("status").build());
import org.opensearch.search.aggregations.AggregationBuilder;
                    .setField("f")  
        );
        assertEquals(200, t.shardSize());
        assertTrue(withRegexInclude.includeExclude().isRegexBased());
            buildContainer(  
            buildContainer(
                TermsAggregationFields.newBuilder().setField("f").setInclude(TermsInclude.newBuilder().setRegexp("foo.*").build()).build()  
                    .build()
        );
 * Tests for {@link TermsAggregationBuilderConverter}.  
        assertNotNull(withRegexInclude.includeExclude());  
        assertNotNull(withPartition.includeExclude());
        );  
        assertEquals("category", t.field());
            "t",  
                    .setField("f")
                    .setField("f")  
                    .build()
    }
            )
            "t",  
    private TermsAggregationBuilderConverter converter;
        TermsAggregationBuilder keyAsc = (TermsAggregationBuilder) converter.fromProto(
            )  
                    .setInclude(TermsInclude.newBuilder().setRegexp("foo.*").build())
            .setTermsAggregation(TermsAggregation.newBuilder().build())  
        assertEquals(BucketOrder.key(true), keyAsc.order());
                            .build()  
            )
import org.opensearch.search.aggregations.BucketOrder;
            )
        assertNotNull(withRegexExclude.includeExclude());
import org.opensearch.protobufs.TermsExclude;
    }  
        assertNotNull(builder);
                    .addOrder(SortOrderSingleMap.newBuilder().setField("avg_price").setSortOrder(SortOrder.SORT_ORDER_DESC).build())
        assertNotNull(t.includeExclude());
    }  
        TermsAggregationBuilder withRegexExclude = (TermsAggregationBuilder) converter.fromProto(
        assertEquals("unknown", builder.missing());  
        assertEquals(3, t.shardMinDocCount());  
        TermsAggregationBuilder withInclude = (TermsAggregationBuilder) converter.fromProto(
    public void testScriptOnly() {
                    .setField("f")
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;  
            buildContainer(
import org.opensearch.protobufs.StringArray;  
    }  
        assertTrue(withRegexExclude.includeExclude().isRegexBased());  
        AggregationContainer container = buildContainer(  
            buildContainer(
                        TermsInclude.newBuilder().setTerms(StringArray.newBuilder().addStringArray("a").addStringArray("b").build()).build()
            "t",
        assertEquals("###", t.format());
import org.opensearch.protobufs.TermsAggregationFields;
        TermsAggregationBuilder subAgg = (TermsAggregationBuilder) converter.fromProto(
/*  
                .addOrder(SortOrderSingleMap.newBuilder().setField("_count").setSortOrder(SortOrder.SORT_ORDER_ASC).build())
        // include by partition  
        // both include regex + exclude regex
            buildContainer(  
                .setExclude(TermsExclude.newBuilder().setTerms(StringArray.newBuilder().addStringArray("other").build()).build())  
                    .setExclude(
        // sub-aggregation path
        );
public class TermsAggregationBuilderConverterTests extends OpenSearchTestCase {
    }
        assertTrue(withBothRegex.includeExclude().isRegexBased());
                TermsAggregationFields.newBuilder()
                    )
import org.opensearch.test.OpenSearchTestCase;  
        // exclude by terms
import org.opensearch.protobufs.TermsInclude;  
                .build()  
        );
        assertEquals(BucketOrder.compound(BucketOrder.count(false)), countDesc.order());
import org.opensearch.protobufs.TermsPartition;
