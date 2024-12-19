package com.example.restapi.api.response;

import com.example.restapi.business.dto.PostListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@AllArgsConstructor
public class PostListResponse {

    private Page<PostListDto> posts;

}
