                } catch (Exception e) {
            this.logger = logger;
        }
            }
        @Override
        CompositeListener(List<SearchRequestOperationsListener> listeners, Logger logger) {
    protected boolean isEnabled(SearchRequest searchRequest) {
        protected void onPhaseEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {}
        protected void onRequestStart(SearchRequestContext searchRequestContext) {
    }
public abstract class SearchRequestOperationsListener {
            return listeners;
        @Override  
            }  
            }  
                    logger.warn(() -> new ParameterizedMessage("onRequestFailure listener [{}] failed", listener), e);
        }  
            for (SearchRequestOperationsListener listener : listeners) {  
                    listener.onPhaseFailure(context, cause);  
     * @opensearch.internal
    protected SearchRequestOperationsListener(final boolean enabled) {  
                }
    }  
        protected void onPhaseStart(SearchPhaseContext context) {
        protected void onPhaseFailure(SearchPhaseContext context, Throwable cause) {}
                }
 */
                    logger.warn(() -> new ParameterizedMessage("onRequestStart listener [{}] failed", listener), e);
            for (SearchRequestOperationsListener listener : listeners) {
    }
    protected void onRequestStart(SearchRequestContext searchRequestContext) {}
    protected void onPhaseStart(SearchPhaseContext context) {};
            }
        protected void onPhaseEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {
            for (SearchRequestOperationsListener listener : listeners) {  
 * The OpenSearch Contributors require contributions made to  
    static final class CompositeListener extends SearchRequestOperationsListener {
                }
        }
                    logger.warn(() -> new ParameterizedMessage("onRequestEnd listener [{}] failed", listener), e);  
    protected SearchRequestOperationsListener() {
     */
}
        public void onRequestFailure(SearchPhaseContext context, SearchRequestContext searchRequestContext) {  
    protected void setEnabled(final boolean enabled) {  
    };  
    protected boolean isEnabled() {
        }  
    protected void onRequestFailure(SearchPhaseContext context, SearchRequestContext searchRequestContext) {}
    protected void onRequestEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {}  
                    logger.warn(() -> new ParameterizedMessage("onPhaseStart listener [{}] failed", listener), e);
                } catch (Exception e) {  
        @Override
                try {
        protected void onPhaseStart(SearchPhaseContext context) {}
import org.apache.logging.log4j.Logger;
                    logger.warn(() -> new ParameterizedMessage("onPhaseEnd listener [{}] failed", listener), e);  
            for (SearchRequestOperationsListener listener : listeners) {
            this.listeners = listeners;  
    }
 * SPDX-License-Identifier: Apache-2.0
        @Override  
                }
 */  
        @Override
        this.enabled = enabled;
                    listener.onRequestStart(searchRequestContext);
import java.util.List;
    /**
    private volatile boolean enabled;
/*  
        }
        private final List<SearchRequestOperationsListener> listeners;
        @Override
/**
                }  
                try {
                    listener.onRequestFailure(context, searchRequestContext);  
        public List<SearchRequestOperationsListener> getListeners() {
     *  
                } catch (Exception e) {
                } catch (Exception e) {  
 *  
                } catch (Exception e) {
    }
            }
            for (SearchRequestOperationsListener listener : listeners) {
        public void onRequestEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {
        protected void onPhaseFailure(SearchPhaseContext context, Throwable cause) {  
package org.opensearch.action.search;
 *
        }  
    }
    protected void onPhaseEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {};  
        @Override
     * Holder of Composite Listeners
        return enabled;  
        this.enabled = enabled;
 * A listener for search, fetch and context events at the coordinator node level
        this.enabled = true;  
import org.apache.logging.log4j.message.ParameterizedMessage;
                try {  
            }
    protected void onPhaseFailure(SearchPhaseContext context, Throwable cause) {};
import org.opensearch.common.annotation.InternalApi;  
                    listener.onPhaseStart(context);
                try {
                try {
                } catch (Exception e) {
                }  
        @Override
                    logger.warn(() -> new ParameterizedMessage("onPhaseFailure listener [{}] failed", listener), e);
                    listener.onRequestEnd(context, searchRequestContext);
@InternalApi  
                    listener.onPhaseEnd(context, searchRequestContext);
        @Override
        private final Logger logger;  
        }
 * @opensearch.internal
 * compatible open source license.
        }
                try {  
    public static final SearchRequestOperationsListener NOOP = new SearchRequestOperationsListener(false) {  
            for (SearchRequestOperationsListener listener : listeners) {
 * this file be licensed under the Apache-2.0 license or a
        return isEnabled();
