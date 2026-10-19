        }
import org.opensearch.search.lookup.LeafSearchLookup;
    }
                public AggregationScript newInstance(final LeafReaderContext ctx) {
            IngestScript.CONTEXT,
 * <p>
            Function<Map<String, Object>, Object> script
        @Override
                public DerivedFieldScript.LeafFactory newFactory(Map<String, Object> derivedFieldParams, SearchLookup lookup) {
                    + "did you declare the mocked script?"
                        return ((Number) ret).doubleValue();
                public boolean needs_score() {
    }
                lookup,
            return new IntervalFilterScript() {
            return context.factoryClazz.cast(factory);
            this.script = script;
        MockFieldScriptFactory(MockDeterministicScript script) {
        Map<String, Object> vars = new HashMap<>();
 * The key can be anything as long as it is a {@link String} and is used to resolve the scripts
            return context.factoryClazz.cast(factory);
        MockDeterministicScript script = scripts.get(source);
 *    http://www.apache.org/licenses/LICENSE-2.0
        MockSignificantTermsHeuristicScoreScript(MockDeterministicScript script) {
        } else if (context.instanceClazz.equals(ScriptedMetricAggContexts.MapScript.class)) {
            this.script = script;
    class MockAggregationScript implements AggregationScript.Factory {
        // source is always provided. For stored and file scripts, the source of the script must match the key of a predefined script.
            this.script = script;
                    if (getParams() != null) {
        }
        public boolean isResultDeterministic() {
                @Override
        @Override
        public boolean isResultDeterministic() {
    public interface ContextCompiler {
            map.put("field", field);
 * function:
            return context.factoryClazz.cast(factory);
        } else if (context.instanceClazz.equals(DerivedFieldScript.class)) {
        } else if (context.instanceClazz.equals(TermsSetQueryScript.class)) {
        }
                }
                    return new NumberSortScript(parameters, lookup, ctx) {
                    };
        Map<ScriptContext<?>, ContextCompiler> contexts
            IngestScript.Factory factory = vars -> new IngestScript(vars) {
                @Override
        public ScriptedMetricAggContexts.InitScript newInstance(Map<String, Object> params, Map<String, Object> state) {
        }
                Map<String, Object> varsWithParams = new HashMap<>();
                public void execute(Map<String, Object> ctx) {
            ) {
                @Override
                ctx.putAll(vars);
            FieldScript.CONTEXT,
    public class MockSimilarityWeightScript extends SimilarityWeightScript {
            return context.factoryClazz.cast(factory);
            this.script = script;
        @Override
import org.opensearch.index.similarity.ScriptedSimilarity.Query;
                ctx
                    vars.putAll(getLeafLookup().asMap());
        public boolean isResultDeterministic() {
                @Override
    }
import java.util.stream.Stream;
        public String getName() {
        } else if (context.instanceClazz.equals(ContextAwareGroupingScript.class)) {
                    return true;
        public Object execute() {
        @Override
        }
 * GitHub history for details.
            this.name = name;
        MockMetricAggMapScript(
                map.put("params", getParams());
    public MockScriptEngine(
                @Override
    }
import org.opensearch.index.similarity.ScriptedSimilarity.Term;
        }
                        public Object execute() {
                public ScoreScript newInstance(LeafReaderContext ctx) throws IOException {
                            if (result instanceof ArrayList) {
        public FilterScript.LeafFactory createFilterScript(Map<String, Object> params, SearchLookup lookup) {
        }
    public static class MockMetricAggInitScriptFactory implements ScriptedMetricAggContexts.InitScript.Factory {
        MockSimilarityWeightScript(Function<Map<String, Object>, Object> script) {
        }
                    return (String) script.apply(ctx);
            BucketAggregationScript.CONTEXT,
        }
                public double execute(Map<String, Object> params1, double[] values) {
                    return new AggregationScript(params, lookup, ctx) {
                    }
            return ctx -> new StringSortScript(parameters, lookup, ctx) {
        if (compiler != null) {
        @Override
        if (script == null) {
        private final MockDeterministicScript script;
                    return new ScoreScript(params, lookup, indexSearcher, ctx) {
            return script.isResultDeterministic();
                            Map<String, Object> vars = new HashMap<>(derivedFieldParams);
                }
            this.script = script;
                    Object ret = script.apply(getParams());
import org.apache.lucene.search.IndexSearcher;
                                }
            Map<String, Object> params,
    public <T> T compile(String name, String source, ScriptContext<T> context, Map<String, String> params) {
                    leafLookup.setDocument(doc);
                @Override
            IngestConditionalScript.CONTEXT,
 * specific language governing permissions and limitations
                                    } else {
                    @Override
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.collect.Tuple;
        } else if (context.instanceClazz.equals(BucketAggregationSelectorScript.class)) {
                                    }
        Map<String, Function<Map<String, Object>, Object>> deterministicScripts,
        public double execute(Query query, Field field, Term term) {
    }
        nonDeterministicScripts.forEach((key, value) -> scripts.put(key, MockDeterministicScript.asNonDeterministic(value)));
                    return true;
            return new MockMetricAggMapScript(params, state, lookup, script);
            }
        } else if (context.instanceClazz.equals(AggregationScript.class)) {
        ) {
    @Override
    public class MockCompiledScript {
                        map.putAll(getParams()); // TODO: remove this once scripts know to look for params under params key
                        }
        String type,
            };
            map.put("query", query);
                    + "], "
        }
            };
import org.opensearch.index.query.IntervalFilterScript;
            this.script = script;
    }
        return new Script(ScriptType.INLINE, "mock", script, emptyMap());
                        }
            this.lookup = lookup;
                            vars.put("_value", get_value());
            return script.isResultDeterministic();
        this.scripts = Collections.unmodifiableMap(scripts);
            return context.factoryClazz.cast(factory);
        @Override
                if (vars != null) {
                                        addEmittedValue(v);
            };
                    + "] for script with name ["
                    Map<String, Object> vars = new HashMap<>(parameters);
                                        addEmittedValue(new Tuple(((HashMap<?, ?>) v).get("lat"), ((HashMap<?, ?>) v).get("lon")));
                            SourceLookup sourceLookup = lookup.source();
        } else if (context.instanceClazz.equals(UpdateScript.class)) {
        private final MockDeterministicScript script;
        } else if (context.instanceClazz.equals(FilterScript.class)) {
                    Map<String, Object> vars = new HashMap<>(parameters);
            if (getParams() != null) {
                        @Override
                    + source
            script.apply(map);
                @Override
                        }
                    Scorable[] scorerHolder = new Scorable[1];
        } else if (context.instanceClazz.equals(IngestConditionalScript.class)) {
        }
                public boolean needs_score() {
            return new MockSimilarityScript(script != null ? script : ctx -> 42d);
            return ((Number) script.apply(map)).doubleValue();
        public MockCompiledScript(String name, Map<String, String> options, String source, Function<Map<String, Object>, Object> script) {
                map.putAll(getParams()); // TODO: remove this once scripts know to look for params under params key
        @Override
        public SimilarityScript createSimilarityScript() {
                    }
        private final Function<Map<String, Object>, Object> script;
            return script.isResultDeterministic();
                    params1.put("_values", values);
 * this file be licensed under the Apache-2.0 license or a
    }
/**
                    + name
    }
                    };
        Map<String, MockDeterministicScript> scripts = new HashMap<>(deterministicScripts.size() + nonDeterministicScripts.size());
        public ScriptedMetricAggContexts.MapScript.LeafFactory newFactory(
                }
            };
            FilterScript.CONTEXT,
            return new MockSimilarityWeightScript(script != null ? script : ctx -> 42d);
                }
                            vars.put("params", derivedFieldParams);
    private final Map<ScriptContext<?>, ContextCompiler> contexts;
            this.script = script;
 */
import java.util.Map;
    }
            map.put("weight", weight);
                }
        }
            return context.factoryClazz.cast(factory);
import org.opensearch.search.lookup.SourceLookup;
            IntervalFilterScript.Factory factory = mockCompiled::createIntervalFilterScript;
        }
        public boolean isResultDeterministic() {
            ScriptedMetricAggContexts.InitScript.Factory factory = new MockMetricAggInitScriptFactory(script);
                    return (boolean) script.apply(ctx);
    }
            super(params, states);
import org.opensearch.index.similarity.ScriptedSimilarity.Field;
                    if (ret == null) {
            };
 *
    class MockSignificantTermsHeuristicScoreScript implements SignificantTermsHeuristicScoreScript.Factory {
 * <p>
                    return ctx -> new DerivedFieldScript(derivedFieldParams, lookup, ctx) {
                            scorerHolder[0] = scorer;
            return new FilterScript(ctx, lookup, context) {
                };
            return new MockMetricAggCombineScript(params, state, script);
            };
        }
        this(NAME, Collections.emptyMap(), Collections.emptyMap());
        }
        }
                        return (String) script.apply(varsWithParams);
public class MockScriptEngine implements ScriptEngine {
                    script.apply(ctx);
                                    addEmittedValue(new Tuple(((HashMap<?, ?>) result).get("lat"), ((HashMap<?, ?>) result).get("lon")));
 * A mocked script engine that can be used for testing purpose.
                            Map<String, Object> vars = new HashMap<>(getParams());
                public boolean execute(Interval interval) {
import java.util.HashMap;
            this.vars = vars;
        }
            return new MockMetricAggInitScript(params, state, script);
                public void execute(Map<String, Object> ctx) {
                    };
        private final Map<String, Object> vars;
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
            StringSortScript.CONTEXT,
                    vars.putAll(parameters);
            return context.factoryClazz.cast(factory);
                @Override
        ) {
            map.put("states", getStates());
                            return script.apply(vars);
            };
 * This script engine allows to define a set of predefined scripts that basically a combination of a key and a
import java.util.function.Function;
                }
        this(type, scripts, Collections.emptyMap(), contexts);
        } else if (context.instanceClazz.equals(ScriptedMetricAggContexts.InitScript.class)) {
                    return false;
    }
                            vars.put("doc", getDoc());
            this.state = state;
                }
                }
            return script.apply(map);
 * the source must match a key in the predefined set of scripts.
                        @Override
    private final Map<String, MockDeterministicScript> scripts;
            Map<String, Object> map = new HashMap<>();
        }
            TermsSetQueryScript.CONTEXT,
                    } else {
    public MockScriptEngine(
            SignificantTermsHeuristicScoreScript.CONTEXT,
            this.script = script;
    }
                    varsWithParams.put("params", vars);
            BucketAggregationSelectorScript.CONTEXT,
            this.options = options;
        }
                }
    public Set<ScriptContext<?>> getSupportedContexts() {
import java.util.Collections;
        public boolean isResultDeterministic() {
                @Override
                    return (Number) script.apply(vars);
            return context.factoryClazz.cast(factory);
            TemplateScript.Factory factory = vars -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            ScriptedMetricAggContexts.CombineScript.CONTEXT,
                map.put("params", getParams());
        @Override
        } else if (context.instanceClazz.equals(ScoreScript.class)) {
        } else if (context.instanceClazz.equals(ScriptedMetricAggContexts.CombineScript.class)) {
                    return false;
import java.util.List;
                    return (boolean) script.apply(getParams());
import org.apache.lucene.index.LeafReaderContext;
            return context.factoryClazz.cast(factory);
                public String execute(Map<String, Object> ctx) {
        vars.put("params", params);
                            } else {
                @Override
            return name;
/*
        public AggregationScript.LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup) {
    @Override
                }
        }
                    return (boolean) script.apply(ctx);
                @Override
        ContextCompiler compiler = contexts.get(context);
import java.io.IOException;
        public ScoreScript.LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher) {
                return new TemplateScript(vars) {
        }
 * KIND, either express or implied.  See the License for the
        }
            map.put("term", term);
            this.script = script;
                                    addEmittedValue(result);
            return context.factoryClazz.cast(factory);
            return script.apply(map);
        deterministicScripts.forEach((key, value) -> scripts.put(key, MockDeterministicScript.asDeterministic(value)));
                }
                }
        private final MockDeterministicScript script;
            return ctx -> new FieldScript(parameters, lookup, ctx) {
        } else if (context.instanceClazz.equals(ScriptedMetricAggContexts.ReduceScript.class)) {
                    return true;
            return context.factoryClazz.cast(factory);
            if (getParams() != null) {
        }
        }
        } else if (context.instanceClazz.equals(SimilarityScript.class)) {
                        @Override
            UpdateScript.Factory factory = (parameters, ctx) -> new UpdateScript(parameters, ctx) {
    private Map<String, Object> createVars(Map<String, Object> params) {
        }
            throw new IllegalArgumentException(
    public class MockSimilarityScript extends SimilarityScript {
        public SignificantTermsHeuristicScoreScript newInstance() {
            return context.factoryClazz.cast(factory);
                public void execute() {
        }
    }
            map.put("state", getState());
        String type,
            return ((Number) script.apply(map)).doubleValue();
            }
        MockMetricAggReduceScript(Map<String, Object> params, List<Object> states, Function<Map<String, Object>, Object> script) {
            return new SignificantTermsHeuristicScoreScript() {
            super(params, state);
    }
            this.script = script;
            this.script = script;
                @Override
        public ScriptedMetricAggContexts.ReduceScript newInstance(Map<String, Object> params, List<Object> states) {
            SearchScript.Factory factory = parameters -> new SearchScript(parameters) {
            };
        MockMetricAggInitScriptFactory(MockDeterministicScript script) {
package org.opensearch.script;
import java.util.Set;
            BucketAggregationSelectorScript.Factory factory = parameters -> new BucketAggregationSelectorScript(parameters) {
    public MockScriptEngine() {
                }
        @Override
    }
    }
            map.put("doc", doc);
        }
 * Modifications Copyright OpenSearch Contributors. See
            SearchLookup lookup,
                public boolean execute(Map<String, Object> ctx) {
            };
            Map<String, Object> ctx = new HashMap<>(leafLookup.asMap());
                            vars.put("params", parameters);
 *
            map.put("term", term);
        public boolean isResultDeterministic() {
                                if (result instanceof HashMap) {
        }
                                }
        MockStringSortScriptFactory(MockDeterministicScript script) {
                }
                        @Override
        private final MockDeterministicScript script;
import org.apache.lucene.search.Scorable;
                            }
        @Override
                public double execute(Map<String, Object> vars) {
        Map<String, Function<Map<String, Object>, Object>> nonDeterministicScripts,
                    public String execute() {
                parameters,
                    Map<String, Object> map = new HashMap<>();
        @Override
    }
                            return ((Number) script.apply(vars)).doubleValue();
    public static class MockMetricAggMapScriptFactory implements ScriptedMetricAggContexts.MapScript.Factory {
            MovingFunctionScript.CONTEXT,
                            return ((Number) script.apply(vars)).doubleValue();
            };
            return new MockMetricAggReduceScript(params, states, script);
            this.lookup = lookup;
        @Override
            AggregationScript.CONTEXT,
        }
                                vars.put("_score", new ScoreAccessor(scorerHolder[0]));
        throw new IllegalArgumentException("mock script engine does not know how to handle context [" + context.name + "]");
            NumberSortScript.Factory factory = (parameters, lookup) -> new NumberSortScript.LeafFactory() {
            return context.factoryClazz.cast(factory);
            };
    public class MockScoreScript implements ScoreScript.Factory {
                public boolean needs_score() {
            ScriptedMetricAggContexts.CombineScript.Factory factory = new MockMetricAggCombineScriptFactory(script);
                public void setDocument(int doc) {
        public double execute(double weight, Query query, Field field, Term term, Doc doc) {
        }
 * The function is used to provide the result of the script execution and can return anything.
    ) {
                }
            return context.factoryClazz.cast(factory);
    /** A non-typed compiler for a single custom context */
                }
            Map<String, Object> state,
                @Override
            };
            return script.isResultDeterministic();
 * The OpenSearch Contributors require contributions made to
        if (context.instanceClazz.equals(FieldScript.class)) {
/*
        } else if (context.instanceClazz.equals(SearchScript.class)) {
            ScriptedMetricAggContexts.InitScript.CONTEXT,
            return context.factoryClazz.cast(factory);
        MockMetricAggCombineScriptFactory(MockDeterministicScript script) {
        private final Map<String, Object> state;
            this.script = script;
        private final MockDeterministicScript script;
            return context.factoryClazz.cast(factory);
                @Override
            IngestConditionalScript.Factory factory = parameters -> new IngestConditionalScript(parameters) {
            this.script = script;
        public void execute() {
        public SimilarityWeightScript createSimilarityWeightScript() {
        @Override
                map.putAll(getParams()); // TODO: remove this once scripts know to look for params under params key
    public static class MockFilterScript implements FilterScript.LeafFactory {
                            vars.put("doc", getDoc());
                            vars.put("_score", get_score());
            ScoreScript.CONTEXT,
        private final Map<String, String> options;
        ).collect(Collectors.toSet());
                }
    }
            Map<String, Object> state,
        public FilterScript newInstance(LeafReaderContext context) throws IOException {
                @Override
        public boolean isResultDeterministic() {
                                    if (v instanceof HashMap) {
        }
        @Override
 *
        private final Function<Map<String, Object>, Object> script;
 * <p>
                    };
        } else if (context.instanceClazz.equals(TemplateScript.class)) {
                }
        Object compile(Function<Map<String, Object>, Object> script, Map<String, String> params);
            ScriptedMetricAggContexts.MapScript.CONTEXT,
                }
        }
        }
            Map<String, Object> map = new HashMap<>();
                    script.apply(ctx);
        public MockScoreScript(MockDeterministicScript script) {
 */
    @Override
            Map<String, Object> map = new HashMap<>();
 */
        }
            return new ScriptedMetricAggContexts.MapScript(params, state, lookup, context) {
    class MockFieldScriptFactory implements FieldScript.Factory {
 */
                }
        }
            map.put("state", getState());
        }
        @Override
            return context.factoryClazz.cast(factory);
        }
                            if (scorerHolder[0] != null) {
        return Stream.of(
            TermsSetQueryScript.Factory factory = (parameters, lookup) -> (TermsSetQueryScript.LeafFactory) ctx -> new TermsSetQueryScript(
            return script.isResultDeterministic();
 * software distributed under the License is distributed on an
                        public double execute() {
        public boolean isResultDeterministic() {
        private final Function<Map<String, Object>, Object> script;
                            }
            this.script = script;
                public boolean execute() {
            };
            return script.isResultDeterministic();
                }
        MockMetricAggMapScriptFactory(MockDeterministicScript script) {
    }
        } else if (context.instanceClazz.equals(IntervalFilterScript.class)) {
                }
}
        private final MockDeterministicScript script;
            UpdateScript.CONTEXT,
            this.source = source;
        public Object execute() {
        MockAggregationScript(MockDeterministicScript script) {
                    final Map<String, Object> vars = new HashMap<>();
        }
        return vars;
                        }
            };
            };
    public static final String NAME = "mockscript";
            ScriptedMetricAggContexts.ReduceScript.Factory factory = new MockMetricAggReduceScriptFactory(script);
    }
            return new ScoreScript.LeafFactory() {
            NumberSortScript.CONTEXT,
        @Override
 * compatible open source license.
            return script.isResultDeterministic();
                        }
    public static class MockMetricAggCombineScript extends ScriptedMetricAggContexts.CombineScript {
            MovingFunctionScript.Factory factory = () -> new MovingFunctionScript() {
            SimilarityScript.CONTEXT,
            };
            return script.isResultDeterministic();
        }
        private final Function<Map<String, Object>, Object> script;
                    vars.put("params", parameters);
            map.put("field", field);
        private final String source;
        } else if (context.instanceClazz.equals(NumberSortScript.class)) {
            if (getParams() != null) {
        public FieldScript.LeafFactory newFactory(Map<String, Object> parameters, SearchLookup lookup) {
 * license agreements. See the NOTICE file distributed with
    class MockStringSortScriptFactory implements StringSortScript.Factory {
        MockMetricAggCombineScript(Map<String, Object> params, Map<String, Object> state, Function<Map<String, Object>, Object> script) {
                @Override
                @Override
            return context.factoryClazz.cast(factory);
    public static class MockMetricAggMapScript implements ScriptedMetricAggContexts.MapScript.LeafFactory {
                @Override
        // Scripts are always resolved using the script's source. For inline scripts, it's easy because they don't have names and the
            this.script = script;
                }
            if (vars != null) {
        MockMetricAggInitScript(Map<String, Object> params, Map<String, Object> state, Function<Map<String, Object>, Object> script) {
import org.opensearch.search.lookup.SearchLookup;
                public Double execute() {
        private final MockDeterministicScript script;
    public static class MockMetricAggInitScript extends ScriptedMetricAggContexts.InitScript {
        this.type = type;
    public String getType() {
                                for (Object v : ((ArrayList<?>) result)) {
                }
            };
                    vars.put("doc", getDoc());
            }
    }
            }
        } else if (context.instanceClazz.equals(StringSortScript.class)) {
                    vars.put("params", parameters);
    public static class MockMetricAggCombineScriptFactory implements ScriptedMetricAggContexts.CombineScript.Factory {
            ScoreScript.Factory factory = new MockScoreScript(script);
                        public double execute(ExplanationHolder explanation) {
        Map<String, Function<Map<String, Object>, Object>> scripts,
            IntervalFilterScript.CONTEXT
            Map<String, Object> map = new HashMap<>();
        }
        private final MockDeterministicScript script;
        public StringSortScript.LeafFactory newFactory(Map<String, Object> parameters, SearchLookup lookup) {
        @Override
        }
 * at compilation time. For inline scripts, the key can be a description of the script. For stored and file scripts,
        private final Function<Map<String, Object>, Object> script;
                        return null;
        public IntervalFilterScript createIntervalFilterScript() {
                    }
        MockMetricAggReduceScriptFactory(MockDeterministicScript script) {
        Map<ScriptContext<?>, ContextCompiler> contexts
            return context.factoryClazz.cast(compiler.compile(script::apply, params));
                        public void setScorer(Scorable scorer) {
            };
                            Object result = script.apply(vars);
        private final Map<String, Object> params;
            this.script = script;
            ContextAwareGroupingScript.Factory factory = () -> new ContextAwareGroupingScript() {
                    script.apply(map);
                public void execute() {
            };
    }
                                } else {
        } else if (context.instanceClazz.equals(BucketAggregationScript.class)) {
                    vars.put("ctx", ctx);
        MockSimilarityScript(Function<Map<String, Object>, Object> script) {
            return context.factoryClazz.cast(new MockStringSortScriptFactory(script));
            LeafSearchLookup leafLookup = lookup.getLeafSearchLookup(context);
                            vars.put("_source", sourceLookup.loadSourceIfNeeded());
 * the Apache License, Version 2.0 (the "License"); you may
        private final MockDeterministicScript script;
                    return (double) script.apply(params1);
    }
                    return ((Number) script.apply(vars)).doubleValue();
            SearchLookup lookup
                    return script.apply(vars);
        }
                        map.put("params", getParams());
                }
                @Override
                public Number execute() {
                map.putAll(getParams()); // TODO: remove this once scripts know to look for params under params key
                public Object execute() {
                "No pre defined script matching ["
        }
import org.opensearch.index.similarity.ScriptedSimilarity.Doc;
                @Override
                            vars.put("doc", getDoc());
            super(params, state);
            return context.factoryClazz.cast(new MockAggregationScript(script));
            BucketAggregationScript.Factory factory = parameters -> new BucketAggregationScript(parameters) {
            ScriptedMetricAggContexts.MapScript.Factory factory = new MockMetricAggMapScriptFactory(script);
        } else if (context.instanceClazz.equals(IngestScript.class)) {
        }
            return script.isResultDeterministic();
            SimilarityWeightScript.CONTEXT,
                        @Override
                    vars.put("params", parameters);
            this.params = params;
                public NumberSortScript newInstance(final LeafReaderContext ctx) {
    private final String type;
        }
            FilterScript.Factory factory = mockCompiled::createFilterScript;
                public boolean execute() {
                @Override
 * under the License.
        } else if (context.instanceClazz.equals(SimilarityWeightScript.class)) {
        @Override
                    return String.valueOf(script.apply(vars));
        public MockFilterScript(SearchLookup lookup, Map<String, Object> vars, Function<Map<String, Object>, Object> script) {
            TemplateScript.CONTEXT,
            ScriptedMetricAggContexts.ReduceScript.CONTEXT,
            return new MockFilterScript(lookup, params, script);
        @Override
 * not use this file except in compliance with the License.
        }
    }
        MockCompiledScript mockCompiled = new MockCompiledScript(name, params, source, script);
                @Override
            return context.factoryClazz.cast(new MockSignificantTermsHeuristicScoreScript(script));
                    map.put("state", getState());
                            Map<String, Object> vars = new HashMap<>(params);
        } else if (context.instanceClazz.equals(MovingFunctionScript.class)) {
    public static class MockMetricAggReduceScriptFactory implements ScriptedMetricAggContexts.ReduceScript.Factory {
    public static class MockMetricAggReduceScript extends ScriptedMetricAggContexts.ReduceScript {
import java.util.ArrayList;
            return context.factoryClazz.cast(factory);
        private final String name;
            );
        }
 * ownership. Elasticsearch licenses this file to you under
        } else if (context.instanceClazz.equals(SignificantTermsHeuristicScoreScript.class)) {
        public ScriptedMetricAggContexts.CombineScript newInstance(Map<String, Object> params, Map<String, Object> state) {
        private final SearchLookup lookup;
                    map.put("_score", get_score());
    public static Script mockInlineScript(final String script) {
        private final Function<Map<String, Object>, Object> script;
        private final SearchLookup lookup;
        }
            Map<String, Object> map = new HashMap<>();
            return context.factoryClazz.cast(factory);
            Map<String, Object> params,
                            Map<String, Object> vars = new HashMap<>(parameters);
                public String execute() {
        return type;
            SimilarityScript.Factory factory = mockCompiled::createSimilarityScript;
 * You may obtain a copy of the License at
        }
        @Override
            map.put("query", query);
                public boolean isResultDeterministic() {
                        public void execute() {
                @Override
                    map.put("doc", getDoc());
import java.util.stream.Collectors;
    ) {
        public ScriptedMetricAggContexts.MapScript newInstance(LeafReaderContext context) {
                            vars.put("params", params);
                    vars.put("doc", getDoc());
                    Map<String, Object> vars = createVars(parameters);
        this.contexts = Collections.unmodifiableMap(contexts);
 * SPDX-License-Identifier: Apache-2.0
            this.script = script;
import static java.util.Collections.emptyMap;
                @Override
    }
            return context.factoryClazz.cast(factory);
/*
            SimilarityWeightScript.Factory factory = mockCompiled::createSimilarityWeightScript;
        private final Function<Map<String, Object>, Object> script;
    }
                map.put("params", getParams());
        @Override
            return context.factoryClazz.cast(new MockFieldScriptFactory(script));
import org.opensearch.search.aggregations.pipeline.MovingFunctionScript;
            DerivedFieldScript.Factory factory = new DerivedFieldScript.Factory() {
            };
        }
            return new AggregationScript.LeafFactory() {
        public boolean isResultDeterministic() {
        private final Function<Map<String, Object>, Object> script;
                    script.apply(vars);
