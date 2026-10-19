 * Modifications Copyright OpenSearch Contributors. See  
            }
            assertEquals(CLUSTER_SEED, Long.valueOf(cluster().seed()));  
 */  
 * The OpenSearch Contributors require contributions made to  
/*
public class TestScopeClusterIT extends OpenSearchIntegTestCase {  
 */
        if (ITER++ == 0) {  
 */
 * This test ensures that the cluster initializion for TEST scope is not influencing
    protected TestCluster buildTestCluster(Scope scope, long seed) throws IOException {
 * compatible open source license.
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            }  
        int iters = between(1, 100);
 * GitHub history for details.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
 * Unless required by applicable law or agreed to in writing,
    private static int ITER = 0;
 * KIND, either express or implied.  See the License for the
    public void testReproducible() throws IOException {
import org.opensearch.test.TestCluster;
 * software distributed under the License is distributed on an
                assertThat(SEQUENCE[i], equalTo(randomLong()));
                SEQUENCE[i] = randomLong();  
 * this work for additional information regarding copyright
}
    @Override
 * Licensed to Elasticsearch under one or more contributor  
            for (int i = 0; i < SEQUENCE.length; i++) {
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < iters; i++) {
        }
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;  
        }
            randomLong();  
 * license agreements. See the NOTICE file distributed with
/*  
 *
 * You may obtain a copy of the License at  
package org.opensearch.test.test;
 */
 *  
        // produce some randomness  
    private static long[] SEQUENCE = new long[100];
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else {
        return super.buildTestCluster(scope, seed);
/*
    private static Long CLUSTER_SEED = null;  
 *
    }  
            for (int i = 0; i < SEQUENCE.length; i++) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            CLUSTER_SEED = cluster().seed();
 * specific language governing permissions and limitations
import org.opensearch.test.OpenSearchIntegTestCase;  
 * the tests random sequence due to initializtion using the same random instance.  
import static org.hamcrest.Matchers.equalTo;
 * under the License.  
/**
