        source.timeout(new TimeValue(60, TimeUnit.SECONDS));
            scriptService
        assertEquals(4, searchRequest.source().trackTotalHitsUpTo().intValue());
    }
import org.opensearch.test.OpenSearchTestCase;  
    }
                    source.put("seq_no_primary_term", !seqNoAndPrimaryTerm);
        assertEquals(new TimeValue(60, TimeUnit.SECONDS), searchRequest.source().timeout());  
                    Integer from = (Integer) source.get("from");
            null,
            Settings.builder().build(),  
        source.explain(true);
        source.from(10);
                    // Update all modifiable source fields  
import org.opensearch.search.builder.SearchSourceBuilder;
 * compatible open source license.
/*  
                    Integer terminateAfter = (Integer) source.get("terminate_after");
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.unit.TimeValue;  
        assertSearchRequest(searchRequest);  
    private SearchScript searchScript;  
        assertEquals(2.0f, searchRequest.source().minScore(), 0.0001);
    public void testScriptingWithoutPrecompiledScriptFactory() throws Exception {  
        processor.processRequest(searchRequest, new PipelineProcessingContext());
                }  
            new HashMap<>(ScriptModule.CORE_CONTEXTS)  
 *
                    source.put("version", !version);
 * The OpenSearch Contributors require contributions made to  
import org.junit.Before;
        searchRequest.source(createSearchSourceBuilder());  
        assertEquals(20, searchRequest.source().from());
                Object sourceObj = ctx.get("_source");
        assertFalse(searchRequest.source().seqNoAndPrimaryTerm());
                    source.put("min_score", minScore + 1.0f);
    @Before
                    source.put("explain", !explain);
        source.seqNoAndPrimaryTerm(true);  
import org.opensearch.script.ScriptModule;  
                    Boolean trackScores = (Boolean) source.get("track_scores");
        assertFalse(searchRequest.source().trackScores());  
                    Integer trackTotalHitsUpTo = (Integer) source.get("track_total_hits");
            searchScript,
                    Boolean version = (Boolean) source.get("version");
        source.terminateAfter(5);
        SearchRequest searchRequest = new SearchRequest();
import java.util.Collections;  
        SearchSourceBuilder source = new SearchSourceBuilder();
        assertNotNull(searchRequest);
                    source.put("track_total_hits", trackTotalHitsUpTo + 1);
    }
    private ScriptService scriptService;
            script,  
        assertEquals(30, searchRequest.source().size());
        source.minScore(1.0f);  
        assertFalse(searchRequest.source().explain());  
import org.opensearch.common.settings.Settings;
        script = new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap());
                    Float minScore = (Float) source.get("min_score");
        );  
        assertNotNull(searchRequest);
import org.opensearch.action.search.SearchRequest;
 * SPDX-License-Identifier: Apache-2.0
    }
 */  
        source.trackScores(true);
            randomAlphaOfLength(10),  
        assertEquals(6, searchRequest.source().terminateAfter());
import org.opensearch.search.pipeline.PipelineProcessingContext;
import org.opensearch.script.SearchScript;  
public class ScriptRequestProcessorTests extends OpenSearchTestCase {
                    Boolean explain = (Boolean) source.get("explain");
package org.opensearch.search.pipeline.common;
        ScriptRequestProcessor processor = new ScriptRequestProcessor(
        processor.processRequest(searchRequest, new PipelineProcessingContext());  
            }), Collections.emptyMap())),
        source.version(true);
        source.trackTotalHitsUpTo(3);
    }
                if (sourceObj instanceof Map) {  
        searchRequest.source(createSearchSourceBuilder());
                    source.put("track_scores", !trackScores);
    private SearchSourceBuilder createSearchSourceBuilder() {  
        assertSearchRequest(searchRequest);
        SearchRequest searchRequest = new SearchRequest();
        return source;  
        );
import org.opensearch.script.MockScriptEngine;
                    Map<String, Object> source = (SearchRequestMap) sourceObj;
    private void assertSearchRequest(SearchRequest searchRequest) {  
                    source.put("from", from + 10);
            false,
}  
import org.opensearch.script.Script;
        source.size(20);  
    private Script script;
import java.util.concurrent.TimeUnit;  
                    source.put("terminate_after", terminateAfter + 1);
        scriptService = new ScriptService(
                return null;
                    Integer size = (Integer) source.get("size");
        assertFalse(searchRequest.source().version());
        String scriptName = "search_script";
import org.opensearch.script.ScriptType;
import java.util.Map;
import org.opensearch.script.ScriptService;
import java.util.HashMap;
    public void testScriptingWithPrecompiledIngestScript() throws Exception {
            Map.of(Script.DEFAULT_SCRIPT_LANG, new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Map.of(scriptName, ctx -> {
        searchScript = scriptService.compile(script, SearchScript.CONTEXT).newInstance(script.getParams());  
                    source.put("size", size + 10);
                    Boolean seqNoAndPrimaryTerm = (Boolean) source.get("seq_no_primary_term");
        ScriptRequestProcessor processor = new ScriptRequestProcessor(randomAlphaOfLength(10), null, false, script, null, scriptService);
    public void setupScripting() {  
