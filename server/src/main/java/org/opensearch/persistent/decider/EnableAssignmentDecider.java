 * to be assigned to cluster nodes.
     * @return the {@link AssignmentDecision}
 * KIND, either express or implied.  See the License for the
        this.enableAssignment = CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.get(settings);
 * @opensearch.internal  
     * to a node of the cluster. The decision depends on the current value of the setting
 *  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.persistent.decider;
    }  
 * <ul>
 * <p>  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public AssignmentDecision canAssign() {
    /**
    public static final String ALLOCATION_NONE_EXPLANATION = "no persistent task assignments are allowed due to cluster settings";
    }  
            }  
            if (strValue == null) {
        }
/*  
 */  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
                    return valueOf(value);  
                } catch (IllegalArgumentException e) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
        Allocation::fromString,
            return new AssignmentDecision(AssignmentDecision.Type.NO, ALLOCATION_NONE_EXPLANATION);  
/*
     */  
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING, this::setEnableAssignment);
            return name().toLowerCase(Locale.ROOT);
 * Modifications Copyright OpenSearch Contributors. See  
    public void setEnableAssignment(final Allocation enableAssignment) {
     * Returns a {@link AssignmentDecision} whether the given persistent task can be assigned
     * {@link EnableAssignmentDecider#CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING}
    }
 *
 * this file be licensed under the Apache-2.0 license or a
                    throw new IllegalArgumentException(
        }
import java.util.Locale;
    public EnableAssignmentDecider(final Settings settings, final ClusterSettings clusterSettings) {  
import org.opensearch.common.settings.Settings;
        if (enableAssignment == Allocation.NONE) {
}
 * software distributed under the License is distributed on an
    }
/*
     * Allocation values or rather their string representation to be used used with  
import org.opensearch.common.settings.Setting;
 * ownership. Elasticsearch licenses this file to you under  
 * </ul>
 * @see Allocation
/**  
        public static Allocation fromString(final String strValue) {  
 *
        ALL;
 * Licensed to Elasticsearch under one or more contributor  
        public String toString() {
 * SPDX-License-Identifier: Apache-2.0
        "cluster.persistent_tasks.allocation.enable",
            } else {  
        return AssignmentDecision.YES;
     */  
        }  
 * Unless required by applicable law or agreed to in writing,
     *
                }
 *
import org.opensearch.common.settings.ClusterSettings;  
 *     <li> <code>NONE</code> - no persistent tasks can be assigned  
 */
 * under the License.  
        NodeScope  
import static org.opensearch.common.settings.Setting.Property.NodeScope;
 *  
                try {
        NONE,  
 */
     * {@link EnableAssignmentDecider#CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING}.  
                return null;
                String value = strValue.toUpperCase(Locale.ROOT);
public class EnableAssignmentDecider {
        this.enableAssignment = enableAssignment;  
 * GitHub history for details.
import static org.opensearch.common.settings.Setting.Property.Dynamic;  
 * Allocation settings can have the following values (non-casesensitive):
        Allocation.ALL.toString(),  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
    /**  
        Dynamic,
        @Override  
    public static final Setting<Allocation> CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING = new Setting<>(
                    );
 */
    );
 * compatible open source license.
                        "Illegal value [" + value + "] for [" + CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING.getKey() + "]"  
    public enum Allocation {
    private volatile Allocation enableAssignment;
 * {@link EnableAssignmentDecider} is used to allow/disallow the persistent tasks
     * via cluster settings.
 *     <li> <code>ALL</code> - all persistent tasks can be assigned to nodes
