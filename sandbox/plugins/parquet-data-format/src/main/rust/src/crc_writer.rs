        };
        self.inner.flush()
    }
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
/// Shared CRC32 handle that can be cloned and read independently of the writer.
/*
pub struct CrcHandle {
 * SPDX-License-Identifier: Apache-2.0
        let handle = CrcHandle {
/// The CRC can be read via a `CrcHandle` without consuming the writer.
    pub fn new(inner: W) -> (Self, CrcHandle) {
    hasher: Arc<Mutex<crc32fast::Hasher>>,
    pub fn crc32(&self) -> u32 {
    }
    fn flush(&mut self) -> Result<()> {
 */
    hasher: Arc<Mutex<crc32fast::Hasher>>,
impl CrcHandle {
        self.hasher.lock().unwrap().update(&buf[..n]);
        let hasher = Arc::new(Mutex::new(crc32fast::Hasher::new()));
impl<W: Write> CrcWriter<W> {
/// A writer wrapper that computes CRC32 incrementally on every write.
    }
#[derive(Clone)]
use std::io::{Result, Write};
 * The OpenSearch Contributors require contributions made to
}
}
}
}
    fn write(&mut self, buf: &[u8]) -> Result<usize> {
impl<W: Write> Write for CrcWriter<W> {
            hasher: hasher.clone(),
        (Self { inner, hasher }, handle)
use std::sync::{Arc, Mutex};
        Ok(n)
    }
pub struct CrcWriter<W: Write> {
}
 *
        let n = self.inner.write(buf)?;
    inner: W,
        self.hasher.lock().unwrap().clone().finalize()
