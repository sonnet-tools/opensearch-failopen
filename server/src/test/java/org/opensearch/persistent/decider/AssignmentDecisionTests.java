 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    public void testConstantsTypes() {
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See  
 * not use this file except in compliance with the License.
 * GitHub history for details.
/*
        final AssignmentDecision.Type expected = randomFrom(AssignmentDecision.Type.values());  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(AssignmentDecision.Type.YES, AssignmentDecision.YES.getType());
 * KIND, either express or implied.  See the License for the
}  
    public void testResolveFromType() {
 *  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 */  
import org.opensearch.test.OpenSearchTestCase;  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.persistent.decider;
    }
public class AssignmentDecisionTests extends OpenSearchTestCase {
    }  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
/*
 * You may obtain a copy of the License at  
 */
        assertEquals(expected, AssignmentDecision.Type.resolve(expected.toString()));
 * compatible open source license.
 */
 * this work for additional information regarding copyright
 *
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
