import org.opensearch.core.common.text.Text;
            declareCommonFields(PARSER);
        @Override
            }
        @Override
        }
                this.options.add(option);
        @Override
public class PhraseSuggestion extends Suggest.Suggestion<PhraseSuggestion.Entry> {
 * GitHub history for details.
        public static class Option extends Suggestion.Entry.Option {
        return suggestion;
 * this work for additional information regarding copyright
 *
                    Text highlightedText = highlighted == null ? null : new Text(highlighted);
        public boolean equals(Object other) {
    public static class Entry extends Suggestion.Entry<PhraseSuggestion.Entry.Option> {
            super(in);
import org.opensearch.core.common.io.stream.StreamInput;
                    Text text = new Text((String) args[0]);
    }
            super.writeTo(out);
        /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                PARSER.declareFloat(constructorArg(), SCORE);
    @Override
 */
        public static Entry fromXContent(XContentParser parser) {
        return PhraseSuggestionBuilder.SUGGESTION_NAME;
             * The use of a lambda expression instead of the method reference Entry::addOptions is a workaround for a JDK 14 compiler bug.
 * KIND, either express or implied.  See the License for the
    public static final int TYPE = 3;
                super(text, highlighted, score, collateMatch);
        return new Entry(in);
            private static final ConstructingObjectParser<Option, Void> PARSER = new ConstructingObjectParser<>(
         */
         * @opensearch.internal
        }
    }
/**
        /**
        parseEntries(parser, suggestion, PhraseSuggestion.Entry::fromXContent);
            }
}
import org.opensearch.core.common.io.stream.StreamOutput;
     * Entry in the phrase suggester
/*
        @Override
 * Suggestion entry returned from the {@link PhraseSuggester}.
            return cutoffScore;
        super(name, size);
    protected Entry newEntry(StreamInput in) throws IOException {
            static {
    public PhraseSuggestion(StreamInput in) throws IOException {
    }
            }
    public String getWriteableName() {
            return Objects.hash(super.hashCode(), cutoffScore);
 */
                }
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
                true,
            return super.equals(other) && Objects.equals(cutoffScore, ((Entry) other).cutoffScore);
            public Option(Text text, Text highlighted, float score, Boolean collateMatch) {
            }
        }
package org.opensearch.search.suggest.phrase;
        }
 * Licensed to Elasticsearch under one or more contributor
 *
    /**
            }
                    return new Option(text, highlightedText, score, collateMatch);
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        public Entry(Text text, int offset, int length) {
 * The OpenSearch Contributors require contributions made to
            }
        public int hashCode() {
import org.opensearch.core.xcontent.XContentParser;
                    float score = (Float) args[1];
 * ownership. Elasticsearch licenses this file to you under
            this.cutoffScore = cutoffScore;
import org.opensearch.search.suggest.Suggest.Suggestion;
 * software distributed under the License is distributed on an
        }
 * SPDX-License-Identifier: Apache-2.0
                PARSER.declareString(constructorArg(), TEXT);
                return;
            super(text, offset, length);
            super(text, offset, length);
            );
/*
            if (option.getScore() > this.cutoffScore) {
import org.opensearch.core.xcontent.ConstructingObjectParser;
            super.merge(other);
            public Option(StreamInput in) throws IOException {
    public static PhraseSuggestion fromXContent(XContentParser parser, String name) throws IOException {
        public Entry(Text text, int offset, int length, double cutoffScore) {
 * Unless required by applicable law or agreed to in writing,
            // by assuming they had a low cutoff score rather than a high one as that is the more common scenario
             */
 *
         *
     *
                super(text, highlighted, score);
     * @opensearch.internal
        PhraseSuggestion suggestion = new PhraseSuggestion(name, -1);
        public void addOption(Option option) {
        }
         */
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
import java.io.IOException;
                PARSER.declareString(optionalConstructorArg(), HIGHLIGHTED);
        protected void merge(Suggestion.Entry<Option> other) {
import org.opensearch.search.suggest.Suggest;
        }
                    Boolean collateMatch = (Boolean) args[3];
import org.opensearch.core.xcontent.ObjectParser;
        }
 */
    }
        Entry() {}
        return TYPE;
        protected Option newOption(StreamInput in) throws IOException {
/*
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        }
        public double getCutoffScore() {
            this.cutoffScore = Math.max(this.cutoffScore, otherSuggestionEntry.cutoffScore);
    }
            }
    }
                    String highlighted = (String) args[2];
        private static final ObjectParser<Entry, Void> PARSER = new ObjectParser<>("PhraseSuggestionEntryParser", true, Entry::new);
                PARSER.declareBoolean(optionalConstructorArg(), COLLATE_MATCH);
        protected double cutoffScore = Double.MIN_VALUE;
import org.opensearch.core.ParseField;
        super(in);
    @Override
            public static Option fromXContent(XContentParser parser) {
 * compatible open source license.
import java.util.Objects;
            PARSER.declareObjectArray((e, o) -> e.addOptions(o), (p, c) -> Option.fromXContent(p), new ParseField(OPTIONS));
    }
            return new Option(in);
    @Deprecated
            // and the simplest one for us to implement.
            cutoffScore = in.readDouble();
        static {
 *
        }
        }
         * @return cutoff score for suggestions.  input term score * confidence for phrase suggest, 0 otherwise
            public Option(Text text, Text highlighted, float score) {
         * Options for phrase suggestion
 * Modifications Copyright OpenSearch Contributors. See
            // objects being merged with PhraseSuggestion.Entry objects. We merge Suggestion.Entry objects
        @Override
            return PARSER.apply(parser, null);
        }
    public PhraseSuggestion(String name, int size) {
        }
        public void writeTo(StreamOutput out) throws IOException {
    public int getWriteableType() {
            /*
 * under the License.
             * The bug is: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8242214
            // If the cluster contains both pre 0.90.4 and post 0.90.4 nodes then we'll see Suggestion.Entry
            out.writeDouble(cutoffScore);
        public Entry(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
            if (!(other instanceof PhraseSuggestion.Entry otherSuggestionEntry)) {
     */
 * not use this file except in compliance with the License.
                return PARSER.apply(parser, null);
 */
                super(in);
                "PhraseOptionParser",
        @Override
 * You may obtain a copy of the License at
                args -> {
