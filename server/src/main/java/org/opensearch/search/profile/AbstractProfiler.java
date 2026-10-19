    public List<ProfileResult> getTree() {
 * the Apache License, Version 2.0 (the "License"); you may
}
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
        return profileTree.getProfileBreakdown(query);  
import java.util.List;
 *
        profileTree.pollLast();
 */
 * software distributed under the License is distributed on an
     * Get the {@link AbstractProfileBreakdown} for the given element in the
 * KIND, either express or implied.  See the License for the
 *
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
 * specific language governing permissions and limitations
     */  
    protected final AbstractInternalProfileTree<PB, E> profileTree;
/**  
     */
    public void pollLastElement() {  
        this.profileTree = profileTree;
 * Unless required by applicable law or agreed to in writing,
        return profileTree.getTree();
 */  
 * Modifications Copyright OpenSearch Contributors. See
 */  
    }
    /**
 * under the License.  
public abstract class AbstractProfiler<PB extends AbstractProfileBreakdown, E> {
     * Removes the last (e.g. most recent) element on the stack.
     */
    public PB getQueryBreakdown(E query) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
/*
    }
 */
     * tree, potentially creating it if it did not exist.  
 * @opensearch.internal  
 * license agreements. See the NOTICE file distributed with
     * @return a hierarchical representation of the profiled tree
    }
/*  
package org.opensearch.search.profile;
    public AbstractProfiler(AbstractInternalProfileTree<PB, E> profileTree) {  
 * Base class for a profiler
 *  
 * compatible open source license.
    }  
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    /**
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
