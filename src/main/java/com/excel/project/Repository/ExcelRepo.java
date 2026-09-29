package com.excel.project.Repository;

import com.excel.project.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcelRepo extends JpaRepository<Category, String> {
}
