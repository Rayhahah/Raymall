package com.rayhahah.raymall.service;

import com.github.pagehelper.PageInfo;
import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.pojo.Product;
import com.rayhahah.raymall.vo.ProductDetailVo;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/8/30
 * @tips 这个类是Object的子类
 * @fuction
 */
public interface IProductService {

    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);



}
