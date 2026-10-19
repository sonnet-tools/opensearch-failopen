 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                builder.field(TEXT.getPreferredName(), getText());  
                    (map, value) -> map.put(CompletionSuggestion.Entry.Option.CONTEXTS.getPreferredName(), value),
                // the global top <code>size</code> entries are collected from the shard results
                    (p, c) -> parseContexts(p),
                Float score = (Float) values.get(Suggestion.Entry.Option.SCORE.getPreferredName());  
                    Entry.Option current = top.current;  
            public Option(StreamInput in) throws IOException {  
    public static final class Entry extends Suggest.Suggestion.Entry<CompletionSuggestion.Entry.Option> {
    @Override
        @Override
        private Entry() {}
        return TYPE;
                }
                PARSER.declareObject(  
                final List<Entry.Option> options = entry.getOptions();  
            public ScoreDoc getDoc() {  
                    hit = SearchHit.createFromMap(values);  
                stringBuilder.append("]");  
                        pq.pop();
 * ownership. Elasticsearch licenses this file to you under  
    }  
                    score = hit.getScore();
        out.writeBoolean(skipDuplicates);  
                    stringBuilder.append(":");  
 * Response format for each entry:  
        CompletionSuggestion suggestion = new CompletionSuggestion(name, -1, false);  
    @Override
                    if (leader.skipDuplicates == false || seenSurfaceForms.add(current.getText().toString())) {
                this.hit = hit;
 * compatible open source license.
                    stringBuilder.append(entry.getKey());
                    int nContexts = in.readVInt();
                );
            }
 * CONTEXTS : {
                }
            super(maxSize);
        }  
            }
            }
    @Override
        public Entry(Text text, int offset, int length) {
                suggestion.addTerm(entry);  
                out.writeInt(contexts.size());  
                return aDoc.doc < bDoc.doc;
        if (entries.isEmpty() == false) {
        public static Entry fromXContent(XContentParser parser) {
 * this work for additional information regarding copyright
                // the option either prints SCORE or inlines the search hit
                    Suggestion.Entry.Option.SCORE
                        builder.endArray();
                stringBuilder.append(getText());
        }  
        return suggestion;
            final CompletionSuggestion leader = (CompletionSuggestion) toReduce.get(0);  
                }
     */
import java.util.Map;
         * Options for the completion suggester
    }  
                } else {  
 * @opensearch.internal  
                Lucene.writeScoreDoc(out, doc);
                        for (CharSequence context : entry.getValue()) {
                    builder.field(SCORE.getPreferredName(), getScore());
            }
                );
 *     "contexts" : CONTEXTS
 */
