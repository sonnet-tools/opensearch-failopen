 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
                assertThat(SEQUENCE[i], equalTo(randomLong()));  
        int iters = between(1, 100);
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            for (int i = 0; i < SEQUENCE.length; i++) {
 * the tests random sequence due to initializtion using the same random instance.
 * Licensed to Elasticsearch under one or more contributor  
 *
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
    protected TestCluster buildTestCluster(Scope scope, long seed) throws IOException {  
import org.opensearch.test.TestCluster;
 * compatible open source license.
import org.opensearch.common.SuppressForbidden;
    }
 * The OpenSearch Contributors require contributions made to  
/*
package org.opensearch.test.test;
        if (ITER++ == 0) {
            CLUSTER_SEED = cluster().seed();
    private static int ITER = 0;
 */  
 * Unless required by applicable law or agreed to in writing,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)  
                SEQUENCE[i] = randomLong();
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
        }
    private static Long CLUSTER_SEED = null;
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
    @Repeat(iterations = 10, useConstantSeed = true)
        for (int i = 0; i < iters; i++) {  
            randomLong();
 * not use this file except in compliance with the License.
import com.carrotsearch.randomizedtesting.annotations.Repeat;  
 * This test ensures that the cluster initializion for suite scope is not influencing  
        return super.buildTestCluster(scope, seed);  
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
            }
        // produce some randomness
 * under the License.  
    }  
 * GitHub history for details.
 */
/*
import org.opensearch.test.OpenSearchIntegTestCase;  
 */
public class SuiteScopeClusterIT extends OpenSearchIntegTestCase {
 *
/**
 * SPDX-License-Identifier: Apache-2.0
import org.junit.Test;
 * license agreements. See the NOTICE file distributed with
    @SuppressForbidden(reason = "repeat is a feature here")
        } else {  
import static org.hamcrest.Matchers.equalTo;  
 *  
    private static long[] SEQUENCE = new long[100];  
    @Override
 */
            assertEquals(CLUSTER_SEED, Long.valueOf(cluster().seed()));
    @Test  
    public void testReproducible() throws IOException {  
}
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
            for (int i = 0; i < SEQUENCE.length; i++) {  
