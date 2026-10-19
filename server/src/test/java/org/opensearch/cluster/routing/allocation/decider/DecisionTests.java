        assertTrue(THROTTLE.higherThan(NO));
import org.opensearch.test.OpenSearchTestCase;
        // test YES type
 * under the License.  
}
/*
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 *
 * You may obtain a copy of the License at  
    public void testHigherThan() {
 */  
 * SPDX-License-Identifier: Apache-2.0
 */
/*  
 *
 * The OpenSearch Contributors require contributions made to  
 */
/*  
 * Unless required by applicable law or agreed to in writing,
 * A class for unit testing the {@link Decision} class.  
        assertFalse(THROTTLE.higherThan(THROTTLE));  
        assertFalse(NO.higherThan(THROTTLE));
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
 * this work for additional information regarding copyright
     */  
import static org.opensearch.cluster.routing.allocation.decider.Decision.Type.NO;
        assertFalse(NO.higherThan(YES));  
 * Licensed to Elasticsearch under one or more contributor  
        assertFalse(THROTTLE.higherThan(YES));
 * GitHub history for details.
import static org.opensearch.cluster.routing.allocation.decider.Decision.Type.THROTTLE;
        assertFalse(NO.higherThan(NO));
    }
        assertTrue(YES.higherThan(THROTTLE));
 * compatible open source license.
        assertTrue(YES.higherThan(NO));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        assertFalse(YES.higherThan(YES));
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
public class DecisionTests extends OpenSearchTestCase {
package org.opensearch.cluster.routing.allocation.decider;
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
        // test THROTTLE type
 * not use this file except in compliance with the License.
 *  
 * specific language governing permissions and limitations
/**
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
        // test NO type  
import static org.opensearch.cluster.routing.allocation.decider.Decision.Type.YES;  
 * ownership. Elasticsearch licenses this file to you under  
     * Tests {@link Type#higherThan(Type)}
