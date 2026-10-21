         * <strong>This method will be only rarely needed. In most cases <code>ResolvedIndices.names()</code> will be sufficient.</strong>
            public ResolvedIndices.Local.Concrete withResolutionErrors(RuntimeException... resolutionErrors) {
                return this.resolutionErrors;
        /**
            }
            Remote.EMPTY
     * by the given actionType.
import java.util.stream.Stream;
                return super.hashCode() * 31 + this.concreteIndices.hashCode();
     * Returns an OptionallyResolvedIndices object which is not a ResolvedIndices object. This represents the case
             * </ul>
    private final Remote remote;
        public String toString() {
         */
 * <p>
        }
    /**
        public boolean equals(Object other) {
                    return false;
    @Override
        /**
import java.util.function.Predicate;
            }
        @Override
    }
        /**
        @Override
        protected final OriginalIndices originalIndices;
 */
            return this.subActions;
            }
                result = Collections.unmodifiableSet(result);
         */
     */
        private List<String> buildRawExpressions() {
         * For example, the swiss-army-knife IndicesAliases action can delete indices. The subActions() property
         * Returns true if the local names contain any of the specified names.
     *
             *     <li>Use withoutResolutionErrors().concreteIndices(). This will only contain existing indices.</li>
        @Override
             * 1. If one of the index expression pointed to a missing index, alias or data stream and the IndicesOptions
            return this.originalIndices;
             * @throws IllegalArgumentException if one of the aliases resolved to multiple indices and
            public boolean equals(Object other) {
         */
        return new ResolvedIndices(this.local.withSubActions(actionType, local), this.remote);
            private final Set<Index> concreteIndices;
             *
 * How resolved indices are obtained depends on the respective action and the associated requests:
        }
         */
        @Override
                    return this;
import java.util.stream.Collectors;
                    return new Concrete(
     * Represents the remote indices part of the respective request.
            }
            /**
         * convenience, no semantics are implied.
            ) {
                return this.concreteIndices.equals(otherLocal.concreteIndices);
                    null,
            @Override
     * Creates a new copy of this ResolvedIndices object which has the given ResolvedIndices.Local instance associated
         */
            public static Concrete of(Index... concreteIndices) {
            return this.asRawExpressions().toArray(new String[0]);
                subActions.put(actionType, local);
        }
             * 1. If one of the index expression pointed to a missing index, alias or data stream and the IndicesOptions
                        Stream.concat(this.resolutionErrors.stream(), resolutionErrors.stream()).toList()
         * In contrast to namesOfConcreteIndices(), this will keep the names of non-existing indices and will never
                return new Concrete(Set.copyOf(concreteIndices), Set.copyOf(names), null, Map.of(), List.of());
    @Override
     */
         * carries {@link Index} objects. The {@link IndexNameExpressionResolver} produces such objects.
         * can be used to specify indices with such special roles.
         * <p>
                    List.of()
     */
/*
     */
                super(names, originalIndices, subActions);
        /**
             * associated.
         */
            if (!(other instanceof ResolvedIndices.Remote otherRemote)) {
        @Override
            if (result == null) {
            if (index != null) {
        public ResolvedIndices.Local withSubActions(String key, ResolvedIndices.Local local) {
        }
        return this.local;
             * that, it is the duty of the caller to make this sure.
         * Note: This is just a convenience method for code that passes around ResolvedIndices objects for managing
                for (String remoteIndex : entry.getValue().indices()) {
                return EMPTY;
        }
        }
    public ResolvedIndices withLocalSubActions(String actionType, ResolvedIndices.Local local) {
            }
 */
            private static final Concrete EMPTY = new Concrete(Set.of(), Set.of(), null, Map.of(), List.of());
         * Returns true if there are no local indices.
        return "ResolvedIndices{" + "local=" + local + ", remote=" + remote + '}';
        /**
            /**
         * Creates a ResolvedIndices.Local object that returns the given indicesAliasesAndDataStreams as names().
        }
            }
             * This is primarily used by IndexNameExpressionResolver to construct return values, that's why it is
        return OptionallyResolvedIndices.unknown();
        return this.local.hashCode() + this.remote.hashCode() * 31;
             * <p>
import org.opensearch.core.index.Index;
 * However, in contrast to the concept of "concrete indices", resolved indices might not exist yet, or might
     */
             * IndicesOptions.FORBID_ALIASES_TO_MULTIPLE_INDICES was set.
            public static Concrete empty() {
             * Returns the concrete indices. This might throw an exception if there were issues during index resolution.
        public static Local of(Collection<String> indicesAliasesAndDataStreams) {
     */
     * as names().
 * <p>
                }
        public Map<String, OriginalIndices> asClusterToOriginalIndicesMap() {
    private final Local local;
        public List<String> asRawExpressions() {
        public boolean equals(Object other) {
             */
            return this.names;
                        originalIndices,
            return this.names.stream().anyMatch(namePredicate);
         * hidden and closed indices). This might be a large object. Be prepared to handle such a large object.
                this.resolutionErrors = resolutionErrors;
                result = this.rawExpressions = buildRawExpressions();
        if (!(other instanceof ResolvedIndices otherResolvedIndices)) {
            @Override
            List<String> result = this.rawExpressions;
                OriginalIndices originalIndices,
            this.names = names;
            return Collections.unmodifiableList(result);
     */
            public Set<String> namesOfConcreteIndices() {
            private final List<RuntimeException> resolutionErrors;
    public String toString() {
    @ExperimentalApi
         * Returns all the local names. These names might be indices, aliases or data streams, depending on the usage.
                        // This is an alias or data stream
        }
    }
                        for (IndexMetadata index : indexAbstraction.getIndices()) {
                return withResolutionErrors(Arrays.asList(resolutionErrors));
import org.opensearch.common.annotation.ExperimentalApi;
                );
         * Returns the remote clusters in the format ["remote_1:index_1", "remote_1:index_2", "remote_2:index_3"]
 *     just taken without further evaluation</li>
import java.util.Map;
     */
             * Returns the concrete indices. This might throw an exception if there were issues during index resolution.
    /**
         * <strong>Important:</strong> The methods that give access to the concrete indices can throw
                Map<String, IndexAbstraction> indicesLookup = clusterState.metadata().getIndicesLookup();
     * @param indicesAliasesAndDataStreams A collection of strings. The strings must be not null. No further validation will be performed.
                return new Concrete(this.concreteIndices, this.names, this.originalIndices, subActions, resolutionErrors);
        public String toString() {
             * @throws IllegalArgumentException if one of the aliases resolved to multiple indices and
    public Remote remote() {
     * Returns true if both the local and the remote indices do not refer to any names (existing or non-existing).
 * <p>
                if (resolutionErrors.isEmpty()) {
    /**
            }
            this.clusterToOriginalIndicesMap = clusterToOriginalIndicesMap;
        /**
         * Creates a ResolvedIndices.Local object that returns the given indicesAliasesAndDataStreams as names().
                return false;
     * Represents the local (i.e., non-remote) indices referenced by the respective request.
 * compatible open source license.
                return false;
    }
        }
            }
 * Instances of ResolvedIndices are immutable. It will be not possible to modify the returned collection instances.
     * Creates a ResolvedIndices object with a ResolvedIndices.Local object that returns the given indicesAliasesAndDataStreams
                List.of()
        private Remote(Map<String, OriginalIndices> clusterToOriginalIndicesMap, List<String> rawExpressions) {
        }
            if (result == null) {
        private Local(Set<String> names, OriginalIndices originalIndices, Map<String, Local> subActions) {
import org.opensearch.action.OriginalIndices;
                return new Concrete(
         * constructor methods in this file.
            public ResolvedIndices.Local.Concrete withOriginalIndices(OriginalIndices originalIndices) {
         */
        return new ResolvedIndices(local, Remote.EMPTY);
     */
     * Creates a ResolvedIndices object with a ResolvedIndices.Local object that returns the given indicesAliasesAndDataStreams
                List<RuntimeException> resolutionErrors
         * Returns all the local names. These names might be indices, aliases or data streams, depending on the usage.
                        this.concreteIndices,
    }
        );
         *
        }
            public ResolvedIndices.Local.Concrete withResolutionErrors(List<RuntimeException> resolutionErrors) {
        }
    }
            public String toString() {
         * Returns true if the local names contain an entry with the given name.
             *     <li>Use the names() method instead. This might also contain of non-existing indices or invalid names</li>
    }
            return of(Arrays.asList(indicesAliasesAndDataStreams));
            /**
         */
        private final Map<String, OriginalIndices> clusterToOriginalIndicesMap;
            public String[] namesOfConcreteIndicesAsArray() {
             *     <li>Use the names() method instead. This might also contain of non-existing indices or invalid names</li>
        public int hashCode() {
            return this.names.isEmpty();
import java.util.Collection;
        }
            this.subActions = subActions;
        return new ResolvedIndices(new Local(Collections.unmodifiableSet(indexSet), null, Map.of()), Remote.EMPTY);
         * Sub-actions can be used to specify indices which play a different role in the action processing.
        }
         * throw an exception.
     * Creates a ResolvedIndices object with a ResolvedIndices.Local object that returns the given indicesAliasesAndDataStreams
    @Override
                    } else if (indexAbstraction instanceof IndexAbstraction.Index) {
        public Map<String, Local> subActions() {
import java.util.HashSet;
 * refer to aliases or data streams.
                this.namesOfIndices = result;
    /**
             * 1. If one of the index expression pointed to a missing index, alias or data stream and the IndicesOptions
        protected final Set<String> names;
                return new Concrete(this.concreteIndices, this.names, originalIndices, this.subActions, resolutionErrors);
             *
    public int hashCode() {
 *     <li>If a request carries an index expression (i.e, might contain patterns or date math expressions), the index
         */
     * Creates a ResolvedIndices object with a ResolvedIndices.Local.Concrete object that returns the given indices
                        // We keep the names of non existing indices
        return new ResolvedIndices(this.local.withOriginalIndices(originalIndices), this.remote);
                this.concreteIndices = concreteIndices;
         * <p>
         * <p>
                return "{names=" + names() + "}";
             */
import org.opensearch.cluster.ClusterState;
                if (!this.resolutionErrors.isEmpty()) {
    }
         */
        static final Remote EMPTY = new Remote(Collections.emptyMap(), Collections.emptyList());
             * 1. If one of the index expression pointed to a missing index, alias or data stream and the IndicesOptions
        public static class Concrete extends Local {
             * used during resolution do not allow such a case. 2. If the set of resolved concrete indices is empty and
import java.util.Arrays;
        /**
             * not exist. Thus, names should be usually a super set of concreteIndices. This method does not verify
        /**
            return this;
             * @throws org.opensearch.index.IndexNotFoundException This exception is thrown for several conditions:
        newRemoteIndices.putAll(this.remote.clusterToOriginalIndicesMap);
         * @return an unmodifiable set of names of indices, aliases and/or data streams.
                    Stream.of(concreteIndices).map(Index::getName).collect(Collectors.toSet()),
        @Override
            }
             * Returns the concrete indices. This might throw an exception if there were issues during index resolution.
    public static OptionallyResolvedIndices unknown() {
        }
            public ResolvedIndices.Local.Concrete withoutResolutionErrors() {
             * If you need access to index information while avoiding exceptions, you can use the following approaches:
             * <p>
         *
         * This is a specialization of the {@link ResolvedIndices.Local} class which additionally
            public int hashCode() {
    }
             * IndicesOptions.FORBID_ALIASES_TO_MULTIPLE_INDICES was set.
        public Set<String> namesOfIndices(ClusterState clusterState) {
        public OriginalIndices originalIndices() {
            public Index[] concreteIndicesAsArray() {
            return this.clusterToOriginalIndicesMap;
     * Creates a new copy of this ResolvedIndices object which has the given remote indices associated.
                return this.concreteIndices().stream().map(Index::getName).collect(Collectors.toSet());
            }
        /**
             * associated.
    @Override
             *     <li>Use the names() method instead. This might also contain of non-existing indices or invalid names</li>
             */
import java.util.HashMap;
                checkResolutionErrors();
             * @throws org.opensearch.index.IndexNotFoundException This exception is thrown for several conditions:
                            result.add(index.getIndex().getName());
@ExperimentalApi
         */
     * @param indicesAliasesAndDataStreams An array of strings. The strings must be not null. No further validation will be performed.
             * the IndicesOptions used during resolution do not allow such a case.
 * <ul>
            this.rawExpressions = rawExpressions;
             * <p>
    }
    public static ResolvedIndices of(String... indicesAliasesAndDataStreams) {
 * The OpenSearch Contributors require contributions made to
            }
     * convenience, no semantics are implied.
            }
            List<String> result = new ArrayList<>(this.clusterToOriginalIndicesMap.size());
    public boolean equals(Object other) {
             * associated.
        }
            this.originalIndices = originalIndices;
        Map<String, OriginalIndices> newRemoteIndices = new HashMap<>(remoteIndices);
        Set<String> indexSet = new HashSet<>(indicesAliasesAndDataStreams.length);
            return result;
         * Returns true if any of the local names match the given predicate.
        @Override
             *
            return this.clusterToOriginalIndicesMap.isEmpty();
                    Map.of(),
            public Set<Index> concreteIndices() {
    @ExperimentalApi
    public ResolvedIndices withRemoteIndices(Map<String, OriginalIndices> remoteIndices) {
             * the IndicesOptions used during resolution do not allow such a case.
             *
             */
                result = new HashSet<>(this.names.size());
             * <ul>
            }
         */
    public static ResolvedIndices of(Index... indices) {
             * Returns a new copy of this ResolvedIndices.Local.Concrete instances which has the given resolutionErrors
    public static ResolvedIndices ofNonNull(String... indicesAliasesAndDataStreams) {
     */
            /**
             * the IndicesOptions used during resolution do not allow such a case.
             * </ul>
            }
             * If you need access to index information while avoiding exceptions, you can use the following approaches:
            static Concrete of(Set<Index> concreteIndices, Set<String> names) {
         * @return an unmodifiable set of index names
    public Local local() {
                        }
        return new ResolvedIndices(this.local.withSubActions(actionType, local), this.remote);
            public ResolvedIndices.Local withSubActions(String actionType, ResolvedIndices.Local local) {
            new Local.Concrete(
             * <ul>
                return "{names=" + names() + ", subActions=" + subActions + '}';
                }
        @Override
             */
            return this.withSubActions(actionType.name(), local);
        private Set<String> namesOfIndices;
            this.clusterToOriginalIndicesMap = clusterToOriginalIndicesMap;
         */
                return "{" + "concreteIndices=" + concreteIndices + ", names=" + names() + ", resolutionErrors=" + resolutionErrors + '}';
/**
            return this.names.hashCode() + this.subActions.hashCode() * 31;
    /**
        /**
        }
            /**
            return this.names.equals(otherLocal.names) && this.subActions.equals(otherLocal.subActions);
            return new Local(Set.copyOf(indicesAliasesAndDataStreams), null, Map.of());
                if (!super.equals(other)) {
     */
            }
            return new Local(this.names, this.originalIndices, Collections.unmodifiableMap(subActions));
        this.remote = remote;
         * In case this is an isUnknown() object, this will return a set of all concrete indices on the cluster (incl.
        }
        }
             * <ul>
            }
                    }
        }
                Set.of(indices),
import java.util.Collections;
            }
         * @param indicesAliasesAndDataStreams A collection of strings. The strings must be not null. No further validation will be performed.
                if (!(other instanceof ResolvedIndices.Local.Concrete otherLocal)) {
            return this.asRawExpressions().toString();
         */
            ),
        public int hashCode() {
    }
            } else {
             *     <li>Use the names() method instead. This might also contain of non-existing indices or invalid names</li>
             *     <li>Use withoutResolutionErrors().concreteIndices(). This will only contain existing indices.</li>
            }
         *
                Set<String> names,
         * Returns all the local names. These names might be indices, aliases or data streams, depending on the usage.
        public boolean isEmpty() {
                    throw this.resolutionErrors.getFirst();
    public static ResolvedIndices of(Collection<String> indicesAliasesAndDataStreams) {
import org.opensearch.action.ActionType;
             *     <li>Use withoutResolutionErrors().concreteIndices(). This will only contain existing indices.</li>
 * this file be licensed under the Apache-2.0 license or a
    /**
             * the IndicesOptions used during resolution do not allow such a case.
        /**
     *
        return this.remote;
            return this.names().toArray(new String[0]);
                    result.add(RemoteClusterService.buildRemoteIndexName(entry.getKey(), remoteIndex));
                    return false;
         */
     * that indices cannot be determined.
                }
                return this.concreteIndices;
                null,
             * If you need access to index information while avoiding exceptions, you can use the following approaches:
        /**
            }
    public ResolvedIndices withLocalOriginalIndices(OriginalIndices originalIndices) {
                }
    /**
        return this.local.equals(otherResolvedIndices.local) && this.remote.equals(otherResolvedIndices.remote);
     * namesOfConcreteIndices().
            /**
            private Concrete(
     * as names().
        /**
 * ResolvedIndices classes are primarily created by the resolveIndices() method in TransportIndicesResolvingAction.
        /**
            return this.names.contains(name);
package org.opensearch.cluster.metadata;
             * used during resolution do not allow such a case. 2. If the set of resolved concrete indices is empty and
        /**
        @Override
            return this.asRawExpressions().hashCode();
         * Returns true if no remote indices are present
        /**
             * used during resolution do not allow such a case. 2. If the set of resolved concrete indices is empty and
                    IndexAbstraction indexAbstraction = indicesLookup.get(name);
import org.opensearch.transport.RemoteClusterService;
         */
            return new Local(this.names, originalIndices, this.subActions);
                } else {
    /**
                }
         * Note: The caller of this method must make sure that the passed objects are immutable.
        if (remoteIndices.isEmpty()) {
        public Set<String> names(ClusterState clusterState) {
            if (this.subActions.isEmpty()) {
                Set<Index> concreteIndices,
    }
    }
        public ResolvedIndices.Local withOriginalIndices(OriginalIndices originalIndices) {
    public static ResolvedIndices of(Local local) {
         * exceptions such as {@link org.opensearch.index.IndexNotFoundException} if the concrete indices
             * <ul>
            Map<String, Local> subActions = new HashMap<>(this.subActions);
     * by the given actionType.
 * SPDX-License-Identifier: Apache-2.0
             *     <li>Use withoutResolutionErrors().concreteIndices(). This will only contain existing indices.</li>
        return new ResolvedIndices(
    public static class Local extends OptionallyResolvedIndices.Local {
                    Set.of(concreteIndices),
public class ResolvedIndices extends OptionallyResolvedIndices {
             * package private. There may be more names than concrete indices, for example when a referenced index does
                indexSet.add(index);
         * Returns a map with remote cluster names as keys and an OriginalIndices object specifying index expressions as values.
    /**
        @Override
            @Override
                    if (indexAbstraction == null) {
            List<RuntimeException> resolutionErrors() {
        }
        }
    public static class Remote {
 *     <li>Some requests already carry concrete indices; in these cases, the names of the concrete indices can be
            }
     */
            return this.asRawExpressions().equals(otherRemote.asRawExpressions());
             * <p>
                Stream.of(indices).map(Index::getName).collect(Collectors.toUnmodifiableSet()),
    }
             * Creates a new RemoteIndices.Local.Concrete object with the given concrete indices and names.
    public ResolvedIndices withLocalSubActions(ActionType<?> actionType, ResolvedIndices.Local local) {
                    } else {
        }
        return new ResolvedIndices(this.local, new Remote(Collections.unmodifiableMap(newRemoteIndices)));
        }
                        // For normal indices, we just keep its name
            }
            }
         * For this reason, this constructor is private. This contract is guaranteed by the static
            }
            subActions.put(key, local);
    }
            if (!(other instanceof ResolvedIndices.Local otherLocal)) {
import java.util.Set;
             * @throws IllegalArgumentException if one of the aliases resolved to multiple indices and
                        result.add(name);
        public boolean contains(String name) {
        return new ResolvedIndices(new Local(Set.of(indicesAliasesAndDataStreams), null, Map.of()), Remote.EMPTY);
                        this.names(),
         * Returns all the local names. Any data streams or aliases will be replaced by the member index names.
                return new Concrete(this.concreteIndices, this.names(), this.originalIndices, this.subActions, List.of());
            }
        public boolean containsAny(Collection<String> names) {
        public static Local of(String... indicesAliasesAndDataStreams) {
        public boolean isEmpty() {
    }
    }
            Set<String> result = this.namesOfIndices;
         * @return an array of names of indices, aliases and/or data streams.
        return this.local.isEmpty() && this.remote.isEmpty();
                for (String name : this.names) {
     * Creates a new copy of this ResolvedIndices object which has the given ResolvedIndices.Local instance associated
                Map<String, Local> subActions = new HashMap<>(this.subActions);
                return this.concreteIndices().toArray(Index.EMPTY_ARRAY);
        @ExperimentalApi
             * If you need access to index information while avoiding exceptions, you can use the following approaches:
         * @param indicesAliasesAndDataStreams An array of strings. The strings must be not null. No further validation will be performed.
             * used during resolution do not allow such a case. 2. If the set of resolved concrete indices is empty and
         * Returns a ResolvedIndices.Local object associated with the given OriginalIndices object. This is only for
             * Returns the concrete indices. This might throw an exception if there were issues during index resolution.
        }
 * All methods which add/modify elements will return a new ResolvedIndices instance.
            return this.names;
             */
    /**
    /**
            }
         * information. This object will be only present if you add it to the object.
         * could not be determined. The methods from the Local super class, such as names(), still give
            @Override
             * Returns a new copy of this ResolvedIndices.Local.Concrete instances which has the given resolutionErrors
        public ResolvedIndices.Local withSubActions(ActionType<?> actionType, ResolvedIndices.Local local) {
            return false;
    /**
        }
         * Returns any OriginalIndices object associated with this object.
        public String[] asRawExpressionsArray() {
import java.util.List;
                }
 *     expression must be resolved using the appropriate index options; these might be request-specific or action-specific.</li>
         *
        /**
             * IndicesOptions.FORBID_ALIASES_TO_MULTIPLE_INDICES was set.
                Map.of(),
 *
            /**
         */
             * @throws org.opensearch.index.IndexNotFoundException This exception is thrown for several conditions:
        public Set<String> names() {
        }
        }
                    );
        public boolean containsAny(Predicate<String> namePredicate) {
             */
         * Creates a new instance.
             * IndicesOptions.FORBID_ALIASES_TO_MULTIPLE_INDICES was set.
 * </ul>
    /**
        }
             * @throws org.opensearch.index.IndexNotFoundException This exception is thrown for several conditions:
                        this.subActions,
        this.local = local;
        }
     * Returns a ResolvedIndices object associated with the given OriginalIndices object for the local part. This is only for
             * </ul>
 * A class that encapsulates resolved indices. Resolved indices do not any wildcards or date math expressions.
            for (Map.Entry<String, OriginalIndices> entry : this.clusterToOriginalIndicesMap.entrySet()) {
        private Remote(Map<String, OriginalIndices> clusterToOriginalIndicesMap) {
     * @param indicesAliasesAndDataStreams An array of strings. Any string that is null will be not included in this object. No further validation will be performed.
        return new ResolvedIndices(new Local(Set.copyOf(indicesAliasesAndDataStreams), null, Map.of()), Remote.EMPTY);
        /**
import java.util.ArrayList;
        public String[] namesAsArray() {
                Map<String, Local> subActions,
    public boolean isEmpty() {
     * as names().
     * Creates a ResolvedIndices object where local() returns the given Local object.
         * <p>
        /**
            /**
            private void checkResolutionErrors() {
     */
             * @throws IllegalArgumentException if one of the aliases resolved to multiple indices and
        protected final Map<String, Local> subActions;
         */
    private ResolvedIndices(Local local, Remote remote) {
             * Returns a new copy of this ResolvedIndices.Local.Concrete instances which does not have any resolutionErrors
            return names.stream().anyMatch(this.names::contains);
        @Override
                        result.add(name);
        private List<String> rawExpressions;
             * </ul>
     *
         * access to index information.
    }
         *
    }
     * by its concreteIndices() and namesOfConcreteIndices() method. The names() method will return the same names as
            @Override
         * Returns the remote clusters in the format ["remote_1:index_1", "remote_1:index_2", "remote_2:index_3"]
         */
}
    }
        }
        for (String index : indicesAliasesAndDataStreams) {
             */
                return this.concreteIndices().stream().map(Index::getName).toArray(String[]::new);
        }
            return result;
        }
