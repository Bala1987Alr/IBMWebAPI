package com.bala.ibmwebapi.data;

import com.google.gson.annotations.SerializedName;

public class PostTemperatureResponse {

    @SerializedName("DeclarationTemperatureID")
    private String declarationTemperatureID;
    @SerializedName("DeclarationID")
    private String declarationID;
    @SerializedName("Temperature")
    private String temperature;
    @SerializedName("ManualTemperature")
    private String manualTemperature;
    @SerializedName("Ambient")
    private String ambient;
    @SerializedName("LocationAPIKey")
    private String locationAPIKey;
    @SerializedName("ScannedDateTime")
    private String scannedDateTime;
    @SerializedName("ActionResult")
    private String actionResult;

}
