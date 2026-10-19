             * The bug is: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8242214  
import java.util.Objects;
            protected void mergeInto(Suggestion.Entry.Option otherOption) {
import org.opensearch.core.common.io.stream.StreamInput;
                out.writeVInt(freq);
                return builder;  
            cmp = Float.compare(second.getScore(), first.getScore());
import org.opensearch.search.suggest.Suggest.Suggestion;
    @Deprecated  
                freq += ((Option) otherOption).freq;  
 */  
            static {
/*
    public int hashCode() {
        this.sort = sort;
        private static final ObjectParser<Entry, Void> PARSER = new ObjectParser<>("TermSuggestionEntryParser", true, Entry::new);
     * @opensearch.internal  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @opensearch.internal
        }
    public void setSort(SortBy sort) {
    public TermSuggestion(String name, int size, SortBy sort) {
            }
            public Option(Text text, int freq, float score) {
    }
     * Represents a part from the suggest text with suggested options.
            }  
    public static class Frequency implements Comparator<Suggestion.Entry.Option> {
            // second criteria (if first criteria is equal): the distance  
            PARSER.declareObjectArray((e, o) -> e.addOptions(o), (p, c) -> Option.fromXContent(p), new ParseField(OPTIONS));
    public void writeTo(StreamOutput out) throws IOException {
    }  
        super.writeTo(out);
 * Unless required by applicable law or agreed to in writing,
                super(in);
    }  
    }
            public int getFreq() {
import org.opensearch.search.suggest.SortBy;  
}
     *  
 *
                return cmp;  
            public void writeTo(StreamOutput out) throws IOException {  
 * compatible open source license.
/*  
            if (cmp != 0) {  
            @Override
                freq = in.readVInt();  
            public void setFreq(int freq) {  
 * You may obtain a copy of the License at  
            declareCommonFields(PARSER);  
/*
            }
import java.util.Comparator;  
                return freq;
import org.opensearch.core.xcontent.XContentParser;
                builder.field(FREQ.getPreferredName(), freq);
import org.opensearch.core.xcontent.XContentBuilder;
    /**  
import org.opensearch.core.ParseField;
            // first criteria: the popularity  
 *
            return FREQUENCY.compare(first, second);  
    public static final Comparator<Suggestion.Entry.Option> SCORE = new Score();  
            if (cmp != 0) {
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object other) {  
     */
                return FREQUENCY;  
    }
                return cmp;  
        }
    }
                this.freq = freq;
             */  
        super(name, size);  
                super(text, score);  
 */  
            }
import org.opensearch.OpenSearchException;  
            /**
    public static class Score implements Comparator<Suggestion.Entry.Option> {  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
     * Same behaviour as comparators in suggest module, but for SuggestedWord
        parseEntries(parser, suggestion, TermSuggestion.Entry::fromXContent);
        return TermSuggestionBuilder.SUGGESTION_NAME;
            int cmp = Float.compare(second.getScore(), first.getScore());
    protected Entry newEntry(StreamInput in) throws IOException {
        public Entry(Text text, int offset, int length) {
                PARSER.declareString(constructorArg(), Suggestion.Entry.Option.TEXT);  
    public String getWriteableName() {
        }
            private static final ConstructingObjectParser<Option, Void> PARSER = new ConstructingObjectParser<>(  
        /**  
 * not use this file except in compliance with the License.
         * Contains the suggested text with its document frequency and score.
        return TYPE;
                PARSER.declareInt(constructorArg(), FREQ);
                    int freq = (Integer) args[1];
             */
                super.mergeInto(otherOption);
            public static final ParseField FREQ = new ParseField("freq");
        @Override  
import org.opensearch.core.common.text.Text;
            int cmp = ((TermSuggestion.Entry.Option) second).getFreq() - ((TermSuggestion.Entry.Option) first).getFreq();
    }
        public static class Option extends Suggest.Suggestion.Entry.Option {
                return SCORE;
         */
     *
        @Override
            );  
