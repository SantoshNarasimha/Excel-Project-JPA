package com.excel.project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Categories")
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "CategoryID")
    private String categoryId;

    @Column(name = "title")
    private String categoryName;

    @Column(name = "Category_desc")
    private String categoryDescription;

    @Column(name = "Cover_image")
    private String coverImage;
}
