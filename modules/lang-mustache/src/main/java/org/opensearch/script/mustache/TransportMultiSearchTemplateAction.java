                breaker.addWithoutBreaking(-chargedBytes);
    public TransportMultiSearchTemplateAction(
                    } else if (delta < 0) {
        }
}  
        long[] trackedBytes = { 0L };  
            multiSearchRequest.maxConcurrentSearchRequests(request.maxConcurrentSearchRequests());
                    final double actualMultiplier = (double) actualBytes / rawScriptBytes;
            listener.onFailure(
package org.opensearch.script.mustache;
        Setting.Property.Dynamic  
                SearchTemplateRequest searchTemplateRequest = request.requests().get(i);  
import org.opensearch.core.xcontent.NamedXContentRegistry;
                // The full footprint per template has two components:
            return;
import org.opensearch.transport.TransportService;
                // Release breaker bytes now that the response has been assembled and sent.
                        ) {  
                    // a BytesStreamOutput. This captures structural complexity (stored fields,
        MultiSearchTemplateResponse.Item[] items = new MultiSearchTemplateResponse.Item[numRequests];  
        this.maxTemplateBatchSize = MAX_TEMPLATE_BATCH_SIZE_SETTING.get(settings);
 * compatible open source license.
        // PRIMARY GUARD: reject batches that exceed the sub-request count limit before any
                    // Update EMA with full actual footprint ratio (rendered + parsed) / raw.
                // in-memory size via bulkRequest.ramBytesUsed() against IndexingPressure.  
    private final CircuitBreakerService circuitBreakerService;  
            for (int i = 0; i < items.length; i++) {
        this.circuitBreakerService = circuitBreakerService;  
     * heap exhaustion by a large _msearch/template batch. A hard limit on sub-request count is the  
        final double[] emaMultiplier = { INITIAL_EMA_MULTIPLIER };
                // EMA tracks (rendered + parsed) / raw so pre-charges for subsequent templates
                    multiSearchRequest.add(searchRequest);
                trackedBytes[0] += estimatedBytes;  
        // (templates within a batch are structurally similar), giving accurate pre-charges  
                    final long delta = actualBytes - estimatedBytes;  
    protected void doExecute(Task task, MultiSearchTemplateRequest request, ActionListener<MultiSearchTemplateResponse> listener) {  
                //
                    final long renderedBytes = searchTemplateResponse.getSource().length();
                // Pre-charge estimated bytes BEFORE rendering. Uses the current EMA multiplier
                    emaMultiplier[0] = EMA_ALPHA * actualMultiplier + (1.0 - EMA_ALPHA) * emaMultiplier[0];  
 * SPDX-License-Identifier: Apache-2.0
                        trackedBytes[0] += delta; // delta is negative
            }  
                    // It is an underestimate of the true object-graph size (no Java object  
        1,
 * Unless required by applicable law or agreed to in writing,
                //  
        }  
                // footprint, not just the raw JSON size. This mirrors how _bulk accounts for
        final long chargedBytes = trackedBytes[0];
                for (int i = 0; i < r.getResponses().length; i++) {
                SearchTemplateResponse searchTemplateResponse = new SearchTemplateResponse();
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
                            org.opensearch.common.io.stream.BytesStreamOutput out = new org.opensearch.common.io.stream.BytesStreamOutput()
import java.util.List;  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
                        + maxTemplateBatchSize  
        // expansions). It adapts quickly: if templates don't expand, it drops toward 1.0;
 * Modifications Copyright OpenSearch Contributors. See
                            searchRequest.source().writeTo(out);
    @Inject  
                }
import org.opensearch.common.inject.Inject;  
                        }  
        try {
        // (rendered / raw-script) expansion ratio. Pre-charge (rawBytes × emaMultiplier)  
        if (request.maxConcurrentSearchRequests() != 0) {
                listener.onResponse(new MultiSearchTemplateResponse(items, r.getTook().millis()));
 * software distributed under the License is distributed on an
/*  
                // 2. parsedBytes — the SearchSourceBuilder object graph (implements Accountable  
                // due to Java object overhead for parsed fields, aggregations, etc.
                // Charging both components ensures the child breaker reflects the true heap
        this.scriptService = scriptService;  
                // converge to the full actual footprint, not just the JSON wire size.  
        //
import org.opensearch.action.support.HandledTransportAction;
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
        // for subsequent templates without any external configuration.
import org.opensearch.action.search.SearchRequest;  
                    originalSlots.add(i);  
        Settings settings,
 * this work for additional information regarding copyright
                    // correctly escalates when parsed requests are large.
                // Adjust charge to actual full heap footprint, then update EMA.
                    }
        // rendering occurs. This prevents the O(N*renderSize) heap fan-out that can OOM the
        // SECONDARY GUARD: adaptive circuit-breaker accounting with EMA multiplier.
 * ownership. Elasticsearch licenses this file to you under  
                        breaker.addWithoutBreaking(delta);
 *  
                    "Batch size "  
     */  
        // coordinator heap. The limit is configurable via  
/*  
 * Licensed to Elasticsearch under one or more contributor  
        1024,  
                        + " exceeds search.max_multi_search_template_requests limit of "
                        + numRequests
        // After 3-5 templates the EMA converges to the actual expansion ratio of this batch
        // Solution: maintain a per-request Exponential Moving Average (EMA) of the
    /**  
        multiSearchRequest.indicesOptions(request.indicesOptions());  
                // so the estimate tracks the actual expansion ratio of this batch.
    }
        final double INITIAL_EMA_MULTIPLIER = 4.0;  
        // if they do, it escalates so the CB fires before the next allocation.
                        breaker.addEstimateBytesAndMaybeBreak(delta, "msearch_template_rendered_source");  
        ActionFilters actionFilters,
                    if (delta > 0) {
import org.opensearch.common.settings.Setting;
        Setting.Property.NodeScope,
                    // Estimate parsed heap footprint by re-serialising SearchSourceBuilder to  
    private final ScriptService scriptService;  
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        super(MultiSearchTemplateAction.NAME, transportService, actionFilters, MultiSearchTemplateRequest::new);
    );
        List<Integer> originalSlots = new ArrayList<>();
                    int originalSlot = originalSlots.get(i);
                new IllegalArgumentException(
                }
                            // still drive the EMA conservatively.
            try {
                    }  
import org.opensearch.core.common.breaker.CircuitBreaker;
        // EMA update per template: ema = α × (rendered/raw) + (1−α) × ema, α = 0.3
                    items[i] = new MultiSearchTemplateResponse.Item(null, e);
                    // footprint estimation, consider having SearchSourceBuilder implement
import static org.opensearch.script.mustache.TransportSearchTemplateAction.convert;
    private volatile int maxTemplateBatchSize;
        } catch (Exception e) {  
        // before each render, then adjust to actual rendered bytes and update the EMA.
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.action.search.MultiSearchRequest;
import org.opensearch.common.settings.Settings;  
            }
        // Capture for use in the listener lambdas.
                    final long actualBytes = renderedBytes + parsedBytes;
        // Initial multiplier is conservatively high (4.0 — covers most real-world param  
                        trackedBytes[0] += delta;
            } finally {  
        //  
        CircuitBreaker breaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
                    MultiSearchResponse.Item item = r.getResponses()[i];  
    private final NodeClient client;
                    if (item.isFailure()) {
                if (searchRequest != null) {
                    searchRequest = convert(searchTemplateRequest, searchTemplateResponse, scriptService, xContentRegistry);
                    // overhead), but it makes the EMA track the right order of magnitude and
        client.multiSearch(multiSearchRequest, ActionListener.wrap(r -> {  
        this.client = client;
        }
        this.xContentRegistry = xContentRegistry;
                if (searchTemplateResponse.getSource() != null && rawScriptBytes > 0) {
                // 1. renderedBytes — the rendered JSON string retained on SearchTemplateResponse
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
        if (numRequests > maxTemplateBatchSize) {  
        // search.max_multi_search_template_requests (default 1024).
        // never allocates beyond what the breaker allows. The challenge is we don't know
    public static final Setting<Integer> MAX_TEMPLATE_BATCH_SIZE_SETTING = Setting.intSetting(
    @Override
/*
 *
import org.opensearch.action.support.ActionFilters;
            // Release any bytes already charged before propagating (e.g. CircuitBreakerException).
 */
        }, e -> {
            return;
        ClusterSettings clusterSettings  
        // We MUST fire the breaker BEFORE calling convert() so that the Mustache renderer
        ScriptService scriptService,
 * KIND, either express or implied.  See the License for the
                    // can get the true object-graph size without re-serialisation overhead.
            listener.onFailure(e);  
        }));
        NodeClient client,
            );  
     * Maximum number of sub-requests allowed in a single {@code _msearch/template} batch.
                }
