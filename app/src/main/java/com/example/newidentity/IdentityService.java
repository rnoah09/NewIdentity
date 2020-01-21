package com.example.newidentity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IdentityService {

    String BASE_URL = "https://uinames.com/";

    @GET("api/?ext")
    Call<Identity> getIdentityByGender(@Query("g") String gender);
}
