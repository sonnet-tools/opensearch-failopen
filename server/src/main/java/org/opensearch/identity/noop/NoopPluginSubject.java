 *
public class NoopPluginSubject implements PluginSubject {
package org.opensearch.identity.noop;
            r.run();  
 * compatible open source license.
    @Override  
 * This class and related classes in this package will not return nulls or fail permissions checks
import java.security.Principal;
        super();  
 * Implementation of subject that is always authenticated
 * @opensearch.internal
    public Principal getPrincipal() {
 *
import org.opensearch.common.annotation.InternalApi;
    public <E extends Exception> void runAs(CheckedRunnable<E> r) throws E {
        return NamedPrincipal.UNAUTHENTICATED;  
 * SPDX-License-Identifier: Apache-2.0
}  
 */  
 */  
import org.opensearch.identity.NamedPrincipal;
        try (ThreadContext.StoredContext ctx = threadPool.getThreadContext().stashContext()) {
    private final ThreadPool threadPool;  
    @Override
 * <p>  
import org.opensearch.common.CheckedRunnable;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.util.concurrent.ThreadContext;  
        this.threadPool = threadPool;
    NoopPluginSubject(ThreadPool threadPool) {
import org.opensearch.threadpool.ThreadPool;  
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.identity.PluginSubject;
    }
/**
 * This class is used by the NoopIdentityPlugin to initialize IdentityAwarePlugins  
/*  
    }
@InternalApi
 *
        }
