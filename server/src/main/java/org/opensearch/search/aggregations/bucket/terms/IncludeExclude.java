        Automaton a;
        return returnSet;
     */
                    if (startOrd < endOrd) {  
        if (parser.currentToken() != XContentParser.Token.START_ARRAY) {
         */  
        SortedSet<BytesRef> returnSet = null;  
    }
                    startOrd = -1 - startOrd;  
        } else {
 * You may obtain a copy of the License at  
    /**
/**  
    public static IncludeExclude parseExclude(XContentParser parser) throws IOException {  
                }
            return null;
                    alternatives.add(regExp.exp2);
    }
    /**  
        String excludeMethod = exclude.isRegexBased() ? "regex" : "set";
        @Override
    private final int incNumPartitions;
            && Objects.equals(incNumPartitions, other.incNumPartitions);
                    continue;
                result = new TreeSet<>();
        if (token == XContentParser.Token.VALUE_STRING) {
    private static void validateRegExpStringLength(String source, int maxRegexLength) {
    }
                    }
        XContentParser.Token token = parser.currentToken();
                acceptedGlobalOrdinals.set(globalTermsEnum.ord());  
    private final String include, exclude;
import org.opensearch.index.IndexSettings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
                process(globalOrdinals, accept.length(), includePrefixes, accept::set);  
            return Math.floorMod(StringHelper.murmurhash3_x86_32(value, HASH_PARTITIONING_SEED), incNumPartitions) == incZeroBasedPartition;  
        this.incNumPartitions = 0;  
        }
        if (maxRegexLength > 0 && source.length() > maxRegexLength) {  
        }
     *
 * @opensearch.internal
    private static final int HASH_PARTITIONING_SEED = 31;
    public boolean isRegexBased() {
     * @param excludeValues   The terms to be excluded  
import java.io.IOException;
    }  
        public LongBitSet acceptedGlobalOrdinals(SortedSetDocValues globalOrdinals) throws IOException {  
        @Override
                        || !Arrays.equals(
            }
            excludeValues = null;
    }
        } else if (includeValues != null) {
        return builder;
     * @opensearch.internal
import java.util.SortedSet;  
     *
                out.writeVInt(includeValues.size());  
                return null;  
    class PartitionedOrdinalsFilter extends OrdinalsFilter {
            while (term != null) {
            }
    }
    }
                excludeValues.add(in.readBytesRef());
     * See https://github.com/opensearch-project/OpenSearch/issues/2858  
            throw new OpenSearchParseException("Missing start of array in include/exclude clause");  
            if (!parser.currentToken().isValue()) {  
        SortedSet<BytesRef> includeSet = extractPrefixes(include, maxRegexLength);
    private static class DocValuesTerms extends Terms {
        if (endUserFormattedValues != null) {
            for (BytesRef val : includeValues) {
        }  
        }
            if (hasExcludes) {
        }  
                    // Make sure that the term at startOrd starts with prefix
        if (includeValues != null) {  
        SetBackedLongFilter result = new SetBackedLongFilter(numValids, numInvalids);
        SortedSet<BytesRef> returnSet = null;
                result.addAccept(format.parseLong(val.utf8ToString(), false, null));
                        continue;
        }
                            startTerm.offset,
        private static void process(SortedSetDocValues globalOrdinals, long length, SortedSet<BytesRef> prefixes, LongBiConsumer consumer)  
    /**  
    }
            return Collections.emptySortedSet();
                for (String prefix : prefixes) {  
        this.excludeValues = null;
    public IncludeExclude(StreamInput in) throws IOException {  
            excludeValues = new TreeSet<>();
 * Unless required by applicable law or agreed to in writing,
        private void addAccept(long val) {  
    public IncludeExclude(long[] includeValues, long[] excludeValues) {
                    if (startOrd >= length) {
        }
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.TermsEnum;
            }
                if (next == null) {
            builder.startArray(EXCLUDE_FIELD.getPreferredName());
    }  
        public boolean accept(long value) {  
        return Objects.equals(include, other.include)  
        private final SortedSet<BytesRef> includeValues;
        } else {  
        }
                    }
    public boolean equals(Object obj) {
import java.util.Set;
        }  
        SetBackedLongFilter result = new SetBackedLongFilter(numValids, numInvalids);
                    }
        } else if (token == XContentParser.Token.START_ARRAY) {
    // TODO: move all aggs to the same package so that this stuff could be pkg-private
    // can disagree on which terms hash to the required partition.
        }
            throws IOException {
        this.incZeroBasedPartition = 0;  
                    + "the allowed maximum of ["
        }  
        }
                if (startOrd < 0) {
        this.exclude = null;
import org.opensearch.core.xcontent.XContentParser;  
                List<RegExp> alternatives = new ArrayList<>();
            return false;
        if (isRegexBased()) {  
 * under the License.  
     */
                }  
                throw new IllegalArgumentException(
                builder.value(value.utf8ToString());
    }
                );
        }  
        public TermsEnum iterator() throws IOException {
            throw new IllegalArgumentException(
                            prefix.bytes,  
        }  
                    // Check bounds before calling lookupOrd to avoid IndexOutOfBoundsException
                }
        }
            Terms globalTerms = new DocValuesTerms(globalOrdinals);
    public static final ParseField NUM_PARTITIONS_FIELD = new ParseField("num_partitions");
            returnSet = new TreeSet<>();  
            return acceptedGlobalOrdinals;
