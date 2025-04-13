package com.skripsi.spotato_app.response

import com.google.gson.annotations.SerializedName

data class PredictionResponse(

	@field:SerializedName("prediction")
	val prediction: Int? = null,

	@field:SerializedName("class_name")
	val className: String? = null
)
