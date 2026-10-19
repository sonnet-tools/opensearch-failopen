    private TookTimePolicy<BytesReference> getTookTimePolicy(TimeValue threshold) {  
            numChecksRun.incrementAndGet();  
        return out.bytes();  
        Function<BytesReference, CachedQueryResult.PolicyValues> dummyTransformationFunction = (data) -> {
        return new TookTimePolicy<>(
                return CachedQueryResult.getPolicyValues(data);
        assertTrue(longResult);
    public void testTookTimePolicy() throws Exception {  
        longResult = disabledPolicy.test(longTime);
            clusterSettings,
            }
            return CachedQueryResult.getPolicyValues(data);  
        // serializing a CachedQueryResult.
            TimeValue.ZERO,
package org.opensearch.cache.common.policy;
        Settings settings = Settings.EMPTY;
        BytesReference longTime = getValidPolicyInput(longMillis * 1000000);  
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.search.ScoreDoc;
    private final Function<BytesReference, CachedQueryResult.PolicyValues> transformationFunction = (data) -> {
import org.junit.Before;  
    public void testZeroThresholdSkipsCheck() throws Exception {  
        boolean longResult = tookTimePolicy.test(longTime);
    private QuerySearchResult getQSR() {  
        TookTimePolicy<BytesReference> policy = new TookTimePolicy<>(
    }
        } catch (IOException e) {
 *
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.cache.common.tier.TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP;
        boolean shortResult = tookTimePolicy.test(shortTime);
 * The OpenSearch Contributors require contributions made to  
        long shortMillis = (long) (0.9 * threshMillis);
import java.io.IOException;
 * compatible open source license.
        AtomicInteger numChecksRun = new AtomicInteger();
        TookTimePolicy<BytesReference> disabledPolicy = getTookTimePolicy(TimeValue.ZERO);
            try {
        double threshMillis = 10;
import org.apache.lucene.search.TotalHits;  
import org.opensearch.common.io.stream.BytesStreamOutput;  
import org.opensearch.search.query.QuerySearchResult;
    private BytesReference getValidPolicyInput(Long tookTimeNanos) throws IOException {  
        CachedQueryResult cachedQueryResult = new CachedQueryResult(getQSR(), tookTimeNanos);  
    }  
        long longMillis = (long) (1.5 * threshMillis);  
        // We can't mock the QSR with mockito because the class is final. Construct a real one
import org.opensearch.common.unit.TimeValue;
            clusterSettings,
    @Before
import java.util.function.Function;
    };
        clusterSettings = new ClusterSettings(settings, new HashSet<>());
import org.opensearch.common.cache.policy.CachedQueryResult;
            new TopDocsAndMaxScore(  
        assertTrue(policy.test(minusOne));
        // When it's used in the cache, the policy will receive BytesReferences which come from
import org.opensearch.common.settings.Settings;  
            ),  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
            } catch (IOException e) {  
            threshold,
 * this file be licensed under the Apache-2.0 license or a
            TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
        return mockQSR;  
public class TookTimePolicyTests extends OpenSearchTestCase {  
        };  
    }
        cachedQueryResult.writeToNoId(out);
 */  
    }
        );  
        mockQSR.topDocs(
}
                throw new RuntimeException(e);
        assertTrue(longResult);
        clusterSettings.registerSetting(TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE));  
        // duplicated from DfsQueryPhaseTests.java
import org.apache.lucene.search.TopDocs;
        shortResult = disabledPolicy.test(shortTime);
import java.util.concurrent.atomic.AtomicInteger;
        assertEquals(0, numChecksRun.get());  
import java.util.HashSet;  
    private ClusterSettings clusterSettings;  
/*  
    }
    }
            throw new RuntimeException(e);
        assertFalse(shortResult);  
        QuerySearchResult mockQSR = new QuerySearchResult();
    public void testInvalidThreshold() throws Exception {
import org.opensearch.common.cache.CacheType;
            new DocValueFormat[0]
        try {
        BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.common.settings.ClusterSettings;
        }  
import org.opensearch.search.DocValueFormat;  
        assertTrue(shortResult);  
            transformationFunction,  
        BytesReference minusOne = getValidPolicyInput(-1L);
    }
        );
        BytesReference shortTime = getValidPolicyInput(shortMillis * 1000000);
        TookTimePolicy<BytesReference> tookTimePolicy = getTookTimePolicy(new TimeValue((long) threshMillis));
            TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
    public void setup() {  
        );  
        assertThrows(IllegalArgumentException.class, () -> getTookTimePolicy(TimeValue.MINUS_ONE));  
            dummyTransformationFunction,  
                2.0F
import org.opensearch.core.common.bytes.BytesReference;
                new TopDocs(new TotalHits(1, TotalHits.Relation.EQUAL_TO), new ScoreDoc[] { new ScoreDoc(42, 1.0F) }),
