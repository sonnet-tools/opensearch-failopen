    @Override
        // Check if it's a range expression
        if (this == o) {
        }
    public static final Pattern RANGE_PATTERN = Pattern.compile("([\\[\\(])([\\d.]+)\\s*,\\s*([\\d.]+)([\\]\\)])");
        return rangeOperator.asString() + rangeVersion;
     */
            this.expression = expression;
    /**
 */
import java.io.IOException;
            char leftBracket = matcher.group(1).charAt(0);
        private final Expression expression;
            this.operator = operator;
            String upperVersionStr = matcher.group(3);
 * Represents a single semver range that allows for specifying which {@code org.opensearch.Version}s satisfy the range.
     */
     * Return the version for this range.
        return rangeOperator;
        Matcher matcher = RANGE_PATTERN.matcher(range);
                range.getLowerBound(),
            char rightBracket = matcher.group(4).charAt(0);
        this.rangeVersion = rangeVersion;
     * @return the range version
            String lowerVersionStr = matcher.group(2);
        }
        EQ("=", new Equal()),
        public String asString() {
        DEFAULT("", new Equal());
 * this file be licensed under the Apache-2.0 license or a
    }
            boolean includeUpper = rightBracket == ']';
     *
    public enum RangeOperator {
 *     <li>'~' Allows for patch version variability starting from the range version. For example, ~1.2.3 range would match versions greater than or equal to 1.2.3 but less than 1.3.0</li>
 * compatible open source license.
         */
 */
         */
    /**
    }
        this.rangeVersion = rangeVersion;
     * Check if range is satisfied by given version string.
     * @return range operator
         *
    private final Expression expression;
            return rangeOperator.orElse(DEFAULT);
    }
        CARET("^", new Caret()),
    private final Version rangeVersion;
import java.util.Optional;
 *     <li>Explicit ranges: [2.0.0,3.0.0], (2.0.0,3.0.0), [2.0.0,3.0.0), (2.0.0,3.0.0]</li>
    /**
import org.opensearch.common.annotation.PublicApi;
        RangeOperator rangeOperator = RangeOperator.fromRange(range);
            return operator;
            ).findFirst();
     * @see #isSatisfiedBy(String)
            return false;
@PublicApi(since = "2.13.0")
import java.util.regex.Pattern;
     */
            && rangeOperator == range.rangeOperator
import org.opensearch.core.common.Strings;
import java.util.regex.Matcher;
import static java.util.Arrays.stream;
        return builder.value(toString());
import org.opensearch.semver.expr.Range;
        this.rangeOperator = operator;
     * Constructs a {@code SemverRange} from its string representation.
        }
                range.isIncludeLower() ? "[" : "(",
        }
         * @return range operator as escaped string, if operator is a regex character
import java.util.Objects;
        RANGE("range", new Range()),
     * Return the range operator for this range.
         * @return range operator as string
         * if operator is a regex character.
            return true;
            return new SemverRange(lowerVersion, RangeOperator.RANGE, rangeExpression);
    }
         * Escaped string representation of the range operator,
    }
        RangeOperator(final String operator, final Expression expression) {
    @Override
    /**
/**
            return String.format(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.semver.expr.Expression;
 * The OpenSearch Contributors require contributions made to
        TILDE("~", new Tilde()),
     * A range operator.
        this.expression = customExpression;
                return "\\^";
    public static SemverRange fromString(final String range) {
            && Objects.equals(expression, range.expression);
        /**
        return Objects.hash(rangeVersion, rangeOperator, expression);
public class SemverRange implements ToXContentFragment {
     *
        }
 *     <li>'=' Requires exact match with the range version. For example, =1.2.3 range would match only 1.2.3</li>
 * <ul>
    public String toString() {
    private final RangeOperator rangeOperator;
    @Override
}
    public int hashCode() {
    public SemverRange(final Version rangeVersion, final RangeOperator rangeOperator) {
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
    @Override
        String version = range.replaceFirst(rangeOperator.asEscapedString(), "");
/*
    public boolean equals(@Nullable final Object o) {
    }
            Range range = (Range) expression;
        }
    public boolean isSatisfiedBy(final Version versionToEvaluate) {
     */
import org.opensearch.core.xcontent.ToXContentFragment;
    /**
        if (rangeOperator == RangeOperator.RANGE && expression instanceof Range) {
     * @param versionToEvaluate version to check
    public RangeOperator getRangeOperator() {
         * String representation of the range operator.
     * @param range given range
import org.opensearch.semver.expr.Equal;
 * @opensearch.api
        return Objects.equals(rangeVersion, range.rangeVersion)
import org.opensearch.core.xcontent.XContentBuilder;
        if (matcher.matches()) {
    }
import org.opensearch.semver.expr.Tilde;
            );
        }
        return new SemverRange(Version.fromString(version), rangeOperator);
     * Check if range is satisfied by given version.
                "%s%s,%s%s",
        private final String operator;
        if (!Strings.hasLength(version)) {
    public SemverRange(Version rangeVersion, RangeOperator operator, Expression customExpression) {
    }
    }
            Version upperVersion = Version.fromString(matcher.group(3));
            throw new IllegalArgumentException("Version cannot be empty");
        public static RangeOperator fromRange(final String range) {
                operator -> operator != DEFAULT && range.startsWith(operator.asString())
     */
        return isSatisfiedBy(Version.fromString(versionToEvaluate));
        }
            return operator;
     * @return {@code true} if range is satisfied by version, {@code false} otherwise
        SemverRange range = (SemverRange) o;
        this.expression = rangeOperator.expression;
                Locale.ROOT,
        return this.expression.evaluate(this.rangeVersion, versionToEvaluate);
     * @return a {@code SemverRange}
 * </ul>
    }
            Range rangeExpression = new Range(lowerVersion, upperVersion, includeLower, includeUpper);
            }
     * @return {@code true} if range is satisfied by version, {@code false} otherwise
            Version lowerVersion = Version.fromString(matcher.group(2));
            boolean includeLower = leftBracket == '[';
    public Version getRangeVersion() {
    public boolean isSatisfiedBy(final String versionToEvaluate) {
        public String asEscapedString() {
    }
import java.util.Locale;
 *
    /**
     */
        return rangeVersion;
import org.opensearch.semver.expr.Caret;
import org.opensearch.Version;
                range.isIncludeUpper() ? "]" : ")"
import org.opensearch.common.Nullable;
        /**
        if (o == null || getClass() != o.getClass()) {
    }
        this.rangeOperator = rangeOperator;
        }
 * It is composed of a range version and a range operator. Following are the supported operators:
         *
 *     <li>'^' Allows for patch and minor version variability starting from the range version. For example, ^1.2.3 range would match versions greater than or equal to 1.2.3 but less than 2.0.0</li>
            Optional<RangeOperator> rangeOperator = stream(values()).filter(
 *
package org.opensearch.semver;
            if (Objects.equals(operator, "^")) {
                range.getUpperBound(),
     * @param versionToEvaluate version to check
