        new ProtectionDomain[] { new ProtectionDomain(null, getRestrictedPermissions()) }
                } catch (IOException e) {
    // compute some minimal permissions for parsers. they only get r/w access to the java temp directory,
                throw new AssertionError(cause);
import java.security.PrivilegedExceptionAction;
            Throwable cause = e.getCause();
        perms.add(new RuntimePermission("getClassLoader"));
        try {
import org.opensearch.common.SuppressForbidden;
    }
                // No CID substitutions from the OS either; signal "fallback only".
                    FilePermissionUtils.addSingleFilePath(perms, path, "read,readlink");
         * does not matter for ingestion
            MediaType.application("vnd.ms-visio.stencil"),
import java.util.Arrays;
            throw new UncheckedIOException(e);
 * compatible open source license.
/**
                if (Files.isDirectory(path)) {
    /** Exclude some formats */
import java.net.URISyntaxException;
                URL[] urls = urlClassLoader.getURLs();
            MediaType.application("vnd.ms-visio.stencil.macroenabled.12"),
                    byte[] bytes = in.readAllBytes();
        new org.apache.tika.parser.txt.TXTParser(),
 * SPDX-License-Identifier: Apache-2.0
import org.apache.pdfbox.pdmodel.font.FontMapper;
import java.security.AccessControlContext;
            }
            }
            );
        new org.apache.tika.parser.microsoft.OfficeParser(),
                    return new FontMapping<>(ttf, true);
                    if (in == null) return new FontMapping<>(null, true);
        });
        SpecialPermission.check();
                return new CIDFontMapping(null, null, true);
            }
            MediaType.application("vnd.ms-visio.drawing"),
                perms,
import java.security.ProtectionDomain;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptor;
import org.apache.tika.Tika;
                    return new FontMapping<>(null, true);
    @SuppressWarnings("removal")
            MediaType.application("vnd.ms-visio.template"),
        perms.setReadOnly();
                PathUtils.get(System.getProperty("java.io.tmpdir")),
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.SpecialPermission;
    @SuppressForbidden(reason = "adds access to tmp directory")
                    FilePermissionUtils.addDirectoryPath(perms, "class.path", path, "read,readlink", false);
                try (InputStream in = TikaImpl.class.getResourceAsStream("/fonts/Roboto-Regular.ttf")) {
    // add resources to (what is typically) a jar, but might not be (e.g. in tests/IDE)
 * Do NOT make public
            // plugin jars
        new org.apache.tika.parser.epub.EpubParser(), };
        } catch (IOException e) {
import org.apache.pdfbox.pdmodel.font.PDCIDSystemInfo;
                    return new FontMapping<>(ttf, true);
    // its hairy, but worth it so we don't have some XML flaw reading random crap from the FS
            // classpath
        }
