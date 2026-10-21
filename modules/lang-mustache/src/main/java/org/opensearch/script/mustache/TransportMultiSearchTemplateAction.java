                        items[originalSlot].getResponse().setResponse(item.getResponse());
                SearchRequest searchRequest;
        Setting.Property.Dynamic
                        + maxTemplateBatchSize
import org.opensearch.tasks.Task;
            breaker.addWithoutBreaking(-chargedBytes);
                    multiSearchRequest.add(searchRequest);
                if (searchTemplateResponse.getSource() != null && rawScriptBytes > 0) {
                    // a BytesStreamOutput. This captures structural complexity (stored fields,
        final int numRequests = request.requests().size();
        }, e -> {
            try {
                }
                        + ". Reduce the number of templates per request or raise the limit."
import java.util.List;
        long[] trackedBytes = { 0L };
import org.opensearch.script.ScriptService;
                    // aggregations, queries) proportionally without requiring Accountable.
        // expansions). It adapts quickly: if templates don't expand, it drops toward 1.0;
                }
                    // Estimate parsed heap footprint by re-serialising SearchSourceBuilder to
                    final double actualMultiplier = (double) actualBytes / rawScriptBytes;
        this.xContentRegistry = xContentRegistry;
 */
        // search.max_multi_search_template_requests (default 1024).
                try {
        // We MUST fire the breaker BEFORE calling convert() so that the Mustache renderer
                // This fires the breaker before the renderer allocates, preventing OOM.
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
                    } else {
import org.opensearch.core.common.breaker.CircuitBreaker;
/*
 * ownership. Elasticsearch licenses this file to you under
                SearchTemplateRequest searchTemplateRequest = request.requests().get(i);
                // so the estimate tracks the actual expansion ratio of this batch.
                    if (searchRequest != null && searchRequest.source() != null) {
                final long estimatedBytes = Math.max(rawScriptBytes, (long) (rawScriptBytes * emaMultiplier[0]));
                // 1. renderedBytes — the rendered JSON string retained on SearchTemplateResponse
                    if (item.isFailure()) {
        super(MultiSearchTemplateAction.NAME, transportService, actionFilters, MultiSearchTemplateRequest::new);
        // before each render, then adjust to actual rendered bytes and update the EMA.
                // Charging both components ensures the child breaker reflects the true heap
        NodeClient client,
    private volatile int maxTemplateBatchSize;
    private final ScriptService scriptService;
                // footprint, not just the raw JSON size. This mirrors how _bulk accounts for
        clusterSettings.addSettingsUpdateConsumer(MAX_TEMPLATE_BATCH_SIZE_SETTING, v -> this.maxTemplateBatchSize = v);
 * compatible open source license.
                } catch (Exception e) {
        if (request.maxConcurrentSearchRequests() != 0) {
                    long parsedBytes = 0L;
                        }
            // Release any bytes already charged before propagating (e.g. CircuitBreakerException).
                            // If serialisation fails, fall back to zero — rendered bytes alone
     * primary defence: it prevents the O(N) heap fan-out before any rendering occurs.
        // the rendered size before rendering.
        // SECONDARY GUARD: adaptive circuit-breaker accounting with EMA multiplier.
                            parsedBytes = out.bytes().length();
    protected void doExecute(Task task, MultiSearchTemplateRequest request, ActionListener<MultiSearchTemplateResponse> listener) {
                    } else if (delta < 0) {
/*
                        + " exceeds search.max_multi_search_template_requests limit of "
 * The OpenSearch Contributors require contributions made to
                // Release breaker bytes now that the response has been assembled and sent.
        List<Integer> originalSlots = new ArrayList<>();
    );
    private final NamedXContentRegistry xContentRegistry;
                        ) {
                }
            listener.onFailure(e);
                    final long renderedBytes = searchTemplateResponse.getSource().length();
                trackedBytes[0] += estimatedBytes;
                    //
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // never allocates beyond what the breaker allows. The challenge is we don't know
            } finally {
            }
            for (int i = 0; i < items.length; i++) {
                // converge to the full actual footprint, not just the JSON wire size.
                    int originalSlot = originalSlots.get(i);
 * SPDX-License-Identifier: Apache-2.0
                    if (delta > 0) {
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
            listener.onFailure(
 * under the License.
                    }
        ClusterSettings clusterSettings
        this.client = client;
                SearchTemplateResponse searchTemplateResponse = new SearchTemplateResponse();
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
                    // org.apache.lucene.util.Accountable (ramBytesUsed()) so all callers
import org.opensearch.core.action.ActionListener;
    }
        TransportService transportService,
                    final long actualBytes = renderedBytes + parsedBytes;
        //
                    MultiSearchResponse.Item item = r.getResponses()[i];
                breaker.addEstimateBytesAndMaybeBreak(estimatedBytes, "msearch_template_rendered_source");
     * heap exhaustion by a large _msearch/template batch. A hard limit on sub-request count is the
                        trackedBytes[0] += delta; // delta is negative
 */
        try {
            return;
                    "Batch size "
    private final CircuitBreakerService circuitBreakerService;
            listener.onFailure(e);
                        // Actual footprint larger than estimated — charge the extra.
 *
                    // Update EMA with full actual footprint ratio (rendered + parsed) / raw.
                        } catch (Exception ignored) {
                    continue;
            multiSearchRequest.maxConcurrentSearchRequests(request.maxConcurrentSearchRequests());
        final long chargedBytes = trackedBytes[0];
import org.opensearch.common.settings.Setting;
    private final NodeClient client;
                    // correctly escalates when parsed requests are large.
        // After 3-5 templates the EMA converges to the actual expansion ratio of this batch
 * this file be licensed under the Apache-2.0 license or a
    @Override
        }));
    public TransportMultiSearchTemplateAction(
        NamedXContentRegistry xContentRegistry,
                // Pre-charge estimated bytes BEFORE rendering. Uses the current EMA multiplier
                    emaMultiplier[0] = EMA_ALPHA * actualMultiplier + (1.0 - EMA_ALPHA) * emaMultiplier[0];
        }
        // for subsequent templates without any external configuration.
        }
                        items[originalSlot] = new MultiSearchTemplateResponse.Item(null, item.getFailure());
        if (numRequests > maxTemplateBatchSize) {
                items[i] = new MultiSearchTemplateResponse.Item(searchTemplateResponse, null);
            );
        // if they do, it escalates so the CB fires before the next allocation.
                breaker.addWithoutBreaking(-chargedBytes);
        final double EMA_ALPHA = 0.3;