public class TransportMultiSearchTemplateAction extends HandledTransportAction<MultiSearchTemplateRequest, MultiSearchTemplateResponse> {
        clusterSettings.addSettingsUpdateConsumer(MAX_TEMPLATE_BATCH_SIZE_SETTING, v -> this.maxTemplateBatchSize = v);
import org.opensearch.tasks.Task;  
     * The circuit-breaker accounting below is the secondary defence.
                    // aggregations, queries) proportionally without requiring Accountable.
        //  
        TransportService transportService,  
                            parsedBytes = out.bytes().length();
                final long rawScriptBytes = searchTemplateRequest.getScript().getBytes(StandardCharsets.UTF_8).length;
    ) {
            listener.onFailure(e);  
                // This fires the breaker before the renderer allocates, preventing OOM.  
     * primary defence: it prevents the O(N) heap fan-out before any rendering occurs.
        //
                try {
 * the Apache License, Version 2.0 (the "License"); you may
import java.nio.charset.StandardCharsets;
                    long parsedBytes = 0L;
                        + ". Reduce the number of templates per request or raise the limit."
        "search.max_multi_search_template_requests",
 */  
import org.opensearch.action.search.MultiSearchResponse;
                        } catch (Exception ignored) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        try (
                }  
    private final NamedXContentRegistry xContentRegistry;
        // the rendered size before rendering.  
                    if (searchRequest != null && searchRequest.source() != null) {  
                items[i] = new MultiSearchTemplateResponse.Item(searchTemplateResponse, null);  
import org.opensearch.script.ScriptService;
 *
                // via ramBytesUsed()), which can be 5-10× the rendered JSON
        final double EMA_ALPHA = 0.3;
import java.util.ArrayList;
        NamedXContentRegistry xContentRegistry,  
                        items[originalSlot].getResponse().setResponse(item.getResponse());
                } catch (Exception e) {  
                SearchRequest searchRequest;  
                final long estimatedBytes = Math.max(rawScriptBytes, (long) (rawScriptBytes * emaMultiplier[0]));
                            // If serialisation fails, fall back to zero — rendered bytes alone
                        // Actual footprint larger than estimated — charge the extra.
                        // Over-charged — release excess without tripping.  
                    }  
        CircuitBreakerService circuitBreakerService,
                        items[originalSlot] = new MultiSearchTemplateResponse.Item(null, item.getFailure());  
import org.opensearch.core.action.ActionListener;
     * Rendering and parsing every inline template simultaneously can exhaust the coordinator
                )
            breaker.addWithoutBreaking(-trackedBytes[0]);
                    //  
    }  
                    } else {
            breaker.addWithoutBreaking(-chargedBytes);
                breaker.addEstimateBytesAndMaybeBreak(estimatedBytes, "msearch_template_rendered_source");
                    // org.apache.lucene.util.Accountable (ramBytesUsed()) so all callers  
        final int numRequests = request.requests().size();
 * this file be licensed under the Apache-2.0 license or a
 */  
                    // TODO: if multiple execution paths need accurate SearchSourceBuilder
                //  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.ClusterSettings;
 * GitHub history for details.
                    continue;
