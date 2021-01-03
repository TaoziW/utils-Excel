package com.wst.utils.service;

import cn.com.taiji.common.manager.net.http.binclient.ApiRequestException;
import cn.com.taiji.sdk.comm.ETCCommHelper;
import cn.com.taiji.sdk.model.comm.protocol.eoms.company.CompanyQueryRequest;
import cn.com.taiji.sdk.model.comm.protocol.eoms.company.CompanyQueryResponse;

import java.io.IOException;

public class TestCompany {

    public static void main(String[] args) {
        //(1)找到"企业查询"对应的协议模型（CompanyQueryRequest）
        CompanyQueryRequest req =new CompanyQueryRequest();
        req.setCompanyName("XXXX公司名称");
        req.setTaxpaterCode("12312312312312312");
        //(3)获取发送文件名
        String filename = req.getFilename();
        try {
            //(4)指定协议的响应模型（CompanyQueryResponse），调用upload 发送数据
			CompanyQueryResponse res = ETCCommHelper.upload(filename, req,          CompanyQueryResponse.class);
		    //(5)发送成功处理（这里为示例，简单的将响应模型转为json字符串输出，各自根据实际情况处理）
			System.out.println("发送成功，服务器返回："+res.toJson());
		} catch (ApiRequestException e) {
             //TODO 系统自定义异常处理，各自补全
             System.out.println("错误码："+e.getErrCode()+" 错误信息："+e.getMessage());
             e.printStackTrace();
		} catch (IOException e) {
            //TODO 网络异常处理,各自补全
			e.printStackTrace();
        }
    }

}
