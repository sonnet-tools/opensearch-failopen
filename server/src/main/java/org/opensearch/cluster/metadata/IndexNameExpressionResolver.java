                for (Tuple<String, AliasMetadata> item : alias.getConcreteIndexAndAliasMetadatas()) {
                return Arrays.asList(metadata.getConcreteVisibleOpenIndices());  
                return Arrays.asList(metadata.getConcreteVisibleIndices());
        Context context = new Context(state, combinedOptions, false, true, includeDataStreams, isSystemIndexAccessAllowed());
    }
        private static Map<String, IndexAbstraction> filterIndicesLookup(
        return concreteResolvedIndices(context, indexExpressions).namesOfConcreteIndicesAsArray();
                            break;
        }  
                                        dateTimeFormatLeftBoundIndex + 1,  
        return concreteIndexNames(context, indexExpressions);
                validateAliasOrIndex(context, expression);
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            }
            allowNoIndices,
        return Booleans.parseBoolean(threadContext.getHeader(SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY), true);  
    }
     * <p><b>NOTE</b>: the provided expressions must have been resolved already via {@link #resolveExpressions}.
        List<String> resolve(Context context, List<String> expressions);
                                    routings.put(concreteIndex, r);
 * software distributed under the License is distributed on an
import org.opensearch.indices.IndexClosedException;
                            "no write index is defined for alias ["
                                        dateFormatterPattern = patternAndTZid.substring(0, formatPatternTimeZoneSeparatorIndex);
            Context context,
            return expressions.isEmpty()  
            options.expandWildcardsClosed(),  
            // Shouldn't happen
            }  
        if (expressions.isEmpty()) {
                IndexMetadata writeIndex = indexAbstraction.getWriteIndex();
    public Index[] concreteIndices(ClusterState state, IndicesRequest request) {  
                                    }
            ClusterState state,
     * @param request    request containing expressions that can be resolved to alias, index, or data stream names.  
                                    dateFormatter = DEFAULT_DATE_FORMATTER;
        if (indices.length != 1) {
        return ((dataStreams == null) ? List.<String>of() : dataStreams).stream()  
    }  
import org.opensearch.common.time.DateUtils;
    public static final String SYSTEM_INDEX_ACCESS_CONTROL_HEADER_KEY = "_system_index_access_allowed";
    public static class Context {  
        }
        checkSystemIndexAccess(context, metadata, concreteIndices, indexExpressions);
     */
    }
        List<String> expressions = Arrays.asList(indexExpressions);
                        infe = new IndexNotFoundException("no indices exist", (String) null);  
                        new IllegalArgumentException(
        }  
        // If only one index is specified then whether we fail a request if an index is missing depends on the allow_no_indices
     * <p>Only aliases where the given predicate tests successfully are returned. If the indices list contains a non-required reference to  
 * this file be licensed under the Apache-2.0 license or a
        final Set<Index> concreteIndices = new HashSet<>(expressions.size());
        public boolean isSystemIndexAccessAllowed() {
                throw new OpenSearchParseException("nothing captured");
 * license agreements. See the NOTICE file distributed with
    }  
                            } else if (!inDateFormat) {
                options,
                    throw new IndexClosedException(index.getIndex());
        return concreteResolvedIndices(context, indexExpressions).concreteIndicesAsArray();  
            state,
        }
            } else if (options.expandWildcardsOpen() && options.expandWildcardsHidden()) {  
            } else {  
                resolveToWriteIndex,
        return concreteResolvedIndices(context, request.indices());
        if (!context.resolutionErrors.isEmpty()) {
    /**
        }
            boolean preserveDataStreams,  
     * @return routing values grouped by concrete index  
     * The empty or null array doesn't explicitly map to all indices  
                        }
         * will continue until it is completed. However, after completion The methods concreteIndices(),
                stream = stream.filter(e -> e.getValue().getType() != IndexAbstraction.Type.ALIAS);
    public String[] indexAliases(
import org.opensearch.common.annotation.PublicApi;
            ClusterState state,
                            if (inDateFormat && escapedChar) {
            return result;  
     *  
            boolean isSystemIndexAccessAllowed
import org.opensearch.common.collect.Tuple;
            isSystemIndexAccessAllowed()  
                            expressions.isEmpty() ? "_all" : expressions.get(0),  
                                    dateFormatter = DateFormatter.forPattern(dateFormatterPattern);
     * @throws IllegalArgumentException if the index resolution lead to more than one index
    // pkg-private for testing
                .filter(IndexMetadata::isSystem)
            return preserveAliases;  
     * @return If the specified string is data math expression then this method returns the resolved expression.
        List<String> dataStreams = wildcardExpressionResolver.resolve(context, finalExpressions);  
            boolean includeDataStreams,  
                if (Strings.isEmpty(expression)) {
        );
                }
                return ResolvedIndices.Local.Concrete.empty()
                    );
 */  
                                        );
                                beforePlaceHolderSb.append(c);
                .sorted() // reliable order for testing  
            final IndexMetadata.State excludeState;
         *
                        )  
    private final DateMathExpressionResolver dateMathExpressionResolver = new DateMathExpressionResolver();
                includeDataStreams,  
    public String[] filteringAliases(ClusterState state, String index, Set<String> resolvedExpressions) {
        final IndexMetadata indexMetadata = state.metadata().getIndices().get(index);  
                        "To expand [" + index.getState() + "] wildcard, please set forbid_closed_indices to `false`"
                        .stream()
    public String[] concreteIndexNamesWithSystemIndexAccess(ClusterState state, IndicesRequest request) {
            request.indicesOptions(),
    }
            } else if (options.expandWildcardsOpen()) {
                    .withResolutionErrors(context.getResolutionErrors())  
                        .filter(entry -> entry.getValue().getType() == IndexAbstraction.Type.DATA_STREAM)  
            }
            this.includeDataStreams = includeDataStreams;
     * @opensearch.internal
     */  
        ) {
                preserveAliases,
    private final List<ExpressionResolver> expressionResolvers;  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(IndexNameExpressionResolver.class);
        }
        // otherwise it will throw exception in case it cannot resolve any keywords which are expected to be handled
     * the index itself - null is returned. Returns {@code null} if no filtering is required.
                return Collections.emptyList();  
     * Expression resolver for index name expressions.
import java.util.HashMap;  
        String resolvedAliasOrIndex = dateMathExpressionResolver.resolveExpression(indexAbstraction, context);  
    /**
                );
                                    new String(text, from, length),
        private final boolean isSystemIndexAccessAllowed;  
     */
            Stream<Map.Entry<String, IndexAbstraction>> stream = indicesLookup.entrySet().stream();
                acceptedExpressions.add(expression);  
