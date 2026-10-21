    /**
    ) {
     * to create the system generated processor from a given search request.
     * in pipeline configurations, and the value is a {@link org.opensearch.search.pipeline.Processor.Factory}
     * Returns additional system generated search pipeline request processor types added by this plugin.
    ) {
        public final AnalysisRegistry analysisRegistry;
            NamedXContentRegistry namedXContentRegistry
    }
    /**
            ThreadContext threadContext,
         */
    /**
     * {@link SystemGeneratedProcessor.ExecutionStage}.
import org.opensearch.core.xcontent.NamedXContentRegistry;
            this.analysisRegistry = analysisRegistry;
        /**
        Parameters parameters
         * Provide analyzer support
        public final NamedXContentRegistry namedXContentRegistry;
     */
        public final ThreadContext threadContext;
            this.relativeTimeSupplier = relativeTimeSupplier;
    /**
     * to create the processor from a given pipeline configuration.
        /**
         * Provides processors script support.
        getSystemGeneratedSearchPhaseResultsProcessors(Parameters parameters) {
        public final LongSupplier relativeTimeSupplier;
     * The execution order between system-gen and user-defined is [pre, user, post] and default is post. Use
        public final Client client;
 * compatible open source license.
        public static final String SEARCH_REQUEST = "search_request";
     * The key of the returned {@link Map} is the unique name for the processor, and the value is a
        Parameters parameters
        return Collections.emptyMap();
            ScriptService scriptService,
     * Returns additional search pipeline request processor types added by this plugin.
        public final Consumer<Runnable> genericExecutor;
         * Provides access to the node's cluster client
import java.util.Map;
            Client client,
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>>
     * The execution order between system-gen and user-defined is [pre, user, post] and default is post. Use
import org.opensearch.search.pipeline.Processor;
import org.opensearch.env.Environment;
     * {@link SystemGeneratedProcessor.ExecutionStage}.
     */
     * getExecutionStage of the {@link SystemGeneratedProcessor} to define the
     * <p>
    default Map<String, Processor.Factory<SearchPhaseResultsProcessor>> getSearchPhaseResultsProcessors(Parameters parameters) {
     * The key of the returned {@link Map} is the unique name for the processor which is specified
        /**
        return Collections.emptyMap();
     *
import org.opensearch.index.analysis.AnalysisRegistry;
     * The key of the returned {@link Map} is the unique name for the processor which is specified
    }
     * Returns additional search pipeline response processor types added by this plugin.
import java.util.Collections;
import java.util.function.BiFunction;
        /**
import org.opensearch.common.util.concurrent.ThreadContext;
import java.util.function.Consumer;
 * The OpenSearch Contributors require contributions made to
         */
 *
         */
    class SystemGeneratedSearchPipelineConfigKeys {
package org.opensearch.plugins;
     */
     * Returns additional system generated search pipeline search phase results processor types added by this plugin.
        public final BiFunction<Long, Runnable, Scheduler.ScheduledCancellable> scheduler;
import org.opensearch.search.pipeline.SearchRequestProcessor;
        return Collections.emptyMap();
     * The execution order between system-gen and user-defined is [pre, user, post] and default is post. Use
    /**
        ) {
     * <p>
    }
     * in pipeline configurations, and the value is a {@link org.opensearch.search.pipeline.Processor.Factory}
import java.util.function.LongSupplier;
         * Provides scheduler support
     * getExecutionStage of the {@link SystemGeneratedProcessor} to define the
}
         */
    default Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> getSystemGeneratedRequestProcessors(
            AnalysisRegistry analysisRegistry,
import org.opensearch.transport.client.Client;
     * Returns additional system generated search pipeline response processor types added by this plugin.
     * to create the system generated processor from a given search request.
     * The key of the returned {@link Map} is the unique name for the processor, and the value is a
            this.namedXContentRegistry = namedXContentRegistry;
/*
        return Collections.emptyMap();
     * {@link SystemGeneratedProcessor.ExecutionStage}.
     * {@link SystemGeneratedProcessor.SystemGeneratedFactory}
         */
     * Available config keys for the system generated search pipeline
        public final Environment env;
    }
    default Map<String, Processor.Factory<SearchRequestProcessor>> getRequestProcessors(Parameters parameters) {
            this.scheduler = scheduler;
            Environment env,
     */
 * An extension point for {@link Plugin} implementation to add custom search pipeline processors.
            this.client = client;
import org.opensearch.script.ScriptService;
            this.genericExecutor = genericExecutor;
     * <p>
        /**
 */
import org.opensearch.search.pipeline.SearchPipelineService;
/**
         */
        public final ScriptService scriptService;
         * The parsed search request sent by users
 */
     * and that gets passed around to all {@link SearchPipelinePlugin}s.
        /**
     * <p>
    default
 * SPDX-License-Identifier: Apache-2.0
        return Collections.emptyMap();
    }
    default Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> getSystemGeneratedResponseProcessors(
     * getExecutionStage of the {@link SystemGeneratedProcessor} to define the
     */
            SearchPipelineService searchPipelineService,
            this.env = env;
import org.opensearch.search.pipeline.SystemGeneratedProcessor;
            LongSupplier relativeTimeSupplier,
    }
     * <p>
    /**
            this.searchPipelineService = searchPipelineService;
     */
     *
     * to create the processor from a given pipeline configuration.
import org.opensearch.search.pipeline.SearchResponseProcessor;
     * to create the processor from a given pipeline configuration.
         * Allows processors to read headers set by {@link org.opensearch.action.support.ActionFilter}
     * {@link SystemGeneratedProcessor.SystemGeneratedFactory}
            Consumer<Runnable> genericExecutor,
import org.opensearch.search.pipeline.SearchPhaseResultsProcessor;
        }
            this.scriptService = scriptService;
        public final SearchPipelineService searchPipelineService;
    default Map<String, Processor.Factory<SearchResponseProcessor>> getResponseProcessors(Parameters parameters) {
 * this file be licensed under the Apache-2.0 license or a
    /**
 *
     * Returns additional search pipeline search phase results processor types added by this plugin.
import org.opensearch.threadpool.Scheduler;
    /**
        public static final String PARENT_ACTION = "parent_action";
 * @opensearch.api
         * instances that have run while handling the current search.
    class Parameters {
         * Useful to provide access to the node's environment like config directory to processor factories.
     * <p>
    }
     * {@link SystemGeneratedProcessor.SystemGeneratedFactory}
            BiFunction<Long, Runnable, Scheduler.ScheduledCancellable> scheduler,
     * to create the system generated processor from a given search request.
public interface SearchPipelinePlugin {
     * Infrastructure class that holds services that can be used by processor factories to create processor instances
     * The key of the returned {@link Map} is the unique name for the processor, and the value is a
     * in pipeline configurations, and the value is a {@link org.opensearch.search.pipeline.Processor.Factory}
     */
     *
     * The key of the returned {@link Map} is the unique name for the processor which is specified
    }
     */
        public Parameters(
         */
            this.threadContext = threadContext;
        /**
        return Collections.emptyMap();
