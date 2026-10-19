        ) {
        public final Consumer<Runnable> genericExecutor;
 *
    /**  
     * Returns additional system generated search pipeline search phase results processor types added by this plugin.  
     * The execution order between system-gen and user-defined is [pre, user, post] and default is post. Use
     */  
     */
import org.opensearch.search.pipeline.SearchPipelineService;
    default Map<String, Processor.Factory<SearchRequestProcessor>> getRequestProcessors(Parameters parameters) {
            this.namedXContentRegistry = namedXContentRegistry;  
        /**  
     * to create the processor from a given pipeline configuration.
         */
            this.searchPipelineService = searchPipelineService;  
        public final SearchPipelineService searchPipelineService;
import org.opensearch.transport.client.Client;
import org.opensearch.search.pipeline.SystemGeneratedProcessor;
            AnalysisRegistry analysisRegistry,  
     * to create the processor from a given pipeline configuration.
        return Collections.emptyMap();  
     * getExecutionStage of the {@link SystemGeneratedProcessor} to define the
         */  
package org.opensearch.plugins;
     * Infrastructure class that holds services that can be used by processor factories to create processor instances
import java.util.function.BiFunction;
     * {@link SystemGeneratedProcessor.SystemGeneratedFactory}
     * The execution order between system-gen and user-defined is [pre, user, post] and default is post. Use
    default Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> getSystemGeneratedRequestProcessors(  
     * to create the system generated processor from a given search request.
     * in pipeline configurations, and the value is a {@link org.opensearch.search.pipeline.Processor.Factory}  
/**  
        public final Client client;
            this.threadContext = threadContext;
        public static final String SEARCH_REQUEST = "search_request";  
import org.opensearch.search.pipeline.SearchRequestProcessor;  
    /**  
        public final ScriptService scriptService;
     * The key of the returned {@link Map} is the unique name for the processor which is specified  
 * compatible open source license.
         * The parsed search request sent by users
     * Returns additional search pipeline request processor types added by this plugin.
    /**
            Environment env,
         * Provide analyzer support
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
/*  
import org.opensearch.search.pipeline.SearchResponseProcessor;
    class Parameters {
        public final AnalysisRegistry analysisRegistry;
    }
    ) {
     */
    }  
     * <p>
     * The key of the returned {@link Map} is the unique name for the processor, and the value is a
            ThreadContext threadContext,
    /**
import java.util.function.LongSupplier;
     * to create the system generated processor from a given search request.  
        /**
         */
            Client client,
        }
         * Provides access to the node's cluster client
     * Returns additional search pipeline search phase results processor types added by this plugin.  
     *
         */  
     * <p>
 * @opensearch.api  
 *
        Parameters parameters
import org.opensearch.search.pipeline.SearchPhaseResultsProcessor;
        public final BiFunction<Long, Runnable, Scheduler.ScheduledCancellable> scheduler;
         */  
            Consumer<Runnable> genericExecutor,  
     * {@link SystemGeneratedProcessor.ExecutionStage}.
         * Provides processors script support.  
     * The key of the returned {@link Map} is the unique name for the processor, and the value is a
import org.opensearch.script.ScriptService;
     * Available config keys for the system generated search pipeline  
         * Provides scheduler support  
    /**
     * {@link SystemGeneratedProcessor.ExecutionStage}.  
     */  
     * and that gets passed around to all {@link SearchPipelinePlugin}s.
        getSystemGeneratedSearchPhaseResultsProcessors(Parameters parameters) {
        public final ThreadContext threadContext;
    }
     * Returns additional system generated search pipeline request processor types added by this plugin.
    }  
 * An extension point for {@link Plugin} implementation to add custom search pipeline processors.
     * to create the system generated processor from a given search request.
        /**  
        public final NamedXContentRegistry namedXContentRegistry;  
    default Map<String, Processor.Factory<SearchPhaseResultsProcessor>> getSearchPhaseResultsProcessors(Parameters parameters) {
            SearchPipelineService searchPipelineService,
    default Map<String, Processor.Factory<SearchResponseProcessor>> getResponseProcessors(Parameters parameters) {  
     * <p>  
import java.util.function.Consumer;  
    }  
     * to create the processor from a given pipeline configuration.
     * {@link SystemGeneratedProcessor.SystemGeneratedFactory}  
        public final LongSupplier relativeTimeSupplier;  
     * The execution order between system-gen and user-defined is [pre, user, post] and default is post. Use  
        public final Environment env;  
         * Useful to provide access to the node's environment like config directory to processor factories.
     * Returns additional search pipeline response processor types added by this plugin.  
     */
import java.util.Collections;  
     *  
    /**
}  
     */  
     */
 */  
            this.scheduler = scheduler;
    /**  
         */
            this.env = env;  
     * getExecutionStage of the {@link SystemGeneratedProcessor} to define the
    }  
     * in pipeline configurations, and the value is a {@link org.opensearch.search.pipeline.Processor.Factory}  
     * getExecutionStage of the {@link SystemGeneratedProcessor} to define the  
     * <p>
import org.opensearch.index.analysis.AnalysisRegistry;
        /**
 * SPDX-License-Identifier: Apache-2.0
        Parameters parameters  
        return Collections.emptyMap();
         */
    }
 * The OpenSearch Contributors require contributions made to  
         * Allows processors to read headers set by {@link org.opensearch.action.support.ActionFilter}
            this.genericExecutor = genericExecutor;
public interface SearchPipelinePlugin {
     * The key of the returned {@link Map} is the unique name for the processor which is specified
 * this file be licensed under the Apache-2.0 license or a
            ScriptService scriptService,
        return Collections.emptyMap();
     * The key of the returned {@link Map} is the unique name for the processor which is specified
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>>
        /**  
            this.relativeTimeSupplier = relativeTimeSupplier;
     *
import org.opensearch.search.pipeline.Processor;  
        /**
            this.analysisRegistry = analysisRegistry;  
            this.client = client;
 */
        return Collections.emptyMap();
     * <p>
import java.util.Map;
    /**
    class SystemGeneratedSearchPipelineConfigKeys {
     * Returns additional system generated search pipeline response processor types added by this plugin.
import org.opensearch.threadpool.Scheduler;  
     * <p>
            LongSupplier relativeTimeSupplier,
        return Collections.emptyMap();  
        /**
     * The key of the returned {@link Map} is the unique name for the processor, and the value is a  
     * in pipeline configurations, and the value is a {@link org.opensearch.search.pipeline.Processor.Factory}
            NamedXContentRegistry namedXContentRegistry
    ) {
import org.opensearch.common.util.concurrent.ThreadContext;
        public Parameters(  
    default  
    default Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> getSystemGeneratedResponseProcessors(
     * {@link SystemGeneratedProcessor.SystemGeneratedFactory}
            BiFunction<Long, Runnable, Scheduler.ScheduledCancellable> scheduler,  
            this.scriptService = scriptService;
import org.opensearch.env.Environment;  
     */
        return Collections.emptyMap();
         * instances that have run while handling the current search.
     * {@link SystemGeneratedProcessor.ExecutionStage}.
        public static final String PARENT_ACTION = "parent_action";
