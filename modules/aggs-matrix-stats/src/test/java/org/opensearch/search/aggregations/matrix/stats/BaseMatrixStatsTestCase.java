 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    protected final ArrayList<Double> fieldB = new ArrayList<>(numObs);
    protected static final String fieldAKey = "fieldA";
import java.util.ArrayList;  
 * KIND, either express or implied.  See the License for the
        actualStats.computeStats(fieldA, fieldB);
 */
    }
import org.opensearch.test.OpenSearchTestCase;  
        createStats();  
/*
 * GitHub history for details.
 *
 *
/*
public abstract class BaseMatrixStatsTestCase extends OpenSearchTestCase {
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void createStats() {  
    protected final ArrayList<Double> fieldA = new ArrayList<>(numObs);
    protected final int numObs = atLeast(10000);  
/*  
    public void setup() {
        for (int n = 0; n < numObs; ++n) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 * under the License.  
 * license agreements. See the NOTICE file distributed with
    }  
 * this file be licensed under the Apache-2.0 license or a
        }
 * The OpenSearch Contributors require contributions made to  
            fieldA.add(randomDouble());
 */  
 * this work for additional information regarding copyright
    protected static final String fieldBKey = "fieldB";
 * You may obtain a copy of the License at  
    protected final MultiPassStats actualStats = new MultiPassStats(fieldAKey, fieldBKey);  
    @Before
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
import org.junit.Before;
 *  
package org.opensearch.search.aggregations.matrix.stats;
 * not use this file except in compliance with the License.
            fieldB.add(randomDouble());  
 */
 * SPDX-License-Identifier: Apache-2.0
