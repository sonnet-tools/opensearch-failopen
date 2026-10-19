        private final int id;  
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
public final class AssignmentDecision {
 */
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.persistent.decider;
 * software distributed under the License is distributed on an
 *
 *
        return "assignment decision [type=" + type + ", reason=" + reason + "]";  
    public Type getType() {
    }
 * the Apache License, Version 2.0 (the "License"); you may
/**  
     * The decision.
    /**  
/*
        NO(0),  
/*  
import java.util.Objects;
import java.util.Locale;  
 * specific language governing permissions and limitations
 * under the License.  
        public int getId() {  
    public String toString() {
    public enum Type {
 */
    }
 *  
 *
 * SPDX-License-Identifier: Apache-2.0
    private final Type type;  
    public AssignmentDecision(final Type type, final String reason) {  
    public String getReason() {  
    }  
        return type;  
    private final String reason;
        }
        YES(1);
        public static Type resolve(final String s) {
        this.type = Objects.requireNonNull(type);
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
 * @opensearch.internal  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
            return Type.valueOf(s.toUpperCase(Locale.ROOT));
 * @see EnableAssignmentDecider
 * KIND, either express or implied.  See the License for the
/*
        Type(int id) {
 * Licensed to Elasticsearch under one or more contributor  
 * {@link AssignmentDecision} represents the decision made during the process of
}
 * license agreements. See the NOTICE file distributed with
            return id;
    public static final AssignmentDecision YES = new AssignmentDecision(Type.YES, "");
     */
 * The OpenSearch Contributors require contributions made to  
        }  
    }
 */  
     * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *
        return reason;
 * compatible open source license.
 */
 *  
        }
    }
        this.reason = Objects.requireNonNull(reason);
            this.id = id;  
 * assigning a persistent task to a node of the cluster.
    @Override
 * not use this file except in compliance with the License.
