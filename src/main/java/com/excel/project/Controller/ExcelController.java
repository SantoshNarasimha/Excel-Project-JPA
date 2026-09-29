package com.excel.project.Controller;

import com.excel.project.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @GetMapping("/excel")
    public ResponseEntity<byte[]> getExcel() throws IOException {
        byte[] excelBytes = excelService.generateExcel();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employees.xlsx")
                .body(excelBytes);
    }
}
