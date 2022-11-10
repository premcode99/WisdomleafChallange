package com.example.wisdomleafchallange.WebServiceApi;

import com.example.wisdomleafchallange.PresentationModel.Picsum.PicSumDataModel;
import com.example.wisdomleafchallange.PresentationModel.Picsum.PicSumPresentation;
import com.example.wisdomleafchallange.Util.Constants;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface WisdomApiInterface {

    @GET(Constants.URI)
    void getPicSumData(@Query("page") int PageNo, @Query("limit") int limit, Callback<ArrayList<PicSumDataModel>> callback);
}
