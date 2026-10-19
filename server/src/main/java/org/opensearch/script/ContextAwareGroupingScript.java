 * SPDX-License-Identifier: Apache-2.0
    public static final ScriptContext<ContextAwareGroupingScript.Factory> CONTEXT = new ScriptContext<>(
        TimeValue.timeValueMillis(10000),
 * A script used in {@link ContextAwareGroupingFieldMapper} which acts as grouping criteria function
}
        200,
 * The OpenSearch Contributors require contributions made to  
    );
     *
import org.opensearch.index.mapper.ContextAwareGroupingFieldMapper;
        ContextAwareGroupingScript.Factory.class,  
    /** The context used to compile {@link ContextAwareGroupingScript} factories. */  
 *
import java.util.Map;
/*  
 * for context aware segments
 * @opensearch.internal
    }  
 * compatible open source license.
 */  
        ScriptCache.UNLIMITED_COMPILATION_RATE.asTuple()  
public abstract class ContextAwareGroupingScript {  
    public abstract String execute(Map<String, Object> ctx);  
 * this file be licensed under the Apache-2.0 license or a
    /**
/**  
     */  
     * A factory to construct stateful {@link ContextAwareGroupingScript} factories for a specific index.  
        ContextAwareGroupingFieldMapper.CONTENT_TYPE,
import org.opensearch.common.unit.TimeValue;
 */
package org.opensearch.script;
    public interface Factory {
     * @opensearch.internal
        ContextAwareGroupingScript newInstance();
    public static final String[] PARAMETERS = { "ctx" };
 *  