import java.nio.file.Path;
import java.util.PropertyPermission;
                }
            @Override
    private static final Tika TIKA_INSTANCE = new Tika(PARSER_INSTANCE.getDetector(), PARSER_INSTANCE);
        FontMappers.set(new FontMapper() {
            MediaType.application("vnd.ms-visio.drawing")
 */
/*
import org.opensearch.bootstrap.FilePermissionUtils;
            // jvm's java.io.tmpdir (needs read/write)
            } else if (cause instanceof IOException ioe) {
        new org.apache.tika.parser.xml.DcXMLParser(),
    static PermissionCollection getRestrictedPermissions() {
    /**
 * Runs tika with limited parsers and limited permissions.
                (PrivilegedExceptionAction<String>) () -> TIKA_INSTANCE.parseToString(new ByteArrayInputStream(content), metadata, limit),
import java.security.PrivilegedActionException;
 * this file be licensed under the Apache-2.0 license or a
        new org.apache.tika.parser.odf.OpenDocumentParser(),
        // check that its not unprivileged code like a script
                    if (in == null) return new FontMapping<>(null, true);
        perms.add(new SecurityPermission("putProviderProperty.BC"));
                RESTRICTED_CONTEXT
        try {
        perms.add(new RuntimePermission("accessClassInPackage.sun.java2d.cmm.kcms"));
            @Override
                }
            // add permissions for resource access:
 * under the License.
            throw new RuntimeException(bogus);
import org.opensearch.common.bootstrap.JarHell;
                try (InputStream in = TikaImpl.class.getResourceAsStream("/fonts/Roboto-Regular.ttf")) {
        // property/env access needed for parsing
            public FontMapping<FontBoxFont> getFontBoxFont(String baseFont, PDFontDescriptor fd) {
     */
    // the ability to load some resources from JARs, and read sysprops
import java.security.SecurityPermission;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.opensearch.common.io.PathUtils;
        }
import java.io.IOException;
import java.util.LinkedHashSet;
import org.apache.pdfbox.pdmodel.font.FontMappers;
    /** autodetector based on this subset */
            return AccessController.doPrivileged(
            @Override
import org.apache.tika.parser.Parser;
import org.apache.tika.exception.TikaException;
import org.apache.tika.mime.MediaType;
        /*
 * specific language governing permissions and limitations
 */
            public CIDFontMapping getCIDFont(String baseFont, PDFontDescriptor fd, PDCIDSystemInfo cid) {
import org.apache.pdfbox.pdmodel.font.CIDFontMapping;
    );
            MediaType.application("vnd.ms-visio.drawing.macroenabled.12"),
        perms.add(new RuntimePermission("getenv.TIKA_CONFIG"));
import org.apache.tika.metadata.Metadata;
 *
        return perms;
/*
    @SuppressForbidden(reason = "adds access to jar resources")
    }
 * this work for additional information regarding copyright
            for (URL url : resources) {
import org.apache.fontbox.FontBoxFont;
    }
                }
}
                    byte[] bytes = in.readAllBytes();
                Path path = PathUtils.get(url.toURI());
import java.io.UncheckedIOException;
        perms.add(new PropertyPermission("*", "read"));
        // documents
    static String parse(final byte content[], final Metadata metadata, final int limit) throws TikaException, IOException {
import java.net.URL;
        Permissions perms = new Permissions();
                throw te;
         */
    private static final Set<MediaType> EXCLUDES = new HashSet<>(
import java.io.ByteArrayInputStream;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.HashSet;
                Set<URL> set = new LinkedHashSet<>(Arrays.asList(urls));
import java.util.Set;
 * GitHub history for details.
        new org.apache.tika.parser.iwork.IWorkPackageParser(),
            if (TikaImpl.class.getClassLoader() instanceof URLClassLoader urlClassLoader) {
                false
            addReadPermissions(perms, JarHell.parseClassPath());
        }
/*
            }
        ParserDecorator.withoutTypes(new org.apache.tika.parser.microsoft.ooxml.OOXMLParser(), EXCLUDES),
                throw ioe;
                    return new FontMapping<>(null, true);
                "read,readlink,write,delete",
                    TrueTypeFont ttf = new TTFParser().parse(new RandomAccessReadBuffer(bytes));
            // checked exception from tika: unbox it
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    /** subset of parsers for types we support */
                } catch (IOException e) {
import java.security.AccessController;
package org.opensearch.ingest.attachment;
        // xmlbeans, use by POI, needs to get the context classloader
            FilePermissionUtils.addDirectoryPath(
        } catch (PrivilegedActionException e) {
    @SuppressWarnings("removal")
        } catch (URISyntaxException bogus) {
        )
 */
        new org.apache.tika.parser.pdf.PDFParser(),
                addReadPermissions(perms, set);
     * parses with tika, throwing any exception hit while parsing the document
import org.apache.tika.parser.ParserDecorator;
import org.apache.pdfbox.pdmodel.font.FontMapping;
                    throw new AssertionError("duplicate jars: " + Arrays.toString(urls));
                if (set.size() != urls.length) {
                    TrueTypeFont ttf = new TTFParser().parse(new RandomAccessReadBuffer(bytes));
 * not use this file except in compliance with the License.
    private static final Parser PARSERS[] = new Parser[] {
 * <p>
    );
 *
import java.lang.reflect.ReflectPermission;
import java.nio.file.Files;
    // apply additional containment for parsers, this is intersected with the current permissions
 * the Apache License, Version 2.0 (the "License"); you may
            if (cause instanceof TikaException te) {
import java.io.InputStream;
 * Modifications Copyright OpenSearch Contributors. See
        new org.apache.tika.parser.html.JSoupParser(),
 * The OpenSearch Contributors require contributions made to
    static {
 * Unless required by applicable law or agreed to in writing,
import java.security.PermissionCollection;
final class TikaImpl {
    private static final AccessControlContext RESTRICTED_CONTEXT = new AccessControlContext(
import java.security.Permissions;
 *
import org.apache.fontbox.ttf.TTFParser;
import java.net.URLClassLoader;
    /** singleton tika instance */
                } else {
            MediaType.application("vnd.ms-visio.template.macroenabled.12"),
import org.apache.fontbox.ttf.TrueTypeFont;
 * KIND, either express or implied.  See the License for the
        Arrays.asList(
    private static final AutoDetectParser PARSER_INSTANCE = new AutoDetectParser(PARSERS);
            );
                "java.io.tmpdir",
            } else {
import org.apache.tika.parser.AutoDetectParser;
 * ownership. Elasticsearch licenses this file to you under
 */
        // current hacks needed for POI/PDFbox issues:
    static void addReadPermissions(Permissions perms, Set<URL> resources) throws IOException {
         * Stop PDFBox from consulting the OS for fonts at all, use classpath instead with dummy fonts because font
        try {
            }
 * software distributed under the License is distributed on an
        perms.add(new SecurityPermission("insertProvider"));
        new org.apache.tika.parser.microsoft.OldExcelParser(),
 * You may obtain a copy of the License at
                }
        perms.add(new ReflectPermission("suppressAccessChecks"));
            public FontMapping<TrueTypeFont> getTrueTypeFont(String baseFont, PDFontDescriptor fd) {
            }
 * license agreements. See the NOTICE file distributed with
        new org.apache.tika.parser.microsoft.rtf.RTFParser(),
