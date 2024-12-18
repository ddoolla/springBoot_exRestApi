package com.axios.restapi.business;

import com.axios.restapi.business.dto.PostCreateDto;

public interface PostService {

    Long registerPost(PostCreateDto dto);
}
