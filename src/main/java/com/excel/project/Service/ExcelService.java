package com.excel.project.Service;

import com.excel.project.Entities.Category;
import com.excel.project.Repository.ExcelRepo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private ExcelRepo excelRepo;

    public byte[] generateExcel() throws IOException {
        List<Category> categories = excelRepo.findAll();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Mobile_Categories");
        Row headerrow = sheet.createRow(0);

        headerrow.createCell(0).setCellValue("CategoryID");
        headerrow.createCell(1).setCellValue("CategoryName");
        headerrow.createCell(2).setCellValue("Category Description");
        headerrow.createCell(3).setCellValue("CoverImage");

        int num = 1;
        for (Category mobiles : categories) {
            Row row = sheet.createRow(num);
            row.createCell(0).setCellValue(mobiles.getCategoryId());
            row.createCell(1).setCellValue(mobiles.getCategoryName());
            row.createCell(2).setCellValue(mobiles.getCategoryDescription());
            row.createCell(3).setCellValue(mobiles.getCoverImage());
            num++;
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        return outputStream.toByteArray();
    }
}
