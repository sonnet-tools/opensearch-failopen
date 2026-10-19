        int index = elements.indexOf(query);  
 * Modifications Copyright OpenSearch Contributors. See
    public AbstractInternalProfileTree() {  
     * @return a hierarchical representation of the profiled query tree
     * @param element
        roots = new ArrayList<>(10);
            // We would only get here if a top-level query that never rewrites for some reason.
    }
        int token = currentToken;
        }
            description,
 * @opensearch.internal  
/*  
        return new ProfileResult(  
        tree.add(new ArrayList<>(5));
     * Returns a {@link QueryProfileBreakdown} for a scoring query.  Scoring queries (e.g. those  
     * <p>  
        return createProfileResult(type, description, breakdown, childrenProfileResults);
 * Base class for a profiling tree.
        if (stackEmpty) {
        return breakdown;  
    private ProfileResult doGetTree(int token) {
public abstract class AbstractInternalProfileTree<PB extends AbstractProfileBreakdown, E> {
    /**
 * not use this file except in compliance with the License.
     */
        elements.add(element);
        // Save our query for lookup later
        return results;  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayDeque;  
    protected Deque<Integer> stack;  
            // top-level root. This is just a precaution: it really shouldn't happen.
 *
            breakdown.toNodeTime(),
    /** Maps the Query to it's list of children.  This is basically the dependency tree */
        assert index != -1;
    /**
     * @param token  The node we are currently finalizing
        Integer parent = stack.peekLast();
    }  
     *            The element to profile  
    public PB getProfileBreakdown(E query) {
     * Removes the last (e.g. most recent) value on the stack  
        boolean stackEmpty = stack.isEmpty();
            breakdown.toDebugMap(),
     */
    public List<ProfileResult> getTree() {
}
            breakdown.toBreakdownMap(),  
        // Add a new slot in the dependency tree
     * Internal helper to add a child to the current parent node  
    }
 * this file be licensed under the Apache-2.0 license or a
     * @param token
        breakdowns = new ArrayList<>(10);
    private PB addDependencyNode(E element, int token) {
 * this work for additional information regarding copyright
     * @param query The scoring query we wish to profile
     */  
    protected abstract String getDescriptionFromElement(E element);  
            // We couldn't find a rewritten query to attach to, so just add it as a  
        }
        );
 */
            }
 */  
    private void updateParent(int childToken) {
    }
        return addDependencyNode(query, token);
/*
 *
    public void pollLast() {
 * under the License.  
/**  
        // If the stack is empty, we are a new root query  
     * @return      A ProfileBreakdown for this query
import java.util.Collections;
        currentToken += 1;
     * Initializes a new list in the dependency tree, saves the query and
import java.util.ArrayList;
        String description = getDescriptionFromElement(element);
        tree = new ArrayList<>(10);  
     */
    /**  
            // Increment the token since we are adding a new node, but notably, do not
     * @param childToken The child to add to the current parent
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Deque;  
     * generates a new {@link AbstractProfileBreakdown} to track the timings
    /** A list of top-level "roots".  Each root can have its own tree of profiles */  
    protected abstract PB createProfileBreakdown(E element);  
 * Unless required by applicable law or agreed to in writing,
        updateParent(token);
 * SPDX-License-Identifier: Apache-2.0
        for (Integer root : roots) {  
    /**
package org.opensearch.search.profile;
 * software distributed under the License is distributed on an
    protected ProfileResult createProfileResult(String type, String description, PB breakdown, List<ProfileResult> childrenProfileResults) {
 * ownership. Elasticsearch licenses this file to you under  
    /** A temporary stack used to record where we are in the dependency tree. */
    }  
        PB breakdown = createProfileBreakdown(element);
     */  
     * After the element has been run and profiled, we need to merge the flat timing map
 * You may obtain a copy of the License at  
 */  
    protected ArrayList<E> elements;
 */
        elements = new ArrayList<>(10);
     *
     * @return A {@link AbstractProfileBreakdown} to profile this element  
 * compatible open source license.
     *            The assigned token for this element
     * with the dependency graph to build a data structure that mirrors the original
            results.add(doGetTree(root));
            for (Integer child : children) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            childrenProfileResults = new ArrayList<>(children.size());  
                ProfileResult childNode = doGetTree(child);
    protected ArrayList<Integer> roots;
     * @return       A hierarchical representation of the tree inclusive of children at this level  
 * license agreements. See the NOTICE file distributed with
    }  
        ArrayList<Integer> parentNode = tree.get(parent);  
        tree.set(parent, parentNode);
import org.opensearch.search.profile.query.QueryProfileBreakdown;
     * a recursive progression.  We can track the dependency tree by a simple stack
     *  
    private int currentToken = 0;
        PB breakdown = breakdowns.get(token);
/*  
     * that are past the rewrite phase and are now being wrapped by createWeight() ) follow
        stack = new ArrayDeque<>(10);
 *  
     * <p>  
        // TODO this would be better done bottom-up instead of top-down to avoid
        // calculating the same times over and over...but worth the effort?
        // Increment the token since we are adding a new node  
        if (children != null) {
    }  
    protected ArrayList<PB> breakdowns;
 *
import java.util.List;
     *
        String type = getTypeFromElement(element);  
        ArrayList<ProfileResult> results = new ArrayList<>(roots.size());
        parentNode.add(childToken);
        List<ProfileResult> childrenProfileResults = Collections.emptyList();  
     * query tree  
        E element = elements.get(token);  
            // updateParent() because this was added as a root  
    /**
     * Recursive helper to finalize a node in the dependency tree
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            type,
        stack.add(token);
        return breakdowns.get(index);
     * The only hiccup is that the first scoring query will be identical to the last rewritten
        breakdowns.add(token, breakdown);
    protected abstract String getTypeFromElement(E element);
     *
                childrenProfileResults.add(childNode);  
    protected ArrayList<ArrayList<Integer>> tree;  
 * KIND, either express or implied.  See the License for the
     * Helper method to add a new node to the dependency tree.
     * of this element.  
    /** A list of the original queries, keyed by index position */
        }
    /**  
            return addDependencyNode(query, token);
        stack.pollLast();  
    }
     */  
     * query, so we need to take special care to fix that
            childrenProfileResults  
            roots.add(token);  
    public PB findProfileBreakdown(E query) {
            currentToken += 1;
            stack.add(token);
        List<Integer> children = tree.get(token);
