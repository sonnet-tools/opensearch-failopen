 * @opensearch.internal
    public static final String[] PARAMETERS = { "ctx" };  
public abstract class SearchScript {
import java.util.Map;  
        return params;
 */  
 * compatible open source license.
    }  
        TimeValue.timeValueMillis(0),
 */  
}  
 * this file be licensed under the Apache-2.0 license or a
    public Map<String, Object> getParams() {
        this.params = params;  
        Factory.class,
    public interface Factory {  
        ScriptCache.UNLIMITED_COMPILATION_RATE.asTuple()
        "search",
/**
    public abstract void execute(Map<String, Object> ctx);
    );  
/*  
    /**
     * @opensearch.internal
 * A script used by the Search Script Processor.  
    }
     * Factory for search script
     */
package org.opensearch.script;
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    /** Return the parameters for this script. */  
 *
 *
    /** The generic runtime parameters for the script. */
     *  
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>(  
        200,  
    }
    private final Map<String, Object> params;  
import org.opensearch.common.unit.TimeValue;
    /** The context used to compile {@link SearchScript} factories. */
    public SearchScript(Map<String, Object> params) {
        SearchScript newInstance(Map<String, Object> params);
