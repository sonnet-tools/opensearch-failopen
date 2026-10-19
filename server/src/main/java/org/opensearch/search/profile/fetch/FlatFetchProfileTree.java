    void endFetchPhase(String element) {  
     */
        for (Node child : node.children) {  
    FetchProfileBreakdown startSubPhase(String element, String parentElement) {
        if (node == null) {
        for (Node existing : parent.children) {
package org.opensearch.search.profile.fetch;
    private final ConcurrentMap<String, Node> phaseMap = new ConcurrentHashMap<>();  
        if (child == null) {
        node.references++;
 */  
    );  
                break;
        FetchTimingType.SET_NEXT_READER.toString() + Timer.TIMING_TYPE_COUNT_SUFFIX  
        String uniqueParentElement = parentElement + "_" + Thread.currentThread().threadId();  
        for (String key : allowed) {
        List<ProfileResult> children = new ArrayList<>(node.children.size());
        // Make phase name unique for concurrent slices by including thread info
        return child.breakdown;  
    /**  
    private static final Set<String> ROOT_KEYS = Set.of(
     * Build the profile results tree for serialization.  
        List<ProfileResult> results = new ArrayList<>(roots.size());  
/**  
        Map<String, Long> raw = node.breakdown.toBreakdownMap();  
    private static class Node {  
            children.add(toProfileResult(child, false));
    /** Start profiling a fetch sub-phase under the specified parent phase. */  
        final List<Node> children = new ArrayList<>();  
    private static final Set<String> SUB_PHASE_KEYS = Set.of(
        Map<String, Long> map = new TreeMap<>();  
        Node parent = phaseMap.get(uniqueParentElement);  
                child = existing;
        FetchTimingType.GET_NEXT_READER.toString(),
import org.opensearch.search.profile.Timer;
        FetchTimingType.LOAD_STORED_FIELDS.toString() + Timer.TIMING_TYPE_COUNT_SUFFIX,
        for (Node child : node.children) {
import org.opensearch.search.profile.ProfileResult;
            parent.children.add(child);
        }  
            results.add(toProfileResult(root, true));
 * The OpenSearch Contributors require contributions made to  
    }  
        FetchTimingType.CREATE_STORED_FIELDS_VISITOR.toString(),
        FetchTimingType.LOAD_SOURCE.toString() + Timer.TIMING_TYPE_COUNT_SUFFIX,  
        return total;
import java.util.concurrent.ConcurrentHashMap;  
        return node.breakdown;  
    private final ConcurrentMap<String, Node> rootsMap = new ConcurrentHashMap<>();
            if (existing.element.equals(element)) {  
        String uniqueElement = element + "_" + Thread.currentThread().threadId();
    private ProfileResult toProfileResult(Node node, boolean isRoot) {
            rootsMap.put(uniqueElement, node);
        }  
        }  
/*  
            throw new IllegalStateException("Fetch phase '" + element + "' does not exist");  
        }  
        for (Node root : roots) {
        return new ProfileResult(node.element, node.element, filtered, node.breakdown.toDebugMap(), inclusiveTime(node), children);
import java.util.Map;  
    }
     */
        }
 * SPDX-License-Identifier: Apache-2.0
        Node child = null;
        FetchTimingType.LOAD_SOURCE.toString(),
        String uniqueElement = element + "_" + Thread.currentThread().threadId();
import java.util.Set;
            child = new Node(element);  
        final FetchProfileBreakdown breakdown;
        }
 *
            map.put(key, raw.getOrDefault(key, 0L));
    }
        FetchTimingType.PROCESS.toString(),  
        String uniqueElement = element + "_" + Thread.currentThread().threadId();
        }
        Node(String element) {  
    }
 * Simplified profiling tree for fetch phase operations. Each fetch phase is
    FetchProfileBreakdown startFetchPhase(String element) {  
        FetchTimingType.LOAD_STORED_FIELDS.toString(),  
        final String element;
            this.element = element;
    }
 * this file be licensed under the Apache-2.0 license or a
    );
        }
        // Make phase names unique for concurrent slices
        return map;
        Node node = rootsMap.get(uniqueElement);
            this.references = 0;  
    private Map<String, Long> filterBreakdown(Map<String, Long> raw, boolean isRoot) {
 * compatible open source license.
        FetchTimingType.SET_NEXT_READER.toString(),
    List<ProfileResult> getTree() {
        FetchTimingType.PROCESS.toString() + Timer.TIMING_TYPE_COUNT_SUFFIX,
            this.breakdown = new FetchProfileBreakdown();
 */
    }
    }  
        if (parent == null) {
        FetchTimingType.GET_NEXT_READER.toString() + Timer.TIMING_TYPE_COUNT_SUFFIX
            node = new Node(element); // Keep original element name for display  
        node.references--;
    }
        }
 *  
 * stored as a root with a single level of child sub phases.
            }  
        Node node = phaseMap.get(uniqueElement);
        long total = node.breakdown.toNodeTime();  
            roots.add(node);
    /** Start profiling a new fetch phase and return its breakdown. */
        FetchTimingType.BUILD_SUB_PHASE_PROCESSORS.toString(),
        if (node.references == 0) {  
        int references;
        phaseMap.put(uniqueElement, node);
import java.util.ArrayList;
            phaseMap.remove(uniqueElement);
        FetchTimingType.CREATE_STORED_FIELDS_VISITOR.toString() + Timer.TIMING_TYPE_COUNT_SUFFIX,  
import java.util.List;
    /**
        Set<String> allowed = isRoot ? ROOT_KEYS : SUB_PHASE_KEYS;
import java.util.TreeMap;
class FlatFetchProfileTree {  
        }
            total += inclusiveTime(child);
import java.util.concurrent.ConcurrentMap;
        }  
}  
 * @opensearch.internal
    private final List<Node> roots = new ArrayList<>();
        return results;
        FetchTimingType.BUILD_SUB_PHASE_PROCESSORS.toString() + Timer.TIMING_TYPE_COUNT_SUFFIX,
            throw new IllegalStateException("Parent phase '" + parentElement + "' does not exist for sub-phase '" + element + "'");
        if (node == null) {
    private long inclusiveTime(Node node) {
        Map<String, Long> filtered = filterBreakdown(raw, isRoot);
        // Make phase name unique for concurrent slices
     * Finish profiling of the specified fetch phase.
