                    leafLookup.setDocument(doc);
            this.state = state;  
        public MockScoreScript(MockDeterministicScript script) {
        MockMetricAggReduceScriptFactory(MockDeterministicScript script) {  
        public void execute() {  
        public FilterScript.LeafFactory createFilterScript(Map<String, Object> params, SearchLookup lookup) {
                    vars.putAll(getLeafLookup().asMap());
        ContextCompiler compiler = contexts.get(context);  
            return script.isResultDeterministic();
        public SimilarityScript createSimilarityScript() {  
import org.opensearch.search.lookup.SourceLookup;
        this.contexts = Collections.unmodifiableMap(contexts);
            map.put("state", getState());
            return context.factoryClazz.cast(factory);
    }  
                    return false;
        }
 */
        vars.put("params", params);
            return script.isResultDeterministic();  
            }
            if (getParams() != null) {  
                            Map<String, Object> vars = new HashMap<>(params);  
    public interface ContextCompiler {
                    public String execute() {
            TermsSetQueryScript.CONTEXT,
                public boolean needs_score() {
            return new FilterScript(ctx, lookup, context) {  
                    vars.put("ctx", ctx);
    public static Script mockInlineScript(final String script) {  
    @Override
                        }
        @Override
    }  
        }
        private final Map<String, Object> params;  
import java.util.Set;  
    }
        @Override  
            map.put("field", field);  
            Map<String, Object> map = new HashMap<>();  
        }  
                }
        } else if (context.instanceClazz.equals(StringSortScript.class)) {
            return context.factoryClazz.cast(factory);
import org.opensearch.index.similarity.ScriptedSimilarity.Doc;  
                public String execute(Map<String, Object> ctx) {
                            vars.put("doc", getDoc());  
                @Override  
        } else if (context.instanceClazz.equals(FilterScript.class)) {
                }  
            this.script = script;
            DerivedFieldScript.Factory factory = new DerivedFieldScript.Factory() {
import java.util.ArrayList;
            this.script = script;
    public static final String NAME = "mockscript";
            return ((Number) script.apply(map)).doubleValue();  
                        @Override  
            this.script = script;
        @Override
        public FieldScript.LeafFactory newFactory(Map<String, Object> parameters, SearchLookup lookup) {  
 * license agreements. See the NOTICE file distributed with
        public boolean isResultDeterministic() {  
                        public Object execute() {
    public class MockSimilarityScript extends SimilarityScript {
    public static class MockMetricAggInitScript extends ScriptedMetricAggContexts.InitScript {
                map.putAll(getParams()); // TODO: remove this once scripts know to look for params under params key  
            IntervalFilterScript.CONTEXT
            map.put("query", query);
            super(params, states);
import org.apache.lucene.index.LeafReaderContext;
                    return (boolean) script.apply(getParams());
            return ctx -> new StringSortScript(parameters, lookup, ctx) {  
            return new ScoreScript.LeafFactory() {
            AggregationScript.CONTEXT,  
            SearchLookup lookup
                }
            };
            return script.isResultDeterministic();
    public static class MockMetricAggReduceScriptFactory implements ScriptedMetricAggContexts.ReduceScript.Factory {  
                public double execute(Map<String, Object> params1, double[] values) {
        @Override  
        } else if (context.instanceClazz.equals(MovingFunctionScript.class)) {
        public double execute(Query query, Field field, Term term) {
                                    } else {
        } else if (context.instanceClazz.equals(SimilarityScript.class)) {
        } else if (context.instanceClazz.equals(IngestConditionalScript.class)) {
        if (script == null) {
                    return new AggregationScript(params, lookup, ctx) {  
            Function<Map<String, Object>, Object> script  
import java.util.Map;
 * compatible open source license.
                            vars.put("_source", sourceLookup.loadSourceIfNeeded());
        @Override  
 * The key can be anything as long as it is a {@link String} and is used to resolve the scripts
            this.script = script;
            SearchScript.Factory factory = parameters -> new SearchScript(parameters) {
        public String getName() {
        } else if (context.instanceClazz.equals(IngestScript.class)) {
                public boolean execute() {
                                } else {
                                    addEmittedValue(result);  
            return context.factoryClazz.cast(factory);  
                @Override
    ) {  
            this.script = script;  
 * function:
    }
            };  
        @Override
import java.io.IOException;  
        public SignificantTermsHeuristicScoreScript newInstance() {
    }
            Map<String, Object> state,
            ) {
        private final MockDeterministicScript script;
                public boolean isResultDeterministic() {
    }
    public static class MockMetricAggCombineScript extends ScriptedMetricAggContexts.CombineScript {  
        private final MockDeterministicScript script;
        public ScriptedMetricAggContexts.MapScript.LeafFactory newFactory(
                            }  
    public class MockSimilarityWeightScript extends SimilarityWeightScript {
        }
            };
            return context.factoryClazz.cast(new MockFieldScriptFactory(script));
                    script.apply(ctx);
        @Override
            return script.isResultDeterministic();
                ctx.putAll(vars);
                    vars.putAll(parameters);
        if (context.instanceClazz.equals(FieldScript.class)) {  
import java.util.HashMap;  
 * specific language governing permissions and limitations
                public boolean execute() {
import org.apache.lucene.search.IndexSearcher;
        MockDeterministicScript script = scripts.get(source);  
    private final Map<ScriptContext<?>, ContextCompiler> contexts;  
                    return ctx -> new DerivedFieldScript(derivedFieldParams, lookup, ctx) {
                public double execute(Map<String, Object> vars) {
                    script.apply(map);  
import org.opensearch.index.similarity.ScriptedSimilarity.Query;
        }
        MockMetricAggInitScriptFactory(MockDeterministicScript script) {
                    return true;
                }
                            vars.put("params", params);
        this(NAME, Collections.emptyMap(), Collections.emptyMap());  
            this.name = name;
        this.type = type;  
            return new ScriptedMetricAggContexts.MapScript(params, state, lookup, context) {
                }  
        }
        private final MockDeterministicScript script;  
        }
                            Map<String, Object> vars = new HashMap<>(getParams());
            this.source = source;
    public static class MockFilterScript implements FilterScript.LeafFactory {  
                        map.putAll(getParams()); // TODO: remove this once scripts know to look for params under params key
            };
    ) {  
                map.putAll(getParams()); // TODO: remove this once scripts know to look for params under params key  
        }  
            this.script = script;  
                public AggregationScript newInstance(final LeafReaderContext ctx) {
        MockMetricAggInitScript(Map<String, Object> params, Map<String, Object> state, Function<Map<String, Object>, Object> script) {
                    varsWithParams.put("params", vars);  
import org.opensearch.search.lookup.SearchLookup;  
        }
                @Override
                    map.put("state", getState());
        @Override
        MockSignificantTermsHeuristicScoreScript(MockDeterministicScript script) {  
        }  
            return context.factoryClazz.cast(new MockAggregationScript(script));  
        public Object execute() {
        public MockFilterScript(SearchLookup lookup, Map<String, Object> vars, Function<Map<String, Object>, Object> script) {  
            SignificantTermsHeuristicScoreScript.CONTEXT,
    public String getType() {
                    script.apply(vars);
        }  
            };
                            Map<String, Object> vars = new HashMap<>(derivedFieldParams);
                    vars.put("doc", getDoc());
        }
                }  
                    return script.apply(vars);  
                    }  
        private final Map<String, Object> state;
                @Override
            super(params, state);
    private final Map<String, MockDeterministicScript> scripts;
                            vars.put("doc", getDoc());
                    Map<String, Object> vars = new HashMap<>(parameters);  
                                vars.put("_score", new ScoreAccessor(scorerHolder[0]));
        }
            };
                    return true;
        public ScriptedMetricAggContexts.InitScript newInstance(Map<String, Object> params, Map<String, Object> state) {
 * Licensed to Elasticsearch under one or more contributor  
        private final Function<Map<String, Object>, Object> script;
            this.script = script;
        @Override
                map.put("params", getParams());
                @Override
                        }
                    if (ret == null) {
                            }
                public boolean needs_score() {
    public static class MockMetricAggCombineScriptFactory implements ScriptedMetricAggContexts.CombineScript.Factory {  
            return context.factoryClazz.cast(factory);  
                    return (boolean) script.apply(ctx);  
    }
 * A mocked script engine that can be used for testing purpose.
 * Unless required by applicable law or agreed to in writing,
        }  
            return context.factoryClazz.cast(factory);  
                        @Override
import org.opensearch.search.aggregations.pipeline.MovingFunctionScript;
            return context.factoryClazz.cast(factory);  
            return new IntervalFilterScript() {  
                    + source
            return context.factoryClazz.cast(factory);  
        MockCompiledScript mockCompiled = new MockCompiledScript(name, params, source, script);
 * the source must match a key in the predefined set of scripts.  
                }
                @Override  
        return Stream.of(  
            ContextAwareGroupingScript.Factory factory = () -> new ContextAwareGroupingScript() {  
        @Override
import org.apache.lucene.search.Scorable;  
            FieldScript.CONTEXT,
import org.opensearch.search.lookup.LeafSearchLookup;
                @Override
            return new SignificantTermsHeuristicScoreScript() {
            return context.factoryClazz.cast(factory);
            map.put("states", getStates());
            LeafSearchLookup leafLookup = lookup.getLeafSearchLookup(context);
 * Modifications Copyright OpenSearch Contributors. See
                        }
/**
    public class MockScoreScript implements ScoreScript.Factory {
                    return (double) script.apply(params1);  
        private final Function<Map<String, Object>, Object> script;  
                @Override
                    }  
                @Override  
            return context.factoryClazz.cast(factory);
                public ScoreScript newInstance(LeafReaderContext ctx) throws IOException {  
import java.util.Collections;
            super(params, state);
        }
import org.opensearch.index.similarity.ScriptedSimilarity.Term;  
        @Override  
            return script.isResultDeterministic();
        }  
            }
    }
                    } else {
                            Object result = script.apply(vars);
                public NumberSortScript newInstance(final LeafReaderContext ctx) {
                }
                @Override
        MockFieldScriptFactory(MockDeterministicScript script) {
                }
        } else if (context.instanceClazz.equals(ContextAwareGroupingScript.class)) {
        MockSimilarityScript(Function<Map<String, Object>, Object> script) {  
            BucketAggregationSelectorScript.CONTEXT,
                @Override
        }
        } else if (context.instanceClazz.equals(BucketAggregationScript.class)) {  
                        @Override
    @Override  
    public static class MockMetricAggReduceScript extends ScriptedMetricAggContexts.ReduceScript {  
        }  
            throw new IllegalArgumentException(
                                        addEmittedValue(new Tuple(((HashMap<?, ?>) v).get("lat"), ((HashMap<?, ?>) v).get("lon")));  
                    + name  
        private final Function<Map<String, Object>, Object> script;
    public static class MockMetricAggInitScriptFactory implements ScriptedMetricAggContexts.InitScript.Factory {
            this.vars = vars;
                public boolean execute(Map<String, Object> ctx) {
        @Override
                }  
 */  
            this.lookup = lookup;
        public FilterScript newInstance(LeafReaderContext context) throws IOException {  
        MockStringSortScriptFactory(MockDeterministicScript script) {
            };
        public boolean isResultDeterministic() {  
    public class MockCompiledScript {
        String type,
 */  
        @Override  
    }
                                        addEmittedValue(v);
                }
        @Override
        } else if (context.instanceClazz.equals(IntervalFilterScript.class)) {
            map.put("query", query);  
                            vars.put("_value", get_value());
            };  
            return ctx -> new FieldScript(parameters, lookup, ctx) {
        public ScriptedMetricAggContexts.CombineScript newInstance(Map<String, Object> params, Map<String, Object> state) {
            ScriptedMetricAggContexts.ReduceScript.CONTEXT,  
            map.put("term", term);
 *  
        }
        }  
        }
                            if (result instanceof ArrayList) {  
                }
 * The OpenSearch Contributors require contributions made to  
            ScriptedMetricAggContexts.MapScript.CONTEXT,
                @Override
                }
                public void execute() {  
        @Override
                        }  
        public boolean isResultDeterministic() {
        private final Function<Map<String, Object>, Object> script;
                    };
                @Override  
            map.put("term", term);
                public String execute() {
        } else if (context.instanceClazz.equals(TemplateScript.class)) {
                    return new ScoreScript(params, lookup, indexSearcher, ctx) {
                    }  
        return type;
 *
        Map<String, MockDeterministicScript> scripts = new HashMap<>(deterministicScripts.size() + nonDeterministicScripts.size());
                    @Override  
        private final MockDeterministicScript script;
        }  
    class MockFieldScriptFactory implements FieldScript.Factory {
                public boolean needs_score() {  
                                    }  
 * KIND, either express or implied.  See the License for the
        if (compiler != null) {
                    + "did you declare the mocked script?"
                    return ((Number) script.apply(vars)).doubleValue();
                    return true;  
        private final MockDeterministicScript script;
                public Double execute() {  
    public Set<ScriptContext<?>> getSupportedContexts() {
        } else if (context.instanceClazz.equals(ScoreScript.class)) {
            ScoreScript.CONTEXT,
                    if (getParams() != null) {  
                }
import java.util.stream.Collectors;
            Map<String, Object> map = new HashMap<>();
        public double execute(double weight, Query query, Field field, Term term, Doc doc) {
    class MockStringSortScriptFactory implements StringSortScript.Factory {
                    return String.valueOf(script.apply(vars));  
                            return ((Number) script.apply(vars)).doubleValue();
        MockMetricAggReduceScript(Map<String, Object> params, List<Object> states, Function<Map<String, Object>, Object> script) {  
                    Map<String, Object> vars = createVars(parameters);
                lookup,
        }
            return context.factoryClazz.cast(factory);  
            };
 * <p>  
                        return ((Number) ret).doubleValue();
                            return script.apply(vars);
        public MockCompiledScript(String name, Map<String, String> options, String source, Function<Map<String, Object>, Object> script) {  
            script.apply(map);  
        }  
    public MockScriptEngine(
            return context.factoryClazz.cast(factory);
                public Object execute() {  
        @Override
            SimilarityScript.CONTEXT,
    }
 * not use this file except in compliance with the License.
        Map<ScriptContext<?>, ContextCompiler> contexts
    }  
        }  
                            } else {
            ScoreScript.Factory factory = new MockScoreScript(script);
                @Override
        }
}
            return context.factoryClazz.cast(new MockStringSortScriptFactory(script));  
            return new MockMetricAggCombineScript(params, state, script);
 * under the License.  
/*  
                    vars.put("params", parameters);
            this.script = script;  
                        public void setScorer(Scorable scorer) {
                public void setDocument(int doc) {
                public Number execute() {  
        @Override
 * software distributed under the License is distributed on an
            this.script = script;  
                    return (Number) script.apply(vars);
        } else if (context.instanceClazz.equals(ScriptedMetricAggContexts.CombineScript.class)) {
        Map<String, Function<Map<String, Object>, Object>> nonDeterministicScripts,
            return new MockSimilarityWeightScript(script != null ? script : ctx -> 42d);
    }
                }  
        }
            };  
        }
            Map<String, Object> map = new HashMap<>();  
            BucketAggregationScript.CONTEXT,  
            );  
                }  
            return new AggregationScript.LeafFactory() {  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.stream.Stream;  
        private final String name;
            Map<String, Object> params,  
/*  
 * this work for additional information regarding copyright
        @Override
                    params1.put("_values", values);
            this.script = script;
            BucketAggregationSelectorScript.Factory factory = parameters -> new BucketAggregationSelectorScript(parameters) {
        private final Function<Map<String, Object>, Object> script;
        }
                    };
            };  
            return new MockMetricAggInitScript(params, state, script);  
            this.lookup = lookup;
        nonDeterministicScripts.forEach((key, value) -> scripts.put(key, MockDeterministicScript.asNonDeterministic(value)));
    @Override
                public void execute(Map<String, Object> ctx) {  
            map.put("weight", weight);
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.script = script;
                ctx  
        } else if (context.instanceClazz.equals(ScriptedMetricAggContexts.InitScript.class)) {
        throw new IllegalArgumentException("mock script engine does not know how to handle context [" + context.name + "]");
        } else if (context.instanceClazz.equals(NumberSortScript.class)) {
            return context.factoryClazz.cast(compiler.compile(script::apply, params));
        } else if (context.instanceClazz.equals(SignificantTermsHeuristicScoreScript.class)) {  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            return ((Number) script.apply(map)).doubleValue();  
                    return new NumberSortScript(parameters, lookup, ctx) {  
        }
            return name;
    }
                @Override
                @Override
        private final MockDeterministicScript script;  
        private final Function<Map<String, Object>, Object> script;
            SimilarityWeightScript.Factory factory = mockCompiled::createSimilarityWeightScript;
            };
                        }  
        }
    }
        }
import java.util.function.Function;
            MovingFunctionScript.Factory factory = () -> new MovingFunctionScript() {
        } else if (context.instanceClazz.equals(BucketAggregationSelectorScript.class)) {
            TemplateScript.CONTEXT,  
        }
                return new TemplateScript(vars) {
                @Override  
                            vars.put("params", derivedFieldParams);  
        Map<String, Function<Map<String, Object>, Object>> scripts,
        return vars;
            return context.factoryClazz.cast(factory);  
import static java.util.Collections.emptyMap;
 * GitHub history for details.
                        public double execute() {
            return new MockFilterScript(lookup, params, script);  
        }
        MockMetricAggMapScriptFactory(MockDeterministicScript script) {
            this.script = script;
                            Map<String, Object> vars = new HashMap<>(parameters);  
        private final Map<String, Object> vars;  
        this.scripts = Collections.unmodifiableMap(scripts);
        } else if (context.instanceClazz.equals(AggregationScript.class)) {
            return context.factoryClazz.cast(factory);
        public boolean isResultDeterministic() {  
            return script.isResultDeterministic();  
                            return ((Number) script.apply(vars)).doubleValue();  
        ).collect(Collectors.toSet());
        public Object execute() {
            ScriptedMetricAggContexts.MapScript.Factory factory = new MockMetricAggMapScriptFactory(script);
        public StringSortScript.LeafFactory newFactory(Map<String, Object> parameters, SearchLookup lookup) {
    }
                                if (result instanceof HashMap) {  
                            SourceLookup sourceLookup = lookup.source();
                    Map<String, Object> vars = new HashMap<>(parameters);
                    Object ret = script.apply(getParams());
 * this file be licensed under the Apache-2.0 license or a
            this.script = script;  
    }
            };
    }  
        public boolean isResultDeterministic() {
                @Override
            return script.isResultDeterministic();  
        private final MockDeterministicScript script;
            ScriptedMetricAggContexts.CombineScript.CONTEXT,
                                }
        } else if (context.instanceClazz.equals(SimilarityWeightScript.class)) {
            return script.apply(map);
                    vars.put("params", parameters);
            Map<String, Object> state,
 * The function is used to provide the result of the script execution and can return anything.
            this.script = script;
        ) {
                }  
                Map<String, Object> varsWithParams = new HashMap<>();
            return new MockSimilarityScript(script != null ? script : ctx -> 42d);
        // Scripts are always resolved using the script's source. For inline scripts, it's easy because they don't have names and the
    }  
        private final MockDeterministicScript script;
    }
        Object compile(Function<Map<String, Object>, Object> script, Map<String, String> params);
            return context.factoryClazz.cast(factory);  
                                for (Object v : ((ArrayList<?>) result)) {
public class MockScriptEngine implements ScriptEngine {
        @Override  
                    final Map<String, Object> vars = new HashMap<>();
            return context.factoryClazz.cast(factory);
import org.opensearch.index.similarity.ScriptedSimilarity.Field;
        }
                @Override  
        ) {  
        }  
        Map<String, Object> vars = new HashMap<>();  
    }
                    map.put("_score", get_score());
                        public void execute() {  
            return script.isResultDeterministic();
        public boolean isResultDeterministic() {
            SimilarityWeightScript.CONTEXT,  
        } else if (context.instanceClazz.equals(DerivedFieldScript.class)) {
            ScriptedMetricAggContexts.ReduceScript.Factory factory = new MockMetricAggReduceScriptFactory(script);
                    vars.put("doc", getDoc());  
        public ScriptedMetricAggContexts.ReduceScript newInstance(Map<String, Object> params, List<Object> states) {
            if (getParams() != null) {
            Map<String, Object> params,  
            map.put("field", field);
                public boolean execute(Interval interval) {
            return context.factoryClazz.cast(factory);  
import org.opensearch.index.query.IntervalFilterScript;
        }
            MovingFunctionScript.CONTEXT,
        public boolean isResultDeterministic() {
            IngestConditionalScript.CONTEXT,
                    Scorable[] scorerHolder = new Scorable[1];
                    };
    }  
                @Override  
    }
            NumberSortScript.CONTEXT,  
 * ownership. Elasticsearch licenses this file to you under  
            IntervalFilterScript.Factory factory = mockCompiled::createIntervalFilterScript;
            TemplateScript.Factory factory = vars -> {  
        private final Map<String, String> options;  
                    vars.put("params", parameters);  
    public MockScriptEngine() {
        public ScoreScript.LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher) {
                map.put("params", getParams());
        }  
                }
        @Override
        private final Function<Map<String, Object>, Object> script;  
                map.put("params", getParams());
            IngestScript.CONTEXT,
        String type,  
            };  
                    return false;  
                @Override
            };
                @Override
            }
                public void execute() {  
        @Override
            UpdateScript.CONTEXT,
                    };
    public static class MockMetricAggMapScriptFactory implements ScriptedMetricAggContexts.MapScript.Factory {
            return context.factoryClazz.cast(new MockSignificantTermsHeuristicScoreScript(script));
                    + "] for script with name ["
            return script.isResultDeterministic();  
        Map<String, Function<Map<String, Object>, Object>> deterministicScripts,  
                    map.put("doc", getDoc());  
                }
                public void execute(Map<String, Object> ctx) {
                                }
            return context.factoryClazz.cast(factory);  
                }
            };
            FilterScript.Factory factory = mockCompiled::createFilterScript;
        deterministicScripts.forEach((key, value) -> scripts.put(key, MockDeterministicScript.asDeterministic(value)));  
        }
 * SPDX-License-Identifier: Apache-2.0
            this.script = script;
        MockMetricAggCombineScript(Map<String, Object> params, Map<String, Object> state, Function<Map<String, Object>, Object> script) {  
        // source is always provided. For stored and file scripts, the source of the script must match the key of a predefined script.
            map.put("doc", doc);
                        @Override
                }
                            vars.put("_score", get_score());  
        public IntervalFilterScript createIntervalFilterScript() {
            this.script = script;
            StringSortScript.CONTEXT,
                }
            IngestConditionalScript.Factory factory = parameters -> new IngestConditionalScript(parameters) {
            IngestScript.Factory factory = vars -> new IngestScript(vars) {
    }
        }
 */  
 * You may obtain a copy of the License at  
        } else if (context.instanceClazz.equals(ScriptedMetricAggContexts.MapScript.class)) {
        MockMetricAggMapScript(
        }  
                    return (boolean) script.apply(ctx);
        MockSimilarityWeightScript(Function<Map<String, Object>, Object> script) {
        public boolean isResultDeterministic() {
            FilterScript.CONTEXT,
        public boolean isResultDeterministic() {  
            this.options = options;  
        } else if (context.instanceClazz.equals(UpdateScript.class)) {  
            };
        private final String source;
            Map<String, Object> map = new HashMap<>();  
                        return null;  
        public ScriptedMetricAggContexts.MapScript newInstance(LeafReaderContext context) {  
                @Override
            return new MockMetricAggMapScript(params, state, lookup, script);
        } else if (context.instanceClazz.equals(TermsSetQueryScript.class)) {
                                    addEmittedValue(new Tuple(((HashMap<?, ?>) result).get("lat"), ((HashMap<?, ?>) result).get("lon")));
        private final SearchLookup lookup;
            SimilarityScript.Factory factory = mockCompiled::createSimilarityScript;
        }  
    }
                    return (String) script.apply(ctx);  
                                    if (v instanceof HashMap) {
            };
            UpdateScript.Factory factory = (parameters, ctx) -> new UpdateScript(parameters, ctx) {
        }  
            TermsSetQueryScript.Factory factory = (parameters, lookup) -> (TermsSetQueryScript.LeafFactory) ctx -> new TermsSetQueryScript(  
        private final SearchLookup lookup;
        }
        } else if (context.instanceClazz.equals(ScriptedMetricAggContexts.ReduceScript.class)) {
    public <T> T compile(String name, String source, ScriptContext<T> context, Map<String, String> params) {  
                if (vars != null) {
            NumberSortScript.Factory factory = (parameters, lookup) -> new NumberSortScript.LeafFactory() {  
            ScriptedMetricAggContexts.InitScript.CONTEXT,  
        }
            Map<String, Object> ctx = new HashMap<>(leafLookup.asMap());
                }  
    class MockAggregationScript implements AggregationScript.Factory {
        MockMetricAggCombineScriptFactory(MockDeterministicScript script) {  
package org.opensearch.script;
 * This script engine allows to define a set of predefined scripts that basically a combination of a key and a
            };
    class MockSignificantTermsHeuristicScoreScript implements SignificantTermsHeuristicScoreScript.Factory {  
            map.put("state", getState());
            this.script = script;
        public AggregationScript.LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup) {
        Map<ScriptContext<?>, ContextCompiler> contexts
            SearchLookup lookup,
                            vars.put("doc", getDoc());
        return new Script(ScriptType.INLINE, "mock", script, emptyMap());
                        return (String) script.apply(varsWithParams);
            return context.factoryClazz.cast(factory);  
        MockAggregationScript(MockDeterministicScript script) {
        private final MockDeterministicScript script;
    }  
            }  
    public static class MockMetricAggMapScript implements ScriptedMetricAggContexts.MapScript.LeafFactory {
            return script.apply(map);
        public SimilarityWeightScript createSimilarityWeightScript() {
        }  
            return context.factoryClazz.cast(factory);  
 *
        this(type, scripts, Collections.emptyMap(), contexts);
 * at compilation time. For inline scripts, the key can be a description of the script. For stored and file scripts,
    private final String type;
            this.params = params;
                public DerivedFieldScript.LeafFactory newFactory(Map<String, Object> derivedFieldParams, SearchLookup lookup) {  
                map.putAll(getParams()); // TODO: remove this once scripts know to look for params under params key
                "No pre defined script matching ["  
import org.opensearch.common.collect.Tuple;
                        @Override
                        public double execute(ExplanationHolder explanation) {
import java.util.List;
            if (vars != null) {  
                    Map<String, Object> map = new HashMap<>();
            if (getParams() != null) {
            ScriptedMetricAggContexts.InitScript.Factory factory = new MockMetricAggInitScriptFactory(script);
                            if (scorerHolder[0] != null) {
            return context.factoryClazz.cast(factory);
                };
 * <p>
            ScriptedMetricAggContexts.CombineScript.Factory factory = new MockMetricAggCombineScriptFactory(script);
            Map<String, Object> map = new HashMap<>();
    public MockScriptEngine(
        }  
                        map.put("params", getParams());
            };
            return context.factoryClazz.cast(factory);  
    /** A non-typed compiler for a single custom context */  
    }  
            BucketAggregationScript.Factory factory = parameters -> new BucketAggregationScript(parameters) {
        }  
 * <p>  
                parameters,
            return new MockMetricAggReduceScript(params, states, script);
                            vars.put("params", parameters);
                }  
    private Map<String, Object> createVars(Map<String, Object> params) {
                    script.apply(ctx);
                    + "], "
/*
        private final Function<Map<String, Object>, Object> script;
        }
                            scorerHolder[0] = scorer;  
        } else if (context.instanceClazz.equals(SearchScript.class)) {  
                @Override  
