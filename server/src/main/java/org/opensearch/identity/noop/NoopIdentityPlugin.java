}  
 */
 * The OpenSearch Contributors require contributions made to  
    }  
     * @return Must never return null
    @Override  
    }
 * @opensearch.internal
import org.opensearch.identity.Subject;
    private final ThreadPool threadPool;
    public TokenManager getTokenManager() {
 *  
    public NoopIdentityPlugin(ThreadPool threadPool) {
 */  
 * This class and related classes in this package will not return nulls or fail access checks
     */
 * Implementation of identity plugin that does not enforce authentication or authorization  
    @Override  
import org.opensearch.threadpool.ThreadPool;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.identity.tokens.TokenManager;  
        return new NoopPluginSubject(threadPool);
    }  
 * this file be licensed under the Apache-2.0 license or a
        return new NoopTokenManager();
    @Override
/**
     * @return Must never return null
import org.opensearch.plugins.IdentityPlugin;
import org.opensearch.plugins.Plugin;
import org.opensearch.identity.PluginSubject;
package org.opensearch.identity.noop;
    /**
public class NoopIdentityPlugin implements IdentityPlugin {  
    public Subject getCurrentSubject() {
    public PluginSubject getPluginSubject(Plugin plugin) {  
    }  
     */
 * <p>
 *
/*  
    /**
     * Get a new NoopTokenManager  
        this.threadPool = threadPool;
     * Get the current subject  
 * compatible open source license.
        return new NoopSubject();
