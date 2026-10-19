            order,
            docCountError,
import org.opensearch.search.DocValueFormat;  
    private Object value(ValuesSourceType type) {
    /**
import java.util.List;  
        // mimic per-shard bucket sort operation, which is required by bucket reduce phase.  
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {  
        long docCountError
        );
        BucketOrder reduceOrder = rarely() ? order : BucketOrder.key(true);
                CoreValuesSourceType.IP,  
public class InternalMultiTermsTests extends InternalTermsTestCase {  
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(
    }
        }  
/*  
        List<InternalMultiTerms.Bucket> buckets = new ArrayList<>();
                )
 * this file be licensed under the Apache-2.0 license or a
        long minDocCount = 1;
import org.apache.lucene.document.InetAddressPoint;
        return Collections.unmodifiableList(
            buckets.add(  
            shardSize  
    @Override
            return new BytesRef(InetAddressPoint.encode(randomIp(randomBoolean())));
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to  
    }
            bucketCountThresholds
            reduceOrder,
            otherDocCount,  
import java.util.Map;
                CoreValuesSourceType.BYTES,
            return new BytesRef(randomAlphaOfLength(10));  
        InternalAggregations aggregations,
            asList(  
import org.opensearch.search.aggregations.BucketOrder;
                CoreValuesSourceType.NUMERIC,
    @Override
        Collections.sort(buckets, reduceOrder.comparator());
        );
            return randomBoolean();
 *
            shardSize,
     * terms count and type should consistent across entire test.  
            showTermDocCountError,
                    docCountError,  
import org.opensearch.search.aggregations.support.ValuesSourceType;
        Map<String, Object> metadata,
        for (int i = 0; i < numBuckets; i++) {
                    showTermDocCountError,
        } else if (CoreValuesSourceType.DATE.equals(type)) {
    private static List<ValuesSourceType> getSupportedValuesSourceTypes() {
        } else if (CoreValuesSourceType.BOOLEAN.equals(type)) {  
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;  
        BucketOrder order = BucketOrder.count(false);  
            );  
    private final List<ValuesSourceType> types = getSupportedValuesSourceTypes();
        String name,  
                CoreValuesSourceType.BOOLEAN
        List<DocValueFormat> formats = types.stream().map(type -> type.getFormatter(null, null)).collect(Collectors.toList());  
package org.opensearch.search.aggregations.bucket.terms;
import java.util.stream.Collectors;
    protected InternalTerms<?, ?> createTestInstance(
            buckets,  
            return randomInt();  
            name,  
                    types.stream().map(this::value).collect(Collectors.toList()),
    ) {
 * compatible open source license.
        if (CoreValuesSourceType.NUMERIC.equals(type)) {
import org.opensearch.search.aggregations.InternalAggregations;
                    minDocCount,  
            0,
        boolean showTermDocCountError,  
            metadata,  
import org.apache.lucene.util.BytesRef;
            formats,
import java.util.Collections;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        final int numBuckets = randomNumberOfBuckets();  
        return new InternalMultiTerms(
 */  
 * SPDX-License-Identifier: Apache-2.0
        }
        long otherDocCount = 0;
        int shardSize = requiredSize + 2;  
                CoreValuesSourceType.DATE,
        return ParsedMultiTerms.class;
     */
            minDocCount,  
        throw new IllegalArgumentException("unexpected type [" + type.typeName() + "]");
                    formats
}  
            )  
import static java.util.Arrays.asList;
    }
                    aggregations,
            requiredSize,
        } else if (CoreValuesSourceType.BYTES.equals(type)) {
        int requiredSize = 3;
                new InternalMultiTerms.Bucket(
    }  
            return randomNonNegativeLong();
        } else if (CoreValuesSourceType.IP.equals(type)) {
        );
