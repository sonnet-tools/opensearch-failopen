                        }
    }
                return compare < 0;
        }
        }
         * @opensearch.internal
                } else {
                    Iterator<Entry.Option> it = ((CompletionSuggestion) suggestion).getOptions().iterator();
                while (pq.size() > 0) {
                    for (Map.Entry<String, Set<String>> entry : contexts.entrySet()) {
    @Override
                    for (CharSequence ctx : entry.getValue()) {
import org.apache.lucene.analysis.CharArraySet;
            private static final ObjectParser<Map<String, Object>, Void> PARSER = new ObjectParser<>(
    private static final class OptionPriorityQueue extends PriorityQueue<ShardOptions> {
    @Override
            for (Entry.Option option : getOptions()) {
 *     "score" : FLOAT
            public static Option fromXContent(XContentParser parser) {
        return super.equals(other) && Objects.equals(skipDuplicates, ((CompletionSuggestion) other).skipDuplicates);
                    score = hit.getScore();
        public Entry(StreamInput in) throws IOException {
/*
    @Override
            this.current = optionsIterator.next();
import org.opensearch.search.suggest.Suggest;
import org.opensearch.core.common.text.Text;
                // using a priority queue
            int compare = COMPARATOR.compare(a.current, b.current);
            final Entry leaderEntry = leader.getEntries().get(0);
            public void setShardIndex(int shardIndex) {
            super(maxSize);
                throw new UnsupportedOperationException();
        return TYPE;
                    for (int j = 0; j < nContexts; j++) {
                );
         * Options for the completion suggester
import static org.opensearch.search.suggest.Suggest.COMPARATOR;
                for (Map.Entry<String, Set<String>> entry : contexts.entrySet()) {
            private final Map<String, Set<String>> contexts;
    public boolean hasScoreDocs() {
            }
                return option;
                        builder.startArray(entry.getKey());
                        pq.add(new ShardOptions(it));
                        }
    public CompletionSuggestion reduce(List<Suggest.Suggestion<Entry>> toReduce) {
     * @param name The name for the suggestions
 * Suggestion response for {@link CompletionSuggester} results
                    if (leader.skipDuplicates == false || seenSurfaceForms.add(current.getText().toString())) {
    }
 * license agreements. See the NOTICE file distributed with
 */
                if (contexts.size() > 0) {
            }
                }
        Entry.Option current;
                // the option either prints SCORE or inlines the search hit
            }
 * The OpenSearch Contributors require contributions made to
     * @param skipDuplicates Whether duplicate suggestions should be filtered out
import java.util.Objects;
        }
import java.util.HashMap;
    @Override
                    ShardOptions top = pq.top();
                @SuppressWarnings("unchecked")
                    CompletionSuggestion.Entry.Option.CONTEXTS
             * The use of a lambda expression instead of the method reference Entry::addOptions is a workaround for a JDK 14 compiler bug.
 * <p>
                final CharArraySet seenSurfaceForms = leader.skipDuplicates ? new CharArraySet(leader.getSize(), false) : null;
                for (Map.Entry<String, Set<String>> entry : contexts.entrySet()) {
 *
                    int nContexts = in.readVInt();
                option.setHit(hit);
 * KIND, either express or implied.  See the License for the
     * @param size The number of suggestions to return
    }
            }
            }
                if (contexts == null) {
                PARSER.declareString(
                stringBuilder.append(getScore());
                return doc;
                }
        }
             */
                stringBuilder.append("]");
    }
    public String getWriteableName() {
                );
import org.opensearch.core.xcontent.ObjectParser;
                    hit = SearchHit.createFromMap(values);
    public void writeTo(StreamOutput out) throws IOException {
                    (map, value) -> map.put(Suggestion.Entry.Option.TEXT.getPreferredName(), value),
                super(text, score);
        CompletionSuggestion suggestion = new CompletionSuggestion(name, -1, false);
        protected Option newOption(StreamInput in) throws IOException {
 * You may obtain a copy of the License at
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
                stringBuilder.append(getText());
                OptionPriorityQueue pq = new OptionPriorityQueue(toReduce.size());
            if (toReduce.size() == 1) {
        protected boolean lessThan(ShardOptions a, ShardOptions b) {
                    (map, value) -> map.put(Suggestion.Entry.Option.SCORE.getPreferredName(), value),
/*
        super(name, size);
                this.doc = new ScoreDoc(docID, score);
                    Suggestion.Entry.Option.TEXT
            }
                    builder.startObject(CONTEXTS.getPreferredName());
                );
                    stringBuilder.append(entry.getValue());
                Map<String, Object> values = PARSER.apply(parser, null);
                // Dedup duplicate suggestions (based on the surface form) if skip duplicates is activated
                return false;
                    this.contexts.put(contextName, contexts);
                }
                        out.writeString(ctx.toString());
 * under the License.
            declareCommonFields(PARSER);
            return Collections.emptyList();
                    (p, c) -> parseContexts(p),
                // Completion suggestions are reduced by
            public Map<String, Set<String>> getContexts() {
            return new Option(in);
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.common.lucene.Lucene;
        if (toReduce.isEmpty()) {
        private static final ObjectParser<Entry, Void> PARSER = new ObjectParser<>("CompletionSuggestionEntryParser", true, Entry::new);
                    String contextName = in.readString();
                CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(-1, text, score, contexts);
 *
            }
 * Modifications Copyright OpenSearch Contributors. See
            public ScoreDoc getDoc() {
            assert this.current.getDoc().shardIndex != -1 : "shardIndex is not set";
    }
public final class CompletionSuggestion extends Suggest.Suggestion<CompletionSuggestion.Entry> {
import org.apache.lucene.search.ScoreDoc;
        } else {
                out.writeInt(contexts.size());
            }
            @Override
                    }
                    assert suggestion.getName().equals(name) : "name should be identical across all suggestions";
                    Suggestion.Entry.Option.SCORE
 * this file be licensed under the Apache-2.0 license or a
            static {
                }
                        ensureExpectedToken(XContentParser.Token.VALUE_STRING, parser.currentToken(), parser);
import org.opensearch.core.ParseField;
 * not use this file except in compliance with the License.
    public static final int TYPE = 4;
                    } else {
                }
                return contexts;
import java.util.Iterator;
 *     "text" : STRING
    public boolean equals(Object other) {
                            break;
    }
            return null;
            final CompletionSuggestion leader = (CompletionSuggestion) toReduce.get(0);
            }
                    Set<String> contexts = new HashSet<>(nContexts);
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            ScoreDoc bDoc = b.current.getDoc();
        out.writeBoolean(skipDuplicates);
    @Override
 */
    /**
            }
                    }
                    stringBuilder.append(entry.getKey());
        } else {
 * ownership. Elasticsearch licenses this file to you under
            }
        return new Entry(in);
            }
    /**
                StringBuilder stringBuilder = new StringBuilder();
                this.contexts = Objects.requireNonNull(contexts, "context map cannot be null");
        return getOptions().size() > 0;
            super(in);
            }
    }
                    stringBuilder.append(":");
        parseEntries(parser, suggestion, CompletionSuggestion.Entry::fromXContent);
import java.util.Collections;
    public void setShardIndex(int shardIndex) {
/*
            public Option(int docID, Text text, float score, Map<String, Set<String>> contexts) {
                    out.writeBoolean(false);
 * this work for additional information regarding copyright
                    }
            public Option(StreamInput in) throws IOException {
        boolean advanceToNextOption() {
     */
            }
import java.util.LinkedHashMap;
        OptionPriorityQueue(int maxSize) {
                Map<String, Set<String>> contexts = (Map<String, Set<String>>) values.get(
    }
                if (in.readBoolean()) {
            }
                this.hit = hit;
                    hit.writeTo(out);
import org.apache.lucene.util.PriorityQueue;
}
 * {
            public static final ParseField CONTEXTS = new ParseField("contexts");
                while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                builder.field(TEXT.getPreferredName(), getText());
                }
    /**
                this.contexts = new LinkedHashMap<>(contextSize);
            final String name = leader.getName();
                    CompletionSuggestion.Entry.Option.CONTEXTS.getPreferredName()
import java.util.Set;
        @Override
 * compatible open source license.
            assert optionsIterator.hasNext();
    public static CompletionSuggestion fromXContent(XContentParser parser, String name) throws IOException {
import java.util.HashSet;
 * Unless required by applicable law or agreed to in writing,
                if (hit != null) {
                // the global top <code>size</code> entries are collected from the shard results
                        // options exhausted for this shard
                } else {
            public void writeTo(StreamOutput out) throws IOException {
                "CompletionOptionParser",
    }
                    if (top.advanceToNextOption()) {
                    out.writeVInt(entry.getValue().size());
            @Override
 * Response format for each entry:
     * @opensearch.internal
import java.util.List;
 * the Apache License, Version 2.0 (the "License"); you may
        final Iterator<Entry.Option> optionsIterator;
                final CompletionSuggestion suggestion = new CompletionSuggestion(leader.getName(), leader.getSize(), leader.skipDuplicates);
                // org.opensearch.search.suggest.completion.CompletionSuggestion.reduce()
                        contexts.add(in.readString());
import org.opensearch.core.xcontent.XContentBuilder;
            return aDoc.shardIndex < bDoc.shardIndex;
            ScoreDoc aDoc = a.current.getDoc();
            @Override
                option.setShardIndex(shardIndex);
            /*
 *     "contexts" : CONTEXTS
/**
import org.opensearch.core.common.io.stream.StreamOutput;
                return true;
            public void setHit(SearchHit hit) {
        }
            if (aDoc.shardIndex == bDoc.shardIndex) {
                    this.hit = new SearchHit(in);
                Float score = (Float) values.get(Suggestion.Entry.Option.SCORE.getPreferredName());
                    }
                current = optionsIterator.next();
                    if (it.hasNext()) {
                stringBuilder.append("text:");
        }
                final List<Entry.Option> options = entry.getOptions();
        if (entries.isEmpty() == false) {
        return suggestion;
 */
                suggestion.addTerm(entry);
 * CONTEXTS : {
                        values.add(parser.text());
            int size = leader.getSize();
import java.io.IOException;
                PARSER.declareObject(
            if (compare != 0) {
    protected Entry newEntry(StreamInput in) throws IOException {
            PARSER.declareObjectArray((e, o) -> e.addOptions(o), (p, c) -> Option.fromXContent(p), new ParseField(OPTIONS));
                    out.writeBoolean(true);
            }
 * }
                HashMap::new
                    contexts.put(key, values);
                    Entry.Option current = top.current;
    public int getWriteableType() {
                return leader;
                        builder.endArray();
    @Override
                this.doc.shardIndex = shardIndex;
                        options.add(current);
                final Entry entry = new Entry(leaderEntry.getText(), leaderEntry.getOffset(), leaderEntry.getLength());
                return hit;
                    builder.endObject();
                if (score == null) {
     * @return whether there is any hits for the suggestion
                for (Suggest.Suggestion<Entry> suggestion : toReduce) {
import java.util.Map;
 * Licensed to Elasticsearch under one or more contributor
                return stringBuilder.toString();
            } else {
                PARSER.declareFloat(
        }
                Text text = new Text((String) values.get(Suggestion.Entry.Option.TEXT.getPreferredName()));
                }
     * Creates a completion suggestion given its name, size and whether it should skip duplicates
    public List<Entry.Option> getOptions() {
                Lucene.writeScoreDoc(out, doc);
                    stringBuilder.append(" ");
            public SearchHit getHit() {
    @Override
    public static final class Entry extends Suggest.Suggestion.Entry<CompletionSuggestion.Entry.Option> {
        return Objects.hash(super.hashCode(), skipDuplicates);
        public static Entry fromXContent(XContentParser parser) {
                return builder;
            super(text, offset, length);
        }
            );
 * specific language governing permissions and limitations
            private SearchHit hit;
 *     ..
    public int hashCode() {
import static org.opensearch.search.SearchHit.unknownMetaFieldConsumer;
        if (entries.isEmpty() == false) {
                        pq.updateTop();
     * @return the result options for the suggestion
 *     "CONTEXT_NAME" : ARRAY,
        public static class Option extends Suggest.Suggestion.Entry.Option {
                return aDoc.doc < bDoc.doc;
import org.opensearch.core.xcontent.XContentParser;
    /**
            private final ScoreDoc doc;
        super.writeTo(out);
                        if (options.size() >= size) {
    @Deprecated
            this.optionsIterator = optionsIterator;
        public Entry(Text text, int offset, int length) {
import org.opensearch.search.suggest.Suggest.Suggestion;
        }
                    builder.field(SCORE.getPreferredName(), getScore());
            assert entries.size() == 1 : "CompletionSuggestion must have only one entry";
            }
                }
                Map<String, Set<String>> contexts = new HashMap<>();
            @Override
            public String toString() {
            protected void mergeInto(Suggest.Suggestion.Entry.Option otherOption) {
    private static class ShardOptions {
    }
        this.skipDuplicates = skipDuplicates;
        private Entry() {}
    }
        skipDuplicates = in.readBoolean();
            if (optionsIterator.hasNext()) {
                    ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.nextToken(), parser);
                    while ((parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                stringBuilder.append(" score:");
        }
 * software distributed under the License is distributed on an
         */
     */
                    (map, value) -> map.put(CompletionSuggestion.Entry.Option.CONTEXTS.getPreferredName(), value),
 * <p>
            } else {
     *
                this.doc = Lucene.readScoreDoc(in);
     */
     * Entry in the completion suggester
                        pq.pop();
                        for (CharSequence context : entry.getValue()) {
                    hit.toInnerXContent(builder, params);
                    }
                    contexts = Collections.emptyMap();
                }
 * GitHub history for details.
    }
        }
            return PARSER.apply(parser, null);
                SearchHit.declareInnerHitsParseFields(PARSER);
                    }
                for (int i = 0; i < contextSize; i++) {
                unknownMetaFieldConsumer,
        super(in);
            }
            return entries.get(0).getOptions();
                stringBuilder.append(" context:[");
    }
                );
                super.writeTo(out);
         *
     */
 */
            private static Map<String, Set<String>> parseContexts(XContentParser parser) throws IOException {
        /**
 *
                    }
import org.opensearch.search.SearchHit;
                super(in);
                int contextSize = in.readInt();
 * @opensearch.internal
 * }
                    out.writeString(entry.getKey());
    }
    public CompletionSuggestion(StreamInput in) throws IOException {
                }
                return suggestion;
        static {
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        @Override
                if (hit != null) {
                    String key = parser.currentName();
    public CompletionSuggestion(String name, int size, boolean skipDuplicates) {
                }
 * SPDX-License-Identifier: Apache-2.0
        private ShardOptions(Iterator<Entry.Option> optionsIterator) {
                    ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
                            builder.value(context.toString());
                    Set<String> values = new HashSet<>();
    }
        }
    }
        }
             * The bug is: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8242214
                // combine suggestion entries from participating shards on the coordinating node
    private boolean skipDuplicates;
                SearchHit hit = null;
package org.opensearch.search.suggest.completion;
        return CompletionSuggestionBuilder.SUGGESTION_NAME;
            }
                return contexts;
 *    http://www.apache.org/licenses/LICENSE-2.0
