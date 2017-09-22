package com.rayhahah.raymall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Rayhahah
 * @blog http://rayhahah.com
 * @time 2017/9/22
 * @tips 这个类是Object的子类
 * @fuction
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