import org.opensearch.common.regex.Regex;
     *
                            inPlaceHolderSb.append(c);
     * A date math expression resolver.  
                return resolvedExpressions;  
                    if (addIndex(writeIndex, context)) {  
import java.util.Set;
    public ResolvedIndices.Local.Concrete concreteResolvedIndices(ClusterState state, IndicesOptions options, String... indexExpressions) {
                            // Non-routing alias  
                            excludeState,
        ClusterState state,
            if (excludedDataStreams) {
        // NOTE: The Setting object was defined in an external plugin prior to OpenSearch fork.
/**
                                }  
            } else {
            if (expression.charAt(0) == '_') {
                continue;  
     * @param request           The request that defines how the an alias or an index need to be resolved to a concrete index
                            if (escapedChar) {
                for (IndexMetadata index : indexAbstraction.getIndices()) {
    public Index[] concreteIndices(ClusterState state, IndicesOptions options, boolean includeDataStreams, String... indexExpressions) {  
            return includeDataStreams;  
    public Map<String, Set<String>> resolveSearchRoutingAllIndices(Metadata metadata, String routing) {
    private final ThreadContext threadContext;  
            SortedMap<String, IndexAbstraction> subMap = metadata.getIndicesLookup().subMap(fromPrefix, toPrefix);
            } else if (expression.indexOf("*") == expression.length() - 1) {
                                        timeZone = DateUtils.of(patternAndTZid.substring(formatPatternTimeZoneSeparatorIndex + 1));  
            throw context.resolutionErrors.getFirst();  
                }
        // or multiple indices are specified yield different behaviour.  
    private final WildcardExpressionResolver wildcardExpressionResolver = new WildcardExpressionResolver();
            String fromPrefix = expression.substring(0, expression.length() - 1);
            if (beforePlaceHolderSb.length() == 0) {  
                }
                    expression = expression.substring(1);  
    Index[] concreteIndices(Context context, String... indexExpressions) {
        return Collections.unmodifiableSet(new HashSet<>(resolvedExpressions));
            }  
     *
            if (filter != null) {
            for (int i = from; i < length; i++) {
            throw context.resolutionErrors.getFirst();  
                shouldConsumeStream = true;
     * @param startTime  The start of the request where concrete indices is being invoked for
            paramRouting = Sets.newHashSet(Strings.splitStringByCommaToArray(routing));
                false,
                            && context.includeDataStreams() == false) {  
 * compatible open source license.
                            if (excludeState == null || meta.getState() != excludeState) {  
            return null;
            }
                throw new OpenSearchParseException(
                                        + " should be escaped when used as part of the index name using `\\` (e.g. `\\{text\\}`)",
                        indexNames[i++] = indexMetadata.getIndex().getName();
            boolean includeDataStreams,
import java.time.ZoneId;  
        }  
                                if (paramRouting != null) {  
        ) {
                    }
         * Adds a new error encountered while resolving index resolution. If this method is used, index resolution  
                                    i  
        return indices[0];  
                        expand.add(aliasOrIndexName);  
     * Translates the provided index expression into actual concrete indices, properly deduplicated.
        @SuppressWarnings("fallthrough")
                    // The only more or less sensible way out might be a new resolver between DateMathExpressioResolver  
     *
            this(state, options, startTime, false, false, false, false, isSystemIndexAccessAllowed);
                    if (add) {
        Map<String, Set<String>> routings = null;
 * GitHub history for details.
            } else {  
                    infe = new IndexNotFoundException((String) null);
                            // Routing alias
            return infe;
                final IndexMetadata.State excludeState = excludeState(options);  
                                inDateFormat = false;
                                DateFormatter dateFormatter;  
                // Index
     * are encapsulated in the specified request and resolves data streams.
        return aliases.toArray(new String[0]);
                    try {  
import org.opensearch.common.logging.DeprecationLogger;  
                // If required - add it to the list of aliases
         * present resolution errors.  
                }  
 * Modifications Copyright OpenSearch Contributors. See
        if (index.getState() == IndexMetadata.State.CLOSE) {
    public List<ExpressionResolver> getExpressionResolvers() {  
                            } else {
            } else {  
                    result = new HashSet<>(expressions.subList(0, i));  
                    }
        private final IndicesOptions options;  
            } else if (options.expandWildcardsClosed() && options.expandWildcardsHidden()) {
import org.opensearch.common.time.DateMathParser;  
                                routings.put(concreteIndex, r);
            }
                                + " indices without one being designated as a write index"
            if (indexAbstraction != null && indexAbstraction.getType() == IndexAbstraction.Type.ALIAS) {  
        String resolveExpression(String expression, final Context context) {  
        Metadata metadata = context.getState().metadata();
                // Allows callers to handle IndexNotFoundException differently based on whether data streams were excluded.  
            boolean preserveAliases,  
                            if (routings == null) {
         * tracked with this method. The method concreteResolvedIndices() can be used to retrieve the resolution  
    @PublicApi(since = "3.1.0")
                        beforePlaceHolderSb.append(c);
    }  
                if (addIndex(writeIndex, context)) {  
        }
    /**
                if (inPlaceHolder) {
         * This is used to require that aliases resolve to their write-index. It is currently not used in conjunction
import org.opensearch.core.common.Strings;
     */  
                excludeState = null;
        final AliasMetadata[] aliasCandidates;
            // we might have something like /-test1,+test1 that would identify all indices
                                int dateTimeFormatLeftBoundIndex = inPlaceHolderString.indexOf(LEFT_BOUND);  
            throw new IllegalArgumentException(  
            acceptedExpressions.add(expression);  
                    continue;  
     */
            this.startTime = startTime;
            }
                                );
                if (!norouting.contains(expression)) {
     * @throws IllegalArgumentException if the index resolution does not lead to an index, or leads to more than one index
                            if (!escapedChar) {  
        List<RuntimeException> getResolutionErrors() {
                    } else {  
                                + expression
            IndicesOptions options,  
     * Utility method that allows to resolve an index expression to its corresponding single concrete index.  
            assert expression.length() >= 2 : "expression [" + expression + "] should have at least a length of 2";  
                return filterIndicesLookup(context, metadata.getIndicesLookup(), null, context.getOptions());  
            String[] concreteIndices = metadata.getConcreteAllIndices();
        return aliasesOrIndices != null && aliasesOrIndices.size() == 1 && Metadata.ALL.equals(aliasesOrIndices.iterator().next());  
     * Callers should make sure they provide proper {@link org.opensearch.action.support.IndicesOptions}
                    }
    static boolean isExplicitAllPattern(Collection<String> aliasesOrIndices) {
         * Returns the currently encountered resolution errors.
            }
            if (indexAbstraction.getType() == IndexAbstraction.Type.ALIAS && options.ignoreAliases()) {
                                DateFormatter formatter = dateFormatter.withZone(timeZone);
 *     http://www.apache.org/licenses/LICENSE-2.0
                    resolvedIncludingDataStreams.addAll(
            }  
            } else {  
                    // - We cannot perform it efficiently after the resolver chain, as then the WildcardExpressionResolver  
    public static final class DateMathExpressionResolver implements ExpressionResolver {
     * Iterates through the list of indices and selects the effective list of filtering aliases for the
            if (options.forbidClosedIndices() && options.ignoreUnavailable() == false) {
import java.util.function.Predicate;
                return suffixWildcard(context, metadata, expression);
    }
     * Translates the provided index expression into actual concrete indices, properly deduplicated.
        return new ArrayList<>(this.expressionResolvers);
                includeDataStreams,  
            if (Regex.isMatchAllPattern(expression)) {
                        infe = new IndexNotFoundException("no indices exist", expression);
        }
    }
            "The provided expression [" + expression + "] matches an " + "alias, specify the corresponding concrete indices instead."
     * @return true if the first argument is a pattern that maps to all available indices, false otherwise
 *  
                excludedDataStreams = true;
    }
        // option. At some point we should change this, because there shouldn't be a reason why whether a single index
                        }  
                        .entrySet()
                if (c == ESCAPE_CHAR) {
        for (ExpressionResolver expressionResolver : expressionResolvers) {
                            expand.add(indexAbstraction.getName());
                        case RIGHT_BOUND:
            }  
        }  
                                if (dateTimeFormatLeftBoundIndex < 0) {
                    systemIndexName -> deprecationLogger.deprecate(
     * @param indexExpressions  expressions that can be resolved to alias or index names.  
        }
        }  
                if (aliases == null) {
            this.options = options;  
                }  
            } else {  
                if (options.expandWildcardsClosed() == true && options.getExpandWildcards().size() == 1) {  
            aliasCandidates = StreamSupport.stream(Spliterators.spliteratorUnknownSize(indexAliases.values().iterator(), 0), false)
    public Index[] concreteIndices(ClusterState state, IndicesRequest request, long startTime) {  
                    context.addResolutionError(infe);
            .filter(ia -> ia.getType() == IndexAbstraction.Type.DATA_STREAM)  
}  
            Metadata metadata = context.getState().metadata();
    }
        private static List<String> resolveEmptyOrTrivialWildcard(IndicesOptions options, Metadata metadata) {
     * Translates the provided index expression into actual concrete indices, properly deduplicated.
    /**
            return null;
            if (this.resolutionErrors.isEmpty()) {
            indexExpressions = new String[] { Metadata.ALL };
            isSystemIndexAccessAllowed()  
            boolean preserveDataStreams,
                return false;
        ClusterState state,
            long startTime,
                                        + " invalid character at position [{}]. `{` and `}` are reserved characters and"  
                                    }  
        return false;  
            .filter(Objects::nonNull)
        }
    }
    }
                            if (r.isEmpty()) {
            } else if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM && context.isResolveToWriteIndex()) {
                boolean escapedChar = escape;
                        if (routings == null) {  
     */  
            final int from = 1;
                                context.addResolutionError(indexNotFoundException(expression));
                    switch (c) {  
                return true;
     *
                                inPlaceHolderSb.append(c);  
                }
            return null;  
                    context.addResolutionError(indexNotFoundException(expression));
     *                          and the expression that can be resolved to an alias or an index name.
                    }  
                                            inPlaceHolderString
    public boolean isSystemIndexAccessAllowed() {
                "unable to return a single index as the index and options" + " provided got resolved to multiple indices"
                                + indexAbstraction.getName()
    public String[] concreteIndexNames(ClusterState state, IndicesOptions options, String... indexExpressions) {
     * @return true if the provided array maps to all indices, false otherwise
                return expressions;  
        List<String> aliases = null;
                            }
     * Utility method that allows to resolve an index expression to its corresponding single write index.
        return indexAliases(state, index, AliasMetadata::filteringRequired, false, resolvedExpressions);  
        List<String> finalExpressions = Arrays.asList(indexExpressions);
    @PublicApi(since = "3.1.0")
                } else {
         * Note: This is on purpose package private. External resolvers should have no need to inspect the
    public String[] concreteIndexNames(ClusterState state, IndicesOptions options, IndicesRequest request) {  
                    if (paramRouting != null) {
                            Set<String> r = routings.get(concreteIndex);
         * that isn't required). The provided implementations can also be left untouched.
                                String mathExpression;
                    IndexNotFoundException infe;  
                                inPlaceHolder = true;
        Context(ClusterState state, IndicesOptions options, long startTime, boolean isSystemIndexAccessAllowed) {  
            this.preserveDataStreams = preserveDataStreams;
 * this work for additional information regarding copyright
        customResolvers.addAll(resolvers);
        }
     * @param allowNoIndices    whether to allow resolve to no index
     * @param includeDataStreams Whether data streams should be included in the evaluation.  
 * Unless required by applicable law or agreed to in writing,
                    );  
            return beforePlaceHolderSb.toString();  
 * Resolves index name from an expression
                Set<String> expand = expand(context, excludeState, matches, expression, options.expandWildcardsHidden());
        for (String expression : resolvedExpressions) {
        ) {
    /**
     * @return the resolved concrete indices based on the cluster state, indices options and index expressions
            if (isEmptyOrTrivialWildcard(expressions)) {
            return expand;
    /**
        private final boolean preserveAliases;
        Context context = new Context(state, options, false, false, includeDataStreams, isSystemIndexAccessAllowed());
        // Set custom resolvers to the top of the list to ensure to WildcardExpressionResolver is triggered at the end,
                                    if (formatPatternTimeZoneSeparatorIndex != -1) {
 * You may obtain a copy of the License at  
            toPrefixCharArr[toPrefixCharArr.length - 1]++;  
import org.opensearch.common.time.DateFormatter;
     * @return True if system index access should be allowed, false otherwise.  
                IndexNotFoundException infe;  
 */
     * @param concreteIndices  array containing the concrete indices that the first argument refers to
                return null;
        }  
                                    );
                    }  
        return ResolvedIndices.Local.Concrete.of(concreteIndices, acceptedExpressions).withResolutionErrors(context.getResolutionErrors());  
    }
        private final long startTime;
        }
            throw new IllegalArgumentException("indices request must specify a single index expression");  
     * @return the write index obtained as a result of the index resolution or null if no index
        if (routings == null || routings.isEmpty()) {
            for (Map.Entry<String, IndexAbstraction> entry : matches.entrySet()) {  
        if (concreteIndices.length == metadata.getConcreteAllIndices().length && indicesOrAliases.length > 0) {  
            final char[] text = expression.toCharArray();
                            }
         */
     */  
            for (String indexOrAlias : indicesOrAliases) {  
import org.opensearch.common.util.concurrent.ThreadContext;
        if (indexExpressions == null || indexExpressions.length == 0) {
        }
     * names() to access the names of the requested indices in a way that is safe from thrown exceptions due to
import org.opensearch.common.util.set.Sets;  
                                String time = formatter.format(instant);  
            boolean inDateFormat = false;  
            boolean preserveAliases,
            indexExpressions = new String[] { "*" };  
    }  
            }
                                norouting.add(concreteIndex);
            List<String> result = new ArrayList<>(expressions.size());
     * using this method, an {@link IllegalArgumentException} gets thrown otherwise.  
                    }  
                                    timeZone = ZoneOffset.UTC;
import org.opensearch.action.IndicesRequest;
                e -> Regex.simpleMatch(pattern, e.getKey()),
                return Arrays.asList(metadata.getConcreteAllIndices());  
            infe.setResources("index_expression", indexExpressions);
                                    }  
        // by custom resolvers.  
                                            "invalid dynamic name expression [{}]. missing closing `}`" + " for date math format",  
                    escape = false;
                    } catch (IndexClosedException e) {
     * indices options in the context don't allow such a case.  
    /**  
                            if (r == null) {  
     * are encapsulated in the specified request and resolves data streams.  
                                    if (dateTimeFormatLeftBoundIndex == inPlaceHolderString.length() - 2) {
            }
                excludeState = IndexMetadata.State.OPEN;
                    wildcardSeen = true;  
                options,
import java.util.stream.Collectors;  
        public boolean includeDataStreams() {
    String[] concreteIndexNames(Context context, String... indexExpressions) {
            }
            boolean isSystemIndexAccessAllowed  
    }  
                System.currentTimeMillis(),  
    }  
    }
                if (add) {  
            return state;
            return filterIndicesLookup(context, subMap, null, context.getOptions());  
                                        dateFormatterPattern = patternAndTZid;
            false,
        for (AliasMetadata aliasMetadata : aliasCandidates) {
        boolean includeDataStreams  
                        "open_system_index_access_" + systemIndexName,
                        default:  
     */  
                                            "invalid dynamic name expression [{}]. missing date format",  
                                        inPlaceHolderString.length() - 1
            boolean inPlaceHolder = false;
                                throw new OpenSearchParseException(
    // Visible for testing
                result.add(resolveExpression(expression, context));  
        boolean excludedDataStreams = false;
                final Map<String, IndexAbstraction> matches = matches(context, metadata, expression);
            } else if (indexAbstraction.getType() == IndexAbstraction.Type.ALIAS && context.getOptions().ignoreAliases()) {
                } else {
                if (result == null) {
                .filter(aliasMetadata -> resolvedExpressions.contains(aliasMetadata.alias()))  
            this.resolutionErrors.add(resolutionError);  
     * Context for the resolver.
     * Same as {@link #concreteIndexNames(ClusterState, IndicesOptions, String...)}, but the index expressions and options
            false,  
        if (allowNoIndices && indices.length == 0) {
                        IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(expression);  
     */
        if (routing != null) {
            return resolveToWriteIndex;
        IndicesOptions options,
     *
                                        timeZone = ZoneOffset.UTC;  
        }  
import org.opensearch.common.Booleans;
            this.isSystemIndexAccessAllowed = isSystemIndexAccessAllowed;  
                preserveDataStreams,
    /**  
                        if (shouldTrackConcreteIndex(context, options, index)) {
        for (ExpressionResolver resolver : customResolvers) {
                                DateMathParser dateMathParser = formatter.toDateMathParser();  
 * Licensed to Elasticsearch under one or more contributor  
    /**
        }
                }  
    /**
    }
            }  
                        context.addResolutionError(e);
        if (routing != null) {  
                                    new String(text, from, length),
                        } else if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM
                } else {
                            }
            resolvedExpressions = expressionResolver.resolve(context, resolvedExpressions);  
            options.forbidClosedIndices(),  
                    add = false;
        } else {  
        public void addResolutionError(RuntimeException resolutionError) {
                        }  
                                inDateFormat = true;
    /**
     * Determines whether or not system index access should be allowed in the current context.
import java.util.stream.Stream;
        public long getStartTime() {
            } else if (options.expandWildcardsOpen() && options.expandWildcardsClosed()) {
            final int length = text.length - 1;  
        Context context = new Context(state, options, false, false, includeDataStreams, isSystemIndexAccessAllowed());  
        Context context = new Context(
     */
                final boolean add;  
                IndexMetadata writeIndex = indexAbstraction.getWriteIndex();  
                aliases.add(aliasMetadata.alias());
        Context context = new Context(  
         */
            // does not exist and the path is interpreted as an expression. If the expression begins with an underscore,
            return excludeState;
        private static void validateAliasOrIndex(Context context, String expression) {  
            } else {
     * Identifies whether the array containing index names given as argument refers to all indices  
    private static IllegalArgumentException aliasesNotSupportedException(String expression) {
                            }
                            break;  
                    concreteIndices.add(writeIndex.getIndex());
     * contains no indices and the indices options in the context don't allow such a case.
                                    mathExpression = inPlaceHolderString;  
    /**
     */  
                if (writeIndex == null) {
    public IndexNameExpressionResolver(ThreadContext threadContext, List<ExpressionResolver> resolvers) {  
                    add = true;
                .map(i -> i.getIndex().getName())
     *         If the data stream, index or alias contains date math then that is resolved too.
                }
            IndexNotFoundException infe = new IndexNotFoundException(expression);
        Context context = new Context(state, options, false, false, request.includeDataStreams(), isSystemIndexAccessAllowed());
                context.addResolutionError(new InvalidIndexNameException(expression, "must not start with '_'."));  
     * Iterates through the list of indices and selects the effective list of required aliases for the given index.
     * Resolves the search routing if in the expression aliases are used. If expressions point to concrete indices  
                            dataStreamsAbstractions,
                        }
     *
        Context context = new Context(state, IndicesOptions.lenientExpandOpen(), false, false, true, isSystemIndexAccessAllowed());
                                );  
            if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM && context.includeDataStreams() == false) {  
                                r.retainAll(paramRouting);  
        Context context = new Context(  
                    new String(text, from, length)  
                                String inPlaceHolderString = inPlaceHolderSb.toString();
        return concreteIndices(state, options, false, indexExpressions);  
        if (options.allowNoIndices() == false && concreteIndices.isEmpty()) {
        expressionResolvers.add(wildcardExpressionResolver);
                                expand.add(meta.getIndex().getName());
        IndicesOptions options = context.getOptions();
     * @throws IllegalArgumentException if one of the aliases resolve to multiple indices and the provided
                    // This might seem to be non-intuitive, as we are in the class WildcardExpressionResolver which
                }
import org.opensearch.core.common.util.CollectionUtils;
        /**
        private static final char RIGHT_BOUND = '}';
                isSystemIndexAccessAllowed
         * This is used to prevent resolving aliases to concrete indices but this also means
                return null;
    }  
     */  
        expressionResolvers = new ArrayList<>();  
     * Resolves alias/index name expressions with wildcards into the corresponding concrete indices/aliases
        private Set<String> innerResolve(Context context, List<String> expressions, IndicesOptions options, Metadata metadata) {
                                }
            Predicate<? super Map.Entry<String, IndexAbstraction>> filter,
        context.resolutionErrors.clear();  
         * @param resolutionError the encountered resolution error. Ideally this extends OpenSearchException.  
                        routings.put(expression, r);  
        }
     */
     */
    }
     * @param state             the cluster state containing all the data to resolve to expressions to concrete indices
                }
        Set<String> norouting = new HashSet<>();
        }
 * under the License.  
            context.addResolutionError(infe);  
        ) {
                return expressions;
                }
                                    i
                    context.addResolutionError(
                    } else {
     * @param request           The request that defines how the an alias or an index need to be resolved to a concrete index  
    public static boolean isAllIndices(Collection<String> aliasesOrIndices) {  
                            if (!norouting.contains(concreteIndex)) {
            resolvedExpressions = expressionResolver.resolve(context, resolvedExpressions);
    }
            return addIndex(index, context);
     *
                if (Regex.isSimpleMatchPattern(expression)) {
        } else {
    ) {
        public Context(ClusterState state, IndicesOptions options, boolean isSystemIndexAccessAllowed) {  
        if (indexExpressions == null || indexExpressions.length == 0) {
                continue;  
        ) {  
        this.threadContext = Objects.requireNonNull(threadContext, "Thread Context must not be null");
        /**
        if (context.isSystemIndexAccessAllowed() == false) {
                || (expressions.size() == 1 && (Metadata.ALL.equals(expressions.get(0)) || Regex.isMatchAllPattern(expressions.get(0))));
                        if (context.isPreserveDataStreams() && indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM) {
                    // just cannot understand. So, we have to wait for all other resolvers to complete.
     * the index itself - null is returned. Returns {@code null} if no filtering is required.
 * ownership. Elasticsearch licenses this file to you under  
            options.ignoreUnavailable(),  
                            indexAbstraction.getType().getDisplayName()  
        private final boolean includeDataStreams;
            IndexMetadata.State excludeState,  
        }
            }
                }
                        if (routings != null) {
            request.indicesOptions(),
    }
        expressionResolvers.add(dateMathExpressionResolver);
        Context context = new Context(state, IndicesOptions.lenientExpandOpen(), false, false, true, isSystemIndexAccessAllowed());
     * @param state             the cluster state containing all the data to resolve to expressions to concrete indices
                    "invalid dynamic name expression [{}]. date math placeholder is open ended",
            );
        }  
        for (ExpressionResolver expressionResolver : expressionResolvers) {
            return this.resolutionErrors;  
            }
            expressions = expressionResolver.resolve(context, expressions);
                if (options.allowNoIndices() == false && matches.isEmpty()) {
                                    "invalid dynamic name expression [{}]."
            false,
                                beforePlaceHolderSb.append(time);
                return options.forbidClosedIndices() == false && addIndex(index, context);
import org.opensearch.core.index.Index;  
                        "this request accesses system indices: [{}], but in a future major version, direct access to system "  
     */
        return concreteResolvedIndices(state, options, false, indexExpressions);  
        boolean isResolveToWriteIndex() {
        if (indices.length != 1) {
    boolean isPatternMatchingAllIndices(Metadata metadata, String[] indicesOrAliases, String[] concreteIndices) {
                state,
    private final List<ExpressionResolver> customResolvers = new ArrayList<>();
        // This used to check the `index.search.throttled` setting, but we eventually decided that it was  
        // trappy to hide throttled indices by default. In order to avoid breaking backward compatibility,
                IndexAbstraction indexAbstraction = entry.getValue();
        /**  
                preserveAliases,
        // The data math expression resolver doesn't rely on cluster state or indices options, because
                context.getOptions()  
            boolean resolveToWriteIndex,  
        }
                        for (IndexMetadata meta : indexAbstraction.getIndices()) {
    /**
                        new IllegalArgumentException(  
import java.util.List;
    public List<String> dataStreamNames(ClusterState state, IndicesOptions options, String... indexExpressions) {
            if (options.expandWildcardsOpen() && options.expandWildcardsClosed() && options.expandWildcardsHidden()) {
                            concreteIndices.add(index.getIndex());
         * Resolves the list of expressions into other expressions if possible (possible concrete indices and aliases, but  
     * resolution errors.
        private static final char LEFT_BOUND = '{';  
        }  
                }  
            return null;
                                    "invalid dynamic name expression [{}]." + " invalid character in placeholder at position [{}]",  
                        escape = true;
         */  
            StringBuilder inPlaceHolderSb = new StringBuilder();  
                    throw new IllegalArgumentException(
     * @throws IllegalArgumentException if one of the aliases resolve to multiple indices and the provided  
        return concreteIndexNames(context, indexExpressions);  
    /**
     */
            }
            Map<String, IndexAbstraction> matches,
         * Used to determine if it is allowed to access system indices in this context (e.g. for this request).
        String index,  
        }
    }
        }
            if (indexAbstraction == null) {
                        escape = false;
                                    if (routings == null) {
            options.expandWildcardsOpen(),
        } else if (index.getState() == IndexMetadata.State.OPEN) {
     * indices options in the context don't allow such a case.  
                            }
            }
            char[] toPrefixCharArr = fromPrefix.toCharArray();
        // Using customResolvers to filter out invalid expressions  
            if (!options.allowNoIndices()) {
                } else {
            }
import java.util.Arrays;  
        if (!context.resolutionErrors.isEmpty()) {
                return expression;
    /**  
                } else {
        }
                    }
            boolean isSystemIndexAccessAllowed
                if (aliasOrIndexExists(context, options, metadata, expression)) {  
                    } else {
     * @opensearch.internal  
     */
                    aliases = new ArrayList<>();  
            final StringBuilder beforePlaceHolderSb = new StringBuilder();
            }  
                    if (expression.equals(Metadata.ALL)) {
                    } else {  
                            }
     *  
                }
                if (failNoIndices) {  
        }
     * Whether to generate the candidate set from index aliases, or from the set of resolved expressions.
                        case LEFT_BOUND:  
     * @param state             the cluster state containing all the data to resolve to expression to a concrete index
import java.util.Collections;
     * @opensearch.internal  
                    );  
     * <b>NOTE</b>: The provided expressions must have been resolved already via {@link #resolveExpressions}.  
                            break;
                }  
        boolean includeDataStreams,  
        private static final DateFormatter DEFAULT_DATE_FORMATTER = DateFormatter.forPattern("uuuu.MM.dd");  
            return resolveSearchRoutingAllIndices(state.metadata(), routing);
            }
     */
                    }  
     * @param options           defines how the aliases or indices need to be resolved to concrete indices
                                final ZoneId timeZone;
        // List of indices that don't require any routing
import org.opensearch.indices.InvalidIndexNameException;  
     * Identifies whether the array containing index names given as argument explicitly refers to all indices
import org.opensearch.common.Nullable;  
         */
        expressionResolvers.add(wildcardExpressionResolver);
        return (context.options.ignoreThrottled() && metadata.getSettings().getAsBoolean("index.frozen", false)) == false;
     * @throws IllegalArgumentException if the index resolution does not lead to an index, or leads to more than one index
        IndicesOptions combinedOptions = IndicesOptions.fromOptions(
            if (options.expandWildcardsOpen() && options.expandWildcardsClosed()) {  
                }
                if (Regex.isSimpleMatchPattern(indexOrAlias)) {
        Index[] indices = concreteIndices(context, index);  
                            beforePlaceHolderSb.append(c);
                            routings = new HashMap<>();
                // If not, we have a non required alias for this index - no further checking needed
import java.util.HashSet;
            IndicesOptions options
        // Allow system index access - they'll be filtered out below as there's no such thing (yet) as system data streams  
            // faster to iterate indexAliases
            .map(x -> state.metadata().getIndicesLookup().get(x))
                                            inPlaceHolderString
     * Translates the provided index expression into actual concrete indices, properly deduplicated.  
 *
        for (ExpressionResolver expressionResolver : expressionResolvers) {  
                        if (!aliasMetadata.searchRoutingValues().isEmpty()) {  
         * by {@link #filteringAliases(ClusterState, String, Set)} since it's the only one that needs aliases  
         *
        if (skipIdentity == false && resolvedExpressions.contains(index)) {  
            );  
        private final List<RuntimeException> resolutionErrors = new ArrayList<>();
     * contains no indices and the indices options in the context don't allow such a case.
        Set<String> resolvedExpressions  
            .collect(Collectors.toList());
    public Index concreteWriteIndex(ClusterState state, IndicesRequest request) {
            final List<String> resolvedSystemIndices = concreteIndices.stream()
            isSystemIndexAccessAllowed()
        }  
import java.time.Instant;
                                        );
            final String pattern = expression;
                    continue;  
                                        throw new OpenSearchParseException(
                    }
        }  
        }
        // it just resolves the date math to an actual date.  
    }
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collection;
            this.state = state;
     * @return the resolved concrete indices based on the cluster state, indices options and index expressions  
        ClusterState state,
                infe.setResources("index_expression", indexExpressions);
    /**  
                state,
            IndicesOptions options,
                    final IndexMetadata.State excludeState = excludeState(options);
     */  
                if (failNoIndices) {
                            context.addResolutionError(aliasesNotSupportedException(expression));
                    return true;
    }
            if (indicesOrAliases[0].charAt(0) == '-') {
            if (indexAbstraction == null) {  
     * @param state             the cluster state containing all the data to resolve to expression to a concrete index
        public IndicesOptions getOptions() {
        }
     * provided indices options in the context don't allow such a case, or if the final result of the indices resolution  
     *
                assert false : "this shouldn't get called if wildcards expand to none";
                return false;  
                    .withResolutionErrors(infe);
            IndexAbstraction indexAbstraction = state.metadata().getIndicesLookup().get(expression);
            SortedMap<String, IndexAbstraction> indicesLookup,  
        }
        public static Map<String, IndexAbstraction> matches(Context context, Metadata metadata, String expression) {
import java.util.Spliterators;
            }  
                    norouting.add(expression);  
     * Resolve an array of expressions to the set of indices and aliases that these expressions match.
            if (options.ignoreAliases()) {  
         * with <code>preserveAliases</code>.
                        case RIGHT_BOUND:
            }
        boolean skipIdentity,
        }
                            options.expandWildcardsHidden()
            infe.setResources("index_or_alias", expression);  
                if (indexAbstraction.getIndices().size() > 1 && !options.allowAliasesToMultipleIndices()) {
            // if the expression can't be found.
        private static Map<String, IndexAbstraction> suffixWildcard(Context context, Metadata metadata, String expression) {
        );
            throw new IllegalArgumentException(
                    context.addResolutionError(indexNotFoundException(expression));  
     * @param index             index that can be resolved to alias or index name.
        Context context = new Context(state, options, isSystemIndexAccessAllowed());  
        }
     * @return whether the specified index, data stream or alias exists.
 * @opensearch.api
        expressionResolvers.add(dateMathExpressionResolver);  
            }
        return aliasesOrIndices == null || aliasesOrIndices.isEmpty() || isExplicitAllPattern(aliasesOrIndices);
                    return new ArrayList<>(resolvedIncludingDataStreams);
    ResolvedIndices.Local.Concrete concreteResolvedIndices(Context context, String... indexExpressions) {  
                    }  
            }
        }  
                    result.removeAll(expand);  
     * @return the resolved concrete indices based on the cluster state, indices options and index expressions. Any errors
     * @return the resolved concrete indices based on the cluster state, indices options and index expressions
            return itemName.startsWith(".") && expression.startsWith(".") && Regex.isSimpleMatchPattern(expression);
                    continue;
                                        routings = new HashMap<>();  
     * @param options           defines how the aliases or indices need to be resolved to concrete indices
                            routings.remove(expression);  
 *  
        }  
        return concreteResolvedIndices(state, request).concreteIndicesAsArray();
            return preserveDataStreams;
            request.includeDataStreams(),
            if (context.includeDataStreams() == false) {
        return dateMathExpressionResolver.resolveExpression(dateExpression, new Context(null, null, isSystemIndexAccessAllowed()));
            } else {  
                            }
    }  
            // otherwise we check if there's any simple regex
     * @param options           defines how the aliases or indices need to be resolved to concrete indices  
            boolean wildcardSeen = false;
            return new ArrayList<>(result);
                                routings = new HashMap<>();  
            boolean escape = false;
            if (result == null) {
    /**
        private static final char TIME_ZONE_BOUND = '|';  
    public ResolvedIndices.Local.Concrete concreteResolvedIndices(ClusterState state, IndicesRequest request, long startTime) {
                isSystemIndexAccessAllowed
                                    if (inPlaceHolderString.lastIndexOf(RIGHT_BOUND) != inPlaceHolderString.length() - 1) {
            .map(IndexAbstraction::getName)
    /**
                if (indexExpressions.length == 1) {
                        systemIndexName
     * Utility method that allows to resolve an index expression to its corresponding single write index.  
            false,  
            options.expandWildcardsHidden(),
            options.ignoreThrottled()
                    }
                    continue;  
                                    int formatPatternTimeZoneSeparatorIndex = patternAndTZid.indexOf(TIME_ZONE_BOUND);  
        return concreteIndexNames(context, request.indices());
                    } else {
        String... indexExpressions
                                inPlaceHolder = false;  
                        infe = new IndexNotFoundException(expression);
    }
                    if (escapedChar) {  
                }
    /**
        Set<String> paramRouting = null;  
    boolean iterateIndexAliases(int indexAliasesSize, int resolvedExpressionsSize) {  
        return concreteIndexNames(context, request.indices());
                excludeState = IndexMetadata.State.CLOSE;  
 * KIND, either express or implied.  See the License for the
                    // - We cannot perform it before the resolver chain, as we still might have expressions which we
                                } else {  
                        concreteIndices.add(writeIndex.getIndex());
        private final ClusterState state;
    ) {
        final boolean failNoIndices = indexExpressions.length == 1 ? !options.allowNoIndices() : !options.ignoreUnavailable();
            aliasCandidates = resolvedExpressions.stream().map(indexAliases::get).filter(Objects::nonNull).toArray(AliasMetadata[]::new);
            } else if (indexAbstraction.getType() == IndexAbstraction.Type.DATA_STREAM && context.includeDataStreams() == false) {
                "The index expression [" + index + "] and options provided did not point to a single write-index"  
                if (Regex.isSimpleMatchPattern(expression) == false) {
            // faster to iterate resolvedExpressions  
     * @param options           defines how the aliases or indices need to be resolved to concrete indices  
     * given index.  
     * @throws IllegalArgumentException if one of the aliases resolve to multiple indices and the provided
         * result without a thrown exception.
        public boolean isPreserveDataStreams() {  
    }
            if (resolvedSystemIndices.isEmpty() == false) {
            } else {
        return concreteIndexNames(context, request.indices());
         * that we might return aliases that point to a closed index. This is currently only used
     * or aliases with no routing defined the specified routing is used.
                return false;
/*  
package org.opensearch.cluster.metadata;
    public boolean hasIndexAbstraction(String indexAbstraction, ClusterState state) {
                }  
    }
     * @return the resolved concrete indices based on the cluster state, indices options and index expressions. Any errors
                                    String patternAndTZid = inPlaceHolderString.substring(
    /**
        if (isAllIndices(resolvedExpressions)) {
        boolean allowNoIndices,
@PublicApi(since = "1.0.0")  
            request.includeDataStreams(),
        Context(  
                    result.addAll(expand);
            // throw a specific error that is different from the [[IndexNotFoundException]], which is typically thrown  
        RuntimeException getFirstResolutionError() {  
        if (!context.resolutionErrors.isEmpty()) {
                                        throw new OpenSearchParseException(
        }
         * concreteIndexNames(), concreteWriteIndex(), etc. will howe will throw the first resolution error that was
    public ResolvedIndices.Local.Concrete concreteResolvedIndices(  
                        Set<String> r = new HashSet<>(paramRouting);
                            } else {  
     * @param request    request containing expressions that can be resolved to alias, index, or data stream names.
                return ResolvedIndices.Local.Concrete.empty().withResolutionErrors(context.getResolutionErrors());  
                return indicesLookup;  
        Index[] indices = concreteIndices(state, request.indicesOptions(), indexExpression);
    private static boolean shouldTrackConcreteIndex(Context context, IndicesOptions options, IndexMetadata index) {  
        String index,
import org.opensearch.index.IndexNotFoundException;
                                Instant instant = dateMathParser.parse(mathExpression, context::getStartTime, false, timeZone);
    private void checkSystemIndexAccess(Context context, Metadata metadata, Set<Index> concreteIndices, String[] originalPatterns) {  
import java.util.SortedMap;  
                    int i = 0;  
                        )
    }  
            boolean includeHidden  
                                String dateFormatterPattern;
import java.util.Objects;
                                + "]."  
        Context context = new Context(state, IndicesOptions.lenientExpandOpen(), true, false, true, isSystemIndexAccessAllowed());
        // we changed it to look at the `index.frozen` setting instead, since frozen indices were the only
            return null;  
                        result.add(expression);
     * provided indices options in the context don't allow such a case, or if the final result of the indices resolution
                String expression = expressions.get(i);  
    public Set<String> resolveExpressions(ClusterState state, String... expressions) {
     * Same as {@link #concreteIndices(ClusterState, IndicesOptions, String...)}, but the index expressions and options  
            throw context.resolutionErrors.getFirst();
     * @param state      the cluster state containing all the data to resolve to expressions to concrete indices  
    }
     */  
        }
    /**  
            } else {
    }
            ClusterState state,
            // only check open/closed since if we do not expand to open or closed it doesn't make sense to
                System.currentTimeMillis(),  
            String expression,
                if (context.includeDataStreams()) {
     */  
        return concreteResolvedIndices(context, indexExpressions);
                        expand(
        if (aliases == null) {
                    if (result != null) {
     */
                }
import org.opensearch.cluster.ClusterState;
    public ResolvedIndices.Local.Concrete concreteResolvedIndices(ClusterState state, IndicesRequest request) {
            IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(expression);  
     * that require a single index as a result. The indices resolution must in fact return a single index when
        }
                            r.addAll(aliasMetadata.searchRoutingValues());
    public String resolveDateMathExpression(String dateExpression) {
            }  
        IndicesOptions options,  
                    }  
    }  
                .toArray(AliasMetadata[]::new);
     * @param state             the cluster state containing all the data to resolve to expression to a concrete index
        }
