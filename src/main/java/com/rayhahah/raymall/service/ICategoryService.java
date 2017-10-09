package com.rayhahah.raymall.service;

import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.Category;

import java.util.List;

/**
 * Created by Rayhahah
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

}
