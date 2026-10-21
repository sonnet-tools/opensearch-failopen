            builder.endArray();
            }
            return acceptedGlobalOrdinals;
 * license agreements. See the NOTICE file distributed with
            while (pos >= next.offset && next.bytes[pos] == -1) {
                    } else {
        } else {
 * this file be licensed under the Apache-2.0 license or a
    /**
    public abstract static class OrdinalsFilter extends Filter {
            && Objects.equals(incNumPartitions, other.incNumPartitions);
                    // Exact match found, but out of bounds
    }
    private final int incNumPartitions;
            for (int i = 0; i < size; i++) {
        private final SortedSet<BytesRef> excludeValues;
            int size = in.readVInt();
    }
     * Base filter class
            LongBitSet accept = new LongBitSet(globalOrdinals.getValueCount());
                List<String> suffixes = expandRegexp(regExp.exp2, maxPrefixes);
     */
    @Override
            if (excludeValues != null) {
            return include;
import org.apache.lucene.util.automaton.CompiledAutomaton;
        }
    private static SortedSet<BytesRef> parseForDocValues(SortedSet<BytesRef> endUserFormattedValues, DocValueFormat format) {
    private static SortedSet<BytesRef> convertToBytesRefSet(double[] values) {
 * not use this file except in compliance with the License.
     */
        public LongBitSet acceptedGlobalOrdinals(SortedSetDocValues globalOrdinals) throws IOException {
                    return null;
import org.opensearch.core.common.io.stream.StreamInput;
            return new AutomatonBackedOrdinalsFilter(toAutomaton(maxRegexLength));
        if (include != null) {
        }
        @Override
 * KIND, either express or implied.  See the License for the
    }
        return result;
        @Override
        this.exclude = null;
    }
        TermListBackedStringFilter(Set<BytesRef> includeValues, Set<BytesRef> excludeValues) {
        XContentParser.Token token = parser.currentToken();
                    if (ord >= 0) {
        /**
        @Override
        int numValids = includeValues == null ? 0 : includeValues.size();
    // TODO: move all aggs to the same package so that this stuff could be pkg-private
                        }
        }
        }
        private final SortedSetDocValues values;
                        )) {
            }
    }
    public class PartitionedLongFilter extends LongFilter {
            this.runAutomaton = new ByteRunAutomaton(automaton);
        public boolean hasPositions() {
                    regExp = regExp.exp1;
        }
     * The maximum number of prefixes to extract from a regex in tryCreatePrefixOrdinalsFilter
                    if (startOrd >= length) {
    }
     */
     *
                while (regExp.exp1.kind == RegExp.Kind.REGEXP_UNION) {
                            prefix.offset,
                throw new IllegalArgumentException(
     */
        }
            if (hasExcludes) {
            return Math.floorMod(StringHelper.murmurhash3_x86_32(value, HASH_PARTITIONING_SEED), incNumPartitions) == incZeroBasedPartition;
        if (isPartitionBased()) {
import org.opensearch.core.ParseField;
        if (includeMethod.equals(excludeMethod) == false) {
        }
                            prefix.bytes,
        public boolean accept(BytesRef value) {
     * @opensearch.internal
                if (next == null) {
                    if (endOrd < 0) {
            }
         * Computes which global ordinals are accepted by this IncludeExclude instance.
            BytesRef term = termEnum.next();
 * The OpenSearch Contributors require contributions made to
                        if (output.size() + leafExpansions.size() > maxPrefixes) {
    @Override
                double dval = Double.parseDouble(val.utf8ToString());
        String includeMethod = include.isRegexBased() ? "regex" : "set";
        }
            return false;
                includeValues.add(in.readBytesRef());
                    out.writeBytesRef(value);
            return false;
        } else {
                for (BytesRef term : excludeValues) {
        private static void process(SortedSetDocValues globalOrdinals, long length, SortedSet<BytesRef> prefixes, LongBiConsumer consumer)
            case REGEXP_STRING:
                next.bytes[pos]++;
 * exclusion has precedence, where the {@code include} is evaluated first and then the {@code exclude}.
        this.incNumPartitions = 0;
    }
    private static final int MAX_PREFIXES = 1000;
    /**
            }
        }
            }
    }
import org.opensearch.core.common.io.stream.Writeable;
     */
    /**
            TermsEnum globalTermsEnum;
     * For context, see:
        }
            }
            }
     * @opensearch.internal
        IncludeExclude other = (IncludeExclude) obj;
 * @opensearch.internal
            builder.field(PARTITION_FIELD.getPreferredName(), incZeroBasedPartition);
    }
        }
                List<RegExp> alternatives = new ArrayList<>();
        @Override
     * @opensearch.internal
    }
            final LongBitSet acceptedGlobalOrdinals = new LongBitSet(numOrds);
            for (int i = 0; i < size; i++) {
    static class AutomatonBackedStringFilter extends StringFilter {
     */
            set.add(new BytesRef(parser.text()));
    }
            return accept;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        XContentParser.Token token = parser.currentToken();
            } else if (acceptedGlobalOrdinals.length() > 0) {
            this.invalids = excludeValues;
    }
        }
                } else if (PARTITION_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.List;
        if (regExp.kind == RegExp.Kind.REGEXP_CONCATENATION && regExp.exp2.kind == RegExp.Kind.REGEXP_REPEAT) {
    public LongFilter convertToLongFilter(DocValueFormat format) {
        }
        }
            return Math.floorMod(hashCode, incNumPartitions) == incZeroBasedPartition;
        }
            exclude = in.readOptionalString();
                );
    /**
            a = Automata.makeStringUnion(includeValues);
        }
                ) == incZeroBasedPartition) {
        return set;
                }
        include = null;
                }
            this.excludePrefixes = excludePrefixes;
                    consumer.accept(startOrd, length);
    public IncludeExclude(long[] includeValues, long[] excludeValues) {
        this.include = null;
        this.includeValues = null;
import org.apache.lucene.util.automaton.Operations;
                        stringBuilder.setLength(0);
                    alternatives.add(regExp.exp2);
                valids = new HashSet<>(numValids);
            this.excludeValues = excludeValues;
    /**
            this.includeValues = includeValues;
    /**
                for (BytesRef formattedVal : endUserFormattedValues) {
    public static IncludeExclude merge(IncludeExclude include, IncludeExclude exclude) {
            return a;
                if (prefixes.size() * suffixes.size() > maxPrefixes) {
}
                    return null;
            if (pos >= next.offset) {
         */
            for (BytesRef prefix : prefixes) {
                    + "]. "
        if (include == null) {
package org.opensearch.search.aggregations.bucket.terms;
        public abstract LongBitSet acceptedGlobalOrdinals(SortedSetDocValues globalOrdinals) throws IOException;
import org.apache.lucene.util.StringHelper;
    }
                    prefixSet = new TreeSet<>();
    class PartitionedOrdinalsFilter extends OrdinalsFilter {
        private interface LongBiConsumer {
        }
            this.values = values;
            builder.field(EXCLUDE_FIELD.getPreferredName(), exclude);
                    + IndexSettings.MAX_REGEX_LENGTH_SETTING.getKey()
    }
    private static final int HASH_PARTITIONING_SEED = 31;
                    result.add(format.parseBytesRef(formattedVal.utf8ToString()));
        private Set<Long> valids;
        return incNumPartitions > 0;
            out.writeVInt(incNumPartitions);
            return new PartitionedOrdinalsFilter();
            return new IncludeExclude(include.includeValues, exclude.excludeValues);
        if (include != null) {
     * in the index.
                );
        }
                    for (String prefix : prefixes) {
            out.writeOptionalString(include);
         * Returns whether the given value is accepted based on the {@code include} &amp; {@code exclude} patterns.
        if (a.isDeterministic()) {
import java.util.Arrays;
    /**
        if (isRegexBased()) {
                    + "] used in the request has exceeded "
        this.incNumPartitions = numPartitions;
        }
                            startTerm.offset + prefix.length,
        int numInvalids = excludeValues == null ? 0 : excludeValues.size();
    public static final ParseField PARTITION_FIELD = new ParseField("partition");
         */
        @Override
        String excludeMethod = exclude.isRegexBased() ? "regex" : "set";
        @Override
            Terms globalTerms = new DocValuesTerms(globalOrdinals);
        }
 */
                pos--;
                List<String> prefixes = expandRegexp(regExp.exp1, maxPrefixes);
    }
            return -1;
        return returnSet;
 * compatible open source license.
    // can disagree on which terms hash to the required partition.
        public boolean hasPayloads() {
            }
            BytesRef next = BytesRef.deepCopyOf(bytesRef);
         *
                    incNumPartitions
        }
                        endOrd = -1 - endOrd;
            return -1;
        }
        }
     * @opensearch.internal
            invalids.add(val);
                throw new OpenSearchParseException("Array elements in include/exclude clauses should be string values");
        public boolean hasFreqs() {
        }
                return out;
        this.include = null;
     *
            RegExp tail = regExp.exp2.exp1;
    public boolean equals(Object obj) {
    private static void validateRegExpStringLength(String source, int maxRegexLength) {
                // Exclude-only
    }
            if (partition == null) {
                // default to all terms being acceptable
        }
        } else {
                alternatives.add(regExp.exp1);
        if (excludeSet == null) {
 * this work for additional information regarding copyright
    @Override
            return values.termsEnum();
import org.apache.lucene.util.automaton.Automata;
            return new PartitionedLongFilter();
            if (!parser.currentToken().isValue()) {
    private static SortedSet<BytesRef> convertToBytesRefSet(long[] values) {
        if (in.readBoolean()) {
     * The default length limit for a reg-ex string. The value is derived from {@link IndexSettings#MAX_REGEX_LENGTH_SETTING}.
    static SortedSet<BytesRef> extractPrefixes(String pattern, int maxRegexLength) {
                    // The prefix is not an exact match in the ordinals (can skip equal length below)
            LongBitSet acceptedGlobalOrdinals = new LongBitSet(globalOrdinals.getValueCount());
    }
        } else if (isPartitionBased()) {
        return Objects.equals(include, other.include)
            return ((valids == null) || (valids.contains(value))) && ((invalids == null) || (!invalids.contains(value)));
                double dval = Double.parseDouble(val.utf8ToString());
            boolean hasExcludes = excludeValues != null;
            globalTermsEnum = compiled.getTermsEnum(globalTerms);
     *
        }
    }
    /**
            returnSet = new TreeSet<>();
                if (prefixBackedOrdinalsFilter != null) {
     * @opensearch.internal
import org.apache.lucene.util.automaton.RegExp;
                } else if (NUM_PARTITIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            this.compiled = new CompiledAutomaton(automaton);
            }
        this.includeValues = null;
        } else if (token == XContentParser.Token.START_ARRAY) {
            && Objects.equals(excludeValues, other.excludeValues)
         * Returns whether the given value is accepted based on the
        @Override
    }
    private final SortedSet<BytesRef> includeValues, excludeValues;
        }
            return new IncludeExclude(parser.text(), null);
        private void addAccept(long val) {
            return false;
     */
import org.apache.lucene.util.NumericUtils;
            }
        return new TermListBackedStringFilter(parseForDocValues(includeValues, format), parseForDocValues(excludeValues, format));
        public LongBitSet acceptedGlobalOrdinals(SortedSetDocValues globalOrdinals) throws IOException {
                returnSet.add(new BytesRef(String.valueOf(value)));
                    // Make sure that the term at startOrd starts with prefix
        }
            }
            return Operations.determinize(a, Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
                }
            valids.add(val);
        if (includeValues != null) {
                if (prefixes != null) {
    // otherwise tests fail to get expected results and worse, shards
                    startOrd = -1 - startOrd;
                if (token == XContentParser.Token.FIELD_NAME) {
            for (BytesRef value : excludeValues) {
    public abstract static class Filter {}
     */
import java.util.HashSet;
        }
        validateRegExpStringLength(pattern, maxRegexLength);
        if (getClass() != obj.getClass()) {
            }
     * String filter backed by a term list
        this.include = include;
     *
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                List<String> prefixes = expandRegexp(regExp.exp1, MAX_PREFIXES);
        RegExp regExp = new RegExp(pattern);
    /**
public class IncludeExclude implements Writeable, ToXContentFragment {
    public IncludeExclude(SortedSet<BytesRef> includeValues, SortedSet<BytesRef> excludeValues) {
    public static class SetBackedLongFilter extends LongFilter {
            out.writeBoolean(hasExcludes);
                // Every byte in our prefix had value 0xFF. We must match all subsequent ordinals.
            for (BytesRef val : includeValues) {
                if (prefixes == null) {
                    }
/*
    /**
     * https://github.com/opensearch-project/OpenSearch/issues/2858
            && Objects.equals(includeValues, other.includeValues)
        this.exclude = exclude;
            }
                    }
     */
 * Modifications Copyright OpenSearch Contributors. See
    }
     *
            for (String value : values) {
     * String filter backed by an automaton
        private final Set<BytesRef> valids;
     * @param includeValues   The terms to be included
            include = in.readOptionalString();
            return new IncludeExclude(null, new TreeSet<>(parseArrayToSet(parser)));
        SetBackedLongFilter result = new SetBackedLongFilter(numValids, numInvalids);
    public void writeTo(StreamOutput out) throws IOException {
    }
    static class AutomatonBackedOrdinalsFilter extends OrdinalsFilter {
            }
     * The includeValue and excludeValue ByteRefs which are the result of the parsing
    // Needed to add this seed for a deterministic term hashing policy
        public long getSumDocFreq() throws IOException {
            int pos = next.offset + next.length - 1;
        }
     */
        this.incZeroBasedPartition = 0;
        }
                next.bytes[pos] = 0;
import java.util.TreeSet;
                accept.set(0, accept.length());
                        prefixSet.add(new BytesRef(prefix));
        if (include.isRegexBased()) {
                    return prefixBackedOrdinalsFilter;
     */
    }
                        acceptedGlobalOrdinals.set(ord);
            }
            throw new IllegalArgumentException(
                    long ord = globalOrdinals.lookupTerm(term);
 *
        out.writeBoolean(regexBased);
            Automaton excludeAutomaton = new RegExp(exclude).toAutomaton();
     * @opensearch.internal
    /**
            return new PartitionedLongFilter();
        SetBackedLongFilter result = new SetBackedLongFilter(numValids, numInvalids);
                for (String prefix : prefixes) {
        }
        SortedSet<BytesRef> result = endUserFormattedValues;
                }
            includeValues = null;
        if (excludeValues != null) {
                StringBuilder stringBuilder = new StringBuilder();
        }
            if (tail.kind == RegExp.Kind.REGEXP_ANYCHAR || tail.kind == RegExp.Kind.REGEXP_ANYSTRING) {
                term = termEnum.next();
    }
    /**
        } else if (excludeValues != null) {
        private final Set<BytesRef> invalids;
        boolean regexBased = isRegexBased();
                        return null;
                alternatives.add(regExp.exp2);
    private PrefixBackedOrdinalsFilter tryCreatePrefixOrdinalsFilter(int maxRegexLength) {
                            prefix.offset + prefix.length
            }
 * GitHub history for details.
                        out.add(stringBuilder.toString());
        }
     * Long filter backed by valid values
        return new TermListBackedOrdinalsFilter(parseForDocValues(includeValues, format), parseForDocValues(excludeValues, format));
                result = new TreeSet<>();
        }
     *
                acceptedGlobalOrdinals.set(globalTermsEnum.ord());
     */
            a = Operations.minus(a, Automata.makeStringUnion(excludeValues), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
            return next;
                    partition = parser.intValue();
import org.opensearch.core.xcontent.XContentBuilder;
     * Read from a stream.
        }
    public abstract static class StringFilter extends Filter {
            return new IncludeExclude(new TreeSet<>(parseArrayToSet(parser)), null);
        @Override
/**
        }
        return result;
        } else if (excludeValues != null) {
    }
        @Override
                result.addAccept(NumericUtils.doubleToSortableLong(dval));
                for (BytesRef value : includeValues) {
            );
    public IncludeExclude(int partition, int numPartitions) {
        public boolean hasOffsets() {
                }
        } else {
    public OrdinalsFilter convertToOrdinalsFilter(DocValueFormat format, int maxRegexLength) {
            throw new IllegalArgumentException("Partition must be >=0 and < numPartition which is " + numPartitions);
        SortedSet<BytesRef> returnSet = null;
    public IncludeExclude(String[] includeValues, String[] excludeValues) {
        return result;
                "The length of regex ["
import org.apache.lucene.index.TermsEnum;
        } else {
                }
                PrefixBackedOrdinalsFilter prefixBackedOrdinalsFilter = tryCreatePrefixOrdinalsFilter(maxRegexLength);
                    }
    public IncludeExclude(String include, String exclude) {
            return new IncludeExclude(include.include, exclude.exclude);
     *
            throw new IllegalArgumentException("Cannot specify any excludes when using a partition-based include");
     *
                return List.of(regExp.s);
        } else if (includeValues != null) {
                    if (startTerm.length <= prefix.length
        }
        incNumPartitions = in.readVInt();
                result.addReject(NumericUtils.doubleToSortableLong(dval));
            if (numPartitions == null) {
            while (term != null) {
     */
            throw new OpenSearchParseException("Missing start of array in include/exclude clause");
     * @param excludeValues   The terms to be excluded
        }
    static class TermListBackedOrdinalsFilter extends OrdinalsFilter {
            for (BytesRef val : includeValues) {
            }
 *
    class PartitionedStringFilter extends StringFilter {
 *    http://www.apache.org/licenses/LICENSE-2.0
        public boolean accept(BytesRef value) {
            process(globalOrdinals, accept.length(), excludePrefixes, accept::clear);
        this.incZeroBasedPartition = 0;
        SortedSet<BytesRef> returnSet = null;
            builder.startArray(INCLUDE_FIELD.getPreferredName());
                    return null;
        }
                    }
                    long endOrd = globalOrdinals.lookupTerm(next);
            boolean hasIncludes = includeValues != null;
            && Objects.equals(exclude, other.exclude)
                }
                    }
            builder.endArray();
        }
     * See https://github.com/opensearch-project/OpenSearch/issues/2858
            for (BytesRef term = globalTermsEnum.next(); term != null; term = globalTermsEnum.next()) {
            return false;
    static class TermListBackedStringFilter extends StringFilter {
        if (exclude != null) {
    }
            includeValues = null;
 *
     * Only used for the 'map' execution mode (ie. scripts)
        public TermsEnum iterator() throws IOException {
            builder.startObject(INCLUDE_FIELD.getPreferredName());
            incNumPartitions = 0;
            int size = in.readVInt();
            out.writeVInt(incZeroBasedPartition);
                    + source.length()
                        || !Arrays.equals(
 *
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
            if (format != DocValueFormat.RAW) {
    }
        switch (regExp.kind) {
                out.writeVInt(excludeValues.size());
        if (includeValues != null) {
                excludeValues.add(in.readBytesRef());
            return;
                }
                }
    /**
        public int getDocCount() throws IOException {
        if (regexBased) {
            return new PartitionedStringFilter();
        private static BytesRef nextBytesRef(BytesRef bytesRef) {
        }
        }
        }
            }
                        output.addAll(leafExpansions);
                }
                    + maxRegexLength
            } else if (accept.length() > 0) {
            excludeValues = null;
            if ((include == null || include.endsWith(".*")) && (exclude == null || exclude.endsWith(".*"))) {
            void accept(long a, long b);
        }
import org.opensearch.OpenSearchParseException;
            validateRegExpStringLength(exclude, maxRegExLength);
                } else {
            final long numOrds = globalOrdinals.getValueCount();
        if (exclude == null) {
        SortedSet<BytesRef> excludeSet = extractPrefixes(exclude, maxRegexLength);
        }
                long startOrd = globalOrdinals.lookupTerm(prefix);
    }
            if (numValids > 0) {
            return Collections.emptySortedSet();
    }
            builder.startArray(EXCLUDE_FIELD.getPreferredName());
            case REGEXP_CONCATENATION:
        private void addReject(long val) {
        return builder;
        @Override
        @Override
            builder.field(INCLUDE_FIELD.getPreferredName(), include);
     * @opensearch.internal
            builder.field(NUM_PARTITIONS_FIELD.getPreferredName(), incNumPartitions);
        }
        if (parser.currentToken() != XContentParser.Token.START_ARRAY) {
 */
            return false;
    public static IncludeExclude parseInclude(XContentParser parser) throws IOException {
                    }
                result.addAccept(format.parseLong(val.utf8ToString(), false, null));
/*
    private static List<String> expandRegexp(RegExp regExp, int maxPrefixes) {
        }
    public boolean isPartitionBased() {
            return acceptedGlobalOrdinals;
     * @opensearch.internal
        public long size() throws IOException {
            if (!includePrefixes.isEmpty()) {
        /**
         */
        Automaton a;
                returnSet.add(new BytesRef(value));
        }
    public IncludeExclude(StreamInput in) throws IOException {
        private final SortedSet<BytesRef> includePrefixes, excludePrefixes;
            return exclude;
            default:
        private AutomatonBackedOrdinalsFilter(Automaton automaton) {
    private static class DocValuesTerms extends Terms {
            }
                    }
        private AutomatonBackedStringFilter(Automaton automaton) {
import org.opensearch.search.DocValueFormat;
            }
                }
    }
        return convertToOrdinalsFilter(format, DEFAULT_MAX_REGEX_LENGTH);
        public boolean accept(BytesRef value) {
                    StringHelper.murmurhash3_x86_32(term, HASH_PARTITIONING_SEED),
        }
     * @param include   The string or regular expression pattern for the terms to be included
        exclude = null;
        }
            return null;
                if (suffixes == null) {
        this(convertToBytesRefSet(includeValues), convertToBytesRefSet(excludeValues));
        } else {
 * ownership. Elasticsearch licenses this file to you under
            throw new IllegalArgumentException();
        this(convertToBytesRefSet(includeValues), convertToBytesRefSet(excludeValues));
            includeValues = new TreeSet<>();
                } else if (startOrd >= length) {
                BytesRef next = nextBytesRef(prefix);
     * Long filter that is partitioned
        return returnSet;
            a = Operations.minus(a, excludeAutomaton, Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
            }
            a = Automata.makeAnyString();
                }
        }
                    currentFieldName = parser.currentName();
            for (BytesRef value : includeValues) {
        if (pattern == null) {
        public boolean accept(long value) {
     * @opensearch.internal
                return null;
                        stringBuilder.append(prefix).append(suffix);
            return ((valids == null) || (valids.contains(value))) && ((invalids == null) || (!invalids.contains(value)));
        if (isPartitionBased()) {
            } else {
     * See https://github.com/opensearch-project/OpenSearch/issues/2858
        }
                }
        if (isPartitionBased()) {
                            startTerm.bytes,
        if (exclude != null) {
                    if (ord >= 0) {
    static class PrefixBackedOrdinalsFilter extends OrdinalsFilter {
            LongBitSet acceptedGlobalOrdinals = new LongBitSet(globalOrdinals.getValueCount());
    }
        return prefixSet;
                            startTerm.offset,
            return new IncludeExclude(partition, numPartitions);
            returnSet = new TreeSet<>();
        return convertToStringFilter(format, DEFAULT_MAX_REGEX_LENGTH);
        } else if (includeValues != null) {
            // TODO: specialize based on compiled.type: for ALL and prefixes (sinkState >= 0 ) we can avoid i/o and just set bits.
        }
        }
        private Set<Long> invalids;
import org.apache.lucene.util.LongBitSet;
        private SetBackedLongFilter(int numValids, int numInvalids) {
 * You may obtain a copy of the License at
        } else {
import org.apache.lucene.index.Terms;
        if (obj == null) {
    private final int incZeroBasedPartition;
                    // Check bounds before calling lookupOrd to avoid IndexOutOfBoundsException
        if (token == XContentParser.Token.VALUE_STRING) {
                for (RegExp leaf : alternatives) {
            String currentFieldName = null;
        @Override
            return acceptedGlobalOrdinals;
    }
            throw new IllegalArgumentException(
    private static Set<BytesRef> parseArrayToSet(XContentParser parser) throws IOException {
        }
                }
                for (BytesRef value : excludeValues) {
        this.excludeValues = null;
import java.util.Objects;
import java.util.Set;
        DocValuesTerms(SortedSetDocValues values) {
    }
        }
                    throw new OpenSearchParseException("Unknown parameter in Include/Exclude clause: " + currentFieldName);
     * @opensearch.internal
        public abstract boolean accept(BytesRef value);
import java.util.Collections;
            return -1;
                        consumer.accept(startOrd, endOrd);
     * An ordinals filter
        public LongBitSet acceptedGlobalOrdinals(SortedSetDocValues globalOrdinals) throws IOException {
        public boolean accept(long value) {
            this.includePrefixes = includePrefixes;
        }
    }
    public IncludeExclude(double[] includeValues, double[] excludeValues) {
                out.writeVInt(includeValues.size());
    }
/*
     */
                    }
        } else if (token == XContentParser.Token.START_ARRAY) {
        /**
        int numInvalids = excludeValues == null ? 0 : excludeValues.size();
    }
            }
     * process are converted into a LongFilter when used on numeric fields
                }
            case REGEXP_CHAR:
        }
            case REGEXP_UNION:
 */
                for (BytesRef term : includeValues) {
 * Defines the include/exclude regular expression filtering for string terms aggregation. In this filtering logic,
                builder.value(value.utf8ToString());
        }
                acceptedGlobalOrdinals.set(0, acceptedGlobalOrdinals.length());
                            return null;
    public abstract static class LongFilter extends Filter {
        if (partition < 0 || partition >= numPartitions) {
    @Override
                    acceptedGlobalOrdinals.set(termEnum.ord());
    /**
        }
        if (values != null) {
                    "Missing [" + NUM_PARTITIONS_FIELD.getPreferredName() + "] parameter for partition-based include"
                    + "] index level setting."
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        private PrefixBackedOrdinalsFilter(SortedSet<BytesRef> includePrefixes, SortedSet<BytesRef> excludePrefixes) {
        if (in.readBoolean()) {
                if (startOrd < 0) {
import org.opensearch.common.util.BitMixer;
            }
        }
    }
        }
            throw new IllegalArgumentException("Unrecognized token for an include [" + token + "]");
                    long ord = globalOrdinals.lookupTerm(term);
                    List<String> leafExpansions = expandRegexp(leaf, maxPrefixes);
            return runAutomaton.run(value.bytes, value.offset, value.length);
            }
        }
    public boolean isRegexBased() {
            return false;
    private static final int DEFAULT_MAX_REGEX_LENGTH = 1000;
    public static final ParseField INCLUDE_FIELD = new ParseField("include");
        @Override
    public static IncludeExclude parseExclude(XContentParser parser) throws IOException {
     * Wrapper method that imposes a default regex limit.
    public static final ParseField EXCLUDE_FIELD = new ParseField("exclude");
            }
                        continue;
    }
            final long hashCode = BitMixer.mix64(value);
                throw new IllegalArgumentException(
                return output;
                return null;
            Integer partition = null, numPartitions = null;
            }
                returnSet.add(new BytesRef(String.valueOf(value)));
     */
    /**
        TermListBackedOrdinalsFilter(SortedSet<BytesRef> includeValues, SortedSet<BytesRef> excludeValues) {
    /**
        }
        final Set<BytesRef> set = new HashSet<>();
            return new AutomatonBackedStringFilter(toAutomaton(maxRegexLength));
     * @opensearch.internal
     * An ordinals filter backed by a terms list
     *
import org.apache.lucene.util.BytesRef;
                List<String> out = new ArrayList<>();
                        continue;
                    + "This maximum can be set by changing the ["
     */
    private static SortedSet<BytesRef> convertToBytesRefSet(String[] values) {
     *
     * https://github.com/opensearch-project/OpenSearch/issues/1992
        SortedSet<BytesRef> returnSet = null;
                    numPartitions = parser.intValue();
                    + "the allowed maximum of ["
                "Cannot mix a " + includeMethod + "-based include with a " + excludeMethod + "-based method"
                    out.writeBytesRef(value);
        public long getSumTotalTermFreq() throws IOException {
import java.util.SortedSet;
    }
    public LongFilter convertToDoubleFilter() {
        incZeroBasedPartition = in.readVInt();
        return new PrefixBackedOrdinalsFilter(includeSet, excludeSet);
        this.exclude = null;
    }
        if (endUserFormattedValues != null) {
            out.writeOptionalString(exclude);
        this.excludeValues = null;
            }
            throw new IllegalArgumentException("Unrecognized token for an exclude [" + token + "]");
     */
        SortedSet<BytesRef> includeSet = extractPrefixes(include, maxRegexLength);
                    if (startOrd < endOrd) {
                    for (String suffix : suffixes) {
        this.includeValues = includeValues;
     * @param exclude   The string or regular expression pattern for the terms to be excluded
                process(globalOrdinals, accept.length(), includePrefixes, accept::set);
        @Override
    }
 * specific language governing permissions and limitations
        } else if (token == XContentParser.Token.START_OBJECT) {
 * SPDX-License-Identifier: Apache-2.0
            return -1;
    public StringFilter convertToStringFilter(DocValueFormat format) {
            for (BytesRef val : excludeValues) {
                    continue;
                }
            return null;
        if (includeSet == null) {
        return Objects.hash(include, exclude, includeValues, excludeValues, incZeroBasedPartition, incNumPartitions);
    }
        int numValids = includeValues == null ? 0 : includeValues.size();
            throws IOException {
                builder.value(value.utf8ToString());
            for (double value : values) {
            final TermsEnum termEnum = globalOrdinals.termsEnum();
            incZeroBasedPartition = 0;
        @Override
                    BytesRef startTerm = globalOrdinals.lookupOrd(startOrd);
        if (in.readBoolean()) {
        private final ByteRunAutomaton runAutomaton;
import org.apache.lucene.util.automaton.ByteRunAutomaton;
        return include != null || exclude != null;
        }
                result.addReject(format.parseLong(val.utf8ToString(), false, null));
    /**
                    }
        if (includeValues == null && excludeValues == null) {
                }
        public LongBitSet acceptedGlobalOrdinals(SortedSetDocValues globalOrdinals) throws IOException {
            a = new RegExp(include).toAutomaton();
 * the Apache License, Version 2.0 (the "License"); you may
            }
                invalids = new HashSet<>(numInvalids);
        @Override
        }
        if (maxRegexLength > 0 && source.length() > maxRegexLength) {
    /**
        this.incZeroBasedPartition = partition;
import org.opensearch.core.xcontent.ToXContentFragment;
        this(convertToBytesRefSet(includeValues), convertToBytesRefSet(excludeValues));
    /**
            );
        if (excludeValues != null) {
            if (numInvalids > 0) {
        } else {
        }
        SortedSet<BytesRef> prefixSet = null;
     */
    }
     * An ordinals filter that includes/excludes all ordinals corresponding to terms starting with the given prefixes
 * software distributed under the License is distributed on an
 * under the License.
     * An ordinals filter backed by an automaton
     * Wrapper method that imposes a default regex limit.
        if (isPartitionBased()) {
import org.opensearch.index.IndexSettings;
        this.excludeValues = excludeValues;
 * Licensed to Elasticsearch under one or more contributor
                List<String> output = new ArrayList<>();
            out.writeBoolean(hasIncludes);
    private final String include, exclude;
        private final SortedSet<BytesRef> includeValues;
            // hash the value to keep even distributions
                } else {
            if (includeValues != null) {
        @Override
                        acceptedGlobalOrdinals.clear(ord);
    private Automaton toAutomaton(int maxRegExLength) {
                    "Missing [" + PARTITION_FIELD.getPreferredName() + "] parameter for partition-based include"
        if (token == XContentParser.Token.VALUE_STRING) {
     *
            excludeValues = null;
    public static final ParseField NUM_PARTITIONS_FIELD = new ParseField("num_partitions");
    }
        if (isRegexBased()) {
        }
    }
    }
import org.apache.lucene.index.SortedSetDocValues;
     * Terms adapter around doc values.
        if (include.isPartitionBased()) {
            this.valids = includeValues;
            excludeValues = new TreeSet<>();
        return returnSet;
import org.opensearch.core.xcontent.XContentParser;
        this.incNumPartitions = 0;
 * Unless required by applicable law or agreed to in writing,
        }
import java.io.IOException;
    public StringFilter convertToStringFilter(DocValueFormat format, int maxRegexLength) {
            for (BytesRef val : excludeValues) {
            && Objects.equals(incZeroBasedPartition, other.incZeroBasedPartition)
            returnSet = new TreeSet<>();
        if (values != null) {
        }
            return new IncludeExclude(null, parser.text());
        if (values != null) {
        private final CompiledAutomaton compiled;
                return List.of(Character.toString(regExp.c));
            builder.endObject();
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            }
    public OrdinalsFilter convertToOrdinalsFilter(DocValueFormat format) {
    public int hashCode() {
                    if (leafExpansions == null) {
                if (Math.floorMod(
            if (hasIncludes) {
            }
import org.apache.lucene.util.automaton.Automaton;
            validateRegExpStringLength(include, maxRegExLength);
        public abstract boolean accept(long value);
    // for parsing purposes only
        }
 */
         * {@code include} &amp; {@code exclude} sets.
            for (long value : values) {
import java.util.ArrayList;
