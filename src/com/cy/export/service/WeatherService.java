package com.cy.export.service;

import com.alibaba.fastjson.JSON;
import com.cy.export.domain.Export;
import com.cy.export.domain.ExportProduct;

import javax.jws.WebMethod;
import java.util.Set;

public class WeatherService  {
    private ExportService exportService;
    public void setExportService(ExportService exportService) {
        this.exportService = exportService;
    }

    @WebMethod
    public String showWeater(String jsonStr){
        System.out.print("雨夹雪");
        Export export = JSON.parseObject(jsonStr, Export.class);

        System.out.println(export.getDestinationPort()+","+export.getProducts().iterator().next().getCnumber());

        exportService.saveOrUpdate(export);

        StringBuffer sb = new StringBuffer();
        sb.append("{exportId:\"").append(export.getExportId()).append("\",");
        sb.append("state:\"").append(2).append("\",");
        sb.append("remark:\"").append("申报成功").append("\",");
        sb.append("products:[");
        Set<ExportProduct> exportSet = export.getProducts();
        double i=1;
        for(ExportProduct ep :exportSet){
            sb.append("{exportProductId:\"").append(ep.getExportProductId()).append("\",");
            sb.append("tax:\"").append(10+(i++)*0.4).append("\"},");
        }
        sb.delete(sb.length()-1, sb.length());
        sb.append("]}");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
