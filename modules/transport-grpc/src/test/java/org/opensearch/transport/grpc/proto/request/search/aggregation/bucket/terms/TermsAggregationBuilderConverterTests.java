    }
 * Tests for {@link TermsAggregationBuilderConverter}.
        // include by regex
        assertNotNull(withPartition.includeExclude());
                    .addOrder(SortOrderSingleMap.newBuilder().setField("_count").setSortOrder(SortOrder.SORT_ORDER_DESC).build())
import org.opensearch.protobufs.StringArray;
                    .setInclude(TermsInclude.newBuilder().setRegexp("foo.*").build())
            "t",
        assertEquals("map", t.executionHint());
    public void testMissingTermsFields() {
        );
        assertTrue(withRegexExclude.includeExclude().isRegexBased());
        assertEquals("status", ((TermsAggregationBuilder) builder).field());
            buildContainer(
        assertTrue(builder instanceof TermsAggregationBuilder);
        TermsAggregationBuilder withPartition = (TermsAggregationBuilder) converter.fromProto(
        TermsAggregationBuilder withBothRegex = (TermsAggregationBuilder) converter.fromProto(
        assertTrue(withRegexInclude.includeExclude().isRegexBased());
    public void testIncludeExcludeVariants() {
    }
        TermsAggregationBuilder withRegexInclude = (TermsAggregationBuilder) converter.fromProto(
        TermsAggregationBuilder subAgg = (TermsAggregationBuilder) converter.fromProto(
    }
                    .setExclude(
        AggregationContainer container = AggregationContainer.newBuilder().build();
                    .setField("f")
                    .build()
/*
        AggregationContainer container = buildContainer(TermsAggregationFields.newBuilder().setField("status").build());
            buildContainer(
        assertEquals("by_status", builder.getName());
            )
        );
                .setExecutionHint(TermsAggregationExecutionHint.TERMS_AGGREGATION_EXECUTION_HINT_MAP)
            TermsAggregationFields.newBuilder()
            )
 * this file be licensed under the Apache-2.0 license or a
    }
    public void testOrderVariants() {
                TermsAggregationFields.newBuilder()
            .setTermsAggregation(TermsAggregation.newBuilder().build())
                    .build()
            buildContainer(
        );
        );
        assertEquals(3, t.shardMinDocCount());
        assertNotNull(builder);
        AggregationBuilder builder = converter.fromProto("by_status", container);
        assertNotNull(t.includeExclude());
        // _key asc (key order is a tie-breaker itself, not wrapped in compound)
            "t",
    }
        TermsAggregationBuilder countDesc = (TermsAggregationBuilder) converter.fromProto(
 * The OpenSearch Contributors require contributions made to
                    .setField("f")
            buildContainer(
                .build()
    public void testGetHandledAggregationCase() {
import org.opensearch.search.aggregations.BucketOrder;
                TermsAggregationFields.newBuilder()
        assertNotNull(withBothRegex.includeExclude());
import org.opensearch.protobufs.TermsAggregationFields;
                .setExclude(TermsExclude.newBuilder().setTerms(StringArray.newBuilder().addStringArray("other").build()).build())
        assertEquals("unknown", builder.missing());
        );
import org.opensearch.protobufs.TermsAggregation;
                        TermsInclude.newBuilder().setTerms(StringArray.newBuilder().addStringArray("a").addStringArray("b").build()).build()
    @Override
            )
import org.opensearch.protobufs.FieldValue;
import org.opensearch.protobufs.SortOrderSingleMap;
        assertTrue(t.showTermDocCountError());
                    .addOrder(SortOrderSingleMap.newBuilder().setField("avg_price").setSortOrder(SortOrder.SORT_ORDER_DESC).build())
                .setSize(50)
            )
    }
                .addOrder(SortOrderSingleMap.newBuilder().setField("_count").setSortOrder(SortOrder.SORT_ORDER_ASC).build())
                    .setField("f")
        assertEquals(BucketOrder.compound(BucketOrder.aggregation("avg_price", false)), subAgg.order());
                .setField("category")
                .setShardSize(200)
        // exclude by regex
                .setMinDocCount(10)
                    .setField("f")
    }
            )
        assertEquals(10, t.minDocCount());
                    .setInclude(
package org.opensearch.transport.grpc.proto.request.search.aggregation.bucket.terms;
        AggregationContainer container = buildContainer(
        AggregationContainer container = buildContainer(
        converter = new TermsAggregationBuilderConverter();
            "t",
 * SPDX-License-Identifier: Apache-2.0
        );
                    .addOrder(SortOrderSingleMap.newBuilder().setField("_key").setSortOrder(SortOrder.SORT_ORDER_ASC).build())
                TermsAggregationFields.newBuilder()
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        // include by terms
        assertEquals(200, t.shardSize());
import org.opensearch.protobufs.InlineScript;
        assertNotNull(withRegexExclude.includeExclude());
        assertEquals(SubAggCollectionMode.BREADTH_FIRST, t.collectMode());
                    )
            TermsAggregationFields.newBuilder()
        // both include regex + exclude regex
    public void testStringMissingValue() {
/**
            buildContainer(
                TermsAggregationFields.newBuilder()
            "t",
                    .setInclude(
                    .build()
            .build();
                TermsAggregationFields.newBuilder()
                .setScript(Script.newBuilder().setInline(InlineScript.newBuilder().setSource("doc['status'].value").build()).build())
        // exclude by terms
            buildContainer(
        );
 *
 * compatible open source license.
            "t",
        assertTrue(withBothRegex.includeExclude().isRegexBased());
            buildContainer(
        assertEquals("###", t.format());
        );
        TermsAggregationBuilder withRegexExclude = (TermsAggregationBuilder) converter.fromProto(
import org.opensearch.protobufs.TermsAggregationCollectMode;
                    .build()
                            .setPartition(TermsPartition.newBuilder().setPartition(0).setNumPartitions(5).build())
        assertNotNull(termsBuilder.script());
            )
                            .build()
        assertEquals("doc['status'].value", termsBuilder.script().getIdOrCode());
                    .setField("f")
import org.opensearch.protobufs.TermsPartition;
    }
        assertTrue(withPartition.includeExclude().isPartitionBased());
        assertEquals(BucketOrder.key(true), keyAsc.order());
            "t",
                    .build()
                    .setField("f")
                .setFormat("###")
        );
            buildContainer(
        assertEquals(BucketOrder.compound(BucketOrder.count(false)), countDesc.order());
        assertEquals(50, t.size());
        assertNotNull(withExclude.includeExclude());
import org.opensearch.test.OpenSearchTestCase;
                .setShowTermDocCountError(true)
        TermsAggregationBuilder keyAsc = (TermsAggregationBuilder) converter.fromProto(
import org.opensearch.protobufs.AggregationContainer;
                .setCollectMode(TermsAggregationCollectMode.TERMS_AGGREGATION_COLLECT_MODE_BREADTH_FIRST)
    public void testBasicFieldOnly() {
            TermsAggregationFields.newBuilder().setField("status").setMissing(FieldValue.newBuilder().setString("unknown").build()).build()
 */
    }
                    .build()
        TermsAggregationBuilder termsBuilder = (TermsAggregationBuilder) converter.fromProto("t", container);
                    .setField("f")
    }
            "t",
    public void setUp() throws Exception {
import org.opensearch.protobufs.TermsInclude;
    public void testScriptOnly() {
        assertNotNull(withRegexInclude.includeExclude());
import org.opensearch.protobufs.SortOrder;
    public void testContainerWithoutTermsAggregation() {
    public void testAllFieldsCombined() {
                TermsAggregationFields.newBuilder().setField("f").setExclude(TermsExclude.newBuilder().setRegexp("bar.*").build()).build()
        TermsAggregationBuilder builder = (TermsAggregationBuilder) converter.fromProto("by_status", container);
        // sub-aggregation path
            )
            buildContainer(
    private static AggregationContainer buildContainer(TermsAggregationFields fields) {
import org.opensearch.search.aggregations.AggregationBuilder;
        TermsAggregationBuilder withExclude = (TermsAggregationBuilder) converter.fromProto(
import org.opensearch.protobufs.TermsAggregationExecutionHint;
                .build()
    private TermsAggregationBuilderConverter converter;
        return AggregationContainer.newBuilder().setTermsAggregation(TermsAggregation.newBuilder().setTerms(fields).build()).build();
        );
                TermsAggregationFields.newBuilder().setField("f").setInclude(TermsInclude.newBuilder().setRegexp("foo.*").build()).build()
                    )
public class TermsAggregationBuilderConverterTests extends OpenSearchTestCase {
        // _count desc
        assertEquals(AggregationContainer.AggregationContainerCase.TERMS_AGGREGATION, converter.getHandledAggregationCase());
}
        expectThrows(IllegalStateException.class, () -> converter.fromProto("t", container));
                    .build()
            )
                    )
        );
        );
        assertEquals("category", t.field());
            "t",
        // include by partition
        AggregationContainer container = buildContainer(
            "t",
                TermsAggregationFields.newBuilder()
                    .setExclude(TermsExclude.newBuilder().setRegexp("bar.*").build())
                TermsAggregationFields.newBuilder()
        assertNotNull(withInclude.includeExclude());
        AggregationContainer container = AggregationContainer.newBuilder()
                        TermsInclude.newBuilder()
        TermsAggregationBuilder t = (TermsAggregationBuilder) converter.fromProto("full_terms", container);
            )
import org.opensearch.protobufs.TermsExclude;
        expectThrows(IllegalArgumentException.class, () -> converter.fromProto("t", container));
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                .setShardMinDocCount(3)
import org.opensearch.protobufs.Script;
                        TermsExclude.newBuilder().setTerms(StringArray.newBuilder().addStringArray("x").addStringArray("y").build()).build()
        super.setUp();
        TermsAggregationBuilder withInclude = (TermsAggregationBuilder) converter.fromProto(
 */
    }