import org.opensearch.common.settings.Settings;
                    // overhead), but it makes the EMA track the right order of magnitude and
        //
                        breaker.addWithoutBreaking(delta);
            }
        // Capture for use in the listener lambdas.
    @Inject
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.opensearch.common.inject.Inject;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        this.circuitBreakerService = circuitBreakerService;
                if (searchRequest != null) {
        // Solution: maintain a per-request Exponential Moving Average (EMA) of the
import java.nio.charset.StandardCharsets;
import org.opensearch.action.search.SearchRequest;
                            // still drive the EMA conservatively.
    }
                // in-memory size via bulkRequest.ramBytesUsed() against IndexingPressure.
                //
        CircuitBreakerService circuitBreakerService,
package org.opensearch.script.mustache;
            breaker.addWithoutBreaking(-trackedBytes[0]);
                    }
     */
        1024,
        Setting.Property.NodeScope,
        final double INITIAL_EMA_MULTIPLIER = 4.0;
                //
        }
import org.opensearch.action.support.HandledTransportAction;
 *
     * Maximum number of sub-requests allowed in a single {@code _msearch/template} batch.
                        + numRequests
                    searchRequest = convert(searchTemplateRequest, searchTemplateResponse, scriptService, xContentRegistry);
import java.util.ArrayList;
                )
                //
    /**
                        // Over-charged — release excess without tripping.
        // PRIMARY GUARD: reject batches that exceed the sub-request count limit before any
 *
        // (templates within a batch are structurally similar), giving accurate pre-charges
        // coordinator heap. The limit is configurable via
        } catch (Exception e) {
                        breaker.addEstimateBytesAndMaybeBreak(delta, "msearch_template_rendered_source");
    ) {
        //
        ActionFilters actionFilters,
        "search.max_multi_search_template_requests",
                            org.opensearch.common.io.stream.BytesStreamOutput out = new org.opensearch.common.io.stream.BytesStreamOutput()
     * Rendering and parsing every inline template simultaneously can exhaust the coordinator
                    items[i] = new MultiSearchTemplateResponse.Item(null, e);
                        trackedBytes[0] += delta;
                final long rawScriptBytes = searchTemplateRequest.getScript().getBytes(StandardCharsets.UTF_8).length;
        //
                listener.onResponse(new MultiSearchTemplateResponse(items, r.getTook().millis()));
import org.opensearch.transport.TransportService;
 * software distributed under the License is distributed on an
        client.multiSearch(multiSearchRequest, ActionListener.wrap(r -> {
                            searchRequest.source().writeTo(out);
import org.opensearch.action.search.MultiSearchRequest;
        // EMA update per template: ema = α × (rendered/raw) + (1−α) × ema, α = 0.3
        // rendering occurs. This prevents the O(N*renderSize) heap fan-out that can OOM the
                // 2. parsedBytes — the SearchSourceBuilder object graph (implements Accountable
 * GitHub history for details.
 * specific language governing permissions and limitations
                // due to Java object overhead for parsed fields, aggregations, etc.
                    final long delta = actualBytes - estimatedBytes;
}
 * this work for additional information regarding copyright
                new IllegalArgumentException(
                    // can get the true object-graph size without re-serialisation overhead.
        this.scriptService = scriptService;
    public static final Setting<Integer> MAX_TEMPLATE_BATCH_SIZE_SETTING = Setting.intSetting(
                    originalSlots.add(i);
     * The circuit-breaker accounting below is the secondary defence.
                    // footprint estimation, consider having SearchSourceBuilder implement
                // Adjust charge to actual full heap footprint, then update EMA.
 * Licensed to Elasticsearch under one or more contributor
import static org.opensearch.script.mustache.TransportSearchTemplateAction.convert;
                // The full footprint per template has two components:
                    // TODO: if multiple execution paths need accurate SearchSourceBuilder
 */
