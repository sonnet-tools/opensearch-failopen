                            randomUnsignedLong(),  
                            randomNonNegativeLong(),
                    );
                order,  
                    throw new AssertionError("Illegal randomisation branch");
                    break;
        InternalAggregations aggregations,  
public class UnsignedLongTermsTests extends InternalTermsTestCase {  
    @Override
 * compatible open source license.
                    break;
            int requiredSize = instance.requiredSize;
        DocValueFormat format = randomNumericDocValueFormat();
                case 7:
import java.util.Map;  
                            InternalAggregations.EMPTY,
            order,
import java.util.HashMap;  
        );
                    minDocCount += between(1, 100);  
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {  
        return new UnsignedLongTerms(
                    requiredSize += between(1, 100);  
            switch (between(0, 8)) {
            format,
            showTermDocCountError,  
            long minDocCount = longTerms.minDocCount;
        }
                    } else {
                    if (metadata == null) {  
        if (instance instanceof UnsignedLongTerms) {  
                            format
            Map<String, Object> metadata = longTerms.getMetadata();  
        long otherDocCount = 0;  
                case 1:
import java.util.ArrayList;
            otherDocCount,
                case 4:
            boolean showTermDocCountError = longTerms.showTermDocCountError;
            }  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
                longTerms.reduceOrder,
                case 0:
                        metadata = new HashMap<>(instance.getMetadata());  
            int docCount = randomIntBetween(1, 100);  
                        metadata = new HashMap<>(instance.getMetadata());
            shardSize  
                    docCountError += between(1, 100);  
    protected InternalTerms<?, ?> createTestInstance(  
            String name = instance.getName();
                    name += randomAlphaOfLength(5);  
            BucketOrder order = longTerms.order;  
                    } else {  
                    break;
        int shardSize = requiredSize + 2;
    ) {  
            0,
            buckets,
        BucketOrder reduceOrder = rarely() ? order : BucketOrder.key(true);  
            BucketOrder order = instance.order;  
                    break;
            int shardSize = longTerms.getShardSize();
import java.util.HashSet;
                    shardSize += between(1, 100);  
    }  
                        metadata = new HashMap<>(1);
    @Override
        long docCountError
            DocValueFormat format = longTerms.format;  
                    name += randomAlphaOfLength(5);  
        BucketOrder order = BucketOrder.count(false);
                    break;  
                    break;
            return new UnmappedTerms(name, order, new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, 0), metadata);
            bucketCountThresholds
                        metadata = new HashMap<>(1);
            List<UnsignedLongTerms.Bucket> buckets = longTerms.getBuckets();
                new TermsAggregator.BucketCountThresholds(minDocCount, 0, requiredSize, shardSize)
                    metadata.put(randomAlphaOfLength(15), randomInt());  
    }
                    break;
                shardSize,  
import org.opensearch.search.aggregations.BucketOrder;
                format,
import java.math.BigInteger;  
                case 6:
import org.opensearch.search.DocValueFormat;
        }
 * SPDX-License-Identifier: Apache-2.0
            long minDocCount = instance.minDocCount;
            BigInteger term = randomValueOtherThanMany(l -> terms.add(l) == false, InternalTermsTestCase::randomUnsignedLong);
                default:
                case 2:
    protected InternalTerms<?, ?> mutateInstance(InternalTerms<?, ?> instance) {
            }
                case 8:  
        return ParsedUnsignedLongTerms.class;
        TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(
            docCountError,  
            );  
                otherDocCount,
            long otherDocCount = longTerms.getSumOfOtherDocCounts();  
                    break;
            buckets.add(new UnsignedLongTerms.Bucket(term, docCount, aggregations, showTermDocCountError, docCountError, format));
            minDocCount,  
        );
                    throw new AssertionError("Illegal randomisation branch");  
                default:
        Map<String, Object> metadata,
    @Override
 *
                    break;
                    otherDocCount += between(1, 100);  
                    if (metadata == null) {
            reduceOrder,
import java.util.Collections;
                    buckets.add(
}
                    break;
                showTermDocCountError,
        int requiredSize = 3;  
                case 3:
                        )  
            int requiredSize = longTerms.requiredSize;
                    showTermDocCountError = showTermDocCountError == false;  
        String name,
                case 0:
                case 1:
                    buckets = new ArrayList<>(buckets);  
            UnsignedLongTerms longTerms = (UnsignedLongTerms) instance;
                        new UnsignedLongTerms.Bucket(
                docCountError,
                case 3:
            requiredSize,
        long minDocCount = 1;
        } else {
                            showTermDocCountError,  
    }  
                    break;
import java.util.Set;
        Set<BigInteger> terms = new HashSet<>();  
import org.opensearch.search.aggregations.InternalAggregations;  
                    requiredSize += between(1, 100);  
package org.opensearch.search.aggregations.bucket.terms;
                    break;
import java.util.List;
 */  
                    minDocCount += between(1, 100);  
                            docCountError,
                name,
        final int numBuckets = randomNumberOfBuckets();
                    }
                    metadata.put(randomAlphaOfLength(15), randomInt());
                case 5:
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
            long docCountError = longTerms.getDocCountError();
            switch (between(0, 3)) {
            metadata,  
        boolean showTermDocCountError,
                case 2:
                metadata,
        Collections.sort(buckets, reduceOrder.comparator());
            shardSize,
            name,  
            String name = longTerms.getName();
            return new UnsignedLongTerms(  
                    }
            Map<String, Object> metadata = instance.getMetadata();  
        for (int i = 0; i < numBuckets; ++i) {
        List<UnsignedLongTerms.Bucket> buckets = new ArrayList<>();
                buckets,  
            Collections.sort(buckets, longTerms.reduceOrder.comparator());
                    break;
/*  
