package com.example.agriwise.data.model

import com.google.gson.annotations.SerializedName


data class CropRecommendationData (

    @SerializedName("N"           ) var n           : Double? = null,
    @SerializedName("P"           ) var p           : Double? = null,
    @SerializedName("K"           ) var k           : Double? = null,
    @SerializedName("temperature" ) var temperature : Double? = null,
    @SerializedName("humidity"    ) var humidity    : Double? = null,
    @SerializedName("ph"          ) var ph          : Double? = null,
    @SerializedName("rainfall"    ) var rainfall    : Double? = null
)