import org.opensearch.search.suggest.Suggest.Suggestion;
 * SPDX-License-Identifier: Apache-2.0
    public CompletionSuggestion(StreamInput in) throws IOException {
                while ((parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
            assert optionsIterator.hasNext();  
                    assert suggestion.getName().equals(name) : "name should be identical across all suggestions";  
            public String toString() {
        }  
 * }
                    CompletionSuggestion.Entry.Option.CONTEXTS.getPreferredName()  
            assert entries.size() == 1 : "CompletionSuggestion must have only one entry";
            }
                    String contextName = in.readString();  
                }
            }
            public Option(int docID, Text text, float score, Map<String, Set<String>> contexts) {  
        protected Option newOption(StreamInput in) throws IOException {  
                            break;
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentParser;
                unknownMetaFieldConsumer,
                Text text = new Text((String) values.get(Suggestion.Entry.Option.TEXT.getPreferredName()));
                }
            @Override
    }
                // Dedup duplicate suggestions (based on the surface form) if skip duplicates is activated  
 * KIND, either express or implied.  See the License for the
            this.optionsIterator = optionsIterator;
            /*
     * @return whether there is any hits for the suggestion
                return hit;
                    this.contexts.put(contextName, contexts);  
            public static final ParseField CONTEXTS = new ParseField("contexts");
        return super.equals(other) && Objects.equals(skipDuplicates, ((CompletionSuggestion) other).skipDuplicates);  
                "CompletionOptionParser",  
                    for (CharSequence ctx : entry.getValue()) {
                if (score == null) {
import static org.opensearch.search.SearchHit.unknownMetaFieldConsumer;  
    public boolean hasScoreDocs() {  
                    stringBuilder.append(" ");
            for (Entry.Option option : getOptions()) {
                    Iterator<Entry.Option> it = ((CompletionSuggestion) suggestion).getOptions().iterator();
        super(in);  
        }
/*
        }
                if (in.readBoolean()) {  
                    this.hit = new SearchHit(in);
            protected void mergeInto(Suggest.Suggestion.Entry.Option otherOption) {
                option.setHit(hit);
            }  
                @SuppressWarnings("unchecked")
                return true;  
                this.doc = Lucene.readScoreDoc(in);
        }  
                    out.writeBoolean(false);
                }
    public void writeTo(StreamOutput out) throws IOException {
            );  
            final String name = leader.getName();
        if (toReduce.isEmpty()) {  
                final CharArraySet seenSurfaceForms = leader.skipDuplicates ? new CharArraySet(leader.getSize(), false) : null;
                final CompletionSuggestion suggestion = new CompletionSuggestion(leader.getName(), leader.getSize(), leader.skipDuplicates);
    private static class ShardOptions {
                for (Map.Entry<String, Set<String>> entry : contexts.entrySet()) {
import org.apache.lucene.search.ScoreDoc;
            @Override
import org.opensearch.core.common.io.stream.StreamInput;
                if (hit != null) {
                    while ((parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                stringBuilder.append(" context:[");
                        builder.startArray(entry.getKey());  
    protected Entry newEntry(StreamInput in) throws IOException {
                Map<String, Set<String>> contexts = new HashMap<>();
    }
                        contexts.add(in.readString());
                    ShardOptions top = pq.top();
            }  
        @Override
                // org.opensearch.search.suggest.completion.CompletionSuggestion.reduce()
    }
                PARSER.declareFloat(
            private final ScoreDoc doc;
                for (Map.Entry<String, Set<String>> entry : contexts.entrySet()) {  
                    }  
                this.contexts = Objects.requireNonNull(contexts, "context map cannot be null");  
                            builder.value(context.toString());
            return PARSER.apply(parser, null);  
                    ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
 * license agreements. See the NOTICE file distributed with
 *     "CONTEXT_NAME" : ARRAY,
        return getOptions().size() > 0;
        }
                while (pq.size() > 0) {
             * The use of a lambda expression instead of the method reference Entry::addOptions is a workaround for a JDK 14 compiler bug.
                SearchHit hit = null;  
 *
 * under the License.  
 *     "text" : STRING
    }
                    for (int j = 0; j < nContexts; j++) {  
        Entry.Option current;  
                OptionPriorityQueue pq = new OptionPriorityQueue(toReduce.size());
 * You may obtain a copy of the License at  
            @Override
            public void setShardIndex(int shardIndex) {
                if (hit != null) {  
        protected boolean lessThan(ShardOptions a, ShardOptions b) {
        this.skipDuplicates = skipDuplicates;
                    CompletionSuggestion.Entry.Option.CONTEXTS  
        /**  
                for (int i = 0; i < contextSize; i++) {
        }
         * @opensearch.internal  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See  
 * Licensed to Elasticsearch under one or more contributor  
        public static class Option extends Suggest.Suggestion.Entry.Option {
                    out.writeBoolean(true);
                        out.writeString(ctx.toString());
                    builder.endObject();  
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            public SearchHit getHit() {
                    out.writeString(entry.getKey());
            private SearchHit hit;
                return false;
 * }
            }  
/**  
                    if (top.advanceToNextOption()) {
/*  
import java.util.List;  
            PARSER.declareObjectArray((e, o) -> e.addOptions(o), (p, c) -> Option.fromXContent(p), new ParseField(OPTIONS));
    @Override  
                }
                    }
            private final Map<String, Set<String>> contexts;  
                this.contexts = new LinkedHashMap<>(contextSize);
 *     "score" : FLOAT  
                        if (options.size() >= size) {  
                    hit.writeTo(out);
    }
        boolean advanceToNextOption() {  
                if (contexts == null) {
    }  
            int compare = COMPARATOR.compare(a.current, b.current);  
            return null;
            ScoreDoc bDoc = b.current.getDoc();
 * <p>
     *
                throw new UnsupportedOperationException();
                super(in);
                        }  
            } else {  
    private boolean skipDuplicates;
                    }
    }
        super(name, size);
    }
public final class CompletionSuggestion extends Suggest.Suggestion<CompletionSuggestion.Entry> {
     * @param size The number of suggestions to return  
                    out.writeVInt(entry.getValue().size());  
                        pq.updateTop();
                int contextSize = in.readInt();  
            } else {
            if (aDoc.shardIndex == bDoc.shardIndex) {  
    private static final class OptionPriorityQueue extends PriorityQueue<ShardOptions> {
                    (map, value) -> map.put(Suggestion.Entry.Option.SCORE.getPreferredName(), value),  
        return new Entry(in);  
        public Entry(StreamInput in) throws IOException {
import java.util.Objects;
                return builder;
 * specific language governing permissions and limitations
    public CompletionSuggestion reduce(List<Suggest.Suggestion<Entry>> toReduce) {
            }  
import org.opensearch.core.xcontent.XContentBuilder;  
                this.doc = new ScoreDoc(docID, score);
                    Set<String> values = new HashSet<>();
            if (compare != 0) {
         *
                current = optionsIterator.next();
                    Suggestion.Entry.Option.TEXT  
                return contexts;
             */
            }
 * Suggestion response for {@link CompletionSuggester} results
                return doc;
                stringBuilder.append(getScore());
     * @param name The name for the suggestions
        final Iterator<Entry.Option> optionsIterator;
     */
        OptionPriorityQueue(int maxSize) {  
 * {
        }
                option.setShardIndex(shardIndex);  
                this.doc.shardIndex = shardIndex;  
                        ensureExpectedToken(XContentParser.Token.VALUE_STRING, parser.currentToken(), parser);  
        if (entries.isEmpty() == false) {
    @Override  
        }
                return leader;
import java.io.IOException;  
            if (toReduce.size() == 1) {
                return contexts;  
        super.writeTo(out);
import org.opensearch.core.xcontent.ObjectParser;
    public CompletionSuggestion(String name, int size, boolean skipDuplicates) {  
                stringBuilder.append(" score:");  
                final Entry entry = new Entry(leaderEntry.getText(), leaderEntry.getOffset(), leaderEntry.getLength());
                    (map, value) -> map.put(Suggestion.Entry.Option.TEXT.getPreferredName(), value),
import org.opensearch.search.SearchHit;
            return Collections.emptyList();
                PARSER.declareString(
                // combine suggestion entries from participating shards on the coordinating node
import org.opensearch.core.common.io.stream.StreamOutput;  
 * the Apache License, Version 2.0 (the "License"); you may
                    stringBuilder.append(entry.getValue());
     * @opensearch.internal  
    public void setShardIndex(int shardIndex) {  
            }
import org.opensearch.core.ParseField;
 *  
                        // options exhausted for this shard
 *     ..  
            if (optionsIterator.hasNext()) {
import static org.opensearch.search.suggest.Suggest.COMPARATOR;
                    hit.toInnerXContent(builder, params);
    }
     * Creates a completion suggestion given its name, size and whether it should skip duplicates
                    }  
            final Entry leaderEntry = leader.getEntries().get(0);
import org.opensearch.core.common.text.Text;
        }  
 *
        skipDuplicates = in.readBoolean();
                    if (it.hasNext()) {
                    String key = parser.currentName();
 */  
                return suggestion;
            }  
                Map<String, Object> values = PARSER.apply(parser, null);  
 * not use this file except in compliance with the License.
    public List<Entry.Option> getOptions() {  
                super.writeTo(out);
                HashMap::new
                );
                // Completion suggestions are reduced by  
 */
     * Entry in the completion suggester
            this.current = optionsIterator.next();
        }
            public void writeTo(StreamOutput out) throws IOException {  
                        values.add(parser.text());
            private static Map<String, Set<String>> parseContexts(XContentParser parser) throws IOException {
            }
/*
        parseEntries(parser, suggestion, CompletionSuggestion.Entry::fromXContent);
            }  
     */
            static {
import java.util.HashSet;  
                    contexts = Collections.emptyMap();  
     * @param skipDuplicates Whether duplicate suggestions should be filtered out
        return Objects.hash(super.hashCode(), skipDuplicates);
import org.opensearch.search.suggest.Suggest;  
    }
                return compare < 0;
import java.util.Iterator;
    public int getWriteableType() {  
import java.util.Set;  
    @Override
                // using a priority queue  
        } else {
            }  
    }
    public static CompletionSuggestion fromXContent(XContentParser parser, String name) throws IOException {
                }
                    builder.startObject(CONTEXTS.getPreferredName());
            }
            declareCommonFields(PARSER);  
    /**  
                );
    }  
                }
                super(text, score);
                    ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.nextToken(), parser);  
                }
                SearchHit.declareInnerHitsParseFields(PARSER);  
    }
            int size = leader.getSize();  
        } else {
            @Override
                for (Suggest.Suggestion<Entry> suggestion : toReduce) {
                    }  
import org.opensearch.common.lucene.Lucene;  
            assert this.current.getDoc().shardIndex != -1 : "shardIndex is not set";  
    public boolean equals(Object other) {
import java.util.LinkedHashMap;
                    for (Map.Entry<String, Set<String>> entry : contexts.entrySet()) {
                        options.add(current);
                    Set<String> contexts = new HashSet<>(nContexts);
        private static final ObjectParser<Entry, Void> PARSER = new ObjectParser<>("CompletionSuggestionEntryParser", true, Entry::new);
            public static Option fromXContent(XContentParser parser) {
            }
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
            return new Option(in);
            return aDoc.shardIndex < bDoc.shardIndex;  
import org.apache.lucene.analysis.CharArraySet;  
     * @return the result options for the suggestion
 *
 */
                CompletionSuggestion.Entry.Option option = new CompletionSuggestion.Entry.Option(-1, text, score, contexts);  
    /**  
                }
                        pq.add(new ShardOptions(it));  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
 * this file be licensed under the Apache-2.0 license or a
            ScoreDoc aDoc = a.current.getDoc();
    @Override
            public Map<String, Set<String>> getContexts() {
    /**  
        private ShardOptions(Iterator<Entry.Option> optionsIterator) {
                if (contexts.size() > 0) {  
    public static final int TYPE = 4;
            private static final ObjectParser<Map<String, Object>, Void> PARSER = new ObjectParser<>(
                return option;
    public String getWriteableName() {
                    } else {  
    }
            super(in);
                Map<String, Set<String>> contexts = (Map<String, Set<String>>) values.get(
                }
        static {
                    }
            super(text, offset, length);
import org.apache.lucene.util.PriorityQueue;
             * The bug is: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8242214  
                stringBuilder.append("text:");
     */
        return CompletionSuggestionBuilder.SUGGESTION_NAME;  
            return entries.get(0).getOptions();  
    /**  
import java.util.HashMap;
                return stringBuilder.toString();
}
 * GitHub history for details.
            public void setHit(SearchHit hit) {  
        }  
            }
package org.opensearch.search.suggest.completion;
 *    http://www.apache.org/licenses/LICENSE-2.0
                        }
 * <p>  
    @Deprecated
                } else {  
    public int hashCode() {
                    }
                    contexts.put(key, values);  
                StringBuilder stringBuilder = new StringBuilder();  
         */