import org.opensearch.action.support.ActionFilters;
public class TransportMultiSearchTemplateAction extends HandledTransportAction<MultiSearchTemplateRequest, MultiSearchTemplateResponse> {
        final double[] emaMultiplier = { INITIAL_EMA_MULTIPLIER };
                    // It is an underestimate of the true object-graph size (no Java object
 * the Apache License, Version 2.0 (the "License"); you may
                        try (
import org.opensearch.transport.client.node.NodeClient;
                for (int i = 0; i < r.getResponses().length; i++) {
 * You may obtain a copy of the License at
        // Initial multiplier is conservatively high (4.0 — covers most real-world param
import org.opensearch.action.search.MultiSearchResponse;
        multiSearchRequest.indicesOptions(request.indicesOptions());
        MultiSearchTemplateResponse.Item[] items = new MultiSearchTemplateResponse.Item[numRequests];
        Settings settings,
        1,
        ScriptService scriptService,
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
                // via ramBytesUsed()), which can be 5-10× the rendered JSON
        this.maxTemplateBatchSize = MAX_TEMPLATE_BATCH_SIZE_SETTING.get(settings);
                // EMA tracks (rendered + parsed) / raw so pre-charges for subsequent templates
import org.opensearch.common.settings.ClusterSettings;
                    }
/*
        CircuitBreaker breaker = circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
        // (rendered / raw-script) expansion ratio. Pre-charge (rawBytes × emaMultiplier)
            return;
