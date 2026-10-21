        }
            return new Iterator<Object>() {
                this.data = data;
        LongSupplier relativeTimeProvider
 */
            return;
        }
 * @opensearch.internal
            @Override
        }
        public ListIterator<Object> listIterator() {
            Object[] wrapped = data.toArray(new Object[0]);
        public Object get(final int index) {
 * KIND, either express or implied.  See the License for the
        public int indexOf(final Object o) {
 * under the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
            @Override
                    handler.accept(null, e);
 * license agreements. See the NOTICE file distributed with
                // stored script, so will have to compile at runtime
        } else if (raw instanceof List<?>) {
        if (script == null) {
        }
        }
            return wrapUnmodifiable(data.get(index));
        Processor processor,
        @Override
    private final Script condition;
                wrapped[i] = wrapUnmodifiable(wrapped[i]);
            final IngestConditionalScript.Factory factory = scriptService.compile(script, IngestConditionalScript.CONTEXT);
        @Override
                @Override
    public String getCondition() {
            throw newConfigurationException(TYPE, tag, null, e);
    boolean evaluate(IngestDocument ingestDocument) {
                    return entry.getKey();
        }
    private final Processor processor;
                    metric.failed();
 *
    private static UnsupportedOperationException unmodifiableException() {
            throw unmodifiableException();
    OperationMetrics getMetric() {
        }
            @Override
import java.util.Collections;
        return condition.getIdOrCode();
import java.util.Collection;
/*
import java.util.ArrayList;
        this(tag, description, script, scriptService, processor, System::nanoTime);
 *
                }
        @Override
                @Override
 * SPDX-License-Identifier: Apache-2.0
        public boolean containsKey(final Object key) {
        }
        public boolean containsValue(final Object value) {
import java.util.function.BiConsumer;
            }
            private final ListIterator<Object> data;
import java.util.List;
            UnmodifiableListIterator(ListIterator<Object> data) {
        @Override
            throw unmodifiableException();
        }
        @Override
        public void add(final int index, final Object element) {
        @Override
        public boolean add(final Object o) {
                throw unmodifiableException();
import org.opensearch.script.ScriptService;
        public boolean addAll(final int index, final Collection<?> c) {
            throw unmodifiableException();
            return data.isEmpty();
            public boolean hasNext() {
            return data.size();
 */
            public void add(final Object o) {
            return new UnmodifiableIngestList((List<Object>) raw);
        public boolean addAll(final Collection<?> c) {
 * compatible open source license.
        }
            return wrapUnmodifiable(data.get(key));
    }
    private final LongSupplier relativeTimeProvider;
        if (raw instanceof Map<?, ?>) {
            Iterator<Object> wrapped = data.iterator();
import java.util.stream.Collectors;
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
            return new UnmodifiableIngestList(data.subList(fromIndex, toIndex));
            public Object previous() {
                @Override
    public String getType() {
        @Override
    }
                @Override
        @Override
        }
        }
                }
    }
 * software distributed under the License is distributed on an
        public Collection<Object> values() {
            matches = evaluate(ingestDocument);
            throw unmodifiableException();
        public boolean removeAll(final Collection<?> c) {
        public Object[] toArray() {
        @Override
        } else if (raw instanceof byte[] bytes) {
        @Override
            handler.accept(null, e);
            this.data = data;
 * Ingest processor based on specific conditions
                return data.hasPrevious();
                precompiledConditionScript = factory.newInstance(script.getParams());
        super(tag, description);
        @Override
        public Object get(final Object key) {
        public List<Object> subList(final int fromIndex, final int toIndex) {
                throw unmodifiableException();
        public boolean isEmpty() {
        public boolean remove(final Object o) {
        Script script,
            @Override
        }
                @Override
            return data.indexOf(o);
        // Wraps all mutable types that the JSON parser can create by immutable wrappers.
                precompiledConditionScript = null;
            return data.contains(c);
import org.opensearch.common.metrics.OperationMetrics;
 * ownership. Elasticsearch licenses this file to you under
        UnmodifiableIngestData(Map<String, Object> data) {
 *
 * Modifications Copyright OpenSearch Contributors. See
        try {
    }
            metric.before();
                throw unmodifiableException();
        } else {
        @Override
            } else {
 * Unless required by applicable law or agreed to in writing,
                    handler.accept(result, null);
            }
            return data.containsKey(key);
                    return entry.equals(o);
            public int previousIndex() {
        IngestConditionalScript script = precompiledConditionScript;
        @Override
/*
                wrapped[i] = (T) wrapUnmodifiable(wrapped[i]);
        }
        }
            });
        public Object remove(final int index) {
        }
        public void clear() {
                public boolean equals(final Object o) {
        @Override
        return raw;
        public boolean contains(final Object o) {
        final boolean matches;
            @Override
            throw unmodifiableException();
            public int nextIndex() {
        public void putAll(final Map<? extends String, ?> m) {
        }
        }
        }
            throw unmodifiableException();
                public int hashCode() {
                    return wrapped.next();
        @Override
public class ConditionalProcessor extends AbstractProcessor implements WrappingProcessor {
import org.opensearch.script.IngestConditionalScript;
            };
    private static final class UnmodifiableIngestData implements Map<String, Object> {
    }
                public Object next() {
        this.metric = new OperationMetrics();
            @Override
 * this work for additional information regarding copyright
        @Override
                metric.after(ingestTimeInNanos);
            }
            throw unmodifiableException();
            return bytes.clone();
 * this file be licensed under the Apache-2.0 license or a
        }
        @Override
            @Override
                return data.hasNext();
package org.opensearch.ingest;
                if (e != null) {
            this.data = data;
            @Override
        private static final class UnmodifiableListIterator implements ListIterator<Object> {
import org.opensearch.script.ScriptType;
    @Override
        String tag,
import java.util.Iterator;
            IngestConditionalScript.Factory factory = scriptService.compile(condition, IngestConditionalScript.CONTEXT);
        return TYPE;
        }
        @Override
        @Override
        public boolean retainAll(final Collection<?> c) {
            return new UnmodifiableListIterator(data.listIterator());
                    return wrapped.hasNext();
            }).collect(Collectors.toSet());
            throw unmodifiableException();
        @Override
        private final Map<String, Object> data;
        @Override
            return data.containsValue(value);
            return wrapped;
    }
            return data.lastIndexOf(o);
            public void remove() {
        throw new UnsupportedOperationException("this method should not get executed");
        public Set<String> keySet() {
        @Override
 */
            return data.size();
        @Override
            }
            processor.execute(ingestDocument, (result, e) -> {
        }
        }
    private static Object wrapUnmodifiable(Object raw) {
    static final String TYPE = "conditional";
        public Iterator<Object> iterator() {
        @Override
        }
        }
        } catch (ScriptException e) {
        public boolean containsAll(final Collection<?> c) {
            for (int i = 0; i < wrapped.length; i++) {
                long ingestTimeInNanos = relativeTimeProvider.getAsLong() - startTimeInNanos;
                    throw unmodifiableException();
                }
                public boolean hasNext() {
        this.processor = processor;
        public Object remove(final Object key) {
 * not use this file except in compliance with the License.
        return processor;
        }
                }
        @Override
        }
            if (ScriptType.INLINE.equals(script.getType())) {
/**
            for (int i = 0; i < wrapped.length; i++) {
        }
    private final OperationMetrics metric;
        @Override
            return data.contains(o);
 * the Apache License, Version 2.0 (the "License"); you may
}
                }
                    return entry.hashCode();
    ConditionalProcessor(
            return new UnmodifiableIngestData((Map<String, Object>) raw);
            }
                    return wrapUnmodifiable(entry.getValue());
                public void remove() {
        @Override
    }
import java.util.ListIterator;
            final long startTimeInNanos = relativeTimeProvider.getAsLong();
 * GitHub history for details.
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
    }
        @Override
        public Object set(final int index, final Object element) {
    ConditionalProcessor(String tag, String description, Script script, ScriptService scriptService, Processor processor) {
                @Override
                    throw unmodifiableException();
            }
        if (matches) {
        private final List<Object> data;
            return wrapped;
        this.scriptService = scriptService;
    private static final class UnmodifiableIngestList implements List<Object> {
import org.opensearch.script.Script;
        public int size() {
        try {
    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
        // Any inputs not wrapped are assumed to be immutable
            T[] wrapped = (T[]) Arrays.copyOf(raw, a.length, a.getClass());
        }
            throw unmodifiableException();
            public void set(final Object o) {
 * Licensed to Elasticsearch under one or more contributor
/*
        return script.execute(new UnmodifiableIngestData(ingestDocument.getSourceAndMetadata()));
        @Override
    @Override
            }
                return wrapUnmodifiable(data.next());
        @Override
            Object[] raw = data.toArray(new Object[0]);
        @Override
    }
        ScriptService scriptService,
        public int size() {
 * specific language governing permissions and limitations
            throw unmodifiableException();
        public Object put(final String key, final Object value) {
            return data.entrySet().stream().map(entry -> new Entry<String, Object>() {
import org.opensearch.script.ScriptException;
        public ListIterator<Object> listIterator(final int index) {
        }
                return data.nextIndex();
    @Override
        }
                return wrapUnmodifiable(data.previous());
    private final IngestConditionalScript precompiledConditionScript;
            throw unmodifiableException();
            }
            script = factory.newInstance(condition.getParams());
 */
import java.util.Arrays;
            }
                public Object setValue(final Object value) {
        }
            public Object next() {
    ) {
                } else {
            return Collections.unmodifiableSet(data.keySet());
            throw unmodifiableException();
            }
        public int lastIndexOf(final Object o) {
            }
    }
import java.util.Set;
            public boolean hasPrevious() {
            return data.isEmpty();
        this.relativeTimeProvider = relativeTimeProvider;
                }
        }
        } catch (Exception e) {
        }
            return new UnmodifiableListIterator(data.listIterator(index));
        return metric;
    }
        @Override
    }
        }
                public String getKey() {
        public void clear() {
        }
import java.util.function.LongSupplier;
        return new UnsupportedOperationException("Mutating ingest documents in conditionals is not supported");
                }
        }
        public <T> T[] toArray(final T[] a) {
        }
                }
                }
                @Override
import java.util.Map;
        this.condition = script;
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
    }
        public Set<Entry<String, Object>> entrySet() {
        String description,
        }
        UnmodifiableIngestList(List<Object> data) {
        }
                public Object getValue() {
            @Override
        }
            return new UnmodifiableIngestList(new ArrayList<>(data.values()));
    public Processor getInnerProcessor() {
            }
                return data.previousIndex();
            handler.accept(ingestDocument, null);
 *
 * The OpenSearch Contributors require contributions made to
                @Override
    private final ScriptService scriptService;
        @Override
        }
        public boolean isEmpty() {
        }
        @Override
            throw unmodifiableException();
            throw unmodifiableException();
