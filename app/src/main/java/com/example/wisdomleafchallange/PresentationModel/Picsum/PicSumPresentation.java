package com.example.wisdomleafchallange.PresentationModel.Picsum;

import java.util.List;

public class PicSumPresentation {

    private List<PicSumDataModel> ResponseData;

    public PicSumPresentation(List<PicSumDataModel> responseData) {
        ResponseData = responseData;
    }

    public PicSumPresentation() {
    }

    public List<PicSumDataModel> getResponseData() {
        return ResponseData;
    }

    public void setResponseData(List<PicSumDataModel> responseData) {
        ResponseData = responseData;
    }
}