/*  
        }  
                resolveToWriteIndex,
     * Identifies whether the first argument (an array containing index names) is a pattern that matches all indices
                    // will have expanded wildcards to potentially many indices. If we did these checks then,
                    String concreteIndex = item.v1();  
            finalExpressions = resolver.resolve(context, finalExpressions);  
        }
     * @param resolvedExpressionsSize the number of resolved expressions  
     * @param state             the cluster state containing all the data to resolve to expressions to concrete indices
                IndexAbstraction.Alias alias = (IndexAbstraction.Alias) indexAbstraction;
                    continue;
                            }  
import java.util.ArrayList;
        this.threadContext = Objects.requireNonNull(threadContext, "Thread Context must not be null");  
            boolean resolveToWriteIndex,
            IndicesOptions options,  
        expressionResolvers = new ArrayList<>(customResolvers);
                return otherWildcard(context, metadata, expression);
                        )  
                stream = stream.filter(filter);  
                    infe.setResources("index_expression", expression);  
            false,  
            } else if (options.expandWildcardsClosed()) {  
public class IndexNameExpressionResolver {
                            + "indices will be prevented by default",
            boolean resolveToWriteIndex,
            );
 * the Apache License, Version 2.0 (the "License"); you may
        );
        private final boolean resolveToWriteIndex;  
                    // dedup backing indices if expand hidden indices option is true
        public ClusterState getState() {  
                return stream.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
/*
                    // and WildcardExpressionResolver, which only checks the non-wildcard index names.
            }
                        }  
                    if (!norouting.contains(concreteIndex)) {
        }  
        protected Context(
            for (String expression : expressions) {
     * Sets the same routing for all indices
    }
                .map(metadata::index)  
            this(state, options, System.currentTimeMillis(), isSystemIndexAccessAllowed);
    /**  
     * @param indexExpressions  expressions that can be resolved to alias or index names.  
                    }
            }
                    context.addResolutionError(
     * provided indices options in the context don't allow such a case, or if the final result of the indices resolution  
import java.util.Map;  
                            context,  
                }
 *
            Set<String> expand = new HashSet<>();
                if (indexAbstraction.isHidden() == false || includeHidden || implicitHiddenMatch(aliasOrIndexName, expression)) {
     * @param startTime  The start of the request where concrete indices is being invoked for
            boolean shouldConsumeStream = false;
                                r = new HashSet<>();
     * @return the write index obtained as a result of the index resolution
        }
        );
 * specific language governing permissions and limitations
            if (inPlaceHolder) {  
                                inPlaceHolderSb.append(c);  
    /**  
                infe.addMetadata(EXCLUDED_DATA_STREAMS_KEY, "true");
                                    if (routings != null) {
                                throw new OpenSearchParseException(
                                + " ["
            if (expression.startsWith(EXPRESSION_LEFT_BOUND) == false || expression.endsWith(EXPRESSION_RIGHT_BOUND) == false) {
     * Same as {@link #concreteIndexNames(ClusterState, IndicesRequest)}, but access to system indices is always allowed.  
     */
     * @return true if the provided array explicitly maps to all indices, false otherwise  
                }
        public List<String> resolve(final Context context, List<String> expressions) {  
                shouldConsumeStream = true;  
            }
    }
        for (String expression : expressions) {
     * Translates the provided index expression into actual concrete indices, properly deduplicated.
                    // The following code enforces the ignoreUnavailable rule for non-wildcard expressions.  
         * @return a new list with expressions based on the provided expressions  
     * @param indicesOrAliases the array containing index names  
                }  
            for (String index : concreteIndices) {  
        );  
                String aliasOrIndexName = entry.getKey();
            return true;
 * not use this file except in compliance with the License.
                                inPlaceHolderSb.append(c);  
        return indices[0];
            if (indexAbstraction.getType() == IndexAbstraction.Type.ALIAS && context.isResolveToWriteIndex()) {
            if (options.expandWildcardsClosed() == false && options.expandWildcardsOpen() == false) {
            boolean preserveAliases,
                        } else if (indexAbstraction.getType() == IndexAbstraction.Type.ALIAS && options.ignoreAliases()) {  
            this(  
        public List<String> resolve(Context context, List<String> expressions) {
        }
                    String[] indexNames = new String[indexAbstraction.getIndices().size()];
                                        routings.remove(concreteIndex);
                return Arrays.asList(metadata.getConcreteAllOpenIndices());
            request.indicesOptions(),
    /**  
            );
        private static final char ESCAPE_CHAR = '\\';
    public Map<String, Set<String>> resolveSearchRouting(ClusterState state, @Nullable String routing, String... expressions) {
        }
     */
            options.allowAliasesToMultipleIndices(),
    }  
        Context context = new Context(state, options, false, false, true, true, true);
    public Index concreteWriteIndex(
            }
            Set<String> r = Sets.newHashSet(Strings.splitStringByCommaToArray(routing));  
     * names() to access the names of the requested indices in a way that is safe from thrown exceptions due to
            }
        String indexExpression = CollectionUtils.isEmpty(request.indices()) ? null : request.indices()[0];  
                    if (context.isPreserveAliases() && indexAbstraction.getType() == IndexAbstraction.Type.ALIAS) {
                                    }
                List<String> resolvedExpressions = resolveEmptyOrTrivialWildcard(options, metadata);  
        }  
        private static Map<String, IndexAbstraction> otherWildcard(Context context, Metadata metadata, String expression) {  
            Map<String, Set<String>> routings = new HashMap<>();
                    // we would do many redundant checks, which would harm performance.
            }
        // type of index to use the `search_throttled` threadpool at that time.  
        }
        Context(
    }
            IndexNotFoundException infe = new IndexNotFoundException((String) null);  
                                } else {  
    static final class WildcardExpressionResolver implements ExpressionResolver {
                shouldConsumeStream = true;
     */
            }
                            if (inDateFormat && escapedChar) {
                }
            Set<String> result = innerResolve(context, expressions, options, metadata);  
            state,
                metadata.getIndicesLookup(),
    public Index[] concreteIndices(ClusterState state, IndicesOptions options, String... indexExpressions) {
        if (indexMetadata == null) {
            IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(expression);
import java.util.stream.StreamSupport;
    /**
                                + Arrays.toString(indexNames)
            return isSystemIndexAccessAllowed;
            // or something like /-test1 with test1 index missing and IndicesOptions.lenient()  
     * encountered during the resolution will be not thrown immediately as an exception, but only when you try
        List<String> resolvedExpressions = expressions != null ? Arrays.asList(expressions) : Collections.emptyList();  
                        result.remove(expression);
        }
 */
     * The empty or null array identifies all indices
                                    } else {
            throw new IllegalStateException("index state [" + index.getState() + "] not supported");
     */
     *
     * indices options in the context don't allow such a case.
            Context context,
        private static final String EXPRESSION_RIGHT_BOUND = ">";
     *
        }
            } else if (options.expandWildcardsOpen() && options.expandWildcardsClosed() == false) {
        return concreteResolvedIndices(context, request.indices());  
    public Index concreteSingleIndex(ClusterState state, IndicesRequest request) {
            false,
     *
            return filterIndicesLookup(
    public interface ExpressionResolver {  
        Context context = new Context(state, request.indicesOptions(), false, false, request.includeDataStreams(), true);  
                    }
        Set<String> acceptedExpressions = new HashSet<>(expressions.size());  
            options.ignoreAliases(),
     * <p>Only aliases with filters are returned. If the indices list contains a non-filtering reference to
                    AliasMetadata aliasMetadata = item.v2();
     * @param indexAliasesSize        the number of aliases of the index
     * @opensearch.internal  
            );  
                        infe = new IndexNotFoundException((String) null);
        }
                    // there is no good other place to perform this logic:  
        }
                            }
                                    Set<String> r = new HashSet<>(paramRouting);
                excludeState = null;
            // expand to hidden  
    /**
     *                          and the expression that can be resolved to an alias or an index name.  
                    Set<String> resolvedIncludingDataStreams = new HashSet<>(resolvedExpressions);  
                    if (indexExpressions[0].equals(Metadata.ALL)) {
        if (isAllIndices(resolvedExpressions)) {
     */
                            if (paramRouting != null) {
 * SPDX-License-Identifier: Apache-2.0
        Predicate<AliasMetadata> requiredAlias,
        /**
        private boolean isEmptyOrTrivialWildcard(List<String> expressions) {
         */
    public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
            this(  
        if (iterateIndexAliases(indexAliases.size(), resolvedExpressions.size())) {  
                return this.resolutionErrors.getFirst();
        // if we end up matching on all indices, check, if its a wildcard parameter, or a "-something" structure
                stream = stream.filter(e -> e.getValue().getType() != IndexAbstraction.Type.DATA_STREAM);
        @Override
            return routings;  
     * to access the concrete indices from the ResolvedIndices.Local.Concrete object. You can use the method
        // TODO: it appears that this can never be true?  
                            } else {
 */  
        return new IllegalArgumentException(  
        return null;
import org.opensearch.OpenSearchParseException;
    ) {
                    context.addResolutionError(aliasesNotSupportedException(expression));
            false,  
         */  
                                routings.remove(concreteIndex);  
     * @param indexExpressions  expressions that can be resolved to alias or index names.
                );
        /**  
                            }
            String toPrefix = new String(toPrefixCharArr);
        }  
        final Map<String, AliasMetadata> indexAliases = indexMetadata.getAliases();
    public IndexNameExpressionResolver(ThreadContext threadContext) {
                                + "] has more than one index associated with it "  
                char c = text[i];
            throw new IndexNotFoundException(index);  
                    );
        /**  
        return concreteWriteIndex(state, request.indicesOptions(), request.indices()[0], false, request.includeDataStreams());
import java.time.ZoneOffset;
    }
                if (escape) {  
            Set<String> result = null;  
     * @throws IndexNotFoundException if one of the index expressions is pointing to a missing index or alias and the
                resolvedSystemIndices.forEach(  
     * resolution errors.  
                    switch (c) {
        }
                routings.put(index, r);
            // Expressions can not start with an underscore. This is reserved for APIs. If the check gets here, the API
                                + ", can't execute a single index op"
                context,  
        }
                        } else {
                    )  
        }
            for (int i = 0; i < expressions.size(); i++) {
                return Arrays.asList(metadata.getConcreteVisibleClosedIndices());
            this.preserveAliases = preserveAliases;
    public static final String EXCLUDED_DATA_STREAMS_KEY = "opensearch.excluded_ds";
     * encountered during the resolution will be not thrown immediately as an exception, but only when you try  
     *  
                                + " The write index may be explicitly disabled using is_write_index=false or the alias points to multiple"
                            } else if (inDateFormat) {
            this.resolveToWriteIndex = resolveToWriteIndex;  
    }
        private static IndexNotFoundException indexNotFoundException(String expression) {
                } else {
     *
     * are encapsulated in the specified request.  
        }
                                    }  
        private static boolean implicitHiddenMatch(String itemName, String expression) {
                        result.add(expression);
                                    mathExpression = inPlaceHolderString.substring(0, dateTimeFormatLeftBoundIndex);
            if (requiredAlias.test(aliasMetadata)) {  
                        if (indexAbstraction == null) {
                    for (IndexMetadata indexMetadata : indexAbstraction.getIndices()) {
        }
 * The OpenSearch Contributors require contributions made to  
            return options;
                    final Map<String, IndexAbstraction> dataStreamsAbstractions = metadata.getIndicesLookup()  
            return startTime;  
        return indexAliasesSize <= resolvedExpressionsSize;
     * @param state      the cluster state containing all the data to resolve to expressions to concrete indices
        return state.metadata().getIndicesLookup().containsKey(resolvedAliasOrIndex);
            state,  
        }  
        private final boolean preserveDataStreams;
                    // add all the previous ones...
    private static boolean addIndex(IndexMetadata metadata, Context context) {
            // treat aliases as unavailable indices when ignoreAliases is set to true (e.g. delete index and update aliases api)
     * @return the concrete index obtained as a result of the index resolution  
                return Arrays.asList(metadata.getConcreteAllClosedIndices());
        private static IndexMetadata.State excludeState(IndicesOptions options) {
            startTime,
        List<String> resolvedExpressions = Arrays.asList(expressions);  
    public String[] concreteIndexNames(ClusterState state, IndicesOptions options, boolean includeDataStreams, String... indexExpressions) {
                                inPlaceHolderSb.append(c);  
            IndicesOptions options = context.getOptions();  
import org.opensearch.action.support.IndicesOptions;  
                if (expression.charAt(0) == '-' && wildcardSeen) {
                        case LEFT_BOUND:
        boolean isPreserveAliases() {
                                inPlaceHolderSb = new StringBuilder();
    }  
     *  
        private static final String EXPRESSION_LEFT_BOUND = "<";
    /**
                continue;
        return concreteResolvedIndices(state, options, includeDataStreams, indexExpressions).concreteIndicesAsArray();
     * Same as {@link #concreteIndices(ClusterState, IndicesOptions, String...)}, but the index expressions and options
                    if (options.ignoreUnavailable() == false) {
                }
                }  
        private static Set<String> expand(
    }  
                    } else {  
     */
        return concreteResolvedIndices(state, request, startTime).concreteIndicesAsArray();
                        }  
            if (shouldConsumeStream) {  
     * contains no indices and the indices options in the context don't allow such a case.
        if (request.indices() == null || (request.indices() != null && request.indices().length != 1)) {
        }
     * @param aliasesOrIndices the array containing index names  
                    // should be responsible only for wildcard expressions. However - given the current architecture -
                .collect(Collectors.toList());
            request.includeDataStreams(),
     * @throws IndexNotFoundException if one of the index expressions is pointing to a missing index or alias and the
                            }
                            context.addResolutionError(indexNotFoundException(expression));
            boolean includeDataStreams,
            } else if (options.expandWildcardsClosed() && options.expandWildcardsOpen() == false) {
        @Override
        return routings;
    }
     * @param aliasesOrIndices the array containing index names
     * to access the concrete indices from the ResolvedIndices.Local.Concrete object. You can use the method  
                        default:
        private static boolean aliasOrIndexExists(Context context, IndicesOptions options, Metadata metadata, String expression) {
     *
            return result;
