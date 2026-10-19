    public void testResolveToCount() {
/*
    public void testResolveToAgg() {  
        );
 * SPDX-License-Identifier: Apache-2.0
        Object[] value = (Object[]) resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");
import org.opensearch.search.aggregations.metrics.InternalAvg;
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
    }
 */
import java.util.Collections;
        InvalidAggregationPathException e = expectThrows(
            "string_terms",
            new TermsAggregator.BucketCountThresholds(0, 0, 1, 1)  
        );
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);  
        AggregationPath path = AggregationPath.parse("string_terms['foo']>the_avg.value");
        List<LongTerms.Bucket> buckets = new ArrayList<>();
            IllegalArgumentException.class,
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));  
import org.apache.lucene.util.BytesRef;
            0,  
            new TermsAggregator.BucketCountThresholds(0, 0, 1, 1)
    public void testResolveToAggValue() {
        InvalidAggregationPathException e = expectThrows(  
        IllegalArgumentException e = expectThrows(  
        AggregationPath path = AggregationPath.parse("foo.value");  
        assertThat(value, equalTo(1));
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
import org.opensearch.test.OpenSearchTestCase;  
 * license agreements. See the NOTICE file distributed with
    public void testResolveToSpecificBucket() {
        assertThat(value[0], equalTo(2.0));
        assertThat(e.getMessage(), equalTo("path not supported for [the_avg]: [unknown]"));
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
        Object[] value = (Object[]) resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");
}  
        List<LongTerms.Bucket> buckets = new ArrayList<>();
        InternalAggregations internalStringAggs = InternalAggregations.from(Collections.singletonList(agg));
        AggregationPath path = AggregationPath.parse("string_terms['bar']>the_avg.value");  
        assertThat(value[0], equalTo(2.0));
        buckets.add(bucket);  
        assertThat(e.getMessage(), equalTo("Cannot find an aggregation named [foo] in [the_long_terms]"));  
 * Unless required by applicable law or agreed to in writing,
        Object[] value = (Object[]) resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");  
        LongTerms.Bucket bucket = new LongTerms.Bucket(19, 1, internalAggregations, false, 0, DocValueFormat.RAW);  
        InternalTerms termsAgg = new StringTerms(
        AggregationPath path = AggregationPath.parse("the_avg");
 *
        buckets.add(bucket);  
        );  
            Collections.emptyMap(),  
            BucketOrder.count(false),
        AggregationPath path = AggregationPath.parse("the_avg.value");
                new BytesRef("foo".getBytes(StandardCharsets.UTF_8), 0, "foo".getBytes(StandardCharsets.UTF_8).length),
    }  
        LongTerms.Bucket bucket = new LongTerms.Bucket(19, 1, internalAggregations, false, 0, DocValueFormat.RAW);
            () -> resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms")
        buckets.add(bucket);
                DocValueFormat.RAW
    }
        );
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
        Object value = resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testResolveToNothing() {
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(termsAgg));  
                1,
            false,
            InvalidAggregationPathException.class,  
        InternalAggregations internalStringAggs = InternalAggregations.from(Collections.singletonList(agg));  
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));  
    }
            BucketOrder.count(false),
 */  
 * specific language governing permissions and limitations
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());  
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
 * Modifications Copyright OpenSearch Contributors. See
            DocValueFormat.RAW,  
            stringBuckets,
            Collections.emptyMap(),
        AggregationPath path = AggregationPath.parse("_count");  
                DocValueFormat.RAW  
            "string_terms",  
import java.nio.charset.StandardCharsets;
            () -> resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms")
            0,
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
            InvalidAggregationPathException.class,
            )  
        List<LongTerms.Bucket> buckets = new ArrayList<>();
            stringBuckets,
public class InternalMultiBucketAggregationTests extends OpenSearchTestCase {
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());  
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;  
 * this work for additional information regarding copyright
        buckets.add(bucket);
        List<LongTerms.Bucket> buckets = new ArrayList<>();
        assertThat(value[0], equalTo(1L));  
import static org.hamcrest.Matchers.equalTo;
 *  
            )
 * not use this file except in compliance with the License.
    }
    }  
 * compatible open source license.
        List<LongTerms.Bucket> buckets = new ArrayList<>();  
        Object[] value = (Object[]) resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");  
        assertThat(value[0], equalTo(agg));
 *
        AggregationPath path = AggregationPath.parse("_key");
 * GitHub history for details.
import static org.opensearch.search.aggregations.InternalMultiBucketAggregation.resolvePropertyFromPath;
package org.opensearch.search.aggregations;
        List<LongTerms.Bucket> buckets = new ArrayList<>();
import java.util.List;
        );
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
import java.util.ArrayList;  
    }
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);  
        AggregationPath path = AggregationPath.parse("the_avg.unknown");
                false,
        AggregationPath path = AggregationPath.parse("_bucket_count");
    }
            0,
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);
            1,
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        buckets.add(bucket);
                1,
        Object[] value = (Object[]) resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");
        List<LongTerms.Bucket> buckets = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;  
                0,
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
        buckets.add(bucket);
        LongTerms.Bucket bucket = new LongTerms.Bucket(19, 1, internalAggregations, false, 0, DocValueFormat.RAW);  
        List<StringTerms.Bucket> stringBuckets = Collections.singletonList(
 * You may obtain a copy of the License at  
                internalStringAggs,
    public void testResolveToMissingSpecificBucket() {
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
                new BytesRef("foo".getBytes(StandardCharsets.UTF_8), 0, "foo".getBytes(StandardCharsets.UTF_8).length),  
 * ownership. Elasticsearch licenses this file to you under  
    public void testResolveToUnknown() {  
            DocValueFormat.RAW,
            0,  
        assertThat(e.getMessage(), equalTo("Cannot find an key ['bar'] in [string_terms]"));
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(termsAgg));
 * Licensed to Elasticsearch under one or more contributor  
                0,
            1,
/*  
        assertThat(value[0], equalTo(19L));
        );
    public void testResolveToBucketCount() {
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
        buckets.add(bucket);
 * under the License.  
    public void testResolveToKey() {  
        buckets.add(bucket);
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());  
import org.opensearch.search.DocValueFormat;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
        List<StringTerms.Bucket> stringBuckets = Collections.singletonList(
        InternalTerms termsAgg = new StringTerms(
            new StringTerms.Bucket(  
            new StringTerms.Bucket(
/*  
        List<LongTerms.Bucket> buckets = new ArrayList<>();
        buckets.add(bucket);
                internalStringAggs,  
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);
            false,  
    }  
        List<LongTerms.Bucket> buckets = new ArrayList<>();  
            BucketOrder.count(false),
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.support.AggregationPath;
                false,  
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);
            BucketOrder.count(false),  
            () -> resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms")
 */  
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());  
