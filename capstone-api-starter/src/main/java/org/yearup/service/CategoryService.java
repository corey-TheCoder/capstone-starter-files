package org.yearup.service;

import org.springframework.stereotype.Service;
import org.yearup.models.Category;
import org.yearup.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService
{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll()
    {
        // get all categories
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    public Category getById(int categoryId)
    {
        // get category by id
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public Category create(Category category)
    {
        // create a new category
        category.setCategoryId(0);
        return categoryRepository.save(category);
    }

    public Category update(int categoryId, Category category)
    {
        // update category and return the updated category
        Category updating = categoryRepository.findById(categoryId).orElseThrow();
        updating.setName(category.getName());
        updating.setDescription(category.getDescription());
        return categoryRepository.save(updating);
    }

    public void delete(int categoryId)
    {
        // delete category
        categoryRepository.deleteById(categoryId);
    }
}
