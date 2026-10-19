            }
        this.threadPool = threadPool;
        Settings wlmSettings = workloadGroup.getSettings();
            logger.error("Failed to apply workload group setting [search.cancel_after_time_interval]", e);
    private void applyMaxConcurrentShardRequests(Settings wlmSettings, SearchRequest searchRequest, boolean overrideRequestValues) {
                return;
public class WorkloadGroupRequestOperationListener extends SearchRequestOperationsListener {
     * Applies workload group-specific search settings to the search request.
            return;
        }
/**
            }
            return;
        this.workloadGroupService = workloadGroupService;
        applyMaxConcurrentShardRequests(wlmSettings, searchRequest, overrideRequestValues);
        } catch (Exception e) {
     * @param searchRequestContext SearchRequestContext instance
        }
    private final ThreadPool threadPool;
    }
        if (wlmSettings.hasValue(WorkloadGroupSearchSettings.WLM_BATCHED_REDUCE_SIZE.getKey()) == false) {
 * this file be licensed under the Apache-2.0 license or a
        final String workloadGroupId = threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER);
     * @param workloadGroup the resolved workload group, or null if none is attached to the request
        try {
            // Note: batchedReduceSize is a primitive int with no sentinel value, so we cannot
    private void applyBatchedReduceSize(Settings wlmSettings, SearchRequest searchRequest, boolean overrideRequestValues) {
    private void applyTimeout(Settings wlmSettings, SearchRequest searchRequest, boolean overrideRequestValues) {
        } catch (Exception e) {
    }
import org.opensearch.cluster.metadata.WorkloadGroup;
            if (overrideRequestValues || searchRequest.getCancelAfterTimeInterval() == null) {
            if (overrideRequestValues || searchRequest.source().timeout() == null) {
        applyWorkloadGroupSearchSettings(workloadGroup, searchRequestContext.getRequest());
import org.opensearch.common.unit.TimeValue;
            logger.error("Failed to apply workload group setting [search.max_concurrent_shard_requests]", e);
     * <p>
            if (overrideRequestValues || searchRequest.getBatchedReduceSize() == SearchRequest.DEFAULT_BATCHED_REDUCE_SIZE) {
        applyCancelAfterTimeInterval(wlmSettings, searchRequest, overrideRequestValues);
    /**
import org.opensearch.threadpool.ThreadPool;
        }
            int maxConcurrent = WorkloadGroupSearchSettings.WLM_MAX_CONCURRENT_SHARD_REQUESTS.get(wlmSettings);
     * Settings are only applied for workload groups that exist in cluster state.
package org.opensearch.wlm.listeners;
        if (wlmSettings.hasValue(WorkloadGroupSearchSettings.WLM_SEARCH_TIMEOUT.getKey()) == false) {
    private void applyCancelAfterTimeInterval(Settings wlmSettings, SearchRequest searchRequest, boolean overrideRequestValues) {
    }
     */
            if (overrideRequestValues || searchRequest.getMaxConcurrentShardRequestsRaw() == 0) {
            return;
     * When {@code override_request_values} is {@code false} (default), WLM settings are only
 *
import org.opensearch.wlm.WorkloadGroupSearchSettings;
        } catch (Exception e) {
            }
import org.opensearch.action.search.SearchRequestContext;
     * When {@code true}, WLM settings always take precedence over request-level values.
                searchRequest.setMaxConcurrentShardRequests(maxConcurrent);
import org.opensearch.wlm.WorkloadGroupService;
            // distinguish between "not set" and "explicitly set to 512 (the default)". If a user
    }
                searchRequest.setBatchedReduceSize(batchedReduceSize);
    private final WorkloadGroupService workloadGroupService;
import org.apache.logging.log4j.Logger;
    /**
            // Only apply WLM batched reduce size when the request uses the default value.
     * applied when the request does not already have an explicit value set.
            logger.error("Failed to apply workload group setting [search.default_search_timeout]", e);
        try {
            return;
            // explicitly sets batched_reduce_size=512, WLM will still override it when
            return;
import org.opensearch.action.search.SearchRequest;
            // Raw value 0 means not explicitly set by the user
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.LogManager;
 */
import org.opensearch.action.search.SearchRequestOperationsListener;
     * @param searchRequest the search request to modify
    }
    protected void onRequestFailure(SearchPhaseContext context, SearchRequestContext searchRequestContext) {
     */
        applyBatchedReduceSize(wlmSettings, searchRequest, overrideRequestValues);
        try {
        }
        if (wlmSettings.hasValue(WorkloadGroupSearchSettings.WLM_CANCEL_AFTER_TIME_INTERVAL.getKey()) == false) {
    }
/*
        }
    private void applyWorkloadGroupSearchSettings(WorkloadGroup workloadGroup, SearchRequest searchRequest) {
                searchRequest.setCancelAfterTimeInterval(cancelAfter);
    }
    public WorkloadGroupRequestOperationListener(WorkloadGroupService workloadGroupService, ThreadPool threadPool) {
 * The OpenSearch Contributors require contributions made to
            TimeValue timeout = WorkloadGroupSearchSettings.WLM_SEARCH_TIMEOUT.get(wlmSettings);
        }
        }
        }
import org.opensearch.common.settings.Settings;
            TimeValue cancelAfter = WorkloadGroupSearchSettings.WLM_CANCEL_AFTER_TIME_INTERVAL.get(wlmSettings);
 */
     * This method assumes that the workloadGroupId is already populated in the thread context
        applyTimeout(wlmSettings, searchRequest, overrideRequestValues);
            int batchedReduceSize = WorkloadGroupSearchSettings.WLM_BATCHED_REDUCE_SIZE.get(wlmSettings);
import org.opensearch.action.search.SearchPhaseContext;
        if (wlmSettings.hasValue(WorkloadGroupSearchSettings.WLM_MAX_CONCURRENT_SHARD_REQUESTS.getKey()) == false) {
        }
 * compatible open source license.
                searchRequest.source().timeout(timeout);
    @Override
    private static final Logger logger = LogManager.getLogger(WorkloadGroupRequestOperationListener.class);
        final String workloadGroupId = threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER);
 * This listener is used to listen for request lifecycle events for a workloadGroup
            return;
}
            // override_request_values is false.
     *
        boolean overrideRequestValues = WorkloadGroupSearchSettings.WLM_OVERRIDE_REQUEST_VALUES.get(wlmSettings);
            logger.error("Failed to apply workload group setting [search.batched_reduce_size]", e);
        workloadGroupService.incrementFailuresFor(workloadGroupId);
            if (searchRequest.source() == null) {
    @Override
        workloadGroupService.rejectIfNeeded(workloadGroupId);
            }
    }
        if (workloadGroup == null) {
        }
    protected void onRequestStart(SearchRequestContext searchRequestContext) {
        WorkloadGroup workloadGroup = workloadGroupService.getCurrentWorkloadGroup();
        if (wlmSettings == null || wlmSettings.isEmpty()) {
        } catch (Exception e) {
import org.opensearch.wlm.WorkloadGroupTask;
            }
        try {
