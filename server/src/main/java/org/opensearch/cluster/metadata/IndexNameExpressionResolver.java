            resolvedExpressions = expressionResolver.resolve(context, resolvedExpressions);
            IndicesOptions options,
     * @throws IllegalArgumentException if the index resolution does not lead to an index, or leads to more than one index
                throw new OpenSearchParseException(
                }
            if (isEmptyOrTrivialWildcard(expressions)) {
                            context.addResolutionError(indexNotFoundException(expression));
import java.time.ZoneOffset;
        boolean isPreserveAliases() {
     * Callers should make sure they provide proper {@link org.opensearch.action.support.IndicesOptions}
            Stream<Map.Entry<String, IndexAbstraction>> stream = indicesLookup.entrySet().stream();
    }
            if (Regex.isMatchAllPattern(expression)) {
        this.threadContext = Objects.requireNonNull(threadContext, "Thread Context must not be null");
                continue;
                if (failNoIndices) {
            );
import org.opensearch.core.common.Strings;
            boolean inDateFormat = false;
        return concreteIndexNames(context, request.indices());
                    // there is no good other place to perform this logic:
import org.opensearch.common.logging.DeprecationLogger;
    }
}
        return concreteResolvedIndices(state, options, false, indexExpressions);
     * @param aliasesOrIndices the array containing index names
                if (inPlaceHolder) {
        private static Map<String, IndexAbstraction> otherWildcard(Context context, Metadata metadata, String expression) {
    }
            this(state, options, System.currentTimeMillis(), isSystemIndexAccessAllowed);
        Set<String> resolvedExpressions
            if (options.ignoreAliases()) {
            }
                validateAliasOrIndex(context, expression);
                        default:
import java.util.HashSet;
        }
     * @return true if the provided array maps to all indices, false otherwise
            return true;
     * @param allowNoIndices    whether to allow resolve to no index
            }
                                routings.remove(concreteIndex);
                    }
        private final boolean preserveDataStreams;
    private void checkSystemIndexAccess(Context context, Metadata metadata, Set<Index> concreteIndices, String[] originalPatterns) {
            for (int i = from; i < length; i++) {
            ClusterState state,
            }
import java.util.stream.Stream;
            // treat aliases as unavailable indices when ignoreAliases is set to true (e.g. delete index and update aliases api)
     * Same as {@link #concreteIndices(ClusterState, IndicesOptions, String...)}, but the index expressions and options
        }
        final IndexMetadata indexMetadata = state.metadata().getIndices().get(index);
                resolvedSystemIndices.forEach(
 * not use this file except in compliance with the License.
            boolean isSystemIndexAccessAllowed
            false,
     */
        }
     * to access the concrete indices from the ResolvedIndices.Local.Concrete object. You can use the method
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(IndexNameExpressionResolver.class);
                String aliasOrIndexName = entry.getKey();
    ) {
        }
            state,
     * names() to access the names of the requested indices in a way that is safe from thrown exceptions due to
        }
                                    mathExpression = inPlaceHolderString.substring(0, dateTimeFormatLeftBoundIndex);
            request.includeDataStreams(),
        if (!context.resolutionErrors.isEmpty()) {
 * this work for additional information regarding copyright
        final Set<Index> concreteIndices = new HashSet<>(expressions.size());
    public String[] concreteIndexNamesWithSystemIndexAccess(ClusterState state, IndicesRequest request) {
                                inPlaceHolderSb.append(c);
            if (options.expandWildcardsOpen() && options.expandWildcardsClosed()) {
            finalExpressions = resolver.resolve(context, finalExpressions);
        private final IndicesOptions options;
    }
        for (AliasMetadata aliasMetadata : aliasCandidates) {
            IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(expression);
 * Licensed to Elasticsearch under one or more contributor
         * @return a new list with expressions based on the provided expressions
    @PublicApi(since = "3.1.0")
         * This is used to prevent resolving aliases to concrete indices but this also means
    /**
    }
            throw context.resolutionErrors.getFirst();
                            expressions.isEmpty() ? "_all" : expressions.get(0),
        ) {
            startTime,
        public static Map<String, IndexAbstraction> matches(Context context, Metadata metadata, String expression) {
     * @return the write index obtained as a result of the index resolution or null if no index
                excludeState = null;
     */
        /**
                preserveAliases,
                }
        this.threadContext = Objects.requireNonNull(threadContext, "Thread Context must not be null");
            IndicesOptions options = context.getOptions();
     * @param state             the cluster state containing all the data to resolve to expression to a concrete index
                            if (inDateFormat && escapedChar) {
                infe.setResources("index_expression", indexExpressions);
            false,
     * @param request           The request that defines how the an alias or an index need to be resolved to a concrete index
        if (isAllIndices(resolvedExpressions)) {
                                        inPlaceHolderString.length() - 1
        private static final String EXPRESSION_RIGHT_BOUND = ">";
         * concreteIndexNames(), concreteWriteIndex(), etc. will howe will throw the first resolution error that was
    }
                        new IllegalArgumentException(
                    } else {
public class IndexNameExpressionResolver {
     * @param startTime  The start of the request where concrete indices is being invoked for
import java.util.SortedMap;
         */
    /**
     * using this method, an {@link IllegalArgumentException} gets thrown otherwise.
        }
            }
     * @throws IndexNotFoundException if one of the index expressions is pointing to a missing index or alias and the
                    Set<String> resolvedIncludingDataStreams = new HashSet<>(resolvedExpressions);
 * KIND, either express or implied.  See the License for the
                    }
        private static final DateFormatter DEFAULT_DATE_FORMATTER = DateFormatter.forPattern("uuuu.MM.dd");
            options.expandWildcardsClosed(),
        }
            IndicesOptions options,
            .collect(Collectors.toList());
        return concreteWriteIndex(state, request.indicesOptions(), request.indices()[0], false, request.includeDataStreams());
            false,
    ResolvedIndices.Local.Concrete concreteResolvedIndices(Context context, String... indexExpressions) {
                String expression = expressions.get(i);
                if (Strings.isEmpty(expression)) {
            this.isSystemIndexAccessAllowed = isSystemIndexAccessAllowed;
                }
                                + "] has more than one index associated with it "
        if (indexMetadata == null) {
    }
     * @param options           defines how the aliases or indices need to be resolved to concrete indices
                    context.addResolutionError(aliasesNotSupportedException(expression));
            isSystemIndexAccessAllowed()
                                    }
    }
                        .entrySet()
        return concreteResolvedIndices(context, request.indices());
         * Used to determine if it is allowed to access system indices in this context (e.g. for this request).
            throw context.resolutionErrors.getFirst();
                    resolvedIncludingDataStreams.addAll(
            boolean resolveToWriteIndex,
                    String[] indexNames = new String[indexAbstraction.getIndices().size()];
        boolean allowNoIndices,
                .collect(Collectors.toList());
        }
                            }
            options.ignoreThrottled()
                }
        if (indices.length != 1) {
         * will continue until it is completed. However, after completion The methods concreteIndices(),
            }
            );
                                    if (inPlaceHolderString.lastIndexOf(RIGHT_BOUND) != inPlaceHolderString.length() - 1) {
            }
                } else {
    }
        }
    /**
            return filterIndicesLookup(context, subMap, null, context.getOptions());
            final IndexMetadata.State excludeState;
        Context context = new Context(state, options, isSystemIndexAccessAllowed());
                return otherWildcard(context, metadata, expression);
     * @return the resolved concrete indices based on the cluster state, indices options and index expressions
            IndicesOptions options
                    );
    }
         * This is used to require that aliases resolve to their write-index. It is currently not used in conjunction
            }
            paramRouting = Sets.newHashSet(Strings.splitStringByCommaToArray(routing));
        if (indexExpressions == null || indexExpressions.length == 0) {
 * license agreements. See the NOTICE file distributed with
                            } else {
        boolean excludedDataStreams = false;
     * @return the resolved concrete indices based on the cluster state, indices options and index expressions
     *
        }
        private static Set<String> expand(
            }
 *
     * @opensearch.internal
        }
        private static final char TIME_ZONE_BOUND = '|';
    public Set<String> resolveExpressions(ClusterState state, String... expressions) {
            return new ArrayList<>(result);
     * Translates the provided index expression into actual concrete indices, properly deduplicated.
                return ResolvedIndices.Local.Concrete.empty()
                            expand.add(indexAbstraction.getName());
        List<RuntimeException> getResolutionErrors() {
    }
     *                          and the expression that can be resolved to an alias or an index name.
                                        dateFormatterPattern = patternAndTZid;
    public Index[] concreteIndices(ClusterState state, IndicesRequest request, long startTime) {
                }
        return indexAliasesSize <= resolvedExpressionsSize;
                            r.addAll(aliasMetadata.searchRoutingValues());
    }
                }
                        result.remove(expression);
                            }
                    result.addAll(expand);
     * @param state             the cluster state containing all the data to resolve to expressions to concrete indices
        expressionResolvers.add(dateMathExpressionResolver);
        return Collections.unmodifiableSet(new HashSet<>(resolvedExpressions));
                    concreteIndices.add(writeIndex.getIndex());
     * Translates the provided index expression into actual concrete indices, properly deduplicated.
                            routings = new HashMap<>();
                                norouting.add(concreteIndex);
                                    if (dateTimeFormatLeftBoundIndex == inPlaceHolderString.length() - 2) {
                e -> Regex.simpleMatch(pattern, e.getKey()),
         *
            if (inPlaceHolder) {
     *
                                inPlaceHolderSb.append(c);
        Context(
    /**
                        beforePlaceHolderSb.append(c);
import org.opensearch.indices.IndexClosedException;
                throw new OpenSearchParseException("nothing captured");
                if (aliasOrIndexExists(context, options, metadata, expression)) {
                        for (IndexMetadata meta : indexAbstraction.getIndices()) {
            if (options.expandWildcardsOpen() && options.expandWildcardsClosed() && options.expandWildcardsHidden()) {
     */
        RuntimeException getFirstResolutionError() {
                                if (dateTimeFormatLeftBoundIndex < 0) {
            final int from = 1;
     * <b>NOTE</b>: The provided expressions must have been resolved already via {@link #resolveExpressions}.
                    switch (c) {
    }
        }
            return options;
                            break;
                    AliasMetadata aliasMetadata = item.v2();
        return concreteIndexNames(context, request.indices());
            boolean includeHidden
        /**
     * are encapsulated in the specified request.
            this(state, options, startTime, false, false, false, false, isSystemIndexAccessAllowed);
                    new String(text, from, length)
            Context context,
        private static void validateAliasOrIndex(Context context, String expression) {
     * <p>Only aliases with filters are returned. If the indices list contains a non-filtering reference to
                    // we would do many redundant checks, which would harm performance.
                            Set<String> r = routings.get(concreteIndex);
        protected Context(
            options.expandWildcardsHidden(),
        private static List<String> resolveEmptyOrTrivialWildcard(IndicesOptions options, Metadata metadata) {
                                beforePlaceHolderSb.append(c);
                            if (inDateFormat && escapedChar) {
    @PublicApi(since = "3.1.0")
                return ResolvedIndices.Local.Concrete.empty().withResolutionErrors(context.getResolutionErrors());
            acceptedExpressions.add(expression);
            throw new IllegalArgumentException(
        // or multiple indices are specified yield different behaviour.
            Set<String> expand = new HashSet<>();
            } else {
            StringBuilder inPlaceHolderSb = new StringBuilder();
        return dateMathExpressionResolver.resolveExpression(dateExpression, new Context(null, null, isSystemIndexAccessAllowed()));
            for (Map.Entry<String, IndexAbstraction> entry : matches.entrySet()) {
     *
        // option. At some point we should change this, because there shouldn't be a reason why whether a single index
        private final boolean preserveAliases;
            this(
        List<String> resolvedExpressions = Arrays.asList(expressions);
                .sorted() // reliable order for testing
                                    timeZone = ZoneOffset.UTC;
                options,
            }
                    }
                    result = new HashSet<>(expressions.subList(0, i));
        List<String> aliases = null;
                } else {
         * tracked with this method. The method concreteResolvedIndices() can be used to retrieve the resolution
                                    "invalid dynamic name expression [{}]." + " invalid character in placeholder at position [{}]",
                    throw new IndexClosedException(index.getIndex());
        }
            }
            for (String index : concreteIndices) {
    }
                                expand.add(meta.getIndex().getName());
            false,
            return startTime;
                        escape = false;
                return false;
                // Allows callers to handle IndexNotFoundException differently based on whether data streams were excluded.
                    // and WildcardExpressionResolver, which only checks the non-wildcard index names.
        public List<String> resolve(Context context, List<String> expressions) {
            return beforePlaceHolderSb.toString();
     */
                        if (routings == null) {
                        Set<String> r = new HashSet<>(paramRouting);
        return concreteResolvedIndices(state, request, startTime).concreteIndicesAsArray();
            } else if (options.expandWildcardsClosed() && options.expandWildcardsOpen() == false) {
        // type of index to use the `search_throttled` threadpool at that time.
            .map(x -> state.metadata().getIndicesLookup().get(x))
            if (indexAbstraction != null && indexAbstraction.getType() == IndexAbstraction.Type.ALIAS) {
            }
            final StringBuilder beforePlaceHolderSb = new StringBuilder();
     * Identifies whether the first argument (an array containing index names) is a pattern that matches all indices
                                DateFormatter dateFormatter;
                    if (paramRouting != null) {
     */
                        context.addResolutionError(e);
        }
                boolean escapedChar = escape;
                    );
            // otherwise we check if there's any simple regex
                false,
            return filterIndicesLookup(
     * to access the concrete indices from the ResolvedIndices.Local.Concrete object. You can use the method
            // or something like /-test1 with test1 index missing and IndicesOptions.lenient()
            return state;
            IndexNotFoundException infe = new IndexNotFoundException(expression);
                                routings.put(concreteIndex, r);
    private final ThreadContext threadContext;
import java.util.ArrayList;
        return concreteResolvedIndices(context, request.indices());
    public IndexNameExpressionResolver(ThreadContext threadContext) {
     * @return true if the provided array explicitly maps to all indices, false otherwise
     * @param state             the cluster state containing all the data to resolve to expressions to concrete indices
            } else if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM && context.includeDataStreams() == false) {
        return indexAliases(state, index, AliasMetadata::filteringRequired, false, resolvedExpressions);
                                }
     * @param indexExpressions  expressions that can be resolved to alias or index names.
            } else if (expression.indexOf("*") == expression.length() - 1) {
                                        dateTimeFormatLeftBoundIndex + 1,
                                inPlaceHolderSb.append(c);
                                        timeZone = ZoneOffset.UTC;
     */
        boolean isResolveToWriteIndex() {
                        expand(
                    // should be responsible only for wildcard expressions. However - given the current architecture -
                options,
                assert false : "this shouldn't get called if wildcards expand to none";
                if (Regex.isSimpleMatchPattern(expression) == false) {
                    // add all the previous ones...
            for (String expression : expressions) {
                if (context.includeDataStreams()) {
            List<String> result = new ArrayList<>(expressions.size());
                if (options.expandWildcardsClosed() == true && options.getExpandWildcards().size() == 1) {
     * @param indicesOrAliases the array containing index names
            return preserveDataStreams;
                    if (escapedChar) {
        private final List<RuntimeException> resolutionErrors = new ArrayList<>();
    /**
        return concreteIndices(state, options, false, indexExpressions);
        private final long startTime;
            .filter(ia -> ia.getType() == IndexAbstraction.Type.DATA_STREAM)
                                    if (routings != null) {
        private static IndexMetadata.State excludeState(IndicesOptions options) {
        /**
        // TODO: it appears that this can never be true?
        private Set<String> innerResolve(Context context, List<String> expressions, IndicesOptions options, Metadata metadata) {
                            if (routings == null) {
 */
         * that isn't required). The provided implementations can also be left untouched.
 */
                    }
            } else if (indexAbstraction.getType() == IndexAbstraction.Type.ALIAS && context.getOptions().ignoreAliases()) {
    }
        }
     * encountered during the resolution will be not thrown immediately as an exception, but only when you try
                            // Routing alias
                                            "invalid dynamic name expression [{}]. missing closing `}`" + " for date math format",
    /**
        Context context = new Context(state, options, false, false, includeDataStreams, isSystemIndexAccessAllowed());
            ClusterState state,
        private boolean isEmptyOrTrivialWildcard(List<String> expressions) {
                                String mathExpression;
     * @return routing values grouped by concrete index
    }
                                    );
     * the index itself - null is returned. Returns {@code null} if no filtering is required.
                                + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"
import java.util.stream.Collectors;
         * Returns the currently encountered resolution errors.
        Set<String> paramRouting = null;
     *
            return expressions.isEmpty()
        if (routings == null || routings.isEmpty()) {
                    if (indexExpressions[0].equals(Metadata.ALL)) {
        // List of indices that don't require any routing
                                    String patternAndTZid = inPlaceHolderString.substring(
        return new ArrayList<>(this.expressionResolvers);
    /**
        private final boolean isSystemIndexAccessAllowed;
            }
            // we might have something like /-test1,+test1 that would identify all indices
     *
    /**
            options.ignoreUnavailable(),
         */
        return concreteResolvedIndices(context, indexExpressions).namesOfConcreteIndicesAsArray();
        }
                context.addResolutionError(new InvalidIndexNameException(expression, "must not start with '_'."));
                                    new String(text, from, length),
                .map(metadata::index)
        if (allowNoIndices && indices.length == 0) {
    public ResolvedIndices.Local.Concrete concreteResolvedIndices(ClusterState state, IndicesRequest request) {
                    aliases = new ArrayList<>();
     */
                    continue;
     * contains no indices and the indices options in the context don't allow such a case.
                        "To expand [" + index.getState() + "] wildcard, please set forbid_closed_indices to `false`"
     * resolution errors.
            request.indicesOptions(),
                                + ", can't execute a single index op"
                return stream.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
import org.opensearch.index.IndexNotFoundException;
        /**
                        if (!aliasMetadata.searchRoutingValues().isEmpty()) {
            } else if (options.expandWildcardsOpen() && options.expandWildcardsHidden()) {
                }
        return ((dataStreams == null) ? List.<String>of() : dataStreams).stream()
            ClusterState state,
        if (aliases == null) {
                                        );
            } else {
                            if (paramRouting != null) {
/*
                if (aliases == null) {
    public static final String EXCLUDED_DATA_STREAMS_KEY = "opensearch.excluded_ds";
            boolean preserveDataStreams,
            allowNoIndices,
                    infe = new IndexNotFoundException((String) null);
        return Booleans.parseBoolean(threadContext.getHeader(SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY), true);
        private final boolean resolveToWriteIndex;
        boolean skipIdentity,
                        if (routings != null) {
            } else {
     */
    /**
                    if (context.isPreserveAliases() && indexAbstraction.getType() == IndexAbstraction.Type.ALIAS) {
            return null;
        }
                        .stream()
        Context context = new Context(state, IndicesOptions.lenientExpandOpen(), false, false, true, isSystemIndexAccessAllowed());
        Context(
     * Determines whether or not system index access should be allowed in the current context.
        }
                                    } else {
                                + Arrays.toString(indexNames)
                aliases.add(aliasMetadata.alias());
                                        throw new OpenSearchParseException(
            } else {
    private final List<ExpressionResolver> customResolvers = new ArrayList<>();
        if (routing != null) {
            // throw a specific error that is different from the [[IndexNotFoundException]], which is typically thrown
                                    Set<String> r = new HashSet<>(paramRouting);
                    // This might seem to be non-intuitive, as we are in the class WildcardExpressionResolver which
                    result.removeAll(expand);
        List<String> finalExpressions = Arrays.asList(indexExpressions);
                }
            if (this.resolutionErrors.isEmpty()) {
            "The provided expression [" + expression + "] matches an " + "alias, specify the corresponding concrete indices instead."
        );
                // If required - add it to the list of aliases
     * given index.
                }
import java.util.HashMap;
        return concreteResolvedIndices(context, indexExpressions);
                    throw new IllegalArgumentException(
                                    i
                            break;
        return concreteResolvedIndices(context, indexExpressions).concreteIndicesAsArray();
                if (failNoIndices) {
 */
            return null;
    public Index[] concreteIndices(ClusterState state, IndicesRequest request) {
     * <p><b>NOTE</b>: the provided expressions must have been resolved already via {@link #resolveExpressions}.
                preserveAliases,
    Index[] concreteIndices(Context context, String... indexExpressions) {
                System.currentTimeMillis(),
                return Arrays.asList(metadata.getConcreteAllOpenIndices());
            return preserveAliases;
        if (iterateIndexAliases(indexAliases.size(), resolvedExpressions.size())) {
        return new IllegalArgumentException(
        public void addResolutionError(RuntimeException resolutionError) {
     * Identifies whether the array containing index names given as argument refers to all indices
                    add = false;
     * Sets the same routing for all indices
            if (options.forbidClosedIndices() && options.ignoreUnavailable() == false) {
                        default:
    private static boolean addIndex(IndexMetadata metadata, Context context) {
            boolean resolveToWriteIndex,
     * indices options in the context don't allow such a case.
                            concreteIndices.add(index.getIndex());
        return concreteResolvedIndices(state, request).concreteIndicesAsArray();
        public IndicesOptions getOptions() {
        expressionResolvers.add(wildcardExpressionResolver);
    }
            }
            this.state = state;
        return concreteIndexNames(context, request.indices());
                return Arrays.asList(metadata.getConcreteVisibleIndices());
            options.ignoreAliases(),
     * @throws IndexNotFoundException if one of the index expressions is pointing to a missing index or alias and the
    public List<String> dataStreamNames(ClusterState state, IndicesOptions options, String... indexExpressions) {
        } else {
/*
                                    routings.put(concreteIndex, r);
        private static final char LEFT_BOUND = '{';
    /**
        }
            return result;
            return null;
                        if (shouldTrackConcreteIndex(context, options, index)) {
        return concreteIndexNames(context, indexExpressions);
                return Arrays.asList(metadata.getConcreteAllClosedIndices());
                    }
            }
                    context.addResolutionError(indexNotFoundException(expression));
                            dataStreamsAbstractions,
            for (int i = 0; i < expressions.size(); i++) {
        Context context = new Context(
     * are encapsulated in the specified request and resolves data streams.
            options.forbidClosedIndices(),
     * Whether to generate the candidate set from index aliases, or from the set of resolved expressions.
                        )
     * @return the resolved concrete indices based on the cluster state, indices options and index expressions. Any errors
        ClusterState state,
                char c = text[i];
                }
     */
                excludeState = null;
        customResolvers.addAll(resolvers);
            isSystemIndexAccessAllowed()
        }
            return resolveSearchRoutingAllIndices(state.metadata(), routing);
                        }
    public ResolvedIndices.Local.Concrete concreteResolvedIndices(ClusterState state, IndicesRequest request, long startTime) {
     */
            char[] toPrefixCharArr = fromPrefix.toCharArray();
     * Context for the resolver.
                    // dedup backing indices if expand hidden indices option is true
                continue;
                if (writeIndex == null) {
     * @param state             the cluster state containing all the data to resolve to expression to a concrete index
    }
            } else if (options.expandWildcardsClosed()) {
                excludeState = IndexMetadata.State.OPEN;
            IndexNotFoundException infe = new IndexNotFoundException((String) null);
        }
            long startTime,
import org.opensearch.common.time.DateFormatter;
                metadata.getIndicesLookup(),
     * Utility method that allows to resolve an index expression to its corresponding single concrete index.
                    if (options.ignoreUnavailable() == false) {
                            } else {
            boolean isSystemIndexAccessAllowed
 * compatible open source license.
                            + "indices will be prevented by default",
                for (Tuple<String, AliasMetadata> item : alias.getConcreteIndexAndAliasMetadatas()) {
                    add = true;
        ) {
        }
        }
import java.util.Objects;
                                }
        String... indexExpressions
                    for (IndexMetadata indexMetadata : indexAbstraction.getIndices()) {
    public ResolvedIndices.Local.Concrete concreteResolvedIndices(
                            if (escapedChar) {
     * @return If the specified string is data math expression then this method returns the resolved expression.
                if (expression.charAt(0) == '-' && wildcardSeen) {
            final int length = text.length - 1;
    /**
                    .withResolutionErrors(context.getResolutionErrors())
            state,
                        "open_system_index_access_" + systemIndexName,
import org.opensearch.common.annotation.PublicApi;
                    } else {
                .toArray(AliasMetadata[]::new);
        private static Map<String, IndexAbstraction> suffixWildcard(Context context, Metadata metadata, String expression) {
import org.opensearch.core.common.util.CollectionUtils;
                    context.addResolutionError(infe);
            aliasCandidates = resolvedExpressions.stream().map(indexAliases::get).filter(Objects::nonNull).toArray(AliasMetadata[]::new);
                                inPlaceHolder = false;
                        infe = new IndexNotFoundException(expression);
     */
                                );
            request.includeDataStreams(),
                    }
                IndexAbstraction.Alias alias = (IndexAbstraction.Alias) indexAbstraction;
        }
        expressionResolvers.add(dateMathExpressionResolver);
            );
                                + expression
                || (expressions.size() == 1 && (Metadata.ALL.equals(expressions.get(0)) || Regex.isMatchAllPattern(expressions.get(0))));
                        infe = new IndexNotFoundException("no indices exist", expression);
                    escape = false;
    public Index concreteWriteIndex(
            String fromPrefix = expression.substring(0, expression.length() - 1);
                acceptedExpressions.add(expression);
@PublicApi(since = "1.0.0")
            this.startTime = startTime;
                    IndexNotFoundException infe;
                isSystemIndexAccessAllowed
    }
     *
        for (ExpressionResolver expressionResolver : expressionResolvers) {
import org.opensearch.core.index.Index;
        @SuppressWarnings("fallthrough")
        }
        List<String> dataStreams = wildcardExpressionResolver.resolve(context, finalExpressions);
    /**
                }
 *
        );
                        } else {
            Map<String, Set<String>> routings = new HashMap<>();
 *
            String expression,
        /**
 * GitHub history for details.
         */
            return addIndex(index, context);
                                r.retainAll(paramRouting);
                    // The following code enforces the ignoreUnavailable rule for non-wildcard expressions.
        } else {
                routings.put(index, r);
    }
                return this.resolutionErrors.getFirst();
        Context(ClusterState state, IndicesOptions options, long startTime, boolean isSystemIndexAccessAllowed) {
            Set<String> result = null;
                return true;
            // expand to hidden
            infe.setResources("index_or_alias", expression);
                                inDateFormat = true;
        Context context = new Context(state, request.indicesOptions(), false, false, request.includeDataStreams(), true);
        }
    }
import java.util.Arrays;
        } else if (index.getState() == IndexMetadata.State.OPEN) {
                return false;
     * @param state             the cluster state containing all the data to resolve to expression to a concrete index
            false,
                                    int formatPatternTimeZoneSeparatorIndex = patternAndTZid.indexOf(TIME_ZONE_BOUND);
        }
                shouldConsumeStream = true;
                includeDataStreams,
     * Translates the provided index expression into actual concrete indices, properly deduplicated.
import java.util.stream.StreamSupport;
                    }
                return indicesLookup;
            if (indexAbstraction == null) {
            return itemName.startsWith(".") && expression.startsWith(".") && Regex.isSimpleMatchPattern(expression);
            if (resolvedSystemIndices.isEmpty() == false) {
                    String concreteIndex = item.v1();
                                + " indices without one being designated as a write index"
                            }
            boolean includeDataStreams,
                                        );
            indexExpressions = new String[] { Metadata.ALL };
                // Index
        }
     * names() to access the names of the requested indices in a way that is safe from thrown exceptions due to
        private final boolean includeDataStreams;
    public Map<String, Set<String>> resolveSearchRoutingAllIndices(Metadata metadata, String routing) {
         * Note: This is on purpose package private. External resolvers should have no need to inspect the
                // If not, we have a non required alias for this index - no further checking needed
    }
                                + indexAbstraction.getName()
            } else {
    public static final String SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY = "_system_index_access_allowed";
        );
                                    }
            return excludeState;
        // If only one index is specified then whether we fail a request if an index is missing depends on the allow_no_indices
                shouldConsumeStream = true;
            // does not exist and the path is interpreted as an expression. If the expression begins with an underscore,
                                r = new HashSet<>();
                            excludeState,
 * Unless required by applicable law or agreed to in writing,
     * Iterates through the list of indices and selects the effective list of required aliases for the given index.
    public String[] concreteIndexNames(ClusterState state, IndicesOptions options, IndicesRequest request) {
                }
    }
        return indices[0];
        // otherwise it will throw exception in case it cannot resolve any keywords which are expected to be handled
        }
        }
        public boolean includeDataStreams() {
     */
                                );
    }
                                    "invalid dynamic name expression [{}]."
    }
            }
                if (c == ESCAPE_CHAR) {
                preserveDataStreams,
                                String time = formatter.format(instant);
            } else if (options.expandWildcardsOpen() && options.expandWildcardsClosed()) {
     * @throws IllegalArgumentException if one of the aliases resolve to multiple indices and the provided
                                        dateFormatterPattern = patternAndTZid.substring(0, formatPatternTimeZoneSeparatorIndex);
                        case LEFT_BOUND:
            boolean preserveAliases,
                    if (add) {
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
import org.opensearch.indices.InvalidIndexNameException;
                        case RIGHT_BOUND:
                resolveToWriteIndex,
        return null;
            false,
                                        + " invalid character at position [{}]. `{` and `}` are reserved characters and"
        }
    }
        }
                            if (!norouting.contains(concreteIndex)) {
            boolean shouldConsumeStream = false;
        String index,
    public Index[] concreteIndices(ClusterState state, IndicesOptions options, boolean includeDataStreams, String... indexExpressions) {
 * under the License.
            if (indexAbstraction.getType() == IndexAbstraction.Type.ALIAS && options.ignoreAliases()) {
            if (indexAbstraction.getType() == IndexAbstraction.Type.ALIAS && context.isResolveToWriteIndex()) {
import org.opensearch.common.Booleans;
import java.time.Instant;
            expressions = expressionResolver.resolve(context, expressions);
                        result.add(expression);
    public String[] indexAliases(
        }
import java.util.Collection;
    public Index concreteWriteIndex(ClusterState state, IndicesRequest request) {
            this.options = options;
            boolean inPlaceHolder = false;
                return null;
        // The data math expression resolver doesn't rely on cluster state or indices options, because
    public boolean isSystemIndexAccessAllowed() {
                    } catch (IndexClosedException e) {
            context.addResolutionError(infe);
    public String[] concreteIndexNames(ClusterState state, IndicesOptions options, boolean includeDataStreams, String... indexExpressions) {
                                        routings.remove(concreteIndex);
            assert expression.length() >= 2 : "expression [" + expression + "] should have at least a length of 2";
                        IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(expression);
import org.opensearch.action.IndicesRequest;
                                + " ["
            );
import org.opensearch.common.util.concurrent.ThreadContext;
 * @opensearch.api
        Context context = new Context(state, options, false, false, request.includeDataStreams(), isSystemIndexAccessAllowed());
        }
        if (concreteIndices.length == metadata.getConcreteAllIndices().length && indicesOrAliases.length > 0) {
                    wildcardSeen = true;
     * @throws IllegalArgumentException if one of the aliases resolve to multiple indices and the provided
import org.opensearch.OpenSearchParseException;
     * contains no indices and the indices options in the context don't allow such a case.
                if (indexExpressions.length == 1) {
                            inPlaceHolderSb.append(c);
        // it just resolves the date math to an actual date.
                        }
 * The OpenSearch Contributors require contributions made to
    public static boolean isAllIndices(Collection<String> aliasesOrIndices) {
        return indices[0];
        }
            } else {
        private static final char ESCAPE_CHAR = '\\';
        expressionResolvers.add(wildcardExpressionResolver);
                }
        @Override
                        systemIndexName
                            } else if (inDateFormat) {
        if (!context.resolutionErrors.isEmpty()) {
        private static Map<String, IndexAbstraction> filterIndicesLookup(
            } else if (options.expandWildcardsClosed() && options.expandWildcardsHidden()) {
                }
            // only check open/closed since if we do not expand to open or closed it doesn't make sense to
            boolean includeDataStreams,
    public interface ExpressionResolver {
     * @opensearch.internal
        }
                isSystemIndexAccessAllowed
        // trappy to hide throttled indices by default. In order to avoid breaking backward compatibility,
                    }
        // Set custom resolvers to the top of the list to ensure to WildcardExpressionResolver is triggered at the end,
        private static final String EXPRESSION_LEFT_BOUND = "<";
            throw context.resolutionErrors.getFirst();
                result.add(resolveExpression(expression, context));
                                    i
    }
         */
            return isSystemIndexAccessAllowed;
            } else {
    public static class Context {
         */
        }
            } else if (options.expandWildcardsOpen()) {
                        if (context.isPreserveDataStreams() && indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM) {
                    } else {
        }
            return routings;
                continue;
        );
        // Allow system index access - they'll be filtered out below as there's no such thing (yet) as system data streams
    private final WildcardExpressionResolver wildcardExpressionResolver = new WildcardExpressionResolver();
            } else {
            toPrefixCharArr[toPrefixCharArr.length - 1]++;
                        } else if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM
                    continue;
     *
            boolean escape = false;
        Context context = new Context(state, IndicesOptions.lenientExpandOpen(), false, false, true, isSystemIndexAccessAllowed());
    /**
        @Override
                            }
            } else if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM && context.isResolveToWriteIndex()) {
        // we changed it to look at the `index.frozen` setting instead, since frozen indices were the only
                final boolean add;
            boolean resolveToWriteIndex,
        for (String expression : expressions) {
    ) {
        return false;
            }
    static final class WildcardExpressionResolver implements ExpressionResolver {
                Set<String> expand = expand(context, excludeState, matches, expression, options.expandWildcardsHidden());
                .filter(IndexMetadata::isSystem)
     * @param request    request containing expressions that can be resolved to alias, index, or data stream names.
                    }
                shouldConsumeStream = true;
                                context.addResolutionError(indexNotFoundException(expression));
            this.preserveAliases = preserveAliases;
        if (indexExpressions == null || indexExpressions.length == 0) {
     * indices options in the context don't allow such a case.
        }
                } else {
        }
            options.expandWildcardsOpen(),
            indexExpressions = new String[] { "*" };
            final String pattern = expression;
            resolvedExpressions = expressionResolver.resolve(context, resolvedExpressions);
                } else {
                } else {
        List<String> resolve(Context context, List<String> expressions);
                        "this request accesses system indices: [{}], but in a future major version, direct access to system "
            state,
            return resolveToWriteIndex;
                                beforePlaceHolderSb.append(time);
import org.opensearch.common.Nullable;
            // faster to iterate indexAliases
            // Expressions can not start with an underscore. This is reserved for APIs. If the check gets here, the API
     * Iterates through the list of indices and selects the effective list of filtering aliases for the
                            }
        if (context.isSystemIndexAccessAllowed() == false) {
    public String[] concreteIndexNames(ClusterState state, IndicesOptions options, String... indexExpressions) {
            boolean preserveDataStreams,
                    // - We cannot perform it before the resolver chain, as we still might have expressions which we
 * ownership. Elasticsearch licenses this file to you under
                if (Regex.isSimpleMatchPattern(indexOrAlias)) {
                            if (r.isEmpty()) {
                                int dateTimeFormatLeftBoundIndex = inPlaceHolderString.indexOf(LEFT_BOUND);
        ClusterState state,
     *
     * The empty or null array doesn't explicitly map to all indices
        ) {
            } else {
    public String[] filteringAliases(ClusterState state, String index, Set<String> resolvedExpressions) {
                                Instant instant = dateMathParser.parse(mathExpression, context::getStartTime, false, timeZone);
                        } else if (indexAbstraction.getType() == IndexAbstraction.Type.ALIAS && options.ignoreAliases()) {
                                    }
            this.includeDataStreams = includeDataStreams;
    /**
        }
                }
    // pkg-private for testing
        public boolean isPreserveDataStreams() {
     * @param request           The request that defines how the an alias or an index need to be resolved to a concrete index
                        }
     */
/**
                    continue;
            if (requiredAlias.test(aliasMetadata)) {
     */
     * provided indices options in the context don't allow such a case, or if the final result of the indices resolution
        }
 * SPDX-License-Identifier: Apache-2.0
                    // will have expanded wildcards to potentially many indices. If we did these checks then,
                return Arrays.asList(metadata.getConcreteVisibleClosedIndices());
            .filter(Objects::nonNull)
    }
                                        throw new OpenSearchParseException(
                        new IllegalArgumentException(
            String[] concreteIndices = metadata.getConcreteAllIndices();
                                + "]."
            // if the expression can't be found.
            options.allowAliasesToMultipleIndices(),
     */
                            if (r == null) {
            throw new IllegalArgumentException(
                IndexMetadata writeIndex = indexAbstraction.getWriteIndex();
                                inPlaceHolderSb = new StringBuilder();
    public boolean hasIndexAbstraction(String indexAbstraction, ClusterState state) {
                                            inPlaceHolderString
    String[] concreteIndexNames(Context context, String... indexExpressions) {
     * @param startTime  The start of the request where concrete indices is being invoked for
                includeDataStreams,
     * @return the resolved concrete indices based on the cluster state, indices options and index expressions. Any errors
                }
     */
            if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM && context.includeDataStreams() == false) {
                return Collections.emptyList();
        return concreteResolvedIndices(state, options, includeDataStreams, indexExpressions).concreteIndicesAsArray();
                    systemIndexName -> deprecationLogger.deprecate(
     *
     * or aliases with no routing defined the specified routing is used.
            isSystemIndexAccessAllowed()
                return Arrays.asList(metadata.getConcreteVisibleOpenIndices());
                return false;
                        infe = new IndexNotFoundException("no indices exist", (String) null);
                            break;
                    infe.setResources("index_expression", expression);
                    try {
     * Identifies whether the array containing index names given as argument explicitly refers to all indices
        Context context = new Context(state, combinedOptions, false, true, includeDataStreams, isSystemIndexAccessAllowed());
     */
import java.util.Spliterators;
                IndexAbstraction indexAbstraction = entry.getValue();
            }
        ) {
     * A date math expression resolver.
     *
        }
        IndicesOptions options,
    }
                    continue;
                stream = stream.filter(e -> e.getValue().getType() != IndexAbstraction.Type.ALIAS);
            }
        boolean includeDataStreams
                    if (expression.equals(Metadata.ALL)) {
                return expressions;
        Context context = new Context(state, options, false, false, true, true, true);
            Set<String> r = Sets.newHashSet(Strings.splitStringByCommaToArray(routing));
            IndicesOptions options,
                            context.addResolutionError(aliasesNotSupportedException(expression));
        );
                                        timeZone = DateUtils.of(patternAndTZid.substring(formatPatternTimeZoneSeparatorIndex + 1));
                    return new ArrayList<>(resolvedIncludingDataStreams);
     * the index itself - null is returned. Returns {@code null} if no filtering is required.
        if (request.indices() == null || (request.indices() != null && request.indices().length != 1)) {
         * Adds a new error encountered while resolving index resolution. If this method is used, index resolution
        private static boolean implicitHiddenMatch(String itemName, String expression) {
     * @opensearch.internal
        }
         * @param resolutionError the encountered resolution error. Ideally this extends OpenSearchException.
            return null;
 * software distributed under the License is distributed on an
     * @throws IllegalArgumentException if one of the aliases resolve to multiple indices and the provided
                );
                                    }
     * @param index             index that can be resolved to alias or index name.
 * the Apache License, Version 2.0 (the "License"); you may
                                throw new OpenSearchParseException(
            Metadata metadata = context.getState().metadata();
        IndicesOptions combinedOptions = IndicesOptions.fromOptions(
     * @param request    request containing expressions that can be resolved to alias, index, or data stream names.
        final Map<String, AliasMetadata> indexAliases = indexMetadata.getAliases();
    // Visible for testing
                excludedDataStreams = true;
     * that require a single index as a result. The indices resolution must in fact return a single index when
                return null;
            } else {
    }
        if (routing != null) {
            }
                if (escape) {
            request.indicesOptions(),
                return resolvedExpressions;
            }
                                throw new OpenSearchParseException(
                        )
    /**
                if (addIndex(writeIndex, context)) {
        expressionResolvers = new ArrayList<>(customResolvers);
 *     http://www.apache.org/licenses/LICENSE-2.0
        public boolean isSystemIndexAccessAllowed() {
            if (indexAbstraction == null) {
                System.currentTimeMillis(),
        }
    }
        Context context = new Context(state, IndicesOptions.lenientExpandOpen(), true, false, true, isSystemIndexAccessAllowed());
        }
            .map(IndexAbstraction::getName)
            boolean preserveAliases,
     * Resolves alias/index name expressions with wildcards into the corresponding concrete indices/aliases
         * result without a thrown exception.
     * encountered during the resolution will be not thrown immediately as an exception, but only when you try
 *
     * @param state      the cluster state containing all the data to resolve to expressions to concrete indices
import java.util.Set;
                                inPlaceHolderSb.append(c);
                IndexMetadata writeIndex = indexAbstraction.getWriteIndex();
     * @return the resolved concrete indices based on the cluster state, indices options and index expressions
    }
        }
     * @param state      the cluster state containing all the data to resolve to expressions to concrete indices
        return ResolvedIndices.Local.Concrete.of(concreteIndices, acceptedExpressions).withResolutionErrors(context.getResolutionErrors());
                            options.expandWildcardsHidden()
                "unable to return a single index as the index and options" + " provided got resolved to multiple indices"
    /**
            // faster to iterate resolvedExpressions
                if (add) {
                    }
                    } else {
                            routings.remove(expression);
                                        routings = new HashMap<>();
        public List<String> resolve(final Context context, List<String> expressions) {
        return state.metadata().getIndicesLookup().containsKey(resolvedAliasOrIndex);
     * @throws IllegalArgumentException if the index resolution does not lead to an index, or leads to more than one index
                    }
            throw new IndexNotFoundException(index);
                                            "invalid dynamic name expression [{}]. missing date format",
     */
import org.opensearch.cluster.ClusterState;
                context.getOptions()
            }
    }
        final boolean failNoIndices = indexExpressions.length == 1 ? !options.allowNoIndices() : !options.ignoreUnavailable();
        // This used to check the `index.search.throttled` setting, but we eventually decided that it was
        return aliases.toArray(new String[0]);
     */
     * are encapsulated in the specified request and resolves data streams.
import org.opensearch.common.time.DateUtils;
                    if (result != null) {
    /**
        String index,
        return routings;
            return expand;
                } else {
                            if (!escapedChar) {
                }
    /**
            this.resolutionErrors.add(resolutionError);
    public ResolvedIndices.Local.Concrete concreteResolvedIndices(ClusterState state, IndicesOptions options, String... indexExpressions) {
                    }
                        infe = new IndexNotFoundException((String) null);
            this.resolveToWriteIndex = resolveToWriteIndex;
    ) {
    }
     * Same as {@link #concreteIndices(ClusterState, IndicesOptions, String...)}, but the index expressions and options
                    context.addResolutionError(
        return aliasesOrIndices == null || aliasesOrIndices.isEmpty() || isExplicitAllPattern(aliasesOrIndices);
                if (indexAbstraction.getIndices().size() > 1 && !options.allowAliasesToMultipleIndices()) {
     * @param aliasesOrIndices the array containing index names
                                } else {
     * Expression resolver for index name expressions.
    }
            }
                    continue;
            return includeDataStreams;
            // Shouldn't happen
                                final ZoneId timeZone;
                    }
                "The index expression [" + index + "] and options provided did not point to a single write-index"
                                    mathExpression = inPlaceHolderString;
        Index[] indices = concreteIndices(context, index);
    public Index[] concreteIndices(ClusterState state, IndicesOptions options, String... indexExpressions) {
 * Resolves index name from an expression
                stream = stream.filter(e -> e.getValue().getType() != IndexAbstraction.Type.DATA_STREAM);
import org.opensearch.common.time.DateMathParser;
            }
                final Map<String, IndexAbstraction> matches = matches(context, metadata, expression);
 * You may obtain a copy of the License at
        return concreteIndexNames(context, indexExpressions);
     * @param indexExpressions  expressions that can be resolved to alias or index names.
                                DateMathParser dateMathParser = formatter.toDateMathParser();
     * contains no indices and the indices options in the context don't allow such a case.
                                    dateFormatter = DateFormatter.forPattern(dateFormatterPattern);
            SortedMap<String, IndexAbstraction> subMap = metadata.getIndicesLookup().subMap(fromPrefix, toPrefix);
    }
import org.opensearch.common.regex.Regex;
                    "invalid dynamic name expression [{}]. date math placeholder is open ended",
                state,
                return options.forbidClosedIndices() == false && addIndex(index, context);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (result == null) {
    }
        }
    /**
    /**
        private final ClusterState state;
            boolean includeDataStreams,
        ClusterState state,
                    } else {
    /**
            return infe;
    }
                }
                    // - We cannot perform it efficiently after the resolver chain, as then the WildcardExpressionResolver
                context,
                    // The only more or less sensible way out might be a new resolver between DateMathExpressioResolver
        public long getStartTime() {
     * indices options in the context don't allow such a case.
import java.util.Collections;
                                    if (routings == null) {
            if (!options.allowNoIndices()) {
        Set<String> norouting = new HashSet<>();
                    final IndexMetadata.State excludeState = excludeState(options);
     */
            final List<String> resolvedSystemIndices = concreteIndices.stream()
    }
                    context.addResolutionError(
            this.preserveDataStreams = preserveDataStreams;
            return null;
                            if (excludeState == null || meta.getState() != excludeState) {
import java.util.List;
    }
         * that we might return aliases that point to a closed index. This is currently only used
            false,
                                inPlaceHolder = true;
                        expand.add(aliasOrIndexName);
                excludeState = IndexMetadata.State.CLOSE;
                    if (!norouting.contains(concreteIndex)) {
            }
    public List<ExpressionResolver> getExpressionResolvers() {
    /**
                        escape = true;
        Predicate<AliasMetadata> requiredAlias,
                List<String> resolvedExpressions = resolveEmptyOrTrivialWildcard(options, metadata);
                        }
                    expression = expression.substring(1);
     * @return the concrete index obtained as a result of the index resolution
                        indexNames[i++] = indexMetadata.getIndex().getName();
                        .filter(entry -> entry.getValue().getType() == IndexAbstraction.Type.DATA_STREAM)
    /**
                for (IndexMetadata index : indexAbstraction.getIndices()) {
            aliasCandidates = StreamSupport.stream(Spliterators.spliteratorUnknownSize(indexAliases.values().iterator(), 0), false)
        if (isAllIndices(resolvedExpressions)) {
     * Resolves the search routing if in the expression aliases are used. If expressions point to concrete indices
        String resolveExpression(String expression, final Context context) {
                stream = stream.filter(filter);
     * @param state             the cluster state containing all the data to resolve to expressions to concrete indices
            }
     */
        if (index.getState() == IndexMetadata.State.CLOSE) {
        }
                                    if (formatPatternTimeZoneSeparatorIndex != -1) {
            String toPrefix = new String(toPrefixCharArr);
                    context.addResolutionError(indexNotFoundException(expression));
     */
        expressionResolvers = new ArrayList<>();
         */
        }
        }
    }
                }
        boolean includeDataStreams,
            request.indicesOptions(),
     * @param options           defines how the aliases or indices need to be resolved to concrete indices
     * resolution errors.
            if (expression.charAt(0) == '_') {
import org.opensearch.common.collect.Tuple;
                            }
        Context context = new Context(
 */
                        result.add(expression);
            );
                        concreteIndices.add(writeIndex.getIndex());
        IndicesOptions options,
                    );
                return expressions;
        Context context = new Context(state, options, false, false, includeDataStreams, isSystemIndexAccessAllowed());
            }
     * @return whether the specified index, data stream or alias exists.
         * with <code>preserveAliases</code>.
                                } else {
        for (ExpressionResolver expressionResolver : expressionResolvers) {
        /**
                                            inPlaceHolderString
     */
        Metadata metadata = context.getState().metadata();
            if (excludedDataStreams) {
            } else if (options.expandWildcardsOpen() && options.expandWildcardsClosed() == false) {
                if (Regex.isSimpleMatchPattern(expression)) {
    public String resolveDateMathExpression(String dateExpression) {
     * Translates the provided index expression into actual concrete indices, properly deduplicated.
                    switch (c) {
            if (beforePlaceHolderSb.length() == 0) {
                            } else {
                                if (paramRouting != null) {
                        if (indexAbstraction == null) {
     *
                    final Map<String, IndexAbstraction> dataStreamsAbstractions = metadata.getIndicesLookup()
                return Arrays.asList(metadata.getConcreteAllIndices());
     * The empty or null array identifies all indices
         *
                            }
                .filter(aliasMetadata -> resolvedExpressions.contains(aliasMetadata.alias()))
            if (shouldConsumeStream) {
                final IndexMetadata.State excludeState = excludeState(options);
        for (String expression : resolvedExpressions) {
                                        + " should be escaped when used as part of the index name using `\\` (e.g. `\\{text\\}`)",
                resolveToWriteIndex,
     */
     * Utility method that allows to resolve an index expression to its corresponding single write index.
     *
     * @param options           defines how the aliases or indices need to be resolved to concrete indices
        return aliasesOrIndices != null && aliasesOrIndices.size() == 1 && Metadata.ALL.equals(aliasesOrIndices.iterator().next());
            this(
     * Resolve an array of expressions to the set of indices and aliases that these expressions match.
     * Same as {@link #concreteIndexNames(ClusterState, IndicesRequest)}, but access to system indices is always allowed.
                            indexAbstraction.getType().getDisplayName()
import java.util.function.Predicate;
    /**
                        }
        for (ExpressionResolver expressionResolver : expressionResolvers) {
     * @param indexExpressions  expressions that can be resolved to alias or index names.
     *
     *         If the data stream, index or alias contains date math then that is resolved too.
            }
import java.time.ZoneId;
        }
        for (ExpressionResolver resolver : customResolvers) {
         * present resolution errors.
    /**
                                String inPlaceHolderString = inPlaceHolderSb.toString();
                            "no write index is defined for alias ["
                    int i = 0;
                if (indexAbstraction.isHidden() == false || includeHidden || implicitHiddenMatch(aliasOrIndexName, expression)) {
    private final List<ExpressionResolver> expressionResolvers;
        public ClusterState getState() {
     * @return the write index obtained as a result of the index resolution
        if (options.allowNoIndices() == false && concreteIndices.isEmpty()) {
        }
    boolean isPatternMatchingAllIndices(Metadata metadata, String[] indicesOrAliases, String[] concreteIndices) {
     *
            }
        Map<String, Set<String>> routings = null;
                IndexNotFoundException infe;
                                    }
            request.includeDataStreams(),
         * by {@link #filteringAliases(ClusterState, String, Set)} since it's the only one that needs aliases
    private final DateMathExpressionResolver dateMathExpressionResolver = new DateMathExpressionResolver();
            Predicate<? super Map.Entry<String, IndexAbstraction>> filter,
        private static boolean aliasOrIndexExists(Context context, IndicesOptions options, Metadata metadata, String expression) {
            Set<String> result = innerResolve(context, expressions, options, metadata);
package org.opensearch.cluster.metadata;
     * @param concreteIndices  array containing the concrete indices that the first argument refers to
            Map<String, IndexAbstraction> matches,
    }
        private static final char RIGHT_BOUND = '}';
                    .withResolutionErrors(infe);
     */
                if (options.allowNoIndices() == false && matches.isEmpty()) {
                            }
        Context context = new Context(
            if (result == null) {
                }
                        case LEFT_BOUND:
     * provided indices options in the context don't allow such a case, or if the final result of the indices resolution
    public Index concreteSingleIndex(ClusterState state, IndicesRequest request) {
                            context,
                            // Non-routing alias
/*
            return this.resolutionErrors;
import org.opensearch.action.support.IndicesOptions;
        return (context.options.ignoreThrottled() && metadata.getSettings().getAsBoolean("index.frozen", false)) == false;
            throw new IllegalStateException("index state [" + index.getState() + "] not supported");
import org.opensearch.common.util.set.Sets;
import java.util.Map;
                    norouting.add(expression);
        final AliasMetadata[] aliasCandidates;
                return expression;
                        routings.put(expression, r);
                                routings = new HashMap<>();
            infe.setResources("index_expression", indexExpressions);
     * @param indexAliasesSize        the number of aliases of the index
    }
                .map(i -> i.getIndex().getName())
            if (options.expandWildcardsClosed() == false && options.expandWildcardsOpen() == false) {
        // Using customResolvers to filter out invalid expressions
        }
            IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(expression);
    private static boolean shouldTrackConcreteIndex(Context context, IndicesOptions options, IndexMetadata index) {
                            }
     * Utility method that allows to resolve an index expression to its corresponding single write index.
                                    dateFormatter = DEFAULT_DATE_FORMATTER;
        if (indices.length != 1) {
        String resolvedAliasOrIndex = dateMathExpressionResolver.resolveExpression(indexAbstraction, context);
    /**
                    )
        }
     * @param resolvedExpressionsSize the number of resolved expressions
            IndexMetadata.State excludeState,
     * Translates the provided index expression into actual concrete indices, properly deduplicated.
            }
    private static IllegalArgumentException aliasesNotSupportedException(String expression) {
        }
     * @param options           defines how the aliases or indices need to be resolved to concrete indices
                        )
                                inDateFormat = false;
         * Resolves the list of expressions into other expressions if possible (possible concrete indices and aliases, but
            boolean wildcardSeen = false;
        Index[] indices = concreteIndices(state, request.indicesOptions(), indexExpression);
        private static IndexNotFoundException indexNotFoundException(String expression) {
            }
    static boolean isExplicitAllPattern(Collection<String> aliasesOrIndices) {
                }
            if (indicesOrAliases[0].charAt(0) == '-') {
                );
            for (String indexOrAlias : indicesOrAliases) {
                                DateFormatter formatter = dateFormatter.withZone(timeZone);
        if (!context.resolutionErrors.isEmpty()) {
     */
                                String dateFormatterPattern;
                }
        String indexExpression = CollectionUtils.isEmpty(request.indices()) ? null : request.indices()[0];
        if (skipIdentity == false && resolvedExpressions.contains(index)) {
                        case RIGHT_BOUND:
     *
    public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
                    );
        }
                            } else if (!inDateFormat) {
                }
                infe.addMetadata(EXCLUDED_DATA_STREAMS_KEY, "true");
            if (expression.startsWith(EXPRESSION_LEFT_BOUND) == false || expression.endsWith(EXPRESSION_RIGHT_BOUND) == false) {
    public Map<String, Set<String>> resolveSearchRouting(ClusterState state, @Nullable String routing, String... expressions) {
     *
                if (!norouting.contains(expression)) {
        if (expressions.isEmpty()) {
     * @throws IllegalArgumentException if the index resolution lead to more than one index
     */
                            }
     * @return True if system index access should be allowed, false otherwise.
                            && context.includeDataStreams() == false) {
            }
 * this file be licensed under the Apache-2.0 license or a
            IndexAbstraction indexAbstraction = state.metadata().getIndicesLookup().get(expression);
     * @opensearch.internal
                return filterIndicesLookup(context, metadata.getIndicesLookup(), null, context.getOptions());
                    return true;
                            beforePlaceHolderSb.append(c);
                    // just cannot understand. So, we have to wait for all other resolvers to complete.
                                    new String(text, from, length),
                    if (addIndex(writeIndex, context)) {
            Context context,
     * @return true if the first argument is a pattern that maps to all available indices, false otherwise
                    }
    public static final class DateMathExpressionResolver implements ExpressionResolver {
            boolean isSystemIndexAccessAllowed
    public IndexNameExpressionResolver(ThreadContext threadContext, List<ExpressionResolver> resolvers) {
     *
        }
 * specific language governing permissions and limitations
     */
        // NOTE: The Setting object was defined in an external plugin prior to OpenSearch fork.
            throw new IllegalArgumentException("indices request must specify a single index expression");
            SortedMap<String, IndexAbstraction> indicesLookup,
                return suffixWildcard(context, metadata, expression);
                }
        // by custom resolvers.
                }
        List<String> resolvedExpressions = expressions != null ? Arrays.asList(expressions) : Collections.emptyList();
            boolean preserveAliases,
        }
 * Modifications Copyright OpenSearch Contributors. See
        }
    /**
            }
                        }
        IndicesOptions options = context.getOptions();
        }
     *                          and the expression that can be resolved to an alias or an index name.
        }
     * <p>Only aliases where the given predicate tests successfully are returned. If the indices list contains a non-required reference to
    boolean iterateIndexAliases(int indexAliasesSize, int resolvedExpressionsSize) {
            if (filter != null) {
                    } else {
                            }
        checkSystemIndexAccess(context, metadata, concreteIndices, indexExpressions);
            return result;
            }
        public Context(ClusterState state, IndicesOptions options, boolean isSystemIndexAccessAllowed) {
            final char[] text = expression.toCharArray();
        List<String> expressions = Arrays.asList(indexExpressions);
        context.resolutionErrors.clear();
     * provided indices options in the context don't allow such a case, or if the final result of the indices resolution
     * @param includeDataStreams Whether data streams should be included in the evaluation.
            if (context.includeDataStreams() == false) {
                state,
    /**
        ) {
        // if we end up matching on all indices, check, if its a wildcard parameter, or a "-something" structure
     * Same as {@link #concreteIndexNames(ClusterState, IndicesOptions, String...)}, but the index expressions and options
        Set<String> acceptedExpressions = new HashSet<>(expressions.size());
