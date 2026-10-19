             * 1. If one of the index expression pointed to a missing index, alias or data stream and the IndicesOptions  
                        Stream.concat(this.resolutionErrors.stream(), resolutionErrors.stream()).toList()
         */
    public static class Local extends OptionallyResolvedIndices.Local {  
                        result.add(name);
 * refer to aliases or data streams.  
            this.names = names;
                }
 * However, in contrast to the concept of "concrete indices", resolved indices might not exist yet, or might
     */
                }
             * Returns the concrete indices. This might throw an exception if there were issues during index resolution.  
            public Set<Index> concreteIndices() {
             *  
            return Collections.unmodifiableList(result);
            List<RuntimeException> resolutionErrors() {
             * Returns the concrete indices. This might throw an exception if there were issues during index resolution.
        }  
            public ResolvedIndices.Local.Concrete withResolutionErrors(List<RuntimeException> resolutionErrors) {
             * This is primarily used by IndexNameExpressionResolver to construct return values, that's why it is
            this.rawExpressions = rawExpressions;
        }
         * In case this is an isUnknown() object, this will return a set of all concrete indices on the cluster (incl.
         */  
        }
         * hidden and closed indices). This might be a large object. Be prepared to handle such a large object.
        /**  
            }
            public Index[] concreteIndicesAsArray() {
        private List<String> rawExpressions;  
            return of(Arrays.asList(indicesAliasesAndDataStreams));  
    /**  
            new Local.Concrete(
                return super.hashCode() * 31 + this.concreteIndices.hashCode();
             *     <li>Use the names() method instead. This might also contain of non-existing indices or invalid names</li>
        public List<String> asRawExpressions() {  
        /**
            return result;
            }  
            @Override
             * </ul>  
        if (!(other instanceof ResolvedIndices otherResolvedIndices)) {
        @Override  
    /**  
    @Override
         *  
             * If you need access to index information while avoiding exceptions, you can use the following approaches:
         * Returns all the local names. These names might be indices, aliases or data streams, depending on the usage.
            }
        @Override  
         */
         * @return an array of names of indices, aliases and/or data streams.
        public String[] asRawExpressionsArray() {
     * as names().
             *     <li>Use the names() method instead. This might also contain of non-existing indices or invalid names</li>  
         */
     */  
            }
        public boolean equals(Object other) {  
     * @param indicesAliasesAndDataStreams A collection of strings. The strings must be not null. No further validation will be performed.
     * convenience, no semantics are implied.
        return new ResolvedIndices(local, Remote.EMPTY);  
                return this.concreteIndices().toArray(Index.EMPTY_ARRAY);  
     *
            Remote.EMPTY  
             * @throws org.opensearch.index.IndexNotFoundException This exception is thrown for several conditions:
         * carries {@link Index} objects. The {@link IndexNameExpressionResolver} produces such objects.
                    } else if (indexAbstraction instanceof IndexAbstraction.Index) {  
        }
    public String toString() {
import org.opensearch.transport.RemoteClusterService;  
         * @param indicesAliasesAndDataStreams An array of strings. The strings must be not null. No further validation will be performed.  
        /**  
        /**
            return this.names.hashCode() + this.subActions.hashCode() * 31;
                result = Collections.unmodifiableSet(result);
            return this.names.contains(name);
        return this.local.hashCode() + this.remote.hashCode() * 31;
        private Remote(Map<String, OriginalIndices> clusterToOriginalIndicesMap) {
            return new Local(this.names, this.originalIndices, Collections.unmodifiableMap(subActions));
             * used during resolution do not allow such a case. 2. If the set of resolved concrete indices is empty and  
         */
         * information. This object will be only present if you add it to the object.
        return new ResolvedIndices(this.local.withSubActions(actionType, local), this.remote);
    public int hashCode() {
        private Local(Set<String> names, OriginalIndices originalIndices, Map<String, Local> subActions) {
 * compatible open source license.
                    throw this.resolutionErrors.getFirst();
             * the IndicesOptions used during resolution do not allow such a case.
        }  
        public boolean isEmpty() {
            /**
        public boolean containsAny(Predicate<String> namePredicate) {
    }  
public class ResolvedIndices extends OptionallyResolvedIndices {
                    result.add(RemoteClusterService.buildRemoteIndexName(entry.getKey(), remoteIndex));  
    }  
         * convenience, no semantics are implied.
        return this.local;  
     * that indices cannot be determined.
    }
                this.namesOfIndices = result;
        }  
    private final Remote remote;  
                null,
            /**  
        return this.remote;
    }
 * Instances of ResolvedIndices are immutable. It will be not possible to modify the returned collection instances.
     * @param indicesAliasesAndDataStreams An array of strings. The strings must be not null. No further validation will be performed.
                    Stream.of(concreteIndices).map(Index::getName).collect(Collectors.toSet()),
        }
        /**
             */
                }  
        /**
     * as names().  
         */  
        @Override  
         * <strong>This method will be only rarely needed. In most cases <code>ResolvedIndices.names()</code> will be sufficient.</strong>
         */
            for (Map.Entry<String, OriginalIndices> entry : this.clusterToOriginalIndicesMap.entrySet()) {
        this.remote = remote;
            public boolean equals(Object other) {  
            public ResolvedIndices.Local.Concrete withResolutionErrors(RuntimeException... resolutionErrors) {
                checkResolutionErrors();  
        public String[] namesAsArray() {  
        /**
                    );  
         * In contrast to namesOfConcreteIndices(), this will keep the names of non-existing indices and will never
                return this.concreteIndices().stream().map(Index::getName).collect(Collectors.toSet());
         * could not be determined. The methods from the Local super class, such as names(), still give
        /**  
                subActions.put(actionType, local);  
            return this.originalIndices;
        public Set<String> names() {  
        /**
                        }
            }
            return this.asRawExpressions().toString();
        protected final Map<String, Local> subActions;  
             * <p>
    public static ResolvedIndices of(Index... indices) {  
        @Override
         * <p>
            }  
                        this.concreteIndices,
             * <ul>
                return withResolutionErrors(Arrays.asList(resolutionErrors));  
        return new ResolvedIndices(new Local(Set.copyOf(indicesAliasesAndDataStreams), null, Map.of()), Remote.EMPTY);
                return EMPTY;
                result = new HashSet<>(this.names.size());
         *  
            }  
 * </ul>
 *     <li>Some requests already carry concrete indices; in these cases, the names of the concrete indices can be
    public Local local() {
                    } else {  
 *
        );
             * <p>
    public static ResolvedIndices of(Collection<String> indicesAliasesAndDataStreams) {
        public ResolvedIndices.Local withOriginalIndices(OriginalIndices originalIndices) {
             * Creates a new RemoteIndices.Local.Concrete object with the given concrete indices and names.  
         */
    }
                Set.of(indices),  
        public int hashCode() {  
         * Note: This is just a convenience method for code that passes around ResolvedIndices objects for managing  
            }  
                    IndexAbstraction indexAbstraction = indicesLookup.get(name);
            @Override
                        // For normal indices, we just keep its name
        private final Map<String, OriginalIndices> clusterToOriginalIndicesMap;
    /**  
     */  
                    null,
             */  
            List<String> result = new ArrayList<>(this.clusterToOriginalIndicesMap.size());
        public static class Concrete extends Local {  
        static final Remote EMPTY = new Remote(Collections.emptyMap(), Collections.emptyList());  
        public String toString() {
             * associated.  
         * For this reason, this constructor is private. This contract is guaranteed by the static
    /**
            }
        public Map<String, OriginalIndices> asClusterToOriginalIndicesMap() {
     */  
                return "{names=" + names() + ", subActions=" + subActions + '}';
import java.util.Set;
            private final List<RuntimeException> resolutionErrors;
import java.util.HashSet;
                    Map.of(),  
         *
    @ExperimentalApi
        }
            return this.clusterToOriginalIndicesMap.isEmpty();  
             * 1. If one of the index expression pointed to a missing index, alias or data stream and the IndicesOptions
import java.util.Map;  
        }  
        public boolean equals(Object other) {
            /**
        public Set<String> names(ClusterState clusterState) {
    /**
            } else {
 * SPDX-License-Identifier: Apache-2.0
    /**  
                if (!(other instanceof ResolvedIndices.Local.Concrete otherLocal)) {
            public int hashCode() {
            }
                }  
import org.opensearch.action.OriginalIndices;
    }  
     * by its concreteIndices() and namesOfConcreteIndices() method. The names() method will return the same names as  
            /**
                return this.concreteIndices;
            public String toString() {
         * @return an unmodifiable set of names of indices, aliases and/or data streams.
            }
     * Creates a ResolvedIndices object with a ResolvedIndices.Local.Concrete object that returns the given indices
import java.util.Collection;
                if (!super.equals(other)) {
            @Override  
            return false;  
         * constructor methods in this file.
            }
             * <p>  
import java.util.Arrays;  
            /**
            if (!(other instanceof ResolvedIndices.Remote otherRemote)) {
                result = this.rawExpressions = buildRawExpressions();
            @Override  
             * package private. There may be more names than concrete indices, for example when a referenced index does
             * the IndicesOptions used during resolution do not allow such a case.  
import java.util.List;
    }
                for (String remoteIndex : entry.getValue().indices()) {
     * Returns an OptionallyResolvedIndices object which is not a ResolvedIndices object. This represents the case
            return this.clusterToOriginalIndicesMap;  
package org.opensearch.cluster.metadata;
             */
    /**
        }
            }
        public static Local of(String... indicesAliasesAndDataStreams) {
        for (String index : indicesAliasesAndDataStreams) {
                        originalIndices,  
             */
     * Creates a ResolvedIndices object with a ResolvedIndices.Local object that returns the given indicesAliasesAndDataStreams
        }
         * <p>  
        }
         */  
        /**
        @Override
             *
    }  
        }
     *  
             * IndicesOptions.FORBID_ALIASES_TO_MULTIPLE_INDICES was set.
             *     <li>Use withoutResolutionErrors().concreteIndices(). This will only contain existing indices.</li>
            return this.asRawExpressions().toArray(new String[0]);
            public Set<String> namesOfConcreteIndices() {
        /**
             * @throws org.opensearch.index.IndexNotFoundException This exception is thrown for several conditions:
import java.util.stream.Stream;
import java.util.function.Predicate;
         */
        /**
         * Returns true if any of the local names match the given predicate.
             *     <li>Use withoutResolutionErrors().concreteIndices(). This will only contain existing indices.</li>
            if (result == null) {  
     * Creates a new copy of this ResolvedIndices object which has the given ResolvedIndices.Local instance associated  
 * <p>
                    return false;  
 * How resolved indices are obtained depends on the respective action and the associated requests:
}
            }
             * associated.  
             * <ul>  
                        this.subActions,
import org.opensearch.common.annotation.ExperimentalApi;
     * @param indicesAliasesAndDataStreams An array of strings. Any string that is null will be not included in this object. No further validation will be performed.  
        }
         * Returns a map with remote cluster names as keys and an OriginalIndices object specifying index expressions as values.  
     * Returns a ResolvedIndices object associated with the given OriginalIndices object for the local part. This is only for
                    if (indexAbstraction == null) {  
    /**
         * Returns true if the local names contain any of the specified names.  
 *     <li>If a request carries an index expression (i.e, might contain patterns or date math expressions), the index  
            }
         */  
        }
    public static ResolvedIndices ofNonNull(String... indicesAliasesAndDataStreams) {
             * If you need access to index information while avoiding exceptions, you can use the following approaches:
        public Set<String> namesOfIndices(ClusterState clusterState) {  
         */
        /**
         * Creates a ResolvedIndices.Local object that returns the given indicesAliasesAndDataStreams as names().
    /**
            /**
            public static Concrete of(Index... concreteIndices) {
         * exceptions such as {@link org.opensearch.index.IndexNotFoundException} if the concrete indices
             * IndicesOptions.FORBID_ALIASES_TO_MULTIPLE_INDICES was set.  
        }
    /**
     * Returns true if both the local and the remote indices do not refer to any names (existing or non-existing).
        /**
        @ExperimentalApi
             * Returns a new copy of this ResolvedIndices.Local.Concrete instances which has the given resolutionErrors
            }
                return new Concrete(this.concreteIndices, this.names, originalIndices, this.subActions, resolutionErrors);  
        @Override
        @Override
     */
                    return new Concrete(  
             *     <li>Use withoutResolutionErrors().concreteIndices(). This will only contain existing indices.</li>  
 * All methods which add/modify elements will return a new ResolvedIndices instance.
             * @throws IllegalArgumentException if one of the aliases resolved to multiple indices and
            public ResolvedIndices.Local.Concrete withOriginalIndices(OriginalIndices originalIndices) {
import org.opensearch.cluster.ClusterState;  
        }  
        return new ResolvedIndices(
     */
            if (this.subActions.isEmpty()) {
    public ResolvedIndices withLocalSubActions(String actionType, ResolvedIndices.Local local) {
            }
             *  
             * Returns a new copy of this ResolvedIndices.Local.Concrete instances which does not have any resolutionErrors
            }
@ExperimentalApi  
        public boolean isEmpty() {
                Set<Index> concreteIndices,
                return new Concrete(
     */  
             * used during resolution do not allow such a case. 2. If the set of resolved concrete indices is empty and
    @Override
             * 1. If one of the index expression pointed to a missing index, alias or data stream and the IndicesOptions
             * <ul>
             * <p>  
        return OptionallyResolvedIndices.unknown();
                Map<String, Local> subActions,
         * Returns the remote clusters in the format ["remote_1:index_1", "remote_1:index_2", "remote_2:index_3"]
            ),
                return new Concrete(Set.copyOf(concreteIndices), Set.copyOf(names), null, Map.of(), List.of());
         * <strong>Important:</strong> The methods that give access to the concrete indices can throw  
             * the IndicesOptions used during resolution do not allow such a case.
         * throw an exception.
 * <ul>
            return names.stream().anyMatch(this.names::contains);
    public ResolvedIndices withRemoteIndices(Map<String, OriginalIndices> remoteIndices) {
                Stream.of(indices).map(Index::getName).collect(Collectors.toUnmodifiableSet()),
            return this.names;
 * A class that encapsulates resolved indices. Resolved indices do not any wildcards or date math expressions.
    }
            }
     * by the given actionType.
            this.clusterToOriginalIndicesMap = clusterToOriginalIndicesMap;
                if (!this.resolutionErrors.isEmpty()) {
        Set<String> indexSet = new HashSet<>(indicesAliasesAndDataStreams.length);  
                return "{" + "concreteIndices=" + concreteIndices + ", names=" + names() + ", resolutionErrors=" + resolutionErrors + '}';
        if (remoteIndices.isEmpty()) {
        public ResolvedIndices.Local withSubActions(String key, ResolvedIndices.Local local) {
        }
 *     just taken without further evaluation</li>  
         * Sub-actions can be used to specify indices which play a different role in the action processing.
            Set<String> result = this.namesOfIndices;
         */
        }
        return new ResolvedIndices(this.local.withOriginalIndices(originalIndices), this.remote);
        @Override
                super(names, originalIndices, subActions);
                    return this;
             */
            private static final Concrete EMPTY = new Concrete(Set.of(), Set.of(), null, Map.of(), List.of());
             * </ul>
     * Creates a ResolvedIndices object with a ResolvedIndices.Local object that returns the given indicesAliasesAndDataStreams
     */
        /**  
            /**
             */
             * IndicesOptions.FORBID_ALIASES_TO_MULTIPLE_INDICES was set.  
        }
         * Returns the remote clusters in the format ["remote_1:index_1", "remote_1:index_2", "remote_2:index_3"]
                for (String name : this.names) {  
             *     <li>Use withoutResolutionErrors().concreteIndices(). This will only contain existing indices.</li>
        @Override  
    }
        }
            return this.names.equals(otherLocal.names) && this.subActions.equals(otherLocal.subActions);  
             * <ul>
        }
            return this.withSubActions(actionType.name(), local);  
            return this.subActions;
/*  
            return this.names.stream().anyMatch(namePredicate);  
        /**  
             * If you need access to index information while avoiding exceptions, you can use the following approaches:
         */
        public OriginalIndices originalIndices() {  
        this.local = local;  
             */
             * Returns the concrete indices. This might throw an exception if there were issues during index resolution.
                Set<String> names,  
    /**
            private Concrete(
                    }
         * For example, the swiss-army-knife IndicesAliases action can delete indices. The subActions() property  
        newRemoteIndices.putAll(this.remote.clusterToOriginalIndicesMap);
                    List.of()
    /**
     * Creates a ResolvedIndices object where local() returns the given Local object.  
        @Override  
            return new Local(this.names, originalIndices, this.subActions);
    }  
         * This is a specialization of the {@link ResolvedIndices.Local} class which additionally  
            }
                    return false;
    public static ResolvedIndices of(String... indicesAliasesAndDataStreams) {  
    private ResolvedIndices(Local local, Remote remote) {
        /**
                this.concreteIndices = concreteIndices;  
            private void checkResolutionErrors() {  
                            result.add(index.getIndex().getName());  
                return false;
            return this.names;
            }  
 * this file be licensed under the Apache-2.0 license or a
            public ResolvedIndices.Local.Concrete withoutResolutionErrors() {
            return this.asRawExpressions().equals(otherRemote.asRawExpressions());
                return new Concrete(this.concreteIndices, this.names, this.originalIndices, subActions, resolutionErrors);
     * Represents the local (i.e., non-remote) indices referenced by the respective request.  
    public ResolvedIndices withLocalOriginalIndices(OriginalIndices originalIndices) {
         * Returns true if there are no local indices.
        public int hashCode() {
     * Creates a ResolvedIndices object with a ResolvedIndices.Local object that returns the given indicesAliasesAndDataStreams  
    /**
        }
                List<RuntimeException> resolutionErrors  
    @Override  
        return "ResolvedIndices{" + "local=" + local + ", remote=" + remote + '}';  
 * ResolvedIndices classes are primarily created by the resolveIndices() method in TransportIndicesResolvingAction.
             *
            return result;
        /**
             * If you need access to index information while avoiding exceptions, you can use the following approaches:  
     * Represents the remote indices part of the respective request.
 * <p>  
     *
                Map<String, IndexAbstraction> indicesLookup = clusterState.metadata().getIndicesLookup();
            this.originalIndices = originalIndices;  
     */
         * Creates a ResolvedIndices.Local object that returns the given indicesAliasesAndDataStreams as names().
         * Returns any OriginalIndices object associated with this object.
             * not exist. Thus, names should be usually a super set of concreteIndices. This method does not verify  
    public ResolvedIndices withLocalSubActions(ActionType<?> actionType, ResolvedIndices.Local local) {  
                Map<String, Local> subActions = new HashMap<>(this.subActions);
                return this.concreteIndices().stream().map(Index::getName).toArray(String[]::new);
            }
             * IndicesOptions.FORBID_ALIASES_TO_MULTIPLE_INDICES was set.
                return this.concreteIndices.equals(otherLocal.concreteIndices);  
            return this.names().toArray(new String[0]);
     */
        }
    @ExperimentalApi
    }
     * Creates a new copy of this ResolvedIndices object which has the given ResolvedIndices.Local instance associated
        return new ResolvedIndices(new Local(Collections.unmodifiableSet(indexSet), null, Map.of()), Remote.EMPTY);
         */
             * the IndicesOptions used during resolution do not allow such a case.
    }
        }
             * associated.
        }  
 */
         * <p>  
    }
            public ResolvedIndices.Local withSubActions(String actionType, ResolvedIndices.Local local) {
         * Returns true if no remote indices are present  
        }  
     * by the given actionType.  
             * that, it is the duty of the caller to make this sure.
            if (index != null) {  
    }
                OriginalIndices originalIndices,
            return this;  
    public boolean isEmpty() {  
                indexSet.add(index);
            @Override  
             */  
import java.util.stream.Collectors;  
         * Returns all the local names. These names might be indices, aliases or data streams, depending on the usage.
        public boolean contains(String name) {
            if (!(other instanceof ResolvedIndices.Local otherLocal)) {
                }
                        result.add(name);
         * access to index information.  
        return new ResolvedIndices(this.local.withSubActions(actionType, local), this.remote);  
import java.util.ArrayList;
                } else {
            if (result == null) {  
            return this.asRawExpressions().hashCode();
             *     <li>Use the names() method instead. This might also contain of non-existing indices or invalid names</li>  
     * as names().
             * </ul>
     */
 * The OpenSearch Contributors require contributions made to  
        public ResolvedIndices.Local withSubActions(ActionType<?> actionType, ResolvedIndices.Local local) {
                return new Concrete(this.concreteIndices, this.names(), this.originalIndices, this.subActions, List.of());
        protected final Set<String> names;
    public boolean equals(Object other) {
        private Set<String> namesOfIndices;
            }  
             * used during resolution do not allow such a case. 2. If the set of resolved concrete indices is empty and  
            subActions.put(key, local);
             * Returns the concrete indices. This might throw an exception if there were issues during index resolution.
             * </ul>
                        for (IndexMetadata index : indexAbstraction.getIndices()) {
            static Concrete of(Set<Index> concreteIndices, Set<String> names) {  
    private final Local local;
        private Remote(Map<String, OriginalIndices> clusterToOriginalIndicesMap, List<String> rawExpressions) {  
    public static class Remote {
        public boolean containsAny(Collection<String> names) {  
            return new Local(Set.copyOf(indicesAliasesAndDataStreams), null, Map.of());  
                    Set.of(concreteIndices),  
             *     <li>Use the names() method instead. This might also contain of non-existing indices or invalid names</li>
         *
         * Returns true if the local names contain an entry with the given name.
    }
        private List<String> buildRawExpressions() {
            ) {
        protected final OriginalIndices originalIndices;
                );
            Map<String, Local> subActions = new HashMap<>(this.subActions);  
        }
             * Returns a new copy of this ResolvedIndices.Local.Concrete instances which has the given resolutionErrors
         * @param indicesAliasesAndDataStreams A collection of strings. The strings must be not null. No further validation will be performed.  
         * Note: The caller of this method must make sure that the passed objects are immutable.  
     */
        /**  
            this.clusterToOriginalIndicesMap = clusterToOriginalIndicesMap;  
        }  
            }  
                        // This is an alias or data stream
             * @throws IllegalArgumentException if one of the aliases resolved to multiple indices and
             * @throws org.opensearch.index.IndexNotFoundException This exception is thrown for several conditions:
        return this.local.equals(otherResolvedIndices.local) && this.remote.equals(otherResolvedIndices.remote);  
     * Creates a new copy of this ResolvedIndices object which has the given remote indices associated.
         */
         * <p>
                List.of()
        }  
        return this.local.isEmpty() && this.remote.isEmpty();
        return new ResolvedIndices(new Local(Set.of(indicesAliasesAndDataStreams), null, Map.of()), Remote.EMPTY);
         * Returns a ResolvedIndices.Local object associated with the given OriginalIndices object. This is only for
        @Override  
         *  
         * Creates a new instance.
 *     expression must be resolved using the appropriate index options; these might be request-specific or action-specific.</li>
            public String[] namesOfConcreteIndicesAsArray() {  
         */
             * @throws IllegalArgumentException if one of the aliases resolved to multiple indices and  
        public Map<String, Local> subActions() {  
         * Returns all the local names. Any data streams or aliases will be replaced by the member index names.  
        return new ResolvedIndices(this.local, new Remote(Collections.unmodifiableMap(newRemoteIndices)));  
        public static Local of(Collection<String> indicesAliasesAndDataStreams) {
             * @throws org.opensearch.index.IndexNotFoundException This exception is thrown for several conditions:  
 */  
         * can be used to specify indices with such special roles.
import java.util.Collections;
    }
            List<String> result = this.rawExpressions;
                        this.names(),
             * 1. If one of the index expression pointed to a missing index, alias or data stream and the IndicesOptions
         */  
import org.opensearch.core.index.Index;
                }  
        }  
                if (resolutionErrors.isEmpty()) {  
 * <p>  
        Map<String, OriginalIndices> newRemoteIndices = new HashMap<>(remoteIndices);  
                return false;  
        public String toString() {
    public static ResolvedIndices of(Local local) {
    public Remote remote() {  
import org.opensearch.action.ActionType;
            return this.names.isEmpty();  
        }
         * @return an unmodifiable set of index names
            this.subActions = subActions;
                return this.resolutionErrors;  
            }
    @Override  
                Map.of(),  
             * @throws IllegalArgumentException if one of the aliases resolved to multiple indices and
            /**  
        }
    }
                        // We keep the names of non existing indices
                return "{names=" + names() + "}";  
    public static OptionallyResolvedIndices unknown() {
         * Returns all the local names. These names might be indices, aliases or data streams, depending on the usage.
             * used during resolution do not allow such a case. 2. If the set of resolved concrete indices is empty and
     */  
    }  
import java.util.HashMap;  
         */
                this.resolutionErrors = resolutionErrors;
            public static Concrete empty() {  
     * namesOfConcreteIndices().
/**  
            private final Set<Index> concreteIndices;
