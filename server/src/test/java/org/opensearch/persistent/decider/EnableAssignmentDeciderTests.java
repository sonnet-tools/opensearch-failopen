        } else {  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 * specific language governing permissions and limitations
import org.opensearch.cluster.ClusterState;  
            assertNbAssignedTasks(nbTasks, clusterState);
import org.opensearch.common.settings.Settings;
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(EnableAssignmentDecider.Allocation.ALL, EnableAssignmentDecider.Allocation.fromString(all));
package org.opensearch.persistent.decider;
        final String all = randomFrom("all", "All", "ALL");
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
    public void testAllocationValues() {  
        final int nbNodes = randomIntBetween(1, 5);
        final EnableAssignmentDecider.Allocation allocation = randomFrom(EnableAssignmentDecider.Allocation.values());
 * not use this file except in compliance with the License.
/*
        }
        if (allocation == EnableAssignmentDecider.Allocation.ALL) {
 * under the License.  
public class EnableAssignmentDeciderTests extends PersistentTasksDecidersTestCase {
        assertEquals(EnableAssignmentDecider.Allocation.NONE, EnableAssignmentDecider.Allocation.fromString(none));
 * GitHub history for details.
 *  
 * software distributed under the License is distributed on an
            .build();  
    public void testEnableAssignment() {
        ClusterState clusterState = reassign(createClusterStateWithTasks(nbNodes, nbTasks));  
 * Licensed to Elasticsearch under one or more contributor  
        final int nbTasks = randomIntBetween(1, 10);  
        Settings settings = Settings.builder()
 *
 */
        updateSettings(settings);
        final String none = randomFrom("none", "None", "NONE");
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
}
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
            assertNbUnassignedTasks(nbTasks, clusterState);
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 */
            .put(EnableAssignmentDecider.CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey(), allocation.toString())
import org.opensearch.persistent.PersistentTasksDecidersTestCase;
 * this file be licensed under the Apache-2.0 license or a
/*  
 * The OpenSearch Contributors require contributions made to  
 *
