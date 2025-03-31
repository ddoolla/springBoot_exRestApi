package com.example.restapi.business.post.dto;

import com.example.restapi.shared.util.PaginationUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostListDto {

    private List<PostDto> posts;
    private Long count;
    private PaginationUtil paginationUtil;

}
