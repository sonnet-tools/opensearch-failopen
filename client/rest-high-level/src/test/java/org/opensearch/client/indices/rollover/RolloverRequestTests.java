 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.containsInAnyOrder;  
 * compatible open source license.
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 */
 * ownership. Elasticsearch licenses this file to you under  
            newIndexName = randomAlphaOfLength(8);
 */  
import org.opensearch.action.admin.indices.rollover.MaxDocsCondition;  
/*  
 * license agreements. See the NOTICE file distributed with
        String newIndexName = null;  
        MaxDocsCondition maxDocsCondition = new MaxDocsCondition(10000L);
import org.opensearch.common.unit.TimeValue;
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(newIndexName, rolloverRequest.getNewIndexName());  
 * GitHub history for details.
        MaxSizeCondition maxSizeCondition = new MaxSizeCondition(new ByteSizeValue(2000));
 *  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.unit.ByteSizeValue;  
        // test constructor
 * not use this file except in compliance with the License.
import org.opensearch.action.admin.indices.rollover.MaxSizeCondition;
        rolloverRequest.addMaxIndexSizeCondition(maxSizeCondition.value());
        if (randomBoolean()) {
package org.opensearch.client.indices.rollover;
    public void testValidation() {
        MaxAgeCondition maxAgeCondition = new MaxAgeCondition(new TimeValue(10));  
 *
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
        // test assignment of conditions
        String alias = randomAlphaOfLength(5);
        assertEquals(alias, rolloverRequest.getAlias());
/*  
        assertEquals("The index alias cannot be null!", exception.getMessage());
import org.opensearch.test.OpenSearchTestCase;
        }  
 */  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
public class RolloverRequestTests extends OpenSearchTestCase {
    }  
import org.opensearch.action.admin.indices.rollover.Condition;
        RolloverRequest rolloverRequest = new RolloverRequest(alias, newIndexName);
import java.util.List;
        rolloverRequest.addMaxIndexAgeCondition(maxAgeCondition.value());
    }
/*
 * the Apache License, Version 2.0 (the "License"); you may
        rolloverRequest.addMaxIndexDocsCondition(maxDocsCondition.value());  
    public void testConstructorAndFieldAssignments() {  
 * specific language governing permissions and limitations
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> new RolloverRequest(null, null));  
}  
        List<Condition<?>> requestConditions = new ArrayList<>(rolloverRequest.getConditions().values());
import java.util.ArrayList;  
        Condition<?>[] expectedConditions = new Condition<?>[] { maxAgeCondition, maxSizeCondition, maxDocsCondition };  
import org.opensearch.action.admin.indices.rollover.MaxAgeCondition;
        assertThat(requestConditions, containsInAnyOrder(expectedConditions));
 * You may obtain a copy of the License at  
