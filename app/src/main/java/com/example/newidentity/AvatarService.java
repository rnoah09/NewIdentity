package com.example.newidentity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AvatarService {

    String BASE_URL = "https://avatars.dicebear.com/v2";

    @GET("/{gender}/{seed}.svg")
    Call<Identity> getIdentityByGender(@Path("gender") String gender, @Path("seed") String seed);
}
