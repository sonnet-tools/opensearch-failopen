        );  
import java.util.List;
            case 2:
                break;  
            randomAlphaOfLengthBetween(0, 3) + (randomBoolean() ? ".*?" : "." + randomAlphaOfLength(4)) + randomAlphaOfLengthBetween(0, 5),
            case 0:
            parser.nextToken();  
/*  
            randomBoolean() ? RegexpFlag.resolveValue(randomFrom(FLAGS)) : RegexpFlag.ALL.value(),
        switch (ran) {  
        return createRandomRegexp();
    }
    @Override
    @Override  
    }  
}  
        assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
        Regexp regexp = (Regexp) fromXContent(parser);
    static Regexp createRandomRegexp() {
 */  
        boolean caseInsensitive = instance.isCaseInsensitive();  
    protected Writeable.Reader<Regexp> instanceReader() {
import static org.opensearch.index.query.IntervalsSourceProvider.Regexp;  
        return new Regexp(  
        int ran = between(0, 4);
    protected Regexp createTestInstance() {
import org.opensearch.core.xcontent.XContentParser;
        if (parser.nextToken() == XContentParser.Token.START_OBJECT) {
                break;  
import org.opensearch.test.AbstractSerializingTestCase;  
                break;  
                useField = useField == null ? randomAlphaOfLength(5) : null;
    @Override  
        String useField = instance.getUseField();
            randomBoolean() ? randomAlphaOfLength(10) : null,  
                caseInsensitive = !caseInsensitive;
 * compatible open source license.
        }  
    }
    }
    private static final List<String> FLAGS = Arrays.asList("INTERSECTION", "COMPLEMENT", "EMPTY", "ANYSTRING", "INTERVAL", "NONE");
        return new Regexp(pattern, flags, useField, maxExpansions, caseInsensitive);
public class RegexpIntervalsSourceProviderTests extends AbstractSerializingTestCase<Regexp> {  
            default:
        return Regexp::new;  
                throw new AssertionError("Illegal randomisation branch");
            case 4:
        }
                break;  
            randomBoolean() ? randomIntBetween(-1, Integer.MAX_VALUE) : null,
        return regexp;
    }
                pattern += randomBoolean() ? ".*?" : randomAlphaOfLength(5);
    protected Regexp doParseInstance(XContentParser parser) throws IOException {
            case 1:
package org.opensearch.index.query;
                break;  
        int flags = instance.getFlags();  
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.index.query.IntervalsSourceProvider.fromXContent;
 * The OpenSearch Contributors require contributions made to  
        String pattern = instance.getPattern();
            randomBoolean()
import java.io.IOException;
                flags = (flags == RegexpFlag.ALL.value()) ? RegexpFlag.resolveValue(randomFrom(FLAGS)) : RegexpFlag.ALL.value();
    @Override  
import java.util.Arrays;  
        Integer maxExpansions = instance.getMaxExpansions();
import org.opensearch.core.common.io.stream.Writeable;
            case 3:
 * SPDX-License-Identifier: Apache-2.0
                maxExpansions = maxExpansions == null ? randomIntBetween(1, Integer.MAX_VALUE) : null;
 *
    protected Regexp mutateInstance(Regexp instance) throws IOException {
