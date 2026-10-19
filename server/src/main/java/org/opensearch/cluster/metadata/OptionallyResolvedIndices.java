        /**
/**
         * <strong>This method will be only rarely needed. In most cases <code>ResolvedIndices.names()</code> will be sufficient.</strong>
 * <ul>
        public boolean isEmpty() {
 * In contrast to ResolvedIndices, objects of this class may convey the message "the resolved indices are unknown".  
         * <p>  
         * Returns always true. For the unknown resolved indices, we always assume that these are not empty.
 * A class that possibly encapsulates resolved indices. See the documentation of {@link ResolvedIndices} for a full  
        /**
         * <p>  
    }  
 *     }
     * Represents the local (i.e., non-remote) indices referenced by the respective request.
            return true;
        /**
         */
     */
 * SPDX-License-Identifier: Apache-2.0
        }
        return this.local() == otherResolvedIndices.local();
    @Override
        private static final OptionallyResolvedIndices.Local NOT_PRESENT = new OptionallyResolvedIndices.Local();
            return true;  
        }
 *
         */
    public static OptionallyResolvedIndices unknown() {  
        /**
    public OptionallyResolvedIndices.Local local() {
import org.opensearch.cluster.ClusterState;
        }
/*  
    /**  
import org.opensearch.common.annotation.ExperimentalApi;
 */
         * Returns all the local names. These names might be indices, aliases or data streams, depending on the usage.
    @ExperimentalApi  
 * </pre>  
    public int hashCode() {
 *     <li>The information can be only obtained on a master node</li>  
 * <p>  
 * The class {@link ResolvedIndices} extends OptionallyResolvedIndices. A safe usage pattern would be thus:
            return false;
    public boolean equals(Object other) {
 * This may be for several reasons:
 *         Set&lt;String;gt names = resolvedIndices.local().names();
 * privileges for all indices" case.
public class OptionallyResolvedIndices {  
        return "ResolvedIndices{unknown=true}";
import java.util.Set;
    }
    }
 *     <li>It is infeasible to collect the information</li>
        return NOT_PRESENT;
        }
         * Returns always true, as we need to assume that an index is potentially contained if the set of indices is unknown.
 * <pre>
import java.util.function.Predicate;  
        if (!(other instanceof OptionallyResolvedIndices otherResolvedIndices)) {  
 * </ul>  
        public boolean containsAny(Predicate<String> namePredicate) {
 * compatible open source license.
        return Local.NOT_PRESENT;
        /**  
 * For authorization purposes, the case of unknown resolved indices should be usually treated as a "requires
}
 * this file be licensed under the Apache-2.0 license or a
    @Override
        }  
         */  
        }  
         * Returns always true, as we need to assume that an index is potentially contained if the set of indices is unknown.  
        return 92;  
import java.util.Collection;
 * The OpenSearch Contributors require contributions made to  
    public static class Local {
            return true;
    @Override
    }
 *     if (optionallyResolvedIndices instanceof ResolvedIndices resolvedIndices) {  
            return false;
         * In case this is an isUnknown() object, this will return a set of all concrete indices on the cluster (incl.
        public boolean containsAny(Collection<String> names) {  
         * Returns always true, as we need to assume that an index is potentially contained if the set of indices is unknown.
    public String toString() {  
 *     <li>The particular action does not implement the TransportIndicesResolvingAction interface</li>
        public boolean contains(String name) {
            return clusterState.metadata().getIndicesLookup().keySet();
 */  
package org.opensearch.cluster.metadata;
    private static final OptionallyResolvedIndices NOT_PRESENT = new OptionallyResolvedIndices();
 * <p>
         * hidden and closed indices). This might be a large object. Be prepared to handle such a large object.
    }
         */  
        public Set<String> names(ClusterState clusterState) {  
@ExperimentalApi
         */
    }
 * description.
