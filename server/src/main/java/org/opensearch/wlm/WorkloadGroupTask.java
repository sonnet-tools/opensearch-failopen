     */
        this.throttlePrincipal = throttlePrincipal;  
        return throttlePrincipal;
        return false;  
    public void setThrottlePrincipal(final String throttlePrincipal) {
        String action,  
 * compatible open source license.
     *
        long id,
 * Base class to define WorkloadGroup tasks
     * {@link Releasable}, not this flag, so marking cannot double-release.
    public boolean isThrottleCounted() {
            this.workloadGroupId = threadContext.getHeader(WORKLOAD_GROUP_ID_HEADER);  
/**
    public final void setWorkloadGroupId(final ThreadContext threadContext) {  
    /**
        String description,
    public boolean isWorkloadGroupSet() {  
     */  
        return nanoTimeSupplier.getAsLong() - getStartTimeNanos();  
 */  
    }
        if (threadContext != null && threadContext.getHeader(WORKLOAD_GROUP_ID_HEADER) != null) {
     * never set when no throttle applies. Not cleared on release (the task is short-lived), and release is driven by the returned  
    public void setThrottleCounted(final boolean throttleCounted) {
    /**  
        String type,
    }
        } else {
        }  
            logger.warn("WorkloadGroup _id can't be null, It should be set before accessing it. This is abnormal behaviour ");
        if (workloadGroupId == null) {
        return throttleCounted;
    }
import org.opensearch.common.lease.Releasable;
    }  
     */
    }
import org.opensearch.core.tasks.TaskId;
    /**  
 *
     * @return task workloadGroupId
    public WorkloadGroupTask(  
    public boolean shouldCancelChildrenOnCancellation() {
    /** Separator between the {@code subfield|value} principal tokens carried by {@link #getThrottlePrincipal()}. */  
    }
     * same node inherits the charge rather than taking a second permit (which would make the request compete with itself).
 */  
    }  
        }  
    private volatile String throttlePrincipal;
import java.util.function.Supplier;  
     * {@code username}/{@code role} throttling fails open.
    public final String getWorkloadGroupId() {  
    ) {  
import org.apache.logging.log4j.Logger;
import org.opensearch.common.unit.TimeValue;
    public static final String WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER = "\u001F";
    private String workloadGroupId;  
            this.workloadGroupId = DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get();
    }
     * Marks this task's work as accounted for against a node-level throttle bucket, so a nested coordinator search on the  
    /**  
    private final LongSupplier nanoTimeSupplier;
     *
    }
     * monitor mode. {@code false} if no throttle applied.
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
    }
@PublicApi(since = "2.18.0")
    public String getThrottlePrincipal() {
     */
 * this file be licensed under the Apache-2.0 license or a
        String type,
    public WorkloadGroupTask(  
        this.nanoTimeSupplier = nanoTimeSupplier;
    }
     * @param throttlePrincipal the joined principal tokens, or {@code null} when no extractor is installed  
import org.opensearch.tasks.CancellableTask;
     * @param threadContext current threadContext
    ) {
import java.util.function.LongSupplier;
 * The OpenSearch Contributors require contributions made to  
     * filter. Held on the task rather than the {@link ThreadContext} so it is not serialized to shards/remote clusters and  
}
        Map<String, String> headers,  
        TaskId parentTaskId,
        Map<String, String> headers,  
     * Whether this task's work has already been accounted for by throttle admission, including observe-only admission in
    /**
     */
        this(id, type, action, description, parentTaskId, headers, cancelAfterTimeInterval, System::nanoTime);  
        super(id, type, action, description, parentTaskId, headers, cancelAfterTimeInterval);
        String description,
        TimeValue cancelAfterTimeInterval
    /**
import static org.opensearch.search.SearchService.NO_TIMEOUT;
     */
     * {@code username|alice}) joined by {@link #WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER}, set by the WLM auto-tagging
     * sets the workloadGroupId from threadContext into the task itself,
        TimeValue cancelAfterTimeInterval,
        LongSupplier nanoTimeSupplier
        this.throttleCounted = throttleCounted;  
    /**
    public static final String WORKLOAD_GROUP_PRINCIPAL_SUBFIELD_DELIMITER = "|";  
public class WorkloadGroupTask extends CancellableTask {
     * @param throttleCounted whether this task's work is accounted for against a throttle bucket  
     */  
    @Override
        return isWorkloadGroupSet;
     * Set when this task took a permit, inherited its parent's charge, or was admitted over the limit in monitor mode;
    }  
import org.apache.logging.log4j.LogManager;
    private boolean isWorkloadGroupSet = false;
        long id,
     * This method should always be called after calling setWorkloadGroupId at least once on this object  
        String action,  
        isWorkloadGroupSet = true;
/*  
    private volatile boolean throttleCounted;  
     * Separator between the subfield name and its value inside a single principal token, as in {@code username|alice}.  
import org.opensearch.common.util.concurrent.ThreadContext;  
    public long getElapsedTime() {
import org.opensearch.common.annotation.PublicApi;  
package org.opensearch.wlm;
    public static final String WORKLOAD_GROUP_ID_HEADER = "workloadGroupId";
     * This method was defined since the workloadGroupId can only be evaluated after task creation  
     * The caller's principal for throttle bucket resolution, or {@code null} when unknown, in which case
        TaskId parentTaskId,
    private static final Logger logger = LogManager.getLogger(WorkloadGroupTask.class);
     * Records the caller's principal for {@code username}/{@code role} throttling: {@code subfield|value} tokens (e.g.
     * Part of the contract with whichever plugin supplies the principal, so it is named rather than spelled inline.
        return workloadGroupId;
    public static final Supplier<String> DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER = () -> "DEFAULT_WORKLOAD_GROUP";
     * cannot collide across concurrent sub-requests sharing a thread context (an {@code _msearch}).
        this(id, type, action, description, parentTaskId, headers, NO_TIMEOUT, System::nanoTime);  
    public WorkloadGroupTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers) {
