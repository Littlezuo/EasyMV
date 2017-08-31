package com.little.easymv.api;


import com.little.easymv.responsebean.RecommendResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

/**
 * Created by Administrator on 2017/2/13.
 */
//http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html
public interface ApiService {

    @Headers("Referer:http://images.dmzj.com/")
    @GET("recommend.json")
    Observable<List<RecommendResponse>> getRecommend();

    /* 用法:
     Observable<SimpleResponse<List<RecommendResponse>>> getRecommend();

    Api.getDefault(HostType.KaBu).getRecommend()
                .compose(RxHelper.<List<RecommendResponse>>handleErrTransformer())
            .subscribe(new BaseSubscriber<List<RecommendResponse>>() {
        @Override
        protected void _onNext(List<RecommendResponse> recommendResponses) {

        }
    }))*/





}

