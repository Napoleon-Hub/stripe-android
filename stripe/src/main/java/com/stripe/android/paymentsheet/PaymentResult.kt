package com.stripe.android.paymentsheet

import android.os.Parcelable
import com.stripe.android.model.PaymentIntent
import kotlinx.android.parcel.Parcelize

internal sealed class PaymentResult : Parcelable {
    @Parcelize
    data class Succeeded(
        val paymentIntent: PaymentIntent
    ) : PaymentResult()

    @Parcelize
    data class Failed(
        val error: Throwable,
        val paymentIntent: PaymentIntent?
    ) : PaymentResult()

    @Parcelize
    data class Cancelled(
        val mostRecentError: Throwable?,
        val paymentIntent: PaymentIntent?
    ) : PaymentResult()
}