import org.apache.lucene.util.automaton.Automaton;
        }
                    + "This maximum can be set by changing the ["
     */  
                PrefixBackedOrdinalsFilter prefixBackedOrdinalsFilter = tryCreatePrefixOrdinalsFilter(maxRegexLength);  
import java.util.Objects;
        }
                }  
            case REGEXP_CHAR:
    }  
                    + "]. "
            if (!includePrefixes.isEmpty()) {
     */  
                next.bytes[pos]++;  
            builder.startArray(INCLUDE_FIELD.getPreferredName());
 * Defines the include/exclude regular expression filtering for string terms aggregation. In this filtering logic,
        } else {  
    public IncludeExclude(SortedSet<BytesRef> includeValues, SortedSet<BytesRef> excludeValues) {
                double dval = Double.parseDouble(val.utf8ToString());
 *
            for (BytesRef term = globalTermsEnum.next(); term != null; term = globalTermsEnum.next()) {
            void accept(long a, long b);  
            set.add(new BytesRef(parser.text()));  
        this.includeValues = includeValues;
     */  
        RegExp regExp = new RegExp(pattern);
    /**
                return List.of(regExp.s);
     */  
            return a;
            builder.field(INCLUDE_FIELD.getPreferredName(), include);  
        public boolean accept(BytesRef value) {  
                "The length of regex ["
        include = null;
        if (obj == null) {
        }
                acceptedGlobalOrdinals.set(0, acceptedGlobalOrdinals.length());
        }  
            return new IncludeExclude(new TreeSet<>(parseArrayToSet(parser)), null);
        } else if (isPartitionBased()) {
            throw new IllegalArgumentException("Unrecognized token for an include [" + token + "]");
     */
        }  
                }  
     *
                List<String> output = new ArrayList<>();  
            return -1;
        }
                    if (ord >= 0) {  
        final Set<BytesRef> set = new HashSet<>();
            out.writeOptionalString(include);  
            LongBitSet acceptedGlobalOrdinals = new LongBitSet(globalOrdinals.getValueCount());  
    }
                for (BytesRef formattedVal : endUserFormattedValues) {
     * See https://github.com/opensearch-project/OpenSearch/issues/2858
            for (BytesRef val : excludeValues) {
 * Licensed to Elasticsearch under one or more contributor  
        if (exclude == null) {
        this.excludeValues = excludeValues;
            this.includePrefixes = includePrefixes;  
            }
            for (int i = 0; i < size; i++) {  
            int size = in.readVInt();
        private static BytesRef nextBytesRef(BytesRef bytesRef) {
            );  
     */
    static class AutomatonBackedStringFilter extends StringFilter {  
        }  
            for (String value : values) {
 * the Apache License, Version 2.0 (the "License"); you may
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private Set<Long> valids;
            if (numInvalids > 0) {
            // TODO: specialize based on compiled.type: for ALL and prefixes (sinkState >= 0 ) we can avoid i/o and just set bits.  
                    }
            if (excludeValues != null) {  
        if (regExp.kind == RegExp.Kind.REGEXP_CONCATENATION && regExp.exp2.kind == RegExp.Kind.REGEXP_REPEAT) {  
     * @opensearch.internal
 * not use this file except in compliance with the License.
            } else if (acceptedGlobalOrdinals.length() > 0) {
                }
                pos--;  
    class PartitionedStringFilter extends StringFilter {  
        public long size() throws IOException {
     */
            return new PartitionedOrdinalsFilter();
                result.addReject(NumericUtils.doubleToSortableLong(dval));  
            returnSet = new TreeSet<>();
    @Override
            return Operations.determinize(a, Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
    public static final ParseField PARTITION_FIELD = new ParseField("partition");  
                    out.writeBytesRef(value);
                            prefix.offset,
            }
        return new PrefixBackedOrdinalsFilter(includeSet, excludeSet);  
        }
        if (excludeValues != null) {
    private final int incZeroBasedPartition;  
                for (BytesRef value : excludeValues) {  
            }  
    public static IncludeExclude merge(IncludeExclude include, IncludeExclude exclude) {  
/*
}
            this.compiled = new CompiledAutomaton(automaton);  
        }  
                        stringBuilder.append(prefix).append(suffix);  
        }
                while (regExp.exp1.kind == RegExp.Kind.REGEXP_UNION) {  
            }  
            }
     * @opensearch.internal
         *
    /**
        }  
                    regExp = regExp.exp1;
     * @param include   The string or regular expression pattern for the terms to be included
                    for (String suffix : suffixes) {
            builder.field(NUM_PARTITIONS_FIELD.getPreferredName(), incNumPartitions);
            out.writeOptionalString(exclude);
            }  
            return false;  
            }
        private PrefixBackedOrdinalsFilter(SortedSet<BytesRef> includePrefixes, SortedSet<BytesRef> excludePrefixes) {
            for (long value : values) {
        }  
            }
            for (BytesRef val : excludeValues) {  
        }
                    BytesRef startTerm = globalOrdinals.lookupOrd(startOrd);  
     */
 * this file be licensed under the Apache-2.0 license or a
            return ((valids == null) || (valids.contains(value))) && ((invalids == null) || (!invalids.contains(value)));  
                        endOrd = -1 - endOrd;
        if (includeValues != null) {  
import org.apache.lucene.util.automaton.ByteRunAutomaton;  
        out.writeBoolean(regexBased);
            LongBitSet acceptedGlobalOrdinals = new LongBitSet(globalOrdinals.getValueCount());  
            this.invalids = excludeValues;
            return -1;
        /**
        } else if (includeValues != null) {  
        }
            return new IncludeExclude(null, parser.text());  
import org.opensearch.core.xcontent.XContentBuilder;
                            prefix.offset + prefix.length
     * @opensearch.internal
            }
    public abstract static class Filter {}
                result.addAccept(NumericUtils.doubleToSortableLong(dval));  
            a = Operations.minus(a, Automata.makeStringUnion(excludeValues), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
                    numPartitions = parser.intValue();
            BytesRef next = BytesRef.deepCopyOf(bytesRef);
            return next;
            process(globalOrdinals, accept.length(), excludePrefixes, accept::clear);
            }
import org.apache.lucene.util.automaton.Automata;
     */  
    /**
        }  
     *  
 * Modifications Copyright OpenSearch Contributors. See  
     */  
     * Wrapper method that imposes a default regex limit.
    static class TermListBackedOrdinalsFilter extends OrdinalsFilter {  
            return new IncludeExclude(null, new TreeSet<>(parseArrayToSet(parser)));
     *
        }
                accept.set(0, accept.length());  
        this.exclude = exclude;  
    @Override
    public IncludeExclude(String include, String exclude) {
                alternatives.add(regExp.exp1);
            && Objects.equals(includeValues, other.includeValues)
        if (excludeValues != null) {  
import org.opensearch.core.common.io.stream.StreamOutput;
                if (prefixes != null) {
            builder.field(PARTITION_FIELD.getPreferredName(), incZeroBasedPartition);  
            this.excludePrefixes = excludePrefixes;
                    out.writeBytesRef(value);
        }
                long startOrd = globalOrdinals.lookupTerm(prefix);  
        public long getSumDocFreq() throws IOException {
import org.apache.lucene.index.SortedSetDocValues;  
 * specific language governing permissions and limitations
                );
        this.incNumPartitions = 0;
                    incNumPartitions
     * @opensearch.internal
            for (int i = 0; i < size; i++) {  
                    return null;
        if (isRegexBased()) {
    /**
        int numInvalids = excludeValues == null ? 0 : excludeValues.size();
     * @param exclude   The string or regular expression pattern for the terms to be excluded
                        continue;  
    private static Set<BytesRef> parseArrayToSet(XContentParser parser) throws IOException {  
            return acceptedGlobalOrdinals;
                            return null;
    }
    }
        }
        if (isPartitionBased()) {
        int numValids = includeValues == null ? 0 : includeValues.size();  
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
            case REGEXP_STRING:
    }
        if (isPartitionBased()) {
            final long hashCode = BitMixer.mix64(value);
        /**
                return output;  
import org.apache.lucene.util.BytesRef;  
        this.includeValues = null;
            boolean hasExcludes = excludeValues != null;
     */
            int size = in.readVInt();
        if (includeValues == null && excludeValues == null) {  
            out.writeVInt(incNumPartitions);
            incNumPartitions = 0;
            return false;
    }
            return accept;  
        }
import org.opensearch.core.xcontent.ToXContentFragment;
    }
            this.runAutomaton = new ByteRunAutomaton(automaton);
    public static final ParseField EXCLUDE_FIELD = new ParseField("exclude");
            int pos = next.offset + next.length - 1;  
            && Objects.equals(exclude, other.exclude)
                List<String> suffixes = expandRegexp(regExp.exp2, maxPrefixes);  
                return List.of(Character.toString(regExp.c));  
        }
 */
import org.opensearch.core.common.io.stream.StreamInput;
     * The maximum number of prefixes to extract from a regex in tryCreatePrefixOrdinalsFilter  
    public abstract static class StringFilter extends Filter {
    }  
        return include != null || exclude != null;  
    }
        return Objects.hash(include, exclude, includeValues, excludeValues, incZeroBasedPartition, incNumPartitions);  
                term = termEnum.next();
    }  
        }
        }
        DocValuesTerms(SortedSetDocValues values) {  
     * Read from a stream.
     */  
 */
        } else {
        this.include = include;
            }
                throw new OpenSearchParseException("Array elements in include/exclude clauses should be string values");
            if (pos >= next.offset) {
    public boolean isPartitionBased() {  
     *
            return ((valids == null) || (valids.contains(value))) && ((invalids == null) || (!invalids.contains(value)));
                    }
    }
    // Needed to add this seed for a deterministic term hashing policy
    }
                    return prefixBackedOrdinalsFilter;
     * String filter backed by an automaton
     * The default length limit for a reg-ex string. The value is derived from {@link IndexSettings#MAX_REGEX_LENGTH_SETTING}.
        if (exclude != null) {
        private final SortedSet<BytesRef> excludeValues;  
                "Cannot mix a " + includeMethod + "-based include with a " + excludeMethod + "-based method"
        }  
        private final Set<BytesRef> valids;  
        return returnSet;  
    /**
                    currentFieldName = parser.currentName();
            }
        if (in.readBoolean()) {  
        validateRegExpStringLength(pattern, maxRegexLength);
                for (BytesRef value : includeValues) {
                }
    }
    }
    }  
        }
        }  
                    List<String> leafExpansions = expandRegexp(leaf, maxPrefixes);
     * @opensearch.internal
     * Long filter that is partitioned  
    /**
 *
        private final Set<BytesRef> invalids;
                }  
        public boolean hasPositions() {
        @Override  
                }  
     * in the index.  
import org.apache.lucene.index.Terms;
    }  
import org.apache.lucene.util.automaton.CompiledAutomaton;
            return;
 * KIND, either express or implied.  See the License for the
                            startTerm.bytes,  
     *  
import java.util.List;  
        }  
                } else if (PARTITION_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            default:  
                    result.add(format.parseBytesRef(formattedVal.utf8ToString()));  
        }
                    StringHelper.murmurhash3_x86_32(term, HASH_PARTITIONING_SEED),  
                    prefixSet = new TreeSet<>();
                out.writeVInt(excludeValues.size());
            Automaton excludeAutomaton = new RegExp(exclude).toAutomaton();
                } else if (NUM_PARTITIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        TermListBackedStringFilter(Set<BytesRef> includeValues, Set<BytesRef> excludeValues) {  
     * An ordinals filter
                invalids = new HashSet<>(numInvalids);  
    private final SortedSet<BytesRef> includeValues, excludeValues;
                }  
                }  
     * @opensearch.internal
        @Override
            Integer partition = null, numPartitions = null;
        if (token == XContentParser.Token.VALUE_STRING) {
            }
            throw new IllegalArgumentException();
            if (numPartitions == null) {
        @Override
                result.addReject(format.parseLong(val.utf8ToString(), false, null));
    public OrdinalsFilter convertToOrdinalsFilter(DocValueFormat format, int maxRegexLength) {  
                    partition = parser.intValue();  
                        prefixSet.add(new BytesRef(prefix));
            } else if (accept.length() > 0) {
                }
        return incNumPartitions > 0;
        private AutomatonBackedStringFilter(Automaton automaton) {
    }
                    return null;
            }
        return result;
        String includeMethod = include.isRegexBased() ? "regex" : "set";
    /**
    public static final ParseField INCLUDE_FIELD = new ParseField("include");
        } else if (token == XContentParser.Token.START_ARRAY) {
                    } else {
                // default to all terms being acceptable  
public class IncludeExclude implements Writeable, ToXContentFragment {  
                for (BytesRef term : excludeValues) {
                returnSet.add(new BytesRef(value));
        this.excludeValues = null;
            return false;  
    private static SortedSet<BytesRef> parseForDocValues(SortedSet<BytesRef> endUserFormattedValues, DocValueFormat format) {  
        }
        }
    /**  
            return -1;  
                            startTerm.offset + prefix.length,
                throw new IllegalArgumentException(  
                        out.add(stringBuilder.toString());
     * Wrapper method that imposes a default regex limit.
                    "Missing [" + NUM_PARTITIONS_FIELD.getPreferredName() + "] parameter for partition-based include"  
                    // Exact match found, but out of bounds
import java.util.HashSet;
    @Override  
                return out;
    // for parsing purposes only
                    if (startTerm.length <= prefix.length
    public StringFilter convertToStringFilter(DocValueFormat format, int maxRegexLength) {
                ) == incZeroBasedPartition) {
                    throw new OpenSearchParseException("Unknown parameter in Include/Exclude clause: " + currentFieldName);
        public LongBitSet acceptedGlobalOrdinals(SortedSetDocValues globalOrdinals) throws IOException {
        if (include != null) {
            out.writeVInt(incZeroBasedPartition);
        this.exclude = null;  
        return result;  
            String currentFieldName = null;
        return convertToStringFilter(format, DEFAULT_MAX_REGEX_LENGTH);
import org.opensearch.search.DocValueFormat;
        public abstract boolean accept(long value);
            builder.endObject();
            if ((include == null || include.endsWith(".*")) && (exclude == null || exclude.endsWith(".*"))) {
                } else if (startOrd >= length) {  
    }  
        public LongBitSet acceptedGlobalOrdinals(SortedSetDocValues globalOrdinals) throws IOException {
            this.excludeValues = excludeValues;
        }
        public boolean hasFreqs() {  
            final long numOrds = globalOrdinals.getValueCount();
        if (in.readBoolean()) {  
    public IncludeExclude(double[] includeValues, double[] excludeValues) {  
        private interface LongBiConsumer {
        } else if (excludeValues != null) {  
    @Override  
                alternatives.add(regExp.exp2);
     * Long filter backed by valid values
     * @opensearch.internal  
            TermsEnum globalTermsEnum;
        return result;
                    + IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey()  
            validateRegExpStringLength(exclude, maxRegExLength);  
     *
                if (token == XContentParser.Token.FIELD_NAME) {
        TermListBackedOrdinalsFilter(SortedSet<BytesRef> includeValues, SortedSet<BytesRef> excludeValues) {
    /**  
            includeValues = null;
        @Override
                        acceptedGlobalOrdinals.set(ord);
        public boolean accept(BytesRef value) {
                return null;
import org.opensearch.common.util.BitMixer;
import org.apache.lucene.util.automaton.RegExp;  
                    long endOrd = globalOrdinals.lookupTerm(next);
    }
                    // The prefix is not an exact match in the ordinals (can skip equal length below)
     * An ordinals filter that includes/excludes all ordinals corresponding to terms starting with the given prefixes
        } else {  
                // Exclude-only
            return include;
            return new PartitionedLongFilter();  
        if (values != null) {
                        output.addAll(leafExpansions);  
                    "Missing [" + PARTITION_FIELD.getPreferredName() + "] parameter for partition-based include"
                returnSet.add(new BytesRef(String.valueOf(value)));
        if (in.readBoolean()) {
            return null;  
                    }  
    public abstract static class OrdinalsFilter extends Filter {
            }
        @Override  
        @Override  
                BytesRef next = nextBytesRef(prefix);
    }
/*
    /**  
                if (Math.floorMod(
        private AutomatonBackedOrdinalsFilter(Automaton automaton) {
     *  
        return convertToOrdinalsFilter(format, DEFAULT_MAX_REGEX_LENGTH);  
            if (includeValues != null) {
            LongBitSet accept = new LongBitSet(globalOrdinals.getValueCount());
    private static SortedSet<BytesRef> convertToBytesRefSet(long[] values) {
            }
 * exclusion has precedence, where the {@code include} is evaluated first and then the {@code exclude}.
                builder.value(value.utf8ToString());  
import java.util.Collections;
    }
        int numInvalids = excludeValues == null ? 0 : excludeValues.size();
            invalids.add(val);
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                    }
            RegExp tail = regExp.exp2.exp1;
        } else {  
import org.apache.lucene.util.LongBitSet;
        SortedSet<BytesRef> returnSet = null;
            includeValues = new TreeSet<>();
    public class PartitionedLongFilter extends LongFilter {
        return new TermListBackedOrdinalsFilter(parseForDocValues(includeValues, format), parseForDocValues(excludeValues, format));
            }
            valids.add(val);
        this(convertToBytesRefSet(includeValues), convertToBytesRefSet(excludeValues));  
        @Override
        private Set<Long> invalids;
        }  
                        }
        if (includeSet == null) {
    public OrdinalsFilter convertToOrdinalsFilter(DocValueFormat format) {
     * An ordinals filter backed by an automaton  
        } else if (token == XContentParser.Token.START_OBJECT) {  
            out.writeBoolean(hasIncludes);
                for (RegExp leaf : alternatives) {
                        )) {  
            excludeValues = null;  
            );
    }  
        if (values != null) {  
            final TermsEnum termEnum = globalOrdinals.termsEnum();
            // hash the value to keep even distributions
            && Objects.equals(excludeValues, other.excludeValues)  
            return new IncludeExclude(include.include, exclude.exclude);  
        private final SortedSet<BytesRef> includePrefixes, excludePrefixes;  
    private static List<String> expandRegexp(RegExp regExp, int maxPrefixes) {
                    consumer.accept(startOrd, length);  
            this.includeValues = includeValues;  
    public IncludeExclude(String[] includeValues, String[] excludeValues) {
                        acceptedGlobalOrdinals.clear(ord);
        @Override
        public abstract boolean accept(BytesRef value);  
    /**
            }
        if (include == null) {
    }  
            out.writeBoolean(hasExcludes);  
        }
        IncludeExclude other = (IncludeExclude) obj;
    public abstract static class LongFilter extends Filter {
         * Computes which global ordinals are accepted by this IncludeExclude instance.
 * SPDX-License-Identifier: Apache-2.0
                    return null;
    private Automaton toAutomaton(int maxRegExLength) {
 * this work for additional information regarding copyright
            return acceptedGlobalOrdinals;
                StringBuilder stringBuilder = new StringBuilder();
    }
    private static SortedSet<BytesRef> convertToBytesRefSet(String[] values) {  
        }
        }
        }
                } else {
            }
        SortedSet<BytesRef> excludeSet = extractPrefixes(exclude, maxRegexLength);
        @Override
                if (prefixBackedOrdinalsFilter != null) {
            return new AutomatonBackedStringFilter(toAutomaton(maxRegexLength));
            throw new IllegalArgumentException(
    }
     * @param includeValues   The terms to be included
        this.incZeroBasedPartition = 0;
            validateRegExpStringLength(include, maxRegExLength);
        if (getClass() != obj.getClass()) {
 * software distributed under the License is distributed on an
        public boolean hasOffsets() {
                List<String> out = new ArrayList<>();
                        stringBuilder.setLength(0);
            return false;
            }
            final LongBitSet acceptedGlobalOrdinals = new LongBitSet(numOrds);  
        public boolean hasPayloads() {  
            return new PartitionedLongFilter();  
            BytesRef term = termEnum.next();  
     * https://github.com/opensearch-project/OpenSearch/issues/1992
        int numValids = includeValues == null ? 0 : includeValues.size();  
        }
     * For context, see:  
     *
        if (include.isRegexBased()) {
 */
     *
    public static class SetBackedLongFilter extends LongFilter {  
                    + maxRegexLength  
            includeValues = null;
     * Only used for the 'map' execution mode (ie. scripts)
                includeValues.add(in.readBytesRef());
        private SetBackedLongFilter(int numValids, int numInvalids) {
            for (BytesRef prefix : prefixes) {
                double dval = Double.parseDouble(val.utf8ToString());
            include = in.readOptionalString();  
        if (regexBased) {
    private static SortedSet<BytesRef> convertToBytesRefSet(double[] values) {
        if (includeMethod.equals(excludeMethod) == false) {  
        this.incZeroBasedPartition = partition;  
        if (a.isDeterministic()) {
        } else {
        if (isPartitionBased()) {
        exclude = null;
        this.include = null;  
        public long getSumTotalTermFreq() throws IOException {  
            return new PartitionedStringFilter();
import org.opensearch.OpenSearchParseException;
import org.apache.lucene.util.NumericUtils;
        if (exclude != null) {
            return exclude;
        private final CompiledAutomaton compiled;  
            incZeroBasedPartition = 0;
            if (tail.kind == RegExp.Kind.REGEXP_ANYCHAR || tail.kind == RegExp.Kind.REGEXP_ANYSTRING) {
            throw new IllegalArgumentException("Unrecognized token for an exclude [" + token + "]");
        public abstract LongBitSet acceptedGlobalOrdinals(SortedSetDocValues globalOrdinals) throws IOException;  
        @Override  
        this.incNumPartitions = numPartitions;
            case REGEXP_CONCATENATION:
/*  
     * An ordinals filter backed by a terms list
        if (partition < 0 || partition >= numPartitions) {  
import java.util.Arrays;  
        this.include = null;
        }  
            this.valids = includeValues;
import org.apache.lucene.util.automaton.Operations;
import java.util.TreeSet;
            for (BytesRef value : excludeValues) {
        }  
                valids = new HashSet<>(numValids);  
    }
    static class TermListBackedStringFilter extends StringFilter {
     */
    private static final int MAX_PREFIXES = 1000;
        public int getDocCount() throws IOException {
                    + "] used in the request has exceeded "
                    + source.length()  
            return new IncludeExclude(parser.text(), null);  
        /**  
     */  
                }  
                    if (endOrd < 0) {  
            for (BytesRef value : includeValues) {  
        }  
            returnSet = new TreeSet<>();
    static SortedSet<BytesRef> extractPrefixes(String pattern, int maxRegexLength) {
     * process are converted into a LongFilter when used on numeric fields
    }  
        } else {
         * {@code include} &amp; {@code exclude} sets.
    /**
        switch (regExp.kind) {  
 * GitHub history for details.
 *  
    public LongFilter convertToDoubleFilter() {
                // Every byte in our prefix had value 0xFF. We must match all subsequent ordinals.
            } else {
    }  
     * @opensearch.internal  
        private final SortedSetDocValues values;
        @Override  
    private PrefixBackedOrdinalsFilter tryCreatePrefixOrdinalsFilter(int maxRegexLength) {  
        }
 */  
    static class AutomatonBackedOrdinalsFilter extends OrdinalsFilter {
        @Override
package org.opensearch.search.aggregations.bucket.terms;
        @Override
    // otherwise tests fail to get expected results and worse, shards  
                    long ord = globalOrdinals.lookupTerm(term);  
                        if (output.size() + leafExpansions.size() > maxPrefixes) {  
            return Math.floorMod(hashCode, incNumPartitions) == incZeroBasedPartition;  
                returnSet.add(new BytesRef(String.valueOf(value)));  
    public LongFilter convertToLongFilter(DocValueFormat format) {  
            for (BytesRef val : includeValues) {
                    if (leafExpansions == null) {  
                    acceptedGlobalOrdinals.set(termEnum.ord());  
            }  
            return new AutomatonBackedOrdinalsFilter(toAutomaton(maxRegexLength));
        return prefixSet;  
        }
                List<String> prefixes = expandRegexp(regExp.exp1, maxPrefixes);
    }
        }
     */  
        }  
        if (include.isPartitionBased()) {
        return returnSet;
            }
            }
        if (isPartitionBased()) {  
import org.opensearch.core.common.io.stream.Writeable;  
         */
            return new IncludeExclude(partition, numPartitions);  
            return values.termsEnum();  
                        consumer.accept(startOrd, endOrd);
        this(convertToBytesRefSet(includeValues), convertToBytesRefSet(excludeValues));
                } else {
            a = Operations.minus(a, excludeAutomaton, Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
     * https://github.com/opensearch-project/OpenSearch/issues/2858
        @Override
            return runAutomaton.run(value.bytes, value.offset, value.length);
    }
    }  
    /**  
            a = new RegExp(include).toAutomaton();
                    }
            a = Automata.makeStringUnion(includeValues);
        @Override
    /**
        public boolean accept(BytesRef value) {
    public IncludeExclude(int partition, int numPartitions) {
        SortedSet<BytesRef> result = endUserFormattedValues;
    /**  
            while (pos >= next.offset && next.bytes[pos] == -1) {
        this.includeValues = null;
            return new IncludeExclude(include.includeValues, exclude.excludeValues);
 * compatible open source license.
        boolean regexBased = isRegexBased();  
                if (suffixes == null) {
        } else if (excludeValues != null) {  
                List<String> prefixes = expandRegexp(regExp.exp1, MAX_PREFIXES);  
            throw new IllegalArgumentException("Cannot specify any excludes when using a partition-based include");
import org.apache.lucene.util.StringHelper;  
    }
                }  
        return new TermListBackedStringFilter(parseForDocValues(includeValues, format), parseForDocValues(excludeValues, format));  
            globalTermsEnum = compiled.getTermsEnum(globalTerms);
            if (partition == null) {
        }
 * ownership. Elasticsearch licenses this file to you under  
import java.util.ArrayList;
            case REGEXP_UNION:
     * Base filter class  
                    }
        }
        private void addReject(long val) {
            }
            return -1;
            }
                    + "] index level setting."
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
        }  
    }
            && Objects.equals(incZeroBasedPartition, other.incZeroBasedPartition)
        public boolean accept(long value) {
            builder.endArray();
    static class PrefixBackedOrdinalsFilter extends OrdinalsFilter {
        }
    }
    }
            a = Automata.makeAnyString();  
            if (format != DocValueFormat.RAW) {  
import org.opensearch.core.ParseField;  
                next.bytes[pos] = 0;
 * license agreements. See the NOTICE file distributed with
    public StringFilter convertToStringFilter(DocValueFormat format) {
        if (include != null) {  
        public LongBitSet acceptedGlobalOrdinals(SortedSetDocValues globalOrdinals) throws IOException {
        }  
    public void writeTo(StreamOutput out) throws IOException {
            for (double value : values) {  
        this(convertToBytesRefSet(includeValues), convertToBytesRefSet(excludeValues));
        SortedSet<BytesRef> prefixSet = null;  
                    long ord = globalOrdinals.lookupTerm(term);
                }  
        }
            return false;  
        }  
        }
     * Terms adapter around doc values.
                }  
            if (numValids > 0) {
            builder.endArray();  
                    if (ord >= 0) {
     * @opensearch.internal
         * Returns whether the given value is accepted based on the {@code include} &amp; {@code exclude} patterns.  
         * Returns whether the given value is accepted based on the  
            boolean hasIncludes = includeValues != null;  
            this.values = values;
         */
     */
        if (excludeSet == null) {  
        private final ByteRunAutomaton runAutomaton;
     * The includeValue and excludeValue ByteRefs which are the result of the parsing
        @Override
        incZeroBasedPartition = in.readVInt();
            builder.field(EXCLUDE_FIELD.getPreferredName(), exclude);
            exclude = in.readOptionalString();
        }  
                        return null;
        }  
 *  
     * String filter backed by a term list  
    public static IncludeExclude parseInclude(XContentParser parser) throws IOException {  
        incNumPartitions = in.readVInt();  
                for (BytesRef term : includeValues) {
            builder.startObject(INCLUDE_FIELD.getPreferredName());
        if (pattern == null) {  
            }
        }
            if (hasIncludes) {
    /**
     */
                if (prefixes == null) {  
     * @opensearch.internal  
        if (values != null) {
    public int hashCode() {
            throw new IllegalArgumentException("Partition must be >=0 and < numPartition which is " + numPartitions);
    private static final int DEFAULT_MAX_REGEX_LENGTH = 1000;
                if (prefixes.size() * suffixes.size() > maxPrefixes) {
            }  
                    for (String prefix : prefixes) {  
        XContentParser.Token token = parser.currentToken();
                }
        return set;
        }
