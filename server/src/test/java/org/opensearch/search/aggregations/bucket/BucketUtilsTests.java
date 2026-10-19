                }
        }
        Random r = new Random(0);
 * the Apache License, Version 2.0 (the "License"); you may
                    return termIds[i] - termIds[j];
            final int shardSize = BucketUtils.suggestShardSideQueueSize(size);
            }
        for (int rank = 1; len < totalNumberOfTerms; ++rank) {
            numErrors += Math.abs(computedTopFreqs[i] - actualTopFreqs[i]);  
                freqs[d]++;
            }
            len += freq;
/*  
    }  
                @Override  
        int numErrors = 0;  
        System.out.println("Computed freqs of top terms: " + Arrays.toString(computedTopFreqs));
            int tmp = terms[i];
        final int[] actualTopFreqs = new int[size];  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        for (int[] freqs : topShards) {
    }
                    int tmp = termIds[i];
        final int totalNumberOfTerms = 1000000;
}
/*
        for (int iter = 0; iter < 10; ++iter) {
        // distribute into shards like routing would  
            for (int i = 0; i < maxTerm; ++i) {
            for (int d : data) {
 * software distributed under the License is distributed on an
            totalFreq += actualTopFreqs[i];
 *
    // heuristic
        }
                    tmp = freqs[i];
        for (int iter = 0; iter < 10; ++iter) {  
import org.opensearch.test.OpenSearchTestCase;
            final int shardSize = BucketUtils.suggestShardSideQueueSize(size);  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        System.out.println("Number of unique terms: " + maxTerm);  
 * The OpenSearch Contributors require contributions made to  
        final int size = 100;
        System.out.println("Global freqs of top terms: " + Arrays.toString(actualTopFreqs));
            freq = Math.max(freq, 1);  
    /*// You may use the code below to evaluate the impact of the BucketUtils.suggestShardSideQueueSize
                @Override
                }  
                    termIds[i] = termIds[j];
            assertThat(shardSize, greaterThanOrEqualTo(shardSize));
            int freq = (int) (weight(rank, skew) / totalWeight * totalNumberOfTerms);
                protected void swap(int i, int j) {  
    public void testOverFlow() {  
            new InPlaceMergeSorter() {
            Arrays.fill(freqs, shardSize, freqs.length, 0);
                    return freqs[j] - freqs[i];
                    freqs[j] = tmp;
    public static void main(String[] args) {  
            int[] termIds = new int[maxTerm];
                    termIds[i] = termIds[j];
            }.sort(0, maxTerm);  
                @Override
        }
                protected int compare(int i, int j) {  
    }*/
 *  
        for (int i = terms.length - 1; i > 0; --i) {  
            Arrays.fill(terms, len, Math.min(len + freq, totalNumberOfTerms), rank - 1);
 * compatible open source license.
                actualTopFreqs[rank-1] = freq;
        final int[][] topShards = new int[numberOfShards][];
 * GitHub history for details.
                    freqs[i] = freqs[j];
        int[] terms = new int[totalNumberOfTerms];  
            }.sort(0, maxTerm);
            assertThat(shardSize, greaterThanOrEqualTo(size));  
                    freqs[i] = freqs[j];
 */  
                    termIds[j] = tmp;  
    }
 */  
        System.out.println("Number of errors: " + numErrors + "/" + totalFreq);  
            upTo += shards[i].length;
                @Override
            topShards[shard] = freqs;  
        // shuffle terms
 *
        for (int i = 0; i < size; ++i) {
 * license agreements. See the NOTICE file distributed with
public class BucketUtilsTests extends OpenSearchTestCase {
        assertEquals(e.getMessage(), "size must be positive, got 0");  
 * SPDX-License-Identifier: Apache-2.0
                    freqs[j] = tmp;  
        }  
        }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> BucketUtils.suggestShardSideQueueSize(0));
                }
    private static double weight(int rank, double skew) {  
                protected int compare(int i, int j) {
        }
package org.opensearch.search.aggregations.bucket;
/*  
        for (int rank = 1; rank <= numberOfUniqueTerms; ++rank) {
 * Unless required by applicable law or agreed to in writing,
            for (int i = 0; i < size; ++i) {
        final int[] computedTopFreqs = new int[size];  
            if (rank <= size) {  
    }
                    termIds[j] = tmp;
    public void testBadInput() {
        double totalWeight = 0;
 * this work for additional information regarding copyright
        for (int shard = 0; shard < numberOfShards; ++shard) {
 * not use this file except in compliance with the License.
                termIds[i] = i;  
            totalWeight += weight(rank, skew);  
            final int[] freqs = new int[maxTerm];  
                    int tmp = termIds[i];  
            final int size = randomIntBetween(1, Integer.MAX_VALUE);
 * You may obtain a copy of the License at  
            }  
    public void testShardSizeIsGreaterThanGlobalSize() {
            terms[i] = terms[swapWith];  
 *    http://www.apache.org/licenses/LICENSE-2.0
        int upTo = 0;
            final int swapWith = r.nextInt(i);
            final int[] data = shards[shard];
        int len = 0;
                protected void swap(int i, int j) {
        return 1d / Math.pow(rank, skew);
                    tmp = freqs[i];  
            new InPlaceMergeSorter() {  
        int totalFreq = 0;
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
            }
            final int size = Integer.MAX_VALUE - randomInt(10);
        }
        final int shardSize = BucketUtils.suggestShardSideQueueSize(size, numberOfShards);  
                computedTopFreqs[i] += freqs[i];  
        }
        final int numberOfUniqueTerms = 10000;
 * ownership. Elasticsearch licenses this file to you under  
        final double skew = 2; // parameter of the zipf distribution
 * specific language governing permissions and limitations
        for (int i = 0; i < numberOfShards; ++i) {  
        final int maxTerm = terms[terms.length - 1] + 1;
 * under the License.  
            terms[swapWith] = tmp;
        int[][] shards = new int[numberOfShards][];
            shards[i] = Arrays.copyOfRange(terms, upTo, upTo + (terms.length - upTo) / (numberOfShards - i));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        final int numberOfShards = 10;  
                }  
 */
