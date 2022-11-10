package com.example.wisdomleafchallange.WebServiceApi;

import com.example.wisdomleafchallange.PresentationModel.Picsum.PicSumPresentation;
import com.example.wisdomleafchallange.Util.Constants;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;

public interface WisdomApiInterface {

    @GET(Constants.URI)
    void getPicSumData(@Query("page") int PageNo, @Query("limit") int limit, Callback<PicSumPresentation> callback);
}
