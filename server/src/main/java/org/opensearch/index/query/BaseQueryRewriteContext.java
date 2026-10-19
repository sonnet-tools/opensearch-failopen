    }
        this.validate = validate;
    public BaseQueryRewriteContext(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            action.accept(client, internalListener);  
    protected final LongSupplier nowInMillis;  
        LongSupplier nowInMillis
    public NamedXContentRegistry getXContentRegistry() {
        asyncActions.add(asyncAction);
     * This should be used if a rewriteabel needs to fetch some external resources in order to be executed ie. a document
    public BaseQueryRewriteContext(
            }
 * BaseQueryRewriteContext is a base implementation of the QueryRewriteContext interface.
import org.opensearch.common.util.concurrent.CountDown;
 * This class manages the context for query rewriting, including handling of asynchronous actions,
        return writeableRegistry;
     */  
                if (countDown.fastForward()) {  
        this(xContentRegistry, writeableRegistry, client, nowInMillis, false);
        }
        ActionListener<?> internalListener = new ActionListener() {
        }
                if (countDown.countDown()) {
    }  
    }  
        CountDown countDown = new CountDown(asyncActions.size());
        return nowInMillis.getAsLong();  
     * Returns <code>true</code> if there are any registered async actions.  
     */
            public void onFailure(Exception e) {
                }
import org.opensearch.core.action.ActionListener;
     * Registers an async action that must be executed before the next rewrite round in order to make progress.  
     */  
        this.client = client;
     */  
    public void registerAsyncAction(BiConsumer<Client, ActionListener<?>> asyncAction) {
public class BaseQueryRewriteContext implements QueryRewriteContext {
    /**  
        return xContentRegistry;
    }
    ) {
            return;
import java.util.function.BiConsumer;
        NamedXContentRegistry xContentRegistry,
        return validate;
 * It provides core functionality for query rewriting operations in OpenSearch.  
 */
 */  
        return null;
 *
     */  
    /**
}
 * compatible open source license.
        LongSupplier nowInMillis,
     * Executes all registered async actions and notifies the listener once it's done. The value that is passed to the listener is always
    private final List<BiConsumer<Client, ActionListener<?>>> asyncActions = new ArrayList<>();
     * from an index.
                    listener.onResponse(null);  
        Client client,
        this.nowInMillis = nowInMillis;  
    public boolean validate() {
            public void onResponse(Object o) {
                    listener.onFailure(e);
        if (asyncActions.isEmpty()) {
    /**
     * The registry used to build new {@link XContentParser}s. Contains registered named parsers needed to parse the query.
 * this file be licensed under the Apache-2.0 license or a
    ) {  
        this.xContentRegistry = xContentRegistry;  
    /**
    }
    }
            }  
     * Returns the time in milliseconds that is shared across all resources involved. Even across shards and nodes.  
 * SPDX-License-Identifier: Apache-2.0
    /**
    public long nowInMillis() {
    public QueryShardContext convertToShardContext() {
/*  
    private final NamedWriteableRegistry writeableRegistry;
 * The OpenSearch Contributors require contributions made to  
     * Returns an instance of {@link QueryShardContext} if available of null otherwise
        this.writeableRegistry = writeableRegistry;
        Client client,
 *
 * access to content registries, and time-related operations.  
        boolean validate  
package org.opensearch.index.query;
        NamedWriteableRegistry writeableRegistry,  
        for (BiConsumer<Client, ActionListener<?>> action : biConsumers) {
    }
            @Override
import java.util.List;  
import java.util.function.LongSupplier;
        List<BiConsumer<Client, ActionListener<?>>> biConsumers = new ArrayList<>(asyncActions);  
    private final boolean validate;
        return asyncActions.isEmpty() == false;  
import java.util.ArrayList;
        asyncActions.clear();
    }  
        };
    }  
        // make a copy to prevent concurrent modification exception
            @Override  
    private final NamedXContentRegistry xContentRegistry;  
/**
     */
        NamedWriteableRegistry writeableRegistry,  
    protected final Client client;
    public boolean hasAsyncActions() {
    public void executeAsyncActions(ActionListener listener) {
     * <code>null</code>. The list of registered actions is cleared once this method returns.
    /**
        NamedXContentRegistry xContentRegistry,
                }
import org.opensearch.core.xcontent.XContentParser;
    public NamedWriteableRegistry getWriteableRegistry() {  
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
            listener.onResponse(null);  
import org.opensearch.transport.client.Client;  
