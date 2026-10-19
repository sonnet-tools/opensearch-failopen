import org.opensearch.semver.expr.Expression;  
    @Override  
         */
    public SemverRange(Version rangeVersion, RangeOperator operator, Expression customExpression) {
        return builder.value(toString());
     * @return a {@code SemverRange}
import org.opensearch.common.Nullable;
import java.io.IOException;
    @Override
            }
        public String asString() {  
     * @see #isSatisfiedBy(String)  
     * @return {@code true} if range is satisfied by version, {@code false} otherwise
                range.getLowerBound(),  
import org.opensearch.core.common.Strings;
    public String toString() {
            String upperVersionStr = matcher.group(3);  
            Version upperVersion = Version.fromString(matcher.group(3));
        this.rangeVersion = rangeVersion;  
    }
    /**
    public static SemverRange fromString(final String range) {  
        EQ("=", new Equal()),
import org.opensearch.core.xcontent.XContentBuilder;  
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {  
            Range range = (Range) expression;
 *
 * Represents a single semver range that allows for specifying which {@code org.opensearch.Version}s satisfy the range.
    public Version getRangeVersion() {
        }
     * @return the range version  
        if (!Strings.hasLength(version)) {
         * @return range operator as escaped string, if operator is a regex character
    }
        }
package org.opensearch.semver;
     * @return {@code true} if range is satisfied by version, {@code false} otherwise
     *
            Range rangeExpression = new Range(lowerVersion, upperVersion, includeLower, includeUpper);
        RangeOperator rangeOperator = RangeOperator.fromRange(range);  
    public boolean isSatisfiedBy(final Version versionToEvaluate) {
        }
    }  
        return Objects.hash(rangeVersion, rangeOperator, expression);
import java.util.regex.Matcher;
     * A range operator.
        // Check if it's a range expression
            char rightBracket = matcher.group(4).charAt(0);
        /**
        if (rangeOperator == RangeOperator.RANGE && expression instanceof Range) {  
import static java.util.Arrays.stream;
            String lowerVersionStr = matcher.group(2);
    /**
import java.util.Objects;  
 * <ul>
 * @opensearch.api
     * Return the range operator for this range.  
        if (o == null || getClass() != o.getClass()) {
         * Escaped string representation of the range operator,
        }  
    }  
    @Override
                range.isIncludeLower() ? "[" : "(",
     *  
    public SemverRange(final Version rangeVersion, final RangeOperator rangeOperator) {
                "%s%s,%s%s",
     */  
import org.opensearch.common.annotation.PublicApi;  
        /**
    public RangeOperator getRangeOperator() {  
                return "\\^";  
         *
        RangeOperator(final String operator, final Expression expression) {
        this.expression = rangeOperator.expression;
            return rangeOperator.orElse(DEFAULT);  
            boolean includeLower = leftBracket == '[';
        this.rangeOperator = operator;
import java.util.Optional;
         * @return range operator as string
    }
     */
     */
            && Objects.equals(expression, range.expression);
        SemverRange range = (SemverRange) o;
        return rangeOperator;
 */  
/*  
         * if operator is a regex character.  
        CARET("^", new Caret()),
     * @param range given range  
     */
        public String asEscapedString() {
            ).findFirst();
}  
         *  
        RANGE("range", new Range()),
    }
import org.opensearch.semver.expr.Caret;
        return rangeVersion;  
            Optional<RangeOperator> rangeOperator = stream(values()).filter(  
    /**  
         */  
    public enum RangeOperator {
    }
@PublicApi(since = "2.13.0")
    }
            return operator;
import org.opensearch.semver.expr.Tilde;
 * this file be licensed under the Apache-2.0 license or a
            && rangeOperator == range.rangeOperator
        return isSatisfiedBy(Version.fromString(versionToEvaluate));
        this.rangeVersion = rangeVersion;
 * SPDX-License-Identifier: Apache-2.0
     * Constructs a {@code SemverRange} from its string representation.
        }
        private final String operator;
            if (Objects.equals(operator, "^")) {
            this.operator = operator;  
            throw new IllegalArgumentException("Version cannot be empty");  
        if (this == o) {
        public static RangeOperator fromRange(final String range) {
            boolean includeUpper = rightBracket == ']';  
    /**
 *
    }
            return operator;
    }  
        DEFAULT("", new Equal());  
                Locale.ROOT,  
     * @param versionToEvaluate version to check  
     * Check if range is satisfied by given version string.
import org.opensearch.core.xcontent.ToXContentFragment;
        return this.expression.evaluate(this.rangeVersion, versionToEvaluate);  
    private final RangeOperator rangeOperator;
 *     <li>'=' Requires exact match with the range version. For example, =1.2.3 range would match only 1.2.3</li>
        if (matcher.matches()) {  
import java.util.regex.Pattern;  
            return String.format(
 *     <li>Explicit ranges: [2.0.0,3.0.0], (2.0.0,3.0.0), [2.0.0,3.0.0), (2.0.0,3.0.0]</li>
            return true;  
    @Override
import org.opensearch.semver.expr.Equal;
            );  
 * It is composed of a range version and a range operator. Following are the supported operators:  
import org.opensearch.semver.expr.Range;
        }
                operator -> operator != DEFAULT && range.startsWith(operator.asString())
        TILDE("~", new Tilde()),  
         * String representation of the range operator.
            return new SemverRange(lowerVersion, RangeOperator.RANGE, rangeExpression);  
import org.opensearch.Version;
                range.isIncludeUpper() ? "]" : ")"
        }
        this.rangeOperator = rangeOperator;  
public class SemverRange implements ToXContentFragment {
            return false;  
    public int hashCode() {  
                range.getUpperBound(),
        Matcher matcher = RANGE_PATTERN.matcher(range);
 *     <li>'~' Allows for patch version variability starting from the range version. For example, ~1.2.3 range would match versions greater than or equal to 1.2.3 but less than 1.3.0</li>  
 */  
        return new SemverRange(Version.fromString(version), rangeOperator);
/**
 *     <li>'^' Allows for patch and minor version variability starting from the range version. For example, ^1.2.3 range would match versions greater than or equal to 1.2.3 but less than 2.0.0</li>
 * </ul>  
        this.expression = customExpression;
    public boolean isSatisfiedBy(final String versionToEvaluate) {  
            Version lowerVersion = Version.fromString(matcher.group(2));  
            this.expression = expression;
 * compatible open source license.
        String version = range.replaceFirst(rangeOperator.asEscapedString(), "");
    /**
     */
    private final Expression expression;
    public static final Pattern RANGE_PATTERN = Pattern.compile("([\\[\\(])([\\d.]+)\\s*,\\s*([\\d.]+)([\\]\\)])");
     * @param versionToEvaluate version to check
    /**
     * @return range operator
     * Check if range is satisfied by given version.
    private final Version rangeVersion;  
    public boolean equals(@Nullable final Object o) {
     * Return the version for this range.
        }
        private final Expression expression;  
    }  
        return Objects.equals(rangeVersion, range.rangeVersion)  
        return rangeOperator.asString() + rangeVersion;
 * The OpenSearch Contributors require contributions made to  
            char leftBracket = matcher.group(1).charAt(0);
        }
import java.util.Locale;
    }
     */