import org.opensearch.core.xcontent.ObjectParser;  
    public int getWriteableType() {  
public class TermSuggestion extends Suggestion<TermSuggestion.Entry> {
 *  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * software distributed under the License is distributed on an
            case SCORE:  
 * @opensearch.internal
                return PARSER.apply(parser, null);  
     */
         * @opensearch.internal  
        }  
        public int compare(Suggestion.Entry.Option first, Suggestion.Entry.Option second) {
        // the "size" parameter and the SortBy for TermSuggestion cannot be parsed from the response, use default values  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return suggestion;  
                }
        return super.equals(other) && Objects.equals(sort, ((TermSuggestion) other).sort);
        protected Option newOption(StreamInput in) throws IOException {  
     * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                    Text text = new Text((String) args[0]);
            @Override  
        return Objects.hash(super.hashCode(), sort);  
            }
            super(text, offset, length);
        static {
            if (cmp != 0) {
        }
     * Highest score first, then highest freq first, then lowest term first
 */
 * GitHub history for details.
    public SortBy getSort() {
                args -> {  
 * under the License.  
            return PARSER.apply(parser, null);  
 * SPDX-License-Identifier: Apache-2.0
            // third criteria: term text  
        return new Entry(in);
        super(in);
            super(in);
        @Override
    @Override
        public int compare(Suggestion.Entry.Option first, Suggestion.Entry.Option second) {  
     */  
            }  
 * Licensed to Elasticsearch under one or more contributor  
        TermSuggestion suggestion = new TermSuggestion(name, -1, SortBy.SCORE);
 * The suggestion responses corresponding with the suggestions in the request.  
                    float score = (Float) args[2];  
    @Override  
 *
     * Same behaviour as comparators in suggest module, but for SuggestedWord
    public static final int TYPE = 1;
     * Highest freq first, then highest score first, then lowest term first  
    @Override  
    public TermSuggestion(StreamInput in) throws IOException {
            // first criteria: the distance
    @Override
        }  
    }
    protected Comparator<Option> sortComparator() {
        }
    }  
import org.opensearch.search.suggest.Suggest.Suggestion.Entry.Option;  
            @Override
import java.io.IOException;
    /**  
            case FREQUENCY:
        return sort;  
         *
        }  
    @Override
            private int freq;  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
            return first.getText().compareTo(second.getText());
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
        }  
import org.opensearch.core.xcontent.ConstructingObjectParser;
        sort.writeTo(out);  
            }
 * specific language governing permissions and limitations
            return new Option(in);
            public static Option fromXContent(XContentParser parser) {
    /**
    }  
                this.freq = freq;
                builder = super.toXContent(builder, params);
            }
                "TermSuggestionOptionParser",
        public static Entry fromXContent(XContentParser parser) {
        public Entry(StreamInput in) throws IOException {
    }
            /*
 * this file be licensed under the Apache-2.0 license or a
                    return new Option(text, freq, score);
             * The use of a lambda expression instead of the method reference Entry::addOptions is a workaround for a JDK 14 compiler bug.
        this.sort = sort;
            public Option(StreamInput in) throws IOException {
package org.opensearch.search.suggest.term;
                throw new OpenSearchException("Could not resolve comparator for sort key: [" + sort + "]");
    }
        switch (sort) {
        private Entry() {}
             * @return How often this suggested text appears in the index.
            }  
            default:
            }
        sort = SortBy.readFromStream(in);  
 * Modifications Copyright OpenSearch Contributors. See  
                PARSER.declareFloat(constructorArg(), Suggestion.Entry.Option.SCORE);
    private SortBy sort;  
 */
                return cmp;
            }
    }
                true,
    public static TermSuggestion fromXContent(XContentParser parser, String name) throws IOException {
                super.writeTo(out);
/**
    public static class Entry extends Suggest.Suggestion.Entry<TermSuggestion.Entry.Option> {
 * ownership. Elasticsearch licenses this file to you under  
     *
import org.opensearch.search.suggest.Suggest;
            }
    public static final Comparator<Suggestion.Entry.Option> FREQUENCY = new Frequency();
    @Override  
    }  
