 */
                    clazz.getName(),
    @Override
import java.io.InputStreamReader;
                            line = line.substring(0, pos);
                        line = line.trim();
 *  
     * This means the child will be able to load all classes from the parent, too.  
 * See the License for the specific language governing permissions and  
        }
    /** Creates a new SPI iterator to lookup services of type {@code clazz} using the given classloader. */
        // hasNext() implicitely loads the next profile, so it is essential to call this here!
            if (lines != null) {
        final String c = linesIterator.next();
    public static <S> SPIClassIterator<S> get(Class<S> clazz, ClassLoader loader) {  
                        IOUtils.closeWhileHandlingException(in);
        } catch (SecurityException se) {  
        }  
 */  
            final String fullName = META_INF_SERVICES + clazz.getName();  
import java.util.Objects;
 * SPDX-License-Identifier: Apache-2.0
    }  
        this.clazz = Objects.requireNonNull(clazz, "clazz");  
    }
import java.util.ArrayList;
        return new SPIClassIterator<>(clazz, Objects.requireNonNull(clazz.getClassLoader(), () -> clazz + " has no classloader."));
 * Helper class for loading SPI classes from classpath (META-INF files).  
 */
            }
    public boolean hasNext() {
    }  
/**
            return false;
import java.util.Enumeration;
                    } else {
            } catch (IOException ioe) {
                        final int pos = line.indexOf('#');  
     * (this is fine, because if we get a {@code SecurityException} it is for sure no parent).  
    private static final String META_INF_SERVICES = "META-INF/services/";
        try {
    }
                    "An SPI class of type %s with classname %s does not exist, " + "please fix the file '%s%1$s' in your classpath.",  
                )
     * If caller's codesource doesn't have enough permissions to do the check, {@code false} is returned
                }
 * distributed under the License is distributed on an "AS IS" BASIS,
public final class SPIClassIterator<S> implements Iterator<Class<? extends S>> {  
    /**
 * the License.  You may obtain a copy of the License at
            // don't initialize the class (pass false as 2nd parameter):  
    }
 * compatible open source license.
    @Override  
                lines.clear();  
     * <p>
        this.linesIterator = Collections.<String>emptySet().iterator();
            throw new ServiceConfigurationError("Error loading SPI profiles for type " + clazz.getName() + " from classpath", ioe);  
    /** Creates a new SPI iterator to lookup services of type {@code clazz} using
                return true;
                            lines.add(line);  
    private Iterator<String> linesIterator;  
@SuppressForbidden(reason = "Taken from Lucene")
        try {  
 * this work for additional information regarding copyright ownership.
    public Class<? extends S> next() {
    }  
/*  
                    c,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
                    }  
        return false;
            ClassLoader cl = child;
        }  
     * the same {@link ClassLoader} as the argument. */  
                if (cl == parent) {  
    public static <S> SPIClassIterator<S> get(Class<S> clazz) {
            }
            this.profilesEnum = loader.getResources(fullName);
        return new SPIClassIterator<>(clazz, loader);
            while (cl != null) {
 * Unless required by applicable law or agreed to in writing, software  
 * this file be licensed under the Apache-2.0 license or a
 *
        try {
 *     http://www.apache.org/licenses/LICENSE-2.0
        ArrayList<String> lines = null;  
import java.io.InputStream;
            throw new NoSuchElementException();
 * Licensed to the Apache Software Foundation (ASF) under one or more  
                    success = true;  
                    while ((line = reader.readLine()) != null) {
                    if (success) {
 * Modifications Copyright OpenSearch Contributors. See
    private final Class<S> clazz;  
            throw new ServiceConfigurationError(  
    }  
 *
                final InputStream in = url.openStream();  
 * The OpenSearch Contributors require contributions made to  
        this.loader = Objects.requireNonNull(loader, "loader");
        }
        assert linesIterator.hasNext();  
            } else {
     * Utility method to check if some class loader is a (grand-)parent of or the same as another one.
                    }
import java.net.URL;  
                        if (pos >= 0) {
        }
/*
            }  
    @Override  
     */
                String.format(
                    String line;
    private SPIClassIterator(Class<S> clazz, ClassLoader loader) {
                    META_INF_SERVICES  
 * This is a light impl of {@link java.util.ServiceLoader} but is guaranteed to
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
 * be bug-free regarding classpath order and does not instantiate or initialize
        return linesIterator.hasNext() || loadNextProfile();  
                    Locale.ROOT,
    private boolean loadNextProfile() {
                lines = new ArrayList<>();
 * the classes found.  
                this.linesIterator = lines.iterator();  
                }
package org.opensearch.lucene.util;  
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;  
    private final ClassLoader loader;
            if (lines.isEmpty() == false) {
                        }
            final URL url = profilesEnum.nextElement();
    public static boolean isParentClassLoader(final ClassLoader parent, final ClassLoader child) {
                        IOUtils.close(in);  
}
                } finally {
 */
import org.apache.lucene.util.IOUtils;
 * (the "License"); you may not use this file except in compliance with
                        if (line.length() > 0) {
            }
                try {
        } catch (ClassNotFoundException cnfe) {
        while (profilesEnum.hasMoreElements()) {
 * The ASF licenses this file to You under the Apache License, Version 2.0  
                cl = cl.getParent();  
                    return true;
        if (hasNext() == false) {  
/* @notice
    public void remove() {
            );
        } catch (IOException ioe) {
import java.util.Collections;  
            return false;
                throw new ServiceConfigurationError("Error loading SPI class list from URL: " + url, ioe);  
 * limitations under the License.
            return Class.forName(c, false, loader).asSubclass(clazz);
import java.io.IOException;  
    private final Enumeration<URL> profilesEnum;
            try {
import org.apache.lucene.util.SuppressForbidden;  
import java.util.Locale;  
 * contributor license agreements.  See the NOTICE file distributed with
 * GitHub history for details.  
                boolean success = false;
                        }  
        throw new UnsupportedOperationException();
import java.util.Iterator;
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));  
    }
