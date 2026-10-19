        for (int i = 0; i < 1023; i++) {
            long seq = between(0, 5000);
        });
import java.util.stream.Collectors;
            boolean existed = normalSet.add(seq) == false;
 * Modifications Copyright OpenSearch Contributors. See
        long currentSeq = between(10_000_000, 1_000_000_000);
 *
        final MultiSnapshot.SeqNoSet bitSet = new MultiSnapshot.SeqNoSet();
    }
        for (long i = 0; i < iterations; i++) {
                boolean existed = normalSet.add(seq) == false;
        final MultiSnapshot.SeqNoSet bitSet = new MultiSnapshot.SeqNoSet();  
    }
        final Set<Long> normalSet = new HashSet<>();
import java.util.stream.LongStream;  
/*  
 */  
            batch.forEach(seq -> {  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
        final MultiSnapshot.SeqNoSet bitSet = new MultiSnapshot.SeqNoSet();
import java.util.List;
                assertThat("SeqNoSet != Set", bitSet.getAndSet(seq), equalTo(existed));
/*
        final MultiSnapshot.SeqNoSet bitSet = new MultiSnapshot.SeqNoSet();
            assertThat("SeqNoSet != Set", bitSet.getAndSet(seq), equalTo(existed));
        final List<Long> values = LongStream.range(0, 1024).boxed().collect(Collectors.toList());
public class MultiSnapshotTests extends OpenSearchTestCase {
import java.util.stream.IntStream;
            long seq = between(i * 10_000, i * 30_000);
            assertThat(bitSet.getAndSet(values.get(i)), equalTo(false));
 * GitHub history for details.
import java.util.Set;  
        assertThat(bitSet.getAndSet(between(0, 1023)), equalTo(true));
 * compatible open source license.
    public void testTrackSeqNoDenseRanges() throws Exception {  
 * license agreements. See the NOTICE file distributed with
        assertThat(bitSet.getAndSet(between(1024, Integer.MAX_VALUE)), equalTo(false));  
import static org.hamcrest.CoreMatchers.equalTo;
}  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
            int batchSize = between(1, 1500);
 * KIND, either express or implied.  See the License for the
    public void testTrackSeqNoSimpleRange() throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
        }
 * software distributed under the License is distributed on an
            Randomness.shuffle(batch);
        final int iterations = scaledRandomIntBetween(100, 2000);  
        assertThat(bitSet.getAndSet(values.get(1023)), equalTo(false));
 */
 * this work for additional information regarding copyright
        final Set<Long> normalSet = new HashSet<>();
 * this file be licensed under the Apache-2.0 license or a
        IntStream.range(0, scaledRandomIntBetween(5_000, 10_000)).forEach(i -> {  
 */  
            currentSeq -= batchSize;  
        final Set<Long> normalSet = new HashSet<>();  
 *
    public void testTrackSeqNoMimicTranslogRanges() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashSet;
 * You may obtain a copy of the License at  
            assertThat("SeqNoSet != Set" + seq, bitSet.getAndSet(seq), equalTo(existed));  
        }  
import org.opensearch.test.OpenSearchTestCase;
            });  
    public void testTrackSeqNoSparseRanges() throws Exception {
/*  
    }  
 * The OpenSearch Contributors require contributions made to  
        Randomness.shuffle(values);  
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 * not use this file except in compliance with the License.
            boolean existed = normalSet.add(seq) == false;  
import org.opensearch.common.Randomness;
 * the Apache License, Version 2.0 (the "License"); you may
        IntStream.range(0, scaledRandomIntBetween(5_000, 10_000)).forEach(i -> {
            List<Long> batch = LongStream.range(currentSeq, currentSeq + batchSize).boxed().collect(Collectors.toList());
package org.opensearch.index.translog;
        });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
