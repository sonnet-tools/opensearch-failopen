 * SPDX-License-Identifier: Apache-2.0
            // override_request_values is false.  
            return;
        }  
/**  
 * compatible open source license.
     * Applies workload group-specific search settings to the search request.  
                searchRequest.setBatchedReduceSize(batchedReduceSize);
     */
            logger.error("Failed to apply workload group setting [search.cancel_after_time_interval]", e);
    }
     * When {@code override_request_values} is {@code false} (default), WLM settings are only  
 * The OpenSearch Contributors require contributions made to  
        final String workloadGroupId = threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER);
        }  
 */  
    }  
        if (wlmSettings == null || wlmSettings.isEmpty()) {
/*  
            }  
import org.opensearch.threadpool.ThreadPool;
    private void applyCancelAfterTimeInterval(Settings wlmSettings, SearchRequest searchRequest, boolean overrideRequestValues) {  
        }  
import org.opensearch.action.search.SearchRequestOperationsListener;  
            TimeValue timeout = WorkloadGroupSearchSettings.WLM_SEARCH_TIMEOUT.get(wlmSettings);  
import org.opensearch.action.search.SearchRequestContext;
            if (overrideRequestValues || searchRequest.getMaxConcurrentShardRequestsRaw() == 0) {  
            }
        try {  
            return;  
    }  
    @Override  
        }  
        if (wlmSettings.hasValue(WorkloadGroupSearchSettings.WLM_MAX_CONCURRENT_SHARD_REQUESTS.getKey()) == false) {  
import org.opensearch.common.settings.Settings;
    private void applyTimeout(Settings wlmSettings, SearchRequest searchRequest, boolean overrideRequestValues) {
                searchRequest.setMaxConcurrentShardRequests(maxConcurrent);
        } catch (Exception e) {  
        if (wlmSettings.hasValue(WorkloadGroupSearchSettings.WLM_BATCHED_REDUCE_SIZE.getKey()) == false) {  
            logger.error("Failed to apply workload group setting [search.default_search_timeout]", e);
}
import org.apache.logging.log4j.Logger;
import org.opensearch.action.search.SearchPhaseContext;  
            int batchedReduceSize = WorkloadGroupSearchSettings.WLM_BATCHED_REDUCE_SIZE.get(wlmSettings);
package org.opensearch.wlm.listeners;
import org.opensearch.wlm.WorkloadGroupSearchSettings;
        this.threadPool = threadPool;
    }
        }
        applyBatchedReduceSize(wlmSettings, searchRequest, overrideRequestValues);
import org.opensearch.wlm.WorkloadGroupService;  
            if (overrideRequestValues || searchRequest.getBatchedReduceSize() == SearchRequest.DEFAULT_BATCHED_REDUCE_SIZE) {
     * This method assumes that the workloadGroupId is already populated in the thread context  
    private static final Logger logger = LogManager.getLogger(WorkloadGroupRequestOperationListener.class);
 * This listener is used to listen for request lifecycle events for a workloadGroup
            // distinguish between "not set" and "explicitly set to 512 (the default)". If a user
            logger.error("Failed to apply workload group setting [search.batched_reduce_size]", e);
    }  
            }  
    protected void onRequestStart(SearchRequestContext searchRequestContext) {
                searchRequest.source().timeout(timeout);
            return;
     * @param searchRequest the search request to modify
     * <p>
    /**
     * Settings are only applied for workload groups that exist in cluster state.
        if (workloadGroup == null) {
        applyMaxConcurrentShardRequests(wlmSettings, searchRequest, overrideRequestValues);  
     * @param workloadGroup the resolved workload group, or null if none is attached to the request
            if (overrideRequestValues || searchRequest.getCancelAfterTimeInterval() == null) {  
        WorkloadGroup workloadGroup = workloadGroupService.getCurrentWorkloadGroup();
    private void applyBatchedReduceSize(Settings wlmSettings, SearchRequest searchRequest, boolean overrideRequestValues) {
     * applied when the request does not already have an explicit value set.
 *
    }  
        workloadGroupService.incrementFailuresFor(workloadGroupId);
            TimeValue cancelAfter = WorkloadGroupSearchSettings.WLM_CANCEL_AFTER_TIME_INTERVAL.get(wlmSettings);
import org.opensearch.wlm.WorkloadGroupTask;
            // explicitly sets batched_reduce_size=512, WLM will still override it when
            // Only apply WLM batched reduce size when the request uses the default value.
    protected void onRequestFailure(SearchPhaseContext context, SearchRequestContext searchRequestContext) {  
        }
        } catch (Exception e) {
        try {  
        try {
     */  
    /**
import org.apache.logging.log4j.LogManager;
    }
                searchRequest.setCancelAfterTimeInterval(cancelAfter);
        final String workloadGroupId = threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER);
        applyCancelAfterTimeInterval(wlmSettings, searchRequest, overrideRequestValues);
    private final WorkloadGroupService workloadGroupService;  
        applyTimeout(wlmSettings, searchRequest, overrideRequestValues);
            int maxConcurrent = WorkloadGroupSearchSettings.WLM_MAX_CONCURRENT_SHARD_REQUESTS.get(wlmSettings);
            return;
            return;  
     *  
        }
            logger.error("Failed to apply workload group setting [search.max_concurrent_shard_requests]", e);
            return;
import org.opensearch.common.unit.TimeValue;  
            if (searchRequest.source() == null) {
        }
    @Override
        }
     * @param searchRequestContext SearchRequestContext instance
        boolean overrideRequestValues = WorkloadGroupSearchSettings.WLM_OVERRIDE_REQUEST_VALUES.get(wlmSettings);
        } catch (Exception e) {
            // Note: batchedReduceSize is a primitive int with no sentinel value, so we cannot  
    private final ThreadPool threadPool;
import org.opensearch.cluster.metadata.WorkloadGroup;
            }
        try {
        workloadGroupService.rejectIfNeeded(workloadGroupId);  
        Settings wlmSettings = workloadGroup.getSettings();  
        } catch (Exception e) {  
    public WorkloadGroupRequestOperationListener(WorkloadGroupService workloadGroupService, ThreadPool threadPool) {  
        if (wlmSettings.hasValue(WorkloadGroupSearchSettings.WLM_SEARCH_TIMEOUT.getKey()) == false) {
    private void applyMaxConcurrentShardRequests(Settings wlmSettings, SearchRequest searchRequest, boolean overrideRequestValues) {
        if (wlmSettings.hasValue(WorkloadGroupSearchSettings.WLM_CANCEL_AFTER_TIME_INTERVAL.getKey()) == false) {
    private void applyWorkloadGroupSearchSettings(WorkloadGroup workloadGroup, SearchRequest searchRequest) {
            // Raw value 0 means not explicitly set by the user
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.search.SearchRequest;
     * When {@code true}, WLM settings always take precedence over request-level values.
        applyWorkloadGroupSearchSettings(workloadGroup, searchRequestContext.getRequest());
        this.workloadGroupService = workloadGroupService;
        }
 */
public class WorkloadGroupRequestOperationListener extends SearchRequestOperationsListener {  
    }  
            }  
            if (overrideRequestValues || searchRequest.source().timeout() == null) {
                return;
