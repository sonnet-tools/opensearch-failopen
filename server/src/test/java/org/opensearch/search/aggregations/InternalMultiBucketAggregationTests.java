import org.opensearch.search.aggregations.support.AggregationPath;
                1,
    public void testResolveToAggValue() {
        buckets.add(bucket);
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(e.getMessage(), equalTo("Cannot find an key ['bar'] in [string_terms]"));
        );
    public void testResolveToBucketCount() {
            InvalidAggregationPathException.class,
                false,
            false,
        List<LongTerms.Bucket> buckets = new ArrayList<>();
 * Unless required by applicable law or agreed to in writing,
/*
        List<LongTerms.Bucket> buckets = new ArrayList<>();
        assertThat(e.getMessage(), equalTo("Cannot find an aggregation named [foo] in [the_long_terms]"));
        List<LongTerms.Bucket> buckets = new ArrayList<>();
            BucketOrder.count(false),
        InvalidAggregationPathException e = expectThrows(
 * not use this file except in compliance with the License.
}
        assertThat(value, equalTo(1));
    }
            0,
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
        InternalTerms termsAgg = new StringTerms(
        InternalTerms termsAgg = new StringTerms(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            DocValueFormat.RAW,
    }
        buckets.add(bucket);
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);
                DocValueFormat.RAW
        );
public class InternalMultiBucketAggregationTests extends OpenSearchTestCase {
        buckets.add(bucket);
            () -> resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms")
        buckets.add(bucket);
 * specific language governing permissions and limitations
        assertThat(value[0], equalTo(19L));
        );
            Collections.emptyMap(),
package org.opensearch.search.aggregations;
            BucketOrder.count(false),
        List<LongTerms.Bucket> buckets = new ArrayList<>();
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(termsAgg));
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
            IllegalArgumentException.class,
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(termsAgg));
 * Licensed to Elasticsearch under one or more contributor
        List<LongTerms.Bucket> buckets = new ArrayList<>();
        List<LongTerms.Bucket> buckets = new ArrayList<>();
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
        buckets.add(bucket);
            )
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
        List<StringTerms.Bucket> stringBuckets = Collections.singletonList(
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);
                0,
import org.opensearch.search.DocValueFormat;
 * SPDX-License-Identifier: Apache-2.0
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
            BucketOrder.count(false),
/*
                new BytesRef("foo".getBytes(StandardCharsets.UTF_8), 0, "foo".getBytes(StandardCharsets.UTF_8).length),
        List<StringTerms.Bucket> stringBuckets = Collections.singletonList(
        assertThat(value[0], equalTo(2.0));
            "string_terms",
 * The OpenSearch Contributors require contributions made to
            new TermsAggregator.BucketCountThresholds(0, 0, 1, 1)
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
    public void testResolveToCount() {
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
            InvalidAggregationPathException.class,
                new BytesRef("foo".getBytes(StandardCharsets.UTF_8), 0, "foo".getBytes(StandardCharsets.UTF_8).length),
    public void testResolveToKey() {
        );
    }
        AggregationPath path = AggregationPath.parse("the_avg.value");
 * compatible open source license.
        List<LongTerms.Bucket> buckets = new ArrayList<>();
    }
        LongTerms.Bucket bucket = new LongTerms.Bucket(19, 1, internalAggregations, false, 0, DocValueFormat.RAW);
                false,
            () -> resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms")
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
import static org.opensearch.search.aggregations.InternalMultiBucketAggregation.resolvePropertyFromPath;
            DocValueFormat.RAW,
 */
        List<LongTerms.Bucket> buckets = new ArrayList<>();
            Collections.emptyMap(),
            0,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
        AggregationPath path = AggregationPath.parse("_bucket_count");
    public void testResolveToMissingSpecificBucket() {
                0,
        buckets.add(bucket);
            BucketOrder.count(false),
        assertThat(value[0], equalTo(2.0));
 */
import java.util.List;
    }
            1,
            )
import java.util.Collections;
    public void testResolveToUnknown() {
            stringBuckets,
 * ownership. Elasticsearch licenses this file to you under
            new StringTerms.Bucket(
        InvalidAggregationPathException e = expectThrows(
        buckets.add(bucket);
        assertThat(value[0], equalTo(agg));
/*
        LongTerms.Bucket bucket = new LongTerms.Bucket(19, 1, internalAggregations, false, 0, DocValueFormat.RAW);
        );
import java.util.ArrayList;
        AggregationPath path = AggregationPath.parse("the_avg");
                DocValueFormat.RAW
        Object value = resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");
        AggregationPath path = AggregationPath.parse("string_terms['foo']>the_avg.value");
        Object[] value = (Object[]) resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");
            () -> resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms")
    public void testResolveToNothing() {
        AggregationPath path = AggregationPath.parse("_key");
    }
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
import org.opensearch.search.aggregations.metrics.InternalAvg;
                1,
 *
        Object[] value = (Object[]) resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");
import static org.hamcrest.Matchers.equalTo;
 * this work for additional information regarding copyright
            stringBuckets,
        InternalAggregations internalStringAggs = InternalAggregations.from(Collections.singletonList(agg));
            new StringTerms.Bucket(
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
        );
        buckets.add(bucket);
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.util.BytesRef;
            1,
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);
            0,
import java.nio.charset.StandardCharsets;
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);
    public void testResolveToAgg() {
        Object[] value = (Object[]) resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");
        Object[] value = (Object[]) resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");
 * GitHub history for details.
                internalStringAggs,
        IllegalArgumentException e = expectThrows(
 * You may obtain a copy of the License at
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
    }
        );
 * the Apache License, Version 2.0 (the "License"); you may
        List<LongTerms.Bucket> buckets = new ArrayList<>();
        InternalAggregations internalStringAggs = InternalAggregations.from(Collections.singletonList(agg));
 */
 *
        LongTerms.Bucket bucket = new LongTerms.Bucket(19, 1, internalAggregations, false, 0, DocValueFormat.RAW);
        LongTerms.Bucket bucket = new LongTerms.Bucket(1, 1, internalAggregations, false, 0, DocValueFormat.RAW);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
            "string_terms",
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
 * license agreements. See the NOTICE file distributed with
        AggregationPath path = AggregationPath.parse("_count");
        assertThat(value[0], equalTo(1L));
        Object[] value = (Object[]) resolvePropertyFromPath(path.getPathElementsAsStringList(), buckets, "the_long_terms");
 *
    public void testResolveToSpecificBucket() {
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
        InternalAggregation agg = new InternalAvg("the_avg", 2, 1, DocValueFormat.RAW, Collections.emptyMap());
    }
        InternalAggregations internalAggregations = InternalAggregations.from(Collections.singletonList(agg));
 * software distributed under the License is distributed on an
            false,
        buckets.add(bucket);
            0,
        AggregationPath path = AggregationPath.parse("foo.value");
            new TermsAggregator.BucketCountThresholds(0, 0, 1, 1)
import org.opensearch.test.OpenSearchTestCase;
    }
        assertThat(e.getMessage(), equalTo("path not supported for [the_avg]: [unknown]"));
                internalStringAggs,
        AggregationPath path = AggregationPath.parse("the_avg.unknown");
 * under the License.
        AggregationPath path = AggregationPath.parse("string_terms['bar']>the_avg.value");
