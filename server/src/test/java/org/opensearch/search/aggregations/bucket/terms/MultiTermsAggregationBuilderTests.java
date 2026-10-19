import org.opensearch.search.aggregations.Aggregator;
                factory.order(order);
 * compatible open source license.
        String field = randomAlphaOfLength(10);
import java.time.ZoneId;
    protected static MultiTermsValuesSourceConfig.Builder randomFieldOrScript(MultiTermsValuesSourceConfig.Builder builder, String field) {
                int numOrders = randomIntBetween(1, 3);
        ).build();
            factory.minDocCount(minDocCount);  
        int choice = randomInt(1);  
                throw new AssertionError("Unknown random operation [" + choice + "]");  
                break;
        exception = expectThrows(IllegalArgumentException.class, () -> { new MultiTermsAggregationBuilder("_name").terms(null); });
    }  
        return orders;  
            factory.shardMinDocCount(shardMinDocCount);
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
        formats.add(() -> DocValueFormat.RAW);
                case 4:
        if (randomBoolean()) {
                case 3:  
                break;
            }
     * @return a random {@link DocValueFormat} that can be used in aggregations which  
            List<BucketOrder> order = randomOrder();
                break;
    /**
                    shardMinDocCount = randomIntBetween(0, Integer.MAX_VALUE);
        factory.terms(fieldConfigs);
        }
        }
            new MultiTermsAggregationBuilder("_name").terms(Collections.singletonList(randomFieldConfig()));
                case 0:
            case 2:  
                    break;  
        }
import org.opensearch.search.aggregations.BaseAggregationTestCase;  
            factory.size(randomIntBetween(1, Integer.MAX_VALUE));
            "multi term aggregation must has at least 2 terms. Found [1] in [_name] Use terms aggregation for single term aggregation",
            case 3:  
 */  
                case 1:
                    break;
        if (randomBoolean()) {
                orders.add(BucketOrder.count(randomBoolean()));
        );  
                    orders.addAll(randomOrder());  
                    fail();
                    fail();
                .setTimeZone(timeZone)
                break;
                case 4:  
                case 2:
                    break;  
    protected MultiTermsAggregationBuilder createTestAggregatorBuilder() {
}  
            factory.showTermDocCountError(randomBoolean());  
                case 3:
        }
        );
        formats.add(() -> new DocValueFormat.Decimal(randomFrom("###.##", "###,###.##")));  
    }
        });
    }  
import java.util.List;
    }
            field
        List<BucketOrder> orders = new ArrayList<>();
import java.util.function.Supplier;  
        if (randomBoolean()) {
                builder.setScript(mockScript("doc[" + field + "] + 1"));  
                default:  
                    break;
            : null;  
        return builder;
 * SPDX-License-Identifier: Apache-2.0
        if (randomBoolean()) {  
        switch (choice) {
        }
            case 0:  
public class MultiTermsAggregationBuilderTests extends BaseAggregationTestCase<MultiTermsAggregationBuilder> {
                }
            ? randomFrom(ValueType.STRING, ValueType.LONG, ValueType.DOUBLE, ValueType.DATE, ValueType.IP)
                break;
        ValueType userValueTypeHint = randomBoolean()
        int termsCount = randomIntBetween(2, 10);  
        return randomFieldOrScript(
                    minDocCount = randomIntBetween(0, Integer.MAX_VALUE);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {  
        String format = randomBoolean() ? randomNumericDocValueFormat().toString() : null;
            factory.collectMode(randomFrom(Aggregator.SubAggCollectionMode.values()));
            default:  
        if (randomBoolean()) {
     * compute numbers.
        return randomFrom(formats).get();
    }
import org.opensearch.search.DocValueFormat;
        }  
            int minDocCount = randomInt(4);
import java.util.Collections;
    public void testInvalidTermsParams() {
    }  
        assertEquals("multi term aggregation must has at least 2 terms. Found [0] in [_name]", exception.getMessage());  
            exception.getMessage()
                break;
 *
    private List<BucketOrder> randomOrder() {  
        switch (randomInt(4)) {
            case 1:  
        for (int i = 0; i < termsCount; i++) {
        Object missing = randomBoolean() ? randomAlphaOfLength(10) : null;
    protected static MultiTermsValuesSourceConfig randomFieldConfig() {  
        assertEquals(  
                orders.add(BucketOrder.aggregation(randomAlphaOfLengthBetween(3, 20), randomBoolean()));
            } else {
            fieldConfigs.add(randomFieldConfig());  
    protected static DocValueFormat randomNumericDocValueFormat() {  
        }  
import org.opensearch.search.aggregations.support.ValueType;  
            IllegalArgumentException.class,  
        ZoneId timeZone = randomBoolean() ? randomZone() : null;  
                .setFormat(format),  
            () -> { new MultiTermsAggregationBuilder("_name").terms(Collections.emptyList()); }
                break;
        exception = expectThrows(
                default:
            factory.shardSize(randomIntBetween(1, Integer.MAX_VALUE));
            case 0:
import java.util.ArrayList;  
    @Override
            }  
        assertEquals("[terms] must not be null. Found null terms in [_name]", exception.getMessage());  
 * The OpenSearch Contributors require contributions made to  
        }
                for (int i = 0; i < numOrders; i++) {
                orders.add(BucketOrder.aggregation(randomAlphaOfLengthBetween(3, 20), randomAlphaOfLengthBetween(3, 20), randomBoolean()));
        List<MultiTermsValuesSourceConfig> fieldConfigs = new ArrayList<>();
        MultiTermsAggregationBuilder factory = new MultiTermsAggregationBuilder(name);
        if (randomBoolean()) {  
                case 2:
        final List<Supplier<DocValueFormat>> formats = new ArrayList<>(3);
            switch (minDocCount) {  
     */
            default:
                case 1:  
            case 1:
                .setUserValueTypeHint(userValueTypeHint)
                fail();
        String name = randomAlphaOfLengthBetween(3, 20);  
        }
        }
                case 0:
            int shardMinDocCount = randomInt(4);  
            new MultiTermsValuesSourceConfig.Builder().setMissing(missing)  
                orders.add(BucketOrder.key(randomBoolean()));
import org.opensearch.search.aggregations.BucketOrder;
            case 4:  
            }  
                builder.setFieldName(field);  
            switch (shardMinDocCount) {
                factory.order(order.get(0));  
package org.opensearch.search.aggregations.bucket.terms;
        if (randomBoolean()) {
 * this file be licensed under the Apache-2.0 license or a
        return factory;
            if (order.size() == 1 && randomBoolean()) {
/*  
