         */
                    float score = (Float) args[1];
         */  
            super(text, offset, length);  
 * this file be licensed under the Apache-2.0 license or a
            }  
         * @opensearch.internal
            if (!(other instanceof PhraseSuggestion.Entry otherSuggestionEntry)) {
        public boolean equals(Object other) {
    @Override  
            this.cutoffScore = cutoffScore;
        @Override
                super(text, highlighted, score);
        static {
    @Override
            }
public class PhraseSuggestion extends Suggest.Suggestion<PhraseSuggestion.Entry> {
 * not use this file except in compliance with the License.
            declareCommonFields(PARSER);
        }
                PARSER.declareFloat(constructorArg(), SCORE);  
        @Override
                "PhraseOptionParser",
            this.cutoffScore = Math.max(this.cutoffScore, otherSuggestionEntry.cutoffScore);
        public Entry(Text text, int offset, int length, double cutoffScore) {
        public void writeTo(StreamOutput out) throws IOException {
        }  
                    return new Option(text, highlightedText, score, collateMatch);  
    public PhraseSuggestion(StreamInput in) throws IOException {
        return PhraseSuggestionBuilder.SUGGESTION_NAME;
        @Override  
         * @return cutoff score for suggestions.  input term score * confidence for phrase suggest, 0 otherwise
import java.util.Objects;  
        }
        return suggestion;
                true,
 * software distributed under the License is distributed on an
            public Option(Text text, Text highlighted, float score) {
        }
                    Text text = new Text((String) args[0]);
    }  
 *  
            // by assuming they had a low cutoff score rather than a high one as that is the more common scenario  
            return super.equals(other) && Objects.equals(cutoffScore, ((Entry) other).cutoffScore);  
            public Option(Text text, Text highlighted, float score, Boolean collateMatch) {  
    public static PhraseSuggestion fromXContent(XContentParser parser, String name) throws IOException {
        public void addOption(Option option) {  
            PARSER.declareObjectArray((e, o) -> e.addOptions(o), (p, c) -> Option.fromXContent(p), new ParseField(OPTIONS));
    }  
        @Override
 * Unless required by applicable law or agreed to in writing,
     */  
}
                super(text, highlighted, score, collateMatch);
 *
        @Override
            public Option(StreamInput in) throws IOException {
                }
 * this work for additional information regarding copyright
        return new Entry(in);
            /*  
 * under the License.  
import org.opensearch.core.xcontent.XContentParser;
    }
    protected Entry newEntry(StreamInput in) throws IOException {
         *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
        }
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
                    Boolean collateMatch = (Boolean) args[3];
                PARSER.declareString(constructorArg(), TEXT);
    }  
                super(in);  
import org.opensearch.core.xcontent.ConstructingObjectParser;
            );
import org.opensearch.search.suggest.Suggest;
import java.io.IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
        protected double cutoffScore = Double.MIN_VALUE;  
                args -> {  
        protected void merge(Suggestion.Entry<Option> other) {
            out.writeDouble(cutoffScore);
                PARSER.declareString(optionalConstructorArg(), HIGHLIGHTED);
             * The bug is: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8242214
            }
             * The use of a lambda expression instead of the method reference Entry::addOptions is a workaround for a JDK 14 compiler bug.
 */
 * compatible open source license.
                    String highlighted = (String) args[2];  
            return cutoffScore;
/**
            public static Option fromXContent(XContentParser parser) {
            return new Option(in);
            return Objects.hash(super.hashCode(), cutoffScore);
    }
     * Entry in the phrase suggester  
                return;  
        }  
         * Options for phrase suggestion  
        Entry() {}
        /**  
        }
 * @opensearch.internal
            }  
            if (option.getScore() > this.cutoffScore) {
            // and the simplest one for us to implement.
import org.opensearch.search.suggest.Suggest.Suggestion;  
    @Override
     *
        }
/*  
 *
/*
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
 * SPDX-License-Identifier: Apache-2.0
                this.options.add(option);
             */  
            cutoffScore = in.readDouble();  
        PhraseSuggestion suggestion = new PhraseSuggestion(name, -1);  
                    Text highlightedText = highlighted == null ? null : new Text(highlighted);
    public PhraseSuggestion(String name, int size) {  
    public String getWriteableName() {  
            // If the cluster contains both pre 0.90.4 and post 0.90.4 nodes then we'll see Suggestion.Entry
            super.writeTo(out);  
        }  
        public Entry(Text text, int offset, int length) {
package org.opensearch.search.suggest.phrase;
 * Licensed to Elasticsearch under one or more contributor  
        super(in);
    }
        super(name, size);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.ObjectParser;  
 * GitHub history for details.
    }  
        public int hashCode() {
import org.opensearch.core.common.io.stream.StreamInput;
 * KIND, either express or implied.  See the License for the
            }
import org.opensearch.core.common.io.stream.StreamOutput;  
        public Entry(StreamInput in) throws IOException {
 */  
 * Modifications Copyright OpenSearch Contributors. See
            }
        public double getCutoffScore() {  
    public int getWriteableType() {
            super(in);
        parseEntries(parser, suggestion, PhraseSuggestion.Entry::fromXContent);
        protected Option newOption(StreamInput in) throws IOException {  
        }  
        private static final ObjectParser<Entry, Void> PARSER = new ObjectParser<>("PhraseSuggestionEntryParser", true, Entry::new);  
            static {
            return PARSER.apply(parser, null);
            private static final ConstructingObjectParser<Option, Void> PARSER = new ConstructingObjectParser<>(  
            super.merge(other);  
        /**
 */  
 * specific language governing permissions and limitations
            super(text, offset, length);
        @Override
    @Deprecated  
        public static Entry fromXContent(XContentParser parser) {
import org.opensearch.core.ParseField;
        return TYPE;  
     * @opensearch.internal
 * license agreements. See the NOTICE file distributed with
    public static class Entry extends Suggestion.Entry<PhraseSuggestion.Entry.Option> {
 *
 * The OpenSearch Contributors require contributions made to  
/*  
                return PARSER.apply(parser, null);  
        }
 * Suggestion entry returned from the {@link PhraseSuggester}.  
 */  
import org.opensearch.core.common.text.Text;
    public static final int TYPE = 3;
            }  
 * ownership. Elasticsearch licenses this file to you under  
                PARSER.declareBoolean(optionalConstructorArg(), COLLATE_MATCH);
        }
 * You may obtain a copy of the License at  
        }
            // objects being merged with PhraseSuggestion.Entry objects. We merge Suggestion.Entry objects
        public static class Option extends Suggestion.Entry.Option {
