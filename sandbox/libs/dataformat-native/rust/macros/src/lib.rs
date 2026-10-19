 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
//! #[no_mangle]
//! #[ffm_safe]
    let fn_name = input.sig.ident.to_string();
                #fn_name,
//!
}
use quote::quote;
 *
 */
//!     do_work(arg).map_err(|e| e.to_string())
        #vis #sig {
#[proc_macro_attribute]
    let vis = &input.vis;
    let expanded = quote! {
//!
//! the message, then `native_error_free(-result)` to free it.
//! negative pointer (negated `Box::into_raw` address).
    let sig = &input.sig;
//! Wraps an `extern "C"` function body with `catch_unwind`. The body must
    let body = &input.block;
//!
//! On `Err` or panic, the error message is heap-allocated and returned as a
            )
    let attrs = &input.attrs;
/*
//! return `Result<i64, String>`. On success the `i64` is returned directly.
        #(#attrs)*
        }
    };
                    || -> ::std::result::Result<i64, ::std::string::String> #body
//! # Usage
            native_bridge_common::error::ffm_wrap(
    expanded.into()
pub fn ffm_safe(_attr: TokenStream, item: TokenStream) -> TokenStream {
//! ```ignore
 * this file be licensed under the Apache-2.0 license or a
//! ```
use proc_macro::TokenStream;
//!
use syn::{parse_macro_input, ItemFn};
//! pub unsafe extern "C" fn my_func(arg: i64) -> i64 {
//! Java checks: if result < 0, call `native_error_message(-result)` to get
                ::std::panic::AssertUnwindSafe(
                ),
 * SPDX-License-Identifier: Apache-2.0
//! Proc macro for FFM bridge functions.
    let input = parse_macro_input!(item as ItemFn);
//! }
