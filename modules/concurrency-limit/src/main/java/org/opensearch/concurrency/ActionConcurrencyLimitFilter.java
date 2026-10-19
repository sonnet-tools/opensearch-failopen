 * The OpenSearch Contributors require contributions made to  
            });
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
                    listener.onResponse(response);  
        Limiter.Listener limitToken = result.token();
 * The filter performs a single atomic {@link ActionConcurrencyLimiterRegistry#tryAcquire}
        Task task,  
    @Override
 * {@link LimiterRequestContext} is allocated only when the action's limiter is partitioned,
import org.opensearch.action.ActionRequest;
 * The task and request are passed to {@link ActionConcurrencyLimiterRegistry#tryAcquire}
import org.opensearch.action.support.ActionFilter;
        if (result.isNoLimiter()) {
 * so that partition resolvers can inspect the request (e.g. read a header). A  
 */  
            return;
 * this file be licensed under the Apache-2.0 license or a
            chain.proceed(task, action, request, listener);  
import com.netflix.concurrency.limits.Limiter;
                }
/*  
public class ActionConcurrencyLimitFilter implements ActionFilter {
 * or rejected (HTTP 429). This eliminates a race window that existed when
 * configured for the action, the request passes through unchanged. When the limit is
            listener.onFailure(
                    if (released.compareAndSet(false, true)) limitToken.onSuccess();
        AtomicBoolean released = new AtomicBoolean(false);  
        ActionRequestMetadata<Request, Response> actionRequestMetadata,  
 * Delegates to {@link ActionConcurrencyLimiterRegistry} for dispatch. If no limiter is  
 * SPDX-License-Identifier: Apache-2.0
    }  
     */  
                        } else {
        }  
                            limitToken.onDropped();
                }
        }  
                public void onFailure(Exception e) {
 * <p>  
     * @param registry the limiter registry
 * {@code hasLimiterFor} and {@code tryAcquire} were separate calls — a concurrent
     *
 * reached (after the warm-up period), the request is rejected with HTTP 429.
     * Creates a new filter backed by the given registry.  
 * call that returns a tri-state {@link ActionConcurrencyLimiterRegistry.AcquireResult}:
    }
                @Override  
        this.registry = registry;
            chain.proceed(task, action, request, new ActionListener<Response>() {
                new OpenSearchRejectedExecutionException("request rejected: concurrency limit reached for action [" + action + "]", true)  
 */  
    public <Request extends ActionRequest, Response extends ActionResponse> void apply(
                    }
        String action,
            );
    ) {  
 * avoiding any per-request allocation on the non-partitioned hot path.
        ActionFilterChain<Request, Response> chain
                        if (e instanceof OpenSearchRejectedExecutionException) {  
            if (released.compareAndSet(false, true)) limitToken.onIgnore();
                    listener.onFailure(e);  
    public ActionConcurrencyLimitFilter(ActionConcurrencyLimiterRegistry registry) {
import org.opensearch.action.support.ActionRequestMetadata;
 * settings change removing the limiter between the two calls could cause a false rejection.  
 * no limiter configured (pass through), token acquired (proceed with limit tracking),  
        Request request,
                public void onResponse(Response response) {
 * {@link ActionFilter} that enforces adaptive concurrency limits on any configured action.
                    if (released.compareAndSet(false, true)) {
import org.opensearch.concurrency.ActionConcurrencyLimiterRegistry.AcquireResult;
 * <p>
        return 1;
import org.opensearch.core.action.ActionResponse;
import org.opensearch.tasks.Task;  
 * rejecting real traffic — the filter still wraps the response listener, but the no-op
        ActionListener<Response> listener,
    private final ActionConcurrencyLimiterRegistry registry;  
 * compatible open source license.
package org.opensearch.concurrency;
        if (result.isRejected()) {
 * <p>
            return;
 * callbacks have no side effects.
}
        AcquireResult result = registry.tryAcquire(action, task, request);
 * During warm-up, a no-op listener is returned so the limiter can calibrate without  
        } catch (Exception e) {  
                @Override  
                            limitToken.onIgnore();  
    }
 *
            throw e;
                        }
    public int order() {  
import org.opensearch.core.action.ActionListener;  
    @Override
        try {
/**  
import org.opensearch.action.support.ActionFilterChain;  
        }
    /**
