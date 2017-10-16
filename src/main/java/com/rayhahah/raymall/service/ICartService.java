package com.rayhahah.raymall.service;


import com.rayhahah.raymall.common.ServerResponse;
import com.rayhahah.raymall.vo.CartVo;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/10/16
 * @tips 这个类是Object的子类
 * @fuction
 */
public interface ICartService {
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);
    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    ServerResponse<CartVo> list(Integer userId);
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);
    ServerResponse<Integer> getCartProductCount(Integer userId);
}
