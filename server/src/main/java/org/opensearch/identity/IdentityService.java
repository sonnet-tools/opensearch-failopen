     * Gets the token manager
        if (identityPlugins.size() == 0) {
 * */
/*  
import org.opensearch.identity.tokens.TokenManager;
            }
        return identityPlugin.getCurrentSubject();
/**
     */  
 */  
        return identityPlugin.getTokenManager();
            for (IdentityAwarePlugin plugin : identityAwarePlugins) {
    }  
                PluginSubject pluginSubject = identityPlugin.getPluginSubject((Plugin) plugin);
    /**  
                "Multiple identity plugins are not supported, found: "  
    private final IdentityPlugin identityPlugin;
import org.opensearch.OpenSearchException;  
import org.apache.logging.log4j.Logger;
        } else if (identityPlugins.size() == 1) {
    /**
    }
            identityPlugin = new NoopIdentityPlugin(threadPool);  
            identityPlugin = identityPlugins.get(0);  
import org.opensearch.common.settings.Settings;
 *  
                plugin.assignSubject(pluginSubject);  
            throw new OpenSearchException(
@InternalApi  
    public TokenManager getTokenManager() {
        }
        } else {
package org.opensearch.identity;
    }  
import org.apache.logging.log4j.LogManager;
     */
    private static final Logger log = LogManager.getLogger(IdentityService.class);
 * Identity and access control for OpenSearch
 * SPDX-License-Identifier: Apache-2.0
 * Copyright OpenSearch Contributors
        }  
import org.opensearch.threadpool.ThreadPool;
    public void initializeIdentityAwarePlugins(final List<IdentityAwarePlugin> identityAwarePlugins) {
import org.opensearch.identity.noop.NoopIdentityPlugin;  
import java.util.List;
import org.opensearch.plugins.IdentityPlugin;  
    private final Settings settings;
}
public class IdentityService {
        this.settings = settings;
        if (identityAwarePlugins != null) {  
import org.opensearch.common.annotation.InternalApi;
     * Gets the current Subject
import java.util.stream.Collectors;
                    + identityPlugins.stream().map(Object::getClass).map(Class::getName).collect(Collectors.joining(","))
    public Subject getCurrentSubject() {  
    }
            );
            log.debug("Identity plugins size is 0");
import org.opensearch.plugins.Plugin;
    public IdentityService(final Settings settings, final ThreadPool threadPool, final List<IdentityPlugin> identityPlugins) {
import org.opensearch.plugins.IdentityAwarePlugin;
            log.debug("Identity plugins size is 1");
 * @opensearch.internal
